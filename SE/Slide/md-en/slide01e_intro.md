---
marp: true
theme: ase-theme
_class: lead
paginate: true
header: 'Software Engineering | Ch 01: Introduction'
footer: 'Ch 01 · Introduction to Software Engineering'
---

# Software Engineering

### Lecture 1: Introduction to Software Engineering

**Instructor: Professor Nien-Lin Hsueh (with Gemini AI)**  
Department of Information Engineering and Computer Science  
Feng Chia University

<!--
**Hello everyone, and welcome! Let's get started with our first slide.**

Welcome to Advanced Software Engineering.

Today, we look at what makes professional software engineering different from hobby programming.

Fifty years ago, software only ran on huge mainframes. Today, it runs our entire world: phones, banks, hospitals, and cars.

In this chapter, we will explore why software is hard to build, why past crises happened, and how we build reliable software today.

**To wrap up this slide, here is the key takeaway to remember:** Software engineering is about discipline, testing, and management. It helps us build software that lasts.
-->
---
<!-- _class: outline outline-slide -->

## Chapter 1: Roadmap & Core Curriculum

<div class="outline-columns">
  <div>
    <h3>Part 1: Historical Genesis & Foundations</h3>
    <ul>
      <li><b>1.1 Software Changes the World:</b> From room-sized mainframes to ubiquitous AI and digital infrastructure.</li>
      <li><b>1.2 The Genesis of SE:</b> The 1968 NATO Conference, software crisis, and catastrophic historical failures.</li>
      <li><b>1.3 What is Software?:</b> Beyond raw code: programs, data structures, procedures, and documentation.</li>
      <li><b>1.4 What is Engineering?:</b> Real-world trade-offs: balancing competing constraints under finite resources.</li>
      <li><b>1.5 What is Software Engineering?:</b> Formal definition, 4 core activities, SWEBOK, and modern toolchains.</li>
    </ul>
  </div>
  <div>
    <h3>Part 2: Quality, Ethics & Modern AI Era</h3>
    <ul>
      <li><b>1.6 Software Quality Models:</b> ISO/IEC 25010 product quality characteristics and operational attributes.</li>
      <li><b>1.7 Professional Ethics & Dark Patterns:</b> ACM/IEEE Code of Ethics, public interest, and deceptive UI design.</li>
      <li><b>1.8 AI in Software Engineering:</b> Paradigm shifts, SDLC lifecycle impact matrix, and technical engineering rigor.</li>
      <li><b>1.9 Synthesis & Conceptual Recap:</b> Key takeaway review, FAQ, interactive quiz, and classic references.</li>
    </ul>
  </div>
</div>

<!--
Here is our roadmap for Chapter 1.

On the left, in Part 1, we start with how software changed the world, why the Software Crisis happened in 1968, and define the foundational questions: What is Software, What is Engineering, and What is Software Engineering?

On the right, in Part 2, we explore international quality models, professional ethics and dark patterns, and how generative AI is transforming our engineering lifecycle.

To summarize this slide, remember this key takeaway: This chapter establishes the fundamental principles, disciplines, and professional responsibilities of software engineering.
-->
---
<!-- _class: lead -->
<!-- header: '1.1 Software Changes the World' -->

# **1.1 Software Changes the World**

> "Software is eating the world."  
> — *Marc Andreessen*

<!--
Welcome to Module 1.1: Software Changes the World.

Over the past few decades, computing has transformed from specialized mainframe military research into the invisible fabric that underpins modern civilization—powering global finance, healthcare, transportation, and daily social communication.

In this section, we trace the dramatic trajectory of how software evolved into humanity's most transformative technology.

To summarize this slide, remember this key takeaway: Software is no longer just a technical tool; it is the primary engine driving global modern society.
-->
---
<!-- header: '1.1 Software Changes the World' -->

## Software Changes the World: From Mainframes to PCs (1950s–1980s)

* **The Mainframe & Minicomputer Era (1950s–1970s):**
  - *The Paradigm:* Giant machines occupying climate-controlled rooms (IBM System/360); software fed via punch cards and magnetic tapes.
  - *Human Impact:* Automated government censuses, defense radar, and core banking ledgers—computations that previously took months of human calculation were completed in hours.
* **The Personal Computer (PC) Revolution (1980s):**
  - *The Paradigm:* Microprocessors brought software onto every desktop (DOS, Apple Macintosh, Windows, VisiCalc, Lotus 1-2-3).
  - *Daily Convenience:*
    - Transformed paper-based offices into interactive digital workspaces.
    - Real-time electronic spreadsheets and word processing freed billions of worker hours from tedious manual recalculation and retyping.

<!--
**Let's flip over to the next slide.**

Let's look at the first two eras of computing.

In the 1950s and 60s, computers were giant mainframes like the IBM System/360. They filled entire rooms. Operators used punch cards to feed in data.

Then in the 1980s, the Personal Computer revolution arrived. Companies like Apple and Microsoft put computers on every office desk.

People stopped using paper ledgers and started using spreadsheets like VisiCalc and Lotus 1-2-3. This saved millions of hours of manual recalculation.

**To wrap up this slide, here is the key takeaway to remember:** The PC era moved computing power from corporate server rooms directly onto everyone's desk.
-->
---

## The Connected World: The Web & Internet Revolution (1990s–2000s)

* **The Birth of the World Wide Web (1990s):**
  - *The Paradigm:* Tim Berners-Lee created HTTP/HTML; browsers (Netscape, Internet Explorer) transformed the Internet into a universal, clickable cyberspace.
  - *Human Impact:* **Democratization of Global Information**—encyclopedias, academic research, and global news became instantly searchable via Yahoo and Google.
* **The Rise of E-Commerce & Global Platforms (2000s):**
  - *The Paradigm:* Secure web transactions (SSL), distributed databases, and web services (Amazon, eBay, PayPal, Wikipedia).
  - *Daily Convenience:*
    - **Elimination of Geographic Distance:** Instant global communication via email and instant messaging.
    - **24/7 Digital Commerce:** Shopping, ticket booking, and online banking replaced physical lines and postal delays.

<!--
**Next up, let's look at the internet era.**

In the 1990s, Tim Berners-Lee created the World Wide Web.

Browsers like Netscape made the internet visual and clickable. Information became instantly searchable on Yahoo and Google.

In the 2000s, e-commerce took off with Amazon, eBay, and PayPal.

Software was no longer an isolated offline file. It became a 24/7 online service connecting the entire world.

**To wrap up this slide, here is the key takeaway to remember:** The internet turned local desktop software into global, always-on cloud services.
-->
---

## The Pocket Revolution: Mobile & Cloud Everywhere (2010s)

* **Smartphones & The App Economy (iOS & Android):**
  - *The Paradigm:* Software moved into our pockets, tightly integrated with GPS, cameras, accelerometers, and high-speed cellular networks (4G/5G).
  - *Human Impact:* **Software as an extension of the human body**—over 6 billion people carry supercomputers everywhere they go.
* **Cloud Computing & The On-Demand Economy:**
  - *The Paradigm:* Elastic cloud infrastructure (AWS, Azure) streaming software, media, and computation on demand.
  - *Daily Convenience:*
    - **Living in the Cloud:** Ride-hailing (Uber), food delivery, on-demand streaming (Spotify, Netflix), and instant cashless mobile payments.
    - **Frictionless Navigation & Living:** Real-time traffic rerouting (Google Maps) and seamless remote collaboration tools.

<!--
**Turning to the next slide here...**

In the 2010s, software moved right into our pockets.

With iPhones and Android devices, over six billion people carry supercomputers everywhere. They come with GPS, cameras, and fast mobile networks.

At the same time, cloud platforms like AWS and Azure grew rapidly. Companies could build apps like Uber and Netflix and serve millions of users overnight.

Software became part of our daily lifestyle: ride-hailing, food delivery, and streaming entertainment.

**To wrap up this slide, here is the key takeaway to remember:** Mobile devices and the cloud combined to make software part of our everyday life.
-->
---

## The Cognitive Leap: Generative AI & Autonomous Systems (2020s–Present)

* **From Deterministic Logic to Probabilistic Intelligence:**
  - *The Paradigm:* Large Language Models (LLMs), multi-modal foundation models, and autonomous AI agents (ChatGPT, GitHub Copilot, Gemini).
  - *Human Impact:* Software no longer just executes pre-written rules—it understands natural language, generates code, synthesizes media, and reasons across complex knowledge domains.
* **Ambient Intelligence & Cyber-Physical Autonomy:**
  - *The Paradigm:* AI integrated with physical vehicles (self-driving cars), robotics, smart grids, and medical precision diagnostics.
  - *Daily Convenience:*
    - **Zero Marginal Cost of Cognitive Assistance:** Instant 24/7 personal tutors, coding copilots, and multi-lingual real-time translation.
    - **Accelerated Scientific Discovery:** AI predicts protein structures (AlphaFold) and accelerates new drug design from decades to weeks.

<!--
**Alright, let's advance to the next slide.**

Now in the 2020s, we have entered the AI era.

We have foundation models like ChatGPT, Claude, and GitHub Copilot.

Software development is changing fast. Instead of writing every line of code by hand, we can describe our intent using plain English prompts.

AI can draft code, generate unit tests, and summarize documentation.

However, AI can still hallucinate bugs and security risks. Our job as engineers is to verify and ensure system quality.

**To wrap up this slide, here is the key takeaway to remember:** AI helps us code faster, but human engineers must still verify correctness and architecture.
-->

---
<!-- _class: lead -->
<!-- header: '1.2 The Software Crisis' -->

# **1.2 The Genesis of Software Engineering**

> "The major cause of the software crisis is that the machines have become several orders of magnitude more powerful! As long as there were no machines, programming was no problem at all."  
> — *Edsger W. Dijkstra (1972 Turing Award Lecture)*

<!--
We now move into Module 1.2: The Genesis of Software Engineering and the classic Software Crisis.

In the late 1960s, hardware capabilities surged exponentially, but software projects routinely collapsed—running drastically over budget, missing catastrophic deadlines, and causing fatal real-world failures.

This systemic breakdown led computer scientists to convene the historic 1968 NATO conference in Garmisch, coining the term 'Software Engineering' to demand rigorous engineering discipline.

To summarize this slide, remember this key takeaway: Software engineering was born out of crisis, proving that hardware power without disciplined engineering leads to catastrophic project failure.
-->
---
<!-- header: '1.2 The Software Crisis' -->

## The Software Crisis of the Late 1960s

<div class="split55">
  <div class="left">

  - As hardware costs plummeted, software demand and complexity exploded.
  - **The Symptoms of Crisis:**
    - Chronic budget overruns (often 3x–4x initial estimates).
    - Critical project delays and abandoned deliveries.
    - Severe defects, system crashes, and unmaintainability.
  - **The Core Problem:** Informal, craft-like programming does not scale to large teams and complex systems.

  </div>
  <div class="right">
    <img src="../../img/ch01/nato_conference.png" alt="NATO Conference 1968" />
  </div>
</div>

<!--
**Moving right along to our next slide...**

Back in the late 1960s, computer hardware became much faster and cheaper.

Organizations wanted bigger and more ambitious software systems.

However, programming methods were still informal. Developers wrote messy code without clear requirements, documentation, or testing.

As a result, projects routinely ran 3 to 4 times over budget. They missed deadlines and delivered buggy software. Many projects were simply abandoned.

This historical turning point was called the **Software Crisis**.

**To wrap up this slide, here is the key takeaway to remember:** Faster hardware cannot fix human mistakes. Complex software requires disciplined engineering methods.
-->
---

## The 1968 NATO Garmisch Conference

* **October 1968 in Garmisch, Germany:**
  - 50 leading computer scientists and industry managers convened.
  - Formally established the term **"Software Engineering"**.
* **The Mission:**
  - Transition software development from an undisciplined, artisanal craft into a **formal engineering discipline**.
  - Establish structured methodologies, rigorous cost estimation, formal verification, and project management.

<!--
**Let's transition to the next slide.**

To tackle the crisis, 50 computer scientists met in Garmisch, Germany, in October 1968.

Here, they formally established the term **"Software Engineering"**.

Their message was clear: we can no longer treat software development like a personal craft or a hobby.

We must treat software like real engineering—just like building bridges or electrical systems.

We need structured methods, accurate cost estimation, and formal testing.

**To wrap up this slide, here is the key takeaway to remember:** Software Engineering turned programming from an individual craft into a disciplined engineering science.
-->
---

## The High Cost of Software Failure

<div class="content-columns">
<div class="content-text">

* **Nagoya Airbus A300 Crash (1994):**
  - Autopilot Go-Around mode stayed active; fought pilot's manual steering, leading to trim nose-up stall and 264 fatalities.
* **Mars Climate Orbiter (1999):**
  - $327M probe lost because ground software calculated thrust in imperial $lbf\cdot s$, while onboard computer expected metric $N\cdot s$.
* **Ariane 5 Flight 501 (1996):**
  - 64-bit float horizontal velocity overflowed 16-bit signed integer ($>32,767$), crashing processors in 37 seconds.

</div>
<div class="content-figure">

<div class="name-card">
  <img src="../../img/ch01/mars_climate_orbiter_card.jpg" alt="Mars Climate Orbiter (1999)" />
  <div class="name-card-caption">
    <span class="name-card-name">Mars Climate Orbiter</span>
    <span class="name-card-cc"><a href="https://en.wikipedia.org/wiki/Mars_Climate_Orbiter" target="_blank">NASA / JPL / Wikipedia</a></span>
  </div>
</div>

</div>
</div>

