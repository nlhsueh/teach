---
marp: true
theme: gaia
size: 16:9
paginate: true
html: true
header: '<div class="hdr-wrap"><span class="hdr-title">Enhancing Requirements Engineering Efficiency through PLANT</span><div class="hdr-actions"><a class="lang-btn" href="./Plant_slide_zh.html" title="切換至繁體中文簡報">🌐 繁</a><div class="nav-dropdown"><button class="nav-btn">Sections ▾</button><div class="nav-menu"><a href="#2">Opening Hook: 1 vs. 6 Agents</a><a href="#3">Outline</a><a href="#4">1. Introduction & RQs</a><a href="#6">2. Related Work</a><a href="#7">3. PLANT Approach</a><a href="#12">4. Experimental Evaluation</a><a href="#19">5. Conclusion & Future Work</a></div></div></div></div>'
footer: 'Nien-Lin Hsueh & Shu-Hsien Liao · Feng Chia University · PLANT Multi-Agent RE Framework'
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
  min-width: 225px;
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
  letter-spacing: 0.06em;
  text-transform: uppercase;
  padding: 5px 14px;
  border-radius: 999px;
  margin-bottom: 18px;
}

section.lead h1 {
  color: #ffffff;
  font-size: 2.0em;
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

section.lead .meta-box strong { color: #ffffff; }
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
.two-col { display: grid; grid-template-columns: 1fr 1fr; gap: 20px; align-items: stretch; }
.three-col { display: grid; grid-template-columns: repeat(3, 1fr); gap: 15px; align-items: stretch; }
.split64 { display: grid; grid-template-columns: 56% 42%; gap: 2%; align-items: center; }
.split55 { display: grid; grid-template-columns: 49% 49%; gap: 2%; align-items: center; }

/* Cards & Callouts */
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
.kpi-label { font-size: 0.76em; color: var(--slate-700); line-height: 1.32; }

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

/* Tables */
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
  line-height: 1.32;
}

tr:nth-child(even) td { background: #f8fafc; }

/* Formula Box */
.formula-strip {
  display: grid;
  grid-template-columns: 1fr 1.35fr;
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

.small-text { font-size: 0.82em; }

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

.rq-hook { font-size: 0.92em; font-weight: 800; color: var(--navy); line-height: 1.28; margin-bottom: 4px; }
.rq-card.teal .rq-hook { color: var(--teal); }
.rq-card.accent .rq-hook { color: var(--accent); }
.rq-q { font-size: 0.8em; color: var(--slate-700); line-height: 1.4; }

/* Mini Bar Rows */
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

<div class="badge">Academic Conference Presentation · Multi-Agent Requirements Engineering</div>

# Enhancing Requirements Engineering Efficiency through a Multi-Agent AI Framework

<div class="subtitle">
<strong>PLANT</strong> (Platform for muLtiple Agent-based requiremeNt developmenT): Coordinating Specialized AI Roles, Knowledge Grounding, and Task-Adaptive Mediation
</div>

<div class="meta-box">
<strong>Nien-Lin Hsueh<sup>+</sup></strong> and <strong>Shu-Hsien Liao</strong><br>
Department of Information Engineering and Computer Science, Feng Chia University, Taichung, Taiwan<br>
<code>nlhsueh@fcu.edu.tw</code> · <code>m1325977@o365.fcu.edu.tw</code>
</div>

<div class="grant">
Supported by the National Science and Technology Council (NSTC), Taiwan R.O.C., under grant NSTC114-2221-E-035-077.
</div>

<!--
Paper Context & Core Contribution:
- Published in the Journal of Information Science and Engineering (JISE, 2026) by Nien-Lin Hsueh and Shu-Hsien Liao (Department of Information Engineering and Computer Science, Feng Chia University; NSTC grant NSTC114-2221-E-035-077).
- Full framework name: PLANT (Platform for muLtiple Agent-based requiremeNt developmenT), an end-to-end multi-agent Requirements Engineering (RE) platform coordinating six specialized LLM roles—User, Analyst, Expert, Modeler, Mediator, and Documenter.
- Core methodological contributions: (1) Simultaneous Stakeholder Prompting (SSP) for unbiased multi-persona elicitation; (2) external regulatory/standards grounding and PlantUML structural validation; (3) Hybrid-Communication-with-Mediator for task-adaptive switching between Simultaneous-Talk and One-by-One dialogue; and (4) Human-in-the-Loop (HITL) deadlock adjudication feeding into an IEEE 29148-compliant SRS with traceable Design Rationales (DR).
- Empirical scope: Evaluated across 5 software systems (103 ground-truth implicit requirements) and 100 requirement conflict pairs on GPT-4.1 and Gemini 3 Flash, alongside an explicit quality-cost trade-off analysis.
-->

---

## Opening Hook: "Done in 6 Turns!" ... Or Did We Miss Half the System?

<div class="fig-box" style="padding: 6px; margin-bottom: 10px; background: #fbf9f2;">
<img src="./img/plant_hook.jpg" alt="Single-Agent LLM vs PLANT Multi-Agent Requirements Team" style="max-height: 415px; border-radius: 6px;">
</div>

<div class="callout" style="margin-top: 6px; padding: 9px 16px;">
<strong>The Big Idea:</strong> A single LLM acts like an eager "yes-man" that stops at surface features. <strong>PLANT</strong> replaces the solo interviewer with a <strong>specialized multi-agent requirements team</strong> that uncovers hidden NFRs, catches conflicts, and logs traceable rationales.
</div>

<!--
Behavioral Contrast: Single-Agent Premature Convergence vs. Multi-Agent Depth:
- In empirical elicitation trials (Table 6), single-agent LLM interviewers terminated early after an average of only 6.20 turns (GPT-4.1) or 6.00 turns (Gemini 3 Flash), despite being permitted up to 20 turns.
- Root causes identified in the paper: Single-agent LLMs suffer from sycophancy bias and premature convergence (Du et al. [3]), prematurely assuming requirements are complete once surface-level functional features (Interaction and Content) are covered—leaving Security, Safety, Reliability, and Performance largely unexamined.
- Multi-agent resolution: By distributing elicitation, regulatory auditing, and behavioral modeling across specialized agents coordinated by a Mediator, PLANT sustains 13.00 to 17.00 productive turns, systematically uncovering implicit Non-Functional Requirements (NFRs), surfacing latent conflicts, and recording traceable Meeting Minutes (MoM).
-->

---

## Presentation Outline

<div class="outline-grid">

<div class="outline-item">
<div class="outline-num">1</div>
<div class="outline-body">

[**Introduction & Research Questions**](#4)
Why single-agent LLMs fail in Requirements Engineering and our three RQs (RQ1–RQ3).

</div>
</div>

<div class="outline-item">
<div class="outline-num">2</div>
<div class="outline-body">

[**Related Work & Research Gap**](#6)
Comparison of LLM & multi-agent RE frameworks (Table 1).

</div>
</div>

<div class="outline-item">
<div class="outline-num">3</div>
<div class="outline-body">

[**PLANT Framework & Mediation**](#7)
Six agent roles, 4-stage workflow, SSP, knowledge grounding, and hybrid communication.

</div>
</div>

<div class="outline-item">
<div class="outline-num">4</div>
<div class="outline-body">

[**Experimental Setup & RQ1–RQ3 Results**](#12)
103 implicit requirements (5 systems), 100 conflict pairs, and cost-effectiveness analysis.

</div>
</div>

<div class="outline-item">
<div class="outline-num">5</div>
<div class="outline-body">

[**Discussion & Threats to Validity**](#17)
Expected component contributions and internal / construct / external validity.

</div>
</div>

<div class="outline-item">
<div class="outline-num">6</div>
<div class="outline-body">

[**Conclusion & Future Work**](#19)
Visual synthesis of RQ1–RQ3 conclusions and roadmap for specification-driven development.

</div>
</div>

</div>

<!--
Paper Structural Roadmap:
- Section 1 (Introduction) frames the critical role of rigorous IEEE 29148 specifications in the AI-Augmented Software Development (AASD) era and defines RQ1 through RQ3.
- Section 2 (Related Work) reviews LLM applications across elicitation, analysis, and specification, comparing PLANT against representative single- and multi-agent frameworks (Table 1).
- Section 3 (Approach) details PLANT's six agent roles (Table 2), four-stage iterative workflow (Fig. 2), Simultaneous Stakeholder Prompting (SSP, Fig. 3), external knowledge grounding, and Mediator-guided hybrid communication (Fig. 4).
- Section 4 (Experimental Evaluation) specifies datasets (Table 3), prompt schemas (Table 4), automated evaluation protocols, quantitative results for RQ1 to RQ3 (Tables 5 to 10), expected component contributions, and threats to validity.
- Section 5 (Conclusion) synthesizes core findings and outlines future work toward fixed-budget ablations, human SRS evaluation, and Specification-Driven Development (SDD).
-->

---

## 1.1 Motivation: Why Single-Agent LLMs Fall Short in RE

<div class="fig-box" style="padding: 10px 12px; margin-bottom: 10px;">
<img src="./img/diag1_single_vs_multi.svg" alt="Single-Agent LLM vs PLANT Multi-Agent Team" style="max-height: 365px;">
</div>

<div class="callout">
<strong>Why RE Matters in the AASD Era:</strong> Even as AI accelerates coding, rapid iteration produces fragmented architectures without a rigorous <strong>IEEE 29148 SRS</strong> — especially for non-functional requirements (NFRs) like security, privacy, and reliability.
</div>

<!--
Theoretical Motivation in the AASD Era:
- AI-Augmented Software Development (AASD, Ozkaya [1]) shifts software engineers from manual coders to supervisors and decision makers. However, accelerated AI code generation without a rigorous IEEE 29148 Software Requirements Specification (SRS) amplifies architectural fragmentation and downstream maintenance costs as systems scale.
- Organizational bottleneck: Traditional RE depends on experienced system analysts conducting multi-round stakeholder meetings to reconcile competing priorities—especially NFRs (security, privacy, performance, reliability, scalability), which are both primary conflict sources and the most frequently overlooked early requirements. Junior-analyst shortages often curtail these iterations.
- Why LLMs help, yet single agents fail: LLMs encode broad standards knowledge and excel at detail-intensive artifact consolidation, but single-agent virtual interviewers (e.g., Korn et al. [2]) conflate stakeholder elicitation, domain compliance, and modeling within one context window, triggering sycophancy bias and early exit (Du et al. [3]).
-->

---

## 1.2 Research Objectives & Three Research Questions

We empirically quantify **PLANT** on two foundational upstream RE tasks and its computational resource trade-off *(revealed step-by-step)*:

<div class="rq-stage">

* <div class="rq-card teal"><img src="./img/rq1_ir.svg" alt="RQ1 Implicit Requirements"><div><div class="rq-hook"><span class="rq-tag" style="background:#0f766e;">RQ1</span> Can specialized agents uncover what stakeholders forget to say?</div><div class="rq-q"><strong>How effectively does PLANT discover implicit requirements</strong> — especially overlooked NFRs — across diverse software systems?</div></div></div>
* <div class="rq-card accent"><img src="./img/rq2_conflict.svg" alt="RQ2 Conflict Identification"><div><div class="rq-hook"><span class="rq-tag">RQ2</span> Can structured deliberation catch hidden requirement clashes?</div><div class="rq-q"><strong>How effectively does PLANT identify requirement conflicts</strong> compared with a single-agent classifier?</div></div></div>
* <div class="rq-card"><img src="./img/rq3_cost.svg" alt="RQ3 Cost-Effectiveness"><div><div class="rq-hook"><span class="rq-tag" style="background:#1b365d;">RQ3</span> When is multi-agent deliberation worth the extra tokens & time?</div><div class="rq-q"><strong>How cost-effective is PLANT</strong> in terms of token consumption, runtime, API cost, and marginal IRE gain per 1M tokens?</div></div></div>

</div>

<!--
Scope of Empirical Evaluation (RQ1 to RQ3):
- Although PLANT's complete workflow generates UML diagrams, Meeting Minutes (MoM), Design Rationales, and IEEE 29148 SRS drafts (available in the public repository), the paper's controlled quantitative evaluation focuses rigorously on two foundational upstream RE bottlenecks plus resource economics:
  - RQ1 (Implicit Requirement Elicitation): Evaluates recall of unstated functional and non-functional requirements (IRE) and early-turn questioning efficiency (TKQR) across 5 diverse domains (103 ground-truth IRs).
  - RQ2 (Requirement Conflict Identification): Evaluates pairwise classification (Macro F1 and Conflict-class Precision, Recall, F1) across 100 balanced requirement pairs from Hospital Management (70) and Food Delivery (30).
  - RQ3 (Cost-Effectiveness): Quantifies token consumption, wall-clock runtime, API cost (US$), marginal IRE gain per additional 1M tokens, and unit cost per elicited IR across GPT-4.1 and Gemini 3 Flash to delineate practical deployment boundaries.
-->

---

## 2. Related Work & Architectural Comparison (Table 1)

Existing LLM-based RE frameworks rarely integrate **task-adaptive negotiation** and **traceable design rationales** end-to-end.

| Approach | Core Description | Elicit. | Analysis | Spec. | Multi-Agent | Negot. | Trace. |
| :--- | :--- | :---: | :---: | :---: | :---: | :---: | :---: |
| LLMREI [2] / RECOVER [7] | Virtual interviews to elicit & structure requirements | ✓ | × | × | × | × | × |
| Elicitron [8] | Simulates usage scenarios & agent-based interviews | ✓ | ✓ | × | ✓ | × | × |
| MAD [9] | Multi-agent debate for requirement classification | × | ✓ | × | ✓ | ✓ | × |
| ReqInOne [10] | Single-agent workflow to analyze & generate SRS | × | ✓ | ✓ | × | × | × |
| MARE [11] / iReDev [12] | Multi-agent role division & shared workspace / KG | ✓ | ✓ | ✓ | ✓ | × | × |
| **Our Approach (PLANT)** | **End-to-end roles, mediator-guided negotiation & traceable DR** | **✓** | **✓** | **✓** | **✓** | **✓** | **✓** |

<div class="callout">
<strong>Key Research Gap:</strong> Even recent multi-agent systems (MARE, iReDev) rely on sequential handoffs without a dedicated <strong>Mediator</strong> that dynamically switches communication modes, escalates deadlocks to humans, or logs structured design rationales.
</div>

<!--
Comparative Positioning in RE Literature (Table 1):
- Single-stage / single-agent tools: LLMREI [2] (33 simulated interviews, >73% valid requirement extraction via zero-shot/CoT) and RECOVER [7] focus strictly on elicitation; ReqInOne [10] targets single-agent analysis and SRS drafting; formal-logic contradiction detectors (Gärtner & Göhlich [14]) and use-case extractors (Eisenreich et al. [15]) address isolated analysis tasks.
- Early multi-agent RE systems: Elicitron [8] simulates user personas for elicitation/analysis without negotiation or SRS specification; MAD [9] applies multi-agent debate solely to requirement classification.
- End-to-end multi-agent peers: MARE [11] assigns elicitation, modeling, validation, and specification roles communicating via a shared workspace; iReDev [12] augments multi-agent refinement with custom domain knowledge graphs.
- Distinct gap addressed by PLANT: Neither MARE nor iReDev includes a dedicated Mediator that dynamically switches communication topologies per discussion goal, escalates deadlocked trade-offs to Human-in-the-Loop (HITL) review (emphasized by Arora et al. [6]), or structures multi-round negotiation logs into explicit Design Rationales linked to SRS clauses.
-->

---

## 3.1 PLANT Framework Overview & Six Specialized Roles

<div class="split64">
<div class="left">

<div class="fig-box">
<img src="./img/fig1_overview.png" alt="Fig. 1: Overview of the PLANT framework" style="max-height: 400px;">
<div class="fig-cap">Fig. 1: Overview of the PLANT framework</div>
</div>

</div>
<div class="right small-text">

### 🤖 Six Specialized Agents (Table 2)
- **User**: Simulates first-person stakeholder personas (usage scenarios, pain points).
- **Analyst**: Structures requirements, defines scope boundaries, flags conflicts.
- **Expert**: Audits against external domain regulations, privacy laws & ISO 25010.
- **Modeler**: Builds & validates PlantUML models (use-case, class, sequence).
- **Mediator**: Plans agenda, switches communication modes, escalates deadlocks.
- **Documenter**: Compiles IEEE 29148 SRS & traceable Design Rationale (DR).

</div>
</div>

<!--
Six Specialized Agent Profiles & Responsibilities (Fig. 1, Table 2 & Table 4):
- User (Multiple Stakeholders): Configured via SSP to adopt confirmed stakeholder personas concurrently, outputting structured JSON of first-person usage scenarios, operational pain points, expected features, and concerns.
- Analyst (Experienced System Analyst): Extracts atomic requirements from stakeholder remarks, partitions In-Scope vs. Out-of-Scope boundaries, identifies pairwise conflicts with rationales, and maintains the evolving requirements draft.
- Expert (Experienced Domain Expert): Queries PLANT's external Document Library and search tools to audit drafts against domain regulations, personal-data protection laws, payment guidelines, and ISO/IEC 25010 quality attributes, citing specific supporting clauses.
- Modeler (Experienced Requirement Modeler): Translates requirements into PlantUML use-case, class, and sequence diagrams, invoking a syntax and consistency validation tool to expose missing actors, states, or exception timeouts.
- Mediator (Experienced Requirement Mediator): Formulates bounded round agendas, selects Simultaneous-Talk vs. One-by-One strategies, evaluates consensus, writes MoM, and triggers HITL escalation on deadlocks.
- Documenter (Experienced Requirement Documenter): Compiles the converged draft into an IEEE 29148 SRS with acceptance criteria and synthesizes multi-round MoM logs into a traceable Design Rationale document.
-->

---

## 3.2 Four-Stage Iterative Collaboration Process

<div class="split55">
<div class="left">

<div class="fig-box">
<img src="./img/fig2_process.png" alt="Fig. 2: Requirements development process in PLANT" style="max-height: 390px;">
<div class="fig-cap">Fig. 2: Four-stage iterative workflow in PLANT</div>
</div>

</div>
<div class="right small-text">

### 🔄 Beyond Single-Pass Generation
1. **Stage 1 · Elicitation (SSP)**: From a rough idea, `User` simulates multiple stakeholders concurrently to capture diverse expectations.
2. **Stage 2 · Multi-Perspective Analysis**: `Analyst` scopes & detects conflicts; `Expert` audits regulations; `Modeler` validates PlantUML flows in parallel.
3. **Stage 3 · Mediated Negotiation**: Up to `r` bounded rounds; `Mediator` resolves conflicts, logs `MoM`, and updates drafts/models.
4. **Stage 4 · Specification & Rationale**: `Documenter` compiles an **IEEE 29148 SRS** linked directly to multi-round `MoM` rationales.

</div>
</div>

<!--
Four-Stage Iterative Workflow Mechanics (Fig. 2):
- Stage 1 (Elicitation via SSP): Starting from a human Proposer's rough system idea, PLANT proposes candidate stakeholder personas (confirmed by the human user), and the User agent simulates them concurrently to collect broad initial needs without sequential anchoring.
- Stage 2 (Parallel Multi-Perspective Analysis, Grounding & Modeling): Analyst structures user requirements, sets scope boundaries, and flags initial conflicts; Expert audits against external regulations/standards; Modeler builds and validates PlantUML models. Analyst consolidates these parallel outputs into a baseline requirements draft and conflict report.
- Stage 3 (Mediator-Guided Iterative Negotiation): Across at most r bounded rounds, the Mediator extracts open issues and unresolved conflicts, dynamically applies Simultaneous-Talk or One-by-One dialogue, escalates high-impact deadlocks to HITL if needed, logs Meeting Minutes (MoM), and triggers synchronous updates to drafts, conflict reports, and UML models.
- Stage 4 (Specification & Design Rationale Generation): Upon convergence or reaching round r, Documenter compiles the IEEE 29148 SRS and links each requirement back to originating stakeholder remarks, conflict deliberations, and MoM rulings.
-->

---

## 3.3 Simultaneous Stakeholder Prompting & Knowledge Grounding

<div class="fig-box" style="padding: 8px 12px; margin-bottom: 10px;">
<img src="./img/fig3_ssp.png" alt="Fig. 3: Simultaneous Stakeholder Prompting (SSP)" style="max-height: 185px;">
<div class="fig-cap">Fig. 3: Simultaneous Stakeholder Prompting (SSP) — independent multi-persona brainstorming</div>
</div>

<div class="two-col">
<div class="card small-text">

### 🗣️ Unbiased Stakeholder Elicitation (SSP)
- Extends Solo Performance Prompting (SPP) [19] using **Simultaneous-Talk** [4]: personas (e.g., *Customer*, *Courier*, *Restaurateur*) generate needs independently without anchoring on prior speakers.

</div>
<div class="card teal small-text">

### 📚 External Knowledge & UML Consistency
- **Expert** queries uploaded laws/standards (ISO 29148, ISO 25010, privacy laws) during initial audit and on-demand negotiation.
- **Modeler** runs PlantUML syntax/consistency checks to expose missing exception paths (e.g., *courier order timeout & reassignment*).

</div>
</div>

<!--
Unbiased Elicitation (SSP), Two-Point Knowledge Retrieval & Model Validation (Fig. 3):
- Simultaneous Stakeholder Prompting (SSP): Extends Solo Performance Prompting (SPP, Wang et al. [19]) with Simultaneous-Talk (Chan et al. [4]). Independent personas (e.g., consumer prioritizing convenience/payments, restaurant owner focusing on peak-hour order control, courier prioritizing routing and earnings transparency) generate requirements concurrently before observing peers, eliminating first-speaker anchoring.
- Two-point External Knowledge Grounding: Users upload project documents, privacy/payment regulations, ISO/IEC/IEEE 29148 [18], and ISO/IEC 25010 [20] into the Document Library. Expert retrieves passages (1) during initial Stage 2 auditing and (2) on demand during Stage 3 negotiation whenever regulatory or technical feasibility questions arise.
- Noise & contradiction handling: Expert filters retrieved chunks against the confirmed in-scope boundary and cites explicit constraints; during One-by-One negotiation, Analyst and Modeler cross-examine whether cited constraints clash with functional workflows, escalating unresolved policy conflicts to HITL.
- Tool-assisted PlantUML validation: Formalizing sequence and use-case diagrams systematically reveals lifecycle omissions—for instance, exposing that courier order acceptance lacks a timeout and automatic reassignment path.
-->

---

## 3.4 Mediator-Guided Negotiation Process

<div class="split55">
<div class="left">

<div class="fig-box">
<img src="./img/fig4_negotiation.png" alt="Fig. 4: Mediator-guided negotiation process" style="max-height: 410px;">
<div class="fig-cap">Fig. 4: Mediator-guided bounded negotiation & HITL escalation</div>
</div>

</div>
<div class="right small-text">

### ⚖️ Structured Agenda & Bounded Rounds
- At the start of each round (`1 ≤ t ≤ r`), the **Mediator** categorizes agenda issues into 4 types:
  1. Open-question exploration
  2. New-requirement supplementation
  3. Requirement trade-off evaluation
  4. Conflict resolution
- **Consensus** ➔ Recorded in Meeting Minutes (`MoM`), triggering draft & UML updates.
- **Deadlock / High-Impact Trade-Off** ➔ Packaged with candidate options for **Human-in-the-Loop (HITL)** adjudication.

</div>
</div>

<!--
Bounded Agenda Planning & Consensus / HITL Protocol (Fig. 4):
- Round initialization (1 <= t <= r): The Mediator inspects the current requirements draft, unresolved conflict report, and open issues, organizing them into a four-category agenda: (1) open-question exploration, (2) new-requirement supplementation, (3) requirement trade-off evaluation, and (4) conflict resolution.
- Consensus evaluation: After participating agents complete their turn on an agenda item, the Mediator checks whether all roles agree on a concrete resolution and no further clarification is requested. Resolved items are recorded in Meeting Minutes (MoM), which directly drive end-of-round updates to the requirements draft, conflict report, and PlantUML diagrams.
- Deadlock & high-impact escalation: When substantive disagreement persists after deliberation or an issue entails a strategic business trade-off (e.g., strict privacy deletion vs. dispute-audit retention), the Mediator packages competing rationales and candidate options for Human-in-the-Loop adjudication rather than forcing an arbitrary LLM vote.
-->

---

## 3.5 Hybrid-Communication-with-Mediator

While *Simultaneous-Talk* and *One-by-One* originate from ChatEval [4], PLANT's novelty is **task-adaptive dynamic switching** orchestrated by the `Mediator`.

<div class="fig-box" style="padding: 8px 10px; margin-top: 6px;">
<img src="./img/diag2_hybrid_comm.svg" alt="Hybrid-Communication-with-Mediator Diagram" style="max-height: 365px;">
</div>

<!--
Task-Adaptive Communication Switching (Hybrid-Communication-with-Mediator):
- Attribution vs. novelty: The paper explicitly notes that Simultaneous-Talk and One-by-One primitives originate from ChatEval (Chan et al. [4]) and are not claimed as new primitives. PLANT's methodological innovation is embedding a dedicated Mediator that dynamically selects and switches between these modes based on the specific RE objective of each agenda item.
- Divergent Expansion -> Simultaneous-Talk (Issue Types 1 & 2: open questions, new requirements): Analyst, Expert, and Modeler generate probing questions or gap assessments independently within the same turn without viewing peer outputs. This prevents early anchoring, curbs groupthink, and maximizes orthogonal coverage across functional scope, domain compliance, and behavioral states.
- Convergent Resolution -> One-by-One (Issue Types 3 & 4: trade-offs, conflict resolution): Agents deliberate sequentially (Analyst -> Expert -> Modeler), inspecting preceding arguments to verify whether candidate compromises violate domain laws or state-transition logic until reaching a mutually consistent verdict.
-->

---

## 4.1 Experimental Setup & Evaluation Metrics

<div class="fig-box" style="padding: 8px 10px; margin-bottom: 8px;">
<img src="./img/diag3_eval_setup.svg" alt="Experimental Evaluation Setup Pipeline" style="max-height: 225px;">
</div>

<div class="formula-strip">
<div class="formula-box">
<i>IRE<sub>t</sub></i> &nbsp;=&nbsp;
<span class="frac"><span class="frac-num"><i>E<sub>t</sub></i></span><span class="frac-den"><i>R<sub>t</sub></i></span></span>
&nbsp;× 100%
<span style="font-family: Inter, sans-serif; font-size: 0.76em; color: #64748b; margin-left: 10px;">(Recall of unique IRs)</span>
</div>
<div class="formula-box">
<i>TKQR<sub>t</sub></i> &nbsp;=&nbsp;
<span class="frac"><span class="frac-num">∑ <i>h<sub>t,i</sub></i> / log<sub>2</sub>(<i>i</i> + 1)</span><span class="frac-den">∑ 1 / log<sub>2</sub>(<i>i</i> + 1)</span></span>
&nbsp;× 100%
<span style="font-family: Inter, sans-serif; font-size: 0.76em; color: #64748b; margin-left: 10px;">(Early-turn efficiency)</span>
</div>
</div>

<div class="callout" style="margin-top: 8px; padding: 7px 14px;">
<strong>Strictly Automated Fair Comparison:</strong> During RQ1 &amp; RQ2 benchmark runs, <strong>0 human interventions</strong> occurred (<code>temperature = 0</code>, max <code>r = 20</code>), with independent <strong>GPT-5.2</strong> as LLM-as-a-Judge.
</div>

<!--
Benchmark Design, Baselines & Reproducibility Protocol (Tables 3 & 4):
- RQ1 Benchmark (103 IRs across 5 systems): Adopts 4 cases from ReqElicitGym [21] (Stock Report, Hospital Management, Ticket Booking, Vocabulary Learning—originally 36 functional IRs covering Interaction, Content, Style) and expands them using ISO/IEC 25010 [20] with 6 NFR categories (Reliability, Compatibility, Flexibility, Performance, Security, Safety) plus a newly constructed 5th multi-stakeholder case, Food Delivery (19 IRs), manually verified for non-overlap.
- RQ2 Benchmark (100 balanced pairs): Uses all 35 Conflict pairs plus 35 randomly sampled Neutral pairs from the Hospital Management subset of the CN dataset [22] (70 pairs), alongside 30 manually verified balanced pairs (15 Conflict, 15 Neutral) for Food Delivery.
- Baseline rationale: Compared against a single-agent LLM baseline on identical backbones (GPT-4.1 and Gemini 3 Flash). Peer multi-agent frameworks (MARE, iReDev, MAD) could not be directly executed because MARE/iReDev generate static drafts rather than turn-by-turn ReqElicitGym interviews (and iReDev requires custom domain KGs), while MAD targets requirement type classification without compatible open-source pipelines.
- Strict automation & metrics: HITL disabled (0 human interventions), temperature = 0, max r = 20 turns (RQ1), 3 independent runs reporting Mean +/- Std (RQ2). An LLM-based oracle simulated user discloses ground-truth IRs only when directly probed; an independent GPT-5.2 LLM-as-a-Judge (following G-Eval [23]) evaluates semantic hits, verified by authors. IRE_t = (E_t / R_t) * 100% measures unique IR recall; TKQR_t applies a 1 / log2(i + 1) logarithmic turn discount to reward early-turn discovery.
-->

---

## 4.2 RQ1 Case Study: Multi-Angle Probing in Food Delivery

Under **Simultaneous-Talk**, three agents independently probe the same abnormal-order scenario from distinct professional angles (Table 5):

| Agent Role | Independent Probing Question | Uncovered Stakeholder Need |
| :--- | :--- | :--- |
| **Analyst** | Should handling options apply to all abnormal scenarios or specific delays / courier no-shows? | *"Contact customer service" must always be available on exceptions.* |
| **Expert** | If real phone numbers are hidden and users only use **built-in in-app chat/voice**, does that satisfy you? | **Hit IR!** *"Yes — do not expose real phone numbers; use in-app anonymous call forwarding with dispute logs."* |
| **Modeler** | Should real-time handling options be restricted according to **order lifecycle states**? | *Cancellation depends on order state & refund policy with clear reasons.* |

<div class="callout">
<strong>Why Multi-Angle Probing Works:</strong> While Analyst and Modeler check functional rules and state transitions, the <strong>Expert</strong> surfaces a critical <strong>security &amp; privacy implicit requirement</strong> completely omitted from the initial description.
</div>

<!--
Qualitative Trace of Orthogonal Multi-Angle Probing (Table 5):
- Scenario: Abnormal order handling in the Food Delivery case under Mediator-selected Simultaneous-Talk.
- Orthogonal probing in a single turn:
  - Analyst probes functional exception scope ("all abnormal scenarios vs. specific delays/courier no-shows"), confirming that "contact customer service" must always remain accessible.
  - Modeler probes lifecycle state constraints ("restricting cancellation by order state"), clarifying state-dependent cancellation tied to refund policies and explicit reason display.
  - Expert independently probes privacy compliance ("hiding real phone numbers via built-in in-app chat/voice"), directly triggering the oracle stakeholder to reveal a ground-truth Security/Privacy implicit requirement: prohibiting direct exposure of customer and courier phone numbers, favoring anonymous call forwarding with dispute-accessible logs.
- Diagnostic takeaway: Because agents do not observe each other's draft questions before speaking, functional questioning does not anchor the Expert away from regulatory and privacy auditing.
-->

---

## 4.3 RQ1 Results: Implicit Requirement Elicitation (103 IRs)

<div class="three-col" style="margin-bottom: 10px;">
<div class="kpi-card teal">
<div class="kpi-val">54.28% vs. 16.77%</div>
<div class="kpi-label">Mean IRE with <strong>GPT-4.1</strong> (54 vs. 17 IRs · <strong>3.2×</strong> gain)</div>
</div>
<div class="kpi-card">
<div class="kpi-val">46.79% vs. 18.90%</div>
<div class="kpi-label">Mean IRE with <strong>Gemini 3 Flash</strong> (48 vs. 19 IRs · <strong>2.5×</strong> gain)</div>
</div>
<div class="kpi-card accent">
<div class="kpi-val">13–17 vs. ~6 Turns</div>
<div class="kpi-label">Prevents premature termination (TKQR: 55.0% / 64.9%)</div>
</div>
</div>

<div class="split55">
<div class="left small-text">

### 🏆 NFR Breakthrough (GPT-4.1 · Table 7)
<div style="margin-top: 8px;">
<div class="bar-row"><div><strong>Security (12 IRs)</strong></div><div class="bar-track"><div class="bar-fill teal" style="width: 83.3%;"></div></div><div class="bar-pct">10 vs. 2</div></div>
<div class="bar-row"><div><strong>Safety (3 IRs)</strong></div><div class="bar-track"><div class="bar-fill teal" style="width: 100%;"></div></div><div class="bar-pct">3 vs. 0</div></div>
<div class="bar-row"><div><strong>Reliability (7 IRs)</strong></div><div class="bar-track"><div class="bar-fill" style="width: 71.4%;"></div></div><div class="bar-pct">5 vs. 0</div></div>
<div class="bar-row"><div><strong>Compatibility (10)</strong></div><div class="bar-track"><div class="bar-fill" style="width: 70%;"></div></div><div class="bar-pct">7 vs. 3</div></div>
<div class="bar-row"><div><strong>Performance (6)</strong></div><div class="bar-track"><div class="bar-fill accent" style="width: 66.7%;"></div></div><div class="bar-pct">4 vs. 0</div></div>
</div>

</div>
<div class="right small-text">

### 📊 Case-Level IRE (%) — Table 6
| System Case | Base (GPT) | PLANT (GPT) | Base (Gem) | PLANT (Gem) |
| :--- | :---: | :---: | :---: | :---: |
| Stock Report | 17.65 | **82.35** | 23.53 | **52.94** |
| Hospital Mgmt | 19.05 | **47.62** | 23.81 | **47.62** |
| Ticket Booking | 13.04 | **43.48** | 8.70 | **39.13** |
| Vocab Learning | 13.04 | **34.78** | 17.39 | **52.17** |
| Food Delivery | 21.05 | **63.16** | 21.05 | **42.11** |

</div>
</div>

<!--
Quantitative Analysis of Implicit Requirement Elicitation (Tables 6 & 7):
- Overall IRE gains: Across all 5 systems, PLANT elevates mean IRE from 16.77% (Std 3.23) to 54.28% (Std 16.78) on GPT-4.1 (54 vs. 17 of 103 IRs; 3.2x gain) and from 18.90% (Std 5.60) to 46.79% (Std 5.44) on Gemini 3 Flash (48 vs. 19 IRs; 2.5x gain). Case-level highlights on GPT-4.1 include Stock Report (82.35% vs. 17.65%) and Food Delivery (63.16% vs. 21.05%).
- NFR breakthrough (Table 7): Single-agent baselines concentrate on surface Interaction and Content (11/17 hits on GPT-4.1; 13/19 on Gemini 3 Flash) and score 0 on Reliability (0/7), Performance (0/6), and Safety (0/3), with only 2/12 on Security. PLANT (GPT-4.1) uncovers 10/12 Security, 3/3 Safety, 5/7 Reliability, 7/10 Compatibility, and 4/6 Performance (while Style remains 0/10 for PLANT, reflecting its engineering-constraint emphasis).
- Interaction depth & TKQR nuance: PLANT sustains 17.00 turns (GPT-4.1) and 13.00 turns (Gemini 3 Flash) vs. 6.20 and 6.00 for baselines. PLANT's mean TKQR is slightly lower (54.95% vs. 61.35% on GPT-4.1; 64.87% vs. 70.43% on Gemini 3 Flash) because multi-agent runs invest early turns establishing scope and structural context before uncovering deep NFRs in later turns. The paper notes that IRE is recall-oriented and deeper probing can yield tangential candidates, mitigated in deployment by scope filtering and HITL review.
-->

---

## 4.4 RQ2 Results: Requirement Conflict Identification (100 Pairs)

Using **One-by-One** deliberation (e.g., *retain complete chat logs* vs. *delete chat records after resolution*), Analyst, Expert, and Modeler cross-check functional rules, privacy obligations, and state transitions (Tables 8 & 9).

| Dataset | Method | LLM Backbone | Macro F1 (%) | Conflict Precision | Conflict Recall | Conflict F1 (%) |
| :--- | :--- | :--- | :---: | :---: | :---: | :---: |
| **Hospital Mgmt** (70 pairs) | Baseline | GPT-4.1 / Gemini 3 | 81.33 / 72.52 | 86.67 / 79.30 | 74.29 / 61.91 | 80.00 / 69.51 |
| **Hospital Mgmt** (70 pairs) | **PLANT** | **GPT-4.1 / Gemini 3** | **90.91 / 89.46** | 86.66 / 84.35 | **97.14 / 97.14** | **91.51 / 90.28** |
| **Food Delivery** (30 pairs) | Baseline | GPT-4.1 / Gemini 3 | 89.90 / 86.43 | 100.0 / 100.0 | 80.00 / 73.33 | 88.89 / 84.62 |
| **Food Delivery** (30 pairs) | **PLANT** | **GPT-4.1 / Gemini 3** | **95.55 / 96.66** | 95.69 / 93.75 | **95.55 / 100.0** | **95.55 / 96.77** |

<div class="callout">
<strong>RQ2 Finding:</strong> Single-agent baselines are overly conservative (missing 20%–38% of conflicts). PLANT lifts <strong>Conflict-class Recall to 95.55%–100.00%</strong> and <strong>Conflict F1 by +6.66 to +20.77 pts</strong> while avoiding false alarms on distinct data scopes.
</div>

<!--
Quantitative Analysis of Pairwise Conflict Identification (Tables 8 & 9):
- Deliberation mechanics (Table 8): On a Food Delivery pair pitting "retain complete customer-service conversation records" against "delete chat records and personal contact info after resolution," One-by-One sequential review allows Analyst (contradictory data retention policy), Expert (mutually exclusive personal-data retention vs. deletion obligations), and Modeler (incompatible process/state lifecycle) to converge on Conflict. Conversely, when requirements govern distinct data scopes (e.g., hiding a deleted address from the front-end UI vs. retaining an anonymized hash in backend audit logs), sequential cross-checking prevents false-positive conflict alarms.
- Hospital Management (70 pairs, Mean +/- Std across 3 runs): Macro F1 jumps from 81.33 +/- 0.00% to 90.91 +/- 1.81% (GPT-4.1) and from 72.52 +/- 0.08% to 89.46 +/- 1.37% (Gemini 3 Flash). Conflict-class Recall surges from 74.29% and 61.91% to 97.14% on both models, lifting Conflict F1 by +11.51 pts (GPT-4.1) and +20.77 pts (Gemini 3 Flash).
- Food Delivery (30 pairs): Macro F1 rises from 89.90% to 95.55% (GPT-4.1) and from 86.43% to 96.66% (Gemini 3 Flash). Single-agent baselines achieve 100% precision only by being overly conservative—flagging obvious lexical contradictions while missing 20.00% to 26.67% of true conflicts. PLANT raises Conflict Recall to 95.55% (GPT-4.1) and 100.00% (Gemini 3 Flash), lifting Conflict F1 by +6.66 and +12.15 pts.
-->

---

## 4.5 RQ3 Results: Cost-Effectiveness & Deployment Trade-Off

| LLM Backbone | Elicited IRs (Base / PLANT) | Avg. Tokens (k) (Base / PLANT) | Avg. Runtime (Base / PLANT) | Avg. Cost (US$) (Base / PLANT) | IRE Gain / 1M Tok. | Cost per IR (PLANT / Base) |
| :--- | :---: | :---: | :---: | :---: | :---: | :---: |
| **GPT-4.1** | 17 / **54** | 40.3 / **3,761** (`93.4×`) | 134s / **3,700s** (`27.6×`) | $0.12 / **$8.14** | **9.65%** | **$0.1507** / $0.0071 |
| **Gemini 3 Flash** | 19 / **48** | 39.4 / **9,811** (`248.8×`) | 114s / **4,173s** (`36.6×`) | $0.07 / **$6.71** | **2.88%** | **$0.1399** / $0.0036 |

<div class="two-col" style="margin-top: 8px;">
<div class="card teal small-text">

### ✅ When PLANT Is Highly Cost-Effective
- Medium-to-large, **compliance-sensitive**, or multi-stakeholder projects at project inception.
- Spending **~1 hour & US\$6.71–\$8.14** (~US\$0.14–\$0.15 per IR) to uncover **2.5×–3.2× more NFRs** is far cheaper than late-stage rework or security defects.

</div>
<div class="card accent small-text">

### ⚡ When a Single-Agent Is Preferable
- Rapid prototyping, simple single-user apps, or real-time brainstorming requiring **sub-minute latency** and minimal API budget.

</div>
</div>

<!--
Resource Footprint, Marginal Return & Deployment Economics (Table 10):
- Per-case resource comparison (averaged over the 5 RQ1 cases):
  - GPT-4.1: Baseline uses 40.26k tokens, 134s, US$0.1206; PLANT uses 3,761.03k tokens (93.4x), 3,700s (27.6x), and US$8.1368 (67.5x), yielding a marginal IRE gain of 9.65% per additional 1M tokens. Unit cost per elicited IR is 69.65k tokens, 68.51s, and US$0.1507 (vs. 2.37k, 7.85s, US$0.0071 for baseline).
  - Gemini 3 Flash: Baseline uses 39.43k tokens, 114s, US$0.0688; PLANT uses 9,810.93k tokens (248.8x), 4,173s (36.6x), and US$6.7145 (97.6x), yielding 2.88% IRE gain per additional 1M tokens and US$0.1399 per elicited IR (204.39k tokens, 86.94s).
- Cross-backbone insight: While Gemini 3 Flash achieves slightly lower total monetary cost ($6.71 vs. $8.14), GPT-4.1 is substantially more token-efficient (3.76M vs. 9.81M tokens; 9.65% vs. 2.88% IRE gain per 1M tokens) and discovers more IRs (54 vs. 48).
- Practical decision boundary: Because requirements elicitation occurs infrequently at project inception or major releases—and missed NFRs or conflicts are among the costliest post-implementation defects—spending ~1 hour and US$6.71 to $8.14 to uncover 2.5x to 3.2x more implicit requirements is highly economical for medium-to-large, compliance-sensitive, or multi-stakeholder systems. Single-agent LLMs remain preferable for rapid prototyping or sub-minute interactive brainstorming.
-->

---

## 4.6 Component Contribution Analysis

Although a full combinatorial ablation is left for future work, our aspect-level breakdown (Table 7) and qualitative traces clarify each component's role:

<div class="two-col">
<div class="card small-text">

### 🧩 Analyst + User Only vs. +Expert & +Modeler
- **Single-Agent Baseline** approximates *Analyst + User* only — capturing primarily *Interaction* & *Content* (11/17 GPT-4.1 hits) while scoring **0** on *Reliability*, *Performance*, and *Safety*.
- Adding **Expert** directly drives *Security* (**9–10/12**), *Safety* (**2–3/3**), and regulatory *Compatibility* discovery.
- Adding **Modeler** uncovers *Reliability* (**2–5/7**) and state-transition edge cases via PlantUML validation.

</div>
<div class="card accent small-text">

### 🧭 Role of Mediator & Hybrid Communication
- Without the **Mediator** consolidating open issues and dynamically switching modes:
  - Pure *One-by-One* brainstorming risks **early anchoring** and groupthink.
  - Uncoordinated parallel dialogue risks **redundant questioning** and unresolved deadlocks.
- Controlled 4-way ablation under **matched turn & token budgets** is a top priority for future work.

</div>
</div>

<!--
Expected Architectural Contributions & Planned Ablation Design (Section 4.3):
- Inferring role impact from aspect-level evidence (Table 7) and dialogue traces:
  - Analyst + User baseline proxy: The single-agent baseline mirrors a solo analyst interviewing a user—capturing primarily Interaction and Content (11/17 GPT-4.1 hits; 13/19 Gemini hits) while scoring 0 on Reliability, Performance, and Safety.
  - Expert contribution: External regulatory and ISO 25010 auditing directly drives breakthroughs in Security (9 to 10 of 12), Safety (2 to 3 of 3), and regulatory Compatibility (6 to 7 of 10), as well as legal data-retention conflict detection.
  - Modeler contribution: Formalizing use-case, class, and sequence diagrams via PlantUML validation systematically exposes Reliability requirements (2 to 5 of 7) and state-transition edge cases (e.g., timeout reassignment).
  - Mediator & Hybrid Communication contribution: Dynamically pairing Simultaneous-Talk (for divergent probing) with One-by-One (for convergent conflict resolution) prevents both the early anchoring of pure sequential brainstorming and the redundant, non-converging chatter of uncoordinated parallel agents.
- Future controlled ablation: A 4-way ablation (without Mediator, Analyst + User only, without Expert/KB, and One-by-One only) under matched turn and token budgets is prioritized for future work.
-->

---

## 4.7 Threats to Validity

<div class="three-col">
<div class="card small-text">

### 🔍 Internal Validity
- **Interaction Budget**: PLANT runs 13–17 turns vs. ~6 turns (93–249× tokens); gains reflect *both* role specialization and deeper interaction.
- **Live Web Search**: While local Document Library docs were static (`temp = 0`), caching live search snapshots will strengthen reproducibility.

</div>
<div class="card accent small-text">

### 🎯 Construct Validity
- **Simulated Users & LLM Judge**: Oracle simulated users may be more cooperative than real clients; multi-judge & human studies are needed.
- **Recall Focus & Scope**: IRE does not penalize out-of-scope questions (mitigated by scope filtering/HITL); downstream SRS & UML quality was not yet quantitatively scored.

</div>
<div class="card teal small-text">

### 🌐 External Validity
- **Dataset Scale**: Evaluated on 5 system cases (103 IRs) across finance, healthcare, transport, education & logistics, plus 100 conflict pairs.
- **Broader Baselines**: Future work will expand to larger industrial repositories and task-adapted multi-agent baselines.

</div>
</div>

<!--
Methodological Threats to Validity (Section 4.3):
- Internal Validity:
  - Interaction & token budget asymmetry: PLANT runs 13 to 17 turns vs. ~6 turns and consumes 93.4x to 248.8x more tokens; observed IRE gains reflect the combined effect of role specialization and deeper interaction horizons rather than role division alone.
  - External retrieval reproducibility: Although temperature = 0 and local Document Library files were static, live web search queries can drift over time; caching all external retrieval snapshots will strengthen reproducibility.
- Construct Validity:
  - Oracle simulated user & single LLM judge: Following ReqElicitGym [21] and G-Eval [23], RQ1 relies on a simulated user (potentially more cooperative than real stakeholders) and a single GPT-5.2 judge (potential evaluator bias), warranting multi-judge consensus and human-subject interviews.
  - Recall-only metric & downstream scope: IRE does not penalize false-positive or over-specified candidate requirements (managed in practice via scope filtering and HITL). Additionally, quantitative experiments evaluated upstream elicitation (RQ1) and conflict classification (RQ2) rather than directly scoring downstream SRS quality, hallucination rates, or traceability accuracy.
- External Validity:
  - Dataset scale: While the 5 cases (103 IRs) and 100 conflict pairs span finance, healthcare, transportation, education, and e-commerce logistics, larger industrial repositories and task-adapted multi-agent baselines are needed for broader generalization.
-->

---

## 5. Conclusion & Future Work

<div class="fig-box" style="padding: 8px 10px; margin-bottom: 8px;">
<img src="./img/diag4_rq_conclusions.svg" alt="Visual Synthesis of PLANT RQ1-RQ3 Conclusions" style="max-height: 360px;">
</div>

<div class="future-strip">
<div class="future-pill"><strong>🧪 1. Fixed-Budget Ablations</strong><br>Isolate Expert, Modeler & Mediator gains under matched token/turn budgets against multi-agent baselines.</div>
<div class="future-pill"><strong>👩‍💻 2. Human SRS Evaluation</strong><br>Quantitatively assess UML completeness, factual grounding & DR traceability with practitioners.</div>
<div class="future-pill"><strong>⚙️ 3. Spec-Driven Development</strong><br>Feed PLANT's traceable IEEE 29148 SRS directly into automated test-case & code generation [24].</div>
</div>

<!--
Synthesis of Empirical Conclusions & Research Roadmap:
- Core conclusions across RQ1 to RQ3:
  - RQ1: Specialized multi-agent probing with external knowledge grounding elevates implicit requirement recall by 2.5x to 3.2x (54.28% on GPT-4.1; 46.79% on Gemini 3 Flash), overcoming single-agent premature termination (~6 turns) and unlocking critical NFRs.
  - RQ2: Mediator-guided One-by-One deliberation raises Conflict-class Recall to 95.55% to 100.00% and Macro F1 to 89.46% to 96.66%, resolving single-agent conservatism while preserving precision across distinct data scopes.
  - RQ3: Computational overhead (93.4x to 248.8x tokens; 27.6x to 36.6x runtime; US$6.71 to $8.14 per system) yields ~US$0.14 to $0.15 per uncovered IR, proving practical for high-stakes, compliance-critical inception phases.
- Three concrete future directions: (1) Controlled fixed-budget ablations and direct comparisons against task-adapted multi-agent baselines; (2) human practitioner evaluation of UML completeness, factual grounding, hallucination rates, and Design Rationale traceability; and (3) feeding PLANT's traceable IEEE 29148 SRS into Specification-Driven Development (SDD, Piskala [24]) for automated test-case and code generation.
-->

---

<!-- _class: closing -->

# Thank You for Your Attention!

<p style="font-size: 1.05em; max-width: 840px;">
Enhancing Requirements Engineering Efficiency through a Multi-Agent AI Framework (PLANT)
</p>

<div class="contact-card">
<strong>Nien-Lin Hsueh<sup>+</sup></strong> &nbsp;·&nbsp; <code>nlhsueh@fcu.edu.tw</code><br>
<strong>Shu-Hsien Liao</strong> &nbsp;·&nbsp; <code>m1325977@o365.fcu.edu.tw</code><br>
Department of Information Engineering and Computer Science, Feng Chia University<br>
Online Repository & Artifacts: <code>https://dummyjack.github.io/PLANT-Manual/</code><br>
<span style="font-size: 0.85em; opacity: 0.85;">Grant: NSTC114-2221-E-035-077 · Questions & Discussion Welcome!</span>
</div>

<!--
Publication, Artifact Repository & Attribution Summary:
- Full Citation: Nien-Lin Hsueh and Shu-Hsien Liao, "Enhancing Requirements Engineering Efficiency through a Multi-Agent AI Framework," Journal of Information Science and Engineering (JISE), 2026, Department of Information Engineering and Computer Science, Feng Chia University, Taichung 407, Taiwan.
- Public Artifacts & Reproducibility Package: Complete system documentation, verbatim agent prompt templates (summarized in Table 4), sample IEEE 29148 SRS outputs, PlantUML diagrams, and Design Rationale logs are openly accessible at https://dummyjack.github.io/PLANT-Manual/.
- Funding Acknowledgment: Supported by the National Science and Technology Council (NSTC), Taiwan R.O.C., under grant NSTC114-2221-E-035-077.
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
