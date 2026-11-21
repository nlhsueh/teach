# 🎯 Lab 05-2: 輸入空間劃分測試 — BVA 與 EP (`u05_partition`)

> 🧭 **Lab 05 四大主題導覽**：
> 1️⃣ [JUnit 5 基礎 (`u05_junit`)](./junit.md) ·
> **2️⃣ [輸入分割 BVA / EP (`u05_partition`)](./partition.md)** *(本頁)* ·
> 3️⃣ [組合與規則 Pairwise / CTM / 決策表 (`u05_combinatorial`)](./combinatorial.md) ·
> 4️⃣ [行為、經驗與屬性 (`u05_behavioral`)](./behavioral.md) ·
> 📚 [參考解答庫 (`solutions/README.md`)](./solutions/README.md)

> 📂 **本分類程式碼目錄**：
> - 待測主程式：[`src/main/java/u05_partition/`](../../src/main/java/u05_partition/)（`bva/Triangle.java`、`bva/PoolTicketCalculator.java`、`ep/BinarySearch.java`、`ep/MathUtils.java`、`ep/PasswordValidator.java`）
> - 示範與練習測試：[`src/test/java/u05_partition/`](../../src/test/java/u05_partition/)
> - 快速執行本分類所有測試：`mvn test -Dtest="u05_partition.**"`

---

## 📋 本分類 (`u05_partition`) 實驗對照表

| 課堂章節 | 模組分類目錄 | 核心技術解鎖 | 專案示範程式 (Demo) | 課堂動手練習 (Exercise) |
| :--- | :--- | :--- | :--- | :--- |
| **5.3** | [`u05_partition/bva/`](../../src/test/java/u05_partition/bva/) | 獨立型 4n+1 / 強固 6n+1、參數化 `@ValueSource` / `@CsvSource`、群組斷言 `assertAll` | `TriangleBvaDemoTest.java` | `TriangleBvaExerciseTest.java`<br>`PoolTicketBvaExerciseTest.java`<br>*(On-Off-In 三點法與年齡階層邊界)* |
| **5.4** | [`u05_partition/ep/`](../../src/test/java/u05_partition/ep/) | 單一無效原則、例外斷言 `assertThrows`、資料驅動 `@CsvSource` / `@EnumSource` | `BinarySearchEpDemoTest.java`<br>`ParamDemoTest.java`<br>`ParamEnumDemoTest.java` | `PasswordValidatorEpExerciseTest.java`<br>*(長度邊界、純文字/數字弱密碼等價類)* |

---

<!-- id: sqa-u05-junit-ccq1 -->
## 🎯 5.3: 邊界值分析 (BVA) 實戰

### 1. 痛點剖析：臨界測資密集與 Early Abort 陷阱
- 邊界值分析 (BVA) 會針對邊緣點產生大量測試數值（`min-, min, min+, nom, max-, max, max+`）。
- 若在同一方法中寫多行常規斷言，一旦第一個 `min-` 斷言失敗，測試會立即拋錯中止，導致後續所有 `max` 邊界檢驗直接被跳過（Early Abort），造成嚴重漏檢！

### 2. JUnit 5 解決方案
- **參數化數值注入 (`@ValueSource` / `@CsvSource`)**：一套測試邏輯，自動批次跑遍所有臨界點。
- **群組聚合斷言 (`assertAll`)**：群組內所有斷言保證全部執行完畢，一次性收集並回報所有邊界失敗！

### 3. Demo 演示：`TriangleBvaDemoTest.java`
開啟專案路徑：[`u05_partition/bva/TriangleBvaDemoTest.java`](../../src/test/java/u05_partition/bva/TriangleBvaDemoTest.java)

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
1. 開啟 [`u05_partition/bva/TriangleBvaExerciseTest.java`](../../src/test/java/u05_partition/bva/TriangleBvaExerciseTest.java)：
   - 補全三角形強固邊界（`min-`、`max+`）越界測資。
   - 運用 On-Off-In 三點法檢驗兩邊之和的極限臨界點。
