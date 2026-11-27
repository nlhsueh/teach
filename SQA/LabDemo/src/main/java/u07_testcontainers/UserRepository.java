package u07_testcontainers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

/**
 * Unit 07 純 Java JDBC 資料存取層範例（不依賴 Spring Boot）
 *
 * 刻意使用 PostgreSQL 原生語法（JSONB、RETURNING id、ON CONFLICT DO UPDATE），
 * 示範為何傳統 H2 記憶體資料庫會產生「假綠燈幻覺」，而必須以 Testcontainers 真實容器進行整合測試！
 */
public class UserRepository {

    public record UserRecord(long id, String name, String email, String metadata) {}

    private final String jdbcUrl;
    private final String username;
    private final String password;

    // 建構子依賴注入 (Constructor DI)：由外部傳入真實資料庫或 Testcontainers 容器的連線資訊
    public UserRepository(String jdbcUrl, String username, String password) {
        this.jdbcUrl = jdbcUrl;
        this.username = username;
        this.password = password;
    }

    public Connection openConnection() throws SQLException {
        return DriverManager.getConnection(jdbcUrl, username, password);
    }

    /**
     * 建立 users 資料表（使用 PostgreSQL 原生 SERIAL、UNIQUE 約束與 JSONB 欄位）
     */
    public void initSchema() throws SQLException {
        String ddl = """
                CREATE TABLE IF NOT EXISTS users (
                    id SERIAL PRIMARY KEY,
                    name VARCHAR(100) NOT NULL,
                    email VARCHAR(120) UNIQUE NOT NULL,
                    metadata JSONB NOT NULL DEFAULT '{}'::jsonb
                )
                """;
        try (Connection conn = openConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(ddl);
        }
    }

    /**
     * 新增使用者並回傳自動產生的主鍵（使用 PostgreSQL 原生 CAST(? AS jsonb) 與 RETURNING id）
     */
    public long save(String name, String email, String metadataJson) throws SQLException {
        String sql = "INSERT INTO users (name, email, metadata) VALUES (?, ?, CAST(? AS jsonb)) RETURNING id";
        try (Connection conn = openConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, metadataJson);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getLong("id");
                }
                throw new SQLException("新增使用者失敗，未取得回傳主鍵 ID");
            }
        }
    }

    /**
     * 依 Email 查詢使用者
     */
    public Optional<UserRecord> findByEmail(String email) throws SQLException {
        String sql = "SELECT id, name, email, metadata::text FROM users WHERE email = ?";
        try (Connection conn = openConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(new UserRecord(
                            rs.getLong("id"),
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getString("metadata")
                    ));
                }
                return Optional.empty();
            }
        }
    }

    /**
     * PostgreSQL 原生 Upsert（ON CONFLICT DO UPDATE）：若 email 已存在則更新姓名
     */
    public void upsertNameByEmail(String name, String email, String metadataJson) throws SQLException {
        String sql = """
                INSERT INTO users (name, email, metadata)
                VALUES (?, ?, CAST(? AS jsonb))
                ON CONFLICT (email) DO UPDATE SET name = EXCLUDED.name
                """;
        try (Connection conn = openConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, metadataJson);
            ps.executeUpdate();
        }
    }
}
