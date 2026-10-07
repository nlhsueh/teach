---
marp: true
theme: ux-theme
paginate: true
header: 'UX for AI: Human-Centered AI System Design'
footer: '薛念林 教授 | 逢甲大學資訊工程學系'
size: 16:9
transition: fade
html: true
---

<!-- _class: lead -->
<!-- _header: '' -->
# UX for AI: 以人為本的 AI 系統介面與互動設計
## Nielsen Heuristics in the AI Era (AI 產品的體驗設計心法)

**薛念林 教授**
逢甲大學 資訊工程學系

<span style="font-size: 14px; color: #64748b; margin-top: 24px; display: block;">（本講義與 Gemini AI 共同協作編製）</span>

---
<!-- header: '本單元大綱 (Outline)' -->

## 本單元大綱 (Outline)

<div class="two-columns">
<div class="card" data-marpit-fragment>

### 🌐 AI 系統與現代互動挑戰
- 什麼是深度封裝的 AI 系統 (AI Systems)
- 知名應用案例：Copilot, Antigravity IDE, Midjourney
- AI 時代的 6 大體驗痛點 (延遲、空白框、黑盒等)

</div>
<div class="card" data-marpit-fragment>

### 🛠️ 10 大原則在 AI 系統的心法與 Prompt
- NS01 ~ NS10 在 AI 時代的演進與心法
- 具體設計實務與建議提示詞架構
- 核心心法總結與課堂檢測 (CCQ & QA)

</div>
</div>

---

![bg fit](../../img/ux_for_ai_concept.png)

---
<!-- header: 'AI 系統與現代互動挑戰' -->

## AI 系統與應用的全面普及

<div class="two-columns">
<div class="card" data-marpit-fragment>

### 💡 什麼是 AI 系統 (AI Systems)？
- **非單純的大語言模型 (LLM)** ：它不是叫使用者去跟 ChatGPT/Claude 網頁版聊天，而是將 AI 能力深度封裝於工作流中的 **應用產品** 。
- **以人為本的系統整合** ：AI 扮演背景運算、自動完成、智能建議或自主代理人 (Agent) 的角色，提供直覺且自然的互動介面。

</div>
<div class="card" data-marpit-fragment>

### 🎯 AI 系統的關鍵應用範疇
- **智慧輔助與自動完成 (Co-piloting)** ：在開發或創作中給予行內建議。
- **上下文關聯操作 (Contextual Actions)** ：根據使用者目前選取的內容主動提供功能。
- **多模態智慧轉換 (Multimodal)** ：將文字、圖像、語音、程式碼等多種媒介進行無縫轉譯。

</div>
</div>

---

## 知名 AI 系統與應用案例 (Famous AI Systems)

<div class="two-columns">
<div class="card" style="font-size: 21px;" data-marpit-fragment>

- 💻 **GitHub Copilot** ：整合於 IDE 的 AI 結對程式員。透過灰色預測字元 (Ghost Text) 在行內即時推薦程式碼，極大提升開發效率。
- 🎨 **Midjourney / DALL-E 3** ：文字生成圖像系統。將複雜的藝術創作過程簡化為 Prompt 對話，從根本改變了創意設計流程。
- 🚀 **Google Antigravity IDE** ：新一代 Agentic AI 整合開發環境。具備自主 Agent、工具調用（終端機、瀏覽器）、行內指令 (`Cmd+I`) 與計畫審查模式 (Planning Mode)，重塑軟體工程開發體驗。

</div>
<div class="card" style="font-size: 21px;" data-marpit-fragment>

- 🌐 **DeepL** ：基於神經網絡的 AI 機器翻譯系統。具備極強的上下文理解力，能生成自然流暢的商業與學術翻譯。
- 🚗 **Tesla FSD (Full Self-Driving)** ：車載自動駕駛系統。採用純視覺神經網路，為車主提供端到端 (End-to-End) 的輔助駕駛體驗。
- 🔬 **AlphaFold** ：蛋白質結構預測系統。為生物學家提供高精度預測，將傳統實驗需耗時數年的工作縮短至數秒。

</div>
</div>

---

## AI 時代的 UX 挑戰與心法

> 面對大語言模型與生成式 AI（黑盒子、思考延遲、幻覺、輸出不確定性），如何以人為本重塑可用性原則？

<div class="three-columns">
<div class="card" data-marpit-fragment>

### 1. 緩解等待焦慮
- 拒絕靜態 Loading
- 打字機 Streaming 輸出
- 展開式 Thinking Steps

</div>
<div class="card" data-marpit-fragment>

### 2. 消除空白框恐懼
- 拒絕單一空白對話框
- 提示詞晶片 (Prompt Chips)
- 反白文字 AI 快捷懸浮球

</div>
<div class="card" data-marpit-fragment>

### 3. 對抗不確定性
- 隨時中斷生成 (Stop)
- 歷史版本輪播 (Carousel)
- 幻覺防範與優雅降級

</div>
</div>

---
<!-- header: 'AI and NS01 系統狀態能見度' -->

## Slide 01: AI and NS01 (系統狀態能見度) - UX 設計心法

> *“系統應在合理時間內，透過適當的反饋，隨時讓使用者掌握目前狀態。”*

<div class="two-columns-73">
<div class="card" style="font-size: 21px;" data-marpit-fragment>

