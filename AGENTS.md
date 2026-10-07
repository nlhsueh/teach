# oTeach 教學教材 Monorepo / 多課程開發規範與架構備忘錄

本檔案由 Antigravity AI 與薛念林教授共同梳理建立，記錄了從 Google Drive 遷移至本機工作區的架構決策與最新進度。

---

## 1. 核心架構決策背景（為什麼搬移至 oTeach？）

1. **脫離 Google Drive 雲端鎖死**：
   * 原先在 Google Drive (`gTEACH/`) 進行 Git 開發，頻繁發生 `.git/index.lock` 鎖死、雲端雙向同步衝突（產生如 `demoBMI 2` 副本）與極度卡頓問題。
2. **職責徹底分離原則**：
   * **`~/oTeach/` (本機 SSD + Git + GitHub)**：
     - 專門存放「教材源碼（Markdown、CSS、產出之 HTML/PDF、範例程式碼、`AGENTS.md`）」。
     - 完全由 Git 與 GitHub 進行版本控制，離線操作飛速、零衝突。
   * **`Google Drive (gTEACH/gTeachXX)` (雲端硬碟)**：
     - 專門存放「不進 GitHub 之非公開私密資料」（如未公開之期中期末考題、標準解答、評分表、未剪輯大錄影檔、大型 zip 包）。
     - Google Drive 端的重複 Git 歷史與源碼已移至 `_backup_old_git/` 封存，不再受 Git 監控。

---

## 2. 目前已完成的遷移與目錄結構

目錄實體路徑：`/Users/nick-mini-26/oTeach/`

```
~/oTeach/
  ├── themes/                      <-- ★ 跨課程共用主題庫
  │     ├── quiz-theme.css         (全章節即時互動自我測驗樣式)
  │     ├── syllabus-theme.css     (課程大綱與導覽樣式)
  │     └── academic-theme.css     (學術簡報樣式)
  │
  ├── TeachUX/                    <-- 使用者體驗設計 (UX Design) 課程工作區
  │     ├── Slide/                 (投影片 Markdown、HTML、PDF)
  │     ├── Lecture/               (講義)
  │     ├── img/                   (教學圖檔)
  │     ├── index.html             (UX 課程門戶入口)
  │     └── .marprc.json           (配置引入 ../themes/)
  │
  └── TeachSQA/                   <-- 軟體品質保證 (SQA) 課程工作區
        ├── Slide/                 (投影片 Markdown、HTML、PDF)
        ├── Lecture/               (講義)
        ├── LabDemo/               (Java 實作範例程式碼)
        ├── img/                   (教學圖檔)
        ├── index.html / lab.html  (SQA 課程門戶入口)
        └── .marprc.json           (配置引入 ../themes/)
```

---

## 3. 重要技術規格與標準

1. **投影片撰寫規格 (Marp)**：
   * 題庫與隨堂測驗一律使用 **100% 純 Markdown 格式**（禁止手寫 `<div class="quiz-layout">` 等 HTML 標籤），由主題腳本透過 Progressive Enhancement 自動原地增強為即時點擊作答回饋與解析展開。
   * 選項清單一律直接顯示（使用 `-` 符號，不使用 `*` 漸進逐條淡入）。
   * 投影片頂部 Header 導覽一律採用純目錄下拉選單（`nav-dropdown`），預設隱藏，hover/click 時展開。
2. **日常工作流程 SOP**：
   * **開工**：`cd ~/oTeach/<課程> && git pull`
   * **開發**：在本機 SSD 快速編輯 Markdown、編譯投影片。
   * **收工**：`git add . && git commit -m "..." && git push`

---

## 4. 下一步規劃藍圖

* **全課程統一教學門戶 (Portal 模式)**：
  - 未來可在 `~/oTeach/index.html` 建立統整入口首頁，展示薛教授所有開設課程（UX, SQA, ASE...）。
  - 單一 GitHub Pages 網址分流給各班級：
    - `https://nlhsueh.github.io/teach/` (總首頁)
    - `https://nlhsueh.github.io/teach/ux/` (給 UX 班級)
    - `https://nlhsueh.github.io/teach/sqa/` (給 SQA 班級)
