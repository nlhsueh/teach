---
marp: true
theme: ase-theme
size: a4
paginate: true
header: ' '
footer: 'Software Engineering (SE) Midterm Examination · Department of CSIE, FCU'
---

<!-- _class: exam-paper -->

<div class="exam-doc-header">
  <div class="inst-title">Feng Chia University · Department of Computer Science & Information Engineering</div>
  <div class="exam-main-title">Software Engineering (SE) — Midterm Examination</div>
  <div class="exam-meta-grid">
    <div><span>Course:</span> Software Engineering (Fall 2026)</div>
    <div><span>Date:</span> Midterm Exam Week</div>
    <div><span>Time Allowed:</span> 100 Minutes</div>
    <div><span>Max Score:</span> 100 Points</div>
  </div>
  <div class="exam-meta-grid" style="margin-top: 4px; background: #ffffff;">
    <div style="flex: 1.2;"><span>Student ID:</span> ___________________________</div>
    <div style="flex: 1.2;"><span>Student Name:</span> ___________________________</div>
    <div style="flex: 0.8; text-align: right;"><span style="font-weight: 800; color: #0b3c5d;">Final Score:</span> ______ / 100</div>
  </div>
</div>

<div class="exam-instructions">
  <strong>Instructions:</strong> Closed book, closed notes. This exam paper contains three sections: <strong>Part I: Multiple Choice (70%)</strong>, <strong>Part II: Fill-in-the-Blank (20%)</strong>, and <strong>Part III: Scenario Essay (10%)</strong>. Write all answers clearly in the designated spaces. For Part I, write the capital letter (A, B, C, or D). For Part III, adhere strictly to the 100–150 word limit.
</div>

<div class="exam-part-header">
  <span>PART I. MULTIPLE CHOICE QUESTIONS</span>
  <span class="pts-badge">70 Points (14 Questions · 5 pts each)</span>
</div>

<div class="exam-mc-item">
  <div class="exam-mc-stem"><span class="q-num">1.</span> In Fred Brooks's classic analysis "No Silver Bullet", which challenge represents an <em>essential difficulty</em> inherent to the very nature of software rather than an accidental difficulty?</div>
  <div class="exam-mc-grid">
    <div><strong>(A)</strong> Memory leaks caused by manual pointer management</div>
    <div><strong>(B)</strong> Slow compilation speed on legacy build toolchains</div>
    <div><strong>(C)</strong> Conceptual complexity of arbitrary non-linear logic</div>
    <div><strong>(D)</strong> Syntax errors from unergonomic programming grammar</div>
  </div>
</div>

<div class="exam-mc-item">
  <div class="exam-mc-stem"><span class="q-num">2.</span> According to Martin Fowler's Technical Debt Quadrant, which scenario exemplifies <em>Prudent and Deliberate</em> debt?</div>
  <div class="exam-mc-grid single-col">
    <div><strong>(A)</strong> Junior developers omitting unit tests because they do not understand test-driven development.</div>
    <div><strong>(B)</strong> An architecture team intentionally bypassing a microservice boundary to release an MVP before a conference, planning remediation next sprint.</div>
    <div><strong>(C)</strong> A team copying and pasting legacy code without realizing the severe security vulnerabilities it introduces.</div>
    <div><strong>(D)</strong> Discovering after three years that a third-party framework is no longer maintained by open-source authors.</div>
  </div>
</div>

<div class="exam-mc-item">
  <div class="exam-mc-stem"><span class="q-num">3.</span> Under the ISO/IEC 25010 software product quality model, if an application gracefully degrades service and recovers uncommitted database transactions during a network outage, it exhibits high:</div>
  <div class="exam-mc-grid">
    <div><strong>(A)</strong> Reliability (Fault tolerance & Recoverability)</div>
    <div><strong>(B)</strong> Usability (Learnability & Operability)</div>
    <div><strong>(C)</strong> Maintainability (Modularity & Reusability)</div>
    <div><strong>(D)</strong> Portability (Adaptability & Installability)</div>
  </div>
