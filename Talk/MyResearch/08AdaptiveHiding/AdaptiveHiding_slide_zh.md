---
marp: true
theme: gaia
size: 16:9
paginate: true
html: true
header: '<div class="hdr-wrap"><span class="hdr-title">適應性影像二進位資料隱藏演算法 (FI 2008)</span><div class="hdr-actions"><a class="lang-btn" href="./AdaptiveHiding_slide.html" title="Switch to English Slides">🌐 EN</a><div class="nav-dropdown"><button class="nav-btn">章節導覽 ▾</button><div class="nav-menu"><a href="#2">簡報大綱</a><a href="#3">1. 研究動機與核心概念</a><a href="#4">2. 相關研究與 OPAP 基準</a><a href="#6">3. 適應性 DEM 隱藏演算法</a><a href="#10">4. 實驗設計與效能分析</a><a href="#14">5. 結論與應用價值</a></div></div></div></div>'
footer: '林清泉（Ching-Chiuan Lin）、薛念林（Nien-Lin Hsueh）、沈文祥（Wen-Hsiang Shen）· 逢甲大學 · Fundamenta Informaticae 2008'
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
  line-height: 1.48;
  padding: 66px 52px 46px 52px;
  box-sizing: border-box;
  letter-spacing: 0.01em !important;
}

section h1, section h2, section h3 { letter-spacing: 0 !important; }
section:not(.lead):not(.closing) > p { max-width: 980px; }

