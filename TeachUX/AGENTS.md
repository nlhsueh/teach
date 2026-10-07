# Workspace Coding Rules and Best Practices

Welcome to the `gTeachUX` project! When modifying or editing files in this workspace (including lecture handbooks in `Lecture/source/` and presentation slide decks in `Slide/source/`), you must strictly adhere to the following rules:

## 1. Markdown Formatting for Slides (Marp & Markdown-it)

### Chinese Bold Spacing Rule
* **Problem**: In the Markdown-it parser (which Marp uses), bold markers (`**`) placed directly adjacent to Chinese characters or full-width punctuation/brackets (e.g., `，。！？、「」（）［］【】` etc.) without spaces will fail to render as bold and instead output raw asterisks.
* **Rule**: You **MUST** insert a single whitespace character before and after any bold markdown block (`**text**`) if it is adjacent to a Chinese character or full-width punctuation outside the block.
* **Example**:
  * ❌ *Incorrect*: `改用**打字機效果（Streaming）**即時輸出`
  * ✅ *Correct*: `改用 **打字機效果（Streaming）** 即時輸出`
  * ❌ *Incorrect*: `在**合理的時間內**給予反饋`
  * ✅ *Correct*: `在 **合理的時間內** 給予反饋`

### 表格全域置中規範 (Table Centering Rule)
* **Problem**: Marp 的預設主題會將 Markdown 表格設定為 `display: block; width: max-content;`，導致表格無法透過 `margin: auto` 水平置中，排版會靠左偏斜且右側大片留白。
* **Rule**: 投影片中所有表格（包括對照表、總結表等）必須一律維持水平置中。全域樣式必須強制指定 `display: table !important` 與 `align-self: center !important`：
  ```css
  table {
    display: table !important;
    width: 95%;
    max-width: 1100px;
    border-collapse: collapse;
    margin: 16px auto !important;
    align-self: center !important;
  }
  ```

---

## 2. 互動題目 (CCQ) 生命週期與同步標準程序 (CCQ Lifecycle & Sync Workflow)

* **階段 1 (初創無 QR 狀態)**：
  * AI 撰寫新互動題目時，一律按照標準格式撰寫題目文字、選項與答案解析。
  * **初創時一律為「無 QR」狀態**，不需要手動繪製或插入 QR Code 圖片，也不需要手動放置 `[線上作答]` 連結。
  * 題目上方可保留或由系統產生 `<!-- id: ux-chXX-ccqN -->` 註解。
* **階段 2 (執行同步)**：
  * 題目撰寫完成後，執行統一同步指令：
    ```bash
    python3 scripts/sync_iActivity.py --course gTeachUX
    ```
  * 同步腳本會自動完成：
    1. 解析 `Lecture/source/` 與 `Slide/source/` 中的互動題目。
    2. 匯出題庫至 `nickedupocket/public/courses/gTeachUX.md`。
    3. 自動生成各題 QR Code 圖檔至 `img/chXX/<act_id>.png`（供簡報使用）。
    4. 自動在講義手冊嵌入 `<!-- id: ... -->` 與 `[課堂互動]` 連結（講義不放 QR Code），簡報投影片中則同時嵌入 `[課堂互動]` 連結與 QR Code 圖檔。
* **階段 3 (題目修改重同步)**：
  * 若題目文字、選項或解析修改，直接修改 Markdown（保留原有 `<!-- id: ... -->`），再次執行 `sync_iActivity.py` 即可自動冪等更新。
* **階段 4 (編譯 PDF)**：
  * 同步完成後再執行 PDF 編譯：
    - 講義 PDF：`node scripts/generate_lecture_pdf.js Lecture/source/ch01_intro.md`
    - 投影片 PDF：`npx @marp-team/marp-cli Slide/source/UX_AI.md --pdf --allow-local-files --no-stdin -o Slide/UX_AI.pdf`

---

## 3. 繁體中文與軟體工程專業用語守則 (Terminology Consistency)

* **程式碼用語規範**：
  * ❌ *嚴禁使用*：`代碼`、`前端代碼`、`代碼塊`、`寫代碼`
  * ✅ *必須使用*：`程式碼`、`前端程式碼`、`程式碼區塊`、`撰寫程式碼`
