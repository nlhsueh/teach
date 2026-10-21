package u05_pbtest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 💡 課堂示範 (Demo 5.9-B)：變質測試 (Metamorphic Testing, MT)
 * 
 * 【教學核心觀念】：
 * 1. 突破 Test Oracle 困境：當難以事先得知絕對答案時，改為檢驗輸入變換前後的「相對變質關係 (MR)」。
 * 2. 搜尋引擎包含性變質關係 (MR_Inclusion)：
 *    - 若查詢條件 A 是查詢條件 B 的子字串（例如 "Java" vs "Java SQA"）；
 *    - 則搜尋結果集合必滿足：Search("Java SQA") ⊆ Search("Java")！
 * 3. 獨立抗擾動性變質關係 (MR_Irrelevant)：
 *    - 搜尋關鍵字前後若加上不相干的空格（如 " Java "），回傳之文件集合數量與內容必須完全相同。
 */
@DisplayName("Unit 5.9 示範：文章搜尋引擎之變質關係 (MR) 測試")
public class MetamorphicDemoTest {

    private MetamorphicSearch searchEngine;

    @BeforeEach
    void setUp() {
        searchEngine = new MetamorphicSearch();
        searchEngine.addDocument("Modern Software Quality Assurance and Testing in Java");
        searchEngine.addDocument("Java Programming Language and JUnit 5 Guide");
        searchEngine.addDocument("Python for Data Science and Machine Learning");
        searchEngine.addDocument("Advanced SQA Verification with Property-Based Testing");
    }

    @Test
    @DisplayName("變質關係 1 (包含與單調性 MR_Inclusion)：複合關鍵字結果必為寬鬆關鍵字之子集")
    void testMetamorphicRelation_inclusion() {
        // 1. 原始輸入與執行 (Source Execution)
        String query1 = "Java";
        List<String> results1 = searchEngine.search(query1);

        // 2. 衍生變換輸入與執行 (Follow-up Execution)
        String query2 = "Java SQA";
        List<String> results2 = searchEngine.search(query2);

        // 3. 變質關係驗證 (MR Verification): results2 必然包含於 results1
        assertTrue(results1.containsAll(results2),
                "變質關係違反：搜尋 'Java SQA' 的結果必須是搜尋 'Java' 結果的子集！");
    }

    @Test
    @DisplayName("變質關係 2 (獨立抗擾動性 MR_Irrelevant)：前後空白擾動不應影響搜尋結果集合")
    void testMetamorphicRelation_irrelevantPerturbation() {
        // 1. 原始輸入
        String querySource = "SQA";
        List<String> sourceResults = searchEngine.search(querySource);

        // 2. 注入擾動輸入 (在關鍵字前後加空白)
        String queryPerturbed = "   SQA   ";
        List<String> perturbedResults = searchEngine.search(queryPerturbed);

        // 3. 驗證變質關係：結果集合完全等價
        assertEquals(sourceResults, perturbedResults,
                "變質關係違反：首尾空白屬於無關擾動，搜尋結果應該完全一致！");
    }
}
