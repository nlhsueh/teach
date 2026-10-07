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

# **進階軟體工程 (Advanced Software Engineering)**
## 核心觀念自學測驗題庫 (Chapters 1–3)

> 「不聞不若聞之，聞之不若見之，見之不若知之，知之不若行之。」 —— 《荀子·儒效》

<div style="display: flex; justify-content: center; gap: 14px; margin-top: 24px;">
  <span class="quiz-tag" style="font-size: 14px; padding: 6px 16px;">📘 3 大核心章節</span>
  <span class="quiz-tag" style="font-size: 14px; padding: 6px 16px;">🎯 31 道經典觀念題</span>
  <span class="quiz-tag" style="font-size: 14px; padding: 6px 16px;">💡 即時檢測與詳解</span>
  <span class="quiz-tag" style="font-size: 14px; padding: 6px 16px;">⚡ 自主節奏隨選作答</span>
</div>

<!--
歡迎使用《進階軟體工程》核心觀念自學互動題庫！

本測驗集結了前三章（導論、開發流程與需求工程）共 31 道精選觀念檢測題 (CCQ)。

不同於課堂即時投票，本投影片專為學生課後自學與複習設計。在 HTML 互動簡報中，你可以隨時點選選項進行作答，系統將提供即時的答題反饋與深入的工程原理解析。

總結這張投影片，請記住這個核心觀念：主動檢測與回想是固化軟體工程思維模型最有效的方法。
-->

---
<!-- header: '自學測驗題庫 ▾ | 題項目錄與章節導覽' -->

## 知識地圖與章節單元導覽 (Table of Contents)

> 點選下方任一章節卡片即可直接跳轉作答；亦可於各題頁面點選右上角 Header 隨時展開題項目錄。

<div class="three-columns" style="margin-top: 15px;">

<div class="card">
  <h3 style="color: #0284c7; margin-bottom: 6px;">📘 第一章</h3>
  <h4 style="font-size: 15px; margin-bottom: 8px;">軟體工程導論</h4>
  <p style="font-size: 13px; color: #64748b; line-height: 1.4;">軟體危機、IEEE 定義、核心活動、布魯克斯法則、職責分離、ISO 25010、倫理與 AI 挑戰。</p>
  <ul style="font-size: 13.5px; line-height: 1.4; margin-top: 6px;">
    <li><strong>題數：</strong> 第 01 題 ～ 第 09 題 (共 9 題)</li>
    <li><strong>核心目標：</strong> 建立軟體工程思維基石</li>
  </ul>
  <div style="margin-top: 12px; text-align: center;">
    <a href="#4" class="btn-primary" style="display: inline-block; padding: 4px 14px; font-size: 13px; text-decoration: none; border-radius: 6px; background: #0284c7; color: #fff; font-weight: 700;">開始第一章測驗 ➔</a>
  </div>
</div>

<div class="card">
  <h3 style="color: #0284c7; margin-bottom: 6px;">⚙️ 第二章</h3>
  <h4 style="font-size: 15px; margin-bottom: 8px;">軟體開發流程</h4>
  <p style="font-size: 13px; color: #64748b; line-height: 1.4;">瀑布模型、V-模型、MVP、敏捷宣言、看板 WIP、Scrum、技術債、結對編程與 CI/CD。</p>
  <ul style="font-size: 13.5px; line-height: 1.4; margin-top: 6px;">
    <li><strong>題數：</strong> 第 10 題 ～ 第 23 題 (共 14 題)</li>
    <li><strong>核心目標：</strong> 掌握敏捷流程與工程實踐</li>
  </ul>
  <div style="margin-top: 12px; text-align: center;">
    <a href="#14" class="btn-primary" style="display: inline-block; padding: 4px 14px; font-size: 13px; text-decoration: none; border-radius: 6px; background: #0284c7; color: #fff; font-weight: 700;">開始第二章測驗 ➔</a>
  </div>
</div>

<div class="card">
  <h3 style="color: #0284c7; margin-bottom: 6px;">📋 第三章</h3>
  <h4 style="font-size: 15px; margin-bottom: 8px;">需求工程</h4>
  <p style="font-size: 13px; color: #64748b; line-height: 1.4;">使用者 vs 系統需求、領域需求、可量化 NFR、五個為什麼、內隱知識、使用案例與 AI 幻覺。</p>
  <ul style="font-size: 13.5px; line-height: 1.4; margin-top: 6px;">
    <li><strong>題數：</strong> 第 24 題 ～ 第 31 題 (共 8 題)</li>
    <li><strong>核心目標：</strong> 需求獲取、規格化與驗證</li>
  </ul>
  <div style="margin-top: 12px; text-align: center;">
    <a href="#29" class="btn-primary" style="display: inline-block; padding: 4px 14px; font-size: 13px; text-decoration: none; border-radius: 6px; background: #0284c7; color: #fff; font-weight: 700;">開始第三章測驗 ➔</a>
  </div>
</div>

</div>

<!--
這裡是全部 31 道題目的總覽地圖。

你可以依序從第 1 題作答至第 31 題，也可以透過上方的卡片直接跳入特定章節。

請留意右上角的頁首標題（Header）帶有互動下拉選單。在測驗的任何時候點選或滑過它，都能隨時展開完整題庫矩陣，自由跳轉到任何一題。

總結這張投影片，請記住這個核心觀念：根據自己的學習進度靈活調配複習重點，針對較不熟悉的領域進行深度檢驗。
-->

---
<!-- _class: lead -->
<!-- header: '第一章 軟體工程導論 | 章節導讀 ▾' -->

# **第一章 軟體工程導論**
## 基礎觀念、本質複雜度、專業倫理與 AI 衝擊

> 「軟體危機的根本原因，在於我們嘗試建造超越人類智力掌握極限的巨大軟體系統。」 —— 艾茲赫爾·戴克斯特拉 (Edsger W. Dijkstra)

<!--
進入第一章：軟體工程導論。

本單元包含 9 道觀念檢測題，檢驗你對軟體本質、危機成因、核心活動與專業倫理的掌握。

請仔細閱讀題目情境，點選選項或使用鍵盤快速鍵作答，並研讀解析確認思維模型是否正確。

總結這張投影片，請記住這個核心觀念：在點擊答案前先進行批判性思考，確認自己能清楚說出為什麼其他選項是錯誤的。
-->

---
<!-- header: '第 1 章 | 第 01 題 / 共 31 題 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 1. 軟體工程導論 · 第 01 題</span>
    <span class="quiz-prog">單元：軟體危機與複雜度</span>
  </div>

  <div class="quiz-qbox">
    為什麼 1968 年的「軟體危機」無法單純透過購買運算速度更快、記憶體容量更大的電腦硬體來解決？
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="false">
      <span class="q-badge">A</span>
      <span class="q-text">1960 年代末期電腦硬體製造與記憶體製程完全停滯，無法提供實質的運算效能提升。</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="true">
      <span class="q-badge">B</span>
      <span class="q-text">危機本質上是系統規模與智力管理帶來的組織複雜度挑戰，更強大的硬體反而刺激並放大了系統規模。</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">當時的高階程式語言完全缺乏數學計算基底與編譯器記憶體動態配置能力。</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">早期的真空管與主機架構在物理特性上無法支援多終端機與遠端通訊網絡的共用協定。</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 請點選左側選項進行自我檢測</span>
      <span class="btn-retry" style="display: none;">↺ 重新作答</span>
    </div>
    <div class="fb-body">
      <strong>💡 正確答案：B</strong> — 危機本質上是系統規模與智力管理帶來的組織複雜度挑戰。單純提升硬體運算能力與記憶體容量，反而會刺激建造更大規模的系統，使人腦使用非正式、隨意編程方法無法應對。更快的 CPU 無法解決需求遺漏、混亂的相依關係或介面溝通失誤等核心軟體問題。
    </div>
  </div>
</div>

<!--
我們來檢視第 1 題：軟體危機與複雜度。

核心問題：為什麼 1968 年的「軟體危機」無法單純透過購買運算速度更快、記憶體容量更大的電腦硬體來解決？

正確答案是選項 B：危機本質上是系統規模與智力管理帶來的組織複雜度挑戰。單純提升硬體運算能力與記憶體容量，反而會刺激建造更大規模的系統，使人腦使用非正式、隨意編程方法無法應對。更快的 CPU 無法解決需求遺漏、混亂的相依關係或介面溝通失誤等核心軟體問題。

總結這張投影片，請記住這個核心觀念：軟體危機與複雜度 提醒我們，軟體工程需要嚴謹的思維定義與客觀驗證，切勿流於盲目猜測。
-->
---
<!-- header: '第 1 章 | 第 02 題 / 共 31 題 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 1. 軟體工程導論 · 第 02 題</span>
    <span class="quiz-prog">單元：IEEE 軟體定義與範疇</span>
  </div>

  <div class="quiz-qbox">
    依據 IEEE 對「軟體 (Software)」的標準定義，下列何者不屬於軟體的範疇？
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="false">
      <span class="q-badge">A</span>
      <span class="q-text">可執行的電腦程式與原始碼檔案。</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="false">
      <span class="q-badge">B</span>
      <span class="q-text">系統資料庫綱要與組態設定檔。</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="true">
      <span class="q-badge">C</span>
      <span class="q-text">CPU 運算處理器與實體記憶體硬體模組。</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">軟體安裝步驟與自動化維運部署程序。</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 請點選左側選項進行自我檢測</span>
      <span class="btn-retry" style="display: none;">↺ 重新作答</span>
    </div>
    <div class="fb-body">
      <strong>💡 正確答案：C</strong> — 依據 IEEE 610.12 標準定義，軟體包含電腦程式、作業程序、相關文件與系統資料。CPU 運算處理器與記憶體屬於執行軟體的「實體電子硬體設備」，本身並非軟體組成要素。
    </div>
  </div>
</div>

<!--
我們來檢視第 2 題：IEEE 軟體定義與範疇。

核心問題：依據 IEEE 對「軟體 (Software)」的標準定義，下列何者不屬於軟體的範疇？

