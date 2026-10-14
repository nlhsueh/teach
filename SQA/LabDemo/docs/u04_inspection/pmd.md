## PMD 介紹

**PMD** 是一個靜態程式碼分析工具，主要用於檢查 Java 程式碼中的潛在問題，例如壞味道（code smells）、未使用的變數、空的 `catch` 區塊、不良的程式結構等。它幫助開發者自動檢查程式碼，提供問題建議，從而提升程式碼品質並減少潛在的錯誤。

PMD 可以與多種構建工具集成，**Maven** 是其中之一。在 Maven 專案中，我們可以透過設定 `pom.xml` 文件，使用 **PMD Maven Plugin** 來自動檢查專案中的程式碼品質。

[Java check rule in PMD](https://docs.pmd-code.org/latest/pmd_rules_java.html)

### PMD 如何提升程式品質

PMD 能檢查程式碼中的許多常見問題，從而提升程式碼的可讀性、維護性及效能。其主要作用包括：

1. **檢測壞味道（Code Smells）**：PMD 可以發現不良的程式結構或不必要的複雜性，這些問題在後續維護過程中可能會導致錯誤或影響效能。
   
2. **強制遵循程式碼風格**：PMD 支援自定義規則，可以確保程式碼符合團隊的編碼標準。

3. **早期發現潛在錯誤**：透過靜態分析，PMD 能夠發現一些潛在的錯誤，避免在後期測試或執行時才發現。

4. **報告程式碼問題**：PMD 生成詳細的報告，指出程式碼中每個問題所在的具體行數及原因，方便開發者進行修正。

### PMD 規則分類總覽

PMD 提供了豐富的預定義規則集，主要涵蓋以下核心維度。各類別之詳細規則定義、壞味道描述與程式碼重構對策，請參閱專屬手冊：

👉 **[📖 點此查看 PMD Java 規則與壞味道詳細手冊 (javarules.md)](./javarules.md)**

| 規則分類 (Category) | 核心目標與檢查範疇 | 典型範例規則 |
| :--- | :--- | :--- |
| **Best Practices** | 建議更安全、高效且符合現代 Java 慣例的語法 | `UseEqualsToCompareStrings`, `UseTryWithResources`, `EmptyCatchBlock` |
| **Code Style** | 強制遵循團隊編碼風格，提高可讀性與審查效率 | `MethodNamingConventions`, `UseBraces`, `AvoidMagicNumbers` |
| **Design** | 識別架構壞味道，降低耦合度，提升可維護性 | `GodClass`, `CyclomaticComplexity`, `LawOfDemeter` |
| **Documentation** | 確保重要 API 具備合規且適當長度的 Javadoc | `CommentRequired`, `CommentSize`, `MissingJavadocMethod` |
| **Error Prone** | 偵測容易引發執行期例外或記憶體洩漏的缺陷 | `NullAssignment`, `AvoidCatchingGenericException`, `AvoidHardCodedPasswords` |
| **Multithreading** | 檢查多執行緒環境下的同步與中斷安全 | `DoNotIgnoreInterruptedException`, `AvoidSynchronizedAtMethodLevel` |
| **Performance** | 避免無效的資源浪費與不必要的記憶體配置 | `AvoidInstantiatingObjectsInLoops`, `UseArraysAsList` |
| **Security** | 檢查潛在安全漏洞（如注入風險與硬編碼金鑰） | `HardCodedCryptoKey` |

---

### PMD 之應用與配置
  

要在 Maven 中使用 PMD，我們需要在 `pom.xml` 中加入 **PMD Maven Plugin**。以下是一個範例配置，展示如何使用 PMD 來檢查程式碼：

#### 1. `POM.xml` 配置

```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-pmd-plugin</artifactId>
            <version>3.26.0</version>
            <configuration>
                <rulesets>
                    <!-- 指定使用的 PMD 規則集 -->
                    <ruleset>src/main/resources/pmd/ruleset.xml</ruleset>
                </rulesets>
                <failOnViolation>false</failOnViolation>
                <printFailingErrors>true</printFailingErrors>
            </configuration>
            <executions>
                <execution>
                    <goals>
                        <!-- 執行 PMD 的 check 工作 -->
                        <goal>check</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```

#### 2. 設定規則集

```xml
<?xml version="1.0" encoding="UTF-8"?>

<ruleset name="All Java Rules"
         xmlns="http://pmd.sourceforge.net/ruleset/2.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://pmd.sourceforge.net/ruleset/2.0.0 https://pmd.sourceforge.io/ruleset_2_0_0.xsd">
    <description>Every Java Rule in PMD</description>
    
    <!-- the rules to be checked -->
    <rule ref="category/java/bestpractices.xml">
        <exclude name="SystemPrintln"/>
        <exclude name="AvoidReassigningParameters"/>
    </rule>
    <rule ref="category/java/codestyle.xml" />
    <rule ref="category/java/design.xml" />
    <rule ref="category/java/documentation.xml" />
    <rule ref="category/java/errorprone.xml" />
    <rule ref="category/java/multithreading.xml" />
    <rule ref="category/java/performance.xml" />
    <rule ref="category/java/security.xml" />

    <!--  override the rules  -->
    <rule ref="category/java/documentation.xml/CommentSize">
        <properties>
            <property name="maxLines" value="6" />
            <property name="maxLineLength" value="80" />
        </properties>
    </rule>
</ruleset>
```

這個規則集設定會檢查 Java 程式碼中的 `System.out.println` 語句，並在檢查到使用時產生警告。

#### 3. 執行規則檢查

在 Maven 中執行 PMD: 打開 Intellij 右方的 Maven 工具，執行 `verify` 進行檢查。

或是使用 console command: maven 中的 PMD 預設會在 `verify` 階段運行，也就是說，在執行以下指令時會自動觸發 PMD 檢查：

```bash
mvn verify
```

或者直接執行 PMD 檢查目標：

```bash
# 預設執行：檢查 pom.xml 中配置的 u04_inspection 單元範圍
mvn pmd:check
```

##### 🎯 如何只檢查特定類別（例如 BubbleSort）？

一般 Maven 預設會掃描專案內所有來源檔，但我們在 `pom.xml` 中預設將範圍鎖定於 `u04_inspection`。若在日常練習時只想針對特定檔案進行檢查，可透過 `-Dpmd.includes` 參數動態指定：

```bash
# 1. 僅檢查所有氣泡排序相關類別 (BubbleSort*)
mvn pmd:check -Dpmd.includes="**/BubbleSort*"

# 2. 僅針對學生實習練習類別 (BubbleSortExercise) 進行檢查
mvn pmd:check -Dpmd.includes="**/BubbleSortExercise.java"

# 3. 產出該特定檔案的 HTML 網頁視覺化報告
mvn pmd:pmd -Dpmd.includes="**/BubbleSortExercise.java"
```

#### 4. 觀看報告、修正程式碼

打開 `target/report/pmd.html`, 觀看錯誤。在頁面上對於該違規如果不清楚，可以直接點擊觀看該違規，會引導到 PMD 的網站觀看說明。修正程式碼後可以再次執行 verify。

#### 5. 調整規則
如果有規則實在不符合你的需要， 例如 CommentSize 原先設定最大行數與長度分別為 6 與 80, 你可以修改：

* 修改規則參數
```xml
    <!--  override the rules  -->
    <rule ref="category/java/documentation.xml/CommentSize">
        <properties>
            <property name="maxLines" value="10" />
            <property name="maxLineLength" value="90" />
        </properties>
    </rule>
```

* 排除規格: 例如將 SystemPrintln 與 AvoidReassigningParameters 排除

```xml
    <rule ref="category/java/bestpractices.xml">
        <exclude name="SystemPrintln"/>
        <exclude name="AvoidReassigningParameters"/>
    </rule>
```

* 忽略警告
如果某些程式碼不適合檢查規則，可以透過 `@SuppressWarnings("PMD")`，讓警告不要出現在報告中。

```java
@SuppressWarnings("PMD")
public class Main {
    public static void main(String[] args) {
        // TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");
...        
```

詳細可以參考 [這裡](#忽略違規)

#### 管理違規

 ```xml
   <configuration>
       <rulesets>
           <ruleset>src/main/resources/pmd/ruleset.xml</ruleset>
       </rulesets>
       <failOnViolation>true</failOnViolation>
       <minimumPriority>3</minimumPriority> <!-- Set to 3 for "warning" and below -->
   </configuration>
```   

在 PMD 的 `configuration` 部分，這兩行設定的作用如下：

1. `<failOnViolation>true</failOnViolation>`
   這表示當 PMD 檢查程式碼時，如果發現任何違規（即不符合規則的程式碼），構建過程將失敗（例如 Maven build 會停止）。設定為 `true` 意味著發現的任何問題都會導致構建失敗，確保這些問題在繼續構建之前必須先行修復。

2. `<minimumPriority>3</minimumPriority>`
   這設定了 PMD 規則的最低優先級。PMD 中的優先級範圍是從 1 到 5，1 表示最高優先級，5 表示最低優先級。當設置為 `minimumPriority` 為 3 時，PMD 只會報告優先級為 3 或更高的違規行為，較低優先級的違規（4 和 5）將會被忽略，不會報告。

此配置的目的是控制 PMD 檢查的嚴格程度，以及哪些問題會導致構建失敗。

如果您想控制 PMD 對違規嚴重程度的行為，您可以調整「pom.xml」中的設定。以下是一些選項：

1. **Set Minimum Severity**: 您可以設定最低嚴重性級別，必須違反該級別 PMD 才能導致建置失敗。例如，您可以指定僅在「error」等級違規時失敗：


2. **Fail on Violations**: If you want to ensure that the build fails only if there are "critical" issues, you can manage this through configurations like:

   ```xml
   <configuration>
       <failOnViolation>true</failOnViolation>
       <minimumPriority>2</minimumPriority> <!-- Only fail on error and critical issues -->
   </configuration>
   ```

3. **Ignoring Certain Rules**: If some violations are not critical, consider excluding specific rules from your ruleset that generate excessive warnings or are not applicable to your project's context.

### 忽略違規

In PMD, to selectively ignore violations, such as one of the `AvoidArrayLoops` rule violations in your code, you can use **PMD suppression mechanisms**. There are three common approaches:

1. **Suppressing Violations with Annotations**
2. **Suppressing Violations with NOPMD Comments**
3. **Using Suppressions in a PMD Configuration File**

#### 1. 使用「標記」SuppressWarnings

局部方法忽略特定規則
```java
@SuppressWarnings("PMD.AvoidArrayLoops")
public void exampleMethod() {
    // Code that would normally trigger AvoidArrayLoops rule
}
```

整個 class 都忽略 PMD 的規則：
```java
@SuppressWarnings("PMD")
public class Main {
    public static void main(String[] args) {
        // TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");
...        
```

#### 2. 使用「註解」NOPMD

```java
for (int i = 0; i < array.length; i++) { //NOPMD - This loop is necessary for performance reasons
    // Your loop code here
}
```

The `NOPMD` comment will tell PMD to ignore the violation for that particular line. Make sure to include a reason after `//NOPMD` for better maintainability and clarity.

#### 3. 客製化規則

```xml
<rule ref="category/java/bestpractices.xml/AvoidArrayLoops">
    <exclude-pattern>.*SomeSpecificFile.java</exclude-pattern>
</rule>
```
or

```xml
<rule ref="category/java/bestpractices.xml">
    <exclude name="SystemPrintln">
        <exclude-pattern>fcu/.*\.java</exclude-pattern>
    </exclude>
    <exclude name="AvoidReassigningParameters" />
</rule>
```

### 改變 PMD 的檢查時程

PMD 預設是在 `verify` 時期執行，如果你想要讓 PMD 在其他階段（例如 `validate` 或 `compile`）運行，可以修改 `pom.xml` 中 `executions` 部分：

```xml
<execution>
    <phase>validate</phase>  <!-- 讓 PMD 在 validate 階段執行 -->
    <goals>
        <goal>check</goal>
    </goals>
</execution>
```

這樣每次執行 `mvn validate` 時就會執行 PMD 的檢查。

## 範例示範：氣泡排序 (Bubble Sort) 程式碼檢視

為了讓大家具體體會 PMD 如何揪出潛藏的壞味道，本單元在 `src/main/java/u04_inspection/` 提供了以氣泡排序為例的示範與實習程式：

1. **`BubbleSortBadSmellDemo.java`**：刻意涵蓋多種 PMD 違規的示範類別。
2. **`BubbleSortClean.java`**：重構後無壞味道且符合 PMD 標準的典範類別。
3. **`BubbleSortExercise.java`**：供課堂實作練習的起始類別。
4. **`BubbleSortTest.java`** (`src/test/java/u04_inspection/`)：驗證功能正確性的單元測試。

### 常見壞味道與 PMD 規則對照表

| PMD 規則 | 壞味道描述與程式碼片段 | 潛在風險 / 影響 | 重構建議 |
| :--- | :--- | :--- | :--- |
| **`UseEqualsToCompareStrings`** | `if (Sort_Order == "DESC")` | 字串常數池比較，可能因物件位址不同引發邏輯錯誤 | 改用 `.equals()` 或定義 `Enum` |
| **`AvoidInstantiatingObjectsInLoops`**| 迴圈內 `new SimpleDateFormat(...)` | 每次內層比較皆配置物件，引發頻繁 GC 與效能下降 | 提取至迴圈外部或設為常數重複使用 |
| **`AvoidMagicNumbers`** | `if (Arr.length > 1000)` | 硬編碼數字語意不明，日後難以統一維護 | 提取為 `public static final int MAX_SIZE` |
| **`UseBraces`** | `if (needSwap) swap();` 省略 `{}` | 容易在後續多人協作維護時因縮排錯覺產生邏輯漏洞 | 強制使用 `{}` 包裹程式碼區塊 |
| **`FieldNamingConventions`** | `private int Total_Swaps;` | 違背 Java 小駝峰命名標準 | 改為 `totalSwaps` |
| **`EmptyCatchBlock`** | `catch (Exception e) {}` | 吞掉例外錯誤，導致排查 bug 困難 | 記錄日誌（如 Log4j 2）或向上拋出例外 |
| **`CommentRequired`** | 缺乏類別與方法 Javadoc 註解 | 團隊成員與外部呼叫者無法理解 API 契約 | 補齊標準 Javadoc（說明、`@param`、`@return`） |

---

## 實驗實作 (Lab Exercises)

### Lab 01: 執行 PMD 靜態檢查

**目標**：透過 Maven 執行 PMD 插件，確認專案靜態分析工具運作正常，並學會檢視報告。

#### 方法 A：使用終端機 (CLI) 執行

1. **執行靜態檢查**：
   開啟終端機，在專案根目錄下執行：
   ```bash
   # 檢查整個 u04_inspection 單元
   mvn pmd:check

   # 或是只檢查特定檔案（例如學生的練習題）
   mvn pmd:check -Dpmd.includes="**/BubbleSortExercise.java"
   ```
   *附註：PMD 會在終端機輸出違規數量與簡要摘要，並生成完整報告於 `target/pmd.xml`。*

2. **產出 HTML 網頁格式報告**：
   ```bash
   # 產出練習題的專屬 HTML 報表
   mvn pmd:pmd -Dpmd.includes="**/BubbleSortExercise.java"
   ```
   執行完成後，使用瀏覽器打開 `target/reports/pmd.html`（或 `target/site/pmd.html`），即可點擊各個規則超連結查看 PMD 官方詳細說明。

---

#### 方法 B：使用 IntelliJ IDEA 執行檢查

在 IntelliJ IDEA 中，您可透過內建的 **Maven 工具視窗** 或 **PMD 外掛** 進行檢查：

##### 1. 透過內建 Maven 工具視窗（無需額外安裝外掛）

* **檢查整個 u04 單元**：
  1. 展開 IntelliJ 右側側邊欄的 **`Maven`** 視窗。
  2. 依序展開 `LabDemo` ➜ `Plugins` ➜ `pmd`。
  3. 雙擊 **`pmd:check`** 即可在下方 Run 視窗檢視整個單元的違規摘要。
* **只檢查個別單一檔案 (例如 BubbleSortExercise.java)**：
  1. 點擊 Maven 工具列上方的 **「Execute Maven Goal」** 圖示（圖示為圓形內含字母 `m`，快捷鍵連按兩次 `Ctrl`）。
  2. 在跳出的指令框中輸入以下參數並按下 Enter：
     ```text
     pmd:check -Dpmd.includes="**/BubbleSortExercise.java"
     ```

##### 2. 透過 IntelliJ PMD 外掛 (PMDPlugin - 圖形右鍵即時檢查)

* **前置設定（一次性）**：
  1. 前往 `Settings` (macOS 為 `Preferences`) ➜ `Plugins` ➜ 搜尋並安裝 **`PMDPlugin`**。
  2. 安裝後進入 `Settings` ➜ `Tools` ➜ `PMD`，在 Rulesets 區塊點擊 `+` 號，選擇 `src/main/resources/pmd/ruleset.xml` 作為自訂規則集。
* **檢查整個單元**：
  * 在左側專案樹狀圖 (Project View) 的 `u04_inspection` 目錄上 **按右鍵** ➜ 選擇 **`Run PMD`** ➜ 點選您的規則集，即可在下方 PMD 視窗樹狀列出所有違規。
* **檢查個別單一檔案**：
  * 在欲檢查的 Java 檔案編輯器內（或左側檔案節點上）**按右鍵** ➜ 選擇 **`Run PMD`**，分析結果將直接在該檔案的程式碼行旁標示警告與波浪底線。

---

### Lab 02: 依 PMD 報告進行重構 (Improve Code)

**目標**：開啟 `src/main/java/u04_inspection/BubbleSortExercise.java`，根據 PMD 報告修復至少 3 項違規。

**操作步驟**：
1. **修正命名與魔術數字**：
   - 將變數 `Total_Swaps` 改為小駝峰命名 `totalSwaps`。
   - 將上限數字 `5000` 提取為常數：
     ```java
     private static final int MAX_DATA_LENGTH = 5_000;
     ```
2. **修正字串比對與括號規範**：
   - 將 `mode == "DESC"` 替換為 `"DESC".equalsIgnoreCase(mode)`。
   - 補齊 `needSwap` 判斷區塊的大括號 `{}`。
3. **優化迴圈內部的記憶體配置**：
   - 移除內層迴圈不必要的 `Integer.valueOf(...)` 物件包裝，直接比對基本型別 `data[j]` 與 `data[j + 1]`。
4. **補齊 Javadoc 註解**：
   - 為公開方法 `bubbleSort` 撰寫符合規範的 Javadoc。
5. **再次驗證**：
   - 重新執行 `mvn pmd:check`，確認警告數量顯著下降。
   - 執行單元測試 `mvn test -Dtest="BubbleSortTest"`，確保重構後的排序功能依然 100% 正確！

---

### Lab 03: 客製化規則集 (Customize Ruleset)

**目標**：學會根據專案需求在 `ruleset.xml` 中調整門檻或排除特定規則。

1. 開啟 `src/main/resources/pmd/ruleset.xml`。
2. **調整註解長度門檻**：
   若團隊偏好較詳盡的 Javadoc，可將 `CommentSize` 的 `maxLines` 調高至 10：
   ```xml
   <rule ref="category/java/documentation.xml/CommentSize">
       <properties>
           <property name="maxLines" value="10" />
           <property name="maxLineLength" value="90" />
       </properties>
   </rule>
   ```
3. **排除特定規則**：
   若專案暫時不需要強求所有局部變數皆宣告 `final`，可在 `codestyle.xml` 或對應分類中排除：
   ```xml
   <rule ref="category/java/codestyle.xml">
       <exclude name="LocalVariableCouldBeFinal"/>
       <exclude name="MethodArgumentCouldBeFinal"/>
   </rule>
   ```
4. 儲存檔案後再次執行 `mvn pmd:check`，觀察警告訊息的變化。

---

### Lab 04: 合理壓制違規 (Suppress Violation)

**目標**：針對無法依常規重構但有其合理設計理由的程式碼，學會局部壓制警告。

以 `BubbleSortExercise.java` 中的 `manualCopy` 方法為例，PMD 會報告 `AvoidArrayLoops`（建議使用 `System.arraycopy`）。若因演算法示範需要手動迴圈：

1. **方法層級壓制 (Annotation)**：
   在方法宣告上方加上：
   ```java
   @SuppressWarnings("PMD.AvoidArrayLoops")
   public int[] manualCopy(final int[] source) {
       ...
   }
   ```
2. **行層級壓制 (NOPMD Comment)**：
   在迴圈行末加上 `// NOPMD` 並註明原因：
   ```java
   for (int i = 0; i < source.length; i++) { // NOPMD - 教學展示手動複製迴圈
       result[i] = source[i];
   }
   ```
3. 執行 `mvn pmd:check`，確認該條規則不再被列為違規。