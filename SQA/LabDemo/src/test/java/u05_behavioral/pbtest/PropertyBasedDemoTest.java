package u05_behavioral.pbtest;

import net.jqwik.api.*;
import net.jqwik.api.constraints.DoubleRange;
import net.jqwik.api.constraints.IntRange;
import u05_combinatorial.ctm.OrderDiscount;
import u05_combinatorial.pair.LoanCalculator;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 💡 課堂示範 (Demo 5.11-A)：屬性基礎測試 (Property-Based Testing, PBT) — 從基礎數學到企業商業邏輯與 Shrinking
 * 
 * 【教學核心觀念】：
 * 1. 範例測試 (Example-based) vs. 屬性測試 (Property-based)：
 *    - 範例測試只檢驗單點特例：assert 1 + 2 == 3。
 *    - 屬性測試檢驗普遍商業不變量 (Invariant)：無論輸入何種金額與會員等級，VIP 結帳價必 <= 一般會員 <= 訪客！
 * 2. 海量隨機與邊界生成 (@ForAll, @DoubleRange, @IntRange)：
 *    - jqwik 引擎自動產生 1,000 組極值、邊界與隨機組合（含 Enum、浮點數、整數區間）。
 * 3. 測資收縮 (Shrinking) 企業抓漏實戰 (請見下方【示範 8】)：
 *    - 當發現違反商業規則的反例時，jqwik 自動二分收縮，回報能夠重現 Bug 的最小反例！
 */
public class PropertyBasedDemoTest {

    // =========================================================================
    // Part 1：基礎代數與資料結構不變量 (Math & Collection Invariants)
    // =========================================================================

    @Property
    @Label("示範 1 (代數定律)：加法交換律不變量 (a + b == b + a)")
    boolean additionIsCommutative(@ForAll int a, @ForAll int b) {
        return MathFunctions.add(a, b) == MathFunctions.add(b, a);
    }

    @Property
    @Label("示範 2 (代數定律)：加法單位元性質 (a + 0 == a)")
    boolean additionHasIdentityElement(@ForAll int a) {
        return MathFunctions.add(a, 0) == a;
    }

    @Property
    @Label("示範 3 (往返可逆)：反轉兩次回到自身不變量 (reverse(reverse(L)) == L)")
    boolean reverseTwiceIsOriginal(@ForAll List<Integer> list) {
        List<Integer> reversedOnce = MathFunctions.reverse(list);
        List<Integer> reversedTwice = MathFunctions.reverse(reversedOnce);

        assertEquals(list.size(), reversedTwice.size());
        return list.equals(reversedTwice);
    }

