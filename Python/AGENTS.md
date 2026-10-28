# AGENTS.md

## Repository Structure & Build Guidelines for gTeachPython

### 1. Structure
- `Lecture/source/`: Markdown source files for Python lecture notes.
- `Lecture/pdf/`: Generated **A4 portrait (直式) document-style** lecture handout PDFs.
- `Slide/source/`: Marp Markdown source files for **16:9 widescreen (橫式)** presentation slides.
- `Slide/pdf/`: Generated PDF slides.
- `img/`: Shared image assets (`../../img/<chapter>/...`).

---

### 2. 互動題目 (CCQ) 生命週期與同步標準程序 (CCQ Lifecycle & Sync Workflow)

* **階段 1 (初創無 QR 狀態)**：
  * 撰寫新 CCQ 題目時一律為草稿狀態，只需撰寫標準題型、選項與答案解析。
  * **初創時一律為「無 QR」狀態**，不需要手動放 QR Code 圖片或 `[線上作答]` 連結。
* **階段 2 (執行同步)**：
  * 題目撰寫完成後，執行統一同步指令：
    ```bash
    python3 scripts/sync_iActivity.py --course gTeachPython
    ```
  * 同步腳本會自動解析題庫、匯出至 `nickedupocket/public/courses/gTeachPython.md`、產生 QR Code 圖片，並自動回寫嵌入註解編號與 `[課堂互動]` 連結至講義（講義不放 QR Code），投影片則同時嵌入 `[課堂互動]` 連結與 QR 圖檔。
* **階段 3 (題目修改重同步)**：
  * 若後續修改題目內容，保留原有的 `<!-- id: python-chXX-ccqN -->` 註解，再次執行 `sync_iActivity.py` 即可自動冪等更新。
* **階段 4 (編譯 PDF)**：
  * 同步完成後再執行 PDF 編譯。

---

### 3. PDF Generation Rules
- **Lecture (A4 講義手冊 PDF)**:
  ```bash
  node ../scripts/generate_lecture_pdf.js Lecture/source/<name>.md
  ```

- **Slide (16:9 投影片 PDF)**:
  ```bash
  marp --no-stdin Slide/source/<name>.md --pdf --allow-local-files -o Slide/pdf/<name>.pdf
  ```
