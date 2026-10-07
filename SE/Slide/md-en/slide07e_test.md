---
marp: true
theme: ase-theme
paginate: true
header: 'Software Engineering | Chapter 7: Software Testing'
footer: 'Prof. Nien-Lin Hsueh'
---

<!-- _class: lead -->
<!-- header: '' -->

# **Software Engineering**

### Chapter 7: Software Testing & Quality Verification

**Prof. Nien-Lin Hsueh**
Department of Information Engineering and Computer Science
Feng Chia University

<!--
Welcome to Chapter 7: Software Testing and Quality Verification.

In software engineering, writing code is only half the battle. Delivering a dependable, production-ready system requires rigorous, repeatable, and scientific verification techniques. Testing is not a haphazard search for bugs—it is a structured discipline governed by mathematical principles, input partition strategies, and structural coverage models.

In this unified chapter, we will master the entire testing spectrum. We start with foundational testing principles and Dijkstra's famous axiom, progress through black-box specification-based methods like Boundary Value Analysis and Equivalence Partitioning, dive into combinatorial Pairwise testing, and conclude with white-box structural coverage criteria—from statement and branch coverage to avionics-grade MC/DC and basis path analysis.

To summarize this slide, remember this key takeaway: Software testing is a disciplined engineering practice designed to systematically uncover defects and verify customer requirements.
-->
---
<!-- _class: outline-slide -->

## Chapter 7: Roadmap & Core Curriculum

<div class="outline-columns">
  <div>
    <h3>Part 1: Principles & Black-Box Testing</h3>
    <ul>
      <li><b>7.1 Testing Foundations & Principles:</b> Verification vs. Validation, Dijkstra's axiom, 7 testing principles, testing pyramid, testing stages.</li>
      <li><b>7.2 Black-Box Testing Techniques:</b> Boundary Value Analysis formulas ($4n+1, 6n+1, 5^n, 7^n$), Equivalence Partitioning (Weak vs. Strong), case studies: Triangle, Exam Scores, FCU Swimming Pool, Binary Search, nextDate.</li>
      <li><b>7.3 Combinatorial & Behavioral Methods:</b> Pairwise/All-Pairs testing, Decision Table testing, State Transition and Use Case testing.</li>
    </ul>
  </div>
  <div>
    <h3>Part 2: White-Box Structural Testing & Synthesis</h3>
    <ul>
      <li><b>7.4 White-Box Structural Testing:</b> Subsumption hierarchy, benchmark code analysis, Statement, Branch, and Condition Coverage, short-circuit evaluation.</li>
      <li><b>7.5 Advanced Criteria & Control Flow:</b> Multiple Condition Coverage, MC/DC in DO-178B/C, loop path explosion, McCabe's Cyclomatic Complexity.</li>
      <li><b>7.6 Testing Synthesis & Anti-Patterns:</b> The myth of 100% coverage, comprehensive benchmark comparison, recap quiz, and industry best practices.</li>
    </ul>
  </div>
</div>

<!--
Here is our roadmap for Chapter 7.

On the left, in Part 1, we establish the foundational philosophy of software verification and explore black-box specification-based techniques. You will learn the exact mathematical formulas for boundary value analysis and study concrete real-world cases like triangle classification, binary search, and calendar boundary calculation.

On the right, in Part 2, we open the glass box to examine internal source code structure. Using a standard benchmark program, we will rigorously compare statement, branch, condition, MC/DC, and basis path coverage, finishing with a critical evaluation of testing anti-patterns.

To summarize this slide, remember this key takeaway: Master both black-box functional testing and white-box structural testing to build a comprehensive, multi-layered quality assurance strategy.
-->
---
<!-- _class: lead -->
<!-- header: '7.1 Testing Foundations & Principles' -->

# **7.1 Software Testing Foundations & Principles**

> "Program testing can be used to show the presence of bugs, but never to show their absence!"
> — *Edsger W. Dijkstra*

<!--
We begin with Module 7.1: Software Testing Foundations and Principles.

Before writing a single test case, every engineer must understand what testing can and cannot achieve. As computer science pioneer Edsger Dijkstra famously pointed out, testing reveals the presence of flaws, but cannot mathematically prove that no bugs remain.

In this section, we examine the distinction between Verification and Validation, explore the seven fundamental principles of testing, inspect the spectrum of testing types, and analyze the classic Software Testing Pyramid.

To summarize this slide, remember this key takeaway: Testing provides empirical evidence of defect presence, establishing confidence in software behavior under bounded constraints.
-->
---
## Testing Objectives: Verification vs. Validation (V&V)

* **Verification ("Are we building the product right?"):**
  - Confirms that software artifacts conform to their technical specifications, architecture designs, and coding standards.
  - Typical techniques: static code analysis, inspections, code reviews, and automated unit test suites.
* **Validation ("Are we building the right product?"):**
  - Demonstrates that the executable system satisfies actual customer needs, operational workflows, and business goals.
  - Typical techniques: user acceptance testing (UAT), customer demos, and beta testing.
* **Two Complementary Testing Goals:**
  1. **Validation Testing:** Demonstrates to stakeholders that the system performs its specified functions correctly under normal inputs.
  2. **Defect Testing:** Intentionally submits invalid, boundary, or hostile inputs to break the system and expose latent flaws.

<!--
Let's distinguish Verification from Validation—the twin pillars of software quality assurance.

Verification asks: 'Are we building the product right?' It checks if the code conforms to specifications, design documents, and structural constraints.

Validation asks: 'Are we building the right product?' It confirms whether the system actually fulfills the customer's true operational needs.

Notice the two operational goals: validation testing proves the happy path works, while defect testing actively tries to break the software to discover hidden failure modes.

To summarize this slide, remember this key takeaway: Verification confirms conformity to specifications, while validation confirms satisfaction of real user needs.
-->
---
## 7 Core Software Testing Principles (Part 1)

