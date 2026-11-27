package u07_testcontainers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit 07 實習示範：純 Java + JUnit 5 + Testcontainers 真實 PostgreSQL 容器化整合測試
 *
 * 執行前提：本機需啟動 Docker Desktop 或 OrbStack（若無 Docker，disabledWithoutDocker=true 會自動略過）。
 * 執行指令：mvn test -Dtest=UserRepositoryTestcontainersTest
 */
@Testcontainers(disabledWithoutDocker = true)
@DisplayName("Unit 07 Testcontainers：純 Java JDBC 真實 PostgreSQL 整合測試")
public class UserRepositoryTestcontainersTest {

    // 1. 宣告真實 PostgreSQL 16 Docker 容器（static 讓同類別測試共用容器以加速執行）
    @Container
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16-alpine")
            .withDatabaseName("sqa_test_db")
            .withUsername("test_user")
            .withPassword("test_pass");

    private static UserRepository userRepository;

    @BeforeAll
    static void setUpDatabase() throws SQLException {
        // 2. 透過 Constructor DI 注入容器動態分配的隨機 Port JDBC URL
        userRepository = new UserRepository(
                postgres.getJdbcUrl(),
                postgres.getUsername(),
                postgres.getPassword()
        );
        userRepository.initSchema();
    }

    @BeforeEach
    void cleanTable() throws SQLException {
        // 確保每個測試案例執行前資料表都是乾淨的（測試獨立性 FIRST 原則）
        try (Connection conn = userRepository.openConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute("TRUNCATE TABLE users RESTART IDENTITY");
        }
    }

    @Test
    @DisplayName("示範 1：驗證 PostgreSQL 原生 JSONB 欄位與 RETURNING id")
    void testSaveAndFindWithNativeJsonb() throws SQLException {
        long id = userRepository.save("Alice", "alice@fcu.edu.tw", "{\"role\": \"ADMIN\", \"level\": 5}");
        assertEquals(1L, id);

        Optional<UserRepository.UserRecord> found = userRepository.findByEmail("alice@fcu.edu.tw");
        assertTrue(found.isPresent());
        assertEquals("Alice", found.get().name());
        assertTrue(found.get().metadata().contains("\"ADMIN\""));
    }

    @Test
    @DisplayName("示範 2：驗證真實資料庫 UNIQUE 約束違規（SQLState 23505）")
    void testUniqueEmailConstraintViolation() throws SQLException {
        userRepository.save("Bob", "bob@fcu.edu.tw", "{}");

        SQLException ex = assertThrows(SQLException.class, () ->
                userRepository.save("Bob Duplicate", "bob@fcu.edu.tw", "{}")
        );
        // PostgreSQL 標準唯一鍵衝突錯誤碼為 23505
        assertEquals("23505", ex.getSQLState());
    }

    @Test
    @DisplayName("示範 3：驗證 PostgreSQL 原生 ON CONFLICT DO UPDATE (Upsert)")
    void testPostgresUpsertOnConflict() throws SQLException {
        userRepository.upsertNameByEmail("Carol v1", "carol@fcu.edu.tw", "{\"tier\": \"SILVER\"}");
        userRepository.upsertNameByEmail("Carol v2", "carol@fcu.edu.tw", "{\"tier\": \"GOLD\"}");

        UserRepository.UserRecord updated = userRepository.findByEmail("carol@fcu.edu.tw").orElseThrow();
        assertEquals("Carol v2", updated.name());
    }
}
