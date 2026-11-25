---
marp: true
theme: gaia
size: 16:9
paginate: true
html: true
header: '<div class="hdr-wrap"><span class="hdr-title">Structuring Requirement Specifications with Goals</span><div class="hdr-actions"><a class="lang-btn" href="./GoalReq_slide_zh.html" title="切換至繁體中文簡報">🌐 繁</a><div class="nav-dropdown"><button class="nav-btn">Sections ▾</button><div class="nav-menu"><a href="#2">Outline</a><a href="#3">1. Motivation &amp; Objectives</a><a href="#5">2. Related Work</a><a href="#6">3. Goal-Driven Use Cases</a><a href="#7">4. Goal Interactions</a><a href="#9">5. Goals Hierarchy &amp; FOOM</a><a href="#12">6. Conflict Resolution</a><a href="#14">7. Conclusion &amp; Future Work</a></div></div></div></div>'
footer: 'Jonathan Lee, Nien-Lin Xue & Jong-Yih Kuo · NCU & Fu-Jen Catholic University · IST 2001'
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
section.lead h1 { color: #ffffff; font-size: 2.05em; font-weight: 800; line-height: 1.24; margin-bottom: 16px; text-align: left; }
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
.split64 { display: grid; grid-template-columns: 56% 42%; gap: 2%; align-items: center; }
.split55 { display: grid; grid-template-columns: 49% 49%; gap: 2%; align-items: center; }
.split46 { display: grid; grid-template-columns: 42% 56%; gap: 2%; align-items: center; }

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
  margin: 8px 0;
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
  padding: 8px 14px;
  font-family: 'JetBrains Mono', monospace;
  font-size: 0.78em;
  line-height: 1.5;
  color: var(--slate-900);
  margin: 6px 0;
}

.small-text { font-size: 0.82em; }

@media print { .lang-btn, .nav-dropdown { display: none !important; } }
</style>

<!-- _class: lead -->

<div class="badge">Information and Software Technology (IST) · Vol. 43, pp. 121–135 · 2001</div>

# Structuring Requirement Specifications with Goals

<div class="subtitle">
Bridging <strong>Goal-Driven Use Cases</strong>, <strong>Nonfunctional Goal Interaction Analysis</strong>, and <strong>Fuzzy Object-Oriented Models (FOOM)</strong> to Handle Conflicting and Imprecise Requirements
</div>

<div class="meta-box">
<strong>Jonathan Lee<sup>a,*</sup></strong> &nbsp;·&nbsp; <code>yjlee@se01.csie.ncu.edu.tw</code><br>
<strong>Nien-Lin Xue<sup>a</sup></strong> &nbsp;·&nbsp; <code>nien@se01.csie.ncu.edu.tw</code> &nbsp;|&nbsp; <strong>Jong-Yih Kuo<sup>b</sup></strong><br>
<sup>a</sup> Software Engineering Laboratory, Dept. of CSIE, National Central University, Chungli, Taiwan<br>
<sup>b</sup> Dept. of CSIE, Fu-Jen Catholic University, HsinChuang, Taipei Hsien, Taiwan
</div>

<div class="grant">
Received 24 April 2000 · Revised 22 June 2000 · Accepted 18 July 2000 · Supported by National Science Council (Taiwan), Grant NSC88-2213-E-008-006
</div>

<!--
Bibliographic Metadata & Research Positioning:
- Paper Title: Structuring requirement specifications with goals
- Authors: Jonathan Lee (corresponding author), Nien-Lin Xue (National Central University), and Jong-Yih Kuo (Fu-Jen Catholic University).
- Venue: Information and Software Technology (IST), Vol. 43 (2001), pp. 121–135, Elsevier Science B.V.
- Research Lineage: This paper synthesizes and extends two foundational prior works by the same research group: Goal-Driven Use Cases (GDUC, Lee & Xue, IEEE Software 1999) and Fuzzy Object-Oriented Modeling (FOOM, Lee, Xue, Hsu & Yang, Information Sciences 1999). Whereas GDUC focused on eliciting and evaluating use cases with goals, this 2001 IST paper completes the pipeline all the way to structuring conflict-free Fuzzy Object-Oriented analysis models via a Goals Hierarchy, Stable Kernel, and systematic conflict-resolution strategies.
-->

---

## Outline

