---
marp: true
theme: ase-theme
paginate: true
header: '軟體工程 | 第四章：系統塑模'
footer: '薛念林 教授 · 逢甲大學資訊工程學系'


---

<!-- _class: lead -->
<!-- header: '' -->

# **軟體工程**

### 第四課：系統塑模與統一架構 (System Modeling & Unified Architecture)

**授課教師：薛念林 教授**  
資訊工程學系  
逢甲大學

<!--
各位好，歡迎來到軟體工程第四課：系統塑模與統一架構。

在第三章中，我們學習了如何透過自然語言與使用者故事來發掘、分析與規格化軟體需求。然而，自然語言天生具備模糊性與不完整性，很難直接無縫轉化為穩健且無瑕疵的程式碼。

今天，我們將完成從抽象需求邁向形式化軟體模型的關鍵躍遷。我們將探討什麼是系統塑模、深入理解四大核心視角、回顧統一塑模語言（UML）的三巨頭歷史，並透徹掌握每一種不可或缺的 UML 圖表。

總結這張投影片，請記住這個核心觀念：系統塑模在人類的模糊需求與可執行的軟體程式碼之間，建立了正式且精確的觀念橋樑。
-->

---

<!-- _class: outline-slide -->

## 第四章：課程藍圖與核心架構

<div class="outline-columns">
<div>
<h3>第一部分：塑模基礎與核心靜態模型</h3>
<ul>
<li><b>4.1 系統塑模基礎：</b> 塑模本質、四大核心視角、五大必備圖表與盲人摸象寓言。</li>
<li><b>4.2 統一塑模語言 (UML)：</b> 1990 年代方法論之戰、三巨頭三位一體分工與 OMG 標準化。</li>
<li><b>4.3 功能塑模與使用案例：</b> 參與者目標、系統邊界、include/extend 關聯與 AI 提示詞指引。</li>
<li><b>4.4 結構塑模與領域類別圖：</b> 領域實體、可見度符號、關聯重數、整體與部分及 AI 提示詞。</li>
<li><b>4.5 互動塑模與循序圖：</b> 訊息傳遞時序、生命線、啟動條、BCE 模式與 AI 提示詞指引。</li>
</ul>
</div>
<div>
<h3>第二部分：工作流程、行為狀態與文字塑模</h3>
<ul>
<li><b>4.6 流程塑模與活動圖：</b> 並行流程、決策分支、分岔/結合、泳道職責與 AI 提示詞。</li>
<li><b>4.7 行為塑模與有限狀態機：</b> 反應型系統、訂單生命週期狀態機、事件觸發、守衛條件與 AI 提示詞。</li>
<li><b>4.8 PlantUML 宣告式文字塑模：</b> 架構即代碼 (Code-as-Architecture)、語法速查與多圖管線。</li>
<li><b>4.9 概念複習與統整：</b> 核心工程原則回顧、填空小測驗與經典文獻。</li>
</ul>
</div>
</div>

<!--
這裡是第四章全新調整後的完整學習藍圖。

在左側的第一部分，我們從系統塑模的哲學本質與四大視角出發，見證 UML 的歷史誕生與三巨頭整合，接著探討以使用者目標為導向的使用案例模型，並定義系統的靜態領域類別結構與動態循序圖。

在右側的第二部分，我們深入探討活動圖的並行流程與泳道分配、分析反應型系統的有限狀態機轉換，掌握現代 PlantUML 宣告式文字塑模技術，最後進行全面性的概念統整與測驗。

每個核心模型皆深度整合專屬的 AI 提示詞指南與外送平台實戰範例！

總結這張投影片，請記住這個核心觀念：本章帶領大家建立從需求意圖、架構設計到 AI 輔助落地的全方位系統塑模思維。
-->

---

<!-- _class: lead -->
<!-- header: '4.1 系統塑模基礎' -->

# **4.1 系統塑模基礎**

> "A language that doesn't affect the way you think about programming is not worth knowing."  
> — *Alan Perlis*

<!--
我們首先進入 4.1 小節：系統塑模基礎 (Foundations of System Modeling)。

在探討具體的圖表與語法之前，我們必須先釐清最根本的問題：什麼是「模型」？為什麼軟體工程師在敲代碼前必須先建立模型？以及多重視角如何幫助我們馴服軟體系統的內在複雜度？

總結這張投影片，請記住這個核心觀念：系統塑模是透過有目的的抽象化與多重視角投影，掌控軟體複雜度的核心工程方法。
-->

---

## 什麼是系統塑模？ (What is System Modeling?)

> "系統塑模是為系統開發抽象模型的過程，每個模型代表該系統不同的視角或觀點。"  
> — *Ian Sommerville, Software Engineering (10th ed.)*

- **系統塑模的核心工程原則：**
  - **抽象化 (Abstraction)：** 隱藏不必要的實作細節，突顯關鍵的架構結構、資料流動與相依關係。
  - **多重視角 (Multiple Perspectives)：** 沒有任何單一圖表能解釋整個複雜軟體；不同利害關係人需要不同的視角。
  - **溝通與驗證 (Communication & Verification)：** 作為產品經理、系統架構師、開發者與測試工程師之間的通用視覺語言。
  - **實作藍圖 (Blueprint for Implementation)：** 提供正式的結構與行為規格，作為後續編寫程式碼與資料庫結構的精確藍圖。

<!--
讓我們先建立系統塑模的根本定義。

Ian Sommerville 教授將塑模定義為建立抽象模型的過程，每個模型展現系統不同的視角。

請特別注意「抽象化」這個詞。試想：如果一張蓋房子的建築藍圖把混凝土中的每一顆分子都畫出來，工人根本不可能蓋出房子！你需要一張水電圖、一張結構圖、一張通風管線圖。

軟體工程也是完全相同的道理：沒有任何一張圖能包辦整個軟體系統，我們必須透過多種互補的視角來掌控複雜度。

總結這張投影片，請記住這個核心觀念：系統塑模透過多重視角的有目的抽象化，幫助軟體工程師全面駕馭軟體系統的複雜度。
-->

---

<!-- _class: title-image-slide -->

## 盲人摸象與多重視角模型 (The Parable of the Elephant & Multiple Perspectives)

<div class="image-wrapper">
<img src="../../img/ch04/concept/blind_men_elephant.svg" alt="盲人摸象與多重視角模型" />
</div>

<!--
這張圖是軟體工程系統塑模中最經典的哲理啟示：「盲人摸象」。

古老寓言中，摸到象鼻的盲人堅持大象像水管；摸到象腿的盲人堅信大象像粗柱；摸到象身的盲人認為大象是一堵高牆；摸到象尾的則以為是一條細繩。每個人都說對了局部事實，卻都犯了「以偏概全 (Fallacy of Composition)」的認知謬誤。

軟體系統也是如此：它本質上是龐大、複雜且無形的抽象產物。
如果你只畫類別圖，就像只摸到象腿——你掌握了靜態結構與屬性骨幹，卻看不出資料如何隨時間流動；
如果你只看循序圖，就像只摸到象鼻——你看到訊息傳遞順序，卻不知道整體系統邊界與外部依賴；
如果你只看狀態圖，就像只摸到象尾——你掌握了反應動態，卻無法反映物件資料定義。

這正是為什麼我們「絕不可能僅用一張單一圖表或模型來描述整個軟體」！
軟體工程必須從外部 (Context)、互動 (Interaction)、結構 (Structural) 與行為 (Behavioral) 四大維度協同塑模，互為佐證，才能在腦海中拼湊出架構的完整真相。

總結這張投影片，請記住這個核心觀念：任何單一模型都是系統在特定維度的局部投影，唯有綜合多重視角，才能建構完整且無盲點的軟體架構。
-->

---

## 系統塑模的 4 大核心視角 (4 Core Perspectives)

- **1. 外部視角 (External Perspective)：**
  - 塑模系統處在的運行環境、外部合作夥伴與邊界範圍。
  - 明確劃分系統邊界：哪些由內部團隊開發，哪些委託給外部第三方服務。
- **2. 互動視角 (Interaction Perspective)：**
  - 塑模外部參與者與系統之間，或是內部協同物件之間的動態溝通與訊息傳遞。
- **3. 結構視角 (Structural Perspective)：**
  - 塑模系統資料組織、類別、屬性、方法與關聯性的靜態架構，與執行時間先後無關。
- **4. 行為視角 (Behavioral Perspective)：**
  - 塑模系統的動態執行行為、業務流程步驟，以及系統針對外在事件所產生的反應式狀態轉換。

<!--
國際軟體工程規範將系統模型有條不紊地理出四大核心視角：

第一，外部視角：系統的界線劃在哪裡？外部有哪些雲端服務和人類使用者會接觸它？
第二，互動視角：參與者與物件之間在時間軸上如何相互傳遞訊息？
第三，結構視角：系統內部的靜態資料表、類別、屬性與關聯長什麼樣子？
第四，行為視角：當事件發生或執行流程啟動時，系統的狀態如何動態反應與流轉？

優秀的軟體工程師必須根據眼前的問題，精準挑選最合適的視角來思考。

總結這張投影片，請記住這個核心觀念：四大核心塑模視角分別為外部、互動、結構與行為視角。
-->

---

## 現代實務必備的 5 大 UML 核心模型

| 模型 / 圖表 | 對應章節 | 所屬視角 | 動態 / 靜態本質 | 主要軟體工程職責 |
| :--- | :---: | :--- | :--- | :--- |
| **1. 使用案例模型** | 4.3 | 互動視角 | 功能契約 | 界定系統邊界、參與者目標與系統功能範疇 |
| **2. 領域類別圖** | 4.4 | 結構視角 | 靜態骨幹 | 定義領域實體、屬性、方法與整體/部分關聯 |
| **3. 物件循序圖** | 4.5 | 互動視角 | 動態時序 | 沿時間軸追蹤訊息傳遞與 BCE 強韌性職責劃分 |
| **4. 業務活動圖** | 4.6 | 行為視角 | 動態流程 | 塑模業務流程、並行分岔/結合與跨角色泳道 |
| **5. 有限狀態機圖** | 4.7 | 行為視角 | 反應生命週期 | 捕捉事件驅動的離散狀態流轉、守衛與不變量 |

> **落實與加速：** 透過 **4.8 PlantUML** (架構即代碼) 統一實踐，各章節深度整合專屬 **AI 提示詞指引**。

<!--
在 UML 2.5 定義的 14 種圖表中，本章聚焦於構成現代軟體架構骨幹的五大不可或缺核心模型：

第一，第 4.3 節探討使用案例模型，確立功能邊界與利害關係人契約。
第二，第 4.4 節深入類別模型，定義靜態領域實體、屬性與物件關聯。
第三，第 4.5 節分析循序圖，追蹤執行期跨時間的訊息交換與邊界–控制–實體 (BCE) 分工。
第四，第 4.6 節研究活動圖，視覺化呈現業務流程、分岔/結合並行與泳道責任分配。
第五，第 4.7 節剖析狀態機圖，塑模反應式物件生命週期、離散狀態與守衛不變量。

每個模型皆深度整合專屬的 AI 提示詞指引與外送平台實戰範例，並於第 4.8 節透過 PlantUML 架構即代碼進行統整。

總結這張投影片，請記住這個核心觀念：精通這五大核心 UML 模型，即可從外部、互動、結構與行為四大維度全面具備規格化、設計與驗證複雜軟體的能力。
-->

---

### 觀念檢核測驗 1 (CCQ 1)
<!-- id: ase-ch04-ccq1 -->
<div class="ccq-columns">
<div class="ccq-text">

軟體架構師若欲定義「**領域實體資料的靜態組織方式，以及類別之間的繼承、關聯與包含關係**」（完全不隨執行時序變動），應採取哪一種塑模視角？

- **A.** 外部視角 (External Perspective)
- **B.** 互動視角 (Interaction Perspective)
- **C.** 結構視角 (Structural Perspective)
- **D.** 行為視角 (Behavioral Perspective)

</div>
<div class="ccq-logo">
    <a href="https://nlhsueh.github.io/nickedupocket/#/student/ase-ch04-ccq1" target="_blank"><img src="../../img/ch04/ase-ch04-ccq1.png" alt="QR Code" /></a>
  </div>
</div>

<!--
讓我們透過觀念檢核測驗 1 來檢驗對四大塑模視角的掌握度。

審視四大視角定義：
外部視角關注系統與環境邊界。
互動視角關注參與者與物件隨時間的訊息傳遞。
行為視角關注離散狀態轉換與動態工作流程。
結構視角則關注資料、類別、屬性與靜態關聯。

正確答案是選項 C，結構視角 (Structural Perspective)！

總結這張投影片，請記住這個核心觀念：結構模型專注於捕捉軟體靜態架構與實體關聯，不受執行時序變動影響。
-->

---

<!-- _class: lead -->
<!-- header: '4.2 統一塑模語言 (UML)' -->

# **4.2 統一塑模語言 (UML)**

> 「標準化的視覺語法，將軟體工程從封閉的方法論孤島，淬煉為全球共通的工程學門。」

<!--
現在進入 4.2 小節：統一塑模語言 (Unified Modeling Language, UML)。

在理解了塑模的哲學基礎與四大視角後，我們接著探討軟體工業界如何平息 1990 年代混亂的方法論之戰，讓 Rational 的 UML 三巨頭攜手合作，最終由 OMG 確立為全球軟體架構的通用世界語。

總結這張投影片，請記住這個核心觀念：UML 為物件導向軟體工程提供了統一且無可替代的視覺標準。
-->

---

## 標準化的迫切需求：1990 年代「方法論之戰」

- **物件導向程式設計的崛起 (1980 年代末至 1990 年代初)：**
  - 軟體產業從程序導向程式碼 (C, Pascal) 大規模轉移至物件導向典範 (C++, Smalltalk)。
  - 工程師迫切需要一套圖形符號來視覺化表達類別、物件與關聯。
- **百家爭鳴的「方法論之戰 (Method Wars)」時代：**
  - 超過 **50 種相互競爭的物件導向塑模記號**充斥商業市場。
  - 各派大師激烈爭論：類別究竟該畫成雲朵、矩形還是橢圓？繼承到底該用空心三角、實心箭頭還是虛線？
  - **嚴重的產業割裂碎片化：** 各公司之間無法交換架構模型，CASE 塑模軟體彼此互不相容，工程師換工作就得被迫重新學習一套新符號。

<!--
回到 1990 年代初期的軟體工程世界。當時軟體界正面臨嚴重的「方法論之戰」。

當時有超過 50 種記號相互廝殺：Booch 方法用雲朵表示類別，OMT 用矩形，OOSE 又是另一套。
每家公司、每套 CASE 工具都互不相容。工程師只要換一家公司，就得把以前學的繪圖記號全部作廢、從頭學起！

這種嚴重的產業內耗，催生了市場對單一、標準化視覺語言的迫切渴望。

總結這張投影片，請記住這個核心觀念：1990 年代的方法論之戰造成產業嚴重割裂，促成了 UML 標準化統一運動的誕生。
-->

---

## 統一與標準化：從 Rational 到 OMG

- **歷史性的大整合 (1994–1996)：**
  - Rational Software 公司做出重大戰略決策，先後延攬 James Rumbaugh 與 Ivar Jacobson，促成三巨頭合體。
  - 整合 Booch 方法、OMT 與 OOSE 三大主流學派，誕生 Unified Method 0.8 與 UML 0.9。
- **國際組織 OMG 官方標準化 (1997)：**
  - 1997 年 11 月，物件管理組織 (OMG, Object Management Group) 正式採納 **UML 1.1** 為國際產業標準。
  - 終結長達十年的方法論之戰，確立全球軟體架構設計的共通世界語。
- **演進至 UML 2.5 (2005–至今)：**
  - 現代 UML 2.5 包含 14 種正式圖表，分為結構圖 (Structure Diagrams) 與行為圖 (Behavior Diagrams)。

<!--
UML 的歷史轉捩點發生在 Rational Software 公司。

1994 年，Jim Rumbaugh 加入 Rational 與 Grady Booch 聯手；1995 年，Ivar Jacobson 也攜帶他的 Objectory 團隊加入。這三位原先在市場上激烈競爭的泰斗，決定放下門戶之見，合力打造一套統一的塑模語言。

1997 年，國際物件管理組織 OMG 正式將 UML 採納為全球軟體產業標準，徹底平息了混亂的方法論之戰。

總結這張投影片，請記住這個核心觀念：UML 的誕生是產業界放下紛爭、走向開放標準化的重大勝利。
-->

---

## UML 奠基先驅：Grady Booch

<div class="content-columns">
<div class="content-text">

- **角色與學術榮譽：**
  - ACM Fellow、IEEE Fellow、IBM 院士、Rational 共同創辦人兼首席科學家。
- **開創經典方法論：**
  - **Booch 方法 (Booch Method)** 與重量級專書：《物件導向分析與設計》。
- **對 UML 的核心貢獻：**
  - 專精於**物件導向實作設計 (Design & Implementation)**，精確定義微觀物件協同與宏觀系統架構。
  - 賦予 UML 精準對應至 C++、Java 等 OOP 程式語言的實作直譯能力。
- **著名軟體工程箴言：**
  > *"良好的架構，是讓未來的重大決策顯得容易且自然的藝術。"*

</div>
<div class="content-figure">

<div class="name-card">
<img src="../../img/ch04/portraits/grady_booch.jpg" alt="Grady Booch" />
<div class="name-card-caption">
<span class="name-card-name">Grady Booch</span>
<span class="name-card-cc"><a href="https://en.wikipedia.org/wiki/Grady_Booch" target="_blank">Rational Software / IBM Fellow</a></span>
</div>
</div>

</div>
</div>

<!--
讓我們認識第一位靈魂人物：Grady Booch。

Booch 是軟體架構領域的傳奇大師。他在 1980 年代推動 Ada 與 C++ 的物件導向設計，他的著作是無數架構師的案頭聖經。

Booch 的核心貢獻在於「微觀設計與實作對應」：他確保 UML 上的每一個符號、每一個關聯，都能夠直接對應到 C++ 或 Java 的真實程式碼結構。

總結這張投影片，請記住這個核心觀念：Grady Booch 為 UML 注入了與物件導向程式碼深度對齊的微觀設計與架構哲學。
-->

---

## UML 奠基先驅：James Rumbaugh

<div class="content-columns">
<div class="content-text">

- **角色與學術榮譽：**
  - 奇異公司 (GE) 全球研發中心軟體主任研究員、Rational Software、IBM。
- **開創經典方法論：**
  - **物件塑模技術 (OMT, Object Modeling Technique)** 與專書：《物件導向塑模與設計》。
- **對 UML 的核心貢獻：**
  - 強調嚴謹的**領域分析 (Domain Analysis)**、語義資料塑模與實體關聯對應。
  - 首創將靜態物件結構與 David Harel 的**狀態圖 (Statecharts)** 深度結合，用以塑模動態反應式系統。
