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

<!--
核心訊息：這篇發表於 IEEE Access（2021）的實證研究，以延伸版 UTAUT2 模型搭配 PLS-SEM，揭露大學生在程式設計課程中真正願意採用 Online Judge 系統的關鍵因素。
口說要點：
- 大家好，今天分享我與 Daramsenge Bilegjargal 在逢甲大學資工系合作的研究，發表於 2021 年 11 月的 IEEE Access。
- 線上評測系統（Online Judge）在程式教學中已相當普及，但過去很少有研究從「學生心理與接受度」的角度進行實證檢驗。
- 我們透過真實混成課程的問卷數據，釐清究竟是哪些因素真正決定學生的使用意願。
轉場：在進入理論模型之前，先從一個程式課堂上大家都很熟悉的場景說起。
-->

---

## 破題：「第 12 次提交還是 WA！」……那學生為何仍願意用 Online Judge？

<div class="fig-box" style="padding: 6px; margin-bottom: 10px; background: #fbf9f2;">
<img src="./img/judge_hook.jpg" alt="嚴格的線上評測系統 vs 真正驅動學生接受的關鍵因素" style="max-height: 410px; border-radius: 6px;">
</div>

<div class="callout" style="margin-top: 6px; padding: 9px 16px;">
<strong>出乎意料的發現：</strong>多一個空白（<code>" 12"</code> vs. <code>"12"</code>）就會直接被判錯誤，但<strong>效率與易用性竟然不是關鍵</strong>！真正讓學生買單的是<strong>學習樂趣（享樂動機）</strong>、<strong>解題自信（自我效能）</strong>與<strong>師生同儕支持（社會影響）</strong>——且對資工與非資工學生一體適用。
</div>

<!--
核心訊息：儘管 Online Judge 的嚴格比對常讓學生反覆失敗，但驅動他們持續使用的關鍵其實是學習樂趣、解題自信與同儕師長支持，而非效率或易用性。
口說要點：
- 請看這張插圖：學生交了第 12 次作業還是拿到 Wrong Answer，原因往往只是輸出多了一個空白字元。
- 直覺上大家會以為「好不好用」或「省不省時間」最關鍵，但我們的統計結果卻推翻了這個假設。
- 真正贏得學生青睞的是享樂動機（樂趣）、自我效能（自信）與社會影響（師生支持），而且對資工與非資工學生一體適用。
轉場：接下來我用簡報大綱說明我們如何一步步驗證這個出乎意料的發現。
-->

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

<!--
核心訊息：本次簡報分為六大單元，從研究動機與 12 項假設模型出發，一路帶到 PLS-SEM 實證結果與教學設計指南。
口說要點：
- 首先介紹研究背景與兩大研究問題，聚焦於影響接受度的關鍵因素與主修科系的調節效果。
- 接著說明如何將 UTAUT2 調適為 12 項假設模型，並在逢甲大學 6 週翻轉式資料科學課程中收集 187 份有效問卷。
- 最後不只看成立的假設，也會深入診斷未成立的 8 項假設，轉化為給開發者與教師的實務建議。
轉場：我們先從第一章開始，看看為什麼「自動化批改」並不等於學生就會買單。
-->

---

## 1.1 研究動機：自動化批改不等於學生願意採用

<div class="fig-box" style="padding: 10px 12px; margin-bottom: 10px;">
<img src="./img/diag1_oj_motivation_zh.svg" alt="系統導向之 OJ 工程與學習者導向之接受度建模對比" style="max-height: 365px;">
</div>

<div class="callout">
<strong>研究重要性：</strong>雖然 Codeforces、UVa、SPOJ 與 Edgar 等自動化程式評測系統（APAS）大幅減輕教師批改負擔，但學界至今<strong>尚無實證研究</strong>探討學生在線上程式課程中對 OJ 系統的接受度成因。
</div>