<!--
**Shifting our attention to the next slide...**

Software bugs are not just small glitches. They can cost millions of dollars and even human lives.

Look at these three famous disasters on the screen:

First, the **Nagoya Airbus A300 crash in 1994**. The autopilot fought against the pilot's manual steering, causing a stall. Sadly, 264 people died.

Second, the **Mars Climate Orbiter in 1999**. A 327-million-dollar probe was lost because of a simple unit mismatch: one team used English pounds, and the other team used metric Newtons!

Third, **Ariane 5 Flight 501 in 1996**. A 64-bit velocity value overflowed a 16-bit register. The rocket exploded in just 37 seconds, destroying 500 million dollars.

**To wrap up this slide, here is the key takeaway to remember:** Software bugs can destroy systems and take lives. Rigorous testing and boundary checking are essential.
-->
---

### Concept Check: The Software Crisis (CCQ 1)
<!-- id: ase-ch01-ccq1 -->
<div class="ccq-columns">
  <div class="ccq-text">

**Why couldn't the 1968 Software Crisis be resolved simply by purchasing faster computer hardware or larger memory?**

- **A.** Computer hardware manufacturing and memory fabrication completely stagnated in the late 1960s, preventing computational speedups.
- **B.** The crisis was fundamentally an intellectual and organizational challenge of system complexity, which faster hardware only amplified.
- **C.** Programming languages of that era strictly lacked mathematical calculation primitives and compiler memory allocation capabilities.
- **D.** Early mainframe computers were physically incompatible with shared telecommunication networks and multi-terminal architectures.

  </div>
  <div class="ccq-logo">
    <a href="https://nlhsueh.github.io/nickedupocket/#/student/ase-ch01-ccq1" target="_blank"><img src="../../img/ch01/ase-ch01-ccq1.png" alt="QR Code" /></a>
  </div>
</div>

<!--
**Let's move ahead to the next slide.**

**Alright, it's time for our first Concept Check Question! Please take out your phone, scan the QR code on the screen, and submit your answer.**

Question: Why couldn't the 1968 Software Crisis be resolved simply by purchasing faster computer hardware or larger memory?

Take a look at options A, B, C, and D:
- A says hardware fabrication stopped in the 1960s.
- B says the crisis was an intellectual challenge of complexity, which faster hardware only amplified.
- C says programming languages lacked mathematical calculations.
- D says mainframes couldn't connect to networks.

Go ahead and submit your vote!

*(Explanation: The crisis was not about hardware speed. It was about the limits of the human mind. Faster hardware allowed bigger systems, and without engineering methods, system complexity exploded.)*

**To wrap up this slide, here is the key takeaway to remember:** System complexity is a human cognitive challenge. Faster hardware without engineering discipline only creates bigger bugs.
-->
---

## We need Engineering method to develop Software
* What is **Software** ?
* What is **Engineering** ?
* What is **Software Engineering** ?

<!--
**Now, moving on to the next slide...**

To solve the software crisis, we must answer three fundamental questions: What is Software? What is Engineering? And what is Software Engineering?

Beginners often think software is just lines of code in a text editor.

If the script runs on localhost, they think the job is finished.

However, professional engineering recognizes that source code is only a small part of a complete system.

Engineering gives us the methods, testing, and architecture needed to build software that lasts.

**To wrap up this slide, here is the key takeaway to remember:** Engineering methods turn a simple script into a reliable, long-lasting production system.
-->
---
<!-- _class: lead -->
<!-- header: '1.3 What is Software?' -->

# **1.3 What is Software?**

> "Source code is only the tip of the software iceberg. Programs, data, documentation, and configuration together breathe life into a system."

<!--
Now we begin Module 1.3: What is Software? Beyond Source Code.

A pervasive beginner misconception is equating software with raw lines of code. In professional practice, source code represents only a fraction of the total intellectual asset.

According to the IEEE standard, software comprises four indispensable pillars: executable programs, data structures, comprehensive documentation, and operating procedures.

To summarize this slide, remember this key takeaway: Professional software is a complete, multi-faceted operational asset, not merely an isolated pile of source code.
-->
---

## The IEEE Anatomy of Software

> **Software (IEEE Standard):** Computer programs, procedures, and possibly associated documentation and data pertaining to the operation of a computer system.

