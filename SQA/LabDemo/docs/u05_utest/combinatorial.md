# 🧩 Lab 05-3: 多維組合與邏輯規則測試 — Pairwise / CTM / 決策表 (`u05_combinatorial`)

> 🧭 **Lab 05 四大主題導覽**：
> 1️⃣ [JUnit 5 基礎 (`u05_junit`)](./junit.md) ·
> 2️⃣ [輸入分割 BVA / EP (`u05_partition`)](./partition.md) ·
> **3️⃣ [組合與規則 Pairwise / CTM / 決策表 (`u05_combinatorial`)](./combinatorial.md)** *(本頁)* ·
> 4️⃣ [行為、經驗與屬性 (`u05_behavioral`)](./behavioral.md) ·
> 📚 [參考解答庫 (`solutions/README.md`)](./solutions/README.md)

> 📂 **本分類程式碼目錄**：
> - 待測主程式：[`src/main/java/u05_combinatorial/`](../../src/main/java/u05_combinatorial/)（`pair/SwimmingPoolPricing.java`、`pair/LoanCalculator.java`、`ctm/OrderDiscount.java`、`decision/PromotionCalculator.java`）
> - 示範與練習測試：[`src/test/java/u05_combinatorial/`](../../src/test/java/u05_combinatorial/)
> - 快速執行本分類所有測試：`mvn test -Dtest="u05_combinatorial.**"`

---

## 📋 本分類 (`u05_combinatorial`) 實驗對照表

| 課堂章節 | 模組分類目錄 | 核心技術解鎖 | 專案示範程式 (Demo) | 課堂動手練習 (Exercise) |
| :--- | :--- | :--- | :--- | :--- |
| **5.5** | [`u05_combinatorial/pair/`](../../src/test/java/u05_combinatorial/pair/) | Greedy 集合覆蓋演算法、AllPairs4J、動態測試工廠 `@TestFactory`、`DynamicTest` | `SwimmingPoolPairwiseDemoTest.java`<br>`LoanCalculatorPairwiseDemoTest.java` | `LoanCalculatorPairwiseExerciseTest.java`<br>*(極限優惠保底 2.0% 與自訂 3 因子矩陣)* |
| **5.6** | [`u05_combinatorial/ctm/`](../../src/test/java/u05_combinatorial/ctm/) | 繁中語意化規格 `@DisplayName`、命名生成器、階層情境 `@Nested` | `OrderDiscountCtmDemoTest.java`<br>`LeapYearDisplayNameDemoTest.java` | `OrderDiscountCtmExerciseTest.java`<br>*(電商 CTM 打點組合階層式驗證)* |
| **5.7** | [`u05_combinatorial/decision/`](../../src/test/java/u05_combinatorial/decision/) | 決策表 1:1 直出 `@CsvSource`、多動作完整驗收 `assertAll` | `PromotionDecisionDemoTest.java` | `PromotionDecisionExerciseTest.java`<br>*(滿千、VIP、促銷碼化簡規則全覆蓋)* |

---

## 🎲 5.5: 全成對組合測試 (Pairwise) 實戰

> 📖 **完整演算法步進推導與專題手冊**：請參閱 [👉 **全成對組合測試專題手冊 (`pairwise_combinatorial.md`)**](./pairwise_combinatorial.md)。

### 1. 痛點剖析：成對矩陣動態生成，靜態測試無法彈性接收
- 多維參數系統引發指數級「組合爆炸」（如 4 參數全乘積需 36 組）。
- NIST 實證 2-Way 交互作用可捕捉 90% 缺陷。
- 但 Pairwise 工具（如 AllPairs4J）是在**執行時期**依演算法動態產生成對矩陣，傳統靜態 `@Test` 無法彈性接收動態長度的測試清單。

