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

<!--
Bibliographic & Research Overview:
This article (Hsueh, Lin, & Lai, Electronics 2024, 13(23), 4633; published 24 November 2024; funded by NSTC grant NSTC112-2221-E-035-030-MY2) investigates how multimodal Large Language Models (specifically GPT-4) can operationalize established Human-Computer Interaction (HCI) theory for automated User Experience (UX) evaluation.

Core Problem & Contribution:
- Traditional manual UX evaluation (lab testing, heuristic inspections, user interviews) is hampered by subjectivity, lack of standardization, high recruitment/coding costs, and observer effects.
- Existing automated web testing tools largely audit technical metrics (HTML validity, broken links, response latency) while neglecting cognitive ergonomics and usability heuristics.
- The authors bridge this divide by coupling Rapi (v4.0.0) automated web interaction recording (JSON operation logs + sequential page screenshots) with GPT-4 guided by six of Jakob Nielsen's usability heuristics (NS01–NS06), validated on a controlled tennis course reservation web application against 16 human evaluators.
-->

---

## Opening Hook: "Looks Fine to Me!" ... Or Did We Miss 90% of UX Bugs?

<div class="fig-box" style="padding: 6px; margin-bottom: 10px; background: #fbf9f2;">
<img src="./img/uxtesting_hook.jpg" alt="Manual Human UX Testing vs Rapi + GPT-4 UX Inspector" style="max-height: 415px; border-radius: 6px;">
</div>

<div class="callout" style="margin-top: 6px; padding: 9px 16px;">
<strong>The Big Idea:</strong> Human evaluators naturally adapt to suboptimal interfaces — yielding a surprisingly conservative <strong>Recall of 0.10 (F1 = 0.16)</strong>. Pairing <strong>Rapi interaction logs + screenshots</strong> with <strong>GPT-4</strong> guided by <strong>Nielsen's heuristics</strong> achieves <strong>0.84 Precision</strong> and <strong>0.66 F1</strong>.
</div>

<!--
Empirical Motivation & Core Finding:
This opening contrast synthesizes the central empirical takeaway from Section 4.4 (Table 6) and Section 4.3 (Table 4) of the paper.
- Human Evaluator Conservatism (Recall = 0.10, Precision = 0.50, Accuracy = 0.33, F1 = 0.16): Across 54 questionnaires covering 27 controlled story instances, human evaluators exhibited strong user adaptability bias. Rather than flagging missing controls or silent failures as usability defects, participants subconsciously adjusted their behavior to accommodate suboptimal designs and rated flawed interfaces conservatively as acceptable.
- Multimodal LLM Sensitivity (Precision = 0.84, Recall = 0.55, Accuracy = 0.63, F1 = 0.66): When GPT-4 receives both Rapi JSON interaction logs and page screenshots structured around Nielsen's heuristics, it systematically penalizes injected violations without habituating to poor design, achieving 5.5x higher recall and 4.1x higher F1 than human evaluators.
-->

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

<!--
Paper Architecture & Section Mapping:
The manuscript is organized into six sections plus three methodological appendices that support full reproducibility:
1. Introduction (Section 1): Frames UX testing within the software development lifecycle (from unit testing to user acceptance testing), cites Nielsen & Molich [2] and Alomari et al. [3] on the dual necessity of usability and learnability, reviews multimodal VLM advances (Flamingo [4], Emu [5]), and formulates RQ1 and RQ2.
2. Literature Review (Section 2): Surveys UX definition challenges (Law et al. [1], Vermeeren et al. [6], Kashfi et al. [7]), evaluation methods/metrics (Inan et al. [8], Albert & Tullis [9]), mixed-method studies [10, 11], and automated UX evaluation gaps [12–15].
3. Research Methodology (Section 3): Details the Rapi + GPT-4 pipeline (Fig. 1), heuristics NS01–NS06 (Appendix A), five-part prompt template (Appendix B), and the tennis course reservation case study (Figs. 2–3, Table 1).
4. Experimental Results & Analysis (Section 4): Reports the parallel human vs. GPT-4 protocol (Fig. 4, Appendix C), TIS/AIS grouping, and Mann-Whitney U / Wilcoxon Signed Rank results (Tables 2–6).
5. Discussion & Limitations (Section 5) and Conclusions (Section 6): Synthesize RQ1–RQ2 answers, human-AI complementarity, validity threats, and three future research directions.
-->

