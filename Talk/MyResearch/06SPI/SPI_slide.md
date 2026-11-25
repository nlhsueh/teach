---
marp: true
theme: gaia
size: 16:9
paginate: true
html: true
header: '<div class="hdr-wrap"><span class="hdr-title">Software Process Improvement at Feng Chia University: An Experience Report</span><div class="hdr-actions"><a class="lang-btn" href="./SPI_slide_zh.html" title="切換至繁體中文簡報">🌐 繁</a><div class="nav-dropdown"><button class="nav-btn">Sections ▾</button><div class="nav-menu"><a href="#2">Outline</a><a href="#3">1. Motivation &amp; Context</a><a href="#4">2. Vision &amp; Objectives</a><a href="#5">3. OIT SPI Lessons (2.1–2.6)</a><a href="#10">4. Influences on IECS</a><a href="#13">5. Continuous Improvement</a><a href="#14">6. Benefits &amp; Takeaways</a></div></div></div></div>'
footer: 'Nien-Lin Hsueh, Don-Lin Yang, Lu-Mei Wang & Peng-Hua Chu · Feng Chia University · JSES 2006'
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
  line-height: 1.46;
  padding: 66px 54px 46px 54px;
  box-sizing: border-box;
  letter-spacing: 0.01em !important;
}

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

.hdr-wrap { width: 100%; display: flex; justify-content: space-between; align-items: center; }
.hdr-title { letter-spacing: 0.01em; opacity: 0.94; }
.hdr-actions { display: inline-flex; align-items: center; gap: 8px; }

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
.lang-btn:hover { background: rgba(255, 255, 255, 0.26); text-decoration: none !important; }

.nav-dropdown { position: relative; display: inline-block; padding-bottom: 6px; margin-bottom: -6px; }
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
.nav-dropdown:hover .nav-menu, .nav-dropdown.open .nav-menu { display: block; }
.nav-menu a { display: block; padding: 7px 14px; color: var(--slate-700); text-decoration: none; font-size: 12.5px; font-weight: 500; line-height: 1.35; }
.nav-menu a:hover { background: var(--slate-100); color: var(--navy); }

footer { position: absolute; left: 54px; bottom: 14px; font-size: 12.5px; color: var(--slate-500); font-weight: 500; }
section::after { position: absolute; right: 54px; bottom: 14px; font-size: 12.5px; font-weight: 700; color: var(--navy); content: attr(data-marpit-pagination) ' / ' attr(data-marpit-pagination-total); }

