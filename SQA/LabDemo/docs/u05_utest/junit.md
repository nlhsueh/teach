# 🧪 Lab 05-1: JUnit 5 基礎與測試架構 (`u05_junit`)

> 🧭 **Lab 05 四大主題導覽**：
> **1️⃣ [JUnit 5 基礎 (`u05_junit`)](./junit.md)** *(本頁)* ·
> 2️⃣ [輸入分割 BVA / EP (`u05_partition`)](./partition.md) ·
> 3️⃣ [組合與規則 Pairwise / CTM / 決策表 (`u05_combinatorial`)](./combinatorial.md) ·
> 4️⃣ [行為、經驗與屬性 (`u05_behavioral`)](./behavioral.md) ·
> 📚 [參考解答庫 (`solutions/README.md`)](./solutions/README.md)

> 📂 **本分類程式碼目錄**：
> - 待測主程式：[`src/main/java/u05_junit/`](../../src/main/java/u05_junit/)（`Calculator.java`、`Person.java`）
> - 示範與練習測試：[`src/test/java/u05_junit/`](../../src/test/java/u05_junit/)
> - 快速執行本分類所有測試：`mvn test -Dtest="u05_junit.**"`

---

## 📚 Unit 05 四大黑箱測試家族總覽

本單元採「概念講授 ➔ Lab Demo 操作 ➔ 深入方法 ➔ 課堂動手練習」之交錯式教學設計，專案程式碼與實驗手冊均依**四大測試方法家族**對應劃分：

| 分類 | 套件目錄 | 對應章節 | 核心主題與涵蓋子模組 | 實驗手冊 |
| :---: | :--- | :---: | :--- | :--- |
| **1** | `u05_junit/` | **5.2** | JUnit 5 快速入門、3A 原則、常用斷言、生命週期與隔離 | **[📖 `junit.md`](./junit.md)** *(本頁)* |
| **2** | `u05_partition/` | **5.3 ～ 5.4** | 單一值域輸入分割：`bva/` 邊界值分析、`ep/` 等價類分割 | **[📖 `partition.md`](./partition.md)** |
| **3** | `u05_combinatorial/` | **5.5 ～ 5.7** | 多維組合與邏輯規則：`pair/` 全成對測試、`ctm/` 分類樹、`decision/` 決策表 | **[📖 `combinatorial.md`](./combinatorial.md)** |
| **4** | `u05_behavioral/` | **5.8 ～ 5.11** | 行為、情境與屬性：`state/` 狀態轉換、`usecase/` 使用案例、`experience/` 錯誤推測、`pbtest/` PBT 與變質測試 | **[📖 `behavioral.md`](./behavioral.md)** |

---

## 📋 本分類 (`u05_junit`) 實驗對照表

| 課堂章節 | 模組分類目錄 | 核心技術解鎖 | 專案示範程式 (Demo) | 課堂動手練習 (Exercise) |
| :--- | :--- | :--- | :--- | :--- |
| **5.2** | [`u05_junit/`](../../src/test/java/u05_junit/) | 測試驅動、3A 原則、`@Test`、`assertEquals` vs. `assertSame`、`assertAll`、生命週期註解 | `CalculatorDemoTest.java`<br>`AssertionsDemoTest.java`<br>`LifeCycleDemoTest.java` | `CalculatorExerciseTest.java`<br>*(3A 減法、負數與零、物件同一性驗證)* |

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

