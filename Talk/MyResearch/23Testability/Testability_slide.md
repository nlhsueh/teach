---
marp: true
theme: gaia
size: 16:9
paginate: true
html: true
header: '<div class="hdr-wrap"><span class="hdr-title">Pytutor: Online Programming Platform & Learners’ Testing Ability</span><div class="hdr-actions"><a class="lang-btn" href="./Testability_slide_zh.html" title="切換至繁體中文簡報">🌐 繁</a><div class="nav-dropdown"><button class="nav-btn">Sections ▾</button><div class="nav-menu"><a href="#2">Opening Hook: Blind Submit vs. DTC</a><a href="#3">Outline</a><a href="#4">1. Introduction & RQs</a><a href="#6">2. Related Work</a><a href="#7">3. Pytutor & SE Indicators</a><a href="#11">4. Experiment & RQ1–RQ3</a><a href="#17">5. Comparison & Implications</a><a href="#19">6. Conclusion & Future Work</a></div></div></div></div>'
footer: 'Nien-Lin Hsueh, Lien-Chi Lai & Wei-Hsiang Tseng · Feng Chia University · Electronics 2023, 12(22), 4596'
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
.four-col { display: grid; grid-template-columns: repeat(4, 1fr); gap: 12px; align-items: stretch; }
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
  padding: 10px 14px;
  box-sizing: border-box;
}

.kpi-card.accent { border-left-color: var(--accent); background: var(--accent-soft); }
.kpi-card.teal { border-left-color: var(--teal); background: var(--teal-soft); }

.kpi-val { font-size: 1.36em; font-weight: 800; color: var(--navy); line-height: 1.15; margin-bottom: 3px; }
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
  grid-template-columns: 1fr 1fr;
  gap: 12px;
  margin-bottom: 10px;
}

.formula-strip-3 {
  display: grid;
  grid-template-columns: 1fr 1fr 1.15fr;
  gap: 10px;
  margin-bottom: 10px;
}

.formula-box {
  background: #f8fafc;
  border: 1.5px solid #cbd5e1;
  border-left: 4px solid var(--navy);
  border-radius: 8px;
  padding: 7px 12px;
  display: flex;
  justify-content: center;
  align-items: center;
  font-family: 'Georgia', 'Times New Roman', serif;
  font-size: 0.88em;
  color: var(--slate-900);
}

.formula-box.teal { border-left-color: var(--teal); background: var(--teal-soft); }
.formula-box.accent { border-left-color: var(--accent); background: var(--accent-soft); }

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

<div class="badge">Electronics 2023, 12(22), 4596 · Software Engineering Education</div>

# Design of an Online Programming Platform and a Study on Learners’ Testing Ability

<div class="subtitle">
<strong>Pytutor</strong>: Integrating Software-Testing Concepts, Defining Test Cases (DTCs), Code Coverage &amp; Mutation Testing into Automated Programming Education
</div>

<div class="meta-box">
<strong>Nien-Lin Hsueh*</strong>, <strong>Lien-Chi Lai</strong>, and <strong>Wei-Hsiang Tseng</strong><br>
Department of Information Engineering and Computer Science, Feng Chia University, Taichung 407, Taiwan<br>
<code>nlhsueh@fcu.edu.tw</code> · DOI: <code>10.3390/electronics12224596</code>
</div>

<div class="grant">
Published: 10 November 2023 (MDPI Electronics) · Funded by the National Science and Technology Council (NSTC), Taiwan R.O.C., under grant MOST112-2813-C-035-075-E.
</div>

<!--
Bibliographic & Research Overview:
This article (Hsueh, Lai, & Tseng, Electronics 2023, 12(22), 4596; published 10 November 2023; funded by NSTC grant MOST112-2813-C-035-075-E) presents the design of Pytutor, a testing-aware Online Judge (OJ) platform, and an empirical investigation of novice learners' programming ability, software-testing ability, and online learning behaviors.

Clarification & Scope:
- Note on Naming (Section 1): Although Pytutor shares a similar name with the well-known code-visualization website Python Tutor (pythontutor.com), the two systems are completely distinct; Pytutor is a full Online Judge system designed around learner-authored Defining Test Cases (DTCs).
- Core Contribution: Combines software engineering metrics (cyclomatic complexity, branch coverage, mutation testing) with cross-platform behavioral telemetry (Pytutor exercise logs + OpenEdu video logs) across a 7-week Python course enrolling both Computer Science (CS) and Non-CS undergraduates.
-->

---

## Opening Hook: "Looks Fine, Send It!" ... Or Did You Test Your Code?

<div class="fig-box" style="padding: 6px; margin-bottom: 10px; background: #fbf9f2;">
<img src="./img/testability_hook.jpg" alt="Traditional OJ Blind Submit vs Pytutor Write Your Own Tests" style="max-height: 415px; border-radius: 6px;">
</div>

<div class="callout" style="margin-top: 6px; padding: 9px 16px;">
<strong>The Big Idea:</strong> Traditional Online Judges grade code with hidden tests alone — and <strong>23% of submissions are sent blindly without a single test</strong>. <strong>Pytutor</strong> embeds <strong>Defining Test Cases (DTCs)</strong>, branch coverage, and mutation testing to cultivate and measure learners' software-testing ability.
</div>

<!--
Empirical Motivation & Central Finding (Table 1):
This opening contrast highlights a pervasive behavioral flaw documented in Section 4.5.1 (Table 1) of the paper:
- Blind Submission Rate (23%): Even under a punitive Cautionary Principle that deducts 3 points per formal submission, learners formally submitted 23% of exercise attempts without executing a single Open Test Case (OTC) or Defining Test Case (DTC) beforehand.
- Under-Utilization of Self-Testing: Learners executed at least one OTC before submission in 59% of exercises, and authored/ran at least one custom DTC in only 44% of exercises, resulting in an average of 1.43 formal submissions per problem.
- Design Intervention: Conventional OJs evaluate code exclusively via hidden test suites, inadvertently training novices to use the grader as a trial-and-error oracle. Pytutor embeds DTC authoring, branch coverage, and mutation testing directly into the practice loop to cultivate and measure software-testing ability.
-->

---

## Presentation Outline

<div class="outline-grid">

<div class="outline-item">
<div class="outline-num">1</div>
<div class="outline-body">

