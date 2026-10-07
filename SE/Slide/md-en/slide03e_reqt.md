---
marp: true
theme: ase-theme
_class: lead
paginate: true
header: 'Software Engineering | Ch 03: Requirements Engineering'
footer: 'Ch 03 · Requirements Engineering'
---
# Software Engineering

### Lecture 3: Requirements Engineering

**Prof. Nien-Lin Hsueh**
Department of Information Engineering and Computer Science
Feng Chia University

<!--
Welcome everyone to Lecture 3 of Software Engineering. Today, our focus is on Requirements Engineering.

In software projects, nothing is more dangerous or expensive than building the wrong product with absolute technical perfection. You could have the most elegant algorithms, zero compiler errors, and the cleanest microservice architecture, but if it does not solve the user's actual problem, the project is a failure.

Over the next few hours, we will learn how to discover, structure, validate, and manage requirements, and see how modern AI tools are transforming this critical discipline.

To summarize this slide, remember this key takeaway: Requirements engineering ensures that we build the right system before we spend time building the system right.
-->
---
<!-- _class: outline outline-slide -->

## Chapter 3: Roadmap & Core Curriculum

<div class="outline-columns">
  <div>
    <h3>Part 1: Foundations, Classification & Metrics</h3>
    <ul>
      <li><b>3.1 Foundations of Requirements Engineering:</b> What is RE, cost curve of late defect fixing, user vs. system requirements.</li>
      <li><b>3.2 Stakeholders & Requirements Classification:</b> Stakeholder personas, functional requirements, and domain business rules.</li>
      <li><b>3.3 Non-Functional Requirements & Metrics:</b> Product, organizational, external qualities (FURPS+), and verifiable metrics.</li>
    </ul>
  </div>
  <div>
    <h3>Part 2: Elicitation, Validation & AI Era</h3>
    <ul>
      <li><b>3.4 Requirements Elicitation & Use Cases:</b> 4-stage elicitation loop, scenarios, UML use case diagrams, and Jacobson specifications.</li>
      <li><b>3.5 Requirements Validation & Management:</b> 5 validation pillars, requirements reviews, traceability matrix, and RFC change control.</li>
      <li><b>3.6 AI-Assisted Requirements Engineering:</b> Generative AI copilots, user story refinement, ambiguity detection, human-in-the-loop.</li>
      <li><b>3.7 Synthesis & Conceptual Recap:</b> Key takeaway review, fill-in-the-blank quiz, discussion questions, and references.</li>
    </ul>
  </div>
</div>

<!--
Here is our roadmap for Chapter 3.

On the left, in Part 1, we establish the foundations of requirements engineering, distinguish user from system requirements, analyze stakeholders, and translate subjective non-functional goals into verifiable metrics.

On the right, in Part 2, we master the elicitation cycle, UML use case modeling, the five pillars of requirements validation, change traceability, and explore how generative AI accelerates specification while keeping humans in the loop.

To summarize this slide, remember this key takeaway: This roadmap guides our journey from stakeholder ambiguity to precise, verified engineering specifications.
-->
---
## Focus Questions

* What is **Requirements Engineering (RE)** and why is fixing requirements errors early so critical?
* What is the fundamental difference between **User Requirements** and **System Requirements**?
* How do **Functional**, **Non-Functional**, and **Domain Requirements** differ?
* What are the 4 main stages of the **Requirements Elicitation & Analysis** process?
* How can non-functional goals be transformed into **verifiable, testable metrics**?
* How do modern **Large Language Models (LLMs)** enhance the RE process, and what are the human-in-the-loop safeguards?

<!--
Before we dive into the details, keep these focus questions in mind throughout our lecture.

First, why is catching a requirements misunderstanding early so much cheaper than catching it later in production?

Second, how do we distinguish high-level user expectations from precise, contract-level system specifications?

Third, what makes non-functional requirements such as security and performance the primary drivers of software architecture?

And finally, how can we leverage modern AI coding assistants and LLMs to accelerate requirements analysis while safeguarding against hallucinations?

To summarize this slide, remember this key takeaway: Keep these focus questions in mind as our guiding compass for Chapter 3.
-->
---
<!-- _class: lead -->
<!-- header: '3.1 Foundations of RE' -->

# **3.1 Foundations of Requirements Engineering**

> "The hardest single part of building a software system is deciding precisely what to build."  
> — *Fred Brooks, No Silver Bullet (1987)*

<!--
Welcome to Module 3.1: Foundations of Requirements Engineering.

As Fred Brooks famously observed in 'No Silver Bullet', no other part of the conceptual work is as difficult as establishing the detailed technical requirements. If you get the requirements wrong, even the most elegant architecture and flawless code will simply build the wrong product.

In this section, we examine the fundamental definition of requirements, the vital distinction between user requirements and system requirements, and why fixing requirements ambiguities early is up to 100 times cheaper than fixing them in production.

To summarize this slide, remember this key takeaway: Requirements engineering bridges human business intent with technical execution, serving as the ultimate foundation of software success.
-->
---
<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch03/cost_of_ambiguity_handwrite.png" alt="The Exponential Cost of Ambiguity" />
</div>

<!--
Take a look at this hand-drawn infographic: 'The Exponential Cost of Ambiguity.'

Notice the steep upward curve moving from left to right. When a requirements ambiguity or misunderstanding is caught at the beginning, the cost to fix it is minimal—just changing a line in a specification.

Look at what happens as we advance through Architecture Design, Coding, and System Testing, all the way to Production Deployment! The cost to fix that same defect multiplies exponentially, up to 100 times more expensive!

Why? Because fixing a requirement defect in production requires ripping out written code, redesigning schemas, rewriting automated tests, and potentially suffering costly system downtime.

To summarize this slide, remember this key takeaway: Catching requirements ambiguities early prevents exponential rework and massive cost overruns later.
-->
---
## Foundations of Requirements Engineering

> The **systematic** process of establishing the services that a customer **requires** from a system and the operational/developmental **constraints** under which it operates.

* **Dual Function of Requirements:**
  1. **Contract Bidding:** High-level abstract statements open to contractor interpretation.
  2. **Contract Basis:** Detailed functional specifications defining precisely what must be delivered.
* **The Fundamental Goal:**
  - Bridging the gap between the messy, ambiguous real world of human stakeholders and the precise, deterministic world of software systems.

<!--
Let's start Module 3.1 with our core definition.

Notice the blockquote at the top: Requirements Engineering is the systematic process of establishing the services that a customer requires from a system, along with the operational and environmental constraints.

Requirements serve a dual business purpose: on one hand, clients need high-level statements to invite bids from contractors; on the other hand, engineers need detailed, unambiguous specifications to write code and verify contracts.

Our fundamental goal as software engineers is to bridge the communication gap between messy human needs and deterministic machine execution.

To summarize this slide, remember this key takeaway: Requirements engineering bridges messy human expectations and deterministic software architecture.
-->
---
<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch03/user_vs_system_req_handwrite.png" alt="Bridging the Communication Chasm" />
</div>

<!--
Look at this hand-drawn concept sketch: 'Bridging the Communication Chasm.'

On the left side, inside the speech bubble, we see the User Requirement: a high-level customer desire expressed in natural language. For example: 'The MHC-PMS shall generate monthly prescription drug cost reports for clinics.'

In the center, we see the Engineering Translation bridge and magnifying glass. That is our role as software engineers!

On the right side, we produce the structured System Requirements: defining exact database triggers, layout fields, and precise performance thresholds like processing 10,000 records in under 60 seconds.

To summarize this slide, remember this key takeaway: Requirements engineering serves as the vital translation bridge between human business needs and technical code.
-->
---
## Types of Requirements

* **User Requirements:**
  - High-level abstract statements written in natural language with diagrams.
  - Target audience: **Clients, system users, managers, non-technical stakeholders.**
  - Focuses on **what** services the system provides from the user perspective.
* **System Requirements:**
  - Detailed, structured specifications defining system functions, services, and operational constraints precisely.
  - Target audience: **Developers, software architects, system testers.**
  - Serves as the baseline technical contract for system *implementation*.
* **Domain Requirements:**
  - Constraints and operational rules derived directly from the application domain (e.g., industry regulations, physical laws).
  - Non-negotiable boundaries that often override both user preferences and technical designs.

<!--
A foundational taxonomy in Requirements Engineering divides requirements into three key levels: User Requirements, System Requirements, and Domain Requirements.

User Requirements are written in natural language, accompanied by simple diagrams. They are aimed at clients, end users, and business executives, describing what the system does from the outside world's point of view.

System Requirements, on the other hand, are detailed, structured technical documents. They define inputs, outputs, exact database constraints, and API contracts for developers, architects, and test engineers.

Domain Requirements originate from the operating environment itself—such as healthcare compliance, banking laws, or physical laws. They are non-negotiable and often override both user requests and technical designs.

To summarize this slide, remember this key takeaway: User requirements communicate customer intent, system requirements define technical execution, and domain requirements enforce non-negotiable industry rules.
-->
---
## A Healthcare Example
 
* **User Requirement (High-Level Intent):**
  > *"The MHC-PMS shall generate monthly summary reports showing the cost of drugs prescribed by each clinic."*
* **System Requirements (Detailed Technical Specification):**
  - **1.1:** On the last working day of each month, a summary report shall be generated of drug costs across each registered clinic.
  - **1.2:** The system shall produce reports using a standardized layout showing drug names, total doses prescribed, and total cost.
  - **1.3:** If drug cost data exceeds 10,000 records, generation shall complete within 60 seconds without locking the transactional database.
* **Domain Requirements (Healthcare Mandates):**
  - **D.1 (Patient Privacy):** Per health data laws (e.g., HIPAA), cost reports must aggregate data so individual patient identities cannot be deduced.
  - **D.2 (Formulary Standards):** Drug classifications and dosage units must strictly follow national medical formulary standards (e.g., FDA NDC / BNF).

<!--
Let's look at a concrete example from a Mental Health Clinic Patient Management System (MHC-PMS).

Look at the User Requirement: 'The system shall generate monthly summary reports showing the cost of drugs prescribed by each clinic.' That sounds simple and clear to a hospital director.

Now look at the System Requirements below it: Notice how it breaks down that single intent into precise technical specifications—the monthly trigger, standardized layouts, and a 60-second database-safe execution threshold.

Finally, notice the Domain Requirements: Healthcare privacy regulations (like HIPAA) mandate patient anonymization, and pharmaceutical laws require strict compliance with national drug formularies. These domain constraints govern the system regardless of user requests.

To summarize this slide, remember this key takeaway: System requirements specify how features operate, while domain requirements enforce mandatory real-world industry rules.
-->
---
<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch03/requirements_types_handwrite.png" alt="The Spectrum of Requirements" />
</div>

<!--
Look at this hand-drawn mind-map illustrating the spectrum of software requirements.

In the center, we see our System Requirements blueprint surrounded by our diverse stakeholders: doctors, nurses, IT administrators, and legal officers.

Notice the three colorful branches radiating outward: Functional Requirements in blue, describing specific services and user actions; Non-Functional Requirements in orange, defining quality attributes like security and 99.9% uptime; and Domain Requirements in green, enforcing industry regulations and compliance laws.

Every successful system must achieve harmony across all three branches.

To summarize this slide, remember this key takeaway: A complete software specification must address what the system does, how it performs, and the domain rules it must obey.
-->
---
### Concept Check Question 1
<!-- id: ase-ch03-ccq1 -->
<div class="ccq-columns">
  <div class="ccq-text">

In requirements engineering, what is the critical operational distinction between **User Requirements** and **System Requirements**?

- **A.** User requirements are high-level stakeholder goals; system requirements are detailed functional contracts for developers.
- **B.** User requirements specify UI wireframes; system requirements specify backend database schemas.
- **C.** User requirements can never change; system requirements are refactored continuously during daily scrums.
- **D.** User requirements come from external legal auditors; system requirements are generated by compiler tools.

  </div>
  <div class="ccq-logo">
    <a href="https://nlhsueh.github.io/nickedupocket/#/student/ase-ch03-ccq1" target="_blank"><img src="../../img/ch03/ase-ch03-ccq1.png" alt="QR Code" /></a>
  </div>