- **著名軟體工程箴言：**
  > *"如果不透徹理解領域的真實本質，就絕不可能打造出卓越的軟體。"*

</div>
<div class="content-figure">

<div class="name-card">
<img src="../../img/ch04/portraits/james_rumbaugh.jpg" alt="James Rumbaugh" />
<div class="name-card-caption">
<span class="name-card-name">James Rumbaugh</span>
<span class="name-card-cc"><a href="https://en.wikipedia.org/wiki/James_Rumbaugh" target="_blank">GE Research / Rational Software</a></span>
</div>
</div>

</div>
</div>

<!--
認識第二位巨頭：James Rumbaugh 博士。

Jim Rumbaugh 早年在奇異公司企業研發中心帶領軟體技術研究。他所創立的 OMT 方法，被業界公認為數學結構最嚴謹的分析方法論。

Rumbaugh 的天才在於領域分析——精確捕捉真實世界的實體、資料庫關聯與狀態機。當 Rumbaugh 與 Booch 攜手時，正好在「分析領域問題」與「設計軟體架構」之間架起完美的平衡木。

總結這張投影片，請記住這個核心觀念：James Rumbaugh 為 UML 奠定了嚴謹的領域分析、資料關聯與狀態圖塑模根基。
-->

---

## UML 奠基先驅：Ivar Jacobson

<div class="content-columns">
<div class="content-text">

- **角色與學術榮譽：**
  - 愛立信 (Ericsson) 首席架構師、Objectory AB 創辦人、Rational Software、SEMAT 發起人。
- **開創經典方法論：**
  - **物件導向軟體工程 (OOSE)**。
- **對 UML 的核心貢獻：**
  - **使用案例 (Use Cases) 的發明者 (1986)：** 革命性地將系統架構錨定在可衡量的使用者目標之上。
  - 提出經典的**邊界–控制–實體 (BCE, Boundary–Control–Entity)** 強韌性分析模式與元件化架構。
- **著名軟體工程箴言：**
  > *"一個沒有使用者的系統，就沒有任何存在的理由。塑模永遠要先從使用者的目標開始。"*

</div>
<div class="content-figure">

<div class="name-card">
<img src="../../img/ch04/portraits/ivar_jacobson.jpg" alt="Ivar Jacobson" />
<div class="name-card-caption">
<span class="name-card-name">Ivar Jacobson</span>
<span class="name-card-cc"><a href="https://en.wikipedia.org/wiki/Ivar_Jacobson" target="_blank">Ericsson / Objectory / Rational</a></span>
</div>
</div>

</div>
</div>

<!--
認識第三位巨頭：Ivar Jacobson 博士。

Jacobson 早年在愛立信研發龐大的電話交換機系統，後來創立 Objectory 公司。他在 1986 年發明了「使用案例 (Use Cases)」。

在 Jacobson 之前，軟體需求大多是一篇篇生硬枯燥的條文式功能規格。Jacobson 徹底顛覆了這個視角，把焦點拉回人類使用者身上：究竟是「誰」在用系統？他們想達成什麼「商業目標」？他還提出了至今仍主導架構設計的 BCE 模式。

總結這張投影片，請記住這個核心觀念：Ivar Jacobson 發明了使用案例與 BCE 模式，讓軟體架構真正以使用者目標為依歸。
-->

---

## UML 三巨頭：軟體塑模的三位一體 (The Trinity of Modeling)

<div class="three-columns">
<div class="card">
<h3>Ivar Jacobson</h3>
<h4>核心回答「Why」(目標 / 使用者)</h4>
<ul>
<li><b>使用案例驅動：</b> 外部參與者想達成什麼目標？</li>
<li><b>BCE 強韌性分析：</b> 徹底分離 UI 邊界與核心資料實體。</li>
<li><b>元件契約規範：</b> 可重用子系統的架構邊界。</li>
</ul>
</div>
<div class="card">
<h3>James Rumbaugh</h3>
<h4>核心回答「What」(領域與資料)</h4>
<ul>
<li><b>領域物件分析：</b> 現實世界存在哪些核心概念？</li>
<li><b>類別與資料綱要：</b> 結構化的實體關聯關係。</li>
<li><b>有限狀態機：</b> 反應式事件驅動的生命週期。</li>
</ul>
</div>
<div class="card">
<h3>Grady Booch</h3>
<h4>核心回答「How」(設計與程式碼)</h4>
<ul>
<li><b>物件導向設計：</b> 類別之間如何精巧協同運作？</li>
<li><b>巨觀架構拆解：</b> 分層模組與相依性控制。</li>
<li><b>實作直譯對應：</b> 視覺模型與 OOP 程式碼直接對齊。</li>
</ul>
</div>
</div>

> 📌 **架構整合精髓：** Jacobson 捕捉系統存在的**初衷目的 (Why)**；Rumbaugh 塑模領域存在的**資料本質 (What)**；Booch 設計程式執行的**實作架構 (How)**。

<!--
請大家細細體會三巨頭之間天衣無縫的互補之美：

Ivar Jacobson 從使用者視角回答了「為什麼 (Why)」系統需要存在。
James Rumbaugh 梳理問題領域，回答了存在哪些資料實體的「本質 (What)」。
Grady Booch 規劃軟體架構，回答了這些元件在程式碼中如何高效運行的「作法 (How)」。

三巨頭的合體不僅成就了 UML，更奠定了 Rational 統一流程（RUP）等現代軟體工程方法的基石。

總結這張投影片，請記住這個核心觀念：UML 完美融合了使用者目標 (Why)、領域資料 (What) 與程式架構 (How) 的三位一體。
-->

---

### 觀念檢核測驗 2 (CCQ 2)
<!-- id: ase-ch04-ccq2 -->
<div class="ccq-columns">
<div class="ccq-text">

在被尊稱為「UML 三巨頭」的軟體工程大師中，哪一位以於 1986 年發明**使用案例 (Use Cases)**、將軟體架構直接錨定於使用者具體目標而聞名？

- **A.** Grady Booch
- **B.** James Rumbaugh
- **C.** Ivar Jacobson
- **D.** Martin Fowler

</div>
<div class="ccq-logo">
    <a href="https://nlhsueh.github.io/nickedupocket/#/student/ase-ch04-ccq2" target="_blank"><img src="../../img/ch04/ase-ch04-ccq2.png" alt="QR Code" /></a>
  </div>
</div>

<!--
讓我們透過觀念測驗 2 來檢驗對 UML 發展史的理解。

檢視各個選項：
Grady Booch 開創了 Booch 方法，主攻物件導向設計與程式碼映射。
James Rumbaugh 開發了 OMT 方法，專精領域分析與物件狀態模型。
Martin Fowler 則是撰寫《UML 精華 (UML Distilled)》與《重構》的大師，但他並非三巨頭成員。

正確答案是 C：Ivar Jacobson！Jacobson 於 1986 年在愛立信提出使用案例，徹底將軟體架構引導向以使用者目標為核心的典範。

總結這張投影片，請記住這個核心觀念：Ivar Jacobson 發明了使用案例，將需求與架構聚焦於使用者具體目標。
-->

---

<!-- _class: lead -->
<!-- header: '4.3 功能與使用案例模型' -->

# **4.3 功能與使用案例模型**

> "使用案例是系統與其參與者之間為了達成可衡量業務目標所簽署的行為契約。"  
> — *Alistair Cockburn*

<!--
我們現在進入第 4.3 節：功能與使用案例模型。

在物件導向分析中，使用案例圖是系統對外部世界的「功能性契約」。它定義了系統的邊界：誰會使用系統？他們試圖達成什麼商業目標？哪些功能是內部開發的，哪些功能委託給第三方外部服務？

在這一節中，我們將透過精緻的視覺圖解，逐步掌握參與者、系統邊界、include 與 extend 關聯的正確用法，並學習如何撰寫正式的使用案例規格書與 AI 提示詞。

總結這張投影片，請記住這個核心觀念：使用案例模型是連結非技術利害關係人與工程團隊之間最關鍵的高階功能視覺契約。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_use_case/01_anatomy_of_use_case_modeling.jpg" alt="The Anatomy of Use-Case Diagram Modeling" />
</div>

<!--
請看這張入門指南：『UML 使用案例圖塑模新手指南』。

大家看畫面上最基礎的三個符號：一個人形符號（代表外部參與者）、一個橢圓（代表使用案例），以及連接兩者的一條實線。

這張圖解決了軟體工程中的大難題。我們不需要去讀動輒幾十頁的繁複文字，透過簡單直觀的圖形，所有人一眼就能看出：誰在用系統？他們想做什麼？彼此如何互動？

總結這張投影片，請記住這個核心觀念：使用案例圖能將抽象繁複的文字需求，轉化為直觀清晰的系統設計。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_use_case/02_business_value_and_user_goals.jpg" alt="Focus: Business Value & User Goals" />
</div>

<!--
請看畫面上的三個卡片。

左邊卡片指出塑模的焦點：商業價值與使用者目標。我們必須問：使用者到底想完成什麼事？例如『預訂航班』或『下單訂餐』。

中間藍色卡片是黃金法則：永遠從專案利害關係人的視角出發，而不是從程式設計師的視角！

右邊卡片提醒排除項：絕對不要畫資料流、功能分解或資料庫處理細節。不要把『輸入密碼』或『點擊按鈕』這種內部操作畫成使用案例。

總結這張投影片，請記住這個核心觀念：聚焦於使用者想要達成的商業目標，而非內部的技術實作細節。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_use_case/03_actor_taxonomy.jpg" alt="Actor Taxonomy" />
</div>

<!--
請看畫面上的四個標註框，這正是構成使用案例圖的四大核心基石。

左上角是『參與者 (Actor)』：人形符號，代表與系統互動的外部實體，可以是真人、組織、第三方系統，甚至是定時排程器。

右上角是『使用案例 (Use Case)』：橢圓形，代表能為參與者交付具體可衡量價值的一連串動作。

左下角是『關聯 (Relationship)』：連線，表達參與者與使用案例之間的互動、相依或繼承關係。

右下角是『系統邊界 (System Boundary)』：灰色外框，清楚界定什麼屬於系統內部開發範圍，什麼屬於外部環境。

總結這張投影片，請記住這個核心觀念：使用案例圖由四大元素構成：參與者、使用案例、關聯線與系統邊界。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_use_case/04_relationship_matrix.jpg" alt="Relationship Matrix: Association, Include, Extend, Generalization" />
</div>

<!--
這張表格整理了 UML 中四種最核心的關聯與生活比喻：

第一行是『關聯 (Association)』：實線，代表參與者參與某個目標。就像顧客走進實體商店。

第二行是『<<include>> 包含』：虛線箭頭，代表每次必執行的強制共用邏輯。就像在結帳 checkout() 時，一定會呼叫 calculateTax() 計算稅金。

第三行是『<<extend>> 擴充』：虛線箭頭，代表特定條件觸發的可選邏輯。就像符合優惠資格時彈出折價券，或者例外錯誤處理。

第四行是『泛化 (Generalization)』：實線帶空心三角箭頭，代表『是一種 (is-a)』的繼承關係。例如國際學生也是一種學生，但具備額外的居留手續。

總結這張投影片，請記住這個核心觀念：牢記關聯差異：include 是強制必跑，extend 是條件可選，泛化則是角色繼承。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_use_case/05_clear_naming_semantics.jpg" alt="Clear Semantics: Strong Verbs & Singular Roles" />
</div>

<!--
使用案例與參與者該如何正確命名？

請看左邊綠色打勾的良好實踐：使用案例一律以『強動詞 + 領域名詞』開頭，例如『提領資金』、『配送貨物』。參與者一律使用單數角色名稱，如『客服專員』，且泛化必須通過『is-like』常理測試。

再看右邊紅色叉叉的壞味道：避免使用弱動詞，如『處理』、『執行』或『做』。嚴禁出現技術黑話，如『Process_DB』，且不要使用企業內部 HR 職稱，如『初階專員』。要塑模角色，而非辦公室抬頭！

總結這張投影片，請記住這個核心觀念：使用案例採用強動詞加名詞命名，參與者採用單數角色名稱。
-->


---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_use_case/07_safe_nesting_limits.jpg" alt="Safe Nesting Limits: Avoid Over-Engineering" />
</div>

<!--
請看這張投影片提示的三大防護原則，讓你的圖表保持乾淨清晰：

第一，最上方的儀表板：『最多兩層嵌套』。切勿層層 include（如 A 包含 B、B 又包含 C），否則會讓圖表退化成雜亂的流程圖！

第二，中間卡片：『嚴禁人連人』。參與者之間絕不可直接連線。現實中人跟人講話的互動，請寫在文字規格書中。

第三，下方卡片：『有目的地使用邊界框』。利用邊界框劃定系統範圍或不同交付階段（第一期、第二期）。

另外注意最底部的提示：用 <<system>> 標示外部系統，用時鐘圖示代表定時排程。

總結這張投影片，請記住這個核心觀念：限制嵌套深度在兩層內，禁止參與者互連，並有目的地劃定系統邊界。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_use_case/08_case_study_enrollment_system.jpg" alt="Case Study: University Enrollment System" />
</div>

<!--
讓我們透過具體案例來演練：大學選課系統。

這張投影片先將系統清楚拆解為左右兩大欄位：『Who（誰）』與『What（做什麼）』。

左邊是參與者：包括一般『學生 (Student)』作為主要參與者、具備特殊資格的『國際學生 (International Student)』，以及定時排程的『時間 (Time)』。

右邊是四個核心使用案例：『學生選課』、『選修研討課』、『執行安全查核』與『提交學費報告』。

在下一張投影片中，我們將把這兩邊完整串接起來！

總結這張投影片，請記住這個核心觀念：在連線之前，先清楚盤點系統中『誰參與 (Who)』與『做什麼 (What)』。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_use_case/09_actor_generalization.jpg" alt="Actor Generalization: Specializing Roles in Hierarchies" />
</div>

<!--
現在請看整合後的完整模型！跟著右側藍圖圖例的橘色編號一步步對照：

編號 1 是『泛化 (Generalization)』：空心箭頭代表國際學生繼承自一般學生，擁有基礎選課的所有權限。

編號 2 是『<<include>> 包含』：箭頭從學生選課指向選修研討課，代表選課時強制包含修習研討課。

編號 3 是『<<extend>> 擴充』：箭頭從執行安全查核指回學生選課，代表僅在特定條件下（如國際學生身分）才觸發安全查核。

編號 4 是『時間參與者 (Time)』：右邊的時鐘圖示每個月定時觸發『提交學費報告』。

總結這張投影片，請記住這個核心觀念：這張圖完整示範了泛化、包含、擴充與定時排程四大觀念在實務系統中的協同運作。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_use_case/10_common_anti_patterns.jpg" alt="Common Anti-Patterns in Use Case Modeling" />
</div>

<!--
這張表格條列了初學者最常犯的四大錯誤、失敗原因與修正對策：

第一項：技術名稱（如 Process_DB_Transaction）。非技術利害關係人看不懂。修正：改用領域名稱（提領資金、產出報表）。

第二項：用箭頭畫資料流。關聯線只代表參與，不是資料搬運。修正：移除箭頭，改畫簡單實線。

第三項：濫用 <<extend>>。滿天飛的虛線箭頭會讓圖形變成蜘蛛網。修正：將次要條件移至文字規格書。

第四項：直接把顧客連到管理員。參與者之間不直接連線。修正：把人與人之間的溝通移到文字情境中敘述。

總結這張投影片，請記住這個核心觀念：避免技術命名、資料流箭頭與人連人連線，維持模型清爽精煉。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_use_case/11_best_practices_checklist.jpg" alt="Best Practices Checklist" />
</div>

<!--
在向團隊展示使用案例圖之前，請逐項檢查這九個方塊：

1. 是否使用了強動詞加領域名詞？
2. 參與者是否使用單數角色名稱，而非職稱？
3. 主要參與者是否放置在左上方？
4. 所有參與者是否都在系統邊界框之外？
5. <<include>> 是否嚴格限定於強制執行步驟？
6. <<extend>> 是否嚴格限定於可選或條件步驟？
7. 泛化繼承是否通過常理邏輯檢驗？
8. 參與者之間是否有零連線？
9. 詳細的擴充條件是否保留在文字規格中？

全數通過，代表你的模型具備高度專業品質！

總結這張投影片，請記住這個核心觀念：將這九項檢核清單作為正式交付前不可或缺的品質把關標準。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_use_case/12_communication_first_mindset.jpg" alt="Communication-First Mindset: Bridges Between Stakeholders and Engineers" />
</div>

<!--
總結本單元的核心精神：擁抱『溝通優先 (Communication-First)』思維。

請看畫面中的三個圓圈：開發者、設計師與業務團隊。三者重疊的最核心交集，就是使用案例圖——它是共用的視覺語言，也是全團隊的單一真實來源。

記住周圍的三句箴言：
使用案例圖是溝通工具，不是技術施工藍圖！
敏捷塑模核心實踐：簡單呈現模型。
如果某個細節無法幫助利害關係人理解系統目的，就毫不猶豫地從圖上拿掉！

總結這張投影片，請記住這個核心觀念：使用案例圖的最高價值，是作為凝聚開發者、設計師與業務端共識的溝通媒介。
-->

---

## 使用案例規格書：UC-01 學生選課 (Enroll Student)

| 欄位名稱 | 規格細節說明 |
| :--- | :--- |
| **使用案例代號 / 名稱** | **UC-01：學生選課 (Enroll Student in Course)** |
| **主要參與者 (Actor)** | 學生 (透過學校單一登入 SSO 驗證身分) |
| **前置條件 (Preconditions)** | 學生具備有效學籍在學狀態；當前處於選課開放時段內 |
| **後置條件 (Postconditions)** | 學生正式納入該課程名冊；該課程剩餘修課名額自動扣減 1 |
| **主要成功路徑 (Main Flow)** | **1.** 學生依學系代碼或開課課號搜尋開放修習的課程清單。<br>**2.** 系統回傳並展示符合條件的班級資訊、上課時間表與剩餘名額。<br>**3.** 學生選定目標課程，向系統提出正式加選請求。<br>**4.** 系統執行 `<<include>> 檢查先修科目資格`，比對學生歷史歷年成績單。<br>**5.** 系統鎖定保留名額，寫入選課交易紀錄，並產生成員確認通知單。<br>**6.** 學生即時檢視個人更新後的課表，並收到選課成功通知信。 |
| **例外與擴充路徑 (Extensions)** | **4a. 先修科目未通過：** 系統提示未修畢之必要擋修科目代碼，中斷選課流程。<br>**4b. 上課時間衝堂：** 系統發出警告，提示與已選課程時間重疊，放棄本次加選。<br>**5a. 課程名額已滿：** 系統觸發 `<<extend>> 加入候補等候名單` 流程。 |

<!--
使用案例圖只是一張高階目錄，真正嚴謹的行為合約完整記錄在使用案例規格書中！

