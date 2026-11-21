---
marp: true
theme: gaia
size: 16:9
paginate: true
html: true
header: '<div class="hdr-wrap"><span class="hdr-title">Behavioral Engagement in an Online Programming Course (PLS-SEM)</span><div class="nav-dropdown"><button class="nav-btn">Sections ▾</button><div class="nav-menu"><a href="#2">Opening Hook: Passive vs. Active</a><a href="#3">Outline</a><a href="#4">1. Introduction & RQs</a><a href="#6">2. Literature Review</a><a href="#7">3. Course Design & Model</a><a href="#12">4. PLS-SEM & IPMA Results</a><a href="#17">5. Implications & Limitations</a><a href="#18">6. Conclusion & Future Work</a></div></div></div>'
footer: 'Nien-Lin Hsueh, Bilegjargal Daramsenge & Lien-Chi Lai · Feng Chia University · JITE:Research (2022)'
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
  font-size: 0.95em;
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
  font-size: 0.88em;
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
  letter-spacing: 0.05em;
  text-transform: uppercase;
  padding: 5px 14px;
  border-radius: 999px;
  margin-bottom: 18px;
}

section.lead h1 {
  color: #ffffff;
  font-size: 1.88em;
  font-weight: 800;
  line-height: 1.24;
  margin-bottom: 14px;
  text-align: left;
}

section.lead .subtitle {
  color: #cbd5e1;
  font-size: 0.92em;
  line-height: 1.5;
  margin-bottom: 24px;
  max-width: 960px;
}

section.lead .meta-box {
  border-left: 4px solid #f43f5e;
  padding-left: 18px;
  color: #e2e8f0;
  font-size: 0.84em;
  line-height: 1.58;
}

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
.two-col { display: grid; grid-template-columns: 1fr 1fr; gap: 20px; align-items: stretch; }
.three-col { display: grid; grid-template-columns: repeat(3, 1fr); gap: 15px; align-items: stretch; }
.split64 { display: grid; grid-template-columns: 54% 44%; gap: 2%; align-items: center; }
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
.kpi-label { font-size: 0.75em; color: var(--slate-700); line-height: 1.32; }

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
  font-size: 0.72em;
  margin: 5px 0;
  background: #ffffff;
  border: 1px solid var(--slate-200);
}

th {
  background: var(--navy);
  color: #ffffff;
  font-weight: 700;
  padding: 5px 7px;
  text-align: left;
  border: 1px solid var(--navy);
}

