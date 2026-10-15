# 全成對組合測試 (Pairwise / All-Pairs Testing) 實戰手冊

---

## 1. 核心觀念：打破組合爆炸的魔咒

當被測系統具備多個輸入參數或設定開關時，所有可能的輸入全組合（Cartesian Product，笛卡爾積）會以指數級暴增：
$$N = v_1 \times v_2 \times \dots \times v_k$$

例如一個包含 10 個參數、每個參數有 3 種狀態的模組，窮盡測試需要 $3^{10} = \mathbf{59,049}$ 個測試案例！

### 🎯 NIST 實證研究與 2-Way 交互作用理論
美國國家標準與技術研究院 (NIST) 針對醫療、航太、國防與伺服器軟體進行廣泛缺陷調查發現：
* **67% ~ 93%** 的軟體缺陷是由「**單一參數**」或「**任意兩個參數之交互作用 (2-Way Interaction)**」所引發。
* 需要 3 個以上參數同時交互才會觸發的缺陷極為罕見（不到 10%）。

**全成對測試 (Pairwise / All-Pairs Testing) 原則**：  
> **確保受測系統中「任意兩個參數」的所有可能取值組合，在整個測試案例集中「至少出現過一次」。**  
> 如此可將案例數從幾萬組急劇縮減至數十組，卻能攔截 90% 以上的潛在交互缺陷！

---

## 2. 深入理解：為什麼求解最小成對測試集是 NP-Hard？

許多工程師初學時會問：「既然要最少測試案例，為什麼工具不用數學直接算出『絕對最小數量』？」

### 📐 數學歸約：最小集合覆蓋問題 (Minimum Set Cover)
1. **問題定義**：
   - 設系統有 $k$ 個參數，總共會產生 $U = \sum_{1 \le i < j \le k} (|V_i| \times |V_j|)$ 個需要被覆蓋的參數對（Pairs）。
   - 每個完整的測試案例（Test Vector）可以同時覆蓋 $\binom{k}{2}$ 個特定參數對。
   - 目標是：**從所有可能的候選測試向量中，挑選出數量最少的子集，使其聯集恰好包含集合 $U$ 中的所有成對組合。**
2. **複雜度結論**：
   - 此問題在計算複雜度理論中完全等價於經典的 **最小集合覆蓋問題 (Minimum Set Cover Problem)**，已被證明屬於 **NP-Complete / NP-Hard**。
   - 當參數數量 $k$ 與水準數增加時，窮舉搜尋全域絕對最佳解（Global Optimum）的時間複雜度呈指數級爆炸，在實務上根本不可行。

### ⚡ 現代工具的啟發式求解策略 (Heuristics)
因此，現代成對測試工具（如微軟 PICT、NIST ACTS、Java AllPairs4J）皆採用**貪婪啟發式演算法 (Greedy / AETG / IPO - In-Parameter-Order)**：
- **核心思維**：在每輪挑選下一個測試案例時，貪婪地選取「能同時覆蓋最多尚未被滿足之成對組合（Uncovered Pairs）」的向量。
- **計算效益**：將計算時間降至多項式時間（秒級內完成），產出的測試集合極度逼近理論下限，性價比極高。
- **約束剪枝 (Constraint Handling)**：遇到互斥規則（如 `OS == "iOS"` 時不可配 `Browser == "IE"`）時，透過 SAT/SMT 求解器即時修剪非法空間。

---

## 3. Java 實戰：AllPairs4J + JUnit 5 動態測試