大家請看「UC-01 學生選課」的標準 Cockburn 規格書結構：
主要參與者是通過驗證的學生。
前置條件確保學籍有效且選課系統開放。
後置條件保證交易成功後名額扣減並登記在冊。

請特別注意主要成功路徑的第 4 步：它正式宣告並調用了被包含的子使用案例「檢查先修科目資格」。
在例外路徑中，清楚規範了擋修、衝堂與額滿時的處理方式。

總結這張投影片，請記住這個核心觀念：使用案例規格書以條理化的對話步驟、前置後置條件與例外處理，賦予圖表實質的工程合約約束力。
-->

---

## AI 輔助指南：使用案例塑模 (Use Case Modeling)

- **1. 角色設定與系統邊界約束 (Persona & Boundary Priming)：**
  - 指示 AI 扮演「精通 UML 2.5 國際標準的資深需求分析師」。
  - **嚴格要求宣告邊界：** 必須先定義 `rectangle "System Name"`，禁止 AI 將外部雲端服務混入內部邊界。
- **2. 參與者與關聯性嚴格語義規範：**
  - **參與者分類：** 要求 AI 區分「主要參與者 (人)」與「次要外部支援服務 (金流 API、簡訊服務)」。
  - **`<<include>>` 規則：** 僅用於「每次下單必執行的強制共用子流程」。
  - **`<<extend>>` 規則：** 僅用於「具備特定觸發條件的可選附加行為」，並指明擴充點。
  - **反模式防護：** 嚴禁功能分解（禁止產生「點擊按鈕」、「輸入密碼」等瑣碎泡泡）。
- **3. 架構師人工審查清單 (Verification Checklist)：**
  - [ ] 每個使用案例是否皆以「動詞 + 受詞」命名（如 `下單訂購`、`追蹤外送`）？
  - [ ] 第三方基礎設施（金流閘道、簡訊）是否正確置於系統邊界外側？
  - [ ] include 箭頭是否正確指向被包含的共用功能？

<!--
使用生成式 AI 輔助產生使用案例圖時，精確的 Prompt 約束是成敗關鍵。

大型語言模型在沒有足夠指引時，最容易犯三個經典錯誤：
第一，功能分解過細，把按鈕點擊畫成使用案例；
第二，混淆 include 與 extend，把可選的功能畫成強制包含；
第三，把外部系統（如綠界金流）畫在系統邊界裡面。

透過設定專業角色、強制劃定矩形邊界與關聯語義規則，能讓 AI 在秒級內產出專業合規的模型代碼。

總結這張投影片，請記住這個核心觀念：引導 AI 產生使用案例圖時，必須嚴格約束系統邊界、動詞命名與 include/extend 語義邊界。
-->

---

## AI 提示詞範例：外送平台使用案例模型

<div class="two-columns">
<div>

**1. 角色設定與任務指令：**
```text
你是一位資深系統分析架構師。
請根據以下需求描述，產生合規且簡練的
PlantUML 使用案例圖與使用案例規格書。
```

**2. 塑模約束條件：**
- 使用 `<<extends>>` 與 `<<includes>>` 建構模組化關係。
- 嚴禁功能分解（禁止出現「點擊按鈕」、「輸入密碼」等瑣碎用例）。
- 以 `rectangle "校園外送平台"` 劃定系統邊界。
- 外部金流閘道與簡訊服務置於邊界外作為次要參與者。

</div>
<div>

**3. 輸入需求敘述 (Requirements Statement)：**
> 「顧客可以在平台瀏覽餐廳菜單、將餐點加入購物車並進行結帳下單。
> 顧客下單時，系統必須強制連線外部**金流閘道**授權扣款，並驗證外送地址有效性。
> 結帳時，顧客可以自由選擇是否套用優惠券代碼 (`套用折扣優惠`)，或勾選放置門口的無接觸配送。
> **餐廳員工**可接收並審核進單、更新廚房備餐進度。
> **外送員**可承接外送任務、回報餐點取件與最終送達。
> 當訂單狀態變更時，系統會自動呼叫外部**簡訊服務**向顧客發送即時通知。」

</div>
</div>

<!--
這是一個標準的工業級 AI 提示詞範例。

在左側，我們給予 AI 明確的工程角色、輸出格式約束以及嚴格的語義規則：
要求必須用矩形宣告系統邊界，把金流與簡訊放在邊界外側，並明確指派 include 與 extend 的使用場景。

在右側，我們輸入一段結構化的外送平台商業需求。

AI 接收到這份提示詞後，即可直接輸出標準的 PlantUML 代碼，完全不需要人工反覆除錯。

總結這張投影片，請記住這個核心觀念：提供明確的邊界規則、參與者角色與關聯語意約束，能讓 AI 精準產出符合企業規範的使用案例圖。
-->

---

### 課堂互動討論：外送平台使用案例邊界 (雙人同儕討論)

<div class="discussion-columns">
  <div class="discussion-text">

  **雙人同儕討論：外送平台範疇界定與使用案例關聯**
  - **工程情境：** 團隊正在為外送平台（如 UberEats/Foodpanda）設計功能使用案例模型。
  - **參與角色：** 顧客、餐廳廚房人員、外送員、第三方金流閘道。
  - **與鄰座同學討論（限時 3 分鐘）：**
    1. 找出 2 個具備 `<<include>>` 關聯的使用案例（例如：*結帳下單* 必然包含 *處理信用卡支付*）。
    2. 找出 1 個適合使用 `<<extend>>` 關聯的情境，並說明其擴充點（例如：*套用促銷折扣碼* 或 *選擇無接觸送餐*）。
    3. 外部「金流閘道 (Payment Gateway)」應放在系統邊界框內部還是外部？為什麼？

  </div>
  <div class="discussion-logo">
    <img src="../../img/ch04/icons/discussion_icon.svg" alt="Discussion Icon" />
  </div>
</div>

<!--
讓我們在此進行 Section 4.3 的雙人同儕討論：外送平台的使用案例邊界！請轉頭與身旁的同學組成架構諮詢小組。

請看螢幕上的三個討論題目：
第一，找出兩個必然包含的 include 關聯。例如：只要顧客按下確認下單，系統就必須強制處理付款與地址驗證。
第二，找出一個 extend 擴充情境。什麼時候行為是選擇性或條件觸發的？例如套用折扣券。
第三，探討系統邊界：金流閘道應該畫在框內還是框外？

花三分鐘與你的夥伴討論這三個問題。

參考解答與架構復盤：
1. Include：『結帳下單』include『授權扣款處理』與『驗證購物車清單』，因為缺少這兩者訂單無法合法成立。
2. Extend：『套用優惠碼』extend『結帳下單』，僅在顧客主動輸入優惠代碼時觸發。
3. 系統邊界：金流閘道屬於第三方外部服務，由銀行或 Stripe 維運，非內部開發程式碼，必須明確置於邊界框外。

總結這張投影片，請記住這個核心觀念：使用案例模型劃定系統責任範圍，並清晰分離基底核心邏輯與選擇性擴充行為。
-->

---

### 觀念檢核測驗 3 (CCQ 3)
<!-- id: ase-ch04-ccq3 -->

<div class="ccq-columns">
<div class="ccq-text">

在 UML 使用案例模型中，若使用案例 A 與使用案例 B 之間存在 **`<<include>>`** 關聯（A 指向 B），這在軟體架構上代表什麼意義？

- **A.** 使用案例 B 是選擇性的，僅在特定異常狀況下才會由 A 觸發執行。
- **B.** 每當使用案例 A 執行時，使用案例 B 所定義的行為「必定且強制」會被納入執行。
- **C.** 使用案例 A 繼承了使用案例 B 的所有屬性與操作方法。
- **D.** 使用案例 B 是外部第三方系統，不屬於軟體邊界範疇。

</div>
<div class="ccq-logo">
    <a href="https://nlhsueh.github.io/nickedupocket/#/student/ase-ch04-ccq3" target="_blank"><img src="../../img/ch04/ase-ch04-ccq3.png" alt="QR Code" /></a>
  </div>
</div>

<!--
讓我們透過觀念檢核測驗 3 來驗收對使用案例關聯的理解。

題目問的是：A include B 代表什麼？
檢視各選項：
選項 A 是 extend 的定義（選擇性條件觸發）。
選項 C 是泛化繼承的觀念。
選項 D 混淆了外部參與者的概念。

正確答案是 B！當 A 包含 B 時，代表 B 是 A 不可分割且必然會執行的共用子程序。

總結這張投影片，請記住這個核心觀念：Include 關聯代表強制執行的共用子流程，而 Extend 則是條件式的擴充行為。
-->

---

<!-- _class: lead -->
<!-- header: '4.4 結構與類別模型' -->

# **4.4 結構與領域類別模型**

> "類別圖是軟體系統的靜態建築骨幹；如果骨幹畸形，任何敏捷開發都拯救不了系統的崩潰。"

<!--
我們現在進入第 4.4 節：結構與領域類別模型。

如果說使用案例回答了系統「為了什麼目標而存在」，那麼類別圖回答的就是系統「由哪些靜態實體與資料結構所構成」。
類別圖是物件導向程式碼與關聯式資料庫結構的直接投影。

在這一節中，我們將深入剖析類別的三格解剖結構、可見度資訊隱藏、多種關聯性、整體與部分（聚合與組合）的生命週期相依，以及如何引導 AI 精確產生領域模型。

總結這張投影片，請記住這個核心觀念：類別圖奠定系統靜態物件導向架構與資料實體的堅實骨幹。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_class/01_anatomy_of_uml_class_diagrams.jpg" alt="The Anatomy of UML Class Diagrams" />
</div>

<!--
請看這幅精緻的架構對照圖：『UML 類別圖解剖學』。

請大家特別看畫面右側這棟建築物的等角透視圖。把軟體想像成一棟實體建築：
中間貫穿上下的核心支柱是 System Core（系統核心基礎）；
旁邊設有伺服器機櫃的房間是 Data Vault（資料庫管理者 DatabaseManager）；
屋頂架著天線的通訊管制室是 Communications Hub（網路控制器 NetworkController）；
而正面的大門和落地窗則是 Public Interface（使用者介面 UserInterface）。

再看右下角的對照小表格：
類別就像一個個房間，屬性就像房間的尺寸規格，操作就是房間裡發生的活動，而關聯線就是連接各個房間的走廊與通道！
左邊則是這棟建築物在 UML 類別圖中的標準表示法。

總結這張投影片，請記住這個核心觀念：類別圖就像建築藍圖：類別是房間，而關聯線就是連接彼此的走廊。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_class/02_blueprint_vs_instance.jpg" alt="Blueprint vs Instance: The Foundation of OOD" />
</div>

<!--
這是物件導向設計最根本的核心概念：『藍圖 (Blueprint) vs. 實例 (Instance)』。

請看左邊小狗的工程藍圖：這就是**類別 (Class)**。它定義了所有狗共有的特徵：屬性有顏色、名字與品種；行為有搖尾巴、吠叫與吃東西。但請記住：你沒辦法撫摸一張藍圖！

再看右邊貼著的三張拍立得照片：這些才是**物件 (Objects)**！
分別是黃金獵犬 Buddy、巴哥犬 Max，以及貴賓犬 Daisy。
牠們都是從同一張狗藍圖打造出來的，但每一隻在現實世界中都擁有各自具體的顏色、名字與狀態。

總結這張投影片，請記住這個核心觀念：類別是設計藍圖，而物件是依據藍圖在記憶體中生成的真實實例。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_class/03_three_perspectives_of_class_modeling.jpg" alt="The Three Perspectives of Class Modeling" />
</div>

<!--
請看頂部橫跨時間軸的三個欄位：類別塑模的三重視角。

左邊是**概念視角 (Conceptual)**：專案剛開始時，我們只關心大方向的業務名詞，畫出簡單的 User 與 Product 方塊，不涉及任何技術細節。

中間是**規格視角 (Specification)**：進入軟體分析階段，我們開始定義介面與型態（例如 login 方法與 price 屬性），定義軟體『做什麼』，但不綁定特定程式語言。

右邊是**實作視角 (Implementation)**：進入工程編碼階段，直接對齊真實程式碼，精確宣告 private 欄位、參數資料型態與方法實作。

總結這張投影片，請記住這個核心觀念：隨著開發進程推進，類別圖會從高階概念演進為軟體規格，最終落實為精確的程式碼結構。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_class/04_anatomy_of_class_box.jpg" alt="Anatomy of the Class Box" />
</div>

<!--
請看畫面中央立體拆解的三層三明治：『類別方塊解剖學』。每個標準的 UML 類別方塊都包含這三層結構：

最上層（藍色）：**類別名稱 (Class Name)**。這是唯一必填的資訊，例如 Customer。

中間層（橘色）：**屬性 (Attributes)**。用來儲存物件狀態，例如 name 與 email。請注意冒號後面標註的是資料型態，如 `name : String`。

最下層（紅色）：**操作與方法 (Operations / Methods)**。代表類別能對外提供的服務，例如 `calculateTotal()`。冒號後面則是回傳型態 `: double`。

總結這張投影片，請記住這個核心觀念：標準類別方塊由三層構成：頂層名稱、中層屬性資料，以及底層操作方法。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_class/05_visibility_matrix.jpg" alt="The Visibility Matrix" />
</div>

<!--
我們如何在類別中保護資料？請看『可見度矩陣 (Visibility Matrix)』。在 UML 中，我們在屬性或方法前方加上前綴符號：

第一行：**加號 (+)** 代表 **Public（公開）**。任何人都可以直接存取，對應右邊程式碼 `public String name;`。

第二行：**減號 (-)** 代表 **Private（私有）**。只有該類別內部才能存取。在良好的物件導向設計中，屬性幾乎都應該是私有的！