<div class="outline-grid">
<div class="outline-item">
<div class="outline-num">1</div>
<div class="outline-body"><a href="#3">Motivation, Gaps &amp; Objectives</a><br>Why goal-based RE needs UML use cases, NFR interaction analysis, and fuzzy OO modeling.</div>
</div>
<div class="outline-item">
<div class="outline-num">2</div>
<div class="outline-body"><a href="#5">Related Work &amp; Conflict Taxonomies</a><br>Goal-oriented RE (KAOS, NFR, GBRAM), conflict-handling families, and imprecise RE.</div>
</div>
<div class="outline-item">
<div class="outline-num">3</div>
<div class="outline-body"><a href="#6">Goal-Driven Use Cases (GDUC)</a><br>Three-facet goal classification (Competence, View, Content) and original vs. extension use cases.</div>
</div>
<div class="outline-item">
<div class="outline-num">4</div>
<div class="outline-body"><a href="#7">Evaluating Goal Interactions</a><br>Five use-case–goal predicates, side effects, and formal system-level interaction derivation.</div>
</div>
<div class="outline-item">
<div class="outline-num">5</div>
<div class="outline-body"><a href="#9">Goals Hierarchy, Kernel &amp; FOOM</a><br>Backtracking algorithm, AHP stable kernel selection, and five types of fuzziness in OO models.</div>
</div>
<div class="outline-item">
<div class="outline-num">6</div>
<div class="outline-body"><a href="#12">Conflict Resolution &amp; Conclusion</a><br>Three conflict roots, Prevention / Compromise / Competition, Meeting Scheduler integration, and future work.</div>
</div>
</div>

<!--
Structural Map of the Paper (Sections 1–6):
- Section 1 (Introduction): Motivates the integration of goal-based RE, UML use cases, and fuzzy object-oriented modeling, illustrated through the Meeting Scheduler benchmark.
- Section 2 (Related Work): Compares Dardenne et al., Mylopoulos et al., Anton (GBRAM), and Rolland et al., and classifies conflict-handling literature into Interaction, Design, and Structural conflicts alongside imprecise RE (RTA and Yen et al.).
- Section 3 (Structuring Use Cases with Goals): Presents the 3-step GDUC process (actors, faceted goals, original & extension use cases).
- Section 4 (Evaluating Goals Interactions): Formalizes 5 predicates between use cases and goals, use-case-level predicates cp/cf, and system-level interaction tuples Rs(Gi, Gj).
- Section 5 (Structuring FOOM Specifications): Introduces the Goals Hierarchy backtracking algorithm, Stable Kernel selection via cooperative degree and Saaty's AHP, FOOM constructs, and conflict resolution (Prevention, Compromise, Competition).
- Section 6 (Conclusion): Summarizes the four core benefits and outlines future directions (worth-oriented domains and university timetabling at NCU).
-->

---

## 1. Motivation & Three Gaps in Goal-Based RE

<div class="split55">
<div>

Why **goal-based requirements engineering**?
- Focuses on **why** a system is built, providing rationale to justify requirements.
- Supports progressive elaboration from organizational objectives to operational specs.
- Exposes multi-stakeholder conflicts early.

**Three persistent gaps in prior approaches:**
1. **No de facto standard notation** (e.g., UML), limiting adoption in large-scale systems.
2. **Goal interactions ignored in structuring** requirement specifications and analysis models.
3. **Imprecise & vague requirements** receive little formal support despite informality being inevitable.

</div>
<div class="fig-box">
<img src="./img/fig1_overview.png" style="max-height: 290px;">
<div class="fig-cap">Fig. 1. End-to-end overview of the proposed three-stage approach (Lee et al., IST 2001).</div>
</div>
</div>

<div class="callout">
<strong>Core Insight:</strong> Combine UML <strong>Use Cases</strong> (standard notation) + <strong>Goal Interaction Analysis</strong> (NFR trade-offs) + <strong>Fuzzy Object-Oriented Models</strong> (imprecision) into one coherent structuring pipeline.
</div>

<!--
Theoretical Motivation (Section 1):
Prior goal-oriented frameworks such as Dardenne et al. (KAOS), Mylopoulos et al. (NFR Framework), and Anton (GBRAM) demonstrated the value of goals for acquisition, justification, and conflict detection. However, they suffered from three structural limitations:
1. Lack of a de facto standard modeling language: Custom formalisms hinder industrial scalability compared to UML use cases and object models.
2. Disconnect between goal interaction analysis and specification structuring: Knowing that two NFRs conflict does not automatically tell analysts how to partition and incrementally build the object model without becoming overwhelmed by early conflict resolution.
3. Under-representation of imprecision: As Balzer et al. argued, informality and vagueness are inherent and even desirable in early specifications, yet crisp OO models force premature precision.

Fig. 1 traces the proposed three-stage pipeline:
- Stage 1: Use cases are extended with faceted goals (original & extension use cases) from domain descriptions and system requirements.
- Stage 2: Interactions between NFR goals are evaluated at use-case and system levels (conflicting, cooperative, irrelevant, counterbalanced).
- Stage 3: Interactions drive a Goals Hierarchy -> Stable Kernel (modeled in FOOM) -> incremental integration of conflicting alternatives via resolution strategies.
-->

---

## 1.2 Research Objectives & Comparison with Prior Goal-Based RE

Three core objectives illustrated on the **Meeting Scheduler** benchmark (Potts et al. 1994; van Lamsweerde et al. 1994 — turning a vague, contradictory mission statement into a structured specification):

