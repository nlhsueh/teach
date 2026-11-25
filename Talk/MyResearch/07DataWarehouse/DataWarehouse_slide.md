---
marp: true
theme: gaia
size: 16:9
paginate: true
html: true
header: '<div class="hdr-wrap"><span class="hdr-title">Efficient Approaches for Materialized Views Selection in a Data Warehouse</span><div class="hdr-actions"><a class="lang-btn" href="./DataWarehouse_slide_zh.html" title="切換至繁體中文簡報">🌐 繁</a><div class="nav-dropdown"><button class="nav-btn">Sections ▾</button><div class="nav-menu"><a href="#2">Outline</a><a href="#3">1. Motivation & Problem</a><a href="#4">2. Related Work</a><a href="#5">3. Vector Lattice & Rewrite</a><a href="#7">4. Cost Model & Metrics</a><a href="#9">5. MPL & MPL-CV Algorithms</a><a href="#11">6. Empirical Evaluation</a><a href="#14">7. Discussion & Conclusion</a></div></div></div></div>'
footer: 'Ming-Chuan Hung, Man-Lin Huang, Don-Lin Yang & Nien-Lin Hsueh · Feng Chia University · Info. Sci. 2007'
---

<style>
@import url('https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700;800&family=JetBrains+Mono:wght@500;600&display=swap');

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
  font-family: 'Inter', -apple-system, BlinkMacSystemFont, 'Segoe UI', sans-serif;
  font-size: 20px;
  line-height: 1.48;
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
h1 { color: var(--navy); font-size: 1.7em; font-weight: 800; line-height: 1.22; margin: 0 0 12px 0; }
h2 {
  color: var(--navy);
  font-size: 1.22em;
  font-weight: 700;
  line-height: 1.25;
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
li { margin-bottom: 5px; line-height: 1.43; }
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
  letter-spacing: 0.06em;
  text-transform: uppercase;
  padding: 5px 14px;
  border-radius: 999px;
  margin-bottom: 18px;
}
section.lead h1 { color: #ffffff; font-size: 1.95em; font-weight: 800; line-height: 1.24; margin-bottom: 16px; text-align: left; }
section.lead .subtitle { color: #cbd5e1; font-size: 0.94em; line-height: 1.5; margin-bottom: 24px; max-width: 960px; }
section.lead .meta-box { border-left: 4px solid #f43f5e; padding-left: 18px; color: #e2e8f0; font-size: 0.85em; line-height: 1.58; }
section.lead .grant { margin-top: 20px; font-size: 0.72em; color: #94a3b8; }

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
  line-height: 1.68;
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
.kpi-label { font-size: 0.76em; color: var(--slate-700); line-height: 1.34; }

.callout {
  background: #f8fafc;
  border-left: 4px solid var(--accent);
  border-radius: 0 8px 8px 0;
  padding: 10px 16px;
  margin-top: 12px;
  font-size: 0.85em;
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
  line-height: 1.32;
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
.outline-body { font-size: 0.84em; line-height: 1.38; }
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
.formula-box {
  background: #f8fafc;
  border: 1px solid var(--slate-200);
  border-left: 4px solid var(--navy);
  border-radius: 6px;
  padding: 8px 14px;
  margin: 6px 0;
  font-family: 'JetBrains Mono', monospace;
  font-size: 0.78em;
  color: var(--navy);
  font-weight: 600;
}
</style>

<!-- _class: lead -->

<div class="badge">Information Sciences · Vol. 177, pp. 1333–1348 · 2007</div>

# Efficient Approaches for Materialized Views Selection in a Data Warehouse

<div class="subtitle">
Accelerating NP-complete OLAP view selection under storage and maintenance constraints via binary vector lattices, space-normalized Gain/Loss metrics, and Mid-Point Locating algorithms (MPL &amp; MPL-CV).
</div>

<div class="meta-box">
<strong>Ming-Chuan Hung<sup>*</sup></strong>, <strong>Man-Lin Huang</strong>, <strong>Don-Lin Yang</strong>, <strong>Nien-Lin Hsueh</strong><br>
Department of Information Engineering and Computer Science, Feng Chia University, Taichung, Taiwan<br>
DOI: <code>10.1016/j.ins.2006.09.007</code>
</div>

<div class="grant">Supported by National Science Council, Taiwan · Contract No. NSC 94-2213-E-035-002</div>

<!--
Paper Metadata & Research Context:
- Full Citation: M.-C. Hung, M.-L. Huang, D.-L. Yang, and N.-L. Hsueh, "Efficient approaches for materialized views selection in a data warehouse," Information Sciences, vol. 177, pp. 1333-1348, 2007.
- Received 22 September 2005; revised 18 September 2006; accepted 19 September 2006.
- Core Problem: In OLAP data warehouses, pre-computing materialized views accelerates complex historical aggregation queries, yet storage space is bounded and base-data updates incur refresh/maintenance costs. Finding the optimal subset of views is NP-complete.
- Core Innovation: Combines (1) binary vector lattice encoding for O(1) bitwise-AND query rewrite, (2) a weighted query-plus-maintenance cost model with unit-space Gain and Loss metrics, and (3) Mid-Point Locating (MPL) and Candidate-View pruned MPL-CV algorithms that choose dynamically between bottom-up addition and top-down deletion.
-->

---

## Outline

<div class="outline-grid">
<div class="outline-item">
  <div class="outline-num">1</div>
  <div class="outline-body"><a href="#3">Motivation &amp; Problem Statement</a><br>Storage limits, OLAP query latency vs. view refresh cost, and NP-completeness of view selection.</div>
</div>
<div class="outline-item">
  <div class="outline-num">2</div>
  <div class="outline-body"><a href="#4">Related Work Comparison</a><br>Contrasting Greedy, Two-Phase, MVPP, and Evolutionary algorithms with our MPL / MPL-CV approach.</div>
</div>
<div class="outline-item">
  <div class="outline-num">3</div>
  <div class="outline-body"><a href="#5">Vector Lattice &amp; Bitwise Query Rewrite</a><br>Encoding data cubes in binary vectors and resolving dependent views via bitwise <code>AND</code>.</div>
</div>
<div class="outline-item">
  <div class="outline-num">4</div>
  <div class="outline-body"><a href="#7">Cost Model, Gain &amp; Loss Metrics</a><br>Weighted query + maintenance cost <code>Cost(mv)</code> and unit-space Gain/Loss selection formulas.</div>
</div>
<div class="outline-item">
  <div class="outline-num">5</div>
  <div class="outline-body"><a href="#9">MPL &amp; MPL-CV Algorithms</a><br>Cutting-point decision between addition and deletion, plus candidate-view pruning in MPL-CV.</div>
</div>
<div class="outline-item">
  <div class="outline-num">6</div>
  <div class="outline-body"><a href="#11">Empirical Evaluation &amp; Discussion</a><br>Loop reduction (47.4%–57.1%) and total cost reduction (25.5%) under <code>w = 0</code> and <code>w ≠ 0</code>.</div>
</div>
</div>

<div class="callout teal" style="margin-top: 16px;">
<strong>Core Insight:</strong> Repeatedly recomputing <code>Cost(mv)</code> across the lattice is the primary runtime bottleneck; cutting from the closer boundary (<code>M<sub>ss</sub></code> vs. <code>M<sub>cs</sub></code>) and pruning oversized views drastically slashes search loops while lowering total DW cost.
</div>

<!--
Paper Organization:
- Section 1 (Introduction): Defines the three-way trade-off among storage space, OLAP query efficiency, and maintenance cost.
- Section 2 (Related work): Surveys Harinarayan's greedy algorithm, Chen & Liu's two-phase algorithm, Yang's MVPP, Gupta & Mumick, Theodoratos & Sellis, and Zhang/Yu evolutionary methods.
- Section 3 (Architectural design): Presents the data cube lattice (Figs. 1-2), binary vector representation (Fig. 3), and bitwise-AND query rewrite.
- Section 4 (Cost model): Formulates Eqs. (1)-(6) for space, query cost, maintenance cost, total weighted cost, Gain metric, and Loss metric, illustrated on a 4-D lattice (Fig. 4, Examples 2-3).
- Section 5 (Selection algorithms): Details the 10-step MPL and MPL-CV algorithms (Figs. 5-6).
- Section 6 (Experiments): Evaluates w = 0 (Tables 2-3, 5; Fig. 7) and w != 0 (Table 4; Figs. 8-9) against the Two-Phase baseline.
- Section 7 (Conclusion): Summarizes results and future online dynamic view evolution.
-->

---

## 1. Motivation & Problem Statement

<div class="three-col" style="margin-bottom: 12px;">
<div class="kpi-card">
  <div class="kpi-val">NP-Complete</div>
  <div class="kpi-label">Selecting an optimal subset of materialized views across a multidimensional lattice</div>
</div>
<div class="kpi-card accent">
  <div class="kpi-val">3 Constraints</div>
  <div class="kpi-label">(1) Limited storage <code>S<sub>s</sub></code>, (2) Query latency <code>C<sub>Q</sub></code>, (3) Refresh cost <code>C<sub>M</sub></code></div>
</div>
<div class="kpi-card teal">
  <div class="kpi-val">3 Innovations</div>
  <div class="kpi-label">Vector lattice, Gain/Loss metrics, and Mid-Point Locating with Candidate Pruning</div>
</div>
</div>

<div class="two-col">
<div class="card">
  <h3>The Data Warehouse Trade-Off</h3>
  <ul class="small-text">
    <li><strong>Why Materialize?</strong> OLAP decision-support queries aggregate massive historical data; storing intermediate views speeds up responses dramatically.</li>
    <li><strong>Why Not Materialize Everything?</strong> Finite storage capacity prohibits storing all <code>2<sup>d</sup></code> cube views, and every source update forces expensive view refreshes.</li>
    <li><strong>Hidden Bottleneck:</strong> Iterative lattice cost recomputation makes view-selection algorithms computationally slow.</li>
  </ul>
</div>
<div class="card accent">
  <h3>Objective of This Study</h3>
  <ul class="small-text">
    <li><strong>Fast Dependency Lookup:</strong> Represent cube lattices as binary vectors so query rewriting uses fast bitwise <code>AND</code>.</li>
    <li><strong>Joint Optimization:</strong> Minimize weighted sum <code>Cost(mv) = C<sub>Q</sub> + w × C<sub>M</sub></code> strictly within actual storage <code>S<sub>s</sub></code>.</li>
    <li><strong>Fewer Search Loops:</strong> Decide adaptively whether to <em>add</em> from minimal views or <em>delete</em> from candidate views using the space mid-point.</li>
  </ul>
</div>
</div>

<!--
Problem Formulation (Section 1):
- Data warehouses integrate distributed, heterogeneous operational databases to support OLAP decision support.
- Unlike OLTP transactions, OLAP queries perform complex multi-dimensional aggregations. Pre-computing materialized views accelerates queries, but when underlying data sources change, materialized views must be refreshed to preserve validity, accuracy, and currency.
- The paper simultaneously addresses three intertwined constraints: (1) available storage space Ss, (2) query processing efficiency, and (3) both query and maintenance costs.
-->

---

## 2. Related Work & Positioning

| Approach | Space Limit | Maint. Cost | Mechanism | Key Limitation |
| :--- | :---: | :---: | :--- | :--- |
| **Harinarayan et al. (1996)** Greedy | ✓ | ✗ | Top-down benefit greedy on lattice | Ignores maintenance cost; poor under tight space |
| **Chen &amp; Liu (1997)** Two-Phase | ✓ | ✗ | Phase 1: minimal set; Phase 2: greedy add | Always adds bottom-up ➔ excessive loops when space is ample |
| **Yang et al. (1997)** MVPP | ✗ | ✓ | Multiple View Processing Plan | Does not enforce bounded storage space |
| **Gupta &amp; Mumick (1999)** | ✗ | ✓ | Maintenance-cost constrained selection | Assumes storage is cheap/unbounded |
| **Zhang / Yu (2001, 2003)** Evolutionary | ✓ | ✓ | Hybrid / constrained GA + stochastic ranking | Good cost savings, but high computation time |
| **Proposed MPL &amp; MPL-CV (2007)** | **✓** | **✓** | **Vector lattice + Gain/Loss + Mid-Point** | **Fast convergence &amp; lower joint query+maint cost** |

<div class="callout" style="margin-top: 10px;">
<strong>Benchmark Selection:</strong> Because Chen &amp; Liu's Two-Phase algorithm already outperforms Harinarayan's Greedy algorithm, Section 6 benchmarks <strong>MPL</strong> and <strong>MPL-CV</strong> directly against Two-Phase across both <code>w = 0</code> and <code>w ≠ 0</code> workloads.
</div>

<!--
Literature Positioning (Section 2):
- Harinarayan et al. [8] introduced the data-cube lattice and greedy benefit heuristic, but omitted view maintenance costs and degrades when storage is insufficient for dependent views.
- Chen & Liu [3] improved on Greedy via a two-phase algorithm: Phase 1 finds the minimal storage set answering all queries, and Phase 2 greedily adds views using remaining space. However, when available space is large, bottom-up addition requires many costly lattice-evaluation loops.
- Yang et al. [23] (MVPP) and Gupta & Mumick [6] incorporated maintenance costs but relaxed storage limits.
- Evolutionary algorithms (Horng [10], Lin & Kuo [14], Zhang [25], Yu [24]) yield low-cost plans at the expense of long runtimes.
- Building on Yang, Huang & Hung (PAKDD 2002 [22]), this paper introduces unit-space Gain/Loss metrics, candidate-view pruning (MPL-CV), and bitwise vector query rewriting.
-->

---

## 3. Lattice Framework & Binary Vector Representation

<div class="split55">
<div class="card">
  <h3>Partial Order &amp; Binary Encoding</h3>
  <ul class="small-text">
    <li><strong>Dependency Relation (<code>⊆</code>):</strong> <code>Q<sub>1</sub> ⊆ Q<sub>2</sub></code> iff query <code>Q<sub>1</sub></code> can be answered using view <code>Q<sub>2</sub></code> (e.g., <code>PS ⊆ PSC</code>).</li>
    <li><strong>3-D Sales Cube (Example 1):</strong> Dimensions Parts (<code>P</code>), Suppliers (<code>S</code>), Customers (<code>C</code>) ➔ <code>2<sup>3</sup> = 8</code> views from top view <code>PSC (111)</code> down to <code>None (000)</code>.</li>
    <li><strong>Bit-Flipping Navigation:</strong>
      <ul>
        <li><strong>Roll-up (Upper dependent views):</strong> Flip a <code>0</code> bit to <code>1</code> (e.g., <code>P(100)</code> ➔ <code>PS(110)</code>, <code>PC(101)</code>).</li>
        <li><strong>Drill-down:</strong> Flip a <code>1</code> bit to <code>0</code>.</li>
      </ul>
    </li>
    <li><strong>Benefit:</strong> Eliminates expensive graph traversal when tracing view dependencies during cost recalculation.</li>
  </ul>
</div>
<div class="fig-box">
  <img src="./img/fig3_lattice_vec.png" alt="Paper Fig. 3 Binary vector lattice representation" style="max-height: 365px;">
  <div class="fig-cap">Fig. 3 (Paper): Binary vector encoding of the 3-D (P, S, C) data cube lattice.</div>
</div>
</div>

<!--
Lattice & Vector Representation (Sections 3.1-3.2, Figs. 1-3):
- A data cube lattice satisfies two conditions: (1) the dependency relation is a partial order, and (2) a top element exists (PSC) from which all other views can be derived.
- In Example 1 (Fig. 2), PSC has size 6M and query frequency 0.05; PS has 0.8M and 0.15; PC has 6M and 0.1; SC has 5M and 0.1; P has 0.2M and 0.25; S has 0.01M and 0.2; C has 0.1M and 0.15.
- Representing each d-dimensional view as a d-bit binary vector enables instant ancestor/descendant identification via simple bit operations rather than pointer-based graph search.
-->

---

## 3.2 Fast Query Rewrite via Bitwise AND

<div class="fig-box" style="margin-bottom: 10px;">
<img src="./img/diag1_bitwise_rewrite.svg" alt="Bitwise AND Query Rewrite Diagram" style="max-height: 270px;">
</div>

<div class="two-col">
<div class="card">
  <h3>Bitwise Dependency Criterion</h3>
  <p class="small-text">Given materialized set <code>mv = {PS(110), PC(101), C(001)}</code> and user query <code>q = S(010)</code>, view <code>m ∈ mv</code> can answer <code>q</code> iff <code>(q ∧ m) == q</code>.</p>
</div>
<div class="card teal">
  <h3>Smallest-View Selection Rule</h3>
  <p class="small-text">When multiple materialized views satisfy <code>(q ∧ m) == q</code>, the rewriter selects the dependent view with the <strong>smallest data size <code>S<sub>i</sub></code></strong> to minimize query I/O cost.</p>
</div>
</div>

<!--
Query Rewrite Mechanics (Sections 3.3-3.4):
- Partial materialization accelerates OLAP by rewriting incoming user queries against the currently materialized view set mv.
- Using the binary vector encoding, testing whether a materialized view m covers a query view q reduces to a single bitwise AND instruction: if (q AND m) == q, then every dimension required by q is present in m.
- In the paper's worked example: S(010) AND PS(110) = (010) [match], S(010) AND PC(101) = (000) [no], S(010) AND C(001) = (000) [no]. Thus S is rewritten to scan PS (0.8M) instead of the raw 6M PSC base cube.
-->

---

## 4. Unified Query & Maintenance Cost Model

<div class="split55">
<div>
  <div class="formula-box">(1) Total Space:  S<sub>mv</sub> = Σ<sub>i ∈ mv</sub> S<sub>i</sub> &nbsp;≤&nbsp; S<sub>s</sub></div>
  <div class="formula-box">(2) Query Cost:  C<sub>Q</sub> = Σ<sub>i=1..n</sub> f<sub>qi</sub> · C(mv ➔ r<sub>i</sub>)</div>
  <div class="formula-box">(3) Maint. Cost: C<sub>M</sub> = Σ<sub>j=1..m</sub> f<sub>uj</sub> · C(l ➔ mv<sub>j</sub>)</div>
  <div class="formula-box" style="border-left-color: var(--accent); color: var(--accent);">(4) Total Cost:  Cost(mv) = C<sub>Q</sub> + w · C<sub>M</sub></div>
  <div class="callout" style="margin-top: 8px; font-size: 0.8em;">
    <strong>Weight <code>w = maintenance freq / query freq</code>:</strong><br>
    • <code>w &lt; 1</code> (typical OLAP): queries outnumber updates.<br>
    • <code>w = 1</code>: equal frequency; <code>w &gt; 1</code>: update-heavy warehouse.
  </div>
</div>
<div class="card">
  <h3>Key Cost-Model Symbols (Table 1)</h3>
  <table>
    <thead><tr><th>Symbol</th><th>Definition</th></tr></thead>
    <tbody>
      <tr><td><code>S<sub>s</sub></code> / <code>S<sub>mv</sub></code></td><td>Actual DW storage limit / Space used by <code>mv</code></td></tr>
      <tr><td><code>f<sub>qi</sub></code> / <code>f<sub>uj</sub></code></td><td>Query frequency of view <code>i</code> / Update freq. of view <code>j</code></td></tr>
      <tr><td><code>C(mv ➔ r<sub>i</sub>)</code></td><td>Cost to answer query view <code>r<sub>i</sub></code> using <code>mv</code></td></tr>
      <tr><td><code>C(l ➔ mv<sub>j</sub>)</code></td><td>Cost to refresh materialized view <code>mv<sub>j</sub></code> from source <code>l</code></td></tr>
      <tr><td><code>n</code> / <code>m</code></td><td>Number of query views / Number of maintained views</td></tr>
    </tbody>
  </table>
</div>
</div>

<!--
Cost Model Formulation (Section 4.1, Table 1, Eqs. 1-4):
- Adapting Yang et al. [23], total data warehouse cost Cost(mv) combines total query cost CQ and weighted total maintenance cost w * CM.
- A lower Cost(mv) indicates a better materialized view set.
- Crucially, raw total cost alone can mislead greedy selection into picking a single huge view that exhausts storage and blocks multiple smaller high-impact views. Therefore, Sections 4.2-4.3 normalize cost deltas by view size Si to form the Gain and Loss metrics.
-->

---

## 4.2 Space-Normalized Gain & Loss Metrics

<div class="split46">
<div>
  <div class="card teal" style="margin-bottom: 10px;">
    <h3>Gain Metric (for Adding Views)</h3>
    <div class="formula-box" style="margin: 4px 0; font-size: 0.75em;">Gain(v) = [Cost(mv) − Cost(mv + {v})] / S<sub>{v}</sub></div>
    <p class="small-text">Benefit per unit space when adding <code>v</code> (subject to <code>S<sub>mv+{v}</sub> ≤ S<sub>s</sub></code>). Pick <strong>highest Gain</strong>.<br>
    <em>Example 2:</em> <code>Gain(C) = (35.55−34.8)/5 = 0.15</code> vs. <strong><code>Gain(P) = (35.55−31.2)/6 = 0.725</code></strong> ➔ Add <code>P</code>.</p>
  </div>
  <div class="card accent">
    <h3>Loss Metric (for Deleting Views)</h3>
    <div class="formula-box" style="margin: 4px 0; font-size: 0.75em; border-left-color: var(--accent); color: var(--accent);">Loss(v) = [Cost(mv − {v}) − Cost(mv)] / S<sub>{v}</sub></div>
    <p class="small-text">Cost penalty per unit space freed by removing <code>v</code>. Pick <strong>lowest Loss</strong>.<br>
    <em>Example 3:</em> <strong><code>Loss(C) = (21.2−20.45)/5 = 0.15</code></strong> vs. <code>Loss(P) = (22.25−20.45)/6 = 0.30</code> ➔ Remove <code>C</code>.</p>
  </div>
</div>
<div class="fig-box">
  <img src="./img/fig4_lattice4d.png" alt="Paper Fig. 4 Four-dimensional CPST lattice" style="max-height: 360px;">
  <div class="fig-cap">Fig. 4 (Paper): 4-D (C, P, S, T) lattice used in Examples 2–3 (9 queried views; Table 2 dataset).</div>
</div>
</div>

<!--
Worked Metric Examples on 4-D Lattice (Sections 4.2-4.3, Fig. 4, Examples 2-3):
- Fig. 4 models a 4-dimensional sales cube over Customers (C), Parts (P), Suppliers (S), and Time (T) with 16 lattice nodes (9 actively queried: CPT, PST, CP, CS, PT, ST, C, P, S).
- Example 2 (Addition): Starting from mv = {CPT, PST, CS, PT} with Cost(mv) = 35.55, adding C (5M) lowers cost to 34.8 (Gain = 0.15/M), while adding P (6M) lowers cost to 31.2 (Gain = 0.725/M). P delivers nearly 5x higher cost savings per MB.
- Example 3 (Deletion): Starting from all query views materialized (Cost = 20.45) when space is exceeded, removing C (5M) raises cost to 21.2 (Loss = 0.15/M), whereas removing P (6M) raises cost to 22.25 (Loss = 0.30/M). Removing C frees space at half the unit-cost penalty.
-->

---

## 5. Mid-Point Locating: MPL vs. MPL-CV

<div class="split55">
<div class="fig-box">
  <img src="./img/fig5_mpl.png" alt="Paper Fig. 5 Visual presentation of MPL" style="max-height: 235px;">
  <div class="fig-cap">Fig. 5 (Paper): MPL uses <code>k = S<sub>as</sub> / (S<sub>ls</sub> − S<sub>ss</sub>)</code> against <code>0.5</code>.</div>
</div>
<div class="fig-box">
  <img src="./img/fig6_mplcv.png" alt="Paper Fig. 6 Visual presentation of MPL-CV" style="max-height: 235px;">
  <div class="fig-cap">Fig. 6 (Paper): MPL-CV prunes oversized views first, then compares <code>S<sub>as</sub></code> to <code>r = S<sub>cs</sub> / 2</code>.</div>
</div>
</div>

<div class="two-col" style="margin-top: 10px;">
<div class="card">
  <h3>MPL Limitation: Mid-Point Distortion</h3>
  <p class="small-text">In MPL, maximal space <code>S<sub>ls</sub></code> includes huge un-materializable views (larger than available space <code>S<sub>as</sub></code>), skewing <code>k &lt; 0.5</code> and forcing unnecessary bottom-up addition loops.</p>
</div>
<div class="card teal">
  <h3>MPL-CV Breakthrough: Candidate Pruning</h3>
  <p class="small-text">MPL-CV discards any view with <code>S<sub>i</sub> &gt; S<sub>as</sub></code> upfront, forming true candidate space <code>S<sub>cs</sub></code> and accurate mid-point <code>r = S<sub>cs</sub> / 2</code>—eliminating erroneous mid-point judgments.</p>
</div>
</div>

<!--
Algorithmic Evolution from MPL to MPL-CV (Sections 5.1-5.2, Figs. 5-6):
- Minimal space Sss is the smallest space needed to answer all queries (Mss); maximal space Sls materializes all query views (Mls); available space Sas = Ss - Sss.
- MPL computes k = Sas / (Sls - Sss): if k < 0.5, start at Mss and iteratively add highest-Gain views; if k >= 0.5, start at Mls and iteratively delete lowest-Loss views.
- Why MPL can misjudge: Suppose Sas = 30M and remaining views include one giant view CPS (100M) plus five small views totaling 24M. MPL sees Sls - Sss = 124M, computes k = 30/124 = 0.24 < 0.5, and runs 4-5 addition loops—even though CPS can NEVER fit! MPL-CV prunes CPS immediately, sees Scs = 24M <= Sas = 30M, and materializes all 5 feasible candidates in 0 extra loops!
-->

---

## 5.2 MPL-CV Decision Workflow (10-Step Algorithm)

<div class="fig-box" style="margin-bottom: 12px;">
<img src="./img/diag2_mplcv_decision.svg" alt="MPL-CV Candidate Pruning and Mid-Point Decision Flowchart" style="max-height: 295px;">
</div>

<div class="three-col">
<div class="card">
  <h3>Boundary Fast-Exits</h3>
  <p class="small-text">If <code>S<sub>s</sub> ≥ S<sub>ls</sub></code> ➔ materialize all (<code>M<sub>ls</sub></code>). If <code>S<sub>s</sub> = S<sub>ss</sub></code> ➔ return <code>M<sub>ss</sub></code>. If <code>S<sub>s</sub> &lt; S<sub>ss</sub></code> ➔ infeasible (<code>∅</code>).</p>
</div>
<div class="card teal">
  <h3>Dynamic Re-Pruning</h3>
  <p class="small-text">In Step 6 of addition, remaining space <code>S<sub>rs</sub> = S<sub>s</sub> − S<sub>mv</sub></code> dynamically shrinks the candidate pool <code>M<sub>cs</sub></code> each loop.</p>
</div>
<div class="card accent">
  <h3>Zero-Loop Optimal Case</h3>
  <p class="small-text">If <code>r &lt; S<sub>as</sub></code> and <code>S<sub>mv</sub> = S<sub>ss</sub> + S<sub>cs</sub> ≤ S<sub>s</sub></code>, Step 5 exits immediately—materializing all feasible candidates in <strong>0 loops</strong>!</p>
</div>
</div>

<!--
Detailed 10-Step MPL-CV Mechanics (Section 5.2):
- Steps 1-3 compute Mss, Sss, Mls, Sls, and Sas = Ss - Sss, handling trivial boundary cases immediately.
- Step 4 filters out views exceeding Sas to obtain candidate set Mcs, candidate space Scs, and mid-point r = Scs / 2.
- Step 5 branches:
  - If r >= Sas (tight space): initialize mv = Mss and loop Steps 6-7, adding the highest-Gain candidate view using vector-lattice Cost(mv) evaluation until Mcs is empty or remaining space Srs < min(Si).
  - If r < Sas (ample space): initialize mv = Mss + Mcs. If total space Smv <= Ss, terminate immediately (Step 10); otherwise loop Steps 8-9, deleting the lowest-Loss candidate view until Smv <= Ss.
-->

---

## 6. Experiments (w = 0): Scaling Actual Space

Using the 4-D dataset (Table 2; minimal space <code>S<sub>ss</sub> = 140M</code> for <code>{CPT, PST, CS}</code>), we compare **Two-Phase**, **MPL**, and **MPL-CV** across five storage budgets (Table 5):

| Case | Storage Limit (`S_s`) | Two-Phase Loops | MPL Loops | MPL-CV Loops | Optimal `Cost(mv)` (All 3) |
| :---: | :---: | :---: | :---: | :---: | :---: |
| 1 | 140M | 1 | 1 | 1 | 41.80 |
| 2 | 160M | 1 | 1 | 1 | 30.30 |
| 3 | 180M | 2 | 2 | 2 | 26.40 |
| **4** | **200M** | **5** | **1** | **1** | **22.95** |
| **5** | **210M** | **5** | **1** | **1** | **22.95** |

<div class="callout teal" style="margin-top: 10px;">
<strong>Key Finding (57.1% Loop Reduction):</strong> All three algorithms achieve the exact same optimal <code>Cost(mv)</code>, yet MPL and MPL-CV cut total lattice-evaluation loops from 14 down to 6—an average speedup of <strong>57.1%</strong>—by switching to deletion at <code>S<sub>s</sub> ≥ 200M</code>.
</div>

<!--
Experiment 6.1.1 Analysis (Table 5):
- Each loop requires recomputing Cost(mv) across the entire lattice for every candidate view, making loop count the dominant driver of execution time.
- At Ss = 140M, 160M, and 180M (tight space), all algorithms perform bottom-up addition (1, 1, 2 loops).
- Once Ss reaches 200M and 210M (closer to maximal space), Two-Phase still grinds through 5 bottom-up addition loops, whereas MPL and MPL-CV jump to the upper set and converge in just 1 deletion loop—achieving 80% fewer loops in Cases 4-5 and 57.1% fewer loops overall (6 vs. 14).
-->

---

## 6.2 Experiments (w = 0): Available Space & Pruning Effect

<div class="split46">
<div class="card">
  <h3>Dataset 2 Setup (Table 3)</h3>
  <ul class="small-text">
    <li>Minimal view set: <code>{CPST}</code> with <code>S<sub>ss</sub> = 200M</code>.</li>
    <li>Remaining 6 views: <code>{CPS(100M), CP(5M), CS(5M), PS(5M), PT(5M), C(4M)}</code>.</li>
    <li>Available space <code>S<sub>as</sub></code> varied from <code>10M</code> to <code>35M</code>.</li>
  </ul>
  <h3 style="margin-top: 10px;">Why MPL-CV Dominates MPL Here</h3>
  <ul class="small-text">
    <li><strong>MPL Trap:</strong> Giant <code>CPS (100M)</code> inflates <code>S<sub>ls</sub> − S<sub>ss</sub> = 124M</code> ➔ MPL stays stuck in 4 addition loops even at <code>30M</code>!</li>
    <li><strong>MPL-CV Pruning:</strong> Eliminates <code>CPS (100M)</code> immediately ➔ <code>S<sub>cs</sub> = 24M</code> ➔ drops to <strong>2, 1, 0, 1 loops</strong> for <code>20M–35M</code>!</li>
  </ul>
</div>
<div class="fig-box">
  <img src="./img/fig7_loops_w0.png" alt="Paper Fig. 7 Loops vs available space for w=0" style="max-height: 365px;">
  <div class="fig-cap">Fig. 7 (Paper): Loop counts as available space grows from 10M to 35M (<code>w = 0</code>).</div>
</div>
</div>

<!--
Experiment 6.1.2 Analysis (Table 3, Fig. 7):
- This experiment directly isolates the benefit of candidate-view pruning in MPL-CV.
- Because CPS requires 100M while available space Sas is only 10M-35M, CPS is strictly infeasible.
- Both Two-Phase and MPL fail to exclude CPS from the mid-point calculation, causing them to execute 4 full lattice-evaluation loops at 20M, 25M, 30M, and 35M.
- MPL-CV prunes CPS immediately, leaving 5 real candidates totaling 24M (r = 12M). At 20M and 25M, MPL-CV switches to deletion (2 and 1 loops); at 30M (24M <= 30M), MPL-CV terminates in 0 loops!
-->

---

## 6.3 Experiments (w ≠ 0): Maintenance Weight Trade-Off

Setting actual space <code>S<sub>s</sub> = 190M</code> (<code>S<sub>ss</sub> = 140M</code>, Table 4) and varying maintenance-to-query weight <code>w ∈ [0.3, 0.7]</code>:

<div class="split55" style="margin-top: 4px;">
<div class="fig-box">
  <img src="./img/fig8_loops_wnz.png" alt="Paper Fig. 8 Loops vs maintenance weight w" style="max-height: 235px;">
  <div class="fig-cap">Fig. 8 (Paper): Selection loop counts across <code>w = 0.3..0.7</code>.</div>
</div>
<div class="fig-box">
  <img src="./img/fig9_cost_wnz.png" alt="Paper Fig. 9 Total Cost(mv) vs weight w" style="max-height: 235px;">
  <div class="fig-cap">Fig. 9 (Paper): Total warehouse <code>Cost(mv)</code> across <code>w = 0.3..0.7</code>.</div>
</div>
</div>

<div class="three-col" style="margin-top: 10px;">
<div class="kpi-card teal">
  <div class="kpi-val">47.4% Fewer Loops</div>
  <div class="kpi-label">MPL &amp; MPL-CV average loop reduction vs. Two-Phase when <code>w ≠ 0</code></div>
</div>
<div class="kpi-card">
  <div class="kpi-val">9%–33% Faster</div>
  <div class="kpi-label">MPL-CV further reduces loops by 9% avg (up to 33% at <code>w = 0.6</code>) over MPL</div>
</div>
<div class="kpi-card accent">
  <div class="kpi-val">25.5% Lower Cost</div>
  <div class="kpi-label">Average reduction in total <code>Cost(mv)</code> over Two-Phase across all <code>w</code></div>
</div>
</div>

<!--
Experiment 6.2 Analysis (Table 4, Figs. 8-9):
- When maintenance cost is active (w != 0), Two-Phase ignores update frequencies and selects views purely for query speedup, causing total Cost(mv) to surge sharply as w rises from 0.3 to 0.7 (reaching ~70 at w = 0.6-0.7).
- By embedding w * CM directly into Gain and Loss metrics, MPL and MPL-CV avoid materializing update-expensive views, cutting total Cost(mv) by 25.5% on average while slashing selection loops by 47.4% relative to Two-Phase.
- At w = 0.6, MPL-CV reduces loops from 3 (MPL) to 2 (a 33% improvement), averaging 9% fewer loops than MPL across the sweep.
-->

---

## 7. Discussion, Limitations & Future Work

<div class="two-col">
<div class="card teal">
  <h3>Core Contributions</h3>
  <ul class="small-text">
    <li><strong>Binary Vector Lattice &amp; Bitwise Rewrite:</strong> Accelerates dependent-view lookup and query rewriting using constant-time bitwise <code>AND</code>.</li>
    <li><strong>Joint Space-Normalized Metrics:</strong> Gain and Loss metrics unify query cost, weighted maintenance cost, and per-MB space efficiency.</li>
    <li><strong>Adaptive Bidirectional Search (MPL-CV):</strong> Candidate pruning + mid-point cutting achieves <strong>47.4%–57.1%</strong> fewer loops and <strong>25.5%</strong> lower total DW cost.</li>
  </ul>
</div>
<div class="card accent">
  <h3>Limitations &amp; Future Directions</h3>
  <ul class="small-text">
    <li><strong>Static Workload Assumption:</strong> Experiments assume fixed query/update frequencies; real e-commerce OLAP workloads drift over time.</li>
    <li><strong>Lattice Scale:</strong> Validated on 3-D and 4-D synthetic cubes (16 nodes); higher-dimensional enterprise cubes merit scalability benchmarks.</li>
    <li><strong>Future Work 1 — Online View Evolution:</strong> Dynamically adding/deleting materialized views in response to live queries with minimal DW disruption.</li>
    <li><strong>Future Work 2 — Residual Space:</strong> Smarter utilization of leftover storage fragments after greedy termination.</li>
  </ul>
</div>
</div>

<div class="callout" style="margin-top: 14px;">
<strong>Takeaway:</strong> In NP-complete view selection, pruning infeasible candidates before choosing between bottom-up addition and top-down deletion simultaneously accelerates optimization and improves solution cost under maintenance-heavy workloads.
</div>

<!--
Critical Synthesis & Future Agenda (Section 7):
- The most time-consuming step in lattice-based materialized view selection is cyclic recalculation of Cost(mv). MPL-CV directly attacks this bottleneck from two angles: bitwise vector lookup inside each evaluation, and candidate-pruned mid-point branching to minimize total iterations.
- Open research challenges identified in Section 7:
  1. Dynamic / Online Materialized View Evolution: adapting the materialized view set incrementally as user query patterns shift in real time without stalling ongoing OLAP processing.
  2. Residual Space Utilization: packing smaller beneficial views into leftover storage space that remains after primary selection terminates.
-->

---

<!-- _class: closing -->

# Thank You for Your Attention!

<p style="font-size: 1.05em; max-width: 880px;">
Efficient Approaches for Materialized Views Selection in a Data Warehouse
</p>

<div class="contact-card">
<strong>Ming-Chuan Hung<sup>*</sup></strong> · <code>mchong@fcu.edu.tw</code> &nbsp;|&nbsp; <strong>Man-Lin Huang</strong> · <code>mlhuang@fcu.edu.tw</code><br>
<strong>Don-Lin Yang</strong> · <code>dlyang@fcu.edu.tw</code> &nbsp;|&nbsp; <strong>Nien-Lin Hsueh</strong> · <code>nlhsueh@fcu.edu.tw</code><br>
Department of Information Engineering and Computer Science, Feng Chia University<br>
<span style="font-size: 0.85em; opacity: 0.88;">Information Sciences, Vol. 177 (2007), pp. 1333–1348 · Grant NSC 94-2213-E-035-002</span>
</div>

<!--
Archival Reference Metadata:
- Title: Efficient approaches for materialized views selection in a data warehouse
- Authors: Ming-Chuan Hung (corresponding author), Man-Lin Huang, Don-Lin Yang, Nien-Lin Hsueh
- Venue: Information Sciences, Elsevier, Vol. 177, pp. 1333-1348, 2007
- DOI: 10.1016/j.ins.2006.09.007
- Keywords: Materialized view, Data warehouse, OLAP, Query rewrite, Gain metric, Loss metric
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
