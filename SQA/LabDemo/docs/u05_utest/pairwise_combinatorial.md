# 全成對組合測試 (Pairwise / All-Pairs Testing) 實戰手冊

> 📂 **本單元程式碼專屬目錄 (`u05_pair`)**：
> - **待測主程式**：[`src/main/java/u05_pair/`](../../src/main/java/u05_pair/)（`SwimmingPoolPricing.java`、`LoanCalculator.java`）
> - **示範與練習測試**：[`src/test/java/u05_pair/`](../../src/test/java/u05_pair/)（`SwimmingPoolPairwiseDemoTest.java`、`LoanCalculatorPairwiseDemoTest.java`、`LoanCalculatorPairwiseExerciseTest.java`）

---

## 1. 核心觀念：打破組合爆炸的魔咒

當被測系統具備多個輸入參數或設定開關時，所有可能的輸入全組合（Cartesian Product，笛卡爾積）會以指數級暴增：
> **N = |V<sub>1</sub>| × |V<sub>2</sub>| × ... × |V<sub>k</sub>|**

例如一個包含 10 個參數、每個參數有 3 種狀態的模組，窮盡測試需要 **3<sup>10</sup> = 59,049** 個測試案例！

### 🎯 NIST 實證研究與 2-Way 交互作用理論
美國國家標準與技術研究院 (NIST) 針對醫療、航太、國防與伺服器軟體進行廣泛缺陷調查發現：
* **67% ~ 93%** 的軟體缺陷是由「**單一參數**」或「**任意兩個參數之交互作用 (2-Way Interaction)**」所引發。
* 需要 3 個以上參數同時交互才會觸發的缺陷極為罕見（不到 10%）。

**全成對測試 (Pairwise / All-Pairs Testing) 原則**：  
> **確保受測系統中「任意兩個參數」的所有可能取值組合，在整個測試案例集中「至少出現過一次」。**  
> 如此可將案例數從幾萬組急劇縮減至數十組，卻能攔截 90% 以上的潛在交互缺陷！

---

## 2. 深入理解：為什麼最小成對測試集是 NP-Hard？如何一步步推導？

許多工程師初學時會問：「既然要最少測試案例，為什麼工具不用數學直接算出『絕對最小數量』？」

### 📐 數學歸約：最小集合覆蓋問題 (Minimum Set Cover)
1. **問題定義**：
   - 設系統有 k 個參數，總共會產生 **|U| = ∑ (|V<sub>i</sub>| × |V<sub>j</sub>|)** 個需要被覆蓋的參數對（Pairs）。
   - 每個完整的測試案例（Test Vector）最多可以同時覆蓋 **C(k, 2)** 個特定參數對。
   - 目標是：**從所有可能的候選測試向量中，挑選出數量最少的子集，使其聯集恰好包含母集合 U 中的所有成對組合。**
2. **複雜度結論與啟發式演算法 (Greedy / IPO)**：
   - 此問題在計算複雜度理論中等價於經典的 **最小集合覆蓋問題 (Minimum Set Cover Problem)**，屬於 **NP-Complete / NP-Hard**。
   - 因此，現代成對測試工具（如 Java **AllPairs4J**、微軟 **PICT**、NIST **ACTS**）皆採用**貪婪啟發式演算法 (Greedy / AETG / IPO)**：每輪挑選下一個測試案例時，貪婪地選取「能同時消去最多尚未覆蓋之成對組合（Uncovered Pairs）」的參數值。

---

## 3. 演算法步進推導範例：游泳池收費系統 (`SwimmingPoolPricing`)

對應教材與投影片的經典範例（實作於 [`src/main/java/u05_pair/SwimmingPoolPricing.java`](../../src/main/java/u05_pair/SwimmingPoolPricing.java)）：
* **時間 (T, 3 種)**：t<sub>1</sub> 清晨 (`MORNING`), t<sub>2</sub> 中午 (`NOON`), t<sub>3</sub> 其他 (`OTHER`)
* **星期 (D, 2 種)**：d<sub>1</sub> 假日 (`HOLIDAY`), d<sub>2</sub> 平日 (`WEEKDAY`)
* **會員 (M, 2 種)**：m<sub>1</sub> 會員 (`true`), m<sub>2</sub> 非會員 (`false`)
* **全乘積需求**：3 × 2 × 2 = **12 個案例**。

