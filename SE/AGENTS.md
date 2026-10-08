# AGENTS.md

## Repository Structure & Build Guidelines for gTeachASE

### 1. Structure
- `Lecture/en/`: English lecture notes Markdown source (`.md`) and compiled A4 portrait PDFs (`.pdf`).
- `Lecture/tw/`: Traditional Chinese lecture notes Markdown source (`.md`) and compiled A4 portrait PDFs (`.pdf`).
- `Slide/md-en/`: Marp Markdown source files for English **16:9 widescreen (橫式)** presentation slides (含 `slide00e_syllabus.md` 研究所專題大綱，ignored in git, maintained locally).
- `Slide/md-tw/`: Marp Markdown source files for Traditional Chinese **16:9 widescreen (橫式)** presentation slides (含 `slide00t_syllabus.md` 大學部大綱，ignored in git, maintained locally).
- `Slide/pdf-en/`: Compiled 16:9 PDF presentation slides (English).
- `Slide/pdf-tw/`: Compiled 16:9 PDF presentation slides (Traditional Chinese).
- `Slide/html/`: Compiled interactive HTML presentation slides (含 `slide00t_syllabus.html`, `slide00e_syllabus.html` 供 GitHub Pages 與首頁參照).
- `img/`: Shared image assets (`../../img/<chapter>/...`).
- `-hidden/pptx/`: 歷史 PowerPoint 簡報檔封存目錄（專案已全面廢除產生 PPTX，既有檔案已全數移至此處封存）。
- `syllabus*`: 歷史大綱檔案（已全面整併遷移至 `Slide/md-*/slide00*.md` 與 `Slide/pdf-*/slide00*.pdf`，根目錄不再保留歷史檔）。

---

### 2. 互動題目 (CCQ) 生命週期與同步標準程序 (CCQ Lifecycle & Sync Workflow)

* **階段 1 (初創無 QR 狀態)**：
  * 撰寫新 CCQ 題目時一律為草稿狀態，只需撰寫標準題型、選項與答案解析。
  * **初創時一律為「無 QR」狀態**，不需要手動放 QR Code 圖片或 `[線上作答]` 連結。
* **階段 2 (執行同步)**：
  * 題目撰寫完成後，執行統一同步指令：
    ```bash
    python3 scripts/sync_ccq.py --course gTeachASE
    ```
  * 同步腳本會自動解析題庫、匯出至 `nickedupocket/public/courses/gTeachASE.md`、產生 QR Code 圖片，並自動回寫嵌入註解編號、作答連結與 QR 圖檔至講義與投影片。
* **階段 3 (題目修改重同步)**：
  * 若後續修改題目內容，保留原有的 `<!-- id: ase-chXX-ccqN -->` 註解，再次執行 `sync_ccq.py` 即可自動冪等更新。
* **階段 4 (編譯 PDF)**：
  * 同步完成後再執行 PDF 編譯。
* **CCQ 選項長度均衡與反套路規範 (Option Length Balance & Anti-Bias)**：
  * **嚴禁「正確答案總是字數最長」**：AI/LLM 撰寫題目時極易把正確答案寫得鉅細靡遺、字數顯著多於干擾項，導致學生即使不懂觀念也能「猜最長的選項」，此現象必須嚴格杜絕。
  * **長度均衡 (Length Parity)**：四個選項的字數長度與語法結構應當相當，長度不宜出現過大落差。
  * **動態變化 (Deliberate Variation)**：題庫中應刻意變化長度模式——偶爾讓正確答案是**字數最短或中等**的選項；亦可刻意豐富干擾選項（Distractors）的技術細節與迷惑性，確保選項長度無法作為預測答案的線索。

---

### 3. PDF & HTML Slide Generation Rules (Direct CLI Compilation)
- **Lecture (A4 直式 Markdown Preview 講義)**:
  ```bash
  node ../scripts/generate_lecture_pdf.js Lecture/en/<name>.md
  node ../scripts/generate_lecture_pdf.js Lecture/tw/<name>.md
  ```