</div>

<!--
Let's test our understanding of the foundations of requirements with Concept Check Question 1.

Look at the prompt on screen: In requirements engineering, what is the critical operational distinction between User Requirements and System Requirements?

Let's evaluate the options:
Option A states that user requirements are high-level statements in natural language for customers, while system requirements are detailed specifications of services and constraints for the development team.
Option B incorrectly limits user requirements to UI wireframes and system requirements to databases.
Option C claims user requirements can never be modified.
Option D suggests external authorities write user requirements and compilers generate system requirements.

The correct answer is Option A! User requirements communicate the overarching business capabilities to non-technical stakeholders, while system requirements bridge those desires into precise, contract-level engineering specifications.

To summarize this slide, remember this key takeaway: User requirements express what customers need, while system requirements define precisely what engineers must build.
-->
---
<!-- _class: lead -->
<!-- header: '3.2 Stakeholders & Classification' -->

# **3.2 System Stakeholders & Requirements Classification**

> "Software systems have many masters. If you fail to identify who has a stake, their unspoken expectations will become your project's failure."

<!--
Now we transition into Module 3.2: System Stakeholders and Requirements Classification.

A software system never exists in a vacuum. It serves an entire ecosystem of stakeholders—from end users entering daily transactions, to IT administrators managing infrastructure, to regulatory bodies enforcing compliance laws.

In this section, we learn how to map stakeholder perspectives, manage competing expectations, and classify requirements into the fundamental Triad: Functional, Non-Functional, and Domain requirements.

To summarize this slide, remember this key takeaway: Identifying all stakeholder roles and balancing their conflicting needs is the primary prerequisite for realistic system specifications.
-->
---
## System Stakeholders & Requirements Classification

> Any person, system or organization affected by the system who has a legitimate interest in its behavior and operational outcome.

* **Types of Stakeholders:**
  - **End Users:** Patients, Doctors, Nurses, Receptionists.
  - **System Managers:** Clinic Managers, IT Directors, Compliance Officers.
  - **External Stakeholders:** Health Authorities, Medical Device Regulators, Insurance Payors.
* **The Stakeholder Conflict Challenge:**
  - Different stakeholders have *competing*, *conflicting* requirements (e.g., Doctors want rapid data entry; Compliance Officers want comprehensive multi-factor audit logging).

<!--
Now in Module 3.2, let's ask: Who defines requirements? Stakeholders!

Notice the definition at the top: A stakeholder is any person or group affected by the system who has a legitimate interest in its behavior.

In a hospital system, stakeholders include end users like doctors and patients, managers like clinic directors and IT administrators, and external authorities like medical compliance boards and insurance companies.

The biggest challenge in requirements engineering is that stakeholders frequently disagree! Doctors want one-click prescribing with zero friction, while security officers demand multi-factor authentication and strict logging. Balancing these competing interests is a primary engineering duty.

To summarize this slide, remember this key takeaway: Software engineering requires actively negotiating and balancing conflicting stakeholder priorities.
-->
---
## Case Study: Stakeholder Ecosystem in UberEats

* **The Multi-Sided Stakeholder Ecosystem:**
  - **Hungry Customer (Eater):** Demands fast delivery, accurate ETA, live GPS tracking, and friction-free refunds.
  - **Restaurant Merchant:** Wants predictable kitchen prep buffers, timely courier arrivals, and locked payments once cooking starts.
  - **Delivery Courier:** Demands fair dispatching algorithms, transparent tip payouts, short distances, and safe parking tolerance.
  - **Platform Operations (Uber):** Optimizes network liquidity, balances supply/demand via dynamic fees, and prevents promotional fraud.
  - **External Regulators:** Enforce food safety temperature standards, labor regulations, and mandatory electronic fiscal receipts.
* **The Stakeholder Conflict Challenge:**
  - *Customer vs. Restaurant:* Customer cancels 5 minutes after ordering; restaurant already started cooking expensive ingredients. Who absorbs the loss?

<!--
Let's bring stakeholder classification to life with a real-world platform: UberEats!

Notice that UberEats is not a simple single-user app; it is a multi-sided market connecting four distinct stakeholder groups, plus external regulators.

Look at their competing interests:
The hungry customer wants their hot burger delivered in 15 minutes, with live GPS tracking and full refund options.
The restaurant merchant wants enough time to prepare quality food, and demands that the customer cannot cancel once the patty hits the grill!
The delivery courier wants fair dispatching, short routes, and clear visibility into tips and earnings.
And Uber's operations team wants to maximize order volume, prevent coupon fraud, and balance driver supply during a Friday night rainstorm.

Notice the clash! If a customer cancels an order after 10 minutes, the customer expects a refund, but the restaurant has already spent money cooking the food. Requirements engineers must define precise business rules and system states to handle these conflicts.

To summarize this slide, remember this key takeaway: Complex systems serve multi-sided stakeholder ecosystems whose competing interests must be balanced through explicit system rules.
-->
---
## UberEats: The Requirements Triad in Practice

> The Requirements Triad balances user-facing services, operational qualities, and environmental compliance.

<div class="three-columns">

<div class="card" data-marpit-fragment>

### 1. Functional
#### Services & Behavior

- Filter restaurants by dietary restrictions and live delivery ETA.
- Broadcast delivery jobs to optimal couriers based on GPS location.
- Automatically split and transfer payouts upon order delivery.

</div>

<div class="card" data-marpit-fragment>

### 2. Non-Functional
#### Quality & Constraints

- **Performance:** Courier GPS coordinates refresh on map $\le 2$ seconds.
- **Availability:** Maintain $\ge 99.99\%$ uptime during peak dinner hours.
- **Security:** Card credentials strictly comply with PCI-DSS Level 1.

</div>

<div class="card" data-marpit-fragment>

### 3. Domain
#### Environmental Mandates

- **Food Safety:** Perishable delivery duration complies with health agency rules.
- **Fiscal Law:** Generate legally compliant electronic VAT invoices.
- **Labor Law:** Comply with local limits on courier shift intervals.

</div>

</div>

<!--
Now let's map the UberEats platform directly onto our Requirements Triad: Functional, Non-Functional, and Domain.

First, Functional Requirements: these are the observable services—filtering menus, dispatching couriers, and processing three-way split payments.

Second, Non-Functional Requirements: these are critical architectural constraints. If the courier's GPS location on the map lags by two minutes instead of two seconds, customers will panic and flood customer support. If the payment gateway crashes during peak dinner rush, the company loses millions in minutes.

Third, Domain Requirements: these come from the operational environment. Food safety laws dictate maximum delivery times for hot food. Road safety and labor laws govern courier dispatch limits. And municipal fiscal regulations require generating valid electronic tax invoices for every single transaction.

Notice that domain laws override everything else! If your software fails food safety or fiscal laws, the government will shut the platform down regardless of how great your UI is.

To summarize this slide, remember this key takeaway: The UberEats platform demonstrates how functional services, non-functional performance, and domain laws must operate in complete synergy.
-->
---
## Functional Requirements: Challenges

* **Requirements Imprecision:**
  - Ambiguous natural language requirements lead to serious engineering misunderstandings.
  - *UberEats Example:* "Customer may cancel an order before delivery."
    - *Customer Interpretation:* Cancel anytime with full refund while food is in transit.
    - *Restaurant Interpretation:* No cancellation once the kitchen starts cooking.
* **Completeness vs. Consistency:**
  - **Completeness:** All edge cases and services must be defined (e.g., courier vehicle breakdown mid-delivery, restaurant out-of-stock substitutions).
  - **Consistency:** Requirements must not contradict each other (e.g., "Full refund upon cancellation" vs. "Guaranteed merchant compensation once food is prepared").
  - *Reality Check:* In complex platforms like UberEats, achieving 100% upfront completeness is practically impossible, requiring continuous iterative refinement.

<!--
Let's examine the classic challenges with Functional Requirements through our UberEats platform.

The primary issue is Imprecision: natural language is deceptively ambiguous!
Consider a common requirement: "A customer may cancel an order before delivery."
A hungry customer assumes that means: "I can click cancel and get a 100% refund even while the driver is on the road."
But the restaurant merchant interprets it as: "Once I crack the eggs and put the steak on the grill, the order is locked and non-refundable!"
Without precise state machines and business rules, this imprecision creates massive customer support friction.

Furthermore, we balance Completeness and Consistency:
Completeness demands specifying every rare edge case—such as what happens when a courier's scooter gets a flat tire in the rain, or an ingredient runs out after an order is placed.
Consistency requires that rules never contradict each other—you cannot guarantee instant customer refunds while simultaneously guaranteeing zero loss to the merchant without defining who absorbs the loss!

In large-scale platforms, achieving complete, contradiction-free requirements upfront is impossible. That is why modern engineering relies on iterative refinement and continuous communication.

To summarize this slide, remember this key takeaway: Natural language ambiguities and hidden rule conflicts must be eliminated through precise business states and iterative refinement.
-->

---
### Concept Check Question 2
<!-- id: ase-ch03-ccq2 -->
<div class="ccq-columns">
  <div class="ccq-text">

Consider the following specification for the UberEats platform:
> *"Due to municipal food hygiene regulations, perishable warm food delivery transit time shall not exceed 45 minutes, and containers must maintain a temperature above 60°C throughout transit."*

What category of software requirement does this statement represent?

- **A.** Domain Requirement (a constraint imposed by the operational environment, industry regulations, or physical laws)
- **B.** Functional Requirement (a specification of an active software computation, user feature, or system service)
- **C.** Non-Functional Requirement (a general software quality attribute concerning performance, scalability, or uptime)
- **D.** User Requirement (a high-level, natural-language goal or business vision expressed by end consumers)

  </div>
  <div class="ccq-logo">
    <a href="https://nlhsueh.github.io/nickedupocket/#/student/ase-ch03-ccq2" target="_blank"><img src="../../img/ch03/ase-ch03-ccq2.png" alt="QR Code" /></a>
  </div>
</div>

<!--
Let's test our understanding with Concept Check Question 2 on the UberEats platform.

Look at the prompt carefully: 'Due to municipal food hygiene regulations, perishable warm food delivery transit time shall not exceed 45 minutes, and containers must maintain a temperature above 60°C throughout transit.' What category of requirement is this?

Let's evaluate the options:
Option A is Domain Requirement.
Option B is Functional Requirement.
Option C is Non-Functional Requirement.
Option D is User Requirement.

The correct answer is Option A! While this requirement mentions a 45-minute timing constraint, it does not arise from user preference or general system performance tuning. Instead, it is dictated by external municipal health laws and thermodynamic physical properties of food safety. In software engineering, constraints that originate from industry regulations, physics, or the operating domain are classified as Domain Requirements.

To summarize this slide, remember this key takeaway: Constraints derived directly from external industry regulations, laws, or physical reality are classified as Domain Requirements.
-->
---
## Interactive Activity: Cybercab Requirements Triad (Pair Discussion)

> **Scenario:** Suppose you are Elon Musk. Your autonomous **Cybercab** is officially street-legal. Beyond personal commuting, you can dispatch it to an autonomous robotaxi fleet to earn rental income.

<div class="three-columns">

<div class="card" data-marpit-fragment>

### 1. Functional
*User features & vehicle services:*
- **Guiding Questions:**
  - How does a rider summon, track, and enter the Cybercab?
  - How does the owner toggle between personal drive and fleet rental?
  - How does the system calculate fares and disburse rental revenue?

</div>

<div class="card" data-marpit-fragment>

### 2. Non-Functional
*Operational qualities & safety limits:*
- **Guiding Questions:**
  - What reaction latency limit is acceptable for obstacle braking?
  - What uptime availability must the cloud dispatch fleet maintain?
  - What cybersecurity safeguards prevent remote fleet takeovers?

