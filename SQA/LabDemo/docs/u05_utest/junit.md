# 🧪 Lab 05: 單元測試與黑箱測試實務 (JUnit 5 & Black-Box Testing)

> 本實驗手冊配合課堂教學節奏，採用「概念講授 ➔ Lab Demo 操作 ➔ 深入方法 ➔ 課堂動手練習」之交錯式教學設計。  
> 專案程式碼依據**方案 B (三層次測試維度)** 結構化劃分於：
> - 基礎工具層：`src/test/java/u05_junit/`
> - 資料與規則層：`src/test/java/u05_input/`
> - 行為與情境層：`src/test/java/u05_scenario/`
> - 性質與變質層：`src/test/java/u05_pbtest/`  
> 每個主題皆配有附詳細教學註解的 **Demo 程式** 與附帶提示指引的 **Exercise 練習程式**。

---

## 📚 課堂章節與實驗主題對照導覽

| 課堂章節 | 模組分類目錄 | 核心技術解鎖 | 專案示範程式 (Demo) | 課堂動手練習 (Exercise) |
| :--- | :--- | :--- | :--- | :--- |
| **5.2** | [`u05_junit/`](#52-junit-5-快速入門與-3a-原則) | 測試驅動、3A 原則、`@Test`、`assertEquals` vs. `assertSame`、`assertAll` | `CalculatorDemoTest.java`<br>`AssertionsDemoTest.java`<br>`LifeCycleDemoTest.java` | `CalculatorExerciseTest.java`<br>*(3A 減法、負數與零、物件同一性驗證)* |
| **5.3** | [`u05_input/bva/`](#53-邊界值分析-bva-實戰) | 獨立型 4n+1 / 強固 6n+1、參數化 `@ValueSource`、群組斷言 `assertAll` | `TriangleBvaDemoTest.java` | `TriangleBvaExerciseTest.java`<br>`PoolTicketBvaExerciseTest.java`<br>*(On-Off-In 三點法與年齡階層邊界)* |
| **5.4** | [`u05_input/ep/`](#54-等價類分割-ep-實戰) | 單一無效原則、例外斷言 `assertThrows`、資料驅動 `@CsvSource` / `@EnumSource` | `BinarySearchEpDemoTest.java`<br>`ParamDemoTest.java`<br>`ParamEnumDemoTest.java` | `PasswordValidatorEpExerciseTest.java`<br>*(長度邊界、純文字/數字弱密碼等價類)* |
| **5.5** | [`u05_input/pairwise/`](#55-全成對組合測試-pairwise-實戰) | AllPairs4J 演算法、動態測試工廠 `@TestFactory`、`DynamicTest` | `LoanCalculatorPairwiseDemoTest.java` | `LoanCalculatorPairwiseExerciseTest.java`<br>*(極限優惠保底 2.0% 與自訂 3 因子矩陣)* |
| **5.6** | [`u05_input/ctm/`](#56-分類樹方法-ctm-規格化實戰) | 繁中語意化規格 `@DisplayName`、命名生成器、階層情境 `@Nested` | `DisplayNameDemoTest.java` | `OrderDiscountCtmExerciseTest.java`<br>*(電商 CTM 打點組合階層式驗證)* |
| **5.7** | [`u05_input/decision/`](#57-因果圖與決策表實戰) | 決策表 1:1 直出 `@CsvSource`、多動作完整驗收 `assertAll` | `PromotionDecisionDemoTest.java` | `PromotionDecisionExerciseTest.java`<br>*(滿千、VIP、促銷碼化簡規則全覆蓋)* |
| **5.8** | [`u05_scenario/state/`](#58-狀態轉換測試實戰) | 前置生命週期隔離 `@BeforeEach`、狀態階層 `@Nested`、狀態不變量 | `StackStateDemoTest.java`<br>`PlayerStateDemoTest.java` | `StackStateExerciseTest.java`<br>*(1-Switch 轉移序列與非法轉移防護)* |
| **5.9** | [`u05_scenario/usecase/`](#59-使用案例測試-use-case-testing-實戰) | 業務情境規格、基本流 (Happy Path)、替代流 (Alternative Path)、例外流 (Exception Path) | `AtmUseCaseDemoTest.java` | `AtmUseCaseExerciseTest.java`<br>*(連續 3 次錯誤密碼鎖卡防衛例外流)* |
| **5.10** | [`u05_scenario/experience/`](#510-經驗基礎與錯誤推測-error-guessing-實戰) | 直覺錯誤推測 (Error Guessing)、攻擊探針、極端畸形邊緣測資 (Boundary/Special Chars) | `ErrorGuessingDemoTest.java` | `ExploratoryExerciseTest.java`<br>*(畸形 Email 與 Null 指標注入防衛測試)* |
| **5.11** | [`u05_pbtest/`](#511-以性質為基礎的測試-pbt-與變質測試實戰) | 屬性不變量 `@Property`、隨機測資 `@ForAll`、測資收縮 (Shrinking)、變質關係 (MR) | `PropertyBasedDemoTest.java`<br>`MetamorphicDemoTest.java` | `PropertyBasedExerciseTest.java`<br>`MetamorphicExerciseTest.java`<br>*(乘法交換律、串列長度守恆、大小寫不敏感變質關係)* |
| **進階** | [`ai/`](#-進階單元ai-輔助單元測試生成教學) | Prompt Engineering 四大要素、測試 Oracle 責任、反例收斂 | - | 練習: 撰寫注入測試知識的高品質 Prompt |

---

## 🚀 5.2: JUnit 5 快速入門與 3A 原則

### 1. 核心思維：Test-First 與 3A 原則
- **Test-First (測試優先)**：
  - 傳統思維：設計 ➔ 寫程式 ➔ 手動測試 ➔ 害怕修改重構。
  - 現代工程：設計 ➔ 撰寫測試案例 ➔ 實作程式碼 ➔ 秒級自動回歸（從紅燈轉綠燈）。
- **3A 原則 (Arrange, Act, Assert)**：
  - **Arrange (安排)**：準備受測物件、初始化測試資料與前置條件。
  - **Act (執行)**：呼叫受測方法，取得實際運算結果或激發系統狀態改變。
  - **Assert (驗證)**：比對實際結果與規格書之預期輸出是否吻合。

### 2. 環境與依賴配置 (Maven)
在 `pom.xml` 中引入現代 JUnit 5 (`junit-jupiter`) 依賴：
```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.11.0</version>
    <scope>test</scope>
</dependency>
```

### 3. Demo 演示：`CalculatorDemoTest.java`
開啟專案路徑：`u05_junit/CalculatorDemoTest.java`

```java
package u05_junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Unit 5.2 示範：Calculator 計算機單元測試與 3A 原則")
public class CalculatorDemoTest {

    @Test
    @DisplayName("基礎加法運算驗證 (經典 3A 結構)")
    void testAdd_standard3A() {
        // 1. Arrange: 準備計算機實體
        Calculator calculator = new Calculator();
        // 2. Act: 執行相加
        int result = calculator.add(10, 25);
        // 3. Assert: 驗證輸出是否為 35
        assertEquals(35, result, "10 + 25 應該等於 35");
    }
}
```

### 4. 關鍵思維：內容值等價 vs. 記憶體同一性
開啟 `u05_junit/AssertionsDemoTest.java` 檢驗經典斷言區分：
- **`assertEquals(expected, actual)`**：內部呼叫 `equals()` 方法，驗證兩物件承載的**資料內容是否相等**。
- **`assertSame(expected, actual)`**：直接比對記憶體指標位址（`==`），驗證是否指向 Heap 中的**同一個物件實體**。

### 🧪 5.2 課堂動手練習
開啟並執行 [`CalculatorExerciseTest.java`](file:///Users/nick-mini-26/oTeach/SQA/LabDemo/src/test/java/u05_junit/CalculatorExerciseTest.java)：
1. **練習 1**：補全減法運算的 3A 測試代碼。
2. **練習 2**：使用 `assertAll` 聚合負數與零的加法運算。
3. **練習 3**：驗證 `Person` 物件之 `assertEquals` 與 `assertSame` 行為差異。

> 💡 **卡關求助 / 參考解答**：  
> 本題完整標準解答與設計思維請參閱 [📖 `solutions/README.md#unit-52-junit-5-基礎與-3a-原則`](solutions/README.md#unit-52-junit-5-基礎與-3a-原則) 或獨立原始碼 [`solutions/5.2_junit/CalculatorExerciseTest.java`](solutions/5.2_junit/CalculatorExerciseTest.java)。

---

## 🎯 5.3: 邊界值分析 (BVA) 實戰

### 1. 痛點剖析：臨界測資密集與 Early Abort 陷阱
- 邊界值分析 (BVA) 會針對邊緣點產生大量測試數值（`min-, min, min+, nom, max-, max, max+`）。
- 若在同一方法中寫多行常規斷言，一旦第一個 `min-` 斷言失敗，測試會立即拋錯中止，導致後續所有 `max` 邊界檢驗直接被跳過（Early Abort），造成嚴重漏檢！

### 2. JUnit 5 解決方案
- **參數化數值注入 (`@ValueSource` / `@CsvSource`)**：一套測試邏輯，自動批次跑遍所有臨界點。
- **群組聚合斷言 (`assertAll`)**：群組內所有斷言保證全部執行完畢，一次性收集並回報所有邊界失敗！

### 3. Demo 演示：`TriangleBvaDemoTest.java`
開啟 `u05_input/bva/TriangleBvaDemoTest.java`：

```java
// 使用 assertAll 聚合邊界測試，任一失敗不中斷其餘邊界
@Test
@DisplayName("兩邊之和剛好等於第三邊之退化邊界 (不構成三角形)")
void testTriangleInequality_criticalBoundary() {
    assertAll("退化極限邊界",
        () -> assertEquals("Not a valid triangle", Triangle.getTriangleType(3, 4, 7), "3+4=7 退化為線段"),
        () -> assertEquals("Not a valid triangle", Triangle.getTriangleType(3, 7, 4)),
        () -> assertEquals("Not a valid triangle", Triangle.getTriangleType(7, 3, 4))
    );
}
```

### 🧪 5.3 課堂動手練習
1. 開啟 [`TriangleBvaExerciseTest.java`](file:///Users/nick-mini-26/oTeach/SQA/LabDemo/src/test/java/u05_input/bva/TriangleBvaExerciseTest.java)：
   - 補全三角形強固邊界（`min-`、`max+`）越界測資。
   - 運用 On-Off-In 三點法檢驗兩邊之和的極限臨界點。
2. 開啟 [`PoolTicketBvaExerciseTest.java`](file:///Users/nick-mini-26/oTeach/SQA/LabDemo/src/test/java/u05_input/bva/PoolTicketBvaExerciseTest.java)：
   - 規格：免費 (0~3歲)、兒童票 (4~12歲)、全票 (13~64歲)、敬老票 (≥ 65 歲)。
   - 使用 `@CsvSource` 驗證所有交界點票價，並用 `assertThrows` 驗證 -1 與 121 歲越界防禦！

> 💡 **卡關求助 / 參考解答**：  
> 本題完整標準解答與設計思維請參閱 [📖 `solutions/README.md#unit-53-邊界值分析-bva`](solutions/README.md#unit-53-邊界值分析-bva) 或獨立原始碼 [`solutions/5.3_bva/`](solutions/5.3_bva/)。

---

## 🧩 5.4: 等價類分割 (EP) 實戰

### 1. 痛點剖析：無效等價類防禦與多維測試表格
- **無效等價類**：依據單一無效原則，非法輸入（如負數邊長、空字串）的外顯行為不是正常輸出，而是觸發系統防禦性機制（拋出例外）。
- **有效等價類**：劃分出的正等價類、零值等價類等多組測試向量，若寫死在程式碼中將導致代碼臃腫且難以維護。

### 2. JUnit 5 解決方案
- **例外斷言 (`assertThrows`)**：精準攔截預期拋出的特定例外類別，並驗證錯誤提示訊息。
- **外部資料驅動 (`@CsvSource` / `@EnumSource`)**：將等價類測試向量外置至表格，測試邏輯與測資徹底解耦。

### 3. Demo 演示：`BinarySearchEpDemoTest.java` 與 `ParamDemoTest.java`
開啟 `u05_input/ep/BinarySearchEpDemoTest.java`：
- 單元素陣列命中 vs. 未命中。
- 多元素陣列命中頭部、中間、尾部。
- 空陣列邊界與傳入 null 之例外斷言。

### 🧪 5.4 課堂動手練習
開啟 [`PasswordValidatorEpExerciseTest.java`](file:///Users/nick-mini-26/oTeach/SQA/LabDemo/src/test/java/u05_input/ep/PasswordValidatorEpExerciseTest.java)：
1. **練習 1**：驗證有效等價類密碼（長度 8~20 且含英數字）。
2. **練習 2**：使用 `assertThrows` 驗證長度過短 (<8) 與過長 (>20) 之無效等價類例外拋出。
3. **練習 3**：驗證純字母或純數字之弱密碼等價類回傳 false。

> 💡 **卡關求助 / 參考解答**：  
> 本題完整標準解答與設計思維請參閱 [📖 `solutions/README.md#unit-54-等價類分割-ep`](solutions/README.md#unit-54-等價類分割-ep) 或獨立原始碼 [`solutions/5.4_ep/PasswordValidatorEpExerciseTest.java`](solutions/5.4_ep/PasswordValidatorEpExerciseTest.java)。

---

## 🎲 5.5: 全成對組合測試 (Pairwise) 實戰

### 1. 痛點剖析：成對矩陣動態生成，靜態測試無法彈性接收
- 多維參數系統引發指數級「組合爆炸」（如 4 參數全乘積需 36 組）。
- NIST 實證 2-Way 交互作用可捕捉 90% 缺陷。
- 但 Pairwise 工具（如 AllPairs4J）是在**執行時期**依演算法動態產生成對矩陣，傳統靜態 `@Test` 無法彈性接收動態長度的測試清單。

### 2. JUnit 5 解決方案
- **動態測試工廠 (`@TestFactory` + `DynamicTest`)**：測試方法回傳動態案例串流，執行時期即時將演算法輸出的每組配對封裝為獨立命名的測試節點！

### 3. Demo 演示：`LoanCalculatorPairwiseDemoTest.java`
開啟 `u05_input/pairwise/LoanCalculatorPairwiseDemoTest.java`：

```java
@TestFactory
@DisplayName("動態執行 AllPairs 生成之所有成對貸款利率測試案例")
List<DynamicTest> dynamicPairwiseTests() {
    List<Case> cases = buildLoanCases(); // 呼叫 AllPairs4J 演算法生成矩陣

    return cases.stream().map(c -> {
        int year = Integer.parseInt(c.get("Years").toString());
        double amount = Double.parseDouble(c.get("Amount").toString());
        boolean isYouth = Boolean.parseBoolean(c.get("IsYouth").toString());
        boolean isMarried = Boolean.parseBoolean(c.get("IsMarried").toString());

        String testName = String.format("成對測試: 年限=%d年, 金額=%.0f, 青年=%b, 已婚=%b",
                year, amount, isYouth, isMarried);

        return DynamicTest.dynamicTest(testName, () -> {
            double rate = LoanCalculator.calculateInterestRate(year, amount, isYouth, isMarried);
            // 驗證業務核心不變量：利率不可低於保底下限 2.0%
            assertTrue(rate >= 2.0, "利率不可低於法定下限 2.0%");
        });
    }).collect(Collectors.toList());
}
```

### 🧪 5.5 課堂動手練習
開啟 [`LoanCalculatorPairwiseExerciseTest.java`](file:///Users/nick-mini-26/oTeach/SQA/LabDemo/src/test/java/u05_input/pairwise/LoanCalculatorPairwiseExerciseTest.java)：
1. **練習 1**：設計極限優惠組合，驗證利率精準觸發保底下限 2.0%。
2. **練習 2**：使用 `AllPairs.AllPairsBuilder` 自行定義 3 因子成對生成矩陣並動態執行斷言！

> 💡 **卡關求助 / 參考解答**：  
> 本題完整標準解答與設計思維請參閱 [📖 `solutions/README.md#unit-55-全成對組合測試-pairwise`](solutions/README.md#unit-55-全成對組合測試-pairwise) 或獨立原始碼 [`solutions/5.5_pairwise/LoanCalculatorPairwiseExerciseTest.java`](solutions/5.5_pairwise/LoanCalculatorPairwiseExerciseTest.java)。

---

## 🌳 5.6: 分類樹方法 (CTM) 規格化實戰

### 1. 痛點剖析：打點規格表缺乏語意可讀性
- Daimler-Benz 分類樹方法 (CTM) 透過打點組合矩陣組裝測試案例。
- 傳統測試若命名為 `test01()`、`test02()`，在 CI/CD 測試報告中完全失去商務脈絡，無法作為利害關係人驗收之活文件。

### 2. JUnit 5 解決方案
- **繁中語意化命名 (`@DisplayName`)**：以自然語言直接描述業務規則。
- **命名生成器 (`@DisplayNameGeneration`)**：支援自動轉譯下底線為空格語句。
- **階層情境分組 (`@Nested`)**：1:1 對應分類樹的樹狀分類與子分類結構。

### 3. Demo 演示：`DisplayNameDemoTest.java`
開啟 `u05_input/ctm/DisplayNameDemoTest.java` 檢視階層式組織結構。

### 🧪 5.6 課堂動手練習
開啟 [`OrderDiscountCtmExerciseTest.java`](file:///Users/nick-mini-26/oTeach/SQA/LabDemo/src/test/java/u05_input/ctm/OrderDiscountCtmExerciseTest.java)：
- 依據投影片中的電商結帳（身分 × 金額 × 支付）CTM 打點規格表：
  - `TC_1`：VIP 大額訂單（>3K）享 8 折加滿額折 300 元。
  - `TC_2`：一般會員中額訂單（1K~3K）享 9 折加滿額折 100 元。
  - `TC_3`：訪客小額訂單（<1K）原價無折扣。
- 以 `@Nested` 分層驗證 CTM 矩陣中的組合！

> 💡 **卡關求助 / 參考解答**：  
> 本題完整標準解答與設計思維請參閱 [📖 `solutions/README.md#unit-56-分類樹方法-ctm`](solutions/README.md#unit-56-分類樹方法-ctm) 或獨立原始碼 [`solutions/5.6_ctm/OrderDiscountCtmExerciseTest.java`](solutions/5.6_ctm/OrderDiscountCtmExerciseTest.java)。

---

## ⚡ 5.7: 因果圖與決策表實戰

### 1. 痛點剖析：規則化簡與多動作覆蓋盲區
- 因果圖法轉出的 CAR 決策表，每一條化簡規則 (Rule) 包含多條件組合。
- 單一規則常激發多個系統外顯動作（例如：折扣價計算 + 發放贈品 + 標記免運）。
- 傳統斷言若第一個動作失敗即中止，將導致後續動作檢驗全部漏掉。

### 2. JUnit 5 解決方案
- **決策表 1:1 直出 (`@CsvSource`)**：決策表的條件與預期輸出欄位直接對映為 CSV 的行與列。
- **多動作聚合斷言 (`assertAll`)**：保證該規則下的所有外顯動作全部被完整驗收。

### 3. Demo 演示：`PromotionDecisionDemoTest.java`
開啟 `u05_input/decision/PromotionDecisionDemoTest.java`：
- 規則 1 (R_1)：滿千且 VIP，無促銷碼 ➔ 僅享 8 折。
- 規則 2 (R_2)：滿千且有促銷碼，非 VIP ➔ 僅享免運。
- 規則 3 (R_3)：滿千、VIP、有促銷碼 ➔ 雙重優惠 (8折 + 免運)。
- 規則 4 (R_4 - 化簡關鍵)：未滿千門檻 ➔ 無論身分與促銷碼，一律原價結帳！

### 🧪 5.7 課堂動手練習
開啟 [`PromotionDecisionExerciseTest.java`](file:///Users/nick-mini-26/oTeach/SQA/LabDemo/src/test/java/u05_input/decision/PromotionDecisionExerciseTest.java)：
1. **練習 1**：剛好滿 1000 元滿額臨界值測試。
2. **練習 2**：999.9 元未滿額臨界值測試（驗證即使有促銷碼依然原價結帳）。
3. **練習 3**：使用 `@CsvSource` 資料驅動驗證 CAR 決策表全規則矩陣！

> 💡 **卡關求助 / 參考解答**：  
> 本題完整標準解答與設計思維請參閱 [📖 `solutions/README.md#unit-57-因果圖與決策表測試`](solutions/README.md#unit-57-因果圖與決策表測試) 或獨立原始碼 [`solutions/5.7_decision/PromotionDecisionExerciseTest.java`](solutions/5.7_decision/PromotionDecisionExerciseTest.java)。

---

## 🔄 5.8: 狀態轉換測試實戰

### 1. 痛點剖析：狀態殘留污染與 void 動作檢驗
- 狀態測試著重於「物件在特定狀態下的外顯行為」與「激發事件後的轉移」。
- 很多操作（如 `push`, `pop`, `turnOn`）為 void 方法，需透過狀態屬性查詢方法驗證；
- 且測試必須保證進入目標狀態前，前置步驟是獨立且乾淨的，避免上一個測試殘留狀態導致假警報。

### 2. JUnit 5 解決方案
- **生命週期前置隔離 (`@BeforeEach`)**：每個測試案例執行前獨立初始化物件並激發特定前置序列。
- **巢狀狀態階層 (`@Nested`)**：以巢狀類別直接對應狀態機的每個狀態節點。

### 3. Demo 演示：`StackStateDemoTest.java` 與 `PlayerStateDemoTest.java`
開啟 `u05_scenario/state/StackStateDemoTest.java`：
- 空狀態 (WhenNew)：驗證 `isEmpty == true` 與 pop 拋出 `EmptyStackException`。
- 滿狀態 (WhenFull)：驗證 `isFull == true` 與 push 拋出 `IllegalStateException` (Stack Overflow)。

### 🧪 5.8 課堂動手練習
開啟 [`StackStateExerciseTest.java`](file:///Users/nick-mini-26/oTeach/SQA/LabDemo/src/test/java/u05_scenario/state/StackStateExerciseTest.java)：
1. **練習 1**：驗證 Empty ➔ Non-Empty ➔ Empty 狀態閉環轉移序列 (1-Switch)。
2. **練習 2**：驗證在空狀態執行 `peek()` 時拋出例外，且物件狀態不變量（依然為空）不被破壞！

> 💡 **卡關求助 / 參考解答**：  
> 本題完整標準解答與設計思維請參閱 [📖 `solutions/README.md#unit-58-狀態轉換測試`](solutions/README.md#unit-58-狀態轉換測試) 或獨立原始碼 [`solutions/5.8_state/StackStateExerciseTest.java`](solutions/5.8_state/StackStateExerciseTest.java)。

---

## 🏦 5.9: 使用案例測試 (Use Case Testing) 實戰

### 1. 痛點剖析：孤立單元測試無法保證端到端業務旅程
- 系統內部各方法雖然各自綠燈，但在真實使用者操作時，多步驟連鎖交互仍常引發商務漏洞。
- 使用案例測試著重於端到端的使用者業務旅程（Actor Goal），涵蓋**基本流 (Happy Path)**、**替代流 (Alternative Path)** 與 **例外流 (Exception Path)**。

### 2. Demo 演示：`AtmUseCaseDemoTest.java`
開啟 `u05_scenario/usecase/AtmUseCaseDemoTest.java`：
- **基本流 (UC-01 Happy Path)**：正確 PIN 碼 ➔ 提款金額合法且充足 ➔ 吐鈔成功且餘額精確扣減。
- **替代流 (UC-02 Alt Path)**：提款金額超過單筆上限（20,000 元）➔ 系統拒絕交易並維持帳戶餘額。
- **例外流 (UC-03 Exception Path)**：提款金額超過帳戶現有餘額 ➔ 系統提示餘額不足並維持帳戶餘額。

### 🧪 5.9 課堂動手練習
開啟 [`AtmUseCaseExerciseTest.java`](file:///Users/nick-mini-26/oTeach/SQA/LabDemo/src/test/java/u05_scenario/usecase/AtmUseCaseExerciseTest.java)：
- **練習重點**：實作「防盜刷 PIN 碼連續錯誤 3 次鎖卡」之嚴格例外流（UC-04）。
- 驗證前 2 次錯誤提示剩餘次數，第 3 次精準觸發鎖卡，且鎖卡後即便輸入正確密碼依然拒絕服務！

> 💡 **卡關求助 / 參考解答**：  
> 本題完整標準解答與設計思維請參閱 [📖 `solutions/README.md#unit-59-使用案例測試-use-case`](solutions/README.md#unit-59-使用案例測試-use-case) 或獨立原始碼 [`solutions/5.9_usecase/AtmUseCaseExerciseTest.java`](solutions/5.9_usecase/AtmUseCaseExerciseTest.java)。

---

## 🕵️ 5.10: 經驗基礎與錯誤推測 (Error Guessing) 實戰

### 1. 痛點剖析：規格書不會寫的直覺盲區與攻擊向量
- 形式化規格書通常只定義「理想與標準的輸入輸出」，但惡意使用者或極端環境常輸入規格書未明定的髒資料。
- 測試工程師依據過去慘痛的踩坑經驗（直覺、缺陷歷史、安全弱點清單），主動設計「破壞性測試探針」。

### 2. Demo 演示：`ErrorGuessingDemoTest.java`
開啟 `u05_scenario/experience/ErrorGuessingDemoTest.java`：
- **字串繞過**：純空白字元（`"   "`）是否能繞過非空檢驗？
- **數值溢位**：年齡輸入 `Integer.MAX_VALUE` 是否造成計算崩潰？
- **安全注入探針**：輸入包含 HTML/XSS 特殊符號（`<script>alert(1)</script>`）是否被妥善過濾？

### 🧪 5.10 課堂動手練習
開啟 [`ExploratoryExerciseTest.java`](file:///Users/nick-mini-26/oTeach/SQA/LabDemo/src/test/java/u05_scenario/experience/ExploratoryExerciseTest.java)：
- **練習 1**：針對 Email 格式進行經驗推測（缺少 `@`、結尾無 Domain、雙重 `@`、空白注入）。
- **練習 2**：輸入 `null` 物件之邊緣崩潰防衛驗證！

> 💡 **卡關求助 / 參考解答**：  
> 本題完整標準解答與設計思維請參閱 [📖 `solutions/README.md#unit-510-經驗基礎與錯誤推測`](solutions/README.md#unit-510-經驗基礎與錯誤推測) 或獨立原始碼 [`solutions/5.10_experience/ExploratoryExerciseTest.java`](solutions/5.10_experience/ExploratoryExerciseTest.java)。

---

## 🔮 5.11: 以性質為基礎的測試 (PBT) 與變質測試實戰

### 1. 痛點剖析：手動單元測試的 Oracle 盲區與覆蓋極限
- **Example-based 侷限**：手動編寫的單一測資（如 `add(2, 3) == 5`）容易帶有開發者的認知偏見，難以覆蓋邊緣極值（如負數溢位、巨大字串）。
- **無 Oracle 困境**：對於複雜演算法（如搜尋引擎、影像辨識、機器學習），我們很難預先人工計算出複雜輸入的「唯一精確輸出」，無法直接下 `assertEquals`。

### 2. 現代解方：PBT 屬性不變量 + Metamorphic 變質關係
- **Property-Based Testing (jqwik)**：
  - 放棄單點驗算，改為描述通用數學性質（如交換律 `a+b == b+a`、反轉兩次不變量 `reverse(reverse(L)) == L`）。
  - 自動生成 1,000 組隨機輸入，若爆掉則自動啟動 **測資收縮 (Shrinking)**，找出最簡反例。
- **變質測試 (Metamorphic Testing)**：
  - 即使不知道精確輸出，我們仍能驗證**輸入轉換前後的輸出對稱關係**（如搜尋 `SQA` 的結果集合，必然包含搜尋 `SQA 2026` 的結果集合）。

### 3. Demo 演示：`u05_pbtest`
開啟 `u05_pbtest/PropertyBasedDemoTest.java` 與 `u05_pbtest/MetamorphicDemoTest.java`：
- 加法交換律、反轉兩次、排序單調性不變量驗證。
- 搜尋引擎輸入微擾抗噪變質關係驗證。

### 🧪 5.11 課堂動手練習
1. 開啟 [`PropertyBasedExerciseTest.java`](file:///Users/nick-mini-26/oTeach/SQA/LabDemo/src/test/java/u05_pbtest/PropertyBasedExerciseTest.java)：
   - 實作「乘法交換律」不變量屬性。
   - 實作「串列排序長度守恆」不變量屬性。
2. 開啟 [`MetamorphicExerciseTest.java`](file:///Users/nick-mini-26/oTeach/SQA/LabDemo/src/test/java/u05_pbtest/MetamorphicExerciseTest.java)：
   - 實作關鍵字大小寫不敏感（Case-Insensitive）變質關係對稱性驗證！

> 💡 **卡關求助 / 參考解答**：  
> 本題完整標準解答與設計思維請參閱 [📖 `solutions/README.md#unit-511-屬性測試-pbt-與變質測試`](solutions/README.md#unit-511-屬性測試-pbt-與變質測試) 或獨立原始碼 [`solutions/5.11_pbtest/`](solutions/5.11_pbtest/)。

---

## 🤖 進階單元：AI 輔助單元測試生成教學

### 1. 核心觀念：AI 是生成器，你才是「Oracle（神諭/預言者）」
在現代軟體工程中，生成測試代碼的成本已大幅降低，但**評估測試正確性與有效性的責任完全落在軟體工程師身上**。
- ❌ **常見盲區**：直接把程式碼貼給 AI 並說「幫我寫測試」，AI 往往直接依據現有程式碼的實作細節照抄斷言（Implementation Bias），程式有 Bug，AI 的測試也跟著錯！
- ✅ **正確做法**：將需求規格契約、邊界條件、等價類別與例外規格注入 Prompt，要求 AI 依據黑箱規格產生測試！

### 2. 高品質測試生成 Prompt 的四大要素
1. **角色定義 (Role)**：指定 AI 扮演資深 SQA 專家。
2. **需求契約 (Specification)**：提供 SRS 介面契約、輸入限制與預期外顯行為。
3. **測試方法指定 (Strategy)**：明確要求採用 BVA 3 點法、EP 單一無效原則或 Pairwise。
4. **框架規範 (Target Framework)**：指定輸出符合 JUnit 5 標準（`@ParameterizedTest`、`@CsvSource`、`assertAll`、`assertThrows`）。