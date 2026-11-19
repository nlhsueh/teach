---
marp: true
theme: gaia
size: 16:9
paginate: true
html: true
header: '<div class="hdr-wrap"><span class="hdr-title">以軟體演化數據分析設計模式之使用度</span><div class="nav-dropdown"><button class="nav-btn">章節導覽 ▾</button><div class="nav-menu"><a href="#2">破題：未雨綢繆或積灰塵？</a><a href="#3">簡報大綱</a><a href="#4">1. 研究動機與問題</a><a href="#6">2. 背景與相關研究</a><a href="#7">3. 模式使用度評估方法</a><a href="#11">4. PUA 系統與實證結果</a><a href="#15">5. 統計分析與研究威脅</a><a href="#18">6. 結論與未來研究</a></div></div></div>'
footer: '薛念林（Nien-Lin Hsueh）· 逢甲大學資訊工程學系 · JISE Vol. 36, pp. 53–73 (2020)'
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
  min-width: 225px;
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
  line-height: 1.25;
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
li { margin-bottom: 5px; line-height: 1.45; }
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
section table th strong, section table th code { color: #ffffff !important; }
section.lead strong, section.closing strong { color: #ffffff !important; }
section.lead code, section.closing code { color: #bae6fd !important; }

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
  letter-spacing: 0.05em;
  padding: 5px 14px;
  border-radius: 999px;
  margin-bottom: 18px;
}

section.lead h1 {
  color: #ffffff;
  font-size: 2.1em;
  font-weight: 900;
  line-height: 1.26;
  margin-bottom: 16px;
  text-align: left;
}

section.lead .subtitle {
  color: #cbd5e1;
  font-size: 0.94em;
  line-height: 1.55;
  margin-bottom: 26px;
  max-width: 940px;
}

section.lead .meta-box {
  border-left: 4px solid #f43f5e;
  padding-left: 18px;
  color: #e2e8f0;
  font-size: 0.86em;
  line-height: 1.62;
}

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
section.closing h1 { color: #ffffff; font-size: 2.2em; margin-bottom: 12px; }
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
.two-col { display: grid; grid-template-columns: 1fr 1fr; gap: 18px; align-items: stretch; }
.three-col { display: grid; grid-template-columns: repeat(3, 1fr); gap: 14px; align-items: stretch; }
.four-col { display: grid; grid-template-columns: repeat(4, 1fr); gap: 12px; align-items: stretch; }
.split64 { display: grid; grid-template-columns: 56% 42%; gap: 2%; align-items: center; }
.split55 { display: grid; grid-template-columns: 49% 49%; gap: 2%; align-items: center; }
.split46 { display: grid; grid-template-columns: 42% 56%; gap: 2%; align-items: center; }

/* Cards & Callouts */
.card {
  background: #ffffff;
  border: 1px solid var(--slate-200);
  border-top: 3.5px solid var(--navy);
  border-radius: 8px;
  padding: 12px 16px;
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

.kpi-val { font-size: 1.35em; font-weight: 800; color: var(--navy); line-height: 1.15; margin-bottom: 2px; }
.kpi-card.accent .kpi-val { color: var(--accent); }
.kpi-card.teal .kpi-val { color: var(--teal); }
.kpi-label { font-size: 0.74em; color: var(--slate-700); line-height: 1.32; }

.callout {
  background: #f8fafc;
  border-left: 4px solid var(--accent);
  border-radius: 0 8px 8px 0;
  padding: 9px 15px;
  margin-top: 9px;
  font-size: 0.85em;
  color: var(--slate-700);
}

.callout strong { color: var(--navy); }
.callout.teal { border-left-color: var(--teal); background: var(--teal-soft); }

/* Tables */
table {
  width: 100%;
  border-collapse: collapse;
  font-size: 0.72em;
  margin: 5px 0;
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
  padding: 4px 8px;
  border: 1px solid var(--slate-200);
  vertical-align: middle;
  line-height: 1.3;
}

tr:nth-child(even) td { background: #f8fafc; }

table.dense { font-size: 0.62em; }
table.dense th, table.dense td { padding: 3px 6px; text-align: center; }
table.dense td:first-child, table.dense th:first-child { text-align: left; font-weight: 700; }
.hi-cell { background: #ccfbf1 !important; color: #0f766e !important; font-weight: 800; }
.mid-cell { background: #e0f2fe !important; color: #1b365d !important; font-weight: 700; }
.zero-cell { color: #94a3b8; }

/* Formula Box */
.formula-box {
  background: #f8fafc;
  border: 1.5px solid #cbd5e1;
  border-left: 4px solid var(--navy);
  border-radius: 8px;
  padding: 8px 14px;
  margin-bottom: 8px;
  display: flex;
  justify-content: center;
  align-items: center;
  font-family: 'Georgia', 'Noto Sans TC', serif;
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
  margin: 0 6px;
  line-height: 1.15;
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

.split64 .left img:hover, .split55 .left img:hover, .split46 .left img:hover {
  transform: scale(1.22);
  transform-origin: left bottom;
  box-shadow: 0 12px 28px rgba(15, 23, 42, 0.22);
  position: relative;
  z-index: 30;
}

.split64 .right img:hover, .split55 .right img:hover, .split46 .right img:hover {
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

.small-text { font-size: 0.81em; }

/* Incremental RQ Grid */
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
  gap: 18px;
  background: #ffffff;
  border: 1px solid var(--slate-200);
  border-left: 5px solid var(--navy);
  border-radius: 10px;
  padding: 14px 20px;
  box-shadow: 0 2px 8px rgba(15, 23, 42, 0.06);
  box-sizing: border-box;
}

.rq-card.teal { border-left-color: var(--teal); }
.rq-card.accent { border-left-color: var(--accent); }
.rq-card img { width: 84px; height: 84px; flex-shrink: 0; border-radius: 10px; }
.rq-hook { font-size: 0.96em; font-weight: 800; color: var(--navy); line-height: 1.32; margin-bottom: 5px; }
.rq-card.teal .rq-hook { color: var(--teal); }
.rq-card.accent .rq-hook { color: var(--accent); }
.rq-q { font-size: 0.82em; color: var(--slate-700); line-height: 1.44; }

.obj-strip { display: grid; grid-template-columns: repeat(4, 1fr); gap: 10px; margin-bottom: 14px; }
.obj-pill {
  background: var(--slate-100);
  border: 1px solid var(--slate-200);
  border-top: 3px solid var(--navy);
  border-radius: 7px;
  padding: 7px 10px;
  font-size: 0.72em;
  line-height: 1.34;
  color: var(--slate-700);
}
.obj-pill strong { color: var(--navy); }

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

<div class="badge">Journal of Information Science and Engineering · Vol. 36, pp. 53–73 (2020)</div>

# 以軟體演化數據分析設計模式之使用度

<div class="subtitle">
<strong>Design Pattern Analysis with Software Evolution Data</strong><br>
結合<strong>模式應用情境（PAC）</strong>、<strong>預期模式使用方式（EPU）</strong>與<strong>使用程度指標（DoU）</strong>，跨越連續版本實證檢驗設計模式是否真正發揮維護效益
</div>

<div class="meta-box">
<strong>薛念林（Nien-Lin Hsueh）</strong><br>
逢甲大學資訊工程學系 · 台中市 407 台灣<br>
<code>nlhsueh@fcu.edu.tw</code> · DOI: <code>10.6688/JISE.202001_36(1).0004</code>
</div>

<div class="grant">
科技部專題研究計畫補助：MOST 106-2221-E-035-MY2
</div>

---

## 破題：精心套用的設計模式，是未雨綢繆，還是積滿灰塵？

<div class="fig-box" style="padding: 6px; margin-bottom: 10px; background: #fbf9f2;">
<img src="./img/pattern20_hook.jpg" alt="過度設計積灰塵 vs 演化中真正被使用的設計模式" style="max-height: 415px; border-radius: 6px;">
</div>

<div class="callout" style="margin-top: 6px; padding: 9px 16px;">
<strong>核心洞察：</strong> 開發者常套用設計模式以換取未來擴充彈性；然而在 <strong>15 個真實開源專案（296 次演化）</strong>的實證中，多數已部署的模式在後續版本中<strong>幾乎未被擴充或重複使用</strong>！
</div>

---

## 簡報大綱

<div class="outline-grid">

<div class="outline-item">
<div class="outline-num">1</div>
<div class="outline-body">

[**研究動機與研究問題**](#4)
為何單一版本快照無法衡量維護性？本研究之四大目標與兩個研究問題（RQ1–RQ2）。

</div>
</div>

<div class="outline-item">
<div class="outline-num">2</div>
<div class="outline-body">

[**背景與相關研究回顧**](#6)
比較 12 篇設計模式評估文獻（Table 1）與圖形相似度自動模式偵測技術。

</div>
</div>

<div class="outline-item">
<div class="outline-num">3</div>
<div class="outline-body">

[**設計模式使用度評估方法**](#7)
模式四大角色分類、FR/NFR 意圖拆解、PAC 與 EPU 形式化定義及 DoU 指標。

</div>
</div>

<div class="outline-item">
<div class="outline-num">4</div>
<div class="outline-body">

[**PUA 工具設計與實證結果**](#11)
Pattern Utilization Analyzer 系統架構、JHotDraw 案例剖析與 15 個開源專案實驗數據。

</div>
</div>

<div class="outline-item">
<div class="outline-num">5</div>
<div class="outline-body">

[**統計分析與研究威脅**](#15)
單因子變異數分析（ANOVA）檢定 RQ1 與 RQ2、Scheffé 事後檢定及四大效度威脅。

</div>
</div>

<div class="outline-item">
<div class="outline-num">6</div>
<div class="outline-body">

[**結論與未來研究方向**](#18)
RQ1–RQ2 實證總結、對開發團隊之實務價值與 PUA 雲端化展望。

</div>
</div>

</div>

---

## 1.1 研究動機：為何靜態快照無法衡量設計模式價值？

<div class="fig-box" style="padding: 8px 10px; margin-bottom: 10px;">
<img src="./img/diag1_static_vs_evolution_zh.svg" alt="靜態快照評估 vs 軟體演化歷程使用度評估" style="max-height: 360px;">
</div>

<div class="callout">
<strong>演化評估原則：</strong> 設計模式的核心價值在於提升長期的<strong>可維護性與可擴充性</strong>。若過度設計或誤用反增維護負擔，因此評估必須橫跨<strong>所有連續版本</strong>，而非只看單一時間點的靜態結構。
</div>

---

## 1.2 研究目標與兩個核心研究問題

<div class="obj-strip">
<div class="obj-pill"><strong>1. 提出評估方法</strong><br>以演化數據形式化定義設計模式使用度。</div>
<div class="obj-pill"><strong>2. 開發自動化工具</strong><br>實作網頁版 <code>PUA</code> 自動化分析系統。</div>
<div class="obj-pill"><strong>3. 大規模開源實證</strong><br>跨 15 個開源專案（296 次演化）分析 11 種模式。</div>
<div class="obj-pill"><strong>4. 統計假說檢定</strong><br>驗證使用度是否受模式類型或專案影響。</div>
</div>

本研究透過單因子變異數分析（One-Way ANOVA）檢定兩項關鍵問題*（逐步揭曉）*：

<div class="rq-stage">

* <div class="rq-card teal"><img src="./img/rq1_pattern.svg" alt="RQ1 模式類型與 DoU"><div><div class="rq-hook"><span class="rq-tag" style="background:#0f766e;">RQ1</span> 某些設計模式天生就比其他模式更容易被發揮嗎？</div><div class="rq-q"><strong>已部署設計模式的使用程度（DoU）與「模式類型」之間是否存在顯著統計差異？</strong>（涵蓋 9 組共 11 種品質改善型 GoF 設計模式。）</div></div></div>
* <div class="rq-card accent"><img src="./img/rq2_project.svg" alt="RQ2 開源專案與 DoU"><div><div class="rq-hook"><span class="rq-tag">RQ2</span> 還是模式能否發揮價值，取決於專案領域與設計紀律？</div><div class="rq-q"><strong>已部署設計模式的使用程度（DoU）與「開源軟體專案」之間是否存在顯著統計差異？</strong>（橫跨 15 個真實世界 Java 開源系統。）</div></div></div>

</div>

---

## 2. 背景與相關研究回顧（Table 1）

既有研究多採靜態指標、受控實驗、問卷調查或腐化分析，**缺乏以自動化工具衡量跨版本「模式使用度」的實證方法**。

| 研究類型 | 代表文獻 | 方法與程式碼分析 | 研究標的與核心焦點 |
| :--- | :--- | :--- | :--- |
| **靜態指標與品質** | Huston [15]; Hsueh et al. [13] | 指標分析 / 量化法（是/否） | 設計模式：與 OO 指標之相容性、模式良構性驗證 |
| **受控維護實驗** | Prechelt et al. [23, 24]; Ng et al. [20, 21] | 人工受控實驗 | 開發人員：模式效益、文件化輔助與預期變更維護 |
| **文獻回顧與調查** | Zhang & Budgen [32, 33] | 系統性回顧與專家調查（否） | 論文與專家：僅 3 種模式獲高評價，四分之一評價偏低 |
| **演化、污垢與缺陷** | Aversano et al. [2]; Vokáč [30]; Izurieta [16] | 自動化工具分析程式碼（是） | 軟體系統：修改頻率、缺陷關聯、模式污垢（Grime）與腐化 |
| **演化使用度評估** | **Hsueh [12] 與本研究（2020）** | **自研 PUA 自動化工具（是）** | **15 個開源專案（296 次演化）：PAC/EPU 符合度與 DoU** |

<div class="callout teal">
<strong>設計模式偵測基礎：</strong> 採用 <strong>Tsantalis et al. [28]</strong> 提出之圖形相似度評分演算法（優於不支援變異體之 DP-Miner [6]），在 JHotDraw 上可達 <strong>100% 精確率與 100% 召回率</strong>。
</div>

---

## 3.1 設計模式使用度評估方法總覽

<div class="fig-box" style="padding: 8px 10px; margin-bottom: 10px;">
<img src="./img/diag2_eval_pipeline_zh.svg" alt="雙軌設計模式使用度評估流程" style="max-height: 360px;">
</div>

<div class="callout">
<strong>雙軌評估架構：</strong> <strong>路徑 A（理論層）</strong>篩選品質改善型模式，自 NFR 意圖定義<em>預期模式使用方式（EPU）</em>；<strong>路徑 B（實證層）</strong>逐版本萃取<em>模式應用情境（PAC）</em>，比對跨版本變更是否符合預期。
</div>

---

## 3.2 模式角色分類與 FR/NFR 意圖拆解

並非所有設計模式皆為了解決維護性問題。我們先將設計模式分為**四大角色** [14]，並聚焦於**品質改善者（Quality-Improver）**：

<div class="four-col" style="margin-bottom: 10px;">
<div class="card small-text">

### 活動促進者
協助常見設計活動（系統分解、物件配置、存取控制與元件組合）。

</div>
<div class="card teal small-text" style="background: var(--teal-soft);">

### ★ 品質改善者
**本研究核心：** 滿足基本功能同時提升非功能品質（可擴充性、可維護性）。

</div>
<div class="card small-text">

### 衝突解決者
協調資源競爭、需求分歧與設計階段頻繁出現的副作用衝突。

</div>
<div class="card small-text">

### 問題解決者
處理邊界條件與可靠性例外（如 Observer 解決資料不一致問題）。

</div>
</div>

<div class="split55">
<div class="left">
<div class="fig-box" style="padding: 8px;">
<img src="./img/fig4_fr_nfr_strategy.png" alt="Strategy 模式之 FR 與 NFR 結構" style="max-height: 155px;">
<div class="fig-cap">Fig. 4 · Strategy 模式之功能結構 FR-structure（左）與非功能結構 NFR-structure（右）</div>
</div>
</div>
<div class="right small-text">

- **功能意圖（FR-Intent）**：讓 `Context` 類別呼叫演算法以解決問題（基本結構）。
- **非功能意圖（NFR-Intent）**：額外引入 `Strategy` 介面角色，使日後可**直接新增或移除 `ConcreteStrategy`** 而不改動 `Context`，提升擴充性。

</div>
</div>

---

## 3.3 形式化模型：PAC、EPU 與使用度判定謂詞

<div class="split55">
<div class="left">

<div class="formula-box">
<strong>PAC(dp, D)</strong>&nbsp; = &nbsp;{ &lt;element, r&gt; }
</div>

<div class="formula-box teal">
<strong>EPU(dp)</strong>&nbsp; = &nbsp;{ &lt;role, operator&gt; }, &nbsp;operator ∈ {+, −}
</div>

<div class="formula-box accent" style="display: block; text-align: center; font-size: 0.8em; line-height: 1.48;">
<strong>utilized(dp, D<sub>j+1</sub>)</strong> &nbsp;⇔<br>
∃ D<sub>j</sub>, Δ(PAC(dp, D<sub>j</sub>), PAC(dp, D<sub>j+1</sub>)) 符合 EPU(dp)
</div>

<div class="card small-text">

### Strategy 範例（資料壓縮系統）
- **PAC**：`{<DataCompression, R_C>, <CompressionTool, R_S>, <RAR, R_CS>, <ZIP, R_CS>}`
- **EPU(Strategy)**：`{<R_CS, +>, <R_CS, −>}`（新增或移除具體策略類別）。

</div>

</div>
<div class="right">

<div class="fig-box" style="padding: 10px;">
<img src="./img/fig5_utilized_example.png" alt="Strategy 模式於後續版本新增 7-zip 演算法" style="max-height: 200px;">
<div class="fig-cap">Fig. 5 · 於版本 D<sub>j+1</sub> 新增 <code>7-zip</code> 符合 EPU(Strategy)</div>
</div>

<div class="callout teal" style="margin-top: 10px;">
<strong>核心判定準則：</strong> 若某設計模式在相鄰版本 D<sub>j</sub> → D<sub>j+1</sub> 間的結構差異 Δ(PAC) 恰好符合其預期操作 EPU(dp)，即判定該模式於此演化步驟中<strong>被有效使用（utilized）</strong>。
</div>

</div>
</div>

---

## 3.4 量化演化效益：模式使用程度（DoU）指標

<div class="split46">
<div class="left">

<div class="formula-box" style="padding: 12px 16px; margin-bottom: 12px;">
<strong>DoU</strong>&nbsp; = &nbsp;
<span class="frac">
<span class="frac-num">實際被使用次數（# of utilized applications）</span>
<span class="frac-den">模式存活演化次數（# of pattern evolution）</span>
</span>
</div>

<div class="card small-text">

### Fig. 6 計算範例（8 個版本、5 個模式實例）
- **▲** = 已部署；**▲'** = 發生有效使用變更；**X** = 已移除。
- `dp1`（V<sub>1</sub>–V<sub>8</sub>）：於 V<sub>3</sub>→V<sub>4</sub>、V<sub>4</sub>→V<sub>5</sub> 使用 2 次 / 7 次演化 = **2/7**。
- `dp2`（V<sub>1</sub>–V<sub>8</sub>）：有效使用 3 次 / 7 次演化 = **3/7**（最高）。
- `dp3`（V<sub>3</sub>–V<sub>8</sub>）：有效使用 1 次 / 5 次演化 = **1/5**。
- `dp4`（V<sub>3</sub>–V<sub>5</sub>）：於 V<sub>5</sub> 移除 → 1 次 / 2 次演化 = **1/2**。
- `dp5`（V<sub>3</sub>–V<sub>8</sub>）：全程未使用 → **0/5**。

</div>

</div>
<div class="right">

<div class="fig-box" style="padding: 10px;">
<img src="./img/fig6_dou_example.png" alt="五個設計模式實例於八個版本中之 DoU 計算範例" style="max-height: 365px;">
<div class="fig-cap">Fig. 6 · 8 個版本（V<sub>1</sub>–V<sub>8</sub>）中 5 個設計模式實例（dp<sub>1</sub>–dp<sub>5</sub>）之 DoU 計算</div>
</div>

</div>
</div>

---

## 4.1 PUA 工具架構與四步驟分析流程

本研究實作網頁版工具 **Pattern Utilization Analyzer（PUA）**，整合三大核心模組：**版本控制模組**、**PAC 模組**與 **PAE/EPU 模組**。

<div class="split46">
<div class="left">

<div class="fig-box" style="padding: 8px;">
<img src="./img/fig7_pua_arch.png" alt="Pattern Utilization Analyzer (PUA) 系統架構" style="max-height: 375px;">
<div class="fig-cap">Fig. 7 · PUA（Pattern Utilization Analyzer）系統架構</div>
</div>

</div>
<div class="right small-text">

<div class="card" style="margin-bottom: 8px;">

### 步驟 1 · 收集多版本原始碼
自 SourceForge 收集開源專案歷代發行版本，匯入 PUA 的**版本控制模組**管理。

</div>

<div class="card teal" style="margin-bottom: 8px;">

### 步驟 2 · 透過 Pattern4 偵測 11 種 GoF 模式
運用 Tsantalis 圖形比對工具 [28, 29] 偵測各版本模式：
- **建立型**：Factory Method（`FM`）、Prototype（`P`）
- **結構型**：Adapter-Command（`AC`）、Composite（`C`）、Decorator（`D`）
- **行為型**：Observer（`O`）、State-Strategy（`SS`）、Template Method（`TM`）、Visitor（`V`）

</div>

<div class="card accent">

### 步驟 3 與 4 · PAC/EPU 比對 → 產出 DoU
逐版本建立 `PAC`、檢驗相鄰版本是否符合 `EPU`，並自動計算各實例與專案之 **DoU**。

</div>

</div>
</div>

---

## 4.2 案例剖析：JHotDraw 的 Observer 模式演化

以 **JHotDraw** 連續五個版本（`5.2 → 5.3 → 5.4b1 → 5.4b2 → 6.0b1`）為例，追蹤 **6 個 Observer 實例**（`dp1`–`dp6`）：

<div class="split55">
<div class="left">

<div class="fig-box" style="padding: 10px;">
<img src="./img/fig8_jhotdraw_observer.png" alt="JHotDraw 專案 Observer 模式使用度分析結果" style="max-height: 320px;">
<div class="fig-cap">Fig. 8 · JHotDraw（5.2–6.0b1）6 個 Observer 實例之 PUA 分析結果</div>
</div>

</div>
<div class="right">

<div class="three-col" style="margin-bottom: 10px;">
<div class="kpi-card teal">
<div class="kpi-val">3/4</div>
<div class="kpi-label"><code>dp3</code>（75% 使用率）</div>
</div>
<div class="kpi-card">
<div class="kpi-val">1/3–1/4</div>
<div class="kpi-label"><code>dp1</code>、<code>dp4</code>、<code>dp5</code></div>
</div>
<div class="kpi-card accent">
<div class="kpi-val">0/4, 0/3</div>
<div class="kpi-label"><code>dp2</code>、<code>dp6</code>（未使用）</div>
</div>
</div>

<div class="card small-text">

### 實例層級觀察
- **`dp1`–`dp4`** 於 v5.2 部署（歷經 4 次演化）：`dp3` 在 4 次演進中有 3 次被有效擴充（`DoU = 3/4`），而 `dp2` 全程未被使用（`0/4`）。
- **`dp5`–`dp6`** 於 v5.3 引入（歷經 3 次演化）：`dp5` 使用 1 次（`1/3`），`dp6` 未使用（`0/3`）。
- 在完整 8 次 JHotDraw 演化中，**Observer 達全實驗最高 DoU = `0.350`**。

</div>

</div>
</div>

---

## 4.3 實驗設定：15 個開源專案與 296 次軟體演化

我們選取 SourceForge 上 **15 個跨領域 Java 開源專案**（繪圖、測試、機器學習、語意網、財務、音樂編輯等），涵蓋 **2000–2012 年**（Table 2）：

<div class="two-col">
<div>

| 開源專案 | 演化次數 | 版本範圍 | 開發時間區間 |
| :--- | :---: | :---: | :--- |
| **FreeMind** | 16 | 0.0.2–0.9.0 | 2000/06 – 2011/02 |
| **HtmlUnit** | 28 | 1.0.0–2.9.0 | 2002/05 – 2011/08 |
| **Jaxe** | 38 | 1.0–3.5 | 2002/06 – 2011/06 |
| **JConvert** | 9 | 1.0.0–1.1.0 | 2007/08 – 2011/05 |
| **JEdit** | 27 | 2.3–4.5.1 | 2000/01 – 2012/03 |
| **Jena** | 17 | 2.0–2.6.4 | 2003/08 – 2010/12 |
| **JGnash** | 26 | 1.0.1–1.10.5 | 2003/01 – 2006/03 |
| **JHotDraw** | 8 | 5.2–7.6 | 2001/02 – 2011/01 |

</div>
<div>

| 開源專案 | 演化次數 | 版本範圍 | 開發時間區間 |
| :--- | :---: | :---: | :--- |
| **JMemorize** | 12 | 0.7.0–1.3.0 | 2004/10 – 2008/03 |
| **JUnit** | 19 | 3.4.0–4.10.0 | 2000/12 – 2011/09 |
| **LatexDraw** | 24 | 1.0.2–2.0.8 | 2006/01 – 2010/03 |
| **PDFsam** | 14 | 1.0.0–2.2.1 | 2007/08 – 2012/07 |
| **Pixelitor** | 34 | 0.1.0–1.1.2 | 2009/11 – 2010/11 |
| **TuxGuitar** | 11 | 0.2–1.2 | 2006/06 – 2009/11 |
| **Weka** | 13 | 3.0.1–3.7.5 | 2002/02 – 2012/08 |
| **總計** | **296** | **15 個系統** | **最長達 12 年** |

</div>
</div>

<div class="callout teal" style="margin-top: 8px;">
<strong>樣本設計：</strong> 包含 3 個文獻經典標竿專案（<strong>JHotDraw</strong>、<strong>JUnit</strong>、<strong>FreeMind</strong>）＋ 隨機挑選之 12 個開源專案，共評估 <strong>9 組（11 種）品質改善型 GoF 模式</strong>。
</div>

---

## 4.4 實證結果：15 個開源專案之 DoU 矩陣（Table 3）

<div class="split64" style="grid-template-columns: 67% 31%; align-items: start;">
<div class="left">

<table class="dense">
<thead>
<tr><th>專案名稱</th><th>FM</th><th>P</th><th>AC</th><th>C</th><th>D</th><th>O</th><th>SS</th><th>TM</th><th>V</th></tr>
</thead>
<tbody>
<tr><td>FreeMind</td><td class="mid-cell">0.161</td><td></td><td class="mid-cell">0.165</td><td></td><td class="hi-cell">0.333</td><td class="hi-cell">0.333</td><td class="hi-cell">0.301</td><td class="hi-cell">0.263</td><td></td></tr>
<tr><td>HtmlUnit</td><td>0.082</td><td class="zero-cell">0</td><td>0.042</td><td></td><td class="mid-cell">0.196</td><td>0.032</td><td>0.129</td><td>0.101</td><td></td></tr>
<tr><td>Jaxe</td><td class="zero-cell">0</td><td></td><td>0.007</td><td></td><td class="zero-cell">0</td><td class="zero-cell">0</td><td>0.014</td><td class="zero-cell">0</td><td></td></tr>
<tr><td>JConvert</td><td></td><td></td><td class="zero-cell">0</td><td></td><td></td><td class="zero-cell">0</td><td class="mid-cell">0.158</td><td>0.125</td><td></td></tr>
<tr><td>JEdit</td><td></td><td></td><td>0.091</td><td></td><td></td><td></td><td class="zero-cell">0</td><td></td><td></td></tr>
<tr><td>Jena</td><td>0.056</td><td>0.060</td><td>0.014</td><td>0.056</td><td>0.076</td><td>0.071</td><td>0.093</td><td>0.047</td><td class="zero-cell">0</td></tr>
<tr><td>JGnash</td><td>0.012</td><td>0.001</td><td>0.023</td><td class="zero-cell">0</td><td>0.023</td><td>0.017</td><td>0.041</td><td>0.017</td><td></td></tr>
<tr><td>JHotDraw</td><td>0.143</td><td>0.004</td><td>0.044</td><td>0.063</td><td class="mid-cell">0.162</td><td class="hi-cell">0.350</td><td class="mid-cell">0.176</td><td>0.104</td><td class="zero-cell">0</td></tr>
<tr><td>JMemorize</td><td>0.010</td><td class="zero-cell">0</td><td>0.020</td><td class="zero-cell">0</td><td>0.010</td><td>0.040</td><td>0.030</td><td>0.030</td><td></td></tr>
<tr><td>JUnit</td><td class="zero-cell">0</td><td></td><td>0.016</td><td>0.045</td><td class="zero-cell">0</td><td class="zero-cell">0</td><td>0.120</td><td>0.026</td><td></td></tr>
<tr><td>LatexDraw</td><td class="zero-cell">0</td><td>0.005</td><td>0.058</td><td class="hi-cell">0.261</td><td></td><td class="mid-cell">0.174</td><td>0.073</td><td>0.075</td><td></td></tr>
<tr><td>PDFsam</td><td></td><td></td><td class="zero-cell">0</td><td></td><td></td><td></td><td>0.029</td><td class="zero-cell">0</td><td></td></tr>
<tr><td>Pixelitor</td><td>0.011</td><td class="zero-cell">0</td><td>0.007</td><td></td><td></td><td>0.020</td><td>0.016</td><td>0.029</td><td></td></tr>
<tr><td>TuxGuitar</td><td class="mid-cell">0.200</td><td>0.009</td><td>0.062</td><td class="zero-cell">0</td><td></td><td>0.125</td><td>0.051</td><td>0.032</td><td></td></tr>
<tr><td>Weka</td><td>0.068</td><td class="zero-cell">0</td><td>0.052</td><td></td><td>0.145</td><td class="zero-cell">0</td><td class="hi-cell">0.315</td><td>0.013</td><td></td></tr>
</tbody>
</table>
<div class="fig-cap" style="text-align:left;">空白 = 未部署 · <code>0</code> = 已部署但未使用 · 藍綠色 ≥ 0.25，淺藍色 ≥ 0.15</div>

</div>
<div class="right">

<div class="kpi-card teal" style="margin-bottom: 9px;">
<div class="kpi-val">0.350</div>
<div class="kpi-label"><strong>全場最高 DoU：</strong> JHotDraw 的 Observer</div>
</div>

<div class="kpi-card accent" style="margin-bottom: 9px;">
<div class="kpi-val">&lt; 0.20</div>
<div class="kpi-label"><strong>整體現況：</strong> 多數模式平均使用度普遍偏低</div>
</div>

<div class="card small-text">

### 亮點觀察
- **FreeMind**：整體表現最突出（`D/O/SS > 0.30`）。
- **Weka**：State-Strategy 高達 `0.315`（演算法切換）。
- **LatexDraw**：Composite 表現最佳（`0.261`）。
- **Jaxe、JEdit、PDFsam、Pixelitor**：普遍偏低或為 `0`。

</div>

</div>
</div>

---

## 5.1 RQ1 統計分析：DoU 與設計模式類型之關係

<div class="split55">
<div class="left">

<div class="fig-box" style="padding: 8px;">
<img src="./img/fig9_boxplot_patterns.png" alt="各類設計模式 DoU 盒鬚圖" style="max-height: 365px;">
<div class="fig-cap">Fig. 9 · 9 組設計模式之 DoU 分布盒鬚圖</div>
</div>

</div>
<div class="right">

<div class="kpi-card teal" style="margin-bottom: 8px;">
<div class="kpi-val">p = 0.146 &gt; 0.05</div>
<div class="kpi-label"><strong>無法拒絕 H<sub>0</sub>：</strong> 不同設計模式類型間之 DoU 無顯著差異</div>
</div>

| 變異來源（Table 4） | SS | df | MS (SS/df) | F 值 | p-value |
| :--- | :---: | :---: | :---: | :---: | :---: |
| **組間（Between）** | 0.090 | 8 | 0.011 | 1.569 | **0.146** |
| **組內（Within）** | 0.626 | 87 | 0.007 | — | — |
| **總計（Total）** | 0.716 | 95 | — | — | — |

<div class="card small-text" style="margin-top: 8px;">

### 為何模式類型無顯著差異？
- 各類模式平均 DoU 皆**低於 0.20**（`Visitor = 0`，`Prototype ≤ 0.060`）。
- 模式部署高度受到**人為習慣與程式理解程度**影響 [21]。
- 開發者傾向選用**自己熟悉的模式**，或因結構複雜度而卻步 [30]，未必契合真實演化需求。

</div>

</div>
</div>

---

## 5.2 RQ2 統計分析：DoU 與開源軟體專案之關係

<div class="split55">
<div class="left">

<div class="fig-box" style="padding: 8px;">
<img src="./img/fig10_boxplot_projects.png" alt="15 個開源專案 DoU 盒鬚圖" style="max-height: 365px;">
<div class="fig-cap">Fig. 10 · 15 個開源軟體專案之 DoU 分布盒鬚圖</div>
</div>

</div>
<div class="right">

<div class="kpi-card accent" style="margin-bottom: 8px;">
<div class="kpi-val">F = 5.704 · p &lt; 0.001</div>
<div class="kpi-label"><strong>拒絕 H<sub>0</sub>：</strong> 不同開源專案間之 DoU 存在極顯著差異！</div>
</div>

| 變異來源（Table 5） | SS | df | MS (SS/df) | F 值 | p-value |
| :--- | :---: | :---: | :---: | :---: | :---: |
| **組間（Between）** | 0.356 | 14 | 0.025 | **5.704** | **&lt; 0.001** |
| **組內（Within）** | 0.361 | 81 | 0.004 | — | — |
| **總計（Total）** | 0.716 | 95 | — | — | — |

<div class="card accent small-text" style="margin-top: 8px;">

### Scheffé 事後多重比較（Table 6）
- **FreeMind** 顯著優於其他 **8 個專案**：`Jaxe` (p=0.001)、`Jena` (0.006)、`jGnash` (&lt;0.001)、`jMemorize` (&lt;0.001)、`JUnit` (0.002)、`PDFsam` (0.028)、`Pixelitor` (0.001)、`TuxGuitar` (0.040)。
- **領域契合度**：在 MVC 圖形介面專案（**JHotDraw** `0.350`、**FreeMind** `0.333`）中，**Observer 與 Decorator** 隨視覺化更新需求持續被活化運用。

</div>

</div>
</div>

---

## 5.3 研究效度威脅（Threats to Validity）

依循 Yin [25] 之個案研究效度框架，檢視以下四個面向：

<div class="two-col">
<div class="card small-text">

### 🎯 建構效度（Construct Validity）
- 分析結果可能受 **Tsantalis et al. 模式偵測工具** [28] 之精確率與召回率影響。
- **緩解機制：** 該工具於文件完整之 JHotDraw 達 **100% 精確率與 100% 召回率** [28]；Aversano et al. [1] 獨立檢驗整體精確率亦 **&gt; 85%**，有效抑制偽陽性干擾。

</div>
<div class="card accent small-text">

### 🔍 內部效度（Internal Validity）
- 外部混淆因子可能影響 DoU 與專案或模式類型間之因果推論。
- **緩解機制：** 透過嚴謹之**單因子 ANOVA**（α = 0.05）與 **Scheffé 事後檢定**，清楚區辨「專案因子具極顯著影響（p &lt; 0.001）」與「模式類型無顯著影響（p = 0.146）」。

</div>
<div class="card teal small-text">

### 🌐 外部效度（External Validity）
- **專案範圍：** 涵蓋 15 個跨領域、不同規模之 Java 開源系統；未來擴展至更多系統將進一步強化推論泛化力。
- **模式範圍：** 聚焦於 23 種 GoF 模式中與維護性最相關之 **9 組（11 種）品質改善型模式** [14]。

</div>
<div class="card small-text">

### 🔁 信度（Reliability Validity）
- 15 個開源專案原始碼（SourceForge）與 Tsantalis 偵測工具皆為**公開可取得資源**。
- 論文第 4.2 節詳述實驗流程，並公開原始 DoU 數據表（Table 3）以供完整統計重現。

</div>
</div>

---

## 6. 結論與未來研究方向

<div class="fig-box" style="padding: 8px 10px; margin-bottom: 8px;">
<img src="./img/diag3_rq_conclusions_zh.svg" alt="RQ1、RQ2 與實務價值總結圖" style="max-height: 355px;">
</div>

<div class="future-strip">
<div class="future-pill"><strong>☁️ 1. PUA 工具雲端服務化</strong><br>將 PUA 轉型為雲端服務，大幅提升跨版本圖形偵測與大規模演化分析之運算效能。</div>
<div class="future-pill"><strong>🧩 2. 擴充設計模式偵測類別</strong><br>納入更多 GoF 與架構設計模式之偵測與 EPU 規則，拓展品質診斷涵蓋面。</div>
<div class="future-pill"><strong>📊 3. 更大規模開源與產業實證</strong><br>藉由升級後之高效能平台，對更多現代開源與企業專案進行長期演化驗證。</div>
</div>

---

<!-- _class: closing -->

# 感謝聆聽！敬請指教

<p style="font-size: 1.05em; max-width: 840px;">
以軟體演化數據分析設計模式之使用度（Design Pattern Analysis with Software Evolution Data）
</p>

<div class="contact-card">
<strong>薛念林（Nien-Lin Hsueh）</strong> &nbsp;·&nbsp; <code>nlhsueh@fcu.edu.tw</code><br>
逢甲大學資訊工程學系<br>
<em>Journal of Information Science and Engineering</em>, Vol. 36, No. 1, pp. 53–73 (2020)<br>
DOI: <code>10.6688/JISE.202001_36(1).0004</code><br>
<span style="font-size: 0.85em; opacity: 0.85;">科技部計畫補助：MOST 106-2221-E-035-MY2 · 歡迎提問與交流！</span>
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