### 💡 AI 產品設計心法 (UX for AI)
- **緩解 AI 的「思考延遲（Latency）」：**- 避免只用靜態的「Loading...」，改用打字機效果（Streaming) 即時輸出內容。
  - 引入 **展開式「思考步驟（Thinking Steps）」** （如 DeepSeek/O1 的 CoT 摺疊面板），讓使用者清楚 AI 正在進行「聯網搜尋」、「閱讀文件」或「執行程式碼」。
- **多步驟 AI 工作流（Multi-Agent Workflows）：**
  - 使用狀態節點圖（Node Graph）或微步進器，向使用者顯示目前 AI 助理正在進行 5 個步驟中的第 2 步（例如：生成草稿 → 翻譯 → 校對）。

</div>
<div class="card" style="font-size: 21px;" data-marpit-fragment>

### 🔍 真實系統應用案例
- **DeepSeek-R1 / OpenAI o1** 思考摺疊面板。
- AI 進行推理時，介面會呈現一個名為 `Thought` 或 `Thinking` 的摺疊區塊，即時顯示其思考步驟（ **Chain of Thought, CoT** ）。使用者可展開查看詳細邏輯，以緩解等待焦慮。

</div>
</div>

---

![bg 80%](../../img/ns01_thinking_process.jpg)

---

## Slide 01: AI and NS01 (系統狀態能見度) - 建議 Prompt

<div class="two-columns">
<div class="prompt-box" data-marpit-fragment>

### 💡 Prompt 設計框架
- **角色 (Role)**: AI 產品體驗架構師。
- **任務 (Task)**: 為多步驟長延遲的 AI 簡報生成流程設計高透明度的狀態反饋機制。
- **約束 (Constraint)**: 必須包含打字機即時輸出 (Streaming) 與思考步驟 (CoT) 折疊面板；禁止使用單一靜態 Loading Spinner。

</div>
<div class="prompt-box" data-marpit-fragment>

### 📝 提示詞範本
> 你是一位 AI 產品體驗架構師。當使用者要求生成一份 10 頁簡報時， 請為我設計 符合 NS01 系統狀態能見度 的反饋流程：
> 1. 將後台 4 個耗時步驟（資料檢索 ➔ 大綱擬定 ➔ 投影片生成 ➔ 視覺排版）轉化為動態微步進器與白話文案。
> 2. **禁止** 僅呈現無指示的靜態等待轉圈。

</div>
</div>

---
<!-- header: 'AI and NS02 真實世界與系統對應' -->

## Slide 02: AI and NS02 (真實世界與系統的對應) - UX 設計心法

> *“系統應說使用者的日常語言，而非工程師的技術術語，並遵循真實世界的邏輯習慣。”*

<div class="two-columns-64">
<div class="card" style="font-size: 21px;" data-marpit-fragment>

### 💡 AI 產品設計心法 (UX for AI)
- **將「模型參數」具象化：**
  - 避免在一般介面直接呈現 Temperature、Top_p、Token Limit 等大模型底層術語。
  - 將技術參數轉化為直覺的「擬真滑桿」或「單選按鈕」（例如：將 Temperature 轉化為「💡 創意表現：保守 → 豐富想像力」）。
- **擬真隱喻與控制：**
  - 使用「副駕駛（Copilot）」或「助理（Assistant）」的擬人化視覺隱喻，讓使用者知道它可以對話，而非面對一個冰冷的 Command Line。

</div>
<div class="card" style="font-size: 21px;" data-marpit-fragment>

### 🔍 真實系統應用案例
- **Google Antigravity IDE** 的「工作模式」與「軟體工程隱喻」。
- 後台模型參數如 `Temperature` （溫度）或推論次數對開發者而言難以量化。 Antigravity IDE 將底層參數轉化為真實世界的軟體工程角色隱喻： **Planning Mode（先出架構藍圖並待審查）** 與 **Agentic Fast Mode（即時結對執行與自動修復）**，用熟悉的工程思維取代冰冷演算法參數。

</div>
</div>

---

![bg 80%](../../img/ns02_match_real_world.jpg)

---

## Slide 02: AI and NS02 (真實世界與系統的對應) - 建議 Prompt

<div class="two-columns">
<div class="prompt-box" data-marpit-fragment>

### 💡 Prompt 設計框架
- **角色 (Role)**: AI 系統產品經理與資深 UX Writer。
- **任務 (Task)**: 將底層大語言模型技術參數（如 Temperature、Top_p）轉化為直覺的使用者語言與控制元件。
- **約束 (Constraint)**: 必須遵循自然語言與物理/角色隱喻；禁止在一般商務介面直接暴露底層演算法術語。

</div>
<div class="prompt-box" data-marpit-fragment>

### 📝 提示詞範本
> 你是一位 AI 系統產品經理。我們正在開發一款商務文案助理， 請為我重新設計後台的模型參數調整介面：
> 1. 將 `Temperature`、`Top_p` 等參數轉化為大眾熟悉的「語氣滑桿」（如：嚴謹專業 ➔ 豐富創意）。
> 2. 提供「角色隱喻」（如：行銷專家、法務顧問）。 **禁止** 直接出現冷冰冰的浮點數與演算法技術術語。

</div>
</div>

---
<!-- header: 'AI and NS03 使用者控制與自由' -->

## Slide 03: AI and NS03 (使用者控制與自由) - UX 設計心法

> *“使用者常會誤觸功能，系統必須提供明確的『緊急出口』與隨時能復原的 Undo/Redo 控制權。”*

