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
為什麼需要視覺模型？

純文字規格書往往充滿模糊與歧義，每位工程師閱讀同一段文字可能產生完全不同的架構想像。使用案例模型透過直觀的幾何圖形與邊界框，將抽象的文字需求轉化為團隊一致認可的視覺契約。

總結這張投影片，請記住這個核心觀念：視覺模型能夠消除文字歧義，建立利害關係人之間一致的心理模型。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_use_case/02_business_value_and_user_goals.jpg" alt="Focus: Business Value & User Goals" />
</div>

<!--
到底什麼是使用案例？

使用案例代表外部參與者使用系統所要達成的一個完整、有價值的商業目標。它不是單一的函式調用或按鈕點擊，而是由一系列事件與互動構成的完整業務情境。

總結這張投影片，請記住這個核心觀念：使用案例聚焦於為參與者交付完整的端到端商業價值。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_use_case/03_actor_taxonomy.jpg" alt="Actor Taxonomy" />
</div>

<!--
接著探討參與者 (Actor) 的觀念。

在 UML 中，參與者可以是人類使用者，也可以是與系統對接的外部軟體系統或硬體設備。請特別注意：參與者代表的是一種「角色 (Role)」，而非具體的「個人姓名」或「內部組織部門」。

總結這張投影片，請記住這個核心觀念：參與者代表與系統互動的外部角色，而非內部人員或特定職稱。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_use_case/04_relationship_matrix.jpg" alt="Relationship Matrix: Association, Include, Extend, Generalization" />
</div>

<!--
使用案例圖中存在四種基本關聯。

第一是參與者與使用案例之間的關聯線；第二是使用案例之間的包含關聯 (Include)；第三是擴充關聯 (Extend)；第四是參與者之間的泛化繼承 (Generalization)。掌握這四種關聯，就能精確表達所有業務互動。

總結這張投影片，請記住這個核心觀念：熟練運用包含、擴充與泛化，能讓複雜的功能模型具備清晰的層次與模組化架構。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_use_case/05_clear_naming_semantics.jpg" alt="Clear Semantics: Strong Verbs & Singular Roles" />
</div>

<!--
使用案例的命名語意標準：

每個使用案例必須使用『主動動詞 + 名詞受詞』命名，例如『下單訂餐』、『查詢課表』。嚴禁使用模糊名詞（如『訂單管理』）或系統內部技術詞彙（如『SQL 查詢』）。

總結這張投影片，請記住這個核心觀念：使用案例一律以主動動詞受詞命名，聚焦於參與者的具體目標。
-->


---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_use_case/07_safe_nesting_limits.jpg" alt="Safe Nesting Limits: Avoid Over-Engineering" />
</div>

<!--
防止包含與擴充的過度嵌套：

使用案例不是流程圖，切勿進行多層 Include 巢狀鏈結（如 A 包含 B、B 又包含 C、C 又包含 D）。過度嵌套會徹底摧毀模型的高階抽象性，使其淪為低階演算法虛擬代碼。

總結這張投影片，請記住這個核心觀念：限制關聯嵌套深度在兩層以內，維持高階商業溝通合約的清晰度。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_use_case/08_case_study_enrollment_system.jpg" alt="Case Study: University Enrollment System" />
</div>

<!--
檢視經典案例：大學選課系統 (University Course Enrollment System)。

學生可執行『選修課程』，系統強制 include『驗證先修科目』；若遇課程額滿，則 extend『加入等候候補名單』。教務處註冊組人員則負責『維護開課清單』。

總結這張投影片，請記住這個核心觀念：真實的系統模型透過邊界框將不同參與者的目標職責優雅隔離。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_use_case/09_actor_generalization.jpg" alt="Actor Generalization: Specializing Roles in Hierarchies" />
</div>

<!--
參與者之間的泛化 (Generalization) 關聯。

當多個參與者角色擁有共用權限，但某些特定角色擁有進階專屬能力時，我們可以使用空心三角箭頭表示繼承。例如全職學生與兼任學生都繼承自『學生』基礎角色。

總結這張投影片，請記住這個核心觀念：參與者泛化能有效重用共用角色權限，消除模型中多餘的重複連線。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_use_case/10_common_anti_patterns.jpg" alt="Common Anti-Patterns in Use Case Modeling" />
</div>

<!--
檢視初學者最容易掉入的四大反模式：

第一，功能分解陷阱：把使用案例當成循序流程圖，把「點擊按鈕」、「輸入密碼」畫成一顆顆小泡泡；第二，蜘蛛網混亂：使用案例之間畫滿了毫無意義的箭頭；第三，邊界消失：把外部資料庫或 API 畫在系統邊界裡面。

總結這張投影片，請記住這個核心觀念：避免過度細化的功能分解，維持高階商業目標導向。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_use_case/11_best_practices_checklist.jpg" alt="Best Practices Checklist" />
</div>

<!--
工程師必備的最佳實踐檢核清單：

1. 每個使用案例名稱必須是動詞加受詞。
2. 參與者必須代表明確角色，而非內部組織部門。
3. 系統邊界框清晰劃分系統責任範圍。
4. 正確區分強制 Include 與條件 Extend。

總結這張投影片，請記住這個核心觀念：遵循嚴謹的語法標準與命名規範，確保模型具備高度可讀性與合約效力。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_use_case/12_communication_first_mindset.jpg" alt="Communication-First Mindset: Bridges Between Stakeholders and Engineers" />
</div>

<!--
總結 4.3 節核心精神：擁抱「溝通優先 (Communication-First)」的心態。

使用案例圖是強大的溝通橋樑，而非孤芳自賞的技術藍圖！它的最大超能力在於連接非技術的業務經理與後端工程團隊。如果一張圖不能讓業務人員在三十秒內看懂，它就是過度設計！

總結這張投影片，請記住這個核心觀念：使用案例模型本質上是凝聚業務目標與工程共識的視覺溝通契約。
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
我們正式進入類別圖的核心領域。

在物件導向軟體工程中，類別圖是最常被使用、也最被深入研究的圖表。它是將現實世界業務領域映射為軟體程式碼的第一道橋樑。

總結這張投影片，請記住這個核心觀念：類別圖是連結現實領域概念與程式碼物件類別的靜態橋樑。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_class/02_blueprint_vs_instance.jpg" alt="Blueprint vs Instance: The Foundation of OOD" />
</div>