### 3. Demo 1 演示：Calculator 計算機與 3A 原則 (`CalculatorDemoTest.java`)
開啟專案路徑：[`u05_junit/CalculatorDemoTest.java`](../../src/test/java/u05_junit/CalculatorDemoTest.java)

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
        // 1. Arrange: 準備受測實體
        Calculator calculator = new Calculator();
        // 2. Act: 執行受測方法
        int result = calculator.add(10, 25);
        // 3. Assert: 驗證輸出是否吻合預期
        assertEquals(35, result, "10 + 25 應該等於 35");
    }
}
```

---

### 4. Demo 2 演示：JUnit 5 常用斷言語法大全 (`AssertionsDemoTest.java`)
開啟專案路徑：[`u05_junit/AssertionsDemoTest.java`](../../src/test/java/u05_junit/AssertionsDemoTest.java)

單元測試的核心在於 **Test Oracle (驗收真理)** 的精準表達。JUnit 5 的 `org.junit.jupiter.api.Assertions` 提供了豐富且具表達力的斷言工具箱：

#### (1) 內容值等價 vs. 記憶體同一性
- **`assertEquals(expected, actual)`**：內部呼叫物件的 `equals()` 方法，驗證兩物件承載的**資料內容是否相等**。
- **`assertSame(expected, actual)`**：直接以記憶體指標位址（`==`）比對，驗證是否指向 Heap 中的**同一個物件實體**；反向驗證則使用 `assertNotSame`。

#### (2) 標準斷言與延遲求值訊息 (Lazy Messages)
當測試失敗時印出的診斷訊息需要較高成本的字串拼接或計算時，直接傳入字串會在每次執行測試時無條件運算。傳入 `Supplier<String>` (Lambda) 則具備**延遲求值 (Lazy Evaluation)** 特性，**僅在斷言失敗時**才會真正運算字串，大幅降低效能開銷：

```java
// 傳統字串：每次測試執行時無條件進行字串拼接
assertEquals(4, calculator.multiply(2, 2), "選填失敗訊息放在最後");

// 延遲求值：僅在斷言失敗時才會呼叫 generateFailureMessage 拼接字串
assertTrue('a' < 'b', () -> generateFailureMessage('a', 'b'));
```

#### (3) 群組斷言 (`assertAll`)：破解 Early Abort 盲區
傳統測試中若連續撰寫多個 `assertEquals`，一旦第一個斷言失敗就會立即拋錯中斷（Early Abort），導致後續狀態無法被檢查。`assertAll` 接受可變長度的 Executable (Lambda)，保證區塊內所有斷言**全數執行完畢**，並一次性聚合回報所有失敗點：

```java
assertAll("person 屬性驗證",
    () -> assertEquals("Jane", person.getFirstName()),
    () -> assertEquals("Doe", person.getLastName())
);
```

#### (4) 階層與相依性斷言 (Dependent Assertions)
利用 `assertAll` 內的巢狀區塊設計，可在前置條件（例如 Null 檢查）未通過時立即終止該區塊的深入檢查，避免噴出非預期的 `NullPointerException` 干擾診斷：

```java
assertAll("properties",
    () -> {
        String firstName = person.getFirstName();
        assertNotNull(firstName); // 前置檢查

        // 僅在 firstName 非 null 時，才會繼續深入斷言
        assertAll("first name 細部檢驗",
            () -> assertTrue(firstName.startsWith("J")),
            () -> assertTrue(firstName.endsWith("e"))
        );
    }
);
```

#### (5) 防禦性例外斷言 (`assertThrows`)
驗證受測方法是否在特定非法輸入下能正確且安全地拋出預期之例外類別，並可進一步驗證例外承載之錯誤訊息：

```java
ArithmeticException exception = assertThrows(
    ArithmeticException.class,
    () -> calculator.divide(1, 0)
);
assertEquals("Division by zero is not allowed.", exception.getMessage());
```

#### (6) 執行效能與逾時測試 (`assertTimeout`)
單元測試亦可用於把關關鍵操作之時間預算（Time Budget），確保程式碼在指定時限內執行完畢：

```java
// 驗證運算必須在 500 毫秒內完成，並回傳運算結果
String actualResult = assertTimeout(ofMillis(500), () -> {
    Thread.sleep(50);
    return "done";
});
assertEquals("done", actualResult);
```

---

### 5. Demo 3 演示：測試生命週期與測試隔離 (`LifeCycleDemoTest.java`)
開啟專案路徑：[`u05_junit/LifeCycleDemoTest.java`](../../src/test/java/u05_junit/LifeCycleDemoTest.java)

#### (1) JUnit 5 五大生命週期註解職責
為確保每個單元測試的獨立性與純淨性，JUnit 5 定義了標準化的生命週期鉤子 (Lifecycle Hooks)：

| 註解 | 作用層級 | 執行時機與次數 | 典型應用情境 |
| :--- | :--- | :--- | :--- |
| **`@BeforeAll`** | 類別層級 (`static`) | 全套測試開始前，僅執行 **1 次** | 啟動測試資料庫、載入大型全域配置 |
| **`@BeforeEach`**| 方法層級 | 每個 `@Test` 執行前，各執行 **1 次** | 初始化/重置受測物件 (`new Calculator()`) |
| **`@Test`**      | 方法層級 | 測試案例主體 | 執行 3A 測試邏輯與斷言驗證 |
| **`@AfterEach`** | 方法層級 | 每個 `@Test` 執行後，各執行 **1 次** | 清理暫存檔案、重置 Mock 狀態 |
| **`@AfterAll`**  | 類別層級 (`static`) | 全套測試結束後，僅執行 **1 次** | 關閉連線池、釋放系統資源 |

> ⚠️ **注意**：`@BeforeAll` 與 `@AfterAll` 在 JUnit 5 預設的生命週期模式下必須宣告為 `static` 方法。

#### (2) 生命週期執行順序流程
當一個測試類別包含兩個測試方法時，JUnit 5 的真實調用順序如下：

```text
[類別啟動] @BeforeAll (執行 1 次：全域環境初始化)
   │
   ├── [測試 1 前] @BeforeEach (重置受測物件，確保環境乾淨)
   │     └── [執行] @Test 1: testMethodOne()
   │   [測試 1 後] @AfterEach  (清理暫存資料)
   │
   ├── [測試 2 前] @BeforeEach (重新建立乾淨物件，不受測試 1 影響)
   │     └── [執行] @Test 2: testMethodTwo()
   │   [測試 2 後] @AfterEach  (清理暫存資料)
   │
