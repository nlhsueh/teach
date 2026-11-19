---
marp: true
theme: gaia
size: 16:9
paginate: true
html: true
header: '<div class="hdr-wrap"><span class="hdr-title">探討學生於程式設計課程中對線上評測系統（Online Judge）之接受度</span><div class="nav-dropdown"><button class="nav-btn">章節導覽 ▾</button><div class="nav-menu"><a href="#2">破題：交了 12 次為何仍愛用？</a><a href="#3">簡報大綱</a><a href="#4">1. 研究動機與問題</a><a href="#6">2. 文獻回顧與缺口</a><a href="#7">3. 研究模型與 12 項假設</a><a href="#10">4. 課程情境與研究方法</a><a href="#12">5. PLS-SEM 實證結果</a><a href="#15">6. 深度討論與實務建議</a><a href="#18">7–8. 結論與未來研究</a></div></div></div>'
footer: 'Daramsenge Bilegjargal ＆ 薛念林（Nien-Lin Hsueh） · 逢甲大學資訊工程學系 · IEEE Access (2021)'
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

.hdr-wrap { width: 100%; display: flex; justify-content: space-between; align-items: center; }
.hdr-title { letter-spacing: 0.01em; opacity: 0.94; }

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
.nav-dropdown.open .nav-menu { display: block; }

.nav-menu a {
  display: block;
  padding: 7px 14px;
  color: var(--slate-700);
  text-decoration: none;
  font-size: 12.5px;
  font-weight: 500;
  line-height: 1.35;
}

.nav-menu a:hover { background: var(--slate-100); color: var(--navy); }

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
h1 { color: var(--navy); font-size: 1.7em; font-weight: 800; line-height: 1.24; margin: 0 0 12px 0; }

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

h3 { color: var(--accent); font-size: 0.96em; font-weight: 700; margin: 4px 0 6px 0; }

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
section.lead strong, section.lead .meta-box strong { color: #ffffff !important; }
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
  letter-spacing: 0.05em;
  padding: 5px 14px;
  border-radius: 999px;
  margin-bottom: 18px;
}

section.lead h1 {
  color: #ffffff;
  font-size: 1.9em;
  font-weight: 900;
  line-height: 1.28;
  margin-bottom: 16px;
  text-align: left;
}

section.lead .subtitle {
  color: #cbd5e1;
  font-size: 0.94em;
  line-height: 1.54;
  margin-bottom: 24px;
  max-width: 960px;
}

section.lead .meta-box {
  border-left: 4px solid #f43f5e;
  padding-left: 18px;
  color: #e2e8f0;
  font-size: 0.85em;
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
  padding: 10px 15px;
  box-sizing: border-box;
}

.kpi-card.accent { border-left-color: var(--accent); background: var(--accent-soft); }
.kpi-card.teal { border-left-color: var(--teal); background: var(--teal-soft); }

.kpi-val { font-size: 1.38em; font-weight: 800; color: var(--navy); line-height: 1.15; margin-bottom: 3px; }
.kpi-card.accent .kpi-val { color: var(--accent); }
.kpi-card.teal .kpi-val { color: var(--teal); }
.kpi-label { font-size: 0.76em; color: var(--slate-700); line-height: 1.35; }

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
  font-size: 0.73em;
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
  line-height: 1.32;
}

