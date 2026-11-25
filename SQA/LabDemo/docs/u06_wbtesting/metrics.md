
# Code Metrics

## Install

Install `Cyclomatic Complexity` metric to your Intellij
* Intellij >> Settings >> Plugins >> Marketplace >> search `MetricsReloaded`
  * Install
  * Restart
  * Choose a file, package or whole project
    * On the project, right click the mouse, choose "Analyze" >> "Calculate metrics"
    * Select the "Complexity metrics"
    * Click "Analyze"
  * On the bottom panel, you will see the metrics

![](../img/calculate_metrics.png)

![](../img/complexity_metrics.png)


## Metrics

`MetricsReloaded` 是一個用於測量和分析程式碼複雜度指標的 IntelliJ 外掛，協助開發人員量化程式碼的可維護性與可測試性。以下介紹五大核心指標：

---

## 💻 MetricsReloaded 外掛程式碼指標介紹

### 1. v(G) (Cyclomatic Complexity) - 圈複雜度

| 定義 | 程式碼的**線性獨立路徑**的數量。 |
| :--- | :--- |
| **白話計算方法** | 把它想像成程式碼中**決策點**（Decision Points）的數量加上 1。每個 `if`、`while`、`for`、`case`（在 `switch` 裡）、`catch`、三元運算子 `? :`，以及邏輯運算子 `&&` 和 `\|\|` 都算作一個決策點。 |
| **隱含的意義** | **數值越大 ➔ 程式碼越複雜**。 |
| **建議值** | 通常認為單一方法的 **v(G) 不應超過 10**。超過 10 就意味著程式碼可能難以理解、難以測試，並且容易出錯。 |

> **簡單來說：** `v(G)` 告訴你一個方法有多少種不同的執行路徑。路徑越多，你需要設計的測試案例就越多，出錯的風險也越高。

### 2. WMC (Weighted Methods per Class) - 類別加權方法數

| 定義 | 類別中**所有方法的複雜度總和**。在 MetricsReloaded 中，這個複雜度通常是使用 **v(G) (圈複雜度)** 來計算。 |
| :--- | :--- |
| **白話計算方法** | 簡單來說，就是把這個類別中**所有方法的 v(G) 值加總起來**。例如，如果一個類別有三個方法，它們的 v(G) 分別是 3, 5, 2，那麼 `WMC = 3 + 5 + 2 = 10`。 |
| **隱含的意義** | **數值越大 ➔ 類別功能越多、越複雜**。 |
| **建議值** | 雖然沒有絕對標準，但 **WMC 過高**通常表示這個類別承擔了**過多的職責**（God Object/Bloated Class）。它可能違反了**單一職責原則 (SRP)**，難以維護和重用。 |

> **簡單來說：** `WMC` 是衡量一個類別**總工作量**的指標。太高的 `WMC` 意味著這個類別應該被拆分成幾個更小的、職責單一的類別。

### 3. OCavg (Class Average Method Complexity) - 類別平均方法複雜度

| 定義 | 類別中**所有方法複雜度的平均值**。 |
| :--- | :--- |
| **白話計算方法** | 將 `WMC` 的值，除以類別中**方法的總數量**：`OCavg = WMC / 類別中的方法總數` |
| **隱含的意義** | **數值越大 ➔ 類別中的「平均方法」越複雜**。 |
| **與 WMC 的區別** | `WMC` 關注**類別的總體大小**，`OCavg` 關注**類別中每個方法的複雜度平均水準**。如果 `WMC` 很高但 `OCavg` 很低，表示類別有很多**簡單**的方法。如果兩者都高，則表示類別有很多**複雜**的方法。 |

> **簡單來說：** `OCavg` 告訴你這個類別的每個方法平均來說有多「燒腦」。

### 4. CogC (Cognitive Complexity) - 認知複雜度

| 定義 | 衡量程式碼對**人類讀者**來說，**理解起來有多困難**。它會考慮程式碼的結構化流、中斷（例如 `break`、`continue`）以及巢狀結構的深度。 |
| :--- | :--- |
| **白話計算方法** | **與 v(G) 相似，但更著重於人類的理解難度**。它懲罰**巢狀結構**（例如 `if` 裡面還有 `if`），以及一些會中斷程式碼正常執行流程的結構（例如 `goto` 或 `break`）。它不會計算那些只是流程控制但不會增加理解難度的結構（例如單純的方法呼叫）。 |
| **隱含的意義** | **數值越大 ➔ 程式碼越難以理解和維護**。這是現代軟體工程中非常重要的指標，因為它直接關注開發人員的閱讀體驗。 |
| **建議值** | 與 v(G) 相似，單一方法的 **CogC 數值越低越好**。高 `CogC` 是**重構**（Refactoring）的強烈訊號。 |

> **簡單來說：** `CogC` 是 `v(G)` 的升級版，專門評估**人腦處理**這段程式碼的難度。

### 5. LOC (Lines of Code) - 程式碼行數

| 定義 | 程式碼中的**物理行數**，通常只計算**實質程式碼**行（不含註釋和空行）。 |
| :--- | :--- |
| **白話計算方法** | 計算類別、方法或檔案中**非空白且非註釋**的程式碼行。 |
| **隱含的意義** | **數值越大 ➔ 類別或方法越長**。 |
| **建議值** | 高 `LOC` 常與高 `WMC`、`v(G)` 同時出現，表示程式碼過長難以掌握；單一方法的 `LOC` 建議控制在 **50 行以內**，符合單一職責原則。 |

> **簡單來說：** `LOC` 衡量程式碼的物理長度。長的方法或類別很難一眼看清全貌。

---

<!-- id: sqa-u05-metrics-ccq1 -->
## 📊 總結與關聯性

MetricsReloaded 提供的這些指標通常需要**結合起來**看，才能全面評估程式碼品質：

| 情境 | 指標組合 | 潛在問題 | 解決建議 |
| :--- | :--- | :--- | :--- |
| **方法過於複雜** | `v(G)` 或 `CogC` **高** | 單個方法邏輯分支太多，難以測試和理解。 | 應將複雜方法**拆解**成多個更小、功能單一的方法。 |
| **類別職責過多** | `WMC` **高** 且 `LOC` **高** | 類別承擔了過多的責任（神級物件）。 | 應使用**設計模式**，將類別**拆分**成多個更專業的類別。 |
| **方法複雜度不一** | `WMC` 高，但 `OCavg` 低 | 類別有很多簡單方法，但可能有一兩個**極度複雜**的方法。 | 專注於重構那幾個特別複雜的方法。 |

---
## 🧪 實作練習範例 (Demo Code)
* **課堂範例（基本路徑）**：[GradeAverage.java](../../src/main/java/u06_coverage/GradeAverage.java) ＆ [GradeAverageBasisPathTest.java](../../src/test/java/u06_coverage/GradeAverageBasisPathTest.java)
* **Lab 2 複雜度度量與重構練習**：[ShippingFeeCalculator.java](../../src/main/java/u06_coverage/ShippingFeeCalculator.java) ＆ [ShippingFeeBasisPathTest.java](../../src/test/java/u06_coverage/ShippingFeeBasisPathTest.java)
* **練習目標**：
  1. 執行 `MetricsReloaded` 插件，比較 `ShippingFeeCalculator` 中 `calculateFeeNested`（深層巢狀）與 `calculateFeeRefactored`（衛語句重構）的 `v(G)` 與 `CogC` 差異。
  2. 針對 `calculateFeeNested` 繪製控制流程圖 (CFG)，導出線性獨立基本路徑並檢驗 `ShippingFeeBasisPathTest` 的分支覆蓋率！