<div class="two-columns-64">
<div class="card" style="font-size: 21px;" data-marpit-fragment>

### 💡 AI 產品設計心法 (UX for AI)
- **對抗 AI 的不確定性**： - 提供隨時  「中斷生成（Stop Generating）」的按鈕，防止 AI 輸出過長或失控的內容。
  - 引入 **「版本輪播（Version Carousel）」** ：在 AI 生成的結果旁，提供 1/3 的左右切換鍵，允許使用者對比並找回前幾次生成的滿意版本。
  - **Prompt 局部編輯** ：使用者可以編輯對話歷史中的任何一則 Prompt，點擊後系統自動在該節點分支「重新生成」，不破壞原始對話。

</div>
<div class="card" style="font-size: 21px;" data-marpit-fragment>

### 🔍 真實系統應用案例
- **ChatGPT / Claude** 的「中斷生成」與「歷史版本切換」。
- 當 AI 輸出的內容偏離預期或陷入無限迴圈時，使用者可隨時點擊「■ 中斷生成 (Stop Generating)」按鈕；生成完成後，若對答案不滿意，可使用 `1/2` 左右按鈕切換並對比歷史生成的不同版本。

</div>
</div>

---

![bg 80%](../../img/ns03_user_control.jpg)

---

## Slide 03: AI and NS03 (使用者控制與自由) - 建議 Prompt

<div class="two-columns">
<div class="prompt-box" data-marpit-fragment>

### 💡 Prompt 設計框架
- **角色 (Role)**: AI 互動設計師與前端工程師。
- **任務 (Task)**: 為不確定性高、長文本輸出的 AI 系統打造緊急出口與歷史版本切換機制。
- **約束 (Constraint)**: 必須支援隨時「一鍵中斷生成 (Stop)」與「版本輪播/差異對照 (Diff)」；禁止鎖死畫面或強迫等待。

</div>
<div class="prompt-box" data-marpit-fragment>

### 📝 提示詞範本
  > 你是一位AI 互動設計師。當 [AI 程式碼生成器] 正在持續輸出 50 行程式碼時， 請為我設計 具備 NS03 使用者控制與自由 的介面邏輯：
> 1. 實作醒目的「■ 中斷生成 (Stop)」按鈕與鍵盤快捷鍵 (`Escape`)。
> 2. 在回覆區旁提供「歷史版本切換 (1/3)」與「程式碼差異對照 (Diff View)」，讓使用者能一鍵還原。 **禁止** 在生成中鎖死畫面。

</div>
</div>

---
<!-- header: 'AI and NS04 一致性與標準' -->

## Slide 04: AI and NS04 (一致性與標準) - UX 設計心法

> *“使用者不應懷疑不同的詞彙、操作或位置是否代表同一件事。需遵循平台既有慣例。”*

<div class="two-columns-73">
<div class="card" style="font-size: 21px;" data-marpit-fragment>

### 💡 AI 產品設計心法 (UX for AI)
- **建立 AI 互動的「新標準」：**
  - 雖然 AI 介面日新月異，但已建立起業界標準（Standards），設計時必須遵循：
    - `Cmd + K` 或 `Ctrl + K` 喚醒全域 AI 搜尋/指令面板。
    - 輸入框按 `Enter` 為發送，`Shift + Enter` 為換行。
    - 每一則 AI 回覆的底部必備「複製（Copy）」與「重新生成（Regenerate）」圖標。
- **反饋機制的一致性：** 全站統一使用「👍 / 👎」或「星星評分」收集使用者對 AI 回覆的滿意度，不可隨意更換評分標準。

</div>
<div class="card" style="font-size: 21px;" data-marpit-fragment>

### 🔍 真實系統應用案例
- **Google Antigravity IDE / ChatGPT** 的標準輸入與操作設計。
- 全網 AI 助手已形成通用的操作標準：使用 `Enter` 鍵發送、 `Shift + Enter` 進行換行；編輯區支援 `Cmd + I` 快速調出即地指令框；回覆內容底部一致標配「📋 複製」與「👍/👎 回饋」，遵循統一互動規範。

</div>
</div>

---

![bg 80%](../../img/ns04_standards.jpg)

---

## Slide 04: AI and NS04 (一致性與標準) - 建議 Prompt

<div class="two-columns">
<div class="prompt-box" data-marpit-fragment>

### 💡 Prompt 設計框架
- **角色 (Role)**: AI Design System 架構師。
- **任務 (Task)**: 制定全站跨系統通用之 AI 對話輸入框與品質反饋規範 (Style Guide)。
- **約束 (Constraint)**: 必須嚴格遵循業界通用標準（如 `Cmd+K` 喚醒、`Enter` 送出、`Shift+Enter` 換行、👍/👎 評分）；禁止自創歧異快捷鍵。

</div>
<div class="prompt-box" data-marpit-fragment>

### 📝 提示詞範本
> 你是一位 AI Design System 架構師。 請為我們制定 一套跨業務系統適用的 AI 互動規範 (UI Style Guide) ：
> 1. 規範通用快捷鍵：`Cmd/Ctrl + K` 喚醒面板、`Enter` 發送、`Shift + Enter` 換行。
> 2. 統一程式碼區塊右上角的「複製」按鈕與回覆底部的「👍 / 👎 評分」與「重新生成」圖標樣式。 禁止 在不同頁面採用互相衝突的快捷鍵。