tr:nth-child(even) td { background: #f8fafc; }

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

/* Incremental RQ Grid */
.rq-stage ul {
  display: flex;
  flex-direction: column;
  gap: 20px;
  list-style: none !important;
  padding: 0 !important;
  margin: 18px 0 0 0 !important;
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
  padding: 18px 22px;
  box-shadow: 0 2px 8px rgba(15, 23, 42, 0.06);
  box-sizing: border-box;
}

.rq-card.teal { border-left-color: var(--teal); }
.rq-card.accent { border-left-color: var(--accent); }

.rq-card img { width: 92px; height: 92px; flex-shrink: 0; border-radius: 10px; }

.rq-hook { font-size: 0.98em; font-weight: 800; color: var(--navy); line-height: 1.28; margin-bottom: 6px; }
.rq-card.teal .rq-hook { color: var(--teal); }
.rq-card.accent .rq-hook { color: var(--accent); }
.rq-q { font-size: 0.86em; color: var(--slate-700); line-height: 1.48; }

/* Mini Bar Rows */
.bar-row {
  display: grid;
  grid-template-columns: 155px 1fr 78px;
  align-items: center;
  gap: 10px;
  margin-bottom: 7px;
  font-size: 0.78em;
}

.bar-track {
  background: var(--slate-100);
  border-radius: 5px;
  height: 18px;
  overflow: hidden;
  border: 1px solid var(--slate-200);
}

.bar-fill { height: 100%; border-radius: 4px; background: var(--navy); }
.bar-fill.teal { background: var(--teal); }
.bar-fill.accent { background: var(--accent); }
.bar-pct { font-weight: 700; text-align: right; color: var(--slate-900); white-space: nowrap; }

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

<div class="badge">IEEE Access · 第 9 卷 · pp. 152606–152615 · 2021 年 11 月</div>

# 探討學生於程式設計課程中對線上評測系統（Online Judge）之接受度

<div class="subtitle">
<strong>結構方程模型分析法（PLS-SEM）：</strong>以延伸版 <strong>UTAUT2</strong> 理論模型，實證揭露驅動大學生採用自動化程式評測系統的真正關鍵因素
</div>

<div class="meta-box">
<strong>Daramsenge Bilegjargal<sup>*</sup></strong> ＆ <strong>薛念林（Nien-Lin Hsueh）</strong><br>
逢甲大學 資訊工程學系（Department of Information Engineering and Computer Science, FCU）<br>
<code>p0731809@o365.fcu.edu.tw</code> · <code>nlhsueh@fcu.edu.tw</code> · DOI: <code>10.1109/ACCESS.2021.3126896</code>
</div>

<div class="grant">
本研究獲科技部（MOST）研究計畫補助：MOST 109-2221-E-035-056。
</div>

---

## 破題：「第 12 次提交還是 WA！」……那學生為何仍願意用 Online Judge？

<div class="fig-box" style="padding: 6px; margin-bottom: 10px; background: #fbf9f2;">
<img src="./img/judge_hook.jpg" alt="嚴格的線上評測系統 vs 真正驅動學生接受的關鍵因素" style="max-height: 410px; border-radius: 6px;">
</div>

<div class="callout" style="margin-top: 6px; padding: 9px 16px;">
<strong>出乎意料的發現：</strong>多一個空白（<code>" 12"</code> vs. <code>"12"</code>）就會直接被判錯誤，但<strong>效率與易用性竟然不是關鍵</strong>！真正讓學生買單的是<strong>學習樂趣（享樂動機）</strong>、<strong>解題自信（自我效能）</strong>與<strong>師生同儕支持（社會影響）</strong>——且對資工與非資工學生一體適用。
</div>

---

## 簡報大綱

<div class="outline-grid">

<div class="outline-item">
<div class="outline-num">1</div>
<div class="outline-body">

[**研究動機與核心問題**](#4)
為何遠距程式課程中的 Online Judge 接受度亟待研究，以及兩大研究問題（RQ1–RQ2）。

</div>
</div>

<div class="outline-item">
<div class="outline-num">2</div>
<div class="outline-body">

[**文獻回顧與研究缺口**](#6)
線上評測系統（OJ）、UTAUT2 科技接受度模型與 PLS-SEM 小樣本因果建模。

</div>
</div>

<div class="outline-item">
<div class="outline-num">3</div>
<div class="outline-body">

[**研究模型與 12 項假設**](#7)
延伸 UTAUT2（納入自我效能、焦慮感與主修科系）及 H1–H12 假設推演。

</div>
</div>

<div class="outline-item">
<div class="outline-num">4</div>
<div class="outline-body">

[**課程情境、問卷與樣本**](#10)
逢甲大學 6 週翻轉式資料科學課程、22 題問卷（n = 187）與兩階段 PLS-SEM 流程。

</div>
</div>

<div class="outline-item">
<div class="outline-num">5</div>
<div class="outline-body">

[**PLS-SEM 測量與結構模型結果**](#12)
信效度驗證、R<sup>2</sup> = 0.754、直接驅動因素（RQ1）與主修科系調節檢定（RQ2）。

</div>
</div>

<div class="outline-item">
<div class="outline-num">6</div>
<div class="outline-body">

[**深度討論、實務建議與結論**](#15)
為何 8 項假設未成立、系統與教學設計指南、研究限制與未來方向。

</div>
</div>

</div>

---

## 1.1 研究動機：自動化批改不等於學生願意採用

<div class="fig-box" style="padding: 10px 12px; margin-bottom: 10px;">
<img src="./img/diag1_oj_motivation_zh.svg" alt="系統導向之 OJ 工程與學習者導向之接受度建模對比" style="max-height: 365px;">
</div>

<div class="callout">
<strong>研究重要性：</strong>雖然 Codeforces、UVa、SPOJ 與 Edgar 等自動化程式評測系統（APAS）大幅減輕教師批改負擔，但學界至今<strong>尚無實證研究</strong>探討學生在線上程式課程中對 OJ 系統的接受度成因。
</div>

---

## 1.2 兩大核心研究問題（Research Questions）

本研究以 **UTAUT2 ＋ PLS-SEM** 針對混成式程式設計課程中的 OJ 接受度提出兩大研究問題 *(逐步揭曉)*：

<div class="rq-stage">

* <div class="rq-card teal"><img src="./img/rq1_factors.svg" alt="RQ1 關鍵驅動因素"><div><div class="rq-hook"><span class="rq-tag" style="background:#0f766e;">RQ1</span> 究竟是哪些關鍵因素，真正驅動學生接受 Online Judge？</div><div class="rq-q">在線上程式設計課程中，<strong>哪些構面</strong>（績效預期、努力預期、社會影響、促成條件、享樂動機、自我效能、焦慮感與主修科系）對學生的 <strong>OJ 系統接受度與使用意願（Behavioral Intention）</strong>具有顯著影響？</div></div></div>
* <div class="rq-card accent"><img src="./img/rq2_major.svg" alt="RQ2 主修科系調節效果"><div><div class="rq-hook"><span class="rq-tag">RQ2</span> 資工與非資工主修背景，會改變這些因素的影響力嗎？</div><div class="rq-q"><strong>主修科系（Academic Major, MJR）是否扮演調節變項</strong>，進而改變各候選因素（EE、HM、SE、ANX）與學生使用 OJ 系統之<strong>行為意願</strong>之間的因果關係？</div></div></div>

</div>

---

## 2. 文獻回顧：Online Judge、UTAUT2 與 PLS-SEM

既有 OJ 文獻偏重系統工程與學習成效，而 UTAUT2 教育應用多聚焦於一般數位學習平台，尚未切入自動化程式評測情境。

| 研究脈絡 | 代表性文獻 | 核心發現與焦點 | 本研究填補之缺口 |
| :--- | :--- | :--- | :--- |
| **線上評測系統（OJ）** | Mekterovic *et al.* (*Edgar*, 2020)；Petit *et al.* (*Jutge.org*, 2018)；Aleman (2011)；Galan *et al.* (2019) | 跨語言自動評測、競賽趣味性、提升留存率與作業完成度之成績正相關 | 缺乏行為接受度實證模型，未能解釋學生*為何*願意持續使用 OJ |
| **教育科技之 UTAUT2** | Venkatesh *et al.* (2003, 2012)；Huang (2020)；Jakkaew &amp; Hemrungrote (2017)；Salloum *et al.* (2019) | 整合 8 大理論（TRA、TPB、TAM 等）；PE、HM、SE 與趣味性顯著影響 VR、Google Classroom 與 LMS 採用 | 首次將 UTAUT2 與主修調節機制應用於**線上程式評測系統** |
| **PLS-SEM 統計建模** | Hair *et al.* (2011, 2017)；Lin *et al.* (2019)；Wong (2013) | 無母數拔靴法；不須常態分佈假設、適用小樣本；採外部＋內部兩階段檢定 | 最適合單學期課程實證調查（`n = 187`）與探索性預測建模 |

<div class="callout teal">
<strong>理論貢獻：</strong>首篇結合<strong>延伸 UTAUT2 模型</strong>（納入自我效能、焦慮感與主修科系）與 <strong>PLS-SEM</strong> 探討自動化程式評測接受度之實證研究。
</div>

---

## 3.1 理論基礎：將 UTAUT2 調適至線上程式評測情境

<div class="split55">
<div class="left">

<div class="fig-box">
<img src="./img/fig1_utaut2.png" alt="圖 1：UTAUT2 概念架構" style="max-height: 390px;">
<div class="fig-cap">圖 1：原始 UTAUT2 概念架構（Venkatesh et al., 2012 [13]）</div>
</div>

</div>
<div class="right small-text">

### 🎯 依課程情境進行構面調適
- **保留核心 UTAUT2 構面（5 項）**：
  - 績效預期（`PE`）、努力預期（`EE`）、社會影響（`SI`）、促成條件（`FC`）、享樂動機（`HM`）
- **排除不適用構面（3 項）**：
  - *價格價值（Price Value）*：校內教學用 OJ **完全免費**。
  - *習慣（Habit）*：屬課程階段性工具，非日常消費軟體。
  - *實際使用行為（Use Behavior）*：屬必修課程情境，故以 `BI` 預測未來自主使用意願（如 LeetCode）。
- **新增程式學習關鍵變項（3 項）**：
  - **自我效能（`SE`）**、**焦慮感（`ANX`）**與**主修科系（`MJR`）**（資工／電機／其他科系）。

</div>
</div>

---

## 3.2 本研究模型與 12 項假設（H1–H12）

<div class="split55">
<div class="left">

<div class="fig-box">
<img src="./img/fig2_research_model.png" alt="圖 2：本研究延伸 UTAUT2 模型與 H1-H12 假設" style="max-height: 395px;">
<div class="fig-cap">圖 2：延伸版 UTAUT2 研究模型（粗黑線代表主修科系之調節路徑）</div>
</div>

</div>
<div class="right small-text">

### 📋 第一組：對行為意願之直接影響（8 條）
- **H1**：`PE ➔ BI` (+) · **H2**：`EE ➔ BI` (+)
- **H4**：`SI ➔ BI` (+) · **H5**：`FC ➔ BI` (+)
- **H6**：`HM ➔ BI` (+) · **H8**：`SE ➔ BI` (+)
- **H10**：`ANX ➔ BI` (−) · **H12**：`MJR ➔ BI` (+)

### 🎓 第二組：主修科系之調節效果（4 條）
- **H3**：`MJR × EE ➔ BI`（既定開發環境熟悉度）
- **H7**：`MJR × HM ➔ BI`（資工背景對寫程式的興趣）
- **H9**：`MJR × SE ➔ BI`（過往解題累積之自信心）
- **H11**：`MJR × ANX ➔ BI`（面對試誤之焦慮敏感度）

</div>
</div>

---

## 3.3 構面推論與 OJ 課堂真實痛點

<div class="two-col">
<div class="card small-text">

### 🛠️ 核心 UTAUT 構面（PE, EE, SI, FC）
- **績效預期（`PE`）**：即時編譯與測試回饋有助於學生反覆修正程式碼品質，直到通過所有測資。
- **努力預期（`EE`）**：介面結構單純，但整合 OpenEdu 單一登入與嚴格測資判讀仍增加學習門檻。
- **社會影響（`SI`）**：逢甲資工自建 OJ 並鼓勵**學長姐、助教與同儕**於系統上互助解題。
- **促成條件（`FC`）**：嚴格字元比對（如 `" 12"` ≠ `"12"`）極易引發挫敗感，凸顯指引與資源之重要性。

</div>
<div class="card teal small-text">

### 🧠 心理與背景構面（HM, SE, ANX, MJR）
- **享樂動機（`HM`）**：**6 個單元中有 5 個融入遊戲化關卡**，學生須通過當前單元才能解鎖下一關，維持學習動力。
- **自我效能（`SE`）**：遠距自主練習時，無老師在旁也能獨立排錯與完成任務的自信心。
- **焦慮感（`ANX`）**：平均需提交 **12 次**才通過、擔心誤按遺失程式碼，加上**公開排行榜**可能加劇成績壓力。
- **主修科系（`MJR`）**：資工系將寫程式視為核心職能，電機系具中度經驗，外系則多屬初學者。

</div>
</div>

---

## 4.1 混成課程情境與兩階段 PLS-SEM 研究流程

<div class="fig-box" style="padding: 8px 10px; margin-bottom: 8px;">
<img src="./img/diag2_study_pipeline_zh.svg" alt="逢甲大學混成翻轉課程與兩階段 PLS-SEM 分析流程" style="max-height: 310px;">
</div>

<div class="callout" style="margin-top: 6px; padding: 8px 14px;">
<strong>為何選用 SmartPLS 3.0（PLS-SEM）？</strong>相較於共變異數結構方程模型，PLS-SEM 採無母數拔靴法，<strong>不要求多變量常態分佈</strong>，在 <code>n = 187</code> 之單學期課程樣本下仍具高度統計檢定力與預測效度。
</div>

---

## 4.2 受測樣本人口統計特徵（`n = 187`，表 1）

<div class="three-col" style="margin-bottom: 10px;">
<div class="kpi-card">
<div class="kpi-val">187 / 約 300</div>
<div class="kpi-label">2021 春季班自願填答大學生（回收率約 62%）</div>
</div>
<div class="kpi-card teal">
<div class="kpi-val">83.4% 資工系</div>
<div class="kpi-label">資工系 156 人、電機系 23 人（12.3%）、其他科系 8 人（4.3%）</div>
</div>
<div class="kpi-card accent">
<div class="kpi-val">80.2% 曾用 OJ</div>
<div class="kpi-label">150 人具過往 OJ 使用經驗，37 人為初次接觸（19.8%）</div>
</div>
</div>

<div class="split55">
<div class="left">

| 背景變項 | 類別 | 人數 | 百分比 |
| :--- | :--- | :---: | :---: |
| **主修科系** | 資訊工程學系（IECS） | 156 | 83.4% |
| | 電機工程學系（EE） | 23 | 12.3% |
| | 其他科系 | 8 | 4.3% |
| **性別** | 男 / 女 | 150 / 37 | 80.2% / 19.8% |
| **年級** | 大一 / 大二 / 大三 / 大四 | 36 / 53 / 72 / 26 | 19.2 / 28.3 / 38.5 / 14.0% |
| **OJ 使用經驗** | 有 / 無 | 150 / 37 | 80.2% / 19.8% |

</div>
<div class="right small-text">

### 📊 樣本結構視覺化分佈
<div style="margin-top: 10px;">
<div class="bar-row"><div><strong>資工系（IECS）</strong></div><div class="bar-track"><div class="bar-fill" style="width: 83.4%;"></div></div><div class="bar-pct">83.4%</div></div>
<div class="bar-row"><div><strong>電機系（EE）</strong></div><div class="bar-track"><div class="bar-fill teal" style="width: 12.3%;"></div></div><div class="bar-pct">12.3%</div></div>
<div class="bar-row"><div><strong>其他科系</strong></div><div class="bar-track"><div class="bar-fill accent" style="width: 4.3%;"></div></div><div class="bar-pct">4.3%</div></div>
<div class="bar-row"><div><strong>大三學生（最多）</strong></div><div class="bar-track"><div class="bar-fill teal" style="width: 38.5%;"></div></div><div class="bar-pct">38.5%</div></div>
<div class="bar-row"><div><strong>具 OJ 經驗</strong></div><div class="bar-track"><div class="bar-fill" style="width: 80.2%;"></div></div><div class="bar-pct">80.2%</div></div>
</div>

</div>
</div>

---

## 5.1 測量模型檢定（外部模型 · 表 2–4）

<div class="split55">
<div class="left">

<div class="fig-box">
<img src="./img/fig3_pls_results.png" alt="圖 3：PLS-Algorithm 測量模型結果" style="max-height: 390px;">
<div class="fig-cap">圖 3：SmartPLS 3.0 因素負荷量與路徑係數估計結果</div>
</div>

</div>
<div class="right small-text">

### ✅ 信度與效度全面達標
| 構面 | CL (≥0.7) | α (≥0.7) | CR (≥0.7) | AVE (>0.5) |
| :--- | :---: | :---: | :---: | :---: |
| **HM 享樂動機** (2) | 0.962–0.965 | 0.924 | 0.963 | **0.929** |
| **SE 自我效能** (2) | 0.938–0.940 | 0.867 | 0.938 | **0.882** |
| **EE 努力預期** (2) | 0.872–0.927 | 0.769 | 0.895 | **0.810** |
| **SI 社會影響** (2) | 0.875–0.914 | 0.752 | 0.889 | **0.800** |
| **ANX 焦慮感** (2) | 0.810–0.956 | 0.753 | 0.879 | **0.786** |
| **BI 行為意願** (2) | 0.835–0.918 | 0.708 | 0.870 | **0.770** |
| **PE 績效預期** (3) | 0.837–0.880 | 0.827 | 0.896 | **0.741** |
| **FC 促成條件** (3) | 0.816–0.877 | 0.794 | 0.879 | **0.709** |

- **Fornell-Larcker 區別效度（表 3–4）**：各構面對角線 √AVE 值（`0.842–0.964`）皆大於與其他構面之相關係數 ➔ **具優良區別與收斂效度**。

</div>
</div>

---

## 5.2 結構模型：直接路徑與 RQ1 實證結果（表 5–6）

<div class="three-col" style="margin-bottom: 8px;">
<div class="kpi-card teal">
<div class="kpi-val">R<sup>2</sup> = 0.754</div>
<div class="kpi-label">行為意願解釋變異量達<strong>高度顯著水準</strong>（> 0.67）</div>
</div>
<div class="kpi-card">
<div class="kpi-val">Q<sup>2</sup> = 0.532</div>
<div class="kpi-label">盲折法交叉驗證冗餘值 > 0 ➔ <strong>具良好預測相關性</strong></div>
</div>
<div class="kpi-card accent">
<div class="kpi-val">4 / 8 項成立</div>
<div class="kpi-label"><strong>HM、SE、SI 與 MJR</strong> 顯著預測使用意願（雙尾拔靴檢定）</div>
</div>
</div>

<div class="split55">
<div class="left">

| 假設 | 路徑關係 | 原始樣本 (O) | SD | t (>1.96) | p (<0.05) | 結論 |
| :---: | :--- | :---: | :---: | :---: | :---: | :---: |
| **H6** | **HM ➔ BI** | **0.400** | 0.080 | **5.008** | **0.000\*\*** | **✓ 成立** |
| **H8** | **SE ➔ BI** | **0.316** | 0.067 | **4.731** | **0.000\*\*** | **✓ 成立** |
| **H4** | **SI ➔ BI** | **0.245** | 0.102 | **2.391** | **0.017\*** | **✓ 成立** |
| **H12** | **MJR ➔ BI** | **-0.098** | 0.044 | **2.239** | **0.026\*** | **✓ 成立** |
| H1 | PE ➔ BI | 0.066 | 0.074 | 0.891 | 0.373 | ✗ 不成立 |
| H2 | EE ➔ BI | -0.035 | 0.076 | 0.457 | 0.648 | ✗ 不成立 |
| H10 | ANX ➔ BI | 0.011 | 0.038 | 0.282 | 0.778 | ✗ 不成立 |
| H5 | FC ➔ BI | 0.010 | 0.104 | 0.098 | 0.922 | ✗ 不成立 |

</div>
<div class="right small-text">

### 🏆 顯著驅動因素影響力排序（RQ1）
<div style="margin-top: 8px;">
<div class="bar-row"><div><strong>HM 享樂動機</strong></div><div class="bar-track"><div class="bar-fill teal" style="width: 100%;"></div></div><div class="bar-pct">β = 0.400</div></div>
<div class="bar-row"><div><strong>SE 自我效能</strong></div><div class="bar-track"><div class="bar-fill teal" style="width: 79%;"></div></div><div class="bar-pct">β = 0.316</div></div>
<div class="bar-row"><div><strong>SI 社會影響</strong></div><div class="bar-track"><div class="bar-fill" style="width: 61.3%;"></div></div><div class="bar-pct">β = 0.245</div></div>
<div class="bar-row"><div><strong>MJR 主修直接</strong></div><div class="bar-track"><div class="bar-fill accent" style="width: 24.5%;"></div></div><div class="bar-pct">|β| = 0.098</div></div>
</div>

<div class="callout teal" style="margin-top: 10px;">
<strong>RQ1 解答：</strong><strong>享樂動機</strong>是最強預測因子，其次為<strong>自我效能</strong>與<strong>社會影響</strong>——遠勝於傳統工具效率與易用性構面（<code>PE</code>, <code>EE</code>, <code>FC</code>）。
</div>

</div>
</div>

---

## 5.3 主修科系調節效果檢定 — RQ2 結果（表 7）

四項關於**主修科系（`MJR`）**之調節假設全數未達顯著水準（`t < 1.96`, `p > 0.05`）：

| 假設 | 調節路徑 | 原始樣本 (O) | 樣本平均 (M) | SD | t 值 (>1.96) | p 值 (<0.05) | 結論 |
| :---: | :--- | :---: | :---: | :---: | :---: | :---: | :---: |
| **H3** | `MJR × EE ➔ BI` | 0.064 | 0.060 | 0.065 | 0.985 | 0.325 | **✗ 不成立** |
| **H7** | `MJR × HM ➔ BI` | 0.006 | -0.013 | 0.083 | 0.067 | 0.947 | **✗ 不成立** |
| **H9** | `MJR × SE ➔ BI` | -0.002 | 0.016 | 0.076 | 0.029 | 0.977 | **✗ 不成立** |
| **H11** | `MJR × ANX ➔ BI` | 0.060 | 0.053 | 0.065 | 0.921 | 0.358 | **✗ 不成立** |

<div class="two-col" style="margin-top: 12px;">
<div class="card accent small-text">

### ⚖️ 無調節效果（`H3, H7, H9, H11` 拒絕）
- 無論是**資工、電機或其他科系**，學習樂趣（`HM`）與解題自信（`SE`）皆以同等強度驅動使用意願。
- 資工與非資工學生同樣未覺得系統特別便利（`H3`），也同樣未因使用 OJ 而感到焦慮（`H11`）。

</div>
<div class="card teal small-text">

### 🎯 但具顯著直接效果（`H12`, p = 0.026*）
- 主修科系仍**直接影響基準使用意願**（`t = 2.239`），反映職涯對程式練習（如未來使用 LeetCode）的需求差異。
- **正向啟示**：只要具備動機、自信與支持，非資工學生同樣能在 OJ 課程中脫穎而出！

</div>
</div>

---

## 6.1 深度診斷：為何有 8 項假設未成立？

將「不顯著」的統計結果，轉化為具體的 **OJ 系統體驗與課程設計診斷**：

| 未成立假設 | 檢定結果 | 訪談與課程脈絡之根因診斷 | 具體設計啟示 |
| :--- | :---: | :--- | :--- |
| **H1：`PE ➔ BI`** | `p = 0.373` (NS) | 與專業 IDE 相比，OJ 缺乏**除錯資訊（debug info）**，削弱學生對開發效率的期待 | 於 OJ 內建階段性**除錯提示與錯誤診斷**功能 |
| **H2：`EE ➔ BI`** | `p = 0.648` (NS) | 網頁編輯器體驗不佳：例如按 Enter **自動縮排**卻須手動刪除，否則 Python 直接編譯錯誤 | 改善程式碼編輯器縮排與現代化 IDE 體驗 |
| **H5：`FC ➔ BI`** | `p = 0.922` (NS) | 線上課程事前已提供清楚操作指引與提醒，基本門檻已被消弭（天花板效應） | 持續維護簡明的新手操作指南與 FAQ |
| **H10：`ANX ➔ BI`** | `p = 0.778` (NS) | 教師事前錄製之**排錯指引影片**有效降低各系學生焦慮——「不好用」不等於「會害怕」 | 保留短影音排錯教學，穩定自主學習信心 |
| **H3, H7, H9, H11** | `p = 0.325–0.977` | 資工生嫌 OJ 不如專業 IDE、外系生覺得操作仍有難度；但樂趣與自信對全體學生皆關鍵 | 打造**跨科系通用之遊戲化與鷹架支持**設計 |

---

## 6.2 實務建議：給 OJ 開發者與授課教師的行動指南

<div class="two-col">
<div class="card small-text">

### 💻 給 OJ 系統開發者與大學決策者
1. **深化遊戲化機制（`HM`, β = 0.400）**：
   - 強化闖關式單元、進度條、徽章與任務回饋，維持遠距學習的持續動機。
2. **補齊除錯支援功能（`PE`）**：
   - 提供結構化的編譯／執行期除錯資訊，取代冰冷單一的 `Wrong Answer` 結果。
3. **消除編輯器操作摩擦（`EE`）**：
   - 修正如 Python 自動縮排誤判等編輯器缺陷，優化單一登入與提交流程。
4. **降低評測焦慮設計（`ANX`）**：
   - 加入草稿自動儲存，並審慎設計常駐公開排行榜以避免過度成績焦慮。

</div>
<div class="card teal small-text">

### 👩‍🏫 給程式設計教師與課程設計者
1. **刻意培養自我效能（`SE`, β = 0.316）**：
   - 錄製簡短**排錯教學影片**並設計由淺入深的題組，幫助學生建立獨立解決問題的自信。
2. **強化正向社會支持（`SI`, β = 0.245）**：
   - 善用**課程討論區、助教即時回覆、電子郵件、通訊軟體與學長姐互助**，維繫學習歸屬感。
3. **友善跨科系學習者（`MJR`）**：
   - 勿預設非資工學生無法適應 OJ：清楚指引 ＋ 遊戲化題目 ＋ 師生支持即可跨越科系門檻。

</div>
</div>

---

## 7. 研究限制與效度威脅

<div class="three-col">
<div class="card small-text">

### 🏫 單一課程樣本範圍
- 受試者（`n = 187`）皆來自台灣逢甲大學之**單一大學部課程**。
- **83.4%** 為資工系學生且 **80.2%** 曾用過 OJ，推論至全初學者或人文社科族群時仍須審慎驗證。

</div>
<div class="card accent small-text">

### 📅 年齡與背景同質性
- 由於大學部受試者年齡高度集中，無法檢驗 UTAUT2 基本調節變項之一——**年齡（Age）**的效果。
- 未來可擴大納入跨年齡層樣本（如 **MOOCs 磨課師**學習者）檢驗年齡調節效應。

</div>
<div class="card teal small-text">

### 📈 使用意願 vs. 長期實際使用
- 本研究於 6 週練習後測量**行為意願（`BI`）**，尚未追蹤課後長期自主使用行為（如持續刷 LeetCode）。
- 未來結合**問卷資料與 OJ 系統提交日誌**，將能更完整驗證意願與實際行為之連結。

</div>
</div>

---

## 8. 結論與未來研究方向

<div class="fig-box" style="padding: 8px 10px; margin-bottom: 8px;">
<img src="./img/diag3_rq_conclusions_zh.svg" alt="RQ1 與 RQ2 實證結論視覺總覽" style="max-height: 355px;">
</div>

<div class="future-strip">
<div class="future-pill"><strong>🌐 1. 擴大跨校與 MOOCs 樣本</strong><br>將調查對象延伸至跨校課程與大型開放式線上課程（MOOCs），提升外部效度。</div>
<div class="future-pill"><strong>👥 2. 年齡調節與長期追蹤</strong><br>納入多元年齡層檢驗年齡調節效果，並串接 OJ 提交紀錄追蹤長期實際使用行為。</div>
<div class="future-pill"><strong>🎮 3. 遊戲化 ＋ 除錯型新一代 OJ</strong><br>結合更豐富的遊戲化元素、內建除錯輔助與流暢編輯器，全面提升學生接受度。</div>
</div>

---

<!-- _class: closing -->

# 感謝聆聽 · 敬請指教！

<p style="font-size: 1.04em; max-width: 860px;">
探討學生於程式設計課程中對線上評測系統（Online Judge）之接受度：結構方程模型分析法
</p>

<div class="contact-card">
<strong>Daramsenge Bilegjargal<sup>*</sup></strong> &nbsp;·&nbsp; <code>p0731809@o365.fcu.edu.tw</code><br>
<strong>薛念林（Nien-Lin Hsueh）</strong> &nbsp;·&nbsp; <code>nlhsueh@fcu.edu.tw</code><br>
逢甲大學 資訊工程學系（Department of Information Engineering and Computer Science, FCU）<br>
發表於 <strong>IEEE Access</strong>, Vol. 9, pp. 152606–152615 (2021) · DOI: <code>10.1109/ACCESS.2021.3126896</code><br>
<span style="font-size: 0.85em; opacity: 0.85;">科技部計畫補助：MOST 109-2221-E-035-056 · 歡迎交流與提問！</span>
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
