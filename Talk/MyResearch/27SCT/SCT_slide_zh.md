---
marp: true
theme: gaia
size: 16:9
paginate: true
html: true
header: '<div class="hdr-wrap"><span class="hdr-title">分層式 LLM 程式學習輔助機制之應用與分析（SCT）</span><div class="hdr-actions"><a class="lang-btn" href="./SCT_slide.html" title="Switch to English Slides">🌐 EN</a><div class="nav-dropdown"><button class="nav-btn">章節導覽 ▾</button><div class="nav-menu"><a href="#2">破題：什麼是 AI Tax？</a><a href="#3">簡報大綱</a><a href="#4">1. 研究動機與問題</a><a href="#6">2. 文獻回顧與缺口</a><a href="#7">3. 研究方法與 LADI</a><a href="#11">4. SCT 系統設計</a><a href="#13">5. 實證研究與結果</a><a href="#20">6. 結論與未來研究</a></div></div></div></div>'
footer: '薛念林（Nien-Lin Hsueh）＆ Ying-Chang Lu · 逢甲大學資訊工程學系 · Smart Coding Tutor (SCT)'
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
  font-size: 20.5px;
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
  min-width: 215px;
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
  font-size: 1.65em;
  font-weight: 800;
  line-height: 1.26;
  margin: 0 0 12px 0;
}

h2 {
  color: var(--navy);
  font-size: 1.28em;
  font-weight: 700;
  line-height: 1.28;
  margin: 0 0 14px 0;
  padding-bottom: 6px;
  border-bottom: 2.5px solid var(--navy);
  display: flex;
  align-items: center;
  gap: 8px;
}

h3 {
  color: var(--accent);
  font-size: 0.98em;
  font-weight: 700;
  margin: 4px 0 6px 0;
}

p {
  margin: 0 0 8px 0;
}

ul, ol {
  margin: 4px 0 8px 0;
  padding-left: 24px;
}

li {
  margin-bottom: 6px;
  line-height: 1.46;
}

li > ul {
  margin-top: 3px;
  margin-bottom: 3px;
}

li > ul > li {
  font-size: 0.92em;
  margin-bottom: 3px;
}

strong {
  color: var(--slate-900);
}

a {
  color: #2563eb;
  text-decoration: none;
}

a:hover {
  text-decoration: underline;
}

/* Inline code without background (per AGENTS.md) */
:not(pre, marp-pre) > code {
  background: transparent !important;
  border: none !important;
  padding: 0 !important;
  font-family: 'JetBrains Mono', monospace;
  font-size: 0.9em;
  font-weight: 600;
  color: #475569;
}

h1 code, h2 code, h3 code {
  color: #0b3c5d;
}

section table th {
  background: var(--navy) !important;
  color: #ffffff !important;
}

section table th code {
  color: #ffffff !important;
}

section.lead code,
section.closing code {
  color: #bae6fd !important;
}

section.closing strong {
  color: #ffffff !important;
}