</div>
</div>

---
<!-- header: 'AI and NS05 錯誤預防' -->

## Slide 05: AI and NS05 (錯誤預防) - UX 設計心法

> *“比起提供好用的錯誤訊息，更好的設計是防範錯誤於未然（預防不合理的輸入或操作）。”*

<div class="two-columns-64">
<div class="card" style="font-size: 21px;" data-marpit-fragment>

### 💡 AI 產品設計心法 (UX for AI)
- 預防「糟糕輸入導致垃圾輸出（Garbage in, Garbage out）」： - 一般使用者極度不擅長寫 Prompt。提供「提示詞晶片（Prompt Chips/Suggestions）」或模板（Templates），點擊即代入標準提示。
  - 輸入框中預設豐富的 **Placeholder 提示字** （例如：試試看輸入：『幫我把這段報告翻譯成日文...』），引導正確輸入。
- **智慧 Prompt 預檢（Pre-flight Check）：** 當檢測到使用者上傳了不支援的檔案格式，或輸入的 Prompt 語意含混時，在發送前以「Inline Suggestion」主動提醒。

</div>
<div class="card" style="font-size: 21px;" data-marpit-fragment>

### 🔍 真實系統應用案例
- **ChatGPT / Claude** 的「提示字晶片 (Prompt Chips)」與「預設預檢」。
- 一般使用者不擅長撰寫 Prompt 。輸入框下方預設提供常用範本的晶片（例如「分析數據」、「撰寫郵件」），點擊即可套用；且當上傳不支援的檔案格式時，發送按鈕會轉為禁用狀態，防止無效點擊。

</div>
</div>

---

![bg 80%](../../img/ns05_error_prevention.jpg)

---

## Slide 05: AI and NS05 (錯誤預防) - 建議 Prompt

<div class="two-columns">
<div class="prompt-box" data-marpit-fragment>

### 💡 Prompt 設計框架
- **角色 (Role)**: AI 防呆與可用性專家。
- **任務 (Task)**: 在使用者與 AI 互動前建立預防機制，避免「糟糕輸入導致垃圾輸出 (Garbage in, Garbage out)」。
- **約束 (Constraint)**: 必須提供提示詞晶片 (Prompt Chips)、輸入前預檢 (Pre-flight Check) 與停用無效按鈕；禁止在送出後才拋出冰冷報錯。

</div>
<div class="prompt-box" data-marpit-fragment>

### 📝 提示詞範本
> 你是一位 AI 防呆專家。針對 [AI 數據分析助理]，  請為我設計發送前的 **NS05 錯誤預防** 機制：
> 1. 當使用者拖曳不支援的檔案格式（如 `.rar`）時，就地即時警示並將「發送」按鈕設為 Disabled。
> 2. 在輸入框下方常駐 3~5 個「Prompt 範本晶片」，引導使用者直接點擊套用標準格式。 **禁止** 讓使用者面對毫無指引的空白框隨意輸入。

</div>
</div>

---
<!-- header: 'AI and NS06 易於識別而非記憶' -->

## Slide 06: AI and NS06 (易於識別，而非憑空記憶) - UX 設計心法

> *“讓資訊、動作與選項保持可見，降低使用者的記憶負荷。使用者不應背誦指令。”*

<div class="two-columns-64">
<div class="card" style="font-size: 21px;" data-marpit-fragment>

### 💡 AI 產品設計心法 (UX for AI)
- **告別「萬惡的空白輸入框（Empty State Fear）」：**
  - 不要只給使用者一個空無一物的對話框，這會帶來極高的認知摩擦（Cognitive Friction）。
  - 畫面上應常駐「最近使用的 Agent 助理」、「常用 Prompt 歷史紀錄」、或一鍵調用最近編輯的檔案。
- **情境選單（Contextual Actions）：**
  - 當使用者在網頁上反白選取一段文字時，立刻在游標旁彈出「AI 快捷懸浮球」（如：翻譯、總結、潤飾），讓使用者「看得到就能點」，不需手動複製貼上。

</div>
<div class="card" style="font-size: 21px;" data-marpit-fragment>

### 🔍 真實系統應用案例
- **Google Antigravity IDE** 的「行內指令（`Cmd + I`）與 Code Lens（程式碼鏡頭）」。
- 當開發者選取程式碼時，可即地喚醒懸浮指令框；而在函式與類別上方常駐提供 **Code Lens**（如 `Explain`、`Refactor`、`Generate Tests`）。使用者「看見即可點擊觸發」，完全不必費心回憶 Prompt 語法或切換視窗手動複製貼上。

</div>
</div>

---

![bg 80%](../../img/ns06_recognition.jpg)

---

## Slide 06: AI and NS06 (易於識別，而非憑空記憶) - 建議 Prompt

<div class="two-columns">
<div class="prompt-box" data-marpit-fragment>

### 💡 Prompt 設計框架
- **角色 (Role)**: AI 情境互動 (Contextual UX) 設計師。
- **任務 (Task)**: 消除使用者對 AI 空白輸入框的恐懼，將可用功能外顯化於使用脈絡中。
- **約束 (Constraint)**: 必須提供情境選單 (Contextual Actions)、最近常用 Prompt 歷史與反白快捷懸浮球；禁止依賴使用者記憶斜線指令。

</div>
<div class="prompt-box" data-marpit-fragment>

