---
marp: true
theme: gaia
size: 16:9
paginate: true
html: true
header: '<div class="hdr-wrap"><span class="hdr-title">Tiered LLM Assistance in Programming Learning</span><div class="nav-dropdown"><button class="nav-btn">Sections ▾</button><div class="nav-menu"><a href="#2">Opening Hook: AI Tax</a><a href="#3">Outline</a><a href="#4">1. Introduction & RQs</a><a href="#6">2. Related Work</a><a href="#7">3. Methodology & LADI</a><a href="#11">4. SCT System</a><a href="#13">5. Empirical Results</a><a href="#20">6. Conclusion & Future Work</a></div></div></div>'
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
Key Takeaway: We transform LLM programming assistance from an unregulated external aid into a tiered, measurable, and pedagogically sound assessment mechanism.

Talking Points:
- Good morning everyone. Today we present Smart Coding Tutor (SCT), our work from Feng Chia University on integrating tiered LLM assistance directly into formal programming assessments.
- Rather than banning AI or leaving it completely unrestricted, our goal is to make AI usage controllable, recordable, and analytically interpretable.
- This research is supported by Taiwan's National Science and Technology Council (NSTC).

Transition: Let's start with a quick thought experiment that captures the core idea behind our system.
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
Key Takeaway: Applying an explicit "AI Tax" (0% to 20%) lets students keep access to scaffolding while preserving fair and transparent grading.

Talking Points:
- Imagine a programming exam as a highway: completely banning AI closes the road, while unrestricted AI lets everyone speed to a full score without revealing who actually knows how to drive.
- Our solution is to put a tollbooth on the AI Express Lane — students can request progressively stronger hints when stuck, but each tier carries an explicit 0% to 20% score adjustment.
- This turns hidden AI reliance into a visible, fair, and interpretable trade-off.

Transition: Here is the roadmap for how we designed, built, and evaluated this mechanism.
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
Key Takeaway: We cover the assessment dilemma, our five-level AI Tax and LADI methodology, the SCT platform, and empirical findings from 112 students.

Talking Points:
- We begin with the motivation, four research questions, and how SCT fills gaps in prior LLM tutor literature.
- Next, we introduce our five-level tiered tutor, proactive support loop, and two new behavioral metrics: EPC and LADI.
- Finally, we walk through the SCT system architecture and empirical results across 112 Python students and 9 formal assessment tasks.

Transition: Let's dive into why open AI use creates an assessment dilemma in programming education.
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
Key Takeaway: Open AI collapses score discrimination via ceiling effects, whereas tiered AI preserves scaffolding while restoring score interpretability.

Talking Points:
- As illustrated in the diagram, when students have unrestricted access to external LLMs, both novices and experts can submit working code, masking true conceptual mastery.
- Conversely, a strict ban removes valuable learning support and is increasingly unrealistic in modern software education.
- Our philosophy is not to prohibit AI, but to bring it inside the assessment platform as a tiered, logged instructional intervention.

Transition: Guided by this philosophy, we formulated four concrete research questions.
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
Key Takeaway: Our study evaluates four pillars: assessment discrimination (RQ1), tiered support effectiveness (RQ2), student budgeting strategies (RQ3), and AI dependency versus mastery (RQ4).

Talking Points:
- RQ1 asks whether attaching an explicit AI tax restores discriminative power and unmasks differences hidden by full-score clustering.
- RQ2 examines whether escalating from L0 through L4 genuinely rescues stuck learners at each step.
- RQ3 and RQ4 investigate how students strategically budget their AI tax and whether our dependency index (LADI) correlates with conceptual understanding.

Transition: Before detailing our design, let's see where SCT stands relative to existing LLM programming tutors.
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
Key Takeaway: Existing LLM tutors act as add-on aids and lack multi-level intensity control, dependency quantification, and formal assessment integration.

Talking Points:
- Tools like CodeAid, CodeHelp, and Gipy provide helpful adaptive feedback, while CodeRunner Agent and Owlgorithm introduce proactive reflection inside platforms.
- However, none of these systems simultaneously combine intensity-tiered scaffolding, escalation tracking, dependency quantification, and formal online-judge grading.
- SCT bridges all eight dimensions under a proactive assistant paradigm inspired by Yan et al.'s framework.

Transition: Now let's look closely at how SCT structures its five assistance levels and the AI Tax rule.
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
Key Takeaway: Students start every problem autonomously at L0 and may escalate up to L4, paying an AI Tax determined by their highest tier reached.

Talking Points:
- Every task begins at L0 with zero deduction. As students encounter barriers, they can voluntarily unlock L1 syntax/runtime hints, L2 logic hints, L3 conversational AI Tutor Q&A, or L4 full solution decomposition.
- Strict prompt boundaries across all tiers prevent the LLM from outputting directly submittable code.
- Crucially, the AI Tax (0% to 20%) is based on the highest tier reached rather than click frequency, encouraging thoughtful help-seeking without penalizing follow-up questions.

