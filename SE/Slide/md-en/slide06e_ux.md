---
marp: true
theme: ase-theme
paginate: true
header: 'Software Engineering | Chapter 6: User Experience (UX) Design'
footer: 'Prof. Nien-Lin Hsueh'
---

<!-- _class: lead -->
<!-- header: '' -->

# **Software Engineering**

### Chapter 6: User Experience (UX) Design & Human-Centered AI

**Prof. Nien-Lin Hsueh**
Department of Information Engineering and Computer Science
Feng Chia University

<!--
Welcome to Chapter 6 of Software Engineering: User Experience Design and Human-Centered AI.

In previous chapters, we studied how to elicit requirements, model system architectures, and structure maintainable object-oriented software. But even the most mathematically elegant, bug-free software architecture is a catastrophic failure if real human beings cannot understand it, navigate it, or enjoy using it.

Software engineering is fundamentally human-centered. In this chapter, we bridge the gap between engineering logic and human psychology. We explore the core principles of User Experience (UX), master Jakob Nielsen's 10 Usability Heuristics, learn how modern engineers use AI to accelerate UX design (AI for UX), and study how to design trustworthy interfaces for AI-powered systems (UX for AI).

To summarize this slide, remember this key takeaway: Software engineering excellence requires pairing robust technical architecture with intuitive, human-centered user experience design.
-->
---
<!-- _class: outline-slide -->

## Chapter 6: Roadmap & Core Curriculum

<div class="outline-columns">
  <div>
    <h3>Part 1: Foundations & Usability Heuristics</h3>
    <ul>
      <li><b>6.1 Foundations of User Experience (UX):</b> What is UX, Norman Doors, the 3 bad design archetypes, Taiwan NHI App case study, UI vs. UX distinction, 5-stage Design Thinking.</li>
      <li><b>6.2 Nielsen's 10 Usability Heuristics:</b> System status visibility, real-world match, user control & freedom, consistency, error prevention, recognition over recall, efficiency accelerators, minimalist aesthetics, error recovery, documentation.</li>
    </ul>
  </div>
  <div>
    <h3>Part 2: AI-Powered UX & Interaction Design</h3>
    <ul>
      <li><b>6.3 AI for UX (AI4UX):</b> AI as a design amplifier, the RTCF prompt engineering framework (Role-Task-Constraint-Format), automated heuristic audits, multi-agent prototyping.</li>
      <li><b>6.4 UX for AI (UX4AI):</b> Designing for non-deterministic AI, managing latency & thinking traces, human agency & steerability, hallucination guardrails, explainable AI (XAI).</li>
      <li><b>6.5 Evaluation & Synthesis:</b> Heuristic severity ratings (0 to 4), heuristic evaluation vs. user testing, chapter recap quiz, and engineering takeaways.</li>
    </ul>
  </div>
</div>

<!--
Here is our roadmap for Chapter 6.

On the left, in Part 1, we unpack foundational UX concepts: why good design is invisible, why bad design causes user rage, and how Jakob Nielsen's 10 Usability Heuristics provide the universal design grammar for digital interfaces.

On the right, in Part 2, we step into the cutting-edge frontier of AI-driven design. We examine AI for UX—using LLMs and agents to supercharge design workflows—and UX for AI—the art and science of designing interfaces for probabilistic, hallucination-prone AI systems.

To summarize this slide, remember this key takeaway: This chapter takes you from foundational cognitive ergonomics to modern, AI-augmented human-computer interaction design.
-->
---
<!-- _class: lead -->
<!-- header: '6.1 Foundations of User Experience (UX)' -->

# **6.1 Foundations of User Experience (UX)**

> "Good design is actually a lot harder to notice than poor design, in part because good designs fit our needs so well that the design is invisible."
> — *Don Norman, The Design of Everyday Things*

<!--
We begin with Module 6.1: Foundations of User Experience Design.

Have you ever walked up to a door in a public building, pushed with all your might, only to realize you were supposed to pull? Did you feel foolish?

As cognitive scientist Don Norman proved, you are not stupid—the door is stupid! When a door has a flat brass plate, human ergonomics dictates pushing. When it has a handle, humans instinctively pull. When a handle requires pushing, the design violates fundamental cognitive psychology.

In this section, we study everyday design psychology, examine classic bad design archetypes, analyze a real-world government app redesign, and define the formal scope of User Experience.

To summarize this slide, remember this key takeaway: When users make mistakes, blame the interface design rather than human intelligence.
-->
---
## The Classic Anti-Pattern: Norman's Door

<div class="split73">
  <div class="left">

* **What is a "Norman Door"?**
  - A door whose design gives false visual clues about how to operate it (e.g., a door with a pull handle that must be pushed, or a flat plate that must be pulled).
* **Affordance vs. Signifier:**
  - **Affordance:** The physical properties and potential actions of an object (a flat surface affords pushing).
  - **Signifier:** Visual cues that signal *where* and *how* the action should happen (e.g., a "PUSH" sign).
* **The Design Axiom:**
  - When an object needs an instruction sign just to open it, its design is fundamentally broken!

  </div>
  <div class="right">
    <img src="../../img/ux/normans_door_nobg.png" alt="Norman Door" />
  </div>
</div>

<!--
Look at this classic example of a Norman Door.

Observe the contradiction: the door has a vertical pull bar, but someone had to paste a clumsy sticker saying 'PUSH' because everyone was pulling it!

Don Norman established the vital distinction between Affordance and Signifiers. An affordance is what an object can physically do. A signifier is an explicit visual signal telling users where and how to interact.

If a door has proper affordances—such as a flat push-plate on the push side and a handle on the pull side—no sign is ever needed. The human brain operates it unconsciously.

To summarize this slide, remember this key takeaway: Intuitive design leverages natural physical affordances so users never require external operational instructions.
-->
---
## The Frustration of Bad UI/UX

<div class="split73">
  <div class="left">

* **The Emotional Toll of Poor Software:**
  - Cognitive overload, confusion, anxiety, and ultimate user abandonment.
  - Users do not blame software architects; they blame themselves or leave 1-star reviews.
* **Why Bad UX Destroys Business Value:**
  - **Cart Abandonment:** 70% of e-commerce carts are dropped due to convoluted checkout flows.
  - **Support Costs:** Thousands of expensive customer tickets originate from confusing navigation.
  - **Employee Burnout:** Enterprise software with terrible UX causes daily operational errors and lost productivity.

  </div>
  <div class="right">
    <img src="../../img/ux/bad_ui_ux_frustration_nobg.png" alt="User Frustration" />
  </div>
</div>

<!--
Poor software design carries severe emotional and economic costs.

When users encounter confusing forms, hidden submit buttons, or sudden error dialogs, they experience visceral frustration. In consumer applications, users simply uninstall the app and switch to a competitor. In enterprise settings, bad software costs organizations millions of dollars in lost productivity and operational mistakes.

Engineers must realize that usability is not a superficial luxury—it directly governs business retention, conversion rates, and software survival.

To summarize this slide, remember this key takeaway: Poor UX directly drives user churn, operational errors, and support overhead.
-->
---
## 3 Classic Bad Design Archetypes

* **1. The "Night Market Chaos" (Arngren-Style Overload):**
  - Stuffs hundreds of products, flashing banners, and conflicting links into a single screen with zero visual hierarchy.
  - The human brain suffers acute cognitive sensory overload.
* **2. The "Paint is Free" (Color & Contrast Nightmare):**
  - Uses neon greens, blazing yellows, and magenta fonts on cyan backgrounds.
  - Violates WCAG color contrast standards; illegible for users with visual impairments.
* **3. The "Where Do I Start?" (Missing Visual Hierarchy):**
  - Clutters dozens of identical, unprioritized buttons across the screen.
  - Fails to establish a primary Call-to-Action (CTA); the user has no idea which button to click first.

<!--
Let's catalog the three most common bad design archetypes found in legacy software.

First is the 'Night Market' style: cramming every possible link, banner, and image onto one page. The user's eye has nowhere to rest.

Second is the 'Paint is Free' style: using garish, uncurated color palettes that violate contrast standards and cause severe eye strain.

Third is the 'Where Do I Start?' archetype: presenting twenty identical buttons with no visual weight, leaving users paralyzed by decision fatigue.

To summarize this slide, remember this key takeaway: Eliminate cognitive overload, adhere to contrast standards, and guide users with clear visual hierarchies.
-->
---
<!-- _class: title-image-slide -->

## Real-World Anti-Pattern: Night Market Sensory Overload

<div class="image-wrapper">
  <img src="../../img/ux/bad_design_night_market_arngren.png" alt="Arngren Cluttered Design" />