</div>

<div class="exam-mc-item">
  <div class="exam-mc-stem"><span class="q-num">4.</span> Under what specific project circumstances is the traditional <em>Waterfall model</em> more appropriate and lower risk than an iterative Agile approach?</div>
  <div class="exam-mc-grid single-col">
    <div><strong>(A)</strong> Consumer mobile apps where UI/UX requirements pivot weekly based on end-user analytics.</div>
    <div><strong>(B)</strong> Safety-critical avionics firmware with fully validated, unchangeable regulatory specifications.</div>
    <div><strong>(C)</strong> Early-stage startup prototypes exploring uncharted product-market fit with vague requirements.</div>
    <div><strong>(D)</strong> E-commerce websites requiring continuous A/B testing and multiple daily production deployments.</div>
  </div>
</div>

---

<!-- _class: exam-paper -->

<div class="exam-doc-header" style="margin-bottom: 8px;">
  <div style="display: flex; justify-content: space-between; font-size: 11px; color: #64748b; font-weight: 600;">
    <span>Software Engineering (SE) — Midterm Examination</span>
    <span>Candidate: _______________________ (ID: _______________________)</span>
  </div>
</div>

<div class="exam-part-header" style="margin-top: 0;">
  <span>PART I. MULTIPLE CHOICE QUESTIONS (CONTINUED)</span>
  <span class="pts-badge">Questions 5 – 9</span>
</div>

<div class="exam-mc-item">
  <div class="exam-mc-stem"><span class="q-num">5.</span> <em>Brooks's Law</em> states: "Adding human power to a late software project makes it later." Which mathematical factor primarily explains this counter-intuitive phenomenon?</div>
  <div class="exam-mc-grid single-col">
    <div><strong>(A)</strong> Hardware CPU throughput degrades linearly when multiple developers write code simultaneously.</div>
    <div><strong>(B)</strong> Interpersonal communication channels grow combinatorially at $n(n - 1) / 2$, diverting senior developers to training.</div>
    <div><strong>(C)</strong> Git merge conflict resolution algorithms experience quadratic $O(n^2)$ time complexity in large repositories.</div>
    <div><strong>(D)</strong> Cloud hosting infrastructure costs increase exponentially whenever extra team members log in.</div>
  </div>
</div>

<div class="exam-mc-item">
  <div class="exam-mc-stem"><span class="q-num">6.</span> In Lean and Agile Kanban systems, <em>Little's Law</em> states $L = \lambda W$ (Lead Time = WIP / Throughput). What is the direct operational consequence of reducing Work-in-Progress (WIP) limits?</div>
  <div class="exam-mc-grid single-col">
    <div><strong>(A)</strong> Developers work longer overtime hours to compensate for reduced multitasking across feature branches.</div>
    <div><strong>(B)</strong> Cycle time decreases, bottlenecks become immediately visible, and feedback loops accelerate.</div>
    <div><strong>(C)</strong> Code quality degrades because developers are strictly forbidden from writing unit tests during WIP caps.</div>
    <div><strong>(D)</strong> Project scope must be permanently reduced by 50% according to Scrum alliance guidelines.</div>
  </div>
</div>

<div class="exam-mc-item">
  <div class="exam-mc-stem"><span class="q-num">7.</span> What is the fundamental conceptual difference between <em>User Requirements</em> and <em>System Requirements</em>?</div>
  <div class="exam-mc-grid single-col">
    <div><strong>(A)</strong> User requirements specify high-level customer services and operational constraints; System requirements define precise, contractual technical specifications for developers.</div>
    <div><strong>(B)</strong> User requirements are written strictly in formal mathematical Z-notation; System requirements are written in colloquial natural language.</div>
    <div><strong>(C)</strong> User requirements are authored exclusively by database administrators; System requirements are written by marketing executives.</div>
    <div><strong>(D)</strong> User requirements describe only non-functional attributes; System requirements define exclusively GUI wireframes.</div>
  </div>
