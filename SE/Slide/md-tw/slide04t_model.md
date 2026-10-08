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
<li><b>4.2 統一塑模語言 (UML)：</b> 1990 年代方法論之戰、UML 三巨頭三位一體分工與 OMG 標準化。</li>
<li><b>4.3 功能塑模與使用案例：</b> 參與者目標、系統邊界、include 與 extend 關聯及規格書。</li>
<li><b>4.4 結構塑模與領域類別圖：</b> 領域實體、可見度符號、關聯重數與聚合/組合生命週期。</li>
</ul>
</div>
<div>
<h3>第二部分：互動時序、狀態機與 AI 輔助塑模</h3>
<ul>
<li><b>4.5 互動塑模與循序圖：</b> 訊息傳遞時序、生命線、啟動條與 BCE 穩健性架構模式。</li>
<li><b>4.6 行為塑模與有限狀態機：</b> 反應型系統、訂單生命週期狀態機、事件觸發、守衛條件與動作。</li>
<li><b>4.7 AI 輔助系統塑模：</b> 文字轉圖視覺副駕駛、PlantUML/Mermaid 宣告式語法與人機協同審查。</li>
<li><b>4.8 核心複習與統整：</b> 重點回顧、概念填空測驗與經典權威文獻。</li>
</ul>
</div>
</div>

<!--
這裡是第四章全新調整後的完整學習藍圖。

在左側的第一部分，我們從系統塑模的哲學本質與四大視角出發，見證 UML 的歷史誕生與三巨頭整合，接著探討以使用者目標為導向的使用案例模型，並定義系統的靜態領域類別結構。

在右側的第二部分，我們進入動態物件互動時序與 BCE 循序圖，分析反應型系統的有限狀態機轉換，掌握現代 AI 輔助文字生成圖表技術，最後進行全面性的概念統整與測驗。

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
<img src="../../img/ch05/blind_men_elephant.svg" alt="盲人摸象與多重視角模型" />
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
## 現代實務必備的 5 大 UML 核心圖表

| 圖表類型 | 所屬視角 | 動態 / 靜態 | 主要軟體工程職責 |
| :--- | :--- | :--- | :--- |
| **1. 環境圖 (Context Diagram)** | 外部視角 | 靜態邊界 | 劃定系統邊界與外部夥伴系統的相依關係 |
| **2. 活動圖 (Activity Diagram)** | 行為視角 | 動態流程 | 視覺化呈現連續業務工作流程與平行並行邏輯 |
| **3. 使用案例圖 (Use Case Diagram)** | 互動視角 | 靜態契約 | 界定使用者目標與系統功能範疇邊界 |
| **4. 循序圖 (Sequence Diagram)** | 互動視角 | 動態時間 | 沿著時間生命線追蹤物件之間的循序訊息傳遞 |
| **5. 類別圖 (Class Diagram)** | 結構視角 | 靜態骨幹 | 定義領域實體、資料屬性、操作方法與物件關聯 |
| *(加分必學) 狀態機圖 (State Diagram)* | 行為視角 | 動態反應 | 塑模離散狀態、事件觸發與反應式生命週期 |

<!--
在 UML 2.5 定義的 14 種圖表中，這五種（加上狀態圖）構成了職業軟體工程師最常用的核心二八工具包：

環境圖劃定系統周邊範圍。
活動圖勾勒業務工作流程。
使用案例圖界定功能範圍與使用者目標。
循序圖描繪運行時隨時間發生的物件溝通。
類別圖作為物件導向程式碼與資料庫結構的靜態建築骨幹。
而狀態機圖則掌管事件驅動的離散反應邏輯。

總結這張投影片，請記住這個核心觀念：精通這五大核心 UML 圖表，就能以精確且無歧義的視覺文法表達任何軟體架構。
-->
---
### 觀念檢核測驗 1 (CCQ 1)
<div class="ccq-columns">
<div class="ccq-text">

軟體架構師若欲定義「**領域實體資料的靜態組織方式，以及類別之間的繼承、關聯與包含關係**」（完全不隨執行時序變動），應採取哪一種塑模視角？

- **A.** 外部視角 (External Perspective)
- **B.** 互動視角 (Interaction Perspective)
- **C.** 結構視角 (Structural Perspective)
- **D.** 行為視角 (Behavioral Perspective)

</div>
<div class="ccq-logo">
<img src="../../img/ch05/question_icon.svg" alt="Question Icon" style="max-width: 140px;" />
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
既然塑模如此不可或缺，軟體產業究竟是如何整合出一套共同標準的呢？

在 1980 年代末到 1990 年代初，C++ 與 Smalltalk 掀起物件導向狂潮，但隨之而來的是一場大混亂——所謂的「方法論之戰」。

當時市場上湧現了 50 多種互相競爭的塑模符號！Grady Booch 用雲朵表示類別；James Rumbaugh 用整齊的矩形；Ivar Jacobson 提出了使用案例；還有 Coad-Yourdon 等各派學說。

這造成了架構上的通天塔。你在 IBM 畫雲朵，換到 GE 得畫方塊。塑模工具彼此無法流通，軟體設計被鎖死在封閉規格中。

總結這張投影片，請記住這個核心觀念：1990 年代的方法論之戰以 50 多種互不相容的符號割裂了軟體產業，催生了標準化的迫切需求。
-->
---
## 統一與標準化：從 Rational 到 OMG

<div class="content-columns">
<div class="content-text">

- **1994 年 – Rational 展開統一整合：**
  - Jim Rumbaugh 離開奇異（GE）加入 Rational Software 與 Grady Booch 攜手，將 Booch 方法與 OMT 融合成「統一方法」(Unified Method v0.8)。
- **1995 年 – 「三巨頭 (Three Amigos)」合體：**
  - Ivar Jacobson 加入 Rational，帶來革命性的**使用案例 (Use Case)** 與 OOSE 架構思維。
- **1997 年 – OMG 國際標準正式誕生：**
  - 提交給**物件管理組織 (OMG)**，於 1997 年 11 月獲全票通過，成為全球公認的 **UML 1.1** 國際標準。
- **2005 年 – UML 2.0 架構大改版：**
  - 擴充至 13 種（後續擴增為 14 種）圖表類型，並具備嚴謹的可執行元模型 (Metamodel)。

</div>
<div class="content-figure">

<div class="name-card">
<img class="contain-fit" src="../../img/ch05/uml_logo.svg" alt="OMG 統一塑模語言" />
<div class="name-card-caption">
<span class="name-card-name">Unified Modeling Language</span>
<span class="name-card-cc"><a href="https://www.omg.org/uml/" target="_blank">Object Management Group (OMG)</a></span>
</div>
</div>

</div>
</div>

<!--
這場危機是如何化解的？正是透過在 Rational Software 上演的傳奇智識大融合。

1994 年，Jim Rumbaugh 離開奇異加入 Rational，與 Grady Booch 合力融合理論分析與實務設計。隔年，Ivar Jacobson 也帶著使用案例方法加入。

這三位大師在軟體界被親切尊稱為「UML 三巨頭 (The Three Amigos)」。

值得稱許的是，Rational 並沒有把 UML 當成自家的私有封閉規格，而是將其無私捐贈給國際開放標準組織 OMG。1997 年 11 月，UML 1.1 成為全球通用的軟體塑模國際標準。

總結這張投影片，請記住這個核心觀念：Rational 公司匯聚了三巨頭的智慧，並由 OMG 正式確立 UML 為全球統一的軟體塑模語言標準。
-->
---
## UML 奠基先驅：Grady Booch

<div class="content-columns">
<div class="content-text">

- **角色與學術榮譽：**
  - Rational Software 首席科學家、IBM 院士 (Fellow)、ACM 院士。
- **開創經典方法論：**
  - **Booch 方法**與劃時代著作：《物件導向分析與設計》(Object-Oriented Analysis and Design with Applications)。
- **對 UML 的核心貢獻：**
  - 極度專注於**具體軟體設計**、模組拆解、類別抽象化與架構模式。
  - 提倡為實作層級的物件結構與程式碼對應關係提供高度的視覺表現力。
- **著名軟體工程箴言：**
  > *"乾淨的程式碼讀起來，永遠就像是由深具責任心與熱忱的人所撰寫。"*

</div>
<div class="content-figure">

<div class="name-card">
<img src="../../img/ch05/grady_booch.jpg" alt="Grady Booch" />
<div class="name-card-caption">
<span class="name-card-name">Grady Booch</span>
<span class="name-card-cc"><a href="https://en.wikipedia.org/wiki/Grady_Booch" target="_blank">Rational Software / IBM Fellow</a></span>
</div>
</div>

</div>
</div>

<!--
讓我們認識三巨頭中的第一位：Grady Booch。

Grady Booch 是 IBM 院士，曾任 Rational Software 首席科學家。他所著的《物件導向分析與設計》是軟體工程領域的殿堂級經典。

Booch 的獨特強項在於「具體軟體設計」——類別、繼承、多型與模組如何直接對應到可執行的程式碼架構。他早期著名的雲朵形狀類別記號，後來演變為 UML 標準的三格矩形。

總結這張投影片，請記住這個核心觀念：Grady Booch 奠定了物件導向設計抽象化與程式碼具體架構對應的基石。
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
<img src="../../img/ch05/james_rumbaugh.jpg" alt="James Rumbaugh" />
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
<img src="../../img/ch05/ivar_jacobson.jpg" alt="Ivar Jacobson" />
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
<div class="ccq-columns">
<div class="ccq-text">

在被尊稱為「UML 三巨頭」的軟體工程大師中，哪一位以於 1986 年發明**使用案例 (Use Cases)**、將軟體架構直接錨定於使用者具體目標而聞名？

- **A.** Grady Booch
- **B.** James Rumbaugh
- **C.** Ivar Jacobson
- **D.** Martin Fowler

</div>
<div class="ccq-logo">
<img src="../../img/ch05/question_icon.svg" alt="Question Icon" style="max-width: 140px;" />
</div>
</div>

<!--
讓我們透過觀念測驗 1 來檢驗對 UML 發展史的理解。

檢視各個選項：
Grady Booch 開創了 Booch 方法，主攻物件導向設計與程式碼映射。
James Rumbaugh 開發了 OMT 方法，專精領域分析與物件狀態模型。
Martin Fowler 則是撰寫《UML 精華 (UML Distilled)》與《重構》的大師，但他並非三巨頭成員。

正確答案是 C：Ivar Jacobson！Jacobson 於 1986 年在愛立信提出使用案例，徹底將軟體架構引導向以使用者目標為核心的典範。

總結這張投影片，請記住這個核心觀念：Ivar Jacobson 發明了使用案例，將需求與架構聚焦於使用者具體目標。
-->
---
<!-- _class: lead -->
<!-- header: '4.3 功能塑模與使用案例模型' -->

# **4.3 功能塑模與使用案例模型**

> "使用案例是系統與其參與者之間為了達成可衡量業務目標所簽署的行為契約。"
> — *Alistair Cockburn*

<!--
我們現在進入第 4.3 節：功能塑模與使用案例模型。

由 Ivar Jacobson 於 1986 年發明的使用案例，是業界界定功能範疇的黃金標準。它打破過去散落、非結構化的文字需求，將軟體功能緊密圍繞在「參與者」與「可衡量的商業目標」周圍。

讓我們透過美食外送平台案例，深入解析使用案例塑模的精髓。

總結本頁核心：使用案例定義了外部參與者與受測系統之間的黑箱功能契約。
-->
---
## 使用案例塑模：核心定義與工程價值

> 「使用案例捕捉了外部參與者與系統之間的行為契約，旨在交付可衡量的業務價值。」