</div>

<!--
Look at this infamous real-world web page from Arngren.

This is a textbook example of sensory overload. Hundreds of unrelated items—drones, electric scooters, model trains—compete simultaneously for attention. There are no margins, no whitespace, no visual grouping, and no clear scanning path.

When everything screams for attention, nothing is heard.

To summarize this slide, remember this key takeaway: Without visual grouping and whitespace, interfaces devolve into chaotic visual noise.
-->
---
## Case Study: Taiwan Mask App — The Operational Challenge

* **Context & Operational Urgency:**
  - During the COVID-19 pandemic, Taiwan's National Health Insurance App (健保快易通) handled millions of mask reservations daily.
* **Critical Usability Flaws of the Original Interface:**
  - **Buried Priority:** The critical "Mask Pre-Order" function was hidden inside a cluttered, 20-icon unorganized grid.
  - **Cognitive Search Fatigue:** Elderly citizens and anxious users were forced to hunt across multiple rows of identical icons.
  - **No Visual Hierarchy:** Trivial informational links had the exact same visual weight as life-critical pandemic services.
  - **System Bottlenecks:** Confused users repeatedly tapped wrong options, spiking customer support queues and server latency.

<!--
Here is a dramatic real-world case study: the Taiwan National Health Insurance App redesign during the COVID-19 pandemic.

During nationwide mask rationing, millions of anxious citizens needed to pre-order masks every single day.

However, the existing app was an administrative portal featuring an unprioritized grid of 20 identical square icons. Mask pre-ordering had the exact same visual weight as routine informational brochures.

Elderly users spent minutes hunting and squinting across the screen.

To summarize this slide, remember this key takeaway: Equal visual weight across disparate features hides mission-critical user tasks during high-stress situations.
-->
---
<!-- _class: title-image-slide -->
## Case Study: Original NHI App Interface (Before)

<div class="image-wrapper">
  <img src="../../img/ux/mask_order_app_before.png" alt="Mask App Before Redesign" />
</div>

<!--
Examine the original interface on this slide.

Notice the problem immediately: 20 identical square icons arranged in a uniform grid.

Can you spot the mask pre-order button right away? It blends right into medical records, hospital directories, and policy announcements.

For a citizen in an emergency rush, this interface required excessive visual scanning and caused severe cognitive friction.

To summarize this slide, remember this key takeaway: Uniform grids force users into exhaustive visual search instead of providing immediate task recognition.
-->
---
<!-- _class: title-image-slide -->
## Case Study: Redesigned Emergency Mask Flow (After)

<div class="image-wrapper">
  <img src="../../img/ux/mask_order_app_after.png" alt="Mask App After Redesign" />
</div>

<!--
Now examine the redesigned interface.

What a dramatic transformation! The design team promoted mask pre-ordering into a massive, high-contrast hero banner right at the top of the mobile screen.

Secondary administrative functions were neatly chunked into clean cards below.

Any citizen opening the app could accomplish their goal with a single tap in less than two seconds.

To summarize this slide, remember this key takeaway: High-priority situational tasks deserve dominant visual real estate and immediate affordance.
-->
---
## Case Study Analysis: Transforming Emergency UX

* **Human-Centered Redesign Strategy:**
  - **Hero Priority Card:** Promoted mask pre-ordering to a prominent top banner occupying the prime mobile thumb zone.
  - **Task Chunking:** Grouped secondary medical services into clear functional cards with clean spacing and high-contrast labels.
  - **Immediate Clarity:** Reduced user decision time from minutes of hunting to a single direct tap.
* **Key Redesign Takeaway:**
  - **Dynamic Situational UX:** Interface navigation hierarchy must dynamically adapt to real-world citizen priorities rather than reflecting static government department structures.

<!--
Let's analyze why this redesign was so successful.

First, the team applied Task Chunking: they grouped related secondary services together, reducing clutter.

Second, they aligned the interface with human situational priorities. During a pandemic, 95% of app visits were for masks. The interface adapted to human reality.

Remember: software navigation should never reflect internal company org charts or database schemas; it must reflect what real humans are trying to accomplish right now.

To summarize this slide, remember this key takeaway: Dynamic, situational UX adapts interface hierarchy to real-world user priorities.
-->
---
## Why is UX So Hard? The Empathy Gap

<div class="split73">
  <div class="left">

* **1. "You Are Not the User":**
  - Software engineers possess deep technical mental models (relational schemas, API routes, thread lifecycles).
  - End users possess everyday domain mental models (ordering dinner, booking an appointment, paying a bill).
* **2. The Curse of Knowledge:**
  - Once an engineer builds a complex feature, it seems "obvious" and "intuitive" to them.
  - They forget the cognitive friction experienced by a first-time user encountering the screen cold.
* **3. Defensive vs. Empathetic Thinking:**
  - Engineers often design interfaces to match backend database tables rather than natural human mental steps.

  </div>
  <div class="right">
    <img src="../../img/ux/why_ux_is_hard_nobg.png" alt="Why UX is Hard" />
  </div>
</div>

<!--
Why do brilliant engineers repeatedly build difficult-to-use software?

The fundamental psychological culprit is the Curse of Knowledge. Because the engineer spent three months designing the database architecture, the interface feels completely obvious to them. They can no longer see the system through the eyes of a novice.

Remember the cardinal rule of interaction design: You Are Not The User. Never assume what is easy for you is easy for the public.

To summarize this slide, remember this key takeaway: Overcome the curse of knowledge by separating internal system schemas from human mental models.
-->
---
## UI (User Interface) vs. UX (User Experience)

* **User Interface (UI):**
  - The tangible, sensory touchpoints through which humans interact with software.
  - *Elements:* Buttons, typography, color palettes, spacing, CSS grids, icons, transitions, animations.
  - *Core Question:* "How does the screen look, render, and react visually?"
* **User Experience (UX):**
  - The overall, end-to-end emotional and psychological journey a human has with a brand, service, or system.
  - *Elements:* Task efficiency, friction, cognitive load, user satisfaction, error recovery, trust.
  - *Core Question:* "How effectively, intuitively, and pleasantly does the user achieve their goal?"
* **The Classical Analogy:**
  - UI is the saddle, stirrup, and reins; UX is the feeling of riding the horse!

<!--
Let's crystallize the distinction between User Interface and User Experience.

UI represents the visual elements: the typography, colors, button gradients, and CSS layout.

UX represents the complete human journey: How long did it take to accomplish the goal? Did the user feel frustrated or delighted? What happened when the payment failed?

A website can have stunning UI graphics with glassmorphism and animations, but if the checkout button fails to submit on mobile Safari, the UX is disastrous.

To summarize this slide, remember this key takeaway: UI is what the user touches and sees; UX is how the user feels and succeeds.
-->
---
<!-- _class: title-image-slide -->
## Visualizing UI vs. UX: Anatomy of Interaction

<div class="image-wrapper">
  <img src="../../img/ux/ui_vs_ux_comparison_new.jpg" alt="UI vs UX Comparison" />
</div>

<!--
This visual comparison illuminates the distinction between UI and UX.

On the left, we observe UI attributes: visual aesthetics, typography, iconography, and color palettes.

On the right, we observe UX attributes: information architecture, interaction flows, usability testing, and emotional satisfaction.

Both are indispensable. But UI serves UX. A visually gorgeous interface that frustrates users is an engineering failure.

To summarize this slide, remember this key takeaway: UI creates the aesthetic sensory touchpoints, while UX governs user success, satisfaction, and utility.
-->
---
<!-- _class: title-image-slide -->

## The 5-Stage UX Design Thinking Process

<div class="image-wrapper">
  <img src="../../img/ux/ux_core_process.jpg" alt="5-Stage Design Thinking Process" />
</div>

<!--
Here is the Stanford d.school Design Thinking framework formalizing the 5-stage UX engineering lifecycle.

Notice the sequence: You never start by writing code or drawing high-fidelity screens. You start with Empathy—observing actual users in their natural environment.

Next, you Define the root problem. Then you Ideate dozens of creative concepts. You build rapid, disposable Prototypes, and you Test them with target users.

Let's examine what happens in each of these five critical stages.

To summarize this slide, remember this key takeaway: UX design is an iterative cycle progressing from user empathy to rapid prototyping and testing.
-->
---
## The 5 Stages of Design Thinking: Process Breakdown

* **1. Empathize (探索 / 同理):**
  - Conduct qualitative user interviews, contextual field inquiries, and observational studies.
  - Identify unarticulated frustrations and true emotional pain points.
* **2. Define (定義):**
  - Synthesize user research into concrete personas, empathy maps, and precise "How Might We" problem statements.