</div>

<div class="exam-mc-item">
  <div class="exam-mc-stem"><span class="q-num">8.</span> Which requirement specification statement adheres to best practices by being <strong>unambiguous, objectively verifiable, and measurable</strong>?</div>
  <div class="exam-mc-grid single-col">
    <div><strong>(A)</strong> "The order processing subsystem must be user-friendly, responsive, and provide great user satisfaction."</div>
    <div><strong>(B)</strong> "The checkout API endpoint shall return HTTP 200 within 250 ms at the 99th percentile under a load of 1,000 requests/sec."</div>
    <div><strong>(C)</strong> "The application should quickly load images whenever high-speed campus Wi-Fi network is available."</div>
    <div><strong>(D)</strong> "The payment portal shall utilize modern, cutting-edge AI technology to maximize business revenue."</div>
  </div>
</div>

<div class="exam-mc-item">
  <div class="exam-mc-stem"><span class="q-num">9.</span> In a UML Use Case diagram, when should you model a relationship as <code>&lt;&lt;extend&gt;&gt;</code> rather than <code>&lt;&lt;include&gt;&gt;</code>?</div>
  <div class="exam-mc-grid single-col">
    <div><strong>(A)</strong> When the base use case cannot complete its normal flow without unconditionally invoking the target behavior.</div>
    <div><strong>(B)</strong> When the target behavior represents optional or conditional functionality triggered only at a specific extension point.</div>
    <div><strong>(C)</strong> When two unrelated human actors share the exact same role and permission levels across the organization.</div>
    <div><strong>(D)</strong> When one use case inherits all class attributes and database schemas directly from a parent entity.</div>
  </div>
</div>

---

<!-- _class: exam-paper -->

<div class="exam-doc-header" style="margin-bottom: 8px;">
  <div style="display: flex; justify-content: space-between; font-size: 11px; color: #64748b; font-weight: 600;">
    <span>Software Engineering (SE) — Midterm Examination</span>
    <span>Candidate: _______________________ (ID: _______________________)</span>
  </div>
</div>

<div class="exam-part-header" style="margin-top: 0;">
  <span>PART I. MULTIPLE CHOICE QUESTIONS (CONCLUDED)</span>
  <span class="pts-badge">Questions 10 – 14</span>
</div>

<div class="exam-mc-item">
  <div class="exam-mc-stem"><span class="q-num">10.</span> In a UML Class Diagram, what is the key semantic distinction between <em>Composition</em> (solid diamond ◆) and <em>Aggregation</em> (hollow diamond ◇)?</div>
  <div class="exam-mc-grid single-col">
    <div><strong>(A)</strong> In Composition, the whole has coincidental ownership, and parts easily outlive the container.</div>
    <div><strong>(B)</strong> In Composition, parts possess strong lifecycle dependency; when the composite whole is destroyed, its parts are destroyed.</div>
    <div><strong>(C)</strong> In Aggregation, parts cannot be shared across multiple different parent container objects.</div>
    <div><strong>(D)</strong> Composition can only be applied to primitive integer data types, whereas Aggregation applies to object pointers.</div>
  </div>
</div>

<div class="exam-mc-item">
  <div class="exam-mc-stem"><span class="q-num">11.</span> In a UML Sequence Diagram, what visual notation denotes that a participant object is actively executing an internal procedure or waiting for a nested return message?</div>
  <div class="exam-mc-grid">
    <div><strong>(A)</strong> A dashed vertical timeline called a Lifeline</div>
    <div><strong>(B)</strong> A vertical rectangular box called an Activation bar</div>
    <div><strong>(C)</strong> A solid black circle denoting initial state</div>
    <div><strong>(D)</strong> A horizontal bidirectional dotted arrow</div>
  </div>
</div>

