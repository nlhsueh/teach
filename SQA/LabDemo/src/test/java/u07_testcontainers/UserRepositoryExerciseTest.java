package u07_testcontainers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 🧪 課堂動手練習 (Exercise 7.7)：Testcontainers 交易回滾 (Rollback) 與 JSONB 查詢
 *
 * 請先啟動本機 Docker，移除 @Disabled 並依照 TODO 提示補全測試程式碼！
 */
@Disabled("課堂動手練習：請在啟動 Docker 後移除此行，完成 TODO 並執行測試")
@Testcontainers(disabledWithoutDocker = true)
@DisplayName("Exercise 7.7：Testcontainers 交易回滾實作練習")
public class UserRepositoryExerciseTest {

    @Container
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16-alpine")
            .withDatabaseName("sqa_exercise_db")
            .withUsername("test_user")
            .withPassword("test_pass");

    private static UserRepository userRepository;

    @BeforeAll
    static void init() throws SQLException {
        userRepository = new UserRepository(
                postgres.getJdbcUrl(),
                postgres.getUsername(),
                postgres.getPassword()
        );
        userRepository.initSchema();
    }

    @Test
    @DisplayName("練習 1：驗證手動交易 rollback() 後，資料庫不應殘留未提交資料")
    void exercise1_transactionRollbackLeavesNoDirtyData() throws SQLException {
        try (Connection conn = userRepository.openConnection()) {
            conn.setAutoCommit(false);
            try (PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO users (name, email, metadata) VALUES (?, ?, CAST(? AS jsonb))")) {
                ps.setString(1, "TempUser");
                ps.setString(2, "temp@fcu.edu.tw");
                ps.setString(3, "{\"temp\": true}");
                ps.executeUpdate();
            }
            // TODO: 呼叫 conn.rollback() 回復本次交易
            conn.rollback();
        }

        // TODO: 驗證 userRepository.findByEmail("temp@fcu.edu.tw") 應為 Optional.empty()
        assertTrue(userRepository.findByEmail("temp@fcu.edu.tw").isEmpty());
    }
}
