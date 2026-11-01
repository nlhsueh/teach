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
 * 🧪 課堂動手練習 (Exercise 5.5)：全成對測試組合與邊界驗證練習
 * 
 * 請閱讀【提示 (Hints)】，參考註解中的提示語法，
 * 親手打出程式碼並移除 fail(...) 以通過測試。
 */
@DisplayName("Unit 5.5 練習：全成對組合測試練習題")
public class LoanCalculatorPairwiseExerciseTest {

    // =========================================================================
    // 💡 練習 1 提示 (Hints)：驗證極限優惠組合是否正確觸發 2.0% 下限鎖定
    // 1. 若年限 25 年 (折 1.0%)
    // 2. 金額 2,500 萬 (超過 500 萬達 2,000 萬 ➔ 折 2.0%)
    // 3. 青年 (折 1.0%) 且 已婚 (折 0.5%)
    // 4. 原始計算：5.0 - 1.0 - 2.0 - 1.0 - 0.5 = 0.5%
    // 5. 但規格明確限制【保底下限為 2.0%】！
    // =========================================================================
    @Test
    @DisplayName("練習 1：驗證各項優惠累加超過上限時，利率精準保底 2.0%")
    void exercise1_testExtremeDiscountBoundary() {
        // [Arrange]
        int year = 25;
        double amount = 25000000; // 2500 萬
        boolean isYouth = true;
        boolean isMarried = true;

        // [Act & Assert]
        // TODO: 請呼叫 LoanCalculator.calculateInterestRate 並斷言回傳利率精準等於 2.0，完成後刪除 fail(...)：
        // double rate = LoanCalculator.calculateInterestRate(year, amount, isYouth, isMarried);
        // assertEquals(2.0, rate, "即使多項優惠累加，利率亦不得低於保底 2.0%");
        fail("尚未完成練習 1：請呼叫 calculateInterestRate 並斷言利率保底為 2.0");
    }

    // =========================================================================
    // 💡 練習 2 提示 (Hints)：使用 AllPairs4J 自行構建 3 因子成對生成矩陣
    // 1. 因子 A (Years): "3", "12", "30"
    // 2. 因子 B (IsYouth): "true", "false"
    // 3. 因子 C (IsMarried): "true", "false"
    // 4. 全乘積為 3 * 2 * 2 = 12 組，成對壓縮後應只有 6 組案例！
    // =========================================================================
    @TestFactory
    @DisplayName("練習 2：動態生成 3 因子成對測試套件")
    List<DynamicTest> exercise2_testCustomPairwiseFactory() {
        // TODO: 請參考下方註解，使用 AllPairs.AllPairsBuilder 設定 3 個 Parameter，
        // 並將生成的 Case 轉換為 DynamicTest 清單：
        // AllPairs allPairs = new AllPairs.AllPairsBuilder()
        //         .withParameter(new Parameter("Years", "3", "12", "30"))
        //         .withParameter(new Parameter("IsYouth", "true", "false"))
        //         .withParameter(new Parameter("IsMarried", "true", "false"))
        //         .build();
        //
        // return allPairs.getGeneratedCases().stream().map(c -> {
        //     int year = Integer.parseInt(c.get("Years").toString());
        //     boolean isYouth = Boolean.parseBoolean(c.get("IsYouth").toString());
        //     boolean isMarried = Boolean.parseBoolean(c.get("IsMarried").toString());
        //     return DynamicTest.dynamicTest("測試年限: " + year + "年, 青年: " + isYouth, () -> {
        //         double rate = LoanCalculator.calculateInterestRate(year, 3000000, isYouth, isMarried);
        //         assertTrue(rate >= 2.0 && rate <= 5.0, "計算出之利率必須介於 2.0% ~ 5.0% 之間");
        //     });
        // }).collect(Collectors.toList());
        return List.of(
                DynamicTest.dynamicTest("尚未完成練習 2", () ->
                        fail("尚未完成練習 2：請使用 AllPairsBuilder 建立 3 因子成對測試"))
        );
    }
}
