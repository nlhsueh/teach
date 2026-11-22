---
marp: true
theme: gaia
size: 16:9
paginate: true
html: true
header: '<div class="hdr-wrap"><span class="hdr-title">PLANT：透過多代理人 AI 框架提升需求工程效率</span><div class="hdr-actions"><a class="lang-btn" href="./Plant_slide.html" title="Switch to English Slides">🌐 EN</a><div class="nav-dropdown"><button class="nav-btn">章節導覽 ▾</button><div class="nav-menu"><a href="#2">破題：單打獨鬥 vs. 團隊協作</a><a href="#3">簡報大綱</a><a href="#4">1. 研究動機與問題</a><a href="#6">2. 文獻回顧與比較</a><a href="#7">3. PLANT 框架設計</a><a href="#12">4. 實證評估與結果</a><a href="#19">5. 結論與未來研究</a></div></div></div></div>'
footer: '薛念林（Nien-Lin Hsueh）＆ Shu-Hsien Liao · 逢甲大學資訊工程學系 · PLANT 多代理人需求工程框架'
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
  min-width: 225px;
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

h1 { color: var(--navy); font-size: 1.65em; font-weight: 800; line-height: 1.26; margin: 0 0 12px 0; }

h2 {
  color: var(--navy);
  font-size: 1.26em;
  font-weight: 700;
  line-height: 1.28;
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
  letter-spacing: 0.05em;
  padding: 5px 14px;
  border-radius: 999px;
  margin-bottom: 18px;
}

