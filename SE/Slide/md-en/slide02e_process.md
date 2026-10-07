---
marp: true
theme: ase-theme
_class: lead
paginate: true
header: 'Software Engineering | Ch 02: Software Processes'
footer: 'Ch 02 · Software Development Processes & Methodologies'
---
# Software Engineering

### Lecture 2: Software Development Processes & Methodologies

**Prof. Nien-Lin Hsueh**
Department of Information Engineering and Computer Science
Feng Chia University

<!--
Welcome everyone to Lecture 2 of Software Engineering. Today, we are exploring one of the most vital topics in modern computing: Software Development Processes and Methodologies.

When people first learn to program, they often believe that software engineering is just about writing code. But as systems grow larger and involve dozens or hundreds of engineers, the hardest problems are rarely about syntax. They are about coordination, managing changing requirements, catching defects early, and shipping reliably without burning out the team.

Over the next few hours, we are going to trace the history and the modern realities of software processes—from traditional Waterfall up to modern AI-assisted engineering.

To summarize this slide, remember this key takeaway: A disciplined process transforms coding from a chaotic personal craft into a reliable, repeatable engineering discipline.
-->
---
<!-- _class: outline outline-slide -->

## Chapter 2: Roadmap & Core Curriculum

<div class="outline-columns">
  <div>
    <h3>Part 1: Classic Paradigms & Agile Frameworks</h3>
    <ul>
      <li><b>2.1 Process & Process Models:</b> Core activities: specification, development, validation, evolution.</li>
      <li><b>2.2 Plan-Driven Paradigms:</b> Waterfall model, stage gates, and V-Model verification vs. validation.</li>
      <li><b>2.3 The Mechanics of Change:</b> Incremental delivery vs. iterative refinement, building the MVP.</li>
      <li><b>2.4 The Agile Mindset:</b> The Agile Manifesto, 4 core values, 12 principles, and embracing change.</li>
      <li><b>2.5 Agile Project Management:</b> Scrum sprints, ceremonies, roles, artifacts, and Kanban WIP limits.</li>
    </ul>
  </div>
  <div>
    <h3>Part 2: Technical Rigor, DevOps & AI Era</h3>
    <ul>
      <li><b>2.6 The Cost of Speed — Technical Debt:</b> Debt quadrant, compound interest, and refactoring strategies.</li>
      <li><b>2.7 Technical Rigor — XP:</b> Extreme Programming, pair programming, TDD, and continuous feedback.</li>
      <li><b>2.8 Systems & Culture — DevOps:</b> Breaking silos, CI/CD automated deployment pipelines, and observability.</li>
      <li><b>2.9 The Modern Frontier — AI Spec-Driven:</b> AI spec loops, human-in-the-loop, recap quiz & references.</li>
    </ul>
  </div>
</div>

<!--
Let's look at our roadmap for today. We have organized Chapter 2 into two major parts across nine logical modules.

On the left, in Part 1, we define software processes and models, examine plan-driven paradigms (Waterfall and V-Model), distinguish incremental from iterative delivery, and master Agile philosophy through Scrum and Kanban.

On the right, in Part 2, we confront the hidden cost of speed with Technical Debt, explore engineering discipline in Extreme Programming, examine DevOps and CI/CD pipelines, and explore modern AI specification-driven workflows.

To summarize this slide, remember this key takeaway: Software processes have evolved from rigid upfront plans to adaptive, automated, and AI-assisted feedback loops.
-->
---
## Focus Questions

* What is the fundamental difference between a **software process activity** and a **lifecycle model** (plan-driven vs. evolutionary)?
* How do **incremental delivery** and **iterative refinement** combine to build a **Minimum Viable Product (MVP)**?
* Why is **Agile** an overarching cultural mindset rather than a rigid framework, and how do **Scrum** and **Kanban** apply it?
* How do **XP engineering practices**, **DevOps pipelines**, and **AI spec-driven workflows** guarantee quality and eliminate **Technical Debt**?

<!--
Before we dive into the details, I want to plant these focus questions in your mind. These are the core questions you should be able to answer by the end of this lecture.

First, what is the fundamental difference between an everyday process activity—like testing or designing—and an overarching lifecycle model?

Second, how do incremental delivery and iterative refinement combine in practice when teams build a Minimum Viable Product?

Third, why do we say Agile is a cultural mindset rather than a rigid set of rules, and how do Scrum and Kanban implement this mindset differently?

Fourth, why does speed without engineering rigor lead to disastrous technical debt and what Martin Fowler calls 'Flaccid Scrum'?

And finally, in our new era of generative AI, how do we prevent sloppy 'vibe coding' and maintain architectural integrity?

To summarize this slide, remember this key takeaway: Keep these focus questions in mind as our guiding compass throughout today's lecture.
-->
---

<!-- _class: lead -->
<!-- header: '2.1 Process & Process Models' -->

# **2.1 Process and Process Models**

> "If a process is not predictable and repeatable, success is merely good luck."  
> — *Watts S. Humphrey*

<!--
Now we begin Module 2.1: Software Development Process and Process Models.

Before we write code or choose tools, we must understand the environment in which engineering happens. A software process defines what activities we perform, while a process model provides the strategic blueprint for sequencing and governing those activities.

As Watts Humphrey, the pioneer of software process maturity, famously observed: without a repeatable process, success is just an accident that you cannot reproduce.

To summarize this slide, remember this key takeaway: A disciplined process transforms software development from ad-hoc luck into a predictable engineering discipline.
-->
---
<!-- _class: title-image-slide -->

## Without a Process vs. With a Process Model

<div class="image-wrapper">
  <img src="../../img/ch02/comic_21_process.jpg" alt="Without a Process vs With a Process Model" />
</div>

<!--
Take a look at this comic on the screen. It contrasts two completely different engineering realities.

On the left side, we see development without a process. The developer is surrounded by pizza boxes, tangled wires, and panic. When a bug appears, they copy and paste random snippets from the internet, pray that the server doesn't crash, and scramble when production goes down. That is the chaotic world of ad-hoc coding.

Now look at the right side: development with a defined process model. The workspace is organized, tasks are clearly tracked, code is modular and backed by automated tests, and the team collaborates calmly.

A process is not about slowing you down with red tape; it is about giving your team a repeatable path to success.

To summarize this slide, remember this key takeaway: A good process does not slow you down; it protects you from chaos and gives you a clear path to deliver value safely.
-->
---
## Software Development Process & Process Models

* **What is a Software Process? (The Concrete Reality):**
  - A structured set of technical, collaborative, and managerial activities carried out to develop, deploy, and maintain software.
  - *ISO/IEC 12207 Standard:* "A set of interrelated or interacting activities which transforms inputs into outputs."
  - *Ian Sommerville:* "A structured set of activities required to develop a software system."
* **What is a Software Process Model? (The Strategic Blueprint):**
  - A simplified, abstract representation or architectural framework of a software process.
  - Defines the strategic sequencing of phases, transition criteria (entry/exit gates), roles, deliverables, and risk management policies (e.g., Waterfall, V-Model, Prototyping, Scrum).
* **The Core Distinction:**
  - **Process** is *what teams actually do* in practice (time-agnostic activities).
  - **Process Model** is the *theoretical blueprint or strategy* chosen to organize, sequence, and govern that work over time.

<!--
Let's start with our first core definition: What is a software process, and what is a process model?

A software process is the actual set of technical, collaborative, and managerial activities that you and your team perform to build and maintain software. The ISO/IEC 12207 standard defines it simply as a set of interacting activities that transforms inputs into outputs.

Now, what is a process model? A process model is an abstraction—a simplified, conceptual roadmap. Think of a process model like a city map. The map is not the city itself; it doesn't show every tree or pothole. But it gives you the overall layout so you know where you are going.

In software, process models help teams decide when to plan, when to build, when to test, and how to handle changes.

To summarize this slide, remember this key takeaway: A process is what we actually do, while a process model is the abstract strategy guiding how and when we do it.
-->
---
## Universal Process Activities: The 4 Pillars of SDLC

Regardless of which process model you adopt, **all software processes** encompass four universal activities:

1. **Software Specification (Requirements Engineering):**
   - Defining what the system should do, operational constraints, user stories, and acceptance criteria.
2. **Software Design & Implementation:**
   - Architecting structural blueprints and writing executable program code.
3. **Software Validation (Verification & Testing):**
   - Ensuring the software conforms to specifications and satisfies customer expectations.
4. **Software Evolution (Maintenance & Operations):**
   - Modifying, refactoring, and scaling existing software in response to changing user needs.

> 💡 **Key Insight:** Activities are time-agnostic actions. **Process models differ fundamentally in WHEN and HOW OFTEN these four activities take place!**

<!--
No matter what fancy methodology or buzzword your company uses—whether you follow Waterfall, Scrum, Kanban, or Extreme Programming—every software project must perform these four universal activities.

First is Software Specification: defining what the system must do, its constraints, and what users expect.

Second is Software Design and Implementation: creating the architecture, choosing data structures, and writing the actual code.

Third is Software Validation: checking that the system works correctly and actually meets customer needs. That includes unit testing, integration testing, and user reviews.

And fourth is Software Evolution: modifying, patching, and enhancing the system as business needs and technology evolve over time.

The difference between process models is not whether you do these activities, but how and when you organize them.

To summarize this slide, remember this key takeaway: Specification, Development, Validation, and Evolution are universal pillars present in every software project.
-->
---
## Landscape of Popular Software Process Models

* **The Spectrum: From Predictive (Plan-Driven) to Adaptive (Continuous):**
  - **1. Plan-Driven / Sequential Models:**
    - *Waterfall & V-Model:* Comprehensive upfront planning, linear sequential phases, strict milestone gates, and verification traceability.
  - **2. Evolutionary / Risk-Driven Models:**
    - *Spiral Model & Prototyping:* Cyclic spirals guided by explicit risk assessment and rapid exploratory user mockups.
  - **3. Iterative & Incremental Models:**
    - *Incremental Delivery & Agile Methods:* Delivering self-contained functional vertical slices in short, adaptive feedback sprints.
  - **4. Continuous & Spec-Driven Paradigms:**
    - *DevOps & CI/CD Pipelines:* Merging development and operations via automated test, build, and deploy loops.
    - *Specification-Driven AI:* Leveraging LLM coding agents strictly governed by formal specifications and automated verification gates.

<!--
This slide gives you a bird's-eye view of the software process landscape. We can think of process models along a spectrum from highly predictive to highly adaptive.

On the left, we have Plan-Driven or Sequential models like Waterfall and the V-Model. These emphasize thorough upfront planning, strict documentation, and sequential milestones.

In the middle, we have Evolutionary and Risk-Driven models like Boehm's Spiral Model, which use prototypes and cycles to explore unknowns.

Further along, we have Agile and Empirical models like Scrum, Kanban, and Extreme Programming, which prioritize rapid feedback, working software, and human collaboration.

And on the modern cutting edge, we have DevOps pipelines and AI Spec-Driven processes that automate testing and deployment.

There is no universally 'best' model; your choice depends on your project's risk, requirements volatility, and team size.

To summarize this slide, remember this key takeaway: There is no single best process model; the right choice depends on your project's risk, uncertainty, and regulatory environment.
-->
---

<!-- _class: lead -->
<!-- header: '2.2 Plan-Driven Paradigms' -->

# **2.2 Plan-Driven Paradigms (Waterfall & V-Model)**

> "Plan the work, then work the plan."  
> Predictability, stage-gate discipline, and verification traceability.

<!--
We now move into Module 2.2: Plan-Driven Paradigms, focusing on the classic Waterfall model and the V-Model.

For decades, plan-driven processes formed the bedrock of enterprise software engineering. By borrowing principles from civil and aerospace engineering, they emphasize exhaustive upfront requirements, formal milestone reviews, and rigorous stage-gate verification.

While modern agile advocates often criticize their rigidity, plan-driven approaches remain indispensable in safety-critical domains where failures cost human lives.

To summarize this slide, remember this key takeaway: Plan-driven paradigms trade flexibility for predictability, verification traceability, and strict milestone governance.
-->

---
## Plan-Driven Paradigms — Waterfall & the V-Model

> Plan-driven software process models where development proceeds through distinct, structured stages, prioritizing formal upfront planning, stage-gate governance, and verification traceability.

* **Underlying Philosophy:**
  - Borrowed from traditional engineering disciplines (civil, aerospace, manufacturing): complete comprehensive design *before* committing to construction to avoid catastrophic rework.
* **Core Plan-Driven Tenets:**
  - **Predictability:** Fixed budgets, fixed timelines, and predefined delivery milestones.
  - **Document-Centric Handoffs:** Detailed specifications serve as legally binding boundary contracts between specialized teams.
  - **Formal Verification:** Work cannot proceed to the next stage until the current stage passes formal review gates.

<!--
Now let's examine Module 2.2: Plan-Driven Paradigms, specifically Waterfall and the V-Model.

Where did the plan-driven philosophy come from? It was borrowed directly from traditional engineering disciplines like civil, aerospace, and mechanical engineering.

When you build a suspension bridge or a skyscraper, you cannot start pouring concrete while still wondering how many floors the building will have. You must complete thorough blueprints, conduct stress simulations, and get formal approvals before construction begins.

Plan-driven software models apply this exact philosophy: they prioritize predictability, formal contracts, clear milestones, and verification traceability over late changes.

To summarize this slide, remember this key takeaway: Plan-driven models prioritize predictability, formal contracts, and upfront architecture over mid-course flexibility.
-->
---
## The Waterfall Model: 5 Sequential Phases

<div class="content-columns">
<div class="content-text">

* **Historical Background:**
  - First described by **Winston W. Royce (1970)** in *"Managing the Development of Large Software Systems"*.
  - *Historical Irony:* Presented as a flawed process needing feedback loops!
* **The 5 Sequential Phases:**
  1. Requirements Analysis & Definition
  2. System & Software Design
  3. Implementation & Unit Testing
  4. Integration & System Testing
  5. Operation & Maintenance

</div>
<div class="content-figure">

<div class="name-card">
  <img src="../../img/ch02/winston_royce.jpg" alt="Winston W. Royce" />
  <div class="name-card-caption">
    <span class="name-card-name">Winston W. Royce</span>
    <span class="name-card-cc"><a href="https://en.wikipedia.org/wiki/Winston_W._Royce" target="_blank">Wikimedia Commons / Wikipedia</a></span>
  </div>
</div>

</div>
</div>

<!--
Here are the five classic sequential phases of the Waterfall model, first described by Dr. Winston Royce in 1970.

Phase 1 is Requirements Analysis and Definition: business analysts talk to customers and produce a detailed Software Requirements Specification (SRS).

Phase 2 is System and Software Design: architects design data schemas, component interfaces, and hardware requirements.

Phase 3 is Implementation and Unit Testing: developers write the programs and test individual modules.

Phase 4 is Integration and System Testing: all modules are assembled together and verified against the original requirements.

Phase 5 is Operation and Maintenance: the software is deployed and patched in production.

Notice the rule of the model: each phase has a strict milestone gate. You do not begin Phase 3 until Phase 2 is formally signed off.

To summarize this slide, remember this key takeaway: Waterfall structures development into strictly sequential phases separated by formal milestone sign-offs.
-->
---
<!-- _class: title-image-slide -->

## The Waterfall Software Lifecycle

<div class="image-wrapper">
  <img src="../../img/ch02/comic_waterfall_model.png" alt="Waterfall Software Lifecycle Comic" />
</div>

<!--
Look at this classic diagram of the Waterfall model. See how each phase cascades cleanly into the next, like water pouring down a flight of stone steps.

Interestingly, when Winston Royce published his original paper in 1970, he presented this purely linear diagram as an example of what NOT to do in complex software!

Royce pointed out that testing happens at the very end of the line. If you discover a fundamental design flaw during system testing in Phase 4, the feedback arrows must travel all the way back up to Phase 1 or 2.

In practice, discovering serious defects late causes schedule blowups and massive budget overruns.

To summarize this slide, remember this key takeaway: In a pure waterfall diagram, discovering a flaw during late testing forces costly and painful rework all the way back to the top.
-->
---
## The Waterfall Model: Applicability and Limitations

* **Applicability (Ideal Scenarios):**
  - **Stable & Well-Understood Requirements:** Specifications are thoroughly frozen upfront and will not change during development.
  - **Safety-Critical & Regulated Domains:** Medical devices, aerospace avionics, and defense systems requiring formal verification and audit traceability.
  - **Inflexible Hardware or Multi-Vendor Contracts:** Embedded hardware fabrication constraints or rigid legal stage-gate boundaries across vendors.
* **Limitations (Drawbacks & Risks):**
  - **Inflexible to Change:** Accommodating requirement modifications once development has started is extraordinarily expensive and disruptive.
  - **Late Risk & Defect Discovery:** System integration and testing occur near the end of the lifecycle; major architectural defects surface late.
  - **Delayed Working Software:** End users and customers cannot see or evaluate executable software until the final phase, creating a large visibility gap.

<!--
When does Waterfall work, and when does it fail? This is a critical engineering judgment you must develop.

Waterfall works well when three conditions hold: First, the requirements are completely understood, stable, and unlikely to change. Second, the technical domain and architecture are well known. And third, the system is subject to strict external regulations or safety standards. Think of nuclear plant controls, flight avionics, or embedded medical devices.

Where does Waterfall struggle? It struggles in consumer apps, web services, and startups. In those environments, users don't know what they want until they see it, and market conditions shift every month. If you spend 12 months writing documents before writing code, you risk building the wrong product.