[類別結束] @AfterAll (執行 1 次：全域資源釋放與連線關閉)
```

#### (3) 核心思維：測試隔離原則 (Test Isolation)
單元測試必須嚴格遵守 **F.I.R.S.T.** 原則中的 **Independent (獨立性)**：
- **嚴禁測試間相依**：測試案例不得依賴其他測試的執行順序或殘留狀態（例如先執行 Insert 測試，後面的 Update 測試才通過）。
- **零副作用與狀態殘留 (No Side-Effects)**：透過 `@BeforeEach` 重新 `new` 受測物件，或在 `@AfterEach` 回復資料狀態，確保任何單一測試無論「單獨跑」、「批次跑」或「隨機順序跑」，結果均百分之百一致。

---

### 🧪 5.2 課堂動手練習
開啟並執行 [`u05_junit/CalculatorExerciseTest.java`](../../src/test/java/u05_junit/CalculatorExerciseTest.java)：
1. **練習 1**：補全減法運算的 3A 測試代碼。
2. **練習 2**：使用 `assertAll` 聚合負數與零的加法運算。
3. **練習 3**：驗證 `Person` 物件之 `assertEquals` 與 `assertSame` 行為差異。

> 💡 **卡關求助 / 參考解答**：  
> 本題完整標準解答與設計思維請參閱 [📖 `solutions/README.md#unit-52-junit-5-基礎與-3a-原則`](./solutions/README.md#unit-52-junit-5-基礎與-3a-原則) 或獨立原始碼 [`solutions/5.2_junit/CalculatorExerciseTest.java`](./solutions/5.2_junit/CalculatorExerciseTest.java)。

---

👉 **下一章**：前往 [🎯 Lab 05-2: 輸入空間劃分測試 — BVA 與 EP (`partition.md`)](./partition.md)