<div class="two-columns">
<div class="card" data-marpit-fragment>
<h3>核心定義與抽象層次 (What It Is)</h3>
<ul>
<li><b>契約型功能範疇：</b> 採取外部黑箱視角，精確界定系統為使用者提供「什麼 (What)」服務，不涉及內部程式細節。</li>
<li><b>目標導向的核心：</b> 將軟體需求錨定在人類使用者或外部系統所欲達成的離散商業目標。</li>
<li><b>劃定系統邊界周界：</b> 明確區隔哪些責任屬於軟體內部，哪些屬於外部使用者或第三方平台。</li>
</ul>
</div>
<div class="card" data-marpit-fragment>
<h3>工程價值與防範風險 (Why It Is Important)</h3>
<ul>
<li><b>根除需求描述的模糊性：</b> 取代散落各處、語意不清的文字條列，整合成目標一致的交易流程。</li>
<li><b>防止範疇蔓延 (Scope Creep)：</b> 嚴謹的系統邊界方框，為衝刺開發與版本發布建立明確的交付承諾。</li>
<li><b>驗收測試 (UAT) 的直接依據：</b> 主要成功情境與例外分支，可 100% 轉譯為端到端系統整合測試案例。</li>
</ul>
</div>
</div>

<!--
首先讓我們在 4.3 節深入理解：什麼是使用案例模型？為什麼軟體工程師必須建立它？

第一，核心定義：使用案例是一份行為契約。它從系統外圍看進來——系統是一個黑箱。它回答了：外部參與者透過與系統互動，獲得了什麼具體價值？

第二，工程價值：若缺乏使用案例，需求規格往往淪為數百條雜亂無章的願望清單。使用案例將互動凝聚為具備商業價值的交易，並直接作為驗收測試的唯一真理來源。

總結本頁核心：使用案例模型界定了以參與者為核心的功能邊界與合約承諾。
-->
---
## 使用案例塑模：四步標準工程流程

> 「使用案例塑模絕不只是在圖上畫圈圈；結構化的使用案例規格敘述書，才是真正的行為契約。」

<div style="display: flex; align-items: stretch; justify-content: space-between; gap: 12px; margin-top: 14px;">
<div class="card" style="flex: 1; padding: 14px 12px; background: #ffffff; border-top: 4px solid #0284c7; border-radius: 8px;">
<div style="font-size: 13px; font-weight: 700; color: #0284c7; text-transform: uppercase;">步驟 1</div>
<h4 style="font-size: 16.5px; margin: 4px 0 6px 0; color: #0b3c5d;">識別參與者<br><span style="font-size: 12px; color: #64748b; font-weight: normal;">(Identify Actors)</span></h4>
<ul style="font-size: 13px; line-height: 1.35; padding-left: 15px; margin: 0;">
<li><b>主要參與者：</b> 主動使用者（顧客、外送員）。</li>
<li><b>支援參與者：</b> 外部 API（金流系統）。</li>
<li>定義人與系統在邊界外角色。</li>
</ul>
</div>

<div style="display: flex; align-items: center; justify-content: center; font-size: 20px; color: #0284c7; font-weight: bold;">→</div>

<div class="card" style="flex: 1; padding: 14px 12px; background: #ffffff; border-top: 4px solid #0ea5e9; border-radius: 8px;">
<div style="font-size: 13px; font-weight: 700; color: #0ea5e9; text-transform: uppercase;">步驟 2</div>
<h4 style="font-size: 16.5px; margin: 4px 0 6px 0; color: #0b3c5d;">界定使用案例<br><span style="font-size: 12px; color: #64748b; font-weight: normal;">(Identify Use Cases)</span></h4>
<ul style="font-size: 13px; line-height: 1.35; padding-left: 15px; margin: 0;">
<li><b>目標驅動：</b> 鎖定完整交易（如訂餐）。</li>
<li><b>控制粒度：</b> 排除瑣碎 UI 點擊動作。</li>
<li>交付可衡量實質業務價值。</li>
</ul>
</div>

<div style="display: flex; align-items: center; justify-content: center; font-size: 20px; color: #0ea5e9; font-weight: bold;">→</div>

<div class="card" style="flex: 1; padding: 14px 12px; background: #ffffff; border-top: 4px solid #38bdf8; border-radius: 8px;">
<div style="font-size: 13px; font-weight: 700; color: #38bdf8; text-transform: uppercase;">步驟 3</div>
<h4 style="font-size: 16.5px; margin: 4px 0 6px 0; color: #0b3c5d;">繪製案例圖與關係<br><span style="font-size: 12px; color: #64748b; font-weight: normal;">(Model Diagram)</span></h4>
<ul style="font-size: 13px; line-height: 1.35; padding-left: 15px; margin: 0;">
<li><b>系統邊界：</b> 劃定系統範疇方框。</li>
<li><b><code>&lt;&lt;include&gt;&gt;</code>：</b> 抽取共用強制子程序。</li>
<li><b><code>&lt;&lt;extend&gt;&gt;</code>：</b> 隔離條件擴充功能。</li>
</ul>
</div>

<div style="display: flex; align-items: center; justify-content: center; font-size: 20px; color: #38bdf8; font-weight: bold;">→</div>

<div class="card" style="flex: 1.1; padding: 14px 12px; background: #f0fdf4; border: 1.5px solid #22c55e; border-top: 4px solid #16a34a; border-radius: 8px;">
<div style="font-size: 13px; font-weight: 800; color: #15803d; text-transform: uppercase;">步驟 4 ★ 核心工程產出</div>
<h4 style="font-size: 16.5px; margin: 4px 0 6px 0; color: #14532d;">撰寫案例規格敘述<br><span style="font-size: 12px; color: #166534; font-weight: normal;">(Write UC Description)</span></h4>
<ul style="font-size: 13px; line-height: 1.35; padding-left: 15px; margin: 0; color: #14532d;">
<li><b>前置 / 後置條件：</b> 系統狀態契約。</li>
<li><b>主要成功情境：</b> 雙向互動步驟。</li>
<li><b>例外替代分支：</b> 錯誤處理規格。</li>
</ul>
</div>
</div>

> 📌 **工程洞見：** 使用案例圖只是一張視覺化的目錄索引，**使用案例規格敘述書 (Use Case Description)** 才是指導工程師實作與品保人員驗收測試的真正契約。

<!--
這張概念圖完整呈現了使用案例塑模的四步標準工程流程。

請觀察橫向管線的遞進：
步驟 1：識別所有人類角色與外部系統參與者。
步驟 2：界定目標導向的使用案例，避免瑣碎按鈕動作。
步驟 3：劃定系統邊界方框，透過 include 與 extend 梳理共用與擴充邏輯。
步驟 4：撰寫結構化使用案例規格敘述書！

請特別記住步驟 4：許多初學者以為畫出橢圓形就大功告成，事實上，圖形只是索引，詳盡的文字規格敘述書才是軟體工程的真正基石！

總結本頁核心：使用案例塑模遵循參與者、目標、圖形關係到規格敘述書的四步工程流程。
-->
---
## 步驟 1 & 2：識別參與者與界定目標導向的使用案例

- **主要參與者 vs. 支援參與者：**
  - **主要參與者 (Primary Actors，顧客、餐廳、外送員)：** 主動發起使用案例以達成個人業務目標的人類使用者。
  - **支援參與者 (Supporting Actors，第三方金流閘道)：** 由系統在背後呼叫以協助完成交易的外部服務系統。
- **系統邊界與參與關聯：**
  - 邊界矩形方框劃定「軟體系統內部」與「外部世界」的權責界線。
  - 實線關聯將參與者與其參與的案例橢圓相連。
- **案例粒度黃金法則 (Granularity Rule of Thumb)：**
  - 使用案例必須代表一項**完整的、能交付實質價值的業務交易**。
  - *反模式 (Anti-Pattern)：* 「點擊登入按鈕」、「輸入密碼」（此為微小 UI 動作，絕非使用案例！）。
  - *最佳實踐：* 「美食訂餐下單」、「管理餐廳菜單」（交付具體業務價值）。

<!--
依照我們的流程，首先看步驟 1 與步驟 2：識別參與者與使用案例。

第一，區分主要與支援參與者。顧客要吃飯，所以是發起案例的主要參與者；Stripe 金流是被系統呼叫幫忙扣款的支援參與者。

第二，嚴守粒度控制！初學者常犯的錯誤是將按鈕點擊寫成使用案例。使用案例必須交付端到端、對使用者有實質意義的業務價值。

總結本頁核心：塑模完整的價值交易，絕不拆解成瑣碎的 UI 操作。
-->
---
<!-- _class: title-image-slide -->

## 步驟 3：美食外送平台完整使用案例圖

<div class="image-wrapper">
<img src="../../img/ch05/food_delivery_usecase.svg" alt="美食外送平台完整使用案例圖" />
</div>

<!--
進入步驟 3：繪製使用案例圖。

請觀察橫向平衡的構圖：
左側配置發起業務的顧客與餐廳夥伴；
右側配置外送員以及第三方的金流處理系統。
左右平衡佈局讓寬螢幕閱覽一目了然。

顧客發起「瀏覽菜單」、「美食訂餐下單」、「追蹤外送」與「取消訂單」；
餐廳管理菜單並接單；外送員接單並完成配送；
而「美食訂餐下單」透過 include 引入了「處理金流付款」，進而呼叫外部金流閘道。

總結本頁核心：兩側分流參與者與清晰邊界，構建出高可讀性的使用案例架構圖。
-->
---
## 步驟 3：符號深解：`<<include>>` 與 `<<extend>>` 的關鍵差異

<div class="two-columns">
<div class="card">
<h3>&lt;&lt;include&gt;&gt; 包含關係（強制執行）</h3>
<ul>
<li><b>語意本質：</b> 基礎案例<b>若未執行被包含案例，則無法成功完成</b>。</li>
<li><b>箭頭方向：</b> <b>由基礎案例指向被包含案例</b>（<code>基礎 ..&gt; 被包含</code>）。</li>
<li><b>工程目的：</b> 抽取多個案例共用的強制性子程序（例如：外送下單與會員訂閱皆需<i>處理金流付款</i>）。</li>
</ul>
</div>
<div class="card">
<h3>&lt;&lt;extend&gt;&gt; 擴充關係（條件觸發）</h3>
<ul>
<li><b>語意本質：</b> 基礎案例本身已可獨立完成；僅在<b>特定觸發條件</b>滿足時才插入額外行為。</li>
<li><b>箭頭方向：</b> <b>由擴充案例指回基礎案例</b>（<code>擴充 ..&gt; 基礎</code>）。</li>
<li><b>工程目的：</b> 隔離非核心的可選邏輯（如套用優惠券），避免污染基礎情境。</li>
</ul>
</div>
</div>

<!--
繼續步驟 3，我們必須徹底釐清 UML 最常考也最常被誤用的兩大關係：Include 與 Extend。

Include 代表強制共用：箭頭由主案例指向子案例。下單買餐絕對必須付款，不能略過！
Extend 代表可選擴充：箭頭由擴充案例倒指回主案例！只有在顧客持有折價券時才觸發，基礎下單就算不折價也能獨立完成。

總結本頁核心：Include 指向強制共用模組；Extend 由可選功能指回基礎案例。
-->
---
<!-- _class: title-image-slide -->

## 步驟 3：Include 與 Extend 視覺語法语意解析

<div class="image-wrapper">
<img src="../../img/ch05/food_delivery_include_extend.svg" alt="Include 與 Extend 機制對比圖" />
</div>

<!--
這張對比圖清晰展示了兩者的語法差異：

上方：「美食訂餐下單」實線箭頭指向「處理金流付款」，標註 include。因為付款是下單必經的強制環節。
下方：「套用促銷優惠券」由外側指回「美食訂餐下單」，標註 extend。因為優惠券純屬可選擴充，只有在結帳前輸入有效代碼才會生效。

請特別注意箭頭的方向性：Include 向前指，Extend 往回指！

總結本頁核心：Include 指向必經子程序，Extend 由條件擴充倒指回主案例。
-->
---
## 步驟 4：撰寫使用案例規格敘述書 (系統的行為契約)

> 「沒有書面規格敘述的使用案例，只是一個沒有故事的標題而已。」— *Alistair Cockburn*