To summarize this slide, remember this key takeaway: Waterfall excels in stable, highly regulated domains, but fails when requirements are uncertain or rapidly evolving.
-->
---
## Waterfall in Practice: Frequently Asked Questions (FAQ)

* **Q1: Are phases handed off strictly through documents?**
  - *Answer:* **Yes.** Classic Waterfall is plan-driven and document-centric. Formal artifacts (SRS, Architecture Specs, Test Plans) act as the binding contract and handoff mechanism between specialized phase teams (Analysts → Designers → Developers → Testers).
* **Q2: Can we really never go back to a previous phase?**
  - *Answer:* **In theory, no; in practice, yes, but at great expense.** When defects or oversights are discovered during testing, teams must backtrack. Revising signed specifications, architectures, and code causes severe delays ("backtracking tax").
* **Q3: When does the customer actually see working software?**
  - *Answer:* **Only at the very end.** Customers review documents and diagrams early on, but only interact with executable software in the final integration and testing phase, maximizing late-stage delivery risk.
* **Q4: Is the Waterfall model obsolete today?**
  - *Answer:* **No.** It remains the standard in safety-critical, regulated, and hardware-coupled domains (aerospace, defense, medical device firmware) where requirements are physically fixed and formal verification is legally mandated.

<!--
Let's answer two common questions students always ask about Waterfall.

Question 1: Are phases handed off like an assembly line with no going back?

In theory, pure Waterfall is strictly sequential. In practice, real-world engineering teams often use phased-gate hybrids. When unexpected issues arise, they do loop back, but doing so requires formal change control board reviews and re-baselining the budget and schedule.

Question 2: Does anyone actually still use Waterfall today?

Yes, absolutely! While consumer software has moved to Agile, massive government defense acquisitions, aerospace contracts, and banking core replacements still use plan-driven contracts because multiple subcontractors need frozen interface definitions.

To summarize this slide, remember this key takeaway: Real-world projects often adopt phased hybrids, but backtracking in a plan-driven project always incurs heavy overhead.
-->
---
### Concept Check Question 1 (CCQ 1)
<!-- id: ase-ch02-ccq1 -->

<div class="ccq-columns">
  <div class="ccq-text">

What is the primary operational drawback of the traditional Waterfall model?

- **A.** It produces inadequate documentation for external auditing and compliance.
- **B.** It makes accommodating changing requirements extremely difficult and costly once underway.
- **C.** It eliminates the need for component and system testing during execution.
- **D.** It cannot be deployed across large-scale multi-site engineering organizations.

  </div>
  <div class="ccq-logo">
    <a href="https://nlhsueh.github.io/nickedupocket/#/student/ase-ch02-ccq1" target="_blank"><img src="../../img/ch02/ase-ch02-ccq1.png" alt="QR Code" /></a>
  </div>
</div>

<!--
Let's test our understanding with Concept Check Question 1.

Read the prompt on screen: What is the primary operational drawback of the traditional Waterfall model?

Let's review the choices:
Option A is incorrect because Waterfall actually generates extensive documentation.
Option C is wrong because Waterfall includes dedicated testing phases at the end.
Option D is untrue because Waterfall has historically been used in massive government and aerospace projects across multiple sites.

The correct answer is Option B! In Waterfall, each phase must finish before the next begins. If requirements change once implementation or testing is underway, backtracking to redesign, rewrite code, and re-test creates enormous delay and cost.

To summarize this slide, remember this key takeaway: Waterfall's primary vulnerability is its rigidity when confronted with changing requirements midway through development.
-->
---
## The V-Model: Proactive Verification and Validation

> An extension of the Waterfall model that establishes a direct, symmetrical relationship between each development (specification) phase and its corresponding testing phase.

* **Why an "Extension of Waterfall"?**
  - It preserves the linear-sequential discipline, stage gates, and upfront documentation of Waterfall.
  - *The Key Difference:* Instead of treating testing as a late afterthought, it bends the lifecycle upward into a "V" shape to enforce **early, proactive test planning**.
* **Dual-Track Engineering Philosophy:**
  - **Left Arm (Decomposition & Design):** Requirements, System Architecture, Component Design.
  - **Right Arm (Integration & Validation):** Unit Testing, Integration Testing, Acceptance Testing.
  - **The Bottom Vertex:** Source code implementation (Coding).
  - *Core Insight:* While writing specifications on the left, engineers simultaneously author the test suites executed on the right!

<!--
Now let's examine the V-Model. The V-Model is an extension of Waterfall that directly addresses Waterfall's biggest flaw: late testing.

In Waterfall, testing was treated as a single phase at the end of the project. The V-Model changes this completely through proactive verification and validation.

Let's clarify these two terms:

Verification asks: 'Are we building the product right?' In other words, does our code conform to its specification?

Validation asks: 'Are we building the right product?' Does the software actually satisfy what the customer needs in the real world?

The core innovation of the V-Model is that test planning begins concurrently during the early specification and design phases, long before coding begins.

To summarize this slide, remember this key takeaway: The V-Model designs testing in parallel with development, shifting quality planning to the very beginning of the project.
-->
---
<!-- _class: title-image-slide -->

## The Software V-Model Architecture

<div class="image-wrapper">
  <img src="../../img/ch02/comic_v_model.png" alt="The Software V-Model Comic" />
</div>

<!--
Take a close look at this V-Model diagram. Notice its symmetrical shape.

On the left side, we move downward through the decomposition phases: Requirements Analysis, System Design, Architecture Design, and Module Design, culminating in Coding at the bottom tip.

Now look at the right side: we move upward through the integration and testing phases: Unit Testing, Integration Testing, System Testing, and Acceptance Testing.

Most importantly, look at the horizontal dashed arrows connecting the two sides!

Each phase on the left defines the test cases for the corresponding phase on the right. When you write requirements, you simultaneously write the acceptance test plan.

To summarize this slide, remember this key takeaway: Every level of design has a corresponding level of testing, established long before the code is even written.
-->
---
## The V-Model Architecture: Traceability & Test Levels

* **The 3 Symmetrical Verification Pairs:**
  1. **User Requirements $\longleft→ Acceptance Testing:**
     - *"Are we building the right system?"* Verifies that business workflows and end-user requirements are completely satisfied before release.
  2. **System Architecture $\longleft→ System Integration Testing:**
     - *"Are subsystems communicating properly?"* Validates API contracts, network protocols, and database integrations against architectural design.
  3. **Detailed Component Design $\longleft→ Unit / Component Testing:**
     - *"Are individual functions working correctly?"* Tests classes, algorithms, and boundary conditions against component specifications.
* **Horizontal Traceability:**
  - Establishes a bidirectional requirement traceability matrix: every requirement maps to an acceptance test, eliminating unverified features.

<!--
Let's look at the three symmetrical verification layers and how they ensure traceability.

At the lowest level, Component Design maps directly to Unit Testing. When you design a function or class interface, you define the unit tests that will verify its algorithms and boundary conditions.

At the middle level, System Architecture maps to Integration Testing. When you design API contracts and database connections, you define tests to verify that components communicate properly.

At the highest level, Business Requirements map to System Testing and Acceptance Testing (UAT).

Traceability means that every single test case points back to a documented requirement, and every requirement has an automated or scripted test verifying it.

To summarize this slide, remember this key takeaway: Requirements traceability ensures that nothing is built without a purpose and nothing is tested without a clear specification.
-->
---
## The V-Model: Applicability and Limitations

* **Strengths (The Good):**
  - **Proactive Defect Prevention:** Designing test cases during specification exposes ambiguities, contradictions, and omissions before writing code.
  - **High Traceability & Auditability:** Explicit 1:1 mapping between design documents and test verification suites.
  - **Disciplined Progress Tracking:** Simple to manage with well-defined deliverables at each level of the V.
* **Limitations (The Bad):**
  - **Rigid & Intolerant to Change:** Like Waterfall, any requirement modification requires updating both the left-arm specification and the right-arm test suite ("cascading rework").
  - **Delayed Executable Software:** No working prototype is produced during the left arm; integration occurs only when ascending the right arm.
* **Applicability (When to Use):**
  - Safety-critical, mission-critical, or heavily regulated domains (automotive ISO 26262, aviation DO-178C, medical device FDA) requiring strict verification certification.

<!--
What are the strengths and limitations of the V-Model?

Its primary strength is proactive defect prevention. Because you write test plans while designing, you catch requirement ambiguities and architectural holes before a single line of code is written. It provides unmatched auditability and regulatory compliance.

However, its limitation is the same as Waterfall's: it remains fundamentally sequential. If customer requirements change halfway through the project, you must update not only the requirement document, but also the system design, the architecture, and all associated test plans. That makes change very expensive.

To summarize this slide, remember this key takeaway: The V-Model maximizes verification rigor, but shares Waterfall's weakness when coping with unexpected requirements changes.
-->
---
### Concept Check Question 2 (CCQ 2)
<!-- id: ase-ch02-ccq2 -->

<div class="ccq-columns">
  <div class="ccq-text">

What is the primary engineering advantage of the V-Model over the classic Waterfall model?

- **A.** It produces working software increments in short two-week sprint iterations.
- **B.** It enforces test planning and acceptance criteria design concurrently with early specification phases.
- **C.** It eliminates the need for detailed architecture design and interface contracts.
- **D.** It allows customers to dynamically modify requirements at zero cost during implementation.

  </div>
  <div class="ccq-logo">
    <a href="https://nlhsueh.github.io/nickedupocket/#/student/ase-ch02-ccq2" target="_blank"><img src="../../img/ch02/ase-ch02-ccq2.png" alt="QR Code" /></a>
  </div>
</div>

<!--
Here is Concept Check Question 2.

Read the prompt on screen: What is the primary engineering advantage of the V-Model over the classic Waterfall model?

Let's look at the options:
Option A describes Scrum or Agile iterations, not the V-Model.
Option C is wrong because the V-Model relies heavily on architectural specifications and interface contracts.
Option D is impossible in plan-driven sequential models like Waterfall and V-Model.

The correct answer is clearly Option B! The core innovation of the V-Model is that test planning and acceptance criteria design are executed concurrently with the early specification phases—linking requirements to acceptance tests and system architecture to integration tests before code is ever written.

To summarize this slide, remember this key takeaway: The V-Model front-loads verification by designing test cases in parallel with early specification phases.
-->
---

### Interactive Activity: Process Model Matchmaker (Pair Discussion)

<div class="discussion-columns">
  <div class="discussion-text">

  **Process Model Matchmaker (Pair Discussion):**
  - **System A (Pacemaker Firmware):** Safety-critical, strict FDA certification, zero runtime bug tolerance.
  - **System B (Campus Food Delivery App):** Volatile user tastes, fierce startup rivals, fast pivot needed.
  - **System C (National Tax Overhaul):** Non-negotiable tax statutes, fixed legal launch deadline.
  - **Questions to Discuss with Your Partner:**
    - Which process model (Waterfall, V-Model, Agile/Scrum, or Spiral) fits each system best? Why?

  </div>
  <div class="discussion-logo">
    <img src="../../img/ch02/discussion_icon.svg" alt="Discussion" />
  </div>
</div>

<!--
Let's pause here for a quick, high-impact classroom activity: The Process Model Matchmaker! Turn to the person sitting next to you—you will work together as a pair of senior software engineering consultants.

Take a look at the three systems on the screen: System A is an implantable pacemaker firmware where a crash means a human life is lost, and the FDA must certify every requirement. System B is a campus food delivery startup where user tastes change every week and rivals are launching tomorrow. System C is a massive government tax portal rewrite with legally mandated tax codes and an unmovable legal filing deadline.

Spend the next three minutes discussing two questions with your partner:
First, which process model would your team select for each system—Waterfall, V-Model, Agile, or Spiral? What is your primary architectural justification?
Second, what catastrophic failure occurs if you apply rapid, unverified Agile or Vibe coding to the pacemaker, or rigid Waterfall to the campus delivery app?
---

**Possible Answers & Debriefing Guide:**

1. **System A (Pacemaker Firmware) -> V-Model (or Formal Plan-Driven Waterfall)**
   - *Rationale:* Life-critical (Class III medical device). Safety and regulatory approval (FDA, ISO 13485) require exhaustive bidirectional traceability from every requirement to clinical acceptance tests before code execution.
   - *Failure if misused:* Agile/Vibe coding with minimal upfront testing can result in fatal cardiac malfunctions requiring high-risk invasive explantation surgery.

2. **System B (Campus Food Delivery App) -> Agile / Scrum (or Kanban)**
   - *Rationale:* Highly volatile market, rapid user feedback needed, low architectural risk. The team must deploy an MVP in 30 days and iterate weekly based on student ordering patterns and merchant feedback.
   - *Failure if misused:* Pure Waterfall spends 6 months drafting requirements documents; by release day, competitors dominate the campus and student preferences have shifted.

3. **System C (National Tax Overhaul) -> Hybrid Model (Plan-Driven Core + Agile Edge)**
   - *Rationale:* The underlying tax calculation engine is legally mandated and fixed by statutory tax codes, requiring strict plan-driven V-Model testing. However, the citizen e-filing web/mobile portal requires Agile sprint iterations for usability and stress testing.
   - *Failure if misused:* Pure Agile risks audit failure and calculation penalties; pure Waterfall risks an unusable, confusing frontend that crashes under tax-day peak loads.

**To wrap up this slide, here is the key takeaway to remember:** Process models are not one-size-fits-all; engineering maturity means choosing the model that aligns with system risk, regulatory compliance, and requirement volatility.
-->
---

<!-- _class: lead -->
<!-- header: '2.3 Incremental & Iterative' -->

# **2.3 The Mechanics of Change (Incremental & Iterative)**

> "Incremental delivery gives you pieces early; iterative development refines the whole over time.  
> Together, they build a Minimum Viable Product."

<!--
Welcome to Module 2.3: The Mechanics of Change — Incremental and Iterative Development.

In this section, we demystify two concepts that are constantly confused in industry discussions. Incremental development builds and delivers the system in functional pieces, while iterative development starts with a rough sketch of the whole and refines it through repeated feedback loops.

When combined, they give birth to the modern concept of the Minimum Viable Product: delivering real, usable end-to-end value from day one.

To summarize this slide, remember this key takeaway: Combining incremental staging with iterative feedback enables teams to validate assumptions rapidly with minimal waste.
-->

---
## The Mechanics of Change — Incremental & Iterative Development

> An engineering approach that decomposes a complex system into smaller, self-contained functional components delivered in successive stages (**increments**) while progressively refining and deepening capabilities through cyclic feedback (**iterations**).

* **Historical Background & Motivation:**
  - Emerged in the 1970s and 1980s (Mills, Basili, Boehm) in direct response to the rigidity, specification freezing, and late-stage defect discovery of the Waterfall model.
  - Replaced "Big Bang" release cycles with **continuous, incremental value realization**.
* **Core Engineering Philosophy:**
  - **Early Value Realization:** Deliver high-priority, usable subsets to users early rather than waiting for full completion.
  - **Empirical Validation:** Validate architectural choices and business assumptions with executable software instead of paper specifications.
  - **Feedback-Driven Adaptation:** Real-world user feedback from early increments directly steers subsequent design and development cycles.

<!--
Let's define these two terms with absolute clarity.

Incremental development is about functional partitioning. You break down a large system into smaller functional chunks, or increments. Increment 1 gives you a working piece of the system; Increment 2 adds another piece, and so on.

Iterative development is about progressive refinement through feedback. You build an initial, rough version of the system, expose it to users, learn from their reactions, and refine and improve it across successive cycles.

In modern software, we rarely use one without the other—we combine them!

To summarize this slide, remember this key takeaway: Incremental builds the system piece by piece; iterative refines and improves each piece through successive cycles.
-->
---
## Incremental Delivery: Functional Partitioning & Value Staging

* **Vertical Functional Slicing:**
  - The system is divided into self-contained vertical slices delivered stage by stage.
  - Each increment delivers 100% finished functionality for a specific subset of features (UI + Business Logic + Database persistence).
* **Staging High-Priority Value to Users:**
  - **Increment 1:** User Registration, Login & Restaurant Menu Search.
  - **Increment 2:** Shopping Cart & Online Checkout.
  - **Increment 3:** Personalized Recommendation Engine & Analytics.
* **Operational Business Benefit:**
  - The customer receives tangible, working business value early, rather than waiting years for a "Big Bang" complete release.

<!--
Let's look at Incremental Delivery in detail.

Instead of trying to deliver an entire 50-feature enterprise system all at once on day 300, we deliver features in staged releases.

In Release 1, we deliver the most critical vertical slice—say, user authentication and basic data entry. That slice goes to real users.

In Release 2, we add reporting and search. In Release 3, we add third-party integrations.

The business benefit is huge: your client starts earning return on investment on Day 60 rather than Day 300, and early user feedback guides subsequent releases.

To summarize this slide, remember this key takeaway: Incremental delivery partitions a large project into deliverable functional slices, delivering early value to stakeholders.
-->
---
<!-- _class: title-image-slide -->

## The Incremental Delivery Process

<div class="image-wrapper">
  <img src="../../img/ch02/incremental_delivery_handwrite.png" alt="The Incremental Delivery Process Whiteboard Sketch" />
</div>

<!--
Look at this handwritten-style illustration of incremental delivery.

Notice how each release is a complete, working layer of functionality.

Release 1 gives the user a working baseline. Release 2 stacks another functional capability on top. Release 3 adds further features.

Each increment must be fully designed, coded, tested, and integrated. An increment is not half-finished code; it is a working, deployable subset of the full system.

To summarize this slide, remember this key takeaway: Each incremental release must be a coherent, usable piece of functionality, not half-finished code.
-->
---
## Iterative Development & The Sculptor Analogy

