---
marp: true
theme: gaia
size: 16:9
paginate: true
html: true
header: '<div class="hdr-wrap"><span class="hdr-title">MDA-Based Visual Modeling Approach for Resources Link Relationships Using UML Profile</span><div class="hdr-actions"><a class="lang-btn" href="./MDA_slide_zh.html" title="切換至繁體中文簡報">🌐 繁</a><div class="nav-dropdown"><button class="nav-btn">Sections ▾</button><div class="nav-menu"><a href="#2">Outline</a><a href="#3">1. Motivation & Objectives</a><a href="#5">2. Related Work</a><a href="#6">3. MDA & XLink-CIM</a><a href="#8">4. XLinkUML Profile & OCL</a><a href="#10">5. Case Study & Prototype</a><a href="#13">6. Discussion & Conclusion</a></div></div></div></div>'
footer: 'I-Ching Hsu, Der-Hong Ting & Nien-Lin Hsueh · NFU · FCU · Computer Standards & Interfaces 2014'
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
  font-size: 1.24em;
  font-weight: 700;
  line-height: 1.25;
  margin: 0 0 13px 0;
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
section.lead h1 { color: #ffffff; font-size: 1.9em; font-weight: 800; line-height: 1.24; margin-bottom: 16px; text-align: left; }
section.lead .subtitle { color: #cbd5e1; font-size: 0.93em; line-height: 1.5; margin-bottom: 24px; max-width: 960px; }
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
  font-size: 0.84em;
  line-height: 1.68;
  color: #f8fafc;
}

.two-col { display: grid; grid-template-columns: 1fr 1fr; gap: 20px; align-items: stretch; }
.three-col { display: grid; grid-template-columns: repeat(3, 1fr); gap: 15px; align-items: stretch; }
.split64 { display: grid; grid-template-columns: 56% 42%; gap: 2%; align-items: center; }
.split55 { display: grid; grid-template-columns: 49% 49%; gap: 2%; align-items: center; }
.split46 { display: grid; grid-template-columns: 42% 56%; gap: 2%; align-items: center; }

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
  padding: 11px 16px;
  margin-top: 14px;
  font-size: 0.84em;
  color: var(--slate-700);
  line-height: 1.5;
}
.callout.teal { border-left-color: var(--teal); background: var(--teal-soft); }
.callout strong { color: var(--navy); }