---

## 1.1 Motivation: Why Traditional & Automated UX Testing Fall Short

<div class="fig-box" style="padding: 10px 12px; margin-bottom: 10px;">
<img src="./img/diag1_motivation_contrast.svg" alt="Manual UX Testing vs Existing Automated Tools vs Rapi + GPT-4" style="max-height: 365px;">
</div>

<div class="callout">
<strong>Bridging the Gap:</strong> Multimodal LLMs like <strong>GPT-4</strong> combine visual perception with semantic reasoning — enabling automated tools to inspect not only <em>technical performance</em>, but also <em>cognitive experience, interaction nuances, and Nielsen's usability heuristics</em>.
</div>

<!--
Theoretical Background & Technological Catalyst:
- Dual Usability Imperative: The paper anchors its motivation in two foundational HCI observations: Nielsen & Molich [2] noted that if a system fails to satisfy usability needs, ease of use alone is irrelevant; conversely, Alomari et al. [3] argued that if a system is too difficult to operate, meeting functional requirements is moot because users cannot complete their tasks.
- Why Existing Automation Is Insufficient: Automated web scanners excel at functional regression and performance benchmarking (load time, DOM validity), yet remain blind to users' cognitive experiences, interaction friction, and emotional needs.
- Multimodal Foundation Models as Enablers: The authors cite Flamingo (Alayrac et al. [4], capable of few-shot visual-language reasoning across up to 32 images/videos) and Emu (Sun et al. [5], unified autoregressive multimodal pretraining for zero-shot/few-shot VQA and description) as evidence that multimodal LLMs like GPT-4 can jointly interpret interface visuals and sequential textual logs, bringing semantic and heuristic reasoning into automated UX auditing.
-->

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

<!--
Research Design & Operationalization of RQ1 and RQ2:
The study establishes three engineering and empirical objectives: (1) build an automated UX detection tool integrating GPT-4's vision capabilities with Nielsen's heuristics; (2) examine how prompt content and structure alter detection accuracy; and (3) benchmark optimized LLM prompts against human evaluators.
- RQ1 (Prompt Modality Ablation): Isolates the marginal value of dynamic behavioral telemetry by contrasting two prompt configurations on the exact same Rapi sessions: Visual Input Only (screenshots + heuristics) vs. Visual Input with Operational Data (screenshots + Rapi JSON operation scripts + heuristics).
- RQ2 (Human-AI Benchmark): Compares the optimized multimodal GPT-4 configuration against 16 trained human evaluators who rated the identical scenarios using an 11-item, 5-point Likert questionnaire mapped to NS01–NS06.
- Practical Objective: Reduce early-stage UX testing cost and subjectivity while preserving theory-grounded quantitative ratings and actionable qualitative diagnostics.
-->

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

<!--
Detailed Synthesis of Prior Work & Research Gap:
- Complexity of UX Constructs: Kashfi et al. [7] identify five inherent UX properties (subjectivity, holism, dynamism, context dependency, and worth) that resist standardization. Law et al. [1] further note a persistent divide: academia emphasizes hedonic and emotional qualities, whereas industry prioritizes functionality and pragmatic usability. Vermeeren et al. [6] stress the shortage of early-stage, lifecycle-integrated evaluation methods.
- Evaluation Methods (Inan et al. [8]): Self-report measures (surveys/interviews) are low-cost but prone to self-report bias; observational measures offer higher objectivity but suffer from observer effects and labor cost; physiological measures (EEG, heart rate, GSR) maximize objectivity at the highest instrumentation cost.
- Metrics & Mixed Methods: Albert & Tullis [9] classify UX metrics into performance, issue-based, self-reported, and behavioral/physiological categories. Prior mixed-method studies combined heuristics + questionnaires on Brazil's Immunization Information System (Guimaraes et al. [10]) and UEQ + usability testing on Halodoc mobile health (Mochammad et al. [11]).
- Automation Gap: Nguyen et al. [12] noted the organizational disconnect between UX designers and SE/DevOps engineers. Namoun et al. [13] audited 10 popular web usability tools across 9 websites (3 categories) on a 19-dimension framework, finding technical bias, inconsistent outputs, and no grounding in usability theory. Biringa & Kul [14] used AST embeddings + Random Forest (3.7% MAE) to predict performance impact of updates, while Whiting [15] coupled load testing with automated UI tests. None of these integrate Jakob Nielsen's 10 heuristics [2] or Donald Norman's design principles [16].
-->

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