[**Introduction & Research Questions**](#4)
Why traditional Online Judges overlook software testing and our three RQs (RQ1–RQ3).

</div>
</div>

<div class="outline-item">
<div class="outline-num">2</div>
<div class="outline-body">

[**Related Work & Research Gap**](#6)
Survey of educational OJ platforms and automated testing assessment systems.

</div>
</div>

<div class="outline-item">
<div class="outline-num">3</div>
<div class="outline-body">

[**Pytutor Platform & SE Indicators**](#7)
Django + Docker sandbox, OTC / DTC / HTC workflow, Resilience (<i>r</i>), PAI, and TEI.

</div>
</div>

<div class="outline-item">
<div class="outline-num">4</div>
<div class="outline-body">

[**Experiment & RQ1–RQ3 Results**](#11)
7-week Python course (61 active learners, 50 exercises), group comparisons & correlations.

</div>
</div>

<div class="outline-item">
<div class="outline-num">5</div>
<div class="outline-body">

[**Comparison, Limitations & Pedagogy**](#17)
Alignment with Yang et al. (2020), study threats, and course design recommendations.

</div>
</div>

<div class="outline-item">
<div class="outline-num">6</div>
<div class="outline-body">

[**Conclusion & Future Work**](#19)
Visual synthesis of RQ1–RQ3 findings and roadmap for AI-assisted programming education.

</div>
</div>

</div>

<!--
Paper Structure & Section Mapping:
The 25-page article is organized into six sections:
1. Introduction (Section 1): Contrasts competition-oriented vs. educational OJs (Wasik [5]), reviews evidence linking testing to code reliability [7–11], introduces Pytutor, and defines RQ1–RQ3.
2. Related Work (Section 2): Surveys three threads: importance of software-testing ability [10, 12–15], automated programming assessment platforms [16–24], and test-case quality / testing education systems [13, 25–29].
3. Methods (Section 3): Details Pytutor's Django MVT architecture (Fig. 1), UI (Figs. 2–3), Docker sandbox security [30–33], learner workflow (Fig. 4), and mathematical definitions of Resilience r, PAI, TQI, TQI+, and TEI (Equations 1–6, Figs. 5–7).
4. Experiment (Section 4): Describes the 7-week asynchronous OpenEdu + Pytutor course (64 videos, 50 exercises, Fig. 8), participant demographics (69 enrolled, 61 active), data sources, and descriptive statistics (Tables 1–2, Fig. 9).
5. Discussion (Section 5): Answers RQ1 (four ability quadrants, Fig. 10), RQ2 (CS vs. Non-CS, formative, and summative Mann-Whitney U tests, Figs. 11–16), RQ3 (Spearman correlations, Figs. 17–18), comparison with Yang et al. [11], and study limitations.
6. Conclusions & Future Work (Section 6): Summarizes pedagogical takeaways and outlines AI virtual tutoring, enhanced web IDE telemetry, and controlled experiments.
-->

---

## 1.1 Motivation: Why Traditional Online Judges Miss Software Testing

<div class="fig-box" style="padding: 10px 12px; margin-bottom: 10px;">
<img src="./img/diag1_oj_vs_pytutor.svg" alt="Traditional OJ vs Pytutor Testing-Aware Online Judge" style="max-height: 365px;">
</div>

<div class="callout">
<strong>Why Testing Ability Matters:</strong> Software testing helps learners clarify specifications and write more reliable code (Lemos et al., 2018; Fidge &amp; Hogan, 2013). Yet existing educational OJ systems evaluate <em>code correctness only</em>, ignoring learners' ability to design effective test cases.
</div>

<!--
Theoretical Grounding & Pedagogical Rationale:
- Role of Online Judges: Educational OJs accelerate feedback, reduce grading overhead, improve learning outcomes, and lower dropout rates (Pereira et al. [4]). Wasik [5] distinguishes competition-oriented OJs (leaderboards, limited languages) from educational OJs (broader language support, gamification), while Fu et al. [6] demonstrated real-time learning analytics dashboards (VisOJ) for tracking student error distributions.
- Why Testing Ability Must Be Cultivated: Empirical studies consistently show that testing strengthens specification comprehension and code reliability: Lemos et al. [7] demonstrated positive impacts of testing education on code reliability; Buffardi & Edwards [8] found strong correlations between early testing quality/quantity and assignment grades; Spacco et al. [9] linked testing habits to improved coding practices; and Fidge & Hogan [10] framed testing ability as "understanding problems" vs. programming ability as "solving problems," noting that novices' testing skills lag substantially behind coding skills.
- Core Gap: Standard educational OJs only verify submitted code against hidden tests, offering neither practice opportunities nor quantitative evaluation for learner-authored test cases.
-->

---

## 1.2 Research Objectives & Three Research Questions

Using **Pytutor** alongside an asynchronous **OpenEdu** Python course, we investigate learners' software engineering abilities and online behaviors *(revealed step-by-step)*:

<div class="rq-stage">

* <div class="rq-card teal"><img src="./img/rq1_behavior.svg" alt="RQ1 Abilities and Behaviors"><div><div class="rq-hook"><span class="rq-tag" style="background:#0f766e;">RQ1</span> How do novices actually code, test, and watch course videos?</div><div class="rq-q"><strong>What is the performance of learners</strong> in terms of software engineering ability indicators (<i>r</i>, PAI, TEI) and online learning behaviors?</div></div></div>
* <div class="rq-card accent"><img src="./img/rq2_groups.svg" alt="RQ2 Group Differences"><div><div class="rq-hook"><span class="rq-tag">RQ2</span> Do CS majors automatically test better than Non-CS majors?</div><div class="rq-q"><strong>How do learners from different groups perform</strong> in programming ability and testing ability across academic major, formative, and summative assessments?</div></div></div>
* <div class="rq-card"><img src="./img/rq3_corr.svg" alt="RQ3 Correlations"><div><div class="rq-hook"><span class="rq-tag" style="background:#1b365d;">RQ3</span> Does writing better tests or watching more videos raise grades?</div><div class="rq-q"><strong>Is there a relationship between ability indicators and learning behavior</strong> (video completion, playback speed) and final learning outcomes?</div></div></div>

</div>

<!--
Operationalization of the Three Research Questions:
Conducted inside a real 7-week asynchronous Python course combining OpenEdu (video lectures) and Pytutor (coding exercises), the study investigates three progressive questions:
- RQ1 (Baseline SE Abilities & Online Behaviors): Quantifies learners' distribution across Resilience (r), Programming Ability Index (PAI), Testing Efficiency Index (TEI), four percentile-based ability quadrants (HPHT, HPLT, LPHT, LPLT), submission/testing frequencies, and OpenEdu video engagement (completion rate, playback speed).
- RQ2 (Group Comparisons Across Major & Assessment Types): Uses non-parametric Mann-Whitney U tests to evaluate whether CS majors (n = 26) differ from Non-CS majors (n = 35) in r, PAI, and TEI, and how these indicators separate median-split high vs. low performers in formative practice (50 exercises) versus summative assessment (40-minute timed exam).
- RQ3 (Correlational Structure): Applies Spearman's rank correlation across ability indicators, video-watching behaviors, and both formative and summative outcomes to uncover how study habits and testing practices relate to programming achievement.
-->

---

## 2. Related Work & Research Gap

While automated assessment tools accelerate grading and feedback, few combine **learner-authored test cases**, **mutation/coverage evaluation**, and **multi-platform behavior analytics**.

| Study / Platform | Primary Focus | Custom Tests (DTC) | Coverage & Mutation | Behavior & Video Logs | Target Learners |
| :--- | :--- | :---: | :---: | :---: | :--- |
| YOJ [16] / Sakai [17] | Automated assignment grading & resubmission | × | × | × | CS1 Beginners |
| Codeflex [20] / 2TSW [23] | Competitive / gamified programming practice | × | × | × | Undergraduates |
| Codespec [21] / Blockly [22] | Parsons / visual algorithm scaffolding | × | × | × | Novices |
| UnitJudge [29] / Selenium [27] | Unit-test feedback / online test scripting | Partial | × | × | Intermediate |
| Yang et al. (2020) [11] | Empirical PAI vs. TEI on 3 tasks (unit tests) | ✓ | ✓ | × | Experienced CS |
| **Pytutor (Ours, 2023)** | **Testing-aware OJ + 50 exercises + OpenEdu logs** | **✓** | **✓** | **✓** | **CS & Non-CS** |

<div class="callout">
<strong>Key Research Gap:</strong> Prior testing-ability studies focused on experienced CS undergraduates over 3 timed tasks. How <strong>novices across CS and Non-CS majors</strong> develop testing sensitivity across a full self-paced online course remains largely unexplored.
</div>

<!--
Positioning Pytutor Against Prior Educational Platforms & Studies:
- Automated Grading & Scaffolding Platforms: Early systems such as YOJ (Sun et al. [16]) and Sakai (Suleman [17]) automated grading and enabled iterative resubmission, leveraging formative feedback (Carless et al. [18], Malmi et al. [19]). Subsequent platforms added timed competition (Codeflex [20]), multi-modality scaffolding including Parsons and Faded Parsons problems (Codespec [21]), visual algorithm animation (Progressive Blockly [22]), and gamification (2TSW [23], Swacha [24], Code Defenders [15]). None evaluate learner-authored test suites via coverage and mutation analysis.
- Testing-Oriented Assessment Systems: Ala-Mutka [13], Vujosevic-Janicic et al. [25], and Montoya-Dato et al. [26] emphasized that weak test suites misjudge buggy code as correct. Jiang & Deng [27] built an online Selenium script practice tool, Kasahara et al. [28] gamified code quality, and UnitJudge (Garcia-Magarino et al. [29]) used unit tests to localize errors in longer assignments, but did not measure coverage/mutation efficiency of student-designed test inputs.
- Closest Benchmark (Yang et al., 2020 [11]): Evaluated programming vs. testing ability using coverage and mutation scores, but examined experienced CS undergraduates with prior testing instruction across only 3 timed unit-test assignments and without video/behavioral analytics. Pytutor extends this paradigm to 50 self-paced exercises across CS and Non-CS novices integrated with OpenEdu telemetry.
-->

---

## 3.1 Pytutor Architecture, Sandbox & Three Test-Case Types

<div class="fig-box" style="padding: 8px 10px; margin-bottom: 10px;">
<img src="./img/diag2_pytutor_pipeline.svg" alt="Pytutor Django MVT Architecture and Evaluation Pipeline" style="max-height: 255px;">
</div>

<div class="two-col">
<div class="card small-text">

### 🧪 Three Categories of Test Cases
- **Open Test Cases (OTCs)**: Teacher-provided public samples (2 per exercise) for basic sanity checks.
- **Defining Test Cases (DTCs)**: **Learner-authored** custom tests executed in Testing Mode to hunt edge cases.
- **Hidden Test Cases (HTCs)**: Teacher-predesigned grading suite (5 per exercise) executed upon formal submission.

</div>
<div class="card accent small-text">

### ⚖️ Two Pedagogical Submission Principles
- **Completion Principle**: Learners may submit multiple times until passing all HTCs.
- **Cautionary Principle**: Each formal submission deducts **3 points**, discouraging blind trial-and-error and encouraging thorough DTC testing first.
- **Docker Security**: Ephemeral containers isolate infinite loops & malicious code, auto-deleting within seconds.

</div>
</div>

<!--
System Architecture, Security & Pedagogical Rules (Section 3.1, Figure 1):
- Django MVT Architecture: Built on Django's Model-View-Template framework for modular extensibility. The Template layer provides a browser-based Python editor and question interface; the View-Control layer invokes the automated assessment engine upon execution/submission; and the Software-Testing module computes branch coverage, mutation scores, and SE indicators (r, PAI, TEI). Design follows Ihantola et al.'s [30] guidelines for usability and safety.
- Three-Tier Test Case Taxonomy:
  1. Open Test Cases (OTCs): 2 instructor-provided public examples per exercise allowing basic verification.
  2. Defining Test Cases (DTCs): Custom inputs authored by learners in Testing Mode; learners must determine expected correctness themselves to probe edge cases.
  3. Hidden Test Cases (HTCs): 5 predesigned private test cases executed only during Formal Submission to compute scores.
- Pedagogical Rules & Docker Isolation: The Completion Principle permits unlimited resubmissions until passing all HTCs, while the Cautionary Principle deducts 3 points per formal submission to deter blind guessing. Addressing server security risks [31, 32], every code run spawns a fresh ephemeral Docker container [33] that terminates and self-deletes within seconds, containing infinite loops or malicious scripts.
-->

---

## 3.2 Testing Mode Interface & Learner Workflow

<div class="split55">
<div class="left">

<div class="fig-box">
<img src="./img/fig3_testing_ui.png" alt="Fig. 3: Result-display area in Pytutor Testing Mode" style="max-height: 365px;">
<div class="fig-cap">Fig. 3: Pytutor Testing Mode — DTC input area, raw compile errors &amp; 3-run history</div>
</div>

</div>
<div class="right">

<div class="fig-box">
<img src="./img/fig4_workflow.png" alt="Fig. 4: Workflow diagram of Pytutor" style="max-height: 365px;">
<div class="fig-cap">Fig. 4: Learner workflow — iterative OTC/DTC verification before formal HTC submit</div>
</div>

</div>
</div>

<div class="callout" style="margin-top: 8px; padding: 8px 14px;">
<strong>Error Transparency &amp; Safety Net:</strong> Compilation errors appear in raw Python form to train debugging, while formal submission requires ticking a <strong>"Confirm Submission"</strong> checkbox to prevent accidental −3 pt penalties.
</div>

<!--
Interface Structure & Behavioral Logging (Sections 3.1.2 & 3.2, Figures 2–4):
- Three-Pane Answering Page: Comprises (1) the Question-Information area (title, problem description, and public OTCs, Fig. 2), (2) the Answering area (code editor with Testing Mode vs. Formal Submission Mode), and (3) the Result-Display area (Fig. 3).
- Testing Mode Pedagogical Features (Figure 3): Displays raw, unmodified Python compiler/runtime error messages so novices learn authentic debugging directly from stack traces rather than sanitized hints. The lower panel allows entering custom DTC inputs and retains a rolling history of the last 3 test runs for side-by-side comparison.
- Formal Submission Safety Net & Workflow (Figure 4): Learners iterate between coding, OTC checks, and DTC verification (or may bypass testing and submit directly). Formal Submission requires explicitly checking a "Confirm Submission" box to prevent accidental -3 point deductions. Every testing event (code snapshot, test input, output) and formal submission (code, passed HTC count, elapsed time) is logged to the database.
-->

---

## 3.3 Quantifying Programming Ability: Resilience (<i>r</i>) & PAI

Pure assignment scores hide how many setbacks a learner faced. We normalize scores by **complexity-adjusted resilience (<i>r</i>)** (`k = 0.1<code>):

<div class="formula-strip-3">
<div class="formula-box accent">
<i>r</i> &nbsp;=&nbsp; <i>e</i><sup><i>k</i> × (<i>tr</i> − <i>ch<sub>p</sub></i>)</sup>
</div>
<div class="formula-box">
<i>s</i> &nbsp;=&nbsp; <i>base</i> + (100 − <i>base</i>) × <i>p</i>
</div>
<div class="formula-box teal">
<i>PAI</i> &nbsp;=&nbsp; <span class="frac"><span class="frac-num"><i>s</i></span><span class="frac-den"><i>r</i></span></span>
</div>
</div>

<div class="split55">
<div class="left">

<div class="fig-box">
<img src="./img/fig6_pai.png" alt="Fig. 6: Impact of resilience r on PAI" style="max-height: 315px;">
<div class="fig-cap">Fig. 6: Impact of resilience <i>r</i> on Programming Ability Index (PAI)</div>
</div>

</div>
<div class="right small-text">

### 📈 Interpreting <i>r</i> and PAI
- **</code>tr`**: Total setback attempts (syntax errors + failed HTC submissions).
- **<code>ch<sub>p</sub></code>**: Challenge level of program `p` (decision count / cyclomatic complexity).
- **Resilience Origin (<code>tr = ch<sub>p</sub></code>, `r = 1`)**: `r > 1` reflects high persistence through setbacks; `r < 1` reflects solving faster than expected.
- **Dual Meaning**: Higher `PAI = s / r` means achieving high HTC pass scores (`s`) with **fewer setbacks**.
- **Course Mean**: Avg `PAI = 121.80` (> 100), showing learners solved most exercises efficiently.

</div>
</div>

<!--
Mathematical Formulation of Resilience (r) & PAI (Sections 3.3.1–3.3.2, Equations 1–3):
Pure exercise scores fail to distinguish a student who solves a problem cleanly from one who succeeds only after many failed attempts. Extending Xu et al.'s [34] attempt-based proficiency model and Pereira et al.'s [36] resilience construct with McCabe cyclomatic complexity [35], the authors define three linked equations:
- Equation (1) Resilience: r = exp(k * (tr - ch_p)), with tuning constant k = 0.1 (chosen via Fig. 5 to provide smooth, non-extreme weighting). Here tr is total setback attempts (syntax errors in testing/submissions plus formal submissions failing to pass all HTCs), and ch_p is the program's challenge level (decision count / cyclomatic complexity). At tr = ch_p (the "resilience origin"), r = 1. Values r > 1 indicate high persistence through setbacks; r < 1 indicates solving with fewer setbacks than expected.
- Equation (3) Base-Adjusted Score: s = base + (100 - base) * p, where base is the minimum score awarded for passing at least one HTC and p is the fraction of HTCs passed.
- Equation (2) Programming Ability Index: PAI = s / r. At r = 1 ("programming ability origin"), PAI = s. When r < 1 (high efficiency), PAI exceeds s (course mean PAI = 121.80 > 100); when r > 1 (many setbacks), PAI drops below s (Fig. 6). Thus r acts as a dual indicator: persistence on one hand, and inverse coding fluency on the other. Note: unlike Yang et al. [11], code maintainability was omitted because introductory exercises are small.
-->

---

## 3.4 Quantifying Testing Ability: TQI & TEI

Testing quality combines **branch coverage (<code>b<sub>t</sub></code>)** and **mutation score (<code>ms<sub>t</sub></code>)** of a learner's combined OTC + DTC suite relative to OTC alone:

<div class="formula-strip-3">
<div class="formula-box">
<i>TQI<sub>t</sub></i> &nbsp;=&nbsp; √(<i>b<sub>t</sub></i> × <i>ms<sub>t</sub></i>)
</div>
<div class="formula-box">
<i>TQI</i><sup>+</sup> &nbsp;=&nbsp; <span class="frac"><span class="frac-num"><i>TQI<sub>OD</sub></i></span><span class="frac-den"><i>TQI<sub>O</sub></i></span></span>
</div>
<div class="formula-box teal">
<i>TEI</i> = 1 (<i>te</i>=<i>te<sub>o</sub></i>) &nbsp;|&nbsp; <i>TQI</i><sup>+</sup>(1 + <i>e</i><sup>−<i>k</i>(<i>te</i>−<i>ch<sub>t</sub></i>)</sup>)
</div>
</div>

<div class="split55">
<div class="left">

<div class="fig-box">
<img src="./img/fig7_tei.png" alt="Fig. 7: Impact of k and test count on TEI" style="max-height: 315px;">
<div class="fig-cap">Fig. 7: Impact of <i>k</i> (= 0.1) and test count on Testing Efficiency Index (TEI)</div>
</div>

</div>
<div class="right small-text">

### 🎯 Interpreting TQI<sup>+</sup> and TEI
- **<code>TQI<sub>OD</sub> / TQI<sub>O</sub></code>**: Measures how much a learner's **DTCs** improve branch coverage and mutant killing over baseline **OTCs**.
- **Baseline Guarantee**: Learners using only OTCs (<code>te = te<sub>o</sub></code>) receive `TEI = 1`. Adding <code>1 + e<sup>−k(te−ch<sub>t</sub>)</sup></code> ensures writing DTCs never drops below `1`.
- **Efficiency Bonus**: Achieving high <code>TQI<sup>+</sup></code> with **fewer test cases** than expected (<code>te < ch<sub>t</sub></code>) yields a higher `TEI`.
- **Course Mean**: Avg `TEI = 1.89`, revealing weak testing habits across most exercises.

</div>
</div>

<!--
Mathematical Formulation of TQI, TQI+ & TEI (Section 3.3.3, Equations 4–6):
Following software-testing literature linking coverage and mutation killing to fault detection [11, 37], testing ability is quantified exclusively from how much a learner's custom DTCs strengthen the baseline OTC suite:
- Equation (4) Test Quality Index: TQI_t = sqrt(b_t * ms_t), the geometric mean of branch coverage b_t (fraction of code branches executed) and mutation score ms_t (fraction of generated mutants killed), scaled 0–100.
- Equation (5) Quality Gain Ratio: TQI+ = TQI_OD / TQI_O, comparing the combined OTC + DTC test suite (TQI_OD) against OTC alone (TQI_O).
- Equation (6) Testing Efficiency Index: If a learner runs only OTCs (te = te_o), TEI = 1 by default (assuming basic testing competence). If the learner authors DTCs (te > te_o), TEI = TQI+ * (1 + exp(-k * (te - ch_t))), where te = total test cases (OTC + DTC), ch_t = expected test count scaling with complexity, and k = 0.1 (Fig. 7).
- Design Safeguard: Adding "1 +" to the exponential term guarantees that learners willing to write DTCs are never penalized below the baseline TEI = 1 even if their DTCs are numerous or weak. Achieving high TQI+ with concise test sets (te < ch_t, left of the "testing ability origin") yields the highest TEI. Course mean TEI was only 1.89 because many exercises remained at TEI = 1.
-->

---

## 4.1 Course Design, Participants & Exercise TQI Distribution

<div class="split55">
<div class="left small-text">

### 📚 7-Week Online Python Course
- **Format**: Asynchronous **OpenEdu** (7 units, **64 videos**) + **Pytutor** (**50 exercises**) + 5 face-to-face Q&amp;A meetings + MS Teams support.
- **Exercise Complexity**: Avg cyclomatic complexity = **4.06**; each has **2 OTCs** + **5 HTCs** (avg OTC branch coverage = **0.92**, mutation score = **0.75**).
- **Participants**: **69 enrolled** (27 CS, 42 Non-CS; 54 with prior coding, 15 with Python); **61 active learners** analyzed (26 CS, 35 Non-CS).
- **Assessments**: **Formative** (avg of 50 Pytutor exercises) &amp; **Summative** (40-min, 4-question final coding exam).

</div>
<div class="right">

<div class="fig-box">
<img src="./img/fig8_tqi_dist.png" alt="Fig. 8: TQI distribution across 50 exercises" style="max-height: 335px;">
<div class="fig-cap">Fig. 8: Baseline OTC TQI distribution across all 50 exercises (some low-TQI exercises urgently require learner DTCs)</div>
</div>

</div>
</div>

<!--
Experimental Context, Curriculum & Data Sources (Sections 4.1–4.4, Figure 8):
- Course Structure: A 7-week asynchronous online Python course combining OpenEdu (7 units, 64 prerecorded videos: Units 1–5 cover programming fundamentals, basic structures/operations, logic, and OOP; Units 6–7 cover practical data processing and object design) with Pytutor (50 exercises distributed across Units 1–5 as 1, 9, 13, 18, and 9 problems respectively). Five face-to-face Q&A meetings (following Montoya-Dato et al. [26] on instructor-guided reflection) and a Microsoft Teams channel provided synchronous/asynchronous support.
- Problem Bank Metrics (Figure 8): Mean cyclomatic complexity = 4.06; each problem includes 2 OTCs and 5 HTCs. Baseline OTCs average 0.92 branch coverage and 0.75 mutation score, though Fig. 8 shows several exercises with very low baseline TQI where learner DTCs are essential to catch faults.
- Cohort & Filtering: 69 undergraduates enrolled (27 CS, 42 Non-CS; 54 had prior coding experience in some language, 15 had prior Python). Motivations included interest in programming (44), acquiring a second skill (30), online convenience (21), and enrolling with classmates (13). After excluding 8 learners inactive in later weeks, N = 61 active learners (26 CS, 35 Non-CS) entered statistical analysis.
- Triangulated Measures: Pre-course survey, OpenEdu video event logs (load_video, play_video, seek_video, pause_video, stop_video), Pytutor execution logs, formative score (50-exercise average), and summative score (40-min, 4-question coding exam held 2 weeks after Week 7 release).
-->

---

## 4.2 RQ1 Results: Learner Engagement & Four Ability Types

<div class="four-col" style="margin-bottom: 10px;">
<div class="kpi-card accent">
<div class="kpi-val">23% Blind</div>
<div class="kpi-label">Exercises submitted with <strong>zero</strong> OTC or DTC testing</div>
</div>
<div class="kpi-card teal">
<div class="kpi-val">44% DTC</div>
<div class="kpi-label">Used ≥ 1 DTC before submit (59% used ≥ 1 OTC)</div>
</div>
<div class="kpi-card">
<div class="kpi-val">56% @ 2.08×</div>
<div class="kpi-label">Avg OpenEdu video completion &amp; playback speed</div>
</div>
<div class="kpi-card">
<div class="kpi-val">1.43 Submits</div>
<div class="kpi-label">Avg formal submits/Q · 14.45 min · <i>tr</i> = 3.23</div>
</div>
</div>

<div class="split55">
<div class="left">

<div class="fig-box">
<img src="./img/fig10_categories.png" alt="Fig. 10: Learners in four ability categories" style="max-height: 270px;">
<div class="fig-cap">Fig. 10: 61 learners grouped by percentile rank (1–50 Low, 51–99 High)</div>
</div>

</div>
<div class="right small-text">

### 📊 Descriptive Summary (Table 2 · N = 61)
| Metric | Mean | Std | Median | Max |
| :--- | :---: | :---: | :---: | :---: |
| Resilience (<i>r</i>) | 1.97 | 2.82 | 0.99 | 17.53 |
| **Avg TEI** | **1.89** | 0.49 | 1.92 | 2.99 |
| **Avg PAI** | **121.80** | 23.64 | 127.55 | 157.19 |
| Formative Score | 72.66 | 26.17 | 84.08 | 99.64 |
| Summative Exam | 68.04 | 23.69 | 77.93 | 100.00 |

**Key Insight**: Low patience (2.08× speed, 56% completion, 23% blind submits) — yet **39 of 61 learners** are split between **HPLT (20)** and **LPHT (19)**!

</div>
</div>

<!--
Empirical Analysis of RQ1: Engagement & Ability Quadrants (Sections 4.5 & 5.1, Tables 1–2, Figs. 9–10):
- Engagement Telemetry (Table 1): Despite the -3 point cautionary penalty, learners averaged 1.43 formal submissions per exercise (spending 14.45 min/problem on average), with tr = 3.23 setbacks and te = 3.41 total test cases (executing OTCs 3.96 times and DTCs 2.94 times per question, including reruns). Crucially, 59% ran >= 1 OTC, only 44% ran >= 1 DTC, and 23% submitted blindly with zero testing. On OpenEdu, mean video completion was 56% (median 60%, max 83%) at an average playback speed of 2.08x (median 2.16x, max 2.92x), signaling low learner patience.
- Proportional Exam Prediction: Given 14.45 min per practice problem, a 40-min, 4-question final exam proportionally predicts ~69% completion; the observed summative mean of 68.04 (median 77.93) closely matches this estimate.
- Descriptive Distributions (Table 2, Fig. 9): r (mean 1.97, SD 2.82, median 0.99, max 17.53 — strongly right-skewed due to highly persistent outliers); TEI (mean 1.89, SD 0.49, median 1.92, range 1.00–2.99); PAI (mean 121.80, SD 23.64, median 127.55, range 49.18–157.19); Formative (mean 72.66, median 84.08); Summative (mean 68.04, median 77.93).
- Four Percentile Quadrants (Figure 10): Splitting PAI and TEI at percentile rank 50 (1–50 Low, 51–99 High) yields HPHT = 11, HPLT = 20, LPHT = 19, LPLT = 11. Nearly two-thirds (39/61) exhibit mismatched coding vs. testing profiles.
-->

---

## 4.3 RQ2a Results: CS Majors vs. Non-CS Majors

<div class="split55">
<div class="left">

<div class="fig-box">
<img src="./img/fig11_cs_cats.png" alt="Fig. 11: CS vs Non-CS across four ability categories" style="max-height: 315px;">
<div class="fig-cap">Fig. 11: Departmental background vs. 4 ability categories (26 CS vs. 35 Non-CS)</div>
</div>

</div>
<div class="right small-text">

### 🔬 Mann–Whitney U Test: CS vs. Non-CS (Fig. 12)
| Indicator | CS (n = 26) vs. Non-CS (n = 35) | <i>p</i>-value | Sig.? |
| :--- | :--- | :---: | :---: |
| **Resilience (<i>r</i>)** | Non-CS face more errors &amp; persist longer | **0.001** | **Yes*** |
| **PAI (Coding)** | CS: **19/26 (73%) HP** vs. Non-CS: 12/35 | **0.0003** | **Yes*** |
| **TEI (Testing)** | CS: **11/26 (42%) HT** vs. Non-CS: 19/35 (54%) | **0.277** | **No** |

<div class="callout" style="margin-top: 10px;">
<strong>Surprising Finding:</strong> CS majors significantly outperform Non-CS majors in <strong>programming ability (PAI)</strong>, yet show <strong>NO significant advantage in testing ability (TEI)</strong>! Overconfidence leads CS students to test less, while Non-CS learners write more DTCs to avoid errors.
</div>

</div>
</div>

<!--
RQ2a Statistical Breakdown: Departmental Background (Section 5.2, Figures 11–12):
Because indicator distributions violated normality (skewed r and PAI), two-sided Mann-Whitney U tests were used to compare CS (n = 26) and Non-CS (n = 35) learners:
- Programming Ability (PAI, Fig. 12b): Highly significant advantage for CS majors (p = 0.0003 < 0.05). In Figure 11, 19 of 26 CS students (73%) fall into High PAI (HP), compared with only 12 of 35 Non-CS students (34%), and CS distributions are tighter/more concentrated.
- Resilience (r, Fig. 12a): Significantly higher among Non-CS majors (p = 0.001 < 0.05). Facing less prior coding fluency, Non-CS students encountered more syntax/logic setbacks yet persisted through repeated iterations.
- Testing Efficiency (TEI, Fig. 12c): No statistically significant difference (p = 0.277 > 0.05). Counterintuitively, a higher proportion of Non-CS learners achieved High TEI (19/35 = 54%) than CS majors (11/26 = 42%).
- Behavioral Interpretation: The authors infer that prior coding experience gives CS majors confidence to attain high scores without authoring many DTCs, whereas Non-CS learners proactively write custom DTCs to avoid compilation and grading errors. Consequently, CS enrollment alone does not confer software-testing proficiency.
-->

---

## 4.4 RQ2b Results: Formative Assessment (Learning Phase)

Dividing the 61 learners by the formative-assessment median (**84.08**) yields **31 high-score** and **30 low-score** learners:

<div class="split55">
<div class="left">

<div class="fig-box">
<img src="./img/fig13_formative_cats.png" alt="Fig. 13: Formative assessment vs ability groups" style="max-height: 300px;">
<div class="fig-cap">Fig. 13: Formative score groups — 21 of 31 high scorers have High TEI!</div>
</div>

</div>
<div class="right">

<div class="fig-box">
<img src="./img/fig14_formative_box.png" alt="Fig. 14: Boxplots for formative assessment" style="max-height: 300px;">
<div class="fig-cap">Fig. 14: Mann–Whitney U — <i>r</i>: <i>p</i> = 0.153 (n.s.) · <b>PAI: <i>p</i> = 0.035*</b> · <b>TEI: <i>p</i> = 0.036*</b></div>
</div>

</div>
</div>

<div class="callout" style="margin-top: 8px;">
<strong>RQ2b Finding:</strong> During the 50-exercise practice phase, <strong>BOTH programming ability (PAI, <i>p</i> = 0.035) and testing ability (TEI, <i>p</i> = 0.036)</strong> significantly separate high scorers from low scorers. Even learners with lower PAI achieve top formative scores when armed with high TEI (<strong>12 LPHT high scorers</strong>)!
</div>

<!--
RQ2b Statistical Breakdown: Formative Learning Phase (Section 5.2, Figures 13–14):
Splitting the 61 active learners at the formative-assessment median (84.08 across 50 Pytutor exercises) produced 31 high-scoring and 30 low-scoring learners:
- Ability Quadrant Distribution (Figure 13): Among the 31 formative high scorers, 21 (68%) belong to the High Testing Ability (HT) quadrants — specifically 9 HPHT and 12 LPHT learners. Notably, 12 learners with below-median programming fluency (Low PAI) still reached the top half of formative scores by leveraging disciplined DTC testing.
- Mann-Whitney U Results (Figure 14):
  - Resilience r (Fig. 14a): p = 0.153 (not significant) — persistence alone does not guarantee high formative scores without effective coding or testing strategies.
  - PAI (Fig. 14b): p = 0.035 (significant) — higher coding efficiency separates top formative performers.
  - TEI (Fig. 14c): p = 0.036 (significant) — higher testing efficiency independently and significantly distinguishes high scorers from low scorers during self-paced practice.
- Pedagogical Insight: In untimed formative learning, strong testing ability acts as a compensatory scaffold that enables novices to catch edge-case defects before incurring formal submission penalties.
-->

---

## 4.5 RQ2c Results: Summative Assessment (Timed Final Exam)

Dividing learners by the summative-exam median (**77.93**; 4 questions in **40 minutes**) yields **31 high achievers** and **30 low achievers**:

<div class="split55">
<div class="left">

<div class="fig-box">
<img src="./img/fig15_summative_cats.png" alt="Fig. 15: Summative assessment vs ability groups" style="max-height: 300px;">
<div class="fig-cap">Fig. 15: Summative score groups — 18 HP vs. 13 LP in the high-score group</div>
</div>

</div>
<div class="right">

<div class="fig-box">
<img src="./img/fig16_summative_box.png" alt="Fig. 16: Boxplots for summative assessment" style="max-height: 300px;">
<div class="fig-cap">Fig. 16: Mann–Whitney U — <i>r</i>: <i>p</i> = 0.105 (n.s.) · <b>PAI: <i>p</i> = 0.016*</b> · TEI: <i>p</i> = 0.93 (n.s.)</div>
</div>

</div>
</div>

<div class="callout" style="margin-top: 8px;">
<strong>RQ2c Finding:</strong> Under strict <strong>40-minute exam pressure</strong>, <strong>PAI is the sole significant differentiator (<i>p</i> = 0.016)</strong>, whereas TEI shows no difference (<i>p</i> = 0.93). Limited exam time leaves little room to design thorough DTCs, favoring rapid, low-error coding proficiency.
</div>

<!--
RQ2c Statistical Breakdown: Timed Summative Exam (Section 5.2, Figures 15–16):
Splitting the 61 learners at the summative final-exam median (77.93 on a 40-minute, 4-question programming exam held two weeks after Week 7) yields 31 high achievers and 30 low achievers:
- Ability Quadrant Shift (Figure 15): In the high-score group, High PAI learners dominate (18 HP vs. 13 LP), reversing the low-score group (13 HP vs. 17 LP).
- Mann-Whitney U Results (Figure 16):
  - Resilience r (Fig. 16a): p = 0.105 (not significant).
  - PAI (Fig. 16b): p = 0.016 (statistically significant) — programming proficiency is the sole significant differentiator of exam performance.
  - TEI (Fig. 16c): p = 0.93 (completely non-significant).
- Contextual Explanation: Under severe time constraints (~10 minutes per coding problem), learners lack the temporal margin to design comprehensive DTC suites and iterate through coverage/mutation checks. Furthermore, the timed exam emphasizes conceptual mastery and rapid, low-error implementation, giving high-PAI coders a decisive competitive advantage.
-->

---

## 4.6 RQ3 Results: Correlations Among Abilities, Videos & Outcomes

<div class="split55">
<div class="left">

<div class="fig-box">
<img src="./img/fig17_corr_ability.png" alt="Fig. 17: Spearman correlation heatmap of ability indicators" style="max-height: 310px;">
<div class="fig-cap">Fig. 17: Spearman correlations among <i>r</i>, PAI &amp; TEI</div>
</div>

</div>
<div class="right">

<div class="fig-box">
<img src="./img/fig18_corr_behavior.png" alt="Fig. 18: Spearman correlation heatmap of abilities vs behaviors and scores" style="max-height: 310px;">
<div class="fig-cap">Fig. 18: Spearman correlations with video behaviors &amp; scores</div>
</div>

</div>
</div>

<div class="callout" style="margin-top: 8px;">
<strong>Key Correlation Patterns:</strong>
(1) <b><i>r</i> ↔ TEI (+0.50)</b>: Frequent errors trigger iterative DTC debugging; <b>PAI ↔ TEI (−0.39)</b> confirms coding &amp; testing are distinct skills.
(2) <b>Video Completion ↔ TEI (+0.33)</b>: Engaged video watchers test more thoroughly; <b>Playback Speed ↔ PAI (−0.24)</b>: Rushing videos hurts coding accuracy.
(3) <b>Outcomes</b>: PAI correlates with both Formative (<b>+0.35</b>) &amp; Summative (<b>+0.38</b>); TEI boosts Formative (<b>+0.26</b>) but not timed exams (<b>+0.073</b>).
</div>

<!--
RQ3 Correlational Network: Abilities, Video Telemetry & Grades (Section 5.3, Figures 17–18):
Spearman's rank correlation heatmaps uncover three structural relationships across the 61 learners:
1. Inter-Indicator Structure (Figure 17):
   - PAI vs. r = -0.863 (strong negative): Mathematically expected since PAI = s / r, reflecting that fluent coders encounter fewer setbacks.
   - r vs. TEI = +0.50 (moderate positive): Learners who hit more syntax/logic errors actively engage in multiple rounds of DTC testing to debug their code.
   - PAI vs. TEI = -0.385 (moderate negative): Confirms that programming fluency and testing diligence are distinct constructs; strong coders often pass introductory exercises without thorough DTC authoring.
2. OpenEdu Video Behaviors vs. Abilities (Figure 18):
   - Video Completion vs. TEI = +0.331 (moderate positive): Diligent learners who watch more lecture content also test more thoroughly; completion has near-zero correlation with r (+0.111) and PAI.
   - Playback Speed vs. PAI = -0.24 (negative), vs. r = +0.203 (positive), vs. TEI = +0.237 (low positive): Rushing videos at high speed impairs conceptual comprehension, raising coding errors (lower PAI, higher r) and forcing compensatory testing (higher TEI).
3. Outcomes: PAI correlates moderately with both Formative (+0.35) and Summative (+0.38) scores; TEI correlates positively with Formative (+0.26) but not Summative (+0.073); r shows weak negative correlations with both assessments.
-->

---

## 5.1 Comparison with Prior Studies & Study Limitations

<div class="two-col">
<div class="card teal small-text">

### 🔍 Comparison with Yang et al. (2020) [11]
- **Confirmed Core Finding**: Both studies show that **strong programming skills do NOT guarantee strong testing ability** — nearly half of strong coders test poorly, while weaker coders can excel at testing.
- **Scale &amp; Context**: Yang et al. evaluated experienced CS students with prior testing training on **3 timed tasks**.
- **Our Extension**: Pytutor spans **50 self-paced exercises** across **CS &amp; Non-CS novices** without prior testing instruction, capturing natural test-case sensitivity and OpenEdu video telemetry.

</div>
<div class="card accent small-text">

### ⚠️ Three Study Limitations
1. **High Baseline OTC Quality**: Several exercises had baseline <code>TQI<sub>O</sub> > 80</code>, leaving narrow headroom for learner DTCs to raise <code>TQI<sup>+</sup></code> and `TEI`.
2. **Untaught Testing Concepts**: Software-testing techniques (e.g., boundary value, equivalence partitioning) were not explicitly taught in the curriculum, so TEI measured *natural sensitivity*.
3. **Off-Platform Editing Blind Spot**: Pytutor currently cannot log whether learners write and test code in a **local IDE** before pasting into the web platform.

</div>
</div>

<!--
Cross-Study Synthesis & Methodological Limitations (Sections 5.4 & 5.5):
- Positioning Against Automated Assessment Platforms: Unlike YOJ [16], Sakai [17], and Codeflex [20], Pytutor lets instructors vary difficulty while requiring learners to design DTCs; like Codespec's [21] multi-skill focus, Pytutor allows instructors to seed starter/buggy code to target debugging skills directly.
- Detailed Comparison with Yang et al. (2020) [11]: Both studies converge on a crucial empirical truth — strong programming skill does not guarantee strong testing ability (nearly half of high-PAI coders exhibit low TEI, while low-PAI learners can excel in TEI). Key extensions: Yang et al. studied experienced CS undergraduates with prior testing training on 3 timed unit-test tasks (Pearson r); Pytutor scales to 50 self-paced exercises across CS and Non-CS novices without prior testing training, adds OpenEdu video telemetry, and applies non-parametric Spearman/Mann-Whitney statistics.
- Three Explicit Study Limitations (Section 5.5):
  1. Ceiling Effect on Baseline OTCs: Several exercises had baseline TQI_O > 80, leaving narrow headroom for learner DTCs to raise TQI+ and compressing TEI variance.
  2. Untaught Testing Methodology: Because formal testing techniques (boundary value analysis, equivalence partitioning) were not taught, TEI captured novices' "natural sensitivity" to test cases rather than trained testing skill.
  3. Off-Platform IDE Blind Spot: Pytutor cannot observe whether students author and test code locally in an external IDE (e.g., VS Code, PyCharm) before pasting a polished solution into the web editor.
-->

---

## 5.2 Pedagogical Implications for Programming Education

Our empirical evidence yields three concrete recommendations for CS1 &amp; online programming instructors:

<div class="three-col" style="margin-top: 10px;">
<div class="card small-text">

### 1. Teach Testing to ALL Majors
- CS majors are **not** naturally better testers (`p = 0.277`).
- Integrate black-box &amp; boundary-case testing directly into introductory courses for **both CS and Non-CS** students.
- Testing helps lower-PAI novices achieve top formative performance.

</div>
<div class="card teal small-text">

### 2. Micro-Segment Video Lessons
- Learners watch only **56%** of videos at **2.08× speed**, and high playback speed negatively correlates with PAI (`−0.24`).
- Break long lectures into **bite-sized knowledge-point clips** to sustain attention and reduce rushed coding errors.

</div>
<div class="card accent small-text">

### 3. Design "Test-Hungry" Problems
- Intentionally keep public OTC coverage modest (<code>TQI<sub>O</sub> < 70</code>) so students **must** craft DTCs to uncover edge cases.
- Pair the **Cautionary Principle (−3 pts)** with instant DTC coverage feedback to make testing a habit.

</div>
</div>

<!--
Evidence-Based Recommendations for Programming Curricula (Sections 5.1, 5.2, 5.5 & 6):
Translating the empirical findings from 61 learners across 50 exercises into actionable instructional design yields three concrete interventions:
1. Embed Software-Testing Instruction for ALL Majors: In the Taiwanese university context studied, CS majors showed no natural TEI advantage over Non-CS peers (p = 0.277), yet strong testing enabled 12 LPHT novices to reach the top half of formative scores. Introductory programming courses (both CS1 and non-major Python) should explicitly teach black-box test design, boundary cases, and equivalence partitioning alongside syntax.
2. Micro-Segment Video Lectures into Knowledge-Point Clips: Because learners averaged only 56% video completion at 2.08x playback speed — and accelerated viewing correlated negatively with PAI (-0.24) and positively with setbacks r (+0.203) — long recordings should be partitioned into concise, single-concept micro-videos to sustain attention and prevent superficial comprehension.
3. Engineer "Test-Hungry" Exercises: To eliminate the TQI_O > 80 ceiling effect (Section 5.5), instructors should deliberately calibrate public OTC coverage to remain modest (e.g., TQI_O < 70), pairing the -3 point Cautionary Principle with immediate DTC coverage/mutation feedback so students must write meaningful DTCs to uncover hidden edge cases.
-->

---

## 6. Conclusion & Future Work

<div class="fig-box" style="padding: 8px 10px; margin-bottom: 8px;">
<img src="./img/diag3_rq_conclusions.svg" alt="Visual Synthesis of Pytutor RQ1-RQ3 Conclusions" style="max-height: 355px;">
</div>

<div class="future-strip">
<div class="future-pill"><strong>🤖 1. AI Virtual Assistant</strong><br>Use generative AI to guide learners Socratic-style toward edge cases — without giving away direct answers.</div>
<div class="future-pill"><strong>💻 2. Richer Online IDE &amp; Telemetry</strong><br>Enhance the web editor so students stay on-platform, enabling fine-grained keystroke &amp; debugging analytics.</div>
<div class="future-pill"><strong>🧪 3. Controlled Experiments</strong><br>Run experimental vs. control group studies to quantify the causal learning gains of testing-integrated OJs.</div>
</div>

<!--
Summary of Contributions & Future Research Agenda (Section 6):
Pytutor demonstrates how an educational Online Judge can move beyond binary HTC pass/fail grading by integrating learner-defined test cases (DTCs), cyclomatic-complexity-adjusted resilience (r) and PAI, and coverage/mutation-based TEI. Across 61 active learners and 50 exercises, the study establishes that (1) novices exhibit impatient online habits (56% video completion at 2.08x speed, 23% blind submits), (2) CS majors surpass Non-CS majors in PAI (p = 0.0003) but not TEI (p = 0.277), and (3) both PAI and TEI drive formative success while PAI alone governs 40-minute timed exams.

Three Future Directions in the Era of AI-Assisted Programming (citing Welsh [38]):
1. Socratic AI Virtual Teaching Assistant: Leverage generative AI to guide learners toward discovering edge cases and debugging strategies through questioning — explicitly avoiding the pitfall of handing out direct code solutions.
2. Enhanced Web IDE & Fine-Grained Telemetry: Upgrade Pytutor's in-browser editor so learners prefer coding on-platform rather than in local IDEs, enabling keystroke-level, edit-compile-test behavioral analytics.
3. Experimental vs. Control Group Validation: Conduct randomized or quasi-experimental controlled trials in future offerings to establish the causal learning gains of testing-integrated OJs over conventional OJs.
-->

---

<!-- _class: closing -->

# Thank You for Your Attention!

<p style="font-size: 1.05em; max-width: 860px;">
Design of an Online Programming Platform and a Study on Learners’ Testing Ability (Pytutor)
</p>

<div class="contact-card">
<strong>Nien-Lin Hsueh*</strong> &nbsp;·&nbsp; <code>nlhsueh@fcu.edu.tw</code><br>
<strong>Lien-Chi Lai</strong> &amp; <strong>Wei-Hsiang Tseng</strong><br>
Department of Information Engineering and Computer Science, Feng Chia University, Taichung, Taiwan<br>
Journal Article: <code>Electronics 2023, 12(22), 4596</code> · <code>https://doi.org/10.3390/electronics12224596</code><br>
<span style="font-size: 0.85em; opacity: 0.85;">Grant: MOST112-2813-C-035-075-E · Questions &amp; Discussion Welcome!</span>
</div>

<!--
Reference & Reproducibility Information:
- Full Citation: Hsueh, N.-L.; Lai, L.-C.; Tseng, W.-H. Design of an Online Programming Platform and a Study on Learners' Testing Ability. Electronics 2023, 12(22), 4596. DOI: https://doi.org/10.3390/electronics12224596 (Open Access, CC BY 4.0).
- Core Formulas & Figures in Published Article: System architecture & workflow (Figs. 1–4), Resilience r, PAI, TQI, TQI+, and TEI equations (Eqs. 1–6; Figs. 5–7), 50-exercise TQI distribution (Fig. 8), engagement & descriptive statistics (Tables 1–2; Figs. 9–10), Mann-Whitney U group comparisons (Figs. 11–16), and Spearman correlation heatmaps (Figs. 17–18).
- Funding & Data Availability: Supported by the National Science and Technology Council (NSTC), Taiwan R.O.C., grant MOST112-2813-C-035-075-E. Learner-level logs are available upon request from the corresponding author (nlhsueh@fcu.edu.tw) subject to student privacy protections.
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
