---
marp: true
theme: gaia
size: 16:9
paginate: true
html: true
header: '<div class="hdr-wrap"><span class="hdr-title">AI Tutor Triad Pattern: Structuring Conversational Guidance in Programming Education</span><div class="hdr-actions"><a class="lang-btn" href="./Pattern26_slide_zh.html" title="切換至繁體中文簡報">🌐 繁</a><div class="nav-dropdown"><button class="nav-btn">Sections ▾</button><div class="nav-menu"><a href="#2">Opening Hook: Full Code vs. Triad</a><a href="#3">Outline</a><a href="#4">1. Introduction & RQs</a><a href="#6">2. Related Work</a><a href="#7">3. SCT & AT-TPL Design</a><a href="#14">4. Empirical Study</a><a href="#18">5. Discussion & Trade-Offs</a><a href="#19">6. Conclusion & Future Work</a></div></div></div></div>'
footer: 'Nien-Lin Hsueh, Lien-Chi Lai & Ying-Chang Lu · Feng Chia University · JISE 2026'
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
  font-size: 1.24em;
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
  font-size: 1.98em;
  font-weight: 800;
  line-height: 1.24;
  margin-bottom: 16px;
  text-align: left;
}

section.lead .subtitle {
  color: #cbd5e1;
  font-size: 0.94em;
  line-height: 1.5;
  margin-bottom: 26px;
  max-width: 960px;
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

.kpi-val { font-size: 1.38em; font-weight: 800; color: var(--navy); line-height: 1.15; margin-bottom: 3px; }
.kpi-card.accent .kpi-val { color: var(--accent); }
.kpi-card.teal .kpi-val { color: var(--teal); }
.kpi-label { font-size: 0.76em; color: var(--slate-700); line-height: 1.34; }

.callout {
  background: #f8fafc;
  border-left: 4px solid var(--accent);
  border-radius: 0 8px 8px 0;
  padding: 9px 15px;
  margin-top: 9px;
  font-size: 0.85em;
  color: var(--slate-700);
}

.callout.teal { border-left-color: var(--teal); background: var(--teal-soft); }
.callout strong { color: var(--navy); }

/* Tables */
table {
  width: 100%;
  border-collapse: collapse;
  font-size: 0.73em;
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
  grid-template-columns: 180px 1fr 78px;
  align-items: center;
  gap: 10px;
  margin-bottom: 8px;
  font-size: 0.79em;
}

.bar-track {
  background: var(--slate-100);
  border-radius: 5px;
  height: 19px;
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

<div class="badge">Journal of Information Science and Engineering (JISE) · 2026</div>

# AI Tutor Triad Pattern: Structuring Conversational Guidance in Programming Education

<div class="subtitle">
<strong>AT-TPL</strong> (AI Tutor Triad Pattern Language): Decomposing LLM Programming Assistance into Specialized <strong>Guidance</strong>, <strong>Debugging</strong>, and <strong>Optimization</strong> Patterns via RACE Prompts in Smart Coding Tutor
</div>

<div class="meta-box">
<strong>Nien-Lin Hsueh<sup>+</sup></strong>, <strong>Lien-Chi Lai</strong>, and <strong>Ying-Chang Lu</strong><br>
Department of Information Engineering and Computer Science, Feng Chia University, Taichung, Taiwan<br>
<code>nlhsueh@fcu.edu.tw</code> · <code>p1000433@o365.fcu.edu.tw</code> · <code>m1305878@o365.fcu.edu.tw</code>
</div>

<div class="grant">
Supported by the National Science and Technology Council (NSTC), Taiwan R.O.C., under grant NSTC 114-2221-E-035-077.
</div>

<!--
Bibliographic & Research Overview:
This paper (Hsueh, Lai, & Lu, Department of Information Engineering and Computer Science, Feng Chia University, Taichung, Taiwan; JISE 2026, supported by NSTC grant 114-2221-E-035-077) introduces the AI Tutor Triad Pattern Language (AT-TPL) for introductory programming education.

Core Thesis:
Rather than exposing students to an unconstrained, general-purpose Large Language Model (LLM) chat interface, AT-TPL decomposes recurring programming help-seeking situations into three specialized, interconnected pedagogical patterns: Guidance (problem understanding and initial planning), Debugging (error diagnosis and targeted repair), and Optimization (post-correctness reflection on readability, efficiency, and idiomatic practices).

Empirical Scope:
Each pattern is formally documented using the classic pattern-language schema (intent, motivation, context, problem, forces, solution, consequences, and related patterns), operationalized in the Smart Coding Tutor (SCT) online judge via the RACE prompt framework, and observed across an authentic Fall 2024 university Python course (315 students, 86 exercises, 4,982 total attempts, 1,315 tutor-assisted attempts).
-->

---

## Opening Hook: "Here's the Full Answer!" ... Wait, What Did You Learn?

<div class="fig-box" style="padding: 6px; margin-bottom: 10px; background: #fbf9f2;">
<img src="./img/pattern26_hook.jpg" alt="General-Purpose LLM vs AI Tutor Triad Pattern" style="max-height: 415px; border-radius: 6px;">
</div>

<div class="callout" style="margin-top: 6px; padding: 9px 16px;">
<strong>The Core Idea:</strong> A general-purpose LLM dumps copy-paste solutions that bypass student thinking. <strong>AT-TPL</strong> replaces one generic chat with a <strong>triad of specialized AI tutor patterns</strong> — <strong>Guidey</strong>, <strong>Debuggy</strong>, and <strong>Opti</strong> — calibrated to each stage of programming work.
</div>

<!--
Pedagogical Problem Framing:
General-purpose LLMs can immediately produce explanations, debugging advice, and complete executable programs [1, 2, 3], yet this responsiveness frequently undermines learning. As Hellas et al. [14] and Prather et al. [4] observe, unconstrained models often supply full solutions that were never requested or lack calibration to the learner's current task state.

Why Decomposing into a Triad Matters:
Novice programmers must simultaneously translate problem statements into abstract logical structures, master syntax, interpret diagnostics, and develop problem-solving strategies. When executable code is handed over immediately, students lose the cognitive work of interpreting input/output specifications, designing algorithms, and tracing faults. AT-TPL addresses this by replacing a single monolithic chat persona with three state-aligned tutor patterns: Guidey (initial planning without executable code), Debuggy (root-cause diagnosis anchored in tracebacks without full replacement code), and Opti (post-acceptance code quality review without full rewrites).
-->

---

## Presentation Outline

<div class="outline-grid">

<div class="outline-item">
<div class="outline-num">1</div>
<div class="outline-body">

[**Introduction & Research Questions**](#4)
Why general-purpose LLMs undermine scaffolding and our three core RQs.

</div>
</div>

<div class="outline-item">
<div class="outline-num">2</div>
<div class="outline-body">

[**Related Work & Comparison**](#6)
Comparing CodeHelp, CS50 tools, CodeAid, and Iris against AT-TPL (Table 1).

</div>
</div>

<div class="outline-item">
<div class="outline-num">3</div>
<div class="outline-body">

[**SCT & AT-TPL Pattern Language**](#7)
System design, shared forces, non-linear transitions, RACE prompts, and all 3 patterns.

</div>
</div>

<div class="outline-item">
<div class="outline-num">4</div>
<div class="outline-body">

[**Empirical Course Deployment**](#14)
315 students, 86 Python exercises, 1,315 tutor-assisted attempts, error & AC analysis.

</div>
</div>

<div class="outline-item">
<div class="outline-num">5</div>
<div class="outline-body">

[**Discussion & Pedagogical Trade-Offs**](#18)
Specificity vs. cognitive offloading, state gating, and proficiency effects.

</div>
</div>

<div class="outline-item">
<div class="outline-num">6</div>
<div class="outline-body">

[**Conclusion & Future Work**](#19)
Visual synthesis of RQ1–RQ3 conclusions and 3-pillar research roadmap.

</div>
</div>

</div>

<!--
Paper Organization & Analytical Progression:
Section 1 (Introduction) motivates why unconstrained LLMs conflict with scaffolding and productive failure, and frames the study's observational design: documenting what help students seek and how LLMs can be structured before conducting controlled causal comparisons.
Section 2 (Related Work) synthesizes literature on LLM code generation, prompt engineering, pattern languages, and four guardrail-based AI tutors (CodeHelp, CS50 tools, CodeAid, and Iris).
Section 3 (Smart Coding Tutor & AT-TPL) details the SCT online judge architecture, the RACE prompt framework, shared forces, state-driven pattern transitions, and full specifications for Guidey, Debuggy, and Opti.
Section 4 (Empirical Study) reports usage distributions, state-alignment vs. state-mismatch findings, error-frequency disparities, acceptance outcomes, and course-level historical context.
Section 5 (Discussion & Conclusion) examines recurring pedagogical trade-offs (specificity vs. cognitive offloading, state gating vs. autonomy, proficiency differences) and outlines three future research directions.
-->

---

## 1.1 Motivation: Why General-Purpose LLM Tutors Fall Short

<div class="fig-box" style="padding: 10px 12px; margin-bottom: 10px;">
<img src="./img/diag1_motivation.svg" alt="General-Purpose LLM vs AI Tutor Triad Pattern Language" style="max-height: 365px;">
</div>

<div class="callout">
<strong>Pedagogical Grounding:</strong> Effective tutoring follows <strong>Scaffolding</strong> [5] (enable progress without replacing the learner's work) and <strong>Productive Failure</strong> [6] (help learners organize and refine ideas after initial struggle) — requiring explicit constraints on <em>what</em> and <em>when</em> an LLM replies.
</div>

<!--
Theoretical Foundations:
1. Scaffolding (Wood, Bruner, & Ross, 1976 [5]): Effective instructional support enables a learner to make progress on tasks just beyond independent reach while leaving responsibility for the cognitive work with the learner. Providing complete executable code violates this principle by substituting the tutor's reasoning for the student's.
2. Productive Failure (Kapur, 2008 [6]): Allowing learners to wrestle with an initial attempt before receiving targeted instructional consolidation helps them organize, test, and refine their own mental models. Premature, over-complete LLM outputs short-circuit this productive struggle.
3. Empirical Evidence on Unconstrained LLMs: Prior studies show that while Codex and ChatGPT can boost immediate completion rates [10, 11], outcomes depend heavily on how students interact with the tool and how prompts are worded [3]. Savelka et al. [8] further demonstrate that GPT-4 easily passes introductory programming assessments, highlighting the urgency of explicit pedagogical constraints on both what an LLM outputs and when it intervenes [7].
-->

---

## 1.2 Research Focus & Three Guiding Questions

Before testing causal efficacy in controlled trials, we first investigate **what help students seek** and **how LLMs should be structured** *(revealed step-by-step)*:

<div class="rq-stage">

* <div class="rq-card teal"><img src="./img/rq1_pattern.svg" alt="RQ1 Pattern Language"><div><div class="rq-hook"><span class="rq-tag" style="background:#0f766e;">RQ1</span> How do we turn ad-hoc prompts into a reusable pedagogical design language?</div><div class="rq-q"><strong>How can LLM programming assistance be structured as a pattern language (AT-TPL)</strong> specifying intent, forces, RACE guardrails, and state-driven transitions?</div></div></div>
* <div class="rq-card accent"><img src="./img/rq2_usage.svg" alt="RQ2 Authentic Usage"><div><div class="rq-hook"><span class="rq-tag">RQ2</span> Which forms of AI help do students actually reach for in a real course?</div><div class="rq-q"><strong>How do learners use Guidance, Debugging, and Optimization patterns</strong> across task states in an authentic 315-student Python course?</div></div></div>
* <div class="rq-card"><img src="./img/rq3_outcomes.svg" alt="RQ3 Errors & Outcomes"><div><div class="rq-hook"><span class="rq-tag" style="background:#1b365d;">RQ3</span> Who uses the AI tutors, and do struggling students reach working solutions?</div><div class="rq-q"><strong>How does tutor usage relate to student error frequencies and final Accepted (AC) outcomes</strong> compared with non-assisted attempts?</div></div></div>

</div>

<!--
Methodological Rationale for an Observational First Step:
The authors explicitly position this work as an observational field study rather than a randomized controlled trial. Their epistemological argument is sequential: before testing whether one AI tutoring intervention causally outperforms another, educators must first establish (1) a formal design vocabulary for structuring stage-specific AI support and (2) an empirical account of what kinds of help students actually seek in an authentic course.

Alignment with the Paper's Contributions:
- RQ1 (Design Formalization): Adapts Alexander's pattern-language tradition [15] and White et al.'s prompt-pattern catalog [16] into a domain-grounded educational pattern language (AT-TPL) that separates pedagogical design principles from concrete RACE prompt realizations.
- RQ2 (Authentic Usage Patterns): Examines voluntary pattern selection across 4,982 attempts (1,315 tutor-assisted) to verify whether students naturally differentiate among planning, debugging, and optimization support, and to detect behavioral mismatches such as premature use of Opti.
- RQ3 (Struggle & Recovery Profile): Compares error frequencies across testing, submission, and runtime phases alongside final judge verdicts (AC, PA, WA, RE) between tutor-assisted and independent attempts, establishing baseline evidence for future quasi-experimental evaluations.
-->

---

## 2. Related Work: Comparing AI Programming Tutors (Table 1)

Existing guardrail tutors embed help-to-situation mappings implicitly inside tool-specific UIs; **AT-TPL** formalizes them as a reusable pattern language.

| AI Tutor | Help-Seeking Situations Covered | Forms of AI Assistance & Guardrails |
| :--- | :--- | :--- |
| **CodeHelp** [17, 18] | Cannot start or cannot fix code *(undistinguished single form)* | Hints, conceptual explanation, root cause & correction hints *(2nd LLM strips code)* |
| **CS50 tools** [21] | Start, fix code, or improve style *(across separate tools)* | Hints, code explanation, root cause hints, `style50` syntactic formatting rules |
| **CodeAid** [19] | Cannot start or cannot fix code *(5 user-selected templates)* | Hints, explanation, pseudo-code; root cause & correction hints |
| **Iris** [20] | Cannot start or cannot fix code *(single chat role)* | Strictest uniform guardrail: subtle hints & counter-questions only *(no pseudo-code)* |
| **AT-TPL (Ours)** | **Start, fix failing code, AND refine post-AC code *(3 patterns)*** | **Calibrated per state: Hints/pseudo-code (`Guidey`); Root cause (`Debuggy`); Quality/idioms (`Opti`)** |

<div class="callout">
<strong>Key Insight:</strong> Prompt constraints are a <em>design intent rather than an absolute guarantee</em> (e.g., CS50 Duck occasionally leaked fixes [22]), making explicit documentation of forces, consequences, and safeguards essential.
</div>

<!--
Comparative Analysis of Guardrail-Based AI Tutors:
Prior systems embed pedagogical constraints inside tool-specific interfaces, differing along two key dimensions:
1. Coverage of Help-Seeking Situations:
   - CodeHelp [17, 18] uses a single request form collecting optional code and error messages without distinguishing initial planning from debugging at the role level; it relies on a secondary LLM pass to strip executable code blocks.
   - Iris [20] integrates exercise statements, student code, and build/test feedback into a single chat role with the strictest uniform constraint: subtle hints, counter-questions, and general best-practice suggestions only, prohibiting executable code, pseudo-code, and concrete steps even during debugging.
   - CodeAid [19] separates starting and debugging across five user-selected feature templates (including General Question, Help Write Code, Help Fix Code, and standalone line-by-line code explanation) and permits pseudo-code during initial guidance.
   - CS50 tools [21] span all three situations across separate utilities (CS50 Duck, Explain Highlighted Code, and style50), but style50 enforces syntactic formatting rules rather than post-acceptance algorithmic efficiency or idiomatic refactoring.

Distinctive Contribution & Shared Limitation:
AT-TPL formalizes all three situations—including post-AC code quality via Optimization—into a reusable pattern language with explicit context, forces, consequences, and transitions. Importantly, the paper cites Yang et al. [22] showing that CS50 Duck occasionally leaked corrected code during debugging despite prompt constraints; hence, prompt rules constitute design intent rather than an absolute guarantee, a caveat that equally applies to AT-TPL's RACE prompts.
-->

---

## 3.1 Smart Coding Tutor (SCT): Online Judge + AI Assistants

<div class="split64">
<div class="left">

<div class="fig-box">
<img src="./img/fig1_sct_design.png" alt="Fig. 1: Design of the Smart Coding Tutor" style="max-height: 395px;">
<div class="fig-cap">Fig. 1: Architecture of the Smart Coding Tutor (SCT) online judge system</div>
</div>

</div>
<div class="right small-text">

### ⚙️ Integrated Learning Loop
- Combines **Assignment Module**, **Code Editor**, **Automated Judger**, **Hidden Test-Case Evaluator**, and **AI Tutors**.
- Passes rich context (`assignment`, `code`, `verdict`, `error message`) to the selected tutor pattern.

### 📋 Six Submission Verdicts
- **AC** (Accepted): Passes all hidden test cases.
- **PA** (Partially Accepted): Passes a subset only.
- **RE** (Runtime Error): Division by zero, index/memory error.
- **WA** (Wrong Answer): Runs but outputs wrong result.
- **TLE** (Time Limit Exceeded) · **CE** (Compilation Error).

</div>
</div>

<!--
System Architecture & Pedagogical Loop:
Smart Coding Tutor (SCT) is an online judge platform [9] combining an assignment module, an in-browser code editor, an automated judger, a hidden test-case evaluator, and embedded AI assistants. Hidden test cases serve a dual pedagogical function: objectively verifying functional correctness while prompting novices to consider boundary conditions, edge cases, and alternative algorithms in an iterative software-development workflow.

Contextual Grounding of AI Tutors:
Because the AI assistants operate inside the online judge environment, every tutor invocation is grounded in structured execution context—including the problem specification, input/output format rules, the student's current code, submission verdicts, and compiler/runtime tracebacks—rather than relying solely on a novice's potentially vague verbal description.

Automated Judge Verdict Taxonomy:
SCT classifies submissions into six standard verdicts that operationally define the learner's task state:
- AC (Accepted): Satisfies all constraints and passes every hidden test case.
- PA (Partially Accepted): Passes only a subset of hidden test cases (often signaling edge-case defects).
- RE (Runtime Error): Terminates abnormally during execution (e.g., division by zero, index out-of-bounds, memory violation).
- WA (Wrong Answer): Executes to completion without exceptions but produces incorrect output.
- TLE (Time Limit Exceeded): Exceeds the execution time budget (inefficient algorithmic complexity or infinite loop).
- CE (Compilation Error): Fails syntax parsing/compilation prior to execution.
-->

---

## 3.2 AT-TPL as a Pattern Language: Transitions & Shared Forces

AT-TPL is **not** three isolated prompts — it is an interconnected pattern language governed by **learner task states** and **three shared forces**.

<div class="fig-box" style="padding: 8px 10px; margin-top: 4px;">
<img src="./img/diag2_attpl_transitions.svg" alt="AT-TPL Non-Linear State Transitions and Shared Forces" style="max-height: 395px;">
</div>

<!--
Pattern-Language Formalism:
Following Alexander et al. [15], AT-TPL treats the three tutors not as isolated prompt templates but as an interconnected language where every pattern shares an eight-part schema: Intent, Motivation, Context, Problem, Forces, Solution (split into design principles and RACE prompt realization), Consequences, and Related Patterns.

Three Shared Forces Across the Language:
1. Timeliness & Concreteness vs. Independent Reasoning: Learners require actionable, timely help, yet overly complete responses displace their own problem-solving effort.
2. Specific Artifact Utility vs. Copy-Paste Risk: Concrete artifacts (examples, fixes, refactored code) are maximally informative, yet executable artifacts can be copied without comprehension.
3. Focused Scope vs. Unaddressed Root Gaps: Restricting a response to a single issue preserves usability and prevents cognitive overload, yet the learner's true underlying difficulty may lie outside that narrow focus.

Non-Linear State Transitions & Partial Adoption:
Although the canonical workflow progresses from Guidance (problem without plan, or code written but not yet executed) to Debugging (failing code) to Optimization (working AC solution), transitions are non-linear: a debugging failure exposing a conceptual gap routes back to Guidance, and an optimization edit introducing a defect routes back to Debugging. Empirically, 67.4% of AI-using students combined multiple patterns across the semester. A notable boundary case is Wrong Answer (WA): it represents a failure without an exception traceback, leaving Debugging with weaker diagnostic input. Finally, the language supports partial instantiation (e.g., deploying only Debugging remains a valid subset) and future extension.
-->

---

## 3.3 The RACE Prompt Framework: Structuring AI Tutors

**RACE** [23] decomposes LLM instructions into four structured prompt engineering slots:

<div class="two-col small-text" style="gap: 10px 16px; margin-top: 4px; font-size: 0.78em;">

<div class="card" style="padding: 9px 14px;">

### 🎭 **R** — Role
Defines the AI's **persona, expertise, and pedagogical stance**.
- *In AT-TPL*: Anchors an educator who withholds full answers or a debugging specialist.

</div>

<div class="card teal" style="padding: 9px 14px;">

### 🎯 **A** — Action
Specifies the exact **single task or verb** the AI must perform.
- *In AT-TPL*: Limits help to hints only, isolating one root cause, or one quality issue.

</div>

<div class="card" style="padding: 9px 14px;">

### 🧩 **C** — Context
Provides **background, artifacts, and the learner's task state**.
- *In AT-TPL*: Supplies problem & I/O specs, failing code + tracebacks, or working AC code.

</div>

<div class="card accent" style="padding: 9px 14px;">

### 🛡️ **E** — Expectation
Sets strict **output format, length, style, and guardrail rules**.
- *In AT-TPL*: Enforces **no executable code**, no greetings, and 2- or 3-part responses.

</div>

</div>

<div class="callout teal" style="margin-top: 10px; padding: 8px 14px; font-size: 0.8em;">
<strong>Why RACE?</strong> AT-TPL is framework-agnostic, yet RACE is chosen because <code>Role / Action / Context</code> map directly to tutor, help type, and learner state, while <code>Expectation</code> gives <strong>pedagogical guardrails</strong> explicit output rules.
</div>

<!--
Definition & Rationale of the RACE Prompt Framework (Section 3.2):
Prompt engineering is essential for controlling LLM behavior in human-computer interaction. This study adopts RACE [23] (Role, Action, Context, Expectation), a general four-component prompt structure not specific to education:
- Role: Defines the AI's persona, domain expertise, and pedagogical stance (e.g., an educator encouraging independent reasoning vs. a debugging specialist).
- Action: Specifies the exact task or verb the AI must execute, narrowing scope to a single form of help so open-ended phrasing does not invite full solutions.
- Context: Supplies necessary background, learner artifacts, and execution state (problem + I/O rules without code; failing code + traceback; or a working program).
- Expectation: Constrains output format, length, style, and explicit pedagogical rules (e.g., withholding executable Python code, omitting greetings, enforcing structured output sections).

Framework Independence vs. Practical Fit:
The authors note that AT-TPL does not depend exclusively on RACE—any prompt framework providing an explicit slot for output constraints can implement the patterns. RACE was chosen specifically because (1) Role, Action, and Context align naturally with the tutor persona, assistance type, and learner situation defined in each pattern, and (2) Expectation operationalizes pedagogical guardrails as unambiguous output rules.
-->

---

## 3.3 (Cont.) Implementing Patterns via RACE (Table 2)

We operationalize AT-TPL using **RACE** [23] because `Expectation` gives pedagogical guardrails an explicit home as output rules:

| Pattern | **R**ole (Stance & Expertise) | **A**ction (Single Help Type) | **C**ontext (Learner State) | **E**xpectation (Output Rules) |
| :--- | :--- | :--- | :--- | :--- |
| **Guidance** (`Guidey`) | Educator encouraging independent thinking *(withholds answers)* | Hints & conceptual explanation only *(avoids full solution)* | Problem statement & I/O rules; pseudo-code OK *(no code yet)* | **No executable code**; hints only; no greetings |
| **Debugging** (`Debuggy`) | Debugging expert + educator *(reads diagnostics)* | Isolate **1 root cause** & propose **1 fix** *(focuses on fault)* | Failing code + error message *(explain, do not guide)* | **2-part output** (Root Cause, Correction Hint); no full code |
| **Optimization** (`Opti`) | Educator in code quality & efficiency *(post-AC review)* | Identify **1 major issue** & **1 strategy** *(avoids overload)* | Working program; idiomatic Python reference | **3-part output** (Summary, Best Practice, Alt. Hint); **no rewrite** |

<div class="callout teal">
<strong>Domain Transferability:</strong> The pattern form and scaffolding stance transfer directly to math or language tutoring; only programming-specific <code>Context</code> & <code>Expectation</code> elements (I/O specs, tracebacks, AC verdict, Python idioms) are domain-bound.
</div>

<!--
Why the RACE Framework Is Used:
AT-TPL is conceptually independent of any single prompt engineering framework; any structured notation that supports explicit output constraints can implement it. The authors adopt RACE [23] (Role, Action, Context, Expectation) because its four slots map cleanly onto pattern elements and give pedagogical guardrails an explicit home:
- Role (R): Encodes both domain expertise and pedagogical stance (e.g., an educator who withholds answers vs. a debugging engineer who reads diagnostics).
- Action (A): Constrains the tutor to a single type of help (e.g., isolate one root cause, identify one major issue), preventing open-ended tasks that invite full solutions or overwhelm novices.
- Context (C): Specifies the exact learner artifact and state available at invocation (problem + I/O rules without code; failing code + traceback; or a functional program evaluated against idiomatic Python).
- Expectation (E): Operationalizes pedagogical guardrails as strict output formatting and prohibition rules (e.g., no executable Python code, no greetings, mandatory two-part or three-part response structures).

General vs. Domain-Specific Transferability:
The paper distinguishes domain-general tutoring principles (the pattern schema, Role framing, hints before answers, scaffolding without solving) from programming-specific elements residing in Context and Expectation (online-judge I/O specifications, exception tracebacks, AC verdicts, the pseudo-code vs. executable-code boundary, and idiomatic Python standards). Porting AT-TPL to mathematics or language learning preserves the pattern structure and general principles while substituting only those domain-bound Context and Expectation elements.
-->

---

## 3.4 Pattern 1: Guidance Pattern (`Guidey`)

<div class="two-col">
<div class="card teal small-text">

### 🎯 Intent, Context & Forces
- **Intent**: Help construct an initial solution strategy while keeping implementation with the student.
- **Context**: Student has the problem & I/O rules, but does not know how to start *(button at top-right of editor)*.
- **Forces Balanced**:
  - Timely concrete help vs. replacing reasoning
  - Multiple constraints vs. cognitive overload
  - Clarifying via pseudo-code vs. copyable Python code

### 🛠️ RACE Solution
- **Small-step scaffolding**: Restate requirement, name concept, or suggest next sub-goal.
- **Incremental interaction**: Student acts on a hint, then requests another if still stuck.
- **Guardrail**: Pseudo-code permitted; **strictly no executable Python code** or greetings.

</div>
<div class="card accent small-text">

### ⚠️ Consequences, Risks & Transitions
- **Benefits**: Provides a structured entry point while keeping coding agency with the learner.
- **Trade-offs & Risks**:
  - *Lower immediate satisfaction*: Hints feel less convenient than full solutions.
  - *Hint-chaining*: Students may request hints back-to-back without acting, shifting reasoning to the AI.
  - *Unverified misdirection*: A misread problem statement has no program output to catch it.
  - *Proficiency gap* [4]: Redundant for strong students; pseudo-code may still feel abstract for novices.
- **Transitions**: Failing implementation ➔ **Debugging**; working solution ➔ **Optimization**.

</div>
</div>

<!--
Full Pattern Specification (Section 3.4.1):
- Context & UI Placement: Triggered when a student has received an assignment with requirements and I/O constraints, is planning or writing initial code, and does not know how to start. Accessible via the Guidey button at the top-right of the SCT code editor (Fig. 2a).
- Exact Deployed RACE Prompt:
  * Role: "You are an excellent programming educator who provides clear guidance and encourages independent thinking. As a Python teaching assistant, you focus on guiding students through problem-solving."
  * Action: "Provide step-by-step guidance, hints, and conceptual explanations to lead the student to a correct and efficient solution."
  * Context: Specifies that the problem has requirements, I/O rules, and format constraints; explicitly permits pseudo-code as a teaching tool while strictly prohibiting executable Python code.
  * Expectation: Forbids executable Python code to prevent copying, forbids greetings to maintain focus, and restricts output to hints and guidance without direct answers.
- Interaction-Level Scaffolding: Cognitive load is controlled incrementally—students are expected to act on one hint (e.g., restating a requirement, naming a concept, or tackling the next sub-goal) before requesting another.

Documented Consequences & Risks:
1. Reduced Immediate Satisfaction: Students seeking rapid homework completion may perceive hints as less helpful than complete solutions.
2. Hint-Chaining Risk: Because another hint is always available, learners may repeatedly request hints without attempting code, effectively transferring reasoning to the tutor.
3. Unverified Misdirection: If the LLM misinterprets a subtle problem constraint, the student has no execution output yet to detect the flawed plan.
4. Proficiency Moderation [4]: Step-by-step hints can feel redundant and slow for students who already have a workable plan, whereas pseudo-code may remain too abstract for complete novices.
-->

---

## 3.5 Pattern 2: Debugging Pattern (`Debuggy`)

<div class="split55">
<div class="left">

<div class="fig-box">
<img src="./img/fig2a_guidey_debuggy.png" alt="Fig. 2a: Guidey and Debuggy in SCT" style="max-height: 390px;">
<div class="fig-cap">Fig. 2a: SCT interface — <code>Guidey</code> (top-right) &amp; <code>Ask Debuggy</code> (below console error)</div>
</div>

</div>
<div class="right small-text">

### 🔍 Explicit Diagnosis, Student-Owned Fix
- **Intent**: Isolate the cause of a concrete failure and guide a targeted correction.
- **RACE Solution**: References exact **traceback + failing line**; enforces **2-part output**:
  1. *Root Cause Analysis* (concise why)
  2. *Correction Hint* (targeted fix / pseudo-code, **no full program**)

### ⚠️ Boundary Case & Risks
- **Wrong Answer (WA) gap**: No traceback exists, weakening diagnostic input and raising incomplete-diagnosis risk [14].
- **Diagnostic dependency**: Beginners may apply fixes without learning to read tracebacks themselves.
- **Transitions**: Missing concept ➔ **Guidance**; passing code ➔ **Optimization**.

</div>
</div>

<!--
Full Pattern Specification (Section 3.4.2):
- Context & UI Placement: Triggered when a student holds non-functional code along with an error message or failed judge result. As shown in Fig. 2a, Ask Debuggy appears directly beneath the console error output while Guidey remains at the top-right of the editor.
- Exact Deployed RACE Prompt:
  * Role: "You are an expert Python Debugging Engineer and an effective educator" specializing in isolating runtime and syntax errors with clear, targeted explanations.
  * Action: Analyze code and error output, isolate the single most likely root cause, and propose the single best fix (avoiding exhaustive multi-issue lists that obscure the immediate fault).
  * Context: Requires both the non-functional code snippet and complete error message (traceback); mandates referencing the error message and failing line explicitly, and shifts pedagogical mode ("Your task is not to guide, but to explain and correct the mistake").
  * Expectation: Enforces a two-part output—(1) Root Cause Analysis (concise explanation of why the error occurred) and (2) Correction Hint (a specific suggestion or pseudo-code fragment)—while prohibiting complete executable Python code.

Boundary Case & Pedagogical Trade-Offs:
- Single-Fix Commitment & WA Limitation: Committing to one root cause increases the risk of incomplete or inaccurate diagnosis, a known failure mode in LLM responses to novice requests [14]. This risk peaks on Wrong Answer (WA) verdicts, where no exception traceback exists; the prompt's requirement to cite an error message cannot be satisfied, forcing diagnosis solely from the problem statement, code, and judge verdict.
- Diagnostic Dependency: Because Debuggy demonstrates how to read the traceback, novices who gain the largest short-term relief also face the highest risk of applying correction hints passively without developing independent traceback-reading skills.
-->

---

## 3.6 Pattern 3: Optimization Pattern (`Opti`)

<div class="split55">
<div class="left">

<div class="fig-box">
<img src="./img/fig2b_opti.png" alt="Fig. 2b: Opti button in SCT" style="max-height: 390px;">
<div class="fig-cap">Fig. 2b: SCT History tab — <code>Ask Opti</code> assistant for post-solution quality review</div>
</div>

</div>
<div class="right small-text">

### ✨ Post-AC Reflection Without Full Rewrites
- **Intent**: Foster readability, efficiency, and idiomatic Python *after* a working (`AC`) solution exists.
- **RACE 3-Part Output**:
  1. *Code Quality Summary* (strengths & gaps)
  2. *Named Best-Practice Suggestion* (e.g., list comprehension)
  3. *Non-Executable Alternative Hint* (**no full rewrite**)

### ⚠️ Prompt Limitation & Adoption Reality
- **Deployed prompt drift**: Role/Action emphasized *performance*, while Context emphasized *readability* — noted transparently for revision (Table 2).
- **Voluntary adoption**: Low post-AC motivation; students often clicked `Opti` *before* achieving AC (un-gated UI).

</div>
</div>

<!--
Full Pattern Specification (Section 3.4.3):
- Context & UI Placement: Intended for students who already have a functional program or an Accepted (AC) verdict and want to examine readability, efficiency, and idiomatic Python practices. Accessed via the Ask Opti button beneath "AI Assistant" in the SCT submission history tab (Fig. 2b).
- Exact Deployed RACE Prompt & Self-Reported Drift:
  * Deployed Role: "high-performance computing and efficiency analysis" educator focusing on Python best practices.
  * Deployed Action: Identify the most significant performance bottleneck, explain the optimization principle (e.g., reducing nested loops), and propose an optimization strategy.
  * Deployed Context: Functional code snippet; focus on readability, conciseness, and idiomatic Python (e.g., list comprehensions, built-in functions).
  * Deployed Expectation: Strict three-part output—(1) Code Quality Summary (strengths and areas for improvement), (2) Best Practice Suggestion (named principle/idiom), and (3) Alternative Solution Hint (non-executable description)—with no complete executable rewrite.
  * Transparent Implementation Critique: The authors explicitly acknowledge an internal inconsistency in the deployed prompt: Role and Action emphasized performance/HPC, whereas Context targeted readability and idioms. They classify this as an implementation flaw rather than a pattern flaw, specifying a revised design in Table 2 where Role is a code-quality educator and readability is primary, with efficiency secondary.

Adoption Reality & Risks:
Because AC signals task completion, voluntary Opti usage was lowest (30.6% of tutor-assisted attempts) and post-AC engagement was rare. Performance-framed advice risks encouraging premature optimization, and unfamiliar idioms can replace student-readable code with unmaintainable code. Moreover, because SCT did not gate Opti by task state, students frequently invoked it after submission errors (23.1%) and runtime errors (24.4%).
-->

---

## 4.1 Empirical Study: Authentic Course Deployment & Usage

Deployed in **Fall 2024** university Python course (Taiwan) across engineering, business, and social science majors:

<div class="three-col" style="margin-bottom: 12px;">
<div class="kpi-card teal">
<div class="kpi-val">315 Students</div>
<div class="kpi-label">Across <strong>86 Python exercises</strong> in an authentic full-semester course</div>
</div>
<div class="kpi-card">
<div class="kpi-val">1,315 / 4,982</div>
<div class="kpi-label"><strong>26.4%</strong> tutor-assisted attempts (73.6% completed independently)</div>
</div>
<div class="kpi-card accent">
<div class="kpi-val">67.4% Multi-Tutor</div>
<div class="kpi-label">Of AI-using students combined <strong>more than one tutor pattern</strong></div>
</div>
</div>

<div class="card small-text">

### 📊 Pattern Usage Share Among 1,315 Tutor-Assisted Attempts *(non-exclusive; sum > 100%)*
<div style="margin-top: 10px;">
<div class="bar-row"><div><strong>Guidance (Guidey)</strong></div><div class="bar-track"><div class="bar-fill teal" style="width: 58.8%;"></div></div><div class="bar-pct">58.8% (773)</div></div>
<div class="bar-row"><div><strong>Debugging (Debuggy)</strong></div><div class="bar-track"><div class="bar-fill accent" style="width: 47.7%;"></div></div><div class="bar-pct">47.7% (627)</div></div>
<div class="bar-row"><div><strong>Optimization (Opti)</strong></div><div class="bar-track"><div class="bar-fill" style="width: 30.6%;"></div></div><div class="bar-pct">30.6% (402)</div></div>
</div>

</div>

<!--
Study Setting & Unit of Analysis (Section 4.1):
- Course Context: Deployed during the 2024 Fall Semester in a university Python programming course in Taiwan enrolling 315 students across diverse majors (engineering, business, and social sciences) completing 86 programming exercises.
- Definition of an Attempt: One student's complete work sequence on a single exercise, aggregating all test runs, submissions, and AI tutor requests up to the final judge verdict.
- Corpus Volume: Out of 4,982 total attempts, 1,315 (26.4%) were tutor-assisted (at least one AI tutor request), while 3,667 (73.6%) were completed independently without AI assistance.

Usage Distribution & Multi-Pattern Adoption:
Among the 1,315 tutor-assisted attempts, individual pattern shares are non-exclusive (summing to 137.1% > 100%) because a single attempt frequently invoked multiple tutors:
- Guidance (Guidey): 58.8% (773 / 1,315 attempts), indicating that problem interpretation and initial algorithm planning represented the single largest source of novice help-seeking.
- Debugging (Debuggy): 47.7% (627 / 1,315 attempts).
- Optimization (Opti): 30.6% (402 / 1,315 attempts).
- Cross-Pattern Switching: At the student level, 67.4% of students who used AI tutors invoked more than one specialized pattern over the semester, empirically supporting the view that learners differentiate among distinct tutoring needs rather than relying on a single role.
-->

---

## 4.2 Usage Contexts: Expected vs. Observed Student Behavior

Observing *when* students invoked each pattern revealed both expected alignment and a striking behavioral mismatch:

<div class="two-col">
<div class="card teal small-text">

### ✅ Debugging Context (Aligned)
- Testing-phase errors occurred in **37.5%** (`1,869 / 4,982`) of all attempts.
- **30.2%** (`564 / 1,869`) of those error-encountering attempts invoked **Debuggy**.
- High **Guidey (58.8%)** & **Multi-Tutor (67.4%)** use confirms students actively switch patterns across problem-solving stages.

</div>
<div class="card accent small-text">

### ⚠️ Optimization Context (State Mismatch!)
- **Intended context**: Post-`AC` reflection on code readability and Python idioms.
- **Observed reality**: Students rarely clicked `Opti` after `AC` — instead invoking it after:
  - **Submission errors**: **23.1%** (`373 / 1,614`)
  - **Runtime errors**: **24.4%** (`150 / 615`)
- **Why?** Because `Opti` was **not gated by task state**, struggling students treated it as another general help button, and stopped once `AC` signaled task completion.

</div>
</div>

<div class="callout">
<strong>Design Takeaway:</strong> Separating patterns conceptually is not enough — supporting post-acceptance code quality requires <strong>state-based UI gating</strong> or <strong>explicit course incentives</strong>.
</div>

<!--
State-Alignment Analysis (Section 4.1):
Evaluating when each tutor was called relative to execution events reveals a sharp contrast between Debugging and Optimization:

1. Debugging Context (Strong Alignment):
   - Testing-phase errors occurred in 37.5% (1,869 / 4,982) of all course attempts.
   - Among those error-encountering attempts, 30.2% (564 / 1,869) invoked Debuggy, closely matching the pattern's intended context (failing code with diagnostic output).

2. Optimization Context (Pronounced State Mismatch):
   - Across all 4,982 attempts, submission errors occurred in 32.4% (1,614 / 4,982) and runtime errors occurred in 12.3% (615 / 4,982).
   - Opti was invoked in 23.1% (373 / 1,614) of attempts with submission errors and 24.4% (150 / 615) of attempts with runtime errors.
   - Conversely, continued interaction with Opti after reaching an Accepted (AC) verdict was rare.

Underlying Mechanisms & Design Implications:
Two structural factors explain this mismatch: (a) an AC verdict provides strong psychological closure, leaving little intrinsic incentive to refactor working code unless explicitly graded or structured into course activities; and (b) because SCT left the Opti button unconstrained by task state, struggling students treated Opti as an additional fallback help button when stuck on errors. Introducing state-based UI gating (enabling Opti only post-AC) would eliminate state misuse, though at the trade-off of restricting learner autonomy.
-->

---

## 4.3 Errors & Acceptance Outcomes (Table 3 & Debuggy Analysis)

<div class="three-col" style="margin-bottom: 10px;">
<div class="kpi-card teal">
<div class="kpi-val">73.9% AC Rate</div>
<div class="kpi-label"><strong>972 / 1,315</strong> tutor-assisted attempts reached Accepted (PA: 12.6%, WA: 3.3%, RE: 2.7%)</div>
</div>
<div class="kpi-card accent">
<div class="kpi-val">3.7× – 5.7× Errors</div>
<div class="kpi-label">Tutor users had far more errors, showing tutors were sought <strong>when struggling</strong></div>
</div>
<div class="kpi-card">
<div class="kpi-val">76.1% vs. 76.7%</div>
<div class="kpi-label">Debuggy users matched non-users' AC rate despite <strong>7.2 vs. 1.0</strong> prior test errors</div>
</div>
</div>

<div class="split55">
<div class="left small-text">

### 📊 Mean Errors per Attempt (Table 3)
| Error Phase | With AI Tutor | Without AI Tutor | Ratio |
| :--- | :---: | :---: | :---: |
| **Testing Errors** | **4.5** *(max 99)* | 0.8 | **5.7×** |
| **Submission Errors** | **3.3** *(max 68)* | 0.6 | **5.1×** |
| **Runtime Errors** | **0.7** *(max 20)* | 0.2 | **3.7×** |

</div>
<div class="right card small-text">

### 🛡️ Debugging Scaffolding Signal
- Among **1,869** attempts with testing errors:
  - **Debuggy users** (`n = 564`): **76.1% AC** (`429/564`), only **2.5%** (`14/564`) remained stuck in CE/RE — despite **7.2×** more test errors beforehand.
  - **Non-users**: **76.7% AC** (with only 1.0 test error).
- *Consistent with* a scaffolding effect, though self-selection prevents causal proof.

</div>
</div>

<!--
Error Profile & Outcome Analysis (Section 4.2):
1. Overall Verdict Distribution (1,315 Tutor-Assisted Attempts):
   - Accepted (AC): 73.9% (972 / 1,315)
   - Partially Accepted (PA): 12.6%
   - Wrong Answer (WA): 3.3%
   - Runtime Error (RE): 2.7%
   (Remaining ~7.5% reflect other non-AC terminal states such as CE/TLE or unsubmitted runs.)

2. Error Disparity Between Tutor-Assisted vs. Independent Attempts (Table 3):
   - Testing-phase errors: mean 4.5 (max 99 in a single attempt) with AI tutor vs. 0.8 without (5.7x ratio).
   - Submission errors: mean 3.3 (max 68) with AI tutor vs. 0.6 without (5.1x ratio).
   - Runtime errors: mean 0.7 (max 20) with AI tutor vs. 0.2 without (3.7x ratio).
   Interpretation: High error counts indicate that students primarily triggered AI tutors when encountering genuine difficulty; the authors caution that error counts reflect help-seeking under struggle rather than serving as a direct proxy for baseline programming ability.

3. Focused Comparison on Testing-Error Attempts (n = 1,869):
   - Attempts that invoked Debuggy (n = 564) had experienced substantially more prior testing errors (mean 7.2 vs. 1.0 for non-Debuggy error attempts), yet achieved a 76.1% AC rate (429 / 564)—virtually matching the 76.7% AC rate of non-Debuggy attempts—with only 2.5% (14 / 564) remaining stuck in CE or RE.
   - Causal Caveat: Because students self-selected whether to invoke tutors, this convergence is consistent with a scaffolding effect for struggling learners but does not constitute causal proof.
-->

---

## 4.4 Course-Level Context & Methodological Honesty

<div class="two-col">
<div class="card teal small-text">

### 📈 Historical Cohort Context
- Relative to earlier offerings of the same Python course:
  - **Class average score**: ~55 ➔ **~75**
  - **Course dropout rate**: ~10% ➔ **~2%**
- **Transparent Framing**: Cohort, instruction, and assessment also changed across semesters; reported strictly as **deployment context**, *not* causal proof of AI tutor impact.

</div>
<div class="card accent small-text">

### 🔬 Observational Scope & Limitations
- **Self-selection bias**: Students freely chose whether and which tutor to invoke; comparisons are descriptive.
- **Prompt guardrails ≠ guarantee**: As seen in CS50 Duck [22], LLM prompts express design intent; post-generation checks or audits are needed to verify zero code leakage.
- **Why observe first?** Knowing *which* help students actually seek is a prerequisite for designing fair controlled comparisons.

</div>
</div>

<!--
Course-Level Historical Context (Section 4.3):
Compared with earlier offerings of the same introductory Python course, the Fall 2024 deployment coincided with two notable macro-level shifts:
- Class average score rose from approximately 55 to approximately 75.
- Course dropout rate fell from nearly 10% to approximately 2%.

Epistemological Boundaries & Methodological Caveats:
1. Confounding Factors in Historical Comparisons: Cohort composition, instructional delivery, and assessment design all changed across semesters. The authors explicitly report these course-level shifts strictly as ecological deployment context and decline to attribute them causally to SCT or AT-TPL.
2. Self-Selection Bias: Within the semester, students freely decided whether and when to request AI support, preventing clean causal isolation of tutor efficacy from learner motivation or persistence.
3. Guardrail Compliance Is Not Guaranteed: Echoing findings from CS50 Duck [22], RACE Expectation rules encode pedagogical intent rather than deterministic enforcement; without automated post-generation filters (like CodeHelp's secondary LLM pass [17] or Iris's self-checks [20]) or response audits, occasional leakage of executable code remains possible.
4. Value of Observational Groundwork: Documenting authentic help-seeking distributions and state-mismatch failure modes provides the empirical prerequisites needed to design fair, well-calibrated controlled comparisons in future work.
-->

---

## 5. Discussion: Recurring Trade-Offs & Design Safeguards

Across all three patterns, one fundamental tension recurs: **making help more concrete and usable simultaneously opens the door to cognitive offloading**.

<div class="three-col">
<div class="card teal small-text">

### ⚖️ 1. Specificity vs. Agency
- AT-TPL does not magically eliminate over-reliance; instead, it **pinpoints exactly where the risk arises** (e.g., hint-chaining in `Guidey`, skipping traceback reading in `Debuggy`).
- Enables targeted safeguards: **hint budgets**, **explain-before-next-hint** prompts, and **gradual fading**.

</div>
<div class="card accent small-text">

### 🚪 2. State Gating vs. Autonomy
- Leaving `Opti` un-gated led to **23%–24% misuse after errors** instead of post-AC reflection.
- **Task-state gating** (unlocking `Opti` only after `AC`) prevents mismatch at the cost of restricting learner choice — a deliberate course-level trade-off.

</div>
<div class="card small-text">

### 🎓 3. Proficiency-Dependent Effects
- **Beginners**: Gain the most immediate relief from `Debuggy`, but face the highest risk of diagnostic dependency and unmaintainable `Opti` idioms.
- **Advanced learners**: Find `Guidey`'s step-by-step hints slow, yet benefit most from `Opti`'s best-practice vocabulary.

</div>
</div>

<!--
Synthesis of Cross-Pattern Pedagogical Tensions (Sections 3.4 & 5):
A single structural tension recurs across Guidance, Debugging, and Optimization: increasing the specificity and immediate utility of AI assistance simultaneously widens the opportunity for students to substitute the tutor's reasoning for their own. AT-TPL does not eliminate this risk; rather, its formal Consequences analysis pinpoints the exact interaction points where over-reliance emerges so course designers can deploy targeted safeguards.

Three Core Design Axes:
1. Specificity vs. Learner Agency:
   - Risk nodes: sequential hint-chaining in Guidey without intervening code edits; passive fix application in Debuggy without learning to parse tracebacks.
   - Recommended safeguards: interaction-level hint budgets, mandatory self-explanation prompts (requiring learners to explain a fix before unlocking further hints), and gradual scaffolding fading.
2. State-Based Gating vs. Learner Autonomy:
   - Un-gated Opti access produced 23.1% (submission-error) and 24.4% (runtime-error) off-state invocations while post-AC usage remained rare.
   - Locking Opti until an AC verdict enforces pedagogical alignment, while pairing it with explicit reflection assignments or rubric incentives addresses post-AC motivational drop-off.
3. Proficiency-Dependent Effects [4]:
   - Novices gain the largest short-term recovery from Debuggy yet face the highest risks of diagnostic dependency, abstract pseudo-code barriers in Guidey, and unmaintainable idiomatic rewrites in Opti.
   - More proficient learners may find incremental Guidey hints redundant yet possess the foundational fluency needed to internalize Opti's named best-practice vocabulary.
-->

---

## 6. Conclusion & Future Work

<div class="fig-box" style="padding: 8px 10px; margin-bottom: 8px;">
<img src="./img/diag3_conclusions.svg" alt="Visual Synthesis of AT-TPL RQ1-RQ3 Conclusions" style="max-height: 360px;">
</div>

<div class="future-strip">
<div class="future-pill"><strong>🧪 1. Quasi-Experimental Trials</strong><br>Compare AT-TPL against (a) 1-line role-only LLMs without pattern guardrails and (b) full-solution tutors.</div>
<div class="future-pill"><strong>🎛️ 2. Adaptive Scaffolding & Fading</strong><br>Adapt hint granularity to learner proficiency, fade support over time, and require self-explanations.</div>
<div class="future-pill"><strong>🧩 3. Expand the Pattern Language</strong><br>Add Reflection, Test-Case Reasoning, and Code-Reading patterns beyond the core triad.</div>
</div>

<!--
Summary of Contributions (Section 5):
AT-TPL advances AI-assisted programming education beyond ad-hoc prompt crafting by contributing:
1. A formal, reusable three-pattern design language (Guidance, Debugging, Optimization) specifying shared forces, eight-part pattern documentation, and non-linear state transitions.
2. A concrete RACE-based operationalization inside Smart Coding Tutor (SCT) with explicit Expectation guardrails and transparent documentation of implementation limitations (such as Opti's performance-vs.-readability prompt drift).
3. An empirical account from 315 students across 86 exercises (4,982 attempts; 1,315 tutor-assisted), demonstrating 67.4% multi-tutor adoption, 73.9% overall AC rate among assisted attempts, 76.1% AC recovery among heavily struggling Debuggy users (7.2 vs. 1.0 prior test errors), and the practical necessity of task-state gating for post-AC optimization.

Three-Pillar Future Research Agenda:
1. Controlled / Quasi-Experimental Comparisons: Evaluate AT-TPL against two specific baselines—(a) a general-purpose LLM given only one-line role labels without pattern guardrails (isolating what pattern constraints add beyond persona labels) and (b) an unconstrained full-solution tutor (quantifying what learning is lost when guardrails are removed).
2. Adaptive Scaffolding & Anti-Reliance Mechanisms: Dynamically adjust hint granularity to learner proficiency and interaction history, fade scaffolding over time, and require learner self-explanations before additional support.
3. Pattern-Language Expansion: Extend the core triad with additional recurring programming-learning patterns, specifically a Reflection Pattern, a Test-Case Reasoning Pattern, and a Code-Reading Pattern.
-->

---

<!-- _class: closing -->

# Thank You for Your Attention!

<p style="font-size: 1.05em; max-width: 860px;">
AI Tutor Triad Pattern: Structuring Conversational Guidance in Programming Education
</p>

<div class="contact-card">
<strong>Nien-Lin Hsueh<sup>+</sup></strong> &nbsp;·&nbsp; <code>nlhsueh@fcu.edu.tw</code><br>
<strong>Lien-Chi Lai</strong> &nbsp;·&nbsp; <code>p1000433@o365.fcu.edu.tw</code> &nbsp;|&nbsp; <strong>Ying-Chang Lu</strong> &nbsp;·&nbsp; <code>m1305878@o365.fcu.edu.tw</code><br>
Department of Information Engineering and Computer Science, Feng Chia University<br>
<span style="font-size: 0.85em; opacity: 0.88;">Journal of Information Science and Engineering (JISE), 2026 · Grant: NSTC 114-2221-E-035-077</span>
</div>

<!--
Reference & Archival Metadata:
- Title: AI Tutor Triad Pattern: Structuring Conversational Guidance in Programming Education
- Authors: Nien-Lin Hsueh (corresponding author, nlhsueh@fcu.edu.tw), Lien-Chi Lai (p1000433@o365.fcu.edu.tw), and Ying-Chang Lu (m1305878@o365.fcu.edu.tw)
- Affiliation: Department of Information Engineering and Computer Science, Feng Chia University, Taichung, Taiwan
- Venue: Journal of Information Science and Engineering (JISE), 2026
- Funding: National Science and Technology Council (NSTC), Taiwan R.O.C., grant NSTC 114-2221-E-035-077
- Keywords: pattern language, programming education, large language model, pedagogical scaffolding, online judge system
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
