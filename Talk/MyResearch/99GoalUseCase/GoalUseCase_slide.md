---
marp: true
theme: gaia
size: 16:9
paginate: true
html: true
header: '<div class="hdr-wrap"><span class="hdr-title">Analyzing User Requirements by Use Cases: A Goal-Driven Approach (GDUC)</span><div class="hdr-actions"><a class="lang-btn" href="./GoalUseCase_slide_zh.html" title="切換至繁體中文簡報">🌐 繁</a><div class="nav-dropdown"><button class="nav-btn">Sections ▾</button><div class="nav-menu"><a href="#2">Outline</a><a href="#3">1. Motivation &amp; Foundations</a><a href="#5">2. Actors &amp; Faceted Goals</a><a href="#7">3. Building Use-Case Models</a><a href="#10">4. Goal Evaluation Pipeline</a><a href="#12">5. Formal Interaction Rules</a><a href="#14">6. Conclusion &amp; Roadmap</a></div></div></div></div>'
footer: 'Jonathan Lee & Nien-Lin Xue · National Central University · IEEE Software 1999'
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
  min-width: 240px;
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
section::after {
  position: absolute;
  right: 54px;
  bottom: 14px;
  font-size: 12.5px;
  font-weight: 700;
  color: var(--navy);
  content: attr(data-marpit-pagination) ' / ' attr(data-marpit-pagination-total);
}