<!--
Pipeline Mechanics & Architectural Rationale (Figure 1):
The framework automates UX auditing across four tightly coupled stages to eliminate manual log coding and reduce evaluator bias:
1. Interaction Recording (Rapi v4.0.0): As a user (or tester) executes a web task, Rapi records granular browser events (clicks, keyboard inputs, execution status, precise startTime/endTime timestamps, and step-level page snapshots) into a structured JSON Operation Script File (e.g., keyed by browser environment such as Chrome 122.0.0.6).
2. Dual-Stream Bifurcation: The raw Operation Script File is parsed into two complementary representations: a textual operation script (preserving chronological action logs, durations, and status flags) and a screenshot-link conversion stream that exposes each captured page state as an image reference for GPT-4's vision encoder.
3. Heuristic-Guided Multimodal Evaluation: GPT-4 receives both streams alongside formal definitions and concrete examples of Nielsen's six heuristics (NS01–NS06) and a standardized scoring rubric.
4. Dual Outputs: For every session, the model produces both quantitative integer scores (1–5 scale per heuristic, anchored at a baseline of 3 and adjusted up or down for notable strengths or violations) and qualitative justifications explaining the specific visual or behavioral evidence behind each rating.
-->

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

<!--
Selection Rationale & Appendix A Operational Definitions:
Rather than applying all 10 of Nielsen's heuristics, the authors selected six heuristics most directly tied to immediate user perception, interaction feedback, operational freedom, and cognitive load in web workflows. Each heuristic was codified in Appendix A with explicit interface criteria embedded into the GPT-4 prompt:
- NS01 (Visibility of system status): Users must never doubt system state or action success. Concrete threshold in prompt: whenever execution time exceeds 3000 ms, the system must display an explicit status/loading indicator.
- NS02 (User control and freedom): Users frequently trigger unintended actions and need clearly marked "emergency exits" (undo/redo, Cancel, Return/Back buttons) without traversing extended recovery paths.
- NS03 (Recognize, diagnose, and recover from errors): Error messages must use plain language (no cryptic codes), identify the exact cause, and suggest a fix (e.g., explicitly stating which password policy was violated during authentication/registration).
- NS04 (Consistency and standards): Uniform conventions reduce learning curves and enable skill transfer. Concrete rule in prompt: the Return/Back button should be placed to the left of the Confirm/Reserve button, and Confirm should be visually more conspicuous.
- NS05 (Recognition rather than recall): Minimize memory load by keeping options and prior records visible or easily retrievable (e.g., course search and reservation history functions).
- NS06 (Match between system and real world): Align language and data presentation with familiar real-world conventions (e.g., weekly timetable table instead of an unstructured flat list; trash-bin metaphor for deletion).
-->

---

## 3.3 Multimodal Prompt Engineering Pipeline (Dual-Data Strategy)

<div class="fig-box" style="padding: 8px 10px; margin-bottom: 8px;">
<img src="./img/diag2_prompt_pipeline.svg" alt="5-Part Structured GPT-4 Prompt Pipeline and Dual Configurations" style="max-height: 350px;">
</div>

<div class="callout" style="margin-top: 6px;">
<strong>Why Dual-Modal Data Matters:</strong> Screenshots show <em>what users see</em> (static layout, error boxes, loading spinners), whereas Rapi JSON scripts show <em>how users interact</em> (attempts, delays <code>>3000 ms</code>, navigation failures).
</div>

<!--
Five-Part Prompt Structure (Appendix B) & Dual-Modality Justification:
Appendix B documents the exact structured prompt passed to GPT-4, composed of five sequential blocks:
1. Introduction & Context: Explains the web interaction JSON dataset containing user actions, timestamps, outcomes, snapshots, and execution context.
2. JSON Format Explanation: Defines key schema fields (`title`, `startTime`, `endTime`, `logs` with message patterns, `cases`, and `screenshots`) so the LLM parses behavioral logs accurately without hallucinating field semantics.
3. User Operation Data: Embeds the recorded Rapi JSON snippet (included in the Visual + Operational Data condition; omitted in the Visual-Only ablation).
4. Nielsen's Usability Principles: Injects the full NS01–NS06 definitions and concrete domain examples from Appendix A.
5. Request for Evaluation: Instructs GPT-4 to evaluate website performance using snapshots and timing records, rate each heuristic on an integer 1–5 scale (starting from a baseline of 3 points and adjusting up or down based on significant evidence), justify each score, and provide an overall summary.

