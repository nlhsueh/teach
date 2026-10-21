package u05_input.pairwise;

import io.github.pavelicii.allpairs4j.AllPairs;
import io.github.pavelicii.allpairs4j.Case;
import io.github.pavelicii.allpairs4j.Parameter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 💡 課堂示範 (Demo 5.5)：全成對組合測試 (Pairwise / All-Pairs Testing)
 * 
 * 【教學核心觀念】：
 * 1. 組合爆炸挑戰：若 4 個參數分別有 3, 3, 2, 2 個水準，全乘積需要 3 * 3 * 2 * 2 = 36 個案例；
 *    若為 10 個變數各 3 水準，全組合將高達 3^10 = 59,049 個案例！
 * 2. NIST 研究精髓：70%~85% 的軟體缺陷是由單一或 2 個參數的交互作用所觸發 (2-Way Faults)。
 * 3. 成對測試保證：藉由 AllPairs4J 演算法，將案例數從 36 個高度壓縮至 10 餘個，
 *    但保證【任意兩個參數的所有可能取值組合】皆被 100% 覆蓋！
 */
@DisplayName("Unit 5.5 示範：貸款利率 AllPairs4J 全成對動態測試")
public class LoanCalculatorPairwiseDemoTest {

    @Test
    @DisplayName("示範 1：驗證 AllPairs 壓縮效益矩陣輸出")
    void testPairwiseMatrixGeneration() {
        List<Case> cases = buildLoanCases();

        System.out.println("==========================================================================");
        System.out.println("  [SQA Lab 5.5] AllPairs4J 全成對測試案例生成矩陣 (LoanCalculator)");
        System.out.println("==========================================================================");
        System.out.printf("%-6s | %-10s | %-12s | %-10s | %-10s%n", 
                "Case #", "貸款年限", "貸款金額(元)", "是否青年", "是否已婚");
        System.out.println("--------------------------------------------------------------------------");

        int index = 1;
        for (Case c : cases) {
            System.out.printf("#%-5d | %-10s | %-12s | %-10s | %-10s%n",
                    index++,
                    c.get("Years") + " 年",
                    c.get("Amount"),
                    c.get("IsYouth"),
                    c.get("IsMarried"));
        }
        System.out.println("==========================================================================");
        System.out.printf("👉 全乘積案例數: 3 × 3 × 2 × 2 = 36 組%n");
        System.out.printf("👉 全成對案例數: 僅需 %d 組即可達到 100%% 2-way 交互作用涵蓋！%n", cases.size());
        System.out.println("==========================================================================");

        // 驗證案例數大幅壓縮 (36 ➔ 遠小於 15)
        assertTrue(cases.size() <= 15, "成對案例總數應大幅小於全乘積 36 個案例");
    }

    @TestFactory
    @DisplayName("示範 2：JUnit 5 @TestFactory 動態成對執行與業務邊界斷言")
    List<DynamicTest> dynamicPairwiseTests() {
        List<Case> cases = buildLoanCases();

        return cases.stream().map(c -> {
            int year = Integer.parseInt(c.get("Years").toString());
            double amount = Double.parseDouble(c.get("Amount").toString());
            boolean isYouth = Boolean.parseBoolean(c.get("IsYouth").toString());
            boolean isMarried = Boolean.parseBoolean(c.get("IsMarried").toString());

            String testName = String.format("成對測試: 年限=%d年, 金額=%.0f, 青年=%b, 已婚=%b",
                    year, amount, isYouth, isMarried);

            return DynamicTest.dynamicTest(testName, () -> {
                double rate = LoanCalculator.calculateInterestRate(year, amount, isYouth, isMarried);

                // 核心業務合約不變量 (Invariants)：
                // 1. 任何優惠組合後，利率不可低於保底下限 2.0%
                assertTrue(rate >= 2.0, "利率不可低於法定下限 2.0%，目前算得: " + rate);

                // 2. 利率不可高於基準利率 5.0%
                assertTrue(rate <= 5.0, "利率不可高於基礎利率 5.0%，目前算得: " + rate);
            });
        }).collect(Collectors.toList());
    }

    /**
     * 構建 AllPairs 測試因子與水準定義
     */
    private static List<Case> buildLoanCases() {
        AllPairs allPairs = new AllPairs.AllPairsBuilder()
                .withParameter(new Parameter("Years", "5", "15", "25"))
                .withParameter(new Parameter("Amount", "4000000", "5500000", "7000000"))
                .withParameter(new Parameter("IsYouth", "true", "false"))
                .withParameter(new Parameter("IsMarried", "true", "false"))
                .build();
        return allPairs.getGeneratedCases();
    }
}