* **1. Programs:** Executable binaries and source code files (Python, Java, C++, TypeScript).
* **2. Data & Schemas:** Database tables, config files, AI weights (e.g. Knight Capital's config error).
* **3. Operational Procedures:** Deployment scripts, backups, recovery runbooks (e.g. GitLab's backup failure).
* **4. Documentation:** Architecture ADDs, API specs (OpenAPI), user guides (e.g. Therac-25 undocumented bugs).

<!--
**Next up, let's look at the official definition.**

The IEEE standard defines software with this exact definition:
*"Computer programs, procedures, and possibly associated documentation and data."*

Look at what happens when teams ignore the other three pillars:
* If you have code but no **data migration rules**, you will corrupt user databases.
* If you have code but no **deployment procedures**, you will take down production servers—just like Knight Capital lost 440 million dollars in 45 minutes due to a deployment mistake!
* If you have code but no **documentation**, no one else can maintain or fix the system when you leave.

Professional software engineering means taking care of all four elements.

**To wrap up this slide, here is the key takeaway to remember:** Professional engineering delivers working code, clean data models, reliable deployment procedures, and clear documentation.
-->
---

## The Software Iceberg Trap: Beyond Raw Source Code

* **The Amateur Fallacy:**
  - Novices and shortsighted managers treat software as merely the visible tip—**Programs (Source Code)**—measuring progress solely by lines of code written.
* **The Hidden Reality (80%+ Below the Surface):**
  - In production systems, over **80% of effort, complexity, and catastrophic failures** reside below the surface in Data, Procedures, and Documentation:
    - *Knight Capital ($440M lost in 45 min):* Core code was fine, but a flawed deployment **procedure** and config **data** caused bankruptcy.
    - *GitLab Database Outage:* Production binaries worked, but disaster recovery **procedures** were untested.
    - *Therac-25:* Inadequate architectural **documentation** concealed lethal concurrency bugs.
* *Without all four pillars, a system is not "engineered software"—it is merely a brittle program.*

<!--
**Turning to the next slide here...**

Here is a classic analogy: think of software as an iceberg in the ocean.

Above the water, you see the visible tip. That represents the lines of source code developers write.

Amateur developers and non-technical managers only look at the tip. They ask: *"How many lines of code did you write today?"*

But look beneath the water. Over 80% of the effort and risk lives below the surface:
* Security, performance, and scalability.
* Automated testing and regression suites.
* Database backups and disaster recovery.
* Clear architectural contracts.

If you only focus on the tip, your project will hit the hidden mass and capsize.

**To wrap up this slide, here is the key takeaway to remember:** Source code is only the visible tip of the iceberg. Real engineering happens beneath the surface in testing, data, and operations.
-->
---

## Why the Four Pillars Demand the Software Life Cycle (SDLC)

> **The Core Epiphany:** **Programming** is writing code in an afternoon. **Software Engineering** is governing all four pillars across the entire **Software Life Cycle (SDLC)**.

* **1. Documentation $\longleft→ Requirements & Architectural Design:**
  - Code only records *how*, but documentation (ADRs, OpenAPI, specs) captures *why*. Without architectural contracts, multi-year team collaboration and system evolution are impossible.
* **2. Programs $\longleft→ Implementation & Automated Verification:**
  - Writing code is only one brief phase. Software engineering mandates continuous unit testing, CI/CD verification, and refactoring to prevent code rot and technical debt.
* **3. Data & Schemas $\longleft→ State Persistence & Long-Term Evolution:**
  - Code changes in seconds, but data lives for decades. The lifecycle requires strict schema versioning, backward compatibility, and database migration engineering.
* **4. Procedures $\longleft→ DevOps, Deployment & Site Reliability (SRE):**
  - Code on `localhost` is a toy. Engineering requires automated deployment pipelines, canary rollouts, disaster recovery runbooks, and telemetry monitoring.

<!--
**Alright, let's advance to the next slide.**

Here is the key epiphany of this section:
**Programming** is writing code in an afternoon.
**Software Engineering** is managing all four pillars across the entire software lifecycle.

Notice how the four pillars connect directly to the lifecycle:
* **Documentation** connects to Requirements and Architecture. Code tells you *how*, but documents tell you *why*.
* **Programs** connect to Implementation and Testing. We need automated tests to ensure code stays healthy.
* **Data** connects to Long-Term Storage. Code changes every week, but data lives for decades.
* **Procedures** connect to DevOps and Site Reliability. Code running on your localhost is just a toy; procedures make it run in production.

**To wrap up this slide, here is the key takeaway to remember:** The Software Development Life Cycle ensures that code, data, procedures, and documentation evolve safely together over years.
-->
---

## Why the 4 Pillars Matter: The YouBike Example

* **1. Programs (Execution Engines):**
  - *Embedded lock firmware, mobile apps, and cloud backend microservices.*
  - Execute real-time lock/unlock protocols, GPS tracking, and concurrent user requests reliably.
* **2. Data & Schemas (Single Source of Truth):**
  - *Bike locations, dock availability, user account balances, and ACID rental logs.*
  - Data corruption or unsynced records cause "ghost bikes", erroneous billing, and lost revenue.
* **3. Operational Procedures (System Resilience):**
  - *firmware updates, dock rebalancing logistics, payment failover, and battery triage.*
  - A flawed OTA deployment bricks thousands of street locks, requiring costly physical field servicing.
* **4. Documentation (Collaboration Contracts):**
  - *OpenAPI specs, MQTT telemetry protocols, and hardware-software interface contracts.*
  - Prevents integration breakdowns among hardware vendors, mobile teams, and municipal transit.

<!--
**Now, let's look at a concrete real-world example.**

Let's look at the YouBike bike-sharing system here in Taiwan. Why do the four pillars matter here?

First, look at **Programs**:
You have embedded firmware inside the bike's smart lock, mobile apps on rider phones, and cloud microservices processing rentals.

Second, look at **Data**:
You have real-time GPS locations, dock vacancies, rider account balances, and payment records. If this data goes out of sync, you get "ghost bikes" and angry users.

Third, look at **Procedures**:
How do trucks rebalance bikes across stations? How do engineers push firmware updates over the air without bricking thousands of locks? Those are operational procedures.

And fourth, **Documentation**:
OpenAPI specs and communication protocols allow hardware vendors, app developers, and city transit to work together smoothly.

If YouBike only had app source code without these procedures and data pipelines, the entire system would fail in hours.

**To wrap up this slide, here is the key takeaway to remember:** Real-world systems like YouBike succeed because code, data, logistics, and documentation work together seamlessly.
-->
---

### Concept Check: The Software Definition (CCQ 2)
<!-- id: ase-ch01-ccq2 -->
<div class="ccq-columns">
  <div class="ccq-text">

**According to the IEEE standard definition of software, which of the following is NOT considered a component of software?**

- **A.** Executable computer programs and source code files.
- **B.** System database schemas and configuration files.
- **C.** CPU processor hardware and physical memory units.
- **D.** Software installation and deployment procedures.

  </div>
  <div class="ccq-logo">
    <a href="https://nlhsueh.github.io/nickedupocket/#/student/ase-ch01-ccq2" target="_blank"><img src="../../img/ch01/ase-ch01-ccq2.png" alt="QR Code" /></a>
  </div>
</div>

<!--
**Moving right along to our next slide...**

**Time for our second Concept Check Question! Please scan the QR code on the screen and submit your vote.**

Question: According to the IEEE standard definition of software, which of the following is NOT considered a component of software?

Let's read the choices:
- A: Executable computer programs and source code files.
- B: System database schemas and configuration files.
- C: CPU processor hardware and physical memory units.
- D: Software installation and deployment procedures.

Think about what we just covered: programs, data, procedures, and documentation. Which one is physical hardware?

Go ahead and submit your answer!

*(Explanation: The correct choice is C. Silicon chips, CPUs, and RAM are physical hardware. Software represents the intangible instructions, data, procedures, and documents that run on the hardware.)*

**To wrap up this slide, here is the key takeaway to remember:** Hardware is the physical engine, while software is the intellectual asset of programs, data, procedures, and documents.
-->
---
<!-- _class: lead -->
<!-- header: '1.4 What is Engineering?' -->

# **1.4 What is Engineering?**

> "Scientists discover the world that exists; engineers create the world that never was."  
> — *Theodore von Kármán*

<!--
Welcome to Module 1.4: What is Engineering? Constraints, Resources, and Pragmatic Optimization.

What elevates a programmer into an engineer? Scientists seek pure theoretical truth regardless of cost. Engineers, by contrast, solve real-world problems under severe constraints of time, money, manpower, and physical reality.

In this section, we examine the fundamental engineering equation: delivering pragmatic, cost-effective solutions while balancing inevitable real-world trade-offs.

To summarize this slide, remember this key takeaway: Engineering is the disciplined art of pragmatic optimization under real-world constraints.
-->
---
<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch01/05_what_is_engineering.png" alt="The Nature of Engineering: From Science to Useful Artifacts" />
</div>

<!--
**Let's transition to the next slide.**

Look at this diagram comparing science and engineering.

What is the difference between a scientist and an engineer?
* **Scientists** study the world as it is. They discover natural laws, like physics and chemistry.
* **Engineers** create things that never existed before. We build airplanes, bridges, and software to solve concrete human problems.

Scientists seek the truth; engineers make things work in the real world.

**To wrap up this slide, here is the key takeaway to remember:** Scientists discover the world that exists. Engineers build the world that solves real problems.
-->
---
<!-- header: '1.4 What is Engineering?' -->

## What is Engineering?

> **Engineering:** The creative application of scientific principles, empirical methods, and practical experience to invent, design, and construct useful artifacts under **real-world constraints** with **finite resources**.

* **Three Core Hallmarks of Professional Engineering:**
  - **1. Systematic:** Following structured, repeatable processes and methodologies rather than ad-hoc trial and error.
  - **2. Disciplined:** Adhering strictly to industry standards, rigorous peer reviews, and safety margins.
  - **3. Quantifiable & Measurable:** Evaluating success and stability through empirical metrics (latency, reliability, test coverage, uptime).
* **Engineering Under Constraints:**
  - Engineering is never done in an ideal vacuum—it is the art of **constrained optimization**, balancing goals against finite time, budget, and resources.

<!--
**Shifting our attention to the next slide...**

Now, what is the formal definition of engineering?

Engineering means creatively applying scientific principles, empirical methods, and practical experience to design and construct useful systems under real-world constraints and with finite resources.

Professional engineering has three key hallmarks:
1. **Systematic**: We follow clear, structured, and repeatable processes—not random trial and error.
2. **Disciplined**: We adhere to industry standards, code reviews, and safety protocols.
3. **Quantifiable**: We measure everything with numbers—latency, memory footprint, uptime, and test coverage.

Engineering is never done in an ideal vacuum; it is always about constrained optimization. Without discipline and numbers, development is just guessing. Engineering turns guessing into predictable science.

**To wrap up this slide, here is the key takeaway to remember:** Engineering replaces guesswork with measurable metrics, standards, and repeatable processes under real-world constraints.
-->
---

## The Engineering Equation: Constraints vs. Resources

* **Constraints (The Limitations):**
  - **Time:** Hard deadlines, release windows.
  - **Budget:** Developer salaries, cloud hosting bills, license fees.
  - **Technology & Platform:** Legacy databases, mobile OS limits.
  - **Regulations:** GDPR data privacy, HIPAA, PCI-DSS.
* **Resources (The Assets):**
  - **Human:** Developer skill, QA engineers, UX designers.
  - **Tools & Infrastructure:** Cloud compute, CI/CD pipelines, open-source libraries.
  - **Domain Knowledge:** Understanding user workflows and business logic.

<!--
**Let's move ahead to the next slide.**

Here is the golden rule: engineering never happens in a vacuum.

Every project is a balancing act between **Constraints** and **Resources**.

On one side, you have strict **Constraints**:
* Deadlines (Time)
* Budgets (Money)
* Regulations like GDPR or HIPAA
* Non-negotiable safety standards

On the other side, you have limited **Resources**:
* How many developers are on your team?
* What tools, libraries, and cloud servers can you afford?

A great engineer does not aim for impossible academic perfection. A great engineer finds the best practical solution within these limits.

**To wrap up this slide, here is the key takeaway to remember:** Engineering is the art of delivering high quality within the real limits of time, money, and team capacity.
-->
---

## Case Study: Healthcare Startup MVP (Minimun Viable Product)

* **Problem:** Launch a HIPAA-compliant telemedicine app in 6 months on a tight $80k budget.
* **The Engineering Balancing Solution:**
  1. **Scope Prioritization:** Focus MVP strictly on video consults and booking; postpone insurance billing.
  2. **Cross-Platform Tooling:** Use Flutter/React Native for a single codebase (saves 40% effort).
  3. **Managed Backend:** Use HIPAA-compliant cloud BaaS instead of bare-metal servers.
  4. **Automated CI/CD:** unit tests on PRs, keeping QA overhead low.
* **Why Not "Perfect" Technical Solutions?**
  - Custom native apps and custom microservices are technically superior, but rejected because they violate constraints ($80k budget, 6 months).
  - **Satisficing:** Find the solution that meets all constraints through pragmatic trade-offs.
  - **The Engineering Imperative:** We need **Requirements Engineering** to negotiate scope against finite budgets, and **System Design** to negotiate trade-offs that satisfy real-world constraints.

<!--
**Now, moving on to the next slide...**

Let's look at a realistic case study: a telemedicine startup.

Imagine you have 3 engineers and 4 months of cash runway to launch an app.

Here are two different mindsets:
* **The Academic Approach**: You spend 8 months writing a complex microservices architecture from scratch. What happens? You run out of money, and the company goes bankrupt before launching.
* **The Engineering Approach**: You build a clean, simple modular monolith. You use proven cloud services and ready-made video APIs like Twilio. You test patient data security thoroughly. Result? You launch in 3.5 months, gain users, and secure funding.

Good engineering means picking the right tools to solve the business problem on time.

**To wrap up this slide, here is the key takeaway to remember:** Pragmatic engineers use proven, reliable tools to meet deadlines instead of over-engineering from scratch.
-->
---
<!-- _class: lead -->
<!-- header: '1.5 What is Software Engineering?' -->

# **1.5 What is Software Engineering?**

> "Software engineering is programming integrated over time, with teams, under changing constraints."  
> — *Titus Winters (Software Engineering at Google)*

<!--
We now arrive at our core disciplinary definition, Module 1.5: What is Software Engineering?

As Google's engineering leadership famously formulated: programming is writing code, but software engineering is making code survive for decades across evolving teams, changing libraries, and shifting business requirements.

We explore the four universal core activities—Specification, Development, Validation, and Evolution—and the foundational Body of Knowledge (BOK) governing them.

To summarize this slide, remember this key takeaway: Software engineering manages complexity across time, scale, and organizational change.
-->
---
<!-- header: '1.5 What is Software Engineering?' -->
<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch01/coding_vs_se_loc_bw.png" alt="Coding vs Software Engineering" />
</div>

<!--
**Let's flip over to the next slide.**

Look at this comparison: Solo Coding versus Enterprise Software Engineering.

When you code a personal hobby project:
* You code alone on your laptop.
* You hold the whole architecture in your head.
* If there is a bug, you fix it yourself. Nobody else is affected.

Now, look at Enterprise Software Engineering:
* You have a team of 50 developers across different time zones.
* The codebase has 2 million lines of code.
* Ten million users rely on it every day.
* New engineers join, senior engineers leave, but the system must never go down!

That is why we need software engineering disciplines: to help teams build software that outlives any single developer.

**To wrap up this slide, here is the key takeaway to remember:** Coding is writing lines of code; Software Engineering is building systems that scale across teams, users, and years.
-->
---

## What is Software Engineering?

> **Software Engineering (IEEE 610.12):** The application of a systematic, disciplined, quantifiable approach to the development, operation, and maintenance of software; that is, the application of engineering to software.

* **1. Engineering Discipline (Systematic, Disciplined, Quantifiable):**
  - Applies scientific rigor, engineering standards, and empirical metrics rather than ad-hoc craftsmanship.
* **2. Full Lifecycle Scope (Development, Operation, Maintenance):**
  - **Development:** Initial specification, architectural design, coding, and quality verification.
  - **Operation & Maintenance:** Ensuring 24/7 runtime stability, performance optimization, and long-term system evolution.

<!--
**Next up, let's look at the official IEEE definition.**

The IEEE standard defines Software Engineering as:
*"The application of a systematic, disciplined, quantifiable approach to the development, operation, and maintenance of software."*

Notice three key phases here:
* **Development**: writing the initial software.
* **Operation**: keeping the system running 24/7.
* **Maintenance**: updating and fixing it over years.

Good engineering covers all three. Building the system is only the first chapter!

**To wrap up this slide, here is the key takeaway to remember:** Software engineering is not just about building code; it is about operating and maintaining systems over their entire lifetime.
-->
---
<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch01/se_core_activities.png" alt="The Four Core Activities of the Software Engineering Process" />
</div>

<!--
**Turning to the next slide here...**

Now, take a look at this diagram on the screen.

No matter what process you use—Waterfall, Scrum, or modern CI/CD—every software project always comes down to these four basic activities:

First, we have **Software Specification**.
Before writing any code, we must ask: What should the system do? What are the constraints? In this step, we talk to users and write down clear requirements.

Second is **Software Design and Implementation**.
Here, we first plan the system architecture. Then, we write the actual code and turn designs into working programs.

Third comes **Software Validation**.
This is where testing happens. We check: Does the software do what the customer asked for? Are there any bugs? We verify that the system works correctly.

And fourth, we have **Software Evolution**.
Software is never finished on day one. Once the system goes live, business needs change, bugs appear, and we must update and maintain the code.

**To wrap up this slide, here is the key takeaway to remember:** Every development model—from Waterfall to Agile—is just a different way of organizing these four basic steps.
-->
---

## Activity 1: Software Specification

> **Defining what the system must do and the constraints under which it must operate.**

* **Core Mission:**
  - Discover, negotiate, and establish user needs and system boundaries before building.
* **Key Lifecycle Sub-Activities:**
  - **Feasibility Study:** Is the project technically and economically viable?
  - **Requirements Elicitation & Analysis:** Discovering what stakeholders actually need.
  - **Specification & Validation:** Documenting requirements into testable, unambiguous contracts.
* **Key Artifacts:** User Stories, Acceptance Criteria (Given-When-Then), SRS, Use Cases.
* **The High-Stakes Risk:**
  - Building the wrong product! A requirement defect caught in production costs **up to 100x more** to resolve than if caught during specification.

<!--
**Alright, let's look closer at Activity 1: Specification.**

Specification answers one fundamental question:
*"What should the system do, and under what constraints?"*

In this phase, we do three things:
* We talk to users to discover their real needs.
* We write down clear use cases, user stories, and API contracts.
* We verify that the requirements make sense and are realistic.

Here is a painful truth: a specification bug is the most expensive mistake in software.
If you build the wrong feature, even the most beautiful code is completely useless!

**To wrap up this slide, here is the key takeaway to remember:** Specification defines what success looks like. Building the wrong product perfectly is the biggest waste of engineering effort.
-->
---

## Activity 2: Software Design & Implementation

> **Translating requirements into executable software structures and source code.**

* **Core Mission:**
  - Transform abstract specifications into robust, maintainable, and high-performance software.
* **Key Lifecycle Sub-Activities:**
  - **Architectural Design:** Defining overall system structure, services, and subsystems.
  - **Interface & Data Modeling:** Establishing modular API contracts and database schemas.
  - **Component Design & Coding:** Writing clean, testable logic, algorithms, and modules.
* **Key Artifacts:** Architecture Decision Records (ADRs), ERDs, OpenAPI Specs, Clean Code.
* **The High-Stakes Risk:**
  - Spaghetti architecture, tight coupling, and runaway technical debt that make future modifications prohibitively expensive.

<!--
**Now, let's move to Activity 2: Design and Implementation.**

This is where ideas turn into working software.

First comes **Design**:
We choose the high-level architecture. Should we use microservices or a modular monolith? How should database tables be structured?

Second comes **Implementation**:
Developers write clean, readable code using proven design patterns like SOLID.

Good design keeps modules loosely coupled. That way, when you change one feature tomorrow, you won't accidentally break the rest of the system!

**To wrap up this slide, here is the key takeaway to remember:** Good software design ensures that future changes only require small, local edits rather than complete system rewrites.
-->
---

## Activity 3: Software Validation

> **Checking that the software conforms to its specification and satisfies customer needs.**

* **The Twin Pillars of Quality (Boehm):**
  - **Verification:** *"Are we building the product right?"* (Conforming strictly to specification).
  - **Validation:** *"Are we building the right product?"* (Meeting real customer intent).
* **Key Lifecycle Sub-Activities:**
  - **Unit & Component Testing:** Isolating modules and verifying boundary behaviors.
  - **Integration & System Testing:** Verifying inter-service contracts and end-to-end flows.
  - **Acceptance Testing & Code Review:** Peer review audits and user sign-off.
* **Key Artifacts:** Automated Test Suites (PyTest, JUnit), CI Pipeline Reports, Coverage Metrics.
* **The High-Stakes Risk:**
  - Critical production outages, catastrophic security breaches, data loss, and legal liability.

<!--
**Moving right along to Activity 3: Software Validation.**

Validation answers two famous questions proposed by Barry Boehm:
* **Verification**: *"Are we building the product right?"* (Does our code pass tests, compile without errors, and follow the spec?)
* **Validation**: *"Are we building the right product?"* (Does this software actually solve the customer's real problem?)

Testing cannot prove that code has zero bugs. But automated tests—unit tests, integration tests, and end-to-end tests—give us confidence that our system behaves correctly.

**To wrap up this slide, here is the key takeaway to remember:** Verification checks if your code meets specifications; Validation checks if your software solves real customer problems.
-->
---

## Activity 4: Software Evolution

> **Modifying and adapting deployed software to meet changing business and user needs.**

* **The Reality of Software Economics:**
  - Real-world software is never "done." Over **60%–80% of total lifecycle cost** occurs in Evolution after initial launch!
* **The Four Modes of Maintenance:**
  - **Corrective:** Fixing latent defects, crash bugs, and edge cases in production.
  - **Adaptive:** Migrating to new cloud runtimes, mobile OS updates, or changing regulations.
  - **Perfective:** Improving throughput, latency, UX responsiveness, and adding new features.
  - **Preventive:** Continuous refactoring to eradicate technical debt before failures occur.
* **Key Artifacts:** Database Migration Scripts, Release Notes, Incident Post-Mortems.

<!--
**Let's transition to Activity 4: Evolution.**

Software is never static like a concrete building. It is a living system.

In fact, studies show that 60% to 80% of all software costs happen *after* the initial release!

Why does software evolve?
* **Fixing bugs**: resolving issues found in production.
* **Adapting**: moving to new cloud platforms, updated OS versions, or new APIs.
* **Refactoring**: cleaning up messy code to keep performance high.
* **Preventing debt**: fixing weak architecture before it causes an outage.

According to Lehman's Laws: if a software system does not evolve, it becomes less and less useful until it dies.

**To wrap up this slide, here is the key takeaway to remember:** Most software engineering is not starting from scratch; it is the continuous improvement and refactoring of living systems.
-->
---

### Concept Check: Core Activities (CCQ 3)
<!-- id: ase-ch01-ccq3 -->
<div class="ccq-columns">
  <div class="ccq-text">

**Which of the following pairs correctly matches a specific software engineering action with its corresponding universal core activity?**

- **A.** Conducting stakeholder interviews to draft user stories → Software Specification
- **B.** Writing automated unit tests to mock database responses → Software Design & Implementation
- **C.** Refactoring database schemas to improve query speed → Software Validation
- **D.** Swapping a third-party payment API for a new gateway → Software Specification

  </div>
  <div class="ccq-logo">
    <a href="https://nlhsueh.github.io/nickedupocket/#/student/ase-ch01-ccq3" target="_blank"><img src="../../img/ch01/ase-ch01-ccq3.png" alt="QR Code" /></a>
  </div>
</div>

<!--
**Shifting our attention to the next slide...**

**Time for our third Concept Check Question! Please scan the QR code on the screen and submit your answer.**

Question: Which of the following pairs correctly matches an action with its core activity?

Let's read the choices:
- A: Conducting user interviews to write user stories → Software Specification
- B: Writing unit tests → Software Design & Implementation
- C: Refactoring database schemas → Software Validation
- D: Swapping a payment API → Software Specification

Think about our four steps: Specification, Design & Code, Validation, and Evolution. Where do user interviews belong?

Submit your vote now!

*(Explanation: The correct answer is A. Interviewing stakeholders to gather requirements is the definition of Specification. Writing tests is Validation, and refactoring schemas is Evolution.)*

**To wrap up this slide, here is the key takeaway to remember:** Understanding the four activities helps you organize your daily tasks and apply the right testing to every step.
-->
---
<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch01/se_elements_infographic.png" alt="Core Elements of Software Engineering" />
</div>

<!--
SKIPPED

Look at this pillars on the screen. It shows the foundation of professional software engineering:

At the bottom is the bedrock: **Principles**.
These are timeless truths, like abstraction, encapsulation, and separation of concerns.

In the middle are **Methods**:
These are structured ways of working, like Agile, Scrum, Test-Driven Development (TDD), and CI/CD.

At the top are **Tools**:
These are specific tools we use today, like Git, Docker, and GitHub Actions.

Tools come and go every few years. But core principles stay relevant for your entire career!

**To wrap up this slide, here is the key takeaway to remember:** Tools change fast, but foundational software principles and disciplined methods last a lifetime.
-->
---

## The Software Engineering Body of Knowledge (BOK)

* Software Engineering is defined by a structured **Body of Knowledge (BOK)**—a system of proven **engineering heuristics** and principles designed to conquer complexity:
  - **Disciplines (Rules of Practice):** Mandatory professional habits and operational protocols (*"Spec before design", "Design before code", Architecture Decision Records, Code reviews*).
  - **Principles (Foundations):** Timeless, enduring engineering truths (*Abstraction, Modularity, Separation of Concerns, Anticipation of Change*).
  - **Methods & Methodologies:** Structured, repeatable process frameworks (*Agile/Scrum, Extreme Programming, TDD, CI/CD pipelines, DevOps*).
  - **Heuristics & Guidelines:** Practical rules of thumb and design heuristics distilled from decades of field experience (*SOLID, Clean Code, KISS, DRY, YAGNI, POLA*).

<!--
In addition to the activities, software engineering is also grounded in a structured Body of Knowledge—a battle-tested collection of principles and heuristics designed to tame scale and complexity.

Here I introduce 4 of them:

First are **Disciplines**: these are mandatory professional habits and operational protocols—such as *"specifications before design"*, *"design before coding"*, and conducting rigorous peer code reviews.

Second are **Principles**: the enduring, foundational truths of software systems—such as abstraction, modularity, and separation of concerns.

Third are **Methods and Methodologies**: structured, repeatable process frameworks that teams execute, such as Agile Scrum, Extreme Programming, Test-Driven Development, and CI/CD pipelines.

And fourth are **Heuristics and Guidelines**: practical rules of thumb distilled from decades of industry practice, including SOLID design principles, Clean Code, KISS, DRY, and YAGNI.

Together, these four layers elevate software creation from ad-hoc programming into a true engineering discipline.

**To wrap up this slide, here is the key takeaway to remember:** The Body of Knowledge provides disciplines, principles, methods, and heuristics to conquer software complexity.
-->
---

## Applying the Body of Knowledge to the 4 Core Activities

* The Body of Knowledge is not abstract theory—it directly anchors each of the **Four Universal Lifecycle Activities**:
* **1. Specification (Requirements):**
  - *Disciplines & Principles:* **"Spec before design"**, Abstraction, Separation of Concerns.
  - *Heuristics:* **YAGNI** (prevent speculative features), unambiguous acceptance criteria.
* **2. Design & Implementation:**
  - *Disciplines & Principles:* **"Design before code"**, Modularity, Information Hiding, ADRs.
  - *Heuristics:* **SOLID principles**, Clean Architecture, GoF patterns, **DRY**, **KISS**.
* **3. Validation (Testing):**
  - *Disciplines & Principles:* **TDD**, independent verification, mandatory Peer Code Reviews.
  - *Heuristics:* Boundary value testing, defense-in-depth, automated regression safety nets.
* **4. Evolution (Maintenance):**
  - *Disciplines & Principles:* **Anticipation of Change**, Semantic Versioning, Technical Debt tracking.
  - *Heuristics:* **The Boy Scout Rule** (*leave code cleaner than you found it*), zero-downtime rollouts.

<!--
**Let's flip over to the next slide.**

Notice how the SWEBOK knowledge areas map directly onto our four core activities:
* For **Specification**, we use Requirements Engineering and use-case modeling.
* For **Design and Implementation**, we use Software Architecture and clean coding standards.
* For **Validation**, we use black-box testing, white-box testing, and coverage tools.
* For **Evolution**, we use Git version control, semantic versioning, and refactoring techniques.

This turns computer science theory into daily, practical engineering habits.

**To wrap up this slide, here is the key takeaway to remember:** The Body of Knowledge gives us concrete, battle-tested practices for every phase of the software process.
-->
---

## Why Principles Matter

> **When engineering principles are ignored, intuition leads to expensive fallacies.**

* **Myth 1: "We're behind schedule—let's add 5 developers to catch up."**
  - *Violates:* **Modularity & Communication Boundaries**.
  - *Reality (Brooks's Law):* Adding manpower to a late project makes it later due to $O(n^2)$ communication overhead.
* **Myth 2: "Software is digital, so changing requirements late is cheap."**
  - *Violates:* **"Spec Before Design" & Architectural Coupling**.
  - *Reality:* Late changes invalidate schemas, API contracts, and tests, costing **up to 100x more**.
* **Myth 3: "Outsource the coding and we don't need technical management."**
  - *Violates:* **The Software Iceberg (Data, Procedures, Docs)**.
  - *Reality:* Raw code without architectural governance creates unmaintainable software debt.

<!--
**Next up, let's look at four dangerous myths in software.**

When teams forget engineering principles, they fall into these common traps:

**Myth 1:** *"If we are behind schedule, just add more programmers."*
Wrong! Brooks's Law proves that adding people to a late project makes it even later.

**Myth 2:** *"Software is easy to change because code has no physical weight."*
Wrong! Uncontrolled changes cause hidden ripples and break existing features.

**Myth 3:** *"We don't need detailed requirements; we can just start coding."*
Wrong! Vague requirements lead to building the wrong product, causing 100 times more rework.

**Myth 4:** *"Once the code compiles and tests pass, our job is done."*
Wrong! Over 80% of costs happen during operations, scaling, and maintenance.

**To wrap up this slide, here is the key takeaway to remember:** Knowing these software engineering truths protects your team from budget disasters and broken schedules.
-->
---
<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch01/late_change_cost_comic.png" alt="Late Requirement Change Cost Comic" />
</div>

<!--
**Turning to the next slide here...**

Take a look at this famous curve on the screen.

It shows one of the most important economic rules in software engineering:
**The later you find a bug, the more expensive it is to fix.**

Let's look at the numbers:
* Finding a requirement bug during **Specification** costs 1 dollar—you just change a line in a document.
* If you catch it during **Design**, it costs 5 dollars.
* If you catch it during **Coding**, it costs 10 dollars.
* If you catch it during **System Testing**, it costs 50 dollars.
* But if that bug reaches **Production**, it costs 100 to 1000 times more! You have to push emergency patches, restore lost data, and face angry customers.

That is why we test early and review requirements carefully!

**To wrap up this slide, here is the key takeaway to remember:** Catching bugs early saves massive amounts of time and money. Prevention is always cheaper than emergency repairs.
-->
---

### Concept Check: Brooks's Law (CCQ 4)
<!-- id: ase-ch01-ccq4 -->
<div class="ccq-columns">
  <div class="ccq-text">

**A project is 3 weeks behind schedule with 2 weeks remaining before release. The manager hires 4 junior programmers to speed up progress. What will happen according to Brooks's Law?**

- **A.** The project will finish 1 week early.
- **B.** The project will be delayed further because senior engineers must spend time onboarding and mentoring new hires.
- **C.** The existing developers will code twice as fast.
- **D.** Communication complexity remains unchanged.

  </div>
  <div class="ccq-logo">
    <a href="https://nlhsueh.github.io/nickedupocket/#/student/ase-ch01-ccq4" target="_blank"><img src="../../img/ch01/ase-ch01-ccq4.png" alt="QR Code" /></a>
  </div>
</div>

<!--
**Alright, let's advance to the next slide.**

**Time for our fourth Concept Check Question! Please scan the QR code on the screen and submit your vote.**

Question: A project is 3 weeks behind schedule with only 2 weeks left. The manager hires 4 junior programmers to speed things up. What will happen according to Brooks's Law?

Let's read the options:
- A: The project finishes 1 week early.
- B: The project is delayed even more, because senior developers must spend time training the new hires.
- C: Developers code twice as fast.
- D: Communication overhead stays the same.

Think about communication overhead and training time. Go ahead and vote!

*(Explanation: The correct answer is B. In The Mythical Man-Month, Fred Brooks explained: adding people to a late project makes it later! New people need training, which pulls senior engineers away from real work.)*

**To wrap up this slide, here is the key takeaway to remember:** Adding people to a late project makes it later. Managing scope is the only real solution.
-->
---

### Concept Check: Design Principles (CCQ 5)
<!-- id: ase-ch01-ccq5 -->
<div class="ccq-columns">
  <div class="ccq-text">

**An order-processing module directly handles HTTP requests, executes payment transactions, queries the SQL database, and generates HTML receipt emails. Which fundamental design principle is most severely violated?**

- **A.** Separation of Concerns: Multiple distinct responsibilities are tightly tangled in a single module.
- **B.** YAGNI: Speculative future features are implemented before actual business requirements emerge.
- **C.** Brooks's Law: Adding developers to the order module increases communication complexity exponentially.
- **D.** Anticipation of Change: System configurations are hardcoded into compiled production binaries.

  </div>
  <div class="ccq-logo">
    <a href="https://nlhsueh.github.io/nickedupocket/#/student/ase-ch01-ccq5" target="_blank"><img src="../../img/ch01/ase-ch01-ccq5.png" alt="QR Code" /></a>
  </div>
</div>

<!--
**Now, let's look at the next page.**

**Time for our fifth Concept Check Question! Please scan the QR code on the screen and submit your answer.**

Question: An order module handles HTTP requests, processes credit card payments, queries the SQL database, and sends receipt emails. Which design principle is most severely violated?

Let's read the choices:
- A: Separation of Concerns (Single Responsibility Principle)
- B: YAGNI (You Aren't Gonna Need It)
- C: Brooks's Law
- D: Anticipation of Change

Look at all those different jobs packed into one single module: HTTP, payment, database, and emails!

Submit your answer now!

*(Explanation: The correct answer is A. Separation of Concerns says each module should do one job well. Tangling web routes, payments, and databases together creates brittle, fragile code.)*

**To wrap up this slide, here is the key takeaway to remember:** Separation of concerns keeps modules independent, so changing an email template won't break payment processing.
-->
---

## Enforcing Disciplines at Scale: The Modern Toolchain

> **Engineers cannot enforce disciplines by willpower alone—tools automate the BOK.**

* **Version Control (Git) → *Enforces Collaboration & Review*:** Branching models, PR audits, and history.
* **CI/CD Pipelines (GitHub Actions) → *Enforces Continuous Verification*:** Automated build, test, and lint gates.
* **Static Code Analysis (SonarQube) → *Enforces Clean Code & Security*:** Detecting code smells and CVEs.
* **Testing Suites (PyTest, Playwright) → *Enforces Quality Standards*:** Unit, integration, and E2E regression nets.
* **Observability (OpenTelemetry, APM) → *Enforces Evolution Feedback*:** Real-time production telemetry and traces.

<!--
**Moving right along to our next slide...**

Across a team of 50 or 100 developers, you cannot rely on willpower alone to keep code clean.

Modern software engineering uses automated tools as objective gatekeepers:
* **Version Control (Git)**: requires pull requests and peer reviews before code merges.
* **Linters and Static Analysis (ESLint, SonarQube)**: scans code for security flaws and code smells automatically on every commit.
* **Continuous Integration (CI/CD)**: automatically builds and tests code on isolated cloud servers. If tests fail, the build is blocked.
* **Containers (Docker)**: ensures the software runs identically on a developer's laptop and on production servers.

These automated guardrails enforce quality across the entire team 24/7.

**To wrap up this slide, here is the key takeaway to remember:** Automated CI/CD pipelines and static analysis tools act as continuous gatekeepers to protect system quality.
-->
---
<!-- _class: lead -->
<!-- header: '1.6 Software Quality Model' -->

# **1.6 The ISO/IEC 25010 Quality Standard**

> "Quality is value to some person. If a system runs without error but nobody wants it, it has zero quality."  
> — *Jerry Weinberg*

<!--
Welcome to Module 1.6: What is a Software Quality Model? The Modern ISO/IEC 25010 Standard.

How do we measure whether software is 'good'? It is never enough for code to be functionally correct if it is vulnerable to hacking, painfully sluggish, or impossible to maintain.

In this section, we study the modern ISO 25010 product quality standard and explore the eight core quality characteristics and their trade-offs.

To summarize this slide, remember this key takeaway: Quality is multi-dimensional; engineering excellence requires balancing functional capability with non-functional quality attributes.
-->
---
<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch01/iso_25010_subattributes.png" alt="ISO/IEC 25010 Software Product Quality Model" />
</div>

<!--
**Let's transition to the next slide.**

Take a look at this big diagram on the screen.

This is the **ISO 25010** software quality model.

What is software quality? It is not just one fuzzy idea like *"this app feels good."*

The international standard breaks quality into eight clear characteristics:
Functional Suitability, Performance, Compatibility, Usability, Reliability, Security, Maintainability, and Portability.

Each one has measurable attributes to help us evaluate our software.

**To wrap up this slide, here is the key takeaway to remember:** ISO 25010 gives us a shared language and measurable checklist to evaluate software quality.
-->
---
<!-- header: '1.6 Software Quality Model' -->

## What is Quality and Quality Model?

> **Software Quality:** The degree to which a software product satisfies stated and implied needs of its stakeholders under specified conditions.

* **What is Software Quality? (Beyond "No Bugs"):**
  - Novices mistakenly equate quality with *"my code compiles and doesn't crash on my laptop."*
  - True quality is multi-dimensional: software can run without runtime crashes while still being unmaintainable, insecure, horribly slow, or unusable.
  - Encompasses both **External Quality** (user experience, speed, uptime) and **Internal Quality** (code maintainability, modularity, test coverage).
* **What is a Software Quality Model?:**
  - **Structured Multi-Dimensional Taxonomy:** Decomposes abstract "quality" into clear **characteristics**, **sub-characteristics**, and **measurable metrics**.
  - **Concrete Engineering Contract:** Translates ambiguous business wishes (*"make the app fast and secure"*) into testable quantitative targets (*$p99 < 100\text{ms}$, zero high-severity CVEs*).
  - **Guide for Architecture Trade-Offs:** Clarifies which quality attributes take priority (*Safety over Time-to-Market*, or *Portability over Raw Performance*).

<!--
**Shifting our attention to the next slide...**

Software Quality is The degree to which a software product satisfies stated and implied needs of its stakeholders under specified conditions.

Now, what is software quality, and what is a quality model?

Beginners often say: *"My code works and doesn't crash on my laptop, so it has high quality."*

True quality is multi-dimensional: software can run without runtime crashes, while still maintainable, secure, running fast, and usable.

Quality has two essential dimensions:
* **External Quality**: what users experience — responsiveness, reliability, ease of use, and security.
* **Internal Quality**: what engineers experience — clean code, modular architecture, and comprehensive automated tests.

To manage this complexity, we need a **Software Quality Model**. A quality model breaks the fuzzy idea of "quality" down into structured characteristics and measurable metrics. It turns vague client wishes into concrete engineering contracts and guides architectural trade-offs.

-->
---

## The Modern Standard: ISO/IEC 25010 (SQuaRE)

> **ISO/IEC 25010 (Software product Quality Requirements and Evaluation): The internationally recognized benchmark standard for specifying and evaluating software quality.**

* **Key Characteristics & Modern Architecture:**
  - **Comprehensive 8-Characteristic Taxonomy:** Systematically covers Functional Suitability, Performance, Compatibility, Usability, Reliability, Security, Maintainability, and Portability.
  - **First-Class Security:** Elevates Security to an independent, top-tier pillar (Confidentiality, Integrity, Non-repudiation, Accountability, Authenticity).
  - **Emphasis on Compatibility & Interoperability:** Treats multi-platform co-existence and standardized API interoperability as primary requirements in distributed/cloud systems.
* **Dual-Perspective Quality Architecture:**
  - **Product Quality Model:** 8 intrinsic technical characteristics of the system (for developers, architects, and QA engineers).
  - **Quality in Use Model:** Real-world human impact during operation (*Effectiveness, Efficiency, Satisfaction, Freedom from Risk, Context Coverage*).

<!--
SKIPPED

What makes the ISO/IEC 25010 standard the international benchmark for software quality?

First, it establishes a comprehensive eight-characteristic product quality model with concrete sub-attributes, giving engineering teams and stakeholders a precise, shared vocabulary.

Second, it elevates Security to an independent, first-class pillar—requiring confidentiality, integrity, and authenticity from the ground up rather than as an afterthought.

Third, it emphasizes Compatibility and Interoperability, which are vital for today's cloud ecosystems, microservices, and mobile platforms.

Finally, ISO 25010 provides a dual perspective:
* The **Product Quality Model** inspects the internal and external technical properties for developers and QA engineers.
* The **Quality in Use Model** evaluates the real-world operational impact—effectiveness, efficiency, and safety for actual human end-users.

**To wrap up this slide, here is the key takeaway to remember:** ISO 25010 provides a comprehensive, dual-perspective framework to evaluate both internal technical excellence and real-world user impact.
-->
---

## ISO 25010: Product Quality Characteristics (1/2)

* **1. Functional Suitability:** *Functions meet stated and implied user needs.*
  - *Sub-attributes:* **Completeness**, **Correctness**, **Appropriateness**.
* **2. Performance Efficiency:** *Performance relative to the amount of resources used.*
  - *Sub-attributes:* **Time Behaviour** (latency, throughput), **Resource Utilization**, **Capacity**.
* **3. Compatibility:** *Ability to share environments and exchange info without conflict.*
  - *Sub-attributes:* **Co-existence** (clean co-habitation), **Interoperability** (data/API exchange).
* **4. Usability (Interaction Capability):** *Ease with which users achieve goals with satisfaction.*
  - *Sub-attributes:* **Recognizability**, **Learnability**, **Operability**, **Error Protection**, **Aesthetics**, **Accessibility**.

<!--
**Now, moving on to the next slide...**

Let's look at the first four characteristics. These focus on user experience and capability:

1. **Functional Suitability**: Does the software do what users actually need? Is it complete and correct?
2. **Performance Efficiency**: How fast is the system? What is the latency, memory footprint, and CPU usage?
3. **Compatibility**: Can this system exchange data smoothly with other systems?
4. **Usability**: Can a user figure out the interface quickly without getting frustrated or making mistakes?

Even if an app has 100 features, if every button takes 30 seconds to respond, users will delete it!

**To wrap up this slide, here is the key takeaway to remember:** Features mean nothing if the system is too slow to use or too confusing to navigate.
-->
---

## ISO 25010: Product Quality Characteristics (2/2)

* **5. Reliability:** *Ability to maintain a specified level of performance over time.*
  - *Sub-attributes:* **Maturity** (low defect rate), **Availability**, **Fault Tolerance**, **Recoverability**.
* **6. Security:** *Protecting data and systems from unauthorized access or tampering.*
  - *Sub-attributes:* **Confidentiality**, **Integrity**, **Non-repudiation**, **Accountability**, **Authenticity**.
* **7. Maintainability:** *Effectiveness and ease with which software can be evolved and fixed.*
  - *Sub-attributes:* **Modularity**, **Reusability**, **Analyzability**, **Modifiability**, **Testability**.
* **8. Portability (Flexibility):** *Ease with which software is transferred across environments.*
  - *Sub-attributes:* **Adaptability**, **Installability**, **Replaceability**.

<!--
**Let's flip over to the next slide.**

Now, look at the other four characteristics. These form the defensive backbone of enterprise systems:

5. **Reliability**: Does the system stay up? Can it recover automatically when an error happens?
6. **Security**: Does it protect user data from unauthorized access and attacks?
7. **Maintainability**: When a bug is found, can developers find it, fix it, and test it easily?
8. **Portability**: Can this software move smoothly from local Linux machines to cloud Kubernetes clusters?

These four are what keep systems running reliably year after year.

**To wrap up this slide, here is the key takeaway to remember:** Reliability, Security, and Maintainability protect your system from outages, data breaches, and code decay.
-->
---

## ISO 25010 Sub-Attributes: Practical Real-World Scenarios

* **Fault Tolerance (Reliability):** Primary payment gateway times out → system retries with backup gateway without dropping the customer transaction.
* **Integrity & Authenticity (Security):** JWT authorization tokens cryptographically signed with RS256 to prevent tampering.
* **Time Behavior & Capacity (Performance Efficiency):** E-commerce search API processes $10,000\text{ req/sec}$ with $p99 < 80\text{ms}$.
* **Interoperability (Compatibility):** Weather service exposes OpenAPI 3.0 and gRPC contracts for zero-friction client integration.
* **Testability & Modularity (Maintainability):** Code structured with Dependency Injection so databases can be easily mocked in unit tests.
* **Installability (Portability):** Complete local microservices stack spins up in 60s via `docker compose up`.

<!--
**Next up, let's look at real-world examples.**

How do these quality attributes look in actual engineering?

* Look at **Fault Tolerance** under Reliability: If the credit card payment gateway goes down, does your checkout page crash? A resilient system puts the order in a queue and tries again later.
* Look at **Time Behavior** under Performance: In stock trading apps, order matching must happen in less than one millisecond.
* Look at **Testability** under Maintainability: Can you run 500 unit tests in 3 seconds to verify your new feature?
* Look at **Confidentiality** under Security: Are sensitive patient records encrypted at rest, and masked in log files?

That is what real software engineering looks like in production.

**To wrap up this slide, here is the key takeaway to remember:** Engineering quality means designing specific, testable safeguards for every critical sub-attribute.
-->
---

### Concept Check: Software Quality Factors (CCQ 6)
<!-- id: ase-ch01-ccq6 -->
<div class="ccq-columns">
  <div class="ccq-text">

**Which of the following matches a real-world software issue with its corresponding ISO 25010 quality characteristic?**

- **A.** A database query taking 15 seconds to return results → Maintainability (Testability)
- **B.** A system crash occurring when a third-party API goes offline → Reliability (Fault Tolerance)
- **C.** Developers struggling to write unit tests due to tight coupling → Portability (Adaptability)
- **D.** An unencrypted session cookie allowing account takeover → Usability (Operability)

  </div>
  <div class="ccq-logo">
    <a href="https://nlhsueh.github.io/nickedupocket/#/student/ase-ch01-ccq6" target="_blank"><img src="../../img/ch01/ase-ch01-ccq6.png" alt="QR Code" /></a>
  </div>
</div>

<!--
**Turning to the next slide here...**

**Time for our sixth Concept Check Question! Scan the QR code on the screen and submit your vote.**

Question: Which of the following matches a real-world software issue with its correct ISO 25010 quality characteristic?

Let's read the choices:
- A: A database query takes 15 seconds → Maintainability
- B: A system handles a third-party API outage without crashing → Reliability (Fault Tolerance)
- C: Developers struggle to write tests → Portability
- D: Unencrypted session cookies → Usability

Look closely at option B: surviving an external API crash without going down. Which category does that belong to?

Go ahead and submit your answer!

*(Explanation: The correct answer is B. Recovering from an external failure without crashing is Fault Tolerance under Reliability. Slow queries are Performance, testing difficulties are Maintainability, and cookie issues are Security.)*

**To wrap up this slide, here is the key takeaway to remember:** Knowing ISO 25010 categories helps you diagnose root causes when outages occur in production.
-->
---

### Interactive Activity: Quality Trade-Off Poll

<div class="discussion-columns">
  <div class="discussion-text">

  **Quality Trade-off Poll & Discussion:**
  - **System A:** Hospital ICU Automated Insulin Pump Controller
  - **System B:** Mobile Casual Viral Game
  - **Poll:** What are the top 2 non-negotiable ISO 25010 attributes for System A vs. System B?
  - **Key Question:** Why is prioritizing *Time to Market* over *Fault Tolerance* fatal for System A, but acceptable for System B? In your opinion, what constraints or factors impair software quality or make high quality hard to achieve?

  </div>
  <div class="discussion-logo">
    <img src="../../img/ch01/discussion_icon.svg" alt="Discussion" />
  </div>
</div>

<!--
**Alright, let's advance to the next slide.**

Here is an essential lesson in software architecture:
**Quality attributes always conflict with each other.** You cannot maximize all of them at the same time!

Let's look at three classic trade-offs:
1. **Performance versus Security**: Adding multi-factor authentication and deep encryption makes your app much safer, but it adds processing time and latency.
2. **Speed-to-Market versus Maintainability**: Rushing out code in two days gets your startup launched fast, but you accumulate messy technical debt.
3. **Portability versus Raw Efficiency**: Writing pure Python runs on any OS, but you lose the raw bare-metal speed of C++ or GPU code.

In software engineering, there are no perfect solutions—only trade-offs!

**To wrap up this slide, here is the key takeaway to remember:** There are no free lunches in software architecture; every design choice is a conscious trade-off.
-->
---
<!-- _class: lead -->
<!-- header: '1.7 Professional Ethics' -->

# **1.7 Professional Ethics and Dark Patterns**

> "With great computational power comes profound ethical responsibility."

<!--
Now we transition into Module 1.7: Professional Ethics, Social Responsibility, and Deceptive Dark Patterns.

Because software controls pacemakers, automotive brakes, financial markets, and personal privacy, software engineers wield immense societal power.

We examine the ACM/IEEE Code of Ethics, analyze notorious real-world breaches, and investigate deceptive UI 'dark patterns' designed to manipulate human psychology.

To summarize this slide, remember this key takeaway: Technical competence without ethical responsibility turns powerful engineering tools into instruments of societal harm.
-->
---
<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch01/code_of_ethics_covenant.png" alt="Code of Ethics: A Formal Covenant of Moral Duties, Professional Standards, and Public Accountability" />
</div>

<!--
**Now, let's look at the next page.**

Look at this illustration on the screen. It shows the ethical contract between software engineers and society.

Doctors take the Hippocratic Oath. Civil engineers stamp building blueprints with official legal seals.

Historically, software engineers have not had formal licenses.

Yet, software engineers write the code that decides bank loans, steers commercial airplanes, and controls medical radiation machines.

Ethical responsibility is not an optional elective. It is a fundamental part of our profession!

**To wrap up this slide, here is the key takeaway to remember:** Because software controls critical human lives, ethical responsibility must guide every line of code we write.
-->
---
<!-- header: '1.7 Professional Ethics & Social Responsibility' -->

## What is a Professional Code of Ethics?

> **A Code of Ethics is a formal covenant establishing the moral duties, professional standards, and public accountability of a discipline.**

* **The Moral Weight of Software Engineering:**
  - Software is no longer just code—it directly governs human health, aviation safety, elections, and global finance.
  - Unlike casual programmers, **professional engineers hold a fiduciary duty to society**.
* **Why Software Engineers Need an Explicit Code of Ethics:**
  - **Asymmetry of Information:** Users and managers cannot audit millions of lines of code—they must trust the engineer's integrity.
  - **Armor Against Compromise:** When corporate managers push to cut safety tests, fake benchmarks, or ship spyware, the Code provides an authoritative shield.
  - **The Fundamental Anchor:** **The Public Interest, Safety, and Welfare must always take absolute precedence over employer loyalty.**

<!--
**Moving right along to our next slide...**

What is a Code of Ethics?

It is a formal commitment that defines our duties to the public, our clients, and our fellow engineers.

The ACM and the IEEE joint committee created the official **Software Engineering Code of Ethics**.

The central rule is simple and non-negotiable:
Software engineers must always act in a way that protects **the public interest**.

Public safety and human well-being always come before corporate profits!

**To wrap up this slide, here is the key takeaway to remember:** The ACM/IEEE Code of Ethics establishes that protecting public safety and human welfare comes first.
-->
---
<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch01/code_of_ethics_principles.png" alt="The Eight Principles of the ACM/IEEE Software Engineering Code of Ethics" />
</div>

<!--
**Let's transition to the next slide.**

Look at this diagram. It shows the eight principles of the Code of Ethics:

1. **Public**: Always protect public safety, health, and privacy.
2. **Client & Employer**: Be honest and loyal, but never violate the public interest.
3. **Product**: Strive for the highest quality and safety.
4. **Judgment**: Maintain honest, independent professional judgment.
5. **Management**: Promote ethical management and fair deadlines.
6. **Profession**: Keep up the honest reputation of software engineering.
7. **Colleagues**: Be fair and support your teammates.
8. **Self**: Commit to continuous learning and ethical practice.

These eight principles give us a roadmap when difficult moral choices arise at work.

**To wrap up this slide, here is the key takeaway to remember:** The Eight Principles help us navigate tough professional conflicts of interest with integrity.
-->
---

## ACM/IEEE Code of Ethics: 8 Core Principles

1. **Public:** Prioritize public safety, health, and welfare above all.
2. **Client & Employer:** Act in their best interest, consistent with public interest.
3. **Product:** Ensure software meets high professional standards.
4. **Judgment:** Maintain integrity and independence in technical evaluation.
5. **Management:** Promote ethical management and realistic project estimates.
6. **Profession:** Advance the integrity and reputation of software engineering.
7. **Colleagues:** Be fair to, support, and mentor peers.
8. **Self:** Participate in lifelong learning and ethical practice.

<!--
**Shifting our attention to the next slide...**

Let's look at Principle 1 in practice: **The Public Interest**.

What happens if your boss tells you to ship software that you know is dangerous or insecure?

Under our professional code, the public interest always wins over employer loyalty.

You cannot say: *"I was just following management orders."*

International law and engineering standards reject that excuse. If a system is unsafe, you have a professional duty to speak up and refuse to sign off.

**To wrap up this slide, here is the key takeaway to remember:** Never sacrifice human safety or privacy just because a manager orders you to do so.
-->
---

## High-Profile Ethical Breaches

* **Volkswagen "Dieselgate" (2015):**
  - Engineers wrote engine software to detect laboratory test cycles and hide toxic $NO_x$ emissions (up to 40x legal limit on the road).
  - Resulted in billions in fines, criminal convictions, and severe environmental harm.
* **Cambridge Analytica (2018):**
  - Improper harvesting of personal data for covert political manipulation.
* **Planned Obsolescence:**
  - Software updates engineered to artificially degrade legacy device performance.

<!--
**Let's move ahead to the next slide.**

Look at these real-world ethical breaches where software systems were deliberately compromised:

First, **Volkswagen Dieselgate in 2015**:
Software engineers programmed the engine control unit to cheat laboratory emissions tests. The vehicles passed lab inspections, but on the road, they emitted up to 40 times the legal limit of toxic nitrogen oxides ($NO_x$). This resulted in tens of billions in fines, criminal convictions, and severe public health harm.

Second, **Cambridge Analytica in 2018**:
Engineers and data analysts improperly harvested the private data of over 87 million users without consent, using psychographic profiling for covert political manipulation during democratic elections.

Third, **Planned Obsolescence**:
Tech companies have deployed software updates intentionally throttled to degrade the performance of older devices, creating artificial friction to force consumers into buying new hardware prematurely.

When engineers stay silent or actively code deception, society pays a massive price.

**To wrap up this slide, here is the key takeaway to remember:** Software engineers bear moral and legal responsibility for their code. Ethical vigilance and integrity are non-negotiable.
-->
---
<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch01/dark_patterns_comic.png" alt="Deceptive Dark Patterns 4-Panel Comic" />
</div>

<!--
**Now, moving on to the next slide...**

Now let's talk about user interface ethics: **Dark Patterns**.

A Dark Pattern is a sneaky user interface designed to trick people into doing things they didn't intend:

* **Roach Motel**: Subscribing takes one click, but canceling requires phone calls or navigating hidden menus.
* **Confirmshaming**: Emotional manipulation on buttons, like: *"No thanks, I hate saving money!"*
* **Sneak into Basket**: Secretly pre-checking optional fees or insurance when you buy a ticket.
* **Fake Urgency (Fabricated Scarcity)**: Fake countdown timers (*"Only 2 minutes left!"*) or fake low-stock warnings designed to manipulate impulse buying.

These tricks exploit human psychology to take user money.
-->
---

## Deceptive "Dark Patterns" in UI/UX Design

* **1. Roach Motel (Subscription Labyrinth):**
  - Signing up takes 1 click; cancelling requires navigating hidden menus or making a phone call.
* **2. Confirmshaming:**
  - Emotionally manipulative text on decline buttons (*"No thanks, I hate saving money"*).
* **3. Hidden Costs & Sneak into Basket:**
  - Pre-ticking add-on insurance or fees at the final checkout step.
* **4. Fabricated Urgency & Scarcity:**
  - Fake countdown timers (*"Only 2 minutes left!"*) and fabricated demand alerts.

<!--
**Let's flip over to the next slide.**

Today, governments are cracking down hard on deceptive UI designs.

In the European Union, the Digital Services Act and GDPR strictly ban dark patterns, with fines up to 6% of global revenue.

In the United States, the FTC is suing companies that make cancellation difficult.

As software engineers, we must realize: UI and frontend code is not ethically neutral. Writing sneaky checkout flows can land your company in court!

**To wrap up this slide, here is the key takeaway to remember:** Dark patterns are not clever growth hacks; they are illegal manipulation that destroys company trust.
-->
---

### Concept Check: Engineering Ethics (CCQ 7)
<!-- id: ase-ch01-ccq7 -->
<div class="ccq-columns">
  <div class="ccq-text">

**Under the ACM/IEEE Code of Ethics, if an employer directs an engineer to implement an algorithm that falsifies safety compliance reports, what is the engineer's obligation?**

- **A.** Comply, because the employer pays the engineer's salary.
- **B.** Refuse and escalate, because the Public Interest takes precedence over Employer loyalty.
- **C.** Implement the code but omit documentation.
- **D.** Outsource the code to an external vendor.

  </div>
  <div class="ccq-logo">
    <a href="https://nlhsueh.github.io/nickedupocket/#/student/ase-ch01-ccq7" target="_blank"><img src="../../img/ch01/ase-ch01-ccq7.png" alt="QR Code" /></a>
  </div>
</div>

<!--
**Next up, let's take a look at the next topic.**

**Time for our seventh Concept Check Question! Please scan the QR code on the screen and submit your vote.**

Question: Under the ACM/IEEE Code of Ethics, if an employer orders you to write code that falsifies safety reports, what is your duty?

Let's read the choices:
- A: Follow orders, because the employer pays your salary.
- B: Refuse and escalate, because the Public Interest comes before employer loyalty.
- C: Write the code, but leave off your name and documentation.
- D: Outsource the task to another company.

Think about Principle 1. Go ahead and submit your answer!

*(Explanation: The correct answer is B. Principle 1 states that the public interest is supreme. You must refuse to falsify safety records and escalate the issue.)*

**To wrap up this slide, here is the key takeaway to remember:** The public interest is non-negotiable. Software engineers must refuse illegal or unsafe instructions.
-->
---

### Interactive Activity: Dark Pattern Detective (Pair Discussion)

<div class="discussion-columns">
  <div class="discussion-text">

  **Dark Pattern Detective Activity (Pair Discussion with Your Classmate):**
  - **Identify & Classify:** Recall a deceptive interface you encountered on a real-world app or website. **Which type of dark pattern does it belong to?** (e.g., Roach Motel, Confirmshaming, Sneak into Basket, Fake Urgency, etc.)
  - **Ethical Analysis:** Which ACM/IEEE ethical principle (Public Interest, Product Quality, Professional Judgment) was violated?
  - **Redesign:** How would you redesign that interaction to achieve legitimate business conversion while remaining transparent, honest, and user-respecting?

  </div>
  <div class="discussion-logo">
    <img src="../../img/ch01/discussion_icon.svg" alt="Discussion" />
  </div>
</div>

<!--
**Turning to the next slide here...**

Let's do an interactive pair discussion with your classmate: The Dark Pattern Detective!

Take two minutes with your partner to discuss:
1. Think of a deceptive design you've encountered on an app, game, or e-commerce site. **Which specific type of dark pattern does it belong to?** Is it a Roach Motel, Confirmshaming, Sneak into Basket, Fake Urgency, or something else?
2. Which ACM/IEEE ethical principle was compromised?
3. How would you redesign that flow to be transparent and user-respecting while still supporting business goals?

Exchange your thoughts with your partner, and let's hear what patterns you've spotted!

**To wrap up this slide, here is the key takeaway to remember:** Spotting and categorizing dark patterns with your peers sharpens your ability to design ethical, user-respecting software.
-->
---
<!-- _class: lead -->
<!-- header: '1.8 AI in Software Engineering' -->

# **1.8 AI in Software Engineering**

> "AI amplifies our velocity, but engineering discipline ensures we are heading in the right direction."

<!--
We now enter the modern frontier, Module 1.8: AI in Software Engineering — Paradigm Shift, Pitfalls, and Engineering Rigor.

Generative AI and Large Language Models are redefining how software is written, moving us from Software 1.0 towards Software 3.0. Yet unsupervised 'vibe coding' introduces hallucinations, code churn, and severe security liabilities.

We explore how professional engineers harness AI as a high-powered copilot while maintaining strict verification, architectural discipline, and testing rigor.

To summarize this slide, remember this key takeaway: AI accelerates code generation, making human architectural judgment and automated verification more critical than ever.
-->
---
<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch01/vibe_coding_comic.jpg" alt="The Vibe Coding Trap" />
</div>

<!--
**Alright, let's advance to the next slide.**

Take a look at this comic on the screen. It captures today's biggest debate in software.

On one side, you have the "vibe coding" dream. An influencer types a quick prompt into an AI tool. In twenty minutes, a colorful website appears on localhost. They tweet: "Software engineering is dead! Anyone can build software now just by vibing."

Now look at the other side. That is production reality. Two weeks later, real users show up. The app crashes under heavy traffic. API keys leak in plain text. Database transactions fail to roll back. Data gets corrupted. Worst of all, nobody can fix it. The entire codebase is AI-generated spaghetti that no human understands.

Building a demo is fun and easy. But engineering a secure, reliable, long-lasting production system is still hard work.

**To wrap up this slide, here is the key takeaway to remember:** Writing demo code with AI is easy; engineering production-grade software that survives in the real world is still hard.
-->
---
<!-- header: '1.8 AI in Software Engineering' -->

## What is "Vibe Programming"?

<div class="content-columns">
<div class="content-text">

> **"Vibe Coding" (popularized by Andrej Karpathy):**  
> A workflow where developers prompt an AI to generate code, rarely inspecting or understanding the implementation, and "just vibe with whatever runs."

* **The Seductive Appeal of the "Vibe":**
  - **Zero-Friction Prototyping:** Anyone can prompt an LLM to build a working prototype or full-stack MVP in an afternoon.
  - **The Illusion of Velocity:** Compiling code creates a false sense of production readiness.
* **Why Vibe Coding Fails as Software Engineering:**
  - **Hidden Fragility:** Unchecked AI code harbors subtle concurrency race conditions, security vulnerabilities (CVEs), and edge cases.
  - **Unmaintainable Debt:** When 20,000 lines built on "vibes" break in production, no human understands the causality.

</div>
<div class="content-figure">

<div class="name-card">
  <img src="../../img/ch01/andrej_karpathy.png" alt="Andrej Karpathy" />
  <div class="name-card-caption">
    <span class="name-card-name">Andrej Karpathy</span>
    <span class="name-card-cc"><a href="https://en.wikipedia.org/wiki/Andrej_Karpathy" target="_blank">Wikimedia Commons / Wikipedia</a></span>
  </div>
</div>

</div>
</div>

<!--
**Now, let's look at the next page.**

You have probably heard the term "Vibe Coding." AI researcher Andrej Karpathy popularized this phrase.

So, what is vibe coding? It is a workflow where you prompt an AI to write code. You don't inspect the lines. You don't really understand how it works. You just "vibe" with whatever runs.

Why is this so appealing? First, zero-friction prototyping. Anyone can build a working prototype in an afternoon. Second, the illusion of velocity. If the code compiles and passes two simple tests, it feels ready to ship.

Why does vibe coding fail as software engineering? Because of hidden fragility. Unchecked AI code hides concurrency race conditions, security flaws, and hallucinated APIs. And when a twenty-thousand-line codebase breaks at 2 AM, no one understands how to fix it.

**To wrap up this slide, here is the key takeaway to remember:** Vibe coding is fast for prototypes; software engineering is the discipline needed for reliable production systems.
-->
---

## The Hidden Hazards: Three Empirical Problems of AI Coding

* **1. Maintainability Degradation & High Code Churn (GitClear 150M LOC Study):**
  - **Code Duplication Surges:** Copy-paste logic increases; proactive refactoring (*"moved lines"*) drops sharply.
  - **High Code Churn:** Code is rapidly deleted or rewritten within two weeks, accumulating massive **Maintainability Debt**.
* **2. 52% Error Rate & The "Illusion of Security" (Purdue University Study):**
  - In 517 software engineering questions, **52% of ChatGPT code answers contained errors**.
  - Due to AI's articulate, confident, and polite tone, **39.3% of developers still preferred and accepted** the flawed code without verification.
* **3. 40% Known Security Vulnerabilities (NYU / Stanford Research):**
  - Automated CWE scans show that without explicit security constraints, **$\approx 40\%$ of AI-generated code** harbors CWE Top 25 vulnerabilities (SQL injection, buffer overflow, race conditions).

<!--
**Moving right along to our next slide...**

Let's look at real data from recent research studies. Researchers found three major hazards when developers accept AI code without inspection.

First, maintainability drops and code churn spikes. GitClear analyzed 150 million lines of committed code. They found code duplication surged through copy-pasting. Proactive refactoring dropped sharply. Code churn doubled—meaning code was deleted or rewritten within two weeks.

Second, a 52% error rate. Purdue University evaluated ChatGPT on 517 software engineering questions. Over half of the answers contained factual errors. But here is the scary part: developers still accepted flawed answers nearly 40% of the time. The AI sounded so polite and confident.

Third, 40% security vulnerabilities. Stanford and NYU studies showed about 40% of AI-generated code contained top security flaws. That includes SQL injection, buffer overflows, and race conditions.

**To wrap up this slide, here is the key takeaway to remember:** AI speeds up typing, but unreviewed code leads to high code churn, frequent errors, and critical security holes.
-->
---

## Real-World Incidents of Vibe Coding

* **1. Production Outages (Amazon Checkout):** AI-generated patch deployed without complete verification broke checkout logic, dropping orders by 99% and losing **6.3M orders in hours**.  
* **2. Slopsquatting (Package Hallucination):** LLMs hallucinate fake package names (`huggingface-cli`); hackers register malware, poisoning builds (30k+ downloads).
* **3. Secrets Sprawl & Hardcoded API Keys:** AI generates sample code with hardcoded passwords and tokens; GitGuardian reports AI code leaks credentials at **$2\times$ the rate of humans**.

<!--
**Let's transition to the next slide.**

These hazards are not theoretical. They have already caused serious real-world incidents.

First, production outages. Look at the Amazon checkout incident on the right. An AI-generated patch was deployed without complete verification. It broke checkout logic. Order volume dropped by 99%. In just a few hours, Amazon lost 6.3 million orders.

Second, slopsquatting through package hallucination. LLMs often hallucinate package names that do not exist, like fake plugins or libraries. Hackers notice these fake names, register them on npm or PyPI, and insert malware. Unsuspecting developers then install them.

Third, secrets sprawl. AI models love inserting hardcoded API keys and passwords into sample code. GitGuardian found AI-assisted code leaks credentials at twice the rate of human developers.

**To wrap up this slide, here is the key takeaway to remember:** Blindly trusting AI output causes real outages, security breaches, and credential leaks.
-->
---

## The Other Side: Benefits & Real-World Triumphs of AI Coding

* **The Genuine Benefits of AI Assistance:**
  - **1. Eliminating Cognitive Drudgery:** Automates boilerplate, regex, CRUD patterns, and scaffolding—allowing engineers to focus on architectural trade-offs and domain logic.
  - **2. Accelerating Developer Velocity & Flow:** Empirical studies show developers complete routine tasks up to **55% faster**, preserving mental energy and deep focus.
* **Two Landmark Real-World Success Stories:**
  - **Case 1: Amazon's 30,000 Java Upgrades (Amazon Q Developer):**
    - Amazon used AI agents to migrate over 30,000 production applications to Java 17 in months, saving **4,500 developer-years** of manual labor and **$260M in annual efficiency gains**.
  - **Case 2: Enterprise Productivity Surge (Accenture & GitHub Copilot):**
    - Across thousands of enterprise engineers, routine feature delivery accelerated by **55%**, with 90% reporting greater flow state when paired with rigorous peer code reviews.
* **The Engineering Takeaway:**
  - **Harness & govern—neither blindly embrace nor dogmatically reject!** The goal is not to surrender to the "vibe", nor to ban AI out of fear, but to **manage AI coding through engineering discipline, verification, and architectural oversight**.

<!--
**Shifting our attention to the next slide...**

Now let's look at the other side of the coin. Does this mean we should ban AI? Absolutely not!

When used with engineering discipline, AI delivers extraordinary productivity gains.

First, it eliminates cognitive drudgery. AI handles repetitive boilerplate, regex patterns, CRUD endpoints, and initial test scaffolding. This frees engineers to focus on architecture and core business logic.

Second, it boosts developer flow. Studies show engineers complete routine tasks up to 55% faster.

Look at Amazon's success story. Using Amazon Q Developer, they upgraded over thirty thousand production apps to Java 17 in just a few months. That saved 4,500 developer-years and 260 million dollars.

Our takeaway is clear: neither blindly embrace nor dogmatically reject. We must govern AI coding with verification and engineering discipline.

**To wrap up this slide, here is the key takeaway to remember:** Don't ban AI and don't surrender to vibes; harness AI's speed while maintaining strict engineering control.
-->
---

## AI in SWE: The Paradigm Shift (Software 1.0 → 3.0)

* **The Evolution of How We Build Software:**
  - **Software 1.0 (Code-Centric):** Humans write explicit, deterministic algorithms line-by-line (f(x) → y).
  - **Software 2.0 (Prompt-Driven):** Humans write natural language prompts and instructions; LLMs generate code, functions, and boilerplate (e.g., Copilot, ChatGPT).
  - **Software 3.0 (Agentic):** Humans specify high-level goals and architectural constraints; autonomous AI agents iteratively plan, execute tools, run tests, and refactor code.
* **The Fundamental Transformation of the Software Engineer:**
  - **What AI Commoditizes:** Boilerplate syntax, standard CRUD endpoints, and syntax translation.
  - **What Remains Irreplaceable:** Domain analysis, architectural trade-offs, security boundaries, and **evaluating whether generated solutions actually meet user needs**.
  - **The Engineer's New Identity:** Moving from *syntax typist* → **System Architect, Specification Designer & Verification Authority**.

<!--
**Let's move ahead to the next slide.**

We are living through a historic paradigm shift in how software gets built.

Think of it in three eras.

Software 1.0 is code-centric. Humans write explicit, deterministic logic line by line. If input is X, output is Y.

Software 2.0 is prompt-driven. Humans write prompts and instructions. AI models generate code, functions, and boilerplate. You see this today with Copilot and ChatGPT.

Software 3.0 is agentic. Humans specify high-level goals and architectural constraints. Autonomous AI agents iteratively plan, call tools, execute tests, and refactor code.

Notice what this changes for your career. AI commoditizes typing syntax. But AI cannot replace domain analysis, architectural trade-offs, and verification. Your role evolves from a "syntax typist" into a system architect and verification authority.

**To wrap up this slide, here is the key takeaway to remember:** In Software 3.0, typing syntax is commoditized; specification, architecture, and verification are your most valuable skills.
-->
---

## AI in SWE: Requirements & System Architecture

* **1. Requirements Engineering (Specification):**
  - **Superpowers ($\oplus$):** Rapidly drafts user stories, Given-When-Then acceptance criteria, and edge-case scenarios; spots ambiguities and contradictions in specs.
  - **Pitfalls & Risks ($\ominus$):** Hallucinates non-existent APIs and false business logic; lacks organizational tacit knowledge, legal liability context, and human empathy.
* **2. Architectural & System Design:**
  - **Superpowers ($\oplus$):** Compares architectural patterns and trade-offs systematically; rapidly scaffolds ERDs, database schemas, and OpenAPI contracts.
  - **Pitfalls & Risks ($\ominus$):** Promotes premature over-engineering and microservice sprawl; blind to operational latency, infrastructure cost limits, and security SLAs.

<!--
**Now, moving on to the next slide...**

Let's see how AI impacts the first two phases of the software lifecycle: Requirements and Architecture.

In requirements engineering, AI has superpowers. It can quickly draft user stories, write Given-When-Then acceptance criteria, and spot ambiguities in specs. But watch out for the pitfalls. AI hallucinates non-existent features and lacks business context, legal understanding, and human empathy.

In architectural design, AI also shines. It can compare design patterns, suggest database schemas, and create OpenAPI contracts. But the risks are real. AI tends to over-engineer, suggesting unnecessary microservices while ignoring infrastructure costs and latency limits.

AI drafts options quickly, but the human architect must make the final call.

-->
---

## AI in SWE: Code Construction & Implementation

* **3. Coding & Implementation:**
  - **Superpowers ($\oplus$):**
    - **Eliminates Boilerplate:** Automates repetitive scaffolding, CRUD endpoints, and complex regex queries.
    - **Polyglot Acceleration:** Translates algorithms and logic seamlessly across programming languages.
    - **Instant Rubber-Ducking:** Explains cryptic compiler errors and suggests alternative implementations in seconds.
  - **Pitfalls & Risks ($\ominus$):**
    - **The "Vibe Coding" Trap:** Developers accept syntactically plausible code without understanding runtime causality.
    - **Security Vulnerabilities:** NYU/Stanford studies show $\approx 40\%$ of AI code contains CWE Top 25 vulnerabilities (SQL injection, buffer overflows, concurrency race conditions).
    - **Supply Chain Poisoning:** Introduces hallucinated packages, deprecated APIs, or restrictive copyleft licenses.

<!--
**Let's flip over to the next slide.**

Next, let's look at the implementation phase: writing code.

Here, AI acts like a supercharged pair programmer.

It eliminates boilerplate. It scaffolds CRUD endpoints and writes complex regex in seconds. It provides polyglot acceleration, translating algorithms between languages. And it offers instant rubber-duck debugging when compiler errors pop up.

However, you must be alert to three big traps.

First, the vibe coding trap. You accept plausible-looking code without understanding how it works. Second, security vulnerabilities. Forty percent of raw AI code contains known security flaws. Third, supply chain poisoning through hallucinated packages or restrictive licenses.

Treat AI like a brilliant, eager intern. Review every single line before merging.

**To wrap up this slide, here is the key takeaway to remember:** Never merge code you do not understand; AI drafts fast, but you are accountable for every line in production.
-->
---

## AI in SWE: Validation, Testing & Evolution

* **4. Software Validation (Testing & QA):**
  - **Superpowers ($\oplus$):** Synthesizes comprehensive mock datasets, boundary unit tests, and property-based fuzzing suites.
  - **Pitfalls & Risks ($\ominus$):** **"Echo-Chamber Testing"**—AI writes tests that merely validate its own flawed assumptions (*"Who tests the tester?"*); unit tests pass on `localhost` but fail under real concurrency.
* **5. Software Evolution (Maintenance):**
  - **Superpowers ($\oplus$):** Deciphers and explains 10-year-old legacy spaghetti codebases in seconds; automates changelogs, docstrings, and migration scripts.
  - **Pitfalls & Risks ($\ominus$):** Introduces **silent regression bugs** during refactoring; generates articulate, authoritative documentation that describes what the code *should* do, not what it *actually* does.

<!--
**Next up, let's take a look at the next topic.**

Now, what about testing and long-term maintenance?

In software validation, AI is great at synthesizing mock datasets, edge-case unit tests, and property fuzzing suites.

But here is the danger: "Echo-Chamber Testing." If you let AI write the code and also write the tests without a specification, what happens? The tests pass! Why? Because the tests simply mirror the AI's own flawed assumptions. You get a false sense of security.

In software evolution, AI helps decipher legacy spaghetti code and drafts migration scripts. But it can introduce silent regression bugs. And it often writes documentation describing what the code *should* do, rather than what it *actually* does.

Always verify tests against real requirements, not against AI assumptions.

-->
---

## Engineering Rigor in the AI Era

> **"Never merge code you do not understand and cannot defend."**

* **The "Automation Bias" Hazard:**
  - Over-trusting fluent, confident AI outputs without verifying boundary behaviors, race conditions, or edge-case security contracts.
* **Three Imperatives for AI-Augmented Engineering:**
  - **1. Specification-First (Contract-Driven):** Never generate code without formal interface definitions, type signatures, and clear acceptance criteria.
  - **2. Independent Verification Net:** AI cannot write both the implementation and its own test cases unchecked (*"Who tests the tester?"*). Mandate deterministic CI regression suites.
  - **3. Human Professional Accountability:** AI provides drafts, but the human engineer owns **100% of the legal, ethical, and architectural liability** for every line in production.

<!--
**Turning to the next slide here...**

Here is our golden rule for the AI era: "Never merge code you do not understand and cannot defend."

Be careful of "automation bias." That is the tendency to trust confident, fluent AI output without checking edge cases or race conditions.

To keep software safe, follow these three engineering imperatives:

First, Specification-First. Never generate code without clear interface definitions, type signatures, and acceptance criteria.

Second, an Independent Verification Net. Never let AI grade its own homework. Run deterministic CI regression suites and automated security scans.

Third, Human Professional Accountability. AI produces drafts, but you own 100% of the legal, ethical, and architectural liability for production code.

**To wrap up this slide, here is the key takeaway to remember:** AI generates code, but software engineering provides the discipline, verification, and human accountability.
-->
---

### Concept Check: AI Coding & Code Churn (CCQ 8)
<!-- id: ase-ch01-ccq8 -->
<div class="ccq-columns">
  <div class="ccq-text">

**In empirical studies evaluating AI coding assistants (such as GitClear's analysis of 150M lines of code), "Code Churn" emerged as a major warning sign. What does high Code Churn indicate in an AI-assisted codebase?**

- **A.** Code is rapidly rewritten, deleted, or patched shortly after commit, indicating brittle code accepted without sufficient verification.
- **B.** Compilers and bundlers are aggressively removing unreachable dead code from application binaries during automated deployment.
- **C.** Software engineering teams are switching programming languages frequently due to automated polyglot syntax translation.
- **D.** Automated test cases are executing too quickly and depleting available CI/CD pipeline virtual machine compute resources.

  </div>
  <div class="ccq-logo">
    <a href="https://nlhsueh.github.io/nickedupocket/#/student/ase-ch01-ccq8" target="_blank"><img src="../../img/ch01/ase-ch01-ccq8.png" alt="QR Code" /></a>
  </div>
</div>

<!--
**Alright, let's advance to the next slide.**

**Alright, it's time for an interactive Concept Check Question! Please take out your phone or open your browser, scan the QR code on the screen, and submit your answer.**

Let's read the question together:

"In empirical studies evaluating AI coding assistants (such as GitClear's analysis of 150M lines of code), 'Code Churn' emerged as a major warning sign. What does high Code Churn indicate in an AI-assisted codebase?"

Here are your options:

A: Code is rapidly rewritten, deleted, or patched shortly after commit, indicating brittle code accepted without sufficient verification.

B: Compilers and bundlers are aggressively removing unreachable dead code from application binaries during automated deployment.

C: Software engineering teams are switching programming languages frequently due to automated polyglot syntax translation.

D: Automated test cases are executing too quickly and depleting available CI/CD pipeline virtual machine compute resources.

Think about what happens when developers accept AI code too quickly. Go ahead and vote!

*(Explanation: The correct answer is A. High code churn means code is frequently replaced within two weeks, revealing brittle, uninspected AI code.)*

**To wrap up this slide, here is the key takeaway to remember:** High code churn reveals that developers are accepting fragile AI code that fails soon after deployment.
-->
---

### Concept Check: AI Verification & Testing (CCQ 9)
<!-- id: ase-ch01-ccq9 -->
<div class="ccq-columns">
  <div class="ccq-text">

**An engineer prompts an AI to generate a complex payment calculation module, and then asks the same AI to write unit tests without providing a formal specification. All tests pass. What is the primary risk?**

- **A.** Echo-chamber validation: The generated tests merely mirror the AI's internal flawed assumptions rather than actual business requirements.
- **B.** Performance bottleneck: AI-generated test assertions take significantly longer to execute than human-written assertions.
- **C.** Compilation failure: Testing frameworks cannot parse automated mock datasets generated by large language models.
- **D.** Version lock-in: The test suite becomes tightly coupled to a single specific cloud runtime environment.

  </div>
  <div class="ccq-logo">
    <a href="https://nlhsueh.github.io/nickedupocket/#/student/ase-ch01-ccq9" target="_blank"><img src="../../img/ch01/ase-ch01-ccq9.png" alt="QR Code" /></a>
  </div>
</div>

<!--
**Now, let's look at the next page.**

**Alright, it's time for another Concept Check Question! Scan the QR code on the screen and submit your answer.**

Here is the question:

"An engineer prompts an AI to generate a complex payment calculation module, and then asks the same AI to write unit tests without providing a formal specification. All tests pass. What is the primary risk?"

Let's check the options:

A: Echo-chamber validation: The generated tests merely mirror the AI's internal flawed assumptions rather than actual business requirements.

B: Performance bottleneck: AI-generated test assertions take significantly longer to execute than human-written assertions.

C: Compilation failure: Testing frameworks cannot parse automated mock datasets generated by large language models.

D: Version lock-in: The test suite becomes tightly coupled to a single specific cloud runtime environment.

What happens when an AI checks its own work without an external spec? Cast your vote!

*(Explanation: The correct answer is A. This is echo-chamber validation. The tests confirm the AI's assumptions, not the real business rules.)*

**To wrap up this slide, here is the key takeaway to remember:** Unit tests must come from independent business requirements, not from the AI's unverified assumptions.
-->
---

### Interactive Activity: The "Vibe Coding" Challenge

<div class="discussion-columns">
  <div class="discussion-text">

  **Classroom Poll & Discussion: AI in Practice**
  - **Poll:** When using AI coding assistants, how often do you inspect and understand every line before committing?
  - **Discussion:** Suppose an AI assistant writes a 200-line asynchronous database handler that passes 2 basic tests. Is it safe to deploy? What verification steps must a professional engineer execute?

  </div>
  <div class="discussion-logo">
    <img src="../../img/ch01/discussion_icon.svg" alt="Discussion" />
  </div>
</div>

<!--
**Moving right along to our next slide...**

Let's run a quick classroom activity: The Vibe Coding Challenge!

First, a quick poll: When you use AI tools like Copilot or ChatGPT, how often do you read and understand every single line before committing? Be honest!

Now, look at the discussion scenario on the screen.

Suppose an AI assistant writes a two-hundred-line asynchronous database handler. It compiles cleanly. It passes two basic tests.

Here is the question for your group: Is it safe to deploy to production right now?

What verification steps would you demand before shipping? Think about race conditions, connection pooling, error handling, and security leaks.

**To wrap up this slide, here is the key takeaway to remember:** Passing two basic tests does not make code production-ready; disciplined engineers always test edge cases and failure modes.
-->
---
<!-- _class: lead -->
<!-- header: '1.9 FAQ & Recap' -->

# **1.9 Frequently Asked Questions (FAQ) & Recap**

> "The most important tool in software engineering is the disciplined, critical human mind."

<!--
To conclude Chapter 1, we arrive at Module 1.9: Frequently Asked Questions and Conceptual Recap.

We will address common student and industry questions—from career paths to foundational mindsets—and solidify our key concepts with an interactive fill-in-the-blank review.

To summarize this slide, remember this key takeaway: Mastering the foundational principles of software engineering provides an enduring anchor throughout an evolving technological career.
-->
---
<!-- header: '1.9 FAQ & Recap' -->

## Frequently Asked Questions (FAQ)

* **Q1: Programming vs. Software Engineering?**
  - *Answer:* Programming is writing code. Software engineering is programming integrated over time, managing team collaboration, constraints (budget/schedule), quality attributes, and long-term evolution.
* **Q2: Why do correct programs with 100% test coverage fail?**
  - *Answer:* Software requires Data, Operational Procedures, and Documentation. Deficiencies in these non-code pillars or in Specification lead to failure.
* **Q3: Satisficing vs. Optimizing?**
  - *Answer:* Real-world constraints (time, budget) require a "satisficing" solution (sufficient to meet constraints) rather than a technically "optimized" one.
* **Q4: The risk of "Vibe Coding" with AI?**
  - *Answer:* Blindly accepting AI code without review leads to bugs. Prevent with code reviews, specification-first testing, and treating AI output as drafts.

<!--
**Let's transition to the next slide.**

Let's review four key questions students often ask in Chapter 1.

Question 1: What is the difference between programming and software engineering?
Programming is writing code. Software engineering is programming integrated over time, with team collaboration, budgets, schedules, quality attributes, and long-term maintenance.

Question 2: Why do programs with 100% test coverage still fail in production?
Because software is more than code. It includes data, operational procedures, and documentation. If your specifications or operating procedures are wrong, even bug-free code will fail.

Question 3: What is the difference between satisficing and optimizing?
In real engineering, resources are limited. We cannot optimize everything. We "satisfice"—we choose solutions that satisfy our budget, deadline, and quality constraints.

Question 4: What is the biggest risk of vibe coding with AI?
Blindly accepting code without review. Prevent this with contract-first specifications, code reviews, and automated CI pipelines.

**To wrap up this slide, here is the key takeaway to remember:** Software engineering is about managing systems, constraints, and teams over time, not just writing syntax.
-->
---

## Recap: Fill-in-the-Blank Quiz

<div class="fill-blank-columns">
  <div class="fill-blank-text">

Test your mastery of Chapter 1 fundamentals:

1. According to the IEEE definition, software consists of programs, data, operational procedures, and **[ _________ ]**.
2. Adding manpower to a late software project makes it later is known as **[ _________ ]** Law.
3. The **[ _________ ]** Quality Model defines 8 product quality characteristics including Functional Suitability, Compatibility, Security, and Maintainability.
4. The first principle of the ACM/IEEE Code of Ethics prioritizes the **[ _________ ]** interest.

  </div>
  <div class="fill-blank-logo">
    <img src="../../img/ch01/fill_blank_icon.svg" alt="Quiz" />
  </div>
</div>

<!--
**Shifting our attention to the next slide...**

Before we conclude Chapter 1, let's test your memory with four quick fill-in-the-blank questions!

Number 1: According to the IEEE definition, software consists of programs, data, operational procedures, and what?
The answer is: Documentation!

Number 2: Adding manpower to a late software project makes it later. Whose law is this?
That's Brooks's Law!

Number 3: What international standard defines eight product quality characteristics, including Performance, Security, and Maintainability?
That is ISO/IEC 25010!

And Number 4: The first principle of the ACM/IEEE Code of Ethics prioritizes whose interest above all else?
The public interest!

Great job if you got all four!

**To wrap up this slide, here is the key takeaway to remember:** These core concepts form the foundation for everything we will study in advanced software engineering.
-->
---

## References & Further Reading

* Sommerville, Ian. *Software Engineering* (10th Edition). Pearson. [Official Website](https://software-engineering-book.com/)
* Brooks, Frederick P. *The Mythical Man-Month: Essays on Software Engineering*. Addison-Wesley.
* ISO/IEC 25010:2011. *Systems and software engineering — Systems and software Quality Requirements and Evaluation (SQuaRE) — System and software quality models*.
* ACM/IEEE Joint Task Force on Software Engineering Ethics. *Software Engineering Code of Ethics*. [IEEE CS](https://www.computer.org/education/code-of-ethics)
* Brignull, Harry. *Deceptive Patterns: Exposing the Tricks Tech Companies Use to Control You*.

<!--
**Let's move ahead to our final slide.**

Here are the classic books and standards referenced in this chapter:

First, Ian Sommerville's classic textbook, *Software Engineering*. A comprehensive guide to processes and architecture.

Second, Fred Brooks's timeless book, *The Mythical Man-Month*. A must-read on team communication and software project dynamics.

Third, the ISO/IEC 25010 standard for software quality models.

Fourth, the ACM/IEEE Software Engineering Code of Ethics.

And finally, recent empirical studies from GitClear, Purdue, NYU, and Stanford on AI code quality and security.

Mastering these foundations ensures we build software that lasts, while learning from the mistakes of the past.

Thank you everyone, and see you in Chapter 2!

**To wrap up this slide, here is the key takeaway to remember:** Standing on the shoulders of software engineering pioneers helps us build reliable, ethical, and enduring systems.
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
