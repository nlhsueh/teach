package u05_input.ctm;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 🧪 課堂動手練習 (Exercise 5.6)：以 @Nested 映射 CTM 分類樹與打點矩陣測試
 * 
 * 對應 CTM 打點組合矩陣：
 * - TC_1: VIP, $3500 (>3K), 信用卡 ➔ 8 折 + 滿額折 300 ➔ 結帳 3500*0.8 - 300 = 2500 元
 * - TC_2: 一般會員, $2000 (1~3K), 行動支付 ➔ 9 折 + 滿額折 100 ➔ 結帳 2000*0.9 - 100 = 1700 元
 * - TC_3: 訪客, $800 (<1K), 貨到付款 ➔ 原價無折扣 ➔ 結帳 800 元
 */
@DisplayName("Unit 5.6 練習：CTM 電商折扣分類樹階層測試")
public class OrderDiscountCtmExerciseTest {

    @Nested
    @DisplayName("👑 VIP 會員分類樹測試群組")
    class VipMemberTests {

        // =========================================================================
        // 💡 練習 1 提示 (Hints)：對應 CTM 矩陣 TC_1
        // 輸入：VIP 會員、金額 3500 元、支付方式 CREDIT_CARD
        // 預期：享 8 折 (3500 * 0.8 = 2800) 並滿額折 300 元 ➔ 最終應為 2500 元
        // =========================================================================
        @Test
        @DisplayName("TC_1: VIP 大額訂單 (>3K) 享 8 折加滿額立減 300 元")
        void testVipLargeOrder() {
            // TODO: 呼叫 OrderDiscount.calculateDiscount 並驗證 finalAmount 是否為 2500.0
            OrderDiscount.DiscountResult result = OrderDiscount.calculateDiscount(
                    OrderDiscount.MemberType.VIP,
                    3500.0,
                    OrderDiscount.PaymentMethod.CREDIT_CARD
            );
            assertEquals(2500.0, result.finalAmount, "VIP 3500 元折抵後應為 2500 元");
            assertEquals(1000.0, result.discountAmount, "總折扣金額應為 1000 元 (700+300)");
        }
    }

    @Nested
    @DisplayName("👤 一般會員與訪客分類樹測試群組")
    class RegularAndGuestTests {

        // =========================================================================
        // 💡 練習 2 提示 (Hints)：對應 CTM 矩陣 TC_2
        // 輸入：REGULAR 會員、金額 2000 元、MOBILE_PAY
        // 預期：享 9 折 (2000 * 0.9 = 1800) 並滿額折 100 元 ➔ 最終應為 1700 元
        // =========================================================================
        @Test
        @DisplayName("TC_2: 一般會員中額訂單 (1K~3K) 享 9 折加滿額立減 100 元")
        void testRegularMediumOrder() {
            // TODO: 驗證 REGULAR 2000 元之 finalAmount 是否為 1700.0
            OrderDiscount.DiscountResult result = OrderDiscount.calculateDiscount(
                    OrderDiscount.MemberType.REGULAR,
                    2000.0,
                    OrderDiscount.PaymentMethod.MOBILE_PAY
            );
            assertEquals(1700.0, result.finalAmount, "一般會員 2000 元折抵後應為 1700 元");
        }

        // =========================================================================
        // 💡 練習 3 提示 (Hints)：對應 CTM 矩陣 TC_3
        // 輸入：GUEST 訪客、金額 800 元、CASH_ON_DELIVERY
        // 預期：無會員折扣、無滿額折 ➔ 最終應為 800 元
        // =========================================================================
        @Test
        @DisplayName("TC_3: 訪客小額訂單 (<1K) 原價無折扣")
        void testGuestSmallOrder() {
            // TODO: 驗證 GUEST 800 元之 finalAmount 是否為 800.0
            OrderDiscount.DiscountResult result = OrderDiscount.calculateDiscount(
                    OrderDiscount.MemberType.GUEST,
                    800.0,
                    OrderDiscount.PaymentMethod.CASH_ON_DELIVERY
            );
            assertEquals(800.0, result.finalAmount, "訪客小額訂單應為原價 800 元");
            assertEquals(0.0, result.discountAmount, "訪客無任何折扣金額");
        }
    }
}
