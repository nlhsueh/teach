---
marp: true
theme: gaia
size: 16:9
paginate: true
html: true
header: '<div class="hdr-wrap"><span class="hdr-title">AI 助教三元模式：結構化程式設計教育中的對話式引導</span><div class="nav-dropdown"><button class="nav-btn">章節導覽 ▾</button><div class="nav-menu"><a href="#2">破題：直接給答案 vs. 三元引導</a><a href="#3">簡報大綱</a><a href="#4">1. 研究動機與問題</a><a href="#6">2. 文獻回顧與比較</a><a href="#7">3. SCT 與 AT-TPL 模式設計</a><a href="#13">4. 實證研究與分析</a><a href="#17">5. 討論與教學權衡</a><a href="#18">6. 結論與未來研究</a></div></div></div>'
footer: '薛念林（Nien-Lin Hsueh）、Lien-Chi Lai ＆ Ying-Chang Lu · 逢甲大學資訊工程學系 · JISE 2026'
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

h1 { color: var(--navy); font-size: 1.65em; font-weight: 800; line-height: 1.26; margin: 0 0 12px 0; }

h2 {
  color: var(--navy);
  font-size: 1.24em;
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

section.lead h1 { color: #ffffff; font-size: 1.9em; font-weight: 800; line-height: 1.28; margin-bottom: 10px; text-align: left; }
section.lead .en-title { color: #93c5fd; font-size: 0.86em; font-weight: 500; line-height: 1.4; margin-bottom: 16px; }
section.lead .subtitle { color: #cbd5e1; font-size: 0.93em; line-height: 1.5; margin-bottom: 24px; max-width: 960px; }

section.lead .meta-box {
  border-left: 4px solid #f43f5e;
  padding-left: 18px;
  color: #e2e8f0;
  font-size: 0.85em;
  line-height: 1.6;
}

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
  padding: 10px 15px;
  box-sizing: border-box;
}

.kpi-card.accent { border-left-color: var(--accent); background: var(--accent-soft); }
.kpi-card.teal { border-left-color: var(--teal); background: var(--teal-soft); }

.kpi-val { font-size: 1.38em; font-weight: 800; color: var(--navy); line-height: 1.15; margin-bottom: 3px; }
.kpi-card.accent .kpi-val { color: var(--accent); }
.kpi-card.teal .kpi-val { color: var(--teal); }
.kpi-label { font-size: 0.76em; color: var(--slate-700); line-height: 1.36; }

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
  line-height: 1.34;
}

tr:nth-child(even) td { background: #f8fafc; }

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

.small-text { font-size: 0.81em; }

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
.rq-q { font-size: 0.8em; color: var(--slate-700); line-height: 1.44; }

.bar-row {
  display: grid;
  grid-template-columns: 195px 1fr 90px;
  align-items: center;
  gap: 10px;
  margin-bottom: 8px;
  font-size: 0.79em;
}

.bar-track {
  background: var(--slate-100);
  border-radius: 5px;
  height: 19px;
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

<div class="badge">Journal of Information Science and Engineering (JISE) · 2026</div>

# AI 助教三元模式：結構化程式設計教育中的對話式引導

<div class="en-title">AI Tutor Triad Pattern: Structuring Conversational Guidance in Programming Education</div>

<div class="subtitle">
提出 <strong>AT-TPL（AI 助教三元模式語言）</strong>：將程式學習輔助解構為<strong>引導（Guidance）</strong>、<strong>除錯（Debugging）</strong>與<strong>最佳化（Optimization）</strong>三大專責模式，並透過 RACE 提示框架落實於 Smart Coding Tutor 線上評測系統
</div>

<div class="meta-box">
<strong>薛念林（Nien-Lin Hsueh）<sup>+</sup></strong>、<strong>Lien-Chi Lai</strong>、<strong>Ying-Chang Lu</strong><br>
逢甲大學資訊工程學系（Department of Information Engineering and Computer Science, Feng Chia University）<br>
<code>nlhsueh@fcu.edu.tw</code> · <code>p1000433@o365.fcu.edu.tw</code> · <code>m1305878@o365.fcu.edu.tw</code>
</div>

<div class="grant">
本研究獲國科會（NSTC）專題研究計畫補助：NSTC 114-2221-E-035-077
</div>

---

## 破題：「完整解答給你了！」⋯⋯等等，那學生學到了什麼？

<div class="fig-box" style="padding: 6px; margin-bottom: 10px; background: #fbf9f2;">
<img src="./img/pattern26_hook.jpg" alt="通用型 LLM 與 AT-TPL 三元助教模式對照" style="max-height: 415px; border-radius: 6px;">
</div>

<div class="callout" style="margin-top: 6px; padding: 9px 16px;">
<strong>核心洞見：</strong> 通用型 LLM 常直接傾倒可複製貼上的完整解答，架空學生的獨立思考。<strong>AT-TPL</strong> 以<strong>三位專責 AI 助教模式</strong>（<strong>Guidey</strong>、<strong>Debuggy</strong>、<strong>Opti</strong>）取代單一聊天機器人，精準配合程式設計各階段的學習需求。
</div>

---

## 簡報大綱

<div class="outline-grid">

<div class="outline-item">
<div class="outline-num">1</div>
<div class="outline-body">

[**研究動機與核心問題**](#4)
通用型 LLM 為何破壞教學鷹架，以及本研究的三項核心探究問題。

</div>
</div>

<div class="outline-item">
<div class="outline-num">2</div>
<div class="outline-body">

[**文獻回顧與系統比較**](#6)
比較 CodeHelp、CS50 工具、CodeAid、Iris 與 AT-TPL（表 1）。

</div>
</div>

<div class="outline-item">
<div class="outline-num">3</div>
<div class="outline-body">

[**SCT 系統與 AT-TPL 模式語言**](#7)
系統架構、共通設計張力、非線性切換、RACE 提示框架與三大模式詳解。

</div>
</div>

<div class="outline-item">
<div class="outline-num">4</div>
<div class="outline-body">

[**真實課堂實證研究**](#13)
315 位學生、86 道 Python 題目、1,315 次助教輔助嘗試之使用與成效分析。

</div>
</div>

<div class="outline-item">
<div class="outline-num">5</div>
<div class="outline-body">

[**討論與教學權衡**](#17)
具體協助 vs. 認知外包、狀態閘控 vs. 學習自主、以及程度差異效應。

</div>
</div>

<div class="outline-item">
<div class="outline-num">6</div>
<div class="outline-body">

[**結論與未來研究方向**](#18)
RQ1–RQ3 結論視覺化總結與三大未來研究藍圖。

</div>
</div>

</div>

---

## 1.1 研究動機：為何通用型 LLM 助教難以勝任程式教學？

<div class="fig-box" style="padding: 10px 12px; margin-bottom: 10px;">
<img src="./img/diag1_motivation_zh.svg" alt="通用型 LLM 與 AT-TPL 三元模式語言對比" style="max-height: 365px;">
</div>

<div class="callout">
<strong>教學理論基礎：</strong> 有效的 AI 輔助須符合<strong>鷹架理論（Scaffolding）</strong>[5]（協助前進但不取代學生工作）與<strong>有效失敗（Productive Failure）</strong>[6]（於初步嘗試後協助整理想法），因此必須明確規範 LLM 的回應邊界與時機。
</div>

---

## 1.2 研究目標與三大核心探究問題

在進行嚴格對照實驗驗證因果效果之前，本研究先釐清**學生在真實課堂尋求何種協助**以及**如何結構化 LLM 回應** *(逐步呈現)*：

<div class="rq-stage">

* <div class="rq-card teal"><img src="./img/rq1_pattern.svg" alt="RQ1 模式語言設計"><div><div class="rq-hook"><span class="rq-tag" style="background:#0f766e;">RQ1</span> 如何將零散提示詞轉化為可重用的教學模式語言？</div><div class="rq-q"><strong>如何將 LLM 程式輔助結構化為模式語言（AT-TPL）</strong>，明確規範教學意圖、共通張力、RACE 護欄與任務狀態切換？</div></div></div>
* <div class="rq-card accent"><img src="./img/rq2_usage.svg" alt="RQ2 課堂使用行為"><div><div class="rq-hook"><span class="rq-tag">RQ2</span> 學生在真實課程中實際會求助哪一類 AI 助教？</div><div class="rq-q">在 315 位學生的 Python 課程中，<strong>學生如何跨階段使用引導、除錯與最佳化三種模式</strong>？實際行為是否符合預期？</div></div></div>
* <div class="rq-card"><img src="./img/rq3_outcomes.svg" alt="RQ3 錯誤與成效"><div><div class="rq-hook"><span class="rq-tag" style="background:#1b365d;">RQ3</span> 哪些學生最常使用助教？遇困後能否成功解題？</div><div class="rq-q"><strong>AI 助教使用行為與學生的錯誤頻率、最終通過率（AC）之間有何關聯</strong>？與未使用助教的嘗試相比呈現何種特徵？</div></div></div>

</div>

---

## 2. 文獻回顧：AI 程式設計助教系統比較（表 1）

現有具教學護欄的 AI 助教多將「學習情境 ➔ 協助形式」隱含在特定工具介面中；**AT-TPL** 則將其形式化為可重用之設計模式語言。

| AI 助教系統 | 涵蓋之求助情境 | AI 輔助形式與護欄機制 |
| :--- | :--- | :--- |
| **CodeHelp** [17, 18] | 不知如何開始或不知如何除錯 *(單一表單未區分角色)* | 概念提示、根因分析與修正提示 *(以二次 LLM 過濾程式碼區塊)* |
| **CS50 tools** [21] | 開始解題、除錯或改善風格 *(分散於多個獨立工具)* | 提示、程式講解、除錯提示，以及 `style50` 語法格式建議 |
| **CodeAid** [19] | 不知如何開始或不知如何除錯 *(5 種功能模板自選)* | 概念說明、程式解釋、虛擬碼；根因分析與修正提示 |
| **Iris** [20] | 不知如何開始或不知如何除錯 *(單一對話角色)* | 最嚴格統一護欄：僅給微提示與反問 *(禁止虛擬碼與具體步驟)* |
| **AT-TPL（本研究）** | **開始規劃、錯誤診斷，以及通過後品質優化 *(三大模式)*** | **依狀態校準：提示/虛擬碼（`Guidey`）；根因提示（`Debuggy`）；慣用語法審查（`Opti`）** |

<div class="callout">
<strong>關鍵觀察：</strong> 提示詞限制屬於<em>設計意圖而非絕對保證</em>（例如 CS50 Duck 偶爾仍在除錯時洩漏完整修正碼 [22]），因此明確記錄張力、後果與後續防護機制至關重要。
</div>

---

## 3.1 Smart Coding Tutor（SCT）：整合 AI 助教之線上評測系統

<div class="split64">
<div class="left">

<div class="fig-box">
<img src="./img/fig1_sct_design.png" alt="Fig. 1: Smart Coding Tutor 系統架構" style="max-height: 395px;">
<div class="fig-cap">圖 1：Smart Coding Tutor（SCT）線上評測與 AI 助教整合架構</div>
</div>

</div>
<div class="right small-text">

### ⚙️ 互動式迭代開發迴圈
- 整合**作業模組**、**程式編輯器**、**自動評測器**、**隱藏測資評估器**與**專責 AI 助教**。
- 自動將脈絡資訊（`題目`、`程式碼`、`評測結果`、`錯誤訊息`）傳入對應助教模式。

### 📋 六種自動評測結果（Verdicts）
- **AC**（Accepted）：通過所有隱藏測資。
- **PA**（Partially Accepted）：僅通過部分測資。
- **RE**（Runtime Error）：執行期錯誤（如除以零、索引越界）。
- **WA**（Wrong Answer）：輸出結果錯誤。
- **TLE**（逾時） · **CE**（編譯錯誤）。

</div>
</div>

---

## 3.2 AT-TPL 模式語言：非線性狀態切換與三大共通張力

AT-TPL 並非三組互不相干的提示詞，而是由**學習任務狀態**驅動、且共同平衡**三大設計張力**的模式語言。

<div class="fig-box" style="padding: 8px 10px; margin-top: 4px;">
<img src="./img/diag2_attpl_transitions_zh.svg" alt="AT-TPL 非線性狀態切換與三大共通張力" style="max-height: 395px;">
</div>

---

## 3.3 以 RACE 框架落實模式規範（表 2）

我們採用 **RACE** [23] 框架實作提示詞，因 `Expectation` 能將教學護欄明確轉化為輸出規則：

| 模式 | **R**ole（角色與立場） | **A**ction（單一核心任務） | **C**ontext（學習者當下狀態） | **E**xpectation（輸出護欄） |
| :--- | :--- | :--- | :--- | :--- |
| **引導模式** (`Guidey`) | 鼓勵獨立思考的教學者 *(立場：不直接給答案)* | 僅提供提示與觀念說明 *(避免開放任務吐出全解)* | 題目需求與 I/O 規則；允許虛擬碼 *(尚無程式碼)* | **嚴禁可執行程式碼**；僅給提示；省略寒暄問候 |
| **除錯模式** (`Debuggy`) | 除錯專家兼教學者 *(專精解讀診斷訊息)* | 定位**單一根因**並提出**單一修正** *(避免失焦)* | 失敗程式碼與錯誤訊息 *(目標為解釋，而非引導)* | **兩段式輸出**（根因分析、修正提示）；不給完整碼 |
| **最佳化模式** (`Opti`) | 程式品質與效率教學者 *(正確後的檢視)* | 指出**最關鍵問題**與**一項策略** *(避免初學者負荷過重)* | 可正常運作之程式；以 Pythonic 慣用語法為基準 | **三段式輸出**（品質摘要、最佳實踐、替代提示）；**不完整重寫** |

<div class="callout teal">
<strong>跨領域可遷移性：</strong> 模式結構與鷹架立場可直接遷移至數學或語言教學；僅 <code>Context</code> 與 <code>Expectation</code> 中之程式專屬元素（I/O 規格、Traceback、AC 判決、Python 慣用語法）隨領域替換。
</div>

---

## 3.4 模式一：引導模式（Guidance Pattern · `Guidey`）

<div class="two-col">
<div class="card teal small-text">

### 🎯 意圖、情境與設計張力
- **意圖**：協助學生建構初步解題策略，同時將實作責任保留給學生。
- **情境**：學生剛讀完題目與 I/O 規範，但不知如何下筆 *(按鈕位於編輯器右上方)*。
- **平衡之張力**：
  - 及時具體協助 vs. 取代獨立推理
  - 多重題目限制 vs. 認知負荷過重
  - 虛擬碼澄清思路 vs. 可執行碼助長抄襲

### 🛠️ RACE 解法設計
- **小步幅鷹架**：重述需求、點出核心概念或建議下一子目標。
- **互動層漸進**：學生先嘗試實作提示，若仍卡關再請求下一條提示。
- **輸出護欄**：允許虛擬碼，**嚴禁提供可執行 Python 程式碼**與客套問候。

</div>
<div class="card accent small-text">

### ⚠️ 後果、風險與模式切換
- **優勢**：提供結構化起點，確保程式撰寫由學生主導。
- **權衡與風險**：
  - *即時滿足感較低*：部分學生覺得提示不如完整解答方便。
  - *連續索取提示*：學生可能未實作就連續點擊提示，變相將推理交給 AI。
  - *誤讀題意風險*：此時尚無程式輸出可驗證，若提示誤解題意恐誤導方向。
  - *程度差異* [4]：對程度佳者顯得冗長，對零基礎者虛擬碼仍可能過於抽象。
- **切換**：實作後出錯 ➔ **除錯模式**；完成可執行解 ➔ **最佳化模式**。

</div>
</div>

---

## 3.5 模式二：除錯模式（Debugging Pattern · `Debuggy`）

<div class="split55">
<div class="left">

<div class="fig-box">
<img src="./img/fig2a_guidey_debuggy.png" alt="圖 2a：SCT 中的 Guidey 與 Debuggy 介面" style="max-height: 390px;">
<div class="fig-cap">圖 2a：SCT 介面 — 編輯器右上角 <code>Guidey</code> 與錯誤輸出區下方 <code>Ask Debuggy</code></div>
</div>

</div>
<div class="right small-text">

### 🔍 明確示範診斷，修正交還學生
- **意圖**：協助學生定位具體失敗原因並進行精準修正。
- **RACE 解法**：強制引用 **Traceback 與出錯行號**，並輸出**兩大區塊**：
  1. *根因分析（Root Cause Analysis）*：簡明解釋為何出錯
  2. *修正提示（Correction Hint）*：具體修正方向或虛擬碼，**不給完整替代程式**

### ⚠️ 邊界情境與風險
- **WA 邊界限制**：邏輯錯誤（Wrong Answer）無 Traceback 可供參照，診斷依據較弱，增加不完整診斷風險 [14]。
- **診斷依賴**：初學者短期獲益最大，但也最容易依賴 AI 解讀錯誤訊息。
- **切換**：發現觀念缺口 ➔ **引導模式**；修正通過 ➔ **最佳化模式**。

</div>
</div>

---

## 3.6 模式三：最佳化模式（Optimization Pattern · `Opti`）

<div class="split55">
<div class="left">

<div class="fig-box">
<img src="./img/fig2b_opti.png" alt="圖 2b：SCT 中的 Opti 介面" style="max-height: 390px;">
<div class="fig-cap">圖 2b：SCT 歷史紀錄分頁 — 供通過測試後檢視程式品質的 <code>Ask Opti</code> 按鈕</div>
</div>

</div>
<div class="right small-text">

### ✨ 通過 AC 後的品質反思，不代為重寫
- **意圖**：在程式正確運作（`AC`）後，引導學生思考可讀性、效率與 Python 最佳實踐。
- **RACE 三段式輸出**：
  1. *程式品質摘要*（優點與改進空間）
  2. *具名最佳實踐建議*（如改用 List Comprehension）
  3. *非可執行替代提示*（**禁止完整改寫**）

### ⚠️ 實作限制與自願使用挑戰
- **部署版提示偏移**：實務部署時 Role/Action 偏重*效能瓶頸*，而 Context 偏重*可讀性*，論文已誠實記錄並於表 2 提出修正規範。
- **自願使用偏低**：通過 AC 後多數學生視為任務結束；且因未設狀態閘控，常在出錯時誤用。

</div>
</div>

---

## 4.1 實證研究：真實課程部署規模與使用分布

於 **2024 年秋季學期**部署於台灣某大學 Python 課程，涵蓋工程、商管與社會科學等多元背景學生：

<div class="three-col" style="margin-bottom: 12px;">
<div class="kpi-card teal">
<div class="kpi-val">315 位學生</div>
<div class="kpi-label">橫跨 <strong>86 道 Python 程式題</strong>之完整學期真實課堂</div>
</div>
<div class="kpi-card">
<div class="kpi-val">1,315 / 4,982</div>
<div class="kpi-label"><strong>26.4%</strong> 為 AI 助教輔助嘗試（73.6% 由學生獨立完成）</div>
</div>
<div class="kpi-card accent">
<div class="kpi-val">67.4% 併用多助教</div>
<div class="kpi-label">使用 AI 工具的學生中，近七成<strong>結合使用兩種以上模式</strong></div>
</div>
</div>

<div class="card small-text">

### 📊 1,315 次助教輔助嘗試中各模式使用占比 *(單次嘗試可併用多助教，總和 > 100%)*
<div style="margin-top: 10px;">
<div class="bar-row"><div><strong>引導模式（Guidey）</strong></div><div class="bar-track"><div class="bar-fill teal" style="width: 58.8%;"></div></div><div class="bar-pct">58.8% (773)</div></div>
<div class="bar-row"><div><strong>除錯模式（Debuggy）</strong></div><div class="bar-track"><div class="bar-fill accent" style="width: 47.7%;"></div></div><div class="bar-pct">47.7% (627)</div></div>
<div class="bar-row"><div><strong>最佳化模式（Opti）</strong></div><div class="bar-track"><div class="bar-fill" style="width: 30.6%;"></div></div><div class="bar-pct">30.6% (402)</div></div>
</div>

</div>

---

## 4.2 使用情境分析：預期設計 vs. 學生實際行為

觀察學生呼叫各模式的實際時機，呈現出「除錯符合預期」與「最佳化明顯錯位」的對照現象：

<div class="two-col">
<div class="card teal small-text">

### ✅ 除錯情境（符合設計預期）
- 所有嘗試中有 **37.5%**（`1,869 / 4,982`）在測試階段發生錯誤。
- 其中 **30.2%**（`564 / 1,869`）的出錯嘗試呼叫了 **Debuggy**。
- **Guidey（58.8%）** 高居首位且 **67.4%** 併用多助教，顯示學生確實依不同解題卡關階段切換求助模式。

</div>
<div class="card accent small-text">

### ⚠️ 最佳化情境（任務狀態錯位！）
- **原始設計意圖**：取得 `AC` 後用於反思程式可讀性與慣用語法。
- **實際觀察結果**：學生鮮少在 `AC` 後呼叫 `Opti`，反而多在失敗時使用：
  - **提交錯誤後使用**：**23.1%**（`373 / 1,614`）
  - **執行期錯誤後使用**：**24.4%**（`150 / 615`）
- **原因剖析**：SCT 未以任務狀態鎖定 `Opti` 按鈕，遇困學生將其視為一般求救管道；而通過 `AC` 後缺乏反思誘因。

</div>
</div>

<div class="callout">
<strong>教學設計啟示：</strong> 僅在概念上區分模式並不足夠——要促成通過測試後的程式碼品質學習，必須搭配<strong>任務狀態閘控（State-Based Gating）</strong>或<strong>明確課程活動誘因</strong>。
</div>

---

## 4.3 錯誤特徵與最終通過率分析（表 3 與 Debuggy 深度比較）

<div class="three-col" style="margin-bottom: 10px;">
<div class="kpi-card teal">
<div class="kpi-val">73.9% 通過率</div>
<div class="kpi-label"><strong>972 / 1,315</strong> 助教輔助嘗試最終達 AC（PA 12.6%、WA 3.3%、RE 2.7%）</div>
</div>
<div class="kpi-card accent">
<div class="kpi-val">錯誤高出 3.7–5.7 倍</div>
<div class="kpi-label">助教使用者的平均錯誤次數顯著較高，顯示主要用於<strong>解題遇困時</strong></div>
</div>
<div class="kpi-card">
<div class="kpi-val">76.1% vs. 76.7%</div>
<div class="kpi-label">Debuggy 群組通過率追平未使用者，儘管事前測試錯誤高達 <strong>7.2 vs. 1.0</strong></div>
</div>
</div>

<div class="split55">
<div class="left small-text">

### 📊 各階段平均錯誤次數比較（表 3）
| 錯誤發生階段 | 使用 AI 助教 | 未使用 AI 助教 | 倍數 |
| :--- | :---: | :---: | :---: |
| **測試階段錯誤** | **4.5** *(最高 99)* | 0.8 | **5.7×** |
| **提交階段錯誤** | **3.3** *(最高 68)* | 0.6 | **5.1×** |
| **執行期錯誤** | **0.7** *(最高 20)* | 0.2 | **3.7×** |

</div>
<div class="right card small-text">

### 🛡️ Debuggy 鷹架輔助訊號
- 在 **1,869** 次發生測試錯誤的嘗試中：
  - **使用 Debuggy**（`n = 564`）：**76.1% 通過 AC**（`429/564`），僅 **2.5%**（`14/564`）停留在 CE/RE 狀態——儘管事前平均錯誤高達 **7.2 倍**。
  - **未使用 Debuggy**：**76.7% 通過 AC**（事前僅 1.0 次錯誤）。
- 此結果*符合*鷹架輔助特徵，但因學生自主選擇使用，尚不構成因果證明。

</div>
</div>

---

## 4.4 課程層級背景與研究方法論誠實界定

<div class="two-col">
<div class="card teal small-text">

### 📈 歷屆課程背景變化
- 相較於往年同門 Python 課程：
  - **班級平均成績**：約 55 分 ➔ **約 75 分**
  - **課程停修／退選率**：近 10% ➔ **約 2%**
- **嚴謹界定**：歷屆學生群體、教學與評量方式亦有調整，故僅作為**部署脈絡參考**，*不將其歸因為 AI 助教之單一因果效果*。

</div>
<div class="card accent small-text">

### 🔬 觀察性研究範圍與限制
- **自選偏誤（Self-Selection）**：學生自由決定是否求助，故所有比較屬描述性實證紀錄。
- **護欄屬意圖非保證**：如 CS50 Duck 經驗 [22]，提示詞約束仍可能被突破，未來需結合事後過濾或稽核。
- **為何先觀察再對照？**：先掌握真實課堂中「學生究竟尋求何種幫助」，方能設計公平且具生態效度的對照實驗。

</div>
</div>

---

## 5. 討論：核心教學權衡與設計防護建議

三大模式反覆面臨同一項核心張力：**協助愈具體、愈能立即派上用場，就愈容易讓學生以 AI 推理取代自身思考**。

<div class="three-col">
<div class="card teal small-text">

### ⚖️ 1. 具體協助 vs. 自主思考
- AT-TPL 無法憑空消除過度依賴，但能**精準標示風險發生的節點**（如 `Guidey` 連續點提示、`Debuggy` 略過閱讀 Traceback）。
- 讓教師得以對症下藥：加入**提示次數上限**、**要求先解釋再給下一提示**與**漸進撤除鷹架**。

</div>
<div class="card accent small-text">

### 🚪 2. 狀態閘控 vs. 學習自主
- 未設狀態限制導致 `Opti` 在出錯後被誤用達 **23%–24%**。
- 導入**任務狀態閘控**（通過 AC 後才解鎖 `Opti`）可消除情境錯位，但代價是限縮學生自由選擇權，需依課程目標權衡。

</div>
<div class="card small-text">

### 🎓 3. 學習者程度差異效應
- **初學者**：短期從 `Debuggy` 獲益最多，但也最容易產生診斷依賴，或套用看不懂的 `Opti` 慣用語法。
- **進階學生**：可能覺得 `Guidey` 步調過慢，卻最能吸收 `Opti` 帶來的程式碼品質詞彙與重構思維。

</div>
</div>

---

## 6. 結論與未來研究方向

<div class="fig-box" style="padding: 8px 10px; margin-bottom: 8px;">
<img src="./img/diag3_conclusions_zh.svg" alt="AT-TPL RQ1-RQ3 結論視覺化總結" style="max-height: 360px;">
</div>

<div class="future-strip">
<div class="future-pill"><strong>🧪 1. 準實驗對照驗證</strong><br>與「單行角色指令（無護欄）」及「直接給全解助教」對照，量化模式護欄之實際學習增益。</div>
<div class="future-pill"><strong>🎛️ 2. 自適應鷹架與漸進撤除</strong><br>依學生程度與進度動態調整提示深度，逐步撤除提示並要求學生自我解釋修正理由。</div>
<div class="future-pill"><strong>🧩 3. 擴充模式語言家族</strong><br>於三元核心外新增反思模式、測資推理模式與程式碼閱讀模式，構築完整教學設計語言。</div>
</div>

---

<!-- _class: closing -->

# 感謝您的聆聽！

<p style="font-size: 1.05em; max-width: 860px;">
AI 助教三元模式：結構化程式設計教育中的對話式引導<br>
<span style="font-size: 0.85em; opacity: 0.88;">AI Tutor Triad Pattern: Structuring Conversational Guidance in Programming Education</span>
</p>

<div class="contact-card">
<strong>薛念林（Nien-Lin Hsueh）<sup>+</sup></strong> &nbsp;·&nbsp; <code>nlhsueh@fcu.edu.tw</code><br>
<strong>Lien-Chi Lai</strong> &nbsp;·&nbsp; <code>p1000433@o365.fcu.edu.tw</code> &nbsp;|&nbsp; <strong>Ying-Chang Lu</strong> &nbsp;·&nbsp; <code>m1305878@o365.fcu.edu.tw</code><br>
逢甲大學資訊工程學系（Feng Chia University）<br>
<span style="font-size: 0.85em; opacity: 0.88;">Journal of Information Science and Engineering (JISE), 2026 · 國科會計畫：NSTC 114-2221-E-035-077</span>
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
