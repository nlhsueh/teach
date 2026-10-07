# Chapter 3: AI for UX — 運用 AI 進行體驗設計與原型打造

## 3.1 AI 輔助生成組件與介面感知錯誤處理

在透過 AI 提示詞生成前端程式碼時，除了程式層面的例外捕捉，必須在 UI 層面符合 NS09 的友善引導原則。

<!-- id: ux-ch03-ccq1 -->
### 🙋 **概念核對問答 (CCQ 1)**

**問題**

在要求 AI 生成前端資料請求組件時，提示詞明確要求「當 API 發生 500 伺服器錯誤時，必須使用 `try...catch` 捕捉並在控制台輸出 `console.error(err)`」，在軟體工程與 UX 層面上已完整滿足了 NS09（協助辨識與復原錯誤）的要求？

A) 正確 (True)
B) 錯誤 (False)

[課堂互動](https://nlhsueh.github.io/nickedupocket/#/student/ux-ch03-ccq1)

<details>
<summary>點擊查看【概念核對問答】答案與解析</summary>

**正確答案：B**

* **解析**：
  * `console.error` 是開發者除錯工具，對終端使用者完全不可見，使用者只會看到按鈕無反應或畫面卡住。
  * NS09 要求介面層級應呈現白話錯誤說明，並提供重試按鈕或指引。

</details>

---

## 3.2 Master Prompt 的多維度 UX 約束設計

撰寫給 AI 的 Master Prompt 時，透過精準定義多項易用性約束，能大幅提升生成原型的品質與實用性。

<!-- id: ux-ch03-ccq2 -->
### 🙋 **概念核對問答 (CCQ 2)**

**問題**

在要求 AI 生成「多步驟註冊表單」時，以下哪一段提示詞最能同時滿足 NS01 (狀態)、NS03 (控制權) 與 NS05 (錯誤預防)？

A) 「請用 React + Tailwind 寫一個美觀的註冊表單，支援深色模式。」
B) 「提供步驟進度條；每步均有『上一步』且保留資料；欄位 blur 時即時驗證並禁用未過關的『下一步』按鈕。」
C) 「表單最後提供送出按鈕，送出失敗時彈出 Toast `Submission failed`。」
D) 「使用 LocalStorage 快取所有欄位，並提供一鍵重設按鈕。」

[課堂互動](https://nlhsueh.github.io/nickedupocket/#/student/ux-ch03-ccq2)

<details>
<summary>點擊查看【概念核對問答】答案與解析</summary>

**正確答案：B**

* **解析**：
  * NS01 系統狀態能見度：頂部步驟進度條清楚標示當前與整體進度。
  * NS03 使用者控制與自由：隨時提供上一步且保留已填資料，支援自由回溯。
  * NS05 錯誤預防：blur 時即時校驗，未填完必填項時主動禁用下一步按鈕，防止無效送出。

</details>

---

<!-- id: ux-ch03-qa1 -->
### 🙋 **問答討論 (QA 1)：用 AI 設計辦公室 Web 點餐系統**

> * **任務與挑戰**：請使用 AI 輔助設計辦公室 Web 點餐系統，並分享你的提示詞與生成觀察：
>   1. **初版生成 vs. UX 優化**：比較「無 Prompt 限制」與「加入尼爾森原則約束」後的程式碼與介面差異。
>   2. **滿足哪些易用性原則**：你的 Master Prompt 中加入了哪些 UX 約束（如 NS01 狀態、NS03 控制權、NS05 錯誤預防）？
>   3. **心得與發現**：AI 生成的 UX 細節是否符合預期？有哪些值得注意的盲點？

---
## 3.3 課堂互動遊戲：從 Prompting 到 Agent 典範轉移闖關挑戰

<!-- id: ux-ch03-game1 -->
### 🙋 課堂遊戲：從 Prompting 到 Agent 典範轉移闖關挑戰 (Game)

**第 1 題：【Chat-based Prompting 的上下文孤島】**
工程師在傳統對話框中輸入「請幫我寫一個符合 NS01 的購物車組件」，AI 給出了一段語法正確的 React 程式碼。然而當工程師複製進專案時，卻發現該組件無法辨識專案既有的 Pinia/Redux 狀態機，CSS 變數亦與全域 Design System 衝突，還缺漏了必要的依賴套件。請問這最能說明傳統對話型 Prompting 的哪一項核心局限？
A) 大型語言模型的推理速度過慢
B) 上下文孤島 (Context Silo) 與缺乏全專案視野
C) 模型欠缺基本的程式碼語法檢查能力
D) 對話介面無法輸出超過 50 行的文字

