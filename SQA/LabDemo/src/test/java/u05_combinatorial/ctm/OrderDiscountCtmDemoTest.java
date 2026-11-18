package u05_combinatorial.ctm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 💡 課堂示範 (Demo 5.6)：CTM 電商結帳折扣分類樹實戰 (對應投影片 p.57 之 TC1 ~ TC4)
 * 
 * 【對應投影片 p.57：CTM 階層細分與打點矩陣（含信用卡子樹，共 10 個葉節點）】
 * - TC1: VIP   × >3K (3500元)  × 信用卡 [刷一次] ➔ 8折 + 折300 (一次付清)   = 2500 元
 * - TC2: VIP   × >3K (3500元)  × 信用卡 [刷分期] ➔ 8折 + 折300 (刷卡分期子樹) = 2500 元
 * - TC3: 一般  × 1~3K (2000元) × 行動支付        ➔ 9折 + 折100 (行動免測分期) = 1700 元
 * - TC4: 訪客  × <1K (800元)   × 貨到付款        ➔ 原價無折扣 (貨到免測分期)  = 800 元
 * 
 * 【教學核心觀念】：
 * 1. 語意化顯示名稱 (@DisplayName)：直接標註 TC1~TC4 完整業務規格，讓測試報告化為驗收活文件。
 * 2. 多層巢狀情境分組 (@Nested)：
 *    - 只有選「信用卡」時才向下展開 제3層 @Nested class CreditCardSubTreeTest（一次 vs. 分期）；
 *    - 「一般會員 (行動支付)」與「訪客 (貨到付款)」自動略過分期子樹，1:1 同構映射 CTM 分類樹！
 */
