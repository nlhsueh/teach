---
marp: true
theme: gaia
size: 16:9
paginate: true
html: true
header: '<div class="hdr-wrap"><span class="hdr-title">評估設計模式品質之量化方法：基於物件導向品質模型與模型轉換</span><div class="hdr-actions"><a class="lang-btn" href="./PatternQuality_slide.html" title="Switch to English Slides">🌐 EN</a><div class="nav-dropdown"><button class="nav-btn">章節導覽 ▾</button><div class="nav-menu"><a href="#2">簡報大綱</a><a href="#3">1. 研究動機與背景</a><a href="#5">2. 形式化模型與 QIE 指標</a><a href="#8">3. PVS 工具與 Mediator 驗證</a><a href="#12">4. GoF 延伸洞見</a><a href="#14">5. 結論與未來研究</a></div></div></div></div>'
footer: '薛念林（Nien-Lin Hsueh）、朱鵬華（Peng-Hua Chu）、朱正忠（William Chu）· 逢甲大學 ＆ 東海大學 · JSS 2008'
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
section.lead h1 { color: #ffffff; font-size: 1.9em; font-weight: 800; line-height: 1.28; margin-bottom: 10px; text-align: left; }
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
.kpi-val { font-size: 1.32em; font-weight: 800; color: var(--navy); line-height: 1.15; margin-bottom: 3px; }
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

.formula-box {
  background: #f8fafc;
  border: 1px solid var(--slate-200);
  border-left: 4px solid var(--navy);
  border-radius: 8px;
  padding: 10px 16px;
  margin: 8px 0;
  font-family: 'JetBrains Mono', monospace;
  font-size: 0.8em;
  color: var(--navy-dark);
  line-height: 1.5;
}

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

.small-text { font-size: 0.81em; }

@media print {
  .lang-btn, .nav-dropdown { display: none !important; }
}
</style>

<!-- _class: lead -->

<div class="badge">The Journal of Systems and Software (JSS) · 第 81 卷 1430–1439 頁 · 2008</div>

# 評估設計模式品質之量化方法

<div class="en-title">A Quantitative Approach for Evaluating the Quality of Design Patterns</div>

<div class="subtitle">
結合<strong>角色基礎 UML 後設模型</strong>、<strong>QMOOD 物件導向品質模型</strong>與自動化模型轉換，客觀驗證設計模式之<strong>意圖與結構一致性</strong>並量化其<strong>品質改善效能（QIE）</strong>
</div>

<div class="meta-box">
<strong>薛念林（Nien-Lin Hsueh）</strong><sup>a,*</sup>、<strong>朱鵬華（Peng-Hua Chu）</strong><sup>a</sup>、<strong>朱正忠（William Chu）</strong><sup>b</sup><br>
<sup>a</sup> 逢甲大學資訊工程學系 · <sup>b</sup> 東海大學資訊工程學系<br>
<code>nlhsueh@fcu.edu.tw</code> · <code>cph@soft.iecs.fcu.edu.tw</code> · <code>cchu@thu.edu.tw</code>
</div>

<div class="grant">
DOI: 10.1016/j.jss.2007.11.724 · 2007 年 11 月接受 · 2008 年刊出（Elsevier）· 補助：國科會 NSC94-2213-E-035-041 ＆ 經濟部 96-EC-17-A-02-S1-029
</div>

<!--
論文書目與核心問題：
本論文發表於 The Journal of Systems and Software（JSS, Vol. 81, pp. 1430-1439, 2008），由逢甲大學薛念林（通訊作者）、朱鵬華與東海大學朱正忠教授共同撰寫。研究回應軟體工程界一項根本驗證難題：當設計模式於「意圖（Intent）」宣稱能解決某項品質問題（如降低耦合、提升擴充性）時，如何客觀且量化地驗證其「解決方案（Solution）」結構確實達成該品質改善？

三大核心貢獻：
1. 六元組形式化定義：將品質改進型設計模式定義為 <I_F, I_N, Q, S_F, S_N, T>，明確對應功能／非功能意圖、品質焦點、角色基礎 UML 後設模型與模型轉換 T。
2. 品質改善效能指標（QIE_P）與 P*-Improver 判準：將 QMOOD 物件導向度量（如 COF、ANA、多型性）提升至後設模型轉換層級，提出 P-Improver 與確保不損害原功能之良構 P*-Improver 定義。
3. 模式驗證系統（PVS）實作與 GoF 實證：串接 IBM Rational Rose（UML Profile / XMI）與自研 PVS 工具，以 20 組隨機樣本證實 Mediator 為強耦合改進者（QIE_coupling = -0.72），並揭示 Decorator 實為複雜度改進者而非抽象度改進者、Singleton 則屬問題解決者。
-->

---

## 簡報大綱

<div class="outline-grid">
<div class="outline-item"><div class="outline-num">1</div><div class="outline-body"><a href="#3">研究動機與技術背景</a><br>意圖與結構一致性缺口、角色基礎後設塑模與 QMOOD 四層品質模型。</div></div>
<div class="outline-item"><div class="outline-num">2</div><div class="outline-body"><a href="#5">形式化六元組與 QIE 量化指標</a><br>FR／NFR 結構二元定義、品質焦點 Q、QIE<sub>P</sub> 公式與良構 P*-Improver。</div></div>
<div class="outline-item"><div class="outline-num">3</div><div class="outline-body"><a href="#8">PVS 系統與 Mediator 驗證案例</a><br>UML Profile、轉換標籤與 20 組隨機樣本 COF 實驗（QIE = −0.72）。</div></div>
<div class="outline-item"><div class="outline-num">4</div><div class="outline-body"><a href="#12">GoF 設計模式延伸洞見</a><br>多型／階層改進者共通轉換結構，以及 Decorator 與 Singleton 之反直覺發現。</div></div>
<div class="outline-item"><div class="outline-num">5</div><div class="outline-body"><a href="#14">結論與未來研究方向</a><br>對模式開發者與使用者之雙重價值、XMI 工具鏈與 MDA 模型驅動整合。</div></div>
<div class="outline-item"><div class="outline-num">6</div><div class="outline-body"><a href="#15">聯絡方式與書目典藏</a><br>作者資訊、研究計畫補助與期刊引用格式。</div></div>
</div>

<div class="callout teal">
<strong>核心驗證哲學：</strong><em>「若設計模式的意圖對應至某項物件導向設計性質（如耦合度），其結構就必須支持該性質；而該結構的物件導向性質可透過物件導向度量指標（如 COF）加以客觀量化評估。」</em>
</div>

<!--
論文結構導覽：
- 第 1 節（緒論，pp. 1430-1431）：提出意圖與結構一致性驗證問題，說明對模式開發者與使用者的雙重效益。
- 第 2 節（背景技術，pp. 1431-1432）：介紹 France et al.（2004）角色基礎後設模型（圖 1）與 Bansiya & Davis（2002）QMOOD 階層品質模型（圖 2）。
- 第 3 節（模式評估方法，pp. 1432-1435）：定義六元組（表 1、圖 3-5）、QIE_P 公式（式 1-2）與 P-Improver／P*-Improver 驗證準則（式 3-5）。
- 第 4 節（案例研究與系統設計，pp. 1435-1439）：以 PVS + Rational Rose 驗證 Mediator（圖 6-8、表 2），並剖析 Observer、Decorator 與 Singleton（圖 9-11）。
- 第 5 節（結論，p. 1439）：總結貢獻並展望 MDA 整合。
-->

---

## 1. 研究動機：驗證意圖與解決方案之一致性

<div class="two-col">
<div class="card accent">
<h3>設計模式品質驗證的既有缺口</h3>
<ul>
<li><strong>GoF 四大核心段落：</strong><em>模式名稱</em>、<em>意圖（Intent）</em>、<em>解決方案（Solution）</em>與<em>結果（Consequences）</em>。</li>
<li><strong>一致性檢核盲點：</strong>隨著設計模式大量湧現，模式於「意圖」宣稱的品質效益（如鬆散耦合）鮮少經過客觀結構驗證。</li>
<li><strong>範例層級圖示的侷限：</strong>傳統類別圖（圖 1a）僅描繪單一特例（例如兩組產品家族），無法系統化檢驗一般情境下的品質行為。</li>
</ul>
</div>
<div class="card teal">
<h3>本研究帶來的雙重工程效益</h3>
<ul>
<li><strong>1. 協助模式開發者（設計驗證）：</strong>建立基於 QMOOD 的客觀驗證程序，確認新設計的模式是否<strong>良構（Well-Designed）</strong>——結構確能解決意圖所宣稱的品質問題且不損及原有功能。</li>
<li><strong>2. 協助模式使用者（客觀選型）：</strong>提供<strong>品質改善效能指標（<code>QIE<sub>P</sub></code>）</strong>量化品質提升幅度，讓架構師依據功能與品質需求挑選最適切的設計模式。</li>
</ul>
</div>
</div>

<div class="callout">
<strong>研究脈絡：</strong>受 Huston（2001）比較模式與非模式度量分數啟發，並承接團隊之設計模式四角色分類（<em>SoSyM 2009</em>），本文專注於為<strong>品質改進者（Quality-Improver）</strong>建立嚴謹的量化驗證體系。
</div>

<!--
動機與學術脈絡（第 1 節，pp. 1430-1431）：
Winn & Calder（2002）強調設計模式應能處理非功能需求；然而過去設計模式的正確性多仰賴專家主觀審查。本研究整合角色基礎後設模型（France et al. 2004）、QMOOD 度量體系（Bansiya & Davis 2002）與 UML Profile 模型轉換（Dong & Yang 2003），將設計模式品質驗證轉化為可重複執行的客觀工程程序。
-->

---

## 2. 技術背景：角色基礎後設模型與 QMOOD 品質模型

<div class="split55">
<div class="small-text">
<h3>1. 角色基礎模式表示法（France et al., 2004）</h3>
<ul>
<li>傳統 GoF 類別圖（圖 1a）停留在模型範例層級（如固定兩組 <code>ProductA</code>、<code>ProductB</code>）。</li>
<li><strong>角色基礎後設模型</strong>（圖 1b）將參與者抽象為正式角色（<code>AbstractFactory</code>、<code>ConcreteProduct</code>、<code>Client</code> 等），得以系統化實例化並自動化驗證任意規模模型。</li>
</ul>
<h3>2. QMOOD 四層階層品質模型（Bansiya &amp; Davis, 2002）</h3>
<ul>
<li>記為 <code>Φ</code>，含四層元素（<code>Φ<sub>1</sub></code>–<code>Φ<sub>4</sub></code>）與三組層間對應（<code>Φ<sub>12</sub></code>、<code>Φ<sub>23</sub></code>、<code>Φ<sub>34</sub></code>）。</li>
<li>由高至低串聯：<strong>設計品質屬性</strong>（如可重用性）➔ <strong>物件導向設計性質</strong>（如耦合度）➔ <strong>物件導向度量</strong>（如 <code>COF</code>）➔ <strong>設計元件</strong>（類別、關聯）。</li>
</ul>
</div>
<div class="fig-box">
<img src="./img/fig2_qmood.png" alt="圖 2 QMOOD 四層品質模型與範例" style="max-height: 390px;">
<div class="fig-cap">圖 2. QMOOD 四層階層品質模型與「可重用性—耦合度—COF」對應範例。</div>
</div>
</div>

<!--
背景技術細節（第 2 節，pp. 1431-1432，圖 1-2）：
1. 角色基礎表示法（第 2.1 節）：在後設模型層級定義每個角色必須滿足的結構條件，使任意數量的產品家族皆可實例化同一組角色規格。
2. QMOOD 數學符號（第 2.2 節）：
   - Level 1 (Phi_1)：六大品質屬性——可重用性、彈性、效能、易理解性、功能性、可擴充性。
   - Level 2 (Phi_2)：十一項物件導向設計性質——設計規模、階層、抽象度、封裝、耦合、內聚、組合、繼承、多型、訊息、複雜度。
   - Level 3 (Phi_3)：具體量化度量（如 COF 耦合因子、ANA 平均祖先數）。
   - Level 4 (Phi_4)：基本物件導向模型元件（物件、類別、關聯、一般化）。
   - 若 (P, mu) 屬於 Phi_23，表示度量指標 mu 可用以評估設計性質 P。
-->

---

## 3. 設計模式六元組形式化定義與品質焦點

<div class="split55">
<div class="small-text">
<p>從品質視角將設計模式定義為六元組 <code>dp = &lt;I<sub>F</sub>, I<sub>N</sub>, Q, S<sub>F</sub>, S<sub>N</sub>, T&gt;</code>：</p>
<ul>
<li><code>I<sub>F</sub></code> / <code>I<sub>N</sub></code>：<strong>功能意圖</strong>（做什麼）與<strong>非功能意圖</strong>（品質貢獻）。</li>
<li><code>Q(dp) = &lt;property, constraint&gt;</code>：<strong>品質焦點</strong>，<code>property ∈ Φ<sub>2</sub></code> 且 <code>constraint ∈ {increased, decreased, maintained}</code>。</li>
<li><code>S<sub>F</sub></code> / <code>S<sub>N</sub></code>：角色基礎之 <strong>FR 結構</strong>與 <strong>NFR 結構</strong>後設模型。</li>
<li><code>T</code>：<strong>模型轉換函數</strong>，將任意實例 <code>s ∈ S<sub>F</sub>(dp)</code> 映射至 <code>T(s) ∈ S<sub>N</sub>(dp)</code>。</li>
</ul>

| 設計模式（表 1） | 品質焦點 <code>Q</code> |
| :--- | :--- |
| <strong>Observer</strong> | <code>&lt;coupling, decreased&gt;</code> |
| <strong>Abstract Factory</strong> | <code>&lt;coupling, decreased&gt;</code> |
| <strong>Strategy</strong> | <code>&lt;polymorphism, increased&gt;</code> |
| <strong>Iterator</strong> | <code>&lt;encapsulation, increased&gt;</code> |

</div>
<div class="fig-box">
<img src="./img/fig5_pattern_elements.png" alt="圖 5 設計模式六元組元素關聯圖" style="max-height: 310px;">
<div class="fig-cap">圖 5. 設計模式各元素之交換關聯圖（以 Abstract Factory 為例）。</div>
</div>
</div>

<!--
六元組形式語意（第 3.1 節、表 1、圖 3-5）：
圖 5 勾勒出本研究的核心理論架構：
- 上方橫向延伸：由功能意圖 I_F 延伸至非功能意圖 I_N，定義出明確的品質焦點 Q(AF) = <coupling, decreased>。
- 左側縱向實現：FR 結構 S_F(AF) 實現基本功能意圖 I_F(AF)。
- 右側縱向強化：NFR 結構 S_N(AF) 強化非功能意圖 I_N(AF)。
- 下方橫向轉換：模型轉換 T 將任一實例模型 s（屬於 S_F）轉換為 T(s)（屬於 S_N），使我們能在相同基準下客觀量測套用設計模式前後的品質指標變化。
-->

---

## 3. 量化度量：品質改善效能（`QIE_P`）

<div class="two-col">
<div class="card">
<h3>1. 基礎物件導向度量範例：COF</h3>
<p class="small-text">針對 <code>coupling</code> 性質，採用 Brito &amp; Abreu（1995）定義之<strong>耦合因子（COF）</strong>：</p>
<div class="formula-box">
COF = [ Σ<sub>i=1..TC</sub> Σ<sub>j=1..TC</sub> is_client(C<sub>i</sub>, C<sub>j</sub>) ] / (TC<sup>2</sup> − TC)
</div>
<p class="small-text">其中 <code>TC</code> 為總類別數；若類別 <code>C<sub>i</sub></code> 對 <code>C<sub>j</sub></code>（<code>C<sub>i</sub> ≠ C<sub>j</sub></code>）具至少一項非繼承參考，則 <code>is_client(C<sub>i</sub>, C<sub>j</sub>) = 1</code>。</p>
</div>
<div class="card teal">
<h3>2. 提升至後設模型層級（式 1–2）</h3>
<p class="small-text">給定 <code>(P, μ) ∈ Φ<sub>23</sub></code> 與彙總函數 <code>G</code>（如平均數 <code>AVG</code>），於典型樣本集 <code>s ∈ S<sub>F</sub></code> 計算：</p>
<div class="formula-box">
QIE<sub>P</sub>(dp) = μ(S<sub>F</sub>, T)<br>
&nbsp;&nbsp;= G<sub>s ∈ SF</sub> [ ( μ(T(s)) − μ(s) ) / μ(s) ] &nbsp;&nbsp;(當 μ(s) ≠ 0)<br>
&nbsp;&nbsp;= ∞ &nbsp;&nbsp;(當 μ(s) = 0)
</div>
</div>
</div>

<div class="three-col" style="margin-top: 12px;">
<div class="kpi-card teal"><div class="kpi-val">QIE<sub>P</sub> &gt; 0</div><div class="kpi-label">套用模式 <code>dp</code> 會<strong>提升</strong>設計性質 <code>P</code>（例如多型方法增加）。</div></div>
<div class="kpi-card accent"><div class="kpi-val">QIE<sub>P</sub> &lt; 0</div><div class="kpi-label">套用模式 <code>dp</code> 會<strong>降低</strong>設計性質 <code>P</code>（例如耦合度下降）。</div></div>
<div class="kpi-card"><div class="kpi-val">|QIE<sub>P</sub>| 絕對值</div><div class="kpi-label">絕對值愈大代表對性質 <code>P</code> <strong>影響力愈強</strong>；等於 <code>0</code> 表示無效。</div></div>
</div>

<!--
QIE_P 數學定義與意涵（第 3.2 節，pp. 1433-1434，式 1-2）：
由於物件導向度量作用於具體實例模型，而設計模式定義於後設模型層級，本研究透過在代表性實例樣本集上計算相對變化率 (mu(T(s)) - mu(s)) / mu(s) 並取平均（G = AVG），成功將度量指標提升至後設轉換層級。當初始值 mu(s) = 0 時定義為無窮大；實務選型時，架構師可直接比較不同候選模式的 |QIE_P| 大小。
-->

---

## 3. 驗證良構品質改進者：`P-Improver` 與 `P*-Improver`

<div class="two-col">
<div class="card">
<h3>一致性驗證：<code>P-Improver</code>（式 3–4）</h3>
<p class="small-text">設計模式 <code>dp = &lt;I<sub>F</sub>, I<sub>N</sub>, &lt;P, C&gt;, S<sub>F</sub>, S<sub>N</sub>, T&gt;</code> 稱為<strong>性質 P 改進者</strong>，若且唯若 <code>QIE<sub>P</sub>(dp)</code> 符合約束 <code>C</code>：</p>
<div class="formula-box">
QIE<sub>P</sub>(dp) &gt; 0 &nbsp; 若 C = "increased"<br>
QIE<sub>P</sub>(dp) &lt; 0 &nbsp; 若 C = "decreased"<br>
QIE<sub>P</sub>(dp) = 0 &nbsp; 若 C = "maintained"
</div>
<p class="small-text"><strong>推論（式 4）：</strong><code>P-improver(dp) ➔ δ(I<sub>N</sub>, S<sub>F</sub>) &lt; δ(I<sub>N</sub>, S<sub>N</sub>)</code> —— NFR 結構對非功能意圖的滿足度嚴格高於 FR 結構。</p>
</div>
<div class="card accent">
<h3>功能保持條件：<code>P*-Improver</code>（式 5）</h3>
<p class="small-text">改善品質<strong>絕不可損害原始功能意圖</strong>。設計模式為<strong>良構 P 改進者</strong>（<code>P*-improver</code>），若且唯若：</p>
<div class="formula-box">
P*-improver(dp) ⇔<br>
&nbsp;&nbsp;P-improver(dp) ∧ ( δ(I<sub>F</sub>, S<sub>N</sub>) = satisfied )
</div>
<ul class="small-text">
<li><code>δ(I<sub>F</sub>, S) ∈ {0, 1}</code>：功能滿足度（由設計者檢核 <code>S<sub>N</sub></code> 是否保有足夠操作與互動以實現 <code>I<sub>F</sub></code>）。</li>
<li><code>δ(I<sub>N</sub>, S) ∈ [0, 1]</code>：非功能滿足度（無法直接量測，透過 <code>P-improver</code> 間接推導）。</li>
</ul>
</div>
</div>

<div class="callout teal">
<strong>Abstract Factory 範例（圖 3）：</strong>引入代理物件 <code>Factory</code> 降低 Client 與 Product 之耦合度（<code>QIE<sub>coupling</sub> &lt; 0</code>），同時完整保留建立產品家族之功能 ➔ 確屬<strong>良構耦合改進者</strong>。
</div>

<!--
P-Improver 與 P*-Improver 理論嚴謹性（第 3.3 節，pp. 1434-1435，式 3-5）：
滿足度函數 delta(intent, structure) 對軟性非功能需求屬於概念性指標（值域 [0, 1]），無法直接觀測，因此透過可計算的 QIE_P（式 3）作為操作型代理以推論式 4。同時，式 5 強制要求轉換後的 S_N 仍須滿足原始功能意圖 I_F（避免靠刪除功能元件來人為壓低耦合度之無效設計）。
-->

---

## 4. 自動化驗證系統：模式驗證系統（PVS）流程

<div class="fig-box" style="padding: 6px 8px;">
<img src="./img/diag_qie_pipeline.svg" alt="PVS 設計模式量化驗證流程" style="max-height: 390px;">
</div>

<div class="callout">
<strong>工具鏈整合（第 4 節）：</strong>使用商業建模工具 <strong>IBM Rational Rose</strong> 將 <code>S<sub>F</sub></code>、<code>S<sub>N</sub></code> 與轉換規格 <code>T</code> 建構為 <strong>UML Profile</strong> 並匯出為 <strong>XMI</strong>，再匯入自研之<strong>模式驗證系統（PVS）</strong>自動執行隨機抽樣、模型轉換與 QIE 量化評估。
</div>

<!--
PVS 系統實作架構（第 4 節，p. 1435）：
為避免自創非標準符號，研究採用 OMG 標準 UML Profile 擴充機制於 Rational Rose 建模並透過標準 XMI 交換格式銜接自研 PVS 引擎。因後設模型 S_F 對應無限多個實例模型，PVS 透過設定抽樣數（如 N = 20）與上下文範圍（類別數、關聯數）自動產生實例並執行 T 轉換與指標計算。
-->

---

## 4. 案例研究（一）：Mediator 意圖、結構與 UML Profile

<div class="split55">
<div class="small-text">
<h3>步驟一：分離意圖與定義品質焦點</h3>
<ul>
<li><strong>I<sub>F</sub>(Mediator)：</strong><code>Colleague</code> 物件可與其他 <code>Colleague</code> 物件相互通訊。</li>
<li><strong>I<sub>N</sub>(Mediator)：</strong>以<strong>鬆散耦合</strong>方式通訊，避免物件彼此顯式參照。</li>
<li><strong>品質焦點：</strong><code>Q(Mediator) = &lt;coupling, decreased&gt;</code> ➔ 對應 <code>Φ<sub>3</sub></code> 度量：<strong>COF</strong>。</li>
</ul>
<h3>步驟二：角色結構與 UML Profile 後設模型</h3>
<ul>
<li><code>S<sub>F</sub></code>（圖 6a）：<code>Colleague</code> 之間多對多直接自我關聯。</li>
<li><code>S<sub>N</sub></code>（圖 6b）：引入 <code>Mediator</code> 仲介者阻隔直接相依。</li>
<li><strong>UML Profile</strong>（圖 6c）：特化 UML 後設類別 <code>Class</code>、<code>Association</code>（<code>C2M_A1/A2</code>）與 <code>AssociationEnd</code>（<code>C2C_AE</code>、<code>C2M_AE</code>）。</li>
</ul>
</div>
<div class="fig-box">
<img src="./img/fig6_mediator_structures.png" alt="圖 6 Mediator FR 結構、NFR 結構與 UML Profile" style="max-height: 380px;">
<div class="fig-cap">圖 6. Mediator 模式：(a) FR 結構 S<sub>F</sub>、(b) NFR 結構 S<sub>N</sub>、(c) 以 UML Profile 表達之 S<sub>N</sub> 後設模型。</div>
</div>
</div>

<!--
Mediator 案例步驟一與二（第 4.1 節，pp. 1435-1436，圖 6）：
自 GoF 原文意圖萃取出 I_F、I_N 與 Q(Mediator) = <coupling, decreased>。在圖 6c 的 UML Profile 中，C2C 代表同事間直接關聯，C2M_A 代表同事連接仲介者之關聯，各自對應端點 C2C_AE 與 C2M_AE，完全符合 UML 2.x 擴充語意。
-->

---

## 4. 案例研究（二）：Mediator 後設模型轉換規格

<div class="split55">
<div class="fig-box">
<img src="./img/fig7_mediator_transform.png" alt="圖 7 Mediator 模式轉換規格" style="max-height: 390px;">
<div class="fig-cap">圖 7. Mediator 後設模型轉換規格 T(Mediator)：由 SourceModel（S<sub>F</sub>）轉換至 TargetModel（S<sub>N</sub>）。</div>
</div>
<div class="small-text">
<h3>步驟三：四種模型轉換標籤（Dong &amp; Yang, 2003）</h3>
<ul>
<li><code>&lt;&lt;removed&gt;&gt;</code>：僅存於來源模型之元素（如直接 <code>C2C</code> 關聯，轉換後移除）。</li>
<li><code>&lt;&lt;new&gt;&gt;</code>：僅存於目標模型之新增元素（<code>Mediator</code> 類別、<code>C2M_A1/A2</code>、<code>C2M_AE1/AE2</code>）。</li>
<li><code>&lt;&lt;unmodified&gt;&gt;</code>：轉換前後維持不變之元素（<code>Colleague</code> 類別與 <code>C2C_AE2</code>）。</li>
<li><code>&lt;&lt;modified&gt;&gt;</code>：屬性、操作或連結關係改變之元素（<code>C2C_AE1</code> 改導向 <code>C2M_A1</code>）。</li>
</ul>
<div class="callout teal">
匯出 XMI 至 <strong>PVS</strong> 後，圖 7 可自動將任意網狀 <code>Colleague</code> 實例模型（圖 8a）重構為星狀仲介者模型（圖 8b）。
</div>
</div>
</div>

<!--
Mediator 轉換規格詳解（第 4.1 節步驟三，pp. 1435-1436，圖 7）：
採用 Dong & Yang（2003）的四類刻板印象標籤描述模型映射，使原本 O(N^2) 的同事間網狀關聯（C2C）得以系統化重構為透過單一 Mediator 轉接的線性 O(N) 關聯（C2M_A1/A2）。
-->

---

## 4. 案例研究（三）：20 組 Mediator 樣本量化驗證結果

<div class="three-col" style="margin-bottom: 10px;">
<div class="kpi-card"><div class="kpi-val">20 組樣本</div><div class="kpi-label">PVS 隨機產生 20 組 <code>s<sub>F</sub></code> 模型（3–10 個 Colleague 類別、3–32 條隨機關聯）。</div></div>
<div class="kpi-card teal"><div class="kpi-val">COF: 0.34 ➔ 0.09</div><div class="kpi-label">全數 20 組樣本耦合因子皆大幅下降（<code>s<sub>F</sub></code>：0.15–0.50 ➔ <code>s<sub>N</sub></code>：0.07–0.13）。</div></div>
<div class="kpi-card accent"><div class="kpi-val">QIE = −0.72</div><div class="kpi-label">平均 <code>QIE<sub>coupling</sub>(Mediator) = −0.72</code>（區間 −0.50 至 −0.82）➔ 驗證為<strong>耦合改進者</strong>！</div></div>
</div>

| 代表性樣本（表 2） | #01 | #04 | #08 | #12 | #14 | #16 | #20 | <strong>20 組平均</strong> |
| :--- | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
| <strong>s<sub>F</sub></strong>（類別數 / 關聯數） | 3 / 3 | 5 / 8 | 6 / 14 | 7 / 21 | 9 / 11 | 9 / 23 | 10 / 32 | 7.4 / 14.9 |
| <strong>COF(s<sub>F</sub>)</strong> | 0.50 | 0.40 | 0.46 | 0.50 | 0.15 | 0.31 | 0.35 | <strong>~0.34</strong> |
| <strong>s<sub>N</sub></strong>（類別數 / 關聯數） | 6 / 4 | 8 / 6 | 10 / 7 | 10 / 8 | 12 / 10 | 12 / 10 | 13 / 11 | 10.4 / 8.2 |
| <strong>COF(s<sub>N</sub>)</strong> | 0.13 | 0.11 | 0.10 | 0.09 | 0.08 | 0.08 | 0.07 | <strong>~0.09</strong> |
| <strong>QIE<sub>SF, SN</sub></strong> | <strong>−0.73</strong> | <strong>−0.73</strong> | <strong>−0.79</strong> | <strong>−0.82</strong> | <strong>−0.50</strong> | <strong>−0.76</strong> | <strong>−0.80</strong> | <strong>−0.72</strong> |

<div class="callout">
<strong>驗證結論：</strong><code>QIE<sub>coupling</sub>(Mediator) = −0.72 &lt; 0</code> 完全符合 <code>Q(Mediator)</code> 之 <code>"decreased"</code> 約束；即便是稀疏樣本 #14 亦降低 50%，密集樣本 #12 與 #20 降幅更達 82% 與 80%。
</div>

<!--
20 組樣本實驗數據深入解讀（第 4.1 節步驟四與表 2，pp. 1435-1437）：
表 2 完整呈現 20 組不同規模與密度的隨機樣本：雖然套用 Mediator 會平均增加 3 個類別（抽象同事、抽象仲介者、具體仲介者），但關聯數大幅縮減（尤其在密集交互情境下如樣本 #12 的 21 -> 8 條、樣本 #20 的 32 -> 11 條），使 COF 由平均 ~0.34 驟降至 ~0.09，平均 QIE 達 -0.72，強力證實 Mediator 確實為良構之耦合改進者。
-->

---

## 4. GoF 延伸洞見（一）：多型性、階層性與抽象度

<div class="two-col">
<div class="card">
<h3>為何多數 GoF 模式皆為多型改進者？</h3>
<ul class="small-text">
<li>以 QMOOD 檢視 Gamma 目錄發現，<strong>Abstract Factory、Builder、Observer、Strategy 與 State</strong> 共享高度相似的結構轉換樣式（圖 9）：
  <ul>
  <li><strong>轉換前（S<sub>F</sub>）：</strong><code>Role1</code> 直接呼叫具體 <code>Role2</code>。</li>
  <li><strong>轉換後（S<sub>N</sub>）：</strong>建立抽象繼承階層，使擴充 <code>Role2</code> 時無須修改 <code>Role1</code>。</li>
  </ul>
</li>
<li><strong>解析推導：</strong>若原結構含 <code>n</code> 個多型方法，轉換後至少新增 1 個多型方法：
  <div class="formula-box">QIE<sub>polymorphism</sub> ≈ [ (n + 1) − n ] / n = 1 / n &gt; 0</div>
</li>
</ul>
</div>
<div class="card teal">
<h3>階層性與抽象度之連動提升</h3>
<ul class="small-text">
<li><strong>階層性（Hierarchy）</strong>代表一般化—特化架構，能強化<em>功能性</em>；<strong>抽象度（Abstraction，以 ANA 衡量）</strong>能提升<em>擴充性與效能</em>。</li>
<li>套用多型轉換時會同步建立新繼承階層，連帶推升階層性與抽象度。</li>
<li><strong>Observer 實例（圖 10）：</strong>將直接呼叫轉化為 <code>Subject</code> 與 <code>Observer</code> 雙繼承階層並新增多型 <code>update()</code>：
  <ul>
  <li><code>QIE<sub>polymorphism</sub> &gt; 0</code>、<code>QIE<sub>hierarchy</sub> &gt; 0</code>、<code>QIE<sub>abstraction</sub> &gt; 0</code> ➔ 同時改善三項物件導向設計性質！</li>
  </ul>
</li>
</ul>
</div>
</div>

<div class="callout">
<strong>架構啟示：</strong>儘管意圖與應用情境各異，眾多 GoF 模式皆透過相同的「引入抽象階層 ＋ 多型委派」轉換母題，在多型、階層與抽象度上同步創造正向 QIE。
</div>

<!--
跨模式結構洞見（第 4.2 節，pp. 1437-1438，圖 9-10）：
QMOOD 量化分析揭示了 GoF 模式家族背後的共通結構機制：圖 9 的 Role1 -> Role2 階層轉換使多型方法數必增至少 1，因此 Abstract Factory、Builder、Observer、Strategy、State 均為多型改進者，並多同時具備階層與抽象度改善效益（如圖 10 Observer）。
-->

---

## 4. GoF 延伸洞見（二）：Decorator 與 Singleton 之反直覺發現

<div class="fig-box" style="padding: 6px 8px; margin-bottom: 8px;">
<img src="./img/fig11_decorator.png" alt="圖 11 Decorator 靜態繼承與物件組合 ANA 比較" style="max-height: 255px;">
<div class="fig-cap">圖 11. Decorator 模式：(a) 靜態繼承 S<sub>F</sub> 引發子類別爆炸（36 類別，ANA = 3.14）；(b) 組合架構 S<sub>N</sub> 驟減至 13 類別（ANA = 2.23）。</div>
</div>

<div class="two-col">
<div class="card accent">
<h3>1. Decorator 並非抽象度改進者！</h3>
<p class="small-text">雖然外觀具繼承階層，但實驗顯示 Decorator 的 <code>QIE<sub>abstraction</sub></code> 為<strong>負值</strong>（<code>ANA：3.14 ➔ 2.23</code>，降幅 29%），因其以動態物件組合取代深層靜態繼承。其真正貢獻在於大幅縮減類別數（36 ➔ 13）➔ 實為<strong>複雜度改進者（Complexity-Improver）</strong>！</p>
</div>
<div class="card">
<h3>2. 並非所有設計模式皆為品質改進者</h3>
<p class="small-text"><strong>Singleton</strong> 旨在限制整個類別階層僅能產生單一實例（保護參照 ＋ 私有建構子），解決的是特定功能性設計難題而非 QMOOD 品質屬性 ➔ 應歸類為<strong>問題解決者（Problem-Solver）</strong>（Hsueh et al., 2007/2009）。</p>
</div>
</div>

<!--
反直覺實證發現詳解（第 4.2 節，pp. 1438-1439，圖 11）：
1. Decorator 悖論：直覺上 Decorator 具有 Component / Decorator 繼承樹，容易被誤認為階層或抽象度改進者；但透過 QMOOD 的平均祖先數（ANA = Average Number of Ancestors）計算：
   - S_F（純靜態繼承以支援 A、B、C 所有組合）：36 個類別，祖先總數 113，ANA = 113/36 = 3.14。
   - S_N（Decorator 物件組合）：13 個類別，祖先總數 29，ANA = 29/13 = 2.23。
   - 因此 QIE_abstraction(Decorator) = (2.23 - 3.14)/3.14 = -0.29 < 0！這項量化結果精準揭露 Decorator 的真正價值在於抑制子類別爆炸，屬於 Complexity-Improver。（註：原論文圖 11 子圖標註偶有排印筆誤寫為 Observer，內文與圖說皆明確指涉 Decorator。）
2. 範疇界線（Singleton）：呼應團隊 2007/2009 之四大角色分類，QIE 評估模型專門適用於品質改進者，不強行套用於 Singleton 這類問題解決者。
-->

---

## 5. 結論與未來研究方向

<div class="two-col" style="margin-bottom: 12px;">
<div class="card teal">
<h3>核心學術與實務貢獻</h3>
<ul class="small-text">
<li><strong>1. 品質導向形式化模型：</strong>以六元組 <code>&lt;I<sub>F</sub>, I<sub>N</sub>, Q, S<sub>F</sub>, S<sub>N</sub>, T&gt;</code> 銜接 GoF 文字敘述、角色基礎 UML 後設模型與 QMOOD 品質體系。</li>
<li><strong>2. 量化 <code>QIE<sub>P</sub></code> 與 <code>P*-Improver</code>：</strong>提供客觀驗證意圖—結構一致性之判準，並可量化比較不同模式的品質改善幅度。</li>
<li><strong>3. PVS 雛形與 GoF 新洞見：</strong>自動化 XMI 驗證證實 Mediator（<code>QIE = −0.72</code>），歸納多型改進者母題，並釐清 Decorator（複雜度改進者）與 Singleton（問題解決者）之本質差異。</li>
</ul>
</div>
<div class="card">
<h3>未來研究藍圖</h3>
<ul class="small-text">
<li><strong>完整 XMI 驗證工具鏈：</strong>擴充 PVS 並建立標準化 XMI 表示法，支援表達完整 GoF 與架構模式庫之 <code>S<sub>F</sub></code>／<code>S<sub>N</sub></code> 後設模型。</li>
<li><strong>整合模型驅動架構（MDA）：</strong>導入 OMG MDA 轉換技術（Miller &amp; Mukerji 2003；Meservy &amp; Fenstermacher 2005），自動化驅動設計模式之模型轉換 <code>T</code>。</li>
<li><strong>多屬性權衡剖析：</strong>同步評估單一設計模式對 QMOOD 全部 11 項設計性質之正向與負向 QIE 綜合效應。</li>
</ul>
</div>
</div>

<div class="callout">
<strong>總結啟示：</strong>設計模式品質量化驗證將設計模式從<em>經驗法則</em>提升為<strong>可稽核、可量測的軟體工程資產</strong>，同時賦能模式設計者與系統架構師做出有憑據的設計決策。
</div>

<!--
結論與未來展望（第 5 節，p. 1439）：
本研究證明「設計模式能改善軟體品質」這項廣為流傳的論斷，完全可以在後設模型層級接受嚴謹的量化檢驗。透過 QMOOD 性質與度量指標的連結，模式作者能在發布前驗證設計一致性，而開發者也能依據 QIE_P 數據理性選用最適切的設計模式。
-->

---

<!-- _class: closing -->

# 感謝聆聽！敬請指教

<p style="font-size: 1.05em; max-width: 860px;">
評估設計模式品質之量化方法（A Quantitative Approach for Evaluating the Quality of Design Patterns）
</p>

<div class="contact-card">
<strong>薛念林（Nien-Lin Hsueh）<sup>*</sup></strong> · <code>nlhsueh@fcu.edu.tw</code> &nbsp;|&nbsp; <strong>朱鵬華（Peng-Hua Chu）</strong> · <code>cph@soft.iecs.fcu.edu.tw</code><br>
<strong>朱正忠（William Chu）</strong> · <code>cchu@thu.edu.tw</code><br>
逢甲大學資訊工程學系 · 東海大學資訊工程學系<br>
<span style="font-size: 0.85em; opacity: 0.88;">The Journal of Systems and Software (JSS), Vol. 81, pp. 1430–1439, 2008 · DOI: 10.1016/j.jss.2007.11.724</span>
</div>

<!--
論文典藏書目資訊：
- 篇名：A quantitative approach for evaluating the quality of design patterns
- 作者：薛念林（Nien-Lin Hsueh，逢甲大學，通訊作者）、朱鵬華（Peng-Hua Chu，逢甲大學）、朱正忠（William Cheng-Chung Chu，東海大學）
- 期刊：The Journal of Systems and Software (JSS), Vol. 81, pp. 1430-1439, 2008（2007 年 12 月 4 日線上刊出，Elsevier Inc.）
- DOI：10.1016/j.jss.2007.11.724
- 計畫補助：國科會 NSC94-2213-E-035-041；經濟部技術處 96-EC-17-A-02-S1-029
- 關鍵詞：Design pattern、Object-oriented metrics、Software quality
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
