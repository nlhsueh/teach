---
marp: true
theme: gaia
size: 16:9
paginate: true
html: true
header: '<div class="hdr-wrap"><span class="hdr-title">結合 UML 與軟體模擬於流程定義、驗證與確認之研究</span><div class="hdr-actions"><a class="lang-btn" href="./UMLProcess_slide.html" title="Switch to English Slides">🌐 EN</a><div class="nav-dropdown"><button class="nav-btn">章節導覽 ▾</button><div class="nav-menu"><a href="#2">簡報大綱</a><a href="#3">1. 研究動機與實務挑戰</a><a href="#4">2. 整體方法架構</a><a href="#5">3. 流程定義（PMP 擴充）</a><a href="#8">4. OCL 自動化驗證</a><a href="#10">5. SimSE 模擬確認</a><a href="#12">6. 逢甲資處案例與問卷</a><a href="#14">7. 討論、限制與結論</a></div></div></div></div>'
footer: '薛念林（Nien-Lin Hsueh）、沈文祥、楊志偉、楊東麟 · 逢甲大學資訊工程學系 · IST 2008'
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
  font-size: 19.5px;
  line-height: 1.5;
  padding: 68px 54px 48px 54px;
  box-sizing: border-box;
  letter-spacing: 0.01em !important;
}

header {
  position: absolute;
  top: 0; left: 0; right: 0;
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
.hdr-actions { display: inline-flex; align-items: center; gap: 8px; }
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
.lang-btn:hover { background: rgba(255, 255, 255, 0.26); }

.nav-dropdown { position: relative; display: inline-block; padding-bottom: 6px; margin-bottom: -6px; }
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
  right: 0; top: 100%;
  min-width: 235px;
  background: #ffffff;
  border: 1px solid var(--slate-200);
  border-radius: 8px;
  box-shadow: 0 10px 24px rgba(15, 23, 42, 0.18);
  padding: 6px 0;
  z-index: 200;
}
.nav-dropdown:hover .nav-menu, .nav-dropdown.open .nav-menu { display: block; }
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
  left: 54px; bottom: 14px;
  font-size: 12.5px;
  color: var(--slate-500);
  font-weight: 500;
}
section::after {
  position: absolute;
  right: 54px; bottom: 14px;
  font-size: 12.5px;
  font-weight: 700;
  color: var(--navy);
  content: attr(data-marpit-pagination) ' / ' attr(data-marpit-pagination-total);
}

