# 程式碼複雜度指標實作手冊 (Code Metrics)

本手冊說明如何量測 Java 專案的核心程式碼複雜度指標（`v(G)`、`WMC`、`OCavg`、`CogC`、`LOC`），涵蓋 **IntelliJ `MetricsReloaded` 外掛**與 **Antigravity AI 自動化計算與報表產出**兩種實務方法。

---

## 🛠️ 一、如何量測並產生複雜度報告（兩種方法）

本課程共涵蓋五大核心複雜度指標（`v(G)`、`CogC`、`WMC`、`OCavg`、`LOC`）：

| 工具 | `v(G)` | `CogC` | `WMC` | `OCavg` | `LOC` | 報表形式與適用情境 |
| :--- | :---: | :---: | :---: | :---: | :---: | :--- |
| **IntelliJ `MetricsReloaded`** | ✅ | ✅ | ✅ | ✅ | ✅ | IDE 互動面板，可匯出 XML／CSV 完整數據表（**課堂首選**） |
| **Antigravity AI** | ✅ | ✅ | ✅ | ✅ | ✅ | 逐行拆解計算過程，直接產出 Markdown／HTML 複雜度報告與重構建議（**免裝外掛**） |

> **⚠️ 備註（為何不用 JaCoCo 或 PMD 產出複雜度總表？）**：
> - **JaCoCo** 專注於測試覆蓋率，僅附帶 `Cxty`（`v(G)`）與 `Lines`，不包含 `CogC`、`WMC`、`OCavg`。
> - **PMD** 屬於靜態規則違規稽核工具（報表以命名與程式碼風格違規為主，且僅在超過門檻時告警，不會列出各方法的完整 5 指標數值表）。
> 因此量測完整五大複雜度指標，建議使用 **`MetricsReloaded`** 或 **Antigravity AI**。

### 方法 A：使用 IntelliJ `MetricsReloaded` 外掛（IDE 完整報表）

1. 開啟 IntelliJ IDEA，前往 **Settings ➔ Plugins ➔ Marketplace**，搜尋並安裝 **`MetricsReloaded`**，安裝後重新啟動 IDE。
2. 選擇欲分析的檔案、套件或整個專案：
   - 在專案或目標資料夾上按右鍵，選擇 **Analyze ➔ Calculate Metrics...**。
   - 在設定檔（Metrics profile）中選擇 **Complexity metrics**（確保勾選 `v(G)`、`WMC`、`OCavg`、`CogC`、`LOC`）。
   - 點擊 **Analyze** 開始掃描。
3. 掃描完成後，於視窗下方 **Metrics** 面板檢視各套件、類別與方法的量化數值（超出門檻的高危方法會以紅字警示）；亦可使用面板左上角的匯出按鈕將結果存為 XML／CSV 報表。

![](../img/calculate_metrics.png)

![](../img/complexity_metrics.png)

---

### 方法 B：使用 Antigravity AI 自動計算指標並產出報告（免裝外掛）

若未安裝 IDE 外掛，或需要針對多個檔案快速產出「**複雜度分析報告＋重構前後對照表**」，可直接在 **Antigravity** 中指定目標原始碼檔案，讓 AI 依標準定義（McCabe `v(G)` 與 SonarSource `CogC` 規則）進行精確計算與診斷。

#### 1. 基本計算指令（Prompt 範本）
> 「請分析 `@ShippingFeeCalculator.java` 中每一個方法與類別，計算並以 Markdown 表格列出以下五大程式碼指標：
> 1. 圈複雜度 `v(G)`（請逐條列出每個決策點）
> 2. 認知複雜度 `CogC`（請標註每一處結構增量與巢狀深度加權）
> 3. 實質程式碼行數 `LOC`（排除空行與註解）
> 4. 類別層級的 `WMC`（所有方法 `v(G)` 總和）與 `OCavg`（平均方法複雜度）
> 最後指出哪些方法超過警戒門檻（`v(G) > 10` 或 `CogC > 15`）並提出衛語句重構建議。」

#### 2. 讓 Antigravity 直接產生可檢視的報告檔案
> 「請掃描 `LabDemo/src/main/java/u06_coverage/` 目錄下所有 Java 類別，計算各類別與方法的 `v(G)`、`CogC`、`WMC`、`OCavg`、`LOC`，並將完整分析結果輸出成一份 Markdown 報告 `metrics_report.md`（或 HTML 儀表板），包含高複雜度排行與重構建議。」

> **💡 Antigravity 計算優勢與注意事項**：
> - **優勢**：能逐行解釋「為什麼這一行 `CogC` 加了 +3（基礎 1 + 巢狀深度 2）」，非常適合課堂學習與程式碼審查；並可直接銜接產出衛語句重構程式碼、HTML 儀表板報告與對應之基本路徑 JUnit 測試。
> - **核對原則**：AI 計算屬於靜態語意推演，建議搭配 **IntelliJ `MetricsReloaded`** 交叉核對數值。

---

## 💻 二、五大核心程式碼複雜度指標介紹

### 1. `v(G)` — 圈複雜度（Cyclomatic Complexity）

| 項目 | 說明 |
| :--- | :--- |
| **定義** | 程式碼中**線性獨立執行路徑**的數量。 |
| **白話計算方法** | 計算程式碼中**決策點**（Decision Points）的總數再加上 `1`。每個 `if`、`while`、`for`、`case`、`catch`、三元運算子 `? :`，以及複合邏輯運算子 `&&` 與 `\|\|` 皆計為 1 個決策點。 |
| **隱含意義** | **數值越大 ➔ 邏輯分支越多、所需基本路徑測試案例越多**。 |
| **建議門檻** | 單一方法建議 **`v(G) <= 10`**；超過 10 代表難以理解與測試，缺陷風險顯著上升。 |

