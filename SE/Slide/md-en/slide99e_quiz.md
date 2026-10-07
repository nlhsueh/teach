---
marp: true
theme: quiz-theme
paginate: true
size: 16:9
---

<!-- _class: lead -->
<!-- _header: '' -->
<!-- _footer: '' -->
<!-- _paginate: false -->

# **Advanced Software Engineering**
## Comprehensive Self-Study Quiz Deck (Chapters 1–3)

> "Tell me and I forget, teach me and I may remember, involve me and I learn." — Benjamin Franklin

<div style="display: flex; justify-content: center; gap: 14px; margin-top: 24px;">
  <span class="quiz-tag" style="font-size: 14px; padding: 6px 16px;">📘 3 Core Chapters</span>
  <span class="quiz-tag" style="font-size: 14px; padding: 6px 16px;">🎯 31 Conceptual Questions</span>
  <span class="quiz-tag" style="font-size: 14px; padding: 6px 16px;">💡 Instant Answer Feedback</span>
  <span class="quiz-tag" style="font-size: 14px; padding: 6px 16px;">⚡ Self-Paced Learning</span>
</div>

<!--
Welcome to the Comprehensive Self-Study Quiz Deck for Advanced Software Engineering!

This slide deck consolidates all 31 conceptual check questions spanning Chapter 1 (Introduction), Chapter 2 (Software Development Processes), and Chapter 3 (Requirements Engineering).

Unlike in-class live polling, this deck is engineered for self-paced mastery. When you click any choice in the HTML presentation, you will receive instant right-or-wrong verification accompanied by comprehensive explanations.

To summarize this slide, remember this key takeaway: Active self-testing is proven to accelerate conceptual retention and solidify software engineering mental models.
-->

---
<!-- header: 'ASE Self-Study Quiz Deck ▾ | Master Table of Contents' -->

## Self-Study Knowledge Map & Chapter Navigation

> Select any chapter below to begin self-testing, or use the header dropdown above to jump to any specific question.

<div class="three-columns" style="margin-top: 15px;">

<div class="card">
  <h3 style="color: #0284c7; margin-bottom: 6px;">📘 Chapter 1</h3>
  <h4 style="font-size: 15px; margin-bottom: 8px;">Introduction to SE</h4>
  <p style="font-size: 13px; color: #64748b; line-height: 1.4;">Software crisis, IEEE definition, core activities, Brooks's law, SoC, ISO 25010, ethics & AI churn.</p>
  <ul style="font-size: 13.5px; line-height: 1.4; margin-top: 6px;">
    <li><strong>Questions:</strong> Q01 – Q09 (9 Qs)</li>
    <li><strong>Target:</strong> Core Mental Models</li>
  </ul>
  <div style="margin-top: 12px; text-align: center;">
    <a href="#4" class="btn-primary" style="display: inline-block; padding: 4px 14px; font-size: 13px; text-decoration: none; border-radius: 6px; background: #0284c7; color: #fff; font-weight: 700;">Start Chapter 1 ➔</a>
  </div>
</div>

<div class="card">
  <h3 style="color: #0284c7; margin-bottom: 6px;">⚙️ Chapter 2</h3>
  <h4 style="font-size: 15px; margin-bottom: 8px;">Process Models</h4>
  <p style="font-size: 13px; color: #64748b; line-height: 1.4;">Waterfall, V-Model, MVP, Agile Manifesto, Kanban WIP, Scrum, Tech Debt, XP, TDD & CI/CD.</p>
  <ul style="font-size: 13.5px; line-height: 1.4; margin-top: 6px;">
    <li><strong>Questions:</strong> Q10 – Q23 (14 Qs)</li>
    <li><strong>Target:</strong> Workflow & Agility</li>
  </ul>
  <div style="margin-top: 12px; text-align: center;">
    <a href="#14" class="btn-primary" style="display: inline-block; padding: 4px 14px; font-size: 13px; text-decoration: none; border-radius: 6px; background: #0284c7; color: #fff; font-weight: 700;">Start Chapter 2 ➔</a>
  </div>
</div>

<div class="card">
  <h3 style="color: #0284c7; margin-bottom: 6px;">📋 Chapter 3</h3>
  <h4 style="font-size: 15px; margin-bottom: 8px;">Requirements Eng.</h4>
  <p style="font-size: 13px; color: #64748b; line-height: 1.4;">User vs. System, Domain, Measurable NFRs, 5 Whys, Tacit Knowledge, Use Cases & AI risks.</p>
  <ul style="font-size: 13.5px; line-height: 1.4; margin-top: 6px;">
    <li><strong>Questions:</strong> Q24 – Q31 (8 Qs)</li>
    <li><strong>Target:</strong> Elicitation & Specs</li>
  </ul>
  <div style="margin-top: 12px; text-align: center;">
    <a href="#29" class="btn-primary" style="display: inline-block; padding: 4px 14px; font-size: 13px; text-decoration: none; border-radius: 6px; background: #0284c7; color: #fff; font-weight: 700;">Start Chapter 3 ➔</a>
  </div>
</div>

</div>

<!--
Here is the master navigation map for our 31 questions.

You can proceed linearly from question 1 to 31, or jump directly into any specific chapter using the cards on this slide.

Notice that the header at the top right contains an interactive dropdown. At any point during your quiz, click or hover the header to reveal the chapter question grid.

To summarize this slide, remember this key takeaway: Navigate freely across chapters to focus on areas where you seek the deepest conceptual reinforcement.
-->

---
<!-- _class: lead -->
<!-- header: 'Ch 1. Introduction | Overview ▾' -->

# **Chapter 1. Introduction to Software Engineering**
## Foundations, Complexity, Professional Ethics & AI Impact

> "The first false assumption: All programmers are created equal. The second: More programmers will make it faster." — *Fred Brooks*

<div style="margin-top: 20px;">
  <span class="quiz-tag" style="font-size: 14px; padding: 6px 16px;">🎯 9 Questions (Q01 – Q09)</span>
</div>

<!--
Entering Chapter 1. Introduction to Software Engineering.

This section challenges your grasp on the fundamental principles introduced in this chapter.

Read each scenario carefully, make your selection, and review the detailed rationale.

To summarize this slide, remember this key takeaway: Reflect critically on each question before clicking your final answer.
-->

---
<!-- header: 'Ch 1. Introduction | Q01 of 31 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 1. Introduction • Question 01</span>
    <span class="quiz-prog">Topic: Software Crisis & Complexity</span>
  </div>

  <div class="quiz-qbox">
    Why couldn't the 1968 Software Crisis be resolved simply by purchasing faster computer hardware or larger memory?
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="false">
      <span class="q-badge">A</span>
      <span class="q-text">Computer hardware manufacturing and memory fabrication completely stagnated in the late 1960s, preventing computational speedups.</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="true">
      <span class="q-badge">B</span>
      <span class="q-text">The crisis was fundamentally an intellectual and organizational challenge of system complexity, which faster hardware only amplified.</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">Programming languages of that era strictly lacked mathematical calculation primitives and compiler memory allocation capabilities.</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">Early mainframe computers were physically incompatible with shared telecommunication networks and multi-terminal architectures.</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 Click an option above to test your understanding</span>
      <span class="btn-retry" style="display: none;">↺ Retry</span>
    </div>
    <div class="fb-body">
      <strong>💡 Correct Answer: B</strong> — The crisis was fundamentally an intellectual and organizational failure in managing system complexity. Increasing hardware capacity allowed organizations to build systems of unprecedented scale, which human programmers using ad-hoc, informal techniques could not manage. Faster CPU chips do not fix missing requirements, tangled spaghetti dependencies, or miscommunicated interface contracts.
    </div>
  </div>
</div>

<!--
Let us examine Question 1: Software Crisis & Complexity.

The core challenge asks: Why couldn't the 1968 Software Crisis be resolved simply by purchasing faster computer hardware or larger memory?

Option B is correct because: The crisis was fundamentally an intellectual and organizational failure in managing system complexity. Increasing hardware capacity allowed organizations to build systems of unprecedented scale, which human programmers using ad-hoc, informal techniques could not manage. Faster CPU chips do not fix missing requirements, tangled spaghetti dependencies, or miscommunicated interface contracts.

To summarize this slide, remember this key takeaway: Software Crisis & Complexity highlights that software engineering requires disciplined problem definition rather than ad-hoc speculation.
-->