### 📝 提示詞範本
> 你是一位AI 情境互動設計師。為了消除寫作助手的「空白框焦慮」， 請遵循 NS06 辨識而非記憶原則設計：
> 1. 當使用者在編輯器反白選取文字時，游標旁即刻浮現「AI 快捷懸浮工具列」（提供摘要、翻譯、擴寫等選項）。
> 2. 在首頁常駐「最近調用的 3 位 Agent 助理」卡片區。 **禁止** 強迫使用者自行背誦所有 `/` 斜線指令。

</div>
</div>

---
<!-- header: 'AI and NS07 使用彈性與效率' -->

## Slide 07: AI and NS07 (使用彈性與效率) - UX 設計心法

> *“系統應能滿足新手與專家的不同需求。提供快捷操作以提高效率。”*

<div class="two-columns-64">
<div class="card" style="font-size: 21px;" data-marpit-fragment>

### 💡 AI 產品設計心法 (UX for AI)
- **專為高頻使用者設計的快捷路徑（Shortcuts）：**
  - **斜線指令（Slash Commands）：** 輸入 `/` 即可快速喚起功能選單（如 Antigravity IDE 的 `/plan`、`/goal` 或 Slack）。
  - **@Mentions 跨領域調用：** 輸入 `@` 快速指派特定專長的 AI 代理人或引用外部知識庫（如 `@Designer`、`@CodingBot`）。
  - **一鍵自訂（Prompt Presets）：** 允許使用者將自己調校好、最常用的長 Prompt 存檔，設定成自訂按鈕（如：『以專業金融顧問的口吻回覆』快捷鍵）。

</div>
<div class="card" style="font-size: 21px;" data-marpit-fragment>

### 🔍 真實系統應用案例
- **Google Antigravity IDE** 的 `@-mentions` 與 `/` 斜線指令。
- 針對高頻專業開發者， Antigravity 支援在輸入框鍵入 `@` 快速精準附加上下文（如 `@Files`、`@Folders`、`@Terminals`、`@Rules` 或 `@MCP` 工具）；同時支援 `/` 斜線指令（如 `/plan` 規劃、`/goal` 深入自主、`/schedule` 排程），讓專家雙手不離鍵盤即可極速調度 AI 工作流。

</div>
</div>

---

![bg 80%](../../img/ns07_efficiency.jpg)

---

## Slide 07: AI and NS07 (使用彈性與效率) - 建議 Prompt

<div class="two-columns">
<div class="prompt-box" data-marpit-fragment>

### 💡 Prompt 設計框架
- **角色 (Role)**: AI 效率與進階工作流設計師。
- **任務 (Task)**: 為 AI 產品同時規劃適合新手的視覺化精靈與專為專家打造的高速加速器。
- **約束 (Constraint)**: 必須支援斜線指令 (`/`)、`@` 跨實體調用、自訂 Prompt Presets 與新手步驟精靈；禁止單一單調的操作途徑。

</div>
<div class="prompt-box" data-marpit-fragment>

### 📝 提示詞範本
> 你是一位 AI 效率設計師。請為 [AI 合約審查系統] 同時設計 新手與專家 兩套互動路徑：
> 1. **新手路徑** ：步驟式點選審查精靈（Wizard），引導逐步上傳與點選檢查項。
> 2. **專家路徑** ：鍵盤快捷控制台，支援 `/review` 快速審查與 `@compliance` 調用知識庫，並允許將常用 Prompt 設為一鍵巨集。 禁止 強制專家進行繁瑣的單步點擊。

</div>
</div>

---
<!-- header: 'AI and NS08 美學與簡約設計' -->

## Slide 08: AI and NS08 (美學與簡約設計) - UX 設計心法

> *“投影片與介面不應包含無關或極少需要的資訊。每一個額外的資訊都會與重要資訊競爭注意波段。”*

<div class="two-columns-73">
<div class="card" style="font-size: 21px;" data-marpit-fragment>

### 💡 AI 產品設計心法 (UX for AI)
- **避免 AI「資訊轟炸（Information Overload）」：**
  - AI 生成內容空間有限且往往極長。避免一次性將幾千字全部扔給使用者。
  - **預設折疊與展開（Show More）：** 對於長篇文章、程式碼區塊或詳細的分析過程，預設僅顯示前 3 行與摘要，使用者有興趣再展開。
  - **善用資訊層級：** 使用粗體、高亮、標籤晶片和適度的卡片區塊區隔資訊，保持版面的整潔與高度可讀性。

</div>
<div class="card" style="font-size: 21px;" data-marpit-fragment>

### 🔍 真實系統應用案例
- **Claude Artifacts** 獨立雙面板設計。
- Claude 將生成的長篇程式碼、網頁或圖表等複雜內容，自動拆分至右側獨立的預覽面板（ **Artifacts** ）中，避免左側對話框被幾千行的程式碼淹沒，保持版面極簡與高度可讀性。

</div>
</div>

---

![bg 80%](../../img/ns08_minimalist.jpg)

---

## Slide 08: AI and NS08 (美學與簡約設計) - 建議 Prompt

<div class="two-columns">
<div class="prompt-box" data-marpit-fragment>

### 💡 Prompt 設計框架
- **角色 (Role)**: AI 資訊架構師 (Information Architect)。
- **任務 (Task)**: 解決 AI 生成內容過長導致的「資訊轟炸」，打造層級分明的極簡介面。
- **約束 (Constraint)**: 必須採用預設折疊 (Show More)、獨立側邊預覽面板 (Artifacts) 與關鍵指標摘要看板；禁止將數千字無差別瀑布流灌入畫面。