* **3. Ideate (構思):**
  - Brainstorm diverse potential solutions without premature judgment; sketch rapid low-fidelity paper wireframes.
* **4. Prototype (設計 / 原型):**
  - Build interactive, testable artifacts (clickable Figma mockups, interactive HTML/CSS code components).
* **5. Test (確認 / 測試):**
  - Put prototypes in front of real users, observe stumbling blocks, measure task completion rates, and iterate.

<!--
Let's examine each phase of the Design Thinking methodology.

In Empathize, you set aside your assumptions and listen to real users.

In Define, you distill research into actionable problem statements and personas.

In Ideate, you brainstorm wide varieties of solutions.

In Prototype, you build quick, testable artifacts.

In Test, you put those artifacts in front of users to gather behavioral evidence. Design is iterative: testing feedback loops back into redefining the problem.

To summarize this slide, remember this key takeaway: The five design thinking stages provide a structured, repeatable methodology for creating human-centered software.
-->
---
## Concept Check Question 1: UX Foundations & Norman Doors

In cognitive ergonomics and UX design, what is the fundamental lesson illustrated by a "Norman Door" that requires a printed "PUSH" label on a pull handle?

- **A.** Users lack the technical literacy required to operate modern mechanical equipment.
- **B.** The door's physical affordances contradict its operation, forcing external signifiers to patch poor design.
- **C.** All architectural and digital interfaces must provide printed documentation to satisfy legal compliance.
- **D.** Visual aesthetics should always take precedence over operational usability in public facilities.

<!--
Let's test our understanding of fundamental UX concepts and Norman Doors.

Reflect on Don Norman's definitions of affordances and signifiers.

Evaluate each option and select the choice that accurately captures why a labeled door represents a design failure.
-->
---
## Concept Check Question 1: Answer & Explanation

- **Correct Answer: B**
- **Explanation:**
  - A Norman Door is the archetypal design failure where the physical affordance of the handle (which naturally affords pulling) contradicts the actual required mechanism (pushing). Because the design violates intuitive human mental models, designers are forced to paste an explicit signifier ("PUSH") to prevent errors.
  - As Don Norman established: if an everyday object requires an instruction label just to perform its primary function, its intuitive design has failed.
  - *Why others are incorrect:* Option A blames the user, which violates the core axiom of human-centered design. Option C is false because intuitive designs should be self-explanatory without manuals. Option D falsely promotes aesthetics over usability.

<!--
The correct answer is B.

When the physical affordance of a handle tells the human brain to pull, but the door only pushes, the design has failed. The paper sign is an embarrassing band-aid over a broken mental model.

To summarize this slide, remember this key takeaway: Intuitive physical and digital interfaces communicate operation through natural affordances, not corrective warning signs.
-->
---
<!-- _class: lead -->
<!-- header: "6.2 Nielsen's 10 Usability Heuristics" -->

# **6.2 Nielsen's 10 Usability Heuristics**

> "Jakob's Law: Users spend most of their time on other sites. This means that users prefer your site to work the same way as all the other sites they already know."
> — *Jakob Nielsen, Nielsen Norman Group*

<!--
We now enter Module 6.2: Nielsen's 10 Usability Heuristics.

Formulated by Jakob Nielsen and Rolf Molich in 1994, these ten heuristics remain the universal constitution of interaction design. They are not rigid mathematical laws; they are broad rules of thumb based on decades of empirical human-computer interaction studies.

In this module, we examine all ten heuristics side-by-side with real interface examples—from gas stove knobs to iPhone lock screens—and study how these timeless rules guide software engineering decisions.

To summarize this slide, remember this key takeaway: Nielsen's 10 Heuristics provide the universal heuristic grammar for evaluating and designing intuitive software interfaces.
-->
---
## Overview: Nielsen's 10 Usability Heuristics