---
<!-- header: 'Ch 1. Introduction | Q02 of 31 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 1. Introduction • Question 02</span>
    <span class="quiz-prog">Topic: IEEE Software Definition</span>
  </div>

  <div class="quiz-qbox">
    According to the IEEE standard definition of software, which of the following is NOT considered a component of software?
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="false">
      <span class="q-badge">A</span>
      <span class="q-text">Executable computer programs and source code files.</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="false">
      <span class="q-badge">B</span>
      <span class="q-text">System database schemas and configuration files.</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="true">
      <span class="q-badge">C</span>
      <span class="q-text">CPU processor hardware and physical memory units.</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">Software installation and deployment procedures.</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 Click an option above to test your understanding</span>
      <span class="btn-retry" style="display: none;">↺ Retry</span>
    </div>
    <div class="fb-body">
      <strong>💡 Correct Answer: C</strong> — The IEEE standard defines software as computer programs, procedures, and possibly associated documentation and data. CPU hardware and physical memory are physical electronic devices (hardware) that execute software, rather than components of the software itself.
    </div>
  </div>
</div>

<!--
Let us examine Question 2: IEEE Software Definition.

The core challenge asks: According to the IEEE standard definition of software, which of the following is NOT considered a component of software?

Option C is correct because: The IEEE standard defines software as computer programs, procedures, and possibly associated documentation and data. CPU hardware and physical memory are physical electronic devices (hardware) that execute software, rather than components of the software itself.

To summarize this slide, remember this key takeaway: IEEE Software Definition highlights that software engineering requires disciplined problem definition rather than ad-hoc speculation.
-->

---
<!-- header: 'Ch 1. Introduction | Q03 of 31 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 1. Introduction • Question 03</span>
    <span class="quiz-prog">Topic: Core Engineering Activities</span>
  </div>

  <div class="quiz-qbox">
    Which of the following pairs correctly matches a specific software engineering action with its corresponding universal core activity?
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="true">
      <span class="q-badge">A</span>
      <span class="q-text">Conducting stakeholder interviews to draft user stories → Software Specification</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="false">
      <span class="q-badge">B</span>
      <span class="q-text">Writing automated unit tests to mock database responses → Software Design & Implementation</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">Refactoring database schemas to improve query speed → Software Validation</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">Swapping a third-party payment API for a new gateway → Software Specification</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 Click an option above to test your understanding</span>
      <span class="btn-retry" style="display: none;">↺ Retry</span>
    </div>
    <div class="fb-body">
      <strong>💡 Correct Answer: A</strong> — Eliciting and modeling requirements through stakeholder interviews is a direct action in Software Specification. Writing unit tests is part of Software Validation (specifically verification). Refactoring database schemas is Software Evolution (preventive/perfective maintenance). Swapping APIs is Design & Implementation or Evolution.
    </div>
  </div>
</div>

<!--
Let us examine Question 3: Core Engineering Activities.

The core challenge asks: Which of the following pairs correctly matches a specific software engineering action with its corresponding universal core activity?

Option A is correct because: Eliciting and modeling requirements through stakeholder interviews is a direct action in Software Specification. Writing unit tests is part of Software Validation (specifically verification). Refactoring database schemas is Software Evolution (preventive/perfective maintenance). Swapping APIs is Design & Implementation or Evolution.

To summarize this slide, remember this key takeaway: Core Engineering Activities highlights that software engineering requires disciplined problem definition rather than ad-hoc speculation.
-->

---
<!-- header: 'Ch 1. Introduction | Q04 of 31 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 1. Introduction • Question 04</span>
    <span class="quiz-prog">Topic: Brooks's Law & Team Scaling</span>
  </div>

  <div class="quiz-qbox">
    A project is 3 weeks behind schedule with 2 weeks remaining before release. The manager hires 4 junior programmers to speed up progress. What will happen according to Brooks's Law?
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="false">
      <span class="q-badge">A</span>
      <span class="q-text">The project will finish 1 week early.</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="true">
      <span class="q-badge">B</span>
      <span class="q-text">The project will be delayed further because senior engineers must spend time onboarding and mentoring new hires.</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">The existing developers will code twice as fast.</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">Communication complexity remains unchanged.</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 Click an option above to test your understanding</span>
      <span class="btn-retry" style="display: none;">↺ Retry</span>
    </div>
    <div class="fb-body">
      <strong>💡 Correct Answer: B</strong> — Frederick Brooks demonstrated in The Mythical Man-Month that complex software development is not partitionable like manual labor. Adding people to a late project increases communication overhead quadratically according to n(n-1)/2, while senior engineers must stop productive coding to onboard newcomers.
    </div>
  </div>
</div>

<!--
Let us examine Question 4: Brooks's Law & Team Scaling.

The core challenge asks: A project is 3 weeks behind schedule with 2 weeks remaining before release. The manager hires 4 junior programmers to speed up progress. What will happen according to Brooks's Law?

Option B is correct because: Frederick Brooks demonstrated in The Mythical Man-Month that complex software development is not partitionable like manual labor. Adding people to a late project increases communication overhead quadratically according to n(n-1)/2, while senior engineers must stop productive coding to onboard newcomers.

To summarize this slide, remember this key takeaway: Brooks's Law & Team Scaling highlights that software engineering requires disciplined problem definition rather than ad-hoc speculation.
-->

---
<!-- header: 'Ch 1. Introduction | Q05 of 31 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 1. Introduction • Question 05</span>
    <span class="quiz-prog">Topic: Separation of Concerns</span>
  </div>

  <div class="quiz-qbox">
    An order-processing module directly handles HTTP requests, executes payment transactions, queries the SQL database, and generates HTML receipt emails. Which fundamental design principle is most severely violated?
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="true">
      <span class="q-badge">A</span>
      <span class="q-text">Separation of Concerns: Multiple distinct responsibilities are tightly tangled in a single module.</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="false">
      <span class="q-badge">B</span>
      <span class="q-text">YAGNI: Speculative future features are implemented before actual business requirements emerge.</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">Brooks's Law: Adding developers to the order module increases communication complexity exponentially.</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">Anticipation of Change: System configurations are hardcoded into compiled production binaries.</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 Click an option above to test your understanding</span>
      <span class="btn-retry" style="display: none;">↺ Retry</span>
    </div>
    <div class="fb-body">
      <strong>💡 Correct Answer: A</strong> — Separation of Concerns (and the Single Responsibility Principle) dictates that a module should have only one reason to change and encapsulate a single coherent responsibility. Tangling HTTP routing, business payment processing, database access, and UI rendering in one module creates severe coupling and high fragility.
    </div>
  </div>
</div>

<!--
Let us examine Question 5: Separation of Concerns.

The core challenge asks: An order-processing module directly handles HTTP requests, executes payment transactions, queries the SQL database, and generates HTML receipt emails. Which fundamental design principle is most severely violated?

Option A is correct because: Separation of Concerns (and the Single Responsibility Principle) dictates that a module should have only one reason to change and encapsulate a single coherent responsibility. Tangling HTTP routing, business payment processing, database access, and UI rendering in one module creates severe coupling and high fragility.

To summarize this slide, remember this key takeaway: Separation of Concerns highlights that software engineering requires disciplined problem definition rather than ad-hoc speculation.
-->

---
<!-- header: 'Ch 1. Introduction | Q06 of 31 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 1. Introduction • Question 06</span>
    <span class="quiz-prog">Topic: ISO 25010 Quality Model</span>
  </div>

  <div class="quiz-qbox">
    Which of the following matches a real-world software issue with its corresponding ISO 25010 quality characteristic?
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="false">
      <span class="q-badge">A</span>
      <span class="q-text">A database query taking 15 seconds to return results → Maintainability (Testability)</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="true">
      <span class="q-badge">B</span>
      <span class="q-text">A system crash occurring when a third-party API goes offline → Reliability (Fault Tolerance)</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">Developers struggling to write unit tests due to tight coupling → Portability (Adaptability)</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">An unencrypted session cookie allowing account takeover → Usability (Operability)</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 Click an option above to test your understanding</span>
      <span class="btn-retry" style="display: none;">↺ Retry</span>
    </div>
    <div class="fb-body">
      <strong>💡 Correct Answer: B</strong> — A system's ability to cope with external service failures without crashing is the definition of Fault Tolerance (a sub-characteristic of Reliability). Slow query execution is Performance Efficiency (Time Behavior). Struggling to write unit tests is Maintainability (Testability). Unencrypted session cookies belong to Security (Confidentiality).
    </div>
  </div>
</div>

<!--
Let us examine Question 6: ISO 25010 Quality Model.

The core challenge asks: Which of the following matches a real-world software issue with its corresponding ISO 25010 quality characteristic?

Option B is correct because: A system's ability to cope with external service failures without crashing is the definition of Fault Tolerance (a sub-characteristic of Reliability). Slow query execution is Performance Efficiency (Time Behavior). Struggling to write unit tests is Maintainability (Testability). Unencrypted session cookies belong to Security (Confidentiality).

