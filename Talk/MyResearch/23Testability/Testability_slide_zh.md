---
marp: true
theme: gaia
size: 16:9
paginate: true
html: true
header: '<div class="hdr-wrap"><span class="hdr-title">Pytutor：線上程式設計平台與學習者測試能力研究</span><div class="nav-dropdown"><button class="nav-btn">章節導覽 ▾</button><div class="nav-menu"><a href="#2">破題：盲目提交 vs. 自訂測資</a><a href="#3">簡報大綱</a><a href="#4">1. 研究動機與問題</a><a href="#6">2. 文獻回顧與缺口</a><a href="#7">3. Pytutor 與能力指標</a><a href="#11">4. 課程實驗與 RQ1–RQ3</a><a href="#17">5. 比較、限制與教學啟示</a><a href="#19">6. 結論與未來研究</a></div></div></div>'
footer: '薛念林（Nien-Lin Hsueh）、Lien-Chi Lai & Wei-Hsiang Tseng · 逢甲大學資訊工程學系 · Electronics 2023'
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
section table th code { color: #ffffff !important; }
section.lead code, section.closing code { color: #bae6fd !important; }
section.closing strong { color: #ffffff !important; }

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
  font-size: 1.98em;
  font-weight: 800;
  line-height: 1.28;
  margin-bottom: 16px;
  text-align: left;
}

section.lead .subtitle {
  color: #cbd5e1;
  font-size: 0.94em;
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
.two-col { display: grid; grid-template-columns: 1fr 1fr; gap: 20px; align-items: stretch; }
.three-col { display: grid; grid-template-columns: repeat(3, 1fr); gap: 15px; align-items: stretch; }
.four-col { display: grid; grid-template-columns: repeat(4, 1fr); gap: 12px; align-items: stretch; }
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
  padding: 10px 14px;
  box-sizing: border-box;
}

.kpi-card.accent { border-left-color: var(--accent); background: var(--accent-soft); }
.kpi-card.teal { border-left-color: var(--teal); background: var(--teal-soft); }

.kpi-val { font-size: 1.32em; font-weight: 800; color: var(--navy); line-height: 1.18; margin-bottom: 3px; }
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
.formula-strip-3 {
  display: grid;
  grid-template-columns: 1fr 1fr 1.15fr;
  gap: 10px;
  margin-bottom: 10px;
}

.formula-box {
  background: #f8fafc;
  border: 1.5px solid #cbd5e1;
  border-left: 4px solid var(--navy);
  border-radius: 8px;
  padding: 7px 12px;
  display: flex;
  justify-content: center;
  align-items: center;
  font-family: 'Georgia', 'Times New Roman', serif;
  font-size: 0.88em;
  color: var(--slate-900);
}

.formula-box.teal { border-left-color: var(--teal); background: var(--teal-soft); }
.formula-box.accent { border-left-color: var(--accent); background: var(--accent-soft); }

.frac {
  display: inline-flex;
  flex-direction: column;
  align-items: center;
  vertical-align: middle;
  margin: 0 4px;
  line-height: 1.08;
}

.frac-num { border-bottom: 1.5px solid var(--slate-900); padding: 0 5px 2px 5px; }
.frac-den { padding: 2px 5px 0 5px; }

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

<div class="badge">Electronics 2023, 12(22), 4596 · 軟體工程教育與線上評測研究</div>

# 線上程式設計平台之設計與學習者測試能力研究

<div class="subtitle">
<strong>Pytutor</strong>：將軟體測試概念、自訂測試案例（DTC）、分支覆蓋率與突變測試融入線上程式自動化教學評量
</div>

<div class="meta-box">
<strong>薛念林（Nien-Lin Hsueh）*</strong>、<strong>Lien-Chi Lai</strong>、<strong>Wei-Hsiang Tseng</strong><br>
逢甲大學資訊工程學系（Department of Information Engineering and Computer Science, FCU）<br>
<code>nlhsueh@fcu.edu.tw</code> · DOI: <code>10.3390/electronics12224596</code>
</div>

<div class="grant">
刊登於 MDPI Electronics（2023 年 11 月 10 日）· 國科會（NSTC）專題研究計畫補助：MOST112-2813-C-035-075-E
</div>

---

## 破題思考：「看起來沒問題，直接交！」⋯⋯你真的測過自己的程式嗎？

<div class="fig-box" style="padding: 6px; margin-bottom: 10px; background: #fbf9f2;">
<img src="./img/testability_hook.jpg" alt="傳統線上評測盲目提交 vs Pytutor 自訂測資先抓蟲" style="max-height: 415px; border-radius: 6px;">
</div>

<div class="callout" style="margin-top: 6px; padding: 9px 16px;">
<strong>核心洞見：</strong>傳統線上評測（OJ）只用隱藏測資打分數，導致高達 <strong>23% 的題次在未經任何測試下便盲目提交</strong>。<strong>Pytutor</strong> 導入<strong>自訂測試案例（DTC）</strong>、分支覆蓋率與突變測試，全面培養並量化學習者的軟體測試能力。
</div>

---

## 簡報大綱

<div class="outline-grid">

<div class="outline-item">
<div class="outline-num">1</div>
<div class="outline-body">

[**研究動機與三個研究問題（RQ1–RQ3）**](#4)
為何傳統 OJ 系統忽略軟體測試，以及本研究欲探討的三大面向。

</div>
</div>

<div class="outline-item">
<div class="outline-num">2</div>
<div class="outline-body">

[**文獻回顧與研究缺口**](#6)
比較現有程式教學 OJ 系統與軟體測試自動化評量研究。

</div>
</div>

<div class="outline-item">
<div class="outline-num">3</div>
<div class="outline-body">

[**Pytutor 平台設計與能力指標**](#7)
Django + Docker 沙箱、OTC/DTC/HTC 流程，以及答題韌性 (<i>r</i>)、PAI 與 TEI。

</div>
</div>

<div class="outline-item">
<div class="outline-num">4</div>
<div class="outline-body">

[**課程實驗設計與 RQ1–RQ3 實證結果**](#11)
7 週線上 Python 課程（61 位有效學生、50 題練習）、分組檢定與相關性分析。

</div>
</div>

<div class="outline-item">
<div class="outline-num">5</div>
<div class="outline-body">

[**與前人比較、研究限制與教學啟示**](#17)
與 Yang et al. (2020) 對照、三項研究限制與具體課程改善建議。

</div>
</div>

<div class="outline-item">
<div class="outline-num">6</div>
<div class="outline-body">

[**結論與未來研究方向**](#19)
RQ1–RQ3 實證結論視覺化總結，以及 AI 助教與實驗對照組展望。

</div>
</div>

</div>

---

## 1.1 研究動機：為何傳統線上評測（OJ）忽略軟體測試？

<div class="fig-box" style="padding: 10px 12px; margin-bottom: 10px;">
<img src="./img/diag1_oj_vs_pytutor_zh.svg" alt="傳統 OJ 與 Pytutor 整合軟體測試平台之對照" style="max-height: 365px;">
</div>

<div class="callout">
<strong>軟體測試在程式教育中的價值：</strong>撰寫測試案例有助於理解問題規格、提升程式碼品質與可靠性（Lemos et al., 2018；Fidge &amp; Hogan, 2013）。然而傳統教學用 OJ 往往<em>只檢核學生程式碼</em>，卻忽略培養「設計有效測資」的關鍵能力。
</div>

---

## 1.2 研究目標與三個研究問題（RQ1–RQ3）

我們將 **Pytutor** 與非同步 **OpenEdu** 線上 Python 課程結合，深入剖析學習者的軟體工程能力與學習行為*（逐項揭示）*：

<div class="rq-stage">

* <div class="rq-card teal"><img src="./img/rq1_behavior.svg" alt="RQ1 能力指標與學習行為"><div><div class="rq-hook"><span class="rq-tag" style="background:#0f766e;">RQ1</span> 初學者在線上寫程式、做測試與看教學影片的真實樣貌為何？</div><div class="rq-q"><strong>學習者在軟體工程能力指標（<i>r</i>、PAI、TEI）與線上學習行為</strong>上的整體表現為何？</div></div></div>
* <div class="rq-card accent"><img src="./img/rq2_groups.svg" alt="RQ2 群體差異比較"><div><div class="rq-hook"><span class="rq-tag">RQ2</span> 資訊相關科系學生的測試能力，真的比非資訊科系更好嗎？</div><div class="rq-q"><strong>不同群體學習者在程式能力與測試能力上有何差異</strong>（依科系背景、形成性評量與總結性評量分組）？</div></div></div>
* <div class="rq-card"><img src="./img/rq3_corr.svg" alt="RQ3 相關性分析"><div><div class="rq-hook"><span class="rq-tag" style="background:#1b365d;">RQ3</span> 多寫測試案例或認真看完影片，真的能幫助提升學習成績嗎？</div><div class="rq-q"><strong>各項能力指標與學習行為</strong>（影片完看率、播放倍速）及最終學習成效之間是否存在關聯？</div></div></div>

</div>

---

## 2. 文獻回顧與研究缺口

現有自動化評測平台多著重於快速批改或遊戲化互動，極少同時整合**學生自訂測資（DTC）**、**覆蓋率／突變測試評估**與**跨平台學習行為紀錄**。

| 研究 / 系統平台 | 核心特色與評量重點 | 自訂測資 (DTC) | 覆蓋率與突變測試 | 影音／行為紀錄 | 適用對象 |
| :--- | :--- | :---: | :---: | :---: | :--- |
| YOJ [16] / Sakai [17] | 基礎程式作業自動批改與多次提交 | × | × | × | 初學者 |
| Codeflex [20] / 2TSW [23] | 競賽導向與遊戲化程式練習系統 | × | × | × | 大學生 |
| Codespec [21] / Blockly [22] | Parsons 拼圖題與演算法視覺化鷹架 | × | × | × | 初學者 |
| UnitJudge [29] / Selenium [27] | 單元測試錯誤回饋／線上測試腳本練習 | 部分 | × | × | 中階學習者 |
| Yang et al. (2020) [11] | 以 3 項單元測試作業實證程式與測試力 | ✓ | ✓ | × | 具背景資工生 |
| **Pytutor（本研究, 2023）** | **測試導向 OJ ＋ 50 題練習 ＋ OpenEdu 紀錄** | **✓** | **✓** | **✓** | **資訊＆非資訊** |

<div class="callout">
<strong>關鍵研究缺口：</strong>前人多針對具備測試背景的資工學生進行短期（3 題）限時實驗；針對<strong>跨越資訊與非資訊科系初學者</strong>、在完整線上課程中的自然測試敏感度與學習行為關聯，仍有待實證填補。
</div>

---

## 3.1 Pytutor 系統架構、Docker 沙箱與三類測資設計

<div class="fig-box" style="padding: 8px 10px; margin-bottom: 10px;">
<img src="./img/diag2_pytutor_pipeline_zh.svg" alt="Pytutor Django MVT 架構與軟體測試分析流程" style="max-height: 255px;">
</div>

<div class="two-col">
<div class="card small-text">

### 🧪 三種測試案例（Test Cases）
- **公開測資（OTC）**：教師提供之公開範例（每題 2 組），供基本功能驗證。
- **自訂測資（DTC）**：**由學生自行設計**之測試資料，在測試模式中主動發掘邊界錯誤。
- **隱藏測資（HTC）**：教師預先設計之評分測資（每題 5 組），於正式提交時計分。

</div>
<div class="card accent small-text">

### ⚖️ 兩大作答設計原則與安全機制
- **完成原則（Completion）**：允許學生多次嘗試，直到通過所有隱藏測資。
- **謹慎原則（Cautionary）**：每次正式提交固定**扣 3 分**，遏止盲目試錯並鼓勵先用 DTC 驗證。
- **Docker 隔離沙箱**：每次執行獨立建立容器、數秒內自動銷毀，防範無窮迴圈與惡意程式。

</div>
</div>

---

## 3.2 測試模式介面與作答工作流程

<div class="split55">
<div class="left">

<div class="fig-box">
<img src="./img/fig3_testing_ui.png" alt="圖 3：Pytutor 測試模式與結果顯示區" style="max-height: 365px;">
<div class="fig-cap">圖 3：Pytutor 測試模式介面 — 自訂測資輸入區、原貌錯誤訊息與近 3 次測試紀錄</div>
</div>

</div>
<div class="right">

<div class="fig-box">
<img src="./img/fig4_workflow.png" alt="圖 4：Pytutor 系統操作流程圖" style="max-height: 365px;">
<div class="fig-cap">圖 4：學習者作答流程 — 經由 OTC／DTC 反覆驗證確認無誤後再正式提交</div>
</div>

</div>
</div>

<div class="callout" style="margin-top: 8px; padding: 8px 14px;">
<strong>錯誤原貌呈現與防呆機制：</strong>系統直接顯示 Python 原始編譯／語法錯誤訊息培養除錯力；正式提交前須勾選<strong>「確認提交」</strong>防呆核取方塊，避免誤按而遭扣 3 分。
</div>

---

## 3.3 程式能力量化指標：答題韌性（<i>r</i>）與 PAI

單純的作業分數無法區分「一次寫對」與「反覆試錯」的差距。本研究結合題目複雜度與挫折次數定義**答題韌性（<i>r</i>）**（取 `k = 0.1<code>）：

<div class="formula-strip-3">
<div class="formula-box accent">
<i>r</i> &nbsp;=&nbsp; <i>e</i><sup><i>k</i> × (<i>tr</i> − <i>ch<sub>p</sub></i>)</sup>
</div>
<div class="formula-box">
<i>s</i> &nbsp;=&nbsp; <i>base</i> + (100 − <i>base</i>) × <i>p</i>
</div>
<div class="formula-box teal">
<i>PAI</i> &nbsp;=&nbsp; <span class="frac"><span class="frac-num"><i>s</i></span><span class="frac-den"><i>r</i></span></span>
</div>
</div>

<div class="split55">
<div class="left">

<div class="fig-box">
<img src="./img/fig6_pai.png" alt="圖 6：答題韌性 r 對程式能力指標 PAI 之影響" style="max-height: 315px;">
<div class="fig-cap">圖 6：答題韌性 <i>r</i> 與程式能力指標（PAI）之函數曲線</div>
</div>

</div>
<div class="right small-text">

### 📈 指標定義與解讀
- **</code>tr`**：挫折嘗試次數（包含語法錯誤與未通過全部 HTC 之提交）。
- **<code>ch<sub>p</sub></code>**：題目挑戰度（依程式 `p` 之決策數／迴圈複雜度計算）。
- **韌性原點（<code>tr = ch<sub>p</sub></code>，`r = 1`）**：`r > 1` 表示遭遇顯著挫折仍堅持嘗試；`r < 1` 表示解題效率優於預期。
- **雙重意涵**：同分下遭遇越少挫折者 `PAI = s / r` 越高，代表程式寫作越穩健。
- **課程平均**：全體平均 `PAI = 121.80`（大於滿分 100），顯示多數題目能高效率完成。

</div>
</div>

---

## 3.4 測試能力量化指標：TQI 與 TEI

結合**分支覆蓋率（<code>b<sub>t</sub></code>）**與**突變分數（<code>ms<sub>t</sub></code>）**，衡量學習者自訂測資（DTC）相對於公開測資（OTC）所帶來的品質提升與效率：

<div class="formula-strip-3">
<div class="formula-box">
<i>TQI<sub>t</sub></i> &nbsp;=&nbsp; √(<i>b<sub>t</sub></i> × <i>ms<sub>t</sub></i>)
</div>
<div class="formula-box">
<i>TQI</i><sup>+</sup> &nbsp;=&nbsp; <span class="frac"><span class="frac-num"><i>TQI<sub>OD</sub></i></span><span class="frac-den"><i>TQI<sub>O</sub></i></span></span>
</div>
<div class="formula-box teal">
<i>TEI</i> = 1 (<i>te</i>=<i>te<sub>o</sub></i>) &nbsp;|&nbsp; <i>TQI</i><sup>+</sup>(1 + <i>e</i><sup>−<i>k</i>(<i>te</i>−<i>ch<sub>t</sub></i>)</sup>)
</div>
</div>

<div class="split55">
<div class="left">

<div class="fig-box">
<img src="./img/fig7_tei.png" alt="圖 7：參數 k 與測資數量對 TEI 之影響" style="max-height: 315px;">
<div class="fig-cap">圖 7：權重係數 <i>k</i> (= 0.1) 與測資數量對測試效率指標（TEI）之影響</div>
</div>

</div>
<div class="right small-text">

### 🎯 TQI<sup>+</sup> 與 TEI 設計巧思
- **<code>TQI<sub>OD</sub> / TQI<sub>O</sub></code>**：量化加入學生自訂測資（DTC）後，分支覆蓋與突變抓錯能力的增益倍率。
- **基礎保障機制**：僅使用公開測資（<code>te = te<sub>o</sub></code>）預設 `TEI = 1`；公式採 <code>1 + e<sup>−k(te−ch<sub>t</sub>)</sup></code> 確保願意自訂測資者不會反而低於基準值 1。
- **精準效率加權**：能以**較少測資**（<code>te < ch<sub>t</sub></code>）達成同等 <code>TQI<sup>+</sup></code> 者，獲得更高 `TEI`。
- **課程平均**：全體平均 `TEI = 1.89`，反映多數題次測試意願或效率仍偏低。

</div>
</div>

---

## 4.1 課程實驗設計、參與者與 50 題 TQI 分佈

<div class="split55">
<div class="left small-text">

### 📚 7 週非同步線上 Python 課程
- **課程架構**：**OpenEdu** 7 大單元（**64 支教學影片**）＋ **Pytutor**（**50 道練習題**）＋ 5 次實體討論會 ＋ MS Teams 即時問答。
- **題庫規格**：平均迴圈複雜度 **4.06**；每題含 **2 組 OTC** 與 **5 組 HTC**（公開測資平均分支覆蓋率 **0.92**、突變分數 **0.75**）。
- **參與對象**：共 **69 人選修**（資訊系 27 人、非資訊系 42 人；54 人曾學過程式、15 人學過 Python）；排除後期無活動者後，有效分析 **61 人**（資訊 26 人、非資訊 35 人）。
- **雙軌評量**：**形成性評量**（50 題平均）與**總結性評量**（40 分鐘 4 題期末上機考）。

</div>
<div class="right">

<div class="fig-box">
<img src="./img/fig8_tqi_dist.png" alt="圖 8：50 道練習題之公開測資 TQI 分佈" style="max-height: 335px;">
<div class="fig-cap">圖 8：50 道題目原始 OTC 之 TQI 分佈（部分低 TQI 題目亟需學生自訂 DTC 補強）</div>
</div>

</div>
</div>

---

## 4.2 RQ1 實證結果：學習參與度與四類能力分群

<div class="four-col" style="margin-bottom: 10px;">
<div class="kpi-card accent">
<div class="kpi-val">23% 盲交</div>
<div class="kpi-label">未經任何 OTC 或 DTC 測試即直接正式提交</div>
</div>
<div class="kpi-card teal">
<div class="kpi-val">44% 用 DTC</div>
<div class="kpi-label">提交前至少自訂 1 組 DTC（59% 使用 OTC）</div>
</div>
<div class="kpi-card">
<div class="kpi-val">56% · 2.08×</div>
<div class="kpi-label">OpenEdu 平均影片完看率與平均播放倍速</div>
</div>
<div class="kpi-card">
<div class="kpi-val">1.43 次提交</div>
<div class="kpi-label">每題平均正式提交 · 耗時 14.45 分 · <i>tr</i> = 3.23</div>
</div>
</div>

<div class="split55">
<div class="left">

<div class="fig-box">
<img src="./img/fig10_categories.png" alt="圖 10：61 位學習者之四類能力分佈" style="max-height: 270px;">
<div class="fig-cap">圖 10：依百分等級（1–50 低、51–99 高）劃分四類能力群體</div>
</div>

</div>
<div class="right small-text">

### 📊 能力指標描述性統計（Table 2 · N = 61）
| 指標項目 | 平均數 | 標準差 | 中位數 | 最大值 |
| :--- | :---: | :---: | :---: | :---: |
| 答題韌性 (<i>r</i>) | 1.97 | 2.82 | 0.99 | 17.53 |
| **平均 TEI** | **1.89** | 0.49 | 1.92 | 2.99 |
| **平均 PAI** | **121.80** | 23.64 | 127.55 | 157.19 |
| 形成性成績 | 72.66 | 26.17 | 84.08 | 99.64 |
| 總結性成績 | 68.04 | 23.69 | 77.93 | 100.00 |

**關鍵觀察**：學生普遍缺乏耐心（2.08 倍速快轉、完看率 56%、23% 盲交），且 **61 人中有 39 人落於 HPLT (20) 與 LPHT (19)**——會寫程式不等於會做測試！

</div>
</div>

---

## 4.3 RQ2a 實證結果：資訊科系 vs. 非資訊科系

<div class="split55">
<div class="left">

<div class="fig-box">
<img src="./img/fig11_cs_cats.png" alt="圖 11：不同科系背景於四類能力群體之人數分佈" style="max-height: 315px;">
<div class="fig-cap">圖 11：資訊系（26 人）與非資訊系（35 人）之能力分類比較</div>
</div>

</div>
<div class="right small-text">

### 🔬 Mann–Whitney U 檢定：資訊 vs. 非資訊（圖 12）
| 評估指標 | 資訊系 (n = 26) vs. 非資訊系 (n = 35) | <i>p</i> 值 | 顯著？ |
| :--- | :--- | :---: | :---: |
| **答題韌性 (<i>r</i>)** | 非資訊系面臨較多錯誤且更堅持嘗試 | **0.001** | **顯著*** |
| **程式能力 (PAI)** | 資訊系 **19/26 (73%) 高程式力** vs. 非資訊 12/35 | **0.0003** | **顯著*** |
| **測試能力 (TEI)** | 資訊系僅 **11/26 (42%) 高測試力** vs. 非資訊 19/35 (54%) | **0.277** | **不顯著** |

<div class="callout" style="margin-top: 10px;">
<strong>驚人發現：</strong>資訊科系學生的<strong>程式能力（PAI）顯著領先</strong>，但在<strong>測試能力（TEI）上卻無任何顯著優勢</strong>！推論資訊系學生因對自身程式碼過度自信而減少測試；非資訊系學生反而更積極撰寫 DTC 以避免報錯。
</div>

</div>
</div>

---

## 4.4 RQ2b 實證結果：形成性評量（平時練習階段）

依形成性評量中位數（**84.08 分**）將 61 位學生分為**高分組（31 人）**與**低分組（30 人）**：

<div class="split55">
<div class="left">

<div class="fig-box">
<img src="./img/fig13_formative_cats.png" alt="圖 13：形成性評量高低分組於四類能力之人數分佈" style="max-height: 300px;">
<div class="fig-cap">圖 13：形成性評量高分組 31 人中，高達 21 人具備高測試能力（HT）</div>
</div>

</div>
<div class="right">

<div class="fig-box">
<img src="./img/fig14_formative_box.png" alt="圖 14：形成性評量高低分組之指標盒鬚圖" style="max-height: 300px;">
<div class="fig-cap">圖 14：Mann–Whitney U — <i>r</i>: <i>p</i> = 0.153 · <b>PAI: <i>p</i> = 0.035*</b> · <b>TEI: <i>p</i> = 0.036*</b></div>
</div>

</div>
</div>

<div class="callout" style="margin-top: 8px;">
<strong>RQ2b 發現：</strong>在 50 題形成性練習階段，<strong>程式能力（PAI, <i>p</i> = 0.035）與測試能力（TEI, <i>p</i> = 0.036）皆與高分顯著相關</strong>。即使程式能力較弱，只要具備高測試能力，仍能拿下優異平時成績（<strong>LPHT 組有 12 人進入高分組</strong>）！
</div>

---

## 4.5 RQ2c 實證結果：總結性評量（限時期末上機考）

依期末考中位數（**77.93 分**；限時 **40 分鐘**完成 4 題）分為**高分組（31 人）**與**低分組（30 人）**：

<div class="split55">
<div class="left">

<div class="fig-box">
<img src="./img/fig15_summative_cats.png" alt="圖 15：總結性評量高低分組於四類能力之人數分佈" style="max-height: 300px;">
<div class="fig-cap">圖 15：期末考高分組 31 人中，高程式能力（HP）佔 18 人</div>
</div>

</div>
<div class="right">

<div class="fig-box">
<img src="./img/fig16_summative_box.png" alt="圖 16：總結性評量高低分組之指標盒鬚圖" style="max-height: 300px;">
<div class="fig-cap">圖 16：Mann–Whitney U — <i>r</i>: <i>p</i> = 0.105 · <b>PAI: <i>p</i> = 0.016*</b> · TEI: <i>p</i> = 0.93 (n.s.)</div>
</div>

</div>
</div>

<div class="callout" style="margin-top: 8px;">
<strong>RQ2c 發現：</strong>在嚴格的 **40 分鐘期末考時間壓力**下，僅**程式能力（PAI, <i>p</i> = 0.016）**呈現顯著差異，TEI 則無差異（<i>p</i> = 0.93）。因作答時間緊迫，學生較難設計高品質 DTC，使寫作熟練度成為勝負關鍵。
</div>

---

## 4.6 RQ3 實證結果：能力指標、影音行為與成績關聯

<div class="split55">
<div class="left">

<div class="fig-box">
<img src="./img/fig17_corr_ability.png" alt="圖 17：能力指標間之 Spearman 等級相關熱圖" style="max-height: 310px;">
<div class="fig-cap">圖 17：<i>r</i>、PAI 與 TEI 三項能力指標之 Spearman 相關熱圖</div>
</div>

</div>
<div class="right">

<div class="fig-box">
<img src="./img/fig18_corr_behavior.png" alt="圖 18：能力指標與影音行為、學習成效之相關熱圖" style="max-height: 310px;">
<div class="fig-cap">圖 18：能力指標與影片觀看行為、形成／總結成績之相關熱圖</div>
</div>

</div>
</div>

<div class="callout" style="margin-top: 8px;">
<strong>核心相關脈絡：</strong>
(1) <b><i>r</i> ↔ TEI (+0.50)</b>：出錯頻率越高越會透過多輪測試除錯；<b>PAI ↔ TEI (−0.39)</b> 證實寫作與測試屬不同能力。
(2) <b>影片完看率 ↔ TEI (+0.33)</b>：完整看片者更願意仔細測試；<b>播放倍速 ↔ PAI (−0.24)</b>：過度快轉看片容易導致寫程式出錯。
(3) <b>學習成效</b>：PAI 與形成性（<b>+0.35</b>）及總結性（<b>+0.38</b>）皆呈中度正相關；TEI 顯著助益形成性成績（<b>+0.26</b>），限時考試則無關（<b>+0.073</b>）。
</div>

---

## 5.1 與前人研究之比較與研究限制

<div class="two-col">
<div class="card teal small-text">

### 🔍 與 Yang et al. (2020) [11] 之對照
- **一致的核心結論**：兩研究皆證實**程式能力強不代表測試能力強**——近半數程式好手測試能力偏低，而程式較弱者亦可能展現優異測試力。
- **前人情境**：Yang et al. 以具備測試訓練的資工系大學生為對象，於限時內完成 **3 項作業**並以單元測試評分。
- **本研究突破**：在 Pytutor 上擴展至 **50 題隨時可練之題庫**，涵蓋**資訊與非資訊初學者**，並串聯 OpenEdu 影音歷程進行全方位剖析。

</div>
<div class="card accent small-text">

### ⚠️ 三項研究限制
1. **公開測資基準偏高**：部分題目之原始 <code>TQI<sub>O</sub></code> 已超過 80，使學生自訂 DTC 之提升空間受限，壓縮 `TEI` 變化幅度。
2. **未正式教授測試方法**：課程僅教導基礎 Python，尚未融入邊界值或等價類等測試理論，故 TEI 反映的是「自然測試敏感度」。
3. **本機端開發行為盲區**：系統目前無法記錄學生是否在**本機編輯器（IDE）**寫完並測試完畢後，才貼上平台提交。

</div>
</div>

---

## 5.2 對程式設計教學之三項具體建議

根據 61 位學生於 50 道練習題的實證證據，本研究對程式設計教師與課程設計者提出以下建議：

<div class="three-col" style="margin-top: 10px;">
<div class="card small-text">

### 1. 不分科系全面融入測試教學
- 在臺灣現行教育脈絡下，資訊系學生的測試能力**並未優於非資訊系**（`p = 0.277`）。
- 應在初階程式課同步教授黑箱與邊界測試觀念，協助程式較弱的學習者透過測試補齊實力。

</div>
<div class="card teal small-text">

### 2. 將教學影片拆分為微知識單元
- 學習者平均僅看 **56%** 影片且開 **2.08 倍速**，而快轉與程式能力呈負相關（`−0.24`）。
- 建議將長影片依**單一知識點切分為精短微單元**，維持專注度並減少觀念遺漏。

</div>
<div class="card accent small-text">

### 3. 設計「需要自訂測資」的練習題
- 適度控制公開測資覆蓋率（如 <code>TQI<sub>O</sub> < 70</code>），引導學生主動思考遺漏情境並撰寫 DTC。
- 結合**謹慎原則（扣 3 分）**與即時測試覆蓋回饋，讓「先測再交」內化為開發習慣。

</div>
</div>

---

## 6. 結論與未來研究方向

<div class="fig-box" style="padding: 8px 10px; margin-bottom: 8px;">
<img src="./img/diag3_rq_conclusions_zh.svg" alt="Pytutor RQ1-RQ3 實證結論視覺化總結" style="max-height: 355px;">
</div>

<div class="future-strip">
<div class="future-pill"><strong>🤖 1. AI 虛擬教學助理</strong><br>導入生成式 AI 扮演蘇格拉底式引導助教，啟發學生思考邊界測資，而非直接給予標準答案。</div>
<div class="future-pill"><strong>💻 2. 強化線上編輯器與細部歷程</strong><br>提升網頁端寫程式體驗以留住學生於平台內開發，蒐集更細緻的編輯與除錯行為資料。</div>
<div class="future-pill"><strong>🧪 3. 實驗組 vs. 對照組實證</strong><br>於未來課程進行分組對照實驗，嚴謹驗證「融入測試概念之 OJ 系統」對學習成效的因果貢獻。</div>
</div>

---

<!-- _class: closing -->

# 感謝您的聆聽與指教！

<p style="font-size: 1.05em; max-width: 860px;">
線上程式設計平台之設計與學習者測試能力研究（Pytutor）
</p>

<div class="contact-card">
<strong>薛念林（Nien-Lin Hsueh）*</strong> &nbsp;·&nbsp; <code>nlhsueh@fcu.edu.tw</code><br>
<strong>Lien-Chi Lai</strong> ＆ <strong>Wei-Hsiang Tseng</strong><br>
逢甲大學資訊工程學系（Department of Information Engineering and Computer Science, FCU）<br>
期刊論文：<code>Electronics 2023, 12(22), 4596</code> · <code>https://doi.org/10.3390/electronics12224596</code><br>
<span style="font-size: 0.85em; opacity: 0.85;">研究計畫補助：MOST112-2813-C-035-075-E · 歡迎提問與交流！</span>
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