* **錯誤碼／狀態碼用語**：
  * ❌ *避免使用*：`錯誤代碼`、`系統代碼`
  * ✅ *推薦使用*：`錯誤碼`、`錯誤代號`、`狀態碼`（如 HTTP 狀態碼）
* **原則**：本教材為逢甲大學資工系之授課教材，全面遵循臺灣資訊科技教育之繁體中文標準軟體工程術語。

---

## 4. HTML 簡報與網頁互動體驗規範 (HTML Presentation & Web UI/UX Standards)

### 4.1 頂部導覽列 (Header Navigation) 架構與互動設計
所有 Marp 投影片之 HTML 互動模式均需具備一致且易用的頂部導覽機制：
* **章節標題與純下拉目錄 (Pure Dropdown Navigation)**：
  - 移除上一章與下一章箭頭，保持頂部導覽乾淨專注，以目錄選單為單一跳轉核心。
  - 標題封裝於 `.header-nav-wrapper` 與 `.header-nav-title`，並帶有指示箭頭 `▾`（`.nav-caret`）。
  - **懸停預覽 (Hover)**：滑鼠移至章節文字時，自動展開下拉式「全簡報章節目錄清單」（`.nav-dropdown`），顯示各節編號 Badge（如 `#01`）與標題。
  - **點擊釘選 (Click Pinning)**：點擊章節標題可切換 `.is-open` 釘選固定目錄面板，便於使用者從容選擇；點擊任一項目或外部任意處即自動關閉。
  - **當前位置高亮 (Active Indicator)**：目錄清單自動標記使用者當前所在之章節項目（`.active` 樣式）。
  - **防斷連橋樑設計 (Invisible Bridge)**：下拉選單頂部需加入 `::before` 透明墊片，消除標題與選單間的微小空隙，防止游標移動時選單意外消失。
* **匯出與列印純淨化 (@media print)**：
  - 在列印或 PDF 匯出模式下，所有互動導覽元素（下拉選單、caret）必須一律設定 `display: none !important;`，維持 PDF 版面整潔。

### 4.2 內容呈現與漸進式設計原則 (Progressive Disclosure / Presentation Strategy)
* **預設原則：全貌優先與資訊完整 (Overview First)**：
  - 教學簡報與講義頁面以「整體結構清晰、一目了然」為核心原則，避免濫用無意義的逐點漸進（Incremental click-to-reveal），防止增加學生的翻頁與認知負擔。
* **適用漸進呈現的情境**：
  - **課堂問答與概念檢核 (CCQ / QA)**：先呈現情境題目與選項，引導學生思考與即時作答，待作答完畢後再揭曉標準答案與解析（或將題目與解答拆分為前後兩頁）。
  - **複雜多步驟流程與架構演進**：拆解為連續獨立頁面（Step-by-step slides）或左右雙欄對照（Before / After），而非在單頁塞入複雜微小動效。
* **轉場動態與回饋 (Transitions & Micro-interactions)**：
  - 簡報轉場一律使用平滑淡入淡出（`transition: fade` 或 URL 參數 `?transition=fade`）。
  - 互動元素（按鈕、卡片、目錄項、導覽箭頭）必須提供即時視覺回饋（如輕微位移 `transform: translateY(-2px)`、柔和陰影變化、高亮底色轉換），遵循 Nielsen 第 1 原則（系統狀態能見度）。

### 4.3 課程入口首頁 (index.html) 設計準則
* **卡片式模組清單 (Module Grid)**：清楚標示單元編號 (Tag)、章節名稱、內容摘要，並提供雙操作按鈕（「🖥️ 開啟簡報 (HTML 互動模式)」與「📄 下載簡報 (PDF)」）。
* **狀態視覺化 (Status Distinction)**：
  - **核心單元**：以顯著邊框與陰影標示（`★ 核心單元`）。
  - **開放單元 vs. 暫未開放單元**：未開放單元採用 `.disabled` 樣式、鎖定圖示與虛線按鈕。
  - **測驗題庫模組**：採用專屬視覺主題色（如綠色系）予以區別。
* **底部操作指南 (Guide Card)**：常駐展示 Header 導覽列操作方式（箭頭跳轉、懸停/點擊目錄）以及 Marp 互動模式鍵盤快捷鍵（`F` 全螢幕、`→`/`Space` 下一頁、`←` 上一頁、`P` 講稿、`數字`+`Enter` 跳頁、`Esc` 退出）。