Why Dual-Modal Input Matters: Static screenshots capture visual layout, button hierarchy, and rendered error dialogs, but cannot reveal temporal latency (>3000 ms), repeated failed login attempts, or navigation dead-ends. Combining both modalities allows GPT-4 to cross-verify visual cues against dynamic interaction traces.
-->

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

<!--
Controlled A/B Testbed Design (Figures 2 & 3):
To evaluate automated UX detection objectively without confounding domain variables, the authors built a custom tennis course reservation web application covering four realistic functional requirements: course listing, course search, course reservation, and reservation cancellation.
- User Flow (Figure 2): Homepage -> Course Overview -> Select Course -> Login Status Check. Unauthenticated users are routed to Login (failed login loops back to Login; successful login proceeds to Reservation Confirmation). On Confirmation, users either confirm (recording reservation details) or cancel (redirecting to the Reservation Record page).
- Controlled Scenario Bifurcation: Each of the 9 stories (S01–S09) exists in two strictly paired versions: an Expected Scenario adhering to Nielsen's heuristics and an Unexpected Scenario that deliberately injects a single targeted heuristic violation while holding all unrelated pages and features constant.
- Concrete Contrast (Figure 3, Story S09): Both versions display the user's reservation history, but the Expected UI (Fig. 3a) provides an explicit "Cancel Reservation" button whereas the Unexpected UI (Fig. 3b) removes cancellation entirely, isolating NS02 (User Control and Freedom).
-->

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

<!--
Experimental Matrix (Table 1) & TIS/AIS Analytical Separation:
Table 1 maps all nine stories (S01–S09) to 10 Target Indicator pairs (S01 targets both NS01 and NS03, while S02–S09 each target one primary heuristic):
- S01 (NS01, NS03): Login failure displays explicit error message vs. silent failure with no message.
- S02 (NS06): Courses rendered in a weekly timetable table vs. a flat list lacking temporal structure.
- S03 (NS04): Back button visually less prominent than Reserve vs. Back button more prominent.
- S04 (NS04): Back button positioned to the left of Reserve vs. positioned to the right.
- S05 (NS02): Back button present vs. omitted.
- S06 (NS05): Course search function available vs. omitted.
- S07 (NS01): Loading system prompt shown during delay vs. no loading prompt.
- S08 (NS05): Course history record available vs. omitted.
- S09 (NS02): History record + booking cancellation available vs. history record only.

TIS vs. AIS Analytical Rationale (Section 4.2):
- TIS (Target Indicator Score) isolates scores on the exact heuristic manipulated in a story (e.g., NS05 in S06) to test direct detection sensitivity between Expected and Unexpected versions.
- AIS (Auxiliary Indicator Score) aggregates the remaining five non-targeted heuristics (e.g., NS01–NS04 and NS06 in S06) to check whether a localized defect triggers unintended spillover effects or consistent divergence between target and auxiliary ratings.
-->

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

<!--
Parallel Evaluation Protocol & Non-Parametric Statistical Justification (Figure 4):
- Human Participant Protocol: 16 participants with 3 months of web development and software engineering training completed 1-hour testing sessions. Each participant was randomly assigned stories containing both Expected and Unexpected versions (completing additional stories if time permitted), yielding 54 completed questionnaires across 27 distinct story instances (n = 27).
- Questionnaire Instrument (Appendix C): An 11-item, 5-point Likert questionnaire covering NS01–NS06 (items 1–2: system state & reasonable response time; items 3–4: return & cancel/redo freedom; items 5–6: clear error messages & major operation reminders; items 7–9: color scheme, consistent layout, general web standards; item 10: low memory load; item 11: real-world display habits). The questionnaire was identical across stories so participants were not cued to which defect was injected.
- LLM Evaluation Protocol: Participants' actual Rapi recordings and screenshots served as direct inputs to GPT-4. API temperature was set to 0.7 to capture response variability, and each Expected/Unexpected scenario was evaluated 30 times under both prompt configurations (Visual + Ops vs. Visual Only).
- Statistical Tests: Because Likert scores are ordinal and human sample size is modest (n = 27), non-parametric tests were applied: two-sample Mann-Whitney U test (alpha = 0.05) with rank-biserial/Z-based effect size r (N < 0.1, S = 0.1–0.3, M = 0.3–0.5, L > 0.5) for Expected vs. Unexpected TIS comparisons, and paired Wilcoxon Signed Rank test for AIS-TIS consistency.
-->

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