### Step 1：盤點待覆蓋母集合 U (共 16 個 Pairs)
* **T × D (3 × 2 = 6 組)**：(t<sub>1</sub>,d<sub>1</sub>), (t<sub>1</sub>,d<sub>2</sub>), (t<sub>2</sub>,d<sub>1</sub>), (t<sub>2</sub>,d<sub>2</sub>), (t<sub>3</sub>,d<sub>1</sub>), (t<sub>3</sub>,d<sub>2</sub>)
* **T × M (3 × 2 = 6 組)**：(t<sub>1</sub>,m<sub>1</sub>), (t<sub>1</sub>,m<sub>2</sub>), (t<sub>2</sub>,m<sub>1</sub>), (t<sub>2</sub>,m<sub>2</sub>), (t<sub>3</sub>,m<sub>1</sub>), (t<sub>3</sub>,m<sub>2</sub>)
* **D × M (2 × 2 = 4 組)**：(d<sub>1</sub>,m<sub>1</sub>), (d<sub>1</sub>,m<sub>2</sub>), (d<sub>2</sub>,m<sub>1</sub>), (d<sub>2</sub>,m<sub>2</sub>)
* **總待覆蓋數**：6 + 6 + 4 = **16 個 Pairs**。
* **單一案例最大效益**：每挑 1 個案例 `(t, d, m)` 最多能一次消去 **C(3, 2) = 3 個 Pair**，理論最小下界至少需 max(3×2, ⌈16/3⌉) = **6 個案例**。

### Step 2：每一輪的選擇條件（IPO 基底展開 + Greedy 貪婪計分）

許多同學會好奇：**「為什麼第 1 輪要先選 `(t1, d1, m1)`？為什麼第 2 輪會變成 `(t1, d2, m2)`？」**  
在標準的成對演算法（如 **IPO, In-Parameter-Order** 結合 **Greedy 貪婪覆蓋**）中，每一輪挑選遵循以下**兩個明確條件**：

1. **條件一（決定前兩欄 `T, D`）：先展開成對基底（Base Grid）**
   - 挑出取值數量最多的前兩個參數 **時間 T (3 種)** 與 **星期 D (2 種)**，直接將兩者的笛卡爾積展開為 **3 × 2 = 6 列必備基底**：
     `(t1, d1) ➔ (t1, d2) ➔ (t2, d1) ➔ (t2, d2) ➔ (t3, d1) ➔ (t3, d2)`。
   - 這樣能優先確保 `T × D` 的 6 個成對組合 100% 不遺漏。
2. **條件二（決定第三欄 `M`）：候選值 `m1` vs. `m2` 貪婪計分 PK**
   - 在每一列固定 `(t_i, d_j)` 後，比較填入 `m1`（會員）與 `m2`（非會員）分別能**新消去幾個「尚未出現過的 Pair」**：
   - **高分者勝出**：優先選能消去更多未覆蓋 Pair 的值。
   - **平手決策（Tie-Breaking）**：若 `m1` 與 `m2` 新增的未覆蓋 Pair 數相同，則依參數定義順序先選第一個值 **`m1`**。

