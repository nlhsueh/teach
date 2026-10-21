package u05_input.bva;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 🧪 課堂動手練習 (Exercise 5.3-B)：游泳池年齡階層票價邊界測試
 * 
 * 業務規格：
 * - 免費票 FREE (0 元)：0 ~ 3 歲
 * - 兒童票 CHILD (100 元)：4 ~ 12 歲
 * - 全票 ADULT (250 元)：13 ~ 64 歲
 * - 敬老票 SENIOR (120 元)：≥ 65 歲 (65 ~ 120 歲)
 * - 異常防禦：年齡 < 0 或 > 120 歲拋出 IllegalArgumentException
 */
@DisplayName("Unit 5.3 練習：游泳池票價年齡階層邊界測試")
public class PoolTicketBvaExerciseTest {

    // =========================================================================
    // 💡 練習 1 提示 (Hints)：On-Off-In 階層臨界點測試
    // 關鍵臨界點：
    // - 3 歲 (免費 On) vs 4 歲 (兒童 In/On)
    // - 12 歲 (兒童 On) vs 13 歲 (全票 In/On)
    // - 64 歲 (全票 On) vs 65 歲 (敬老 In/On)
    // =========================================================================
    @ParameterizedTest(name = "年齡 {0} 歲 ➔ 預期票種: {1}, 票價: {2} 元")
    @DisplayName("練習 1：使用 @CsvSource 測試四個年齡階層的所有交界點")
    @CsvSource({
            // 年齡, 預期票種, 預期票價
            "0,  FREE,   0",
            "3,  FREE,   0",
            "4,  CHILD,  100",
            "12, CHILD,  100",
            "13, ADULT,  250",
            "64, ADULT,  250",
            "65, SENIOR, 120",
            "120, SENIOR, 120"
    })
    void exercise1_testAgeBoundaries(int age, PoolTicketCalculator.TicketType expectedType, int expectedPrice) {
        // TODO: 呼叫 PoolTicketCalculator.getTicketType(age) 取得結果並進行斷言
        PoolTicketCalculator.TicketType actualType = PoolTicketCalculator.getTicketType(age);
        assertEquals(expectedType, actualType, "年齡 " + age + " 歲之票種判定不符");
        assertEquals(expectedPrice, actualType.getPrice(), "年齡 " + age + " 歲之票價不符");
    }

    // =========================================================================
    // 💡 練習 2 提示 (Hints)：越界異常防禦測試 (assertThrows)
    // 邊界越界點：
    // - 下界越界：-1 歲
    // - 上界越界：121 歲
    // =========================================================================
    @Test
    @DisplayName("練習 2：驗證年齡越界的防禦性例外拋出")
    void exercise2_testInvalidAgeBoundaries() {
        assertAll("年齡越界防禦",
                // TODO: 驗證輸入 -1 歲時會拋出 IllegalArgumentException
                () -> assertThrows(IllegalArgumentException.class,
                        () -> PoolTicketCalculator.getTicketType(-1),
                        "年齡 -1 歲必須拋出 IllegalArgumentException"),

                // TODO: 驗證輸入 121 歲時會拋出 IllegalArgumentException
                () -> assertThrows(IllegalArgumentException.class,
                        () -> PoolTicketCalculator.getTicketType(121),
                        "年齡 121 歲必須拋出 IllegalArgumentException")
        );
    }
}