<div class="two-columns">
<div class="card" data-marpit-fragment>
<h3>使用案例規格敘述書的核心結構</h3>
<ul>
<li><b>識別碼與名稱：</b> 唯一編號 (如 <code>UC-01</code>) 與動賓片語標題 (如 <code>美食訂餐下單</code>)。</li>
<li><b>主要參與者與觸發事件：</b> 誰發起此流程？何種商業事件促成互動開始？</li>
<li><b>前置條件 (Preconditions)：</b> 流程開始前系統<b>必須滿足</b>的真值狀態（如：顧客已認證、餐廳營業中）。</li>
<li><b>後置條件 (Postconditions)：</b> 成功完成後系統保證達成的狀態（如：訂單處於 <code>PAID</code> 狀態、廚房接獲通知）。</li>
</ul>
</div>
<div class="card" data-marpit-fragment>
<h3>情境流程劃分與驗收角色</h3>
<ul>
<li><b>主要成功情境 (Main Flow)：</b> 編號條列的雙向對話：使用者操作步驟 → 系統驗證與回饋。</li>
<li><b>替代與例外情境 (Alternative Flows)：</b> 錯誤處理、卡號失效或可選擴充（如 <code>3a. 信用卡授權遭拒</code>）。</li>
<li><b>驗收測試 (UAT) 的基石：</b> 規格書中的每一條例外分支，直接對應至一組端到端自動化測試案例！</li>
<li><b>軟體架構的腳本：</b> 主要成功情境直接作為循序圖 (4.5) 物件互動的設計腳本。</li>
</ul>
</div>
</div>

<!--
現在我們邁入步驟 4：撰寫使用案例規格敘述書。這是需求轉化為工程合約的關鍵產出。

請看左側卡片：一份專業的規格書必定具備前置條件與後置條件，定義系統在執行前後的狀態契約。

請看右側卡片：主要成功情境描寫最順暢的正常路徑。但真實世界中 80% 的臭蟲都在例外狀況！透過擴充情境記錄付款失敗、菜品售罄，每一條分支都能直接寫成自動化測試案例。

總結本頁核心：規格敘述書詳盡規範前置/後置條件、主情境與替代分支，是軟體實作與測試的基石。
-->
---
## 步驟 4：結構化使用案例規格書：美食訂餐下單 (UC-01)

| 規格書欄位 | 具體技術說明與規格定義 |
| :--- | :--- |
| **案例代號與名稱** | **UC-01: 美食訂餐下單 (Place Food Order)** |
| **主要參與者** | 顧客 (已註冊並通過認證之 FoodieGo App 會員) |
| **前置條件 (Pre)** | 顧客處於已登入狀態；購物車內至少有 1 項有效餐點，且該餐廳處於營業接單狀態。 |
| **後置條件 (Post)** | 訂單建立並標記為 `PAID` 狀態；通知廚房接單；外送排程佇列已建立；收據寄發顧客。 |
| **主要成功情境 (Main Flow)** | 1. 顧客於購物車結帳頁面點擊「確認送出訂單」。<br>2. 系統進行即時庫存校驗，並精算餐點小計、外送費與應付總額。<br>3. 系統執行 `<<include>>` **UC-02: 處理金流付款**，向外部第三方金流驗證扣款。<br>4. 系統寫入持久化資料庫，產生唯一訂單編號 `orderId`。<br>5. 系統向餐廳端管理儀表板推播即時訂單製備通知。<br>6. 系統建立 GPS 外送追蹤通訊工作階段，並回傳預估抵達時間。 |
| **擴充例外情境 (Extensions)** | **3a. 信用卡扣款授權遭拒：**<br>&nbsp;&nbsp;&nbsp;&nbsp;3a1. 系統即時提示顧客卡號失效，訂單暫存保留為 `DRAFT` 待付狀態。<br>**4a. `<<extend>>` 套用促銷優惠券：**<br>&nbsp;&nbsp;&nbsp;&nbsp;4a1. 顧客於結帳前輸入有效代碼，系統於步驟 3 扣款前扣抵折扣金額。 |

<!--
這就是步驟 4 的具體工程產出：UC-01 美食訂餐下單的結構化規格書。

請看這份契約的嚴密性：
前置條件確保購物車與餐廳狀態合法；
主要成功情境明確交代了 6 步交易對話；
第 3 步透過 include 引入付款；
而例外分支 3a 清楚交代扣款失敗時回到 DRAFT 狀態，4a 則銜接優惠券 extend 邏輯。

工程師與品保團隊完全可以依此規格開發與撰寫測試，不留任何瞎猜空間。

總結本頁核心：結構化表格詳盡規範了案例的步驟、包含關係與例外處理機制。
-->
---
## 使用案例模型：與其他 UML 模型的協同關係

> 「使用案例規格敘述書是軟體開發的單一事實來源，驅動結構、動態與狀態模型的建立。」

<div style="display: flex; gap: 16px; align-items: stretch; margin-top: 14px;">
<!-- Left: Use Case Anchor -->
<div class="card" style="flex: 32%; background: #f8fafc; border: 2px solid #0284c7; border-radius: 8px; padding: 16px 14px; display: flex; flex-direction: column; justify-content: center; text-align: center;">
<div style="background: #0284c7; color: #ffffff; font-weight: 700; font-size: 12px; padding: 3px 8px; border-radius: 4px; display: inline-block; margin: 0 auto 8px auto;">需求單一事實來源</div>
<h3 style="margin: 0 0 6px 0; color: #0b3c5d; font-size: 19px;">4.3 使用案例模型</h3>
<p style="font-size: 13.5px; line-height: 1.4; color: #334155; margin: 0 0 10px 0;">定義外部黑箱行為契約與端到端價值情境。</p>
<div style="background: #ffffff; border: 1px dashed #cbd5e1; border-radius: 6px; padding: 8px; font-size: 12.5px; color: #0369a1; text-align: left;">
      • 參與者與邊界劃定<br>
      • 目標導向使用案例<br>
      • 結構化規格敘述書
</div>
</div>
<!-- Middle: Connective arrows -->
<div style="display: flex; flex-direction: column; justify-content: space-around; align-items: center; width: 24px; font-size: 20px; color: #0284c7; font-weight: bold;">
<div>→</div>
<div>→</div>
<div>→</div>
</div>
<!-- Right: 3 Dependent Models -->
<div style="flex: 64%; display: flex; flex-direction: column; gap: 8px;">
<!-- To Class Model -->
<div class="card" style="padding: 10px 14px; background: #ffffff; border-left: 4px solid #3b82f6; border-radius: 6px;">
<div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 3px;">
<h4 style="margin: 0; font-size: 15.5px; color: #0b3c5d;">4.4 領域類別模型 (結構骨幹)</h4>
<span style="background: #eff6ff; color: #1d4ed8; font-size: 11.5px; font-weight: 600; padding: 1px 6px; border-radius: 4px;">名詞分析法</span>
</div>
<p style="font-size: 13px; line-height: 1.35; color: #475569; margin: 0;">
        使用案例步驟中的<b>領域名詞</b>（Customer, Order, Dish）直接提取為領域實體類別、資料屬性與持久化關聯。
      </p>
</div>
<!-- To Sequence Diagram -->
<div class="card" style="padding: 10px 14px; background: #ffffff; border-left: 4px solid #8b5cf6; border-radius: 6px;">
<div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 3px;">
<h4 style="margin: 0; font-size: 15.5px; color: #0b3c5d;">4.5 互動循序圖 (動態交互)</h4>
<span style="background: #f5f3ff; color: #6d28d9; font-size: 11.5px; font-weight: 600; padding: 1px 6px; border-radius: 4px;">場景動態實現</span>
</div>
<p style="font-size: 13px; line-height: 1.35; color: #475569; margin: 0;">
        使用案例的<b>主要情境與例外分支</b>，直接轉譯為循序圖的時間序列腳本，由 BCE 物件協同實踐該案例。
      </p>
</div>
<!-- To State Machine -->
<div class="card" style="padding: 10px 14px; background: #ffffff; border-left: 4px solid #10b981; border-radius: 6px;">
<div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 3px;">
<h4 style="margin: 0; font-size: 15.5px; color: #0b3c5d;">4.6 有限狀態機 (生命週期)</h4>
<span style="background: #ecfdf5; color: #047857; font-size: 11.5px; font-weight: 600; padding: 1px 6px; border-radius: 4px;">觸發事件與前置守衛</span>
</div>
<p style="font-size: 13px; line-height: 1.35; color: #475569; margin: 0;">
        使用案例中的操作是激發實體<b>狀態躍遷</b>的外部事件（如付款使訂單轉為 PAID）；狀態機狀態亦守衛使用案例前置條件。
      </p>
</div>
</div>
</div>

<!--
在結束 4.3 節前，請看這張跨模型協同概念圖。

左側是使用案例模型——整個軟體架構的需求單一事實來源。
看右側的三大對接：
1. 類別模型：案例文字裡的名詞，直接成為 4.4 的類別。
2. 循序圖：案例裡的對話步驟，直接成為 4.5 的動態訊息呼叫。
3. 狀態機：使用者的操作觸發了 4.6 的狀態跳轉，而當前狀態更是案例能不能執行的前置守衛！

使用案例成功串接了需求、結構、互動與生命週期。

總結本頁核心：使用案例規格書是整個系統塑模的母體，驅動類別、循序與狀態機的誕生。
-->
---
### 觀念檢核測驗 3 (CCQ 3)

<div class="ccq-columns">
<div class="ccq-text">

在美食外送使用案例模型中，為何「套用優惠折扣碼」使用 `<<extend>>` 指向「美食訂餐下單」，而「美食訂餐下單」卻使用 `<<include>>` 指向「處理信用卡扣款」？

- **A.** 折扣碼是每筆訂單強制必填的欄位；而扣款則是自由選填的項目。
- **B.** 折扣碼為特定條件下的選用行為；而扣款則是結帳必定執行的共用程序。
- **C.** 折扣碼由次要參與者發起執行；而扣款則由主要參與者獨立完成。
- **D.** 折扣碼代表類別層級的繼承關係；而扣款代表物件層級的組合關係。

</div>
<div class="ccq-logo">
<img src="../../img/ch05/question_icon.svg" alt="Question Icon" style="max-width: 140px;" />
</div>
</div>

<!--
讓我們透過觀念測驗 2 來檢驗對使用案例關係的理解。

分析選項：
選項 A 完全顛倒了業務邏輯。
選項 C 混淆了參與者角色與關聯構造型（Stereotypes）。
選項 D 混淆了類別圖與使用案例圖的箭頭概念。

正確答案是 B！套用優惠碼是有條件且非強制的選用行為——沒有折價券也能順利下單。相對地，處理扣款是每筆結帳必經的共用子流程。

總結這張投影片，請記住這個核心觀念：Include 代表必定執行的共用功能，Extend 則代表有條件觸發的選用行為。
-->
---
<!-- _class: lead -->
<!-- header: '4.4 結構塑模與領域類別圖' -->

# **4.4 結構塑模與領域類別圖**

> "Classes are the static building blocks; objects are the living runtime instances."  
> *(類別是系統的靜態積木；物件是運作時的鮮活實例。)*

<!--
我們現在轉進 4.4 節：結構塑模與領域類別圖（Class Diagrams）。

循序圖展現了特定場景下的動態訊息傳遞，但我們同樣需要精確定義軟體的靜態組織——包含有哪些類別、各自具備哪些欄位與方法，以及不受時間流逝影響的物件關聯。

讓我們檢視美食外送平台的領域類別模型。

總結這張投影片，請記住這個核心觀念：類別圖定義了物件導向系統的靜態架構骨幹與領域實體關聯。
-->
---
## 領域類別塑模：核心定義與工程價值

> 「類別圖定義了物件導向系統的靜態架構骨幹、領域實體關聯與資料封裝防線。」

<div class="two-columns">
<div class="card" data-marpit-fragment>
<h3>何謂類別模型 (Definition & Abstraction)</h3>
<ul>
<li><b>靜態結構藍圖：</b> 一種完全獨立於執行時序的模型，定義軟體型別、內部封裝狀態（屬性）與操作責任（方法）。</li>
<li><b>領域實體映射：</b> 將真實世界問題領域的商業概念、實體與規則，精準轉化為物件導向軟體的抽象表示。</li>
<li><b>結構關聯分類學：</b> 形式化定義關聯 (Association)、聚合 (◇)、組合 (◆) 與一般化繼承 (Generalization)。</li>
</ul>
</div>
<div class="card" data-marpit-fragment>
<h3>為何至關重要 (Engineering Value)</h3>
<ul>
<li><b>程式碼與資料庫的直接映射：</b> 標準三格矩形（類別名稱、屬性、方法）可 1:1 直接轉換為 OOP 原始碼與關聯式資料表架構。</li>
<li><b>精確控制物件生命週期耦合：</b> 嚴格區分「同生共死」的強擁有關係（組合）與「彼此獨立」的弱擁有關係（聚合）。</li>
<li><b>資料封裝與語意完整性防線：</b> 透過可見度符號（<code>+</code>、<code>-</code>、<code>#</code>）保護內部狀態不變量，防範外部任意篡改。</li>
</ul>
</div>
</div>