@DisplayName("Unit 5.6 示範：CTM 電商結帳折扣分類樹 (TC1 ~ TC4 完整階層測試)")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class OrderDiscountCtmDemoTest {

    // =========================================================================
    // 👑 分類一 [會員身分]：VIP 會員 ➔ 滿 3000 元 ➔ 信用卡子樹 (TC1, TC2)
    // =========================================================================
    @Nested
    @DisplayName("👑 分類一 [會員身分]：VIP 會員 (VIPMemberTest)")
    class VIPMemberTest {

        @BeforeEach
        void printLevel1() {
            System.out.println("🌳 [CTM 階層 1] 👑 分類一 [會員身分]：VIP 會員 (VIPMemberTest)");
        }

        @Nested
        @DisplayName("💰 分類二 [消費金額]：>3K 大額訂單 (Over3000AmountTest)")
        class Over3000AmountTest {

            @BeforeEach
            void printLevel2() {
                System.out.println("   └── [CTM 階層 2] 💰 分類二 [消費金額]：>3K 大額訂單 (Over3000AmountTest)");
            }

            @Nested
            @DisplayName("💳 分類三 [付款方式]：信用卡支付子樹 (CreditCardSubTreeTest)")
            class CreditCardSubTreeTest {

                @BeforeEach
                void printLevel3(TestInfo testInfo) {
                    System.out.println("       └── [CTM 階層 3 (子樹)] 💳 分類三 [付款方式]：信用卡支付子樹");
                    System.out.println("           └── 🎯 執行案例：" + testInfo.getDisplayName());
                }

                @Test
                @DisplayName("TC1: VIP × >3K × 刷一次 ➔ 8折+折300 (一次付清，結帳 2500 元)")
                void testTc1_VipOver3000CreditCardOneTime() {
                    OrderDiscount.DiscountResult result = OrderDiscount.calculateDiscount(
                            OrderDiscount.MemberType.VIP,
                            3500.0,
                            OrderDiscount.PaymentMethod.CREDIT_CARD_ONE_TIME
                    );
                    assertEquals(2500.0, result.finalAmount, "3500 * 0.8 - 300 應為 2500 元");
                    assertEquals(1000.0, result.discountAmount, "總折扣應為 1000 元");
                }

                @Test
                @DisplayName("TC2: VIP × >3K × 刷分期 ➔ 8折+折300 (刷卡分期子樹，結帳 2500 元)")
                void testTc2_VipOver3000CreditCardInstallment() {
                    OrderDiscount.DiscountResult result = OrderDiscount.calculateDiscount(
                            OrderDiscount.MemberType.VIP,
                            3500.0,
                            OrderDiscount.PaymentMethod.CREDIT_CARD_INSTALLMENT
                    );
                    assertEquals(2500.0, result.finalAmount, "刷卡分期子樹同樣享 8 折與滿額折 300 元");
                    assertEquals(1000.0, result.discountAmount, "總折扣應為 1000 元");
                }
            }
        }
    }

    // =========================================================================
    // 👤 分類一 [會員身分]：一般會員 ➔ 1~3K 中額訂單 ➔ 行動支付免測分期 (TC3)
    // =========================================================================
    @Nested
    @DisplayName("👤 分類一 [會員身分]：一般會員 (RegularMemberTest)")
    class RegularMemberTest {

        @BeforeEach
        void printLevel1() {
            System.out.println("🌳 [CTM 階層 1] 👤 分類一 [會員身分]：一般會員 (RegularMemberTest)");
        }

        @Nested
        @DisplayName("💰 分類二 [消費金額]：1~3K 中額訂單 (MediumAmountTest)")
        class MediumAmountTest {

            @BeforeEach
            void printLevel2(TestInfo testInfo) {
                System.out.println("   └── [CTM 階層 2] 💰 分類二 [消費金額]：1~3K 中額訂單 (MediumAmountTest)");
                System.out.println("       └── 🎯 執行案例：" + testInfo.getDisplayName());
            }

            @Test
            @DisplayName("TC3: 一般 × 1~3K × 行動 ➔ 9折+折100 (行動免測分期，結帳 1700 元)")
            void testTc3_RegularMediumMobilePay() {
                OrderDiscount.DiscountResult result = OrderDiscount.calculateDiscount(
                        OrderDiscount.MemberType.REGULAR,
                        2000.0,
                        OrderDiscount.PaymentMethod.MOBILE_PAY
                );
                assertEquals(1700.0, result.finalAmount, "2000 * 0.9 - 100 應為 1700 元");
                assertEquals(300.0, result.discountAmount, "總折扣應為 300 元");
            }
        }
    }

    // =========================================================================
    // 🛒 分類一 [會員身分]：訪客 ➔ <1K 小額訂單 ➔ 貨到付款免測分期 (TC4)
    // =========================================================================
    @Nested
    @DisplayName("🛒 分類一 [會員身分]：訪客 (GuestMemberTest)")
    class GuestMemberTest {

        @BeforeEach
        void printLevel1() {
            System.out.println("🌳 [CTM 階層 1] 🛒 分類一 [會員身分]：訪客 (GuestMemberTest)");
        }

        @Nested
        @DisplayName("💰 分類二 [消費金額]：<1K 小額訂單 (Under1000AmountTest)")
        class Under1000AmountTest {

            @BeforeEach
            void printLevel2(TestInfo testInfo) {
                System.out.println("   └── [CTM 階層 2] 💰 分類二 [消費金額]：<1K 小額訂單 (Under1000AmountTest)");
                System.out.println("       └── 🎯 執行案例：" + testInfo.getDisplayName());
            }

            @Test
            @DisplayName("TC4: 訪客 × <1K × 貨到 ➔ 原價無折扣 (貨到免測分期，結帳 800 元)")
            void testTc4_GuestSmallCashOnDelivery() {
                OrderDiscount.DiscountResult result = OrderDiscount.calculateDiscount(
                        OrderDiscount.MemberType.GUEST,
                        800.0,
                        OrderDiscount.PaymentMethod.CASH_ON_DELIVERY
                );
                assertEquals(800.0, result.finalAmount, "訪客小額訂單應為原價 800 元");
                assertEquals(0.0, result.discountAmount, "總折扣應為 0 元");
            }
        }
    }
}
