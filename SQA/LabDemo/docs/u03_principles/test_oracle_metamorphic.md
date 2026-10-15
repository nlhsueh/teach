# 實驗 3-2：Test Oracle 破局實驗 —— 從 assertEquals 失敗到變質關係 (The Oracle Sandbox)

> 💡 **單元對應**：Ch03 軟體測試基礎 —— **3.5 測試全景 3W2H 與 AI 時代 Test Oracle 難題破解**；並為 **Ch05 黑箱測試與屬性基礎測試 (PBT/MT)** 奠定實作基礎。

---

## 🎯 實驗目標 (Objectives)

1. **體會「測試預言機難題 (The Test Oracle Problem)」**：
   理解為何在面對複雜網路圖學、科學計算、搜尋推薦或 AI 系統時，傳統的 `assertEquals(expected, actual)` 斷言會完全失靈。
2. **掌握變質測試 (Metamorphic Testing, MT) 的核心哲學**：
   體會陳振宇 (T.Y. Chen 1998) 教授提出的革命性思想：**「當無法得知單次執行的絕對標準答案時，轉為檢驗多次執行之間的輸入輸出相對關係 (Metamorphic Relations, MRs)。」**
3. **動手執行與設計變質斷言**：
   在實際的導航路網系統 (`RoutePlanner`) 中，運用對稱性、比例縮放、三角不等式與獨立抗擾動性等 4 大經典 MR 模式，無需手算答案即可自動抓出隱藏缺陷！

---

## 🧩 為什麼 assertEquals 遇到複雜系統會崩潰？

在傳統單元測試教學中，我們總是習慣給定一個簡單輸入，然後手算預期結果：

```java
// 在 3 個節點的超迷你三角形路網中：
// A --(10)--> B --(15)--> C
// A ---------(30)--------> C
// 人類一眼就能算出：最短路徑為 10 + 15 = 25
assertEquals(25.0, planner.findShortestDistance(graph, "A", "C"));
```

然而，在真實世界的工程情境中：
* 如果路網包含了全台灣 12 個城市、20 條以上高快速道路、省道與山線交錯？
* 如果輸入是自駕車相機拍攝的百萬像素即時路況影像？
* 如果輸入是巨量資料庫搜尋或 LLM 生成的 500 字摘要？

**人類專家根本不可能預先算出精確的唯一解答！**  
如果你算不出 `expected`，你的單元測試該如何寫下去？這就是困擾軟體測試界數十年的 **Test Oracle Problem**。

---

## 🔄 變質測試的三步執行迴圈

變質測試提出了一個精妙的解法：

```text
    【原始輸入 x】 ───────────────> 【待測系統 f】 ───────────────> 【原始輸出 y】
         │                                                            │
         │ (變質變換 Transform)                                       │ (MR 變質關係判定)
         ▼                                                            ▼
    【變換輸入 x'】 ──────────────> 【待測系統 f】 ───────────────> 【後續輸出 y'】
                                                                 R(x, x', y, y') 是否成立？
```

只要我們能找到系統演算法在數學或邏輯上**必然滿足的相對不變量**，只要該關係被打破，就 **100% 證明演算法內部邏輯存在 Bug**！

---

## 💻 專案實作程式碼解析

本實驗已在專案中建立完整程式碼：
* 待測演算法：[`src/main/java/u03_principles/RoutePlanner.java`](../../src/main/java/u03_principles/RoutePlanner.java)
* 變質測試沙盒：[`src/test/java/u03_principles/OracleSandboxTest.java`](../../src/test/java/u03_principles/OracleSandboxTest.java)

### 🏛️ 四大經典變質關係模式實戰

#### 1. MR-1：對稱與等價性 (Symmetry Invariance)
* **哲學**：在無向路網圖中，由台北出發到高雄的最短距離，必然嚴格等於由高雄出發到台北的最短距離！
* **代碼落地**：
  ```java
  double forwardDist = planner.findShortestDistance(graph, "Taipei", "Kaohsiung");
  double backwardDist = planner.findShortestDistance(graph, "Kaohsiung", "Taipei");

  assertEquals(forwardDist, backwardDist, 0.0001, "變質關係違規：雙向路徑不對稱！");
  ```

#### 2. MR-2：比例縮放一致性 (Scaling Consistency)
* **哲學**：若將全台灣所有道路權重同乘以 $k$ 倍（例如公里換算英哩），算出的最短距離必然精準放大 $k$ 倍！
* **代碼落地**：
  ```java
  double baseDist = planner.findShortestDistance(graph, "Taipei", "Pingtung");
  RoadGraph scaledGraph = graph.scaleWeights(2.0); // 放大 2 倍
  double scaledDist = planner.findShortestDistance(scaledGraph, "Taipei", "Pingtung");

  assertEquals(baseDist * 2.0, scaledDist, 0.001, "變質關係違規：未等比例縮放！");
  ```

#### 3. MR-3：中繼點三角不等式 (Triangle Inequality)
* **哲學**：由台北直達高雄的最短路徑，絕對不會比「台北到台中 + 台中到高雄」還要長！
* **代碼落地**：
  ```java
  double distAB = planner.findShortestDistance(graph, "Taipei", "Kaohsiung");
  double distAC = planner.findShortestDistance(graph, "Taipei", "Taichung");
  double distCB = planner.findShortestDistance(graph, "Taichung", "Kaohsiung");

  assertTrue(distAB <= (distAC + distCB) + 0.0001, "變質關係違規：違反三角不等式！");
  ```

#### 4. MR-4：無關獨立節點抗擾動性 (Irrelevant Perturbation)
* **哲學**：在路網中加入一個尚未連通的孤島節點（如澎湖 `Penghu_Isolated`），本島任何兩點之間的最短距離絕對不可受任何影響！
* **代碼落地**：
  ```java
  RoadGraph perturbedGraph = graph.copy();
  perturbedGraph.addNode("Penghu_Isolated"); // 加入獨立孤島節點

  double perturbedDist = planner.findShortestDistance(perturbedGraph, "Taipei", "Hualien");
  assertEquals(originalDist, perturbedDist, 0.0001, "變質關係違規：孤立節點干擾了路徑！");
  ```

---

## 🏃 實驗動手跑 (Run the Lab)

請在終端機執行 Maven 指定測試指令，或在 IDE 中直接執行：

```bash
# 只執行 Unit 03 的變質測試沙盒
mvn test -Dtest="u03_principles.OracleSandboxTest"
```

你將會看到 JUnit 5 迅速通過 8 組測試案例（包含縮放因子的參數化測試），且耗時不超過 0.05 秒！

---

## 🚀 進階挑戰任務 (Self-Challenge)

嘗試在 `OracleSandboxTest.java` 中新增第 5 個變質關係：**「加邊或縮減權重之單調性 (Monotonicity)」**：

> **MR-5 單調性挑戰**：
> 如果我們在既有的路網中，額外開闢一條「台北直達高雄的新高鐵路線」（權重設為更小的值，例如 120.0），那麼新路網計算出的台北到高雄最短距離，必然 **小於等於 ($\le$)** 原有的最短距離，絕對不可能反而變長！

請試著寫出這個測試方法，並體會變質關係是如何全自動保護我們的演算法不發生回歸缺陷！
