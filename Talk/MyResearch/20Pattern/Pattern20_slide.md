---
marp: true
theme: gaia
size: 16:9
paginate: true
html: true
header: '<div class="hdr-wrap"><span class="hdr-title">Design Pattern Analysis with Software Evolution Data</span><div class="nav-dropdown"><button class="nav-btn">Sections ▾</button><div class="nav-menu"><a href="#2">Opening Hook: Dust Collector?</a><a href="#3">Outline</a><a href="#4">1. Introduction & RQs</a><a href="#6">2. Background & Related Work</a><a href="#7">3. Utilization Evaluation Method</a><a href="#11">4. PUA System & Experiments</a><a href="#15">5. Statistical Analysis & Threats</a><a href="#18">6. Conclusion & Future Work</a></div></div></div>'
footer: 'Nien-Lin Hsueh · Feng Chia University · JISE Vol. 36, pp. 53–73 (2020)'
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
  font-size: 20.5px;
  line-height: 1.48;
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
  min-width: 235px;
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
  font-size: 1.7em;
  font-weight: 800;
  line-height: 1.22;
  margin: 0 0 12px 0;
}

h2 {
  color: var(--navy);
  font-size: 1.26em;
  font-weight: 700;
  line-height: 1.25;
  margin: 0 0 13px 0;
  padding-bottom: 6px;
  border-bottom: 2.5px solid var(--navy);
  display: flex;
  align-items: center;
  gap: 8px;
}

h3 {
  color: var(--accent);
  font-size: 0.96em;
  font-weight: 700;
  margin: 4px 0 6px 0;
}

p { margin: 0 0 8px 0; }
ul, ol { margin: 4px 0 8px 0; padding-left: 22px; }
li { margin-bottom: 5px; line-height: 1.43; }
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
  text-transform: uppercase;
  padding: 5px 14px;
  border-radius: 999px;
  margin-bottom: 18px;
}

section.lead h1 {
  color: #ffffff;
  font-size: 2.15em;
  font-weight: 800;
  line-height: 1.24;
  margin-bottom: 16px;
  text-align: left;
}

section.lead .subtitle {
  color: #cbd5e1;
  font-size: 0.95em;
  line-height: 1.5;
  margin-bottom: 26px;
  max-width: 940px;
}

section.lead .meta-box {
  border-left: 4px solid #f43f5e;
  padding-left: 18px;
  color: #e2e8f0;
  font-size: 0.85em;
  line-height: 1.58;
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
section.closing h1 { color: #ffffff; font-size: 2.25em; margin-bottom: 12px; }
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

/* Grids & Layouts */
.two-col { display: grid; grid-template-columns: 1fr 1fr; gap: 18px; align-items: stretch; }
.three-col { display: grid; grid-template-columns: repeat(3, 1fr); gap: 14px; align-items: stretch; }
.four-col { display: grid; grid-template-columns: repeat(4, 1fr); gap: 12px; align-items: stretch; }
.split64 { display: grid; grid-template-columns: 56% 42%; gap: 2%; align-items: center; }
.split55 { display: grid; grid-template-columns: 49% 49%; gap: 2%; align-items: center; }
.split46 { display: grid; grid-template-columns: 42% 56%; gap: 2%; align-items: center; }

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
  padding: 9px 14px;
  box-sizing: border-box;
}

.kpi-card.accent { border-left-color: var(--accent); background: var(--accent-soft); }
.kpi-card.teal { border-left-color: var(--teal); background: var(--teal-soft); }

.kpi-val { font-size: 1.38em; font-weight: 800; color: var(--navy); line-height: 1.15; margin-bottom: 2px; }
.kpi-card.accent .kpi-val { color: var(--accent); }
.kpi-card.teal .kpi-val { color: var(--teal); }
.kpi-label { font-size: 0.74em; color: var(--slate-700); line-height: 1.3; }

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
  font-size: 0.72em;
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
  padding: 4px 8px;
  border: 1px solid var(--slate-200);
  vertical-align: middle;
  line-height: 1.28;
}

