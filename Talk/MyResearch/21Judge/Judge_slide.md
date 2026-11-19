---
marp: true
theme: gaia
size: 16:9
paginate: true
html: true
header: '<div class="hdr-wrap"><span class="hdr-title">Understanding Students’ Acceptance of Online Judge Systems (UTAUT2 + PLS-SEM)</span><div class="nav-dropdown"><button class="nav-btn">Sections ▾</button><div class="nav-menu"><a href="#2">Opening Hook: Try #12 &amp; Fun</a><a href="#3">Outline</a><a href="#4">1. Motivation &amp; RQs</a><a href="#6">2. Related Work</a><a href="#7">3. Research Model &amp; Hypotheses</a><a href="#10">4. Methodology &amp; Sample</a><a href="#12">5. PLS-SEM Results</a><a href="#15">6. Discussion &amp; Implications</a><a href="#18">7–8. Conclusion &amp; Future Work</a></div></div></div>'
footer: 'Daramsenge Bilegjargal & Nien-Lin Hsueh · Feng Chia University · IEEE Access (2021)'
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
section.lead strong, section.lead .meta-box strong { color: #ffffff !important; }
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
  font-size: 1.95em;
  font-weight: 800;
  line-height: 1.24;
  margin-bottom: 16px;
  text-align: left;
}