* **Progressive Refinement of the Whole:**
  - An incomplete version of the *entire* system is created first, then repeatedly revised, deepened, and polished based on empirical feedback.
* **The Sculptor Metaphor:**
  - **Iteration 1 (Rough Silhouette):** Chisel the general shape out of a raw block of marble.
  - **Iteration 2 (Proportions & Limbs):** Carve the major muscle groups, limbs, and facial outline.
  - **Iteration 3 (Detailing):** Define fine hair, hands, and facial expression.
  - **Iteration 4 (Surface Polish):** Smooth the marble surfaces to a polished sheen.
* **Core Takeaway:**
  - Every iteration touches and refines the whole product, allowing continuous validation of overall proportions!

<!--
Now let's examine Iterative Development through the famous Sculptor Analogy.

Imagine a sculptor creating a statue from a block of marble.

How does the sculptor work? Do they carve the left foot to 100% polished perfection, paint the toenails, and then move on to the right foot?

Of course not! If they did that, they might discover six months later that the torso doesn't fit the legs, and the entire block of marble would be ruined.

Instead, the sculptor chips away rough outlines of the entire body. Then they refine the curves, carve out facial features, and finally polish the surface.

In software, building a rough 'walking skeleton' first allows you to test end-to-end architecture early.

To summarize this slide, remember this key takeaway: Iteration develops software like a sculptor: starting with a rough overall skeleton and refining details across repeated passes.
-->
---
<!-- _class: title-image-slide -->

## Delivering Value vs. Refining Fidelity: The Sculptor Analogy

<div class="image-wrapper">
  <img src="../../img/ch02/comic_mvp_sculptor.jpg" alt="Delivering Value vs. Refining Fidelity: MVP vs Sculptor Comic" />
</div>

<!--
Look at this visual diagram of the Sculptor Analogy.

In Stage 1, we have a rough stone block with basic guide lines.

In Stage 2, the general silhouette of the figure emerges.

In Stage 3, the arms, head, and posture are clearly defined.

In Stage 4, the finished, polished statue stands complete.

Notice that at every stage, the sculptor is working on the whole system, not an isolated fragment. In software, this is how we refine user experience, performance, and architecture iteratively.

To summarize this slide, remember this key takeaway: An iterative walking skeleton proves system architecture early before investing heavily in fine details.
-->
---
## Combined Model (Incremental + Iterative) & The MVP

* **Real-World Agility Combines Both Dimensions:**
  - Deliver functional slices incrementally, while continuously refining existing slices iteratively based on user telemetry.
* **The Henrik Kniberg Car Metaphor:**
  - *Wrong (Pure Incremental without Usability):* Delivering a Wheel → Axle → Chassis → Car.
    - *(A user cannot commute to work on a detached rubber wheel!).*
  - *Right (Combined MVP Progression):* Skateboard → Scooter → Bicycle → Motorcycle → Car.
    - *(Every release provides an end-to-end usable transportation capability!).*
* **Definition of Minimum Viable Product (MVP):**
  - The smallest functional product slice that delivers real user value and allows the team to collect the maximum amount of validated customer learning with the least effort.

<!--
In modern Agile engineering, we combine both models to build a Minimum Viable Product, or MVP.

What is an MVP? Frank Robinson coined the term, and Eric Ries popularized it in *The Lean Startup*.

An MVP is the smallest version of a product that allows a team to collect the maximum amount of validated learning about customers with the least effort.

Notice the word: Viable. An MVP is not a broken prototype or a random pile of buggy code. It is a complete, functioning slice that genuinely solves a core problem for early adopters.

To summarize this slide, remember this key takeaway: An MVP must be a complete, viable solution to a user problem at every stage, not an unusable component of a larger machine.
-->
---
<!-- _class: title-image-slide -->

## Incremental & Iterative MVP Progression

<div class="image-wrapper">
  <img src="../../img/ch02/comic_combined_model.jpg" alt="Combined Model: Incremental + Iterative MVP Progression" />
</div>

<!--
Look at this classic illustration by Henrik Kniberg. It is one of the most famous diagrams in software engineering.

Look at the top row: What NOT to do.

The customer wants a car. In Step 1, you give them a single wheel. Can they use it? No, they are angry! In Step 2, you give them an axle. Still unusable. In Step 3, you give them a car body with no engine. Still useless! Only at Step 4 do they get a working vehicle.

Now look at the bottom row: The Agile MVP way.

The customer's core need is transportation. In Step 1, you give them a skateboard. It's simple, but it rolls and gets them places! In Step 2, you add a handlebar to make a scooter. In Step 3, you build a bicycle. In Step 4, a motorcycle. And in Step 5, a convertible car!

At every single stage, the customer has a working, valuable product.

To summarize this slide, remember this key takeaway: Deliver viable, working transportation first, then iterate toward greater speed and luxury.
-->
---
## Can Incremental Be Applied Alone? A Food Delivery Case Study

* **Food Order & Delivery System Example:**
  - **Spring 1 (MVP — Core Flow):** Browse simple text menu → Cash on Delivery → Driver phone dispatch. *(Entire vertical flow works!)*
  - **Spring 2 (Incremental Addition):** Add Online Credit Card Payment slice.
  - **Spring 3 (Iterative Refinement):** Upgrade driver phone dispatch to Real-Time GPS Map Tracking.
* **Why Incremental Alone Fails in Modern Software:**
  - If you spend 6 months building a pristine restaurant catalog without checkout or delivery, users starve and cannot order food.
  - **Architectural Synergy:** Incremental adds new capability boundaries; Iterative deepens quality, performance, and user experience.

<!--
Now let's ask a challenging question: Can Incremental delivery be applied alone, without Iterative refinement?

Let's consider a food delivery app like UberEats or Foodpanda.

Suppose your team decides to be strictly incremental: in Sprint 1, you build the Restaurant Menu catalog. In Sprint 2, you build the Shopping Cart. In Sprint 3, you build Payment.

What happens when users actually try to order? They might say: 'I want to add special cooking instructions to each dish, but your frozen Menu component doesn't support notes!'

If your process forbids iterating on previously shipped increments, your system will be rigid and frustrating. In software, new increments almost always reveal necessary improvements to existing modules.

To summarize this slide, remember this key takeaway: Incremental delivery without iterative refinement is vulnerable, because real-world software features constantly require adjustments as new capabilities are introduced.
-->
---
### Concept Check Question 3 (CCQ 3)
<!-- id: ase-ch02-ccq3 -->

<div class="ccq-columns">
  <div class="ccq-text">

In software process engineering, what is the fundamental conceptual difference between "Incremental" and "Iterative" development?

- **A.** Incremental focuses on automated testing; Iterative focuses on UI design.
- **B.** Incremental delivers finished functional slices stage-by-stage; Iterative progressively refines and deepens an evolving system through repeated feedback cycles.
- **C.** Incremental requires frozen upfront specifications; Iterative eliminates all documentation.
- **D.** Incremental is used solely for hardware; Iterative is used solely for cloud software.

  </div>
  <div class="ccq-logo">
    <a href="https://nlhsueh.github.io/nickedupocket/#/student/ase-ch02-ccq3" target="_blank"><img src="../../img/ch02/ase-ch02-ccq3.png" alt="QR Code" /></a>
  </div>
</div>

<!--
Let's check our understanding with Concept Check Question 3.

Read the prompt on screen: In software process engineering, what is the fundamental conceptual difference between "Incremental" and "Iterative" development?

Let's examine the options:
Option A incorrectly claims Incremental focuses on automated testing and Iterative on UI design.
Option C claims Iterative eliminates documentation, which is a classic misconception.
Option D suggests an arbitrary split between hardware and cloud software.

The correct answer is Option B! Incremental development delivers finished functional slices stage-by-stage (like adding finished rooms to a house), whereas Iterative development progressively refines and deepens an evolving system through repeated feedback cycles (like a sculptor refining clay).

To summarize this slide, remember this key takeaway: Incremental builds feature by feature, while iterative refines the whole system cycle by cycle.
-->
---
### Concept Check Question 4 (CCQ 4)
<!-- id: ase-ch02-ccq4 -->

<div class="ccq-columns">
  <div class="ccq-text">

In Henrik Kniberg's famous Minimum Viable Product (MVP) analogy (Skateboard to Car), why is delivering a standalone car wheel in the first release considered an anti-pattern?

- **A.** Because manufacturing an isolated wheel is significantly more expensive than building a skateboard.
- **B.** Because a detached wheel provides zero usable transportation value and yields no validated user learning.
- **C.** Because a wheel violates standard continuous integration and automated test coverage thresholds.
- **D.** Because a wheel cannot be deployed without prior sign-off from international automotive regulatory bodies.

  </div>
  <div class="ccq-logo">
    <a href="https://nlhsueh.github.io/nickedupocket/#/student/ase-ch02-ccq4" target="_blank"><img src="../../img/ch02/ase-ch02-ccq4.png" alt="QR Code" /></a>
  </div>
</div>

<!--
Let's test our understanding of the Minimum Viable Product with Concept Check Question 4.

Take a look at the question: In Henrik Kniberg's famous MVP analogy of moving from a skateboard to a car, why is delivering just a single car wheel in the very first release considered a failure of the MVP concept?

Look at the choices. Option A talks about manufacturing costs, Option C mentions test coverage, and Option D brings up regulatory bodies.

The correct answer is Option B! Why? Because the core definition of an MVP is that it must be viable—it must solve a real user problem. A wheel sitting alone on the floor cannot transport anyone. It gives the user zero value and gives the engineering team zero real feedback on whether their transportation concept works. A skateboard, while humble, is a complete working vehicle that moves people from day one!

To summarize this slide, remember this key takeaway: An MVP must deliver immediate, usable end-to-end value rather than an isolated, unusable component.
-->
---

### Interactive Activity: Slicing a Chess App (Group Discussion)

<div class="discussion-columns">
  <div class="discussion-text">

  **Slicing a Web Chess Application (Group Discussion):**
  - **Scenario:** Your team must build a full-featured Web Chess game in one semester.
  - **Question 1 (Incremental Slicing):**
    - Define 3–4 functional increments that deliver end-to-end playable value at each stage.
  - **Question 2 (Iterative Refinement):**
    - Pick the *Chess Board UI*. How does it evolve iteratively across releases?
  - **Question 3 (Anti-Pattern):**
    - What fatal mistake occurs if you build "Incrementally without Iteration"?

  </div>
  <div class="discussion-logo">
    <img src="../../img/ch02/discussion_icon.svg" alt="Discussion" />
  </div>
</div>

<!--
Let's dive into our second classroom activity: Slicing a Web Chess Application! This exercise will make the abstract distinction between Incremental and Iterative development crystal clear.

Imagine your project team has one semester to build and launch an online chess platform. Many student teams fail because they spend four months building a beautiful 3D piece rendering engine, but by the end of the term, players still can't move a pawn across the board!

Work with your group to answer the three questions on screen: How do you slice it incrementally? How do you refine the UI iteratively? And what fatal anti-pattern must you avoid?
---

**Possible Answers & Debriefing Guide:**

1. **Question 1 — Incremental Slicing (Delivering Finished Functional Slices Stage-by-Stage):**
   - *Increment 1 (Playable Local Core):* 2-player local pass-and-play on 1 screen. 8x8 board representation, basic legal moves (pawn, knight, rook, bishop, queen, king), turn switching, win by king capture. (End-to-end playable on day one!).
   - *Increment 2 (Rules & Clock):* Check/checkmate detection, castling, en passant, move history notation (PGN export), and a countdown chess clock timer.
   - *Increment 3 (Single-Player AI):* AI bot opponent with adjustable difficulty levels using heuristic Minimax / Alpha-Beta pruning or Stockfish API integration.
   - *Increment 4 (Online Multiplayer):* WebSocket real-time multiplayer lobby, room match codes, user accounts, and Elo matchmaking rating.

2. **Question 2 — Iterative Refinement (Evolving Qualitative Depth Across Cycles):**
   - *Iteration 1 (Functional Prototype / ASCII):* Console text grid or plain HTML table with character symbols to verify coordinate math and board state logic.
   - *Iteration 2 (Interactive Canvas / SVG):* 2D responsive board with SVG vector pieces, click-to-move interaction, and valid move dot highlights.
   - *Iteration 3 (Polished Production Delight):* Smooth drag-and-drop piece animations, sound effects for moves/captures/checks, premove queuing, and accessibility screen-reader support.

3. **Question 3 — Anti-Pattern ("Incrementally without Iteration" / Standalone Car Wheel):**
   - *The Anti-Pattern:* Building components to 100% finished fidelity in silos before integration—such as spending 8 weeks perfecting 3D photorealistic piece models and lighting shaders before implementing piece movement.
   - *The Disaster:* The team ends up with isolated, unusable assets that cannot be tested with real players and inevitably fail when integrated days before the final deadline.

**To wrap up this slide, here is the key takeaway to remember:** Incremental slicing delivers functional feature sets piece by piece, while iterative refinement deepens the fidelity and quality of those features through continuous user feedback.
-->
---

<!-- _class: lead -->
<!-- header: '2.4 Agile Philosophy' -->

# **2.4 The Mindset Shift (Agile Philosophy)**

> "Responding to change over following a plan."  
> — *The Agile Manifesto (2001)*

<!--
We now transition into Module 2.4: The Mindset Shift — Agile Philosophy.

At the turn of the millennium, high software failure rates led seventeen visionary software leaders to gather in Utah and draft the Agile Manifesto.

Agile is not a project management tool, a certification, or a set of mandatory meetings. It is fundamentally a cultural mindset that values human collaboration, working software, and rapid adaptation to evolving realities over rigid documentation.

To summarize this slide, remember this key takeaway: Agile is an overarching cultural mindset and value system, not a rigid set of bureaucratic rituals.
-->
---
<!-- _class: title-image-slide -->

## The Mindset Shift: Traditional vs. Agile Philosophy

<div class="image-wrapper">
  <img src="../../img/ch02/comic_24_agile.jpg" alt="Agile Manifesto Comic" />
</div>

<!--
Now we enter Module 2.4: The Mindset Shift — Agile Philosophy.

Look at this comic comparing the traditional mindset with the Agile mindset.

On the left, look at the traditional meeting: managers in suits are surrounded by towers of 500-page specification binders. They are fiercely arguing over change-request forms while the market has already moved on.

On the right, look at the Agile team: developers and business partners are standing together around a whiteboard, looking at real user feedback, adapting their backlog, and smiling because they just released working code.

Agile is not a set of bureaucratic rules; it is an attitude of responsiveness, human respect, and practical focus.

To summarize this slide, remember this key takeaway: Agile is not a set of bureaucratic rules; it is an organizational mindset prioritizing customer value and adaptive teamwork.
-->
---
## The Mindset Shift — Agile Philosophy

> Agile is **not** a set of bureaucratic rules, a Jira board, or a collection of meetings. Agile is an overarching **cultural mindset and value system** that prioritizes **individuals**, **working software**, **customer collaboration**, and **adaptability** over **rigid plans**.

* **Historical Context: The 1990s Software Crisis:**
  - Massive software projects were failing at alarming rates (Standish Group Chaos Reports: >70% challenged or cancelled).
  - Teams spent years producing thick requirement binders while the real-world market moved past them.
* **The Snowbird Summit (February 2001):**
  - 17 software pioneers (representing Extreme Programming, Scrum, DSDM, Crystal, Feature-Driven Development) gathered in Snowbird, Utah.
  - Despite different methodology backgrounds, they found common ground and drafted the **Agile Manifesto**.

<!--
How did the Agile movement begin?

In February 2001, seventeen software luminaries—including Kent Beck, Ward Cunningham, Martin Fowler, Robert Martin, Alistair Cockburn, and Jeff Sutherland—met at the Snowbird ski resort in Utah.

They came from different methodological backgrounds: Extreme Programming, Scrum, DSDM, Crystal, and Feature-Driven Development.

Despite their differences, they all agreed on one thing: the software industry was suffering under heavyweight, document-driven methodologies that produced endless paperwork but delayed, defective software.

Together, they drafted the Agile Manifesto.

To summarize this slide, remember this key takeaway: The Agile movement arose as a practical rebellion against heavyweight, document-heavy software processes.
-->
---
## The Agile Manifesto: 4 Core Values

In 2001, the **Agile Manifesto** established four fundamental value pairs:

* **Individuals and interactions** over processes and tools
* **Working software** over comprehensive documentation
* **Customer collaboration** over contract negotiation
* **Responding to change** over following a plan

* > 💡 *“That is, while there is value in the items on the right, we value the items on the left more.”*

* **The Core Cultural Realization:**
  - Processes and tools are useless if developers cannot communicate openly.
  - Comprehensive documentation is worthless if the software does not execute.
  - Rigid contracts breed adversarial relationships; collaboration builds great products.
  - A detailed five-year plan is an illusion in an unpredictable market.

<!--
Here are the four core values of the Agile Manifesto. You should know these by heart.

1. Individuals and interactions over processes and tools.

2. Working software over comprehensive documentation.

3. Customer collaboration over contract negotiation.

4. Responding to change over following a plan.

Now, pay very close attention to the sentence at the bottom:

'That is, while there is value in the items on the right, we value the items on the left more.'

Agile does NOT say: 'Never write documentation' or 'Never follow a plan.' It says when there is a trade-off, working software and human collaboration must take priority!

To summarize this slide, remember this key takeaway: Agile balances values: it cherishes individuals, working code, collaboration, and responsiveness over rigid processes and paperwork.
-->
---
<!-- _class: title-image-slide -->

## The Agile Manifesto: 4 Core Values on the Balance Scale