| Dimension | Dardenne et al. [12] | Mylopoulos et al. [26] | Anton (GBRAM) [3] | **This Approach (Lee et al. 2001)** |
| :--- | :--- | :--- | :--- | :--- |
| **Types of Goals** | System goal, Privacy goal | Nonfunctional reqt., Satisficing, Argument | Achievement goal, Maintenance goal | **Rigid / Soft, Actor / System-specific, Functional / Nonfunctional** |
| **Roles of Goals** | Reqt. acquisition, Reqt. analysis | Nonfunctional reqt. analysis | Reqt. analysis, Reqt. evolution | **Use case structuring, Reqt. evolution, OO model structuring** |
| **Goal Relationships** | Conflicting | Support, Against | Dependent | **Conflicting, Cooperative, Irrelevant, Counterbalanced** |

<div class="callout teal">
<strong>Why Meeting Scheduler?</strong> Widely adopted RE benchmark whose requirements exhibit typical real-world ambiguity (e.g., "convenient schedule", "important participant") and sharp NFR trade-offs (convenience vs. performance, privacy vs. shared preferences).
</div>

<!--
Comparative Positioning (Table 1 & Section 2.1):
- Dardenne et al. (KAOS): Distinguishes nonoperational goals from operational constraints that restrict actions/objects to assign agent responsibilities.
- Mylopoulos et al. (NFR Framework): Treats NFRs as softgoals rarely satisfied in a binary sense; design decisions contribute positively or negatively, evaluated via a labeling procedure.
- Anton (GBRAM): Classifies goals into achievement goals (mapped to actions) and maintenance goals (mapped to NFRs), elaborated via obstacles and scenarios.
- Rolland et al.: Iteratively pairs goal discovery with scenario authoring to populate a requirement chunks hierarchy.
- Lee, Xue & Kuo's distinctive contribution: Unifies a three-facet goal taxonomy with standard UML use cases, derives four formal system-level interaction types, and directly uses those interactions to structure Fuzzy Object-Oriented Models (FOOM).
-->

---

## 2. Related Work: Conflict Taxonomies & Imprecise Requirements

<div class="three-col">
<div class="card">
<h3>1. Interaction Conflicts</h3>
<div class="small-text">
Satisfying one stakeholder requirement impairs another (e.g., librarian vs. patron loan period).<br><br>
• <strong>Oz</strong> (Robinson &amp; Fickas): pairwise detection, compromise, compensation, dissolution.<br>
• <strong>Viewpoints</strong> (Easterbrook): split inconsistent views into self-consistent hierarchy.<br>
• <strong>Divergence</strong> (Lamsweerde): temporal-logic boundary conflicts.
</div>
</div>
<div class="card accent">
<h3>2. Design Conflicts</h3>
<div class="small-text">
Two requirements cannot both be supported by one architecture (e.g., layered portability vs. performance).<br><br>
• <strong>QARCC / WinWin</strong> (Boehm &amp; In): Theory W stakeholder win-condition negotiation.<br>
• <strong>DRE</strong> (Vanwelkenhuysen): models design-property vs. requirement trade-offs as guidelines.
</div>
</div>
<div class="card teal">
<h3>3. Structural &amp; Imprecise RE</h3>
<div class="small-text">
• <strong>Structural Conflicts</strong> (Spaccapietra): same reality modeled as entity vs. attribute; resolved via generalization.<br><br>
• <strong>RTA</strong> (Lee &amp; Kuo 1998): Zadeh's test-score semantics + fuzzy and/or 4-level hierarchy.<br>
• <strong>Priority Trade-offs</strong> (Yen et al.): distance-wise conflict/cooperation degrees &amp; customer sacrifice ratios.
</div>
</div>
</div>

<div class="callout">
<strong>Key Takeaway:</strong> Existing conflict techniques either defer resolution indefinitely (Viewpoints) or demand heavy upfront negotiation (Oz, WinWin). Our framework isolates a <strong>conflict-free Stable Kernel</strong> first, then resolves remaining conflicts incrementally.
</div>

<!--
Literature Synthesis (Sections 2.2 & 2.3):
The paper organizes conflict-handling research into three orthogonal categories:
1. Interaction conflicts: Arise from competing stakeholder objectives. Oz automates negotiation via compromise, compensation (adding conflict-free requirements), and dissolution (replacing contentious items). Easterbrook's Viewpoints tolerate inconsistency by branching self-consistent viewpoints in an inheritance hierarchy. van Lamsweerde et al. formalize weak conflicts (divergences) under boundary conditions using real-time temporal logic and divergence patterns.
2. Design conflicts: Arise relative to an architectural choice rather than requirement definitions. Boehm's QARCC operates inside WinWin using Theory W ("making everyone a winner") to flag quality-attribute risks. Vanwelkenhuysen's Design Requirement Embedding (DRE) records trade-off histories between conceptual design properties and requirements.
3. Structural conflicts: Same domain concept represented differently across views (entity vs. attribute); Spaccapietra resolves these via formal correspondences and generalization rules.

