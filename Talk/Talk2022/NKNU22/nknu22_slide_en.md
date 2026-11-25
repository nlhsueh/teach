---
marp: true
theme: gaia
size: 16:9
paginate: true
html: true
header: '<div class="hdr-wrap"><span class="hdr-title">Online Programming Education &amp; Learning Process Analytics · NKNU Keynote (2022/12/08)</span><div class="hdr-actions"><a class="lang-btn" href="./nknu22_slide.html" title="切換至繁體中文簡報">🌐 繁</a><div class="nav-dropdown"><button class="nav-btn">Sections ▾</button><div class="nav-menu"><a href="#2">Presentation Outline</a><a href="#3">Context: Learn At Home</a><a href="#4">Four-Stage MOOC Evolution</a><a href="#5">MOOC Course &amp; Unit Design</a><a href="#6">Beyond Videos: Learning Components</a><a href="#7">Assessment &amp; Online Judge</a><a href="#8">Engagement &amp; Student Feedback</a><a href="#9">Analytics: More than Dashboard</a><a href="#10">Case 1: 9 Video Watching Patterns</a><a href="#11">Case 1: Pass/Fail Prediction Results</a><a href="#12">Case 2: Interactive Module Activity</a><a href="#13">Case 2: Debugging &amp; Grade Correlation</a><a href="#14">Case 2: Frustration &amp; Dropout</a><a href="#15">Lessons Learned &amp; Takeaways</a></div></div></div></div>'
footer: 'Prof. Nien-Lin Hsueh · Dept. of IECS, Feng Chia University · Invited Talk at NKNU (2022/12/08)'
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
  font-size: 20px;
  line-height: 1.48;
  letter-spacing: 0.01em !important;
  padding: 68px 54px 48px 54px;
  box-sizing: border-box;
}

section h1, section h2, section h3 { letter-spacing: 0 !important; }

header {
  position: absolute;
  top: 0; left: 0; right: 0;
  height: 44px;
  padding: 0 54px;
  background: var(--navy);
  color: #ffffff;
  font-size: 13px;
  font-weight: 600;
  display: flex;
  align-items: center;
  box-sizing: border-box;
  overflow: visible !important;
  z-index: 50;
}

.hdr-wrap { width: 100%; display: flex; justify-content: space-between; align-items: center; }
.hdr-title { opacity: 0.94; }
.hdr-actions { display: flex; align-items: center; gap: 8px; flex-shrink: 0; }

.lang-btn {
  display: inline-flex;
  align-items: center;
  gap: 4px;
  background: rgba(255, 255, 255, 0.14);
  color: #ffffff !important;
  border: 1px solid rgba(255, 255, 255, 0.28);
  border-radius: 6px;
  padding: 3px 10px;
  font-size: 12px;
  font-weight: 600;
  text-decoration: none !important;
  cursor: pointer;
}
.lang-btn:hover { background: rgba(255, 255, 255, 0.26); }

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
  min-width: 245px;
  max-height: 460px;
  overflow-y: auto;
  background: #ffffff;
  border: 1px solid var(--slate-200);
  border-radius: 8px;
  box-shadow: 0 10px 24px rgba(15, 23, 42, 0.18);
  padding: 6px 0;
  z-index: 200;
}

.nav-dropdown:hover .nav-menu,
.nav-dropdown.open .nav-menu { display: block; }

.nav-menu a {
  display: block;
  padding: 6px 14px;
  color: var(--slate-700);
  text-decoration: none;
  font-size: 12px;
  font-weight: 500;
  line-height: 1.35;
}
.nav-menu a:hover { background: var(--slate-100); color: var(--navy); }

@media print { .lang-btn, .nav-dropdown { display: none !important; } }