<div class="image-wrapper">
  <img src="../../img/ch02/agile_manifesto_values.jpg" alt="The Agile Manifesto: 4 Core Values with Comics" />
</div>

<!--
Take a look at this balance scale diagram.

On the left scale, heavy with golden weight, are our primary Agile values: Individuals and Interactions, Working Software, Customer Collaboration, and Responding to Change.

On the right scale are Processes and Tools, Documentation, Contracts, and Plans.

Notice that both sides exist on the balance! Good teams still use Git, still write API docs, and still make sprint plans. But whenever process threatens to choke collaboration, or documentation prevents shipping working code, the scale tips decisively to the left.

To summarize this slide, remember this key takeaway: The Manifesto does not discard process or planning; it re-centers our primary loyalty onto human collaboration and working software.
-->
---
## The 12 Principles of Agile Software

<div class="two-columns">
<div class="card" data-marpit-fragment>

### Principles 1 – 6: Value & People
1. **Customer Satisfaction:** Satisfy the customer through early and continuous delivery of valuable software.
2. **Welcome Change:** Harness changing requirements for the customer's competitive advantage, even late.
3. **Frequent Delivery:** Deliver working software frequently, from a couple of weeks to a couple of months.
4. **Daily Collaboration:** Business stakeholders and developers must work together daily throughout the project.
5. **Motivated Individuals:** Build projects around motivated people; provide environment, support, and trust.
6. **Face-to-Face Conversation:** The most effective method of conveying information is direct conversation.

</div>
<div class="card" data-marpit-fragment>

### Principles 7 – 12: Delivery & Discipline
7. **Working Software:** Working software is the primary measure of progress.
8. **Sustainable Pace:** Maintain a constant, sustainable development pace indefinitely.
9. **Technical Excellence:** Continuous attention to technical excellence and good design enhances agility.
10. **Simplicity:** The art of maximizing the amount of work not done is essential.
11. **Self-Organizing Teams:** The best architectures, requirements, and designs emerge from self-organizing teams.
12. **Regular Reflection:** Regularly reflect on how to become more effective, then tune and adjust.

</div>
</div>

<!--
Supporting those four values are the 12 Principles of Agile Software. Let's look at four crucial highlights:

Principle 1: Our highest priority is to satisfy the customer through early and continuous delivery of valuable software.

Principle 2: Welcome changing requirements, even late in development. Agile processes harness change for the customer's competitive advantage.

Principle 4: Business people and developers must work together daily throughout the project.

And Principle 8: Sustainable development. Sponsors, developers, and users should be able to maintain a constant, healthy pace indefinitely—no 80-hour death marches!

To summarize this slide, remember this key takeaway: The 12 principles translate Agile values into daily operating habits for healthy, sustainable engineering teams.
-->
---
### Concept Check Question 5 (CCQ 5)
<!-- id: ase-ch02-ccq5 -->

<div class="ccq-columns">
  <div class="ccq-text">

The Agile Manifesto states: *"Working software over comprehensive documentation."* What does this value primarily advocate in practice?

- **A.** Engineering teams are completely prohibited from writing architecture blueprints or API specifications.
- **B.** While documentation has value, delivering functional software that solves user problems is the primary measure of progress.
- **C.** Software architectures should be created completely ad-hoc during coding without any upfront thought.
- **D.** Documentation should only ever be written if mandated by external government regulatory auditors.

  </div>
  <div class="ccq-logo">
    <a href="https://nlhsueh.github.io/nickedupocket/#/student/ase-ch02-ccq5" target="_blank"><img src="../../img/ch02/ase-ch02-ccq5.png" alt="QR Code" /></a>
  </div>
</div>

<!--
Here is Concept Check Question 5 on the core values of the Agile Manifesto.

The Manifesto says: 'Working software over comprehensive documentation.' What does this actually mean when you are working on an engineering team?

Notice Option A and Option C: these represent the classic misconception that Agile means 'never write docs' or 'code without design.' That is completely false!

The correct answer is Option B: the Manifesto explicitly reminds us that while documentation has real value, our primary measure of success and progress must always be working, tested software in the hands of users. Documentation that sits on a shelf while the software doesn't work is useless.

To summarize this slide, remember this key takeaway: Agile values working software as the ultimate truth of project progress without discarding useful documentation.
-->
---
### Concept Check Question 6 (CCQ 6)
<!-- id: ase-ch02-ccq6 -->

<div class="ccq-columns">
  <div class="ccq-text">

Agile Principle 8 states: *"Agile processes promote sustainable development. The sponsors, developers, and users should be able to maintain a constant pace indefinitely."* What is the primary engineering motivation?

- **A.** To prevent code quality degradation, accumulated defects, and burnout caused by sustained overtime and 'crunch modes.'
- **B.** To enforce that every developer on the team writes the exact same number of lines of code each day.
- **C.** To ensure that software project budgets remain permanently fixed across all financial quarters.
- **D.** To prevent customers from submitting new feature requests after the first sprint planning session.

  </div>
  <div class="ccq-logo">
    <a href="https://nlhsueh.github.io/nickedupocket/#/student/ase-ch02-ccq6" target="_blank"><img src="../../img/ch02/ase-ch02-ccq6.png" alt="QR Code" /></a>
  </div>
</div>

<!--
Let's look at Concept Check Question 6, focusing on the 12 Agile Principles.

Principle 8 emphasizes sustainable development—that everyone involved should maintain a constant, steady pace indefinitely. Why did the authors of the Agile Manifesto make this a core principle?

Look at the choices. The correct answer is Option A. In the bad old days of software development, teams worked 80-hour weeks in 'crunch mode' or 'death marches' before a deadline. When developers are exhausted, they make careless architectural mistakes, skip tests, and write buggy code that takes months to fix. A sustainable pace protects both team health and software quality over the long run.

To summarize this slide, remember this key takeaway: Sustainable engineering pace prevents burnout and protects codebase quality over the long run.
-->
---

<!-- _class: lead -->
<!-- header: '2.5 Scrum & Kanban' -->

# **2.5 Agile Project Management (Scrum & Kanban)**

> "Scrum establishes the cadence; Kanban optimizes the flow.  
> Stop starting, start finishing."  
> — *Henrik Kniberg*

<!--
Welcome to Module 2.5: Agile Project Management — Scrum and Kanban.

While the Agile Manifesto articulates core values, teams need practical operating mechanisms on Monday morning to coordinate work, manage backlogs, and track progress.

In this module, we contrast the two most widely adopted Agile frameworks: Scrum, which organizes work into timeboxed Sprint rhythms with defined roles, and Kanban, which maximizes throughput by visualizing work and strictly limiting work-in-progress.

To summarize this slide, remember this key takeaway: Scrum provides timeboxed cadences for sprint goals, while Kanban optimizes continuous flow by restricting WIP bottlenecks.
-->
---
<!-- _class: title-image-slide -->

## Agile Project Management: Scrum Sprints vs. Kanban Pull Flow

<div class="image-wrapper">
  <img src="../../img/ch02/comic_25_scrum_kanban.jpg" alt="Scrum Sprints vs Kanban Pull Flow Comic" />
</div>

<!--
Now we move into Module 2.5: Agile Project Management — Scrum & Kanban.

Look at this comic contrasting the two most popular agile project management frameworks.

On the left, we see a Scrum team running in fixed 2-week Sprints. They plan together, hold daily 15-minute standup meetings, and deliver a shippable increment at the end of each sprint.

On the right, we see a Kanban team managing a continuous flow. They visualize their workflow on a board and set strict limits on Work-In-Progress (WIP) to prevent bottlenecks.

Let's explore how both frameworks work in practice.

To summarize this slide, remember this key takeaway: Scrum organizes work into timeboxed sprint rhythms, whereas Kanban manages continuous flow by limiting work-in-progress.
-->
---
## Agile Project Management — Scrum & Kanban

> Agile management frameworks organize team collaboration, cadences, and work tracking. They govern HOW WORK IS COORDINATED, but are deliberately silent on how code is engineered.

* **Why Do We Need Project Management Frameworks?**
  - The Agile Manifesto gives philosophy, but doesn't tell a team what to do on Monday morning!
  - Teams need concrete mechanisms to prioritize backlog items, synchronize daily efforts, and inspect deliverables.
* **The Two Dominant Management Paradigms:**
  - **Scrum:** Timeboxed cadence (Sprints), fixed roles, ceremonies, and committed sprint backlogs.
  - **Kanban:** Continuous flow, pull-based delivery, visual cards, and strict Work In Progress (WIP) limits.

<!--
Remember: Agile is the overarching philosophy, but Scrum and Kanban are concrete management frameworks.

Many teams say 'we are agile,' but when you ask how they organize their week, they need concrete rules. That is where Scrum and Kanban come in.

They provide specific roles, meeting cadences, and visual artifacts to help self-organizing teams inspect and adapt their work.

To summarize this slide, remember this key takeaway: Scrum and Kanban are concrete management frameworks that put Agile principles into daily practice.
-->
---
## The Scrum Framework: Roles & Artifacts

* **Timeboxed Cadences (Sprints):**
  - Development cycles of fixed duration (typically 1 to 4 weeks) with inspect-and-adapt reviews.
* **3 Defined Roles:**
  - **Product Owner (PO):** Defines product vision, prioritizes the backlog, maximizes ROI, represents user voice.
  - **ScrumMaster:** Servant-leader; coaches the team, removes impediments, shields developers from distractions.
  - **Developers:** Cross-functional professionals who build the releasable increment.
* **3 Core Artifacts:**
  - **Product Backlog:** Prioritized single source of truth for all proposed features and fixes.
  - **Sprint Backlog:** Committed subset of items selected for the active sprint.
  - **Increment:** Usable, tested, and potentially releasable product slice meeting the **Definition of Done (DoD)**.

<!--
Let's look at Scrum's 3 Roles and 3 Artifacts.

The 3 Roles:

First, the Product Owner: they represent the business, own the product vision, and prioritize the backlog.

Second, the Scrum Master: a servant-leader who coaches the team, facilitates ceremonies, and removes impediments.

Third, the Developers: the cross-functional team of engineers and testers who actually build the software.

The 3 Artifacts:

The Product Backlog: the single prioritized list of everything desired in the product.

The Sprint Backlog: the subset of items chosen for the current sprint.

And the Increment: the usable, tested, potentially releasable product slice completed during the sprint.

To summarize this slide, remember this key takeaway: Scrum relies on clear accountability between the Product Owner, Scrum Master, and Developers to produce a shippable increment.
-->
---
<!-- _class: title-image-slide -->

## The Complete Scrum Framework Lifecycle

<div class="image-wrapper">
  <img src="../../img/ch02/comic_scrum_framework.png" alt="Complete Scrum Framework Lifecycle" />
</div>

<!--
Walk through this complete Scrum lifecycle diagram with me.

It starts on the left with the Product Owner gathering inputs and maintaining the Product Backlog.

At the beginning of each 1- to 4-week Sprint, the team holds Sprint Planning to select items and define the Sprint Goal.

During the sprint, developers work together and hold a 15-minute Daily Scrum standing up to synchronize progress and surface blockers.

At the end of the sprint, the team demonstrates working software at the Sprint Review, and then conducts a Sprint Retrospective to inspect their own process and improve.

To summarize this slide, remember this key takeaway: The Scrum cycle turns backlog ideas into shippable product increments through fixed, disciplined feedback loops.
-->
---
## Scrum Ceremonies & The Sprint Rhythm

* **1. Sprint Planning:**
  - Team inspects the Product Backlog, agrees on a **Sprint Goal**, and selects backlog items into the Sprint Backlog.
* **2. Daily Scrum (Standup):**
  - 15-minute daily synchronization meeting:
    - *What did I accomplish yesterday? What will I work on today? What obstacles are blocking my progress?*
* **3. Sprint Review:**
  - Held at the end of the sprint to demonstrate the working Increment to stakeholders and gather live feedback.
* **4. Sprint Retrospective:**
  - Dedicated team reflection:
    - *What went well? What went poorly? What concrete process experiments will we adopt next sprint?*

<!--
Let's emphasize the four core Scrum ceremonies:

1. Sprint Planning: The team defines what can be delivered in the sprint and how that work will be achieved.

2. Daily Scrum: A brief 15-minute daily check-in answering: What did I do yesterday? What will I do today? What blockers are in my way?

3. Sprint Review: A live demonstration of working software to stakeholders to collect feedback.

4. Sprint Retrospective: The team's private reflection on what went well, what went poorly, and what one process change they will adopt in the next sprint.

The Retrospective is the single most important ceremony—it is the engine of continuous team improvement!

To summarize this slide, remember this key takeaway: The Sprint Retrospective is the engine of Scrum, empowering the team to continuously inspect and adapt its own workflow.
-->
---
## The Kanban Framework: Continuous Flow & Pull Systems

* **Origin & Philosophy:**
  - Derived from the **Toyota Production System (Lean Manufacturing)**.
  - Instead of fixed timeboxes (sprints), Kanban operates on **continuous flow** through a **pull system**.
* **The 4 Core Practices of Kanban:**
  1. **Visualize the Workflow:** Use a Kanban board with distinct columns (To Do, In Progress, Review, Done) to make all work transparent.
  2. **Limit Work In Progress (WIP):** Set strict numerical caps on how many tasks can occupy a stage simultaneously.
  3. **Manage Flow:** Monitor the movement of items across the board; eliminate blockages.
  4. **Make Process Policies Explicit:** Clearly define "Definition of Ready" and "Definition of Done".

<!--
Now let's examine Kanban.

Kanban originated in Japan from the Toyota Production System (Lean manufacturing). Taiichi Ohno designed it as a 'pull' system to eliminate waste and prevent overproduction.

David J. Anderson adapted Kanban for knowledge work and software engineering.

Kanban is based on three core practices:

1. Visualize the workflow on a board.

2. Limit Work-in-Progress (WIP) in each stage.

3. Manage and optimize flow to minimize cycle time.

Unlike Scrum, Kanban has no fixed-length sprints and no prescribed roles. Work flows continuously.

To summarize this slide, remember this key takeaway: Kanban prevents multitasking and bottlenecks by enforcing strict Work-In-Progress (WIP) limits across a visible workflow.
-->
---
<!-- _class: title-image-slide -->

## Kanban Board Flow with Work-in-Progress (WIP) Limits

<div class="image-wrapper">
  <img src="../../img/ch02/comic_kanban_flow.png" alt="Kanban Board with WIP Limits Comic" />
</div>

<!--
Take a look at this Kanban board diagram.

Look at the columns: Backlog, Ready, In Progress, Code Review, and Done.

Notice the numbers in parentheses at the top of the middle columns: 'In Progress (Max: 3)' and 'Code Review (Max: 2)'.

Those are WIP limits! If there are already 3 cards in 'In Progress', a developer who finishes a task is NOT allowed to pull a 4th card into progress.

Instead, they must swarm to help unblock testing or review!

The fundamental mantra of Kanban is: 'Stop starting, start finishing!'

To summarize this slide, remember this key takeaway: Kanban's golden rule is "stop starting, start finishing" by respecting WIP limits.
-->
---
## Scrum vs. Kanban: Direct Architectural Comparison

| Dimension | Scrum | Kanban |
|---|---|---|
| **Cadence** | Regular, fixed-length sprints (1–4 weeks) | Continuous flow; work pulled as capacity allows |
| **Release Timing** | At end of each Sprint (or continuous) | Continuous delivery upon task completion |
| **Roles** | Product Owner, ScrumMaster, Developers | No prescribed roles (teams keep existing structure) |
| **WIP Control** | Limited by Sprint Backlog commitment | Explicit numerical WIP limits per board column |
| **Mid-Cycle Changes**| Discouraged during active sprint | Changes can be made to backlog at any time |
| **Primary Metric** | Velocity (Story Points per sprint) | Cycle Time, Lead Time, Throughput |
| **Best Suited For** | Product development with feature roadmaps | Maintenance, DevOps, IT support, continuous ops |

<!--
Here is a direct architectural comparison between Scrum and Kanban.

In Cadence: Scrum uses fixed-length timeboxes (1 to 4 week sprints), while Kanban operates on continuous flow.

In Change Rules: In Scrum, once a sprint starts, the sprint backlog is protected and should not change. In Kanban, the priority can change at any time as long as a task hasn't been pulled into work.

In Roles: Scrum prescribes Product Owner, Scrum Master, and Developers. Kanban prescribes no set roles.

In Metrics: Scrum tracks Sprint Velocity and burndown charts. Kanban tracks Cycle Time, Lead Time, and Cumulative Flow.

To summarize this slide, remember this key takeaway: Use Scrum for cadence-driven product iterations, and use Kanban for continuous, interrupt-driven flow.
-->
---
### Concept Check Question 7 (CCQ 7)
<!-- id: ase-ch02-ccq7 -->

<div class="ccq-columns">
  <div class="ccq-text">

In the Kanban process framework, what is the primary operational purpose of enforcing strict "Work In Progress" (WIP) limits on columns?

- **A.** To prevent developers from modifying automated unit test scripts.
- **B.** To expose bottlenecks, reduce multitasking, and maximize delivery flow throughput.
- **C.** To mandate that every team member attends daily 15-minute standup meetings.
- **D.** To ensure all software increments are packaged into fixed 2-week sprint iterations.

  </div>
  <div class="ccq-logo">
    <a href="https://nlhsueh.github.io/nickedupocket/#/student/ase-ch02-ccq7" target="_blank"><img src="../../img/ch02/ase-ch02-ccq7.png" alt="QR Code" /></a>
  </div>
</div>

<!--
Let's test our understanding with Concept Check Question 7.

