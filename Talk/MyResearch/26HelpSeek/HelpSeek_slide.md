---
marp: true
theme: gaia
size: 16:9
paginate: true
html: true
header: '<div class="hdr-wrap"><span class="hdr-title">Help-Seeking in LLM-Assisted Learning: Behavioral Pathways &amp; Coding Efficiency</span><div class="nav-dropdown"><button class="nav-btn">Sections ▾</button><div class="nav-menu"><a href="#2">Opening Hook: 78% Smash Retry</a><a href="#3">Outline</a><a href="#4">1. Motivation &amp; RQs</a><a href="#6">2. Related Work</a><a href="#7">3. System &amp; Methodology</a><a href="#10">4. Empirical Results (RQ1–RQ2)</a><a href="#15">5. Discussion, RQ3 &amp; Limitations</a><a href="#18">6. Conclusion &amp; Future Work</a></div></div></div>'
footer: 'Lien-Chi Lai &amp; Nien-Lin Hsueh · Feng Chia University · Electronics 2026, 15, 2706'
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
  min-width: 240px;
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
  margin: 0 0 12px 0;
  padding-bottom: 6px;
  border-bottom: 2.5px solid var(--navy);
  display: flex;
  align-items: center;
  gap: 8px;
}

h3 {
  color: var(--accent);
  font-size: 0.95em;
  font-weight: 700;
  margin: 4px 0 6px 0;
}