<!--
類別與物件實例的根本區別：

類別是藍圖 (Blueprint)，定義型態與結構規格；物件是執行期的具體實例 (Instance)，擁有具體的記憶體空間與狀態資料。類別圖塑模的是藍圖，而非個別物件。

總結這張投影片，請記住這個核心觀念：類別圖是定義物件集合結構特徵的靜態藍圖。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_class/03_three_perspectives_of_class_modeling.jpg" alt="The Three Perspectives of Class Modeling" />
</div>

<!--
類別塑模的三重視角：

概念視角 (Conceptual) 捕捉真實領域名詞；規格視角 (Specification) 定義抽象型態與介面操作簽章；實作視角 (Implementation) 則直接對齊程式語言中的具體欄位與函式實作。

總結這張投影片，請記住這個核心觀念：依據專案階段精準切換概念、規格與實作三重視角。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_class/04_anatomy_of_class_box.jpg" alt="Anatomy of the Class Box" />
</div>

<!--
剖析 UML 類別標準三格矩形：

頂格是類別名稱；中格是屬性清單，標註名稱、型態與預設值；底格是操作方法清單，標註參數型態與回傳值。如果只需要表達概念模型，可以省略底格方法，聚焦於資料屬性。

總結這張投影片，請記住這個核心觀念：三格矩形分別規範類別識別、資料屬性與操作行為合約。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_class/05_visibility_matrix.jpg" alt="The Visibility Matrix" />
</div>

<!--
封裝與可見度符號是物件導向的基石：