Read the prompt on screen: In the Kanban process framework, what is the primary operational purpose of enforcing strict "Work In Progress" (WIP) limits on columns?

Let's examine the options:
Option A has nothing to do with WIP limits; test scripts can always be updated.
Option C describes the Scrum daily standup, not Kanban WIP limits.
Option D confuses Kanban continuous flow with Scrum 2-week timeboxed sprints.

The correct answer is Option B! As Little's Law demonstrates, capping work-in-progress exposes hidden system bottlenecks, stops developers from multitasking across half-finished tickets, and maximizes overall delivery throughput. In Kanban, the motto is: "Stop starting, start finishing!"

To summarize this slide, remember this key takeaway: WIP limits prevent multitasking congestion and expose system bottlenecks to maximize delivery flow.
-->
---
### Concept Check Question 8 (CCQ 8)
<!-- id: ase-ch02-ccq8 -->

<div class="ccq-columns">
  <div class="ccq-text">

In the Scrum framework, what is the primary operational objective of the **Sprint Retrospective** held at the end of each sprint?

- **A.** To demonstrate working software increments to external business stakeholders and end users.
- **B.** To inspect team collaboration, identify operational friction, and commit to concrete process improvements for the next sprint.
- **C.** To evaluate individual developer velocity and determine annual salary adjustments.
- **D.** To re-architect the entire system database schema and deploy hotfixes to live production servers.

  </div>
  <div class="ccq-logo">
    <a href="https://nlhsueh.github.io/nickedupocket/#/student/ase-ch02-ccq8" target="_blank"><img src="../../img/ch02/ase-ch02-ccq8.png" alt="QR Code" /></a>
  </div>
</div>

<!--
Let's test our understanding of Scrum ceremonies with Concept Check Question 8.

What is the primary goal of the Sprint Retrospective held at the end of each sprint?

A lot of beginners confuse Option A with Option B. Option A is actually the Sprint Review, where you demo the software to stakeholders!

The Sprint Retrospective is described by Option B: it is an internal team meeting where the team reflects on how they worked together—what went well, what caused friction, and what specific action they will take to improve their process in the next sprint. It is the engine of continuous adaptation.

To summarize this slide, remember this key takeaway: The Sprint Retrospective empowers the team to continuously inspect and tune its own working habits.
-->
---

<!-- _class: lead -->
<!-- header: '2.6 Technical Debt' -->

# **2.6 Technical Debt**

> "Shipping first time code is like going into debt.  
> A little debt accelerates development so long as it is paid back promptly with a rewrite."  
> — *Ward Cunningham*

<!--
Now we arrive at Module 2.6: Technical Debt.

When organizations rush to push features every sprint without investing in code health, automated tests, or architectural design, they fall into a perilous trap.

Coined by Ward Cunningham, 'Technical Debt' captures the compounding cost of expedient shortcuts. Just like financial debt, unpaid technical shortcuts accumulate interest that will eventually paralyze future development velocity.

To summarize this slide, remember this key takeaway: Shortcuts taken today become technical debt tomorrow, charging compounding interest on every new feature.
-->
---
<!-- _class: title-image-slide -->

## The Hidden Cost of Speed: Technical Debt

<div class="image-wrapper">
  <img src="../../img/ch02/comic_26_technical_debt.jpg" alt="Technical Debt Comic" />
</div>

<!--
Now we arrive at Module 2.6: Technical Debt.

Look at this comic carefully. An engineer is building a house on a foundation made of fragile twigs, duct tape, and unwritten unit tests.

The engineer is grinning and celebrating: 'Look how fast I finished the sprint!'

Meanwhile, underneath, giant structural cracks are spreading, and the whole house is tilting precariously.

In software engineering, going fast by cutting corners is not real speed—it is a dangerous illusion.

To summarize this slide, remember this key takeaway: Shortcuts taken today become technical debt tomorrow, charging compound interest on every future feature.
-->
---
## Technical Debt: A Financial Loan on Software

<div class="content-columns">
<div class="content-text">

> Shipping code quickly without engineering discipline is like taking out a **financial loan**. It accelerates delivery today, but incurs compounding interest that eventually bankrupts future engineering velocity.

* **Origin of the Metaphor:**
  - Coined by **Ward Cunningham (1992)**, co-author of the Agile Manifesto and creator of the first Wiki.
* **The Core Paradox of Agile Delivery:**
  - Scrum and Kanban empower teams to demo features sprint after sprint.
  - **The Trap:** Prioritizing *feature speed* while neglecting automated tests and architectural health.
  - **The Compounding Interest:** You borrowed time today, but pay interest daily via brittle code, regressions, and velocity collapse.

</div>
<div class="content-figure">

<div class="name-card">
  <img src="../../img/ch02/ward_cunningham.jpg" alt="Ward Cunningham" />
  <div class="name-card-caption">
    <span class="name-card-name">Ward Cunningham</span>
    <span class="name-card-cc"><a href="https://en.wikipedia.org/wiki/Ward_Cunningham" target="_blank">Wikimedia Commons / CC BY-SA</a></span>
  </div>
</div>

</div>
</div>

<!--
What is Technical Debt?

Ward Cunningham, one of the co-authors of the Agile Manifesto and the inventor of the wiki, coined this famous financial metaphor in 1992.

Just like taking out a financial loan, cutting corners—such as skipping automated tests, copy-pasting code, or delaying architecture refactoring—lets you deliver something quickly today.

You borrowed time! But that debt is not free. You must pay interest on that debt every single day in the form of harder debugging, brittle systems, and slower feature delivery.

And if you never pay down the principal by refactoring, the interest mounts until the codebase collapses into bankruptcy.

To summarize this slide, remember this key takeaway: Technical debt trades short-term delivery speed for long-term slowdown and system fragility.
-->

---
## The "Flaccid Scrum" Phenomenon & Architectural Erosion

* **Martin Fowler's Warning: "Flaccid Scrum"**
  - Adopting the superficial management ceremonies of Scrum (standups, sprints, user stories, Jira boards) while **completely ignoring technical engineering practices**.
  - Teams become "feature factories" that rapidly produce fragile, untested code.
* **The Consequences of Technical Neglect:**
  - **Architectural Erosion:** System boundaries blur, modular encapsulation breaks down, turning clean architecture into a **"Big Ball of Mud"**.
  - **Velocity Collapse:** Sprint velocity drops exponentially over time because developers spend 80% of their day fighting regression defects.
  - **Developer Burnout & Turnover:** High friction, fear of touching code, and morale collapse.

<!--
Martin Fowler coined a vivid phrase that every engineer should know: 'Flaccid Scrum.'

What does Flaccid Scrum mean? It happens when a company adopts all the management rituals of Scrum—they have daily standups, sticky notes, sprint planning, and Scrum Masters—but they ignore technical engineering practices!

They write sloppy code, don't write automated tests, and don't practice refactoring.

As Martin Fowler warned: Scrum without technical craftsmanship just lets you produce low-quality junk in two-week cycles. You cannot have real business agility without technical rigor.

To summarize this slide, remember this key takeaway: Agile project management without engineering craftsmanship inevitably degenerates into Flaccid Scrum.
-->

---
## Empirical Evidence & Real-World Disasters of Technical Debt

> Technical debt is not an abstract metaphor: it drains **42% of engineering time** worldwide and can trigger **billion-dollar enterprise collapses**.

<div class="two-columns">
<div class="card" data-marpit-fragment>

### 📊 Global Empirical Data

- **Stripe Developer Coefficient Report (2018):**
  - Developers spend **42% of their weekly time** (~17.3 hrs) on tech debt and bad code.
  - Global GDP loss: **$85B – $300B annually** in squandered developer productivity.
- **CISQ Industry Benchmark (2022):**
  - Accumulated technical debt in the US alone exceeded **$1.52 Trillion**.

</div>
<div class="card" data-marpit-fragment>

### 💥 Case: Southwest Airlines Meltdown (2022)

- **The Holiday Catastrophe:**
  - **16,700 flights cancelled** in one week; stranded millions of holiday travelers.
  - Direct financial loss of **over $1 Billion USD** plus severe brand damage.
- **The Technical Root Cause:**
  - Decades of neglected technical debt in the crew-scheduling system (**SkySolver**).
  - Management prioritized expansion while ignoring warnings about obsolete IT systems.

</div>
</div>

<!--
Is Technical Debt just an abstract theoretical concept, or is there real data and evidence behind it?

The data is staggering. The Stripe Developer Coefficient Study surveyed thousands of engineers worldwide and found that developers spend 42% of their working hours—nearly two full days every week—dealing with bad code, maintenance, and technical debt! That represents over $85 billion dollars in lost productivity every year.

And when technical debt reaches its breaking point, catastrophic collapse occurs. Look at the Southwest Airlines holiday meltdown in December 2022. A winter storm caused disruptions, and their 30-year-old legacy crew-scheduling software, SkySolver, completely crashed under cascading reassignments.

Over 16,700 flights were cancelled, stranding millions of travelers and costing Southwest over $1 billion dollars. The union and engineers had warned executives about this technical debt for years, but leadership kept prioritizing surface marketing over core IT health.

To summarize this slide, remember this key takeaway: Technical debt is not a theoretical annoyance—it consumes over 40% of developer time and can trigger billion-dollar enterprise collapses.
-->
---
### Concept Check Question 9 (CCQ 9)
<!-- id: ase-ch02-ccq9 -->

<div class="ccq-columns">
  <div class="ccq-text">

According to Ward Cunningham's Technical Debt metaphor, what represents the "compounding interest" paid by a software organization?

- **A.** The annual licensing fees paid for cloud hosting infrastructure and IDEs.
- **B.** The ongoing extra time, degraded velocity, and regression defects suffered during all future development.
- **C.** The bonus compensation paid to engineers who complete sprint tickets ahead of schedule.
- **D.** The legal costs of acquiring open-source third-party dependencies.

  </div>
  <div class="ccq-logo">
    <a href="https://nlhsueh.github.io/nickedupocket/#/student/ase-ch02-ccq9" target="_blank"><img src="../../img/ch02/ase-ch02-ccq9.png" alt="QR Code" /></a>
  </div>
</div>

<!--
Let's look at Concept Check Question 9.

Read the prompt on screen: According to Ward Cunningham's Technical Debt metaphor, what represents the "compounding interest" paid by a software organization?

Let's review the options:
Option A refers to financial operational expenses, not technical debt interest.
Option C describes financial bonuses.
Option D refers to open-source licensing.

The correct answer is Option B! In Ward Cunningham's metaphor, taking a shortcut borrows time, which is the principal. But every day you don't refactor, you pay compounding interest in the form of slower delivery speed, harder debugging, fragile modules, and regression bugs that pop up whenever you add a new feature.

To summarize this slide, remember this key takeaway: The interest on technical debt is paid through degraded velocity and mounting regression bugs during all future development.
-->
---
### Concept Check Question 10 (CCQ 10)
<!-- id: ase-ch02-ccq10 -->

<div class="ccq-columns">
  <div class="ccq-text">

Martin Fowler coined the term **"Flaccid Scrum"** to describe which critical software engineering failure?

- **A.** Adopting Scrum management ceremonies (daily standups, sprints, story points) while completely neglecting technical engineering practices like TDD, refactoring, and CI.
- **B.** Refusing to use Jira or commercial issue tracking software in favor of physical sticky notes.
- **C.** Allowing product owners to adjust backlog priorities between sprint planning sessions.
- **D.** Enforcing automated test execution on every Git commit in the continuous integration pipeline.

  </div>
  <div class="ccq-logo">
    <a href="https://nlhsueh.github.io/nickedupocket/#/student/ase-ch02-ccq10" target="_blank"><img src="../../img/ch02/ase-ch02-ccq10.png" alt="QR Code" /></a>
  </div>
</div>

<!--
Let's look at Concept Check Question 10 on the relationship between agile management and technical rigor.

Martin Fowler warned against what he called 'Flaccid Scrum.' What does this anti-pattern describe?

The correct answer is Option A. Many organizations enthusiastically adopt the surface rituals of Scrum—they hire Scrum Masters, do daily standups, and move tickets on Jira—but they don't teach their developers how to write automated tests, how to refactor, or how to maintain clean architecture. The result is poorly designed, fragile software delivered in two-week cycles. You cannot have real agility without technical excellence.

To summarize this slide, remember this key takeaway: Scrum rituals without engineering craftsmanship inevitably produce fragile code.
-->
---

### Interactive Activity: The Technical Debt Dilemma (Pair Discussion)

<div class="discussion-columns">
  <div class="discussion-text">

  **The Technical Debt Dilemma (Pair Discussion):**
  - **Scenario:** High-stakes VC demo in 3 weeks to close a $5M funding round for your startup.
  - **Reality:** Payment service has heavy architectural debt (no automated tests, intermittent concurrency crashes).
  - **PM's Demand:** "We must build a flashy 1-Click Crypto Checkout feature for the demo!"
  - **Pair Discussion Prompts:**
    1. Would you (A) Refuse and refactor, (B) Stack the feature on messy code and pray, or (C) Propose a pragmatic hybrid?
    2. Using Martin Fowler's Quadrant, is this debt *Prudent* or *Reckless*? How do you schedule repayment post-demo?

  </div>
  <div class="discussion-logo">
    <img src="../../img/ch02/discussion_icon.svg" alt="Discussion" />
  </div>
</div>

<!--
Let's pause for our third interactive activity: The Technical Debt Dilemma! Turn to your partner—you are now the lead software architect at a fast-growing financial technology startup.

Here is the high-stakes reality: In exactly three weeks, your startup is pitching live to venture capitalists to secure a critical five-million-dollar funding round. If the pitch fails, the company runs out of runway in two months.
However, your core payment microservice is drowning in technical debt—it was rushed out during a hackathon, has zero automated tests, and occasionally locks up under concurrent requests. Now, your product manager rushes into your office demanding: "We must add a flashy One-Click Crypto Checkout feature for the investor pitch, or they won't fund us!"

Take three minutes to debate this dilemma with your partner:
Which path do you take? Do you flatly refuse the PM and spend the three weeks refactoring, risking the funding? Do you blindly pile the crypto code on top of the mess and pray it doesn't crash during the live demo? Or can you engineer a pragmatic third option—like a mock UI prototype with strict sandbox boundaries, accompanied by an explicit agreement to allocate the next two sprints entirely to debt repayment?

Also, think about Martin Fowler's Technical Debt Quadrant: Is taking on debt to win an investor demo deliberate and prudent, or is it reckless? What engineering guardrails prevent deliberate debt from metastasizing into permanent Flaccid Scrum?

**To wrap up this slide, here is the key takeaway to remember:** Technical debt is a strategic financial tool—taking on deliberate debt to seize a market window is acceptable, provided there is an uncompromised plan to pay down the principal immediately after.
-->
---

<!-- _class: lead -->
<!-- header: '2.7 Extreme Programming' -->

# **2.7 Technical Rigor (Extreme Programming)**

> "Any fool can write code that a computer can understand.  
> Good programmers write code that humans can understand."  
> — *Martin Fowler*

<!--
Welcome to Module 2.7: Technical Rigor — Extreme Programming, or XP.

To counter the dangers of Flaccid Scrum and technical debt, we turn to the engineering discipline created by Kent Beck. Extreme Programming asks a provocative question: if an engineering practice is good, what happens if we turn the dial up to 10 and do it all the time?

Through Test-Driven Development, continuous refactoring, pair programming, and small releases, XP provides the technical muscle that makes true agile agility sustainable.

To summarize this slide, remember this key takeaway: Extreme Programming provides the technical craftsmanship that protects agile codebases from decay and obsolescence.
-->
---
<!-- _class: title-image-slide -->

## Extreme Programming (XP): Technical Rigor & Clean Code

<div class="image-wrapper">
  <img src="../../img/ch02/comic_27_extreme_programming.jpg" alt="Extreme Programming XP Comic" />
</div>

<!--
To counter Flaccid Scrum and technical debt, we turn to Module 2.7: Technical Rigor — Extreme Programming (XP).

Look at this comic illustrating Extreme Programming.

Here we see developers working together in pairs at one screen, automated tests turning green with every commit, and continuous refactoring keeping the code clean.

Kent Beck, who created XP in 1996, asked a radical question: 'If code reviews are good, why not review code all the time via Pair Programming? If testing is good, why not write tests before every single feature with TDD?'

XP takes proven engineering practices and turns the dial up to 10!

To summarize this slide, remember this key takeaway: Extreme Programming provides the technical backbone that makes agile software reliable and adaptable.
-->
---
## Technical Rigor: Extreme Programming (XP)

<div class="content-columns">
<div class="content-text">

> Created by Kent Beck in 1996, Extreme Programming (XP) is an Agile process model focused specifically on *coding discipline*, *technical excellence*, and *continuous refactoring* — serving as the primary antidote to Technical Debt.

* **Why "Extreme" Programming?**
* Kent Beck asked: *"If an engineering practice is good, what if we turn the dial up to 10 and do it all the time?"*
  - *Testing* is good → Test before writing code (**TDD**).
  - *Code review* is good → Review continuously (**Pair Programming**).
  - *Design* is good → Refactor constantly (**Simple Design**).
  - *Integration* is good → Integrate multiple times a day (**CI/CD**).
  - *Releases* are good → Deliver tiny increments (**Small Releases**).

</div>
<div class="content-figure">

<div class="name-card">
  <img src="../../img/ch02/kent_beck.jpg" alt="Kent Beck" />
  <div class="name-card-caption">
    <span class="name-card-name">Kent Beck</span>
    <span class="name-card-cc"><a href="https://en.wikipedia.org/wiki/Kent_Beck" target="_blank">Wikimedia Commons / CC BY-SA</a></span>
  </div>