For imprecise requirements (Section 2.3), Lee & Kuo's Requirements Trade-off Analysis (RTA) uses Zadeh's canonical form in test-score semantics and parameterized fuzzy and/or aggregation, while Yen et al. derive relative priority ratios from marginal willingness to sacrifice one requirement's satisfaction degree for another.
-->

---

## 3. Structuring Use Cases with Faceted Goals

<div class="split55">
<div>

**Three-Step Construction Process:**
1. **Identify Actors**: External roles interacting directly with the system (e.g., `Initiator`, `Participant`).
2. **Identify Goals via 3 Facets**:
   - **Competence**: `Rigid (R)` (must be 100% satisfied) vs. `Soft (S)` (satisfied to a degree; weakly dependent on rigid).
   - **View**: `Actor-specific (A)` vs. `System-specific (Y)`.
   - **Content**: `Functional (F)` (operation sequence) vs. `Nonfunctional (N)` (qualifying constraint).
3. **Build Use Case Models**:
   - **Original UC** ➔ achieves Original Goal `⟨R, A, F⟩` (Basic + Recovery/Failure courses).
   - **Extension UC** (`extends`) ➔ optimizes/maintains Soft (`E1`), achieves System-specific (`E2`), or achieves Nonfunctional (`E3`) goals.

</div>
<div class="fig-box">
<img src="./img/fig3_uc_model.png" style="max-height: 365px;">
<div class="fig-cap">Fig. 3. Goal-driven use case model for the Meeting Scheduler system.</div>
</div>
</div>

<!--
Goal-Driven Use Cases Mechanics (Section 3):
- Original Goals & Use Cases: Every original goal is strictly ⟨Rigid, Actor-specific, Functional⟩. Mapping each original goal to an original use case guarantees the specification satisfies at least all actors' minimum functional requirements. In the Meeting Scheduler, `Plan a meeting` achieves `MeetingRequestSatisfied (R, A, F)`. Its basic course covers the nominal path; alternative courses split into recovery courses (recovering from strong schedule conflicts) and failure courses (canceling the meeting when unrecoverable).
- Extension Goals & Use Cases: Extending Cockburn's goal-use case linkage, extension use cases are systematically created for three distinct reasons (Fig. 2 in the paper):
  * E1 (Soft goal): `Make a convenient schedule` optimizes `MaxConvenienceSchedule (S, A, N)`; `Increase attendance` maintains `MaxNumberOfParticipants (S, A, N)`.
  * E2 (System-specific goal): `Accommodate important meetings` achieves `SupportFlexibility (S, Y, F)` across all initiators rather than one actor's personal view.
  * E3 (Nonfunctional goal): `Keep appropriate performance` qualifies `Plan a meeting` with `AppropriatePerformance (S, A, N)`.
- Weak Dependence: An extension goal's existence depends on its original goal, yet satisfying the original goal does not guarantee full satisfaction of extension goals (except partial satisfaction for soft goals).
-->

---

## 4. Evaluating Goal Interactions: Use-Case Level & Side Effects

<div class="split55">
<div>

Adopted 5 predicates (extending Mylopoulos et al.) to classify how performing use case `U<sub>k</sub>` affects goal `G`:
- `satisfied` / `denied`: utterly achieved or ceased.
- `satisfiable` / `deniable`: achieved or impaired to a degree.
- `independent`: unaffected by `U<sub>k</sub>`.

**Direct Effects vs. Three Side-Effect Paths (Fig. 4):**
- **(a), (b) Direct**: Original/Extension UC achieves, optimizes, or maintains its own goal.
- **(c) Original ➔ Extension**: Succeeding `Plan a meeting` partially satisfies `MaxConvenienceSchedule` (`satisfiable`).
- **(d) Extension ➔ Original**: `Accommodate important meetings` may cancel a lower-priority meeting (`denied`).
- **(e) Extension ➔ Other Extension**: `Keep appropriate performance` halts convenience negotiation (`deniable`).

</div>
<div class="fig-box">
<img src="./img/fig4_interactions.png" style="max-height: 360px;">
<div class="fig-cap">Fig. 4. Direct effects (a, b) and side effects (c, d, e) between use cases and goals.</div>
</div>
</div>

<!--
Use-Case–Goal Predicates and Use-Case-Level Interactions (Sections 4.1 & 4.2):
A use case is designed for its directly associated goal, yet executing it frequently alters non-associated goals through side effects (arrows c, d, e in Fig. 4).
From these 5 predicates, pairwise goal interactions at the use-case level (with respect to a specific use case Uk) are derived via two boolean predicates:
- cp_Uk(Gi, Gj) = True (Cooperative): both Gi and Gj increase in satisfaction (positively cooperative) or both decrease (negatively cooperative) after Uk executes.
- cf_Uk(Gi, Gj) = True (Conflicting): one goal's satisfaction increases (satisfied/satisfiable) while the other's decreases (denied/deniable) after Uk executes.
- Both False (Irrelevant): satisfaction degrees remain unchanged.