h1 { color: var(--navy); font-size: 1.7em; font-weight: 800; line-height: 1.22; margin: 0 0 12px 0; letter-spacing: 0 !important; }
h2 {
  color: var(--navy);
  font-size: 1.22em;
  font-weight: 700;
  line-height: 1.25;
  margin: 0 0 12px 0;
  padding-bottom: 6px;
  border-bottom: 2.5px solid var(--navy);
  display: flex;
  align-items: center;
  gap: 8px;
  letter-spacing: 0 !important;
}
h3 { color: var(--accent); font-size: 0.94em; font-weight: 700; margin: 4px 0 6px 0; letter-spacing: 0 !important; }
p { margin: 0 0 8px 0; }
ul, ol { margin: 4px 0 8px 0; padding-left: 22px; }
li { margin-bottom: 4px; line-height: 1.42; }
strong { color: var(--slate-900); }
a { color: #2563eb; text-decoration: none; }
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
section.lead h1 { color: #ffffff; font-size: 2.02em; font-weight: 800; line-height: 1.24; margin-bottom: 16px; text-align: left; }
section.lead .subtitle { color: #cbd5e1; font-size: 0.94em; line-height: 1.5; margin-bottom: 26px; max-width: 960px; }
section.lead .meta-box { border-left: 4px solid #f43f5e; padding-left: 18px; color: #e2e8f0; font-size: 0.85em; line-height: 1.6; }
section.lead .grant { margin-top: 22px; font-size: 0.72em; color: #94a3b8; }

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

.two-col { display: grid; grid-template-columns: 1fr 1fr; gap: 18px; align-items: stretch; }
.three-col { display: grid; grid-template-columns: repeat(3, 1fr); gap: 14px; align-items: stretch; }
.split64 { display: grid; grid-template-columns: 58% 40%; gap: 2%; align-items: center; }
.split55 { display: grid; grid-template-columns: 49% 49%; gap: 2%; align-items: center; }

.card {
  background: #ffffff;
  border: 1px solid var(--slate-200);
  border-top: 3.5px solid var(--navy);
  border-radius: 8px;
  padding: 11px 15px;
  box-shadow: 0 2px 6px rgba(15, 23, 42, 0.05);
  box-sizing: border-box;
}
.card.accent { border-top-color: var(--accent); }
.card.teal { border-top-color: var(--teal); }

.callout {
  background: #f8fafc;
  border-left: 4px solid var(--accent);
  border-radius: 0 8px 8px 0;
  padding: 10px 16px;
  margin-top: 12px;
  font-size: 0.84em;
  color: var(--slate-700);
  line-height: 1.5;
}
.callout.teal { border-left-color: var(--teal); background: var(--teal-soft); }
.callout strong { color: var(--navy); }

table {
  width: 100%;
  border-collapse: collapse;
  font-size: 0.72em;
  margin: 6px 0;
  background: #ffffff;
  border: 1px solid var(--slate-200);
}
th { background: var(--navy); color: #ffffff; font-weight: 700; padding: 6px 9px; text-align: left; border: 1px solid var(--navy); }
td { padding: 6px 9px; border: 1px solid var(--slate-200); vertical-align: middle; line-height: 1.35; }
tr:nth-child(even) td { background: #f8fafc; }

.outline-grid { display: grid; grid-template-columns: 1fr 1fr; gap: 14px 24px; margin-top: 10px; }
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

.fig-box {
  background: #ffffff;
  border: 1px solid var(--slate-200);
  border-radius: 8px;
  padding: 8px;
  text-align: center;
  box-shadow: 0 2px 6px rgba(15, 23, 42, 0.05);
  overflow: visible;
  position: relative;
}
.fig-box img {
  max-width: 100%;
  height: auto;
  display: block;
  margin: 0 auto;
  border-radius: 4px;
  cursor: zoom-in;
  transition: transform 0.25s ease, box-shadow 0.25s ease;
}
.fig-box.is-zoomed { z-index: 45; }
.fig-box img.is-zoomed { position: relative; z-index: 46; box-shadow: 0 18px 44px rgba(15, 23, 42, 0.30); background: #ffffff; }
.fig-cap { font-size: 0.72em; color: var(--slate-500); margin-top: 5px; font-weight: 500; }

.formula-box {
  background: #f8fafc;
  border: 1px solid var(--slate-200);
  border-left: 4px solid var(--navy);
  border-radius: 6px;
  padding: 7px 12px;
  font-family: 'JetBrains Mono', monospace;
  font-size: 0.76em;
  line-height: 1.48;
  color: var(--slate-900);
  margin: 5px 0;
}

.small-text { font-size: 0.81em; }

@media print { .lang-btn, .nav-dropdown { display: none !important; } }
</style>

<!-- _class: lead -->

<div class="badge">IEEE Software · Feature Article · Vol. 16, No. 4, pp. 92–101 · July/August 1999</div>

# Analyzing User Requirements by Use Cases: A Goal-Driven Approach

<div class="subtitle">
<strong>GDUC (Goal-Driven Use Cases)</strong>: Extending Use-Case Modeling with Faceted Goals to Capture Nonfunctional Requirements and Systematically Evaluate Requirement Interactions
</div>

<div class="meta-box">
<strong>Jonathan Lee</strong> &nbsp;·&nbsp; <code>yjlee@se01.csie.ncu.edu.tw</code><br>
<strong>Nien-Lin Xue</strong> &nbsp;·&nbsp; <code>nien@se01.csie.ncu.edu.tw</code><br>
Department of Computer Science and Information Engineering, National Central University, Chungli 32054, Taiwan
</div>

<div class="grant">
© 1999 IEEE · Supported by National Science Council (Taiwan), Grants NSC87-2213-E-008-024 and NSC88-2213-E-008-006
</div>

<!--
Bibliographic Metadata & Historical Significance:
- Paper Title: Analyzing User Requirements by Use Cases: A Goal-Driven Approach
- Authors: Jonathan Lee (Professor) and Nien-Lin Xue (PhD Student), Department of Computer Science and Information Engineering, National Central University, Taiwan.
- Venue: IEEE Software, Vol. 16, No. 4 (July/August 1999), pp. 92–101 (Feature Article).
- Role in Research Lineage: This seminal IEEE Software paper introduced the Goal-Driven Use Cases (GDUC) methodology, establishing the faceted goal classification scheme (Competence, View, Content), systematic derivation of original and extension use cases, and the formal three-step goal interaction evaluation pipeline that directly served as the foundation for the authors' subsequent 2001 IST paper on structuring Fuzzy Object-Oriented Models.
-->

---

## Outline

<div class="outline-grid">
<div class="outline-item">
<div class="outline-num">1</div>
<div class="outline-body"><a href="#3">Motivation &amp; Theoretical Foundations</a><br>Why classical use cases fall short on NFRs and interactions, and how GDUC bridges goals and use cases.</div>
</div>
<div class="outline-item">
<div class="outline-num">2</div>
<div class="outline-body"><a href="#5">Identifying Actors &amp; Faceted Goals</a><br>Primary vs. secondary actors and the three-facet goal taxonomy (Competence, View, Content).</div>
</div>
<div class="outline-item">
<div class="outline-num">3</div>
<div class="outline-body"><a href="#7">Building Goal-Driven Use-Case Models</a><br>Original vs. extension use cases (extends), abstract reuse (uses), and the Meeting Scheduler specification.</div>
</div>
<div class="outline-item">
<div class="outline-num">4</div>
<div class="outline-body"><a href="#10">Three-Step Goal Evaluation Pipeline</a><br>Five use-case–goal predicates, direct effects vs. side effects, and interaction matrices.</div>
</div>
<div class="outline-item">
<div class="outline-num">5</div>
<div class="outline-body"><a href="#12">Formal System-Level Interaction Rules</a><br>Use-case vs. system-level predicates (cp, cf), three derivation rules, and worked Meeting Scheduler proofs.</div>
</div>
<div class="outline-item">
<div class="outline-num">6</div>
<div class="outline-body"><a href="#14">Benefits &amp; Future Research Roadmap</a><br>Key takeaways of GDUC and the roadmap toward Fuzzy OOM and AHP prioritization.</div>
</div>
</div>

<!--
Article Structure Overview:
1. Introduction (pp. 92–93): Contrasts user-centered use-case strengths with two major limitations (NFRs and requirement interactions), introducing GDUC's four pillars.
2. Goal-Driven Use Cases & Actors (pp. 93–94): Synthesizes Jacobson, Dardenne, and Mylopoulos; defines primary and secondary actors.
3. Identifying Goals (pp. 94–95): Introduces the 3-facet classification scheme (Competence, View, Content).
4. Building Use-Case Models (pp. 95–97, p. 100): Details Original Use Cases, Extension Use Cases (3 triggers), Refinement via `uses`, and the boxed Sample Use Case (`Plan a meeting`).
5. Goal Evaluation (pp. 97–99): Presents the 3-step evaluation pipeline, 5 predicates, direct vs. side effects, and formal system-level interaction equations for original–original, original–extension, and extension–extension goal pairs.
6. Conclusion & Future Work (pp. 99–100): Summarizes GDUC benefits and previews Fuzzy OOM and AHP prioritization.
-->

---

## 1. Motivation: Why Classical Use Cases Need Goals

<div class="two-col">
<div class="card">
<h3>Strengths &amp; Gaps of Classical Use Cases</h3>
<div class="small-text">
<strong>Strengths:</strong> User-centered elicitation; manages complexity by isolating one actor's usage aspect at a time.<br><br>
<strong>Two Critical Problems:</strong><br>
1. <strong>No systematic NFR handling</strong>: Quality attributes are crucial to system success, yet use cases focus almost solely on functional flows.<br>
2. <strong>No requirement interaction analysis</strong>: Conflicting or cooperative interactions among requirements are unaddressed in use-case models.
</div>
</div>
<div class="card accent">
<h3>Four Pillars of GDUC</h3>
<div class="small-text">
Inspired by <strong>procedural logic</strong> (Georgeff &amp; Lansky 1986 — associating every process with a purpose), <strong>GDUC</strong>:<br>
1. Uses <strong>goals</strong> to structure use-case models &amp; derive use cases.<br>
2. Differentiates <strong>soft vs. rigid goals</strong> to handle imprecise NFRs.<br>
3. <strong>Embeds goal information</strong> directly inside use cases.<br>
4. Analyzes <strong>requirement interactions</strong> via goal–use-case relationships.
</div>
</div>
</div>

<div class="callout teal">
<strong>Benchmark Case Study:</strong> The <strong>Meeting Scheduler</strong> problem (Potts et al. 1994) illustrates GDUC end-to-end — turning a vague, contradictory mission statement into a structured specification.
</div>

<!--
Problem Statement & Procedural Logic Inspiration (pp. 92–93):
While Jacobson's use cases excel at user-centered complexity management, Dano et al. and Regnell et al. noted their weakness in formalization and large-scale structuring. Lee and Xue identify two deeper requirements-engineering gaps:
1. Nonfunctional requirements (NFRs) such as convenience, performance, and flexibility have no principled place in classical use-case diagrams.
2. Interactions among requirements (conflicts and synergies) remain invisible until late design.
Drawing on Georgeff & Lansky's procedural logic ("every process serves a purpose"), GDUC binds each use case to an explicit goal to be achieved, optimized, or maintained.
-->

---

## 1.2 Theoretical Foundations & GDUC Construction Workflow

<div class="three-col">
<div class="card">
<h3>Use-Case Mechanics</h3>
<div class="small-text">
• <strong>Actor</strong>: Role played by a category of users.<br>
• <strong>Basic vs. Alternative Courses</strong>: Simplest path vs. variants &amp; errors.<br>
• <strong><code>extends</code></strong>: Embeds extended behavior into base UC.<br>
• <strong><code>uses</code></strong>: Extracts shared fragments into abstract UC for reuse.
</div>
</div>
<div class="card accent">
<h3>Goal-Oriented Roots</h3>
<div class="small-text">
• <strong>Dardenne et al. [13]</strong>: Nonoperational goals achieved via operational constraints on actions/objects.<br>
• <strong>Mylopoulos et al. [14]</strong>: NFR goals are rarely binary-satisfied; evaluated by positive/negative contributions &amp; labeling.<br>
• <strong>Cockburn [16]</strong>: Linking use cases with user goals.
</div>
</div>
<div class="card teal">
<h3>GDUC 3-Step Process</h3>
<div class="small-text">
<strong>Step 1:</strong> Identify <strong>actors</strong> (primary &amp; secondary users interacting directly).<br><br>
<strong>Step 2:</strong> Identify <strong>goals</strong> via a 3-facet classification scheme.<br><br>
<strong>Step 3:</strong> Build &amp; refine <strong>use-case models</strong> (original ➔ extension ➔ abstract reuse).
</div>
</div>
</div>

<div class="callout">
<strong>Core Philosophy:</strong> Goal-based RE focuses on <strong>why</strong> systems are constructed, providing rationale to justify requirements; use cases focus on <strong>how</strong> actors interact with the system. GDUC unifies both views.
</div>

<!--
Synthesis of Prior Work (pp. 93–94):
GDUC fuses two complementary traditions:
- Jacobson's Use-Case Driven Engineering: provides `extends` (behavioral extension) and `uses` (factoring common behavior) alongside basic/alternative courses.
- Goal-Oriented RE (Dardenne et al. 1993; Mylopoulos et al. 1992): explains why requirements exist and recognizes that NFRs are satisfied to degrees rather than all-or-nothing.
GDUC operationalizes this fusion through a clean three-step acquisition workflow (Actors -> Faceted Goals -> Use-Case Models), followed by a three-step evaluation workflow.
-->

---

## 2. Identifying Actors & Three-Facet Goal Classification

**Step 1 — Identifying Actors** (Meeting Scheduler):
- **Primary Actors** (perform main system tasks): `Initiator` (initiates meeting, notifies, resolves conflicts) and `Participant` (registers, inputs date/location/equipment preferences).
- **Secondary Actor** (supervises &amp; maintains system): `Operator`.

<div class="fig-box" style="margin-top: 8px;">
<img src="./img/faceted_goal_cube.svg" style="max-height: 315px;">
<div class="fig-cap">GDUC's three-facet goal classification scheme mapping goals to Original vs. Extension use cases.</div>
</div>

<!--
Actors & Three-Facet Taxonomy (pp. 93–95):
1. Competence Facet: Rigid (R) goals define minimum requirements that must be completely satisfied; Soft (S) goals define desirable properties satisfied partially and are weakly dependent on their rigid goal (e.g., `MaxConvenientSchedule` and `MaxNumberofParticipants` are meaningless if `MeetingRequestSatisfied` fails).
2. View Facet: Actor-specific (A) goals capture an individual actor's objectives, whereas System-specific (Y) goals capture properties the system must uphold across all users (e.g., dynamically replanning to accommodate a more important meeting -> `SupportFlexibility`).
3. Content Facet: Functional (F) goals are achieved by executing a sequence of operations, whereas Nonfunctional (N) goals act as constraints qualifying their associated functional goals.
-->

---

## 2.2 Faceted Goal Classification: Meeting Scheduler Example

Applying the `(Competence, View, Content)` taxonomy to the Meeting Scheduler requirements cleanly separates minimum functional cores from soft, system-wide, and nonfunctional extensions:

| Goal Name | Competence | View | Content | Role in GDUC | Associated Use Case |
| :--- | :--- | :--- | :--- | :--- | :--- |
| `MeetingRequestSatisfied` | **Rigid (R)** | **Actor (A)** | **Functional (F)** | **Original Goal** | `Plan a meeting` (Achieve) |
| `RegisterAMeeting` | **Rigid (R)** | **Actor (A)** | **Functional (F)** | **Original Goal** | `Register a meeting` (Achieve) |
| `MaxNumberofParticipants` | **Soft (S)** | **Actor (A)** | **Nonfunctional (N)** | **Extension Goal** | `Increase attendance` (Maintain) |
| `MaxConvenientSchedule` | **Soft (S)** | **Actor (A)** | **Nonfunctional (N)** | **Extension Goal** | `Make a convenient schedule` (Optimize) |
| `AppropriatePerformance` | **Soft (S)** | **Actor (A)** | **Nonfunctional (N)** | **Extension Goal** | `Keep appropriate performance` (Optimize) |
| `SupportFlexibility` | **Soft (S)** | **System (Y)** | **Functional (F)** | **Extension Goal** | `Accommodate important meetings` (Optimize) |

<div class="callout teal">
<strong>Weak Dependence Principle:</strong> Soft goals (`MaxNumberofParticipants`, `MaxConvenientSchedule`) are <strong>weakly dependent</strong> on `MeetingRequestSatisfied` — participant count and convenience are meaningless if no meeting is scheduled.
</div>

<!--
Worked Classification Analysis (pp. 94–95):
Notice how every goal receives an unambiguous triple (Competence, View, Content):
- Only (R, A, F) goals become Original Goals — guaranteeing that the base use-case model covers every actor's mandatory functional baseline without clutter.
- Any goal deviating on even one facet (Soft, System-specific, or Nonfunctional) becomes an Extension Goal, handled modularly via `extends` use cases.
- Notice also the distinction between Optimize vs. Maintain: `Make a convenient schedule` optimizes convenience beyond the basic meeting plan, whereas `Increase attendance` maintains the full participant count when recovery courses threaten to drop attendees.
-->

---

## 3. Building & Refining Use-Case Models with Goals

<div class="split55">
<div>

Each use case is a process to **achieve**, **optimize**, or **maintain** a goal (extending Cockburn [16]):

1. **Original Use Cases** (`U<sub>1</sub>`): Associated with an actor to **achieve** an original goal `⟨R, A, F⟩`. Includes **Basic Course** + **Alternative Course** (Recovery / Failure).
2. **Extension Use Cases** (`extends`): Created for 3 cases:
   - `E<sub>1</sub>`: **Optimize / Maintain** a **Soft** goal.
   - `E<sub>2</sub>`: **Achieve** a **System-specific** goal.
   - `E<sub>3</sub>`: **Achieve** a **Nonfunctional** goal (qualifying constraint).
3. **Refinement (`uses`)**: Extract common fragments into an **abstract use case** with **no associated goal** (e.g., `Extend date range`).

</div>
<div class="fig-box">
<img src="./img/fig1_deriving_uc.png" style="max-height: 360px;">
<div class="fig-cap">Figure 1. Deriving original (U<sub>1</sub>) and extension (E<sub>1</sub>, E<sub>2</sub>, E<sub>3</sub>) use cases from faceted goals.</div>
</div>
</div>

<!--
Critical Distinction Between `extends` and `uses` in GDUC (pp. 95–97):
Although both `extends` and `uses` insert an additional subsequence into a base use-case flow, GDUC draws a sharp semantic boundary between them:
- In an `extends` relationship, BOTH the original use case and the extension use case own explicit goals to achieve, optimize, or maintain.
- In a `uses` relationship, the extracted abstract use case exists purely to enhance modularity and reusability and has NO goal associated with it.
For instance, both `Increase attendance` and `Make a convenient schedule` may need to extend a meeting's date range; factoring `Extend date range` via `uses` eliminates duplication without inventing artificial goals.
-->

---

## 3.2 Meeting Scheduler: Complete Goal-Driven Use-Case Model

<div class="fig-box" style="margin: 4px 0;">
<img src="./img/fig2_meeting_uc.png" style="max-height: 375px;">
<div class="fig-cap">Figure 2. Goal-driven use-case model for the Meeting Scheduler system (Lee &amp; Xue, IEEE Software 1999).</div>
</div>

<div class="callout">
<strong>Model Reading:</strong> Top layer = Original Goals <code>(R, A, F)</code>; Middle layer = Actors, Original UCs, Extension UCs (<code>extends</code>), &amp; Abstract UC (<code>uses</code>); Bottom layer = Extension Goals (Soft / System / Nonfunctional).
</div>

<!--
Structural Walkthrough of Figure 2 (pp. 95–96):
- Two original use cases satisfy the two rigid, actor-specific, functional goals: `Plan a meeting` (Initiator -> `MeetingRequestSatisfied`) and `Register a meeting` (Participant -> `RegisterAMeeting`).
- Four extension use cases extend `Plan a meeting`:
  1. `Increase attendance` -> Maintain `MaxNumberofParticipants (S, A, N)`.
  2. `Make a convenient schedule` -> Optimize `MaxConvenientSchedule (S, A, N)`.
  3. `Keep appropriate performance` -> Optimize `AppropriatePerformance (S, A, N)`.
  4. `Accommodate important meetings` -> Optimize `SupportFlexibility (S, Y, F)`.
- One abstract use case (`Extend date range`) is shared via `uses` by both `Increase attendance` and `Make a convenient schedule`.
-->

---

## 3.3 Sample Use Case Specification: Planning a Meeting

From the paper's boxed specification (*"Sample Use Case: Planning a Meeting"*, p. 100) — **Goal:** `MeetingRequestSatisfied (R, A, F)`:

<div class="two-col">
<div class="card">
<h3>Basic Course (Nominal Path)</h3>
<div class="small-text">
1. Initiator issues a meeting request.<br>
2. System auto-fills submission date; initiator enters date range, locations, meeting type, potential attendees &amp; importance levels.<br>
3. Initiator notifies attendees: active participants enter equipment needs; important participants enter preferred locations; exclusive &amp; preference sets lie inside date range.<br>
4. System computes schedule within date range, outside all exclusive sets, with available room + equipment + minimum lead time.<br>
5. System lists feasible schedules; initiator picks one &amp; notifies all participants.
</div>
</div>
<div class="card accent">
<h3>Alternative Courses (Recovery &amp; Failure)</h3>
<div class="small-text">
<strong>Strong Schedule Conflict Recovery / Failure:</strong><br>
System notifies initiator to choose:<br>
• Ask a participant to remove a date from exclusive set;<br>
• Propose a low-importance participant to withdraw;<br>
• Extend the date range; or<br>
• <strong>Cancel the meeting</strong> (failure course — elicited because problem statements omitted cancellation rules!).<br><br>
<strong>Equipment Unavailability:</strong><br>
Initiator proposes new locations (restarts round) or cancels meeting and notifies all participants.
</div>
</div>
</div>

<!--
Requirements Elicitation Value of Recovery vs. Failure Courses (pp. 95, 100):
Separating alternative courses into Recovery Courses (restoring the original goal `MeetingRequestSatisfied`) and Failure Courses (handling unrecoverable failure) directly uncovers missing requirements! As the authors note on p. 95, the original Meeting Scheduler problem statement never specified when a meeting should be canceled; forcing analysts to define the failure course for `MeetingRequestSatisfied` immediately exposed this elicitation gap.
Furthermore, notice how recovery actions (e.g., proposing a low-importance participant withdraw) can impair the soft goal `MaxNumberofParticipants`, motivating the `Increase attendance` extension use case to maintain that soft goal.
-->

---

## 4. Goal Evaluation: Three-Step Requirements Evaluation Pipeline

Real-world requirements inevitably contradict one another. GDUC evaluates interactions systematically through **three matrix transformations**:

<div class="fig-box" style="margin: 6px 0;">
<img src="./img/fig3_eval_steps.png" style="max-height: 295px;">
<div class="fig-cap">Figure 3. GDUC's three steps: (a) Use-case–Goal predicates ➔ (b) Use-case-level interactions ➔ (c) System-level interactions.</div>
</div>

1. **(a) UC–Goal Analysis**: Determine each use case's direct effects &amp; side effects on every goal.
2. **(b) Use-Case-Level Pairwise Interactions**: Derive whether `(G<sub>i</sub>, G<sub>j</sub>)` cooperate, conflict, or are irrelevant w.r.t. each `U<sub>k</sub>`.
3. **(c) System-Level Amalgamation**: Aggregate across base &amp; extension use cases to classify system-wide goal interactions.

<!--
Evaluation Pipeline Architecture (pp. 96–97):
Figure 3 visually summarizes GDUC's bottom-up evaluation mechanics:
- Matrix (a) has rows U1..Um and columns G1..Gn, populated with the 5 predicates (`Satisfied`, `Denied`, `Satisfiable`, `Deniable`, `Independent`).
- Matrix (b) transforms pairs of columns from (a) into pairwise goal relations (`Conflicting`, `Cooperative`, `Irrelevant`) per use case Uk.
- Matrix (c) amalgamates rows across the use-case model into a single system-level verdict (`Conflicting`, `Cooperative`, `Counterbalanced`, `Irrelevant`) for every goal pair (Gi, Gj).
-->

---

## 4.1 Use-Case–Goal Relationships: Direct Effects & Side Effects

<div class="split64">
<div>

Adopted **5 predicates** (extending Mylopoulos et al. [14]):
- `satisfied` / `denied`: completely achieved or ceased.
- `satisfiable` / `deniable`: partially satisfied or impaired.
- `independent`: unaffected by performing the use case.

**Direct Effects (solid arrows) vs. Side Effects (dashed arrows):**
- **(a) Original UC ➔ Basic Goal**: `satisfied` (basic/recovery) or `denied` (failure).
- **(b) Extension UC ➔ Extension Goal**: `satisfied` (rigid) or `satisfiable` (soft).
- **(c) Original UC ➔ Extension Goal**: Succeeding `Plan a meeting` partially satisfies `MaxConvenientSchedule` (`satisfiable`).
- **(d) Extension UC ➔ Basic Goal**: System-specific `Accommodate important meetings` may cancel a meeting (`denied`).
- **(e) Extension UC ➔ Other Extension Goal**: `Increase attendance` helps `MaxConvenientSchedule` (`satisfiable`), whereas `Keep appropriate performance` halts convenience negotiation (`deniable`).

</div>
<div class="fig-box">
<img src="./img/fig4_uc_goal_rel.png" style="max-height: 390px;">
<div class="fig-cap">Figure 4. Direct effects (a, b) and side effects (c, d, e) between use cases and goals.</div>
</div>
</div>

<!--
Side-Effect Mechanics in Figure 4 (p. 97):
A major contribution of GDUC is making hidden side effects explicit:
- Arrow (c) captures positive spillover from achieving an original goal to its weakly dependent soft extension goals.
- Arrow (d) highlights a crucial rule: an extension use case generally does NOT impair its own original goal, EXCEPT when the extension serves a system-specific goal (like `SupportFlexibility` overriding an individual initiator's meeting).
- Arrow (e) exposes cross-extension interference — both positive (`Increase attendance` extending the date range also makes `MaxConvenientSchedule` satisfiable) and negative (`Keep appropriate performance` terminating negotiation makes `MaxConvenientSchedule` deniable).
-->

---

## 4.2 Use-Case-Level & System-Level Goal Interactions

<div class="two-col">
<div class="card">
<h3>Use-Case Level (w.r.t. specific <code>U<sub>k</sub></code>)</h3>
<div class="small-text">
Defined by boolean predicates <code>cp<sub>Uk</sub>(G<sub>i</sub>, G<sub>j</sub>)</code> and <code>cf<sub>Uk</sub>(G<sub>i</sub>, G<sub>j</sub>)</code>:<br><br>
• <strong>Conflicting</strong> (<code>cf<sub>Uk</sub> = True</code>): One goal increases while the other decreases after <code>U<sub>k</sub></code> (e.g., <code>satisfiable</code> vs. <code>deniable</code>).<br>
• <strong>Cooperative</strong> (<code>cp<sub>Uk</sub> = True</code>): Both increase (positively) or both decrease (negatively).<br>
• <strong>Irrelevant</strong> (both <code>False</code>): Neither changes.<br><br>
<em>Contrast with Boehm &amp; In's QARCC [17]:</em> QARCC analyzes domain-independent architecture/quality conflicts; GDUC analyzes <strong>domain-specific requirement conflicts</strong> via use cases.
</div>
</div>
<div class="card accent">
<h3>System Level: <code>R<sub>s</sub>(G<sub>i</sub>, G<sub>j</sub>) = ⟨cp, cf⟩</code></h3>
<div class="small-text">
Amalgamating related use cases yields <strong>four system-level relations</strong>:

| `R<sub>s</sub>(G<sub>i</sub>, G<sub>j</sub>)` | Meaning |
| :--- | :--- |
| `⟨False, False⟩` | **Irrelevant** |
| `⟨True, False⟩` | **Cooperative** |
| `⟨False, True⟩` | **Conflicting** |
| `⟨True, True⟩` | **Counterbalanced** |

By reflexivity, every goal cooperates with itself: <code>R<sub>s</sub>(G<sub>i</sub>, G<sub>i</sub>) = ⟨True, False⟩</code>.
</div>
</div>
</div>

<!--
Use-Case vs. System Level Semantics (pp. 98–99):
- At the use-case level, `make a convenient schedule` yields `satisfiable` for `MaxConvenientSchedule` and `deniable` for `AppropriatePerformance`, giving `cf_{make a convenient schedule}(MaxConvenientSchedule, AppropriatePerformance) = True`.
- At the system level, two goals can cooperate in one use case while conflicting in another; the pair ⟨cp, cf⟩ = ⟨True, True⟩ captures this nuanced "Counterbalanced" state instead of collapsing it prematurely.
- Distinction from QARCC (Boehm & In 1996): QARCC targets generic, domain-independent conflicts between architectural strategies and quality attributes (e.g., layered architecture improving portability at the expense of performance), whereas GDUC discovers requirement-level conflicts grounded in the target domain's concrete use cases.
-->

---

## 4.3 Formal System-Level Derivation Rules & Worked Proofs

Given original goals `G<sub>i</sub>, G<sub>j</sub>` (with UCs `U<sub>i</sub>, U<sub>j</sub>`) and extension goals `G<sub>i1</sub>, G<sub>j1</sub>` (with UCs `U<sub>i1</sub>, U<sub>j1</sub>`), GDUC defines **three formal derivation cases**:

<div class="formula-box">
<strong>Case 1 (Original–Original):</strong><br>
cp(G<sub>i</sub>, G<sub>j</sub>) = cp<sub>Ui</sub>(G<sub>i</sub>, G<sub>j</sub>) ∨ cp<sub>Uj</sub>(G<sub>i</sub>, G<sub>j</sub>) &nbsp;&nbsp;|&nbsp;&nbsp; cf(G<sub>i</sub>, G<sub>j</sub>) = cf<sub>Ui</sub>(G<sub>i</sub>, G<sub>j</sub>) ∨ cf<sub>Uj</sub>(G<sub>i</sub>, G<sub>j</sub>)<br>
<strong>Case 2 (Original–Extension, weak dependence on G<sub>j</sub>):</strong><br>
cp(G<sub>i</sub>, G<sub>j1</sub>) = cp(G<sub>i</sub>, G<sub>j</sub>) ∨ cp<sub>Ui</sub>(G<sub>i</sub>, G<sub>j1</sub>) ∨ cp<sub>Uj1</sub>(G<sub>i</sub>, G<sub>j1</sub>) &nbsp;&nbsp;(and analogously for cf)<br>
<strong>Case 3 (Extension–Extension):</strong><br>
cp(G<sub>i1</sub>, G<sub>j1</sub>) = cp(G<sub>i1</sub>, G<sub>j</sub>) ∨ cp(G<sub>i</sub>, G<sub>j1</sub>) ∨ cp<sub>Ui1</sub>(G<sub>i1</sub>, G<sub>j1</sub>) ∨ cp<sub>Uj1</sub>(G<sub>i1</sub>, G<sub>j1</sub>) &nbsp;&nbsp;(and analogously for cf)
</div>

<div class="two-col" style="margin-top: 8px;">
<div class="card teal">
<h3>Proof 1: <code>G<sub>MRS</sub></code> vs. <code>G<sub>MCS</sub></code> (Case 2)</h3>
<div class="small-text">
<code>cp(G<sub>MRS</sub>, G<sub>MCS</sub>) = cp(G<sub>MRS</sub>, G<sub>MRS</sub>) ∨ cp<sub>UPM</sub> ∨ cp<sub>UMCS</sub> = True</code><br>
<code>cf(G<sub>MRS</sub>, G<sub>MCS</sub>) = cf(G<sub>MRS</sub>, G<sub>MRS</sub>) ∨ cf<sub>UPM</sub> ∨ cf<sub>UMCS</sub> = False</code><br>
➔ <strong>Cooperative</strong> <code>⟨True, False⟩</code>
</div>
</div>
<div class="card accent">
<h3>Proof 2: <code>G<sub>MCS</sub></code> vs. <code>G<sub>AP</sub></code> (Case 3)</h3>
<div class="small-text">
<code>cp(G<sub>MCS</sub>, G<sub>AP</sub>) = cp(G<sub>MCS</sub>, G<sub>MRS</sub>) ∨ ... = False</code> (excl. base self)<br>
<code>cf(G<sub>MCS</sub>, G<sub>AP</sub>) = cf(G<sub>MCS</sub>, G<sub>MRS</sub>) ∨ cf(G<sub>AP</sub>, G<sub>MRS</sub>) ∨ cf<sub>UMCS</sub> ∨ cf<sub>UKAP</sub> = True</code><br>
➔ <strong>Conflicting</strong> <code>⟨False, True⟩</code>
</div>
</div>
</div>

<!--
Recursive System-Level Derivation Equations (pp. 98–99, Figure 5):
GDUC's derivation rules are cleanly stratified by weak dependence:
1. Original–Original (Gi, Gj): Checks cooperation/conflict over their respective original use cases Ui and Uj.
2. Original–Extension (Gi, Gj1): Because Gj1 is only achieved/optimized if its base original goal Gj is satisfied, the system-level relation Rs(Gi, Gj) must be included alongside use-case evaluations over Ui and Uj1. In Proof 1, since G_MCS extends G_MRS and cp(G_MRS, G_MRS) = True (reflexivity), G_MRS and G_MCS cooperate.
3. Extension–Extension (Gi1, Gj1): Combines cross-level interactions (Gi1 with Gj, and Gi with Gj1) plus direct extension use-case evaluations (Ui1 and Uj1). In Proof 2, evaluating `make a convenient schedule` (U_MCS) and `keep appropriate performance` (U_KAP) yields `cf(G_MCS, G_AP) = True`, rigorously proving the system-level conflict between convenience and performance.
-->

---

## 5. Benefits & Future Research Roadmap

<div class="two-col">
<div class="card">
<h3>Three Core Benefits of GDUC</h3>
<div class="small-text">
1. <strong>Structuring Mechanism</strong>: Systematically guides the derivation and modular organization of use-case specifications via faceted goals.<br><br>
2. <strong>Bridging Domain &amp; System</strong>: Connects high-level domain descriptions with functional and nonfunctional system requirements.<br><br>
3. <strong>Soft &amp; Conflicting Requirements</strong>: Makes soft NFRs explicit and provides a formal 3-step calculus to detect requirement conflicts early.
</div>
</div>
<div class="card teal">
<h3>Two Planned Extensions (Directly Realized in 2001!)</h3>
<div class="small-text">
<strong>1. Fuzzy Object-Oriented Modeling (FOOM):</strong><br>
Transition GDUC's goal interactions into the system-analysis object model to manage conflicting AND imprecise requirements using fuzzy objects.<br><br>
<strong>2. AHP Goal Prioritization:</strong><br>
Apply the <strong>Analytic Hierarchy Process (AHP)</strong> (Karlsson &amp; Ryan 1997; Saaty) to distinguish critical requirements from mere adornments for conflict resolution.
</div>
</div>
</div>

<div class="callout">
<strong>Historical Lineage:</strong> Both future directions proposed on p. 100 of this 1999 IEEE Software paper were directly fulfilled in the authors' follow-up <strong>2001 Information and Software Technology (IST)</strong> paper!
</div>

<!--
Conclusion & Research Continuity (pp. 99–100):
GDUC demonstrated that goals play a dual role in requirements acquisition: structuring use-case specifications and formally evaluating requirement interactions.
Notably, the paper's two concluding future-work commitments — (1) extending object-oriented analysis models with fuzzy logic to utilize GDUC's goal interactions, and (2) prioritizing goals via AHP — became the exact core contributions of Lee, Xue & Kuo (IST 2001, "Structuring requirement specifications with goals"), forming a cohesive multi-year research arc.
-->

---

<!-- _class: closing -->

# Thank You for Your Attention!

<p style="font-size: 1.05em; max-width: 860px;">
Analyzing User Requirements by Use Cases: A Goal-Driven Approach
</p>

<div class="contact-card">
<strong>Jonathan Lee</strong> &nbsp;·&nbsp; <code>yjlee@se01.csie.ncu.edu.tw</code><br>
<strong>Nien-Lin Xue</strong> &nbsp;·&nbsp; <code>nien@se01.csie.ncu.edu.tw</code><br>
Department of Computer Science and Information Engineering, National Central University, Taiwan<br>
<span style="font-size: 0.85em; opacity: 0.88;">IEEE Software, Vol. 16, No. 4 (July/August 1999), pp. 92–101 · Grants: NSC87-2213-E-008-024, NSC88-2213-E-008-006</span>
</div>

<!--
Archival Reference:
- Citation: J. Lee and N.-L. Xue, "Analyzing User Requirements by Use Cases: A Goal-Driven Approach," IEEE Software, Vol. 16, No. 4, pp. 92–101, July/August 1999.
- Publisher: IEEE Computer Society (0740-7459/99/$10.00 © 1999 IEEE).
- Funding: National Science Council (Taiwan) under grants NSC87-2213-E-008-024 and NSC88-2213-E-008-006.
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