</div>

<div class="card" data-marpit-fragment>

### 3. Domain
*Mandatory legal & industry rules:*
- **Guiding Questions:**
  - What federal autonomous vehicle certifications (e.g. NHTSA) apply?
  - What crash investigation data (blackbox/EDR) is legally required?
  - What commercial passenger liability insurance is mandated by law?

</div>

</div>

<!--
Let's pause here for an interactive pair discussion: The Cybercab Requirements Triad! Turn to your classmate next to you—together, you are Elon Musk and Tesla's chief software architect.

Here is your scenario: The Cybercab is officially street-legal! When you are not using it for your personal daily commute, you want to dispatch it into an autonomous robotaxi fleet to pick up passengers and earn rental revenue.

Take the next 3 minutes with your partner to formulate 2 to 3 concrete requirements for each dimension:
First, Functional Requirements: What active computations, features, and platform services must the car and mobile app perform? For example, remote summon, contactless door unlock, and dynamic fare splitting between the fleet platform and car owner.

Second, Non-Functional Requirements: What critical quality attributes govern runtime operations? Consider real-time obstacle avoidance latency—decision time must be under 100 milliseconds. Consider platform uptime across peak urban commute hours, and vehicle cybersecurity against remote hijack attacks.

Third, Domain Requirements: What external physical, municipal traffic, and legal industry constraints govern the vehicle? Regardless of what features you dream up, you cannot launch without NHTSA Level 5 autonomous certification, tamper-proof EDR blackbox logging, and automatic commercial passenger insurance coverage.

To summarize this slide, remember this key takeaway: Functional features, quality attributes, and domain compliance must be co-designed as a unified triad to take an autonomous Cybercab from concept to safe commercial reality.
-->
---
<!-- _class: lead -->
<!-- header: '3.3 NFR & Metrics' -->

# **3.3 Non-Functional Requirements (NFR) & Metrics**

> "If you can't measure it, you can't manage it — and you certainly cannot verify it."  
> — *Tom DeMarco*

<!--
We now arrive at Module 3.3: Non-Functional Requirements and Verifiable Metrics.

A system can execute every feature requested on paper, yet still be utterly useless if it takes ten minutes to load, leaks sensitive user data, or crashes during peak hours. Non-functional requirements define the systemic quality attributes of our software.

In this section, we explore how to classify NFRs across product, organizational, and external dimensions, and how to forge vague, subjective goals into crisp, mathematically verifiable engineering metrics.

To summarize this slide, remember this key takeaway: Non-functional requirements determine system viability; transforming qualitative wishes into verifiable metrics makes quality testable.
-->
---
## Non-Functional Requirements & Metrics

> Constraints on the services or functions offered by the system, including timing constraints, security, reliability, and standards compliance, fundamentally shaping software architecture.

* **System-Wide Impact:**
  - NFRs often apply to the system as a **whole** rather than **individual** features.
  - Failing to meet an NFR can render the entire system useless (e.g., a slow or insecure medical database).
* **Architectural Influence:**
  - Performance NFRs dictate module communication patterns; security NFRs introduce authentication infrastructure.
  - *Architecture is shaped far more by NFRs than by functional features!*

<!--
Now in Module 3.3, let's examine Non-Functional Requirements, or NFRs.

Here is a vital truth that every senior software architect knows: Software architecture is shaped far more by non-functional requirements than by functional requirements!

Think about it: whether an e-commerce site sells books or shoes doesn't fundamentally change its database design. But whether it needs to support 10 users or 10 million concurrent users completely changes the architecture!

Failing an NFR can render the entire system worthless. If an online banking app performs transactions correctly but takes 45 seconds to respond, users will abandon it immediately.

To summarize this slide, remember this key takeaway: Non-functional requirements dictate the underlying system architecture and determine overall product viability.
-->
---
<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch03/nfr_foundation_handwrite.png" alt="The Structural Base of NFRs" />
</div>

<!--
Look at this hand-drawn infographic: 'The Non-Functional Requirements Iceberg.'

Look at the ocean waterline: Above the surface is the visible tip of the iceberg—the Functional Requirements. That represents only 20% of what users see: buttons, UI screens, and reports.

Beneath the waterline lies the massive 80% underwater body: the Non-Functional Requirements—Performance, Security, Scalability, High Availability, Fault Tolerance, and Compliance.

Notice the handwritten arrow: 'Architecture is shaped by the underwater foundation, not just the tip!' If the NFR foundation fails, the visible features will sink immediately.

To summarize this slide, remember this key takeaway: Robust non-functional qualities form the invisible bedrock that supports all user-facing features.
-->

---
<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch03/nfr_hierarchy_handwrite.png" alt="Non-Functional Requirements Hierarchy" />
</div>

<!--
Look at this hand-drawn architectural taxonomy: 'The Non-Functional Requirements Hierarchy.'

At the top, we see the root: Non-Functional Requirements (NFR). Following Ian Sommerville's classic software engineering framework, NFRs branch into three major families:

First, on the left: Product Requirements. These define the runtime behavior of the software itself. Notice the sub-branches:
- Usability: How easy the software is to learn and operate without user error.
- Efficiency: split into Performance (response time, transaction throughput) and Space (memory footprint and disk consumption).
- Dependability: encompassing Reliability (Mean Time Between Failures) and Availability (uptime percentage).
- Security: protecting data integrity and access control.

Second, in the center: Organizational Requirements. These stem from the customer's and vendor's internal environment:
- Operational requirements: how systems are deployed, backed up, and monitored in daily operations.
- Development Standards: required programming languages, version control workflows, and coding conventions.
- Environmental requirements: operating system compatibility and target hardware constraints.

Third, on the right: External Requirements. These originate from outside the organization:
- Regulatory and Legal mandates: FDA medical compliance, aviation safety, and banking regulations.
- Safety constraints: ensuring software malfunctions cannot harm human life.
- Privacy and GDPR: strict data residency, user consent, and right-to-be-forgotten rules.
- Ethical requirements: ensuring algorithmic fairness, transparency, and prevention of deceptive dark patterns.

To summarize this slide, remember this key takeaway: Non-functional requirements encompass product runtime qualities, internal organizational rules, and external legal mandates.
-->
---
<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch03/comic_nfr_classification.png" alt="Classification of Non-Functional Requirements" />
</div>

<!--
Ian Sommerville provides a classic taxonomy for classifying Non-Functional Requirements into three main branches.

Look at this comic:
First, Product Requirements: an impatient user pacing back and forth, shouting 'I need 0.1s response time NOW!'

Second, Organizational Requirements: a company director holding a thick policy binder: 'Company Policy: Java Only, Git Flow.'

Third, External Requirements: a privacy inspector in sunglasses holding a 'GDPR Compliance' clipboard, inspecting server racks.

To summarize this slide, remember this key takeaway: Non-functional requirements originate from product runtime behavior, internal organizational policies, and external legal mandates.
-->

---
## Classification of NFRs: Three Major Families

> Non-functional requirements derive from product runtime behavior, internal organizational policies, and external operating environments.

<div class="three-columns">

<div class="card" data-marpit-fragment>

### 1. Product Requirements
**Definition:** Specify how the delivered software product must execute and behave at runtime.

- **Scope:** Runtime performance, dependability, and user experience constraints.
- **Sub-types:** Usability, Efficiency (speed/memory), Reliability, Security.
- **Examples:** Response time $\le 2$s, availability $\ge 99.99\%$, AES-256 encryption.

</div>

<div class="card" data-marpit-fragment>

### 2. Organizational Requirements
**Definition:** Consequences of policies, procedures, and standards within the customer or developer organization.

- **Scope:** Development lifecycle, operational governance, and infrastructure choices.
- **Sub-types:** Development standards, Operational runbooks, Platform constraints.
- **Examples:** Mandated Git Flow, daily offsite DB backup, target AWS deployment.

</div>

<div class="card" data-marpit-fragment>

### 3. External Requirements
**Definition:** Requirements derived from factors external to the system and its engineering process.

- **Scope:** Regulatory compliance, legal obligations, safety laws, and societal ethics.
- **Sub-types:** Legislative mandates, Safety regulations, Ethical standards.
- **Examples:** GDPR privacy compliance, electronic tax invoicing, medical fail-safe rules.

</div>

</div>

<!--
Before diving into specific measurement metrics, let's explore Ian Sommerville's classic taxonomy that organizes all non-functional requirements into three foundational families:

First, Product Requirements: by definition, these specify how the delivered software product must execute and behave at runtime. They encompass runtime qualities including execution speed, throughput, resource consumption, usability, reliability, and security.

Second, Organizational Requirements: by definition, these are consequences of internal organizational policies, engineering workflows, and management standards within either the customer's or developer's enterprise. They govern how the software is built, operated, and hosted.

Third, External Requirements: by definition, these arise entirely from factors external to the system and its development process. This broad category includes municipal tax laws, regulatory standards, medical safety rules, and privacy frameworks like GDPR.

To summarize this slide, remember this key takeaway: Understand the definition of each NFR family—Product (how the system behaves), Organizational (how the enterprise operates), and External (what the law and society demand).
-->
---
## Goals vs. Verifiable NFRs

* **Goal (Imprecise Intention):**
  > *"The system should be easy to use by medical staff and minimize user errors."*
* **Verifiable NFR (Testable Metric):**
  > *"Medical staff shall be able to use all core functions after 2 hours of training. After training, the average number of operator errors shall not exceed 2 per working day."*
* **The Golden Engineering Principle:**
  - Always transform subjective stakeholder goals into **quantifiable, objectively testable metrics!**

<!--
How do we write professional Non-Functional Requirements? We must convert subjective goals into verifiable metrics.

Look at the top example: 'The system should be easy to use by medical staff and minimize user errors.' That is a noble goal, but it is impossible to test! What does 'easy' mean?

Now look at the bottom example: 'Medical staff shall be able to use all core functions after 2 hours of training, and the average operator errors shall not exceed 2 per working day.'

Notice the difference! The second statement gives QA engineers an exact test plan. You can hire five nurses, train them for two hours, measure their errors, and prove objectively whether the requirement passed or failed.

To summarize this slide, remember this key takeaway: Software engineers must translate subjective stakeholder wishes into objectively measurable and testable metrics.
-->
---
<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch03/comic_gqm_metrics.png" alt="Forging Metrics from Ambiguity" />
</div>

<!--
Look at this comic illustrating how we turn vague stakeholder wishes into verifiable metrics!

On the left, the client enthusiastically requests: 'The system must be blazing fast and super easy to use!' That is a high-level goal, but impossible for developers to verify objectively.

In the middle, the developer is scratching his head, holding a sign: 'How do I test super easy?'

On the right, the QA engineer uses measuring tools to establish exact, verifiable metrics: 'Response time under 200 milliseconds, error rate below 0.1%, and training time under one hour.'

To summarize this slide, remember this key takeaway: Transforming fuzzy stakeholder wishes into concrete, measurable metrics is the essence of verifiable requirements.
-->
---
## Metrics for Specifying NFRs

| Property | Measurable Metric Examples |
|---|---|
| **Speed** | Processed transactions/sec; Response time; Screen refresh rate |
| **Size** | Megabytes of RAM; Number of ROM chips required |
| **Ease of Use** | Training time to competency; Number of help desk queries/week |
| **Reliability** | Mean Time Between Failures (MTBF); Rate of failure occurrence |
| **Robustness** | Time to restart after failure; Percentage of data corrupted on power loss |
| **Portability** | Percentage of target-dependent statements; Number of supported OS platforms |

<!--
This reference table lists standard engineering metrics for specifying non-functional qualities.

For Speed, don't say 'lightning fast'—specify transactions per second or 95th-percentile response time in milliseconds.

For Reliability, use Mean Time Between Failures (MTBF) or availability percentages like 'four nines'—99.99% uptime.

