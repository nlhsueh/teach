---
marp: true
theme: gaia
size: 16:9
paginate: true
html: true
header: '<div class="hdr-wrap"><span class="hdr-title">A Quantitative Approach for Evaluating the Quality of Design Patterns</span><div class="hdr-actions"><a class="lang-btn" href="./PatternQuality_slide_zh.html" title="切換至繁體中文簡報">🌐 繁</a><div class="nav-dropdown"><button class="nav-btn">Sections ▾</button><div class="nav-menu"><a href="#2">Outline</a><a href="#3">1. Motivation &amp; Background</a><a href="#5">2. Formal Model &amp; QIE</a><a href="#8">3. PVS Tool &amp; Mediator Study</a><a href="#12">4. Broader GoF Insights</a><a href="#14">5. Conclusion &amp; Future Work</a></div></div></div></div>'
footer: 'Nien-Lin Hsueh, Peng-Hua Chu & William Chu · Feng Chia Univ. & Tunghai Univ. · JSS 2008'
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
  padding: 68px 54px 48px 54px;
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
h3 { color: var(--accent); font-size: 0.96em; font-weight: 700; margin: 4px 0 6px 0; letter-spacing: 0 !important; }
p { margin: 0 0 8px 0; }
ul, ol { margin: 4px 0 8px 0; padding-left: 22px; }
li { margin-bottom: 5px; line-height: 1.43; }
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
section.lead h1 { color: #ffffff; font-size: 1.98em; font-weight: 800; line-height: 1.24; margin-bottom: 16px; text-align: left; }
section.lead .subtitle { color: #cbd5e1; font-size: 0.94em; line-height: 1.5; margin-bottom: 24px; max-width: 960px; }
section.lead .meta-box { border-left: 4px solid #f43f5e; padding-left: 18px; color: #e2e8f0; font-size: 0.84em; line-height: 1.58; }
section.lead .grant { margin-top: 20px; font-size: 0.72em; color: #94a3b8; }

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
section.closing h1 { color: #ffffff; font-size: 2.2em; margin-bottom: 12px; }
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

.two-col { display: grid; grid-template-columns: 1fr 1fr; gap: 20px; align-items: stretch; }
.three-col { display: grid; grid-template-columns: repeat(3, 1fr); gap: 15px; align-items: stretch; }
.split64 { display: grid; grid-template-columns: 56% 42%; gap: 2%; align-items: center; }
.split55 { display: grid; grid-template-columns: 49% 49%; gap: 2%; align-items: center; }

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
.kpi-val { font-size: 1.32em; font-weight: 800; color: var(--navy); line-height: 1.15; margin-bottom: 3px; }
.kpi-card.accent .kpi-val { color: var(--accent); }
.kpi-card.teal .kpi-val { color: var(--teal); }
.kpi-label { font-size: 0.76em; color: var(--slate-700); line-height: 1.34; }

.callout {
  background: #f8fafc;
  border-left: 4px solid var(--accent);
  border-radius: 0 8px 8px 0;
  padding: 10px 16px;
  margin-top: 12px;
  font-size: 0.84em;
  color: var(--slate-700);
  line-height: 1.48;
}
.callout.teal { border-left-color: var(--teal); background: var(--teal-soft); }
.callout strong { color: var(--navy); }

.formula-box {
  background: #f8fafc;
  border: 1px solid var(--slate-200);
  border-left: 4px solid var(--navy);
  border-radius: 8px;
  padding: 10px 16px;
  margin: 8px 0;
  font-family: 'JetBrains Mono', monospace;
  font-size: 0.8em;
  color: var(--navy-dark);
  line-height: 1.5;
}

table {
  width: 100%;
  border-collapse: collapse;
  font-size: 0.72em;
  margin: 6px 0;
  background: #ffffff;
  border: 1px solid var(--slate-200);
}
th { background: var(--navy); color: #ffffff; font-weight: 700; padding: 6px 9px; text-align: left; border: 1px solid var(--navy); }
td { padding: 5px 9px; border: 1px solid var(--slate-200); vertical-align: middle; line-height: 1.32; }
tr:nth-child(even) td { background: #f8fafc; }

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
  transition: transform 0.25s ease, box-shadow 0.25s ease;
  cursor: zoom-in;
}
.fig-box.is-zoomed { z-index: 45; }
.fig-box img.is-zoomed {
  position: relative;
  z-index: 46;
  box-shadow: 0 18px 44px rgba(15, 23, 42, 0.30);
  background: #ffffff;
}
.fig-cap { font-size: 0.72em; color: var(--slate-500); margin-top: 5px; font-weight: 500; }

.small-text { font-size: 0.81em; }

@media print {
  .lang-btn, .nav-dropdown { display: none !important; }
}
</style>

<!-- _class: lead -->

<div class="badge">The Journal of Systems and Software (JSS) · Vol. 81, pp. 1430–1439 · 2008</div>

# A Quantitative Approach for Evaluating the Quality of Design Patterns

<div class="subtitle">
Verifying <strong>Intent–Structure Consistency</strong> and Quantifying <strong>Quality Improvement Effectiveness (QIE)</strong> via Role-Based UML Metamodels, QMOOD Metrics, and Automated Model Transformation
</div>

<div class="meta-box">
<strong>Nien-Lin Hsueh</strong><sup>a,*</sup>, <strong>Peng-Hua Chu</strong><sup>a</sup>, and <strong>William Chu</strong><sup>b</sup><br>
<sup>a</sup> Department of Information Engineering and Computer Science, Feng Chia University, Taichung, Taiwan<br>
<sup>b</sup> Department of Computer Science and Information Engineering, Tunghai University, Taichung, Taiwan<br>
<code>nlhsueh@fcu.edu.tw</code> · <code>cph@soft.iecs.fcu.edu.tw</code> · <code>cchu@thu.edu.tw</code>
</div>

<div class="grant">
DOI: 10.1016/j.jss.2007.11.724 · Accepted Nov 2007 · Published 2008 (Elsevier) · Grants: NSC94-2213-E-035-041 &amp; MOEA 96-EC-17-A-02-S1-029
</div>

<!--
Bibliographic & Research Overview:
This paper (Hsueh, Chu, & Chu, The Journal of Systems and Software 81 (2008) 1430-1439; doi:10.1016/j.jss.2007.11.724) addresses a foundational verification question in software design: when a design pattern claims in its Intent section to solve a quality problem (e.g., loose coupling, extensibility), how can we objectively and quantitatively verify that its Solution structural model actually achieves that quality improvement?

Core Contributions:
1. Formal 6-Tuple Pattern Representation: Formulates a quality-improving design pattern as <I_F, I_N, Q, S_F, S_N, T>, pairing FR/NFR intents with role-based UML metamodels and a transformation T.
2. Quantitative QIE_P Metric & P*-Improver Definition: Lifts QMOOD object-oriented metrics (e.g., COF, ANA, polymorphism) to the metamodel transformation level via Quality Improvement Effectiveness (QIE_P), defining P-improver and well-designed P*-improver criteria.
3. Pattern Verification System (PVS) & GoF Validation: Implements an XMI/Rational Rose-integrated verification tool, validates Mediator across 20 random sample models (QIE_coupling = -0.72), and uncovers nuanced insights on Observer, Decorator (negative abstraction QIE; actually a complexity-improver), and Singleton (problem-solver, not quality-improver).
-->

---

## Outline

<div class="outline-grid">
<div class="outline-item"><div class="outline-num">1</div><div class="outline-body"><a href="#3">Motivation &amp; Background</a><br>Intent–solution consistency gap, role-based metamodeling, and QMOOD hierarchy.</div></div>
<div class="outline-item"><div class="outline-num">2</div><div class="outline-body"><a href="#5">Formal 6-Tuple &amp; QIE Metric</a><br>FR/NFR intent &amp; structure duality, Quality Focus Q, QIE<sub>P</sub> formula, and P*-Improver.</div></div>
<div class="outline-item"><div class="outline-num">3</div><div class="outline-body"><a href="#8">PVS Tool &amp; Mediator Case Study</a><br>UML Profiles, transformation tags, 20-sample COF experiment (QIE = −0.72).</div></div>
<div class="outline-item"><div class="outline-num">4</div><div class="outline-body"><a href="#12">Broader GoF Insights</a><br>Polymorphism/hierarchy improvers vs. counter-intuitive Decorator &amp; Singleton cases.</div></div>
<div class="outline-item"><div class="outline-num">5</div><div class="outline-body"><a href="#14">Conclusion &amp; Future Work</a><br>Dual utility for developers &amp; users, XMI tooling, and Model-Driven Architecture (MDA).</div></div>
<div class="outline-item"><div class="outline-num">6</div><div class="outline-body"><a href="#15">Contact &amp; Archival Reference</a><br>Authors, affiliations, grants, and bibliographic metadata.</div></div>
</div>

<div class="callout teal">
<strong>Guiding Principle:</strong> <em>"If a pattern's intent maps to an OO design property (e.g., coupling), its structure must support that property—and that property can be quantitatively evaluated via OO metrics (e.g., COF)."</em>
</div>

<!--
Paper Structure Map:
- Section 1 (Introduction, pp. 1430-1431): Motivates intent-solution consistency validation and defines dual benefits for pattern developers and users.
- Section 2 (Background Work, pp. 1431-1432): Reviews France et al.'s (2004) role-based pattern metamodels (Fig. 1) and Bansiya & Davis's (2002) QMOOD 4-level quality model (Fig. 2).
- Section 3 (Pattern Evaluation, pp. 1432-1435): Introduces the 6-tuple <I_F, I_N, Q, S_F, S_N, T> (Table 1, Figs. 3-5), QIE_P (Eqs. 1-2), and P-improver / P*-improver definitions (Eqs. 3-5).
- Section 4 (Case Study & System Design, pp. 1435-1439): Walks through Mediator validation in PVS + Rational Rose (Figs. 6-8, Table 2) and discusses broader GoF patterns (Figs. 9-11).
- Section 5 (Conclusion, p. 1439): Summarizes contributions and MDA future work.
-->

---

## 1. Motivation: Verifying Intent–Solution Consistency

<div class="two-col">
<div class="card accent">
<h3>The Unchecked Pattern Quality Gap</h3>
<ul>
<li><strong>Four Essential Pattern Sections (GoF):</strong> <em>Name</em>, <em>Intent</em> (problem to resolve), <em>Solution</em> (structural model), and <em>Consequences</em>.</li>
<li><strong>Consistency Challenge:</strong> As design patterns proliferate, claims in the <em>Intent</em> section (e.g., "promotes loose coupling") are rarely verified objectively against the <em>Solution</em> structure.</li>
<li><strong>Beyond Informal Examples:</strong> Model-level class diagrams (Fig. 1a) only show one fixed example (e.g., 2 product families) and cannot systematically verify general quality behavior.</li>
</ul>
</div>
<div class="card teal">
<h3>Two Core Research Contributions</h3>
<ul>
<li><strong>1. For Pattern Developers (Validation):</strong> A systematic, objective approach based on OO quality models (QMOOD) to verify whether a newly designed pattern is <strong>well-designed</strong>—i.e., its structure truly resolves its stated quality intent without breaking functionality.</li>
<li><strong>2. For Pattern Users (Selection):</strong> A <strong>quantitative metric (<code>QIE<sub>P</sub></code>)</strong> measuring the <em>magnitude</em> of quality improvement, helping architects choose the most effective pattern for their functional and quality requirements.</li>
</ul>
</div>
</div>

<div class="callout">
<strong>Theoretical Lineage:</strong> Inspired by Huston (2001) (comparing metric scores of pattern vs. non-pattern solutions) and building on the authors' 4-role taxonomy (<em>SoSyM 2009</em>), this work formalizes quantitative validation for <strong>Quality-Improver</strong> patterns.
</div>

<!--
Context & Motivation (Section 1, pp. 1430-1431):
Winn & Calder (2002) observed that a design pattern should handle non-functional requirements by providing not just a functional solution, but a "better" solution for quality attributes. Yet pattern validation traditionally relied on subjective peer review. By combining role-based metamodeling (France et al. 2004), QMOOD hierarchical metrics (Bansiya & Davis 2002), and automated metamodel transformation (Dong & Yang 2003), this paper turns pattern quality validation into a reproducible, quantitative engineering procedure.
-->

---

## 2. Background: Role-Based Metamodels &amp; QMOOD

<div class="split55">
<div class="small-text">
<h3>1. Role-Based Pattern Representation (France et al., 2004)</h3>
<ul>
<li>Traditional GoF diagrams (Fig. 1a) depict concrete examples (e.g., <code>ProductA</code>, <code>ProductB</code>).</li>
<li><strong>Role-based metamodels</strong> (Fig. 1b) abstract participants into formal roles (<code>AbstractFactory</code>, <code>ConcreteFactory</code>, <code>AbstractProduct</code>, <code>ConcreteProduct</code>, <code>Client</code>) so arbitrary instance models can be generated and verified.</li>
</ul>
<h3>2. QMOOD 4-Level Hierarchy (Bansiya &amp; Davis, 2002)</h3>
<ul>
<li>Denoted as <code>Φ</code> with 4 levels (<code>Φ<sub>1</sub></code>–<code>Φ<sub>4</sub></code>) and 3 mappings (<code>Φ<sub>12</sub></code>, <code>Φ<sub>23</sub></code>, <code>Φ<sub>34</sub></code>).</li>
<li>Connects high-level <strong>Quality Attributes</strong> (e.g., Reusability) ➔ <strong>OO Design Properties</strong> (e.g., Coupling) ➔ <strong>OO Metrics</strong> (e.g., <code>COF</code>) ➔ <strong>OO Components</strong> (Class, Relationship).</li>
</ul>
</div>
<div class="fig-box">
<img src="./img/fig2_qmood.png" alt="Fig. 2 QMOOD model and example" style="max-height: 390px;">
<div class="fig-cap">Fig. 2. QMOOD 4-level hierarchical quality model and Reusability–Coupling–COF mapping example.</div>
</div>
</div>

<!--
Background Formalisms (Section 2, pp. 1431-1432, Figs. 1-2):
1. Role-Based Metamodeling (Section 2.1): Allows specifying structural properties that any conforming model element must satisfy. In Abstract Factory, arbitrary numbers of product families instantiate the single ConcreteProduct role.
2. QMOOD Formal Notation (Section 2.2):
   - Level 1 (Phi_1): 6 quality attributes — Reusability, Flexibility, Effectiveness, Understandability, Functionality, Extendibility.
   - Level 2 (Phi_2): 11 OO design properties — Design Size, Hierarchy, Abstraction, Encapsulation, Coupling, Cohesion, Composition, Inheritance, Polymorphism, Messaging, Complexity.
   - Level 3 (Phi_3): Quantitative OO design metrics (e.g., COF for Coupling, ANA for Abstraction).
   - Level 4 (Phi_4): Primitive OO elements (objects, classes, relationships, generalization).
   - Mapping (P, mu) in Phi_23 states that metric mu evaluates design property P.
-->

---

## 3. Formal 6-Tuple Pattern Definition &amp; Quality Focus

<div class="split55">
<div class="small-text">
<p>A quality-improving pattern is defined as a 6-tuple <code>dp = &lt;I<sub>F</sub>, I<sub>N</sub>, Q, S<sub>F</sub>, S<sub>N</sub>, T&gt;</code>:</p>
<ul>
<li><code>I<sub>F</sub></code> / <code>I<sub>N</sub></code>: <strong>FR-Intent</strong> (what it does) &amp; <strong>NFR-Intent</strong> (quality gain).</li>
<li><code>Q(dp) = &lt;property, constraint&gt;</code>: <strong>Quality Focus</strong>, where <code>property ∈ Φ<sub>2</sub></code> and <code>constraint ∈ {increased, decreased, maintained}</code>.</li>
<li><code>S<sub>F</sub></code> / <code>S<sub>N</sub></code>: Role-based <strong>FR-Structure</strong> &amp; <strong>NFR-Structure</strong> metamodels.</li>
<li><code>T</code>: <strong>Transformation</strong> mapping every instance <code>s ∈ S<sub>F</sub>(dp)</code> to <code>T(s) ∈ S<sub>N</sub>(dp)</code>.</li>
</ul>

| Pattern (Table 1) | Quality Focus <code>Q</code> |
| :--- | :--- |
| <strong>Observer</strong> | <code>&lt;coupling, decreased&gt;</code> |
| <strong>Abstract Factory</strong> | <code>&lt;coupling, decreased&gt;</code> |
| <strong>Strategy</strong> | <code>&lt;polymorphism, increased&gt;</code> |
| <strong>Iterator</strong> | <code>&lt;encapsulation, increased&gt;</code> |

</div>
<div class="fig-box">
<img src="./img/fig5_pattern_elements.png" alt="Fig. 5 Pattern element relationships" style="max-height: 310px;">
<div class="fig-cap">Fig. 5. Commutative relationship between FR/NFR intents, Quality Focus Q, FR/NFR metamodels, and Transformation T (Abstract Factory).</div>
</div>
</div>

<!--
Formal Pattern Semantics (Section 3.1, Table 1, Figs. 3-5):
Fig. 5 captures the core theoretical bridge of the paper:
- Top horizontal link: Extending I_F(AF) to I_N(AF) defines the Quality Focus Q(AF) = <coupling, decreased>.
- Left vertical link: S_F(AF) realizes I_F(AF) (Client directly instantiates ConcreteProducts).
- Right vertical link: S_N(AF) enhances I_N(AF) (surrogate Factory decouples Client from ConcreteProducts).
- Bottom horizontal link: Transformation T maps any instance model s in S_F(AF) into T(s) in S_N(AF), enabling automated quantitative comparison before and after applying the pattern.
-->

---

## 3. Quantitative Metric: Quality Improvement Effectiveness (`QIE_P`)

<div class="two-col">
<div class="card">
<h3>1. Base OO Metric Example: COF</h3>
<p class="small-text">For property <code>coupling</code>, QMOOD maps to Brito &amp; Abreu's (1995) <strong>Coupling Factor (COF)</strong>:</p>
<div class="formula-box">
COF = [ Σ<sub>i=1..TC</sub> Σ<sub>j=1..TC</sub> is_client(C<sub>i</sub>, C<sub>j</sub>) ] / (TC<sup>2</sup> − TC)
</div>
<p class="small-text">where <code>TC</code> is total classes, and <code>is_client(C<sub>i</sub>, C<sub>j</sub>) = 1</code> iff class <code>C<sub>i</sub></code> has a non-inheritance reference to <code>C<sub>j</sub></code> (<code>C<sub>i</sub> ≠ C<sub>j</sub></code>).</p>
</div>
<div class="card teal">
<h3>2. Lifting Metrics to Metamodels (Eqs. 1–2)</h3>
<p class="small-text">Given metric <code>μ</code> with <code>(P, μ) ∈ Φ<sub>23</sub></code> and aggregation function <code>G</code> (e.g., <code>AVG</code>) over typical sample set <code>s ∈ S<sub>F</sub></code>:</p>
<div class="formula-box">
QIE<sub>P</sub>(dp) = μ(S<sub>F</sub>, T)<br>
&nbsp;&nbsp;= G<sub>s ∈ SF</sub> [ ( μ(T(s)) − μ(s) ) / μ(s) ] &nbsp;&nbsp;(if μ(s) ≠ 0)<br>
&nbsp;&nbsp;= ∞ &nbsp;&nbsp;(if μ(s) = 0)
</div>
</div>
</div>

<div class="three-col" style="margin-top: 12px;">
<div class="kpi-card teal"><div class="kpi-val">QIE<sub>P</sub> &gt; 0</div><div class="kpi-label">Applying pattern <code>dp</code> <strong>increases</strong> OO design property <code>P</code> (e.g., higher polymorphism).</div></div>
<div class="kpi-card accent"><div class="kpi-val">QIE<sub>P</sub> &lt; 0</div><div class="kpi-label">Applying pattern <code>dp</code> <strong>decreases</strong> OO design property <code>P</code> (e.g., lower coupling).</div></div>
<div class="kpi-card"><div class="kpi-val">|QIE<sub>P</sub>| Magnitude</div><div class="kpi-label">Larger absolute value indicates <strong>stronger impact</strong> on property <code>P</code>; <code>0</code> means inefficacious.</div></div>
</div>

<!--
Mathematical Definition of QIE_P (Section 3.2, pp. 1433-1434, Eqs. 1-2):
Because a pattern is specified at the metamodel level (S_F -> S_N) while OO metrics operate on concrete instance models, Hsueh et al. lift metric mu to mu(M, T) by evaluating the relative metric change (mu(T(m)) - mu(m)) / mu(m) across a representative sample set of instantiated models M and aggregating via G (typically arithmetic mean AVG).
- Note on edge case: If mu(s) = 0 (e.g., zero initial polymorphic methods before transformation), QIE_P is defined as infinity (representing unbounded relative increase from zero).
- Comparative utility: Two candidate patterns targeting the same property P can be ranked objectively by comparing their |QIE_P| magnitudes.
-->

---

## 3. Defining `P-Improver` and Well-Designed `P*-Improver`

<div class="two-col">
<div class="card">
<h3>Consistency Validation: <code>P-Improver</code> (Eqs. 3–4)</h3>
<p class="small-text">A pattern <code>dp = &lt;I<sub>F</sub>, I<sub>N</sub>, &lt;P, C&gt;, S<sub>F</sub>, S<sub>N</sub>, T&gt;</code> is a <strong>property P improver</strong> iff <code>QIE<sub>P</sub>(dp)</code> matches constraint <code>C</code>:</p>
<div class="formula-box">
QIE<sub>P</sub>(dp) &gt; 0 &nbsp; if C = "increased"<br>
QIE<sub>P</sub>(dp) &lt; 0 &nbsp; if C = "decreased"<br>
QIE<sub>P</sub>(dp) = 0 &nbsp; if C = "maintained"
</div>
<p class="small-text"><strong>Implication (Eq. 4):</strong> <code>P-improver(dp) ➔ δ(I<sub>N</sub>, S<sub>F</sub>) &lt; δ(I<sub>N</sub>, S<sub>N</sub>)</code> — the NFR-structure satisfies the non-functional intent to a strictly higher degree than the FR-structure.</p>
</div>
<div class="card accent">
<h3>Functional Preservation: <code>P*-Improver</code> (Eq. 5)</h3>
<p class="small-text">Improving quality must <strong>never impair original functionality</strong>. A pattern is a <strong>well-designed P-improver</strong> (<code>P*-improver</code>) iff:</p>
<div class="formula-box">
P*-improver(dp) ⇔<br>
&nbsp;&nbsp;P-improver(dp) ∧ ( δ(I<sub>F</sub>, S<sub>N</sub>) = satisfied )
</div>
<ul class="small-text">
<li><code>δ(I<sub>F</sub>, S) ∈ {0, 1}</code>: binary functional satisfaction (verified by checking operations &amp; interactions in <code>S<sub>N</sub></code>).</li>
<li><code>δ(I<sub>N</sub>, S) ∈ [0, 1]</code>: continuous NFR satisfaction degree (inferred indirectly via <code>P-improver</code>).</li>
</ul>
</div>
</div>

<div class="callout teal">
<strong>Example (Abstract Factory, Fig. 3):</strong> Introducing surrogate <code>Factory</code> reduces Client–Product coupling (<code>QIE<sub>coupling</sub> &lt; 0</code>) while preserving product-family creation ➔ confirmed <strong>well-designed Coupling-Improver</strong>.
</div>

<!--
Theoretical Rigor of P-Improver and P*-Improver (Section 3.3, pp. 1434-1435, Eqs. 3-5):
Note an important nuance in the paper: the satisfaction function delta(intent, structure) is a conceptual construct that cannot be measured directly for soft NFRs (ranging in [0, 1]). Therefore, Eq. (4) uses the measurable QIE_P(dp) criterion in Eq. (3) as an operational proxy to establish delta(I_N, S_F) < delta(I_N, S_N). Meanwhile, Eq. (5) safeguards against degenerate transformations (e.g., deleting classes to artificially reduce COF) by requiring the designer to verify that S_N retains sufficient operations and collaborations to satisfy I_F (note: Eq. (5) in the PDF has a minor typographical S_F inside the formula, immediately clarified in the very next line of text as delta(I_F, S_N) = satisfied).
-->

---

## 4. Automated Verification Tool: Pattern Verification System (PVS)

<div class="fig-box" style="padding: 6px 8px;">
<img src="./img/diag_qie_pipeline.svg" alt="PVS Quantitative Pattern Verification Pipeline" style="max-height: 390px;">
</div>

<div class="callout">
<strong>Tool Integration (Section 4):</strong> Metamodels <code>S<sub>F</sub></code>, <code>S<sub>N</sub></code>, and transformation <code>T</code> are modeled as <strong>UML Profiles</strong> in <strong>IBM Rational Rose</strong>, exported to <strong>XMI</strong>, and imported into the authors' custom <strong>Pattern Verification System (PVS)</strong> for automated random model instantiation, transformation, and QIE computation.
</div>

<!--
System Architecture of PVS (Section 4, p. 1435):
Rather than inventing proprietary graph-grammar syntax, the authors leverage standard UML 2.x Profile extension mechanisms (Heaven & Finkelstein 2004; OMG UML Semantics 2007) inside IBM Rational Rose. Exporting to standard XMI bridges commercial CASE modeling tools with the custom PVS engine, which handles:
1. Bounded random sampling of conforming source instances s_F from S_F (since a metamodel admits infinitely many instances).
2. Automated execution of transformation T to generate s_N = T(s_F).
3. Automated OO metric calculation (e.g., COF, ANA) on every pair (s_F, s_N) and aggregate QIE_P reporting.
-->

---

## 4. Case Study I: Mediator Intent, Structures &amp; UML Profile

<div class="split55">
<div class="small-text">
<h3>Step 1: Intent Separation &amp; Quality Focus</h3>
<ul>
<li><strong>I<sub>F</sub>(Mediator):</strong> A <code>Colleague</code> object can communicate with other <code>Colleague</code> objects.</li>
<li><strong>I<sub>N</sub>(Mediator):</strong> Communicate in a <strong>loose-coupling</strong> manner by keeping objects from referring to each other explicitly.</li>
<li><strong>Quality Focus:</strong> <code>Q(Mediator) = &lt;coupling, decreased&gt;</code> ➔ Metric in <code>Φ<sub>3</sub></code>: <strong>COF</strong>.</li>
</ul>
<h3>Step 2: Role-Based Structures &amp; UML Profile</h3>
<ul>
<li><code>S<sub>F</sub></code> (Fig. 6a): Direct many-to-many self-association among <code>Colleague</code> classes.</li>
<li><code>S<sub>N</sub></code> (Fig. 6b): Introduces <code>Mediator</code> broker between all <code>Colleague</code> instances.</li>
<li><strong>UML Profile</strong> (Fig. 6c): Specializes UML metaclasses <code>Class</code>, <code>Association</code> (<code>C2M_A1/A2</code>), and <code>AssociationEnd</code> (<code>C2C_AE</code>, <code>C2M_AE</code>).</li>
</ul>
</div>
<div class="fig-box">
<img src="./img/fig6_mediator_structures.png" alt="Fig. 6 Mediator FR, NFR and UML profile" style="max-height: 380px;">
<div class="fig-cap">Fig. 6. Mediator pattern: (a) FR-structure S<sub>F</sub>, (b) NFR-structure S<sub>N</sub>, and (c) S<sub>N</sub> represented as a UML Profile metamodel.</div>
</div>
</div>

<!--
Mediator Case Study Steps 1 & 2 (Section 4.1, pp. 1435-1436, Fig. 6):
Starting from GoF's Mediator intent ("Define an object that encapsulates how a set of objects interact. Mediator promotes loose coupling..."), Step 1 extracts I_F, I_N, and Q(Mediator) = <coupling, decreased>.
Step 2 constructs the metamodel-level representations:
- C2C: Association linking one Colleague to another in S_F.
- C2C_AE: Association end of C2C.
- C2M_A: Association linking Colleague to Mediator in S_N.
- C2M_AE: Association end of C2M_A.
By subtyping standard UML metamodel elements (Class, Association, AssociationEnd), the metamodel remains directly editable in Rational Rose.
-->

---

## 4. Case Study II: Mediator Transformation Specification

<div class="split55">
<div class="fig-box">
<img src="./img/fig7_mediator_transform.png" alt="Fig. 7 Transformation specification of Mediator" style="max-height: 390px;">
<div class="fig-cap">Fig. 7. Metamodel transformation specification T(Mediator) mapping SourceModel (S<sub>F</sub>) to TargetModel (S<sub>N</sub>).</div>
</div>
<div class="small-text">
<h3>Step 3: Four Transformation Tags (Dong &amp; Yang, 2003)</h3>
<ul>
<li><code>&lt;&lt;removed&gt;&gt;</code>: Elements present only in <code>SourceModel</code> (e.g., direct <code>C2C</code> associations—omitted in target).</li>
<li><code>&lt;&lt;new&gt;&gt;</code>: Elements newly created in <code>TargetModel</code> (<code>Mediator</code> class, <code>C2M_A1/A2</code>, <code>C2M_AE1/AE2</code>).</li>
<li><code>&lt;&lt;unmodified&gt;&gt;</code>: Elements preserved identically across transformation (<code>Colleague</code> classes &amp; <code>C2C_AE2</code>).</li>
<li><code>&lt;&lt;modified&gt;&gt;</code>: Elements whose attributes, operations, or bindings change (<code>C2C_AE1</code> re-routed through <code>C2M_A1</code>).</li>
</ul>
<div class="callout teal">
Exported from Rational Rose as XMI, Fig. 7 allows <strong>PVS</strong> to automatically transform any arbitrary mesh of <code>Colleague</code> classes (Fig. 8a) into a star-topology Mediator model (Fig. 8b).
</div>
</div>
</div>

<!--
Mediator Transformation Specification Details (Section 4.1 Step 3, pp. 1435-1436, Fig. 7):
Adopting Dong & Yang's (2003) UML profile tagging scheme, Fig. 7 formally specifies how every instance of direct Colleague-to-Colleague association (C2C) is dissolved and re-routed through a single Mediator class.
- Multiplicity 1..* on C2C_AE1/C2C_AE2 in SourceModel allows arbitrary numbers of pairwise associations among 3 to 10 Colleague classes to be systematically collapsed into linear O(N) connections to Mediator in TargetModel.
-->

---

## 4. Case Study III: Quantitative Results on 20 Mediator Samples

<div class="three-col" style="margin-bottom: 10px;">
<div class="kpi-card"><div class="kpi-val">20 Samples</div><div class="kpi-label">PVS randomly generated 20 <code>s<sub>F</sub></code> models (3–10 Colleague classes, 3–32 random associations).</div></div>
<div class="kpi-card teal"><div class="kpi-val">COF: 0.34 ➔ 0.09</div><div class="kpi-label">Coupling dropped sharply in every sample (<code>s<sub>F</sub></code>: 0.15–0.50 ➔ <code>s<sub>N</sub></code>: 0.07–0.13).</div></div>
<div class="kpi-card accent"><div class="kpi-val">QIE = −0.72</div><div class="kpi-label">Average <code>QIE<sub>coupling</sub>(Mediator) = −0.72</code> (range −0.50 to −0.82) ➔ Verified <strong>Coupling-Improver</strong>!</div></div>
</div>

| Representative Samples (Table 2) | #01 | #04 | #08 | #12 | #14 | #16 | #20 | <strong>20-Sample Avg</strong> |
| :--- | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
| <strong>s<sub>F</sub></strong> (#Class / #Assoc) | 3 / 3 | 5 / 8 | 6 / 14 | 7 / 21 | 9 / 11 | 9 / 23 | 10 / 32 | 7.4 / 14.9 |
| <strong>COF(s<sub>F</sub>)</strong> | 0.50 | 0.40 | 0.46 | 0.50 | 0.15 | 0.31 | 0.35 | <strong>~0.34</strong> |
| <strong>s<sub>N</sub></strong> (#Class / #Assoc) | 6 / 4 | 8 / 6 | 10 / 7 | 10 / 8 | 12 / 10 | 12 / 10 | 13 / 11 | 10.4 / 8.2 |
| <strong>COF(s<sub>N</sub>)</strong> | 0.13 | 0.11 | 0.10 | 0.09 | 0.08 | 0.08 | 0.07 | <strong>~0.09</strong> |
| <strong>QIE<sub>SF, SN</sub></strong> | <strong>−0.73</strong> | <strong>−0.73</strong> | <strong>−0.79</strong> | <strong>−0.82</strong> | <strong>−0.50</strong> | <strong>−0.76</strong> | <strong>−0.80</strong> | <strong>−0.72</strong> |

<div class="callout">
<strong>Verdict:</strong> <code>QIE<sub>coupling</sub>(Mediator) = −0.72 &lt; 0</code> matches constraint <code>"decreased"</code> in <code>Q(Mediator)</code> across all 20 topologies (even sparse #14 achieves −50%, while dense #12/#20 achieve −82%/−80%).
</div>

<!--
Quantitative Validation Results (Section 4.1 Step 4 & Table 2, pp. 1435-1437):
Table 2 reports all 20 PVS-generated random samples spanning 3 to 10 Colleague classes (with 3 to 32 random inter-colleague associations).
- Structural Effect: Applying T(Mediator) adds 3 classes on average (Abstract Colleague, Abstract Mediator, Concrete Mediator) while drastically collapsing quadratic O(N^2) inter-colleague associations into linear connections.
- Quantitative Consistency: Every single sample exhibits a strongly negative QIE between -0.50 (Sample 14: sparse 9 classes, 11 associations, COF 0.15 -> 0.08) and -0.82 (Sample 12: dense 7 classes, 21 associations, COF 0.50 -> 0.09).
- Aggregate Score: AVG(QIE) = -0.72, objectively confirming that Mediator is a strong Coupling-Improver and demonstrating that its coupling-reduction benefit scales up as colleague interaction density increases.
-->

---

## 4. Broader GoF Insights I: Polymorphism, Hierarchy &amp; Abstraction

<div class="two-col">
<div class="card">
<h3>Why Most GoF Patterns Are Polymorphism-Improvers</h3>
<ul class="small-text">
<li>Applying QMOOD across Gamma's GoF catalog reveals that <strong>Abstract Factory, Builder, Observer, Strategy, and State</strong> share a common transformation motif (Fig. 9):
  <ul>
  <li><strong>Before (S<sub>F</sub>):</strong> <code>Role1</code> directly calls concrete <code>Role2</code>.</li>
  <li><strong>After (S<sub>N</sub>):</strong> Introduces an abstract hierarchy so <code>Role2</code> can be extended without modifying <code>Role1</code>.</li>
  </ul>
</li>
<li><strong>Analytical Proof:</strong> Adding at least 1 polymorphic method to <code>n</code> existing polymorphic methods yields:
  <div class="formula-box">QIE<sub>polymorphism</sub> ≈ [ (n + 1) − n ] / n = 1 / n &gt; 0</div>
</li>
</ul>
</div>
<div class="card teal">
<h3>Coupled Hierarchy &amp; Abstraction Gains</h3>
<ul class="small-text">
<li><strong>Hierarchy</strong> (generalization–specialization) enhances system <em>functionality</em>; <strong>Abstraction</strong> (average ancestors <code>ANA</code>) enhances <em>extensibility &amp; effectiveness</em>.</li>
<li>When a pattern introduces a polymorphic hierarchy, <strong>Hierarchy</strong> and <strong>Abstraction</strong> typically rise together.</li>
<li><strong>Observer Example (Fig. 10):</strong> Direct <code>Subject ➔ Observer</code> calls are transformed into two abstract hierarchies (<code>Subject</code> &amp; <code>Observer</code>) with polymorphic <code>update()</code>:
  <ul>
  <li><code>QIE<sub>polymorphism</sub> &gt; 0</code>, <code>QIE<sub>hierarchy</sub> &gt; 0</code>, <code>QIE<sub>abstraction</sub> &gt; 0</code> ➔ simultaneous improver of all three properties!</li>
  </ul>
</li>
</ul>
</div>
</div>

<div class="callout">
<strong>Architectural Takeaway:</strong> Despite differing intents and applicability, many GoF patterns achieve flexibility through the exact same structural transformation motif—creating measurable positive QIE across polymorphism, hierarchy, and abstraction.
</div>

<!--
Cross-Pattern Structural Analysis (Section 4.2, pp. 1437-1438, Figs. 9-10):
Evaluating multiple GoF patterns under QMOOD exposes a unifying structural explanation:
- Polymorphism (runtime interface substitution) directly drives QMOOD Flexibility, Extensibility, and Effectiveness.
- Because transforming direct calls (Role1 -> Role2) into polymorphic hierarchies (Fig. 9) adds abstract superclasses and overridden operations, Observer (Fig. 10), Strategy, State, Builder, and Abstract Factory naturally score positively on Polymorphism, Hierarchy, and Abstraction simultaneously.
-->

---

## 4. Broader GoF Insights II: Decorator &amp; Singleton Surprises

<div class="fig-box" style="padding: 6px 8px; margin-bottom: 8px;">
<img src="./img/fig11_decorator.png" alt="Fig. 11 Decorator ANA comparison" style="max-height: 255px;">
<div class="fig-cap">Fig. 11. Decorator pattern: (a) Static inheritance S<sub>F</sub> causes subclass explosion (36 classes, ANA = 3.14); (b) Composition-based S<sub>N</sub> cuts classes to 13 (ANA = 2.23).</div>
</div>

<div class="two-col">
<div class="card accent">
<h3>1. Decorator Is NOT an Abstraction-Improver!</h3>
<p class="small-text">Despite having a hierarchy, Decorator's <code>QIE<sub>abstraction</sub></code> is <strong>negative</strong> (<code>ANA: 3.14 ➔ 2.23</code>, −29%) because it replaces deep static inheritance with runtime composition. Its true strength is slashing classes (36 ➔ 13) ➔ a <strong>Complexity-Improver</strong>!</p>
</div>
<div class="card">
<h3>2. Not All Patterns Are Quality-Improvers</h3>
<p class="small-text"><strong>Singleton</strong> constrains a class hierarchy to instantiate exactly one object (protected reference + private constructors). It solves a functional programming constraint rather than improving QMOOD quality ➔ classified as a <strong>Problem-Solver</strong> (Hsueh et al., 2007/2009).</p>
</div>
</div>

<!--
Counter-Intuitive Empirical Discoveries (Section 4.2, pp. 1438-1439, Fig. 11):
1. Decorator Pattern Paradox: Visually, Decorator contains an inheritance tree (Component -> Basic / Decorator -> A, B, C), tempting developers to assume it improves Hierarchy/Abstraction. However, quantitative QMOOD evaluation using ANA (Average Number of Ancestors) exposes the opposite:
   - S_F (static inheritance for all combinations of A, B, C): 36 classes, sum of ancestors = 113 -> ANA = 113 / 36 = 3.14.
   - S_N (Decorator object composition): 13 classes, sum of ancestors = 29 -> ANA = 29 / 13 = 2.23.
   - Therefore QIE_abstraction(Decorator) = (2.23 - 3.14)/3.14 = -0.29 < 0. This quantitatively proves Decorator is a Complexity-Improver (avoiding combinatorial subclass explosion), NOT an Abstraction-Improver!
   (Note: Fig. 11 sub-captions in the original published PDF contain a minor print typo labeling "(a) S_F(Observer)" / "(b) S_N(Observer)" while the figure caption and text explicitly describe Decorator.)
2. Scope Boundary (Singleton): Connects directly back to the 4-role classification (activity-facilitator, quality-improver, problem-solver, conflict-resolver): QIE applies specifically to Quality-Improver patterns, not Problem-Solvers like Singleton.
-->

---

## 5. Conclusion &amp; Future Work

<div class="two-col" style="margin-bottom: 12px;">
<div class="card teal">
<h3>Core Contributions</h3>
<ul class="small-text">
<li><strong>1. Formal Quality-Perspective Model:</strong> Represented patterns as <code>&lt;I<sub>F</sub>, I<sub>N</sub>, Q, S<sub>F</sub>, S<sub>N</sub>, T&gt;</code>, bridging informal GoF text with role-based UML metamodels and QMOOD metrics.</li>
<li><strong>2. Quantitative <code>QIE<sub>P</sub></code> &amp; <code>P*-Improver</code>:</strong> Enabled objective verification of intent–structure consistency and magnitude comparison across competing patterns.</li>
<li><strong>3. PVS Prototype &amp; GoF Insights:</strong> Automated XMI-based validation confirmed Mediator (<code>QIE = −0.72</code>), explained polymorphism-improver motifs, and revealed Decorator as a Complexity-Improver rather than Abstraction-Improver.</li>
</ul>
</div>
<div class="card">
<h3>Future Research Directions</h3>
<ul class="small-text">
<li><strong>Full XMI-Based Verification Suite:</strong> Expand PVS with a complete standardized XMI schema for representing meta-level <code>S<sub>F</sub></code> and <code>S<sub>N</sub></code> structures across the entire GoF and architectural pattern catalogs.</li>
<li><strong>Model-Driven Architecture (MDA) Integration:</strong> Adopt OMG MDA transformation techniques (Miller &amp; Mukerji 2003; Meservy &amp; Fenstermacher 2005) to formalize and automate <code>T</code> across platform-independent and platform-specific models.</li>
<li><strong>Multi-Property Tradeoff Profiling:</strong> Evaluate simultaneous positive and negative QIE profiles across all 11 QMOOD properties.</li>
</ul>
</div>
</div>

<div class="callout">
<strong>Bottom Line:</strong> Quantitative pattern verification elevates design patterns from <em>folk wisdom</em> to <strong>auditable, measurable software engineering assets</strong> for both pattern authors and system architects.
</div>

<!--
Conclusion & Future Roadmap (Section 5, p. 1439):
This work demonstrates that the widely accepted claim "design patterns improve software quality" can—and should—be tested quantitatively at the metamodel level. By linking QMOOD design properties and metrics to formal FR -> NFR transformations, pattern developers gain a consistency check before publishing new patterns, and practitioners gain empirical evidence (QIE_P) for selecting patterns that genuinely match their non-functional requirements.
-->

---

<!-- _class: closing -->

# Thank You for Your Attention!

<p style="font-size: 1.05em; max-width: 860px;">
A Quantitative Approach for Evaluating the Quality of Design Patterns
</p>

<div class="contact-card">
<strong>Nien-Lin Hsueh<sup>*</sup></strong> · <code>nlhsueh@fcu.edu.tw</code> &nbsp;|&nbsp; <strong>Peng-Hua Chu</strong> · <code>cph@soft.iecs.fcu.edu.tw</code><br>
<strong>William Chu</strong> · <code>cchu@thu.edu.tw</code><br>
Feng Chia University &amp; Tunghai University, Taichung, Taiwan<br>
<span style="font-size: 0.85em; opacity: 0.88;">The Journal of Systems and Software (JSS), Vol. 81, pp. 1430–1439, 2008 · DOI: 10.1016/j.jss.2007.11.724</span>
</div>

<!--
Archival Citation Metadata:
- Title: A quantitative approach for evaluating the quality of design patterns
- Authors: Nien-Lin Hsueh (Feng Chia University, corresponding author), Peng-Hua Chu (Feng Chia University), William Cheng-Chung Chu (Tunghai University)
- Venue: The Journal of Systems and Software (JSS), Vol. 81, pp. 1430-1439, 2008 (Available online Dec 4, 2007, Elsevier Inc.)
- DOI: 10.1016/j.jss.2007.11.724
- Grants: National Science Council (Taiwan) NSC94-2213-E-035-041; Department of Industrial Technology, MOEA (Taiwan) 96-EC-17-A-02-S1-029
- Keywords: Design pattern, Object-oriented metrics, Software quality
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