</div>
<div class="prompt-box" data-marpit-fragment>

### 📝 提示詞範本
> 你是一位 AI 資訊架構師。當 [AI 市場調研助理] 生成一份包含數據、長文與圖表的巨大報告時， 請基於 NS08 極簡設計 重新排版：
> 1. 將長篇程式碼與複雜圖表拆分至右側獨立的 **Artifacts 預覽面板** 。
> 2. 左側對話區僅呈現前 3 行精簡摘要與 3 個核心 KPI 晶片，其餘細節提供「展開查看完整推演」按鈕。 禁止 將數千字未經收納直接瀑布流灌入。

</div>
</div>

---
<!-- header: 'AI and NS09 錯誤辨識與復原' -->

## Slide 09: AI and NS09 (協助辨識、診斷與從錯誤中復原) - UX 設計心法

> *“錯誤訊息應以清晰白話呈現，精確指出問題，並建設性地提供具體解決方案。”*

<div class="two-columns-64">
<div class="card" style="font-size: 21px;" data-marpit-fragment>

### 💡 AI 產品設計心法 (UX for AI)
- **優雅防範 AI「幻覺（Hallucination）」與「失效」：**
  - 當 AI 的回答可能不準確或不符合事實時，介面應明確標記（如：「⚠️ 此回答由 AI 生成，關鍵資訊請交叉核對」），並提供快速重新生成。
- **API 連線/超時報錯優雅降級（Graceful Degradation）：**
  - 當 AI 服務過載（如 Token 耗盡、超時斷線），不要只拋出「HTTP 502 Bad Gateway」等狀態碼。
  - 應白話告訴使用者：「目前 AI 連線人數眾多，您的 Prompt 檔已自動儲存，您可以[一鍵重試]。」

</div>
<div class="card" style="font-size: 21px;" data-marpit-fragment>

### 🔍 真實系統應用案例
- **Google Antigravity IDE** 的「Diagnostic Auto-Fix（診斷即時修復）」。
- 當程式碼編譯出錯、Lint 報錯或終端機執行失敗時， Antigravity 在問題面板與終端機直接提供一鍵「Auto-Fix」按鈕。 Agent 會自主讀取錯誤堆疊追蹤 (Stack Trace)、定位受影響程式碼並自動提出 Diff 修改，協助工程師秒速從挫折中復原，而非拋出冰冷晦澀的錯誤碼。

</div>
</div>

---

![bg 80%](../../img/ns09_error_recovery.jpg)

---

## Slide 09: AI and NS09 (協助辨識、診斷與從錯誤中復原) - 建議 Prompt

<div class="two-columns">
<div class="prompt-box" data-marpit-fragment>

### 💡 Prompt 設計框架
- **角色 (Role)**: AI 系統容錯與微文案 (Microcopy) 專家。
- **任務 (Task)**: 為 AI 服務過載、API 超時或輸出幻覺等異常狀態設計優雅降級與一鍵修復機制。
- **約束 (Constraint)**: 必須以白話說明原因、提供「一鍵重試 / 自動分割檔案」等建設性復原步驟；禁止拋出 HTTP 狀態碼或未處理的 Exception。

</div>
<div class="prompt-box" data-marpit-fragment>

### 📝 提示詞範本
> 你是一位 AI 微文案與容錯專家。當 [AI 翻譯器] 處理 50MB 大型文件因 Timeout 斷線時， 請基於 NS09 設計錯誤對話框：
> 1. 以繁體中文白話告知：「連線超時。因文件較大，AI 處理時間超出預期，您的原檔已安全暫存。」
> 2. 提供兩個具體動作按鈕：「[一鍵自動拆分為 3 個章節上傳]」與「[重新連線重試]」。 禁止 僅拋出 `HTTP 504 Gateway Timeout`。

</div>
</div>

---
<!-- header: 'AI and NS10 說明文件與輔助' -->

## Slide 10: AI and NS10 (說明文件與輔助說明) - UX 設計心法

> *“雖然不需文件就能操作系統是最好的，但隨時提供易於檢索、聚焦任務且簡潔的說明文件依然不可或缺。”*

<div class="two-columns-73">
<div class="card" style="font-size: 21px;" data-marpit-fragment>

### 💡 AI 產品設計心法 (UX for AI)
- **「可解釋性 AI」（XAI, Explainable AI）即是最好的說明：**
  - AI 產生的推薦或決策，往往像個黑盒子。
  - 介面中必須在決策旁提供 **「解釋說明（Explain this recommendation）」** 的互動提示。例如：「為什麼我會看到這筆推薦？因為您在 3 天內曾瀏覽過 Python 與 UI 設計相關職缺。」這就是 AI 時代的「說明文件」。
- **情境化動態引導（Context-sensitive Copilot）：**
  - 揚棄傳統的大部頭 Help PDF。在輸入框旁設計輕量化的「互動式提示指南」，引導使用者逐步學會如何精準寫出「好 Prompt」。

</div>
<div class="card" style="font-size: 21px;" data-marpit-fragment>

### 🔍 真實系統應用案例
- **Perplexity AI / ChatGPT Search** 的數字引文腳註。
- AI 生成的內容可能存在幻覺。介面在每個事實論點旁標記數字腳註（例如 `[1]` , `[2]` ），滑鼠懸停或點擊可顯示該資訊的原始新聞或網頁來源，作為可信度的即時輔助說明。