For Robustness, measure how quickly the system recovers from a crash and the percentage of data preserved during sudden power loss.

These metrics turn vague promises into legally enforceable engineering contracts.

To summarize this slide, remember this key takeaway: Quantifiable metrics replace subjective arguments with verifiable engineering benchmarks.
-->
---
### Concept Check Question 3
<!-- id: ase-ch03-ccq3 -->
<div class="ccq-columns">
  <div class="ccq-text">

A client provides an imprecise non-functional goal: *"The order checkout system must be blazing fast and highly reliable."* Which of the following correctly transforms this vague goal into a **verifiable, testable engineering metric**?

- **A.** 99% of checkouts shall have response time $\le 500$ ms, and peak uptime shall be $\ge 99.95\%$.
- **B.** The checkout UI shall use sleek animations so customers perceive maximum speed.
- **C.** All checkout services shall use memory-safe code to guarantee bug-free execution.
- **D.** The cloud database shall allocate unlimited RAM whenever transaction load increases.

  </div>
  <div class="ccq-logo">
    <a href="https://nlhsueh.github.io/nickedupocket/#/student/ase-ch03-ccq3" target="_blank"><img src="../../img/ch03/ase-ch03-ccq3.png" alt="QR Code" /></a>
  </div>
</div>

<!--
Let us test your understanding of turning subjective non-functional desires into verifiable engineering requirements!

The client wants the system to be 'blazing fast and highly reliable.'
Option B talks about sleek UI animations.
Option C talks about memory-safe languages and promises 'bug-free' execution, which is untestable.
Option D talks about allocating unlimited cloud memory.

The correct answer is Option A! A verifiable NFR must be quantifiable so that test engineers can objectively measure pass or fail. Specifying 95th- or 99th-percentile latency under 500 milliseconds and four-nines availability provides an unambiguous, enforceable engineering contract.

To summarize this slide, remember this key takeaway: Verifiable non-functional requirements replace subjective adjectives with objectively testable numerical metrics.
-->
---
## Interactive Activity: Quantifying Cybercab NFRs (Pair Discussion)

> **Scenario:** Elon Musk demands: *"The Cybercab must offer the safest drive, the smoothest rental experience, and the most effortless automated return."* How do you translate these desires into **verifiable, testable NFR metrics**?

<div class="three-columns">

<div class="card" data-marpit-fragment>

### 1. Drive Safety & Latency
*Turning "safe drive" into metrics:*
- **Guiding Questions:**
  - What is the max perception-to-braking latency in milliseconds ($\text{ms}$)?
  - Under what adverse weather conditions (fog, night, rain) must this hold?
  - What statistical percentile (e.g. 99.99%) guarantees passenger safety?

</div>

<div class="card" data-marpit-fragment>

### 2. Renting & Pickup Flow
*Turning "smooth rental" into metrics:*
- **Guiding Questions:**
  - How fast must cloud dispatch match and route a nearby vehicle ($\le N\text{ s}$)?
  - What is the max door unlock latency via Bluetooth/NFC upon renter arrival?
  - What is the allowable False Rejection Rate (FRR) for passenger identity check?

</div>

<div class="card" data-marpit-fragment>

### 3. Return & Inspection
*Turning "effortless return" into metrics:*
- **Guiding Questions:**
  - How fast must cabin cameras/sensors detect left-behind items or trash?
  - What minimum battery reserve must remain before permitting rental completion?
  - Within how many seconds must damage deposit hold and billing finalize?

</div>

</div>

<!--
Let's pause here for an interactive pair discussion: Quantifying Cybercab Non-Functional Requirements! Turn to your partner—you are now the Lead Quality Assurance and Systems Engineer for the Tesla Cybercab shared fleet program.

Elon Musk just gave you a visionary mandate: 'The Cybercab must offer the safest drive, the smoothest rental experience, and the most effortless automated return!' But software and test engineers cannot write automated pass/fail verification for adjectives like 'smooth' and 'effortless.'

Take 3 minutes with your partner to turn these three lifecycle phases into verifiable numbers:

First, Driving Safety: Define perception-to-braking latency in milliseconds—such as less than 100 milliseconds for emergency obstacle stops under 99.99% of operating conditions, and Mean Distance Between Disengagements (MDBD) over 50,000 miles.

Second, Renting and Pickup Flow: When a user taps 'Rent' on the mobile app, cloud matching and dispatch must respond in under 3 seconds. Proximity Bluetooth/NFC door unlocking must complete in under 0.8 seconds as the renter approaches, with identity verification False Rejection Rate under 0.1%.

Third, Return and Turn-In Flow: When the renter exits and taps 'Return', in-cabin ultrasonic and vision sensors must scan for trash, spilled liquids, or forgotten smartphones within 30 seconds. The vehicle must guarantee at least a 20% battery state of charge (or navigate itself directly to an inductive charging pad), and the final invoice and security deposit release must settle within 5 seconds.

To summarize this slide, remember this key takeaway: Quantifying non-functional requirements must span the entire product lifecycle—from user dispatch and contactless rental to autonomous driving and automated return checkout.
-->
---
<!-- _class: lead -->
<!-- header: '3.4 Elicitation & Modeling' -->

# **3.4 Requirements Elicitation & Modeling**

> "Customers do not know what they want until you show it to them — elicitation is a collaborative journey of discovery."

<!--
Welcome to Module 3.4: Requirements Elicitation and Modeling.

Requirements are never simply waiting to be collected like apples falling from a tree. Stakeholders rarely know exactly what they need, often speak in organizational jargon, and possess tacit knowledge they assume you already know.

In this section, we master the four core elicitation techniques—interviews, ethnography, user stories, and document archaeology—and learn how to formalize user scenarios into structured UML Use Case models.

To summarize this slide, remember this key takeaway: Requirements elicitation is an active discovery process that translates messy human workflows into structured, visual software models.
-->

---
<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch03/comic_imprecision_swing.png" alt="The Imprecision Trap" />
</div>

<!--
Take a look at this classic four-panel comic satirizing the software tree swing dilemma!

Panel 1 shows what the customer described: a wooden board swing tied to branches on opposite sides of the trunk, so the tree trunk sits directly in the way of the swing!

Panel 2 shows how the systems analyst designed it: to solve the swing hitting the trunk, cutting a framed opening right through the center of the tree trunk reinforced with wooden struts!

Panel 3 shows how the programmer coded it: tangled ropes tied tightly around the trunk and ground, rendering the swing completely immobile!

And Panel 4 shows what the customer actually wanted: a simple tire swing hanging freely from a single branch, bringing pure joy. Notice the clear contrast between the flawed, over-complicated description and the simple real need!

To summarize this slide, remember this key takeaway: Vague adjectives and unvalidated specifications are hidden traps that inevitably lead to misaligned implementations.
-->

---
## Why Requirements Elicitation is Hard

<div class="content-columns">
<div class="content-text">

> *"The hardest single part of building a software system is deciding precisely what to build."*  
> — **Fred Brooks**, *No Silver Bullet (1987)*

* **1. Tacit Knowledge Barrier:**
  - Experts struggle to articulate routine habits (*"It's just obvious!"*).
* **2. Solution Bias (Premature Anchoring):**
  - Non-technical clients jump straight to UI/tech solutions.
* **3. Conflicting Stakeholder Agendas:**
  - Competing priorities across marketing, security, and finance.
* **4. Requirements Volatility:**
  - Needs continuously shift as soon as prototypes are touched.

</div>
<div class="content-figure">

<div class="name-card">
  <img src="../../img/ch03/fred_brooks.jpg" alt="Fred Brooks" />
  <div class="name-card-caption">
    <span class="name-card-name">Fred Brooks (1931–2022)</span>
    <span class="name-card-cc"><a href="https://en.wikipedia.org/wiki/Fred_Brooks" target="_blank">Turing Award (1999) / Wikipedia</a></span>
  </div>
</div>

</div>
</div>

<!--
Before we conclude our study of elicitation and modeling, let us reflect on a fundamental reality: Why is requirements elicitation so notoriously difficult?

Fred Brooks famously stated in 'No Silver Bullet' that the hardest single part of building software is deciding precisely what to build. No other part of the work so cripples the resulting system if done wrong!

Why is elicitation so challenging in practice?

First is the Articulation Barrier: Experts possess vast amounts of tacit knowledge. Because their routines are second nature, they unconsciously omit critical domain assumptions during interviews.

Second is Solution Bias: Non-technical clients rarely state their raw problem. Instead, they jump straight to premature solutions—demanding a dropdown menu or a blockchain ledger when a simple business process fix was needed.

Third is Conflicting Agendas: There is no single 'user'. In healthcare, doctors, nurses, billing clerks, and compliance officers have deeply conflicting goals that pull the software in opposite directions.

And fourth is Requirements Volatility: Requirements are a moving target. The moment stakeholders see the first working prototype, their mental model expands and their requirements shift.

To summarize this slide, remember this key takeaway: Elicitation is hard because it requires uncovering unspoken tacit habits, resolving political conflicts, and adapting to inevitable scope shifts.
-->

---
## Requirements Elicitation & Modeling

> The collaborative, iterative process of discovering, understanding, negotiating, and modeling stakeholder needs and operational system boundaries.

* **Four Interleaved Activities:**
  1. **Elicitation & Analysis:** Discovering requirements from stakeholders.
  2. **Specification:** Documenting requirements formally.
  3. **Validation:** Checking that requirements reflect real needs.
  4. **Management:** Managing changes to requirements over time.
* **Spiral & Iterative Nature:**
  - RE is **never a single-pass, linear activity**; it is an iterative spiral where understanding deepens across successive releases.

<!--
Now in Module 3.4, let's examine the Requirements Engineering Process and Elicitation.

Requirements engineering consists of four core, interleaved activities: Elicitation and Analysis, Specification, Validation, and Management.

Notice the word: interleaved! In real projects, you don't finish 100% of elicitation before starting specification. As soon as you document a requirement, you discover gaps that trigger further stakeholder discussions.

Requirements engineering is an iterative spiral that continues throughout the life of the software.

To summarize this slide, remember this key takeaway: Requirements engineering is an ongoing, iterative cycle of discovery, specification, validation, and change management.
-->
---
<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch03/comic_clarity_cycle.png" alt="Requirements Engineering Engine of Clarity" />
</div>

<!--
Look at this comic showing the Requirements Engineering Engine of Clarity!

Notice the four active stages around the circular workflow:
First, Elicitation: the engineer is untangling a giant, messy ball of client ideas to discover what users truly need.

Second, Specification: converting those untangled thoughts into structured blueprints and technical documentation.

Third, Validation: reviewing the blueprints with the client to verify they match expectations before writing code.

And fourth, Management: organizing versions, filing changes, and maintaining the specification over time.

To summarize this slide, remember this key takeaway: The requirements cycle continuously transforms tangled ambiguity into verified engineering clarity.
-->

---
## Elicitation Technique 1: Stakeholder Interviews & Workshops

* **Types of Interviews:**
  - **Closed Interviews:** Pre-defined question sets useful for verifying factual constraints and compliance checklists.
  - **Open Interviews:** Unstructured, exploratory conversations uncovering stakeholder frustrations, mental models, and broad visions.
  - **Semi-Structured Interviews:** Core agenda with flexibility to drill down into unexpected operational friction points.
* **The "Unstated Assumptions" Trap:**
  - Stakeholders frequently omit obvious domain knowledge (*"Of course everyone knows taxes change by county!"*).
* **Facilitated Workshops:**
  - Gathers conflicting stakeholders (e.g., Doctors, Nurses, IT, Billing) in one room with a neutral facilitator to resolve competing needs in hours rather than months.

<!--
Let's dive deeply into the first core elicitation technique: Stakeholder Interviews and Facilitated Workshops.

