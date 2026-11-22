---
marp: true
theme: gaia
size: 16:9
paginate: true
html: true
header: '<div class="hdr-wrap"><span class="hdr-title">Tiered LLM Assistance in Programming Learning</span><div class="hdr-actions"><a class="lang-btn" href="./SCT_slide_zh.html" title="切換至繁體中文簡報">🌐 繁</a><div class="nav-dropdown"><button class="nav-btn">Sections ▾</button><div class="nav-menu"><a href="#2">Opening Hook: AI Tax</a><a href="#3">Outline</a><a href="#4">1. Introduction & RQs</a><a href="#6">2. Related Work</a><a href="#7">3. Methodology & LADI</a><a href="#11">4. SCT System</a><a href="#13">5. Empirical Results</a><a href="#20">6. Conclusion & Future Work</a></div></div></div></div>'
footer: 'Nien-Lin Hsueh & Ying-Chang Lu · Feng Chia University · Smart Coding Tutor (SCT)'
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
  font-size: 21px;
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
  min-width: 220px;
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
  font-size: 1.28em;
  font-weight: 700;
  line-height: 1.25;
  margin: 0 0 14px 0;
  padding-bottom: 6px;
  border-bottom: 2.5px solid var(--navy);
  display: flex;
  align-items: center;
  gap: 8px;
}

h3 {
  color: var(--accent);
  font-size: 0.98em;
  font-weight: 700;
  margin: 4px 0 6px 0;
}

p {
  margin: 0 0 8px 0;
}

ul, ol {
  margin: 4px 0 8px 0;
  padding-left: 24px;
}

li {
  margin-bottom: 6px;
  line-height: 1.44;
}

li > ul {
  margin-top: 3px;
  margin-bottom: 3px;
}

li > ul > li {
  font-size: 0.92em;
  margin-bottom: 3px;
}

strong {
  color: var(--slate-900);
}

a {
  color: #2563eb;
  text-decoration: none;
}

a:hover {
  text-decoration: underline;
}

/* Inline code without background (per AGENTS.md) */
:not(pre, marp-pre) > code {
  background: transparent !important;
  border: none !important;
  padding: 0 !important;
  font-family: 'JetBrains Mono', monospace;
  font-size: 0.9em;
  font-weight: 600;
  color: #475569;
}

h1 code, h2 code, h3 code {
  color: #0b3c5d;
}

section table th {
  background: var(--navy) !important;
  color: #ffffff !important;
}

section table th code {
  color: #ffffff !important;
}

section.lead code,
section.closing code {
  color: #bae6fd !important;
}

section.closing strong {
  color: #ffffff !important;
}

/* Lead / Title Slide */
section.lead {
  background: linear-gradient(135deg, #102442 0%, #1b365d 62%, #294c7a 100%);
  color: #ffffff;
  display: flex;
  flex-direction: column;
  justify-content: center;
  padding: 54px 72px;
}

section.lead header,
section.lead footer,
section.lead::after {
  display: none !important;
}

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
  font-size: 1.95em;
  font-weight: 800;
  line-height: 1.24;
  margin-bottom: 18px;
  text-align: left;
}

section.lead .subtitle {
  color: #cbd5e1;
  font-size: 0.95em;
  line-height: 1.5;
  margin-bottom: 28px;
  max-width: 920px;
}

section.lead .meta-box {
  border-left: 4px solid #f43f5e;
  padding-left: 18px;
  color: #e2e8f0;
  font-size: 0.85em;
  line-height: 1.55;
}

section.lead .meta-box strong {
  color: #ffffff;
}

section.lead .grant {
  margin-top: 22px;
  font-size: 0.72em;
  color: #94a3b8;
}

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

section.closing header,
section.closing footer,
section.closing::after {
  display: none !important;
}

section.closing h1 {
  color: #ffffff;
  font-size: 2.3em;
  margin-bottom: 12px;
}

section.closing p {
  color: #e2e8f0;
}

section.closing .contact-card {
  margin-top: 24px;
  background: rgba(255, 255, 255, 0.12);
  border: 1px solid rgba(255, 255, 255, 0.25);
  border-radius: 12px;
  padding: 18px 34px;
  font-size: 0.85em;
  line-height: 1.65;
  color: #f8fafc;
}

/* Grids & Layouts */
.two-col {
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 22px;
  align-items: stretch;
}

.three-col {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: 16px;
  align-items: stretch;
}

.four-col {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: 14px;
  align-items: stretch;
}

.split64 {
  display: grid;
  grid-template-columns: 58% 40%;
  gap: 2%;
  align-items: center;
}

.split46 {
  display: grid;
  grid-template-columns: 42% 56%;
  gap: 2%;
  align-items: center;
}

.split55 {
  display: grid;
  grid-template-columns: 49% 49%;
  gap: 2%;
  align-items: center;
}

/* Cards & Callouts */
.card {
  background: #ffffff;
  border: 1px solid var(--slate-200);
  border-top: 3.5px solid var(--navy);
  border-radius: 8px;
  padding: 14px 18px;
  box-shadow: 0 2px 6px rgba(15, 23, 42, 0.05);
  box-sizing: border-box;
}

.card.accent {
  border-top-color: var(--accent);
}

.card.teal {
  border-top-color: var(--teal);
}

.kpi-card {
  background: var(--slate-100);
  border: 1px solid var(--slate-200);
  border-left: 4px solid var(--navy);
  border-radius: 8px;
  padding: 12px 16px;
  box-sizing: border-box;
}

.kpi-card.accent {
  border-left-color: var(--accent);
  background: var(--accent-soft);
}

.kpi-card.teal {
  border-left-color: var(--teal);
  background: var(--teal-soft);
}

.kpi-val {
  font-size: 1.55em;
  font-weight: 800;
  color: var(--navy);
  line-height: 1.15;
  margin-bottom: 4px;
}

.kpi-card.accent .kpi-val {
  color: var(--accent);
}

.kpi-card.teal .kpi-val {
  color: var(--teal);
}

.kpi-label {
  font-size: 0.78em;
  color: var(--slate-700);
  line-height: 1.32;
}

.callout {
  background: #f8fafc;
  border-left: 4px solid var(--accent);
  border-radius: 0 8px 8px 0;
  padding: 10px 16px;
  margin-top: 10px;
  font-size: 0.88em;
  color: var(--slate-700);
}

.callout strong {
  color: var(--navy);
}

/* Tables (Compact Anti-Overflow per AGENTS.md) */
table {
  width: 100%;
  border-collapse: collapse;
  font-size: 0.78em;
  margin: 8px 0;
  background: #ffffff;
  border: 1px solid var(--slate-200);
}

th {
  background: var(--navy);
  color: #ffffff;
  font-weight: 700;
  padding: 6px 10px;
  text-align: left;
  border: 1px solid var(--navy);
}

td {
  padding: 5px 10px;
  border: 1px solid var(--slate-200);
  vertical-align: middle;
  line-height: 1.35;
}

tr:nth-child(even) td {
  background: #f8fafc;
}

tr.highlight-row td {
  background: #fdf2f5 !important;
  font-weight: 700;
  color: var(--navy);
}

.center-cell {
  text-align: center;
}

/* Formula Box (Zero-LaTeX Publication Style) */
.formula-box {
  background: #f8fafc;
  border: 1.5px solid #cbd5e1;
  border-left: 5px solid var(--navy);
  border-radius: 8px;
  padding: 14px 22px;
  margin: 10px 0 12px 0;
  display: flex;
  justify-content: center;
  align-items: center;
  font-family: 'Georgia', 'Times New Roman', serif;
  font-size: 1.22em;
  color: var(--slate-900);
}