<div class="exam-mc-item">
  <div class="exam-mc-stem"><span class="q-num">12.</span> In the Boundary-Control-Entity (BCE) architectural pattern, which component is strictly responsible for orchestrating use case business workflows and enforcing transaction rules?</div>
  <div class="exam-mc-grid">
    <div><strong>(A)</strong> Boundary (View / Web Page / REST API Controller)</div>
    <div><strong>(B)</strong> Control (Coordinator / Service / Business Logic)</div>
    <div><strong>(C)</strong> Entity (Data Model / Database Table Schema)</div>
    <div><strong>(D)</strong> Actor (Human user operating the web browser)</div>
  </div>
</div>

<div class="exam-mc-item">
  <div class="exam-mc-stem"><span class="q-num">13.</span> In a UML State Machine diagram, under what condition does a transition labeled <code>submit [isValid == true] / logAudit()</code> execute?</div>
  <div class="exam-mc-grid single-col">
    <div><strong>(A)</strong> Whenever event <code>submit</code> occurs, regardless of the boolean evaluation of <code>isValid</code>.</div>
    <div><strong>(B)</strong> When event <code>submit</code> occurs AND guard condition <code>isValid == true</code> holds, subsequently invoking action <code>logAudit()</code>.</div>
    <div><strong>(C)</strong> Only after action <code>logAudit()</code> finishes executing and assigns a boolean return value to <code>submit</code>.</div>
    <div><strong>(D)</strong> When the state machine enters an error state and rolls back the database transaction automatically.</div>
  </div>
</div>

<div class="exam-mc-item">
  <div class="exam-mc-stem"><span class="q-num">14.</span> What is the holistic engineering value of linking Use Case, Sequence, Class, and State diagrams together in a project?</div>
  <div class="exam-mc-grid single-col">
    <div><strong>(A)</strong> They replace compiler type-checkers so developers no longer need to write unit or regression tests.</div>
    <div><strong>(B)</strong> They provide complementary structural and behavioral viewpoints, ensuring end-to-end requirement traceability.</div>
    <div><strong>(C)</strong> They guarantee 100% bug-free software execution without requiring code reviews or CI/CD pipelines.</div>
    <div><strong>(D)</strong> They allow non-technical project managers to directly generate binary machine code without programmers.</div>
  </div>
</div>

---

<!-- _class: exam-paper -->

<div class="exam-doc-header" style="margin-bottom: 8px;">
  <div style="display: flex; justify-content: space-between; font-size: 11px; color: #64748b; font-weight: 600;">
    <span>Software Engineering (SE) — Midterm Examination</span>
    <span>Candidate: _______________________ (ID: _______________________)</span>
  </div>
</div>

<div class="exam-part-header" style="margin-top: 0;">
  <span>PART II. FILL-IN-THE-BLANK QUESTIONS</span>
  <span class="pts-badge">20 Points (10 Questions · 2 pts each)</span>
</div>

<div style="font-size: 11.5px; color: #475569; margin-bottom: 6px;">
  <strong>Instructions:</strong> Fill each blank with the foundational term, model, or concept name studied in Chapters 1–4.
</div>

