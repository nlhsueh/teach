---
marp: true
theme: gaia
size: 16:9
paginate: true
html: true
header: '<div class="hdr-wrap"><span class="hdr-title">分層式 LLM 程式學習輔助機制之應用與分析（SCT）</span><div class="nav-dropdown"><button class="nav-btn">章節導覽 ▾</button><div class="nav-menu"><a href="#2">破題：什麼是 AI Tax？</a><a href="#3">簡報大綱</a><a href="#4">1. 研究動機與問題</a><a href="#6">2. 文獻回顧與缺口</a><a href="#7">3. 研究方法與 LADI</a><a href="#11">4. SCT 系統設計</a><a href="#13">5. 實證研究與結果</a><a href="#20">6. 結論與未來研究</a></div></div></div>'
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

---

## 破題思考：如果使用 AI 協助也要繳交「AI 稅（AI Tax）」？

<div class="fig-box" style="padding: 6px; margin-bottom: 10px; background: #fbf9f2;">
<img src="./img/ai_tax_hook.jpg" alt="程式考試中的 AI Tax 趣味比喻插畫" style="max-height: 415px; border-radius: 6px;">
</div>

<div class="callout" style="margin-top: 6px; padding: 9px 16px;">
<strong>核心破題構想：</strong> 與其全面封閉道路，不如在 AI 快速道上設立<strong>分級收費站</strong>！學生卡關時仍可獲得分層引導，但透過明確的 <strong>AI 稅率（0%–20%）</strong>，讓評量成績維持公平、透明與可解釋性。
</div>

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

---

## 1.1 研究動機：AI 輔助程式學習中的評量困境

<div class="fig-box" style="padding: 10px 12px; margin-bottom: 10px;">
<img src="./img/diag1_assessment_dilemma_zh.svg" alt="未控管開放 AI 與 SCT 分層機制之評量對比" style="max-height: 365px;">
</div>

<div class="callout">
<strong>核心設計理念：</strong> 本研究的目的<strong>並非禁止學生使用 AI</strong>，而是將 AI 輔助轉化為<strong>可控、分層且可紀錄</strong>的教學介入，讓成績能真實反映能力與輔助程度。
</div>

---

## 1.2 研究目標與四大研究問題（RQ1–RQ4）

為驗證 **Smart Coding Tutor（SCT）** 是否能兼顧「鷹架支持」與「評量效度」，本研究探討以下**四大問題** *（逐步揭曉）*：

<div class="rq-stage">

* <div class="rq-card teal"><img src="./img/rq1_icon.svg" alt="RQ1 還原真實能力"><div><div class="rq-hook"><span class="rq-tag" style="background:#0f766e;">RQ1</span> 我們能否揭開滿分假象、還原真實能力？</div><div class="rq-q">分層 AI 輔助機制是否能提升程式評量任務的<strong>成績鑑別度</strong>？</div></div></div>
* <div class="rq-card"><img src="./img/rq2_icon.svg" alt="RQ2 階梯式助推"><div><div class="rq-hook"><span class="rq-tag" style="background:#1b365d;">RQ2</span> 較高層級的提示真的能救起卡關學生嗎？</div><div class="rq-q">不同 AI 輔助層級（L<sub>0</sub>–L<sub>4</sub>）在解題過程中各自產生何種<strong>支持效果</strong>？</div></div></div>
* <div class="rq-card accent"><img src="./img/rq3_icon.svg" alt="RQ3 AI 稅率策略"><div><div class="rq-hook"><span class="rq-tag">RQ3</span> 面對「AI 稅」，學生會怎麼精打細算？</div><div class="rq-q">在具備明確評量成本的分層機制下，學生展現哪些<strong>使用策略與行為模式</strong>？</div></div></div>
* <div class="rq-card"><img src="./img/rq4_icon.svg" alt="RQ4 LADI 與概念理解"><div><div class="rq-hook"><span class="rq-tag" style="background:#1b365d;">RQ4</span> 概念越扎實，就越不依賴 AI 嗎？</div><div class="rq-q">學生的 <strong>AI 依賴程度（LADI）</strong>與其概念理解學習成效之間存在何種關聯？</div></div></div>

</div>

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

---

## 3.1 五級分層 AI 助教與 AI 稅率設計

每道題目皆從 **L<sub>0</sub>** 開始，由學生依解題卡關狀態自主決定是否升級，全層級皆設明確邊界以防直接給出完整解答。

<div class="fig-box" style="padding: 10px 12px; margin: 6px 0 8px 0;">
<img src="./img/diag2_tiered_staircase_zh.svg" alt="五級分層 AI 助教階梯與 AI 稅率示意圖" style="max-height: 350px;">
</div>

<div class="callout">
<strong>AI 稅率計費原則：</strong> 以學生在單題中實際動用的<strong>最高 AI 輔助層級</strong>（而非呼叫次數）作為該題之 AI 使用成本，將外部輔助強度轉化為可觀察的評量指標。
</div>

---

## 3.2 主動式學習支持與完成後概念鞏固

借鏡 Yan 等人的<strong>主動式助手（Proactive Assistant）</strong>架構 [12]，SCT 串聯「解題中停滯提醒」與「通過測資後之概念鞏固」。

<div class="fig-box" style="padding: 10px 12px; margin: 8px 0 10px 0;">
<img src="./img/diag3_proactive_loop_zh.svg" alt="主動式學習支持與完成後概念檢核閉環流程圖" style="max-height: 335px;">
</div>

<div class="callout">
<strong>教學調節原則：</strong> 主動提示保留<strong>學習者主導權</strong>（絕不越俎代庖），而完成後的概念檢核與反思則引導學習從「通過測資」走向「穩定概念理解與遷移」。
</div>

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