在 Java 生態系中，**[AllPairs4J](https://github.com/pavelicii/allpairs4j)** 是一套開源、純 Java、無須安裝外部 native binary 的成對生成框架，能與 JUnit 5 的 `@TestFactory` 和 `DynamicTest` 無縫整合。

### 3.1 Maven 依賴配置 (`pom.xml`)
```xml
<!-- AllPairs4J for Pairwise Combinatorial Testing -->
<dependency>
    <groupId>io.github.pavelicii</groupId>
    <artifactId>allpairs4j</artifactId>
    <version>2.0.0</version>
    <scope>test</scope>
</dependency>
```

### 3.2 房貸利率計算器 (LoanCalculator) 案例背景
受測方法 `LoanCalculator.calculateInterestRate(loanYears, loanAmount, isYouth, isMarried)` 具備 4 個維度：
- **貸款年限 (Years)**：5 年、15 年、25 年 (3 種)
- **貸款金額 (Amount)**：400 萬、550 萬、700 萬 (3 種)
- **青年優惠 (IsYouth)**：true、false (2 種)
- **婚姻狀態 (IsMarried)**：true、false (2 種)

若採用笛卡爾全乘積：$3 \times 3 \times 2 \times 2 = \mathbf{36}$ 組案例。  
透過 **AllPairs4J** 壓縮後：僅需 **9 組成對案例**！

### 3.3 JUnit 5 動態成對測試程式碼
位於本專案：`src/test/java/u04_utest/LoanCalculatorPairwiseTest.java`

```java
package u04_utest;

import io.github.pavelicii.allpairs4j.AllPairs;
import io.github.pavelicii.allpairs4j.Case;
import io.github.pavelicii.allpairs4j.Parameter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.List;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

public class LoanCalculatorPairwiseTest {

    @TestFactory
    @DisplayName("動態執行 AllPairs 生成之成對貸款利率測試案例")
    List<DynamicTest> dynamicPairwiseLoanTests() {
        // 1. 定義因子 (Factors) 與水準 (Levels)
        AllPairs allPairs = new AllPairs.AllPairsBuilder()
                .withParameter(new Parameter("Years", "5", "15", "25"))
                .withParameter(new Parameter("Amount", "4000000", "5500000", "7000000"))
                .withParameter(new Parameter("IsYouth", "true", "false"))
                .withParameter(new Parameter("IsMarried", "true", "false"))
                .build();

        // 2. 將成對案例投影為 JUnit 5 DynamicTest
        return allPairs.getGeneratedCases().stream().map(c -> {
            int years = Integer.parseInt(c.get("Years").toString());
            double amount = Double.parseDouble(c.get("Amount").toString());
            boolean isYouth = Boolean.parseBoolean(c.get("IsYouth").toString());
            boolean isMarried = Boolean.parseBoolean(c.get("IsMarried").toString());

            String title = String.format("成對案例: 年限=%d, 金額=%.0f, 青年=%s, 已婚=%s",
                    years, amount, isYouth, isMarried);

            return DynamicTest.dynamicTest(title, () -> {
                double rate = LoanCalculator.calculateInterestRate(years, amount, isYouth, isMarried);
                assertTrue(rate >= 2.0 && rate <= 5.0, "利率應介於合法區間 2.0% ~ 5.0%");
            });
        }).collect(Collectors.toList());
    }
}
```

### 3.4 執行測試
```bash
mvn test -Dtest=LoanCalculatorPairwiseTest
```

---

## 4. 業界主流命令列工具：Microsoft PICT 對照

若在 CI/CD 腳本或多語言環境中，微軟開源的 **PICT (Pairwise Independent Combinatorial Tool)** 是工業界最普及的標準工具。

### 4.1 模型檔定義 (`loan_calculator.pict`)
位於本專案：`src/test/resources/pairwise/loan_calculator.pict`
```text
Years: 5, 15, 25
Amount: 4000000, 5500000, 7000000
IsYouth: true, false
IsMarried: true, false

# 支援自訂約束條件（若有業務互斥）：
# IF [Years] = 25 THEN [Amount] > 4000000;
```

### 4.2 執行 PICT 生成矩陣
```bash
# 安裝 (macOS: brew install pict / Windows: choco install pict)
pict src/test/resources/pairwise/loan_calculator.pict
```
產出結果將以 Tab 分隔矩陣輸出，可直接匯入 Excel 或轉為 CSV 餵入參數化測試。