footer {
  position: absolute;
  left: 54px;
  bottom: 14px;
  font-size: 12.2px;
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

h1 { color: var(--navy); font-size: 1.7em; font-weight: 800; line-height: 1.24; margin: 0 0 12px 0; }

h2 {
  color: var(--navy);
  font-size: 1.22em;
  font-weight: 700;
  line-height: 1.26;
  margin: 0 0 13px 0;
  padding-bottom: 6px;
  border-bottom: 2.5px solid var(--navy);
  display: flex;
  align-items: center;
  gap: 8px;
}

h3 { color: var(--accent); font-size: 0.94em; font-weight: 700; margin: 4px 0 6px 0; }
p { margin: 0 0 8px 0; }
ul, ol { margin: 4px 0 8px 0; padding-left: 22px; }
li { margin-bottom: 4px; line-height: 1.42; }
li > ul { margin-top: 3px; margin-bottom: 3px; }
li > ul > li { font-size: 0.92em; margin-bottom: 3px; }
strong { color: var(--slate-900); }
a { color: #2563eb; text-decoration: none; font-weight: 600; }
a:hover { text-decoration: underline; }

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
section.lead code, section.closing code { color: #bae6fd !important; }
section.closing strong { color: #ffffff !important; }

/* Lead & Closing */
section.lead {
  background: linear-gradient(135deg, #102442 0%, #1b365d 60%, #0f766e 100%);
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
  font-size: 0.74em;
  font-weight: 600;
  padding: 5px 14px;
  border-radius: 999px;
  margin-bottom: 18px;
}

section.lead h1 { color: #ffffff; font-size: 2.15em; font-weight: 900; line-height: 1.2; margin-bottom: 12px; text-align: left; }
section.lead .subtitle { color: #e2e8f0; font-size: 0.98em; line-height: 1.5; margin-bottom: 28px; max-width: 920px; }

section.lead .meta-box {
  border-left: 4px solid #34d399;
  padding-left: 18px;
  color: #f1f5f9;
  font-size: 0.88em;
  line-height: 1.65;
}
section.lead .meta-box strong { color: #ffffff; }

section.closing {
  background: linear-gradient(135deg, #102442 0%, #1b365d 60%, #0f766e 100%);
  color: #ffffff;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  text-align: center;
  padding: 48px 72px;
}

section.closing header, section.closing footer, section.closing::after { display: none !important; }
section.closing h1 { color: #ffffff; font-size: 2.0em; margin-bottom: 12px; }
section.closing p { color: #e2e8f0; }

/* Layouts */
.two-col { display: grid; grid-template-columns: 1fr 1fr; gap: 18px; align-items: stretch; }
.three-col { display: grid; grid-template-columns: repeat(3, 1fr); gap: 14px; align-items: stretch; }
.split64 { display: grid; grid-template-columns: 58% 40%; gap: 2%; align-items: center; }
.split46 { display: grid; grid-template-columns: 42% 56%; gap: 2%; align-items: center; }
.split55 { display: grid; grid-template-columns: 49% 49%; gap: 2%; align-items: center; }

.card {
  background: #ffffff;
  border: 1px solid var(--slate-200);
  border-top: 3.5px solid var(--navy);
  border-radius: 10px;
  padding: 12px 15px;
  box-shadow: 0 2px 8px rgba(15, 23, 42, 0.05);
  box-sizing: border-box;
}
.card.accent { border-top-color: var(--accent); }
.card.teal { border-top-color: var(--teal); }
.card.amber { border-top-color: #d97706; }

.callout {
  background: #f8fafc;
  border-left: 4px solid var(--accent);
  border-radius: 0 8px 8px 0;
  padding: 10px 15px;
  margin-top: 12px;
  max-width: 960px;
  margin-left: auto;
  margin-right: auto;
  font-size: 0.83em;
  line-height: 1.48;
  color: var(--slate-700);
}
.callout strong { color: var(--navy); }

/* Hub Grid */
.hub-grid { display: grid; grid-template-columns: 1fr 1fr; gap: 15px 18px; margin-top: 4px; }
.hub-card {
  background: #ffffff;
  border: 1px solid var(--slate-200);
  border-left: 5px solid var(--navy);
  border-radius: 10px;
  padding: 12px 15px;
  box-shadow: 0 2px 8px rgba(15, 23, 42, 0.05);
}
.hub-card.teal { border-left-color: var(--teal); }
.hub-card.accent { border-left-color: var(--accent); }
.hub-card.amber { border-left-color: #d97706; }

.hub-title { font-size: 0.92em; font-weight: 800; color: var(--navy); margin-bottom: 8px; }
.hub-card.teal .hub-title { color: var(--teal); }
.hub-card.accent .hub-title { color: var(--accent); }
.hub-card.amber .hub-title { color: #b45309; }

.hub-links { display: flex; flex-direction: column; gap: 6px; font-size: 0.78em; }
.hub-link {
  display: flex;
  align-items: center;
  justify-content: space-between;
  gap: 10px;
  background: #f8fafc;
  border: 1px solid var(--slate-200);
  border-radius: 7px;
  padding: 6px 10px;
  color: var(--slate-900) !important;
  text-decoration: none !important;
}
.hub-link:hover { background: #eff6ff; border-color: #93c5fd; color: var(--navy) !important; }
.hub-badge {
  font-size: 0.82em;
  font-weight: 700;
  color: #ffffff;
  background: var(--navy);
  padding: 2px 8px;
  border-radius: 999px;
  white-space: nowrap;
  flex-shrink: 0;
}
.hub-card.teal .hub-badge { background: var(--teal); }
.hub-card.accent .hub-badge { background: var(--accent); }
.hub-card.amber .hub-badge { background: #d97706; }

/* Tables */
table { width: 100%; border-collapse: collapse; font-size: 0.74em; margin: 6px 0; }
th { background: var(--navy); color: #ffffff; font-weight: 700; padding: 7px 9px; text-align: left; }
td { padding: 6px 9px; border-bottom: 1px solid var(--slate-200); }
tr:nth-child(even) td { background: #f8fafc; }

/* Figures & Hover Zoom */
.fig-box {
  background: #ffffff;
  border: 1px solid var(--slate-200);
  border-radius: 10px;
  padding: 8px;
  text-align: center;
  box-shadow: 0 2px 8px rgba(15, 23, 42, 0.05);
  overflow: visible;
  position: relative;
}
.fig-box img { max-width: 100%; height: auto; display: block; margin: 0 auto; border-radius: 5px; }
.fig-cap { font-size: 0.72em; color: var(--slate-500); margin-top: 6px; font-weight: 600; }

.small-text { font-size: 0.81em; line-height: 1.44; }
.pill {
  display: inline-block;
  font-size: 0.73em;
  font-weight: 700;
  padding: 2px 8px;
  border-radius: 999px;
  background: #eff6ff;
  color: var(--navy);
  margin: 2px;
}
.pill.teal { background: #f0fdfa; color: var(--teal); }
.pill.accent { background: #fdf2f5; color: var(--accent); }

.split64 .right img, .split46 .right img, .split55 .right img, .two-col .right img, .card img {
  transition: transform 0.24s ease, box-shadow 0.24s ease;
  transform-origin: right bottom;
  cursor: zoom-in;
  position: relative;
  z-index: 1;
}
.split64 .left img, .split46 .left img, .split55 .left img, .two-col .left img {
  transition: transform 0.24s ease, box-shadow 0.24s ease;
  transform-origin: left bottom;
  cursor: zoom-in;
  position: relative;
  z-index: 1;
}
.split64 .right img:hover, .split46 .right img:hover, .split55 .right img:hover, .two-col .right img:hover,
.split64 .left img:hover, .split46 .left img:hover, .split55 .left img:hover, .two-col .left img:hover,
.card img:hover {
  transform: scale(var(--zoom-scale, 1.55));
  box-shadow: 0 18px 42px rgba(15, 23, 42, 0.34);
  z-index: 90;
  background: #ffffff;
  border-radius: 6px;
}
</style>

<!-- _class: lead -->

<div class="badge">National Kaohsiung Normal University (NKNU) · Invited Keynote (2022/12/08)</div>

# Online Learning and Process Analytics in Programming Education

<div class="subtitle">
From Pandemic-Driven MOOC Transformation, Multi-Modal Interactive Components, and Online Judge Practice to OpenEdu Learning Analytics on Video Early-Warning, Engagement, and Frustration
</div>

<div class="meta-box">
<strong>Speaker:</strong> Prof. Nien-Lin Hsueh<br>
<strong>Affiliation:</strong> Dept. of Information Engineering and Computer Science, Feng Chia University<br>
<strong>Date &amp; Venue:</strong> Dec 8, 2022, 10:00 · National Kaohsiung Normal University (NKNU)
</div>

<!--
This invited keynote presented at National Kaohsiung Normal University (NKNU) on December 8, 2022 synthesizes Feng Chia University's multi-year journey transforming introductory Python programming courses into scalable MOOCs and applying Educational Data Mining (EDM) to OpenEdu learning logs. The talk bridges two halves: (1) pedagogical design for online programming education beyond recorded lectures, and (2) empirical learning process analytics covering early pass/fail prediction from video logs, interactive module retention, grade correlation between self-practice and Online Judge, and frustration-driven dropout analysis.
-->

---

## Presentation Outline (Click Any Item to Jump)

<div class="hub-grid">

<div class="hub-card teal">
<div class="hub-title">🚀 1. MOOC Journey: Course Evolution</div>
<div class="hub-links">
<a class="hub-link" href="#3"><span>🌍 Context: Learn At Home Global Experiment</span><span class="hub-badge">Slide #3</span></a>
<a class="hub-link" href="#4"><span>📈 Four-Stage Evolution &amp; 13-5 Blended Model</span><span class="hub-badge">Slide #4</span></a>
<a class="hub-link" href="#5"><span>🧱 Course Design: 6 Units &amp; Micro-Unit Rhythm</span><span class="hub-badge">Slide #5</span></a>
</div>
</div>

<div class="hub-card">
<div class="hub-title">🧩 2. Beyond Videos: Interactive Components</div>
<div class="hub-links">
<a class="hub-link" href="#6"><span>📊 Nine Learning Components &amp; Preference Survey</span><span class="hub-badge">Slide #6</span></a>
<a class="hub-link" href="#7"><span>⚖️ Assessment, Online Judge &amp; Capstone Projects</span><span class="hub-badge">Slide #7</span></a>
<a class="hub-link" href="#8"><span>💡 Enhancing Engagement &amp; Student Voices</span><span class="hub-badge">Slide #8</span></a>
</div>
</div>

<div class="hub-card accent">
<div class="hub-title">🎬 3. Analytics Case 1: Video Early Warning</div>
<div class="hub-links">
<a class="hub-link" href="#9"><span>🗄️ More than Dashboard: 3 Data Tiers &amp; JSON Logs</span><span class="hub-badge">Slide #9</span></a>
<a class="hub-link" href="#10"><span>👀 9 Video Watching Patterns Classification</span><span class="hub-badge">Slide #10</span></a>
<a class="hub-link" href="#11"><span>🤖 ML Pass/Fail Early Prediction Performance</span><span class="hub-badge">Slide #11</span></a>
</div>
</div>

<div class="hub-card amber">
<div class="hub-title">🧪 4. Analytics Case 2: Interaction &amp; Frustration</div>
<div class="hub-links">
<a class="hub-link" href="#12"><span>🔥 Module Activity Retention (17% vs. 32% / OJ 40%)</span><span class="hub-badge">Slide #12</span></a>
<a class="hub-link" href="#13"><span>📉 Debugging Traces &amp; SP / OJ / Exam Correlation</span><span class="hub-badge">Slide #13</span></a>
<a class="hub-link" href="#14"><span>😓 Frustration Degree, Grades &amp; Dropout Risk</span><span class="hub-badge">Slide #14</span></a>
</div>
</div>

</div>

<!--
Interactive four-quadrant outline aligning with the Chinese edition page-for-page (#1–#15). Slides 3–8 cover the practical instructional design of MOOCs and Online Judge programming courses; Slides 9–14 present empirical OpenEdu learning log analyses; Slide 15 distills lessons learned toward Precise Learning and links to companion peer-reviewed studies (21Judge and 22Engagement).
-->

---

## Context: Learn At Home &amp; the Forced Online Experiment

According to the United Nations, COVID-19 school closures across 13 countries disrupted **290 million students** (Learn From Home, LFH), exposing four structural bottlenecks:

<div class="two-col small-text" style="margin-top: 8px;">

<div class="card">

### 🌐 1. Insufficient Infrastructure
Not every region has stable and reliable broadband internet connectivity.

### 💻 2. School Technology &amp; Support
Not all schools possess the required platforms or technical support staff.

</div>

<div class="card accent">

### 👩‍🏫 3. Human Resources
Few institutions have sufficient faculty capacity to craft high-quality online materials.

### 🏠 4. Home Technology
Not all student households have adequate hardware or software environments.

</div>

</div>

<div class="callout">
<strong>Key Reflection:</strong> Like it or not, educators and students were propelled into an unprecedented experiment—one that gave us the opportunity to rigorously test the <strong>possibilities and limits of online programming education</strong>.
</div>

<!--
During COVID-19, mass remote instruction revealed systemic disparities in broadband infrastructure, institutional IT support, instructional design readiness, and home computing access. Rather than treating remote teaching as a temporary stopgap, the Feng Chia University team leveraged this moment to formalize MOOC courseware design, automated grading, and data-driven learning process analytics.
-->

---

## MOOC Journey: Four-Stage Course Evolution

<div class="fig-box" style="padding: 6px 8px;">
<img src="./img/diag_mooc_evolution_en.svg" alt="Four-Stage MOOC Evolution Diagram" style="max-height: 225px;">
</div>

<div class="two-col small-text" style="margin-top: 12px;">

<div class="card">

### 🎬 Stage 2 Tips: Recording Pre-Class Videos
- Prioritize **clear audio and visuals**, and test equipment early.
- **Do not try to record everything**: keep clips short and visually varied.
- **Anticipate in-video quizzes** while planning the script.

</div>

<div class="card teal">

### 📅 Stage 3 Practice: 13-5 Async Blended (`1-(3-1)3-4-1`)
- **13 async online weeks** + **5 key in-person sessions**:
  1. Course onboarding &amp; tool setup; 2–3. Discussion &amp; two review exams;
  4. Project proposal discussion; 5. Final project demo &amp; Q&amp;A.

</div>

</div>

<!--
The transition from face-to-face instruction to full-scale MOOCs unfolded across four deliberate stages: (1) traditional classroom delivery; (2) flipped online previews combining concise concept clips with Trinket embedded code snippets; (3) a 13-5 asynchronous blended schedule (13 online weeks and 5 milestone physical meetings structured as 1-(3-1)3-4-1) augmented by Coding Corner auto-grading; and (4) full OpenEdu MOOCs supported by explicit course guidelines and weekly proactive email nudges.
-->

---

## MOOC Course Design: Six Units &amp; Micro-Unit Rhythm

<div class="two-col small-text">

<div class="card">

### 🗂️ Macro Course Architecture (OpenEdu)
- **Pre-Course Onboarding**: Course guidelines, environment setup, pre-survey.
- **Six Progressive Units**:
  - Unit 1: Python Programming &amp; Data Science Intro
  - Unit 2: Basic Program Structure &amp; Variables
  - Unit 3: Logic Control (Sequence, Branching, Loops)
  - Units 4–6: Functions, Data Structures &amp; Data Analytics
- **Capstone &amp; Closure**: Final project, post-survey, **Certificate issuance**.

</div>

<div class="card accent">

### 🔁 Standard Micro-Unit Learning Rhythm
Every unit follows a predictable scaffolding loop to prevent novice disorientation:
1. **Introduction**: Real-world motivation &amp; scenario framing
2. **Concept × 3**: Bite-sized core concept micro-videos
3. **Application**: Concrete applied walkthrough
4. **Online Judge**: Immediate hands-on coding with auto-grading
5. **Solution &amp; Test**: Solution debrief and unit assessment

</div>

</div>

<div class="callout">
<strong>Design Principle:</strong> Effective online courses never dump raw 3-hour classroom recordings online; they decompose concepts into digestible micro-units with <strong>embedded practice and verification loops</strong>.
</div>

<!--
On OpenEdu, the Python & Data Science MOOC pairs a macro six-unit progression with a consistent micro-unit rhythm (Introduction -> 3 Concept clips -> Application -> Online Judge -> Solution -> Unit Test). This recurring structure reduces extraneous cognitive load so learners immediately apply each newly introduced concept in code.
-->

---

## Beyond Videos: Nine Learning Components &amp; Student Survey

Online programming education cannot rely on passive video watching alone; the course orchestrates **9 interactive components**:

<div class="split46" style="margin-top: 6px;">
<div class="left small-text">

<div class="card teal" style="margin-bottom: 10px;">

### 🧰 Nine Learning Components
<span class="pill">Lecture Video</span><span class="pill">Quiz in Video</span><span class="pill">Lecture Notes</span><span class="pill teal">Simulation &amp; Lab</span><span class="pill teal">Self-Practice</span><span class="pill teal">Flashcards</span><span class="pill accent">Forum (Teams/Line)</span><span class="pill accent">Feedback</span><span class="pill accent">Online Judge</span>

</div>

<div class="card accent">

### 📊 Key Survey Findings
- Among quizzes, learners **preferred Self-Practice over graded in-video quizzes** (low-stakes experimentation).
- **Online Judge polarized learners**: lower average likability due to difficulty, yet a **remarkably high share of "Strongly Like"** responses.

</div>

</div>
<div class="right">

<div class="fig-box">
<img src="./img/fig_components_survey.jpeg" alt="Student Preference Survey Across Learning Components" style="max-height: 360px;">
<div class="fig-cap">Empirical preference survey across OpenEdu learning components (hover to zoom)</div>
</div>

</div>
</div>

<!--
Survey data from OpenEdu learners highlights two pedagogical nuances: (1) low-stakes self-practice exercises are preferred over graded in-video quizzes because they invite safe trial-and-error; (2) Online Judge coding tasks exhibit a bimodal reception—challenging for novices, yet eliciting strong enthusiasm from learners who value authentic hands-on coding mastery.
-->

---

## Assessment Core: Online Judge Virtual TA &amp; Capstone Projects

<div class="two-col small-text">

<div class="card">

### ⚖️ Dual Assessment &amp; Online Judge
- **Closed-Form Quizzes**: Calibrated attempt limits paired with **instant feedback**.
- **Online Judge (Virtual TA)**:
  - Pipeline: `Student Code` ➔ `Sandbox + Test Data` ➔ `Instant Verdict &amp; Score`.
  - Gamified themes such as **Star Trek** lower novice anxiety toward syntax errors.

</div>

<div class="card teal">

### 🏆 Real-World Open Data Capstones (20+ Topics)
Students apply Python to public datasets and everyday problems:
- **Urban Mobility**: Taipei/New Taipei YouBike, parking occupancy, Taichung traffic accidents, nationwide post-office mapping.
- **Health &amp; Environment**: Real-time PM2.5 rankings, enterovirus visits, dengue fever age distribution.
- **Finance &amp; Lifestyle**: **Auto stock alerts to LINE**, retail spending prediction, salary analytics, distance-based hotel recommendations.

</div>

</div>

<div class="callout">
<strong>Pedagogical Value:</strong> Online Judge acts as a 24/7 "Virtual TA" closing the delayed-feedback gap in online courses, while open-data capstones anchor programming skills in authentic civic and personal problems.
</div>

<!--
Automated grading via Online Judge provides immediate compilation and hidden test-case feedback within seconds, compensating for the absence of in-room TAs. Meanwhile, open-data final projects allow cross-disciplinary students to connect Python skills to civic datasets (air quality, YouBike, public health) and personal automation (LINE stock notifications).
-->

---

## Enhancing Course Engagement &amp; Student Feedback

<div class="three-col small-text" style="margin-top: 4px;">

<div class="card">

### 🎥 Short, Well-Designed Videos
Focused micro-videos with embedded **Quiz in Video** pop-ups sustain learner attention during asynchronous viewing.

</div>

<div class="card teal">

### 🎮 Gamification
Narrative mini-games like **Star Trek** spark intrinsic motivation among non-CS learners.

</div>

<div class="card accent">

### 🔄 Multi-Modal Interaction
Combines **Listen ➔ Read ➔ Code ➔ Simulate** so learners immediately test comprehension after watching.

</div>

</div>

<div class="card small-text" style="margin-top: 14px; border-top-color: #64748b; background: #f8fafc;">

### 💬 Representative Student Feedback
- *"I normally learn slowly, but **replaying videos** lets me revisit tough concepts, and **in-video quizzes** reinforce retention!"*
- *"Combining **Self-Practice &amp; Online Judge** lets me immediately test whether I truly understood each unit."*
- *"Loved the **Star Trek** game—gamified interactions made learning Python genuinely fun!"*

</div>

<!--
Three pillars drive sustained engagement in online programming courses: concise interactive videos, gamification, and multi-modal active learning (listen, read, practice, simulate). Student testimonials corroborate how self-paced replay, embedded quizzes, OJ immediate feedback, and Star Trek gamification accommodate diverse learning speeds—insights later modeled via PLS-SEM in JITE 2022.
-->

---

## Learning Data Analytics: More than Dashboard

<div class="fig-box" style="padding: 6px 8px;">
<img src="./img/diag_data_layers_en.svg" alt="Three-Tier Learning Data Analytics Architecture" style="max-height: 215px;">
</div>

<div class="two-col small-text" style="margin-top: 12px;">

<div class="card">

### 📡 OpenEdX Fine-Grained Event Logs
Captures 20+ interaction event categories across the learning lifecycle:
- Enrollment &amp; Navigational events
- **Video Interactions (17 types)**: `load_video`, `play_video`, `pause_video`, `seek_video`, `speed_change_video`, `stop_video`
- **Problem Interactions (16 types)**: `problem_check`, `showanswer`

</div>

<div class="card accent">

### 🧾 Key JSON Log Schema Fields
- **Identity &amp; Context**: `user_id`, `course_id`, `session`
- **Timeline**: `time` (event timestamp), `currentTime` (video second)
- **Behavioral Trace**: `old_time / new_time` (seek jumps), `old_speed / new_speed` (playback rate), `event_type`

</div>

</div>

<!--
Moving beyond summary dashboards, OpenEdu provides three progressive analytics tiers: (1) zero-code visual dashboards for daily monitoring; (2) de-identified tabular exports suitable for Excel-based instructional research; and (3) raw de-identified JSON event logs capturing granular video and problem interactions for machine learning and Educational Data Mining (EDM).
-->

---

## Case 1 (Part 1): Video Watching Behavior &amp; 9 Patterns

**Research Question**: Can we predict whether a student will **Pass or Fail** based solely on their watching behavior during the **first 3 videos**?

<div class="split46" style="margin-top: 8px;">
<div class="left small-text">

<div class="card" style="margin-bottom: 10px;">

### 🔍 Four Core Behavioral Dimensions
Extracted from `play / pause / seek / stop` logs:
- **Complete-watch (CW)**: Watches almost the entire video
- **Partial-watch (PW)**: Leaves before the video ends
- **Forward watch (f)**: Includes forward-seek skips
- **Backward watch (b)**: Includes backward-seek replays

</div>

<div class="card teal">

### 🧪 Empirical Evaluation Scope
- **Single Course** (MOM) vs. **180 Diverse Courses**
- **Instructor-paced** vs. **Self-paced** offerings

</div>

</div>
<div class="right">

<div class="fig-box">
<img src="./img/fig_9_patterns.jpeg" alt="9 Video Watching Patterns Taxonomy" style="max-height: 365px;">
<div class="fig-cap">Nine watching patterns derived from completion and seek directions (hover to zoom)</div>
</div>

</div>
</div>

<!--
Case 1 constructs an early-warning prediction pipeline from raw OpenEdX video logs. Through three preprocessing levels, each learner's viewing trace is categorized into 9 watching patterns combining completion (CW vs. PW) with seek behavior (none, forward, backward, bidirectional). Each <student, course> pair is encoded as a feature vector of pattern proportions from the first three videos to predict final pass/fail outcomes.
-->

---

## Case 1 (Part 2): Pattern Distribution &amp; ML Prediction Results

Evaluated **SVM, Neural Network, and Random Forest** via **10-fold Cross-Validation**; **Random Forest** achieved the strongest performance:

<div class="split46" style="margin-top: 6px;">
<div class="left">

<div class="fig-box">
<img src="./img/fig_pass_fail_patterns.jpeg" alt="Pass vs Fail Watching Pattern Proportions" style="max-height: 290px;">
<div class="fig-cap">Proportion of 9 watching patterns comparing Pass vs. Fail cohorts</div>
</div>

</div>
<div class="right small-text">

| Setting (Random Forest · 10-fold CV) | Accuracy | Precision | Recall | F1 |
| :--- | :---: | :---: | :---: | :---: |
| **Single Course (MOM)** | **0.83** | **0.89** | 0.89 | **0.89** |
| **180 Different Courses** | 0.71 | 0.70 | **0.95** | 0.81 |
| **Instructor-paced Courses** | 0.71 | 0.71 | **0.96** | 0.82 |
| **Self-paced Courses** | **0.91** | **0.93** | **0.976** | **0.95** |

<div class="callout" style="margin-top: 12px; max-width: 100%;">
<strong>Key Finding:</strong> Even across 180 heterogeneous courses, Random Forest achieves <strong>95%–97.6% Recall</strong> on at-risk learners—and reaches <strong>91% Accuracy (F1 = 0.95)</strong> in self-paced courses for early intervention!
</div>

</div>
</div>

<!--
The pattern distribution chart reveals distinct viewing signatures between passing and failing learners. Across 10-fold cross-validation, Random Forest achieves 0.83 accuracy (F1 = 0.89) on a single course, maintains 0.95 recall across 180 diverse courses (capturing nearly all at-risk learners), and peaks at 0.91 accuracy and 0.95 F1 in self-paced courses where early self-regulation is decisive.
-->

---

## Case 2 (Part 1): Interactive Modules &amp; Activity Retention

Tracking learner participation retention through Week 5 across courses and interactive modules:

<div class="three-col" style="margin-top: 6px;">

<div class="fig-box">
<img src="./img/fig_activity_low.jpeg" alt="Low-Interaction Course Activity Curve (17%)" style="max-height: 195px;">
<div class="fig-cap">Low-Interaction Course (M2019s)<br><strong style="color: #8c1d40;">Activity drops sharply to 17%</strong></div>
</div>

<div class="fig-box">
<img src="./img/fig_activity_high.jpeg" alt="High-Interaction Course Activity Curve (32%)" style="max-height: 195px;">
<div class="fig-cap">High-Interaction Course (M2019f)<br><strong style="color: #0f766e;">Activity sustained at 32%</strong></div>
</div>

<div class="fig-box">
<img src="./img/fig_activity_oj.jpeg" alt="Online Judge Module Activity Retention (40%)" style="max-height: 195px;">
<div class="fig-cap">Online Judge Coding Module<br><strong style="color: #1b365d;">Highest retention at 40%</strong></div>
</div>

</div>

<div class="callout" style="margin-top: 14px;">
<strong>Key Observation:</strong> Adding richer interactive elements in M2019f (e.g., Star Trek at <strong>30%</strong>) roughly <strong>doubled</strong> Week-5 retention over M2019s; although <strong>Online Judge</strong> had fewer initial participants, it retained <strong>40%</strong> activity—higher than any other module!
</div>

<!--
Comparing cohorts with differing levels of interactivity demonstrates that richer interactive design sustains participation roughly twice as well by Week 5 (30%–32% in M2019f vs. 15%–17% in M2019s). Notably, while Online Judge has a higher initial barrier, learners who engage with OJ exhibit the highest sustained activity rate (40%) across all instructional modules.
-->

---

## Case 2 (Part 2): Debugging Traces &amp; Grade Correlation (SP vs. OJ)

Analyzing submission histories (`F1072`) to understand *how students debug*, and correlating **Self-Practice (SP)** vs. **Online Judge (OJ)** with **Exam** scores:

<div class="two-col" style="margin-top: 6px;">

<div class="fig-box">
<img src="./img/fig_corr_sp_exam.jpeg" alt="Self-Practice vs Exam Correlation (r=0.54)" style="max-height: 220px;">
<div class="fig-cap">Self-Practice (SP) vs. Exam: <strong style="color: #1b365d;">CORR = 0.54</strong></div>
</div>

<div class="fig-box">
<img src="./img/fig_corr_oj_exam.jpeg" alt="Online Judge vs Exam Correlation (r=0.70)" style="max-height: 220px;">
<div class="fig-cap">Online Judge (OJ) vs. Exam: <strong style="color: #8c1d40;">CORR = 0.70</strong></div>
</div>

</div>

<div class="callout small-text" style="margin-top: 12px;">
<strong>Empirical Observations:</strong> (1) Because <strong>SP (MCQs)</strong> permits unlimited retries, high SP scores do not guarantee high exam scores (<code>r = 0.54</code>); <strong>OJ hands-on coding</strong> correlates far more strongly with exams (<code>r = 0.70</code>). (2) Submission traces expose persistent novice misconceptions (variables, string quotes/concatenation, <code>input()</code>) and <strong>blind trial-and-error editing</strong>.
</div>

<!--
Submission-level trace analysis uncovers both conceptual bottlenecks (variables, string quotation/concatenation, input parsing) and unproductive blind debugging habits. Quantitatively, hands-on Online Judge performance exhibits a substantially stronger correlation with final exam outcomes (r = 0.70) than repeatable multiple-choice Self-Practice (r = 0.54).
-->

---

## Case 2 (Part 3): Frustration Analysis, Grades &amp; Dropout

Repeated failed submissions accumulate severe frustration (e.g., on the very first simple OJ task, one student **submitted 32 versions and still failed**):

<div class="split55" style="margin-top: 6px;">
<div class="left">

<div class="fig-box">
<img src="./img/fig_frustration_grade.jpeg" alt="Frustration Degree vs Course Grade Scatter Plot" style="max-height: 315px;">
<div class="fig-cap">Frustration Degree shows a strong negative relationship with course grades</div>
</div>

</div>
<div class="right small-text">

| Cohort Comparison Metric | High-Frustration / Low-Grade | Low-Frustration / High-Grade |
| :--- | :---: | :---: |
| **By Frustration (Avg. Grade)** | `49.29` | **`80.1`** |
| **By Frustration (Dropout Rate)** | **`34%`** | `12%` |
| **By Lab Grade (Avg. Lab Score)** | `57` | **`74`** |
| **By Lab Grade (Avg. Frustration F)** | **`11.1`** | `6.7` |

<div class="callout" style="margin-top: 12px; max-width: 100%;">
<strong>Early Intervention Insight:</strong> High-frustration learners suffer nearly <strong>3× higher dropout (34% vs. 12%)</strong> and far lower grades—detecting <em>who</em> is stuck and <em>when</em> they need help is vital!
</div>

</div>
</div>

<!--
Quantifying repeated submission failures into a Frustration Degree (F) reveals a striking bidirectional pattern: high-frustration learners average 49.29 with a 34% dropout rate (vs. 80.1 and 12% dropout for low-frustration peers), while low-performing lab cohorts exhibit nearly double the average frustration (11.1 vs. 6.7). This empirical evidence directly motivated the team's subsequent work on timely scaffolding and tiered AI tutoring.
-->

---

<!-- _class: closing -->

# Lessons Learned &amp; Takeaways

<div style="display: grid; grid-template-columns: repeat(3, 1fr); gap: 16px; max-width: 980px; margin: 16px auto 22px auto; text-align: left;">
<div style="background: rgba(255,255,255,0.12); border: 1px solid rgba(255,255,255,0.26); border-radius: 12px; padding: 16px 18px; font-size: 0.83em;">
<strong style="font-size: 1.06em;">📖 1. Textbook is Necessary</strong><br>
Videos and interactive widgets cannot fully replace structured textbooks—well-organized written references remain essential for deep review.
</div>
<div style="background: rgba(255,255,255,0.12); border: 1px solid rgba(255,255,255,0.26); border-radius: 12px; padding: 16px 18px; font-size: 0.83em;">
<strong style="font-size: 1.06em;">🤝 2. Improve Learning Support</strong><br>
Combine Online Judge virtual TAs, multi-modal interactions, and frustration alerts to intervene before learners drop out.
</div>
<div style="background: rgba(255,255,255,0.12); border: 1px solid rgba(255,255,255,0.26); border-radius: 12px; padding: 16px 18px; font-size: 0.83em;">
<strong style="font-size: 1.06em;">🎯 3. Precise Learning</strong><br>
Leverage OpenEdu process analytics to move from one-size-fits-all teaching toward data-driven, personalized instruction.
</div>
</div>

<p style="font-size: 0.88em; color: #e2e8f0;">
Related Research &amp; Talks:
<a href="../../MyResearch/21Judge/Judge_slide.html" target="_blank" rel="noopener" style="color: #7dd3fc;">21Judge (UTAUT2) ↗</a> ·
<a href="../../MyResearch/22Engagement/Engagement_slide.html" target="_blank" rel="noopener" style="color: #7dd3fc;">22Engagement (PLS-SEM) ↗</a> ·
<a href="../../Talk2026/NKNU26/nknu26_slide.html" target="_blank" rel="noopener" style="color: #fde68a;">2026 NKNU Keynote (AI &amp; Education) ↗</a>
</p>

<!--
Three enduring lessons synthesize the 2022 NKNU keynote: (1) structured textbooks remain indispensable alongside interactive media; (2) automated grading, gamification, and frustration detection must work together to strengthen learner support; and (3) fine-grained learning process analytics paves the path toward Precise Learning. Links at the bottom connect directly to the team's companion English research decks (21Judge, 22Engagement) and the 2026 NKNU AI & Education keynote.
-->

<script>
(function() {
  document.addEventListener('click', function(e) {
    var lang = e.target.closest('.lang-btn');
    if (lang) {
      e.preventDefault();
      window.location.href = lang.getAttribute('href').split('#')[0] + (window.location.hash || '');
      return;
    }
    var btn = e.target.closest('.nav-btn');
    if (btn) {
      e.preventDefault();
      e.stopPropagation();
      var dd = btn.closest('.nav-dropdown');
      var wasOpen = dd.classList.contains('open');
      document.querySelectorAll('.nav-dropdown.open').forEach(function(el) { el.classList.remove('open'); });
      if (!wasOpen) dd.classList.add('open');
      return;
    }
    if (!e.target.closest('.nav-menu')) {
      document.querySelectorAll('.nav-dropdown.open').forEach(function(el) { el.classList.remove('open'); });
    }
  });

  function updateHoverZoomBounds() {
    var imgs = document.querySelectorAll('.split64 img, .split46 img, .split55 img, .two-col img, .card img');
    imgs.forEach(function(img) {
      var sec = img.closest('section');
      if (!sec) return;
      var sRect = sec.getBoundingClientRect();
      var iRect = img.getBoundingClientRect();
      if (iRect.width < 10 || iRect.height < 10) return;
      var isLeft = !!img.closest('.left');
      var availW = isLeft ? (sRect.right - iRect.left - 18) : (iRect.right - sRect.left - 18);
      var availH = iRect.bottom - sRect.top - 52;
      var maxScale = Math.min(2.1, Math.max(1.12, Math.min(availW / iRect.width, availH / iRect.height)));
      img.style.setProperty('--zoom-scale', maxScale.toFixed(2));
    });
  }
  window.addEventListener('load', updateHoverZoomBounds);
  window.addEventListener('resize', updateHoverZoomBounds);
  window.addEventListener('hashchange', function() { setTimeout(updateHoverZoomBounds, 80); });
  setTimeout(updateHoverZoomBounds, 250);
})();
</script>