正確答案是選項 C：依據 IEEE 610.12 標準定義，軟體包含電腦程式、作業程序、相關文件與系統資料。CPU 運算處理器與記憶體屬於執行軟體的「實體電子硬體設備」，本身並非軟體組成要素。

總結這張投影片，請記住這個核心觀念：IEEE 軟體定義與範疇 提醒我們，軟體工程需要嚴謹的思維定義與客觀驗證，切勿流於盲目猜測。
-->
---
<!-- header: '第 1 章 | 第 03 題 / 共 31 題 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 1. 軟體工程導論 · 第 03 題</span>
    <span class="quiz-prog">單元：軟體工程通用核心活動</span>
  </div>

  <div class="quiz-qbox">
    下列哪一組選項正確地將具體的軟體工程實踐行為，對應到其所屬的四大通用核心活動？
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="true">
      <span class="q-badge">A</span>
      <span class="q-text">與利害關係人進行訪談以梳理使用者故事 → 軟體規格說明 (Specification)</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="false">
      <span class="q-badge">B</span>
      <span class="q-text">撰寫自動化單元測試以模擬資料庫回應 → 軟體設計與實作 (Design & Implementation)</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">重構資料庫綱要以提升查詢執行效能 → 軟體驗證 (Validation)</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">將老舊的第三方支付 API 抽換為全新閘道服務 → 軟體規格說明 (Specification)</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 請點選左側選項進行自我檢測</span>
      <span class="btn-retry" style="display: none;">↺ 重新作答</span>
    </div>
    <div class="fb-body">
      <strong>💡 正確答案：A</strong> — 與利害關係人訪談並梳理使用者故事是「軟體規格說明 (Specification)」的直接實踐；單元測試屬於「驗證 (Validation)」；資料庫重構屬於「軟體演進 (Evolution)」；抽換第三方 API 屬於「設計與實作」或「演進」。
    </div>
  </div>
</div>

<!--
我們來檢視第 3 題：軟體工程通用核心活動。

核心問題：下列哪一組選項正確地將具體的軟體工程實踐行為，對應到其所屬的四大通用核心活動？

正確答案是選項 A：與利害關係人訪談並梳理使用者故事是「軟體規格說明 (Specification)」的直接實踐；單元測試屬於「驗證 (Validation)」；資料庫重構屬於「軟體演進 (Evolution)」；抽換第三方 API 屬於「設計與實作」或「演進」。