* **1. Testing Shows Presence of Defects (Dijkstra's Axiom):**
  - Testing proves that bugs exist within an application; it can never prove that software is 100% defect-free.
* **2. Exhaustive Testing is Impossible:**
  - Testing every possible combination of inputs, memory states, and preconditions is computationally infeasible.
  - Engineers must employ risk-based sampling, boundary analysis, and equivalence partitioning.
* **3. Early Testing (The "Shift-Left" Movement):**
  - Testing activities must begin as early as requirements engineering and architectural design.
  - Catching defects during requirements is 10 to 100 times cheaper than fixing them in post-deployment production.
* **4. Defect Clustering (The Pareto Principle / 80-20 Rule):**
  - In most software systems, roughly 80% of all discovered bugs originate from 20% of the core modules.
  - Modules with high cyclomatic complexity, frequent churn, or tight coupling harbor the vast majority of flaws.

<!--
The International Software Testing Qualifications Board formalizes seven timeless principles.

Principle 1 is Dijkstra's axiom: testing demonstrates bugs are present, not absent.

Principle 2 states that exhaustive testing is impossible. A simple form with three integer inputs has over 70 trillion combinations! We must sample intelligently.

Principle 3 is Shift-Left: find errors early in requirements and design when fixing them costs pennies instead of thousands of dollars.

Principle 4 is defect clustering: bugs love company. 80% of defects concentrate in the 20% most complex modules.

To summarize this slide, remember this key takeaway: Intelligent sampling, early defect detection, and targeting high-risk defect clusters yield the highest testing return on investment.
-->
---
## 7 Core Software Testing Principles (Part 2)

* **5. Beware of the Pesticide Paradox:**
  - Running the exact same automated test suite repeatedly will eventually stop finding new defects.
  - Just as agricultural pests develop resistance to pesticides, software defects evade repetitive tests; test suites must continually evolve, mutate, and expand.
* **6. Testing is Context Dependent:**
  - No single testing strategy fits all projects.
  - An e-commerce mobile application emphasizes rapid deployment, usability, and checkout funnel speed; a medical pacemaker or avionics flight controller demands rigorous formal proofs and MC/DC certification.
* **7. Absence-of-Errors Fallacy:**
  - Achieving zero reported defects is meaningless if the system is unusable, performs poorly, or solves the wrong customer problem.
  - Usability, fitness for purpose, and business alignment override purely technical bug counts.

<!--
Continuing with the remaining three principles.

Principle 5 is the Pesticide Paradox. If you never update your tests, developers unconsciously write code that passes existing tests while introducing novel defects in untested gaps.

Principle 6 highlights context dependence. You cannot test an avionics flight guidance computer the same way you test a casual mobile game.

Principle 7 warns against the absence-of-errors fallacy. A system can be completely bug-free according to unit tests, but if nobody wants to use it or it doesn't solve the business problem, the project is still a failure.

To summarize this slide, remember this key takeaway: Regularly evolve test suites, tailor testing rigor to system risk, and ensure software delivers genuine user value.
-->
---
<!-- _class: title-image-slide -->

## Visual Overview: 7 Core Software Testing Principles

<div class="image-wrapper">
  <img src="../../img/ch07/testing_principles.svg" alt="7 Core Software Testing Principles" />
</div>

<!--
Here is a comprehensive visual synthesis of the Seven Software Testing Principles.

Observe the progression: from Dijkstra's fundamental defect axiom, through the necessity of risk-based sampling, the economic power of Shift-Left testing, Pareto clustering, the evolving pesticide paradox, domain context, and the avoidance of the absence-of-errors trap.

Keep this mental map in mind whenever you design quality assurance strategies for your development teams.

To summarize this slide, remember this key takeaway: These seven principles guide pragmatic test resource allocation across all engineering phases.
-->
---
<!-- _class: title-image-slide -->

## The Spectrum of Software Testing Types

<div class="image-wrapper">
  <img src="../../img/ch07/testing_types.svg" alt="The Spectrum of Software Testing Types" />
</div>

<!--
Look at the broad taxonomy of testing types across the software lifecycle.

Testing is divided into Functional Testing—which evaluates business logic, API contracts, and user interactions—and Non-Functional Testing—which measures speed, load, stress, security, and recovery.

Furthermore, we classify testing by development phase: Development Testing, Release Testing, and User Acceptance Testing.

To summarize this slide, remember this key takeaway: Quality assurance spans functional features, non-functional attributes, and operational delivery stages.
-->
---
## Specialized Testing 1: Regression Testing

* **Definition:**
  - Re-executing existing automated test suites against modified code bases to verify that recent code changes, refactorings, or bug fixes have not broken previously functioning behavior.
* **The Regression Risk:**
  - Studies show that 20% to 50% of all bug fixes inadvertently introduce new, collateral defects elsewhere in the codebase.
* **Regression in Modern CI/CD Pipelines:**
  - Fast unit regression suites run automatically on every `git push` and Pull Request.
  - Comprehensive end-to-end regression suites run nightly or prior to scheduled release cutoffs.
* **Test Suite Selection Strategies:**
  - **Retest All:** Running every test (comprehensive but slow for large suites).
  - **Regression Test Selection (RTS):** Utilizing code coverage maps to run only tests exercising modified methods.

<!--
Let's examine Regression Testing—the cornerstone of modern continuous integration.

Whenever an engineer modifies code, refactors an architecture, or patches a bug, there is substantial risk of unintended collateral damage. Regression testing guarantees that what worked yesterday still works today.

In modern CI/CD pipelines, automated regression suites run on every pull request, giving developers immediate confidence that their commits are safe to merge.

To summarize this slide, remember this key takeaway: Automated regression testing prevents code decay and protects existing functionality during continuous evolution.
-->
---
## Specialized Testing 2: Fuzz Testing (Fuzzing)

* **Definition:**
  - An automated testing technique that generates and injects massive streams of **invalid, malformed, semi-structured, or pseudorandom inputs** into software interfaces.
* **Target Vulnerabilities:**
  - Memory corruption (buffer overflows, use-after-free, double-free in C/C++/Rust).
  - Unhandled exceptions, infinite loops, thread deadlocks, and denial-of-service crashes.
* **Fuzzing Methodologies:**
  - **Mutation-based:** Takes valid seed inputs and mutates bits/bytes randomly.
  - **Generation-based:** Generates inputs conforming to a specified grammar or protocol.
  - **Coverage-guided:** Uses lightweight binary instrumentation to prioritize inputs that reach new code branches (e.g., AFL, libFuzzer, Google OSS-Fuzz).

<!--
Fuzz Testing, or fuzzing, is one of the most effective automated defect discovery techniques in computer security.

Instead of hand-crafting polite test cases, a fuzzer bombards the application with millions of bizarre, corrupted, and malformed inputs. Coverage-guided fuzzers like AFL detect when an input reaches a new branch in the binary and mutate that input further.

Google's OSS-Fuzz project has discovered tens of thousands of critical security vulnerabilities in open-source infrastructure using this exact technique.

To summarize this slide, remember this key takeaway: Coverage-guided fuzz testing uncovers deep edge-case crashes and zero-day security vulnerabilities through automated input mutation.
-->
---
## Specialized Testing 3: Smoke, Sanity & Mutation Testing

* **Smoke Testing (Build Verification):**
  - A fast, non-exhaustive test suite executed on every fresh software build to verify core critical paths ("Does the build catch fire when turned on?").
  - If smoke tests fail, the build is immediately rejected and returned to developers without wasting QA team time.
* **Sanity Testing (Post-Fix Verification):**
  - A focused, narrow test suite executed immediately following a minor bug fix or patch to confirm that the specific reported defect is resolved before broader regression.
* **Mutation Testing (Evaluating the Test Suite Itself):**
  - Intentionally injects small syntactic faults ("mutants", e.g., swapping `>` with `<`, `+` with `-`) into the source code.
  - If existing test suites fail ("kill the mutant"), the test suite is strong; if tests pass despite the corrupted code ("surviving mutant"), test coverage is inadequate.

<!--
Here are three vital specialized testing practices.

Smoke testing is your first line of defense: a quick 5-minute sanity check on every build to confirm basic components boot up without crashing.

Sanity testing focuses on a single fixed defect to verify the patch worked.

Mutation testing answers a profound meta-question: Who tests the tests? By injecting artificial bugs into your source code, mutation testing measures whether your test suite is truly capable of detecting regressions.

To summarize this slide, remember this key takeaway: Smoke tests guard build health, sanity tests verify quick patches, and mutation testing evaluates test suite efficacy.
-->
---
## Non-Functional Testing: Load, Stress & Security

* **Load Testing:**
  - Validates system response time, throughput (RPS), and server resource consumption under **expected peak operational workloads** (e.g., 5,000 concurrent shopping users).
* **Stress Testing:**
  - Pushes system concurrency and transaction volume **beyond maximum design limits** until failure occurs.
  - Objective: Evaluates graceful degradation, error handling, and automated recovery without data corruption.
* **Security & Penetration Testing:**
  - Validates defense-in-depth against malicious exploits: SQL injection, cross-site scripting (XSS), broken access control, and unauthorized privilege escalation.
  - Combines automated Static/Dynamic Application Security Testing (SAST/DAST) with ethical manual red-teaming.

<!--
Non-functional testing verifies that a system operates reliably under real-world operational stressors.

Load testing measures whether your servers deliver acceptable latency under anticipated peak traffic.

Stress testing intentionally pushes the system past its breaking point to verify that when it crashes, it fails gracefully without corrupting database transactions.

Security testing verifies that malicious actors cannot bypass authentication or manipulate API payloads.

To summarize this slide, remember this key takeaway: Non-functional testing validates system performance, resilience, and security under extreme operational conditions.
-->
---
## The Software Testing Pyramid

<div style="text-align: center; margin-top: 10px;">
  <img src="../../img/ch07/testing_pyramid.svg" style="max-height: 480px;" alt="Software Testing Pyramid" />
</div>

<!--
Examine the Software Testing Pyramid, popularized by Mike Cohn.

At the base of the pyramid lies Unit Testing: thousands of fast, deterministic, isolated tests executing in milliseconds.

In the middle sits Integration and Component Testing: validating API contracts, database queries, and inter-service communication.

At the top sits End-to-End (E2E) and UI Testing: validating complete customer workflows in real browser environments. Because E2E tests are slow, brittle, and expensive to maintain, they should form the smallest percentage of your test portfolio.

To summarize this slide, remember this key takeaway: Maintain a broad base of fast unit tests, supported by service integration tests, capped by a focused set of critical E2E flows.
-->
---
## Stages of Testing: Development Testing

* **Unit Testing:**
  - Evaluates individual functions, algorithms, or object classes in strict isolation.
  - Isolates external dependencies (databases, external APIs, filesystem) using **test doubles (mocks, stubs, and fakes)**.
  - Executed locally by developers and in automated pre-commit hooks.
* **Component Testing:**
  - Evaluates clusters of cooperating classes that together form a cohesive functional component or subsystem.
  - Focuses on module boundary interfaces and internal data flow integrity.
* **System Testing:**
  - Integrates all subsystems into a complete runtime package to verify end-to-end workflows and emergent behavior.
  - Verifies cross-service communication, security policies, and performance characteristics in staging environments.

<!--
Development testing progresses in three structured tiers.

Unit testing isolates single methods using mock objects. If a unit test fails, the bug is pinpointed to a specific function in seconds.

Component testing verifies clusters of classes working together, checking that interfaces pass data without serialization errors.

System testing integrates the entire application—frontend, backend, databases, and message queues—to evaluate emergent behaviors.

To summarize this slide, remember this key takeaway: Development testing proceeds progressively from isolated units, through integrated components, to full system environments.
-->
---
## Release Testing vs. User Testing

* **Release Testing (Pre-Deployment Validation):**
  - Performed by an independent QA team on a candidate release build.
  - **Requirements-Based Testing:** Systematically checks off every acceptance criterion in the functional specification.
  - **Scenario / Workflow Testing:** Simulates realistic, end-to-end user journeys (e.g., browsing, adding to cart, checkout, delivery tracking).
* **User & Acceptance Testing (Customer Evaluation):**
  - **Alpha Testing:** Internal employees and trusted simulated users test the software on-site at the developer's facility.
  - **Beta Testing:** Early release delivered to external end-users in real operating environments to gather field feedback and telemetry.
  - **Acceptance Testing:** The formal verification performed by the client against legal contract requirements prior to commercial sign-off.

<!--
As software prepares for public release, testing transitions from developers to independent teams and end-users.

Release testing validates that all contract requirements are met and that end-to-end user scenarios complete smoothly.

User testing begins with Alpha testing—internal stakeholders testing in a staging sandbox—followed by Beta testing with real early adopters, and concluding with contractual Acceptance Testing.

To summarize this slide, remember this key takeaway: Release testing ensures formal specification compliance, while user testing validates real-world operational acceptance.
-->
---
## Concept Check Question 1: Testing Principles

According to Dijkstra's foundational testing axiom and the Shift-Left principle, what is the primary capability and economic timing of software testing?

- **A.** It mathematically proves that a program is completely free of all defects when executed early in requirements.
- **B.** It can show the presence of defects but never their absence, and finding bugs early is drastically cheaper.
- **C.** It guarantees 100% statement coverage across all modules if automated regression tests are run continuously.
- **D.** It replaces the necessity for customer acceptance testing by eliminating defect clustering in production code.

<!--
Let's test our understanding of fundamental testing principles.

Consider Dijkstra's axiom carefully, alongside the economic benefits of the Shift-Left movement.

Read each option thoughtfully and select the choice that accurately captures both core concepts.
-->
---
## Concept Check Question 1: Answer & Explanation

- **Correct Answer: B**
- **Explanation:**
  - Edsger Dijkstra's famous axiom explicitly states: *"Program testing can be used to show the presence of bugs, but never to show their absence!"* Testing provides empirical evidence of flaws, but cannot mathematically prove zero bugs exist.
  - The Shift-Left principle emphasizes testing as early as requirements and design, because resolving defects early costs 10x to 100x less than fixing them in post-release maintenance.
  - *Why others are incorrect:* Option A contradicts Dijkstra's axiom. Option C confuses structural statement coverage with functional defect absence. Option D is false because automated tests never eliminate the need for customer acceptance testing.

<!--
The correct answer is B.

Testing can demonstrate that defects exist, but cannot prove their total absence. Furthermore, shifting testing left to requirements and architecture catches bugs when they are exponentially cheaper to rectify.

To summarize this slide, remember this key takeaway: Testing reveals defect presence rather than absence, and early detection maximizes development efficiency.
-->
---
<!-- _class: lead -->
<!-- header: '7.2 Black-Box Testing Techniques' -->

# **7.2 Black-Box Testing Techniques**

> "Testing without a specification is like exploring a dark cave without a map: you might find something, but you have no idea if you're in the right cavern."

<!--
We now transition to Module 7.2: Black-Box Testing Techniques.

Black-box testing, also known as specification-based or functional testing, evaluates software behavior strictly against functional requirements without examining internal source code.

In this module, we explore the contrast between black-box and white-box testing, master the four mathematical formulas of Boundary Value Analysis, examine weak versus strong Equivalence Partitioning, and study classical real-world case studies: Triangle classification, FCU swimming pool fees, Binary Search, and calendar nextDate calculation.

To summarize this slide, remember this key takeaway: Black-box testing designs rigorous input-output test suites derived directly from functional specifications.
-->
---
## Black-Box vs. White-Box Testing

* **Black-Box Testing (Specification-Based / Functional):**
  - **Perspective:** The tester treats the application as an opaque black box with zero visibility into source code, algorithms, or internal data structures.
  - **Input Source:** Derived directly from functional requirements, user stories, API contracts, and user documentation.
  - **Primary Benefit:** Tests whether the system fulfills intended user goals; completely unbiased by developer implementation quirks.
* **White-Box Testing (Structural / Glass-Box / Clear-Box):**
  - **Perspective:** The tester has complete visibility into the source code, control flow graphs, conditions, and execution branches.
  - **Input Source:** Derived from control logic, loops, conditional statements, and architectural structures.
  - **Primary Benefit:** Identifies dead code, unexercised logic branches, and boundary edge cases inside algorithms.

<!--
Let's contrast the two primary paradigms of software testing.

In Black-Box testing, the system is an opaque container. You send inputs and inspect outputs based strictly on specifications. You don't know or care whether the backend is written in Java, Python, or Rust.

In White-Box testing, you inspect the internal machinery—every if-statement, loop, and boolean expression—to ensure all code paths have been exercised.

Both paradigms are essential and mutually reinforcing.

To summarize this slide, remember this key takeaway: Black-box validates requirement satisfaction from the outside, while white-box verifies structural code execution from the inside.
-->
---
<!-- _class: title-image-slide -->

## Visual Overview: Black-Box vs. White-Box Testing

<div class="image-wrapper">
  <img src="../../img/ch07/black_vs_white_box.svg" alt="Black-Box vs White-Box Testing" />
</div>

<!--
Notice the stark visual contrast shown on this slide.

On the left, the black-box tester stands outside the boundary, feeding inputs into the system and checking expected outputs against specification contracts.

On the right, the white-box tester peers inside the transparent glass box, tracing control flow graphs, execution branches, and conditional nodes.

To summarize this slide, remember this key takeaway: Black-box tests what the software does; white-box tests how the software executes.
-->
---
<!-- _class: title-image-slide -->

## 5 Major Black-Box Testing Methods

<div class="image-wrapper">
  <img src="../../img/ch07/black_box_methods.svg" alt="5 Major Black-Box Testing Methods" />
</div>

<!--
Here is the five-part taxonomy of black-box testing techniques.

1. Boundary Value Analysis: testing partition edges.
2. Equivalence Partitioning: grouping inputs into representative classes.
3. Decision Table Testing: handling complex boolean logic combinations.
4. State Transition Testing: verifying finite state machines.
5. Use Case & Scenario Testing: validating end-to-end user transactions.

Let's study each method in technical detail.

To summarize this slide, remember this key takeaway: Combine partition, boundary, tabular, state, and scenario techniques to achieve comprehensive black-box coverage.
-->
---
## Boundary Value Testing: The Single Fault Assumption

* **Why Boundaries Fail (The "Off-by-One" Phenomenon):**
  - Programmers frequently make comparison mistakes (`<` vs. `<=`, `>` vs. `>=`) and index errors at partition limits.
  - Empirical research confirms that **over 60% of functional bugs occur at boundaries** of input domains.
* **The Single Fault Assumption (單一錯誤假設):**
  - Assumes that software failures are almost always caused by a defect in a **single variable** rather than simultaneous, coordinated defects across multiple variables.
  - *Consequence:* When testing the boundary values of variable $X$, all other variables are held at their typical, nominal middle values (`norm`).
* **Worst-Case Testing (Non-Independent Variables):**
  - Rejects the single fault assumption when input variables interact in compound logical expressions (e.g., `if (exam <= 60 && hw <= 60)`).
  - Generates the complete **Cartesian cross-product** of boundary values across all inputs.

<!--
Why do boundary values fail so often?

Because human programmers routinely introduce off-by-one errors: writing less-than instead of less-than-or-equal, or starting array indexes at 1 instead of 0.

To design efficient boundary test suites, we rely on the Single Fault Assumption. This assumes bugs are caused by one variable failing at a time. Therefore, we test boundary values for variable A while holding variables B and C at safe nominal values.

However, if variables interact tightly in logic, we must drop this assumption and use worst-case Cartesian testing.

To summarize this slide, remember this key takeaway: The Single Fault Assumption tests one boundary at a time holding others nominal, while worst-case testing evaluates multi-variable boundary interactions.
-->
---
## The 4 Boundary Value Testing Formulas

<div style="text-align: center; margin-top: 10px;">
  <img src="../../img/ch07/boundary_taxonomy.svg" style="max-height: 380px;" alt="Boundary Value Taxonomy" />
</div>

* **For $n$ input variables, the required test cases are:**
  1. **Independent Normal (BVA):** $4n + 1$ (values: `min, min+, norm, max-, max` per variable, plus 1 all-`norm`).
  2. **Independent Robustness:** $6n + 1$ (adds out-of-bounds `min-` and `max+`).
  3. **Worst-Case Normal:** $5^n$ (Cartesian product of 5 points across all variables).
  4. **Worst-Case Robustness:** $7^n$ (Cartesian product of 7 points across all variables).

<!--
Memorize these four standard formulas for boundary testing across n variables.

In Independent Normal BVA, each variable is tested at 4 boundary points—min, min-plus, max-minus, and max—while others stay at norm, plus 1 common nominal test case, giving 4n + 1. For 3 variables, that's 13 test cases.

Independent Robustness adds invalid boundaries (min-minus and max-plus), yielding 6n + 1, or 19 tests.

In Worst-Case testing, we test all combinations: 5 to the power of n for normal, and 7 to the power of n for robust.

To summarize this slide, remember this key takeaway: Boundary testing scales linearly (4n+1, 6n+1) under single fault assumptions, and exponentially (5^n, 7^n) in worst-case analysis.
-->
---
## Boundary Case Study: Triangle Classification

* **Problem Specification:**
  - Inputs: Three integers $a, b, c \in [1, 200]$ representing side lengths.
  - Output: *Equilateral*, *Isosceles*, *Scalene*, or *Non-Triangle*.
* **Independent Normal Boundary ($4n + 1 = 13$ test cases):**
  - Hold $b, c = 100$ (`norm`). Test $a \in \{1, 2, 199, 200\}$.
  - Repeat for $b$ (holding $a, c = 100$) and $c$ (holding $a, b = 100$), plus 1 case $(100, 100, 100)$.
* **The "Diversity Deficit" Flaw:**
  - Notice that in all 13 test cases, two sides are *always equal to 100*!
  - Therefore, the 13 test cases only test *Equilateral* $(100,100,100)$ and *Isosceles* triangles; **not a single Scalene triangle is ever tested!**
* **Engineering Solutions:**
  - Use dynamic random `norm` values for each variable (e.g., $a_{\text{norm}}=100, b_{\text{norm}}=101, c_{\text{norm}}=102$).
  - Apply **Output-Guided Partitioning** to guarantee coverage across all expected output categories.

<!--
The classic Triangle Problem illustrates a famous trap in boundary value analysis: the Diversity Deficit.

If you blindly apply the 4n+1 formula with a fixed nominal value of 100, every single test case holds two sides at 100. As a result, you only ever produce Equilateral and Isosceles triangles! You never test a Scalene triangle where all three sides are distinct!

This teaches us a profound lesson: never apply formulas blindly. Always check whether your test suite covers every output category.

To summarize this slide, remember this key takeaway: Blind boundary testing can create diversity deficits; combine input boundaries with output-guided partition verification.
-->
---
## Equivalence Partitioning: Weak vs. Strong Coverage

* **Equivalence Partitioning (EP) Principle:**
  - Partitions the infinite input and output space into discrete classes where the program is presumed to process all values within a class identically.
  - Testing one representative value from each partition is theoretically equivalent to testing all values in that partition.
* **Weak Coverage (Weak EP):**
  - Based on the **Single Fault Assumption**.
  - Requires that each identified partition of every variable is covered by **at least one test case**.
  - Total test cases = $\max(|P_1|, |P_2|, \dots, |P_n|)$.
* **Strong Coverage (Strong EP):**
  - Rejects single fault assumption to account for multi-variable interactions.
  - Requires testing the **Cartesian product** of all partitions across all variables:
    $$\text{Total Test Cases} = |P_1| \times |P_2| \times \dots \times |P_n|$$

<!--
Equivalence Partitioning divides large input domains into equivalence classes. If a function behaves identically for all positive numbers from 1 to 100, testing 42 gives you the same confidence as testing 73.

Weak EP covers every partition of every variable at least once by packing them into the minimum number of test cases.

Strong EP tests every combination of partitions across all variables using Cartesian cross-products.

To summarize this slide, remember this key takeaway: Weak EP achieves partition coverage with minimal test cases, while Strong EP evaluates multi-variable partition combinations.
-->
---
## EP Case Study 1: Single-Variable Domain (Exam Scores)

> **Specification:** An academic grading portal accepts integer scores between **0** and **100** inclusive.

* **Partition 1: Invalid Low ($\text{Score} < 0$):**
  - *Representative Test Value:* **$-15$**
  - *Expected System Output:* Rejection error ("Score cannot be negative").
* **Partition 2: Valid Range ($0 \le \text{Score} \le 100$):**
  - *Representative Test Value:* **$75$**
  - *Expected System Output:* Score accepted and grade recorded.
* **Partition 3: Invalid High ($\text{Score} > 100$):**
  - *Representative Test Value:* **$135$**
  - *Expected System Output:* Rejection error ("Score exceeds maximum limit of 100").
* **Testing Takeaway:**
  - A comprehensive suite must always include both **valid partitions** (testing feature correctness) and **invalid partitions** (testing defensive exception handling).

<!--
Here is a straightforward single-variable equivalence partitioning example: an exam scoring input.

The input domain splits cleanly into three partitions: Invalid Low (below 0), Valid Range (0 to 100), and Invalid High (above 100).

Notice that we select one representative value from each partition: -15, 75, and 135.

Never test only valid inputs. In production software, robust error handling for invalid partitions is just as critical as the happy path.

To summarize this slide, remember this key takeaway: Always define both valid partitions to verify functionality and invalid partitions to verify exception handling.
-->
---
## EP Case Study 2: Multi-Variable FCU Swimming Pool Fee

> **Specification:** Public pool ticket price depends on three variables: **Age**, **Time Slot**, and **Membership Status**.

<div style="text-align: center; margin-top: 10px;">
  <img src="../../img/ch07/swimming_pool_ep.svg" style="max-height: 230px;" alt="Swimming Pool EP Matrix" />
</div>

* **Identified Input Partitions:**
  - **Age ($P_{\text{Age}}$):** Child ($< 12$), Adult ($12\text{--}64$), Senior ($\ge 65$), Invalid ($< 0$).
  - **Time Slot ($P_{\text{Time}}$):** Off-Peak (Morning), Peak (Evening).
  - **Membership ($P_{\text{Member}}$):** Member (Discounted), Non-Member (Standard).
* **Coverage Analysis:**
  - **Weak EP:** $\max(4, 2, 2) = 4$ test cases (covers all partitions at least once).
  - **Strong EP:** $4 \times 2 \times 2 = 16$ test cases (tests all demographic pricing permutations).

<!--
In this multi-variable example, ticket pricing at the university swimming pool depends on age, time slot, and membership.

Notice the partition counts: Age has 4 partitions, Time has 2, and Membership has 2.

Under Weak EP, we only need 4 test cases to cover every partition at least once. Under Strong EP, we test all 16 combinations to guarantee that no specific pricing combination produces an incorrect fee.

To summarize this slide, remember this key takeaway: Weak EP scales to the largest single partition count, whereas Strong EP evaluates all Cartesian combinations.
-->
---
## EP Case Study 3: Binary Search Partition Plan

> **Specification:** `Search(Key: int, A: Array) -> (Found: bool, Index: int)`

* **Input Array Partitions:**
  - Empty array ($a^0$: length = 0).
  - Single-element array ($a^1$: length = 1).
  - Multi-element sorted array ($a^*$: length $> 1$).
* **Output & Target Position Partitions:**
  - **Found ($f^t$):** Key located at First index ($c^1$), Middle index ($c^m$), or Last index ($c^l$).
  - **Not Found ($f^f$):** Key smaller than array min ($v^{<\text{min}}$), larger than array max ($v^{>\text{max}}$), or between elements.
  - **Invalid ($k^!$):** Null or unsorted array input.
* **Weak Coverage Plan:**
  - Derive 8 structured test cases ($R_1 \text{--} R_8$) ensuring every input state and output position is verified.

<!--
Binary Search is a classic algorithm with tricky edge cases.

To test it thoroughly using equivalence partitioning, we partition both the input array structure—empty, single element, multiple elements—and the target key position—first element, middle element, last element, not found, and out of bounds.

This structured breakdown leads directly to our 8-case test suite.

To summarize this slide, remember this key takeaway: Partition both input data structures and output result positions to thoroughly exercise search algorithms.
-->
---
<!-- _class: title-image-slide -->

## EP Case Study 3: Binary Search Test Suite

<div class="image-wrapper">
  <img src="../../img/ch07/binary_search_ep_table.svg" alt="Binary Search Test Suite Table" />
</div>

<!--
Examine the complete test suite for Binary Search.

Notice how test cases R1 through R8 systematically cover each equivalence class:
R1 tests an empty array;
R2 tests a single-element array with a match;
R3 tests a single-element array with no match;
R4, R5, and R6 test multi-element arrays with the key at the first, middle, and last positions;
and R7 and R8 test missing elements below min and above max.

Every partition is verified with minimal redundancy.

To summarize this slide, remember this key takeaway: A structured 8-case suite thoroughly tests binary search edge cases without exhaustive trial-and-error.
-->
---
## Boundary & EP Case Study: nextDate Plan

> **Specification:** `nextDate(month: int, day: int, year: int) -> String` where Year $\in [1800, 2048]$.

<div style="text-align: center; margin-top: 10px;">
  <img src="../../img/ch07/nextdate_case_study.svg" style="max-height: 250px;" alt="nextDate Case Study" />
</div>

* **Critical Boundary Test Conditions:**
  - **Standard Month End:** `2024-01-31` $\to$ `2024-02-01`
  - **Year End Rollover:** `2024-12-31` $\to$ `2025-01-01`
  - **30-Day Month Boundary:** `2024-04-30` $\to$ `2024-05-01` (Day `31` in April is Invalid!).
  - **Leap Year Century Boundary:**
    - `2024-02-28` $\to$ `2024-02-29` (Leap year divisible by 4).
    - `2023-02-28` $\to$ `2023-03-01` (Common year).
    - `1900-02-28` $\to$ `1900-03-01` (Century year not divisible by 400).
    - `2000-02-28` $\to$ `2000-02-29` (Century leap year divisible by 400).

<!--
The nextDate problem is a renowned benchmark in software testing literature.

Calculating tomorrow's date involves intricate Gregorian calendar boundary rules: months with 30 versus 31 days, year-end rollovers, and the quadrennial, centennial, and quad-centennial leap year rules.

Designing test cases for nextDate exercises all boundary categories in a compact problem domain.

To summarize this slide, remember this key takeaway: Date calculations require testing month boundaries, year rollovers, and complex multi-tier leap year rules.
-->
---
<!-- _class: title-image-slide -->

## Boundary & EP Case Study: nextDate Test Suite

<div class="image-wrapper">
  <img src="../../img/ch07/nextdate_ep_table.svg" alt="nextDate Test Cases Table" />
</div>

<!--
Here is the concrete test suite for the nextDate function.

Observe how test cases TC1 through TC8 systematically verify typical mid-month increments, 30-day transitions, 31-day transitions, December year-end rollovers, standard leap years, non-leap years, and out-of-bounds date rejections.

To summarize this slide, remember this key takeaway: Systematic tabular test design guarantees complete coverage of complex calendrical boundary conditions.
-->
---
## Concept Check Question 2: Boundary Value Analysis

Under the Single Fault Assumption, how many test cases are required to perform Independent Normal Boundary Value Analysis on a function with $n = 4$ independent input variables?

- **A.** 16 test cases, derived by evaluating the $2^n$ binary combinations of boundary extremes.
- **B.** 17 test cases, derived using the $4n + 1$ formula covering 4 boundaries per input plus 1 nominal.
- **C.** 25 test cases, derived using the $6n + 1$ formula including robust out-of-bounds values.
- **D.** 625 test cases, derived using the $5^n$ worst-case Cartesian product of all inputs.

<!--
Let's check our mastery of Boundary Value Analysis formulas.

Review the problem parameters: Independent Normal testing, Single Fault Assumption, and 4 variables.

Recall the mathematical formulas we examined earlier and choose the correct calculation.
-->
---
## Concept Check Question 2: Answer & Explanation

- **Correct Answer: B**
- **Explanation:**
  - For Independent Normal Boundary Value Analysis under the Single Fault Assumption, each variable is tested at 4 boundary values (`min, min+, max-, max`) while all other variables are held at their nominal middle value (`norm`).
  - Across $n$ variables, this yields $4 \times n$ test cases. Adding the single common test case where all variables are nominal (`norm, norm, ...`) gives the standard formula:
    $$\text{Total Test Cases} = 4n + 1 = 4(4) + 1 = 17 \text{ test cases}$$
  - *Why others are incorrect:* Option A (16) confuses BVA with binary truth tables. Option C (25) corresponds to Robustness testing ($6n+1 = 6(4)+1 = 25$). Option D (625) corresponds to Worst-Case testing ($5^n = 5^4 = 625$).

<!--
The correct answer is B.

Under the Single Fault Assumption, each variable is tested at its 4 boundary points while holding others at nominal, plus one common all-nominal test case. For 4 variables, 4 times 4 plus 1 equals 17 test cases.

To summarize this slide, remember this key takeaway: Independent normal boundary testing requires 4n+1 test cases, scaling linearly with the number of inputs.
-->
---
<!-- _class: lead -->
<!-- header: '7.3 Combinatorial & Behavioral Methods' -->

# **7.3 Combinatorial & Behavioral Methods**

> "Combinatorial explosion is the nemesis of exhaustive testing; pairwise testing is the engineer's sharpest scalpel."

<!--
We now enter Module 7.3: Combinatorial and Behavioral Methods.

When software involves multiple configuration options, interacting checkboxes, or complex conditional business rules, testing all combinations leads to combinatorial explosion.

In this section, we study All-Pairs (Pairwise) testing to conquer combinatorial explosion, examine Decision Table testing for complex boolean business logic, and explore State Transition and Scenario testing.

To summarize this slide, remember this key takeaway: Combinatorial and tabular testing compress complex multi-variable state spaces into manageable, high-yield test suites.
-->
---
## All-Pairs (Pairwise) Testing

* **The Combinatorial Explosion Problem:**
  - Testing all combinations (Strong EP / Cartesian Product) across $k$ parameters each with $v$ values requires **$v^k$ test cases**.
  - Example: A web application with 10 dropdowns, each having 3 choices, requires $3^{10} = \mathbf{59,049}$ test cases!
* **The Empirical Pairwise Principle:**
  - Studies by the US National Institute of Standards and Technology (NIST) show that **between 67% and 93% of all software defects are triggered by interactions between at most 2 parameters (pairs)**.

<div style="text-align: center; margin-top: 10px;">
  <img src="../../img/ch07/all_pairs_testing.svg" style="max-height: 220px;" alt="All-Pairs Testing" />
</div>

* **Engineering Value:**
  - Pairwise testing ensures **every pair of parameter values is tested together at least once**, reducing 59,049 tests down to approximately **15 to 20 test cases**!

<!--
Consider the challenge of combinatorial explosion.

If your web application has 10 dropdown menus with 3 options each, testing every combination requires nearly 60,000 test cases! That is impossible to execute manually and costly to automate.

However, empirical research by NIST discovered that the overwhelming majority of software bugs are triggered by interactions between at most two parameters—a specific operating system paired with a specific browser version.

Pairwise testing mathematically generates the minimal test suite where every pair of values co-occurs at least once, reducing thousands of test cases down to fewer than twenty.

To summarize this slide, remember this key takeaway: Pairwise testing dramatically reduces combinatorial explosion while capturing the vast majority of multi-parameter interaction defects.
-->
---
## Decision Table Testing: Modeling Complex Boolean Logic

* **Concept & Objective:**
  - A structured tabular method for specifying and testing complex business rules where multiple input conditions determine specific system actions.
* **Decision Table Structure:**
  - **Condition Stubs:** Lists all boolean conditions/inputs.
  - **Action Stubs:** Lists all possible system actions/outputs.
  - **Rules (Columns):** Each column represents a unique combination of conditions ($T/F$) and the resulting triggered actions ($X$).

<div style="text-align: center; margin-top: 10px;">
  <img src="../../img/ch07/decision_table.svg" style="max-height: 280px;" alt="Decision Table Example" />
</div>

<!--
When business requirements contain intricate if-then-else rules, Decision Table testing brings complete clarity.

A decision table maps boolean condition stubs on top to action stubs on the bottom. Each column defines a rule: if conditions 1 and 2 are true but 3 is false, action A is executed.

Decision tables make it immediately obvious if any condition combinations have been omitted by requirements analysts.

To summarize this slide, remember this key takeaway: Decision tables systematically capture complex multi-condition business logic, preventing omitted edge cases.
-->
---
## State Transition & Use Case Scenario Testing

* **State Transition Testing:**
  - Used for reactive, stateful systems (e.g., e-commerce orders, embedded controllers, game engines).
  - Models system states, event triggers, guards, and output transitions.
  - **Coverage Goals:**
    1. *All-States Coverage:* Every valid state visited at least once.
    2. *All-Transitions Coverage:* Every valid state transition executed.
    3. *Invalid Transition Testing:* Verifying that invalid transitions are rejected (e.g., trying to *Ship* an order that is *Cancelled*).
* **Use Case & Scenario Testing:**
  - Derived directly from user stories and UML Use Case specifications.
  - **Happy Path (Basic Flow):** Tests the primary normal sequence achieving user goals.
  - **Alternate & Exception Flows:** Tests validation failures, network disconnects, and user cancellations.

<!--
State Transition Testing and Use Case Testing evaluate end-to-end dynamic behaviors.

State testing models how an entity moves between states—like an order progressing from Placed to Paid to Shipped. Crucially, state testing must verify both valid transitions and invalid transitions, ensuring an order cannot jump directly from Cancelled to Shipped.

Use Case testing validates complete end-to-end customer journeys, testing the happy path alongside alternate recovery flows.

To summarize this slide, remember this key takeaway: State testing validates entity lifecycle integrity, while use case testing validates end-to-end customer goals.
-->
---
## Concept Check Question 3: Combinatorial Testing

Why is All-Pairs (Pairwise) testing widely considered one of the highest-ROI test design techniques in modern software engineering?

- **A.** It tests all possible $N$-way parameter combinations, guaranteeing 100% path coverage.
- **B.** It requires full white-box access to control flow graphs, eliminating the need for integration testing.
- **C.** It dramatically compresses test suites while empirically catching over 70% to 90% of parameter interaction bugs.
- **D.** It replaces boundary value analysis by automatically generating all invalid boundary points.

<!--
Let's assess our understanding of combinatorial and pairwise testing.

Think about why software teams adopt tools like Microsoft PICT or ACTS to generate pairwise suites.

Evaluate each option and select the one that correctly identifies the ROI and empirical backing of pairwise testing.
-->
---
## Concept Check Question 3: Answer & Explanation

- **Correct Answer: C**
- **Explanation:**
  - NIST empirical studies across diverse software domains demonstrate that the vast majority of software defects (67% to 93%) are caused by interactions between at most 2 parameters (pairs).
  - All-Pairs testing drastically compresses test suites from $O(v^k)$ down to $O(v^2 \log k)$ (e.g., reducing tens of thousands of tests to under 25) while detecting the overwhelming majority of interaction defects, delivering extraordinary return on investment.
  - *Why others are incorrect:* Option A is false because All-Pairs only tests 2-way interactions, not all $N$-way combinations. Option B is false because All-Pairs is a black-box technique requiring no source code access. Option D is false because Pairwise testing is complementary to Boundary Value Analysis, not a replacement for it.

<!--
The correct answer is C.

Pairwise testing delivers immense ROI because empirical studies show that the vast majority of software defects are triggered by interactions between at most two parameters. By ensuring all pairs are tested, we achieve massive defect detection with minimal test count.

To summarize this slide, remember this key takeaway: Pairwise testing provides exponential compression of test suites while capturing over 70% to 90% of interaction defects.
-->
---
<!-- _class: lead -->
<!-- header: '7.4 White-Box Structural Testing' -->

# **7.4 White-Box Structural Testing**

> "You cannot inspect quality into a product, but structural testing ensures no dark corners remain uninspected."

<!--
We now transition into Part 2 of Chapter 7: White-Box Structural Testing.

In white-box testing, also known as glass-box or clear-box testing, we inspect the actual internal source code, control flow graphs, conditional decisions, and execution paths.

In this module, we introduce the formal coverage subsumption hierarchy, establish a single benchmark program used to compare all criteria, and examine Statement Coverage, Branch Coverage, Condition Coverage, and the surprising paradoxes introduced by short-circuit boolean evaluation.

To summarize this slide, remember this key takeaway: White-box testing measures how comprehensively a test suite executes internal code logic and decision branches.
-->
---
## White-Box Fundamentals & Coverage Subsumption Hierarchy

* **Core Definition:**
  - Testing software with full knowledge of internal source code, control flow graphs (CFG), and logic expressions.
* **The Subsumption Principle ($A \implies B$):**
  - Coverage criterion $A$ **subsumes** criterion $B$ if and only if any test suite that satisfies $A$ is guaranteed to satisfy $B$.
* **The Classical Subsumption Hierarchy:**
  - $\text{Statement (SC)} \le \text{Branch (BC)} \le \text{Branch/Condition (BCC)} \le \text{MC/DC} \le \text{Multiple Condition (MCC)} \le \text{Path (PC)}$.

<div style="text-align: center; margin-top: 10px;">
  <img src="../../img/ch07/coverage_subsumption.svg" style="max-height: 260px;" alt="Coverage Subsumption Hierarchy" />
</div>

<!--
White-Box testing evaluates the thoroughness of test suites by measuring which parts of the source code are exercised during execution.

To compare different criteria, computer scientists use the Subsumption Principle: Criterion A subsumes Criterion B if achieving 100% in A guarantees 100% in B.

As shown in the hierarchy diagram, Statement Coverage is at the bottom. Branch Coverage subsumes Statement Coverage. Above that sit Condition combinations, MC/DC, and Path Coverage.

To summarize this slide, remember this key takeaway: Stronger structural coverage criteria subsume weaker ones, providing strictly greater execution guarantees.
-->
---
## Standard Benchmark Program for Coverage Analysis

To compare all white-box coverage criteria rigorously, we evaluate the **SAME standard benchmark program** across all criteria:

```java
// Standard Benchmark Program for Structural Coverage Analysis
void process(int A, int B, int X) {
    if (A > 1 && B == 0) {  // Decision 1 (b1): Condition c1 && Condition c2
        Y = A;
    }
    if (A == 2 || X > 1) {  // Decision 2 (b2): Condition c3 || Condition c4
        Y = X;
    }
    print(Y);
}
```

* **Decision 1 ($b_1$):** `(A > 1) && (B == 0)`
  - Atomic conditions: $c_1: (A > 1)$, $c_2: (B == 0)$.
* **Decision 2 ($b_2$):** `(A == 2) || (X > 1)`
  - Atomic conditions: $c_3: (A == 2)$, $c_4: (X > 1)$.

<!--
To make our comparison rigorous and concrete, we use this single Java benchmark function throughout the entire lecture.

Notice the structure: the function takes three integers, A, B, and X.

It contains two decision points:
Decision 1 (b1) is an AND expression: A > 1 && B == 0.
Decision 2 (b2) is an OR expression: A == 2 || X > 1.

There are four atomic boolean conditions: c1, c2, c3, and c4. Let's see how each coverage criterion evaluates this code.

To summarize this slide, remember this key takeaway: Benchmark code with compound AND and OR decisions enables precise mathematical comparison of structural coverage criteria.
-->
---
## 1. Statement Coverage (SC / SC100)

* **Definition:**
  - Every executable statement in the program must be executed **at least once**.
  - Formula: $\text{Statement Coverage} = \frac{\text{Executed Statements}}{\text{Total Executable Statements}} \times 100\%$.
* **100% Statement Coverage on Benchmark Code:**
  - Consider a single test case: $T_1 = (A = 2, B = 0, X = 3)$.
  - *Trace:* $b_1$ evaluates to $\text{True} \implies Y = 2$. Next, $b_2$ evaluates to $\text{True} \implies Y = 3$. Then `print(3)` executes.
  - **Result:** **100% Statement Coverage is achieved with only ONE test case!**
* **The Critical Weakness of Statement Coverage:**
  - SC100 is the **weakest** structural criterion!
  - If Line 2 contained a bug (`&&` miswritten as `||`) or Line 3 was miswritten as `Y = B`, test $T_1$ would pass with 100% coverage, completely blind to the defect.

<!--
Statement Coverage, or SC, simply asks: Did execution touch every line of code?

In our benchmark function, a single test case—A=2, B=0, X=3—executes every line of code, achieving 100% Statement Coverage in one shot!

Why is Statement Coverage dangerous when relied upon alone? Because it only tests that code ran, not that the decision logic was correct! If the developer wrote AND instead of OR, or omitted an else-branch, SC100 passes with flying colors while hiding major bugs.

To summarize this slide, remember this key takeaway: Statement coverage is a minimal baseline; achieving 100% SC leaves untested branches and boolean logic flaws.
-->
---
## 2. Branch / Decision Coverage (BC / BC100)

* **Definition:**
  - Every decision point ($b_1, b_2$) must evaluate to **True** at least once and **False** at least once.
  - Formula: $\text{Branch Coverage} = \frac{\text{Executed Decision Outcomes}}{\text{Total Decision Outcomes}} \times 100\%$.
* **100% Branch Coverage on Benchmark Code (2 Test Cases):**
  - $T_1 = (A = 3, B = 0, X = 3) \implies b_1 = \text{True}, b_2 = \text{True}$
  - $T_2 = (A = 3, B = 1, X = 1) \implies b_1 = \text{False}, b_2 = \text{False}$
  - Both decisions $b_1$ and $b_2$ evaluate to $\{\text{True}, \text{False}\}$.
* **Subsumption Rule ($BC \implies SC$):**
  - Achieving 100% Branch Coverage **strictly guarantees 100% Statement Coverage** ($BC100 \implies SC100$).
  - For standard commercial software, Branch Coverage is considered the standard engineering baseline.

<!--
Branch Coverage, also called Decision Coverage, requires that every branch—the True branch and the False branch—is executed for every decision point.

On our benchmark code, we need two test cases: one where both decisions evaluate to True, and one where both evaluate to False.

Crucially, achieving 100% Branch Coverage guarantees 100% Statement Coverage. If you take every branch, you must visit every statement inside those branches.

To summarize this slide, remember this key takeaway: Branch coverage guarantees statement coverage and serves as the industry baseline for commercial software.
-->
---
## 3. Condition Coverage (CC / CC100) & The Paradox

* **Definition:**
  - Every individual atomic boolean condition ($c_1, c_2, c_3, c_4$) within decisions must evaluate to **True** and **False** at least once.
* **100% Condition Coverage on Benchmark Code (2 Test Cases):**
  - $T_1 = (2, 0, 3) \implies c_1: T, c_2: T, c_3: T, c_4: T$
  - $T_2 = (1, 1, 1) \implies c_1: F, c_2: F, c_3: F, c_4: F$
  - All atomic conditions take both True and False values.
* **The CC vs. BC Paradox: Does CC100 guarantee BC100? NO!**
  - Consider test suite: $T_a = (3, 1, 1)$ ($c_1: T, c_2: F \implies b_1: \text{False}$) and $T_b = (1, 0, 2)$ ($c_1: F, c_2: T \implies b_1: \text{False}$).
  - Both conditions $c_1$ and $c_2$ evaluate to $\{T, F\}$ (100% Condition Coverage achieved!).
  - **However, $b_1$ evaluates to False in BOTH tests! 0% Branch True coverage is achieved!**

<!--
Condition Coverage shifts attention from the overall decision to the individual atomic boolean conditions. Every condition must evaluate to True and False.

Here is the famous testing paradox: Does 100% Condition Coverage guarantee 100% Branch Coverage?

Surprisingly, the answer is NO!

Look at the paradox on this slide: in test Ta, c1 is True and c2 is False. In test Tb, c1 is False and c2 is True. Every condition took True and False. But because True AND False is False, decision b1 evaluated to False in both tests! The True branch was never executed!

To summarize this slide, remember this key takeaway: Condition coverage evaluates atomic booleans, but does NOT guarantee branch coverage.
-->
---
## Short-Circuit Evaluation Impact on Testing

* **Short-Circuit Evaluation Semantics (`&&`, `||`):**
  - In modern programming languages (Java, C, C++, JavaScript, Python), right-hand conditions are skipped if the left-hand condition determines the final outcome:
    - `false && expr` $\implies$ `expr` is **never evaluated**.
    - `true || expr` $\implies$ `expr` is **never evaluated**.
* **Impact on Structural Coverage Measurement:**
  | Test Case | $p$ ($c_1$) | $q$ ($c_2$) | Short-Circuit Evaluation of $p \text{ \&\& } q$ |
  | :--- | :---: | :---: | :---: |
  | $T_1$ | **True** | **False** | Evaluates both; returns **False**. |
  | $T_2$ | **False** | *Skipped ($x$)* | Skips $q$; returns **False**. |
  | $T_3$ | **True** | **True** | Evaluates both; returns **True**. |
* **Key Takeaway:**
  - Under short-circuiting, test $T_2$ never actually exercises condition $q$.
  - To achieve 100% Condition Coverage under short-circuiting compilers, a test like $T_3$ is required to force $q = \text{True}$, which **simultaneously forces the decision to True and guarantees Branch Coverage!**

<!--
Short-circuit evaluation in modern compilers introduces an interesting twist to structural testing.

When evaluating an AND expression, if the first condition is False, the compiler skips the second condition entirely. If condition q isn't even executed in machine instructions, did your test truly cover it?

Under strict short-circuit coverage metrics, you must force the first condition to True in order to evaluate the second condition, which naturally forces Branch Coverage as a byproduct.

To summarize this slide, remember this key takeaway: Short-circuiting skips right-hand conditions, requiring deliberate test design to guarantee atomic condition execution.
-->
---
## Concept Check Question 4: Condition vs. Branch Coverage

Given the decision statement `if (X > 10 && Y == 1)`:
Which test suite achieves **100% Condition Coverage (CC100)** but completely **FAILS to achieve Branch Coverage (BC100)**?

- **A.** $T_1: (X = 12, Y = 1)$ and $T_2: (X = 5, Y = 2)$
- **B.** $T_1: (X = 12, Y = 2)$ and $T_2: (X = 5, Y = 1)$
- **C.** $T_1: (X = 12, Y = 1)$ and $T_2: (X = 12, Y = 2)$
- **D.** $T_1: (X = 5, Y = 1)$ and $T_2: (X = 5, Y = 2)$

<!--
Let's verify your understanding of the CC vs BC paradox.

Analyze each test suite for the decision X > 10 AND Y == 1.

Check whether both atomic conditions experience True and False, while the overall decision fails to experience both True and False branches.
-->
---
## Concept Check Question 4: Answer & Explanation

- **Correct Answer: B**
- **Explanation:**
  - Let atomic conditions be $c_1: (X > 10)$ and $c_2: (Y == 1)$.
  - **In Test Suite B:**
    - For $T_1(12, 2)$: $c_1 = \text{True}, c_2 = \text{False} \implies \text{Decision} = \text{False}$.
    - For $T_2(5, 1)$: $c_1 = \text{False}, c_2 = \text{True} \implies \text{Decision} = \text{False}$.
    - *Condition Coverage:* $c_1 \in \{T, F\}$ and $c_2 \in \{T, F\} \implies$ **100% Condition Coverage achieved!**
    - *Branch Coverage:* Both tests evaluate to False $\implies$ **0% True Branch executed! BC100 fails!**
  - *Why others are incorrect:* In Option A, $T_1$ produces True and $T_2$ produces False (achieving BC100). In Option C, $c_1$ is never False. In Option D, $c_1$ is never True.

<!--
The correct answer is B.

In test 1, c1 is True and c2 is False. In test 2, c1 is False and c2 is True. Both conditions take True and False, achieving 100% Condition Coverage. But because True AND False is False, both tests evaluate to False, completely missing the True branch!

To summarize this slide, remember this key takeaway: Condition coverage alone does not subsume branch coverage because opposing condition outcomes can lock the decision to False.
-->
---
<!-- _class: lead -->
<!-- header: '7.5 Advanced Criteria & Control Flow' -->

# **7.5 Advanced Criteria & Control Flow**

> "In safety-critical avionics, an untested condition branch is not an oversight—it is a hazard."

<!--
We now advance to Module 7.5: Advanced Criteria and Control Flow.

When developing software for safety-critical domains—commercial airliners, medical devices, nuclear reactors, and automotive braking systems—standard branch coverage is not legally sufficient.

In this module, we examine Multiple Condition Combination coverage, analyze the FAA/DO-178B mandatory standard known as MC/DC (Modified Condition/Decision Coverage), explore the Loop Path Explosion problem, and apply McCabe's Cyclomatic Complexity to derive basis path test suites.

To summarize this slide, remember this key takeaway: Advanced coverage criteria provide rigorous defect detection for mission-critical software architectures.
-->
---
## 4. Multiple Condition Combination (MCC)

* **Definition:**
  - Every possible combination of boolean truth values for atomic conditions within each decision must be executed.
  - For a decision with $n$ atomic conditions, requires **$2^n$ test cases per decision**.
* **Truth Combinations for Benchmark Code ($2^2 + 2^2 = 8$ combinations):**
  - **Decision 1 ($c_1, c_2$):** (1) TT, (2) TF, (3) FT, (4) FF.
  - **Decision 2 ($c_3, c_4$):** (5) TT, (6) TF, (7) FT, (8) FF.
* **100% MCC Test Suite (4 Test Cases):**
  - $T_1 = (2, 0, 4) \implies$ Decision 1: TT $\to \text{True}$, Decision 2: TT $\to \text{True}$
  - $T_2 = (2, 1, 1) \implies$ Decision 1: TF $\to \text{False}$, Decision 2: TF $\to \text{True}$
  - $T_3 = (1, 0, 2) \implies$ Decision 1: FT $\to \text{False}$, Decision 2: FT $\to \text{True}$
  - $T_4 = (1, 1, 1) \implies$ Decision 1: FF $\to \text{False}$, Decision 2: FF $\to \text{False}$
* **Limitation:** Exponential explosion: a compound decision with 10 conditions requires $2^{10} = \mathbf{1,024}$ test cases!

<!--
Multiple Condition Combination, or MCC, tests every combination in the boolean truth table.

For a decision with two conditions, there are 4 combinations: TT, TF, FT, and FF. By aligning tests across both decisions, 4 test cases achieve 100% MCC on our benchmark code.

The fatal drawback of MCC is exponential explosion. If an avionics flight rule has 10 boolean sensor conditions, MCC requires over 1,000 tests for that single line of code! We need a smarter criterion.

To summarize this slide, remember this key takeaway: Multiple Condition Combination tests all truth table permutations, but scales exponentially with condition count.
-->
---
## 5. Modified Condition / Decision Coverage (MC/DC)

* **Safety-Critical Standard:**
  - Mandated by **FAA / RTCA DO-178B/C (Level A)** for commercial aircraft flight control software.
* **The 4 MC/DC Requirements:**
  1. Every decision point has evaluated to **True** and **False** at least once (BC100).
  2. Every condition within a decision has evaluated to **True** and **False** at least once (CC100).
  3. Every entry and exit point has been invoked at least once.
  4. **Condition Independence:** Each condition has been shown to **independently affect the decision's outcome** by toggling that condition while holding all other conditions fixed.
* **Linear Efficiency ($N + 1$):**
  - For a decision with $N$ conditions, MC/DC requires only **$N + 1$ test cases** instead of $2^N$!
  - For $N = 10$ conditions: MCC requires 1,024 tests; MC/DC requires only **11 test cases**!

<!--
Modified Condition/Decision Coverage—MC/DC—is the gold standard of safety-critical software testing.

Invented by Boeing and mandated by the FAA for commercial flight control software, MC/DC proves that every condition independently controls the decision outcome.

The genius of MC/DC is its linear efficiency. While MCC requires 2 to the power of N tests, MC/DC requires only N + 1 tests! For a 10-condition rule, MC/DC drops the test count from 1,024 down to just 11.

To summarize this slide, remember this key takeaway: MC/DC provides avionics-grade independence verification with linear N+1 test case efficiency.
-->
---
## MC/DC Independence Pair Analysis & Benchmark Suite

* **Independence Pair Concept:**
  - For condition $c_i$, find two test cases where $c_i$ toggles ($T \left→ F$), all other conditions $c_j$ remain identical, and the **final decision outcome toggles ($T \left→ F$)**.
* **MC/DC Test Suite for Benchmark Decision 1: `(A > 1 && B == 0)`:**
  | Test ID | Input $(A, B)$ | $c_1: (A > 1)$ | $c_2: (B == 0)$ | Decision Outcome ($b_1$) | Validates Independence Of |
  | :--- | :---: | :---: | :---: | :---: | :--- |
  | **$M_1$** | $(2, 0)$ | **True** | **True** | **True** | Base True Case |
  | **$M_2$** | $(1, 0)$ | **False** | **True** | **False** | Independence Pair for $c_1$ $(M_1, M_2)$ |
  | **$M_3$** | $(2, 1)$ | **True** | **False** | **False** | Independence Pair for $c_2$ $(M_1, M_3)$ |
* **Result:**
  - Test suite $\{M_1, M_2, M_3\}$ achieves **100% MC/DC with $N + 1 = 2 + 1 = 3$ test cases!**

<!--
Look at this concrete MC/DC independence analysis table for Decision 1: A > 1 && B == 0.

Notice how independence pairs work:
Comparing M1 and M2: condition c1 flips from True to False, while condition c2 stays True. The decision flips from True to False! This proves c1 independently controls the decision.

Comparing M1 and M3: condition c2 flips from True to False, while c1 stays True. The decision flips from True to False! This proves c2 independently controls the decision.

Three test cases achieve 100% MC/DC coverage.

To summarize this slide, remember this key takeaway: MC/DC uses independence pairs to demonstrate that each condition directly controls the decision outcome.
-->
---
## 6. Path Coverage & The Loop Explosion Problem

* **Definition:**
  - Tests **every possible execution path** from program entry to program exit.
  - Conceptually the most exhaustive structural criterion possible.
* **Paths for Benchmark Program (4 Independent Paths):**
  - Path 1: Decision 1 True, Decision 2 True $\implies (2, 0, 4)$
  - Path 2: Decision 1 True, Decision 2 False $\implies (2, 0, 1)$
  - Path 3: Decision 1 False, Decision 2 True $\implies (1, 0, 2)$
  - Path 4: Decision 1 False, Decision 2 False $\implies (1, 1, 1)$
* **The Loop Path Explosion Problem:**
  - If a program contains a loop that executes up to 20 times, and inside the loop there are 4 branching paths:
    $$\text{Total Execution Paths} = 4^{20} = 2^{40} \approx \mathbf{1.1 \times 10^{12} \text{ paths!}}$$
  - At 1 millisecond per test, executing full path coverage would take **over 34 years!**

<!--
Path Coverage requires testing every single path from start to finish.

In our simple benchmark code with no loops, there are only 4 paths.

However, the moment a program contains loops, path coverage suffers from catastrophic Loop Path Explosion. A simple loop running 20 times with 4 internal branches yields over 1 trillion execution paths! Exhaustive path coverage is computationally impossible for non-trivial software.

To summarize this slide, remember this key takeaway: Full path coverage is computationally impossible in looping programs due to combinatorial path explosion.
-->
---
## Basis Path Testing (McCabe's Cyclomatic Complexity)

* **McCabe's Cyclomatic Complexity $V(G)$:**
  - Measures the structural complexity of a program and defines the maximum number of **linearly independent basis paths** in a Control Flow Graph.
  - **Formulas:**
    1. $V(G) = E - N + 2P$ (where $E$ = edges, $N$ = nodes, $P$ = connected components).
    2. $V(G) = \text{Binary Decision Predicates} + 1$.
    3. $V(G) = \text{Number of Enclosed Regions in Planar CFG} + 1$.
* **Core Engineering Benefit:**
  - Guarantees 100% Statement Coverage and 100% Branch Coverage by executing exactly **$V(G)$ basis paths**, completely bypassing loop path explosion.
* **Complexity Guidelines:**
  - $V(G) \le 10$: Well-structured, testable code.
  - $V(G) > 20$: High risk, complex, difficult to test.
  - $V(G) > 50$: Unmaintainable spaghetti code; refactoring is mandatory.

<!--
McCabe's Cyclomatic Complexity provides the elegant mathematical solution to loop path explosion.

Instead of testing all trillion paths, McCabe proved that every execution path is a linear combination of a small set of basis paths.

The number of basis paths, V(G), equals the number of binary decision points plus one.

Testing exactly V(G) basis paths guarantees 100% statement and branch coverage without combinatorial explosion.

To summarize this slide, remember this key takeaway: Basis path testing uses McCabe's cyclomatic complexity to achieve complete branch coverage with minimal linear test paths.
-->
---
## Concept Check Question 5: Advanced Coverage Criteria

In safety-critical avionics testing conforming to DO-178B/C Level A, why is MC/DC mandated rather than Multiple Condition Combination (MCC) or standard Branch Coverage?

- **A.** Because MC/DC is a black-box method that does not require examining boolean operators in code.
- **B.** Because MC/DC verifies condition independence with $N+1$ tests, avoiding the $2^N$ explosion of MCC while being far stricter than Branch Coverage.
- **C.** Because MC/DC executes every loop iteration up to $N+1$ times, guaranteeing zero runtime deadlocks.
- **D.** Because MC/DC eliminates the need for unit testing by proving requirement validity directly.

<!--
Let's test our understanding of advanced structural criteria and safety standards.

Consider the engineering trade-offs between Branch Coverage, MCC, and MC/DC in DO-178B/C avionics certification.

Select the option that accurately captures why MC/DC is the mandatory standard.
-->
---
## Concept Check Question 5: Answer & Explanation

- **Correct Answer: B**
- **Explanation:**
  - DO-178B/C Level A mandates MC/DC because standard Branch Coverage is insufficient to verify that individual boolean conditions cannot cause hazardous hidden failures.
  - While Multiple Condition Combination (MCC) checks all truth combinations, its exponential cost ($2^N$) is prohibitive for complex logic. MC/DC delivers rigorous condition independence verification in **$N + 1$ test cases**, providing maximum defect detection with linear efficiency.
  - *Why others are incorrect:* Option A is false because MC/DC is an advanced white-box technique. Option C confuses MC/DC with loop boundary testing. Option D is false because MC/DC is a unit-level structural criterion and does not replace requirement validation.

<!--
The correct answer is B.

MC/DC achieves the ideal balance: it is far stricter than simple branch coverage because it proves condition independence, while requiring only N+1 tests instead of the exponential 2^N explosion of MCC.

To summarize this slide, remember this key takeaway: MC/DC is the gold standard for safety-critical systems because it achieves condition independence verification with linear test efficiency.
-->
---
<!-- _class: lead -->
<!-- header: '7.6 Testing Synthesis & Anti-Patterns' -->

# **7.6 Testing Synthesis & Anti-Patterns**

> "Beware of the fallacy: 100% code coverage does not mean 100% bug-free software."

<!--
We conclude Chapter 7 with Module 7.6: Testing Synthesis and Anti-Patterns.

In modern software development, teams often obsess over metrics. High code coverage numbers can create a false sense of security if engineers mistake code execution for functional correctness.

In this closing module, we debunk the myth of 100% code coverage, provide a comprehensive comparison table of all six structural criteria evaluated on our benchmark code, test your knowledge with a fill-in-the-blank recap quiz, and review practical recommendations.

To summarize this slide, remember this key takeaway: Combine structural metrics with meaningful assertions, property tests, and risk-based quality engineering.
-->
---
## The Myth of 100% Code Coverage

* **1. Diminishing Return on Investment (ROI):**
  - Moving a codebase from 0% to 80% coverage catches roughly 90% of all latent defects cost-effectively.
  - Pushing from 95% to 100% coverage requires exponential engineering effort for minimal defect reduction.
* **2. Execution Does NOT Imply Correctness (The Assertion Void):**
  - A test suite can achieve 100% Statement and Branch Coverage **without containing a single assertion statement!**
  - If tests do not assert correct state, exceptions, and outputs, code execution reveals nothing about functional accuracy.
* **3. Missing Logic & Omitted Specifications:**
  - Code coverage only measures code that was *written*.
  - If a developer completely forgot to implement a critical business requirement (e.g., tax calculation for international orders), coverage metrics report 100% because no code exists to be missed!
* **4. Brittle Tests on Defensive Code:**
  - Forcing coverage on hardware panic handlers, out-of-memory guards, and defensive logging produces brittle, low-value tests.

<!--
Let's debunk the pervasive myth of 100% code coverage.

First, the law of diminishing returns applies: reaching 80% coverage delivers huge quality gains, but forcing the last 5% costs disproportionate engineering hours.

Second, execution does not mean correctness. You can write a test that executes every line of code without writing a single assert statement. The code runs, the metric shows 100%, and yet not a single behavior was verified!

Third, coverage cannot test omitted requirements. If an entire feature is missing from the codebase, coverage will still show 100%.

To summarize this slide, remember this key takeaway: High coverage is a necessary indicator of tested code, but never proof of correct software.
-->
---
## Comprehensive Comparison: Structural Coverage on Benchmark Code

| Coverage Criterion | Target Evaluated | Benchmark Test Cases Needed | Key Strength / Practical Limitation |
| :--- | :--- | :---: | :--- |
| **Statement (SC)** | Executable statements | **1 Test:** $(2, 0, 3)$ | Baseline requirement; blind to missing branches & logic defects. |
| **Branch (BC)** | Decision outcomes ($T/F$) | **2 Tests:** $(3,0,3), (3,1,1)$ | Standard commercial baseline; guarantees 100% Statement Coverage. |
| **Condition (CC)** | Atomic conditions ($T/F$) | **2 Tests:** $(2,0,3), (1,1,1)$ | Tests condition primitives; does **NOT** guarantee Branch Coverage! |
| **MC/DC** | Condition independence | **3 Tests ($N+1$):** $(2,0),(1,0),(2,1)$ | DO-178B/C avionics standard; linear scaling with maximum rigor. |
| **Multiple Cond (MCC)** | Condition combinations | **4 Tests ($2^N$):** TT, TF, FT, FF | Exhaustive truth table testing; suffers from exponential explosion. |
| **Path (PC)** | Entry-to-exit paths | **4 Tests** | Complete path execution; suffers from catastrophic loop explosion. |

<!--
This master comparison table synthesizes all six structural criteria evaluated on our standard benchmark program.

Study the column of required test cases:
Statement Coverage needs only 1 test case.
Branch Coverage and Condition Coverage each need 2.
MC/DC needs 3 (N + 1).
Multiple Condition Combination and Path Coverage each need 4.

Review the trade-offs: Statement coverage is minimal, Branch coverage is standard, MC/DC is safety-critical, and MCC and Path suffer from combinatorial explosion.

To summarize this slide, remember this key takeaway: Choose structural testing criteria based on system criticality, balancing defect detection against combinatorial cost.
-->
---
## Chapter Recap: Fill-in-the-Blank Challenge

Test your mastery of the core concepts across Chapter 7:

* **1.** The Pareto Principle in software testing states that roughly **`___`**% of defects cluster in **`___`**% of modules.
* **2.** Under the Single Fault Assumption, Independent Normal Boundary Value Analysis requires **`___`** test cases for $n$ variables.
* **3.** **`___`** testing ensures that every pair of parameter values is tested together at least once, preventing combinatorial explosion.
* **4.** Achieving 100% Branch Coverage strictly guarantees 100% **`___`** Coverage, but does not guarantee Condition Coverage.
* **5.** The safety-critical standard mandated for commercial flight software that achieves condition independence in $N+1$ tests is **`___`**.
* **6.** Basis Path Testing utilizes McCabe's **`___`** Complexity to determine the minimum number of independent execution paths.

<!--
Let's review the core terminology and mathematical formulas from Chapter 7.

Take a moment to mentally fill in the blanks for all six questions.
-->
---
## Chapter Recap: Solution Key

Here are the completed principles and technical terms:

* **1.** The Pareto Principle in software testing states that roughly **80%** of defects cluster in **20%** of modules.
* **2.** Under the Single Fault Assumption, Independent Normal Boundary Value Analysis requires **$4n + 1$** test cases for $n$ variables.
* **3.** **All-Pairs (Pairwise)** testing ensures that every pair of parameter values is tested together at least once, preventing combinatorial explosion.
* **4.** Achieving 100% Branch Coverage strictly guarantees 100% **Statement** Coverage ($BC100 \implies SC100$), but does not guarantee Condition Coverage.
* **5.** The safety-critical standard mandated for commercial flight software that achieves condition independence in $N+1$ tests is **MC/DC**.
* **6.** Basis Path Testing utilizes McCabe's **Cyclomatic** Complexity to determine the minimum number of independent execution paths.

<!--
Here is the solution key.

1. Pareto 80/20 rule.
2. 4n + 1 boundary formula.
3. All-Pairs or Pairwise testing.
4. Statement Coverage subsumption.
5. MC/DC in DO-178B/C.
6. Cyclomatic Complexity.

To summarize this slide, remember this key takeaway: These six core concepts form the bedrock of disciplined software testing and quality engineering.
-->
---
## Chapter Summary & Engineering Best Practices

* **Synthesize Black-Box & White-Box Testing:**
  - Use **Equivalence Partitioning and Boundary Value Analysis** to design functional tests from specifications without implementation bias.
  - Use **Pairwise Testing** to tame multi-parameter configuration spaces.
  - Use **Branch and MC/DC Coverage** to verify that internal logic and safety conditions are thoroughly exercised.
* **Follow the Testing Pyramid:**
  - Anchor quality on a dense base of fast, automated unit tests.
  - Validate inter-service contracts with integration and component tests.
  - Reserve slow end-to-end tests for critical business user journeys.
* **Adopt Continuous Quality:**
  - Shift-left by reviewing requirements and architecture early.
  - Automate regression test suites within CI/CD pipelines on every pull request.
  - Remember Dijkstra's lesson: testing demonstrates defect presence—design code for testability from day one!

<!--
To conclude Chapter 7, let's review our overarching engineering best practices.

Quality is not something you sprinkle onto software at the very end. Quality must be designed in from the beginning.

Combine black-box specification tests with white-box structural coverage. Respect the testing pyramid: thousands of fast unit tests, hundreds of integration tests, and dozens of end-to-end user workflows.

And above all, remember Dijkstra's insight: testing shows the presence of bugs, not their absence. Write clean, modular, testable code every single day.

To summarize this slide, remember this key takeaway: Rigorous testing combines specification-based functional design, structural coverage verification, and automated CI/CD execution.
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
