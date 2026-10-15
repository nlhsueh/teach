package u04_utest;

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
 * 全成對測試 (Pairwise / All-Pairs Testing) 實戰示範
 * 
 * 採用開源成對生成框架 AllPairs4J，配合 JUnit 5 的 @TestFactory 動態測試，
 * 將本來需要 3 x 3 x 2 x 2 = 36 種全乘積案例，秒級壓縮至 10 餘個高覆蓋成對案例，
 * 保證所有雙參數（2-way）組合皆被 100% 涵蓋！
 */
public class LoanCalculatorPairwiseTest {

    @Test
    @DisplayName("驗證 AllPairs 矩陣壓縮效益（從 36 個全組合壓縮至 ~10 個成對案例）")
    void testPairwiseMatrixGeneration() {
        List<Case> cases = buildLoanCases();

        System.out.println("==========================================================================");
        System.out.println("  [SQA Lab] AllPairs4J 全成對測試案例生成矩陣 (LoanCalculator)");
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
        System.out.println("--------------------------------------------------------------------------");
        System.out.printf("👉 全乘積案例數: 3 × 3 × 2 × 2 = 36 組%n");
        System.out.printf("👉 全成對案例數: 僅需 %d 組即可達到 100%% 2-way 交互作用涵蓋！%n", cases.size());
        System.out.println("==========================================================================");

        assertTrue(cases.size() <= 12, "全成對測試案例數應大幅小於全乘積 36 個案例");
    }

    @TestFactory
    @DisplayName("動態執行 AllPairs 生成之所有成對貸款利率測試案例")
    List<DynamicTest> dynamicPairwiseLoanTests() {
        List<Case> cases = buildLoanCases();

        return cases.stream().map(testCase -> {
            int years = Integer.parseInt(testCase.get("Years").toString());
            double amount = Double.parseDouble(testCase.get("Amount").toString());
            boolean isYouth = Boolean.parseBoolean(testCase.get("IsYouth").toString());
            boolean isMarried = Boolean.parseBoolean(testCase.get("IsMarried").toString());

            String testTitle = String.format("成對測試: 年限=%d年, 金額=%.0f, 青年=%s, 已婚=%s",
                    years, amount, isYouth, isMarried);

            return DynamicTest.dynamicTest(testTitle, () -> {
                double actualRate = LoanCalculator.calculateInterestRate(years, amount, isYouth, isMarried);

                // 領域基本約束驗證
                assertTrue(actualRate >= 2.0, "貸款利率不可低於最低限制 2.0%");
                assertTrue(actualRate <= 5.0, "貸款利率不可高於基準利率 5.0%");

                // 預期值比對 (Oracle)
                double expectedRate = calculateExpectedRate(years, amount, isYouth, isMarried);
                assertEquals(expectedRate, actualRate, 0.0001, 
                        () -> String.format("利率計算錯誤！年限=%d, 金額=%.0f, 青年=%b, 已婚=%b", 
                                years, amount, isYouth, isMarried));
            });
        }).collect(Collectors.toList());
    }

    /**
     * 透過 AllPairsBuilder 定義因子與水準，啟動啟發式演算法生成測試矩陣
     */
    private List<Case> buildLoanCases() {
        AllPairs allPairs = new AllPairs.AllPairsBuilder()
                .withParameter(new Parameter("Years", "5", "15", "25"))
                .withParameter(new Parameter("Amount", "4000000", "5500000", "7000000"))
                .withParameter(new Parameter("IsYouth", "true", "false"))
                .withParameter(new Parameter("IsMarried", "true", "false"))
                .build();
        return allPairs.getGeneratedCases();
    }

    /**
     * 測試預期結果 (Oracle) 獨立計算邏輯
     */
    private double calculateExpectedRate(int years, double amount, boolean isYouth, boolean isMarried) {
        double baseRate = 5.0;
        double discount = 0.0;

        if (years > 20) {
            discount += 1.0;
        } else if (years > 10) {
            discount += 0.5;
        }

        if (amount >= 5_000_000) {
            double over = amount - 4_999_999;
            discount += Math.ceil(over / 1_000_000) * 0.1;
        }

        if (isYouth) {
            discount += 1.0;
        }

        if (isMarried) {
            discount += 0.5;
        }

        double finalRate = baseRate - discount;
        return Math.max(2.0, finalRate);
    }
}
