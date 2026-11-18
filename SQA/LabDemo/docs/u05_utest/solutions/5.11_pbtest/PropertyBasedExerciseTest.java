package u05_behavioral.pbtest;

import net.jqwik.api.*;
import net.jqwik.api.constraints.DoubleRange;
import net.jqwik.api.constraints.IntRange;
import u05_combinatorial.pair.LoanCalculator;

import java.util.List;

/**
 * 🧪 課堂動手練習 (Exercise 5.11-A 標準解答)：屬性基礎測試 (PBT) 不變量實作（含企業商業邏輯）
 */
public class PropertyBasedExerciseTest {

    @Property
    @Label("練習 1：乘法交換律不變量驗證")
    boolean exercise1_multiplicationIsCommutative(@ForAll int a, @ForAll int b) {
        return MathFunctions.multiply(a, b) == MathFunctions.multiply(b, a);
    }

    @Property
    @Label("練習 2：反轉後清單長度守恆不變量")
    boolean exercise2_reversedListLengthInvariant(@ForAll List<Integer> list) {
        List<Integer> reversed = MathFunctions.reverse(list);
        return list.size() == reversed.size();
    }

    @Property
    @Label("練習 3 (企業邏輯)：青年首購房貸利率單調性與法定保底 2.0% 不變量")
    boolean exercise3_youthLoanDiscountMonotonicity(
            @ForAll @IntRange(min = 1, max = 40) int years,
            @ForAll @DoubleRange(min = 100000.0, max = 30000000.0) double amount,
            @ForAll boolean isMarried) {
        double youthRate = LoanCalculator.calculateInterestRate(years, amount, true, isMarried);
        double normalRate = LoanCalculator.calculateInterestRate(years, amount, false, isMarried);
        return youthRate <= normalRate && youthRate >= 2.0;
    }
}
