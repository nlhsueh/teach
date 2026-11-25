---
marp: true
theme: gaia
size: 16:9
paginate: true
html: true
header: '<div class="hdr-wrap"><span class="hdr-title">University Timetabling through Conceptual Modeling (TBCG)</span><div class="hdr-actions"><a class="lang-btn" href="./Timetabling_slide_zh.html" title="切換至繁體中文簡報">🌐 繁</a><div class="nav-dropdown"><button class="nav-btn">Sections ▾</button><div class="nav-menu"><a href="#2">Outline</a><a href="#3">1. Motivation &amp; Challenges</a><a href="#4">2. Related Work</a><a href="#5">3. Problem &amp; Constraints</a><a href="#6">4. TBCG Modeling</a><a href="#10">5. Blackboard &amp; CLIPS</a><a href="#13">6. NCU System &amp; Conclusions</a></div></div></div></div>'
footer: 'Jonathan Lee, Shang-Pin Ma, Lien Fu Lai, Nien Lin Hsueh & Yong-Yi Fanjiang · IJIS 2005'
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
  top: 0; left: 0; right: 0;
  height: 44px; padding: 0 54px;
  background: var(--navy); color: #ffffff;
  font-size: 13.5px; font-weight: 600;
  display: flex; align-items: center;
  box-sizing: border-box; overflow: visible !important; z-index: 50;
}

.hdr-wrap { width: 100%; display: flex; justify-content: space-between; align-items: center; }
.hdr-title { letter-spacing: 0.01em; opacity: 0.94; }
.hdr-actions { display: inline-flex; align-items: center; gap: 8px; }

.lang-btn {
  background: rgba(255, 255, 255, 0.14); color: #ffffff !important;
  border: 1px solid rgba(255, 255, 255, 0.28); border-radius: 6px;
  padding: 3px 10px; font-size: 12px; font-weight: 600;
  text-decoration: none !important; cursor: pointer;
  display: inline-flex; align-items: center; gap: 4px; line-height: 1.35;
  transition: background 0.15s ease;
}
.lang-btn:hover { background: rgba(255, 255, 255, 0.26); text-decoration: none !important; }