h1, h2, h3 { letter-spacing: 0 !important; }
h1 { color: var(--navy); font-size: 1.65em; font-weight: 800; line-height: 1.26; margin: 0 0 12px 0; }
h2 {
  color: var(--navy);
  font-size: 1.22em;
  font-weight: 700;
  line-height: 1.28;
  margin: 0 0 13px 0;
  padding-bottom: 6px;
  border-bottom: 2.5px solid var(--navy);
  display: flex;
  align-items: center;
  gap: 8px;
}
h3 { color: var(--accent); font-size: 0.95em; font-weight: 700; margin: 4px 0 6px 0; }
p { margin: 0 0 8px 0; }
ul, ol { margin: 4px 0 8px 0; padding-left: 22px; }
li { margin-bottom: 5px; line-height: 1.45; }
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
section.lead h1 { color: #ffffff; font-size: 1.88em; font-weight: 800; line-height: 1.28; margin-bottom: 10px; text-align: left; }
section.lead .en-title { color: #93c5fd; font-size: 0.85em; font-weight: 500; line-height: 1.4; margin-bottom: 16px; }
section.lead .subtitle { color: #cbd5e1; font-size: 0.92em; line-height: 1.5; margin-bottom: 22px; max-width: 960px; }
section.lead .meta-box { border-left: 4px solid #f43f5e; padding-left: 18px; color: #e2e8f0; font-size: 0.84em; line-height: 1.6; }
section.lead .grant { margin-top: 18px; font-size: 0.72em; color: #94a3b8; }

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
section.closing h1 { color: #ffffff; font-size: 2.15em; margin-bottom: 12px; }
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
.split46 { display: grid; grid-template-columns: 42% 56%; gap: 2%; align-items: center; }

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
.kpi-val { font-size: 1.35em; font-weight: 800; color: var(--navy); line-height: 1.15; margin-bottom: 3px; }
.kpi-card.accent .kpi-val { color: var(--accent); }
.kpi-card.teal .kpi-val { color: var(--teal); }
.kpi-label { font-size: 0.76em; color: var(--slate-700); line-height: 1.36; }

.callout {
  background: #f8fafc;
  border-left: 4px solid var(--accent);
  border-radius: 0 8px 8px 0;
  padding: 10px 16px;
  margin-top: 12px;
  font-size: 0.84em;
  color: var(--slate-700);
  line-height: 1.5;
}
.callout.teal { border-left-color: var(--teal); background: var(--teal-soft); }
.callout strong { color: var(--navy); }

table {
  width: 100%;
  border-collapse: collapse;
  font-size: 0.72em;
  margin: 8px 0;
  background: #ffffff;
  border: 1px solid var(--slate-200);
}
th {
  background: var(--navy);
  color: #ffffff;
  font-weight: 700;
  padding: 6px 9px;
  text-align: left;
  border: 1px solid var(--navy);
}
td {
  padding: 5px 9px;
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
  padding: 11px 15px;
}
.outline-num {
  background: var(--navy);
  color: #ffffff;
  font-weight: 800;
  font-size: 0.85em;
  width: 28px; height: 28px;
  border-radius: 6px;
  display: flex; align-items: center; justify-content: center;
  flex-shrink: 0;
  margin-top: 2px;
}
.outline-body { font-size: 0.84em; line-height: 1.4; }
.outline-body a { color: var(--navy); font-weight: 700; font-size: 1.05em; }

.fig-box {
  background: #ffffff;
  border: 1px solid var(--slate-200);
  border-radius: 8px;
  padding: 8px;
  text-align: center;
  box-shadow: 0 2px 6px rgba(15, 23, 42, 0.05);
  overflow: visible;
  position: relative;
}
.fig-box img {
  max-width: 100%;
  height: auto;
  display: block;
  margin: 0 auto;
  border-radius: 4px;
  cursor: zoom-in;
  transition: transform 0.25s ease, box-shadow 0.25s ease;
}
.fig-box.is-zoomed { z-index: 45; }
.fig-box img.is-zoomed {
  position: relative;
  z-index: 46;
  box-shadow: 0 18px 44px rgba(15, 23, 42, 0.30);
  background: #ffffff;
}
.fig-cap { font-size: 0.72em; color: var(--slate-500); margin-top: 5px; font-weight: 500; }
.small-text { font-size: 0.82em; }
</style>

<!-- _class: lead -->

<div class="badge">Information and Software Technology · Vol. 50, pp. 897–911 · 2008</div>

# 結合 UML 與軟體模擬於流程定義、驗證與確認之研究

<div class="en-title">Applying UML and Software Simulation for Process Definition, Verification, and Validation</div>

<div class="subtitle">
將 CMMI 流程領域目標嵌入 UML 流程模型擴充組（PMP），透過 OCL 自動化驗證合規性，並在先導專案啟動前以 SimSE 互動模擬進行流程確認與教育訓練。
</div>

<div class="meta-box">
<strong>薛念林（Nien-Lin Hsueh）</strong>、<strong>沈文祥<sup>*</sup>（Wen-Hsiang Shen）</strong>、<strong>楊志偉（Zhi-Wei Yang）</strong>、<strong>楊東麟（Don-Lin Yang）</strong><br>
逢甲大學資訊工程學系 · DOI: <code>10.1016/j.infsof.2007.10.015</code>
</div>

<div class="grant">經濟部技術處學界科專計畫補助 · 計畫編號：96-EC-17-A-02-S1-029</div>

<!--
論文背景與研究定位：
- 完整出處：N.-L. Hsueh, W.-H. Shen, Z.-W. Yang, and D.-L. Yang, "Applying UML and software simulation for process definition, verification, and validation," Information and Software Technology, Vol. 50, pp. 897-911, 2008。
- 核心研究缺口：既有軟體流程建模語言（如 Petri net、工作流程語言或通用型 SPEM）多半無法在流程定義階段直接嵌入 CMMI 流程領域（PA）與目標的階層關係，亦缺乏在昂貴的先導專案（pilot project）執行前進行輕量級流程確認（validation）的機制。
- 雙重應用價值：本研究所提之 UML-OCL-SimSE 一貫式流程環境，除可協助企業工程流程小組（EPG）進行 CMMI 流程改善外，流程通過確認後亦能直接作為學生與專案成員之互動式流程教育平台。
-->

---

## 簡報大綱

<div class="outline-grid">
<div class="outline-item">
  <div class="outline-num">1</div>
  <div class="outline-body"><a href="#3">研究動機與實務挑戰</a><br>逢甲大學資訊處導入 CMMI Level 3 之實務經驗、既有 PML 與 SPEM 侷限、先導專案風險。</div>
</div>
<div class="outline-item">
  <div class="outline-num">2</div>
  <div class="outline-body"><a href="#4">整體方法架構（D-V-V）</a><br>串聯 UML 定義、OCL 驗證、SimSE 轉換、模擬確認與教育訓練之六步驟生命週期。</div>
</div>
<div class="outline-item">
  <div class="outline-num">3</div>
  <div class="outline-body"><a href="#5">流程定義（PMP 擴充組）</a><br>嵌入 CMMI 之靜態元模型、Rational XDE 12 項刻板型（Stereotypes）與三視角 UML 圖形。</div>
</div>
<div class="outline-item">
  <div class="outline-num">4</div>
  <div class="outline-body"><a href="#8">OCL 自動化流程驗證</a><br>流程結構規則與 CMMI 成熟度規則之 OCL 形式化檢查與即時錯誤警示。</div>
</div>
<div class="outline-item">
  <div class="outline-num">5</div>
  <div class="outline-body"><a href="#10">SimSE 模擬模型轉換</a><br>從 PMP XML 轉換至 SimSE 物件、動作、觸發器與效應規則，並量化流程理解度。</div>
</div>
<div class="outline-item">
  <div class="outline-num">6</div>
  <div class="outline-body"><a href="#12">逢甲資處案例與問卷分析</a><br>針對產品開發流程六大實務邀請 8 位 EPG 專案領導人實測與 6 題問卷評估。</div>
</div>
</div>

<div class="callout teal" style="margin-top: 16px;">
<strong>核心論點：</strong>結合工程師熟悉的 UML 擴充組（PMP）、自動化 OCL 合規驗證與互動式 SimSE 模擬，可在投入昂貴的先導專案前及早揪出流程設計缺陷。
</div>

<!--
論文結構總覽：
- 第 1 節（緒論）以逢甲大學資訊處（OIT）自 2003 年 3 月啟動 CMMI ML3 改善計畫為真實背景，引出流程定義、驗證與確認三大議題。
- 第 2 節（相關研究）回顧 UML 流程建模、SPEM 侷限、UML Profile 機制、形式化驗證與 SimSE 教育模擬遊戲。
- 第 3 節（流程定義）提出含 CMMI 框架之靜態流程元模型（圖 2）、12 項 PMP 刻板型（表 1）及類別／狀態／活動三種視角（圖 3 至圖 5）。
- 第 4 節（流程驗證）以 OCL 定義流程結構規則與 CMMI 規則（圖 6 至圖 10）。
- 第 5 節（流程確認）說明 PMP 轉 SimSE 之對照表（表 2）、遊戲行為細化規則（圖 11 至圖 12、表 3）、理解度公式與 OIT 實證結果（圖 13 至圖 15、表 4）。
- 第 6 節（結論）總結貢獻並展望分散式開發環境之流程建模。
-->

---

## 1. 研究動機與實務挑戰

<div class="three-col" style="margin-bottom: 12px;">
<div class="kpi-card">
  <div class="kpi-val">18 個 PA</div>
  <div class="kpi-label">逢甲大學資訊處（OIT）自 2003 年 3 月起導入 CMMI Level 3 之流程領域</div>
</div>
<div class="kpi-card accent">
  <div class="kpi-val">42 項目標</div>
  <div class="kpi-label">需確保組織流程能完整追溯並滿足所有 CMMI 特定與一般目標</div>
</div>
<div class="kpi-card teal">
  <div class="kpi-val">約 130 項實務</div>
  <div class="kpi-label">EPG 必須定義、交叉驗證一致性並確認可執行性的龐大流程數量</div>
</div>
</div>

<div class="two-col">
<div class="card">
  <h3>OIT 工程流程小組（EPG）四大痛點</h3>
  <ul class="small-text">
    <li><strong>可讀性：</strong>如何定義清晰精簡、讓所有流程執行者皆能理解的規範？</li>
    <li><strong>CMMI 充分性：</strong>如何確知所定義流程已涵蓋 CMMI 所有必要要求？</li>
    <li><strong>跨文件一致性：</strong>各流程產出物、狀態與活動之間是否存在衝突？</li>
    <li><strong>先導專案成本高：</strong>IDEAL 模式建議先執行先導專案，但若流程本身有瑕疵，即使小型先導仍耗費龐大人力。</li>
  </ul>
</div>
<div class="card accent">
  <h3>既有流程建模語言（PML）之不足</h3>
  <ul class="small-text">
    <li><strong>Petri Net 與工作流程語言：</strong>形式嚴謹可防衝突，但語法門檻過高，一般軟體開發人員難以閱讀與執行。</li>
    <li><strong>OMG SPEM：</strong>雖基於 UML，但規格過於龐大不易落地，且屬通用標準，<em>未提供 CMMI 流程定義支援</em>。</li>
    <li><strong>本研究解方：</strong>以輕量級 UML Profile（PMP）嵌入 CMMI 階層，結合 OCL 自動驗證與 SimSE 先導前模擬。</li>
  </ul>
</div>
</div>

<!--
研究動機細節（第 1 至 2 節）：
- 逢甲大學資訊處（OIT）於 2003 年 3 月啟動 CMMI 成熟度第三級（ML3）改善專案，涵蓋 18 個流程領域、42 項目標與 130 項實務（包括專案規劃、監控、組態管理等）。
- 傳統文字式流程規格書難以跨頁比對一致性與 CMMI 覆蓋度；若直接進入 IDEAL 模型建議的先導專案（pilot project），一旦流程順序或角色權責設計不當，將造成組織極高的試錯成本。
- 因此，團隊選擇開發人員最熟悉的 UML 作為基礎，利用 UML Profile 擴充機制克服 Petri net 的學習門檻與 SPEM 缺乏 CMMI 語意的雙重限制。
-->

---

## 2. 整體方法架構（定義 ➔ 驗證 ➔ 確認）

<div class="fig-box" style="margin-bottom: 10px;">
<img src="./img/diag1_pipeline.svg" alt="四階段 UML-OCL-SimSE 流程定義驗證確認管線圖" style="max-height: 255px;">
</div>

<div class="split64">
<div class="card">
  <h3>六大生命週期步驟</h3>
  <ol class="small-text">
    <li><strong>流程模型定義：</strong>於 Rational XDE 載入 PMP，繪製靜態結構、產出物狀態與動態活動圖。</li>
    <li><strong>自動化流程驗證：</strong>即時執行內嵌之 OCL 結構規則與 CMMI 合規規則。</li>
    <li><strong>模擬模型轉換：</strong>將 PMP 匯出為 XML ➔ 自動轉出半成品 SimSE 模型 ➔ 手動細化遊戲參數。</li>
    <li><strong>先導前確認與教育：</strong>由利害關係人試玩模擬遊戲，及早修訂流程並於通過後轉作人員訓練工具。</li>
  </ol>
</div>
<div class="fig-box">
  <img src="./img/fig1_overview.png" alt="論文圖 1 整體方法概觀" style="max-height: 195px;">
  <div class="fig-cap">論文圖 1：結合 UML、OCL 與 SimSE 之整體方法概觀。</div>
</div>
</div>

<!--
生命週期設計邏輯（第 1 節、圖 1）：
- 本架構明確區分「驗證（Verification）」與「確認（Validation）」：前者透過 OCL 檢查模型結構與 CMMI 規範是否正確一致；後者透過 SimSE 互動模擬檢查流程是否符合組織實務運作需求。
- 若模擬結果顯示流程不適合實際執行，可立即在圖 1(d) 回饋修訂流程模型，大幅縮減後續先導專案的返工成本。
- 流程通過確認並正式採用後，該模擬環境亦直接承擔圖 1(e) 的流程教育訓練角色。
-->

---

## 3. 流程定義：嵌入 CMMI 之靜態元模型

<div class="split46">
<div class="card">
  <h3>雙層元模型架構</h3>
  <ul class="small-text">
    <li><strong>上層（CMMI 框架）：</strong>明確定義 <code>CMMI_ML</code>（五級成熟度）➔ <code>CMMI_PA</code>（流程領域）➔ <code>CMMI_Goal</code>（目標）➔ <code>CMMI_Practice</code>（實務）。</li>
    <li><strong>下層（組織流程結構）：</strong>
      <ul>
        <li><code>WorkProcess</code> ➔ <code>WorkPractice</code> ➔ 原子層級 <code>WorkStep</code>（如產品開發 ➔ 軟體設計 ➔ 同儕審查）。</li>
        <li>每個流程皆強制包含 <code>EntryCriteria</code> 與 <code>ExitCriteria</code>。</li>
        <li><code>ProcessMember</code> 細分為 <code>ProcessOwner</code> 與 <code>ProcessPerformer</code>。</li>
      </ul>
    </li>
    <li><strong>橋接關聯：</strong>組織 <code>WorkPractice</code> 透過實現關係對應 <code>CMMI_Practice</code>，奠定自動稽核基礎。</li>
  </ul>
</div>
<div class="fig-box">
  <img src="./img/fig2_metamodel.png" alt="論文圖 2 靜態流程元模型" style="max-height: 390px;">
  <div class="fig-cap">論文圖 2：結合 CMMI 框架（虛線上方）與組織流程元素（虛線下方）之靜態元模型。</div>
</div>
</div>

<!--
靜態元模型語意解析（第 3.1 節、圖 2）：
- 虛線下方描述組織基本流程元素：WorkProcess 描述執行作業，其子類別 WorkPractice 可為子流程並包含多個原子化的 WorkStep；例如「Product Development」包含子流程「Software Design」，其下再包含「Peer review」。每個 WorkProcess 至少須有一個 EntryCriteria（如使用者需求已起草）與一個 ExitCriteria。
- 虛線上方導入 CMMI 階層：成熟度等級（ML1 至 ML5）由多個流程領域（PA）構成，每個 PA 含多項目標（Goal），每項目標由多項實務（Practice）達成。透過組織 WorkPractice 與 CMMI_Practice 之關聯，即可程式化追溯組織成熟度是否達標。
-->

---

## 3.2 流程模型擴充組（PMP）與刻板型定義

擷取 UML SPEM 精華並以 XML 建置於 IBM Rational XDE 中，定義 **12 項核心刻板型（Stereotypes）**：

| 刻板型（Stereotype） | UML 基礎類別 | 父刻板型 | OIT 組織流程實例 |
| :--- | :--- | :--- | :--- |
| `WorkArtifact` | `Core::Class` / `ObjectFlowState` | — | 客戶需求、SDD、SRS、系統驗收單（SAF） |
| `EntryCriteria` / `ExitCriteria` | `Core::Constraint` | — | 需求起草後方可分析 / 需求書完成即停止 |
| `WorkProcess` ➔ `WorkPractice` ➔ `WorkStep` | `Core::Operation` / `ActionState` | 階層繼承 | 產品開發 ➔ 需求分析 ➔ 建立需求基線 |
| `ProcessMember` ➔ `Owner` / `Performer` | `UseCases::Actor` | 階層繼承 | 專案領導人、流程定義團隊、需求分析師 |
| `CMMI_ML`, `CMMI_PA` | `Core::Class` | — | 成熟度第二級（ML2）；REQM、CM、PPQA |
| `CMMI_Goal`, `CMMI_Practice` | `Core::Class` | — | 管理需求；管理需求變更 |

<div class="callout">
<strong>工程優勢：</strong>PMP 直接以標準 UML 擴充機制精煉語意並存成 XML 檔，建模者無須重新學習專有符號即可獲得 CMMI 領域專屬工具列與驗證能力。
</div>

<!--
PMP 刻板型工程設計（第 3.2 節、表 1）：
- PMP 將 12 個流程與 CMMI 概念對應至 UML 標準元類別（Core::Class、Core::Constraint、Core::Operation、ActivityGraphs::ObjectFlowState/ActionState 與 UseCases::Actor）。
- 由於 WorkArtifact 同時繼承 Core::Class 與 ActivityGraphs::ObjectFlowState，同一工作產出物既能在類別圖描述靜態輸入／輸出相依，也能在活動圖以物件流狀態（如 [Drafted]、[Approved]）精準表達進出條件。
-->

---

## 3.3 多視角 UML 流程建模實務

<div class="split55">
<div class="card">
  <h3>三種互補且同步之流程視角</h3>
  <ul class="small-text">
    <li><strong>類別圖（靜態結構）：</strong>呈現活動輸入（SDD、RTM、TP）、產出（程式碼、單元測試）、執行者與 CMMI 實務對應（如 <em>Software Design</em> 實現 <em>Manage Requirements Changes</em>）。</li>
    <li><strong>狀態圖（產出物生命週期）：</strong>描繪 <code>WorkArtifact</code> 狀態轉換（如 <em>SAF</em> 經由需求引出由 <code>Approved ➔ Accepted</code>）。工具強制轉換事件須選自已定義之 <code>WorkProcess</code>，杜絕誤植。</li>
    <li><strong>活動圖（動態流程順序）：</strong>以物件流狀態（<code>System Proposal [Drafted]</code>）表達進出條件，並以<strong>泳道（Swimlanes）</strong>區分不同執行者職責（如 Elicitor 與 Analyzer）。</li>
  </ul>
  <div class="callout teal" style="margin-top: 8px; font-size: 0.78em;">
    <strong>單一元模型一致性：</strong>活動圖中之 <code>SAF [Accepted]</code> 直接參照狀態圖的 <code>Accepted</code> 狀態與類別圖的 <code>SAF</code> 類別，跨圖不一致可即時揭露。
  </div>
</div>
<div class="fig-box">
  <img src="./img/fig5_activity.png" alt="論文圖 5 含泳道之活動圖" style="max-height: 395px;">
  <div class="fig-cap">論文圖 5：以泳道區分 Elicitor 與 Analyzer 職責並標示產出物狀態之活動圖。</div>
</div>
</div>

<!--
多視角建模與跨圖一致性（第 3.3 節、圖 3 至圖 5）：
- 實務上 EPG 採迭代方式建模：先以類別圖盤點流程元素與 CMMI 對應關係（圖 3A-C），再以狀態圖定義關鍵產出物之狀態轉換（圖 4），最後以活動圖串接動態執行順序與角色泳道（圖 5）。
- 在匯入 PMP 的 Rational XDE 環境中，繪製狀態圖轉換時只能從類別圖已宣告的 WorkProcess 清單選取，大幅降低人為拼寫錯誤或幽靈活動的產生。
-->

---

## 4. 基於 OCL 之自動化流程驗證

採用無副作用之<strong>物件限制語言（OCL）</strong>撰寫驗證規則並內嵌於 PMP 元模型中，自動檢查流程之<strong>正確性、完整性與一致性</strong>：

<div class="two-col">
<div class="card">
  <h3>1. 流程結構相關規則（Process-Related）</h3>
  <p class="small-text">約束組織流程定義之基本結構完整性：</p>
  <ul class="small-text">
    <li><strong>單一執行者多重性：</strong>每項 <code>WorkPractice</code> 須由恰好一位 <code>ProcessPerformer</code> 負責執行。</li>
    <li><strong>強制進出條件：</strong>每個 <code>WorkProcess</code> 皆必須定義至少一項 <code>EntryCriteria</code> 與 <code>ExitCriteria</code>。</li>
    <li><strong>跨圖參照一致：</strong>活動圖所使用之產出物狀態須與狀態圖宣告完全相符。</li>
  </ul>
</div>
<div class="card accent">
  <h3>2. CMMI 合規相關規則（CMMI-Related）</h3>
  <p class="small-text">由下而上自動稽核階段式成熟度覆蓋情形：</p>
  <ul class="small-text">
    <li><strong>實務實現檢查：</strong>CMMI ML2 每項 <code>CMMI_Practice</code> 皆須至少有一個組織 <code>WorkPractice</code> 實現之。</li>
    <li><strong>目標與流程領域達成：</strong>當旗下所有實務皆被實現時目標始告達成；所有目標達成時該 PA 始告滿足。</li>
    <li><strong>一般實務（GP）間接推論：</strong>當組織流程滿足特定 PA（如組態管理 CM），規則引擎會主動提示亦同時滿足所有 PA 之 <em>GP：Manage Configurations</em>。</li>
  </ul>
</div>
</div>

<!--
OCL 驗證架構解析（第 4.1 節、圖 6）：
- 論文於第 4.1.2 節展示四類核心 CMMI 相關 OCL 規則：
  1. ML2 所有 PA 皆須滿足之規則。
  2. ML2 所有 Goal 皆須達成之規則。
  3. ML2 所有 Practice 皆須被組織 WorkPractice 實現之規則。
  4. 跨 PA 一般實務（GP）間接滿足推論規則：當 Practice1 實現「CMMI_SP: Identify Configuration Items」時，系統主動回饋該實務同時滿足 CM 流程領域及所有 PA 之「GP: Manage Configurations」，使驗證工具兼具 CMMI 知識輔導功能。
-->

---

## 4.2 自動化流程驗證實務畫面

<div class="split55">
<div class="fig-box">
  <img src="./img/fig7_verification.png" alt="論文圖 7 流程結構規則錯誤警示" style="max-height: 315px;">
  <div class="fig-cap">論文圖 7：結構規則錯誤—<code>WorkPractice</code> 遺漏必要的 <code>EntryCriteria</code>。</div>
</div>
<div class="fig-box">
  <img src="./img/fig8_cmmi_warn.png" alt="論文圖 8 CMMI 合規規則警告" style="max-height: 315px;">
  <div class="fig-cap">論文圖 8：CMMI 規則警告—即時標示尚未滿足 ML2 要求之處。</div>
</div>
</div>

<div class="callout teal" style="margin-top: 12px;">
<strong>對 EPG 作業之實質效益：</strong>自動化 OCL 驗證取代耗時易錯的人工紙本審查，於建模當下即時回報結構缺失（圖 7）、CMMI 覆蓋缺口（圖 8）與 GP 對應知識（圖 9），直至通過全部規則產出無誤模型（圖 10）。
</div>

<!--
驗證工具執行實況（第 4.2 節、圖 7 至圖 10）：
- 圖 7 顯示當建模者遺漏某項 WorkPractice 的 EntryCriteria 時，模型檢查工具會立即於底部視窗列出違規元件與規則說明。
- 圖 8 顯示當流程模型未達 CMMI ML2 規則要求時，系統自動跳出警告訊息指明缺漏處。
- 透過即時自動化檢查，EPG 無須耗費大量人力逐頁交叉核對 130 項實務規格書，即可確保送交模擬確認前的模型完全合規。
-->

---

## 5. 透過 SimSE 軟體模擬進行流程確認

為於先導專案前確認流程是否切合實務，本研究採**兩階段法**將已驗證之 PMP 轉為可執行之 **SimSE** 模擬遊戲：（1）自動 XML 模型轉換，（2）人工細化遊戲行為參數。

| PMP 來源元素 | 轉換規則與指引 | 產出之 SimSE 元件 |
| :--- | :--- | :--- |
| 類別圖：`WorkPractice`（如 Implementation） | 自動映射為 SimSE 動作 | 動作 `Implementation` |
| 類別圖：`ProcessPerformer`（如 Implementer） | 自動映射為 Employee 子型別 | 員工子型別 `Implementer` |
| 類別圖：`WorkArtifact` 與產出關係 | 自動映射為 Artifact 與建立規則 | 產出物 `UnitTest` ＋ 建立規則 |
| 狀態圖：產出物狀態與轉換 | **（M）** 狀態轉觸發條件、轉換轉效應規則 | 條件 `SAF == Approved`；效應 `➔ Accepted` |
| 活動圖：活動順序與泳道 | 順序自動轉觸發條件；**（M）** 泳道轉效率規則 | 觸發條件 `SPAF approved`；正確角色效率高於錯誤角色 |

<div class="callout" style="margin-top: 8px; font-size: 0.8em;">
<strong>SimSE 五大建構元件：</strong><code>Object Types</code>（員工、產出物、專案、工具、客戶）、<code>Start State</code>、<code>Actions</code>（含自動／使用者／隨機三類觸發器與終止器）、<code>Rules</code>（建立／銷毀／效應規則）與 <code>Graphics</code>（虛擬辦公室配置）。<em>（M）</em> 表需人工介入細化。
</div>

<!--
PMP 至 SimSE 轉換架構（第 5.1 至 5.2 節、表 2）：
- SimSE 由加州大學爾灣分校（UC Irvine）開發，為單人互動式圖形軟體工程模擬遊戲，玩家扮演專案經理指派團隊成員執行開發活動。
- 自動轉換工具解析 Rational XDE 匯出之 PMP XML，產生包含員工子型別、產出物、動作與基本前置條件的半成品 SimSE 模型。
- 人工細化階段則補入軟體工程動態參數：員工屬性（體力初始為 1.0、生產力、錯誤率）、產出物屬性（規模、已知／未知錯誤數、完成度百分比），並加入自動休息（break）與低體力隨機離職（quit，如體力 <= 0.1 時有 70% 機率觸發）等真實機制。
-->

---

## 5.2 轉換工具、行為效應規則與量化評分

<div class="split55">
<div class="fig-box">
  <img src="./img/fig13_transform.png" alt="論文圖 13 XML 至 SimSE 轉換工具畫面" style="max-height: 290px;">
  <div class="fig-cap">論文圖 13：自製 PMP XML 至 SimSE 模型轉換工具（左為流程模型，右為模擬模型）。</div>
</div>
<div>
  <div class="card accent" style="margin-bottom: 10px;">
    <h3>角色適配效應規則（以 SSA 活動為例）</h3>
    <div class="small-text">
      • <strong>正確執行者（Analyzer）：</strong><code>energy -= 0.05</code>，<code>errorRate = (1 - energy) × 0.4</code>。<br>
      • <strong>錯誤執行者（Elicitor）：</strong><code>energy -= 0.10</code>，<code>errorRate = (1 - energy) × 0.6</code> ➔ 進度慢且注入更多缺陷須返工！
    </div>
  </div>
  <div class="card teal">
    <h3>流程理解度量化公式</h3>
    <div class="small-text" style="line-height: 1.55;">
      <strong>單一實務理解度：</strong><br>
      <code>P<sub>i</sub>Understanding = (P<sub>i</sub>BestTimeElapsed / P<sub>i</sub>ActionTimeElapsed) × 100</code><br>
      <strong>整體流程理解度：</strong><br>
      <code>ProcessUnderstanding = (1 / n) × Σ<sub>i=1..n</sub> P<sub>i</sub>Understanding</code>
    </div>
  </div>
</div>
</div>

<!--
行為細化與量化評分設計（第 5.3 至 5.4 節、圖 11 至圖 13、表 3）：
- 論文圖 11 與表 3 將軟體工程實證法則（如人盡其才可提升生產力、前置產出物完成度影響後續階段品質）轉化為 SimSE EffectRule。若指派不當角色執行系統與軟體分析（SSA），不僅體力消耗加倍、錯誤率係數由 0.4 升至 0.6，後續還需額外除錯時間。
- 論文圖 12 展示 Implementation 動作的觸發與終止規則：僅當 Implementer 已受僱且健康度 >= 0.6 時始可由右鍵選單啟動；當程式碼完成度達 100% 時自動終止，玩家亦可隨時手動中止。
- ProcessUnderstanding 以最佳執行時間除以玩家實際耗時計算各實務得分並取平均，能客觀揭露玩家在哪些流程環節偏離規範。
-->

---

## 6. 實證案例：逢甲大學資訊處（OIT）驗證

針對逢甲資處 9 份流程規格中之**產品開發流程**（含 6 大實務：客戶需求引出、系統／軟體分析、架構／資料庫設計、軟體設計、實作、整合與交付），邀請 **8 位 EPG 專案領導人** 進行實測：

<div class="split55" style="margin-top: 6px;">
<div class="fig-box">
  <img src="./img/fig14_simse.png" alt="論文圖 14 SimSE 模擬中之產出物狀態" style="max-height: 235px;">
  <div class="fig-cap">論文圖 14：SimSE 虛擬辦公室與各工作產出物即時狀態監控畫面。</div>
</div>
<div class="fig-box">
  <img src="./img/fig15_scores.png" alt="論文圖 15 各實務理解度分數" style="max-height: 235px;">
  <div class="fig-cap">論文圖 15：各實務得分精準抓出遺漏 SRS 審查（實務 II）與單元測試（實務 V）。</div>
</div>
</div>

<div class="three-col" style="margin-top: 10px;">
<div class="kpi-card teal">
  <div class="kpi-val">7 / 8 位 &gt; 80 分</div>
  <div class="kpi-label">七位 EPG 專案領導人得分逾 80 分，其中兩位流程起草者獲 <strong>100 分滿分</strong></div>
</div>
<div class="kpi-card accent">
  <div class="kpi-val">40.7 分（1 位低分）</div>
  <div class="kpi-label">訪談確認低分主因為初次接觸 SimSE 操作介面不熟，而非流程定義錯誤</div>
</div>
<div class="kpi-card">
  <div class="kpi-val">二測提升 +13.7%</div>
  <div class="kpi-label">第二次測試平均總分顯著提升 13.7%，證實具備高度教育訓練成效</div>
</div>
</div>

<!--
OIT 實證案例解析（第 5.4 節、圖 14 至圖 15）：
- 實驗流程：先由 Rational XDE 匯出產品開發流程 PMP XML，經轉換工具（圖 13）轉為 SimSE 模型並配置虛擬辦公室後，由 8 位參與 EPG 的專案領導人上機操作。
- 圖 15 展現高度診斷力：玩家於實務 II 未執行 SRS 審查、於實務 V 未執行單元測試與產出測試紀錄，導致該兩項實務分數明顯偏低，系統立即定位問題環節。
- 8 位受測者中 7 位取得 80 分以上（2 位起草人得滿分），顯示模擬環境忠實反映 OIT 流程；第二次試玩平均分數再提升 13.7%，展現此環境作為新進成員流程訓練工具的潛力。
-->

---

## 6.2 實務人員問卷評估與教學成效

<div class="split46">
<div class="card">
  <h3>問卷核心發現（n = 8，五點量表）</h3>
  <ul class="small-text">
    <li><strong>六題全數高於 3.50 分</strong>（遠高於 3.0 中立門檻），呈現一致正向回饋。</li>
    <li><strong>最高評價 — 4.75 / 5.0（Q6）：</strong>75% 非常同意、25% 同意能透過此環境有效學習產品開發流程之<em>活動順序</em>。</li>
    <li><strong>易用性與趣味性：</strong>操作相對容易（<strong>3.75</strong>）且過程具趣味性（<strong>3.63</strong>）。</li>
    <li><strong>流程吻合度與核可度：</strong>標準流程與遊戲情境高度對應（<strong>3.63</strong>），且多數認同流程已完備可供先導專案執行（<strong>3.50</strong>）。</li>
  </ul>
</div>
<div class="fig-box">
  <img src="./img/diag2_survey.svg" alt="OIT EPG 六題問卷結果長條圖" style="max-height: 365px;">
  <div class="fig-cap">論文表 4：8 位 OIT EPG 專案領導人對模擬驗證環境之五點量表平均評分。</div>
</div>
</div>

<!--
問卷逐題數據拆解（第 5.4 節、表 4）：
- Q1（遊玩趣味性）：2 分佔 25%、3 分佔 12.5%、4 分佔 37.5%、5 分佔 25%，平均 3.63。
- Q2（操作難易／順手度）：3 分佔 37.5%、4 分佔 50%、5 分佔 12.5%，平均 3.75。
- Q3（標準產品開發流程與遊戲情境之吻合度）：3 分佔 37.5%、4 分佔 62.5%，平均 3.63。
- Q4（產品開發流程定義之完備與核可度）：3 分佔 50%、4 分佔 50%，平均 3.50。
- Q5（對目前實務工作之幫助程度）：2 分佔 25%、3 分佔 12.5%、4 分佔 50%、5 分佔 12.5%，平均 3.50。
- Q6（能否從中學習產品開發流程之活動順序）：4 分佔 25%、5 分佔 75%，平均 4.75。
- 團隊亦收集開放式意見與操作日誌，用以持續強化模擬模型並降低後續先導專案執行風險。
-->

---

## 7. 討論、研究限制與未來展望

<div class="two-col">
<div class="card teal">
  <h3>主要學術與實務貢獻</h3>
  <ul class="small-text">
    <li><strong>嵌入 CMMI 之 UML Profile（PMP）：</strong>將 CMMI 成熟度階層直接融入開發者熟悉的類別圖、狀態圖與活動圖。</li>
    <li><strong>自動化 OCL 稽核機制：</strong>同時檢驗流程結構正確性與 CMMI 覆蓋合規性，並具備跨 PA 一般實務推論提醒。</li>
    <li><strong>先導前輕量級模擬確認與教學：</strong>透過 SimSE 及早發現流程設計盲點、降低先導專案風險，並無縫轉化為高效教學工具（4.75/5.0）。</li>
  </ul>
</div>
<div class="card accent">
  <h3>研究限制與未來方向</h3>
  <ul class="small-text">
    <li><strong>人工細化負擔：</strong>狀態轉換、泳道效率與員工／產出物動態效應規則仍需人工撰寫 SimSE 規則，尚未達到 100% 全自動生成。</li>
    <li><strong>實證樣本與範圍：</strong>驗證僅針對 OIT 9 份規格中的「產品開發流程」，且受測樣本較小（8 位 EPG 專案領導人）。</li>
    <li><strong>介面學習曲線：</strong>初次操作 SimSE 介面不熟可能干擾首輪測驗分數（40.7 分離群值）。</li>
    <li><strong>未來研究：</strong>將本流程建模、驗證與模擬確認方法延伸至<em>分散式軟體開發環境</em>。</li>
  </ul>
</div>
</div>

<div class="callout" style="margin-top: 14px;">
<strong>給實務界的啟示：</strong>以軟體模型工程的思維管理軟體流程—結合型別化元模型、自動化 OCL 驗證與可執行模擬—能讓 CMMI 導入從繁瑣文書轉型為可驗證、可演練的工程實踐。
</div>

<!--
綜合討論與研究限制（第 5.4 節與第 6 節）：
- 本研究最大的工程價值在於整合既有成熟標準（UML Profile、OCL、SimSE），而非另創難懂的專有數學符號，使組織 EPG 與一般專案工程師能以極低阻力導入。
- 研究限制涵蓋：半自動轉換仍需手動補充遊戲動態規則、實證聚焦於單一工程流程且受測人數僅 8 位（其中 2 位為流程起草者），以及模擬器介面初學門檻。
- 論文第 6 節明確指出未來方向將聚焦於「分散式環境（distributed environment）」之流程建模與驗證應用。
-->

---

<!-- _class: closing -->

# 感謝聆聽！敬請指教

<p style="font-size: 1.05em; max-width: 880px;">
結合 UML 與軟體模擬於流程定義、驗證與確認之研究<br>
<span style="font-size: 0.82em; opacity: 0.86;">Applying UML and Software Simulation for Process Definition, Verification, and Validation</span>
</p>

<div class="contact-card">
<strong>薛念林（Nien-Lin Hsueh）</strong> · <code>nlhsueh@fcu.edu.tw</code> &nbsp;|&nbsp; <strong>沈文祥<sup>*</sup></strong> · <code>shen@ocit.edu.tw</code><br>
<strong>楊志偉（Zhi-Wei Yang）</strong> · <code>sundy.yang@auo.com</code> &nbsp;|&nbsp; <strong>楊東麟</strong> · <code>dlyang@fcu.edu.tw</code><br>
逢甲大學資訊工程學系（Department of Information Engineering and Computer Science, FCU）<br>
<span style="font-size: 0.85em; opacity: 0.88;">Information and Software Technology, Vol. 50 (2008), pp. 897–911 · 計畫編號 96-EC-17-A-02-S1-029</span>
</div>

<!--
文獻與歸檔資訊：
- 篇名：Applying UML and software simulation for process definition, verification, and validation
- 作者：薛念林（Nien-Lin Hsueh）、沈文祥（Wen-Hsiang Shen，通訊作者）、楊志偉（Zhi-Wei Yang）、楊東麟（Don-Lin Yang）
- 期刊：Information and Software Technology (IST), Elsevier, Vol. 50, pp. 897-911, 2008
- DOI：10.1016/j.infsof.2007.10.015
- 關鍵字：CMMI、UML、流程建模、流程模擬、軟體工程教育
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

document.addEventListener('click', (e) => {
  const langBtn = e.target.closest('.lang-btn');
  if (!langBtn) return;
  e.preventDefault();
  const target = langBtn.getAttribute('href');
  if (target) window.location.href = target + (window.location.hash || '');
});
</script>