<!--
核心訊息：現有 Online Judge 研究多偏重系統開發與批改效率，卻長期缺乏從學習者角度出發的科技接受度實證研究。
口說要點：
- 如圖所示，Codeforces、UVa、SPOJ 與 Edgar 等系統大幅減輕了教師批改作業的負擔。
- 但如果只從系統工程角度出發，忽略了遠距課程中學習者的心理感受與挫敗感，再強的自動評測也難以發揮教學成效。
- 本研究填補了這個空白，成為少數以實證模型檢驗線上程式課程 OJ 接受度的研究。
轉場：針對這個研究缺口，我們提出兩個核心研究問題。
-->

---

## 1.2 兩大核心研究問題（Research Questions）

本研究以 **UTAUT2 ＋ PLS-SEM** 針對混成式程式設計課程中的 OJ 接受度提出兩大研究問題 *(逐步揭曉)*：

<div class="rq-stage">

* <div class="rq-card teal"><img src="./img/rq1_factors.svg" alt="RQ1 關鍵驅動因素"><div><div class="rq-hook"><span class="rq-tag" style="background:#0f766e;">RQ1</span> 究竟是哪些關鍵因素，真正驅動學生接受 Online Judge？</div><div class="rq-q">在線上程式設計課程中，<strong>哪些構面</strong>（績效預期、努力預期、社會影響、促成條件、享樂動機、自我效能、焦慮感與主修科系）對學生的 <strong>OJ 系統接受度與使用意願（Behavioral Intention）</strong>具有顯著影響？</div></div></div>
* <div class="rq-card accent"><img src="./img/rq2_major.svg" alt="RQ2 主修科系調節效果"><div><div class="rq-hook"><span class="rq-tag">RQ2</span> 資工與非資工主修背景，會改變這些因素的影響力嗎？</div><div class="rq-q"><strong>主修科系（Academic Major, MJR）是否扮演調節變項</strong>，進而改變各候選因素（EE、HM、SE、ANX）與學生使用 OJ 系統之<strong>行為意願</strong>之間的因果關係？</div></div></div>

</div>

<!--
核心訊息：本研究聚焦於找出顯著影響 OJ 使用意願的關鍵構面（RQ1），以及檢驗主修科系是否會改變這些因素的影響力（RQ2）。
口說要點：
- RQ1 一次檢視八個候選構面，包含績效預期、努力預期、社會影響、促成條件、享樂動機、自我效能、焦慮感與主修科系，找出真正顯著的預測因子。
- RQ2 進一步追問：資工系與非資工系學生在易用性、樂趣、自信與焦慮對使用意願的影響上，是否存在統計上的調節差異？
- 回答這兩個問題，能幫助大學設計出對跨科系學生都友善的程式評測課程。
轉場：接著我們快速回顧三大相關文獻脈絡，定位本研究的理論貢獻。
-->

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

<!--
核心訊息：本研究串聯 OJ 系統、UTAUT2 教育科技與 PLS-SEM 三大領域，首度將延伸 UTAUT2 模型應用於自動化程式評測情境。
口說要點：
- 既有 OJ 文獻如 Edgar 與 Jutge.org 著重於多語言評測與成績關聯，但缺乏解釋「學生為何願意使用」的行為接受度模型。
- UTAUT2 整合了八大經典科技接受理論，雖已用於 VR 與 LMS 平台，但尚未納入主修調節來檢驗線上程式評測系統。
- 而在統計方法上，PLS-SEM 採無母數拔靴法，不須常態分佈假設，非常適合單學期課程 187 人的探索性預測建模。
轉場：接下來進入第三章，說明我們如何依據課程情境調適 UTAUT2 理論架構。
-->

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