.nav-dropdown { position: relative; display: inline-block; padding-bottom: 6px; margin-bottom: -6px; }
.nav-btn {
  background: rgba(255, 255, 255, 0.14); color: #ffffff;
  border: 1px solid rgba(255, 255, 255, 0.28); border-radius: 6px;
  padding: 3px 10px; font-size: 12px; font-weight: 600; cursor: pointer; font-family: inherit;
}
.nav-menu {
  display: none; position: absolute; right: 0; top: 100%; min-width: 235px;
  background: #ffffff; border: 1px solid var(--slate-200); border-radius: 8px;
  box-shadow: 0 10px 24px rgba(15, 23, 42, 0.18); padding: 6px 0; z-index: 200;
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
  background: transparent !important; border: none !important; padding: 0 !important;
  font-family: 'JetBrains Mono', monospace; font-size: 0.9em; font-weight: 600; color: #475569;
}
h1 code, h2 code, h3 code { color: #0b3c5d; }
section table th { background: var(--navy) !important; color: #ffffff !important; }
section table th strong, section table th code { color: #ffffff !important; }
section.lead strong, section.closing strong { color: #ffffff !important; }
section.lead code, section.closing code { color: #bae6fd !important; }

section.lead {
  background: linear-gradient(135deg, #102442 0%, #1b365d 62%, #294c7a 100%);
  color: #ffffff; display: flex; flex-direction: column; justify-content: center; padding: 54px 72px;
}
section.lead header, section.lead footer, section.lead::after { display: none !important; }
section.lead .badge {
  display: inline-block; align-self: flex-start;
  background: rgba(255, 255, 255, 0.14); border: 1px solid rgba(255, 255, 255, 0.32);
  color: #f8fafc; font-size: 0.72em; font-weight: 600; letter-spacing: 0.06em;
  text-transform: uppercase; padding: 5px 14px; border-radius: 999px; margin-bottom: 18px;
}
section.lead h1 { color: #ffffff; font-size: 2.02em; font-weight: 800; line-height: 1.24; margin-bottom: 16px; text-align: left; }
section.lead .subtitle { color: #cbd5e1; font-size: 0.94em; line-height: 1.5; margin-bottom: 24px; max-width: 960px; }
section.lead .meta-box { border-left: 4px solid #f43f5e; padding-left: 18px; color: #e2e8f0; font-size: 0.82em; line-height: 1.56; }
section.lead .grant { margin-top: 20px; font-size: 0.72em; color: #94a3b8; }

section.closing {
  background: linear-gradient(135deg, #102442 0%, #1b365d 65%, #8c1d40 100%);
  color: #ffffff; display: flex; flex-direction: column; justify-content: center; align-items: center; text-align: center; padding: 54px 72px;
}
section.closing header, section.closing footer, section.closing::after { display: none !important; }
section.closing h1 { color: #ffffff; font-size: 2.2em; margin-bottom: 12px; }
section.closing p { color: #e2e8f0; }
section.closing .contact-card {
  margin-top: 22px; background: rgba(255, 255, 255, 0.12); border: 1px solid rgba(255, 255, 255, 0.25);
  border-radius: 12px; padding: 18px 36px; font-size: 0.82em; line-height: 1.66; color: #f8fafc;
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
.kpi-val { font-size: 1.3em; font-weight: 800; color: var(--navy); line-height: 1.15; margin-bottom: 3px; }
.kpi-card.accent .kpi-val { color: var(--accent); }
.kpi-card.teal .kpi-val { color: var(--teal); }
.kpi-label { font-size: 0.76em; color: var(--slate-700); line-height: 1.34; }

.callout { background: #f8fafc; border-left: 4px solid var(--accent); border-radius: 0 8px 8px 0; padding: 11px 16px; margin-top: 12px; font-size: 0.85em; color: var(--slate-700); line-height: 1.5; }
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

@media print { .lang-btn, .nav-dropdown { display: none !important; } }
</style>

<!-- _class: lead -->

<div class="badge">International Journal of Intelligent Systems (IJIS) · Vol. 20 · 2005</div>

# University Timetabling through Conceptual Modeling

<div class="subtitle">
Automated Software Engineering for Course Timetabling via <strong>Task-Based Conceptual Graphs (TBCG)</strong>, <strong>Blackboard Synthesis</strong>, and <strong>Executable CLIPS Expert Systems</strong>
</div>

<div class="meta-box">
<strong>Jonathan Lee</strong><sup>1</sup>, <strong>Shang-Pin Ma</strong><sup>1</sup>, <strong>Lien Fu Lai</strong><sup>2</sup>, <strong>Nien Lin Hsueh</strong><sup>3</sup>, and <strong>Yong-Yi Fanjiang</strong><sup>4</sup><br>
<sup>1</sup> Dept. of CSIE, National Central University &nbsp;·&nbsp; <sup>2</sup> Dept. of CSIE, National Changhua University of Education<br>
<sup>3</sup> Dept. of IECS, Feng Chia University &nbsp;·&nbsp; <sup>4</sup> Dept. of CIS, National Taichung University<br>
<code>yjlee@selab.csie.ncu.edu.tw</code> · <code>nlhsueh@fcu.edu.tw</code>
</div>

<div class="grant">
Published in International Journal of Intelligent Systems, Vol. 20, pp. 1137–1160 (2005), Wiley Periodicals, Inc. · DOI: 10.1002/int.20115 · Supported by NSC92-2213-E-008-001.
</div>

<!--
Bibliographic & Research Overview:
This journal article by Jonathan Lee, Shang-Pin Ma, Lien Fu Lai, Nien Lin Hsueh, and Yong-Yi Fanjiang, published in the International Journal of Intelligent Systems (Vol. 20, pp. 1137 to 1160, 2005; DOI 10.1002/int.20115), introduces an automated software engineering methodology—Task-Based Conceptual Graphs (TBCG)—to solve university course timetabling.

Core Thesis:
Rather than hard-coding scheduling algorithms whose logic becomes brittle whenever institutional rules change, TBCG models timetabling specifications graphically and formally across four views (Domain, State, Functional, and Behavioral models). After verifying consistency, a six-level Blackboard system automatically translates TBCG specifications into an executable CLIPS expert system and Oracle object-relational database schemas, allowing maintenance and constraint changes to be performed directly at the specification level.
-->

---

## Outline

<div class="outline-grid">
<div class="outline-item">
<div class="outline-num">1</div>
<div class="outline-body"><a href="#3">Motivation &amp; Four Timetabling Challenges</a><br>Why institutional variability demands specification-level maintenance and constraint relaxation.</div>
</div>
<div class="outline-item">
<div class="outline-num">2</div>
<div class="outline-body"><a href="#4">Related Work: OR, HMI &amp; AI Paradigms</a><br>Comparative synthesis of Operations Research, Human-Machine Interaction, and AI methods.</div>
</div>
<div class="outline-item">
<div class="outline-num">3</div>
<div class="outline-body"><a href="#5">NCU Problem Statement &amp; 7 Constraints</a><br>Three stakeholders, 5 hard constraints (C<sub>0</sub>), 2 soft constraints, and NCU CSIE scale.</div>
</div>
<div class="outline-item">
<div class="outline-num">4</div>
<div class="outline-body"><a href="#6">TBCG Conceptual Modeling &amp; Tasks</a><br>TBSM + Conceptual Graphs, actors, demons, constraint overlays, and NCU task hierarchy.</div>
</div>
<div class="outline-item">
<div class="outline-num">5</div>
<div class="outline-body"><a href="#10">Operationalizing TBCG via Blackboard</a><br>Five knowledge sources translating 4 views into CLIPS modules, rules, and Oracle schemas.</div>
</div>
<div class="outline-item">
<div class="outline-num">6</div>
<div class="outline-body"><a href="#13">NCU System, Discussion &amp; Takeaways</a><br>Multi-department Java + CLIPS + Oracle deployment, maintenance benefits, and limitations.</div>
</div>
</div>

<!--
Structural Map of the Paper:
Section 1 (Introduction, pp. 1137 to 1139) defines timetabling and identifies four enduring engineering challenges.
Section 2 (Related Work, pp. 1139 to 1141) surveys 30 years of timetabling research across Operations Research (sequential, cluster, meta-heuristic), Human-Machine Interaction, and Artificial Intelligence (constraint programming, expert systems, neural networks).
Section 3 (Problem Statements, pp. 1141 to 1142) specifies the university course timetabling problem at National Central University (NCU) CSIE with 3 actors and 7 constraints.
Section 4 (Conceptual Modeling through TBCG, pp. 1143 to 1155) formalizes TBSM in Conceptual Graphs (4.1) and details operationalization into CLIPS via a Blackboard architecture (4.2).
Section 5 (NCU Timetabling System, pp. 1155 to 1158) demonstrates generated Oracle schemas (5.1) and CLIPS knowledge base rules (5.2).
Section 6 (Conclusion, p. 1158) summarizes architectural advantages.
-->

---

## 1. Motivation: Four Enduring Challenges in Timetabling

Timetabling assigns events/courses to **timeslots**, **classrooms**, and **instructors** while satisfying institutional constraints. Despite 30+ years of research, four software engineering gaps persist:

<div class="two-col" style="margin-top: 8px;">
<div class="card accent">
<h3>1. Frequent Reformulation &amp; Change</h3>
<p class="small-text">Institutional rules vary widely across universities and semesters; small policy tweaks cause complex ripple effects if maintained in source code.</p>
<h3 style="margin-top: 10px;">2. Lack of a Generalized Framework</h3>
<p class="small-text">Bespoke schedulers are slow and costly to build; a reusable methodology is needed across diverse timetabling domains.</p>
</div>
<div class="card teal">
<h3>3. Incorporating Human Expertise</h3>
<p class="small-text">Capturing administrative heuristics is hard, yet domain knowledge is vital to prune the search space and fit real-world context.</p>
<h3 style="margin-top: 10px;">4. Hard vs. Soft Constraint Relaxation</h3>
<p class="small-text">Real timetables aim for a <strong>feasible solution</strong> satisfying <em>all hard constraints</em> and <em>as many soft constraints as possible</em> via relaxation.</p>
</div>
</div>

<div class="callout">
<strong>Key Insight (TBCG):</strong> Treat timetabling as an <strong>executable conceptual specification</strong> problem—maintain constraints and tasks at the readable specification level, and <strong>auto-generate</strong> the executable expert system.
</div>

<!--
Engineering Motivation (Section 1):
Following Gunadhi et al. (1996), the paper explicitly scopes the university course timetabling problem with three practical assumptions: (1) students are already assigned or select classes themselves; (2) constraints partition cleanly into hard (mandatory) vs. soft (desirable); and (3) the practical objective is finding a feasible timetable satisfying all hard constraints and maximizing soft constraint satisfaction, rather than optimizing a single rigid mathematical objective function.

Why Automated Software Engineering Matters:
In conventional timetabling implementations, adding or relaxing a single departmental rule requires modifying tangled imperative code. By elevating the specification into first-order-logic-backed Task-Based Conceptual Graphs (TBCG) that automatically compile into CLIPS rules and database schemas, policy maintenance becomes transparent, explainable, and rapid.
-->

---

## 2. Related Work: Three Paradigms of Automated Timetabling

| Paradigm | Representative Techniques | Key Strengths | Primary Limitations |
| :--- | :--- | :--- | :--- |
| **Operations Research (OR)** | **Sequential:** Graph coloring (de Werra)<br>**Cluster:** Lagrangian relaxation, QAP<br>**Meta-heuristic:** Memetic GA, Tabu Search, Hill-Climbing | High-quality solutions for well-formed math models (especially meta-heuristics) | Graph coloring fails to scale &amp; resists rule changes; fixed clusters hurt quality; meta-heuristics incur high compute cost |
| **Human-Machine Interaction (HMI)** | Iterative approximation–evaluation–modification (Mulvey); DBMS bookkeeping (Johnson) | Keeps human judgment in the loop; reduces clerical workload | Laborious for large problems; finding a good initial solution is computationally expensive |
| **Artificial Intelligence (AI)** | **Constraint Programming / CLP** (Prolog, OO-CBR)<br>**Expert Systems** (RAPS, PROTEUS, OO scheduler)<br>**Neural Networks** (Hopfield nets) | Expressive constraints; captures domain expertise; separates data, knowledge &amp; solver | Hopfield nets suffer infeasibility &amp; heavy compute; most AI systems still require manual coding when specs evolve |

<div class="callout teal">
<strong>Positioning TBCG:</strong> Extends the <strong>Expert System + Constraint Satisfaction</strong> lineage by adding <strong>formal conceptual graph modeling</strong>, <strong>contextual reuse</strong>, <strong>automated verification</strong>, and <strong>automatic code generation</strong>.
</div>

<!--
Comparative Literature Synthesis (Section 2):
The paper organizes three decades of timetabling literature into three major families:
1. Operations Research (Section 2.1): Sequential graph-coloring methods (de Werra, 1985, 1996, 1997) struggle with scale and dynamic customization; cluster methods (Tripathy, 1984, 1992; Ferland & Roy, 1985) risk poor timetable quality due to early fixed clustering (Burke & Petrovic, 2002); meta-heuristics (Hertz, 1991, 1992; Schaerf, 1999; Moscato & Norman, 1992) achieve strong quality at steep computational cost.
2. Human-Machine Interaction (Section 2.2): Systems like Mulvey (1982) and Johnson (1993) aid clerical bookkeeping and interactive refinement but remain laborious at scale.
3. Artificial Intelligence (Section 2.3): Constraint logic programming (Boizumault et al., 1996; Deris et al., 2000; Valouxis & Housos, 2003) and expert systems (Gunadhi et al., 1996; Solotorevsky et al., 1994 RAPS; Dhar & Ranganathan, 1990 PROTEUS) separate knowledge from algorithms, whereas Hopfield neural networks (Smith et al., 1995) suffer heavy computational overhead (Mausser & Magazine, 1996). TBCG builds directly on AI's separation of concerns while automating the entire specification-to-code lifecycle.
-->

---

## 3. Problem Formulation: NCU CSIE Case & 7 Constraints

<div class="fig-box" style="padding: 6px; margin-bottom: 8px;">
<img src="./img/tbcg_constraints_hierarchy.svg" alt="NCU CSIE Course Timetabling Scope and Constraint Hierarchy" style="max-height: 365px;">
<div class="fig-cap">NCU CSIE real-world dataset (42 subjects, 40 timeslots, 6 rooms), 3 actors, 5 hard constraints (C<sub>0</sub>), and 2 soft constraints (Section 3).</div>
</div>

<div class="callout" style="margin-top: 8px;">
<strong>Workflow:</strong> Instructors submit course forms (title, <strong>preference set</strong>, <strong>exclusion set</strong>) ➔ Automated scheduling ➔ Draft circulated for instructor validation ➔ Approved timetable sent to Dean of Academic Affairs.
</div>

<!--
Problem Statement & NCU Benchmark (Section 3):
Following Schaerf's (1999) taxonomy (school, course, and examination timetabling), this study addresses university course timetabling using real operational data from the Department of Computer Science and Information Engineering at National Central University (NCU): 19 faculty members, over 550 students, 42 subjects (1 to 5 lectures/week based on credit hours), 40 weekly timeslots, and 6 classrooms.

Constraint Partitioning:
Constraints 1 through 5 are Hard Constraints (Level C0, strictly mandatory): no instructor double-booking, no overlap among required courses of the same class, single course per classroom per slot, classroom availability respected, and room capacity >= registered students. Constraints 6 and 7 are Soft Constraints (relaxable): matching instructor preference/exclusion sets, and avoiding 3+ consecutive lectures (e.g., splitting a 3-credit course into 2 consecutive slots + 1 isolated slot on another day).
-->

---

## 4. TBCG Automated Software Engineering Lifecycle

<div class="fig-box" style="padding: 8px; margin-bottom: 10px;">
<img src="./img/fig1_tbcg_process.png" alt="Figure 1: Automated software development processes by TBCG" style="max-height: 290px;">
<div class="fig-cap">Figure 1 (Paper p. 1143): End-to-end automated software development and specification-level maintenance via TBCG.</div>
</div>

<div class="three-col">
<div class="card">
<h3>1. Modeling &amp; Reuse</h3>
<p class="small-text">Capture domain/process specs in <strong>TBCG</strong>; reuse past specs via <strong>Contextual Retrieval</strong> (fuzzy similarity + purpose-directed analogy).</p>
</div>
<div class="card teal">
<h3>2. Formal Verification</h3>
<p class="small-text">Verify <strong>Model Specs</strong> (constraint satisfaction &amp; relaxation) and <strong>Process Specs</strong> (inter-/intra-level CG inference consistency).</p>
</div>
<div class="card accent">
<h3>3. Auto-Generation</h3>
<p class="small-text">Blackboard transforms verified TBCG into <strong>CLIPS</strong> rules, DB schemas &amp; UI; maintenance loops back to <strong>TBCG specs</strong>.</p>
</div>
</div>

<!--
Four-Stage TBCG Automation Pipeline (Section 4, Figure 1):
Figure 1 highlights the paper's core software engineering loop:
1. Specification Acquisition: Task-Based Specification Methodology (TBSM; Lee, Lai, & Huang, 1996) organizes domain knowledge, functional requirements, and problem-solving methods around tasks, while Conceptual Graphs (CGs; Sowa, 1984) supply first-order-logic semantics. A Contextual Retrieval Mechanism (Lai, Lee, & Yang, 1999) uses fuzzy similarity and purpose-directed analogy to retrieve reusable TBCGs from the repository.
2. Verification (Lee & Lai, 1998): Checks both static model consistency (constraint networks and relaxation repair) and dynamic process consistency (inter-level and intra-level transitions).
3. Operationalization: Translates verified TBCGs into executable CLIPS code.
4. Specification-Level Maintenance: Crucially, the feedback arrow labeled "Maintenance" returns directly to TBCG specifications rather than to generated CLIPS code.
-->

---

## 4.1 Task-Based Specifications in Conceptual Graphs (TBSM + CG)

<div class="two-col">
<div class="card">
<h3>TBSM: Four Specification Views</h3>
<ul class="small-text">
<li><strong>Domain Model (DM):</strong> Static entities, attributes, and relations (ER-like concepts).</li>
<li><strong>State Model (SM):</strong> Problem-solving states, completion stages, and attached constraints.</li>
<li><strong>Functional Specification (FM):</strong> Preconditions, local invariants (<em>protections</em>), and rigid/soft postconditions.</li>
<li><strong>Behavioral Specification (BM):</strong> Dynamic subtask control via <strong>Task State Expressions (TSE)</strong>:
  <ul>
  <li><em>Sequencing:</em> follow, immediately follow</li>
  <li><em>Branching:</em> selection, optional, conditional (<code>b?</code> / <code>¬b?</code>)</li>
  <li><em>Iteration:</em> repeating task loops</li>
  </ul>
</li>
</ul>
</div>
<div class="card teal">
<h3>Extended Conceptual Graph Primitives</h3>
<ul class="small-text">
<li><strong>Concepts <code>[Entity]</code> &amp; Relations <code>(rel)</code>:</strong> Declarative facts, attributes <code>(attr)</code>, data types <code>(chrc)</code>, and cardinalities (<code>@</code>).</li>
<li><strong>Actors <code>&lt;Actor&gt;</code>:</strong> Procedural nodes computing output referents from inputs.</li>
<li><strong>Demons <code>&lt;&lt;Demon&gt;&gt;</code> (Delugach):</strong> State-transition triggers that <strong>assert</strong> output concepts and <strong>retract</strong> input concepts once all inputs &amp; task tokens are enabled.</li>
<li><strong>Constraint Overlays:</strong> Dashed-line actors overlaid on state graphs to enforce hard/soft constraints.</li>
</ul>
</div>
</div>

<!--
Formal Foundations of TBCG (Section 4.1):
TBCG unifies TBSM's multi-level task refinement (task / method / subtask, inspired by Chandrasekaran, 1990) with Sowa's Conceptual Graphs extended by Delugach's (1991) dynamic demons and Eshner/Pfeiffer's constraint overlays.
- Static vs. Dynamic Split: Domain Models map terms to ENTITY concepts, attributes via (attr), and types via (chrc). State Models overlay constraint actors onto state graphs and use demons whose inputs are STATE objects plus TASK tokens.
- Functional Semantics: Preconditions, protections, and rigid postconditions are crisp propositions, whereas soft postconditions are modeled as fuzzy propositions (Lee & Kuo, 1998).
- Behavioral Semantics: Task State Expressions (TSE) extend regular expressions and compile into state-transition diagrams using an initiator demon, a START state, conditional test tasks (b? and not-b?), and a (final) monadic relation.
-->

---

## 4.2 Hierarchical Task Structure for NCU Timetabling

<div class="split55">
<div>
<div class="card" style="margin-bottom: 10px;">
<h3>Top-Down Task Decomposition</h3>
<ul class="small-text">
<li><strong>Root Task <code>T0</code>:</strong> <code>Courses-Scheduling-System</code> iterates via <code>M-T0</code> over <code>Select-An-Instructor (T1)</code> and <code>Schedule-An-Instructor (T2)</code>.</li>
<li><strong>Method <code>M-T2</code>:</strong> Iteratively executes:
  <ol>
  <li><code>Select-A-Course (T21)</code> from unscheduled courses;</li>
  <li><code>Schedule-A-Course (T22)</code> into valid slot &amp; room;</li>
  <li><code>Conflict-Resolution (T23)</code> — <em>skipped</em> if <code>T22</code> succeeds!</li>
  </ol>
</li>
</ul>
</div>
<div class="card accent">
<h3>Constraint Relaxation Subtasks (<code>M-T23</code>)</h3>
<ul class="small-text">
<li><code>T231</code>: <strong>Schedule-With-Flexibility</strong></li>
<li><code>T232</code>: <strong>Reduce-Exclusive-Set</strong> (optional)</li>
<li><code>T233</code>: <strong>Enlarge-Preference-Set</strong> (optional)</li>
</ul>
</div>
</div>
<div class="fig-box">
<img src="./img/fig2_task_structure.png" alt="Figure 2: A task structure of the timetabling at NCU" style="max-height: 415px;">
<div class="fig-cap">Figure 2 (Paper p. 1145): Hierarchical task/method/subtask structure with TSE control expressions.</div>
</div>
</div>

<!--
Task Hierarchy & Conflict Resolution (Section 4.1, Figure 2):
Figure 2 illustrates how TBCG tames scheduling complexity through modular task decomposition (task -> method -> subtasks).
- At the top level, M-T0 controls the loop (b1(T1, T2))* over all instructors.
- Inside Schedule-An-Instructor (T2), M-T2 specifies the TSE (b2(T21, T22, b3(T23)))*: while unscheduled courses remain (b2), select a course (T21), attempt to schedule it (T22), and invoke Conflict-Resolution (T23) only when a conflict occurs (b3 is true).
- When invoked, M-T23 resolves conflicts by relaxing soft constraints through Schedule-With-Flexibility (T231), optionally reducing the instructor's exclusive set (T232), or enlarging the preference set (T233).
-->

---

## 4.3 Concrete Task Specification: `Schedule-A-Course` (`T22`)

<div class="split55">
<div>
<ul class="small-text">
<li><strong>Domain Model (Top):</strong> Defines three core concepts and attributes—e.g., <code>Course</code> carries 7 attributes (<code>Name</code>, <code>Session</code>, <code>Class</code>, <code>Required</code>, <code>Credit-Hours</code>, <code>Meeting</code>, <code>Location</code>) with cardinality markers (<code>@1</code>, <code>@n</code>).</li>
<li><strong>State Model (Bottom):</strong> Captures transition from <code>Course[current]</code> ➔ <code>Course[scheduled]</code> triggered by demon <code>&lt;&lt;Schedule-A-Course&gt;&gt;</code>.</li>
<li><strong>Constraint Overlays (<code>T22-L1</code>..<code>T22-L5</code>):</strong> Overlaid on the state transition; e.g., <code>T22-L1</code> checks that no scheduled meeting falls inside the instructor's <code>exclusive-set</code>.</li>
</ul>
<div class="callout teal" style="margin-top: 8px;">
<strong>Two-Rule Compilation:</strong> Every constraint overlay yields both a <strong>satisfaction test rule</strong> and a <strong>violation repair (fix) rule</strong> in CLIPS.
</div>
</div>
<div class="fig-box">
<img src="./img/fig5_schedule_course.png" alt="Figure 5: The task Schedule-A-Course" style="max-height: 410px;">
<div class="fig-cap">Figure 5 (Paper p. 1147): Complete TBCG specification (Domain Model + State Model) of task Schedule-A-Course.</div>
</div>
</div>

<!--
Detailed Anatomy of Schedule-A-Course (Section 4.1, Figures 5 and 6):
Figure 5 demonstrates how static data structure and dynamic state-transition semantics coexist cleanly inside a single TBCG task specification:
- Domain Model: Models Instructor, Course, and Available-Location along with single-valued and multi-valued attributes.
- State Model: Specifies that the state "[current] <- (Instructor) -> (instruct) -> [Course] -> (current)" transitions to "... -> [Course] -> (scheduled)" if and only if (1) the constraint hierarchy T22-L1 through T22-L5 is satisfied (at least through hard level C0) and (2) the task token Schedule-A-Course is performed.
- Figure 6 in the paper zooms into constraint T22-L1, separating its "rule" part (checking satisfaction) from its "fix-rule" part (repairing violations).
-->

---

## 5. Operationalizing TBCG via a 6-Level Blackboard Model

<div class="split55">
<div>
<p class="small-text">A <strong>Blackboard architecture</strong> (6 hierarchical levels + <strong>5 Knowledge Sources</strong>) opportunistically and incrementally transforms verified TBCGs into executable software:</p>
<ol class="small-text">
<li><strong>Task Partition KS:</strong> Splits each Task into 4 views (<code>DM</code>, <code>SM</code>, <code>FM</code>, <code>BM</code>).</li>
<li><strong>Database Construction KS:</strong> Maps <code>DM</code> ➔ CLIPS <code>deftemplate</code> &amp; Oracle DB schemas.</li>
<li><strong>Rule Extraction KS:</strong> Extracts CLIPS <code>defrule</code>s from <code>SM</code> (constraints/states), <code>FM</code> (preconditions/protections), and <code>BM</code> (TSE demons).</li>
<li><strong>UI Info Extraction KS:</strong> Extracts form formats (<code>DM</code>), HCI states (<code>SM</code>), and flow (<code>BM</code>).</li>
<li><strong>KB Synthesis KS:</strong> Integrates all task rules into a unified Knowledge Base guided by the task structure.</li>
</ol>
</div>
<div class="fig-box">
<img src="./img/fig7_blackboard.png" alt="Figure 7: The blackboard model of our system" style="max-height: 400px;">
<div class="fig-cap">Figure 7 (Paper p. 1150): Six-level Blackboard hierarchy (Task ➔ Knowledge Base) driven by five Knowledge Sources.</div>
</div>
</div>

<!--
Blackboard Operationalization Architecture (Section 4.2, Figure 7):
To bridge the gap between graphical conceptual graphs and a complete multi-component software system (database, expert system rules, and user interface), the authors employ a Blackboard problem-solving model organized into six abstraction levels: Task, Model (DM, SM, FM, BM), Database, Rule, UI Information, and Knowledge Base.

Opportunistic & Incremental Synthesis:
Knowledge Sources (KS) communicate exclusively by reading and writing changes on the blackboard. Whenever a new TBCG task specification or constraint edit is posted, the relevant KSs trigger incrementally to regenerate the affected deftemplates, defrules, UI metadata, and synthesized knowledge base—avoiding monolithic recompilation and enabling rapid iterative prototyping.
-->

---

## 5.1 End-to-End Transformation: TBCG ➔ CLIPS & Oracle DB

<div class="fig-box" style="padding: 6px; margin-bottom: 8px;">
<img src="./img/tbcg_to_clips_pipeline.svg" alt="TBCG to CLIPS and Oracle Transformation Pipeline" style="max-height: 365px;">
<div class="fig-cap">Mapping four TBCG views through five Blackboard Knowledge Sources into CLIPS deftemplates, defmodules/defrules, Oracle DB, and Java UI.</div>
</div>

<div class="callout teal" style="margin-top: 8px;">
<strong>Modular Isolation:</strong> Each TBCG task compiles into an independent CLIPS <code>defmodule</code>, and each composite actor into its own module—so rules in one task never corrupt another task's execution.
</div>

<!--
Systematic Code Generation Pipeline (Sections 4.2.1, 4.2.2, 5.1, and 5.2):
This diagram summarizes the exact target artifacts produced by the TBCG CASE tool and Blackboard system:
- From Domain Model (DM): One-to-one mapping of concept cardinalities (Table II) into CLIPS deftemplate constructs with single-field (slot) and multi-field (multislot) attributes plus a unique non-null id slot for entity integrity, then directly into Oracle object-relational tables (collection columns for multislots).
- From State/Functional/Behavioral Models (SM, FM, BM): Modular CLIPS defmodules and defrules implementing constraint tests, violation repairs, high-salience protection invariants, and focus-stack control flow.
- From UI Info Extraction: Initial Java front-end forms and interaction flows connected to the Oracle database via JDBC/ODBC.
-->

---

## 5.2 Translating Domain Models, Actors, Demons & Constraints

<div class="two-col">
<div class="card">
<h3>1. Data, Integrity &amp; Extensible Actors</h3>
<ul class="small-text">
<li><strong>Table II (DM ➔ CLIPS ➔ Oracle):</strong> Single concepts map to <code>slot</code>; sets map to <code>multislot</code> (Oracle collection columns). Every template gets a unique non-null <code>id</code> slot; cascading deletion preserves referential integrity.</li>
<li><strong>Table III (Actor Primitives):</strong> 1-to-1 CLIPS mapping across 4 groups—<em>Test</em> (<code>&gt;</code>, <code>eq</code>, <code>member</code>, <code>subsetp</code>), <em>Manipulation</em> (<code>insert</code>, <code>delete</code>, <code>replace</code>), <em>I/O</em> (<code>read</code>, <code>printout</code>), and <em>Math</em> (<code>+</code>, <code>-</code>, <code>*</code>, <code>/</code>). Composite actors compose dataflow primitives.</li>
</ul>
</div>
<div class="card teal">
<h3>2. Control Flow &amp; Constraint Hierarchy</h3>
<ul class="small-text">
<li><strong>TSE Demons ➔ <code>defrule</code> + <code>focus</code> Stack:</strong> Follow, Conditional, and Iteration demons retract input state, assert output state, and push the subtask module via <code>focus</code>; empty agenda pops focus back.</li>
<li><strong>Preconditions &amp; Protections:</strong> Unmet preconditions invoke <code>return</code>; local invariants compile to <strong>highest-salience rules</strong> that auto-restore prior state upon violation.</li>
<li><strong>Constraint Hierarchy (<code>C<sub>0</sub></code>..<code>C<sub>n</sub></code>):</strong> A state transition fires only when hard level <code>C<sub>0</sub></code> (and all stronger levels) are satisfied.</li>
</ul>
</div>
</div>

<div class="callout">
<strong>Clean Separation of Concerns:</strong> Facts (<code>deftemplate</code>), domain/control rules (<code>defrule</code>), and CLIPS's Rete inference engine remain cleanly decoupled—making constraint insertion or removal a one-edit specification change.
</div>

<!--
Detailed Translation Mechanics (Sections 4.2.1, 4.2.2, 5.1, and 5.2):
1. Database & Integrity (4.2.1 & 5.1): For Schedule-A-Course, the Database Construction KS generates three CLIPS templates: Course, Instructor, and Available-Location. The Course template maps directly to the Oracle relation Course(id, state, name, session, class, required, credit-hours, {meeting}, {location}). Adding a mandatory unique id slot enforces key/entity integrity, while cascading cleanup on fact retraction enforces referential integrity.
2. Actor Operationalization (4.2.2): Table III enumerates 22 built-in actor primitives across test, manipulation, I/O, and arithmetic categories. New composite actors can be defined graphically as dataflow combinations of existing primitives and compiled automatically into CLIPS modules.
3. State Transitions & Hierarchy (4.2.2 & 5.2): Each constraint generates a test rule (e.g., T22-L1-rule asserting constraint-satisfaction) and a fix rule. Level-checking rules verify cumulative satisfaction from C0 downward, firing State-Transition only when satisfied. Protection rules carry the highest CLIPS salience so any invariant breach immediately rolls back the offending fact change.
-->

---

## 6. NCU University Timetabling System Architecture

<div class="split55">
<div>
<div class="card" style="margin-bottom: 10px;">
<h3>Two-Part Deployed Architecture</h3>
<ul class="small-text">
<li><strong>Front-End (Java UI):</strong> Interactive course-form entry, timetable visualization, and instructor validation.</li>
<li><strong>Kernel (Generated CLIPS Expert System):</strong> Produced automatically from verified TBCG specifications via the TBCG CASE tool.</li>
<li><strong>Shared Oracle Database (JDBC/ODBC):</strong> Enables multiple departments (Dept. A, Dept. B) to coordinate shared classrooms and campus resources over the network.</li>
</ul>
</div>
<div class="card teal">
<h3>Knowledge Base Synthesis Guarantee</h3>
<p class="small-text">The <strong>KB Synthesis KS</strong> traverses the task structure top-down from root <code>T0</code>, collecting every subtask's rules so no rule is ever omitted during integration.</p>
</div>
</div>
<div class="fig-box">
<img src="./img/fig11_ncu_system.png" alt="Figure 11: Overview of the university timetabling system in NCU" style="max-height: 405px;">
<div class="fig-cap">Figure 11 (Paper p. 1156): Multi-department NCU timetabling deployment with Java UI, TBCG-generated kernel, and networked Oracle DB.</div>
</div>
</div>

<!--
System Deployment & Multi-Department Architecture (Section 5, Figure 11):
Figure 11 shows the complete operational architecture deployed for National Central University. Each department (Department A, Department B) runs its own TBCG-generated executable expert system kernel paired with a Java front-end UI, while connecting through JDBC/ODBC over the campus network to a shared Oracle database. This design lets individual departments customize their local scheduling policies and constraints directly in their own TBCG specifications while maintaining campus-wide consistency on shared rooms and timeslots.
-->

---

## 7. Discussion, Limitations & Key Takeaways

<div class="two-col">
<div class="card teal">
<h3>Three Architectural Advantages</h3>
<ol class="small-text">
<li><strong>Specification-Level Maintenance:</strong> Policy updates and hard/soft constraint insertions or removals happen directly on graphical TBCGs rather than brittle source code.</li>
<li><strong>Decoupled Expert Architecture:</strong> Clean separation of facts, knowledge base, and inference engine boosts long-term maintainability.</li>
<li><strong>Multi-Level Scalability:</strong> Hierarchical task decomposition (<code>T0 ➔ T2 ➔ T22/T23</code>) breaks large timetabling problems into verifiable, modular subproblems.</li>
</ol>
</div>
<div class="card accent">
<h3>Scope Boundaries &amp; Limitations</h3>
<ul class="small-text">
<li><strong>Qualitative Case Validation:</strong> Demonstrates NCU CSIE (42 subjects, 40 slots, 6 rooms) end-to-end, without runtime/quality benchmarks against Tabu Search or ILP solvers.</li>
<li><strong>Feasibility over Global Optimality:</strong> Designed to satisfy all <code>C<sub>0</sub></code> hard constraints and relax soft constraints rather than optimize a numeric objective.</li>
<li><strong>Tooling Dependency:</strong> Requires analysts trained in Conceptual Graphs and TBSM notation alongside the TBCG CASE tool.</li>
</ul>
</div>
</div>

<div class="callout">
<strong>Core Takeaway:</strong> Conceptual modeling with <strong>TBCG</strong> turns university timetabling from a one-off coding exercise into a <strong>verifiable, reusable, specification-driven software engineering workflow</strong>.
</div>

<!--
Critical Synthesis & Research Assessment (Section 6):
The paper's enduring contribution lies in software engineering automation for knowledge-intensive scheduling systems:
1. Maintainability: Small logical changes at the code level often trigger unpredictable bugs, whereas editing a TBCG constraint overlay or task method is visual, formal, and verifiable prior to code regeneration.
2. Modularity: Mapping tasks to CLIPS defmodules and using a Blackboard architecture cleanly separates database schemas, constraint rules, invariants, and UI specifications.

Methodological Limitations:
As an architectural and modeling paper in IJIS, the evaluation focuses on expressiveness, formal translation correctness, and deployment feasibility on NCU CSIE's 42-course dataset rather than empirical runtime comparisons against meta-heuristic or integer programming benchmarks. Extending TBCG with quantitative soft-constraint scoring and large-scale multi-college benchmarks remains a natural avenue for follow-up work (e.g., the authors' subsequent IJAIT 2008 paper).
-->

---

<!-- _class: closing -->

# Thank You & Questions

<p style="font-size: 1.02em; max-width: 780px;">
Task-Based Conceptual Graphs · Six-Level Blackboard Synthesis · Executable CLIPS Timetabling
</p>

<div class="contact-card">
<strong>Jonathan Lee</strong><sup>1</sup> &nbsp;·&nbsp; <code>yjlee@selab.csie.ncu.edu.tw</code> &nbsp;|&nbsp; <strong>Shang-Pin Ma</strong><sup>1</sup> &nbsp;|&nbsp; <strong>Lien Fu Lai</strong><sup>2</sup><br>
<strong>Nien Lin Hsueh</strong><sup>3</sup> &nbsp;·&nbsp; <code>nlhsueh@fcu.edu.tw</code> &nbsp;|&nbsp; <strong>Yong-Yi Fanjiang</strong><sup>4</sup><br>
NCU · NCUE · Feng Chia University · National Taichung University, Taiwan<br>
<span style="font-size: 0.85em; opacity: 0.88;">International Journal of Intelligent Systems (IJIS), Vol. 20, pp. 1137–1160, 2005 · DOI: 10.1002/int.20115 · NSC92-2213-E-008-001</span>
</div>

<!--
Reference & Archival Metadata:
- Title: University Timetabling through Conceptual Modeling
- Authors: Jonathan Lee (NCU), Shang-Pin Ma (NCU), Lien Fu Lai (NCUE), Nien Lin Hsueh (FCU), Yong-Yi Fanjiang (National Taichung University)
- Venue: International Journal of Intelligent Systems, Vol. 20, pp. 1137 to 1160, 2005 (Wiley Periodicals, Inc.)
- DOI: 10.1002/int.20115
- Funding: National Science Council (Taiwan), Grant NSC92-2213-E-008-001
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