</div>
</div>

---

![bg 80%](../../img/ns10_help_doc.jpg)

---

## Slide 10: AI and NS10 (說明文件與輔助說明) - 建議 Prompt

<div class="two-columns">
<div class="prompt-box" data-marpit-fragment>

### 💡 Prompt 設計框架
- **角色 (Role)**: 可解釋性 AI (XAI) 與新手引導設計師。
- **任務 (Task)**: 為黑盒子 AI 決策提供透明的「可解釋性來源標記」，並提供情境化互動引導。
- **約束 (Constraint)**: 必須包含數字引文來源腳註 (Citations / XAI)、即時互動 Tooltip 與任務導向範本；禁止提供傳統無聊的整本 PDF 說明書。

</div>
<div class="prompt-box" data-marpit-fragment>

### 📝 提示詞範本
> 你是一位 可解釋性 AI (XAI) 設計師。 請為 [AI 理財投資助理] 設計 NS10 輔助說明 機制：
> 1. 在 AI 生成的每項數據與建議旁標記數字腳註（如 `[1]`），點擊或懸停即浮現原始市場數據來源與推理依據。
> 2. 在輸入框旁設計互動式 Tooltip，教導新手如何輸入「投資預算、風險偏好、時間週期」三大關鍵要素。 禁止提供難以檢索的靜態手冊。

</div>
</div>

---
<!-- header: 'UX for AI 核心心法總結' -->

## UX for AI 核心心法與 10 大原則總結

> *AI 系統充滿不確定性與黑盒子特性； UX for AI 的使命是用透明的狀態、直覺的隱喻、充分的控制權與情境化工具，確保人類始終掌控全局（Human-in-the-Loop）。*

<div class="two-columns">
<div class="card" style="font-size: 19px;" data-marpit-fragment>

### 🧭 透明與掌控 (NS01 ~ NS05)
- **NS01 狀態能見度** ：Streaming 打字機即時輸出、CoT 思考步驟折疊面板。
- **NS02 真實世界對應** ：底層模型參數轉化為直覺工程角色隱喻（Planning Mode）。
- **NS03 控制與自由** ：隨時中斷生成 (Stop)、歷史版本輪播與 Diff 差異對照。
- **NS04 一致性與標準** ：遵循 `Enter` 發送、`Cmd+I/K` 喚醒、統一評分圖標。
- **NS05 錯誤預防** ：提供 Prompt 晶片引導與輸入前預檢，避免無效請求。

</div>
<div class="card" style="font-size: 19px;" data-marpit-fragment>

### ⚡ 效率與流暢 (NS06 ~ NS10)
- **NS06 易於識別** ：反白浮動指令框 (`Cmd+I`)、程式碼鏡頭 (Code Lens)，看見即可點。
- **NS07 彈性與效率** ：`@-mentions` 跨實體精準引用、`/` 斜線指令極速調度。
- **NS08 美學與簡約** ：長篇產出與程式碼拆分至獨立 **Artifacts 預覽面板** ，避免資訊轟炸。
- **NS09 錯誤復原** ：白話降級提示、Diagnostic Auto-Fix 一鍵修復，取代底層錯誤碼。
- **NS10 說明與輔助** ：可解釋性 AI (XAI) 來源標註與數字引文腳註，即時解答疑惑。

</div>
</div>

---
<!-- header: '課堂檢測與討論 (CCQ & QA)' -->

<!-- id: ux-ch04-ccq1 -->
## 🙋 概念核對問答 (CCQ1)

<div class="two-columns-64">
<div class="card">

### ❓ AI 信心度 (Confidence) 與防呆設計
**[ 是 / 否 ]** 「在 AI 輔助醫療診斷或智慧報稅系統中，為了建立使用者對 AI 的強大信任感，介面應一律以 100% 篤定的語氣呈現 AI 的分析結果，避免顯示『信心度 (Confidence Score: 68%)』或替代方案，以免引發使用者的懷疑與猶豫。」

請判斷上述說法是否正確，並思考過度信任 (Over-reliance) 的風險。