Interviews come in three distinct forms:
Closed interviews: with fixed, predefined questions—great for verifying regulatory checklists.
Open interviews: open-ended discussions where you ask 'What is the most painful part of your day?' to discover hidden problems.
And Semi-structured interviews: the industry standard, combining a prepared topic agenda with the flexibility to explore unexpected issues.

Watch out for the 'Unstated Assumptions' trap! Domain experts live in their world every day. They assume things are so obvious that they forget to mention them to engineers—such as county tax rules or hospital shift handoffs.

When stakeholders disagree, one-on-one interviews create endless back-and-forth email arguments. The solution is a Joint Application Design (JAD) workshop: bring all parties into a single room with a neutral facilitator, whiteboard the workflow, and negotiate trade-offs in real time.

To summarize this slide, remember this key takeaway: Combining semi-structured interviews with facilitated workshops cuts through hidden assumptions and aligns conflicting stakeholder priorities.
-->
---
## Interview Heuristics: Principles, Myths 

* **Core Principles:**
  - **Listen 80%, Talk 20%:** Let stakeholders articulate operational pain points without interruption.
  - **Focus on Problems, Not Solutions:** Ask *"What goal are you trying to accomplish?"* rather than *"Do you want a dropdown button?"*
* **Common Myths:**
  - *Myth 1:* "Users know what they want and state it clearly." (Reality: They confuse symptoms with root causes).
  - *Myth 2:* "One interview yields a complete spec." (Reality: Interviews provide initial hypotheses).
  - *Myth 3:* "Discuss technical architecture with users." (Reality: Microservices/SQL talk alienates stakeholders).

<!--
Now let us examine the heuristics, myths, and practical skills of effective stakeholder interviewing.

First, the core principles: The golden rule of interviewing is Listen 80%, Talk 20%! Software engineers love solving problems immediately, but jumping in with solutions stops the client from revealing the true bottleneck. Always anchor questions in the problem domain, not the solution domain.

Second, let us dispel three persistent myths:
Myth 1: Users know what they want. In reality, users know what frustrates them, but they often request bandages rather than cures.
Myth 2: One interview gives you a finished specification. Elicitation is a discovery journey; an interview only provides initial clues.
Myth 3: You should discuss databases or code. Bringing up technical jargon makes non-technical users clam up.

Third, practical skills: Use the '5 Whys' technique to drill down to root business causes. And practice the 'Three-Second Pause': when a user pauses, do not rush to fill the silence. Wait three seconds, and they will almost always volunteer the messy, real truth!

To summarize this slide, remember this key takeaway: Masterful interviewers listen actively, separate problems from solutions, and use targeted questioning to uncover root causes.
-->
---
## Elicitation Technique 2: Ethnography & Workplace Observation

> *"What people say they do, and what they actually do, are often entirely different."*

* **The Power of Direct Observation:**
  - Spending time in the actual operational environment (e.g., hospital ER, trading floor, warehouse loading dock).
* **Uncovering "Tacit Knowledge":**
  - **Tacit Knowledge:** Deeply ingrained habits, shortcuts, and informal workarounds that users perform automatically but never mention in meetings.
* **Observation Styles:**
  - **Passive Observation ("Fly on the Wall"):** Watching natural workflows without interruption to identify operational bottlenecks and cognitive load.
  - **Contextual Inquiry (Active Shadowing):** Observing users perform real tasks, asking clarifying questions in the moment (*"Why did you write that code on a sticky note?"*).

<!--
Our second core technique is Ethnography and Workplace Observation.

Margaret Mead famously observed that what people say they do, and what they actually do, are often completely different!

In formal interviews, users describe the official company policy. But when you sit next to them on the trading floor or in the emergency room, you discover 'tacit knowledge'—the real, messy shortcuts they use to survive their daily workload.

Think of the classic hospital example: an engineer asks nurses how they administer medicine, and they describe the six-step software protocol. But when you shadow the nurse on night shift, you see yellow sticky notes plastered all over the computer monitor with temporary patient codes, because the official system takes eight clicks to load!

If you only interview, you automate the theoretical process. If you observe ethnographically, you solve the real human problem.

To summarize this slide, remember this key takeaway: Workplace observation uncovers informal workarounds and tacit knowledge that users never describe in formal interviews.
-->
---
## Elicitation Technique 3: Scenarios, User Stories & Storyboards

* **Concrete Narrative Scenarios:**
  - Rich, chronological walkthroughs of realistic, day-in-the-life system usage under both typical conditions and crisis situations.
* **Agile User Stories & Acceptance Criteria:**
  - **Format:** *"As a [User Role], I want [Capability], so that [Business Value]."*
  - **Given-When-Then (Gherkin):**
    - *Given* a customer with an active promo code,
    - *When* they apply the code to an eligible restaurant order,
    - *Then* the subtotal must reflect a 20% discount up to a maximum of \$10.
* **Low-Fidelity Storyboarding & Paper Prototyping:**
  - Quick comic-strip sketches of user journeys that elicit early, visceral feedback before writing code (*"I didn't realize I'd need 5 screen taps just to reorder!"*).

<!--
The third elicitation technique is Scenarios, User Stories, and Storyboards.

Abstract requirements like 'The system shall provide authentication' put stakeholders to sleep. But tell a concrete story—'Dr. Emily is running to Room 302 while wearing sterile latex gloves during an emergency code'—and suddenly requirements become crystal clear!

In agile development, we encapsulate requirements in User Stories: 'As a user, I want a capability, so that I get a specific value.' To make them testable, we write Given-When-Then acceptance criteria. Notice how this bridges the gap between human language and automated acceptance tests.

Furthermore, we use Storyboards and Paper Prototypes: simple hand-drawn sketches of screens and user actions. Users who are hesitant to critique expensive software feel completely comfortable scribbling with a red pen on paper sketches, revealing layout friction before any code is written.

To summarize this slide, remember this key takeaway: Concrete narrative scenarios and paper storyboards make abstract requirements tangible and immediately testable.
-->
---
<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch03/comic_ubereats_user_story.png" alt="Agile User Story & Acceptance Criteria: UberEats Courier Tracking" />
</div>

<!--
Look at this comic illustrating Agile User Stories and Scenarios in action using UberEats!

In Panel 1, our hungry student formulates the classic User Story:
'As a Hungry Customer, I want live GPS tracking of my UberEats courier, so that I do not wait in the cold rain!'
Notice how this encapsulates the actor role, system capability, and real business value.

In Panel 2, the courier picks up the order and pedals through the city with live GPS waypoints.

In Panel 3, see how the engineering team turns this user story into verifiable acceptance criteria using Given-When-Then:
'GIVEN the courier is within 2 minutes,
WHEN the app alerts the customer,
THEN the food is delivered hot and fresh!'

And in Panel 4, the criteria are fulfilled—the customer steps downstairs right on time and receives steaming hot ramen.

To summarize this slide, remember this key takeaway: User stories articulate human motivation, while Given-When-Then acceptance criteria define the objective test of completion.
-->
---
## Elicitation Technique 4: Document Analysis & System Archaeology

* **Mining Existing Operational Artifacts:**
  - **Standard Operating Procedures (SOPs):** Official enterprise rules, compliance manuals, and safety checklists.
  - **Legacy Code & Database Schemas:** Reverse-engineering existing production systems to extract implicit business algorithms.
  - **Forms & Spreadsheet Archaeology:**
    - Paper intake forms, invoice receipts, and manual Excel tracking sheets.
    - *Rule of Thumb:* Every column in an active Excel sheet represents an unfulfilled requirement of the previous software system!
* **The "Archaeology Trap":**
  - Distinguish between **essential business logic** (must preserve) and **historical technical workarounds** (must deprecate, not blindly digitize).

<!--
Our fourth elicitation technique is Document Analysis and System Archaeology.

Before building a new system, you must investigate the paper trail and legacy software already in place.

Look at existing standard operating procedures, training manuals, and regulatory audits. More importantly, inspect the manual Excel spreadsheets that staff use every day!

Here is an essential software engineering rule of thumb: Every custom column in an employee's private Excel sheet represents a feature that the previous software system failed to provide. By analyzing these spreadsheets, you uncover months of hidden operational requirements.

However, beware the 'Archaeology Trap'! Do not blindly copy every step of an ancient manual workflow into your software. Ask: 'Is this an essential business rule, or was this just a workaround for a broken printer from 1998?' Automate the goal, not the historical inefficiency.

To summarize this slide, remember this key takeaway: Analyzing existing forms and spreadsheets reveals unfulfilled needs, but engineers must separate essential business logic from obsolete workarounds.
-->
---
## Choosing Elicitation Techniques: A Comparative Matrix

| Technique | Primary Strengths | Main Limitations | Best Applied When... |
|---|---|---|---|
| **Interviews** | High depth; builds personal stakeholder rapport | Vulnerable to bias; misses tacit knowledge | Initial discovery & understanding broad goals |
| **Workshops (JAD)** | Resolves conflicting priorities; rapid alignment | Scheduling friction; dominant personalities | Multiple stakeholders have competing requirements |
| **Ethnography** | Discovers actual behavior & informal workarounds | Highly time-consuming; non-generalizable | Complex, physical, high-stress work environments |
| **User Stories & Scenarios** | Testable; directly feeds agile sprint backlogs | Can miss global non-functional constraints | Defining incremental user-facing features |
| **Doc Analysis** | Highly objective; uncovers legacy business rules | Documents are often outdated or aspirational | Replacing legacy systems & regulated domains |

<!--
To conclude our elicitation module, let's examine this comparative engineering matrix.

No single elicitation technique is sufficient on its own. A senior requirements engineer selects the right tool for each situation:

Use Interviews for early broad exploration and building trust.
Use Joint Application Design workshops when you need to resolve stubborn political conflicts between departments.
Use Ethnography and Observation in high-stress, complex physical environments like operating rooms and flight control towers, where unwritten habits make or break usability.
Use User Stories and Scenarios to turn requirements into testable agile sprint backlogs.
And use Document Analysis when replacing legacy mainframe systems or ensuring regulatory compliance.

Combining these techniques provides a 360-degree view of real user needs.

To summarize this slide, remember this key takeaway: A professional engineer combines multiple complementary elicitation techniques to capture both high-level goals and ground-level realities.
-->
---
<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch03/comic_elicitation_techniques.png" alt="The Four Requirements Elicitation Techniques" />
</div>

<!--
Take a look at this four-panel comic summarizing our four core requirements elicitation techniques in action!

In Panel 1: Interviews & Workshops! The engineer is interviewing the client while the whiteboard behind them is covered in colorful sticky notes from a Joint Application Design session. Asking questions directly helps align high-level goals.

In Panel 2: Ethnography & Observation! Look at our engineer acting as a 'fly on the wall', peeking from behind a potted plant. Notice what the worker is doing: the screen is covered in yellow sticky notes with secret workarounds! That is tacit knowledge in action—habits users never mention in formal meetings.

In Panel 3: Scenarios & Storyboards! The engineer presents low-fidelity comic-strip sketches of the user journey. The customer immediately points out friction points before any software has been coded.

And in Panel 4: Document Archaeology! The engineer dons an archaeologist hat with a magnifying glass, unearthing ancient standard operating procedures from 1998 and a monster Excel spreadsheet with eighty custom columns!

To summarize this slide, remember this key takeaway: A master requirements engineer combines interviews, observation, storyboards, and document archaeology to uncover both stated wishes and unstated operational realities.
-->
---
### Concept Check Question 4
<!-- id: ase-ch03-ccq4 -->
<div class="ccq-columns">
  <div class="ccq-text">

During a requirements elicitation interview, an executive insists: *"Our clinical software must include a blockchain ledger to record patient vitals."* What is the most effective engineering interview heuristic to apply?