<!--
核心訊息：我們保留 UTAUT2 五項核心構面、排除三項不適用構面，並針對程式學習情境新增自我效能、焦慮感與主修科系。
口說要點：
- 對照左側圖 1 的原始 UTAUT2，我們保留了績效預期、努力預期、社會影響、促成條件與享樂動機。
- 由於校內 OJ 免費、屬階段性課程工具且為必修評量，因此排除價格價值、習慣與實際使用行為，改以行為意願預測學生課後主動刷題（如 LeetCode）的傾向。
- 同時新增自我效能、焦慮感與主修科系，精準反映遠距寫程式與除錯的心理挑戰。
轉場：將這些構面整合起來，就形成我們的延伸研究模型與 12 項假設。
-->

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

<!--
核心訊息：延伸版 UTAUT2 研究模型共提出 12 項假設，包含 8 條直接影響路徑與 4 條主修科系調節路徑。
口說要點：
- 左側圖 2 呈現完整架構：第一組為 8 條直接影響行為意願的路徑（H1、H2、H4、H5、H6、H8、H10、H12）。
- 其中焦慮感（H10）預期為負向影響，其餘七項皆預期為正向影響。
- 第二組以粗黑線標示（H3、H7、H9、H11），用來檢驗主修科系是否調節努力預期、享樂動機、自我效能與焦慮感對使用意願的作用。
轉場：為了讓這些抽象構面更有畫面感，我們來看看它們在真實 OJ 課堂中對應哪些體驗。
-->

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

<!--
核心訊息：模型中的每一個構面都對應到具體的課堂痛點與教學設計，包括嚴格字元比對、平均 12 次提交與遊戲化闖關單元。
口說要點：
- 左欄對應核心 UTAUT 構面：即時編譯回饋對應績效預期，OpenEdu 單一登入門檻對應努力預期，助教與學長姐互助對應社會影響，而多一個空白就判錯的規則凸顯促成條件的重要。
- 右欄則是心理與背景構面：課程 6 個單元中有 5 個設計為遊戲化闖關（享樂動機），遠距獨立排錯考驗自我效能。
- 學生平均每題要提交約 12 次且面對公開排行榜，因此焦慮感與主修背景也是我們高度關注的變項。
轉場：了解理論架構後，第四章說明我們的課程實施情境與研究流程。
-->

---

## 4.1 混成課程情境與兩階段 PLS-SEM 研究流程

<div class="fig-box" style="padding: 8px 10px; margin-bottom: 8px;">
<img src="./img/diag2_study_pipeline_zh.svg" alt="逢甲大學混成翻轉課程與兩階段 PLS-SEM 分析流程" style="max-height: 310px;">
</div>

<div class="callout" style="margin-top: 6px; padding: 8px 14px;">
<strong>為何選用 SmartPLS 3.0（PLS-SEM）？</strong>相較於共變異數結構方程模型，PLS-SEM 採無母數拔靴法，<strong>不要求多變量常態分佈</strong>，在 <code>n = 187</code> 之單學期課程樣本下仍具高度統計檢定力與預測效度。
</div>

<!--
核心訊息：本研究於逢甲大學 6 週翻轉式資料科學課程收集 22 題問卷，並以 SmartPLS 3.0 執行外部與內部兩階段模型檢定。
口說要點：
- 上方流程圖呈現完整設計：學生透過每週線上單元練習 OJ 後，自願填寫 22 題李克特量表問卷。
- 分析分為兩階段：先檢驗外部測量模型的信度與效度，確認題項品質無虞後，再檢驗內部結構模型的路徑顯著性與預測力。
- 採用 SmartPLS 3.0 能在 n = 187 的單學期課程樣本下提供穩健的無母數拔靴檢定力。
轉場：接下來看看實際參與填答的 187 位學生背景分佈。
-->

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