[線上作答](https://nlhsueh.github.io/nickedupocket/#/student/ux-ch04-ccq1)

  

</div>
<div class="card-img">

<a href="https://nlhsueh.github.io/nickedupocket/#/student/ux-ch04-ccq1" target="_blank"><img src="../../img/ch04/ux-ch04-ccq1.png" alt="QR Code" style="max-height: 280px;"></a>

</div>
</div>

---

<!-- id: ux-ch04-ccq2 -->
## 🙋 概念核對問答 (CCQ2)

<div class="two-columns-64">
<div class="card">

### ❓ 複雜長任務的 AI 等待體驗
當 AI 執行需耗時 15~20 秒的深度研究（如文獻交叉驗證）時，以下哪一種介面反饋設計最符合現代 UX for AI 的「透明度與等待心理學」？

- **(A)** 顯示全螢幕單一旋轉 Spinner，註明「運算中請勿關閉」
- **(B)** 採用動態思考進度（CoT），即時滾動顯示「正在搜尋 12 篇文獻 ➔ 萃取論點 ➔ 驗證數據」，並支援折疊
- **(C)** 立即顯示空白頁，待全部完成後瞬間重新整理
- **(D)** 將 Timeout 強制縮短為 3 秒，未完成直接中斷報錯

[線上作答](https://nlhsueh.github.io/nickedupocket/#/student/ux-ch04-ccq2)

  

</div>
<div class="card-img">

<a href="https://nlhsueh.github.io/nickedupocket/#/student/ux-ch04-ccq2" target="_blank"><img src="../../img/ch04/ux-ch04-ccq2.png" alt="QR Code" style="max-height: 280px;"></a>

</div>
</div>

---

<!-- id: ux-ch04-qa1 -->
## 🙋 問答討論 (QA1)

<div class="two-columns-64">
<div class="card">

### 全面系統 UX 健檢
請挑選一個你常用的系統進行全方位診斷與優化構想：

1. **問題診斷** ：找出系統中違反 **Nielsen 10 大原則** 的 3 個具體問題。
2. **AI Prompt 實踐** ：寫出一段具備工程師思維的 Prompt，要求 AI 生成符合該 UX 規範的前端組件。
3. **AI 產品優化** ：若將該系統升級為 AI 智慧助手，你將如何設計防呆反饋與錯誤復原機制？

[線上作答](https://nlhsueh.github.io/nickedupocket/#/student/ux-ch04-qa1)

  

</div>
<div class="card-img">

<a href="https://nlhsueh.github.io/nickedupocket/#/student/ux-ch04-qa1" target="_blank"><img src="../../img/ch04/ux-ch04-qa1.png" alt="QR Code" style="max-height: 280px;"></a>

</div>
</div>

---
<!-- _class: lead -->
<!-- _header: '' -->

# Thank You!
## 打造以人為本、流暢優雅的使用者體驗

**Q & A / 交流討論**

<script>
(function() {
  function initHeaderDropdown() {
    const sections = [];
    const seenTitles = new Set();
    const slideSections = document.querySelectorAll('section[id]');
    
    // 1. Scan unique section titles and their slide IDs
    slideSections.forEach(sec => {
      const header = sec.querySelector('header');
      if (!header) return;
      
      let title = header.textContent.trim();
      title = title.replace(/^[◄◀]\s*/, '').replace(/\s*[►▶]$/, '').trim();
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
      const wrapper = document.createElement('span');
      wrapper.className = 'header-nav-wrapper';
      
      const titleSpan = document.createElement('span');
      titleSpan.className = 'header-nav-title';
      titleSpan.title = '點擊固定或懸停查看所有章節快速跳轉';
      titleSpan.innerHTML = currentTitle + '<span class="nav-caret"> ▾</span>';
      
      titleSpan.addEventListener('click', function(e) {
        e.stopPropagation();
        const wasOpen = wrapper.classList.contains('is-open');
        document.querySelectorAll('.header-nav-wrapper.is-open').forEach(w => w.classList.remove('is-open'));
        if (!wasOpen) {
          wrapper.classList.add('is-open');
        }
      });
      
      const dropdown = document.createElement('div');
      dropdown.className = 'nav-dropdown';
      
      dropdown.addEventListener('click', function(e) {
        e.stopPropagation();
      });
      
      const dropHeader = document.createElement('div');
      dropHeader.className = 'nav-dropdown-header';
      dropHeader.innerHTML = '<span>📑 快速跳轉章節目錄</span><span style="font-size:11px;font-weight:normal;color:#64748b;">共 ' + sections.length + ' 個章節</span>';
      dropdown.appendChild(dropHeader);
      
      const grid = document.createElement('div');
      grid.className = 'nav-dropdown-grid';
      
      sections.forEach(s => {
        const item = document.createElement('a');
        const isActive = (s.title === currentTitle);
        item.className = 'nav-dropdown-item' + (isActive ? ' active' : '');
        item.href = '#' + s.id;
        item.innerHTML = '<span class="badge">#' + s.id.padStart(2, '0') + '</span><span class="item-text" title="' + s.title + '">' + s.title + '</span>';
        
        item.addEventListener('click', function(e) {
          wrapper.classList.remove('is-open');
          dropdown.style.display = 'none';
          window.location.hash = '#' + s.id;
          setTimeout(() => { dropdown.style.display = ''; }, 350);
        });
        
        grid.appendChild(item);
      });
      
      dropdown.appendChild(grid);
      wrapper.appendChild(titleSpan);
      wrapper.appendChild(dropdown);
      return wrapper;
    }

    // Close any pinned dropdown when clicking anywhere outside
    document.addEventListener('click', function(e) {
      if (!e.target.closest('.header-nav-wrapper')) {
        document.querySelectorAll('.header-nav-wrapper.is-open').forEach(w => w.classList.remove('is-open'));
      }
    });

    // 2. Enhance each header element across all slides
    slideSections.forEach(sec => {
      const header = sec.querySelector('header');
      if (!header || header.dataset.navEnhanced) return;
      header.dataset.navEnhanced = 'true';
      
      let title = header.textContent.trim();
      title = title.replace(/^[◄◀]\s*/, '').replace(/\s*[►▶]$/, '').trim();
      if (!title) return;
      
      header.innerHTML = '';
      const wrapper = createDropdownWrapper(title);
      header.appendChild(wrapper);
    });
  }

  if (document.readyState === 'loading') {
    document.addEventListener('DOMContentLoaded', initHeaderDropdown);
  } else {
    initHeaderDropdown();
  }
  setTimeout(initHeaderDropdown, 400);
})();
</script>
