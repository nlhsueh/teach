---
marp: true
theme: gaia
size: 16:9
paginate: true
html: true
header: '<div class="hdr-wrap"><span class="hdr-title">Applying Large Language Model to User Experience Testing</span><div class="nav-dropdown"><button class="nav-btn">Sections ▾</button><div class="nav-menu"><a href="#2">Opening Hook: Human vs. LLM</a><a href="#3">Outline</a><a href="#4">1. Introduction & RQs</a><a href="#6">2. Literature Review</a><a href="#7">3. Proposed UX Testing Tool</a><a href="#10">4. Tennis Booking Case Study</a><a href="#12">5. Experimental Evaluation</a><a href="#16">6. Discussion & Conclusion</a></div></div></div>'
footer: 'Nien-Lin Hsueh, Hsuen-Jen Lin & Lien-Chi Lai · Feng Chia University · Electronics 2024, 13, 4633'
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
  min-width: 230px;
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
  font-size: 2.05em;
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
  padding: 10px 15px;
  box-sizing: border-box;
}

.kpi-card.accent { border-left-color: var(--accent); background: var(--accent-soft); }
.kpi-card.teal { border-left-color: var(--teal); background: var(--teal-soft); }

.kpi-val { font-size: 1.42em; font-weight: 800; color: var(--navy); line-height: 1.15; margin-bottom: 3px; }
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
  padding: 5px 8px;
  text-align: left;
  border: 1px solid var(--navy);
}

td {
  padding: 4.5px 8px;
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
  gap: 18px;
  list-style: none !important;
  padding: 0 !important;
  margin: 16px 0 0 0 !important;
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
  padding: 16px 20px;
  box-shadow: 0 2px 8px rgba(15, 23, 42, 0.06);
  box-sizing: border-box;
}

.rq-card.teal { border-left-color: var(--teal); }
.rq-card.accent { border-left-color: var(--accent); }

.rq-card img { width: 88px; height: 88px; flex-shrink: 0; border-radius: 10px; }

.rq-hook { font-size: 0.96em; font-weight: 800; color: var(--navy); line-height: 1.3; margin-bottom: 6px; }
.rq-card.teal .rq-hook { color: var(--teal); }
.rq-card.accent .rq-hook { color: var(--accent); }
.rq-q { font-size: 0.84em; color: var(--slate-700); line-height: 1.44; }

