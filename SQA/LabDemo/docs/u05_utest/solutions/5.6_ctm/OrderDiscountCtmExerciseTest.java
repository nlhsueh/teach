package u05_combinatorial.ctm;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 🧪 課堂動手練習 (Exercise 5.6 標準解答)：以多層 @Nested 映射 CTM 分類樹與打點矩陣測試 (TC_1 ~ TC_4)
 * 
 * 對應投影片 CTM 電商結帳折扣打點組合矩陣（含信用卡子樹，共 10 個葉節點、4 組測試案例）：
 * - TC_1: VIP 會員, 3500 元 (>3K), 信用卡 [刷一次] ➔ 8 折 + 滿額折 300 ➔ 結帳 3500*0.8 - 300 = 2500 元
 * - TC_2: VIP 會員, 3500 元 (>3K), 信用卡 [刷分期] ➔ 8 折 + 滿額折 300 ➔ 結帳 3500*0.8 - 300 = 2500 元 (信用卡子樹)
 * - TC_3: 一般會員, 2000 元 (1~3K), 行動支付       ➔ 9 折 + 滿額折 100 ➔ 結帳 2000*0.9 - 100 = 1700 元
 * - TC_4: 訪客,     800 元 (<1K),  貨到付款       ➔ 原價無折扣        ➔ 結帳 800 元
 */
@DisplayName("Unit 5.6 練習：CTM 電商折扣分類樹多層 @Nested 測試 (TC_1 ~ TC_4)")
public class OrderDiscountCtmExerciseTest {

    @Nested
    @DisplayName("👑 VIP 會員分類樹測試群組 (外層分類)")
    class VipMemberTests {

        @Nested
        @DisplayName("💳 信用卡支付子樹：一次付清 vs. 分期付款 (內層子樹)")
        class CreditCardSubTreeTests {

            @Test
            @DisplayName("TC_1: VIP 大額訂單 (>3K) 刷卡一次付清 ➔ 享 8 折加滿額立減 300 元")
            void testVipLargeOrderCreditCardOneTime() {
                OrderDiscount.DiscountResult result = OrderDiscount.calculateDiscount(
                        OrderDiscount.MemberType.VIP,
                        3500.0,
                        OrderDiscount.PaymentMethod.CREDIT_CARD_ONE_TIME
                );
                assertEquals(2500.0, result.finalAmount, "VIP 3500 元折抵後應為 2500 元");
                assertEquals(1000.0, result.discountAmount, "總折扣金額應為 1000 元 (700+300)");
            }

            @Test
            @DisplayName("TC_2: VIP 大額訂單 (>3K) 刷卡分期 (子樹) ➔ 享 8 折加滿額立減 300 元")
            void testVipLargeOrderCreditCardInstallment() {
                OrderDiscount.DiscountResult result = OrderDiscount.calculateDiscount(
                        OrderDiscount.MemberType.VIP,
                        3500.0,
                        OrderDiscount.PaymentMethod.CREDIT_CARD_INSTALLMENT
                );
                assertEquals(2500.0, result.finalAmount, "VIP 3500 元刷卡分期折抵後應為 2500 元");
                assertEquals(1000.0, result.discountAmount, "總折扣金額應為 1000 元 (700+300)");
            }
        }
    }

    @Nested
    @DisplayName("👤 一般會員與訪客分類樹測試群組 (免測分期子樹)")
    class RegularAndGuestTests {

        @Test
        @DisplayName("TC_3: 一般會員中額訂單 (1K~3K) 行動支付 ➔ 享 9 折加滿額立減 100 元")
        void testRegularMediumOrderMobilePay() {
            OrderDiscount.DiscountResult result = OrderDiscount.calculateDiscount(
                    OrderDiscount.MemberType.REGULAR,
                    2000.0,
                    OrderDiscount.PaymentMethod.MOBILE_PAY
            );
            assertEquals(1700.0, result.finalAmount, "一般會員 2000 元折抵後應為 1700 元");
        }

        @Test
        @DisplayName("TC_4: 訪客小額訂單 (<1K) 貨到付款 ➔ 原價無折扣")
        void testGuestSmallOrderCashOnDelivery() {
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