### 2. JUnit 5 + `AllPairs4J` 解決方案與核心 API 解析
本專案引入純 Java 成對測試框架 **`AllPairs4J`** (`io.github.pavelicii:allpairs4j:2.0.0`)，搭配 JUnit 5 的 **`@TestFactory` + `DynamicTest`**，只要四個核心 API 即可將成對演算法轉化為自動化單元測試：

| `AllPairs4J` / JUnit 5 核心 API | 角色與意義 | 游泳池範例用法 (`SwimmingPoolPairwiseDemoTest.java`) |
| :--- | :--- | :--- |
| **`new Parameter(name, values...)`** | 定義**單一測試參數維度**（名稱 + 所有候選水準值） | `new Parameter("TimeSlot", "MORNING", "NOON", "OTHER")` |
| **`new AllPairs.AllPairsBuilder()`** | **建造者模式**組裝多個參數維度：<br>• `.withParameter(...)` 註冊維度<br>• `.withConstraint(...)` 排除非法互斥組合<br>• **`.build()` 啟動 Greedy 演算法**計算矩陣 | `new AllPairs.AllPairsBuilder()`<br>&nbsp;&nbsp;`.withParameter(...)`<br>&nbsp;&nbsp;`.build()` |
| **`allPairs.getGeneratedCases()`** | 取得演算法壓縮後的**成對案例清單 (`List<Case>`)** | 回傳 6 組 `Case`（由 3×2×2=12 組全乘積壓縮而來） |
| **`Case.get("參數名稱")`** | `Case` 繼承自 `LinkedHashMap<String, Object>`，代表**單列測試組合**，以參數名稱取值 | `c.get("TimeSlot")`、`c.get("DayType")`、`c.get("IsMember")` |
| **`@TestFactory` + `DynamicTest`** | JUnit 5 動態測試工廠，將每一筆 `Case` 即時封裝為 IDE 中獨立顯示的測試節點 | `DynamicTest.dynamicTest(title, () -> { ... })` |

### 3. Demo 演示：`SwimmingPoolPairwiseDemoTest.java` 與 `LoanCalculatorPairwiseDemoTest.java`
開啟 `src/test/java/u05_combinatorial/pair/` 目錄下的兩個示範類別：
- **[`u05_combinatorial/pair/SwimmingPoolPairwiseDemoTest.java`](../../src/test/java/u05_combinatorial/pair/SwimmingPoolPairwiseDemoTest.java)**：對應投影片「游泳池收費系統（3 × 2 × 2 = 12 組全乘積）」，示範如何用 `AllPairs4J` 產生 **6 組**測試案例消去全部 16 個成對配對：

```java
// 1. 使用 AllPairsBuilder 註冊 3 個參數維度，呼叫 build() 啟動演算法生成 6 組 Case
private static List<Case> buildSwimmingPoolCases() {
    AllPairs allPairs = new AllPairs.AllPairsBuilder()
            .withParameter(new Parameter("TimeSlot", "MORNING", "NOON", "OTHER"))
            .withParameter(new Parameter("DayType", "HOLIDAY", "WEEKDAY"))
            .withParameter(new Parameter("IsMember", "true", "false"))
            .build();
    return allPairs.getGeneratedCases();
}

// 2. 結合 @TestFactory，用 c.get("參數名") 取出每組配對值並封裝為 DynamicTest
@TestFactory
List<DynamicTest> dynamicSwimmingPoolPairwiseTests() {
    return buildSwimmingPoolCases().stream().map(c -> {
        TimeSlot time = TimeSlot.valueOf(c.get("TimeSlot").toString());
        DayType day = DayType.valueOf(c.get("DayType").toString());
        boolean isMember = Boolean.parseBoolean(c.get("IsMember").toString());

        return DynamicTest.dynamicTest("泳池成對: " + time + "/" + day + "/會員=" + isMember, () -> {
            int price = SwimmingPoolPricing.calculatePrice(time, day, isMember);
            assertTrue(price >= 50 && price <= 200);
        });
    }).collect(Collectors.toList());
}
```