| 輪次 | 基底 (T, D) | 候選 `m1` vs. `m2` 貪婪計分比較（本輪新消去 Pair 數） | 勝出測試案例 | 累計覆蓋進度 |
| :---: | :---: | :--- | :---: | :---: |
| **1** | **(t<sub>1</sub>, d<sub>1</sub>)** | • 選 `m1`：消去 `(t₁,d₁), (t₁,m₁), (d₁,m₁)` ➔ **+3 組**<br>• 選 `m2`：消去 `(t₁,d₁), (t₁,m₂), (d₁,m₂)` ➔ **+3 組**<br>👉 **平手（皆 +3），依預設順序先選 `m1`** | **(t<sub>1</sub>, d<sub>1</sub>, m<sub>1</sub>)** | 3 / 16 |
| **2** | **(t<sub>1</sub>, d<sub>2</sub>)** | • 若選 `m1`：`(t₁,m₁)` **已於第 1 輪出現過（重複！）**，僅新增 `(t₁,d₂), (d₂,m₁)` ➔ **+2 組**<br>• 若選 `m2`：一次消去全新 `(t₁,d₂), (t₁,m₂), (d₂,m₂)` ➔ **+3 組**<br>👉 **`m2` (+3) > `m1` (+2)，貪婪必選 `m2`** | **(t<sub>1</sub>, d<sub>2</sub>, m<sub>2</sub>)** | 6 / 16 |
| **3** | **(t<sub>2</sub>, d<sub>1</sub>)** | • 若選 `m1`：`(d₁,m₁)` **已於第 1 輪出現過（重複！）**，僅新增 `(t₂,d₁), (t₂,m₁)` ➔ **+2 組**<br>• 若選 `m2`：一次消去全新 `(t₂,d₁), (t₂,m₂)` 及未覆蓋的 `(d₁,m₂)` ➔ **+3 組**<br>👉 **`m2` (+3) > `m1` (+2)，貪婪必選 `m2`** | **(t<sub>2</sub>, d<sub>1</sub>, m<sub>2</sub>)** | 9 / 16 |
| **4** | **(t<sub>2</sub>, d<sub>2</sub>)** | • 若選 `m1`：一次消去全新 `(t₂,d₂), (t₂,m₁)` 及最後一組 `(d₂,m₁)` ➔ **+3 組**<br>• 若選 `m2`：`(t₂,m₂)` 與 `(d₂,m₂)` 皆已出現過，僅新增 `(t₂,d₂)` ➔ **+1 組**<br>👉 **`m1` (+3) > `m2` (+1)，貪婪必選 `m1`** *(至此 `D×M` 4 組已全滿)* | **(t<sub>2</sub>, d<sub>2</sub>, m<sub>1</sub>)** | 12 / 16 |
| **5** | **(t<sub>3</sub>, d<sub>1</sub>)** | • 選 `m1`：新增 `(t₃,d₁), (t₃,m₁)` ➔ **+2 組**<br>• 選 `m2`：新增 `(t₃,d₁), (t₃,m₂)` ➔ **+2 組**<br>👉 **`D×M` 已全數覆蓋，兩者平手（皆 +2），依序先選 `m1`** | **(t<sub>3</sub>, d<sub>1</sub>, m<sub>1</sub>)** | 14 / 16 |
| **6** | **(t<sub>3</sub>, d<sub>2</sub>)** | • 若選 `m1`：`(t₃,m₁)` 已於第 5 輪重複，僅新增 `(t₃,d₂)` ➔ **+1 組**<br>• 若選 `m2`：補齊最後兩組 `(t₃,d₂), (t₃,m₂)` ➔ **+2 組**<br>👉 **`m2` (+2) > `m1` (+1)，貪婪必選 `m2`** | **(t<sub>3</sub>, d<sub>2</sub>, m<sub>2</sub>)** | **16 / 16 (100%)** ✅ |

### Step 3：`AllPairs4J` 核心 API 詳解與使用方法（以游泳池收費系統為例）

