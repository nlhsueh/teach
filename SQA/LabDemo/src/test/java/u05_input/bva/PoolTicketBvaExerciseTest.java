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
 * - 敬老票 SENIOR (120 元)：>= 65 歲 (65 ~ 120 歲)
 * - 異常防禦：年齡 < 0 或 > 120 歲拋出 IllegalArgumentException
 */
@DisplayName("Unit 5.3 練習：游泳池票價年齡階層邊界測試")
public class PoolTicketBvaExerciseTest {

    // =========================================================================
    // 💡 練習 1 提示 (Hints)：On-Off-In 階層臨界點測試
    // 關鍵臨界點：
    // - 0 歲、3 歲 (免費 FREE, 0 元) vs 4 歲、12 歲 (兒童 CHILD, 100 元)
    // - 13 歲、64 歲 (全票 ADULT, 250 元) vs 65 歲、120 歲 (敬老 SENIOR, 120 元)
    // =========================================================================
    @ParameterizedTest(name = "年齡 {0} 歲 ➔ 預期票種: {1}, 票價: {2} 元")
    @DisplayName("練習 1：使用 @CsvSource 測試四個年齡階層的所有交界點")
    @CsvSource({
            // TODO: 請參考下方註解，補全四個年齡階層的上下邊界測資 (年齡, 預期票種, 預期票價)：
            // "0,   FREE,   0",
            // "3,   FREE,   0",
            // "4,   CHILD,  100",
            // "12,  CHILD,  100",
            // "13,  ADULT,  250",
            // "64,  ADULT,  250",
            // "65,  SENIOR, 120",
            // "120, SENIOR, 120"
            "0, FREE, 0"
    })
    void exercise1_testAgeBoundaries(int age, PoolTicketCalculator.TicketType expectedType, int expectedPrice) {
        // TODO: 請呼叫 PoolTicketCalculator.getTicketType(age) 取得結果並進行斷言，完成後刪除 fail(...)：
        // PoolTicketCalculator.TicketType actualType = PoolTicketCalculator.getTicketType(age);
        // assertEquals(expectedType, actualType, "年齡 " + age + " 歲之票種判定不符");
        // assertEquals(expectedPrice, actualType.getPrice(), "年齡 " + age + " 歲之票價不符");
        fail("尚未完成練習 1：請補全 @CsvSource 邊界測資並完成票種與票價斷言");
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
        // TODO: 請使用 assertThrows 驗證輸入 -1 歲與 121 歲時皆會拋出 IllegalArgumentException：
        // () -> assertThrows(IllegalArgumentException.class, () -> PoolTicketCalculator.getTicketType(-1)),
        // () -> assertThrows(IllegalArgumentException.class, () -> PoolTicketCalculator.getTicketType(121))
        assertAll("年齡越界防禦",
                () -> fail("尚未完成練習 2：請驗證輸入 -1 歲時會拋出 IllegalArgumentException"),
                () -> fail("尚未完成練習 2：請驗證輸入 121 歲時會拋出 IllegalArgumentException")
        );
    }
}