table {
  width: 100%;
  border-collapse: collapse;
  font-size: 0.70em;
  margin: 6px 0;
  background: #ffffff;
  border: 1px solid var(--slate-200);
}
th { background: var(--navy); color: #ffffff; font-weight: 700; padding: 5px 8px; text-align: left; border: 1px solid var(--navy); }
td { padding: 4px 8px; border: 1px solid var(--slate-200); vertical-align: middle; line-height: 1.3; }
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
.fig-box img.is-zoomed { position: relative; z-index: 46; box-shadow: 0 18px 44px rgba(15, 23, 42, 0.30); background: #ffffff; }
.fig-cap { font-size: 0.72em; color: var(--slate-500); margin-top: 5px; font-weight: 500; }
.small-text { font-size: 0.81em; }

.future-strip { display: grid; grid-template-columns: repeat(3, 1fr); gap: 12px; margin-top: 12px; }
.future-pill {
  background: #f8fafc;
  border: 1px solid var(--slate-200);
  border-left: 4px solid var(--teal);
  border-radius: 8px;
  padding: 9px 13px;
  font-size: 0.75em;
  line-height: 1.4;
  color: var(--slate-700);
}
.future-pill strong { color: var(--navy); }

@media print { .lang-btn, .nav-dropdown { display: none !important; } }
</style>

<!-- _class: lead -->

<div class="badge">Computer Standards &amp; Interfaces (CSI) · Vol. 36, pp. 648–656 · 2014</div>

# MDA-Based Visual Modeling Approach for Resources Link Relationships Using UML Profile

<div class="subtitle">
Bridging Conceptual Software Modeling and Multi-Domain Web/Cloud Resource Linking via <strong>XLink-CIM</strong>, the <strong>XLinkUML Profile</strong>, and the <strong>XSLT-Powered U2XLink Transcoder</strong>
</div>

<div class="meta-box">
<strong>I-Ching Hsu<sup>a,*</sup></strong>, <strong>Der-Hong Ting<sup>b</sup></strong>, and <strong>Nien-Lin Hsueh<sup>b</sup></strong><br>
<sup>a</sup> Dept. of Computer Science and Information Engineering, National Formosa University, Yunlin, Taiwan<br>
<sup>b</sup> Dept. of Information Engineering and Computer Science, Feng-Chia University, Taichung, Taiwan
</div>

<div class="grant">
DOI: 10.1016/j.csi.2013.08.017 · Supported by National Science Council, Taiwan R.O.C., under Contract No. NSC 97-2221-E-150-039
</div>

<!--
Paper Metadata & Archival Context:
- Full Title: MDA-based visual modeling approach for resources link relationships using UML profile
- Publication: Computer Standards & Interfaces (CSI), Vol. 36, pp. 648–656, 2014 (Received Aug 2, 2010; Revised & Accepted Aug 30, 2013; Available online Sep 5, 2013; Elsevier; DOI: 10.1016/j.csi.2013.08.017).
- Authors: I-Ching Hsu (Corresponding author, National Formosa University, hsuic@nfu.edu.tw), Der-Hong Ting (Feng-Chia University), and Nien-Lin Hsueh (Feng-Chia University).
- Core Premise: Introduces an OMG Model Driven Architecture (MDA) pipeline that formalizes W3C XLink concepts as a Computation Independent Model (XLink-CIM), extends UML 2.x into a reusable Platform Independent Model (XLinkUML profile), and automates transformation via XMI + Apache Xalan XSLT (U2XLink Transcoder) into both W3C XLink schemas and semantic OWL-L ontologies.
-->

---

## Presentation Outline

<div class="outline-grid">

<div class="outline-item">
<div class="outline-num">1</div>
<div class="outline-body"><a href="#3">Motivation &amp; Research Objectives</a><br>Why XML editors fall short for XLink/Cloud resource linking, and our three MDA goals.</div>
</div>

<div class="outline-item">
<div class="outline-num">2</div>
<div class="outline-body"><a href="#5">Related Work</a><br>XLink/linkbase studies, OWL-L semantic linking, and OMG/domain-specific UML profiles.</div>
</div>

<div class="outline-item">
<div class="outline-num">3</div>
<div class="outline-body"><a href="#6">MDA Four-Layer Architecture &amp; XLink-CIM</a><br>Aligning MOF/UML/Models and formalizing Resource, Extended Link, Simple Link, and Linkbase.</div>
</div>

<div class="outline-item">
<div class="outline-num">4</div>
<div class="outline-body"><a href="#8">XLinkUML Profile &amp; OCL Constraints</a><br>14 UML stereotypes across Resource, Arc, and Link architectures with formal OCL invariants.</div>
</div>

<div class="outline-item">
<div class="outline-num">5</div>
<div class="outline-body"><a href="#10">Case Study &amp; U2XLink Prototype System</a><br>Student Semester Plan modeling in StarUML and automated XSLT generation to XLink &amp; OWL-L.</div>
</div>

<div class="outline-item">
<div class="outline-num">6</div>
<div class="outline-body"><a href="#13">Discussion, Limitations &amp; Conclusion</a><br>Extensibility of XSLT style sheets, Semantic Web OWL roadmap, and key engineering takeaways.</div>
</div>

</div>

<!--
Structural Map of the Paper:
- Section 1 (Introduction, pp. 648–649): Identifies the lack of conceptual/visual modeling in XML editors for XLink & Cloud resource discovery, introduces OWL-L, and frames the 3 MDA contributions.
- Section 2 (Related Work, p. 649): Surveys XLink/linkbase systems (XConnector, Xspect, XLinkProxy, xlinkit, OWL-L) and UML profiles (CORBA, EDOC, UTP, UWE, WebML, MDD access control, OLAP).
- Section 3 (MDA-based Approach, pp. 649–650): Presents the OMG 4-layer metamodeling architecture (M3 MOF, M2 UML/Profile, M1 PIM, M0 PSM instances, Fig. 1).
- Section 4 (XLink Framework, pp. 650–651): Gives four formal mathematical tuple definitions (Definitions 1–4) and XLink-CIM (Fig. 2).
- Sections 5 & 6 (XLinkUML Profile, pp. 651–653): Defines the 14 stereotypes (Table 1), tagged values, Resource/Arc/Link diagrams (Figs. 3–6), and three OCL arc invariants.
- Section 7 (Semester Plan Example, p. 653): Demonstrates modeling student, subject, course, semesterPlan, and Plans (Fig. 7).
- Section 8 (Prototype & XSLT Generation, pp. 653–655): Details StarUML -> XMI -> U2XLink Transcoder (Xalan + XMI2XLink / XMI2OWL-L) in Figs. 8–9.
- Section 9 (Conclusions, pp. 655–656): Summarizes contributions and future OWL ontology deduction work.
-->

---

## 1. Motivation: The Modeling Gap in Web &amp; Cloud Resource Linking

<div class="two-col">
<div class="card">
<h3>🌐 Why XLink &amp; OWL-L Matter</h3>
<ul class="small-text">
<li><strong>Unstructured Web &amp; Cloud Discovery:</strong> Finding and publishing distributed Web and Cloud resources is difficult without explicit link metadata.</li>
<li><strong>W3C XLink Advantage:</strong> Supports <strong>out-of-line links</strong> (separating content from external linkbases), multi-resource links, and inbound/third-party arcs.</li>
<li><strong>Syntax vs. Semantics Gap:</strong> Standard XLink focuses on XML syntax rather than computer-interpretable semantics—motivating our prior <strong>OWL-L</strong> ontology (link profile + link model).</li>
</ul>
</div>

<div class="card accent">
<h3>⚠️ Limitations of Current XML Tooling</h3>
<ul class="small-text">
<li><strong>No Conceptual Visual Modeling:</strong> Conventional XML editors force developers to hand-craft verbose XML tags directly.</li>
<li><strong>Low Reuse &amp; Poor Productivity:</strong> Lack of high-level abstractions makes multi-domain XLink applications error-prone and hard to maintain.</li>
<li><strong>UML Extension Needed:</strong> Standard UML is the de facto software engineering notation, yet lacks native constructs for XLink resources, traversal arcs, and linkbases.</li>
</ul>
</div>
</div>

<div class="callout">
<strong>Core Thesis:</strong> Applying OMG's <strong>Model Driven Architecture (MDA)</strong> with a lightweight <strong>UML Profile</strong> enables developers to model resource link relationships visually once (PIM) and automatically generate multiple XML/Semantic Web targets (PSM).
</div>

<!--
Problem Statement & Context (Section 1, pp. 648–649):
- In Web and Cloud computing environments, two symmetric problems arise: providers struggle to publish services cleanly, and users struggle to discover useful resources. W3C XLink addresses structural linking via out-of-line linkbases, while the authors' earlier OWL-L (CSI 2009) adds semantic interpretability (Link Profile for agent discovery; Link Model for agent exploitation).
- However, writing raw XLink or OWL-L in XML editors lacks software engineering rigor—there is no visual conceptual layer, causing inefficient development and low reuse.
- OMG offers two UML extension mechanisms: heavy MOF metamodel extension (defining a brand-new metamodel) vs. lightweight UML Profiles (stereotypes, tagged values, constraints). Choosing a UML Profile preserves compatibility with off-the-shelf UML tools like StarUML and Web engineering frameworks (UWE, WebML).
-->

---

## 1. Research Objectives &amp; Three Core Contributions

<div class="three-col" style="margin-top: 8px;">

<div class="card">
<h3>🏛️ 1. MDA Methodology</h3>
<p class="small-text">Establish a systematic <strong>CIM ➔ PIM ➔ PSM</strong> software engineering methodology for modeling Web and Cloud resource link relationships (<strong>XLink-CIM</strong>).</p>
</div>

<div class="card teal">
<h3>🧩 2. XLinkUML Profile</h3>
<p class="small-text">Design a reusable UML 2.x profile (<strong>14 stereotypes</strong>, tagged values, and <strong>OCL invariants</strong>) extending UML metaclasses for visual XLink modeling.</p>
</div>

<div class="card accent">
<h3>⚙️ 3. U2XLink Transcoder</h3>
<p class="small-text">Implement an extensible <strong>XMI + XSLT (Apache Xalan)</strong> prototype that automatically generates both <strong>XLink schemas</strong> and <strong>OWL-L ontologies</strong> from StarUML.</p>
</div>

</div>

<div class="three-col" style="margin-top: 16px;">
<div class="kpi-card"><div class="kpi-val">4 Layers</div><div class="kpi-label">OMG MDA alignment: M3 (MOF) ➔ M2 (Profile) ➔ M1 (PIM) ➔ M0 (XML/OWL-L)</div></div>
<div class="kpi-card teal"><div class="kpi-val">14 Stereotypes</div><div class="kpi-label">Covering Resource, Arc (with 3 OCL rules), and Link/Linkbase modeling</div></div>
<div class="kpi-card accent"><div class="kpi-val">2+ PSM Targets</div><div class="kpi-label">Plug-in XSLT architecture: XMI2XLink &amp; XMI2OWL-L (zero engine rewrite)</div></div>
</div>

<!--
Summary of Contributions (Section 1, p. 649):
1. Conceptual & Methodological: Formalizes the W3C XLink specification into a Computation Independent Model (XLink-CIM) grounded in four mathematical tuple definitions, lifting XLink out of raw XML syntax.
2. Modeling Language Extension: Packages the XLinkUML profile so it can be imported into standard UML tools and integrated with Web Engineering profiles (UWE, Topic Maps, GUI Layout, WebML).
3. Extensible Code Generation: Because each target domain is encapsulated as an XSLT stylesheet inside the Style Sheet Base, supporting a new XLink application domain only requires adding a new XSLT stylesheet without modifying the Xalan-based Transcoding Engine.
-->

---

## 2. Related Work: XLink Systems &amp; UML Profiles

<div class="two-col">
<div class="card">
<h3>🔗 XLink, Linkbases &amp; Semantic Linking</h3>
<ul class="small-text">
<li><strong>Out-of-Line Link Separation:</strong> Content resides in XML documents while link structures are maintained independently in external <strong>linkbases</strong>.</li>
<li><strong>Hypermedia &amp; Link Servers:</strong> <code>XConnector</code> (multimedia sync), <code>Xspect</code> (open hypermedia), <code>XLinkProxy</code> (external linkbases), and <code>xlinkit</code> (consistency checking &amp; smart link generation).</li>
<li><strong>Intelligent Semantic Linking:</strong> Prior work by Kao &amp; Hsu (2007) and Hsu (2009, <code>OWL-L</code> / <code>SXRS</code>) integrated Semantic Web ontologies for dynamic link generation and recommendation.</li>
</ul>
</div>

<div class="card teal">
<h3>📐 Domain-Specific UML Profiles &amp; MDA</h3>
<ul class="small-text">
<li><strong>OMG Standard Profiles:</strong> UML Profile for CORBA, EDOC (Enterprise Distributed Object Computing), and UML Testing Profile (UTP).</li>
<li><strong>Web &amp; Knowledge Engineering:</strong> UML profiles for Web frameworks (Fuentes &amp; Vallecillo), Web 2.0 mashups &amp; context-aware apps (Hsu, 2012–2013), and knowledge-based systems (Abdullah et al., 2007).</li>
<li><strong>MDA &amp; OCL Precision:</strong> Access control MDD with OCL (Fink et al., 2006), platform-independent OLAP + DB generation (Pardillo &amp; Mazón, 2012).</li>
<li><strong>Gap Addressed:</strong> No prior UML profile + MDA pipeline bridged visual UML modeling directly to both <strong>XLink</strong> and <strong>OWL-L</strong>.</li>
</ul>
</div>
</div>

<!--
Positioning Against Prior Literature (Section 2, p. 649):
- XLink research established rich linking mechanisms (XConnector, Xspect, XLinkProxy, xlinkit) and semantic extensions (OWL-L, SXRS), yet focused on runtime link servers or XML/OWL schemas rather than visual software modeling.
- Meanwhile, UML profiling has proven effective across distributed systems (CORBA, EDOC), testing (UTP), security (RBAC/access control with OCL), data warehouses (OLAP), and Web 2.0 engineering.
- This paper bridges the two communities by defining a formal, OCL-constrained UML profile specifically for XLink resource link relationships within an OMG MDA workflow.
-->

---

## 3. OMG Four-Layer MDA Architecture for XLink

<div class="split55">
<div class="fig-box">
<img src="./img/fig_mda_4layer.png" alt="The Four-Layer Model Driven Architecture (Fig. 1)" style="max-height: 360px;">
<div class="fig-cap">Fig. 1 from paper: Four-layer OMG MDA metamodeling stack (M3 ➔ M0).</div>
</div>

<div>

### Mapping XLink Across M3 ➔ M0
- **M3 — Meta-Metamodel (`MOF`):** Universal language defining modeling languages (UML, CWM).
- **M2 — Metamodel (`UML + XLinkUML Profile`):** Extends standard UML metaclasses with XLink stereotypes, tagged values, and OCL constraints derived from **XLink-CIM**.
- **M1 — Model (`PIM`):** Developers visually construct domain models (e.g., *Semester Plan*) using the XLinkUML profile—completely platform-independent.
- **M0 — Real Objects (`PSM & Instances`):** XSLT transforms exported XMI into platform-specific **XLink XML schemas** and **OWL-L ontologies**.

</div>
</div>

<!--
OMG Four-Layer Metamodeling Alignment (Section 3, Fig. 1, pp. 649–650):
- MDA separates concerns into three viewpoints: CIM (environment & requirements without structural/processing details), PIM (platform-agnostic model), and PSM (platform-specific realization).
- Fig. 1 grounds this workflow in OMG's 4-layer hierarchy:
  - M3: Meta-Object Facility (MOF) specifies UML itself.
  - M2: UML metamodel tailored via the XLinkUML profile package (stereotypes, tagged values, constraints).
  - M1: Domain-specific PIMs built by developers (such as the Semester Plan model) and transformed into XLink/OWL-L PSMs via XSLT.
  - M0: Concrete runtime XML documents, linkbases, and Web/Cloud resource instances.
-->

---

## 4. Formal XLink-CIM Definitions

<div class="split55">
<div>

### Four Formal Tuples (Definitions 1–4)
1. **Resource (Def. 1):** `WR = &lt;R<sub>id</sub>, U<sub>id</sub>, A<sub>WR</sub>&gt;`
   - URI identifier `R<sub>id</sub>`, owner `U<sub>id</sub>`, attributes `A<sub>WR</sub>` (Web pages, services, hosts, devices).
2. **Extended Link (Def. 2):** `EL = &lt;L<sub>a</sub>, L<sub>o</sub>, R<sub>a</sub>, In, Ou, Tp, A<sub>r</sub>&gt;`
   - Remote **Locators** `L<sub>a</sub>`, **Local Resources** `L<sub>o</sub>`, role `R<sub>a</sub>`, arc role `A<sub>r</sub>`, and directed traversal arcs: **Inbound** (`In`), **Outbound** (`Ou`), **Third-Party** (`Tp`).
3. **Simple Link (Def. 3):** `SL = &lt;L<sub>a</sub>, R<sub>a</sub>, Ou, A<sub>r</sub>&gt;`
   - Restricted 2-resource subset (local start ➔ remote end; outbound only).
4. **Linkbase (Def. 4):** `LB = &lt;ELs, A<sub>LB</sub>&gt;`
   - XML link repository aggregating extended links (`In` &amp; `Tp`).

</div>
<div class="fig-box">
<img src="./img/fig_xlink_cim.png" alt="The XLink-CIM Conceptual Model (Fig. 2)" style="max-height: 365px;">
<div class="fig-cap">Fig. 2 from paper: Abstract conceptual structure of XLink-CIM.</div>
</div>
</div>

<!--
Formal XLink-CIM Specification (Section 4, Definitions 1–4, Fig. 2, pp. 650–651):
- Extended links can be modeled as directed graphs where participating resources (Locators = remote resources; Local Resources = embedded resources) are nodes and traversal rules (arcs) are directed edges:
  - Outbound arc: local starting resource -> remote ending resource.
  - Inbound arc: remote starting resource -> local ending resource.
  - Third-party arc: remote starting resource -> remote ending resource (neither endpoint is local).
- Simple links have no internal structure and support only a single outbound arc between a local starting resource and a remote ending resource.
- Linkbases (Def. 4) collect sets of extended links into standalone XML repositories, enabling centralized management of inbound and third-party links separated from the linked documents themselves.
-->

---

## 5. XLinkUML Profile: Three Sub-Architectures

<div class="fig-box" style="padding: 6px 8px; margin-bottom: 10px;">
<img src="./img/diag_xlinkuml_profile.svg" alt="XLinkUML Profile Architecture: Resource, Arc + OCL, Link" style="max-height: 310px;">
</div>

<div class="callout teal">
<strong>Modular Package Design (Fig. 3):</strong> Packaged as a standard UML Profile, <code>XLinkUML</code> can be directly imported into existing Web Engineering methodologies including <strong>UWE</strong>, <strong>Topic Maps</strong>, <strong>GUI Layout modeling</strong>, and <strong>WebML</strong>.
</div>

<!--
XLinkUML Profile Design (Sections 5 & 6, Figs. 3–6, pp. 651–653):
- The profile extends UML 2.x using three standard extension mechanisms: Stereotypes (specializing metaclasses), Tagged Values (typed metadata properties on stereotypes), and Constraints (formal OCL invariants).
- Resource Architecture (Section 5.1, Fig. 4): <<resource>> extends Class (tags: label, title, role) with subclasses <<localResource>> and <<locator>>; <<entity>> extends Component to represent persistent physical files or remote services.
- Arc Architecture (Section 6, Fig. 5): <<arc>> extends AssociationClass (so an arc acts simultaneously as both a UML Association and a Class holding tags: showBehavior, actuateBehavior, arcrole, from, to), specialized into <<inbound>>, <<outbound>>, and <<thirdParty>>.
- Link Architecture (Section 6.1, Fig. 6): <<XMLDocument>>, <<linkbase>>, <<extendedLink>>, <<simpleLink>>, and <<hyperlink>> extend Artifact; <<extendedLink>> aggregates title, arc, and resource elements.
-->

---

## 5. UML-to-XLink Mapping &amp; Formal OCL Invariants

<div class="split55">
<div>

### Complete 14-Stereotype Mapping (Table 1)
| Stereotype | UML Base | XLink Construct |
| :--- | :--- | :--- |
| `«resource»` / `«localResource»` / `«locator»` | Class | URI resource / embedded / remote URI |
| `«entity»` | Component | Persistent physical file for a resource |
| `«arc»` / `«inbound»` / `«outbound»` / `«thirdParty»` | AssociationClass | Directed traversal rules between endpoints |
| `«title»` | Class | Human-readable label for a link |
| `«XMLDocument»` | Artifact | Root XML-based document |
| `«simpleLink»` / `«hyperlink»` | Artifact | 2-resource outbound link / human link |
| `«extendedLink»` / `«linkbase»` | Artifact | Multi-resource link / external repository |

</div>
<div>

### Formal OCL Arc Constraints (Section 6)
<div class="card" style="margin-bottom: 10px;">
<p class="small-text"><strong>1. Outbound Arc (Local ➔ Remote):</strong><br>
<code>context outbound inv:</code><br>
<code>self.from.oclIsTypeOf(localResource) and self.to.oclIsTypeOf(locator)</code></p>
</div>
<div class="card teal" style="margin-bottom: 10px;">
<p class="small-text"><strong>2. Inbound Arc (Remote ➔ Local):</strong><br>
<code>context inbound inv:</code><br>
<code>self.from.oclIsTypeOf(locator) and self.to.oclIsTypeOf(localResource)</code></p>
</div>
<div class="card accent">
<p class="small-text"><strong>3. Third-Party Arc (Remote ➔ Remote):</strong><br>
<code>context thirdParty inv:</code><br>
<code>self.from.oclIsTypeOf(locator) and self.to.oclIsTypeOf(locator)</code></p>
</div>

</div>
</div>

<!--
Precise Metamodel Semantics (Table 1 & Section 6, pp. 651–653):
- Extending AssociationClass for <<arc>> is a pivotal modeling choice: plain UML Associations cannot carry rich typed properties and enumerations cleanly, whereas AssociationClass allows each traversal edge to carry showBehavior (show enumeration), actuateBehavior (actuate enumeration), arcrole, start (from), and end (to) tags.
- The three OCL invariants enforce W3C XLink structural validity at modeling time inside the UML tool—preventing illegal arc endpoint combinations (e.g., an outbound arc mistakenly targeting a local resource) before code generation even begins.
- Note: The original PDF prints "form" as a minor typo for "from" in the OCL block; semantically it denotes the starting resource attribute of an arc.
-->

---

## 6. Case Study: Student Semester Plan in XLinkUML

<div class="split55">
<div class="fig-box">
<img src="./img/fig_semester_plan.png" alt="Semester Plan Modeled with XLinkUML Profile (Fig. 7)" style="max-height: 365px;">
<div class="fig-cap">Fig. 7 from paper: Visual PIM of a student's Semester Plan using XLinkUML stereotypes.</div>
</div>

<div>

### Domain Semantics &amp; Stereotype Assignment
- **`Plans` (`«linkbase»`):** Repository aggregating one or more `semesterPlan` extended links.
- **`semesterPlan` (`«extendedLink»`):** Associates **exactly 1 `student`** with **≥ 1 `subject`** and **≥ 1 `course`**.
- **Participating Resources:**
  - `student` &amp; `course` ➔ **`«locator»`** (remote URI resources).
  - `subject` ➔ **`«localResource»`** (embedded local resource).
- **Three Validated Arcs (Satisfying OCL):**
  - `interest` (`«inbound»`): `student` (remote) ➔ `subject` (local).
  - `cover` (`«outbound»`): `subject` (local) ➔ `course` (remote).
  - `take` (`«thirdParty»`): `student` (remote) ➔ `course` (remote).

</div>
</div>

<!--
Concrete Walkthrough of the Semester Plan PIM (Section 7, Fig. 7, pp. 653–654):
- This case study demonstrates all three XLink arc types simultaneously within one cohesive academic domain: a student specifies subjects of interest and enrolls in courses covering those chosen subjects.
- Notice how every single arc obeys its corresponding OCL invariant from Section 6:
  - interest (<<inbound>>): starts at remote <<locator>> student, ends at <<localResource>> subject.
  - cover (<<outbound>>): starts at <<localResource>> subject, ends at remote <<locator>> course.
  - take (<<thirdParty>>): connects two remote <<locator>> resources (student -> course) without either being local to the linkbase.
- Multiplicity constraints (1 student, 1..* subject, 1..* course) are captured visually in standard UML class-diagram notation.
-->

---

## 7. Prototype System: U2XLink Transcoder Pipeline

<div class="fig-box" style="padding: 6px 8px; margin-bottom: 10px;">
<img src="./img/diag_u2xlink_pipeline.svg" alt="U2XLink Transcoder End-to-End MDA Pipeline" style="max-height: 300px;">
</div>

<div class="three-col">
<div class="card">
<h3>1. Visual Modeling</h3>
<p class="small-text">Model resource links graphically in <strong>StarUML</strong> using the imported <code>XLinkUML</code> profile and export standard <strong>XMI</strong>.</p>
</div>
<div class="card teal">
<h3>2. XSLT Transcoding</h3>
<p class="small-text"><strong>U2XLink Transcoder</strong> invokes <strong>Apache Xalan</strong> to apply stylesheets from the extensible <strong>Style Sheet Base</strong>.</p>
</div>
<div class="card accent">
<h3>3. Dual PSM Output</h3>
<p class="small-text"><code>XMI2XLink</code> outputs W3C <strong>XLink Schema</strong>; <code>XMI2OWL-L</code> outputs semantic <strong>OWL-L Ontology</strong> XML.</p>
</div>
</div>

<!--
Prototype Architecture & Extensibility (Section 8, Fig. 8, pp. 653–654):
- The prototype integrates two core components: the XLinkUML profile (implemented in open-source StarUML) and the U2XLink Transcoder.
- Standard XMI (XML Metadata Interchange) acts as the tool-neutral bridge, decoupling the visual UML editor from the backend transcoder so any XMI-compliant UML tool can plug in.
- Inside U2XLink Transcoder, the Transcoding Engine runs Apache Xalan (XSLT processor) over a modular Style Sheet Base containing XMI2XLink and XMI2OWL-L.
- Key architectural advantage: Adding a brand-new target platform or XML/RDF dialect requires ONLY authoring a new XSLT stylesheet—zero changes to the UML profile or Java/Xalan engine.
-->

---

## 7. Automated Multi-Target Generation Demo

<div class="split55">
<div>

### End-to-End Transformation Flow (Fig. 9)
- **(A) Visual UML PIM:** Developer draws the Semester Plan diagram in **StarUML** with `«locator»`, `«localResource»`, `«extendedLink»`, and arc stereotypes.
- **(B) XMI Export:** StarUML serializes the full UML model and tagged values into a standard **XMI** document.
- **(C ➔ D) XLink Schema PSM:** Applying `XMI2XLink` transforms XMI into a valid W3C **XLink XML schema** ready for hypermedia/linkbase engines.
- **(E ➔ F) OWL-L Ontology PSM:** Applying `XMI2OWL-L` transforms the **exact same XMI** into a computer-interpretable **OWL-L ontology** for intelligent Web/Cloud agents.

<div class="callout teal">
<strong>Model Once, Generate Many:</strong> A single visual PIM drives both syntactic XML linking and semantic Web reasoning without manual XML coding.
</div>

</div>
<div class="fig-box">
<img src="./img/fig_prototype_gen.png" alt="Automatically Generating XLink and OWL-L from Visual UML (Fig. 9)" style="max-height: 365px;">
<div class="fig-cap">Fig. 9 from paper: Live StarUML PIM (A) ➔ XMI (B) ➔ XLink Schema (C–D) &amp; OWL-L (E–F).</div>
</div>
</div>

<!--
Code Generation Walkthrough (Section 8, Fig. 9, pp. 654–655):
- Fig. 9 validates the entire MDA round-trip on the Semester Plan example inside the implemented prototype.
- Panels (A)–(B) show the graphical StarUML editor exporting structured XMI metadata; Panels (C)–(D) show the XMI2XLink stylesheet generating W3C XLink XML elements (extended links, locators, resources, and arcs); Panels (E)–(F) show the XMI2OWL-L stylesheet transforming the identical XMI source into OWL-L classes and properties.
- This concrete dual-target proof-of-concept demonstrates MDA's core promise: shielding domain modelers from syntactic XML/OWL verbosity while guaranteeing structural consistency across heterogeneous target platforms.
-->

---

## 8. Discussion: Strengths, Trade-Offs &amp; Scope

<div class="two-col">
<div class="card">
<h3>✅ Architectural Strengths</h3>
<ul class="small-text">
<li><strong>Zero-Code Extensibility:</strong> Encapsulating each target domain in an XSLT stylesheet lets teams add new output formats (e.g., RDFa, JSON-LD, Cloud service registries) cleanly.</li>
<li><strong>Standards Compliance:</strong> Built strictly on OMG standards (<strong>MOF, UML 2.x, OCL, XMI</strong>) and W3C standards (<strong>XLink, XSLT, OWL</strong>).</li>
<li><strong>Ecosystem Composability:</strong> Lightweight UML Profile packaging allows seamless import into UWE, WebML, or enterprise UML tools beyond StarUML.</li>
<li><strong>Early Error Prevention:</strong> OCL invariants catch invalid inbound/outbound/third-party arc definitions at design time.</li>
</ul>
</div>

<div class="card accent">
<h3>⚠️ Limitations &amp; Open Challenges</h3>
<ul class="small-text">
<li><strong>One-Way Transformation:</strong> Current U2XLink Transcoder performs forward PIM ➔ PSM generation without automated reverse engineering (XML ➔ UML).</li>
<li><strong>Limited Semantic Reasoning:</strong> While OWL-L output enables machine interpretability, dynamic rule deduction and OWL reasoner integration remain future work.</li>
<li><strong>XMI Dialect Variance:</strong> Real-world UML tools occasionally emit subtle XMI schema differences that require XSLT adapter tuning.</li>
<li><strong>Empirical User Study:</strong> Paper demonstrates functional feasibility via prototype rather than controlled developer productivity experiments.</li>
</ul>
</div>
</div>

<!--
Critical Evaluation & Engineering Trade-Offs (Sections 8 & 9, pp. 654–656):
- Choosing XSLT over imperative Java/MOF-to-Text code generators keeps transformation rules declarative, XML-native, and easy to inspect or swap per domain.
- However, XSLT transformations are unidirectional (forward engineering) and sensitive to XMI version/vendor quirks (e.g., StarUML vs. Enterprise Architect vs. Papyrus).
- Furthermore, while the paper demonstrates syntactic and structural correctness through the Semester Plan case study and StarUML/Xalan prototype, quantifying developer time savings and defect reduction across large industrial linkbases remains an open empirical opportunity.
-->

---

## 8. Conclusion &amp; Future Research Directions

<div class="callout teal" style="margin-top: 4px; margin-bottom: 14px;">
<strong>Core Contribution:</strong> We bridged software engineering and Web/Cloud resource linking through an <strong>OMG MDA pipeline</strong>—formalizing <strong>XLink-CIM</strong>, designing the OCL-constrained <strong>XLinkUML profile</strong> in StarUML, and implementing the extensible <strong>XSLT-based U2XLink Transcoder</strong> to automatically generate both <strong>XLink schemas</strong> and <strong>OWL-L ontologies</strong>.
</div>

<div class="future-strip">
<div class="future-pill"><strong>🧠 1. Full OWL Ontology Reasoning</strong><br>Extend XLinkUML with richer OWL semantics to deduce new adaptation rules and intelligent link behaviors automatically.</div>
<div class="future-pill"><strong>☁️ 2. Cloud Service Discovery</strong><br>Apply visual XLinkUML + OWL-L linkbases to publish, compose, and discover distributed Cloud computing resources.</div>
<div class="future-pill"><strong>🔄 3. Round-Trip &amp; Empirical Eval</strong><br>Support bidirectional XLink ➔ UML reverse synchronization and conduct controlled usability trials with Web engineers.</div>
</div>

<!--
Conclusion & Future Roadmap (Section 9, pp. 655–656):
- Summary: Rather than editing raw, error-prone XML linkbases by hand, Web and Cloud developers can visually model complex multi-resource link topologies in standard UML, enforce traversal correctness via OCL invariants, and automatically transcode XMI into platform-specific XLink schemas or OWL-L ontologies.
- Future Direction Explicitly Identified by Authors: Extending the XLinkUML profile with Semantic Web OWL ontologies to deduce novel adaptation rules and enable higher-level agent intelligence over modeled XLink applications.
-->

---

<!-- _class: closing -->

# Thank You for Your Attention!

<p style="font-size: 1.05em; max-width: 860px;">
MDA-Based Visual Modeling Approach for Resources Link Relationships Using UML Profile
</p>

<div class="contact-card">
<strong>I-Ching Hsu<sup>a,*</sup></strong> (<code>hsuic@nfu.edu.tw</code>) · <strong>Der-Hong Ting<sup>b</sup></strong> · <strong>Nien-Lin Hsueh<sup>b</sup></strong><br>
<sup>a</sup> Dept. of Computer Science and Information Engineering, National Formosa University, Yunlin, Taiwan<br>
<sup>b</sup> Dept. of Information Engineering and Computer Science, Feng-Chia University, Taichung, Taiwan<br>
<span style="font-size: 0.85em; opacity: 0.88;">Computer Standards &amp; Interfaces (CSI), Vol. 36, pp. 648–656, 2014 · DOI: 10.1016/j.csi.2013.08.017</span>
</div>

<!--
Archival Citation & Funding Metadata:
- Citation: I-Ching Hsu, Der-Hong Ting, and Nien-Lin Hsueh, "MDA-based visual modeling approach for resources link relationships using UML profile," Computer Standards & Interfaces, Vol. 36, pp. 648–656, 2014.
- DOI: 10.1016/j.csi.2013.08.017
- Grant: National Science Council of the Republic of China, Taiwan, Contract No. NSC 97-2221-E-150-039.
- Keywords: UML profile, MDA, XLink, Software engineering, Cloud computing.
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

// Bilingual toggle preserving current slide hash
document.addEventListener('click', (e) => {
  const langBtn = e.target.closest('.lang-btn');
  if (!langBtn) return;
  e.preventDefault();
  const target = langBtn.getAttribute('href');
  if (target) window.location.href = target + (window.location.hash || '');
});
</script>