<!--
核心訊息：修課約 300 人中共有 187 位大學生自願填答（回收率約 62%），以資工系與具 OJ 經驗者為主，亦涵蓋電機與外系學生。
口說要點：
- 從表 1 與右側長條圖可以看到，資工系佔 83.4%（156 人）、電機系佔 12.3%（23 人），其他科系佔 4.3%（8 人）。
- 年級分佈以大三學生最多（38.5%），且有 80.2% 的受試者過去曾使用過 OJ，約兩成為初次接觸。
- 這份樣本結構有助於我們後續解讀主修調節檢定結果，也是討論研究限制時的重要脈絡。
轉場：確認完樣本背景後，第五章正式揭曉 PLS-SEM 的測量與結構模型實證結果。
-->

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

<!--
核心訊息：外部測量模型在因素負荷量、內部一致性信度、收斂效度與區別效度上全數達標，確保問卷構面具高度品質。
口說要點：
- 左側圖 3 呈現 SmartPLS 估計結果，右側表格則彙整各構面的信效度指標：所有構面的因素負荷量、Cronbach's alpha 與組合信度 CR 皆大於 0.7。
- 平均變異萃取量 AVE 介於 0.709（FC）到 0.929（HM）之間，遠高於 0.5 的收斂效度門檻。
- Fornell-Larcker 檢定亦顯示各構面對角線的平方根 AVE（0.842 至 0.964）均大於構面間相關係數，具備優良區別效度。
轉場：測量模型過關後，我們馬上來看 RQ1 的核心答案：究竟哪些因素顯著驅動使用意願？
-->

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

<!--
核心訊息：模型對行為意願的解釋力高達 75.4%（R 平方 = 0.754），其中享樂動機、自我效能、社會影響與主修科系為四項顯著直接驅動因素。
口說要點：
- 先看上方三個關鍵指標：R 平方達 0.754（超過 0.67 屬高度解釋力），盲折法 Q 平方為 0.532，展現良好的預測相關性。
- 針對 RQ1，享樂動機是最強預測因子（beta = 0.400, p < 0.001），其次是自我效能（beta = 0.316）與社會影響（beta = 0.245），主修科系則具較小的直接影響（|beta| = 0.098, p = 0.026）。
- 相對地，傳統認為很重要的績效預期、努力預期、促成條件與焦慮感皆未達顯著水準。
轉場：接著來看 RQ2，主修科系究竟有沒有調節這些因素的影響力？
-->

---

## 5.3 主修科系調節效果檢定 — RQ2 結果（表 7）

四項關於<strong>主修科系（<code>MJR</code>）</strong>之調節假設全數未達顯著水準（`t < 1.96`, `p > 0.05`）：

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

<!--
核心訊息：四項主修科系調節假設全數未成立，代表學習樂趣與解題自信對資工與非資工學生具有同等強度的正向驅動力。
口說要點：
- 表 7 顯示 H3、H7、H9 與 H11 的 t 值皆遠低於 1.96，p 值落在 0.325 到 0.977 之間，全部不顯著。
- 這意味著無論學生來自資工、電機或其他科系，只要覺得有趣且對解題有信心，使用 OJ 的意願就會以幾乎相同的幅度提升。
- 雖然主修科系仍直接影響基準意願（H12），反映不同科系對未來刷題的職涯需求差異，但好消息是非資工學生同樣能透過良好設計獲得成功。
轉場：那麼，為什麼 12 項假設中有高達 8 項未成立？第六章我們把這些「不顯著」轉化為系統診斷。
-->

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

<!--
核心訊息：未成立的 8 項假設揭露了具體的體驗痛點，包括缺乏除錯資訊、編輯器自動縮排陷阱，以及事前排錯影片成功消弭焦慮的效果。
口說要點：
- 透過課後訪談我們發現，績效預期（H1）不顯著是因為 OJ 缺乏像專業 IDE 那樣的除錯資訊；努力預期（H2）不顯著則是網頁編輯器按 Enter 自動縮排常導致 Python 語法錯誤。
- 促成條件（H5）不顯著呈現天花板效應，因為課程事前已提供完整指引，消除了基本操作障礙。
- 而焦慮感（H10）不顯著其實是好現象：老師錄製的簡短排錯影片讓各系學生不再害怕操作，證明「介面不好用」並不等於「學生會焦慮」。
轉場：綜合這些實證與診斷發現，我們整理出一份給開發者與教師的行動指南。
-->

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

