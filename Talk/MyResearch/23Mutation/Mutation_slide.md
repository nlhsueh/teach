---
marp: true
theme: gaia
size: 16:9
paginate: true
html: true
header: '<div class="hdr-wrap"><span class="hdr-title">Code Immunity Boost: Gamified Learning for Mutation Testing</span><div class="nav-dropdown"><button class="nav-btn">Sections ▾</button><div class="nav-menu"><a href="#2">Opening Hook: Paper vs. Immunity</a><a href="#3">Outline</a><a href="#4">1. Introduction & RQs</a><a href="#6">2. Background & Related Work</a><a href="#8">3. CIB Design & Architecture</a><a href="#13">4. Pilot Experiment & Survey</a><a href="#18">5. Conclusion & Future Work</a></div></div></div>'
footer: 'Nien-Lin Hsueh*, Zeng Hung Xuan, & Bilegjargal Daramsenge · Feng Chia University · IJIET 2023 (Vol. 13, No. 7)'
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
section table th code, section table th strong { color: #ffffff !important; }
section.lead code, section.closing code { color: #bae6fd !important; }
section.lead strong, section.closing strong { color: #ffffff !important; }

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
  padding: 9px 14px;
  box-sizing: border-box;
}

.kpi-card.accent { border-left-color: var(--accent); background: var(--accent-soft); }
.kpi-card.teal { border-left-color: var(--teal); background: var(--teal-soft); }

.kpi-val { font-size: 1.38em; font-weight: 800; color: var(--navy); line-height: 1.15; margin-bottom: 3px; }
.kpi-card.accent .kpi-val { color: var(--accent); }
.kpi-card.teal .kpi-val { color: var(--teal); }
.kpi-label { font-size: 0.74em; color: var(--slate-700); line-height: 1.32; }

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
  grid-template-columns: 1fr 1.25fr;
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
  margin: 0 5px;
  line-height: 1.08;
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
  grid-template-columns: 165px 1fr 78px;
  align-items: center;
  gap: 10px;
  margin-bottom: 7px;
  font-size: 0.76em;
}

.bar-track {
  background: var(--slate-100);
  border-radius: 5px;
  height: 17px;
  overflow: hidden;
  border: 1px solid var(--slate-200);
}

.bar-fill { height: 100%; border-radius: 4px; background: var(--navy); }
.bar-fill.teal { background: var(--teal); }
.bar-fill.accent { background: var(--accent); }
.bar-pct { font-weight: 700; text-align: right; color: var(--slate-900); white-space: nowrap; }

/* Benchmark Chips */
.chip-row {
  display: flex;
  flex-wrap: wrap;
  gap: 8px;
  margin-top: 8px;
}

.chip {
  background: var(--slate-100);
  border: 1px solid var(--slate-200);
  color: var(--navy);
  font-size: 0.74em;
  font-weight: 700;
  padding: 4px 11px;
  border-radius: 999px;
}

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

</style>

<!-- _class: lead -->

<div class="badge">IJIET 2023 · Vol. 13, No. 7 · Gamified Software Testing Education</div>

# Design and Implementation of Gamified Learning System for Mutation Testing

<div class="subtitle">
<strong>Code Immunity Boost (CIB)</strong> &amp; <strong>Code Vaccine Incubator (CVI)</strong>: Turning Mutation Testing Education into an Interactive Vaccine-Development Mission
</div>

<div class="meta-box">
<strong>Nien-Lin Hsueh*</strong>, <strong>Zeng Hung Xuan</strong>, and <strong>Bilegjargal Daramsenge</strong><br>
Department of Information Engineering and Computer Science, Feng Chia University, Taiwan<br>
<code>nlhsueh@fcu.edu.tw</code> · DOI: <code>10.18178/ijiet.2023.13.7.1916</code>
</div>

<div class="grant">
Published in International Journal of Information and Education Technology (pp. 1150–1155, July 2023) · Grant: MOST 110-2221-E-035-031-MY2
</div>

<!--
Key Takeaway: We present Code Immunity Boost (CIB) and Code Vaccine Incubator (CVI), a gamified learning platform that transforms mutation testing education into an interactive vaccine-development mission.
Talking Points:
- Welcome everyone. This work, published in IJIET 2023 by our team at Feng Chia University, tackles a persistent pain point in software testing courses: teaching mutation testing effectively.
- Instead of asking students to trace mutants by hand, we turn the workflow into an engaging immune-defense game backed by an automated mutant generator.
Transition: Let's start with a quick visual contrast of why traditional mutation testing classrooms struggle.
-->

---

## Opening Hook: Drowning in Mutant Sheets... or Boosting Code Immunity?

<div class="fig-box" style="padding: 6px; margin-bottom: 10px; background: #fbf9f2;">
<img src="./img/mutation_hook.jpg" alt="Manual Mutation Testing vs Code Immunity Boost" style="max-height: 415px; border-radius: 6px;">
</div>

<div class="callout" style="margin-top: 6px; padding: 9px 16px;">
<strong>The Big Idea:</strong> Handwriting and tracing dozens of mutants by hand quickly drains students' motivation. <strong>Code Immunity Boost (CIB)</strong> reframes mutation testing as a <strong>vaccine-development mission</strong>—where <strong>Leukocytes</strong> (test cases) hunt <strong>Vaccines</strong> (mutants) to strengthen the <strong>Human Body</strong> (program).
</div>

<!--
Key Takeaway: Manual mutation testing quickly exhausts student motivation, whereas CIB reframes the same rigor as a vaccine-development game.
Talking Points:
- On the left, you see the classic classroom reality: students drowning in paper mutant sheets, manually tracing outputs and losing enthusiasm as soon as programs get non-trivial.
- On the right is Code Immunity Boost: the program becomes a Human Body, mutants become Vaccines, and student-written test cases become Leukocytes hunting those mutants.
Transition: Here is the roadmap for how we designed, built, and evaluated this system.
-->

---

## Presentation Outline

<div class="outline-grid">

<div class="outline-item">
<div class="outline-num">1</div>
<div class="outline-body">

[**Introduction & Research Questions**](#4)
Why software testing education needs gamification and our three pilot RQs (RQ1–RQ3).

</div>
</div>

<div class="outline-item">
<div class="outline-num">2</div>
<div class="outline-body">

[**Mutation Testing & Related Work**](#6)
Mutant killing workflow, Mutation Score metric, and limitations of Code Defenders.

</div>
</div>

<div class="outline-item">
<div class="outline-num">3</div>
<div class="outline-body">

[**CIB Game Design & Architecture**](#8)
Immune-system metaphor, 3 Octalysis drives, fragility-calibrated levels, and 6 core modules.

</div>
</div>

<div class="outline-item">
<div class="outline-num">4</div>
<div class="outline-body">

[**Pilot Experiment: Performance & Validity**](#13)
Control (handwriting) vs. Experimental (CIB) submission volume and valid/invalid dynamics.

</div>
</div>

<div class="outline-item">
<div class="outline-num">5</div>
<div class="outline-body">

[**Student Satisfaction Survey & Insights**](#16)
5-point Likert evaluation across Motivation (Q1), Attention (Q2), and Learning Outcome (Q3).

</div>
</div>

<div class="outline-item">
<div class="outline-num">6</div>
<div class="outline-body">

[**Conclusion & Future Work**](#18)
Visual synthesis of RQ1–RQ3 findings and roadmap for Online Judge integration.

</div>
</div>

</div>

<!--
Key Takeaway: Our talk covers six parts, from motivation and mutation testing basics to CIB's architecture, pilot results, and future roadmap.
Talking Points:
- First, we explain why software testing education lags in gamification and introduce our three research questions.
- Next, we walk through CIB's biological metaphor, Octalysis game mechanics, and six-module architecture, followed by our pilot experiment comparing CIB against handwriting.
Transition: Let's dive into Section 1 to see why gamification is especially needed in software testing.
-->

---

## 1.1 Motivation: Why Software Testing Education Needs Gamification

<div class="fig-box" style="padding: 10px 12px; margin-bottom: 10px;">
<img src="./img/diag1_motivation.svg" alt="Traditional Mutation Testing Education vs CIB Gamified Learning" style="max-height: 365px;">
</div>

<div class="callout">
<strong>Why This Matters:</strong> A systematic mapping of 156 SE gamification studies [15] shows gamification boosts participation, knowledge, and SE practices—yet <strong>software testing remains severely underrepresented</strong> compared to design and process courses.
</div>

<!--
Key Takeaway: Software engineering gamification is proven to boost engagement, yet software testing remains severely underrepresented.
Talking Points:
- A systematic mapping of 156 SE gamification studies shows strong gains in student participation and knowledge across design and process courses.
- However, software testing—and mutation testing in particular—still relies heavily on tedious manual exercises where high cognitive overhead kills motivation.
- As the diagram illustrates, CIB replaces that manual bottleneck with instant automated execution and game feedback.
Transition: With that motivation in mind, let's look at the three research questions guiding our pilot study.
-->

---

## 1.2 Research Objectives & Three Research Questions

We evaluate **Code Immunity Boost (CIB)** in a pilot study asking *"How do students learn by using the CIB tool?"* *(revealed step-by-step)*:

<div class="rq-stage">

* <div class="rq-card teal"><img src="./img/rq1_icon.svg" alt="RQ1 Test Case Productivity"><div><div class="rq-hook"><span class="rq-tag" style="background:#0f766e;">RQ1</span> Does gamified automation help students write more &amp; better test cases?</div><div class="rq-q"><strong>How does CIB affect test case submission volume and valid test case construction</strong> compared with traditional manual handwriting?</div></div></div>
* <div class="rq-card accent"><img src="./img/rq2_icon.svg" alt="RQ2 Instant Feedback Dynamics"><div><div class="rq-hook"><span class="rq-tag">RQ2</span> Why do automated players submit more invalid attempts—and is that good?</div><div class="rq-q"><strong>How does CIB's instant automated feedback shape invalid submission rates</strong> and iterative trial-and-error learning across difficulty levels?</div></div></div>
* <div class="rq-card"><img src="./img/rq3_icon.svg" alt="RQ3 Motivation and Satisfaction"><div><div class="rq-hook"><span class="rq-tag" style="background:#1b365d;">RQ3</span> Do students stay motivated, focused, and confident in applying mutation testing?</div><div class="rq-q"><strong>How does CIB impact Motivation (Q1), Attention (Q2), and Learning Performance (Q3)</strong> on a 5-point Likert questionnaire?</div></div></div>

</div>

<!--
Key Takeaway: Our pilot study investigates how CIB affects test productivity (RQ1), trial-and-error feedback dynamics (RQ2), and student motivation and learning outcomes (RQ3).
Talking Points:
- RQ1 measures whether automated gamification helps novices write more total and valid test cases than paper-based handwriting.
- RQ2 unpacks an intriguing pattern: why automated learners submit more invalid attempts, and how instant feedback turns those errors into productive iteration.
- RQ3 evaluates students' Motivation, Attention, and self-reported Learning Performance via a 5-point Likert survey.
Transition: Before introducing the game, let's briefly review how mutation testing and the Mutation Score work.
-->

---

## 2.1 Background: How Mutation Testing Works

<div class="fig-box" style="padding: 8px 12px; margin-bottom: 10px;">
<img src="./img/diag2_mutation_cycle.svg" alt="Mutation Testing Execution Cycle" style="max-height: 270px;">
</div>

<div class="formula-strip">
<div class="formula-box">
<i>ms</i> &nbsp;=&nbsp; <span class="frac"><span class="frac-num"><i>killed</i></span><span class="frac-den"><i>all</i> − <i>equiv</i></span></span> &nbsp; ∈ [0.0, 1.0]
</div>
<div class="callout" style="margin-top: 0;">
<strong>Mutation Score (ms):</strong> Ratio of killed mutants to non-equivalent mutants [17]. <strong>Equivalent mutants</strong> preserve original program behavior and cannot be killed. Higher <code>ms</code> ➔ stronger error-detecting test suite.
</div>
</div>

<!--
Key Takeaway: Mutation testing evaluates test suite strength by injecting small faults (mutants) and measuring the Mutation Score (ms).
Talking Points:
- As shown in the cycle diagram, we take an original program, generate slightly modified mutants, and run the student's test suite against both.
- If a test produces a different output on a mutant, that mutant is "killed"; otherwise it survives.
- The Mutation Score equals killed mutants divided by all non-equivalent mutants, ranging from 0.0 to 1.0, where higher scores mean stronger fault-detection power.
Transition: Now let's compare CIB against existing gamified tools, especially Code Defenders.
-->

---

## 2.2 Related Work: Code Defenders & Research Gap

While **Code Defenders** [16, 18, 19] pioneered gamified mutation testing via 2-player *Attacker vs. Defender* competition, classroom adoption faces practical barriers:

| Learning Approach | Play Mode | Difficulty Control | Feedback Mechanism | Key Limitation / Advantage |
| :--- | :--- | :--- | :--- | :--- |
| **Manual Handwriting** | Solo paper-based | Unstructured | Manual tracing & calculation | Extreme workload; students lose motivation on complex programs |
| **Code Defenders [16, 18, 19]** | 2-player (Attacker vs. Defender) + AI mode | No explicit quantitative difficulty index | Competitive round scoring | Large **skill gap** between paired students frustrates weaker side; AI mode cannot fully replace 2-player balance |
| **Our Approach: CIB + CVI** | **Structured Solo Progression** | **Fragility-calibrated 4-tier levels** | **Instant automated Python runner & Immunity bar** | **Self-paced, vaccine-themed mission with dual roles & automated CVI mutant pool** |

<div class="callout teal">
<strong>Research Gap Addressed:</strong> CIB eliminates peer skill-mismatch by pairing an automated mutant pool (<strong>CVI</strong>) with an explicit, quantitative difficulty index (<strong>mutant fragility</strong>) for smooth solo progression.
</div>

<!--
Key Takeaway: CIB overcomes Code Defenders' peer skill-mismatch problem by offering structured solo progression with fragility-calibrated difficulty levels.
Talking Points:
- Code Defenders pioneered two-player Attacker-versus-Defender mutation testing, but in real classrooms a wide skill gap between paired students often frustrates the weaker partner.
- Its AI mode also lacks an explicit quantitative difficulty index to guide novices smoothly from easy to hard tasks.
- Our approach pairs CIB with CVI, an automated mutant pool calibrated by mutant fragility, enabling self-paced solo mastery.
Transition: Let's see how we translated these mechanics into an intuitive immune-system metaphor.
-->

---

## 3.1 Game Metaphor: Vaccine, Leukocyte & Human Body

<div class="split55">
<div class="left">

<div class="fig-box">
<img src="./img/fig1_analogy.png" alt="Fig. 1: Program, test case and mutant analogy" style="max-height: 410px;">
<div class="fig-cap">Fig. 1: Biological immune-system analogy for mutation testing</div>
</div>

</div>
<div class="right small-text">

### 🧬 Immune Defense = Software Quality
- **Human Body ⇄ Program**: The system whose resilience we aim to protect and strengthen.
- **Vaccine ⇄ Mutant**: A controlled, weakened fault injected to train defenses.
- **Leukocyte ⇄ Test Case**: Immune defender that detects and kills invading mutants.
- **Pathogen ⇄ Real Error**: Bugs prevented once test cases are upgraded.

<div class="formula-box teal" style="margin-top: 8px; padding: 7px 12px; font-size: 0.9em;">
<strong>Immunity</strong> &nbsp;=&nbsp; Mutation Score (<i>ms</i>)
</div>
<div class="formula-box accent" style="margin-top: 7px; padding: 7px 12px; font-size: 0.9em;">
<strong>Vaccine Efficacy</strong> &nbsp;=&nbsp; 1 − <i>fragility</i>
</div>

</div>
</div>

<!--
Key Takeaway: CIB maps core mutation testing concepts directly onto an immune-system analogy so novices grasp metrics intuitively.
Talking Points:
- In Figure 1, the Human Body represents the program under test, Vaccines represent injected mutants, and Leukocytes represent test cases that detect and neutralize them.
- Real software bugs act as Pathogens that the strengthened immune system prevents.
- Crucially, the two formulas map directly to game scores: Immunity equals Mutation Score (ms), and Vaccine Efficacy equals 1 minus fragility.
Transition: Beyond the metaphor, let's examine the Octalysis gamification drives and benchmark suite behind CIB.
-->

---

## 3.2 Gamification Core: Three Octalysis Drives & Benchmark Suite

CIB embeds **three core drives from the Octalysis gamification framework** to sustain intrinsic and extrinsic motivation:

<div class="three-col">
<div class="card small-text">

### 🌍 1. Epic Meaning
- Set in a world facing raging pathogens (inspired by COVID-19).
- Students develop vaccines (mutants) and train leukocytes (test cases) to protect programs—giving exercises a **sense of mission**.

</div>
<div class="card teal small-text">

### 🏆 2. Accomplishment
- **Immunity** (`ms`) and **Vaccine Efficacy** (`1 − fragility`) serve as clear status points.
- Visual **progress bars** exploit incomplete graphics to motivate filling targets and earning higher ranks.

</div>
<div class="card accent small-text">

### 🎭 3. Empowerment
- Students play **two complementary roles** (*Leukocyte* & *Vaccine*).
- Open-ended test & mutant authoring lets learners apply creativity and iterate on strategy.

</div>
</div>

<div class="card" style="margin-top: 12px; padding: 10px 16px;">
<div style="font-size: 0.8em; color: var(--slate-700);"><strong style="color: var(--navy);">🧪 Benchmark Suite &amp; Code Vaccine Incubator (CVI):</strong> We built <strong>CVI</strong> to generate large mutant pools across 7 classic mutation-testing benchmarks [20]:</div>
<div class="chip-row">
<span class="chip">Triangle</span>
<span class="chip">Computing the Median</span>
<span class="chip">Euclidean GCD</span>
<span class="chip">Fibonacci Search</span>
<span class="chip">Binary Search</span>
<span class="chip">Interpolation Search</span>
<span class="chip">Leap Year</span>
</div>
</div>

<!--
Key Takeaway: CIB embeds three Octalysis core drives—Epic Meaning, Accomplishment, and Empowerment—across seven classic mutation-testing benchmarks.
Talking Points:
- Inspired by the COVID-19 era, Epic Meaning frames testing as a vaccine-development mission rather than a dry homework sheet.
- Accomplishment uses Immunity progress bars and rankings to motivate students to push past minimum thresholds, while Empowerment lets them play both Leukocyte and Vaccine roles.
- To power these levels, our Code Vaccine Incubator (CVI) generates mutant pools across seven classic benchmarks, from Triangle and GCD to Binary and Interpolation Search.
Transition: Let's look at how these benchmarks are organized into progressive difficulty tiers.
-->

---

## 3.3 Progressive Level Design & Difficulty Calibration

<div class="split64">
<div class="left">

<div class="fig-box">
<img src="./img/fig2_levels.png" alt="Fig. 2: CIB Level Selection Screenshot" style="max-height: 400px;">
<div class="fig-cap">Fig. 2: CIB progressive level screen with ranking, difficulty &amp; thresholds</div>
</div>

</div>
<div class="right small-text">

### 🎯 Fragility-Based 4-Tier Difficulty
- Unlike arbitrary solo modes, CIB calibrates level difficulty using **mutant fragility** across 4 tiers:
  - `Easy` ➔ `Medium` ➔ `Hard` ➔ `Difficult`
- **Unlock Progression**:
  1. **Rank & Lock Status**: Cleared levels display star rankings (e.g., `S` rank); uncleared levels show a lock icon.
  2. **Level Metadata**: Shows level number, benchmark program, and difficulty badge.
  3. **Dual Thresholds**:
     - **Basic Condition**: Minimum mutation score to pass & unlock the next level (e.g., `≥ 50%`).
     - **Better Condition**: Stretch goal (e.g., `≥ 70%–80%`) for bonus points and mastery.

</div>
</div>

<!--
Key Takeaway: CIB calibrates four progressive difficulty tiers using mutant fragility and motivates mastery through dual pass thresholds.
Talking Points:
- Figure 2 shows the level selection screen, where cleared stages earn star ranks such as S while locked stages await progression.
- Instead of arbitrary ordering, levels scale from Easy to Difficult based on quantitative mutant fragility.
- Each level defines a Basic Condition (such as 50% mutation score) to unlock the next stage, plus a Better Condition (70% to 80%) for stretch-goal bonus points.
Transition: Let's walk through a concrete round of playing the Leukocyte role inside CIB.
-->

---

## 3.4 Gameplay Walkthrough: Playing the Leukocyte Role

<div class="split55">
<div class="left">

<div class="fig-box">
<img src="./img/fig3_leukocyte_ui.png" alt="Fig. 3: Screen of playing leukocyte" style="max-height: 330px;">
<div class="fig-cap">Fig. 3: CIB Leukocyte UI — (1) Original Code, (2) Mutants, (3) Test Editor</div>
</div>

<div class="callout teal" style="font-size: 0.78em; margin-top: 8px;">
<strong>Tech Stack:</strong> Built on <strong>Python</strong> &amp; the standard <code>unittest</code> framework—students inspect the original code and mutants side-by-side and submit live unit tests.
</div>

</div>
<div class="right small-text">

### 🛡️ Example Scenario (10 Mutants: m<sub>1</sub>–m<sub>10</sub>)
- **Pass (Basic)**: Kill ≥ 5 mutants (`Immunity ≥ 0.5`).
- **High Points (Better)**: Kill ≥ 8 mutants (`Immunity ≥ 0.8`).

| Round | Test Case | Killed Mutants | Immunity | Result |
| :---: | :---: | :--- | :---: | :---: |
| 1 | `t1` | m<sub>1</sub>, m<sub>2</sub> | `0.2` | Not Pass |
| 2 | `t2` | m<sub>1</sub>, m<sub>3</sub>–m<sub>6</sub> | `0.5` | **Pass** |
| 3 | `t3` | m<sub>1</sub>–m<sub>8</sub> | **`0.8`** | **Pass (High Pts)** |

- **Iterative Learning**: Immediate mutant-kill feedback guides students from `0.2` ➔ `0.5` ➔ `0.8` without manual output tracing.

</div>
</div>

<!--
Key Takeaway: Instant mutant-kill feedback lets students iteratively strengthen their Python unittest suite without manual output tracing.
Talking Points:
- In Figure 3, the Leukocyte interface displays the original code, the mutants, and a Python unittest editor side by side.
- Take a 10-mutant level requiring 0.5 Immunity to pass and 0.8 for high points: Round 1 kills only 2 mutants (0.2, Not Pass), Round 2 reaches 0.5 (Pass), and Round 3 kills 8 mutants for 0.8 (High Points).
- Students immediately see which mutants survived and refine their assertions in seconds.
Transition: Under the hood, six modular components make this rapid feedback loop possible.
-->

---

## 3.5 CIB System Architecture & Six Core Modules

<div class="split55">
<div class="left">

<div class="fig-box">
<img src="./img/fig4_architecture.png" alt="Fig. 4: The architecture of Code Immunity Boost" style="max-height: 400px;">
<div class="fig-cap">Fig. 4: System architecture of Code Immunity Boost (CIB)</div>
</div>

</div>
<div class="right small-text">

### ⚙️ Six Interconnected Modules
1. **Code Editor**: Front-end editor for authoring Python `unittest` test cases or custom mutants.
2. **Code Runner**: Compiles & executes submitted code, routing outputs to `Metrics Computer` and syntax/runtime **Error Messages** back to the user.
3. **Metrics Computer**: Executes mutation testing to compute **Mutation Score** (test cases) and **Fragility** (mutants).
4. **Game Manager**: Feeds level info to the UI, computes game scores, and checks Basic/Better pass conditions.
5. **Code Database**: Stores and manages user-defined test cases and mutants.
6. **Game Database**: Persists levels, CVI mutant pools, and player progress.

</div>
</div>

<!--
Key Takeaway: CIB's architecture connects six dedicated modules to automate code execution, metric computation, and game progression.
Talking Points:
- As shown in Figure 4, students submit Python unittest code or mutants via the Code Editor, which sends them to the Code Runner for compilation and execution.
- Syntax or runtime errors return immediately to the learner, while valid runs pass to the Metrics Computer to compute Mutation Score and Fragility.
- Finally, the Game Manager evaluates pass thresholds and updates the UI, backed by separate Code and Game Databases.
Transition: With the system built, let's examine how we designed our pilot experiment to evaluate it.
-->

---

## 4.1 Pilot Experiment Setup

Before a full-scale classroom deployment, we conducted a **pilot experiment** to evaluate feasibility, test-writing performance, and student perception.

<div class="three-col">
<div class="card small-text">

### 👥 Participants
- **10 university students** (3 female, 7 male).
- Department of Information Engineering, **Feng Chia University**.
- **Zero prior exposure** to mutation testing before the study.

</div>
<div class="card teal small-text">

### ⚖️ Controlled Grouping
- **Experimental Group (CIB)**: Designed Python `unittest` cases inside CIB with automated mutant execution & instant feedback.
- **Control Group (Handwriting)**: Learned mutation testing manually by handwriting tests, simulating mutant outputs, and computing `ms`.

</div>
<div class="card accent small-text">

### 📊 Tasks & Survey
- **Evaluated Benchmarks**: `Euclidean GCD`, `Interpolation Search`, and `Triangle` (increasing difficulty).
- **Survey Instrument**: 11-item **5-point Likert questionnaire** adapted from Barrio [21] covering Motivation, Attention, and Learning Outcome.

</div>
</div>

<div class="callout" style="margin-top: 12px;">
<strong>Analysis Method:</strong> Because this pilot study focuses on validating tool usability and learning dynamics with `N = 10` novices, we report <strong>descriptive statistics</strong>, submission boxplots, valid/invalid breakdowns, and Likert comparisons.
</div>

<!--
Key Takeaway: Our pilot study compared CIB against manual handwriting with 10 mutation-testing novices across three progressively harder benchmarks.
Talking Points:
- Ten IECS undergraduates at Feng Chia University with zero prior mutation testing exposure were split into an Experimental group using CIB and a Control group using paper handwriting.
- Both groups worked through Euclidean GCD, Interpolation Search, and Triangle, followed by an 11-item 5-point Likert questionnaire adapted from Barrio.
- Given the pilot sample size of N = 10, we focus on descriptive statistics, submission distributions, and qualitative classroom observations.
Transition: Let's look at the first striking result for RQ1: test case submission volume.
-->

---

## 4.2 RQ1 Results: Dramatic Surge in Test Case Submissions

<div class="split55">
<div class="left">

<div class="fig-box">
<img src="./img/fig5_submissions.png" alt="Fig. 5: Number of test cases submission" style="max-height: 385px;">
<div class="fig-cap">Fig. 5: Total test case submissions across benchmarks (Control vs. CIB)</div>
</div>

</div>
<div class="right small-text">

### 📈 Table II: Submitted Test Cases by Group

| Group | All | GCD | Search | Triangle |
| :--- | :---: | :---: | :---: | :---: |
| Control (Handwriting) | 18 | 11 | 4 | 3 |
| **Experimental (CIB)** | **152** | **13** | **34** | **105** |

<div class="two-col" style="gap: 10px; margin-top: 8px;">
<div class="kpi-card teal">
<div class="kpi-val">8.4×</div>
<div class="kpi-label">Total submissions (<strong>152 vs. 18</strong>; avg 30.4 vs. 3.6 per task)</div>
</div>
<div class="kpi-card">
<div class="kpi-val">3.1×</div>
<div class="kpi-label"><strong>Valid</strong> test cases constructed (<strong>25 vs. 8</strong> overall)</div>
</div>
</div>

- **Why the gap widens**: Manual simulation breaks down as program logic grows complex (`Triangle`: **105 vs. 3**).

</div>
</div>

<!--
Key Takeaway: CIB students submitted 8.4 times more total test cases and constructed 3.1 times more valid test cases than the handwriting group.
Talking Points:
- Table II and Figure 5 show 152 total submissions in CIB versus only 18 in the Control group, alongside 25 valid test cases versus 8 overall.
- Notice how the gap explodes with problem complexity: on GCD it is 13 versus 11, on Interpolation Search 34 versus 4, and on Triangle 105 versus just 3.
- Manual output tracing simply collapses once branching logic grows complex.
Transition: Next, let's examine RQ2 to understand why CIB also produced more invalid submissions.
-->

---

## 4.3 RQ2 Results: Valid vs. Invalid Submissions & Trial-and-Error

<div class="split55">
<div class="left">

<div class="fig-box">
<img src="./img/fig6_invalid.png" alt="Fig. 6: Number of invalid test cases" style="max-height: 385px;">
<div class="fig-cap">Fig. 6: Invalid test case submissions across benchmarks</div>
</div>

</div>
<div class="right small-text">

### 🔄 The Productive Trial-and-Error Paradox
- **More Valid Tests**: Experimental group produced **25 valid** test cases vs. only **8** for Control.
- **Higher Invalid Rate**: CIB's proportion of invalid (uncompilable/failing) submissions was also higher.
- **Root Cause — Instant Feedback Loop**:
  - When `Code Runner` returns an immediate error message, CIB students rapidly tweak and resubmit—even when intermediate fixes remain invalid.
  - Rather than a flaw, this rapid cycle represents **healthy trial-and-error learning** in test design.
- **Difficulty Cliff in Control Group**: On harder tasks (`Interpolation Search` & `Triangle`), Control group valid & invalid submissions both **collapsed near 0**.

</div>
</div>

<!--
Key Takeaway: CIB's higher invalid submission rate reflects healthy, rapid trial-and-error debugging driven by instant error feedback.
Talking Points:
- Figure 6 shows that CIB learners submitted more uncompilable or failing attempts alongside their 25 valid tests.
- Rather than a drawback, this happens because Code Runner immediately surfaces syntax and assertion errors, prompting students to tweak and resubmit rapidly until tests succeed.
- By contrast, on Search and Triangle, the Control group hit a difficulty cliff where both valid and invalid submissions dropped near zero.
Transition: Now let's turn to RQ3 and see how students rated Motivation and Attention on the survey.
-->

---

## 4.4 RQ3 Results: Motivation (Q1) & Attention (Q2) Survey

Students rated 11 items on a **5-point Likert scale** (`*` = CIB-only questions comparing gamification against traditional teaching):

<div class="two-col">
<div class="card teal small-text">

### 🔥 Table IV: Motivation (Q1)

| Item | Description (Short) | Ctrl | **Exp** |
| :--- | :--- | :---: | :---: |
| `Q1-1` | Like this way of learning | 3.50 | **4.50** |
| `Q1-2` | Makes me more aware of MT | 3.50 | **4.83** |
| `Q1-3` | Want to go deeper into MT | 3.00 | **4.17** |
| `Q1-4*` | Level design increases motivation | — | **4.33** |
| `Q1-5*` | Prefer over traditional teaching | — | **4.67** |

</div>
<div class="card small-text">

### 🎯 Table V: Attention (Q2)

| Item | Description (Short) | Ctrl | **Exp** |
| :--- | :--- | :---: | :---: |
| `Q2-1` | Few distractions / concentrate well | 3.50 | **4.17** |
| `Q2-2` | High-intensity cognitive thinking | **4.50** | **4.50** |
| `Q2-3` | Actively participating in process | 4.50 | **4.83** |

<div class="callout" style="font-size: 0.9em; margin-top: 10px;">
<strong>Nuance on Q2-2:</strong> Manual handwriting forced heavy cognitive tracing (4.50), but the tedious computation severely hurt concentration (<code>Q2-1: 3.50</code>) and killed deeper interest (<code>Q1-3: 3.00</code>).
</div>

</div>
</div>

<!--
Key Takeaway: CIB substantially boosted student Motivation and classroom concentration while maintaining high cognitive engagement.
Talking Points:
- In Table IV, CIB outscored handwriting on every shared Motivation item, including awareness of mutation testing (4.83 vs. 3.50) and desire to explore further (4.17 vs. 3.00), with 4.67 preferring CIB over traditional teaching.
- In Table V, both groups reported equally high cognitive thinking on Q2-2 (4.50), but tedious manual calculations hurt the Control group's concentration (Q2-1: 3.50 vs. 4.17).
Transition: Let's look at self-reported Learning Performance and the qualitative contrast between both groups.
-->

---

## 4.5 RQ3 Results: Learning Performance (Q3) & Qualitative Findings

<div class="two-col">
<div class="card small-text">

### 🎓 Table VI: Learning Performance (Q3)

| Item | Question | Ctrl | **Exp** |
| :--- | :--- | :---: | :---: |
| `Q3-1` | Understand mutation testing approach | **4.75** | 4.67 |
| `Q3-2` | Can apply mutation testing technique | 4.00 | **4.33** |
| `Q3-3*` | Better learning effect than traditional | — | **4.83** |

<div style="margin-top: 12px;">
<div class="bar-row"><span><strong>Q1 Avg (Shared)</strong></span><div class="bar-track"><div class="bar-fill teal" style="width:90%;"></div></div><span class="bar-pct">4.50 vs 3.33</span></div>
<div class="bar-row"><span><strong>Q2 Avg (All 3)</strong></span><div class="bar-track"><div class="bar-fill" style="width:90%;"></div></div><span class="bar-pct">4.50 vs 4.17</span></div>
<div class="bar-row"><span><strong>Q3 Avg (Shared)</strong></span><div class="bar-track"><div class="bar-fill accent" style="width:90%;"></div></div><span class="bar-pct">4.50 vs 4.38</span></div>
</div>

</div>
<div class="card teal small-text">

### 💬 Qualitative Classroom Takeaways
- **Shared Conceptual Grasp**: Both groups understood mutation testing basics (`Q3-1`: 4.75 vs. 4.67), showing manual tracing still builds conceptual memory.
- **Divergent Student Reactions**:
  - **Control Group**: Felt overwhelmed by handwriting workload and **asked to reduce the number of mutants** to ease manual execution.
  - **Experimental Group**: Never felt the mutant pool was too large—instead expressed strong enthusiasm for CIB (`Q3-3* = 4.83`) and **wanted to tackle even harder levels**.
- **Applied Skill Edge**: CIB students reported higher confidence in *applying* mutation testing (`Q3-2`: **4.33** vs. 4.00).

</div>
</div>

<!--
Key Takeaway: Both groups grasped basic concepts, but CIB gave students stronger applied confidence and enthusiasm for harder challenges.
Talking Points:
- In Table VI, both groups scored high on conceptual understanding (Q3-1: 4.75 vs. 4.67), showing manual tracing still builds conceptual memory.
- However, CIB students felt more confident applying mutation testing (Q3-2: 4.33 vs. 4.00) and strongly rated CIB's learning effect above traditional teaching (Q3-3*: 4.83).
- Qualitatively, Control students asked to reduce the number of mutants due to fatigue, whereas CIB students never complained about volume and actively wanted harder levels.
Transition: Let's wrap up with a visual summary of our findings and future research directions.
-->

---

## 5. Conclusion & Future Work

<div class="fig-box" style="padding: 8px 10px; margin-bottom: 8px;">
<img src="./img/diag3_rq_conclusions.svg" alt="Visual Synthesis of CIB RQ1-RQ3 Conclusions" style="max-height: 355px;">
</div>

<div class="future-strip">
<div class="future-pill"><strong>🌐 1. Online Judge Integration</strong><br>Embed CIB &amp; CVI into popular Online Judge platforms so students practice testing alongside coding assignments.</div>
<div class="future-pill"><strong>📊 2. Larger Controlled Studies</strong><br>Scale beyond the 10-student pilot to full university cohorts with inferential statistics &amp; longitudinal retention tests.</div>
<div class="future-pill"><strong>🧩 3. Expanded Roles &amp; Languages</strong><br>Evaluate the Vaccine-authoring role deeply and extend CVI beyond Python <code>unittest</code> to Java/C++ curricula.</div>
</div>

<!--
Key Takeaway: CIB successfully makes mutation testing engaging and scalable for novices, paving the way for Online Judge integration and larger cohorts.
Talking Points:
- The visual summary captures our three takeaways: 8.4x higher submission activity (RQ1), productive instant-feedback trial-and-error (RQ2), and strong gains in motivation, focus, and applied confidence (RQ3).
- Looking ahead, we plan to embed CIB and CVI into Online Judge platforms, run larger controlled classroom studies with inferential statistics, and expand beyond Python to Java and C++ while evaluating the Vaccine-authoring role.
Transition: Thank you for listening—let's move to the closing slide for questions and discussion.
-->

---

<!-- _class: closing -->

# Thank You for Your Attention!

<p style="font-size: 1.05em; max-width: 840px;">
Design and Implementation of Gamified Learning System for Mutation Testing (Code Immunity Boost)
</p>

<div class="contact-card">
<strong>Nien-Lin Hsueh*</strong> · <code>nlhsueh@fcu.edu.tw</code><br>
<strong>Zeng Hung Xuan</strong> &nbsp;·&nbsp; <strong>Bilegjargal Daramsenge</strong><br>
Department of Information Engineering and Computer Science, Feng Chia University, Taiwan<br>
IJIET Vol. 13, No. 7, pp. 1150–1155, July 2023 · DOI: <code>10.18178/ijiet.2023.13.7.1916</code><br>
<span style="font-size: 0.85em; opacity: 0.85;">Grant: MOST 110-2221-E-035-031-MY2 · Questions &amp; Discussion Welcome!</span>
</div>

<!--
Key Takeaway: Thank the audience and invite questions on CIB's design, fragility calibration, or classroom deployment.
Talking Points:
- Thank you very much for your attention. Feel free to reach out via email or check our IJIET 2023 paper for full details.
- I would be happy to answer any questions about Code Immunity Boost, our mutant generator CVI, or our plans for Online Judge integration.
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