Worked Example: For Uk = `make a convenient schedule`, its relationship with `MaxConvenienceSchedule` is `satisfiable` while its relationship with `AppropriatePerformance` is `deniable`. Hence cf_UMCS(MaxConvenienceSchedule, AppropriatePerformance) = True.
-->

---

## 4.2 Formal Derivation of System-Level NFR Interactions

At the **system level**, related use cases are amalgamated; interactions between two nonfunctional goals `G<sub>i1</sub>` and `G<sub>j1</sub>` are captured by the predicate pair `R<sub>s</sub>(G<sub>i1</sub>, G<sub>j1</sub>) = ⟨cp(G<sub>i1</sub>, G<sub>j1</sub>), cf(G<sub>i1</sub>, G<sub>j1</sub>)⟩`:

<div class="two-col">
<div class="card">
<h3>Four System-Level Interaction Types</h3>

| `R<sub>s</sub>(G<sub>i</sub>, G<sub>j</sub>)` | System-Level Relation |
| :--- | :--- |
| `⟨False, False⟩` | **Irrelevant** |
| `⟨True, False⟩` | **Cooperative** |
| `⟨False, True⟩` | **Conflicting** |
| `⟨True, True⟩` | **Counterbalanced** |

</div>
<div class="card accent">
<h3>Formal Disjunction Across Base &amp; Extension UCs</h3>
<div class="small-text">Because extension goals weakly depend on their original goals `G<sub>i</sub>`, `G<sub>j</sub>`, system-level derivation aggregates all four use cases (`U<sub>i</sub>, U<sub>j</sub>, U<sub>i1</sub>, U<sub>j1</sub>`):</div>
<div class="formula-box">
cp(G<sub>i1</sub>, G<sub>j1</sub>) = cp<sub>Ui</sub> ∨ cp<sub>Uj</sub> ∨ cp<sub>Ui1</sub> ∨ cp<sub>Uj1</sub><br>
cf(G<sub>i1</sub>, G<sub>j1</sub>) = cf<sub>Ui</sub> ∨ cf<sub>Uj</sub> ∨ cf<sub>Ui1</sub> ∨ cf<sub>Uj1</sub>
</div>
</div>
</div>

<div class="callout teal">
<strong>Worked Derivation (`G<sub>MCS</sub>` vs. `G<sub>AP</sub>`):</strong> Evaluating over `U<sub>PM</sub>` (plan a meeting), `U<sub>MCS</sub>` (make convenient schedule), and `U<sub>KAP</sub>` (keep appropriate performance) yields <code>cp(G<sub>MCS</sub>, G<sub>AP</sub>) = False</code> and <code>cf(G<sub>MCS</sub>, G<sub>AP</sub>) = True</code> ➔ <strong>Conflicting</strong> at the system level.
</div>

<!--
System-Level Aggregation Semantics (Section 4.3):
Ebert (1998) noted that severe trade-offs occur predominantly among nonfunctional requirements. Therefore, Section 4.3 focuses system-level analysis on NFR goal pairs (Gi1, Gj1) associated with extension use cases Ui1 and Uj1, which extend original use cases Ui and Uj (Fig. 5 in the paper).
Why include Ui and Uj in the disjunction? Because Gi1 is optimized or maintained only when its base original goal Gi is satisfied; thus any cooperative or conflicting effect induced by the base use cases Ui or Uj must propagate to the system-level relationship.
Notice the crucial distinction of the fourth state, Counterbalanced ⟨True, True⟩: two goals can cooperate in one use case while conflicting in another! Both Conflicting and Counterbalanced pairs are prohibited from coexisting in the same conflict-free alternative in Section 5.1.
-->

---

## 5.1 Establishing a Goals Hierarchy (Conflict-Free Alternatives)

<div class="split55">
<div>

Instead of resolving all conflicts upfront (which overloads analysts), partition goals into **conflict-free alternatives** satisfying 3 constraints:
1. Within any alternative `A`, every pair `(G<sub>i</sub>, G<sub>j</sub>)` is **cooperative** or **irrelevant**.
2. Any two alternatives `A<sub>i</sub>, A<sub>j</sub>` contain at least one **conflicting** or **counterbalanced** pair.
3. Maximality: any external goal `G<sub>i</sub> ∉ A<sub>k</sub>` conflicts/counterbalances with some `G<sub>k</sub> ∈ A<sub>k</sub>`.

**Backtracking Algorithm (Section 5.1):**
- Place all **functional goals** at the root (included in every alternative).
- Depth-first add non-conflicting NFRs as children.
- Backtrack when a remaining NFR conflicts with the current node (but not ancestors) to branch a sibling alternative.

</div>
<div class="fig-box">
<img src="./img/fig7_goals_hierarchy.png" style="max-height: 315px;">
<div class="fig-cap">Fig. 7. Goals hierarchy for the Meeting Scheduler yielding two conflict-free alternatives (A<sub>1</sub> and A<sub>2</sub>).</div>
</div>
</div>

