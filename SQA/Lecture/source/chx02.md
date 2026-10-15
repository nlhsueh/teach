# Chapter X02: SQA 核心挑戰 10 題限時搶答賽 (Game Battle)

<!-- id: sqa-x02-battle-game -->
#### 🙋 **課堂遊戲挑戰 (Game)：SQA 核心挑戰 10 題限時搶答賽 (Ch03理論與Ch02實戰除錯)**

**第 1 題：AI 生成測試的假綠燈盲區**

某工程師請 AI 生成利息公式並讓同一個 AI 寫單元測試，100% 綠燈卻被主管機關判定違法。主要反映何種測試盲點？
A) 測試執行次數不夠多，只要重複跑十萬次就能發現違法  
B) 陷入「殺蟲劑悖論（自我印證盲區）」與「無錯謬誤（符合語法但不符真實法規需求）」  
C) 只要覆蓋率達到 100%，系統必然合規  
D) 作業系統與硬體浮點數運算器的物理缺陷

<details>
<summary>點擊查看答案與解析</summary>

**正確答案**：B
**解析**：AI 依據自身認知與相同偏誤生成程式碼與測試，導致測試與程式「錯在同一個盲區」，產生自我印證的假綠燈；且無語法錯誤不等於滿足法規與業務真實需求（無錯謬誤 Absence-of-errors fallacy）。
</details>

---

**第 2 題：冰淇淋甜筒反模式與品質雙向度**

醫療 App 依據過期指引實作並通過所有單元測試，醫師卻抱怨完全不合看診流程。這反映了？
A) 底層單元測試過多，應立即刪除  
B) 通過了 Verification（正確地造出軟體），但在 Validation（造出正確的軟體）上徹底失敗  
C) 只要將測試改用 Python 執行即可解決  
D) 醫師的抱怨屬於編譯時期語法錯誤

<details>
<summary>點擊查看答案與解析</summary>

**正確答案**：B
**解析**：測試金字塔應以「單元測試為厚實基底」，頂層 UI 測試過多即為冰淇淋甜筒；且 Verification 是「是否正確地建造軟體」，Validation 則是「是否建造了正確的軟體」。
</details>

---

**第 3 題：V 模型雙向追溯對應**

在標準 V 開發模型中，依據「高階架構設計 (ADD)」模組介面，所對應執行的測試層級為何？
A) 單元測試 (Unit Testing)  
B) 整合測試 (Integration Testing)  
C) 驗收測試 (Acceptance Testing)  
D) 靜態程式碼檢視 (Code Review)

<details>
<summary>點擊查看答案與解析</summary>

**正確答案**：B
**解析**：V 模型的對稱關係為：需求分析 ➔ 驗收測試；高階架構設計 ➔ 整合測試；詳細元件設計 ➔ 單元測試。
</details>

---

**第 4 題：軟體行為文氏圖的致命未知**

行為文氏圖中落在 P \ (S ∪ T)（程式有寫但規格未提、測試未測）的區域代表什麼？
A) 系統完全符合規格的最佳實踐  
B) 存在未經規格定義與測試防護的非預期隱藏行為（如後門或幽靈邏輯），構成重大風險  
C) 代表單元測試覆蓋率達 100%  
D) 測試案例不需定義預期結果

<details>
<summary>點擊查看答案與解析</summary>

**正確答案**：B
**解析**：程式包含規格與測試以外的行為，代表存在開發者的私自實作、遺留代碼或惡意邏輯，是品質與資安最危險的地帶。
</details>

---

**第 5 題：Test Oracle 難題與變形測試**

自駕車辨識等面臨 Test Oracle 難題時，旋轉影像 10 度檢驗輸出是否維持不變量，屬於哪種技術？
A) 聘請千人手動核對  
B) 變形測試 (Metamorphic Testing)  
C) 將 CI 斷言全部改為 pass  
D) 永遠只測試空字串

<details>
<summary>點擊查看答案與解析</summary>

**正確答案**：B
**解析**：變形測試不依賴絕對輸出值，而是透過「變形關係（Metamorphic Relation）」，檢驗輸入變換後輸出是否保持預期的相對性質或不變量。
</details>

---

**第 6 題：中斷點暫停時機與變數狀態**

於 int a = 100; a = a + 1; 的第二行設中斷點，除錯器高亮停在該行時，a 的值是多少？
A) 100 (中斷點在該行執行前暫停)  
B) 101 (已運算完成)  
C) 0  
D) 變數尚未初始化

<details>
<summary>點擊查看答案與解析</summary>

**正確答案**：A
**解析**：中斷點的機制是「Pause before execution」，停在該行時尚未執行賦值運算，因此 a 仍為前一行的 100。
</details>

---

**第 7 題：單步追蹤操作 (Step Into vs Step Over)**

除錯時若想「進入被呼叫函式內部逐行追蹤其邏輯」，應在工具列點擊？
A) Step Over (單步跳過)  
B) Step Into (單步進入)  
C) Step Out (單步跳出)  
D) Resume (繼續執行)

<details>
<summary>點擊查看答案與解析</summary>

**正確答案**：B
**解析**：Step Into 會深入子函式內部逐行追蹤；Step Over 則是將子函式當成一整個原子步驟在背景執行完畢並停在下一行。
</details>

---

**第 8 題：整數除法截斷陷阱 (Integer Division)**

程式碼 double area = Math.PI * Math.pow(diameter / 2, 2); 輸入 5 算出的半徑卻是 2.0，原因為？
Math) pow 不支援整數運算  
A) diameter / 2 屬於整數除法，小數被強制截斷捨去  
Math) PI 精準度不足  
B) Scanner 無法讀取奇數

<details>
<summary>點擊查看答案與解析</summary>

**正確答案**：B
**解析**：Java 中 int / int 結果強制為 int，5 / 2 會被截斷為 2，代入計算面積產生重大偏差。應寫成 diameter / 2.0。
</details>

---

**第 9 題：並發 Check-Then-Act 與 TOCTOU 漏洞**

餘額檢查寫在 synchronized 外面（if (balance >= amount) { synchronized ... }），為何並發時會扣成負數？
A) synchronized 無法鎖定變數  
B) 多執行緒可同時通過鎖外的餘額檢查，隨後依序進鎖扣款（TOCTOU 漏洞）  
C) JVM 會自動省略外層 if  
D) synchronized 不能以區塊形式使用

<details>
<summary>點擊查看答案與解析</summary>

**正確答案**：B
**解析**：Check-Then-Act 必須具備原子性。檢查與修改必須同時包在同一個 synchronized 臨界區段內（先鎖定 ➔ 再檢查 ➔ 後修改），否則檢查時為真、使用時條件早已改變。
</details>

---

**第 10 題：金融數值精度防禦**

金融交易系統中嚴禁使用 double 進行結算，其品質防禦方案為何？
A) double 無法表示負數  
B) IEEE 754 浮點數有截斷偏差；應使用 BigDecimal 或整數最小貨幣單位 long 儲存  
C) 浮點數運算會導致 CPU 當機  
D) 資料庫完全無法儲存小數

<details>
<summary>點擊查看答案與解析</summary>

**正確答案**：B
**解析**：0.1 在二進位中為無限循環小數，以 IEEE 754 儲存必定有精度截斷誤差。長期大量交易累加會導致對帳不平。正確防禦是使用 BigDecimal(String) 或以最小貨幣單位整數 long 運算。
</details>

[課堂互動](https://nlhsueh.github.io/nickedupocket/#/student/sqa-x02-battle-game)

<img src="../../img/chX02/sqa-x02-battle-game.png" width="120">
