---
marp: true
theme: gaia
size: 16:9
paginate: true
html: true
header: '<div class="hdr-wrap"><span class="hdr-title">Evolutionary Agents for Intelligent Transport Systems</span><div class="hdr-actions"><a class="lang-btn" href="./ITS_slide_zh.html" title="切換至繁體中文簡報">🌐 繁</a><div class="nav-dropdown"><button class="nav-btn">Sections ▾</button><div class="nav-menu"><a href="#2">Outline</a><a href="#3">1. Motivation &amp; Issues</a><a href="#4">2. Related Work</a><a href="#5">3. Evolutionary Agent Model</a><a href="#7">4. Evolution Mechanism</a><a href="#10">5. Case Study &amp; Results</a><a href="#13">6. Discussion &amp; Conclusion</a></div></div></div></div>'
footer: 'Jong Yih Kuo, Shin Jie Lee, Chia Ling Wu, Nien Lin Hsueh & Jonathan Lee · IJFS 2005'
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
section.lead .meta-box { border-left: 4px solid #f43f5e; padding-left: 18px; color: #e2e8f0; font-size: 0.84em; line-height: 1.6; }
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
  border-radius: 12px; padding: 18px 36px; font-size: 0.83em; line-height: 1.66; color: #f8fafc;
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

table { width: 100%; border-collapse: collapse; font-size: 0.73em; margin: 8px 0; background: #ffffff; border: 1px solid var(--slate-200); }
th { background: var(--navy); color: #ffffff; font-weight: 700; padding: 6px 9px; text-align: left; border: 1px solid var(--navy); }
td { padding: 5px 9px; border: 1px solid var(--slate-200); vertical-align: middle; line-height: 1.34; }
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

<div class="badge">International Journal of Fuzzy Systems (IJFS) · Vol. 7, No. 2 · June 2005</div>

# Evolutionary Agents for Intelligent Transport Systems

<div class="subtitle">
Integrating <strong>Fuzzy Soft Goals</strong>, <strong>OWL / RuleML Ontological Reasoning</strong>, and <strong>Genetic + SOM Multi-Agent Evolution</strong> for Adaptive Traveler Information Systems
</div>

<div class="meta-box">
<strong>Jong Yih Kuo</strong>, <strong>Shin Jie Lee</strong>, <strong>Chia Ling Wu</strong>, <strong>Nien Lin Hsueh</strong>, and <strong>Jonathan Lee</strong><br>
Keywords: Intelligent Agent · Evolutionary Computation · Intelligent Transportation Systems (ITS)<br>
Published in <em>International Journal of Fuzzy Systems</em>, Vol. 7, No. 2, pp. 85–92, June 2005
</div>

<div class="grant">
Partially sponsored by the National Science Council (NSC93-2213-E-030-008) and the Ministry of Education (EX-91-E-FA06-4-4), Taiwan.
</div>

<!--
Bibliographic & Research Overview:
This journal article by Jong Yih Kuo, Shin Jie Lee, Chia Ling Wu, Nien Lin Hsueh, and Jonathan Lee, published in the International Journal of Fuzzy Systems (Vol. 7, No. 2, pp. 85 to 92, June 2005), proposes a unified evolutionary multi-agent framework for Intelligent Transportation Systems (ITS).

Core Contribution:
Newly instantiated software agents start with limited knowledge and low problem-solving capability. To enable agents to adapt dynamically in distributed ITS environments, the authors combine four complementary pillars: (1) a BDI-inspired four-module agent architecture, (2) Goal-Driven Use Cases (GDUC) with Zadeh's test-score semantics for fuzzy soft/rigid goals, (3) OWL and RuleML ontological reasoning for sub-goal refinement, and (4) a five-state multi-agent evolution cycle using Sugeno fuzzy inference, SOM-based selection, and inter-/intra-agent genetic restructuring, validated on a live Web-service-based ATIS hotel recommendation prototype.
-->

---

## Outline

<div class="outline-grid">
<div class="outline-item">
<div class="outline-num">1</div>
<div class="outline-body"><a href="#3">Motivation &amp; Core Agent Evolution Issues</a><br>Why distributed ITS needs self-evolving multi-agent systems and four design pillars.</div>
</div>
<div class="outline-item">
<div class="outline-num">2</div>
<div class="outline-body"><a href="#4">Related Work: MAS for ITS &amp; Evolution</a><br>Survey of Soft DNA, InforMirror, UTC agents, EIA, mobile dynamic objects, and fuzzy GA agents.</div>
</div>
<div class="outline-item">
<div class="outline-num">3</div>
<div class="outline-body"><a href="#5">Evolutionary Agent Model (BDI + GDUC)</a><br>Four-module architecture, OWL ontologies, and Zadeh test-score fuzzy goal modeling.</div>
</div>
<div class="outline-item">
<div class="outline-num">4</div>
<div class="outline-body"><a href="#7">Fuzzy, Ontology &amp; Genetic Evolution</a><br>Sugeno controller (9 heuristic rules), OWL/RuleML sub-goal refinement, SOM selection &amp; GA cycle.</div>
</div>
<div class="outline-item">
<div class="outline-num">5</div>
<div class="outline-body"><a href="#10">Case Study: ATIS Hotel Recommendation</a><br>Web-service architecture (JSP, TPWS, AEM, ORM, WSS), UI prototype, and 13-scenario benchmarks.</div>
</div>
<div class="outline-item">
<div class="outline-num">6</div>
<div class="outline-body"><a href="#13">Discussion, Limitations &amp; Takeaways</a><br>Architectural strengths, evaluation boundaries, and concluding contributions.</div>
</div>
</div>

<!--
Structural Map of the Paper:
Section 1 (Introduction, p. 85) motivates Multi-Agent Systems (MAS) for geographically and functionally distributed ITS and defines four foundational requirements for agent evolution.
Section 2 (Related Work, pp. 85 to 86) reviews MAS frameworks in ITS (2.1) and evolutionary agent algorithms (2.2).
Section 3 (Evolutionary Agent Model, pp. 86 to 89) presents the BDI-based 4-module agent architecture (3.1), Goal-Driven Use Case analysis (3.2), and fuzzy soft/rigid goal formulation (3.3).
Section 4 (Agent Evolution Mechanism, pp. 89 to 90) details the Sugeno fuzzy reasoning model (4.1), OWL/RuleML goal-driven ontology reasoning (4.2), and the 5-state evolution life cycle with SOM selection and GA restructuring (4.3).
Section 5 (Case Study, pp. 90 to 91) implements an ATIS hotel/snack/scenery recommendation system over Web Services and reports 13 simulation scenarios (Table 3).
Section 6 (Conclusion, p. 91) summarizes contributions.
-->

---

## 1. Motivation: Why Evolving Multi-Agent Systems for ITS?

Modern cities face daily traffic congestion, accidents, delays, and emissions. **Intelligent Transportation Systems (ITS)** combine AI, control, and communications across geographically and functionally distributed entities—making **Multi-Agent Systems (MAS)** an ideal paradigm.

<div class="two-col" style="margin-top: 8px;">
<div class="card accent">
<h3>The Cold-Start Problem of New Agents</h3>
<ul class="small-text">
<li>When agents are initially created, they possess <strong>minimal knowledge, limited experience, and low capability</strong>.</li>
<li>Static agents cannot adapt their negotiation strategies or travel recommendations to dynamic user preferences and changing road/service environments.</li>
</ul>
</div>
<div class="card teal">
<h3>Four Essential Issues in Agent Evolution</h3>
<ol class="small-text">
<li><strong>Suitable Agent Structure:</strong> Modular mental architecture supporting evolutionary restructuring.</li>
<li><strong>Internal Evolution Mechanisms:</strong> Fuzzy + ontological reasoning to refine goals and beliefs.</li>
<li><strong>Social Multi-Agent Concerns:</strong> Coordination, negotiation, and inter-agent exchange.</li>
<li><strong>Fitness Evaluation Tools:</strong> Quantifying agent adaptability and survival across generations.</li>
</ol>
</div>
</div>

<!--
Problem Statement (Section 1):
In ITS services—such as route guidance, travel recommendation, traffic information provision, and vehicle assistance control—software agents act autonomously on behalf of travelers. However, newly spawned agents lack domain maturity. Addressing the four structural, reasoning, social, and evaluation pillars simultaneously is necessary so agents can evolve both their internal knowledge/beliefs and their structural plan modules over successive generations.
-->

---

## 2. Related Work: MAS in ITS & Evolutionary Agents

<div class="two-col">
<div class="card">
<h3>2.1 Multi-Agent Frameworks for ITS</h3>
<ul class="small-text">
<li><strong>Soft DNA (Kohata et al.):</strong> Dynamic role allocation via FAMOUS &amp; Conceptual Fuzzy Sets.</li>
<li><strong>InforMirror (Kase et al.):</strong> Internet-based agent assistance for in-car navigation.</li>
<li><strong>Driver Behavior &amp; Forecast (Rossetti et al.; Wahle et al.):</strong> Microscopic simulation and anticipatory traffic reaction models.</li>
<li><strong>Decentralized Traffic Control (Ferreira et al.; Roozemond):</strong> Intersection agents (ITSA), authority agents, and road segment agents (RSA).</li>
<li><strong>Architecture-Centric MAS (Park et al.):</strong> Architectural styles/patterns for transport info prototypes.</li>
</ul>
</div>
<div class="card teal">
<h3>2.2 Agent Evolution Mechanisms</h3>
<ul class="small-text">
<li><strong>GA Behavior Sequences (Maskell &amp; Wilby):</strong> Evolving agent control code to adapt to local network changes.</li>
<li><strong>Evolutionary Intelligent Agents (Cristea et al.):</strong> Task-dependent genotype-driven evolution preserving variety.</li>
<li><strong>Dynamic Mobile Objects (Tanaka et al.):</strong> Attaching, serializing, and migrating dynamic objects across hosts.</li>
<li><strong>Real-Time Fuzzy Behavior Evolution (Bonarini):</strong> Evolutionary + RL learning of fuzzy behavior modules.</li>
<li><strong>Fuzzy Rule Extraction Agents (Wang et al.):</strong> Parent and offspring fuzzy agents competing via an arbitrator on accuracy &amp; interpretability.</li>
</ul>
</div>
</div>

<!--
Literature Positioning (Section 2):
Prior ITS multi-agent frameworks excel at decentralized traffic signaling and driver advisories, while prior evolutionary agent systems apply Genetic Algorithms, dynamic objects, or fuzzy rule learning independently. However, none tightly couple (a) formal Goal-Driven Use Cases with elastic fuzzy soft goals, (b) Semantic Web OWL/RuleML ontology refinement, and (c) SOM-guided genetic restructuring inside a unified BDI agent life cycle—the exact gap targeted by this paper.
-->

---

## 3. Evolutionary Agent Architecture (BDI + 4 Modules)

<div class="split55">
<div>
<p class="small-text">Grounded in the <strong>BDI (Belief–Desire–Intention)</strong> formalism (Rao &amp; Georgeff), each agent integrates four tightly coupled modules:</p>
<ol class="small-text">
<li><strong>Ontology Management Module:</strong> Stores <strong>domain-specific ontology</strong> (e.g., OWL schema for Hotel: <code>name</code>, <code>roomType</code>, <code>price</code>, <code>address</code>, <code>phone</code>) and <strong>issue-specific ontology</strong> (elastic soft-goal qualities).</li>
<li><strong>Goal Module (Creation):</strong> Models rigid &amp; fuzzy soft goals into a goal hierarchy via fuzzy modeling &amp; ontological reasoning.</li>
<li><strong>Belief Module (Growing):</strong> Encodes environment facts and fuzzy rules; refines goals and updates rules from execution feedback.</li>
<li><strong>Plan Module (Selection):</strong> Selects weighted strategies &amp; action plans; triggers <strong>Restructuring</strong> back to Goal/Belief modules.</li>
</ol>
</div>
<div class="fig-box">
<img src="./img/fig1_agent_model.png" alt="Figure 1: Agent Model" style="max-height: 410px;">
<div class="fig-cap">Figure 1 (Paper p. 87): Four-module evolutionary BDI agent model with ontology access and restructuring feedback loops.</div>
</div>
</div>

<!--
Agent Mental Architecture (Section 3.1, Figures 1 and 2):
Figure 1 maps the classic BDI mental states onto an evolutionary lifecycle:
- Agent Creation occurs in the Goal Module, which queries the Ontology Management Module to interpret user preferences. Domain ontologies are annotated in W3C OWL (Figure 2 in the paper defines FunctionalProperty attributes for Hotel), while issue-specific ontologies capture weighted soft-goal decompositions (Figure 3: Quality -> Facilities 0.8, Space 0.7, Services 0.9).
- Agent Growing occurs in the Belief Module via fuzzy and ontological reasoning, incorporating success/failure feedback from executed plans to adapt fuzzy rules.
- Agent Selection and Restructuring occur in the Plan Module, feeding structural mutations and crossover updates back into the Goal and Belief modules.
-->

---

## 3.1 Goal-Driven Analysis (GDUC) & Fuzzy Goal Modeling

<div class="split55">
<div>
<div class="card" style="margin-bottom: 10px;">
<h3>GDUC Multi-Faceted Goal Taxonomy (3.2)</h3>
<ul class="small-text">
<li>Classifies goals along <strong>4 aspects</strong>: <em>Competence</em> (rigid vs. soft), <em>View</em> (user- vs. agent-specific), <em>Content</em> (functional vs. non-functional), and <em>Constraints</em> (pre-/post-conditions).</li>
<li>Example use case <code>getHotelRecommendation</code> extends to <code>runAgain</code> and <code>showExceptionMessage</code>.</li>
</ul>
</div>
<div class="card teal">
<h3>Zadeh Test-Score Semantics (3.3)</h3>
<ul class="small-text">
<li>Canonical form: <code>G ⇒ R(P) IS A</code>, with possibility distribution <code>Π<sub>R(p)</sub> = μ<sub>A</sub></code>.</li>
<li><strong>Soft Goals:</strong> <code>G<sub>1</sub> ⇒ Preference(Snack) IS HIGH</code>; <code>G<sub>2</sub> ⇒ Quality(Hotel) IS HIGH</code>.</li>
<li><strong>Rigid Goal (<code>μ = 1.0</code>):</strong> <code>G<sub>3</sub> ⇒ MaxPrice(Hotel) IS M<sub>max</sub></code>.</li>
</ul>
</div>
</div>
<div class="fig-box">
<img src="./img/fig4_fuzzy_goals.png" alt="Figure 4: Fuzzy sets of the user's goals" style="max-height: 405px;">
<div class="fig-cap">Figure 4 (Paper p. 89): Triangular/trapezoidal fuzzy membership functions for (a) Interest (Low/Average/High) and (b) Budget (Poor/Normal/Rich).</div>
</div>
</div>

<!--
Goal-Driven Use Cases & Fuzzy Semantics (Sections 3.2 and 3.3, Table 1, Figures 4a/4b):
Using Lee & Kuo's GDUC methodology (1998, 2001), requirements are structured into a stable kernel use case ("getRecommendation") plus two extending alternative flows ("runAgain" if the user is unsatisfied, and "showExceptionMessage" on connection failure).

Formal Mental State Transition:
Each user goal g is formalized as a state transition <b, g, a> achieved by a plan <precondition, post-condition>. Using Zadeh's (1986) test-score semantics, imprecise traveler preferences become elastic constraints whose satisfaction degree is evaluated via membership functions: Interest spans [0, 100] (Low, Average, High) and Budget spans [0, 10000+] (Poor, Normal, Rich). A rigid goal is simply a boundary special case where membership must equal 1.0.
-->

---

## 4. Integrated Fuzzy–Ontology–Evolution Pipeline

<div class="fig-box" style="padding: 6px; margin-bottom: 8px;">
<img src="./img/its_fuzzy_ontology_pipeline.svg" alt="Fuzzy, Ontology, and GA+SOM Evolution Pipeline" style="max-height: 365px;">
<div class="fig-cap">End-to-end reasoning &amp; evolution flow: GDUC Fuzzy Goals ➔ OWL/RuleML Refinement ➔ Sugeno Inference ➔ GA + SOM Optimization.</div>
</div>

<div class="callout teal" style="margin-top: 8px;">
<strong>Synergistic Pipeline:</strong> <strong>Ontology reasoning</strong> expands coarse goals into weighted sub-goals; <strong>Sugeno fuzzy rules</strong> compute hotel class demand (<code>DH</code>); <strong>GA + SOM</strong> evolve optimal hotel–snack–scenery bundles.
</div>

<!--
Unified Mechanism Overview (Sections 3.3 and 4.1 to 4.3):
This synthesized diagram connects all four mathematical and symbolic stages of the paper:
1. GDUC Fuzzy Goals: Distinguishes elastic soft preferences (G1, G2) from hard budget ceiling (G3).
2. OWL + RuleML Ontology Refinement: Decomposes Quality(Hotel) using issue-specific relevance weights (Facilities 0.8, Space 0.7, Services 0.9) to derive refined sub-goals G21, G22, G23.
3. Sugeno Fuzzy Controller: Evaluates 9 heuristic rules (HR1 to HR9) over Max(Budget) and Min(Budget) to defuzzify a crisp hotel class demand degree DH.
4. GA + SOM Evolution: Encodes candidate recommendations as binary chromosomes (1 Hotel + 3 Snacks + 3 Sceneries) and evolves the population using weighted spatial distance fitness.
-->

---

## 4.1 Sugeno Fuzzy Inference & OWL/RuleML Ontology Reasoning

<div class="split55">
<div>
<h3 style="margin-top: 0;">Sugeno Controller &amp; 9 Heuristic Rules (4.1)</h3>
<p class="small-text">Firing levels <code>α<sub>1</sub>, α<sub>2</sub></code> use the <strong>Min operator</strong>; crisp output is the weighted average <code>z<sub>0</sub> = (α<sub>1</sub>·c<sub>1</sub> + α<sub>2</sub>·c<sub>2</sub>) / (α<sub>1</sub> + α<sub>2</sub>)</code> yielding Hotel Class <strong><code>DH</code></strong> ∈ {VS, S, N, L, VL}:</p>

| Max(Budget) \ Min(Budget) | **High** | **Average** | **Low** |
| :--- | :---: | :---: | :---: |
| **Rich** | `VL` (HR1) | `L` (HR2) | `N` (HR3) |
| **Normal** | `L` (HR4) | `N` (HR5) | `S` (HR6) |
| **Poor** | `N` (HR7) | `S` (HR8) | `VS` (HR9) |

</div>
<div class="card teal">
<h3>Goal-Driven Ontology Reasoning (4.2)</h3>
<ul class="small-text">
<li><strong>Semantic Similarity:</strong> Computed as the <strong>product of pre-defined relevance values</strong> along a directed semantic relation path in the OWL class hierarchy.</li>
<li><strong>RuleML Inference:</strong> Ontology rules encoded in <strong>RuleML</strong> dynamically expand soft goals into concrete sub-goals and prompt user confirmation:
  <ul>
  <li><code>G<sub>21</sub> ⇒ Equipments(Hotel) IS HIGH</code> (0.8)</li>
  <li><code>G<sub>22</sub> ⇒ Space(Hotel) IS HIGH</code> (0.7)</li>
  <li><code>G<sub>23</sub> ⇒ Service(Hotel) IS HIGH</code> (0.9)</li>
  </ul>
</li>
</ul>
</div>
</div>

<!--
Fuzzy Rule Base & Semantic Refinement (Sections 4.1 and 4.2, Table 2, Figures 3 and 5):
1. Sugeno Fuzzy Reasoning (4.1): Extending Zimmermann's (1996) Sugeno controller, Table 2 maps the 3x3 combinations of Max(Budget) {Rich, Normal, Poor} and Min(Budget) {High, Average, Low} onto five linguistic Hotel Class degrees (Figure 5: VS, S, N, L, VL spanning [0.0, 1.0]). Crucially, the Ontology Management Module supplies domain knowledge to these fuzzy rules, while the agent's learning mechanism evolves the rules over time.
2. Ontological Reasoning (4.2): OWL provides shared semantic annotations across heterogeneous travel providers, while RuleML specifies inference rules. Multiplying edge relevance weights along a directed relation path quantifies semantic confidence, automatically refining abstract user desires (e.g., "High Hotel Quality") into evaluable attributes (Equipments, Space, Service).
-->

---

## 4.2 Five-State Agent Evolution Cycle & Genetic Operators

<div class="split55">
<div>
<ol class="small-text">
<li><strong>Agent Creation:</strong> Agent factory spawns individuals encoding a binary chromosome <code>[Hotel | 3 Snacks | 3 Sceneries]</code> (IDs <code>1..N</code>).</li>
<li><strong>Agent Growth (Refinement):</strong> Mating pool selected randomly; internal knowledge refined via ontological, fuzzy, and learning mechanisms.</li>
<li><strong>Filter / Selection (SOM):</strong> Self-Organization-Based Optimization (<strong>SOM</strong>) selects fitter agents using weighted spatial distance fitness:<br><code>F = Σ (w<sub>i</sub> · d(H, Sc<sub>i</sub>) + w<sub>j</sub> · d(H, Sn<sub>j</sub>))</code></li>
<li><strong>Restructuring:</strong> <em>Inter-agent crossover</em> (swap modules across agents), <em>intra-agent crossover</em> (swap parameters/strategies within an agent), &amp; gene mutation (<code>p<sub>m</sub> = 0.01</code>).</li>
<li><strong>Illness State:</strong> Damaged/tampered agents enter recovery before returning to Growth.</li>
</ol>
</div>
<div class="fig-box">
<img src="./img/fig6_evolution_cycle.png" alt="Figure 6: Agent evolution process" style="max-height: 390px;">
<div class="fig-cap">Figure 6 (Paper p. 90): Five-state multi-agent evolution life cycle (Creation, Growing, Filter/Selection, Restructuring, and Illness).</div>
</div>
</div>

<!--
Evolution Life Cycle & Genetic Mechanics (Section 4.3, Figures 6 and 7):
Figure 6 formalizes an agent's complete lifespan across five states:
- Chromosome Design (Figure 7): Each individual encodes a complete travel recommendation tuple—one hotel ID, three snack-place IDs, and three scenic-spot IDs—represented as binary strings over 1..N (e.g., 001 | 001 002 003 | 001 002 003).
- SOM-Based Selection (Su, Zhao, & Lee, IJCNN 2004): Evaluates fitness via the weighted sum of GPS distances from candidate hotel H to selected scenic spots (Sc_i) and snack places (Sn_j), guiding convergence toward spatially convenient recommendations.
- Dual-Level Restructuring: Supports both inter-agent module exchange (multi-point sorted crossover) and intra-agent parameter/strategy exchange, plus random gene replacement mutation.
- Fault Tolerance (Illness State): Explicitly models security/integrity recovery when an agent is tampered with by malicious hosts or peers.
-->

---

## 5. Case Study: ATIS Hotel Recommendation Architecture

<div class="split55">
<div>
<p class="small-text">An <strong>Advanced Traveler Information System (ATIS)</strong> subsystem built over distributed <strong>Web Services</strong> (5 hotel websites + GPS snack &amp; scenery databases):</p>
<ul class="small-text">
<li><strong>JSP Form:</strong> Captures traveler budget, room type, date, and top-3 snack &amp; scenic preferences.</li>
<li><strong>TPWS (Travel Planning Web Service):</strong> Fuzzifies user profile, runs Sugeno inference, and defuzzifies facility demand degree.</li>
<li><strong>WSS (Web Service Simplifier):</strong> Aggregates live data from Scenery, Snack Bar, and Hotel Information Web Services.</li>
<li><strong>AEM (Agent Evolution Module):</strong> Executes GA + SOM optimization and invokes Hotel Reservation Web Service.</li>
<li><strong>ORM &amp; OMS:</strong> Performs ontological reasoning, builds recommendation lists, and persists user profiles &amp; evolved rules.</li>
</ul>
</div>
<div class="fig-box">
<img src="./img/fig8_system_arch.png" alt="Figure 8: Agent system architecture" style="max-height: 400px;">
<div class="fig-cap">Figure 8 (Paper p. 91): Service-oriented ATIS prototype linking JSP, TPWS, AEM, ORM, WSS, SOM, OMS, and external Web Services.</div>
</div>
</div>

<!--
Prototype Architecture & Service-Oriented Integration (Sections 5.1 and 5.2, Figure 8):
To validate the theoretical model, the authors implemented a working Java/JSP and Apache Axis Web Services prototype. Two Web Services query a GPS database for snack bars and scenic spots, while five dedicated Hotel Web Services scrape/query five target hotel websites for hotel name, room types, price, and live reservation status. Separating TPWS (fuzzy demand inference), WSS (external service aggregation), AEM (GA+SOM evolution), and ORM/OMS (ontological reasoning and knowledge storage) demonstrates practical SOA interoperability for distributed ITS.
-->

---

## 5.1 Interactive Prototype: User Preference Capture (JSP Form)

<div class="split55">
<div>
<div class="card" style="margin-bottom: 10px;">
<h3>Live Traveler Input Specification</h3>
<ul class="small-text">
<li><strong>Snack Preferences (1–3):</strong> e.g., <em>Snack</em>, <em>Convenience Store</em>, <em>PUB</em>.</li>
<li><strong>Scenic Spot Preferences (1–3):</strong> e.g., <em>Water Activity</em>, <em>Botanical Garden/Zoo</em>, <em>Campground</em>.</li>
<li><strong>Budget Interval:</strong> <code>Min = 3000</code>, <code>Max = 6000</code> (feeds both rigid ceiling <code>G<sub>3</sub></code> and Sugeno rules <code>HR1–HR9</code>).</li>
<li><strong>Booking Constraints:</strong> Room type (<em>Single Room</em>) &amp; 8-digit reservation date (<code>20050318</code>).</li>
</ul>
</div>
<div class="card teal">
<h3>Prototype Outputs</h3>
<p class="small-text">Returns the evolved optimal <strong>hotel name</strong>, <strong>room type</strong>, <strong>reservation date</strong>, and nearby <strong>scenic &amp; snack recommendations</strong>—with one-click re-evolution (<code>runAgain</code>) if unsatisfied.</p>
</div>
</div>
<div class="fig-box">
<img src="./img/fig9_jsp_form.png" alt="Figure 9: The JSP form" style="max-height: 405px;">
<div class="fig-cap">Figure 9 (Paper p. 91): Live JSP client interface (Apache Axis Web Service) capturing multi-criteria traveler goals.</div>
</div>
</div>

<!--
User Interaction & Closed-Loop Workflow (Sections 5.1 and 5.3, Figure 9):
Figure 9 shows the actual deployed JSP front-end running on Apache Axis (Client.jsp). Notice how the UI directly operationalizes the GDUC Table 1 specification: three ranked snack categories, three ranked scenic spot categories, minimum and maximum budget bounds, room type, and reservation date. Submitting the form triggers TPWS -> WSS -> AEM -> ORM -> JSP rendering, while allowing the traveler to re-run agent evolution if the returned itinerary does not meet expectations.
-->

---

## 5.2 Empirical Results: Convergence & Latency across 13 Scenarios

<div class="fig-box" style="padding: 6px; margin-bottom: 8px;">
<img src="./img/its_perf_chart.svg" alt="Table 3 Empirical Results: Generations and Execution Time" style="max-height: 315px;">
<div class="fig-cap">Visualization of Table 3 (Paper p. 91): 13 experimental runs scaling from 100–292 snack places and 12–88 scenic spots.</div>
</div>

<div class="three-col" style="margin-top: 6px;">
<div class="kpi-card">
<div class="kpi-val">3 – 31 Gen</div>
<div class="kpi-label">All 13 runs converged well below the <strong>100-generation</strong> ceiling (95% fitness stability)</div>
</div>
<div class="kpi-card teal">
<div class="kpi-val">125 – 422 ms</div>
<div class="kpi-label">Real-time interactive latency (mean <strong>~240 ms</strong> across 12 standard runs; 16 ms anomaly noted at 256/78)</div>
</div>
<div class="kpi-card accent">
<div class="kpi-val">p<sub>m</sub> = 0.01</div>
<div class="kpi-label">Low mutation rate balances exploration with rapid SOM-guided convergence</div>
</div>
</div>

<!--
Empirical Evaluation Analysis (Section 5.3, Table 3):
In Table 3, the authors tested 13 combinations of candidate pool sizes ranging from 100 to 292 snack places and 12 to 88 scenic spots. Evolution terminated once either 95% of agents shared identical fitness or 100 generations elapsed (mutation rate = 0.01).

Key Quantitative Findings:
- Fast Convergence: Every single scenario reached the 95% stability criterion in between 3 and 31 generations (median 11 generations), never hitting the 100-generation timeout.
- Interactive Responsiveness: Execution times ranged from 125 ms (103 snacks / 12 sceneries, 3 gen) up to a maximum of 422 ms (256 snacks / 86 sceneries, 23 gen), proving suitability for real-time Web-based travel advisory.
- Data Observation: Row 11 in Table 3 (256 snacks, 78 sceneries, 31 generations) reports 16 ms in the original printed table—likely a typographical artifact in the 2005 print (e.g., 516 ms or timer wrap)—which is transparently highlighted in teal on the chart.
-->

---

## 6. Discussion: Strengths & Methodological Limitations

<div class="two-col">
<div class="card teal">
<h3>Core Architectural Strengths</h3>
<ul class="small-text">
<li><strong>Expressive Soft/Rigid Modeling:</strong> GDUC + Zadeh test-score semantics gracefully handle imprecise traveler preferences alongside strict budget bounds.</li>
<li><strong>Semantic Interoperability:</strong> OWL + RuleML ontologies allow agents to share and refine domain concepts across heterogeneous hotel &amp; GPS Web Services.</li>
<li><strong>Fast Real-Time Evolution:</strong> SOM-assisted GA achieves sub-half-second convergence (&lt; 0.43 s) even with ~380 candidate POIs.</li>
<li><strong>Resilient Lifecycle:</strong> Explicitly incorporates an <em>Illness &amp; Recovery</em> state for distributed security.</li>
</ul>
</div>
<div class="card accent">
<h3>Limitations &amp; Open Questions</h3>
<ul class="small-text">
<li><strong>No Baseline Comparison:</strong> Table 3 measures convergence speed and runtime, but does not compare solution quality against pure GA, exhaustive search, or non-evolutionary agents.</li>
<li><strong>Static Relevance Weights:</strong> Issue-specific ontology weights (0.8, 0.7, 0.9) and heuristic rules (<code>HR1–HR9</code>) are manually initialized; online weight learning is not empirically benchmarked.</li>
<li><strong>Prototype Scale:</strong> Evaluated on 5 simulated hotel websites and spatial proximity fitness, without live traffic congestion or multi-user reservation contention.</li>
</ul>
</div>
</div>

<!--
Critical Evaluation & Research Context:
From a 2005 software engineering and soft-computing perspective, this paper is notably forward-looking in uniting Semantic Web standards (OWL, RuleML), Web Services (Apache Axis), fuzzy goal modeling, and evolutionary computation into a working prototype.

At the same time, an objective scholarly review notes three evaluation boundaries: (1) Table 3 reports only generations and milliseconds without optimality-gap comparisons against baseline heuristics; (2) the "Illness" security recovery state and long-term fuzzy-rule learning are designed architecturally rather than stress-tested experimentally; and (3) extending the spatial distance fitness function to include dynamic traffic delays and multi-agent negotiation over scarce hotel rooms remains future work.
-->

---

## 7. Conclusion & Key Takeaways

<div class="three-col" style="margin-bottom: 12px;">
<div class="card">
<h3>1. Fuzzy Goal-Driven Modeling</h3>
<p class="small-text">Formalized traveler soft &amp; rigid goals via <strong>GDUC</strong> and <strong>Zadeh test-score semantics</strong>, bridging human language and agent mental states.</p>
</div>
<div class="card teal">
<h3>2. Ontology-Guided Evolution</h3>
<p class="small-text">Combined <strong>OWL/RuleML sub-goal refinement</strong> with <strong>Sugeno fuzzy rules</strong> so agents grow their beliefs dynamically rather than remaining static.</p>
</div>
<div class="card accent">
<h3>3. Multi-Agent GA + SOM Cycle</h3>
<p class="small-text">Constructed a 5-state evolution lifecycle with <strong>SOM selection</strong> and <strong>inter-/intra-agent restructuring</strong>, validated in &lt; 422 ms on live Web Services.</p>
</div>
</div>

<div class="callout teal">
<strong>Takeaway for ITS &amp; Agent Engineering:</strong> Combining <strong>symbolic semantics (OWL + RuleML)</strong> with <strong>soft computing (Fuzzy Logic + GA + SOM)</strong> equips distributed ITS agents to start lightweight and rapidly evolve personalized, real-time travel solutions.
</div>

<!--
Concluding Synthesis (Section 6):
The paper demonstrates a cohesive blueprint for adaptive ITS agents: (1) model elastic user requirements as fuzzy soft/rigid goals; (2) refine goals semantically through domain- and issue-specific ontologies; (3) infer user demand degrees via Sugeno fuzzy control; and (4) continuously evolve agent recommendations through SOM-guided genetic restructuring. The deployed ATIS hotel recommendation prototype confirms that this hybrid symbolic-evolutionary pipeline runs cleanly within sub-second web interaction budgets.
-->

---

<!-- _class: closing -->

# Thank You & Questions

<p style="font-size: 1.02em; max-width: 780px;">
Fuzzy Soft Goals · OWL &amp; RuleML Ontological Reasoning · SOM + GA Evolutionary Agents for ITS
</p>

<div class="contact-card">
<strong>Jong Yih Kuo</strong> &nbsp;|&nbsp; <strong>Shin Jie Lee</strong> &nbsp;|&nbsp; <strong>Chia Ling Wu</strong><br>
<strong>Nien Lin Hsueh</strong> &nbsp;·&nbsp; <code>nlhsueh@fcu.edu.tw</code> &nbsp;|&nbsp; <strong>Jonathan Lee</strong><br>
<span style="font-size: 0.85em; opacity: 0.88;">International Journal of Fuzzy Systems (IJFS), Vol. 7, No. 2, pp. 85–92, June 2005</span><br>
<span style="font-size: 0.82em; opacity: 0.82;">Grants: NSC93-2213-E-030-008 &amp; Ministry of Education EX-91-E-FA06-4-4</span>
</div>

<!--
Reference & Archival Metadata:
- Title: Evolutionary Agents for Intelligent Transport Systems
- Authors: Jong Yih Kuo, Shin Jie Lee, Chia Ling Wu, Nien Lin Hsueh, Jonathan Lee
- Venue: International Journal of Fuzzy Systems, Vol. 7, No. 2, pp. 85 to 92, June 2005
- Funding: National Science Council (NSC93-2213-E-030-008) and Ministry of Education (EX-91-E-FA06-4-4), Taiwan
- Keywords: Intelligent Agent, Evolutionary, Intelligent Transportation Systems
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