Transition: Beyond reactive tier escalation, SCT also monitors learner stagnation proactively.
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
Key Takeaway: SCT pairs stagnation-triggered proactive reminders during coding with post-AC conceptual checks to turn passing tests into lasting mastery.

Talking Points:
- While students code, SCT monitors idle time and repeated errors; when stagnation is detected, it nudges the learner with an optional reminder rather than auto-solving the task.
- Once a student achieves Accepted (AC), SCT does not stop there — it triggers targeted concept questions and reflection checks based on their error history.
- This closed loop preserves learner agency while ensuring students actually understand the code they submitted.

Transition: Next, how do we quantify not just the final tier a student reached, but the path they took to get there?
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
Key Takeaway: The Escalation Profile Coefficient (EPC) distinguishes gradual help-seeking from abrupt jumping to high-intensity AI support.

Talking Points:
- Look at the three paths in the figure: all three students end at L4, yet their behaviors are completely different.
- EPC combines two signals: s / 4 captures initial dependency (starting directly at a high tier), while lambda times (1 minus m / (f minus s + 1)) measures escalation sparsity — skipping intermediate tiers increases the score.
- With lambda set to 0.3, a gradual climber gets a much lower EPC than someone who immediately jumps to L4.

Transition: We then anchor EPC onto a continuous 0-to-10 scale to form our primary dependency metric, LADI.
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
Key Takeaway: LADI maps tiered AI usage onto a continuous [0, 10] scale by anchoring on final intensity (2f) and refining within each band using +2 EPC.

Talking Points:
- Autonomous L0 records receive a LADI of 0, while AI-assisted records are placed into distinct bands via 2f plus 2 EPC.
- As the scale shows, three students who all finish at L4 are cleanly separated: 8.50 for gradual escalation, 8.80 for skip-step escalation, and 10.00 for jumping straight to L4.
- This gives instructors and researchers a fine-grained, continuous indicator of AI reliance that can be tuned across courses via lambda.

Transition: Let's see how these pedagogical mechanisms are engineered inside the SCT platform.
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
Key Takeaway: SCT tightly integrates an Online Judge core, a Level-Based Prompt Builder, and a Learning State Analyzer in one unified platform.

Talking Points:
- On the left, the Online Judge core handles assignments, editing, execution, and standard verdicts (AC, PA, WA, RE, TLE, CE).
- When a student requests help, the Level-Based Prompt Builder packages the problem statement, current code, error logs, and chosen tier (L1 to L4) to enforce strict scaffolding boundaries.
- Meanwhile, the Learning State Analyzer continuously tracks submissions and errors to drive both the Proactive Hint Trigger and the Concept Question Generator.

Transition: Let's take a quick look at what this looks like from the student's perspective.
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
Key Takeaway: Lower tiers (L1 and L2) deliver structured diagnostic hints and coverage checklists, while higher tiers (L3 and L4) unlock multi-turn conversational guidance.

Talking Points:
- On the left, the L1 interface focuses purely on interpreting syntax and runtime errors so novices learn to read stack traces.
- On the right, the L2 interface guides logic debugging with a code-coverage checklist without revealing the fix.
- When students escalate to L3 or L4, they enter a multi-turn AI Tutor chat for conceptual Q&A or pseudocode structuring, with every interaction logged automatically.

Transition: With the system in place, let's examine our empirical study design and classroom protocol.
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
Key Takeaway: We evaluated SCT with 112 Python students across 3 formal assessments (9 tasks) under strict controls prohibiting external AI tools.

Talking Points:
- All three formal assessments were conducted in-class with external generative AI tools strictly prohibited, ensuring 100% of AI interactions occurred inside SCT.
- This gave us complete behavioral logs of level switches, prompts, and submission verdicts alongside independent conceptual understanding scores.
- Each dataset directly maps to our four research questions, from score discrimination to four-quadrant behavioral profiling and LADI validation.

Transition: Let's walk through the empirical findings, starting with RQ1 on assessment discrimination.
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
Key Takeaway: Applying the AI Tax cuts full-score clustering from 52.7% to 13.4% and reveals a statistically significant gap between IT and Non-IT students.

Talking Points:
- Look at the top KPIs: the correlation between programming and conceptual scores rises from 0.219 to 0.324 — far higher than the 0.136 observed under open AI — while full-score concentration drops sharply from 52.7% to 13.4%.
- In the table, raw scores show no significant gap between IT and Non-IT students (p = .0818), but after applying the AI Tax, IT majors score significantly higher (73.42 vs. 62.25, p = .0270).
- Students themselves also recognized this fairness, rating discriminative power at 3.93 out of 5.0.