h1 { color: var(--navy); font-size: 1.7em; font-weight: 800; line-height: 1.22; margin: 0 0 12px 0; letter-spacing: 0 !important; }
h2 { color: var(--navy); font-size: 1.22em; font-weight: 700; line-height: 1.25; margin: 0 0 12px 0; padding-bottom: 6px; border-bottom: 2.5px solid var(--navy); display: flex; align-items: center; gap: 8px; letter-spacing: 0 !important; }
h3 { color: var(--accent); font-size: 0.96em; font-weight: 700; margin: 4px 0 6px 0; letter-spacing: 0 !important; }
p { margin: 0 0 8px 0; }
ul, ol { margin: 4px 0 8px 0; padding-left: 22px; }
li { margin-bottom: 5px; line-height: 1.42; }
strong { color: var(--slate-900); }
a { color: #2563eb; text-decoration: none; }
a:hover { text-decoration: underline; }

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
  display: inline-block; align-self: flex-start;
  background: rgba(255, 255, 255, 0.14); border: 1px solid rgba(255, 255, 255, 0.32);
  color: #f8fafc; font-size: 0.72em; font-weight: 600; letter-spacing: 0.06em;
  text-transform: uppercase; padding: 5px 14px; border-radius: 999px; margin-bottom: 18px;
}
section.lead h1 { color: #ffffff; font-size: 1.98em; font-weight: 800; line-height: 1.24; margin-bottom: 16px; text-align: left; }
section.lead .subtitle { color: #cbd5e1; font-size: 0.94em; line-height: 1.5; margin-bottom: 24px; max-width: 960px; }
section.lead .meta-box { border-left: 4px solid #f43f5e; padding-left: 18px; color: #e2e8f0; font-size: 0.85em; line-height: 1.58; }
section.lead .grant { margin-top: 20px; font-size: 0.72em; color: #94a3b8; }

section.closing {
  background: linear-gradient(135deg, #102442 0%, #1b365d 65%, #8c1d40 100%);
  color: #ffffff;
  display: flex; flex-direction: column; justify-content: center; align-items: center; text-align: center;
  padding: 54px 72px;
}
section.closing header, section.closing footer, section.closing::after { display: none !important; }
section.closing h1 { color: #ffffff; font-size: 2.2em; margin-bottom: 12px; }
section.closing p { color: #e2e8f0; }
section.closing .contact-card {
  margin-top: 22px; background: rgba(255, 255, 255, 0.12); border: 1px solid rgba(255, 255, 255, 0.25);
  border-radius: 12px; padding: 18px 36px; font-size: 0.84em; line-height: 1.68; color: #f8fafc;
}

.two-col { display: grid; grid-template-columns: 1fr 1fr; gap: 18px; align-items: stretch; }
.three-col { display: grid; grid-template-columns: repeat(3, 1fr); gap: 14px; align-items: stretch; }
.split64 { display: grid; grid-template-columns: 56% 42%; gap: 2%; align-items: center; }
.split55 { display: grid; grid-template-columns: 49% 49%; gap: 2%; align-items: center; }

.card { background: #ffffff; border: 1px solid var(--slate-200); border-top: 3.5px solid var(--navy); border-radius: 8px; padding: 12px 16px; box-shadow: 0 2px 6px rgba(15, 23, 42, 0.05); box-sizing: border-box; }
.card.accent { border-top-color: var(--accent); }
.card.teal { border-top-color: var(--teal); }

.kpi-card { background: var(--slate-100); border: 1px solid var(--slate-200); border-left: 4px solid var(--navy); border-radius: 8px; padding: 10px 14px; box-sizing: border-box; }
.kpi-card.accent { border-left-color: var(--accent); background: var(--accent-soft); }
.kpi-card.teal { border-left-color: var(--teal); background: var(--teal-soft); }
.kpi-val { font-size: 1.32em; font-weight: 800; color: var(--navy); line-height: 1.15; margin-bottom: 3px; }
.kpi-card.accent .kpi-val { color: var(--accent); }
.kpi-card.teal .kpi-val { color: var(--teal); }
.kpi-label { font-size: 0.76em; color: var(--slate-700); line-height: 1.34; }

.callout { background: #f8fafc; border-left: 4px solid var(--accent); border-radius: 0 8px 8px 0; padding: 11px 16px; margin-top: 14px; font-size: 0.85em; color: var(--slate-700); line-height: 1.5; }
.callout.teal { border-left-color: var(--teal); background: var(--teal-soft); }
.callout strong { color: var(--navy); }

table { width: 100%; border-collapse: collapse; font-size: 0.74em; margin: 8px 0; background: #ffffff; border: 1px solid var(--slate-200); }
th { background: var(--navy); color: #ffffff; font-weight: 700; padding: 7px 10px; text-align: left; border: 1px solid var(--navy); }
td { padding: 6px 10px; border: 1px solid var(--slate-200); vertical-align: middle; line-height: 1.35; }
tr:nth-child(even) td { background: #f8fafc; }

.outline-grid { display: grid; grid-template-columns: 1fr 1fr; gap: 14px 24px; margin-top: 10px; }
.outline-item { display: flex; align-items: flex-start; gap: 12px; background: #f8fafc; border: 1px solid var(--slate-200); border-left: 4px solid var(--navy); border-radius: 8px; padding: 12px 16px; }
.outline-num { background: var(--navy); color: #ffffff; font-weight: 800; font-size: 0.85em; width: 28px; height: 28px; border-radius: 6px; display: flex; align-items: center; justify-content: center; flex-shrink: 0; margin-top: 2px; }
.outline-body { font-size: 0.85em; line-height: 1.38; }
.outline-body a { color: var(--navy); font-weight: 700; font-size: 1.04em; }

.fig-box { background: #ffffff; border: 1px solid var(--slate-200); border-radius: 8px; padding: 8px; text-align: center; box-shadow: 0 2px 6px rgba(15, 23, 42, 0.05); overflow: visible; position: relative; }
.fig-box img { max-width: 100%; height: auto; display: block; margin: 0 auto; border-radius: 4px; cursor: zoom-in; transition: transform 0.25s ease, box-shadow 0.25s ease; }
.fig-box.is-zoomed { z-index: 45; }
.fig-box img.is-zoomed { position: relative; z-index: 46; box-shadow: 0 18px 44px rgba(15, 23, 42, 0.30); background: #ffffff; }
.fig-cap { font-size: 0.72em; color: var(--slate-500); margin-top: 5px; font-weight: 500; }

.small-text { font-size: 0.82em; }
.pill { display: inline-block; background: var(--navy); color: #ffffff; font-size: 0.72em; font-weight: 700; padding: 2px 8px; border-radius: 4px; margin-right: 6px; vertical-align: middle; }
.pill.accent { background: var(--accent); }
.pill.teal { background: var(--teal); }

@media print { .lang-btn, .nav-dropdown { display: none !important; } }
</style>

<!-- _class: lead -->

<div class="badge">Journal of Software Engineering Studies (JSES) · Vol. 1, No. 1 · Sep 2006</div>

# Software Process Improvement at Feng Chia University: An Experience Report

<div class="subtitle">
A Two-Year <strong>CMMI<sup>®</sup>-SW/SS v1.1 Maturity Level 3</strong> Journey at the Office of Information Technology (OIT) and Its Dual Impact on <strong>Software Engineering Education</strong> in the Department of IECS
</div>

<div class="meta-box">
<strong>Nien-Lin Hsueh</strong><sup>1</sup>, <strong>Don-Lin Yang</strong><sup>2</sup>, <strong>Lu-Mei Wang</strong><sup>2</sup>, and <strong>Peng-Hua Chu</strong><sup>1</sup><br>
<sup>1</sup> Department of Information Engineering and Computer Science (IECS), Feng Chia University<br>
<sup>2</sup> Office of Information Technology (OIT), Feng Chia University, Taichung, Taiwan<br>
<code>nlhsueh@fcu.edu.tw</code> · <code>dlyang@fcu.edu.tw</code> · <code>lwang@fcuoa.fcu.edu.tw</code>
</div>

<div class="grant">
Published in JSES, Vol. 1, No. 1, pp. 34–40, September 2006 (Software Engineering Association of Taiwan). Supported by NSC Taiwan under Contract No. NSC94-2213-E-035-041.
</div>

<!--
Bibliographic & Research Overview:
This experience report by Nien-Lin Hsueh, Don-Lin Yang, Lu-Mei Wang, and Peng-Hua Chu (Feng Chia University, Taichung, Taiwan), published in the inaugural issue of the Journal of Software Engineering Studies (Vol. 1, No. 1, pp. 34 to 40, September 2006), documents a two-year CMMI-based Software Process Improvement (SPI) initiative at FCU's Office of Information Technology (OIT).

Historical & Institutional Context:
OIT originated as the Electronic Computer Center in July 1969, was renamed Information Center in August 1986, and was elevated to a major university office in 2001 responsible for campus IT policy and e-campus development. Starting on March 29, 2004, OIT adopted CMMI-SW/SS Version 1.1 under the IDEAL reference model and achieved Maturity Level 3 in January 2006.

Dual Research Contribution:
Unlike commercial SPI case studies focused solely on certification for contract acquisition, this paper highlights a unique university-wide synergy: six actionable SPI lessons tailored to a small IT organization maintaining over 130 campus systems, paired with four concrete transformations in undergraduate/graduate software engineering education and research within the Department of IECS.
-->

---

## Outline

<div class="outline-grid">
<div class="outline-item">
<div class="outline-num">1</div>
<div class="outline-body"><a href="#3">Motivation &amp; Campus IT Challenges</a><br>Growth to 100+ campus systems, maintenance crises, and the dual OIT–IECS mission.</div>
</div>
<div class="outline-item">
<div class="outline-num">2</div>
<div class="outline-body"><a href="#4">Vision, Core Values &amp; SPI Objectives</a><br>IDEAL<sup>SM</sup> Initiating phase and need-driven CMMI<sup>®</sup> objectives beyond appraisal badges.</div>
</div>
<div class="outline-item">
<div class="outline-num">3</div>
<div class="outline-body"><a href="#5">OIT Process Improvement &amp; 6 Lessons</a><br>Role-targeted training, 9 handbooks, parameterization, CM, maintenance, hybrid OOA/OOD, and tools.</div>
</div>
<div class="outline-item">
<div class="outline-num">4</div>
<div class="outline-body"><a href="#10">Influences on the Department of IECS</a><br>Test working group, real-world capstone projects, SE2004 curriculum, and SE research tools.</div>
</div>
<div class="outline-item">
<div class="outline-num">5</div>
<div class="outline-body"><a href="#13">Continuous Improvement &amp; Success Factors</a><br>Annual quality evaluations, CMMI + ISO integration, and three organizational enablers.</div>
</div>
<div class="outline-item">
<div class="outline-num">6</div>
<div class="outline-body"><a href="#14">Benefits, Reflections &amp; Takeaways</a><br>Measurable organizational gains, constraints of small IT units, and transferable lessons.</div>
</div>
</div>

<!--
Structural Map of the Paper:
Section 1 (Introduction, pp. 34 to 35) traces OIT's evolution since 1969 and catalogs six systemic software engineering problems that emerged once OIT's portfolio exceeded 100 production systems.
Section 2 (Process Improvement at OIT, pp. 35 to 38) presents seven subsections (2.1 through 2.7) covering organizational vision, training, process definition, project types, design methodology, process tools, and continuous improvement, distilling six numbered Lessons Learned (2.1 to 2.6).
Section 3 (Influences on the Department of IECS, pp. 38 to 39) details four academic spin-offs: the multi-tier Test Working Group (3.1), OIT-sponsored Capstone Projects (3.2), SE curriculum expansion aligned with SE2004 and Taiwan's SEC (3.3), and applied SE research tools (3.4).
Section 4 (Conclusion, pp. 39 to 40) synthesizes six organizational benefits and three core success factors.
-->

---

## 1. Motivation & Context: Scaling Past 100+ Campus Systems

<div class="three-col" style="margin-bottom: 12px;">
<div class="kpi-card">
<div class="kpi-val">1969 ➔ 2001</div>
<div class="kpi-label">Computer Center elevated to <strong>Office of IT (OIT)</strong> driving FCU's e-campus mission</div>
</div>
<div class="kpi-card accent">
<div class="kpi-val">130+ Systems</div>
<div class="kpi-label">Production campus systems under active OIT maintenance (100+ at SPI launch)</div>
</div>
<div class="kpi-card teal">
<div class="kpi-val">22 Months</div>
<div class="kpi-label">Mar 29, 2004 ➔ Jan 2006: achieved <strong>CMMI<sup>®</sup>-SW/SS v1.1 ML3</strong></div>
</div>
</div>

<div class="two-col">
<div class="card accent">
<h3>Six Pain Points Before SPI (2004)</h3>
<ul class="small-text">
<li><strong>Poor maintainability:</strong> constantly changing requirements with missing supporting documents.</li>
<li><strong>Schedule slippage:</strong> recurring project delays across campus units.</li>
<li><strong>Uncontrolled quality:</strong> faculty and student dissatisfaction with live systems.</li>
<li><strong>Inefficient HR utilization:</strong> ad-hoc workload distribution.</li>
<li><strong>Chaotic configuration:</strong> inconsistent versions, platforms, and systems.</li>
<li><strong>Requirement mismatch:</strong> user needs inaccurately elicited and delivered.</li>
</ul>
</div>
<div class="card teal">
<h3>Dual Mission: Operations + Education</h3>
<ul class="small-text">
<li><strong>Operational Goal (OIT):</strong> Establish predictable, productive software processes to deliver a personalized, integrated e-campus platform.</li>
<li><strong>Educational Goal (IECS):</strong> Leverage OIT's real CMMI<sup>®</sup> engineering environment to strengthen software engineering capability of IECS students.</li>
<li><strong>Broader Relevance:</strong> The six pain points are representative of university computer centers across Taiwan.</li>
</ul>
</div>
</div>

<!--
Problem Context & Institutional Scope:
Before March 2004, FCU's OIT had grown into the central IT organization responsible for building a personalized, integrated e-campus platform supporting teaching, learning, research, and administration. Once the maintained portfolio surpassed 100 systems (reaching over 130 systems by 2006), informal ad-hoc practices broke down across six dimensions: missing documentation under volatile requirements, chronic schedule delays, uncontrolled product quality, poor staff allocation, chaotic multi-version/multi-platform configuration management, and inaccurate user requirements.

Why CMMI-SW/SS v1.1?
OIT selected SEI's CMMI-SW/SS Version 1.1 (Software Engineering / Supplier Sourcing) to address both in-house development/maintenance and outsourced campus systems. Crucially, because OIT operates inside a university, leadership deliberately coupled operational process reform with curriculum and practical training reform in the Department of Information Engineering and Computer Science (IECS).
-->

---

## 2. Need-Driven Vision, Core Values & Process Objectives

Guided by SEI's **IDEAL<sup>SM</sup>** Initiating phase, OIT anchored its SPI plan to **organizational needs** rather than chasing an appraisal badge for external contracts.

<div class="two-col" style="margin-top: 8px;">
<div class="card">
<h3>Organizational Identity</h3>
<ul class="small-text">
<li><strong>Vision:</strong> Act as a key contributor to FCU's higher-education success via advanced IT services.</li>
<li><strong>Mission:</strong> Support IT needs for quality teaching, effective learning, research excellence, efficient administration, and community service.</li>
<li><strong>5 Core Values:</strong> Customer satisfaction, overriding commitment to quality, personal accountability, life-long learning, and teamwork.</li>
</ul>
</div>
<div class="card teal">
<h3>Five Concrete Process Objectives</h3>
<ol class="small-text">
<li><strong>On-time delivery</strong> aligned with university academic timeframes.</li>
<li><strong>Product quality improvement</strong> across campus systems.</li>
<li><strong>User friendliness</strong> through consistent UI design standards.</li>
<li><strong>Functional fitness</strong> meeting expected user requirements.</li>
<li><strong>Reliability gains:</strong> reduce <strong>MTTR</strong> (Mean Time to Repair) and increase <strong>MTBF</strong> (Mean Time Between Failure).</li>
</ol>
</div>
</div>

<div class="callout">
<strong>Self-Improving vs. Commercial SPI:</strong> Commercial firms often pursue CMMI<sup>®</sup> primarily to win contracts; as a university IT center, OIT treated <strong>actual organizational pain relief</strong> as the sole yardstick for process design.
</div>

<!--
IDEAL Model & Need-Driven Strategy (Section 2.1):
OIT adopted SEI's IDEAL model (Initiating, Diagnosing, Establishing, Acting, Leveraging; McFeeley, 1996) as its overarching SPI lifecycle. In the Initiating phase, identifying clear business drivers prevented CMMI adoption from devolving into bureaucratic paperwork.

Contrast with Commercial Contractors:
The authors explicitly note that commercial software vendors sometimes adopt CMMI instrumentally to qualify for government or enterprise bids, risking "compliance theater." Because OIT is an internal service unit serving FCU faculty and students, its five process objectives directly target operational reliability (MTTR reduction, MTBF increase), academic-calendar predictability, UI consistency across 130+ systems, and requirement fidelity.
-->

---

## 3. OIT SPI Roadmap: From Initiation to CMMI<sup>®</sup> ML3

<div class="fig-box" style="padding: 6px; margin-bottom: 8px;">
<img src="./img/spi_ideal_roadmap.svg" alt="FCU OIT CMMI-SW/SS v1.1 Improvement Journey" style="max-height: 365px;">
<div class="fig-cap">Synthesized roadmap of OIT's 22-month CMMI-SW/SS v1.1 improvement lifecycle and six lessons learned (Sections 2.1–2.7).</div>
</div>

<div class="callout teal" style="margin-top: 8px;">
<strong>End-to-End Coherence:</strong> Each stage resolved a concrete bottleneck discovered during pilot runs—moving from <strong>broad CMMI lectures</strong> to <strong>role-specific training</strong>, <strong>parameterized handbooks</strong>, <strong>dedicated maintenance plans</strong>, and <strong>in-house tooling</strong>.
</div>

<!--
Architectural Synthesis of Section 2:
This diagram integrates the five progressive phases of OIT's SPI effort described across Sections 2.1 through 2.7:
1. Initiating (2.1): Translating Vision, Mission, and Core Values into five measurable objectives.
2. Role-Targeted Training (2.2, Lesson 2.1): Pivoting from all-staff CMMI theory to targeted EPG, engineering, and PM tracks, followed by practice-focused process rollout training.
3. Standardized Process Definition (2.3, Lessons 2.2 and 2.3): Authoring 9 handbooks using a uniform 8-field practice schema, combined plans, Excel templates, and versioned Process Asset Library (PAL) control.
4. Reality-Aligned Tailoring & Tooling (2.4 to 2.6, Lessons 2.4 to 2.6): Separating semester-level Maintenance Plans for 130+ systems, adopting a pragmatic hybrid DFD+OOA/OOD methodology, and building 8 internal process tools.
5. ML3 Appraisal & Continuous Improvement (2.7): Annual quality reviews, ISO 9001 integration, agile maintenance refinement, and automated testing.
-->

---

## 3.1 Role-Targeted Training Strategy (Lesson 2.1)

<div class="two-col">
<div class="card accent">
<h3>Initial Pitfall: All-Staff CMMI<sup>®</sup> Training</h3>
<ul class="small-text">
<li>OIT initially taught CMMI<sup>®</sup> to <strong>all 4 sections</strong>: System Development, System Maintenance, Resource Management, and Technology Supporting.</li>
<li><strong>Problem 1 (What vs. How):</strong> CMMI<sup>®</sup> specifies <em>goals to satisfy</em>, not <em>how to achieve them</em>—offering little immediate help to non-EPG staff.</li>
<li><strong>Problem 2 (Cognitive Distance):</strong> Abstract CMMI<sup>®</sup> terminology was hard to grasp for support and operational personnel.</li>
</ul>
</div>
<div class="card teal">
<h3>Revised Strategy: "Knowledge to Those Who Use It"</h3>
<ul class="small-text">
<li><strong>EPG Members:</strong> CMMI<sup>®</sup> specifications &amp; Personal Software Process (PSP).</li>
<li><strong>Software Engineers:</strong> Requirements Engineering, OO methodology, Software Testing, CM &amp; testing tools.</li>
<li><strong>Project Leaders:</strong> PMP<sup>®</sup> &amp; Function Point (FP) estimation.</li>
<li><strong>Round-2 Rollout Training:</strong> Once EPG defined the 9 handbooks, staff were trained on <em>practical procedures</em>—not CMMI<sup>®</sup> clauses.</li>
</ul>
</div>
</div>

<div class="callout">
<strong>Lesson Learned 2.1:</strong> Provide CMMI<sup>®</sup> specification training <strong>only to EPG members</strong> at SPI launch, rather than to the entire organization; train general staff on concrete organizational practices once defined.
</div>

<!--
Training Evolution (Section 2.2):
OIT's training curriculum spanned four domains: Engineering (requirements engineering, OO development, software testing), Management (PMP, function point estimation), Process (PSP, CMMI), and Tools (configuration management, project management, testing tools).

Why the Pivot Mattered:
Teaching raw CMMI model specifications to non-EPG staff across all four OIT sections created frustration because CMMI is a descriptive capability model rather than a prescriptive work instruction. By restricting deep CMMI training to the Engineering Process Group (EPG) and giving engineers/managers domain-relevant skills first, OIT reduced resistance. After EPG authored the concrete organizational processes, a second wave of hands-on training taught staff how to execute OIT's own procedures without exposing them to raw CMMI jargon.
-->

---

## 3.2 Process Definition: 9 Handbooks & Parameterization (Lessons 2.2–2.3)

OIT authored **9 Process Handbooks** (each structured as `Handbook ➔ Procedures ➔ Practices ➔ Tasks`), with every procedure illustrated as a **flowchart** and every practice standardized into an **8-field schema**.

<div class="split55" style="margin-top: 6px;">
<div>

| Schema Field | Purpose in Every Practice |
| :--- | :--- |
| **OWNER / ROLE** | Maintaining role &amp; participating roles |
| **DESCRIPTION** | Concise scope and purpose of the practice |
| **ENTRY / EXIT** | Preconditions &amp; postconditions for gating |
| **INPUT / OUTPUT** | Required &amp; generated/revised work products |
| **ASSETS / REF** | Links to templates/guides in the **PAL** |
| **TASKS &amp; MEASURES** | Step-by-step tasks &amp; linked process metrics |

</div>
<div class="card teal">
<h3>Small-Org Optimization (Lesson 2.3)</h3>
<ul class="small-text">
<li><strong>Process Combination:</strong> Merged Project Plan + Configuration Management Plan into one <strong>integrated, parameterizable template</strong> (eliminating per-project CM policy rewriting).</li>
<li><strong>Spreadsheet Automation:</strong> Adopted <strong>Excel</strong> templates for size estimation and process/product metrics to minimize calculation overhead.</li>
<li><strong>Lesson 2.2:</strong> Consistent 8-field format + high-level graphical models streamline EPG communication and staff onboarding.</li>
</ul>
</div>
</div>

<!--
Process Architecture & Small-Organization Tailoring (Section 2.3):
Drawing on Humphrey (1989), Fuggetta (2000), Guerrero & Eterovic (2004), and Russ & McGregor (2000), OIT addressed the classic small-organization SPI dilemma: heavyweight enterprise documentation cripples small teams.
1. Uniform Practice Structure (Lesson 2.2): For example, the Engineering handbook covers product development, V&V, requirements management, and software maintenance. Standardizing every practice around Owner, Description, Entry/Exit Criteria, Input/Output, Role, Assets/Reference (stored in the Process Asset Library, PAL), Tasks, and Measures ensures unambiguous answers to who does what, under what gating condition, with what artifacts, and how it is measured.
2. Combination & Parameterization (Lesson 2.3): Rather than forcing project managers to author separate Project Plans and CM Plans from scratch, common boilerplate is abstracted into a parameterized template where PMs fill only project-specific parameters. Excel worksheets automate metrics and size calculations.
-->

---

## 3.3 Configuration Management of Process Assets

<div class="split64">
<div>
<ul class="small-text">
<li><strong>Cascading Change Risk:</strong> During active SPI, process handbooks and work-product templates evolve frequently and cross-reference one another.</li>
<li><strong>Impact Propagation:</strong> A single revision to <code>Process Handbook P1</code> can invalidate its own <strong>Template T</strong>, <strong>Checklist C</strong>, and <strong>Worksheet W</strong>, while triggering cascading updates in dependent handbooks such as <code>P2</code>.</li>
<li><strong>OIT's Lightweight Solution:</strong>
  <ul>
  <li>Enforce strict <strong>version identification</strong> across all PAL artifacts.</li>
  <li>Embed a standardized <strong>revision history header</strong> at the top of every handbook, template, checklist, and worksheet.</li>
  </ul>
</li>
</ul>
<div class="callout teal" style="margin-top: 10px;">
<strong>Governance Principle:</strong> Treat process assets themselves as configuration items—otherwise process drift silently breaks auditability and staff trust.
</div>
</div>
<div class="fig-box">
<img src="./img/fig1_cm_handbook.png" alt="Figure 1: Configuration Management of a Process Handbook" style="max-height: 360px;">
<div class="fig-cap">Figure 1 (Paper p. 37): Dependency propagation when Process Handbook P1 changes.</div>
</div>
</div>

<!--
Configuration Management of Process Handbooks (Section 2.3, Figure 1):
In early SPI iterations, organizations often apply Configuration Management (CM) only to application source code while overlooking the process documentation itself. Figure 1 illustrates why process CM is critical: handbooks are not standalone documents—each handbook (e.g., P1) binds specific templates (T), checklists (C), and worksheets (W) and references peer handbooks (e.g., P2). Uncontrolled edits create mismatches between checklists and procedures, causing failed peer reviews and inconsistent QA audits. OIT resolved this by assigning formal version IDs and maintaining an explicit revision history block at the header of every process artifact stored in the Process Asset Library (PAL).
-->

---

## 3.4 Tailoring to Reality: Maintenance, Hybrid Design & In-House Tools

<div class="three-col">
<div class="card">
<h3><span class="pill">L2.4</span> Maintenance Projects</h3>
<ul class="small-text">
<li>3 project types: <strong>New/Enhancement</strong>, <strong>Maintenance</strong>, <strong>Outsourcing</strong>.</li>
<li><strong>Pilot Failure:</strong> Version-1 planning targeted new projects and proved unworkable for <strong>130+ maintained systems</strong>.</li>
<li><strong>Fix:</strong> Aggregate all systems into a <strong>semester-level Maintenance Plan</strong> + dedicated <strong>Service Request System</strong>.</li>
</ul>
</div>
<div class="card teal">
<h3><span class="pill teal">L2.5</span> Hybrid Methodology</h3>
<ul class="small-text">
<li>PowerDesigner dropped DFD, pushing OIT toward pure OO (Use Case, Class, Sequence, State diagrams in SDD).</li>
<li><strong>Reality Check:</strong> Engineers knew DFD well, and most OIT apps are <strong>database systems</strong> where pure OO yields limited payoff.</li>
<li><strong>Fix:</strong> Multi-discipline <strong>DFD + OOA</strong> in analysis, <strong>OOD</strong> in design.</li>
</ul>
</div>
<div class="card accent">
<h3><span class="pill accent">L2.6</span> 8 In-House Tools</h3>
<ul class="small-text">
<li>Commercial tools rarely match tailored organizational workflows.</li>
<li>OIT built <strong>8 internal tools</strong>: Project Mgmt, PAL, Service Request, Impact Analysis, HR, Supplier Info, Source Version Control, and QA Checklist systems.</li>
<li>Lowers daily process friction and sustains adoption.</li>
</ul>
</div>
</div>

<div class="callout" style="margin-top: 12px;">
<strong>Pragmatic Engineering Takeaway:</strong> Never force-fit a textbook lifecycle, pure methodology, or off-the-shelf tool—<strong>pilot early</strong> and tailor processes to the organization's actual project mix and staff expertise.
</div>

<!--
Lessons Learned 2.4, 2.5, and 2.6 (Sections 2.4 to 2.6):
1. Maintenance vs. New Development (Section 2.4, Lesson 2.4): Because OIT maintains over 130 campus systems, creating an individual full-scale project plan for every small maintenance request was unsustainable. After the version-one pilot failed on maintenance work, OIT redesigned maintenance as an aggregated semester-level Maintenance Plan (defining planned requirements, system ownership, and schedules at semester start) backed by a Service Request System for intake and impact tracking.
2. Methodology Fit (Section 2.5, Lesson 2.5): Process definition must align with artifact templates (such as the Software Design Document, SDD) and engineering methods. While OIT adopted UML diagrams (use case, class, sequence, state) for OOD, retaining Data Flow Diagrams (DFD) alongside OOA during analysis leveraged existing engineer fluency and suited data-centric university information systems.
3. Custom Process Tooling (Section 2.6, Lesson 2.6): Building eight lightweight web/internal tools—especially PAL, Service Request, Impact Analysis, and QA Checklist systems—made CMMI compliance part of daily workflow rather than an administrative afterthought.
-->

---

## 4. Dual Impact: OIT–IECS Educational & Research Synergy

<div class="fig-box" style="padding: 6px; margin-bottom: 8px;">
<img src="./img/spi_dual_impact.svg" alt="OIT and Department of IECS Dual-Benefit Ecosystem" style="max-height: 365px;">
<div class="fig-cap">Four-pillar synergy transferring OIT's CMMI ML3 engineering practice into IECS teaching, capstone projects, and SE research (Section 3).</div>
</div>

<div class="callout teal" style="margin-top: 8px;">
<strong>Core Educational Insight:</strong> Graduates who experience real CMMI<sup>®</sup> engineering discipline inside campus IT projects enter industry knowing <em>what a healthy software process looks like</em>.
</div>

<!--
Institutional Synergy Between OIT and IECS (Section 3):
A defining contribution of this paper is demonstrating how a university's operational IT center can serve as a living software engineering laboratory for its Computer Science department. Rather than treating OIT's CMMI ML3 achievement as an isolated administrative milestone, FCU created a bidirectional feedback loop: OIT supplies authentic production projects, real faculty/student users, and rigorous CMMI standards, while IECS supplies testing manpower, capstone teams, modernized SE courses, and custom research prototypes (UML process V&V, sequential-pattern gap analysis, and PSP-assistant).
-->

---

## 4.1 IECS Test Working Group & OIT Collaboration

<div class="split55">
<div>
<div class="card teal" style="margin-bottom: 10px;">
<h3>Multi-Tier Student Testing Model</h3>
<ul class="small-text">
<li><strong>PhD &amp; Master's Students:</strong> Communicate directly with OIT developers to author the <strong>Test Plan</strong> and <strong>Test Design</strong> from Requirement &amp; Design Specifications.</li>
<li><strong>Undergraduate Students:</strong> Construct executable <strong>test cases</strong> using testing tools once test design is confirmed.</li>
<li><strong>OIT &amp; Users:</strong> Execute <strong>System Test</strong> and campus <strong>Acceptance Test</strong>.</li>
</ul>
</div>
<div class="card">
<h3>Threefold Benefits</h3>
<ol class="small-text">
<li><strong>Relieves OIT bottleneck:</strong> augments limited staff testing capacity.</li>
<li><strong>Authentic skill building:</strong> students practice testing on live campus systems.</li>
<li><strong>Reusable regression DB:</strong> builds a long-term test case repository for university IS.</li>
</ol>
</div>
</div>
<div class="fig-box">
<img src="./img/fig2_oit_iecs.png" alt="Figure 2: Cooperation between OIT and the Department of IECS" style="max-height: 410px;">
<div class="fig-cap">Figure 2 (Paper p. 38): Cross-lane V-model testing workflow across Faculty/Student, OIT, and IECS.</div>
</div>
</div>

<!--
OIT-IECS Test Working Group (Section 3.1, Figure 2):
Figure 2 depicts a three-swimlane collaboration across Faculty/Student, OIT, and IECS that mirrors a structured V-model handoff:
- OIT produces the Requirement Specification, which flows into a jointly confirmed Test Plan with IECS graduate students.
- OIT produces the Design Specification, enabling IECS graduate students to create the Test Design.
- IECS undergraduate students then implement concrete test cases using automated/structured testing tools.
- Those test cases return to OIT for System Testing, culminating in Acceptance Testing by FCU faculty and students.
This hierarchical division of labor solves two chronic problems simultaneously: OIT's lack of dedicated QA staffing and students' lack of exposure to real-world verification artifacts and regression test repositories.
-->

---

## 4.2 Capstone Projects, SE2004 Curriculum & SE Research

<div class="three-col">
<div class="card">
<h3>Capstone Reform (3.2)</h3>
<ul class="small-text">
<li><strong>Old flaws:</strong> toy projects without real users, or ad-hoc industry projects teaching <em>"chaos is normal."</em></li>
<li><strong>OIT Partnership:</strong> <strong>5–10 real projects/year</strong> for qualified IECS students.</li>
<li><strong>SE Interest Group:</strong> applies CMMI<sup>®</sup> Project Plan, CM, and RD to capstones.</li>
</ul>
</div>
<div class="card teal">
<h3>Curriculum Expansion (3.3)</h3>
<ul class="small-text">
<li>Aligned with <strong>SE2004</strong> &amp; Taiwan's <strong>SEC</strong> (beyond broad SA &amp; SE surveys).</li>
<li><strong>4 New Courses (2004–06):</strong> PSP, Component-Based SE, Intro to CMMI<sup>®</sup>, Formal Methods.</li>
<li><strong>3 Planned (2007 S2):</strong> Software Project Mgmt, Software Quality, SOA.</li>
</ul>
</div>
<div class="card accent">
<h3>Applied SE Research (3.4)</h3>
<ul class="small-text">
<li>OIT's real process artifacts sparked three concrete research tools:
  <ul>
  <li><strong>UML-based Process</strong> definition &amp; V&amp;V tool.</li>
  <li><strong>Light-weight Mining</strong> process gap analysis (ICS 2006).</li>
  <li><strong>PSP-Assistant</strong> tool supporting PSP courses.</li>
  </ul>
</li>
</ul>
</div>
</div>

<div class="callout" style="margin-top: 12px;">
<strong>Breaking the "Chaotic Industry" Myth:</strong> Embedding students inside a CMMI<sup>®</sup> ML3 campus IT unit counters the misconception that real-world software engineering skips planning, requirements, and configuration control.
</div>

<!--
Educational & Research Outcomes (Sections 3.2 to 3.4):
1. Capstone Projects (3.2): Traditional capstones suffer from either artificial toy scopes (no real users challenging quality) or unmanaged external projects that inadvertently teach students that chaotic hacking is standard industry practice. OIT remedies both by supplying 5 to 10 authentic campus projects annually to students who pass a qualification test, supported by an IECS Software Engineering Interest Group focused on CMMI-aligned project planning, configuration management, and requirements development.
2. Curriculum Reform (3.3): Previously, IECS offered only broad undergraduate "System Analysis" and "Software Engineering" courses with limited hands-on depth. Guided by IEEE/ACM SE2004 and Taiwan's Software Engineering Consortium (SEC), IECS launched four new courses (PSP, CBSE, Introduction to CMMI, Formal Methods) and scheduled three additional courses for Spring 2007 (Software Project Management, Software Quality, and Service-Oriented Architecture).
3. Research Spin-offs (3.4): Practical challenges at OIT directly motivated peer-reviewed SE research, including a UML-based process V&V tool, a sequential-pattern-mining lightweight CMMI gap analysis method (Hsueh et al., ICS 2006), and the PSP-Assistant tool (Shen, Hsueh, & Chu, SERP 2006).
-->

---

## 5. Continuous Improvement & Three Critical Success Factors

<div class="two-col">
<div class="card teal">
<h3>Annual Quality Evaluation &amp; 3 Next Actions (2.7)</h3>
<p class="small-text">Every year, OIT audits <strong>estimation predictability</strong>, <strong>product quality</strong>, <strong>UI design capability</strong>, <strong>requirement elicitation</strong>, and <strong>review efficiency</strong>.</p>
<ol class="small-text">
<li><strong>CMMI<sup>®</sup> + ISO Integration:</strong> Unify CMMI<sup>®</sup> ML3 processes with OIT's existing <strong>ISO 9001:2000</strong> quality standards.</li>
<li><strong>Agile Maintenance Refinement:</strong> Streamline maintenance processes for higher responsiveness across 130+ systems.</li>
<li><strong>Broader Automation:</strong> Expand automated testing and process-efficiency tools.</li>
</ol>
</div>
<div class="card accent">
<h3>Three Critical Success Factors (Section 4)</h3>
<ul class="small-text">
<li><strong>1. Full Management Support:</strong> Unwavering commitment and resource backing from both FCU's President and OIT's Director from day one.</li>
<li><strong>2. Learning Culture:</strong> OIT developers proactively embraced software engineering knowledge and continuous skill growth.</li>
<li><strong>3. Common Consensus via Weekly EPG:</strong> Because OIT is a small organization, nearly all developers participated in weekly EPG meetings—examining cross-process interactions and reaching consensus rapidly.</li>
</ul>
</div>
</div>

<div class="callout">
<strong>Most Valuable Lesson After Two Years:</strong> Achieving Maturity Level 3 is a milestone, not a finish line—institutionalizing <strong>annual self-evaluation and continuous improvement</strong> is the highest-leverage outcome of SPI.
</div>

<!--
Sustaining SPI Beyond ML3 Appraisal (Sections 2.7 and 4):
OIT had already implemented ISO 9001:2000 in 2003 before starting CMMI in 2004; hence, harmonizing CMMI and ISO frameworks became a top priority post-2006 to avoid dual-audit overhead. Equally important is refining maintenance agility and deploying automated testing tools.

Why OIT Succeeded Where Many Small Units Stall:
The paper highlights three organizational enablers: (1) visible top-down sponsorship from FCU's President and OIT leadership; (2) an academic learning culture where engineers welcomed SE training; and (3) high-participation governance—because OIT was compact enough to involve almost all developers in weekly EPG discussions, process interactions were vetted collaboratively rather than imposed top-down.
-->

---

## 6. Summary of Benefits, Reflections & Takeaways

<div class="two-col">
<div class="card">
<h3>Six Organizational Benefits Achieved</h3>
<ol class="small-text">
<li>Established a <strong>standard organizational process set</strong> (9 handbooks + PAL).</li>
<li><strong>Re-organized human resources</strong> to optimize efficiency.</li>
<li>Improved <strong>product quality and productivity</strong>.</li>
<li>Delivered <strong>expected functionality on schedule</strong>.</li>
<li>Systematically managed <strong>technical documentation</strong> and assured <strong>outsourcing quality</strong>.</li>
<li>Built a lasting <strong>OIT–IECS cooperation ecosystem</strong>.</li>
</ol>
</div>
<div class="card teal">
<h3>Reflections &amp; Scope Boundaries</h3>
<ul class="small-text">
<li><strong>Experience-Report Scope:</strong> Reports qualitative organizational outcomes and lessons rather than formal before/after defect or MTTR statistical benchmarks.</li>
<li><strong>Small-Org Transferability:</strong> Weekly all-developer EPG consensus works best in compact teams; larger units require layered governance.</li>
<li><strong>Transferable Blueprint:</strong> Any university IT center can pair CMMI<sup>®</sup>-based SPI with CS/SE departments for mutual operational and educational gain.</li>
</ul>
</div>
</div>

<div class="callout teal" style="margin-top: 12px;">
<strong>Core Takeaway:</strong> Process improvement succeeds when it is <strong>need-driven</strong>, <strong>parameterized for small teams</strong>, <strong>tailored to maintenance reality</strong>, and <strong>amplified through university-wide learning</strong>.
</div>

<!--
Critical Synthesis & Research Limitations:
This experience report provides rich, practitioner-grounded evidence on adopting CMMI-SW/SS v1.1 in a non-commercial university IT organization. Its six reported benefits span process standardization, HR efficiency, product quality/productivity, schedule reliability, technical document and outsourcing governance, and OIT-IECS collaboration.

Methodological Reflection:
As an experience report published shortly after the January 2006 ML3 appraisal, the paper does not report longitudinal quantitative defect-density or MTTR/MTBF time-series datasets—those metrics were being institutionalized through OIT's annual quality evaluations. Nevertheless, the six concrete lessons (Lessons 2.1 through 2.6) and the four-pillar OIT-IECS educational integration offer a highly practical, replicable blueprint for university IT centers and small-to-medium software organizations worldwide.
-->

---

<!-- _class: closing -->

# Thank You & Questions

<p style="font-size: 1.02em; max-width: 780px;">
Need-Driven CMMI<sup>®</sup> Process Improvement · Six Practical Lessons · OIT–IECS Educational Synergy
</p>

<div class="contact-card">
<strong>Nien-Lin Hsueh</strong> &nbsp;·&nbsp; <code>nlhsueh@fcu.edu.tw</code> &nbsp;|&nbsp; <strong>Don-Lin Yang</strong> &nbsp;·&nbsp; <code>dlyang@fcu.edu.tw</code><br>
<strong>Lu-Mei Wang</strong> &nbsp;·&nbsp; <code>lwang@fcuoa.fcu.edu.tw</code> &nbsp;|&nbsp; <strong>Peng-Hua Chu</strong><br>
Department of IECS &amp; Office of Information Technology, Feng Chia University, Taichung, Taiwan<br>
<span style="font-size: 0.85em; opacity: 0.88;">Journal of Software Engineering Studies (JSES), Vol. 1, No. 1, pp. 34–40, September 2006 · NSC94-2213-E-035-041</span>
</div>

<!--
Reference & Archival Metadata:
- Title: Software Process Improvement at Feng Chia University: An Experience Report
- Authors: Nien-Lin Hsueh (Dept. of IECS, FCU), Don-Lin Yang (OIT / Dept. of IECS, FCU), Lu-Mei Wang (OIT, FCU), Peng-Hua Chu (Dept. of IECS, FCU)
- Venue: Journal of Software Engineering Studies, Vol. 1, No. 1, pp. 34 to 40, September 2006, Software Engineering Association of Taiwan
- Funding: National Science Council, Taiwan, Contract No. NSC94-2213-E-035-041
- Acknowledgments: Jessie Lee and Christine Lee of ProVision for their assistance on the CMMI improvement project.
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

document.addEventListener('click', (e) => {
  const langBtn = e.target.closest('.lang-btn');
  if (!langBtn) return;
  e.preventDefault();
  const target = langBtn.getAttribute('href');
  if (target) window.location.href = target + (window.location.hash || '');
});
</script>