</div>

</div>
</div>

<!--
Let's look at the philosophy of Extreme Programming, or XP.

Created by Kent Beck in 1996 while working on the Chrysler Comprehensive Compensation system, XP is the technical engine of Agile.

Kent Beck, who also co-authored the Agile Manifesto and created JUnit, asked a radical question: 'If an engineering practice is good, what happens if we turn the dial up to 10 and do it all the time?'

If unit testing is good, write automated tests before every line of production code via Test-Driven Development. If code reviews are good, review code constantly via Pair Programming. If refactoring is good, refactor continuously to keep designs simple.

While Scrum provides project management ceremonies, XP provides the hardcore technical discipline that prevents architectural decay and technical debt.

To summarize this slide, remember this key takeaway: Extreme Programming takes proven software engineering practices and turns the dial up to 10 to sustain high velocity and clean design.
-->
---
<!-- _class: title-image-slide -->

## Core Extreme Programming (XP) Practices & Feedback Loops

<div class="image-wrapper">
  <img src="../../img/ch02/comic_xp_practices.png" alt="Core Extreme Programming (XP) Practices with Comic Icons" />
</div>

<!--
Look at this concentric circle diagram of XP practices. Notice how they create nested feedback loops of different timeframes:

At the innermost circle (seconds to minutes): Pair Programming, Test-Driven Development, and Unit Testing provide instant feedback with every keystroke.

At the middle circle (hours to days): Continuous Integration, Refactoring, and Simple Design ensure the codebase stays integrated and healthy every day.

At the outer circle (weeks): User Stories, Small Releases, and the Planning Game align engineering with customer needs.

Notice that every practice reinforces the others like interlocking gears.

To summarize this slide, remember this key takeaway: XP practices form interlocking feedback loops ranging from seconds at the keyboard to weeks in product releases.
-->
---
## XP Practices: Test-Driven Development (TDD)

* **The Test-First Mindset:**
  - Never write a line of production code unless you have a *failing automated test*!
* **The Red-Green-Refactor Cycle:**
  1. **RED:** Write a small automated unit test that specifies desired behavior and fails.
  2. **GREEN:** Write the absolute minimal production code necessary to pass the test.
  3. **REFACTOR:** Clean up structure, remove duplication, and improve names while tests remain green.
* **Result:** Creates an automated regression safety net that makes code changes fearless!

<!--
One of the most famous XP practices is Test-Driven Development, or TDD.

In traditional development, people write code first and maybe write tests later—if they have time. In TDD, you invert the order: you write the test *before* writing the implementation code!

TDD follows the famous Red-Green-Refactor cycle:

First, Red: Write a small automated unit test that fails, because the functionality doesn't exist yet.

Second, Green: Write the simplest, quickest code that makes the test pass.

Third, Refactor: Clean up the code, remove duplication, and improve variable names while the passing tests give you confidence that nothing broke.

To summarize this slide, remember this key takeaway: TDD uses tests as living design specifications, driving code creation through the Red-Green-Refactor cycle.
-->
---
<!-- _class: title-image-slide -->

## The Test-Driven Development (TDD) Cycle

<div class="image-wrapper">
  <img src="../../img/ch02/comic_tdd_cycle.png" alt="The TDD Red-Green-Refactor Cycle Comic" />
</div>

<!--
Look at this circular diagram of the TDD cycle.

See the three phases:

Red: Write a failing test. This forces you to think about the interface and behavior from the caller's perspective before getting lost in implementation details.

Green: Make the test pass. Write just enough code to satisfy the test—no over-engineering.

Refactor: Clean up the code. Eliminate duplicate logic, improve design patterns, and ensure readability.

When you practice TDD, you build a safety net of thousands of automated tests, eliminating fear from software development.

To summarize this slide, remember this key takeaway: When you have a comprehensive suite of passing tests, you can refactor boldly without fear of regression.
-->
---
## Continuous Refactoring & Simple Design

* **What is Refactoring?**
  - Martin Fowler: *"A change made to the internal structure of software to make it easier to understand and cheaper to modify, without changing its observable external behavior."*
  - In XP, refactoring is not a special phase scheduled once a year; **it is an hourly developer reflex**.
* **Kent Beck's 4 Rules of Simple Design:**
  1. **Passes all tests:** System correctness is verified automatically.
  2. **Reveals intent:** Code is *self-documenting* with clear naming and modular responsibilities.
  3. **No duplication (DRY):** *Don't Repeat Yourself* — single point of truth for business logic.
  4. **Fewest elements:** No speculative over-engineering, unused abstractions, or dead code.
* **The Antidote to Debt:** Continuous refactoring constantly repays technical debt on every commit!

<!--
Now let's examine Continuous Refactoring and Simple Design.

Martin Fowler defines refactoring as: 'A change made to the internal structure of software to make it easier to understand and cheaper to modify, without changing its observable behavior.'

And what is Simple Design? Kent Beck established Four Rules of Simple Design, ordered by priority:

1. Passes all tests.

2. Reveals developer intent (clean, self-documenting code).

