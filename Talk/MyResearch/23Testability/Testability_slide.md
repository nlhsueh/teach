---
marp: true
theme: gaia
size: 16:9
paginate: true
html: true
header: '<div class="hdr-wrap"><span class="hdr-title">Pytutor: Online Programming Platform & Learners’ Testing Ability</span><div class="nav-dropdown"><button class="nav-btn">Sections ▾</button><div class="nav-menu"><a href="#2">Opening Hook: Blind Submit vs. DTC</a><a href="#3">Outline</a><a href="#4">1. Introduction & RQs</a><a href="#6">2. Related Work</a><a href="#7">3. Pytutor & SE Indicators</a><a href="#11">4. Experiment & RQ1–RQ3</a><a href="#17">5. Comparison & Implications</a><a href="#19">6. Conclusion & Future Work</a></div></div></div>'
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
Key Takeaway: We introduce Pytutor, a testing-aware online programming platform, and present an empirical study of novices' programming and testing abilities.
Talking Points:
- Hello everyone. Today I am presenting our Electronics 2023 study from Feng Chia University on designing an online programming platform and investigating learners' software-testing ability.
- We built Pytutor to integrate learner-defined test cases, branch coverage, and mutation testing directly into an automated online judge.
- Across a 7-week Python course, we examined how CS and Non-CS learners code, test, watch course videos, and perform on formative and summative assessments.
Transition: Let's begin with an everyday classroom habit that motivated this entire project.
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
Key Takeaway: Traditional online judges foster blind submissions — 23% of exercise attempts are submitted without any testing — whereas Pytutor trains learners to test first.
Talking Points:
- Most students using a standard online judge write code, eyeball it, and hit Submit immediately, treating hidden grading tests as a trial-and-error crutch.
- Even with a penalty in place, our logs revealed that 23% of submissions were sent blindly without running a single open or custom test case.
- Pytutor flips this mindset by making Defining Test Cases (DTCs), branch coverage, and mutation testing first-class parts of the learning loop.
Transition: Here is an outline of the six sections we will cover today.
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
Key Takeaway: The presentation moves from motivation and related work to Pytutor's design and SE indicators, empirical RQ1-RQ3 results, and pedagogical takeaways.
Talking Points:
- Sections 1 and 2 establish why traditional online judges neglect software testing and where prior empirical studies leave a gap.
- Section 3 introduces Pytutor's Docker sandbox, three test-case tiers, and our quantitative indicators: Resilience r, PAI, and TEI.
- Sections 4 through 6 report results from 61 active learners across 50 Python exercises, followed by pedagogical recommendations and future work.
Transition: Let's start with Section 1 and look closely at the limitations of traditional online judges.
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
Key Takeaway: Traditional educational OJs check code correctness only, missing the pedagogical value of designing test cases to clarify specifications.
Talking Points:
- As shown in the comparison diagram, conventional OJs give students a problem statement, accept a code upload, and return a pass-or-fail verdict from hidden tests.
- Research shows that designing test cases helps novices understand edge cases and write more reliable code, yet standard OJs never measure or reward testing effort.
- Pytutor bridges this gap by introducing a dedicated Testing Mode and quantifying both programming efficiency and test-suite quality.
Transition: Guided by this motivation, we formulated three research questions.
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
Key Takeaway: We investigate learners' baseline SE abilities and video behaviors (RQ1), differences across majors and score groups (RQ2), and correlations with outcomes (RQ3).
Talking Points:
- RQ1 establishes the baseline: how do novices perform on resilience r, PAI, TEI, and OpenEdu video engagement?
- RQ2 tests a common assumption: do CS majors automatically test better than Non-CS majors, and how do abilities separate high and low scorers in formative versus summative assessments?
- RQ3 explores how coding ability, testing ability, and video-watching habits correlate with final learning outcomes.
Transition: Next, let's position Pytutor relative to existing programming platforms and testing studies.
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
Key Takeaway: Pytutor is the first educational platform to combine learner-authored DTCs, coverage and mutation metrics, and multi-platform video analytics for both CS and Non-CS novices.
Talking Points:
- As summarized in the table, mainstream educational OJs like YOJ, Sakai, Codeflex, and Blockly focus on grading or scaffolding without evaluating learner-authored test suites.
- Yang et al. (2020) pioneered empirical PAI and TEI evaluation, but their study examined experienced CS students over just three timed tasks without video telemetry.
- Pytutor extends this line of work to 50 self-paced exercises across both CS and Non-CS novices, integrated with OpenEdu learning logs.
Transition: Let's move to Section 3 to see how Pytutor is architected under the hood.
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
Key Takeaway: Pytutor pairs a Django MVT architecture and ephemeral Docker sandboxes with three test-case tiers and a cautionary -3 point submission rule.
Talking Points:
- The pipeline diagram shows how learner code executes inside isolated Docker containers that auto-delete within seconds to guard against infinite loops or unsafe code.
- We structure testing into three tiers: 2 public Open Test Cases (OTCs), unlimited learner-authored Defining Test Cases (DTCs), and 5 Hidden Test Cases (HTCs) for grading.
- Pedagogically, we balance the Completion Principle (unlimited resubmissions) with the Cautionary Principle (-3 points per formal submit) to discourage blind trial-and-error.
Transition: Let's see how this workflow looks from the learner's perspective in Testing Mode.
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
Key Takeaway: Pytutor's Testing Mode displays raw Python error traces, tracks recent test history, and requires explicit confirmation before formal submission.
Talking Points:
- Figure 3 shows the Testing Mode interface, where students input custom DTCs, inspect raw Python compilation or runtime errors to practice real debugging, and compare their last three test runs.
- Figure 4 maps the full workflow: learners iterate freely between OTCs and DTCs until confident, then tick a Confirm Submission checkbox to avoid accidental -3 point deductions.
- Every testing event and submission attempt is logged seamlessly for downstream SE ability analytics.
Transition: Now let's look at how we turn those logs into quantitative indicators, starting with Resilience and PAI.
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
Key Takeaway: Programming Ability Index (PAI) normalizes a learner's exercise score by complexity-adjusted resilience r, rewarding high scores achieved with fewer setbacks.
Talking Points:
- Raw scores alone cannot tell a student who solved a problem cleanly from one who stumbled through ten failed attempts.
- We define resilience r = exp(k * (tr - ch_p)), where tr counts setbacks (syntax errors and failed HTC submits) and ch_p is the problem's cyclomatic complexity.
- As Figure 6 illustrates, dividing score s by r produces PAI: fewer setbacks yield r < 1 and a higher PAI. Across our course, mean PAI reached 121.80, indicating generally efficient problem solving.
Transition: Next, let's see how we quantify testing ability using TQI and TEI.
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
Key Takeaway: Testing Efficiency Index (TEI) measures how much a learner's custom DTCs boost branch coverage and mutation killing over baseline OTCs, weighted by test-count efficiency.
Talking Points:
- First, Test Quality Index (TQI) takes the geometric mean of branch coverage and mutation score, and TQI+ computes the improvement ratio when adding learner DTCs to baseline OTCs.
- To ensure writing DTCs is never penalized below doing nothing, learners who use only OTCs get TEI = 1, while DTC authors receive TQI+ * (1 + exp(-k * (te - ch_t))).
- As shown in Figure 7, achieving strong coverage and mutant killing with concise, targeted test cases yields the highest TEI. However, the course mean was only 1.89.
Transition: With the metrics defined, let's move to Section 4 and review our 7-week course experiment.
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
Key Takeaway: Our 7-week asynchronous Python course analyzed 61 active CS and Non-CS learners across 64 OpenEdu videos and 50 Pytutor exercises.
Talking Points:
- The course combined 64 OpenEdu videos across 7 units with 50 Pytutor exercises averaging a cyclomatic complexity of 4.06, supported by five Q&A sessions and MS Teams.
- Out of 69 enrolled students, 61 active learners (26 CS and 35 Non-CS) completed enough work for full analysis, evaluated via both formative practice scores and a 40-minute summative coding exam.
- Figure 8 plots baseline OTC TQI across all 50 exercises: while average OTC coverage is high (0.92), several low-TQI exercises urgently require learner-authored DTCs to catch edge cases.
Transition: Let's examine our first empirical findings for RQ1 on the next slide.
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
Key Takeaway: Learners display impatient online habits (2.08x video speed, 56% completion, 23% blind submits), and coding and testing abilities diverge sharply across individuals.
Talking Points:
- The top KPI cards highlight impatient study behavior: students watched only 56% of videos at an average 2.08x playback speed, used DTCs in just 44% of exercises, and submitted blindly 23% of the time.
- In Figure 10, splitting the 61 learners at the 50th percentile into four quadrants reveals a striking split: 39 of 61 learners fall into the mismatched groups — 20 HPLT (high coding, low testing) and 19 LPHT (low coding, high testing).
- Table 2 confirms solid overall coding (mean PAI 121.80) alongside modest testing efficiency (mean TEI 1.89).
Transition: Now let's test RQ2a: do CS majors outperform Non-CS majors in both coding and testing?
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
Key Takeaway: CS majors significantly outperform Non-CS majors in programming ability (p = 0.0003), but show NO significant advantage in testing ability (p = 0.277).
Talking Points:
- Look at Figure 11 and the Mann-Whitney U table: 73% of CS majors (19 of 26) fall into the High PAI group, confirming a clear coding advantage over Non-CS peers.
- Yet on TEI, the difference vanishes completely (p = 0.277): in fact, 54% of Non-CS learners achieved High TEI compared to only 42% of CS majors.
- Non-CS students also showed higher resilience r (p = 0.001): encountering more errors prompted them to write more DTCs, whereas CS students' confidence often led them to skip testing.
Transition: Next, let's check how PAI and TEI relate to performance in the 50-exercise formative phase (RQ2b).
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
Key Takeaway: In formative practice, BOTH programming ability (p = 0.035) and testing ability (p = 0.036) significantly distinguish high scorers from low scorers.
Talking Points:
- Splitting the cohort by the formative median of 84.08 gives 31 high scorers and 30 low scorers.
- Figure 13 shows that 21 of the 31 high scorers have High TEI — remarkably, 12 of them are LPHT learners who overcame weaker coding fluency through disciplined testing.
- The boxplots in Figure 14 confirm statistically significant differences for both PAI (p = 0.035) and TEI (p = 0.036), while resilience r is not significant.
Transition: Does testing ability keep that same advantage during a strict timed final exam? Let's check RQ2c.
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
Key Takeaway: Under strict 40-minute final-exam pressure, programming ability (PAI, p = 0.016) is the sole significant differentiator, while TEI shows no effect (p = 0.93).
Talking Points:
- Splitting learners at the summative exam median of 77.93 shifts the pattern noticeably: 18 of 31 high achievers are High PAI coders (Figure 15).
- In Figure 16, PAI remains statistically significant (p = 0.016), whereas TEI drops completely to p = 0.93.
- The reason is practical: answering four coding questions in 40 minutes leaves little time to craft thorough DTCs, so rapid, low-error coding proficiency dominates timed exams.
Transition: Let's tie all abilities, video behaviors, and scores together through Spearman correlation analysis in RQ3.
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
Key Takeaway: Coding and testing are negatively correlated (PAI vs. TEI = -0.39), while thorough video watching boosts testing (+0.33) and rushing playback hurts coding (-0.24).
Talking Points:
- In Figure 17, resilience r correlates positively with TEI (+0.50) because encountering errors drives learners to debug with DTCs, while PAI and TEI correlate negatively (-0.39), reinforcing that coding and testing are distinct skills.
- Figure 18 links OpenEdu video habits to performance: higher video completion correlates positively with TEI (+0.33), whereas cranking up playback speed correlates negatively with PAI (-0.24).
- Finally, PAI predicts both formative (+0.35) and summative (+0.38) scores, whereas TEI specifically lifts formative performance (+0.26) rather than timed exams (+0.073).
Transition: Let's move to Section 5 to compare our findings with prior literature and discuss key limitations.
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
Key Takeaway: Our findings corroborate Yang et al. (2020) across a much larger 50-exercise novice cohort, while highlighting three concrete study limitations.
Talking Points:
- Like Yang et al. (2020), we confirm that strong coders are not automatically strong testers; our contribution extends this insight from 3 timed CS tasks to 50 self-paced exercises across CS and Non-CS novices with video analytics.
- On the right, we note three limitations: several exercises had baseline OTC TQI above 80, leaving limited room for DTC gains; testing theory was not explicitly taught; and Pytutor cannot observe off-platform local IDE editing.
Transition: Based on these insights and limitations, what should instructors change in their courses?
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
Key Takeaway: Instructors should explicitly teach testing to all majors, micro-segment lecture videos, and design "test-hungry" exercises with modest public OTC coverage.
Talking Points:
- First, teach black-box and boundary-value testing to both CS and Non-CS students, since CS majors show no natural testing advantage and strong testing helps weaker coders excel.
- Second, break long recordings into short, single-concept micro-videos to counter the 56% completion rate and 2.08x speed-watching that hurts coding accuracy.
- Third, intentionally keep public OTC TQI below 70 and pair the -3 point cautionary rule with instant coverage feedback so students must write DTCs to uncover edge cases.
Transition: Let's conclude with a visual synthesis of RQ1 through RQ3 and our roadmap for future work.
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
Key Takeaway: Pytutor reveals that coding and testing are distinct skills shaped by study habits, pointing toward AI Socratic tutoring, richer online IDEs, and controlled experiments.
Talking Points:
- The visual synthesis brings all three RQs together: novices rush videos and blind-submit 23% of exercises; CS majors lead in PAI but not TEI; and testing lifts formative scores while coding speed governs timed exams.
- Moving forward, we plan to integrate a Socratic generative AI assistant to guide edge-case thinking without leaking answers, upgrade the web IDE to capture on-platform editing telemetry, and run controlled experimental studies.
Transition: Thank you for your attention; let's move to the closing slide for questions.
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
Key Takeaway: Thank the audience and invite questions on Pytutor, SE ability metrics, and testing-integrated programming education.
Talking Points:
- Thank you very much for joining this presentation. You can access the full Electronics 2023 article via the DOI listed on screen.
- I welcome any questions or suggestions about Pytutor's architecture, PAI and TEI metrics, or classroom deployment.
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