.frac {
  display: inline-flex;
  flex-direction: column;
  align-items: center;
  vertical-align: middle;
  margin: 0 4px;
  line-height: 1.1;
}

.frac-num {
  border-bottom: 1.5px solid var(--slate-900);
  padding: 0 6px 2px 6px;
}

.frac-den {
  padding: 2px 6px 0 6px;
}

.piecewise {
  display: inline-flex;
  align-items: center;
  gap: 8px;
}

.brace {
  font-size: 2.3em;
  font-weight: 300;
  line-height: 1;
  color: var(--navy);
}

.cases {
  display: flex;
  flex-direction: column;
  gap: 4px;
  text-align: left;
  font-size: 0.94em;
}

/* Outline Grid */
.outline-grid {
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 14px 24px;
  margin-top: 8px;
}

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

.outline-body {
  font-size: 0.86em;
  line-height: 1.38;
}

.outline-body a {
  color: var(--navy);
  font-weight: 700;
  font-size: 1.05em;
}

/* Bar Charts */
.bar-row {
  display: grid;
  grid-template-columns: 205px 1fr 92px;
  align-items: center;
  gap: 14px;
  margin-bottom: 12px;
  font-size: 0.85em;
}

.bar-track {
  background: var(--slate-100);
  border-radius: 6px;
  height: 24px;
  overflow: hidden;
  border: 1px solid var(--slate-200);
}

.bar-fill {
  height: 100%;
  border-radius: 5px;
  background: var(--navy);
}

.bar-fill.accent {
  background: var(--accent);
}

.bar-fill.teal {
  background: var(--teal);
}

.bar-fill.muted {
  background: #64748b;
}

.bar-pct {
  font-weight: 700;
  text-align: right;
  color: var(--slate-900);
  white-space: nowrap;
}

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





.fig-cap {
  font-size: 0.72em;
  color: var(--slate-500);
  margin-top: 6px;
  font-weight: 500;
}

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

.small-text {
  font-size: 0.84em;
}

/* Incremental RQ Grid (Slide 4) */
.rq-stage ul {
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 16px;
  list-style: none !important;
  padding: 0 !important;
  margin: 10px 0 0 0 !important;
}

.rq-stage li {
  margin: 0 !important;
  padding: 0 !important;
  list-style: none !important;
}

.rq-stage li::marker {
  content: "";
}

.rq-card {
  display: flex;
  align-items: center;
  gap: 14px;
  background: #ffffff;
  border: 1px solid var(--slate-200);
  border-top: 3.5px solid var(--navy);
  border-radius: 10px;
  padding: 13px 16px;
  box-shadow: 0 2px 8px rgba(15, 23, 42, 0.06);
  height: 100%;
  box-sizing: border-box;
}

.rq-card.teal { border-top-color: var(--teal); }
.rq-card.accent { border-top-color: var(--accent); }

.rq-card img {
  width: 92px;
  height: 92px;
  flex-shrink: 0;
  border-radius: 10px;
}

.rq-hook {
  font-size: 0.88em;
  font-weight: 800;
  color: var(--navy);
  line-height: 1.28;
  margin-bottom: 5px;
}

.rq-card.teal .rq-hook { color: var(--teal); }
.rq-card.accent .rq-hook { color: var(--accent); }

.rq-q {
  font-size: 0.77em;
  color: var(--slate-700);
  line-height: 1.4;
}

.future-strip {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: 12px;
  margin-top: 10px;
}

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

.future-pill strong {
  color: var(--navy);
}

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

<div class="badge">Academic Conference Presentation · Programming Education & Learning Analytics</div>

# Application and Analysis of a Tiered LLM-Based Programming Assistance Mechanism in Programming Learning

<div class="subtitle">
Transforming AI Assistance from an Unregulated Aid into a Controllable, Recordable, and Analyzable Instructional Intervention
</div>

<div class="meta-box">
<strong>Nien-Lin Hsueh<sup>+</sup></strong> and <strong>Ying-Chang Lu</strong><br>
Department of Information Engineering and Computer Science, Feng Chia University, Taichung, Taiwan<br>
<code>nlhsueh@fcu.edu.tw</code> · <code>m1305878@o365.fcu.edu.tw</code>
</div>

<div class="grant">
Supported by the National Science and Technology Council (NSTC), Taiwan R.O.C., under grant NSTC114-2221-E-035-077.
</div>

<!--
Paper Context & Core Contribution:
- Published in the Journal of Information Science and Engineering (JISE) by Nien-Lin Hsueh and Ying-Chang Lu (Department of Information Engineering and Computer Science, Feng Chia University; NSTC grant NSTC114-2221-E-035-077).
- Central problem: When Large Language Models (LLMs) are integrated into programming assessments, raw test-case scores conflate independent programming competence with reliance on AI-generated hints or solution structures, undermining assessment interpretability and discriminative power.
- Core contribution: The paper designs, implements, and empirically evaluates Smart Coding Tutor (SCT), an online judge platform embedding a five-level tiered AI assistance mechanism (L0 to L4), explicit AI Tax Rates (0% to 20%), stagnation-triggered proactive prompts, post-completion conceptual consolidation, and a continuous behavioral metric—the Level-Anchored Dependency Index (LADI)—validated with 112 university Python students.
-->

---

## Opening Hook: What If Using AI Came With an "AI Tax"?

<div class="fig-box" style="padding: 6px; margin-bottom: 10px; background: #fbf9f2;">
<img src="./img/ai_tax_hook.jpg" alt="Humorous illustration of AI Tax in a programming exam" style="max-height: 415px; border-radius: 6px;">
</div>

<div class="callout" style="margin-top: 6px; padding: 9px 16px;">
<strong>The Big Idea:</strong> Don't close the highway — <strong>put a tollbooth on the AI Express Lane!</strong> Students can still request tiered AI guidance when stuck, while an explicit <strong>AI Tax (0%–20%)</strong> keeps scores fair, transparent, and interpretable.
</div>

<!--
Conceptual Framing of the "AI Tax":
- Programming educators face a structural dichotomy: prohibiting LLMs altogether deprives novices of timely debugging explanations and motivational scaffolding, whereas allowing unrestricted external AI collapses grade variance because students with vastly different conceptual mastery can submit identical passing code.
- Operational mechanism: Rather than blocking AI access, SCT internalizes AI support inside the formal assessment environment and attaches an explicit, transparent institutional cost—the AI Tax Rate (0% at L0 up to 20% at L4)—to each escalating tier of assistance.
- Pedagogical rationale: Making assistance cost observable converts hidden external reliance into an explicit self-regulation decision, enabling instructors to separate independent competence from scaffolded completion while preserving equitable learning support.
-->

---

## Presentation Outline

<div class="outline-grid">

<div class="outline-item">
<div class="outline-num">1</div>
<div class="outline-body">

