---
marp: true
theme: gaia
size: 16:9
paginate: true
html: true
header: '<div class="hdr-wrap"><span class="hdr-title">Code Immunity Boost：變異測試遊戲化學習系統之設計與實作</span><div class="nav-dropdown"><button class="nav-btn">章節導覽 ▾</button><div class="nav-menu"><a href="#2">破題：手寫地獄 vs. 程式免疫強化</a><a href="#3">簡報大綱</a><a href="#4">1. 研究動機與問題</a><a href="#6">2. 背景知識與文獻比較</a><a href="#8">3. CIB 遊戲設計與架構</a><a href="#13">4. 先導實驗與問卷評估</a><a href="#18">5. 結論與未來研究</a></div></div></div>'
footer: '薛念林（Nien-Lin Hsueh）*、Zeng Hung Xuan、Bilegjargal Daramsenge · 逢甲大學資工系 · IJIET 2023'
---

<style>
@import url('https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700;800&family=Noto+Sans+TC:wght@400;500;700;900&family=JetBrains+Mono:wght@500;600&display=swap');

:root {
  --navy: #1b365d;
  --navy-dark: #102442;
  --accent: #8c1d40;
  --accent-soft: #fdf2f5;
  --teal: #0f766e;
  --teal-soft: #f0fdfa;
  --slate-900: #0f172a;
  --slate-700: #334155;
  --slate-500: #64748b;
  --slate-200: #e2e8f0;
  --slate-100: #f1f5f9;
  --surface: #ffffff;
}

section {
  background: var(--surface);
  color: var(--slate-900);
  font-family: 'Noto Sans TC', 'PingFang TC', 'Inter', -apple-system, sans-serif;
  font-size: 20px;
  line-height: 1.5;
  padding: 68px 54px 48px 54px;
  box-sizing: border-box;
}

/* Header & Navigation Dropdown */
header {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  height: 44px;
  padding: 0 54px;
  background: var(--navy);
  color: #ffffff;
  font-size: 13.5px;
  font-weight: 600;
  display: flex;
  align-items: center;
  box-sizing: border-box;
  overflow: visible !important;
  z-index: 50;
}

