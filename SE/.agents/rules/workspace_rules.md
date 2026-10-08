# Course Repository Rules & Structure

## 1. Directory Structure

The repository organizes course materials according to strict separation between source files and generated build artifacts:

### Lecture Notes (`Lecture/`)
- `Lecture/en/`: Markdown source files for English lecture notes (e.g., `ch01e_intro.md`) and compiled A4 portrait PDFs (`ch01e_intro.pdf`).
- `Lecture/tw/`: Markdown source files for Traditional Chinese lecture notes (e.g., `ch01t_intro.md`, `ch03t_agile.md`) and compiled A4 portrait PDFs (`ch01t_intro.pdf`).

### Slide Decks (`Slide/`)
- `Slide/md-en/`: Marp Markdown presentation slides formatted in **16:9 widescreen (橫式)** for English courses (e.g., `slide01e_intro.md`) — ignored in git, maintained locally for compilation.
- `Slide/md-tw/`: Marp Markdown presentation slides formatted in **16:9 widescreen (橫式)** for Traditional Chinese courses (e.g., `slide01t_intro.md`) — ignored in git, maintained locally for compilation.
- `Slide/pdf-en/`: Compiled 16:9 PDF presentation slide decks for English courses (e.g., `slide01e_intro.pdf`, `syllabus115-1_graduate.pdf`).
- `Slide/pdf-tw/`: Compiled 16:9 PDF presentation slide decks for Traditional Chinese courses (e.g., `slide01t_intro.pdf`, `syllabus115-1_under.pdf`).

### Image & Media Assets (`img/`, `Video/`)
- `img/`: Shared images, vector SVGs, and diagrams categorized by chapter folder (e.g., `img/ch01/`, `img/ch02/`).
  - **Asset Reference Path**: Markdown files located inside `Lecture/en/`, `Lecture/tw/`, `Slide/md-en/`, and `Slide/md-tw/` MUST reference images using `../../img/<chapter>/<filename>`.
  - **Figure Background Matching**: All newly generated images, diagrams, and comics intended for slides MUST match the slide background color (`#f5f5f5`) or use a transparent background (PNG/SVG) to blend seamlessly without pure white border boxes.
- `Video/`: Video recordings, audio, and local transcripts (completely ignored in git).

### Course Syllabuses
- `syllabus115-1_under.md`: Undergraduate course syllabus (Traditional Chinese, 資訊多元專班) -> compiled to `Slide/pdf-tw/syllabus115-1_under.pdf`.
- `syllabus115-1_graduate.md`: Graduate seminar syllabus (English, 進階軟體工程 ASE) -> compiled to `Slide/pdf-en/syllabus115-1_graduate.pdf`.

---

## 2. Naming Conventions & Section Structure

- **Language Codes**:
  - `e`: English (e.g., `ch01e_intro.md`, `slide01e_intro.md`)
  - `t`: Traditional Chinese (e.g., `ch01t_intro.md`, `slide01t_intro.md`)
- **Pairing Rule**:
  - `Lecture/en/ch01e_intro.md` -> `Lecture/en/ch01e_intro.pdf` (A4 直式 Markdown Preview 樣式)
  - `Lecture/tw/ch01t_intro.md` -> `Lecture/tw/ch01t_intro.pdf` (A4 直式 Markdown Preview 樣式)
  - `Slide/md-en/slide01e_intro.md` -> `Slide/pdf-en/slide01e_intro.pdf` (16:9 橫式投影片)
  - `Slide/md-tw/slide01t_intro.md` -> `Slide/pdf-tw/slide01t_intro.pdf` (16:9 橫式投影片)
- **Lecture Section Numbering vs. Slide Headings**:
  - **Lecture notes (章節編號至第三層)**: All major sections (`##` H2 headings) in Lecture notes must use `Chapter.Section` numbering (e.g. `## 1.1 ...`, `## 1.2 ...`, `## 2.1 ...`). All subsections (`###` H3 headings) must use 3-level numbering `Chapter.Section.SubSection` (e.g. `### 1.1.1 ...`, `### 1.1.2 ...`, `### 1.6.1 ...`).
  - **Slide decks (小節標題不重複編號)**: Each major section begins with a `_class: lead` page carrying the section number and declaring `<!-- header: 'Chapter.Section <Title>' -->`. Subsequent slide titles (`##` H2 headings) inside that section **MUST NOT** repeat the section number (e.g., use `## Software Processes`, not `## 2.1 Software Processes`).
- **Interactive Activity per Section**:
  - Every major section in lecture notes must conclude with at least one interactive item (e.g. CCQ, Pair Discussion, Poll).
- **No Answers in Slides (投影片不附解答)**:
  - Slides are for live classroom instruction and student reasoning. **Never include answer slides or answer keys in slides**. Only present the questions and options. Answers belong strictly in the Lecture handbooks.
- **CCQ Option Length Balance & Anti-Bias (避免答案最長陷阱)**:
  - **嚴禁答案長度最長慣性**：避免正確答案總是選項中文字最長、細節最詳盡者。
  - **長度均衡**：四個選項長度不可落差過大，結構保持對稱。
  - **刻意變化**：隨機變化答案長度模式，偶爾將正確答案設為最短或中等長度，或刻意擴充干擾項細節，確保無法靠「字數最多」猜答案。


---

## 3. PDF Direct Compilation Commands

Both lecture notes and slides must be compiled directly via command line without manual or AI text reconstruction:

```bash
# 1. Compile Lecture Note to A4 Portrait Markdown Preview PDF
node ../scripts/generate_lecture_pdf.js Lecture/en/<filename>.md
node ../scripts/generate_lecture_pdf.js Lecture/tw/<filename>.md

# 2. Compile Slide Deck to 16:9 Widescreen PDF
# English Slides:
marp --no-stdin Slide/md-en/<name_e>.md --pdf --allow-local-files -o Slide/pdf-en/<name_e>.pdf

# Traditional Chinese Slides:
marp --no-stdin Slide/md-tw/<name_t>.md --pdf --allow-local-files -o Slide/pdf-tw/<name_t>.pdf
```
