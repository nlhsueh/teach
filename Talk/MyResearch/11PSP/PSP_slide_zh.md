---
marp: true
theme: gaia
size: 16:9
paginate: true
html: true
header: '<div class="hdr-wrap"><span class="hdr-title">評估 PSP 訓練紀律化軟體開發之成效：Plan–Track–Review 評估模型</span><div class="hdr-actions"><a class="lang-btn" href="./PSP_slide.html" title="Switch to English Slides">🌐 EN</a><div class="nav-dropdown"><button class="nav-btn">章節導覽 ▾</button><div class="nav-menu"><a href="#2">簡報大綱</a><a href="#3">1. 研究動機與問題</a><a href="#5">2. Plan–Track–Review 模型</a><a href="#8">3. 實證研究設計</a><a href="#9">4. 實證結果與路徑分析</a><a href="#13">5. 討論與實務建議</a><a href="#14">6. 研究效度與結論</a></div></div></div></div>'
footer: '沈文祥（Wen-Hsiang Shen）、薛念林（Nien-Lin Hsueh）、李維曼（Wei-Mann Lee）· 逢甲大學 ＆ 僑光科大 · IST 2011'
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
.nav-menu a { display: block; padding: 7px 14px; color: var(--slate-700); text-decoration: none; font-size: 12.5px; font-weight: 500; line-height: 1.35; }
.nav-menu a:hover { background: var(--slate-100); color: var(--navy); }

footer { position: absolute; left: 54px; bottom: 14px; font-size: 12.5px; color: var(--slate-500); font-weight: 500; }
section::after {
  position: absolute;
  right: 54px;
  bottom: 14px;
  font-size: 12.5px;
  font-weight: 700;
  color: var(--navy);
  content: attr(data-marpit-pagination) ' / ' attr(data-marpit-pagination-total);
}