- **Slide (16:9 橫式投影片)**:
  - **統一主題規範 (ase-theme, quiz-theme & syllabus-theme)**：
    - 一般教學投影片全面採用 `theme: ase-theme`（定義於 `themes/ase-theme.css`）。
    - 互動自學測驗題庫簡報（`slide99e_quiz.md`、`slide99t_quiz.md`）全面採用跨課程共用主題 `theme: quiz-theme`（定義於 `gTEACH/themes/quiz-theme.css`，本地透過 `themes/quiz-theme.css` 符號連結或相對路徑直接參照）。
    - 課程綱要與學習地圖簡報（`slide00t_syllabus.md`、`slide00e_syllabus.md`）全面採用跨課程共用主題 `theme: syllabus-theme`（定義於 `gTEACH/themes/syllabus-theme.css`，本地透過 `themes/syllabus-theme.css` 符號連結參照）。風格採用典雅扁平無漸層色系（暖象牙白底 `#faf8f5`、深海軍藍 `#0f2742` 與暖琥珀金 `#b45309`），清單項目**一律使用 `- `（靜態呈現，絕不使用 `* ` 漸進展開）**。
    - 所有主題皆透過專案根目錄 `.marprc.yml` 與 `.vscode/settings.json` 自動載入，投影片 Frontmatter 只需宣告 `theme: <name>`，無須重複嵌入龐大 CSS 區塊。
  - **PDF 編譯指令**：
    ```bash
    # English Slides:
    marp --no-stdin Slide/md-en/<name_e>.md --pdf --allow-local-files -o Slide/pdf-en/<name_e>.pdf

    # Traditional Chinese Slides:
    marp --no-stdin Slide/md-tw/<name_t>.md --pdf --allow-local-files -o Slide/pdf-tw/<name_t>.pdf
    ```
  - **HTML 互動簡報編譯指令 (供 GitHub Pages 使用)**：
    ```bash
    # English HTML:
    marp --no-stdin Slide/md-en/<name_e>.md --html --allow-local-files -o Slide/html/<name_e>.html

    # Traditional Chinese HTML:
    marp --no-stdin Slide/md-tw/<name_t>.md --html --allow-local-files -o Slide/html/<name_t>.html
    ```
  - **清單漸進與同步出現規範 (Incremental & Sub-bullet Rules)**：
    - **第一層項目使用 `*`**：觸發漸進點擊揭示步序（Marp Fragment）。
    - **第二層（及以下）縮排子項目使用 `-`**：作為靜態附屬清單，使大標與其說明細節**同時一起出現**，避免演講者逐條重複空按。
  - **版本控制規範**：`Slide/html/` 目錄納入 Git 版本控制追蹤（not gitignore），供 GitHub Pages 線上互動簡報與入口首頁 (`index.html`) 連結使用。

---

### 4. 投影片口播逐字稿規範 (Speaker Notes Workflow & No-PPTX Rule)
- **不再單獨產生 `handout*.md`**：所有的逐頁課堂/影片口播講稿（Speaker Notes）一律直接以 Marp 註解格式（`<!-- ... -->`）內嵌於投影片 Markdown 源碼（`Slide/md-en/<name>.md` 或 `Slide/md-tw/<name>.md`）中，作為備課與教學提示。
- **口播風格要求**：採用真實課堂/教學影片的口播逐字稿風格（短句、自然對話節奏、呼吸停頓、對齊專有名詞與 CCQ），每頁末尾以「總結這張投影片，請記住這個核心觀念：...」收尾。
- **段落空行排版**：註解中的逐字稿**段落之間務必保留一行空白行（空一行）**，切勿擠成單一密集群塊，以確保在 Markdown 源碼中具備清晰美觀的閱讀節奏。
- **❌ 全面廢除 PPTX 編譯**：之後**一律不需要、嚴禁產生 PPTX 檔案**（既有 PPTX 檔案已全數封存至 `-hidden/pptx/`）。投影片全面以 HTML（線上互動閱讀）與 PDF（離線閱讀與印刷）作為標準交付格式。

---

### 5. 投影片小節過渡頁與標題規範 (Slide Section Lead Pages & Headings)
- **小節過渡頁 (Lead Page)**：每個主要小節開頭均需設置專屬 Lead Page：
  - 使用 `<!-- _class: lead -->`，並設定 `<!-- header: 'Chapter.Section <Short Title>' -->`。
  - 主標題標記章節編號：`# **Chapter.Section <Full Title>**`。
  - 搭配與該主題高度相關的大師名言或經典箴言（`> 引言`）。
  - Lead 頁由 `section.lead` CSS 樣式控制垂直水平置中，並隱藏頁首、頁尾與頁碼。
- **內頁標題不重複編號 (No Redundant Section Numbers in Slide Headings)**：
  - 由於過渡頁已宣告編號，且後續投影片右上角已常駐顯示章節 Header，**進入小節後的投影片標題（`## H2`）切勿重複冠上小節編號**（例如寫 `## Software Development Process & Process Models`，不要寫 `## 2.1 Software Development Process & Process Models`）。

---