> 🤔 **關鍵盲點：成對工具只負責生出「輸入組合 (Inputs)」，那「Expected Output」從哪來？**  
> `AllPairs4J` 不懂游泳池或房貸的業務規則，因此**不會自動產生 Expected Output**！實務上有兩種驗證策略（皆實作於 `SwimmingPoolPairwiseDemoTest.java`）：
> 1. **策略 A（屬性不變量斷言，如上例 `@TestFactory`）**：不逐一算精確值，直接驗證「在任何組合下都必須成立的業務邊界與不崩潰性」（如 `50 <= price <= 200`、房貸利率 `>= 2.0%`）。優點是全自動，但若應收 80 元卻算成 100 元會漏抓。
> 2. **策略 B（兩階段精確預言機：AllPairs 挑組合 ➔ 人工對照 SRS 補上 Expected Output 轉為 `@CsvSource`）**：先用 `AllPairs4J` 把 12 組壓縮成 **6 組**（幫工程師省去算另外 6 組或 27 組的時間），再由工程師為這 6 組補上 SRS 規格預期票價（`100, 80, 200, 50, 100, 100`），透過 `@CsvSource` + `assertEquals(expectedPrice, actualPrice)` 進行 100% 精確驗證！

- **[`u05_combinatorial/pair/LoanCalculatorPairwiseDemoTest.java`](../../src/test/java/u05_combinatorial/pair/LoanCalculatorPairwiseDemoTest.java)**：將 4 維度貸款利率（3 × 3 × 2 × 2 = 36 組全乘積）壓縮至 **9 組**，並以 `@TestFactory` 動態驗證利率保底下限 2.0%：

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
開啟 [`u05_combinatorial/pair/LoanCalculatorPairwiseExerciseTest.java`](../../src/test/java/u05_combinatorial/pair/LoanCalculatorPairwiseExerciseTest.java)：
1. **練習 1**：設計極限優惠組合，驗證利率精準觸發保底下限 2.0%。
2. **練習 2**：使用 `AllPairs.AllPairsBuilder` 自行定義 3 因子成對生成矩陣並動態執行斷言！

