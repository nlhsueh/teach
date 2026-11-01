package u05_pbtest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 🧪 課堂動手練習 (Exercise 5.11-B)：變質測試 (MT) 關係驗證實作
 * 
 * 請閱讀【提示 (Hints)】，參考註解中的提示語法，
 * 親手打出程式碼並移除 fail(...) 以通過測試。
 */
@DisplayName("Unit 5.11 練習：搜尋引擎大小寫不敏感變質關係測試")
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
        // TODO: 請建立全大寫關鍵字 "SOFTWARE" 並呼叫 searchEngine.search(...)：
        // String queryUpper = "SOFTWARE";
        // List<String> resultsUpper = searchEngine.search(queryUpper);

        // [MR Verification]
        // TODO: 請使用 assertEquals 斷言 resultsLower 與 resultsUpper 完全相等，完成後刪除 fail(...)：
        // assertEquals(resultsLower, resultsUpper,
        //         "變質關係違反：搜尋關鍵字大小寫不應改變搜尋結果！");
        fail("尚未完成練習：請搜尋全大寫關鍵字並斷言與小寫搜尋結果一致");
    }
}