[課堂互動](https://nlhsueh.github.io/nickedupocket/#/student/ux-ch03-game1)

<details>
<summary>點擊查看答案與解析</summary>

**正確答案**：B
**解析**：傳統 Chat-based AI 缺乏對既有專案結構、狀態管理與全域樣式的感知能力，生成的程式碼片段需要工程師手動拼裝與除錯，形成孤島效應。
</details>

---

**第 2 題：【Agent 的規劃優先原則 (Planning Mode)】**
當我們指派 AI Agent 一個涉及 5 個前端組件、全站深色模式變數以及結帳狀態機的複雜 UX 重構任務時，一個成熟的 Agentic 協同工作流應該採取的第一步動作為何？
A) 立即以多執行緒同時盲目改寫 5 個前端程式碼檔案
B) 自動覆寫既有檔案並強制執行 `git push --force` 推送至遠端
C) 優先進入規劃模式 (Plan)，主動分析相依性並產出結構化實施計畫書，等待人類審查批准
D) 自動關閉終端機並拒絕執行跨檔案操作

<details>
<summary>點擊查看答案與解析</summary>

**正確答案**：C
**解析**：成熟的 Agent 工作流遵循「規劃優先 (Planning Mode)」與「人機協同 (Human-in-the-Loop)」，先分析跨檔案相依性並產出計畫書，經人類審查確認後才調用工具執行修改。
</details>

---

**第 3 題：【閉環驗證與自主走查 (Feedback Loop)】**
AI Agent 在完成購物車刪除防呆 Modal (NS05) 的前端程式碼改動後，自主調用終端機指令編譯專案、開啟瀏覽器走查工具模擬點擊結帳流程，並在瀏覽器控制台檢測有無未捕捉之 JavaScript 錯誤。請問這項特徵體現了 Agent 與傳統 Prompting 的哪項本質差異？
A) 單一對話的提示詞長度能無限擴展
B) 外部工具調用與自主閉環走查驗證 (Tool Calling & Feedback Loop)
C) 取代人類產品經理的所有商業決策
D) 完全不需要依賴任何底層大型語言模型

<details>
<summary>點擊查看答案與解析</summary>

**正確答案**：B
**解析**：Agent 能透過 Tools 控制終端機與瀏覽器，具備執行驗證與捕捉反饋的閉環能力，不再只是被動輸出文字。
</details>

---

**第 4 題：【人機協同 (Human-in-the-Loop) 的角色演進】**
在現代 Agentic UX 開發模式下，AI Agent 能自主負擔繁重的跨檔案重構、樣式微調與自動化測試驗證。請問在此典範轉移下，人類工程師與設計師最關鍵的核心職責轉變為何？
A) 專職手動輸入終端機編譯指令
B) 意圖定義、架構審核、關鍵決策批准與最終體驗驗收 (Reviewer & Orchestrator)
C) 完全退出軟體開發流程，由 AI 獨立交付與部署上線
D) 僅負責幫 AI 支付 API 費用與伺服器硬體維護

<details>
<summary>點擊查看答案與解析</summary>

**正確答案**：B
**解析**：人類在 Agent 時代從低層次的程式碼拼裝者，升級為高層次的系統編排者 (Orchestrator)、架構審核者與最終體驗把關者。
</details>

---

**第 5 題：【斜線指令實踐：經驗固化 (`/learn`)】**
團隊在協同開發時，發現 Agent 預設常常生成未對齊 Design System 的任意色彩，破壞了介面一致性 (NS04)。若使用 Antigravity IDE，團隊最推薦透過哪一項指令將「一律使用 tokens.css 變數」的決策沉澱為全專案的長期記憶？
A) `/goal`
B) `/schedule`
C) `/learn`
D) `/plan`

<details>
<summary>點擊查看答案與解析</summary>

**正確答案**：C
**解析**：`/learn` 能將人類反饋與專案最佳實踐固化為專案自訂規則 (Rules/Knowledge)，使後續對話與 Agent 任務自動遵守。
</details>