.hdr-wrap {
  width: 100%;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.hdr-title {
  letter-spacing: 0.01em;
  opacity: 0.94;
}

.nav-dropdown {
  position: relative;
  display: inline-block;
  padding-bottom: 6px;
  margin-bottom: -6px;
}

.nav-btn {
  background: rgba(255, 255, 255, 0.14);
  color: #ffffff;
  border: 1px solid rgba(255, 255, 255, 0.28);
  border-radius: 6px;
  padding: 3px 10px;
  font-size: 12px;
  font-weight: 600;
  cursor: pointer;
  font-family: inherit;
}

.nav-menu {
  display: none;
  position: absolute;
  right: 0;
  top: 100%;
  min-width: 235px;
  background: #ffffff;
  border: 1px solid var(--slate-200);
  border-radius: 8px;
  box-shadow: 0 10px 24px rgba(15, 23, 42, 0.18);
  padding: 6px 0;
  z-index: 200;
}

.nav-dropdown:hover .nav-menu,
.nav-dropdown.open .nav-menu {
  display: block;
}

.nav-menu a {
  display: block;
  padding: 7px 14px;
  color: var(--slate-700);
  text-decoration: none;
  font-size: 12.5px;
  font-weight: 500;
  line-height: 1.35;
}

.nav-menu a:hover {
  background: var(--slate-100);
  color: var(--navy);
}

/* Footer & Pagination */
footer {
  position: absolute;
  left: 54px;
  bottom: 14px;
  font-size: 12.5px;
  color: var(--slate-500);
  font-weight: 500;
}

section::after {
  position: absolute;
  right: 54px;
  bottom: 14px;
  font-size: 12.5px;
  font-weight: 700;
  color: var(--navy);
  content: attr(data-marpit-pagination) ' / ' attr(data-marpit-pagination-total);
}

/* Headings */
h1 {
  color: var(--navy);
  font-size: 1.7em;
  font-weight: 800;
  line-height: 1.24;
  margin: 0 0 12px 0;
}

h2 {
  color: var(--navy);
  font-size: 1.24em;
  font-weight: 700;
  line-height: 1.26;
  margin: 0 0 13px 0;
  padding-bottom: 6px;
  border-bottom: 2.5px solid var(--navy);
  display: flex;
  align-items: center;
  gap: 8px;
}

h3 {
  color: var(--accent);
  font-size: 0.96em;
  font-weight: 700;
  margin: 4px 0 6px 0;
}

p { margin: 0 0 8px 0; }
ul, ol { margin: 4px 0 8px 0; padding-left: 22px; }
li { margin-bottom: 5px; line-height: 1.44; }
li > ul { margin-top: 3px; margin-bottom: 3px; }
li > ul > li { font-size: 0.92em; margin-bottom: 3px; }
strong { color: var(--slate-900); }
a { color: #2563eb; text-decoration: none; }
a:hover { text-decoration: underline; }

/* Inline code without background */
:not(pre, marp-pre) > code {
  background: transparent !important;
  border: none !important;
  padding: 0 !important;
  font-family: 'JetBrains Mono', monospace;
  font-size: 0.9em;
  font-weight: 600;
  color: #475569;
}

h1 code, h2 code, h3 code { color: #0b3c5d; }
section table th { background: var(--navy) !important; color: #ffffff !important; }
section table th code, section table th strong { color: #ffffff !important; }
section.lead code, section.closing code { color: #bae6fd !important; }
section.lead strong, section.closing strong { color: #ffffff !important; }

/* Lead Slide */
section.lead {
  background: linear-gradient(135deg, #102442 0%, #1b365d 62%, #294c7a 100%);
  color: #ffffff;
  display: flex;
  flex-direction: column;
  justify-content: center;
  padding: 54px 72px;
}

section.lead header, section.lead footer, section.lead::after { display: none !important; }

section.lead .badge {
  display: inline-block;
  align-self: flex-start;
  background: rgba(255, 255, 255, 0.14);
  border: 1px solid rgba(255, 255, 255, 0.32);
  color: #f8fafc;
  font-size: 0.72em;
  font-weight: 600;
  letter-spacing: 0.06em;
  padding: 5px 14px;
  border-radius: 999px;
  margin-bottom: 18px;
}

section.lead h1 {
  color: #ffffff;
  font-size: 2.0em;
  font-weight: 800;
  line-height: 1.26;
  margin-bottom: 16px;
  text-align: left;
}

section.lead .subtitle {
  color: #cbd5e1;
  font-size: 0.95em;
  line-height: 1.54;
  margin-bottom: 26px;
  max-width: 940px;
}

section.lead .meta-box {
  border-left: 4px solid #f43f5e;
  padding-left: 18px;
  color: #e2e8f0;
  font-size: 0.85em;
  line-height: 1.62;
}

section.lead .meta-box strong { color: #ffffff; }
section.lead .grant { margin-top: 22px; font-size: 0.72em; color: #94a3b8; }

/* Closing Slide */
section.closing {
  background: linear-gradient(135deg, #102442 0%, #1b365d 65%, #8c1d40 100%);
  color: #ffffff;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  text-align: center;
  padding: 54px 72px;
}

section.closing header, section.closing footer, section.closing::after { display: none !important; }
section.closing h1 { color: #ffffff; font-size: 2.25em; margin-bottom: 12px; }
section.closing p { color: #e2e8f0; }

section.closing .contact-card {
  margin-top: 22px;
  background: rgba(255, 255, 255, 0.12);
  border: 1px solid rgba(255, 255, 255, 0.25);
  border-radius: 12px;
  padding: 18px 36px;
  font-size: 0.85em;
  line-height: 1.7;
  color: #f8fafc;
}

/* Grids & Layouts */
.two-col { display: grid; grid-template-columns: 1fr 1fr; gap: 20px; align-items: stretch; }
.three-col { display: grid; grid-template-columns: repeat(3, 1fr); gap: 15px; align-items: stretch; }
.split64 { display: grid; grid-template-columns: 56% 42%; gap: 2%; align-items: center; }
.split55 { display: grid; grid-template-columns: 49% 49%; gap: 2%; align-items: center; }

/* Cards & Callouts */
.card {
  background: #ffffff;
  border: 1px solid var(--slate-200);
  border-top: 3.5px solid var(--navy);
  border-radius: 8px;
  padding: 13px 17px;
  box-shadow: 0 2px 6px rgba(15, 23, 42, 0.05);
  box-sizing: border-box;
}

.card.accent { border-top-color: var(--accent); }
.card.teal { border-top-color: var(--teal); }

.kpi-card {
  background: var(--slate-100);
  border: 1px solid var(--slate-200);
  border-left: 4px solid var(--navy);
  border-radius: 8px;
  padding: 9px 14px;
  box-sizing: border-box;
}

.kpi-card.accent { border-left-color: var(--accent); background: var(--accent-soft); }
.kpi-card.teal { border-left-color: var(--teal); background: var(--teal-soft); }

.kpi-val { font-size: 1.38em; font-weight: 800; color: var(--navy); line-height: 1.15; margin-bottom: 3px; }
.kpi-card.accent .kpi-val { color: var(--accent); }
.kpi-card.teal .kpi-val { color: var(--teal); }
.kpi-label { font-size: 0.74em; color: var(--slate-700); line-height: 1.34; }

.callout {
  background: #f8fafc;
  border-left: 4px solid var(--accent);
  border-radius: 0 8px 8px 0;
  padding: 9px 15px;
  margin-top: 9px;
  font-size: 0.85em;
  color: var(--slate-700);
}

.callout.teal { border-left-color: var(--teal); background: var(--teal-soft); }
.callout strong { color: var(--navy); }

/* Tables */
table {
  width: 100%;
  border-collapse: collapse;
  font-size: 0.74em;
  margin: 6px 0;
  background: #ffffff;
  border: 1px solid var(--slate-200);
}

th {
  background: var(--navy);
  color: #ffffff;
  font-weight: 700;
  padding: 5px 8px;
  text-align: left;
  border: 1px solid var(--navy);
}

td {
  padding: 5px 8px;
  border: 1px solid var(--slate-200);
  vertical-align: middle;
  line-height: 1.34;
}

tr:nth-child(even) td { background: #f8fafc; }

/* Formula Box */
.formula-strip {
  display: grid;
  grid-template-columns: 1fr 1.25fr;
  gap: 14px;
  margin-top: 8px;
}

.formula-box {
  background: #f8fafc;
  border: 1.5px solid #cbd5e1;
  border-left: 4px solid var(--navy);
  border-radius: 8px;
  padding: 8px 14px;
  display: flex;
  justify-content: center;
  align-items: center;
  font-family: 'Georgia', 'Times New Roman', serif;
  font-size: 0.92em;
  color: var(--slate-900);
}

.formula-box.teal { border-left-color: var(--teal); background: var(--teal-soft); }
.formula-box.accent { border-left-color: var(--accent); background: var(--accent-soft); }

.frac {
  display: inline-flex;
  flex-direction: column;
  align-items: center;
  vertical-align: middle;
  margin: 0 5px;
  line-height: 1.08;
}

.frac-num { border-bottom: 1.5px solid var(--slate-900); padding: 0 6px 2px 6px; }
.frac-den { padding: 2px 6px 0 6px; }

/* Outline Grid */
.outline-grid { display: grid; grid-template-columns: 1fr 1fr; gap: 14px 24px; margin-top: 8px; }

.outline-item {
  display: flex;
  align-items: flex-start;
  gap: 12px;
  background: #f8fafc;
  border: 1px solid var(--slate-200);
  border-left: 4px solid var(--navy);
  border-radius: 8px;
  padding: 12px 16px;
}

.outline-num {
  background: var(--navy);
  color: #ffffff;
  font-weight: 800;
  font-size: 0.85em;
  width: 28px;
  height: 28px;
  border-radius: 6px;
  display: flex;
  align-items: center;
  justify-content: center;
  flex-shrink: 0;
  margin-top: 2px;
}

.outline-body { font-size: 0.85em; line-height: 1.4; }
.outline-body a { color: var(--navy); font-weight: 700; font-size: 1.05em; }

/* Figures & Hover Zoom */
.fig-box {
  background: #ffffff;
  border: 1px solid var(--slate-200);
  border-radius: 8px;
  padding: 8px;
  text-align: center;
  box-shadow: 0 2px 6px rgba(15, 23, 42, 0.05);
}

.fig-box img {
  max-width: 100%;
  height: auto;
  display: block;
  margin: 0 auto;
  border-radius: 4px;
  transition: transform 0.25s ease, box-shadow 0.25s ease;
}

.split64 .left img:hover, .split55 .left img:hover {
  transform: scale(1.22);
  transform-origin: left bottom;
  box-shadow: 0 12px 28px rgba(15, 23, 42, 0.22);
  position: relative;
  z-index: 30;
}

.split64 .right img:hover, .split55 .right img:hover {
  transform: scale(1.22);
  transform-origin: right bottom;
  box-shadow: 0 12px 28px rgba(15, 23, 42, 0.22);
  position: relative;
  z-index: 30;
}

.fig-cap { font-size: 0.72em; color: var(--slate-500); margin-top: 5px; font-weight: 500; }

.rq-tag {
  display: inline-block;
  background: var(--accent);
  color: #ffffff;
  font-size: 0.72em;
  font-weight: 700;
  padding: 2px 8px;
  border-radius: 4px;
  margin-right: 6px;
  vertical-align: middle;
}

.small-text { font-size: 0.82em; }

/* Incremental RQ Grid (3 Cards) */
.rq-stage ul {
  display: flex;
  flex-direction: column;
  gap: 14px;
  list-style: none !important;
  padding: 0 !important;
  margin: 10px 0 0 0 !important;
}

.rq-stage li { margin: 0 !important; padding: 0 !important; list-style: none !important; }
.rq-stage li::marker { content: ""; }

.rq-card {
  display: flex;
  align-items: center;
  gap: 16px;
  background: #ffffff;
  border: 1px solid var(--slate-200);
  border-left: 5px solid var(--navy);
  border-radius: 10px;
  padding: 11px 18px;
  box-shadow: 0 2px 8px rgba(15, 23, 42, 0.06);
  box-sizing: border-box;
}

.rq-card.teal { border-left-color: var(--teal); }
.rq-card.accent { border-left-color: var(--accent); }
.rq-card img { width: 82px; height: 82px; flex-shrink: 0; border-radius: 10px; }

.rq-hook { font-size: 0.92em; font-weight: 800; color: var(--navy); line-height: 1.3; margin-bottom: 4px; }
.rq-card.teal .rq-hook { color: var(--teal); }
.rq-card.accent .rq-hook { color: var(--accent); }
.rq-q { font-size: 0.8em; color: var(--slate-700); line-height: 1.42; }

/* Mini Bar Rows */
.bar-row {
  display: grid;
  grid-template-columns: 155px 1fr 82px;
  align-items: center;
  gap: 10px;
  margin-bottom: 7px;
  font-size: 0.76em;
}

.bar-track {
  background: var(--slate-100);
  border-radius: 5px;
  height: 17px;
  overflow: hidden;
  border: 1px solid var(--slate-200);
}

.bar-fill { height: 100%; border-radius: 4px; background: var(--navy); }
.bar-fill.teal { background: var(--teal); }
.bar-fill.accent { background: var(--accent); }
.bar-pct { font-weight: 700; text-align: right; color: var(--slate-900); white-space: nowrap; }

/* Benchmark Chips */
.chip-row {
  display: flex;
  flex-wrap: wrap;
  gap: 8px;
  margin-top: 8px;
}

.chip {
  background: var(--slate-100);
  border: 1px solid var(--slate-200);
  color: var(--navy);
  font-size: 0.74em;
  font-weight: 700;
  padding: 4px 11px;
  border-radius: 999px;
}

.future-strip { display: grid; grid-template-columns: repeat(3, 1fr); gap: 12px; margin-top: 10px; }

.future-pill {
  background: #f8fafc;
  border: 1px solid var(--slate-200);
  border-left: 4px solid var(--teal);
  border-radius: 8px;
  padding: 8px 12px;
  font-size: 0.74em;
  line-height: 1.4;
  color: var(--slate-700);
}

.future-pill strong { color: var(--navy); }
</style>

<!-- _class: lead -->

<div class="badge">IJIET 2023 · Vol. 13, No. 7 · 軟體測試遊戲化教育</div>

# 變異測試遊戲化學習系統之設計與實作

<div class="subtitle">
<strong>Code Immunity Boost (CIB)</strong> ＆ <strong>Code Vaccine Incubator (CVI)</strong>：以「疫苗研發與免疫防禦」為主題的互動式變異測試教學平台
</div>

<div class="meta-box">
<strong>薛念林（Nien-Lin Hsueh）*</strong>、<strong>Zeng Hung Xuan</strong>、<strong>Bilegjargal Daramsenge</strong><br>
逢甲大學資訊工程學系（Department of Information Engineering and Computer Science, Feng Chia University）<br>
<code>nlhsueh@fcu.edu.tw</code> · DOI: <code>10.18178/ijiet.2023.13.7.1916</code>
</div>

<div class="grant">
發表於 International Journal of Information and Education Technology (pp. 1150–1155, July 2023) · 科技部計畫：MOST 110-2221-E-035-031-MY2
</div>

---

## 破題：深陷手寫變異體地獄……還是強化「程式免疫力」？

<div class="fig-box" style="padding: 6px; margin-bottom: 10px; background: #fbf9f2;">
<img src="./img/mutation_hook.jpg" alt="手寫變異測試 vs Code Immunity Boost" style="max-height: 415px; border-radius: 6px;">
</div>

<div class="callout" style="margin-top: 6px; padding: 9px 16px;">
<strong>核心概念：</strong>傳統手寫與人工追蹤大量變異體極易耗盡學生的學習熱情。<strong>Code Immunity Boost (CIB)</strong> 將變異測試轉化為<strong>疫苗研發任務</strong>——讓學生化身<strong>白血球</strong>（測試案例）擊殺<strong>疫苗</strong>（變異體），全面提升<strong>人體</strong>（程式）品質！
</div>

---

## 簡報大綱

<div class="outline-grid">

<div class="outline-item">
<div class="outline-num">1</div>
<div class="outline-body">

[**研究動機與核心問題**](#4)
軟體測試教學為何需要遊戲化，以及本先導研究欲探討之三大問題（RQ1–RQ3）。

</div>
</div>

<div class="outline-item">
<div class="outline-num">2</div>
<div class="outline-body">

[**變異測試基礎與文獻比較**](#6)
變異體擊殺流程、變異分數公式，以及與 Code Defenders 之對比缺口。

</div>
</div>

<div class="outline-item">
<div class="outline-num">3</div>
<div class="outline-body">

[**CIB 遊戲設計與系統架構**](#8)
免疫系統隱喻、Octalysis 三大核心驅力、脆弱度分級關卡與六大系統模組。

</div>
</div>

<div class="outline-item">
<div class="outline-num">4</div>
<div class="outline-body">

[**先導實驗：測試產量與有效性**](#13)
手寫對照組 vs. CIB 實驗組之測試提交量與有效／無效案例動態分析。

</div>
</div>

<div class="outline-item">
<div class="outline-num">5</div>
<div class="outline-body">

[**學習滿意度問卷與質性洞察**](#16)
五點李克特量表評估：學習動機 (Q1)、專注力 (Q2) 與學習成效 (Q3)。

</div>
</div>

<div class="outline-item">
<div class="outline-num">6</div>
<div class="outline-body">

[**結論與未來展望**](#18)
RQ1–RQ3 核心發現視覺化統整，以及整合至 Online Judge 之推廣藍圖。

</div>
</div>

</div>

---

## 1.1 研究動機：為何軟體測試教育亟需遊戲化？

<div class="fig-box" style="padding: 10px 12px; margin-bottom: 10px;">
<img src="./img/diag1_motivation_zh.svg" alt="傳統變異測試教學 vs CIB 遊戲化學習" style="max-height: 365px;">
</div>

<div class="callout">
<strong>研究背景：</strong>涵蓋 156 篇軟體工程遊戲化研究的系統性回顧 [15] 指出，遊戲化能顯著提升課程參與度與專業知識；然而相較於系統設計與開發流程，<strong>軟體測試領域的遊戲化教學工具仍極度匱乏</strong>。
</div>

---

## 1.2 研究目標與三大研究問題

本先導實驗探討核心問題*「學生如何透過 CIB 工具學習變異測試？」*，聚焦三大面向*（逐步展開）*：

<div class="rq-stage">

* <div class="rq-card teal"><img src="./img/rq1_icon.svg" alt="RQ1 測試案例產量與品質"><div><div class="rq-hook"><span class="rq-tag" style="background:#0f766e;">RQ1</span> 遊戲化自動化環境能否幫助學生寫出更多、更有效的測試案例？</div><div class="rq-q"><strong>相較於傳統手寫變異測試，CIB 如何影響學生的測試案例總提交數與有效測試案例產出</strong>？</div></div></div>
* <div class="rq-card accent"><img src="./img/rq2_icon.svg" alt="RQ2 即時回饋與試錯機制"><div><div class="rq-hook"><span class="rq-tag">RQ2</span> 為何實驗組的無效提交比例反而較高——這對學習有何意義？</div><div class="rq-q"><strong>CIB 的即時自動化回饋如何影響無效提交率</strong>，以及在不同題目難度下的反覆試錯除錯行為？</div></div></div>
* <div class="rq-card"><img src="./img/rq3_icon.svg" alt="RQ3 動機、專注與成效"><div><div class="rq-hook"><span class="rq-tag" style="background:#1b365d;">RQ3</span> 學生是否更投入、更專注，且更有信心將變異測試應用於實務？</div><div class="rq-q"><strong>CIB 對學生的學習動機 (Q1)、專注度 (Q2) 與自評學習成效 (Q3)</strong> 有何具體影響？</div></div></div>

</div>

---

## 2.1 背景知識：變異測試（Mutation Testing）運作機制

<div class="fig-box" style="padding: 8px 12px; margin-bottom: 10px;">
<img src="./img/diag2_mutation_cycle_zh.svg" alt="變異測試執行循環" style="max-height: 270px;">
</div>

<div class="formula-strip">
<div class="formula-box">
<i>ms</i> &nbsp;=&nbsp; <span class="frac"><span class="frac-num"><i>killed</i></span><span class="frac-den"><i>all</i> − <i>equiv</i></span></span> &nbsp; ∈ [0.0, 1.0]
</div>
<div class="callout" style="margin-top: 0;">
<strong>變異分數 (Mutation Score, ms)：</strong>遭擊殺變異體佔所有非等價變異體之比例 [17]。<strong>等價變異體 (equiv)</strong> 不改變原程式行為，無法被任何測試擊殺；<code>ms</code> 越高代表測試套件偵錯力越強。
</div>
</div>

---

## 2.2 文獻回顧：Code Defenders 與研究缺口

**Code Defenders** [16, 18, 19] 首創雙人對戰式變異測試遊戲（攻擊者寫變異體、防禦者寫測試案例），但在課堂實際導入時面臨以下挑戰：

| 教學模式 | 進行方式 | 難度控制 | 回饋機制 | 主要限制／優勢 |
| :--- | :--- | :--- | :--- | :--- |
| **傳統手寫教學** | 單人紙筆模擬 | 缺乏分級 | 人工追蹤比對與手算 | 工作量極為繁重，題目一難便迅速喪失學習動機 |
| **Code Defenders [16, 18, 19]** | 雙人對戰（攻／守）＋單人電腦模式 | 單人模式**缺乏明確難度指標** | 對戰回合積分 | 雙方**能力落差過大**時易使一方挫敗；電腦模式難以取代雙人平衡 |
| **本研究：CIB ＋ CVI** | **單人結構化闖關** | **以脆弱度量化四階難度** | **Python 即時自動評分與免疫力進度條** | **無需配對、結合疫苗研發敘事、雙角色扮演與 CVI 自動變異體池** |

<div class="callout teal">
<strong>填補研究缺口：</strong>CIB 透過自建變異體生成器（<strong>CVI</strong>）與明確的量化難度指標（<strong>變異體脆弱度</strong>），徹底消除雙人程度落差，打造循序漸進的單人變異測試學習體驗。
</div>

---

## 3.1 遊戲隱喻：疫苗、白血球與人體防禦

<div class="split55">
<div class="left">

<div class="fig-box">
<img src="./img/fig1_analogy.png" alt="Fig. 1: 程式、測試案例與變異體之免疫隱喻" style="max-height: 410px;">
<div class="fig-cap">Fig. 1：以「疫苗提升人體免疫力」類比變異測試核心關係</div>
</div>

</div>
<div class="right small-text">

### 🧬 免疫防禦 ＝ 軟體品質強化
- **人體（Human）⇄ 程式（Program）**：我們欲保護並強化品質的目標軟體。
- **疫苗（Vaccine）⇄ 變異體（Mutant）**：刻意植入微小變異以刺激防禦機制。
- **白血球（Leukocyte）⇄ 測試案例（Test Case）**：負責偵測並消滅變異體的守護者。
- **病原體（Pathogen）⇄ 程式錯誤（Error）**：經由強化後的測試套件預先防範。

<div class="formula-box teal" style="margin-top: 8px; padding: 7px 12px; font-size: 0.9em;">
<strong>免疫力（Immunity）</strong> &nbsp;=&nbsp; 變異分數 (<i>ms</i>)
</div>
<div class="formula-box accent" style="margin-top: 7px; padding: 7px 12px; font-size: 0.9em;">
<strong>疫苗保護力（Vaccine Efficacy）</strong> &nbsp;=&nbsp; 1 − <i>fragility</i>
</div>

</div>
</div>

---

## 3.2 遊戲化核心：Octalysis 三大驅力與基準程式庫

CIB 融入 **Octalysis 遊戲化八角框架中的三大核心驅力**，兼顧內在使命感與外在成就回饋：

<div class="three-col">
<div class="card small-text">

### 🌍 1. 史詩意義（Meaning）
- 受 COVID-19 疫情啟發，設定病原體肆虐之故事背景。
- 學生研發疫苗（變異體）並訓練白血球（測試案例）保護程式，賦予練習**真實使命感**。

</div>
<div class="card teal small-text">

### 🏆 2. 發展與成就（Accomplishment）
- 以**免疫力**（`ms`）與**疫苗保護力**（`1 − fragility`）作為直覺分數指標。
- 透過**進度條**與星等評級激發「填滿空白」的通關動力，同時內化兩大測試指標。

</div>
<div class="card accent small-text">

### 🎭 3. 創意與賦權（Empowerment）
- 學生可自由扮演**白血球**與**疫苗**兩種角色。
- 測試案例與變異體的寫法多元開放，鼓勵學生結合軟體知識反覆精進策略。

</div>
</div>

<div class="card" style="margin-top: 12px; padding: 10px 16px;">
<div style="font-size: 0.8em; color: var(--slate-700);"><strong style="color: var(--navy);">🧪 基準程式與 Code Vaccine Incubator (CVI)：</strong>本研究開發 <strong>CVI</strong> 變異體生成工具，針對 7 支變異測試經典基準程式 [20] 建置大量變異體題庫：</div>
<div class="chip-row">
<span class="chip">Triangle</span>
<span class="chip">Computing the Median</span>
<span class="chip">Euclidean GCD</span>
<span class="chip">Fibonacci Search</span>
<span class="chip">Binary Search</span>
<span class="chip">Interpolation Search</span>
<span class="chip">Leap Year</span>
</div>
</div>

---

## 3.3 漸進式關卡設計與難度分級

<div class="split64">
<div class="left">

<div class="fig-box">
<img src="./img/fig2_levels.png" alt="Fig. 2: CIB 關卡選擇畫面" style="max-height: 400px;">
<div class="fig-cap">Fig. 2：CIB 漸進式關卡介面——顯示評級、題目難度與通關門檻</div>
</div>

</div>
<div class="right small-text">

### 🎯 以脆弱度（Fragility）劃分四階難度
- 以變異體之**脆弱度**作為客觀難度依據，由淺入深劃分四個等級：
  - `Easy` ➔ `Medium` ➔ `Hard` ➔ `Difficult`
- **闖關解鎖機制**：
  1. **評級與鎖定狀態**：通關後顯示對應星等（如 `S` 級），未解鎖關卡顯示鎖頭圖示。
  2. **關卡資訊**：清楚呈現關卡編號、基準程式名稱與難度標籤。
  3. **雙重通關條件**：
     - **基本條件（Basic）**：達標即可過關並解鎖下一關（如 `ms ≥ 50%`）。
     - **進階條件（Better）**：鼓勵追求高分與深度測試（如 `ms ≥ 70%–80%`）。

</div>
</div>

---

## 3.4 實際遊玩示範：扮演「白血球」角色

<div class="split55">
<div class="left">

<div class="fig-box">
<img src="./img/fig3_leukocyte_ui.png" alt="Fig. 3: 白血球角色遊玩介面" style="max-height: 330px;">
<div class="fig-cap">Fig. 3：白血球介面——(1) 原始程式、(2) 變異體檢視、(3) 測試編輯區</div>
</div>

<div class="callout teal" style="font-size: 0.78em; margin-top: 8px;">
<strong>技術實作：</strong>基於 <strong>Python</strong> 與標準 <code>unittest</code> 框架，學生可並排比對原始碼與變異體，即時撰寫並提交單元測試。
</div>

</div>
<div class="right small-text">

### 🛡️ 闖關情境範例（共 10 個變異體 m<sub>1</sub>–m<sub>10</sub>）
- **基本通關**：擊殺 ≥ 5 個變異體（`Immunity ≥ 0.5`）。
- **高分獎勵**：擊殺 ≥ 8 個變異體（`Immunity ≥ 0.8`）。

| 回合 | 測試案例 | 擊殺之變異體 | 免疫力 | 判定結果 |
| :---: | :---: | :--- | :---: | :---: |
| 1 | `t1` | m<sub>1</sub>, m<sub>2</sub> | `0.2` | 未通關 |
| 2 | `t2` | m<sub>1</sub>, m<sub>3</sub>–m<sub>6</sub> | `0.5` | **通關** |
| 3 | `t3` | m<sub>1</sub>–m<sub>8</sub> | **`0.8`** | **高分通關** |

- **即時回饋循環**：學生免去手動追蹤輸出，依系統回饋迅速將免疫力從 `0.2` 推進至 `0.8`。

</div>
</div>

---

## 3.5 CIB 系統架構與六大核心模組

<div class="split55">
<div class="left">

<div class="fig-box">
<img src="./img/fig4_architecture.png" alt="Fig. 4: Code Immunity Boost 系統架構圖" style="max-height: 400px;">
<div class="fig-cap">Fig. 4：Code Immunity Boost (CIB) 六大模組系統架構</div>
</div>

</div>
<div class="right small-text">

### ⚙️ 六大核心模組職責
1. **Code Editor**：前端程式碼編輯器，供學生撰寫 Python `unittest` 測試案例或變異體。
2. **Code Runner**：負責編譯與執行提交程式，將執行結果送往 `Metrics Computer`，若有語法或執行錯誤則即時回傳 **Error Message**。
3. **Metrics Computer**：執行變異測試並計算測試案例之**變異分數**與變異體之**脆弱度**。
4. **Game Manager**：提供關卡資訊給前端顯示、計算遊戲得分並判定是否通關。
5. **Code Database**：儲存與管理使用者撰寫之測試案例與變異體。
6. **Game Database**：儲存關卡設定、CVI 變異體題庫與玩家進度。

</div>
</div>

---

## 4.1 先導實驗設計（Pilot Experiment）

於正式大規模導入前，我們先進行**先導實驗**以驗證系統可行性、測試案例產出品質與學生學習體驗。

<div class="three-col">
<div class="card small-text">

### 👥 受試對象
- **10 位大學生**（女性 3 位、男性 7 位）。
- 皆來自**逢甲大學資訊工程學系**。
- 實驗前均**未曾學過變異測試**，起點一致。

</div>
<div class="card teal small-text">

### ⚖️ 實驗分組
- **實驗組（CIB 工具）**：透過 CIB 遊戲化平台撰寫 Python 測試案例擊殺變異體，享自動化執行與即時回饋。
- **對照組（手寫方式）**：以傳統手寫方式設計測試案例、人工模擬變異體輸出並手算變異分數。

</div>
<div class="card accent small-text">

### 📊 評測題目與問卷
- **實作基準題**：`Euclidean GCD`、`Interpolation Search` 與 `Triangle`（難度遞增）。
- **滿意度問卷**：改編自 Barrio [21] 之 11 題**五點李克特量表**，涵蓋動機、專注力與學習成效。

</div>
</div>

<div class="callout" style="margin-top: 12px;">
<strong>分析方法：</strong>考量本先導實驗樣本數為 `N = 10`，重點在於驗證工具流程與學習行為差異，故採用<strong>敘述性統計</strong>、提交次數箱型圖、有效／無效案例拆解及問卷均分比較進行分析。
</div>

---

## 4.2 RQ1 結果：測試案例提交量與有效案例大幅領先

<div class="split55">
<div class="left">

<div class="fig-box">
<img src="./img/fig5_submissions.png" alt="Fig. 5: 兩組測試案例提交次數箱型圖" style="max-height: 385px;">
<div class="fig-cap">Fig. 5：各題目測試案例提交次數比較（對照組 vs. CIB 實驗組）</div>
</div>

</div>
<div class="right small-text">

### 📈 Table II：兩組測試案例總提交次數

| 分組 | 總計 (All) | GCD | Search | Triangle |
| :--- | :---: | :---: | :---: | :---: |
| 對照組（手寫） | 18 | 11 | 4 | 3 |
| **實驗組（CIB）** | **152** | **13** | **34** | **105** |

<div class="two-col" style="gap: 10px; margin-top: 8px;">
<div class="kpi-card teal">
<div class="kpi-val">8.4×</div>
<div class="kpi-label">總提交數（<strong>152 vs. 18</strong>；均 30.4 vs. 3.6 筆）</div>
</div>
<div class="kpi-card">
<div class="kpi-val">3.1×</div>
<div class="kpi-label"><strong>有效</strong>測試案例數（<strong>25 vs. 8</strong> 筆）</div>
</div>
</div>

- **差距隨難度擴大**：手寫模擬在複雜題目極度吃力，在 `Triangle` 題差距高達 **105 vs. 3**！

</div>
</div>

---

## 4.3 RQ2 結果：有效 vs. 無效提交與「即時回饋試錯效應」

<div class="split55">
<div class="left">

<div class="fig-box">
<img src="./img/fig6_invalid.png" alt="Fig. 6: 兩組無效測試案例次數箱型圖" style="max-height: 385px;">
<div class="fig-cap">Fig. 6：各題目無效測試案例（無法編譯或執行失敗）比較</div>
</div>

</div>
<div class="right small-text">

### 🔄 建設性的「快速試錯」現象
- **有效案例大幅勝出**：實驗組產出 **25 筆有效**測試案例，遠勝對照組的 **8 筆**。
- **無效比例亦較高**：實驗組中無法編譯／執行失敗的無效提交比例高於對照組。
- **原因剖析——即時錯誤回饋驅動迭代**：
  - `Code Runner` 立即回報錯誤訊息，促使學生迅速修改重送（即使當次修正仍未完全正確）。
  - 我們認為這正是**鍛鍊測試設計能力的重要試錯學習過程（Trial-and-Error）**。
- **對照組難度崩潰**：在較難的 `Interpolation Search` 與 `Triangle` 題目中，手寫組的有效與無效提交數皆**趨近於 0**。

</div>
</div>

---

## 4.4 RQ3 結果：學習動機 (Q1) 與專注力 (Q2) 問卷分析

採用 **5 分制李克特量表**施測 11 題（標註 `*` 者為實驗組專屬題目，用以評估遊戲化相較傳統教學之優勢）：

<div class="two-col">
<div class="card teal small-text">

### 🔥 Table IV：學習動機（Q1）

| 題號 | 題項摘要 | 對照 | **實驗** |
| :--- | :--- | :---: | :---: |
| `Q1-1` | 喜歡這種變異測試學習方式 | 3.50 | **4.50** |
| `Q1-2` | 更能理解變異測試概念 | 3.50 | **4.83** |
| `Q1-3` | 想更深入學習變異測試 | 3.00 | **4.17** |
| `Q1-4*` | 關卡具挑戰性且提升動機 | — | **4.33** |
| `Q1-5*` | 偏好此方式勝過傳統教學 | — | **4.67** |

</div>
<div class="card small-text">

### 🎯 Table V：專注與投入度（Q2）

| 題號 | 題項摘要 | 對照 | **實驗** |
| :--- | :--- | :---: | :---: |
| `Q2-1` | 較少分心、能專注學習 | 3.50 | **4.17** |
| `Q2-2` | 過程屬高強度認知思考 | **4.50** | **4.50** |
| `Q2-3` | 感覺自己主動參與學習 | 4.50 | **4.83** |

<div class="callout" style="font-size: 0.9em; margin-top: 10px;">
<strong>Q2-2 細緻觀察：</strong>手寫法雖迫使學生高度動腦追蹤（4.50），但繁瑣計算導致專注力下滑（<code>Q2-1: 3.50</code>），並大幅澆熄深入學習意願（<code>Q1-3: 3.00</code>）。
</div>

</div>
</div>

---

## 4.5 RQ3 結果：學習成效 (Q3) 與質性回饋洞察

<div class="two-col">
<div class="card small-text">

### 🎓 Table VI：學習成效自評（Q3）

| 題號 | 問卷題目 | 對照 | **實驗** |
| :--- | :--- | :---: | :---: |
| `Q3-1` | 我能理解變異測試的方法 | **4.75** | 4.67 |
| `Q3-2` | 我能應用變異測試的技術 | 4.00 | **4.33** |
| `Q3-3*` | 學習效果優於傳統教學法 | — | **4.83** |

<div style="margin-top: 12px;">
<div class="bar-row"><span><strong>Q1 均分（共同題）</strong></span><div class="bar-track"><div class="bar-fill teal" style="width:90%;"></div></div><span class="bar-pct">4.50 vs 3.33</span></div>
<div class="bar-row"><span><strong>Q2 均分（全 3 題）</strong></span><div class="bar-track"><div class="bar-fill" style="width:90%;"></div></div><span class="bar-pct">4.50 vs 4.17</span></div>
<div class="bar-row"><span><strong>Q3 均分（共同題）</strong></span><div class="bar-track"><div class="bar-fill accent" style="width:90%;"></div></div><span class="bar-pct">4.50 vs 4.38</span></div>
</div>

</div>
<div class="card teal small-text">

### 💬 課堂質性觀察與回饋對比
- **基本概念皆獲建立**：兩組在「理解變異測試概念」（`Q3-1`：4.75 vs. 4.67）皆達高分，顯示手寫追蹤雖辛苦，仍能讓學生對原理留下深刻印象。
- **截然不同的心態走向**：
  - **對照組**：強烈感受手寫壓力，紛紛**希望減少變異體數量**以減輕人工負擔。
  - **實驗組**：完全不覺得變異體太多，高度肯定 CIB 成效（`Q3-3* = 4.83`），甚至**主動期待挑戰更難的關卡**。
- **實作應用更具信心**：實驗組在「實際應用變異測試技術」（`Q3-2`：**4.33** vs. 4.00）表現更佳。

</div>
</div>

---

## 5. 結論與未來研究方向

<div class="fig-box" style="padding: 8px 10px; margin-bottom: 8px;">
<img src="./img/diag3_rq_conclusions_zh.svg" alt="CIB RQ1-RQ3 研究結論視覺統整" style="max-height: 355px;">
</div>

<div class="future-strip">
<div class="future-pill"><strong>🌐 1. 整合至 Online Judge 系統</strong><br>將 CIB 與 CVI 結合熱門線上解題平台，讓學生在寫程式的同時自然養成軟體測試與品質驗證習慣。</div>
<div class="future-pill"><strong>📊 2. 擴大正式課堂對照實驗</strong><br>由 10 人先導實驗擴大至完整修課班級，導入推論統計檢定並追蹤長期學習保留成效。</div>
<div class="future-pill"><strong>🧩 3. 深化雙角色與多語言支援</strong><br>進一步評估「疫苗（撰寫變異體）」角色學習效益，並將 CVI 擴展至 Java／C++ 等主流教學語言。</div>
</div>

---

<!-- _class: closing -->

# 感謝聆聽與指教！

<p style="font-size: 1.05em; max-width: 840px;">
變異測試遊戲化學習系統之設計與實作（Code Immunity Boost, CIB）
</p>

<div class="contact-card">
<strong>薛念林（Nien-Lin Hsueh）*</strong> · <code>nlhsueh@fcu.edu.tw</code><br>
<strong>Zeng Hung Xuan</strong> &nbsp;·&nbsp; <strong>Bilegjargal Daramsenge</strong><br>
逢甲大學資訊工程學系（Feng Chia University, Taiwan）<br>
IJIET Vol. 13, No. 7, pp. 1150–1155, July 2023 · DOI: <code>10.18178/ijiet.2023.13.7.1916</code><br>
<span style="font-size: 0.85em; opacity: 0.85;">科技部補助計畫：MOST 110-2221-E-035-031-MY2 · 歡迎提問與交流！</span>
</div>

<script>
document.addEventListener('click', (e) => {
  const btn = e.target.closest('.nav-btn');
  if (btn) {
    e.stopPropagation();
    const dd = btn.closest('.nav-dropdown');
    const wasOpen = dd.classList.contains('open');
    document.querySelectorAll('.nav-dropdown.open').forEach(el => el.classList.remove('open'));
    if (!wasOpen) dd.classList.add('open');
    return;
  }
  document.querySelectorAll('.nav-dropdown.open').forEach(el => el.classList.remove('open'));
});
</script>
