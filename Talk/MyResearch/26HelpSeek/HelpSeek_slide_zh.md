---
marp: true
theme: gaia
size: 16:9
paginate: true
html: true
header: '<div class="hdr-wrap"><span class="hdr-title">LLM 輔助學習中的求助行為：補救路徑與後續程式編寫效率分析</span><div class="nav-dropdown"><button class="nav-btn">章節導覽 ▾</button><div class="nav-menu"><a href="#2">破題：78% 狂按重測？</a><a href="#3">簡報大綱</a><a href="#4">1. 研究動機與問題</a><a href="#6">2. 文獻回顧與定位</a><a href="#7">3. 系統架構與研究方法</a><a href="#10">4. 實證結果 (RQ1–RQ2)</a><a href="#15">5. 深度討論、RQ3 與限制</a><a href="#18">6. 結論與未來研究</a></div></div></div>'
footer: 'Lien-Chi Lai ＆ 薛念林（Nien-Lin Hsueh） · 逢甲大學資訊工程學系 · Electronics 2026, 15, 2706'
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
  min-width: 230px;
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
h1 { color: var(--navy); font-size: 1.7em; font-weight: 800; line-height: 1.24; margin: 0 0 12px 0; }

h2 {
  color: var(--navy);
  font-size: 1.24em;
  font-weight: 700;
  line-height: 1.26;
  margin: 0 0 12px 0;
  padding-bottom: 6px;
  border-bottom: 2.5px solid var(--navy);
  display: flex;
  align-items: center;
  gap: 8px;
}

