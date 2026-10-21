package u05_input.decision;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 💡 課堂示範 (Demo 5.7)：因果圖法與 CAR 決策表測試 (Decision Table)
 * 
 * 【教學核心觀念】：
 * 1. 因果圖邏輯網絡：將需求中的原因 (Causes, C_i) 與結果 (Effects, E_i) 以布林邏輯 (AND, OR, NOT) 關聯。
 * 2. CAR 決策表化簡：利用「不在乎條件 (Don't Care, `-`)」將 2^3 = 8 條規則收斂為 4 條精準規則：
 *    - 規則 1 (R_1)：滿千(Y), VIP(Y), 促銷碼(N) ➔ 8折(X)
 *    - 規則 2 (R_2)：滿千(Y), VIP(N), 促銷碼(Y) ➔ 免運(X)
 *    - 規則 3 (R_3)：滿千(Y), VIP(Y), 促銷碼(Y) ➔ 8折(X) + 免運(X)
 *    - 規則 4 (R_4)：未滿千(N), VIP(-), 促銷碼(-) ➔ 原價(X)  <-- 合併 4 條冗餘規則！
 * 3. 測試效益：達成 100% 業務邏輯覆蓋且零冗餘測試。
 */
@DisplayName("Unit 5.7 示範：促銷決策表化簡規則驗證")
public class PromotionDecisionDemoTest {

    @Test
    @DisplayName("示範 1 (規則 R_1)：滿千且 VIP，無促銷碼 ➔ 僅享 8 折優惠")
    void testRule1_vipOnly() {
        // [Arrange] 滿額 1500 元、是 VIP、無免運碼
        double amount = 1500.0;
        boolean isVip = true;
        boolean hasShippingCoupon = false;

        // [Act]
        PromotionCalculator.PromotionResult result = 
                PromotionCalculator.evaluate(amount, isVip, hasShippingCoupon);

        // [Assert] 驗證動作項組合
        assertAll("R_1 動作驗收",
                () -> assertTrue(result.discount80Percent, "應享有 8 折優惠"),
                () -> assertFalse(result.freeShipping, "無促銷碼，不應享有免運"),
                () -> assertFalse(result.regularCheckout, "已享優惠，不可判定為原價結帳")
        );
    }

    @Test
    @DisplayName("示範 2 (規則 R_2)：滿千且有促銷碼，非 VIP ➔ 僅享免運折抵")
    void testRule2_shippingCouponOnly() {
        PromotionCalculator.PromotionResult result = 
                PromotionCalculator.evaluate(1200.0, false, true);

        assertAll("R_2 動作驗收",
                () -> assertFalse(result.discount80Percent, "非 VIP 不享 8 折"),
                () -> assertTrue(result.freeShipping, "有促銷碼，應享免運"),
                () -> assertFalse(result.regularCheckout)
        );
    }

    @Test
    @DisplayName("示範 3 (規則 R_3)：滿千、是 VIP、有促銷碼 ➔ 雙重優惠 (8折 + 免運)")
    void testRule3_dualBenefits() {
        PromotionCalculator.PromotionResult result = 
                PromotionCalculator.evaluate(2000.0, true, true);

        assertAll("R_3 動作驗收",
                () -> assertTrue(result.discount80Percent, "應享 8 折"),
                () -> assertTrue(result.freeShipping, "應享免運"),
                () -> assertFalse(result.regularCheckout)
        );
    }

    @Test
    @DisplayName("示範 4 (規則 R_4 - 化簡關鍵)：未滿千門檻 ➔ 無論身分與促銷碼，一律原價結帳")
    void testRule4_notReachThreshold_dontCareInputs() {
        // C_1 = N (800 元)，此時無論 C_2 (VIP) 與 C_3 (促銷碼) 為何，結果必定為原價 E_3！
        PromotionCalculator.PromotionResult rA = PromotionCalculator.evaluate(800.0, true, true);
        PromotionCalculator.PromotionResult rB = PromotionCalculator.evaluate(500.0, false, false);

        assertAll("R_4 不在乎化簡驗證",
                () -> assertTrue(rA.regularCheckout, "未滿千即使有 VIP 與促銷碼亦為原價"),
                () -> assertFalse(rA.discount80Percent),
                () -> assertFalse(rA.freeShipping),

                () -> assertTrue(rB.regularCheckout, "未滿千一般顧客為原價")
        );
    }
}
