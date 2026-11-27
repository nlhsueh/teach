---
marp: true
theme: sqa-theme
_class: lead
_header: ''
paginate: true
html: true
header: '軟體品質保證 (SQA)'
footer: 'Ch07 整合測試與測試替身'
---

# 軟體品質與測試

### 第 7 章：整合測試 (Integration Testing) 與測試替身架構

授課教師：薛念林 教授

> 「單元測試證明了零件的完好，整合測試則驗證了齒輪的嚙合。」  
> 從純 Java 建構子依賴注入 (`Constructor DI`) 出發，親手實作 Top-Down (Stub)、Bottom-Up (Driver)、Mockito 測試替身與 **Testcontainers 容器化資料庫實戰**！

---

<!-- _class: outline-slide -->
<!-- header: '本章大綱 (Outline)' -->

## 本章重點導讀 (Key Highlights)

<div class="outline-columns">
<div>

### 🧩 純 Java 漸進式整合策略
- [**7.1 整合測試與 V 開發模型 (V-Model)**](#3)：
  - 為什麼單元測試全綠燈，組裝起來卻崩潰？六大介面錯誤
  - 純 Java 實戰剖析：`Calculator` 除以零之**前後置契約失配**
  - 建構子依賴注入 (`Constructor Injection`) 與三層架構呼叫鏈
- [**7.2 由下而上整合 (Bottom-Up Integration)**](#7)：
  - 核心哲學、測試驅動程式 (**Test Driver**) 與五步推進流程
  - 純 Java 實戰：`RealPrimeChecker` ➔ `Prime` 真實組裝演練
- [**7.3 由上而下整合 (Top-Down Integration)**](#10)：
  - 核心哲學、測試存根 (**Test Stub**) 與質數列印三模組推演
  - 純 Java 實戰：手寫 `MockPrimeChecker` Stub 隔離頂層測試
- [**7.4 整合測試策略比較 (Comparison)**](#12)：
  - Big Bang、Top-Down、Bottom-Up 與三明治整合 (Sandwich) 評比
  - 🎮 *互動模擬：四大整合策略演進與 Driver/Stub 動態追蹤* (CCQ 1)

</div>
<div>

### 🎭 測試替身、Mockito 與容器化實戰
- [**7.5 隔離架構與測試替身原則 (Test Doubles)**](#16)：
  - 從 Driver/Stub 到 **5 大替身**（Dummy, Stub, Spy, Mock, Fake）
  - 何時用 Mock vs. 真實物件（`Market` 台積電股價）、脆化測試反模式
  - 🎯 *互動練習：五大測試替身情境判別挑戰* (CCQ 2)
- [**7.6 Lab: Mockito 測試驅動與模擬 (`u07_mockito`)**](#22)：
  - `mock()`、`@Mock` + `@InjectMocks`、`spy()` 局部修補、`verify()` 抓漏
- [**7.7 Testcontainers 容器化資料庫實戰 (`u07_testcontainers`)**](#26)：
  - H2 記憶體資料庫的「假綠燈幻覺」（JSONB、Upsert、約束碼）
  - 純 Java JDBC + `@Testcontainers` 動態啟動真實 PostgreSQL 16
  - 🎮 *互動模擬：H2 陷阱對照 ＆ Docker 容器 5 步生命週期*
- [**7.8 課堂實習與綜合練習 (`LabDemo`)**](#30)：
  - `u07_mockito` 三大模組 + `u07_testcontainers` 實戰與必考快篩

</div>
</div>

---

<!-- _class: lead -->
<!-- header: '7.1 整合測試與 V 開發模型' -->

# **7.1 整合測試與 V 開發模型 (V-Model)**

> 「兩把門鎖把手單獨旋轉都很順暢（單元測試 100% 通過），  
> 但安裝在同一扇雙開門上卻互相卡死——這就是為什麼我們需要整合測試。」

---

<!-- header: '7.1 整合測試與 V 開發模型' -->

## 為什麼單元測試全過，組裝起來卻崩潰？V 模型與測試層級

<div class="card-deck">

> 💡 整合測試（Integration Testing）聚焦於檢驗多個類別、模組或服務在**協同作業與介面傳遞**時的交互正確性。

<div class="content-columns">
<div class="content-text">

- **三大測試層級定位**：
  1. **單元測試**：檢視個別類別或單一方法之內部邏輯（對應詳細設計）。
  2. **整合測試 (Integration Testing)**：檢驗多個模組之間的**介面組合與參數契約**。
  3. **系統測試 (System Testing)**：檢驗完整軟硬體系統整體行為與非功能品質（對應系統需求）。
- **⚠️ 整合階段常見的六大錯誤**：
  1. **版本管理問題**（A 模組升級了介面，B 模組仍用舊版）
  2. **遺漏、重複或互相衝突的功能**（雙方都沒做防呆，或重複扣款）
  3. **不正確或不一致的資料結構**（回傳陣列順序或單位定義不同）
  4. **Client 送來的資料違反 Server 的前置條件 (Precondition)**
  5. **錯誤的參數值傳遞**（如寬高參數順序傳反）
  6. **多執行緒 (Threads) 之間的資源互相衝突與死結**

</div>
<div class="content-figure">

![V-Model](../../img/ch07/BknjbJHVT.png)

</div>
</div>
</div>

---

<!-- header: '7.1 整合測試與 V 開發模型' -->

## 純 Java 實戰案例：為什麼兩個 100% 綠燈的類別整合後卻崩潰？

<div class="card-deck">

> 💡 See [Calculator.java](../../lab.html?file=LabDemo/src/main/java/u07_mockito/calculator/Calculator.java) 與 [RealCalculatorService.java](../../lab.html?file=LabDemo/src/main/java/u07_mockito/calculator/RealCalculatorService.java): 「**介面契約推諉 (Contract Mismatch)**」！

<div class="two-columns">
<div class="card">

##### 💻 兩個各自獨立開發的純 Java 類別
- **上層呼叫者 (`Calculator.java`，由工程師 A 開發)**：
  ```java
  public class Calculator {
      private final CalculatorService service;
      // 透過建構子依賴注入 (Constructor DI)
      public Calculator(CalculatorService service) {
          this.service = service;
      }
      public int divide(int a, int b) {
          // 工程師 A 心想：「除以 0 的防呆應該由底層 Service 負責拋出
          // IllegalArgumentException 吧！」所以直接轉交：
          return service.divide(a, b);
      ...
  ```
- **底層實作 (`RealCalculatorService.java`，by 工程師 B)**：
  ```java
  public class RealCalculatorService implements CalculatorService {
      @Override
      public int divide(int a, int b) {
          // 工程師 B 心想：「上層傳進來前一定已經檢查過 b != 0 了！」
          return a / b; // 直接相除！
      ...
  ```

</div>
<div class="card">

##### 💥 單元測試全綠燈 vs. 真實整合大爆炸！
- **1. A 做單元測試 ([CalculatorTest.java](../../lab.html?file=LabDemo/src/test/java/u07_mockito/calculator/CalculatorTest.java#L87))** — 🟩 **綠燈！**
  ```java
  // A 用 Mock 假設底層除以 0 會乖乖拋出 IllegalArgumentException：
  when(calculatorService.divide(6, 0))
      .thenThrow(IllegalArgumentException.class);
  assertThrows(IllegalArgumentException.class,
      () -> calculator.divide(6, 0)); // ✅ 單元測試通過！
  ```
- **2. B 做單元測試 ([RealCalculatorTest.java](../../lab.html?file=LabDemo/src/test/java/u07_mockito/calculator/RealCalculatorTest.java))** — 🟩 **綠燈！**
  - B 只測了正常數值 `divide(6,3)==2`，單元測試也通過！
- **3. 真實整合測試** — 🟥 **崩潰！**
  ```java
  Calculator realCalc = new Calculator(new RealCalculatorService());
  realCalc.divide(6, 0);
  // 💥 炸出 ArithmeticException: / by zero！而非預期的 IllegalArgumentException！
  ```
- 單元測試用 Mock 只驗證了「你以為的假設」；唯有真實整合測試，才能抓出模組間「誰該負責檢查前置條件」的契約斷裂！

</div>
</div>
</div>

---

<!-- header: '7.1 整合測試與 V 開發模型' -->

## 支援整合測試的程式設計基石：建構子依賴注入 (Constructor DI)

<div class="card-deck">

<div class="two-columns">
<div class="card">

#### ❌ 內部硬編碼 `new`（無法隔離與漸進整合）
```java
public class Prime {
    // ❌ 致命寫法：把底層實作死鎖在類別內部！
    private final PrimeChecker checker = new RealPrimeChecker();

    public int[] allPrime(int n) { ... }
}
```
- **為什麼這樣寫會讓測試寸步難行？**
  1. 若 `RealPrimeChecker` 還沒寫完，或內部需要連線真實資料庫，`Prime` 就**完全無法單獨編譯與測試**！
  2. 無法在由上而下測試時換成假程式 (`Stub`)，也無法在單元測試時注入 `Mockito` 替身。

</div>
<div class="card">

#### ✅ 依賴介面 + 建構子注入
```java
public class Prime {
    private final PrimeChecker primeChecker; // 依賴抽象介面
    // ✅ 由外部決定要傳入「假樁 (Stub)」還是「真實物件 (Real)」！
    public Prime(PrimeChecker primeChecker) {
        this.primeChecker = primeChecker;
    }
    public int[] allPrime(int n) { ... }
}
```
- **一套程式碼，支援三種測試階段自由插拔**：
  1. **由上而下測試 (Top-Down)**：`new Prime(new MockPrimeChecker())` *(手寫 Stub)*
  2. **Mockito 動態模擬**：`new Prime(mock(PrimeChecker.class))` *(動態 Mock)*
  3. **由下而上真實整合 (Bottom-Up)**：`new Prime(new RealPrimeChecker())` *(真實組裝)*

</div>
</div>
</div>

---

<!-- _class: lead -->
<!-- header: '7.2 由下而上整合 (Bottom-Up)' -->

# **7.2 由下而上整合測試 (Bottom-Up Integration)**

> 「從最底層不依賴任何人的基礎模組測起；  
> 關鍵在於設計『測試驅動程式 (Test Driver)』主動餵入參數，地基穩固後再逐層往上真實組裝！」

---

<!-- header: '7.2 由下而上整合 (Bottom-Up)' -->

## 由下而上整合測試原理與五步漸進推演

<div class="card-deck">
<div class="content-columns">
<div class="content-text">

#### 🧱 五步漸進式由下而上整合流程
1. **步驟 1（測試最底層葉節點）**：
   - 分別撰寫 `b`, `c`, `a` 等 **Test Driver**，測試模組 **E, F, G, D** 是否正常。
2. **步驟 2（組裝第一層子系統）**：
   - 用真實模組 **B** 替換掉假驅動 `b`，改由上一層 Driver `a` 驅動測試 **B-E-F** 三者的真實互動！
3. **步驟 3**：用真實 **C** 替換 `c`，利用 Driver `a` 測試 **B-C** 溝通。
4. **步驟 4**：用真實 **D** 替換 `d`，利用 Driver `a` 測試 **B-C-D** 溝通。
5. **步驟 5（全系統合龍）**：
   - 用最頂層真實模組 **A** 替換 `a`，利用測試驅動 `x` 測試 **A-B, A-C, A-D** 整體協作！

> 🎯 **現代關鍵觀念**：在 JUnit 時代，我們不需要另外寫 `main()` 當 Driver——**每一個 `@Test` 測試方法本身就是一個標準的 Test Driver！**

</div>
<div class="content-figure">

![Bottom-Up Integration](../../img/ch07/HyQJGyS4T.png)

</div>
</div>
</div>

---

<!-- header: '7.2 由下而上整合 (Bottom-Up)' -->

## 純 Java 由下而上實戰：`RealPrimeChecker` ➔ `Prime` 漸進組裝

<div class="card-deck">

> 💡 對照 [RealPrimeChecker.java](../../lab.html?file=LabDemo/src/main/java/u07_mockito/prime/RealPrimeChecker.java)、[Prime.java](../../lab.html?file=LabDemo/src/main/java/u07_mockito/prime/Prime.java) 與 [PrimeTest.java](../../lab.html?file=LabDemo/src/test/java/u07_mockito/prime/PrimeTest.java#L85)，體驗零 Mock 的由下而上真實整合！

<div class="two-columns">
<div class="card">

##### 1️⃣ 以 JUnit Driver 測試最底層 `RealPrimeChecker`
- **底層葉節點**：不依賴任何其他類別。
  ```java
  public class RealPrimeChecker implements PrimeChecker {
      public boolean isPrime(int num) {
          if (num < 2) return false;
          for (int i = 2; i * i <= num; i++) {
              if (num % i == 0) return false;
          }
          return true;
      }
  }
  ```
- **撰寫 Test Driver (`@Test`) 先把地基測穩**：
  ```java
  @Test // JUnit 測試方法即 Test Driver，主動丟參數給底層模組
  public void testRealIsPrimeDriver() {
      RealPrimeChecker checker = new RealPrimeChecker();
      assertTrue(checker.isPrime(2));
      assertFalse(checker.isPrime(10));
  }
  ```

</div>
<div class="card">

##### 2️⃣ 底層通過後，向上與真實 `Prime` 組裝整合！
- **中層業務模組**：呼叫 `isPrime(i)` 篩出所有質數。
  ```java
  public class Prime {
      private final PrimeChecker primeChecker;
      public Prime(PrimeChecker primeChecker) {
          this.primeChecker = primeChecker;
      }
      public int[] allPrime(int n) {
          ArrayList<Integer> primes = new ArrayList<>();
          for (int i = 2; i <= n; i++) {
              if (primeChecker.isPrime(i)) primes.add(i);
          }
          return primes.stream().mapToInt(i -> i).toArray();
      }
  }
  ```
- **由下而上整合測試**：
  ```java
  @Test // 完全不用 Stub/Mock！直接把已驗證的真實底層裝進 Prime
  public void testAllPrimeWithRealPrimeChecker() {
      PrimeChecker realCheck = new RealPrimeChecker();
      Prime prime = new Prime(realCheck); // 真實組裝 B + E
      assertArrayEquals(new int[]{2, 3, 5, 7}, prime.allPrime(10));
  }
  ```

</div>
</div>
</div>

---

<!-- _class: lead -->
<!-- header: '7.3 由上而下整合 (Top-Down)' -->

# **7.3 由上而下整合測試 (Top-Down Integration)**

> 「當底層演算法或資料庫還沒寫好，但上層邏輯急需先行驗證時——  
> 先接上一個極簡的『假程式 / 存根 (Test Stub)』，讓高階模組能立刻跑起來！」

---

<!-- header: '7.3 由上而下整合 (Top-Down)' -->

## 由上而下整合測試原理與「質數列印」三模組推演

<div class="card-deck">

> 💡 **Stubs (測試存根 / 假程式)**：著重介面吻合、回傳固定假資料，不寫真實演算法！

<div class="two-columns-64">
<div class="card">

### 平行開發「質數列印 (`Displayer` ➔ `allPrime` ➔ `isPrime`)」
1. **階段一：先測最頂層 `display()`（此時 `allPrime` 還沒寫好）**：
   - 撰寫 `allPrime` 的 **Stub**，固定回傳 `{2,3,5,7}` 讓 `display()` 先行測試版面：
   ```java
   int[] allPrime(int n) { return new int[]{2, 3, 5, 7}; } // <-- Stub 假程式
   ```
2. **階段二：換上真實 `allPrime()`，搭配底層 `isPrime` 的手寫 Stub**：
   ```java
   public class MockPrimeChecker implements PrimeChecker { // 手寫 Stub 類別
       public boolean isPrime(int n) {
           return (n == 2 || n == 3 || n == 5); // 僅硬編碼 2, 3, 5 為質數！
       }
   }
   @Test void testAllPrimeWithMyMock() {
       Prime prime = new Prime(new MockPrimeChecker()); // 注入手寫 Stub
       assertArrayEquals(new int[]{2, 3, 5}, prime.allPrime(5)); // ✅ 通過！
   }
   ```
3. **階段三：最後才換成真實的 `RealPrimeChecker` 完成全系統整合！**

</div>
<div class="card">

### 🏛️ 由上而下五步整合流程
- 先為底層撰寫 `b, c, d` **Stubs** 測試頂層 **A**；
- 再用真實 **B, C, D** 替換 `b, c, d`，並為更底層撰寫 `e, f, g` Stubs；
- 逐層往下替換，直到全部換成真模組！

![Top-Down Integration](../../img/ch07/Sye8GJrVT.png)

</div>
</div>
</div>

---

<!-- _class: lead -->
<!-- header: '7.4 整合測試策略大比拼' -->

# **7.4 整合測試策略比較與三明治整合法**

> 「由上而下能提早確認高階流程但手寫 Stub 很累；由下而上 Driver 好寫但高階介面太晚驗證——  
> 實務上最常將兩者折衷結合，採用上下夾擊的『三明治整合法 (Sandwich Integration)』！」

---

<!-- header: '7.4 整合測試策略大比拼' -->

## 四大整合測試策略全方位對比矩陣

<div class="card-deck">

> 💡 為什麼從剛才的 `MockPrimeChecker` 可以看出「**設計 Stub 比設計 Driver 困難**」？因為 `MockPrimeChecker` 只硬編碼到 5，一旦上層改測 `allPrime(10)` 就會因漏掉 7 而失靈！

| 評估維度 | 大霹靂整合 (Big Bang) | 由上而下 (Top-Down) | 由下而上 (Bottom-Up) | 三明治整合 (Sandwich / 混合式) |
| :--- | :--- | :--- | :--- | :--- |
| **核心整合方向** | 所有類別寫完一次全部拼裝 | 從頂層主控/UI 往下逐步整合 | 從底層基礎工具/DAO 往上整合 | 以中間核心業務層為目標，上下夾擊 |
| **所需輔助程式** | 無（看似省事，實則災難） | 需設計大量 **Stubs（較困難）** | 需設計 **Drivers（JUnit 即 Driver，較容易）** | 頂層用少量 Stubs，底層用 Drivers |
| **最大優勢** | 無須撰寫額外替身輔助碼 | **儘早向使用者展示並確認系統介面與高階控制流程** | **底層地基穩固、Driver 易於以 JUnit 撰寫、錯誤易定位** | 兼顧早期高階流程確認與底層演算法穩定度 |
| **主要缺點 / 風險** | 錯誤全混在一起，**缺陷極難定位** | 手寫 Stub 難以模擬複雜狀態（如 `allPrime(10)` 漏掉 `7`） | **高階業務與 UI 最晚才成型**，若需求變更將引發大幅重工 | 需較周密的雙向測試規劃與團隊分工 |
| **純 Java `Prime` 對應** | 全部寫完才第一次跑 `main()` | `new Prime(new MockPrimeChecker())` | `RealPrimeChecker` ➔ `new Prime(new RealPrimeChecker())` | 頂層 UI 配 Stub、底層算術配 JUnit，於 `Prime` 層會師 |

</div>

---

<!-- header: '7.4 整合測試策略大比拼' -->

## 互動視覺化實驗室：四大整合策略演進模擬器（Driver vs. Stub）

<div class="int-interactive-stage" id="int-strat-lab">
<div class="shrink-toolbar">
  <div class="shrink-toolbar-group">
    <button type="button" class="shrink-btn is-active" data-int-mode="bu">1. 由下而上 (Bottom-Up)</button>
    <button type="button" class="shrink-btn" data-int-mode="td">2. 由上而下 (Top-Down)</button>
    <button type="button" class="shrink-btn" data-int-mode="sw">3. 三明治 (Sandwich)</button>
    <button type="button" class="shrink-btn" data-int-mode="bb">4. 大霹靂 (Big Bang)</button>
  </div>
  <div class="shrink-toolbar-group">
    <button type="button" class="shrink-btn is-primary" id="int-next-btn">⏭️ 推進下一步</button>
    <button type="button" class="shrink-btn" id="int-reset-btn">↺ 重設</button>
  </div>
</div>

<div class="int-grid">
  <div class="shrink-panel">
    <div class="shrink-panel-title">
      <span>🌳 模組相依樹（7 個純 Java 模組）</span>
      <span class="shrink-badge" id="int-step-badge">步驟 1 / 3</span>
    </div>
    <div class="int-svg-wrap">
      <svg viewBox="0 0 540 270" xmlns="http://www.w3.org/2000/svg">
        <g stroke="#94a3b8" stroke-width="2" fill="none">
          <line x1="270" y1="54" x2="115" y2="112"/>
          <line x1="270" y1="54" x2="270" y2="112"/>
          <line x1="270" y1="54" x2="425" y2="112"/>
          <line x1="115" y1="158" x2="85" y2="210"/>
          <line x1="115" y1="158" x2="215" y2="210"/>
          <line x1="425" y1="158" x2="425" y2="210"/>
        </g>
        <g class="int-node st-pending" id="int-node-A" transform="translate(195,12)">
          <rect width="150" height="42" rx="8"/><text x="75" y="18" text-anchor="middle" font-size="12" font-weight="800" fill="#0f172a">A: PrimeApp</text><text x="75" y="34" text-anchor="middle" font-size="10.5" fill="#475569" class="node-role">頂層主控</text>
        </g>
        <g class="int-node st-driver" id="int-node-B" transform="translate(45,112)">
          <rect width="140" height="46" rx="8"/><text x="70" y="20" text-anchor="middle" font-size="12" font-weight="800" fill="#0f172a">B: PrimeService</text><text x="70" y="36" text-anchor="middle" font-size="10.5" fill="#475569" class="node-role">Driver b</text>
        </g>
        <g class="int-node st-pending" id="int-node-C" transform="translate(205,112)">
          <rect width="130" height="46" rx="8"/><text x="65" y="20" text-anchor="middle" font-size="12" font-weight="800" fill="#0f172a">C: Formatter</text><text x="65" y="36" text-anchor="middle" font-size="10.5" fill="#475569" class="node-role">輸出格式化</text>
        </g>
        <g class="int-node st-driver" id="int-node-D" transform="translate(355,112)">
          <rect width="140" height="46" rx="8"/><text x="70" y="20" text-anchor="middle" font-size="12" font-weight="800" fill="#0f172a">D: AuditLogger</text><text x="70" y="36" text-anchor="middle" font-size="10.5" fill="#475569" class="node-role">Driver d</text>
        </g>
        <g class="int-node st-real" id="int-node-E" transform="translate(15,210)">
          <rect width="140" height="46" rx="8"/><text x="70" y="20" text-anchor="middle" font-size="12" font-weight="800" fill="#0f172a">E: RealPrimeChecker</text><text x="70" y="36" text-anchor="middle" font-size="10.5" fill="#15803d" class="node-role">真實模組 ✅</text>
        </g>
        <g class="int-node st-real" id="int-node-F" transform="translate(175,210)">
          <rect width="140" height="46" rx="8"/><text x="70" y="20" text-anchor="middle" font-size="12" font-weight="800" fill="#0f172a">F: RangeValidator</text><text x="70" y="36" text-anchor="middle" font-size="10.5" fill="#15803d" class="node-role">真實模組 ✅</text>
        </g>
        <g class="int-node st-real" id="int-node-G" transform="translate(355,210)">
          <rect width="140" height="46" rx="8"/><text x="70" y="20" text-anchor="middle" font-size="12" font-weight="800" fill="#0f172a">G: FileWriter</text><text x="70" y="36" text-anchor="middle" font-size="10.5" fill="#15803d" class="node-role">真實模組 ✅</text>
        </g>
      </svg>
    </div>
    <div class="int-legend">
      <span class="int-legend-pill"><span class="int-dot" style="background:#dcfce7;border:1.5px solid #16a34a;"></span>真實模組 (已測)</span>
      <span class="int-legend-pill"><span class="int-dot" style="background:#ffedd5;border:1.5px solid #ea580c;"></span>Test Driver</span>
      <span class="int-legend-pill"><span class="int-dot" style="background:#f3e8ff;border:1.5px solid #9333ea;"></span>Test Stub</span>
      <span class="int-legend-pill"><span class="int-dot" style="background:#f1f5f9;border:1.5px solid #94a3b8;"></span>待整合</span>
    </div>
  </div>

  <div class="shrink-panel">
    <div class="shrink-panel-title">
      <span id="int-mode-title">🧱 由下而上 (Bottom-Up)</span>
      <span style="font-size:11px;color:#64748b;font-weight:700;" id="int-proto-tag">原型可見度：晚</span>
    </div>
    <div class="int-kpi-triple">
      <div class="shrink-kpi"><div class="k-lbl">使用 Drivers</div><div class="k-val" id="int-kpi-drv" style="color:#ea580c;">2</div></div>
      <div class="shrink-kpi"><div class="k-lbl">使用 Stubs</div><div class="k-val" id="int-kpi-stb" style="color:#9333ea;">0</div></div>
      <div class="shrink-kpi"><div class="k-lbl">已驗證真實模組</div><div class="k-val" id="int-kpi-real" style="color:#16a34a;">3 / 7</div></div>
    </div>
    <div class="alt-mnemonic-box" id="int-step-desc" style="font-size:12.5px;line-height:1.48;">
      <strong>步驟 1：先測最底層葉節點 (E, F, G)</strong><br/>
      撰寫 JUnit Test Drivers 取代 B、D，直接驗證最底層演算法與 I/O。優點是零 Stubs、底層錯誤立刻暴露！
    </div>
    <div class="shrink-banner" id="int-step-banner">💡 點擊「⏭️ 推進下一步」觀察各層真實模組如何逐步取代 Driver 或 Stub！</div>
  </div>
</div>
</div>

---

<!-- header: '7.4 整合測試策略大比拼' -->

## 概念核對問答 (CCQ 1)

<div class="ccq-columns">
<div class="ccq-text">

<!-- id: sqa-ch07-ccq1 -->
**問題情境**：  
團隊正在開發一套無人自動駕駛控制系統：底層是直接與感測器（光達、雷達）通訊的高頻硬體驅動模組，頂層是決策與路徑規劃演算法。硬體部門回報感測器實體電路板目前極為脆弱且容易過熱故障。軟體測試工程師此時若要展開整合測試，最合理的策略應為何？

- **A)** 採用大霹靂整合，等待整車硬體與車載電腦全部組裝完畢後直接上路進行道路測試
- **B)** 採用由下而上整合，直接在真實車輛上長時間持續讀取實體匯流排感測器訊號
- **C)** 採用由上而下整合，先為脆弱的底層硬體撰寫 Stubs 模擬雷達資料以驗證高層演算法
- **D)** 完全不進行任何整合測試，只要感測器模組單元測試全數覆蓋即可直接出廠

</div>
<div class="ccq-logo">

<a href="https://nlhsueh.github.io/nickedupocket/#/student/sqa-ch07-ccq1" target="_blank"><img src="../../img/ch07/sqa-ch07-ccq1.png" alt="QR Code" /></a>

</div>
</div>

---

<!-- _class: lead -->
<!-- header: '7.5 隔離架構與測試替身原則' -->

# **7.5 隔離架構與測試替身原則 (Test Doubles)**

> 「剛才為了測 `Prime` 還得自己手寫一個 `MockPrimeChecker.java` 類別，太麻煩了！  
> 現代測試架構將這種替代品統稱為『測試替身 (Test Double)』，並由 Mockito 動態生成！」

---

<!-- header: '7.5 隔離架構與測試替身原則' -->

## 邏輯串接：從 Stubs/Drivers 到 Gerard Meszaros 五大測試替身

<div class="card-deck">

> 💡 在現代 JUnit 5 架構中，**`@Test` 本身就是 Driver**；而用來隔離真實依賴的五種替代品則統稱為 **Test Double（測試替身，源自電影替身演員 Stunt Double）**！

<div class="two-columns-64">
<div class="card">

1. **Dummy Object (虛設物件)**：僅用來**填充建構子或方法的必填參數列表**，測試過程中完全不會被調用（通常直接傳入 `null` 或空物件）。
2. **Stub (樁物件 / 填補物件)**：
   - 為受測物件提供**硬編碼或預設的固定回傳值**（如`when(checker.isPrime(3)).thenReturn(true)`），專司「提供間接輸入」。
3. **Spy (間諜物件)**：包裹真實物件（或部分實作物件），未打樁時執行原本邏輯，同時**秘密記錄被調用的次數與參數**。
4. **Mock Object (模擬物件)**：
   - 專注於**行為驗證 (Behavior Verification)**，透過 `verify()` 檢驗 SUT 是否依預期次數、參數與順序呼叫依賴項。
5. **Fake Object (偽物件)**：
   - 擁有**真實可運作但簡化的邏輯實作**（如用 Java `HashMap` 實作的記憶體資料庫 `FakeUserRepository`），有狀態且會動，但不適合正式生產環境。

</div>
<div class="card">

### 📊 五大測試替身速查表
| 替身種類 | 核心職責與口訣 | 驗證焦點 |
| :--- | :--- | :---: |
| **Dummy** | 純湊數佔位參數（啞巴木頭） | 無 |
| **Stub** | 提供固定預設回傳值（錄音機） | **狀態驗證**<br>*(State)* |
| **Spy** | 包裝真實物件並局部打樁（監視器） | 狀態 + 行為 |
| **Mock** | 驗證互動次數與參數（嚴格教官） | **行為驗證**<br>*(Behavior)* |
| **Fake** | 輕量簡化版可用實作（`HashMap` DB） | **狀態驗證**<br>*(State)* |

</div>
</div>
</div>

---

<!-- header: '7.5 隔離架構與測試替身原則' -->

## 為什麼需要測試替身？以 `LabDemo` 股票市值計算 (`MarketTest`) 為例

<div class="card-deck">

> 💡 [Market.java](../../lab.html?file=LabDemo/src/main/java/u07_mockito/stock/Market.java) 與 [MarketTest.java](../../lab.html?file=LabDemo/src/test/java/u07_mockito/stock/MarketTest.java)：如果 `Market.getMarketValue()` 直接連線證交所 API 抓台積電 (`2330`) 即時股價?

<div class="two-columns">
<div class="card">

### 📈 為什麼真實股價 API 不能直接拿來跑單元測試？
- **1. 股價每秒跳動（不確定性 Non-deterministic）**：
  - 早上測台積電 `1035` 元通過，下午漲到 `1050` 元，`assertEquals(29850, marketValue)` 當場紅燈失敗！
- **2. 外部網路緩慢、收盤或斷線（環境脆弱）**。
- **💻 `Market.java` 待測業務邏輯**：
  ```java
  public class Market {
      private StockService stockService; // 外部股價查詢介面
      private List<Stock> stocks;        // 持股清單 (股票代號, 股數)

      public double getMarketValue() {
          double marketValue = 0.0;
          for (Stock stock : stocks) {
              // 呼叫外部服務取得單價 × 持有股數
              marketValue += stockService.getPrice(stock)
                           * stock.getQuantity();
          }
          return marketValue;
      }
  }
  ```

</div>
<div class="card">

### 🧪 `MarketTest.java`：用 Stub 凍結外部股價！
```java
public class MarketTest {
    @Test
    public void testMarketValue() {
        Market market = new Market();
        // 1. 建立外部 StockService 的替身物件
        StockService stockService = mock(StockService.class);
        market.setStockService(stockService);

        // 2. 準備持股：10 股台積電 (2330) + 100 股元大台灣50 (0050)
        Stock tsmc = new Stock("2330", "TSMC", 10);
        Stock etf0050 = new Stock("0050", "0050", 100);
        market.setStocks(List.of(tsmc, etf0050));

        // 3. 佈樁 (Stubbing)：固定回傳假設股價，徹底隔離證交所網路！
        when(stockService.getPrice(tsmc)).thenReturn(1035.0);
        when(stockService.getPrice(etf0050)).thenReturn(195.0);

        // 4. 斷言總市值：1035*10 + 195*100 = 10350 + 19500 = 29850
        assertEquals(29850.0, market.getMarketValue());
    }
}
```
> 🎯 **注意到嗎？** 這裡我們對 `StockService`（外部網路依賴）用了 **Mock/Stub**，但對 `Stock`（純資料實體）與 `ArrayList` 則是直接 `new` **真實物件**！

</div>
</div>
</div>

---

<!-- header: '7.5 隔離架構與測試替身原則' -->

## 何時該用 Mock？何時不該用？警惕「脆化測試 (Brittle Tests)」

<div class="card-deck">

> 💡 **測試應專注於外顯行為 (Behavior-centric)，而非內部實作細節 (Implementation-centric)**！濫用 Mock 將使測試淪為重構的絆腳石。

<div class="two-columns">
<div class="card">

- **✅ 適合使用 Mock / Stub 的四大情境**：
  1. **外部或第三方依賴**：如 `StockService` 股價 API、簡訊發送、信用卡扣款閘道。
  2. **共享或緩慢的外部資源**：遠端資料庫查詢、檔案系統 I/O。
  3. **尚未開發完成的協同模組**：如平行開發中尚未寫好的 `PrimeChecker`。
  4. **非確定性行為 (Non-deterministic)**：系統時間 (`LocalDateTime.now()`)、隨機亂數。

- **❌ 不應使用 Mock 的三大情境（請直接 `new` 物件！）**：
  1. **純領域邏輯與演算法**：排序、金額加減、字串處理。
  2. **值物件與資料實體 (Value Objects / Entities)**：如 `new Stock("2330", "TSMC", 10)`
  3. **Java 標準庫容器**：切勿 Mock `List`、`ArrayList` 或 `Map`。

</div>
<div class="card">

### 🚨 脆化測試與過度 Mock 三大反模式
- **什麼是脆化測試 (Brittle Tests)？**
  - 當你重構了生產程式碼的**內部實作細節**（例如將 `for` 迴圈改寫為 Stream，或調整內部呼叫順序），在**公開業務行為與輸出結果完全正確**的前提下，測試案例卻突然大面積紅燈失敗！
- **過度 Mock (Over-Mocking) 三大反模式**：
  1. **Mock Everything（Mock 所有東西）**：一個測試 mock 了七八個物件並塞滿 `when().thenReturn()`，等於只是把生產程式碼用 Mockito 抄寫一遍。
  2. **緊密耦合內部細節**：過度使用 `verify()` 綁死內部非公開步驟的呼叫次數，一重構就斷裂。
  3. **Test Oracle 迷失（假綠燈）**：如 7.1 的 `CalculatorTest`，只驗證自己幻想的 Mock 例外，結果真實整合時當場炸出 `ArithmeticException`！

</div>
</div>
</div>

---

<!-- header: '7.5 隔離架構與測試替身原則' -->

## 互動實作練習：五大測試替身 (Test Double) 情境判別挑戰

<div class="td-quiz-stage" id="td-quiz-lab">
<div class="shrink-toolbar">
  <div class="shrink-toolbar-group">
    <span style="font-size:12.5px;font-weight:800;color:#0b3c5d;">🎯 請為以下 5 個 Java 測試情境，點選最精確的 Test Double 類型：</span>
  </div>
  <div class="shrink-toolbar-group">
    <button type="button" class="shrink-btn is-primary" id="td-check-btn">✅ 送出核對</button>
    <button type="button" class="shrink-btn" id="td-explain-btn">📖 顯示詳解</button>
    <button type="button" class="shrink-btn" id="td-reset-btn">↺ 重填</button>
  </div>
</div>

<div class="td-quiz-list">
  <div class="td-quiz-row" data-ans="Dummy">
    <div class="td-q-text"><strong>Q1.</strong> 建構子 <code>new OrderService(repo, logger)</code> 必填 <code>logger</code>，但此測試完全不印日誌，只傳空物件佔位。
      <div class="td-q-explain">💡 <strong>Dummy</strong>：僅為了通過編譯填塞參數列表，過程中從未被呼叫。</div>
    </div>
    <div class="td-opts"><button type="button" class="td-opt-btn">Dummy</button><button type="button" class="td-opt-btn">Stub</button><button type="button" class="td-opt-btn">Spy</button><button type="button" class="td-opt-btn">Mock</button><button type="button" class="td-opt-btn">Fake</button></div>
  </div>
  <div class="td-quiz-row" data-ans="Stub">
    <div class="td-q-text"><strong>Q2.</strong> 測試 <code>MarketTest</code> 時寫 <code>when(stockService.getPrice(tsmc)).thenReturn(1035.0)</code> 固定回傳台積電股價。
      <div class="td-q-explain">💡 <strong>Stub</strong>：專責提供固定預設回傳值（間接輸入），不驗證呼叫次數。</div>
    </div>
    <div class="td-opts"><button type="button" class="td-opt-btn">Dummy</button><button type="button" class="td-opt-btn">Stub</button><button type="button" class="td-opt-btn">Spy</button><button type="button" class="td-opt-btn">Mock</button><button type="button" class="td-opt-btn">Fake</button></div>
  </div>
  <div class="td-quiz-row" data-ans="Spy">
    <div class="td-q-text"><strong>Q3.</strong> 包裹真實的 <code>new MockPrimeChecker()</code>，只對漏寫的 <code>isPrime(7)</code> 局部打樁 <code>doReturn(true)</code>。
      <div class="td-q-explain">💡 <strong>Spy</strong>：包裹真實物件執行原程式碼，僅局部覆寫特定方法並記錄呼叫。</div>
    </div>
    <div class="td-opts"><button type="button" class="td-opt-btn">Dummy</button><button type="button" class="td-opt-btn">Stub</button><button type="button" class="td-opt-btn">Spy</button><button type="button" class="td-opt-btn">Mock</button><button type="button" class="td-opt-btn">Fake</button></div>
  </div>
  <div class="td-quiz-row" data-ans="Mock">
    <div class="td-q-text"><strong>Q4.</strong> 測試結帳流程時撰寫 <code>verify(paymentGateway, times(1)).charge(500)</code> 嚴格檢驗扣款恰好呼叫 1 次。
      <div class="td-q-explain">💡 <strong>Mock</strong>：核心為「行為驗證 (Behavior Verification)」，檢驗互動次數與參數。</div>
    </div>
    <div class="td-opts"><button type="button" class="td-opt-btn">Dummy</button><button type="button" class="td-opt-btn">Stub</button><button type="button" class="td-opt-btn">Spy</button><button type="button" class="td-opt-btn">Mock</button><button type="button" class="td-opt-btn">Fake</button></div>
  </div>
  <div class="td-quiz-row" data-ans="Fake">
    <div class="td-q-text"><strong>Q5.</strong> 用 <code>HashMap&lt;String, User&gt;</code> 實作輕量級 <code>InMemoryUserRepo</code>，具備真實 <code>save()</code> 與 <code>findByEmail()</code> 狀態。
      <div class="td-q-explain">💡 <strong>Fake</strong>：擁有真實可運作但簡化的邏輯實作，適合快速測試但不可上正式環境。</div>
    </div>
    <div class="td-opts"><button type="button" class="td-opt-btn">Dummy</button><button type="button" class="td-opt-btn">Stub</button><button type="button" class="td-opt-btn">Spy</button><button type="button" class="td-opt-btn">Mock</button><button type="button" class="td-opt-btn">Fake</button></div>
  </div>
</div>
<div class="shrink-banner" id="td-feedback">👆 請依序點選 5 題的替身類型，再按「✅ 送出核對」！</div>
</div>

---

<!-- header: '7.5 隔離架構與測試替身原則' -->

## 概念核對問答 (CCQ 2)

<div class="ccq-columns">
<div class="ccq-text">

<!-- id: sqa-ch07-ccq2 -->
**問題情境**：  
資深架構師在審查小明的測試程式碼時，發現小明在測試 `OrderCheckoutService` 時，將內部的 `TaxCalculator`、`DiscountRuleEngine` 與 `OrderEntity` 全部使用 Mock 嚴格設定並逐行 `verify()`，因而提醒他「避免過度 Mocking，應優先採用真實物件或 Fake 物件」。請問下列哪一項**不是**過度 Mock 帶來的缺點？

- **A)** 重構內部輔助方法或調用順序時，極易造成測試非預期失敗（脆化測試 Brittle Tests）
- **B)** 測試案例過度綁定內部實作細節，如同把生產程式碼用 Mockito 語法重抄一遍
- **C)** 容易掩蓋外部依賴真實行為契約變動，產生「單元測試全綠、上線卻崩潰」的假綠燈幻覺
- **D)** 測試案例能自動啟動真實資料庫鎖定機制，精準抓出高併發交易下的死結 (Deadlock)

</div>
<div class="ccq-logo">

<a href="https://nlhsueh.github.io/nickedupocket/#/student/sqa-ch07-ccq2" target="_blank"><img src="../../img/ch07/sqa-ch07-ccq2.png" alt="QR Code" /></a>

</div>
</div>

---

<!-- _class: lead -->
<!-- header: '7.6 Mockito 實戰與行為驗證' -->

# **7.6 Lab: Mockito 測試驅動與模擬 (`u07_mockito`)**

> 「打開 `LabDemo/src/test/java/u07_mockito`，直接點擊綠色三角形 ▶️：  
> 體驗從手寫 `MockPrimeChecker` 進化至動態 `mock()`、`@InjectMocks`、`spy()` 與 `verify()`！」

---

<!-- header: '7.6 Mockito 實戰與行為驗證' -->

## Mockito 核心實戰 (1)：動態 `mock()` 與 `@Mock / @InjectMocks` 註解

<div class="card-deck">

> 💡 [PrimeTest.java](../../lab.html?file=LabDemo/src/test/java/u07_mockito/prime/PrimeTest.java) 與 [PrimePlusTest.java](../../lab.html?file=LabDemo/src/test/java/u07_mockito/prime/PrimePlusTest.java)：無須再手寫 `MockPrimeChecker.java` 類別，一行 `mock(PrimeChecker.class)` 搞定！

<div class="two-columns">
<div class="card">

### 💻 寫法 A：建構子注入
```java
public class PrimeTest {
    @Test
    public void testAllPrime() {
        // 1. 動態建立 PrimeChecker 介面的 Mock 替身
        PrimeChecker mockChecker = mock(PrimeChecker.class);

        // 2. 佈樁 (Stubbing)：指定 2~5 的回傳值
        when(mockChecker.isPrime(2)).thenReturn(true);
        when(mockChecker.isPrime(3)).thenReturn(true);
        when(mockChecker.isPrime(4)).thenReturn(false);
        when(mockChecker.isPrime(5)).thenReturn(true);

        // 3. 透過建構子注入替身並驗證結果
        Prime prime = new Prime(mockChecker);
        assertArrayEquals(new int[]{2, 3, 5}, prime.allPrime(5));
    }

    @Test // 模擬當輸入超過 100 時拋出防禦性例外 (thenThrow)
    public void testMockException() {
        PrimeChecker mockChecker = mock(PrimeChecker.class);
        when(mockChecker.isPrime(101)).thenThrow(
            new IllegalArgumentException("Should <= 100"));
        Prime prime = new Prime(mockChecker);
        assertThrows(IllegalArgumentException.class,
            () -> prime.allPrime(101));
    }
}
```

</div>
<div class="card">

### ✨ 寫法 B：註解自動注入 (`PrimePlusTest.java`)
```java
// 啟用 JUnit 5 Mockito 擴充引擎，自動初始化註解欄位
@ExtendWith(MockitoExtension.class)
public class PrimePlusTest {

    @Mock // 1. 自動建立 PrimeChecker 的模擬替身
    PrimeChecker mockChecker;

    @InjectMocks // 2. 自動呼叫 new Prime(mockChecker) 完成注入！
    Prime prime;

    @Test
    public void testAllPrime() {
        when(mockChecker.isPrime(2)).thenReturn(true);
        when(mockChecker.isPrime(3)).thenReturn(true);
        when(mockChecker.isPrime(4)).thenReturn(false);
        when(mockChecker.isPrime(5)).thenReturn(true);

        assertArrayEquals(new int[]{2, 3, 5}, prime.allPrime(5));

        // 3. 行為驗證：確認 2, 3, 4, 5 各被呼叫恰好 1 次！
        verify(mockChecker, times(1)).isPrime(2);
        verify(mockChecker, times(1)).isPrime(3);
        verify(mockChecker, times(1)).isPrime(4);
        verify(mockChecker, times(1)).isPrime(5);
    }
}
```

</div>
</div>
</div>

---

<!-- header: '7.6 Mockito 實戰與行為驗證' -->

## Mockito 核心實戰 (2)：`mock()` vs. `spy()` 差異

<div class="card-deck">

> 💡 [PrimeSpyTest.java](../../lab.html?file=LabDemo/src/test/java/u07_mockito/prime/PrimeSpyTest.java)：未設定 `when`，在 `mock()` 一律回傳預設值 (`0/false/null`)；在 `spy()` 則會呼叫真實物件程式碼！

<div class="two-columns">
<div class="card">

##### 🎭 `mock(App.class)` vs. `spy(App.class)`
- **1. `mock()`（全虛擬空殼）**：
  ```java
  App a = mock(App.class);
  when(a.add(1, 1)).thenReturn(2);
  assertEquals(2, a.add(1, 1)); // ✅ 通過 (有打樁)
  assertEquals(4, a.add(2, 2)); // ❌ 失敗! 未打樁預設回傳 0
  ```
- **2. `spy()`（包裹真實物件，僅局部覆寫 Partial Mock）**：
  ```java
  App a = spy(new App());
  when(a.add(1, 1)).thenReturn(2);
  assertEquals(2, a.add(1, 1)); // ✅ 通過 (走打樁值)
  assertEquals(4, a.add(2, 2)); // ✅ 通過! 執行真實 add(2,2) 回傳 4
  ```

</div>
<div class="card">

##### 🕵️ 用 `spy()` 局部修補不完整的 `MockPrimeChecker`

還記得手寫的 `MockPrimeChecker` 只寫到 `5`、忘了寫 `7` 嗎？看 [PrimeSpyTest.java](../../lab.html?file=LabDemo/src/test/java/u07_mockito/prime/PrimeSpyTest.java) 如何用 **`spy()`** 局部打補丁：
```java
public class PrimeSpyTest {
    @Test
    public void testWithSpy() {
        // 1. 以半成品的真實物件 MockPrimeChecker 建立 Spy 間諜
        PrimeChecker checker = new MockPrimeChecker();
        PrimeChecker spyChecker = spy(checker);

        // 2. 僅針對漏寫的 7 進行局部打樁 (2, 3, 5 仍走原物件程式碼!)
        doReturn(true).when(spyChecker).isPrime(7);

        // 3. 注入 spyChecker 並測試 1~10 的質數
        Prime prime = new Prime(spyChecker);
        int[] result = prime.allPrime(10);

        // 2, 3, 5 來自原物件，7 來自 Spy 補丁 ➔ 完美湊齊 {2, 3, 5, 7}！
        assertArrayEquals(new int[]{2, 3, 5, 7}, result);
    }
}
```

</div>
</div>
</div>

---

<!-- header: '7.6 Mockito 實戰與行為驗證' -->

## Mockito 核心實戰 (3)：`verify()` 次數驗證與 `PrimeTest`

<div class="card-deck">

> [PrimeTest.java](../../lab.html?file=LabDemo/src/test/java/u07_mockito/prime/PrimeTest.java#L21) 執行 `testAllPrimeWithMockedIsPrime()`，為什麼 verify(mockChecker, times(1)).isPrime(1) 會亮紅燈失敗？

<div class="two-columns">
<div class="card">

##### 🔍 `verify()` 如何抓出呼叫契約落差？
- **看看 `PrimeTest.java` 第 37~41 行寫了什麼**：
  ```java
  int[] result = prime.allPrime(10);
  assertArrayEquals(new int[]{2, 3, 5, 7}, result); // ✅ 狀態斷言通過！

  // 💥 但是下面這行行為驗證卻亮紅燈：Wanted but not invoked!
  verify(mockChecker, times(1)).isPrime(1); // !! 為什麼失敗？
  ```
- **原因剖析**：
  - 打開 `Prime.allPrime(n)` 原始碼：`for (int i = 2; i <= n; i++)` —— 迴圈直接從 **`i = 2`** 開始，**根本沒有呼叫過 `mockChecker.isPrime(1)`**！
  - 此外，`allPrime(10)` 會呼叫 `isPrime(2) ~ isPrime(10)`，因為 `6, 8, 9, 10` 沒打樁而預設回傳 `false`，所以狀態斷言 `{2, 3, 5, 7}` 剛好通過，但 **`verify()` 卻能精準監督內部互動次數**！

</div>
<div class="card">

##### 📋 `verify()` 常用次數檢驗語法大全
```java
// 1. 預設驗證恰好呼叫 1 次 (等效於 times(1))
verify(mockedList).add("1");
verify(mockedList, times(1)).add("1");

// 2. 驗證特定呼叫次數
verify(mockedList, times(2)).add("2");
verify(mockedList, times(3)).add("3");

// 3. 驗證從未被呼叫過 (等效於 times(0))
verify(mockedList, never()).add("4");

// 4. 驗證至少 / 至多呼叫次數
verify(mockedList, atLeastOnce()).add("3");
verify(mockedList, atLeast(2)).add("3");
verify(mockedList, atMost(5)).add("3");
```

</div>
</div>
</div>

---

<!-- _class: lead -->
<!-- header: '7.7 Testcontainers 容器化資料庫實戰' -->

# **7.7 Testcontainers 容器化資料庫實戰 (`u07_testcontainers`)**

> 「Mock 與 H2 記憶體資料庫常製造『本機全綠、上線爆炸』的假綠燈幻覺——  
> 用純 Java JDBC + Docker **Testcontainers**，在 JUnit 5 中一鍵拉起 100% 真實 PostgreSQL！」

---

<!-- header: '7.7 Testcontainers 容器化資料庫實戰' -->

## 為什麼要淘汰 H2 記憶體資料庫？Testcontainers 架構原理

<div class="card-deck">

> 💡 **環境一致性 (Environment Parity)**：整合測試若連的是簡化版 H2 記憶體庫，永遠無法保證真實 PostgreSQL / MySQL 上線時不會炸裂！

<div class="content-columns">
<div class="content-text">

- **💣 H2 記憶體資料庫的三大「假綠燈幻覺」**：
  1. **SQL 方言與原生型別失配**：PostgreSQL 的 `JSONB`、`RETURNING id`、`ON CONFLICT DO UPDATE` 在 H2 中不支援或行為不同。
  2. **約束與錯誤碼落差**：真實 PostgreSQL 唯一鍵衝突回傳 `SQLState = 23505`，H2 與 MySQL 錯誤細節各異。
  3. **併發鎖定與交易隔離**：記憶體單線程假資料庫無法重現真實死結 (`Deadlock`) 與行級鎖 (`FOR UPDATE`)。
- **🐳 Testcontainers 三大核心優勢（免裝任何框架！）**：
  1. **純 Java + JUnit 5 直接驅動**：不需 Spring Boot，只要建構子注入 `postgres.getJdbcUrl()` 即可。
  2. **動態隨機 Port 防衝突**：自動映射主機隨機埠，CI/CD 平行跑測試零碰撞。
  3. **Ryuk 守護容器自動銷毀**：測完自動清除容器與資料，不留任何髒環境！

</div>
<div class="content-figure">

![Testcontainers Architecture](../../img/ch07/testcontainers_architecture_flow.jpg)

</div>
</div>
</div>

---

<!-- header: '7.7 Testcontainers 容器化資料庫實戰' -->

## 純 Java JDBC + Testcontainers 實戰 (`u07_testcontainers`)

<div class="card-deck">

> 💡 對應 [UserRepository.java](../../lab.html?file=LabDemo/src/main/java/u07_testcontainers/UserRepository.java) 與 [UserRepositoryTestcontainersTest.java](../../lab.html?file=LabDemo/src/test/java/u07_testcontainers/UserRepositoryTestcontainersTest.java)（零 Spring Boot，直接 `mvn test -Dtest=UserRepositoryTestcontainersTest`！）

<div class="two-columns">
<div class="card">

##### 1️⃣ 待測程式：`UserRepository.java` (Constructor DI)
```java
public class UserRepository {
    private final String jdbcUrl, username, password;
    // ✅ 透過建構子注入容器動態連線資訊（免 Spring）
    public UserRepository(String url, String user, String pass) {
        this.jdbcUrl = url; this.username = user; this.password = pass;
    }
    // 使用 PostgreSQL 原生 JSONB 與 RETURNING id
    public long save(String name, String email, String json)
            throws SQLException {
        String sql = "INSERT INTO users (name, email, metadata) "
                   + "VALUES (?, ?, CAST(? AS jsonb)) RETURNING id";
        ...
    }
    // PostgreSQL 原生 Upsert (ON CONFLICT DO UPDATE)
    public void upsertNameByEmail(...) throws SQLException { ... }
}
```

</div>
<div class="card">

##### 2️⃣ 容器化測試：`@Testcontainers` + `PostgreSQLContainer`
```java
@Testcontainers(disabledWithoutDocker = true)
public class UserRepositoryTestcontainersTest {
    @Container
    static PostgreSQLContainer<?> postgres =
        new PostgreSQLContainer<>("postgres:16-alpine")
            .withDatabaseName("sqa_test_db");

    @BeforeAll static void setUp() throws SQLException {
        repo = new UserRepository(postgres.getJdbcUrl(),
            postgres.getUsername(), postgres.getPassword());
        repo.initSchema();
    }

    @Test void testUniqueEmailConstraintViolation() throws Exception {
        repo.save("Bob", "bob@fcu.edu.tw", "{}");
        SQLException ex = assertThrows(SQLException.class,
            () -> repo.save("Bob2", "bob@fcu.edu.tw", "{}"));
        assertEquals("23505", ex.getSQLState()); // 真實 PG 錯誤碼！
    }
}
```

</div>
</div>
</div>

---

<!-- header: '7.7 Testcontainers 容器化資料庫實戰' -->

## 互動視覺化實驗室：H2 假綠燈對照 ＆ Testcontainers 5 步生命週期

<div class="tc-interactive-stage" id="tc-flow-lab">
<div class="shrink-toolbar">
  <div class="shrink-toolbar-group">
    <button type="button" class="shrink-btn is-active" data-tc-tab="lifecycle">🐳 1. Testcontainers 5 步生命週期追蹤</button>
    <button type="button" class="shrink-btn" data-tc-tab="h2trap">💣 2. H2 假綠燈 vs. 真實 PostgreSQL 陷阱對照</button>
  </div>
  <div class="shrink-toolbar-group">
    <button type="button" class="shrink-btn is-primary" id="tc-next-btn">⏭️ 下一步 / 下一陷阱</button>
    <button type="button" class="shrink-btn" id="tc-reset-btn">↺ 重設</button>
  </div>
</div>

<div id="tc-view-lifecycle" class="shrink-panel">
  <div class="tc-steps-bar">
    <div class="tc-step-chip is-active" data-tc-step="0">① @Testcontainers<br/>偵測 Docker</div>
    <div class="tc-step-chip" data-tc-step="1">② 拉起容器<br/>隨機 Port 綁定</div>
    <div class="tc-step-chip" data-tc-step="2">③ Constructor DI<br/>注入 JDBC URL</div>
    <div class="tc-step-chip" data-tc-step="3">④ 真實 SQL 測試<br/>JSONB / 23505</div>
    <div class="tc-step-chip" data-tc-step="4">⑤ Ryuk 守護容器<br/>自動銷毀零殘留</div>
  </div>
  <div class="tc-compare-grid" style="margin-top:4px;">
    <div class="shrink-code-box" id="tc-console-log">[Step 1/5] JUnit 5 啟動 @Testcontainers(disabledWithoutDocker = true)
> 偵測本機 Docker Daemon (OrbStack / Docker Desktop)...
> ✅ Docker API v1.45 連線成功！準備啟動測試容器。</div>
    <div class="alt-mnemonic-box" id="tc-step-explain" style="font-size:13px;line-height:1.52;">
      <strong>🔍 為什麼加上 <code>disabledWithoutDocker = true</code>？</strong><br/>
      若同學或 CI 機器尚未啟動 Docker，JUnit 5 會自動「略過 (Skipped)」而非整個建置失敗，兼顧日常離線開發體驗與真實整合品質！
    </div>
  </div>
  <div class="shrink-banner" id="tc-life-banner">👆 點擊上方任一步驟卡片或「⏭️ 下一步」，追蹤容器從誕生到自動銷毀的完整流程！</div>
</div>

<div id="tc-view-h2trap" class="shrink-panel" style="display:none;">
  <div class="shrink-toolbar-group" style="justify-content:center;">
    <button type="button" class="shrink-btn is-active" data-tc-trap="0">陷阱 1：JSONB ＆ RETURNING id</button>
    <button type="button" class="shrink-btn" data-tc-trap="1">陷阱 2：ON CONFLICT DO UPDATE</button>
    <button type="button" class="shrink-btn" data-tc-trap="2">陷阱 3：UNIQUE 鎖定與錯誤碼 23505</button>
  </div>
  <div class="tc-compare-grid">
    <div class="tc-card-bad">
      <div style="font-size:13px;font-weight:800;color:#b91c1c;margin-bottom:5px;" id="tc-h2-title">❌ 傳統 H2 記憶體庫：假象相容 / 語法落差</div>
      <div style="font-size:12.5px;color:#7f1d1d;line-height:1.48;" id="tc-h2-desc">為了讓測試在 H2 跑過，工程師被迫把 <code>JSONB</code> 改成 <code>VARCHAR</code>、拿掉 <code>RETURNING id</code>，結果測試碼與正式生產 SQL 完全脫節！</div>
    </div>
    <div class="tc-card-good">
      <div style="font-size:13px;font-weight:800;color:#15803d;margin-bottom:5px;" id="tc-pg-title">✅ Testcontainers (postgres:16-alpine)：100% 真實執行</div>
      <div style="font-size:12.5px;color:#14532d;line-height:1.48;" id="tc-pg-desc">直接執行真實 <code>CAST(? AS jsonb) RETURNING id</code> 與 <code>metadata-&gt;&gt;'role'</code> 查詢；本機過了，上線 PostgreSQL 16 就 100% 能跑！</div>
    </div>
  </div>
  <div class="shrink-banner is-done" id="tc-trap-banner">🎯 黃金原則：邏輯演算法用純單元測試/Mockito，牽涉真實 SQL 方言與交易約束一律上 Testcontainers！</div>
</div>
</div>

---

<!-- header: '7.8 課堂實習與綜合練習' -->

## 🧪 7.8 課堂實習指引 (`u07_mockito` + `u07_testcontainers`) 與必考快篩

<div class="card-deck">

> 💡 請打開 `LabDemo` 專案，搭配手冊 [mokito.md](../../lab.html?file=LabDemo/docs/u08_integration/mokito.md) 與 [testcontainers.md](../../lab.html?file=LabDemo/docs/u08_integration/testcontainers.md) 動手演練！

<div class="two-columns">
<div class="card">

### 💻 課堂動手實習四部曲 (`LabDemo`)
1. **實驗 1：質數系統四種測法 (`u07_mockito/prime/`)**
   - 修正 [PrimeTest.java](../../lab.html?file=LabDemo/src/test/java/u07_mockito/prime/PrimeTest.java) 第 41 行的 `verify(mockChecker).isPrime(1)`，並比較手寫 Stub、`mock()`、`spy()` 與 `RealPrimeChecker`。
2. **實驗 2：計算機契約失配排查 (`u07_mockito/calculator/`)**
   - 實作 `new Calculator(new RealCalculatorService()).divide(6, 0)` 整合測試，修復 [Calculator.java](../../lab.html?file=LabDemo/src/main/java/u07_mockito/calculator/Calculator.java) 除以零防呆。
3. **實驗 3：股票市值外部依賴隔離 (`u07_mockito/stock/`)**
   - 在 [MarketTest.java](../../lab.html?file=LabDemo/src/test/java/u07_mockito/stock/MarketTest.java) 新增第 3 檔股票練習 `when().thenReturn()`。
4. **實驗 4：Testcontainers 真實資料庫 (`u07_testcontainers/`)**
   - 啟動 Docker 執行 [UserRepositoryTestcontainersTest.java](../../lab.html?file=LabDemo/src/test/java/u07_testcontainers/UserRepositoryTestcontainersTest.java)，並完成 [UserRepositoryExerciseTest.java](../../lab.html?file=LabDemo/src/test/java/u07_testcontainers/UserRepositoryExerciseTest.java) 交易回滾練習！

</div>
<div class="card">

### 🎯 必考觀念題快篩與解析
- **Q1：關於整合測試，下列何者正確？（複選題）**
  - ❌ (A) 整合測試測試所有模組，又稱為系統測試 *(錯，層級不同)*
  - ❌ (B) 若一開始律定好介面規格，就可省略整合測試 *(錯，實作仍會發生契約誤解)*
  - ✅ **(C) 由下而上的整合測試，需要設計 Test Driver** *(正確！)*
  - ✅ **(D) 一般而言，Stub 的設計比 Driver 較為困難** *(正確！)*
- **Q2：關於 Mockito 與 Testcontainers，下列何者正確？（複選題）**
  - ✅ **(A) Mockito 利用 `when(...).thenReturn(...)` 設定假回傳資料** *(正確！)*
  - ❌ (B) `mock(A.class)` 的 `A` 不可為 interface *(錯，最常 mock interface)*
  - ✅ **(C) Testcontainers 透過 Docker 啟動真實資料庫，消除 H2 方言落差** *(正確！)*

</div>
</div>
</div>

---

<!-- header: '附錄：課堂互動參考解答' -->

## 附錄：課堂互動參考解答

<div class="card-deck">

> 💡 本章課堂互動 (CCQ 1 ～ CCQ 2) 官方標準解答與核心觀念解析總整理。

<div class="two-columns">
<div class="card">

### 🧭 CCQ 1：由上而下整合與 Test Stubs
- **CCQ 1【採用由上而下整合，先寫 Stubs 模擬感測器 (C)】**：
  - **解析**：當底層硬體尚未穩定、昂貴或容易過熱毀損時，採用「**由上而下 (Top-Down)**」策略，為底層硬體撰寫模擬樁 (**Test Stubs**) 回傳測試訊號餵給高層決策演算法，能在保護脆弱硬體的前提下，提早驗證核心控制與路徑規劃邏輯！
  - 大霹靂整合 (A) 無法定位錯誤；由下而上 (B) 會直接損毀硬體；完全不測整合 (D) 則無法抓出介面協定與時序問題。

</div>
<div class="card">

### 🎯 CCQ 2：過度 Mocking 與脆化測試 (Brittle Tests)
- **CCQ 2【能精準抓出高併發死結不是過度 Mock 的特性 (D)】**：
  - **解析**：Mock 只是純記憶體中的虛擬空殼物件，沒有真實資料庫鎖定或交易隔離機制，**完全不可能測出高併發 Deadlock**（這正是過度依賴 Mock 的盲區，必須靠真實模組與真實環境整合測試才能檢驗）。
  - 選項 A（重構易斷裂之**脆化測試 Brittle Tests**）、選項 B（把生產碼重抄一遍）、選項 C（掩蓋外部依賴契約變更造成**假綠燈**）皆為過度 Mocking 的典型致命缺點！

</div>
</div>
</div>

<script>
(function() {
  function initHeaderDropdown() {
    var sections = [];
    var seenTitles = new Set();
    var slideSections = document.querySelectorAll("section[id]");
    
    // 1. Scan unique section titles and their slide IDs
    slideSections.forEach(function(sec) {
      var header = sec.querySelector("header");
      if (!header) return;
      
      var title = header.textContent.trim();
      title = title.replace(/^[◄◀]\s*/, "").replace(/\s*[►▶]$/, "").trim();
      if (!title || seenTitles.has(title)) return;
      
      seenTitles.add(title);
      sections.push({
        id: sec.id,
        title: title
      });
    });

    if (sections.length === 0) return;

    // Helper to create the dropdown DOM
    function createDropdownWrapper(currentTitle) {
      var wrapper = document.createElement("span");
      wrapper.className = "header-nav-wrapper";
      
      var titleSpan = document.createElement("span");
      titleSpan.className = "header-nav-title";
      titleSpan.title = "點擊固定或懸停查看所有章節快速跳轉";
      
      var textNode = document.createTextNode(currentTitle);
      var caretSpan = document.createElement("span");
      caretSpan.className = "nav-caret";
      caretSpan.textContent = " ▾";
      titleSpan.appendChild(textNode);
      titleSpan.appendChild(caretSpan);
      
      titleSpan.addEventListener("click", function(e) {
        e.stopPropagation();
        var wasOpen = wrapper.classList.contains("is-open");
        document.querySelectorAll(".header-nav-wrapper.is-open").forEach(function(w) {
          w.classList.remove("is-open");
        });
        if (!wasOpen) {
          wrapper.classList.add("is-open");
        }
      });
      
      var dropdown = document.createElement("div");
      dropdown.className = "nav-dropdown";
      
      dropdown.addEventListener("click", function(e) {
        e.stopPropagation();
      });
      
      var dropHeader = document.createElement("div");
      dropHeader.className = "nav-dropdown-header";
      var titlePart = document.createElement("span");
      titlePart.textContent = "📑 快速跳轉章節目錄";
      var countPart = document.createElement("span");
      countPart.style.fontSize = "11px";
      countPart.style.fontWeight = "normal";
      countPart.style.color = "#64748b";
      countPart.textContent = "共 " + sections.length + " 個章節";
      dropHeader.appendChild(titlePart);
      dropHeader.appendChild(countPart);
      dropdown.appendChild(dropHeader);
      
      var grid = document.createElement("div");
      grid.className = "nav-dropdown-grid";
      
      sections.forEach(function(s) {
        var item = document.createElement("a");
        var isActive = (s.title === currentTitle);
        item.className = "nav-dropdown-item" + (isActive ? " active" : "");
        item.href = "#" + s.id;
        
        var badge = document.createElement("span");
        badge.className = "badge";
        badge.textContent = "#" + s.id.padStart(2, "0");
        
        var itemText = document.createElement("span");
        itemText.className = "item-text";
        itemText.title = s.title;
        itemText.textContent = s.title;
        
        item.appendChild(badge);
        item.appendChild(itemText);
        
        item.addEventListener("click", function(e) {
          wrapper.classList.remove("is-open");
          dropdown.style.display = "none";
          window.location.hash = "#" + s.id;
          setTimeout(function() { dropdown.style.display = ""; }, 350);
        });
        
        grid.appendChild(item);
      });
      
      dropdown.appendChild(grid);
      wrapper.appendChild(titleSpan);
      wrapper.appendChild(dropdown);
      return wrapper;
    }

    // Close any pinned dropdown when clicking anywhere outside
    document.addEventListener("click", function(e) {
      if (!e.target.closest(".header-nav-wrapper")) {
        document.querySelectorAll(".header-nav-wrapper.is-open").forEach(function(w) {
          w.classList.remove("is-open");
        });
      }
    });

    // 2. Enhance each header element across all slides
    slideSections.forEach(function(sec) {
      var header = sec.querySelector("header");
      if (!header || header.dataset.navEnhanced) return;
      header.dataset.navEnhanced = "true";
      
      var title = header.textContent.trim();
      title = title.replace(/^[◄◀]\s*/, "").replace(/\s*[►▶]$/, "").trim();
      if (!title) return;
      
      header.innerHTML = "";
      var wrapper = createDropdownWrapper(title);
      header.appendChild(wrapper);
    });

    // 3. Auto-link and calibrate section items on the Outline slide (Slide 2)
    var secByNum = {};
    sections.forEach(function(s) {
      var m = s.title.match(/^(\d+\.\d+)\b/);
      if (m && !secByNum[m[1]]) {
        secByNum[m[1]] = s.id;
      }
    });
    var outlineSlide = document.querySelector("section.outline-slide, section[id=\"2\"]");
    if (outlineSlide) {
      outlineSlide.querySelectorAll("li").forEach(function(li) {
        var existingLink = li.querySelector(":scope > a, :scope > strong > a");
        if (existingLink) {
          var m = existingLink.textContent.trim().match(/^(\d+\.\d+)\b/);
          if (m && secByNum[m[1]]) {
            existingLink.href = "#" + secByNum[m[1]];
          }
          return;
        }
        var strong = li.querySelector(":scope > strong, :scope > b");
        if (strong) {
          var m = strong.textContent.trim().match(/^(\d+\.\d+)\b/);
          if (m && secByNum[m[1]]) {
            var a = document.createElement("a");
            a.href = "#" + secByNum[m[1]];
            strong.parentNode.insertBefore(a, strong);
            a.appendChild(strong);
          }
        }
      });
    }

    // 4. Auto-clamp hover zoom scale (--zoom-scale) so enlarged images never exceed slide (1280x720)
    function updateImgZoomScale(img) {
      var sec = img.closest("section");
      if (!sec) return;
      var w = img.offsetWidth;
      var h = img.offsetHeight;
      if (!w || !h) return;
      var x = 0, y = 0, cur = img;
      while (cur && cur !== sec && sec.contains(cur)) {
        x += cur.offsetLeft;
        y += cur.offsetTop;
        cur = cur.offsetParent;
      }
      var secW = sec.offsetWidth || 1280;
      var secH = sec.offsetHeight || 720;
      var padSide = 36;
      var padTop = 30;
      var isLeftOrigin = img.closest(":is(.two-columns, .two-columns-64, .two-columns-73, .three-columns) > .card:first-child");
      var availW = isLeftOrigin ? (secW - padSide - x) : ((x + w) - padSide);
      var availH = (y + h) - padTop;
      var tag = img.tagName ? img.tagName.toLowerCase() : "";
      var cap = (tag === "pre" || tag === "marp-pre") ? 1.42 : 2.0;
      var maxS = Math.min(cap, availW / w, availH / h, (secH - 60) / h);
      if (maxS < 1.0) maxS = 1.0;
      img.style.setProperty("--zoom-scale", maxS.toFixed(3));
    }
    document.querySelectorAll(".card img:not(.emoji), div.content-figure img:not(.emoji), .card pre, .card marp-pre").forEach(function(img) {
      if (img.dataset.zoomBound) return;
      img.dataset.zoomBound = "true";
      img.addEventListener("mouseenter", function() { updateImgZoomScale(img); });
      img.addEventListener("load", function() { updateImgZoomScale(img); });
      updateImgZoomScale(img);
    });

    // 5. Interactive Integration Strategy Simulator (Section 7.4)
    var intLab = document.getElementById("int-strat-lab");
    if (intLab && !intLab.dataset.bound) {
      intLab.dataset.bound = "1";
      var intModeBtns = Array.from(intLab.querySelectorAll("[data-int-mode]"));
      var intNextBtn = document.getElementById("int-next-btn");
      var intResetBtn = document.getElementById("int-reset-btn");
      var intStepBadge = document.getElementById("int-step-badge");
      var intModeTitle = document.getElementById("int-mode-title");
      var intProtoTag = document.getElementById("int-proto-tag");
      var intDrv = document.getElementById("int-kpi-drv");
      var intStb = document.getElementById("int-kpi-stb");
      var intReal = document.getElementById("int-kpi-real");
      var intDesc = document.getElementById("int-step-desc");
      var intBanner = document.getElementById("int-step-banner");
      var nodeIds = ["A", "B", "C", "D", "E", "F", "G"];

      var INT_DATA = {
        bu: {
          title: "🧱 由下而上 (Bottom-Up)", proto: "原型可見度：晚",
          steps: [
            { drv: 2, stb: 0, real: 3, states: { A:"pending", B:"driver", C:"pending", D:"driver", E:"real", F:"real", G:"real" },
              roles: { A:"待整合", B:"Driver b", C:"待整合", D:"Driver d", E:"真實模組 ✅", F:"真實模組 ✅", G:"真實模組 ✅" },
              desc: "<strong>步驟 1：先測最底層葉節點 (E, F, G)</strong><br/>撰寫 JUnit Test Drivers 取代 B、D，直接驗證最底層演算法與 I/O。零 Stubs、底層錯誤立刻暴露！",
              banner: "💡 地基先固：E、F、G 驗證通過後，點擊「⏭️ 推進下一步」向上組裝中層！" },
            { drv: 1, stb: 0, real: 6, states: { A:"driver", B:"real", C:"real", D:"real", E:"real", F:"real", G:"real" },
              roles: { A:"Driver a", B:"真實 B ✅", C:"真實 C ✅", D:"真實 D ✅", E:"真實 E ✅", F:"真實 F ✅", G:"真實 G ✅" },
              desc: "<strong>步驟 2：換上真實中層 (B, C, D)</strong><br/>用真實 B、C、D 取代舊 Driver，改以頂層 Driver a 驅動測試 B-E-F 與 D-G 之真實介面銜接！",
              banner: "🔎 中層整合完成（6/7 真實模組），只剩最頂層 PrimeApp 尚未合龍！" },
            { drv: 0, stb: 0, real: 7, states: { A:"real", B:"real", C:"real", D:"real", E:"real", F:"real", G:"real" },
              roles: { A:"真實 A ✅", B:"真實 B ✅", C:"真實 C ✅", D:"真實 D ✅", E:"真實 E ✅", F:"真實 F ✅", G:"真實 G ✅" },
              desc: "<strong>步驟 3：頂層 A 合龍完成！</strong><br/>全部 7 個模組真實組裝完畢。缺點是直到最後一步才看見完整使用者介面。",
              banner: "🎉 由下而上整合完成！共 7/7 模組驗證通過，零 Stub 維護負擔。" }
          ]
        },
        td: {
          title: "🏛️ 由上而下 (Top-Down)", proto: "原型可見度：極早",
          steps: [
            { drv: 0, stb: 3, real: 1, states: { A:"real", B:"stub", C:"stub", D:"stub", E:"pending", F:"pending", G:"pending" },
              roles: { A:"真實 A ✅", B:"Stub b", C:"Stub c", D:"Stub d", E:"待整合", F:"待整合", G:"待整合" },
              desc: "<strong>步驟 1：先測最頂層主控 A (PrimeApp)</strong><br/>撰寫 3 個 Stubs (b, c, d) 回傳固定假資料，第一天就能向使用者展示系統骨架與主流程！",
              banner: "💡 骨架先行：A 已驗證，點擊「⏭️ 推進下一步」將中層換成真實模組！" },
            { drv: 0, stb: 3, real: 4, states: { A:"real", B:"real", C:"real", D:"real", E:"stub", F:"stub", G:"stub" },
              roles: { A:"真實 A ✅", B:"真實 B ✅", C:"真實 C ✅", D:"真實 D ✅", E:"Stub e", F:"Stub f", G:"Stub g" },
              desc: "<strong>步驟 2：中層 B, C, D 換成真實模組</strong><br/>向下推進，改為底層 E, F, G 撰寫 Mock/Stub（例如手寫 MockPrimeChecker 或 Mockito mock()）。",
              banner: "⚠️ 注意：底層 Stub 若硬編碼不全（如只寫到 5 漏寫 7），測試容易失靈！" },
            { drv: 0, stb: 0, real: 7, states: { A:"real", B:"real", C:"real", D:"real", E:"real", F:"real", G:"real" },
              roles: { A:"真實 A ✅", B:"真實 B ✅", C:"真實 C ✅", D:"真實 D ✅", E:"真實 E ✅", F:"真實 F ✅", G:"真實 G ✅" },
              desc: "<strong>步驟 3：底層 E, F, G 全數換回真實模組</strong><br/>所有 Stub 退場，完成全系統真實整合！",
              banner: "🎉 由上而下整合完成！早期即可驗證架構，但 Stub 撰寫成本較高。" }
          ]
        },
        sw: {
          title: "🥪 三明治整合 (Sandwich)", proto: "原型可見度：早＋底層穩",
          steps: [
            { drv: 2, stb: 3, real: 4, states: { A:"real", B:"stub", C:"stub", D:"stub", E:"real", F:"real", G:"real" },
              roles: { A:"真實 A ✅", B:"Stub/Drv", C:"Stub c", D:"Stub/Drv", E:"真實 E ✅", F:"真實 F ✅", G:"真實 G ✅" },
              desc: "<strong>步驟 1：上下雙向同時開工！</strong><br/>頂層團隊用 Stub 驗證 A 的介面；底層團隊同步用 JUnit Driver 驗證 E, F, G 核心演算法與資料庫！",
              banner: "⚡ 平行加速：上下兩層同步推進，大幅縮短專案總測試時程！" },
            { drv: 0, stb: 0, real: 7, states: { A:"real", B:"real", C:"real", D:"real", E:"real", F:"real", G:"real" },
              roles: { A:"真實 A ✅", B:"真實 B ✅", C:"真實 C ✅", D:"真實 D ✅", E:"真實 E ✅", F:"真實 F ✅", G:"真實 G ✅" },
              desc: "<strong>步驟 2：於中間業務層 (B, C, D) 會師合龍！</strong><br/>上層介面與底層地基皆已驗證完畢，在核心服務層快速整合收尾。",
              banner: "🎉 三明治整合完成！現代敏捷企業團隊最常用的黃金折衷策略。" }
          ]
        },
        bb: {
          title: "💥 大霹靂整合 (Big Bang)", proto: "原型可見度：最晚",
          steps: [
            { drv: 0, stb: 0, real: 0, states: { A:"pending", B:"pending", C:"pending", D:"pending", E:"pending", F:"pending", G:"pending" },
              roles: { A:"各自開發", B:"各自開發", C:"各自開發", D:"各自開發", E:"各自開發", F:"各自開發", G:"各自開發" },
              desc: "<strong>階段 1：完全不做漸進整合</strong><br/>7 個模組各自開發、各自只跑單元測試，完全不寫 Driver 或 Stub，看似最省事……",
              banner: "⏳ 點擊「⏭️ 推進下一步」看看最後一天全部拼在一起會發生什麼事！" },
            { drv: 0, stb: 0, real: 7, states: { A:"driver", B:"driver", C:"driver", D:"driver", E:"driver", F:"driver", G:"driver" },
              roles: { A:"💥 錯誤混雜", B:"💥 難定位", C:"💥 難定位", D:"💥 難定位", E:"💥 難定位", F:"💥 難定位", G:"💥 難定位" },
              desc: "<strong>階段 2：一次全部組裝 ➔ 災難性除錯！</strong><br/>同時爆出 12 個介面錯誤、版本衝突與契約失配，完全不知道是哪一層壞掉，除錯成本指數飆升！",
              banner: "🚨 教訓：大霹靂整合只適用於極小型玩具專案，正式軟體開發嚴禁採用！" }
          ]
        }
      };

      var curMode = "bu", curStep = 0;
      function renderInt() {
        var cfg = INT_DATA[curMode];
        var st = cfg.steps[curStep];
        intModeBtns.forEach(function(b) { b.classList.toggle("is-active", b.getAttribute("data-int-mode") === curMode); });
        if (intModeTitle) intModeTitle.textContent = cfg.title;
        if (intProtoTag) intProtoTag.textContent = cfg.proto;
        if (intStepBadge) {
          intStepBadge.textContent = "步驟 " + (curStep + 1) + " / " + cfg.steps.length;
          intStepBadge.classList.toggle("is-done", curStep === cfg.steps.length - 1 && curMode !== "bb");
        }
        if (intDrv) intDrv.textContent = String(st.drv);
        if (intStb) intStb.textContent = String(st.stb);
        if (intReal) intReal.textContent = st.real + " / 7";
        if (intDesc) intDesc.innerHTML = st.desc;
        if (intBanner) {
          intBanner.textContent = st.banner;
          intBanner.classList.toggle("is-done", curStep === cfg.steps.length - 1 && curMode !== "bb");
        }
        nodeIds.forEach(function(id) {
          var g = document.getElementById("int-node-" + id);
          if (!g) return;
          g.setAttribute("class", "int-node st-" + st.states[id]);
          var t = g.querySelector(".node-role");
          if (t) t.textContent = st.roles[id];
        });
      }
      intModeBtns.forEach(function(b) {
        b.addEventListener("click", function(e) { e.stopPropagation(); curMode = b.getAttribute("data-int-mode"); curStep = 0; renderInt(); });
      });
      if (intNextBtn) intNextBtn.addEventListener("click", function(e) {
        e.stopPropagation();
        curStep = (curStep + 1) % INT_DATA[curMode].steps.length;
        renderInt();
      });
      if (intResetBtn) intResetBtn.addEventListener("click", function(e) { e.stopPropagation(); curStep = 0; renderInt(); });
      renderInt();
    }

    // 6. Interactive Test Double 5-Question Quiz (Section 7.5)
    var tdLab = document.getElementById("td-quiz-lab");
    if (tdLab && !tdLab.dataset.bound) {
      tdLab.dataset.bound = "1";
      var tdRows = Array.from(tdLab.querySelectorAll(".td-quiz-row"));
      var tdFb = document.getElementById("td-feedback");
      tdRows.forEach(function(row) {
        var btns = Array.from(row.querySelectorAll(".td-opt-btn"));
        btns.forEach(function(btn) {
          btn.addEventListener("click", function(e) {
            e.stopPropagation();
            btns.forEach(function(b) { b.classList.remove("is-selected"); });
            btn.classList.add("is-selected");
            row.dataset.pick = btn.textContent.trim();
            row.classList.remove("is-correct", "is-wrong");
          });
        });
      });
      var tdCheck = document.getElementById("td-check-btn");
      if (tdCheck) tdCheck.addEventListener("click", function(e) {
        e.stopPropagation();
        var right = 0, answered = 0;
        tdRows.forEach(function(row) {
          var pick = row.dataset.pick || "";
          if (pick) answered++;
          var ok = pick === row.getAttribute("data-ans");
          row.classList.toggle("is-correct", ok);
          row.classList.toggle("is-wrong", !ok);
          row.classList.add("show-explain");
          if (ok) right++;
        });
        if (tdFb) {
          tdFb.classList.toggle("is-done", right === tdRows.length);
          tdFb.textContent = right === tdRows.length
            ? "🎉 滿分 5 / 5！你已完全分清 Dummy、Stub、Spy、Mock、Fake 五大測試替身！"
            : ("📊 得分：" + right + " / " + tdRows.length + "（已答 " + answered + " 題），請對照各題展開之藍色解析複習！");
        }
      });
      var tdExp = document.getElementById("td-explain-btn");
      if (tdExp) tdExp.addEventListener("click", function(e) {
        e.stopPropagation();
        tdRows.forEach(function(row) { row.classList.toggle("show-explain"); });
      });
      var tdReset = document.getElementById("td-reset-btn");
      if (tdReset) tdReset.addEventListener("click", function(e) {
        e.stopPropagation();
        tdRows.forEach(function(row) {
          delete row.dataset.pick;
          row.classList.remove("is-correct", "is-wrong", "show-explain");
          row.querySelectorAll(".td-opt-btn").forEach(function(b) { b.classList.remove("is-selected"); });
        });
        if (tdFb) { tdFb.classList.remove("is-done"); tdFb.textContent = "👆 請依序點選 5 題的替身類型，再按「✅ 送出核對」！"; }
      });
    }

    // 7. Interactive Testcontainers Lifecycle & H2 Trap Lab (Section 7.7)
    var tcLab = document.getElementById("tc-flow-lab");
    if (tcLab && !tcLab.dataset.bound) {
      tcLab.dataset.bound = "1";
      var tcTabBtns = Array.from(tcLab.querySelectorAll("[data-tc-tab]"));
      var tcViewLife = document.getElementById("tc-view-lifecycle");
      var tcViewTrap = document.getElementById("tc-view-h2trap");
      var tcStepChips = Array.from(tcLab.querySelectorAll("[data-tc-step]"));
      var tcTrapBtns = Array.from(tcLab.querySelectorAll("[data-tc-trap]"));
      var tcConsole = document.getElementById("tc-console-log");
      var tcExplain = document.getElementById("tc-step-explain");
      var tcLifeBanner = document.getElementById("tc-life-banner");
      var tcH2Title = document.getElementById("tc-h2-title");
      var tcH2Desc = document.getElementById("tc-h2-desc");
      var tcPgTitle = document.getElementById("tc-pg-title");
      var tcPgDesc = document.getElementById("tc-pg-desc");
      var tcNext = document.getElementById("tc-next-btn");
      var tcReset = document.getElementById("tc-reset-btn");

      var TC_STEPS = [
        { log: "[Step 1/5] JUnit 5 啟動 @Testcontainers(disabledWithoutDocker = true)\n> 偵測本機 Docker Daemon (OrbStack / Docker Desktop)...\n> ✅ Docker API v1.45 連線成功！準備啟動測試容器。",
          exp: "<strong>🔍 為什麼加上 <code>disabledWithoutDocker = true</code>？</strong><br/>若本機尚未啟動 Docker，JUnit 5 會優雅地略過而非讓整個專案建置失敗，兼顧日常離線開發與真實整合！",
          ban: "👆 步驟 1 完成：已連上本機 Docker Daemon。" },
        { log: "[Step 2/5] Creating container for image: postgres:16-alpine\n> Pulling image postgres:16-alpine ... OK (cached)\n> Container started in 1.42s!\n> Mapped Port: container 5432 -> host localhost:55482",
          exp: "<strong>🔌 為什麼一定要映射「隨機 Port (55482)」？</strong><br/>避免與本機已安裝的 PostgreSQL (5432) 衝突，並讓多個測試或 CI Pipeline 能同時平行執行互不干擾！",
          ban: "🐳 步驟 2 完成：100% 真實的 PostgreSQL 16 容器已就緒！" },
        { log: "[Step 3/5] @BeforeAll setUpDatabase()\n> jdbcUrl = postgres.getJdbcUrl()\n  -> jdbc:postgresql://localhost:55482/sqa_test_db\n> repo = new UserRepository(jdbcUrl, user, pass);\n> repo.initSchema(); // CREATE TABLE users (... JSONB)",
          exp: "<strong>🧩 Constructor DI 的威力（免 Spring Boot！）</strong><br/>只需透過建構子把 <code>postgres.getJdbcUrl()</code> 傳進純 Java <code>UserRepository</code>，即可無痛對接真實資料庫！",
          ban: "🔗 步驟 3 完成：待測程式已透過標準 JDBC 連上容器資料庫。" },
        { log: "[Step 4/5] Running JUnit 5 Integration Tests...\n> ✅ testSaveAndFindWithNativeJsonb() -> id=1, JSONB OK\n> ✅ testUniqueEmailConstraintViolation() -> SQLState 23505\n> ✅ testPostgresUpsertOnConflict() -> ON CONFLICT OK",
          exp: "<strong>🎯 真刀真槍驗證生產 SQL！</strong><br/>每筆測試前執行 <code>TRUNCATE TABLE users</code> 確保獨立性 (FIRST 原則)，完整驗證 JSONB、Upsert 與真實 <code>23505</code> 錯誤碼！",
          ban: "✅ 步驟 4 完成：3 項真實 PostgreSQL 整合測試全數綠燈通過！" },
        { log: "[Step 5/5] Testcontainers Ryuk Reaper Cleanup\n> Stopping container postgres:16-alpine ...\n> Removing container & anonymous volume ...\n> ✅ Cleanup complete! 0 orphan containers left.",
          exp: "<strong>🧹 Ryuk 守護容器 (Reaper) 自動善後</strong><br/>即使測試中途當掉或被強制中斷，Testcontainers 附帶的 Ryuk 容器也會在數秒內自動回收殘留容器，環境永遠乾淨如新！",
          ban: "🎉 5 步生命週期完整結束！零殘留、零環境漂移、100% 生產一致性。" }
      ];
      var TC_TRAPS = [
        { h2t: "❌ H2 陷阱 1：不支援真實 JSONB 與 RETURNING id", h2d: "為了在 H2 跑過測試，開發者常被迫把 <code>JSONB</code> 降級為 <code>VARCHAR</code> 或改寫 SQL，導致測試與生產環境完全脫節！",
          pgt: "✅ Testcontainers (postgres:16-alpine)：原生語法直上", pgd: "完整執行 <code>CAST(? AS jsonb) RETURNING id</code> 與 <code>metadata-&gt;&gt;'role'</code>，本機過了上線就 100% 相容！" },
        { h2t: "❌ H2 陷阱 2：ON CONFLICT DO UPDATE 語法差異", h2d: "PostgreSQL 特有的 <code>INSERT ... ON CONFLICT (email) DO UPDATE SET name = EXCLUDED.name</code> 在 H2 預設模式會直接拋出語法錯誤或行為偏差。",
          pgt: "✅ Testcontainers：真實 Upsert 行為驗證", pgd: "在真實 PostgreSQL 16 容器執行 <code>upsertNameByEmail()</code>，確保重複鍵更新邏輯與正式機完全一致！" },
        { h2t: "❌ H2 陷阱 3：UNIQUE 錯誤碼與併發鎖失真", h2d: "H2 單機記憶體引擎難以重現真實資料庫的 <code>SQLState 23505</code>、行級鎖 (`FOR UPDATE`) 與高併發死結 (`Deadlock`)。",
          pgt: "✅ Testcontainers：精準攔截 23505 與交易回滾", pgd: "直接斷言 <code>assertEquals(\"23505\", ex.getSQLState())</code> 並實測 <code>conn.rollback()</code>，確保交易邊界牢不可破！" }
      ];
      var tcTab = "lifecycle", tcStep = 0, tcTrap = 0;
      function renderTc() {
        tcTabBtns.forEach(function(b) { b.classList.toggle("is-active", b.getAttribute("data-tc-tab") === tcTab); });
        if (tcViewLife) tcViewLife.style.display = (tcTab === "lifecycle") ? "" : "none";
        if (tcViewTrap) tcViewTrap.style.display = (tcTab === "h2trap") ? "" : "none";
        tcStepChips.forEach(function(c, i) {
          c.classList.toggle("is-active", i === tcStep);
          c.classList.toggle("is-done", i < tcStep);
        });
        var s = TC_STEPS[tcStep];
        if (tcConsole) tcConsole.textContent = s.log;
        if (tcExplain) tcExplain.innerHTML = s.exp;
        if (tcLifeBanner) { tcLifeBanner.textContent = s.ban; tcLifeBanner.classList.toggle("is-done", tcStep === TC_STEPS.length - 1); }
        tcTrapBtns.forEach(function(b, i) { b.classList.toggle("is-active", i === tcTrap); });
        var tr = TC_TRAPS[tcTrap];
        if (tcH2Title) tcH2Title.textContent = tr.h2t;
        if (tcH2Desc) tcH2Desc.innerHTML = tr.h2d;
        if (tcPgTitle) tcPgTitle.textContent = tr.pgt;
        if (tcPgDesc) tcPgDesc.innerHTML = tr.pgd;
      }
      tcTabBtns.forEach(function(b) { b.addEventListener("click", function(e) { e.stopPropagation(); tcTab = b.getAttribute("data-tc-tab"); renderTc(); }); });
      tcStepChips.forEach(function(c, i) { c.addEventListener("click", function(e) { e.stopPropagation(); tcStep = i; renderTc(); }); });
      tcTrapBtns.forEach(function(b, i) { b.addEventListener("click", function(e) { e.stopPropagation(); tcTrap = i; renderTc(); }); });
      if (tcNext) tcNext.addEventListener("click", function(e) {
        e.stopPropagation();
        if (tcTab === "lifecycle") tcStep = (tcStep + 1) % TC_STEPS.length;
        else tcTrap = (tcTrap + 1) % TC_TRAPS.length;
        renderTc();
      });
      if (tcReset) tcReset.addEventListener("click", function(e) { e.stopPropagation(); tcStep = 0; tcTrap = 0; renderTc(); });
      renderTc();
    }
  }

  if (document.readyState === "loading") {
    document.addEventListener("DOMContentLoaded", initHeaderDropdown);
  } else {
    initHeaderDropdown();
  }
  setTimeout(initHeaderDropdown, 400);
})();
</script>