/* Lead / Title Slide */
section.lead {
  background: linear-gradient(135deg, #102442 0%, #1b365d 62%, #294c7a 100%);
  color: #ffffff;
  display: flex;
  flex-direction: column;
  justify-content: center;
  padding: 54px 72px;
}

section.lead header,
section.lead footer,
section.lead::after {
  display: none !important;
}

section.lead .badge {
  display: inline-block;
  align-self: flex-start;
  background: rgba(255, 255, 255, 0.14);
  border: 1px solid rgba(255, 255, 255, 0.32);
  color: #f8fafc;
  font-size: 0.72em;
  font-weight: 600;
  letter-spacing: 0.05em;
  padding: 5px 14px;
  border-radius: 999px;
  margin-bottom: 18px;
}

section.lead h1 {
  color: #ffffff;
  font-size: 1.9em;
  font-weight: 800;
  line-height: 1.28;
  margin-bottom: 14px;
  text-align: left;
}

section.lead .en-title {
  color: #93c5fd;
  font-size: 0.86em;
  font-weight: 500;
  line-height: 1.4;
  margin-bottom: 16px;
}

section.lead .subtitle {
  color: #cbd5e1;
  font-size: 0.94em;
  line-height: 1.5;
  margin-bottom: 24px;
  max-width: 920px;
}

section.lead .meta-box {
  border-left: 4px solid #f43f5e;
  padding-left: 18px;
  color: #e2e8f0;
  font-size: 0.85em;
  line-height: 1.6;
}

section.lead .meta-box strong {
  color: #ffffff;
}

section.lead .grant {
  margin-top: 20px;
  font-size: 0.72em;
  color: #94a3b8;
}

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

section.closing header,
section.closing footer,
section.closing::after {
  display: none !important;
}

section.closing h1 {
  color: #ffffff;
  font-size: 2.2em;
  margin-bottom: 12px;
}

section.closing p {
  color: #e2e8f0;
}

section.closing .contact-card {
  margin-top: 24px;
  background: rgba(255, 255, 255, 0.12);
  border: 1px solid rgba(255, 255, 255, 0.25);
  border-radius: 12px;
  padding: 18px 34px;
  font-size: 0.85em;
  line-height: 1.7;
  color: #f8fafc;
}

/* Grids & Layouts */
.two-col {
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 22px;
  align-items: stretch;
}

.three-col {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: 16px;
  align-items: stretch;
}

.split64 {
  display: grid;
  grid-template-columns: 58% 40%;
  gap: 2%;
  align-items: center;
}

.split55 {
  display: grid;
  grid-template-columns: 49% 49%;
  gap: 2%;
  align-items: center;
}

/* Cards & Callouts */
.card {
  background: #ffffff;
  border: 1px solid var(--slate-200);
  border-top: 3.5px solid var(--navy);
  border-radius: 8px;
  padding: 14px 18px;
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
  padding: 12px 16px;
  box-sizing: border-box;
}

.kpi-card.accent {
  border-left-color: var(--accent);
  background: var(--accent-soft);
}

.kpi-card.teal {
  border-left-color: var(--teal);
  background: var(--teal-soft);
}

.kpi-val {
  font-size: 1.5em;
  font-weight: 800;
  color: var(--navy);
  line-height: 1.15;
  margin-bottom: 4px;
}

.kpi-card.accent .kpi-val { color: var(--accent); }
.kpi-card.teal .kpi-val { color: var(--teal); }

.kpi-label {
  font-size: 0.78em;
  color: var(--slate-700);
  line-height: 1.38;
}

.callout {
  background: #f8fafc;
  border-left: 4px solid var(--accent);
  border-radius: 0 8px 8px 0;
  padding: 10px 16px;
  margin-top: 10px;
  font-size: 0.88em;
  color: var(--slate-700);
}

.callout strong {
  color: var(--navy);
}

/* Tables */
table {
  width: 100%;
  border-collapse: collapse;
  font-size: 0.78em;
  margin: 8px 0;
  background: #ffffff;
  border: 1px solid var(--slate-200);
}

th {
  background: var(--navy);
  color: #ffffff;
  font-weight: 700;
  padding: 6px 10px;
  text-align: left;
  border: 1px solid var(--navy);
}

td {
  padding: 5px 10px;
  border: 1px solid var(--slate-200);
  vertical-align: middle;
  line-height: 1.38;
}

tr:nth-child(even) td {
  background: #f8fafc;
}

/* Formula Box */
.formula-box {
  background: #f8fafc;
  border: 1.5px solid #cbd5e1;
  border-left: 5px solid var(--navy);
  border-radius: 8px;
  padding: 10px 18px;
  margin: 6px 0 10px 0;
  display: flex;
  justify-content: center;
  align-items: center;
  font-family: 'Georgia', 'Times New Roman', serif;
  font-size: 1.15em;
  color: var(--slate-900);
}

.frac {
  display: inline-flex;
  flex-direction: column;
  align-items: center;
  vertical-align: middle;
  margin: 0 4px;
  line-height: 1.1;
}

.frac-num {
  border-bottom: 1.5px solid var(--slate-900);
  padding: 0 6px 2px 6px;
}

.frac-den {
  padding: 2px 6px 0 6px;
}

.piecewise {
  display: inline-flex;
  align-items: center;
  gap: 8px;
}

.brace {
  font-size: 2.3em;
  font-weight: 300;
  line-height: 1;
  color: var(--navy);
}

.cases {
  display: flex;
  flex-direction: column;
  gap: 4px;
  text-align: left;
  font-size: 0.94em;
}

/* Outline Grid */
.outline-grid {
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 14px 24px;
  margin-top: 8px;
}

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

.outline-body {
  font-size: 0.86em;
  line-height: 1.42;
}

.outline-body a {
  color: var(--navy);
  font-weight: 700;
  font-size: 1.05em;
}

/* Bar Charts */
.bar-row {
  display: grid;
  grid-template-columns: 205px 1fr 92px;
  align-items: center;
  gap: 14px;
  margin-bottom: 12px;
  font-size: 0.85em;
}

.bar-track {
  background: var(--slate-100);
  border-radius: 6px;
  height: 24px;
  overflow: hidden;
  border: 1px solid var(--slate-200);
}

.bar-fill {
  height: 100%;
  border-radius: 5px;
  background: var(--navy);
}

.bar-fill.accent { background: var(--accent); }
.bar-fill.teal { background: var(--teal); }
.bar-fill.muted { background: #64748b; }

.bar-pct {
  font-weight: 700;
  text-align: right;
  color: var(--slate-900);
  white-space: nowrap;
}

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





.fig-cap {
  font-size: 0.72em;
  color: var(--slate-500);
  margin-top: 6px;
  font-weight: 500;
}

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

.small-text {
  font-size: 0.84em;
}

/* Incremental RQ Grid */
.rq-stage ul {
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 16px;
  list-style: none !important;
  padding: 0 !important;
  margin: 10px 0 0 0 !important;
}

.rq-stage li {
  margin: 0 !important;
  padding: 0 !important;
  list-style: none !important;
}

.rq-stage li::marker {
  content: "";
}

.rq-card {
  display: flex;
  align-items: center;
  gap: 14px;
  background: #ffffff;
  border: 1px solid var(--slate-200);
  border-top: 3.5px solid var(--navy);
  border-radius: 10px;
  padding: 13px 16px;
  box-shadow: 0 2px 8px rgba(15, 23, 42, 0.06);
  height: 100%;
  box-sizing: border-box;
}

.rq-card.teal { border-top-color: var(--teal); }
.rq-card.accent { border-top-color: var(--accent); }

.rq-card img {
  width: 92px;
  height: 92px;
  flex-shrink: 0;
  border-radius: 10px;
}

.rq-hook {
  font-size: 0.88em;
  font-weight: 800;
  color: var(--navy);
  line-height: 1.32;
  margin-bottom: 5px;
}

.rq-card.teal .rq-hook { color: var(--teal); }
.rq-card.accent .rq-hook { color: var(--accent); }

.rq-q {
  font-size: 0.77em;
  color: var(--slate-700);
  line-height: 1.44;
}

.future-strip {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: 12px;
  margin-top: 10px;
}

.future-pill {
  background: #f8fafc;
  border: 1px solid var(--slate-200);
  border-left: 4px solid var(--teal);
  border-radius: 8px;
  padding: 8px 12px;
  font-size: 0.74em;
  line-height: 1.42;
  color: var(--slate-700);
}

.future-pill strong {
  color: var(--navy);
}

.fig-box { overflow: visible; position: relative; }
.fig-box img { cursor: zoom-in; }
.fig-box.is-zoomed { z-index: 45; }
.fig-box img.is-zoomed {
  position: relative;
  z-index: 46;
  box-shadow: 0 18px 44px rgba(15, 23, 42, 0.30);
  background: #ffffff;
}


/* Typography Measure & Letter-Spacing Polish (override Gaia 1.25px default) */
section {
  letter-spacing: 0.01em !important;
}
section h1, section h2, section h3 {
  letter-spacing: 0 !important;
}
section:not(.lead):not(.closing) > p {
  max-width: 980px;
}
section .callout {
  max-width: 920px;
  margin-left: auto;
  margin-right: auto;
  line-height: 1.54;
}


/* Table Breathing Room & Callout Separation */
section table {
  margin-top: 12px !important;
  margin-bottom: 14px !important;
}
section table th {
  padding: 9px 11px !important;
}
section table td {
  padding: 8px 11px !important;
  line-height: 1.42 !important;
}
section .split55 table th,
section .split64 table th,
section .split55 table td,
section .split64 table td {
  padding: 6px 8px !important;
}
section table + .callout,
section .fig-box + .callout,
section .two-col + .callout,
section .three-col + .callout,
section div + .callout {
  margin-top: 20px !important;
}
section .callout {
  padding: 12px 18px !important;
}


.hdr-actions {
  display: inline-flex;
  align-items: center;
  gap: 8px;
}
.lang-btn {
  background: rgba(255, 255, 255, 0.14);
  color: #ffffff !important;
  border: 1px solid rgba(255, 255, 255, 0.28);
  border-radius: 6px;
  padding: 3px 10px;
  font-size: 12px;
  font-weight: 600;
  text-decoration: none !important;
  cursor: pointer;
  display: inline-flex;
  align-items: center;
  gap: 4px;
  line-height: 1.35;
  transition: background 0.15s ease;
}
.lang-btn:hover {
  background: rgba(255, 255, 255, 0.26);
  text-decoration: none !important;
}
@media print {
  .lang-btn, .nav-dropdown { display: none !important; }
}

</style>

<!-- _class: lead -->

<div class="badge">學術會議專題報告 · 程式設計教育與學習分析</div>

# 分層式大型語言模型程式輔助機制於程式學習之應用與分析

<div class="en-title">
Application and Analysis of a Tiered LLM-Based Programming Assistance Mechanism in Programming Learning
</div>

<div class="subtitle">
將 AI 輔助從「未受控管的外掛工具」轉化為「可控、可紀錄、可分析」的教學介入機制
</div>

<div class="meta-box">
<strong>薛念林（Nien-Lin Hsueh）<sup>+</sup></strong>、<strong>Ying-Chang Lu</strong><br>
逢甲大學 資訊工程學系（Feng Chia University, Taichung, Taiwan）<br>
<code>nlhsueh@fcu.edu.tw</code> · <code>m1305878@o365.fcu.edu.tw</code>
</div>

<div class="grant">
國科會專題研究計畫補助：NSTC114-2221-E-035-077
</div>

<!--
論文背景與核心貢獻：
- 本論文發表於《Journal of Information Science and Engineering (JISE)》，作者為逢甲大學資訊工程學系薛念林（Nien-Lin Hsueh）與 Ying-Chang Lu，研究獲國科會計畫 NSTC114-2221-E-035-077 補助。
- 核心研究問題：當大型語言模型（LLM）導入程式設計評量時，學生最終通過測資的成績往往同時混雜了「獨立程式實作能力」與「對 AI 提示或解題結構之依賴程度」，導致傳統線上評測分數喪失可解釋性與鑑別度。
- 主要貢獻：本研究設計並實作 Smart Coding Tutor（SCT）線上解題平台，整合五級分層 AI 助教機制（L0 至 L4）、明確之 AI 稅率（0% 至 20%）、停滯觸發式主動提示、完成後概念檢核與反思回饋，並提出「層級錨定依賴指標（LADI）」，於逢甲大學 112 位 Python 修課生中完成實證驗證。
-->

---

## 破題思考：如果使用 AI 協助也要繳交「AI 稅（AI Tax）」？

<div class="fig-box" style="padding: 6px; margin-bottom: 10px; background: #fbf9f2;">
<img src="./img/ai_tax_hook.jpg" alt="程式考試中的 AI Tax 趣味比喻插畫" style="max-height: 415px; border-radius: 6px;">
</div>

<div class="callout" style="margin-top: 6px; padding: 9px 16px;">
<strong>核心破題構想：</strong> 與其全面封閉道路，不如在 AI 快速道上設立<strong>分級收費站</strong>！學生卡關時仍可獲得分層引導，但透過明確的 <strong>AI 稅率（0%–20%）</strong>，讓評量成績維持公平、透明與可解釋性。
</div>

<!--
「AI 稅（AI Tax）」之教學設計理念：
- 程式設計教育正面臨兩難：若全面禁止生成式 AI，初學者將失去即時排錯解釋與學習動機鷹架；若完全開放外部 AI，則不同概念理解程度的學生皆可產出正確程式碼，造成嚴重天花板效應與分數失真。
- 制度運作機制：SCT 不採禁止策略，而是將 AI 輔助內嵌於正式評測平台中，並針對不同強度的提示層級設定公開透明的扣分成本（AI 稅率：L0 為 0% 至 L4 為 20%）。
- 評量學理意義：將隱性的外部依賴轉化為顯性的自我調節決策，使教師能在保留鷹架支持的同時，清晰區辨「獨立完成」與「高度輔助完成」，維持評量公平性與分數可解釋性。
-->

---

## 簡報大綱（Outline）

<div class="outline-grid">

<div class="outline-item">
<div class="outline-num">1</div>
<div class="outline-body">

[**研究動機與四大研究問題**](#4)
開放式 AI 帶來的評量鑑別度困境，以及本研究之 RQ1–RQ4。

</div>
</div>

<div class="outline-item">
<div class="outline-num">2</div>
<div class="outline-body">

[**文獻回顧與研究缺口**](#6)
現有 LLM 程式助教系統比較，與正式評量流程整合之不足。

</div>
</div>

<div class="outline-item">
<div class="outline-num">3</div>
<div class="outline-body">

[**研究方法：分層 AI、AI 稅率與 LADI**](#7)
五級分層助教、主動提示與反思檢核、以及 EPC 與 LADI 指標。

</div>
</div>

<div class="outline-item">
<div class="outline-num">4</div>
<div class="outline-body">

[**Smart Coding Tutor（SCT）系統設計**](#11)
整合式系統架構、分層提示建構器與學生端操作介面。

</div>
</div>

<div class="outline-item">
<div class="outline-num">5</div>
<div class="outline-body">

[**實證研究與分析結果（RQ1–RQ4）**](#13)
112 位逢甲 Python 修課生、3 次正式評量共 9 道題目之實證分析。

</div>
</div>

<div class="outline-item">
<div class="outline-num">6</div>
<div class="outline-body">

[**結論與未來研究方向**](#20)
RQ1–RQ4 核心發現全景圖、教學啟示與後續精進規劃。

</div>
</div>

</div>

<!--
論文結構與章節導覽：
- 第 1 節（緒論）剖析開放式 LLM 造成之評量鑑別度困境，並提出涵蓋評量效度、分層支持、使用策略與 AI 依賴之四大研究問題（RQ1 至 RQ4）。
- 第 2 節（文獻回顧）綜述 LLM 程式助教、語意回饋自動評分、題目生成與主動式教學 AI 框架，並以 Table 1 對照五個代表性系統。
- 第 3 節（研究方法）形式化定義五級分層助教、AI 稅率計費規則、主動式學習支持、完成後概念鞏固、升級剖面係數（EPC）與層級錨定依賴指標（LADI）。
- 第 4 節介紹 SCT 整合式系統架構與分層介面；第 5 節呈現 112 位學生於 3 次正式評量（共 9 題）之實證分析；第 6 節總結教學啟示、研究限制與未來方向。
-->

---

## 1.1 研究動機：AI 輔助程式學習中的評量困境

<div class="fig-box" style="padding: 10px 12px; margin-bottom: 10px;">
<img src="./img/diag1_assessment_dilemma_zh.svg" alt="未控管開放 AI 與 SCT 分層機制之評量對比" style="max-height: 365px;">
</div>

<div class="callout">
<strong>核心設計理念：</strong> 本研究的目的<strong>並非禁止學生使用 AI</strong>，而是將 AI 輔助轉化為<strong>可控、分層且可紀錄</strong>的教學介入，讓成績能真實反映能力與輔助程度。
</div>

<!--
理論背景與實證動機：
- LLM 輔助效益與評量隱憂：LLM 具備自然語言錯誤解釋、程式修復、對話輔導與語意回饋能力（Ozkaya [1]、Liu 等人 [2]、Pereira & Mello [3]），可減輕大班程式教學中個別指導與人工批改負擔（Messer 等人 [4]）。
- 傳統線上評測系統（OJ）之盲區：既有的自動評測高度仰賴測資比對與輸出正確性，無法觀測學生的推理品質、除錯歷程或所動用的外部輔助強度（Messer 等人 [4]、Gabbay & Cohen [5]）。
- 先期課程觀測數據：在先期完全開放 AI 輔助的課程觀察中，程式實作成績高度集中於高分區，而概念理解成績卻相當離散；AI 使用次數與概念理解分數之相關係數僅達 r = 0.136，證實未經分層校準的分數難以反映真實獨立解題能力。
- 設計哲學：呼應人機協作與教育 AI 設計原則（Kazemitabaar 等人 [7]、Chen 等人 [10]、Yan [12]），SCT 旨在將 AI 轉化為可控、可紀錄且可分析的教學介入，而非單純禁用。
-->

---

## 1.2 研究目標與四大研究問題（RQ1–RQ4）

為驗證 **Smart Coding Tutor（SCT）** 是否能兼顧「鷹架支持」與「評量效度」，本研究探討以下**四大問題** *（逐步揭曉）*：

<div class="rq-stage">

* <div class="rq-card teal"><img src="./img/rq1_icon.svg" alt="RQ1 還原真實能力"><div><div class="rq-hook"><span class="rq-tag" style="background:#0f766e;">RQ1</span> 我們能否揭開滿分假象、還原真實能力？</div><div class="rq-q">分層 AI 輔助機制是否能提升程式評量任務的<strong>成績鑑別度</strong>？</div></div></div>
* <div class="rq-card"><img src="./img/rq2_icon.svg" alt="RQ2 階梯式助推"><div><div class="rq-hook"><span class="rq-tag" style="background:#1b365d;">RQ2</span> 較高層級的提示真的能救起卡關學生嗎？</div><div class="rq-q">不同 AI 輔助層級（L<sub>0</sub>–L<sub>4</sub>）在解題過程中各自產生何種<strong>支持效果</strong>？</div></div></div>
* <div class="rq-card accent"><img src="./img/rq3_icon.svg" alt="RQ3 AI 稅率策略"><div><div class="rq-hook"><span class="rq-tag">RQ3</span> 面對「AI 稅」，學生會怎麼精打細算？</div><div class="rq-q">在具備明確評量成本的分層機制下，學生展現哪些<strong>使用策略與行為模式</strong>？</div></div></div>
* <div class="rq-card"><img src="./img/rq4_icon.svg" alt="RQ4 LADI 與概念理解"><div><div class="rq-hook"><span class="rq-tag" style="background:#1b365d;">RQ4</span> 概念越扎實，就越不依賴 AI 嗎？</div><div class="rq-q">學生的 <strong>AI 依賴程度（LADI）</strong>與其概念理解學習成效之間存在何種關聯？</div></div></div>

</div>

<!--
四大研究問題（RQ1 至 RQ4）之檢驗維度：
- RQ1（評量鑑別度）：檢驗將 AI 輔助強度與明確稅率納入成績計算後，是否能有效緩解滿分集中現象、提升程式實作與概念理解分數之一致性，並揭露不同背景學生的真實能力差異。
- RQ2（分層支持效果）：驗證 L0 至 L4 五個層級在嚴格守住不直接給答案的邊界下，是否能呈現具區辨力的階梯式支持（以不升級即於該層達成 AC 之完成率衡量）。
- RQ3（使用策略與行為模式）：探討在具備明確評量成本的制度下，學生如何依據自身概念掌握與卡關狀態權衡輔助強度與分數扣除，並剖析四象限投入產出分群。
- RQ4（AI 依賴與學習成效）：檢視 LADI 指標之分布特徵及其與獨立概念理解成績之關聯，並跨學科背景（資訊 vs. 非資訊）與年級（大一至大四）檢驗其初步效標關聯效度。
-->

---

## 2. 文獻回顧與研究缺口（Table 1）

既有 LLM 程式助教多聚焦於單一輔助功能，且多屬**外掛式工具**，缺乏與正式線上評測（OJ）流程的深度整合。

| 相關研究 | 學習分析 | 評量鑑別 | 強度分層 | 行為分析 | 依賴量化 | 平台整合 | 反思支持 | 主動性角色<sup>1</sup> |
| :--- | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :--- |
| CodeAid [7] | | | | ✓ | | | | Adaptive（適應型） |
| CodeHelp [6] | ✓ | | | ✓ | | | | Adaptive（適應型） |
| Gipy [5] | | | | ✓ | | | | Adaptive（適應型） |
| CodeRunner Agent [8] | ✓ | | | | | ✓ | ✓ | Proactive（主動型） |
| Owlgorithm [9] | | | | | | ✓ | ✓ | Proactive（主動型） |
| **本研究（SCT）** | **✓** | **✓** | **✓** | **✓** | **✓** | **✓** | **✓** | **Proactive（主動型）** |

<div class="callout">
<strong>關鍵研究缺口：</strong> 既有研究較少同時區分<strong>輔助強度層級</strong>、追蹤<strong>跨層升級歷程</strong>，並解析 AI 依賴程度與評量鑑別度間的關聯。<br>
<span style="font-size: 0.88em; color: #475569;"><sup>1</sup> <strong>主動性角色定義（Yan 等人框架 [12]）：</strong><strong>Adaptive（適應型）</strong>係被動等待學生主動提問或觸發錯誤後才回應；<strong>Proactive（主動型）</strong>則由系統持續監控學習狀態（如停滯、重複錯誤），於適當時機主動介入提醒或引導反思。</span>
</div>

<!--
文獻定位與研究缺口（Table 1 解析）：
- 適應型（Adaptive／被動回應）助教：CodeAid [7] 透過概念說明、虛擬碼與逐行引導避免直接給出完整解答；CodeHelp [6] 限制回應於錯誤定位與修正方向；Gipy [5] 將 LLM 回饋結合 MOOC 測試導向回饋。此類研究雖探討求助行為，但多為獨立外掛工具，與正式線上評量流程整合度低。
- 主動型（Proactive）與反思導向平台：CodeRunner Agent [8] 整合教材、執行結果與學習紀錄以支持自我調節學習；Owlgorithm [9] 於競程課程中導入引導式自我解釋與解題後反思。兩者皆對應 Yan [12] 框架中的主動型角色。
- 自動回饋與主動介入之文獻警示：既有文獻指出 LLM 程式碼審查之一致性仍不穩定（Liu 等人 [2]、Estévez-Ayres 等人 [15]），即便回饋品質高仍需結構化設計以維持學習者自主權（Cao 等人 [17]），且過度頻繁的主動介入反會降低滿意度與自主感（Chen 等人 [10]、CodingGenie [18]）。
- 本研究填補之缺口：既有五套系統均未在正式 OJ 評測流程內，同時整合強度分層、評量成本鑑別、跨層升級追蹤與連續依賴指標（LADI），SCT 一次補齊此八大維度。
-->

---

## 3.1 五級分層 AI 助教與 AI 稅率設計

每道題目皆從 **L<sub>0</sub>** 開始，由學生依解題卡關狀態自主決定是否升級，全層級皆設明確邊界以防直接給出完整解答。

<div class="fig-box" style="padding: 10px 12px; margin: 6px 0 8px 0;">
<img src="./img/diag2_tiered_staircase_zh.svg" alt="五級分層 AI 助教階梯與 AI 稅率示意圖" style="max-height: 350px;">
</div>

<div class="callout">
<strong>AI 稅率計費原則：</strong> 以學生在單題中實際動用的<strong>最高 AI 輔助層級</strong>（而非呼叫次數）作為該題之 AI 使用成本，將外部輔助強度轉化為可觀察的評量指標。
</div>

<!--
五級分層 AI 助教與 AI 稅率規則（Table 2）：
- L0（無 AI 提示，稅率 0%）：每道題目的預設起點。學生僅依賴題目敘述、自行測試與 OJ 評測狀態完成作答，構成自主解題基準。
- L1（執行錯誤提示，稅率 5%）：針對編譯錯誤（CE）或執行時期錯誤（RE），解釋錯誤訊息、可能成因與檢查方向。
- L2（邏輯錯誤提示，稅率 10%）：針對程式可執行但獲得 WA 或 PA 之狀況，提供條件判斷、邊界案例、資料結構與輸入輸出處理等除錯方向。
- L3（AI 助教問答，稅率 15%）：開放多輪對話介面，由學生主動提問以獲得概念釐清與解題策略說明。
- L4（完整高強度引導，稅率 20%）：提供解題流程拆解、策略比較與虛擬碼層級架構說明，但全層級皆設有明確回饋邊界，禁止直接產出可貼上送出的完整解答。
- 稅率計費學理依據：高層級包含低層級支持並深化引導深度。AI 稅率係依學生在單題中實際動用的「最高層級」計算，而非呼叫次數或平均強度，藉此反映解題過程所動用的最大外部鷹架程度，同時避免學生因擔心重複扣分而不敢在同層級內追問釐清觀念。
-->

---

## 3.2 主動式學習支持與完成後概念鞏固

借鏡 Yan 等人的<strong>主動式助手（Proactive Assistant）</strong>架構 [12]，SCT 串聯「解題中停滯提醒」與「通過測資後之概念鞏固」。

<div class="fig-box" style="padding: 10px 12px; margin: 8px 0 10px 0;">
<img src="./img/diag3_proactive_loop_zh.svg" alt="主動式學習支持與完成後概念檢核閉環流程圖" style="max-height: 335px;">
</div>

<div class="callout">
<strong>教學調節原則：</strong> 主動提示保留<strong>學習者主導權</strong>（絕不越俎代庖），而完成後的概念檢核與反思則引導學習從「通過測資」走向「穩定概念理解與遷移」。
</div>

<!--
主動式學習支持與完成後概念鞏固機制：
- 理論依據：借鏡 Yan [12] 之「主動式助手（Proactive Assistant）」角色框架。在程式學習中，學生常在未主動求助的狀態下陷入停滯，若系統僅被動等待提問，支持往往介入過晚。
- 累積式停滯偵測：SCT 將「停滯」視為累積性歷程而非單一失敗事件，綜合監測測試與提交結果變化、重複性錯誤、連續失敗次數與停滯時間，以降低誤觸發並對齊真實需求。
- 保留學習者主導權：主動機制定位為「提示提醒」而非「自動塞入回饋」。系統僅主動詢問是否需要協助，是否啟用 AI 與選擇哪一層級完全由學生自主決定。
- 完成後雙軌鞏固：通過測資（AC）不代表真正理解核心概念。學生獲得 AC 後，系統依據題目脈絡、答題歷程與重複錯誤紀錄，提供：（1）概念檢核（Concept Checks）確認核心觀念並診斷迷思；（2）反思導向回饋（Reflection-Oriented Feedback）引導學生回顧策略選擇並思考如何遷移至相似題型。
-->

---

## 3.3 量化升級歷程：升級剖面係數（EPC）

僅觀察*是否使用 AI* 或*最終層級*，無法區分「循序漸進求助」與「直接跳往高強度依賴」（`s`：起始層級、`f`：最終層級、`m`：實際經歷有效層級數、`λ = 0.3`）。

<div class="formula-box">
<i>EPC</i> &nbsp;=&nbsp;
<span class="frac"><span class="frac-num"><i>s</i></span><span class="frac-den">4</span></span>
&nbsp;+&nbsp; <i>λ</i> &nbsp;( 1 −
<span class="frac"><span class="frac-num"><i>m</i></span><span class="frac-den"><i>f</i> − <i>s</i> + 1</span></span>
)
</div>

<div class="fig-box" style="padding: 8px 10px;">
<img src="./img/diag4_escalation_paths_zh.svg" alt="三種同樣抵達 L4 的升級路徑比較圖" style="max-height: 255px;">
</div>

<div class="callout" style="margin-top: 8px; padding: 8px 14px;">
<strong>兩項關鍵行為訊號：</strong> <code>s / 4</code> 刻畫解題初期的<strong>初始依賴</strong>；<code>1 − m / (f − s + 1)</code> 衡量升級路徑的<strong>稀疏程度</strong>（跳過越多中間層級，代表越明顯的依賴躍升）。
</div>

<!--
升級剖面係數（EPC）之數學定義與行為意涵：
- 設計動機：僅觀測是否使用 AI 或最終停留層級 f，無法區分「循序嘗試 L1 -> L2 -> L3 -> L4 的漸進求助者」與「一開始便直衝 L4 的高強度依賴者」。
- 公式定義：EPC = (s / 4) + lambda * (1 - m / (f - s + 1))，其中 s 為起始使用層級（1 至 4）、f 為最終最高層級（1 至 4）、m 為實際經歷的有效輔助層級數、lambda 為稀疏度權重參數（本研究初始設定為 0.3）。
- 第一項（s / 4）衡量初始依賴：解題初期即啟用愈高層級，起始依賴值愈大（例如 s = 1 時為 0.25，s = 4 時達 1.00）。
- 第二項（lambda * (1 - m / (f - s + 1))）衡量升級路徑稀疏度：分母 (f - s + 1) 為起訖層級間的完整跨距。若學生依序經歷所有中間層級，則 m = f - s + 1（稀疏度為 0，屬於密集漸進求助）；若跳過中間層級以極少步數直達高層，則稀疏度提高，反映明顯的依賴躍升。
- 抵達 f = 4 之數值範例（lambda = 0.3）：循序漸進（L1->L2->L3->L4，s=1, m=4）得 EPC = 0.25；跳級升級（L1->L4，s=1, m=2）得 EPC = 0.40；直達高層（僅 L4，s=4, m=1）得 EPC = 1.00。
-->

---

## 3.4 層級錨定依賴指標（LADI）

LADI 將分層機制下的 AI 使用行為映射至 **`[0, 10]`** 連續量尺，以最終層級 `2f` 為主錨點，並透過 `+2 EPC` 細分區間內的升級歷程。

<div class="formula-box" style="font-size: 1.12em;">
<div class="piecewise">
<span><i>LADI</i> &nbsp;=</span>
<span class="brace">{</span>
<div class="cases">
<span>0, &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <i>f</i> = 0</span>
<span>2<i>f</i> + 2<i>EPC</i>, &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <i>f</i> ∈ {1, 2, 3, 4}</span>
</div>
</div>
</div>

<div class="fig-box" style="padding: 8px 10px; margin-bottom: 10px;">
<img src="./img/diag5_ladi_scale_zh.svg" alt="LADI 0 到 10 連續量尺與層級錨點示意圖" style="max-height: 190px;">
</div>

<div class="callout" style="margin-top: 6px; padding: 8px 14px;">
<strong>指標分析優勢：</strong> 即使兩位學生最終皆抵達 <strong>L<sub>4</sub></strong>，LADI 仍能精細區辨其歷程差異（漸進 <code>8.50</code> vs. 跳級 <code>8.80</code> vs. 直達 <code>10.00</code>），且 <code>λ</code> 可依課程情境調整校準。
</div>

<!--
層級錨定依賴指標（LADI）之公式結構與分析優勢：
- 分段定義：當 f = 0（全程無 AI 自主解題）時，LADI = 0；當 f 屬於 {1, 2, 3, 4} 時，LADI = 2f + 2*EPC。
- 連續值域 [0, 10]：透過 2f 將紀錄錨定於對應層級的主區間（2、4、6、8），再以 +2*EPC（最大為 2.0，發生於 s = f = 4 且 m = 1）在區間內細分升級歷程，使所有多層級行為皆能映射至 [0, 10] 連續量尺。
- 區間內歷程鑑別力：以前頁抵達 L4 的三種路徑為例（lambda = 0.3），漸進升級之 LADI 為 8.50，跳級升級為 8.80，直達 L4 則為 10.00，精準呈現同層級背後的行為差異。
- 參數可調適性：主錨點 2f 確保最終輔助強度為依賴判定的核心結構，而權重 lambda 則控制升級歷程對總分的影響比例，未來可依不同課程脈絡、題目難度或理論假設進行校準。
-->

---

## 4.1 Smart Coding Tutor（SCT）系統架構

<div class="split64">
<div class="left">

<div class="fig-box">
<img src="./img/fig1_architecture.png" alt="Fig. 1: Smart Coding Tutor 系統架構圖" style="max-height: 410px;">
<div class="fig-cap">Fig. 1：Smart Coding Tutor（SCT）整合式系統架構</div>
</div>

</div>
<div class="right small-text">

### ⚙️ 四大核心整合模組
- **線上評測核心（OJ Core）**：整合題目管理、程式碼編輯器、評測器與測資評估，即時回報 `AC`、`PA`、`WA`、`RE`、`TLE`、`CE` 狀態。
- **分層提示建構器（Level-Based Prompt Builder）**：依據題目、程式碼、錯誤訊息與所選層級（L<sub>1</sub>–L<sub>4</sub>）動態組裝提示送往 AI Tutor。
- **學習狀態分析器（Learning State Analyzer）**：整合提交歷程、錯誤模式與 AI 使用紀錄，驅動：
  - **主動提示觸發器（Proactive Hint Trigger）**
  - **弱點概念題生成器（Concept Question Generator）**

</div>
</div>

<!--
Smart Coding Tutor（SCT）平台系統架構（Fig. 1）：
- 單一封閉整合環境：SCT 將題目管理、程式碼編輯、自動評測、分層 AI 輔助、學習狀態分析與行為日誌記錄整合於同一平台，使學生在同一脈絡中完成作答、除錯與反思，並同步保存完整研究歷程資料。
- 線上評測核心（OJ Core）：採用標準線上評測狀態標籤，包含 Accepted（AC）、Partially Accepted（PA）、Wrong Answer（WA）、Runtime Error（RE）、Time Limit Exceeded（TLE）與 Compilation Error（CE），即時提供執行回饋並作為 AI 觸發與行為分析依據。
- 分層提示建構器（Level-Based Prompt Builder）：將題目敘述、學生現行程式碼、編譯／執行錯誤輸出與所選層級（L1 至 L4）動態封裝為受控提示送往 AI Tutor，嚴格落實各層回饋邊界。
- 學習狀態分析器（Learning State Analyzer）：整合提交紀錄、錯誤模式、停滯狀態與 AI 使用歷程，即時驅動「主動提示觸發器」與「弱點概念題生成器」。
-->

---

## 4.2 SCT 學生端操作介面（L1 與 L2 實景）

<div class="split55">
<div class="left">

<div class="fig-box">
<img src="./img/fig2a_L1_interface.png" alt="L1 執行錯誤提示介面截圖" style="max-height: 350px;">
<div class="fig-cap">(a) L<sub>1</sub> 語法與執行時期錯誤提示介面</div>
</div>

</div>
<div class="right">

<div class="fig-box">
<img src="./img/fig2b_L2_interface.png" alt="L2 邏輯錯誤與程式覆蓋率檢核介面" style="max-height: 350px;">
<div class="fig-cap">(b) L<sub>2</sub> 邏輯除錯提示與程式碼覆蓋率檢核表</div>
</div>

</div>
</div>

<div class="callout" style="margin-top: 10px;">
<strong>多輪對話升級（L<sub>3</sub> & L<sub>4</sub>）：</strong> 較高層級提供多輪對話式 AI 助教介面，支援概念釐清與策略討論（L<sub>3</sub>），乃至流程拆解與虛擬碼結構引導（L<sub>4</sub>），全程同步寫入行為日誌。
</div>

<!--
SCT 學生端分層介面實作細節（Fig. 2a 與 Fig. 2b）：
- 自主升級與留痕控制：每題起始於 L0，學生需透過「AI assistance level」選單主動切換層級；平台完整記錄啟用時點、切換歷程與互動內容，供後續策略與依賴分析。
- 低層級結構化診斷介面（L1 與 L2）：Fig. 2a 為 L1 錯誤訊息提示介面，針對 CE／RE 解讀錯誤堆疊、可能原因與排查方向；Fig. 2b 為 L2 邏輯錯誤提示介面，針對可執行但獲 WA／PA 的程式，提供邏輯檢視建議與程式碼覆蓋率檢核表，引導檢查條件分支、邊界值、資料使用與 I/O 處理。
- 高層級多輪對話介面（L3 與 L4）：升級至 L3 或 L4 後開啟對話式 AI 助教視窗，支援學生依前輪回覆持續追問；L3 側重題意理解、概念釐清與策略討論，L4 則提供流程拆解、策略比較與虛擬碼結構說明。
-->

---

## 5.1 實證研究設計與實驗場域

<div class="fig-box" style="padding: 10px 12px; margin-bottom: 12px;">
<img src="./img/diag6_study_pipeline_zh.svg" alt="實證研究流程與資料蒐集架構圖" style="max-height: 235px;">
</div>

<div class="two-col">
<div class="card small-text">

### 🧪 嚴謹實驗控管
- 三次正式評量期間**全面禁用外部生成式 AI 工具**。
- 所有 AI 輔助互動皆須透過 **SCT 平台**進行，確保層級切換、對話內容與提交結果之資料完整性。

</div>
<div class="card accent small-text">

### 📊 對應四大研究問題之驗證
- **RQ1**：原始成績 vs. 分層調整成績、資訊與非資訊背景 `t` 檢定。
- **RQ2**：L<sub>0</sub>–L<sub>4</sub> 各層級不升級即達成 `AC` 之完成率。
- **RQ3 & RQ4**：AI 稅率四象限分群、LADI 雙峰分布與概念理解相關分析。

</div>
</div>

<!--
實證研究場域、樣本組成與實驗控管：
- 場域與對象：於 114 學年度逢甲大學 Python 程式設計課程實施，共計 112 位修課學生參與，其中資訊相關背景佔 55.36%（62 人）、非資訊背景佔 44.64%（50 人），涵蓋大一至大四學生。
- 練習與正式評量資料：學期間學生於 SCT 完成 86 題日常練習與作業，以確保熟悉平台操作並建立學習歷程觀察；核心量化分析聚焦於 3 次正式課堂評量（每次 3 題，合計 9 道程式實作題），並搭配獨立施測之概念理解評量與課後問卷（回收有效樣本 n = 56）。
- 嚴謹內部效度控管：三次正式評量期間嚴格禁止使用任何外部生成式 AI 工具，所有 AI 輔助互動皆必須於 SCT 平台內完成，確保層級切換、對話日誌、停滯事件與評測結果具備 100% 資料完整性。
-->

---

## 5.2 RQ1 實證結果：分層機制顯著提升評量鑑別度

<div class="three-col" style="margin-bottom: 12px;">
<div class="kpi-card teal">
<div class="kpi-val">0.219 ➔ 0.324</div>
<div class="kpi-label">程式實作與概念理解相關 <code>r</code> 提升（對比先期開放 AI 僅 <code>0.136</code>）</div>
</div>
<div class="kpi-card accent">
<div class="kpi-val">52.7% ➔ 13.4%</div>
<div class="kpi-label">滿分學生比例大幅下降，有效緩解分數天花板集中現象</div>
</div>
<div class="kpi-card">
<div class="kpi-val">3.93 / 5.0</div>
<div class="kpi-label">學生問卷（<code>n = 56</code>）高度認同分層模式較開放模式更具鑑別度</div>
</div>
</div>

| 評量指標（資訊背景 vs. 非資訊背景獨立樣本 `t` 檢定） | 資訊背景均分 | 非資訊背景均分 | `t(110)` | `p` 值 | 95% 信賴區間 |
| :--- | :---: | :---: | :---: | :---: | :---: |
| 原始程式實作成績（未扣 AI 稅） | 81.46 | 71.63 | 1.76 | `.0818`（未達顯著） | `[−1.26, 20.91]` |
| **分層調整後成績（納入 AI 稅率）** | **73.42** | **62.25** | **2.24** | **`.0270*`（達顯著）** | **`[1.29, 21.05]`** |

<div class="callout">
<strong>RQ1 發現：</strong> 納入 AI 輔助成本後，不僅降低滿分集中現象，更使<strong>資訊背景學生的調整後成績顯著高於非資訊背景學生</strong>（<code>73.42</code> vs. <code>62.25</code>，<code>p = .0270</code>），還原了原本被原始高分所掩蓋的能力與 AI 依賴差異。
</div>

<!--
RQ1 評量鑑別度提升之統計證據：
- 與概念理解之一致性提升：先期完全開放 AI 模式下，AI 使用次數與概念理解成績相關僅為 r = 0.136；導入 SCT 分層評量後，程式實作成績與概念理解成績之皮爾森相關係數，由未調整原始分數的 r = 0.219 提升至納入 AI 稅率後的 r = 0.324。
- 有效緩解分數天花板效應：滿分學生比例由原始成績的 52.7% 大幅下降至調整後的 13.4%，顯示分數分布不再過度集中於頂端，鑑別力顯著回升。
- 資訊與非資訊背景獨立樣本 t 檢定：在未扣稅的原始成績上，資訊生（M = 81.46）與非資訊生（M = 71.63）之差異未達統計顯著，t(110) = 1.76，p = .0818，95% CI [-1.26, 20.91]；納入分層 AI 稅率調整後，資訊生均分顯著高於非資訊生（M = 73.42 vs. 62.25），t(110) = 2.244，p = .0270，95% CI [1.29, 21.05]。此結果顯示原始高分掩蓋了非資訊生仰賴較高強度 AI 輔助的現象。
- 學生主觀認同：56 份問卷中，學生對「分層模式較完全開放模式更具評量鑑別度」的平均認同度達 3.93 / 5.0，與量化數據相互呼應。
-->

---

## 5.3 RQ2 實證結果：各輔助層級展現階梯式支持效果

完成率定義 ＝ 曾使用該層級的紀錄中，**未再升級即於該層達成 `AC`** 之比例。

<div style="margin: 14px 0 12px 0;">
<div class="bar-row">
<div><strong>L<sub>0</sub>（自主解題）</strong></div>
<div class="bar-track"><div class="bar-fill teal" style="width: 81.55%;"></div></div>
<div class="bar-pct">81.55%</div>
</div>
<div class="bar-row">
<div><strong>L<sub>1</sub>（執行錯誤提示）</strong></div>
<div class="bar-track"><div class="bar-fill muted" style="width: 21.05%;"></div></div>
<div class="bar-pct">21.05%</div>
</div>
<div class="bar-row">
<div><strong>L<sub>2</sub>（邏輯錯誤提示）</strong></div>
<div class="bar-track"><div class="bar-fill" style="width: 34.88%;"></div></div>
<div class="bar-pct">34.88%</div>
</div>
<div class="bar-row">
<div><strong>L<sub>3</sub>（AI 助教問答）</strong></div>
<div class="bar-track"><div class="bar-fill" style="width: 43.64%;"></div></div>
<div class="bar-pct">43.64%</div>
</div>
<div class="bar-row">
<div><strong>L<sub>4</sub>（完整高強度引導）</strong></div>
<div class="bar-track"><div class="bar-fill accent" style="width: 80.41%;"></div></div>
<div class="bar-pct">80.41%</div>
</div>
</div>

<div class="callout">
<strong>RQ2 發現：</strong> 約 32.39% 有效紀錄全程維持 <strong>L<sub>0</sub></strong>（自主基準，<code>AC</code> 率達 81.55%）；在啟用 AI 的紀錄中，完成率從 <strong>L<sub>1</sub> 的 21.05% 單調遞增至 L<sub>4</sub> 的 80.41%</strong>，顯示高層級具備明確的補償性支持效果，且人工抽樣亦確認回應符合邊界規範。
</div>

<!--
RQ2 各輔助層級之階梯式支持效果解析：
- 完成率操作型定義：若學生解題過程曾進入某層級，該紀錄計入該層級的「使用次數」；但僅當學生在該層級「未再進一步升級即達成 AC」時，始計入該層級的「完成案例」（例如路徑 L1 -> L2 -> L4 在 L1、L2、L4 皆計為使用，但僅在 L4 計為完成）。
- 自主解題基準群體（L0）：約 32.39% 的有效答題紀錄全程維持於 L0，且其 AC 完成率高達 81.55%。論文特別強調，L0 高完成率並非意味 AI 輔助多餘，而是反映該族群本身已具備獨立解題能力，無須動用外部鷹架。
- 啟用 AI 後之單調遞增補償效應：在動用 AI 的紀錄中，當層完成率隨輔助強度穩定攀升：L1 為 21.05%、L2 為 34.88%、L3 為 43.64%、L4 達 80.41%。低層級可在不洩漏解答前提下協助部分學生排除語法或邏輯障礙，而高層級則對深度卡關者發揮顯著補償性支持。
- 提示邊界稽核：研究團隊針對互動日誌進行人工抽樣檢視，確認 LLM 回應整體符合各層設定之邊界規範。
-->

---

## 5.4 RQ3 實證結果：使用策略與 AI 稅率四象限分析

<div class="split55">
<div class="left">

<div class="fig-box">
<img src="./img/fig3_ai_tax_quadrant.png" alt="Fig. 3: AI 稅率與學習成效四象限散佈圖" style="max-height: 430px;">
<div class="fig-cap">Fig. 3：AI 稅率與程式成績四象限分析（中位數：稅率 0.125、分數 80）</div>
</div>

</div>
<div class="right small-text">

### 🎯 差異化成本效益權衡模式
- 平均 AI 使用層級與概念理解呈負相關（**`r = −0.368`**）➔ AI 使用反映真實學習需求，而非隨機點擊。
- **高稅高產出（AI 助攻高效型，30.36%）**：善用高強度引導成功轉化為高實作成績。
- **低稅高產出（高效自主型，25.00%）**：僅需少量或無需 AI 輔助即展現高度精熟。
- **低稅低產出（低投入低回報型，25.89%）**：可能未善用可用提示，或卡關時過晚升級。
- **高稅低產出（高稅負擔型，18.75%）**：即使獲得高強度提示，仍難以轉化為正確程式碼。

</div>
</div>

<!--
RQ3 使用策略與四象限成本效益分群（Fig. 3）：
- 需求驅動的層級選擇：學生的平均 AI 使用層級與概念理解成績呈中度負相關（r = -0.368），顯示概念較佳者傾向使用較低層級，概念較弱者則較常升級至高層級，證實 AI 使用強度反映真實學習需求而非隨機點擊或全面依賴。
- 四象限劃分與族群意涵（Fig. 3）：以樣本中位數（AI 稅率 = 0.125、程式實作成績 = 80）將 112 位學生分為四類：
  1. 高稅高產出（AI 助攻高效型，30.36%）：能有效消化高強度引導並轉化為高程式實作表現。
  2. 低稅高產出（高效自主型，25.00%）：僅憑少量或無 AI 輔助即達成高分。兩類高產出族群合計超過全班半數（55.36%）。
  3. 低稅低產出（低投入低回報型，25.89%）：稅率偏低但成績不理想，顯示可能未善用平台可用提示，或於卡關時過晚決定升級。
  4. 高稅低產出（高稅負擔型，18.75%）：即使動用高強度提示仍無法順利轉化為正確程式碼，屬於最需教師介入補強基礎實作能力之高風險族群。
-->

---

## 5.5 RQ4 實證結果：LADI 呈現顯著雙峰分層分布

學生並未集中於中度依賴區間，而是明顯**分化為「低依賴自主群」與「高依賴求助群」**。

<div style="margin: 16px 0 14px 0;">
<div class="bar-row">
<div><strong>[0, 2) 低依賴</strong></div>
<div class="bar-track"><div class="bar-fill teal" style="width: 32.39%;"></div></div>
<div class="bar-pct">32.39%</div>
</div>
<div class="bar-row">
<div><strong>[2, 4) 輕度依賴</strong></div>
<div class="bar-track"><div class="bar-fill muted" style="width: 3.46%;"></div></div>
<div class="bar-pct">3.46%</div>
</div>
<div class="bar-row">
<div><strong>[4, 6) 中度依賴</strong></div>
<div class="bar-track"><div class="bar-fill muted" style="width: 5.97%;"></div></div>
<div class="bar-pct">5.97%</div>
</div>
<div class="bar-row">
<div><strong>[6, 8) 較高依賴</strong></div>
<div class="bar-track"><div class="bar-fill" style="width: 11.64%;"></div></div>
<div class="bar-pct">11.64%</div>
</div>
<div class="bar-row">
<div><strong>[8, 10] 高度依賴</strong></div>
<div class="bar-track"><div class="bar-fill accent" style="width: 46.54%;"></div></div>
<div class="bar-pct">46.54%</div>
</div>
</div>

<div class="callout">
<strong>關鍵觀察：</strong> 合計近 <strong>79%</strong> 的答題紀錄落於兩端極值區間 — <code>[0, 2)</code> 佔 <strong>32.39%</strong>、<code>[8, 10]</code> 佔 <strong>46.54%</strong>，凸顯在正式評量情境下學生對外部鷹架之需求呈現高度兩極化。
</div>

<!--
RQ4 LADI 指標之雙峰分層分布特徵：
- 五個區間之實際占比分布：
  - [0, 2) 低依賴：32.39%
  - [2, 4) 輕度依賴：3.46%
  - [4, 6) 中度依賴：5.97%
  - [6, 8) 較高依賴：11.64%
  - [8, 10] 高度依賴：46.54%
- 雙峰極化現象：合計高達 78.93%（近八成）的答題紀錄落於兩端極值區間（[0, 2) 與 [8, 10]），中間三個過渡區間合計僅佔 21.07%。
- 學習行為解讀：在正式計分評量的時間與成績壓力下，學生並未均勻分布於中度依賴區帶，而是呈現明確分化——具備獨立能力者全程停留於 L0，一旦遭遇 L1／L2 無法迅速排除的解題瓶頸，便傾向一路升級至 L4 結構化引導以確保通過測資。
-->

---

## 5.6 RQ4 實證結果：LADI 與概念理解表現之關聯

<div class="split55">
<div class="left">

<div class="fig-box">
<img src="./img/fig4_ladi_scatter.png" alt="Fig. 4: 概念理解成績與 LADI 散佈圖" style="max-height: 420px;">
<div class="fig-cap">Fig. 4：概念理解分數與 LADI 指標之分群迴歸散佈圖</div>
</div>

</div>
<div class="right small-text">

### 📉 LADI 之初步效標關聯效度證據
- **整體相關性**：呈中度負相關（**`r = −0.383`**）— 概念理解越佳的學生，整體 AI 依賴程度越低。
- **依學科背景分組**：
  - **資訊背景學生**：**`r = −0.509`**（隨概念提升，依賴度顯著下降）。
  - **非資訊背景學生**：**`r = −0.187`**（即便概念提升，仍受限於語法熟練度與實作經驗而需輔助）。
- **依年級分析**：
  - 大四：**`r = −0.779`** ｜ 大三：`r = −0.353`
  - 大二：`r = −0.350` ｜ 大一：`r = +0.150`

</div>
</div>

<!--
RQ4 LADI 與概念理解之關聯及分群調節效應（Fig. 4）：
- 整體效標關聯證據：LADI 與概念理解成績呈現中度負相關（r = -0.383），略強於單純平均層級（r = -0.368），顯示納入升級歷程後的指標更能敏感反映概念掌握與 AI 依賴之間的對應關係。
- 學科背景調節差異：資訊背景學生的負相關明顯較強（r = -0.509），隨著概念理解提升，AI 依賴度清晰下降；非資訊背景學生之負相關則較弱（r = -0.187），主因在於其即便理解抽象概念，仍受限於語法熟練度不足、實作經驗有限或除錯流程尚未穩定，故在寫作階段仍需仰賴 AI 鷹架。
- 年級演化趨勢：負相關強度隨年級穩定加深——大四（r = -0.779）、大三（r = -0.353）、大二（r = -0.350），而大一新生則呈微弱正相關（r = +0.150），反映先備知識、程式經驗與自我調節成熟度會影響概念轉化為獨立解題的效率。
- 統計推論界線：本分析屬橫斷面相關檢定，僅能提供 LADI 的初步效標關聯效度證據，尚無法直接推論「低理解導致高依賴」或「高依賴削弱理解」之單向因果關係。
-->

---

## 5.7 綜合討論、教學啟示與研究限制

<div class="two-col">
<div class="card small-text">

### 🏫 教學與評量實務啟示
- **不禁止 AI 也能守住公平性**：透過分層設計與明確 AI 稅率，兼顧新手的鷹架支持與成績之可解釋性。
- **差異化輔導非資訊背景新手**：非資訊生負相關較弱（`r = −0.187`），顯示其除概念外仍需語法與除錯實作引導。
- **及早辨識高風險學習族群**：四象限分析可協助教師提前關注「高稅負擔型（18.75%）」與「低投入低回報型（25.89%）」學生。

</div>
<div class="card accent small-text">

### 🔬 方法學反思與研究限制
- **相關而非因果**：LADI 與概念分數之負相關（`r = −0.383`）屬初步效標關聯證據，尚無法直接推論因果方向。
- **主動提示時機仍待優化**：學生對主動式提示介入時機之滿意度平均僅 **`2.96 / 5.0`**，停滯偵測門檻與觸發頻率須進一步校準。
- **單一課程脈絡**：權重參數 `λ = 0.3` 與各層稅率之跨課程穩健性仍須後續驗證。

</div>
</div>

<!--
教學實務啟示與方法學限制反思：
- 兼顧公平與支持之評量範式：透過五級分層邊界與公開 AI 稅率，教師無須全面禁用 AI，即可有效緩解分數壓縮並保留成績可解釋性。
- 精準教學介入依據：四象限分群與背景分析為差異化輔導提供明確座標——針對低投入低回報型（25.89%）加強求助時機引導；針對高稅負擔型（18.75%）與非資訊背景新手（r = -0.187）補強語法熟練度、除錯步驟與程式實作演練。
- 主動提示時機之實證限制：課後問卷顯示學生對「主動式提示介入時機」的平均滿意度僅為 2.96 / 5.0。此發現呼應 Chen 等人 [10] 之研究，指出停滯偵測門檻、觸發頻率與介入節奏若未精準校準，易干擾學習專注度或降低自主感受。
- 推論範圍與參數限制：本研究資料來自單一 Python 課程（N = 112），且權重參數（lambda = 0.3）與每層 5% 之線性稅率屬初始設定，其跨課程與跨語言穩健性仍待驗證。
-->

---

## 6. 結論與未來研究方向

<div class="fig-box" style="padding: 8px 10px; margin-bottom: 8px;">
<img src="./img/diag7_rq_conclusions_zh.svg" alt="RQ1 至 RQ4 實證結論全景概念圖" style="max-height: 360px;">
</div>

<div class="future-strip">
<div class="future-pill"><strong>🚀 1. 跨課程與縱貫式驗證</strong><br>跨學期與不同程式課程檢驗 LADI 穩定性，以及長期獨立解題遷移成效。</div>
<div class="future-pill"><strong>🔔 2. 優化主動式提示時機</strong><br>精進停滯偵測模型與觸發頻率，提升介入滿意度（突破目前 <code>2.96 / 5.0</code>）。</div>
<div class="future-pill"><strong>🎛️ 3. 參數與稅率實證校準</strong><br>依題目難度與程式語言特性，系統性校準權重 <code>λ</code> 與各層級 AI 稅率。</div>
</div>

<!--
四大研究問題總結與未來研究藍圖：
- 實證成果總覽：
  - RQ1：分層稅率將滿分集中率由 52.7% 降至 13.4%，程式與概念相關由 r = 0.219 升至 0.324，並顯現資訊與非資訊背景之顯著差異（p = .0270）。
  - RQ2：除 32.39% 自主基準紀錄（L0，AC 率 81.55%）外，啟用 AI 之當層完成率由 L1（21.05%）單調遞增至 L4（80.41%），驗證階梯式補償支持。
  - RQ3：四象限分析揭露多元成本效益策略，且平均層級與概念分數呈負相關（r = -0.368），顯示求助具真實需求依據。
  - RQ4：LADI 呈顯著雙峰分布（兩端合計 78.93%）並與概念理解呈中度負相關（r = -0.383；資訊生 r = -0.509；大四 r = -0.779）。
- 後續三大精進方向：（1）開展跨課程與跨學期縱貫研究，檢驗 LADI 穩定性、因果動態與長期獨立解題遷移成效；（2）優化停滯偵測演算法與主動提示頻率，使介入滿意度突破 2.96 / 5.0；（3）依程式語言與題目難度系統性實證校準 lambda 與稅率結構。
-->

---

<!-- _class: closing -->

# 感謝聆聽 · 敬請指教！

<p style="font-size: 1.02em; max-width: 820px;">
分層式大型語言模型程式輔助機制於程式學習之應用與分析<br>
<span style="font-size: 0.82em; opacity: 0.85;">Application and Analysis of a Tiered LLM-Based Programming Assistance Mechanism in Programming Learning</span>
</p>

<div class="contact-card">
<strong>薛念林（Nien-Lin Hsueh）<sup>+</sup></strong> &nbsp;·&nbsp; <code>nlhsueh@fcu.edu.tw</code><br>
<strong>Ying-Chang Lu</strong> &nbsp;·&nbsp; <code>m1305878@o365.fcu.edu.tw</code><br>
逢甲大學 資訊工程學系（Feng Chia University）<br>
<span style="font-size: 0.85em; opacity: 0.85;">國科會計畫補助：NSTC114-2221-E-035-077 · 歡迎提問與交流！</span>
</div>

<!--
論文出處與核心論點摘要：
- 論文資訊：Nien-Lin Hsueh 與 Ying-Chang Lu，〈Application and Analysis of a Tiered LLM-Based Programming Assistance Mechanism in Programming Learning〉，《Journal of Information Science and Engineering (JISE)》，逢甲大學資訊工程學系。
- 計畫致謝：本研究承蒙中華民國國家科學及技術委員會（NSTC）專題研究計畫補助，計畫編號 NSTC114-2221-E-035-077。
- 核心學術主張：將生成式 AI 融入程式設計教育的關鍵，並非「全面禁止或完全放任」的二元抉擇，而是如何透過明確的輔助邊界、可觀測的制度成本（AI 稅率）與歷程導向依賴指標（LADI），在支持學生完成任務的同時，守住正式評量結果的解釋效度。
-->

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

// Dynamic bounded in-place hover zoom (max 2.15x, strictly within 1280x720 safe area)
document.querySelectorAll('.split64 .fig-box img, .split55 .fig-box img, .split46 .fig-box img, .split73 .fig-box img, .two-col .fig-box img, .three-col .fig-box img').forEach((img) => {
  const box = img.closest('.fig-box');
  img.addEventListener('mouseenter', () => {
    const sec = img.closest('section');
    if (!sec) return;
    img.style.transform = '';
    const sr = sec.getBoundingClientRect();
    const ir = img.getBoundingClientRect();
    if (!ir.width || !ir.height) return;
    const padX = sr.width * (24 / 1280);
    const padTop = sr.height * (52 / 720);
    const padBot = sr.height * (22 / 720);
    const safeL = sr.left + padX;
    const safeR = sr.right - padX;
    const safeT = sr.top + padTop;
    const safeB = sr.bottom - padBot;
    const maxW = safeR - safeL;
    const maxH = safeB - safeT;
    const s = Math.min(2.15, (maxW / ir.width) * 0.98, (maxH / ir.height) * 0.98);
    if (s <= 1.03) return;
    const L = Math.max(0, ir.left - safeL);
    const R = Math.max(0, safeR - ir.right);
    const T = Math.max(0, ir.top - safeT);
    const B = Math.max(0, safeB - ir.bottom);
    const ox = (L + R) > 0 ? (L / (L + R)) * 100 : 50;
    const oy = (T + B) > 0 ? (T / (T + B)) * 100 : 50;
    img.style.transformOrigin = ox.toFixed(1) + '% ' + oy.toFixed(1) + '%';
    img.style.transform = 'scale(' + s.toFixed(3) + ')';
    img.classList.add('is-zoomed');
    if (box) box.classList.add('is-zoomed');
  });
  img.addEventListener('mouseleave', () => {
    img.style.transform = '';
    img.classList.remove('is-zoomed');
    if (box) box.classList.remove('is-zoomed');
  });
});


// Bilingual toggle preserving current slide hash
document.addEventListener('click', (e) => {
  const langBtn = e.target.closest('.lang-btn');
  if (!langBtn) return;
  e.preventDefault();
  const target = langBtn.getAttribute('href');
  if (target) window.location.href = target + (window.location.hash || '');
});

</script>