<!--
核心訊息：OJ 開發者應深化遊戲化並補齊除錯與編輯器體驗，授課教師則應透過排錯影片與多元社群支持來培養自我效能與歸屬感。
口說要點：
- 給系統開發者：第一優先是強化影響力最大的享樂動機（beta = 0.400），擴充闖關與進度回饋；同時補齊錯誤診斷資訊、修正編輯器縮排缺陷並加入草稿自動儲存。
- 給授課教師：運用簡短排錯影片與由淺入深的題組來建立自我效能（beta = 0.316），並透過助教討論區與學長姐互助發揮社會影響力（beta = 0.245）。
- 針對跨科系班級，只要結合清楚指引、趣味題目與師生支持，就能有效跨越科系門檻。
轉場：在總結之前，我們也誠實檢視本研究的三項限制與效度威脅。
-->

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
- 由於大學部受試者年齡高度集中，無法檢驗 UTAUT2 基本調節變項之一——<strong>年齡（Age）</strong>的效果。
- 未來可擴大納入跨年齡層樣本（如 **MOOCs 磨課師**學習者）檢驗年齡調節效應。

</div>
<div class="card teal small-text">

### 📈 使用意願 vs. 長期實際使用
- 本研究於 6 週練習後測量**行為意願（`BI`）**，尚未追蹤課後長期自主使用行為（如持續刷 LeetCode）。
- 未來結合**問卷資料與 OJ 系統提交日誌**，將能更完整驗證意願與實際行為之連結。

</div>
</div>

<!--
核心訊息：本研究受限於單一校內課程之資工為主樣本、大學生年齡高度同質性，以及僅測量 6 週後之行為意願而非長期實際使用紀錄。
口說要點：
- 首先，187 位樣本全數來自逢甲大學單一課程，其中 83.4% 為資工系、80.2% 曾使用 OJ，外推至人文社科或全初學者時須審慎。
- 其次，大學部受試者年齡相近，無法檢驗 UTAUT2 原始模型中的年齡調節變項，這非常適合未來在 MOOCs 平台上延伸驗證。
- 最後，本研究測量的是 6 週後的行為意願，未來若能結合 OJ 系統提交日誌進行長期追蹤，將更能驗證意願與實際刷題行為的關聯。
轉場：最後我們用一張視覺總結圖來回顧核心結論與未來展望。
-->

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

<!--
核心訊息：學習樂趣、解題自信與社會支持是跨科系通用的 OJ 接受度關鍵，未來將朝跨校 MOOCs 驗證、長期行為追蹤與遊戲化除錯型 OJ 邁進。
口說要點：
- 圖中完整彙整了兩大研究問題的結論：模型解釋力達 75.4%，由享樂動機、自我效能與社會影響領銜（RQ1），且不受主修科系調節（RQ2）。
- 未來研究有三大方向：擴大至跨校與 MOOCs 樣本、納入年齡變項並串接提交日誌追蹤長期使用，以及打造結合遊戲化與除錯輔助的新一代 OJ 系統。
轉場：以上就是本次研究的完整分享，接下來進入結尾並歡迎大家提問交流。
-->

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

<!--
核心訊息：感謝聽眾聆聽，提供論文出處與作者聯絡資訊，並開放現場提問與討論。
口說要點：
- 非常感謝各位的聆聽與指教！
- 本研究全文發表於 IEEE Access（2021），畫面上提供論文 DOI 以及兩位作者的聯絡信箱，歡迎會後進一步交流。
- 接下來開放提問，無論是關於 UTAUT2 模型設計、PLS-SEM 分析細節，或是程式設計課程導入 OJ 的實務經驗，都很歡迎討論。
轉場：開放現場 Q&A。
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

</script>
