package u06_coverage;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import u05_combinatorial.pair.LoanCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit 06 Lab 3 練習：LoanCalculator.java 白箱分支涵蓋度分析 (Exercise)
 *
 * 實習手冊：LabDemo/docs/u06_wbtesting/whitebox_test.md
 * 說明：本檔案目前僅提供 1 組無優惠的基準測資（部分涵蓋度）。
 * 請先執行：
 *   mvn clean test -Dtest=LoanCalculatorCoverageExerciseTest jacoco:report
 * 觀察 JaCoCo 報告中哪些優惠條件與 2.0% 保底分支呈現紅色／黃色，
 * 逐步補齊測試案例直到 Branch Coverage 達到 100%！
 */
@DisplayName("Unit 06 Lab 3 練習：LoanCalculator 分支涵蓋度分析")
public class LoanCalculatorCoverageExerciseTest {

    @Test
    @DisplayName("TC1 (範例)：無任何優惠條件，維持基礎利率 5.0%")
    void testBaseRateWithoutAnyDiscount() {
        // 年限 <= 10、金額 <= 500 萬、非青年、未婚 ➔ 所有 if 皆走 False 分支
        double rate = LoanCalculator.calculateInterestRate(5, 3_000_000, false, false);
        assertEquals(5.0, rate);
    }

    // =========================================================================
    // TODO 1：補寫測試覆蓋「年限 > 10 年 (折 0.5%)」與「年限 > 20 年 (折 1.0%)」分支
    // 提示：觀察 if (year > 20) ... else if (year > 10) 的兩條 True 路徑
    // =========================================================================

    // =========================================================================
    // TODO 2：補寫測試覆蓋「金額 > 500 萬」、「青年優惠」與「已婚優惠」分支
    // 提示：例如 year=15, amount=8_000_000, isYouth=true, isMarried=true
    // =========================================================================

    // =========================================================================
    // TODO 3：補寫測試覆蓋「利率低於 2.0% 時強制保底 2.0%」防禦分支
    // 提示：將多項優惠疊加使原始利率 < 2.0%，斷言回傳精準鎖定為 2.0
    // =========================================================================
}
