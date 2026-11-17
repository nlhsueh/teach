package u06_coverage;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit 06 白箱測試實作：GradeAverage.java 基本路徑測試 (Basis Path Testing)
 *
 * 實習手冊：LabDemo/docs/u06_wbtesting/metrics.md
 * 圈複雜度 V(G) = P + 1 = 5 + 1 = 6，對應 6 條線性獨立路徑（其中 Path 1 為不可行路徑）
 */
public class GradeAverageBasisPathTest {

    GradeAverage ga = new GradeAverage();

    @Test
    @DisplayName("Path 2: 首筆即結束符號，valid = 0 (1 -> 2 -> 9 -> 11 -> 12)")
    void testPath2_ImmediatelyEnd() {
        int[] grade = {-999};
        assertEquals(-999.0, ga.computeAverage(grade));
    }

    @Test
    @DisplayName("Path 3: 超過 50 筆成績，觸發 index < 50 為 False 跳出 (1 -> 2 -> 3 -> 9 -> ...)")
    void testPath3_Exceed50Items() {
        int[] grade = new int[52];
        for (int i = 0; i < 50; i++) {
            grade[i] = 80;
        }
        grade[50] = 90;
        grade[51] = -999;
        assertEquals(80.0, ga.computeAverage(grade));
    }

    @Test
    @DisplayName("Path 4: 成績低於下限 min(10)，觸發錯誤分支 (1 -> 2 -> 3 -> 4 -> 7 -> 8 -> 2...)")
    void testPath4_BelowMin() {
        int[] grade = {5, -999}; // 5 < 10
        assertEquals(-999.0, ga.computeAverage(grade));
    }

    @Test
    @DisplayName("Path 5: 成績高於上限 max(100)，觸發錯誤分支 (1 -> 2 -> 3 -> 4 -> 5 -> 7 -> 8 -> 2...)")
    void testPath5_AboveMax() {
        int[] grade = {105, -999}; // 105 > 100
        assertEquals(-999.0, ga.computeAverage(grade));
    }

    @Test
    @DisplayName("Path 6: 正常累加有效成績並計算平均 (1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 8 -> 2 -> 9 -> 10 -> 12)")
    void testPath6_NormalValidGrades() {
        int[] grade = {80, 90, -999};
        assertEquals(85.0, ga.computeAverage(grade));
    }
}
