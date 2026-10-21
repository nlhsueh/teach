package u05_input.decision;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 🧪 課堂動手練習 (Exercise 5.7)：促銷決策表規則自動化驗證
 * 
 * 請閱讀【提示 (Hints)】，補全 // TODO 標記處的程式碼以通過測試。
 */
@DisplayName("Unit 5.7 練習：CAR 決策表測試練習題")
public class PromotionDecisionExerciseTest {

    // =========================================================================
    // 💡 練習 1 提示 (Hints)：剛好滿足滿額門檻 (1000 元邊界) 的 R_1 驗收
    // 邊界測試結合決策表：當金額剛好為 1000.0 元 (C_1=Y) 且為 VIP，驗證是否精準享有 8 折！
    // =========================================================================
    @Test
    @DisplayName("練習 1：驗證 1000 元滿額臨界值且具 VIP 身分")
    void exercise1_testExact1000VipBoundary() {
        // [Arrange] 剛好 1000.0 元
        double amount = 1000.0;
        boolean isVip = true;
        boolean hasCoupon = false;

        // [Act]
        // TODO: 呼叫 PromotionCalculator.evaluate
        PromotionCalculator.PromotionResult result = 
                PromotionCalculator.evaluate(amount, isVip, hasCoupon);

        // [Assert]
        // TODO: 斷言 discount80Percent 為 true, regularCheckout 為 false
        assertTrue(result.discount80Percent, "剛好滿 1000 元應享 8 折");
        assertFalse(result.regularCheckout, "不應為原價");
    }

    // =========================================================================
    // 💡 練習 2 提示 (Hints)：未達滿額門檻 (999.9 元邊界) 的 R_4 驗收
    // 當金額為 999.9 元 (C_1=N)，即使輸入促銷碼且為 VIP，亦不得享有任何優惠！
    // =========================================================================
    @Test
    @DisplayName("練習 2：驗證 999.9 元未滿額臨界值 (即使有促銷碼依然原價)")
    void exercise2_test999UnderThresholdBoundary() {
        double amount = 999.9;
        boolean isVip = true;
        boolean hasCoupon = true;

        // TODO: 呼叫 PromotionCalculator.evaluate 並驗證結果
        PromotionCalculator.PromotionResult result = 
                PromotionCalculator.evaluate(amount, isVip, hasCoupon);

        assertTrue(result.regularCheckout, "999.9 元未達門檻，必須原價結帳");
        assertFalse(result.discount80Percent, "未達門檻不可享 8 折");
        assertFalse(result.freeShipping, "未達門檻不可享免運");
    }

    // =========================================================================
    // 💡 練習 3 提示 (Hints)：使用 @CsvSource 一次驗證 CAR 表的 4 條精準規則
    // 欄位：金額, 是否VIP, 是否有碼, 預期8折, 預期免運, 預期原價
    // =========================================================================
    @ParameterizedTest(name = "規則驗收 - 金額:{0}, VIP:{1}, 促銷碼:{2} ➔ 8折:{3}, 免運:{4}, 原價:{5}")
    @DisplayName("練習 3：資料驅動驗證 CAR 決策表全規則矩陣")
    @CsvSource({
            // R_1: 滿千, VIP, 無碼 ➔ 8折
            "1500.0, true,  false, true,  false, false",
            // R_2: 滿千, 一般, 有碼 ➔ 免運
            "1200.0, false, true,  false, true,  false",
            // R_3: 滿千, VIP, 有碼 ➔ 8折 + 免運
            "2500.0, true,  true,  true,  true,  false",
            // R_4: 未滿千, VIP, 有碼 ➔ 原價結帳 (化簡規則)
            "800.0,  true,  true,  false, false, true"
    })
    void exercise3_testAllDecisionRules(double amount, boolean isVip, boolean hasCoupon,
                                       boolean exp80, boolean expShip, boolean expRegular) {
        // TODO: 執行 evaluate 並以 assertAll 統一斷言三項動作
        PromotionCalculator.PromotionResult result = 
                PromotionCalculator.evaluate(amount, isVip, hasCoupon);

        assertAll("決策表動作比對",
                () -> assertEquals(exp80, result.discount80Percent, "8折動作不符"),
                () -> assertEquals(expShip, result.freeShipping, "免運動作不符"),
                () -> assertEquals(expRegular, result.regularCheckout, "原價動作不符")
        );
    }
}