<div style="display: grid; grid-template-columns: 1fr 1fr; gap: 6px 14px; margin-bottom: 10px;">
  <div class="exam-fib-row"><span class="q-num">15.</span> A visual Lean workflow method restricting WIP using board columns is called <span class="exam-blank"></span>.</div>
  <div class="exam-fib-row"><span class="q-num">16.</span> A dynamic UML interaction diagram showing messages over lifelines in time order is a <span class="exam-blank"></span>.</div>
  <div class="exam-fib-row"><span class="q-num">17.</span> In ISO/IEC 25010, how easily users can learn and operate the system is called <span class="exam-blank"></span>.</div>
  <div class="exam-fib-row"><span class="q-num">18.</span> The classic software model with strictly linear, non-overlapping phases is the <span class="exam-blank"></span> model.</div>
  <div class="exam-fib-row"><span class="q-num">19.</span> The implied future cost of rework caused by choosing quick expedient code is called <span class="exam-blank"></span>.</div>
  <div class="exam-fib-row"><span class="q-num">20.</span> A behavioral UML model capturing external actor goals and interactions is a <span class="exam-blank"></span> diagram.</div>
  <div class="exam-fib-row"><span class="q-num">21.</span> The static structural UML diagram modeling classes, attributes, and relationships is the <span class="exam-blank"></span> diagram.</div>
  <div class="exam-fib-row"><span class="q-num">22.</span> In UML class models, a strong 'whole-part' association with shared lifecycle is called <span class="exam-blank"></span>.</div>
  <div class="exam-fib-row"><span class="q-num">23.</span> A UML diagram tracking the event-driven lifecycle states and triggers of an entity is a <span class="exam-blank"></span> diagram.</div>
  <div class="exam-fib-row"><span class="q-num">24.</span> Improving internal code structure without changing external behavior is called <span class="exam-blank"></span>.</div>
</div>

<div class="exam-part-header" style="margin-top: 4px;">
  <span>PART III. SCENARIO ESSAY QUESTION</span>
  <span class="pts-badge">10 Points (1 Question · Word Count: 100–150 words)</span>
</div>

<div class="exam-essay-prompt">
  <strong>Question 25 (Scenario & Architectural Trade-off Analysis):</strong><br />
  A fast-growing fintech startup rushed an online payment platform to market, declaring: <em>"We are 100% Agile—working software over comprehensive documentation means writing code directly without UML or layered architecture."</em> Three months later, whenever an <code>Order</code> is cancelled, orphan <code>PaymentRecord</code> rows remain in the DB; the web UI directly executes raw SQL queries; and sprint velocity plummeted by 60% due to cascading regression bugs.<br />
  <strong>Your Task:</strong> Using software engineering principles from Chapters 1–4 (Technical Debt, Agile vs. Cowboy Coding, BCE separation, and UML lifecycle modeling), critically analyze the team's misconception and formulate a concrete <strong>3-step technical remedy</strong> to restore velocity and architectural integrity.
  <br /><span style="color: #dc2626; font-weight: 700;">Constraint: Answer must be concise, structured, and strictly between 100 and 150 words.</span>
</div>

<div style="font-size: 11px; font-weight: 700; color: #475569; margin: 2px 0 2px 0;">
  STUDENT WRITTEN RESPONSE (Target: 100–150 words):
</div>

<div class="exam-writing-area" style="min-height: 125px;">
  <!-- Ruled notebook lines for student response -->
</div>

<div style="margin-top: 6px; font-size: 10.5px; color: #64748b; display: flex; justify-content: space-between;">
  <span>Grading Rubric: [1] Agile vs. Cowboy diagnosis (3 pts) · [2] Architecture & Lifecycle remedy (4 pts) · [3] Strategy & Word limit (3 pts)</span>
  <span>Word Count: ________ words</span>
</div>

---

<!-- _class: exam-paper -->

<div class="exam-doc-header" style="margin-bottom: 8px;">
  <div class="inst-title">Department of Computer Science & Information Engineering · FCU</div>
  <div class="exam-main-title" style="font-size: 18px; color: #059669;">Software Engineering Midterm — Official Solution Key</div>
  <div style="text-align: center; font-size: 11.5px; color: #475569; font-weight: 600;">Grading Guide & Conceptual Rationales for Part I (MC) and Part II (Fill-in-the-Blank)</div>
</div>

<div class="exam-part-header" style="background: #059669; margin-top: 0;">
  <span>PART I SOLUTIONS: MULTIPLE CHOICE (70 PTS)</span>
  <span class="pts-badge">5 Points Each</span>
</div>