<div class="outline-columns">
  <div>
    <ul>
      <li><b>NS01. Visibility of System Status:</b> Keep users informed through timely feedback.</li>
      <li><b>NS02. Match System & Real World:</b> Speak the user's language using natural concepts.</li>
      <li><b>NS03. User Control & Freedom:</b> Provide clear emergency exits (undo/redo).</li>
      <li><b>NS04. Consistency & Standards:</b> Follow platform conventions (Jakob's Law).</li>
      <li><b>NS05. Error Prevention:</b> Eliminate error-prone conditions beforehand.</li>
    </ul>
  </div>
  <div>
    <ul>
      <li><b>NS06. Recognition Rather Than Recall:</b> Make objects, actions, and options visible.</li>
      <li><b>NS07. Flexibility & Efficiency:</b> Provide accelerators for power users.</li>
      <li><b>NS08. Aesthetic & Minimalist Design:</b> Maximize signal-to-noise ratio.</li>
      <li><b>NS09. Help Users Recover from Errors:</b> Express error messages in plain language.</li>
      <li><b>NS10. Help and Documentation:</b> Provide searchable, contextual guidance.</li>
    </ul>
  </div>
</div>

<!--
Here is the master list of Jakob Nielsen's 10 Usability Heuristics.

Every software engineer, product manager, and designer should have these ten principles memorized.

Notice the scope: from immediate feedback (NS01) to real-world metaphors (NS02), emergency escapes (NS03), consistency (NS04), preventing bugs before they happen (NS05), reducing cognitive memory load (NS06), power shortcuts (NS07), visual minimalism (NS08), friendly error recovery (NS09), and contextual documentation (NS10).

Let's dissect each heuristic with real-world examples.

To summarize this slide, remember this key takeaway: These ten heuristics cover feedback, cognitive load, error resilience, and operational efficiency across all software tiers.
-->
---
## NS01: Visibility of System Status

* **Heuristic Principle:**
  > "The system should always keep users informed about what is going on, through appropriate feedback within a reasonable time."
* **Core Interaction Patterns:**
  - **Immediate Touch Feedback:** Active button states, ripple effects, and micro-animations validating input registration.
  - **Progress Transparency:** Deterministic progress bars (% complete), multi-step checkout steppers (1. Cart &rarr; 2. Shipping &rarr; 3. Payment).
  - **Background Task Feedback:** Spinners with descriptive, dynamic status copy (*"Uploading image 3 of 5..."*).
  - **Connection State Indicators:** Real-time online/offline banners and live synchronization indicators.

<!--
Heuristic 1: Visibility of System Status.

Nothing induces user anxiety faster than clicking a button and seeing absolutely nothing happen. Did the transaction go through? Did the app crash? Should I click it again and risk double-billing?

Software must provide immediate feedback. If an operation takes less than 1 second, a subtle animation is fine. If it takes several seconds, provide an explicit percentage progress bar. For multi-step workflows, show a breadcrumb stepper.

To summarize this slide, remember this key takeaway: Continuous, timely visual feedback eliminates user anxiety and prevents duplicate submission errors.
-->
---
<!-- _class: title-image-slide -->
## NS01 in Practice: System Status & Real-Time Feedback

<div class="image-wrapper">
  <img src="../../img/ux/ns01_status_feedback_examples.png" alt="Status Feedback Examples" />
</div>

<!--
Look at these concrete implementations of system status visibility.

Notice the distinct patterns: a linear percentage progress bar informing users of background download duration, step-by-step breadcrumb steppers guiding a multi-page checkout flow, and tactile button depression animations.

Every interaction state is explicitly communicated. The user is never left guessing whether their action was registered.

To summarize this slide, remember this key takeaway: Visual feedback across buttons, spinners, and progress steppers keeps users continuously oriented.
-->
---
## NS02: Match Between System and the Real World

* **Heuristic Principle:**
  > "The system should speak the users' language, with words, phrases, and concepts familiar to the user, rather than system-oriented terms. Follow real-world conventions."
* **Natural Spatial Mapping (Natural Mapping):**
  - Controls should mirror the physical arrangement of the objects they manipulate.
  - *Classic Counter-Example:* Gas stove burner knobs arranged in a straight line for a 2x2 grid force mental translation and errors.
  - *Good Design:* Arranging 4 knobs in the exact same 2x2 layout as the burners makes operation instantaneous and error-free.
* **Familiar Conceptual Metaphors:**
  - Trash can for deletions, desktop folder icons for directory trees, and shopping carts for e-commerce purchases.

<!--
Heuristic 2: Match Between System and the Real World.

Software should adopt metaphors and spatial arrangements that humans already understand from physical life. Think of the trash can icon on your desktop, the shopping cart in e-commerce, or the folder hierarchy.

Examine the gas stove example on the upcoming slide: when 4 knobs are arranged in a straight line, your brain has to perform mental translation to determine which knob controls which burner. But when the knobs mirror the physical 2x2 layout, interaction is instinctive.

To summarize this slide, remember this key takeaway: Map digital controls directly to physical spatial layouts and everyday human vocabulary.
-->
---
<!-- _class: title-image-slide -->
## NS02 in Practice: Natural Spatial Mapping of Controls

<div class="image-wrapper">
  <img src="../../img/ux/ns02_mapping_gas_stove.png" alt="Gas Stove Natural Mapping" />
</div>

<!--
Examine this classic demonstration of natural mapping.

On the left, four knobs are arranged in a single horizontal row for a 2x2 burner stove. Users must read labels or mentally calculate which knob controls which burner—inevitably resulting in burning the wrong pot!

On the right, arranging the knobs in the identical 2x2 matrix makes operation subconscious and completely error-free.

To summarize this slide, remember this key takeaway: When digital controls mirror real-world spatial geometries, mental translation friction drops to zero.
-->
---
## NS03: User Control & Freedom (Emergency Exits)

* **Heuristic Principle:**
  > "Users often choose system functions by mistake and will need a clearly marked 'emergency exit' to leave the unwanted state without having to go through an extended dialogue."
* **Essential Implementation Patterns:**
  - **Universal Undo / Redo:** Support `Ctrl+Z` / `Cmd+Z` across all text editors, canvas tools, and destructive state changes.
  - **Cancelation Actions:** Provide clear, high-contrast "Cancel" buttons on modals, file uploads, and bulk operations.
  - **Non-Destructive Navigation:** Allow users to back out of a checkout or registration wizard without wiping previously entered form data.
  - **Soft Deletes:** Move deleted items to a "Trash Bin" with a 30-day restoration window before permanent deletion.

<!--
Heuristic 3: User Control and Freedom.

Humans are curious, but they are also prone to accidental clicks. If an interface makes users terrified that a single misclick will permanently delete their data or finalize an unwanted purchase, they become hesitant and anxious.

Provide obvious emergency exits! Every modal dialog must have an escape key or close icon. Every destructive action should provide an immediate 'Undo' toast notification.

When users know they can easily undo any mistake, they explore features freely and confidently.

To summarize this slide, remember this key takeaway: Clear emergency exits and universal undo mechanisms empower users to explore software without fear of irreversible mistakes.
-->
---
<!-- _class: title-image-slide -->
## NS03 in Practice: User Control, Freedom & Emergency Exits

<div class="image-wrapper">
  <img src="../../img/ux/ns03_user_control.jpg" alt="User Control and Freedom" />
</div>

<!--
Look at these interaction safeguards on screen.

Notice the prominent 'Cancel' button next to the primary action, the ubiquitous 'Undo' toast appearing after deletion, and the escape cross on modal dialogs.

Users never feel trapped in an unrecoverable state. They know that if their finger slips, they can instantly revert the action with a single tap.

To summarize this slide, remember this key takeaway: Prominent emergency exits and undo options provide a psychological safety net for user exploration.
-->
---
## NS04: Consistency & Standards (Jakob's Law)

* **Heuristic Principle:**
  > "Users should not have to wonder whether different words, situations, or actions mean the same thing. Follow platform and industry conventions."
* **Jakob's Law of Internet User Experience:**
  - Users spend 99% of their digital lives on **other websites and apps**.
  - They expect your software to follow established conventions (e.g., logo at top-left returns home, shopping cart at top-right, magnifying glass indicates search).
* **Two Dimensions of Consistency:**
  - **Internal Consistency:** Uniform fonts, button styles, padding, and terminology across your own app (Design Systems).
  - **External Consistency:** Adhering to platform standards (Apple HIG for iOS, Material Design for Android).

<!--
Heuristic 4: Consistency and Standards.

Engineers and junior designers often succumb to the urge to reinvent the wheel—putting navigation menus at the bottom-right or using novel icons for shopping carts.

Jakob Nielsen formulated Jakob's Law: Remember that your users spend 99% of their screen time on other applications! When they arrive at your app, they transfer their existing habits and expectations.

Respect platform standards. Use design tokens to ensure internal consistency across your product suite.

To summarize this slide, remember this key takeaway: Adhering to platform conventions and internal design systems minimizes cognitive friction and speeds user onboarding.
-->
---
<!-- _class: title-image-slide -->
## NS04 in Practice: Standardized Conventions & Metaphors

<div class="image-wrapper">
  <img src="../../img/ux/ns04_standards.jpg" alt="Consistency and Standards" />
</div>

<!--
Observe these universal interface conventions.

Top-left logos link back to the homepage. Shopping carts reside in the upper right. Search inputs display magnifying glasses. System icons—like gear for settings and bell for notifications—are instantly understood worldwide.

When your application complies with these platform standards, first-time users can navigate immediately with zero training.

To summarize this slide, remember this key takeaway: Conform to industry-standard UI conventions so users can leverage familiar existing mental models.
-->
---
## NS05: Error Prevention

* **Heuristic Principle:**
  > "Even better than good error messages is a careful design which prevents a problem from occurring in the first place."
* **Defensive Design Patterns:**
  - **Eliminate Error-Prone States:** Grey out or disable the "Submit" button until all mandatory fields pass real-time validation.
  - **Input Constraints:** Use visual Date Pickers instead of freeform text boxes to prevent date formatting syntax errors (`MM/DD/YYYY` vs. `DD/MM/YYYY`).
  - **Confirmation for Irreversible Actions:** Display high-friction confirmation dialogs before permanent actions (e.g., typing the repository name to delete a GitHub repo).
  - **Intelligent Defaults:** Pre-fill sensible default parameters to eliminate blank-form intimidation.

<!--
Heuristic 5: Error Prevention.

Writing a polite error message after the user fails is good; designing the interface so the user cannot fail in the first place is brilliant engineering.

Why let a user type a date into a raw text box and then yell at them for using slashes instead of dashes? Give them a constrained date picker widget!

For catastrophic actions—like deleting a production database—introduce intentional friction, such as requiring the user to type the database name explicitly.

To summarize this slide, remember this key takeaway: Prevent errors by constraining inputs, validating fields in real time, and requiring explicit confirmation for destructive actions.
-->
---
<!-- _class: title-image-slide -->
## NS05 in Practice: Confirmation Dialogs & Destructive Safeguards

<div class="image-wrapper">
  <img src="../../img/ux/ns05_confirmation_dialogs.png" alt="Confirmation Dialogs" />
</div>

<!--
Examine GitHub's famous repository deletion confirmation dialog on this slide.

Notice the intentional friction: GitHub does not simply offer an 'OK' button. It requires the developer to explicitly type out the repository name before the destructive delete button activates.

This makes accidental catastrophic deletions virtually impossible. Slips and lapses are caught before any bytes are destroyed.

To summarize this slide, remember this key takeaway: Use high-friction confirmation safeguards to protect users from irreversible mistakes on destructive actions.
-->
---
## NS06: Recognition Rather Than Recall

* **Heuristic Principle:**
  > "Minimize the user's memory load by making objects, actions, and options visible. The user should not have to remember information from one part of the dialogue to another."
* **Cognitive Psychology Foundation:**
  - **Recognition (Easy):** Identifying something you have seen before when presented with visual cues (e.g., multiple-choice quiz).
  - **Recall (Hard):** Retrieving information entirely from memory without assistance (e.g., blank-slate command line terminal).
* **UI Implementations:**
  - Autocomplete search dropdowns displaying recent search keywords.
  - Visual thumbnails of recently edited documents instead of raw filenames.
  - Contextual action toolbars appearing when text is selected.

<!--
Heuristic 6: Recognition Rather Than Recall.

Human working memory is extremely limited—capable of holding only about 4 to 7 chunks of information at once.

Recognition is cognitively cheap: when you see a familiar icon or recent search history, your brain recognizes it instantly. Recall is cognitively expensive: forcing a user to remember a customer ID code from screen 1 to paste into screen 3 creates intense mental friction.

Keep options, previous inputs, and action buttons visible in the user's immediate visual field.

To summarize this slide, remember this key takeaway: Reduce working memory load by surfacing recent history, contextual suggestions, and visible interaction options.
-->
---
<!-- _class: title-image-slide -->
## NS06 in Practice: Recognition Over Recall & Search History

<div class="image-wrapper">
  <img src="../../img/ux/ns06_search_keyword_retention.png" alt="Recent Search Retention" />
</div>

<!--
Look at this modern search interface pattern.

When the user taps the search input, they are not confronted with a blank screen. Instead, the interface displays their recent searches, popular trending topics, and auto-complete suggestions.

The user's brain simply recognizes what they were looking for, avoiding the cognitive effort of recalling and typing out the full query again.

To summarize this slide, remember this key takeaway: Surfacing recent history and visual suggestions transforms difficult recall into effortless recognition.
-->
---
## NS07: Flexibility & Efficiency of Use (Accelerators)

* **Heuristic Principle:**
  > "Accelerators—unseen by the novice user—may often speed up the interaction for the expert user such that the system can cater to both inexperienced and experienced users."
* **Dual-Track Interaction Design:**
  - **Novice Path:** Guided visual menus, onboarding tours, wizard steppers, and descriptive labels.
  - **Expert Accelerators:** Keyboard shortcuts (`Cmd+K` command palette), multi-touch gestures, reusable templates, and batch actions.
* **Progressive Mastery:**
  - Display keyboard shortcut hints directly inside dropdown menus, enabling novices to gradually transition into power users.

<!--
Heuristic 7: Flexibility and Efficiency of Use.

Great software caters gracefully to both first-time novices and daily power users.

A novice needs clear labels, large buttons, and guided step-by-step wizards. A power user—like an accountant or software engineer—finds clicking through five modal screens agonizingly slow.

Provide accelerators: command palettes like Cmd+K, keyboard hotkeys, and macro snippets. Novices never need to know the hotkeys exist, but power users will love you for them.

To summarize this slide, remember this key takeaway: Provide accelerators and shortcuts that allow power users to operate at peak speed without confusing novice users.
-->
---
<!-- _class: title-image-slide -->
## NS07 in Practice: Keyboard Shortcuts & Power-User Accelerators

<div class="image-wrapper">
  <img src="../../img/ux/ns07_keyboard_shortcuts_snippets.png" alt="Keyboard Shortcuts and Snippets" />
</div>

<!--
Examine the power-user accelerators shown here:

Notice the `Cmd+K` command palette in modern developer tools, allowing instant fuzzy searching across hundreds of actions without leaving the keyboard.

Notice also how menu items display subtle grey shortcut badges next to commands (`Cmd+S`, `Cmd+Shift+P`). As novices browse menus, they subconsciously memorize hotkeys and graduate into expert users.

To summarize this slide, remember this key takeaway: Accelerators like command palettes and hotkeys dramatically elevate power-user velocity while remaining invisible to novices.
-->
---
## NS08: Aesthetic & Minimalist Design

* **Heuristic Principle:**
  > "Dialogues should not contain information which is irrelevant or rarely needed. Every extra unit of information in a dialogue competes with the relevant units of information and diminishes their relative visibility."
* **The Signal-to-Noise Ratio (SNR):**
  - **Signal:** Information directly relevant to the user's immediate decision.
  - **Noise:** Visual clutter, redundant borders, unnecessary badges, decorative chrome.
* **Technique: Progressive Disclosure (漸進式揭露):**
  - Show only the primary, essential controls upfront.
  - Tuck advanced settings behind "Advanced Options" accordions or secondary tabs.

<!--
Heuristic 8: Aesthetic and Minimalist Design.

Minimalism in UX does not mean making everything stark white or hiding features completely. It means maximizing the Signal-to-Noise ratio.

Every extra word, decorative border, or irrelevant banner competes for the user's finite visual attention.

Use Progressive Disclosure: show users what they need right now to complete the current step, and hide advanced configuration parameters behind an 'Advanced' accordion.

To summarize this slide, remember this key takeaway: Eliminate visual noise and use progressive disclosure to keep user attention focused on primary tasks.
-->
---
<!-- _class: title-image-slide -->
## NS08 in Practice: Minimalist Clarity vs Information Overload

<div class="image-wrapper">
  <img src="../../img/ux/ns08_excessive_info_gates.png" alt="Minimalist vs Cluttered Gates" />
</div>

<!--
Look at this striking comparison on screen.

On the left, an old-fashioned portal screen is overwhelmed with dozens of competing widgets, blinking banners, and links. The signal-to-noise ratio is catastrophically low.

On the right, modern minimalist design spotlights the primary action with ample whitespace, clean visual hierarchy, and zero decorative clutter.

To summarize this slide, remember this key takeaway: Clean visual hierarchy and generous whitespace maximize the visibility of primary user goals.
-->
---
## NS09: Help Users Recognize, Diagnose, & Recover from Errors

* **Heuristic Principle:**
  > "Error messages should be expressed in plain language (no codes), precisely indicate the problem, and constructively suggest a solution."
* **The Anatomy of a Terrible Error Message:**
  - ❌ *"Error 0x80004005: Unexpected runtime exception in thread main."* (Terrifies the user; completely unhelpful).
* **The Anatomy of a Great Error Message:**
  - ✅ **Plain Language:** *"We couldn't charge your credit card."*
  - ✅ **Precise Cause:** *"The expiration date entered (05/23) is in the past."*
  - ✅ **Constructive Recovery:** *"Please enter an updated expiration date or choose a different payment method [Update Card]."*

<!--
Heuristic 9: Helping Users Recover from Errors.

When an error occurs, the user is already in a vulnerable state. Never display raw stack traces, hex memory dumps, or generic HTTP error codes.

A proper error message contains three components: First, plain language explaining what went wrong. Second, the precise reason why it happened. Third, a constructive next step or clickable button to fix it.

Notice how modern websites turn a 404 Page Not Found into a helpful recovery portal with search bars and popular links.

To summarize this slide, remember this key takeaway: Deliver plain-language error messages that clearly state the cause and provide direct, actionable recovery paths.
-->
---
<!-- _class: title-image-slide -->
## NS09 in Practice: Constructive Error Recovery & Helpful 404s

<div class="image-wrapper">
  <img src="../../img/ux/ns09_error_404_recovery.png" alt="Friendly 404 Recovery" />
</div>

<!--
Observe this empathetic 404 error page implementation.

Instead of displaying a blank page with a terrifying '404 Bad Request' code, the application uses friendly language, acknowledges that the link might have moved, and immediately provides helpful recovery options: a search box and a button to return to the dashboard.

An error state is transformed into an effortless, reassuring recovery path.

To summarize this slide, remember this key takeaway: Empathetic error designs explain the issue in plain language and offer immediate, one-click recovery routes.
-->
---
## NS10: Help and Documentation

* **Heuristic Principle:**
  > "Even though it is better if the system can be used without documentation, it may be necessary to provide help and documentation. Any such information should be easy to search, focused on the user's task, list concrete steps to be carried out, and not be too large."
* **Modern Documentation Paradigms:**
  - **Contextual Tooltips:** Inline `?` icons explaining complex form requirements on hover.
  - **Interactive Onboarding Tours:** Lightweight, multi-step interactive walkthroughs highlighting key UI areas for first-time signups.
  - **Searchable Task-Oriented Help Centers:** Documentation organized by customer goals rather than internal system architecture.

<!--
Heuristic 10: Help and Documentation.

The ultimate goal of interaction design is a system so intuitive that nobody reads the manual. But for complex enterprise platforms, good documentation is indispensable.

Modern documentation is contextual and embedded directly inside the application: microcopy tooltips, interactive product tours, and searchable knowledge bases organized around user tasks rather than internal API modules.

To summarize this slide, remember this key takeaway: Provide searchable, task-focused documentation and contextual microcopy embedded directly within user workflows.
-->
---
<!-- _class: title-image-slide -->
## NS10 in Practice: Contextual Help & Interactive Onboarding

<div class="image-wrapper">
  <img src="../../img/ux/ns10_onboarding_tutorial_modes.png" alt="Interactive Onboarding Modes" />
</div>

<!--
Look at this interactive onboarding pattern.

Instead of forcing users to read a 50-page PDF manual before they can touch the software, the app uses progressive onboarding: interactive spotlights and contextual tooltips that introduce features right when the user reaches them in their flow.

Learning happens organically through doing, not passive reading.

To summarize this slide, remember this key takeaway: Embed contextual tooltips and interactive walkthroughs directly within user tasks to enable progressive learning.
-->
---
## Concept Check Question 2: Usability Heuristics

When designing an e-commerce checkout flow, a team replaces raw text date inputs with an interactive calendar picker and automatically disables the "Place Order" button until all required shipping addresses pass validation. Which Nielsen Heuristic is primarily demonstrated?

- **A.** NS01: Visibility of System Status.
- **B.** NS05: Error Prevention.
- **C.** NS07: Flexibility and Efficiency of Use.
- **D.** NS10: Help and Documentation.

<!--
Let's check our understanding of Nielsen's Usability Heuristics.

Analyze the team's actions: replacing freeform text with a constrained picker, and disabling the submit button until validation rules are satisfied.

Identify which heuristic governs preventing user mistakes before they occur.
-->
---
## Concept Check Question 2: Answer & Explanation

- **Correct Answer: B**
- **Explanation:**
  - Nielsen's **NS05: Error Prevention** states that careful design which prevents mistakes from occurring in the first place is far superior to even the best error messages.
  - Using a constrained calendar picker prevents invalid date formatting errors, and disabling the submit button until required fields are filled prevents invalid submission attempts before they happen.
  - *Why others are incorrect:* NS01 deals with status feedback (progress bars, spinners). NS07 deals with power accelerators (shortcuts). NS10 deals with help guides and documentation.

<!--
The correct answer is B.

Constraining input widgets and validating fields before submission embodies Error Prevention. You eliminate the possibility of invalid input before the user can make a mistake.

To summarize this slide, remember this key takeaway: Proactive input constraints and disabled invalid actions exemplify heuristic NS05: Error Prevention.
-->
---
<!-- _class: lead -->
<!-- header: '6.3 AI for UX (AI4UX)' -->

# **6.3 AI for UX (AI4UX): Amplifying Design Workflows**

> "AI will not replace UX designers, but UX designers who use AI will replace those who do not."

<!--
We now transition into Part 2: AI-Powered UX and Interaction Design.

In Module 6.3, we explore AI for UX (AI4UX). How can software engineers and designers leverage Large Language Models, generative image tools, and autonomous AI agents to dramatically accelerate the UX design lifecycle?

We introduce the RTCF prompt engineering framework, explore synthetic persona generation, examine automated heuristic evaluation audits, and look at multi-agent design systems.

To summarize this slide, remember this key takeaway: AI for UX utilizes generative intelligence as a cognitive co-designer to rapidly prototype, critique, and optimize interfaces.
-->
---
## What is AI for UX (AI4UX)?

* **The AI-Amplified Designer:**
  - Generative AI acts as a **cognitive partner and speed multiplier** across every stage of the design thinking process.
* **Core Application Areas:**
  - **Research & Empathy:** Generating diverse synthetic user personas, simulating edge-case user interviews.
  - **Ideation & Copywriting:** Rapidly generating microcopy variations, localization strings, and accessibility alt text.
  - **Automated Heuristic Audits:** Feeding UI screenshots to multimodal LLMs to identify Nielsen heuristic violations.
  - **Generative Prototyping:** Text-to-wireframe and text-to-code pipelines (v0, Figma AI, Galileo).

<!--
What is AI for UX?

It is the practice of using generative AI tools to amplify the speed, depth, and quality of user experience work.

Instead of spending weeks drafting user personas or writing dozens of button microcopy variations by hand, designers use LLMs to generate high-quality drafts in seconds.

Furthermore, vision-language models can inspect UI mockups and conduct automated heuristic evaluations, identifying contrast failures or missing labels before human testing begins.

To summarize this slide, remember this key takeaway: AI for UX transforms generative models into rapid research, ideation, auditing, and prototyping partners.
-->
---
<!-- _class: title-image-slide -->
## AI for UX: The Augmented Human-AI Design Workflow

<div class="image-wrapper">
  <img src="../../img/ux/ai_for_ux_concept.png" alt="AI for UX Concept" />
</div>

<!--
Look at this visualization of the modern AI-augmented design workflow.

The human designer provides creative vision, strategic objectives, and empathetic evaluation. Generative AI tools and multi-agent copilots rapidly generate layout alternatives, accessibility audits, and boilerplate component code.

Design speed accelerates tenfold while human empathy and taste remain firmly in the driver's seat.

To summarize this slide, remember this key takeaway: AI for UX amplifies designer throughput without replacing human creativity and empathy.
-->
---
## The RTCF Prompt Engineering Framework for Designers

To get precise, professional UX output from AI models, avoid vague prompts (❌ *"Help me design a login page"*). Use the structured **RTCF Framework**:

* **R — Role (角色):**
  - Define the AI's persona and expertise (e.g., *"Act as a Lead UX Researcher specializing in accessibility and WCAG 2.1 AA standards."*).
* **T — Task (任務):**
  - Define the concrete objective (e.g., *"Conduct a heuristic evaluation of this mobile checkout wireframe."*).
* **C — Constraints (約束):**
  - Enforce domain rules (e.g., *"Evaluate strictly against Nielsen's Heuristics NS01, NS03, and NS05; target a 375px mobile viewport."*).
* **F — Format (格式):**
  - Specify the output structure (e.g., *"Provide results in a 4-column Markdown table: [Heuristic ID, Observed Issue, Severity (0-4), Concrete Fix Recommendation]."*).

<!--
Prompt engineering is an essential engineering skill.

Vague prompts generate vague, generic output. If you type 'Give me UX ideas for my app,' you get useless cliches.

Apply the RTCF framework:
Role: tell the model who it is—a senior accessibility specialist.
Task: tell it the exact assignment—audit this checkout screen.
Constraint: bind it to specific rules—Nielsen heuristics and mobile constraints.
Format: mandate a structured Markdown table with severity ratings.

Structured prompts yield production-grade design analysis.

To summarize this slide, remember this key takeaway: Master the RTCF framework—Role, Task, Constraint, and Format—to extract precise, actionable UX engineering outputs from LLMs.
-->
---
## Multi-Agent Prototyping & Generative UI

* **Autonomous Multi-Agent Architecture:**
  - Modern IDEs and agent systems (e.g., Antigravity, Devin, Claude Code) orchestrate specialized agents working in tandem.
  - **UX Research Agent:** Analyzes customer tickets and synthesizes user pain points.
  - **Design System Agent:** Generates CSS tokens, typography scales, and accessible color palettes.
  - **Frontend Code Agent:** Translates specifications into responsive HTML/CSS/React components.
* **The Human-in-the-Loop Safeguard:**
  - AI generates rapid prototypes; human engineers evaluate ergonomics, brand voice, and real user empathy.

<!--
Look at modern autonomous multi-agent engineering workflows.

In state-of-the-art environments like Google Antigravity, specialized agents collaborate: a research agent identifies user pain points, a design system agent generates consistent CSS variables, and a coding agent builds the executable UI component.

Notice the vital role of the human engineer: Human-in-the-Loop. The human provides taste, architectural judgment, and ethical oversight, validating that the generated interface truly delights real people.

To summarize this slide, remember this key takeaway: Multi-agent systems automate rapid UI code generation, with human designers providing critical architectural judgment and user empathy.
-->
---
<!-- _class: title-image-slide -->
## Multi-Agent Architecture: Collaborative Prototyping Pipelines

<div class="image-wrapper">
  <img src="../../img/ux/antigravity_agents_architecture.png" alt="Agents Architecture" />
</div>

<!--
Examine the multi-agent system architecture on this slide.

Notice how specialized autonomous agents coordinate: a research subagent ingests user requirements, a design subagent structures layout tokens, and a frontend implementation subagent drafts interactive code.

Crucially, review checkpoints feed back to the human developer before changes commit to production.

To summarize this slide, remember this key takeaway: Multi-agent architectures divide design challenges across specialized cognitive roles, unified by human review gates.
-->
---
<!-- _class: lead -->
<!-- header: '6.4 UX for AI (UX4AI)' -->

# **6.4 UX for AI (UX4AI): Designing Human-Centered AI**

> "The hardest part of building AI products is not training the model—it is designing the interface that makes probabilistic intelligence understandable, steerable, and trustworthy."

<!--
We now enter Module 6.4: UX for AI (UX4AI).

Notice the inversion! In the previous section, we used AI to help us design software (AI for UX). Now, we ask the opposite, profound question: How do we design the user experience OF an AI product? (UX for AI).

AI applications—such as ChatGPT, GitHub Copilot, Gemini, and autonomous agents—behave completely differently from traditional deterministic software. They are probabilistic. They suffer from latency, produce hallucinations, and possess opaque internal reasoning.

How do we adapt Nielsen's 10 Heuristics for the age of generative intelligence?

To summarize this slide, remember this key takeaway: UX for AI establishes the interaction design patterns required to make non-deterministic models steerable, transparent, and trustworthy.
-->
---
## Unique UX Challenges in AI-Native Products

* **1. Non-Determinism & Unpredictability:**
  - Traditional software: `2 + 2` always returns `4`.
  - AI systems: Submitting the identical prompt twice may yield completely different phrasing, tone, or formatting.
* **2. The "Hallucination" Dilemma:**
  - Generative models can generate completely fabricated facts, non-existent API methods, or fake citations with total syntactic confidence.
* **3. Latency & the "Thinking" Black Box:**
  - Complex reasoning models (e.g., o1, Gemini Thinking) require 5 to 30 seconds of inference time before returning a single token.
* **4. The Calibration of Trust:**
  - **Over-trust:** Users blindly accept false AI code without reviewing it, leading to production outages.
  - **Under-trust:** Users abandon the AI after a single minor mistake, losing all productivity benefits.

<!--
Why is designing interfaces for AI products so extraordinarily difficult?

Traditional software is deterministic: if you click Save, it writes bytes to disk. The mental model is mechanical and predictable.

AI is probabilistic. It hallucinates with absolute confidence. It suffers from inference latency. It can write flawless code on Monday and hallucinate an imaginary library on Tuesday.

The core challenge of UX for AI is trust calibration: helping users understand exactly what the AI can do, warning them of limitations, and making errors effortless to detect and fix.

To summarize this slide, remember this key takeaway: AI interaction design must manage non-determinism, hallucinations, latency, and calibrated user trust.
-->
---
## AI + NS01: Visibility of AI State & Thinking Traces

* **The Problem of AI Latency & Black Boxes:**
  - Long inference times (10-30s) leave users staring at blank screens, wondering if the server crashed.
* **Interaction Solutions:**
  - **Streaming Tokens:** Stream text responses token-by-token immediately, providing instant perceived performance.
  - **Collapsible Reasoning Traces:** Display interactive "Thinking Process" accordions showing internal reasoning steps and tool execution.
  - **RAG Grounding Citations:** Provide clickable source pills linking directly to retrieved reference documents.

<!--
Let's examine how Heuristic 1—Visibility of System Status—applies directly to modern AI products.

When an LLM takes 15 seconds to reason through a complex math or coding problem, staring at a static loading spinner makes users believe the application has frozen.

The solution is multi-faceted: stream tokens progressively, provide collapsible reasoning accordions that disclose the model's internal thinking steps, and display clickable citation pills for retrieved RAG chunks.

To summarize this slide, remember this key takeaway: Streaming text and collapsible reasoning accordions make probabilistic inference latency transparent and engaging.
-->
---
<!-- _class: title-image-slide -->
## AI + NS01 in Practice: Streaming Tokens & Collapsible Reasoning

<div class="image-wrapper">
  <img src="../../img/ux/ns01_thinking_process.jpg" alt="AI Thinking Process" />
</div>

<!--
Look at this state-of-the-art AI reasoning interface on screen.

Notice the collapsible 'Thought for 12 seconds' accordion. Users can expand it to inspect the AI's step-by-step logic, active tool invocations, and sub-queries.

Real-time token streaming gives immediate tactile feedback, completely eliminating perceived inference latency.

To summarize this slide, remember this key takeaway: Collapsible thinking accordions and token streaming transform opaque inference latency into engaging system status transparency.
-->
---
## AI + NS02 & NS03: Grounding, Control & Human Agency

* **AI + NS02 (Match with Real World):**
  - **Transparent Bot Identity:** Clearly disclose that the system is an AI assistant; avoid deceptive pseudo-human personas.
  - **Conversational Grounding:** Establish shared context using familiar conversational turns and natural language.
* **AI + NS03 (User Control & Freedom):**
  - **Stop Generation Button:** Provide an instant button to abort runaway or misdirected responses.
  - **Prompt Branching:** Allow users to edit previous prompts and fork alternative conversation threads.
  - **Steerability Sliders:** Provide controls for temperature, brevity, and response tone.

<!--
Heuristics 2 and 3 govern conversational grounding and human agency.

In NS02, software must never deceive users into believing they are talking to a human doctor or lawyer. Disclose AI identity clearly.

In NS03, human agency is paramount: users must have full steerability. If the AI begins outputting unwanted code, provide an immediate 'Stop Generating' button. Let users edit prior prompts to branch conversations without starting over from scratch.

To summarize this slide, remember this key takeaway: Maintain human agency with transparent identity disclosure, instant generation aborts, and prompt branching.
-->
---
<!-- _class: title-image-slide -->
## AI + NS03 in Practice: User Steerability & Cancelation Controls

<div class="image-wrapper">
  <img src="../../img/ux/ns_ai_03.jpg" alt="AI User Control and Freedom" />
</div>

<!--
Look at these steering mechanisms in modern LLM applications.

Notice the prominent 'Stop Generating' button active during inference, the hover edit button on past user messages allowing quick prompt rewrites, and the regenerative retry icon.

The human user remains completely in charge of the conversational direction at all times.

To summarize this slide, remember this key takeaway: Dedicated stop buttons, prompt edit forks, and regenerate options guarantee user control over non-deterministic AI outputs.
-->
---
## AI + NS05: Error Prevention & Agentic Guardrails

* **The Extreme Stakes of Agentic AI:**
  - Autonomous agents can execute shell commands, edit production code, and interact with external APIs.
  - An unchecked hallucination can delete files, drop database tables, or leak API keys.
* **Human-in-the-Loop (HITL) Guardrails:**
  - **Pre-Execution Confirmation:** Require explicit developer approval before running terminal commands or modifying files.
  - **Diff Previews:** Display color-coded git-style diffs showing exactly what lines the AI proposes to modify.
  - **Sandboxed Execution:** Run unverified AI code in isolated containers before applying changes to host environments.

<!--
Heuristic 5—Error Prevention—takes on life-or-death importance when dealing with autonomous AI agents.

An autonomous coding agent with terminal access can easily execute 'rm -rf' or overwrite critical configuration files if it hallucinates an incorrect shell command.

The gold standard pattern is Human-in-the-Loop confirmation: the agent proposes the plan and displays a git diff of proposed edits, but waits for the human engineer to click 'Approve' before executing.

To summarize this slide, remember this key takeaway: Human-in-the-loop confirmation guardrails protect software integrity against autonomous agent errors.
-->
---
<!-- _class: title-image-slide -->
## AI + NS05 in Practice: Human-in-the-Loop Confirmation & Diff Auditing

<div class="image-wrapper">
  <img src="../../img/ux/ns05_error_prevention.jpg" alt="AI Error Prevention Guardrails" />
</div>

<!--
Examine this agentic confirmation modal.

Before executing a terminal command or overwriting project files, the agent halts and presents a clear, readable diff alongside an explicit 'Run' or 'Cancel' choice.

The developer can inspect the exact bash command and file diff before any change touches their machine.

To summarize this slide, remember this key takeaway: Explicit pre-execution confirmation modals and diff previews prevent catastrophic autonomous agent mistakes.
-->
---
## AI + NS07 & NS10: Accelerators & Explainability (XAI)

* **AI + NS07 (Flexibility & Accelerators):**
  - **Slash Commands:** Quick keyboard triggers (`/explain`, `/refactor`, `/fix-tests`) allowing power users to bypass conversational typing.
  - **Multi-Modal Drag-and-Drop:** Allowing users to drag screenshots, PDF diagrams, and log files directly into the prompt box.
* **AI + NS10 (Explainable AI - XAI):**
  - **"Why this answer?":** Contextual tooltips explaining which source documents or prompt instructions triggered the recommendation.
  - **Model Cards & Confidence Meters:** Explicitly disclosing active model versions and estimated prediction confidence.

<!--
Finally, examine heuristics 7 and 10 in AI applications.

In NS07, power users don't want to type long polite sentences. They want slash commands: /test, /fix, /summarize. They want to drag an error screenshot directly into the chat pane.

In NS10, documentation evolves into Explainable AI. Users deserve to know why an AI made a loan decision or medical recommendation. Popovers disclosing retrieved documents and confidence scores build calibrated trust.

To summarize this slide, remember this key takeaway: Slash commands and multi-modal inputs accelerate expert workflows, while Explainable AI fosters calibrated trust.
-->
---
<!-- _class: title-image-slide -->
## AI + NS10 in Practice: Explainable AI & Contextual Citations

<div class="image-wrapper">
  <img src="../../img/ux/ns10_help_doc.jpg" alt="AI Transparency and Explainability" />
</div>

<!--
Observe these explainability patterns on screen.

Notice the numbered footnote citations and clickable document pills. When clicked, they disclose the exact passage retrieved from the knowledge base that grounded the AI's response.

Transparency transforms a mysterious AI black box into a verifiable, trustworthy engineering tool.

To summarize this slide, remember this key takeaway: Interactive citation pills and grounded reference popovers provide the transparency required for calibrated user trust.
-->
---
## Concept Check Question 3: UX for AI Design

When designing an autonomous AI coding assistant that can inspect directories, edit source files, and execute shell commands, which design pattern best fulfills **Error Prevention (NS05)** and **User Agency (NS03)**?

- **A.** Allowing the agent to execute all file deletions and shell scripts silently in the background without user interruption.
- **B.** Requiring explicit human-in-the-loop review and confirmation before executing high-risk file modifications or system terminal commands.
- **C.** Removing the ability to stop or cancel running background tasks once the AI begins executing code.
- **D.** Hiding all command execution logs from developers to avoid visual clutter and information overload.

<!--
Let's evaluate our understanding of human-centered AI design principles.

Consider the severe security and stability risks of autonomous agents interacting with local filesystems.

Identify the design pattern that protects the user while preserving human control.
-->
---
## Concept Check Question 3: Answer & Explanation

- **Correct Answer: B**
- **Explanation:**
  - Autonomous agents operating on codebases can introduce irreversible damage (e.g., recursive file deletion, dropping databases, running dangerous shell commands).
  - Fulfilling **NS05 (Error Prevention)** and **NS03 (User Control & Freedom)** requires a strict **Human-in-the-Loop (HITL)** architecture: the agent plans actions, but high-risk executions (modifying files, running shell scripts) mandate explicit developer preview and approval.
  - *Why others are incorrect:* Option A creates severe security and data-loss hazards. Option C directly violates User Control (NS03). Option D violates Visibility of System Status (NS01) by hiding critical execution logs.

<!--
The correct answer is B.

Autonomous AI agents must always maintain a Human-in-the-Loop guardrail. When an agent proposes destructive file edits or shell scripts, it must request explicit human confirmation.

To summarize this slide, remember this key takeaway: Human-in-the-loop confirmation guardrails protect software integrity against autonomous agent errors.
-->
---
<!-- _class: lead -->
<!-- header: '6.5 Evaluation & Synthesis' -->

# **6.5 Evaluation & Engineering Synthesis**

> "Evaluating usability with 5 users uncovers roughly 85% of all usability problems."
> — *Jakob Nielsen*

<!--
We conclude Chapter 6 with Module 6.5: Evaluation and Engineering Synthesis.

How do engineering teams rigorously evaluate interfaces before and after release?

In this final module, we examine formal Heuristic Evaluation methodology, learn Nielsen's 5-point severity rating scale, contrast expert heuristic audits with empirical user testing, test your knowledge with a fill-in-the-blank recap challenge, and review key engineering takeaways.

To summarize this slide, remember this key takeaway: Combine expert heuristic evaluations with empirical user testing to systematically eliminate usability flaws throughout the SDLC.
-->
---
## Conducting a Formal Heuristic Evaluation

* **What is a Heuristic Evaluation?**
  - A discount usability inspection method where independent evaluators examine an interface against established heuristics (e.g., Nielsen's 10).
* **Nielsen's 5-Point Severity Rating Scale:**
  - **0 = Not a usability problem:** Does not affect user progress.
  - **1 = Cosmetic problem only:** Minor visual blemish; fix only if extra time is available.
  - **2 = Minor usability problem:** Low priority; causes minor inconvenience but user can recover.
  - **3 = Major usability problem:** High priority; severely delays or confuses users; must be fixed before release.
  - **4 = Usability catastrophe:** Imperative to fix! Completely blocks task completion; software cannot ship!

<!--
How do you conduct a formal Heuristic Evaluation?

A group of 3 to 5 independent evaluators steps through every screen, checking each interaction against the 10 heuristics.

Every discovered problem is assigned a severity score from 0 to 4:
Level 0 is not a problem.
Level 1 is cosmetic—like a misaligned border.
Level 2 is minor.
Level 3 is major—like a confusing button label that misleads users.
Level 4 is a catastrophe—like a broken submit button that traps users in an infinite loop. Software cannot ship with Level 4 flaws!

To summarize this slide, remember this key takeaway: Prioritize usability defect remediation using Nielsen's 5-point severity rating scale.
-->
---
## Heuristic Evaluation vs. Empirical User Testing

| Dimension | Heuristic Evaluation (專家啟發式評估) | Empirical User Testing (真實使用者易用性測試) |
| :--- | :--- | :--- |
| **Evaluators** | 3 to 5 UX Experts / Senior Engineers | 5 Real Representative End-Users |
| **When to Use** | Early in design (wireframes, early prototypes) | Later in development (interactive prototypes, staging) |
| **Cost & Speed** | Extremely fast (1–2 days); low financial cost | Slower (1–2 weeks); requires recruitment and lab setup |
| **Primary Strength** | Quickly finds obvious heuristic violations & edge cases | Reveals authentic human behavioral friction & surprises |
| **Limitation** | Experts can miss domain-specific workflow quirks | Users reveal *what* broke, but not always *why* or *how to fix* |

<!--
Compare Heuristic Evaluation with Empirical User Testing.

Heuristic evaluation is fast, cheap, and conducted by internal experts early in the design cycle. It catches 75% of obvious layout, consistency, and status feedback mistakes before any code is built.

User testing puts the product in front of actual customers. It takes more time and money, but reveals authentic human behavior that experts never anticipate.

Both techniques are complementary: run heuristic audits first to clean up obvious flaws, then run user testing to validate real workflows.

To summarize this slide, remember this key takeaway: Use heuristic audits early for rapid defect discovery, and user testing later to validate authentic customer workflows.
-->
---
## Chapter Recap: Fill-in-the-Blank Challenge

Test your mastery of the core concepts in Chapter 6:

* **1.** A door with a pull handle that must be pushed to open is famously known as a **`___`** Door.
* **2.** **`___`** Law states that users spend most of their time on other websites, expecting your site to follow common conventions.
* **3.** Nielsen Heuristic **`___`** states that preventing mistakes beforehand is vastly superior to displaying polite error messages.
* **4.** The prompt engineering framework for designers consisting of Role, Task, Constraint, and Format is abbreviated **`___`**.
* **5.** In AI interfaces, displaying streaming tokens and collapsible reasoning steps exemplifies heuristic **`___`**: Visibility of System Status.
* **6.** On Nielsen's severity rating scale, a usability defect that completely blocks task completion and prevents product release is rated as a **`___`**.

<!--
Let's review the core concepts and principles from Chapter 6.

Take a moment to mentally fill in the blanks across all six questions.
-->
---
## Chapter Recap: Solution Key

Here are the completed principles and technical terms:

* **1.** A door with a pull handle that must be pushed to open is famously known as a **Norman** Door.
* **2.** **Jakob's** Law states that users spend most of their time on other websites, expecting your site to follow common conventions.
* **3.** Nielsen Heuristic **NS05: Error Prevention** states that preventing mistakes beforehand is vastly superior to displaying polite error messages.
* **4.** The prompt engineering framework for designers consisting of Role, Task, Constraint, and Format is abbreviated **RTCF**.
* **5.** In AI interfaces, displaying streaming tokens and collapsible reasoning steps exemplifies heuristic **NS01**: Visibility of System Status.
* **6.** On Nielsen's severity rating scale, a usability defect that completely blocks task completion and prevents product release is rated as a **4 (Catastrophe)**.

<!--
Here is the solution key.

1. Norman Door.
2. Jakob's Law.
3. NS05 Error Prevention.
4. RTCF Framework.
5. NS01 Visibility of System Status.
6. Severity Level 4: Usability Catastrophe.

To summarize this slide, remember this key takeaway: These core principles form the foundation of professional human-computer interaction and AI interface design.
-->
---
## Chapter Summary & Engineering Takeaways

* **1. Human Psychology Precedes Code:**
  - Excellent software engineers design for human cognitive limits (working memory, emotional frustration, mental models).
  - When users stumble, fix the interface affordances rather than blaming user competence.
* **2. Internalize Nielsen's 10 Heuristics:**
  - Make status visible (NS01), match real-world metaphors (NS02), offer undo exits (NS03), adhere to standards (NS04), prevent errors proactively (NS05), and write constructive error messages (NS09).
* **3. Master AI-Augmented Design (AI4UX & UX4AI):**
  - Use structured RTCF prompting to accelerate research, prototyping, and automated heuristic audits.
  - Design AI products for calibrated trust: stream tokens, show reasoning traces, mandate human confirmations for agentic actions, and provide in-place error recovery.

<!--
To conclude Chapter 6, remember that technology is only as powerful as the human experience it enables.

You can write flawless, concurrent backend algorithms, but if your users cannot understand what the software is doing, your engineering efforts will go to waste.

Master Nielsen's 10 heuristics. Empathize with real users. Leverage AI to accelerate your design workflows, and design your AI products with transparency, control, and human dignity.

To summarize this slide, remember this key takeaway: Great engineering marries technical structural rigor with empathetic, intuitive human-centered design.
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