總結這張投影片，請記住這個核心觀念：軟體工程通用核心活動 提醒我們，軟體工程需要嚴謹的思維定義與客觀驗證，切勿流於盲目猜測。
-->
---
<!-- header: '第 1 章 | 第 04 題 / 共 31 題 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 1. 軟體工程導論 · 第 04 題</span>
    <span class="quiz-prog">單元：布魯克斯法則與團隊規模</span>
  </div>

  <div class="quiz-qbox">
    某個軟體專案目前落後進度 3 週，距離正式交付期限僅剩 2 週。專案經理決定緊急招募 4 位初階程式設計師加入以期加速進度。根據「布魯克斯法則 (Brooks's Law)」，最可能的結果是什麼？
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="false">
      <span class="q-badge">A</span>
      <span class="q-text">專案將因此提前 1 週順利交付。</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="true">
      <span class="q-badge">B</span>
      <span class="q-text">專案進度將進一步嚴重延宕，因為資深工程師必須耗費寶貴時間來指導與培訓新人。</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">既有開發人員的產出效率將立刻提升一倍。</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">團隊內部的溝通複雜度將維持不變。</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 請點選左側選項進行自我檢測</span>
      <span class="btn-retry" style="display: none;">↺ 重新作答</span>
    </div>
    <div class="fb-body">
      <strong>💡 正確答案：B</strong> — 佛瑞德·布魯克斯在《人月神話》中指出：軟體開發是複雜的智力活動，無法像體力勞動般任意分割。向落後的專案增加人手，團隊通訊路徑會依 $n(n-1)/2$ 呈二次方暴增，且資深工程師必須暫停手邊開發來指導新人，導致專案更加落後。
    </div>
  </div>
</div>

<!--
我們來檢視第 4 題：布魯克斯法則與團隊規模。

核心問題：某個軟體專案目前落後進度 3 週，距離正式交付期限僅剩 2 週。專案經理決定緊急招募 4 位初階程式設計師加入以期加速進度。根據「布魯克斯法則 (Brooks's Law)」，最可能的結果是什麼？

正確答案是選項 B：佛瑞德·布魯克斯在《人月神話》中指出：軟體開發是複雜的智力活動，無法像體力勞動般任意分割。向落後的專案增加人手，團隊通訊路徑會依 $n(n-1)/2$ 呈二次方暴增，且資深工程師必須暫停手邊開發來指導新人，導致專案更加落後。

總結這張投影片，請記住這個核心觀念：布魯克斯法則與團隊規模 提醒我們，軟體工程需要嚴謹的思維定義與客觀驗證，切勿流於盲目猜測。
-->
---
<!-- header: '第 1 章 | 第 05 題 / 共 31 題 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 1. 軟體工程導論 · 第 05 題</span>
    <span class="quiz-prog">單元：單一職責原則 (SRP)</span>
  </div>

  <div class="quiz-qbox">
    一個電商「訂單處理模組」同時直接處理 HTTP 請求解析、執行信用卡交易、執行 SQL 資料庫查詢，並動態組裝 HTML 收據郵件。此設計最嚴重違反了哪項核心設計原則？
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="true">
      <span class="q-badge">A</span>
      <span class="q-text">關注點分離 (Separation of Concerns)：多項互不相干的業務職責緊密糾纏在單一模組中。</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="false">
      <span class="q-badge">B</span>
      <span class="q-text">YAGNI 原則：在客戶尚未提出明確商業需求前，過早實作臆測的未來擴充功能。</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">布魯克斯法則 (Brooks's Law)：對該訂單模組增加工程人手導致團隊溝通成本呈指數上升。</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">預應變更 (Anticipation of Change)：系統設定與業務規則被硬編碼寫死在編譯二進位檔中。</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 請點選左側選項進行自我檢測</span>
      <span class="btn-retry" style="display: none;">↺ 重新作答</span>
    </div>
    <div class="fb-body">
      <strong>💡 正確答案：A</strong> — 一個模組同時負責網路通訊、金流扣款、資料庫存取與郵件生成，承擔了過多截然不同的業務邏輯，嚴重違反「單一職責原則 (Single Responsibility Principle, SRP)」，應拆分為各自獨立的高內聚模組。
    </div>
  </div>
</div>

<!--
我們來檢視第 5 題：單一職責原則 (SRP)。

核心問題：一個電商「訂單處理模組」同時直接處理 HTTP 請求解析、執行信用卡交易、執行 SQL 資料庫查詢，並動態組裝 HTML 收據郵件。此設計最嚴重違反了哪項核心設計原則？

正確答案是選項 A：一個模組同時負責網路通訊、金流扣款、資料庫存取與郵件生成，承擔了過多截然不同的業務邏輯，嚴重違反「單一職責原則 (Single Responsibility Principle, SRP)」，應拆分為各自獨立的高內聚模組。

總結這張投影片，請記住這個核心觀念：單一職責原則 (SRP) 提醒我們，軟體工程需要嚴謹的思維定義與客觀驗證，切勿流於盲目猜測。
-->
---
<!-- header: '第 1 章 | 第 06 題 / 共 31 題 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 1. 軟體工程導論 · 第 06 題</span>
    <span class="quiz-prog">單元：ISO 25010 軟體品質特徵</span>
  </div>

  <div class="quiz-qbox">
    下列哪一個選項正確地將真實世界發生的軟體問題，對應到其所屬的 ISO 25010 品質特徵？
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="false">
      <span class="q-badge">A</span>
      <span class="q-text">資料庫查詢需要耗費 15 秒才能返回結果 → 可維護性 (Maintainability · 可測試性)</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="true">
      <span class="q-badge">B</span>
      <span class="q-text">當第三方外部 API 離線時，整個系統瞬間全面崩潰停擺 → 可靠性 (Reliability · 容錯性)</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">由於模組間強烈緊密耦合，開發者極難為其撰寫單元測試 → 可移植性 (Portability · 適應性)</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">未加密的 Session Cookie 導致惡意攻擊者輕易竊取身分登入他人帳號 → 易用性 (Usability · 易操作性)</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 請點選左側選項進行自我檢測</span>
      <span class="btn-retry" style="display: none;">↺ 重新作答</span>
    </div>
    <div class="fb-body">
      <strong>💡 正確答案：B</strong> — 當支付閘道或子服務逾時時，訂單核心系統應能維持降級運作而非全盤崩潰，此能力屬於「可靠性 (Reliability)」維度下的「容錯性 (Fault Tolerance)」或「可用性 (Availability)」。
    </div>
  </div>
</div>

<!--
我們來檢視第 6 題：ISO 25010 軟體品質特徵。

核心問題：下列哪一個選項正確地將真實世界發生的軟體問題，對應到其所屬的 ISO 25010 品質特徵？

正確答案是選項 B：當支付閘道或子服務逾時時，訂單核心系統應能維持降級運作而非全盤崩潰，此能力屬於「可靠性 (Reliability)」維度下的「容錯性 (Fault Tolerance)」或「可用性 (Availability)」。

總結這張投影片，請記住這個核心觀念：ISO 25010 軟體品質特徵 提醒我們，軟體工程需要嚴謹的思維定義與客觀驗證，切勿流於盲目猜測。
-->
---
<!-- header: '第 1 章 | 第 07 題 / 共 31 題 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 1. 軟體工程導論 · 第 07 題</span>
    <span class="quiz-prog">單元：ACM/IEEE 軟體工程倫理守則</span>
  </div>

  <div class="quiz-qbox">
    依據 ACM/IEEE 軟體工程倫理守則，若雇主或主管強烈指示工程師撰寫一段偽造安全合規報告、隱匿系統危險的演算法時，工程師的最高倫理義務為何？
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="false">
      <span class="q-badge">A</span>
      <span class="q-text">服從指示實作，因為雇主支付了工程師薪資，商業利益高於一切。</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="true">
      <span class="q-badge">B</span>
      <span class="q-text">堅定拒絕並向上呈報，因為保護公眾利益與社會安全的責任絕對高於對雇主的盲目忠誠。</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">照常撰寫該段偽造邏輯，但刻意省略所有程式碼文檔與註解。</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">將該段具爭議的代碼偷偷外包給第三方廠商執行以規避內部責任。</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 請點選左側選項進行自我檢測</span>
      <span class="btn-retry" style="display: none;">↺ 重新作答</span>
    </div>
    <div class="fb-body">
      <strong>💡 正確答案：B</strong> — ACM/IEEE 軟體工程倫理守則第一條明確規範：公眾的健康、安全與福祉高於雇主或客戶的利益。面對會威脅人命或法規的安全隱患，工程師有道德與法定責任拒絕違規指示並向上級或主管機關通報。
    </div>
  </div>
</div>

<!--
我們來檢視第 7 題：ACM/IEEE 軟體工程倫理守則。

核心問題：依據 ACM/IEEE 軟體工程倫理守則，若雇主或主管強烈指示工程師撰寫一段偽造安全合規報告、隱匿系統危險的演算法時，工程師的最高倫理義務為何？

正確答案是選項 B：ACM/IEEE 軟體工程倫理守則第一條明確規範：公眾的健康、安全與福祉高於雇主或客戶的利益。面對會威脅人命或法規的安全隱患，工程師有道德與法定責任拒絕違規指示並向上級或主管機關通報。

總結這張投影片，請記住這個核心觀念：ACM/IEEE 軟體工程倫理守則 提醒我們，軟體工程需要嚴謹的思維定義與客觀驗證，切勿流於盲目猜測。
-->
---
<!-- header: '第 1 章 | 第 08 題 / 共 31 題 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 1. 軟體工程導論 · 第 08 題</span>
    <span class="quiz-prog">單元：AI 編程與代碼流失率 (Code Churn)</span>
  </div>

  <div class="quiz-qbox">
    在評估 AI 輔助開發的實證研究中（如 GitClear 分析 1.5 億行代碼），「程式碼流失率 (Code Churn)」是關鍵品質指標。高 Code Churn 在 AI 開發環境中反映出何種核心問題？
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="true">
      <span class="q-badge">A</span>
      <span class="q-text">新提交的程式碼在極短時間內就被頻繁修改、刪除或推翻重寫，反映出 AI 代碼看似產出快速但本質脆弱且未經深思。</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="false">
      <span class="q-badge">B</span>
      <span class="q-text">編譯器與打包工具在持續部署管線中，主動且有效率地從發布二進位檔案中自動剔除未引用的死碼。</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">軟體開發團隊因為具備多語言自動轉譯工具，而在專案中頻繁更換底層核心程式語言與技術架構。</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">自動化測試案例執行速度過快，導致雲端 CI/CD 伺服器的虛擬機器運算配額在短時間內迅速耗盡。</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 請點選左側選項進行自我檢測</span>
      <span class="btn-retry" style="display: none;">↺ 重新作答</span>
    </div>
    <div class="fb-body">
      <strong>💡 正確答案：A</strong> — 代碼在寫入後兩週內即被大量重寫或廢棄刪除，稱為「代碼流失率 (Code Churn)」。這代表開發者雖然能快速產出代碼，但程式碼品質欠佳、架構缺乏深思熟慮，是 Vibe Coding 累積技術債的典型徵兆。
    </div>
  </div>
</div>

<!--
我們來檢視第 8 題：AI 編程與代碼流失率 (Code Churn)。

核心問題：在評估 AI 輔助開發的實證研究中（如 GitClear 分析 1.5 億行代碼），「程式碼流失率 (Code Churn)」是關鍵品質指標。高 Code Churn 在 AI 開發環境中反映出何種核心問題？

正確答案是選項 A：代碼在寫入後兩週內即被大量重寫或廢棄刪除，稱為「代碼流失率 (Code Churn)」。這代表開發者雖然能快速產出代碼，但程式碼品質欠佳、架構缺乏深思熟慮，是 Vibe Coding 累積技術債的典型徵兆。

總結這張投影片，請記住這個核心觀念：AI 編程與代碼流失率 (Code Churn) 提醒我們，軟體工程需要嚴謹的思維定義與客觀驗證，切勿流於盲目猜測。
-->
---
<!-- header: '第 1 章 | 第 09 題 / 共 31 題 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 1. 軟體工程導論 · 第 09 題</span>
    <span class="quiz-prog">單元：AI 驗證與同溫層測試陷阱</span>
  </div>

  <div class="quiz-qbox">
    工程師請 AI 生成一套複雜的計費結帳模組，並在未提供形式化規格契約下，直接請同一個 AI 自動生成單元測試。測試全部綠燈通過。此時最大的工程風險為何？
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="true">
      <span class="q-badge">A</span>
      <span class="q-text">同溫層盲點驗證：AI 生成的測試僅是在驗證自身有缺陷的錯誤假設，無法證明符合真實的業務規格。</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="false">
      <span class="q-badge">B</span>
      <span class="q-text">執行效能瓶頸：AI 生成的測試斷言在執行期需要耗費比人類手寫測試多出數十倍的記憶體運算資源。</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">編譯語法失敗：既有的主流自動化測試框架無法成功解析大型語言模型所合成的 Mock 假資料結構。</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">技術版本鎖定：該測試套件會與特定單一雲端供應商的執行時期環境產生強烈且無法抽換的緊密耦合。</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 請點選左側選項進行自我檢測</span>
      <span class="btn-retry" style="display: none;">↺ 重新作答</span>
    </div>
    <div class="fb-body">
      <strong>💡 正確答案：A</strong> — 當測試程式與實作程式碼皆由同一個 AI 模型在未經外部客觀規格定義下生成時，測試只會順著錯誤的生成邏輯進行驗證，形成「同溫層測試 (Echo Chamber Testing)」，產生虛假的安全感。
    </div>
  </div>
</div>

<!--
我們來檢視第 9 題：AI 驗證與同溫層測試陷阱。

核心問題：工程師請 AI 生成一套複雜的計費結帳模組，並在未提供形式化規格契約下，直接請同一個 AI 自動生成單元測試。測試全部綠燈通過。此時最大的工程風險為何？

正確答案是選項 A：當測試程式與實作程式碼皆由同一個 AI 模型在未經外部客觀規格定義下生成時，測試只會順著錯誤的生成邏輯進行驗證，形成「同溫層測試 (Echo Chamber Testing)」，產生虛假的安全感。

總結這張投影片，請記住這個核心觀念：AI 驗證與同溫層測試陷阱 提醒我們，軟體工程需要嚴謹的思維定義與客觀驗證，切勿流於盲目猜測。
-->
---
<!-- _class: lead -->
<!-- header: '第二章 軟體開發流程 | 章節導讀 ▾' -->

# **第二章 軟體開發流程**
## 流程模型、敏捷哲學、極限編程與工程紀律

> 「沒有任何單一的技術或管理突破，能在十年內讓軟體的生產力、可靠度或簡易性提升一個數量級。」 —— 佛瑞德·布魯克斯 (Fred Brooks)

<!--
進入第二章：軟體開發流程與模型。

本單元包含 14 道觀念檢測題，深入探討傳統瀑布模型、V-模型、敏捷宣言價值、看板 WIP 限制、技術債本利和與 CI/CD 實踐。

作答時請將自己置身於敏捷團隊的工程情境中，判斷哪項決策才能為使用者帶來最健康的長期價值。

總結這張投影片，請記住這個核心觀念：流程模型的選擇必須與專案的變更容忍度、風險特徵與團隊成熟度相匹配。
-->

---
<!-- header: '第 2 章 | 第 10 題 / 共 31 題 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 2. 軟體開發流程 · 第 10 題</span>
    <span class="quiz-prog">單元：傳統瀑布模型的本質缺點</span>
  </div>

  <div class="quiz-qbox">
    傳統瀑布模型在實務運作上最主要的核心缺點是什麼？
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="false">
      <span class="q-badge">A</span>
      <span class="q-text">為外部法規合規性與稽核所產生的工程文檔過度匱乏。</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="true">
      <span class="q-badge">B</span>
      <span class="q-text">一旦專案啟動進行，極難且成本高昂去因應與調適變更的需求。</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">在執行過程中完全消除了元件測試與系統整合測試的需求。</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">無法在跨國多據點的大型軟體工程組織中進行團隊協同。</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 請點選左側選項進行自我檢測</span>
      <span class="btn-retry" style="display: none;">↺ 重新作答</span>
    </div>
    <div class="fb-body">
      <strong>💡 正確答案：B</strong> — 瀑布模型將開發切分為嚴格依序進行的階段，並假設前期需求能夠完全凍結。一旦專案進入後期的編程或測試階段，任何需求變更都將導致跨階段的骨牌式連鎖重工，付出極為高昂的代價。
    </div>
  </div>
</div>

<!--
我們來檢視第 10 題：傳統瀑布模型的本質缺點。

核心問題：傳統瀑布模型在實務運作上最主要的核心缺點是什麼？

正確答案是選項 B：瀑布模型將開發切分為嚴格依序進行的階段，並假設前期需求能夠完全凍結。一旦專案進入後期的編程或測試階段，任何需求變更都將導致跨階段的骨牌式連鎖重工，付出極為高昂的代價。

總結這張投影片，請記住這個核心觀念：傳統瀑布模型的本質缺點 提醒我們，軟體工程需要嚴謹的思維定義與客觀驗證，切勿流於盲目猜測。
-->
---
<!-- header: '第 2 章 | 第 11 題 / 共 31 題 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 2. 軟體開發流程 · 第 11 題</span>
    <span class="quiz-prog">單元：V-模型與測試左移</span>
  </div>

  <div class="quiz-qbox">
    相較於傳統瀑布模型，V-模型在工程實務上最主要的核心優勢是什麼？
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="false">
      <span class="q-badge">A</span>
      <span class="q-text">在為期兩週的短週期衝刺疊代中持續交付可運行軟體增量。</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="true">
      <span class="q-badge">B</span>
      <span class="q-text">強制在早期的規格分析階段，即同步進行測試規劃與驗收準則設計。</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">完全消除了對詳細架構設計文件與介面合約的依賴。</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">允許客戶在實作編程階段隨意動態變更需求且完全不衍生額外成本。</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 請點選左側選項進行自我檢測</span>
      <span class="btn-retry" style="display: none;">↺ 重新作答</span>
    </div>
    <div class="fb-body">
      <strong>💡 正確答案：B</strong> — V-模型的最大貢獻在於「測試左移 (Shift-Left Testing)」：在專案初期的需求分析階段就同步規劃驗收測試計畫，在系統架構設計時即規劃整合測試，提早揭露各層級的潛在缺陷。
    </div>
  </div>
</div>

<!--
我們來檢視第 11 題：V-模型與測試左移。

核心問題：相較於傳統瀑布模型，V-模型在工程實務上最主要的核心優勢是什麼？

正確答案是選項 B：V-模型的最大貢獻在於「測試左移 (Shift-Left Testing)」：在專案初期的需求分析階段就同步規劃驗收測試計畫，在系統架構設計時即規劃整合測試，提早揭露各層級的潛在缺陷。

總結這張投影片，請記住這個核心觀念：V-模型與測試左移 提醒我們，軟體工程需要嚴謹的思維定義與客觀驗證，切勿流於盲目猜測。
-->
---
<!-- header: '第 2 章 | 第 12 題 / 共 31 題 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 2. 軟體開發流程 · 第 12 題</span>
    <span class="quiz-prog">單元：增量 (Incremental) 與疊代 (Iterative)</span>
  </div>

  <div class="quiz-qbox">
    在軟體流程工程中，「增量 (Incremental)」與「疊代 (Iterative)」開發的根本觀念差異是什麼？
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="false">
      <span class="q-badge">A</span>
      <span class="q-text">增量專注於自動化測試；疊代專注於 UI 介面視覺設計。</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="true">
      <span class="q-badge">B</span>
      <span class="q-text">增量分階段交付完整可運行的垂直功能切片；疊代在重複循環中深化打磨系統的整體初稿。</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">增量由專案經理負責主導；疊代完全由客戶端工程師自行決策。</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">增量嚴格遵循瀑布規範；疊代完全不產生任何程式碼文檔。</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 請點選左側選項進行自我檢測</span>
      <span class="btn-retry" style="display: none;">↺ 重新作答</span>
    </div>
    <div class="fb-body">
      <strong>💡 正確答案：B</strong> — 增量開發 (Incremental) 是按功能模組一塊一塊交付（如搭拼圖般垂直切片）；疊代開發 (Iterative) 則是在一輪輪回圈中逐步深化打磨整體系統（如雕刻塑像般逐漸精細）。敏捷方法通常同時結合兩者。
    </div>
  </div>
</div>

<!--
我們來檢視第 12 題：增量 (Incremental) 與疊代 (Iterative)。

核心問題：在軟體流程工程中，「增量 (Incremental)」與「疊代 (Iterative)」開發的根本觀念差異是什麼？

正確答案是選項 B：增量開發 (Incremental) 是按功能模組一塊一塊交付（如搭拼圖般垂直切片）；疊代開發 (Iterative) 則是在一輪輪回圈中逐步深化打磨整體系統（如雕刻塑像般逐漸精細）。敏捷方法通常同時結合兩者。

總結這張投影片，請記住這個核心觀念：增量 (Incremental) 與疊代 (Iterative) 提醒我們，軟體工程需要嚴謹的思維定義與客觀驗證，切勿流於盲目猜測。
-->
---
<!-- header: '第 2 章 | 第 13 題 / 共 31 題 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 2. 軟體開發流程 · 第 13 題</span>
    <span class="quiz-prog">單元：最小可行產品 (MVP) 演進模式</span>
  </div>

  <div class="quiz-qbox">
    在 Henrik Kniberg 著名的最小可行產品 (MVP) 隱喻中（從滑板到汽車），為什麼在第一期交付「一顆孤立的汽車輪子」被視為嚴重的反模式 (Anti-Pattern)？
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="false">
      <span class="q-badge">A</span>
      <span class="q-text">因為單獨製造一顆輪子的生產成本遠高於組裝滑板。</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="true">
      <span class="q-badge">B</span>
      <span class="q-text">因為單獨一顆輪子無法提供任何端到端的交通位移價值，使用者完全無法藉其驗證核心痛點。</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">因為在現代工業設計中汽車輪子無法直接升級為機車輪胎。</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">因為軟體工程標準禁止團隊在第一期專案中開發圓形幾何物件。</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 請點選左側選項進行自我檢測</span>
      <span class="btn-retry" style="display: none;">↺ 重新作答</span>
    </div>
    <div class="fb-body">
      <strong>💡 正確答案：B</strong> — 軟體的價值在於「解決使用者痛點」。單一顆輪子無法提供任何位移功能，是不可運作的內部組件；而滑板雖然簡陋，卻能立刻提供位移價值並蒐集真實使用者反饋，這才是 MVP 的核心真諦。
    </div>
  </div>
</div>

<!--
我們來檢視第 13 題：最小可行產品 (MVP) 演進模式。

核心問題：在 Henrik Kniberg 著名的最小可行產品 (MVP) 隱喻中（從滑板到汽車），為什麼在第一期交付「一顆孤立的汽車輪子」被視為嚴重的反模式 (Anti-Pattern)？

正確答案是選項 B：軟體的價值在於「解決使用者痛點」。單一顆輪子無法提供任何位移功能，是不可運作的內部組件；而滑板雖然簡陋，卻能立刻提供位移價值並蒐集真實使用者反饋，這才是 MVP 的核心真諦。

總結這張投影片，請記住這個核心觀念：最小可行產品 (MVP) 演進模式 提醒我們，軟體工程需要嚴謹的思維定義與客觀驗證，切勿流於盲目猜測。
-->
---
<!-- header: '第 2 章 | 第 14 題 / 共 31 題 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 2. 軟體開發流程 · 第 14 題</span>
    <span class="quiz-prog">單元：敏捷宣言核心價值</span>
  </div>

  <div class="quiz-qbox">
    敏捷宣言宣稱：*「可運行的軟體重於詳盡的文檔。」* 這項價值在實務工程中主要倡導何種行為？
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="false">
      <span class="q-badge">A</span>
      <span class="q-text">嚴格禁止工程團隊撰寫任何架構設計文件或 API 規格合約。</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="true">
      <span class="q-badge">B</span>
      <span class="q-text">雖然文檔具有其輔助價值，但團隊應將交付可點擊執行的軟體系統置於最優先級。</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">專案進度完全不需要撰寫程式碼，只需由客戶口頭認可即可。</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">將所有軟體文檔直接替換為行銷部門的投影片。</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 請點選左側選項進行自我檢測</span>
      <span class="btn-retry" style="display: none;">↺ 重新作答</span>
    </div>
    <div class="fb-body">
      <strong>💡 正確答案：B</strong> — 敏捷宣言主張「可執行的軟體高於詳盡的文件」，意在強調文件應以支援可運行軟體的交付為目的，避免過度官僚形式主義阻礙實際價值的快速交付，並非完全放棄規格與架構文檔。
    </div>
  </div>
</div>

<!--
我們來檢視第 14 題：敏捷宣言核心價值。

核心問題：敏捷宣言宣稱：*「可運行的軟體重於詳盡的文檔。」* 這項價值在實務工程中主要倡導何種行為？

正確答案是選項 B：敏捷宣言主張「可執行的軟體高於詳盡的文件」，意在強調文件應以支援可運行軟體的交付為目的，避免過度官僚形式主義阻礙實際價值的快速交付，並非完全放棄規格與架構文檔。

總結這張投影片，請記住這個核心觀念：敏捷宣言核心價值 提醒我們，軟體工程需要嚴謹的思維定義與客觀驗證，切勿流於盲目猜測。
-->
---
<!-- header: '第 2 章 | 第 15 題 / 共 31 題 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 2. 軟體開發流程 · 第 15 題</span>
    <span class="quiz-prog">單元：敏捷原則之可持續開發步調</span>
  </div>

  <div class="quiz-qbox">
    敏捷原則第八條指出：*「敏捷流程提倡可持續的開發步調。發起人、開發者和使用者應能長期維持恆常穩定的步調。」* 其最核心的工程動機為何？
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="true">
      <span class="q-badge">A</span>
      <span class="q-text">避免因長時間過勞導致代碼品質劣化、累積致命缺陷以及工程團隊耗竭流失。</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="false">
      <span class="q-badge">B</span>
      <span class="q-text">強制工程師每週必須提交超過一百次無意義的 Git Commit 記錄。</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">限制開發團隊每天最多只能撰寫五十行以內的原始碼。</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">確保軟體永遠不需要在生產環境中進行重大版本發行。</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 請點選左側選項進行自我檢測</span>
      <span class="btn-retry" style="display: none;">↺ 重新作答</span>
    </div>
    <div class="fb-body">
      <strong>💡 正確答案：A</strong> — 敏捷原則提倡「可持續的開發步調 (Sustainable Pace)」。長期加班與通宵開發會耗盡工程師心力，使代碼缺陷率急遽飆升，後續修復臭蟲的時間往往數倍於加班搶出的進度，反而拖垮整體產能。
    </div>
  </div>
</div>

<!--
我們來檢視第 15 題：敏捷原則之可持續開發步調。

核心問題：敏捷原則第八條指出：*「敏捷流程提倡可持續的開發步調。發起人、開發者和使用者應能長期維持恆常穩定的步調。」* 其最核心的工程動機為何？

正確答案是選項 A：敏捷原則提倡「可持續的開發步調 (Sustainable Pace)」。長期加班與通宵開發會耗盡工程師心力，使代碼缺陷率急遽飆升，後續修復臭蟲的時間往往數倍於加班搶出的進度，反而拖垮整體產能。

總結這張投影片，請記住這個核心觀念：敏捷原則之可持續開發步調 提醒我們，軟體工程需要嚴謹的思維定義與客觀驗證，切勿流於盲目猜測。
-->
---
<!-- header: '第 2 章 | 第 16 題 / 共 31 題 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 2. 軟體開發流程 · 第 16 題</span>
    <span class="quiz-prog">單元：看板方法與半成品限制 (WIP Limit)</span>
  </div>

  <div class="quiz-qbox">
    在看板 (Kanban) 流程框架中，對看板欄位強制設定嚴格的「在製品數量上限 (WIP Limits)」主要工程目的為何？
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="false">
      <span class="q-badge">A</span>
      <span class="q-text">限制工程師每日能夠修改的程式碼檔案總數。</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="true">
      <span class="q-badge">B</span>
      <span class="q-text">消除多工切換耗損、暴露出流程瓶頸，並迫使團隊在開啟新工作前先將既有任務推進至完成。</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">迫使軟體團隊必須恢復傳統瀑布模型的年度驗收測試。</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">確保軟體專案的所有架構設計皆由外部顧問獨立完成。</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 請點選左側選項進行自我檢測</span>
      <span class="btn-retry" style="display: none;">↺ 重新作答</span>
    </div>
    <div class="fb-body">
      <strong>💡 正確答案：B</strong> — 看板限制在製品 (WIP) 的核心精神是「停止開始，開始完成 (Stop starting, start finishing)」。限制平行進行中的任務數量，能顯著降低上下文切換 (Context Switching) 的認知損耗，並能迅速暴露流水線中的阻塞瓶頸。
    </div>
  </div>
</div>

<!--
我們來檢視第 16 題：看板方法與半成品限制 (WIP Limit)。

核心問題：在看板 (Kanban) 流程框架中，對看板欄位強制設定嚴格的「在製品數量上限 (WIP Limits)」主要工程目的為何？

正確答案是選項 B：看板限制在製品 (WIP) 的核心精神是「停止開始，開始完成 (Stop starting, start finishing)」。限制平行進行中的任務數量，能顯著降低上下文切換 (Context Switching) 的認知損耗，並能迅速暴露流水線中的阻塞瓶頸。

總結這張投影片，請記住這個核心觀念：看板方法與半成品限制 (WIP Limit) 提醒我們，軟體工程需要嚴謹的思維定義與客觀驗證，切勿流於盲目猜測。
-->
---
<!-- header: '第 2 章 | 第 17 題 / 共 31 題 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 2. 軟體開發流程 · 第 17 題</span>
    <span class="quiz-prog">單元：衝刺回顧會議 (Sprint Retrospective)</span>
  </div>

  <div class="quiz-qbox">
    在 Scrum 框架中，每個衝刺末期召開的「衝刺回顧會議 (Sprint Retrospective)」其最主要的核心目標是什麼？
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="false">
      <span class="q-badge">A</span>
      <span class="q-text">向外界利益關係人正式演示可運行的軟體增量以獲取商業反饋。</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="true">
      <span class="q-badge">B</span>
      <span class="q-text">審視團隊內部的人際協同、工程流程與工具實踐，並制定具體的行動改善方案。</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">針對落後進度的工程師個人進行公開績效檢討與懲處。</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">將整個軟體專案的所有產品待辦清單全面銷毀重來。</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 請點選左側選項進行自我檢測</span>
      <span class="btn-retry" style="display: none;">↺ 重新作答</span>
    </div>
    <div class="fb-body">
      <strong>💡 正確答案：B</strong> — 衝刺回顧會議 (Retrospective) 是團隊內部的閉門自省會議，聚焦於「人、流程、工具與協同機制」的檢討與調適，並共同承諾在下一個衝刺具體落實改進行動。
    </div>
  </div>
</div>

<!--
我們來檢視第 17 題：衝刺回顧會議 (Sprint Retrospective)。

核心問題：在 Scrum 框架中，每個衝刺末期召開的「衝刺回顧會議 (Sprint Retrospective)」其最主要的核心目標是什麼？

正確答案是選項 B：衝刺回顧會議 (Retrospective) 是團隊內部的閉門自省會議，聚焦於「人、流程、工具與協同機制」的檢討與調適，並共同承諾在下一個衝刺具體落實改進行動。

總結這張投影片，請記住這個核心觀念：衝刺回顧會議 (Sprint Retrospective) 提醒我們，軟體工程需要嚴謹的思維定義與客觀驗證，切勿流於盲目猜測。
-->
---
<!-- header: '第 2 章 | 第 18 題 / 共 31 題 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 2. 軟體開發流程 · 第 18 題</span>
    <span class="quiz-prog">單元：軟體技術債與利息代價</span>
  </div>

  <div class="quiz-qbox">
    依據 Ward Cunningham 提出的「技術債 (Technical Debt)」金融隱喻，下列何者代表軟體組織在未來所必須支付的「複利利息 (Interest)」？
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="false">
      <span class="q-badge">A</span>
      <span class="q-text">每年向公有雲端供應商支付的伺服器虛擬機器租賃費用。</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="true">
      <span class="q-badge">B</span>
      <span class="q-text">因架構混亂耦合與缺乏測試，導致後續每次新增或修改功能時額外耗費的摸索、除錯與修補代價。</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">發放給全體資深軟體架構師的年度專案分紅獎金。</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">購買商業專利編譯器軟體授權的固定折舊費用。</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 請點選左側選項進行自我檢測</span>
      <span class="btn-retry" style="display: none;">↺ 重新作答</span>
    </div>
    <div class="fb-body">
      <strong>💡 正確答案：B</strong> — 當初為了求快而欠下的架構債務是「本金」；而因為劣質代碼存在，導致後續每次開發與維護時額外付出的摸索、除錯與修補代價，就是必須不斷償還的「利息」。
    </div>
  </div>
</div>

<!--
我們來檢視第 18 題：軟體技術債與利息代價。

核心問題：依據 Ward Cunningham 提出的「技術債 (Technical Debt)」金融隱喻，下列何者代表軟體組織在未來所必須支付的「複利利息 (Interest)」？

正確答案是選項 B：當初為了求快而欠下的架構債務是「本金」；而因為劣質代碼存在，導致後續每次開發與維護時額外付出的摸索、除錯與修補代價，就是必須不斷償還的「利息」。

總結這張投影片，請記住這個核心觀念：軟體技術債與利息代價 提醒我們，軟體工程需要嚴謹的思維定義與客觀驗證，切勿流於盲目猜測。
-->
---
<!-- header: '第 2 章 | 第 19 題 / 共 31 題 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 2. 軟體開發流程 · 第 19 題</span>
    <span class="quiz-prog">單元：疲軟 Scrum (Flaccid Scrum)</span>
  </div>

  <div class="quiz-qbox">
    Martin Fowler 提出著名的**「疲軟 Scrum (Flaccid Scrum)」**一詞，是用來針砭軟體工程實務中的哪項重大失衡？
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="true">
      <span class="q-badge">A</span>
      <span class="q-text">全面導入 Scrum 的管理儀式與表象名詞，卻徹底拋棄了 TDD、持續重構與 CI 等技術工程實踐。</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="false">
      <span class="q-badge">B</span>
      <span class="q-text">拒絕使用昂貴的商業 Jira 專案追蹤軟體，堅持使用物理實體白板與紙本便利貼。</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">允許產品負責人在衝刺規劃會議進行期間微調待辦清單的排序。</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">強制在每一次 Git Commit 提交時必須由自動化 CI 流水線執行單元測試。</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 請點選左側選項進行自我檢測</span>
      <span class="btn-retry" style="display: none;">↺ 重新作答</span>
    </div>
    <div class="fb-body">
      <strong>💡 正確答案：A</strong> — 「疲軟 Scrum (Flaccid Scrum)」指的是團隊僅導入站立會議、衝刺等專案管理儀式，卻忽視了極限編程 (XP) 中的自動化測試、重構、持續整合等嚴謹技術實踐，導致底層代碼逐漸腐爛。
    </div>
  </div>
</div>

<!--
我們來檢視第 19 題：疲軟 Scrum (Flaccid Scrum)。

核心問題：Martin Fowler 提出著名的**「疲軟 Scrum (Flaccid Scrum)」**一詞，是用來針砭軟體工程實務中的哪項重大失衡？

正確答案是選項 A：「疲軟 Scrum (Flaccid Scrum)」指的是團隊僅導入站立會議、衝刺等專案管理儀式，卻忽視了極限編程 (XP) 中的自動化測試、重構、持續整合等嚴謹技術實踐，導致底層代碼逐漸腐爛。

總結這張投影片，請記住這個核心觀念：疲軟 Scrum (Flaccid Scrum) 提醒我們，軟體工程需要嚴謹的思維定義與客觀驗證，切勿流於盲目猜測。
-->
---
<!-- header: '第 2 章 | 第 20 題 / 共 31 題 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 2. 軟體開發流程 · 第 20 題</span>
    <span class="quiz-prog">單元：結對編程之領航員角色</span>
  </div>

  <div class="quiz-qbox">
    在極限編程 (XP) 的結對編程 (Pair Programming) 實踐中，「領航員 (Navigator)」的最主要核心職責是什麼？
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="false">
      <span class="q-badge">A</span>
      <span class="q-text">專注於敲擊鍵盤語法並在本地終端機執行指令編譯。</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="true">
      <span class="q-badge">B</span>
      <span class="q-text">退後一步進行宏觀戰略思考，即時審閱代碼結構、推敲極端邊界條件並把關系統架構。</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">擔任專屬的 Scrum 敏捷教練並負責在 Jira 系統中拖動任務卡片。</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">負責與客戶進行法律合約協商並審批團隊年度工程預算。</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 請點選左側選項進行自我檢測</span>
      <span class="btn-retry" style="display: none;">↺ 重新作答</span>
    </div>
    <div class="fb-body">
      <strong>💡 正確答案：B</strong> — 在結對編程 (Pair Programming) 中，領航員 (Navigator) 的職責是抽離鍵盤細節，站在更高的戰略視野：審視整體演算法方向、考量邊界與極端狀況、預防架構腐爛，並確保代碼符合設計模式。
    </div>
  </div>
</div>

<!--
我們來檢視第 20 題：結對編程之領航員角色。

核心問題：在極限編程 (XP) 的結對編程 (Pair Programming) 實踐中，「領航員 (Navigator)」的最主要核心職責是什麼？

正確答案是選項 B：在結對編程 (Pair Programming) 中，領航員 (Navigator) 的職責是抽離鍵盤細節，站在更高的戰略視野：審視整體演算法方向、考量邊界與極端狀況、預防架構腐爛，並確保代碼符合設計模式。

總結這張投影片，請記住這個核心觀念：結對編程之領航員角色 提醒我們，軟體工程需要嚴謹的思維定義與客觀驗證，切勿流於盲目猜測。
-->
---
<!-- header: '第 2 章 | 第 21 題 / 共 31 題 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 2. 軟體開發流程 · 第 21 題</span>
    <span class="quiz-prog">單元：TDD 測試驅動開發與重構</span>
  </div>

  <div class="quiz-qbox">
    在極限編程的「測試驅動開發 (TDD)」紅綠重構循環中，「重構 (Refactor)」階段的特定工程目標是什麼？
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="false">
      <span class="q-badge">A</span>
      <span class="q-text">為模組增添全新的業務功能並擴展其對外的公共 API 介面合約。</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="true">
      <span class="q-badge">B</span>
      <span class="q-text">在確保所有既有自動化測試持續維持綠燈通過的前提下，改善程式碼的內部架構、消除重複並提升可讀性。</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">徹底刪除所有執行時間超過一秒的自動化單元測試以加速 CI 構建。</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">將應用系統從物件導向語言強行全盤改寫為純函式語言。</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 請點選左側選項進行自我檢測</span>
      <span class="btn-retry" style="display: none;">↺ 重新作答</span>
    </div>
    <div class="fb-body">
      <strong>💡 正確答案：B</strong> — 重構 (Refactoring) 的定義是在「不改變外在可觀察行為」的前提下，改善代碼的內部結構與可維護性。在重構期間必須確保所有自動化測試皆維持綠燈（通過狀態）。
    </div>
  </div>
</div>

<!--
我們來檢視第 21 題：TDD 測試驅動開發與重構。

核心問題：在極限編程的「測試驅動開發 (TDD)」紅綠重構循環中，「重構 (Refactor)」階段的特定工程目標是什麼？

正確答案是選項 B：重構 (Refactoring) 的定義是在「不改變外在可觀察行為」的前提下，改善代碼的內部結構與可維護性。在重構期間必須確保所有自動化測試皆維持綠燈（通過狀態）。

總結這張投影片，請記住這個核心觀念：TDD 測試驅動開發與重構 提醒我們，軟體工程需要嚴謹的思維定義與客觀驗證，切勿流於盲目猜測。
-->
---
<!-- header: '第 2 章 | 第 22 題 / 共 31 題 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 2. 軟體開發流程 · 第 22 題</span>
    <span class="quiz-prog">單元：持續交付 (CD) vs. 持續部署</span>
  </div>

  <div class="quiz-qbox">
    在現代 DevOps 實務中，「持續交付 (Continuous Delivery)」與「持續部署 (Continuous Deployment)」在實務維運上的根本決定性差異為何？
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="false">
      <span class="q-badge">A</span>
      <span class="q-text">持續交付需要仰賴人工編譯原始碼；持續部署則實現編譯自動化。</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="true">
      <span class="q-badge">B</span>
      <span class="q-text">持續交付在預發環境中暫停並需經由人工商業決策審批發行；持續部署則在通過全套自動化測試後直接自動推上生產環境。</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">持續交付專門用於行動 App 開發；持續部署專門用於關聯式資料庫。</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">持續交付完全不需單元測試；持續部署強制要求結對編程。</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 請點選左側選項進行自我檢測</span>
      <span class="btn-retry" style="display: none;">↺ 重新作答</span>
    </div>
    <div class="fb-body">
      <strong>💡 正確答案：B</strong> — 持續交付 (Continuous Delivery) 確保每版代碼皆產出經過嚴密驗證、可隨時上線的製品，但由人工業務決策決定何時釋出；持續部署 (Continuous Deployment) 則拿掉人工審批，自動化直通生產環境。
    </div>
  </div>
</div>

<!--
我們來檢視第 22 題：持續交付 (CD) vs. 持續部署。

核心問題：在現代 DevOps 實務中，「持續交付 (Continuous Delivery)」與「持續部署 (Continuous Deployment)」在實務維運上的根本決定性差異為何？

正確答案是選項 B：持續交付 (Continuous Delivery) 確保每版代碼皆產出經過嚴密驗證、可隨時上線的製品，但由人工業務決策決定何時釋出；持續部署 (Continuous Deployment) 則拿掉人工審批，自動化直通生產環境。

總結這張投影片，請記住這個核心觀念：持續交付 (CD) vs. 持續部署 提醒我們，軟體工程需要嚴謹的思維定義與客觀驗證，切勿流於盲目猜測。
-->
---
<!-- header: '第 2 章 | 第 23 題 / 共 31 題 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 2. 軟體開發流程 · 第 23 題</span>
    <span class="quiz-prog">單元：AI 代理人與自動化驗證守門員</span>
  </div>

  <div class="quiz-qbox">
    在現代「AI 規格驅動開發 (AI Specification-Driven)」實務中，自動化 CI/CD 驗證守門員的最主要核心角色是什麼？
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="false">
      <span class="q-badge">A</span>
      <span class="q-text">阻止人類開發者親自審閱人工智慧所生成的代碼產物。</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="true">
      <span class="q-badge">B</span>
      <span class="q-text">在 AI 生成的程式碼合入生產環境前，強制執行確定性品質檢查、測試合規性驗證與缺陷防堵。</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">將自然語言提示詞直接轉換為公有雲端供應商的月度扣款帳單。</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">全面廢除傳統軟體規格書，改以未經驗證的龐雜聊天歷史紀錄替代。</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 請點選左側選項進行自我檢測</span>
      <span class="btn-retry" style="display: none;">↺ 重新作答</span>
    </div>
    <div class="fb-body">
      <strong>💡 正確答案：B</strong> — AI 代理人能以驚人速度產出大量代碼，但極易混雜幻覺、不符規範的寫法或未知漏洞。嚴密的自動化編譯、靜態分析與單元測試守門員，是確保主幹分支品質不受污染的關鍵防線。
    </div>
  </div>
</div>

<!--
我們來檢視第 23 題：AI 代理人與自動化驗證守門員。

核心問題：在現代「AI 規格驅動開發 (AI Specification-Driven)」實務中，自動化 CI/CD 驗證守門員的最主要核心角色是什麼？

正確答案是選項 B：AI 代理人能以驚人速度產出大量代碼，但極易混雜幻覺、不符規範的寫法或未知漏洞。嚴密的自動化編譯、靜態分析與單元測試守門員，是確保主幹分支品質不受污染的關鍵防線。

總結這張投影片，請記住這個核心觀念：AI 代理人與自動化驗證守門員 提醒我們，軟體工程需要嚴謹的思維定義與客觀驗證，切勿流於盲目猜測。
-->
---
<!-- _class: lead -->
<!-- header: '第三章 需求工程 | 章節導讀 ▾' -->

# **第三章 需求工程**
## 需求探索、規格契約、可量化指標與人機協同

> 「在建造軟體系統的所有環節中，最困難的單一任務，莫過於精準決定究竟要建造什麼。」 —— 佛瑞德·布魯克斯 (Fred Brooks)

<!--
進入第三章：需求工程。

本單元包含 8 道觀念檢測題，涵蓋使用者需求與系統需求的分工、領域需求的辨識、非功能性需求之客觀可驗證性、民族誌挖掘內隱知識與大語言模型幻覺防範。

這是軟體工程中失敗代價最高昂的階段，請謹慎思考每一個需求問題背後的真實意圖。

總結這張投影片，請記住這個核心觀念：唯有正確定義問題，才能打造出真正滿足真實世界需求的正確系統。
-->

---
<!-- header: '第 3 章 | 第 24 題 / 共 31 題 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 3. 需求工程 · 第 24 題</span>
    <span class="quiz-prog">單元：使用者需求 vs. 系統需求</span>
  </div>

  <div class="quiz-qbox">
    在需求工程中，「使用者需求 (User Requirements)」與「系統需求 (System Requirements)」最關鍵的實務運作差異為何？
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="true">
      <span class="q-badge">A</span>
      <span class="q-text">使用者需求是利害關係人的高階目標；系統需求則是供開發者實作的精確功能合約。</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="false">
      <span class="q-badge">B</span>
      <span class="q-text">使用者需求限定於 UI 線框圖；系統需求則專指後端資料庫的資料表綱要設計。</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">使用者需求簽署後絕不可變更；系統需求則需在每日站立會議中持續進行重構。</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">使用者需求來自外部法規稽核團隊；系統需求則由編譯器工具自動解析產生。</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 請點選左側選項進行自我檢測</span>
      <span class="btn-retry" style="display: none;">↺ 重新作答</span>
    </div>
    <div class="fb-body">
      <strong>💡 正確答案：A</strong> — 使用者需求 (User Requirements) 以高階自然語言與圖表描繪系統需提供之服務與業務約束，主要面向客戶與主管；系統需求 (System Requirements) 則詳細規範系統功能、介面與操作約束，作為工程師實作與驗收的合約。
    </div>
  </div>
</div>

<!--
我們來檢視第 24 題：使用者需求 vs. 系統需求。

核心問題：在需求工程中，「使用者需求 (User Requirements)」與「系統需求 (System Requirements)」最關鍵的實務運作差異為何？

正確答案是選項 A：使用者需求 (User Requirements) 以高階自然語言與圖表描繪系統需提供之服務與業務約束，主要面向客戶與主管；系統需求 (System Requirements) 則詳細規範系統功能、介面與操作約束，作為工程師實作與驗收的合約。

總結這張投影片，請記住這個核心觀念：使用者需求 vs. 系統需求 提醒我們，軟體工程需要嚴謹的思維定義與客觀驗證，切勿流於盲目猜測。
-->
---
<!-- header: '第 3 章 | 第 25 題 / 共 31 題 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 3. 需求工程 · 第 25 題</span>
    <span class="quiz-prog">單元：領域需求 (Domain Requirements)</span>
  </div>

  <div class="quiz-qbox">
    請參考 UberEats 外送平台的這段需求規格說明：
> *「因應市政食品衛生安全法規，易腐熟食的外送運送時間不得超過 45 分鐘，且運送容器全程須維持在 60°C 以上。」*

請問上述敘述屬於哪一種軟體需求類別？
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="true">
      <span class="q-badge">A</span>
      <span class="q-text">領域需求 (Domain Requirement，由運作環境、產業法規或物理定律所施加的強制約束)</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="false">
      <span class="q-badge">B</span>
      <span class="q-text">功能性需求 (Functional Requirement，指定系統必須執行的主動計算、特定功能或服務)</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">非功能性需求 (Non-Functional Requirement，針對效能、擴充性或可用性等整體系統品質特性)</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">使用者需求 (User Requirement，由終端消費者所提出之高階自然語言願景或業務目標)</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 請點選左側選項進行自我檢測</span>
      <span class="btn-retry" style="display: none;">↺ 重新作答</span>
    </div>
    <div class="fb-body">
      <strong>💡 正確答案：A</strong> — 源自外部法規、主管機關監管標準、特定產業合約或實體物理環境法則的強制性約束，在軟體工程中歸類為「領域需求 (Domain Requirements)」。
    </div>
  </div>
</div>

<!--
我們來檢視第 25 題：領域需求 (Domain Requirements)。

核心問題：請參考 UberEats 外送平台的這段需求規格說明：
> *「因應市政食品衛生安全法規，易腐熟食的外送運送時間不得超過 45 分鐘，且運送容器全程須維持在 60°C 以上。」*

請問上述敘述屬於哪一種軟體需求類別？

正確答案是選項 A：源自外部法規、主管機關監管標準、特定產業合約或實體物理環境法則的強制性約束，在軟體工程中歸類為「領域需求 (Domain Requirements)」。

總結這張投影片，請記住這個核心觀念：領域需求 (Domain Requirements) 提醒我們，軟體工程需要嚴謹的思維定義與客觀驗證，切勿流於盲目猜測。
-->
---
<!-- header: '第 3 章 | 第 26 題 / 共 31 題 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 3. 需求工程 · 第 26 題</span>
    <span class="quiz-prog">單元：可驗證的非功能性需求指標</span>
  </div>

  <div class="quiz-qbox">
    客戶提出了一個模糊的非功能性目標：*「訂單結帳系統必須具備極致速度與極高可靠度。」* 下列哪一項敘述正確地將此模糊目標轉化為**可驗證、可測試的工程量化指標**？
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="true">
      <span class="q-badge">A</span>
      <span class="q-text">99% 的結帳交易回應時間須 $\le 500$ 毫秒，且尖峰時段系統可用性須達 $\ge 99.95\%$。</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="false">
      <span class="q-badge">B</span>
      <span class="q-text">結帳使用者介面應採用滑順流暢的過場動畫，使顧客在心理層面感受最極致的速度。</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">所有結帳微服務皆須採用記憶體安全程式語言開發，以百分之百確保程式零缺陷執行。</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">雲端資料庫應於尖峰交易負載攀升時，自動配置無上限的隨機存取記憶體 (RAM)。</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 請點選左側選項進行自我檢測</span>
      <span class="btn-retry" style="display: none;">↺ 重新作答</span>
    </div>
    <div class="fb-body">
      <strong>💡 正確答案：A</strong> — 非功能性需求必須具備「客觀可量化與可驗證性」。選項 A 明確定義了 99 百分位延遲低於 500ms、尖峰可用性達 99.95%，使測試團隊能依此設計壓力測試並得出明確判定。
    </div>
  </div>
</div>

<!--
我們來檢視第 26 題：可驗證的非功能性需求指標。

核心問題：客戶提出了一個模糊的非功能性目標：*「訂單結帳系統必須具備極致速度與極高可靠度。」* 下列哪一項敘述正確地將此模糊目標轉化為**可驗證、可測試的工程量化指標**？

正確答案是選項 A：非功能性需求必須具備「客觀可量化與可驗證性」。選項 A 明確定義了 99 百分位延遲低於 500ms、尖峰可用性達 99.95%，使測試團隊能依此設計壓力測試並得出明確判定。

總結這張投影片，請記住這個核心觀念：可驗證的非功能性需求指標 提醒我們，軟體工程需要嚴謹的思維定義與客觀驗證，切勿流於盲目猜測。
-->
---
<!-- header: '第 3 章 | 第 27 題 / 共 31 題 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 3. 需求工程 · 第 27 題</span>
    <span class="quiz-prog">單元：訪談啟發技術與五個為什麼</span>
  </div>

  <div class="quiz-qbox">
    在需求訪談過程中，一位醫院主管堅持要求：*「我們的臨床資訊系統必須導入區塊鏈帳本來記錄病患的生理生命徵象。」* 此時軟體工程師最應採用的專業訪談啟發法為何？
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="true">
      <span class="q-badge">A</span>
      <span class="q-text">運用「五個為什麼 (5 Whys)」探詢其背後的資料防竄改與稽核痛點，而非過早鎖定特定技術。</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="false">
      <span class="q-badge">B</span>
      <span class="q-text">立即針對客戶指定的區塊鏈功能，著手撰寫智慧合約與關聯式資料庫對應綱要。</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">當場直接駁回該主管的要求，因為非技術利害關係人不得主動指定系統的實作架構。</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">禮貌性終止本次訪談流程，並將後續需求擷取工作完全轉向被動的工作場所觀察法。</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 請點選左側選項進行自我檢測</span>
      <span class="btn-retry" style="display: none;">↺ 重新作答</span>
    </div>
    <div class="fb-body">
      <strong>💡 正確答案：A</strong> — 利害關係人往往提出表面技術解法（如區塊鏈），工程師應運用「五個為什麼 (5 Whys)」深掘其背後真正的商業痛點（如稽核紀錄不可篡改），進而給出最適當的工程架構。
    </div>
  </div>
</div>

<!--
我們來檢視第 27 題：訪談啟發技術與五個為什麼。

核心問題：在需求訪談過程中，一位醫院主管堅持要求：*「我們的臨床資訊系統必須導入區塊鏈帳本來記錄病患的生理生命徵象。」* 此時軟體工程師最應採用的專業訪談啟發法為何？

正確答案是選項 A：利害關係人往往提出表面技術解法（如區塊鏈），工程師應運用「五個為什麼 (5 Whys)」深掘其背後真正的商業痛點（如稽核紀錄不可篡改），進而給出最適當的工程架構。

總結這張投影片，請記住這個核心觀念：訪談啟發技術與五個為什麼 提醒我們，軟體工程需要嚴謹的思維定義與客觀驗證，切勿流於盲目猜測。
-->
---
<!-- header: '第 3 章 | 第 28 題 / 共 31 題 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 3. 需求工程 · 第 28 題</span>
    <span class="quiz-prog">單元：民族誌觀察法與內隱知識挖掘</span>
  </div>

  <div class="quiz-qbox">
    在需求工程中，當分析急診室或飛航管制等複雜且高壓的運作環境時，為何**民族誌觀察法 (Ethnography / 職場觀察)** 具備無可取代的關鍵價值？
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="true">
      <span class="q-badge">A</span>
      <span class="q-text">能發掘內隱知識——即使用者已習以為常且視為當然，因而在正式訪談中鮮少主動提及的工作細節與非正式捷徑。</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="false">
      <span class="q-badge">B</span>
      <span class="q-text">能自動將利害關係人的自然語言需求，在完全無須人工介入的情況下直接編譯為可執行的驗收測試套件。</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">能完全消除後續的軟體架構設計、關聯式資料庫建模以及同儕程式碼審查 (Code Review) 等開發階段。</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">能確保所產出的軟體需求規格書在專案的第一個開發衝刺期 (Sprint) 即達成 100% 的數學完全性。</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 請點選左側選項進行自我檢測</span>
      <span class="btn-retry" style="display: none;">↺ 重新作答</span>
    </div>
    <div class="fb-body">
      <strong>💡 正確答案：A</strong> — 現場人員在長期高壓環境下累積的大量工作直覺、非正式流程與緊急捷徑，屬於「內隱知識 (Tacit Knowledge)」，在會議室訪談中極難被主動表述，必須透過實地民族誌觀察法才能發掘。
    </div>
  </div>
</div>

<!--
我們來檢視第 28 題：民族誌觀察法與內隱知識挖掘。

核心問題：在需求工程中，當分析急診室或飛航管制等複雜且高壓的運作環境時，為何**民族誌觀察法 (Ethnography / 職場觀察)** 具備無可取代的關鍵價值？

正確答案是選項 A：現場人員在長期高壓環境下累積的大量工作直覺、非正式流程與緊急捷徑，屬於「內隱知識 (Tacit Knowledge)」，在會議室訪談中極難被主動表述，必須透過實地民族誌觀察法才能發掘。

總結這張投影片，請記住這個核心觀念：民族誌觀察法與內隱知識挖掘 提醒我們，軟體工程需要嚴謹的思維定義與客觀驗證，切勿流於盲目猜測。
-->
---
<!-- header: '第 3 章 | 第 29 題 / 共 31 題 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 3. 需求工程 · 第 29 題</span>
    <span class="quiz-prog">單元：使用案例圖與詳細說明書</span>
  </div>

  <div class="quiz-qbox">
    軟體工程團隊繪製了一份 UML 使用案例圖，標註使用者與「提領現金」使用案例相連。為何工程師除了使用案例圖外，還必須撰寫詳盡的文字型**使用案例說明書 (Use Case Description)**？
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="true">
      <span class="q-badge">A</span>
      <span class="q-text">圖形僅呈現高階系統範疇；文字說明才能完整定義循序步驟、前置條件、後置條件與例外處理流程。</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="false">
      <span class="q-badge">B</span>
      <span class="q-text">現行現代網頁瀏覽器若缺乏伴隨的 Markdown 純文字描述，將完全無法正確渲染 UML 向量圖形。</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">現代編譯器與虛擬機器需要文字型使用案例說明，以便在執行階段預先為角色執行緒配置堆積記憶體。</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">文字型使用案例說明的核心目的，是將非功能性需求自動轉化為前端圖形使用者介面的高傳真原型。</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 請點選左側選項進行自我檢測</span>
      <span class="btn-retry" style="display: none;">↺ 重新作答</span>
    </div>
    <div class="fb-body">
      <strong>💡 正確答案：A</strong> — UML 使用案例圖僅提供宏觀視角展示參與者與功能之關聯；工程師在實作與編寫測試案例時，必須仰賴文字型說明書中所定義的前置條件、主要成功流程與例外處理路徑。
    </div>
  </div>
</div>

<!--
我們來檢視第 29 題：使用案例圖與詳細說明書。

核心問題：軟體工程團隊繪製了一份 UML 使用案例圖，標註使用者與「提領現金」使用案例相連。為何工程師除了使用案例圖外，還必須撰寫詳盡的文字型**使用案例說明書 (Use Case Description)**？

正確答案是選項 A：UML 使用案例圖僅提供宏觀視角展示參與者與功能之關聯；工程師在實作與編寫測試案例時，必須仰賴文字型說明書中所定義的前置條件、主要成功流程與例外處理路徑。

總結這張投影片，請記住這個核心觀念：使用案例圖與詳細說明書 提醒我們，軟體工程需要嚴謹的思維定義與客觀驗證，切勿流於盲目猜測。
-->
---
<!-- header: '第 3 章 | 第 30 題 / 共 31 題 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 3. 需求工程 · 第 30 題</span>
    <span class="quiz-prog">單元：後期需求變更與骨牌效應代價</span>
  </div>

  <div class="quiz-qbox">
    為何在軟體系統交付上線後才修正需求錯誤，其耗費的成本會遠高於在早期開發階段修正？
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="false">
      <span class="q-badge">A</span>
      <span class="q-text">需求規格文件一旦由客戶簽署核准後，在法律上便具有合約鎖定效力而嚴格禁止進行任何修改。</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="true">
      <span class="q-badge">B</span>
      <span class="q-text">後期修正必須耗費大量成本重新設計架構、重寫程式碼、重測並重新部署基於錯誤前提建立的連鎖元件。</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">雲端程式碼儲存庫的自動化編譯器，在軟體發布至正式生產環境後會自動鎖定並阻止程式碼變更。</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">自動化單元測試套件在程式碼封裝並部署至雲端微服務叢集後，將會完全失去其工程驗證的有效性。</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 請點選左側選項進行自我檢測</span>
      <span class="btn-retry" style="display: none;">↺ 重新作答</span>
    </div>
    <div class="fb-body">
      <strong>💡 正確答案：B</strong> — 當需求缺陷逃逸至正式生產環境後，建築於該錯誤之上的架構設計、資料庫綱要、API 介面合約、前端視角與測試套件全都必須打掉重做，引發百倍的骨牌式重工成本。
    </div>
  </div>
</div>

<!--
我們來檢視第 30 題：後期需求變更與骨牌效應代價。

核心問題：為何在軟體系統交付上線後才修正需求錯誤，其耗費的成本會遠高於在早期開發階段修正？

正確答案是選項 B：當需求缺陷逃逸至正式生產環境後，建築於該錯誤之上的架構設計、資料庫綱要、API 介面合約、前端視角與測試套件全都必須打掉重做，引發百倍的骨牌式重工成本。

總結這張投影片，請記住這個核心觀念：後期需求變更與骨牌效應代價 提醒我們，軟體工程需要嚴謹的思維定義與客觀驗證，切勿流於盲目猜測。
-->
---
<!-- header: '第 3 章 | 第 31 題 / 共 31 題 ▾' -->

<div class="quiz-layout">
  <div class="quiz-meta">
    <span class="quiz-tag">Ch 3. 需求工程 · 第 31 題</span>
    <span class="quiz-prog">單元：生成式 AI 在需求工程中的幻覺風險</span>
  </div>

  <div class="quiz-qbox">
    當軟體工程團隊運用大型語言模型 (LLM) 從利害關係人的訪談逐字稿中自動生成需求規格書時，最需要透過「人機協同 (Human-in-the-Loop)」進行驗證的核心風險是什麼？
  </div>

  <div class="quiz-grid">
    <div class="quiz-choice" data-opt="A" data-correct="true">
      <span class="q-badge">A</span>
      <span class="q-text">LLM 可能產生聽起來合理但完全虛構的商業邏輯、遺漏關鍵的邊界約束，或捏造不存在的外部 API 串接。</span>
    </div>
    <div class="quiz-choice" data-opt="B" data-correct="false">
      <span class="q-badge">B</span>
      <span class="q-text">LLM 完全無法產出以 Markdown 清單格式或標準使用者故事 Given-When-Then 語法結構編排的規格文字。</span>
    </div>
    <div class="quiz-choice" data-opt="C" data-correct="false">
      <span class="q-badge">C</span>
      <span class="q-text">LLM 在生成文字時會消耗過量伺服器記憶體，進而導致正式環境中微服務叢集的資料庫發生死結錯誤。</span>
    </div>
    <div class="quiz-choice" data-opt="D" data-correct="false">
      <span class="q-badge">D</span>
      <span class="q-text">LLM 嚴格遵循傳統瀑布式開發流程，因此會堅決拒絕為敏捷疊代衝刺週期生成增量式的需求項目。</span>
    </div>
  </div>

  <div class="quiz-fb state-idle">
    <div class="fb-head">
      <span class="fb-msg">👉 請點選左側選項進行自我檢測</span>
      <span class="btn-retry" style="display: none;">↺ 重新作答</span>
    </div>
    <div class="fb-body">
      <strong>💡 正確答案：A</strong> — 大型語言模型 (LLM) 本質為機率文字預測器而非領域專家，極易產生虛構商業邏輯或遺漏邊界限制的「幻覺 (Hallucination)」，因此在將其產生的規格投入實作前，必須有人類工程師進行嚴謹驗證。
    </div>
  </div>
</div>

<!--
我們來檢視第 31 題：生成式 AI 在需求工程中的幻覺風險。

核心問題：當軟體工程團隊運用大型語言模型 (LLM) 從利害關係人的訪談逐字稿中自動生成需求規格書時，最需要透過「人機協同 (Human-in-the-Loop)」進行驗證的核心風險是什麼？

正確答案是選項 A：大型語言模型 (LLM) 本質為機率文字預測器而非領域專家，極易產生虛構商業邏輯或遺漏邊界限制的「幻覺 (Hallucination)」，因此在將其產生的規格投入實作前，必須有人類工程師進行嚴謹驗證。

總結這張投影片，請記住這個核心觀念：生成式 AI 在需求工程中的幻覺風險 提醒我們，軟體工程需要嚴謹的思維定義與客觀驗證，切勿流於盲目猜測。
-->
---
<!-- _class: lead -->
<!-- header: '自學測驗題庫 ▾ | 測驗圓滿完成' -->

# **🎉 恭喜！已完成全部 31 道核心觀念測驗**
## 成功檢視軟體工程導論、流程模型與需求工程全貌

> 「日日行，不怕千萬里；常常做，不怕千萬事。」 —— 《格言聯璧》

<div class="three-columns" style="margin-top: 25px;">

<div class="card">
  <h3 style="color: #0284c7; margin-bottom: 6px;">📘 複習第一章</h3>
  <p style="font-size: 13.5px; color: #475569;">回顧軟體危機、職責分離、ISO 25010 與工程倫理核心概念。</p>
  <div style="margin-top: 10px;">
    <a href="#4" class="btn-secondary" style="display: inline-block; padding: 4px 12px; font-size: 12.5px; text-decoration: none; border-radius: 4px; border: 1px solid #cbd5e1; background: #fff; color: #0284c7; font-weight: 700;">跳轉至第 01 題 ➔</a>
  </div>
</div>

<div class="card">
  <h3 style="color: #0284c7; margin-bottom: 6px;">⚙️ 複習第二章</h3>
  <p style="font-size: 13.5px; color: #475569;">回顧敏捷宣言、Scrum 儀式、看板 WIP 限制與 TDD 重構回圈。</p>
  <div style="margin-top: 10px;">
    <a href="#14" class="btn-secondary" style="display: inline-block; padding: 4px 12px; font-size: 12.5px; text-decoration: none; border-radius: 4px; border: 1px solid #cbd5e1; background: #fff; color: #0284c7; font-weight: 700;">跳轉至第 10 題 ➔</a>
  </div>
</div>

<div class="card">
  <h3 style="color: #0284c7; margin-bottom: 6px;">📋 複習第三章</h3>
  <p style="font-size: 13.5px; color: #475569;">回顧需求獲取方法、可量化 NFR、使用案例與 AI 幻覺防範。</p>
  <div style="margin-top: 10px;">
    <a href="#29" class="btn-secondary" style="display: inline-block; padding: 4px 12px; font-size: 12.5px; text-decoration: none; border-radius: 4px; border: 1px solid #cbd5e1; background: #fff; color: #0284c7; font-weight: 700;">跳轉至第 24 題 ➔</a>
  </div>
</div>

</div>

<!--
恭喜你完成《進階軟體工程》全部 31 道核心觀念題的自學挑戰！

你已經完整檢驗了導論、軟體流程模型與需求工程三大模組的核心精髓。

若在剛才的作答中有任何題目經過多次嘗試才答對，強烈建議點選上方卡片返回該題再次複習，直到能純熟解構背後的工程原理。

總結這張投影片，請記住這個核心觀念：主動的自我檢驗所建立的強韌直覺，將在未來的專案架構與系統開發中成為你最強大的工程後盾。
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