<div style="display: grid; grid-template-columns: 1fr 1fr; gap: 5px 12px; margin-bottom: 8px;">
  <div class="exam-key-card">
    <div class="ans-hdr"><span>Q1. Essential Difficulty</span><span class="ans-val">Key: (C)</span></div>
    <div>Conceptual complexity of arbitrary logic is an inherent essential difficulty (Brooks). Memory, compiler speed, and syntax are accidental tool constraints.</div>
  </div>
  <div class="exam-key-card">
    <div class="ans-hdr"><span>Q2. Technical Debt Quadrant</span><span class="ans-val">Key: (B)</span></div>
    <div>Intentionally bypassing a boundary for a strategic business deadline while planning immediate payoff is deliberate & prudent (Fowler).</div>
  </div>
  <div class="exam-key-card">
    <div class="ans-hdr"><span>Q3. ISO/IEC 25010 Quality</span><span class="ans-val">Key: (A)</span></div>
    <div>Graceful degradation and transaction recovery under failure are sub-characteristics of Reliability (Fault Tolerance & Recoverability).</div>
  </div>
  <div class="exam-key-card">
    <div class="ans-hdr"><span>Q4. Waterfall Suitability</span><span class="ans-val">Key: (B)</span></div>
    <div>Waterfall thrives when specifications are safety-critical, fully validated, and unchangeable upfront. High volatility requires Agile.</div>
  </div>
  <div class="exam-key-card">
    <div class="ans-hdr"><span>Q5. Brooks's Law</span><span class="ans-val">Key: (B)</span></div>
    <div>Adding personnel increases communication paths combinatorially by $n(n-1)/2$, diverting senior staff into ramp-up coaching.</div>
  </div>
  <div class="exam-key-card">
    <div class="ans-hdr"><span>Q6. Little's Law (Kanban)</span><span class="ans-val">Key: (B)</span></div>
    <div>$L = \lambda W$. Capping WIP directly reduces cycle time, unmasks system bottlenecks, and enhances feedback velocity.</div>
  </div>
  <div class="exam-key-card">
    <div class="ans-hdr"><span>Q7. User vs. System Reqt</span><span class="ans-val">Key: (A)</span></div>
    <div>User requirements provide high-level customer services; System requirements specify exact, testable technical behaviors for developers.</div>
  </div>
  <div class="exam-key-card">
    <div class="ans-hdr"><span>Q8. Measurable NFR</span><span class="ans-val">Key: (B)</span></div>
    <div>Specifying HTTP 200 within 250 ms at 99th percentile under 1,000 req/sec provides a quantitatively testable benchmark.</div>
  </div>
  <div class="exam-key-card">
    <div class="ans-hdr"><span>Q9. Use Case &lt;&lt;extend&gt;&gt;</span><span class="ans-val">Key: (B)</span></div>
    <div><code>&lt;&lt;extend&gt;&gt;</code> inserts optional, conditional behavior at declared extension points; <code>&lt;&lt;include&gt;&gt;</code> is mandatory/unconditional.</div>
  </div>
  <div class="exam-key-card">
    <div class="ans-hdr"><span>Q10. Composition vs. Aggregation</span><span class="ans-val">Key: (B)</span></div>
    <div>Composition implies strong ownership and coincident lifetime (cascading deletion); Aggregation implies shared, independent existence.</div>
  </div>
  <div class="exam-key-card">
    <div class="ans-hdr"><span>Q11. Sequence Activation</span><span class="ans-val">Key: (B)</span></div>
    <div>A vertical rectangular bar represents execution focus / active processing period along an object's lifeline.</div>
  </div>
  <div class="exam-key-card">
    <div class="ans-hdr"><span>Q12. BCE Controller</span><span class="ans-val">Key: (B)</span></div>
    <div>Control objects encapsulate business workflow coordination, state validation, and transactional integrity, insulating UI from Entity.</div>
  </div>
  <div class="exam-key-card">
    <div class="ans-hdr"><span>Q13. State Guard Condition</span><span class="ans-val">Key: (B)</span></div>
    <div>A transition fires only when the trigger event arrives AND the bracketed guard boolean evaluates to true.</div>
  </div>
  <div class="exam-key-card">
    <div class="ans-hdr"><span>Q14. Holistic Model Linking</span><span class="ans-val">Key: (B)</span></div>
    <div>Unified diagrams model complementary structural and behavioral facets of a single system, ensuring bidirectional traceability.</div>
  </div>