To summarize this slide, remember this key takeaway: ISO 25010 Quality Model highlights that software engineering requires disciplined problem definition rather than ad-hoc speculation.
-->

---
<!-- header: 'Ch 1. Introduction | Q07 of 31 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 1. Introduction • Question 07</span>
    <span class="quiz-prog">Topic: ACM/IEEE Code of Ethics</span>
  </div>

  <div class="quiz-qbox">
    Under the ACM/IEEE Code of Ethics, if an employer directs an engineer to implement an algorithm that falsifies safety compliance reports, what is the engineer's obligation?
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="false">
      <span class="q-badge">A</span>
      <span class="q-text">Comply, because the employer pays the engineer's salary.</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="true">
      <span class="q-badge">B</span>
      <span class="q-text">Refuse and escalate, because the Public Interest takes precedence over Employer loyalty.</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">Implement the code but omit documentation.</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">Outsource the code to an external vendor.</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 Click an option above to test your understanding</span>
      <span class="btn-retry" style="display: none;">↺ Retry</span>
    </div>
    <div class="fb-body">
      <strong>💡 Correct Answer: B</strong> — Principle 1 of the ACM/IEEE Software Engineering Code of Ethics states that software engineers shall act consistently with the public interest, which takes absolute precedence over loyalty to an employer or client.
    </div>
  </div>
</div>

<!--
Let us examine Question 7: ACM/IEEE Code of Ethics.

The core challenge asks: Under the ACM/IEEE Code of Ethics, if an employer directs an engineer to implement an algorithm that falsifies safety compliance reports, what is the engineer's obligation?

Option B is correct because: Principle 1 of the ACM/IEEE Software Engineering Code of Ethics states that software engineers shall act consistently with the public interest, which takes absolute precedence over loyalty to an employer or client.

To summarize this slide, remember this key takeaway: ACM/IEEE Code of Ethics highlights that software engineering requires disciplined problem definition rather than ad-hoc speculation.
-->