<!--
讓我們進入 4.4 節，探討領域類別模型的核心本質與工程重要性。

首先，何謂類別模型：類別圖是系統的靜態結構藍圖。它完全不受時間先後影響，定義了軟體中的類別、欄位、方法，以及實體之間的關聯與繼承關係。

其次，為什麼它至關重要：如果不先建立類別模型就貿然寫程式碼，往往會寫出高度耦合、難以維護的爛代碼。類別圖貫徹物件導向封裝原則，並清楚區分物件生命週期的強弱耦合。

總結這張投影片，請記住這個核心觀念：類別圖定義了物件導向系統的靜態骨幹、封裝界限與資料綱要。
-->
---
## 領域類別塑模：四步標準工程流程

> 「領域塑模將真實世界中混亂的概念名詞，轉化為高內聚、低偶合的物件導向結構架構。」

<div style="display: flex; align-items: stretch; justify-content: space-between; gap: 12px; margin-top: 14px;">
<div class="card" style="flex: 1; padding: 14px 12px; background: #ffffff; border-top: 4px solid #3b82f6; border-radius: 8px;">
<div style="font-size: 13px; font-weight: 700; color: #3b82f6; text-transform: uppercase;">步驟 1</div>
<h4 style="font-size: 16.5px; margin: 4px 0 6px 0; color: #0b3c5d;">名詞分析法<br><span style="font-size: 12px; color: #64748b; font-weight: normal;">(Extract Nouns)</span></h4>
<ul style="font-size: 13px; line-height: 1.35; padding-left: 15px; margin: 0;">
<li>從使用案例規格敘述中提取候選實體。</li>
<li>排除短暫 UI 暫存值與無意義純量。</li>
</ul>
</div>

<div style="display: flex; align-items: center; justify-content: center; font-size: 20px; color: #3b82f6; font-weight: bold;">→</div>