<!--
Goals Hierarchy Algorithm & Completeness (Section 5.1):
Each root-to-leaf path in the Goals Hierarchy corresponds to one maximal conflict-free set of requirements (an alternative).
In the paper's generic illustration (Fig. 6), functional goals G_FG form the root, and backtracking over NFRs G2–G6 yields three alternatives: {G_FG, G2, G3, G5}, {G_FG, G2, G6}, and {G_FG, G4, G3, G5}.
Applied to the Meeting Scheduler (Fig. 7):
- Root functional goals: G_MRS (MeetingRequestSatisfied) and G_PD (ParticipantDelegated).
- Alternative A1 = {G_MRS, G_PD, G_MCS, G_MNOP, G_SF} (prioritizes convenience, attendance, and flexibility).
- Alternative A2 = {G_MRS, G_PD, G_AP, G_MI} (prioritizes appropriate performance and minimal interaction).
Because every alternative is guaranteed conflict-free, analysts can immediately construct a clean baseline model without premature trade-off paralysis.
-->

---

## 5.2 Selecting a Stable Kernel via Cooperative & Importance Degrees

<div class="two-col">
<div class="card">
<h3>What Is a Stable Kernel?</h3>
<div class="small-text">
• Contains <strong>all functional requirements</strong> plus a conflict-free subset of NFRs (only cooperative or irrelevant pairs).<br><br>
• <strong>Stable</strong> because it requires zero upfront conflict resolution and serves as a clean foundation for incremental refinement.<br><br>
• Selected from the Goals Hierarchy alternatives using two quantitative criteria.
</div>
</div>
<div class="card accent">
<h3>Two Selection Criteria</h3>
<div class="small-text">
<strong>1. Cooperative Degree:</strong> Total number of cooperative interactions among goals inside an alternative (e.g., `1` if `G<sub>3</sub>` and `G<sub>5</sub>` cooperate).<br><br>
<strong>2. Importance Degree (Saaty's AHP):</strong> Sum of absolute goal weights computed via pairwise comparison reciprocal matrix &amp; normalized principal eigenvector.
</div>
</div>
</div>

<div class="callout teal">
<strong>Meeting Scheduler Decision (Fig. 7):</strong> Alternatives <code>A<sub>1</sub></code> and <code>A<sub>2</sub></code> tie in cooperative degree. Applying Saaty's AHP importance weights shows <code>Importance(A<sub>1</sub>) &gt; Importance(A<sub>2</sub>)</code> ➔ <strong><code>A<sub>1</sub> = {G<sub>MRS</sub>, G<sub>PD</sub>, G<sub>MCS</sub>, G<sub>MNOP</sub>, G<sub>SF</sub>}</code></strong> is selected as the <strong>Stable Kernel</strong>.
</div>

<!--
Quantitative Kernel Selection (Section 5.2):
Choosing which maximal conflict-free alternative becomes the Stable Kernel is governed by a two-tier evaluation:
1. Cooperative Degree: Rewards alternatives whose NFRs mutually reinforce one another (higher synergy, fewer internal tensions).
2. Importance Degree: When alternatives have equal cooperative degrees (as A1 and A2 do in the Meeting Scheduler), stakeholder priorities break the tie rigorously using Thomas Saaty's Analytic Hierarchy Process (AHP, 1982). Analysts elicit pairwise relative weights between goals to build a reciprocal matrix, then extract the normalized eigenvector via the eigenvalue method to obtain absolute weights. Summing the weights of goals in each alternative identifies the highest-value conflict-free kernel.
-->

---

## 5.2 Modeling the Kernel with Fuzzy Object-Oriented Models (FOOM)

<div class="split46">
<div class="small-text">

To capture vague requirements inside the Stable Kernel, **FOOM** introduces **5 types of fuzziness**:
1. **Fuzzy Classes**: Imprecise boundaries (e.g., `ImportantParticipant`) encapsulating static properties (attributes/ops) &amp; dynamic properties (fuzzy rules).
2. **Fuzzy Attribute Ranges**: Linguistic terms (`young`) or **typical values**: `status: {student/0.4, staff/0.7, faculty/1}`.
3. **Fuzzy Rules**: Internal attribute constraints (e.g., *if role is staff ➔ less important*) or inter-class triggers.
4. **Perceptual Fuzziness (`ISA` / `AKO`)**: Implicit membership in `[0, 1]` from static + dynamic properties.
5. **Uncertain Fuzzy Associations**: Quadruple canonical form:
   `(preference, ⟨John, L102⟩, strong, very true)` + soft constraints.

</div>
<div class="fig-box">
<img src="./img/fig8_kernel_model.png" style="max-height: 390px;">
<div class="fig-cap">Fig. 8. Stable Kernel modeled in FOOM notation (G<sub>MRS</sub>, G<sub>PD</sub>, G<sub>MCS</sub>).</div>
</div>
</div>

<!--
FOOM Formal Constructs (Sections 5.2.1–5.2.3):
- Distinction between Imprecision and Uncertainty (Dubois & Prade 1988): Imprecision is the absence of a sharp boundary on an attribute value (modeled via linguistic degrees of participation, e.g., `strong`), whereas uncertainty reflects reliance/confidence in that information (modeled via fuzzy truth values `t` such as `true`, `fairly true`, `very true`).
- Uncertain Fuzzy Association Quadruple: `(link attribute, ⟨x, y⟩, degree of participation, t)`. For example, `(preference, ⟨John, L102⟩, strong, very true)` captures both the strength of John's preference for room L102 and the system's confidence in that observation.
- Crisp vs. Fuzzy Classes: Even a crisp class like `MeetingRegistration` may own an attribute with a fuzzy range (`participant importance`). Conversely, `ImportantParticipant` is a fuzzy class whose `ISA` membership degree is implicitly derived from static `status` and dynamic `role`.
- Soft Constraints: Requirements like "a meeting location should be as convenient as possible for all important participants" are modeled as soft constraints spanning the `prefer` and `take place` associations (Fig. 8).
-->

---

## 5.3 Conflict Roots & Three Resolution Strategies

Once the Stable Kernel is built, remaining goals from other alternatives conflict with the kernel. Resolution begins by diagnosing the **root cause**:

<div class="fig-box" style="margin: 6px 0;">
<img src="./img/conflict_resolution_map.svg" style="max-height: 335px;">
<div class="fig-cap">Taxonomy of 3 conflict roots mapped to Prevention, Compromise (Specialization), and Competition strategies.</div>
</div>

<div class="callout">
<strong>Priority Rule:</strong> Always attempt <strong>Prevention</strong> first (arbitrator or alternative use case), then <strong>Compromise</strong> (disjoint subclass specialization), and use <strong>Competition</strong> only when one goal clearly dominates in both importance <code>P(G)</code> and avoided impairment <code>I<sub>G2</sub>(G<sub>1</sub>)</code>.
</div>

<!--
Root Causes & Resolution Mechanics (Sections 5.3.1 & 5.3.2):
1. Competing Resources: Mutually exclusive resources (e.g., library books desired long-term by patrons vs. kept available by librarians). Resolved via Prevention (introduce a Book Arbitrator) or Compromise (specialize `Patron` into `Student` [2 weeks] and `Faculty` [as needed], or `Books` into `ReservedBook` and `UnreservedBook`, Fig. 10).
2. Divergent Expectations: Opposite expectations on a common property, behavior, or relationship (e.g., `ParticipantPreferenceKnown` vs. `ParticipantPrivacy`). Resolved via Compromise by specializing `Participant` into `PrivilegedParticipant` and `NonPrivilegedParticipant`.
3. Side Effects: Executing a use case for one goal impairs an unrelated goal (e.g., `Accommodate important meetings` canceling a meeting impairs `MeetingRequestSatisfied`). Resolved via Prevention by designing an alternative use case (Fig. 9: exclude conflicting schedules out of date range so no meeting is canceled), or via Compromise/Competition.
-->

---

## 5.3 Case Study: Integrating Alternatives in Meeting Scheduler

<div class="split55">
<div>

**Competition vs. Compromise Decision Matrix (Table 2)** for `G<sub>MCS</sub>` (Convenience) vs. `G<sub>AP</sub>` (Performance):

| Degree of Impairment | Importance | Strategy |
| :--- | :--- | :--- |
| `I<sub>GAP</sub>(G<sub>MCS</sub>) &gt; I<sub>GMCS</sub>(G<sub>AP</sub>)` | `P(G<sub>MCS</sub>) &gt; P(G<sub>AP</sub>)` | **Competition**: select `G<sub>MCS</sub>` |
| `I<sub>GAP</sub>(G<sub>MCS</sub>) &gt; I<sub>GMCS</sub>(G<sub>AP</sub>)` | `P(G<sub>MCS</sub>) &lt; P(G<sub>AP</sub>)` | **Compromise** (specialize) |
| `I<sub>GAP</sub>(G<sub>MCS</sub>) &lt; I<sub>GMCS</sub>(G<sub>AP</sub>)` | `P(G<sub>MCS</sub>) &gt; P(G<sub>AP</sub>)` | **Compromise** (specialize) |
| `I<sub>GAP</sub>(G<sub>MCS</sub>) &lt; I<sub>GMCS</sub>(G<sub>AP</sub>)` | `P(G<sub>MCS</sub>) &lt; P(G<sub>AP</sub>)` | **Competition**: select `G<sub>AP</sub>` |

**Resulting OO Specializations (Figs. 11–12):**
- `Meeting` ➔ `ProfessionalMeeting` (max convenience) &amp; `PrivateMeeting` (fast scheduling / performance).
- `SupportFlexibility` ➔ prevented cancellation via alternative date-exclusion UC.

</div>
<div class="fig-box">
<img src="./img/fig12_integrating.png" style="max-height: 360px;">
<div class="fig-cap">Fig. 12. Step-by-step integration of G<sub>MNOP</sub>, G<sub>SF</sub>, and G<sub>AP</sub> into the Meeting Scheduler kernel.</div>
</div>
</div>

<!--
Formal Impairment & Integration Walkthrough (Section 5.3.2.3 & Fig. 12):
- Impairment Notation: I_G2(G1) denotes the degree of impairment suffered by G1 when G2 is satisfied. If I_G2(G1) > I_G1(G2), achieving G1 incurs less overall impairment than achieving G2.
- Note on Table 2 Typography in Original Paper: Table 2 in the 2001 IST print lists G_MRS in cells where the caption and prose (p. 134) explicitly analyze G_MCS (MaxConvenientSchedule) vs. G_AP (AppropriatePerformance). Both importance P(G) and impairment I must align to justify Competition; when they disagree (e.g., G_MCS is more important yet satisfying it severely impairs G_AP), neither goal can be neglected, triggering Compromise via class specialization (`Meeting` -> `ProfessionalMeeting` / `PrivateMeeting`, Fig. 11).
- Fig. 12 illustrates the incremental integration flow: starting from the Stable Kernel, `MaxNumberOfParticipants` (no conflict) integrates directly; `SupportFlexibility` is integrated via Prevention (alternative use case without cancellation); and `AppropriatePerformance` is integrated via Compromise (specializing `Meeting`).
-->

---

## 6. Discussion, Contributions & Future Directions

<div class="two-col">
<div class="card">
<h3>Four Core Contributions</h3>
<div class="small-text">
1. <strong>Goal-Driven Structuring</strong>: Bridges UML use cases and object models via faceted goals.<br>
2. <strong>Domain-to-System Bridge</strong>: Formally connects functional and nonfunctional requirement interactions.<br>
3. <strong>Incremental Conflict Management</strong>: Goals Hierarchy + Stable Kernel avoids upfront negotiation overload.<br>
4. <strong>Imprecision Support</strong>: Extends OO specifications with FOOM (fuzzy classes, typical values, rules, uncertain links).
</div>
</div>
<div class="card teal">
<h3>Limitations &amp; Future Research</h3>
<div class="small-text">
• <strong>Code-Level Mapping</strong>: Mapping FOOM to executable code requires programming languages with native fuzzy sets, rules, and inference (Footnote 2).<br>
• <strong>Dynamic Behavior Evaluation</strong>: Investigate Rosenschein's <em>worth-oriented domain</em> to evaluate statechart dynamics without executing them.<br>
• <strong>Real-World Scale-Up</strong>: Apply the framework to the <strong>National Central University (NCU) timetabling system</strong> case study.
</div>
</div>
</div>

<div class="callout">
<strong>Enduring Impact:</strong> Demonstrated that <strong>requirements conflicts should drive object-model architecture</strong> (via stable kernels and subclass specialization) rather than remaining isolated in textual negotiation logs.
</div>

<!--
Conclusion, Practical Constraints & Future Agenda (Section 6 & Footnote 2):
- Key Philosophical Contribution: Rather than treating goal-oriented RE and object-oriented analysis as separate worlds, Lee, Xue & Kuo fuse them so that goal interactions directly dictate the modular structure of the resulting FOOM specification.
- Practical Implementation Note (Footnote 2, p. 124): Transitioning from FOOM analysis specifications down to implementation requires language-level support for fuzzy membership functions, fuzzy rule encapsulation, and fuzzy inference engines.
- Two Planned Next Steps:
  1. Worth-oriented domain (Rosenschein & Zlotkin 1994) for evaluating dynamic object behaviors (statecharts) analytically without full simulation/execution.
  2. Large-scale empirical validation on National Central University's real-world university timetabling problem, which involves complex multi-stakeholder soft constraints and competing room/time resources.
-->

---

<!-- _class: closing -->

# Thank You for Your Attention!

<p style="font-size: 1.05em; max-width: 860px;">
Structuring Requirement Specifications with Goals
</p>

<div class="contact-card">
<strong>Jonathan Lee<sup>a,*</sup></strong> &nbsp;·&nbsp; <code>yjlee@se01.csie.ncu.edu.tw</code><br>
<strong>Nien-Lin Xue<sup>a</sup></strong> &nbsp;·&nbsp; <code>nien@se01.csie.ncu.edu.tw</code> &nbsp;|&nbsp; <strong>Jong-Yih Kuo<sup>b</sup></strong><br>
<sup>a</sup> National Central University &nbsp;·&nbsp; <sup>b</sup> Fu-Jen Catholic University, Taiwan<br>
<span style="font-size: 0.85em; opacity: 0.88;">Information and Software Technology, Vol. 43 (2001), pp. 121–135 · Grant: NSC88-2213-E-008-006</span>
</div>

<!--
Archival Reference:
- Citation: J. Lee, N.-L. Xue, J.-Y. Kuo, "Structuring requirement specifications with goals," Information and Software Technology, Vol. 43, No. 2, pp. 121–135, 2001.
- PII: S0950-5849(00)00144-0, Elsevier Science B.V.
- Keywords: Requirements engineering; Conflicting requirements; Goals; Fuzzy object-oriented model.
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
