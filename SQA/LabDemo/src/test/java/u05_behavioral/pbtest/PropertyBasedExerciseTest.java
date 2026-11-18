package u05_behavioral.pbtest;

import net.jqwik.api.*;
import net.jqwik.api.constraints.DoubleRange;
import net.jqwik.api.constraints.IntRange;
import u05_combinatorial.pair.LoanCalculator;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 🧪 課堂動手練習 (Exercise 5.11-A)：屬性基礎測試 (PBT) 不變量實作（含企業商業邏輯）
 * 
 * 請閱讀【提示 (Hints)】，參考註解中的提示語法，
 * 親手打出程式碼並移除 fail(...) 以通過測試。
 */
public class PropertyBasedExerciseTest {

    // =========================================================================
    // 💡 練習 1 提示 (Hints)：乘法交換律不變量 (a * b == b * a)
    // 1. 使用 @Property 與 @ForAll 隨機注入整數 a 與 b。
    // 2. 驗證 MathFunctions.multiply(a, b) 是否等於 MathFunctions.multiply(b, a)。
    // =========================================================================
    @Property
    @Label("練習 1：乘法交換律不變量驗證")
    boolean exercise1_multiplicationIsCommutative(@ForAll int a, @ForAll int b) {
        // TODO: 請驗證 a * b 是否恆等於 b * a，完成後刪除 fail(...)：
        // return MathFunctions.multiply(a, b) == MathFunctions.multiply(b, a);
        fail("尚未完成練習 1：請回傳 MathFunctions.multiply(a, b) == MathFunctions.multiply(b, a)");
        return false;
    }

    // =========================================================================
    // 💡 練習 2 提示 (Hints)：反轉串列長度守恆性質
    // 對任意整數清單 L，其反轉後串列 reverse(L) 的元素數量必恆等於原串列長度！
    // =========================================================================
    @Property
    @Label("練習 2：反轉後清單長度守恆不變量")
    boolean exercise2_reversedListLengthInvariant(@ForAll List<Integer> list) {
        // TODO: 請呼叫 MathFunctions.reverse(list) 並驗證長度是否相等，完成後刪除 fail(...)：
        // List<Integer> reversed = MathFunctions.reverse(list);
        // return list.size() == reversed.size();
        fail("尚未完成練習 2：請呼叫 MathFunctions.reverse(list) 並驗證反轉前後 size() 相等");
        return false;
    }

    // =========================================================================
    // 💡 練習 3 提示 (Hints)：企業商業邏輯 — 銀行房貸「青年首購優惠單調性與保底 2.0%」不變量
    // 對任意貸款年限 (1~40年)、任意金額 (10萬~3000萬) 與婚姻狀態：
    // 1. 具備青年首購資格 (isYouth = true) 的核貸利率 youthRate，必定 <= 非青年 (isYouth = false) 的 normalRate！
    // 2. 且 youthRate 永遠不可低於法定保底利率 2.0%！
    // =========================================================================
    @Property
    @Label("練習 3 (企業邏輯)：青年首購房貸利率單調性與法定保底 2.0% 不變量")
    boolean exercise3_youthLoanDiscountMonotonicity(
            @ForAll @IntRange(min = 1, max = 40) int years,
            @ForAll @DoubleRange(min = 100000.0, max = 30000000.0) double amount,
            @ForAll boolean isMarried) {
        // TODO: 請分別計算 isYouth=true 與 isYouth=false 的利率，驗證 youthRate <= normalRate 且 youthRate >= 2.0，完成後刪除 fail(...)：
        // double youthRate = LoanCalculator.calculateInterestRate(years, amount, true, isMarried);
        // double normalRate = LoanCalculator.calculateInterestRate(years, amount, false, isMarried);
        // return youthRate <= normalRate && youthRate >= 2.0;
        fail("尚未完成練習 3：請驗證青年首購利率 <= 一般申貸利率 且 >= 2.0%");
        return false;
    }
}