### 6. 圖片與圖表生成底色規範 (Figure & Comic Background Consistency Rule)
- **🎨 圖片底色一致性規範 (Background Matching)**：
  - 投影片使用 Gaia 主題預設之淡灰底色（`backgroundColor: #f5f5f5`）。
  - 未來生成任何投影片插圖、架構圖、流程圖、示意圖或漫畫（Comics / Figures / Diagrams，例如使用 `generate_image` 或繪圖腳本）時，**圖片背景色必須與投影片底色完全一致（指定底色為 `#f5f5f5`，或使用透明背景 PNG/SVG）**。
  - 嚴禁生成純白底（`#ffffff`）圖片，避免置入投影片時產生突兀的白框與邊界割裂感。
  - **既有圖片處理原則**：此規則適用於後續新產生的圖片，**既有歷史圖片暫不主動回溯修改**。

---

### 7. 教材編譯與發布兩階段工作流程 (Preparation vs. Upload Workflow)
* **階段一：教材準備階段（日常編修與預覽）**：
  * 當修改或調整講義與投影片內容時（未特別指示進入上傳階段）：
  * **僅編譯產生 HTML 與 PDF**（供本地即時檢視與確認排版）：
    - 講義：`node ../scripts/generate_lecture_pdf.js Lecture/tw/<name>.md`
    - 簡報：`marp --no-stdin Slide/md-tw/<name>.md --html ...` 與 `--pdf ...`
  * ❌ **嚴禁編譯 PPTX**（專案已全面廢除 PPTX 產出）。
  * ❌ **嚴禁主動執行 Git Commit 與 Push**（不上傳、不推播至遠端）。
* **階段二：教材上傳階段（定稿交付與發布）**：
  * 只有在使用者明確指示「**教材上傳**」、「**發布**」或要求「**commit & push**」時：
  * ✅ **HTML 與 PDF 定稿**：確認 `Slide/html/` 與 `Slide/pdf-*/` 檔案為最新版本。
  * ❌ **不產生 PPTX**（維持無 PPTX 原則）。
  * ✅ **執行版本控制同步**：執行 `git add`、`git commit` 與 `git push`，將變更推播至遠端倉庫。

---

### 8. 多欄卡片排版與樣式規範 (Multi-Column Card Guidelines)
* **逐步揭示屬性 (Fragment)**：凡使用多欄卡片（`.two-columns`、`.three-columns`），每個 `<div class="card">` **一律必須加上 `data-marpit-fragment`**，維持適當演講呈現步調。
* **頂部引言引導 (Guiding Quote)**：在多欄卡片容器上方，**必須有一段 `> 引言` 或核心提示句**，先勾勒思維脈絡再展開分欄卡片。
* **卡片底色與層次樣式**：卡片底色採用半透明柔白霧面底（`rgba(255, 255, 255, 0.75)` 搭配微陰影與細邊框），兼顧視覺柔和與立體分層，解決純白刺眼與完全透明空洞的問題。

---

### 9. 箭頭符號與表情符號排版規範 (Arrows & Emoji Typography Rules)
* **嚴禁使用 LaTeX 箭頭語法 (`\rightarrow`, `$\rightarrow$`, `\longleftrightarrow` 等)**：
  * **禁止理由**：
    1. 腳本處理時 `\r` 常被誤判為 Carriage Return，導致字串被腰斬成換行與殘留裸露的 `ightarrow`。
    2. Marp 與各平台 Markdown 預覽器在一般文字中對 LaTeX 數學公式支援不一，容易出現未解析原始碼或字體排版突兀。
  * **標準寫法**：
    - 向右箭頭一律使用標準 Unicode 字符 **`→`**（U+2192）。
    - 雙向箭頭一律使用標準 Unicode 字符 **`↔`**（U+2194）。
    - 箭頭前後保留單一空格（如：`需求規格 → 設計實作 → 測試驗收`、`模組 A ↔ 模組 B`）。
* **表情符號 (Emoji) 避免與離線自包含規範**：
  * **禁止理由**：Marp 預設會將 Unicode Emoji 轉為遠端 `cdn.jsdelivr.net` 的 Twemoji SVG 圖檔，在離線或嚴格網路環境下編譯 PDF 會產生白框破圖或載入失敗。
  * **標準寫法**：
    - 內文與卡片避免使用裝飾性 Unicode Emoji。
    - 狀態或分類提示一律改用純文字標籤（例如：`[最佳實踐]`、`[反模式]`、`[案例]`）或原生 CSS 樣式，維持教材 100% 離線自包含（Self-contained）。

