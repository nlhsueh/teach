# PMD Java 規則手冊 (Java Rules Reference)

PMD（Programming Mistake Detector）是一款靜態程式碼分析工具，用於檢測原始程式碼中的潛在問題。PMD 提供了一組豐富的預定義規則集，涵蓋最佳實踐、程式碼風格、設計、文件與潛在錯誤。

> 🔗 官方完整規則手冊：[PMD Java Rules Documentation](https://docs.pmd-code.org/latest/pmd_rules_java.html)  
> 🔙 返回主單元說明：[PMD 靜態分析與配置實務 (pmd.md)](./pmd.md)

---

## 1. Best Practices（最佳實踐）

建議使用更安全、高效且符合現代 Java 慣例的方法來編寫程式碼。

### 常見規則與壞味道說明

- **`UseEqualsToCompareStrings`** – 避免使用 `==` 比較字串  
  *Bad Smell:* 直接用 `==` 比較字串比的是記憶體位址而非內容，容易導致不可預期的錯誤，應改用 `.equals()`。

- **`UseTryWithResources`** – 使用 `try-with-resources` 管理資源  
  *Bad Smell:* 手動在 `finally` 中關閉串流時，若發生例外可能導致資源洩漏，應改用自動管理資源語法。

- **`EmptyCatchBlock`** – 避免空的 `catch` 區塊  
  *Bad Smell:* 空的 `catch` 區塊會吞掉異常，導致錯誤難以發現和排查。

- **`ReturnFromFinallyBlock`** – 不要在 `finally` 區塊內使用 `return`  
  *Bad Smell:* 在 `finally` 區塊中 `return` 會覆蓋 `try` 或 `catch` 中的返回值或異常，導致不可預測的行為。

- **`FinalFieldCouldBeStatic`** – 使用 `final` 修飾不可變變數  
  *Bad Smell:* 若變數在初始化後不應變更，應使用 `final` 來提高可讀性和安全性。

- **`AvoidUsingStaticFields`** – 避免過度使用靜態變數  
  *Bad Smell:* 過多的靜態變數可能導致非預期的共享狀態問題，影響可維護性與執行緒安全。

- **`UseIsEmptyOnCollections`** – 使用 `isEmpty()` 而非 `size() == 0` 來檢查集合是否為空  
  *Bad Smell:* `isEmpty()` 更具可讀性，且某些特定集合的效能優於 `size() == 0`。

- **`DoNotIgnoreInterruptedException`** – 不要忽略 `InterruptedException`  
  *Bad Smell:* 在多執行緒環境下，應適當處理或重設中斷狀態，確保執行緒可以正確響應中斷信號。

- **`AvoidInstantiatingObjectsInLoops`** – 避免在迴圈中創建不必要的物件  
  *Bad Smell:* 在迴圈內部頻繁創建物件會導致不必要的記憶體分配與 GC 負擔，應在迴圈外部初始化以提高效能。

- **`AbstractClassWithoutAbstractMethod`** – 抽象類中沒有抽象方法  
  *Bad Smell:* 若類別沒有任何抽象方法，應考慮是否該設計為普通類別，而非抽象類。

- **`AvoidDuplicateLiterals`** – 避免重複的字面值  
  *Bad Smell:* 多次重複相同的字串或數值會降低可維護性，應將其提取為命名常數。

```java
public class OrderProcessor {
    private static final String PENDING = "PENDING";
    private static final String SHIPPED = "SHIPPED";
    private static final String DELIVERED = "DELIVERED";

    public void processOrder(String status) {
        if (PENDING.equals(status)) {
            System.out.println("Order is still pending.");
        } else if (SHIPPED.equals(status)) {
            System.out.println("Order has been shipped.");
        } else if (DELIVERED.equals(status)) {
            System.out.println("Order has been delivered.");
        }
    }
}
```

- **`GodClass`** – 避免「上帝類」  
  *Bad Smell:* 單個類別擁有過多的責任，應拆分為多個類以提高可讀性與可維護性。

- **`TooManyMethods`** – 避免類別中方法數量過多  
  *Bad Smell:* 當類別的方法數量過多時，可能意味著職責過於龐雜，應考慮拆分。

- **`ExcessiveParameterList`** – 避免過多的參數列表  
  *Bad Smell:* 方法參數過多（如超過 4-5 個）會降低可讀性，應考慮使用 Parameter Object 封裝。

- **`AvoidDeeplyNestedIfStmts`** – 避免過深的巢狀 `if` 語句  
  *Bad Smell:* 多層巢狀 `if` 會大幅增加認知負荷，應考慮提早返回（Early Return）或 Guard Clauses。

- **`LawOfDemeter`** – 遵循迪米特法則（Law of Demeter, LoD）  
  *Bad Smell:* 物件不應直接存取其他物件的方法鏈（如 `a.getB().getC().doAction()`），應降低耦合度。

- **`UnusedPrivateMethod`** – 移除未使用的私有方法  
  *Bad Smell:* 私有方法若未被使用，應刪除以減少無效程式碼複雜度。

- **`CyclomaticComplexity`** – 避免過高的循環複雜度  
  *Bad Smell:* 當函式內的決策點（如 `if`、`for`、`switch`）過多時，應拆分成更小的方法。

- **`AvoidReassigningParameters`** – 避免修改方法參數的值  
  *Bad Smell:* 方法參數應視為不可變的輸入，若需變更應指派給新的區域變數。

---

## 2. Code Style（程式碼風格）

強制團隊遵循統一的程式碼風格，提升團隊協作與程式碼審查的流暢度。

- **`UnnecessarySemicolon`** – 避免不必要的分號  
  *Bad Smell:* 在類別或方法內部出現額外的孤立分號，應移除以保持整潔。

- **`UnusedImports`** – 移除未使用的 `import`  
  *Bad Smell:* 未使用的匯入會讓程式碼顯得雜亂，降低可讀性。

- **`TooManyStaticImports`** – 避免過多的靜態匯入  
  *Bad Smell:* 使用過多 `import static` 可能造成命名衝突或語意混淆，應僅匯入核心必要方法。

- **`MethodNamingConventions`** – 方法命名應符合規範  
  *Bad Smell:* 方法名稱應使用小駝峰命名法（camelCase），如 `calculateTotal()`，避免底線或大寫開頭。

- **`ClassNamingConventions`** – 類名應遵循 Pascal 命名法  
  *Bad Smell:* 類名應使用大寫開頭的駝峰命名，如 `OrderProcessor`。

- **`VariableNamingConventions`** – 區域變數命名應符合規範  
  *Bad Smell:* 變數名稱應使用小寫開頭的駝峰命名，如 `orderCount`。

- **`FieldNamingConventions`** – 類別成員變數應遵循小駝峰命名法  
  *Bad Smell:* `private int TotalAmount;` 應改為 `private int totalAmount;`。

- **`ConstantNamingConventions`** – 常數應使用全大寫命名，並以 `_` 分隔  
  *Bad Smell:* `final int maxRetries = 5;` 應改為 `final int MAX_RETRIES = 5;`。

- **`AvoidTrailingWhitespace`** – 移除行尾多餘空白  
  *Bad Smell:* 行尾的多餘空白會污染 Git Diff 審查。

- **`LineLength`** – 避免單行長度過長（超過 80 或 120 字元）  
  *Bad Smell:* 過長的單行在多分割視窗或代碼審查時需要橫向滾動，影響閱讀體驗。

- **`ConsecutiveBlankLines`** – 避免過多的連續空行  
  *Bad Smell:* 連續多行空白會讓程式碼版面鬆散，通常限制最多 1 行空行。

- **`AtLeastOneConstructor`** – 類別應該有至少一個明確的建構子  
  *Bad Smell:* 明確定義建構子能提高類別實例化時的語意清晰度。

- **`UseBraces`** – 使用 `{}` 包裹條件與迴圈語句  
  *Bad Smell:* 單行 `if (condition) doAction();` 容易在多人編輯時產生縮排錯誤，應始終包裹 `{}`：
  ```java
  if (condition) {
      doSomething();
  }
  ```

- **`SwitchStmtsShouldHaveDefault`** – `switch` 陳述式應該具備 `default` 分支  
  *Bad Smell:* 缺少 `default` 分支可能導致未涵蓋的分支靜默穿透。

- **`AvoidMagicNumbers`** – 避免未說明的魔術數字  
  *Bad Smell:* `if (x > 1000)` 應將 `1000` 抽取為具名常數 `MAX_LIMIT`。

- **`NoFinalizer`** – 避免使用 `finalize()` 方法  
  *Bad Smell:* `finalize()` 在現代 Java 中已被廢棄，應使用 `AutoCloseable` 與 `try-with-resources`。

---

## 3. Design（設計原則）

識別不良的架構設計與物件導向壞味道，提高程式碼的可維護性、測試性與擴展性。

- **`GodClass` / `LargeClass`** – 避免「上帝類」與過大的類別  
  *Bad Smell:* 類別過大通常意味著職責過多，違背單一職責原則（SRP），應拆分為小組件。

- **`FeatureEnvy`** – 依戀情結（避免過度存取其他類別的屬性）  
  *Bad Smell:* 若類別 A 頻繁操作類別 B 的內部資料，該邏輯通常應該移入類別 B。

- **`DataClass`** – 避免貧血的純資料類  
  *Bad Smell:* 類別若只包含 getter/setter 而無任何領域行為，應評估是否採用 Java Record 或賦予適當行為。

- **`SwitchStatement`** – 避免以龐大的 `switch` 取代多型  
  *Bad Smell:* 重複出現的多分支判斷通常應重構為策略模式（Strategy）或多型（Polymorphism）。

- **`RefusedBequest`** – 避免拒絕繼承（子類別覆寫父類別卻空實作）  
  *Bad Smell:* 子類別不使用繼承來的方法，意味著繼承關係不成立，應改用組合（Composition）。

- **`CouplingBetweenObjects` / `HighFanOut`** – 避免高耦合與過度依賴  
  *Bad Smell:* 類別依賴過多的外部型別會導致單元測試難以 Mock、修改時牽一髮動全身。

- **`AvoidStaticMethods`** – 避免過度使用靜態方法  
  *Bad Smell:* 靜態方法無法被多型覆寫，容易造成強烈依賴並增加單元測試隔離的困難度。

---

## 4. Documentation（文件註解）

確保重要類別與公用 API 具備適當且格式合規的 Javadoc。

- **`CommentRequired`** – 關鍵類別與公開方法應提供註解  
  *Bad Smell:* 公開 API 缺少說明，使其他開發者必須閱讀原始碼才能猜測使用方式。

- **`MissingJavadocMethod`** – 公開方法應有 Javadoc 標籤說明用途、參數及回傳值：
  ```java
  /**
   * 計算訂單折扣後總金額。
   *
   * @param price 商品原價
   * @param discount 折扣比率 (0.0 ~ 1.0)
   * @return 折扣後金額
   */
  public double calculateTotal(double price, double discount) { ... }
  ```

- **`CommentSize`** – 註解應保持適當長度與行數  
  *Bad Smell:* 註解過長或行數過多可能意味著程式碼本身不夠直觀，或塞入了不必要的廢話。

- **`TodoComment`** – 避免遺留未處理的 `TODO` 註解  
  *Bad Smell:* 程式碼中長期殘留的 `TODO` 會失去警示作用，應及時實作或轉為 Issue 追蹤。

---

## 5. Error Prone（防範潛在缺陷）

偵測容易引發執行時期錯誤（Runtime Exception）或資源洩漏的危險寫法。

- **`AvoidCatchingGenericException`** – 避免過度使用 `catch (Exception e)`  
  *Bad Smell:* 捕捉所有例外會掩蓋特定型別的非預期錯誤，應明確捕捉特定子類別。

- **`DoNotThrowExceptionInFinally`** – 避免在 `finally` 中拋出例外  
  *Bad Smell:* `finally` 中的例外會吃掉並覆蓋 `try` 區塊中的主要錯誤原因。

- **`NullAssignment`** – 避免明確指定變數為 `null`  
  *Bad Smell:* 頻繁的 `null` 賦值容易埋下 `NullPointerException` 隱患，建議評估 `Optional` 或空物件模式。

- **`AvoidThrowingNullPointerException`** – 不要手動拋出 `NullPointerException`  
  *Bad Smell:* NPE 代表程式內部未處理好的缺陷，手動拋出應使用 `IllegalArgumentException` 或自訂例外。

- **`AvoidHardCodedPasswords`** – 避免硬編碼機密資訊  
  *Bad Smell:* 密碼與金鑰絕對不可明文寫在程式碼中，應透過環境變數或安全配置載入。