> **一句話總結**：`v(G)` 告訴你一個方法至少需要幾條獨立路徑才能達成基本路徑覆蓋。

### 2. `WMC` — 類別加權方法數（Weighted Methods per Class）

| 項目 | 說明 |
| :--- | :--- |
| **定義** | 類別中**所有方法的複雜度總和**（預設以各方法的 `v(G)` 作為權重）。 |
| **白話計算方法** | 將該類別中所有方法的 `v(G)` 相加。例如某類別有三個方法，`v(G)` 分別為 3、5、2，則 `WMC = 3 + 5 + 2 = 10`。 |
| **隱含意義** | **數值越大 ➔ 類別承擔的總工作量與邏輯越龐大**。 |
| **建議門檻** | `WMC` 過高通常是「上帝物件（God Object）」警訊，代表違反**單一職責原則（SRP）**，應拆分為多個職責單一的小類別。 |

### 3. `OCavg` — 類別平均方法複雜度（Class Average Method Complexity）

| 項目 | 說明 |
| :--- | :--- |
| **定義** | 類別中所有方法複雜度的算術平均值。 |
| **白話計算方法** | `OCavg = WMC / 類別中的方法總數`。 |
| **與 `WMC` 的差別** | 若 `WMC` 高但 `OCavg` 低，代表類別方法很多但大多很單純（可能只需注意少數特別複雜的方法）；若兩者皆高，表示整個類別普遍過於複雜。 |

### 4. `CogC` — 認知複雜度（Cognitive Complexity）

| 項目 | 說明 |
| :--- | :--- |
| **定義** | 衡量程式碼對**人類閱讀與理解**的困難程度（由 SonarSource 提出），重點懲罰**巢狀深度（Nesting Depth）**與流程中斷。 |
| **白話計算方法** | 每進入一層巢狀結構（如 `if` 內再包 `for` 與 `if`），內層條件除了本身 `+1`，還會額外加上「目前的巢狀層數」作為懲罰；反之，平坦的 `switch` 結構或衛語句（Guard Clauses）則不會累積巢狀懲罰。 |
| **隱含意義** | **數值越大 ➔ 人腦閱讀越吃力、維護時越容易改出新 Bug**。 |
| **建議門檻** | 單一方法建議 **`CogC <= 15`**；高 `CogC` 是應立即進行重構（如衛語句扁平化、提煉方法）的強烈訊號。 |

### 5. `LOC` — 實質程式碼行數（Lines of Code）

| 項目 | 說明 |
| :--- | :--- |
| **定義** | 扣除空白行與註解後的**實質程式碼物理行數**。 |
| **隱含意義** | **數值越大 ➔ 方法或類別越冗長**，通常與高 `v(G)`、`WMC` 同時出現。 |
| **建議門檻** | 單一方法建議控制在 **50 行以內**，確保閱讀時一眼可掌握完整邏輯。 |

---

<!-- id: sqa-u05-metrics-ccq1 -->
## 📊 三、指標組合診斷與重構對照表

實務上應**綜合判讀**各項指標，而非只看單一數字：

| 診斷情境 | 指標特徵 | 潛在品質問題 | 重構與測試建議 |
| :--- | :--- | :--- | :--- |
| **方法過於複雜** | `v(G)` 高 且 `CogC` 高 | 單一方法分支過多且巢狀過深，難以理解與測試。 | 使用**衛語句（Guard Clauses）**降低巢狀深度，並以**提煉方法（Extract Method）**拆分邏輯。 |
| **類別過度膨脹** | `WMC` 高 且 `LOC` 高 | 類別承擔過多職責（上帝類別），違反單一職責原則。 | 依業務領域拆分為多個高內聚、低耦合的專責類別。 |
| **複雜度集中失衡** | `WMC` 高 但 `OCavg` 低 | 類別中多數方法簡單，但隱藏 1～2 個極端複雜的核心方法。 | 鎖定 `v(G)` 與 `CogC` 最高的那幾個方法優先補齊基本路徑測試並重構。 |

---

## 🧪 四、課堂實作練習（LabDemo）

- **課堂範例（基本路徑）**：[GradeAverage.java](../../src/main/java/u06_coverage/GradeAverage.java) ＆ [GradeAverageBasisPathTest.java](../../src/test/java/u06_coverage/GradeAverageBasisPathTest.java)
- **Lab 2 複雜度度量與重構練習**：[ShippingFeeCalculator.java](../../src/main/java/u06_coverage/ShippingFeeCalculator.java) ＆ [ShippingFeeBasisPathExerciseTest.java](../../src/test/java/u06_coverage/ShippingFeeBasisPathExerciseTest.java)（僅含 Path 1–2，其餘基本路徑待補齊）
- **實作任務**：
  1. 使用 `MetricsReloaded` 或 **Antigravity AI** 產生完整五大指標報表，比較 `ShippingFeeCalculator` 中 `calculateFeeNested`（深層巢狀）與 `calculateFeeRefactored`（衛語句重構）的 `v(G)`、`CogC`、`WMC`、`OCavg` 與 `LOC` 差異。
  2. 針對 `calculateFeeNested` 繪製控制流程圖（CFG），導出線性獨立基本路徑，補齊 [ShippingFeeBasisPathExerciseTest.java](../../src/test/java/u06_coverage/ShippingFeeBasisPathExerciseTest.java) 中的 `TODO` 測試並執行 `mvn clean test -Dtest=ShippingFeeBasisPathExerciseTest jacoco:report` 驗證達到 100% 分支覆蓋。
