---
marp: true
theme: default
paginate: true
size: 16:9
header: '使用者體驗設計與 AI (UX & AI) — 觀念檢核題庫標準答案與解析'
footer: '逢甲大學 資訊工程學系 薛念林 教授'
style: |
  section {
    font-family: 'PingFang TC', 'Microsoft JhengHei', 'Noto Sans TC', sans-serif;
    padding: 36px 44px;
    background-color: #f8fafc;
    color: #1e293b;
    font-size: 20px;
    line-height: 1.5;
  }
  h1 {
    color: #1e3a8a;
    font-size: 32px;
    border-bottom: 3px solid #3b82f6;
    padding-bottom: 8px;
    margin-top: 0;
    margin-bottom: 14px;
  }
  h2 {
    color: #1e40af;
    font-size: 26px;
    margin-top: 0;
    margin-bottom: 12px;
    border-bottom: 2px solid #93c5fd;
    padding-bottom: 6px;
  }
  h3 {
    color: #0f172a;
    font-size: 21px;
    margin-top: 0;
    margin-bottom: 8px;
  }
  .card {
    background: white;
    padding: 14px 18px;
    border-radius: 8px;
    box-shadow: 0 4px 6px -1px rgba(0,0,0,0.06);
    border: 1px solid #e2e8f0;
    margin-bottom: 12px;
  }
  .answer-box {
    background: #ecfdf5;
    border: 2px solid #10b981;
    border-radius: 8px;
    padding: 12px 16px;
    margin-top: 10px;
  }
  .answer-badge {
    display: inline-block;
    background: #059669;
    color: white;
    font-weight: bold;
    padding: 2px 10px;
    border-radius: 4px;
    margin-right: 8px;
  }
  .lead {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    text-align: center;
    background: linear-gradient(135deg, #1e3a8a 0%, #1e40af 100%);
    color: white;
  }
  .lead h1 {
    color: white;
    font-size: 42px;
    border-bottom: 4px solid #60a5fa;
  }
  .lead h2 {
    color: #93c5fd;
    font-size: 24px;
    border-bottom: none;
  }
---

<!-- _class: lead -->
# 使用者體驗設計與 AI (UX & AI)
## 觀念檢核 (CCQ) 標準答案與深度解析手冊

**薛念林 教授**
逢甲大學 資訊工程學系

<span style="font-size: 15px; color: #cbd5e1; margin-top: 20px; display: block;">涵蓋 Part 1 ~ Part 4 所有課堂是非題與情境選擇題之標準答案、考核目標與設計心理學解析</span>

---

# 📘 Part 1: 使用者體驗設計導論 — 觀念檢核答案

<div class="card">

### 是非題 1：UX 和 UI 的差異
* **題目** ：對於使用者而言，UX 決定了系統是否「好用」，而 UI 則決定了系統是否「好看」。兩者相輔相成，缺一不可，共同構築了最終的使用者體驗。請判斷上述說法是否正確？
* <div class="answer-box">
  <span class="answer-badge">標準答案：否 (X)</span> <b>容易落入「重外觀、輕架構」的簡化迷思</b>
  </div>
* 💡 **深度解析** ：
  1. **UI 不僅僅是「好看」** ：UI (User Interface) 涵蓋資訊架構排版、視覺階層、元件可操作性 (Affordance) 與狀態反饋，並非單純的美工配色。
  2. **UX 不只是「好用」** ：UX (User Experience) 是使用者在使用產品全旅程中的 **主觀心理認知、情感共鳴、滿意度與價值實現** 。一個完全好用但令人枯燥、失去信任的系統，依然稱不上優秀的 UX。

</div>

---

# 📘 Part 1: 使用者體驗設計導論 — 觀念檢核答案

<div class="card">

### 是非題 2：效能問題與 UX 的關聯
* **題目** ：登入系統的時間過長，是屬於系統架構和效能的問題，與 UX 無關。請參考 ISO 9241-11 對 UX 的定義，判斷上述說法是否正確？
* <div class="answer-box">
  <span class="answer-badge">標準答案：否 (X)</span> <b>效能缺陷直接劣化使用者感知體驗</b>
  </div>
* 💡 **深度解析** ：
  1. **ISO 9241-11 的定義** ：可用性包含 **有效性 (Effectiveness)** 、 **效率 (Efficiency)** 與 **滿意度 (Satisfaction)** 。
  2. 登入過慢直接破壞了操作效率，並引發等待焦慮與系統當機的懷疑（滿意度驟降）。
  3. **工程 vs. 體驗** ：架構效能是底層實作手段，而使用者感受到的等待時間與反饋則是核心的 UX 範疇。

</div>

---

# 📘 Part 1: 使用者體驗設計導論 — 觀念檢核答案

<div class="card">

### 選擇題：UX 標準核心流程辨析
* **題目** ：以下哪個活動 **不算** 在 UX 的標準流程中？
  * (A) 了解使用者的痛點 ｜ (B) 進行畫面的設計與確認 ｜ (C) 進行市場的分析與調查
  * (D) 開發一個雛形進行試用 ｜ (E) 對系統進行壓力測試
* <div class="answer-box">
  <span class="answer-badge">標準答案：(E) 對系統進行壓力測試</span> <b>屬於系統工程測試，非以人為本的 UX 活動</b>
  </div>
* 💡 **深度解析** ：
  * **UX 5 大標準流程** ：① 探索 (A/C) ➔ ② 分析痛點 ➔ ③ 構思 ➔ ④ 設計與原型 (B/D) ➔ ⑤ 可用性測試。
  * **(E) 壓力測試 (Stress Testing)** ：屬於後端非功能性工程驗證（測試伺服器並行承載極限），而非評估使用者認知與操作易用性的 UX 設計活動。

</div>

---

# 📗 Part 2: 尼爾森 10 大原則 — 觀念檢核答案

<div class="card">

### 是非題 1：錯誤預防 (NS05) 的邊界與警示疲勞
* **題目** ：為了徹底落實錯誤預防，系統在使用者執行「任何」可能修改資料的操作（包括編輯個人暱稱、切換深色模式）時，都強制彈出確認視窗要求點擊「確定修改」，這是兼顧安全性與可用性的最佳實踐？
* <div class="answer-box">
  <span class="answer-badge">標準答案：否 (X)</span> <b>過度防呆會誘發「警示疲勞 (Alert Fatigue)」</b>
  </div>
* 💡 **深度解析** ：
  1. 無差別的確認彈窗會大幅破壞 **NS03 (使用者控制權)** 與 **NS07 (使用效率)** ，讓用戶養成不看內容直接按「確定」的麻木習慣。
  2. **最佳實踐為風險分級** ：低風險操作採用「自動儲存 + Undo 復原機制」；唯有高風險、不可逆操作（如刪除帳號、格式化資料）才需二次阻斷確認。

</div>

---

# 📗 Part 2: 尼爾森 10 大原則 — 觀念檢核答案

<div class="card">

### 是非題 2：簡潔設計 (NS08) 與跨裝置可見性
* **題目** ：為了實現極致簡潔的視覺體驗，將資料表格中的操作按鈕（編輯/刪除/下載）全數隱藏，改為僅在使用者將滑鼠 Hover 懸停於該列時才浮現，這在所有裝置與情境下都是最推薦的做法？
* <div class="answer-box">
  <span class="answer-badge">標準答案：否 (X)</span> <b>在行動端/觸控螢幕完全失效</b>
  </div>
* 💡 **深度解析** ：
  1. **觸控裝置無 Hover 狀態** ：在手機或平板上，缺乏滑鼠懸停機制，隱藏按鈕將導致功能徹底無法觸發。
  2. **可發現性 (Discoverability) 降低** ：過度隱藏核心操作違反了 **NS06 (易於識別而非記憶)** ，新手使用者必須四處盲目滑動探索才能找到操作入口。

</div>

---

# 📗 Part 2: 尼爾森 10 大原則 — 觀念檢核答案

<div class="card">

### 選擇題 1：信用卡輸入欄位優化 (NS05 + NS06)
* **題目** ：電商結帳頁在輸入信用卡時，自動依卡號長度在每 4 碼插入空格（`4111 2222 3333 4444`），並在辨識出卡別後即時於右側點亮 Visa 圖示。這項設計最直接體現了哪兩項原則的結合？
* <div class="answer-box">
  <span class="answer-badge">標準答案：(A) NS05 (錯誤預防) 與 NS06 (易於識別而非記憶)</span>
  </div>
* 💡 **深度解析** ：
  * **NS05 錯誤預防** ：利用格式化分塊（Chunking），將 16 位長數字拆解為 4 位一組，顯著降低使用者抄寫與肉眼校對時的看錯與輸錯機率。
  * **NS06 易於識別而非記憶** ：由系統自動辨識卡號前綴並即時點亮品牌 Logo（如 Visa / MasterCard），使用者一眼即可確認是否拿對卡片，無需回憶卡種規則。

</div>

---

# 📗 Part 2: 尼爾森 10 大原則 — 觀念檢核答案

<div class="card">

### 選擇題 2：Gmail 遺漏附件攔截 (NS05 + NS03)
* **題目** ：使用者在 Gmail 內文提及「如附件企劃書」，但在未附加檔案時點擊「傳送」，系統即時攔截並提示：「您提及了附件但未附加檔案，是否仍要傳送？」，並提供「取消」與「直接傳送」。這最直接體現了哪兩項原則的結合？
* <div class="answer-box">
  <span class="answer-badge">標準答案：(A) NS05 (錯誤預防) 與 NS03 (使用者控制與自由)</span>
  </div>
* 💡 **深度解析** ：
  * **NS05 錯誤預防** ：系統透過內文語意分析，在使用者按下送出且造成不可逆錯誤前「主動攔截」，防患於未然。
  * **NS03 使用者控制與自由** ：系統並非粗暴強行鎖死傳送功能，而是提供「取消（回編輯區）」與「直接傳送（確認無誤仍可送出）」兩個明確出口，尊重使用者的最終自主權。

</div>

---

# 📙 Part 3: AI for UX — 觀念檢核答案

<div class="card">

### 是非題：API 例外處理的使用者介面感知
* **題目** ：在要求 AI 生成前端資料請求組件時，提示詞明確要求「當 API 發生 500 伺服器錯誤時，必須使用 `try...catch` 捕捉並在控制台輸出 `console.error(err)`」，在軟體工程與 UX 層面上已完整滿足了 NS09（協助辨識與復原錯誤）的要求？
* <div class="answer-box">
  <span class="answer-badge">標準答案：否 (X)</span> <b>Console.error 對終端使用者完全不可見</b>
  </div>
* 💡 **深度解析** ：
  1. `console.error` 是開發者的內部除錯工具。一般使用者在畫面上只會看到按鈕卡住或無反應的「死寂狀態」。
  2. **NS09 要求介面層級的友善引導** ：UI 應呈現白話錯誤說明（如 *「伺服器連線繁忙，請稍候再試」* ），並提供明確的「重試按鈕」或「客服回報連結」。

</div>

---

# 📙 Part 3: AI for UX — 觀念檢核答案

<div class="card">

### 選擇題：Master Prompt 的多維度 UX 約束設計
* **題目** ：在要求 AI 生成「多步驟註冊表單」時，以下哪一段提示詞最能同時滿足 NS01 (狀態)、NS03 (控制權) 與 NS05 (錯誤預防)？
* <div class="answer-box">
  <span class="answer-badge">標準答案：(B) 進度條 (NS01) + 保留資料上一步 (NS03) + 即時驗證禁用按鈕 (NS05)</span>
  </div>
* 💡 **深度解析** ：
  * **NS01 系統狀態能見度** ：頂部步驟指示器 (Step Indicator) 清楚標示「當前在第幾步 / 總共幾步」。
  * **NS03 使用者控制與自由** ：隨時提供「上一步」且完整保留已填寫內容，支援自由回溯修改。
  * **NS05 錯誤預防** ：欄位離開 (blur) 時即時校驗，未填完必填項時主動禁用下一步按鈕，防止無效送出。

</div>

---

# 🤖 Part 4: UX for AI — 觀念檢核答案

<div class="card">

### 是非題：AI 信心度揭露與過度信任風險
* **題目** ：在 AI 輔助醫療診斷或智慧報稅系統中，為了建立使用者對 AI 的強大信任感，介面應一律以 100% 篤定的語氣呈現 AI 的分析結果，避免顯示「信心度 (Confidence Score: 68%)」或替代方案，以免引發使用者的懷疑與猶豫？
* <div class="answer-box">
  <span class="answer-badge">標準答案：否 (X)</span> <b>隱瞞不確定性會誘發危險的「過度信任 (Over-reliance)」</b>
  </div>
* 💡 **深度解析** ：
  1. 在高風險專業領域，AI 模型不可避免存在幻覺與邊界限制。
  2. **可解釋性 (XAI) 與信任校準** ：誠實揭露信心水準、列出評估依據與次佳備選方案，才能引導專業人員進行精準的「人機協同覆核」，防止災難性決策。

</div>

---

# 🤖 Part 4: UX for AI — 觀念檢核答案

<div class="card">

### 選擇題：長任務等待體驗與心智模型對齊
* **題目** ：當 AI 執行需耗時 15~20 秒的深度研究（如文獻交叉驗證）時，以下哪一種介面反饋設計最符合現代 UX for AI 的「透明度與等待心理學」？
* <div class="answer-box">
  <span class="answer-badge">標準答案：(B) 動態思考步驟 (CoT) 即時滾動顯示並支援折疊</span>
  </div>
* 💡 **深度解析** ：
  * **消除等待焦慮 (NS01)** ：長達 20 秒的靜態 Spinner 會讓使用者誤以為當機。
  * **思考步驟視覺化 (Chain-of-Thought)** ：即時滾動「搜尋文獻 ➔ 萃取論點 ➔ 驗證數據」，給予使用者可預期的進度推進感。
  * **兼顧資訊簡潔 (NS08)** ：提供折疊/展開功能，滿足想要深入了解運算邏輯或只想看最終結論的兩類使用者需求。

---

<!-- _class: lead -->
# 觀念檢核核心心得總結

## 「原則是恆久的，介面是演進的」

**從傳統 GUI 到 AI 時代的 Copilot，使用者對掌控權、透明度與錯誤預防的需求從未改變。**

逢甲大學 資訊工程學系 薛念林 教授