</div>

<div class="exam-part-header" style="background: #059669; margin-top: 4px;">
  <span>PART II SOLUTIONS: FILL-IN-THE-BLANK (20 PTS)</span>
  <span class="pts-badge">2 Points Each</span>
</div>

<div style="display: grid; grid-template-columns: 1fr 1fr; gap: 3px 12px; font-size: 11px;">
  <div><strong>15.</strong> <span style="color: #059669; font-weight: 800;">Kanban</span> (or Kanban board)</div>
  <div><strong>16.</strong> <span style="color: #059669; font-weight: 800;">Sequence Diagram</span> (or Sequence model)</div>
  <div><strong>17.</strong> <span style="color: #059669; font-weight: 800;">Usability</span> (ISO/IEC 25010 characteristic)</div>
  <div><strong>18.</strong> <span style="color: #059669; font-weight: 800;">Waterfall</span> (or Waterfall model)</div>
  <div><strong>19.</strong> <span style="color: #059669; font-weight: 800;">Technical Debt</span> (Ward Cunningham metaphor)</div>
  <div><strong>20.</strong> <span style="color: #059669; font-weight: 800;">Use Case</span> (or Use Case diagram)</div>
  <div><strong>21.</strong> <span style="color: #059669; font-weight: 800;">Class Diagram</span> (UML static structural model)</div>
  <div><strong>22.</strong> <span style="color: #059669; font-weight: 800;">Composition</span> (Solid diamond ◆ relationship)</div>
  <div><strong>23.</strong> <span style="color: #059669; font-weight: 800;">State Diagram</span> (or State Machine diagram)</div>
  <div><strong>24.</strong> <span style="color: #059669; font-weight: 800;">Refactoring</span> (Code restructuring technique)</div>
</div>

---

<!-- _class: exam-paper -->

<div class="exam-doc-header" style="margin-bottom: 8px;">
  <div class="inst-title">Department of Computer Science & Information Engineering · FCU</div>
  <div class="exam-main-title" style="font-size: 18px; color: #059669;">Part III Essay — Grading Rubric & Exemplary Solution</div>
  <div style="text-align: center; font-size: 11.5px; color: #475569; font-weight: 600;">Scoring Criteria, Benchmark Evaluation, and Annotated Model Answer (10 Points)</div>
</div>

<div class="exam-part-header" style="background: #059669; margin-top: 0;">
  <span>ESSAY SCORING RUBRIC (TOTAL: 10 POINTS)</span>
  <span class="pts-badge">Standardized Criteria</span>
</div>