tr:nth-child(even) td { background: #f8fafc; }

table.dense { font-size: 0.62em; }
table.dense th, table.dense td { padding: 3px 6px; text-align: center; }
table.dense td:first-child, table.dense th:first-child { text-align: left; font-weight: 700; }
.hi-cell { background: #ccfbf1 !important; color: #0f766e !important; font-weight: 800; }
.mid-cell { background: #e0f2fe !important; color: #1b365d !important; font-weight: 700; }
.zero-cell { color: #94a3b8; }

/* Formula Box */
.formula-box {
  background: #f8fafc;
  border: 1.5px solid #cbd5e1;
  border-left: 4px solid var(--navy);
  border-radius: 8px;
  padding: 8px 14px;
  margin-bottom: 8px;
  display: flex;
  justify-content: center;
  align-items: center;
  font-family: 'Georgia', 'Times New Roman', serif;
  font-size: 0.92em;
  color: var(--slate-900);
}

.formula-box.teal { border-left-color: var(--teal); background: var(--teal-soft); }
.formula-box.accent { border-left-color: var(--accent); background: var(--accent-soft); }

.frac {
  display: inline-flex;
  flex-direction: column;
  align-items: center;
  vertical-align: middle;
  margin: 0 6px;
  line-height: 1.1;
}

.frac-num { border-bottom: 1.5px solid var(--slate-900); padding: 0 6px 2px 6px; }
.frac-den { padding: 2px 6px 0 6px; }

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

.outline-body { font-size: 0.85em; line-height: 1.38; }
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

.small-text { font-size: 0.81em; }

/* Incremental RQ Grid */
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
  gap: 18px;
  background: #ffffff;
  border: 1px solid var(--slate-200);
  border-left: 5px solid var(--navy);
  border-radius: 10px;
  padding: 14px 20px;
  box-shadow: 0 2px 8px rgba(15, 23, 42, 0.06);
  box-sizing: border-box;
}

.rq-card.teal { border-left-color: var(--teal); }
.rq-card.accent { border-left-color: var(--accent); }
.rq-card img { width: 84px; height: 84px; flex-shrink: 0; border-radius: 10px; }
.rq-hook { font-size: 0.96em; font-weight: 800; color: var(--navy); line-height: 1.3; margin-bottom: 5px; }
.rq-card.teal .rq-hook { color: var(--teal); }
.rq-card.accent .rq-hook { color: var(--accent); }
.rq-q { font-size: 0.82em; color: var(--slate-700); line-height: 1.42; }

.obj-strip { display: grid; grid-template-columns: repeat(4, 1fr); gap: 10px; margin-bottom: 14px; }
.obj-pill {
  background: var(--slate-100);
  border: 1px solid var(--slate-200);
  border-top: 3px solid var(--navy);
  border-radius: 7px;
  padding: 7px 10px;
  font-size: 0.72em;
  line-height: 1.32;
  color: var(--slate-700);
}
.obj-pill strong { color: var(--navy); }

.future-strip { display: grid; grid-template-columns: repeat(3, 1fr); gap: 12px; margin-top: 10px; }
.future-pill {
  background: #f8fafc;
  border: 1px solid var(--slate-200);
  border-left: 4px solid var(--teal);
  border-radius: 8px;
  padding: 8px 12px;
  font-size: 0.74em;
  line-height: 1.38;
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

</style>

<!-- _class: lead -->

<div class="badge">Journal of Information Science and Engineering · Vol. 36, pp. 53–73 (2020)</div>

# Design Pattern Analysis with Software Evolution Data

<div class="subtitle">
Evaluating whether deployed <strong>GoF Design Patterns</strong> are truly utilized across software releases using <strong>Pattern Application Context (PAC)</strong>, <strong>Expected Pattern Utilization (EPU)</strong>, and <strong>Degree of Utilization (DoU)</strong>
</div>

<div class="meta-box">
<strong>Nien-Lin Hsueh</strong><br>
Department of Information Engineering and Computer Science, Feng Chia University, Taichung 407, Taiwan<br>
<code>nlhsueh@fcu.edu.tw</code> · DOI: <code>10.6688/JISE.202001_36(1).0004</code>
</div>

<div class="grant">
Supported by the Ministry of Science and Technology (MOST), Taiwan, under grant MOST 106-2221-E-035-MY2.
</div>

<!--
Paper Context & Contribution:
- Bibliographic record: Nien-Lin Hsueh, "Design Pattern Analysis with Software Evolution Data," Journal of Information Science and Engineering (JISE), Vol. 36, No. 1, pp. 53–73, January 2020 (DOI: 10.6688/JISE.202001_36(1).0004; received July 19, 2018; accepted September 17, 2018; supported by MOST 106-2221-E-035-MY2).
- Core problem addressed: Although Gang-of-Four (GoF) design patterns are widely deployed to improve software maintainability and extensibility, prior evaluation methods inspect only static single-version snapshots, overlooking whether patterns actually absorb evolutionary change across releases.
- Methodological & empirical scope: The paper formalizes Pattern Application Context (PAC), Expected Pattern Utilization (EPU), and Degree of Utilization (DoU), implements the web-based Pattern Utilization Analyzer (PUA), and evaluates 11 quality-improver GoF patterns (grouped into 9 categories) across 15 open-source Java systems spanning 296 software evolutions.
-->

---

## Opening Hook: Architectural Investment... Or Cobwebbed Dust Collector?

<div class="fig-box" style="padding: 6px; margin-bottom: 10px; background: #fbf9f2;">
<img src="./img/pattern20_hook.jpg" alt="DoU = 0% Dust Collector vs Utilized in Evolution" style="max-height: 415px; border-radius: 6px;">
</div>

<div class="callout" style="margin-top: 6px; padding: 9px 16px;">
<strong>The Big Idea:</strong> Developers apply design patterns to make software flexible for future change — yet across <strong>15 open-source projects (296 evolutions)</strong>, most deployed patterns are <strong>rarely or never extended</strong> after initial deployment.
</div>

<!--
Empirical Paradox of Pattern Over-Engineering:
- Architectural investment vs. maintenance overhead: Deploying a design pattern introduces extra abstractions, interfaces, and indirection to prepare for anticipated future changes. When those anticipated extensions never occur—or when patterns are over-applied or misused—the added structural complexity increases maintenance burden or impairs performance without yielding evolutionary payoff.
- Longitudinal evidence across 296 evolutions: Empirical tracking of 15 real-world Java open-source projects from SourceForge reveals that the vast majority of deployed pattern instances exhibit low utilization (mean DoU < 0.20 across every pattern type), with numerous instances scoring DoU = 0 (deployed but never extended after initial introduction).
- Analytical implication: This empirical gap motivates testing whether low utilization is an inherent property of specific GoF pattern types (RQ1) or a reflection of project domain alignment and team architectural discipline (RQ2).
-->

---

## Presentation Outline

<div class="outline-grid">

<div class="outline-item">
<div class="outline-num">1</div>
<div class="outline-body">

[**Introduction & Research Questions**](#4)
Why static snapshots fail to evaluate maintainability, plus our 4 objectives and 2 formal RQs.

</div>
</div>

<div class="outline-item">
<div class="outline-num">2</div>
<div class="outline-body">

[**Background & Related Work**](#6)
Comparison of 12 pattern-evaluation studies (Table 1) and graph-similarity pattern detection.

</div>
</div>

<div class="outline-item">
<div class="outline-num">3</div>
<div class="outline-body">

[**Utilization Evaluation Methodology**](#7)
Pattern classification, FR/NFR-intent, formal PAC & EPU definitions, and the DoU metric.

</div>
</div>

<div class="outline-item">
<div class="outline-num">4</div>
<div class="outline-body">

[**PUA System & Experimental Results**](#11)
Pattern Utilization Analyzer architecture, JHotDraw case study, and 15 OSS project results.

</div>
</div>

<div class="outline-item">
<div class="outline-num">5</div>
<div class="outline-body">

[**Statistical Analysis & Threats to Validity**](#15)
One-way ANOVA for RQ1 (Pattern Type) & RQ2 (OSS Project), Scheffé post-hoc test, and threats.

</div>
</div>

<div class="outline-item">
<div class="outline-num">6</div>
<div class="outline-body">

[**Conclusion & Future Work**](#18)
Empirical synthesis of RQ1–RQ2, practical takeaways for teams, and roadmap for PUA.

</div>
</div>

</div>

<!--
Paper Structure & Analytical Roadmap:
- Sections 1–2 (Introduction & Background): Articulates why maintainability evaluation requires multi-version evolution data rather than static snapshots, categorizes 12 prior pattern-evaluation studies (Table 1), and justifies adopting Tsantalis et al.'s graph-similarity detector over DP-Miner.
- Section 3 (Utilization Evaluation Methodology): Introduces the four-role pattern classification, separates FR-intent from NFR-intent, and mathematically defines PAC, EPU, the utilization predicate, and DoU (Equations 1–6; Figures 3–6).
- Section 4 (System Design & Experimental Results): Presents the three-module PUA web architecture (Figure 7), walks through 6 Observer instances in JHotDraw (Figure 8), documents the 15-project SourceForge benchmark (Table 2), and reports the full 15 × 9 DoU matrix (Table 3).
- Sections 5–6 (Statistical Analysis, Validity & Conclusion): Conducts One-Way ANOVA and Scheffé post-hoc contrasts for RQ1 and RQ2 (Tables 4–6; Figures 9–10), audits four validity dimensions following Yin's template, and outlines practical maintenance actions and future cloud-scale extensions.
-->

---

## 1.1 Motivation: Why Static Snapshots Miss Pattern Value

<div class="fig-box" style="padding: 8px 10px; margin-bottom: 10px;">
<img src="./img/diag1_static_vs_evolution.svg" alt="Static Snapshot vs Evolutionary Utilization" style="max-height: 360px;">
</div>

<div class="callout">
<strong>Evolutionary Principle:</strong> Most design patterns target <strong>maintainability & extensibility</strong> over time. Over-applied or unused patterns add structural complexity without payoff — so evaluation must span <strong>all consecutive versions</strong>, not a single snapshot.
</div>

<!--
Why Evolutionary Data Is Necessary for Pattern Evaluation:
- Limitation of static snapshot models: Traditional quality evaluations inspect a single version of a codebase using object-oriented metrics or static quality models. Because most GoF patterns exist specifically to lower future maintenance cost under evolving requirements, a single snapshot can verify structural presence but cannot determine whether the pattern ever fulfilled its extensibility purpose.
- Contrasting evolutionary trajectories (Paper Figs. 1–2): If a Strategy pattern dp1 is deployed in v1 to enable future algorithm substitution, yet no ConcreteStrategy class is ever added or removed from v1 through v10 (Fig. 1), the pattern is under-utilized. Conversely, if a Strategy class is removed between v1 and v2 and a new one is added between v2 and vn (Fig. 2), the pattern actively absorbed design change through extension rather than modification.
- Hot spots for change: Expected utilization operationalizes the intended "hot spot for change" of a pattern, enabling objective post-hoc auditing across all consecutive releases in a version control repository.
-->

---

## 1.2 Research Objectives & Two Research Questions

<div class="obj-strip">
<div class="obj-pill"><strong>1. Methodology</strong><br>Formulate pattern utilization using evolution data.</div>
<div class="obj-pill"><strong>2. Automation</strong><br>Build the web-based <code>PUA</code> analyzer tool.</div>
<div class="obj-pill"><strong>3. Empirical Study</strong><br>Evaluate 11 patterns over 15 OSS (296 evolutions).</div>
<div class="obj-pill"><strong>4. Statistics</strong><br>Test whether DoU depends on pattern type or project.</div>
</div>

We test two core statistical research questions using One-Way ANOVA *(revealed step-by-step)*:

<div class="rq-stage">

* <div class="rq-card teal"><img src="./img/rq1_pattern.svg" alt="RQ1 Pattern Type vs DoU"><div><div class="rq-hook"><span class="rq-tag" style="background:#0f766e;">RQ1</span> Do certain design patterns naturally get utilized more often than others?</div><div class="rq-q"><strong>Is there any statistical difference between the DoU of deployed patterns and their type?</strong> (Across 9 quality-improver pattern groups covering 11 GoF patterns.)</div></div></div>
* <div class="rq-card accent"><img src="./img/rq2_project.svg" alt="RQ2 OSS Project vs DoU"><div><div class="rq-hook"><span class="rq-tag">RQ2</span> Or does utilization depend on the project domain & engineering discipline?</div><div class="rq-q"><strong>Is there any statistical difference between the DoU of deployed patterns and the open source project?</strong> (Across 15 real-world Java OSS systems.)</div></div></div>

</div>

<!--
Four Research Objectives & Statistical Hypotheses:
- Four operational objectives: (1) Formulate a rigorous, evolution-based pattern utilization metric; (2) build an automated analysis tool (PUA) to compute it across release histories; (3) apply the tool to 15 publicly archived SourceForge Java systems (leveraging transparent OSS version histories); and (4) statistically test whether utilization varies by pattern type or by project.
- RQ1 (Pattern-Type Factor): Tests H0: μ1 = μ2 = ... = μ9 against H1 (unequal means) via One-Way ANOVA (α = 0.05) across 9 quality-improver pattern groups covering 11 GoF patterns, evaluating whether certain patterns inherently achieve higher DoU regardless of host system.
- RQ2 (Project-Domain Factor): Tests H0: μ1 = μ2 = ... = μ15 via One-Way ANOVA (α = 0.05) across 15 OSS projects, evaluating whether application domain characteristics (e.g., MVC GUI frameworks vs. utility tools) and engineering practices drive statistically significant differences in DoU.
-->

---

## 2. Background & Related Work (Table 1)

Existing studies evaluate patterns via static metrics, controlled human experiments, surveys, or decay analysis — **none automatically quantifies evolutionary utilization**.

| Research Category | Representative Studies | Method & Code Analysis | Subjects & Key Focus |
| :--- | :--- | :--- | :--- |
| **Static Metrics & Quality** | Huston [15]; Hsueh et al. [13] | Metric analysis / Quantitative (Yes/No) | Design patterns: compatibility with OO metrics & well-definedness |
| **Controlled Experiments** | Prechelt et al. [23, 24]; Ng et al. [20, 21] | Human maintenance experiments | Maintainers: pattern benefit, documentation & anticipated changes |
| **Surveys & Mapping** | Zhang & Budgen [32, 33] | Systematic review & expert survey (No) | Papers & experts: 3 patterns rated useful; 25% gain low approval |
| **Evolution, Grime & Defects** | Aversano et al. [2]; Vokáč [30]; Izurieta [16] | Automated tools on code (Yes) | Software: change frequency, defect rate, pattern grime & decay |
| **Evolutionary Utilization** | **Hsueh [12] & This Work (2020)** | **Automated PUA tool on code (Yes)** | **15 OSS projects (296 evolutions): PAC/EPU conformance & DoU** |

<div class="callout teal">
<strong>Pattern Detection Foundation:</strong> We adopt <strong>Tsantalis et al. [28]</strong> (graph-similarity scoring on static class matrices) rather than DP-Miner [6], because it supports modified pattern variants and achieves <strong>100% precision & recall</strong> on JHotDraw.
</div>

<!--
Comparative Taxonomy of Pattern Evaluation & Detection Literature (Table 1):
- Four evaluation criteria in Table 1: Prior studies are classified by Motivation, Method, Code Analysis (Yes/No), and Subjects (Design Patterns, Software, Research Papers, or Human participants).
  - Static metrics & well-definedness: Huston (2001) showed OO metrics often produce conflicting evaluations of patterns; Hsueh et al. (2008) proposed quantitative well-definedness validation without code evolution.
  - Controlled human experiments: Prechelt et al. (2001, 2002) compared patterns against simpler designs and tested explicit pattern documentation; Ng et al. (2007, 2012) showed maintainers who utilize deployed patterns deliver significantly less faulty code, while highlighting comprehension and human factors.
  - Surveys & mapping studies: Zhang & Budgen (2012, 2013) found only 3 GoF patterns were broadly rated useful by experienced practitioners, whereas 25% received low approval.
  - Evolution, grime & defects: Aversano et al. (2007) tracked pattern change frequency and co-change; Vokáč (2004) correlated pattern presence with defect rates; Izurieta & Bieman (2013) analyzed pattern grime and decay on 3 OSS systems; Hsueh et al. (2011) performed preliminary occasion/effectiveness analysis on Jaxe alone.
- Detection engine choice: Tsantalis et al. (2006) encode class relationships as graphs/matrices and apply vertex similarity scoring, successfully recovering modified pattern variants with 100% precision and 100% recall on JHotDraw. By contrast, Dong et al.'s DP-Miner (2007) uses weighted matrices for static behavioral analysis but lacks support for pattern deviations and dynamic analysis.
-->

---

## 3.1 Utilization Evaluation Methodology Overview

<div class="fig-box" style="padding: 8px 10px; margin-bottom: 10px;">
<img src="./img/diag2_eval_pipeline.svg" alt="Two-Track Pattern Utilization Evaluation Pipeline" style="max-height: 360px;">
</div>

<div class="callout">
<strong>Two-Track Design:</strong> <strong>Track A (Theory)</strong> filters quality-improver patterns and defines their <em>Expected Pattern Utilization (EPU)</em> from NFR-intent; <strong>Track B (Practice)</strong> extracts <em>Pattern Application Context (PAC)</em> across versions to measure conformance.
</div>

<!--
Two-Track Evaluation Architecture (Fig. 3):
- Track A — Theoretical Specification (Left side of Fig. 3): Begins by filtering GoF patterns because not all patterns target maintainability. After isolating Quality-Improver patterns, each pattern's intent is decomposed into FR-intent (functional baseline) and NFR-intent (quality extension), from which its formal Expected Pattern Utilization (EPU) rules are derived.
- Track B — Empirical Mining (Right side of Fig. 3): Harvests consecutive source-code releases of target software projects, detects deployed pattern instances per release via graph-similarity matching, and extracts each instance's Pattern Application Context (PAC).
- Conformance bridge: Track A and Track B converge at the utilization predicate, which checks whether the structural delta between consecutive PACs conforms to the pattern's theoretical EPU, yielding an objective longitudinal DoU score.
-->

---

## 3.2 Pattern Classification & FR/NFR-Intent Analysis

Not every GoF pattern targets maintainability. First, we classify patterns into **four roles** [14] and isolate **Quality-Improver** patterns:

<div class="four-col" style="margin-bottom: 10px;">
<div class="card small-text">

### Activity-Facilitator
Facilitates recurring design tasks (decomposition, object allocation, access control).

</div>
<div class="card teal small-text" style="background: var(--teal-soft);">

### ★ Quality-Improver
**Our Focus:** Satisfies functional requirements while enhancing NFRs (extensibility, maintainability).

</div>
<div class="card small-text">

### Conflict-Resolver
Balances competing resources, divergent expectations, or side-effect requirement conflicts.

</div>
<div class="card small-text">

### Problem-Solver
Resolves boundary conditions and reliability issues (e.g., inconsistency via Observer).

</div>
</div>

<div class="split55">
<div class="left">
<div class="fig-box" style="padding: 8px;">
<img src="./img/fig4_fr_nfr_strategy.png" alt="FR and NFR structure of Strategy pattern" style="max-height: 155px;">
<div class="fig-cap">Fig. 4 · FR-structure (left) vs. NFR-structure (right) of Strategy pattern</div>
</div>
</div>
<div class="right small-text">

- **FR-Intent (What it does)**: A `Context` uses an algorithm to solve a problem (simple FR-structure).
- **NFR-Intent (Quality gain)**: Introduces an abstract `Strategy` interface so new `ConcreteStrategy` algorithms can be **added or removed** without modifying `Context`.

</div>
</div>

<!--
Four-Role Pattern Taxonomy & Intent Decomposition (Fig. 4):
- Four design pattern roles (Hsueh et al., 2009):
  1. Activity-Facilitator: Supports recurring non-algorithmic design tasks (system decomposition, object allocation, access control, control flow, component composition).
  2. Quality-Improver (study focus): Addresses subjective, relative, and interacting non-functional requirements (NFRs) by extending a basic functional solution with higher maintainability, reusability, or extensibility.
  3. Conflict-Resolver: Balances competing resources, divergent expectations, or design-phase side-effect conflicts via specialization, agents, or arbitrators.
  4. Problem-Solver: Prevents boundary exceptions and reliability failures (e.g., Observer resolving state inconsistency between a Subject and registered Observers).
- FR-structure vs. NFR-structure (Fig. 4, Strategy): The FR-intent ("what it does") lets a Context invoke an algorithm via a simple direct structure (FR-structure). The NFR-intent ("quality gain") introduces an abstract Strategy interface role (NFR-structure) so ConcreteStrategy classes can be added or removed without altering Context. Because utilization measures satisfaction of NFR-intent during evolution, only Quality-Improver patterns are evaluated under this framework.
-->

---

## 3.3 Formal Model: PAC, EPU & Utilization Predicate

<div class="split55">
<div class="left">

<div class="formula-box">
<strong>PAC(dp, D)</strong>&nbsp; = &nbsp;{ &lt;element, r&gt; }
</div>

<div class="formula-box teal">
<strong>EPU(dp)</strong>&nbsp; = &nbsp;{ &lt;role, operator&gt; }, &nbsp;operator ∈ {+, −}
</div>

<div class="formula-box accent" style="display: block; text-align: center; font-size: 0.8em; line-height: 1.48;">
<strong>utilized(dp, D<sub>j+1</sub>)</strong> &nbsp;⇔<br>
∃ D<sub>j</sub>, Δ(PAC(dp, D<sub>j</sub>), PAC(dp, D<sub>j+1</sub>)) conforms to EPU(dp)
</div>

<div class="card small-text">

### Strategy Example (Data Compression)
- **PAC**: `{<DataCompression, R_C>, <CompressionTool, R_S>, <RAR, R_CS>, <ZIP, R_CS>}`
- **EPU(Strategy)**: `{<R_CS, +>, <R_CS, −>}` (add or remove a ConcreteStrategy).

</div>

</div>
<div class="right">

<div class="fig-box" style="padding: 10px;">
<img src="./img/fig5_utilized_example.png" alt="Utilized Strategy pattern adding 7-zip" style="max-height: 200px;">
<div class="fig-cap">Fig. 5 · Adding <code>7-zip</code> in D<sub>j+1</sub> conforms to EPU(Strategy)</div>
</div>

<div class="callout teal" style="margin-top: 10px;">
<strong>Core Criterion:</strong> A deployed pattern is declared <strong>utilized</strong> between consecutive versions D<sub>j</sub> → D<sub>j+1</sub> if and only if its structural delta Δ(PAC) matches its expected evolution operator in EPU(dp).
</div>

</div>
</div>

<!--
Mathematical Formalization of Pattern Utilization (Equations 1–5, Fig. 5):
- Pattern Application Context (Eq. 1): PAC(dp, D) = {<element, r>} represents the set of design elements and their assigned pattern roles r in software version D. For a data-compression Strategy deployment (Eq. 2), PAC(Strategy, D) = {<DataCompression, R_C>, <CompressionTool, R_S>, <RAR, R_CS>, <ZIP, R_CS>}, where R_C = Context, R_S = Strategy, and R_CS = ConcreteStrategy.
- Expected Pattern Utilization (Eq. 3): EPU(dp) = {<role, operator>} with operator ∈ {+, −} specifies the anticipated evolutionary structural operations on key roles. For Strategy (Eq. 4), EPU(Strategy) = {<R_CS, +>, <R_CS, −>}, capturing addition or removal of ConcreteStrategy classes without modifying Context or Strategy.
- Utilization predicate (Eq. 5): utilized(dp, D_{j+1}) ⇔ ∃ D_j such that Δ(PAC(dp, D_j), PAC(dp, D_{j+1})) conforms to EPU(dp), where D_j and D_{j+1} are consecutive versions deploying the same pattern instance dp. In Fig. 5, introducing a 7-zip class under CompressionTool in D_{j+1} produces a <R_CS, +> delta matching EPU(Strategy), formally certifying utilization.
-->

---

## 3.4 Quantifying Evolution: Degree of Utilization (DoU)

<div class="split46">
<div class="left">

<div class="formula-box" style="padding: 12px 16px; margin-bottom: 12px;">
<strong>DoU</strong>&nbsp; = &nbsp;
<span class="frac">
<span class="frac-num"># of utilized applications</span>
<span class="frac-den"># of pattern evolution</span>
</span>
</div>

<div class="card small-text">

### Fig. 6 Walkthrough (8 Versions, 5 Instances)
- **▲** = pattern deployed; **▲'** = utilized change; **X** = removed.
- `dp1` (V<sub>1</sub>–V<sub>8</sub>): 2 utilized (V<sub>3</sub>→V<sub>4</sub>, V<sub>4</sub>→V<sub>5</sub>) / 7 transitions = **2/7**.
- `dp2` (V<sub>1</sub>–V<sub>8</sub>): 3 utilized transitions / 7 = **3/7** (highest).
- `dp3` (V<sub>3</sub>–V<sub>8</sub>): 1 utilized / 5 = **1/5**.
- `dp4` (V<sub>3</sub>–V<sub>5</sub>): removed at V<sub>5</sub> → 1 utilized / 2 = **1/2**.
- `dp5` (V<sub>3</sub>–V<sub>8</sub>): never utilized → **0/5**.

</div>

</div>
<div class="right">

<div class="fig-box" style="padding: 10px;">
<img src="./img/fig6_dou_example.png" alt="Utilization analysis of five instances across eight versions" style="max-height: 365px;">
<div class="fig-cap">Fig. 6 · DoU calculation across 5 pattern instances (dp<sub>1</sub>–dp<sub>5</sub>) over V<sub>1</sub>–V<sub>8</sub></div>
</div>

</div>
</div>

<!--
Degree of Utilization Metric & Lifecycle Normalization (Eq. 6, Fig. 6):
- Formal definition (Eq. 6): DoU = (# of utilized applications) / (# of pattern evolution), bounded in [0, 1]. The numerator counts consecutive version transitions where the utilization predicate holds; the denominator equals the number of consecutive versions in which the pattern instance remains alive minus one (accounting for delayed introduction or mid-lifecycle removal).
- Detailed Fig. 6 calculation (8 versions V1–V8, 5 instances):
  - dp1 (alive V1–V8, 7 evolutions): utilized during V3→V4 and V4→V5 → DoU = 2/7.
  - dp2 (alive V1–V8, 7 evolutions): utilized during V3→V4, V4→V5, and V6→V7 → DoU = 3/7.
  - dp3 (introduced at V3, alive V3–V8, 5 evolutions): utilized during V4→V5 → DoU = 1/5.
  - dp4 (introduced at V3, removed at V5, 2 evolutions): utilized during V3→V4 → DoU = 1/2 (normalizing strictly by active lifespan).
  - dp5 (introduced at V3, alive V3–V8, 5 evolutions): never utilized → DoU = 0/5.
- Interpretive caveat noted in the paper: A higher DoU indicates more frequent evolutionary payoff, yet judging whether a low-DoU deployment is genuinely unnecessary still requires active developer review.
-->

---

## 4.1 PUA System Architecture & 4-Step Workflow

We built **Pattern Utilization Analyzer (PUA)**, a web-based tool with three core modules: **Version Control**, **PAC Module**, and **PAE/EPU Module**.

<div class="split46">
<div class="left">

<div class="fig-box" style="padding: 8px;">
<img src="./img/fig7_pua_arch.png" alt="System architecture of Pattern Utilization Analyzer (PUA)" style="max-height: 375px;">
<div class="fig-cap">Fig. 7 · PUA System Architecture</div>
</div>

</div>
<div class="right small-text">

<div class="card" style="margin-bottom: 8px;">

### Step 1 · Collect Multi-Version Source Code
Harvest historical releases from SourceForge and import into PUA's **Version Control Module**.

</div>

<div class="card teal" style="margin-bottom: 8px;">

### Step 2 · Detect 11 GoF Patterns via Pattern4
Run Tsantalis's graph-matching tool [28, 29] per version:
- **Creational**: Factory Method (`FM`), Prototype (`P`)
- **Structural**: Adapter-Command (`AC`), Composite (`C`), Decorator (`D`)
- **Behavioral**: Observer (`O`), State-Strategy (`SS`), Template Method (`TM`), Visitor (`V`)

</div>

<div class="card accent">

### Step 3 & 4 · PAC/EPU Conformance → DoU
Extract `PAC` per version, check consecutive transitions against `EPU`, and output **DoU** per pattern instance and project.

</div>

</div>
</div>

<!--
Pattern Utilization Analyzer (PUA) Architecture & Pattern Grouping (Fig. 7):
- Modular web architecture: PUA consists of three coordinated modules: (1) Version Control Module, which ingests and manages multi-version source-code archives harvested from SourceForge; (2) PAC Module, which parses Pattern4 detection outputs per version and stores role-element contexts; and (3) EPU/PAE Module, which computes inter-version PAC deltas, checks EPU conformance, and aggregates DoU.
- Pattern4 detection scope (9 groups covering 11 GoF patterns): Invoking Tsantalis's graph-similarity detector (Pattern4) per release identifies Creational patterns (Factory Method [FM], Prototype [P]), Structural patterns (Adapter-Command [AC], Composite [C], Decorator [D]), and Behavioral patterns (Observer [O], State-Strategy [SS], Template Method [TM], Visitor [V]).
- Why AC and SS are paired: Adapter/Command and State/Strategy share isomorphic static UML class structures under static graph-similarity matching, so Tsantalis's detector and PUA evaluate each structurally equivalent pair as a unified category.
-->

---

## 4.2 Case Study Walkthrough: Observer Pattern in JHotDraw

Applying PUA to **JHotDraw** across five consecutive versions (`5.2 → 5.3 → 5.4b1 → 5.4b2 → 6.0b1`) tracks **6 Observer instances** (`dp1`–`dp6`):

<div class="split55">
<div class="left">

<div class="fig-box" style="padding: 10px;">
<img src="./img/fig8_jhotdraw_observer.png" alt="Observer pattern analysis for JHotDraw" style="max-height: 320px;">
<div class="fig-cap">Fig. 8 · PUA analysis of 6 Observer instances in JHotDraw (5.2–6.0b1)</div>
</div>

</div>
<div class="right">

<div class="three-col" style="margin-bottom: 10px;">
<div class="kpi-card teal">
<div class="kpi-val">3/4</div>
<div class="kpi-label"><code>dp3</code> (75% utilized)</div>
</div>
<div class="kpi-card">
<div class="kpi-val">1/3–1/4</div>
<div class="kpi-label"><code>dp1</code>, <code>dp4</code>, <code>dp5</code></div>
</div>
<div class="kpi-card accent">
<div class="kpi-val">0/4, 0/3</div>
<div class="kpi-label"><code>dp2</code>, <code>dp6</code> (unused)</div>
</div>
</div>

<div class="card small-text">

### Instance-Level Insights
- **`dp1`–`dp4`** deployed at v5.2 (4 evolution steps): `dp3` actively evolved in 3 of 4 transitions (`DoU = 3/4`), while `dp2` was never utilized (`0/4`).
- **`dp5`–`dp6`** introduced at v5.3 (3 evolution steps): `dp5` utilized once (`1/3`), `dp6` unused (`0/3`).
- Across all 8 JHotDraw evolutions, **Observer reaches the dataset's peak DoU of `0.350`**.

</div>

</div>
</div>

<!--
Instance-Level Evolutionary Walkthrough in JHotDraw (Fig. 8):
- Benchmark significance: JHotDraw (originating from Erich Gamma's 2D structured drawing framework) is a canonical "design exercise" heavily reliant on documented GoF patterns, making it ideal for illustrating PUA's fine-grained instance tracking.
- Five-version trace (5.2 → 5.3 → 5.4b1 → 5.4b2 → 6.0b1): PUA tracks 6 distinct Observer instances (dp1–dp6):
  - Deployed at v5.2 (4 consecutive evolutions): dp1 was utilized once (5.3→5.4b1, DoU = 1/4); dp2 was never utilized (0/4); dp3 was utilized in 3 of 4 transitions (DoU = 3/4 = 75%); dp4 was utilized once (1/4).
  - Deployed at v5.3 (3 consecutive evolutions): dp5 was utilized once (1/3); dp6 was never utilized (0/3).
- Project-wide aggregation: Across all 8 JHotDraw evolutions (v5.2–v7.6), Observer aggregates to DoU = 0.350—the highest single cell across the entire 15-project dataset—yet Fig. 8 demonstrates substantial within-project heterogeneity among individual instances.
-->

---

## 4.3 Experimental Setup: 15 OSS Projects & 296 Evolutions

We evaluated **15 Java open-source systems** from SourceForge spanning diverse domains (GUI editors, testing, ML, semantic web, finance, audio) over **2000–2012** (Table 2):

<div class="two-col">
<div>

| OSS Project | # Evol. | Versions | Time Interval |
| :--- | :---: | :---: | :--- |
| **FreeMind** | 16 | 0.0.2–0.9.0 | Jun 2000 – Feb 2011 |
| **HtmlUnit** | 28 | 1.0.0–2.9.0 | May 2002 – Aug 2011 |
| **Jaxe** | 38 | 1.0–3.5 | Jun 2002 – Jun 2011 |
| **JConvert** | 9 | 1.0.0–1.1.0 | Aug 2007 – May 2011 |
| **JEdit** | 27 | 2.3–4.5.1 | Jan 2000 – Mar 2012 |
| **Jena** | 17 | 2.0–2.6.4 | Aug 2003 – Dec 2010 |
| **JGnash** | 26 | 1.0.1–1.10.5 | Jan 2003 – Mar 2006 |
| **JHotDraw** | 8 | 5.2–7.6 | Feb 2001 – Jan 2011 |

</div>
<div>

| OSS Project | # Evol. | Versions | Time Interval |
| :--- | :---: | :---: | :--- |
| **JMemorize** | 12 | 0.7.0–1.3.0 | Oct 2004 – Mar 2008 |
| **JUnit** | 19 | 3.4.0–4.10.0 | Dec 2000 – Sep 2011 |
| **LatexDraw** | 24 | 1.0.2–2.0.8 | Jan 2006 – Mar 2010 |
| **PDFsam** | 14 | 1.0.0–2.2.1 | Aug 2007 – Jul 2012 |
| **Pixelitor** | 34 | 0.1.0–1.1.2 | Nov 2009 – Nov 2010 |
| **TuxGuitar** | 11 | 0.2–1.2 | Jun 2006 – Nov 2009 |
| **Weka** | 13 | 3.0.1–3.7.5 | Feb 2002 – Aug 2012 |
| **Total** | **296** | **15 Systems** | **Up to 12 Years** |

</div>
</div>

<div class="callout teal" style="margin-top: 8px;">
<strong>Scope:</strong> 3 classic benchmarks (<strong>JHotDraw</strong>, <strong>JUnit</strong>, <strong>FreeMind</strong>) + 12 randomly selected Java OSS projects, evaluated across <strong>9 quality-improver pattern groups (11 GoF patterns)</strong>.
</div>

<!--
Empirical Benchmark Design & Domain Diversity (Table 2):
- Sampling strategy: To balance comparability with prior literature against selection bias, the benchmark combines 3 widely studied software engineering reference systems (JHotDraw, JUnit, FreeMind) with 12 randomly selected Java open-source projects from SourceForge (HtmlUnit, Jaxe, JConvert, JEdit, Jena, JGnash, JMemorize, LatexDraw, PDFsam, Pixelitor, TuxGuitar, Weka).
- Functional domain breadth: The 15 systems span 2D/LaTeX/image graphics (JHotDraw, LatexDraw, Pixelitor), mind mapping (FreeMind), automated unit and headless web testing (JUnit, HtmlUnit), XML and programmer text editors (Jaxe, JEdit), semantic web/RDF/OWL toolkits (Jena), machine learning (Weka), personal finance (JGnash), flashcard learning (JMemorize), PDF utilities (PDFsam), unit conversion (JConvert), and multitrack guitar tablature (TuxGuitar).
- Temporal & evolutionary scale: Release histories span up to 12 years (2000–2012), ranging from 8 evolutions (JHotDraw 5.2–7.6) to 38 evolutions (Jaxe 1.0–3.5), totaling 296 version transitions.
-->

---

## 4.4 Experimental Results: DoU Matrix Across 15 OSS Projects (Table 3)

<div class="split64" style="grid-template-columns: 67% 31%; align-items: start;">
<div class="left">

<table class="dense">
<thead>
<tr><th>Project</th><th>FM</th><th>P</th><th>AC</th><th>C</th><th>D</th><th>O</th><th>SS</th><th>TM</th><th>V</th></tr>
</thead>
<tbody>
<tr><td>FreeMind</td><td class="mid-cell">0.161</td><td></td><td class="mid-cell">0.165</td><td></td><td class="hi-cell">0.333</td><td class="hi-cell">0.333</td><td class="hi-cell">0.301</td><td class="hi-cell">0.263</td><td></td></tr>
<tr><td>HtmlUnit</td><td>0.082</td><td class="zero-cell">0</td><td>0.042</td><td></td><td class="mid-cell">0.196</td><td>0.032</td><td>0.129</td><td>0.101</td><td></td></tr>
<tr><td>Jaxe</td><td class="zero-cell">0</td><td></td><td>0.007</td><td></td><td class="zero-cell">0</td><td class="zero-cell">0</td><td>0.014</td><td class="zero-cell">0</td><td></td></tr>
<tr><td>JConvert</td><td></td><td></td><td class="zero-cell">0</td><td></td><td></td><td class="zero-cell">0</td><td class="mid-cell">0.158</td><td>0.125</td><td></td></tr>
<tr><td>JEdit</td><td></td><td></td><td>0.091</td><td></td><td></td><td></td><td class="zero-cell">0</td><td></td><td></td></tr>
<tr><td>Jena</td><td>0.056</td><td>0.060</td><td>0.014</td><td>0.056</td><td>0.076</td><td>0.071</td><td>0.093</td><td>0.047</td><td class="zero-cell">0</td></tr>
<tr><td>JGnash</td><td>0.012</td><td>0.001</td><td>0.023</td><td class="zero-cell">0</td><td>0.023</td><td>0.017</td><td>0.041</td><td>0.017</td><td></td></tr>
<tr><td>JHotDraw</td><td>0.143</td><td>0.004</td><td>0.044</td><td>0.063</td><td class="mid-cell">0.162</td><td class="hi-cell">0.350</td><td class="mid-cell">0.176</td><td>0.104</td><td class="zero-cell">0</td></tr>
<tr><td>JMemorize</td><td>0.010</td><td class="zero-cell">0</td><td>0.020</td><td class="zero-cell">0</td><td>0.010</td><td>0.040</td><td>0.030</td><td>0.030</td><td></td></tr>
<tr><td>JUnit</td><td class="zero-cell">0</td><td></td><td>0.016</td><td>0.045</td><td class="zero-cell">0</td><td class="zero-cell">0</td><td>0.120</td><td>0.026</td><td></td></tr>
<tr><td>LatexDraw</td><td class="zero-cell">0</td><td>0.005</td><td>0.058</td><td class="hi-cell">0.261</td><td></td><td class="mid-cell">0.174</td><td>0.073</td><td>0.075</td><td></td></tr>
<tr><td>PDFsam</td><td></td><td></td><td class="zero-cell">0</td><td></td><td></td><td></td><td>0.029</td><td class="zero-cell">0</td><td></td></tr>
<tr><td>Pixelitor</td><td>0.011</td><td class="zero-cell">0</td><td>0.007</td><td></td><td></td><td>0.020</td><td>0.016</td><td>0.029</td><td></td></tr>
<tr><td>TuxGuitar</td><td class="mid-cell">0.200</td><td>0.009</td><td>0.062</td><td class="zero-cell">0</td><td></td><td>0.125</td><td>0.051</td><td>0.032</td><td></td></tr>
<tr><td>Weka</td><td>0.068</td><td class="zero-cell">0</td><td>0.052</td><td></td><td>0.145</td><td class="zero-cell">0</td><td class="hi-cell">0.315</td><td>0.013</td><td></td></tr>
</tbody>
</table>
<div class="fig-cap" style="text-align:left;">Blank = not deployed · <code>0</code> = deployed but never utilized · Teal ≥ 0.25, Blue ≥ 0.15</div>

</div>
<div class="right">

<div class="kpi-card teal" style="margin-bottom: 9px;">
<div class="kpi-val">0.350</div>
<div class="kpi-label"><strong>Highest DoU:</strong> Observer in JHotDraw</div>
</div>

<div class="kpi-card accent" style="margin-bottom: 9px;">
<div class="kpi-val">&lt; 0.20</div>
<div class="kpi-label"><strong>Overall Reality:</strong> Mean DoU universally low across patterns</div>
</div>

<div class="card small-text">

### Key Patterns
- **FreeMind**: Strongest overall (`D/O/SS > 0.30`).
- **Weka**: State-Strategy excels (`0.315`, ML algorithms).
- **LatexDraw**: Composite leads (`0.261`, shapes).
- **Jaxe, JEdit, PDFsam, Pixelitor**: Very low or `0` DoU.

</div>

</div>
</div>

<!--
Cross-Project DoU Matrix & Domain-Specific Highlights (Table 3):
- Matrix encoding & sample size: Table 3 contains 96 deployed project-pattern cells (yielding total df = 95 in ANOVA). Blank cells denote patterns never deployed in that project; 0 indicates a deployed pattern that was never utilized across any evolution.
- Universally low baseline: Across all 9 pattern groups, mean DoU remains below 0.20, indicating that most deployed patterns do not frequently exercise their intended evolutionary extension points. Visitor (V) was deployed only in Jena and JHotDraw and recorded DoU = 0 in both; Prototype (P) never exceeded 0.060 (Jena).
- High-utilization domain alignments:
  - FreeMind achieved the strongest broad utilization (Decorator = 0.333, Observer = 0.333, State-Strategy = 0.301, Template Method = 0.263, Adapter-Command = 0.165, Factory Method = 0.161).
  - JHotDraw reached the global maximum with Observer (0.350), alongside State-Strategy (0.176) and Decorator (0.162).
  - Weka exhibited high State-Strategy utilization (0.315), matching frequent additions of interchangeable ML algorithms; LatexDraw led in Composite (0.261) for hierarchical graphical shapes; TuxGuitar led in Factory Method (0.200); HtmlUnit peaked in Decorator (0.196).
  - By contrast, Jaxe, JEdit, PDFsam, Pixelitor, JUnit, JMemorize, and JGnash showed sparse or near-zero utilization.
-->

---

## 5.1 RQ1 Analysis: DoU vs. Design Pattern Type

<div class="split55">
<div class="left">

<div class="fig-box" style="padding: 8px;">
<img src="./img/fig9_boxplot_patterns.png" alt="Box plots of DoU for different design patterns" style="max-height: 365px;">
<div class="fig-cap">Fig. 9 · Box plots of DoU across 9 pattern groups</div>
</div>

</div>
<div class="right">

<div class="kpi-card teal" style="margin-bottom: 8px;">
<div class="kpi-val">p = 0.146 &gt; 0.05</div>
<div class="kpi-label"><strong>Fail to Reject H<sub>0</sub>:</strong> No significant DoU difference across pattern types</div>
</div>

| Source (Table 4) | SS | df | MS (SS/df) | F | p-value |
| :--- | :---: | :---: | :---: | :---: | :---: |
| **Between Patterns** | 0.090 | 8 | 0.011 | 1.569 | **0.146** |
| **Within Patterns** | 0.626 | 87 | 0.007 | — | — |
| **Total** | 0.716 | 95 | — | — | — |

<div class="card small-text" style="margin-top: 8px;">

### Why No Pattern Type Dominates?
- Mean DoU is **universally &lt; 0.20** (`Visitor = 0`, `Prototype ≤ 0.060`).
- Pattern usage is heavily shaped by **human habits & program comprehension** [21].
- Developers pick **familiar patterns** or avoid structurally complex ones [30], regardless of true evolution need.

</div>

</div>
</div>

<!--
One-Way ANOVA for RQ1 — Pattern Type Effect (Table 4, Fig. 9):
- Hypothesis test specification (α = 0.05): H0: μ1 = μ2 = ... = μ9 (equal mean DoU across all 9 pattern groups) vs. H1 (unequal means).
- ANOVA statistics (Table 4): Between-patterns SS = 0.090 (df = 8, MS = 0.011), Within-patterns SS = 0.626 (df = 87, MS = 0.007), Total SS = 0.716 (df = 95), yielding F = 1.569 and p = 0.146 (> 0.05). Thus, H0 cannot be rejected: deployed pattern utilization does not statistically depend on pattern type.
- Behavioral & cognitive interpretation: Because mean DoU is universally < 0.20 across every group (Fig. 9), no GoF pattern inherently guarantees high evolutionary payoff. Drawing on Ng et al. (2012) and Vokáč (2004), the paper attributes this to two developer-side factors: (1) pattern deployment is heavily mediated by human habits and program comprehension; and (2) developers gravitate toward familiar patterns while avoiding structurally complex ones (such as Visitor), disconnecting pattern choice from actual future change trajectories.
-->

---

## 5.2 RQ2 Analysis: DoU vs. Open Source Project

<div class="split55">
<div class="left">

<div class="fig-box" style="padding: 8px;">
<img src="./img/fig10_boxplot_projects.png" alt="Box plots of DoU for 15 open source projects" style="max-height: 365px;">
<div class="fig-cap">Fig. 10 · Box plots of DoU across 15 OSS projects</div>
</div>

</div>
<div class="right">

<div class="kpi-card accent" style="margin-bottom: 8px;">
<div class="kpi-val">F = 5.704 · p &lt; 0.001</div>
<div class="kpi-label"><strong>Reject H<sub>0</sub>:</strong> DoU differs significantly across OSS projects!</div>
</div>

| Source (Table 5) | SS | df | MS (SS/df) | F | p-value |
| :--- | :---: | :---: | :---: | :---: | :---: |
| **Between Projects** | 0.356 | 14 | 0.025 | **5.704** | **&lt; 0.001** |
| **Within Projects** | 0.361 | 81 | 0.004 | — | — |
| **Total** | 0.716 | 95 | — | — | — |

<div class="card accent small-text" style="margin-top: 8px;">

### Scheffé Post-Hoc Test (Table 6)
- **FreeMind** significantly outperforms **8 OSS projects**: `Jaxe` (p=0.001), `Jena` (0.006), `jGnash` (&lt;0.001), `jMemorize` (&lt;0.001), `JUnit` (0.002), `PDFsam` (0.028), `Pixelitor` (0.001), `TuxGuitar` (0.040).
- **Domain Synergy**: In MVC GUI apps (**JHotDraw** `0.350`, **FreeMind** `0.333`), **Observer & Decorator** actively drive view-update evolution.

</div>

</div>
</div>

<!--
One-Way ANOVA & Scheffé Post-Hoc Contrasts for RQ2 (Tables 5–6, Fig. 10):
- Hypothesis test specification (α = 0.05): H0: μ1 = μ2 = ... = μ15 (equal mean DoU across all 15 OSS projects) vs. H1 (unequal project means).
- ANOVA statistics (Table 5): Between-projects SS = 0.356 (df = 14, MS = 0.025), Within-projects SS = 0.361 (df = 81, MS = 0.004), Total SS = 0.716 (df = 95), yielding F = 5.704 and p < 0.001. Thus, H0 is strongly rejected: project context accounts for nearly half of total variance (η² = 0.356 / 0.716 ≈ 49.7%).
- Scheffé post-hoc pairwise contrasts (Table 6): Applying Scheffé's conservative method for unequal group sizes reveals that FreeMind significantly outperforms 8 projects at α = 0.05: Jaxe (Δ = 0.256, p = 0.001), Jena (Δ = 0.207, p = 0.006), jGnash (Δ = 0.243, p < 0.001), jMemorize (Δ = 0.242, p < 0.001), JUnit (Δ = 0.230, p = 0.002), PDFsam (Δ = 0.250, p = 0.028), Pixelitor (Δ = 0.246, p = 0.001), and TuxGuitar (Δ = 0.191, p = 0.040).
- Architectural explanation: In MVC-driven interactive GUI applications like JHotDraw (Observer = 0.350) and FreeMind (Observer & Decorator = 0.333), notification-listening and visual decoration mechanisms align directly with continuous figure-visualization evolution (Aversano et al., 2007), demonstrating disciplined pattern selection and ongoing maintenance conformance.
-->

---

## 5.3 Threats to Validity

Following Yin's case-study validation template [25], we address four validity dimensions:

<div class="two-col">
<div class="card small-text">

### 🎯 Construct Validity
- Results depend on the precision & recall of **Tsantalis et al.'s pattern detector** [28].
- **Mitigation:** Achieves **100% precision & 100% recall** on well-documented JHotDraw [28], and **&gt; 85% overall precision** in independent audits by Aversano et al. [1], limiting false-positive distortion.

</div>
<div class="card accent small-text">

### 🔍 Internal Validity
- External confounding factors could influence the observed DoU relationships.
- **Mitigation:** Rigorous **One-Way ANOVA** (α = 0.05) + **Scheffé post-hoc contrasts** cleanly separate the non-significant pattern-type factor (p = 0.146) from the highly significant project factor (p &lt; 0.001).

</div>
<div class="card teal small-text">

### 🌐 External Validity
- **Project Scope:** 15 OSS Java systems across diverse domains & sizes; expanding to larger industrial repositories will further strengthen generalizability.
- **Pattern Scope:** Evaluates 9 groups (11 patterns) out of 23 GoF patterns, specifically targeting **quality-improver** patterns [14].

</div>
<div class="card small-text">

### 🔁 Reliability Validity
- All 15 OSS codebases (SourceForge) and Tsantalis's `Pattern4` detection tool are **publicly available**.
- Step-by-step PUA workflow (Section 4.2) and raw DoU tables (Table 3) are published for full statistical replication.

</div>
</div>

<!--
Structured Validity Assessment Following Yin's Framework (Section 5.4):
- Construct validity (detection accuracy): DoU depends directly on the precision and recall of Tsantalis et al.'s static graph-similarity detector (Pattern4). This threat is mitigated by documented 100% precision and 100% recall on JHotDraw (Tsantalis et al., 2006) and > 85% overall precision in independent validation across external systems (Aversano et al., 2009), constraining false-positive distortion.
- Internal validity (confounding factors): To verify whether observed DoU variation stems from pattern type or project context, One-Way ANOVA (α = 0.05) and Scheffé post-hoc tests were applied systematically, cleanly separating the non-significant pattern factor (p = 0.146) from the highly significant project factor (p < 0.001).
- External validity (generalizability): Although the 15 SourceForge Java projects span diverse domains and sizes, generalizing to proprietary industrial repositories or non-Java ecosystems requires broader sampling. Similarly, pattern scope is intentionally restricted to 9 groups (11 patterns) out of 23 GoF patterns because only Quality-Improver patterns carry explicit evolutionary NFR-intent (Hsueh et al., 2009).
- Reliability validity (reproducibility): All 15 OSS source repositories (SourceForge) and Tsantalis's Pattern4 tool are publicly accessible; Section 4.2 specifies the exact 4-step PUA protocol and Table 3 publishes the complete raw DoU matrix for independent statistical replication.
-->

---

## 6. Conclusion & Future Work

<div class="fig-box" style="padding: 8px 10px; margin-bottom: 8px;">
<img src="./img/diag3_rq_conclusions.svg" alt="Visual Synthesis of RQ1, RQ2 and Practical Value" style="max-height: 355px;">
</div>

<div class="future-strip">
<div class="future-pill"><strong>☁️ 1. Cloud-Service PUA</strong><br>Re-architect PUA as a scalable cloud service to accelerate multi-version graph detection & analysis.</div>
<div class="future-pill"><strong>🧩 2. Expanded Pattern Catalog</strong><br>Extend detection & EPU definitions beyond 11 GoF patterns to cover more architectural & design patterns.</div>
<div class="future-pill"><strong>📊 3. Larger OSS Benchmark</strong><br>Validate evolutionary DoU trends across larger modern repositories & industrial codebases.</div>
</div>

<!--
Empirical Synthesis, Maintenance Applications & Future Roadmap:
- Core empirical conclusion: Across 296 software evolutions in 15 Java OSS projects, deployed GoF design patterns exhibit universally low mean utilization (< 0.20), with many instances never reused after initial deployment. Utilization does not differ significantly by pattern type (p = 0.146) but differs highly significantly by software project (p < 0.001), confirming that domain fit and architectural discipline govern evolutionary payoff.
- Three actionable engineering applications highlighted in Section 6:
  1. Developers: Monitor the live utilization status of deployed pattern instances across project releases.
  2. Maintenance analysts: Use low-DoU diagnostics to prioritize targeted refactoring—either consolidating toward utilized patterns or removing dead, unexercised pattern abstractions.
  3. Project managers: Identify mismatches in requirement and feature planning whenever anticipated extension points fail to materialize during evolution.
- Technical roadmap: Re-architect PUA as a cloud service to accelerate computationally intensive multi-version graph matching, expand detection and EPU specifications beyond 11 GoF patterns, and scale empirical benchmarking to larger modern OSS and industrial codebases.
-->

---

<!-- _class: closing -->

# Thank You for Your Attention!

<p style="font-size: 1.05em; max-width: 840px;">
Design Pattern Analysis with Software Evolution Data
</p>

<div class="contact-card">
<strong>Nien-Lin Hsueh</strong> &nbsp;·&nbsp; <code>nlhsueh@fcu.edu.tw</code><br>
Department of Information Engineering and Computer Science, Feng Chia University<br>
<em>Journal of Information Science and Engineering</em>, Vol. 36, No. 1, pp. 53–73 (2020)<br>
DOI: <code>10.6688/JISE.202001_36(1).0004</code><br>
<span style="font-size: 0.85em; opacity: 0.85;">Grant: MOST 106-2221-E-035-MY2 · Questions & Discussion Welcome!</span>
</div>

<!--
Archival Citation & Research Provenance:
- Full citation: N.-L. Hsueh, "Design Pattern Analysis with Software Evolution Data," Journal of Information Science and Engineering (JISE), vol. 36, no. 1, pp. 53–73, Jan. 2020, doi: 10.6688/JISE.202001_36(1).0004.
- Institutional affiliation & funding: Department of Information Engineering and Computer Science, Feng Chia University, Taichung 407, Taiwan; supported by the Ministry of Science and Technology (MOST), Taiwan, under Grant MOST 106-2221-E-035-MY2.
- Reproducibility & lineage: Extends prior work on goal-driven pattern classification (SoSyM 2009) and preliminary single-project evolution analysis on Jaxe (COMPSAC 2011) into a full 15-project statistical benchmark using publicly available SourceForge archives and Tsantalis's Pattern4 detector.
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