<!--
Deep Dive into RQ1: Modality Trade-offs & Scenario Sensitivity (Tables 2, 3 & 4):
Comparing Visual + Operational Data against Visual Input Only reveals a nuanced trade-off rather than a uniform gain:
- Aggregate Classification Metrics (Table 4): Visual + Ops substantially improves Precision (0.84 vs. 0.71, +0.13), Recall (0.55 vs. 0.50, +0.05), and F1 (0.66 vs. 0.64, +0.02), indicating far fewer false positives and stronger defect capture. Overall Accuracy is slightly lower (0.63 vs. 0.65), driven by static-UI edge cases where extra JSON text can dilute visual focus.
- Where Operation Scripts Are Essential (Tables 2 vs. 3): Dynamic and stateful defects depend heavily on Rapi logs. S01-NS03 (login error handling) strengthens from medium effect r = 0.46 (Visual Only) to large effect r = 0.51 (Visual + Ops, U = 6968.0, Z = 8.35, p < 0.001). Three scenarios reach statistical significance ONLY with operation logs: S05-NS02 (back button presence, p = 0.003), S07-NS01 (loading prompt, p < 0.001), and S08-NS05 (history record, p = 0.001).
- Where Visual-Only Prompts Suffice or Excel: Purely static layout checks (S03 button color, S04 button position) perform comparably without logs. Notably, S09-NS02 (missing cancellation button) reached significance only in Visual-Only mode (p = 0.013, r = 0.14 vs. p = 0.512 with logs), demonstrating that leaner prompts can reduce distraction for visually self-contained checks.
-->

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

<!--
Deep Dive into RQ2: GPT-4 vs. Human Evaluators (Tables 4, 5 & 6):
When evaluated against the exact same controlled Expected/Unexpected ground truth, optimized multimodal GPT-4 outperforms the 16 human evaluators across every classification metric:
- Metric Disparity: Accuracy 0.63 vs. 0.33, Precision 0.84 vs. 0.50, Recall 0.55 vs. 0.10 (5.5x higher), and F1 0.66 vs. 0.16 (4.1x higher).
- Cognitive Mechanism Behind Low Human Recall (0.10): The authors attribute humans' severe false-negative rate to user adaptability bias. During live tasks, participants adapt their workflow around missing features or silent delays, normalizing suboptimal UX rather than penalizing it on Likert scales. In addition, 3 months of SE training may be insufficient to sensitize evaluators to subtle heuristic violations without targeted UX inspection checklists.
- Significant Target Detections (Table 5): Humans achieved statistical significance on only 2 of 10 story-indicator pairs: S01-NS01 (login failure status, U = 67.5, Z = 2.43, p = 0.015, r = 0.47 M) and S04-NS04 (back button position, U = 62.5, Z = 2.04, p = 0.035, r = 0.39 M). Three others were borderline non-significant (S01-NS03 p = 0.059; S06-NS05 p = 0.052; S09-NS02 p = 0.054).
- Unexpected AIS-TIS Consistency: Humans detected 0 of 10 significant unexpected AIS-TIS divergences, whereas GPT-4 (+Ops) flagged 4 of 10 (S03, S05, S07, S08), demonstrating much higher sensitivity to non-standard interface deviations.
-->

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

<!--
Granular Cross-Comparison of Tables 2, 3 & 5:
Examining all 10 story-indicator pairs side by side uncovers distinct error profiles and human-AI complementarity:
- GPT-4 (+Ops) Strengths: Excels at systematic, rule-verifiable functional and feedback checks: S01-NS03 (p < 0.001, r = 0.51 L), S06-NS05 (p < 0.001, r = 0.31 M), S05-NS02 (p = 0.003), S07-NS01 (p < 0.001), and S08-NS05 (p = 0.001). Notice that S05, S07, and S08 exhibit statistically significant p-values despite small/negligible r values due to rank-order consistency across 30 repeated LLM runs (and strong Unexpected AIS-TIS significance in S03 p = 0.010, S05 p = 0.026, S07 p < 0.001, S08 p < 0.001).
- Human Spatial & Status Intuition: Humans decisively outperformed GPT-4 on S04-NS04 (back button placed right of Reserve: human p = 0.035, r = 0.39 M vs. GPT-4 p = 1.000 / 0.418), showing that subtle spatial conventions remain easier for human visual perception than for GPT-4. Humans also registered login failure under NS01 (p = 0.015, r = 0.47 M), whereas GPT-4 categorized the same defect primarily under NS03 (error diagnosis).
- Shared Blind Spot (S02-NS06): Neither GPT-4 (p = 0.218 / 0.398) nor humans (p = 0.937) significantly penalized flat list vs. weekly table display, suggesting that layout format preferences are less strictly perceived as usability violations than missing controls or broken error feedback.
-->

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