h3 { color: var(--accent); font-size: 0.95em; font-weight: 700; margin: 4px 0 6px 0; }

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
section table th strong { color: #ffffff !important; }
section table th code { color: #ffffff !important; }
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
  font-size: 1.88em;
  font-weight: 900;
  line-height: 1.28;
  margin-bottom: 14px;
  text-align: left;
}

section.lead .subtitle {
  color: #cbd5e1;
  font-size: 0.92em;
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

section.lead .meta-box strong { color: #ffffff !important; }
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
.two-col { display: grid; grid-template-columns: 1fr 1fr; gap: 18px; align-items: stretch; }
.three-col { display: grid; grid-template-columns: repeat(3, 1fr); gap: 14px; align-items: stretch; }
.split64 { display: grid; grid-template-columns: 56% 42%; gap: 2%; align-items: center; }
.split55 { display: grid; grid-template-columns: 49% 49%; gap: 2%; align-items: center; }

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
  padding: 10px 14px;
  box-sizing: border-box;
}

.kpi-card.accent { border-left-color: var(--accent); background: var(--accent-soft); }
.kpi-card.teal { border-left-color: var(--teal); background: var(--teal-soft); }

.kpi-val { font-size: 1.34em; font-weight: 800; color: var(--navy); line-height: 1.18; margin-bottom: 3px; }
.kpi-card.accent .kpi-val { color: var(--accent); }
.kpi-card.teal .kpi-val { color: var(--teal); }
.kpi-label { font-size: 0.75em; color: var(--slate-700); line-height: 1.35; }

.callout {
  background: #f8fafc;
  border-left: 4px solid var(--accent);
  border-radius: 0 8px 8px 0;
  padding: 8px 14px;
  margin-top: 8px;
  font-size: 0.84em;
  color: var(--slate-700);
}

.callout strong { color: var(--navy); }

/* Tables */
table {
  width: 100%;
  border-collapse: collapse;
  font-size: 0.73em;
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
  padding: 5px 8px;
  border: 1px solid var(--slate-200);
  vertical-align: middle;
  line-height: 1.34;
}

tr:nth-child(even) td { background: #f8fafc; }

/* Formula Box */
.formula-strip {
  display: grid;
  grid-template-columns: 1.2fr 1.05fr;
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
  font-size: 0.88em;
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

.outline-body { font-size: 0.85em; line-height: 1.42; }
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

.split64 .left img:hover, .split55 .left img:hover, .two-col > div:first-child img:hover {
  transform: scale(1.22);
  transform-origin: left bottom;
  box-shadow: 0 12px 28px rgba(15, 23, 42, 0.22);
  position: relative;
  z-index: 30;
}

.split64 .right img:hover, .split55 .right img:hover, .two-col > div:last-child img:hover {
  transform: scale(1.22);
  transform-origin: right bottom;
  box-shadow: 0 12px 28px rgba(15, 23, 42, 0.22);
  position: relative;
  z-index: 30;
}

.fig-cap { font-size: 0.71em; color: var(--slate-500); margin-top: 5px; font-weight: 500; }

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
.rq-q { font-size: 0.8em; color: var(--slate-700); line-height: 1.44; }

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
</style>

<!-- _class: lead -->

<div class="badge">Electronics 2026, 15, 2706 · 資訊教育與 AI 輔助學習</div>

# LLM 輔助學習中的求助行為：補救行為路徑及其與後續程式編寫歷程效率之有限關聯

<div class="subtitle">
<strong>Help-Seeking in LLM-Assisted Learning</strong>：透過真實課堂 <strong>732 次補救學習歷程</strong>（366 位學生 · 43 份作業），剖析學生在精熟學習系統中的 AI 概念澄清行為與實證效益
</div>

<div class="meta-box">
<strong>Lien-Chi Lai<sup>*</sup></strong> ＆ <strong>薛念林（Nien-Lin Hsueh）</strong><br>
逢甲大學資訊工程學系（Department of Information Engineering and Computer Science, Feng Chia University）<br>
<code>p1000433@o365.fcu.edu.tw</code> · <code>nlhsueh@fcu.edu.tw</code>
</div>

<div class="grant">
刊登於 MDPI Electronics (2026 年 6 月 18 日) · DOI: 10.3390/electronics15122706 · 國科會計畫補助：NSTC114-2221-E-035-077
</div>

---

## 破題：我們打造了 24 小時 AI 助教，為何 78% 學生只顧著狂按「重測」？

<div class="fig-box" style="padding: 6px; margin-bottom: 10px; background: #fbf9f2;">
<img src="./img/helpseek_hook.jpg" alt="78% 純重測慣性 vs 22% 及早向 AI 求助" style="max-height: 410px; border-radius: 6px;">
</div>

<div class="callout" style="margin-top: 6px; padding: 9px 16px;">
<strong>驚人的課堂真相：</strong> 即使 AI 概念澄清功能就放在測驗旁邊，仍有 <strong>78.0% 的補救歷程完全忽略 AI</strong>、反覆狂按「重測」！反觀及早（第 1 輪）主動求助的學生，補救輪數減半，但後續寫程式的效率卻呈現出乎意料的「無顯著差異」。
</div>

---

## 簡報大綱（Presentation Outline）

<div class="outline-grid">

<div class="outline-item">
<div class="outline-num">1</div>
<div class="outline-body">

[**研究動機與三大問題**](#4)
為何「技術可用」不等於「有效求助」，以及本研究欲回答的 RQ1–RQ3。

</div>
</div>

<div class="outline-item">
<div class="outline-num">2</div>
<div class="outline-body">

[**文獻回顧與研究定位**](#6)
補救學習與自我調整學習（SRL）、LLM 程式教育與智慧家教求助研究。

</div>
</div>

<div class="outline-item">
<div class="outline-num">3</div>
<div class="outline-body">

[**系統架構與研究方法**](#7)
DialoguEDU 兩階段精熟門檻、介面成本不對稱、四大路徑分類與 MixedLM。

</div>
</div>

<div class="outline-item">
<div class="outline-num">4</div>
<div class="outline-body">

[**實證結果（RQ1 & RQ2）**](#10)
路徑分布、時機效應（δ = −0.912）、後續寫碼無顯著差異與雙重穩健性檢驗。

</div>
</div>

<div class="outline-item">
<div class="outline-num">5</div>
<div class="outline-body">

[**深度討論、RQ3 理論與限制**](#15)
78% 迴避求助三大成因、選擇性歷程支持機制與研究效度限制。

</div>
</div>

<div class="outline-item">
<div class="outline-num">6</div>
<div class="outline-body">

[**結論與未來研究方向**](#18)
RQ1–RQ3 核心視覺統整與主動提示式 AI 助教設計藍圖。

</div>
</div>

</div>

---

## 1.1 研究動機：技術可用性 ≠ 有效的求助行為

<div class="fig-box" style="padding: 10px 12px; margin-bottom: 10px;">
<img src="./img/diag1_access_vs_use_zh.svg" alt="常見假設與真實課堂實證對比" style="max-height: 355px;">
</div>

<div class="callout">
<strong>本研究填補的兩大缺口：</strong> (1) 現有 LLM 程式教育多聚焦於<em>程式碼生成／除錯</em>，極少探討<strong>概念評量補救中的澄清求助</strong>；(2) 相較於實驗室測試或問卷，真實課堂部署的<strong>完整歷程日誌分析</strong>仍十分稀缺。
</div>

---

## 1.2 研究目標與三大研究問題（RQ1–RQ3）

我們分析精熟學習程式課程中的真實互動日誌（`N = 732` 次補救歷程），依序探討三大核心問題 *(逐項展開)*：

<div class="rq-stage">

* <div class="rq-card teal"><img src="./img/rq1_pathways.svg" alt="RQ1 補救行為路徑"><div><div class="rq-hook"><span class="rq-tag" style="background:#0f766e;">RQ1 · 描述性</span> 學生進入補救分支後，實際上都怎麼跟 AI 互動？</div><div class="rq-q"><strong>呈現出哪些行為路徑？</strong> 澄清行為的發生率、首次時機、頻率與功能類型為何？不同路徑在補救輪數（<i>R</i>）與耗時上有何差異？</div></div></div>
* <div class="rq-card accent"><img src="./img/rq2_coding.svg" alt="RQ2 後續程式效率"><div><div class="rq-hook"><span class="rq-tag">RQ2 · 關聯性</span> 補救時問 AI，真的會讓接下來寫程式更順、更快嗎？</div><div class="rq-q"><strong>不同補救路徑是否與後續程式挑戰效率相關</strong>（活躍時間與程式碼快照數）？在控制學生個體差異與作業難度後是否依然成立？</div></div></div>
* <div class="rq-card"><img src="./img/rq3_theory.svg" alt="RQ3 理論整合"><div><div class="rq-hook"><span class="rq-tag" style="background:#1b365d;">RQ3 · 理論整合</span> LLM 概念澄清在精熟學習中究竟扮演什麼理論角色？</div><div class="rq-q"><strong>整合 RQ1 與 RQ2 發現</strong>，應如何界定其運作機制、邊界條件，並轉化為具體的 AI 教學系統設計建議？</div></div></div>

</div>

---

## 2. 文獻回顧與本研究定位

| 研究脈絡 | 代表性既有發現 | 尚未解決的關鍵缺口 |
| :--- | :--- | :--- |
| **補救學習與 SRL** [5, 10, 11] | 有效學習者會監控錯誤並調整策略；但在允許重考的系統中常陷入**重測慣性**；及時回饋有助阻止迷思延續。 | 觀察資料中難以區分「及時回饋效益」與「學生先備能力」差異。 |
| **LLM 程式教育** [1, 2, 12, 13] | 初學者對 LLM 使用高度分歧 [1]；Koedinger 等人指出單位練習機會的學習速率在不同教學條件下高度一致 [13]。 | 多集中於程式碼生成與除錯，缺乏概念評量補救與後續寫碼之連結。 |
| **ITS / AI 求助行為** [3–7, 16] | 適應性求助是 SRL 核心，但學生常出現**求助迴避**或鑽漏洞 [5]；回饋時機與類型比總量更關鍵 [16]。 | 多採小規模質性訪談、問卷或控制實驗，缺乏長期自然課堂日誌 [6, 7]。 |
| **本研究（DialoguEDU）** | **732 次真實補救歷程**（366 位學生、43 份作業），完整串聯選擇題重測、AI 對話與程式編寫快照。 | **直接銜接「補救求助路徑」與「後續程式歷程效率」的實證驗證。** |

<div class="callout">
<strong>為何精熟門檻設計極具研究價值？</strong> 學生必須先通過 80% 概念選擇題才能解鎖程式題，讓「答錯 ➔ 求助或重測 ➔ 寫程式」的完整歷程在自然課堂中完全可視化。
</div>

---

## 3.1 精熟學習系統架構（DialoguEDU）

<div class="split55">
<div class="left">

<div class="fig-box">
<img src="./img/fig1_workflow.png" alt="圖 1：DialoguEDU 兩階段精熟學習流程" style="max-height: 430px;">
<div class="fig-cap">圖 1：兩階段精熟門檻工作流程與補救分支（Student Workflow）</div>
</div>

</div>
<div class="right small-text">

### 🏗️ 兩階段精熟門檻設計 [8]
- **第一階段（概念選擇題 MCQ）**：由 **Gemini 2.5 Flash**（`temp = 0.7`，直接以教師 PDF 教材為上下文，無額外 RAG）動態出題。
- **80% 精熟門檻**：未達標即進入**補救分支**，系統將錯題注入提示詞，進行**錯誤感知式（Error-Aware）重出題**，精準鎖定迷思。
- **LLM 澄清介面**：補救期間隨時可提問，系統提示詞約束 AI 僅解釋概念、**不直接給答案**。
- **第二階段（個人化程式挑戰）**：達標後依據學生完整作答與迷思紀錄客製程式題，採 LLM 初評 + 助教人工複核。

</div>
</div>

---

## 3.2 學生互動介面與「操作成本不對稱」

<div class="two-col">
<div>
<div class="fig-box">
<img src="./img/fig2a_mcq_ui.png" alt="圖 2a：MCQ 評量介面" style="max-height: 315px;">
<div class="fig-cap">圖 2a：MCQ 概念評量介面（顯示 80% 門檻與錯題標記）</div>
</div>
</div>
<div>
<div class="fig-box">
<img src="./img/fig2b_llm_ui.png" alt="圖 2b：LLM 澄清助手介面" style="max-height: 315px;">
<div class="fig-cap">圖 2b：LLM 澄清介面（預設快捷按鈕 + 自由文字輸入框）</div>
</div>
</div>
</div>

<div class="callout" style="margin-top: 10px;">
<strong>關鍵介面洞察 — 操作成本不對稱（Interaction Cost Asymmetry）：</strong> 按一下「重測」或預設按鈕（如<em>「解釋這個概念」</em>、<em>「為何我答錯？」</em>）的認知阻力遠低於自行組織文字提問，無形中助長了被動重測慣性。
</div>

---

## 3.3 資料集、四大行為路徑與統計分析流程

<div class="fig-box" style="padding: 8px 10px; margin-bottom: 8px;">
<img src="./img/diag2_method_pipeline_zh.svg" alt="研究資料與統計分析流程" style="max-height: 245px;">
</div>

<div class="formula-strip">
<div class="formula-box">
<i>Cliff's δ</i> &nbsp;=&nbsp;
<span class="frac"><span class="frac-num">#(<i>x<sub>i</sub></i> &gt; <i>y<sub>j</sub></i>) − #(<i>x<sub>i</sub></i> &lt; <i>y<sub>j</sub></i>)</span><span class="frac-den"><i>n<sub>x</sub></i> × <i>n<sub>y</sub></i></span></span>
<span style="font-family: 'Noto Sans TC', sans-serif; font-size: 0.72em; color: #64748b; margin-left: 10px;">(10,000 次 Bootstrap 95% CI)</span>
</div>
<div class="formula-box" style="font-family: 'Noto Sans TC', sans-serif; font-size: 0.74em; flex-direction: column; align-items: flex-start; gap: 3px;">
<div><strong>Romano [17] |δ| 標準：</strong> &lt;0.147 可忽略 · &lt;0.33 小 · &lt;0.474 中 · ≥0.474 大</div>
<div><strong>線性混合效應模型：</strong> <code>log(Y) ~ pathway + assignment_id + (1 | student_id)</code></div>
</div>
</div>

<div class="callout" style="margin-top: 8px; padding: 7px 14px;">
<strong>互斥完備分類：</strong> 所有進入補救的歷程（<code>set_number &gt; 1</code>，<code>N = 732</code>）依<strong>「頻率優先、時機次之」</strong>全數歸類（0 筆排除）；RQ2 納入有實際寫碼紀錄之 <code>N = 716</code> 筆（排除閒置 &gt; 30 分鐘間隔）。
</div>

---

## 4.1 RQ1 實證結果：路徑分布、求助時機與功能類型

<div class="three-col" style="margin-bottom: 8px;">
<div class="kpi-card accent">
<div class="kpi-val">78.0% (571/732)</div>
<div class="kpi-label"><strong>純重測路徑</strong> — 僅 22.0%（161 次）曾使用 AI 澄清功能</div>
</div>
<div class="kpi-card teal">
<div class="kpi-val">86.3% (139/161)</div>
<div class="kpi-label"><strong>集中於第 1 輪</strong> — 是否求助幾乎在首錯後立即決定（中位數 1.0）</div>
</div>
<div class="kpi-card">
<div class="kpi-val">84.7% (216/255)</div>
<div class="kpi-label"><strong>概念型提問</strong> — 遠高於系統型（11.0%）與流程型（4.3%）</div>
</div>
</div>

<div class="split55">
<div class="left">
<div class="fig-box">
<img src="./img/fig3_pathways.png" alt="圖 3：補救行為路徑分布" style="max-height: 270px;">
<div class="fig-cap">圖 3：四大互斥行為路徑分布（N = 732）</div>
</div>
</div>
<div class="right">
<div class="fig-box">
<img src="./img/fig4_clarif_chars.png" alt="圖 4：首次澄清輪次與功能類型分布" style="max-height: 270px;">
<div class="fig-cap">圖 4：(a) 首次澄清輪次分布；(b) 255 則訊息功能類型分布</div>
</div>
</div>
</div>

---

## 4.2 RQ1 實證結果：補救輪數與 Cliff's δ 效果量分析

<div class="split55" style="margin-bottom: 4px;">
<div class="left">
<div class="fig-box" style="padding: 5px;">
<img src="./img/fig5_rounds_violin.png" alt="圖 5：各路徑補救輪數小提琴箱型圖" style="max-height: 192px;">
<div class="fig-cap">圖 5：補救輪數 (R) — 單次即時中位數 2.0 vs. 單次延遲 4.0</div>
</div>
</div>
<div class="right">
<div class="fig-box" style="padding: 5px;">
<img src="./img/fig6_rq1_forest.png" alt="圖 6：RQ1 Cliff's delta 森林圖" style="max-height: 192px;">
<div class="fig-cap">圖 6：RQ1 成對比較之 Cliff's δ 與 95% Bootstrap 信賴區間</div>
</div>
</div>
</div>

| RQ1 成對比較（Table 4） | 指標 | n<sub>1</sub> / n<sub>2</sub> | 中位數 Mdn<sub>1</sub> vs. Mdn<sub>2</sub> | Cliff's δ | 95% 信賴區間 | 效果量 |
| :--- | :--- | :---: | :---: | :---: | :---: | :---: |
| 有澄清 vs. 純重測 | 輪數 / 總耗時 | 161 / 571 | 2.0 vs. 2.0 / 812s vs. 616s | +0.073 / +0.193 | [−0.014, 0.160] / [0.086, 0.299] | 可忽略 / 小 |
| 多次澄清 vs. 單次澄清 | 輪數 / 總耗時 | 50 / 111 | 2.5 vs. 2.0 / 1119s vs. 637s | +0.231 / +0.432 | [0.060, 0.401] / [0.246, 0.603] | 小 / 中 |
| **單次即時 vs. 單次延遲** | **輪數 (<i>R</i>)** | **97 / 14** | **2.0 vs. 4.0** | **−0.912** | **[−0.971, −0.835]** | **大效果量** |

<div class="callout" style="margin-top: 5px; padding: 6px 14px; font-size: 0.8em;">
<strong>嚴謹解讀提醒：</strong> <code>δ = −0.912</code> 具<em>部分定義性重疊</em>（單次延遲依定義必發生於第 2 輪後）且樣本數小（<code>n = 14</code>），故應視為描述性特徵，不可過度推論為因果關係。
</div>

---

## 4.3 RQ2 實證結果：通過率天花板與原始寫碼效率

<div class="three-col" style="margin-bottom: 8px;">
<div class="kpi-card teal">
<div class="kpi-val">99.6% (729/732)</div>
<div class="kpi-label">順利通過精熟門檻並進入後續程式挑戰</div>
</div>
<div class="kpi-card accent">
<div class="kpi-val">97.3% 通過率</div>
<div class="kpi-label">顯著<strong>天花板效應</strong>（各路徑均達 96.8%–100%）</div>
</div>
<div class="kpi-card">
<div class="kpi-val">|δ| = 0.002 – 0.127</div>
<div class="kpi-label">活躍時間與快照數之原始效果量<strong>全數可忽略</strong></div>
</div>
</div>

<div class="split55">
<div class="left">
<div class="fig-box">
<img src="./img/fig7_rq2_coding.png" alt="圖 7：各路徑後續程式挑戰效率（對數尺度）" style="max-height: 270px;">
<div class="fig-cap">圖 7：各路徑活躍時間與程式碼快照數分布（對數尺度，N = 716）</div>
</div>
</div>
<div class="right small-text">

### 📊 原始歷程效率統計（Tables 5 & 6）
| 行為路徑 (<i>N</i>) | 活躍時間中位數 (IQR) | 快照數中位數 | 活躍時間 δ (vs. 純重測) |
| :--- | :---: | :---: | :---: |
| **純重測** (559) | 17.3 分 [6.9, 33.5] | 26.0 | 基準組 |
| **單次即時** (96) | 22.1 分 [10.6, 37.6] | 33.5 | +0.118 *(可忽略)* |
| **單次延遲** (13) | 15.1 分 [9.2, 33.9] | 29.0 | +0.034 *(可忽略)* |
| **多次澄清** (48) | 22.1 分 [9.7, 38.6] | 30.5 | +0.127 *(可忽略)* |

- 所有 95% 信賴區間均跨越 0；程式碼快照數 `|δ| ≤ 0.083`。

</div>
</div>

---

## 4.4 RQ2 實證結果：線性混合效應模型（控制混淆變項）

<div class="split55">
<div class="left">
<div class="fig-box">
<img src="./img/fig8_rq2_mixedlm.png" alt="圖 8：MixedLM 係數森林圖" style="max-height: 350px;">
<div class="fig-cap">圖 8：線性混合效應模型迴歸係數（對數尺度）與 95% CI</div>
</div>
</div>
<div class="right small-text">

### 📉 MixedLM 分析結果（Table 7 · N = 716，355 位學生）
控制**學生隨機截距**與**43 份作業難度固定效應**後：

| 結果指標 | 路徑（相對於純重測） | 係數 Coef. | 95% CI | <i>p</i> 值 |
| :--- | :--- | :---: | :---: | :---: |
| `log(活躍時間)` | 單次即時澄清 | +0.218 | [−0.034, 0.471] | 0.090 *(ns)* |
| `log(活躍時間)` | 單次延遲澄清 | −0.051 | [−0.667, 0.566] | 0.872 *(ns)* |
| `log(活躍時間)` | 多次澄清 | +0.108 | [−0.242, 0.458] | 0.546 *(ns)* |
| `log(快照數)` | 單次即時澄清 | +0.079 | [−0.148, 0.305] | 0.498 *(ns)* |
| `log(快照數)` | 單次延遲澄清 | −0.157 | [−0.692, 0.379] | 0.567 *(ns)* |
| `log(快照數)` | 多次澄清 | +0.002 | [−0.312, 0.316] | 0.989 *(ns)* |

</div>
</div>

<div class="callout" style="margin-top: 8px;">
<strong>穩健的無顯著發現（Null Result）：</strong> 所有路徑皆未達統計顯著（<code>p &gt; 0.05</code>），最接近顯著的單次即時（+0.218，約多花 24% 時間）方向亦非「加速寫碼」；單次延遲組（<code>n = 13</code>）檢定力不足，屬尚未定論。
</div>

---

## 4.5 穩健性檢驗：程式碼變異分群與閒置閾值敏感度

為確認是否受外部 AI 貼上程式碼或 30 分鐘閒置門檻干擾，本研究進行兩項敏感度測試（Section 4.2.4, Table 8）：

| 變異分群（條件：單次長度縮減 >50% 且相似度 <50%） | 路徑（vs. 純重測） | n<sub>clar</sub> / n<sub>PR</sub> | 活躍時間 δ [95% CI] | 快照數 δ [95% CI] |
| :--- | :--- | :---: | :---: | :---: |
| **穩定編寫組（`n = 531`, 72.8%）** | 即時 / 延遲 / 多次 | 69 / 6 / 34 vs. 410 | +0.107 / −0.135 / +0.071 *(全跨 0)* | +0.060 / −0.102 / +0.022 *(全跨 0)* |
| **高變異組（`n = 198`, 27.2%）** | 即時 / 延遲 / 多次 | 27 / 7 / 14 vs. 149 | **+0.148 / +0.173 / +0.258** *(小、跨 0)* | +0.145 / +0.120 / +0.082 *(全跨 0)* |

<div class="two-col" style="margin-top: 8px;">
<div class="card teal small-text">

### 🔍 94,249 組連續快照變動稽核
- **82.8%** 的連續修改幅度小於 **5%**；僅 **8.1%** 超過 20%。
- 證實學生以**漸進式自主除錯**為主，非整段貼上外部 AI 解答，確保穩定組的無顯著結論反映真實學習情境。

</div>
<div class="card accent small-text">

### ⏱️ 閒置門檻敏感度（15 / 30 / 60 分鐘）
- 改以 **15 分鐘（`N = 715`）** 與 **60 分鐘（`N = 717`）** 重估 MixedLM，結論完全一致。
- 單次即時 `log(活躍時間)` 係數分別為 `0.168 / 0.218 / 0.158`（全數 `p > 0.09`），其餘路徑皆 `p > 0.31`。

</div>
</div>

---

## 5.1 深度討論：為何 78% 迴避求助？為何 RQ2 無顯著差異？

<div class="two-col">
<div class="card accent small-text">

### 🚫 78.0% 迴避求助的三大機制（RQ1）
1. **知識錯覺與過度自信** [15]：首次答錯後低估概念漏洞，以為再重考一次就能過關。
2. **失敗當下的認知負荷**：剛答錯時認知資源最緊繃，自行組織精準提問的後設認知門檻過高。
3. **介面誘發之重測慣性**：按「重測」的操作成本遠低於打字提問，形成阻力最小路徑。

- 此外，**多次澄清組**耗時顯著更長（`1119s` vs. `637s`，`δ = 0.432`），反映更深層的概念困惑與多輪鷹架需求。

</div>
<div class="card teal small-text">

### 🧩 RQ2 無顯著差異的五大詮釋
1. **精熟門檻的起點均等效應**：不論走哪條路徑，皆須達到 **80% 門檻**才解鎖寫碼，大幅抹平了進入程式題時的先備落差！
2. **高通過率天花板壓縮**：**97.3%** 的過關率壓縮了效率指標的變異空間。
3. **觀察視窗過窄**：僅追蹤緊接在後的單一程式題，未捕捉跨作業延遲遷移。
4. **個體認知處理異質性**：不同學生吸收相同 AI 回覆的深度差異大，稀釋群體均值。
5. **學習速率高度規律性** [13]：單位練習機會的學習增益對教學條件變異具高度穩健性。

</div>
</div>

---

## 5.2 RQ3 理論定位：選擇性歷程支持機制與系統設計啟示

<div class="fig-box" style="padding: 8px 10px; margin-bottom: 8px;">
<img src="./img/diag3_selective_support_zh.svg" alt="選擇性歷程支持機制理論架構圖" style="max-height: 335px;">
</div>

<div class="callout" style="margin-top: 6px; padding: 9px 15px;">
<strong>具體教學系統設計建議（系統主動觸發提示）：</strong> 別被動等焦慮的初學者自己提問！應在<strong>第 1 輪補救</strong>或<strong>連續失敗 2 次後</strong>自動彈出提示（例如：<em>「您已連續未達標兩次，是否請 AI 協助釐清這個核心概念？」</em>），大幅降低求助認知門檻。
</div>

---

## 5.3 研究限制與效度威脅（Limitations）

<div class="three-col">
<div class="card accent small-text">

### ⚖️ 因果推論與樣本不均
- **缺乏先備能力前測**：觀察性研究無法排除自我選擇偏誤（SRL 較強的學生可能更早問也更快過關）。
- **樣本高度不平衡**：純重測（`n = 571`）vs. 單次延遲（`n = 14`），延遲組檢定力受限。
- **定義性重疊**：`δ = −0.912` 部分源自延遲組必發生於第 2 輪後。

</div>
<div class="card small-text">

### 📏 指標效度與動態軌跡
- **代理指標生態效度**：97.3% 天花板迫使改用活躍時間與快照數，但花更多時間亦可能代表*深度探索*而非低效。
- **單次作業視窗**：無法評估多週後的長期知識遷移。
- **尚未建模個體演變**：將同一學生的多次歷程視為獨立事件，未追蹤整學期求助習慣的變化。

</div>
<div class="card teal small-text">

### 🤖 編碼方式與外部效度
- **規則式自動編碼**：具高度可重現性，但無人工評分者信度；預設歸入*概念型*（84.7%）可能略為高估。
- **未評估 AI 回覆品質**：LLM 解釋的正確性與教學適切性尚未納入調節變項。
- **單一情境限制**：單一大學非資工大一課程與單一模型（**Gemini 2.5 Flash**）。

</div>
</div>

---

## 6. 結論與未來研究方向

<div class="fig-box" style="padding: 8px 10px; margin-bottom: 8px;">
<img src="./img/diag4_rq_conclusions_zh.svg" alt="RQ1-RQ3 結論視覺化統整圖" style="max-height: 350px;">
</div>

<div class="future-strip">
<div class="future-pill"><strong>🧪 1. 隨機分派介入實驗</strong><br>比較「系統主動提示」與「學生自主求助」並納入前測控制，驗證因果效應。</div>
<div class="future-pill"><strong>📈 2. 跨學期縱貫軌跡</strong><br>追蹤多次作業間的延遲遷移效應，並建模學生個體求助策略隨經驗的演變。</div>
<div class="future-pill"><strong>🌐 3. 跨校複現與回覆品質稽核</strong><br>拓展至多校、多款 LLM，並結合人工抽樣驗證 AI 解釋品質與功能編碼效度。</div>
</div>

---

<!-- _class: closing -->

# 感謝聆聽！敬請指教

<p style="font-size: 1.02em; max-width: 880px;">
LLM 輔助學習中的求助行為：補救行為路徑及其與後續程式編寫歷程效率之有限關聯
</p>

<div class="contact-card">
<strong>Lien-Chi Lai<sup>*</sup></strong> &nbsp;·&nbsp; <code>p1000433@o365.fcu.edu.tw</code><br>
<strong>薛念林（Nien-Lin Hsueh）</strong> &nbsp;·&nbsp; <code>nlhsueh@fcu.edu.tw</code><br>
逢甲大學資訊工程學系（Department of Information Engineering and Computer Science, FCU）<br>
刊登期刊：<strong>Electronics 2026, 15, 2706</strong> &nbsp;·&nbsp; <code>https://doi.org/10.3390/electronics15122706</code><br>
<span style="font-size: 0.85em; opacity: 0.85;">國科會計畫補助：NSTC114-2221-E-035-077 · 歡迎交流與提問！</span>
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