/* Header & Navigation Dropdown */
header {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  height: 44px;
  padding: 0 52px;
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
.lang-btn:hover { background: rgba(255, 255, 255, 0.26); text-decoration: none !important; }

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

@media print { .lang-btn, .nav-dropdown { display: none !important; } }

/* Footer & Pagination */
footer {
  position: absolute;
  left: 52px;
  bottom: 14px;
  font-size: 12.5px;
  color: var(--slate-500);
  font-weight: 500;
}

section::after {
  position: absolute;
  right: 52px;
  bottom: 14px;
  font-size: 12.5px;
  font-weight: 700;
  color: var(--navy);
  content: attr(data-marpit-pagination) ' / ' attr(data-marpit-pagination-total);
}

/* Headings */
h1 { color: var(--navy); font-size: 1.65em; font-weight: 800; line-height: 1.24; margin: 0 0 12px 0; }
h2 {
  color: var(--navy);
  font-size: 1.22em;
  font-weight: 700;
  line-height: 1.28;
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
  letter-spacing: 0.06em;
  padding: 5px 14px;
  border-radius: 999px;
  margin-bottom: 18px;
}
section.lead h1 { color: #ffffff; font-size: 1.98em; font-weight: 800; line-height: 1.26; margin-bottom: 14px; text-align: left; }
section.lead .subtitle { color: #cbd5e1; font-size: 0.93em; line-height: 1.54; margin-bottom: 24px; max-width: 960px; }
section.lead .meta-box { border-left: 4px solid #f43f5e; padding-left: 18px; color: #e2e8f0; font-size: 0.85em; line-height: 1.62; }
section.lead .grant { margin-top: 20px; font-size: 0.74em; color: #94a3b8; }

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
section.closing h1 { color: #ffffff; font-size: 2.15em; margin-bottom: 12px; }
section.closing p { color: #e2e8f0; }
section.closing .contact-card {
  margin-top: 22px;
  background: rgba(255, 255, 255, 0.12);
  border: 1px solid rgba(255, 255, 255, 0.25);
  border-radius: 12px;
  padding: 18px 36px;
  font-size: 0.85em;
  line-height: 1.68;
  color: #f8fafc;
}

/* Layouts & Cards */
.two-col { display: grid; grid-template-columns: 1fr 1fr; gap: 18px; align-items: stretch; }
.three-col { display: grid; grid-template-columns: repeat(3, 1fr); gap: 14px; align-items: stretch; }
.split64 { display: grid; grid-template-columns: 56% 42%; gap: 2%; align-items: center; }
.split55 { display: grid; grid-template-columns: 49% 49%; gap: 2%; align-items: center; }
.split46 { display: grid; grid-template-columns: 42% 56%; gap: 2%; align-items: center; }

.card {
  background: #ffffff;
  border: 1px solid var(--slate-200);
  border-top: 3.5px solid var(--navy);
  border-radius: 8px;
  padding: 12px 15px;
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
.kpi-label { font-size: 0.75em; color: var(--slate-700); line-height: 1.38; }

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

/* Tables */
table {
  width: 100%;
  border-collapse: collapse;
  font-size: 0.73em;
  margin: 8px 0 10px 0;
  background: #ffffff;
  border: 1px solid var(--slate-200);
}
th {
  background: var(--navy);
  color: #ffffff;
  font-weight: 700;
  padding: 6px 8px;
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

/* Outline Grid */
.outline-grid { display: grid; grid-template-columns: 1fr 1fr; gap: 14px 22px; margin-top: 10px; }
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

.eq-box {
  background: #f8fafc;
  border: 1px solid var(--slate-200);
  border-left: 4px solid var(--teal);
  border-radius: 6px;
  padding: 8px 14px;
  margin: 8px 0;
  font-family: 'JetBrains Mono', monospace;
  font-size: 0.78em;
  color: var(--slate-900);
  line-height: 1.5;
}
.small-text { font-size: 0.82em; }
.future-strip { display: grid; grid-template-columns: repeat(3, 1fr); gap: 12px; margin-top: 12px; }
.future-pill {
  background: #f8fafc;
  border: 1px solid var(--slate-200);
  border-left: 4px solid var(--teal);
  border-radius: 8px;
  padding: 10px 13px;
  font-size: 0.76em;
  line-height: 1.42;
  color: var(--slate-700);
}
.future-pill strong { color: var(--navy); }
</style>

<!-- _class: lead -->

<div class="badge">Fundamenta Informaticae · 第 84 卷，頁 1–12 · 2008（IOS Press）</div>

# 適應性影像二進位資料隱藏演算法

<div class="subtitle">
<strong>Adaptively Embedding Binary Data in an Image</strong><br>
透過<strong>雙區段變動長度子訊息分解（DEM）</strong>與<strong>最近鄰像素值微調</strong>，在任意藏量下最小化偽裝影像失真
</div>

<div class="meta-box">
<strong>林清泉（Ching-Chiuan Lin）<sup>*</sup></strong>、<strong>薛念林（Nien-Lin Hsueh）</strong>、<strong>沈文祥（Wen-Hsiang Shen）</strong><br>
逢甲大學資訊工程學系（Department of Information Engineering and Computer Science, Feng Chia University）<br>
<code>cclin@ocit.edu.tw</code> · <code>nlhsueh@fcu.edu.tw</code> · <code>shen@ocit.edu.tw</code>
</div>

<div class="grant">
關鍵字：資訊隱藏（Information hiding）· 最低有效位元（LSB）· 基本訊息目錄（DEM）· 最佳像素調整程序（OPAP）
</div>

<!--
論文背景與核心摘要：
本論文（林清泉、薛念林、沈文祥，Fundamenta Informaticae 84, 2008, pp. 1–12）提出一種兼具高視覺品質與彈性藏量的適應性二進位資料隱藏演算法。

核心研究洞見：
傳統空間域方法（如簡單 LSB 取代與 Chan–Cheng 最佳像素調整程序 OPAP）強制每個像素藏入固定整數 k 個位元，使每像素的狀態數受限於 2 的冪次（2^k ∈ {2, 4, 8, 16}）。當目標藏量 C 落在非整數 bpp（例如 1.5、2.25 或 3.375 bpp）時，固定位元法會產生不必要的像素大幅跳動。本研究將二進位訊息 M 切分為兩區段，並依據基本訊息目錄（DEM）分解為 n 與 n−1 類變動長度子訊息（n ≥ 3），再將像素微調至最近的同餘鄰近值，將單一像素失真嚴格限制於 ±⌊n/2⌋ 以內。
-->

---

## 簡報大綱（Outline）

<div class="outline-grid">

<div class="outline-item">
  <div class="outline-num">1</div>
  <div class="outline-body"><a href="#3">研究動機與核心問題</a><br>視覺品質與藏量之權衡，以及傳統 2<sup>k</sup> 固定位元法的粒度瓶頸。</div>
</div>

<div class="outline-item">
  <div class="outline-num">2</div>
  <div class="outline-body"><a href="#4">相關文獻與 OPAP 基準</a><br>PVD、模數法、LSB 配對、EMD、簡單 LSB 取代與 Chan–Cheng OPAP。</div>
</div>

<div class="outline-item">
  <div class="outline-num">3</div>
  <div class="outline-body"><a href="#6">適應性 DEM 隱藏演算法</a><br>基本訊息目錄（DEM）、雙區段分割、公式 (2)–(8) 與 4×4 實例演練。</div>
</div>

<div class="outline-item">
  <div class="outline-num">4</div>
  <div class="outline-body"><a href="#10">實驗設計與結果比較</a><br>Lena、Baboon、Airplane、Pepper 於 1.0 至 3.875 bpp 之完整比較（表 2–4）。</div>
</div>

<div class="outline-item">
  <div class="outline-num">5</div>
  <div class="outline-body"><a href="#13">低失真機制深度解析</a><br>為何非 2 冪次 n 勝過分數 k 混用，以及於 k = 2、3 時與 OPAP 等價之原因。</div>
</div>

<div class="outline-item">
  <div class="outline-num">6</div>
  <div class="outline-body"><a href="#14">結論與實務應用價值</a><br>主要貢獻、精簡輔助資訊需求與高畫質隱寫應用場景。</div>
</div>

</div>

<!--
簡報章節架構說明：
本論文分為五節：第一節闡述影像資訊隱藏背景與空間域既有研究限制；第二節回顧簡單 LSB 取代與 Chan–Cheng OPAP [9]；第三節嚴謹定義基本訊息目錄 DEM_t(n)、期望藏量公式 EC_n、八步驟適應性雙區段嵌入演算法、模數擷取流程與 4×4 灰階影像完整範例；第四節在 Java / Windows XP 平台針對四張 512×512 測試影像執行每點 100 組隨機訊息之平均 PSNR 評測；第五節總結失真上界保證與研究貢獻。
-->

---

## 1. 研究動機與核心概念

<div class="two-col">
<div class="card">
<h3>影像隱藏的畫質與藏量兩難</h3>
<ul>
  <li><strong>應用領域：</strong>智慧財產權保護、機密通訊與多媒體註記。</li>
  <li><strong>不可察覺性：</strong>偽裝影像（stego-image）須盡量減少對原始宿主影像（host image）之改動。</li>
  <li><strong>固定 k 位元瓶頸：</strong>簡單 LSB 與 OPAP 每像素取代 <code>k</code> 位元，狀態數受限於 <code>2<sup>k</sup> ∈ {2, 4, 8, 16}</code>。</li>
  <li><strong>粒度過粗：</strong>當所需藏量為非整數 bpp（如 1.5 或 2.25 bpp）時，固定位元法被迫跨級跳動，造成過大失真。</li>
</ul>
</div>

<div class="card teal">
<h3>本研究之適應性分解洞見</h3>
<ul>
  <li><strong>打破固定位元數限制：</strong>每個像素不必嵌入相同位元數量的秘密訊息。</li>
  <li><strong>任意整數 n 元字母表（n ≥ 3）：</strong>依目標藏量 <code>C = #(M)/N</code>，將訊息 <code>M</code> 分解為變動長度基本子訊息。</li>
  <li><strong>雙區段最小化策略：</strong>將 <code>M</code> 分為最小化的 <code>M'<sub>n</sub></code> 與最大化的 <code>M''<sub>n−1</sub></code>，讓多數像素採用更小的 <code>n−1</code> 字母表。</li>
  <li><strong>最近鄰像素調整：</strong>將像素移至最近同餘鄰近值，誤差嚴格限制於 <code>±⌊n/2⌋</code>。</li>
</ul>
</div>
</div>

<div class="callout teal">
<strong>關鍵成果：</strong>在 1.5 bpp 藏量下，本演算法選用 <code>n = 3</code>（單像素最多僅 ±1 改動），PSNR 達 <strong>49.89 dB</strong>——較 OPAP 高出 <strong>+1.76 dB</strong>，較簡單 LSB 高出 <strong>+3.52 dB</strong>。
</div>

<!--
研究動機補充（第 1 節）：
在空間域資訊隱藏中，直接 LSB 取代與像素值調整都會造成宿主影像失真。為維持可接受的視覺品質，傳統 LSB 通常限制 k ≤ 4，但這也使單像素可表達的狀態數只能以 2 的冪次跳躍（2、4、8、16）。本研究透過前綴無關（prefix-free）之基本訊息目錄（DEM）將狀態數推廣至任意整數 n ≥ 3，並以雙區段（n 與 n−1）動態貼合任意訊息長度 #(M) 與宿主像素數 N，進而大幅壓低均方誤差（MSE）。
-->

---

## 2. 相關文獻：空間域資訊隱藏方法比較

| 技術類別 | 代表文獻 | 核心運作機制 | 本研究所克服之主要限制 |
| :--- | :--- | :--- | :--- |
| **像素差值法（PVD）** | Wu &amp; Tsai [4]；Wu 等人 [5]；Chang 等人 [6] | 依相鄰像素差值區間 `{0–7, 8–15, ...}` 對應不同嵌入位元數 | 藏量偏低（&lt; 1.6 bpp）且畫質較低（&lt; 42 dB）；需預先定義差值表 |
| **模數函數法** | Wang [7]；Chang 等人 [8] | 令 `y' = y − (y mod q) + x`，若 `|y' − y| &gt; q/2` 則以 `±q` 修正 | 嵌入二進位訊息時受限於 `q = 2^k`，本質與 OPAP 相同 |
| **LSB 配對與 EMD** | Mielikainen [10]；Zhang &amp; Wang [11] | 像素對配對（改動率降至 0.375）；`R` 像素區塊內至多 1 像素改動 ±1 | 藏量受限於 1 bpp [10] 或 `(log2(2R+1))/R` bpp [11] |
| **區塊差值藏圖法** | Li 等人 [12]；Wang &amp; Chen [13] | 利用秘密影像平滑特性進行區塊配對或雙向壓縮 | 僅適用於隱藏「秘密影像」，無法嵌入一般二進位位元串 |
| **LSB 與 OPAP** | Chan &amp; Cheng [9] | 直接取代 `k` 個最低有效位元後再進行最佳 `±2^k` 像素調整 | 狀態數受限於 2 的冪次 `2^k`，在非整數 bpp 下畫質非最佳 |

<!--
文獻定位補充（第 1 節）：
論文系統性回顧了五大類空間域隱藏技術：
1. PVD 系列 [4, 5, 6]：Wu & Tsai (2003) 將差值區間 {0–7, 8–15, 16–31, 32–63, 64–127, 128–255} 對應至位元長度 {3, 3, 4, 5, 6, 7}，但藏量低於 1.6 bpp、PSNR 低於 42 dB；Wu 等人 (2005) 混合門檻以下 LSB 與門檻以上 PVD 提升藏量。
2. 模數函數法 [7, 8]：雖具像素微調思想，但針對一般二進位串仍須令模數 q = 2^k。
3. 低失真低藏量法 [10, 11]：Mielikainen (2006) 將 1 bpp 下像素改動機率由 0.5 降至 0.375；Zhang & Wang (2006) 的 EMD 在 R 像素區塊藏入 (2R+1) 進位數字，但最大藏量不超過 log2(2R+1)/R bpp。
4. 影像藏影像法 [12, 13]：仰賴秘密影像區塊平滑性，不適用於任意隨機二進位資料。
本方法同時支援任意二進位訊息與高彈性藏量（1.0 至 3.875+ bpp），且大幅提升非整數 bpp 下的 PSNR。
-->

---

## 2. 比較基準：簡單 LSB 取代與 OPAP [9]

<div class="split55">
<div>
<div class="card">
<h3>簡單 LSB 取代（Simple LSB）</h3>
<div class="eq-box">
y' = y − (y mod 2<sup>k</sup>) + m &nbsp;&nbsp;（式 1）<br>
擷取：m = y' mod 2<sup>k</sup> &nbsp;（通常 k ≤ 4）
</div>
<ul class="small-text">
  <li>直接以 <code>k</code> 位元秘密訊息 <code>m</code> 取代宿主像素 <code>y</code> 的最低 <code>k</code> 個位元。</li>
  <li>單像素最大誤差可達 <code>2<sup>k</sup> − 1</code>（例如 <code>k = 2</code> 時誤差可達 −3）。</li>
</ul>
</div>

<div class="card accent" style="margin-top: 10px;">
<h3>Chan &amp; Cheng 最佳像素調整（OPAP）[9]</h3>
<ul class="small-text">
  <li>令 LSB 取代後之差值為 <code>d<sub>i</sub> = b'<sub>i</sub> − b<sub>i</sub></code>：</li>
  <li>若 <code>−2<sup>k</sup> &lt; d<sub>i</sub> &lt; −2<sup>k−1</sup></code> 且 <code>b'<sub>i</sub> &lt; 256 − 2<sup>k</sup></code> ➔ 加上 <code>2<sup>k</sup></code>。</li>
  <li>若 <code>2<sup>k−1</sup> &lt; d<sub>i</sub> &lt; 2<sup>k</sup></code> 且 <code>b'<sub>i</sub> ≥ 2<sup>k</sup></code> ➔ 減去 <code>2<sup>k</sup></code>。</li>
  <li>其餘維持不變 ➔ 將最壞誤差減半至 <code>±2<sup>k−1</sup></code>。</li>
</ul>
</div>
</div>

<div class="fig-box">
<img src="./img/fig1_opap.png" alt="Figure 1: OPAP k=2 範例" style="max-height: 290px;">
<div class="fig-cap">圖 1（論文第 4 頁）：k = 2 時 OPAP 範例 — (a) 將 (00)<sub>2</sub> 嵌入 (43)<sub>16</sub>，由 (40)<sub>16</sub> 上調至 (44)<sub>16</sub>（誤差 −3 ➔ +1）；(b) 將 (11)<sub>2</sub> 嵌入 (44)<sub>16</sub>，由 (47)<sub>16</sub> 下調至 (43)<sub>16</sub>。</div>
</div>
</div>

<!--
比較基準機制詳解（第 2 節）：
Chan 與 Cheng (2004) [9] 提出的 OPAP 利用「加減 2^k 不改變最低 k 個位元」之特性，在維持擷取公式 m = b'_i mod 2^k 完全不變的前提下，將 LSB 取代後的像素值拉回更靠近原始宿主像素 b_i 的位置。
以圖 1(a) 為例，k = 2、b_i = (01000011)_2 = (43)_16 = 67，欲嵌入 (00)_2 時，簡單 LSB 會得到 (40)_16 = 64（d_i = −3）；因落入 −4 < d_i < −2 且 64 < 252，OPAP 加上 4 得到 (44)_16 = 68，使絕對誤差由 3 降至 1。圖 1(b) 則是對稱情形，嵌入 (11)_2 至 (44)_16 後由 (47)_16 下調至 (43)_16。本研究的式 (2)–(3) 正是將此思想從 2^k 推廣至任意整數模數 n ≥ 3。
-->

---

## 3. 所提方法：適應性雙區段 DEM 隱藏架構

<div class="fig-box" style="padding: 8px 10px; margin-bottom: 10px;">
<img src="./img/diag1_adaptive_pipeline.svg" alt="適應性雙區段 DEM 隱藏流程圖" style="max-height: 365px;">
</div>

<div class="callout">
<strong>核心設計哲學：</strong>盡量<strong>最大化子訊息個數</strong>（充分利用全部 <code>N</code> 個像素），同時<strong>最小化子訊息種類數 <code>n</code></strong>，使每個像素的調整幅度嚴格落在 <code>{b<sub>i</sub> − ⌊n/2⌋, ..., b<sub>i</sub> + ⌊n/2⌋}</code> 之間。
</div>

<!--
整體演算法架構說明（第 3 節）：
本演算法將二進位訊息編碼與像素值微調解耦為四個步驟：
1. 藏量評估與 DEM 選擇：計算所需藏量 C = #(M)/N，選出滿足 EC_n <= C < EC_{n+1} 的最小整數 n ≥ 3，並依據訊息 M 中位元「1」或「0」何者居多，選用 DEM_1(n) 或 DEM_0(n)。
2. 雙區段切分：若因位元排列特性導致 |M_n| > N，則將 n 遞增 1。隨後將 M 切分為 M'_n || M''_{n-1}，在 |M'_n| + |M''_{n-1}| <= N 的條件下盡量縮小 |M'_n|（理論比例約為 ER_n），讓更多像素享有更低失真的 n−1 字母表。
3. 最近鄰像素嵌入：依序以模數 n 嵌入 M'_n、以模數 n−1 嵌入 M''_{n-1}，並透過式 (2)–(3) 確保非過飽和像素誤差不超過 ⌊n/2⌋。
4. O(1) 模數擷取：接收端僅需計算 b''_i mod n（或 mod (n−1)）即可查表還原所有子訊息並移除尾端補齊位元。
-->

---

## 3. 基本訊息目錄（DEM）與期望藏量推導

<div class="split64">
<div>

| 子訊息 | `n = 3` (`DEM1` / `DEM0`) | `n = 4` (`DEM1` / `DEM0`) | `n = 5` (`DEM1` / `DEM0`) | `n = 6` (`DEM1` / `DEM0`) | `n = 7` (`DEM1` / `DEM0`) |
| :--- | :---: | :---: | :---: | :---: | :---: |
| `m1` | `0` / `1` | `00` / `11` | `00` / `11` | `00` / `11` | `10` / `01` |
| `m2` | `10` / `01` | `01` / `10` | `01` / `10` | `01` / `10` | `110` / `001` |
| `m3` | `11` / `00` | `10` / `01` | `10` / `01` | `100` / `011` | `111` / `000` |
| `m4` | — | `11` / `00` | `110` / `001` | `101` / `010` | `000` / `111` |
| `m5` | — | — | `111` / `000` | `110` / `001` | `001` / `110` |
| `m6` | — | — | — | `111` / `000` | `010` / `101` |
| `m7` | — | — | — | — | `011` / `100` |
| **期望藏量 EC<sub>n</sub>** | **1.50** | **2.00** | **2.25** | **2.50** | **2.75** |

</div>

<div>
<div class="card teal">
<h3>平衡前綴碼條件與期望藏量</h3>
<div class="eq-box">
⌊log<sub>2</sub> n⌋ ≤ #(m<sub>u</sub>) ≤ ⌈log<sub>2</sub> n⌉ &nbsp;&nbsp;（式 4）<br>
EC<sub>n</sub> = ∑ #(m<sub>u</sub>) × P<sub>u</sub> &nbsp;&nbsp;（式 5）<br>
EC<sub>n</sub> = ⌊log<sub>2</sub> n⌋ − 1 + n / 2<sup>⌊log<sub>2</sub> n⌋</sup> （式 6）
</div>
<ul class="small-text">
  <li><strong>平衡樹最大化藏量：</strong>當 <code>n = 4</code> 時，平衡集 <code>{00, 01, 10, 11}</code> 期望藏量為 <code>2.00 bpp</code>，優於不平衡集 <code>{0, 100, 101, 11}</code> 之 <code>1.75 bpp</code>。</li>
  <li><strong>位元主導性配對：</strong>若位元 <code>1</code> 居多則選 <code>DEM<sub>1</sub>(n)</code>（因 <code>#DEM<sub>1</sub>(3,1) = 3 &gt; 2</code>），若位元 <code>0</code> 居多則選 <code>DEM<sub>0</sub>(n)</code>。</li>
  <li><strong>對稱特例（n = 7）：</strong>兩表皆含 10 個 1 與 10 個 0，任選其一皆可。</li>
</ul>
</div>
</div>
</div>

<!--
DEM 建構與數學推導（第 3 節、表 1、式 4–6）：
基本訊息目錄（DEM）是一組大小為 n 的完整前綴碼（prefix-free code），可由遞迴展開葉節點 m_u 為 m_u0 與 m_u1 構成。為使隨機二進位訊息獲得最大期望藏量 EC_n，任意兩個碼字的位元長度差必須至多為 1，即滿足式 (4)：⌊log2 n⌋ <= #(m_u) <= ⌈log2 n⌉。
式 (6) 推導：令 L = ⌊log2 n⌋，平衡前綴碼會將 (n − 2^L) 個長度為 L 的節點分裂為 2(n − 2^L) 個長度為 L+1 的碼字，並保留 (2^{L+1} − n) 個長度為 L 的碼字。因長度 L 與 L+1 碼字出現機率分別為 2^{-L} 與 2^{-(L+1)}，故：
EC_n = (2^{L+1} − n) * L * 2^{-L} + 2(n − 2^L) * (L+1) * 2^{-(L+1)} = L − 1 + n / 2^L bpp。
由此得到精細的藏量階梯：n=3 ➔ 1.5、n=4 ➔ 2.0、n=5 ➔ 2.25、n=6 ➔ 2.5、n=7 ➔ 2.75、n=8 ➔ 3.0、n=9 ➔ 3.125、n=10 ➔ 3.25、n=11 ➔ 3.375、n=13 ➔ 3.625、n=15 ➔ 3.875 bpp。
-->

---

## 3. 最近鄰像素調整與雙區段嵌入演算法

<div class="two-col">
<div class="card">
<h3>像素值調整公式（式 2–3）</h3>
<div class="eq-box">
b'<sub>i</sub> = b<sub>i</sub> − (b<sub>i</sub> mod n) + u − 1 &nbsp;&nbsp;（式 2）<br>
b''<sub>i</sub> = b'<sub>i</sub> + n &nbsp; 若 b<sub>i</sub> − b'<sub>i</sub> &gt; n/2 且 b'<sub>i</sub> ≤ 255−n<br>
b''<sub>i</sub> = b'<sub>i</sub> − n &nbsp; 若 (b'<sub>i</sub> − b<sub>i</sub> &gt; n/2 且 b'<sub>i</sub> ≥ n) 或 b'<sub>i</sub> &gt; 255<br>
b''<sub>i</sub> = b'<sub>i</sub> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 其他情形 &nbsp;&nbsp;（式 3）
</div>
<ul class="small-text">
  <li><strong>奇數 n：</strong>採用對稱鄰域 <code>{b<sub>i</sub>−⌊n/2⌋, ..., b<sub>i</sub>+⌊n/2⌋}</code>。</li>
  <li><strong>偶數 n：</strong>採用包含 <code>b<sub>i</sub></code> 的連續 <code>n</code> 個值（非過飽和時誤差皆 <code>≤ ⌊n/2⌋</code>）。</li>
  <li><strong>尾端補齊策略：</strong>若 <code>M''<sub>n−1</sub></code> 最後一段不足完整碼字，補齊為使該像素變動最小的 DEM 碼字。</li>
</ul>
</div>

<div class="card accent">
<h3>八步驟適應性嵌入與擷取流程</h3>
<ol class="small-text">
  <li>計算 <code>C = #(M)/N</code>；若 <code>C ≤ 1.5</code> 選 <code>n = 3</code>，否則選 <code>EC<sub>n</sub> ≤ C &lt; EC<sub>n+1</sub></code>。</li>
  <li>依主導位元 <code>t</code> 選 <code>DEM<sub>t</sub>(n)</code>，將 <code>M</code> 分解為 <code>M<sub>n</sub></code>。</li>
  <li>若 <code>|M<sub>n</sub>| &gt; N</code>，令 <code>n ← n + 1</code> 並重新分解。</li>
  <li>切分 <code>M = M'<sub>n</sub> ∥ M''<sub>n−1</sub></code>，使 <code>|M'<sub>n</sub>| + |M''<sub>n−1</sub>| ≤ N</code> 且最小化 <code>|M'<sub>n</sub>| ≈ N × (C − EC<sub>n−1</sub>)/(EC<sub>n</sub> − EC<sub>n−1</sub>)</code>。</li>
  <li>依序以 <code>DEM<sub>t</sub>(n)</code> 嵌入 <code>M'<sub>n</sub></code>，再以 <code>DEM<sub>t</sub>(n−1)</code> 嵌入 <code>M''<sub>n−1</sub></code>。</li>
  <li>保存輔助參數：<code>n, |M'<sub>n</sub>|, |M''<sub>n−1</sub>|, #(M), DEM<sub>t</sub>(n), DEM<sub>t</sub>(n−1)</code>。</li>
</ol>
<div class="eq-box" style="margin-top: 6px;">
擷取（式 7–8）：u' = b''<sub>i</sub> mod n（i &lt; |M'<sub>n</sub>|）否則 mod (n−1)；u = u' + 1
</div>
</div>
</div>

<!--
演算法細節與邊界保護機制（第 3 節，式 2–3 與 7–8）：
式 (3) 包含兩項關鍵安全設計：
1. 過飽和（oversaturation）防護：當像素值接近 255 且 u−1 > b_i mod n 時，式 (2) 可能暫時產生 b'_i > 255，式 (3) 強制減去 n 以確保偽裝像素嚴格位於 [0, 255]；同理，加 n 需檢查 b'_i <= 255 − n，減 n 需檢查 b'_i >= n。
2. 雙區段（n 與 n−1）設計動機：當實際藏量 C 介於 EC_{n-1} 與 EC_n 之間，或因位元排列使 |M_n| > N 而遞增 n 時，若全部像素都使用模數 n，不僅會浪費尾端像素，也會讓所有使用像素承受較大的 ⌊n/2⌋ 誤差上界。透過最小化 |M'_n| 與最大化 |M''_{n-1}|，可將絕大多數像素壓回較小的 ⌊(n−1)/2⌋ 誤差範圍內。當 n = 3 時，則令 |M''_2| = 0。
-->

---

## 3. 位元排列效應與 4×4 灰階影像實例演練

<div class="split55">
<div>
<div class="fig-box" style="margin-bottom: 10px;">
<img src="./img/fig2_capacity.png" alt="圖 2：n=3 時不同位元排列之藏量範例" style="max-height: 120px;">
<div class="fig-cap">圖 2（論文第 7 頁）：同樣 8 像素與 DEM<sub>0</sub>(3) = {1, 01, 00}，不同位元排列可達 1.75、1.50 或 1.375 bpp。</div>
</div>

<div class="card teal">
<h3>完整範例：4×4 影像嵌入 25 位元</h3>
<ul class="small-text">
  <li><strong>訊息：</strong><code>M = (0110110101100011100101101)<sub>2</sub></code>，<code>C = 25/16 = 1.5625 bpp</code>。</li>
  <li><strong>步驟 2–4：</strong>位元 <code>1</code> 居多 ➔ <code>DEM<sub>1</sub>(3)</code> 拆出 <code>|M<sub>3</sub>| = 17 &gt; 16</code> ➔ 遞增為 <code>n = 4</code>。</li>
  <li><strong>雙區段切分：</strong><code>|M'<sub>4</sub>| = 1</code>（<code>s<sub>0</sub> = 01</code>）與 <code>|M''<sub>3</sub>| = 15</code>（<code>s<sub>1</sub>..s<sub>15</sub></code>，末段補 <code>0</code> 成 <code>10</code> 使第 15 像素 <code>43</code> 維持零改動！）。</li>
  <li><strong>結果：</strong>16 像素藏入 25 位元，<strong>僅 9 個像素變動且幅度皆為 ±1</strong>。</li>
</ul>
</div>
</div>

<div class="fig-box">
<img src="./img/fig3_example.png" alt="圖 3：4x4 原始影像與偽裝影像" style="max-height: 350px;">
<div class="fig-cap">圖 3（論文第 8 頁）：(a) 原始 4×4 灰階影像；(b) 偽裝影像（粗體為僅有之 9 個變動像素，皆 ±1）。擷取：像素 0 得 45 mod 4 = 1 ➔ DEM<sub>1</sub>(4) 之 m<sub>2</sub> = "01"；像素 1 得 46 mod 3 = 1 ➔ DEM<sub>1</sub>(3) 之 m<sub>2</sub> = "10"。</div>
</div>
</div>

<!--
實例逐步驗證（第 3 節，圖 2 與圖 3）：
圖 2 說明為何步驟 4 必須檢查 |M_n| > N：即使同樣採用 DEM_0(3) = {m1=1, m2=01, m3=00} 且位元 0 居多，8 個像素在不同排列下可能剛好容納 14 位元（1.75 bpp）、12 位元（1.50 bpp）或 11 位元（1.375 bpp）。但在大量隨機位元串下，長期平均會精準收斂至理論期望值 EC_n。

圖 3 範例中，25 位元訊息含 14 個 1 與 11 個 0（故 t = 1）。影像由左至右、由上而下掃描：像素 0（值 45）以 DEM_1(4) 嵌入 s_0 = "01"（u = 2），計算 45 − (45 mod 4) + 1 = 45（零改動）；像素 1（值 47）以 DEM_1(3) 嵌入 s_1 = "10"（u = 2），計算 47 − (47 mod 3) + 1 = 46（減 1）；最後一個像素 15（值 43）剩下單一位元 "1"，因 43 mod 3 = 1 對應 u = 2（"10"），故補齊位元 "0" 即可讓像素 43 完全不需修改。
-->

---

## 4. 實驗設定與標準測試影像

<div class="fig-box" style="margin-bottom: 12px;">
<img src="./img/fig4_test_images.png" alt="圖 4：四張 512x512 灰階測試影像" style="max-height: 230px;">
<div class="fig-cap">圖 4（論文第 9 頁）：四張 512 × 512 × 8 位元標準灰階宿主影像（N = 262,144 像素）— (a) Lena；(b) Baboon；(c) Airplane；(d) Pepper。</div>
</div>

<div class="three-col">
<div class="kpi-card">
  <div class="kpi-val">Java · Win XP</div>
  <div class="kpi-label">於相同硬體與開發平台實作本演算法、簡單 LSB 取代與 OPAP [9]，確保公平比較。</div>
</div>
<div class="kpi-card teal">
  <div class="kpi-val">每組 100 次隨機</div>
  <div class="kpi-label">表 2–4 所有 PSNR 數據均為嵌入 100 組獨立隨機二進位訊息之平均值。</div>
</div>
<div class="kpi-card accent">
  <div class="kpi-val">PSNR（dB）</div>
  <div class="kpi-label"><code>10 × log<sub>10</sub>(255² / MSE)</code>，其中 <code>MSE = (1 / r×c) ∑ (α(i,j) − β(i,j))²</code>。</div>
</div>
</div>

<!--
實驗方法論（第 4 節）：
實驗選用四張涵蓋平滑至高紋理之經典 512×512 灰階影像（Lena、Baboon、Airplane、Pepper，每張 262,144 像素）。為消除單一隨機位元排列造成的變異，每一組藏量設定皆重複產生 100 筆隨機二進位訊息並取 PSNR 平均值。針對 LSB 與 OPAP 基準在非整數藏量下的公平設定，作者採用 k = q * k_i + q' * k_j（其中 q + q' = 1，例如 2.25 bpp 時 75% 像素嵌入 2 位元、25% 像素嵌入 3 位元），確保基準方法同樣充分利用全部像素以達其最佳畫質。
-->

---

## 4. 中低藏量效能比較：1.0 bpp 與 1.5 bpp（表 2 與表 3）

<div class="two-col">
<div>
<h3>表 2：藏量 = 1.0 bpp（262,144 位元）</h3>

| 宿主影像 | 簡單 LSB | OPAP [9] | **本方法（n = 3）** | 較 OPAP 增益 |
| :--- | :---: | :---: | :---: | :---: |
| **Lena** | 51.1414 | 51.1423 | **51.6559** | **+0.51 dB** |
| **Baboon** | 51.1426 | 51.1398 | **51.6527** | **+0.51 dB** |
| **Airplane** | 51.1381 | 51.1406 | **51.6593** | **+0.52 dB** |
| **Pepper** | 51.1415 | 51.1412 | **51.6563** | **+0.52 dB** |
| **平均** | 51.1409 | 51.1410 | **51.6561** | **+0.52 dB** |

<div class="callout teal" style="margin-top: 10px;">
<strong>為何 1.0 bpp 即可領先 +0.52 dB：</strong>採用 <code>n = 3</code> 僅需使用約 <code>174,763</code> 個像素，其中僅 2/3（<strong>116,509 像素</strong>）需改動 ±1，遠少於 LSB/OPAP 的 <strong>131,072 像素</strong>！
</div>
</div>

<div>
<h3>表 3：藏量 = 1.5 bpp（393,216 位元）</h3>

| 宿主影像 | LSB (`k=2`) | LSB (`k=1.5`) | OPAP (`k=2`) | OPAP (`k=1.5`) | **本方法 (`n=3`)** |
| :--- | :---: | :---: | :---: | :---: | :---: |
| **Lena** | 45.4020 | 46.3716 | 47.6256 | 48.1305 | **49.8916** |
| **Baboon** | 45.4068 | 46.3774 | 47.6252 | 48.1290 | **49.8917** |
| **Airplane** | 45.3947 | 46.3686 | 47.6180 | 48.1334 | **49.9012** |
| **Pepper** | 45.3950 | 46.3624 | 47.6262 | 48.1274 | **49.8938** |

<div class="callout" style="margin-top: 10px;">
<strong>1.5 bpp 展現最大優勢：</strong>本方法（<code>n = 3</code>）在四張影像皆達 <strong>49.89 dB</strong>，較最佳 OPAP（<code>k = 1.5</code>）高出 <strong>+1.76 dB</strong>，較最佳 LSB 高出 <strong>+3.52 dB</strong>。
</div>
</div>
</div>

<!--
表 2 與表 3 數據深度解讀（第 4 節，頁 9–10）：
表 2（1.0 bpp，262,144 位元）：在 LSB 與 OPAP（k = 1）中，全部 262,144 個像素皆須嵌入 1 位元，期望有一半（131,072 像素）會變動 ±1，對應 MSE ≈ 0.500、PSNR ≈ 51.14 dB。反觀本方法選用 n = 3（平均每像素藏 1.5 位元），僅需動用 262,144 / 1.5 ≈ 174,763 個像素，且每個使用像素有 1/3 機率維持不變、2/3 機率變動 ±1，故僅約 116,509 像素變動 ±1（MSE ≈ 0.4444、PSNR ≈ 51.66 dB）。
表 3（1.5 bpp，393,216 位元）：基準方法測試兩種配置——k = 2（使用 0.75N 像素各藏 2 位元）與 k = 1.5（前半像素藏 2 位元、後半像素藏 1 位元）。即使採用較優的 k = 1.5，OPAP 仍有半數像素面臨 ±2 誤差，使 PSNR 止步於 48.13 dB；而本方法 n = 3 將所有像素誤差壓制於 ±1 內，穩定達到 49.89–49.90 dB。
-->

---

## 4. 中高藏量效能比較：2.0–3.875 bpp（表 4）

<div class="split64">
<div class="fig-box">
<img src="./img/diag2_psnr_chart.svg" alt="Lena 於 1.0 至 3.875 bpp 之 PSNR 曲線比較" style="max-height: 390px;">
<div class="fig-cap">Lena 影像於 1.0–3.875 bpp 之 PSNR 曲線（表 2–4）：適應性 DEM 全面勝過簡單 LSB，並在所有非整數藏量勝過 OPAP。</div>
</div>

<div>
<h3>表 4 重點摘錄（Lena，單位：dB）</h3>

| 藏量 (bpp) | `n` | LSB | OPAP | **本方法** | 較 OPAP 增益 |
| :---: | :---: | :---: | :---: | :---: | :---: |
| **2.000** | 4 | 44.15 | 46.37 | **46.37** | 0.00 dB |
| **2.250** | 5 | 41.60 | 44.15 | **45.12** | **+0.97 dB** |
| **2.500** | 6 | 40.01 | 42.69 | **43.12** | **+0.43 dB** |
| **2.750** | 7 | 38.84 | 41.60 | **42.11** | **+0.51 dB** |
| **3.000** | 8 | 37.92 | 40.73 | **40.73** | 0.00 dB |
| **3.125** | 9 | 36.51 | 39.38 | **39.89** | **+0.51 dB** |
| **3.375** | 11 | 34.58 | 37.52 | **38.13** | **+0.61 dB** |
| **3.625** | 13 | 33.25 | 36.23 | **36.68** | **+0.45 dB** |
| **3.875** | 15 | 32.23 | 35.23 | **35.42** | **+0.18 dB** |

</div>
</div>

<!--
表 4 數據分析（第 4 節，頁 10–11）：
在 Lena、Baboon、Airplane、Pepper 四張影像上，同一藏量下的 PSNR 幾乎完全一致（跨影像差異小於 0.03 dB），證明失真度幾乎完全由模數 n 決定而無關影像紋理複雜度。
關鍵觀察：
- 在精確 2 的冪次（2.0 bpp 對應 n = 4；3.0 bpp 對應 n = 8）時，DEM 所有碼字長度均固定為 k = 2 或 3，式 (2)–(3) 在數學上與 Chan–Cheng OPAP 完全等價（分別為 46.37 dB 與 40.73 dB）。
- 在所有非整數藏量（n = 5, 6, 7, 9, 10, 11, 13, 15）中，本方法穩定勝過 OPAP +0.18 至 +0.97 dB，且領先簡單 LSB 達 +2.2 至 +3.5 dB；其中以剛跨越 2 冪次邊界之奇數 n 增益最顯著（如 n = 5 在 2.25 bpp 領先 +0.97 dB、n = 11 在 3.375 bpp 領先 +0.61 dB）。
-->

---

## 4. 低失真機制深度解析：為何適應性 DEM 勝出？

<div class="three-col">
<div class="card">
<h3>1. 避免誤差平方放大效應</h3>
<p class="small-text">由於 MSE 與像素誤差的<strong>平方</strong> <code>(Δb)<sup>2</sup></code> 成正比，避免跨入 <code>k+1</code> 位元能帶來顯著的 PSNR 紅利：</p>
<ul class="small-text">
  <li><strong>2.25 bpp：</strong>OPAP 混用 75% <code>k=2</code>（<code>|Δb| ≤ 2</code>）與 25% <code>k=3</code>（<code>|Δb| ≤ 4</code>，平方誤差高達 <strong>16</strong>）。</li>
  <li>本方法用 <code>n = 5</code>：全圖皆 <code>|Δb| ≤ 2</code>（平方誤差上限僅 <strong>4</strong>）➔ 勝出 <strong>+0.97 dB</strong>！</li>
</ul>
</div>

<div class="card teal">
<h3>2. 奇數 n 的對稱鄰域優勢</h3>
<p class="small-text">奇數 <code>n</code>（3, 5, 7, 9, 11, 13, 15）以原始像素 <code>b<sub>i</sub></code> 為絕對中心展開：</p>
<ul class="small-text">
  <li><code>n = 3</code>：<code>{−1, 0, +1}</code> ➔ 理論 MSE = <code>2/3 = 0.667</code>。</li>
  <li><code>n = 5</code>：<code>{−2, −1, 0, +1, +2}</code> ➔ 理論 MSE = <code>10/5 = 2.00</code>。</li>
  <li>偶數 <code>n</code> 存在不對稱尾端誤差，故奇數 <code>n</code> 在曲線上展現最明顯的領先峰值。</li>
</ul>
</div>

<div class="card accent">
<h3>3. 跨影像紋理之高度穩定性</h3>
<p class="small-text">不同於 PVD 或區塊配對法會因影像平滑度而劇烈波動：</p>
<ul class="small-text">
  <li><strong>1.5 bpp PSNR：</strong>Lena <code>49.89</code>、Baboon <code>49.89</code>、Airplane <code>49.90</code>、Pepper <code>49.89 dB</code>。</li>
  <li><strong>2.25 bpp PSNR：</strong>四張影像皆穩定落於 <code>45.12–45.13 dB</code>。</li>
  <li>對平滑圖與高紋理圖、任意二進位訊息皆具一致保證。</li>
</ul>
</div>
</div>

<div class="callout teal">
<strong>理論核心總結：</strong>以平衡前綴碼構成之任意整數 <code>n</code> 元量化取代傳統 <code>2<sup>k</sup></code> 量化，徹底消弭粗粒度位元切換所造成的二次方 MSE 懲罰。
</div>

<!--
理論失真公式與實測數據對照：
假設像素值對 n 取餘數呈均勻分布，最近鄰像素調整的理論期望 MSE 具封閉解：
- 奇數 n = 2m + 1：MSE(n) = (n^2 − 1) / 12。
  代入 n = 3 得 MSE = 8/12 = 0.6667 ➔ PSNR = 10*log10(255^2 / 0.6667) = 49.89 dB（與表 3 完全吻合）。
  代入 n = 5 得 MSE = 24/12 = 2.0000 ➔ PSNR = 10*log10(255^2 / 2.0) = 45.12 dB（與表 4 完全吻合）。
- 偶數 n = 2m：MSE(n) = (n^2 + 2) / 12。
  代入 n = 4（OPAP k=2）得 MSE = 1.5000 ➔ 46.37 dB；n = 8（OPAP k=3）得 MSE = 5.5000 ➔ 40.73 dB。
反觀 OPAP 在 2.25 bpp 混用 k=2 與 k=3 時，期望 MSE = 0.75 * 1.5 + 0.25 * 5.5 = 2.5000（44.15 dB），明顯差於 n = 5 的 2.0000（45.12 dB）。此解析解完整解釋了表 2–4 的實測優勢。
-->

---

## 5. 結論與實務應用價值

<div class="three-col">
<div class="kpi-card teal">
  <div class="kpi-val">失真 ≤ ⌊n/2⌋</div>
  <div class="kpi-label">每個非過飽和宿主像素的改動幅度嚴格不超過 ⌊n/2⌋，提供極佳的偽裝影像視覺品質。</div>
</div>
<div class="kpi-card">
  <div class="kpi-val">最高 +1.76 dB</div>
  <div class="kpi-label">於非整數藏量全面勝過 OPAP（1.0、1.5、2.25–3.875 bpp），並領先簡單 LSB 達 2.2–3.5 dB。</div>
</div>
<div class="kpi-card accent">
  <div class="kpi-val">O(N) 通用二進位</div>
  <div class="kpi-label">單次掃描即可完成模數嵌入與擷取，無需預先假設秘密資料結構，適用任何二進位訊息。</div>
</div>
</div>

<div class="future-strip">
<div class="future-pill"><strong>1. 雙區段最佳化</strong><br>將 <code>M</code> 分割為最小化之 <code>M'<sub>n</sub></code> 與最大化之 <code>M''<sub>n−1</sub></code>，在用滿 <code>N</code> 個像素的同時將字母表大小 <code>n</code> 降至最低。</div>
<div class="future-pill"><strong>2. 精簡輔助資訊</strong><br>解碼端僅需 <code>n</code>、<code>|M'<sub>n</sub>|</code>、<code>|M''<sub>n−1</sub>|</code>、<code>#(M)</code> 與兩個 DEM 對應表（由 <code>n</code> 與主導位元 <code>t</code> 即可唯一決定）。</div>
<div class="future-pill"><strong>3. 實務應用定位</strong><br>特別適合對視覺品質要求極高且藏量隨任務動態變動之機密通訊、版權標記與影像註記系統。</div>
</div>

<!--
研究貢獻總結（第 5 節）：
1. 提出平衡前綴碼形式之基本訊息目錄 DEM_t(n) 與位元主導性選表機制，並推導封閉式期望藏量公式 EC_n = ⌊log2 n⌋ − 1 + n / 2^{⌊log2 n⌋}。
2. 設計雙區段適應性訊息分解（M = M'_n || M''_{n-1}）結合具過飽和保護之最近鄰模數調整（式 2–3），將像素誤差嚴格收斂於 ±⌊n/2⌋ 以內。
3. 透過四張 512×512 標準影像橫跨 1.0 至 3.875 bpp 之大量隨機訊息實驗，證實本方法在各種藏量下皆能提供比簡單 LSB 與 OPAP 更低失真的偽裝影像。
-->

---

<!-- _class: closing -->

# 感謝聆聽 · 敬請指教！

<p style="font-size: 1.05em; max-width: 860px;">
適應性影像二進位資料隱藏演算法（Adaptively Embedding Binary Data in an Image）
</p>

<div class="contact-card">
<strong>林清泉（Ching-Chiuan Lin）<sup>*</sup></strong> · <code>cclin@ocit.edu.tw</code><br>
<strong>薛念林（Nien-Lin Hsueh）</strong> · <code>nlhsueh@fcu.edu.tw</code> &nbsp;|&nbsp; <strong>沈文祥（Wen-Hsiang Shen）</strong> · <code>shen@ocit.edu.tw</code><br>
逢甲大學資訊工程學系（Department of Information Engineering and Computer Science, Feng Chia University）<br>
<span style="font-size: 0.85em; opacity: 0.88;">Fundamenta Informaticae，第 84 卷，頁 1–12，2008 年 · IOS Press</span>
</div>

<!--
論文書目資料：
- 篇名：Adaptively Embedding Binary Data in an Image（適應性影像二進位資料隱藏演算法）
- 作者：Ching-Chiuan Lin（通訊作者，cclin@ocit.edu.tw）、Nien-Lin Hsueh（nlhsueh@fcu.edu.tw）、Wen-Hsiang Shen（shen@ocit.edu.tw）
- 單位：逢甲大學資訊工程學系（Taichung 40724, Taiwan, ROC）
- 期刊：Fundamenta Informaticae 84 (2008) 1–12, IOS Press
- 關鍵字：Information hiding, LSB
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