td {
  padding: 4.5px 7px;
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

<div class="badge">Journal of Information Technology Education: Research · Vol. 21, 2022, pp. 403–423</div>

# Exploring the Influence of Students' Modes of Behavioral Engagement in an Online Programming Course

<div class="subtitle">
Using the <strong>Partial Least Squares Structural Equation Modeling (PLS-SEM)</strong> &amp; <strong>Importance-Performance Map Analysis (IPMA)</strong> Approach
</div>

<div class="meta-box">
<strong>Nien-Lin Hsueh</strong>, <strong>Bilegjargal Daramsenge*</strong>, and <strong>Lien-Chi Lai</strong><br>
Department of Information Engineering and Computer Science, Feng Chia University, Taichung, Taiwan<br>
<code>nlhsueh@fcu.edu.tw</code> · <code>P0731809@o365.fcu.edu.tw</code> · <code>P1000433@mail.fcu.edu.tw</code>
</div>

<div class="grant">
Supported by the Ministry of Science and Technology (MOST), Taiwan, under grant MOST 110-2221-E-035-031-MY2 · DOI: 10.28945/5010
</div>

---

## Opening Hook: "Logged In Every Day!" ... Why Didn't Grades Move?

<div class="fig-box" style="padding: 6px; margin-bottom: 10px; background: #fbf9f2;">
<img src="./img/engagement_hook.jpg" alt="Passive Study vs Active Engagement in Online Programming" style="max-height: 415px; border-radius: 6px;">
</div>

<div class="callout" style="margin-top: 6px; padding: 9px 16px;">
<strong>The Big Idea:</strong> Simply logging in every day (<code>Online_days</code>) or clicking online textbooks (<code>Doc_count</code>) does <strong>not</strong> directly raise coding grades. Only when behavioral activity channels through <strong>cognitive self-assessment</strong> (<code>Unit_test</code>, <code>Game_test</code>, <code>OJ_test</code>) and <strong>active video watching</strong> do grades soar (<strong>R<sup>2</sup> = 77.1%</strong>).
</div>

---

## Presentation Outline

<div class="outline-grid">

<div class="outline-item">
<div class="outline-num">1</div>
<div class="outline-body">

[**Introduction & Research Questions**](#4)
Limitations of traditional LMS/OJ tools and our three guiding questions (RQ1–RQ3).

</div>
</div>

<div class="outline-item">
<div class="outline-num">2</div>
<div class="outline-body">

[**Literature Review**](#6)
Prior findings on video viewing, learning materials, self-assessment, and behavioral analytics.

</div>
</div>

<div class="outline-item">
<div class="outline-num">3</div>
<div class="outline-body">

[**Course Design & Research Model**](#7)
FCU Python blended MOOC (N = 217), OpenEdu log pipeline, 13 indicators, and H1–H7.

</div>
</div>

<div class="outline-item">
<div class="outline-num">4</div>
<div class="outline-body">

[**PLS-SEM & IPMA Empirical Results**](#12)
Measurement reliability, direct paths (RQ1), mediation (RQ2), and IPMA maps (RQ3).

</div>
</div>

<div class="outline-item">
<div class="outline-num">5</div>
<div class="outline-body">

[**Implications & Study Limitations**](#17)
Actionable recommendations for platform developers, policymakers, and instructors.

</div>
</div>

<div class="outline-item">
<div class="outline-num">6</div>
<div class="outline-body">

[**Conclusion & Future Work**](#18)
Visual synthesis of RQ1–RQ3 findings and roadmap for MOOCs and affective analytics.

</div>
</div>

</div>

---

## 1.1 Motivation: Beyond Click Counts and Blind OJ Scores

<div class="fig-box" style="padding: 8px; margin-bottom: 10px;">
<img src="./img/diag1_motivation.svg" alt="Motivation Contrast: Traditional LMS vs Integrated PLS-SEM + IPMA" style="max-height: 335px;">
</div>

<div class="three-col">
<div class="kpi-card">
<div class="kpi-val">217 Students</div>
<div class="kpi-label">Active undergraduates in FCU's MOE Award-winning Python blended course (Spring 2021)</div>
</div>
<div class="kpi-card teal">
<div class="kpi-val">5 Constructs · 13 Logs</div>
<div class="kpi-label">Behavioral (Time, Video, Docs) + Cognitive Mediator (Self-Assessment) ➔ Final Grade</div>
</div>
<div class="kpi-card accent">
<div class="kpi-val">R<sup>2</sup> = 0.771</div>
<div class="kpi-label">Substantial in-sample predictive power explaining 77.1% of final project grade variance</div>
</div>
</div>

---

## 1.2 Research Questions

<div class="rq-stage">

* <div class="rq-card"><img src="./img/rq1_icon.svg" alt="RQ1 Direct Effects"><div><div class="rq-hook">RQ1 · Direct Effects — Which Online Study Habits Actually Raise Coding Grades?</div><div class="rq-q">What is the <strong>direct effect</strong> of students' behavioral engagement types (Online Time, Video Watching, Online Document Reading) and cognitive self-assessment on their final grades in an online programming course? <em>(Tested via H1, H3, H5, H7)</em></div></div></div>
* <div class="rq-card teal"><img src="./img/rq2_icon.svg" alt="RQ2 Cognitive Mediation"><div><div class="rq-hook">RQ2 · Cognitive Mediation — Does Self-Assessment Bridge Activity to Mastery?</div><div class="rq-q">What is the <strong>mediating role of cognitive engagement</strong> (Self-Assessment: Unit Quiz, 4-HP Game, Online Judge) on the relationship between behavioral engagement types and final grades? <em>(Tested via H2, H4, H6 + Bootstrapped Indirect Effects)</em></div></div></div>
* <div class="rq-card accent"><img src="./img/rq3_icon.svg" alt="RQ3 IPMA Priority Drivers"><div><div class="rq-hook">RQ3 · Priority Drivers — Where Should Instructors &amp; Platforms Invest First?</div><div class="rq-q">Which specific constructs and log indicators <strong>most strongly affect students' performance</strong>, and which high-importance activities currently suffer from low performance? <em>(Investigated via Importance-Performance Map Analysis, IPMA)</em></div></div></div>

</div>

---

## 2. Literature Review: Engagement in Online Programming

<div class="three-col">
<div class="card small-text">

### 🎬 Video Watching Behavior
- **In-Video Quizzes**: Cummins et al. (2015) achieved consistently high engagement (**71%–86%**) with interactive video questions.
- **Grade Correlation**: Picardo et al. (2021) found lecture recording views significantly correlate with CS1 grades—even lifting repeat students' scores.
- **Viewing Strategies**: Li (2019) & Yoon et al. (2021) linked active pausing/seeking to higher achievement.

</div>
<div class="card accent small-text">

### 📖 Materials & Self-Assessment
- **Interactive Docs**: Isomöttönen & Tirronen (2016) showed e-books work best when paired with quizzes, feedback, and embedded coding boxes.
- **Fair Self-Evaluation**: Ngai et al. (2010) proved beginners assess themselves objectively given instant feedback.
- **Automated Explanations**: Lepp et al. (2017) found self-assessment tools cut instructor support load in MOOCs.

</div>
<div class="card teal small-text">

### 📊 Behavioral Log Analytics
- **IDE Logging**: Watson et al. (2013) predicted **42.49%** of coursework variance directly from BlueJ IDE logs (N = 45).
- **Flipped PLS-SEM**: Wang (2017, 2019) showed problem-solving & self-reflection drive Moodle achievement (N = 488).
- **Research Gap**: Few studies link **MOOC behavioral logs** + **cognitive self-assessment** + **IPMA** in programming.

</div>
</div>

<div class="callout">
<strong>Theoretical Anchor:</strong> We adapt <strong>G. Sun &amp; Bin's (2018)</strong> MOOC behavioral engagement evaluation framework and integrate it with <strong>PLS-SEM</strong> (Hair et al., 2019) to model causal paths without strict normality assumptions.
</div>

---

## 3.1 Blended Python Course Design & Participants

<div class="two-col">
<div class="card small-text">

### 🏫 Course Format & Pedagogical Design
- **Course**: Basic Python Programming (computation, logic, collections, functions, basic `pandas` analysis) at **Feng Chia University**, Spring 2021.
- **Blended Schedule**: **2 hrs/week** flexible online study + **1 hr/week** in-class discussion.
- **Interactive Suite**: Quiz-in-video, Trinket online workshops, Google Slide flashcards, Google Docs textbook, StarTrec lite **Game-test**, and **Online Judge (OJ)**.
- **Recognition**: Winner of Taiwan Ministry of Education's **Outstanding MOOC Award**.

</div>
<div class="card teal small-text">

### 👥 Sample & Authentic Final Assessment
- **Participants**: **315** initially enrolled ➔ **217 active students** retained after removing inactive accounts with zero behavioral logs.
- **Major Distribution**:
  - **177 (82%)** Information Engineering & Computer Science (IECS)
  - **40 (18%)** Non-CS majors (Materials, Applied Math, Business, Aerospace, Civil, Statistics, EE, etc.)
- **Final Grade (`Score`)**: Open-data Python term project (e.g., decade traffic trends or Taiwan birth rates since 1900) measuring real problem-solving skill.

</div>
</div>

<div class="callout">
<strong>Why Open-Data Projects?</strong> Grounding Python tasks in familiar Taiwan government open datasets keeps beginners focused on coding logic rather than abstract domain rules.
</div>

---

## 3.2 Multi-Platform Log Processing & PLS-SEM Pipeline

<div class="fig-box" style="padding: 8px; margin-bottom: 10px;">
<img src="./img/diag2_log_pipeline.svg" alt="Log Data Processing and SmartPLS 3.3.6 Pipeline" style="max-height: 365px;">
</div>

<div class="callout" style="margin-top: 6px;">
<strong>Why PLS-SEM (SmartPLS 3.3.6)?</strong> Ideal for exploratory causal models with multiple latent constructs, non-normal log distributions, and moderate sample sizes (N = 217), while enabling <strong>bootstrapped mediation</strong> (5,000 subsamples) and <strong>IPMA</strong>.
</div>

---

## 3.3 Research Model & Seven Hypotheses (H1–H7)

<div class="split64">
<div class="left small-text">

### 🧭 Hypothesized Causal Paths
- **Online Time** (`Online_days`):
  - **H1**: Online time ➔ Final grade *(direct)*
  - **H2**: Online time ➔ Self-assessment
- **Video Watching** (7 OpenEdu actions):
  - **H3**: Video watching ➔ Final grade *(direct)*
  - **H4**: Video watching ➔ Self-assessment
- **Online Document Reading** (`Doc_count`):
  - **H5**: Online doc use ➔ Final grade *(direct)*
  - **H6**: Online doc use ➔ Self-assessment
- **Cognitive Mediator** (`Self-assessment`):
  - **H7**: Self-assessment ➔ Final grade

</div>
<div class="right">
<div class="fig-box">
<img src="./img/fig1_research_model.png" alt="Figure 1: Proposed PLS-SEM Research Model (H1-H7)" style="max-height: 390px;">
<div class="fig-cap">Figure 1: Research model with 5 constructs, 13 indicators &amp; H1–H7.</div>
</div>
</div>
</div>

---

## 3.4 Behavioral & Cognitive Constructs Defined

| Engagement Type | Construct | Log Indicators (13 Retained from 28) | Operational Meaning |
| :--- | :--- | :--- | :--- |
| **Behavioral** | **Online Time** | `Online_days` (1 item) | Number of active days with OpenEdu activity logs |
| **Behavioral** | **Video Watching** | `Load_count`, `Play_count`, `Pause_count`, `Stop_count`, `Seek_backward_count`, `Video_count`, `Watching_time` (7 items) | Classroom entry, study frequency, thinking pauses, stopping, active content review, unique videos watched & total viewing duration |
| **Behavioral** | **Online Doc Reading** | `Doc_count` (1 item) | Click frequency on chapter-decomposed Google Docs code & explanation guides |
| **Cognitive (Mediator)** | **Self-Assessment** | `Unit_test`, `Game_test`, `OJ_test` (3 items) | Concept MCQs, gamified 4-HP StarTrec lite challenges, and auto-graded executable Python coding tasks |
| **Target (DV)** | **Final Grade** | `Score` (1 item) | Final term project grade on Taiwan open-data analysis with Python |

<div class="callout" style="margin-top: 8px;">
<strong>Indicator Screening:</strong> 15 of 28 initial log variables had cross-loadings below Hair et al. (2019) thresholds and were pruned; single-item constructs (<code>Online_days</code>, <code>Doc_count</code>, <code>Score</code>) are natively supported in PLS-SEM (CL = 1.000).
</div>

---

## 3.5 Interactive Cognitive Plug-ins: Game Test & OJ System

<div class="split55">
<div class="left">
<div class="fig-box">
<img src="./img/fig3_plugins_game_oj.png" alt="Figure 3: (a) StarTrec lite Game Test and (b) Online Judge System" style="max-height: 395px;">
<div class="fig-cap">Figure 3: (a) StarTrec lite 4-HP Game Test &amp; (b) Automated Python OJ.</div>
</div>
</div>
<div class="right small-text">

<div class="card teal" style="margin-bottom: 10px;">

### 🎮 Three Tiers of Cognitive Challenge
1. **`Unit_test` (Concept Check)**: Multiple-choice unit quizzes verifying foundational Python syntax & logic.
2. **`Game_test` (StarTrec lite)**: Gamified adventure requiring **4 HP** to advance—wrong answers force a restart, nudging students to consult docs & peers.
3. **`OJ_test` (Online Judge)**: Highest difficulty—students write & submit executable Python code graded instantly against predefined test cases.

</div>

<div class="callout" style="margin-top: 6px;">
<strong>Acting as a 24/7 TA:</strong> Instant automated feedback transforms passive watching into active cognitive problem-solving.
</div>

</div>
</div>

---

## 4.1 Measurement Model: Reliability & Discriminant Validity

<div class="split55">
<div class="left">

### Table 1: Reliability & Convergent Validity
| Construct | Indicator | CL | α | CR | AVE |
| :--- | :--- | :---: | :---: | :---: | :---: |
| **Self-Assessment** | `Unit_test` | **0.926** | **0.824** | **0.896** | **0.743** |
| | `Game_test` | **0.866** | | | |
| | `OJ_test` | **0.787** | | | |
| **Video Watching** | `Load_count` | **0.873** | **0.900** | **0.922** | **0.629** |
| | `Watching_time` | **0.857** | | | |
| | `Pause_count` | **0.836** | | | |
| | `Play_count` | **0.792** | | | |
| | `Video_count` | **0.738** | | | |
| | `Seek_backward` | **0.670** | | | |
| | `Stop_count` | **0.655** | | | |
| *Single-Item (×3)* | `Score`/`Doc`/`Days` | 1.000 | — | — | — |

</div>
<div class="right small-text">

### Table 2: Fornell-Larcker Criterion
| Construct | FG | Doc | Time | SA | Vid |
| :--- | :---: | :---: | :---: | :---: | :---: |
| **Final Grade** | **1.00** | | | | |
| **Online Doc** | 0.16 | **1.00** | | | |
| **Online Time** | 0.41 | 0.29 | **1.00** | | |
| **Self-Assess.** | 0.87 | 0.17 | 0.39 | **0.86** | |
| **Video Watch** | 0.38 | 0.26 | 0.46 | 0.31 | **0.79** |

<div class="callout" style="margin-top: 10px;">
<strong>All Thresholds Passed:</strong> Cronbach's α (&gt; 0.82), CR (&gt; 0.89), AVE (&gt; 0.62), and diagonal √AVE exceeds all off-diagonal correlations (Hair et al., 2019).
</div>

</div>
</div>

---

## 4.2 <span class="rq-tag">RQ1</span> Structural Model & Direct Effects (H1–H7)

<div class="split64">
<div class="left">

### Table 3: Bootstrapped Direct Paths (5,000 subsamples)
| H | Path | Coeff (O) | t-Stat | p-Value | Result |
| :-: | :--- | :---: | :---: | :---: | :---: |
| H1 | Online time ➔ Grade | 0.047 | 1.394 | 0.163 | NS |
| **H2** | **Online time ➔ Self-Assess.** | **0.302** | **5.430** | **0.000\*\*** | **Supported** |
| **H3** | **Video ➔ Final grade** | **0.113** | **2.937** | **0.003\*\*** | **Supported** |
| **H4** | **Video ➔ Self-Assess.** | **0.157** | **2.429** | **0.015\*** | **Supported** |
| H5 | Online doc ➔ Grade | -0.018 | 0.582 | 0.561 | NS |
| H6 | Online doc ➔ Self-Assess. | 0.037 | 0.658 | 0.511 | NS |
| **H7** | **Self-Assess. ➔ Grade** | **0.819** | **29.505** | **0.000\*\*** | **Supported** |

<div class="callout" style="margin-top: 6px;">
<strong>Substantial Explanatory Power:</strong> Final Grade <strong>R<sup>2</sup> = 0.771</strong> (Adjusted R<sup>2</sup> = 0.767). Among behavioral modes, <strong>Video Watching</strong> is the <em>only</em> one with a significant direct effect on grades!
</div>

</div>
<div class="right">
<div class="fig-box">
<img src="./img/fig6_pls_path_results.png" alt="Figure 6: PLS Path Modeling Results" style="max-height: 410px;">
<div class="fig-cap">Figure 6: PLS path model (bold = significant; R<sup>2</sup> = 0.771).</div>
</div>
</div>
</div>

---

## 4.3 <span class="rq-tag">RQ2</span> Mediation Analysis: Self-Assessment as the Bridge

### Table 5: Specific Indirect Effects via Self-Assessment (Bootstrapping, 5,000 subsamples)

| Indirect Path (Behavioral ➔ Cognitive ➔ Outcome) | Indirect Effect (O) | Sample Mean (M) | SD | t-Stat | p-Value | Mediation Type |
| :--- | :---: | :---: | :---: | :---: | :---: | :---: |
| **Online time ➔ Self-assessment ➔ Final grade** | **0.248** | 0.248 | 0.046 | **5.352** | **0.000\*\*** | **Full Mediation** |
| **Video watching ➔ Self-assessment ➔ Final grade** | **0.128** | 0.134 | 0.054 | **2.389** | **0.017\*** | **Partial Mediation** |
| Online document reading ➔ Self-assessment ➔ Final grade | 0.031 | 0.029 | 0.047 | 0.656 | 0.512 | Not Significant |

<div class="three-col" style="margin-top: 12px;">
<div class="kpi-card teal">
<div class="kpi-val">Full Mediation</div>
<div class="kpi-label"><strong>Online Time</strong> fails directly (p = 0.163), but strongly lifts grades <em>when spent on self-assessments</em> (β = 0.248, p = 0.000**).</div>
</div>
<div class="kpi-card">
<div class="kpi-val">Dual Channel</div>
<div class="kpi-label"><strong>Video Watching</strong> boosts grades <em>both</em> directly (0.113**) and indirectly through self-assessment (0.128*).</div>
</div>
<div class="kpi-card accent">
<div class="kpi-val">Docs Unused</div>
<div class="kpi-label"><strong>Online Docs</strong> show no direct or mediated effect (p = 0.512)—students prefer coding &amp; videos over reading static text.</div>
</div>
</div>

---

## 4.4 <span class="rq-tag">RQ3</span> IPMA at the Construct Level

<div class="split64">
<div class="left">

### Table 6: Standardized Construct Effects on Final Grade
| Engagement Type | Construct | Importance (Total Effect) | Performance (0–100) |
| :--- | :--- | :---: | :---: |
| **Cognitive** | **Self-Assessment** | **0.82** | **62.43** |
| Behavioral | **Online Time** | **0.29** | 33.43 |
| Behavioral | **Video Watching** | **0.24** | 48.70 |
| Behavioral | Online Doc Reading | 0.01 | 9.19 |

<div class="callout" style="margin-top: 10px;">
<strong>Strategic Reading of IPMA:</strong>
<ul>
<li><strong>#1 Driver</strong>: Self-Assessment dominates both Importance (<strong>0.82</strong>) and Performance (<strong>62.43</strong>).</li>
<li><strong>High Leverage</strong>: Boosting Online Time (P = 33.43) &amp; Video engagement (P = 48.70) yields strong gains.</li>
<li><strong>Red Flag</strong>: Online Docs sit at the bottom-left (I = 0.01, P = 9.19).</li>
</ul>
</div>

</div>
<div class="right">
<div class="fig-box">
<img src="./img/fig4_ipma_constructs.png" alt="Figure 4: IPMA Results for Constructs" style="max-height: 390px;">
<div class="fig-cap">Figure 4: Construct-level IPMA (x = Total Effect, y = Performance).</div>
</div>
</div>
</div>

---

## 4.5 <span class="rq-tag">RQ3</span> IPMA at the Indicator Level: Actionable Targets

<div class="split64">
<div class="left">

### Table 7: Key Indicator Importance & Performance
| Indicator | Type | Importance | Performance | Priority Zone |
| :--- | :--- | :---: | :---: | :--- |
| **`Unit_test`** | Cognitive | **0.36** | **85.97** | ★ Maintain Strength |
| **`OJ_test`** | Cognitive | **0.31** | **47.88** | 🎯 **Top Improvement** |
| **`Online_days`** | Behavioral | **0.29** | **33.43** | 🎯 **Top Improvement** |
| **`Game_test`** | Cognitive | **0.28** | **77.00** | ★ Maintain Strength |
| `Video_count` | Behavioral | 0.06 | 62.52 | Solid Habit |
| `Watching_time` | Behavioral | 0.04 | 42.16 | Moderate |
| `Pause`/`Play` | Behavioral | 0.05 / 0.05 | 25.8 / 26.5 | Low Activity |
| `Doc_count` | Behavioral | 0.01 | 9.19 | Lowest Usage |

</div>
<div class="right">
<div class="fig-box">
<img src="./img/fig5_ipma_indicators.png" alt="Figure 5: IPMA Results for Indicators" style="max-height: 380px;">
<div class="fig-cap">Figure 5: Indicator-level IPMA—<code>OJ_test</code> &amp; <code>Online_days</code> offer highest ROI.</div>
</div>
</div>
</div>

---

## 5.1 Practical Implications & Study Limitations

<div class="two-col">
<div class="card small-text">

### 🏗️ For Platform Developers & Policymakers
- **Prioritize Cognitive Self-Assessment**: Invest in interactive OJ systems, gamified tests (`Game_test`), and unit quizzes (`Unit_test`) tightly aligned with cognitive skills.
- **Turn Time into Practice**: Since `OJ_test` has high importance (0.31) but moderate performance (47.88), scaffolded hints & progressive coding exercises can unlock major grade gains.

</div>
<div class="card teal small-text">

### 👩‍🏫 For Instructors & Students
- **Craft Concise, Engaging Videos**: Video watching directly and indirectly lifts grades—short, focused session videos support review, language learners, and absent students (Carlisle, 2010; Ronchetti, 2010).
- **Redesign Static Online Docs**: Students bypass plain text (`P = 9.19`); embed interactive code runners and mini-quizzes inside readings.

</div>
</div>

<div class="future-strip" style="margin-top: 12px;">
<div class="future-pill" style="border-left-color: var(--accent);"><strong>⚠️ Limitation 1 · Single Cohort</strong><br>217 undergraduates from one university course; broader MOOC generalizability needed.</div>
<div class="future-pill" style="border-left-color: var(--accent);"><strong>⚠️ Limitation 2 · Single-Item Logs</strong><br>15 of 28 indicators pruned for low CL; Online Time &amp; Docs retained as single-item constructs.</div>
<div class="future-pill" style="border-left-color: var(--accent);"><strong>⚠️ Limitation 3 · Affective Gap</strong><br>Focused on behavioral &amp; cognitive dimensions; emotional/social engagement not yet captured.</div>
</div>

---

## 5.2 Conclusion & Future Work

<div class="fig-box" style="padding: 8px 10px; margin-bottom: 8px;">
<img src="./img/diag3_rq_conclusions.svg" alt="Visual Synthesis of RQ1-RQ3 Conclusions" style="max-height: 360px;">
</div>

<div class="future-strip">
<div class="future-pill"><strong>🌍 1. Wider MOOC Cohorts</strong><br>Replicate across diverse open MOOC populations beyond a single university classroom.</div>
<div class="future-pill"><strong>🐛 2. Fine-Grained Coding Logs</strong><br>Integrate debugging, testing, and multi-item behavioral logs to enrich construct validity.</div>
<div class="future-pill"><strong>💬 3. Emotional &amp; Social Dimensions</strong><br>Incorporate affective reactions and peer-interaction analytics alongside behavioral logs.</div>
</div>

---

<!-- _class: closing -->

# Thank You for Your Attention!

<p style="font-size: 1.02em; max-width: 880px;">
Exploring the Influence of Students' Modes of Behavioral Engagement in an Online Programming Course Using the PLS-SEM Approach
</p>

<div class="contact-card">
<strong>Nien-Lin Hsueh</strong> &nbsp;·&nbsp; <code>nlhsueh@fcu.edu.tw</code><br>
<strong>Bilegjargal Daramsenge*</strong> &nbsp;·&nbsp; <code>P0731809@o365.fcu.edu.tw</code><br>
<strong>Lien-Chi Lai</strong> &nbsp;·&nbsp; <code>P1000433@mail.fcu.edu.tw</code><br>
Department of Information Engineering and Computer Science, Feng Chia University<br>
<span style="font-size: 0.85em; opacity: 0.88;">JITE:Research, Vol. 21 (2022), pp. 403–423 · DOI: 10.28945/5010 · MOST 110-2221-E-035-031-MY2</span>
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