- **A.** Apply the "5 Whys" to investigate the underlying data integrity and audit problem rather than prematurely locking in the suggested technology.
- **B.** Immediately begin drafting smart contracts and relational database schemas for the requested blockchain feature.
- **C.** Reject the executive's request outright because non-technical stakeholders are prohibited from proposing system capabilities.
- **D.** Politely terminate the interview and switch exclusively to passive workplace observation.

  </div>
  <div class="ccq-logo">
    <a href="https://nlhsueh.github.io/nickedupocket/#/student/ase-ch03-ccq4" target="_blank"><img src="../../img/ch03/ase-ch03-ccq4.png" alt="QR Code" /></a>
  </div>
</div>

<!--
Let's test our understanding of interview heuristics with Concept Check Question 4.

Look at the scenario on screen: An executive insists that clinical software must include a blockchain ledger for patient vitals. What is the most effective engineering interview heuristic?

Let's evaluate the options:
Option A applies the '5 Whys' to explore the real underlying problem—audit trails, tamper-resistance, or compliance—rather than blindly implementing blockchain.
Option B immediately jumps to coding smart contracts.
Option C rudely rejects the stakeholder.
Option D abandons the interview entirely.

The correct answer is Option A! Stakeholders frequently suggest specific technical tools because they heard a buzzword, when their real business requirement is data integrity or regulatory traceability. An engineer's job is to uncover the underlying problem, not prematurely implement proposed technical band-aids.

To summarize this slide, remember this key takeaway: Always probe past superficial technology requests to discover the root business and operational requirements.
-->
---
### Concept Check Question 5
<!-- id: ase-ch03-ccq5 -->
<div class="ccq-columns">
  <div class="ccq-text">

In requirements engineering, why is **Ethnography (workplace observation)** uniquely vital when analyzing complex operational environments such as hospital emergency rooms or air traffic control?

- **A.** It uncovers tacit knowledge—ingrained habits, physical workarounds, and unwritten shortcuts that users perform automatically but never mention during interviews.
- **B.** It automatically compiles natural language requirements directly into executable acceptance test suites without human intervention.
- **C.** It eliminates the need for subsequent software architecture design, database modeling, or code review phases.
- **D.** It guarantees that the resulting software requirements will achieve 100% mathematical completeness on the initial development sprint.

  </div>
  <div class="ccq-logo">
    <a href="https://nlhsueh.github.io/nickedupocket/#/student/ase-ch03-ccq5" target="_blank"><img src="../../img/ch03/ase-ch03-ccq5.png" alt="QR Code" /></a>
  </div>
</div>

<!--
Let's test our understanding of elicitation techniques with Concept Check Question 5.

Look at the prompt on screen: In requirements engineering, why is Ethnography (workplace observation) uniquely vital when analyzing complex operational environments?

Let's review our choices:
Option A focuses on uncovering tacit knowledge—ingrained habits, physical workarounds, and unwritten shortcuts.
Option B claims it automatically compiles requirements into tests.
Option C claims it eliminates architecture and code reviews.
Option D claims it guarantees 100% mathematical completeness.

The correct answer is Option A! People often cannot articulate everything they do because habits become second nature. By observing practitioners in their actual physical workspace, engineers uncover critical tacit knowledge—like sticky notes, manual spreadsheets, and physical handoffs—that never appear in official manuals or interviews.

To summarize this slide, remember this key takeaway: Ethnography uncovers tacit knowledge and informal workarounds that stakeholders take for granted and omit from interviews.
-->
---
## From Scenarios to Use Cases: Bridging Elicitation to Modeling

> How do engineers transition from raw elicitation stories (Technique 3) into structured system models?

* **Connecting to Elicitation Technique 3 (Scenarios & User Stories):**
  - Elicitation produces concrete human stories (*"Alice orders sushi using a coupon, but her card expires"*).
* **What is a Scenario?**
  - A single, concrete execution path through a user interaction (one specific narrative sequence).
* **What is a Use Case?**
  - A **generalized** umbrella that aggregates **all related scenarios** (the Happy Path plus all alternative & exception flows) for a specific actor goal (*Place Food Order*).
* **Why Transition from Scenarios to Use Cases?**
  - Scenarios provide rich narrative context; use cases structure them into comprehensive functional contracts for engineering and test planning.

<!--
Let us connect our modeling journey back to Elicitation Technique 3: Scenarios and User Stories!

Students often ask: Where do use cases come from? Do they appear out of thin air? No! They are derived directly from the scenarios and user stories we gathered during elicitation.

Remember: A scenario is a single concrete story about one user having one experience.

A Use Case is the generalized umbrella that bundles all those related scenarios together—the primary happy path, along with every single alternative and exception path, achieving one clear business goal.

Scenarios provide empathy and narrative clarity; use cases transform them into structured engineering requirements.

To summarize this slide, remember this key takeaway: Scenarios capture individual user journeys, while use cases aggregate all related paths into structured interaction contracts.
-->
---
## Discovering Use Cases: The 5-Step Process

How do engineers systematically discover and structure use cases during elicitation?

1. **Identify External Actors:** Determine who or what interacts directly with the software (human roles, payment gateways, automated sensors).
2. **Identify Actor Business Goals:** For each actor, ask: *"What observable value do they need the system to deliver?"*
3. **Group Scenarios into Use Cases:** Cluster related user stories into verb-noun operational goals (*Place Order*, *Track Delivery*).
4. **Define System Boundaries:** Clearly demarcate what logic resides inside the application vs. what remains external or manual.
5. **Factor Common & Conditional Logic:** Extract shared mandatory steps (`<<include>>`) and optional variations (`<<extend>>`).

<!--
Now, how do requirements engineers systematically discover and guide use cases during elicitation? We follow a proven 5-step process:

Step 1: Identify External Actors. Who touches the software? Remember, actors are roles, not specific people—and external services like payment gateways count as actors too.

Step 2: Identify Actor Goals. What observable business value does each actor need? Focus on outcomes, not micro-actions like clicking buttons.

Step 3: Group Scenarios into Use Case Candidates. Bundle related daily user stories under concise verb-noun names, like 'Place Order' or 'Withdraw Cash'.

Step 4: Establish System Boundaries. Draw a crisp box around what our software owns versus what external APIs or manual staff handle.

Step 5: Factor Common and Conditional Logic. Extract shared, reusable sub-tasks using 'include', and handle edge cases or optional add-ons using 'extend'.

With this 5-step elicitation framework in hand, let us look at the standard UML notation for visualizing these models!

To summarize this slide, remember this key takeaway: Guide use case discovery by identifying actors and business goals before establishing boundaries and factoring relationships.
-->
---
## Use Case Diagram Notation (UML)

* **Actors:** External entities (users or systems) interacting with the application.
* **Use Cases:** Ellipses representing high-level functional interactions.
* **System Boundary:** Box defining scope of the system under design.
* **Relationships:**
  - **`<<include>>`:** Behavior that is always executed as part of the base use case (e.g., *Authenticate User* included in *View Medical Records*).
  - **`<<extend>>`:** Optional or conditional behavior triggered under specific conditions (e.g., *Prescribe Controlled Substance* extends *Prescribe Medication*).

<!--
To model functional interactions, we use UML Use Case Diagrams.

A use case diagram has four key elements:
Actors: stick figures representing external human roles or external systems interacting with our software.
Use Cases: horizontal ellipses representing discrete functional tasks that yield observable value.
The System Boundary: a box defining what is inside our software versus what is outside.
And Relationships: especially `<<include>>`, where a sub-task is always required, and `<<extend>>`, where extra behavior is triggered conditionally under specific edge cases.

To summarize this slide, remember this key takeaway: Use case diagrams define system scope and model interactions between external actors and system services.
-->
---
<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch03/use_case_anatomy_handwrite.png" alt="Anatomy of a UML Use Case Diagram" />
</div>

<!--
Look at this hand-drawn diagram: 'Anatomy of a UML Use Case Diagram.'

On the left is the Actor—a stick figure representing an external user, such as a bank customer.

In the center is the System Boundary box enclosing the core functions of the ATM banking system: 'Withdraw Cash', 'Check Balance', and 'Transfer Funds'.

Notice the dashed arrows labeled `<<include>>`: all three core transactions automatically include the 'Authenticate User' use case.

To summarize this slide, remember this key takeaway: A use case diagram defines system scope and clearly maps external actors to value-delivering system journeys.
-->
---
<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch03/use_case_description_handwrite.png" alt="Use Case Description: Withdraw Cash" />
</div>

<!--
Look at this detailed hand-drawn whiteboard specification: 'Use Case Description: Withdraw Cash (ATM Banking System).'

Remember our previous slide? A UML diagram provides the bird's-eye view, but an ellipse alone cannot tell developers how to build or test the feature! For that, we author a rigorous, step-by-step Use Case Description.

Look at the structure on the whiteboard:
First, the Metadata box on the left:
- Primary Actor: Bank Customer.
- Preconditions: ATM is online, cash vault loaded, and card inserted & validated.
- Postconditions: Cash dispensed, account balance debited, audit log recorded, and card returned.

Second, look at the Main Success Scenario—the sequential 'Happy Path' on the right:
Step 1: Customer selects 'Withdraw Cash' and inputs amount ($100).
Step 2: System verifies available account balance with Core Banking API.
Step 3: System confirms internal ATM vault has sufficient bills.
Step 4: System debits customer account and creates transaction log.
Step 5: System initiates cash dispensing mechanism.
Step 6: System ejects ATM card and sounds chime.
Step 7: Customer removes card; System opens cash dispenser shutter.
Step 8: Customer takes cash; System prints transaction receipt.

Finally, look at the Extensions & Exceptions box at the bottom:
Real software spends 80% of its logic handling edge cases:
- Step 2a: Insufficient Balance? System displays an alert, offers balance check, and aborts cleanly.
- Step 3a: Machine Out of Cash? Machine alerts customer, limits withdrawal amount, or aborts.
- Step 6a: Unclaimed Card? If card not taken within 30 seconds, ATM retracts card for security!
- Step 8a: Unclaimed Cash? If cash left in tray for 30 seconds, shutter closes and debit is reversed.

This comprehensive specification is what QA engineers use to write automated test suites, and what engineers use to implement robust business logic.

To summarize this slide, remember this key takeaway: A use case description transforms high-level diagram bubbles into an enforceable, step-by-step contract covering both normal and exception flows.
-->

---
### Concept Check Question 6
<!-- id: ase-ch03-ccq6 -->
<div class="ccq-columns">
  <div class="ccq-text">

A software engineering team creates a UML Use Case Diagram showing an actor connected to the "Withdraw Cash" use case. Why must engineers author a detailed textual **Use Case Description** in addition to the diagram?

- **A.** Diagrams only show high-level scope; descriptions define sequential flows, preconditions, postconditions, and exception handling.
- **B.** UML diagrams cannot be rendered by web browsers without accompanying markdown text.
- **C.** Compilers require use case descriptions to allocate heap memory for actor threads.
- **D.** Descriptions convert non-functional requirements into automated GUI wireframes.

  </div>
  <div class="ccq-logo">
    <a href="https://nlhsueh.github.io/nickedupocket/#/student/ase-ch03-ccq6" target="_blank"><img src="../../img/ch03/ase-ch03-ccq6.png" alt="QR Code" /></a>
  </div>
</div>

<!--
Let us evaluate our understanding of requirements modeling with Concept Check Question 6.

Look at the prompt: A software engineering team creates a UML Use Case Diagram showing an actor connected to 'Withdraw Cash'. Why must engineers author a detailed textual Use Case Description in addition to the diagram?

Let us evaluate the options:
Option A explains that diagrams provide high-level system scope, while descriptions provide the sequential happy path, preconditions, postconditions, and exception handling.
Option B mentions web browser rendering.
Option C mentions compiler heap memory rules.
Option D claims use case descriptions convert NFRs into wireframes.

The correct answer is Option A! A use case diagram is just a visual table of contents; it shows who interacts with what feature. But engineers cannot write code or tests from an ellipse alone. They need the textual use case description to know the exact preconditions, the sequential normal flow, and how to handle exception flows when things go wrong.