加號 (+) 代表 public 公開存取；減號 (-) 代表 private 私有封裝；井號 (#) 代表 protected 保護層級（僅子類別可見）；波浪號 (~) 代表 package 套件層級。良好的物件導向設計要求屬性一律 private，透過 public 方法對外提供受控服務。

總結這張投影片，請記住這個核心觀念：嚴格遵循資訊隱藏原則，屬性私有化並透過公開方法暴露必要操作。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_class/06_parameter_directionality.jpg" alt="Parameter Directionality Dashboard" />
</div>

<!--
深入檢視 UML 方法簽章中的參數方向指示符號：

`in` 代表輸入參數（唯讀不可改）；`out` 代表輸出參數（由方法賦值傳回）；`inout` 則代表雙向讀寫參數。這在塑模跨行程遠端呼叫 (RPC) 或底層 C/C++ API 時至關重要。

總結這張投影片，請記住這個核心觀念：參數方向指示符精確規範資料在函式邊界的流動方向與所有權。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_class/07_taxonomy_of_relationships.jpg" alt="Taxonomy of Relationships" />
</div>

<!--
類別之間存在多種結構關聯：

最弱的是依賴 (Dependency)，其次是普通關聯 (Association)，再往上是整體與部分的聚合 (Aggregation) 與組合 (Composition)，最後是具備多型特性的泛化繼承 (Generalization) 與介面實現 (Realization)。

總結這張投影片，請記住這個核心觀念：不同關聯代表不同強度的耦合程度，架構師應依生命週期與相依性審慎抉擇。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_class/08_connector_cheat_sheet.jpg" alt="The Connector Cheat Sheet" />
</div>

<!--
這是一張價值連城的 UML 連線符號速查指南：

實線箭頭是一般關聯；空心三角實線是類別繼承；空心三角虛線是介面實現；空心菱形是聚合；實心黑菱形是組合。請大家務必把這張圖的線條與箭頭形狀烙印在腦海中，這是全球軟體工程師共通的文法！

總結這張投影片，請記住這個核心觀念：精確區分虛實線條與箭頭形狀，避免在架構圖上傳達錯誤的依賴語義。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_class/09_aggregation_vs_composition.jpg" alt="Lifecycle Diagnostic: Aggregation vs. Composition" />
</div>

<!--
聚合與組合是軟體工程中最常被考究的核心觀念：

聚合 (Aggregation，空心菱形) 代表「Has-A」弱整體關係，部分可以獨立於整體而存在，例如大學與教授、外送平台與外送員；組合 (Composition，實心菱形) 代表「Part-Of」強整體關係，部分無法獨立生存，若整體消亡，部分隨之連帶銷毀，例如訂單與訂單明細項。

總結這張投影片，請記住這個核心觀念：組合代表強生命週期綁定與連帶銷毀，而聚合代表獨立生命週期的鬆散組織。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_class/10_cardinality_and_constraints.jpg" alt="Cardinality & Constraints" />
</div>

<!--
關聯重數 (Multiplicity) 規範了物件執行期的數量約束：

`1` 代表恰好一個；`0..1` 代表可選（可能為 null）；`*` 或 `0..*` 代表零到多個；`1..*` 代表至少一個。必須在關聯線的兩端分別清楚標註，才能作為資料庫外部鍵 (FK) 與反向集合屬性的精確依據。

總結這張投影片，請記住這個核心觀念：重數雙向明確標註，是指導資料庫綱要與程式碼集合宣告的法定邊界規則。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_class/11_order_model_example.jpg" alt="Syntax to System: The Order Model" />
</div>

<!--
將上述所有語法融會貫通於真實的電商訂單領域模型中：

看左邊的 Customer：包含私有 customerID 並以 1 對 * 關聯 Order。看中間的 Order：以實心菱形組合 (Composition) 指向 LineItem，訂單刪除時明細連帶抹除。看下方 PaymentInterface：Order 透過虛線空心箭頭實現介面。

總結這張投影片，請記住這個核心觀念：結合可見度、重數、組合與介面實現，就能勾勒出生產級的強韌領域模型。
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
我們現在進入第 4.5 節：互動與循序圖模型 (Sequence Diagrams)。

類別圖向我們展示了系統由哪些物件組成，但它無法告訴我們「當使用者點擊按鈕時，這些物件如何在時間軸上一步步協同通訊、呼叫方法並處理錯誤」。
循序圖正是為此而生：它以時間為縱軸、物件為橫軸，清晰展現系統運行時的動態脈搏。

在這一節中，我們將學習生命線、啟動條、同步/非同步訊息、BCE 架構模式、UML 2.0 複合片段 (alt, opt, loop)，並結合 AI 提示詞產生嚴謹的動態互動模型。

總結這張投影片，請記住這個核心觀念：循序圖沿時間軸精確描繪物件協同與訊息傳遞，是驗證動態邏輯與 API 介面的核心工具。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_sequence/01_dynamic_interaction_overview.jpg" alt="Dynamic Interaction Overview" />
</div>

<!--
我們從靜態跨越到動態世界：為什麼需要動態互動模型？

因為軟體 Bug 與分散式系統架構故障，絕大多數不是發生在類別定義上，而是發生在物件跨時間、跨網路呼叫時的時序死結、競爭條件 (Race Conditions) 與未捕獲例外上。

總結這張投影片，請記住這個核心觀念：動態模型能提前暴露跨物件訊息傳遞與分散式時序中的隱藏架構缺陷。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_sequence/02_static_vs_dynamic_collaboration.jpg" alt="Mapping Dynamic Collaboration: Static vs Dynamic Models" />
</div>

<!--
靜態結構與動態行為如同硬幣的兩面：

左側類別圖展示『有什麼實體』，右側循序圖展示『如何隨時間運作』。類別圖中的公開方法，正是循序圖中箭頭上的訊息名稱；兩者相互對應、互為驗證。

總結這張投影片，請記住這個核心觀念：靜態類別定義能力，動態循序展現運作，兩者相互印證方能構成完整架構。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_sequence/03_interaction_canvas_and_dimensions.jpg" alt="The Interaction Canvas: Object Dimension & Time Dimension" />
</div>

<!--
循序圖的畫布維度與座標軸：

橫軸代表系統中的物件實體（空間維度），縱軸由上向下代表時間的流逝（時間維度）。所有訊息箭頭一律水平繪製，位置越下方代表發生時間越晚。

總結這張投影片，請記住這個核心觀念：以時間為縱軸、物件為橫軸，是循序圖視覺化執行時序的核心座標體系。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_sequence/04_structural_anatomy.jpg" alt="Structural Anatomy: Lifelines, Activation Bars, and Events" />
</div>

<!--
深入循序圖的四大解剖要素：

頂部矩形代表參與物件或參與者；向下延伸的垂直虛線是生命線 (Lifeline)；虛線上的細長矩形條是啟動條 (Activation Bar)，代表該物件正在執行處理；橫向箭頭則是物件間傳遞的訊息。

總結這張投影片，請記住這個核心觀念：掌握生命線、啟動區間與訊息箭頭，就能看懂任何複雜的執行期時序。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_sequence/05_messaging_matrix.jpg" alt="The Messaging Matrix: Synchronous, Asynchronous, Return, Create, Destroy" />
</div>

<!--
訊息箭頭的精準語法语義：

實心三角箭頭 (`->`) 代表同步呼叫 (Synchronous Call)，呼叫端會阻塞等待回傳；虛線箭頭 (`-->`) 代表回傳訊息 (Return Message)；開放式魚骨箭頭 (`->>`) 代表非同步事件 (Asynchronous Message)，發送後立即繼續執行，不等待結果。

總結這張投影片，請記住這個核心觀念：正確區分同步阻塞呼叫與非同步事件派發，是設計高併發與微服務架構的基石。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_sequence/06_combined_fragments_overview.jpg" alt="UML 2.0 Combined Fragments: alt, opt, loop, par" />
</div>

<!--
UML 2.0 引入了強大的複合片段 (Combined Fragments)：

`alt` 代表多選一條件分支（相當於 if-else）；`opt` 代表選擇性執行（相當於單純的 if）；`loop` 代表迴圈重複執行；`par` 代表多個生命線並行執行。這讓循序圖具備了表達現代控制結構的完整能力。

總結這張投影片，請記住這個核心觀念：複合片段讓循序圖能夠優雅精確地表達條件分支、例外處理與迴圈重複邏輯。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_sequence/07_fragment_operators_to_code.jpg" alt="Fragment Operators to Production Code Logic" />
</div>

<!--
這張圖展示了複合片段如何 100% 精準映射到程式代碼：

`alt` 框中的守衛條件直接轉化為 `if (condition) { ... } else { ... }` 區塊；`loop` 框直接對應到 `while` 或 `for` 迴圈。架構師在圖上定義好例外分支，開發者編寫代碼時就絕對不會遺漏錯誤處理！

總結這張投影片，請記住這個核心觀念：複合片段與高階語言的控制結構一一對應，是防止邊界例外被遺漏的利器。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_sequence/08_case_study_hotel_reservation.jpg" alt="System Model Case Study: Hotel Reservation Flow" />
</div>

<!--
檢視經典案例：飯店線上預訂與支付流程。

觀察這張生產級循序圖：前端 UI 呼叫 ReservationController，控制器協調 RoomInventory 鎖定房型，接著呼叫外部 PaymentGateway 進行信用卡扣款，並透過 `alt` 片段優雅處理扣款成功與信用卡遭拒的兩條分支。

總結這張投影片，請記住這個核心觀念：真實的循序圖必須完整涵蓋正常流程與異常處理分支，形成嚴密的業務防護網。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_sequence/09_requirements_to_code_pipeline.jpg" alt="The Requirements-to-Code Pipeline: Use Case → Scenario → Sequence → Code" />
</div>

<!--
軟體工程的標準落地推進管線：

第一步，使用案例定義目標；第二步，將使用案例展開為一條條具體情境劇本；第三步，以循序圖分配物件職責並繪製訊息流；第四步，直接對照循序圖撰寫 Controller、Service 與 Repository 程式碼。這就是專業的工程紀律！

總結這張投影片，請記住這個核心觀念：循序圖是承接高階使用案例情境、轉化為可執行物件導向程式碼的中樞引擎。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_sequence/10_model_before_code.jpg" alt="Model Before Code: Architectural Discipline vs Chaotic Code" />
</div>

<!--
總結 4.5 節的永恆箴言：『先塑模，後寫代碼 (Model Before Code)』。

左邊是沒做設計就盲目動手敲代碼：產生盤根錯節的依賴、未處理的競態條件與義大利麵架構；右邊是先用循序圖理清互動：在寫第一行代碼前就明確各元件職責、排除時序死結。

總結這張投影片，請記住這個核心觀念：在動手編程前視覺化動態通訊，能省下數十倍後期返工與抓 Bug 的沉重代價。
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

在 UML 2.0 循序圖中，若欲精準表達「**二選一的互斥條件分支邏輯**」（例如：若信用卡扣款成功則產生訂單，若扣款失敗則回滾交易並提示錯誤），應採用哪一種複合片段 (Combined Fragment)？

- **A.** `loop` 片段
- **B.** `par` 片段
- **C.** `opt` 片段
- **D.** `alt` 片段

</div>
<div class="ccq-logo">
    <a href="https://nlhsueh.github.io/nickedupocket/#/student/ase-ch04-ccq5" target="_blank"><img src="../../img/ch04/ase-ch04-ccq5.png" alt="QR Code" /></a>
  </div>
</div>

<!--
讓我們透過觀念檢核測驗 5 來檢驗對循序圖複合片段的掌握。

審視四個複合片段選項：
`loop` 用於表達重複迴圈。
`par` 用於表達多條生命線並行處理 (Parallel)。
`opt` 代表可選分支 (Optional)，相當於沒有 else 的單純 if。
`alt` 則是 Alternatives 的縮寫，專門用於多選一的互斥分支 (if-else)。

正確答案是 D，`alt` 片段！

總結這張投影片，請記住這個核心觀念：`alt` 片段用於表達互斥條件分支 (if-else)，而 `opt` 則用於單一可選條件 (if without else)。
-->

---

<!-- _class: lead -->
<!-- header: '4.6 流程與活動圖模型' -->

# **4.6 流程與活動圖模型**

> "複雜的業務流程就像多條河流匯聚；活動圖能讓我們精確掌控每一道支流的並行與匯合。"

<!--
我們現在進入第 4.6 節：流程與活動圖模型 (Activity Diagrams)。

在現代分散式軟體中，系統很少只依序執行單一步驟。顧客下單後，餐廳要同時備餐、演算法要同時計算外送路線、金流要同時請款。這種「並行 (Concurrency)」與「非同步協同」很難在一般流程圖中清晰表達。

活動圖是 UML 中專門用於描述業務流程、工作流、並行分岔 (Fork)、同步結合 (Join) 與跨角色責任泳道 (Swimlanes) 的強大武器。

總結這張投影片，請記住這個核心觀念：活動圖精準捕捉多角色工作流程、並行計算與同步屏障，是業務流程再造與分散式微服務協同的利器。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_act/01_cover.jpg" alt="Mapping the Dynamic System with UML Activity Diagrams" />
</div>

<!--
我們正式進入活動圖的世界。

在業務分析與系統架構中，活動圖負責將複雜的業務規則與運作流程具象化。它不僅能表達循序步驟，更是處理高併發與多執行緒流程的標準語言。

總結這張投影片，請記住這個核心觀念：活動圖是視覺化複雜動態業務工作流與並行機制的利器。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_act/02_visual_logic.jpg" alt="Moving Beyond Static Structures to Model Dynamic Workflows" />
</div>

<!--
為什麼不能只靠類別圖與使用案例？

使用案例只告訴我們『有哪些功能』，卻沒說明執行的內部演算法與作業先後順序。活動圖超越了靜態結構，深入呈現資料與控制權在系統中流轉的真實軌跡。

總結這張投影片，請記住這個核心觀念：活動圖填補了高階使用案例與底層程式碼演算法之間的動態流程缺口。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_act/03_triggers.jpg" alt="Three Triggers for Behavioral Modeling" />
</div>

<!--
驅動行為塑模的三大核心情境：

第一，複雜業務邏輯與跨部門作業程序；第二，涉及多方角色的微服務協同調度；第三，高併發環境下的非同步並行處理與超時例外管控。

總結這張投影片，請記住這個核心觀念：當流程跨越多個角色、包含平行處理或具備複雜條件決策時，正是活動圖大顯身手的時刻。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_act/04_compair.jpg" alt="Standard Flowcharts vs UML Activity Diagrams" />
</div>

<!--
比較傳統流程圖與 UML 活動圖的本質差異：

傳統流程圖缺乏嚴格語法，無法表達『同時並行』的執行緒，也無法區分『控制流』與『資料物件流』；而 UML 活動圖具備精準的符號體系，天生支援分岔、結合與泳道責任歸屬。

總結這張投影片，請記住這個核心觀念：UML 活動圖具備表達並行多執行緒與責任泳道的強大能力，遠勝傳統流程圖。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_act/05_core.jpg" alt="The Core Vocabulary of System Flow" />
</div>

<!--
掌握活動圖的四大核心詞彙：

實心圓點是起點 (Initial Node)；圓角矩形代表具體執行的動作 (Action)；箭頭是引導執行權轉移的控制流 (Control Flow)；雙重圓圈實心點則是流程終點 (Final Activity Node)。

總結這張投影片，請記住這個核心觀念：起點、動作、控制流與終點構成了所有動態流程的基本骨架。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_act/06_conditional.jpg" alt="Handling Conditional System Logic: Decision & Merge Nodes" />
</div>

<!--
條件分支的兩大菱形節點：

決策節點 (Decision Node，一進多出) 依據守衛條件 `[guard]` 將流程分流至不同路徑；合併節點 (Merge Node，多進一出) 則將多個互斥分支收攏為單一流程。請注意：決策節點的分支守衛條件必須完全互斥！

總結這張投影片，請記住這個核心觀念：決策菱形負責條件分流，合併菱形負責互斥路徑的匯整，兩者皆不涉及並行計算。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_act/07_parallel.jpg" alt="Orchestrating Parallel System Actions: Fork & Join Nodes" />
</div>

<!--
活動圖最具威力的特徵：並行同步棒 (Synchronization Bar)：

分岔節點 (Fork，一粗線進多出) 將單一執行權分裂為多個並行活動，同時在背景運作；結合節點 (Join，多粗線進一出) 則是同步屏障，必須等待『所有平行分支全部執行完畢』，後續流程才能被喚醒繼續！

總結這張投影片，請記住這個核心觀念：Fork 啟動平行並行處理，Join 執行同步等待，確保所有分支到位後才推進後續作業。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_act/08_object_flow.jpg" alt="Tracking Data & Objects: Object Nodes and Object Flows" />
</div>

<!--
除了控制權，資料是如何傳遞的？

活動圖中的直角矩形代表物件節點 (Object Node)，虛線或帶有物件的箭頭稱為物件流 (Object Flow)。它清楚標示出某個動作產生了『訂單實體 [已付款]』，並作為下一動作的輸入參數。

總結這張投影片，請記住這個核心觀念：物件節點明確追蹤資料實體在流程中的狀態變更與傳遞依賴。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_act/09_swimlane.jpg" alt="Multi-Actor Accountability: Why Swimlanes Matter" />
</div>

<!--
當多個部門或微服務協同運作時，職責往往容易互相踢皮球。

泳道 (Swimlanes / Partitions) 將活動圖垂直或水平劃分為不同欄位，每個欄位對應一個明確的負責角色、部門或微服務元件。任何動作落在該欄位內，就代表由該角色負起全部執行責任！

總結這張投影片，請記住這個核心觀念：泳道將流程動作的當責性嚴格鎖定於具體角色或微服務，徹底消滅職責邊界模糊。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_act/10_grouping.jpg" alt="Grouping Activities by Actor or Thread: Swimlanes / Partitions" />
</div>

<!--
泳道的架構分組彈性：

在微服務架構中，泳道可以對應訂單服務、庫存服務、物流服務；在業務流程中，可以對應顧客、店員、外送員。透過跨泳道的控制流箭頭，系統間的 API 呼叫與事件依賴一目了然。

總結這張投影片，請記住這個核心觀念：泳道分區能自然映射分散式微服務架構，清晰界定跨服務呼叫邊界。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_act/11_notation.jpg" alt="Complete Visual Taxonomy of Dynamic Modeling" />
</div>

<!--
這是一張活動圖符號體系的完整全景圖：

從初始點、動作節點、決策菱形、分岔/結合粗棒、物件矩形到終止點與中斷點 (Interruptible Region)。熟悉這套符號體系，就能流暢閱讀並設計任何複雜的企業級流程。

總結這張投影片，請記住這個核心觀念：完整的活動圖符號體系能精準描繪具備容錯、中斷與並行的企業級工作流。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_act/12_workflow.jpg" alt="The Unified Workflow Model: Swimlanes + Concurrency + Logic" />
</div>

<!--
將所有元素熔鑄為一體：

看這張整合模型：左邊是顧客泳道，中間是餐廳泳道，右邊是外送員泳道。中間使用了 Fork 讓廚房備餐與外送派單平行進行，最後在取餐處透過 Join 棒完美同步！

總結這張投影片，請記住這個核心觀念：融合泳道、條件決策與並行分岔結合，能建立無懈可擊的端到端業務藍圖。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_act/13_three_phases.jpg" alt="Three Phases to Map Your Complex Systems" />
</div>

<!--
總結 4.6 節最佳實踐：繪製系統流程的三大漸進階段：

第一階段：探索高階主幹流程；第二階段：劃分泳道邊界並指派各動作當責角色；第三階段：放大複雜度細節，補齊決策判斷、Fork/Join 並行與例外中斷。

總結這張投影片，請記住這個核心觀念：由高階主幹到泳道分配、再到並行細節，逐步演進是掌握活動圖複雜度的工程法門。
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

在 UML 活動圖中，若一條粗黑橫棒擁有「**多個輸入控制流 (Incoming Flows)**」與「**單一輸出控制流 (Outgoing Flow)**」，這代表哪一種節點？其執行語義為何？

- **A.** 分岔節點 (Fork Node)：將單一控制流複製為多個並行活動。
- **B.** 結合節點 (Join Node)：必須等待所有輸入控制流皆執行完畢後，才啟動後續動作。
- **C.** 決策節點 (Decision Node)：依據守衛條件進行多選一互斥分流。
- **D.** 合併節點 (Merge Node)：只要任一輸入控制流到達，便立即啟動後續動作。

</div>
<div class="ccq-logo">
    <a href="https://nlhsueh.github.io/nickedupocket/#/student/ase-ch04-ccq6" target="_blank"><img src="../../img/ch04/ase-ch04-ccq6.png" alt="QR Code" /></a>
  </div>
</div>

<!--
讓我們透過觀念檢核測驗 6 來驗收對活動圖並行節點的理解。

題目問的是：多進一出的粗黑橫棒是什麼？
分析選項：
選項 A 是 Fork（一進多出）。
選項 C 是菱形決策（一進多出條件分支）。
選項 D 是菱形合併（多進一出，任一到達即觸發）。
選項 B 是 Join 結合節點！多條輸入控制流匯整為單一輸出，且語義上必須全部到達才能放行。

正確答案是 B！

總結這張投影片，請記住這個核心觀念：Join 粗黑橫棒是必須等待所有平行輸入完全到位的同步屏障 (Synchronization Barrier)。
-->

---

<!-- _class: lead -->
<!-- header: '4.7 行為與狀態機模型' -->

# **4.7 行為與狀態機模型**

> "軟體系統中最昂貴的災難，往往源自於物件在錯誤的時間接收了看似合法的事件。"

<!--
我們現在進入第 4.7 節：行為與有限狀態機模型 (State Machine Diagrams)。

活動圖描述的是「跨物件的連續工作流」，而狀態機圖聚焦的是「單一核心實體在生命週期中如何針對外部事件做出反應」。
例如一張訂單：它不是死板的資料庫紀錄，它是一個有生命的實體，會歷經 Placed、Preparing、OutForDelivery 到 Delivered 等離散狀態。

在錯誤的狀態下接收事件（例如在司機已經送達時點擊取消訂單），會引發致命的業務漏洞。
狀態機圖就是架構師用來定義「合法狀態」、「守衛條件」與「防禦性不變量」的最高數學憲法。

總結這張投影片，請記住這個核心觀念：狀態機模型規範物件生命的離散狀態與事件轉換邊界，是守護業務不變量與防禦性設計的核心武器。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_state_machine/01_anatomy_of_state_dependent_behavior.jpg" alt="The Anatomy of State-Dependent Behavior" />
</div>

<!--
我們進入狀態機的核心：狀態相依行為。

在軟體中，系統對同一事件的反應，完全取決於它『當前處於什麼狀態』。如果手機在鎖定狀態，按電源鍵是點亮螢幕；如果在通話狀態，按電源鍵是掛斷電話！這就是狀態相依。

總結這張投影片，請記住這個核心觀念：相同事件在不同狀態下會產生完全不同的反應與行為結果。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_state_machine/02_same_event_different_results.jpg" alt="The Same Event Yields Different Results Based on State" />
</div>

<!--
以具體案例感受狀態的決定性威力：

以電商訂單為例，當使用者觸發『取消訂單』事件：若訂單在『剛下單』狀態，系統無條件全額退款；若訂單在『配送中』狀態，系統必須拒絕取消並提示無法退款！狀態決定了系統的生死邊界。

總結這張投影片，請記住這個核心觀念：狀態機本質上是透過狀態前置條件來保護業務邏輯的正確性。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_state_machine/03_positioning_within_uml_ecosystem.jpg" alt="Positioning the Tool Within the UML Ecosystem" />
</div>

<!--
狀態機在整個 UML 宇宙中佔據獨特的戰略高地：

它不同於類別圖的結構、不同於活動圖的流水線、不同於循序圖的通訊。它專注於『單一關鍵核心實體（如訂單、帳戶、連線）的完整生命週期歷程』。

總結這張投影片，請記住這個核心觀念：狀態機專為生命週期複雜、事件驅動的關鍵領域實體提供形式化規範。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_state_machine/04_state_defined_lifecycle_interval.jpg" alt="A State is a Defined Interval in an Object's Lifecycle" />
</div>

<!--
如何為『狀態』下一個精確的工程定義？

狀態是物件生命週期中滿足某個條件、執行某個活動或等待某個外部事件的一段時間區間。在狀態名稱命名上，必須使用形容詞或過去分詞（如 Placed, Active, Closed），絕對不要用動詞命名！

總結這張投影片，請記住這個核心觀念：狀態代表物件在時間軸上的穩定條件，名稱應使用形容詞或過去分詞。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_state_machine/05_four_triggers_of_state_transitions.jpg" alt="The Four Triggers That Initiate State Transitions" />
</div>

<!--
觸發狀態轉換的四大驅動力：

第一，訊號事件 (Signal Event，如接收到非同步 MQTT 訊息)；第二，呼叫事件 (Call Event，如函式被呼叫)；第三，時間事件 (Time Event，如超時 30 分鐘 `after(30m)`)；第四，變更事件 (Change Event，如溫度高於 100 度 `when(temp > 100)`)。

總結這張投影片，請記住這個核心觀念：訊號、呼叫、時間與條件變更構成了狀態機運轉的四大感測源。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_state_machine/06_mechanics_of_a_transition.jpg" alt="The Mechanics of a Transition" />
</div>

<!--
狀態轉換箭頭上的國際標準語法公式：

`Trigger [Guard] / Action`。Trigger 是觸發的事件名；中括號 `[Guard]` 是布林守衛條件（必須為 true 才能通行）；斜線 `/ Action` 則是轉換瞬間順帶執行的原子動作。

總結這張投影片，請記住這個核心觀念：牢記『事件 [守衛條件] / 動作』的三位一體語法公式，這是狀態轉換的法定標準。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_state_machine/07_actions_vs_activities.jpg" alt="Execution Engines: Actions vs. Activities" />
</div>

<!--
嚴格區分動作 (Action) 與活動 (Activity) 的巨大差異：

動作 (Action) 是『原子性、瞬間完成、不可中斷』的，例如變數賦值或發送一封 email；活動 (Activity，以 `do /` 標註) 則是『耗時長、可被中斷』的，例如播放音樂或加熱烤箱，一旦外部事件發生，活動會被立刻中斷並跳出狀態！

總結這張投影片，請記住這個核心觀念：Action 是瞬間不可中斷的原子操作，Activity 是耗時且隨時可被中斷的持續狀態。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_state_machine/08_entry_and_exit_actions.jpg" alt="Boundary Executions: Entry and Exit Actions" />
</div>

<!--
狀態的邊界執行防禦機制：

`entry /` 動作：不管從哪一條路徑進入該狀態，第一時間強制自動執行（例如進入 OutForDelivery 立即啟動 GPS 追蹤）；`exit /` 動作：無論因為何種原因離開該狀態，強制自動清理資源（例如關閉 GPS）。

總結這張投影片，請記住這個核心觀念：善用 entry 與 exit 動作，能確保狀態初始設定與資源釋放具備 100% 執行可靠度。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_state_machine/09_scaling_architecture_complexity_matrix.jpg" alt="Scaling Architecture: The Complexity Matrix" />
</div>

<!--
當系統變得極度複雜時，狀態數量會呈指數級爆炸（狀態爆炸問題）。

如果全部使用傳統的扁平狀態圖，狀態之間會密密麻麻畫成蜘蛛網；為了解決這個難題，UML 狀態機引入了階層式複合狀態 (Composite States)。

總結這張投影片，請記住這個核心觀念：透過階層式複合狀態封裝內部子狀態，是解決大規模狀態爆炸的架構解法。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_state_machine/10_composite_states_and_history.jpg" alt="Composite States and System Memory" />
</div>

<!--
深入複合狀態與歷史狀態 (History State, [H])：

複合狀態內部可以包含多個子狀態。更神奇的是歷史節點 [H]：當系統暫時跳出複合狀態（如設備休眠），再次喚醒返回時，歷史節點能記住『上次離開時停在誰』，直接精確復原子狀態，不需重頭開始！

總結這張投影片，請記住這個核心觀念：歷史狀態節點讓階層系統具備狀態記憶復原能力，大幅提升使用者體驗。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_state_machine/11_concurrency_fork_and_join.jpg" alt="Concurrency: Forking and Joining Execution Threads" />
</div>

<!--
狀態機中的正交並行區域 (Orthogonal Regions)：

一個物件在同一瞬間，能否同時具備兩種獨立狀態？答案是肯定的！例如一台智慧手機在開機狀態下，可以同時處於『連網狀態』與『音訊播放狀態』。狀態機用虛線將複合狀態切分為多個正交區塊，彼此獨立運作。

總結這張投影片，請記住這個核心觀念：正交區域允許單一實體內部同時並存多個獨立維度的並行子狀態機。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_state_machine/12_unified_blueprint_hvac_example.jpg" alt="The Unified Blueprint: HVAC Heating/Cooling System" />
</div>

<!--
檢視工業級狀態機實戰藍圖：智慧空調 (HVAC) 控制系統。

這張圖融合了初始狀態、加熱與製冷的複合狀態切換、歷史記憶節點、以及高溫火警時的緊急例外中斷跳轉。結構嚴整、邏輯滴水不漏。

總結這張投影片，請記住這個核心觀念：真實的工程狀態機統一了起點、複合狀態、記憶歷史與安全例外機制。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_state_machine/13_operationalizing_behavioral_logic_ai.jpg" alt="Operationalizing Behavioral Logic with AI" />
</div>

<!--
總結 4.7 節：利用生成式 AI 將行為邏輯落地。

現代軟體工程師不再需要手動拖拉複雜的狀態圖框。我們可以將領域業務規則寫成結構化需求文字，由 AI 協助直接編譯為正式、可被靜態分析驗證的 PlantUML 狀態機代碼！架構師的職責轉向檢視邊界與守衛條件的安全。

總結這張投影片，請記住這個核心觀念：AI 工具能加速文字到正式狀態機的轉譯，工程師則專注審查邊界轉換與守衛安全性。
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

在 UML 狀態機圖中，關於轉換標籤 (Transition Label) 的國際標準語法結構 `Trigger [Guard] / Action`，下列敘述何者**完全正確**？

- **A.** `[Guard]` 是強制執行的動作，`/ Action` 是條件檢查。
- **B.** 只有當 `Trigger` 事件發生，且 `[Guard]` 守衛條件評估為 true 時，轉換才會發生並執行 `/ Action`。
- **C.** `Trigger` 代表進入新狀態後持續進行的長期耗時活動。
- **D.** 只要 `[Guard]` 條件為 true，無需任何事件即可隨時自動觸發轉換。

</div>
<div class="ccq-logo">
    <a href="https://nlhsueh.github.io/nickedupocket/#/student/ase-ch04-ccq7" target="_blank"><img src="../../img/ch04/ase-ch04-ccq7.png" alt="QR Code" /></a>
  </div>
</div>

<!--
讓我們透過觀念檢核測驗 7 來檢驗對狀態轉換語法的掌握。

分析題目的語法公式：`Trigger [Guard] / Action`。
選項 A 顛倒了守衛與動作。
選項 C 混淆了 Trigger 與 Activity (`do /`)。
選項 D 忽略了 Trigger 事件觸發的必要性。

正確答案是 B！只有當指定的 Trigger 事件到達，並且中括號內的 Guard 條件成立為 true 時，狀態轉換才會放行，並在瞬間執行 Action 動作！

總結這張投影片，請記住這個核心觀念：轉換必須滿足『事件到達』且『守衛評估為真』，才會執行動作並完成狀態轉移。
-->

---

<!-- _class: lead -->
<!-- header: '4.8 PlantUML 宣告式文字塑模' -->

# **4.8 PlantUML 宣告式文字塑模**

> "告別手動拖拉圖框的痛苦。架構即代碼，讓軟體模型與程式碼在 Git 倉儲中一同進化。"

<!--
我們現在進入第 4.8 節：PlantUML 宣告式文字塑模 (Code-as-Architecture)。

過去三十年，許多工程師對 UML 敬而遠之的最大原因，就是傳統繪圖工具極度繁瑣痛苦：拖拉方塊、調整箭頭對齊、檔案格式二進位無法用 Git 進行 code review、重構時牽一髮而動全身。

PlantUML 與「架構即代碼 (Code-as-Architecture)」徹底終結了這個噩夢！
我們只需要用簡練的純文字標記語言描述物件與關聯，排版佈局全部自動交給渲染引擎處理。更棒的是，它能與 Git、CI/CD 與 Markdown 講義無縫整合。

總結這張投影片，請記住這個核心觀念：PlantUML 實現了架構即代碼，讓軟體模型具備可版本控制、自動渲染與無摩擦維護的現代工程特質。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_plantuml/01_plantuml_code_driven_architecture.jpg" alt="UML Modeling with PlantUML: Code-Driven Architecture" />
</div>

<!--
我們正式邁入文字化塑模新時代：代碼驅動的現代架構。

在現代敏捷與 DevOps 環境中，軟體架構必須具備輕量、快速迭代與自動化特性。PlantUML 是這場革新的領頭羊。

總結這張投影片，請記住這個核心觀念：PlantUML 將傳統昂貴繁瑣的圖形拖拉，轉化為優雅高效的純文字宣告。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_plantuml/02_stop_dragging_start_writing.jpg" alt="Stop Dragging Boxes. Start Writing Architecture." />
</div>

<!--
為什麼要停止手動拖拉方塊？

手動排版浪費了工程師 80% 的寶貴精力在微調像素與對齊線上。以代碼寫架構，你能把全部心智專注於『領域實體、責任分配與時序合約』。版面美化，交給演算法處理！

總結這張投影片，請記住這個核心觀念：讓工具負責排版，讓大腦專注於架構邏輯本身。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_plantuml/03_frictionless_setup.jpg" alt="The Frictionless Setup: VS Code Extension & Local Rendering" />
</div>

<!--
零摩擦的現代化開發環境搭建：

只需在 VS Code 安裝 PlantUML 擴充套件，配合本機 Graphviz 引擎或遠端渲染伺服器，按下 Alt+D (Option+D) 即可享有毫秒級的即時預覽！支援 PNG、SVG 與向量 PDF 輸出。

總結這張投影片，請記住這個核心觀念：在 IDE 內部直接編寫並即時預覽 UML，是最高效無縫的現代塑模工作流。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_plantuml/04_five_essential_lenses.jpg" alt="The Architect's Blueprint: 5 Essential Lenses" />
</div>

<!--
PlantUML 的五大核心透鏡：

它以統一的文字文法體系，同時支援使用案例圖、類別圖、循序圖、活動圖與狀態機圖！你不需要安裝五種不同軟體，一套文字文法搞定全部五大維度。

總結這張投影片，請記住這個核心觀念：統一的宣告式語法能無差別駕馭五大核心 UML 模型，極大降低認知負擔。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_plantuml/05_use_case_in_plantuml.jpg" alt="Use Case Diagrams in PlantUML Syntax" />
</div>

<!--
PlantUML 的使用案例語法極度簡潔：

`actor Customer` 宣告參與者；`(Place Order)` 宣告圓形使用案例；`rectangle System { ... }` 劃定系統邊界；`.>` 與 `<.` 輕鬆表達包含與擴充。

總結這張投影片，請記住這個核心觀念：幾行純文字就能瞬間渲染出邊界清晰、關聯嚴謹的使用案例圖。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_plantuml/06_class_diagrams_in_plantuml.jpg" alt="Class Diagrams in PlantUML Syntax" />
</div>

<!--
類別圖在 PlantUML 中的優雅宣告：

`class Order { ... }` 定義類別主體；以 `-`、`+`、`#` 標註可見度；自動將屬性與方法分類排版；支援 `interface`、`abstract class` 與 `enum` 關鍵字。

總結這張投影片，請記住這個核心觀念：語法直接映射 Java 與 TypeScript 的語義習慣，所寫即所想。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_plantuml/07_class_relationships_matrix.jpg" alt="The Class Relationship Matrix in PlantUML Syntax" />
</div>

<!--
這是 PlantUML 關聯符號的經典矩陣：

`<|--` 是繼承；`*--` 是實心菱形組合；`o--` 是空心菱形聚合；`..|>` 是介面實現；`-->` 是定向關聯。兩端加上引號即可標註重數，例如 `"1" *-- "1..*" LineItem`。

總結這張投影片，請記住這個核心觀念：熟記 ASCII 連線字元組合，在鍵盤上彈指間就能建立複雜的物件圖譜。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_plantuml/08_sequence_diagrams_in_plantuml.jpg" alt="Sequence Diagrams in PlantUML Syntax" />
</div>

<!--
循序圖是 PlantUML 最具殺手級優勢的王牌：

只需依序鍵入 `Alice -> Bob: request`，生命線自動生成、時序自動排版、箭頭精確對齊！配合 `activate` 與 `deactivate`，啟動條毫秒級成型。

總結這張投影片，請記住這個核心觀念：PlantUML 循序圖是軟體業界撰寫 API 規格與時序驗證的首選工具。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_plantuml/09_anatomy_of_sequence_syntax.jpg" alt="Anatomy of Sequence Syntax: Lifelines & Messages" />
</div>

<!--
深入循序圖複合語法：

使用 `alt [condition] ... else ... end` 建立條件分支；使用 `autonumber` 自動為每一則訊息標上序號；使用 `participant` 或 `actor` 為實體賦予具象圖示。

總結這張投影片，請記住這個核心觀念：支援完整的 UML 2.0 複合片段與自動編號，大幅提升規格書專業度。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_plantuml/10_activity_diagrams_in_plantuml.jpg" alt="Activity Diagrams & Swimlanes in PlantUML Syntax" />
</div>

<!--
現代 Activity Beta 語法無比優雅：

`start` 起點；`:Action Name;` 動作；`|Lane Name|` 泳道；`fork` 與 `fork again` 並行分岔；`end fork` 結合；`stop` 終點。閱讀起來就像在讀自然語言詩篇！

總結這張投影片，請記住這個核心觀念：Activity Beta 語法以極簡文字精確捕捉跨泳道並行流程。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_plantuml/11_state_diagrams_in_plantuml.jpg" alt="State Diagrams in PlantUML Syntax" />
</div>

<!--
狀態圖的純文字定義：

`[*] --> Placed` 初始狀態；`Placed --> Accepted : acceptOrder` 轉換；`state OutForDelivery { ... }` 階層複合狀態；`entry /` 與 `exit /` 直接內嵌於狀態區塊內部。

總結這張投影片，請記住這個核心觀念：宣告式語法能讓階層式複合狀態機保持極致清晰與數學嚴謹。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_plantuml/12_cross_diagram_syntax_cheatsheet.jpg" alt="Cross-Diagram Syntax Quick Reference Matrix" />
</div>

<!--
這張跨圖表語法速查對照表是每位軟體架構師的案頭必備指南：

橫跨使用案例、類別、循序、活動與狀態機，快速對照各圖表的起點、關聯與關鍵字。隨查隨用，效率倍增。

總結這張投影片，請記住這個核心觀念：將跨圖表共通符號內化為肌肉記憶，大幅提振日常架構設計生產力。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_plantuml/13_holistic_system_view.jpg" alt="The Holistic System View: Linking Models Together" />
</div>

<!--
文字化塑模的最大威力：宏觀整體視野 (Holistic View)。

當所有圖表都變成純文字代碼，你可以把整個系統的模型全部收錄在一個 `docs/models/` Git 資料夾內，並在 CI/CD 流程中自動編譯為線上文件網站！

總結這張投影片，請記住這個核心觀念：純文字讓分散的模型形成互為佐證的完整系統架構工程資產。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_plantuml/14_practical_architecture_workflow.jpg" alt="Practical Architecture Workflow: Code, Render, Iterate" />
</div>

<!--
現代軟體架構團隊的每日實踐工作流：

1. 在分支編寫 PlantUML 文字代碼；
2. 本機 VS Code 即時渲染驗證；
3. 提交 Git Commit 並建立 Pull Request，與團隊進行有意義的文字 Diff Code Review；
4. 合併後自動部署至文件門戶。

總結這張投影片，請記住這個核心觀念：納入 Git 版本控制與 Pull Request 審查，賦予架構模型與代碼同等尊嚴的維護週期。
-->

---

<!-- _class: full-image-slide -->

<div class="centered-image">
  <img src="../../img/ch04/nb_plantuml/15_elevate_your_architecture.jpg" alt="Master the Syntax, Elevate Your Architecture" />
</div>

<!--
總結 4.8 節：精通 PlantUML，升級你的架構思維！

當你不再受限於笨重的繪圖軟體，你就能在每一次需求變更時，第一時間用五秒鐘改兩行文字更新架構圖。敏捷與嚴謹不再衝突，模型真正成為活著的代碼！

總結這張投影片，請記住這個核心觀念：PlantUML 讓架構塑模變得無摩擦且可持續，是頂尖軟體工程師必備的核心生產力武器。
-->

---

### 觀念檢核測驗 8 (CCQ 8)
<!-- id: ase-ch04-ccq8 -->
<div class="ccq-columns">
<div class="ccq-text">

在軟體架構工程實踐中，相較於傳統以滑鼠手動拖拉圖框的二進位繪圖軟體（如 Visio 或特定商業 CASE 工具），採用 **PlantUML 宣告式文字塑模 (Code-as-Architecture)** 的最核心工程優勢為何？

- **A.** 能保證自動生成 100% 無 Bug 的 Java 實作程式碼，無需單元測試。
- **B.** 可以在純文字 Markdown 中編寫，輕鬆納入 Git 進行精確的行級版本控制與 Pull Request 審查。
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