    @Property
    @Label("示範 4 (結構守恆)：排序後的長度守恆與單調遞增不變量")
    boolean sortedListIsMonotonic(@ForAll List<Integer> list) {
        List<Integer> sorted = MathFunctions.sort(list);
        assertEquals(list.size(), sorted.size());

        for (int i = 0; i < sorted.size() - 1; i++) {
            if (sorted.get(i) > sorted.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    // =========================================================================
    // Part 2：企業商業邏輯不變量實戰 (Enterprise Business Logic Invariants)
    // =========================================================================

    @Property
    @Label("示範 5 (企業金流守恆)：電商折扣後金額必不為負、不超過原價，且應付+折扣==原價")
    boolean orderDiscountBoundsAndConservation(
            @ForAll OrderDiscount.MemberType member,
            @ForAll @DoubleRange(min = 0.0, max = 100000.0) double amount,
            @ForAll OrderDiscount.PaymentMethod payment) {

        OrderDiscount.DiscountResult res = OrderDiscount.calculateDiscount(member, amount, payment);

        // 不變量 A：結帳金額絕不可為負數（防倒貼漏洞），且不可超過原價
        boolean withinBounds = res.finalAmount >= 0.0 && res.finalAmount <= amount;
        // 不變量 B：應付金額 + 總折抵金額 必恆等於 原始訂單金額（金流守恆定律）
        boolean conservation = Math.abs((res.finalAmount + res.discountAmount) - amount) < 1e-6;

        return withinBounds && conservation;
    }

    @Property
    @Label("示範 6 (企業等級單調性)：同金額與付款方式下，VIP 應付金額 <= 一般會員 <= 訪客")
    boolean membershipTierMonotonicity(
            @ForAll @DoubleRange(min = 0.0, max = 100000.0) double amount,
            @ForAll OrderDiscount.PaymentMethod payment) {

        double vipPay = OrderDiscount.calculateDiscount(OrderDiscount.MemberType.VIP, amount, payment).finalAmount;
        double regPay = OrderDiscount.calculateDiscount(OrderDiscount.MemberType.REGULAR, amount, payment).finalAmount;
        double guestPay = OrderDiscount.calculateDiscount(OrderDiscount.MemberType.GUEST, amount, payment).finalAmount;

        // 企業定價鐵律：高階會員永遠不可能比低階會員或訪客買得更貴（防止定價倒掛 Bug）
        return vipPay <= regPay && regPay <= guestPay;
    }

    @Property
    @Label("示範 7 (銀行風控不變量)：房貸利率必介於法定 2.0%~5.0%，且多貸 100 萬利率只降不升")
    boolean loanInterestRateFloorAndMonotonicity(
            @ForAll @IntRange(min = 1, max = 40) int years,
            @ForAll @DoubleRange(min = 100000.0, max = 50000000.0) double amount,
            @ForAll boolean isYouth,
            @ForAll boolean isMarried) {

        double baseRate = LoanCalculator.calculateInterestRate(years, amount, isYouth, isMarried);
        double moreLoanRate = LoanCalculator.calculateInterestRate(years, amount + 1000000.0, isYouth, isMarried);

        // 不變量 A：無論優惠如何疊加，核貸利率永遠鎖定在 [2.0%, 5.0%] 法定範圍內
        boolean withinLegalBounds = baseRate >= 2.0 && baseRate <= 5.0;
        // 不變量 B：額度優惠單調性 — 貸款金額增加時，利率只會更優惠或持平，絕不反升
        boolean monotonic = moreLoanRate <= baseRate;

        return withinLegalBounds && monotonic;
    }

    // =========================================================================
    // Part 3：測資收縮 (Shrinking) 企業實戰 — 自動抓出「滿額斷崖定價倒掛 Bug」
    // 💡 課堂操作：將下方 @Disabled 註解掉並執行，親眼觀察 jqwik 如何從隨機金額自動收縮出最小反例 amount = 2901！
    // =========================================================================
    @Disabled("💡 課堂演示 Shrinking 時請註解掉此行：觀察 jqwik 自動收縮找出滿 3000 折 300 的斷崖倒掛最小反例 (amount = 2901)")
    @Property(tries = 1000)
    @Label("示範 8 (Shrinking 抓漏實戰)：檢驗「多買 100 元商品，應付金額不應反而變少」")
    boolean shrinkingDemo_spendMoreShouldNotPayLess(
            @ForAll @IntRange(min = 100, max = 50000) int amount) {

        // 比較 VIP 買 amount 元 vs. 多買 100 元 (amount + 100) 的結帳金額：
        double payLessItems = OrderDiscount.calculateDiscount(
                OrderDiscount.MemberType.VIP, amount, OrderDiscount.PaymentMethod.CREDIT_CARD_ONE_TIME).finalAmount;
        double payMoreItems = OrderDiscount.calculateDiscount(
                OrderDiscount.MemberType.VIP, amount + 100, OrderDiscount.PaymentMethod.CREDIT_CARD_ONE_TIME).finalAmount;

        // 商業預期：多買 100 元商品，結帳總額應該 >= 原本金額
        // 💥 但因 >3000 元立減從 100 跳升至 300，當 amount = 2901 時：
        //    買 2901 元需付 2220.8 元，多買 100 元湊到 3001 元卻只要付 2100.8 元（多買反而少付 120 元）！
        //    jqwik 抽中隨機金額後，會透過 Shrinking 自動收縮並精準回報最小反例：amount = 2901！
        return payMoreItems >= payLessItems;
    }
}