<!--
Theoretical Implications & Validity Threats (Sections 5.2 & 5.3):
- Paradigm Shift Beyond Functional Automation: Traditional automated tools verify technical health (load times, HTTP status, DOM errors). Embedding Nielsen's heuristics into multimodal LLM prompts demonstrates that automated systems can audit higher-order cognitive and interaction dimensions (error recovery clarity, status visibility, functional completeness) consistently and at low marginal cost.
- Hybrid AI-Human Workflow: Because GPT-4 systematically catches missing features and feedback violations (high recall/precision) while humans retain superior intuition for spatial layout ergonomics (S04), emotional tone, and real-world context, the paper advocates a staged hybrid pipeline: automated Rapi + GPT-4 screening during rapid early iterations, followed by targeted human expert review.
- Four Methodological Limitations (Section 5.3):
  1. Sample Size & Generalizability: 16 participants (54 questionnaires across 27 story instances) with homogeneous web/SE training cannot represent age, domain, and cultural diversity.
  2. Environmental Confounders: Physical testing venue conditions and network latency variations could introduce uncontrolled timing noise into Rapi interaction logs.
  3. Inherent UX Subjectivity: Individual backgrounds and prior mental models naturally introduce rating variance that no single rubric fully eliminates.
  4. Ground-Truth Construction Bias: Although Expected/Unexpected pairs were derived from Nielsen's heuristics, researcher assumptions during scenario authoring may influence ground-truth labels.
-->

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

<!--
Synthesis of Contributions & Three-Pillar Research Roadmap (Section 6):
This study validates that pairing Rapi web interaction recording with heuristic-guided GPT-4 prompts yields a rapid, consistent, and theory-grounded automated UX inspector. Answering RQ1, adding operational scripts elevates precision (0.84 vs. 0.71), recall (0.55 vs. 0.50), and F1 (0.66 vs. 0.64), especially for dynamic workflows, while visual-only prompts remain competitive for static visual audits. Answering RQ2, GPT-4 outperforms human evaluators by 5.5x in recall and 4.1x in F1 on heuristic violations while exhibiting clear complementarity with human spatial judgment.

Three Future Research Directions Outlined in Section 6:
1. AI-Human Synergy in High-Empathy Domains: Define division of labor where human judgment is indispensable, such as emotional resonance in healthcare interfaces and cultural appropriateness in localized applications.
2. Expanded Multimodality & AI Ethics Governance: Incorporate richer behavioral channels (voice think-aloud, video/facial cues) under transparent data-privacy boundaries and rigorous validation protocols for high-stakes financial and medical systems.
3. Mobile Platform Extension & Alignment Metrics: Extend the framework to mobile ecosystems with gesture/viewport-specific heuristics beyond Nielsen's web rules, optimize task-adaptive prompt engineering, and establish formal AI-human evaluation alignment metrics.
-->

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

<!--
Reference & Reproducibility Resources:
- Full Citation: Hsueh, N.-L.; Lin, H.-J.; Lai, L.-C. Applying Large Language Model to User Experience Testing. Electronics 2024, 13(23), 4633. DOI: https://doi.org/10.3390/electronics13234633 (Open Access, CC BY 4.0).
- Included Appendices in Published Article: Appendix A (full operational definitions and domain examples for NS01–NS06), Appendix B (complete five-part GPT-4 prompt template and Rapi JSON schema explanation), and Appendix C (11-item 5-point Likert UX evaluation questionnaire).
- Data Availability & Funding: Supported by the National Science and Technology Council (NSTC), Taiwan R.O.C., grant NSTC112-2221-E-035-030-MY2. Participant-level interaction records are available upon request from the corresponding author (nlhsueh@fcu.edu.tw) due to participant privacy protections.
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