第三行：**井號 (#)** 代表 **Protected（保護）**。外部無法存取，但繼承它的子類別可以使用。

對照右側的程式碼範例，這些符號完美對應大家熟悉的 Java 或 C++ 關鍵字！

總結這張投影片，請記住這個核心觀念：屬性一律私有使用減號 (-)，公開服務使用加號 (+)，繼承保護使用井號 (#)。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_class/06_parameter_directionality.jpg" alt="Parameter Directionality Dashboard" />
</div>

<!--
請看這張儀表板中圍繞在方法方塊周圍的三色箭頭：參數方向性指示。

左上角的藍色箭頭標示 **in**：這是最常見的輸入參數，呼叫端把資料傳進來，方法僅讀取使用。

下方的黃色彎曲箭頭標示 **inout**：資料傳入方法，在內部被修改後，再把更新結果傳回給呼叫端。

右下角的紅色箭頭標示 **out**：方法產生或計算出全新資料，並透過參數輸出傳回給呼叫端。

在串接底層 API、遠端微服務或硬體介面時，這些指示能消除資料流動方向的歧義。

總結這張投影片，請記住這個核心觀念：參數方向標籤明確定義資料流向：in 為輸入、out 為輸出、inout 為雙向修改。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_class/07_taxonomy_of_relationships.jpg" alt="Taxonomy of Relationships" />
</div>

<!--
請看橫跨畫面頂部的藍色光譜橫尺：『關聯光譜 (Taxonomy of Relationships)』。它呈現了類別之間從最鬆散到最緊密的四種結構強度：

最左端是**依賴 (Dependency)**：Class A 僅短暫借用 Class B（例如作為方法參數），彼此毫無擁有權。

往右是**普通關聯 (Association)**：兩個類別彼此認識並持有參考，例如顧客關聯到訂單。

再往右是**聚合 (Aggregation)**：弱整體關係，但部分可以獨立存活，例如圖書館擁有藏書。

最右端是**組合 (Composition) 與泛化繼承**：最緊密的生死關係。在組合中，整體消亡，部分隨之連帶毀滅；在繼承中，子類別嚴格繼承父類別的所有特徵。

總結這張投影片，請記住這個核心觀念：類別關聯橫跨連續光譜：從左側短暫借用的依賴，到右側生死相依的組合。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_class/08_connector_cheat_sheet.jpg" alt="The Connector Cheat Sheet" />
</div>

<!--
這是一張讓大家考試與實作隨身必備的『連線符號速查表』。四個象限區分得非常清楚：

左上象限：**繼承 (Inheritance)**。實線搭配空心三角箭頭指向父類別，代表『是一種 (is-a)』。

右上象限：**實現 (Realization)**。虛線搭配空心三角箭頭指向介面，代表具體類別實現了介面合約。

左下象限：**依賴 (Dependency)**。虛線搭配開放箭頭，代表短暫的『uses 使用』關係。

右下象限：**一般關聯 (Simple Association)**。一條單純的實線，代表兩個對等類別之間的結構連線。

總結這張投影片，請記住這個核心觀念：精確分辨實線與虛線、空心三角與開放箭頭，避免傳達錯誤的依賴語義。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_class/09_aggregation_vs_composition.jpg" alt="Lifecycle Diagnostic: Aggregation vs. Composition" />
</div>

<!--
現在深入探討軟體工程最經典的考題：聚合 (Aggregation) 與組合 (Composition) 的差異。

請看左欄：**聚合**使用**空心菱形 (◇)**。代表『包含 (part-of)』，但生命週期各自獨立。看生活比喻：球隊與球員。如果球隊今天解散了，球員依然存在，可以加入其他球隊！

再看右欄：**組合**使用**實心菱形 (◆)**。這是嚴格的強包含與生命週期綁定！看生活比喻：房子與房間。如果房子被怪手拆毀了，房間也就隨之不復存在！

在程式碼中，組合代表刪除主訂單時，必須連帶 cascade-delete 所有的訂單明細。

總結這張投影片，請記住這個核心觀念：部分能獨立存活用空心菱形（聚合）；部分隨整體連帶銷毀用實心菱形（組合）。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_class/10_cardinality_and_constraints.jpg" alt="Cardinality & Constraints" />
</div>

<!--
請看畫面上由藍色與紅色方塊組成的網絡圖：『重數與約束 (Cardinality & Constraints)』。在 UML 中，重數規範了物件之間可連接的數量上限與下限：

左邊：**一對一 (1 to 1)**。一個藍方塊剛好對應一個紅方塊，就像一位國民持有一本護照。

中間：**一對多 (1 to *)**。一個藍方塊分支連到多個紅方塊，就像一位顧客可以建立多筆訂單。

右邊：**多對多 (* to *)**。藍紅方塊交織成網狀，就像學生選修多門課程，而每門課程也有多名學生。

標註這些數字能指導工程師在資料庫中該設計外鍵還是中繼關聯表！

總結這張投影片，請記住這個核心觀念：重數明確定義了類別實例在執行期能夠相互關聯的數量邊界。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_class/11_order_model_example.jpg" alt="Syntax to System: The Order Model" />
</div>

<!--
現在讓我們看看所有觀念如何融合在真實的電商訂單模型中！跟著藍色對話框逐一看：

左下角對話框：注意 `- customerID`。減號代表這是**私有屬性 (Private)**，保護客戶機密資料。

上方中央對話框：Customer 與 Order 之間的連線標有 1 與 *，這是**一對多關聯 (One-to-Many)**。

右上角對話框：Order 伸出紅色實心菱形指向 LineItem，這是**組合 (Composition)**！訂單一旦刪除，所有購買明細連帶銷毀。

右下角對話框：虛線空心箭頭指向 PaymentInterface，這是**介面實現 (Realization)**。

這張圖優雅示範了可見度、重數、組合與介面合約的完整結合！

總結這張投影片，請記住這個核心觀念：一張成熟的類別圖能完整整合可見度、重數、組合依賴與介面合約。
-->

---

## AI 輔助指南：類別塑模 (Class Modeling)

- **1. 角色設定與抽象層次界定 (Persona & Abstraction Level)：**
  - 指示 AI 扮演「物件導向領域模型專家 (Domain Architect)」，並明確要求產出「概念層領域模型」或「實作層設計模型」。
- **2. 整體與部分關聯性嚴格紀律 (Whole-Part Coupling)：**
  - **組合 (`*--`, ◆)：** 強制 AI 辨識具備生命週期相依性的實體（整體銷毀時，部分連帶 cascade-delete）。
  - **聚合 (`o--`, ◇)：** 要求部分具備獨立生命週期時使用空心菱形。
  - **禁止濫用泛型關聯：** 嚴禁 AI 全部使用普通實線 (`--`) 敷衍了事，必須為每條線指明重數與關聯型態。
- **3. 封裝與雙向重數規範：**
  - 要求強制加上可見度符號（屬性私有 `-`、操作公開 `+`、型態宣告）。
  - 關聯線「兩端」皆必須明確標註重數（如 `1` 對 `1..*`）。
- **4. 架構師人工審查清單 (Verification Checklist)：**
  - [ ] AI 是否誤將繼承 (`<|--`) 當成組合 (`*--`)？
  - [ ] 敏感屬性（密碼、金流 token、地址）是否皆設定為 `- private`？
  - [ ] 關聯重數在業務邏輯上是否合理（例如訂單能否包含 0 個項目）？

<!--
在引導 AI 產生類別圖時，最需要警惕的是「關係平庸化」與「繼承濫用」。

如果沒有給予嚴格提示，LLM 經常把所有實體都用普通實線連起來，遺失重要的組合與聚合語義；或者隨意濫用繼承，造成深層脆弱的類別階層。

透過提示詞強制規範組合 (Composition) 與聚合 (Aggregation) 的判定準則，並要求在兩端標註重數與可見度，架構師就能在數秒內獲得符合 Domain-Driven Design (DDD) 標準的乾淨模型。

總結這張投影片，請記住這個核心觀念：嚴格約束整體/部分生命週期、雙向重數與屬性封裝，防止 AI 產出淺薄失真的類別圖。
-->

---

## AI 提示詞範例：外送平台領域類別模型

<div class="two-columns">
<div>

**1. 角色設定與任務指令：**
```text
你是一位資深物件導向軟體架構師。
請根據以下領域需求，產出符合 DDD 規範的
標準 PlantUML 類別圖 (Class Diagram)。
```

**2. 塑模約束條件：**
- `Order` 與 `OrderItem` 必須使用**組合關聯** (`*--`，重數 `1` 對 `1..*`)。
- `Order` 與 `Courier` 必須使用**聚合關聯** (`o--`，重數 `*` 對 `0..1`)。
- `OrderItem` 關聯至 `MenuItem` (`*` 對 `1`)。
- 所有屬性均須宣告 `- private` 與明確資料型態。
- 標註關鍵業務方法 (`+ calculateTotal()`, `+ assignCourier()`)。

</div>
<div>

**3. 輸入需求敘述 (Requirements Statement)：**
> 「系統包含 **Customer**（顧客 ID、姓名、Email、電話、外送地址）。
> **Restaurant**（餐廳 ID、店名、地址）擁有多項 **MenuItem**（餐點 ID、品名、單價、是否在庫）。
> 顧客可建立多筆 **Order**。每筆訂單包含訂單編號、狀態列舉 (OrderStatus: 待處理、製作中、配送中、已送達)、下單時間與總金額。
> 一筆訂單由一個或多個 **OrderItem**（購買數量、購買當下單價、小計）組成；若訂單被取消刪除，其明細項目必須連帶銷毀。
> 平台可指派一位 **Courier**（外送員 ID、姓名、電話、交通工具）負責配送訂單。
> 訂單透過 **PaymentProcessor** 介面委託第三方完成扣款。」

</div>
</div>

<!--
請看這份專為外送平台領域類別圖設計的 AI 提示詞範例。

在左側約束條件中，我們明確寫下了領域規則的骨幹：
Order 與 OrderItem 必須是組合（因為訂單明細脫離訂單就毫無存在的實體意義）；Order 與 Courier 則是聚合（因為外送員在完成配送後依然獨立存在於系統中）。

在右側，我們提供清晰的領域名詞與欄位定義。

這樣的提示詞結構能確保生成出來的 PlantUML 代碼具備極高的工程成熟度。

總結這張投影片，請記住這個核心觀念：在 Prompt 中直接指明實體的生命週期從屬性，能有效引導 AI 產出具備高內聚、低耦合的優雅類別圖。
-->

---

### 課堂互動討論：外送平台領域類別架構 (雙人同儕討論)

<div class="discussion-columns">
  <div class="discussion-text">

  **雙人同儕討論：外送平台物件整體與部分及關聯重數抉擇**
  - **領域實體：** `Customer`, `Order`, `OrderItem`, `MenuItem`, `Restaurant`, `Courier`。
  - **與鄰座同學討論（限時 3 分鐘）：**
    1. **組合 vs. 聚合：** `Order` 與 `OrderItem` 應採用組合 (◆) 還是聚合 (◇)？`Order` 與 `Courier` 之間又該採用何者？為什麼？
    2. **跨店購物車重數難題：** 若平台開放顧客在一次結帳中同時包含多家 `Restaurant` 的餐點，類別關聯與重數該如何重新調整？
    3. **資料封裝與安全性：** 為了保護個資與支付憑證，哪些屬性必須設為 `- private`？

  </div>
  <div class="discussion-logo">
    <img src="../../img/ch04/icons/discussion_icon.svg" alt="Discussion Icon" />
  </div>
</div>

<!--
現在讓我們進行 Section 4.4 的雙人同儕討論：外送平台領域類別架構！請戴上物件導向設計架構師的帽子。

審視題目中的三個架構難題：
第一，辨別生命週期：Order 與 OrderItem 是什麼關係？Order 與 Courier 呢？
第二，考慮商業模式突變：如果原本只能單店下單，現在產品經理要求「跨店結帳」（一張訂單買兩家不同餐廳的食物），類別圖會發生什麼翻天覆地的變化？
第三，封裝考量：哪些敏感資料絕不能 public 暴露？

花三分鐘與你的夥伴討論這三個問題。

參考解答與架構復盤：
1. 組合 vs 聚合：Order 到 OrderItem 是絕對的組合 (◆)，因為明細項無法脫離訂單獨立存在；而 Order 到 Courier 是聚合 (◇) 或一般關聯，外送員生命週期獨立於任何單一訂單。
2. 跨店重數：若支援跨店，OrderItem 必須直接關聯所屬的 Restaurant，或者在 Order 下拆分出 SubOrder（子訂單）分別對應不同店家與取件配送路線。
3. 封裝：信用卡 token、顧客完整地址與電話必須嚴格 private，並透過專屬授權方法存取。

總結這張投影片，請記住這個核心觀念：組合強化生命週期依賴，而封裝與合理的重數規劃則是保護領域資料完整性的盾牌。
-->

---

### 觀念檢核測驗 4 (CCQ 4)
<!-- id: ase-ch04-ccq4 -->
<div class="ccq-columns">
<div class="ccq-text">

在 UML 類別圖中，若類別 A 與類別 B 之間繪製了一條連線，且在 A 端標示了**實心黑色菱形 (Filled Black Diamond, ◆)** 指向 B，這代表什麼架構意涵？

- **A.** 類別 B 繼承了類別 A 的所有公開方法與屬性。
- **B.** 類別 A 組合 (Composition) 了類別 B；當物件 A 被銷毀時，所屬的物件 B 也將連帶被銷毀。
- **C.** 類別 A 與類別 B 是鬆散聚合關係，B 擁有獨立生存的生命週期。
- **D.** 類別 A 與類別 B 之間僅存在執行期的暫時性依賴。

</div>
<div class="ccq-logo">
    <a href="https://nlhsueh.github.io/nickedupocket/#/student/ase-ch04-ccq4" target="_blank"><img src="../../img/ch04/ase-ch04-ccq4.png" alt="QR Code" /></a>
  </div>
</div>

<!--
讓我們透過觀念檢核測驗 4 來檢視對類別關聯性的掌握。

題目問的是：實心黑色菱形 (◆) 代表什麼？
檢視選項：
選項 A 是泛化繼承（空心三角箭頭）。
選項 C 是聚合關係（空心菱形 ◇）。
選項 D 是依賴關係（虛線箭頭）。

正確答案是 B！實心黑色菱形代表強整體組合關係 (Composition)，部分與整體共存亡，具備 cascade-delete 的生命週期約束。

總結這張投影片，請記住這個核心觀念：實心菱形代表生命週期緊密綁定的組合關係 (Composition)，整體消亡則部分連帶銷毀。
-->

---

<!-- _class: lead -->
<!-- header: '4.5 互動與循序圖模型' -->

# **4.5 互動與循序圖模型**

> "時間是軟體架構中最嚴苛的考驗；循序圖將時間的流逝具象化為可驗證的訊息契約。"

<!--
歡迎進入第 4.5 節：互動與循序圖模型！

在前面幾節，我們透過使用案例了解了使用者想要什麼，也透過類別圖認識了系統有哪些靜態結構。但真實的軟體是隨時間動態運行的。當使用者點擊畫面按鈕時，物件之間會互相傳遞訊息、呼叫方法並回傳結果。

在這一節中，我們將學習 UML 循序圖 (Sequence Diagram)。我們將深入探討生命線、訊息箭頭、if-else 與迴圈等複合片段，並學習如何透過 AI 提示詞產出清晰嚴謹的循序模型。

總結這張投影片，請記住這個核心觀念：循序圖沿時間軸展示物件之間如何透過傳遞訊息相互協同，落實具體情境劇本。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_sequence/01_dynamic_interaction_overview.jpg" alt="Dynamic Interaction Overview" />
</div>

<!--
請看這張 3D 視角的循序圖架構藍圖。

畫面頂部有三個參與者：第一個是 Actor 1 使用者 (User)，第二個是 Actor 2 系統介面 (System Interface)，第三個是 Actor 3 後端服務 (Backend Service)。從每個角色向下延伸的垂直虛線就是生命線。

請沿著橘色箭頭由上往下追蹤編號 1 到 5 的訊息順序：
第一步，使用者向系統介面提交請求 (SubmitRequest)。
第二步，系統介面進行自我資料驗證 (Validate)。
第三步，介面向後端服務發起交易處理 (ProcessTransaction)。
第四步，後端更新資料庫並確認成功 (UpdateDatabase)。
第五步，系統介面將確認結果回傳給使用者 (ReturnResponse)。

這張圖非常直觀：誰跟誰通訊、先後順序為何，一目了然！

總結這張投影片，請記住這個核心觀念：循序圖以時間先後為序，為使用者、前端介面與後端服務之間的訊息交流提供清晰的動態藍圖。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_sequence/02_static_vs_dynamic_collaboration.jpg" alt="Mapping Dynamic Collaboration: Static vs Dynamic Models" />
</div>

<!--
這張圖清楚對比了靜態模型與動態模型的核心差異。

左側藍色區塊是「靜態類別模型」：展示 Class A、Class B 與 Class C 之間的關聯。它告訴我們系統中有哪些零件、誰認識誰，但完全沒有時間或執行順序的概念。

右側金色區塊則是「動態循序模型」：展示兩個真正正在運行的物件 Object X 與 Object Y。此時時間順序至關重要！請看橘色箭頭：1 請求動作、2 處理資料、3 發送回應、4 確認完成。

打個比方：類別圖就像一張道路地圖，告訴你有哪幾條公路；而循序圖則是車輛在道路上依序行駛的即時導航記錄。

總結這張投影片，請記住這個核心觀念：類別圖定義系統的靜態結構，循序圖則展現系統隨時間推進的動態運作行為。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_sequence/03_interaction_canvas_and_dimensions.jpg" alt="The Interaction Canvas: Object Dimension & Time Dimension" />
</div>

<!--
我們來理解循序圖畫布的兩大維度座標軸。

上方水平的藍色軸線是「物件維度 (Object Dimension)」：參與互動的物件由左至右排列，通常越早參與互動的物件排在越左邊。

左側垂直向下的橘色軸線是「時間維度 (Time Dimension)」：時間永遠由上往下單向推進。在頁面上方發生的訊息，一定比下方的訊息更早發生。

請特別注意右下角的警告標語：垂直距離代表的是「事件發生的先後順序」，而不是「實際經過的秒數或時長」！兩條線之間的空白較大，不代表系統等待了十分鐘，只代表下一個事件接續發生。

總結這張投影片，請記住這個核心觀念：循序圖畫布橫向排列參與物件、縱向推進時間順序，清晰表達事件發生的先後關係。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_sequence/04_structural_anatomy.jpg" alt="Structural Anatomy: Lifelines, Activation Bars, and Events" />
</div>

<!--
這是循序圖的四大核心解剖構造。請對照左側圖解與右側的四張卡片。

第一是頂部的 Actor（參與者）：代表啟動互動的外部使用者或外部系統角色。
第二是垂直向下的虛線 Lifeline（生命線）：代表該物件在時間軸上的存在週期。

第三是黃色長條形矩形 Focus of Control（控制焦點，又稱啟動條 Activation Bar）：代表該物件當前正積極執行程式代碼的區間，從上方的啟動時間 (Initiation Time) 一直持續到下方的完成時間 (Completion Time)。

第四是 Event（事件）：指時間軸上某個發生的時間點，例如一條訊息到達或發出的瞬間。事件觸發時，啟動條便隨之展開！

總結這張投影片，請記住這個核心觀念：參與者發起事件，生命線代表存在，而啟動條則標記物件正在積極執行運算的期間。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_sequence/05_messaging_matrix.jpg" alt="The Messaging Matrix: Synchronous, Asynchronous, Return, Create, Destroy" />
</div>

<!--
這張訊息矩陣表是循序圖最重要的語法對照表，不同的箭頭在程式代碼中代表截然不同的行為。

第一，Call（呼叫）：實心線搭配實心箭頭，代表呼叫另一個物件的方法。
第二，Return（返回）：虛線搭配開放式箭頭，代表將執行結果傳回給呼叫者。

第三，Self（自我呼叫）：彎曲箭頭繞回同一個物件，代表呼叫自己內部的輔助方法。
第四，Recursive（遞迴呼叫）：在原本的啟動條上堆疊一個新的啟動條，代表方法自我遞迴。

第五，Create（建立）：虛線箭頭直接指向一個新的物件方塊，代表在運行時 new 出新物件。
第六，Destroy（消滅）：箭頭末端加上粗體叉叉 X，代表釋放記憶體或結束生命週期。

最後，Duration 標記兩個時間點之間的時長。

總結這張投影片，請記住這個核心觀念：實線實心箭頭代表方法呼叫，虛線代表資料返回或建立新物件，叉叉 X 則標記生命週期的終結。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_sequence/06_combined_fragments_overview.jpg" alt="UML 2.0 Combined Fragments: alt, opt, loop, par" />
</div>

<!--
在早期的 UML 中，一張循序圖只能畫單一線性流程。一旦遇到 if-else 條件分支，工程師就必須畫兩張完全獨立的圖！

為了解決這個痛點，UML 2.0 推出了「複合片段 (Combined Fragments)」。它就像一個外框，框住特定區間的生命線來表達條件判斷或重複迴圈。

請觀察這個框架的三個關鍵部位：
第一，左上角的黃色標籤是「片段運算子 (Operator)」，例如圖中的 `alt` 代表互斥的條件分支。
第二，方括號內的 `[condition == true]` 是「守衛條件 (Guard)」，說明觸發該路徑的條件。
第三，中間的水平虛線是「分支分隔線 (Divider)」，上半部是條件成立時的執行路徑，下半部則是 else 的備用路徑。

總結這張投影片，請記住這個核心觀念：複合片段透過運算子標籤、守衛條件與分隔線，在單一圖表中優雅表達條件分支與迴圈邏輯。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_sequence/07_fragment_operators_to_code.jpg" alt="Fragment Operators to Production Code Logic" />
</div>

<!--
這張對照表非常實用，它展示了 UML 片段運算子如何直接對應到程式代碼！

請特別注意前兩個運算子，這是初學者最常混淆的地方：
`alt` 代表 Alternatives（互斥分支）：只能執行其中一條路徑，直接對應到 `if ... else if ... else`。
`opt` 代表 Optional（可選路徑）：只有在條件成立時才執行，沒有 else 分支，對應到單純的 `if` 敘述。

接下來：
`loop` 代表重複迴圈，對應到 `while` 或 `for`。
`par` 代表 Parallel（平行並發），對應到多執行緒或非同步 async 任務。
`region` 是臨界區，對應到 Mutex 鎖或同步區塊。
`neg` 標記非法或錯誤路徑，對應到丟出 Exception。
`ref` 代表引用另一張循序圖，就像呼叫外部函式一樣，能避免單張圖過於龐大。

總結這張投影片，請記住這個核心觀念：`alt` 對應 if-else，`opt` 對應單純 if，`loop` 對應迴圈，而 `ref` 則能模組化分解複雜圖形。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_sequence/08_case_study_hotel_reservation.jpg" alt="System Model Case Study: Hotel Reservation Flow" />
</div>

<!--
讓我們透過一個真實的「飯店訂房」案例，來看所有觀念如何串聯運作。

頂部有四條生命線：使用者 User、前端預訂視窗 ReservationWindow、後端訂房系統 BookingSystem，以及 Reservation 預訂實體物件。

跟隨時間軸由上往下看：
首先，使用者在視窗點擊 `initiate()` 開始訂房。
接著，視窗呼叫 BookingSystem 的 `checkAvailability()` 查詢空房狀態。

這時進入了 `alt` 條件複合片段：
上半部如果 `[room available]` 有空房，BookingSystem 發送 create 虛線箭頭，建立全新的 Reservation 物件！
下半部如果是 `[else]` 沒有空房，BookingSystem 則透過虛線返回 `bookingFailed()` 失敗訊息給視窗。

成功與失敗分支在一張圖中表達得清清楚楚。

總結這張投影片，請記住這個核心觀念：真實的循序圖協調介面視窗、後端系統、實體建立與異常分支，構成嚴謹的互動防護網。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_sequence/09_requirements_to_code_pipeline.jpg" alt="The Requirements-to-Code Pipeline: Use Case → Scenario → Sequence → Code" />
</div>

<!--
我們如何從模糊的客戶需求一步步走到精確的程式碼？這條四步驟管線展示了完整的工程脈絡。

第一步是 Use Case（使用案例）：定義系統在宏觀層面要做什麼，例如「預訂飯店房間」。
第二步是 Scenario（情境劇本）：展開該使用案例的具體路徑，例如「正常扣款成功的晴天路徑」或「信用卡過期的雨天路徑」。

第三步是 Sequence Diagram（循序圖）：針對特定劇本，精確畫出跨時間的物件、方法呼叫與訊息傳遞。
第四步是 Implementation（代碼實作）：工程師看著循序圖編寫類別與方法，完全不需盲目通靈猜測！

請看底部的金句：劇本是系統的一次執行過程，而循序圖正是這趟過程的精確架構藍圖。

總結這張投影片，請記住這個核心觀念：從高階使用案例拆解出具體劇本，再繪製循序圖分配物件職責，最後落實為高品質代碼。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_sequence/10_model_before_code.jpg" alt="Model Before Code: Architectural Discipline vs Chaotic Code" />
</div>

<!--
這是軟體工程最重要的核心哲學：『先塑模，後寫代碼 (Model Before Code)』。

請看左邊：如果一拿到需求就衝動動手敲鍵盤寫代碼，往往會寫出義大利麵般的混亂函式、隨處可見的空指標例外 (NullPointerException) 與未經處理的資料庫查詢。我們給它打上一個醒目的大叉叉！

右邊則是專業的藍圖：乾淨的循序圖將 User、ApplicationController 與 DatabaseManager 的分工交代得清清楚楚，並與 UI 介面完美對齊。

請看底部的四大價值：
1. 語言中立：無論用 Java、Python 還是 Go，架構概念完全一致。
2. 跨領域對齊：即使不懂寫 code 的產品經理也能看懂流程。
3. 團隊共識：在圖上改一個箭頭只要五秒鐘，在代碼中大改架構卻要花上好幾週。
4. 測試導向：測試工程師能直接把每個箭頭轉化為自動化測試案例！

總結這張投影片，請記住這個核心觀念：先繪製循序藍圖建立團隊共識與測試基礎，能省下數十倍後期返工與抓 Bug 的沉重代價。
-->

---

## AI 輔助指南：循序圖塑模 (Sequence Modeling)

- **1. 角色設定與架構模式約束 (Persona & Architecture Pattern)：**
  - 指示 AI 扮演「分散式系統與 API 整合架構師」。
  - **強制引入 BCE 模式：** 嚴格要求區分 Boundary (介面)、Control (業務邏輯)、Entity (資料庫實體)，嚴禁 UI 直接繞過控制器存取資料庫。
- **2. 訊息語法與複合片段嚴格規範：**
  - **同步呼叫 (`->`) 與返回 (`-->`)：** 強制要求對稱繪製返回虛線與回傳型態，避免啟動條無限懸空。
  - **非同步派發 (`->>`)：** 對於背景事件排隊、推播通知，強制使用開放式箭頭。
  - **複合片段 (`alt`)：** 強制要求 AI 必須針對業務失敗情境（如扣款失敗、超時）繪製 `alt [成功] else [失敗]` 區塊。
- **3. 架構師人工審查清單 (Verification Checklist)：**
  - [ ] 是否存在違背分層架構的「越級呼叫」（例如前端 UI 直接調用資料庫實體）？
  - [ ] `alt` 片段中是否具備互斥的守衛條件 `[guard]`？
  - [ ] 啟動條 (activate/deactivate) 的生命區間是否與方法呼叫週期完全吻合？

<!--
引導 AI 產生循序圖時，最容易出現的架構硬傷是「越級呼叫」與「只畫 Happy Path」。

如果缺乏架構約束，LLM 經常讓前端直接向資料庫查詢，破壞三層分層架構；而且它極度傾向只畫成功路徑，完全忽略真實世界隨處可見的網路超時與驗證失敗。

透過在提示詞中強制要求遵守 BCE 模式，並強制命令它用 alt 複合片段處理異常分支，就能產出生產級別的嚴謹循序圖。

總結這張投影片，請記住這個核心觀念：透過 BCE 分層約束、對稱返回箭頭與 alt 異常分支，確保 AI 產出的循序圖具備生產級強韌度。
-->

---

## AI 提示詞範例：外送平台結帳循序模型

<div class="two-columns">
<div>

**1. 角色設定與任務指令：**
```text
你是一位資深分散式系統後端架構師。
請根據以下結帳情境，採用 BCE 模式
產出標準 PlantUML 循序圖 (Sequence Diagram)。
```

**2. 塑模約束條件：**
- 宣告生命線職責：
  - `boundary CheckoutUI as ":結帳介面"`
  - `control OrderCtrl as ":訂單控制器"`
  - `boundary StripeAPI as ":金流服務"`
  - `entity OrderEntity as ":訂單實體"`
  - `queue KitchenQueue as ":廚房事件佇列"`
- 必須使用 `alt` 片段處理 `[扣款成功]` 與 `[扣款失敗]`。
- 廚房通知必須使用非同步箭頭 `->>` 發送至事件佇列。

</div>
<div>

**3. 輸入需求敘述 (Requirements Statement)：**
> 「顧客在 **CheckoutUI** 點擊『立即付款』按鈕。
> **CheckoutUI** 轉發 `submitOrder(購物車清單, 支付憑據)` 至 **OrderCtrl**。
> **OrderCtrl** 呼叫 **StripeAPI** 執行 `authorizeCharge(金額, 憑據)`。
> 若授權成功：
> 1. StripeAPI 回傳授權碼 `chargeToken`。
> 2. OrderCtrl 呼叫 **OrderEntity** 建立持久化訂單紀錄（狀態設為 `PLACED`）。
> 3. OrderCtrl 以非同步訊息發布 `orderPlacedEvent` 至 **KitchenQueue**。
> 4. OrderCtrl 回傳 `orderSuccess(訂單編號)` 給 CheckoutUI。
> 若授權失敗：
> 1. StripeAPI 回傳 `declinedError`。
> 2. OrderCtrl 記錄失敗日誌，不建立訂單，直接回傳 `paymentFailed()`。」

</div>
</div>

<!--
這是一份引導 AI 產出 BCE 外送結帳循序圖的經典提示詞。

請看左側的約束條件：
我們不僅要求宣告 BCE 生命線角色，還特別指定了廚房事件佇列為非同步佇列。
同時，我們明確要求使用 alt 複合片段包辦成功與失敗兩條路徑。

右側的需求文字條理分明，步驟清晰。

這樣的提示詞送進 LLM，產出的循序圖絕對是架構評審會議上可以直接過關的高水準作品。

總結這張投影片，請記住這個核心觀念：明確定義 BCE 生命線角色與 alt 異常處理分支，能引導 AI 產出符合微服務實務的循序圖。
-->

---

### 課堂互動討論：外送平台結帳與異常循序流 (雙人同儕討論)

<div class="discussion-columns">
  <div class="discussion-text">

  **雙人同儕討論：追蹤執行期訊息時序與 BCE 強韌性架構**
  - **工程情境：** 顧客在手機 App 點擊確認結帳，送出金額 $35 美元的外送訂單。
  - **核心生命線：** `:CheckoutUI` (邊界), `:OrderController` (控制), `:Order` (實體), `:PaymentGateway` (外部服務)。
  - **與鄰座同學討論（限時 3 分鐘）：**
    1. 當扣款成功時，請依時間先後追蹤主要訊息流動。是由哪一個物件負責實體化 `:Order` 物件？
    2. 如何利用 `alt` 複合片段來同時容納「扣款成功」與「卡片過期/額度不足」的分支？
    3. 通知餐廳廚房接單的訊息，應該設計為同步阻塞呼叫 (`->`) 還是非同步訊息 (`->>`)？為什麼？

  </div>
  <div class="discussion-logo">
    <img src="../../img/ch04/icons/discussion_icon.svg" alt="Discussion Icon" />
  </div>
</div>

<!--
現在讓我們進入 Section 4.5 的雙人同儕討論：外送平台結帳與異常循序流！請轉頭與夥伴組成後端架構評審小組。

請探討題目中的三個核心設計抉擇：
第一，追蹤幸福路徑：顧客點擊付款後，各物件呼叫順序為何？誰有資格 new 出 Order 實體？
第二，異常防護：如何用 alt 複合片段優雅呈現扣款被拒絕？
第三，通訊效能關鍵：通知廚房平板接單，應該是讓顧客畫面卡在那邊等廚房回傳的同步呼叫，還是丟進 Kafka 佇列的非同步訊息？

花三分鐘與你的夥伴討論這三個問題。

參考解答與架構復盤：
1. 訊息時序：CheckoutUI 送出請求給 OrderController，控制器向金流閘道授權，取得 token 後由控制器調用工廠或 Repository 建立 Order 實體。
2. Alt 片段：`[paymentApproved]` 進行持久化並進入履約；`[else / paymentFailed]` 回滾交易並回傳錯誤訊息給 UI。
3. 同步 vs 非同步：廚房通知必須是「非同步 (`->>`)」！若設計為同步阻塞，顧客的 App 畫面會一直轉圈圈等待廚房店員按平板確認，一旦廚房網路延遲就會造成結帳超時崩潰。

總結這張投影片，請記住這個核心觀念：循序圖讓 BCE 職責劃分、異常失敗路徑與非同步解耦機制在動手寫程式碼前清晰可見。
-->

---

### 觀念檢核測驗 5 (CCQ 5)
<!-- id: ase-ch04-ccq5 -->
<div class="ccq-columns">
<div class="ccq-text">

在 BCE (Boundary-Control-Entity) 架構循序圖中，當顧客透過結帳前端點擊『確認下單』按鈕時，該事件應先傳遞給哪一種類型的物件處理？

- **A.** 直接傳遞給 `Order` 實體物件立即寫入資料庫
- **B.** 直接呼叫 `PaymentGatewayAPI` 邊界物件立即刷卡扣款
- **C.** 傳遞給 `OrderController` 控制物件協調業務邏輯驗證與調用
- **D.** 直接傳遞給 `Restaurant` 實體物件確認餐廳接單

</div>
<div class="ccq-logo">
    <a href="https://nlhsueh.github.io/nickedupocket/#/student/ase-ch04-ccq5" target="_blank"><img src="../../img/ch04/ase-ch04-ccq5.png" alt="QR Code" /></a>
  </div>
</div>

<!--
讓我們透過觀念檢核測驗 5 來檢驗對 BCE 架構職責分工的掌握。請掃描 QR Code 或點選連結進行線上作答。

題目詢問：當顧客點擊結帳介面的按鈕時，這個請求應該先交給誰？

我們逐一審視選項：
選項 A 主張直接交給 Order 實體物件，這嚴重違反了分層架構：前端介面絕對不能直接讀寫資料庫實體！
選項 B 主張直接呼叫金流服務，跳過內部驗證與訂單處理，是不合理的捷徑。
選項 D 也是前端直接碰觸實體物件。

正確答案是 C！請求必須先送到 `OrderController` 控制物件。由它負責驗證購物車、檢查庫存、協調金流授權，最後才建立訂單實體。

總結這張投影片，請記住這個核心觀念：控制物件負責統籌業務邏輯，是介於邊界介面與資料實體之間的核心中樞。
-->

---

<!-- _class: lead -->
<!-- header: '4.6 流程與活動圖模型' -->

# **4.6 流程與活動圖模型**

> "複雜的業務流程就像多條河流匯聚；活動圖能讓我們精確掌控每一道支流的並行與匯合。"

<!--
歡迎進入第 4.6 節：流程與活動圖模型！

在上一節中，循序圖向我們展示了單一情境劇本下物件之間的訊息往來。但在真實的現代軟體中，系統經常需要處理跨部門的商業工作流程、多方角色的責任交接，以及背景同時執行的平行任務。

UML 活動圖 (Activity Diagram) 正是為工作流程而生。在這一節中，我們將學習動作節點、決策菱形、平行分岔與結合棒，以及劃分責任的泳道。

總結這張投影片，請記住這個核心觀念：活動圖專門用於塑模動態業務流程、條件決策邏輯，以及多執行緒平行並行任務。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_act/01_cover.jpg" alt="Mapping the Dynamic System with UML Activity Diagrams" />
</div>

<!--
請看這張描繪動態系統的漸進演進圖。

沿著畫面中的引導線，貫穿了三個關鍵方塊：
第一個是左邊的「構想生成 (Idea Generation)」：我們從非結構化的想法與雲朵概念開始。
第二個是中間的「結構邏輯 (Structural Logic)」：我們定義商業規則、決策菱形與並行分工。
第三個是右邊的「系統實踐 (System Realization)」：我們建立包含分岔棒與結合棒的具體可執行活動圖。

活動圖能將腦海中混亂的業務想法，一步步轉化為條理分明的工程架構藍圖。

總結這張投影片，請記住這個核心觀念：活動圖能將非結構化的商業構想，淬鍊為清晰可執行的動態工作流藍圖。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_act/02_visual_logic.jpg" alt="Moving Beyond Static Structures to Model Dynamic Workflows" />
</div>

<!--
這張投影片呈現了一個極具衝擊力的對比：「混亂的文字」與「清晰的視覺邏輯」。

請看左邊：這是一大段冗長密集的文字敘述，說明拆開包裝、初始化系統、建立檔案、輸入文字、排版到儲存。讀完這大坨文字，往往容易看漏步驟或產生誤解。

現在看右邊：四個清爽的圓角方塊搭配箭頭，依序是開箱、建檔、打字、存檔。

這正是我們繪製活動圖的原因：透過視覺化的圖形邏輯，讓流程步驟一目了然！

總結這張投影片，請記住這個核心觀念：活動圖以直觀的視覺流程取代冗長混亂的文字，讓執行步驟清晰無誤。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_act/03_triggers.jpg" alt="Three Triggers for Behavioral Modeling" />
</div>

<!--
我們什麼時候該畫活動圖？請看這個環形圖中的三大觸發情境：

第一是「商業工作流程 (Business Workflows)」：當我們需要串聯協調多個不同的使用案例，來達成更大的業務目標時。
第二是「複雜協同調度 (Complex Coordination)」：當單一使用案例內部包含多個重疊作業，需要精確控制時序與並行時。
第三是「情境狀態映射 (Contextual Mapping)」：當我們必須精確界定每個步驟執行前的前置條件 (Pre-conditions) 與執行後的後置條件 (Post-conditions) 時。

總結這張投影片，請記住這個核心觀念：在跨使用案例的工作流、重疊的複雜調度，以及需要驗證前後置條件時，最適合採用活動圖。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_act/04_compair.jpg" alt="Standard Flowcharts vs UML Activity Diagrams" />
</div>

<!--
很多人常問：『我們從小就會畫流程圖，為什麼還要學 UML 活動圖？』請看這張比較表。

前兩行：循序邏輯與條件分支，傳統流程圖和活動圖都能做到（都打勾）。
但請看下面三行，傳統流程圖全部被打上了灰色叉叉：
傳統流程圖無法表達「平行並行 (Concurrency)」——也就是兩件事同時發生；
傳統流程圖缺乏「泳道 (Swimlanes)」——無法指派每個動作的負責人或服務；
傳統流程圖也無法追蹤「資料物件」的狀態轉變。

UML 活動圖五個項目全部支援，這就是為什麼大型企業軟體必須使用活動圖！

總結這張投影片，請記住這個核心觀念：活動圖超越傳統流程圖，提供並行多執行緒、責任泳道與資料物件流等工業級能力。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_act/05_core.jpg" alt="The Core Vocabulary of System Flow" />
</div>

<!--
這是活動圖的四大核心詞彙。請對照畫面中央的圖形與四張卡片：

第一，最左側的實心黑色圓點是「初始節點 (Initial Node)」：代表整個流程被點燃的觸發起點。
第二，實線箭頭是「控制流 (Control Flow)」：指引執行權如何依序前進。

第三，中間的圓角矩形是「動作節點 (Action)」：代表使用者或系統執行的單一具體任務。
第四，最右側的雙同心圓靶心是「終止節點 (Activity Final Node)」：代表所有執行緒全部停止，流程正式結束。

總結這張投影片，請記住這個核心觀念：流程始於初始實心點，沿著控制箭頭穿過圓角動作方塊，最終抵達雙圓靶心結束。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_act/06_conditional.jpg" alt="Handling Conditional System Logic: Decision & Merge Nodes" />
</div>

<!--
我們來看條件分支邏輯。請觀察圖中的兩個菱形：

上方第一個菱形是「決策節點 (Decision Node)」：它提出問題「需要圖片嗎？」。如果 Yes，走左邊進行開圖與貼圖；如果 No，直接走右邊繞過。決策節點根據條件「嚴格二選一」。

下方第二個菱形是「合併節點 (Merge Node)」：它將兩條互斥的分支重新匯合，接續執行儲存檔案。請特別注意：合併節點「不需要等待兩邊都完成」，因為原本就只會走其中一條路，哪一邊到了就直接往下走！

總結這張投影片，請記住這個核心觀念：決策菱形依守衛條件進行互斥分流，合併菱形則安全地將替代路徑重新收攏。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_act/07_parallel.jpg" alt="Orchestrating Parallel System Actions: Fork & Join Nodes" />
</div>

<!--
現在我們來看平行並行處理：注意圖中的兩條粗黑橫棒！

當「收到訂單」後，流程遇到了上方的「分岔節點 (Fork Node)」：
這條粗黑橫棒將單一流程切分為兩條同時發生的並行分支——一邊處理請款 (Handle Billing)，另一邊備貨寄送 (Fill & Send)。

再看下方的粗黑橫棒「結合節點 (Join Node)」：
結合棒是一個同步屏障！它會「嚴格等待兩條平行分支全部抵達」，確認帳款處理完且貨物也備妥後，才放行進入「關閉訂單」。若請款一秒搞定，它也會在結合棒前掛起等待，直到包裝完成！

總結這張投影片，請記住這個核心觀念：Fork 粗棒啟動平行並行任務，Join 粗棒則等待所有平行分支全部完成後才繼續前進。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_act/08_object_flow.jpg" alt="Tracking Data & Objects: Object Nodes and Object Flows" />
</div>

<!--
工作流程不只執行動作，還會產生與傳遞資料。

請特別觀察畫面中的圖形形狀：
一般的動作（如產生報表、核准資料）是「圓角矩形」；
而中間的「物件節點 (Object Node)」則是「直角矩形」！它代表真實的資料檔案或物件實體，例如 `Financial_Report.pdf`。

連接它們的虛線箭頭稱為「物件流 (Object Flow)」：代表資料的流動。左邊動作產出 PDF，右邊動作則讀入該 PDF 進行審核。

總結這張投影片，請記住這個核心觀念：直角矩形代表資料物件節點，虛線箭頭代表資料在動作之間的輸入與輸出流轉。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_act/09_swimlane.jpg" alt="The Multi-Actor Accountability Problem" />
</div>

<!--
這是軟體工程常見的痛點：多方角色的當責模糊問題。

請看左邊「沒有泳道」的情況：七個動作方塊被蜘蛛網般的箭頭糾纏在一起。誰負責審查？誰負責請款？誰通知員工？完全看不出來，一旦出事大家就互相踢皮球。

再看右邊「引入泳道」的成果：我們畫出一條縱向分隔線，左欄是員工 (Employee)，右欄是主管 (Manager)。
責任瞬間清清楚楚：員工負責提交報銷與確認細節；主管負責審查、核准、對帳與撥款。

總結這張投影片，請記住這個核心觀念：泳道將畫布劃分為不同責任欄位，消滅工作交接過程中的職責模糊與推諉。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_act/10_grouping.jpg" alt="Grouping Activities by Actor or Thread: Swimlanes / Partitions" />
</div>

<!--
讓我們透過一個大學新生報到的例子，來看泳道如何清晰展示跨角色交接。

畫面上劃分出兩個泳道：左邊是學生 (Applicant)，右邊是註冊組 (Registrar)。

請追蹤跨越分隔線的箭頭：
首先，學生填寫報到表單；
接著，箭頭跨越泳道交給註冊組：註冊組檢查表單、確認填寫無誤，並通知學生；
最後，箭頭再跨回學生泳道：學生繳交學雜費。

每次箭頭跨過泳道分界線，就代表一次清清楚楚的跨角色工作交接 (Handoff)。

總結這張投影片，請記住這個核心觀念：跨泳道箭頭直觀呈現不同角色、部門或微服務之間的實體工作交接點。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_act/11_notation.jpg" alt="Complete Visual Taxonomy of Dynamic Modeling" />
</div>

<!--
這是一張活動圖的完整視覺語法全景速查表，結構分為三大欄：

第一欄「參與者 (The Actors)」：泳道與分區，負責將動作歸屬給特定角色或服務。
第二欄「動作與資料 (The Actions)」：包含代表任務的圓角動作節點，以及代表資料實體的直角物件節點。

第三欄「交通指揮官 (The Directors)」：
起點實心圓與終點雙圓圈；
實線控制流與虛線物件流；
菱形的條件決策與合併節點；
以及粗黑棒的並行分岔與同步結合節點。

隨時牢記這張全景表，你就能看懂並繪製任何專業的企業活動圖！

總結這張投影片，請記住這個核心觀念：活動圖由泳道角色、任務物件與控制流節點三大支柱組成，具備完整的動態表達力。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_act/12_workflow.jpg" alt="The Unified Workflow Model: Swimlanes + Concurrency + Logic" />
</div>

<!--
看這張大成之作：所有活動圖核心要素在單一模型中完美融合！

畫面有三個泳道：Actor A、Actor B 與 Actor C。
跟著箭頭走一次完整流程：
1. Actor A 發起初始請求，跨泳道交給 Actor B 審查。
2. Actor B 審查後碰到 Fork 分岔棒，同時啟動兩條平行支流！
在 Actor B，執行分析並產出「分析報告」物件；
在 Actor C，執行子處理。注意那個菱形：如果不成功，會循環重試！
3. 當報告產出且子處理重試成功，兩者在 Actor C 的 Join 結合棒同步！
4. Actor C 產出最終成果，再跨泳道交回 Actor A 交付成果，抵達終點。

泳道分工、並行處理、重試迴圈與物件流動全部井然有序！

總結這張投影片，請記住這個核心觀念：融合泳道責任、Fork/Join 並行與決策重試迴圈，能打造企業級無懈可擊的工作流藍圖。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_act/13_three_phases.jpg" alt="Three Phases to Map Your Complex Systems" />
</div>

<!--
最後，總結在實務中設計複雜工作流程的三大漸進階段：

最底部的第一階段：審視商業情境 (Business Context)。宏觀梳理核心使用案例，界定流程的輸入前置條件與輸出後置條件。
中間的第二階段：繪製核心工作流 (Map Core Workflows)。建立主要泳道分區，串聯使用案例之間的主要控制流。
最頂部的第三階段：深入複雜細節 (Zoom In on Complexity)。補齊決策判斷、Fork/Join 並行粗棒，以及資料物件的狀態轉變。

循序漸進，不要一開始就想畫完所有細節。

總結這張投影片，請記住這個核心觀念：依序從商業情境、核心泳道到並行細節三階段逐步推進，是駕馭複雜工作流的最佳實務。
-->

---

## AI 輔助指南：活動圖塑模 (Activity Modeling)

- **1. 角色設定與現代語法標準 (Persona & Syntax Standard)：**
  - 指示 AI 扮演「分散式工作流與業務流程架構師 (Workflow Architect)」。
  - **強制要求使用現代語法：** 指定採用 **PlantUML Activity Beta 新版語法** (`start`, `stop`, `if/else`, `fork/fork again/end fork`)，避免過時的舊版標記。
- **2. 泳道當責邊界嚴格分配 (Swimlane Accountability)：**
  - 要求明確定義泳道分區（如 `|顧客|`, `|餐廳廚房|`, `|調度引擎|`, `|外送員|`），動作必須歸屬在對應欄位中。
- **3. 並行與同步工程紀律：**
  - **分岔 (`fork` / `fork again`)：** 明確指示哪些流程必須平行運作（例如廚房做菜與系統配對司機）。
  - **同步結合 (`end fork` / `join`)：** 強制要求在取餐交件前必須同步，防止產生單獨無人外送的競爭條件 (Race Condition)。
- **4. 架構師人工審查清單 (Verification Checklist)：**
  - [ ] 每個 `fork` 是否都有對應的 `end fork` 結合屏障？
  - [ ] 跨泳道的控制流轉移是否合理且具備最小依賴？
  - [ ] 是否存在流程在結合棒無限等待、造成業務死結的缺陷？

<!--
引導 AI 產生活動圖時，最容易出現的破綻是「失去並行能力」與「泳道歸屬混亂」。

如果沒有嚴格限制，AI 經常把應該同時進行的任務畫成前後串聯的單線流水帳，或者畫出一個 Fork 分岔後卻忘了用 Join 棒同步，導致流程遺失同步屏障。

透過指定現代 PlantUML beta 語法、明確宣告四大角色泳道，並明確規定並行分岔與結合點，AI 就能在秒級內產出具備工業級精準度的端到端活動圖。

總結這張投影片，請記住這個核心觀念：約束現代語法、明確劃分泳道並嚴格規範 Fork/Join 配對，能確保 AI 產出零死結的高品質活動圖。
-->

---

## AI 提示詞範例：外送平台廚房與外送並行活動模型

<div class="two-columns">
<div>

**1. 角色設定與任務指令：**
```text
你是一位分散式工作流程架構師。
請根據以下外送履約流程，使用 PlantUML
activity beta 語法產生具備泳道與並行的活動圖。
```

**2. 塑模約束條件：**
- 建立 4 個泳道：
  - `|顧客|`, `|餐廳廚房|`,
  - `|調度引擎|`, `|外送員|`
- 訂單付款後立即插入 `fork` 並行分岔：
  - 分支一：廚房接單、備餐並包裝餐點。
  - 分支二：調度系統規劃路徑、媒合司機、司機開車抵達店家。
- 使用 `end fork` (結合) 同步「包裝完成」與「司機抵達」。
- 結合後進行交餐配送，驗證 OTP 後 `stop`。

</div>
<div>

**3. 輸入需求敘述 (Requirements Statement)：**
> 「顧客在 **|顧客|** 泳道送出訂單並完成信用卡付款。
> 付款確認後，系統立即啟動兩條平行並行工作流：
> - 在 **|餐廳廚房|** 泳道：廚房列印工單、廚師開始烹調餐點、完成後將食物裝盒並貼上封條。
> - 同時間，在 **|調度引擎|** 泳道：系統計算配送里程、搜尋附近空閒外送員並派送接單推播；在 **|外送員|** 泳道，外送員點擊接單並騎車前往餐廳。
> **同步里程碑：** 外送員抵達櫃檯時，必須等待『餐點包裝完成』且『外送員已經抵店』兩項條件皆達成，才能進行實體交餐。
> 交餐後，外送員騎車前往顧客地址，顧客輸入 OTP 驗證簽收，流程結束。」

</div>
</div>

<!--
這是一份引導 AI 產出多泳道並行活動圖的示範提示詞。

請看左側的約束細節：
我們為 AI 規定了四個清楚的泳道分工，並特別強調了 Fork 分岔與 Join 結合的物理意義。
更重要的是，我們在需求中定義了「同步里程碑」：餐點不能無人取件變冷，司機也不能空手離開。

透過這份 Prompt，AI 會生成非常乾淨的 PlantUML 代碼，完美呈現兩條支流的同時展開與匯合。

總結這張投影片，請記住這個核心觀念：明確定義並行支流與結合里程碑，能讓 AI 正確處理多角色非同步工作流。
-->

---

### 課堂互動討論：外送平台廚房與外送並行流程 (雙人同儕討論)

<div class="discussion-columns">
  <div class="discussion-text">

  **雙人同儕討論：外送平台業務並行性與泳道當責劃分**
  - **工程情境：** 訂單扣款成功的瞬間，餐點製作與外送司機調度必須同時平行展開。
  - **四大多方泳道：** `顧客`, `餐廳廚房`, `調度引擎`, `外送員`。
  - **與鄰座同學討論（限時 3 分鐘）：**
    1. 在扣款成功後，**分岔棒 (Fork Bar)** 應放在哪裡？哪兩條平行分支被同時啟動？
    2. **結合棒 (Join Bar)** 必須在何處進行同步？為什麼司機不能在未結合前就逕自啟程前往顧客住處？
    3. 若司機抵達餐廳時廚房還在煮麵（競態條件），活動圖如何自然呈現這種「等待狀態」？

  </div>
  <div class="discussion-logo">
    <img src="../../img/ch04/icons/discussion_icon.svg" alt="Discussion Icon" />
  </div>
</div>

<!--
讓我們進入 Section 4.6 的雙人同儕討論：外送平台業務並行性與泳道當責劃分！請轉頭與夥伴組成營運流程架構小組。

請探討題目中的三個並行工程問題：
第一，分岔發生在何時？付款完成瞬間，廚房開始炒菜，調度引擎開始計算 GPS 媒合司機。
第二，結合點在哪裡？兩者在取餐櫃檯交會，必須兩者皆到位才能繼續。
第三，競態條件：司機先到，菜還沒好；或是菜先好，司機還在塞車。在活動圖的執行語義（Token 語義）中，這如何被優雅處理？

花三分鐘與你的夥伴討論這三個問題。

參考解答與架構復盤：
1. Fork 棒：緊接在『扣款成功』之後，分支一進入『餐廳廚房』備餐包裝，分支二進入『調度引擎』派單並由『外送員』騎車前往店家。
2. Join 棒：設在『櫃檯交接餐點』之前，因為配送貨物必須同時滿足『食物已煮熟打包』與『配送員已抵達現場』兩個條件。
3. 等待狀態：Join 棒在 UML 語義中天生就是一個同步屏障（Synchronization Barrier）。先到達的分支 token 會停留在結合棒前方掛起等待，直到另一條分支的 token 也抵達，結合棒才會釋放一個新的 token 往下執行，完美避免了空手送餐的災難。

總結這張投影片，請記住這個核心觀念：活動圖的 Fork 與 Join 機制能優雅捕捉分散式並行流程與同步等待屏障。
-->

---

### 觀念檢核測驗 6 (CCQ 6)
<!-- id: ase-ch04-ccq6 -->
<div class="ccq-columns">
<div class="ccq-text">

在 UML 活動圖中，**分岔/結合 (Fork/Join 同步條)** 與 **決策/合併 (Decision/Merge 菱形)** 的核心差異為何？

- **A.** Fork/Join 用於將單一流程切分為多條「並行同時執行」的執行緒；Decision/Merge 則依據布林條件由多條路徑中「嚴格選擇其一 (互斥)」執行。
- **B.** Fork/Join 用於類別繼承；Decision/Merge 用於物件實體化。
- **C.** Fork/Join 只能處理資料流；Decision/Merge 只能處理錯誤例外。
- **D.** Fork/Join 必須等待人工確認；Decision/Merge 由系統計時器自動觸發。

</div>
<div class="ccq-logo">
    <a href="https://nlhsueh.github.io/nickedupocket/#/student/ase-ch04-ccq6" target="_blank"><img src="../../img/ch04/ase-ch04-ccq6.png" alt="QR Code" /></a>
  </div>
</div>

<!--
讓我們透過觀念檢核測驗 6 來驗收對活動圖並行節點與條件決策差異的理解。請掃描 QR Code 或點選連結進行線上作答。

題目問的是：Fork/Join 同步粗棒與 Decision/Merge 菱形的核心行為差異是什麼？

分析選項：
選項 B 混淆了結構化物件導向概念（繼承與實體化）。
選項 C 與資料流或例外處理無關。
選項 D 憑空捏造了人工確認與計時器的假規則。

選項 A 是正確答案！Fork 粗黑橫棒將單一控制流切分為多條平行並行執行緒，Join 則等待所有並行執行緒皆完成才放行；而 Decision 菱形是根據條件由多條路徑中嚴格二選一或多選一（互斥）。

總結這張投影片，請記住這個核心觀念：Fork/Join 管理多執行緒平行並行任務，而 Decision/Merge 負責互斥條件決策。
-->

---

<!-- _class: lead -->
<!-- header: '4.7 行為與狀態機模型' -->

# **4.7 行為與狀態機模型**

> "軟體系統在動態執行中的行為，取決於它當下所處的狀態，以及觸發狀態轉移的事件。"

<!--
歡迎來到第 4.7 節：行為與有限狀態機模型 (State Machine Diagrams)。

到目前為止，我們學習了類別圖（靜態結構）、循序圖（物件互動）以及活動圖（業務工作流）。

然而，在許多反應型系統中——例如自動駕駛、智慧空調、或是外送訂單系統——物件的行為取決於它「當前處於什麼狀態」。

在這一節中，我們將深入探討狀態機如何塑模離散狀態、事件觸發、狀態轉移、動作與活動、複合狀態以及系統歷史記憶。

總結這張投影片，請記住這個核心觀念：狀態機模型用來描繪反應型系統如何隨著時間與外部事件，在離散狀態之間精準流轉。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_state_machine/01_anatomy_of_state_dependent_behavior.jpg" alt="The Anatomy of State-Dependent Behavior" />
</div>

<!--
請看這張全景藍圖：『狀態相依行為的架構剖析 (The Anatomy of State-Dependent Behavior)』。

在軟體工程中，許多系統並不是無狀態的（Stateless）。它們不只是接收輸入、產生輸出，它們會「記住自己身在何處」！

系統面對同一個刺激會做出什麼反應，根本上取決於它目前的內部狀態。

UML 狀態機圖為我們提供了一套清晰且嚴謹的視覺框架，用來設計、拆解並驗證這些狀態相依的系統。

總結這張投影片，請記住這個核心觀念：狀態機圖為行為取決於內部狀態的反應型軟體實體，提供了形式化的設計框架。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_state_machine/02_same_event_different_results.jpg" alt="The Same Event Yields Different Results Based on State" />
</div>

<!--
請看這個最直觀的經典範例：『相同事件因狀態不同而產生完全不同的結果』。

看看圖中的電燈開關：當外部事件 `pressSwitch()` 發生時，它抵達了代表電燈狀態的菱形。

如果電燈當前處於「關閉狀態 (Off)」，順著藍色路徑，按開關會「打開電燈 (Turn Light On)」。

但如果電燈當前處於「開啟狀態 (On)」，順著紅色路徑，按下完全相同的開關，卻會「關閉電燈 (Turn Light Off)」！

系統的回應不僅僅是由輸入事件決定，而是完全取決於它過去的歷史與當前的狀態。

總結這張投影片，請記住這個核心觀念：在狀態相依系統中，完全相同的事件在不同狀態下會觸發截然不同的行為結果。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_state_machine/03_positioning_within_uml_ecosystem.jpg" alt="Positioning the Tool Within the UML Ecosystem" />
</div>

<!--
請看狀態機圖在整個 UML 生態系中的戰略定位，特別是對比右邊的循序圖：

右邊的循序圖，追蹤的是「多個協同物件在單一線性情境下的訊息傳遞」。它展示的是特定業務流程下的物件通訊。

左邊的狀態機圖則剛好相反！它將鏡頭拉近至「單一獨立物件（例如一張訂單或一個網路連線）」，完整描摹它一生中面對「所有可能事件與狀態」的全貌。

一句話總結：循序圖看的是「一個情境下的許多物件」，狀態機圖看的是「一個物件的一生所有情境」。

總結這張投影片，請記住這個核心觀念：循序圖描繪多物件在單一情境的互動，狀態機圖則聚焦單一物件跨越所有情境的生命週期。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_state_machine/04_state_defined_lifecycle_interval.jpg" alt="A State is a Defined Interval in an Object's Lifecycle" />
</div>

<!--
究竟什麼是『狀態 (State)』？請看圖中的定義與三個標號說明。

狀態絕非一瞬間的動作，而是物件生命週期中一段「持續存在的時間區間 (Time Interval)」。

圖中標註了三個核心元素：
第 1 點是 Initial Pseudo-State（初始偽狀態，實心黑圓圈）——物件生命週期的起跑線。
第 2 點是 The State（狀態本體）——條件被滿足、持續執行活動、或等待事件發生的活躍時間區間。
第 3 點是 Final State（終止狀態，牛眼圓圈）——物件生命週期的終點。

對於不會關機的連續運作系統（例如作業系統核心或恆溫控制器），終止狀態通常可以省略。

總結這張投影片，請記住這個核心觀念：狀態是物件生命週期中一段持續的時間區間，介於初始建立與最終終止之間。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_state_machine/05_four_triggers_of_state_transitions.jpg" alt="The Four Triggers That Initiate State Transitions" />
</div>

<!--
推動系統在不同狀態間流轉的四種觸發事件 (Triggers)：

左上角是訊號事件 (Signal Event，閃電圖標)：接收到外部傳來的非同步訊息或封包。
右上角是呼叫事件 (Call Event，齒輪圖標)：呼叫端調用了物件上的某個方法或操作。
左下角是時間事件 (Time Event，沙漏圖標)：經過了指定的時間間隔，例如 `after(30s)`。
右下角是變更事件 (Change Event，中括號圖標)：某個布林運算式成立的瞬間，例如 `when(temp > 100)`。

這四種事件構成了狀態機運作的全部感知來源。

總結這張投影片，請記住這個核心觀念：狀態轉換由四種事件觸發——非同步訊號、方法呼叫、經過時間與條件成立。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_state_machine/06_mechanics_of_a_transition.jpg" alt="The Mechanics of a Transition" />
</div>

<!--
請看狀態轉換的運作機制，這張圖用了一座極為生動的『漏斗機器』來做比喻！

先看上方的法定公式：
[來源狀態] + (事件) + [動作] = [目標狀態]。

現在跟著機器走一遍：
藍色的球代表「事件 (Event)」，掉入漏斗中。
拉桿控制著「守衛條件 [Guard Condition]」。只有當守衛條件為真時，閥門才會打開！
球通過旋轉的齒輪，這代表執行「動作 / Action」——瞬間完成的原子操作。
最後球滾出管道，穩穩落入「目標狀態 (Target State)」的箱子中！

如果轉換箭頭上沒有指定任何事件，它就是一個「自動完成轉換」，會在內部活動結束時自動觸發。

總結這張投影片，請記住這個核心觀念：狀態轉換需在事件發生且守衛條件為真時放行，並在轉移瞬間執行原子動作。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_state_machine/07_actions_vs_activities.jpg" alt="Execution Engines: Actions vs. Activities" />
</div>

<!--
這張投影片點出了 UML 中最核心也最常被考到的觀念：動作 (Actions) 與活動 (Activities) 的本質差異！

請逐行比對表格中的四個維度：
第一，本質 (Nature)：動作是「原子計算」（例如呼叫方法或釋放物件）；活動是「非原子計算」。
第二，持續時間 (Duration)：動作是「瞬間完成」的，邏輯耗時為零；活動則是「持續進行」的，耗時較長。
第三，可中斷性 (Interruptibility)：特別看有顏色的字！動作「絕對不可被中斷」；活動則「隨時可以被事件中斷」！
第四，觸發時機 (Triggers)：動作在進入、離開或轉換時瞬間執行；活動則在停留於狀態期間持續執行 (`do /`)。

總結這張投影片，請記住這個核心觀念：Action 是瞬間不可中斷的原子操作，Activity 則是耗時進行且隨時可被事件中斷的持續計算。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_state_machine/08_entry_and_exit_actions.jpg" alt="Boundary Executions: Entry and Exit Actions" />
</div>

<!--
請看狀態邊界的防護機制：進入動作 (Entry Action) 與離開動作 (Exit Action)。

圖中展示了名為 `Check Book Status` 的狀態，裡面維護著一個 `BookCopy Object`。

注意左側進入邊界的藍色火花：`entry / action`。無論是從哪一條轉換路徑來到這個狀態，只要跨入邊界，這個動作保證百分之百立即執行！
注意右側離開邊界的紅色火花：`exit / action`。無論是因為什麼事件要離開這個狀態，只要跨出邊界，這個動作保證百分之百立即執行清理！

這讓初始化與資源釋放邏輯與狀態邊界牢牢綁定，避免在每條進入或離開的箭頭上重複撰寫程式碼。

總結這張投影片，請記住這個核心觀念：Entry 與 Exit 動作確保每次跨越狀態邊界時，初始設定與資源釋放保證絕對執行。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_state_machine/09_scaling_architecture_complexity_matrix.jpg" alt="Scaling Architecture: The Complexity Matrix" />
</div>

<!--
當系統變得龐大時，扁平狀態圖會變成無法閱讀的蜘蛛網。看 UML 如何透過三種狀態層次解決複雜度：

第一欄是「簡單狀態 (Simple State)」：如 `Active`，單一且不可分割的原子狀態。
第二欄是「複合狀態 (Composite State)」：如 `Heater`，它像一個容器，內部封裝了 `Idle`、`Heating`、`Cooling` 等巢狀子狀態，有效隱藏內部細節！
第三欄是「並行狀態 (Concurrent State)」：水平虛線將狀態切分為兩條並行軌道，上方是 Task A1 到 A2，下方是 Task B1 到 B3，兩者同時並行執行！

總結這張投影片，請記住這個核心觀念：複合狀態與並行狀態透過階層巢狀與平行分區，徹底解決大規模狀態爆炸的架構難題。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_state_machine/10_composite_states_and_history.jpg" alt="Composite States and System Memory" />
</div>

<!--
當系統被突發事件中斷時，如何記住上次停在哪裡？請看複合狀態與歷史記憶節點 (History State, [H])。

一般情況下，進入複合狀態時，一律會從最前面的 Substate A 重新開始。

但是想像一下：你在寫信時突然來了一通電話，講完電話切回信箱時，你希望從頭開始寫，還是回到剛才寫了一半的畫面？當然是回到剛才的地方！
圖中的 `(H)` 圓圈就是「歷史狀態記憶槽」。
當系統離開 Substate B 時，快取 (Cache) 記住了這個位置。
當系統稍後從外部重新進入 `(H)` 時，指標直接精準跳回 Substate B！

總結這張投影片，請記住這個核心觀念：歷史狀態節點作為快取記憶槽，能讓系統在中斷復原後直接回到上次活躍的子狀態。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_state_machine/11_concurrency_fork_and_join.jpg" alt="Concurrency: Forking and Joining Execution Threads" />
</div>

<!--
請看狀態機如何處理多執行緒平行任務：Fork 分流與 Join 聚合。

以圖中的線上拍賣系統為例：
`Auction Trigger` 抵達左側粗黑垂直的 Fork 橫線。
單一流程立刻被分流為兩條並行軌道：上方執行 `Processing the Bid`（出價處理），下方同時執行 `Authorizing Payment Limit`（授權額度驗證）。

兩條並行路徑最後都匯入右側粗黑垂直的 Join 橫線。
系統會在 Join 處等待兩條軌道都順利完成。
只有當兩者都抵達時，轉換才會正式放行並往下推進。

總結這張投影片，請記住這個核心觀念：Fork 將流程分流為並行子狀態，Join 則等待所有並行軌道完成後才進行同步放行。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_state_machine/12_unified_blueprint_hvac_example.jpg" alt="The Unified Blueprint: HVAC Heating/Cooling System" />
</div>

<!--
這就是狀態機的綜合實戰藍圖：智慧空調 (HVAC Heater System)！

看看這個架構有多麼優雅嚴整：
中央垂直虛線將整個系統切分為兩個並行運作的區域：左邊是 Thermostat Control（恆溫控制），右邊是 Fan Operation（風扇運轉）。

左側恆溫控制從初始起點進入 `Idle`，當 `temp < setpoint` 訊號到達時轉入 `Heating`，同時瞬間執行原子進入動作 `entry / activate_burner`，並配有歷史快取 `(H)`。
右側風扇運作則獨立根據風速請求訊號，在 `Fan Low`、`Fan High` 與 `Fan Off` 之間靈活轉移。

透過並行分區、清晰事件觸發與邊界動作，複雜的實體行為被組織得井然有序。

總結這張投影片，請記住這個核心觀念：真實工程架構將並行分區、進入動作、事件觸發與歷史記憶整合為單一嚴整藍圖。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_state_machine/13_operationalizing_behavioral_logic_ai.jpg" alt="Operationalizing Behavioral Logic with AI" />
</div>

<!--
總結 4.7 節：利用生成式 AI 將行為邏輯落地。

請看左側的 Prompt 提示詞：我們要求 AI「建立一個拍賣系統，包含並行的出價處理與付款授權，並為暫停的拍賣配置歷史狀態」。

看右側建模工具產出的成果：AI 精準建立了包含 `Bid Processing` 與 `Payment Authorization` 兩個並行分區的狀態機，並在 `Suspended` 狀態配置了 `(H)` 歷史節點！

現代架構師不再需要手動拖拉圖框，而是撰寫精確的行為規則交由 AI 生成，將心力專注於審查守衛條件與邊界安全性。

總結這張投影片，請記住這個核心觀念：AI 工具能秒級將自然語言規則轉譯為嚴謹的狀態機模型，工程師則專注審查邊界與守衛。
-->

---

## AI 輔助指南：狀態機塑模 (State Machine Modeling)

- **1. 角色設定與形式化檢驗紀律 (Persona & Formal FSM Discipline)：**
  - 指示 AI 扮演「形式化系統驗證與有限狀態機 (FSM) 專家」。
  - **狀態命名嚴格紀律：** 狀態名稱必須代表物件的「客觀穩態條件」，一律採用形容詞或過去分詞（如 `Placed`, `Preparing`, `Delivered`），嚴禁使用動詞當作狀態名稱！
- **2. 轉換語法與防禦性不變量約束：**
  - **法定語法公式：** 強制要求轉換連線必須遵循 `事件名稱 [守衛條件] / 執行動作`。
  - **進入/離開動作：** 對於具備資源配置或通知的關鍵狀態，明確定義 `entry /` 與 `exit /`。
  - **嚴格封鎖非法路徑：** 明確宣告哪些狀態之間「絕對禁止跳轉」（例如配送中嚴禁直接點擊取消）。
- **3. 架構師人工審查清單 (Verification Checklist)：**
  - [ ] 是否存在無法抵達的「孤島狀態」或進得去出不來的「死結陷阱」？
  - [ ] 守衛條件 `[guard]` 是否互斥且覆蓋所有可能？
  - [ ] 終止狀態 (`[*]`) 是否正確對應至業務的終結？

<!--
引導 AI 產生狀態機圖時，最常見的失誤是「把狀態寫成動作」以及「遺漏非法跳轉的防護」。

初學者或 LLM 常常把狀態命名為『烹調餐點』、『指派司機』——這完全混淆了活動與狀態！狀態必須是『已接單』、『備餐中』或『已送達』。

透過在 Prompt 中要求遵循 UML 標準公式『事件 [守衛] / 動作』，並命令它設置進入與離開動作，就能產出具備強大防禦力、杜絕非法業務跳轉的狀態機。

總結這張投影片，請記住這個核心觀念：約束狀態為過去分詞命名、嚴格規範轉換語法公式並定義例外守衛，能確保 AI 產出數學上嚴格正確的狀態機。
-->

---

## AI 提示詞範例：外送平台訂單生命週期狀態機模型

<div class="two-columns">
<div>

**1. 角色設定與任務指令：**
```text
你是一位形式化驗證工程師。
請根據以下訂單生命週期規則，產生標準合規的
PlantUML 狀態機圖 (State Machine Diagram)。
```

**2. 塑模約束條件：**
- 狀態清單：`Placed`, `Accepted`, `Preparing`, `ReadyForPickup`, `OutForDelivery`, `Delivered`, `Cancelled`。
- 轉換標籤必須遵循 `Event [Guard] / Action`。
- `OutForDelivery` 狀態必須包含 `entry / startGPSTracking()`。
- 僅允許在 `Placed` 與 `Accepted` 狀態下取消 `[cancellationWindow <= 120s]`；進入 `Preparing` 後嚴禁取消。

</div>
<div>

**3. 輸入需求敘述 (Requirements Statement)：**
> 「**Order** 生命週期從 `[*]` 開始，顧客完成扣款後進入 **Placed** (已下單)。
> 在 **Placed** 狀態下，餐廳點擊接受則觸發 `acceptOrder` 進入 **Accepted**；若餐廳拒絕則觸發 `rejectOrder` 進入 **Cancelled** `/ issueFullRefund()`。
> 顧客在 **Placed** 或 **Accepted** 狀態下可主動觸發 `cancelOrder`，但必須滿足守衛條件 `[timeElapsed <= 120s]` 才能轉入 **Cancelled**。
> 當廚房點擊開始做菜，觸發 `startCooking` 進入 **Preparing**；此時取消路徑完全鎖死。
> 餐點打包完成後觸發 `packagingComplete` 進入 **ReadyForPickup**。
> 外送員抵達掃描條碼後觸發 `courierPickedUp` 進入 **OutForDelivery**，同時執行 `entry / startGPSTracking()`。
> 顧客輸入 OTP 簽收後觸發 `confirmDropoff` 進入終止狀態 **Delivered**，最後轉入 `[*]`。」

</div>
</div>

<!--
請看這份外送訂單生命週期的 AI 提示詞示範。

注意左側的約束有多麼嚴密：
我們列舉了七個嚴格的狀態名稱，全部是過去分詞；我們明確指示了 OutForDelivery 的 entry 動作。
最關鍵的是業務防禦規則：一旦進入 Preparing，取消訂單的路徑直接封閉，且取消動作受 120 秒超時守衛保護。

這份提示詞送給 LLM，產出的狀態機代碼能直接作為後端開發者撰寫狀態模式 (State Pattern) 或 Spring StateMachine 的骨幹規格。

總結這張投影片，請記住這個核心觀念：明確列舉合法狀態、轉換語法與取消守衛邊界，能引導 AI 產出杜絕業務漏洞的狀態機模型。
-->

---

### 課堂互動討論：外送平台訂單生命週期與不變量 (雙人同儕討論)

<div class="discussion-columns">
  <div class="discussion-text">

  **雙人同儕討論：守衛離散狀態轉換與捍衛業務不變量**
  - **工程情境：** 建立外送平台中核心 `Order` 實體的完整生命週期狀態機。
  - **關鍵狀態：** `Placed`, `Accepted`, `Preparing`, `ReadyForPickup`, `OutForDelivery`, `Delivered`, `Cancelled`。
  - **與鄰座同學討論（限時 3 分鐘）：**
    1. **合法性轉換：** 當訂單處於 `OutForDelivery` (外送中) 狀態時，顧客點擊「取消訂單」事件是否應被允許？在狀態機上應如何防禦？
    2. **守衛條件設計：** 請為 `Placed → Cancelled` 的轉換撰寫一段嚴謹的布林守衛條件 `[guard]`（例如考慮時限與廚房狀態）。
    3. **進入動作：** 當訂單進入 `OutForDelivery` 狀態時，應配置什麼 `entry /` 動作以即時觸發外部系統？

  </div>
  <div class="discussion-logo">
    <img src="../../img/ch04/icons/discussion_icon.svg" alt="Discussion Icon" />
  </div>
</div>

<!--
讓我們來到 Section 4.7 的雙人同儕討論：外送平台訂單生命週期與不變量！請戴上系統完整性與防禦性架構師的帽子。

探討題目中的三個關鍵業務邊界問題：
第一，非法跳轉防禦：司機都在路上跑了，顧客按取消怎麼辦？狀態機怎麼處理？
第二，撰寫守衛條件：在剛下單狀態，顧客按取消，需要符合哪些條件才能放行？
第三，進入動作：進入配送中，系統應自動做些什麼？

花三分鐘與你的夥伴討論這三個問題。

參考解答與架構復盤：
1. 合法性轉換：在 `OutForDelivery` 狀態下，`cancelOrder` 事件屬於非法操作！在狀態機中，我們『完全不為該狀態繪製指向 Cancelled 的轉換箭頭』。任何未定義的事件到達，狀態機一律直接忽略或拋出例外，這從根本上杜絕了在路上退單的業務漏洞。
2. 守衛條件：`Placed -> Cancelled` 上標註 `[currentTime - placedTime <= 120s && kitchenStatus == NotStarted]`。若超時或廚房已備料，守衛評估為 false，轉換被拒絕。
3. 進入動作：`entry / broadcastCourierEnRoute(); activateLiveGPSStream()`，一進入該狀態就自動啟動 GPS 地圖串流並向顧客推播訊息。

總結這張投影片，請記住這個核心觀念：狀態機透過不開放非法轉換箭頭與配置嚴密守衛條件，捍衛了系統不可逾越的業務邊界。
-->

---

### 觀念檢核測驗 7 (CCQ 7)
<!-- id: ase-ch04-ccq7 -->
<div class="ccq-columns">
<div class="ccq-text">

在 UML 狀態機圖中，**動作 (Action，如 transition 上的 `/ refund()` 或 `entry /`)** 與 **活動 (Activity，如 `do /`)** 最根本的執行語義差異為何？

- **A.** Action 是瞬間完成、不可中斷的原子性操作；Activity 是耗時進行的持續運算，且可被外來事件隨時中斷。
- **B.** Action 只能寫 Python；Activity 只能寫 SQL。
- **C.** Action 只能在進入狀態時執行；Activity 只能在離開狀態時執行。
- **D.** Action 專門處理例外失敗；Activity 專門處理成功路徑。

</div>
<div class="ccq-logo">
    <a href="https://nlhsueh.github.io/nickedupocket/#/student/ase-ch04-ccq7" target="_blank"><img src="../../img/ch04/ase-ch04-ccq7.png" alt="QR Code" /></a>
  </div>
</div>

<!--
讓我們透過觀念檢核測驗 7 來檢驗對狀態機執行語義的掌握。

分析題目選項：
選項 B 與 D 混淆了具體技術與形式化 UML 語意。
選項 C 混淆了進入與離開動作。

正確答案是 A！在 UML 狀態機語意規格中：
Action（轉換動作、entry/、exit/）概念上邏輯耗時為零，具備原子性且絕對不可中斷。
Activity（以 `do /` 宣告）則代表一段耗時運算，只要有任何觸發狀態轉換的外來事件到達，該活動會被立即中斷並退出狀態。

總結這張投影片，請記住這個核心觀念：Action 是瞬間不可中斷的原子操作，Activity 則是耗時進行且隨時可被事件中斷的持續計算。
-->

---

<!-- _class: lead -->
<!-- _class: lead -->
<!-- header: '4.8 PlantUML 宣告式文字塑模' -->

# **4.8 PlantUML 宣告式文字塑模**

> "告別手動拖拉圖框的痛苦。架構即代碼，讓軟體模型與程式碼在 Git 倉儲中一同進化。"

<!--
歡迎來到第 4.8 節：PlantUML 宣告式文字塑模 (Text-Based Modeling with PlantUML)。

長期以來，許多工程師對 UML 敬而遠之，最大的痛點就是傳統 GUI 工具極度繁瑣：手動拖拉圖框、微調箭頭像素，而且二進位檔完全無法在 Git 中進行版本比對與審查。

PlantUML 帶來了「架構即代碼 (Diagram-as-Code)」的重大革新！

我們只需要撰寫清晰易讀的純文字標記，模型就能與源碼一同存放在 Git 倉儲中，在 Pull Request 中進行 diff 審查，並由引擎自動編譯渲染。

總結這張投影片，請記住這個核心觀念：PlantUML 實現了代碼驅動的架構塑模，消除手動排版負擔並完美整合 Git 工作流。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_plantuml/01_plantuml_code_driven_architecture.jpg" alt="UML Modeling with PlantUML: Code-Driven Architecture" />
</div>

<!--
請看這張視覺開場：『UML Modeling with PlantUML』。

左側是黑底的代碼編輯器，寫著極為簡練的宣告式語法：
`component "Order Service" as OS`
`database "Order DB" as ODB`
`OS --> ODB : Stores Order Data`

注意那道橘色箭頭穿透像素方塊，直接噴發到右側的架構圖中！

右側的渲染引擎自動將文字轉譯為清晰的 User Interface、Order Service 與 Order DB 結構圖。

你負責撰寫文字邏輯，排版與美化全部交由引擎自動完成！

總結這張投影片，請記住這個核心觀念：PlantUML 能秒級將純文字腳本自動轉譯為標準合規且美觀的架構圖表。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_plantuml/02_stop_dragging_start_writing.jpg" alt="Stop Dragging Boxes. Start Writing Architecture." />
</div>

<!--
這就是文字塑模的核心哲學：『停止拖拉方塊，開始以代碼撰寫架構』。

看看左邊的白板：歪歪斜斜的方塊、糾纏混亂的箭頭，還有一隻打著叉叉的哭泣滑鼠——這代表著傳統繪圖方式的「緩慢、手動與脫節」。

再看看右邊：深色編輯器裡只有簡短幾行定義 `User` 與 `Order` 的代碼，右邊立刻生成帶有 `1` 到 `*` 多重性關聯的發光類別圖——代表著「即時、版本控制與標準化」。

省下 80% 調整像素的時間，把精力集中在真正的架構決策上！

總結這張投影片，請記住這個核心觀念：文字化塑模消除了手動排版的疲勞，讓架構圖直接融入軟體工程的標準流程。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_plantuml/03_frictionless_setup.jpg" alt="The Frictionless Setup: VS Code Extension & Local Rendering" />
</div>

<!--
請看零摩擦的開發環境設定，只需三個簡單步驟：

第一步（Install）：在 VS Code 市集中安裝 PlantUML 擴充套件。
第二步（Write）：建立副檔名為 `.puml` 的文字檔案。
第三步（Render）：按下快速鍵 `Alt + D`（Mac 上按 `Option + D`），即可啟動即時視覺預覽！

看看下方的 VS Code 視窗：
左側編輯器在輸入 `class Car` 時，享有語法高亮（標號 1）與代碼自動補全（標號 2）。
右側視窗即時渲染出 Car 類別框，還能直接匯出為 PNG、SVG 或 ASCII 圖（標號 3）！

總結這張投影片，請記住這個核心觀念：PlantUML 與主流編輯器無縫整合，提供輸入即預覽的極致開發體驗與多格式匯出能力。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_plantuml/04_five_essential_lenses.jpg" alt="The Architect's Blueprint: 5 Essential Lenses" />
</div>

<!--
請看架構師的五大核心透鏡樹狀圖：

UML 圖表整體分支為兩大體系：

上方分支是「結構圖 (Structure Diagrams)」——靜態的系統藍圖，由類別圖 (Class Diagram) 掛帥，定義系統中的物件、屬性與操作。

下方分支是「行為圖 (Behavior Diagrams)」——動態運轉中的系統，涵蓋四大透鏡：
- 使用案例圖 (Use Case)：高階系統功能與參與者互動。
- 活動圖 (Activity)：業務流程與控制流轉。
- 循序圖 (Sequence)：跨時間的循序物件互動。
- 狀態圖 (State)：單一物件在不同條件下的生命週期。

一套 PlantUML 語法，就能同時駕馭結構與行為五大模型！

總結這張投影片，請記住這個核心觀念：PlantUML 以統一的語法體系，同時涵蓋一大結構模型與四大行為動態模型。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_plantuml/05_use_case_in_plantuml.jpg" alt="Use Case Diagrams in PlantUML Syntax" />
</div>

<!--
看看用 PlantUML 繪製使用案例圖有多麼簡單：

請看左側的代碼與兩條粉紅色對應箭頭：
輸入 `actor Customer`，立刻生成代表外部參與者的火柴人圖示！
輸入 `usecase Login` 與 `usecase Checkout`，立刻生成代表系統功能的橢圓形！
接著用 `Customer --> Login` 與 `Customer --> Checkout` 連線，關聯瞬間完成。

短短四行文字，就能在撰寫任何實作程式碼之前，精確鎖定敏捷開發的高階需求邊界。

總結這張投影片，請記住這個核心觀念：PlantUML 透過 actor 與 usecase 等直覺關鍵字，快速勾勒參與者與功能邊界。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_plantuml/06_class_diagrams_in_plantuml.jpg" alt="Class Diagrams in PlantUML Syntax" />
</div>

<!--
現在檢視類別圖的宣告式語法：

注意左側代碼的三段內容，精準對應到右側類別框的三個隔層：
`class Animal` 對應到頂層的類別名稱（The Blueprint）。
`int id` 與 `String name` 對應到中間層的屬性欄位（Attributes）。
`+int getId()` 與 `+void makeSound()` 對應到底層的操作方法（Operations/Methods）。

左上角提示了關鍵的可見度標記：`+` 代表 public、`-` 代表 private、`#` 代表 protected。
寫類別圖的感覺，就跟撰寫標準物件導向程式碼一模一樣！

總結這張投影片，請記住這個核心觀念：PlantUML 類別圖語法高度貼合物件導向程式碼習慣，具備直覺的三層區塊與可見度宣告。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_plantuml/07_class_relationships_matrix.jpg" alt="The Class Relationship Matrix in PlantUML Syntax" />
</div>

<!--
請看這份極具助記效果的類別關聯符號矩陣：

PlantUML 的符號設計充滿了象形巧思：
- 繼承 (Inheritance)：`<|--`，尖角三角形指向父類別。
- 關聯 (Association)：`--`，一條乾淨的實線。
- 聚合 (Aggregation)：`o--`，小寫字母 o 剛好畫出一顆空心菱形，代表部分可獨立存在。
- 組合 (Composition)：`*--`，星號剛好畫出一顆實心菱形，代表同生共死的強烈擁有權。

因為長得就像 UML 的箭頭，工程師完全不需要死背，單憑視覺直覺就能在鍵盤上敲出關聯。

總結這張投影片，請記住這個核心觀念：ASCII 象形符號（如 `<|--`、`o--`、`*--`）讓類別關聯的建立迅速、自然且不易出錯。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_plantuml/08_sequence_diagrams_in_plantuml.jpg" alt="Sequence Diagrams in PlantUML Syntax" />
</div>

<!--
循序圖是 PlantUML 最受開發者喜愛的殺手級功能：

循序圖捕捉動態行為與 API 調用，時間軸由上至下垂直流動。

看左側的代碼：
宣告 `participant User` 與 `participant OrderService`。
`User -> OrderService : Request to place order`（實線箭頭發送請求）。
`OrderService --> User : Confirm order placement`（虛線箭頭回傳結果）。

右側的生命線、啟動長條與水平訊息流全部自動生成對齊，毫無手動拉線的痛苦。

總結這張投影片，請記住這個核心觀念：PlantUML 循序圖將日常的對話式文字敘述，秒級轉化為精準對齊的時序訊息互動圖。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_plantuml/09_anatomy_of_sequence_syntax.jpg" alt="Anatomy of Sequence Syntax: Lifelines & Messages" />
</div>

<!--
請看循序圖解剖學中的四大核心元素（橘色標籤）：

第一，生命線 (Lifelines)：垂直虛線，代表參與協同的物件或微服務元件。
第二，訊息 (Messages)：水平橫向箭頭，代表生命線之間的通訊互動（例如同步呼叫）。
第三，啟動長條 (Activation Boxes)：覆蓋在生命線上的細長矩形，標示物件正在主動處理運算的活躍期。
第四，生命週期事件 (Lifecycle Events)：專屬的生命週期訊息，例如 `new` 箭頭指向 `New Participant` 框，表示實體的動態建立或銷毀。

在 PlantUML 中，這些視覺元素都能用最簡單的文字關鍵字精準生成。

總結這張投影片，請記住這個核心觀念：循序圖由生命線、訊息箭頭、啟動長條與生命週期事件四大核心視覺骨架所構成。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_plantuml/10_activity_diagrams_in_plantuml.jpg" alt="Activity Diagrams & Swimlanes in PlantUML Syntax" />
</div>

<!--
請看活動圖與業務流程工作流在 PlantUML 中的表現：

注意三條青色箭頭將左邊的文字代碼對齊到右邊的流程節點：
標號 1：`start` 生成黑色的起點圓圈 (Start Node)。
標號 2：`:Customer Login;` 與 `:Add to Cart;` 用冒號與分號包覆，生成圓角矩形的動作狀態 (Action States)。
標號 3：`stop` 生成牛眼圓圈的終點節點 (End Node)。

此外，語法還原生支援 `if/then/else` 條件分支與 `|Lane Name|` 泳道分割，宣告流程既簡潔又結構化。

總結這張投影片，請記住這個核心觀念：活動圖透過 start、冒號動作與 stop 等極簡標記，優雅呈現步驟分明的業務流程。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_plantuml/11_state_diagrams_in_plantuml.jpg" alt="State Diagrams in PlantUML Syntax" />
</div>

<!--
請看狀態圖在 PlantUML 中的純文字定義：

活動圖關注多角色流程，狀態圖則嚴格聚焦在「單一物件的生命週期」。

看左側的標準格式框：`StateA --> StateB : Event String`。

沿著圖中粉紅色箭頭追蹤狀態流轉：
`[*] --> NewOrder` 代表生命週期起點。
`NewOrder --> Paid : Payment Processed` 代表付款成功引發狀態跳轉。
`Paid --> Shipped : Order Sent` 代表出貨跳轉。
`Shipped --> [*]` 代表生命週期終止。

幾行文字，就能完整規範單一核心實體面對所有外來事件的離散狀態。

總結這張投影片，請記住這個核心觀念：狀態圖透過箭頭轉換、事件標籤與起終點標記，簡潔定義物件的離散生命週期。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_plantuml/12_cross_diagram_syntax_cheatsheet.jpg" alt="Cross-Diagram Syntax Quick Reference Matrix" />
</div>

<!--
請看這張『架構師的診斷決策矩陣：挑選最適模型 (Choosing Your Model)』：

當面對具體的工程問題時，這張表能指引你選擇正確的視角：
- 使用案例圖 (Use Case)：釐清使用者目標、系統範疇與高階需求。
- 類別圖 (Class)：確立領域實體、欄位屬性與靜態關聯。
- 循序圖 (Sequence)：驗證特定情境下跨物件、跨 API 的時序呼叫合約。
- 活動圖 (Activity)：梳理複雜的業務工作流、條件決策與並行分工。
- 狀態圖 (State)：嚴格規範核心實體的離散狀態流轉與邊界保護。

根據工程痛點對症下藥，選擇最具表現力的 UML 模型。

總結這張投影片，請記住這個核心觀念：根據問題本質選擇最合適的建模透鏡，是卓越架構師的核心診斷素養。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_plantuml/13_holistic_system_view.jpg" alt="The Holistic System View: Linking Models Together" />
</div>

<!--
請看宏觀整體視野 (The Holistic System View)：四大多維模型如何緊密串聯！

看這條貫穿 Stage 1 到 Stage 4 的端到端架構管線：
Stage 1：使用案例 (`Customer Checkout`) 確立了使用者的商業需求...
Stage 2：...這項需求需要循序圖 (`User` 與 `Payment Service` 互動) 來定義時序傳遞...
Stage 3：...這段互動需要類別圖 (`PaymentProcessor`) 建立實體結構與方法...
Stage 4：...最終執行時，會改變訂單在狀態圖中的狀態（從 `Pending` 轉為 `Paid`）！

看底部的核心洞察：UML 各圖表絕非彼此孤立的文件，它們是對同一套軟體系統在不同維度上的重疊視角！

總結這張投影片，請記住這個核心觀念：UML 各圖表不是孤立的畫作，而是同一個軟體實體彼此呼應的立體投影。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_plantuml/14_practical_architecture_workflow.jpg" alt="Practical Architecture Workflow: Code, Render, Iterate" />
</div>

<!--
請看『文檔即代碼 (Docs-as-Code) 的三大核心價值』：

第一張卡片：Version Controlled（版本控制）。圖表與程式碼一同活在 Git 中，歷史紀錄一清二楚，文檔永遠不會脫離實際程式碼而過期。
第二張卡片：Effortless Updates（輕鬆更新）。需求變更時，只需要修改一個單字，不需要手動重畫十幾個方框與重拉對齊連線。
第三張卡片：Standardized Clarity（標準化清晰度）。徹底消除手繪白板照片的模糊與各人自創風格的凌亂，產出全團隊統一、標準的架構規格。

總結這張投影片，請記住這個核心觀念：Docs-as-Code 保證了架構圖表具備可版本控制、極簡維護與全團隊標準化輸出的現代工程特質。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_plantuml/15_elevate_your_architecture.jpg" alt="Master the Syntax, Elevate Your Architecture" />
</div>

<!--
總結 4.8 節，請記住這句箴言：『精通語法，升級你的架構思維！』

優秀的軟體設計，始於高效精準的溝通。

PlantUML 架起了一座連接純文字邏輯與視覺架構的橋樑，讓工程師能以代碼的速度思考，同時以架構的維度溝通。

打開你的 VS Code，安裝擴充套件，開始撰寫你的架構代碼吧！

總結這張投影片，請記住這個核心觀念：文字化塑模融合了文字的精確與圖像的直觀，賦予敏捷團隊最高維度的架構設計生產力。
-->

---

### 觀念檢核測驗 8 (CCQ 8)
<!-- id: ase-ch04-ccq8 -->
<div class="ccq-columns">
<div class="ccq-text">

在軟體架構工程實踐中，相較於傳統以滑鼠手動拖拉圖框的二進位繪圖軟體（如 Visio 或特定商業 CASE 工具），採用 **PlantUML 宣告式文字塑模 (Code-as-Architecture)** 的最核心工程優勢為何？

- **A.** 能保證自動生成 100% 無 Bug 的 Java 實作程式碼，無需單元測試。
- **B.** 可以在純文字中編寫，輕鬆納入 Git 進行精確的行級版本控制、Pull Request 審查與 CI/CD 自動編譯。
- **C.** 完全廢除物件導向原則，讓系統架構不再需要考慮類別或介面。
- **D.** 限制只能產出循序圖，防止工程師建立過多無意義的圖表。

</div>
<div class="ccq-logo">
    <a href="https://nlhsueh.github.io/nickedupocket/#/student/ase-ch04-ccq8" target="_blank"><img src="../../img/ch04/ase-ch04-ccq8.png" alt="QR Code" /></a>
  </div>
</div>

<!--
讓我們透過觀念檢核測驗 8 來檢驗對宣告式文字塑模工程價值的掌握。

分析選項：
選項 A 是誇大不實的神話，模型不能替代軟體測試。
選項 C 完全悖離物件導向宗旨。
選項 D 違背事實，PlantUML 支援全套 UML 圖表。

正確答案是 B！純文字宣告式架構讓模型成為代碼的一部分，享有 Git 行級 Diff、版本歷史比對與團隊 PR Code Review 的完整現代工程優勢。

總結這張投影片，請記住這個核心觀念：文字化塑模讓架構資產得以被 Git 版本控制，消除傳統繪圖二進位檔無法審查與協作的長期痛點。
-->

---

<!-- _class: lead -->
<!-- header: '4.9 概念複習與統整' -->

# **4.9 概念複習與統整**

> "模型是軟體工程的世界語；精通模型，方能洞見架構的真實靈魂。"

<!--
來到第四章的終章：4.9 概念複習與統整。

今天我們完成了一趟跨越歷史、理論、五大核心模型與現代 AI 輔助的壯麗旅程。從 1990 年代的三巨頭整合，到使用案例的功能契約、類別圖的靜態骨幹、循序圖的時間時序、活動圖的並行泳道、狀態機的守衛不變量，最後以 PlantUML 架構即代碼進行統一。

讓我們透過互動小測驗來驗收今天的豐碩學習成果。

總結這張投影片，請記住這個核心觀念：多重視角的系統塑模為我們提供了駕馭軟體內在複雜度最高效、最嚴謹的工程思維架構。
-->

---

## 核心觀念統整：互動填空小測驗

測試你對本章核心架構概念的掌握度：

1. 於 Rational Software 攜手催生 UML 標準化的「UML 三巨頭」為 Grady Booch、Jim Rumbaugh 與 **`___`**。
2. 系統塑模的四大基礎核心視角為外部視角、**`___`** 視角、結構視角與行為視角。
3. 在使用案例模型中，多個使用案例強制共用的必要子程序應使用 **`___`** 關聯。
4. 徹底分離使用者介面、業務邏輯與資料庫持久實體的架構模式稱為 **`___`** 模式。
5. 在 UML 類別圖中，實心黑色菱形 (`◆`) 代表 **`___`** 關聯，部分與整體生命週期緊密綁定連帶銷毀。
6. 在 UML 類別圖中，空心菱形 (`◇`) 代表 **`___`** 關聯，部分具備獨立生存的生命週期。
7. UML 狀態機圖中，轉換標籤的國際標準語法為：事件觸發 [**`___`**] / 執行動作。

<!--
讓我們透過填空小測驗進行熱烈的課堂回顧：

1. 第三位巨頭是發明使用案例與 BCE 的 Ivar Jacobson！
2. 四大核心視角為外部、互動 (Interaction)、結構與行為！
3. 強制共用的必要子程序使用 <<include>> 包含關聯！
4. 分離 UI、邏輯與實體的架構模式是 Boundary-Control-Entity (BCE)！
5. 實心菱形代表生命週期綁定的組合 (Composition)！
6. 空心菱形代表鬆散獨立的聚合 (Aggregation)！
7. 中括號內的布林檢查條件是守衛條件 (Guard Condition)！

大家表現得非常出色！

總結這張投影片，請記住這個核心觀念：這些核心概念構成了現代物件導向軟體架構設計最堅實的基石。
-->

---

## 經典文獻與延伸閱讀 (References)

- **權威經典教科書與國際標準：**
  - Sommerville, I. (2016). *Software Engineering* (10th ed.). Chapter 5: System Modeling. Pearson.
  - Booch, G., Rumbaugh, J., & Jacobson, I. (2005). *The Unified Modeling Language User Guide* (2nd ed.). Addison-Wesley.
  - Fowler, M. (2003). *UML Distilled: A Brief Guide to the Standard Object Modeling Language* (3rd ed.). Addison-Wesley.
  - Cockburn, A. (2000). *Writing Effective Use Cases*. Addison-Wesley.
  - Object Management Group (OMG). (2017). *OMG Unified Modeling Language (OMG UML) Specification*, Version 2.5.1.
- **現代宣告式文字塑模資源：**
  - PlantUML 官方標準網站：[plantuml.com](https://plantuml.com)
  - Mermaid.js 宣告式圖表手冊：[mermaid.js.org](https://mermaid.js.org)

<!--
這裡是第四章的權威經典教科書、OMG 國際標準規格書與現代宣告式文字塑模工具資源。

Grady Booch、Jim Rumbaugh 與 Ivar Jacobson 合著的《UML 使用者指南》與 Martin Fowler 的《UML 精華》是不可不讀的傳世經典。Alistair Cockburn 的專書則是學習撰寫企業級使用案例規格書的金科玉律。

現代工程實務中，請務必善用 PlantUML 享受架構即代碼的高效樂趣。

感謝大家的熱情參與！
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