section.lead h1 { color: #ffffff; font-size: 1.9em; font-weight: 800; line-height: 1.28; margin-bottom: 12px; text-align: left; }
section.lead .en-title { color: #93c5fd; font-size: 0.86em; font-weight: 500; line-height: 1.4; margin-bottom: 16px; }
section.lead .subtitle { color: #cbd5e1; font-size: 0.94em; line-height: 1.5; margin-bottom: 24px; max-width: 940px; }

section.lead .meta-box {
  border-left: 4px solid #f43f5e;
  padding-left: 18px;
  color: #e2e8f0;
  font-size: 0.85em;
  line-height: 1.6;
}

section.lead .meta-box strong { color: #ffffff; }
section.lead .grant { margin-top: 20px; font-size: 0.72em; color: #94a3b8; }

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

.two-col { display: grid; grid-template-columns: 1fr 1fr; gap: 20px; align-items: stretch; }
.three-col { display: grid; grid-template-columns: repeat(3, 1fr); gap: 15px; align-items: stretch; }
.split64 { display: grid; grid-template-columns: 56% 42%; gap: 2%; align-items: center; }
.split55 { display: grid; grid-template-columns: 49% 49%; gap: 2%; align-items: center; }

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

.kpi-val { font-size: 1.42em; font-weight: 800; color: var(--navy); line-height: 1.15; margin-bottom: 3px; }
.kpi-card.accent .kpi-val { color: var(--accent); }
.kpi-card.teal .kpi-val { color: var(--teal); }
.kpi-label { font-size: 0.76em; color: var(--slate-700); line-height: 1.36; }

.callout {
  background: #f8fafc;
  border-left: 4px solid var(--accent);
  border-radius: 0 8px 8px 0;
  padding: 9px 15px;
  margin-top: 9px;
  font-size: 0.86em;
  color: var(--slate-700);
}

.callout strong { color: var(--navy); }

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
  line-height: 1.35;
}

tr:nth-child(even) td { background: #f8fafc; }

.formula-strip { display: grid; grid-template-columns: 1fr 1.35fr; gap: 14px; margin-top: 8px; }

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
  font-size: 0.94em;
  color: var(--slate-900);
}

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

.outline-body { font-size: 0.85em; line-height: 1.42; }
.outline-body a { color: var(--navy); font-weight: 700; font-size: 1.05em; }

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

.rq-hook { font-size: 0.92em; font-weight: 800; color: var(--navy); line-height: 1.32; margin-bottom: 4px; }
.rq-card.teal .rq-hook { color: var(--teal); }
.rq-card.accent .rq-hook { color: var(--accent); }
.rq-q { font-size: 0.8em; color: var(--slate-700); line-height: 1.42; }

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
  line-height: 1.42;
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

<div class="badge">學術會議專題報告 · 多代理人需求工程</div>

# 透過多代理人 AI 框架提升需求工程效率

<div class="en-title">
Enhancing Requirements Engineering Efficiency through a Multi-Agent AI Framework (PLANT)
</div>

<div class="subtitle">
結合專業角色分工、外部領域知識引導、任務自適應調解（Hybrid Communication）與人機協作（HITL）之需求開發平台
</div>

<div class="meta-box">
<strong>薛念林（Nien-Lin Hsueh）<sup>+</sup></strong>、<strong>Shu-Hsien Liao</strong><br>
逢甲大學 資訊工程學系（Feng Chia University, Taichung, Taiwan）<br>
<code>nlhsueh@fcu.edu.tw</code> · <code>m1325977@o365.fcu.edu.tw</code>
</div>

<div class="grant">
國科會專題研究計畫補助：NSTC114-2221-E-035-077
</div>

<!--
論文背景與核心貢獻：
- 本論文發表於《Journal of Information Science and Engineering (JISE)》（2026），作者為逢甲大學資訊工程學系薛念林（Nien-Lin Hsueh）與 Shu-Hsien Liao，獲國科會計畫 NSTC114-2221-E-035-077 補助。
- 框架全名為 PLANT（Platform for muLtiple Agent-based requiremeNt developmenT），是一套端到端多代理人需求工程（RE）平台，協調 User、Analyst、Expert、Modeler、Mediator 與 Documenter 六大專業 LLM 角色。
- 核心方法創新包含：（1）同步利害關係人提示（SSP）以消除多角色訪談之先發言偏誤；（2）外部法規標準文件檢索與 PlantUML 模型一致性驗證；（3）由調解者主導之任務自適應混合溝通機制（Hybrid-Communication-with-Mediator）；（4）人機協作（HITL）僵局裁決與可追溯至 IEEE 29148 SRS 之設計理由（DR）生成。
- 實證規模：橫跨 5 大跨領域系統（103 項基準隱性需求）與 100 組需求衝突配對，於 GPT-4.1 與 Gemini 3 Flash 雙模型評估成效並量化品質與成本權衡。
-->

---

## 破題思考：「6 輪就搞定！」⋯⋯還是漏掉了半個系統？

<div class="fig-box" style="padding: 6px; margin-bottom: 10px; background: #fbf9f2;">
<img src="./img/plant_hook.jpg" alt="單一代理人 LLM 與 PLANT 多代理人需求團隊對比插畫" style="max-height: 415px; border-radius: 6px;">
</div>

<div class="callout" style="margin-top: 6px; padding: 9px 16px;">
<strong>核心破題構想：</strong> 單一 LLM 容易淪為「點頭稱是的應聲蟲」，聊完表面功能就草草收工。<strong>PLANT</strong> 打造一支<strong>專業分工的多代理人需求團隊</strong>，主動揪出遺漏的資安／隱私需求與潛在衝突，並留下完整決策軌跡。
</div>

<!--
單一代理人過早收斂 vs. 多代理人深度探勘之行為對比：
- 論文實證數據（Table 6）顯示，即使最高允許 20 輪對話，單一代理人訪談基線平均僅進行 6.20 輪（GPT-4.1）或 6.00 輪（Gemini 3 Flash）即自行終止。
- 學理成因：單一 LLM 容易出現迎合偏誤（sycophancy bias）與過早收斂（premature convergence，Du 等人 [3]），在釐清表層功能（互動與內容）後即誤判需求已完備，導致資安、安全、可靠度與效能等非功能性需求（NFRs）大量漏失。
- 多代理人解方：PLANT 將利害關係人模擬、法規稽核與流程建模拆分予專責代理人並由 Mediator 協調，穩定推進至 13.00 至 17.00 輪深度訪談，系統性揭露隱性需求、揪出潛在衝突並沉澱可追溯之會議紀錄（MoM）。
-->

---

## 簡報大綱（Outline）

<div class="outline-grid">

<div class="outline-item">
<div class="outline-num">1</div>
<div class="outline-body">

[**研究動機與三大研究問題**](#4)
單一代理人 LLM 在需求工程的盲區，以及本研究之 RQ1–RQ3。

</div>
</div>

<div class="outline-item">
<div class="outline-num">2</div>
<div class="outline-body">

[**文獻回顧與架構比較**](#6)
現有 LLM 與多代理人需求工程框架之功能對照（Table 1）。

</div>
</div>

<div class="outline-item">
<div class="outline-num">3</div>
<div class="outline-body">

[**PLANT 框架與自適應調解機制**](#7)
六大專業角色、四階段迭代流程、SSP、外部知識庫與混合溝通調解。

</div>
</div>

<div class="outline-item">
<div class="outline-num">4</div>
<div class="outline-body">

[**實證設計與 RQ1–RQ3 結果**](#12)
5 大系統（103 項隱性需求）、100 組衝突配對，以及品質與成本權衡分析。

</div>
</div>

<div class="outline-item">
<div class="outline-num">5</div>
<div class="outline-body">

[**元件貢獻分析與效度威脅**](#17)
各代理人角色之預期貢獻，以及內部／構念／外部效度反思。

</div>
</div>

<div class="outline-item">
<div class="outline-num">6</div>
<div class="outline-body">

[**結論與未來研究方向**](#19)
RQ1–RQ3 核心發現全景概念圖，以及邁向規格驅動開發（SDD）藍圖。

</div>
</div>

</div>

<!--
論文架構與章節導覽：
- 第 1 節（緒論）闡述 AI 輔助軟體開發（AASD）時代下嚴謹 IEEE 29148 規格書之不可替代性，並定義 RQ1 至 RQ3。
- 第 2 節（文獻回顧）綜述 LLM 於需求引出、分析與規格撰寫之應用，並於 Table 1 比較具代表性之單一與多代理人框架。
- 第 3 節（研究方法）詳述 PLANT 六大角色（Table 2）、四階段迭代協作流程（Fig. 2）、同步利害關係人提示（SSP，Fig. 3）、外部知識庫引導，以及調解者主導之混合溝通機制（Fig. 4）。
- 第 4 節（實證評估）說明資料集建構（Table 3）、提示結構（Table 4）、全自動評測協議、RQ1 至 RQ3 量化結果（Tables 5 至 10）、元件貢獻推論與效度威脅。
- 第 5 節（結論）統整核心發現並規劃固定預算消融實驗、真人 SRS 評估與規格驅動開發（SDD）藍圖。
-->

---

## 1.1 研究動機：為何單一代理人 LLM 難以勝任需求工程？

<div class="fig-box" style="padding: 10px 12px; margin-bottom: 10px;">
<img src="./img/diag1_single_vs_multi_zh.svg" alt="單一代理人 LLM 與 PLANT 多代理人團隊對比示意圖" style="max-height: 365px;">
</div>

<div class="callout">
<strong>AI 輔助開發（AASD）時代的關鍵：</strong> AI 寫程式越快，若缺乏嚴謹的 <strong>IEEE 29148 SRS</strong>（特別是資安、隱私、可靠度等非功能性需求），系統擴張後越容易演變為難以維護的碎裂架構。
</div>

<!--
AASD 時代下之理論動機與實務痛點：
- AI 輔助軟體開發（AASD，Ozkaya [1]）促使軟體工程師由程式實作者轉型為監督者與決策者；然而程式碼生成越快，若缺乏嚴謹的 IEEE 29148 軟體需求規格書（SRS）引導，系統擴張後越容易產生架構碎裂與高昂維護成本。
- 組織人力瓶頸：實務上協調異質利害關係人（特別是安全、隱私、效能、可靠度與擴展性等最易起衝突也最常被忽略的 NFRs）高度仰賴資深系統分析師進行多輪會議，但業界普遍缺乏資深分析人力，導致前期分析遭大幅壓縮。
- LLM 之優勢與單一角色極限：LLM 內建廣泛的軟體標準知識且擅長繁瑣規格彙整，但單一虛擬訪談者（如 Korn 等人 [2]）在單一脈絡視窗中同時承擔訪談、法規查核與建模職能，極易陷入迎合偏誤與過早收斂（Du 等人 [3]）。
-->

---

## 1.2 研究目標與三大研究問題（RQ1–RQ3）

本研究聚焦於兩大上游需求核心任務與計算成本權衡，進行嚴謹量化評估 *（逐步揭曉）*：

<div class="rq-stage">

* <div class="rq-card teal"><img src="./img/rq1_ir.svg" alt="RQ1 挖掘隱性需求"><div><div class="rq-hook"><span class="rq-tag" style="background:#0f766e;">RQ1</span> 專業分工的 AI 團隊，能挖出客戶「忘了說」的需求嗎？</div><div class="rq-q"><strong>PLANT 發掘隱性需求（Implicit Requirements）的成效為何？</strong>特別是容易被忽略的非功能性需求（NFRs）。</div></div></div>
* <div class="rq-card accent"><img src="./img/rq2_conflict.svg" alt="RQ2 辨識需求衝突"><div><div class="rq-hook"><span class="rq-tag">RQ2</span> 多角色交叉審議，能否抓出暗藏的規格矛盾？</div><div class="rq-q"><strong>PLANT 辨識需求衝突（Requirement Conflicts）的準確度與召回率</strong>，相較單一代理人表現為何？</div></div></div>
* <div class="rq-card"><img src="./img/rq3_cost.svg" alt="RQ3 成本效益權衡"><div><div class="rq-hook"><span class="rq-tag" style="background:#1b365d;">RQ3</span> 多代理人協作多花的時間與 Token，到底划不划算？</div><div class="rq-q"><strong>PLANT 在需求開發中的成本效益為何？</strong>（Token 消耗、執行時間、API 費用與單位需求成本）</div></div></div>

</div>

<!--
三大研究問題（RQ1 至 RQ3）之實證範疇：
- 雖然 PLANT 完整系統支援產出 UML 模型、會議紀錄（MoM）、設計理由（DR）與 IEEE 29148 SRS（詳見公開範例庫），本論文之嚴格量化評估聚焦於兩項上游核心瓶頸與資源經濟性：
  - RQ1（隱性需求引出）：於 5 大跨領域系統（103 項基準隱性需求）評估不重複隱性需求召回率（IRE）與早期輪次提問效率（TKQR）。
  - RQ2（需求衝突辨識）：於醫院管理（70 組）與外送平台（30 組）合計 100 組平衡配對上，評估總體 Macro F1 及衝突類別之 Precision、Recall 與 F1。
  - RQ3（成本效益權衡）：跨 GPT-4.1 與 Gemini 3 Flash 記錄 Token 消耗、執行時間、API 費用、每百萬 Token 之 IRE 邊際增益，以及單一隱性需求之單位成本，界定實務導入條件。
-->

---

## 2. 文獻回顧與架構比較（Table 1）

既有 LLM 需求工程研究多缺乏**任務自適應的衝突調解機制**與**可追溯的設計理由（Design Rationale）紀錄**。

| 相關研究 | 核心作法說明 | 引出 | 分析 | 規格 | 多代理 | 協商 | 追溯 |
| :--- | :--- | :---: | :---: | :---: | :---: | :---: | :---: |
| LLMREI [2] / RECOVER [7] | 以單一虛擬訪談者進行需求訪談與整理 | ✓ | × | × | × | × | × |
| Elicitron [8] | 模擬產品使用情境與代理訪談以探索需求 | ✓ | ✓ | × | ✓ | × | × |
| MAD [9] | 透過多代理人辯論提升需求分類準確度 | × | ✓ | × | ✓ | ✓ | × |
| ReqInOne [10] | 單一代理人工作流分析需求並產出 SRS | × | ✓ | ✓ | × | × | × |
| MARE [11] / iReDev [12] | 多代理人分工搭配共享工作區或領域知識圖譜 | ✓ | ✓ | ✓ | ✓ | × | × |
| **本研究（PLANT）** | **整合六大角色、調解者自適應協商與完整設計理由追溯** | **✓** | **✓** | **✓** | **✓** | **✓** | **✓** |

<div class="callout">
<strong>研究缺口：</strong> 即便是 MARE 與 iReDev，仍採循序交接模式，缺少能依議題動態切換溝通策略、遇僵局升級交由人類專家（HITL）裁決並沉澱設計理由的 <strong>Mediator</strong> 角色。
</div>

<!--
文獻回顧與架構比較（Table 1 深度解析）：
- 單階段／單代理人系統：LLMREI [2]（33 場模擬訪談，以 zero-shot 與 CoT 萃取出逾 73% 有效需求）與 RECOVER [7] 聚焦於引出階段；ReqInOne [10] 以單一代理人進行分析與 SRS 草擬；形式邏輯矛盾偵測（Gärtner & Göhlich [14]）與使用案例萃取（Eisenreich 等人 [15]）則專注於單一分析子任務。
- 早期多代理人 RE 研究：Elicitron [8] 模擬使用情境與角色訪談但未涵蓋協商與規格產出；MAD [9] 則將多代理人辯論限縮於需求分類準確度。
- 端到端多代理人先驅：MARE [11] 透過共享工作區串聯引出、建模、驗證與規格角色；iReDev [12] 進一步結合領域知識圖譜迭代精煉需求文件。
- PLANT 填補之關鍵缺口：MARE 與 iReDev 皆採循序或共享工作區交接，缺乏能依議題目標動態切換溝通拓樸、遇僵局升級人機協作裁決（呼應 Arora 等人 [6] 主張），並將多輪協商紀錄沉澱為可追溯設計理由（DR）的專責 Mediator 角色。
-->

---

## 3.1 PLANT 框架總覽與六大專業代理人角色

<div class="split64">
<div class="left">

<div class="fig-box">
<img src="./img/fig1_overview.png" alt="Fig. 1: PLANT 框架架構總覽" style="max-height: 400px;">
<div class="fig-cap">Fig. 1：PLANT 多代理人需求工程框架總覽</div>
</div>

</div>
<div class="right small-text">

### 🤖 六大專業代理人角色（Table 2）
- **User**：模擬多方利害關係人第一人稱視角（使用情境與痛點）。
- **Analyst**：結構化需求、界定系統範疇（In/Out-of-Scope）並揪出衝突。
- **Expert**：檢索外部文件庫，稽核領域法規、個資保護與 ISO 25010。
- **Modeler**：繪製並以工具驗證 PlantUML（使用案例、類別、循序圖）。
- **Mediator**：規劃議程、動態切換溝通模式、遇僵局啟動 HITL 裁決。
- **Documenter**：彙整會議紀錄（MoM），產出 **IEEE 29148 SRS** 與設計理由（DR）。

</div>
</div>

<!--
六大專業代理人角色定義與輸入輸出架構（Fig. 1、Table 2 與 Table 4）：
- User（多方利害關係人模擬）：透過 SSP 同步扮演經確認之利害關係人角色，以結構化 JSON 輸出第一人稱使用情境、作業痛點、預期功能與顧慮。
- Analyst（資深系統分析師）：萃取原子化需求、界定系統範疇（In-Scope 與 Out-of-Scope）、偵測配對需求衝突並附理由，持續維護需求草案與衝突報告。
- Expert（資深領域專家）：檢索外部文件庫與搜尋工具，依據領域法規、個資保護法、支付規範與 ISO/IEC 25010 品質模型稽核草案，引用具體條文提出風險評估或探勘提問。
- Modeler（資深需求建模師）：繪製並更新 PlantUML 使用案例、類別與循序圖，呼叫語法與一致性檢查工具以揭露遺漏的參與者、狀態或逾時例外。
- Mediator（資深需求調解者）：規劃有限輪數議程、動態擇定 Simultaneous-Talk 或 One-by-One 溝通模式、判定共識、撰寫會議紀錄（MoM）並將僵局升級至 HITL。
- Documenter（資深規格撰寫師）：依 IEEE 29148 標準彙整具備驗收準則之功能與非功能需求，並將多輪 MoM 決策串聯為完整設計理由文件。
-->

---

## 3.2 四階段迭代需求協作流程

<div class="split55">
<div class="left">

<div class="fig-box">
<img src="./img/fig2_process.png" alt="Fig. 2: PLANT 四階段需求開發流程" style="max-height: 390px;">
<div class="fig-cap">Fig. 2：PLANT 四階段迭代協作與產出物更新流程</div>
</div>

</div>
<div class="right small-text">

### 🔄 告別「單次生成」的迭代精煉
1. **階段一 · 同步利害關係人引出（SSP）**：從初步構想出發，由 `User` 同步模擬多方角色，廣泛收集期待與痛點。
2. **階段二 · 多視角分析、知識稽核與建模**：`Analyst` 界定範疇與衝突、`Expert` 查核法規、`Modeler` 驗證 PlantUML 並行運作。
3. **階段三 · 調解者引導之迭代協商**：於上限 `r` 輪內由 `Mediator` 調度討論、寫入 `MoM` 並同步更新草案與模型。
4. **階段四 · 規格與設計理由產出**：收斂後由 `Documenter` 產出符合 **IEEE 29148** 之 SRS 並串聯完整設計理由（DR）。

</div>
</div>

<!--
四階段迭代需求協作流程（Fig. 2）：
- 階段一（SSP 同步利害關係人引出）：由人類提案者輸入初步構想並確認候選利害關係人角色，User 代理人並行模擬多方視角，廣泛收集期待與痛點。
- 階段二（多視角分析、知識稽核與建模）：Analyst 結構化需求並界定範疇與初始衝突；Expert 查核外部法規與標準；Modeler 建構並驗證 PlantUML 系統模型。三者並行運作後由 Analyst 彙整為基準需求草案與衝突報告。
- 階段三（調解者引導之迭代協商）：於上限 r 輪內，Mediator 提取未解衝突與開放問題，依議題切換溝通策略協調討論；若出現高影響僵局則交由人類專家（HITL）裁決，將共識寫入 MoM 並驅動草案、衝突報告與 UML 模型同步更新。
- 階段四（規格與設計理由產出）：所有議題收斂或達輪數上限 r 後，Documenter 編撰符合 IEEE 29148 之 SRS，並將每項需求追溯至原始討論、衝突權衡與 MoM 裁決。
-->

---

## 3.3 同步利害關係人提示（SSP）與外部知識驗證

<div class="fig-box" style="padding: 8px 12px; margin-bottom: 10px;">
<img src="./img/fig3_ssp.png" alt="Fig. 3: Simultaneous Stakeholder Prompting (SSP)" style="max-height: 185px;">
<div class="fig-cap">Fig. 3：同步利害關係人提示（SSP）— 獨立多角色並行發想</div>
</div>

<div class="two-col">
<div class="card small-text">

### 🗣️ 避免偏誤的多角色並行引出（SSP）
- 延伸 Solo Performance Prompting（SPP）[19]，採 **Simultaneous-Talk** [4] 讓不同角色（如消費者、外送員、餐廳業者）互不干擾地獨立提出需求，避免被先發言者帶偏。

</div>
<div class="card teal small-text">

### 📚 外部領域知識與 PlantUML 一致性檢查
- **Expert** 於初審與協商兩階段檢索文件庫（ISO 29148、ISO 25010、個資法規），引用具體條文佐證建議。
- **Modeler** 透過 PlantUML 語法與流程檢查揭露遺漏例外（例如*外送員接單逾時自動轉派機制*）。

</div>
</div>

<!--
同步利害關係人提示（SSP）、雙時點知識檢索與模型驗證（Fig. 3）：
- 同步利害關係人提示（SSP）：延伸 Solo Performance Prompting（SPP，Wang 等人 [19]）並結合 Simultaneous-Talk（Chan 等人 [4]），讓各模擬角色（如重視點餐便利與支付的消費者、重視尖峰接單控管的餐廳業者、重視路線與收益透明的外送員）互不干擾地獨立生成需求，避免早期發言錨定。
- 雙時點外部知識驗證：使用者事前上傳專案參考文件、個資與支付法規、ISO/IEC/IEEE 29148 [18] 與 ISO/IEC 25010 [20] 至文件庫。Expert 於（1）階段二初審與（2）階段三協商遇法規或技術可行性疑問時即時檢索條文。
- 雜訊與矛盾過濾機制：Expert 先依已確認之 In-Scope 邊界過濾檢索段落並明確引證；進入 One-by-One 協商後，Analyst 與 Modeler 交叉檢驗法規建議是否與業務流程衝突，若仍具歧義則由 Mediator 彙整方案升級至 HITL。
- PlantUML 一致性檢查：將文字需求轉為正式循序圖與使用案例圖，可系統性揭露遺漏之生命週期例外（例如外送員接單逾時自動轉派機制）。
-->

---

## 3.4 調解者引導之協商流程（Mediator-Guided Negotiation）

<div class="split55">
<div class="left">

<div class="fig-box">
<img src="./img/fig4_negotiation.png" alt="Fig. 4: 調解者引導之協商流程" style="max-height: 410px;">
<div class="fig-cap">Fig. 4：調解者引導之有限輪數協商與 HITL 升級機制</div>
</div>

</div>
<div class="right small-text">

### ⚖️ 結構化議程與有限輪數收斂
- 每輪開始（`1 ≤ t ≤ r`），**Mediator** 檢視最新草案與衝突報告，將議題分為四大類：
  1. 開放問題探索（Open Question）
  2. 新需求補充（New Requirement）
  3. 需求權衡評估（Trade-off）
  4. 需求衝突解決（Conflict Discussion）
- **達成共識** ➔ 記錄於會議紀錄（`MoM`），驅動草案與 UML 同步更新。
- **持續僵局／重大商業權衡** ➔ 彙整各方論點與候選方案，交由<strong>人類專家（HITL）</strong>裁決。

</div>
</div>

<!--
調解者引導之有限輪數協商與 HITL 升級機制（Fig. 4）：
- 結構化議程規劃（1 <= t <= r）：每輪開始時，Mediator 檢視最新需求草案、未解衝突報告與待釐清疑問，將議程議題歸類為四大類：（1）開放問題探索、（2）新需求補充、（3）需求權衡評估與（4）需求衝突解決。
- 共識判定與產出同步：當參與代理人針對單一議題完成發言且達成一致結論、無人要求進一步釐清時，Mediator 將決策寫入會議紀錄（MoM），並於該輪結束時觸發草案、衝突報告與 PlantUML 模型更新。
- 僵局與重大商業權衡之 HITL 升級：若歷經審議仍存實質分歧，或涉及高影響業務取捨（如嚴格個資刪除義務 vs. 爭議稽核紀錄留存），Mediator 會將各方論點與候選方案結構化呈現予人類專家裁決，避免由 LLM 任意表決。
-->

---

## 3.5 任務自適應混合溝通機制（Hybrid Communication）

PLANT 的核心創新在於由 `Mediator` 依議題目標，在 **Simultaneous-Talk**（發散探索）與 **One-by-One**（收斂決策）之間動態切換。

<div class="fig-box" style="padding: 8px 10px; margin-top: 6px;">
<img src="./img/diag2_hybrid_comm_zh.svg" alt="任務自適應混合溝通調解機制示意圖" style="max-height: 365px;">
</div>

<!--
任務自適應混合溝通機制（Hybrid-Communication-with-Mediator）：
- 文獻歸屬與創新界定：論文明確指出 Simultaneous-Talk 與 One-by-One 兩種基本溝通原語源自 ChatEval（Chan 等人 [4]），並非本研究新創；PLANT 的核心創新在於引入專責 Mediator，依據每項議題之需求工程目標在兩模式間動態切換。
- 發散式資訊擴展 -> Simultaneous-Talk（議題類型 1 與 2：開放問題、新需求補充）：Analyst、Expert 與 Modeler 在同一輪次中各自獨立提問或評估，互不檢視他人輸出，藉此消除早期錨定與從眾效應，最大化功能範疇、法規合規與行為狀態之視角覆蓋率。
- 收斂式決策形成 -> One-by-One（議題類型 3 與 4：需求權衡、衝突解決）：代理人依序審議（Analyst -> Expert -> Modeler），後發言者檢視前序論點以驗證折衷方案是否違反領域法規或狀態轉換邏輯，逐步收斂為一致決議。
-->

---

## 4.1 實證實驗設計與評估指標

<div class="fig-box" style="padding: 8px 10px; margin-bottom: 8px;">
<img src="./img/diag3_eval_setup_zh.svg" alt="實證實驗設計與資料集管線圖" style="max-height: 225px;">
</div>

<div class="formula-strip">
<div class="formula-box">
<i>IRE<sub>t</sub></i> &nbsp;=&nbsp;
<span class="frac"><span class="frac-num"><i>E<sub>t</sub></i></span><span class="frac-den"><i>R<sub>t</sub></i></span></span>
&nbsp;× 100%
<span style="font-family: 'Noto Sans TC', sans-serif; font-size: 0.76em; color: #64748b; margin-left: 10px;">（隱性需求召回率）</span>
</div>
<div class="formula-box">
<i>TKQR<sub>t</sub></i> &nbsp;=&nbsp;
<span class="frac"><span class="frac-num">∑ <i>h<sub>t,i</sub></i> / log<sub>2</sub>(<i>i</i> + 1)</span><span class="frac-den">∑ 1 / log<sub>2</sub>(<i>i</i> + 1)</span></span>
&nbsp;× 100%
<span style="font-family: 'Noto Sans TC', sans-serif; font-size: 0.76em; color: #64748b; margin-left: 10px;">（早期輪次提問效率）</span>
</div>
</div>

<div class="callout" style="margin-top: 8px; padding: 7px 14px;">
<strong>嚴格自動化公平評測：</strong> RQ1 與 RQ2 基準測試皆關閉 HITL（<strong>0 次人工介入</strong>，<code>temperature = 0</code>，上限 20 輪），並由獨立之 <strong>GPT-5.2</strong> 擔任 LLM-as-a-Judge 判定語意命中。
</div>

<!--
實證資料集建構、基線設計與評測協議（Tables 3 與 4）：
- RQ1 資料集（5 大系統共 103 項隱性需求）：採用 ReqElicitGym [21] 基準中之 4 套系統（股市報告、醫院管理、線上訂票、單字學習，原僅含 36 項互動／內容／風格功能性隱性需求），依據 ISO/IEC 25010 [20] 擴充六大非功能性維度（可靠度、相容性、彈性、效能、資安、安全性），並新建第 5 套多利害關係人案例「外送平台（19 項）」，經人工逐項審查確認與初始描述無重疊。
- RQ2 資料集（100 組平衡配對）：採用 CN 資料集 [22] 醫院管理子集全數 35 組衝突配對並隨機抽樣 35 組中性配對（共 70 組），另為外送平台建構並人工驗證 30 組平衡配對（15 衝突、15 中性）。
- 基線選擇說明：與同底層模型（GPT-4.1、Gemini 3 Flash）之單一代理人基線對比。既有 MARE、iReDev 與 MAD 未直接納入基準對照，係因 MARE／iReDev 針對靜態描述進行端到端生成（iReDev 另需專屬領域知識圖譜）而非 ReqElicitGym 逐輪互動訪談，MAD 則聚焦需求類型分類且缺乏相容開源評測管線。
- 全自動公平設定與指標：RQ1 與 RQ2 關閉 HITL（0 次人工介入）、temperature = 0、上限 r = 20 輪（RQ1）；RQ2 執行 3 次獨立試驗並報告 Mean +/- Std。RQ1 由模擬利害關係人僅在被直接追問對應面向時揭露基準隱性需求，並由獨立模型 GPT-5.2 擔任 LLM-as-a-Judge（參照 G-Eval [23]）判定語意命中且經作者覆核。IRE_t = (E_t / R_t) * 100% 衡量不重複隱性需求召回率；TKQR_t 採 1 / log2(i + 1) 對數折扣衡量早期輪次提問效率。
-->

---

## 4.2 RQ1 案例剖析：外送平台之多視角深度探勘（Table 5）

在 **Simultaneous-Talk** 模式下，三位代理人針對同一異常訂單情境，從各自專業視角獨立提問：

| 代理人角色 | 獨立探勘提問角度 | 成功引出之利害關係人真實需求 |
| :--- | :--- | :--- |
| **Analyst** | 異常處理選項（聯繫客服／取消訂單）應適用於所有異常，或僅限延遲與外送員爽約？ | *任何異常情境下「聯繫客服」皆須可用，其餘視情況提供。* |
| **Expert** | 若系統**隱藏雙方真實電話號碼**，改採 App 內建聊天或匿名轉接通話，是否符合需求？ | **命中隱性需求！** *不應直接暴露顧客與外送員電話，須改採 App 內匿名通話並留存爭議紀錄。* |
| **Modeler** | 異常即時處理選項是否應依**訂單生命週期狀態**限制（例如特定階段禁止取消）？ | *取消權限依訂單狀態與退款政策決定，但須清楚呈現原因。* |

<div class="callout">
<strong>多視角互補價值：</strong> 當 Analyst 與 Modeler 釐清功能規則與狀態限制時，<strong>Expert</strong> 成功挖出原始需求描述隻字未提的<strong>資安與個資隱私隱性需求</strong>。
</div>

<!--
RQ1 外送平台多視角探勘對話軌跡剖析（Table 5）：
- 情境脈絡：外送平台異常訂單處理議題，Mediator 啟用 Simultaneous-Talk 模式。
- 單輪正交視角提問實例：
  - Analyst 追問異常處理選項（聯繫客服／取消訂單）是否適用所有異常或特定延誤／外送員爽約，確認「聯繫客服」於任何異常皆須常駐可用。
  - Modeler 追問即時處理選項是否應受訂單生命週期狀態限制，釐清取消權限須依訂單階段與退款政策判定並明示原因。
  - Expert 獨立從個資保護視角詢問是否應隱藏真實電話、改採 App 內建聊天或匿名轉接通話，精準觸發模擬用戶說出原始描述隻字未提之基準隱性需求（禁止暴露顧客與外送員電話，並留存紀錄供爭議調閱）。
- 機制驗證：由於三位角色發言前彼此隔離，功能面提問不會將 Expert 錨定於表層規則，成功開啟隱私合規維度。
-->

---

## 4.3 RQ1 實證結果：隱性需求引出成效（103 項 IRs）

<div class="three-col" style="margin-bottom: 10px;">
<div class="kpi-card teal">
<div class="kpi-val">54.28% vs. 16.77%</div>
<div class="kpi-label"><strong>GPT-4.1</strong> 平均 IRE（54 vs. 17 項 · <strong>3.2 倍</strong>提升）</div>
</div>
<div class="kpi-card">
<div class="kpi-val">46.79% vs. 18.90%</div>
<div class="kpi-label"><strong>Gemini 3 Flash</strong> 平均 IRE（48 vs. 19 項 · <strong>2.5 倍</strong>提升）</div>
</div>
<div class="kpi-card accent">
<div class="kpi-val">13–17 vs. ~6 輪</div>
<div class="kpi-label">突破過早終止（TKQR：54.95% / 64.87%）</div>
</div>
</div>

<div class="split55">
<div class="left small-text">

### 🏆 非功能性需求（NFR）關鍵突破（GPT-4.1 · Table 7）
<div style="margin-top: 8px;">
<div class="bar-row"><div><strong>資安 Security (12)</strong></div><div class="bar-track"><div class="bar-fill teal" style="width: 83.3%;"></div></div><div class="bar-pct">10 vs. 2</div></div>
<div class="bar-row"><div><strong>安全 Safety (3)</strong></div><div class="bar-track"><div class="bar-fill teal" style="width: 100%;"></div></div><div class="bar-pct">3 vs. 0</div></div>
<div class="bar-row"><div><strong>可靠 Reliability (7)</strong></div><div class="bar-track"><div class="bar-fill" style="width: 71.4%;"></div></div><div class="bar-pct">5 vs. 0</div></div>
<div class="bar-row"><div><strong>相容 Compat. (10)</strong></div><div class="bar-track"><div class="bar-fill" style="width: 70%;"></div></div><div class="bar-pct">7 vs. 3</div></div>
<div class="bar-row"><div><strong>效能 Perf. (6)</strong></div><div class="bar-track"><div class="bar-fill accent" style="width: 66.7%;"></div></div><div class="bar-pct">4 vs. 0</div></div>
</div>

</div>
<div class="right small-text">

### 📊 五大系統案例 IRE (%) 比較 — Table 6
| 系統案例 | 基線 (GPT) | PLANT (GPT) | 基線 (Gem) | PLANT (Gem) |
| :--- | :---: | :---: | :---: | :---: |
| 股市報告 | 17.65 | **82.35** | 23.53 | **52.94** |
| 醫院管理 | 19.05 | **47.62** | 23.81 | **47.62** |
| 線上訂票 | 13.04 | **43.48** | 8.70 | **39.13** |
| 單字學習 | 13.04 | **34.78** | 17.39 | **52.17** |
| 外送平台 | 21.05 | **63.16** | 21.05 | **42.11** |

</div>
</div>

<!--
RQ1 隱性需求引出之量化成果與深入解讀（Tables 6 與 7）：
- 整體 IRE 表現：橫跨 5 套系統，PLANT 於 GPT-4.1 將平均 IRE 由 16.77%（Std 3.23）大幅提升至 54.28%（Std 16.78，命中 54 vs. 17 項，達 3.2 倍）；於 Gemini 3 Flash 則由 18.90%（Std 5.60）升至 46.79%（Std 5.44，命中 48 vs. 19 項，達 2.5 倍）。個別案例中，GPT-4.1 於股市報告達 82.35%、外送平台達 63.16%。
- 非功能性需求突破（Table 7）：單一基線高度集中於表層互動與內容（GPT-4.1 佔 11/17、Gemini 佔 13/19），在可靠度（0/7）、效能（0/6）與安全性（0/3）全數掛零，資安僅命中 2/12。PLANT（GPT-4.1）則成功發掘 10/12 資安、3/3 安全性、5/7 可靠度、7/10 相容性與 4/6 效能（風格面向為 0/10，反映系統偏重工程與合規約束）。
- 輪數深度與 TKQR 解讀：PLANT 平均推進 17.00 輪（GPT-4.1）與 13.00 輪（Gemini 3 Flash），顯著突破基線約 6 輪過早終止。PLANT 平均 TKQR 略低於基線（GPT-4.1：54.95% vs. 61.35%；Gemini：64.87% vs. 70.43%），因多代理人前期先穩固範疇與系統脈絡，於中後輪次密集挖掘深層 NFRs。論文亦指出 IRE 屬召回導向指標，深層探勘可能產生過度細化建議，實務上須透過範疇過濾與 HITL 審查收斂。
-->

---

## 4.4 RQ2 實證結果：需求衝突辨識成效（100 組配對）

透過 **One-by-One** 依序審議（例：*客服須完整保留對話紀錄* vs. *結案後立即刪除對話與聯絡方式*），Analyst、Expert 與 Modeler 交叉查核資料留存規則、個資法規與狀態生命週期（Tables 8 & 9）。

| 資料集 | 方法 | 底層模型 | 總體 Macro F1 | 衝突精確率 | 衝突召回率 | 衝突類別 F1 |
| :--- | :--- | :--- | :---: | :---: | :---: | :---: |
| **醫院管理**（70 組） | 單一基線 | GPT-4.1 / Gemini 3 | 81.33 / 72.52 | 86.67 / 79.30 | 74.29 / 61.91 | 80.00 / 69.51 |
| **醫院管理**（70 組） | **PLANT** | **GPT-4.1 / Gemini 3** | **90.91 / 89.46** | 86.66 / 84.35 | **97.14 / 97.14** | **91.51 / 90.28** |
| **外送平台**（30 組） | 單一基線 | GPT-4.1 / Gemini 3 | 89.90 / 86.43 | 100.0 / 100.0 | 80.00 / 73.33 | 88.89 / 84.62 |
| **外送平台**（30 組） | **PLANT** | **GPT-4.1 / Gemini 3** | **95.55 / 96.66** | 95.69 / 93.75 | **95.55 / 100.0** | **95.55 / 96.77** |

<div class="callout">
<strong>RQ2 發現：</strong> 單一基線過於保守（漏抓 20%–38% 衝突）。PLANT 將<strong>衝突召回率大幅拉升至 95.55%–100.00%</strong>，衝突 F1 提升 <strong>+6.66 至 +20.77 個百分點</strong>，且能區分前後端資料範疇以避免誤報。
</div>

<!--
RQ2 需求衝突辨識之審議軌跡與統計成果（Tables 8 與 9）：
- One-by-One 審議實例（Table 8）：面對「客服系統須完整保留對話與操作紀錄」與「問題解決後須刪除聊天紀錄與個人聯絡方式」之衝突配對，Analyst 指出資料留存政策直接矛盾、Expert 指出個資保留期限與刪除義務互斥、Modeler 確認同一資料物件於狀態設計中無法同時保留與刪除，三方達成 Conflict 共識。反之，若兩需求作用於不同資料範疇（如前端隱藏已刪除地址 vs. 後端稽核日誌留存去識別化雜湊），依序交叉檢查能有效避免誤報（False Positive）。
- 醫院管理（70 組，3 次獨立執行 Mean +/- Std）：總體 Macro F1 由 81.33 +/- 0.00% 升至 90.91 +/- 1.81%（GPT-4.1），由 72.52 +/- 0.08% 升至 89.46 +/- 1.37%（Gemini 3 Flash）；衝突類別召回率由 74.29% 與 61.91% 同步躍升至 97.14%，衝突 F1 分別提升 +11.51 與 +20.77 個百分點。
- 外送平台（30 組）：總體 Macro F1 由 89.90% 升至 95.55%（GPT-4.1），由 86.43% 升至 96.66%（Gemini 3 Flash）。單一基線雖具 100% 精確率，實因過於保守僅標記顯性字面矛盾而漏抓 20.00% 至 26.67% 衝突；PLANT 將衝突召回率拉升至 95.55% 與 100.00%，衝突 F1 提升 +6.66 與 +12.15 個百分點。
-->

---

## 4.5 RQ3 實證結果：成本效益與實務導入權衡（Table 10）

| 底層 LLM | 命中 IR 數（基線 / PLANT） | 平均 Token (k)（基線 / PLANT） | 平均執行時間（基線 / PLANT） | 平均 API 費用（基線 / PLANT） | 每 1M Tok. IRE 增益 | 單一 IR 成本（PLANT / 基線） |
| :--- | :---: | :---: | :---: | :---: | :---: | :---: |
| **GPT-4.1** | 17 / **54** | 40.3 / **3,761** (`93.4×`) | 134s / **3,700s** (`27.6×`) | $0.12 / **$8.14** | **9.65%** | **$0.1507** / $0.0071 |
| **Gemini 3 Flash** | 19 / **48** | 39.4 / **9,811** (`248.8×`) | 114s / **4,173s** (`36.6×`) | $0.07 / **$6.71** | **2.88%** | **$0.1399** / $0.0036 |

<div class="two-col" style="margin-top: 8px;">
<div class="card teal small-text">

### ✅ 何時採用 PLANT 最具投資報酬率？
- 中大型、**高合規／高資安敏感**，或多利害關係人專案之初期啟動階段。
- 投入約 **1 小時與 US\$6.71–\$8.14**（每項隱性需求僅約 US\$0.14–\$0.15）即可多發掘 **2.5×–3.2× 隱性需求**，遠比後期返工或資安漏洞修復划算。

</div>
<div class="card accent small-text">

### ⚡ 何時單一代理人更合適？
- 快速原型開發（Rapid Prototyping）、簡單單人工具，或需要**一分鐘內即時回應**且預算極度受限的腦力激盪場景。

</div>
</div>

<!--
RQ3 成本效益、邊際報酬與實務導入邊界（Table 10）：
- 單一系統平均資源消耗（5 套 RQ1 系統平均）：
  - GPT-4.1：基線耗用 40.26k Token、134 秒、US$0.1206；PLANT 耗用 3,761.03k Token（93.4 倍）、3,700 秒（27.6 倍）、US$8.1368（67.5 倍），每增加 1M Token 帶來 9.65% IRE 增益；每項成功引出之隱性需求單位成本為 69.65k Token、68.51 秒、US$0.1507（基線為 2.37k、7.85 秒、US$0.0071）。
  - Gemini 3 Flash：基線耗用 39.43k Token、114 秒、US$0.0688；PLANT 耗用 9,810.93k Token（248.8 倍）、4,173 秒（36.6 倍）、US$6.7145（97.6 倍），每 1M Token 之 IRE 增益為 2.88%，單一隱性需求成本為 US$0.1399（204.39k Token、86.94 秒）。
- 跨模型效率對比：Gemini 3 Flash 總 API 費用略低（$6.71 vs. $8.14），但 GPT-4.1 的 Token 轉換效率顯著更優（376 萬 vs. 981 萬 Token；每百萬 Token 增益 9.65% vs. 2.88%）且命中總數更高（54 vs. 48 項）。
- 專案導入決策準則：需求開發屬專案初期或重大版本里程碑之低頻高價值活動，且遺漏 NFRs 與衝突為後期修復成本最高之缺陷。對中大型、合規敏感或多利害關係人系統而言，投入約 1 小時與 US$6.71 至 $8.14 換取 2.5 至 3.2 倍隱性需求覆蓋率極具經濟效益；反之，若為追求一分鐘內回饋的快速原型或簡易單人應用，單一代理人仍較具實用性。
-->

---

## 4.6 各元件貢獻分析與未來消融實驗規劃

雖受資源限制尚未進行全組合消融實驗，但從面向細分數據（Table 7）與對話軌跡可清楚推論各關鍵元件之貢獻：

<div class="two-col">
<div class="card small-text">

### 🧩 僅 Analyst + User vs. 加入 Expert 與 Modeler
- **單一基線**近似僅有 *Analyst + User*：主要命中表層*互動*與*內容*（GPT-4.1 佔 11/17），在*可靠度*、*效能*與*安全性*全數掛零（`0`）。
- 加入 **Expert** 後直接驅動*資安*（**9–10/12**）、*安全性*（**2–3/3**）與法規*相容性*之發現。
- 加入 **Modeler** 後透過 PlantUML 流程驗證，有效揭露*可靠度*（**2–5/7**）與狀態轉換邊界例外。

</div>
<div class="card accent small-text">

### 🧭 Mediator 與混合溝通模式之關鍵角色
- 若缺乏 **Mediator** 統整待解議題並動態切換溝通策略：
  - 全程僅用 *One-by-One* 發想易產生**早期錨定**與從眾效應。
  - 無調度的並行對話則容易重複提問、難以收斂僵局。
- 後續將於**固定輪數與固定 Token 預算**下進行四組受控消融實驗。

</div>
</div>

<!--
各元件預期貢獻剖析與受控消融規劃（第 4.3 節）：
- 結合面向細分數據（Table 7）與對話軌跡之歸因分析：
  - 僅 Analyst + User（單一基線近似）：僅能涵蓋表層互動與內容（GPT-4.1 佔 11/17、Gemini 佔 13/19），於可靠度、效能與安全性完全掛零。
  - Expert 貢獻：透過外部文件庫與 ISO 25010 稽核，直接驅動資安（9 至 10/12）、安全性（2 至 3/3）與法規相容性（6 至 7/10）之發掘，並提供個資留存衝突判定依據。
  - Modeler 貢獻：藉由 PlantUML 循序圖與使用案例圖驗證，系統性揭露可靠度需求（2 至 5/7）與狀態轉換邊界例外（如逾時轉派）。
  - Mediator 與混合溝通貢獻：依任務目標切換 Simultaneous-Talk 與 One-by-One，同時規避純循序發想的早期錨定偏誤，以及無調度並行對話之重複提問與僵局不收斂。
- 後續消融實驗設計：將於固定輪數與固定 Token 預算下執行四組受控消融（移除 Mediator、僅留 Analyst + User、移除 Expert／知識庫、全程僅用 One-by-One），精確拆解各元件之獨立貢獻。
-->

---

## 4.7 研究效度威脅（Threats to Validity）

<div class="three-col">
<div class="card small-text">

### 🔍 內部效度（Internal）
- **互動深度與預算**：PLANT 執行 13–17 輪（基線約 6 輪）並消耗較多 Token，成效反映「角色分工」與「互動深度」之綜合效果。
- **外部檢索變異**：雖本地文件庫固定（`temp = 0`），未來將快取即時網路搜尋結果以提升重現性。

</div>
<div class="card accent small-text">

### 🎯 構念效度（Construct）
- **模擬用戶與 LLM 裁判**：模擬用戶可能較真實客戶配合，單一裁判模型亦可能有偏好；後續將引入多裁判與真人受試者訪談。
- **召回導向與範疇**：IRE 不懲罰過度延伸問題（實務賴範疇過濾與 HITL 收斂）；下游 SRS 與 UML 品質尚未納入本次量化評分。

</div>
<div class="card teal small-text">

### 🌐 外部效度（External）
- **資料集規模**：本次涵蓋 5 大跨領域系統（金融、醫療、交通、教育、外送物流，共 103 IRs）與 100 組衝突配對。
- **更多基線比較**：未來將擴展至大型產業需求庫與更多多代理人基準系統。

</div>
</div>

<!--
研究效度威脅之嚴謹反思（第 4.3 節）：
- 內部效度（Internal Validity）：
  - 互動輪數與計算預算不對稱：PLANT 執行 13 至 17 輪（基線約 6 輪）且消耗 93.4 至 248.8 倍 Token，因此 IRE 提升反映「角色分工」與「互動深度」之綜合效應，而非純粹角色拆分之單獨貢獻。
  - 外部檢索時變性：雖已固定 temperature = 0 並使用靜態本地文件庫，但即時網路搜尋結果仍可能隨時間變動，未來將全面快取外部檢索快照以確保重現性。
- 構念效度（Construct Validity）：
  - 模擬用戶與單一 LLM 裁判：RQ1 遵循 ReqElicitGym [21] 與 G-Eval [23] 採模擬利害關係人（可能較真實客戶配合）與單一 GPT-5.2 裁判（可能具單模型評估偏好），後續須引入多裁判一致性檢驗與真人訪談。
  - 召回導向指標與下游產出評分：IRE 不懲罰過度延伸或無關提問（實務上仰賴範疇過濾與 HITL 收斂）；此外本次量化實驗聚焦於上游引出（RQ1）與衝突分類（RQ2），尚未針對下游產出之 SRS 品質、幻覺率與追溯準確度進行量化評分。
- 外部效度（External Validity）：
  - 資料集規模與基線廣度：雖已涵蓋金融、醫療、交通、教育與外送物流 5 大領域（103 項隱性需求、100 組衝突配對），仍須擴展至大型產業需求庫與任務適配之多代理人基線以強化外推性。
-->

---

## 5. 結論與未來研究方向

<div class="fig-box" style="padding: 8px 10px; margin-bottom: 8px;">
<img src="./img/diag4_rq_conclusions_zh.svg" alt="PLANT RQ1 至 RQ3 實證結論全景概念圖" style="max-height: 360px;">
</div>

<div class="future-strip">
<div class="future-pill"><strong>🧪 1. 固定預算消融實驗</strong><br>在對等 Token 與輪數預算下，與其他多代理人基線對比並拆解各元件獨立貢獻。</div>
<div class="future-pill"><strong>👩‍💻 2. 真人專家 SRS 評估</strong><br>邀請實務工程師量化評估產出之 UML 模型、事實依據與設計理由可追溯性。</div>
<div class="future-pill"><strong>⚙️ 3. 規格驅動開發（SDD）</strong><br>將 PLANT 可追溯的 IEEE 29148 SRS 銜接至下游自動化測試案例與程式碼生成 [24]。</div>
</div>

<!--
實證結論綜整與未來研究藍圖（第 5 節）：
- 三大研究問題核心結論：
  - RQ1：多角色分工結合外部知識引導，將隱性需求召回率提升 2.5 至 3.2 倍（GPT-4.1 達 54.28%、Gemini 3 Flash 達 46.79%），突破單一基線約 6 輪過早收斂並大幅強化 NFR 覆蓋。
  - RQ2：調解者引導之 One-by-One 審議將衝突召回率拉升至 95.55% 至 100.00%、總體 Macro F1 達 89.46% 至 96.66%，有效改善單一基線過於保守之漏報問題。
  - RQ3：多代理人協作雖耗用 93.4 至 248.8 倍 Token 與 27.6 至 36.6 倍執行時間（每系統 US$6.71 至 $8.14），但單一隱性需求成本僅約 US$0.14 至 $0.15，對高風險、重合規專案前期具備顯著投資報酬率。
- 後續三大推進方向：（1）於固定 Token 與輪數預算下執行受控消融實驗並與多代理人基線對照；（2）邀請軟體實務工程師量化評估產出 UML 模型、事實依據、幻覺率與設計理由可追溯性；（3）將 PLANT 產出之可追溯 IEEE 29148 SRS 銜接至規格驅動開發（SDD，Piskala [24]），驅動下游自動化測試案例與程式碼生成。
-->

---

<!-- _class: closing -->

# 感謝聆聽 · 敬請指教！

<p style="font-size: 1.02em; max-width: 840px;">
透過多代理人 AI 框架提升需求工程效率（PLANT）<br>
<span style="font-size: 0.82em; opacity: 0.85;">Enhancing Requirements Engineering Efficiency through a Multi-Agent AI Framework</span>
</p>

<div class="contact-card">
<strong>薛念林（Nien-Lin Hsueh）<sup>+</sup></strong> &nbsp;·&nbsp; <code>nlhsueh@fcu.edu.tw</code><br>
<strong>Shu-Hsien Liao</strong> &nbsp;·&nbsp; <code>m1325977@o365.fcu.edu.tw</code><br>
逢甲大學 資訊工程學系（Feng Chia University）<br>
公開系統文件與範例產出：<code>https://dummyjack.github.io/PLANT-Manual/</code><br>
<span style="font-size: 0.85em; opacity: 0.85;">國科會計畫補助：NSTC114-2221-E-035-077 · 歡迎提問與交流！</span>
</div>

<!--
論文出處、公開資源庫與計畫致謝：
- 論文資訊：Nien-Lin Hsueh 與 Shu-Hsien Liao，〈Enhancing Requirements Engineering Efficiency through a Multi-Agent AI Framework〉，《Journal of Information Science and Engineering (JISE)》，2026，逢甲大學資訊工程學系。
- 公開系統文件與可重現性資源：完整架構說明、各代理人原始提示模板（摘要見 Table 4）、IEEE 29148 SRS 範例、PlantUML 圖檔與設計理由紀錄皆公開於 https://dummyjack.github.io/PLANT-Manual/。
- 計畫致謝：本研究承蒙中華民國國家科學及技術委員會（NSTC）專題研究計畫補助，計畫編號 NSTC114-2221-E-035-077。
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