> 💡 **卡關求助 / 參考解答**：  
> 本題完整標準解答與設計思維請參閱 [📖 `solutions/README.md#unit-55-全成對組合測試-pairwise`](./solutions/README.md#unit-55-全成對組合測試-pairwise) 或獨立原始碼 [`solutions/5.5_pairwise/LoanCalculatorPairwiseExerciseTest.java`](./solutions/5.5_pairwise/LoanCalculatorPairwiseExerciseTest.java)。

---

## 🌳 5.6: 分類樹方法 (CTM) 規格化實戰

### 1. 痛點剖析：打點規格表與階層子樹缺乏語意可讀性
- Daimler-Benz 分類樹方法 (CTM) 透過「**樹狀子分類細分 + 垂直防漏打點矩陣**」組裝測試案例。
- 在電商結帳折扣範例中，共有三個分類維度（`會員身分`、`消費金額`、`付款方式`），其中只有選「**信用卡**」時才向下展開「**刷一次 vs. 刷分期**」階層子樹（共 10 個葉節點、4 組測試案例 `TC₁ ~ TC₄`）：

| 案例 | VIP | 一般 | 訪客 | <1K | 1~3K | >3K | 刷一次 | 刷分期 | 行動 | 貨到 | 預期輸出與測試重點 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :--- |
| **TC<sub>1</sub>** | ⚫ | | | | | ⚫ | ⚫ | | | | 3500×0.8−300 = **2500 元** (一次付清) |
| **TC<sub>2</sub>** | ⚫ | | | | | ⚫ | | ⚫ | | | 3500×0.8−300 = **2500 元** (**刷卡分期子樹**) |
| **TC<sub>3</sub>** | | ⚫ | | | ⚫ | | | | ⚫ | | 2000×0.9−100 = **1700 元** (行動免測分期) |
| **TC<sub>4</sub>** | | | ⚫ | ⚫ | | | | | | ⚫ | **800 元** 原價無折扣 (貨到免測分期) |

- 若傳統單元測試僅扁平命名為 `testCheckout1()`、`testCheckout2()`，在 CI/CD 測試報表中將完全失去分類樹的階層脈絡與業務語意。

### 2. JUnit 5 解決方案
- **繁中語意化命名 (`@DisplayName`)**：以自然語言直接標註 CTM 打點組合與預期業務結果。
- **命名生成器 (`@DisplayNameGeneration`)**：支援自動轉譯下底線方法名為空格語句。
- **多層巢狀情境分組 (`@Nested`)**：將 CTM 的上層分類（`VIPMemberTest`）、中層分類（`Over3000AmountTest`）與下層子樹（`CreditCardSubTreeTest`）1:1 映照為 Java 內部 `@Nested` 類別階層，使 IDE 測試導覽樹自動呈現出與 CTM 分類樹完全一致的樹狀結構！

### 3. Demo 演示：`OrderDiscountCtmDemoTest.java` 與 `LeapYearDisplayNameDemoTest.java`
開啟 [`u05_combinatorial/ctm/OrderDiscountCtmDemoTest.java`](../../src/test/java/u05_combinatorial/ctm/OrderDiscountCtmDemoTest.java) 檢視多層 `@Nested` 如何同構映射 CTM 分類樹（`TC1 ~ TC4`）：

```java
@Nested
@DisplayName("👑 分類一 [會員身分]：VIP 會員 (VIPMemberTest)")
class VIPMemberTest {

    @Nested
    @DisplayName("💰 分類二 [消費金額]：滿 3000 元大額訂單 (Over3000AmountTest)")
    class Over3000AmountTest {

        @Nested
        @DisplayName("💳 分類三 [付款方式]：信用卡支付子樹 (CreditCardSubTreeTest)")
        class CreditCardSubTreeTest {

            @Test
            @DisplayName("TC1: VIP會員且滿3000元刷卡一次付清 ➔ 享8折與滿額折300")
            void testVipOver3000CreditCardOneTime() {
                OrderDiscount.DiscountResult result = OrderDiscount.calculateDiscount(
                        OrderDiscount.MemberType.VIP, 3500.0,
                        OrderDiscount.PaymentMethod.CREDIT_CARD_ONE_TIME);
                assertEquals(2500.0, result.finalAmount);
            }

            @Test
            @DisplayName("TC2: VIP會員且滿3000元刷卡分期 (子樹) ➔ 享8折與滿額折300")
            void testVipOver3000CreditCardInstallment() {
                OrderDiscount.DiscountResult result = OrderDiscount.calculateDiscount(
                        OrderDiscount.MemberType.VIP, 3500.0,
                        OrderDiscount.PaymentMethod.CREDIT_CARD_INSTALLMENT);
                assertEquals(2500.0, result.finalAmount);
            }
        }
    }
}
```

### 🧪 5.6 課堂動手練習
開啟 [`u05_combinatorial/ctm/OrderDiscountCtmExerciseTest.java`](../../src/test/java/u05_combinatorial/ctm/OrderDiscountCtmExerciseTest.java)：
- 依據上方電商結帳（身分 × 金額 × 付款方式含信用卡子樹）CTM 打點規格表：
  - **外層 `@Nested class VipMemberTests`** 內嵌 **`@Nested class CreditCardSubTreeTests`**：
    - `TC_1`：VIP 大額訂單（3500 元, `CREDIT_CARD_ONE_TIME`）➔ 結帳 `2500.0` 元、總折扣 `1000.0` 元。
    - `TC_2`：VIP 大額訂單（3500 元, `CREDIT_CARD_INSTALLMENT` 刷卡分期子樹）➔ 結帳 `2500.0` 元、總折扣 `1000.0` 元。
  - **外層 `@Nested class RegularAndGuestTests`**（行動支付與貨到付款免測分期子樹）：
    - `TC_3`：一般會員中額訂單（2000 元, `MOBILE_PAY`）➔ 結帳 `1700.0` 元。
    - `TC_4`：訪客小額訂單（800 元, `CASH_ON_DELIVERY`）➔ 原價 `800.0` 元、總折扣 `0.0` 元。

> 💡 **卡關求助 / 參考解答**：  
> 本題完整標準解答與設計思維請參閱 [📖 `solutions/README.md#unit-56-分類樹方法-ctm`](./solutions/README.md#unit-56-分類樹方法-ctm) 或獨立原始碼 [`solutions/5.6_ctm/OrderDiscountCtmExerciseTest.java`](./solutions/5.6_ctm/OrderDiscountCtmExerciseTest.java)。

---

<!-- id: sqa-u05-junit-ccq2 -->
## ⚡ 5.7: 因果圖與決策表實戰

### 1. 痛點剖析：規則化簡與多動作覆蓋盲區
- 因果圖法轉出的 CAR 決策表，每一條化簡規則 (Rule) 包含多條件組合。
- 單一規則常激發多個系統外顯動作（例如：折扣價計算 + 發放贈品 + 標記免運）。
- 傳統斷言若第一個動作失敗即中止，將導致後續動作檢驗全部漏掉。

### 2. JUnit 5 解決方案
- **決策表 1:1 直出 (`@CsvSource`)**：決策表的條件與預期輸出欄位直接對映為 CSV 的行與列。
- **多動作聚合斷言 (`assertAll`)**：保證該規則下的所有外顯動作全部被完整驗收。

### 3. Demo 演示：`PromotionDecisionDemoTest.java`
開啟 [`u05_combinatorial/decision/PromotionDecisionDemoTest.java`](../../src/test/java/u05_combinatorial/decision/PromotionDecisionDemoTest.java)：
- 規則 1 (R<sub>1</sub>)：滿千且 VIP，無促銷碼 ➔ 僅享 8 折。
- 規則 2 (R<sub>2</sub>)：滿千且有促銷碼，非 VIP ➔ 僅享免運。
- 規則 3 (R<sub>3</sub>)：滿千、VIP、有促銷碼 ➔ 雙重優惠 (8折 + 免運)。
- 規則 4 (R<sub>4</sub> - 化簡關鍵)：未滿千門檻 ➔ 無論身分與促銷碼，一律原價結帳！

### 🧪 5.7 課堂動手練習
開啟 [`u05_combinatorial/decision/PromotionDecisionExerciseTest.java`](../../src/test/java/u05_combinatorial/decision/PromotionDecisionExerciseTest.java)：
1. **練習 1**：剛好滿 1000 元滿額臨界值測試。
2. **練習 2**：999.9 元未滿額臨界值測試（驗證即使有促銷碼依然原價結帳）。
3. **練習 3**：使用 `@CsvSource` 資料驅動驗證 CAR 決策表全規則矩陣！

> 💡 **卡關求助 / 參考解答**：  
> 本題完整標準解答與設計思維請參閱 [📖 `solutions/README.md#unit-57-因果圖與決策表測試`](./solutions/README.md#unit-57-因果圖與決策表測試) 或獨立原始碼 [`solutions/5.7_decision/PromotionDecisionExerciseTest.java`](./solutions/5.7_decision/PromotionDecisionExerciseTest.java)。

---

⬅️ **上一章**：[🎯 Lab 05-2: 輸入空間劃分測試 — BVA 與 EP (`partition.md`)](./partition.md)  
👉 **下一章**：[🔄 Lab 05-4: 狀態、情境、經驗與屬性測試 (`behavioral.md`)](./behavioral.md)
