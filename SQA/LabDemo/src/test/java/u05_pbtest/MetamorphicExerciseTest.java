package u05_pbtest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 🧪 課堂動手練習 (Exercise 5.9-B)：變質測試 (MT) 關係驗證實作
 * 
 * 請閱讀【提示 (Hints)】，補全 // TODO 標記處的程式碼以通過測試。
 */
@DisplayName("Unit 5.9 練習：搜尋引擎大小寫不敏感變質關係測試")
public class MetamorphicExerciseTest {

    private MetamorphicSearch searchEngine;

    @BeforeEach
    void setUp() {
        searchEngine = new MetamorphicSearch();
        searchEngine.addDocument("Software Engineering with Design Patterns");
        searchEngine.addDocument("Modern SQA Testing Techniques");
        searchEngine.addDocument("Cloud Computing Architecture");
    }

    // =========================================================================
    // 💡 練習提示 (Hints)：對稱性變質關係 (MR_Symmetry)
    // 1. 搜尋引擎應具備大小寫不敏感 (Case-Insensitivity) 的性質。
    // 2. 原始輸入：q1 = "software"
    // 3. 變質輸入：q2 = "SOFTWARE" 或 "SoFtWaRe"
    // 4. 變質關係判定：Search(q1) 的結果清單必須與 Search(q2) 完全一致！
    // =========================================================================
    @Test
    @DisplayName("練習：驗證關鍵字大小寫切換之對稱性變質關係")
    void exercise_testCaseInsensitivitySymmetry() {
        // [Source Execution]
        String queryLower = "software";
        List<String> resultsLower = searchEngine.search(queryLower);

        // [Follow-up Execution]
        // TODO: 建立全大寫關鍵字並呼叫 search
        String queryUpper = "SOFTWARE";
        List<String> resultsUpper = searchEngine.search(queryUpper);

        // [MR Verification]
        // TODO: 斷言兩者結果集合完全相等
        assertEquals(resultsLower, resultsUpper,
                "變質關係違反：搜尋關鍵字大小寫不應改變搜尋結果！");
    }
}
