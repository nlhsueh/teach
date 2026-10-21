package u05_scenario.experience;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 💡 課堂示範 (Demo 5.11)：經驗基礎測試與錯誤猜測法 (Error Guessing)
 * 
 * 【教學核心觀念】：
 * 1. 錯誤猜測法的本質：測試者根據過去開發與測試經驗、直覺以及歷史缺陷清單 (Fault Taxonomy)，
 *    主動猜測「開發者最容易在此處犯下的錯誤」。
 * 2. 經典錯誤猜測防禦清單：
 *    - 清單 1：空白與空字串繞過（如純空格 `"   "` 是否被誤判為合法字串）。
 *    - 清單 2：極端整數值（如 `0`、`-1`、`Integer.MAX_VALUE` 溢位）。
 *    - 清單 3：特殊格式探針（如 XSS `<script>`、SQL 注入單引號 `'`）。
 *    - 清單 4：首尾空白字元是否漏未 `trim()`。
 */
@DisplayName("Unit 5.11 示範：錯誤猜測法防禦清單實戰")
public class ErrorGuessingDemoTest {

    private UserProfileService userService;

    @BeforeEach
    void setUp() {
        userService = new UserProfileService();
    }

    @ParameterizedTest(name = "猜測無效使用者名稱：\"{0}\"")
    @DisplayName("示範 1【空白與注入猜測】：純空格與危險特殊字元探針防禦")
    @ValueSource(strings = {
            "",                     // 空字串
            "   ",                  // 純空白字元繞過
            "<script>alert(1)</script>", // XSS 探針
            "admin' OR '1'='1"      // SQL 注入單引號探針
    })
    void testUsernameErrorGuessing(String maliciousUsername) {
        assertThrows(IllegalArgumentException.class, () ->
                userService.createUser(maliciousUsername, "user@example.com", 25),
                "未妥善過濾危險字元或純空格使用者名稱！"
        );
    }

    @ParameterizedTest(name = "猜測極端年齡值：{0}")
    @DisplayName("示範 2【整數邊界與溢位猜測】：0、負數與整數極大值防禦")
    @ValueSource(ints = {
            0,                      // 零值
            -1,                     // 負數
            151,                    // 超過人類極限
            Integer.MAX_VALUE       // 21 億整數極限溢位探針
    })
    void testAgeErrorGuessing(int abnormalAge) {
        assertThrows(IllegalArgumentException.class, () ->
                userService.createUser("JohnDoe", "user@example.com", abnormalAge),
                "未攔截異常年齡數值！"
        );
    }

    @Test
    @DisplayName("示範 3【字串修剪猜測】：輸入含有首尾空白時應自動 trim() 清理")
    void testWhitespaceTrimming() {
        UserProfileService.UserProfile profile = 
                userService.createUser("  ValidUser  ", "  test@example.com  ", 30);

        assertEquals("ValidUser", profile.username, "使用者名稱首尾空白應被自動修剪");
        assertEquals("test@example.com", profile.email, "Email 首尾空白應被自動修剪");
    }
}
