---
marp: true
theme: ase-theme
title: 'Software Engineering'
paginate: true
header: 'Software Engineering | Ch 06: User Experience (UX) & Interaction Design'
footer: 'Prof. Nien-Lin Hsueh'
---
<!-- _class: lead -->
<!-- header: '' -->

# Software Engineering
### Chapter 6: User Experience (UX) Engineering & Interaction Design
#### From Cognitive Foundations & Quantitative Laws to Empirical Usability Engineering

**Prof. Nien-Lin Hsueh**
Department of Information Engineering and Computer Science
Feng Chia University

<!--
Welcome everyone to Chapter 6 of Software Engineering: User Experience (UX) Engineering, Human-Computer Interaction (HCI), and Interaction Design.

In previous chapters, we mastered how to elicit requirements, model system behavior with UML, and architect scalable backend systems. Yet even the most fault-tolerant, sub-millisecond microservice architecture will fail in the real world if human users cannot understand its conceptual model, navigate its interface, or recover from errors safely.

In this 60-slide academic lecture, we approach UX not as subjective artistic decoration, but as a rigorous engineering and cognitive science discipline. We will progress from ISO usability standards and human information processing to quantitative interaction laws, human-centered research, information architecture, Jakob Nielsen's 10 heuristics, empirical usability testing, and AI-augmented UX design.

To summarize this slide, remember this key takeaway: UX Engineering bridges human cognitive psychology and software design to ensure systems are useful, usable, accessible, and safe.
-->
---
<!-- _class: outline-slide -->

## Chapter 6: Roadmap & Core Curriculum

<div class="outline-columns">
<div>
<h3>Part 1: Foundations, Cognition, Laws & Research</h3>
<ul>
<li><b>6.1 Foundations of HCI, UX & Usability:</b> ISO 9241-210, UI vs. UX, Garrett's 5 Planes, and Nielsen's 5 usability dimensions.</li>
<li><b>6.2 Cognitive Psychology & Mental Models:</b> Model Human Processor, Norman's 7 Stages of Action, Gulfs, and Cognitive Load.</li>
<li><b>6.3 Quantitative Laws & Visual Perception:</b> Fitts's Law, Hick's Law, Tesler's Law, Gestalt grouping, and WCAG accessibility.</li>
<li><b>6.4 Human-Centered Design & User Research:</b> Double Diamond lifecycle, empirical research, Personas, JTBD, and Journey Maps.</li>
</ul>
</div>
<div>
<h3>Part 2: Architecture, Evaluation, Testing & AI UX</h3>
<ul>
<li><b>6.5 Information Architecture & Prototyping:</b> Taxonomies, Card Sorting, Tree Testing, Wireframing, and Atomic Design Systems.</li>
<li><b>6.6 Analytical Evaluation (Heuristics):</b> Heuristic Evaluation workflow, Nielsen's 10 Usability Heuristics, and Cognitive Walkthroughs.</li>
<li><b>6.7 Empirical Testing, Metrics & Ethics:</b> Think-Aloud testing, N=5 model, SUS score, HEART metrics, A/B testing, and Dark Patterns.</li>
<li><b>6.8 AI-Augmented UX & Synthesis:</b> AI for UX vs. UX for AI, interactive concept recap, self-assessment, and reference solutions.</li>
</ul>
</div>
</div>

<!--
Here is our comprehensive 8-section academic roadmap for Chapter 6, organized into two main parts:

In Part 1 (Sections 6.1 to 6.4), we build our theoretical and empirical foundation:
Section 6.1 defines HCI, UX, and Usability through ISO 9241 standards, Garrett's 5 Planes, and Jakob Nielsen's 5 quality components.
Section 6.2 explores Cognitive Psychology: how human perception, working memory, Mental Models, and Don Norman's Gulfs of Execution and Evaluation govern every user interaction.
Section 6.3 covers Quantitative Laws of Interaction (Fitts's Law, Hick-Hyman Law, Jakob's Law, Tesler's Law), Gestalt visual perception, and WCAG accessibility engineering.
Section 6.4 introduces the ISO Human-Centered Design (HCD) Double Diamond process, empirical user research, Personas, Jobs-to-be-Done (JTBD), and Customer Journey Maps.

In Part 2 (Sections 6.5 to 6.8), we move from structure and prototyping to analytical inspection, empirical testing, and AI:
Section 6.5 covers Information Architecture (IA), Card Sorting, Tree Testing, the Prototyping Fidelity Spectrum, and Atomic Design Systems.
Section 6.6 examines Analytical Evaluation using Jakob Nielsen's 10 Usability Heuristics and Cognitive Walkthroughs.
Section 6.7 covers Empirical Usability Testing, the System Usability Scale (SUS), Google's HEART framework, and Ethical UX (Dark Patterns).
Finally, Section 6.8 explores AI-Augmented UX (AI for UX vs. UX for AI) and synthesizes the entire chapter.

To summarize this slide, remember this key takeaway: Our curriculum follows the full UX engineering lifecycle from cognitive theory and user research to information architecture, heuristic inspection, and empirical validation.
-->
---
<!-- _class: lead -->
<!-- header: '6.1 Foundations of HCI, UX & Usability' -->

# **6.1 Foundations of HCI, UX & Usability Engineering**

> "Design is not just what it looks like and feels like. Design is how it works."  
> — *Steve Jobs (Co-founder of Apple)*

<!--
Welcome to Section 6.1: Foundations of HCI, UX, and Usability Engineering.

A common misconception among software engineers is equating User Experience (UX) with graphic design—choosing colors, border radii, or animations at the very end of a sprint. In reality, visual styling is only the outermost surface of a much deeper architectural structure.

In this section, we establish the formal academic definitions of Human-Computer Interaction (HCI), User Experience (ISO 9241-210), and Usability (ISO 9241-11 & Jakob Nielsen), and examine why UX engineering directly determines software project survival.

To summarize this slide, remember this key takeaway: UX Engineering is a foundational software engineering discipline that governs how a product works, not merely how its surface looks.
-->
---
## What is User Experience (UX)? Formal Definitions

> **ISO 9241-210 Definition:** User Experience is *"a person's perceptions and responses resulting from the use and/or anticipated use of a system, product or service."*

<div class="two-columns">
<div class="card" data-marpit-fragment>

### 1. HCI vs. UX vs. UI vs. CX
- **Human-Computer Interaction (HCI)**:
  - The academic discipline uniting computer science, cognitive psychology, and ergonomics to study interactive computing systems.
- **User Interface (UI — The Conduit)**:
  - The concrete visual, auditory, or tactile presentation layer (buttons, typography, layouts, voice prompts) through which users interact.
- **User Experience (UX — The Holistic Outcome)**:
  - The end-to-end cognitive, behavioral, and emotional journey before, during, and after interacting with the system.
- **Customer Experience (CX)**:
  - The broader organizational umbrella encompassing marketing, pricing, retail support, and multi-channel brand interactions.

</div>
<div class="card" data-marpit-fragment>

### 2. Why UI Alone Cannot Save a Broken UX
- **[Case Study] The Food Delivery Checkout Paradox**:
  - Suppose a Food Delivery app features award-winning gradients and smooth 120Hz animations (**Great UI**).
  - However, it hides delivery surge fees until the final step, loses the cart when switching payment methods, and offers no cancel button (**Broken UX**).
- **Engineering Insight**:
  - **UI** is the saddle, the stirrups, and the reins; **UX** is whether the rider actually reaches their destination safely and comfortably.
  - A beautiful UI on top of a flawed task workflow only accelerates user frustration.

</div>
</div>

<!--
Let's begin by distinguishing four terms that are frequently confused in industry: HCI, UI, UX, and CX.

Look at the left card:
Human-Computer Interaction (HCI) is the foundational academic field founded by pioneers like Stuart Card, Thomas Moran, Allen Newell, and Don Norman in the early 1980s.
User Interface (UI) is the concrete presentation medium—the pixels, buttons, forms, and touch controls on the screen.
User Experience (UX), as defined by ISO 9241-210, encompasses the user's holistic perceptions, cognitive load, task efficiency, and emotional responses before, during, and after using the system.
Customer Experience (CX) extends even further to include brand marketing, pricing, and customer service hotline interactions.

Look at the right card: Why can't a polished UI save a broken UX?
Consider our Food Delivery platform: if the app has gorgeous typography and animations (UI), but wipes out the user's customized meal cart whenever a credit card fails validation (UX), users will abandon the app immediately.

To summarize this slide, remember this key takeaway: UI is the visible interaction surface, whereas UX encompasses the entire structural, functional, and cognitive journey of accomplishing a user goal.
-->
---
<!-- _class: title-image-slide -->

## Visual Comparison: UI vs. UX in Real-World Products

<div class="image-wrapper">
  <img src="../../img/ux/ui_vs_ux_comparison_new.png" alt="Visual Comparison of UI versus UX" />
</div>

<!--
Examine this visual illustration contrasting User Interface (UI) design and User Experience (UX) design.

Notice the classic ketchup bottle analogy and digital product comparison:
The glass ketchup bottle on the left was designed with an iconic, aesthetically pleasing visual form (UI). Yet when a user actually tries to pour ketchup onto their plate, it either refuses to come out or splatters everywhere—a classic usability failure!
By contrast, the inverted squeeze bottle on the right was engineered around human ergonomics, physics, and the actual context of use (UX): the nozzle stays primed at the bottom, dispensing the exact amount needed with one squeeze.

In software systems, UI focuses on visual presentation, color palettes, and component styling, while UX focuses on information architecture, interaction flows, error prevention, and cognitive alignment with user goals.

To summarize this slide, remember this key takeaway: Great software products harmonize aesthetic UI presentation with ergonomic, goal-driven UX engineering.
-->
---
## Why UX Engineering Matters in Software Engineering

* **1. The Economic ROI of Early UX Engineering (Boehm's Law Applied to UX):**
  - Fixing a workflow or mental-model flaw during **UX Prototyping** costs **$1** (moving a wireframe box in 5 minutes).
  - Fixing that same flaw after **Backend API & UI Coding** costs **$10–$20**; fixing it after **Production Release** costs **$50–$100+** in rework, support tickets, and user churn.
* **2. Operational Efficiency & Error Reduction in Enterprise Systems:**
  - Every extra click or ambiguous label multiplied across 50,000 daily courier dispatches wastes thousands of labor hours and inflates operational error rates.
* **3. Safety-Critical Systems: When Poor UX Becomes Fatal:**
  - **[Case 1] Therac-25 Radiation Therapy (1985–1987)**: Cryptic error codes (`Malfunction 54`) and mode-confusion UI contributed to lethal radiation overdoses.
  - **[Case 2] Hawaii Ballistic Missile False Alarm (2018)**: Ambiguous dropdown links (`PACOM (CDW) - STATE ONLY` vs. `Test Missile Alert`) with no confirmation dialog triggered statewide panic.

<!--
Why should backend and full-stack software engineers care deeply about UX Engineering?

First, consider the economic return on investment (ROI): Barry Boehm's Cost of Change curve applies directly to user interfaces! Discovering that a 5-step checkout flow confuses users during a 10-minute wireframe test costs almost nothing to fix. Discovering it after engineers have hardcoded database schemas, REST APIs, and React state machines costs 50 to 100 times more!

Second, in enterprise software, usability directly impacts business throughput. Shaving 5 seconds of confusion off a courier dispatch screen saves thousands of hours per month across a fleet.

Third, in safety-critical domains—medical devices, aviation cockpits, nuclear power plants, and emergency alert systems—poor UX is not a minor annoyance; it can be fatal. In the 2018 Hawaii false missile alert, an operator clicked the wrong link in a cluttered list of nearly identical text strings with no preview or confirmation dialog.

To summarize this slide, remember this key takeaway: Early UX engineering prevents expensive late-stage code rework, boosts operational productivity, and safeguards against catastrophic human error.
-->
---
## Structural Frameworks: Garrett's 5 Planes & Morville's Honeycomb

> **Architectural View of UX:** UX is built from the **bottom up**—from abstract business/user strategy to concrete visual pixels.

<div class="two-columns">
<div class="card" data-marpit-fragment>

### 1. Jesse James Garrett's 5 Planes of UX (Bottom → Top)
1. **Surface Plane (Concrete)**: Visual sensory design—color palettes, typography, icons, and micro-animations.
2. **Skeleton Plane**: Interface layout, wireframes, navigation bars, and information presentation placement.
3. **Structure Plane**: **Interaction Design (IxD)** (system behavior over time) and **Information Architecture (IA)** (taxonomy).
4. **Scope Plane**: Functional specifications (feature set) and content requirements (*aligns with SRS!*).
5. **Strategy Plane (Abstract)**: User needs (Personas/JTBD) + Business objectives (ROI/KPIs).

</div>
<div class="card" data-marpit-fragment>

### 2. Peter Morville's 7 Facets (The UX Honeycomb)
- **Useful**: Does the system solve a real, meaningful problem?
- **Usable**: Is the interface easy and intuitive to operate?
- **Findable**: Can users locate features and content when needed?
- **Credible**: Do users trust the system's security and accuracy?
- **Accessible**: Can users with diverse abilities (visual, motor, auditory, cognitive) use it effectively?
- **Desirable**: Does the aesthetic and brand evoke positive emotion?
- **Valuable**: Does it deliver measurable value to users and sponsors?

</div>
</div>

<!--
How do UX architects structure a software product systematically? Let's examine two foundational models in the field: Jesse James Garrett's 5 Planes of UX on the left, and Peter Morville's UX Honeycomb on the right.

In the left card, Garrett's 5 Planes demonstrate why UX must be engineered from the bottom up (Plane 5 up to Plane 1):
At the bottom is the **Strategy Plane** (Why are we building this, and for whom?), followed by the **Scope Plane** (What features belong in our Software Requirements Specification?).
Next comes the **Structure Plane**, where we define Information Architecture and Interaction Design flows.
Above that sits the **Skeleton Plane** (wireframes and control placement), and finally, at the very top, the **Surface Plane** (visual styling).
If you try to design the Surface Plane without fixing the Strategy, Scope, and Structure beneath it, the product collapses!

In the right card, Peter Morville's UX Honeycomb expands our evaluation criteria beyond mere usability into seven facets: Useful, Usable, Findable, Credible, Accessible, Desirable, and Valuable.

To summarize this slide, remember this key takeaway: Garrett's 5 Planes organize UX design from abstract strategy up to visual surface, while Morville's Honeycomb defines the seven quality facets of a complete user experience.
-->
---
## ISO 9241-11 & Jakob Nielsen's 5 Quality Components of Usability

> **ISO 9241-11 Definition:** Usability is the extent to which a system can be used by **specified users** to achieve **specified goals** with **effectiveness, efficiency, and satisfaction** in a **specified context of use**.

| Nielsen's 5 Usability Dimensions | Core Engineering Question | Empirical Measurement Metric (Quantitative) |
| :--- | :--- | :--- |
| **1. Learnability** | How easily can a **first-time novice** accomplish basic tasks upon first encounter? | First-attempt **Task Completion Rate (%)** & time to complete onboarding without assistance. |
| **2. Efficiency** | Once users have learned the system, **how quickly** can they perform frequent tasks? | **Time-on-Task (seconds)**, number of clicks/keystrokes, or orders processed per minute. |
| **3. Memorability** | After returning from a hiatus (weeks/months), how easily can users **re-establish proficiency**? | Task completion time & error count after a **30-day non-use interval**. |
| **4. Errors** | How many errors do users make, how **severe** are they, and how easily can they **recover**? | **Error Rate per Task**, frequency of critical dead-ends, and mean time to recover. |
| **5. Satisfaction** | How pleasant, comfortable, and frustration-free is the subjective experience? | Post-study standardized scales: **SUS (0–100)**, **CSAT**, or **Net Promoter Score (NPS)**. |

<!--
Now let's zoom in on the most testable engineering subset of UX: **Usability**.

ISO 9241-11 defines usability around three pillars—Effectiveness (can users complete the goal accurately?), Efficiency (how much effort/time does it take?), and Satisfaction (how comfortable do they feel?)—always evaluated relative to specific users, specific goals, and a specific environment.

Jakob Nielsen, co-founder of the Nielsen Norman Group, operationalized usability into **5 measurable quality components** shown in this table:
1. **Learnability**: How fast can a novice place their first food order without reading a manual?
2. **Efficiency**: How fast can an experienced restaurant cashier accept 20 incoming orders during the Friday dinner rush? (Notice that novices need high Learnability, while daily power users need high Efficiency!)
3. **Memorability**: If a user only files taxes once a year, can they remember how the interface works without starting from scratch?
4. **Errors**: How often do users make slips or mistakes, and how gracefully does the system help them recover?
5. **Satisfaction**: Measured empirically via instruments like the System Usability Scale (SUS).

To summarize this slide, remember this key takeaway: Usability is not a vague opinion; it is quantified across Learnability, Efficiency, Memorability, Errors, and Satisfaction.
-->
---
## The Aesthetic-Usability Effect & Norman's 3 Levels of Emotional Design

> **Empirical Finding (Kurosu & Kashimura, 1995):** Users perceive **aesthetically pleasing interfaces as more usable** than they objectively are—up to a critical threshold!

<div class="two-columns">
<div class="card" data-marpit-fragment>

### 1. The Aesthetic-Usability Effect
- **Origin (ATM Study, 1995)**:
  - Researchers tested 26 layouts of an ATM with identical functionality and number of buttons.
  - Layouts rated higher in visual beauty were consistently rated significantly **easier to use** (`r = 0.589`), even when actual task speed was identical.
- **Engineering Implications & Limits**:
  - **[Benefit]**: Visual polish builds initial trust and makes users more tolerant of **minor** usability hiccups.
  - **[Boundary Limit]**: Aesthetics **cannot** mask **severe** task failures (e.g., broken checkout or lost data).

</div>
<div class="card" data-marpit-fragment>

### 2. Don Norman's 3 Levels of Emotional Processing
- **1. Visceral Level (Pre-conscious / First Impression)**:
  - Instantaneous (`< 50ms`) gut reaction to visual symmetry, color harmony, typography, and tactile feel.
- **2. Behavioral Level (In-Use / Functional Usability)**:
  - Subconscious experience while performing tasks—governed by **usability, feedback speed, and feel of control**.
- **3. Reflective Level (Post-Use / Conscious Meaning)**:
  - Intellectual rationalization, personal identity, brand pride, and whether the user recommends the product to peers.

</div>
</div>

<!--
How do aesthetics and emotion interact with functional usability? Let's examine two classic theories: the Aesthetic-Usability Effect and Don Norman's Three Levels of Emotional Design.

In the left card, in 1995, Japanese researchers Masaaki Kurosu and Kaori Kashimura tested 26 variations of an ATM interface with identical functional logic. They discovered the **Aesthetic-Usability Effect**: users consistently perceived visually attractive layouts as easier to use, and were more patient when minor issues occurred. However, usability studies also show a hard boundary: while good aesthetics forgive minor friction, they never rescue a system that fails to complete the user's core task!

In the right card, Don Norman's book *Emotional Design* explains *why* this happens across three brain processing levels:
1. The **Visceral Level** is your immediate, pre-conscious reaction to visual appearance (`< 50ms`).
2. The **Behavioral Level** is the functional usability experienced during task execution.
3. The **Reflective Level** is your conscious post-use reflection, memory, and brand attachment.

To summarize this slide, remember this key takeaway: Visual aesthetics create positive visceral trust that cushions minor friction, while behavioral usability and reflective value sustain long-term adoption.
-->
---
### Concept Check Question 1 (CCQ 1)
<!-- id: ase-ch06-ccq1 -->
<div class="ccq-columns">
  <div class="ccq-text">

A hospital deploys a new Emergency Room Triage System. First-time nursing interns complete training in 10 minutes (**high novice learnability**), but veteran ER nurses require **14 mouse clicks across 5 modal dialogs** to register a single critical patient during mass-casualty surges. According to **Jakob Nielsen's 5 Quality Components of Usability**, which specific usability dimension is severely compromised?

- **A.** **Memorability**, because veteran nurses must re-learn the triage taxonomy after returning from annual leave.
- **B.** **Efficiency**, because expert users face excessive interaction steps when executing high-frequency tasks.
- **C.** **Learnability**, because first-time nursing interns cannot complete basic triage registration without manuals.
- **D.** **Visceral Aesthetics**, because the modal dialogs lack modern gradient styling and smooth micro-animations.

  </div>
  <div class="ccq-logo">
  </div>
</div>

<!--
Let's check our understanding of Section 6.1 with Concept Check Question 1 (CCQ 1)!

Read the scenario carefully: First-time nursing interns learn the new ER Triage System in just 10 minutes, so **Learnability** (Option C) is already high. And veteran ER nurses use the system every single day, so this is not an intermittent-use **Memorability** problem (Option A), nor is it a visual styling issue (Option D).

Instead, once nurses have already learned the system, requiring 14 mouse clicks across 5 modal dialogs for every single critical patient severely bottlenecks their task execution speed during high-volume surges. In Jakob Nielsen's 5 usability dimensions, the speed and effort required by experienced users to perform frequent tasks is **Efficiency**!

Therefore, the correct answer is B!

To summarize this slide, remember this key takeaway: Learnability measures initial onboarding ease for novices, whereas Efficiency measures task execution speed and minimal interaction cost for experienced users.
-->
---
<!-- _class: lead -->
<!-- header: '6.2 Cognitive Psychology & Mental Models' -->

# **6.2 Cognitive Psychology & Human Information Processing**

> "What information consumes is rather obvious: it consumes the attention of its recipients. Hence a wealth of information creates a poverty of attention."  
> — *Herbert A. Simon (Nobel Laureate & Turing Award Winner)*

<!--
Welcome to Section 6.2: Cognitive Psychology and Human Information Processing.

Every interactive software system involves two processors communicating across an interface: a silicon CPU/GPU executing code, and a biological human brain perceiving visuals, forming mental models, holding items in working memory, and executing motor actions.

While silicon processors double in speed over time, the human perceptual, cognitive, and motor architecture has remained fundamentally unchanged for tens of thousands of years. In this section, we study the cognitive laws that govern how humans perceive, think, remember, and act.

To summarize this slide, remember this key takeaway: Designing usable software requires engineering interfaces that respect the biological limits of human perception, attention, and working memory.
-->
---
## The Model Human Processor (MHP) & Perceptual Response Thresholds

> **Foundational HCI Model (Card, Moran & Newell, 1983):** Models the human user as three coupled subsystems—**Perceptual**, **Cognitive**, and **Motor**—each with measurable cycle times.

<div class="two-columns">
<div class="card" data-marpit-fragment>

### 1. The 3 Subsystems of MHP
- **Perceptual System (`τ_p ≈ 100 ms`)**:
  - Sensory buffers (Visual Iconic Store & Auditory Echoic Store) that capture raw stimuli from the screen.
  - Events occurring within **`< 100 ms`** fuse into a single instantaneous perception (perceived causality).
- **Cognitive System (`τ_c ≈ 70 ms`)**:
  - Compares perceived symbols in **Working Memory** against **Long-Term Memory** schemas to make decisions.
- **Motor System (`τ_m ≈ 70 ms`)**:
  - Translates cognitive intentions into physical muscle movements (finger tap, mouse drag, eye saccade).

</div>
<div class="card" data-marpit-fragment>

### 2. Jakob Nielsen's 3 Response-Time Thresholds
- **`0.1 Second (100 ms)` — Instantaneous Manipulation**:
  - The user feels they are **directly manipulating** the object (e.g., button press state, scrolling, cursor tracking).
- **`1.0 Second (1,000 ms)` — Uninterrupted Flow of Thought**:
  - The user notices a slight delay, but their **train of thought remains unbroken** without needing a progress bar.
- **`10 Seconds (10,000 ms)` — Maximum Attention Span**:
  - Beyond `10s`, working memory context breaks down; the UI **must** provide a **percent-done progress indicator**, time estimate, and a safe **Cancel / Background** option!

</div>
</div>

<!--
Let's examine the foundational quantitative model of Human-Computer Interaction: the **Model Human Processor (MHP)** introduced by Stuart Card, Thomas Moran, and Allen Newell in *The Psychology of Human-Computer Interaction* (1983).

Look at the left card: MHP models the human mind as three pipelined processors:
1. The **Perceptual Processor** (`~100 ms` cycle time) captures visual and auditory stimuli into short-lived sensory buffers.
2. The **Cognitive Processor** (`~70 ms` cycle time) matches sensory input in Working Memory against Long-Term Memory to decide what to do next.
3. The **Motor Processor** (`~70 ms` cycle time) dispatches physical commands to the hand, fingers, or eyes.
Notice that a simple human visual reaction (`Perceive + Cognize + Motor`) takes roughly `100 + 70 + 70 = 240 ms`!

Look at the right card: Directly derived from human perceptual and cognitive constants are **Jakob Nielsen's 3 Universal Response-Time Limits** (`0.1s`, `1.0s`, and `10s`):
Under `100 ms`, actions feel completely instantaneous. Under `1.0 second`, the user's train of thought stays intact. Beyond `10 seconds`, attention fractures unless you display a deterministic progress bar and allow background execution.

To summarize this slide, remember this key takeaway: Software latency requirements (`100ms`, `1s`, `10s`) are dictated not by arbitrary server SLAs, but by the biological cycle times of the human perceptual and cognitive processors.
-->
---
## Don Norman's 7 Stages of Action & The Two Gulfs

> **Core Interaction Cycle (Don Norman, *The Design of Everyday Things*):** Every human interaction bridges the gap between **Internal Psychological Goals** and **External Physical System State**.

<div class="two-columns">
<div class="card" data-marpit-fragment>

### 1. The 7 Stages of Action Cycle
- **Goal (1)**: Formulate the high-level objective (*"Order dinner for $15"*).
- **Execution Bridge (Stages 2 → 4)**:
  - **2. Plan**: Choose an action strategy.
  - **3. Specify**: Determine the exact sequence of UI inputs.
  - **4. Perform**: Execute physical clicks/taps on the world.
- **Evaluation Bridge (Stages 5 → 7)**:
  - **5. Perceive**: Sense what changed on the screen.
  - **6. Interpret**: Decode the meaning of that visual change.
  - **7. Compare**: Verify if the new system state matches the **Goal**.

</div>
<div class="card" data-marpit-fragment>

### 2. The Two Gulfs of Interaction Failure
- **The Gulf of Execution (*"How do I make it do what I want?"*)**:
  - The gap between the user's **intentions** and the **actions allowed** by the interface.
  - *Bridged by*: Clear **Signifiers**, **Affordances**, **Natural Mapping**, and **Constraints**.
- **The Gulf of Evaluation (*"What happened? Did it work?"*)**:
  - The effort required to perceive and interpret the **system's current state** after acting.
  - *Bridged by*: Immediate **Status Feedback (`< 100ms`)**, clear **Conceptual Models**, and informative state indicators.

</div>
</div>

<!--
Now let's examine one of the most important theoretical models in all of UX Engineering: **Don Norman's 7 Stages of Action** and the **Two Gulfs** (*The Design of Everyday Things*).

Look at the left card: Whenever a user interacts with your software, they traverse seven cognitive stages:
First, they form a **Goal** (Stage 1).
Next, they cross the **Execution Bridge**: they **Plan** a high-level approach (Stage 2), **Specify** the exact sequence of buttons to click (Stage 3), and physically **Perform** the action (Stage 4).
Then, after the system responds, they cross the **Evaluation Bridge**: they **Perceive** the screen update (Stage 5), **Interpret** what those pixels mean (Stage 6), and **Compare** the outcome against their original Goal (Stage 7).

Now look at the right card: Where do usability failures occur? In the **Two Gulfs**!
1. The **Gulf of Execution** occurs when a user knows *what* they want to achieve (e.g., split the restaurant bill with a friend), but cannot figure out *how* to execute it in your UI.
2. The **Gulf of Evaluation** occurs when a user clicks "Pay Now", the button neither spins nor changes state, and the user has no idea whether their credit card was charged or if the app froze!

To summarize this slide, remember this key takeaway: Great interaction design narrows the Gulf of Execution through clear signifiers and constraints, and narrows the Gulf of Evaluation through immediate, unambiguous feedback.
-->
---
## Affordances, Signifiers, Mappings & Feedback

> **Bridging the Gulfs:** Don Norman refined his framework to distinguish **Affordances** (what actions are possible) from **Signifiers** (the perceptible clues showing where and how to act).

| Core Design Concept | Formal Definition in HCI / UX | Software UI Engineering Application |
| :--- | :--- | :--- |
| **1. Affordance** | The relationship between a physical/digital object and a user that defines **what actions are possible**. | A scrollable viewport *affords* vertical panning; a text input box *affords* typing characters. |
| **2. Signifier** | Any **perceptible visual, auditory, or tactile clue** that communicates *where* and *how* an action should be taken. | An underlined blue label, a raised button shadow, a `[Search]` icon, or a visible scrollbar thumb. |
| **3. Natural Mapping** | The spatial or logical relationship between **controls and their effects** in the world. | Pressing the **Right Arrow `→`** advances to the next slide; dragging a slider up increases volume. |
| **4. Feedback** | Communicating the **results of an action** back to the user immediately and clearly. | Button ripple (`< 100ms`), toast confirmation (`"Added to Cart"`), or inline red validation text. |
| **5. Constraints** | Limiting possible actions (Physical, Cultural, Semantic, Logical) to **prevent invalid states**. | Disabling the `"Place Order"` button until a valid delivery address and payment method are selected. |

<!--
How do we concretely bridge the Gulf of Execution and the Gulf of Evaluation? Don Norman defines five fundamental design primitives shown in this table:

1. **Affordance**: An affordance is an objective relationship defining what actions are possible (for example, a touch screen *affords* tapping and swiping).
2. **Signifier**: Because digital screens are flat glass, users cannot see hidden affordances unless designers provide **Signifiers**—perceptible clues like button borders, cursor changes, icons, or placeholder prompts that signal *"Tap here!"* or *"Swipe left to delete!"* (Flat-design trends that strip away button borders destroy signifiers!)
3. **Natural Mapping**: Aligning the layout of controls with their real-world spatial or logical effects, reducing cognitive translation effort to zero.
4. **Feedback**: Immediately confirming that an input was received and showing its effect on system state.
5. **Constraints**: Proactively blocking illegal actions before an error can even occur.

To summarize this slide, remember this key takeaway: Affordances define possible actions, Signifiers make those actions discoverable, Mappings align controls with outcomes, and Feedback confirms state changes.
-->
---
<!-- _class: title-image-slide -->

## Case Study: Norman's Door & Natural Mapping in Controls

<div class="image-wrapper">
  <img src="../../img/ux/normans_door_nobg.png" alt="Norman's Door and Signifier Failure" />
</div>

<!--
Look at this famous everyday example that gave birth to the term **"Norman's Door"**:

When you walk up to a door that has identical grab-handles on both the push side and the pull side, what happens? The handle acts as a misleading **Signifier** that screams *"Pull me!"* even when the door hinges only allow pushing! To fix their design failure, building managers end up taping ugly paper signs reading `"PUSH"` onto the handle.

A well-engineered door requires zero instructions: the pull side has a vertical grab handle (signifying pulling), while the push side has a flat metal plate (affording only pushing and naturally signifying where to place your hand).

In software interfaces, whenever you have to write a multi-line instruction paragraph explaining *"Click the gray text above to save, do not click the green button below"*, you have built a digital Norman's Door!

To summarize this slide, remember this key takeaway: If a standard user interface control requires an instructional warning label to prevent misuse, its signifiers and mappings are fundamentally flawed.
-->
---
## Mental Models vs. Conceptual Models (The System Image)

> **Norman's Triad of Models:** Designers **never talk directly to users**; they communicate exclusively through the **System Image** (the UI, feedback, behavior, and documentation).

<div class="two-columns">
<div class="card" data-marpit-fragment>

### 1. The Three Models in Software Systems
- **1. The Designer's Conceptual Model**:
  - How the software architect and developer conceive the system (e.g., Git commits as a Directed Acyclic Graph of SHA-1 blobs and trees; file deletion as unlinking an inode pointer).
- **2. The User's Mental Model**:
  - The internal belief system formed in the user's mind based on prior real-world experience (e.g., folders on a desktop, a shopping cart, a trash can).
- **3. The System Image (The Bridge)**:
  - Everything the user actually interacts with: UI layout, metaphors, labels, feedback, and error messages.

</div>
<div class="card" data-marpit-fragment>

### 2. Engineering Consequences of Model Mismatch
- **[Anti-Pattern] Implementation Model Leak**:
  - Exposing database foreign-key stack traces (`ORA-02292: integrity constraint violated`) or internal microservices jargon directly to end users.
- **[Case Study] Cloud Sync vs. Local Save**:
  - If a web editor auto-saves to the cloud every keystroke, but displays a prominent `"Save"` icon thatActually downloads a `.json` backup, users with a traditional desktop Mental Model will repeatedly click `"Save"` and clutter their disk!
- **Design Rule**: Align the **System Image** with the **User's Mental Model**, hiding internal implementation mechanics.

</div>
</div>

<!--
Why do software engineers so often build interfaces that make complete sense to the development team, yet baffle real users? Don Norman's **Triad of Mental Models** explains this phenomenon clearly.

Look at the left card:
1. The **Designer's Model (or Implementation Model)** is how the engineer understands the code—relational tables, JSON payloads, state machines, and asynchronous queues.
2. The **User's Mental Model** is the internal working model inside the user's head, shaped by everyday life and other apps they use.
3. Crucially, once the software ships, the engineer is not standing behind the user's chair explaining how it works! The Designer communicates with the User *exclusively* through the **System Image** (the visible UI, metaphors, and runtime behavior).

Look at the right card: When a developer lets the backend **Implementation Model** leak directly into the **System Image**—for instance, asking a hungry food delivery customer *"Select Partition Shard & Idempotency Mode"* or throwing a raw SQL foreign-key exception—a catastrophic mismatch occurs between the System Image and the User's Mental Model!

To summarize this slide, remember this key takeaway: Engineers must design the System Image to match the User's Mental Model rather than exposing the backend Implementation Model.
-->
---
## Working Memory, Attention & Cognitive Load Theory

> **Sweller's Cognitive Load Theory (1988):** Human **Working Memory** has severely limited capacity (`4 ± 1` active chunks, decaying within `~20 seconds`); exceeding it triggers cognitive overload and task abandonment.

<div class="two-columns">
<div class="card" data-marpit-fragment>

### 1. The 3 Types of Cognitive Load (John Sweller)
- **Intrinsic Cognitive Load (Task Inherent)**:
  - The unavoidable mental effort required by the domain task itself (e.g., filing corporate taxes vs. ordering a coffee).
  - *Managed by*: Breaking complex workflows into **progressive step-by-step wizards**.
- **Extraneous Cognitive Load (Bad UI Overhead)**:
  - Wasted mental effort caused by **poor interface design**—visual clutter, inconsistent navigation, cryptic jargon, or forcing users to memorize codes across screens.
  - *Engineering Goal*: **Eliminate Extraneous Load to near zero!**
- **Germane Cognitive Load (Schema Building)**:
  - Productive mental effort invested in learning reusable patterns and mastering the system's conceptual model.

</div>
<div class="card" data-marpit-fragment>

### 2. Memory & Attention Constraints in UI Design
- **Working Memory Capacity (Miller `7 ± 2` → Cowan `4 ± 1`)**:
  - Modern cognitive research (Nelson Cowan, 2001) shows humans actively hold only **3 to 5 chunks** in working memory while multitasking.
- **Recognition Over Recall**:
  - Showing recent addresses, visual menu thumbnails, and search autocomplete (`Recognition`) requires far less cognitive load than typing from memory (`Recall`).
- **Inattentional & Change Blindness**:
  - Users tunnel-focus on their goal; subtle status changes placed outside their **foveal fixation zone** (`~2°` visual angle) go completely unnoticed!

</div>
</div>

<!--
Let's examine the biological bottleneck at the heart of the Cognitive Processor: **Working Memory** and **John Sweller's Cognitive Load Theory (1988)**.

In the left card, Sweller classifies mental effort into three distinct types:
1. **Intrinsic Load** is the inherent complexity of the problem itself (configuring an AWS VPC firewall is intrinsically more complex than ordering a pizza).
2. **Extraneous Load** is unnecessary cognitive friction imposed by clumsy UI design—such as forcing a user to read a 6-digit promo code on Banner Screen A, memorize it in their head, navigate three menus deep to Checkout Screen B, and type it in from memory!
3. **Germane Load** is healthy mental effort spent forming long-term mental schemas.
As UX engineers, our primary mission is to **ruthlessly eliminate Extraneous Cognitive Load** so all of the user's limited working memory remains available for their actual task!

In the right card, note two critical perceptual limits: First, while George Miller's 1956 paper cited `7 ± 2` items, Nelson Cowan's modern research shows active working memory during complex tasks holds only **`4 ± 1` chunks**. Second, due to **Change Blindness** and **Foveal Tunnel Vision**, if a user clicks a button at the bottom-right of a desktop screen and you display a tiny error message at the top-left corner, the user will never see it!

To summarize this slide, remember this key takeaway: Effective UI design minimizes extraneous cognitive load, relies on visual recognition over memory recall, and places feedback near the user's locus of attention.
-->
---
### Concept Check Question 2 (CCQ 2)
<!-- id: ase-ch06-ccq2 -->
<div class="ccq-columns">
  <div class="ccq-text">

In a cloud deployment dashboard, an engineer clicks the **"Deploy to Production"** button. Because the frontend lacks a loading spinner, toast message, or state change for 8 seconds, the engineer assumes the click failed and clicks the button three more times, triggering conflicting deployments. In **Don Norman's Action Cycle**, which specific breakdown caused this error?

- **A.** A wide **Gulf of Execution**, because the engineer could not locate the deployment button on the screen.
- **B.** Excess **Intrinsic Cognitive Load**, because cloud deployment inherently requires memorizing Linux kernel flags.
- **C.** A wide **Gulf of Evaluation**, because the interface failed to provide immediate feedback on the system's new state.
- **D.** A **Natural Mapping** violation, because the deployment button was positioned on the right side of the toolbar.

  </div>
  <div class="ccq-logo">
  </div>
</div>

<!--
Let's check our understanding of Section 6.2 with Concept Check Question 2 (CCQ 2)!

In this scenario, the engineer easily found and clicked the "Deploy to Production" button—so they crossed the Execution bridge without difficulty (eliminating Option A). Nor is this about Linux kernel flags (Option B) or toolbar spatial mapping (Option D).

Instead, *after* the engineer performed the action, the interface gave zero visual feedback for 8 seconds (violating the `100ms` tactile feedback threshold and `1.0s` flow threshold). Because the user could not perceive or interpret whether the system state had changed, they fell into a wide **Gulf of Evaluation** (*"What happened? Did my click register?"*) and repeatedly clicked the button!

Therefore, the correct answer is C!

To summarize this slide, remember this key takeaway: Failing to display immediate state feedback after a user action creates a wide Gulf of Evaluation, directly provoking duplicate submissions and user errors.
-->
---
<!-- _class: lead -->
<!-- header: '6.3 Quantitative Laws & Visual Perception' -->

# **6.3 Quantitative Laws of Interaction & Visual Perception**

> "Design is a science as much as an art: human motor movement, choice reaction time, and visual grouping obey mathematical laws."

<!--
Welcome to Section 6.3: Quantitative Laws of Interaction and Visual Perception.

Many computer science students are surprised to discover that Human-Computer Interaction has mathematical equations that accurately predict how many milliseconds a user needs to point to a button (`Fitts's Law`) or choose from a menu (`Hick-Hyman Law`).

In this section, we master the core quantitative and behavioral laws of interaction design, examine how Gestalt psychology governs visual layout without clutter, and establish concrete engineering standards for WCAG Web Accessibility.

To summarize this slide, remember this key takeaway: Quantitative HCI laws and perceptual principles allow software engineers to optimize pointing speed, decision latency, visual hierarchy, and accessibility mathematically.
-->
---
## Mathematical Laws of Pointing & Choice: Fitts's Law & Hick's Law

> **Predictive HCI Modeling:** Human motor targeting and decision-making speed follow **logarithmic information-theoretic equations** (bits per second).

<div class="two-columns">
<div class="card" data-marpit-fragment>

### 1. Fitts's Law (1954 — Motor Targeting Speed)
- **Shannon Formulation (MacKenzie, 1992)**:
  - `MT = a + b · log`<sub>`2`</sub>`(D / W + 1)`
  - `MT`: Movement Time; `D`: Distance to target; `W`: Width (size) of target along the axis of motion.
  - `log`<sub>`2`</sub>`(D / W + 1)`: **Index of Difficulty (`ID`, in bits)**.
- **4 Core UI Engineering Applications**:
  1. **Enlarge Primary Targets (`↑ W`)**: Make frequent CTAs at least `44×44 px` (Apple iOS) / `48×48 dp` (Android).
  2. **Minimize Travel Distance (`↓ D`)**: Context menus (`right-click`) pop up at `D ≈ 0` right under the cursor!
  3. **Infinite Screen Edges ("Magic Corners")**: macOS top menu bar & Windows bottom-left Start corner have **`W = ∞`** because the cursor is stopped by the screen bezel.
  4. **Separate Destructive Actions**: Never place `"Delete Account"` `2px` next to `"Save"`!

</div>
<div class="card" data-marpit-fragment>

### 2. Hick-Hyman Law (1952 — Choice Reaction Time)
- **Mathematical Formulation**:
  - `RT = a + b · log`<sub>`2`</sub>`(n + 1)` (for `n` equally probable choices)
  - `RT = a + b · Σ p`<sub>`i`</sub>` log`<sub>`2`</sub>`(1 / p`<sub>`i`</sub>` + 1)` (general entropy form)
- **Core UI Engineering Applications**:
  1. **Progressive Disclosure**: Do not dump 40 settings onto one screen; display the **3–5 primary options** and tuck advanced settings behind `"Advanced..."`.
  2. **Categorized & Scannable Grouping**: Group long lists into clear semantic categories so users scan `k` headers instead of reading `n` unsorted items.
  3. **Smart Defaults & Highlighted Recommendations**: Highlighting a `[Recommended]` plan reduces choice entropy (`H`), slashing decision paralysis!

</div>
</div>

<!--
Let's examine the two most famous mathematical equations in Human-Computer Interaction: **Fitts's Law** (Paul Fitts, 1954; refined by Scott MacKenzie, 1992) on the left, and the **Hick-Hyman Law** (William Hick & Ray Hyman, 1952) on the right.

Look at the left card: **Fitts's Law** states that the time `MT` required to move a pointer (or finger) to a target is a logarithmic function of the ratio between the distance to the target (`D`) and the target's width (`W`):
`MT = a + b * log2(D/W + 1)`.
What does this formula tell us as UI engineers?
1. Make frequent primary buttons large (`↑ W`, minimum `44×44 px` on touchscreens) and place them close to the user's natural thumb zone or current cursor (`↓ D`).
2. Why does a right-click pop-up context menu feel so fast? Because it appears right under your cursor (`D = 0`)!
3. Why is the macOS menu bar pinned to the top pixel edge of the screen? Because you can fling your mouse upward at full speed—the screen border stops the cursor, giving the menu bar **infinite effective target width (`W = ∞`)**!
4. Conversely, we can use Fitts's Law in reverse to prevent accidents: make destructive buttons (`"Format Disk"`) smaller and further away from common actions.

Look at the right card: **Hick's Law** models cognitive choice reaction time `RT = a + b * log2(n + 1)`. As the number of choices `n` increases, decision latency grows logarithmically (and linearly if the list is unsorted!). We solve this via **Progressive Disclosure**—showing only core choices upfront and revealing secondary details on demand.

To summarize this slide, remember this key takeaway: Fitts's Law optimizes physical target acquisition (`D` and `W`), while Hick's Law minimizes cognitive decision latency (`n`) through progressive disclosure.
-->
---
## Behavioral & Workflow Laws: Jakob's, Tesler's, Postel's & Doherty

> **Systems Laws of UX:** Great interaction design leverages **existing user habits**, absorbs **accidental complexity** into code, and accepts **flexible human input**.

<div class="two-columns">
<div class="card" data-marpit-fragment>

### 1. Jakob's Law & The Doherty Threshold
- **Jakob's Law of Internet User Experience (Jakob Nielsen)**:
  - *"Users spend most of their time on **other sites**. This means that users prefer your site to work the same way as all the other sites they already know."*
  - **Design Rule**: Follow established platform conventions (top-right shopping cart `[Cart]`, top-left logo home link, standard `Ctrl+Z` undo) so users spend **0% cognitive load** learning navigation!
- **The Doherty Threshold (`< 400 ms`, Walter Doherty, 1982)**:
  - Productivity soars when computer and human interact at a pace **`< 400 ms`**, ensuring neither waits on the other.
  - *Technique*: Use **Optimistic UI Updates** & **Skeleton Screens** to keep perceived response under `400 ms`.

</div>
<div class="card" data-marpit-fragment>

### 2. Tesler's Law & Postel's Law in UI Engineering
- **Tesler's Law (Law of Conservation of Complexity)**:
  - Every application has an inherent amount of irreducible complexity. The only question is: **Who bears it—the User or the Software Engineer?**
  - *Example*: Instead of forcing users to type City, State, and County manually, the engineer spends 20 lines of code auto-filling them from a 5-digit **Postal/ZIP Code**!
- **Postel's Law (The Robustness Principle)**:
  - *"Be conservative in what you send, be liberal in what you accept."*
  - *Example*: Accept credit card or phone numbers whether the user types `0912-345-678`, `(0912) 345 678`, or `0912345678`—strip formatting characters in code instead of throwing a red syntax error!

</div>
</div>

<!--
Beyond Fitts's and Hick's laws, four system-level laws govern everyday software UX engineering:

Look at the left card:
1. **Jakob's Law**: Users spend 99% of their digital lives on *other* apps and websites. When a designer reinvents standard controls—putting the shopping cart at the bottom-left or changing a checkbox into a triangle—users get disoriented. Innovate on your core product value, not on basic navigation conventions!
2. **The Doherty Threshold (`< 400 ms`)**: Discovered by IBM researcher Walter Doherty in 1982, when system response drops below 400 milliseconds, human engagement and productivity jump dramatically because the user stays in a continuous flow state. Modern apps achieve this using **Skeleton Screens** and **Optimistic UI** (immediately showing a "Liked" heart before the HTTP POST finishes).

Look at the right card:
3. **Larry Tesler's Law (Conservation of Complexity)**: Complexity cannot be destroyed, only shifted. If an engineer takes an extra hour to write an address auto-complete or smart default, they shift complexity *away* from millions of users and onto the software!
4. **Jon Postel's Law (Robustness Principle)**: Never scold a user with `"Error: Do not include dashes in phone number!"` Accept flexible human input formats liberally and normalize them silently in your frontend parser.

To summarize this slide, remember this key takeaway: Follow Jakob's Law for familiar conventions, honor the 400ms Doherty Threshold, and apply Tesler's and Postel's laws to shift formatting work from the user to the code.
-->
---
## Gestalt Principles of Visual Perception in UI Layout

> **Gestalt Psychology (*"The whole is other than the sum of its parts"*):** The human visual cortex automatically groups screen elements into coherent structures based on **6 perceptual laws**.

| Gestalt Principle | Perceptual Mechanism | UI / Frontend Engineering Application |
| :--- | :--- | :--- |
| **1. Proximity** | Elements placed **closer together** are perceived as belonging to the same functional group. | Keep a form **Label `4px`** above its **Input Box**, but leave **`20px` margin** before the next field—zero border lines needed! |
| **2. Similarity** | Elements sharing visual attributes (**color, shape, size, font**) are perceived as having similar behavior. | Style all primary actions in solid brand blue (`#2563eb`) and all secondary actions in subtle outline gray. |
| **3. Common Region (Enclosure)** | Elements enclosed within a **visible boundary or shaded card** are perceived as a unified unit. | Group an order card's restaurant title, item list, and `"Track Order"` button inside a subtle `.card` container. |
| **4. Continuity** | The human eye naturally follows **smooth, aligned lines and curves** rather than abrupt jagged jumps. | Align form labels and inputs along a **single clean vertical left axis** to accelerate visual scanning. |
| **5. Closure** | The brain automatically fills in missing gaps to perceive **complete, familiar shapes**. | Partially clipping the 4th card at the right edge of a horizontal carousel naturally signals *"Scroll right for more!"* |
| **6. Figure-Ground** | The visual system instantly separates the **foreground focal object (Figure)** from the **background (Ground)**. | Dimming the background (`rgba(0,0,0,0.5)` backdrop blur) behind a **Modal Dialog** focuses 100% attention on the modal. |

<!--
How does a user look at a screen of 50 rectangles and text strings and instantly understand which label belongs to which input box? The answer lies in **Gestalt Psychology**, founded by Max Wertheimer, Kurt Koffka, and Wolfgang Köhler in the early 20th century.

Review the six core Gestalt principles in this table and how they guide CSS layout engineering:
1. **Proximity**: The single most powerful layout tool! If the vertical gap between `Label A` and `Input A` is equal to the gap between `Input A` and `Label B` (`12px` everywhere), users constantly type into the wrong box. By setting `margin-bottom: 4px` on labels and `margin-bottom: 20px` between form groups, **Proximity** groups them effortlessly without drawing ugly boxes!
2. **Similarity**: Things that look alike should act alike. Never use your clickable link color (`#2563eb` blue underline) for non-clickable static headings!
3. **Common Region (Enclosure)**: Using subtle background shading or cards to group related controls.
4. **Continuity**: Maintaining crisp grid alignment so the eye glides down a single column.
5. **Closure**: Showing `3.5` cards in a horizontal row so the cut-off 4th card visually signifies horizontal scrolling.
6. **Figure-Ground**: Using elevation shadows and modal backdrops to separate active foreground dialogs from background content.

To summarize this slide, remember this key takeaway: Gestalt principles allow engineers to communicate structure and hierarchy through whitespace, alignment, and similarity rather than heavy visual clutter.
-->
---
## Visual Hierarchy, Typography, Contrast & Accessibility (WCAG 2.2)

> **Inclusive Engineering Mandate:** Accessibility (**a11y**) is not an optional edge case—roughly **15% of the global population** lives with visual, motor, auditory, or cognitive disabilities ( plus situational impairments like bright sunlight!).

<div class="two-columns">
<div class="card" data-marpit-fragment>

### 1. Visual Hierarchy & Scanning Patterns
- **F-Pattern & Z-Pattern Eye Tracking (NN/g)**:
  - Users **do not read** interfaces word-for-word; they **scan** in an **F-shaped pattern** (text-heavy lists) or **Z-shaped pattern** (landing pages).
- **3 Pillars of Scannable Typography**:
  - **Size & Weight Scale**: Clear ratio between `H1` (`28–32px`), `H2` (`20–24px`), Body (`16px`), and Caption (`13–14px`).
  - **Line Length (Measure)**: Keep body text paragraphs between **50 and 75 characters per line** (`max-width: 65ch`).
  - **Whitespace (Negative Space)**: Active breathing room that prevents visual crowding and isolates focal points.

</div>
<div class="card" data-marpit-fragment>

### 2. W3C WCAG 2.1 / 2.2 Accessibility (POUR)
- **The 4 POUR Principles**: **P**erceivable, **O**perable, **U**nderstandable, **R**obust.
- **Concrete Frontend Engineering Requirements**:
  1. **Color Contrast (Level AA)**: Minimum **`4.5 : 1`** luminance contrast ratio for normal text (`3.0 : 1` for large text `>= 18pt` or UI icons).
  2. **Never Rely on Color Alone**: ~8% of males have red-green color deficiency (Deuteranopia/Protanopia). Pair red error borders with **an icon (`[!]`) + text message**!
  3. **Keyboard & Screen Reader Support**: Full `Tab` focus ring order, semantic HTML (`<button>`, `<nav>`, `<main>`), and `aria-label` attributes.

</div>
</div>

<!--
Let's examine how Visual Hierarchy and Web Content Accessibility Guidelines (**WCAG 2.1 / 2.2**) translate into concrete frontend engineering standards.

In the left card, Nielsen Norman Group's eye-tracking studies prove a humbling truth: **Users don't read web pages; they scan them!**
To support scanning:
1. Establish an unmistakable typographic scale (`H1 > H2 > Body > Caption`).
2. Constrain paragraph line widths to `50–75 characters` (`65ch`)—lines spanning `180 characters` across a 27-inch monitor cause the eye to lose its place when jumping to the next line.

In the right card, let's review **WCAG Accessibility (a11y)** structured around the **POUR** acronym (Perceivable, Operable, Understandable, Robust):
1. **Contrast Ratio**: Light-gray text (`#999999`) on a white background (`#ffffff`) has a contrast ratio of only `2.8:1`—it becomes unreadable for aging eyes or a courier riding under midday sun! WCAG Level AA requires at least **`4.5:1`** for normal text.
2. **Color-Blindness Safety**: Never indicate status by red vs. green color alone; always combine color with distinct shapes/icons and text labels.
3. **Semantic HTML & Keyboard Operability**: Use real `<button>` elements (not `<div onclick>`) so keyboard `Tab`/`Enter` and screen readers work out of the box.

To summarize this slide, remember this key takeaway: Accessible visual design combines scannable typographic hierarchy with WCAG 4.5:1 contrast, color-independent indicators, and semantic HTML.
-->
---
### Peer Discussion 6.3: Diagnosing a High-Friction Checkout Screen

<div class="discussion-columns">
  <div class="discussion-text">

  **UX Engineering Audit: Refactoring the Food Delivery Checkout UI (4 Mins)**
  - **Scenario:** A junior developer built the checkout screen for our **Food Delivery App**, and cart abandonment jumped to **62%**. An inspection reveals four design flaws:
    1. The **"Place Order"** button is a tiny `24×18 px` text link at the top-left corner of the mobile screen, right next to **"Empty Entire Cart"** (`2px` gap).
    2. The payment selector displays all **28 supported banks and wallets** in a single unsorted radio-button list.
    3. The phone number field rejects `0912-345-678` with a red popup: *"Error: Numeric digits only! Re-enter all 8 address fields."*
    4. Required fields are marked *only* by changing their border color from green to red (`#ef4444` on `#e5e7eb` gray background, contrast `2.1:1`).
  - **Discussion Tasks:**
    - **Q1.** Identify which specific **Law of UX or Accessibility Standard** (Fitts's, Hick's, Tesler's/Postel's, WCAG) is violated by each of the 4 flaws (`#1` to `#4`).
    - **Q2.** Propose the concrete **UI refactoring fix** for each flaw!

  </div>
  <div class="discussion-logo">
    <img src="../../img/discussion_icon.svg" alt="Discussion Icon" />
  </div>
</div>

<!--
Let's take 4 minutes for Peer Discussion 6.3!

Work with your neighbor to audit this high-friction Food Delivery checkout screen where 62% of users abandon their cart.
Look at the four flaws (`#1` through `#4`):
In Flaw #1, look at the size (`24x18 px`), placement (top-left of a mobile screen, far from the thumb), and proximity (`2px` from "Empty Entire Cart"). Which mathematical law is violated here?
In Flaw #2, dumping 28 unsorted banks and wallets into a single flat radio list violates which decision-time law?
In Flaw #3, rejecting hyphens in a phone number and wiping out all 8 address fields violates which robustness and complexity laws?
And in Flaw #4, relying solely on red vs. green borders with a `2.1:1` contrast ratio violates which WCAG accessibility rules?

Discuss with your partner both the theoretical law violated and your concrete engineering refactoring for each item. (Full reference solutions are provided in Appendix B at the end of the slide deck!)

To summarize this slide, remember this key takeaway: Auditing interfaces against Fitts's Law, Hick's Law, Postel's Law, and WCAG standards turns subjective UI critique into systematic engineering diagnosis.
-->
---
### Concept Check Question 3 (CCQ 3)
<!-- id: ase-ch06-ccq3 -->
<div class="ccq-columns">
  <div class="ccq-text">

According to the Shannon formulation of **Fitts's Law** (`MT = a + b · log`<sub>`2`</sub>`(D / W + 1)`), why do desktop operating systems place critical global menus (such as the macOS Menu Bar or the Windows Start button) flush against the **extreme edges or corners of the screen**?

- **A.** Screen edges reduce the number of menu items `n`, lowering cognitive choice reaction time under Hick's Law.
- **B.** The monitor bezel blocks the cursor from overshooting, giving edge targets an effectively infinite width `W`.
- **C.** Placing menus at the screen edge increases luminance contrast ratios to satisfy WCAG 2.2 Level AAA standards.
- **D.** Peripheral vision processes corner pixels in `< 20ms`, bypassing the Model Human Processor's motor stage.

  </div>
  <div class="ccq-logo">
  </div>
</div>

<!--
Let's check our mastery of Section 6.3 with Concept Check Question 3 (CCQ 3)!

The question asks: According to Fitts's Law (`MT = a + b * log2(D/W + 1)`), why are the macOS Menu Bar and Windows Start button pinned flush against the extreme edges or corners of the display?

Let's evaluate the four options:
Option A confuses Fitts's Law (motor pointing) with Hick's Law (number of choices `n`).
Option B is exact: when a button sits in the middle of the screen, the user must decelerate their hand carefully so the cursor does not overshoot the button's width `W`. When a target sits flush against the edge or corner of the screen, the physical screen boundary stops the cursor automatically—giving the target an **effectively infinite width (`W = ∞`)** along the movement axis and slashing the Index of Difficulty!
Options C and D are fabricated claims about contrast and peripheral vision.

Therefore, the correct answer is B!

To summarize this slide, remember this key takeaway: Under Fitts's Law, pinning controls flush against screen edges or corners prevents cursor overshoot and grants effectively infinite target depth.
-->
---
<!-- _class: lead -->
<!-- header: '6.4 HCD Process & User Research' -->

# **6.4 The Human-Centered Design (HCD) Process & User Research**

> "You are not the user! Every assumption you make about how people will use your software is a hypothesis waiting to be tested."  
> — *Jakob Nielsen & Don Norman*

<!--
Welcome to Section 6.4: The Human-Centered Design (HCD) Process and Empirical User Research.

Perhaps the single greatest trap in software engineering is the **False-Consensus Effect**: engineers naturally assume that because *they* understand recursive folder trees, regular expressions, or modal state transitions, everyday users think the exact same way.

Hence the First Golden Rule of UX Engineering: **"You Are Not the User!"**
In this section, we study the ISO 9241-210 Human-Centered Design lifecycle, the UK Design Council's Double Diamond model, empirical user research methods, Personas, Jobs-to-be-Done (JTBD), and Customer Journey Mapping.

To summarize this slide, remember this key takeaway: Human-Centered Design replaces developer assumptions with empirical user research across iterative divergent and convergent phases.
-->
---
## The Double Diamond Model & ISO 9241-210 Iterative Lifecycle

> **Design Before Solutioning:** Engineers must first **design the right thing** (Problem Space) before **designing the thing right** (Solution Space).

<div class="two-columns">
<div class="card" data-marpit-fragment>

### 1. The Double Diamond (4 Phases: Diverge ↔ Converge)
- **Diamond 1 — Understanding the Problem Space**:
  1. **Discover (Diverge `<`)**: Conduct field observations, contextual inquiry, and user interviews to uncover real pain points.
  2. **Define (Converge `>`)**: Synthesize findings into Personas, Journey Maps, and a focused **Problem Statement (HMW — How Might We)**.
- **Diamond 2 — Engineering the Solution Space**:
  3. **Develop (Diverge `<`)**: Brainstorm alternative IA flows, sketch low-fidelity wireframes, and explore interactive prototypes.
  4. **Deliver (Converge `>`)**: Run usability tests, refine high-fidelity designs, validate metrics, and hand off to agile sprints.

</div>
<div class="card" data-marpit-fragment>

### 2. ISO 9241-210 Core Principles of HCD
- **1. Explicit Understanding of Users, Tasks & Environments**:
  - Grounded in empirical observation, not stakeholder guesswork.
- **2. Users Involved Throughout Design & Development**:
  - Continuous feedback from early paper sketches to beta releases.
- **3. Driven & Refined by User-Centered Evaluation**:
  - Prototypes are tested early and often to catch mental-model flaws.
- **4. Iterative Process**:
  - Every evaluation round feeds insights back into requirements and design until usability benchmarks are met.

</div>
</div>

<!--
How does UX Engineering fit into the broader Software Development Lifecycle (SDLC)? Let's examine the **UK Design Council's Double Diamond Model (2005)** on the left and the **ISO 9241-210 Human-Centered Design Standard** on the right.

Look at the left card: Why is it called the **Double Diamond**?
Because great design alternates between **Divergent Thinking** (expanding to explore possibilities) and **Convergent Thinking** (narrowing down to focused decisions) across two distinct diamonds:
- **Diamond 1 (Problem Space — "Build the Right Thing")**: First we **Discover** (diverge via field user research), then we **Define** (converge on the core user personas and problem statement).
- **Diamond 2 (Solution Space — "Build the Thing Right")**: Next we **Develop** (diverge by sketching multiple alternative UI prototypes), and finally we **Deliver** (converge through usability testing and engineering delivery).

Most failed software projects skip Diamond 1 entirely—jumping straight into coding a solution for a problem users don't actually have!

To summarize this slide, remember this key takeaway: The Double Diamond enforces exploring and defining the Problem Space before diverging and converging in the Solution Space.
-->
---
<!-- _class: title-image-slide -->

## Visual Overview: The Iterative UX Engineering Lifecycle

<div class="image-wrapper">
  <img src="../../img/ux/ux_core_process_nobg.png" alt="The Core Iterative UX Engineering Process" />
</div>

<!--
Examine this visual diagram of the Core Iterative UX Engineering Process:

Notice how the workflow forms a continuous empirical loop:
1. **Understand & Empathize (Research)**: Observing real users in their physical and social context to uncover their goals, constraints, and bottlenecks.
2. **Define & Structure**: Translating messy qualitative observations into structured Personas, Empathy Maps, Information Architecture, and Task Flows.
3. **Ideate & Prototype**: Rapidly externalizing ideas from low-cost paper sketches and grayscale wireframes up to interactive clickable prototypes.
4. **Evaluate & Test**: Running analytical Heuristic Evaluations and empirical Usability Tests with real users, feeding quantitative and qualitative findings back to refine the design before expensive production coding!

To summarize this slide, remember this key takeaway: The UX engineering process is an iterative feedback loop connecting user research, problem definition, rapid prototyping, and empirical evaluation.
-->
---
## Empirical User Research: The 2×2 Landscape (NN/g)

> **Triangulation Principle:** What users **say they do** in interviews often differs from what they **actually do** in the wild! Combine **Attitudinal** and **Behavioral** methods.

| Research Dimension | Qualitative (*"Why & How to Fix"*)<br>Small Sample (`N = 5–12`), Deep Insights | Quantitative (*"How Many & How Much"*)<br>Large Sample (`N = 100–10,000+`), Statistical |
| :--- | :--- | :--- |
| **Behavioral**<br>*(What Users Actually Do)* | **• Contextual Inquiry (Field Observation)**<br>**• Moderated Usability Testing (Think-Aloud)**<br>*Insight*: Uncovers workarounds, environmental distractions, and mental-model breakdowns. | **• Product Telemetry & Clickstream Funnel Analytics**<br>**• Controlled A/B Testing & Eye-Tracking Heatmaps**<br>*Insight*: Pinpoints exact drop-off rates (`62% at step 3`) and task completion times at scale. |
| **Attitudinal**<br>*(What Users Say & Feel)* | **• Semi-Structured User Interviews**<br>**• Diary Studies & Focus Groups**<br>*Insight*: Reveals underlying motivations, domain goals, anxieties, and unmet emotional needs. | **• Standardized Questionnaires (SUS, SUPR-Q, NPS)**<br>**• Large-Scale Intercept Surveys & Kano Surveys**<br>*Insight*: Benchmarks subjective satisfaction and feature priority across customer segments. |

<!--
How do UX researchers select the right empirical method for a given stage of the project? Christian Rohrer at the Nielsen Norman Group classifies all user research methods across a **2×2 Matrix** shown in this table:

Along the vertical axis, we distinguish **Behavioral** methods (*observing what people actually do*) from **Attitudinal** methods (*listening to what people say they think or feel*). Why is this distinction so vital? Because human beings are notoriously bad at predicting their own future behavior or recalling microscopic UI habits! In an interview, a courier might say, *"I always verify the customer's apartment number before riding,"* yet in a **Contextual Inquiry** (riding along in the rain), you observe that glare on the phone screen forces them to guess!

Along the horizontal axis, we distinguish **Qualitative** methods (`N = 5–12` participants, answering **Why** a problem happens and **How** to fix it) from **Quantitative** methods (`N = 100+` participants, answering **How much** or **How many** with statistical rigor).
Best engineering practice **triangulates** both: Analytics tells you *where* the funnel is leaking (`62% drop-off at checkout`), while Qualitative Observation tells you *why* (`users can't find the promo code button`)!

To summarize this slide, remember this key takeaway: Quantitative analytics reveal *what* is happening at scale, while qualitative behavioral observation reveals *why* it happens and how to fix it.
-->
---
## Synthesizing Research: Affinity Diagrams, Personas & JTBD

> **Data-Driven Synthesis:** Raw interview transcripts must be distilled into actionable engineering models—**Personas** (*Who*) and **Jobs-to-be-Done** (*Why*).

<div class="two-columns">
<div class="card" data-marpit-fragment>

### 1. Affinity Diagramming & Evidence-Based Personas
- **Affinity Diagramming (KJ Method)**:
  - Clustering hundreds of field observation notes bottom-up into thematic insight groups (`Pain Points`, `Workarounds`, `Trust Barriers`).
- **Alan Cooper's Goal-Directed Personas (*The Inmates Are Running the Asylum*)**:
  - An archetype representing a distinct **behavioral pattern cluster** derived from real user research (never made-up marketing stereotypes!).
  - **Core Anatomy of an Engineering Persona**:
    1. **Context & Tech Proficiency** (e.g., *"Rider Wei, operates one-handed on a scooter in rain"*).
    2. **End Goals & Motivations** (maximize deliveries/hour safely).
    3. **Pain Points & Frustrations** (small tap targets, GPS drift).

</div>
<div class="card" data-marpit-fragment>

### 2. Jobs-to-be-Done (JTBD — Clayton Christensen)
- **Focus on the "Job", Not Demographic Labels**:
  - People don't buy products because of their age bracket; they *"hire"* a product to get a specific **Job** done in a specific situation.
- **Standard JTBD Statement Template**:
  - **When** `[Situation / Context]`,
  - **I want to** `[Motivation / Action]`,
  - **So I can** `[Expected Outcome / Value]`.
- **Food Delivery JTBD Example**:
  - *"When I am working overtime with 4 colleagues at 8 PM (**Situation**), I want to share a single group cart link where everyone picks their own meal in 3 minutes (**Action**), so I can order dinner without collecting cash or passing my phone around (**Outcome**)."*

</div>
</div>

<!--
Once we return from field observations and user interviews with hundreds of notes, how do we synthesize that qualitative data so software engineers can act on it?

Look at the left card: First, teams use **Affinity Diagramming** (the KJ Method invented by Jiro Kawakita) to cluster individual observations into recurring behavioral patterns.
From those clusters, we construct **Goal-Directed Personas**, pioneered by Alan Cooper in his classic book *The Inmates Are Running the Asylum*.
Warning: A real engineering Persona is **never** a fictional demographic wishlist (*"32-year-old Aries who likes yoga"*). It is an empirical behavioral archetype capturing **Context of Use** (riding a scooter with wet gloves), **Core Goals**, and **Current Pain Points**. Designing for 1 to 3 specific Personas prevents "elastic user" syndrome where developers twist the definition of the user to justify whatever code is easiest to write!

Look at the right card: Complementing Personas is **Jobs-to-be-Done (JTBD)** (`When [Situation], I want to [Action], so I can [Outcome]`), which links directly to Agile User Stories!

To summarize this slide, remember this key takeaway: Evidence-based Personas model *who* uses the system and under what constraints, while Jobs-to-be-Done (JTBD) captures *why* they hire the system in a specific context.
-->
---
## Modeling Context & Tasks: Journey Maps & Task Analysis (HTA)

> **End-to-End Temporal Modeling:** While Personas capture user traits, **Customer Journey Maps** and **Hierarchical Task Analysis (HTA)** model actions, emotions, and pain points **over time**.

<div class="two-columns">
<div class="card" data-marpit-fragment>

### 1. Customer Journey Map (Macro Experience Flow)
- **Horizontal Stages (Timeline)**:
  - `Discovery` → `Onboarding` → `Ordering` → `Waiting` → `Delivery & Support`.
- **Vertical Swimlanes Across Each Stage**:
  1. **User Actions & Touchpoints**: Mobile app, SMS, push notifications, physical handoff.
  2. **Thoughts & Questions**: *"Is the restaurant still open? Where is my rider?"*
  3. **Emotional Curve (`Delight (+) ↔ Frustration (−)`)**: Visualizes emotional peaks and **valleys of anxiety** (e.g., the 25-minute "black box" wait after paying!).
  4. **Pain Points & Engineering Opportunities**: Adding a live kitchen status tracker (`Preparing → Packing → Picked Up`) directly heals the post-payment anxiety valley!

</div>
<div class="card" data-marpit-fragment>

### 2. Hierarchical Task Analysis (HTA — Micro Task Tree)
- **Origin (Annett & Duncan, 1967)**:
  - Decomposes a high-level user **Goal (`0`)** into a tree of **Sub-tasks (`1, 2, 3...`)** and execution **Plans** (specifying sequence, selection, or loops).
- **Food Delivery HTA Example**:
  - **Goal `0`**: Complete Group Meal Order
    - `1.` Create Group Session & Share Link
    - `2.` Collect Member Selections (`Plan 2`: wait until all members click *"Ready"* OR host clicks *"Lock Cart"*)
    - `3.` Select Split-Bill vs. Host-Pays Mode
    - `4.` Authorize Payment (`3.1` Verify address → `3.2` Confirm total → `3.3` Authenticate biometrics)
- **Engineering Value**: Directly maps to **UI screen flows, UML Activity Diagrams, and test scenarios**!

</div>
</div>

<!--
How do we model the dynamic flow of a user's interaction over time? We pair two complementary artifacts: the **Customer Journey Map** (macro experience) on the left, and **Hierarchical Task Analysis (HTA)** (micro task decomposition) on the right.

Look at the left card: A **Customer Journey Map** plots the user's end-to-end timeline across stages (`Discovery → Ordering → Waiting → Delivery`), overlaying their **Emotional Curve**.
In Food Delivery research, plotting the emotional curve reveals a famous insight: the lowest point of user satisfaction (maximum anxiety) occurs *immediately after payment*, when money has left their bank account and they sit hungry in the dark wondering if the restaurant even saw their order! That single Journey Map insight inspired the iconic live **Order Progress Tracker** (`Order Confirmed → Preparing in Kitchen → Rider Heading to Store → Arriving in 4 mins`).

Look at the right card: **Hierarchical Task Analysis (HTA)** breaks each high-level goal down into numbered sub-goals and conditional execution **Plans**—providing a rigorous bridge from UX research directly into UML Activity Diagrams and UI state machines.

To summarize this slide, remember this key takeaway: Customer Journey Maps expose emotional pain points across touchpoints, while Hierarchical Task Analysis (HTA) decomposes goals into structured operational steps.
-->
---
## Bridging UX Artifacts to Software Requirements (SRS)

> **Closing the SE ↔ UX Gap:** Every UX research artifact translates directly into a formal **Software Engineering Requirements or Design Specification** artifact!

| UX Engineering Artifact (Ch 06) | Corresponding SE / UML Artifact (Ch 03–05) | Concrete Traceability Example in Food Delivery |
| :--- | :--- | :--- |
| **1. Evidence-Based Persona**<br>*(e.g., Rider Wei — Scooter Context)* | **UML Actor & Non-Functional Requirements (NFRs)** in SRS | **Usability NFR-01**: Courier Order Accept/Decline screen must have tap targets `>= 56×56 dp` and contrast `>= 7:1` for one-handed outdoor glare use. |
| **2. Jobs-to-be-Done (JTBD)** | **Agile Epic & User Stories**<br>(`As a... I want... So that...`) | **US-204**: *As an office team host, I want to generate a shareable group-cart link with a $25/person cap so colleagues can pick meals within budget.* |
| **3. Customer Journey Map**<br>*(Post-Payment Anxiety Valley)* | **Functional Requirements & Event-Driven Architecture** | **FR-108**: System shall push real-time `OrderStateChanged` WebSocket updates within `< 2s` of kitchen tablet and courier status transitions. |
| **4. Hierarchical Task Analysis (HTA)** | **UML Use Case Scenarios, Activity Diagrams & Acceptance Tests** | Maps HTA `Plan 2` branches (`All Members Ready` vs. `Host Timeout Override`) directly into **Given-When-Then (BDD)** acceptance criteria. |

<!--
Before we move into Part 2 of Chapter 6, examine this synthesis table showing how UX Engineering integrates seamlessly with Requirements Engineering (Chapter 3), System Modeling (Chapter 4), and Software Design (Chapter 5):

1. An **Evidence-Based Persona** (like Courier Wei riding in outdoor sunlight with one thumb) directly specifies our **UML Actor** profile and quantifiable **Usability Non-Functional Requirements (NFRs)** in the SRS (e.g., minimum `56×56 dp` touch targets and `7:1` outdoor contrast).
2. A **Jobs-to-be-Done (JTBD)** statement translates directly into an **Agile Epic or User Story**.
3. Pain points uncovered in a **Customer Journey Map** drive both **Functional Requirements** and backend **Event-Driven Architecture** (such as WebSocket push notifications).
4. And **Hierarchical Task Analysis (HTA)** plans map 1-to-1 into **UML Use Case Flows, Activity Diagrams, and Given-When-Then Acceptance Tests**!

To summarize this slide, remember this key takeaway: UX artifacts are not isolated design deliverables; they trace directly into UML actors, user stories, non-functional requirements, and acceptance criteria in the SRS.
-->
---
<!-- _class: lead -->
<!-- header: '6.5 IA, Wireframing & Prototyping' -->

# **6.5 Information Architecture, Wireframing & Prototyping**

> "If a user can't find it, it doesn't exist."  
> — *Steve Krug (Author of Don't Make Me Think)*

<!--
Welcome to Section 6.5 (and Part 2 of our lecture): Information Architecture (IA), Wireframing, and Prototyping.

Once we have researched our users and defined their goals in Sections 6.1–6.4, how do we structure the software's content, navigation, and screen layouts before writing frontend code?

In this section, we examine Information Architecture (Garrett's Structure Plane), empirical taxonomy validation using Card Sorting and Tree Testing, the Prototyping Fidelity Spectrum (from 5-minute paper sketches to interactive Figma prototypes), and scalable UI engineering via Brad Frost's Atomic Design Systems.

To summarize this slide, remember this key takeaway: Information Architecture and iterative prototyping validate content findability and interaction flows before costly frontend coding begins.
-->
---
## Information Architecture (IA): Organization, Labeling & Navigation

> **Information Architecture (Rosenfeld, Morville & Arango — *The "Polar Bear Book"*):** The structural design of shared information environments to maximize **findability** and **understandability**.

<div class="two-columns">
<div class="card" data-marpit-fragment>

### 1. The 4 Core Systems of Information Architecture
- **1. Organization Systems (How we categorize)**:
  - **LATCH Principle (Wurman)**: Information can only be organized by **L**ocation, **A**lphabet, **T**ime, **C**ategory, or **H**ierarchy (Magnitude).
  - **Structural Topologies**: **Hierarchy (Tree)**, **Sequential (Linear Wizard)**, **Matrix (Multi-faceted Filter)**, and **Organic (Hypertext Graph)**.
- **2. Labeling Systems (How we name things)**:
  - Using user-centric vocabulary (`"Track My Order"`) instead of internal DB table names (`"Query Dispatch_Log_V2"`).

</div>
<div class="card" data-marpit-fragment>

### 2. Navigation & Search Systems
- **3. Navigation Systems (How users move through space)**:
  - **Global Navigation**: Persistent top/bottom bar present across the entire app (`Home | Search | Orders | Account`).
  - **Local Navigation**: Sub-navigation within a specific category (e.g., Restaurant Menu tabs: `Popular | Mains | Drinks`).
  - **Contextual & Breadcrumb Navigation**: `"Where am I?"* trail (`Home > Taiwanese > Din Tai Fung > XiaoLongBao`) + inline related links.
- **4. Search Systems**:
  - Autocomplete, typo tolerance, and faceted filtering when repositories grow too large to browse.

</div>
</div>

<!--
What is **Information Architecture (IA)**? Coined by Richard Saul Wurman and formalized by Louis Rosenfeld and Peter Morville in *Information Architecture for the World Wide Web*, IA is the structural blueprint of how information is categorized, labeled, and navigated.

Look at the left card:
1. **Organization Systems**: Richard Saul Wurman's famous **LATCH** principle states that all human knowledge is organized along five axes: **L**ocation (nearby restaurants on a map), **A**lphabet (A-Z directory), **T**ime (chronological order history), **C**ategory (Cuisine type: Italian, Thai, Vegan), or **H**ierarchy/Magnitude (Price low-to-high or Star rating).
2. **Labeling Systems**: Every menu label is a promise to the user. Labels must use the user's natural mental-model vocabulary, never internal database schema names.

Look at the right card:
3. **Navigation Systems** answer the three fundamental spatial questions every user asks on every screen (Steve Krug): *"Where am I?"*, *"Where have I been?"*, and *"Where can I go next?"* through Global, Local, and Breadcrumb navigation.
4. **Search Systems** complement browsing with typo-tolerant query retrieval and multi-attribute faceted filters.

To summarize this slide, remember this key takeaway: Information Architecture combines Organization, Labeling, Navigation, and Search systems so users always know where they are and how to find what they need.
-->
---
## Empirical IA Validation: Card Sorting & Tree Testing

> **Testing Navigation Before Drawing Screens:** Never let backend database schemas dictate your UI menu hierarchy—validate user mental models empirically with **Card Sorting** and **Tree Testing**!

<div class="two-columns">
<div class="card" data-marpit-fragment>

### 1. Card Sorting (Generative — Building the Taxonomy)
- **How It Works**:
  - Write 30–60 content items or app features on index cards (or digital tools like OptimalSort). Ask `15–20` users to group them into piles that make sense to them.
- **Two Variants**:
  - **Open Card Sort**: Users create their own groupings AND invent their own **category names** (*discovers how users naturally classify and label concepts*).
  - **Closed Card Sort**: Users sort cards into **pre-defined top-level categories** (*tests whether existing menu labels are unambiguous*).
- **Analysis**: **Dendrograms** & **Similarity Matrices** reveal consensus clusters vs. orphan items.

</div>
<div class="card" data-marpit-fragment>

### 2. Tree Testing (Evaluative — "Reverse Card Sorting")
- **How It Works**:
  - Strip away all visual styling, layout, and graphics—present **only the pure text menu hierarchy (the "Tree")**.
  - Give users realistic findability tasks: *"Where would you go to request a refund for a missing drink?"*
- **Quantitative IA Metrics**:
  1. **Success Rate (%)**: Did they reach the correct leaf node?
  2. **Directness (%)**: Did they navigate straight there on the **first path without backtracking** (`First-Click Accuracy`)?
  3. **Time Spent**: Seconds required to locate the item.

</div>
</div>

<!--
How do we know whether our proposed menu structure matches the User's Mental Model *before* we spend weeks designing screens? UX engineers use two complementary empirical methods: **Card Sorting** and **Tree Testing**.

Look at the left card: **Card Sorting** is a generative method used to create or restructure a taxonomy:
You give participants 30 to 60 cards representing specific features (e.g., `"Change Credit Card"`, `"Download Tax Invoice"`, `"Report Cold Food"`, `"Tip Rider"`).
In an **Open Card Sort**, users group the cards however they think best and write their own category titles—revealing their natural mental taxonomy!
In a **Closed Card Sort**, you give them fixed top-level buckets (`Account`, `Orders`, `Help`, `Wallet`) and measure whether users agree on which bucket each feature belongs in.

Look at the right card: **Tree Testing** (often called *Reverse Card Sorting*) evaluates the resulting hierarchy:
You show users a plain-text accordion tree of your menu labels and ask: *"Find where to cancel your monthly subscription."*
Research shows that **First-Click Testing** is highly predictive: if a user's very first menu click is correct, their probability of completing the task is **87%**; if their first click is wrong, task success plummets to **46%**!

To summarize this slide, remember this key takeaway: Open/Closed Card Sorting discovers how users naturally group and label concepts, while Tree Testing validates findability and first-click accuracy in the resulting hierarchy.
-->
---
## The Prototyping Fidelity Spectrum: Sketch → Wireframe → Prototype

> **Bill Buxton's Dual Mandate (*Sketching User Experiences*):** Early low-fidelity sketches focus on **"Getting the Right Design"** (exploring alternatives cheaply); late high-fidelity prototypes focus on **"Getting the Design Right"** (refining micro-interactions).

| Fidelity Tier | Visual & Interactive Characteristics | Primary Engineering Purpose & Cost to Change |
| :--- | :--- | :--- |
| **1. Low-Fidelity (Lo-Fi)**<br>*Paper Sketches & Balsamiq* | Hand-drawn boxes, rough lines, zero color/fonts; static or wizard-of-oz paper flipping. | **Divergent Ideation (`Cost: Minutes`)**: Explore 5 radically different workflows in 30 mins. Encourages honest user critique (*nobody hesitates to criticize a pencil sketch!*). |
| **2. Mid-Fidelity (Mid-Fi)**<br>*Grayscale Wireframes* | Strict grid layout, real hierarchy & copy labels, grayscale boxes (`[Image]`), no brand colors. | **Skeleton & IA Alignment (`Cost: Hours`)**: Lock down screen density, Gestalt grouping, content priority, and edge-case states (`Empty`, `Loading`, `Error`). |
| **3. High-Fidelity (Hi-Fi)**<br>*Interactive Figma / Code Prototype* | Pixel-accurate UI tokens, real food photos, clickable state transitions, and micro-animations. | **Usability Testing & Dev Handoff (`Cost: Days`)**: Validate realistic task flows, visual contrast, and exact component specs prior to sprint implementation. |

<!--
Once our Information Architecture is validated, we move to Garrett's Skeleton and Surface planes through **Prototyping**. Examine the three tiers of the **Prototyping Fidelity Spectrum** in this table:

1. **Low-Fidelity (Lo-Fi) Paper Sketches**: Why do senior UX architects still start with pen and paper or rough Balsamiq sketches? Two reasons:
   - First, **speed and non-attachment (Sunk-Cost Immunity)**: If you spend 3 days crafting a pixel-perfect Figma screen, you fall in love with it and resist changing it when it fails usability testing. If you draw three 5-minute sketches, you happily throw away two!
   - Second, **honest participant feedback**: When users see a polished high-fidelity screen, they assume the app is already finished and only comment on colors or fonts. When they see a rough sketch, they feel empowered to critique the fundamental workflow!
2. **Mid-Fidelity (Mid-Fi) Grayscale Wireframes**: Focus strictly on layout hierarchy, real text labels (avoiding fake `"Lorem ipsum"` wherever possible!), and mapping out the **4 UI States** of every screen: `Ideal State`, `Empty State`, `Loading State`, and `Error State`.
3. **High-Fidelity (Hi-Fi) Interactive Prototypes**: Clickable Figma prototypes used for summative usability testing and exact developer handoff.

To summarize this slide, remember this key takeaway: Match prototyping fidelity to your engineering stage—use low-fidelity sketches to explore alternative concepts cheaply, and high-fidelity prototypes to validate detailed interactions.
-->
---
## Design Systems, Atomic Design & UI Engineering Consistency

> **Bridging UX Design & Frontend Architecture (Brad Frost, 2013):** A **Design System** is not a static PDF style guide; it is a **versioned, single-source-of-truth component library** shared between Figma and production code (React/Vue/iOS/Android).

<div class="two-columns">
<div class="card" data-marpit-fragment>

### 1. Brad Frost's 5-Level Atomic Design Hierarchy
1. **Atoms (Primitives)**: Indivisible UI building blocks—`<Button>`, `<Input>`, `<Icon>`, `<Badge>`, plus **Design Tokens** (`--color-primary-600`, `--space-4`).
2. **Molecules (Simple Compounds)**: A small functional unit combining 2–3 atoms—e.g., a **`<SearchBar>`** (`<Label>` + `<Input>` + `<Button>`).
3. **Organisms (Complex Sections)**: Self-contained interface regions—e.g., **`<RestaurantCard>`** or **`<GlobalNavbar>`**.
4. **Templates (Page Skeletons)**: Content-agnostic layout grids assembling organisms into a page structure.
5. **Pages (Concrete Instances)**: Templates populated with real runtime data (`"Din Tai Fung Menu"`), used to test edge cases (e.g., 80-character dish names!).

</div>
<div class="card" data-marpit-fragment>

### 2. Why Software Engineers Love Design Systems
- **1. Enforces Nielsen's Heuristic #4 (Consistency)**:
  - Guarantees every modal, toast, and primary button behaves identically across 50 microservices and frontend squads.
- **2. Design Tokens as the Contract (`JSON → CSS/Swift/Kotlin`)**:
  - Semantic tokens (`color.bg.danger.subtle`, `spacing.md = 16px`) enable instant **Dark Mode** switching and WCAG contrast compliance from a single JSON source!
- **3. Built-In Accessibility (a11y Once, Everywhere)**:
  - Baking keyboard `Tab` focus traps and `aria-*` attributes into the base `<DialogAtom>` automatically makes every modal in the enterprise accessible!

</div>
</div>

<!--
How do modern software engineering organizations ensure that 40 frontend developers and 15 UX designers build a unified, consistent interface without reinventing the `<Button>` 40 times? Through **Design Systems** (such as Google Material 3, Apple Human Interface Guidelines, IBM Carbon, or Shopify Polaris) structured via **Brad Frost's Atomic Design (2013)**.

Look at the left card:Notice how **Atomic Design** mirrors object-oriented composition in software engineering:
1. **Atoms** are the foundational HTML/UI primitives (`<Button>`, `<Input>`, `<Avatar>`) governed by **Design Tokens** (variables for color, typography, spacing, and elevation).
2. **Molecules** combine a few atoms into a single-purpose widget (like a `<PromoCodeField>` combining an input box and an `"Apply"` button).
3. **Organisms** combine molecules and atoms into reusable domain sections (like a `<CheckoutOrderSummary>` card).
4. **Templates** define the structural page wireframe grid.
5. **Pages** instantiate templates with real dynamic payloads to stress-test layout wrapping and truncation.

Look at the right card: By encoding **Design Tokens** and **WCAG Accessibility** directly into the shared Atomic component library (documented in **Storybook**), teams eliminate UI drift, support Dark Mode effortlessly, and boost frontend velocity by 3–5x!

To summarize this slide, remember this key takeaway: Atomic Design Systems unite UX designers and frontend engineers around shared Design Tokens and reusable component hierarchies from Atoms to Pages.
-->
---
### Peer Discussion 6.5: IA & Wireframe States for Group Ordering

<div class="discussion-columns">
  <div class="discussion-text">

  **UX Architecture Exercise: Designing the "Office Group Order" Flow (4 Mins)**
  - **Scenario:** You are designing the **Group Order (Shared Cart)** feature for our Food Delivery App based on the JTBD from Section 6.4 (*Host invites 4 colleagues via link; budget cap $25/person*).
  - **1. Information Architecture & Labeling:**
    - Where in the app's hierarchy should `"Start Group Order"` live so users find it on their **first click** (Restaurant Menu header vs. Account Settings vs. Checkout Screen)?
  - **2. Mid-Fidelity Wireframe & The 4 UI States:**
    - Sketch or specify the **Host's Shared Cart Wireframe**, explicitly addressing the **4 Mandatory UI States**:
      - **Empty State**: Host just created the link; 0 colleagues have joined yet. What signifiers/actions are shown?
      - **Loading / Active State**: 3 colleagues have added items; 1 colleague is still *"Choosing..."*.
      - **Error / Edge State**: A colleague adds a $32 item exceeding the $25 cap, OR abandons their phone without clicking *"I'm Ready"*. How does the UI prevent the Host from getting stuck?

  </div>
  <div class="discussion-logo">
    <img src="../../img/discussion_icon.svg" alt="Discussion Icon" />
  </div>
</div>

<!--
Let's take 4 minutes for Peer Discussion 6.5!

Imagine you are the UX Architect pairing with a Frontend Tech Lead to design the **Group Order (Shared Cart)** feature in our Food Delivery App.
Discuss two crucial architectural questions with your partner:
First, **Information Architecture & First-Click Findability**: If a user opens the app wanting to order lunch with 4 coworkers from a specific restaurant, where does their Mental Model expect to find the `"Group Order"` button? If you hide it inside `Account > Settings > Experimental Features`, what will happen in a Tree Test?
Second, **Wireframing the 4 UI States**: Novice designers only draw the "Happy Path" (Ideal State) where all 4 coworkers instantly pick $20 meals. In real life, what should the wireframe show in the **Empty State** (0 friends joined), the **Partial Progress State** (3 ready, 1 still browsing), and the **Edge/Error State** (one coworker walked away from their desk—how can the Host proceed to checkout without losing everyone else's food)?

We will review the complete reference architecture in Appendix B!

To summarize this slide, remember this key takeaway: Robust interaction design requires placing features where mental models expect them and explicitly designing Empty, Loading, Partial, and Error states—not just the Happy Path.
-->
---
### Concept Check Question 4 (CCQ 4)
<!-- id: ase-ch06-ccq4 -->
<div class="ccq-columns">
  <div class="ccq-text">

Before designing any visual screens for a banking portal, a UX engineer presents 30 participants with a **plain-text collapsible menu hierarchy** (stripped of all graphics, colors, and page layouts) and asks: *"Where would you click to freeze a lost debit card?"* Which specific UX evaluation method is being conducted, and what does it measure?

- **A.** **Open Card Sorting**, which discovers how users invent new category names from unorganized feature cards.
- **B.** **Tree Testing**, which evaluates menu findability and first-click accuracy within an existing hierarchy.
- **C.** **A/B Split Testing**, which measures live production conversion rates between two visual button styles.
- **D.** **Atomic Design Auditing**, which verifies that UI molecules inherit CSS tokens from primitive atoms.

  </div>
  <div class="ccq-logo">
  </div>
</div>

<!--
Let's check our understanding of Section 6.5 with Concept Check Question 4 (CCQ 4)!

Read the method description carefully: The UX engineer already has a proposed menu hierarchy, strips away all visual layout and styling to show *only* the text menu tree, and measures whether users can navigate the tree to find a specific target (`"Freeze a lost debit card"`).

Let's compare the options:
Option A (**Open Card Sorting**) is generative: you give users an unorganized deck of cards and ask them to group them into piles and invent category names.
Option B (**Tree Testing**, or Reverse Card Sorting) is evaluative: you give users a plain-text menu tree and measure **Success Rate** and **Directness (First-Click Accuracy)** to validate whether your Information Architecture labels and hierarchy are findable independent of visual layout!
Options C and D refer to live traffic experimentation and design system architecture, respectively.

Therefore, the correct answer is B!

To summarize this slide, remember this key takeaway: Tree Testing isolates the pure text hierarchy of an Information Architecture to measure first-click accuracy and findability before visual wireframing begins.
-->
---
<!-- _class: lead -->
<!-- header: '6.6 Nielsen 10 Usability Heuristics' -->

# **6.6 Analytical Evaluation: Nielsen's 10 Usability Heuristics**

> "Heuristic evaluation is a discount usability engineering method: 3 to 5 independent evaluators can identify 75% to 80% of major usability problems before a single user test is run."  
> — *Jakob Nielsen (1994)*

<!--
Welcome to Section 6.6: Analytical Evaluation and Jakob Nielsen's 10 Usability Heuristics.

In software engineering, before we run expensive integration tests in production, we perform **Static Code Analysis and Peer Code Reviews** to catch bugs early. In UX Engineering, the exact equivalent of a static code review is **Analytical Usability Inspection**—led by **Heuristic Evaluation** (Jakob Nielsen & Rolf Molich, 1990; refined by Nielsen in 1994) and **Cognitive Walkthroughs**.

In this section, we master the formal Heuristic Evaluation protocol, Nielsen's 0–4 Severity Scale, all 10 Usability Heuristics with concrete software engineering examples, and the Cognitive Walkthrough technique.

To summarize this slide, remember this key takeaway: Heuristic Evaluation is the UX equivalent of static code inspection, systematically catching interface defects against 10 time-tested design principles.
-->
---
## Heuristic Evaluation: Protocol, Evaluators & Severity Rating

> **Why Multiple Evaluators? (Nielsen & Landauer, 1993):** A single evaluator finds only **`~35%`** of usability problems; aggregating **3 to 5 independent evaluators** uncovers **`75%–80%`** of issues at minimal cost!

<div class="two-columns">
<div class="card" data-marpit-fragment>

### 1. The 4-Step Heuristic Evaluation Protocol
1. **Briefing & Task Scenarios**: Evaluators receive the target Persona, domain context, and core task flows to inspect.
2. **Independent Inspection (Crucial Rule!)**:
   - Each of the **3–5 evaluators** inspects the interface **alone** (two passes: Pass 1 for overall flow, Pass 2 auditing each screen against the 10 Heuristics) to prevent groupthink bias!
3. **Aggregation & Debriefing**: Combine duplicate findings into a master defect log, citing the specific **Heuristic (`#1–#10`)** violated.
4. **Severity Rating & Action Plan**: Score each defect (`0–4`) to prioritize engineering sprint fixes.

</div>
<div class="card" data-marpit-fragment>

### 2. Nielsen's 0–4 Usability Severity Scale
- **Severity = f (`Frequency`, `Impact`, `Persistence`)**:
  - **`0` — Not a Problem**: Disagreement; no UX impact.
  - **`1` — Cosmetic Problem**: Fix only if extra time remains in the sprint (e.g., `2px` icon misalignment).
  - **`2` — Minor Usability Problem**: Low priority; causes brief hesitation but users recover quickly.
  - **`3` — Major Usability Problem**: High priority; causes significant confusion, delay, or repeated errors.
  - **`4` — Usability Catastrophe**: **Blocker!** Must be fixed before release (causes data loss, double-charging, or task abandonment).

</div>
</div>

<!--
How is a formal **Heuristic Evaluation** conducted in industry?

Look at the left card: A common mistake students make is sitting 5 people in a room together to critique a screen at the same time. In a real Heuristic Evaluation, **each evaluator must inspect the UI independently first**! Why? Because if an outspoken senior developer speaks first, everyone else anchors on their opinion (**Groupthink**). When 3 to 5 evaluators inspect the interface independently and then merge their lists, they catch 75% to 80% of all usability defects!

Look at the right card: Once defects are logged, how do we decide what the engineering team must fix before launch? Jakob Nielsen defines a **0-to-4 Severity Scale** based on three factors—**Frequency** (how many users hit it?), **Impact** (how badly does it block them?), and **Persistence** (do they hit it every single time, or only once?):
A **Level 4 Usability Catastrophe** is a release blocker (just like a `P0` severity bug in Jira!), whereas a **Level 1 Cosmetic Problem** is fixed only when spare bandwidth exists.

To summarize this slide, remember this key takeaway: Effective Heuristic Evaluation requires 3 to 5 independent inspections followed by collective severity ranking (0 to 4) to prioritize engineering fixes.
-->
---
## Nielsen's Heuristics #1 – #3: Status, Real World & User Control

> **Cluster 1 (Transparency & Agency):** Keep the user informed, speak their language, and always provide an **emergency exit**.

| Heuristic (`#1 – #3`) | Core Principle & Cognitive Rationale | Software UI Engineering Examples (`[Good]` vs. `[Violation]`) |
| :--- | :--- | :--- |
| **#1 Visibility of System Status** | Always keep users informed about **what is going on**, through appropriate feedback within a reasonable time (`100ms / 1s / 10s`). | **[Good]**: Live Food Delivery steps (`Order Confirmed → Kitchen Preparing → Rider 3 mins away`) + upload `%` bar.<br>**[Violation]**: Clicking `"Pay"` shows a frozen button for 9 seconds. |
| **#2 Match Between System & Real World** | Speak the **users' language** (words, phrases, familiar concepts) rather than system-oriented engineering terms; follow real-world conventions. | **[Good]**: Checkout uses a familiar receipt layout and says *"Card declined by bank"*.<br>**[Violation]**: Throwing `"Error 0x80040E14: RPC Payment Shard NullPointer"`. |
| **#3 User Control & Freedom** | Users often choose functions by mistake and need a clearly marked **"Emergency Exit"** to leave the unwanted state without an extended dialogue. | **[Good]**: Gmail's `"Message Sent — [Undo] (5s)"` toast; Food Delivery `"Cancel Order (Free within 60s)"` button.<br>**[Violation]**: Accidentally tapping an item immediately charges the card with no cancel/back option. |

<!--
Let's systematically master all 10 of Jakob Nielsen's Usability Heuristics, grouped into three logical engineering clusters. Here in Cluster 1 (Heuristics #1, #2, and #3), the focus is on **System Transparency and User Agency**:

1. **Heuristic #1 — Visibility of System Status**: Directly narrows Norman's **Gulf of Evaluation**. Whether it is a battery icon, an unread badge, a step indicator (`Step 2 of 3`), or a live courier map, the user should never have to guess what state the system is in.
2. **Heuristic #2 — Match Between System and the Real World**: Directly enforces aligning the **System Image** with the **User's Mental Model**. Never leak backend table names, HTTP status codes (`502 Bad Gateway`), or enum keys (`STATUS_PENDING_ACK_04`) onto a customer screen!
3. **Heuristic #3 — User Control and Freedom**: Humans explore interfaces by trial and error, and fingers slip on mobile screens. Always provide an immediate **"Emergency Exit"**—`Undo`, `Redo`, `Cancel`, and a clear `×` close button on modals—so users feel safe exploring your software without fear of irreversible traps!

To summarize this slide, remember this key takeaway: Heuristics #1–#3 ensure users always know the current system state, understand the domain vocabulary, and possess a safe Undo/Cancel emergency exit.
-->
---
<!-- _class: title-image-slide -->

## Visual Examples: Visibility of System Status & Real-World Mapping

<div class="image-wrapper">
  <img src="../../img/ux/ns01_status_feedback_examples.png" alt="Nielsen Heuristic 1 Visibility of System Status Examples" />
</div>

<!--
Examine these concrete visual examples of Heuristic #1 (**Visibility of System Status**):

Notice how different task durations require different visual status indicators:
- For instantaneous actions (`< 100 ms`), a tactile button press state, toggle switch animation, or badge count update immediately confirms receipt.
- For multi-second asynchronous operations (`1s–10s`), an indeterminate skeleton shimmer or spinner communicates that the request is actively processing.
- For long or multi-stage workflows (`> 10s` or multi-minute physical fulfillment like Food Delivery or file uploads), a deterministic step progress bar (`Order Received → Preparing → On the Way → Delivered`) with estimated time remaining eliminates uncertainty and prevents repeat submissions!

To summarize this slide, remember this key takeaway: Matching status feedback granularity to operation duration keeps users informed and confident across every stage of execution.
-->
---
## Nielsen's Heuristics #4 – #7: Consistency, Errors, Memory & Speed

> **Cluster 2 (Cognitive Efficiency & Error Prevention):** Leverage conventions, prevent **Slips & Mistakes** before they happen, minimize memory load, and provide **Accelerators** for experts.

| Heuristic (`#4 – #7`) | Core Principle & Cognitive Rationale | Software UI Engineering Examples (`[Good]` vs. `[Violation]`) |
| :--- | :--- | :--- |
| **#4 Consistency & Standards** | Users should not have to wonder whether different words, situations, or actions mean the same thing (**Internal & External Consistency**). | **[Good]**: Using standard platform navigation and consistent button terminology (`"Place Order"` everywhere).<br>**[Violation]**: Calling the cart `"Basket"` on screen 1, `"Tray"` on screen 2, and `"Bag"` on screen 3. |
| **#5 Error Prevention** | Better than a good error message is a **careful design that prevents a problem from occurring** in the first place (eliminate **Slips** & **Mistakes**). | **[Good]**: Graying out past calendar dates; Gmail warning *"You wrote 'attached' but attached no file."*<br>**[Violation]**: Letting users type `"Feb 31"` in a plain text box and failing only after form submission. |
| **#6 Recognition Rather Than Recall** | Minimize user memory load by making **objects, actions, and options visible**; users should not have to remember info from one screen to another. | **[Good]**: Showing recent delivery addresses, dish thumbnails, and inline promo-code selector.<br>**[Violation]**: Forcing users to memorize a 10-digit order ID from Page A to type into Support Page B. |
| **#7 Flexibility & Efficiency of Use** | Provide **Accelerators**—unseen by the novice user—that speed up interaction for the **expert user** (`Novice + Expert dual catering`). | **[Good]**: `"One-Tap Reorder Favorite"`, keyboard shortcuts (`Cmd+K` command palette), bulk actions.<br>**[Violation]**: Forcing power-user cashiers through a 6-step novice wizard for every single order. |

<!--
Now let's examine Cluster 2: Heuristics #4, #5, #6, and #7, which govern **Cognitive Efficiency and Error Prevention**:

4. **Heuristic #4 — Consistency and Standards**: Encompasses both **Internal Consistency** (within your own product via an Atomic Design System) and **External Consistency** (following industry conventions per **Jakob's Law**).
5. **Heuristic #5 — Error Prevention**: Don Norman divides human errors into two types:
   - **Slips (Action Errors)**: The user has the *right intention*, but accidentally executes the wrong physical action (e.g., fat-fingering `"Delete"` next to `"Edit"`). We prevent Slips via Fitts's Law spacing, constraints, and confirmation dialogs for high-stakes actions.
   - **Mistakes (Mental-Model Errors)**: The user forms the *wrong goal or plan* because they misunderstood the system state. We prevent Mistakes via clear previews, smart defaults, and contextual guardrails (like Gmail's forgotten-attachment detector!).
6. **Heuristic #6 — Recognition Rather Than Recall**: Directly applies Cognitive Load Theory—keep options, recent searches, and context visible on screen!
7. **Heuristic #7 — Flexibility and Efficiency of Use**: How do you satisfy both a first-time novice and a daily power user? Keep the default UI clean for novices, while embedding **Accelerators** (`Cmd+K`, swipe gestures, `"1-Click Reorder"`) for experts!

To summarize this slide, remember this key takeaway: Heuristics #4–#7 reduce cognitive friction through consistency, proactive constraint-based error prevention, visible context, and expert accelerators.
-->
---
## Nielsen's Heuristics #8 – #10: Minimalism, Recovery & Help

> **Cluster 3 (Signal-to-Noise & Graceful Recovery):** Every extra unit of irrelevant information competes with relevant units and **diminishes their relative visibility**.

| Heuristic (`#8 – #10`) | Core Principle & Cognitive Rationale | Software UI Engineering Examples (`[Good]` vs. `[Violation]`) |
| :--- | :--- | :--- |
| **#8 Aesthetic & Minimalist Design** | Interfaces should **not contain irrelevant or rarely needed information**; maximize the **Signal-to-Noise Ratio** (Edward Tufte's *Data-Ink Ratio*). | **[Good]**: Restaurant card shows only Name, Photo, Rating (`4.8★`), ETA (`25 min`), and Delivery Fee.<br>**[Violation]**: Cluttering every menu card with 14 promotional badges, legal disclaimers, and full address strings. |
| **#9 Help Users Recognize, Diagnose & Recover from Errors** | Error messages must be expressed in **plain language** (no error codes), precisely **indicate the problem**, and **constructively suggest a solution**. | **[Good]**: *"Card expired (08/25). Please update your expiration date or choose Apple Pay."*<br>**[Violation]**: A red banner saying simply `"Invalid Input (Code 422)"` without highlighting which field failed. |
| **#10 Help & Documentation** | Even though it is best if the system can be used without documentation, provide **searchable, task-focused, concise contextual help**. | **[Good]**: Inline `[?]` tooltip explaining *"Service Fee covers packaging & insurance"* right at checkout.<br>**[Violation]**: Forcing users to download a 120-page PDF manual to learn how to split a bill. |

<!--
Now let's complete the 10 Heuristics with Cluster 3: Heuristics #8, #9, and #10!

8. **Heuristic #8 — Aesthetic and Minimalist Design**: Note that "Minimalist" does **not** mean making everything blank white and hiding all labels! It means maximizing the **Signal-to-Noise Ratio**: every pixel on screen should directly support the user's current task. If 15 marketing banners and secondary metadata fields scream for attention on a checkout screen, the user misses the critical delivery address warning!
9. **Heuristic #9 — Help Users Recognize, Diagnose, and Recover from Errors**: Whenever an error cannot be prevented by Heuristic #5, your error message must fulfill **3 mandatory engineering criteria**:
   - **(a) Noticeable & Polite**: Clearly visible near the field (never blame or insult the user).
   - **(b) Plain-Language Diagnosis**: Explain *what* went wrong in human terms (no raw stack traces or hex codes).
   - **(c) Constructive Recovery Action**: Provide a direct button or instruction showing *how to fix it right now*!
10. **Heuristic #10 — Help and Documentation**: Deliver help **in-context** (inline tooltips, empty-state coaching, interactive 3-step onboarding spotlights) centered on concrete user tasks.

To summarize this slide, remember this key takeaway: Heuristics #8–#10 keep interfaces focused on high-signal task information while providing actionable error recovery and contextual guidance.
-->
---
## Cognitive Walkthrough: Task-Focused Analytical Inspection

> **Complementing Heuristic Evaluation (Wharton, Rieman, Lewis & Polson, 1994):** While Heuristic Evaluation audits a UI broadly against 10 principles, a **Cognitive Walkthrough** steps through a specific **task action-by-action** to evaluate **first-time Learnability**.

<div class="two-columns">
<div class="card" data-marpit-fragment>

### 1. The 4 Standard Questions Asked at Every Action Step
- For each micro-step `k` in a novice user's task sequence, evaluators ask **4 cognitive questions** (mapped to Norman's Action Cycle!):
  1. **Goal Formation**: Will the user realistically **try to achieve the right effect** at this step?
  2. **Visibility (Affordance)**: Will the user **notice that the correct UI control is available** on the screen?
  3. **Label Association (Signifier)**: Will the user **associate the control's label/icon with their intended goal**?
  4. **Feedback Evaluation**: After performing the action, will the user **see clear feedback confirming progress** toward their goal?

</div>
<div class="card" data-marpit-fragment>

### 2. Heuristic Evaluation vs. Cognitive Walkthrough
| Comparison Dimension | Heuristic Evaluation | Cognitive Walkthrough |
| :--- | :--- | :--- |
| **Inspection Scope** | Holistic screen-by-screen audit against **10 Heuristics**. | Step-by-step trace of **specific task flows**. |
| **Primary Focus** | Overall usability (`#1–#10`), consistency & error handling. | **First-time Learnability** & exploratory discovery. |
| **Theoretical Root** | Empirical usability principles (Nielsen, 1994). | **CE+ Theory of Exploratory Learning** & Norman's Action Cycle. |
| **Output Artifact** | Defect log with **Heuristic ID & Severity (`0–4`)**. | Step failure trace (`Q1–Q4` breakdown per action). |

</div>
</div>

<!--
Along with Heuristic Evaluation, what is the second major **Analytical Inspection** method taught in academic HCI courses? The **Cognitive Walkthrough**, developed by Cathleen Wharton, John Rieman, Clayton Lewis, and Peter Polson (1994).

Look at the left card: Unlike Heuristic Evaluation (which evaluates whole screens against 10 broad rules), a **Cognitive Walkthrough** simulates a **first-time novice user** performing a concrete task step by step.
At every single click or tap in the ideal task path, the engineering team asks **4 strict questions**:
- **Q1 (Intent)**: Will the user even know they are supposed to do this step right now?
- **Q2 (Visibility)**: Is the button or control visible without hidden scrolling or hover traps?
- **Q3 (Signifier Match)**: Does the button's label match the words in the user's head so they know *this* is the button to click?
- **Q4 (Feedback)**: Once clicked, does the screen update clearly enough that the user knows they succeeded and moves to the next step?
If the answer to any of `Q1–Q4` is *"No"*, you have pinpointed an exact learnability bug!

To summarize this slide, remember this key takeaway: Cognitive Walkthroughs audit first-time task learnability by testing Goal Formation, Control Visibility, Label Association, and Feedback at every action step.
-->
---
### Concept Check Question 5 (CCQ 5)
<!-- id: ase-ch06-ccq5 -->
<div class="ccq-columns">
  <div class="ccq-text">

When a user attempts to register an account on a web portal, typing an already-registered email and clicking **"Submit"** clears the entire 12-field form and displays a banner reading: **`"SQLSTATE[23505]: Unique violation on key idx_users_email"`**. Which pair of **Jakob Nielsen's 10 Usability Heuristics** is most directly violated by this behavior?

- **A.** **#7 Flexibility and Efficiency of Use** and **#8 Aesthetic and Minimalist Design**.
- **B.** **#2 Match Between System and Real World** and **#9 Help Users Recognize, Diagnose, and Recover from Errors**.
- **C.** **#1 Visibility of System Status** and **#10 Help and Documentation**.
- **D.** **#4 Consistency and Standards** and **#6 Recognition Rather Than Recall**.

  </div>
  <div class="ccq-logo">
  </div>
</div>

<!--
Let's check our mastery of Section 6.6 with Concept Check Question 5 (CCQ 5)!

Analyze what went wrong in this registration form:
First, instead of speaking the user's natural language (*"This email is already registered"*), the UI dumps a raw PostgreSQL database exception (`"SQLSTATE[23505]: Unique violation on key idx_users_email"`). Exposing internal database jargon directly violates **Heuristic #2: Match Between System and the Real World**!
Second, when the error occurs, the UI wipes out all 12 fields the user just typed and offers zero constructive recovery path (such as preserving their input and offering a *"Log in instead"* or *"Reset password"* link). That directly violates **Heuristic #9: Help Users Recognize, Diagnose, and Recover from Errors** (as well as inline Error Prevention #5)!

Comparing the option pairs, Option B (`#2` and `#9`) is the exact match!

To summarize this slide, remember this key takeaway: Raw database exceptions and destructive form resets violate Heuristic #2 (Match Between System and Real World) and Heuristic #9 (Constructive Error Recovery).
-->
---
<!-- _class: lead -->
<!-- header: '6.7 Usability Testing, Metrics & Ethics' -->

# **6.7 Empirical Usability Testing, Metrics & Ethical UX**

> "Testing one user early in the project is better than testing 50 near the end."  
> — *Steve Krug (Rocket Surgery Made Easy)*

<!--
Welcome to Section 6.7: Empirical Usability Testing, Quantitative Metrics, and Ethical UX Engineering.

Analytical inspections like Heuristic Evaluation and Cognitive Walkthroughs are powerful, but they are still performed by experts—not by real end users. Even the most seasoned UX architect cannot predict every surprising way real humans will interpret an interface in the wild.

In this section, we transition from analytical inspection to **Empirical Evaluation with Real Users**: Moderated Think-Aloud Usability Testing, Jakob Nielsen's `N = 5` Poisson discovery model, quantitative benchmarking (Task Success, SUS, NASA-TLX, Google HEART, A/B Testing), and Ethical UX Engineering against **Dark Patterns**.

To summarize this slide, remember this key takeaway: Empirical usability testing validates software with real representative users, combining qualitative Think-Aloud insights with standardized quantitative metrics.
-->
---
## Formative vs. Summative Testing & The Think-Aloud Protocol

> **Why Test with `N = 5` Users Per Iteration? (Nielsen & Landauer, 1993):** The proportion of usability problems discovered by `n` users follows **`P = 1 − (1 − L)`<sup>`n`</sup>** (where average problem discoverability `L ≈ 0.31`). Testing **5 users uncovers `~85%`** of usability flaws!

<div class="two-columns">
<div class="card" data-marpit-fragment>

### 1. Formative vs. Summative Usability Testing
- **Formative Evaluation (*During Design — "Find & Fix"*)**:
  - Conducted iteratively on **wireframes and prototypes** before code is locked.
  - **Sample Size**: **5 users per iteration** (`3 rounds × 5 users = 15 users` catches far more bugs than `1 round × 15 users`!).
  - **Focus**: Qualitative behavioral diagnosis (*Why did they get stuck?*).
- **Summative Evaluation (*Post-Build — "Benchmark & Compare"*)**:
  - Conducted on working builds or against competitors.
  - **Sample Size**: **`20–30+` users** for tight confidence intervals on quantitative metrics (`Task Success %`, `Time-on-Task`, `SUS`).

</div>
<div class="card" data-marpit-fragment>

### 2. The Think-Aloud Protocol (Ericsson & Simon, 1984)
- **How Concurrent Think-Aloud Works**:
  - Ask participants to complete realistic scenario tasks while **continuously verbalizing their thoughts, expectations, and confusion out loud** (*"I'm looking for a way to split the bill... I'm clicking this icon because it looks like two people..."*).
- **3 Strict Moderator Rules (Preventing Bias)**:
  1. **Test the System, Never the User**: Explicitly reassure participants *"We are testing the app, not you; any confusion is the software's fault."*
  2. **Never Lead the Witness**: Never ask *"Do you see the green button at the top?"* Ask open prompts: *"What are you thinking right now?"*
  3. **Observe Actions Over Polite Compliments**: Users often say *"It's nice!"* out of politeness after failing a task for 4 minutes!

</div>
</div>

<!--
Let's examine the methodology of **Empirical Usability Testing**.

Look at the left card: First, distinguish **Formative Testing** from **Summative Testing**:
- **Formative Usability Testing** happens *while* you are still designing wireframes and prototypes. Its goal is to find and fix flaws rapidly.
Why did Jakob Nielsen and Thomas Landauer (1993) famously recommend testing **`N = 5` users per round**?
Look at the Poisson discovery formula: `P = 1 - (1 - L)^n`, where `L ≈ 0.31` is the average probability that any single user encounters a given usability flaw.
With `n = 1` user, you find `31%` of flaws. With `n = 3`, you find `67%`. With **`n = 5` users, you uncover `1 - (0.69)^5 ≈ 85%`** of the core usability problems in that design! Rather than spending your entire budget testing 15 users on a broken prototype v1, you test **5 users on v1**, fix the bugs, test **5 users on v2**, fix the remaining bugs, and test **5 users on v3**!
- **Summative Usability Testing**, by contrast, evaluates a completed release with `20–30+` users to establish statistically reliable benchmarks.

Look at the right card: During Formative testing, our gold-standard method is the **Think-Aloud Protocol** (K. Anders Ericsson & Herbert A. Simon, 1984), which opens a direct window into the user's working memory and mental model!

To summarize this slide, remember this key takeaway: Iterative formative testing with 5 users per round using the Think-Aloud protocol uncovers ~85% of usability defects early and cheaply.
-->
---
## Quantitative Usability Metrics & Standardized Questionnaires

> **Objective UX Benchmarking:** Combine **Behavioral Task Metrics** (what happened during the test) with **Standardized Psychometric Scales** (validated post-task / post-test questionnaires).

| Metric Category | Specific Engineering Metric / Scale | Formula, Benchmark Threshold & Interpretation |
| :--- | :--- | :--- |
| **1. Effectiveness**<br>*(Behavioral)* | **Task Completion Rate (Success %)** & **Error Count** | `Success % = (Completed Accurately / Total Attempts) × 100%`.<br>*Target*: **`>= 80%–90%`** for consumer apps; **`100%`** for safety-critical flows. |
| **2. Efficiency**<br>*(Behavioral)* | **Time-on-Task (s)** & **Lostness Metric (`L`, Smith 1996)** | `L = sqrt((N/S − 1)² + (R/N − 1)²)` (`R`=min nodes, `S`=total visited, `N`=unique visited).<br>*Threshold*: `L < 0.4` indicates clear navigation; **`L > 0.5`** indicates severe user disorientation! |
| **3. Post-Task Ease**<br>*(Attitudinal)* | **SEQ (Single Ease Question)** & **NASA-TLX (Cognitive Workload)** | **SEQ**: 1-item 7-point rating right after each task (*"Overall, how difficult or easy was this task?"*, Benchmark **`>= 5.5 / 7`**). **NASA-TLX**: 6-dimension workload index. |
| **4. Overall Usability**<br>*(Post-Study Scale)* | **SUS (System Usability Scale — John Brooke, 1986)** | 10 alternating positive/negative items (`1–5` Likert), scored **`0 to 100`** (percentile rank, *not* a percentage!).<br>*Industry Historical Average*: **`68`** (`>= 80.3` is Grade **A** / Top 10%; `< 50` is Grade **F**). |

<!--
How do we quantify usability so software engineering teams can track UX quality in CI/CD release gates alongside backend latency and test coverage? Examine the four tiers of quantitative metrics in this table:

1. **Behavioral Effectiveness**: **Binary Task Completion Rate (%)** (did the user successfully place the group order without moderator rescue?) and **Critical vs. Non-Critical Error Counts**.
2. **Behavioral Efficiency**: **Time-on-Task** (geometric mean in seconds) and Pauline Smith's (1996) mathematical **Lostness Metric (`L`)**, which compares the minimum optimal number of screens required (`R`) against the unique screens (`N`) and total screen visits (`S`) taken by the user. When `L > 0.5`, users are lost in a maze of backtracking!
3. **Post-Task Perceived Ease**: Immediately after each individual task, we administer the **Single Ease Question (SEQ)** (`1 = Very Difficult` to `7 = Very Easy`, historical average `~5.5`) or **NASA-TLX** for high-stakes operational interfaces.
4. **Post-Study Overall Perceived Usability**: At the end of the entire test session, we administer John Brooke's (1986) **System Usability Scale (SUS)**—the most widely validated 10-item psychometric questionnaire in software engineering. Remember: a **SUS score of `68`** is the 50th percentile industry benchmark, and **`>= 80.3`** places your software in the top 10% (Grade A)!

To summarize this slide, remember this key takeaway: Rigorous UX evaluation pairs behavioral metrics (Task Success, Time-on-Task, Lostness) with standardized psychometric instruments (SEQ and the 0–100 SUS scale).
-->
---
## Large-Scale Production Experiments: A/B Testing & Google HEART

> **Continuous UX Telemetry:** After launch, product engineering teams pair **Controlled Online Experiments (A/B Testing)** with **Google's HEART Framework** (Kerry Rodden, Hilary Hutchinson & Xin Fu, 2010).

<div class="two-columns">
<div class="card" data-marpit-fragment>

### 1. Controlled A/B Testing & Guardrail Metrics
- **Randomized Controlled Trial (RCT) in Production**:
  - Randomly split live traffic (`50% Control A` vs. `50% Variant B` via feature flags) to test a specific **UX Hypothesis**.
- **Statistical Rigor & Guardrail Metrics**:
  - Require pre-calculated **Sample Size (Statistical Power `1 − β >= 80%`)** and **`p < 0.05`** significance (never "peek and stop early"!).
  - **Guardrail Metrics**: When testing if a larger checkout button increases conversion (`Primary Metric`), monitor **Cancel/Refund Rate** and **Page Latency** (`Guardrail Metrics`) to ensure you didn't just cause accidental clicks!

</div>
<div class="card" data-marpit-fragment>

### 2. Google's HEART Framework + Goals-Signals-Metrics
- **5 UX Quality Dimensions at Scale (`H-E-A-R-T`)**:
  - **H — Happiness**: Subjective satisfaction (`SUS`, in-app CSAT, App Store rating).
  - **E — Engagement**: Depth & frequency of voluntary interaction (`orders/week`, active sessions).
  - **A — Adoption**: New users adopting the product or a new feature (`% using Group Order within 14 days`).
  - **R — Retention**: Cohort survival rate (`D7 / D30 / D90` returning active users; inverse of **Churn**).
  - **T — Task Success**: Behavioral efficiency & error rates in telemetry (`Search-to-Cart %`, checkout completion time).

</div>
</div>

<!--
Once your software ships to hundreds of thousands of users in production, how do you continuously measure and improve UX? We combine **Controlled A/B Testing** on the left with **Google's HEART Framework** on the right.

Look at the left card: In an **A/B Test**, live users are randomly assigned to Control (`A`) or Treatment (`B`).
Notice the critical engineering concept of **Guardrail Metrics**: Suppose Variant B increases `"1-Click Order"` conversion by `+8%`, but also increases `"Customer Support Cancellation Requests"` by `+25%` because users clicked it by accident! Without a Guardrail Metric protecting user trust and error rates, naive conversion optimization can degrade UX!

Look at the right card: Developed by Google UX researchers Kerry Rodden, Hilary Hutchinson, and Xin Fu (2010), the **HEART Framework** structures production UX telemetry across five orthogonal dimensions—**Happiness, Engagement, Adoption, Retention, and Task Success**—mapped via the **Goals → Signals → Metrics** process so product teams never drown in vanity metrics.

To summarize this slide, remember this key takeaway: Production UX engineering combines statistically rigorous A/B testing (with guardrail metrics) and Google's HEART framework to track long-term user value.
-->
---
## Ethical UX Engineering: Dark Patterns vs. Transparent Design

> **ACM Code of Ethics & EU Digital Services Act (DSA):** Software engineers have a professional and legal duty to reject **Deceptive Design (Dark Patterns)** that exploit human cognitive biases against the user's best interest.

| Dark Pattern (Harry Brignull, 2010) | Deceptive Cognitive Manipulation Mechanism | Ethical & Legal UX Engineering Alternative |
| :--- | :--- | :--- |
| **1. Roach Motel**<br>*(Asymmetric Friction)* | Signing up for a monthly subscription takes **1 tap**, but canceling requires calling a phone hotline during business hours and navigating 8 retention screens. | **Symmetric Click-to-Cancel (FTC Rule)**: Make subscription cancellation just as fast, visible, and self-service as sign-up. |
| **2. Confirmshaming**<br>*(Emotional Manipulation)* | Phrasing the decline button to guilt or insult the user: *"No thanks, I hate saving money and prefer paying full price."* | **Neutral, Respectful Labeling**: Use clear, objective choices: `"Apply Annual Pass"` vs. `"Continue with Standard Order"`. |
| **3. Sneak into Basket & Drip Pricing** | Automatically pre-checking optional insurance/tips in the cart, or hiding mandatory `"Platform + Service Fees"` until the final payment click. | **Upfront All-In Price Transparency & Opt-In Consent**: Display total estimated fees upfront; require explicit user **Opt-In** (never pre-checked boxes!). |
| **4. Misdirection & Disguised Cancel** | Making `"Keep My Subscription"` a giant bright blue button while hiding `"Confirm Cancellation"` as tiny low-contrast gray text (`Fitts + Visual Hierarchy abuse`). | **Honest Visual Hierarchy**: Style primary confirmation and secondary back actions clearly without inverting button semantics to trick users. |

<!--
As software engineers and UX designers, our deep knowledge of cognitive psychology, Fitts's Law, Gestalt hierarchy, and default biases comes with a profound ethical responsibility.

In 2010, cognitive scientist **Harry Brignull** coined the term **Dark Patterns** (now also termed **Deceptive Design Patterns**) to describe user interfaces carefully crafted to trick users into doing things they did not intend—such as buying hidden add-ons, surrendering private data, or failing to cancel recurring subscriptions.

Review the four notorious Dark Patterns in this table:
1. **Roach Motel**: Easy to get in (1-click sign-up), nearly impossible to get out.
2. **Confirmshaming**: Manipulating user guilt through insulting decline labels.
3. **Sneak into Basket / Drip Pricing**: Pre-checking optional add-ons (exploiting default bias) or hiding mandatory fees until the user has already invested 10 minutes building their cart (exploiting the **Sunk-Cost Fallacy**).
4. **Visual Misdirection**: Inverting button colors on a cancellation confirmation screen so users who habitually click the bright button accidentally *keep* the subscription they were trying to cancel!

Today, Dark Patterns are not merely unethical under the **ACM/IEEE Software Engineering Code of Ethics**—they are **illegal** under the **EU Digital Services Act (DSA Article 25)**, **GDPR**, and **US FTC Click-to-Cancel regulations**, carrying fines up to 6% of global annual turnover!

To summarize this slide, remember this key takeaway: Ethical UX engineering uses cognitive science to empower user agency and informed consent, never to manipulate users via deceptive Dark Patterns.
-->
---
### Peer Discussion 6.7: Designing a Usability Test Plan & Ethical Audit

<div class="discussion-columns">
  <div class="discussion-text">

  **Empirical UX Lab: Testing & Auditing "FoodPass" Subscription (4 Mins)**
  - **Scenario:** The business team wants to launch **FoodPass** (a $9.99/month free-delivery membership) inside our Food Delivery App.
  - **Part 1 — Formative & Summative Usability Test Plan:**
    - You have **2 weeks** before launch. How many participants (`N`) will you recruit for your **Formative Think-Aloud** wireframe rounds vs. your final **Summative Benchmark**?
    - Write **1 concrete, non-leading Task Scenario** (without using the exact button label `"Manage FoodPass"`) to test whether users can pause or cancel their membership, and list **2 Quantitative Metrics** you will record.
  - **Part 2 — Dark Pattern Ethical Audit:**
    - A PM proposes: *(a)* Pre-checking `"Add FoodPass ($9.99/mo)"` at checkout by default, and *(b)* Requiring users to go through 5 screens where `"Keep FoodPass"` is bright green and `"Cancel"` is a tiny gray link.
    - **Task:** Name the **2 Dark Patterns** present and rewrite the flow to achieve high ethical conversion without deception!

  </div>
  <div class="discussion-logo">
    <img src="../../img/discussion_icon.svg" alt="Discussion Icon" />
  </div>
</div>

<!--
Let's take 4 minutes for Peer Discussion 6.7!

In this exercise, you are leading the UX Engineering release review for **FoodPass**, a $9.99/month membership program.
Work with your partner on two tasks:
In Part 1, design the **Usability Test Plan**:
- How do you apply Nielsen's `N = 5` rule across formative iterations?
- And how do you write a **non-leading Task Prompt**? Remember: if the button on screen is labeled `"Manage FoodPass"`, and your test script says *"Please click Manage FoodPass to cancel"*, you have turned a cognitive usability test into a trivial word-matching game! How should you phrase the scenario instead?
In Part 2, conduct a **Dark Pattern Audit** on the PM's proposal: identify the exact Dark Pattern names for `(a)` and `(b)`, and propose an ethical, transparent alternative (such as showing the exact dollar savings on the current order with an explicit Opt-In toggle and 1-click Pause/Cancel).

Full reference solutions are in Appendix B!

To summarize this slide, remember this key takeaway: A rigorous usability test plan uses non-leading scenario prompts and objective metrics, while ethical design drives adoption through transparent value rather than Dark Patterns.
-->
---
<!-- _class: lead -->
<!-- header: '6.8 AI-Augmented UX & Synthesis' -->

# **6.8 AI-Augmented UX Engineering, Synthesis & References**

> "In the era of Generative AI, the paradigm shifts twice: we use AI to accelerate UX workflows (AI for UX), and we invent new interaction paradigms for probabilistic AI systems (UX for AI)."

<!--
Welcome to our final section, Section 6.8: AI-Augmented UX Engineering, Conceptual Synthesis, and References.

Today, Artificial Intelligence and Large Language Models (LLMs) are transforming User Experience along two distinct dimensions:
First, **AI for UX**: How UX researchers and UI engineers use generative AI as a copilot across the Double Diamond lifecycle.
Second, **UX for AI**: How we design trustworthy, controllable human-centered interfaces for AI-powered features that are inherently probabilistic, non-deterministic, and prone to hallucination!

Let's examine this dual paradigm and then synthesize our entire 60-slide curriculum.

To summarize this slide, remember this key takeaway: Modern software engineers must master both using AI to accelerate UX engineering (AI for UX) and designing safe, transparent interfaces for probabilistic AI agents (UX for AI).
-->
---
## The Dual Paradigm: "AI for UX" vs. "UX for AI" (Human-AI Interaction)

> **Deterministic GUI vs. Probabilistic AI:** Traditional GUIs are **100% deterministic** (`Click Button A → State B`); Generative AI interfaces are **probabilistic, latency-variable, and fallible**, requiring new UX engineering patterns!

<div class="two-columns">
<div class="card" data-marpit-fragment>

### 1. AI for UX (Accelerating the HCD Lifecycle)
- **Discover & Define**:
  - Using LLMs to transcribe interviews, cluster **Affinity Diagrams** with verbatim citations, and spot themes across 10,000 support tickets.
- **Develop (Ideation & Wireframing)**:
  - Rapidly generating multi-variant wireframe layouts, realistic domain microcopy (eliminating `"Lorem ipsum"`), and WCAG-compliant color palettes.
- **Evaluate (Synthetic Pre-Inspection)**:
  - Running automated **Heuristic & WCAG pre-audits** before human usability testing (*Warning: Synthetic AI personas never replace real human observation!*).

</div>
<div class="card" data-marpit-fragment>

### 2. UX for AI (Designing Human-AI Interaction — HAI)
- **Microsoft's 18 HAI Guidelines (Amershi et al., CHI 2019)**:
  1. **Calibrate Trust Initially (`G1–G2`)**: Make clear *what the AI can do* and *how well it can do it* (avoid false anthropomorphism).
  2. **Hybrid Intent Input (Prompt + GUI Controls)**: Pure chat boxes have a wide **Gulf of Execution** ("Blank Canvas Paralysis"); pair natural language with **clickable prompt chips & parameter sliders**!
  3. **Explainability & Source Grounding (`G11`)**: Show *why* the AI recommended a dish or route, with clickable citations/provenance.
  4. **Graceful Hallucination Recovery & Human-in-the-Loop**: Stream tokens progressively (`< 400ms` first token), show confidence levels, and require **explicit human confirmation** (`Diff Preview + Undo`) before executing destructive actions!

</div>
</div>

<!--
Let's unpack the two sides of AI and UX shown on this slide:

In the left card (**AI for UX**), Generative AI acts as a high-speed copilot across all four phases of the Double Diamond: clustering interview transcripts into affinity themes, generating realistic domain copy and wireframe variations in seconds, and running automated WCAG and Heuristic pre-checks. However, remember our golden rule from Section 6.4: **Synthetic LLM personas cannot replace observing real humans in the wild**, because LLMs do not have physical thumbs riding a scooter in the rain!

In the right card (**UX for AI**), how do we design user interfaces for AI agents and LLM features (based on Saleema Amershi et al.'s landmark CHI 2019 paper, *Guidelines for Human-AI Interaction*)?
1. **Overcome "Blank Prompt Paralysis"**: A blank text box has terrible discoverability (Heuristic #6 Recognition over Recall!). Great AI UX pairs natural-language input with **contextual starter chips, scoped slash commands, and visual refinement controls**.
2. **Stream Feedback & Explain Why**: Use token streaming to keep first-byte feedback under the `400ms` Doherty Threshold, and ground AI outputs with transparent citations so users can verify accuracy.
3. **Human-in-the-Loop Agency**: Because AI is probabilistic, never let an AI agent execute irreversible actions (charging a credit card or deleting production records) without a clear **Preview Diff + One-Click Undo**!

To summarize this slide, remember this key takeaway: AI for UX accelerates research and prototyping, while UX for AI combines hybrid GUI-prompt controls, source grounding, and human-in-the-loop previews to tame probabilistic models.
-->
---
## 🧩 Conceptual Recap: Fill-in-the-Blank Quiz (Part 1)

<div class="fill-blank-container">

<div class="word-bank">
  <div class="word-bank-title">🏷️ Word Bank:</div>
  <span class="word-chip">Gulf of Execution</span>
  <span class="word-chip">Gulf of Evaluation</span>
  <span class="word-chip">Fitts's Law</span>
  <span class="word-chip">Extraneous Cognitive Load</span>
</div>

<div class="quiz-questions">

1. In Don Norman's 7 Stages of Action, the gap between a user's intention and the actions allowed by the interface (*"How do I work this?"*) is the <span class="quiz-blank" data-answer="Gulf of Execution">[ _________ ]</span>.
2. When a user clicks a button and cannot tell whether the system registered the action due to missing status feedback, they face a wide <span class="quiz-blank" data-answer="Gulf of Evaluation">[ _________ ]</span>.
3. In John Sweller's Cognitive Load Theory, unnecessary mental effort caused by cluttered layouts, inconsistent navigation, or cryptic jargon is called <span class="quiz-blank" data-answer="Extraneous Cognitive Load">[ _________ ]</span>.
4. The logarithmic predictive model `MT = a + b · log`<sub>`2`</sub>`(D / W + 1)` governing pointing time as a function of target distance and size is <span class="quiz-blank" data-answer="Fitts's Law">[ _________ ]</span>.

</div>

<div class="quiz-hint">💡 <em>Interactive Mode: Click any blank slot to reveal or hide the answer!</em></div>

</div>

<!--
Let's review the core cognitive and mathematical foundations from Part 1 of Chapter 6 using our interactive Fill-in-the-Blank Quiz (Part 1):

1. The gap between what the user wants to accomplish and figuring out how to operate the controls is Don Norman's **Gulf of Execution**!
2. The struggle to perceive and interpret whether the system state changed after acting is the **Gulf of Evaluation**!
3. Mental effort wasted decoding poor interface design—rather than inherent task complexity—is **Extraneous Cognitive Load**!
4. And the mathematical formula predicting motor target acquisition time from distance `D` and width `W` is **Fitts's Law**!

To summarize this slide, remember this key takeaway: Mastering the Two Gulfs, Cognitive Load Theory, and Fitts's Law provides a scientific foundation for diagnosing interaction bottlenecks.
-->
---
## 🧩 Conceptual Recap: Fill-in-the-Blank Quiz (Part 2)

<div class="fill-blank-container">

<div class="word-bank">
  <div class="word-bank-title">🏷️ Word Bank:</div>
  <span class="word-chip">Tree Testing</span>
  <span class="word-chip">Recognition Rather Than Recall</span>
  <span class="word-chip">Think-Aloud Protocol</span>
  <span class="word-chip">Roach Motel</span>
</div>

<div class="quiz-questions">

5. The empirical IA evaluation method ("reverse card sorting") that tests findability and first-click accuracy using a plain-text menu hierarchy is <span class="quiz-blank" data-answer="Tree Testing">[ _________ ]</span>.
6. Showing recent delivery addresses and visual autocomplete suggestions instead of forcing users to memorize codes applies Nielsen's Heuristic #6: <span class="quiz-blank" data-answer="Recognition Rather Than Recall">[ _________ ]</span>.
7. The formative usability testing method in which participants continuously verbalize their thoughts and expectations while performing tasks is the <span class="quiz-blank" data-answer="Think-Aloud Protocol">[ _________ ]</span>.
8. A deceptive Dark Pattern that makes subscribing take 1 click while burying cancellation behind phone calls and 8 retention screens is a <span class="quiz-blank" data-answer="Roach Motel">[ _________ ]</span>.

</div>

<div class="quiz-hint">💡 <em>Interactive Mode: Click any blank slot to reveal or hide the answer!</em></div>

</div>

<!--
Now let's complete Part 2 of our interactive Fill-in-the-Blank Quiz covering Information Architecture, Heuristics, Usability Testing, and Ethics:

5. Testing findability on a stripped-down text hierarchy before designing screens is **Tree Testing**!
6. Making options and context visible on screen so users don't have to retrieve information from memory is Nielsen's Heuristic #6: **Recognition Rather Than Recall**!
7. Asking users to speak their thoughts out loud while completing tasks is Ericsson and Simon's **Think-Aloud Protocol**!
8. And an asymmetric deceptive flow that is trivial to enter but deliberately painful to exit is the **Roach Motel** Dark Pattern!

To summarize this slide, remember this key takeaway: Tree Testing, Recognition over Recall, Think-Aloud testing, and ethical anti-dark-pattern standards anchor professional UX engineering practice.
-->
---
## Core Curriculum Synthesis & Classic Academic Literature

| Section | Core UX / HCI Models & Frameworks | Golden Engineering Takeaway |
| :--- | :--- | :--- |
| **6.1 Foundations** | **ISO 9241-210 / 9241-11**, Garrett's 5 Planes, **Nielsen's 5 Dimensions** | UX is built bottom-up (`Strategy → Surface`); quantify Learnability, Efficiency, Memorability, Errors & Satisfaction. |
| **6.2 Cognition** | **Model Human Processor (`100ms/1s/10s`)**, **7 Stages & 2 Gulfs**, **Cognitive Load** | Narrow the **Gulfs of Execution & Evaluation**; align the **System Image** with the **User's Mental Model**; cut extraneous load. |
| **6.3 Laws & a11y** | **Fitts's Law**, **Hick's Law**, **Tesler/Postel**, **Gestalt**, **WCAG 2.2 (`4.5:1`)** | Maximize target `W`, minimize `D` & choice entropy `n`; absorb complexity in code; enforce `4.5:1` contrast & non-color cues. |
| **6.4 HCD Research** | **Double Diamond**, **2×2 Research Matrix**, **Personas**, **JTBD**, **Journey Maps & HTA** | *"You are not the user!"* Triangulate behavioral & attitudinal research; trace Personas/JTBD/HTA directly to the **SRS**. |
| **6.5 IA & Prototyping** | **LATCH**, **Card Sorting & Tree Testing**, **Lo-Fi → Hi-Fi**, **Atomic Design** | Validate taxonomy findability first; sketch Lo-Fi to get the *right design*; scale UI via **Atoms → Organisms** & Tokens. |
| **6.6 Heuristics** | **Nielsen's 10 Usability Heuristics (`0–4` Severity)**, **Cognitive Walkthrough** | Run 3–5 independent inspections (`~80%` bug discovery); prevent Slips & Mistakes; audit novice steps via `Q1–Q4`. |
| **6.7 Testing & Ethics** | **Think-Aloud (`N = 5`)**, **SUS (`68` avg)**, **HEART & A/B**, **Anti-Dark Patterns** | Test 5 users per round; benchmark via **SUS & HEART**; reject **Roach Motel / Confirmshaming** Dark Patterns. |
| **6.8 AI & UX** | **AI for UX** vs. **UX for AI (Microsoft 18 HAI Guidelines)** | Pair natural language with GUI controls, ground sources, and require **Human-in-the-Loop Preview + Undo**. |

* **Essential References:** Don Norman (*The Design of Everyday Things*); Jakob Nielsen (*Usability Engineering*); Stuart Card, Thomas Moran & Allen Newell (*The Psychology of HCI*); Steve Krug (*Don't Make Me Think*); Jesse James Garrett (*The Elements of User Experience*); ISO 9241-210 & W3C WCAG 2.2.

<!--
Review this comprehensive Chapter 6 Synthesis Matrix and reading list!

Notice how every single section connects into a unified software engineering discipline:
From ISO usability standards (6.1) and cognitive psychology (6.2) to mathematical interaction laws and accessibility (6.3), empirical user research and SRS traceability (6.4), information architecture and Atomic Design Systems (6.5), Jakob Nielsen's 10 Heuristics (6.6), empirical Think-Aloud testing, SUS metrics, and ethical design (6.7), all the way to Human-AI Interaction (6.8).

For deeper reading, consult the foundational classics listed at the bottom: Don Norman's *The Design of Everyday Things*, Jakob Nielsen's *Usability Engineering*, Card, Moran, and Newell's *The Psychology of Human-Computer Interaction*, and Steve Krug's *Don't Make Me Think*.

To summarize this slide, remember this key takeaway: UX Engineering integrates cognitive science, mathematical laws, empirical research, and rigorous usability testing across the entire software lifecycle.
-->
---
<!-- header: '6.8 Appendix: Suggested Solutions' -->

## Appendix A: Suggested Answers for CCQ 1 – CCQ 5

| Question | Ans | Core UX / HCI Principle & Concise Engineering Rationale |
| :--- | :---: | :--- |
| **CCQ 1 (Sec 6.1)**<br>*Usability Dimensions* | **B** | **Efficiency vs. Learnability (Nielsen's 5 Components)**: Novice interns learn in 10 mins (high *Learnability*), but requiring 14 clicks across 5 modals for experienced daily nurses bottlenecks expert task speed (**Efficiency**). |
| **CCQ 2 (Sec 6.2)**<br>*Norman's Two Gulfs* | **C** | **Wide Gulf of Evaluation**: The engineer executed the click easily (narrow *Gulf of Execution*), but the lack of immediate visual feedback (`< 100ms` button state / `< 1s` spinner) prevented perceiving the new system state, causing duplicate clicks. |
| **CCQ 3 (Sec 6.3)**<br>*Fitts's Law (`D` & `W`)* | **B** | **Infinite Target Width (`W = ∞`) at Screen Edges**: Under `MT = a + b · log2(D/W + 1)`, pinning global menus flush against screen edges/corners uses the display boundary to stop cursor overshoot, dramatically lowering the Index of Difficulty. |
| **CCQ 4 (Sec 6.5)**<br>*IA Empirical Testing* | **B** | **Tree Testing (Reverse Card Sorting)**: Evaluates an existing text hierarchy stripped of visual layout to measure **Findability Success Rate (%)** and **First-Click Directness (%)** prior to wireframing. |
| **CCQ 5 (Sec 6.6)**<br>*Nielsen's 10 Heuristics* | **B** | **#2 Match Real World & #9 Error Recovery**: Exposing raw SQL error codes (`SQLSTATE[23505]`) violates **#2** (system-oriented jargon); wiping out 12 user-typed fields with no constructive fix violates **#9** (and **#5 Error Prevention**). |

<!--
Appendix A provides the complete answer key and theoretical rationale for all five Concept Check Questions (CCQ 1 through CCQ 5) across Chapter 6.

Use this summary table when reviewing for quizzes and exams to verify your mastery of Nielsen's 5 Usability Components (6.1), Norman's Gulfs of Execution and Evaluation (6.2), Fitts's Law (6.3), Tree Testing vs. Card Sorting (6.5), and Nielsen's 10 Usability Heuristics (6.6).

To summarize this slide, remember this key takeaway: Every CCQ illustrates how theoretical HCI models diagnose concrete frontend engineering defects.
-->
---
## Appendix B: Suggested Solutions for Peer Discussions 6.3, 6.5 & 6.7

<div class="two-columns">
<div class="card" data-marpit-fragment>

### 1. Solution — Peer Discussion 6.3 (Checkout Audit) & 6.5 (Group IA)
- **Peer Discussion 6.3 (4 Checkout Flaws & Fixes)**:
  1. **Fitts's Law + Heuristic #5**: Enlarge `"Place Order"` to full-width `52px` bottom bar (`↑ W`, `↓ D` in thumb zone); move `"Empty Cart"` into a top-right overflow menu with confirmation.
  2. **Hick-Hyman Law**: Replace 28 flat radio buttons with the user's **last-used payment method** as default + `3` top categories (`Card | Apple/Google Pay | Bank`).
  3. **Postel's & Tesler's Laws + Heuristic #9**: Auto-strip `-`/`()` spaces in JS; preserve all 8 address fields on validation error!
  4. **WCAG 2.2 Level AA (`1.4.1` & `1.4.3`)**: Increase contrast to `>= 4.5:1` (`#b91c1c` on `#fef2f2`) and add `[!] Required` icon + text below each missing field.
- **Peer Discussion 6.5 (Group Order IA & 4 States)**:
  - **IA Placement**: Place `"[+ Group Order]"` button directly in the **Restaurant Menu Header** (matches user mental model when browsing a restaurant).
  - **Edge State Override**: Show per-member status (`Adding...` vs. `Ready ✓`), auto-cap items at `$25` with inline split-pay option, and give Host a **"Lock Cart & Checkout Now"** override so 1 away coworker never blocks the order!

</div>
<div class="card" data-marpit-fragment>

### 2. Solution — Peer Discussion 6.7 (Usability Test & Ethics)
- **Part 1 — Test Plan & Non-Leading Scenario**:
  - **Sample Plan**: Run **2 formative rounds × 5 users (`N = 10`)** using **Think-Aloud** on Figma prototypes to fix flows, then **1 summative round (`N = 25`)** to benchmark.
  - **Non-Leading Prompt**: *"Imagine you subscribed to FoodPass last month, but you are traveling abroad for 3 weeks and want to stop being billed next month. Show me what you would do."* (Never say the word `"Manage"` or `"Cancel"`!).
  - **Metrics**: **Task Completion Rate (%)**, **Time-on-Task (s)**, **First-Click Accuracy (%)**, and post-task **SEQ / SUS**.
- **Part 2 — Dark Pattern Audit & Ethical Redesign**:
  - **Violations**: `(a)` **Sneak into Basket** (pre-checked opt-out box); `(b)` **Roach Motel + Visual Misdirection** (5 retention screens with inverted button colors).
  - **Ethical Fix**: Show transparent math (*"Save $4.50 on this order with FoodPass — [Add Free Trial]"* explicit Opt-In) and provide a symmetric **1-Click Pause / Cancel** button in Account Settings!

</div>
</div>

<!--
Finally, Appendix B provides the complete reference solutions for all three hands-on Peer Discussions (6.3, 6.5, and 6.7), followed by our interactive Table of Contents and Quick-Jump scripts.

Thank you very much for your attention and active participation in Chapter 6: User Experience (UX) Engineering and Interaction Design!

To summarize this slide, remember this key takeaway: Applying quantitative UX laws, complete state wireframing, non-leading usability testing, and ethical transparency elevates software engineering from working code to empowering human experiences.
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

    const allTitles = sections.map(s => s.title).join('');
    const isEn = !/[\u4e00-\u9fa5]/.test(allTitles);
    const txtOutline = isEn ? '📑 Table of Contents' : '📑 章節目錄';
    const txtTitleTooltip = isEn ? 'Click to pin or hover to view outline' : '點擊固定或懸停查看章節目錄';
    const txtPrev = isEn ? 'Previous Section' : '上一章節';
    const txtNext = isEn ? 'Next Section' : '下一章節';

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

    document.addEventListener('click', function(e) {
      if (!e.target.closest('.header-nav-wrapper')) {
        document.querySelectorAll('.header-nav-wrapper.is-open').forEach(w => w.classList.remove('is-open'));
      }
    });

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
      const active = document.activeElement;
      if (active && (active.tagName === 'INPUT' || active.tagName === 'TEXTAREA' || active.tagName === 'SELECT' || active.isContentEditable)) {
        return;
      }
      if (e.ctrlKey || e.altKey || e.metaKey) {
        return;
      }

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

      if ((e.key === 'Escape' || e.code === 'Escape') && inputBuffer.length > 0) {
        e.preventDefault();
        e.stopPropagation();
        clearInput();
        return;
      }

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

  // =========================================================================
  // 3. Interactive Fill-in-the-Blank Quiz (Click to Reveal / Hide)
  // =========================================================================
  function initQuizBlanks() {
    document.querySelectorAll('span.quiz-blank').forEach(function(el) {
      if (el.dataset.initialized) return;
      el.dataset.initialized = 'true';
      const answer = el.getAttribute('data-answer') || '';
      const placeholder = '[ _________ ]';
      if (!el.textContent.trim()) {
        el.textContent = placeholder;
      }
      el.title = 'Click to reveal / hide answer';
      el.addEventListener('click', function(e) {
        e.stopPropagation();
        if (el.classList.contains('revealed')) {
          el.classList.remove('revealed');
          el.textContent = placeholder;
        } else {
          el.classList.add('revealed');
          el.textContent = answer;
        }
      });
    });
  }

  function init() {
    initHeaderDropdown();
    initNumberQuickJump();
    initQuizBlanks();
  }

  if (document.readyState === 'loading') {
    document.addEventListener('DOMContentLoaded', init);
  } else {
    init();
  }
  setTimeout(init, 400);
})();
</script>