---
<!-- header: 'Ch 1. Introduction | Q08 of 31 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 1. Introduction • Question 08</span>
    <span class="quiz-prog">Topic: Code Churn & AI Assistants</span>
  </div>

  <div class="quiz-qbox">
    In empirical studies evaluating AI coding assistants (such as GitClear's analysis of 150M lines of code), &quot;Code Churn&quot; emerged as a major warning sign. What does high Code Churn indicate in an AI-assisted codebase?
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="true">
      <span class="q-badge">A</span>
      <span class="q-text">Code is rapidly rewritten, deleted, or patched shortly after commit, indicating brittle code accepted without sufficient verification.</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="false">
      <span class="q-badge">B</span>
      <span class="q-text">Compilers and bundlers are aggressively removing unreachable dead code from application binaries during automated deployment.</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">Software engineering teams are switching programming languages frequently due to automated polyglot syntax translation.</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">Automated test cases are executing too quickly and depleting available CI/CD pipeline virtual machine compute resources.</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 Click an option above to test your understanding</span>
      <span class="btn-retry" style="display: none;">↺ Retry</span>
    </div>
    <div class="fb-body">
      <strong>💡 Correct Answer: A</strong> — Code churn measures the percentage of code that is modified, replaced, or deleted within two weeks of being committed. In AI coding environments, high code churn reveals that developers rapidly accept AI suggestions that compile on localhost but fail under real-world integration, forcing frequent rewrites and accumulating maintainability debt.
    </div>
  </div>
</div>

<!--
Let us examine Question 8: Code Churn & AI Assistants.

The core challenge asks: In empirical studies evaluating AI coding assistants (such as GitClear's analysis of 150M lines of code), &quot;Code Churn&quot; emerged as a major warning sign. What does high Code Churn indicate in an AI-assisted codebase?

Option A is correct because: Code churn measures the percentage of code that is modified, replaced, or deleted within two weeks of being committed. In AI coding environments, high code churn reveals that developers rapidly accept AI suggestions that compile on localhost but fail under real-world integration, forcing frequent rewrites and accumulating maintainability debt.

To summarize this slide, remember this key takeaway: Code Churn & AI Assistants highlights that software engineering requires disciplined problem definition rather than ad-hoc speculation.
-->

---
<!-- header: 'Ch 1. Introduction | Q09 of 31 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 1. Introduction • Question 09</span>
    <span class="quiz-prog">Topic: GenAI Architectural Slop Risk</span>
  </div>

  <div class="quiz-qbox">
    An engineer prompts an AI to generate a complex payment calculation module, and then asks the same AI to write unit tests without providing a formal specification. All tests pass. What is the primary risk?
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="true">
      <span class="q-badge">A</span>
      <span class="q-text">Echo-chamber validation: The generated tests merely mirror the AI's internal flawed assumptions rather than actual business requirements.</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="false">
      <span class="q-badge">B</span>
      <span class="q-text">Performance bottleneck: AI-generated test assertions take significantly longer to execute than human-written assertions.</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">Compilation failure: Testing frameworks cannot parse automated mock datasets generated by large language models.</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">Version lock-in: The test suite becomes tightly coupled to a single specific cloud runtime environment.</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 Click an option above to test your understanding</span>
      <span class="btn-retry" style="display: none;">↺ Retry</span>
    </div>
    <div class="fb-body">
      <strong>💡 Correct Answer: A</strong> — When AI writes both the implementation and its own test cases without an independent specification contract, it falls into "echo-chamber testing"—validating only what it assumed, rather than what the system is actually required to do. Independent verification is required ("Who tests the tester?").
    </div>
  </div>
</div>

<!--
Let us examine Question 9: GenAI Architectural Slop Risk.

The core challenge asks: An engineer prompts an AI to generate a complex payment calculation module, and then asks the same AI to write unit tests without providing a formal specification. All tests pass. What is the primary risk?

Option A is correct because: When AI writes both the implementation and its own test cases without an independent specification contract, it falls into "echo-chamber testing"—validating only what it assumed, rather than what the system is actually required to do. Independent verification is required ("Who tests the tester?").

To summarize this slide, remember this key takeaway: GenAI Architectural Slop Risk highlights that software engineering requires disciplined problem definition rather than ad-hoc speculation.
-->

---
<!-- _class: lead -->
<!-- header: 'Ch 2. Development Processes | Overview ▾' -->

# **Chapter 2. Software Development Processes & Methodologies**
## Plan-Driven vs. Agile, Scrum, Kanban, Technical Debt & Extreme Programming

> "Individuals and interactions over processes and tools; working software over comprehensive documentation." — *Agile Manifesto (2001)*

<div style="margin-top: 20px;">
  <span class="quiz-tag" style="font-size: 14px; padding: 6px 16px;">🎯 14 Questions (Q10 – Q23)</span>
</div>

<!--
Entering Chapter 2. Software Development Processes & Methodologies.

This section challenges your grasp on the fundamental principles introduced in this chapter.

Read each scenario carefully, make your selection, and review the detailed rationale.

To summarize this slide, remember this key takeaway: Reflect critically on each question before clicking your final answer.
-->

---
<!-- header: 'Ch 2. Development Processes | Q10 of 31 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 2. Development Processes • Question 10</span>
    <span class="quiz-prog">Topic: Waterfall Late Integration Risk</span>
  </div>

  <div class="quiz-qbox">
    What is the primary operational drawback of the traditional Waterfall model?
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="false">
      <span class="q-badge">A</span>
      <span class="q-text">It produces inadequate documentation for external auditing and compliance.</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="true">
      <span class="q-badge">B</span>
      <span class="q-text">It makes accommodating changing requirements extremely difficult and costly once underway.</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">It eliminates the need for component and system testing during execution.</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">It cannot be deployed across large-scale multi-site engineering organizations.</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 Click an option above to test your understanding</span>
      <span class="btn-retry" style="display: none;">↺ Retry</span>
    </div>
    <div class="fb-body">
      <strong>💡 Correct Answer: B</strong> — The Waterfall model rigidly partitions activities into sequential stages with formal handoffs. Accommodating changing user needs requires costly backward iterations, contract renegotiation, and massive specification rework.
    </div>
  </div>
</div>

<!--
Let us examine Question 10: Waterfall Late Integration Risk.

The core challenge asks: What is the primary operational drawback of the traditional Waterfall model?

Option B is correct because: The Waterfall model rigidly partitions activities into sequential stages with formal handoffs. Accommodating changing user needs requires costly backward iterations, contract renegotiation, and massive specification rework.

To summarize this slide, remember this key takeaway: Waterfall Late Integration Risk highlights that software engineering requires disciplined problem definition rather than ad-hoc speculation.
-->

---
<!-- header: 'Ch 2. Development Processes | Q11 of 31 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 2. Development Processes • Question 11</span>
    <span class="quiz-prog">Topic: V-Model Verification & Validation</span>
  </div>

  <div class="quiz-qbox">
    What is the primary engineering advantage of the V-Model over the classic Waterfall model?
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="false">
      <span class="q-badge">A</span>
      <span class="q-text">It produces working software increments in short two-week sprint iterations.</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="true">
      <span class="q-badge">B</span>
      <span class="q-text">It enforces test planning and acceptance criteria design concurrently with early specification phases.</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">It eliminates the need for detailed architecture design and interface contracts.</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">It allows customers to dynamically modify requirements at zero cost during implementation.</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 Click an option above to test your understanding</span>
      <span class="btn-retry" style="display: none;">↺ Retry</span>
    </div>
    <div class="fb-body">
      <strong>💡 Correct Answer: B</strong> — The V-Model's definitive breakthrough is horizontal symmetry: test suites are authored concurrently with their corresponding specification phases (e.g., acceptance tests designed during requirements analysis), front-loading defect discovery.
    </div>
  </div>
</div>

<!--
Let us examine Question 11: V-Model Verification & Validation.

The core challenge asks: What is the primary engineering advantage of the V-Model over the classic Waterfall model?

Option B is correct because: The V-Model's definitive breakthrough is horizontal symmetry: test suites are authored concurrently with their corresponding specification phases (e.g., acceptance tests designed during requirements analysis), front-loading defect discovery.

To summarize this slide, remember this key takeaway: V-Model Verification & Validation highlights that software engineering requires disciplined problem definition rather than ad-hoc speculation.
-->

---
<!-- header: 'Ch 2. Development Processes | Q12 of 31 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 2. Development Processes • Question 12</span>
    <span class="quiz-prog">Topic: Incremental vs. Iterative Process</span>
  </div>

  <div class="quiz-qbox">
    In software process engineering, what is the fundamental conceptual difference between &quot;Incremental&quot; and &quot;Iterative&quot; development?
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="false">
      <span class="q-badge">A</span>
      <span class="q-text">Incremental focuses on automated testing; Iterative focuses on UI design.</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="true">
      <span class="q-badge">B</span>
      <span class="q-text">Incremental delivers finished functional slices stage-by-stage; Iterative refines an end-to-end working draft over repeated cycles.</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">Incremental is managed by product owners; Iterative is managed exclusively by external regulators.</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">Incremental follows waterfall rules; Iterative produces no documentation.</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 Click an option above to test your understanding</span>
      <span class="btn-retry" style="display: none;">↺ Retry</span>
    </div>
    <div class="fb-body">
      <strong>💡 Correct Answer: B</strong> — Incremental builds software piece by piece by vertical functional slices; iterative starts with a rough draft of the entire system and progressively refines depth, fidelity, and polish through repeated cycles.
    </div>
  </div>
</div>

<!--
Let us examine Question 12: Incremental vs. Iterative Process.

The core challenge asks: In software process engineering, what is the fundamental conceptual difference between &quot;Incremental&quot; and &quot;Iterative&quot; development?

Option B is correct because: Incremental builds software piece by piece by vertical functional slices; iterative starts with a rough draft of the entire system and progressively refines depth, fidelity, and polish through repeated cycles.

To summarize this slide, remember this key takeaway: Incremental vs. Iterative Process highlights that software engineering requires disciplined problem definition rather than ad-hoc speculation.
-->

---
<!-- header: 'Ch 2. Development Processes | Q13 of 31 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 2. Development Processes • Question 13</span>
    <span class="quiz-prog">Topic: Kniberg's MVP Analogy (Skateboard)</span>
  </div>

  <div class="quiz-qbox">
    In Henrik Kniberg's famous Minimum Viable Product (MVP) analogy (Skateboard to Car), why is delivering a standalone car wheel in the first release considered an anti-pattern?
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="false">
      <span class="q-badge">A</span>
      <span class="q-text">Because manufacturing an isolated wheel is significantly more expensive than building a skateboard.</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="true">
      <span class="q-badge">B</span>
      <span class="q-text">Because an isolated wheel provides zero end-to-end transportation value, preventing users from validating core problem assumptions.</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">Because modern vehicle designs prohibit upgrading wheels into scooters.</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">Because software engineering standards mandate that all early increments must be rectangular.</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 Click an option above to test your understanding</span>
      <span class="btn-retry" style="display: none;">↺ Retry</span>
    </div>
    <div class="fb-body">
      <strong>💡 Correct Answer: B</strong> — An MVP must deliver standalone, end-to-end usable value that solves a real user problem. A single wheel cannot transport a person, leaving the user dissatisfied and generating zero empirical feedback on transportation needs.
    </div>
  </div>
</div>

<!--
Let us examine Question 13: Kniberg's MVP Analogy (Skateboard).

The core challenge asks: In Henrik Kniberg's famous Minimum Viable Product (MVP) analogy (Skateboard to Car), why is delivering a standalone car wheel in the first release considered an anti-pattern?

Option B is correct because: An MVP must deliver standalone, end-to-end usable value that solves a real user problem. A single wheel cannot transport a person, leaving the user dissatisfied and generating zero empirical feedback on transportation needs.

To summarize this slide, remember this key takeaway: Kniberg's MVP Analogy (Skateboard) highlights that software engineering requires disciplined problem definition rather than ad-hoc speculation.
-->

---
<!-- header: 'Ch 2. Development Processes | Q14 of 31 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 2. Development Processes • Question 14</span>
    <span class="quiz-prog">Topic: Agile Manifesto Living Software</span>
  </div>

  <div class="quiz-qbox">
    The Agile Manifesto states: *&quot;Working software over comprehensive documentation.&quot;* What does this value primarily advocate in practice?
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="false">
      <span class="q-badge">A</span>
      <span class="q-text">Engineering teams are completely prohibited from writing architecture blueprints or API specifications.</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="true">
      <span class="q-badge">B</span>
      <span class="q-text">While documentation has value, delivering working, tested, and validated software is the primary measure of progress and customer value.</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">Projects should be evaluated solely on executive PowerPoint presentations.</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">Source code comments must be erased before deployment to production.</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 Click an option above to test your understanding</span>
      <span class="btn-retry" style="display: none;">↺ Retry</span>
    </div>
    <div class="fb-body">
      <strong>💡 Correct Answer: B</strong> — The Agile Manifesto emphasizes that running, tested software delivering actual business value takes precedence over generating exhaustive paperwork. Documentation is authored when it serves an essential communicative purpose, but never at the expense of working software.
    </div>
  </div>
</div>

<!--
Let us examine Question 14: Agile Manifesto Living Software.

The core challenge asks: The Agile Manifesto states: *&quot;Working software over comprehensive documentation.&quot;* What does this value primarily advocate in practice?

Option B is correct because: The Agile Manifesto emphasizes that running, tested software delivering actual business value takes precedence over generating exhaustive paperwork. Documentation is authored when it serves an essential communicative purpose, but never at the expense of working software.

To summarize this slide, remember this key takeaway: Agile Manifesto Living Software highlights that software engineering requires disciplined problem definition rather than ad-hoc speculation.
-->

---
<!-- header: 'Ch 2. Development Processes | Q15 of 31 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 2. Development Processes • Question 15</span>
    <span class="quiz-prog">Topic: Agile Sustainable Development Pace</span>
  </div>

  <div class="quiz-qbox">
    Agile Principle 8 states: *&quot;Agile processes promote sustainable development. The sponsors, developers, and users should be able to maintain a constant pace indefinitely.&quot;* What is the primary engineering motivation?
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="true">
      <span class="q-badge">A</span>
      <span class="q-text">To prevent code quality degradation, accumulated defects, and developer burnout caused by chronic overtime and crunch periods.</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="false">
      <span class="q-badge">B</span>
      <span class="q-text">To mandate that developers submit at least 50 pull requests per day.</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">To eliminate the need for software upgrades after initial system launch.</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">To restrict development teams to working only on legacy systems.</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 Click an option above to test your understanding</span>
      <span class="btn-retry" style="display: none;">↺ Retry</span>
    </div>
    <div class="fb-body">
      <strong>💡 Correct Answer: A</strong> — Chronic overtime causes severe cognitive fatigue, multiplying defect injection rates and accelerating developer burnout. A sustainable, predictable pace produces higher quality code and predictable delivery velocity over years.
    </div>
  </div>
</div>

<!--
Let us examine Question 15: Agile Sustainable Development Pace.

The core challenge asks: Agile Principle 8 states: *&quot;Agile processes promote sustainable development. The sponsors, developers, and users should be able to maintain a constant pace indefinitely.&quot;* What is the primary engineering motivation?

Option A is correct because: Chronic overtime causes severe cognitive fatigue, multiplying defect injection rates and accelerating developer burnout. A sustainable, predictable pace produces higher quality code and predictable delivery velocity over years.

To summarize this slide, remember this key takeaway: Agile Sustainable Development Pace highlights that software engineering requires disciplined problem definition rather than ad-hoc speculation.
-->

---
<!-- header: 'Ch 2. Development Processes | Q16 of 31 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 2. Development Processes • Question 16</span>
    <span class="quiz-prog">Topic: Kanban WIP Limits & Flow Control</span>
  </div>

  <div class="quiz-qbox">
    In the Kanban process framework, what is the primary operational purpose of enforcing strict &quot;Work In Progress&quot; (WIP) limits on columns?
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="false">
      <span class="q-badge">A</span>
      <span class="q-text">To prevent developers from modifying automated unit test scripts.</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="true">
      <span class="q-badge">B</span>
      <span class="q-text">To expose bottlenecks, reduce multitasking context-switching waste, and maximize delivery flow throughput.</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">To mandate that every team member attends daily 15-minute standup meetings.</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">To ensure all software increments are packaged into fixed 2-week sprint iterations.</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 Click an option above to test your understanding</span>
      <span class="btn-retry" style="display: none;">↺ Retry</span>
    </div>
    <div class="fb-body">
      <strong>💡 Correct Answer: B</strong> — By restricting WIP limits, teams prevent hidden queues, eliminate context-switching waste, and immediately highlight process bottlenecks where cards pile up.
    </div>
  </div>
</div>

<!--
Let us examine Question 16: Kanban WIP Limits & Flow Control.

The core challenge asks: In the Kanban process framework, what is the primary operational purpose of enforcing strict &quot;Work In Progress&quot; (WIP) limits on columns?

Option B is correct because: By restricting WIP limits, teams prevent hidden queues, eliminate context-switching waste, and immediately highlight process bottlenecks where cards pile up.

To summarize this slide, remember this key takeaway: Kanban WIP Limits & Flow Control highlights that software engineering requires disciplined problem definition rather than ad-hoc speculation.
-->

---
<!-- header: 'Ch 2. Development Processes | Q17 of 31 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 2. Development Processes • Question 17</span>
    <span class="quiz-prog">Topic: Daily Scrum Coordination Goals</span>
  </div>

  <div class="quiz-qbox">
    In the Scrum framework, what is the primary operational objective of the **Sprint Retrospective** held at the end of each sprint?
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="false">
      <span class="q-badge">A</span>
      <span class="q-text">To demonstrate working software increments to external business stakeholders.</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="true">
      <span class="q-badge">B</span>
      <span class="q-text">To inspect internal team collaboration, engineering practices, and tools, and identify actionable process improvements for the next sprint.</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">To assign individual performance ratings and conduct annual salary reviews.</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">To rewrite the entire product backlog and discard unfinished user stories.</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 Click an option above to test your understanding</span>
      <span class="btn-retry" style="display: none;">↺ Retry</span>
    </div>
    <div class="fb-body">
      <strong>💡 Correct Answer: B</strong> — While the Sprint Review focuses on inspecting the product with stakeholders, the Sprint Retrospective focuses inward on the team's processes, collaboration dynamics, and engineering practices to implement continuous self-improvement.
    </div>
  </div>
</div>

<!--
Let us examine Question 17: Daily Scrum Coordination Goals.

The core challenge asks: In the Scrum framework, what is the primary operational objective of the **Sprint Retrospective** held at the end of each sprint?

Option B is correct because: While the Sprint Review focuses on inspecting the product with stakeholders, the Sprint Retrospective focuses inward on the team's processes, collaboration dynamics, and engineering practices to implement continuous self-improvement.

To summarize this slide, remember this key takeaway: Daily Scrum Coordination Goals highlights that software engineering requires disciplined problem definition rather than ad-hoc speculation.
-->

---
<!-- header: 'Ch 2. Development Processes | Q18 of 31 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 2. Development Processes • Question 18</span>
    <span class="quiz-prog">Topic: Technical Debt Metaphor</span>
  </div>

  <div class="quiz-qbox">
    According to Ward Cunningham's Technical Debt metaphor, what represents the &quot;compounding interest&quot; paid by a software organization?
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="false">
      <span class="q-badge">A</span>
      <span class="q-text">The annual licensing fees paid for cloud hosting infrastructure and IDEs.</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="true">
      <span class="q-badge">B</span>
      <span class="q-text">The ongoing extra time, degraded velocity, and regression defects suffered during all future development.</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">The bonus compensation paid to engineers who complete sprint tickets ahead of schedule.</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">The legal costs of acquiring open-source third-party dependencies.</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 Click an option above to test your understanding</span>
      <span class="btn-retry" style="display: none;">↺ Retry</span>
    </div>
    <div class="fb-body">
      <strong>💡 Correct Answer: B</strong> — The interest on technical debt is the extra friction and slowed velocity encountered every time engineers attempt to add new features or modify brittle, untested, poorly factored code.
    </div>
  </div>
</div>

<!--
Let us examine Question 18: Technical Debt Metaphor.

The core challenge asks: According to Ward Cunningham's Technical Debt metaphor, what represents the &quot;compounding interest&quot; paid by a software organization?

Option B is correct because: The interest on technical debt is the extra friction and slowed velocity encountered every time engineers attempt to add new features or modify brittle, untested, poorly factored code.

To summarize this slide, remember this key takeaway: Technical Debt Metaphor highlights that software engineering requires disciplined problem definition rather than ad-hoc speculation.
-->

---
<!-- header: 'Ch 2. Development Processes | Q19 of 31 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 2. Development Processes • Question 19</span>
    <span class="quiz-prog">Topic: Martin Fowler's Flaccid Scrum</span>
  </div>

  <div class="quiz-qbox">
    Martin Fowler coined the term **&quot;Flaccid Scrum&quot;** to describe which critical software engineering failure?
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="true">
      <span class="q-badge">A</span>
      <span class="q-text">Adopting Scrum management ceremonies (daily standups, sprints, story points) while completely neglecting technical engineering practices like TDD, refactoring, and CI.</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="false">
      <span class="q-badge">B</span>
      <span class="q-text">Refusing to use Jira or commercial issue tracking software in favor of physical sticky notes.</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">Allowing product owners to adjust backlog priorities between sprint planning sessions.</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">Enforcing automated test execution on every Git commit in the continuous integration pipeline.</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 Click an option above to test your understanding</span>
      <span class="btn-retry" style="display: none;">↺ Retry</span>
    </div>
    <div class="fb-body">
      <strong>💡 Correct Answer: A</strong> — Flaccid Scrum occurs when organizations adopt agile project management rituals but ignore engineering craftsmanship. Without automated tests, refactoring, and clean architecture, code quickly becomes fragile and unmaintainable.
    </div>
  </div>
</div>

<!--
Let us examine Question 19: Martin Fowler's Flaccid Scrum.

The core challenge asks: Martin Fowler coined the term **&quot;Flaccid Scrum&quot;** to describe which critical software engineering failure?

Option A is correct because: Flaccid Scrum occurs when organizations adopt agile project management rituals but ignore engineering craftsmanship. Without automated tests, refactoring, and clean architecture, code quickly becomes fragile and unmaintainable.

To summarize this slide, remember this key takeaway: Martin Fowler's Flaccid Scrum highlights that software engineering requires disciplined problem definition rather than ad-hoc speculation.
-->

---
<!-- header: 'Ch 2. Development Processes | Q20 of 31 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 2. Development Processes • Question 20</span>
    <span class="quiz-prog">Topic: XP Pair Programming Roles</span>
  </div>

  <div class="quiz-qbox">
    In Extreme Programming (XP), what is the primary role of the &quot;Navigator&quot; during a pair programming session?
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="false">
      <span class="q-badge">A</span>
      <span class="q-text">Typing out code syntax and executing local terminal commands.</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="true">
      <span class="q-badge">B</span>
      <span class="q-text">Thinking strategically, reviewing code in real time, considering edge cases, and looking at the broader architecture.</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">Serving as the official sprint facilitator and managing Jira backlog ticket status.</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">Negotiating customer contracts and approving annual engineering budgets.</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 Click an option above to test your understanding</span>
      <span class="btn-retry" style="display: none;">↺ Retry</span>
    </div>
    <div class="fb-body">
      <strong>💡 Correct Answer: B</strong> — In pair programming, the Driver types the code while the Navigator thinks strategically, reviews code in real time, catches bugs, considers edge cases, and ensures the implementation aligns with overall architecture.
    </div>
  </div>
</div>

<!--
Let us examine Question 20: XP Pair Programming Roles.

The core challenge asks: In Extreme Programming (XP), what is the primary role of the &quot;Navigator&quot; during a pair programming session?

Option B is correct because: In pair programming, the Driver types the code while the Navigator thinks strategically, reviews code in real time, catches bugs, considers edge cases, and ensures the implementation aligns with overall architecture.

To summarize this slide, remember this key takeaway: XP Pair Programming Roles highlights that software engineering requires disciplined problem definition rather than ad-hoc speculation.
-->

---
<!-- header: 'Ch 2. Development Processes | Q21 of 31 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 2. Development Processes • Question 21</span>
    <span class="quiz-prog">Topic: TDD Red-Green-Refactor Cycle</span>
  </div>

  <div class="quiz-qbox">
    In Extreme Programming's Test-Driven Development (TDD), what is the specific objective of the **&quot;Refactor&quot;** step in the Red-Green-Refactor cycle?
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="false">
      <span class="q-badge">A</span>
      <span class="q-text">Adding new functional capabilities and expanding the module's public API contract.</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="true">
      <span class="q-badge">B</span>
      <span class="q-text">Improving the internal structure and readability of the code while ensuring all existing automated tests continue to pass.</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">Removing unit tests that take longer than one second to execute in the local test suite.</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">Rewriting the application from an object-oriented language to a functional programming language.</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 Click an option above to test your understanding</span>
      <span class="btn-retry" style="display: none;">↺ Retry</span>
    </div>
    <div class="fb-body">
      <strong>💡 Correct Answer: B</strong> — Refactoring strictly means altering the internal structure of software to make it easier to understand and cheaper to modify without changing its observable external behavior, protected by passing unit tests.
    </div>
  </div>
</div>

<!--
Let us examine Question 21: TDD Red-Green-Refactor Cycle.

The core challenge asks: In Extreme Programming's Test-Driven Development (TDD), what is the specific objective of the **&quot;Refactor&quot;** step in the Red-Green-Refactor cycle?

Option B is correct because: Refactoring strictly means altering the internal structure of software to make it easier to understand and cheaper to modify without changing its observable external behavior, protected by passing unit tests.

To summarize this slide, remember this key takeaway: TDD Red-Green-Refactor Cycle highlights that software engineering requires disciplined problem definition rather than ad-hoc speculation.
-->

---
<!-- header: 'Ch 2. Development Processes | Q22 of 31 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 2. Development Processes • Question 22</span>
    <span class="quiz-prog">Topic: Continuous Delivery vs. Deployment</span>
  </div>

  <div class="quiz-qbox">
    What is the defining operational distinction between &quot;Continuous Delivery&quot; and &quot;Continuous Deployment&quot;?
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="false">
      <span class="q-badge">A</span>
      <span class="q-text">Continuous Delivery requires manual code compilation; Continuous Deployment automates compilation.</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="true">
      <span class="q-badge">B</span>
      <span class="q-text">Continuous Delivery stops at staging and requires human business approval to release; Continuous Deployment automatically deploys passing builds directly to live production.</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">Continuous Delivery is used solely for mobile apps; Continuous Deployment is used solely for backend databases.</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">Continuous Delivery eliminates unit testing; Continuous Deployment mandates pair programming.</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 Click an option above to test your understanding</span>
      <span class="btn-retry" style="display: none;">↺ Retry</span>
    </div>
    <div class="fb-body">
      <strong>💡 Correct Answer: B</strong> — Continuous Delivery ensures that every build passing the automated pipeline is immediately deployable to production, but waits for a human business decision. Continuous Deployment automatically promotes every passing build straight to production with zero manual gates.
    </div>
  </div>
</div>

<!--
Let us examine Question 22: Continuous Delivery vs. Deployment.

The core challenge asks: What is the defining operational distinction between &quot;Continuous Delivery&quot; and &quot;Continuous Deployment&quot;?

Option B is correct because: Continuous Delivery ensures that every build passing the automated pipeline is immediately deployable to production, but waits for a human business decision. Continuous Deployment automatically promotes every passing build straight to production with zero manual gates.

To summarize this slide, remember this key takeaway: Continuous Delivery vs. Deployment highlights that software engineering requires disciplined problem definition rather than ad-hoc speculation.
-->

---
<!-- header: 'Ch 2. Development Processes | Q23 of 31 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 2. Development Processes • Question 23</span>
    <span class="quiz-prog">Topic: Automated CI/CD Quality Gates</span>
  </div>

  <div class="quiz-qbox">
    In modern AI Specification-Driven development, what is the primary role of automated CI/CD verification gates?
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="false">
      <span class="q-badge">A</span>
      <span class="q-text">To prevent human developers from reviewing artificial intelligence output.</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="true">
      <span class="q-badge">B</span>
      <span class="q-text">To enforce deterministic quality, test compliance, and defect containment before AI-generated code merges into production.</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">To convert natural language prompts directly into cloud infrastructure invoices.</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">To replace software specifications with unverified prompt histories.</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 Click an option above to test your understanding</span>
      <span class="btn-retry" style="display: none;">↺ Retry</span>
    </div>
    <div class="fb-body">
      <strong>💡 Correct Answer: B</strong> — AI coding agents can generate code rapidly, but they may introduce subtle hallucinations or security flaws. Automated CI/CD gates provide deterministic verification barriers that prevent unverified code from reaching production.
    </div>
  </div>
</div>

<!--
Let us examine Question 23: Automated CI/CD Quality Gates.

The core challenge asks: In modern AI Specification-Driven development, what is the primary role of automated CI/CD verification gates?

Option B is correct because: AI coding agents can generate code rapidly, but they may introduce subtle hallucinations or security flaws. Automated CI/CD gates provide deterministic verification barriers that prevent unverified code from reaching production.

To summarize this slide, remember this key takeaway: Automated CI/CD Quality Gates highlights that software engineering requires disciplined problem definition rather than ad-hoc speculation.
-->

---
<!-- _class: lead -->
<!-- header: 'Ch 3. Requirements Engineering | Overview ▾' -->

# **Chapter 3. Requirements Engineering**
## Elicitation, Functional & Non-Functional Specifications, Modeling & Validation

> "The hardest single part of building a software system is deciding precisely what to build." — *Fred Brooks (1987)*

<div style="margin-top: 20px;">
  <span class="quiz-tag" style="font-size: 14px; padding: 6px 16px;">🎯 8 Questions (Q24 – Q31)</span>
</div>

<!--
Entering Chapter 3. Requirements Engineering.

This section challenges your grasp on the fundamental principles introduced in this chapter.

Read each scenario carefully, make your selection, and review the detailed rationale.

To summarize this slide, remember this key takeaway: Reflect critically on each question before clicking your final answer.
-->

---
<!-- header: 'Ch 3. Requirements Engineering | Q24 of 31 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 3. Requirements Engineering • Question 24</span>
    <span class="quiz-prog">Topic: User vs. System Requirements</span>
  </div>

  <div class="quiz-qbox">
    In requirements engineering, what is the critical operational distinction between **User Requirements** and **System Requirements**?
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="true">
      <span class="q-badge">A</span>
      <span class="q-text">User requirements are high-level stakeholder goals; system requirements are detailed functional contracts for developers.</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="false">
      <span class="q-badge">B</span>
      <span class="q-text">User requirements specify UI wireframes; system requirements specify backend database schemas.</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">User requirements can never change; system requirements are refactored continuously during daily scrums.</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">User requirements come from external legal auditors; system requirements are generated by compiler tools.</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 Click an option above to test your understanding</span>
      <span class="btn-retry" style="display: none;">↺ Retry</span>
    </div>
    <div class="fb-body">
      <strong>💡 Correct Answer: A</strong> — User requirements communicate the overarching business capabilities to non-technical stakeholders, while system requirements bridge those desires into precise, contract-level engineering specifications.
    </div>
  </div>
</div>

<!--
Let us examine Question 24: User vs. System Requirements.

The core challenge asks: In requirements engineering, what is the critical operational distinction between **User Requirements** and **System Requirements**?

Option A is correct because: User requirements communicate the overarching business capabilities to non-technical stakeholders, while system requirements bridge those desires into precise, contract-level engineering specifications.

To summarize this slide, remember this key takeaway: User vs. System Requirements highlights that software engineering requires disciplined problem definition rather than ad-hoc speculation.
-->

---
<!-- header: 'Ch 3. Requirements Engineering | Q25 of 31 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 3. Requirements Engineering • Question 25</span>
    <span class="quiz-prog">Topic: Domain Requirements (UberEats)</span>
  </div>

  <div class="quiz-qbox">
    Consider the following specification for the UberEats platform: <em>&ldquo;Due to municipal food hygiene regulations, perishable warm food delivery transit time shall not exceed 45 minutes, and containers must maintain a temperature above 60°C throughout transit.&rdquo;</em> What category of software requirement does this statement represent?
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="true">
      <span class="q-badge">A</span>
      <span class="q-text">Domain Requirement (a constraint imposed by the operational environment, industry regulations, or physical laws)</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="false">
      <span class="q-badge">B</span>
      <span class="q-text">Functional Requirement (a specification of an active software computation, user feature, or system service)</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">Non-Functional Requirement (a general software quality attribute concerning performance, scalability, or uptime)</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">User Requirement (a high-level, natural-language goal or business vision expressed by end consumers)</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 Click an option above to test your understanding</span>
      <span class="btn-retry" style="display: none;">↺ Retry</span>
    </div>
    <div class="fb-body">
      <strong>💡 Correct Answer: A</strong> — While this requirement mentions a 45-minute timing constraint, it does not arise from user preference or general system performance tuning. Instead, it is dictated by external municipal health laws and thermodynamic physical properties of food safety. In software engineering, constraints that originate from industry regulations, physics, or the operating domain are classified as Domain Requirements.
    </div>
  </div>
</div>

<!--
Let us examine Question 25: Domain Requirements (UberEats).

The core challenge asks: Consider the following specification for the UberEats platform: > *&quot;Due to municipal food hygiene regulations, perishable warm food delivery transit time shall not exceed 45 minutes, and containers must maintain a temperature above 60°C throughout transit.&quot;* What category of software requirement does this statement represent?

Option A is correct because: While this requirement mentions a 45-minute timing constraint, it does not arise from user preference or general system performance tuning. Instead, it is dictated by external municipal health laws and thermodynamic physical properties of food safety. In software engineering, constraints that originate from industry regulations, physics, or the operating domain are classified as Domain Requirements.

To summarize this slide, remember this key takeaway: Domain Requirements (UberEats) highlights that software engineering requires disciplined problem definition rather than ad-hoc speculation.
-->

---
<!-- header: 'Ch 3. Requirements Engineering | Q26 of 31 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 3. Requirements Engineering • Question 26</span>
    <span class="quiz-prog">Topic: Verifiable & Measurable NFRs</span>
  </div>

  <div class="quiz-qbox">
    A client provides an imprecise non-functional goal: *&quot;The order checkout system must be blazing fast and highly reliable.&quot;* Which of the following correctly transforms this vague goal into a **verifiable, testable engineering metric**?
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="true">
      <span class="q-badge">A</span>
      <span class="q-text">99% of checkouts shall have response time $\le 500$ ms, and peak uptime shall be $\ge 99.95\%$.</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="false">
      <span class="q-badge">B</span>
      <span class="q-text">The checkout UI shall use sleek animations so customers perceive maximum speed.</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">All checkout services shall use memory-safe code to guarantee bug-free execution.</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">The cloud database shall allocate unlimited RAM whenever transaction load increases.</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 Click an option above to test your understanding</span>
      <span class="btn-retry" style="display: none;">↺ Retry</span>
    </div>
    <div class="fb-body">
      <strong>💡 Correct Answer: A</strong> — A verifiable NFR must be quantifiable so that test engineers can objectively measure pass or fail. Specifying 95th- or 99th-percentile latency under 500 milliseconds and four-nines availability provides an unambiguous, enforceable engineering contract.
    </div>
  </div>
</div>

<!--
Let us examine Question 26: Verifiable & Measurable NFRs.

The core challenge asks: A client provides an imprecise non-functional goal: *&quot;The order checkout system must be blazing fast and highly reliable.&quot;* Which of the following correctly transforms this vague goal into a **verifiable, testable engineering metric**?

Option A is correct because: A verifiable NFR must be quantifiable so that test engineers can objectively measure pass or fail. Specifying 95th- or 99th-percentile latency under 500 milliseconds and four-nines availability provides an unambiguous, enforceable engineering contract.

To summarize this slide, remember this key takeaway: Verifiable & Measurable NFRs highlights that software engineering requires disciplined problem definition rather than ad-hoc speculation.
-->

---
<!-- header: 'Ch 3. Requirements Engineering | Q27 of 31 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 3. Requirements Engineering • Question 27</span>
    <span class="quiz-prog">Topic: Root Cause & The 5 Whys Heuristic</span>
  </div>

  <div class="quiz-qbox">
    During a requirements elicitation interview, an executive insists: *&quot;Our clinical software must include a blockchain ledger to record patient vitals.&quot;* What is the most effective engineering interview heuristic to apply?
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="true">
      <span class="q-badge">A</span>
      <span class="q-text">Apply the &quot;5 Whys&quot; to investigate the underlying data integrity and audit problem rather than prematurely locking in the suggested technology.</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="false">
      <span class="q-badge">B</span>
      <span class="q-text">Immediately begin drafting smart contracts and relational database schemas for the requested blockchain feature.</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">Reject the executive's request outright because non-technical stakeholders are prohibited from proposing system capabilities.</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">Politely terminate the interview and switch exclusively to passive workplace observation.</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 Click an option above to test your understanding</span>
      <span class="btn-retry" style="display: none;">↺ Retry</span>
    </div>
    <div class="fb-body">
      <strong>💡 Correct Answer: A</strong> — Stakeholders frequently suggest specific technical tools because they heard a buzzword, when their real business requirement is data integrity or regulatory traceability. An engineer's job is to uncover the underlying problem, not prematurely implement proposed technical band-aids.
    </div>
  </div>
</div>

<!--
Let us examine Question 27: Root Cause & The 5 Whys Heuristic.

The core challenge asks: During a requirements elicitation interview, an executive insists: *&quot;Our clinical software must include a blockchain ledger to record patient vitals.&quot;* What is the most effective engineering interview heuristic to apply?

Option A is correct because: Stakeholders frequently suggest specific technical tools because they heard a buzzword, when their real business requirement is data integrity or regulatory traceability. An engineer's job is to uncover the underlying problem, not prematurely implement proposed technical band-aids.

To summarize this slide, remember this key takeaway: Root Cause & The 5 Whys Heuristic highlights that software engineering requires disciplined problem definition rather than ad-hoc speculation.
-->

---
<!-- header: 'Ch 3. Requirements Engineering | Q28 of 31 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 3. Requirements Engineering • Question 28</span>
    <span class="quiz-prog">Topic: Ethnography & Tacit Knowledge</span>
  </div>

  <div class="quiz-qbox">
    In requirements engineering, why is **Ethnography (workplace observation)** uniquely vital when analyzing complex operational environments such as hospital emergency rooms or air traffic control?
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="true">
      <span class="q-badge">A</span>
      <span class="q-text">It uncovers tacit knowledge—ingrained habits, physical workarounds, and unwritten shortcuts that users perform automatically but never mention during interviews.</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="false">
      <span class="q-badge">B</span>
      <span class="q-text">It automatically compiles natural language requirements directly into executable acceptance test suites without human intervention.</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">It eliminates the need for subsequent software architecture design, database modeling, or code review phases.</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">It guarantees that the resulting software requirements will achieve 100% mathematical completeness on the initial development sprint.</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 Click an option above to test your understanding</span>
      <span class="btn-retry" style="display: none;">↺ Retry</span>
    </div>
    <div class="fb-body">
      <strong>💡 Correct Answer: A</strong> — People often cannot articulate everything they do because habits become second nature. By observing practitioners in their actual physical workspace, engineers uncover critical tacit knowledge—like sticky notes, manual spreadsheets, and physical handoffs—that never appear in official manuals or interviews.
    </div>
  </div>
</div>

<!--
Let us examine Question 28: Ethnography & Tacit Knowledge.

The core challenge asks: In requirements engineering, why is **Ethnography (workplace observation)** uniquely vital when analyzing complex operational environments such as hospital emergency rooms or air traffic control?

Option A is correct because: People often cannot articulate everything they do because habits become second nature. By observing practitioners in their actual physical workspace, engineers uncover critical tacit knowledge—like sticky notes, manual spreadsheets, and physical handoffs—that never appear in official manuals or interviews.

To summarize this slide, remember this key takeaway: Ethnography & Tacit Knowledge highlights that software engineering requires disciplined problem definition rather than ad-hoc speculation.
-->

---
<!-- header: 'Ch 3. Requirements Engineering | Q29 of 31 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 3. Requirements Engineering • Question 29</span>
    <span class="quiz-prog">Topic: Use Case Diagrams vs. Descriptions</span>
  </div>

  <div class="quiz-qbox">
    A software engineering team creates a UML Use Case Diagram showing an actor connected to the &quot;Withdraw Cash&quot; use case. Why must engineers author a detailed textual **Use Case Description** in addition to the diagram?
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="true">
      <span class="q-badge">A</span>
      <span class="q-text">Diagrams only show high-level scope; descriptions define sequential flows, preconditions, postconditions, and exception handling.</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="false">
      <span class="q-badge">B</span>
      <span class="q-text">UML diagrams cannot be rendered by web browsers without accompanying markdown text.</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">Compilers require use case descriptions to allocate heap memory for actor threads.</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">Descriptions convert non-functional requirements into automated GUI wireframes.</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 Click an option above to test your understanding</span>
      <span class="btn-retry" style="display: none;">↺ Retry</span>
    </div>
    <div class="fb-body">
      <strong>💡 Correct Answer: A</strong> — A use case diagram is just a visual table of contents; it shows who interacts with what feature. But engineers cannot write code or tests from an ellipse alone. They need the textual use case description to know the exact preconditions, the sequential normal flow, and how to handle exception flows when things go wrong.
    </div>
  </div>
</div>

<!--
Let us examine Question 29: Use Case Diagrams vs. Descriptions.

The core challenge asks: A software engineering team creates a UML Use Case Diagram showing an actor connected to the &quot;Withdraw Cash&quot; use case. Why must engineers author a detailed textual **Use Case Description** in addition to the diagram?

Option A is correct because: A use case diagram is just a visual table of contents; it shows who interacts with what feature. But engineers cannot write code or tests from an ellipse alone. They need the textual use case description to know the exact preconditions, the sequential normal flow, and how to handle exception flows when things go wrong.

To summarize this slide, remember this key takeaway: Use Case Diagrams vs. Descriptions highlights that software engineering requires disciplined problem definition rather than ad-hoc speculation.
-->

---
<!-- header: 'Ch 3. Requirements Engineering | Q30 of 31 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 3. Requirements Engineering • Question 30</span>
    <span class="quiz-prog">Topic: Exponential Cost of Late Defects</span>
  </div>

  <div class="quiz-qbox">
    Why is fixing a requirements error after software delivery significantly more expensive than fixing an error during early development?
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="false">
      <span class="q-badge">A</span>
      <span class="q-text">Requirements documents cannot be legally modified once signed by clients.</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="true">
      <span class="q-badge">B</span>
      <span class="q-text">A late fix requires redesigning, recoding, retesting, and redeploying cascading components that were built on the flawed premise.</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">Compilers automatically lock code repositories against changes after the first production release.</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">Automated unit tests lose their validity after code has been deployed to cloud environments.</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 Click an option above to test your understanding</span>
      <span class="btn-retry" style="display: none;">↺ Retry</span>
    </div>
    <div class="fb-body">
      <strong>💡 Correct Answer: B</strong> — When a requirement defect escapes into production, all the downstream work built on that false premise—the architectural design, database schemas, API contracts, frontend views, and automated tests—must be ripped out and rebuilt. That cascading rework is what causes the 100x cost explosion.
    </div>
  </div>
</div>

<!--
Let us examine Question 30: Exponential Cost of Late Defects.

The core challenge asks: Why is fixing a requirements error after software delivery significantly more expensive than fixing an error during early development?

Option B is correct because: When a requirement defect escapes into production, all the downstream work built on that false premise—the architectural design, database schemas, API contracts, frontend views, and automated tests—must be ripped out and rebuilt. That cascading rework is what causes the 100x cost explosion.

To summarize this slide, remember this key takeaway: Exponential Cost of Late Defects highlights that software engineering requires disciplined problem definition rather than ad-hoc speculation.
-->

---
<!-- header: 'Ch 3. Requirements Engineering | Q31 of 31 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 3. Requirements Engineering • Question 31</span>
    <span class="quiz-prog">Topic: LLM Hallucinations in Requirements</span>
  </div>

  <div class="quiz-qbox">
    When software engineering teams use Large Language Models (LLMs) to generate requirements specifications from stakeholder interview transcripts, what is the primary operational risk requiring human-in-the-loop verification?
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="true">
      <span class="q-badge">A</span>
      <span class="q-text">The LLM may hallucinate plausible-sounding but fictitious business logic, omitted edge-case constraints, and non-existent external API integrations.</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="false">
      <span class="q-badge">B</span>
      <span class="q-text">The LLM cannot output text formatted in Markdown bullet points or standard user story Given-When-Then acceptance criteria.</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">The LLM will consume excessive server memory and cause database deadlock errors across production microservice clusters.</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">The LLM strictly enforces waterfall development practices and refuses to generate requirements for iterative agile sprint cycles.</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 Click an option above to test your understanding</span>
      <span class="btn-retry" style="display: none;">↺ Retry</span>
    </div>
    <div class="fb-body">
      <strong>💡 Correct Answer: A</strong> — LLMs are fluent text predictors, not domain experts. They frequently invent plausible-sounding business rules or overlook subtle safety constraints that were never stated by the stakeholder. An experienced requirements engineer must critically audit every generated requirement.
    </div>
  </div>
</div>

<!--
Let us examine Question 31: LLM Hallucinations in Requirements.

The core challenge asks: When software engineering teams use Large Language Models (LLMs) to generate requirements specifications from stakeholder interview transcripts, what is the primary operational risk requiring human-in-the-loop verification?

Option A is correct because: LLMs are fluent text predictors, not domain experts. They frequently invent plausible-sounding business rules or overlook subtle safety constraints that were never stated by the stakeholder. An experienced requirements engineer must critically audit every generated requirement.

To summarize this slide, remember this key takeaway: LLM Hallucinations in Requirements highlights that software engineering requires disciplined problem definition rather than ad-hoc speculation.
-->

---
<!-- _class: lead -->
<!-- header: 'ASE Self-Study Quiz Deck ▾ | Complete' -->

# **🎉 Congratulations! Quiz Deck Completed**
## You Have Reviewed All 31 Conceptual Milestones

> "Continuous improvement is better than delayed perfection." — Mark Twain

<div class="three-columns" style="margin-top: 25px;">

<div class="card">
  <h3 style="color: #0284c7; margin-bottom: 6px;">📘 Review Ch 1</h3>
  <p style="font-size: 13.5px; color: #475569;">Revisit Software Crisis, ISO 25010 & Ethics concepts.</p>
  <div style="margin-top: 10px;">
    <a href="#4" class="btn-secondary" style="display: inline-block; padding: 4px 12px; font-size: 12px; text-decoration: none; border-radius: 4px; border: 1px solid #cbd5e1; background: #fff; color: #0284c7; font-weight: 700;">Jump to Q01 ➔</a>
  </div>
</div>

<div class="card">
  <h3 style="color: #0284c7; margin-bottom: 6px;">⚙️ Review Ch 2</h3>
  <p style="font-size: 13.5px; color: #475569;">Revisit Agile, Scrum, Kanban & TDD cycles.</p>
  <div style="margin-top: 10px;">
    <a href="#14" class="btn-secondary" style="display: inline-block; padding: 4px 12px; font-size: 12px; text-decoration: none; border-radius: 4px; border: 1px solid #cbd5e1; background: #fff; color: #0284c7; font-weight: 700;">Jump to Q10 ➔</a>
  </div>
</div>

<div class="card">
  <h3 style="color: #0284c7; margin-bottom: 6px;">📋 Review Ch 3</h3>
  <p style="font-size: 13.5px; color: #475569;">Revisit Elicitation, NFR metrics & Use Cases.</p>
  <div style="margin-top: 10px;">
    <a href="#29" class="btn-secondary" style="display: inline-block; padding: 4px 12px; font-size: 12px; text-decoration: none; border-radius: 4px; border: 1px solid #cbd5e1; background: #fff; color: #0284c7; font-weight: 700;">Jump to Q24 ➔</a>
  </div>
</div>

</div>

<!--
Congratulations on completing the Comprehensive Self-Study Quiz Deck!

You have actively tested yourself on all 31 essential questions across the Introduction, Process Models, and Requirements Engineering chapters.

Use the jump links to return to any challenging topic and strengthen your mastery.

To summarize this slide, remember this key takeaway: Active self-quizzing builds resilient engineering intuition that translates directly into robust production systems.
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