section.lead .subtitle {
  color: #cbd5e1;
  font-size: 0.94em;
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

.kpi-val { font-size: 1.4em; font-weight: 800; color: var(--navy); line-height: 1.15; margin-bottom: 3px; }
.kpi-card.accent .kpi-val { color: var(--accent); }
.kpi-card.teal .kpi-val { color: var(--teal); }
.kpi-label { font-size: 0.76em; color: var(--slate-700); line-height: 1.32; }

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
  line-height: 1.3;
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

.split64 .left img:hover, .split55 .left img:hover {
  transform: scale(1.22);
  transform-origin: left bottom;
  box-shadow: 0 12px 28px rgba(15, 23, 42, 0.22);
  position: relative;
  z-index: 30;
}

.split64 .right img:hover, .split55 .right img:hover {
  transform: scale(1.22);
  transform-origin: right bottom;
  box-shadow: 0 12px 28px rgba(15, 23, 42, 0.22);
  position: relative;
  z-index: 30;
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

/* Incremental RQ Grid */
.rq-stage ul {
  display: flex;
  flex-direction: column;
  gap: 20px;
  list-style: none !important;
  padding: 0 !important;
  margin: 18px 0 0 0 !important;
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
  padding: 18px 22px;
  box-shadow: 0 2px 8px rgba(15, 23, 42, 0.06);
  box-sizing: border-box;
}

.rq-card.teal { border-left-color: var(--teal); }
.rq-card.accent { border-left-color: var(--accent); }

.rq-card img { width: 92px; height: 92px; flex-shrink: 0; border-radius: 10px; }

.rq-hook { font-size: 0.98em; font-weight: 800; color: var(--navy); line-height: 1.28; margin-bottom: 6px; }
.rq-card.teal .rq-hook { color: var(--teal); }
.rq-card.accent .rq-hook { color: var(--accent); }
.rq-q { font-size: 0.86em; color: var(--slate-700); line-height: 1.45; }

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
</style>

<!-- _class: lead -->

<div class="badge">IEEE Access · Vol. 9 · pp. 152606–152615 · November 2021</div>

# Understanding Students’ Acceptance of Online Judge System in Programming Courses

<div class="subtitle">
<strong>A Structural Equation Modeling Approach:</strong> Applying Extended <strong>UTAUT2</strong> &amp; <strong>PLS-SEM</strong> to Uncover What Truly Drives Student Adoption of Automated Programming Assessment
</div>

<div class="meta-box">
<strong>Daramsenge Bilegjargal<sup>*</sup></strong> and <strong>Nien-Lin Hsueh</strong><br>
Department of Information Engineering and Computer Science, Feng Chia University, Taichung, Taiwan<br>
<code>p0731809@o365.fcu.edu.tw</code> · <code>nlhsueh@fcu.edu.tw</code> · DOI: <code>10.1109/ACCESS.2021.3126896</code>
</div>

<div class="grant">
Supported by the Ministry of Science and Technology (MOST), Taiwan, under Grant MOST 109-2221-E-035-056.
</div>

---

## Opening Hook: "Try #12: Wrong Answer!" ... So Why Do Students Keep Using OJs?

<div class="fig-box" style="padding: 6px; margin-bottom: 10px; background: #fbf9f2;">
<img src="./img/judge_hook.jpg" alt="Strict Online Judge vs What Actually Drives Student Acceptance" style="max-height: 410px; border-radius: 6px;">
</div>

<div class="callout" style="margin-top: 6px; padding: 9px 16px;">
<strong>The Surprise Finding:</strong> An extra space (<code>" 12"</code> vs. <code>"12"</code>) triggers instant failure, yet <strong>efficiency &amp; ease of use did NOT predict adoption</strong>! Instead, <strong>fun (Hedonic Motivation)</strong>, <strong>confidence (Self-Efficacy)</strong>, and <strong>peer/teacher support (Social Influence)</strong> win students over — across both CS and non-CS majors.
</div>

---

## Presentation Outline

<div class="outline-grid">

<div class="outline-item">
<div class="outline-num">1</div>
<div class="outline-body">

[**Motivation &amp; Research Questions**](#4)
Why Online Judge acceptance in distance programming remains under-studied and our two RQs.

</div>
</div>

<div class="outline-item">
<div class="outline-num">2</div>
<div class="outline-body">

[**Related Work &amp; Research Gap**](#6)
Online Judge systems, UTAUT2 in education, and PLS-SEM for small-sample causal modeling.

</div>
</div>

<div class="outline-item">
<div class="outline-num">3</div>
<div class="outline-body">

[**Research Model &amp; 12 Hypotheses**](#7)
Extending UTAUT2 with Self-Efficacy, Anxiety, and Academic Major (H1–H12).

</div>
</div>

<div class="outline-item">
<div class="outline-num">4</div>
<div class="outline-body">

[**Course Context, Survey &amp; Sample**](#10)
6-week blended FCU Data Science course, 22-item survey (n = 187), and PLS-SEM pipeline.

</div>
</div>

<div class="outline-item">
<div class="outline-num">5</div>
<div class="outline-body">

[**PLS-SEM Measurement &amp; Structural Results**](#12)
Reliability/validity checks, R<sup>2</sup> = 0.754, direct drivers (RQ1), and major moderation (RQ2).

</div>
</div>

<div class="outline-item">
<div class="outline-num">6</div>
<div class="outline-body">

[**Discussion, Implications &amp; Conclusion**](#15)
Why 8 hypotheses were rejected, actionable design playbook, limitations, and future work.

</div>
</div>

</div>

---

## 1.1 Motivation: Automated Grading Alone Doesn’t Guarantee Adoption

<div class="fig-box" style="padding: 10px 12px; margin-bottom: 10px;">
<img src="./img/diag1_oj_motivation.svg" alt="System-Centric OJ Engineering vs Learner-Centric Acceptance Modeling" style="max-height: 365px;">
</div>

<div class="callout">
<strong>Why This Matters:</strong> While automated programming assessment systems (APAS) like Codeforces, UVa, SPOJ, and Edgar slash grading workload, <strong>no prior empirical study</strong> examined what drives students to actually accept an Online Judge in an online course.
</div>

---

## 1.2 Two Core Research Questions

To bridge this gap, we investigate student acceptance of an OJ system in a blended programming course using **UTAUT2 + PLS-SEM** *(revealed step-by-step)*:

<div class="rq-stage">

* <div class="rq-card teal"><img src="./img/rq1_factors.svg" alt="RQ1 Significant Acceptance Factors"><div><div class="rq-hook"><span class="rq-tag" style="background:#0f766e;">RQ1</span> What truly motivates students to embrace an Online Judge?</div><div class="rq-q"><strong>What are the significant factors</strong> (among performance, effort, social influence, facilitating conditions, hedonic motivation, self-efficacy, anxiety, and major) that affect students’ <strong>acceptance of and behavioral intention to use</strong> an OJ system in an online programming course?</div></div></div>
* <div class="rq-card accent"><img src="./img/rq2_major.svg" alt="RQ2 Academic Major Moderation"><div><div class="rq-hook"><span class="rq-tag">RQ2</span> Does being a CS vs. non-CS major change how those factors work?</div><div class="rq-q"><strong>Does academic major (MJR) moderate</strong> the causal relationships between candidate psychological/usability factors (EE, HM, SE, ANX) and students’ <strong>behavioral intention</strong> to use an OJ system?</div></div></div>

</div>

---

## 2. Related Work: Online Judges, UTAUT2 &amp; PLS-SEM

Existing OJ studies focus on system engineering or learning outcomes rather than **technology acceptance**, while UTAUT2 studies target general e-learning platforms.

| Research Stream | Representative Studies | Key Findings / Focus | Gap Addressed by Our Study |
| :--- | :--- | :--- | :--- |
| **Online Judge (OJ) Systems** | Mekterovic *et al.* (*Edgar*, 2020); Petit *et al.* (*Jutge.org*, 2018); Aleman (2011); Galan *et al.* (2019) | Multi-language auto-grading, tournament fun, stronger retention &amp; grade correlation after training | Lack empirical behavioral-acceptance models explaining *why* learners adopt OJs |
| **UTAUT / UTAUT2 in EdTech** | Venkatesh *et al.* (2003, 2012); Huang (2020); Jakkaew &amp; Hemrungrote (2017); Salloum *et al.* (2019) | Integrates 8 theories (TRA, TPB, TAM…); PE, HM, SE &amp; playfulness drive VR, Google Classroom &amp; LMS use | Never applied with demographic moderation to **online programming OJ systems** |
| **PLS-SEM Modeling** | Hair *et al.* (2011, 2017); Lin *et al.* (2019); Wong (2013) | Nonparametric bootstrap; robust to small samples &amp; non-normal data; 2-step outer/inner evaluation | Ideal for single-semester course empirical survey (`n = 187`) &amp; prediction |

<div class="callout teal">
<strong>Theoretical Contribution:</strong> First study to pair an <strong>extended UTAUT2 model</strong> (adding Self-Efficacy, Anxiety &amp; Academic Major) with <strong>PLS-SEM</strong> in an automated online programming assessment context.
</div>

---

## 3.1 Theoretical Foundation: Adapting UTAUT2 to Online Judges

<div class="split55">
<div class="left">

<div class="fig-box">
<img src="./img/fig1_utaut2.png" alt="Fig. 1: Conceptual framework of the UTAUT2 model" style="max-height: 390px;">
<div class="fig-cap">Fig. 1: Original UTAUT2 Conceptual Framework (Venkatesh et al., 2012 [13])</div>
</div>

</div>
<div class="right small-text">

### 🎯 Context-Driven Model Adaptation
- **Retained Core UTAUT2 Constructs (5)**:
  - Performance Expectancy (`PE`), Effort Expectancy (`EE`), Social Influence (`SI`), Facilitating Conditions (`FC`), Hedonic Motivation (`HM`)
- **Excluded Non-Applicable Constructs (3)**:
  - *Price Value*: OJ is **free** for university students.
  - *Habit*: Course-bound tool, not everyday consumer use.
  - *Use Behavior*: Mandatory course context; `BI` predicts future open-OJ use (e.g., LeetCode).
- **Added Educational &amp; Coding Constructs (3)**:
  - **Self-Efficacy (`SE`)**, **Anxiety (`ANX`)**, and **Academic Major (`MJR`)** (IECS vs. EE vs. Other).

</div>
</div>

---

## 3.2 Proposed Research Model &amp; 12 Hypotheses (H1–H12)

<div class="split55">
<div class="left">

<div class="fig-box">
<img src="./img/fig2_research_model.png" alt="Fig. 2: Proposed Research Model H1-H12" style="max-height: 395px;">
<div class="fig-cap">Fig. 2: Proposed Extended UTAUT2 Research Model (darker lines = moderated paths)</div>
</div>

</div>
<div class="right small-text">

### 📋 Group 1: Direct Effects on BI (8 Paths)
- **H1**: `PE ➔ BI` (+) · **H2**: `EE ➔ BI` (+)
- **H4**: `SI ➔ BI` (+) · **H5**: `FC ➔ BI` (+)
- **H6**: `HM ➔ BI` (+) · **H8**: `SE ➔ BI` (+)
- **H10**: `ANX ➔ BI` (−) · **H12**: `MJR ➔ BI` (+)

### 🎓 Group 2: Major Moderation (4 Paths)
- **H3**: `MJR × EE ➔ BI` (prior IDE familiarity)
- **H7**: `MJR × HM ➔ BI` (CS coding interest)
- **H9**: `MJR × SE ➔ BI` (prior OJ confidence)
- **H11**: `MJR × ANX ➔ BI` (stress sensitivity)

</div>
</div>

---

## 3.3 Why These Constructs Matter in an OJ Classroom

<div class="two-col">
<div class="card small-text">

### 🛠️ Core UTAUT Drivers (PE, EE, SI, FC)
- **Performance Expectancy (`PE`)**: Instant compile/run feedback helps students iteratively fix code quality until all test cases pass.
- **Effort Expectancy (`EE`)**: Simple web workspace, yet OpenEdu SSO login &amp; strict test-case judging add learning overhead.
- **Social Influence (`SI`)**: IECS built its own OJ and actively encouraged **senior students, TAs &amp; peers** to help each other.
- **Facilitating Conditions (`FC`)**: Exact string diff (e.g., `" 12"` ≠ `"12"`) frustrates novices unless clear guides &amp; support exist.

</div>
<div class="card teal small-text">

### 🧠 Psychological &amp; Major Factors (HM, SE, ANX, MJR)
- **Hedonic Motivation (`HM`)**: **5 of 6 units** featured gamified coding quests — students unlock the next level only after passing the current one.
- **Self-Efficacy (`SE`)**: Confidence to debug independently when stuck in distance learning without an instructor nearby.
- **Anxiety (`ANX`)**: Students average **~12 submissions** per problem, fear losing code on misclicks, and see **public rankings**.
- **Academic Major (`MJR`)**: IECS students view coding as a core career skill vs. EE (moderate) &amp; Other departments.

</div>
</div>

---

## 4.1 Blended Course Context &amp; PLS-SEM Research Pipeline

<div class="fig-box" style="padding: 8px 10px; margin-bottom: 8px;">
<img src="./img/diag2_study_pipeline.svg" alt="Blended Course Context and Two-Stage PLS-SEM Pipeline" style="max-height: 310px;">
</div>

<div class="callout" style="margin-top: 6px; padding: 8px 14px;">
<strong>Why SmartPLS 3.0 (PLS-SEM)?</strong> Unlike covariance-based SEM, PLS-SEM is a nonparametric bootstrap approach requiring <strong>no multivariate normality assumption</strong> and offering high statistical power for exploratory prediction with <code>n = 187</code>.
</div>

---

## 4.2 Participant Demographics (`n = 187`, Table 1)

<div class="three-col" style="margin-bottom: 10px;">
<div class="kpi-card">
<div class="kpi-val">187 / ~300</div>
<div class="kpi-label">Voluntary undergrad respondents (~62% response rate, Spring 2021)</div>
</div>
<div class="kpi-card teal">
<div class="kpi-val">83.4% IECS</div>
<div class="kpi-label">156 IECS, 23 EE (12.3%), and 8 Other Departments (4.3%)</div>
</div>
<div class="kpi-card accent">
<div class="kpi-val">80.2% Prior OJ</div>
<div class="kpi-label">150 had prior OJ experience vs. 37 first-time users (19.8%)</div>
</div>
</div>

<div class="split55">
<div class="left">

| Demographic Item | Category | Freq. | % |
| :--- | :--- | :---: | :---: |
| **Academic Major** | Dept. of IECS | 156 | 83.4% |
| | Dept. of EE | 23 | 12.3% |
| | Other departments | 8 | 4.3% |
| **Gender** | Male / Female | 150 / 37 | 80.2% / 19.8% |
| **Year of Study** | 1st / 2nd / 3rd / 4th | 36 / 53 / 72 / 26 | 19.2 / 28.3 / 38.5 / 14.0% |
| **OJ Experience** | Yes / No | 150 / 37 | 80.2% / 19.8% |

</div>
<div class="right small-text">

### 📊 Year &amp; Major Distribution
<div style="margin-top: 10px;">
<div class="bar-row"><div><strong>IECS Major</strong></div><div class="bar-track"><div class="bar-fill" style="width: 83.4%;"></div></div><div class="bar-pct">83.4%</div></div>
<div class="bar-row"><div><strong>EE Major</strong></div><div class="bar-track"><div class="bar-fill teal" style="width: 12.3%;"></div></div><div class="bar-pct">12.3%</div></div>
<div class="bar-row"><div><strong>Other Depts.</strong></div><div class="bar-track"><div class="bar-fill accent" style="width: 4.3%;"></div></div><div class="bar-pct">4.3%</div></div>
<div class="bar-row"><div><strong>3rd Year (Peak)</strong></div><div class="bar-track"><div class="bar-fill teal" style="width: 38.5%;"></div></div><div class="bar-pct">38.5%</div></div>
<div class="bar-row"><div><strong>Prior OJ Exp.</strong></div><div class="bar-track"><div class="bar-fill" style="width: 80.2%;"></div></div><div class="bar-pct">80.2%</div></div>
</div>

</div>
</div>

---

## 5.1 Measurement Model Assessment (Outer Model · Tables 2–4)

<div class="split55">
<div class="left">

<div class="fig-box">
<img src="./img/fig3_pls_results.png" alt="Fig. 3: Measurement results of PLS-Algorithm" style="max-height: 390px;">
<div class="fig-cap">Fig. 3: PLS-Algorithm Outer Loadings &amp; Path Coefficients (SmartPLS 3.0)</div>
</div>

</div>
<div class="right small-text">

### ✅ Reliability &amp; Validity Verification
| Construct | CL (≥0.7) | α (≥0.7) | CR (≥0.7) | AVE (>0.5) |
| :--- | :---: | :---: | :---: | :---: |
| **HM** (2 items) | 0.962–0.965 | 0.924 | 0.963 | **0.929** |
| **SE** (2 items) | 0.938–0.940 | 0.867 | 0.938 | **0.882** |
| **EE** (2 items) | 0.872–0.927 | 0.769 | 0.895 | **0.810** |
| **SI** (2 items) | 0.875–0.914 | 0.752 | 0.889 | **0.800** |
| **ANX** (2 items) | 0.810–0.956 | 0.753 | 0.879 | **0.786** |
| **BI** (2 items) | 0.835–0.918 | 0.708 | 0.870 | **0.770** |
| **PE** (3 items) | 0.837–0.880 | 0.827 | 0.896 | **0.741** |
| **FC** (3 items) | 0.816–0.877 | 0.794 | 0.879 | **0.709** |

- **Fornell-Larcker (Tables 3–4)**: All diagonal √AVE values (`0.842–0.964`) exceed every off-diagonal correlation ➔ **strong discriminant validity**.

</div>
</div>

---

## 5.2 Structural Model: Direct Effects &amp; RQ1 Results (Tables 5–6)

<div class="three-col" style="margin-bottom: 8px;">
<div class="kpi-card teal">
<div class="kpi-val">R<sup>2</sup> = 0.754</div>
<div class="kpi-label"><strong>Substantial</strong> explained variance in Behavioral Intention (> 0.67)</div>
</div>
<div class="kpi-card">
<div class="kpi-val">Q<sup>2</sup> = 0.532</div>
<div class="kpi-label">Blindfolding cross-validated redundancy (> 0 = <strong>predictive relevance</strong>)</div>
</div>
<div class="kpi-card accent">
<div class="kpi-val">4 / 8 Supported</div>
<div class="kpi-label"><strong>HM, SE, SI &amp; MJR</strong> significantly predict BI (bootstrapping two-tailed)</div>
</div>
</div>

<div class="split55">
<div class="left">

| Hyp. | Path | Orig. (O) | SD | t (>1.96) | p (<0.05) | Result |
| :---: | :--- | :---: | :---: | :---: | :---: | :---: |
| **H6** | **HM ➔ BI** | **0.400** | 0.080 | **5.008** | **0.000\*\*** | **✓ S** |
| **H8** | **SE ➔ BI** | **0.316** | 0.067 | **4.731** | **0.000\*\*** | **✓ S** |
| **H4** | **SI ➔ BI** | **0.245** | 0.102 | **2.391** | **0.017\*** | **✓ S** |
| **H12** | **MJR ➔ BI** | **-0.098** | 0.044 | **2.239** | **0.026\*** | **✓ S** |
| H1 | PE ➔ BI | 0.066 | 0.074 | 0.891 | 0.373 | ✗ NS |
| H2 | EE ➔ BI | -0.035 | 0.076 | 0.457 | 0.648 | ✗ NS |
| H10 | ANX ➔ BI | 0.011 | 0.038 | 0.282 | 0.778 | ✗ NS |
| H5 | FC ➔ BI | 0.010 | 0.104 | 0.098 | 0.922 | ✗ NS |

</div>
<div class="right small-text">

### 🏆 Ranking of Significant Drivers (RQ1)
<div style="margin-top: 8px;">
<div class="bar-row"><div><strong>HM (Fun)</strong></div><div class="bar-track"><div class="bar-fill teal" style="width: 100%;"></div></div><div class="bar-pct">β = 0.400</div></div>
<div class="bar-row"><div><strong>SE (Confidence)</strong></div><div class="bar-track"><div class="bar-fill teal" style="width: 79%;"></div></div><div class="bar-pct">β = 0.316</div></div>
<div class="bar-row"><div><strong>SI (Social)</strong></div><div class="bar-track"><div class="bar-fill" style="width: 61.3%;"></div></div><div class="bar-pct">β = 0.245</div></div>
<div class="bar-row"><div><strong>MJR (Direct)</strong></div><div class="bar-track"><div class="bar-fill accent" style="width: 24.5%;"></div></div><div class="bar-pct">|β| = 0.098</div></div>
</div>

<div class="callout teal" style="margin-top: 10px;">
<strong>RQ1 Answer:</strong> <strong>Hedonic Motivation</strong> is the #1 predictor, followed by <strong>Self-Efficacy</strong> and <strong>Social Influence</strong> — outweighing utility (<code>PE</code>, <code>EE</code>, <code>FC</code>).
</div>

</div>
</div>

---

## 5.3 Moderating Effects of Academic Major — RQ2 Results (Table 7)

All four hypothesized moderating effects of **Academic Major (`MJR`)** were statistically **non-significant** (`t < 1.96`, `p > 0.05`):

| Hyp. | Moderated Relationship | Orig. Sample (O) | Sample Mean (M) | SD | t-Stat (>1.96) | p-Value (<0.05) | Result |
| :---: | :--- | :---: | :---: | :---: | :---: | :---: | :---: |
| **H3** | `MJR × EE ➔ BI` | 0.064 | 0.060 | 0.065 | 0.985 | 0.325 | **✗ NS** |
| **H7** | `MJR × HM ➔ BI` | 0.006 | -0.013 | 0.083 | 0.067 | 0.947 | **✗ NS** |
| **H9** | `MJR × SE ➔ BI` | -0.002 | 0.016 | 0.076 | 0.029 | 0.977 | **✗ NS** |
| **H11** | `MJR × ANX ➔ BI` | 0.060 | 0.053 | 0.065 | 0.921 | 0.358 | **✗ NS** |

<div class="two-col" style="margin-top: 12px;">
<div class="card accent small-text">

### ⚖️ No Moderation (`H3, H7, H9, H11` Rejected)
- Whether a student is **IECS, EE, or non-CS**, enjoyment (`HM`) and problem-solving confidence (`SE`) boost OJ acceptance at virtually identical strength.
- Neither CS nor non-CS students found the editor especially convenient (`H3`), and neither group felt anxious (`H11`).

</div>
<div class="card teal small-text">

### 🎯 Yet Significant Direct Effect (`H12`, p = 0.026*)
- Academic major **directly affects baseline intention** (`t = 2.239`), likely reflecting career relevance of coding practice (e.g., future LeetCode use).
- **Encouraging takeaway**: Non-CS students can succeed equally well when motivated, self-confident, and supported!

</div>
</div>

---

## 6.1 Diagnostic Deep Dive: Why Were 8 Hypotheses Rejected?

Turning non-significant paths into **actionable UX and pedagogical diagnostics**:

| Rejected Path | Statistical Result | Root-Cause Diagnosis from Course &amp; Student Interviews | Design Implication |
| :--- | :---: | :--- | :--- |
| **H1: `PE ➔ BI`** | `p = 0.373` (NS) | Unlike professional IDEs, the OJ lacked **debugging information**, limiting perceived workspace productivity | Integrate step-by-step **debugger / diagnostic hints** into OJ |
| **H2: `EE ➔ BI`** | `p = 0.648` (NS) | Web editor UX friction — e.g., **auto-indent on Enter** forced manual deletion or caused Python compile errors | Fix editor formatting &amp; offer modern IDE-grade editing UX |
| **H5: `FC ➔ BI`** | `p = 0.922` (NS) | Clear course guidelines &amp; upfront reminders already pre-empted operational hurdles (ceiling effect) | Maintain concise onboarding checklists &amp; FAQ docs |
| **H10: `ANX ➔ BI`** | `p = 0.778` (NS) | **Troubleshooting guideline videos** eliminated technical fear across all majors — inconvenient ≠ anxious | Keep short troubleshooting videos to prevent drop-off |
| **H3, H7, H9, H11** | `p = 0.325–0.977` | CS students compared OJ unfavorably to IDEs; non-CS still faced steep learning; fun &amp; SE mattered universally | Design **universal gamification &amp; scaffolding** for all majors |

---

## 6.2 Practical Implications: A Playbook for Developers &amp; Instructors

<div class="two-col">
<div class="card small-text">

### 💻 For OJ Developers &amp; University Policymakers
1. **Double Down on Gamification (`HM`, β = 0.400)**:
   - Expand staged quests, progress bars, badges, and unlockable units to sustain self-directed engagement.
2. **Add Real Debugging Support (`PE`)**:
   - Provide structured runtime/compiler diagnostics instead of opaque `Wrong Answer` verdicts.
3. **Eliminate Editor Friction (`EE`)**:
   - Fix language-specific quirks (like Python auto-indent traps) and smooth SSO workflows.
4. **Design Anxiety-Safe Feedback (`ANX`)**:
   - Auto-save code drafts and reconsider always-visible public rankings that heighten grade stress.

</div>
<div class="card teal small-text">

### 👩‍🏫 For Programming Instructors &amp; Course Designers
1. **Cultivate Self-Efficacy (`SE`, β = 0.316)**:
   - Provide short **troubleshooting videos** and scaffolded starter problems so students gain confidence solving bugs independently.
2. **Build Active Social Support (`SI`, β = 0.245)**:
   - Pair online OJ practice with responsive **TA forums, messaging channels, email, and senior-student mentoring**.
3. **Empower Cross-Major Cohorts (`MJR`)**:
   - Do not assume non-CS students cannot thrive on OJs: clear guidelines + fun tasks + supportive instructors bridge the major gap.

</div>
</div>

---

## 7. Limitations &amp; Threats to Validity

<div class="three-col">
<div class="card small-text">

### 🏫 Single-Course Sample Scope
- Respondents (`n = 187`) came from **one undergraduate course** at a single university (FCU, Taiwan).
- **83.4%** were IECS majors and **80.2%** had prior OJ experience, which may constrain generalizability to novice-heavy or humanities cohorts.

</div>
<div class="card accent small-text">

### 📅 Age &amp; Demographic Homogeneity
- Because undergraduate participants were close in age, the core UTAUT2 moderator of **age** could not be evaluated.
- Future studies should recruit broader age groups (e.g., **MOOCs** and lifelong learners) to test age moderation.

</div>
<div class="card teal small-text">

### 📈 Intention vs. Longitudinal Use
- The study measured **Behavioral Intention (`BI`)** after 6 weeks rather than long-term post-course **Use Behavior** (e.g., voluntary LeetCode practice).
- Combining survey data with **OJ submission logs** would triangulate intention with actual coding behavior.

</div>
</div>

---

## 8. Conclusion &amp; Future Work

<div class="fig-box" style="padding: 8px 10px; margin-bottom: 8px;">
<img src="./img/diag3_rq_conclusions.svg" alt="Visual Synthesis of RQ1 and RQ2 Conclusions" style="max-height: 355px;">
</div>

<div class="future-strip">
<div class="future-pill"><strong>🌐 1. Broader MOOC Cohorts</strong><br>Extend sampling beyond one campus course to diverse universities and massive open online courses (MOOCs).</div>
<div class="future-pill"><strong>👥 2. Age &amp; Longitudinal Tracking</strong><br>Test UTAUT2 age moderation and link behavioral intention to actual long-term coding practice logs.</div>
<div class="future-pill"><strong>🎮 3. Gamified + Debugger OJ</strong><br>Co-design next-gen OJs combining richer gamification with built-in debugging hints and frictionless editors.</div>
</div>

---

<!-- _class: closing -->

# Thank You for Your Attention!

<p style="font-size: 1.04em; max-width: 860px;">
Understanding Students’ Acceptance of Online Judge System in Programming Courses: A Structural Equation Modeling Approach
</p>

<div class="contact-card">
<strong>Daramsenge Bilegjargal<sup>*</sup></strong> &nbsp;·&nbsp; <code>p0731809@o365.fcu.edu.tw</code><br>
<strong>Nien-Lin Hsueh</strong> &nbsp;·&nbsp; <code>nlhsueh@fcu.edu.tw</code><br>
Department of Information Engineering and Computer Science, Feng Chia University, Taiwan<br>
Published in <strong>IEEE Access</strong>, Vol. 9, pp. 152606–152615 (2021) · DOI: <code>10.1109/ACCESS.2021.3126896</code><br>
<span style="font-size: 0.85em; opacity: 0.85;">Grant: MOST 109-2221-E-035-056 · Questions &amp; Discussion Welcome!</span>
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