<div class="card" style="flex: 1; padding: 14px 12px; background: #ffffff; border-top: 4px solid #2563eb; border-radius: 8px;">
<div style="font-size: 13px; font-weight: 700; color: #2563eb; text-transform: uppercase;">步驟 2</div>
<h4 style="font-size: 16.5px; margin: 4px 0 6px 0; color: #0b3c5d;">指派屬性與操作<br><span style="font-size: 12px; color: #64748b; font-weight: normal;">(Attributes & Methods)</span></h4>
<ul style="font-size: 13px; line-height: 1.35; padding-left: 15px; margin: 0;">
<li>定義資料狀態與可見度 (+, -, #)。</li>
<li>依照單一職責指派核心業務操作。</li>
</ul>
</div>

<div style="display: flex; align-items: center; justify-content: center; font-size: 20px; color: #2563eb; font-weight: bold;">→</div>

<div class="card" style="flex: 1; padding: 14px 12px; background: #ffffff; border-top: 4px solid #1d4ed8; border-radius: 8px;">
<div style="font-size: 13px; font-weight: 700; color: #1d4ed8; text-transform: uppercase;">步驟 3</div>
<h4 style="font-size: 16.5px; margin: 4px 0 6px 0; color: #0b3c5d;">建立關聯與重數<br><span style="font-size: 12px; color: #64748b; font-weight: normal;">(Multiplicities)</span></h4>
<ul style="font-size: 13px; line-height: 1.35; padding-left: 15px; margin: 0;">
<li>繪製物件間的結構連線與角色名稱。</li>
<li>標註嚴格基數上下限 (1, 0..1, 1..*)。</li>
</ul>
</div>

<div style="display: flex; align-items: center; justify-content: center; font-size: 20px; color: #1d4ed8; font-weight: bold;">→</div>

<div class="card" style="flex: 1.1; padding: 14px 12px; background: #eff6ff; border: 1.5px solid #3b82f6; border-top: 4px solid #1e40af; border-radius: 8px;">
<div style="font-size: 13px; font-weight: 800; color: #1e40af; text-transform: uppercase;">步驟 4 ★ 生命週期控制</div>
<h4 style="font-size: 16.5px; margin: 4px 0 6px 0; color: #1e3a8a;">重構生命週期<br><span style="font-size: 12px; color: #1d4ed8; font-weight: normal;">(聚合 ◇ vs 組合 ◆)</span></h4>
<ul style="font-size: 13px; line-height: 1.35; padding-left: 15px; margin: 0; color: #1e3a8a;">
<li><b>聚合 (◇)：</b> 獨立共享生命週期（餐廳與餐點）。</li>
<li><b>組合 (◆)：</b> 級聯銷毀所有權（訂單與明細項目）。</li>
</ul>
</div>
</div>

> 📌 **工程洞見：** 類別塑模的核心在於**定義物件責任邊界與生命週期偶合度**——在撰寫任何 SQL 或 OOP 程式碼前，徹底杜絕記憶體洩漏與孤兒資料風險。
---
<!-- _class: title-image-slide -->

## 美食外送領域：類別圖架構藍圖

<div class="image-wrapper">
<img src="../../img/ch05/food_delivery_class.svg" alt="美食外送領域類別圖" />
</div>

<!--
請看這張完整的美食外送平台領域類別圖。

觀察所有結構元素的精確整合：
最上方是抽象父類別 `User`，由 `Customer` 與 `Courier` 繼承泛化。
正中央核心實體是 `Order`。
請注意實心黑菱形：`Restaurant` 組合了 `MenuItem`，而 `Order` 組合了 `OrderItem`。
請注意空心白菱形：`DeliveryTask` 聚合了 `Courier`。
再注意每條關聯線兩端的重數（Multiplicity）：`1`、`1..*`、`0..*` 與 `0..1`。

接下來我們逐一拆解這張圖背後的軟體工程決策。

總結這張投影片，請記住這個核心觀念：領域類別圖將類別、繼承、整體部分生命週期與重數綜合成完整的資料藍圖。
-->
---
## 領域類別結構與物件生命週期關聯解析

- **泛化繼承階層 (Generalization / Inheritance)：**
  - `User` 為抽象父類別，定義共用屬性（`userId`, `phone`, `email`）與方法（`login()`）。
  - `Customer` 與 `Courier` 特化繼承 `User`，共享帳號身分同時擴充專屬欄位（如送餐地址 vs. 載具型態與 GPS 座標）。
- **組合 (`◆` 實心菱形，Composition) — 強整體–部分擁有關係：**
  - `Order "1" *-- "1..*" OrderItem`：`OrderItem`（例如兩份辣味漢堡）脫離父層 `Order` 便無獨立存在的意義。若訂單被刪除，其下的訂單明細必須連帶被串聯刪除（Cascade Delete）！
  - `Restaurant "1" *-- "1..*" MenuItem`：菜單料理嚴格附屬於該發布餐廳。
- **聚合 (`◇` 空心菱形，Aggregation) — 弱整體–部分擁有關係：**
  - `DeliveryTask "0..*" o-- "1" Courier`：外送任務分派給外送員，但外送員具備**完全獨立的生命週期**。外送任務結束或被取消時，外送員依然留在系統中！
- **關聯與價格歷史快照去耦合：**
  - `OrderItem` 以 `0..* --> 1` 關聯 `MenuItem`。`OrderItem` 獨立記錄下單當下的歷史成交單價，未來餐廳調漲漢堡價格時，過去的歷史訂單金額絕不會受到波及。

<!--
深入剖析類別關聯背後的工程考量：

請大家務必釐清「組合」與「聚合」的重大差異：
`OrderItem` 指向 `Order` 是實心菱形（組合）！如果訂單刪除，裡面的明細項目隨之消失，不可能單獨飄在記憶體裡。

但 `DeliveryTask` 指向 `Courier` 是空心菱形（聚合）！任務包含了一位外送員，但外送員是獨立個體。送完這單，外送員繼續在線等待下一單。

另外，`OrderItem` 獨立保存單價快照，能避免商家下個月調漲菜單時，上個月已結算訂單金額跟著跳動的嚴重財務災難！

總結這張投影片，請記住這個核心觀念：在塑模整體部分關係時，務必區分組合（生命週期綁定）與聚合（具備獨立生命週期）。
-->
---
## 類別圖標準語法：三格矩形、可見度與關聯重數

- **標準三格類別方塊 (Three-Compartment Box)：**
  - **頂層方格：** 類別名稱，採 `PascalCase`（斜體代表 `abstract` 抽象類別）。
  - **中層方格：** 屬性欄位：`[可見度] 名稱 : 型別 [= 預設值]`。
  - **底層方格：** 操作方法：`[可見度] 名稱(參數 : 型別) : 回傳型別`。
- **可見度修飾詞 (Visibility Modifiers，封裝文法)：**
  - `+` **Public (公有)：** 整個系統任何類別皆可公開存取。
  - `-` **Private (私有)：** 嚴格封裝於本類別宣告內部。
  - `#` **Protected (保護)：** 僅限本類別與其衍生子類別存取。
  - `~` **Package (套件私有)：** 僅限同模組或命名空間內存取。
- **關聯端重數標示 (Multiplicity)：**
  - `1`：剛好精確 1 個實例。
  - `0..1`：選用；0 個或 1 個實例。
  - `0..*` (或 `*`)：0 個至多個實例。
  - `1..*`：至少 1 個實例（上不封頂）。

<!--
這是類別圖語法的快速參考手冊：

每個類別矩形分為三格：名稱、屬性與操作方法。
可見度符號落實物件導向封裝精神：加號代表 public，減號代表 private，井號代表 protected。

關聯兩端的重數宣示了系統的關鍵業務規則：
`1` 代表恰好一個。
`0..1` 代表選用。
`1..*` 代表至少一個。
例如，我們宣告 `Order` 必須包含 `1..*` 筆 `OrderItem`，意味著商業邏輯禁止建立 0 項商品的空訂單！

總結這張投影片，請記住這個核心觀念：類別方格定義名稱、屬性與操作，並透過嚴格的可見度與重數語義落實物件導向設計。
-->
---
## 領域類別模型：與其他 UML 模型的協同關係

> 「領域類別模型構築了軟體系統的靜態結構骨幹，為動態互動與生命週期跳轉提供載體。」

<div style="display: flex; gap: 16px; align-items: stretch; margin-top: 14px;">
<div class="card" style="flex: 32%; background: #f8fafc; border: 2px solid #3b82f6; border-radius: 8px; padding: 16px 14px; display: flex; flex-direction: column; justify-content: center; text-align: center;">
<div style="background: #3b82f6; color: #ffffff; font-weight: 700; font-size: 12px; padding: 3px 8px; border-radius: 4px; display: inline-block; margin: 0 auto 8px auto;">靜態結構核心</div>
<h3 style="margin: 0 0 6px 0; color: #0b3c5d; font-size: 19px;">4.4 領域類別模型</h3>
<p style="font-size: 13.5px; line-height: 1.4; color: #334155; margin: 0 0 10px 0;">定義領域實體概念、屬性狀態與生命週期偶合結構。</p>
<div style="background: #ffffff; border: 1px dashed #cbd5e1; border-radius: 6px; padding: 8px; font-size: 12.5px; color: #1d4ed8; text-align: left;">
• 實體類別與資料型別<br>
• 關聯重數與基數限制<br>
• 聚合 (◇) 與組合 (◆)
</div>
</div>

<div style="display: flex; flex-direction: column; justify-content: space-around; align-items: center; width: 24px; font-size: 20px; color: #3b82f6; font-weight: bold;">
<div>→</div>
<div>→</div>
<div>→</div>
</div>

<div style="flex: 64%; display: flex; flex-direction: column; gap: 8px;">
<div class="card" style="padding: 10px 14px; background: #ffffff; border-left: 4px solid #0284c7; border-radius: 6px;">
<div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 3px;">
<h4 style="margin: 0; font-size: 15.5px; color: #0b3c5d;">4.3 使用案例模型 (功能合約)</h4>
<span style="background: #e0f2fe; color: #0369a1; font-size: 11.5px; font-weight: 600; padding: 1px 6px; border-radius: 4px;">實體資料載體</span>
</div>
<p style="font-size: 13px; line-height: 1.35; color: #475569; margin: 0;">
        類別模型提供持久化資料結構與領域實體，支撐使用案例流程中各步驟的資料儲存與狀態維護。
</p>
</div>
<div class="card" style="padding: 10px 14px; background: #ffffff; border-left: 4px solid #8b5cf6; border-radius: 6px;">
<div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 3px;">
<h4 style="margin: 0; font-size: 15.5px; color: #0b3c5d;">4.5 互動循序圖 (動態交互)</h4>
<span style="background: #f5f3ff; color: #6d28d9; font-size: 11.5px; font-weight: 600; padding: 1px 6px; border-radius: 4px;">生命線型別與 API</span>
</div>
<p style="font-size: 13px; line-height: 1.35; color: #475569; margin: 0;">
        類別模型定義了循序圖中各個生命線物件的所屬型別，並嚴格限制水平訊息呼叫必須對應類別中的合法方法簽章。
</p>
</div>
<div class="card" style="padding: 10px 14px; background: #ffffff; border-left: 4px solid #10b981; border-radius: 6px;">
<div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 3px;">
<h4 style="margin: 0; font-size: 15.5px; color: #0b3c5d;">4.6 有限狀態機 (生命週期)</h4>
<span style="background: #ecfdf5; color: #047857; font-size: 11.5px; font-weight: 600; padding: 1px 6px; border-radius: 4px;">內部狀態空間</span>
</div>
<p style="font-size: 13px; line-height: 1.35; color: #475569; margin: 0;">
        狀態機深入刻畫類別圖中特定實體類別（如 FoodOrder）的內部狀態變遷；狀態機的屬性即直接對應類別的 status 列舉或 State Pattern。
</p>
</div>
</div>
</div>
---
### 觀念檢核測驗 4 (CCQ 4)
<div class="ccq-columns">
<div class="ccq-text">

在美食外送類別圖中，為何「訂單 (Order)」與「訂單明細 (OrderItem)」之間採用**組合 (`◆`)**，而「外送任務 (DeliveryTask)」與「外送員 (Courier)」之間卻採用**聚合 (`◇`)**？

- **A.** 訂單明細可脫離訂單獨立存在；但外送員失去任務就無法存活。
- **B.** 訂單明細隨訂單銷毀而連帶消失；外送員則具備完全獨立的生命週期。
- **C.** 組合代表類別層級的繼承；聚合代表執行時的方法調用。
- **D.** 組合強制規定零對一重數；聚合強制規定一對多重數。

</div>
<div class="ccq-logo">
<img src="../../img/ch05/question_icon.svg" alt="Question Icon" style="max-width: 140px;" />
</div>
</div>

<!--
讓我們透過觀念測驗 4 來檢核對物件生命週期耦合的理解。

檢視各選項：
選項 A 完全顛倒了兩者的生命週期。
選項 C 混淆了整體與部分關聯與類別繼承。
選項 D 混淆了重數與關聯種類。

正確答案是 B！`OrderItem` 在商業邏輯上無法脫離父層 `Order` 獨立存在——訂單被刪除，明細必然連帶銷毀（組合）。相反地，外送員是獨立個體，任務完成或取消都不影響外送員的存在（聚合）。

總結這張投影片，請記住這個核心觀念：組合將組件生命週期與父層緊密綁定，而聚合則保有組件獨立的生命週期。
-->
---
<!-- _class: lead -->
<!-- header: '4.5 互動塑模與循序圖' -->

# **4.5 互動塑模與循序圖**

> "Interaction modeling shows how objects collaborate over time to fulfill the promise of a use case."  
> *(互動塑模展示了物件如何在時間維度上協同運作，以實現使用案例的承諾。)*

<!--
現在推進到 4.4 節：動態互動塑模與循序圖（Sequence Diagrams）。

如果說使用案例規格書是用表格文字描繪流程，那麼真實軟體世界則是由記憶體與網路中相互傳遞訊息的協同物件所驅動。

在此節中，我們將學習 UML 循序圖，追蹤美食外送的結帳訊息流，並掌握經典的邊界-控制-實體（BCE）架構模式。

總結這張投影片，請記住這個核心觀念：循序圖沿著時間軸精確刻畫參與物件之間的訊息互動傳遞。
-->
---
## 循序圖塑模：核心定義與工程價值

> 「互動塑模揭示了物件實例如何在執行時序中緊密協同，共同履行使用案例的行為承諾。」

<div class="two-columns">
<div class="card" data-marpit-fragment>
<h3>何謂循序圖模型 (Definition & Abstraction)</h3>
<ul>
<li><b>時間順序訊息流動：</b> 二維動態互動模型，水平軸排列參與物件生命線，垂直軸由上而下代表時序推移。</li>
<li><b>顯性化訊息語意：</b> 清楚呈現同步呼叫 (Synchronous)、非同步訊息 (Asynchronous)、回傳值與物件啟動條長度。</li>
<li><b>結構化控制邏輯：</b> 透過標準化複合片段 (Combined Fragments 如 <code>alt</code>、<code>opt</code>、<code>loop</code>) 表達條件分支與迴圈。</li>
</ul>
</div>
<div class="card" data-marpit-fragment>
<h3>為何至關重要 (Engineering Value)</h3>
<ul>
<li><b>揭示動態執行協同機制：</b> 類別圖只呈現「誰認識誰」，循序圖明確解答「誰在何時呼叫誰、等待多久、傳遞何種參數」。</li>
<li><b>驗證架構分層與責任分配：</b> 實踐 BCE 穩健性架構模式（邊界、控制、實體），杜絕 UI 與資料庫直接耦合的義大利麵代碼。</li>
<li><b>驗證通訊協定與並發邏輯：</b> 作為微服務分散式呼叫、網路逾時因應與多執行緒並發除錯的精確設計藍圖。</li>
</ul>
</div>
</div>

<!--
讓我們進入 4.5 節，探索循序圖 (Sequence Diagrams) 的本質與重要性。

首先，何謂循序圖：循序圖是一種動態互動模型。不同於靜態類別圖，循序圖擁有明確的時間維度，自上而下追蹤物件生命線之間如何透過訊息傳遞完成協同。

其次，為什麼它至關重要：光有類別圖無法證明系統能正常運作！循序圖驗證了物件之間如何協作以滿足特定的使用案例場景，更能落實 BCE 模式，確保架構分層清晰。

總結這張投影片，請記住這個核心觀念：循序圖精確捕捉特定場景下物件間隨時間流動的訊息交換與架構協調機制。
-->
---
## 循序圖塑模：四步標準工程流程

> 「循序圖塑模驗證了靜態類別結構是否具備足夠能力協同合作，順利實現動態業務情境。」

<div style="display: flex; align-items: stretch; justify-content: space-between; gap: 12px; margin-top: 14px;">
<div class="card" style="flex: 1; padding: 14px 12px; background: #ffffff; border-top: 4px solid #8b5cf6; border-radius: 8px;">
<div style="font-size: 13px; font-weight: 700; color: #8b5cf6; text-transform: uppercase;">步驟 1</div>
<h4 style="font-size: 16.5px; margin: 4px 0 6px 0; color: #0b3c5d;">鎖定情境腳本<br><span style="font-size: 12px; color: #64748b; font-weight: normal;">(From Use Case)</span></h4>
<ul style="font-size: 13px; line-height: 1.35; padding-left: 15px; margin: 0;">
<li>選定單一具體情境（正常主情境或特定例外分支）。</li>
<li>確定本次互動邊界。</li>
</ul>
</div>

<div style="display: flex; align-items: center; justify-content: center; font-size: 20px; color: #8b5cf6; font-weight: bold;">→</div>

<div class="card" style="flex: 1; padding: 14px 12px; background: #ffffff; border-top: 4px solid #7c3aed; border-radius: 8px;">
<div style="font-size: 13px; font-weight: 700; color: #7c3aed; text-transform: uppercase;">步驟 2</div>
<h4 style="font-size: 16.5px; margin: 4px 0 6px 0; color: #0b3c5d;">識別 BCE 生命線<br><span style="font-size: 12px; color: #64748b; font-weight: normal;">(Boundary-Control-Entity)</span></h4>
<ul style="font-size: 13px; line-height: 1.35; padding-left: 15px; margin: 0;">
<li>映射參與者、介面邊界、控制器與實體物件。</li>
<li>由左至右橫向展開。</li>
</ul>
</div>

<div style="display: flex; align-items: center; justify-content: center; font-size: 20px; color: #7c3aed; font-weight: bold;">→</div>

<div class="card" style="flex: 1; padding: 14px 12px; background: #ffffff; border-top: 4px solid #6d28d9; border-radius: 8px;">
<div style="font-size: 13px; font-weight: 700; color: #6d28d9; text-transform: uppercase;">步驟 3</div>
<h4 style="font-size: 16.5px; margin: 4px 0 6px 0; color: #0b3c5d;">繪製時序訊息<br><span style="font-size: 12px; color: #64748b; font-weight: normal;">(Top-Down Messaging)</span></h4>
<ul style="font-size: 13px; line-height: 1.35; padding-left: 15px; margin: 0;">
<li>由上而下標示時間流動。</li>
<li>區分同步 (→)、非同步 (->) 與回傳虛線 (-->)。</li>
</ul>
</div>

<div style="display: flex; align-items: center; justify-content: center; font-size: 20px; color: #6d28d9; font-weight: bold;">→</div>

<div class="card" style="flex: 1.1; padding: 14px 12px; background: #f5f3ff; border: 1.5px solid #8b5cf6; border-top: 4px solid #5b21b6; border-radius: 8px;">
<div style="font-size: 13px; font-weight: 800; color: #5b21b6; text-transform: uppercase;">步驟 4 ★ 控制邏輯</div>
<h4 style="font-size: 16.5px; margin: 4px 0 6px 0; color: #3b0764;">套用複合區塊<br><span style="font-size: 12px; color: #6d28d9; font-weight: normal;">(alt / opt / loop)</span></h4>
<ul style="font-size: 13px; line-height: 1.35; padding-left: 15px; margin: 0; color: #3b0764;">
<li><b>alt:</b> 互斥條件分支 (if-else)。</li>
<li><b>opt:</b> 滿足條件時執行的可選行為。</li>
<li><b>loop:</b> 對集合物件的重複迭代處理。</li>
</ul>
</div>
</div>

> 📌 **工程洞見：** 循序圖強制落實 **BCE 職責分離原則**——嚴格禁止 UI 介面邊界直接越權操作資料庫實體，必須經由 Controller 控制層協調調度。
---
<!-- _class: title-image-slide -->

## 訂單下單與支付流程：UML 循序圖

<div class="image-wrapper">
<img src="../../img/ch05/food_delivery_sequence.svg" alt="美食外送下單循序圖" />
</div>

<!--
請看這張「美食訂餐下單」情境的循序圖。

注意橫跨上方的各個參與物件：
最左側是人類顧客。
邊界物件：`CheckoutUI`。
業務邏輯協調者：`OrderController` 控制器。
外部金流介面：`PaymentGatewayAPI`。
實體物件：`Order` 與 `Restaurant`。
以及背景外送排程服務：`DispatchService`。

順著時間軸由上往下追蹤訊息：
1. 顧客點擊確認結帳。
2. UI 將請求委派給 OrderController。
3. 控制器進行內部購物車驗證。
4. 控制器呼叫外部 PaymentGatewayAPI 進行預扣授權。
5. 收到授權 Token 後，控制器在資料庫建立 Order 實體。
6. 控制器非同步通知餐廳並加入外送派單佇列。
7. 最後將確認結果與追蹤網址回傳給顧客。

總結這張投影片，請記住這個核心觀念：循序圖依時間順序清晰追蹤各架構元件之間的方法調用與訊息傳遞。
-->
---
## 循序訊息流動與 BCE 架構模式剖析

- **邊界–控制–實體 (BCE, Boundary–Control–Entity) 架構模式：**
  - **邊界物件 (`<<Boundary>>`)：** 負責與外部人類參與者及第三方 API 溝通（如 `CheckoutUI`、`PaymentGatewayAPI`）。
  - **控制物件 (`<<Control>>`)：** 協調交易流程、業務邏輯演算法與流程分派（如 `OrderController`、`DispatchService`）。
  - **實體物件 (`<<Entity>>`)：** 封裝持久化儲存的領域狀態與業務核心資料（如 `Order`、`Restaurant`）。
- **BCE 架構不可動搖的黃金鐵律：**
  - 外部使用者與 UI 邊界物件**絕不可直接碰觸或存取 Entity 資料實體物件**！
  - 呼叫流向必須嚴格遵守：**Actor &rarr; Boundary &rarr; Control &rarr; Entity**。
  - *原因：* 徹底實現介面與資料綱要的解耦。未來資料庫欄位或 ORM 變更時，UI 畫面完全不受波及。

<!--
請特別注意主導這張循序圖的核心設計模式：邊界-控制-實體（BCE）模式。

邊界物件位於外圍——負責渲染畫面或解析 JSON。
控制物件蘊含商業邏輯——協調驗證、分散式交易與派單排程。
實體物件則代表儲存在資料庫裡的領域核心資料。

這是一條軟體工程的鋼鐵紀律：前端 UI 絕對不能直接繞過控制器去讀寫資料庫實體！
如果你的網頁表單直接寫 SQL 存取資料表，就會寫出高耦合、極端難以維護的義大利麵程式碼。

總結這張投影片，請記住這個核心觀念：BCE 模式透過控制協調者，將使用者介面與底層持久化資料模型徹底解耦。
-->
---
## 循序圖符號與語意指引

| 視覺符號 | 語意符號名稱 | 精確技術語義 |
| :--- | :--- | :--- |
| **垂直虛線** | **生命線 (Lifeline)** | 代表該物件實例在記憶體中隨時間推移的存續狀態。 |
| **狹長垂直矩形** | **啟用條 (Activation Bar)** | 代表該物件實例正在 CPU 上積極執行程式碼運算的時間區間。 |
| **實線＋實心箭頭** | **同步呼叫 (Synchronous Call)** | 阻斷性呼叫（Blocking）；呼叫端暫停等待回傳結果後方能繼續。 |
| **實線＋開放箭頭** | **非同步訊息 (Asynchronous Call)** | 非阻斷性訊息（Non-blocking）；呼叫端送出訊息後立即繼續執行。 |
| **虛線＋開放箭頭** | **回傳訊息 (Return Message)** | 將運算結果或資料實例明確回傳給原始呼叫者。 |
| **自我迴圈箭頭** | **自身調用 (Self-Invocation)** | 物件呼叫自身的私有方法（例如 `validateCart()`）。 |

> 📌 **幾何黃金法則：** 時間沿著垂直軸嚴格**向下**推進。任何訊息箭頭絕對不可向上逆行！

<!--
複習 UML 循序圖的標準符號規範：

垂直虛線是生命線——代表物件存活在記憶體的時間。
細長矩形條是啟用條——代表物件正在積極執行指令。
實心三角箭頭代表同步呼叫，呼叫端會被阻塞等待。
開放刺狀箭頭代表非同步訊息，送出後不等待立刻往下走。
虛線箭頭則是運算完成後的資料回傳。

請看圖中步驟 3：`validateCart()` 彎回控制器自己，這就是經典的自身調用（Self-Invocation）。

總結這張投影片，請記住這個核心觀念：循序圖透過時間生命線，清楚區分了同步阻斷呼叫、非同步訊息與資料回傳。
-->
---
## 循序圖模型：與其他 UML 模型的協同關係

> 「循序圖扮演了動態轉譯的橋樑，將靜態的需求文字與類別定義，化為可執行的訊息調度流。」

<div style="display: flex; gap: 16px; align-items: stretch; margin-top: 14px;">
<div class="card" style="flex: 32%; background: #f8fafc; border: 2px solid #8b5cf6; border-radius: 8px; padding: 16px 14px; display: flex; flex-direction: column; justify-content: center; text-align: center;">
<div style="background: #8b5cf6; color: #ffffff; font-weight: 700; font-size: 12px; padding: 3px 8px; border-radius: 4px; display: inline-block; margin: 0 auto 8px auto;">動態互動核心</div>
<h3 style="margin: 0 0 6px 0; color: #0b3c5d; font-size: 19px;">4.5 互動循序圖</h3>
<p style="font-size: 13.5px; line-height: 1.4; color: #334155; margin: 0 0 10px 0;">跨物件實例的時間序列訊息交換與控制轉移。</p>
<div style="background: #ffffff; border: 1px dashed #cbd5e1; border-radius: 6px; padding: 8px; font-size: 12.5px; color: #6d28d9; text-align: left;">
• BCE 生命線與啟動條<br>
• 同步與非同步呼叫<br>
• 複合區塊 (alt / loop)
</div>
</div>

<div style="display: flex; flex-direction: column; justify-content: space-around; align-items: center; width: 24px; font-size: 20px; color: #8b5cf6; font-weight: bold;">
<div>→</div>
<div>→</div>
<div>→</div>
</div>

<div style="flex: 64%; display: flex; flex-direction: column; gap: 8px;">
<div class="card" style="padding: 10px 14px; background: #ffffff; border-left: 4px solid #0284c7; border-radius: 6px;">
<div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 3px;">
<h4 style="margin: 0; font-size: 15.5px; color: #0b3c5d;">4.3 使用案例模型 (功能需求)</h4>
<span style="background: #e0f2fe; color: #0369a1; font-size: 11.5px; font-weight: 600; padding: 1px 6px; border-radius: 4px;">場景動態實現</span>
</div>
<p style="font-size: 13px; line-height: 1.35; color: #475569; margin: 0;">
        直接實現使用案例規格書中的文字對話步驟，證明整個系統架構能端到端滿足使用者的業務目標。
</p>
</div>
<div class="card" style="padding: 10px 14px; background: #ffffff; border-left: 4px solid #3b82f6; border-radius: 6px;">
<div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 3px;">
<h4 style="margin: 0; font-size: 15.5px; color: #0b3c5d;">4.4 領域類別模型 (結構定義)</h4>
<span style="background: #eff6ff; color: #1d4ed8; font-size: 11.5px; font-weight: 600; padding: 1px 6px; border-radius: 4px;">方法合法性檢核</span>
</div>
<p style="font-size: 13px; line-height: 1.35; color: #475569; margin: 0;">
        每一條水平訊息皆直接檢驗或反哺接收類別的方法簽章 (Method Signatures)，確保職責分配合理。
</p>
</div>
<div class="card" style="padding: 10px 14px; background: #ffffff; border-left: 4px solid #10b981; border-radius: 6px;">
<div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 3px;">
<h4 style="margin: 0; font-size: 15.5px; color: #0b3c5d;">4.6 有限狀態機 (生命週期)</h4>
<span style="background: #ecfdf5; color: #047857; font-size: 11.5px; font-weight: 600; padding: 1px 6px; border-radius: 4px;">觸發事件派遣</span>
</div>
<p style="font-size: 13px; line-height: 1.35; color: #475569; margin: 0;">
        抵達實體生命線的特定訊息（如 processPayment()），正是激發狀態機產生狀態躍遷的事件觸發源。
</p>
</div>
</div>
</div>
---
### 觀念檢核測驗 5 (CCQ 5)
<div class="ccq-columns">
<div class="ccq-text">

在採用 **邊界–控制–實體 (BCE)** 架構設計的 UML 循序圖中，當使用者於 `CheckoutUI` 點擊結帳送出時，該請求應該直接交由哪一個物件接收處理？

- **A.** 直接交給 `Order` 實體物件，以便第一時間將訂單寫入資料庫。
- **B.** 直接交給 `PaymentGatewayAPI` 邊界物件，以便立刻進行信用卡扣款。
- **C.** 交給 `OrderController` 控制物件，以統籌驗證業務規則與協調交易。
- **D.** 直接交給 `Restaurant` 實體物件，以確認廚房產能是否充足。

</div>
<div class="ccq-logo">
<img src="../../img/ch05/question_icon.svg" alt="Question Icon" style="max-width: 140px;" />
</div>
</div>

<!--
讓我們透過觀念測驗 3 檢核對 BCE 架構的掌握度。

分析選項：
選項 A 嚴重違反 BCE 原則：UI 絕不能直接跨層操縱 Entity 資料實體！
選項 B 繞過了內部驗證直接呼叫外部收費 API，容易產生幽靈帳單。
選項 D 讓前端畫面直接綁定特定的領域實體，造成高度耦合。

正確答案是 C！`OrderController` 作為控制物件，負責承接請求、驗證購物車商品、協調外部扣款並處理資料庫持久化。

總結這張投影片，請記住這個核心觀念：控制物件在 UI 邊界與資料實體之間擔任中介，負責落實商業規則與流程協調。
-->
---
<!-- _class: lead -->
<!-- header: '4.6 行為塑模與狀態機' -->

# **4.6 行為塑模與有限狀態機模型**

> "A system in dynamic execution is defined by the states it occupies and the events that trigger transitions."  
> *(動態執行中的系統，是由其所處的狀態以及觸發狀態轉換的事件所定義。)*

<!--
我們接著進入 4.6 節：行為塑模與狀態機模型（State Machine Diagrams）。

類別圖展現靜態結構，循序圖描繪單一場景的互動，但是對於反應式系統——例如自駕車控制、醫療輸液幫浦，以及外送訂單的生命週期流轉——最好的塑模方式就是有限狀態機（FSM）。

讓我們看看一筆外送訂單如何在各個離散運作狀態之間切換。

總結這張投影片，請記住這個核心觀念：狀態機塑模了反應式系統如何針對外在事件，在離散運作狀態之間依序轉換。
-->
---
## 狀態機塑模：核心定義與工程價值

> 「運作中的反應型系統，取決於其所處的離散狀態，以及激發狀態合法躍遷的事件驅動機制。」

<div class="two-columns">
<div class="card" data-marpit-fragment>
<h3>何謂狀態機模型 (Definition & Abstraction)</h3>
<ul>
<li><b>離散事件驅動模型：</b> 源自 David Harel 的 Statecharts 理論，刻畫單一反應型實體在整個生命週期中如何回應外部事件。</li>
<li><b>狀態分類學：</b> 包含初態 (Initial)、終態 (Final) 及滿足特定商業不變量的穩定運作狀態。</li>
<li><b>轉換語法嚴謹規範：</b> 透過 <code>觸發事件 [守衛條件] / 動作效果</code> 形式化宣告狀態躍遷機制。</li>
</ul>
</div>
<div class="card" data-marpit-fragment>
<h3>為何至關重要 (Engineering Value)</h3>
<ul>
<li><b>徹底消除非法業務狀態：</b> 從數學與架構層面杜絕「未付款卻已出貨」、「已取消訂單卻重複退款」等重大業務漏洞。</li>
<li><b>馴服非同步事件的複雜度：</b> 在電商訂單、IoT 設備與長時間工作流中，提供具備確定性與可預測性的可靠行為保障。</li>
<li><b>確立明確的執行防衛線：</b> 嚴格的守衛條件 <code>[Guard]</code> 保證狀態躍遷只在業務不變量完全成立時才被放行。</li>
</ul>
</div>
</div>

<!--
讓我們進入 4.6 節，探討有限狀態機模型 (State Machine Diagrams) 的本質與重要性。

首先，何謂狀態機：狀態機聚焦於單一物件在其完整生命週期中的反應行為。基於 David Harel 的理論，它定義了物件所處的離散狀態以及狀態之間合法的轉換路徑。

其次，為什麼它至關重要：在現代複雜系統中，非法的狀態躍遷往往導致毀滅性的業務漏洞。例如外送員已取餐，系統卻還能允許用戶一鍵取消？狀態機在架構層面封死了所有非法的轉換，保障業務語意完整性。

總結這張投影片，請記住這個核心觀念：狀態機透過嚴謹的事件驅動模型，守護領域實體的生命週期完整性，杜絕非法狀態躍遷。
-->
---
## 狀態機塑模：四步標準工程流程

> 「狀態機塑模從數學上杜絕了系統非法狀態的發生，並能有效駕馭非同步事件的複雜度。」

<div style="display: flex; align-items: stretch; justify-content: space-between; gap: 12px; margin-top: 14px;">
<div class="card" style="flex: 1; padding: 14px 12px; background: #ffffff; border-top: 4px solid #10b981; border-radius: 8px;">
<div style="font-size: 13px; font-weight: 700; color: #10b981; text-transform: uppercase;">步驟 1</div>
<h4 style="font-size: 16.5px; margin: 4px 0 6px 0; color: #0b3c5d;">鎖定核心實體<br><span style="font-size: 12px; color: #64748b; font-weight: normal;">(Stateful Lifecycle)</span></h4>
<ul style="font-size: 13px; line-height: 1.35; padding-left: 15px; margin: 0;">
<li>挑選具備多階段生命週期的關鍵類別（如 FoodOrder）。</li>
<li>排除無狀態實體。</li>
</ul>
</div>

<div style="display: flex; align-items: center; justify-content: center; font-size: 20px; color: #10b981; font-weight: bold;">→</div>

<div class="card" style="flex: 1; padding: 14px 12px; background: #ffffff; border-top: 4px solid #059669; border-radius: 8px;">
<div style="font-size: 13px; font-weight: 700; color: #059669; text-transform: uppercase;">步驟 2</div>
<h4 style="font-size: 16.5px; margin: 4px 0 6px 0; color: #0b3c5d;">列舉合法狀態<br><span style="font-size: 12px; color: #64748b; font-weight: normal;">(Stable Conditions)</span></h4>
<ul style="font-size: 13px; line-height: 1.35; padding-left: 15px; margin: 0;">
<li>盤點所有穩定靜止狀態：草稿、已付款、製餐中、已送達。</li>
<li>標定起始與終止端點。</li>
</ul>
</div>

<div style="display: flex; align-items: center; justify-content: center; font-size: 20px; color: #059669; font-weight: bold;">→</div>

<div class="card" style="flex: 1; padding: 14px 12px; background: #ffffff; border-top: 4px solid #047857; border-radius: 8px;">
<div style="font-size: 13px; font-weight: 700; color: #047857; text-transform: uppercase;">步驟 3</div>
<h4 style="font-size: 16.5px; margin: 4px 0 6px 0; color: #0b3c5d;">繪製事件跳轉<br><span style="font-size: 12px; color: #64748b; font-weight: normal;">(Event Triggers)</span></h4>
<ul style="font-size: 13px; line-height: 1.35; padding-left: 15px; margin: 0;">
<li>繪製狀態間的單向躍遷箭頭路徑。</li>
<li>標註觸發躍遷的外部業務事件。</li>
</ul>
</div>

<div style="display: flex; align-items: center; justify-content: center; font-size: 20px; color: #047857; font-weight: bold;">→</div>

<div class="card" style="flex: 1.1; padding: 14px 12px; background: #ecfdf5; border: 1.5px solid #10b981; border-top: 4px solid #065f46; border-radius: 8px;">
<div style="font-size: 13px; font-weight: 800; color: #065f46; text-transform: uppercase;">步驟 4 ★ 躍遷文法</div>
<h4 style="font-size: 16.5px; margin: 4px 0 6px 0; color: #064e3b;">守衛與動作效果<br><span style="font-size: 12px; color: #047857; font-weight: normal;">([guard] / action)</span></h4>
<ul style="font-size: 13px; line-height: 1.35; padding-left: 15px; margin: 0; color: #064e3b;">
<li><b>[guard]:</b> 必須滿足的布林條件門檻。</li>
<li><b>/ action:</b> 躍遷時執行的原子副作用。</li>
<li><b>標準語法：</b> <code>event [guard] / action</code>。</li>
</ul>
</div>
</div>

> 📌 **工程洞見：** 狀態機在數學邏輯上消滅了非法狀態（如未付款直接出貨），將混亂的巢狀 `if-else` 與 Flag 標記轉化為嚴謹可驗證的狀態模式。
---
<!-- _class: title-image-slide -->

## 訂單生命週期：UML 狀態機圖 (State Machine Diagram)

<div class="image-wrapper">
<img src="../../img/ch05/food_delivery_state.svg" alt="訂單生命週期狀態機圖" />
</div>

<!--
請看這張塑模訂單完整生命週期的 UML 狀態機圖。

注意標準記號：
上方實心黑圓是起始狀態（Initial State）。
圓角矩形代表各個離散狀態：`Placed (已下單)`、`Accepted (已接單)`、`Preparing (備餐中)`、`ReadyForPickup (待取餐)`、`OutForDelivery (配送中)`、`Delivered (已送達)`，以及 `Cancelled (已取消)`。
同心雙圓（牛眼圓）代表結束終止狀態。

注意連接狀態之間的箭頭：這些是狀態轉換（Transitions）。
上面的標註遵循經典 UML 文法：`觸發事件 [守衛條件] / 執行動作`。
例如，在 `Placed` 狀態下，若發生 `restaurantAccepts() [within 5 min]`，則轉移至 `Accepted` 並執行 `/ lockOrder()`。
若顧客在兩分鐘內取消，則轉移至 `Cancelled` 並執行 `/ refundCharge()`。

總結這張投影片，請記住這個核心觀念：狀態機透過事件觸發、守衛條件與轉換動作，精確規範系統的離散狀態演變。
-->
---
## 狀態圖運作原理與轉換文法解析

- **有限狀態機 (FSM) 核心原理：**
  - 在任何單一運行瞬間，一個 `Order` 物件實例**恰好且只能處於一個**離散狀態。
  - 訂單對外界事件的反應，完全取決於其**當前所處的活躍狀態**。
- **標準狀態轉換標籤文法 (Formal Label Grammar)：**
  $$\text{觸發事件 (Event)} \; [\text{守衛條件 (Guard)}] \; / \; \text{執行動作 (Action)}$$
  - **觸發事件 (Trigger Event)：** 刺激狀態轉移的外部或內部事件（如 `chefStartsCooking()`, `courierScansPickup()`）。
  - **守衛條件 (`[...]` Guard Condition)：** 必須計算為 `true` 轉換才會被放行的布林條件（如 `[within 5 min]`, `[time < 2 min]`）。
  - **執行動作 (`/ ...` Action Effect)：** 狀態轉移瞬間原子化執行的計算動作（如 `/ refundCharge()`, `/ startLiveGPSTracking()`）。
- **狀態進入動作 (State Entry Actions)：**
  - 進入特定狀態時自動執行的動作（例如：`Placed: Entry / startRestaurantAcceptTimer()`）。

<!--
深入剖析狀態機對分散式交易系統的重大價值：

想像一筆訂單已經進入 `OutForDelivery (配送中)` 狀態，此時顧客在手機上猛按「取消訂單」會怎樣？
因為在狀態機上，從 `OutForDelivery` **根本沒有任何一條箭頭**可以通往 `Cancelled`，系統在架構層級就能直接安全拒絕取消請求！外送員已經在路上，絕不允許隨意取消。

再看中括號裡的守衛條件：在 `Placed` 狀態，顧客只有在 `[time < 2 min]` 條件下才能取消；超過兩分鐘，守衛條件評估為 false，取消通道直接封鎖！

狀態機徹底杜絕了分散式系統中的非法狀態轉移。

總結這張投影片，請記住這個核心觀念：狀態機透過事件觸發、布林守衛條件與原子動作，在架構層級杜絕非法商業狀態轉移。
-->
---
## 有限狀態機：與其他 UML 模型的協同關係

> 「有限狀態機統攝了領域實體的生命週期完整性，並在全系統層面守衛商業不變量。」

<div style="display: flex; gap: 16px; align-items: stretch; margin-top: 14px;">
<div class="card" style="flex: 32%; background: #f8fafc; border: 2px solid #10b981; border-radius: 8px; padding: 16px 14px; display: flex; flex-direction: column; justify-content: center; text-align: center;">
<div style="background: #10b981; color: #ffffff; font-weight: 700; font-size: 12px; padding: 3px 8px; border-radius: 4px; display: inline-block; margin: 0 auto 8px auto;">生命週期守護者</div>
<h3 style="margin: 0 0 6px 0; color: #0b3c5d; font-size: 19px;">4.6 有限狀態機</h3>
<p style="font-size: 13.5px; line-height: 1.4; color: #334155; margin: 0 0 10px 0;">複雜領域實體隨時間與事件演進的離散生命週期規則。</p>
<div style="background: #ffffff; border: 1px dashed #cbd5e1; border-radius: 6px; padding: 8px; font-size: 12.5px; color: #047857; text-align: left;">
• 合法穩定靜止狀態<br>
• 外部事件觸發與信號<br>
• 守衛條件與動作效果
</div>
</div>

<div style="display: flex; flex-direction: column; justify-content: space-around; align-items: center; width: 24px; font-size: 20px; color: #10b981; font-weight: bold;">
<div>→</div>
<div>→</div>
<div>→</div>
</div>

<div style="flex: 64%; display: flex; flex-direction: column; gap: 8px;">
<div class="card" style="padding: 10px 14px; background: #ffffff; border-left: 4px solid #0284c7; border-radius: 6px;">
<div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 3px;">
<h4 style="margin: 0; font-size: 15.5px; color: #0b3c5d;">4.3 使用案例模型 (功能合約)</h4>
<span style="background: #e0f2fe; color: #0369a1; font-size: 11.5px; font-weight: 600; padding: 1px 6px; border-radius: 4px;">前置條件守衛門檻</span>
</div>
<p style="font-size: 13px; line-height: 1.35; color: #475569; margin: 0;">
        實體的當前狀態直接作為使用案例能否被觸發執行的前置守衛門檻（如只有在已付款或備餐中狀態，才允許執行「取消訂單」案例）。
</p>
</div>
<div class="card" style="padding: 10px 14px; background: #ffffff; border-left: 4px solid #3b82f6; border-radius: 6px;">
<div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 3px;">
<h4 style="margin: 0; font-size: 15.5px; color: #0b3c5d;">4.4 領域類別模型 (結構定義)</h4>
<span style="background: #eff6ff; color: #1d4ed8; font-size: 11.5px; font-weight: 600; padding: 1px 6px; border-radius: 4px;">狀態模式實作</span>
</div>
<p style="font-size: 13px; line-height: 1.35; color: #475569; margin: 0;">
        狀態機深入描繪類別圖中特定實體類別的動態演變，直接對應 OOP 中的 GoF 狀態模式 (State Pattern) 或列舉變數。
</p>
</div>
<div class="card" style="padding: 10px 14px; background: #ffffff; border-left: 4px solid #8b5cf6; border-radius: 6px;">
<div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 3px;">
<h4 style="margin: 0; font-size: 15.5px; color: #0b3c5d;">4.5 互動循序圖 (動態交互)</h4>
<span style="background: #f5f3ff; color: #6d28d9; font-size: 11.5px; font-weight: 600; padding: 1px 6px; border-radius: 4px;">事件來源與動作效果</span>
</div>
<p style="font-size: 13px; line-height: 1.35; color: #475569; margin: 0;">
        循序圖中傳入實體生命線的訊息激發了狀態機的狀態躍遷；而躍遷伴隨的動作效果則體現為循序圖後續的呼叫返回。
</p>
</div>
</div>
</div>
---
### 觀念檢核測驗 6 (CCQ 6)
<div class="ccq-columns">
<div class="ccq-text">

在訂單生命週期狀態機中，標籤 `customerCancels() [time < 2 min] / refundCharge()` 各自代表何種技術語義？

- **A.** `customerCancels()` 為守衛條件；`[time < 2 min]` 為觸發事件；`refundCharge()` 為目標狀態。
- **B.** `customerCancels()` 為觸發事件；`[time < 2 min]` 為布林守衛條件；`refundCharge()` 為轉換執行動作。
- **C.** `customerCancels()` 為目標類別；`[time < 2 min]` 為呼叫方法；`refundCharge()` 為傳回型別。
- **D.** `customerCancels()` 為主要參與者；`[time < 2 min]` 為逾時限制；`refundCharge()` 為物件生命線。

</div>
<div class="ccq-logo">
<img src="../../img/ch05/question_icon.svg" alt="Question Icon" style="max-width: 140px;" />
</div>
</div>

<!--
讓我們透過觀念測驗 5 驗證對狀態機標籤語法的掌握。

檢視選項：
選項 A 完全調換了定義。
選項 C 誤用類別圖名詞解釋狀態圖。
選項 D 混入了循序圖的參與者與生命線名詞。

正確答案是 B！`customerCancels()` 是觸發事件，`[time < 2 min]` 是必須成立的布林守衛條件，而 `/ refundCharge()` 則是在狀態轉移時觸發的原子執行動作。

總結這張投影片，請記住這個核心觀念：UML 狀態機轉換嚴格遵循「事件 [守衛條件] / 動作」的標準文法。
-->
---
<!-- _class: lead -->
<!-- header: '4.7 AI 輔助系統塑模' -->

# **4.7 AI 輔助系統塑模**

> "AI is a visual copilot that eliminates diagramming friction, but human architects must ensure semantic correctness."  
> *(AI 是一具消除繪圖阻力的視覺副駕駛，但人類架構師必須確保語意的終極正確性。)*

<!--
現在我們來到現代軟體工程的最前線：4.7 節 AI 輔助系統塑模。

過去幾十年來，開發者對 UML 最大的抱怨之一，就是必須在厚重的塑模軟體裡痛苦地拖拉矩形、調整箭頭對齊、維護不相容的二進位檔案。

有了大型語言模型（LLM），這道阻力徹底煙消雲散。LLM 極度擅長將自然語言規格轉譯為 PlantUML 或 Mermaid 等宣告式文字圖表。在此節中，我們將探討 AI 塑模應用與人機協同防護。

總結這張投影片，請記住這個核心觀念：AI 工具消除了繪圖排版阻力，但架構師必須嚴格把關語意與架構邊界。
-->
---
## AI 在系統塑模中的角色：視覺副駕駛 (Visual Copilot)

- **宣告式繪圖革命 (Text-to-Diagram Revolution)：**
  - 大型語言模型能直接將非結構化軟體需求轉譯為**宣告式文字標記圖表**（如 PlantUML、Mermaid.js、Graphviz）。
  - 在數秒內架起自然語言使用者故事與正式圖形架構模型之間的橋樑。

<div style="text-align: center; margin-top: 15px;">
<img src="../../img/ch05/ai_in_system_modeling.svg" style="max-height: 280px; width: auto;" alt="AI 輔助系統塑模工作流程" />
</div>

- **生產力的大幅躍升：** 徹底消除惱人的手動排版微調，讓軟體架構師能全神貫注於架構邏輯推理，而非繪圖軟體排版。

<!--
生成式 AI 為軟體塑模掀起了一場徹底的解放革命。

過去在 Visio 或 Rational Rose 裡拉箭頭拉到手酸的日子已經結束。現在，你可以將 Jira Ticket 或使用者故事餵給 Claude 或 ChatGPT，指令：「請產生美食結帳的 PlantUML 循序圖，包含金流閘道」。三秒鐘內，乾淨無暇的標記語法就躍然眼前，並能立即編譯成精美向量圖！

這徹底消除了格式摩擦，讓團隊在衝刺規劃（Sprint Planning）時能極速視覺化各種架構替代方案。

總結這張投影片，請記住這個核心觀念：AI 驅動的 Text-to-UML 技術大幅加速了架構視覺化與敏捷文件的迭代效率。
-->
---
## AI 在系統塑模中的 4 大核心應用

- **1. 文字直接生成 UML (Text-to-UML Generation)：**
  - 直接根據敏捷使用者故事與 Given-When-Then 驗收準則，自動生成循序圖、類別圖與活動圖標記。
- **2. 領域實體智能萃取 (Domain Entity Extraction)：**
  - 深度語意分析規格需求書，智慧提煉領域名詞（潛在類別、屬性）與動詞（方法操作、關聯）。
- **3. 跨圖表一致性驗證 (Cross-Diagram Consistency Validation)：**
  - 比對檢查使用案例參與者、類別圖與循序圖生命線，偵測命名衝突或未被實作的方法呼叫。
- **4. 程式碼逆向工程塑模 (Code-to-Model Reverse Engineering)：**
  - 讀取現有專案程式碼庫（Java/TypeScript/Python），自動逆向產出類別階層與相依圖，加速新進人員上手。

<!--
歸納今日 AI 在系統塑模領域的四大實務落地應用：

第一，文字轉 UML：需求文字直接轉譯為 Mermaid 或 PlantUML。
第二，領域實體萃取：從數十頁的合約需求書中自動提煉出核心實體名詞與操作動詞。
第三，跨圖表一致性檢查：檢查模型是否存在矛盾——例如循序圖呼叫了一個類別圖上根本沒宣告的方法！
第四，程式碼逆向塑模：接手陌生大型開源專案時，讓 AI 快速掃描並畫出架構圖，幫工程師省下數天摸索時間。

總結這張投影片，請記住這個核心觀念：AI 透過自動草擬、實體萃取、一致性驗證與逆向工程，全方位賦能塑模工作。
-->
---
## 人機協同防護：AI 塑模風險與最佳實踐

- **未經審查即盲信 AI 塑模的潛在風險：**
  - **虛構關聯 (Hallucinated Associations)：** 幻覺捏造出不存在於業務真實世界中的繼承或組合關聯。
  - **架構過度膨脹 (Architectural Bloat)：** 硬塞不必要的設計模式（如動輒套用十層工廠裝飾者），違背簡潔原則。
  - **幽靈生命線 (Ghost Lifelines)：** 在循序圖中憑空捏造不存在的微服務 API 或網路端點。
- **不可動搖的軟體工程黃金守則：**
  > **「AI 負責起草繪圖；人類架構師負責檢驗語意！」**  
  > *(AI Drafts the Diagram; The Human Architect Validates the Semantics!)*  
  > 軟體架構師必須以批判性工程眼光審視 AI 生成的模型，確保其忠實反映領域真相與架構邊界。

<!--
與需求工程一樣，未經人工驗證的 AI 塑模伴隨著極大風險。

大型語言模型經常患有「設計模式狂熱症」——明明一個簡單類別就能搞定的功能，AI 偏偏要幫你生出 AbstractFactoryDecoratorManager。它也可能產生關聯幻覺，憑空捏造出荒謬的繼承關係。

因此請牢記我們的黃金守則：AI 負責起草繪圖，人類架構師負責檢驗語意！

將 AI 產出的圖表視為快速初稿，永遠以專業批判的工程眼光審視它。

總結這張投影片，請記住這個核心觀念：人類架構師必須針對領域本質真相與架構簡潔性，主動驗證 AI 生成之模型。
-->
---
### 觀念檢核測驗 7 (CCQ 7)
<div class="ccq-columns">
<div class="ccq-text">

當軟體工程團隊導入生成式 AI 輔助自動化產生 UML 圖表時，軟體工程師／架構師最核心的職責為何？

- **A.** 拒絕使用任何 AI 工具，堅持純手動編寫每一行繪圖標記語法。
- **B.** 嚴格驗證領域業務語意正確性、結構約束條件與架構簡潔度。
- **C.** 全面廢除傳統程式碼審查（Code Review）與架構設計評審會議。
- **D.** 無條件全盤接受 AI 所生成的所有類別關聯與微服務生命線。

</div>
<div class="ccq-logo">
<img src="../../img/ch05/question_icon.svg" alt="Question Icon" style="max-width: 140px;" />
</div>
</div>

<!--
讓我們透過觀念測驗 6 來檢核對 AI 輔助塑模人機協同的理解。

使用 AI 生成 UML 時，工程師的核心定位是什麼？

審視選項：
選項 A 因噎廢食，放棄了現代工具的高效優勢。
選項 C 與 D 代表了對未經驗證 AI 產物的盲目危險依賴。

正確答案是 B！正如我們的黃金原則：「AI 負責起草繪圖，人類架構師負責檢驗語意」。工程師必須確保產出的模型忠實契合業務真實情況，並堅守架構簡潔性。

總結這張投影片，請記住這個核心觀念：人類架構師的核心使命，在於嚴格驗證 AI 生成圖表的語意正確性與架構簡潔性。
-->
---
<!-- _class: lead -->
<!-- header: '4.8 核心複習與參考文獻' -->

# **4.8 核心複習與統整**

> "Models are the lingua franca of software engineering."  
> *(模型，是軟體工程世界的通用語彙。)*

<!--
在第四章的尾聲，我們來到 4.8 節：核心複習與參考文獻。

我們將透過互動填空複習，全面鞏固今天所學的所有核心基石——從三巨頭歷史、環境邊界、使用案例契約，到 BCE 循序互動、領域類別圖與有限狀態機。

最後我們將回顧軟體塑模的經典學術文獻與國際標準。

總結這張投影片，請記住這個核心觀念：精通系統塑模，能賦予軟體工程師推導、溝通與驗證複雜軟體架構的強大能力。
-->
---
## 核心觀念統整：互動填空小測驗

測試你對本章核心概念的掌握度：

1. 在 Rational Software 整合並催生 UML 的「三巨頭」為 Grady Booch、Jim Rumbaugh 與 **`___`**。
2. **`___`** 圖用以劃定內部軟體系統與外部夥伴服務雲端之間的營運邊界。
3. 在使用案例塑模中，多個案例必定強制共用的子流程是透過 **`___`** 關係抽離。
4. 將系統劃分為使用者介面、商業邏輯協調與持久化實體的經典架構模式是 **`___`**。
5. 在 UML 類別圖中，實心黑菱形 (`◆`) 代表 **`___`**，子物件無法脫離父物件獨立存在。
6. 在 UML 類別圖中，空心白菱形 (`◇`) 代表 **`___`**，子物件具備完全獨立的生命週期。
7. UML 狀態機圖之狀態轉移標籤嚴格遵循標準語法：觸發事件 [**`___`**] / 執行動作。

<!--
讓我們透過快速互動測驗，盤點今天的學習成果！

1. 三巨頭是 Grady Booch、Jim Rumbaugh 與 Ivar Jacobson！
2. 環境圖（Context Diagram）用以劃定系統與外部夥伴的營運邊界！
3. 強制共用的子流程是透過 <<include>> 關係抽離！
4. 切分 UI、商業邏輯與資料實體的經典架構是 BCE 模式！
5. 實心菱形代表組合（Composition）！
6. 空心菱形代表聚合（Aggregation）！
7. 中括號中的是守衛條件（Guard Condition）！

全體同學表現非常優異！

總結這張投影片，請記住這個核心觀念：這些核心塑模概念構成了打造穩健物件導向軟體架構的堅固基石。
-->
---
## 經典文獻與延伸閱讀 (References)

- **奠基教科書與國際標準規範：**
  - Sommerville, I. (2016). *Software Engineering* (10th ed.). Chapter 5: System Modeling. Pearson.
  - Booch, G., Rumbaugh, J., & Jacobson, I. (2005). *The Unified Modeling Language User Guide* (2nd ed.). Addison-Wesley.
  - Fowler, M. (2003). *UML Distilled: A Brief Guide to the Standard Object Modeling Language* (3rd ed.). Addison-Wesley.
  - Cockburn, A. (2000). *Writing Effective Use Cases*. Addison-Wesley.
  - Object Management Group (OMG). (2017). *OMG Unified Modeling Language (OMG UML) Specification*, Version 2.5.1.
- **現代宣告式繪圖標準與 AI 塑模工具：**
  - PlantUML 開源標準官方網站：[plantuml.com](https://plantuml.com)
  - Mermaid.js JavaScript 宣告式繪圖文件庫：[mermaid.js.org](https://mermaid.js.org)

<!--
這裡是第四章的經典參考文獻、國際 OMG UML 官方規範，以及現代宣告式繪圖工具資源。

Grady Booch、Jim Rumbaugh 與 Ivar Jacobson 合著的《UML 使用者手冊》，以及 Martin Fowler 的《UML 精華》是不可錯過的永恆經典。Alistair Cockburn 的著作為撰寫高效使用案例立下了黃金標準。

若要實踐現代 Text-to-Diagram 與 AI 繪圖協作，強烈推薦深入研讀 PlantUML 與 Mermaid.js。

謝謝大家今天的投入參與！
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