Transition: Next, let's check RQ2 — do higher tiers actually help stuck students reach Accepted?
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
Key Takeaway: Among AI-assisted records, exact-level completion ratios rise monotonically from 21.05% at L1 to 80.41% at L4, confirming hierarchical scaffolding.

Talking Points:
- First, 32.39% of all valid records stayed completely autonomous at L0 and achieved an 81.55% AC rate, establishing a strong independent baseline.
- For students who needed help, completion at the exact tier accessed climbed steadily: 21.05% at L1, 34.88% at L2, 43.64% at L3, and 80.41% at L4.
- This monotonic progression confirms that each tier provides distinct, compensatory support without immediately giving away answers at lower levels.

Transition: Knowing that higher tiers work, how do students balance the AI Tax against their target score in RQ3?
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
Key Takeaway: Four-quadrant profiling reveals distinct student budgeting strategies, with AI usage reflecting genuine learning needs (r = -0.368) rather than random clicking.

Talking Points:
- Splitting students at the medians (AI Tax = 0.125, Score = 80) yields four actionable profiles.
- Two groups perform strongly: AI-Boosted High Performers (30.36%) effectively convert deep guidance into high scores, while High-Efficiency Users (25.00%) succeed independently at low tax.
- Crucially, the bottom quadrants flag at-risk learners: 25.89% under-utilize available hints (Low Investment, Low Return), and 18.75% pay high tax yet still struggle to translate hints into working code.

Transition: Turning to RQ4, what does the overall distribution of our LADI dependency index look like?
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
Key Takeaway: Student AI dependency is sharply bimodal — nearly 79% of records fall into either the low-dependency [0, 2) or high-dependency [8, 10] extremes.

Talking Points:
- Rather than forming a bell curve around moderate dependency, student records split into two clear poles: 32.39% in [0, 2) and 46.54% in [8, 10].
- Middle bands ([2, 4), [4, 6), and [6, 8)) account for only about 21% combined.
- This polarization shows that under formal assessment pressure, learners either solve tasks independently or escalate all the way to structured guidance once stuck.

Transition: Finally, does higher conceptual mastery actually correspond to lower LADI scores?
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
Key Takeaway: LADI negatively correlates with conceptual understanding overall (r = -0.383), with a much stronger link for IT majors (r = -0.509) and senior students (r = -0.779).

Talking Points:
- The scatter plot provides preliminary criterion-related validity for LADI: overall, students with stronger conceptual understanding exhibit lower AI dependency (r = -0.383).
- Breaking this down by background reveals a striking contrast: IT majors show a strong negative correlation (r = -0.509), whereas Non-IT majors show only r = -0.187 because syntax and debugging hurdles persist even when concepts improve.
- Similarly, the negative relationship strengthens steadily across academic years, peaking at r = -0.779 among fourth-year students.

Transition: Let's synthesize what these findings mean for classroom teaching and acknowledge key limitations.
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
Key Takeaway: Tiered AI with explicit costs restores fairness without bans and enables early risk detection, though proactive timing and causality need further work.

Talking Points:
- Pedagogically, SCT lets instructors keep AI accessible while using four-quadrant profiles to intervene early for Tax-Burdened (18.75%) and Under-Utilizing (25.89%) students, and to offer targeted syntax coaching for Non-IT novices.
- Methodologically, our LADI correlation is not yet causal, and student satisfaction with proactive prompt timing averaged only 2.96 out of 5.0, signaling that stagnation thresholds need calibration.
- We also note that lambda = 0.3 and our tax schedule were validated in a single course and warrant cross-course testing.

Transition: Let's wrap up with a visual summary of our conclusions and our roadmap ahead.
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
Key Takeaway: Across RQ1 to RQ4, SCT proves that tiered AI scaffolding and LADI can balance learning support with assessment integrity, setting up three clear next steps.

Talking Points:
- The diagram synthesizes all four findings: restored score discrimination (RQ1), monotonic tiered rescue (RQ2), actionable four-quadrant strategies (RQ3), and a bimodal, mastery-linked LADI index (RQ4).
- Moving forward, we will run longitudinal cross-course studies to test independent coding transfer, refine proactive stagnation triggers to lift satisfaction above 2.96, and empirically calibrate lambda and tax rates across languages.

Transition: Thank you for listening — we look forward to your questions and feedback.
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
Key Takeaway: Thank the audience and invite questions on tiered AI scaffolding, AI Tax calibration, or LADI analytics.

Talking Points:
- Thank you very much for your attention.
- Please feel free to reach out to us at Feng Chia University via the emails shown here, and we welcome any questions or discussion on SCT, AI Tax design, or LADI.

Transition: Open the floor for Q&A.
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
