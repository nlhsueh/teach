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
> 從純 Java 建構子依賴注入 (`Constructor DI`) 出發，親手實作 Top-Down (Stub)、Bottom-Up (Driver) 與 Mockito 測試替身，無痛銜接企業級整合測試架構！

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

</div>
<div>

### 🎭 測試替身與 Mockito 實戰
- [**7.5 隔離架構與測試替身原則 (Test Doubles)**](#15)：
  - 從 Driver/Stub 到 **5 大替身**（Dummy, Stub, Spy, Mock, Fake）
  - 何時用 Mock vs. 真實物件（以 `Stock Market` 台積電股價為例）
  - 警惕**脆化測試 (Brittle Tests)** 與過度 Mock 三大反模式
- [**7.6 Lab: Mockito 測試驅動與模擬 (`u07_mockito`)**](#20)：
  - 手寫 Stub 進化至動態 `mock()`、`@Mock` + `@InjectMocks`
  - `mock()` vs. `spy()`（`PrimeSpyTest` 局部修補實戰）
  - `verify()` 抓出 `PrimeTest` 漏測 `isPrime(1)` 之隱藏 Bug！
- [**7.7 課堂實習與綜合練習 (`LabDemo u07_mockito`)**](#24)：
  - 質數系統、計算機契約失配與股票市值三大模組動手演練
  - 整合測試與 Mockito 必考觀念題快篩解析

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

<!-- header: '7.7 課堂實習與綜合練習' -->

## 🧪 7.7 課堂實習指引 (`LabDemo u07_mockito`) 與必考觀念解析

<div class="card-deck">

> 💡 請打開 `LabDemo` 專案的 `src/test/java/u07_mockito`，不需安裝任何額外伺服器，直接點擊 JUnit 綠色三角形 ▶️ 動手體驗三大模組！

<div class="two-columns">
<div class="card">

### 💻 課堂動手實習三部曲 (`u07_mockito`)
1. **實驗 1：質數系統由上而下、Spy 與由下而上整合 (`prime/`)**
   - 開啟 [PrimeTest.java](../../lab.html?file=LabDemo/src/test/java/u07_mockito/prime/PrimeTest.java)、[PrimePlusTest.java](../../lab.html?file=LabDemo/src/test/java/u07_mockito/prime/PrimePlusTest.java)、[PrimeSpyTest.java](../../lab.html?file=LabDemo/src/test/java/u07_mockito/prime/PrimeSpyTest.java)。
   - **動手任務**：修正 `PrimeTest.java` 第 41 行的 `verify(mockChecker).isPrime(1)` 讓測試由紅轉綠，並比較手寫 `MockPrimeChecker`、`mock()`、`spy()` 與 `RealPrimeChecker` 四種測法！
2. **實驗 2：計算機前後置契約失配排查 (`calculator/`)**
   - 開啟 [CalculatorTest.java](../../lab.html?file=LabDemo/src/test/java/u07_mockito/calculator/CalculatorTest.java) 與 [Calculator.java](../../lab.html?file=LabDemo/src/main/java/u07_mockito/calculator/Calculator.java)。
   - **動手任務**：寫一個真實整合測試 `new Calculator(new RealCalculatorService()).divide(6, 0)`，取消 `Calculator.java` 第 25~27 行註解修復除以零防呆！
3. **實驗 3：股票市值外部依賴隔離 (`stock/`)**
   - 開啟 [MarketTest.java](../../lab.html?file=LabDemo/src/test/java/u07_mockito/stock/MarketTest.java)，新增第 3 檔股票（如聯發科 `2454`）練習 `when().thenReturn()` 佈樁與市值斷言！

</div>
<div class="card">

### 🎯 必考觀念題快篩與解析
- **Q1：關於整合測試，下列何者正確？（複選題）**
  - ❌ (A) 整合測試測試所有模組，又稱為系統測試 *(錯，層級不同)*
  - ❌ (B) 若一開始律定好介面規格，就可省略整合測試 *(錯，如 `Calculator` 除以零案例，實作仍會發生契約誤解或時序衝突)*
  - ✅ **(C) 由下而上的整合測試，需要設計 Test Driver** *(正確！)*
  - ✅ **(D) 一般而言，Stub 的設計比 Driver 較為困難** *(正確！)*
- **Q2：關於 Mockito 的使用，下列何者正確？（單選題）**
  - ❌ (A) 僅適合用於由下往上的整合測試 *(錯，Mock/Stub 最常用於由上而下隔離底層)*
  - ✅ **(B) 利用 `when(...).thenReturn(...)` 來設定假回傳資料** *(正確！)*
  - ❌ (C) `mock(A.class)` 的 `A` 不可為 interface *(錯，最常 mock interface)*
  - ❌ (D) `mock` 僅用於由上往下，`spy` 僅用於由下往上 *(錯)*

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
  }

  if (document.readyState === "loading") {
    document.addEventListener("DOMContentLoaded", initHeaderDropdown);
  } else {
    initHeaderDropdown();
  }
  setTimeout(initHeaderDropdown, 400);
})();
</script>