p { margin: 0 0 8px 0; }
ul, ol { margin: 4px 0 8px 0; padding-left: 22px; }
li { margin-bottom: 5px; line-height: 1.42; }
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
section table th strong { color: #ffffff !important; }
section table th code { color: #ffffff !important; }
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
  font-size: 1.9em;
  font-weight: 800;
  line-height: 1.24;
  margin-bottom: 16px;
  text-align: left;
}

section.lead .subtitle {
  color: #cbd5e1;
  font-size: 0.93em;
  line-height: 1.5;
  margin-bottom: 24px;
  max-width: 960px;
}

section.lead .meta-box {
  border-left: 4px solid #f43f5e;
  padding-left: 18px;
  color: #e2e8f0;
  font-size: 0.85em;
  line-height: 1.58;
}

section.lead .meta-box strong { color: #ffffff !important; }
section.lead .grant { margin-top: 20px; font-size: 0.72em; color: #94a3b8; }

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
  padding: 10px 14px;
  box-sizing: border-box;
}

.kpi-card.accent { border-left-color: var(--accent); background: var(--accent-soft); }
.kpi-card.teal { border-left-color: var(--teal); background: var(--teal-soft); }

.kpi-val { font-size: 1.38em; font-weight: 800; color: var(--navy); line-height: 1.15; margin-bottom: 3px; }
.kpi-card.accent .kpi-val { color: var(--accent); }
.kpi-card.teal .kpi-val { color: var(--teal); }
.kpi-label { font-size: 0.75em; color: var(--slate-700); line-height: 1.32; }

.callout {
  background: #f8fafc;
  border-left: 4px solid var(--accent);
  border-radius: 0 8px 8px 0;
  padding: 8px 14px;
  margin-top: 8px;
  font-size: 0.84em;
  color: var(--slate-700);
}

.callout strong { color: var(--navy); }

/* Tables */
table {
  width: 100%;
  border-collapse: collapse;
  font-size: 0.73em;
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
  padding: 5px 8px;
  border: 1px solid var(--slate-200);
  vertical-align: middle;
  line-height: 1.3;
}

tr:nth-child(even) td { background: #f8fafc; }

/* Formula Box */
.formula-strip {
  display: grid;
  grid-template-columns: 1.25fr 1fr;
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
  font-size: 0.9em;
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

.split64 .left img:hover, .split55 .left img:hover, .two-col > div:first-child img:hover {
  transform: scale(1.22);
  transform-origin: left bottom;
  box-shadow: 0 12px 28px rgba(15, 23, 42, 0.22);
  position: relative;
  z-index: 30;
}

.split64 .right img:hover, .split55 .right img:hover, .two-col > div:last-child img:hover {
  transform: scale(1.22);
  transform-origin: right bottom;
  box-shadow: 0 12px 28px rgba(15, 23, 42, 0.22);
  position: relative;
  z-index: 30;
}

.fig-cap { font-size: 0.71em; color: var(--slate-500); margin-top: 5px; font-weight: 500; }

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
.rq-q { font-size: 0.79em; color: var(--slate-700); line-height: 1.4; }

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
</style>

<!-- _class: lead -->

<div class="badge">Electronics 2026, 15, 2706 · Computing Education &amp; AI-Assisted Learning</div>

# Help-Seeking in LLM-Assisted Learning: Behavioral Pathways and Their Limited Association with Subsequent Coding Process Efficiency

<div class="subtitle">
Analyzing <strong>732 Real-World Remediation Episodes</strong> (366 Students · 43 Assignments) to Uncover How Students Use LLM Conceptual Clarification in Mastery-Gated Programming
</div>

<div class="meta-box">
<strong>Lien-Chi Lai<sup>*</sup></strong> and <strong>Nien-Lin Hsueh</strong><br>
Department of Information Engineering and Computer Science, Feng Chia University, Taichung, Taiwan<br>
<code>p1000433@o365.fcu.edu.tw</code> · <code>nlhsueh@fcu.edu.tw</code>
</div>

<div class="grant">
Published: 18 June 2026 · DOI: 10.3390/electronics15122706 · Supported by NSTC, Taiwan R.O.C. (Grant NSTC114-2221-E-035-077).
</div>

---

## Opening Hook: We Built a 24/7 AI Tutor — So Why Do 78% Smash "Retry"?

<div class="fig-box" style="padding: 6px; margin-bottom: 10px; background: #fbf9f2;">
<img src="./img/helpseek_hook.jpg" alt="78% Pure Retesting Inertia vs 22% Early AI Help-Seeking" style="max-height: 410px; border-radius: 6px;">
</div>

<div class="callout" style="margin-top: 6px; padding: 9px 16px;">
<strong>The Big Surprise:</strong> Even with instant LLM clarification sitting right beside the quiz, <strong>78.0% of remediation episodes ignore AI help</strong> and repeatedly smash "Retry." Yet when students ask early (Round 1), they clear remediation in half the rounds — even though downstream coding efficiency stays unchanged!
</div>

---

## Presentation Outline

<div class="outline-grid">

<div class="outline-item">
<div class="outline-num">1</div>
<div class="outline-body">

[**Motivation & Research Questions**](#4)
Why AI access ≠ effective help-seeking, classroom log gap, and RQ1–RQ3.

</div>
</div>

<div class="outline-item">
<div class="outline-num">2</div>
<div class="outline-body">

[**Related Work & Research Gap**](#6)
Remediation & SRL, LLMs in CS education, and adaptive help-seeking in ITS.

</div>
</div>

<div class="outline-item">
<div class="outline-num">3</div>
<div class="outline-body">

[**System Architecture & Methodology**](#7)
DialoguEDU mastery-gated workflow, UI cost asymmetry, 4 pathways & MixedLM.

</div>
</div>

<div class="outline-item">
<div class="outline-num">4</div>
<div class="outline-body">

[**Empirical Results (RQ1 & RQ2)**](#10)
Pathway distribution, timing effect (δ = −0.912), null coding efficiency & robustness.

</div>
</div>

<div class="outline-item">
<div class="outline-num">5</div>
<div class="outline-body">

[**Discussion, RQ3 Theory & Limitations**](#15)
Why 78% avoid help, Selective Process-Support Mechanism, and validity limits.

</div>
</div>

<div class="outline-item">
<div class="outline-num">6</div>
<div class="outline-body">

[**Conclusion & Future Work**](#18)
Visual synthesis of RQ1–RQ3 and actionable roadmap for proactive AI tutoring.

</div>
</div>

</div>

---

## 1.1 Motivation: Technological Access ≠ Effective Help-Seeking

<div class="fig-box" style="padding: 10px 12px; margin-bottom: 10px;">
<img src="./img/diag1_access_vs_use.svg" alt="Common Assumption vs Classroom Reality in LLM Help-Seeking" style="max-height: 355px;">
</div>

<div class="callout">
<strong>Two Research Gaps Addressed:</strong> (1) Most LLM-in-CS studies focus on <em>code generation/debugging</em> rather than <strong>conceptual assessment remediation</strong>; (2) Complete process-level behavioral logs from real classroom deployments remain scarce compared to lab experiments and surveys.
</div>

---

## 1.2 Research Objectives & Three Research Questions

Using full interaction logs from a mastery-gated programming course (`N = 732` episodes), we investigate three linked questions *(revealed step-by-step)*:

<div class="rq-stage">

* <div class="rq-card teal"><img src="./img/rq1_pathways.svg" alt="RQ1 Behavioral Pathways"><div><div class="rq-hook"><span class="rq-tag" style="background:#0f766e;">RQ1 · Descriptive</span> How do students actually navigate LLM remediation?</div><div class="rq-q"><strong>What behavioral pathways emerge</strong> in terms of clarification occurrence, timing, frequency, functional type, remediation rounds (<i>R</i>), and duration?</div></div></div>
* <div class="rq-card accent"><img src="./img/rq2_coding.svg" alt="RQ2 Coding Efficiency"><div><div class="rq-hook"><span class="rq-tag">RQ2 · Associative</span> Does seeking clarification speed up subsequent coding?</div><div class="rq-q"><strong>Are remediation pathways associated with subsequent coding process efficiency</strong> (active time &amp; code snapshots) after controlling for student and assignment differences?</div></div></div>
* <div class="rq-card"><img src="./img/rq3_theory.svg" alt="RQ3 Theoretical Integration"><div><div class="rq-hook"><span class="rq-tag" style="background:#1b365d;">RQ3 · Theoretical</span> What role does LLM clarification truly play in mastery learning?</div><div class="rq-q"><strong>Integrating RQ1 and RQ2, what is its theoretical mechanism</strong>, boundary conditions, and practical design implication for AI-assisted learning systems?</div></div></div>

</div>

---

## 2. Related Work & Research Positioning

| Research Stream | Representative Prior Findings | Key Unresolved Gap |
| :--- | :--- | :--- |
| **Remediation & SRL** [5, 10, 11] | Effective learners monitor errors & adapt strategies; yet multi-retry systems trigger **retesting inertia**. Early feedback curbs misconceptions. | Difficult to separate timing benefits from prior ability in naturalistic settings. |
| **LLMs in CS Education** [1, 2, 12, 13] | Novices show highly individualized LLM usage [1]. Per-opportunity learning rates are remarkably consistent across conditions [13]. | Focuses mainly on code generation/debugging; conceptual remediation effects remain underexplored. |
| **Help-Seeking in ITS / AI** [3–7, 16] | Adaptive help-seeking is a core SRL skill, yet learners often show **help avoidance** or gaming [5]; feedback timing outweighs volume [16]. | Mostly small-scale qualitative studies, surveys, or controlled experiments [6, 7]. |
| **This Study (DialoguEDU)** | **732 naturalistic remediation episodes** (366 students, 43 assignments) tracing MCQ retries, LLM dialogs & code snapshots end-to-end. | **Connects process-level help-seeking pathways directly to subsequent coding efficiency.** |

<div class="callout">
<strong>Why Mastery Gating Helps Research:</strong> Requiring students to pass an 80% conceptual MCQ gate before coding makes the entire remediation loop directly observable in real classroom logs.
</div>

---

## 3.1 Mastery Learning Architecture (DialoguEDU)

<div class="split55">
<div class="left">

<div class="fig-box">
<img src="./img/fig1_workflow.png" alt="Fig. 1: Student workflow in DialoguEDU" style="max-height: 430px;">
<div class="fig-cap">Fig. 1: Two-stage mastery-gated workflow &amp; remediation branch</div>
</div>

</div>
<div class="right small-text">

### 🏗️ Two-Stage Mastery Gating [8]
- **Stage 1 (Conceptual MCQ)**: Dynamically generated from instructor PDFs via **Gemini 2.5 Flash** (`temp = 0.7`, direct prompt context, no RAG).
- **80% Mastery Threshold**: Students below threshold enter the **Remediation Branch** with **error-aware MCQ regeneration** targeting prior misconceptions.
- **LLM Clarification Interface**: Available anytime during remediation to explain concepts *without revealing MCQ answers*.
- **Stage 2 (Personalized Coding)**: Unlocked upon passing; tailored to each student's MCQ error history, graded by LLM + manual TA verification.

</div>
</div>

---

## 3.2 Student Interfaces & Interaction Cost Asymmetry

<div class="two-col">
<div>
<div class="fig-box">
<img src="./img/fig2a_mcq_ui.png" alt="Fig. 2a: MCQ assessment interface" style="max-height: 315px;">
<div class="fig-cap">Fig. 2a: MCQ interface showing 80% mastery threshold &amp; marked errors</div>
</div>
</div>
<div>
<div class="fig-box">
<img src="./img/fig2b_llm_ui.png" alt="Fig. 2b: LLM clarification interface" style="max-height: 315px;">
<div class="fig-cap">Fig. 2b: LLM assistant with predefined buttons &amp; free-text chat</div>
</div>
</div>
</div>

<div class="callout" style="margin-top: 10px;">
<strong>Design Insight — Interaction Cost Asymmetry:</strong> Clicking <em>Retry</em> or a predefined button (<em>"Explain this concept"</em>, <em>"Why was my answer wrong?"</em>) takes far less cognitive effort than formulating a free-text question — nudging stressed learners toward passive retesting.
</div>

---

## 3.3 Dataset, Pathway Taxonomy & Analytical Pipeline

<div class="fig-box" style="padding: 8px 10px; margin-bottom: 8px;">
<img src="./img/diag2_method_pipeline.svg" alt="Methodology and Statistical Analysis Pipeline" style="max-height: 245px;">
</div>

<div class="formula-strip">
<div class="formula-box">
<i>Cliff's δ</i> &nbsp;=&nbsp;
<span class="frac"><span class="frac-num">#(<i>x<sub>i</sub></i> &gt; <i>y<sub>j</sub></i>) − #(<i>x<sub>i</sub></i> &lt; <i>y<sub>j</sub></i>)</span><span class="frac-den"><i>n<sub>x</sub></i> × <i>n<sub>y</sub></i></span></span>
<span style="font-family: Inter, sans-serif; font-size: 0.74em; color: #64748b; margin-left: 10px;">(10k Bootstrap 95% CI)</span>
</div>
<div class="formula-box" style="font-family: Inter, sans-serif; font-size: 0.75em; flex-direction: column; align-items: flex-start; gap: 3px;">
<div><strong>Romano [17] |δ| Thresholds:</strong> &lt;0.147 Negligible · &lt;0.33 Small · &lt;0.474 Med · ≥0.474 Large</div>
<div><strong>MixedLM (REML):</strong> <code>log(Y) ~ pathway + assignment_id + (1 | student_id)</code></div>
</div>
</div>

<div class="callout" style="margin-top: 8px; padding: 7px 14px;">
<strong>Exhaustive Classification:</strong> Every episode (<code>set_number &gt; 1</code>, <code>N = 732</code>) is assigned deterministically by <strong>frequency first, then timing</strong> (0 excluded). RQ2 analyzes <code>N = 716</code> episodes with coding activity (<code>active_time &gt; 0</code>, 30-min idle cutoff).
</div>

---

## 4.1 RQ1 Results: Pathway Distribution, Timing & Focus

<div class="three-col" style="margin-bottom: 8px;">
<div class="kpi-card accent">
<div class="kpi-val">78.0% (571/732)</div>
<div class="kpi-label"><strong>Pure Retesting</strong> — only 22.0% (161) ever use AI clarification</div>
</div>
<div class="kpi-card teal">
<div class="kpi-val">86.3% (139/161)</div>
<div class="kpi-label"><strong>First-Round Timing</strong> — help-seeking decisions happen immediately (Mdn = 1.0)</div>
</div>
<div class="kpi-card">
<div class="kpi-val">84.7% (216/255)</div>
<div class="kpi-label"><strong>Conceptual Focus</strong> — vs. 11.0% System &amp; 4.3% Procedural</div>
</div>
</div>

<div class="split55">
<div class="left">
<div class="fig-box">
<img src="./img/fig3_pathways.png" alt="Fig. 3: Remediation pathway distribution" style="max-height: 270px;">
<div class="fig-cap">Fig. 3: Distribution across 4 mutually exclusive pathways (N = 732)</div>
</div>
</div>
<div class="right">
<div class="fig-box">
<img src="./img/fig4_clarif_chars.png" alt="Fig. 4: First clarification round and functional type" style="max-height: 270px;">
<div class="fig-cap">Fig. 4: (a) First clarification round; (b) Message functional type (n = 255)</div>
</div>
</div>
</div>

---

## 4.2 RQ1 Results: Remediation Rounds & Cliff's δ Effect Sizes

<div class="split55" style="margin-bottom: 4px;">
<div class="left">
<div class="fig-box" style="padding: 5px;">
<img src="./img/fig5_rounds_violin.png" alt="Fig. 5: Remediation rounds violin-box plot" style="max-height: 192px;">
<div class="fig-cap">Fig. 5: Remediation rounds (R) — Immediate Mdn = 2.0 vs. Delayed Mdn = 4.0</div>
</div>
</div>
<div class="right">
<div class="fig-box" style="padding: 5px;">
<img src="./img/fig6_rq1_forest.png" alt="Fig. 6: RQ1 Cliff's delta forest plot" style="max-height: 192px;">
<div class="fig-cap">Fig. 6: Cliff's δ &amp; 95% Bootstrap CIs for RQ1 pairwise comparisons</div>
</div>
</div>
</div>

| RQ1 Comparison (Table 4) | Outcome | n<sub>1</sub> / n<sub>2</sub> | Mdn<sub>1</sub> vs. Mdn<sub>2</sub> | Cliff's δ | 95% Bootstrap CI | Magnitude |
| :--- | :--- | :---: | :---: | :---: | :---: | :---: |
| With Clarif. vs. Pure Retest | Rounds / Dur. | 161 / 571 | 2.0 vs. 2.0 / 812s vs. 616s | +0.073 / +0.193 | [−0.014, 0.160] / [0.086, 0.299] | Negl. / Small |
| Multiple vs. Non-multiple | Rounds / Dur. | 50 / 111 | 2.5 vs. 2.0 / 1119s vs. 637s | +0.231 / +0.432 | [0.060, 0.401] / [0.246, 0.603] | Small / Med |
| **Single Immed. vs. Delayed** | **Rounds (<i>R</i>)** | **97 / 14** | **2.0 vs. 4.0** | **−0.912** | **[−0.971, −0.835]** | **Large** |

<div class="callout" style="margin-top: 5px; padding: 6px 14px; font-size: 0.8em;">
<strong>Methodological Caveat:</strong> The large <code>δ = −0.912</code> contrast is <em>partly definitional</em> (delayed clarifiers by construction occur at round ≥ 2) and based on <code>n = 14</code>; we interpret it descriptively rather than causally.
</div>

---

## 4.3 RQ2 Results: Pass-Rate Ceiling & Raw Coding Efficiency

<div class="three-col" style="margin-bottom: 8px;">
<div class="kpi-card teal">
<div class="kpi-val">99.6% (729/732)</div>
<div class="kpi-label">Successfully unlocked &amp; entered the coding challenge</div>
</div>
<div class="kpi-card accent">
<div class="kpi-val">97.3% Pass Rate</div>
<div class="kpi-label">Severe <strong>ceiling effect</strong> across all pathways (96.8%–100%)</div>
</div>
<div class="kpi-card">
<div class="kpi-val">|δ| = 0.002 – 0.127</div>
<div class="kpi-label"><strong>All negligible</strong> raw effects on active time &amp; code snapshots</div>
</div>
</div>

<div class="split55">
<div class="left">
<div class="fig-box">
<img src="./img/fig7_rq2_coding.png" alt="Fig. 7: Coding challenge efficiency by pathway" style="max-height: 270px;">
<div class="fig-cap">Fig. 7: Active time &amp; code snapshots on log scale (N = 716)</div>
</div>
</div>
<div class="right small-text">

### 📊 Raw Process Efficiency (Tables 5 & 6)
| Pathway (<i>N</i>) | Active Mdn (IQR) | Snap. Mdn | Active δ (vs. PR) |
| :--- | :---: | :---: | :---: |
| **Pure Retesting** (559) | 17.3m [6.9, 33.5] | 26.0 | Ref. |
| **Single Immed.** (96) | 22.1m [10.6, 37.6] | 33.5 | +0.118 *(Negl.)* |
| **Single Delayed** (13) | 15.1m [9.2, 33.9] | 29.0 | +0.034 *(Negl.)* |
| **Multiple Clarif.** (48) | 22.1m [9.7, 38.6] | 30.5 | +0.127 *(Negl.)* |

- Every 95% Bootstrap CI spans zero; snapshot `|δ| ≤ 0.083` across all groups.

</div>
</div>

---

## 4.4 RQ2 Results: Mixed-Effect Linear Models (Controlling Confounds)

<div class="split55">
<div class="left">
<div class="fig-box">
<img src="./img/fig8_rq2_mixedlm.png" alt="Fig. 8: Mixed-effect model coefficient forest plot" style="max-height: 350px;">
<div class="fig-cap">Fig. 8: MixedLM coefficients (log scale) &amp; 95% CIs vs. Pure Retesting</div>
</div>
</div>
<div class="right small-text">

### 📉 MixedLM Results (Table 7 · N = 716, 355 Students)
Controls for **student random intercept** &amp; **assignment fixed effects** (43 assignments):

| Outcome | Pathway (vs. Pure Retest) | Coef. | 95% CI | <i>p</i> |
| :--- | :--- | :---: | :---: | :---: |
| `log(Active)` | Single Immediate | +0.218 | [−0.034, 0.471] | 0.090 *(ns)* |
| `log(Active)` | Single Delayed | −0.051 | [−0.667, 0.566] | 0.872 *(ns)* |
| `log(Active)` | Multiple Clarif. | +0.108 | [−0.242, 0.458] | 0.546 *(ns)* |
| `log(Snaps)` | Single Immediate | +0.079 | [−0.148, 0.305] | 0.498 *(ns)* |
| `log(Snaps)` | Single Delayed | −0.157 | [−0.692, 0.379] | 0.567 *(ns)* |
| `log(Snaps)` | Multiple Clarif. | +0.002 | [−0.312, 0.316] | 0.989 *(ns)* |

</div>
</div>

<div class="callout" style="margin-top: 8px;">
<strong>Robust Null Finding:</strong> None of the pathways reaches significance (all <code>p &gt; 0.05</code>), and the closest estimate (+0.218, ≈24% more time) points <em>away</em> from faster coding. Single Delayed (<code>n = 13</code>) remains underpowered/inconclusive.
</div>

---

## 4.5 Robustness Checks: Code-Variability & Idle-Cutoff Sensitivity

To verify that external AI copy-pasting or the 30-min idle cutoff did not mask real effects, we ran two sensitivity checks (Section 4.2.4, Table 8):

| Subgroup (Partition: >50% length drop &amp; <50% similarity) | Pathway (vs. PR) | n<sub>clar</sub> / n<sub>PR</sub> | Active Time δ [95% CI] | Snapshots δ [95% CI] |
| :--- | :--- | :---: | :---: | :---: |
| **Stable Coding (`n = 531`, 72.8%)** | Single Immed. / Delayed / Mult. | 69 / 6 / 34 vs. 410 | +0.107 / −0.135 / +0.071 *(all span 0)* | +0.060 / −0.102 / +0.022 *(all span 0)* |
| **High Variability (`n = 198`, 27.2%)** | Single Immed. / Delayed / Mult. | 27 / 7 / 14 vs. 149 | **+0.148 / +0.173 / +0.258** *(small, span 0)* | +0.145 / +0.120 / +0.082 *(all span 0)* |

<div class="two-col" style="margin-top: 8px;">
<div class="card teal small-text">

### 🔍 94,249 Snapshot-Pair Audit
- **82.8%** of consecutive code edits changed **< 5%** of the code; only **8.1%** exceeded 20%.
- Confirms authentic iterative debugging rather than wholesale external AI pasting — validating the stable-group null result.

</div>
<div class="card accent small-text">

### ⏱️ Idle-Threshold Sensitivity (15 / 30 / 60 min)
- Re-estimating MixedLM under **15 min (`N = 715`)** and **60 min (`N = 717`)** cutoffs yields identical conclusions.
- Single Immediate `log(Active)` stays `0.168 / 0.218 / 0.158` (`all p > 0.09`); all other pathways `p > 0.31`.

</div>
</div>

---

## 5.1 Discussion: Why 78% Avoid Help & Why RQ2 Is Null

<div class="two-col">
<div class="card accent small-text">

### 🚫 Three Drivers of 78.0% Help Avoidance (RQ1)
1. **Illusion of Knowing (Overconfidence)** [15]: After a first failure, students underestimate conceptual gaps and assume a quick retry will suffice.
2. **Cognitive Load at Failure**: Formulating a coherent question demands metacognitive effort right when cognitive resources are most strained.
3. **Interface-Induced Retesting Inertia**: Clicking *Retry* has a lower interaction cost than typing a free-text question, reinforcing passive trial-and-error.

- Meanwhile, **Multiple Clarifiers** (`Mdn = 1119s` vs. `637s`, `δ = 0.432`) likely signal deeper conceptual struggles requiring multi-turn scaffolding.

</div>
<div class="card teal small-text">

### 🧩 Five Explanations for the RQ2 Null Result
1. **Mastery-Gating Equalization**: Everyone must clear the **80% MCQ gate** before coding — equalizing entering conceptual competence across pathways!
2. **Ceiling Compression**: A **97.3%** pass rate leaves limited variance for pathway effects to surface.
3. **Narrow Observation Window**: Captures only the immediately following task, not delayed cross-assignment transfer.
4. **Learner Heterogeneity**: Individual depth of processing dilutes group-level averages toward zero.
5. **Regularity of Learning Rates** [13]: Per-opportunity learning gains are remarkably stable across instructional variations.

</div>
</div>

---

## 5.2 RQ3 Theory: Selective Process-Support Mechanism & Design

<div class="fig-box" style="padding: 8px 10px; margin-bottom: 8px;">
<img src="./img/diag3_selective_support.svg" alt="Selective Process-Support Mechanism Framework" style="max-height: 335px;">
</div>

<div class="callout" style="margin-top: 6px; padding: 9px 15px;">
<strong>Actionable Design Implication (System-Triggered Prompting):</strong> Don't wait for stressed novices to self-initiate! Proactively prompt clarification in <strong>Round 1</strong> or after <strong>2 consecutive failures</strong> (e.g., <em>"You've missed this twice — ask AI to clarify the concept?"</em>) to lower the metacognitive entry barrier.
</div>

---

## 5.3 Limitations & Threats to Validity

<div class="three-col">
<div class="card accent small-text">

### ⚖️ Causal & Sample Limits
- **No Prior-Ability Pretest**: Observational design cannot separate self-selection (stronger SRL skills) from causal timing effects.
- **Sample Imbalance**: Pure Retesting (`n = 571`) vs. Single Delayed (`n = 14`) yields wide CIs and low power for delayed clarifiers.
- **Definitional Overlap**: `δ = −0.912` partly reflects counting rounds prior to Round-2+ clarification.

</div>
<div class="card small-text">

### 📏 Measurement & Trajectories
- **Ceiling & Proxy Validity**: 97.3% pass rate forces reliance on active time & snapshots, where longer time may reflect *deeper exploration* rather than inefficiency.
- **Single-Task Window**: Cannot observe delayed transfer across later assignments.
- **Episode Independence**: Does not yet model within-student help-seeking evolution across the semester.

</div>
<div class="card teal small-text">

### 🤖 Classification & Scope
- **Rule-Based Coding**: Deterministic & reproducible, but no human IRR; default *Conceptual* bucket (84.7%) may include minor unclassified residuals.
- **Unanalyzed LLM Quality**: Response accuracy & pedagogical clarity were not scored.
- **Single Context**: One university, one introductory non-CS course, single backbone (**Gemini 2.5 Flash**).

</div>
</div>

---

## 6. Conclusion & Future Work

<div class="fig-box" style="padding: 8px 10px; margin-bottom: 8px;">
<img src="./img/diag4_rq_conclusions.svg" alt="Visual Synthesis of RQ1-RQ3 Conclusions" style="max-height: 350px;">
</div>

<div class="future-strip">
<div class="future-pill"><strong>🧪 1. Randomized Prompting Trials</strong><br>Test system-triggered vs. self-triggered Round-1 prompts with baseline pretests to establish causality.</div>
<div class="future-pill"><strong>📈 2. Longitudinal Trajectories</strong><br>Track cross-assignment transfer and within-student help-seeking habit evolution across a full semester.</div>
<div class="future-pill"><strong>🌐 3. Multi-Site &amp; Response Audits</strong><br>Replicate across institutions &amp; LLMs while evaluating AI explanation quality and human-validated coding.</div>
</div>

---

<!-- _class: closing -->

# Thank You for Your Attention!

<p style="font-size: 1.02em; max-width: 880px;">
Help-Seeking in LLM-Assisted Learning: Behavioral Pathways and Their Limited Association with Subsequent Coding Process Efficiency
</p>

<div class="contact-card">
<strong>Lien-Chi Lai<sup>*</sup></strong> &nbsp;·&nbsp; <code>p1000433@o365.fcu.edu.tw</code><br>
<strong>Nien-Lin Hsueh</strong> &nbsp;·&nbsp; <code>nlhsueh@fcu.edu.tw</code><br>
Department of Information Engineering and Computer Science, Feng Chia University<br>
Published in <strong>Electronics 2026, 15, 2706</strong> &nbsp;·&nbsp; <code>https://doi.org/10.3390/electronics15122706</code><br>
<span style="font-size: 0.85em; opacity: 0.85;">Grant: NSTC114-2221-E-035-077 · Questions &amp; Discussion Welcome!</span>
</div>

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
</script>
