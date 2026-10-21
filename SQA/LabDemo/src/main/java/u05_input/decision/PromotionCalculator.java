package u05_input.decision;

/**
 * 促銷結帳決策邏輯 (供 Unit 5.7 因果圖與決策表測試 Decision Table 示範)
 * 
 * 對應 CAR 決策表規格：
 * - 條件 (Conditions)：
 *   - C_1: 訂單金額 >= 1000 元 (滿額先決門檻)
 *   - C_2: 具備 VIP 會員身分
 *   - C_3: 結帳時輸入有效免運促銷碼
 * - 動作 (Actions)：
 *   - E_1: 輸出「享有 8 折優惠」
 *   - E_2: 輸出「享有免運費折抵」
 *   - E_3: 輸出「原價一般結帳」
 * 
 * 商業規則化簡 (CAR)：
 * - R_1: C_1(Y), C_2(Y), C_3(N) ➔ E_1 (8折)
 * - R_2: C_1(Y), C_2(N), C_3(Y) ➔ E_2 (免運)
 * - R_3: C_1(Y), C_2(Y), C_3(Y) ➔ E_1 + E_2 (雙重優惠)
 * - R_4: C_1(N), C_2(-), C_3(-) ➔ E_3 (未滿額則無視其他條件，原價結帳)
 */
public class PromotionCalculator {

    public static class PromotionResult {
        public final boolean discount80Percent;
        public final boolean freeShipping;
        public final boolean regularCheckout;

        public PromotionResult(boolean discount80Percent, boolean freeShipping, boolean regularCheckout) {
            this.discount80Percent = discount80Percent;
            this.freeShipping = freeShipping;
            this.regularCheckout = regularCheckout;
        }

        @Override
        public String toString() {
            return String.format("PromotionResult[8折=%b, 免運=%b, 原價=%b]",
                    discount80Percent, freeShipping, regularCheckout);
        }
    }

    public static PromotionResult evaluate(double amount, boolean isVip, boolean hasShippingCoupon) {
        // C_1 滿額門檻 (先決條件)
        boolean c1 = amount >= 1000.0;
        boolean c2 = isVip;
        boolean c3 = hasShippingCoupon;

        // 若未滿額 (C_1 = N)，化簡為 R_4：一律原價結帳，無視 VIP 與促銷碼
        if (!c1) {
            return new PromotionResult(false, false, true);
        }

        // 滿額情況下評估各優惠動作
        boolean e1 = c1 && c2; // 8折
        boolean e2 = c1 && c3; // 免運
        boolean e3 = !(e1 || e2); // 若皆無則為原價

        return new PromotionResult(e1, e2, e3);
    }
}
