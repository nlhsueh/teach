package u05_scenario.experience;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 🧪 課堂動手練習 (Exercise 5.11)：探索性測試與缺陷猜測清單練習
 * 
 * 請閱讀【提示 (Hints)】，補全 // TODO 標記處的程式碼以通過測試。
 */
@DisplayName("Unit 5.11 練習：Email 格式常見直覺錯誤猜測")
public class ExploratoryExerciseTest {

    private UserProfileService userService;

    @BeforeEach
    void setUp() {
        userService = new UserProfileService();
    }

    // =========================================================================
    // 💡 練習 1 提示 (Hints)：猜測無效 Email 格式探針
    // 開發者常以為輸入字串只要有 "@" 就是合法的 Email。
    // 請猜測並測試以下典型瑕疵格式：
    // - 缺少 "@"：如 "plainaddress"
    // - 缺少網域名稱：如 "user@" 或 "@example.com"
    // - 含有空格：如 "user @example.com"
    // - 傳入 null
    // =========================================================================
    @ParameterizedTest(name = "測試無效 Email 格式猜測：\"{0}\"")
    @DisplayName("練習 1：驗證各類典型畸形 Email 格式皆被防禦攔截")
    @ValueSource(strings = {
            "plainaddress",
            "user@",
            "@example.com",
            "user @example.com",
            "user@.com"
    })
    void exercise1_testInvalidEmailPatterns(String invalidEmail) {
        // TODO: 使用 assertThrows 驗證傳入無效 Email 時會拋出 IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () ->
                userService.createUser("Alice", invalidEmail, 28),
                "畸形 Email 格式必須拋出 IllegalArgumentException"
        );
    }

    // =========================================================================
    // 💡 練習 2 提示 (Hints)：測試 null 指標攻擊
    // 若 username 或 email 傳入 null，系統應該優雅拋出 IllegalArgumentException，
    // 嚴禁噴出未處理的 NullPointerException 導致服務崩潰！
    // =========================================================================
    @Test
    @DisplayName("練習 2：驗證傳入 null 參數之防衛性設計")
    void exercise2_testNullInputs() {
        assertAll("Null 參數防衛",
                // TODO: 驗證 username 為 null 時拋出 IllegalArgumentException
                () -> assertThrows(IllegalArgumentException.class,
                        () -> userService.createUser(null, "valid@test.com", 25),
                        "Username 為 null 必須拋出 IllegalArgumentException"),

                // TODO: 驗證 email 為 null 時拋出 IllegalArgumentException
                () -> assertThrows(IllegalArgumentException.class,
                        () -> userService.createUser("Alice", null, 25),
                        "Email 為 null 必須拋出 IllegalArgumentException")
        );
    }
}