在 [`SwimmingPoolPairwiseDemoTest.java`](../../src/test/java/u05_pair/SwimmingPoolPairwiseDemoTest.java) 中，我們不用自己手寫迴圈挑測資，而是直接呼叫 Java 成對測試框架 **[AllPairs4J](https://github.com/pavelicii/allpairs4j)**（Maven 座標：`io.github.pavelicii:allpairs4j:2.0.0`）自動完成上述 Step 2 的貪婪計算。

#### 1. `AllPairs4J` 四大核心類別與方法意義

| 核心類別 / 方法 (`io.github.pavelicii.allpairs4j.*`) | 角色與意義 | 使用語法與回傳型別 |
| :--- | :--- | :--- |
| **`Parameter`** | **測試參數維度（Factor & Levels）**<br>代表受測系統的「單一輸入參數名稱」與其「所有可能的候選取值清單」。 | `new Parameter("TimeSlot", "MORNING", "NOON", "OTHER")`<br>*(第 1 個引數為參數名稱 `String`，後續可傳入任意個 `Object...` 或 `List<?>` 候選值)* |
| **`AllPairs.AllPairsBuilder`** | **成對模型建造者（Fluent Builder）**<br>採用建造者模式，負責收集所有參數維度、設定組合階數（t-way）與互斥約束條件。 | • `.withParameter(Parameter)`：註冊一個參數維度<br>• `.withTestCombinationSize(int t)`：選填，預設 `2`（2-Way 成對），可改為 `3`（3-Way）<br>• `.withConstraint(Predicate)`：選填，過濾非法互斥組合<br>• `.build()`：**觸發演算法運算**並回傳 `AllPairs` |
| **`AllPairs`** | **成對測試集容器（Generated Suite）**<br>封裝演算法計算完成的最小化成對測試矩陣（實作 `Iterable<Case>`）。 | `allPairs.getGeneratedCases()`<br>➔ 回傳 `List<Case>`（即壓縮後的所有成對測試案例清單） |
| **`Case`** | **單一測試案例列（Test Vector / Row）**<br>代表矩陣中的「其中一組測試案例」（例如第 1 列 `MORNING, HOLIDAY, true`）。底層繼承自 `LinkedHashMap<String, Object>`。 | `c.get("TimeSlot")`<br>➔ 依據當初定義的 `Parameter` 名稱（Key），取出該列被分配到的參數值（Value） |

#### 2. `AllPairs4J` + JUnit 5 `@TestFactory` 實作四部曲（游泳池範例完整拆解）

```java
// 【第 1 步：定義參數維度 (Parameter) 並以 Builder 觸發演算法 (.build())】
AllPairs allPairs = new AllPairs.AllPairsBuilder()
        // 依序註冊游泳池收費系統的 3 個參數維度與各自的候選取值：
        .withParameter(new Parameter("TimeSlot", "MORNING", "NOON", "OTHER")) // 時間 (3種)
        .withParameter(new Parameter("DayType", "HOLIDAY", "WEEKDAY"))        // 星期 (2種)
        .withParameter(new Parameter("IsMember", "true", "false"))            // 會員 (2種)
        // 選填進階設定：
        // .withTestCombinationSize(2) // 預設即為 2 (2-Way Pairwise)
        // .withConstraint(c -> !(c.get("TimeSlot").equals("MORNING") && c.get("DayType").equals("HOLIDAY")))
        .build(); // 👈 呼叫 build() 瞬間，內部自動執行 IPO + Greedy 演算法完成 16 個 Pairs 覆蓋！

// 【第 2 步：取得演算法生成的成對測試案例清單 (List<Case>)】
List<Case> cases = allPairs.getGeneratedCases(); // 12 組全乘積被壓縮為 6 組 Case！

// 【第 3 步：走訪每一筆 Case，用 c.get("參數名") 取出測試值並轉型】
return cases.stream().map(c -> {
    TimeSlot time = TimeSlot.valueOf(c.get("TimeSlot").toString());
    DayType day = DayType.valueOf(c.get("DayType").toString());
    boolean isMember = Boolean.parseBoolean(c.get("IsMember").toString());

    String title = String.format("泳池成對案例: 時段=%s, 星期=%s, 會員=%b", time, day, isMember);

    // 【第 4 步：封裝為 JUnit 5 DynamicTest，交由 @TestFactory 在 IDE 展開為獨立測試節點】
    return DynamicTest.dynamicTest(title, () -> {
        int price = SwimmingPoolPricing.calculatePrice(time, day, isMember);
        assertTrue(price >= 50 && price <= 200, "票價應介於 50 ~ 200 元合理區間");
    });
}).collect(Collectors.toList());
```

#### 3. 🤔 關鍵工程盲點剖析：AllPairs4J 只生出「輸入組合」，那「Expected Output（預期結果）」怎麼來？

看到上面的程式碼，敏銳的同學一定會發現一個問題：  
> **「`AllPairs4J`（或 PICT）只幫我們挑出了 6 組輸入參數組合 `(TimeSlot, DayType, IsMember)`，但它根本不知道游泳池的收費規格，不會自動生出 `expectedPrice`！那我們要怎麼寫 `assertEquals`？」**

這正是軟體測試中著名的 **Test Oracle Problem（測試預言機問題）**。在實務工程中，針對成對測試的 Expected Output 有 **3 種標準解決策略**：

| 預言機策略 (Oracle Strategy) | 運作方式 | 優缺點與適用場景 |
| :--- | :--- | :--- |
| **策略 A：兩階段精確預言機**<br>*(工具生組合 ➔ 人工補預期值 ➔ `@CsvSource`)* | 1. **第一階段（工具壓縮）**：用 `AllPairs4J` 將 12 組（或 36 組）壓縮並印出 **6 組精選輸入**。<br>2. **第二階段（人工算 Oracle）**：工程師只需對照規格書（SRS）算出這 **6 組**的精確預期票價（省去算另外 6~27 組的苦工！），填入 `@CsvSource` 執行 `assertEquals(expected, actual)`。 | ✅ **最精確**（任何算錯 1 元都能抓到）<br>📌 適用於壓縮後案例數適中（如 6~20 組）的核心業務邏輯。 |
| **策略 B：屬性不變量斷言**<br>*(`@TestFactory` + Invariant Oracle)* | 不逐一查表算精確值，而是驗證「**在任何輸入組合下都必須成立的業務不變量與不崩潰性**」（例如：`50 <= price <= 200`、貸款利率必 `>= 2.0%` 保底、系統不拋出 Exception）。 | ✅ **100% 全自動**，適合上百組高維度配對或 Smoke Test<br>⚠️ **盲區**：若應收 80 元卻算成 100 元（仍在 50~200 區間內），單靠區間斷言會漏抓！ |
| **策略 C：獨立參考模型預言機**<br>*(`@TestFactory` + Reference Oracle)* | 在測試端透過「舊版系統」、「獨立查表規則」或「簡化版規格公式」動態算出 `expected`，再與被測系統比對。 | ✅ 兼具全自動與精確性<br>📌 適用於系統重構（新舊版本對拍）或具標準公式之領域。 |

👉 **在 [`SwimmingPoolPairwiseDemoTest.java`](../../src/test/java/u05_pair/SwimmingPoolPairwiseDemoTest.java) 的「示範 3-Step1 與 Step2」中，即展示了如何落地【策略 A：兩階段精確預言機】**：
1. **先執行 `generateCsvSourceTemplateForPaste()`**：在 Console 自動印出排版對齊的 `@CsvSource({...})` 程式碼骨架（最後一欄標示 `TODO`），方便工程師直接複製貼上（Copy & Paste）。
2. **再貼入 `testSwimmingPoolPairwiseWithExactOracle(...)` 並將 `TODO` 改為 SRS 預期票價**：
```java
@ParameterizedTest(name = "成對精確驗證 #{index}: 時段={0}, 星期={1}, 會員={2} ➔ 預期票價={3}元")
@CsvSource({
    // 第一階段由 generateCsvSourceTemplateForPaste() 印出前 3 欄骨架；第二階段由工程師對照 SRS 將 TODO 改為預期票價：
    "MORNING, HOLIDAY, true,  100", // #1: 假日(200) + 會員五折 = 100 元
    "MORNING, WEEKDAY, false,  80", // #2: 平日(100) + 非會員清晨八折 = 80 元
    "NOON,    HOLIDAY, false, 200", // #3: 假日(200) + 非會員不打折 = 200 元
    "NOON,    WEEKDAY, true,   50", // #4: 平日(100) + 會員五折 = 50 元
    "OTHER,   HOLIDAY, true,  100", // #5: 假日(200) + 會員五折 = 100 元
    "OTHER,   WEEKDAY, false, 100"  // #6: 平日(100) + 非會員一般時段原價 = 100 元
})
void testSwimmingPoolPairwiseWithExactOracle(TimeSlot time, DayType day, boolean isMember, int expectedPrice) {
    assertEquals(expectedPrice, SwimmingPoolPricing.calculatePrice(time, day, isMember));
}
```

開啟 [`src/test/java/u05_pair/SwimmingPoolPairwiseDemoTest.java`](../../src/test/java/u05_pair/SwimmingPoolPairwiseDemoTest.java) 並執行：
```bash
mvn test -Dtest=SwimmingPoolPairwiseDemoTest
```

---

## 4. Java 進階實戰：房貸利率計算器 (`LoanCalculator` + JUnit 5 `@TestFactory`)

在 Java 生態系中，**[AllPairs4J](https://github.com/pavelicii/allpairs4j)** 是一套純 Java 成對生成框架，能與 JUnit 5 的 `@TestFactory` 和 `DynamicTest` 無縫整合。

### 4.1 房貸利率計算器 (`u05_pair/LoanCalculator.java`) 案例背景
受測方法 `LoanCalculator.calculateInterestRate(loanYears, loanAmount, isYouth, isMarried)` 具備 4 個維度：
- **貸款年限 (Years)**：5 年、15 年、25 年 (3 種)
- **貸款金額 (Amount)**：400 萬、550 萬、700 萬 (3 種)
- **青年優惠 (IsYouth)**：true、false (2 種)
- **婚姻狀態 (IsMarried)**：true、false (2 種)

若採用笛卡爾全乘積：3 × 3 × 2 × 2 = **36 組案例**。  
透過 **AllPairs4J** 壓縮後：僅需 **9 組成對案例**！

### 4.2 JUnit 5 動態成對測試程式碼 (`LoanCalculatorPairwiseDemoTest.java`)
位於本專案：[`src/test/java/u05_pair/LoanCalculatorPairwiseDemoTest.java`](../../src/test/java/u05_pair/LoanCalculatorPairwiseDemoTest.java)

```java
package u05_pair;

import io.github.pavelicii.allpairs4j.AllPairs;
import io.github.pavelicii.allpairs4j.Case;
import io.github.pavelicii.allpairs4j.Parameter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.List;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

public class LoanCalculatorPairwiseDemoTest {

    @TestFactory
    @DisplayName("示範 2：JUnit 5 @TestFactory 動態成對執行與業務邊界斷言")
    List<DynamicTest> dynamicPairwiseTests() {
        AllPairs allPairs = new AllPairs.AllPairsBuilder()
                .withParameter(new Parameter("Years", "5", "15", "25"))
                .withParameter(new Parameter("Amount", "4000000", "5500000", "7000000"))
                .withParameter(new Parameter("IsYouth", "true", "false"))
                .withParameter(new Parameter("IsMarried", "true", "false"))
                .build();

        return allPairs.getGeneratedCases().stream().map(c -> {
            int year = Integer.parseInt(c.get("Years").toString());
            double amount = Double.parseDouble(c.get("Amount").toString());
            boolean isYouth = Boolean.parseBoolean(c.get("IsYouth").toString());
            boolean isMarried = Boolean.parseBoolean(c.get("IsMarried").toString());

            String testName = String.format("成對測試: 年限=%d年, 金額=%.0f, 青年=%b, 已婚=%b",
                    year, amount, isYouth, isMarried);

            return DynamicTest.dynamicTest(testName, () -> {
                double rate = LoanCalculator.calculateInterestRate(year, amount, isYouth, isMarried);
                assertTrue(rate >= 2.0 && rate <= 5.0, "利率應介於合法區間 2.0% ~ 5.0%");
            });
        }).collect(Collectors.toList());
    }
}
```

### 4.3 執行 `u05_pair` 測試與課堂練習
```bash
# 執行 u05_pair 目錄下所有示範測試
mvn test -Dtest="u05_pair.*DemoTest"

# 執行課堂練習題 (完成 LoanCalculatorPairwiseExerciseTest.java 後驗證)
mvn test -Dtest=LoanCalculatorPairwiseExerciseTest
```

> 💡 **課堂動手練習 (`u05_pair/LoanCalculatorPairwiseExerciseTest.java`)**：
> 1. **練習 1**：設計極限優惠組合（25 年、2500 萬、青年、已婚），驗證利率精準觸發保底下限 `2.0%`。
> 2. **練習 2**：使用 `AllPairs.AllPairsBuilder` 自行定義 3 因子成對生成矩陣（3 × 2 × 2 = 12 組 ➔ 壓縮為 6 組）並動態執行斷言！
> *(標準解答請參閱 [`solutions/5.5_pairwise/LoanCalculatorPairwiseExerciseTest.java`](solutions/5.5_pairwise/LoanCalculatorPairwiseExerciseTest.java))*

---

## 5. 業界主流命令列工具：Microsoft PICT 對照

若在 CI/CD 腳本或多語言環境中，微軟開源的 **PICT (Pairwise Independent Combinatorial Tool)** 是工業界最普及的標準工具。

### 5.1 模型檔定義 (`loan_calculator.pict`)
位於本專案：[`src/test/resources/pairwise/loan_calculator.pict`](../../src/test/resources/pairwise/loan_calculator.pict)
```text
Years: 5, 15, 25
Amount: 4000000, 5500000, 7000000
IsYouth: true, false
IsMarried: true, false

# 支援自訂約束條件（若有業務互斥）：
# IF [Years] = 25 THEN [Amount] > 4000000;
```

### 5.2 執行 PICT 生成矩陣
```bash
# 安裝 (macOS: brew install pict / Windows: choco install pict)
pict src/test/resources/pairwise/loan_calculator.pict
```
產出結果將以 Tab 分隔矩陣輸出，可直接匯入 Excel 或轉為 CSV 餵入參數化測試。
