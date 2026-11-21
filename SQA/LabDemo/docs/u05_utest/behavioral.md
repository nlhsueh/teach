# 🔄 Lab 05-4: 狀態、情境、經驗與屬性測試 (`u05_behavioral`)

> 🧭 **Lab 05 四大主題導覽**：
> 1️⃣ [JUnit 5 基礎 (`u05_junit`)](./junit.md) ·
> 2️⃣ [輸入分割 BVA / EP (`u05_partition`)](./partition.md) ·
> 3️⃣ [組合與規則 Pairwise / CTM / 決策表 (`u05_combinatorial`)](./combinatorial.md) ·
> **4️⃣ [行為、經驗與屬性 (`u05_behavioral`)](./behavioral.md)** *(本頁)* ·
> 📚 [參考解答庫 (`solutions/README.md`)](./solutions/README.md)

> 📂 **本分類程式碼目錄**：
> - 待測主程式：[`src/main/java/u05_behavioral/`](../../src/main/java/u05_behavioral/)（`state/AirlineTicket.java`、`state/Stack.java`、`state/Player.java`、`usecase/AtmWithdrawService.java`、`experience/UserProfileService.java`、`pbtest/MathFunctions.java`、`pbtest/MetamorphicSearch.java`）
> - 示範與練習測試：[`src/test/java/u05_behavioral/`](../../src/test/java/u05_behavioral/)
> - 快速執行本分類所有測試：`mvn test -Dtest="u05_behavioral.**"`

---

## 📋 本分類 (`u05_behavioral`) 實驗對照表