3. Contains no duplication (the DRY principle: Don't Repeat Yourself).

4. Has the fewest elements (minimum necessary classes and methods).

Notice that passing tests is always rule number one!

To summarize this slide, remember this key takeaway: Simple design prioritizes passing tests, clear intent, and zero duplication over clever or over-engineered abstractions.
-->
---
## Pair Programming & Collective Code Ownership

* **Pair Programming Dynamics:**
  - Two developers collaborate at one workstation: **Driver** (writes code/tests) & **Navigator** (reviews architecture & edge cases).
* **Collective Code Ownership:**
  - No single developer "owns" or hoards a module; any pair can refactor code anywhere.
* **Empirical Evidence:**
  - Studies show pairing reduces defects by 15–30% and produces cleaner, simpler designs.
* **Eliminating the "Bus Factor":**
  - *"The minimum number of engineers whose sudden departure (or being "hit by a bus") would stall the project."*
  - A Bus Factor of **1** is a dangerous *Single Point of Failure* (SPOF) caused by knowledge silos.

<!--
Another signature XP practice is Pair Programming.

In Pair Programming, two software engineers work together at one workstation.

One engineer acts as the 'Driver': they have their hands on the keyboard, focusing on typing code, syntax, and local logic.

The other engineer acts as the 'Navigator': they observe, think about edge cases, check whether the current method fits the overall architecture, and suggest test cases.

Every 20 to 30 minutes, they swap roles!

Now, what is the 'Bus Factor' mentioned in the final bullet? It is a classic software engineering risk metric: How many developers on your team can be hit by a bus—or win the lottery and leave tomorrow—before your project grinds to a complete halt?

If only Alice understands the legacy payment system, your team's Bus Factor is 1. If Alice leaves, the company is in serious jeopardy!

By practicing Pair Programming and Collective Code Ownership, knowledge is never trapped in a single engineer's head. You continuously raise your Bus Factor, eliminate single points of failure, and build true team resilience.

To summarize this slide, remember this key takeaway: Pair programming combines tactical coding with strategic oversight, creating higher quality code and eliminating single-person knowledge bottlenecks.
-->
---
<!-- _class: title-image-slide -->

## Pair Programming: Driver & Navigator Dynamics

<div class="image-wrapper">
  <img src="../../img/ch02/comic_pair_programming.jpg" alt="Pair Programming: Driver & Navigator Comic" />
</div>

<!--
Look at this comic illustrating Pair Programming in action.

Notice the conversation between the Driver and the Navigator:

The Driver says: 'I'm implementing the binary search loop here.'

The Navigator immediately notices: 'Wait, what happens if the input array contains duplicate keys or is completely empty?'

Because the Navigator is thinking one step ahead, bugs are caught in real-time before they even reach a pull request or CI pipeline!

To summarize this slide, remember this key takeaway: Continuous peer collaboration during pair programming catches architectural blind spots instantly.
-->
---
### Concept Check Question 11 (CCQ 11)
<!-- id: ase-ch02-ccq11 -->

<div class="ccq-columns">
  <div class="ccq-text">

In Extreme Programming (XP), what is the primary role of the "Navigator" during a pair programming session?

- **A.** Typing out code syntax and executing local terminal commands.
- **B.** Thinking strategically, reviewing code in real time, considering edge cases, and looking at the broader architecture.
- **C.** Serving as the official sprint facilitator and managing Jira backlog ticket status.
- **D.** Negotiating customer contracts and approving annual engineering budgets.

  </div>
  <div class="ccq-logo">
    <a href="https://nlhsueh.github.io/nickedupocket/#/student/ase-ch02-ccq11" target="_blank"><img src="../../img/ch02/ase-ch02-ccq11.png" alt="QR Code" /></a>
  </div>
</div>

<!--
Let's verify our understanding with Concept Check Question 11.

In Extreme Programming, what is the primary role of the 'Navigator' during pair programming?

Option A describes the Driver, who types the syntax.
Option B is the correct answer: The Navigator thinks strategically, reviews code in real-time, anticipates edge cases, and maintains the broader architecture.
Option C describes a Scrum Master.
Option D is a management role.

The correct answer is Option B.

To summarize this slide, remember this key takeaway: In pair programming, the Navigator acts as an active strategic co-pilot, catching defects and architectural blind spots in real time.
-->
---
### Concept Check Question 12 (CCQ 12)
<!-- id: ase-ch02-ccq12 -->

<div class="ccq-columns">
  <div class="ccq-text">

In Extreme Programming's Test-Driven Development (TDD), what is the specific objective of the **"Refactor"** step in the Red-Green-Refactor cycle?

- **A.** Adding new functional capabilities and expanding the module's public API contract.
- **B.** Improving the internal structure and readability of the code while ensuring all existing automated tests continue to pass.
- **C.** Removing unit tests that take longer than one second to execute in the local test suite.
- **D.** Rewriting the application from an object-oriented language to a functional programming language.

  </div>
  <div class="ccq-logo">
    <a href="https://nlhsueh.github.io/nickedupocket/#/student/ase-ch02-ccq12" target="_blank"><img src="../../img/ch02/ase-ch02-ccq12.png" alt="QR Code" /></a>
  </div>
</div>

<!--
Now let's examine Concept Check Question 12 on Test-Driven Development.

In the famous Red-Green-Refactor cycle, what is the exact purpose of the 'Refactor' step?

Option A is a common trap: refactoring never adds new features! If you add new behavior, you are no longer refactoring; you are developing.

The correct answer is Option B: Refactoring means improving the internal design, eliminating duplication, and making the code clean and readable, without changing observable behavior. And because you just made all your tests green, you can refactor with complete confidence that you haven't broken anything.

To summarize this slide, remember this key takeaway: Refactoring cleans up internal code structure while passing tests guarantee behavioral stability.
-->
---

<!-- _class: lead -->
<!-- header: '2.8 DevOps' -->

# **2.8 Systems & Culture (DevOps)**

> "You build it, you run it."  
> Breaking down the wall of confusion through continuous delivery and shared operational ownership.  
> — *Werner Vogels, CTO of Amazon*

<!--
Now we step into Module 2.8: Systems and Culture — DevOps.

For decades, an organizational 'Wall of Confusion' separated software developers from operations engineers. Developers were incentivized to push changes quickly, while operations were incentivized to keep production stable by preventing changes.

DevOps tears down that wall through automated CI/CD pipelines, Infrastructure as Code, and a culture of shared responsibility: if you build the system, you share the responsibility of running it in production.

To summarize this slide, remember this key takeaway: DevOps replaces departmental blame with automated pipelines and shared end-to-end operational accountability.
-->
---
<!-- _class: title-image-slide -->

## DevOps & The "Wall of Confusion" Between Dev and Ops

<div class="image-wrapper">
  <img src="../../img/ch02/comic_28_devops.png" alt="DevOps Wall of Confusion Comic" />
</div>

<!--
Welcome to Module 2.8: Systems & Culture — DevOps.

Look at this comic illustrating the traditional dilemma between Development and Operations.

In the old days, there was a giant 'Wall of Confusion' between Dev and Ops.

On the left, the Developer writes code on their laptop, throws a zip file over the wall, and says: 'It worked on my machine! My job is done!'

On the right, at 3:00 AM, the Operations engineer gets paged because the server crashed, and shouts: 'Your code broke production!'

DevOps is the movement that tears down that wall of blame.

To summarize this slide, remember this key takeaway: DevOps replaces the wall of blame between Dev and Ops with automated collaboration and shared operational ownership.
-->
---
## Systems & Culture — DevOps

> A cultural, organizational, and technical movement that bridges the traditional divide between **Development (Dev)** and **Operations (Ops)**, automating the software delivery lifecycle through continuous pipelines, Infrastructure as Code (IaC), and production telemetry.

* **Breaking the "Wall of Confusion":**
  - **Development Incentives:** Rewarded for change, rapid feature velocity, and new releases.
  - **Operations Incentives:** Rewarded for stability, uptime, 99.999% reliability, and minimizing changes.
  - **The Wall:** Devs threw compiled binaries over the wall to Ops: *"It worked on my machine; now it's your problem!"*
  - **The DevOps Solution:** Shared accountability — *"You build it, you run it!"*

<!--
What is DevOps?

DevOps is not just a software tool, and it is not just a job title. It is a cultural, organizational, and technical philosophy that unifies software Development (Dev) and IT Operations (Ops).

Its goal is to shorten the systems development life cycle while delivering features, fixes, and updates frequently and reliably.

Amazon CTO Werner Vogels summarized the cultural mindset in six words: 'You build it, you run it.'

When developers share responsibility for running their systems in production, they write more resilient, observable code.

To summarize this slide, remember this key takeaway: DevOps unifies development and operations into an unbroken, automated feedback loop with shared accountability.
-->
---
## Continuous Integration (CI): Breaking the Wall Between Dev & Ops

> CI tears down the "Wall of Confusion" by replacing manual handoffs with high-frequency trunk integration and automated quality gates.

* **Tearing Down the "Works on My Machine" Wall:**
  - Developers integrate code into a shared mainline (**trunk**) multiple times daily, eliminating multi-week *Merge Hell*.
  - Integration friction is confronted continuously in tiny, painless increments rather than a catastrophic quarterly surprise.
* **Automated Quality Gates as the Objective Arbiter:**
  - Every push automatically triggers clean builds, unit/integration test suites, and security scans (SAST/linters) in an isolated runner.
  - Replaces subjective finger-pointing between Dev and QA with an unambiguous, automated single source of truth.
* **Shift-Left Responsibility & The Stop-the-Line Rule:**
  - If any test fails, the build is **BROKEN**—the entire team halts new feature work to fix trunk immediately.

<!--
The cornerstone of DevOps is Continuous Integration, or CI, and its primary purpose is breaking down the infamous 'Wall of Confusion.'

In traditional teams, developers worked in isolated feature branches for weeks or months. When they finally threw their code over the wall, they entered 'Merge Hell'—conflicts everywhere, broken builds, and endless blame games: 'It worked on my machine, so it must be QA's fault or Ops's server configuration!'

CI shatters this wall through two principles. First, developers integrate their code into the shared mainline repository multiple times every single day. Integration pain is dealt with in tiny, continuous doses.

Second, every commit triggers an automated pipeline—compiling the build, running thousands of unit and integration tests, and scanning for security vulnerabilities in an isolated, neutral environment.

The pipeline is the objective arbiter of truth. If any test fails, the build is broken, and the entire team stops the line to fix it.

To summarize this slide, remember this key takeaway: Continuous Integration breaks the wall between Dev and Ops by replacing siloed handoffs with automated, objective quality gates on every commit.
-->
---
## Why DevOps Needs CD: Continuous Delivery & Deployment

> Code sitting in a repository yields **zero business value**. CD removes the operational wall to make releasing software a routine, low-risk business decision.

* **De-Risking Releases Through Small Batch Sizes:**
  - CD follows the principle: *"If it hurts, do it more often."* Smaller, frequent updates are exponentially easier to test, verify, and rollback.
* **Continuous Delivery (Deployable on Demand):**
  - Every passing commit automatically produces a validated, production-ready artifact deployed into a staging environment.
  - The final release to live users is a **business decision** (clicking a button), removing technical bottlenecks from product strategy.
* **Continuous Deployment (Zero-Touch Value Stream):**
  - Eliminates human operational gatekeepers entirely; passing commits deploy automatically straight to live users in minutes.
  - Relies on automated safety nets: Canary rollouts, Blue-Green deployments, and instant automated rollback telemetry.

<!--
Now, why does DevOps need CD? Because code sitting in a Git repository delivers zero business value to end users, while accumulating release risk.

In traditional organizations, deployment was a terrifying, once-a-quarter midnight event. Hundreds of changes were dumped into production at once. When things inevitably broke, Ops built even taller bureaucratic walls to stop developers from releasing.

CD embraces the classic engineering maxim: 'If it hurts, do it more often!' By automating the release pipeline, deployments shrink into small, frequent, routine non-events.

Notice the crucial distinction between Continuous Delivery and Continuous Deployment:

Continuous Delivery ensures that every passing build is always in a verified, releasable state in staging. Pushing to live users is simply a business decision—a product manager clicks a button whenever the market is ready.

Continuous Deployment takes automation all the way: every commit that passes all automated tests deploys automatically straight to production without human intervention. This is how companies like Netflix, Amazon, and Meta safely deploy thousands of times each day.

To summarize this slide, remember this key takeaway: CD transforms high-risk deployments into routine, low-stress releases, ensuring code reaches users safely and continuously.
-->
---
<!-- _class: title-image-slide -->

## The Automated DevOps CI/CD Pipeline

<div class="image-wrapper">
  <img src="../../img/ch02/comic_cicd_pipeline.png" alt="DevOps CI/CD Pipeline Comic" />
</div>

<!--
Look at this end-to-end CI/CD pipeline diagram.

Follow the flow from left to right:

First, a developer commits code to Git.

Immediately, the CI pipeline triggers: automated linting, unit tests, and security scans run.

Next, the code is packaged into a Docker container image.

The image is deployed to a Staging environment where automated integration and performance tests run.

If all quality gates pass, the pipeline deploys the artifact into Production and monitors live telemetry.

If any test fails anywhere along the pipeline, the deployment stops immediately.

To summarize this slide, remember this key takeaway: An automated CI/CD pipeline acts as a series of progressive quality gates guarding production safety.
-->
---
## Infrastructure as Code & Production Observability

> In DevOps, **Infrastructure is Software**: Managing cloud topology via declarative, versioned code eliminates environment drift and enables reliable continuous delivery.

* **Infrastructure as Code (IaC) — Cattle, Not Pets:**
  - **Declarative Environments:** Tools like Terraform, Docker, and Kubernetes guarantee Dev, Staging, and Production share 100% identical configurations.
  - **Destroys Snowflake Servers:** Eliminates "works on my machine" by treating servers as disposable, immutable assets rather than hand-crafted pets.
* **Production Observability — Closing the Feedback Loop:**
  - **The Three Telemetry Pillars:** Structured **Logs** (events), time-series **Metrics** (CPU, latency, RPS), and distributed **Traces** (end-to-end request lifecycles).
  - **Actionable Engineering Telemetry:** Real-world crashes, performance bottlenecks, and user errors route directly back into developer sprint backlogs.

<!--
Let's look at two foundational technical pillars that make modern DevOps possible: Infrastructure as Code and Production Observability.

Why is Infrastructure as Code, or IaC, so critically important in DevOps?

In the old days, developers threw code over the wall to system administrators, who manually clicked through cloud consoles or typed ad-hoc terminal commands. This caused what we call 'Snowflake Servers'—servers whose exact configurations nobody truly understood, leading to the dreaded excuse: 'Well, it worked on my machine!'

With IaC tools like Terraform, Docker, and Kubernetes, infrastructure is defined as declarative code stored in Git. Staging and production environments are guaranteed to be identical. Any infrastructure modification must pass code review in a Pull Request, and if an outage occurs, you can roll back your entire cloud architecture in seconds using git revert!

On the operations side, we have Production Observability. Through the three pillars—logs, metrics, and distributed traces—we monitor live system health. When an issue occurs in production, telemetry immediately routes back into the engineering backlog.

To summarize this slide, remember this key takeaway: Infrastructure as Code eliminates environmental drift, while production telemetry closes the loop from operations back to engineering.
-->

---
### Concept Check Question 13 (CCQ 13)
<!-- id: ase-ch02-ccq13 -->

<div class="ccq-columns">
  <div class="ccq-text">

What is the defining operational distinction between "Continuous Delivery" and "Continuous Deployment"?

- **A.** Continuous Delivery requires manual code compilation; Continuous Deployment automates compilation.
- **B.** Continuous Delivery stops at staging and requires human business approval to release; Continuous Deployment automatically deploys passing builds directly to live production.
- **C.** Continuous Delivery is used solely for mobile apps; Continuous Deployment is used solely for backend databases.
- **D.** Continuous Delivery eliminates unit testing; Continuous Deployment mandates pair programming.

  </div>
  <div class="ccq-logo">
    <a href="https://nlhsueh.github.io/nickedupocket/#/student/ase-ch02-ccq13" target="_blank"><img src="../../img/ch02/ase-ch02-ccq13.png" alt="QR Code" /></a>
  </div>
</div>

<!--
Let's test our understanding with Concept Check Question 13.

Read the question carefully: What is the fundamental difference between Continuous Delivery and Continuous Deployment?

Option A says Continuous Delivery uses Docker while Continuous Deployment uses Kubernetes.

Option B says Continuous Delivery ensures code is always in a releasable state but requires manual approval for production, whereas Continuous Deployment automatically deploys every passing commit to production.

Option C says Continuous Delivery only works for mobile apps.

Option D says Continuous Deployment does not run automated tests.

The correct answer is Option B. That manual approval gate is the exact dividing line.

To summarize this slide, remember this key takeaway: The dividing line between Continuous Delivery and Continuous Deployment is whether the production release trigger is manual or fully automated.
-->
---

<!-- _class: lead -->
<!-- header: '2.9 AI Spec-Driven Process' -->

# **2.9 The Modern Frontier (AI Spec-Driven Process)**

> "AI is an amplifier: it amplifies disciplined engineering specifications,  
> but it equally amplifies careless, chaotic habits."

<!--
We now enter our final major module, Module 2.9: The Modern Frontier — AI Specification-Driven Process.

With the rise of Large Language Models and autonomous coding agents, the mechanics of software engineering are undergoing a historic transformation.

However, moving from informal 'vibe coding' to enterprise-grade AI engineering requires strict specifications, sandbox validation, and automated verification guardrails. AI writes code at superhuman speed, but humans must steer architecture and verify correctness.

To summarize this slide, remember this key takeaway: Spec-driven engineering provides the essential guardrails that turn generative AI from a chaotic prompter into a reliable engineering multiplier.
-->
---
<!-- _class: title-image-slide -->

## Specification-Driven AI vs. Vibe Coding

<div class="image-wrapper">
  <img src="../../img/ch02/comic_29_ai_spec_driven.png" alt="Specification-Driven AI Comic" />
</div>

<!--
Now we arrive at our final module, Module 2.9: The Modern Frontier — AI Spec-Driven Process.

Look at this comic contrasting two ways engineers use AI today.

On the left, we see 'Vibe Coding': a developer typing casual, vague prompts into an LLM, blindly copying 500 lines of generated code, and hoping it works. When bugs appear, they type another prompt and pray. That is an engineering nightmare!

On the right, we see Specification-Driven AI: an engineer writes precise specifications, defines automated test suites, and directs an AI agent within strict automated guardrails.

AI is an amplifier: it amplifies good engineering, but it also amplifies sloppy habits.

To summarize this slide, remember this key takeaway: AI tools are amplifiers: they amplify disciplined engineering specifications, but they also amplify careless chaotic habits.
-->
---
## AI-Augmented SDLC: The Paradigm Shift in Process Models

> In the AI era, software engineering is not about typing syntax—it is about **orchestrating the entire life cycle**. AI accelerates construction to near-zero marginal cost, shifting human value to **upstream** specification and **downstream** verification.

* **From Human-Centric to Agentic Processes:**
  - **Traditional Process Models (Waterfall / Agile / DevOps):** Designed to coordinate *human developers* through documents, standups, sprint boards, and code reviews.
  - **AI-Augmented Process Model:** Coordinates *autonomous AI agents alongside human architects* in a continuous co-engineering loop.
* **The SDLC Bottleneck Inversion:**
  - **Implementation is Commoditized:** Writing code, boilerplate, and syntax debugging no longer bottleneck development velocity.
  - **Value Shifts to the Bookends:** Critical human engineering shifts to **Upstream Intent (Domain Specs & Architecture)** and **Downstream Assurance (Verification & Safety)**.

<!--
Now let's examine AI-based software processes from the broader perspective of the entire Software Development Life Cycle.

Throughout this chapter, we've traced how process models evolved: from rigid Waterfall phases, to flexible Agile iterations, to automated DevOps pipelines. Today, we stand at the threshold of the next major evolution: the AI-Augmented SDLC.

Notice a fundamental shift: all previous process models were designed for humans! Waterfall gave humans detailed documents. Scrum gave humans daily standups and sprint boards.

In an AI-augmented process model, software construction is delegated to autonomous AI agents. Writing syntax is becoming a near-zero marginal cost activity.

Because coding is no longer the bottleneck, human engineering value shifts decisively to the bookends of the life cycle: Upstream into defining precise specifications and architectures, and Downstream into rigorous verification and testing.

This brings us to the central dilemma of modern software engineering: production systems demand 100% deterministic mathematical correctness, yet LLMs are inherently probabilistic.

How does a software process model bridge this gap? That is the defining question of AI engineering.

To summarize this slide, remember this key takeaway: In an AI-augmented process model, human engineers transition from typing syntax to orchestrating upstream specifications and downstream verification gates.
-->
---
## Operationalizing the AI Process: The Engineering Harness

> In Agile, process discipline is maintained through human rituals (standups, reviews). But an autonomous AI agent cannot attend a meeting.  
> **How do we enforce process discipline on AI? We mechanize the process into an Engineering Harness.**
> $$\mathbf{\text{Autonomous Production Agent}} = \mathbf{\text{LLM Model (Brain)}} + \mathbf{\text{Harness (Process Rails)}}$$

* **The Process-to-Machinery Bridge:**
  - In traditional SDLC, the software process coordinates *human behavior* via social agreements, ceremonies, and manual checkpoints.
  - In an AI-augmented SDLC, the process must be **embodied in software infrastructure** that actively steers and restrains autonomous agents.
  - The model provides raw generative intelligence; the harness guarantees engineering rigor, safety, and compliance.
* **Harness Engineering (Definition):**
  - The discipline of designing the operational equipment, deterministic guardrails, execution environments, and verification feedback loops that safely govern a probabilistic model.
  
<!--
This brings us to a crucial conceptual breakthrough: how do we actually operationalize a software process for an autonomous AI agent?

In Scrum or Kanban, we enforce process discipline through human social rituals: daily standup meetings, sprint planning, and manual pull request reviews.

But an autonomous AI coding agent cannot join your morning standup or read sticky notes on a whiteboard. If you want an AI agent to obey your software process, you must mechanize that process into software infrastructure.

That infrastructure is called an Engineering Harness!

Think of the formula on the slide: an Autonomous Agent is not just the model. The Model is merely the probabilistic brain. The Harness provides the hands, the guardrails, and the truth oracles.

Without a harness, an LLM wanders into chaotic vibe coding. With a harness, it becomes a disciplined, repeatable engineering partner.

To summarize this slide, remember this key takeaway: An Engineering Harness is the operational machinery that translates software process discipline into automated infrastructure for AI agents.
-->

---
<!-- _class: title-image-slide -->

## The Harness Metaphor: "I Don't Make It Smarter. I Design the Equipment."

<div class="image-wrapper">
  <img src="../../img/ch02/comic_harness_engineering.png" alt="Harness Engineering Horse Metaphor Comic" />
</div>
<p class="image-source">Image Source: <a href="https://medium.com/coding-nexus/harness-engineering-the-new-discipline-behind-ai-agents-that-ship-production-software-b80e40d17a43" target="_blank">Coding Nexus — Harness Engineering</a></p>

<!--
Look at this comic illustrating the heart of Harness Engineering.

The AI Model is like a magnificent, spirited horse: incredibly powerful, fast, and capable—yet inherently wild and unpredictable. If you let it run free with no gear, it can bolt off a cliff or throw its rider. That is what happens in unguided 'vibe coding'.

The software engineer doesn't make the horse's muscles stronger or its brain smarter. Instead, the engineer's true craft is designing the equipment: the harness, reins, bit, and stirrups!

Notice the equipment components labeled on the harness:
Across the back: Constraints—defining clear system boundaries and schemas.
Across the chest: Feedback Loops—steering and correcting course dynamically.
Hanging at the sides: Memory and Tools—providing state persistence and deterministic execution capabilities.

The engineer holding the reins smiles and says: 'I don't make it smarter. I design the equipment.'

To summarize this slide, remember this key takeaway: In the AI era, software engineers don't train models; we design the engineering harness that channels probabilistic intelligence into production software.
-->

---
## The Three Pillars of an Agent Engineering Harness

* **1. Context & Specification Harness (Input Rails):**
  - **Constrains Problem Scope:** Feeds machine-readable requirements (`SPEC.md`), architectural rules, and API contracts (`OpenAPI`, `Protobuf`).
  - **Eliminates Hallucination Drift:** Restricts the agent's attention to relevant codebase slices rather than unconstrained prompting.
* **2. Execution Sandbox Harness (Runtime Safety Rails):**
  - **Isolates Side Effects:** Executes code, shell commands, and builds inside ephemeral containers or isolated sandboxes (Docker, WebAssembly).
  - **Permission Boundaries:** Enforces strict file-access controls, preventing destructive deletions or unauthorized network exfiltration.
* **3. Verification & Oracle Harness (Feedback Rails):**
  - **Deterministic Ground Truth:** Compilers, typecheckers, linters, and automated test suites act as the infallible quality arbiter.
  - **Drives Autonomous Recovery:** Captures stack traces and diagnostic logs to feed the self-healing repair loop before human review.

<!--
Now let's examine the three foundational pillars that make up an Agent Engineering Harness.

Pillar 1 is the Context and Specification Harness, or the Input Rails. Large language models drift when prompts are vague. The input harness provides structured, machine-readable specifications, domain schemas, and architectural boundaries. It tells the agent exactly what problem to solve, and what rules it cannot break.

Pillar 2 is the Execution Sandbox Harness, or the Runtime Safety Rails. When an AI agent runs code or executes terminal commands, you cannot let it run loose on production servers or your root filesystem. The sandbox harness provides isolated, containerized environments with strict permission controls.

Pillar 3 is the Verification and Oracle Harness, or the Feedback Rails. This is the deterministic ground truth. The model might hallucinate that its code works, but the compiler and test suites don't lie. When a test fails, the oracle harness captures the exact failure log and feeds it back into the agent to trigger self-healing.

Together, these three pillars turn probabilistic AI into a rock-solid engineering engine.

To summarize this slide, remember this key takeaway: An engineering harness enforces process discipline through Input Rails (specs), Runtime Rails (sandboxes), and Feedback Rails (verification oracles).
-->
---
## The 3-Step Agentic Feedback Loop in Practice

* **Step 1: Formal Specification (Powered by Input Rails)**
  - Human architect writes unambiguous requirements, data schemas, interface contracts, and acceptance test criteria in structured Markdown (`SPEC.md`).
* **Step 2: Autonomous Agent Execution (Powered by Sandbox Rails)**
  - AI agent inspects repository context, formulates a multi-step plan, and implements code inside the safe execution harness.
* **Step 3: Automated Verification & Self-Healing (Powered by Oracle Rails)**
  - Automated test harness compiles code and executes unit, integration, and security suites.
  - **The Self-Healing Loop:** If any test fails, compiler errors and test traces automatically feed back into the agent harness for autonomous self-repair *before* human code review!

<!--
Now let's see how those three harness pillars translate into the daily operational workflow: The 3-Step Agentic Feedback Loop.

Step 1 is Formal Specification. Powered by our Input Rails, the human architect writes clear, machine-actionable specifications, API schemas, and acceptance tests. The human directs the 'What' and the 'Why.'

Step 2 is Autonomous Agent Execution. Inside the Sandbox Rails, the AI agent plans its work, creates files, writes code, and runs builds without risking system damage. The agent handles the 'How.'

Step 3 is Automated Verification and Self-Healing. Powered by our Oracle Rails, the automated CI pipeline immediately tests the code.

Here is the magic of modern agentic engineering: if a test fails, the error logs feed directly back into the agent harness. The agent reads the compiler error, reflects on its mistake, and modifies its own code to fix the defect—all before a human engineer ever looks at the pull request!

Notice how this completely closes the loop: human guidance at Step 1, automated machine self-healing at Step 3.

To summarize this slide, remember this key takeaway: The 3-step agentic loop pairs human specification with automated test oracles to enable reliable, self-healing software development.
-->

---
<!-- _class: title-image-slide -->

## Harness Engineering: From AI Brain to Production Code

<div class="image-wrapper">
  <img src="../../img/ch02/harness_engineering.png" alt="Harness Engineering: Model + Harness = Production Software" />
</div>
<p class="image-source">Image Source: <a href="https://medium.com/coding-nexus/harness-engineering-the-new-discipline-behind-ai-agents-that-ship-production-software-b80e40d17a43" target="_blank">Coding Nexus — Harness Engineering</a></p>

<!--
Look at this architecture diagram illustrating Harness Engineering.

On the left, we have the Powerful AI Brain—a Large Language Model capable of rapid reasoning and code generation. But on its own, it is probabilistic and untamed.

In the center is the Harness—the engineering scaffold surrounding the model. It contains four critical systems:
First, Constraints: rigid specifications and schemas that channel what the agent is allowed to build.
Second, Feedback Loops: automated self-healing mechanisms that feed error logs back to the agent.
Third, Verification Systems: compilers, linters, and test suites that act as objective oracles.
And fourth, Infrastructure: secure execution sandboxes and tool environments.

On the right is the outcome: Reliable Software Development—structured, modular, and production-ready.

Remember the golden equation of modern AI engineering: Agent equals Model plus Harness.

To summarize this slide, remember this key takeaway: Harness Engineering provides the constraints, feedback loops, verification systems, and infrastructure that turn raw AI capability into dependable software.
-->
---
## 4 Golden Principles for AI-Driven Processes

1. **Specifications as Single Source of Truth:**
   - LLMs have short attention spans and forget chat history. Structured files (`SPEC.md`, `ARCHITECTURE.md`) provide persistent context.
2. **The Harness as Deterministic Ground Truth (Verification Oracle):**
   - Never trust raw LLM output without execution. Automated test harnesses, compilers, and linters serve as the deterministic oracle for agent validation and self-healing.
3. **Small, Testable Incremental Prompts:**
   - Prompting an AI to "build an entire Amazon clone" yields broken hallucinated code. Break tasks into small vertical slices (TDD style!).
4. **Human-in-the-Loop Architectural Governance:**
   - AI writes the tactical code (Driver); human engineers remain the strategic architects (Navigator).

* > 🚀 **The New Role of the Software Engineer:** You are no longer just a code typist. You are a **Systems Architect, Specification Author, and Verification Governor**.

<!--
Here are the 4 Golden Principles for AI-Driven Processes:

1. Specification as the Single Source of Truth: If it is not in the specification, the AI cannot guess it.

2. Test Harness as the Ground Truth Guardrail: Never trust AI-generated code without automated test harnesses that verify behavior and edge cases.

3. Small, Verifiable Increments: Never ask an AI to 'build an entire social network.' Ask it to implement one well-defined function or module at a time.

4. Human Architectural Oversight: The human engineer is always responsible for security, performance, data models, and system coherence.

To summarize this slide, remember this key takeaway: Anchor AI coding in verifiable test harnesses and small incremental steps with human architectural oversight.
-->
---
### Concept Check Question 14 (CCQ 14)
<!-- id: ase-ch02-ccq14 -->

<div class="ccq-columns">
  <div class="ccq-text">

In modern AI Specification-Driven development, what is the primary role of automated CI/CD verification gates?

- **A.** To prevent human developers from reviewing artificial intelligence output.
- **B.** To enforce deterministic quality, test compliance, and defect containment before AI-generated code merges into production.
- **C.** To convert natural language prompts directly into cloud infrastructure invoices.
- **D.** To replace software specifications with unverified prompt histories.

  </div>
  <div class="ccq-logo">
    <a href="https://nlhsueh.github.io/nickedupocket/#/student/ase-ch02-ccq14" target="_blank"><img src="../../img/ch02/ase-ch02-ccq14.png" alt="QR Code" /></a>
  </div>
</div>

<!--
Let's work through Concept Check Question 14.

Read the prompt on screen: In modern AI Specification-Driven development, what is the primary role of automated CI/CD verification gates?

Let's examine the options:
Option A is wrong because human architects still review pull requests.
Option C refers to cloud billing, which is irrelevant.
Option D suggests replacing specifications, which is the exact opposite of spec-driven development.

The correct answer is Option B! When autonomous AI coding agents generate code at superhuman speeds, automated CI/CD verification gates—including linters, compilers, static analyzers, and unit/integration test suites—act as deterministic quality filters to contain defects and ensure compliance before AI code can ever touch production.

To summarize this slide, remember this key takeaway: Automated CI/CD verification gates provide deterministic safety boundaries for autonomous AI coding agents.
-->
---

<!-- _class: lead -->
<!-- header: '2.10 Recap & References' -->

# **2.10 Conceptual Recap & References**

> "Theory without practice is empty;  
> practice without theory is blind."

<!--
We have arrived at Module 2.10: Conceptual Recap and References.

Over this chapter, we have journeyed through the full spectrum of software development processes—from plan-driven Waterfall and V-Models to Agile, Scrum, Kanban, Extreme Programming, DevOps, and AI Spec-Driven workflows.

Let's synthesize what we have learned through an interactive recap quiz and review key foundational references.

To summarize this slide, remember this key takeaway: Mastery of software engineering comes from harmonizing technical craft with sound process judgment.
-->
---
## Conceptual Recap: Fill-in-the-blank Quiz

Test your mastery across the 9 software process modules:

1. Software processes consist of 4 universal activities: Specification, Design/Implementation, **___**, and Evolution.
2. The **___** model organizes testing symmetrically against requirements and design stages.
3. Delivering functional vertical slices is **___**, while progressively refining an existing whole is **___**.
4. The Agile Manifesto explicitly values **___** over following a plan.
5. In Kanban, the primary mechanism used to expose bottlenecks and optimize flow is limiting **___**.
6. Taking shortcuts to ship quickly incurs **___**, which degrades future developer velocity.
7. In Extreme Programming, the practice of writing automated tests before production code is **___**.
8. In DevOps, the elite performance metrics established by Google are known as the **___** metrics.
9. Grounding AI coding agents with formal markdown documents and automated test harnesses is called **___**.

<!--
Now, let's do an interactive conceptual recap! I'll read each clue, and I want you to shout out the missing concept.

1. The classic sequential model with five linear phases: Waterfall!

2. The model pairing every design phase with a test phase: The V-Model!

3. Delivering features piece by piece: Incremental delivery!

4. Refining a whole system over repeated cycles: Iterative development!

5. Agile management with Sprints and Scrum Masters: Scrum!

6. Continuous flow system that limits Work-in-Progress: Kanban!

7. The hidden interest paid for cutting corners: Technical Debt!

8. XP practice of writing failing tests before code: Test-Driven Development (TDD)!

9. Automatically building and testing every commit: Continuous Integration (CI)!

10. Guiding AI with formal contracts and test harnesses: Specification-Driven AI!

Excellent job, everyone!

To summarize this slide, remember this key takeaway: These core concepts form the foundational vocabulary of professional software engineering practices.
-->
---
## References & Further Reading

* **Ian Sommerville** (2016). *Software Engineering* (10th Edition). Pearson.
* **Kent Beck** (2004). *Extreme Programming Explained: Embrace Change* (2nd Edition). Addison-Wesley.
* **Martin Fowler** (2018). *Refactoring: Improving the Design of Existing Code* (2nd Edition). Addison-Wesley.
* **Ken Schwaber & Jeff Sutherland** (2020). *The Scrum Guide*. [scrumguides.org](https://scrumguides.org/)
* **Nicole Forsgren, Jez Humble, Gene Kim** (2018). *Accelerate: Building and Scaling High Performing Technology Organizations (DORA)*. IT Revolution.

<!--
To close today's lecture, here are the essential references and further reading.

For foundational concepts, read Ian Sommerville's *Software Engineering*.

For technical craftsmanship, read Kent Beck's *Extreme Programming Explained* and Martin Fowler's *Refactoring*.

For agile management, check out Henrik Kniberg's *Scrum and XP from the Trenches*.

And for modern DevOps and organizational velocity, read *Accelerate* by Nicole Forsgren, Jez Humble, and Gene Kim.

Thank you all for your active participation today. I'll see you in our next lecture!

To summarize this slide, remember this key takeaway: Great software engineers combine deep technical craft with disciplined process awareness and continuous learning.
-->

<script>
(function() {
  // =========================================================================
  // 1. Header Dropdown (Table of Contents / Outline)
  // =========================================================================
  function initHeaderDropdown() {
    const sections = [];
    const seenTitles = new Set();
    const slideSections = document.querySelectorAll('section[id]');
    
    // 1. Scan unique section titles and their slide IDs
    slideSections.forEach(sec => {
      const header = sec.querySelector('header');
      if (!header) return;
      
      let title = header.textContent.trim();
      title = title.replace(/^[◄◀]\s*/, '').replace(/\s*[►▶]$/, '').trim();
      if (!title || seenTitles.has(title)) return;
      
      seenTitles.add(title);
      sections.push({
        id: sec.id,
        title: title
      });
    });

    if (sections.length === 0) return;

    // Detect language: if slide titles don't have Chinese characters, use English
    const allTitles = sections.map(s => s.title).join('');
    const isEn = !/[\u4e00-\u9fa5]/.test(allTitles);
    const txtOutline = isEn ? '📑 Table of Contents' : '📑 章節目錄';
    const txtTitleTooltip = isEn ? 'Click to pin or hover to view outline' : '點擊固定或懸停查看章節目錄';
    const txtPrev = isEn ? 'Previous Section' : '上一章節';
    const txtNext = isEn ? 'Next Section' : '下一章節';

    // Helper to create the dropdown DOM
    function createDropdownWrapper(currentTitle) {
      const wrapper = document.createElement('span');
      wrapper.className = 'header-nav-wrapper';
      
      const titleSpan = document.createElement('span');
      titleSpan.className = 'header-nav-title';
      titleSpan.title = txtTitleTooltip;
      titleSpan.innerHTML = currentTitle + '<span class="nav-caret"> ▾</span>';
      
      titleSpan.addEventListener('click', function(e) {
        e.stopPropagation();
        const wasOpen = wrapper.classList.contains('is-open');
        document.querySelectorAll('.header-nav-wrapper.is-open').forEach(w => w.classList.remove('is-open'));
        if (!wasOpen) {
          wrapper.classList.add('is-open');
        }
      });
      
      const dropdown = document.createElement('div');
      dropdown.className = 'nav-dropdown';
      
      dropdown.addEventListener('click', function(e) {
        e.stopPropagation();
      });
      
      const dropHeader = document.createElement('div');
      dropHeader.className = 'nav-dropdown-header';
      dropHeader.innerHTML = '<span>' + txtOutline + '</span>';
      dropdown.appendChild(dropHeader);
      
      const grid = document.createElement('div');
      grid.className = 'nav-dropdown-grid';
      
      sections.forEach(s => {
        const item = document.createElement('a');
        const isActive = (s.title === currentTitle);
        item.className = 'nav-dropdown-item' + (isActive ? ' active' : '');
        item.href = '#' + s.id;
        item.innerHTML = '<span class="badge">#' + s.id.padStart(2, '0') + '</span><span class="item-text" title="' + s.title + '">' + s.title + '</span>';
        
        item.addEventListener('click', function(e) {
          e.preventDefault();
          wrapper.classList.remove('is-open');
          dropdown.style.display = 'none';
          const targetHash = '#' + s.id;
          if (window.location.hash === targetHash) {
            window.dispatchEvent(new HashChangeEvent('hashchange'));
          } else {
            window.location.hash = targetHash;
          }
          setTimeout(() => { dropdown.style.display = ''; }, 350);
        });
        
        grid.appendChild(item);
      });
      
      dropdown.appendChild(grid);
      wrapper.appendChild(titleSpan);
      wrapper.appendChild(dropdown);
      return wrapper;
    }

    // Close any pinned dropdown when clicking anywhere outside
    document.addEventListener('click', function(e) {
      if (!e.target.closest('.header-nav-wrapper')) {
        document.querySelectorAll('.header-nav-wrapper.is-open').forEach(w => w.classList.remove('is-open'));
      }
    });

    // 2. Enhance each header element across all slides
    slideSections.forEach(sec => {
      const header = sec.querySelector('header');
      if (!header || header.dataset.navEnhanced) return;
      header.dataset.navEnhanced = 'true';
      
      const links = header.querySelectorAll('a');
      let prevLink = null;
      let nextLink = null;
      
      links.forEach(a => {
        const txt = a.textContent.trim();
        if (txt === '◄' || txt === '◀') prevLink = a;
        if (txt === '►' || txt === '▶') nextLink = a;
      });
      
      let title = header.textContent.trim();
      title = title.replace(/^[◄◀]\s*/, '').replace(/\s*[►▶]$/, '').trim();
      if (!title) return;
      
      header.innerHTML = '';
      if (prevLink) {
        prevLink.className = 'header-nav-arrow';
        prevLink.title = txtPrev;
        header.appendChild(prevLink);
        header.appendChild(document.createTextNode(' '));
      }
      
      const wrapper = createDropdownWrapper(title);
      header.appendChild(wrapper);
      
      if (nextLink) {
        header.appendChild(document.createTextNode(' '));
        nextLink.className = 'header-nav-arrow';
        nextLink.title = txtNext;
        header.appendChild(nextLink);
      }
    });
  }

  // =========================================================================
  // 2. Number Quick Jump (<kbd>Num</kbd> + <kbd>Enter</kbd>)
  // =========================================================================
  function initNumberQuickJump() {
    let inputBuffer = '';
    let timer = null;
    let hud = null;

    // Detect language: check titles or body text
    const slideSections = document.querySelectorAll('section[id]');
    let hasZh = false;
    slideSections.forEach(s => {
      if (/[\u4e00-\u9fa5]/.test(s.textContent || '')) hasZh = true;
    });
    const isEn = !hasZh;

    function getOrCreateHud() {
      if (!hud) {
        hud = document.createElement('div');
        hud.id = 'slide-quick-jump-hud';
        hud.style.cssText = [
          'position: fixed',
          'bottom: 36px',
          'left: 50%',
          'transform: translateX(-50%)',
          'background: rgba(15, 23, 42, 0.94)',
          'color: #ffffff',
          'padding: 8px 18px',
          'border-radius: 28px',
          'font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, system-ui, sans-serif',
          'font-size: 14px',
          'font-weight: 500',
          'box-shadow: 0 16px 36px rgba(0, 0, 0, 0.35), 0 0 0 1px rgba(255, 255, 255, 0.15)',
          'backdrop-filter: blur(16px)',
          '-webkit-backdrop-filter: blur(16px)',
          'z-index: 999999',
          'display: none',
          'align-items: center',
          'gap: 8px',
          'pointer-events: none',
          'opacity: 0',
          'transition: opacity 0.15s ease, transform 0.15s ease'
        ].join(';');
        const targetParent = document.fullscreenElement || document.body;
        targetParent.appendChild(hud);
      }
      const parent = document.fullscreenElement || document.body;
      if (hud.parentElement !== parent) {
        parent.appendChild(hud);
      }
      return hud;
    }

    function getTotalSlides() {
      const secs = document.querySelectorAll('section[id]');
      return secs.length || 1;
    }

    function showHud() {
      const el = getOrCreateHud();
      const total = getTotalSlides();
      const label = isEn ? 'Go to slide:' : '跳至頁碼:';
      const enterHint = isEn ? 'Enter ↵' : 'Enter 確認 ↵';
      el.innerHTML = '<span>🧭 ' + label + '</span> ' +
        '<strong style="color: #38bdf8; font-size: 20px; font-weight: 700; font-family: ui-monospace, SFMono-Regular, Menlo, monospace; letter-spacing: 1px;">' + inputBuffer + '</strong> ' +
        '<span style="opacity: 0.6; font-size: 13px;">/ ' + total + '</span> ' +
        '<span style="background: rgba(255,255,255,0.18); padding: 2px 7px; border-radius: 6px; font-size: 11px; margin-left: 2px; font-weight: 600;">' + enterHint + '</span>';
      el.style.display = 'flex';
      el.style.opacity = '1';

      if (timer) clearTimeout(timer);
      timer = setTimeout(clearInput, 2800);
    }

    function clearInput() {
      inputBuffer = '';
      if (timer) {
        clearTimeout(timer);
        timer = null;
      }
      if (hud) {
        hud.style.opacity = '0';
        setTimeout(() => {
          if (inputBuffer === '' && hud) hud.style.display = 'none';
        }, 150);
      }
    }

    function jumpToSlide(num) {
      const total = getTotalSlides();
      const target = Math.max(1, Math.min(num, total));
      const targetHash = '#' + target;
      
      // Visual flash confirmation
      const el = getOrCreateHud();
      const confirmedMsg = isEn ? ('✓ Slide ' + target) : ('✓ 第 ' + target + ' 頁');
      el.innerHTML = '<span style="color: #34d399; font-weight: 700; font-size: 15px;">' + confirmedMsg + '</span>';
      el.style.display = 'flex';
      el.style.opacity = '1';
      setTimeout(clearInput, 500);

      if (window.location.hash === targetHash) {
        window.dispatchEvent(new HashChangeEvent('hashchange'));
      } else {
        window.location.hash = targetHash;
      }
    }

    window.addEventListener('keydown', function(e) {
      // Don't intercept when focusing editable form elements
      const active = document.activeElement;
      if (active && (active.tagName === 'INPUT' || active.tagName === 'TEXTAREA' || active.tagName === 'SELECT' || active.isContentEditable)) {
        return;
      }

      // Ignore if modifier keys are pressed
      if (e.ctrlKey || e.altKey || e.metaKey) {
        return;
      }

      // Resolve digit from key or code (supports '2', 'Digit2', 'Numpad2')
      let digit = null;
      if (e.key >= '0' && e.key <= '9') {
        digit = e.key;
      } else if (/^(?:Digit|Numpad)([0-9])$/.test(e.key)) {
        digit = e.key.replace(/^(?:Digit|Numpad)/, '');
      } else if (/^(?:Digit|Numpad)([0-9])$/.test(e.code || '')) {
        digit = (e.code || '').replace(/^(?:Digit|Numpad)/, '');
      }

      if (digit !== null) {
        inputBuffer += digit;
        if (inputBuffer.length > 4) inputBuffer = inputBuffer.slice(-4);
        showHud();
        return;
      }

      // Backspace
      if ((e.key === 'Backspace' || e.code === 'Backspace') && inputBuffer.length > 0) {
        e.preventDefault();
        e.stopPropagation();
        inputBuffer = inputBuffer.slice(0, -1);
        if (inputBuffer.length === 0) {
          clearInput();
        } else {
          showHud();
        }
        return;
      }

      // Escape
      if ((e.key === 'Escape' || e.code === 'Escape') && inputBuffer.length > 0) {
        e.preventDefault();
        e.stopPropagation();
        clearInput();
        return;
      }

      // Enter key confirms numeric jump
      if ((e.key === 'Enter' || e.code === 'Enter' || e.code === 'NumpadEnter') && inputBuffer.length > 0) {
        e.preventDefault();
        e.stopPropagation();
        const targetPage = parseInt(inputBuffer, 10);
        if (!isNaN(targetPage)) {
          jumpToSlide(targetPage);
        } else {
          clearInput();
        }
      }
    }, true);
  }

  // Initialize both features
  function init() {
    initHeaderDropdown();
    initNumberQuickJump();
  }

  if (document.readyState === 'loading') {
    document.addEventListener('DOMContentLoaded', init);
  } else {
    init();
  }
  setTimeout(init, 400);
})();

</script>