[**Introduction & Research Questions**](#4)
Assessment challenges of open LLM use and our four research questions (RQ1–RQ4).

</div>
</div>

<div class="outline-item">
<div class="outline-num">2</div>
<div class="outline-body">

[**Related Work & Research Gap**](#6)
Comparison of LLM programming tutors and the lack of formal assessment integration.

</div>
</div>

<div class="outline-item">
<div class="outline-num">3</div>
<div class="outline-body">

[**Methodology: Tiered AI, AI Tax & LADI**](#7)
Five-level AI tutor, proactive prompts, reflection checks, EPC, and LADI index.

</div>
</div>

<div class="outline-item">
<div class="outline-num">4</div>
<div class="outline-body">

[**Smart Coding Tutor (SCT) System**](#11)
System architecture, level-based prompt builder, and student interfaces.

</div>
</div>

<div class="outline-item">
<div class="outline-num">5</div>
<div class="outline-body">

[**Empirical Study & Results (RQ1–RQ4)**](#13)
Evaluation with 112 Python students across 3 formal assessments (9 tasks).

</div>
</div>

<div class="outline-item">
<div class="outline-num">6</div>
<div class="outline-body">

[**Conclusion & Future Work**](#20)
Key pedagogical implications, limitations, and directions for longitudinal study.

</div>
</div>

</div>

<!--
Paper Structural Roadmap:
- Section 1 (Introduction) establishes the assessment interpretability crisis caused by open LLM usage and defines four research questions (RQ1 to RQ4) spanning discrimination, tiered support efficacy, usage strategies, and AI dependency.
- Section 2 (Related Work) surveys LLM-based programming tutors, automated semantic grading, exercise generation, and proactive educational AI frameworks, positioning SCT against five representative systems (Table 1).
- Section 3 (Research Method) formalizes the five-level AI tutor, AI Tax Rate rule, proactive support loop, post-AC concept checks, Escalation Profile Coefficient (EPC), and Level-Anchored Dependency Index (LADI).
- Section 4 (Smart Coding Tutor) details the integrated platform architecture and tiered UI modules; Section 5 reports empirical findings from 112 Python students across 3 formal assessments (9 tasks); Section 6 synthesizes implications, limitations, and future directions.
-->

---

## 1.1 Motivation: The Assessment Dilemma in AI-Assisted Learning

<div class="fig-box" style="padding: 10px 12px; margin-bottom: 10px;">
<img src="./img/diag1_assessment_dilemma.svg" alt="Conceptual contrast: Open AI vs. Tiered AI Assessment" style="max-height: 365px;">
</div>

<div class="callout">
<strong>Core Design Philosophy:</strong> The goal is <strong>not to prohibit AI</strong>, but to transform AI assistance into a <strong>controllable, tiered, and recordable</strong> instructional intervention that preserves assessment interpretability.
</div>

<!--
Theoretical & Empirical Motivation:
- Capabilities vs. assessment risks: LLMs excel at natural-language error explanation, program repair, conversational tutoring, and semantic feedback (Ozkaya [1]; Liu et al. [2]; Pereira & Mello [3]), reducing instructional bottlenecks in large introductory programming classes (Messer et al. [4]).
- Limitations of traditional Online Judges (OJs): Automated graders rely predominantly on test-case pass/fail verdicts and output matching, which cannot observe reasoning quality, debugging trajectories, or the intensity of external assistance mobilized (Messer et al. [4]; Gabbay & Cohen [5]).
- Prior course evidence: In earlier iterations of the authors' course under unrestricted AI access, programming scores exhibited severe ceiling effects (high score concentration) while conceptual understanding remained widely dispersed; the correlation between AI usage frequency and conceptual scores was only r = 0.136, confirming that uncalibrated scores fail to reflect independent mastery.
- Design stance: Aligned with human-AI collaboration principles (Kazemitabaar et al. [7]; Chen et al. [10]; Yan [12]), SCT treats AI as a controllable, recordable, and analyzable instructional intervention rather than a prohibited external shortcut.
-->

---

## 1.2 Research Objectives & Four Research Questions

To evaluate whether **Smart Coding Tutor (SCT)** balances scaffolding with assessment integrity, we investigate **four core questions** *(revealed step-by-step)*:

<div class="rq-stage">

* <div class="rq-card teal"><img src="./img/rq1_icon.svg" alt="RQ1 Unmask Mastery"><div><div class="rq-hook"><span class="rq-tag" style="background:#0f766e;">RQ1</span> Can we unmask true mastery?</div><div class="rq-q">Can a tiered AI assistance mechanism improve the <strong>discriminative power</strong> of programming task assessment?</div></div></div>
* <div class="rq-card"><img src="./img/rq2_icon.svg" alt="RQ2 Tiered Boost"><div><div class="rq-hook"><span class="rq-tag" style="background:#1b365d;">RQ2</span> Do higher tiers rescue stuck learners?</div><div class="rq-q">What are the <strong>support effects</strong> of different AI assistance levels (L<sub>0</sub>–L<sub>4</sub>) during the problem-solving process?</div></div></div>
* <div class="rq-card accent"><img src="./img/rq3_icon.svg" alt="RQ3 AI Tax Strategy"><div><div class="rq-hook"><span class="rq-tag">RQ3</span> How do students budget their "AI Tax"?</div><div class="rq-q">What <strong>AI usage strategies and behavioral patterns</strong> emerge when support carries an explicit assessment cost?</div></div></div>
* <div class="rq-card"><img src="./img/rq4_icon.svg" alt="RQ4 LADI vs Mastery"><div><div class="rq-hook"><span class="rq-tag" style="background:#1b365d;">RQ4</span> Does mastery reduce AI dependency?</div><div class="rq-q">What is the relationship between students' <strong>AI dependency (LADI)</strong> and their conceptual learning outcomes?</div></div></div>

</div>

<!--
Analytical Scope of RQ1 through RQ4:
- RQ1 (Assessment Discrimination): Examines whether integrating assistance intensity and explicit AI Tax Rates into scoring reduces full-score concentration, strengthens alignment between programming and conceptual scores, and uncovers ability differences across student backgrounds.
- RQ2 (Hierarchical Support Effects): Investigates whether each assistance tier (L0 to L4) delivers distinct, monotonically increasing problem-solving support—measured by exact-level Accepted (AC) completion ratios without further escalation—while respecting non-spoiling feedback boundaries.
- RQ3 (Usage Strategies & Behavioral Patterns): Explores how learners trade off scaffolding depth against explicit score deductions, examining both average assistance level correlations and four-quadrant cost-outcome typologies.
- RQ4 (AI Dependency & Learning Outcomes): Evaluates the distributional properties and preliminary criterion-related validity of LADI by testing its correlation with independent conceptual understanding across departmental backgrounds (IT vs. Non-IT) and academic years (1st to 4th year).
-->

---

## 2. Related Work & Research Gap

Prior LLM-based programming tutors focus on specific support features, but remain **add-on tools** weakly integrated with formal online judging workflows.

| Study | Analyt. | Assess. | Levels | Behav. | Depend. | Platform | Reflect. | Initiative<sup>1</sup> |
| :--- | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :--- |
| CodeAid [7] | | | | ✓ | | | | Adaptive |
| CodeHelp [6] | ✓ | | | ✓ | | | | Adaptive |
| Gipy [5] | | | | ✓ | | | | Adaptive |
| CodeRunner Agent [8] | ✓ | | | | | ✓ | ✓ | Proactive |
| Owlgorithm [9] | | | | | | ✓ | ✓ | Proactive |
| **This Study (SCT)** | **✓** | **✓** | **✓** | **✓** | **✓** | **✓** | **✓** | **Proactive** |

<div class="callout">
<strong>Key Research Gap:</strong> Existing studies rarely distinguish <strong>assistance intensity</strong>, track <strong>multi-level escalation histories</strong>, or quantify how <strong>AI dependency</strong> relates to assessment discrimination.<br>
<span style="font-size: 0.88em; color: #475569;"><sup>1</sup> <strong>Initiative Roles (Yan et al. [12]):</strong> <strong>Adaptive</strong> AI responds reactively only after explicit learner requests; <strong>Proactive</strong> AI monitors learner state (e.g., stagnation, repeated errors) and initiates timely prompts or reflection.</span>
</div>

<!--
Literature Positioning (Table 1 Analysis):
- Adaptive (reactive) tutors: CodeAid [7] enforces guardrails by offering conceptual explanations, pseudocode, and line-by-line guidance rather than full code; CodeHelp [6] restricts responses to error localization and revision directions; Gipy [5] pairs LLM feedback with test-driven MOOC feedback. While these systems study help-seeking behavior, they operate as auxiliary add-ons outside formal graded OJ workflows.
- Proactive & reflective platforms: CodeRunner Agent [8] integrates course materials, execution verdicts, and learning records to scaffold self-regulated learning; Owlgorithm [9] embeds guided self-explanation and post-solution reflection in competitive programming. Both align with the Proactive role in Yan's Adaptive-Proactive-Collaborative-Partner framework [12].
- Automated grading & proactive timing caveats: Prior work notes uneven consistency in LLM-based code review (Liu et al. [2]; Estévez-Ayres et al. [15]), warns that structured design is required to preserve learner autonomy (Cao et al. [17]), and demonstrates that excessive proactive intervention reduces satisfaction and perceived autonomy (Chen et al. [10]; CodingGenie [18]).
- Research gap filled by SCT: None of the five benchmarked systems simultaneously integrates (a) multi-level assistance intensity control, (b) formal assessment discrimination via explicit usage costs, (c) escalation-path tracking, and (d) quantitative dependency modeling (LADI) inside an online judge.
-->

---

## 3.1 Five-Level Tiered AI Tutor & AI Tax Rate

Each problem begins at **L<sub>0</sub>**. Students choose when to escalate, while explicit feedback boundaries prevent direct submittable code generation.

<div class="fig-box" style="padding: 10px 12px; margin: 6px 0 8px 0;">
<img src="./img/diag2_tiered_staircase.svg" alt="Five-Level Tiered AI Tutor Staircase and AI Tax Rate" style="max-height: 350px;">
</div>

<div class="callout">
<strong>AI Tax Rate Rule:</strong> Calculated by the <strong>highest assistance level reached</strong> per problem (rather than call frequency), capturing the maximum external support mobilized and translating it into an observable assessment cost.
</div>

<!--
Formal Specification of Tiers L0 to L4 (Table 2):
- L0 (No AI Hints, 0% Tax): Default starting state for every task. Learners rely solely on the problem statement, self-testing, and standard OJ verdicts, establishing an autonomous baseline.
- L1 (Runtime Error Hints, 5% Tax): Explains compilation (CE) or runtime (RE) error messages, likely root causes, and diagnostic checking directions.
- L2 (Logic Error Hints, 10% Tax): Targets runnable code yielding Wrong Answer (WA) or Partially Accepted (PA) by offering directional debugging prompts regarding conditionals, boundary cases, data structures, and I/O handling.
- L3 (AI Tutor Q&A, 15% Tax): Multi-turn conversational chat supporting problem comprehension, conceptual clarification, and strategic discussion.
- L4 (Full AI Assistance, 20% Tax): Highest-intensity scaffolding providing process decomposition, strategy comparison, and pseudocode-level structural outlines—still bounded to prohibit directly submittable full code.
- Tax calculation rationale: Each higher tier subsumes lower-tier support. The AI Tax Rate is determined strictly by the highest level reached per problem rather than invocation frequency or average intensity, because the maximum tier best captures the peak external scaffolding mobilized while allowing learners to ask clarifying follow-up questions within a tier without incremental penalty.
-->

---

## 3.2 Proactive Learning Support & Post-Completion Consolidation

Inspired by Yan et al.'s **Proactive Assistant** role [12], SCT couples **stagnation-triggered reminders** during problem solving with **post-AC conceptual consolidation**.

<div class="fig-box" style="padding: 10px 12px; margin: 8px 0 10px 0;">
<img src="./img/diag3_proactive_loop.svg" alt="Proactive Learning Support and Post-Completion Consolidation Loop" style="max-height: 335px;">
</div>

<div class="callout">
<strong>Key Pedagogical Principle:</strong> Proactive prompts preserve <strong>learner agency</strong> (never auto-solving), while post-completion checks shift learning from <em>passing test cases</em> toward <strong>durable conceptual mastery</strong>.
</div>

<!--
Proactive Intervention & Post-AC Consolidation Mechanics:
- Theoretical grounding: Draws directly on Yan's Proactive Assistant paradigm [12], recognizing that struggling novices often stagnate silently without initiating help requests, causing reactive-only support to arrive too late.
- Stagnation detection as a cumulative process: Rather than triggering on a single compilation or test failure, SCT monitors cumulative behavioral trajectories—changes in testing and submission verdicts, repeated identical errors, consecutive failures, and stagnation duration—to minimize false alarms.
- Preserving learner agency: The proactive module functions strictly as a non-intrusive prompting mechanism ("Do you need AI assistance?") rather than an automatic feedback injector. Whether to activate AI and which tier (L1 to L4) to select remains entirely the learner's decision.
- Post-completion dual loop: Because passing test cases (AC) does not guarantee conceptual mastery, SCT leverages the student's error history and repetitive failure logs after AC to deliver (1) contextualized Concept Checks that diagnose lingering misconceptions, and (2) Reflection-Oriented Feedback prompting learners to review strategic choices and consider knowledge transfer to analogous problems.
-->

---

## 3.3 Quantifying Escalation: Escalation Profile Coefficient (EPC)

Observing only the *final level* cannot distinguish **gradual help-seeking** from **abrupt high-level reliance** (`s`: start level, `f`: final level, `m`: effective levels experienced, `λ = 0.3`).

<div class="formula-box" style="padding: 10px 18px; margin: 6px 0 10px 0; font-size: 1.15em;">
<i>EPC</i> &nbsp;=&nbsp;
<span class="frac"><span class="frac-num"><i>s</i></span><span class="frac-den">4</span></span>
&nbsp;+&nbsp; <i>λ</i> &nbsp;( 1 −
<span class="frac"><span class="frac-num"><i>m</i></span><span class="frac-den"><i>f</i> − <i>s</i> + 1</span></span>
)
</div>

<div class="fig-box" style="padding: 8px 10px;">
<img src="./img/diag4_escalation_paths.svg" alt="Three Escalation Paths Ending at L4" style="max-height: 255px;">
</div>

<div class="callout" style="margin-top: 8px; padding: 8px 14px;">
<strong>Two Behavioral Signals:</strong> <code>s / 4</code> captures <strong>initial dependency</strong>; <code>1 − m / (f − s + 1)</code> measures <strong>escalation sparsity</strong> (skipping intermediate tiers increases the dependency leap).
</div>

<!--
Mathematical Formulation of the Escalation Profile Coefficient (EPC):
- Motivation: Recording only binary AI usage or the final tier f fails to separate a learner who methodically attempts L1 -> L2 -> L3 -> L4 from one who immediately jumps to L4 without attempting lower-level self-debugging.
- Formula: EPC = (s / 4) + lambda * (1 - m / (f - s + 1)), where s in {1, 2, 3, 4} is the initial AI assistance level accessed, f in {1, 2, 3, 4} is the final (highest) level reached, m is the count of distinct effective AI levels actually experienced, and lambda = 0.3 is the sparsity weight parameter.
- First component (s / 4): Measures initial dependency—entering directly at a higher tier yields a larger baseline coefficient (e.g., s = 1 gives 0.25, whereas s = 4 gives 1.00).
- Second component (lambda * (1 - m / (f - s + 1))): Measures escalation sparsity. The denominator (f - s + 1) represents the full span of tiers between start and finish. Traversing every intermediate tier yields m = f - s + 1 (sparsity = 0, dense gradual help-seeking). Skipping intermediate tiers lowers m relative to the span, raising EPC to reflect an abrupt dependency leap.
- Worked examples ending at f = 4 (with lambda = 0.3): Gradual (L1->L2->L3->L4: s=1, m=4) gives EPC = 0.25 + 0.3*(1 - 4/4) = 0.25; Skip-step (L1->L4: s=1, m=2) gives EPC = 0.25 + 0.3*(1 - 2/4) = 0.40; Immediate jump (L4 only: s=4, m=1) gives EPC = 1.00 + 0.3*(1 - 1/1) = 1.00.
-->

---

## 3.4 Level-Anchored Dependency Index (LADI)

LADI maps multi-level AI usage onto a continuous **`[0, 10]`** scale, using final intensity `2f` as the primary band anchor and `+2 EPC` to capture within-band escalation behavior.

<div class="formula-box" style="padding: 10px 18px; margin: 6px 0 10px 0; font-size: 1.12em;">
<div class="piecewise">
<span><i>LADI</i> &nbsp;=</span>
<span class="brace">{</span>
<div class="cases">
<span>0, &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <i>f</i> = 0</span>
<span>2<i>f</i> + 2<i>EPC</i>, &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <i>f</i> ∈ {1, 2, 3, 4}</span>
</div>
</div>
</div>

<div class="fig-box" style="padding: 8px 10px; margin-bottom: 10px;">
<img src="./img/diag5_ladi_scale.svg" alt="Continuous LADI [0, 10] Scale and Band Anchors" style="max-height: 190px;">
</div>

<div class="callout" style="margin-top: 6px; padding: 8px 14px;">
<strong>Analytical Advantage:</strong> Two students both reaching <strong>L<sub>4</sub></strong> are cleanly separated by process trajectory (<code>8.50</code> gradual vs. <code>8.80</code> skip-step vs. <code>10.00</code> immediate), with <code>λ</code> tunable across course contexts.
</div>

<!--
Mathematical Formulation & Properties of LADI:
- Piecewise definition: LADI = 0 when f = 0 (autonomous completion with no AI assistance), and LADI = 2f + 2*EPC when f in {1, 2, 3, 4}.
- Bounded continuous range [0, 10]: Because f in {1, 2, 3, 4} anchors the score into primary bands (2, 4, 6, 8) and 2*EPC ranges up to 2.0 (reaching 2.0 when s = f = 4 and m = 1), LADI maps any multi-level usage trajectory onto a continuous [0, 10] scale.
- Within-band trajectory separation: Using the worked f = 4 examples (lambda = 0.3), gradual escalation yields LADI = 8 + 2(0.25) = 8.50, skip-step escalation yields LADI = 8 + 2(0.40) = 8.80, and immediate L4 reliance yields LADI = 8 + 2(1.00) = 10.00.
- Analytical advantages and calibration: Anchoring on 2f ensures that final support intensity remains the primary structural determinant of dependency, while +2*EPC captures fine-grained process differences. The hyperparameter lambda (initialized at 0.3 in this study) can be recalibrated across courses, task difficulties, or theoretical weighting assumptions to adjust the relative sensitivity to escalation sparsity.
-->

---

## 4.1 Smart Coding Tutor (SCT) System Architecture

<div class="split64">
<div class="left">

<div class="fig-box">
<img src="./img/fig1_architecture.png" alt="Fig. 1: System architecture of Smart Coding Tutor" style="max-height: 410px;">
<div class="fig-cap">Fig. 1: System architecture of Smart Coding Tutor (SCT)</div>
</div>

</div>
<div class="right small-text">

### ⚙️ Integrated Platform Modules
- **Online Judge Core**: Assignment, Editor, Judger, and Test Case Evaluator reporting standard statuses (`AC`, `PA`, `WA`, `RE`, `TLE`, `CE`).
- **Level-Based Prompt Builder**: Injects problem context, code, error output, and selected tier (L<sub>1</sub>–L<sub>4</sub>) into the AI Tutor.
- **Learning State Analyzer**: Monitors submission history, error patterns, and AI usage to drive:
  - **Proactive Hint Trigger** (stagnation alerts)
  - **Concept Question Generator** (weakness checks)

</div>
</div>

<!--
Engineering Architecture of Smart Coding Tutor (Fig. 1):
- Unified closed-loop environment: SCT consolidates problem management, code editing, automated online judging, tiered AI assistance, learning state analysis, and synchronous behavioral data logging into a single web platform, eliminating data fragmentation across external chat tools.
- Online Judge Core: Executes submitted Python code against test suites and returns six standard OJ verdicts—Accepted (AC), Partially Accepted (PA), Wrong Answer (WA), Runtime Error (RE), Time Limit Exceeded (TLE), and Compilation Error (CE). These verdicts simultaneously inform learners, gate tier-specific hints, and feed analytics.
- Level-Based Prompt Builder: Dynamically packages the problem specification, current student code, execution/error trace, and the student-selected tier (L1 to L4) into tier-constrained system prompts before querying the LLM, enforcing strict anti-solution boundaries.
- Learning State Analyzer: Continuously ingests submission trajectories, error patterns, stagnation durations, and AI tier transitions to drive two pedagogical triggers: the Proactive Hint Trigger during problem solving and the Concept Question Generator for post-AC consolidation.
-->

---

## 4.2 SCT User Interface: Tiered AI Support in Action

<div class="split55">
<div class="left">

<div class="fig-box">
<img src="./img/fig2a_L1_interface.png" alt="L1 error message hint interface" style="max-height: 350px;">
<div class="fig-cap">(a) L<sub>1</sub> Runtime / Syntax Error Hint Interface</div>
</div>

</div>
<div class="right">

<div class="fig-box">
<img src="./img/fig2b_L2_interface.png" alt="L2 logic error hint interface" style="max-height: 350px;">
<div class="fig-cap">(b) L<sub>2</sub> Logic Error Hint & Code Coverage Checklist</div>
</div>

</div>
</div>

<div class="callout" style="margin-top: 10px;">
<strong>Multi-Turn Escalation (L<sub>3</sub> & L<sub>4</sub>):</strong> Higher levels unlock a conversational AI Tutor chat supporting follow-up concept Q&A (L<sub>3</sub>) and structured solution decomposition / pseudocode guidance (L<sub>4</sub>), with full interaction logging.
</div>

<!--
Tier-Specific Interface Design (Fig. 2a & Fig. 2b):
- Controlled self-escalation: Every task initializes at L0. Students intentionally unlock higher assistance via an explicit "AI assistance level" menu, keeping both timing and intensity under learner control while logging exact timestamps and switch sequences.
- Low-tier structured diagnostics (L1 & L2): Fig. 2a illustrates the L1 Runtime/Syntax Error Hint interface, which translates compiler or runtime stack traces into accessible explanations, probable causes, and verification steps. Fig. 2b illustrates the L2 Logic Error Hint interface for WA/PA submissions, pairing directional debugging guidance with a code-coverage checklist targeting conditionals, edge cases, data usage, and I/O formatting.
- High-tier multi-turn dialogue (L3 & L4): Escalating to L3 or L4 unlocks a persistent conversational AI Tutor chat where learners ask iterative follow-up questions as their understanding evolves—focusing on conceptual/strategic clarification at L3 and workflow decomposition, strategy comparison, and pseudocode outlines at L4. All dialogue turns are logged for audit and boundary verification.
-->

---

## 5.1 Empirical Study Design & Context

<div class="fig-box" style="padding: 10px 12px; margin-bottom: 12px;">
<img src="./img/diag6_study_pipeline.svg" alt="Empirical Study Pipeline and Data Collection Protocol" style="max-height: 235px;">
</div>

<div class="two-col">
<div class="card small-text">

### 🧪 Strict Experimental Controls
- **External generative AI tools were strictly prohibited** during all three formal assessments.
- All AI interactions occurred exclusively inside **SCT**, guaranteeing complete logging of level switches, prompts, and submission outcomes.

</div>
<div class="card accent small-text">

### 📊 Core Evaluation Alignment
- **RQ1**: Raw vs. tier-adjusted scores & IT vs. Non-IT `t`-tests.
- **RQ2**: Exact-level completion ratios across L<sub>0</sub>–L<sub>4</sub>.
- **RQ3 & RQ4**: AI tax four-quadrant profiles, LADI distribution, and correlation with conceptual understanding.

</div>
</div>

<!--
Empirical Protocol & Sample Composition:
- Course context: Conducted in an introductory Python programming course at Feng Chia University, Taiwan, during the 114th academic year.
- Participants: N = 112 undergraduate students, comprising 55.36% (n = 62) with an Information Technology (IT) academic background and 44.64% (n = 50) from non-IT departments, spanning 1st-year through 4th-year cohorts.
- Practice vs. formal assessment corpus: Students completed 86 daily practice and assignment tasks on SCT throughout the term to ensure platform familiarity and longitudinal process observation. The primary statistical evaluation analyzed three formal in-class assessments, each consisting of three programming tasks (9 formal tasks total), paired with independent conceptual understanding assessments and a post-study student perception questionnaire (n = 56 respondents).
- Experimental validity control: External generative AI tools (e.g., ChatGPT, Copilot) were strictly prohibited during all three formal assessments; all AI interactions were routed exclusively through SCT, guaranteeing complete observability of tier selections, escalation paths, prompt logs, and verdicts.
-->

---

## 5.2 RQ1: Tiered AI Improves Assessment Discrimination

<div class="three-col" style="margin-bottom: 12px;">
<div class="kpi-card teal">
<div class="kpi-val">0.219 ➔ 0.324</div>
<div class="kpi-label">Programming–Conceptual correlation <code>r</code> (vs. open-AI <code>r = 0.136</code>)</div>
</div>
<div class="kpi-card accent">
<div class="kpi-val">52.7% ➔ 13.4%</div>
<div class="kpi-label">Full-score concentration sharply reduced (less ceiling effect)</div>
</div>
<div class="kpi-card">
<div class="kpi-val">3.93 / 5.0</div>
<div class="kpi-label">Student agreement (<code>n = 56</code>) that tiered mode is more discriminative</div>
</div>
</div>

| Assessment Metric (IT vs. Non-IT Group) | IT Mean | Non-IT Mean | `t(110)` | `p`-value | 95% CI |
| :--- | :---: | :---: | :---: | :---: | :---: |
| Raw Programming Score (Before Adjustment) | 81.46 | 71.63 | 1.76 | `.0818` (n.s.) | `[−1.26, 20.91]` |
| **Tier-Adjusted Score (After AI Tax)** | **73.42** | **62.25** | **2.24** | **`.0270*`** | **`[1.29, 21.05]`** |

<div class="callout">
<strong>Finding (RQ1):</strong> Incorporating AI assistance cost reduces score clustering and reveals that <strong>IT-background students scored significantly higher than non-IT students</strong> after adjustment (<code>73.42</code> vs. <code>62.25</code>, <code>p = .0270</code>), unmasking differences hidden in raw scores.
</div>

<!--
Statistical Evidence for Improved Assessment Discrimination (RQ1):
- Correlation with conceptual mastery: Under prior unrestricted AI conditions, AI usage frequency correlated weakly with conceptual understanding (r = 0.136). Within the SCT formal assessments, applying tier-based AI Tax adjustments elevated the Pearson correlation between programming implementation scores and conceptual understanding scores from r = 0.219 (raw scores) to r = 0.324 (tier-adjusted scores).
- Mitigation of ceiling effects: Full-score concentration dropped markedly from 52.7% on raw scores to 13.4% on tier-adjusted scores, restoring variance and interpretability across the upper end of the grading distribution.
- Independent-samples t-tests (IT vs. Non-IT): On raw programming scores, the mean gap between IT students (M = 81.46) and Non-IT students (M = 71.63) did not reach statistical significance, t(110) = 1.76, p = .0818, 95% CI [-1.26, 20.91]. After applying the tiered AI Tax adjustment, IT students scored significantly higher than Non-IT students (M = 73.42 vs. 62.25), t(110) = 2.244, p = .0270, 95% CI [1.29, 21.05]. Raw scores had been artificially compressed because Non-IT learners mobilized higher-intensity AI scaffolding to compensate for weaker coding foundations.
- Learner perception: In the post-study survey (n = 56), students rated agreement that the tiered mode is more discriminative than fully open AI at 3.93 / 5.0, triangulating the quantitative evidence.
-->

---

## 5.3 RQ2: Hierarchical Support Effects Across AI Levels

Completion ratio = percentage of records accessing a level that reached `AC` **at that exact level** without further upgrading.

<div style="margin: 14px 0 12px 0;">
<div class="bar-row">
<div><strong>L<sub>0</sub> (Autonomous)</strong></div>
<div class="bar-track"><div class="bar-fill teal" style="width: 81.55%;"></div></div>
<div class="bar-pct">81.55%</div>
</div>
<div class="bar-row">
<div><strong>L<sub>1</sub> (Runtime Hints)</strong></div>
<div class="bar-track"><div class="bar-fill muted" style="width: 21.05%;"></div></div>
<div class="bar-pct">21.05%</div>
</div>
<div class="bar-row">
<div><strong>L<sub>2</sub> (Logic Hints)</strong></div>
<div class="bar-track"><div class="bar-fill" style="width: 34.88%;"></div></div>
<div class="bar-pct">34.88%</div>
</div>
<div class="bar-row">
<div><strong>L<sub>3</sub> (AI Tutor Q&A)</strong></div>
<div class="bar-track"><div class="bar-fill" style="width: 43.64%;"></div></div>
<div class="bar-pct">43.64%</div>
</div>
<div class="bar-row">
<div><strong>L<sub>4</sub> (Full Guidance)</strong></div>
<div class="bar-track"><div class="bar-fill accent" style="width: 80.41%;"></div></div>
<div class="bar-pct">80.41%</div>
</div>
</div>

<div class="callout">
<strong>Finding (RQ2):</strong> 32.39% of valid records stayed at <strong>L<sub>0</sub></strong> (autonomous baseline, 81.55% <code>AC</code>). Among AI-assisted records, completion ratios rose monotonically from <strong>21.05% (L<sub>1</sub>) to 80.41% (L<sub>4</sub>)</strong>, confirming distinct hierarchical and compensatory support effects.
</div>

<!--
Hierarchical Scaffolding & Exact-Level Completion Ratios (RQ2):
- Operational metric definition: A task record is counted as "using" a given level if the student accessed that tier during problem solving, but is counted as a "completion" at that tier strictly if the student achieved Accepted (AC) without subsequently escalating to a higher level (e.g., a path L1 -> L2 -> L4 counts as usage for L1, L2, and L4, but completion solely for L4).
- Autonomous baseline (L0): Approximately 32.39% of all valid task records remained at L0 throughout solving, achieving an 81.55% AC rate. As the paper emphasizes, this high L0 completion rate does not imply AI is redundant; rather, it reflects a self-selected subgroup with sufficient baseline competence to solve tasks independently.
- Monotonic compensatory support (L1 to L4): Among records invoking AI support, exact-level completion ratios rose monotonically with intensity: 21.05% (L1), 34.88% (L2), 43.64% (L3), and 80.41% (L4). Lower tiers resolve localized syntax or logic hurdles for a subset of learners without giving away solutions, whereas L4 delivers substantial compensatory scaffolding for deeply stuck students.
- Guardrail fidelity: Manual sampling of logged AI tutor interactions verified that LLM outputs adhered closely to their intended level boundaries—confining lower tiers to error explanation and conceptual hints while reserving structured decomposition for higher tiers.
-->

---

## 5.4 RQ3: Usage Strategies & Four-Quadrant Analysis

<div class="split55">
<div class="left">

<div class="fig-box">
<img src="./img/fig3_ai_tax_quadrant.png" alt="Fig. 3: Relationship between AI tax rate and learning outcomes" style="max-height: 430px;">
<div class="fig-cap">Fig. 3: Four-quadrant analysis (medians: Tax = 0.125, Score = 80)</div>
</div>

</div>
<div class="right small-text">

### 🎯 Differentiated Trade-Off Patterns
- Average AI level negatively correlates with conceptual understanding (**`r = −0.368`**) ➔ usage reflects learning needs, not random clicks.
- **AI-Boosted High Performers (30.36%)**: High tax, high output — leverage deep AI guidance effectively.
- **High-Efficiency Users (25.00%)**: Low tax, high output — strong independent mastery.
- **Low Investment, Low Return (25.89%)**: Low tax, low output — under-utilization or delayed escalation.
- **AI Tax-Burdened Users (18.75%)**: High tax, low output — struggle to translate AI hints into working code.

</div>
</div>

<!--
Differentiated AI Usage Strategies & Four-Quadrant Typology (RQ3):
- Need-driven intensity selection: Students' average AI assistance level exhibited a moderate negative correlation with conceptual understanding scores (r = -0.368). Learners with stronger conceptual grasp relied on lower tiers, whereas conceptually weaker learners escalated to higher tiers, confirming that tier selection reflected genuine instructional need rather than random exploration or uniform overreliance.
- Four-quadrant segmentation (Fig. 3): Splitting the 112 students at the sample medians—AI Tax Rate = 0.125 and Programming Implementation Score = 80—yielded four behavioral profiles:
  1. High-Tax, High-Output (AI-Boosted High Performers, 30.36%): Effectively converted high-intensity AI guidance into high task performance.
  2. Low-Tax, High-Output (High-Efficiency Users, 25.00%): Achieved strong programming outcomes autonomously or with minimal hints. Together, these two high-output groups exceeded half (55.36%) of the cohort.
  3. Low-Tax, Low-Output (Low Investment, Low Return, 25.89%): Paid low AI tax yet achieved poor scores, indicating under-utilization of available scaffolding or delayed escalation when stuck.
  4. High-Tax, Low-Output (AI Tax-Burdened Users, 18.75%): Mobilized intensive AI guidance but struggled to translate explanations or pseudocode into working Python implementations, signaling acute foundational deficits.
-->

---

## 5.5 RQ4: Stratified (Bimodal) Distribution of LADI

Rather than clustering around moderate dependency, students clearly **stratified into low-dependency and high-dependency groups**.

<div style="margin: 16px 0 14px 0;">
<div class="bar-row">
<div><strong>[0, 2) Low</strong></div>
<div class="bar-track"><div class="bar-fill teal" style="width: 32.39%;"></div></div>
<div class="bar-pct">32.39%</div>
</div>
<div class="bar-row">
<div><strong>[2, 4) Mild</strong></div>
<div class="bar-track"><div class="bar-fill muted" style="width: 3.46%;"></div></div>
<div class="bar-pct">3.46%</div>
</div>
<div class="bar-row">
<div><strong>[4, 6) Moderate</strong></div>
<div class="bar-track"><div class="bar-fill muted" style="width: 5.97%;"></div></div>
<div class="bar-pct">5.97%</div>
</div>
<div class="bar-row">
<div><strong>[6, 8) Elevated</strong></div>
<div class="bar-track"><div class="bar-fill" style="width: 11.64%;"></div></div>
<div class="bar-pct">11.64%</div>
</div>
<div class="bar-row">
<div><strong>[8, 10] High</strong></div>
<div class="bar-track"><div class="bar-fill accent" style="width: 46.54%;"></div></div>
<div class="bar-pct">46.54%</div>
</div>
</div>

<div class="callout">
<strong>Key Observation:</strong> Nearly <strong>79%</strong> of student records fall in the two extremes — <strong>32.39%</strong> in <code>[0, 2)</code> and <strong>46.54%</strong> in <code>[8, 10]</code> — highlighting polarized needs for external scaffolding under formal assessment pressure.
</div>

<!--
Bimodal Stratification of LADI Across Task Records (RQ4):
- Distributional breakdown across the [0, 10] LADI scale:
  - [0, 2) Low dependency: 32.39%
  - [2, 4) Mild dependency: 3.46%
  - [4, 6) Moderate dependency: 5.97%
  - [6, 8) Elevated dependency: 11.64%
  - [8, 10] High dependency: 46.54%
- Structural interpretation: Nearly 79% (78.93%) of all valid records clustered in the two extreme intervals—[0, 2) and [8, 10]—while the three intermediate bands combined accounted for only 21.07%.
- Behavioral mechanism: Rather than forming a unimodal distribution around moderate scaffolding, learners under formal graded assessment pressure polarized into two distinct regimes: those able to execute tasks autonomously (staying at L0) and those who, once encountering an impasse that lower-tier hints (L1/L2) did not immediately resolve, escalated all the way to L4 structured guidance to secure task completion.
-->

---

## 5.6 RQ4: LADI vs. Conceptual Understanding Performance

<div class="split55">
<div class="left">

<div class="fig-box">
<img src="./img/fig4_ladi_scatter.png" alt="Fig. 4: Scatter plot of conceptual understanding performance and LADI" style="max-height: 420px;">
<div class="fig-cap">Fig. 4: Conceptual score vs. LADI by departmental background</div>
</div>

</div>
<div class="right small-text">

### 📉 Criterion-Related Evidence for LADI
- **Overall Correlation**: Moderate negative correlation (**`r = −0.383`**) — stronger conceptual understanding aligns with lower AI dependency.
- **By Background**:
  - **IT Majors**: **`r = −0.509`** (clear decline in reliance as concepts strengthen).
  - **Non-IT Majors**: **`r = −0.187`** (still rely on AI for syntax & implementation scaffolding).
- **By Academic Year**:
  - 4th-year: **`r = −0.779`** | 3rd-year: `r = −0.353`
  - 2nd-year: `r = −0.350` | 1st-year: `r = +0.150`

</div>
</div>

<!--
Criterion-Related Validity & Subgroup Moderation of LADI (RQ4, Fig. 4):
- Overall association: LADI exhibited a moderate negative correlation with conceptual understanding performance (r = -0.383), slightly stronger than simple average AI level (r = -0.368), supporting LADI's sensitivity to both final tier and escalation trajectory.
- Departmental background moderation: IT-background students demonstrated a pronounced negative correlation (r = -0.509), indicating that stronger conceptual mastery directly translated into lower AI reliance. Non-IT students showed a much weaker negative correlation (r = -0.187), reflecting persistent implementation barriers—such as lower syntax familiarity, limited debugging fluency, and unstable problem-solving routines—that sustain AI dependence even when conceptual scores improve.
- Academic year progression: Negative correlations strengthened systematically with academic seniority: 4th-year (r = -0.779), 3rd-year (r = -0.353), and 2nd-year (r = -0.350), whereas 1st-year students exhibited a weak positive correlation (r = +0.150). Prior programming exposure and accumulated self-regulation experience appear to moderate how effectively learners convert conceptual knowledge into independent coding.
- Methodological caveat: Because the analysis is cross-sectional and correlational, it cannot establish causal direction (i.e., whether weak mastery causes dependency or dependency impedes mastery); results represent preliminary criterion-related validity evidence for LADI.
-->

---

## 5.7 Discussion & Pedagogical Implications

<div class="two-col">
<div class="card small-text">

### 🏫 Instructional & Assessment Insights
- **Restoring Fairness Without Bans**: Linking tiered AI support to explicit AI tax rates preserves student access to scaffolding while keeping scores interpretable.
- **Tailoring Support for Non-IT Novices**: Lower correlation (`r = −0.187`) among non-IT students suggests conceptual gains alone do not eliminate syntax/debugging barriers.
- **Early Risk Identification**: Four-quadrant profiles help instructors spot *Tax-Burdened* (18.75%) and *Under-Utilizing* (25.89%) students early.

</div>
<div class="card accent small-text">

### 🔬 Methodological Reflections & Limits
- **Correlational, Not Causal**: LADI shows preliminary criterion-related validity (`r = −0.383`), but cannot yet establish causal direction between dependency and mastery.
- **Proactive Timing Gap**: Student satisfaction with proactive prompt timing averaged only **`2.96 / 5.0`**, indicating stagnation thresholds and trigger frequency need calibration.
- **Single-Course Context**: Generalizability of `λ = 0.3` and tier tax weights requires cross-course validation.

</div>
</div>

<!--
Pedagogical Takeaways & Methodological Boundaries:
- Assessment equity without prohibition: Coupling tiered LLM scaffolding with explicit, transparent AI Tax Rates enables instructors to maintain supportive debugging access while mitigating score compression and preserving grading interpretability.
- Diagnostic targeting via four-quadrant & subgroup analytics: Instructors can deploy quadrant membership as an early-warning dashboard—coaching Low-Tax, Low-Output learners (25.89%) on timely help-seeking while providing foundational coding remediation to High-Tax, Low-Output learners (18.75%) and syntax-fluency drills for Non-IT novices (r = -0.187).
- Proactive timing limitation: In the post-study questionnaire, average student satisfaction with proactive prompt timing was only 2.96 / 5.0. Consistent with Chen et al. [10], poorly calibrated stagnation thresholds or prompt frequency can feel intrusive or misaligned with learners' cognitive state, warranting adaptive threshold tuning.
- Generalizability constraints: Findings derive from a single introductory Python course (N = 112) with fixed hyperparameter settings (lambda = 0.3; linear 5% tax increments per tier). Cross-course, multi-language, and longitudinal validation is required before generalizing parameter values.
-->

---

## 6. Conclusion & Future Work

<div class="fig-box" style="padding: 8px 10px; margin-bottom: 8px;">
<img src="./img/diag7_rq_conclusions.svg" alt="Visual Synthesis of RQ1-RQ4 Conclusions" style="max-height: 360px;">
</div>

<div class="future-strip">
<div class="future-pill"><strong>🚀 1. Longitudinal & Cross-Course</strong><br>Validate LADI stability and long-term independent coding transfer across semesters.</div>
<div class="future-pill"><strong>🔔 2. Smarter Proactive Timing</strong><br>Refine stagnation thresholds & trigger frequency to lift satisfaction above <code>2.96 / 5.0</code>.</div>
<div class="future-pill"><strong>🎛️ 3. Parameter Calibration</strong><br>Empirically tune <code>λ</code> and AI tax schedules across task difficulties & languages.</div>
</div>

<!--
Synthesis of Findings & Research Roadmap:
- Empirical synthesis across RQ1 to RQ4:
  - RQ1: Tiered AI Tax scoring reduced full-score clustering (52.7% to 13.4%), lifted programming-conceptual alignment (r = 0.219 to 0.324), and revealed significant IT vs. Non-IT differences (p = .0270).
  - RQ2: Exact-level AC rates rose monotonically from L1 (21.05%) to L4 (80.41%), confirming hierarchical compensatory scaffolding alongside a 32.39% L0 autonomous cohort (81.55% AC).
  - RQ3: Four-quadrant cost-outcome profiling exposed heterogeneous trade-off strategies driven by genuine learning needs (r = -0.368).
  - RQ4: LADI revealed bimodal polarization (78.93% in extreme bands) and moderate negative alignment with conceptual mastery (r = -0.383; IT r = -0.509; 4th-year r = -0.779).
- Future research agenda: (1) Cross-course and longitudinal studies to test LADI stability, causal dynamics, and long-term independent coding transfer; (2) refined stagnation-detection models and adaptive trigger pacing to lift proactive timing satisfaction beyond 2.96 / 5.0; and (3) empirical calibration of the escalation weight lambda and AI tax schedules across programming languages and task difficulties.
-->

---

<!-- _class: closing -->

# Thank You for Your Attention!

<p style="font-size: 1.05em; max-width: 820px;">
Application and Analysis of a Tiered LLM-Based Programming Assistance Mechanism in Programming Learning
</p>

<div class="contact-card">
<strong>Nien-Lin Hsueh<sup>+</sup></strong> &nbsp;·&nbsp; <code>nlhsueh@fcu.edu.tw</code><br>
<strong>Ying-Chang Lu</strong> &nbsp;·&nbsp; <code>m1305878@o365.fcu.edu.tw</code><br>
Department of Information Engineering and Computer Science, Feng Chia University<br>
<span style="font-size: 0.85em; opacity: 0.85;">Grant: NSTC114-2221-E-035-077 · Questions & Discussion Welcome!</span>
</div>

<!--
Publication & Attribution Summary:
- Full Citation: Nien-Lin Hsueh and Ying-Chang Lu, "Application and Analysis of a Tiered LLM-Based Programming Assistance Mechanism in Programming Learning," Journal of Information Science and Engineering (JISE), Department of Information Engineering and Computer Science, Feng Chia University, Taichung 407, Taiwan.
- Funding Acknowledgment: Supported by the National Science and Technology Council (NSTC), Taiwan R.O.C., under grant NSTC114-2221-E-035-077.
- Core Research Thesis: The central question for AI in programming education is not a binary choice between prohibition and unrestricted access, but rather how assistance boundaries, explicit institutional costs (AI Tax), and trajectory-aware analytics (LADI) can be co-designed to scaffold task completion while preserving the interpretive validity of formal assessment.
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