2. 開啟 [`u05_partition/bva/PoolTicketBvaExerciseTest.java`](../../src/test/java/u05_partition/bva/PoolTicketBvaExerciseTest.java)：
   - 規格：免費 (0~3歲)、兒童票 (4~12歲)、全票 (13~64歲)、敬老票 (≥ 65 歲)。
   - 使用 `@CsvSource` 驗證所有交界點票價，並用 `assertThrows` 驗證 -1 與 121 歲越界防禦！

> 💡 **卡關求助 / 參考解答**：  
> 本題完整標準解答與設計思維請參閱 [📖 `solutions/README.md#unit-53-邊界值分析-bva`](./solutions/README.md#unit-53-邊界值分析-bva) 或獨立原始碼 [`solutions/5.3_bva/`](./solutions/5.3_bva/)。

---

## 🧩 5.4: 等價類分割 (EP) 實戰

### 1. 痛點剖析：無效等價類防禦與多維測試表格
- **無效等價類**：依據單一無效原則，非法輸入（如負數邊長、空字串）的外顯行為不是正常輸出，而是觸發系統防禦性機制（拋出例外）。
- **有效等價類**：劃分出的正等價類、零值等價類等多組測試向量，若寫死在程式碼中將導致代碼臃腫且難以維護。

### 2. JUnit 5 解決方案
- **例外斷言 (`assertThrows`)**：精準攔截預期拋出的特定例外類別，並驗證錯誤提示訊息。
- **外部資料驅動 (`@CsvSource` / `@EnumSource`)**：將等價類測試向量外置至表格，測試邏輯與測資徹底解耦。

### 3. Demo 演示：`BinarySearchEpDemoTest.java`、`ParamDemoTest.java` 與 `ParamEnumDemoTest.java`
開啟專案路徑：
- [`u05_partition/ep/BinarySearchEpDemoTest.java`](../../src/test/java/u05_partition/ep/BinarySearchEpDemoTest.java)：
  - 單元素陣列命中 vs. 未命中。
  - 多元素陣列命中頭部、中間、尾部。
  - 空陣列邊界與傳入 `null` 之例外斷言。
- [`u05_partition/ep/ParamDemoTest.java`](../../src/test/java/u05_partition/ep/ParamDemoTest.java) 與 [`u05_partition/ep/ParamEnumDemoTest.java`](../../src/test/java/u05_partition/ep/ParamEnumDemoTest.java)：
  - 示範 `@ValueSource`、`@CsvSource`、`@CsvFileSource`、`@EnumSource` 資料驅動測試寫法。

### 🧪 5.4 課堂動手練習
開啟 [`u05_partition/ep/PasswordValidatorEpExerciseTest.java`](../../src/test/java/u05_partition/ep/PasswordValidatorEpExerciseTest.java)：
1. **練習 1**：驗證有效等價類密碼（長度 8~20 且含英數字）。
2. **練習 2**：使用 `assertThrows` 驗證長度過短 (<8) 與過長 (>20) 之無效等價類例外拋出。
3. **練習 3**：驗證純字母或純數字之弱密碼等價類回傳 `false`。

> 💡 **卡關求助 / 參考解答**：  
> 本題完整標準解答與設計思維請參閱 [📖 `solutions/README.md#unit-54-等價類分割-ep`](./solutions/README.md#unit-54-等價類分割-ep) 或獨立原始碼 [`solutions/5.4_ep/PasswordValidatorEpExerciseTest.java`](./solutions/5.4_ep/PasswordValidatorEpExerciseTest.java)。

---

⬅️ **上一章**：[🧪 Lab 05-1: JUnit 5 基礎與測試架構 (`junit.md`)](./junit.md)  
👉 **下一章**：[🧩 Lab 05-3: 多維組合與邏輯規則測試 (`combinatorial.md`)](./combinatorial.md)