| 課堂章節 | 模組分類目錄 | 核心技術解鎖 | 專案示範程式 (Demo) | 課堂動手練習 (Exercise) |
| :--- | :--- | :--- | :--- | :--- |
| **5.8** | [`u05_behavioral/state/`](../../src/test/java/u05_behavioral/state/) | 全轉移覆蓋 (5 路徑)、虛擬時鐘 `Clock`、前置隔離 `@BeforeEach`、狀態階層 `@Nested`、狀態不變量 | `AirlineTicketStateDemoTest.java`<br>`StackStateDemoTest.java`<br>`PlayerStateDemoTest.java` | `StackStateExerciseTest.java`<br>*(1-Switch 轉移序列與非法轉移防護)* |
| **5.9** | [`u05_behavioral/usecase/`](../../src/test/java/u05_behavioral/usecase/) | 業務情境規格、基本流 (Happy Path)、替代流 (Alternative Path)、例外流 (Exception Path) | `AtmUseCaseDemoTest.java` | `AtmUseCaseExerciseTest.java`<br>*(連續 3 次錯誤密碼鎖卡防衛例外流)* |
| **5.10** | [`u05_behavioral/experience/`](../../src/test/java/u05_behavioral/experience/) | 直覺錯誤推測 (Error Guessing)、攻擊探針、極端畸形邊緣測資 (Boundary/Special Chars) | `ErrorGuessingDemoTest.java` | `ExploratoryExerciseTest.java`<br>*(畸形 Email 與 Null 指標注入防衛測試)* |
| **5.11** | [`u05_behavioral/pbtest/`](../../src/test/java/u05_behavioral/pbtest/) | 屬性不變量 `@Property`、隨機測資 `@ForAll`、測資收縮 (Shrinking)、變質關係 (MR) | `PropertyBasedDemoTest.java`<br>`MetamorphicDemoTest.java` | `PropertyBasedExerciseTest.java`<br>`MetamorphicExerciseTest.java`<br>*(乘法交換律、串列長度守恆、大小寫不敏感變質關係)* |
| **進階** | [`AI 輔助測試`](#-進階單元ai-輔助單元測試生成教學) | Prompt Engineering 四大要素、測試 Oracle 責任、反例收斂 | - | 練習：撰寫注入測試知識的高品質 Prompt |

---

## 🔄 5.8: 狀態轉換測試實戰

### 1. 痛點剖析：狀態殘留污染與 void 動作檢驗
- 狀態測試著重於「物件在特定狀態下的外顯行為」與「激發事件後的轉移」。
- 很多操作（如 `push`, `pop`, `turnOn`）為 `void` 方法，需透過狀態屬性查詢方法驗證；
- 且測試必須保證進入目標狀態前，前置步驟是獨立且乾淨的，避免上一個測試殘留狀態導致假警報。

### 2. JUnit 5 解決方案
- **生命週期前置隔離 (`@BeforeEach`)**：每個測試案例執行前獨立初始化物件並激發特定前置序列。
- **巢狀狀態階層 (`@Nested`)**：以巢狀類別直接對應狀態機的每個狀態節點。

### 3. Demo 演示：`AirlineTicketStateDemoTest.java`、`StackStateDemoTest.java` 與 `PlayerStateDemoTest.java`
1. **✈️ 航空訂票狀態機（對應課堂 6 狀態 / 8 轉移模型）**：開啟 [`u05_behavioral/state/AirlineTicketStateDemoTest.java`](../../src/test/java/u05_behavioral/state/AirlineTicketStateDemoTest.java)（受測類別：[`AirlineTicket.java`](../../src/main/java/u05_behavioral/state/AirlineTicket.java)）
   - **Part 1（全轉移覆蓋 5 條路徑）**：以 5 條端到端事件序列覆蓋全部 6 個狀態節點與 8 條轉移弧線（`giveInfo ➔ payMoney ➔ print ➔ giveTicket` 正常登機、三階段主動取消 `cancel`、逾期未付 `payTimeExpire`），並示範注入虛擬時鐘 **`Clock.fixed`** 瞬間快轉 25 小時，免 `Thread.sleep` 驗證逾時轉移。
   - **Part 2（狀態轉移表 ❌ 非法轉移防禦）**：以 `@Nested` + `@BeforeEach` 依現態分組（`WhenMadeTests`、`WhenPaidTests`、`WhenTicketedTests`、`TerminalStateInvariantTests`），驗證所有非法事件均拋出 `IllegalStateException` 且不污染原狀態（如已登機 `USED` 禁止再退票）。
2. **📦 物件導向堆疊狀態機**：開啟 [`u05_behavioral/state/StackStateDemoTest.java`](../../src/test/java/u05_behavioral/state/StackStateDemoTest.java) 與 [`u05_behavioral/state/PlayerStateDemoTest.java`](../../src/test/java/u05_behavioral/state/PlayerStateDemoTest.java)：
   - 空狀態 (`EmptyStateTests`)：驗證 `isEmpty == true` 與 `pop` 拋出 `EmptyStackException`。
   - 滿狀態 (`FullStateTests`)：驗證 `isFull == true` 與 `push` 拋出 `IllegalStateException` (Stack Overflow)。

### 🧪 5.8 課堂動手練習
開啟 [`u05_behavioral/state/StackStateExerciseTest.java`](../../src/test/java/u05_behavioral/state/StackStateExerciseTest.java)：
1. **練習 1**：驗證 Empty ➔ Non-Empty ➔ Empty 狀態閉環轉移序列 (1-Switch)。
2. **練習 2**：驗證在空狀態執行 `peek()` 時拋出例外，且物件狀態不變量（依然為空）不被破壞！

> 💡 **卡關求助 / 參考解答**：  
> 本題完整標準解答與設計思維請參閱 [📖 `solutions/README.md#unit-58-狀態轉換測試`](./solutions/README.md#unit-58-狀態轉換測試) 或獨立原始碼 [`solutions/5.8_state/StackStateExerciseTest.java`](./solutions/5.8_state/StackStateExerciseTest.java)。

---

## 🏦 5.9: 使用案例測試 (Use Case Testing) 實戰

### 1. 痛點剖析：孤立單元測試無法保證端到端業務旅程
- 系統內部各方法雖然各自綠燈，但在真實使用者操作時，多步驟連鎖交互仍常引發商務漏洞。
- 使用案例測試著重於端到端的使用者業務旅程（Actor Goal），涵蓋**基本流 (Happy Path)**、**替代流 (Alternative Path)** 與 **例外流 (Exception Path)**。

### 2. Demo 演示：`AtmUseCaseDemoTest.java`
開啟 [`u05_behavioral/usecase/AtmUseCaseDemoTest.java`](../../src/test/java/u05_behavioral/usecase/AtmUseCaseDemoTest.java)：
- **基本流 (UC-01 Happy Path)**：正確 PIN 碼 ➔ 提款金額合法且充足 ➔ 吐鈔成功且餘額精確扣減。
- **替代流 (UC-02 Alt Path)**：提款金額超過單筆上限（20,000 元）➔ 系統拒絕交易並維持帳戶餘額。
- **例外流 (UC-03 Exception Path)**：提款金額超過帳戶現有餘額 ➔ 系統提示餘額不足並維持帳戶餘額。

### 🧪 5.9 課堂動手練習
開啟 [`u05_behavioral/usecase/AtmUseCaseExerciseTest.java`](../../src/test/java/u05_behavioral/usecase/AtmUseCaseExerciseTest.java)：
- **練習重點**：實作「防盜刷 PIN 碼連續錯誤 3 次鎖卡」之嚴格例外流（UC-04）。
- 驗證前 2 次錯誤提示剩餘次數，第 3 次精準觸發鎖卡，且鎖卡後即便輸入正確密碼依然拒絕服務！

> 💡 **卡關求助 / 參考解答**：  
> 本題完整標準解答與設計思維請參閱 [📖 `solutions/README.md#unit-59-使用案例測試-use-case`](./solutions/README.md#unit-59-使用案例測試-use-case) 或獨立原始碼 [`solutions/5.9_usecase/AtmUseCaseExerciseTest.java`](./solutions/5.9_usecase/AtmUseCaseExerciseTest.java)。

---

<!-- id: sqa-u05-junit-ccq3 -->
## 🕵️ 5.10: 經驗基礎與錯誤推測 (Error Guessing) 實戰

### 1. 痛點剖析：規格書不會寫的直覺盲區與攻擊向量
- 形式化規格書通常只定義「理想與標準的輸入輸出」，但惡意使用者或極端環境常輸入規格書未明定的髒資料。
- 測試工程師依據過去慘痛的踩坑經驗（直覺、缺陷歷史、安全弱點清單），主動設計「破壞性測試探針」。

### 2. Demo 演示：`ErrorGuessingDemoTest.java`
開啟 [`u05_behavioral/experience/ErrorGuessingDemoTest.java`](../../src/test/java/u05_behavioral/experience/ErrorGuessingDemoTest.java)：
- **字串繞過**：純空白字元（`"   "`）是否能繞過非空檢驗？
- **數值溢位**：年齡輸入 `Integer.MAX_VALUE` 是否造成計算崩潰？
- **安全注入探針**：輸入包含 HTML/XSS 特殊符號（`<script>alert(1)</script>`）是否被妥善過濾？

### 🧪 5.10 課堂動手練習
開啟 [`u05_behavioral/experience/ExploratoryExerciseTest.java`](../../src/test/java/u05_behavioral/experience/ExploratoryExerciseTest.java)：
- **練習 1**：針對 Email 格式進行經驗推測（缺少 `@`、結尾無 Domain、雙重 `@`、空白注入）。
- **練習 2**：輸入 `null` 物件之邊緣崩潰防衛驗證！

> 💡 **卡關求助 / 參考解答**：  
> 本題完整標準解答與設計思維請參閱 [📖 `solutions/README.md#unit-510-經驗基礎與錯誤推測`](./solutions/README.md#unit-510-經驗基礎與錯誤推測) 或獨立原始碼 [`solutions/5.10_experience/ExploratoryExerciseTest.java`](./solutions/5.10_experience/ExploratoryExerciseTest.java)。

---

## 🔮 5.11: 以性質為基礎的測試 (PBT) 與變質測試實戰

> 📖 **完整 jqwik 框架實戰與 Shrinking 深入教學**：請參閱 [👉 **jqwik 屬性基礎測試專題手冊 (`jqwik_property_based.md`)**](./jqwik_property_based.md)。

### 1. 痛點剖析：手動單元測試的 Oracle 盲區與覆蓋極限
- **Example-based 侷限**：手動編寫的單一測資（如 `add(2, 3) == 5`）容易帶有開發者的認知偏見，難以覆蓋邊緣極值（如負數溢位、巨大字串）。
- **無 Oracle 困境**：對於複雜演算法（如搜尋引擎、影像辨識、機器學習），我們很難預先人工計算出複雜輸入的「唯一精確輸出」，無法直接下 `assertEquals`。

### 2. 現代解方：PBT 屬性不變量 + Metamorphic 變質關係
- **Property-Based Testing (jqwik)**：
  - 放棄單點驗算，改為描述通用數學性質（如交換律 `a+b == b+a`、反轉兩次不變量 `reverse(reverse(L)) == L`）。
  - 自動生成 1,000 組隨機輸入，若爆掉則自動啟動 **測資收縮 (Shrinking)**，找出最簡反例。
- **變質測試 (Metamorphic Testing)**：
  - 即使不知道精確輸出，我們仍能驗證**輸入轉換前後的輸出對稱關係**（如搜尋 `SQA` 的結果集合，必然包含搜尋 `SQA 2026` 的結果集合）。

### 3. Demo 演示：`u05_behavioral/pbtest`
開啟 [`u05_behavioral/pbtest/PropertyBasedDemoTest.java`](../../src/test/java/u05_behavioral/pbtest/PropertyBasedDemoTest.java) 與 [`u05_behavioral/pbtest/MetamorphicDemoTest.java`](../../src/test/java/u05_behavioral/pbtest/MetamorphicDemoTest.java)：
- **Part 1 (基礎代數與串列不變量)**：加法交換律、加法單位元、反轉兩次可逆、排序單調遞增不變量驗證。
- **Part 2 (企業商業邏輯不變量實戰)**：
  - **電商金流守恆 (`OrderDiscount`)**：對任意會員、金額 (`0 ~ 100,000`) 與支付方式，結帳金額必 `>= 0`（防倒貼漏洞）、`<= 原價`，且 `應付金額 + 折抵金額 == 原價`。
  - **會員等級尊榮單調性 (`OrderDiscount`)**：相同金額與支付方式下，`VIP 應付金額 <= 一般會員 <= 訪客`（防止定價倒掛 Bug）。
  - **銀行風控不變量 (`LoanCalculator`)**：核貸利率必介於法定 `[2.0%, 5.0%]`，且多貸 100 萬時利率只降不升。
- **變質測試 (`MetamorphicDemoTest.java`)**：搜尋引擎範圍縮小之子集包含性與前後空白抗擾動性驗證。

### 🧪 5.11 課堂動手練習
1. 開啟 [`u05_behavioral/pbtest/PropertyBasedExerciseTest.java`](../../src/test/java/u05_behavioral/pbtest/PropertyBasedExerciseTest.java)：
   - **練習 1**：實作「乘法交換律」不變量屬性。
   - **練習 2**：實作「反轉串列長度守恆」不變量屬性。
   - **練習 3 (企業邏輯實戰)**：使用 `@IntRange` 與 `@DoubleRange` 驗證銀行房貸「青年首購利率 `<=` 一般申貸利率 且 `>= 2.0%`」不變量！
2. 開啟 [`u05_behavioral/pbtest/MetamorphicExerciseTest.java`](../../src/test/java/u05_behavioral/pbtest/MetamorphicExerciseTest.java)：
   - 實作關鍵字大小寫不敏感（Case-Insensitive）變質關係對稱性驗證！

> 💡 **卡關求助 / 參考解答**：  
> 本題完整標準解答與設計思維請參閱 [📖 `solutions/README.md#unit-511-屬性測試-pbt-與變質測試`](./solutions/README.md#unit-511-屬性測試-pbt-與變質測試) 或獨立原始碼 [`solutions/5.11_pbtest/`](./solutions/5.11_pbtest/)。

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

---

⬅️ **上一章**：[🧩 Lab 05-3: 多維組合與邏輯規則測試 (`combinatorial.md`)](./combinatorial.md)  
🏠 **返回總覽**：[🧪 Lab 05-1: JUnit 5 基礎與測試架構 (`junit.md`)](./junit.md)