<table style="width: 100%; border-collapse: collapse; font-size: 11px; margin-bottom: 8px; line-height: 1.35;">
  <thead>
    <tr style="background: #f1f5f9; border-bottom: 2px solid #cbd5e1; text-align: left;">
      <th style="padding: 4px 6px; width: 22%;">Dimension</th>
      <th style="padding: 4px 6px; width: 38%;">Mastery / Full Credit</th>
      <th style="padding: 4px 6px; width: 25%;">Partial Credit</th>
      <th style="padding: 4px 6px; width: 15%;">Inadequate</th>
    </tr>
  </thead>
  <tbody>
    <tr style="border-bottom: 1px solid #e2e8f0;">
      <td style="padding: 4px 6px; font-weight: 700; color: #0b3c5d;">1. Agile Diagnosis (3 pts)</td>
      <td style="padding: 4px 6px;">Exposes that abandoning architecture is <em>cowboy coding</em>, not Agile. Connects regression bugs directly to reckless technical debt accumulation and missing validation boundaries.</td>
      <td style="padding: 4px 6px;">Mentions technical debt or bad agile, but misses root cause of regression bugs.</td>
      <td style="padding: 4px 6px;">Blames programmers or repeats question text.</td>
    </tr>
    <tr style="border-bottom: 1px solid #e2e8f0;">
      <td style="padding: 4px 6px; font-weight: 700; color: #0b3c5d;">2. Architecture Remedy (4 pts)</td>
      <td style="padding: 4px 6px;">Applies <strong>Composition</strong> (cascading lifecycle deletion to kill orphan records) and <strong>BCE separation</strong> (UI talks to Control service; Control manages Entity transactions).</td>
      <td style="padding: 4px 6px;">Suggests database foreign keys or backend API, but lacks UML/BCE design patterns.</td>
      <td style="padding: 4px 6px;">Suggests manual DB cleanup scripts.</td>
    </tr>
    <tr style="border-bottom: 1px solid #e2e8f0;">
      <td style="padding: 4px 6px; font-weight: 700; color: #0b3c5d;">3. Strategy & Length (3 pts)</td>
      <td style="padding: 4px 6px;">Provides structured 3-step remedy (e.g., CI/CD regression suite, WIP debt repayment quota). Strictly satisfies <strong>100–150 word</strong> constraint.</td>
      <td style="padding: 4px 6px;">Remedy is vague, or word count is slightly outside 100–150 words (80–99 or 151–175).</td>
      <td style="padding: 4px 6px;">Unstructured, or word count violates range severely.</td>
    </tr>
  </tbody>
</table>

<div class="exam-part-header" style="background: #059669;">
  <span>EXEMPLARY MODEL ANSWER (134 WORDS · 10/10 POINTS)</span>
  <span class="pts-badge">Word Count: 134 words</span>
</div>

<div style="background: #f0fdf4; border: 1.5px solid #86efac; border-left: 5px solid #16a34a; border-radius: 4px; padding: 8px 12px; font-size: 11.5px; line-height: 1.45; color: #1e293b; margin-bottom: 8px;">
  The team confused Agile with "cowboy coding." Abandoning architectural discipline accumulated reckless technical debt, where regression interest now consumes 60% of velocity.<br /><br />
  <strong>Concrete 3-Step Remedy:</strong><br />
  <strong>1. Model Lifecycle Dependencies:</strong> Redefine <code>Order</code> and <code>PaymentRecord</code> as a <em>Composition</em> (◆) relationship. Implement cascading deletion and foreign-key integrity constraints to eliminate orphaned records.<br />
  <strong>2. Enforce Boundary-Control-Entity (BCE):</strong> Decouple the UI Boundary from database Entities by inserting a <code>PaymentControl</code> service. This coordinator enforces business validation, atomicity, and encapsulates raw SQL into repositories.<br />
  <strong>3. Pay Down Technical Debt Incrementally:</strong> Establish automated CI/CD regression tests and allocate 20% of every sprint capacity to refactor tight coupling, restoring predictable velocity without halting product delivery.
</div>

<div style="background: #f8fafc; border: 1px solid #cbd5e1; border-radius: 4px; padding: 6px 10px; font-size: 10.5px; color: #475569; line-height: 1.38;">
  <strong>Examiner Notes on Common Pitfalls:</strong>
  <ul style="margin: 2px 0 0 16px; padding: 0;">
    <li><em>Pitfall A:</em> Suggesting "hire more developers" directly violates Brooks's Law and exacerbates velocity collapse.</li>
    <li><em>Pitfall B:</em> Proposing a complete system rewrite from scratch ignores business continuity; incremental refactoring is the standard engineering practice.</li>
    <li><em>Pitfall C:</em> Writing over 170 words or under 90 words incurs an automatic 1–2 point penalty on conciseness.</li>
  </ul>
</div>