/* Mini Bar Rows */
.bar-row {
  display: grid;
  grid-template-columns: 115px 1fr 105px;
  align-items: center;
  gap: 10px;
  margin-bottom: 8px;
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

<div class="badge">Electronics 2024 · Vol. 13, Issue 23 · Article 4633 (MDPI)</div>

# Applying Large Language Model to User Experience Testing

<div class="subtitle">
Integrating <strong>Rapi Web Interaction Recording</strong>, <strong>Multimodal Prompt Engineering</strong>, and <strong>Nielsen's Usability Heuristics</strong> with GPT-4 for Automated UX Evaluation
</div>

<div class="meta-box">
<strong>Nien-Lin Hsueh*</strong>, <strong>Hsuen-Jen Lin</strong>, and <strong>Lien-Chi Lai</strong><br>
Department of Information Engineering and Computer Science, Feng Chia University, Taichung 407, Taiwan<br>
<code>nlhsueh@fcu.edu.tw</code> · <code>kobayasa209924@gmail.com</code> · <code>p1000433@mail.fcu.edu.tw</code>
</div>

<div class="grant">
Published: 24 November 2024 · DOI: <code>https://doi.org/10.3390/electronics13234633</code> · Grant: NSTC112-2221-E-035-030-MY2
</div>

---

## Opening Hook: "Looks Fine to Me!" ... Or Did We Miss 90% of UX Bugs?

<div class="fig-box" style="padding: 6px; margin-bottom: 10px; background: #fbf9f2;">
<img src="./img/uxtesting_hook.jpg" alt="Manual Human UX Testing vs Rapi + GPT-4 UX Inspector" style="max-height: 415px; border-radius: 6px;">
</div>

<div class="callout" style="margin-top: 6px; padding: 9px 16px;">
<strong>The Big Idea:</strong> Human evaluators naturally adapt to suboptimal interfaces — yielding a surprisingly conservative <strong>Recall of 0.10 (F1 = 0.16)</strong>. Pairing <strong>Rapi interaction logs + screenshots</strong> with <strong>GPT-4</strong> guided by <strong>Nielsen's heuristics</strong> achieves <strong>0.84 Precision</strong> and <strong>0.66 F1</strong>.
</div>

---

## Presentation Outline

<div class="outline-grid">

<div class="outline-item">
<div class="outline-num">1</div>
<div class="outline-body">

[**Introduction & Research Questions**](#4)
Why manual UX testing and existing automated tools fall short, and our two RQs (RQ1–RQ2).

</div>
</div>

<div class="outline-item">
<div class="outline-num">2</div>
<div class="outline-body">

[**Literature Review & Research Gap**](#6)
UX evaluation methods, metric taxonomies, and the missing usability-theory link in automation.

</div>
</div>

<div class="outline-item">
<div class="outline-num">3</div>
<div class="outline-body">

[**Proposed LLM-Based UX Testing Tool**](#7)
Rapi + GPT-4 architecture, six Nielsen heuristics (NS01–NS06), and multimodal prompt design.

</div>
</div>

<div class="outline-item">
<div class="outline-num">4</div>
<div class="outline-body">

[**Case Study: Tennis Course Reservation**](#10)
System workflow, UI contrast examples, nine evaluation stories (S01–S09), and TIS/AIS grouping.

</div>
</div>

<div class="outline-item">
<div class="outline-num">5</div>
<div class="outline-body">

[**Experimental Evaluation (RQ1 & RQ2)**](#12)
Prompt configuration impact, GPT-4 vs. 16 human evaluators, and non-parametric statistics.

</div>
</div>

<div class="outline-item">
<div class="outline-num">6</div>
<div class="outline-body">

[**Discussion, Limitations & Conclusion**](#16)
Human–AI synergy, study limitations, RQ conclusions synthesis, and future research roadmap.

</div>
</div>

</div>

---

## 1.1 Motivation: Why Traditional & Automated UX Testing Fall Short

<div class="fig-box" style="padding: 10px 12px; margin-bottom: 10px;">
<img src="./img/diag1_motivation_contrast.svg" alt="Manual UX Testing vs Existing Automated Tools vs Rapi + GPT-4" style="max-height: 365px;">
</div>

<div class="callout">
<strong>Bridging the Gap:</strong> Multimodal LLMs like <strong>GPT-4</strong> combine visual perception with semantic reasoning — enabling automated tools to inspect not only <em>technical performance</em>, but also <em>cognitive experience, interaction nuances, and Nielsen's usability heuristics</em>.
</div>

---

## 1.2 Research Objectives & Two Research Questions

We build a **GPT-4 + Rapi** automated UX detection tool grounded in **Nielsen's usability heuristics** and empirically investigate two core questions *(revealed step-by-step)*:

<div class="rq-stage">

* <div class="rq-card teal"><img src="./img/rq1_icon.svg" alt="RQ1 Prompt Engineering"><div><div class="rq-hook"><span class="rq-tag" style="background:#0f766e;">RQ1</span> Do interaction logs + screenshots beat screenshots alone?</div><div class="rq-q"><strong>How does providing different information within prompts</strong> (visual screenshots + Rapi JSON operation scripts vs. screenshots only) <strong>influence the accuracy of UX detection by GPT-4?</strong></div></div></div>
* <div class="rq-card accent"><img src="./img/rq2_icon.svg" alt="RQ2 GPT-4 vs Human Evaluators"><div><div class="rq-hook"><span class="rq-tag">RQ2</span> Can an LLM inspector outperform human evaluators on usability heuristics?</div><div class="rq-q"><strong>What is the performance of GPT-4 in user experience detection compared to human evaluators</strong> when using optimized heuristic-guided prompts?</div></div></div>

</div>

<div class="callout" style="margin-top: 16px;">
<strong>Goal:</strong> Lower early-stage UX testing cost while maintaining rigorous, consistent, and theory-grounded usability feedback.
</div>

---

## 2. Literature Review: Methods, Metrics & the Automation Gap

UX is inherently **subjective, holistic, dynamic, and context-dependent** [1, 7]. Existing evaluation methods and automated tools each face clear trade-offs:

| Category | Representative Approaches & Studies | Key Strengths | Critical Limitations |
| :--- | :--- | :--- | :--- |
| **Manual Methods** [8] | Self-report (surveys/interviews), Observational, Physiological | Captures real human perception & emotion | Costly, time-consuming, self-report bias & observer effect |
| **UX Metrics** [9] | Performance, Issue-based, Self-reported, Behavioral/Physiological | Holistic view when combined in mixed methods [10, 11] | High labor required to collect, code & align across lifecycle |
| **Web Usability Tools** [13] | 10 popular automated tools across 9 websites (19-dim framework) | Fast technical checks (HTML, links, load time) | Neglects usability issues; inconsistent; no usability theory |
| **ML / Load UI Tools** [14, 15] | AST embeddings + Random Forest (3.7% MAE); Load + UI tests | Accurate performance-impact & load estimation | Focuses on speed/functionality; blind to cognition & heuristics |
| **Our Approach** | **Rapi Web Recorder + GPT-4 + Nielsen's Heuristics (NS01–NS06)** | **Low-cost, consistent, multimodal & theory-grounded** | **Requires prompt tuning & human oversight for high-stakes UX** |

<div class="callout">
<strong>Key Research Gap:</strong> Established UX theories — such as <strong>Jakob Nielsen's 10 Heuristics [2]</strong> and <strong>Donald Norman's Design Principles [16]</strong> — have rarely been integrated into automated UX testing frameworks.
</div>

---

## 3.1 Automated UX Testing Architecture (Rapi + GPT-4)

<div class="split64">
<div class="left">

<div class="fig-box">
<img src="./img/fig1_framework.png" alt="Fig. 1: Framework for website UX evaluation" style="max-height: 390px;">
<div class="fig-cap">Fig. 1: Website UX evaluation framework combining Rapi, Nielsen's heuristics, and GPT-4</div>
</div>

</div>
<div class="right small-text">

### ⚙️ Four-Stage Evaluation Pipeline
1. **Interaction Recording (`Rapi v4.0.0`)**: Captures clicks, keyboard inputs, timestamps, status & page snapshots into an **Operation Script File** (JSON).
2. **Dual-Stream Bifurcation**:
   - **Text Script**: Extracts structured user actions & timing logs.
   - **Screenshot-Link Conversion**: Converts visual captures into accessible links for multimodal input.
3. **Heuristic-Guided GPT-4 Analysis**: Integrates visual + operational streams with **Nielsen's 6 heuristics (NS01–NS06)**.
4. **Dual Outputs**: Produces both **quantitative 1–5 scores** per indicator and **qualitative score explanations**.

</div>
</div>

---

## 3.2 Six Adopted Nielsen Usability Heuristics (NS01–NS06)

We selected **six perception-critical heuristics** from Nielsen [2] and embedded their definitions and concrete interface rules directly into the GPT-4 prompt (Appendix A):

| Code | Nielsen Usability Heuristic | Core UX Focus | Concrete Rule / Example in Prompt |
| :---: | :--- | :--- | :--- |
| **NS01** | **Visibility of system status** | Timely feedback so users always know system state | If execution exceeds `3000 ms`, display a clear loading status prompt |
| **NS02** | **User control and freedom** | Clearly marked "emergency exit" to undo/leave unwanted states | Provide explicit `Cancel` and `Return / Back` buttons |
| **NS03** | **Recognize, diagnose & recover from errors** | Plain-language error messages explaining cause & fix | On login/password failure, show clear error message specifying the issue |
| **NS04** | **Consistency and standards** | Uniform layout, visual hierarchy & platform conventions | `Back` button placed to the **left** of `Confirm` and **less prominent** |
| **NS05** | **Recognition rather than recall** | Minimize user memory load by making options visible | Provide accessible `Course Search` and `History Records` functions |
| **NS06** | **Match between system & real world** | Familiar language and natural, logical presentation | Display course schedules in a familiar **weekly table** (not flat list) |

---

## 3.3 Multimodal Prompt Engineering Pipeline (Dual-Data Strategy)

<div class="fig-box" style="padding: 8px 10px; margin-bottom: 8px;">
<img src="./img/diag2_prompt_pipeline.svg" alt="5-Part Structured GPT-4 Prompt Pipeline and Dual Configurations" style="max-height: 350px;">
</div>

<div class="callout" style="margin-top: 6px;">
<strong>Why Dual-Modal Data Matters:</strong> Screenshots show <em>what users see</em> (static layout, error boxes, loading spinners), whereas Rapi JSON scripts show <em>how users interact</em> (attempts, delays <code>>3000 ms</code>, navigation failures).
</div>

---

## 4.1 Case Study: Tennis Course Reservation System

<div class="fig-box" style="padding: 6px 10px; margin-bottom: 8px;">
<img src="./img/fig2_flowchart.png" alt="Fig. 2: Flowchart of course reservation process" style="max-height: 145px;">
<div class="fig-cap">Fig. 2: Tennis course reservation user flow (Homepage ➔ Course Overview ➔ Login Check ➔ Confirm / Record / Cancel)</div>
</div>

<div class="split64">
<div class="left">

<div class="fig-box" style="padding: 6px;">
<img src="./img/fig3_ui_compare.png" alt="Fig. 3: UI comparison with and without Cancel Reservation" style="max-height: 245px;">
<div class="fig-cap">Fig. 3: Example Story S09 — (a) Expected UI with "Cancel Reservation" vs. (b) Unexpected UI without cancellation</div>
</div>

</div>
<div class="right small-text">

### 🎾 Controlled A/B Story Design
- **Four Core Features**: Course listing, course search, course reservation, and reservation cancellation.
- **Expected vs. Unexpected Pairs**: Each of 9 stories (`S01`–`S09`) creates a controlled contrast:
  - **Expected**: Strictly follows Nielsen's heuristic.
  - **Unexpected**: Deliberately violates one target heuristic while holding other features constant.

</div>
</div>

---

## 4.2 Nine Evaluation Stories (S01–S09) & TIS / AIS Grouping

| Story | Evaluated Aspect | Target Heuristic (TIS) | Expected Scenario (Good UX) | Unexpected Scenario (Flawed UX) |
| :---: | :--- | :--- | :--- | :--- |
| **S01** | Login failure error | `NS01`, `NS03` | Failure message displayed on login fail | No failure message displayed |
| **S02** | Course schedule format | `NS06` | Weekly order in a **table** format | Displayed in a flat **list** format |
| **S03** | Back button color | `NS04` | Back button **less prominent** than Reserve | Back button **more prominent** than Reserve |
| **S04** | Back button position | `NS04` | Back button to the **left** of Reserve | Back button to the **right** of Reserve |
| **S05** | Back button presence | `NS02` | Back button provided | No back button provided |
| **S06** | Course search function | `NS05` | Course search function provided | No course search function provided |
| **S07** | Loading system prompt | `NS01` | System prompt shown while loading | No system prompt shown while loading |
| **S08** | Course history record | `NS05` | Course history record provided | No course history record provided |
| **S09** | Cancel booking option | `NS02` | History record **+ cancellation** provided | History record only (**no cancellation**) |

<div class="callout" style="margin-top: 6px; padding: 7px 14px;">
<strong>TIS vs. AIS Grouping:</strong> <strong>TIS (Target Indicator Score)</strong> measures the exact heuristic modified by the story (e.g., <code>NS05</code> in <code>S06</code>), while <strong>AIS (Auxiliary Indicator Score)</strong> covers the other 5 heuristics to test indirect spillover effects.
</div>

---

## 5.1 Experimental Setup & Non-Parametric Statistical Design

<div class="split55">
<div class="left">

<div class="fig-box">
<img src="./img/fig4_workflow.png" alt="Fig. 4: Workflow for evaluating UX using web operations and LLM scoring" style="max-height: 390px;">
<div class="fig-cap">Fig. 4: Parallel human questionnaire & LLM-based UX evaluation workflow</div>
</div>

</div>
<div class="right small-text">

### 🧪 Human vs. Automated Study Protocol
- **Human Evaluators**: **16 participants** (3 months web/SE training), 1-hour sessions, randomly assigned stories (both Expected & Unexpected).
  - Collected **54 questionnaires** across **27 story instances** (`n = 27`), rated on an **11-item 5-point Likert scale** (Appendix C).
- **Automated Tool (`GPT-4`)**: Recorded sessions via **Rapi**, evaluated at `temperature = 0.7`, **30 runs per scenario** across 2 prompt configurations.
- **Non-Parametric Tests** *(ordinal Likert data)*:
  - **Mann–Whitney U** (`p < 0.05`, effect size `r`): Expected vs. Unexpected TIS sensitivity.
  - **Wilcoxon Signed Rank**: Paired **AIS–TIS consistency**.

</div>
</div>

---

## 5.2 RQ1 Results: Visual + Operational Data vs. Visual-Only Prompts

<div class="three-col" style="margin-bottom: 10px;">
<div class="kpi-card teal">
<div class="kpi-val">0.84 vs. 0.71</div>
<div class="kpi-label"><strong>Precision (+0.13)</strong> — fewer false positives with operation scripts</div>
</div>
<div class="kpi-card">
<div class="kpi-val">0.55 vs. 0.50</div>
<div class="kpi-label"><strong>Recall (+0.05)</strong> — catches more dynamic UX inconsistencies</div>
</div>
<div class="kpi-card accent">
<div class="kpi-val">0.66 vs. 0.64</div>
<div class="kpi-label"><strong>F1 Score (+0.02)</strong> · Overall Accuracy similar (0.63 vs. 0.65)</div>
</div>
</div>

<div class="split55">
<div class="left small-text">

### 📊 Comparative Metrics (Table 4)
| Prompt Configuration | Acc. | Prec. | Rec. | F1 |
| :--- | :---: | :---: | :---: | :---: |
| **Visual + Operational Data** | 0.63 | **0.84** | **0.55** | **0.66** |
| **Visual Input Only** | **0.65** | 0.71 | 0.50 | 0.64 |

<div class="callout" style="margin-top: 10px;">
<strong>Takeaway (RQ1):</strong> Richer multimodal prompts noticeably lift <strong>Precision (+13 pts)</strong> and <strong>Recall (+5 pts)</strong>, proving prompt design must match the UX dimension being audited.
</div>

</div>
<div class="right small-text">

### 🔎 Scenario-Specific Insights (Tables 2 & 3)
- **Dynamic & Complex Features** *(Ops Script Wins)*:
  - `S01–NS03` (Error msg): **Large effect `r = 0.51`** (`p < 0.001`) vs. `r = 0.46` (Visual only).
  - `S06–NS05` (Search): **Medium effect `r = 0.31`** (`p < 0.001`).
  - `S05`, `S07` (Loading), `S08` (History): Significant (`p ≤ 0.003`) **only when operation logs are included**.
- **Static Visual Elements** *(Visual Only Suffices)*:
  - Button color/position (`S03`, `S04`) show comparable results without logs.
  - `S09–NS02` (Cancel button) was significant (`p = 0.013`, `r = 0.14`) only in Visual-Only mode — simpler prompts can reduce distraction for static checks.

</div>
</div>

---

## 5.3 RQ2 Results: GPT-4 (Optimized Prompt) vs. Human Evaluators

<div class="three-col" style="margin-bottom: 10px;">
<div class="kpi-card teal">
<div class="kpi-val">0.66 vs. 0.16</div>
<div class="kpi-label"><strong>F1 Score (4.1× higher)</strong> — GPT-4 vs. Human Evaluators</div>
</div>
<div class="kpi-card accent">
<div class="kpi-val">0.55 vs. 0.10</div>
<div class="kpi-label"><strong>Recall (5.5× higher)</strong> — Humans miss 90% of injected UX flaws</div>
</div>
<div class="kpi-card">
<div class="kpi-val">0.84 vs. 0.50</div>
<div class="kpi-label"><strong>Precision (+0.34)</strong> · Accuracy: <strong>0.63 vs. 0.33</strong></div>
</div>
</div>

<div class="split55">
<div class="left small-text">

### 📈 Metric-by-Metric Comparison (Tables 4 & 6)
<div style="margin-top: 8px;">
<div class="bar-row"><div><strong>Accuracy</strong></div><div class="bar-track"><div class="bar-fill" style="width: 63%;"></div></div><div class="bar-pct">0.63 vs 0.33</div></div>
<div class="bar-row"><div><strong>Precision</strong></div><div class="bar-track"><div class="bar-fill teal" style="width: 84%;"></div></div><div class="bar-pct">0.84 vs 0.50</div></div>
<div class="bar-row"><div><strong>Recall</strong></div><div class="bar-track"><div class="bar-fill accent" style="width: 55%;"></div></div><div class="bar-pct">0.55 vs 0.10</div></div>
<div class="bar-row"><div><strong>F1 Score</strong></div><div class="bar-track"><div class="bar-fill teal" style="width: 66%;"></div></div><div class="bar-pct">0.66 vs 0.16</div></div>
</div>

</div>
<div class="right small-text">

### 🧠 Why Human Evaluators Scored Low Recall
- **User Adaptability Bias**: Participants tended to **adapt their behavior to suboptimal designs** and treat flawed interfaces as "normal" (conservative ratings).
- **Limited Significant Hits (Table 5)**: Humans only detected **2 of 10** target pairs significantly:
  - `S01–NS01` (Login status, `p = 0.015`, `r = 0.47` M)
  - `S04–NS04` (Back button position, `p = 0.035`, `r = 0.39` M)
- **Zero Unexpected AIS–TIS Detection**: Humans found **0/10** significant AIS–TIS unexpected consistencies, whereas GPT-4 flagged **4/10**.

</div>
</div>

---

## 5.4 Scenario-Level Sensitivity & AIS–TIS Consistency (Tables 2, 3 & 5)

| Story – Indicator | Tested UX Element | GPT-4 (Visual + Ops) TIS `p` / `r` | GPT-4 (Visual Only) TIS `p` / `r` | Human Evaluators TIS `p` / `r` | GPT-4 (+Ops) Unexpected AIS–TIS |
| :--- | :--- | :---: | :---: | :---: | :---: |
| **S01 – NS01** | Login error status | 0.317 / 0.16 (S) | 0.951 / 0.00 (N) | **0.015\*** / **0.47 (M)** | 0.196 |
| **S01 – NS03** | Error diagnosis | **0.000\*** / **0.51 (L)** | **0.000\*** / **0.46 (M)** | 0.059 / 0.35 (M) | 0.207 |
| **S02 – NS06** | Weekly table vs. list | 0.218 / 0.07 (N) | 0.398 / 0.05 (N) | 0.937 / 0.02 (N) | 0.499 |
| **S03 – NS04** | Back button color | 0.083 / 0.03 (N) | 0.157 / 0.07 (N) | 0.542 / 0.12 (S) | **0.010\*** |
| **S04 – NS04** | Back button position | 1.000 / 0.06 (N) | 0.418 / 0.04 (N) | **0.035\*** / **0.39 (M)** | 0.440 |
| **S05 – NS02** | Back button presence | **0.003\*** / 0.07 (N) | 0.107 / 0.09 (N) | 0.783 / 0.06 (N) | **0.026\*** |
| **S06 – NS05** | Course search | **0.000\*** / **0.31 (M)** | **0.000\*** / **0.33 (M)** | 0.052 / 0.37 (M) | 0.562 |
| **S07 – NS01** | Loading prompt | **0.000\*** / 0.08 (N) | 0.074 / 0.06 (N) | 0.845 / 0.04 (N) | **0.000\*** |
| **S08 – NS05** | History record | **0.001\*** / 0.00 (N) | 0.153 / 0.08 (N) | 0.183 / 0.26 (S) | **0.000\*** |
| **S09 – NS02** | Cancel booking | 0.512 / 0.03 (N) | **0.013\*** / **0.14 (S)** | 0.054 / 0.37 (M) | 0.623 |

<div class="callout" style="margin-top: 6px; padding: 7px 14px;">
<strong>Complementary Strengths:</strong> GPT-4 systematically catches <strong>error handling (<code>S01</code>), feature completeness (<code>S05</code>, <code>S06</code>, <code>S08</code>), and loading feedback (<code>S07</code>)</strong>, while human intuition remains sharp on <strong>spatial layout conventions (<code>S04</code>)</strong>.
</div>

---

## 6.1 Discussion & Study Limitations

<div class="two-col">
<div class="card teal small-text">

### 🤝 Toward Synergistic AI + Human UX Testing
- **Beyond Functional Automation**: Unlike traditional automated tools limited to speed/load metrics, GPT-4 interprets interface semantics, error guidance, and cognitive load via Nielsen's heuristics.
- **Cost-Effective Early Screening**: Run Rapi + GPT-4 rapidly in early iterations to catch missing controls, broken feedback, and consistency issues before recruiting lab participants.
- **Irreplaceable Human Judgment**: Human evaluators retain intuitive sensitivity to spatial ergonomics (`S04`), emotional resonance, and domain-specific cultural context — pointing to a **hybrid AI + Human workflow**.

</div>
<div class="card accent small-text">

### ⚠️ Threats to Validity & Limitations
- **Sample Size**: 16 participants (54 questionnaires across 27 story instances) may not represent full user diversity across ages and domains.
- **Environmental Factors**: Testing venue and network latency could introduce uncontrolled noise into user interaction logs.
- **UX Subjectivity**: Individual backgrounds and prior expectations naturally create variance in perceived usability.
- **Ground-Truth Design Bias**: Although grounded in Nielsen's heuristics, crafting Expected/Unexpected scenarios may embed researcher assumptions — warranting broader multi-site validation.

</div>
</div>

---

## 6.2 Conclusion & Future Work

<div class="fig-box" style="padding: 8px 10px; margin-bottom: 8px;">
<img src="./img/diag3_rq_conclusions.svg" alt="Visual Synthesis of RQ1 and RQ2 Conclusions" style="max-height: 350px;">
</div>

<div class="future-strip">
<div class="future-pill"><strong>🤝 1. AI–Human Synergy</strong><br>Study where human expertise is vital — e.g., emotional resonance in healthcare UI & cultural appropriateness.</div>
<div class="future-pill"><strong>🔒 2. Multimodal & Ethics</strong><br>Integrate voice/video data with strict privacy boundaries & validation protocols for finance/medical apps.</div>
<div class="future-pill"><strong>📱 3. Mobile & Platform Rules</strong><br>Extend to mobile platforms with platform-specific heuristics & clear AI–human alignment metrics.</div>
</div>

---

<!-- _class: closing -->

# Thank You for Your Attention!

<p style="font-size: 1.05em; max-width: 840px;">
Applying Large Language Model to User Experience Testing
</p>

<div class="contact-card">
<strong>Nien-Lin Hsueh*</strong> &nbsp;·&nbsp; <code>nlhsueh@fcu.edu.tw</code><br>
<strong>Hsuen-Jen Lin</strong> &nbsp;·&nbsp; <code>kobayasa209924@gmail.com</code> &nbsp;|&nbsp; <strong>Lien-Chi Lai</strong> &nbsp;·&nbsp; <code>p1000433@mail.fcu.edu.tw</code><br>
Department of Information Engineering and Computer Science, Feng Chia University<br>
Published in <strong>Electronics 2024, 13, 4633</strong> · <code>https://doi.org/10.3390/electronics13234633</code><br>
<span style="font-size: 0.85em; opacity: 0.85;">Grant: NSTC112-2221-E-035-030-MY2 · Questions & Discussion Welcome!</span>
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