h1 { color: var(--navy); font-size: 1.65em; font-weight: 800; line-height: 1.26; margin: 0 0 12px 0; letter-spacing: 0 !important; }
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
  letter-spacing: 0 !important;
}
h3 { color: var(--accent); font-size: 0.96em; font-weight: 700; margin: 4px 0 6px 0; letter-spacing: 0 !important; }
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
  margin-bottom: 16px;
}
section.lead h1 { color: #ffffff; font-size: 1.85em; font-weight: 800; line-height: 1.28; margin-bottom: 10px; text-align: left; }
section.lead .en-title { color: #93c5fd; font-size: 0.85em; font-weight: 500; line-height: 1.4; margin-bottom: 14px; }
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
  margin: 6px 0;
  background: #ffffff;
  border: 1px solid var(--slate-200);
}
th { background: var(--navy); color: #ffffff; font-weight: 700; padding: 6px 9px; text-align: left; border: 1px solid var(--navy); }
td { padding: 5px 9px; border: 1px solid var(--slate-200); vertical-align: middle; line-height: 1.34; }
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
  overflow: visible;
  position: relative;
}
.fig-box img {
  max-width: 100%;
  height: auto;
  display: block;
  margin: 0 auto;
  border-radius: 4px;
  transition: transform 0.25s ease, box-shadow 0.25s ease;
  cursor: zoom-in;
}
.fig-box.is-zoomed { z-index: 45; }
.fig-box img.is-zoomed {
  position: relative;
  z-index: 46;
  box-shadow: 0 18px 44px rgba(15, 23, 42, 0.30);
  background: #ffffff;
}
.fig-cap { font-size: 0.72em; color: var(--slate-500); margin-top: 5px; font-weight: 500; }

.rq-card {
  display: flex;
  align-items: flex-start;
  gap: 14px;
  background: #ffffff;
  border: 1px solid var(--slate-200);
  border-left: 5px solid var(--navy);
  border-radius: 10px;
  padding: 13px 18px;
  margin-bottom: 12px;
  box-shadow: 0 2px 8px rgba(15, 23, 42, 0.06);
}
.rq-card.teal { border-left-color: var(--teal); }
.rq-card.accent { border-left-color: var(--accent); }
.rq-badge {
  background: var(--navy);
  color: #ffffff;
  font-weight: 800;
  font-size: 0.82em;
  padding: 5px 11px;
  border-radius: 6px;
  flex-shrink: 0;
}
.rq-card.teal .rq-badge { background: var(--teal); }
.rq-card.accent .rq-badge { background: var(--accent); }
.rq-hook { font-size: 0.92em; font-weight: 800; color: var(--navy); margin-bottom: 3px; }
.rq-card.teal .rq-hook { color: var(--teal); }
.rq-card.accent .rq-hook { color: var(--accent); }
.rq-q { font-size: 0.82em; color: var(--slate-700); line-height: 1.44; }

.small-text { font-size: 0.82em; }

@media print {
  .lang-btn, .nav-dropdown { display: none !important; }
}
</style>

<!-- _class: lead -->

<div class="badge">Information and Software Technology (IST) · 第 53 卷 137–148 頁 · 2011</div>

# 評估 PSP 訓練紀律化軟體開發之成效：Plan–Track–Review 評估模型

<div class="en-title">Assessing PSP Effect in Training Disciplined Software Development: A Plan–Track–Review Model</div>

<div class="subtitle">
串聯核心<strong>軟體工程價值</strong>與<strong>九項關鍵 PSP 度量指標</strong>，結合階段式評估框架、平均數／中位數雙軌分析與跨階段路徑模型
</div>

<div class="meta-box">
<strong>沈文祥（Wen-Hsiang Shen）</strong><sup>a</sup>、<strong>薛念林（Nien-Lin Hsueh）</strong><sup>a</sup>、<strong>李維曼（Wei-Mann Lee）</strong><sup>b,*</sup><br>
<sup>a</sup> 逢甲大學資訊工程學系 · <sup>b</sup> 僑光科技大學資訊科技系<br>
<code>shen@ocu.edu.tw</code> · <code>nlhsueh@fcu.edu.tw</code> · <code>dwl@ocu.edu.tw</code>
</div>

<div class="grant">
DOI: 10.1016/j.infsof.2010.09.004 · 2009 年 11 月收稿 · 2010 年 9 月接受 · 2011 年刊出（Elsevier B.V.）
</div>

<!--
論文書目與研究背景：
本論文發表於 Information and Software Technology（IST, Vol. 53, pp. 137-148, 2011），由逢甲大學沈文祥、薛念林與僑光科技大學李維曼（通訊作者）共同撰寫。研究聚焦於個人軟體流程（Personal Software Process, PSP）在培養紀律化軟體開發能力上的成效評估問題。

核心研究貢獻：
1. 透過系統性文獻回顧建構「Plan-Track-Review」三階段評估模型，將九項關鍵 PSP 度量指標（SEA、TEA、APR；DEA、DRR、YLD；DDS、LPH、AFR）與可量測性、可預測性、可控性、可管理性、可靠性及效率等軟體工程價值完整對應。
2. 採用更嚴格的絕對值估算準確度公式與統一六步驟評估程序，結合平均數參數檢定（t 檢定與 ANOVA）及抗極端值之中位數改進因子（MIF），並對照外部學術與業界基準（Wesslen 2000；Hayes & Over 1997）。
3. 以 18 週研究所 PSP 專課（16 位研究生、160 份完整作業）進行實證，發現 Track 階段品質控制成效顯著、Plan 階段規模估算需較長學習曲線，並透過迴歸與準路徑分析證實前期階段對後期品質與效率具跨階段延續效應。
-->

---

## 簡報大綱

<div class="outline-grid">
<div class="outline-item"><div class="outline-num">1</div><div class="outline-body"><a href="#3">研究動機與研究問題</a><br>PSP 評估碎片化現象、三大方法論困境與三項核心研究問題。</div></div>
<div class="outline-item"><div class="outline-num">2</div><div class="outline-body"><a href="#5">Plan–Track–Review 評估框架</a><br>PSP 生命週期階段、九項指標對應工程價值與六步驟統一程序。</div></div>
<div class="outline-item"><div class="outline-num">3</div><div class="outline-body"><a href="#8">實證研究設計與資料稽核</a><br>18 週研究所課程（N = 16、160 份作業）、三組資料集與零錯誤檢核。</div></div>
<div class="outline-item"><div class="outline-num">4</div><div class="outline-body"><a href="#9">實證結果與路徑分析</a><br>箱形／折線趨勢、ANOVA、跨階段迴歸（R<sup>2</sup> 高達 0.949）與外部基準比較。</div></div>
<div class="outline-item"><div class="outline-num">5</div><div class="outline-body"><a href="#13">討論、問卷調查與業界應用</a><br>學生採納落差（程式碼審查 80% vs. 規模量測 20%）、PROBE 門檻與裁剪建議。</div></div>
<div class="outline-item"><div class="outline-num">6</div><div class="outline-body"><a href="#14">研究效度威脅與結論</a><br>內外部效度控制、核心貢獻總結與後續複製研究展望。</div></div>
</div>

<div class="callout teal">
<strong>核心發現預覽：</strong>PSP 訓練對軟體工程師的<strong>缺陷可控性、流程可管理性與產品可靠性</strong>（Track 與 Review 階段，<code>p ≤ 0.015</code>）具高度正向顯著成效；相對地，<strong>專案規模與時程可預測性</strong>（Plan 階段）需更長學習週期，但前期階段表現仍顯著影響後期品質與生產力。
</div>

<!--
論文結構導覽：
- 第 1 節（緒論，pp. 137-138）：指出既有 PSP 成效評估缺乏系統性機制，提出三項核心研究問題。
- 第 2 節（理論架構，pp. 138-140）：連結 PSP 與 CMM/ISO9001 標準，將 PSP 生命週期劃分為 Plan-Organize、Track-Manage、Review-Optimize 三階段，定義九項核心指標（表 1、表 2）並剖析三大評估困境（表 3）。
- 第 3 節（研究方法，pp. 140-141）：說明 2008 年秋季研究所課程設計、絕對值正規化公式、t 檢定／ANOVA、迴歸與準路徑分析，以及統一六步驟評估程序。
- 第 4 節（研究結果，pp. 142-145）：呈現圖 2-6 趨勢圖、表 4 ANOVA、表 5 迴歸模型、圖 7 準路徑圖與表 6 綜合評估報表。
- 第 5 節（討論，pp. 146-147）與附錄 A（表 7-8）：探討效度威脅、估算不顯著原因、教學觀察、學生問卷與業界導入策略。
- 第 6 節（結論，p. 147）：總結學術與教學價值，呼籲更多實證複製研究。
-->

---

## 1. 研究動機與評估方法論困境

<div class="two-col">
<div class="card">
<h3>PSP 訓練的效益與推廣阻力</h3>
<ul>
<li><strong>已驗證之 SPI 效益：</strong>提升專案估算準確度、降低缺陷數、提早發現缺陷並提升生產力，適用大學部、研究所與業界。</li>
<li><strong>實務導入摩擦：</strong>人工記錄繁瑣、資料易出錯（既有研究約 5% 有誤）、教師批改負荷重，且完整兩週訓練對業界成本偏高。</li>
<li><strong>評估視角碎片化：</strong>專案管理研究偏重估算指標，軟體品質研究偏重缺陷指標，缺乏連結<strong>工程價值</strong>的整體評估模型。</li>
</ul>
</div>
<div class="card accent">
<h3>既有文獻之三大評估困境</h3>
<ul>
<li><strong>1. 比較範圍與層級：</strong>PSP3 僅含 1 份作業（10A），因此以 <code>PSP0 vs. PSP2</code> 階段彙總平均比較更具統計合理性。</li>
<li><strong>2. 估算準確度公式不一致：</strong>Humphrey 用 <code>(實際 − 計畫) / 計畫</code>，Hayes 符號相反，Prechelt 用比值；含正負號加總會導致高估 −300% 與低估 +200% 相互抵銷！</li>
<li><strong>3. 判定門檻分歧：</strong>統計顯著性、經驗門檻（如 <code>AFR &gt; 2</code>、<code>YLD ≥ 40%</code>）與中位數改進因子（MIF）各行其是。</li>
</ul>
</div>
</div>

<div class="callout">
<strong>本研究之方法論突破：</strong>採用更嚴格的<strong>絕對值估算準確度公式</strong>（<code>|實際 − 計畫| / 計畫</code>），並結合<strong>平均數檢定與中位數基準</strong>，徹底避免正負抵銷與極端值扭曲。
</div>

<!--
動機與方法論困境深層解析（第 1 節與第 2.5 節）：
自 1995 年 Humphrey 於 SEI 提出 PSP 以來，大量研究證實其軟體流程改善（SPI）潛力，但推廣始終受限於繁瑣記錄導致動機下降與資料真實性受損（Johnson & Disney 1999 指出約 5% 資料有缺陷）。

三大評估困境細節：
1. 區間選擇：PSP0 至 PSP2 各包含多份作業（1A-3A、4A-6A、7A-9A），而 PSP3 僅有單一循環整合練習 10A。採階段彙總平均（repeated measures）比較 PSP0 與 PSP2 可顯著提升統計檢定力（Dyba et al. 2006）。
2. 正負抵銷陷阱：若學生在某作業高估 300%（-300%）而在另一作業低估 200%（+200%），傳統有號公式會算出 -100%，掩蓋了總計 500% 的偏離誤差。改採絕對值（Hayes 1997 首提、Wesslen 2000 實作）符合工業界嚴格標準，且使「趨近於零」成為一致的改善方向。
3. 多元基準整合：同時結合趨勢準則（表 3）、參數統計顯著性與代表過半數學生表現的中位數改進因子（MIF），兼顧嚴謹檢定與直覺化教學回饋。
-->

---

## 1. 核心研究問題

<div class="rq-card">
<div class="rq-badge">RQ 1</div>
<div>
<div class="rq-hook">系統化評估途徑與軟體工程目標</div>
<div class="rq-q">應採取何種方式探討 PSP 訓練成效議題？PSP 訓練究竟能達成哪些明確的軟體工程目標？</div>
</div>
</div>

<div class="rq-card teal">
<div class="rq-badge">RQ 2</div>
<div>
<div class="rq-hook">軟體工程價值與關鍵指標選取</div>
<div class="rq-q">應選用哪些軟體工程價值與對應的 PSP 度量指標，方能完整評估各階段的訓練成效？</div>
</div>
</div>

<div class="rq-card accent">
<div class="rq-badge">RQ 3</div>
<div>
<div class="rq-hook">精確評估方法與有意義之教學回饋</div>
<div class="rq-q">如何精確評估這些指標，並將分析結果轉譯為對 PSP 教師與學生皆具參考價值的具體回饋？</div>
</div>
</div>

<div class="callout">
<strong>與工業界標準對齊（第 2.1 節）：</strong>比照 CMM 與 ISO 9001「說你所做、做你所說」之核心精神，PSP 能在個人層級直接落實關鍵 SPI 六大要素中的四項：<strong>預算、時程、品質與生產力</strong>（顧客與員工滿意度則屬長期 TSP/TQM 範疇）。
</div>

<!--
研究範疇與理論定位（第 1 節與第 2.1 節）：
三項研究問題與全文架構一一對應：
- RQ1：將 PSP 演進式生命週期收斂為 Plan-Organize、Track-Manage、Review-Optimize 三大階段，與 Boehm 螺旋模型及 Deming PDCA 品質循環高度呼應。
- RQ2：從 Humphrey 的三項基礎度量（規模、時間、缺陷）篩選出九項核心衍生指標，逐一對應六大軟體工程價值（表 1），並依階段分層為入門、中階、結業指標（表 2）。
- RQ3：提出六步驟統一評估程序（第 3.5 節）與雙軌綜合報表（表 6），同時對照班級內部同儕中位數與外部學術／業界常模。

排除指標說明（第 2.3 節）：
個人程式設計能力、先備軟體工程知識與審查速率（LOC/hr）因既有文獻顯示其在 SPI 評估中不顯著，或難以在單一 PSP 週期內訓練養成，故排除於本評估模型之外。
-->

---

## 2. PSP 生命週期與階段式視角

<div class="split64">
<div class="small-text">
<ul>
<li><strong>計畫—組織階段（PSP0 ➔ PSP1）：</strong>建立需求定義、程式規範、規模／時間估算（PROBE）與時程規劃，培養<strong>可量測性與可預測性</strong>。</li>
<li><strong>追蹤—管理階段（PSP1 ➔ PSP2）：</strong>記錄編碼、編譯與測試期間的缺陷數量、類型與注入／移除階段，培養<strong>可追蹤性、可控性與可管理性</strong>（對應個人版 CMM Level 2）。</li>
<li><strong>審查—最佳化階段（PSP2 ➔ PSP3）：</strong>落實設計審查、程式碼審查與事後檢討，培養<strong>流程可靠性與效率</strong>（邁向 CMM Level 5 最佳化層級）。</li>
</ul>
<div class="callout">
刻意區隔 <strong>Track（追蹤）</strong>與 <strong>Review（審查）</strong>兩階段，有助於釐清缺陷管控紀律與審查驅動最佳化各自帶來的成效。
</div>
</div>
<div class="fig-box">
<img src="./img/fig1_psp_lifecycle.png" alt="圖 1 PSP 生命週期階段" style="max-height: 390px;">
<div class="fig-cap">圖 1. PSP 生命週期演進階段（PSP0 至 PSP3；引自 Shen et al., 2011）。</div>
</div>
</div>

<!--
PSP 生命週期演進細節（第 2.2 節與圖 1）：
圖 1 展示 Humphrey 所定義的四層 PSP 演進架構：
- PSP0（基準個人流程）：現有開發流程、時間與缺陷記錄表、缺陷類型標準；PSP0.1 加入程式規範、規模量測與流程改善提案（PIP）。
- PSP1（個人規劃流程）：引入 PROBE 規模估算與測試報告；PSP1.1 加入任務與時程規劃。
- PSP2（個人品質管理）：引入程式碼審查與設計審查檢核表；PSP2.1 加入設計樣板。
- PSP3（循環個人流程）：透過循環式增量整合擴展至較大型程式開發。

與既有文獻對照（第 2.4 節）：
相較於 Hayes 的細粒度分段，Plan-Track-Review 模型更為精簡直覺，不僅呼應 Hilburn 的教學階段劃分，更有助於在成效歸因時釐清教師、學員與 PSP 工具本身之貢獻。
-->

---

## 2. Plan–Track–Review 三階段評估模型

<div class="fig-box" style="padding: 6px 8px;">
<img src="./img/diag_ptr_framework.svg" alt="Plan-Track-Review 三階段評估模型" style="max-height: 410px;">
</div>

<div class="callout teal">
<strong>漸進式三層指標設計（表 2）：</strong>每階段均配置<strong>入門（Entry）</strong>、<strong>中階（Intermediate）</strong>與<strong>結業（Exit）</strong>指標。本研究新納入之 <code>APR</code>（實耗／計畫時間比，借鏡 Prechelt 與 Humphrey 實獲值概念）作為計畫階段結業指標；<code>AFR</code> 則總結整體 PSP 品質效率。
</div>

<!--
九項 PSP 指標定義與工程價值對應（第 2.3 節、表 1 與表 2）：
九項指標皆由規模、時間、缺陷三項基礎度量衍生：
1. Plan 階段：
   - SEA（入門）：規模估算準確度 -> 衡量軟體規模之能力 -> 可量測性（Measurability）。
   - TEA（中階）：時間估算準確度 -> 預測開發時間之能力 -> 可預測性（Predictability）。
   - APR（結業）：實際／計畫時間比 -> 如期達成專案期限之能力 -> 可預測性／可控性（本研究自建）。
2. Track 階段：
   - DEA（入門）：缺陷估算準確度 -> 預測缺陷頻率之能力 -> 可預測性／可追蹤性。
   - DRR（中階）：編譯與測試階段缺陷移除率 -> 降低編譯與測試缺陷之能力 -> 可控性（Controllability）。
   - YLD（結業）：產出率（首次編譯前注入且於編譯前移除之缺陷比例） -> 編譯前控制缺陷之能力 -> 可管理性（Manageability）。
3. Review 階段：
   - DDS（入門）：總缺陷密度（每千行程式碼移除缺陷數） -> 降低缺陷密度之能力 -> 可靠性（Reliability）。
   - LPH（中階）：生產力（新增與修改 LOC 除以總開發小時） -> 提升生產力之能力 -> 效率（Efficiency）。
   - AFR（結業）：評估失敗比（設計與程式審查時間佔編譯與測試時間之比例） -> 管理風險之能力 -> 可靠性／效率。
-->

---

## 2. 趨勢判定準則與統一六步驟評估程序

<div class="split55">
<div>
<h3>九項指標趨勢判定準則（表 3）</h3>

| 預期改善趨勢 | 對應指標 | 判定意涵 |
| :--- | :--- | :--- |
| <strong>趨近於 0</strong> | <code>SEA</code>、<code>TEA</code>、<code>DEA</code> | 採 <code>|實際 − 計畫| / 計畫</code> 絕對值正規化 |
| <strong>持續下降</strong> | <code>DRR</code>、<code>DDS</code> | 編譯測試缺陷率與總缺陷密度降低 |
| <strong>持續上升</strong> | <code>YLD</code>、<code>LPH</code> | 編譯前缺陷攔截率與每小時產出提升 |
| <strong>小於 1</strong> | <code>APR</code> | 於計畫時程內如期完工 |
| <strong>大於 2</strong> | <code>AFR</code> | 審查投入時間達除錯重工時間兩倍以上 |

</div>
<div class="card teal">
<h3>統一六步驟評估程序（第 3.5 節）</h3>
<ol class="small-text">
<li><strong>擇定評估區間：</strong>優先採階段區間（<code>PSP0 ➔ PSP2</code>）；僅出現於 PSP2 之 <code>DEA</code>、<code>AFR</code> 採 <code>7A–9A</code>。</li>
<li><strong>執行統計檢定：</strong>進行成對 t 檢定與單因子 ANOVA（輔以事後多重比較）。</li>
<li><strong>比對預期趨勢：</strong>檢核變動方向是否符合表 3（絕對值化後全數具單向一致性）。</li>
<li><strong>綜合判定改善：</strong>同時權衡趨勢方向與 t 檢定統計顯著性。</li>
<li><strong>計算中位數改進因子（MIF）：</strong>建立班級同儕內部基準並對照外部常模。</li>
<li><strong>轉譯工程價值回饋：</strong>依表 1 轉化為個人或班級之強弱項診斷報告。</li>
</ol>
</div>
</div>

<!--
指標解讀注意事項（第 3.5 節）：
由於 SEA、TEA、DEA 均已轉換為絕對值誤差，數值呈現「下降趨勢」代表趨近於零，亦即估算準確度「提升」，切勿望文生義誤判為準確度下降。

三組資料集切分邏輯（第 3.1 與 3.3 節）：
- 第一組資料集（PSP0 至 PSP2）：檢定 SEA、TEA、APR、DRR、YLD、DDS、LPH 七項指標，利用階段彙總平均提高統計檢定力。
- 第二組資料集（作業 7A 至 9A）：檢定僅於 PSP2 起存在之 DEA 與 AFR；作業 10A（PSP3）因涉及循環整合效應，不納入 t 檢定與 ANOVA。
- 第三組資料集（涵蓋 PSP0–PSP3 四階段，共 16 人 × 4 階段 = 64 筆階段觀測值）：用於跨階段多元迴歸與準路徑分析。
-->

---

## 3. 實證研究設計與資料完整性控管

<div class="three-col" style="margin-bottom: 12px;">
<div class="kpi-card"><div class="kpi-val">16 位研究生</div><div class="kpi-label">13 位碩士生與 3 位博士生修習 18 週專屬 PSP 研究所課程（2008 年秋季班）。</div></div>
<div class="kpi-card teal"><div class="kpi-val">160 份作業</div><div class="kpi-label">全員完成 Humphrey 10 份標準程式作業（14 人用 Java、2 人用 C++，每週 1 份）。</div></div>
<div class="kpi-card accent"><div class="kpi-val">0 筆錯誤</div><div class="kpi-label">全數 160 份作業之缺陷注入與移除總數稽核完全一致，零資料不一致錯誤。</div></div>
</div>

<div class="two-col">
<div class="card">
<h3>18 週課程安排與雙軌視覺分析</h3>
<ul class="small-text">
<li><strong>第 1–4 週：</strong>PSP 基礎觀念、時間／缺陷記錄方法與程式規範建立。</li>
<li><strong>第 5–14 週：</strong>實作 <code>PSP0</code> 至 <code>PSP3</code> 共 10 份程式作業與課堂討論。</li>
<li><strong>第 15–18 週：</strong>產出個人分析報表、教師回饋與課後採納意願問卷。</li>
<li><strong>雙軌圖表檢核：</strong>箱形圖（顯示中位數與極端值鬚線）搭配折線圖（群體平均趨勢）。</li>
</ul>
</div>
<div class="card teal">
<h3>研究倫理與資料效度控管</h3>
<ul class="small-text">
<li><strong>無績效懲罰機制：</strong>學生事前不知情且只要誠實完成十份作業即保證及格，杜絕「刻意美化數據」之失真威脅。</li>
<li><strong>認證 PSP 教師逐份稽核：</strong>嚴格檢查每份作業的計算、遺漏與轉錄錯誤。</li>
<li><strong>極端值交叉驗證：</strong>另建排除 IQR 極端值之備份資料集交叉檢核，確認結論不受離群值左右。</li>
</ul>
</div>
</div>

<!--
研究情境與代表性（第 3.1 與 5.1.1 節）：
受測學生逾三分之二有兼職工作且幾乎皆同時修習其他課程，時間壓力情境相當貼近一般軟體開發實務（雖與全職業界專案仍有差異）。

資料品質稽核（第 5.1.1 節）：
依循 Paulk 等人（2009）建議，本研究逐份比對「總注入缺陷數」與「總移除缺陷數」，在全部 160 份作業中未發現任何資料不一致錯誤，有效克服 Johnson & Disney（1999）指出的 PSP 記錄失真風險。

統計分析設計（第 3.2-3.4 節）：
1. 描述統計：以箱形圖與平均數折線圖雙軌並陳，防止極端值誤導平均趨勢判讀。
2. 推論統計：成對 t 檢定與單因子 ANOVA（含 Post-Hoc 檢定），協助區辨學習效應與流程效應（Wesslen 2000）。
3. 結構關係：以各後期指標為依變數、所有前期階段指標為自變數建立多元迴歸模型，再繪製準路徑分析圖（類比 Green et al. 2005 之偏最小平方法）。
-->

---

## 4. 實證結果（一）：計畫階段趨勢（SEA、TEA、APR）

<div class="two-col">
<div class="fig-box">
<img src="./img/fig2_sea_trend.png" alt="圖 2 規模估算準確度趨勢" style="max-height: 280px;">
<div class="fig-cap">圖 2. 規模估算準確度（SEA）：PSP0 至 PSP2 之箱形圖（左）與平均趨勢圖（右）。</div>
</div>
<div class="fig-box">
<img src="./img/fig4_apr_trend.png" alt="圖 4 實際與計畫時間比趨勢" style="max-height: 280px;">
<div class="fig-cap">圖 4. 實際／計畫時間比（APR）：PSP0 至 PSP2 穩定收斂至 1.0 附近。</div>
</div>
</div>

<div class="callout">
<strong>計畫階段診斷：</strong><strong>SEA 並未改善</strong>（平均誤差由 <code>13.2% ➔ 20.5%</code>，MIF = <code>0.67</code>），且在 PSP1 初次導入 PROBE 時離散度明顯擴大；<strong>TEA</strong> 僅微幅下降（<code>29.8% ➔ 26.2%</code>，未達顯著）。相對地，<strong>APR</strong> 穩定收斂（<code>1.16 ➔ 1.01</code>，MIF = <code>1.10</code>），顯示時程規劃工具已初見成效。
</div>

<!--
計畫階段結果深入解析（第 4.1 節與圖 2-4）：
- SEA（圖 2）：與多數既有文獻不同，學生絕對規模估算誤差不降反升（13.2% -> 20.5%）。箱形圖顯示 PSP1 階段盒身明顯擴張，反映學生剛從直覺猜測轉用正式 PROBE 規模估算工具時的不穩定性；在業界情境中，此類誤差可能導致嚴重的成本低估（Lederer & Prasad 2000）。
- TEA（圖 3，文中摘要）：平均時間估算誤差自 29.8% 微降至 26.2%（MIF = 1.14），盒身緊湊但未達統計顯著。
- APR（圖 4）：自 1.16 穩步降至 1.01，逼近「小於 1（準時完工）」目標，顯示 PSP1 引入之時程規劃有助於控制交期。
- 為何 SEA/TEA 不顯著（第 5.2 節）？驗證分析已排除：(1) 絕對值公式效應、(2) 極端值干擾（IQR 備份資料集結果一致）、(3) 記錄錯誤（問卷 Q2-Q4 平均 3.8-4.0/5）。作者歸因於學生缺乏實務開發經驗，且規劃估算能力較品質控管需要更長的學習曲線。
-->

---

## 4. 實證結果（二）：追蹤與審查趨勢及 ANOVA 檢定

<div class="split55">
<div class="fig-box">
<img src="./img/fig5_dea_trend.png" alt="圖 5 缺陷估算準確度趨勢" style="max-height: 270px;">
<div class="fig-cap">圖 5. 缺陷估算準確度（DEA）於 7A–9A（PSP2）之顯著改善：誤差由 63.6% 驟降至 25.0%。</div>
</div>
<div>
<h3>顯著單因子 ANOVA 摘要（表 4）</h3>

| 指標變數 | 評估區間 | 自由度 | F 值 | p 值 |
| :--- | :--- | :---: | :---: | :---: |
| <strong>DDS</strong>（總缺陷密度） | PSP0–PSP2 | (2, 45) | 9.106 | <strong>&lt; 0.001</strong> |
| <strong>YLD</strong>（編譯前產出率） | PSP0–PSP2 | (2, 45) | 35.637 | <strong>&lt; 0.001</strong> |
| <strong>DRR</strong>（編譯測試缺陷率） | PSP0–PSP2 | (2, 45) | 12.634 | <strong>&lt; 0.001</strong> |
| <strong>DEA</strong>（缺陷估算準確度） | 7A–9A | (2, 45) | 3.978 | <strong>0.026</strong> |

<div class="callout teal">
<strong>品質改善最為突出：</strong>全數四項達 ANOVA 統計顯著之指標皆屬<strong>軟體品質與缺陷控管</strong>維度；事後檢定證實 PSP0 至 PSP2 品質呈漸進式提升，且 DEA 於 <code>7A–9A</code> 區間顯著進步。
</div>
</div>
</div>

<!--
追蹤與審查趨勢及 ANOVA 解析（第 4.1-4.2 節、圖 5-6 與表 4）：
- DEA（圖 5）與 AFR（圖 6）：此二指標自 PSP2 始出現，故以 7A-9A 為評估區間。DEA 誤差由 63.6% 大幅下降至 25.0%（t 檢定 p = 0.010、ANOVA F = 3.978, p = 0.026、MIF = 2.79）；AFR 則呈小幅上升（1.12 -> 1.15, MIF = 1.21）。
- DEA 與 AFR 的反向鏡像現象：圖 5（DEA）與圖 6（AFR）在 7A、9A 與 8A 的盒身大小恰呈相反分佈，折線趨勢亦近乎互為倒影。因三份作業皆處於相同 PSP2 流程階段，此現象源於程式經驗差異、審查速率或學習效應，而非流程處理變動。
- ANOVA 檢定結果（表 4）：九項指標中僅四項達顯著水準，依 F 值排序為 YLD（35.637）、DRR（12.634）、DDS（9.106）與 DEA（3.978），顯示短期 PSP 訓練對品質與缺陷控管之立竿見影效果遠勝於專案規模與時間估算。
-->

---

## 4. 實證結果（三）：跨階段迴歸與準路徑分析

<div class="split55">
<div class="fig-box">
<img src="./img/fig7_path_analysis.png" alt="圖 7 準路徑分析變數流向圖" style="max-height: 390px;">
<div class="fig-cap">圖 7. 跨階段顯著路徑流向圖（n = 64 階段觀測值；*p &lt; .05、**p &lt; .01、***p &lt; .001）。</div>
</div>
<div>
<h3>顯著多元迴歸模型摘要（表 5）</h3>

| 依變數 | R<sup>2</sup> | p 值 | 顯著預測迴歸方程式 |
| :--- | :---: | :---: | :--- |
| <strong>DDS</strong> | <strong>0.949</strong> | &lt; 0.001 | <code>+0.162 YLD + 0.997 DRR + 0.221 DEA − 4.156</code> |
| <strong>AFR</strong> | <strong>0.332</strong> | 0.001 | <code>+0.009 DEA − 0.004 DRR + 0.407</code> |
| <strong>LPH</strong> | <strong>0.319</strong> | 0.001 | <code>+0.093 YLD − 0.083 DRR + 0.148 SEA + 33.04</code> |
| <strong>DRR</strong> | <strong>0.130</strong> | 0.038 | <code>+54.656 APR − 0.501 SEA + 22.242</code> |

<div class="callout">
<strong>跨階段延續效應獲得驗證：</strong>當編譯測試缺陷率（<code>DRR</code>）下降時，總缺陷密度（<code>DDS</code>，解釋力高達 94.9%）同步降低，並顯著推升<strong>生產力（<code>LPH</code>）</strong>與<strong>審查效益（<code>AFR</code>）</strong>；計畫階段之 <code>APR</code> 與 <code>SEA</code> 亦顯著影響追蹤階段之 <code>DRR</code>。
</div>
</div>
</div>

<!--
跨階段迴歸與準路徑分析深入解讀（第 4.3-4.4 節、表 5 與圖 7）：
本研究利用第三組資料集（16 位學生 × 4 個 PSP 階段 = 64 筆觀測值），嚴格限定僅以後期階段變數對所有前期階段變數進行迴歸分析，以檢驗階段間之前置影響力：
- 式 (3) AFR（R^2 = 0.332, p = 0.001）：受追蹤階段之 DEA 與 DRR 顯著預測。
- 式 (4) LPH（R^2 = 0.319, p = 0.001）：受 YLD、DRR 及 SEA 顯著影響；編譯前產出率愈高、編譯測試缺陷率愈低，開發效率愈高。
- 式 (5) DDS（R^2 = 0.949, p < 0.001）：追蹤階段全數三項指標（DEA、DRR、YLD）共同解釋 94.9% 變異，而計畫階段指標均未直接進入，凸顯整體軟體品質高度奠基於追蹤階段的缺陷管控表現。
- 式 (6) DRR（R^2 = 0.130, p = 0.038）：受計畫階段 APR 與 SEA 顯著預測，證明 Plan -> Track 確實存在延續效應；但偏低的 R^2（13%）也暗示計畫階段仍遺漏個人開發經驗與知識等關鍵因子。
- 模型觀察限制：圖 7 中 TEA 成為孤立節點（無顯著外連路徑），且少數路徑（如 SEA -> LPH 正係數）呈現直覺悖論，有待更大樣本進一步釐清。
-->

---

## 4. PSP 成效綜合評估報表與外部基準比較（表 6）

| 階段 | 指標 | 平均數趨勢（本研究） | t 檢定 p 值 | 中位數 MIF（本研究） | Wesslén (2000)（學術常模） | Hayes &amp; Over (1997)（業界常模） |
| :--- | :---: | :---: | :---: | :---: | :---: | :---: |
| <strong>Plan</strong> | <code>SEA</code> | 13.2 ➔ 20.5 | – | (0.67) | 2.1 | 2.5 |
| <strong>Plan</strong> | <code>TEA</code> | 29.8 ➔ 26.2 | – | 1.14 | 3.0 | 1.75 |
| <strong>Plan</strong> | <code>APR</code> | 1.16 ➔ 1.01 | – | 1.10 | – | – |
| <strong>Track</strong> | <code>DEA</code> | 63.6 ➔ 25.0 | <strong>0.010*</strong> | <strong>2.79</strong> | – | – |
| <strong>Track</strong> | <code>DRR</code> | 119.2 ➔ 43.6 | <strong>&lt; 0.001**</strong> | <strong>3.02</strong> | – | – |
| <strong>Track</strong> | <code>YLD</code> | 5.7% ➔ 47.9% | <strong>&lt; 0.001**</strong> | <strong>42.7%</strong> | 39% | 50% |
| <strong>Review</strong> | <code>DDS</code> | 121.8 ➔ 70.9 | <strong>0.015*</strong> | <strong>1.83</strong> | 2.0 | 2.5 |
| <strong>Review</strong> | <code>LPH</code> | 23.1 ➔ 24.9 | – | 1.57 | (0.86) | 無增減 |
| <strong>Review</strong> | <code>AFR</code> | 1.12 ➔ 1.15 | – | 1.21 | – | – |

<div class="callout teal">
<strong>整體評估結論：</strong>超過半數學生（<code>MIF &gt; 1</code>）在 <strong>9 項軟體工程目標中的 8 項</strong>皆獲得改善（僅 SEA 例外）。分階段表現呈現<strong>追蹤階段優異、審查階段中等、計畫階段偏弱</strong>，與 Wesslén 研究所學術常模高度吻合（YLD 42.7% vs. 39%；DDS MIF 1.83 vs. 2.0）。
</div>

<!--
綜合報表與外部基準對照解析（第 4.5 節與表 6）：
- Track 階段（表現優異）：三項指標全數達統計顯著——DEA（63.6% -> 25.0%, p = 0.010, MIF = 2.79）、DRR（119.2 -> 43.6 缺陷/KLOC, p < 0.001, MIF = 3.02）與 YLD（5.7% -> 47.9%, p < 0.001, 中位數 42.7% 優於 Wesslen 的 39% 並逼近 Hayes 業界水準 50%）。細分編譯（DRRC）與測試（DRRT）子指標亦呈現一致改善。
- Review 階段（表現中等）：DDS 顯著降低（121.8 -> 70.9, p = 0.015, MIF = 1.83）；LPH 小幅成長（23.1 -> 24.9 LOC/hr, MIF = 1.57，優於 Wesslen 的 0.86 與 Hayes 的持平）；AFR 略增至 1.15（MIF = 1.21），但尚未達 > 2 之理想門檻。
- Plan 階段（表現偏弱）：僅 APR 呈現穩定收斂（1.16 -> 1.01, MIF = 1.10），TEA 僅微幅改善（MIF = 1.14），SEA 則倒退（MIF = 0.67）。
-->

---

## 5. 討論：學生問卷回饋與教學／業界導入建議

<div class="split55">
<div>
<h3>課後問卷：認知重要性 vs. 未來採納意願（附錄 A）</h3>

| PSP 技術項目（表 7–8） | 認知重要性 | 承諾未來採用 |
| :--- | :---: | :---: |
| <strong>程式碼審查（Code Review）</strong> | <strong>86.7%</strong> | <strong>80.0%</strong> |
| <strong>設計審查（Design Review）</strong> | 80.0% | <strong>73.3%</strong> |
| <strong>計畫與排程（Planning）</strong> | 80.0% | 66.7% |
| <strong>工時估算（Effort Est.）</strong> | 73.3% | 66.7% |
| <strong>設計樣板（Design Template）</strong> | 73.3% | 60.0% |
| <strong>事後檢討（Postmortem）</strong> | <strong>86.7%</strong> | 33.3% |
| <strong>工時日誌（Effort Log）</strong> | 73.3% | 33.3% |
| <strong>規模量測（Size Meas.）</strong> | 60.0% | <strong>20.0%</strong> |

<p class="small-text" style="margin-top:6px;">整體助益評分：<strong>4.7 / 5.0</strong>（課程品質）與 <strong>4.5 / 5.0</strong>（未來職場）。</p>
</div>
<div class="card accent">
<h3>教育課程與業界實務建議</h3>
<ul class="small-text">
<li><strong>工具自動化減負：</strong>規模與工時記錄之「高認同、低採納」落差，凸顯導入自動化收集工具（如 LEAP、HackyStat、Eclipse 外掛）的迫切性。</li>
<li><strong>課程分層配置：</strong>完整 PSP 宜開設於研究所階段（大學生缺乏實務與程式經驗）；其他資工課程可在簡化記錄前提下採部分導入。</li>
<li><strong>業界專案裁剪：</strong>以貼近企業實務、善用外部函式庫的任務取代 Humphrey 數學題，縮短週期但須涵蓋 Plan–Track–Review 三階段。</li>
<li><strong>導入「顧客代理人」：</strong>於專案期間介入 2–4 次協助驗收測試，且業界評核應優先聚焦各階段<strong>結業指標</strong>（<code>APR</code>、<code>YLD</code>、<code>AFR</code>）。</li>
</ul>
</div>
</div>

<!--
教師觀察與問卷深度分析（第 5.3-5.4 節與附錄 A 表 7-8）：
- 表 7（五點量表）：學生高度理解 PSP 課程內容（4.3）、具填寫日誌能力（4.0）、自評日誌準確度 3.8，並高度肯定 PSP 對課程品質（4.7，66.7% 給滿分）與未來職場（4.5）之幫助，未來採用概念意願達 4.1。
- 表 8（認知重要性 vs. 承諾採用率）：揭示顯著的「人工記錄鴻溝」——高達 86.7% 認為事後檢討重要、73.3% 認為工時日誌重要，卻僅 33.3% 願於未來持續採用，規模量測採納率更低至 20%。反觀程式碼審查（80.0%）與設計審查（73.3%）獲得極高承諾，呼應本研究將 AFR 列為核心結業指標的觀點。
- PROBE 教學瓶頸：即使對研究生而言，PROBE 估算仍具高度挑戰，教師須耗費大量心力輔導除錯。
- 業界導入對策（第 5.4 節）：PSP 本身缺乏終端產品驗收機制，故建議納入外部「顧客代理人（customer proxy）」（Honig 2008）定期驗收，並依企業需求彈性設定各指標權重與定期回訓。
-->

---

## 5. 研究效度威脅與 6. 結論

<div class="two-col" style="margin-bottom: 12px;">
<div class="card">
<h3>研究效度威脅與對策（第 5.1 節）</h3>
<ul class="small-text">
<li><strong>內部效度：</strong>透過無績效懲罰、事後不知情收案、教師逐份稽核（160 份作業 0 錯誤），並採 IQR 備份驗證與抗極端值中位數（MIF）雙軌報表加以嚴密控管。</li>
<li><strong>外部效度：</strong>受測人數精簡（<code>N = 16</code>；迴歸與路徑分析為 <code>n = 64</code> 筆階段觀測），但透過高同質性樣本及與 Hayes（<code>n = 298</code>）、Wesslén（<code>n = 131</code>）大樣本外部基準對照提升詮釋力。</li>
<li><strong>推論與延續性：</strong>模型廣泛推論仍需更大規模複製研究，以釐清短期與長期 PSP 保留效應並納入個人先備能力因子。</li>
</ul>
</div>
<div class="card teal">
<h3>核心貢獻與關鍵啟示</h3>
<ul class="small-text">
<li><strong>1. Plan–Track–Review 評估模型：</strong>系統化對應九項關鍵 PSP 指標與六大軟體工程價值，區分入門／中階／結業層級。</li>
<li><strong>2. 嚴謹雙軌評估程序：</strong>結合絕對值正規化、六步驟流程、參數檢定與內外部中位數基準，提供師生具體診斷回饋。</li>
<li><strong>3. 實證真相檢視：</strong>PSP 能快速強化<strong>缺陷可控性與產品可靠性</strong>（<code>p ≤ 0.015</code>）、中度提升<strong>效率</strong>，而<strong>規模／時間估算</strong>則需長期養成，且前期階段確具跨階段延續影響力。</li>
</ul>
</div>
</div>

<div class="callout">
<strong>未來研究方向：</strong>納入個人開發經驗等遺漏變數以精進 Plan–Track–Review 模型、區辨短期與長期訓練留存效益，並推動跨校與業界之實證複製研究。
</div>

<!--
效度威脅與結論總結（第 5.1 節與第 6 節）：
- 內部效度：對照 Wohlin 等人（1999）四類效度威脅，特別防範人工記錄錯誤（Johnson & Disney 1999）、極端值偏誤（Paulk et al. 2009）與刻意數據造假。
- 外部效度：儘管受限於緊湊的高等教育課綱導致樣本數有限（N = 16），64 筆階段觀測值與大型外部常模對照已為 Plan-Track-Review 模型提供扎實的初步驗證。
- 實務價值：表 6 綜合評估報表讓教師與學生得以同時依據「業界標準、學術標準與班級同儕標準」檢視紀律化軟體開發的養成進度。
-->

---

<!-- _class: closing -->

# 感謝聆聽！敬請指教

<p style="font-size: 1.05em; max-width: 860px;">
評估 PSP 訓練紀律化軟體開發之成效：Plan–Track–Review 評估模型
</p>

<div class="contact-card">
<strong>沈文祥（Wen-Hsiang Shen）</strong> · <code>shen@ocu.edu.tw</code> &nbsp;|&nbsp; <strong>薛念林（Nien-Lin Hsueh）</strong> · <code>nlhsueh@fcu.edu.tw</code><br>
<strong>李維曼（Wei-Mann Lee）<sup>*</sup></strong> · <code>dwl@ocu.edu.tw</code><br>
逢甲大學資訊工程學系 · 僑光科技大學資訊科技系<br>
<span style="font-size: 0.85em; opacity: 0.88;">Information and Software Technology, Vol. 53, pp. 137–148, 2011 · DOI: 10.1016/j.infsof.2010.09.004</span>
</div>

<!--
論文典藏書目資訊：
- 篇名：Assessing PSP effect in training disciplined software development: A Plan-Track-Review model
- 作者：沈文祥（Wen-Hsiang Shen，逢甲大學）、薛念林（Nien-Lin Hsueh，逢甲大學）、李維曼（Wei-Mann Lee，僑光科技大學，通訊作者）
- 期刊：Information and Software Technology (IST), Vol. 53, pp. 137-148, 2011 (Elsevier B.V.)
- DOI：10.1016/j.infsof.2010.09.004
- 關鍵詞：Personal software process (PSP)、Software process improvement (SPI)、Effect assessment、Plan-Track-Review
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