To summarize this slide, remember this key takeaway: A UML diagram establishes scope, while the use case description specifies the contract of normal and exception behaviors.
-->
---
## Interactive Activity: Cybercab Requirements Elicitation (Pair Discussion)

> **10-Minute Pair Mission:** You are Lead Requirements Engineers for Cybercab. Deliver a **3-Point Elicitation Action Plan** on paper / shared doc within 10 minutes:

<div class="three-columns">

<div class="card" data-marpit-fragment>

### Deliverable 1: Stakeholders (3m)
*Select 2 contrasting stakeholder groups:*
- **Action Guide:**
  - Pick 2 groups: e.g. Daily Rider, Car Owner (Lessor), Disabled Rider, or City Traffic Dept.
  - **Your Output:** Formulate **1 hidden / unstated pain point** for each group that a regular online survey would miss.

</div>

<div class="card" data-marpit-fragment>

### Deliverable 2: Techniques (4m)
*Match 1 elicitation technique to each:*
- **Action Guide:**
  - Choose methods from 3.4: Contextual Observation, Cabin VR Mockup, or Workshops.
  - **Your Output:** Justify *why* this specific technique uncovers their tacit needs and emotional friction effectively.

</div>

<div class="card" data-marpit-fragment>

### Deliverable 3: Reconcile (3m)
*Resolve 1 direct clash between them:*
- **Action Guide:**
  - Define 1 conflict: e.g. Curbside drop-off anywhere vs. City traffic safety laws.
  - **Your Output:** Apply **MoSCoW** (Must-Have vs. Won't-Have) to declare the winner and give your engineering rationale.

</div>

</div>

<!--
Let's pause here for our capstone 10-minute pair discussion: Planning the Cybercab Requirements Elicitation Campaign! Turn to your classmate next to you—together, you are the Requirements Engineering Leads for the Cybercab platform.

You have a strict 10-minute timebox to produce a 3-point action plan on your notebook or laptop. Look at the three cards on the screen:

In the first 3 minutes (Deliverable 1): Select 2 contrasting stakeholders—such as a Daily Commuter Rider and a City Traffic Official, or an Elderly Passenger with a Walker and a Car Owner who leases out the vehicle. Identify 1 unstated, tacit pain point for each that a simple questionnaire would never reveal.

In the next 4 minutes (Deliverable 2): Select the most effective elicitation method for each stakeholder from Section 3.4. For example, using Contextual Ethnography (riding along with existing taxi/rideshare users) to observe how elderly riders handle heavy bags, or using a Full-Scale Cabin Mockup and VR prototype to test wheelchair access and emergency stop levers.

In the final 3 minutes (Deliverable 3): Identify an inevitable conflict between your two stakeholders. For instance, the rider wants drop-off directly at the destination door on a busy street, but the city traffic code prohibits stopping in bus lanes. Apply MoSCoW prioritization to decide which requirement wins, and justify your engineering trade-off.

I will call on two pairs to present their 3 deliverables in 60 seconds each!

To summarize this slide, remember this key takeaway: A successful 10-minute elicitation plan identifies contrasting stakeholders, matches deep discovery techniques to uncover tacit needs, and uses MoSCoW to decisively resolve trade-offs.
-->
---
<!-- _class: lead -->
<!-- header: '3.5 Validation & Change' -->

# **3.5 Requirements Validation & Change Management**

> "Change is inevitable. In a living system, requirements management is the art of embracing change without descending into chaos."

<!--
We now enter Module 3.5: Requirements Validation and Change Management.

Even after a specification is written, our work is far from complete. Are our requirements complete, consistent, and feasible? Requirements validation acts as the ultimate quality gate before costly construction begins.

Furthermore, because business environments and markets constantly evolve, requirements will inevitably change. We will investigate the Five Pillars of validation and explore formal change management pipelines and bidirectional traceability.

To summarize this slide, remember this key takeaway: Rigorous validation ensures we build the right system, while traceability matrices keep evolution controlled and auditable.
-->
---
## Requirements Validation & Change Management

> The critical quality process of certifying that requirements represent real user needs, and managing evolving specifications throughout the software lifecycle.

* **High Cost of Requirements Errors:**
  - Fixing a requirements error after system delivery can cost **up to 100 times** more than fixing a coding bug!
* **5 Requirements Checks:**
  1. **Validity:** Does it reflect the real needs of the customer?
  2. **Consistency:** Are there conflicting requirements?
  3. **Completeness:** Are all requirements and constraints included?
  4. **Realism:** Can the requirement be implemented with current budget/tech?
  5. **Verifiability:** Can the requirement be objectively tested?

<!--
Now in Module 3.5, let's examine Requirements Validation.

Why is validation so crucial? Because fixing a requirement defect after the software is deployed costs up to 100 times more than catching it now!

When reviewing requirements, we apply Five Golden Checks:
Validity: Does the system really need this?
Consistency: Does this contradict any other requirement?
Completeness: Did we forget any edge cases?
Realism: Can we actually build this within budget and technology constraints?
And Verifiability: Can our test engineers write an automated test that objectively verifies it?

To summarize this slide, remember this key takeaway: Rigorous validation ensures specifications are valid, consistent, complete, realistic, and verifiable before coding begins.
-->
---
<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch03/comic_5_pillars_validation.png" alt="The 5 Pillars of Requirements Validation" />
</div>

<!--
Take a look at this comic: 'The 5 Pillars of Requirements Validation!'

Here we see our quality inspection line running five critical checkpoints:
First, Validity: the inspector confirms directly with the client: 'Is this what you really need?'
Second, Consistency: catching blatant contradictions where one page says 'Must be Red' and another says 'Must be Blue'!
Third, Completeness: finding that missing puzzle piece of forgotten edge cases.
Fourth, Realism: checking the price tag and calculator to ensure feasibility within budget and timeline.
And fifth, Verifiability: the QA engineer holding a clear checklist of pass/fail automated tests.

To summarize this slide, remember this key takeaway: Testing requirements across the five validation pillars prevents catastrophic defects before writing a single line of code.
-->
---
## Requirements Change & Management

* **Why Requirements Change:**
  - Business goals shift, new regulations emerge, payors and actual system users have conflicting demands.
* **Requirements Management Planning:**
  - **Unique Identification:** Tagging every requirement with a traceable ID (e.g., `REQ-SEC-012`).
  - **Traceability Policies:** Maintaining links from requirements to architecture modules, code commits, and test cases.
  - **Change Control Process:** Formal assessment of the cost and architectural impact before approving changes.

<!--
In software engineering, change is not an anomaly; it is an inevitable law of nature.

Why do requirements change? Because businesses evolve, competitors launch new features, and regulations update.

To survive change without falling into chaos, we need Requirements Management:
First, give every requirement a unique, permanent identifier.
Second, maintain Traceability: link every requirement forward to design modules and unit tests, and backward to business goals.
And third, establish a clear Change Control Process to analyze the cost, risk, and timeline impact before accepting modifications.

To summarize this slide, remember this key takeaway: Disciplined traceability and change control turn inevitable requirements volatility into manageable evolution.
-->
---
<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch03/req_change_management_handwrite.png" alt="Requirements Change Management & Traceability" />
</div>

<!--
Look at this hand-drawn architectural diagram: 'Requirements Change Management & Traceability.'

On the left is Unique ID Tagging: organizing every requirement into structured index cards (REQ-01, REQ-02).

In the center is the Traceability Matrix: clear linking arrows connecting each requirement directly to its Architecture Component, Code Module, and Test Cases.

And on the right is the Change Control Board: balancing Cost versus Value, running rigorous impact analysis before any modification receives the official 'Approved' stamp.

To summarize this slide, remember this key takeaway: Unique IDs, traceability links, and impact analysis enable systems to absorb evolving requirements without chaotic breakdown.
-->
---
### Concept Check Question 7
<!-- id: ase-ch03-ccq7 -->
<div class="ccq-columns">
  <div class="ccq-text">

Why is fixing a requirements error after software delivery significantly more expensive than fixing an error during early development?

- **A.** Requirements documents cannot be legally modified once signed by clients.
- **B.** A late fix requires redesigning, recoding, retesting, and redeploying cascading components that were built on the flawed premise.
- **C.** Compilers automatically lock code repositories against changes after the first production release.
- **D.** Automated unit tests lose their validity after code has been deployed to cloud environments.

  </div>
  <div class="ccq-logo">
    <a href="https://nlhsueh.github.io/nickedupocket/#/student/ase-ch03-ccq7" target="_blank"><img src="../../img/ch03/ase-ch03-ccq7.png" alt="QR Code" /></a>
  </div>
</div>

<!--
Let's work through Concept Check Question 7 on Requirements Validation.

Read the prompt carefully: Why is fixing a requirements error after software delivery significantly more expensive than fixing an error during early development?

Look at the options:
Option A mentions legal locks.
Option B highlights cascading rework across design, code, tests, and deployment.
Option C mentions compiler locks.
Option D talks about test validity.

The correct answer is Option B! When a requirement defect escapes into production, all the downstream work built on that false premise—the architectural design, database schemas, API contracts, frontend views, and automated tests—must be ripped out and rebuilt. That cascading rework is what causes the 100x cost explosion.

To summarize this slide, remember this key takeaway: Late requirements defects cause massive cascading rework across code, architecture, tests, and documentation.
-->
---
<!-- _class: lead -->
<!-- header: '3.6 AI in Requirements Engineering' -->

# **3.6 AI-Assisted Requirements Engineering**

> "AI is a cognitive amplifier for requirements analysis, but human judgment remains the irreplaceable anchor of accountability."

<!--
Now we arrive at the cutting-edge frontier, Module 3.6: AI-Assisted Requirements Engineering.

The emergence of Large Language Models has sparked a revolution in how software engineers interact with natural language specifications. Because LLMs are trained on massive repositories of domain knowledge, they excel at synthesizing ambiguous interview notes, identifying missing edge cases, and drafting user stories.

However, LLMs can hallucinate non-existent constraints and introduce subtle security gaps. In this section, we explore the four core AI applications in RE and establish why human-in-the-loop validation remains non-negotiable.

To summarize this slide, remember this key takeaway: LLMs dramatically accelerate requirements drafting and edge-case discovery, but human domain experts must retain final verification authority.
-->
---
## AI in Requirements Engineering: Overview

> Leveraging Large Language Models as intelligent analytical copilots to bridge informal human dialogue and formal, testable software specifications.

* **The Generative AI Paradigm Shift:**
  - LLMs and Generative AI tools serve as an **intelligent RE Copilot** across the software engineering lifecycle.
  - Bridges the gap between informal customer language and formal software engineering artifacts.
* **Key Capabilities:**
  - Drafting structured specifications from messy meeting notes.
  - Detecting semantic contradictions and missing edge cases across hundreds of pages of documentation.
  - Generating initial test cases and Gherkin acceptance criteria automatically.

<!--
Now in Module 3.6, let's explore the modern frontier: AI in Requirements Engineering.

With the rise of Large Language Models, requirements engineering is experiencing its biggest transformation in decades.

LLMs act as an intelligent RE Copilot. They can ingest messy, unstructured customer interview transcripts and draft structured user stories, formal specifications, and acceptance criteria in seconds.

They excel at scanning vast documentation sets to flag contradictions, ambiguities, and missing edge cases that human eyes might miss after reading for hours.

To summarize this slide, remember this key takeaway: Generative AI acts as a tireless analytical partner, transforming informal customer dialogue into structured specifications.
-->
---
## Why LLMs Work for RE: Pre-Trained Domain Ontologies

> *"When you ask an AI to design a food delivery app, it doesn't start from scratch—it already knows the business domain!"*

* **The Secret of Pre-Trained Domain Knowledge:**
  - LLMs are trained on billions of tokens: industry documentation, enterprise case studies, open-source codebases, and ISO/IEEE standards.
  - The model already possesses a latent **Domain Ontology**:
    - **In Banking:** It already knows accounts require transaction atomicity, multi-factor auth, and regulatory audit ledgers.
    - **In E-Commerce / Delivery:** It already understands multi-party split payments, geofencing, dynamic surge pricing, and cancellation refund rules.
* **The "Instant Domain Advisor" Advantage:**
  - **Surfacing Tacit Requirements:** Immediately proposes standard industry edge cases that junior engineers often forget (e.g., promo-code fraud, cold-chain temperature thresholds).
  - **Rapid Scaffolding:** Transforms informal stakeholder interview transcripts into Given-When-Then user stories and UML candidate entities in seconds.

<!--
Why does Generative AI work so remarkably well for Requirements Engineering?

Here is the fundamental reason: LLMs do not start from a blank page. They possess vast, pre-trained domain ontologies!

Think about it: When you tell ChatGPT or Claude, 'I want to build an UberEats clone for local farm groceries,' the model already knows the grocery and delivery domains intimately! It knows you need cold-chain temperature monitoring, driver dispatch radius, split payouts between farmers and couriers, and credit card tokenization.

The model acts as an Instant Domain Advisor. It surfaces tacit, unstated requirements and standard industry checklists that a human development team might take weeks to uncover or accidentally forget until production.

It bridges the gap between chaotic customer transcripts and structured software requirements because it has already seen thousands of similar systems in its training data.

To summarize this slide, remember this key takeaway: LLMs excel in requirements engineering because their pre-trained weights encode deep domain ontologies and standard industry business rules.
-->
---
<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch03/comic_ai_re_copilot.png" alt="AI as a Requirements Engineering Copilot" />
</div>

<!--
Look at this comic: 'AI as a Requirements Engineering Copilot!'

On the left is the dreaded mountain of raw chaos: messy handwritten meeting notes, cassette tapes, conflicting client emails, and vague requests.

In the middle, our multi-armed AI copilot rapidly sorts, analyzes, and refines the unstructured inputs into clean specifications.

And on the right, the lead architect comfortably reviews the generated document—clearly defining user needs and traceability—giving it an enthusiastic thumbs up!

To summarize this slide, remember this key takeaway: Generative AI copilots handle the heavy lifting of sorting raw stakeholder chaos into structured specifications for architect review.
-->
---
## 4 Core AI Applications in RE

1. **Automated User Story & Specification Generation:**
   - Converts raw client interview transcripts into structured `Given-When-Then` Gherkin acceptance criteria.
2. **Ambiguity & Inconsistency Detection:**
   - Scans hundreds of requirement statements to detect contradictory terms and passive-voice vagueness.
3. **Traceability Matrix Construction:**
   - Uses semantic embeddings to map high-level user requirements to code functions and unit tests.
4. **Synthetic Stakeholder Persona Simulation:**
   - Simulates diverse user personas to brainstorm overlooked edge cases during early discovery.

<!--
Here are the four core practical applications of AI in Requirements Engineering today:

First, Automated User Story Generation: taking messy interview notes and generating structured Gherkin `Given-When-Then` acceptance tests.

Second, Ambiguity Detection: using semantic analysis to identify passive voice, missing actors, and contradictory statements across requirements.

Third, Automated Traceability: using semantic embeddings to automatically map user requirements to code files and test suites.

And fourth, Synthetic Persona Simulation: asking an LLM to role-play as a pediatric nurse, a compliance auditor, or a confused patient to discover edge cases you hadn't anticipated.

To summarize this slide, remember this key takeaway: AI accelerates user story drafting, ambiguity scanning, traceability mapping, and persona exploration.
-->
---
<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch03/comic_ai_re_loop.png" alt="The 4 Core AI Applications in Requirements Engineering" />
</div>

<!--
Look at this comic showing the 4 Core AI Applications in Requirements Engineering!

First, User Story Gen: turning rambling client chatter into structured Given-When-Then cards.

Second, Ambiguity Detective: sounding a red siren whenever subjective words like 'User-Friendly' or 'Fast' creep into specifications.

Third, Traceability Matrix: an AI assistant weaving neural links directly connecting requirements documents to code modules and unit tests.

And fourth, Persona Simulator: the robot donning doctor, patient, and hacker personas to simulate rare edge cases before writing code.

To summarize this slide, remember this key takeaway: AI enriches the requirements lifecycle through automated drafting, ambiguity detection, traceability mapping, and persona simulation.
-->
---
## Human-in-the-Loop: Risks & Best Practices

* **Risks of Unchecked AI in RE:**
  - **Hallucinations:** Inventing non-existent business rules or domain constraints.
  - **Privacy & IP Leaks:** Accidentally leaking proprietary business logic to public cloud models.
  - **Bias Amplification:** Reinforcing historical biases in requirements datasets.
* **The Golden Rule: Human-in-the-Loop:**
  - AI proposes; **the Human Software Engineer disposes.**
  - The human engineer retains legal, ethical, and architectural accountability for every accepted requirement.

<!--
While AI tools are powerful, unchecked AI usage in requirements engineering introduces severe risks.

First, Hallucinations: an LLM may invent non-existent business rules or regulatory requirements that sound completely convincing!

Second, Privacy and IP leaks: sending confidential client data or proprietary medical algorithms into public cloud LLMs can violate laws and contracts.

That brings us to our Golden Rule: Human-in-the-Loop. AI proposes, but the human software engineer verifies and approves. You, as the professional engineer, retain ultimate legal, architectural, and ethical accountability.

To summarize this slide, remember this key takeaway: AI is a powerful generator, but the human engineer remains the ultimate gatekeeper of truth and accountability.
-->
---
<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch03/comic_human_in_the_loop.png" alt="Human-in-the-Loop: The Ultimate Responsibility in AI-Assisted RE" />
</div>

<!--
Take a look at this comic: 'Human-in-the-Loop: The Ultimate Responsibility in AI-Assisted RE!'

Here we see an AI-powered vehicle speeding along, with the robot driver gleefully shouting 'Faster! More features!'

But in the driver's seat, the human engineer maintains total command—holding the steering wheel, raising the shield against hallucinations and IP leak risks, and applying the brakes of architectural judgment and safety.

AI can accelerate generation, but only the professional software engineer can be legally, ethically, and architecturally accountable for the final system.

To summarize this slide, remember this key takeaway: Human architectural oversight is non-negotiable; engineers must steer, safeguard, and validate all AI-assisted requirements.
-->
---
### Concept Check Question 8
<!-- id: ase-ch03-ccq8 -->
<div class="ccq-columns">
  <div class="ccq-text">

When software engineering teams use Large Language Models (LLMs) to generate requirements specifications from stakeholder interview transcripts, what is the primary operational risk requiring human-in-the-loop verification?

- **A.** The LLM may hallucinate plausible-sounding but fictitious business logic, omitted edge-case constraints, and non-existent external API integrations.
- **B.** The LLM cannot output text formatted in Markdown bullet points or standard user story Given-When-Then acceptance criteria.
- **C.** The LLM will consume excessive server memory and cause database deadlock errors across production microservice clusters.
- **D.** The LLM strictly enforces waterfall development practices and refuses to generate requirements for iterative agile sprint cycles.

  </div>
  <div class="ccq-logo">
    <a href="https://nlhsueh.github.io/nickedupocket/#/student/ase-ch03-ccq8" target="_blank"><img src="../../img/ch03/ase-ch03-ccq8.png" alt="QR Code" /></a>
  </div>
</div>

<!--
Let's test our understanding of AI in Requirements Engineering with Concept Check Question 8.

Look at the prompt: When software engineering teams use Large Language Models to generate requirements specifications from stakeholder transcripts, what is the primary operational risk requiring human-in-the-loop verification?

Let's review the options:
Option A highlights hallucinated business logic, omitted edge cases, and fabricated API capabilities.
Option B claims LLMs cannot produce Markdown or Given-When-Then criteria.
Option C confuses text generation with production database deadlocks.
Option D claims LLMs refuse to generate agile requirements.

The correct answer is Option A! LLMs are fluent text predictors, not domain experts. They frequently invent plausible-sounding business rules or overlook subtle safety constraints that were never stated by the stakeholder. An experienced requirements engineer must critically audit every generated requirement.

To summarize this slide, remember this key takeaway: Human-in-the-loop verification is essential because AI easily hallucinates plausible-sounding but dangerous requirement errors.
-->
---
<!-- _class: lead -->
<!-- header: '3.7 Recap & References' -->

# **3.7 Conceptual Recap & References**

> "Requirements are the bridge between human intention and digital reality."

<!--
To conclude Chapter 3, we arrive at Module 3.7: Conceptual Recap and References.

We will consolidate all the foundational principles we covered today—from the requirements triad and verifiable NFR metrics to UML use cases and AI-assisted elicitation—through an interactive fill-in-the-blank knowledge check.

We will also review the seminal research papers and textbooks that established modern requirements engineering.

To summarize this slide, remember this key takeaway: Clear, verifiable, and validated requirements are the single greatest predictor of software project success.
-->
---
## Conceptual Recap: Fill-in-the-blank Quiz

Test your understanding of the core concepts in this chapter:

1. **`___`** requirements describe what the system should do, while **`___`** requirements specify system constraints.
2. High-level requirements written for customers are called **`___`** requirements.
3. Detailed specifications written as a technical contract for developers are **`___`** requirements.
4. The Goal-Question-Metric approach turns vague stakeholder wishes into **`___`** metrics.
5. In UML use cases, behavior that is always executed as part of a base use case uses the **`___`** relationship.
6. When using AI in requirements engineering, the engineering principle that ensures accountability is **`___`**.

<!--
Let's do an interactive recap quiz to solidify what we've learned today! Shout out the answers as I read through:

1. Functional requirements describe what the system should do, while Non-Functional requirements specify constraints!

2. High-level requirements for customers are User requirements!

3. Detailed technical specifications for developers are System requirements!

4. The Goal-Question-Metric approach turns vague wishes into Verifiable or Testable metrics!

5. In UML use cases, mandatory shared behavior uses the `<<include>>` relationship!

6. And when using AI in requirements engineering, the vital principle ensuring accountability is Human-in-the-Loop!

Outstanding job, everyone!

To summarize this slide, remember this key takeaway: These core terms form the essential foundation of professional requirements engineering.
-->
---
## References & Further Reading

* **Foundational Textbooks & Standards:**
  - Sommerville, I. (2016). *Software Engineering* (10th ed.). Chapter 4: Requirements Engineering. Pearson.
  - IEEE Std 830-1998 / ISO/IEC/IEEE 29148:2018: *Systems and software engineering — Life cycle processes — Requirements engineering*.
  - Cockburn, A. (2000). *Writing Effective Use Cases*. Addison-Wesley.
  - Wiegers, K., & Beatty, J. (2013). *Software Requirements* (3rd ed.). Microsoft Press.
* **AI & Empirical Requirements Engineering Research:**
  - Ferrari, A., et al. (2023). "Detecting Ambiguities in Requirements with Large Language Models." *IEEE RE'23*.
  - Arora, C., et al. (2024). "Automating Requirements Elicitation and Analysis with LLMs: An Empirical Evaluation." *ACM TOSEM*.
  - Zhang, H., Rahman, M., & Wang, Y. (2024). "Faithfulness, Hallucination, and Risk in Generative Requirements Engineering." *Empirical Software Engineering (EMSE)*.

<!--
Here are the foundational textbooks, international IEEE/ISO standards, and state-of-the-art empirical research papers for Chapter 3.

For classical requirements engineering, Ian Sommerville's Chapter 4 and Karl Wiegers' Software Requirements are the gold standards. Alistair Cockburn's text remains the definitive guide for writing rigorous use cases.

For modern AI-driven requirements engineering, refer to the recent empirical papers from IEEE RE, ACM TOSEM, and Empirical Software Engineering on ambiguity detection, automated elicitation, and hallucination mitigation.

Thank you for your active participation in Chapter 3!
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
