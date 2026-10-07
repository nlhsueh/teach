---
marp: true
theme: quiz-theme
paginate: true
header: 'UX Design 綜合題庫: 全章節實戰測驗與核心解析'
footer: '薛念林 教授 | 逢甲大學資訊工程學系'
size: 16:9
transition: fade
html: true

---

<!-- _class: lead -->
<!-- _header: '' -->
# 全課程易用性與互動設計實戰題庫
## 24 題即時互動測驗、作答回饋與深度解析

**薛念林 教授**
逢甲大學 資訊工程學系

*涵蓋 UCD 導論、尼爾森 10 大原則、AI for UX、UX for AI 與 Tidwell 設計模式*

---

<!-- header: '本題庫大綱 (Outline)' -->

## 本題庫大綱 (Outline)

<div class="two-columns">
<div class="card">

### 📘 前半部：基礎概念與尼爾森原則
- **[Part 1: 使用者體驗導論實戰測驗 (Q01 ~ Q03)](#4)**
  - UX vs UI 界線、UCD 核心心法、雙鑽石設計模型
- **[Part 2: 尼爾森 10 大原則與 AI-UX 測驗 (Q04 ~ Q13)](#8)**
  - NS01 狀態能見度 ~ NS09 錯誤復原全情境題
  - 1-10-100 品質成本法則與 RTCF 提示框架

</div>
<div class="card">

### 🚀 後半部：AI 體驗與設計模式
- **[Part 3: UX for AI 體驗設計與 Agent 轉移 (Q14 ~ Q18)](#19)**
  - 上下文孤島、Planning Mode、閉環驗證、信心度與優雅降級
- **[Part 4: Tidwell 介面設計模式精選 (Q19 ~ Q24)](#25)**
  - Wizard 精靈、Deep Linking、Accordion、Breadcrumbs、Card List 等實戰題

</div>
</div>

---

<!-- header: 'Part 1: 使用者體驗導論實戰測驗 (Q01 ~ Q03)' -->

<!-- _class: part-cover -->
# Part 1: 使用者體驗導論實戰測驗 (Q01 ~ Q03)
## 從 UX 基礎心法到使用者中心設計 (UCD) 雙鑽石架構

---

<!-- header: 'Part 1: 使用者體驗導論實戰測驗 (Q01 ~ Q03)' -->

## ❓ Part 1 · 第 01 題：【UX 與 UI 的核心界線】

某新創團隊在開發一款智慧健康管理 App。前端工程師認為只要套用最時髦的 UI 視覺元件庫、漸層色與微動畫，就能保證使用者擁有極佳的產品體驗。 依據本課程對 UX (User Experience) 與 UI (User Interface) 的本質定義，下列哪一項敘述最為正確？

- (A) UI 設計優美即等於卓越的 UX，兩者本質完全相同
- (B) UI 聚焦於外觀視覺與互動觸點，UX 則涵蓋使用者在使用全過程中的整體感受、易用性與價值實現
- (C) UX 僅屬於後端工程師與產品經理的責任，UI 設計師不必涉入
- (D) UX 只能透過大量的 A/B 測試來定義，無法在前期進行使用者研究

> **💡 正確答案：(B)**
> UI (User Interface) 是介面外觀、色彩、排版與按鈕樣式等具體視覺與互動觸點；而 UX (User Experience) 則是使用者在與系統互動全程所感受到的整體滿意度、認知摩擦與問題解決程度。漂亮的 UI 若流程繁瑣或無法解決使用者問題，仍是糟糕的 UX。

---

<!-- header: 'Part 1: 使用者體驗導論實戰測驗 (Q01 ~ Q03)' -->

## ❓ Part 1 · 第 02 題：【使用者中心設計 (UCD) 核心心法】

傳統軟體工程中常發生的「溝通代溝」，多半源於工程團隊直接依據數十頁文字規格書 (PRD) 埋頭開發，數月後交付時才發現與客戶期望大相逕庭，修改成本極高。 使用者中心設計 (User-Centered Design, UCD) 主張的核心做法為何？

- (A) 嚴格禁止客戶在交付驗收前查看任何開發中的半成品與原型
- (B) 盡可能在專案前期透過訪談、雛形 (Prototypes) 與可用性測試讓真實使用者參與，並進行快速迭代
- (C) 全權交由資深軟體架構師憑工程直覺定義使用者的最佳操作流程
- (D) 將所有心力放在後端資料庫的正規化，介面待上線後再交給外包修改

> **💡 正確答案：(B)**
> UCD 強調「以人為本」，主張在軟體生命週期早期就必須引進真實使用者的回饋，透過低保真 (Low-fi) 與高保真 (High-fi) 雛形走查驗證需求，早期發現問題，避免在後期付出高昂的修改成本。

---

<!-- header: 'Part 1: 使用者體驗導論實戰測驗 (Q01 ~ Q03)' -->

## ❓ Part 1 · 第 03 題：【雙鑽石設計模型 (Double Diamond)】

英國設計委員會 (Design Council) 提出的雙鑽石設計模型 (Double Diamond) 是 UX 與軟體工程創新極為推崇的架構，強調「發散 (Diverge)」與「收斂 (Converge)」的交替運用。 請問雙鑽石模型的四個核心階段依序為何？

- (A) 發想 (Discover) ➔ 定義 (Define) ➔ 開發 (Develop) ➔ 交付 (Deliver)
- (B) 編碼 (Code) ➔ 測試 (Test) ➔ 部署 (Deploy) ➔ 監控 (Monitor)
- (C) 需求 (PRD) ➔ 繪製 (Figma) ➔ 切版 (HTML) ➔ 上線 (Launch)
- (D) 訪談 (Interview) ➔ 繪圖 (Sketch) ➔ 會議 (Meeting) ➔ 結案 (Close)

> **💡 正確答案：(A)**
> 雙鑽石由兩個鑽石組成：第一個鑽石「做對的事情」(Discover 發散探索問題領域 ➔ Define 收斂定義真實痛點)；第二個鑽石「把事情做好」(Develop 發散探索解決方案 ➔ Deliver 收斂交付測試驗證)。

---

<!-- header: 'Part 2: 尼爾森 10 大原則與 AI 提示工程 (Q04 ~ Q13)' -->

<!-- _class: part-cover -->
# Part 2: 尼爾森 10 大原則與 AI 提示工程 (Q04 ~ Q13)
## 啟發式評估十準則、AI 介面防呆與約束式提示工程

---

<!-- header: 'Part 2: 尼爾森 10 大原則與 AI 提示工程 (Q04 ~ Q13)' -->

## ❓ Part 2 · 第 04 題：【NS01 系統狀態能見度 (Visibility of System Status)】

某雲端硬碟在使用者上傳 100 張高清相片時，介面不僅顯示「已完成 42/100 張 (42%)」，還以微步進進度條即時提示預估剩餘時間與上傳速率，而非只有靜態的等待圖示。 請問這項設計最直接符合哪一項尼爾森原則？

- (A) NS01 系統狀態能見度 (Visibility of System Status)
- (B) NS02 真實世界與系統對應 (Match Between System and the Real World)
- (C) NS04 一致性與標準 (Consistency and Standards)
- (D) NS08 美學與簡約設計 (Aesthetic and Minimalist Design)

> **💡 正確答案：(A)**
> NS01 要求系統應在合理時間內，透過適當的反饋（如進度條、完成百分比、剩餘時間），隨時讓使用者清楚掌握目前狀態，消除等待時「是否當機或斷線」的未知焦慮。

---

<!-- header: 'Part 2: 尼爾森 10 大原則與 AI 提示工程 (Q04 ~ Q13)' -->

## ❓ Part 2 · 第 05 題：【NS02 真實世界與系統對應 (Match Between System and Real World)】

電子書閱讀 App 在翻頁時模擬紙本書籍的翻頁動畫與紙張摩擦音效，並將收藏書籍的分類介面設計成木質書架，刪除檔案則使用「丟入桌面垃圾桶」的動作。 請問這項設計最能體現哪一項原則？

- (A) NS01 系統狀態能見度 (Visibility of System Status)
- (B) NS02 真實世界與系統對應 (Match Between System and the Real World)
- (C) NS06 易於識別而非記憶 (Recognition Rather than Recall)
- (D) NS07 彈性與使用效率 (Flexibility and Efficiency of Use)

> **💡 正確答案：(B)**
> NS02 要求系統說使用者的日常語言，使用通俗熟悉詞彙，並遵循真實世界的物理習慣與邏輯隱喻（如木質書架、翻頁效果與實體垃圾桶），降低使用者的心智轉譯負擔。

---

<!-- header: 'Part 2: 尼爾森 10 大原則與 AI 提示工程 (Q04 ~ Q13)' -->

## ❓ Part 2 · 第 06 題：【NS03 使用者控制與自由 (User Control and Freedom)】

使用者在郵件軟體中誤將 50 封重要信件整批選取並點擊「刪除」。系統立即在底部浮現橫幅：「已將 50 封郵件移至垃圾桶 [復原 (Undo)]」，並持續顯示 10 秒供隨時點擊復原。 請問這項設計符合哪一項原則？

- (A) NS03 使用者控制與自由 (User Control and Freedom)
- (B) NS05 錯誤預防 (Error Prevention)
- (C) NS08 美學與簡約設計 (Aesthetic and Minimalist Design)
- (D) NS10 說明文件與輔助 (Help and Documentation)

> **💡 正確答案：(A)**
> NS03 指出使用者常會因誤觸功能而出錯，系統必須提供清晰標記的「緊急出口」（Emergency Exit）與支援 Undo/Redo 的反悔機制，讓使用者能自主掌控全局而不致恐慌。

---

<!-- header: 'Part 2: 尼爾森 10 大原則與 AI 提示工程 (Q04 ~ Q13)' -->

## ❓ Part 2 · 第 07 題：【NS04 一致性與標準 (Consistency and Standards)】

某跨平台系統在 iOS App 遵循蘋果 HIG 將主導覽列置於底部，在桌面 Web 遵循頂部 Header 導航；全站無論在哪個頁面，「加入購物車」一律是深橘色按鈕、「立即結帳」一律是綠色按鈕，危險操作一律是紅色文字。 請問這項設計主要符合哪一項原則？

- (A) NS03 使用者控制與自由 (User Control and Freedom)
- (B) NS04 一致性與標準 (Consistency and Standards)
- (C) NS06 易於識別而非記憶 (Recognition Rather than Recall)
- (D) NS09 協助辨識與復原錯誤 (Help Users Recover from Errors)

> **💡 正確答案：(B)**
> NS04 要求系統遵循平台的既定慣例（如 iOS 與 Web 的標準）與全站統一的視覺規範（Design System）。相同的文字、色彩與按鈕在不同頁面具備一致意義，能有效降低使用者的學習門檻。

---

<!-- header: 'Part 2: 尼爾森 10 大原則與 AI 提示工程 (Q04 ~ Q13)' -->

## ❓ Part 2 · 第 08 題：【NS05 錯誤預防 (Error Prevention)】

在訂房系統的表單中，當使用者選擇「入住日期：2026/10/15」後，系統會自動將「退房日期」選擇器中早於 10/15 的所有日期設為灰色反灰且不可點選狀態。 請問這項設計的核心價值為何？

- (A) 屬於 NS05 錯誤預防，防範不合理的輸入與操作於未然
- (B) 屬於 NS09 錯誤復原，在使用者輸入錯誤後跳出警告視窗
- (C) 屬於 NS10 說明文件，教導使用者如何正確看懂日曆
- (D) 屬於 NS01 狀態能見度，告知使用者目前資料庫的空房數量

> **💡 正確答案：(A)**
> NS05 主張「預防勝於治療」。比起在使用者送出非法日期後拋出錯誤對話框，更好的設計是在輸入時直接透過介面約束 (Constraints) 將錯誤發生的機會消除於萌芽階段。

---

<!-- header: 'Part 2: 尼爾森 10 大原則與 AI 提示工程 (Q04 ~ Q13)' -->

## ❓ Part 2 · 第 09 題：【NS06 易於識別而非記憶 (Recognition Rather than Recall)】

在電商網站搜尋時，輸入框下方自動列出使用者「最近搜尋過的關鍵字」與「最近瀏覽過的 5 件商品」，且在比較多款筆電時提供並排規格比較表。 請問這項設計主要符合哪一項原則？

- (A) NS02 真實世界與系統對應
- (B) NS06 易於識別而非記憶 (Recognition Rather than Recall)
- (C) NS07 彈性與使用效率
- (D) NS04 一致性與標準

> **💡 正確答案：(B)**
> 人類大腦擅長辨識 (Recognition) 而不擅長憑空回憶 (Recall)。將選項、動作與歷史紀錄直接呈現在眼前，使用者「看見就能點選」，可大幅減輕記憶負擔。

---

<!-- header: 'Part 2: 尼爾森 10 大原則與 AI 提示工程 (Q04 ~ Q13)' -->

## ❓ Part 2 · 第 10 題：【NS07 彈性與使用效率 (Flexibility and Efficiency of Use)】

圖形設計工具為新手提供視覺化圖示工具列與步驟指引精靈，同時為資深專家提供大量的單鍵快捷鍵（如 V 選擇、B 筆刷、Cmd+J 複製圖層）與自訂批次巨集功能。 請問這項設計符合哪一項原則？

- (A) NS03 使用者控制與自由
- (B) NS07 彈性與使用效率 (Flexibility and Efficiency of Use)
- (C) NS08 美學與簡約設計
- (D) NS05 錯誤預防

> **💡 正確答案：(B)**
> NS07 要求系統兼顧新手與專家的不同步調。新手可以循序漸進點選按鈕，而高頻資深專家則能透過快捷加速器 (Accelerators) 實現極致的操作效率。

---

<!-- header: 'Part 2: 尼爾森 10 大原則與 AI 提示工程 (Q04 ~ Q13)' -->

## ❓ Part 2 · 第 11 題：【NS08 美學與簡約設計 (Aesthetic and Minimalist Design)】

某資訊看板將數百條未分類的各類數據無差別全部堆砌在首頁，充斥五顏六色的圖表與閃爍字體，使用者難以找到重點。依據 NS08 原則，最佳改善方案為何？ 下列哪一項改善策略最符合 NS08 美學與簡約設計？

- (A) 在頁面頂部加上一個搜尋框即可，首頁內容保持不變
- (B) 建立明確的資訊層級，預設僅展示 3 個核心指標卡片與精簡摘要，其餘細節提供「展開查看完整推演」
- (C) 增加更多跳轉連結與側邊欄廣告以塞滿留白空間
- (D) 將字體全部改為超小字級以塞下更多圖表

> **💡 正確答案：(B)**
> NS08 指出介面不應包含無關或極少需要的資訊。每一個額外的雜訊都會與真正重要的資訊競爭注意力。適當留白、預設折疊與清楚的層級收納是簡約美學的核心。

---

<!-- header: 'Part 2: 尼爾森 10 大原則與 AI 提示工程 (Q04 ~ Q13)' -->

## ❓ Part 2 · 第 12 題：【NS09 協助辨識、診斷與從錯誤中復原】

使用者在註冊網站填寫密碼時若長度不足，下列哪一種介面反饋方式最符合 NS09 的優良設計實踐？ 下列哪一種錯誤反饋方式最符合 NS09 原則？

- (A) 彈出警示對話框顯示：Error Code: 0x8004005 Validation Failure
- (B) 僅在輸入框周圍亮紅框，但不給予任何文字說明
- (C) 在密碼框下方即時以紅字清晰提示：「密碼長度不足，至少需包含 8 個字元與 1 個數字」，並標出尚缺條件
- (D) 靜默重設整個表單，強迫使用者從姓名重新填寫

> **💡 正確答案：(C)**
> NS09 要求錯誤訊息必須以清楚淺白的日常語言呈現，嚴禁直接拋出底層錯誤碼；更重要的是必須精確指出問題所在，並建設性地給予復原指引，引導使用者完成正確操作。

---

<!-- header: 'Part 2: 尼爾森 10 大原則與 AI 提示工程 (Q04 ~ Q13)' -->

## ❓ Part 2 · 第 13 題：【1-10-100 法則與 RTCF 提示框架】

軟體工程中的「1-10-100 品質成本法則」強調前期預防的重要性。而在運用 AI 生成符合 UX 規範的組件時，RTCF 框架能確保輸出品質。 關於 1-10-100 法則與 RTCF 提示詞架構，下列哪一項敘述正確？

- (A) 1-10-100 代表開發速度需提升 100 倍；RTCF 代表 Run, Test, Code, Fix
- (B) 1-10-100 指在需求/UX 階段修正花 1 元，後期修改成本呈指數劇增；RTCF 為 Role（角色）、Task（任務）、Constraint（約束）、Few-shots（少樣本）
- (C) 1-10-100 指預算分配比例；RTCF 指 React, TypeScript, CSS, Figma
- (D) 1-10-100 指 A/B 測試人數；RTCF 代表 Return, Throw, Catch, Finally

> **💡 正確答案：(B)**
> 1-10-100 法則證明了前期 UX 確認的極高價值（前期改花 1 元，上線後改花 100 元）；而在使用 AI 協同設計 UI 時，透過 RTCF 框架定義明確的約束 (Constraint) 能確保 AI 生成程式碼符合可用性標準。

---

<!-- header: 'Part 3: UX for AI 體驗設計與 Agent 轉移 (Q14 ~ Q18)' -->

<!-- _class: part-cover -->
# Part 3: UX for AI 體驗設計與 Agent 轉移 (Q14 ~ Q18)
## 從黑盒子走向透明人機協同，Agentic 閉環與優雅降級

---

<!-- header: 'Part 3: UX for AI 體驗設計與 Agent 轉移 (Q14 ~ Q18)' -->

## ❓ Part 3 · 第 14 題：【傳統對話型 Prompting 的上下文孤島】

在複雜軟體開發中，傳統「在網頁對話框 (Chat UI) 反覆複製貼上 Prompt」的協同模式，常讓開發者感到效率低落且繁瑣。 請問這最能說明傳統對話型 Prompting 的哪一項核心局限？

- (A) 大型語言模型的推理速度過慢
- (B) 上下文孤島 (Context Silo) 與缺乏全專案視野，AI 無法主動調用工具驗證成果
- (C) 模型欠缺基本的程式碼語法檢查能力
- (D) 對話介面無法輸出超過 50 行的文字

> **💡 正確答案：(B)**
> 傳統 Chat Prompting 的 AI 被困在單一對話框中，無法直接感知整個專案的目錄架構、相依性與執行環境，且無法自主驗證修改是否引發編譯報錯，迫使工程師成為人工搬運工。

---

<!-- header: 'Part 3: UX for AI 體驗設計與 Agent 轉移 (Q14 ~ Q18)' -->

## ❓ Part 3 · 第 15 題：【Agent 規劃優先原則 (Planning Mode)】

Google Antigravity IDE 等現代 Agentic AI 開發環境在處理大型任務時，提倡「Planning Mode（規劃審查模式）」。 請問 Planning Mode 的核心人機協同優勢為何？

- (A) 讓 AI 在完全不通知使用者的情況下直接覆寫所有程式碼
- (B) 在動手修改前，先梳理架構脈絡並生成多步驟實施藍圖供工程師審查審核，確保方向正確後再執行
- (C) 強制將所有後端邏輯轉寫為 Python 腳本
- (D) 限制 AI 每次只能修改一行程式碼以節省 Token

> **💡 正確答案：(B)**
> Planning Mode 體現了以人為本的人機協同：在進入破壞性執行前，先產出清晰的步驟藍圖與風險評估，讓人類具備充分的知情權與控制權（Approve/Reject/Edit），避免失控修改。

---

<!-- header: 'Part 3: UX for AI 體驗設計與 Agent 轉移 (Q14 ~ Q18)' -->

## ❓ Part 3 · 第 16 題：【閉環驗證與自主走查 (Feedback Loop)】

Agentic 軟體工程強調 AI 的自主執行能力與自我修正機制。 下列哪一項行為最能說明 Agentic 模式的「閉環驗證 (Feedback Loop)」？

- (A) AI 生成程式碼後直接向使用者宣布任務完成，不進行任何測試
- (B) AI 生成修改後，自主調用終端機執行編譯與單元測試，若遇錯誤則讀取堆疊日誌自我修正，直至測試全數通過
- (C) AI 隨機挑選檔案刪除以測試系統的容錯能力
- (D) 遇到錯誤時直接終止任務並要求使用者重新開新對話

> **💡 正確答案：(B)**
> 閉環驗證是 Agent 區別於傳統單向輸出的關鍵。 Agent 具備工具調用能力（Tool Use），能在沙盒中自動執行編譯指令或單元測試，遇到錯誤自主修復，形成「生成 ➔ 驗證 ➔ 診斷 ➔ 修正」的自治閉環。

---

<!-- header: 'Part 3: UX for AI 體驗設計與 Agent 轉移 (Q14 ~ Q18)' -->

## ❓ Part 3 · 第 17 題：【AI 信心度 (Confidence Score) 與防呆信任】

在醫療輔助診斷、財務風控或法律諮詢等高風險 AI 系統中，介面設計應如何處理 AI 的分析結果，以防範使用者「過度信任 (Over-reliance)」？ 下列哪一項設計最符合 UX for AI 的防呆信任架構？

- (A) 一律以 100% 絕對篤定的語氣宣稱診斷無誤，以建立使用者無條件的信任
- (B) 呈現結果時附帶信心度指標（如：信心度 72%）、備選方案與推論依據，並提醒使用者進行專業交叉核對
- (C) 隱藏所有推論過程，只顯示最後的處方籤
- (D) 強制使用者在 3 秒內接受 AI 的建議否則鎖定系統

> **💡 正確答案：(B)**
> 過度信任是 AI 互動設計的重大隱憂。透過誠實揭露信心水準、列出替代解釋並提醒人類審查，能保持使用者批判性思維，避免因盲信 AI 幻覺而釀成重大事故。

---

<!-- header: 'Part 3: UX for AI 體驗設計與 Agent 轉移 (Q14 ~ Q18)' -->

## ❓ Part 3 · 第 18 題：【AI 服務異常的優雅降級 (Graceful Degradation)】

當大型語言模型處理長文本發生網路連線超時 (Timeout) 或 API 額度過載時，介面應如何向使用者反饋？ 下列哪一種設計最符合 UX for AI 的優雅降級 (Graceful Degradation)？

- (A) 畫面直接崩潰變白，並在控制台拋出 HTTP 504 Gateway Timeout
- (B) 白話告知連線超時、自動暫存使用者已輸入的 Prompt 與上傳文件，並提供「一鍵重試」與「自動分段處理」建議按鈕
- (C) 彈出警示框責備使用者的網路環境不佳
- (D) 自動刪除所有對話紀錄以釋放記憶體

> **💡 正確答案：(B)**
> 優雅降級在 AI 服務中至關重要。當底層 API 斷線或過載，系統應妥善保護使用者輸入的資料資產，並以建設性的行動選項協助復原，絕不可拋出未經包裝的底層狀態碼。

---

<!-- header: 'Part 4: Tidwell 介面設計模式精選測驗 (Q19 ~ Q24)' -->

<!-- _class: part-cover -->
# Part 4: Tidwell 介面設計模式精選測驗 (Q19 ~ Q24)
## 經典 UI 模式庫：導覽架構、多步驟表單與空間收納

---

<!-- header: 'Part 4: Tidwell 介面設計模式精選測驗 (Q19 ~ Q24)' -->

## ❓ Part 4 · 第 19 題：【Wizard 步驟精靈模式】

依據 Tidwell 介面設計模式，當使用者面對線上綜合所得稅申報、複雜帳號註冊等具備高認知負擔且具嚴格先後順序的多步驟任務時。 請問最推薦採用的模式為何？

- (A) Accordion (手風琴)
- (B) Wizard (步驟精靈模式)
- (C) Deep Linking (深層連結)
- (D) Infinite Scroll (無限滾動)

> **💡 正確答案：(B)**
> Wizard 模式將複雜龐大的長表單拆解成數個邏輯連貫的線性步驟（如：身分驗證 ➔ 收入確認 ➔ 扣除額計算 ➔ 繳稅確認），並搭配進度步進器，大幅降低使用者的認知負荷與出錯率。

---

<!-- header: 'Part 4: Tidwell 介面設計模式精選測驗 (Q19 ~ Q24)' -->

## ❓ Part 4 · 第 20 題：【Deep Linking 深層連結模式】

某企業知識庫系統包含數百篇長篇技術文件與多層級 API 規範。工程師希望能直接將文件中某個具體章節或特定程式碼區塊的 URL 複製分享給同事，點擊後頁面能自動精準滾動至該段落。 請問這體現了哪種 Tidwell 模式？

- (A) Deep Linking (深層連結)
- (B) Modal Dialog (強制對話框)
- (C) Carousels (輪播卡片)
- (D) Breadcrumbs (麵包屑)

> **💡 正確答案：(A)**
> Deep Linking（深層連結）為頁面內的特定錨點、狀態或子內容提供唯一的 URL。使用者點擊後能直接精準抵達該特定內容，極大促進協同合作與知識分享效率。

---

<!-- header: 'Part 4: Tidwell 介面設計模式精選測驗 (Q19 ~ Q24)' -->

## ❓ Part 4 · 第 21 題：【Accordion 手風琴模式】

在行動端或空間受限的設定頁面中，若有 10 個互不干擾的偏好設定項目（如：隱私設定、通知頻率、主題色彩等），設計師希望使用者能在單一視窗中瀏覽所有項目大綱，並僅在需要時就地展開細節。 請問最合適的模式為？

- (A) Accordion (手風琴 / 折疊卡片)
- (B) Wizard (步驟精靈)
- (C) Splash Screen (啟動閃屏)
- (D) Pagination (多頁分頁)

> **💡 正確答案：(A)**
> Accordion 模式透過垂直堆疊的標題欄，允許使用者點擊「就地展開/收攏」感興趣的內容區塊，在極度節省垂直螢幕空間的同時，維持宏觀概覽與微觀細節的兼顧。

---

<!-- header: 'Part 4: Tidwell 介面設計模式精選測驗 (Q19 ~ Q24)' -->

## ❓ Part 4 · 第 22 題：【Breadcrumbs 麵包屑導航】

在多層級大型電商網站（如：首頁 > 3C 數位 > 筆記型電腦 > 輕薄商務筆電）中，使用者常常在深層商品頁面迷失方向。在標題上方常駐提供階層路徑的模式稱為什麼？ 請問這項設計模式稱為什麼？

- (A) Breadcrumbs (麵包屑導航)
- (B) Tree View (樹狀目錄)
- (C) Hamburger Menu (漢堡選單)
- (D) Toast Notification (吐司提示)

> **💡 正確答案：(A)**
> Breadcrumbs（麵包屑導航，源自童話《糖果屋》灑麵包屑認路）清晰顯示使用者在全站階層樹狀架構中所處的精確位置，並提供各父層級的一鍵回溯路徑，是層級導航的經典模式。

---

<!-- header: 'Part 4: Tidwell 介面設計模式精選測驗 (Q19 ~ Q24)' -->

## ❓ Part 4 · 第 23 題：【Card List 卡片清單模式】

現代社群平台（如 Instagram、Pinterest、Facebook 動態消息）與專案看板（Trello），普遍採用「Card（卡片）」樣式來呈現單元內容。 請問卡片模式 (Card List) 廣受青睞的核心優勢為何？

- (A) 因為卡片樣式強制只能容納文字，不可放置圖片或影片
- (B) 因為卡片將異質資訊（圖片、標題、作者、點讚數、留言）封裝成一個自給自足的獨立視覺單元，便於在不同螢幕尺寸間靈活重組排版
- (C) 因為卡片樣式無法點擊，能防止使用者誤觸
- (D) 因為卡片樣式只適用於橫向列印

> **💡 正確答案：(B)**
> Card（卡片）是現代響應式設計 (RWD) 的基石。它將異質且相關的資訊封裝為一體，具有極高的模組化特性，在多欄網格、單欄滾動或瀑布流中皆能完美適應。

---

<!-- header: 'Part 4: Tidwell 介面設計模式精選測驗 (Q19 ~ Q24)' -->

## ❓ Part 4 · 第 24 題：【Time-Slot Picker / Data Sheet 數據表格模式】

台灣高鐵購票系統在查詢某日車次時，呈現矩陣清單標明「車次、出發時間、抵達時間、自由座餘額、早鳥折扣」，並允許使用者直接點選切換前一班或後一班車次。 這最直接體現了 Tidwell 的哪種設計心法？

- (A) 透過直覺的數據表格 (Data Sheet) 與時間時段選擇器 (Time-Slot Picker) 消除認知負荷，讓使用者在單一脈絡下進行多維度方案比對與決策
- (B) 強迫使用者記憶每一班車的列車編號才能輸入訂票
- (C) 隱藏票價資訊，直到使用者輸入信用卡付款後才揭示
- (D) 限制使用者每次查詢只能查看一班列車

> **💡 正確答案：(A)**
> 數據表格與時段選擇器將繁雜的多維度選項（班次、時間、票價、餘額）平鋪並置，使用者不必反覆跳出頁面，即可在同一個畫面上比較優劣並做出最佳決策，顯著提升操作效率與體驗。

---

<!-- header: '題庫完成與學習成效自我檢視' -->

## 🎓 題庫完成與學習成效自我檢視

### 📊 自我測驗成效評估
- **21 ~ 24 題正確 (卓越 / 專家級)** ：
  - 徹底融會貫通 UX 原理、尼爾森 10 大原則與 AI 工具實務，具備優秀的軟體產品架構與評估能力！
- **16 ~ 20 題正確 (良好 / 穩健級)** ：
  - 掌握絕大多數核心觀念，建議複習答錯的題目並回顧 Unit 02 與 Unit 03 的案例對照。
- **15 題以下 (需加強 / 觀念釐清)** ：
  - 建議重溫 Unit 01 ~ Unit 04 投影片，加強體會「以人為本」的人機協同理念。

### 💡 學習三大關鍵要訣
1. **不要只看美觀 (UI)** ：時刻牢記 1-10-100 法則，前期做好 UX 規劃價值百倍。
2. **永遠給予控制權 (NS03/NS09)** ：AI 與系統充滿不確定性，緊急出口與白話復原是信任基石。
3. **動手實作閉環 (Agentic)** ：善用 Google Antigravity IDE、Planning Mode 與設計樣式庫，將理論落實於真實工程專案中！

<script>
(function() {
  function initHeaderDropdown() {
    const sections = [];
    const seenTitles = new Set();
    const slideSections = document.querySelectorAll('section[id]');
    
    slideSections.forEach(sec => {
      const header = sec.querySelector('header');
      if (!header) return;
      let title = header.textContent.trim();
      title = title.replace(/^[◄◀]\s*/, '').replace(/\s*[►▶]$/, '').trim();
      if (!title || seenTitles.has(title)) return;
      seenTitles.add(title);
      sections.push({ id: sec.id, title: title });
    });

    if (sections.length === 0) return;

    function createDropdownWrapper(currentTitle) {
      const wrapper = document.createElement('span');
      wrapper.className = 'header-nav-wrapper';
      
      const titleSpan = document.createElement('span');
      titleSpan.className = 'header-nav-title';
      titleSpan.title = '點擊固定或懸停查看題庫章節目錄';
      titleSpan.innerHTML = currentTitle + '<span class="nav-caret"> ▾</span>';
      
      titleSpan.addEventListener('click', function(e) {
        e.stopPropagation();
        const wasOpen = wrapper.classList.contains('is-open');
        document.querySelectorAll('.header-nav-wrapper.is-open').forEach(w => w.classList.remove('is-open'));
        if (!wasOpen) wrapper.classList.add('is-open');
      });
      
      const dropdown = document.createElement('div');
      dropdown.className = 'nav-dropdown';
      dropdown.addEventListener('click', function(e) { e.stopPropagation(); });
      
      const dropHeader = document.createElement('div');
      dropHeader.className = 'nav-dropdown-header';
      dropHeader.innerHTML = '<span>📑 題庫章節目錄</span><span style="font-size:11px;font-weight:normal;color:#64748b;">共 ' + sections.length + ' 個單元</span>';
      dropdown.appendChild(dropHeader);
      
      const grid = document.createElement('div');
      grid.className = 'nav-dropdown-grid';
      sections.forEach(s => {
        const item = document.createElement('a');
        const isActive = (s.title === currentTitle);
        item.className = 'nav-dropdown-item' + (isActive ? ' active' : '');
        item.href = '#' + s.id;
        item.innerHTML = '<span class="badge">#' + s.id.padStart(2, '0') + '</span><span class="item-text" title="' + s.title + '">' + s.title + '</span>';
        item.addEventListener('click', function() {
          wrapper.classList.remove('is-open');
        });
        grid.appendChild(item);
      });
      
      dropdown.appendChild(grid);
      wrapper.appendChild(titleSpan);
      wrapper.appendChild(dropdown);
      return wrapper;
    }

    document.addEventListener('click', function(e) {
      if (!e.target.closest('.header-nav-wrapper')) {
        document.querySelectorAll('.header-nav-wrapper.is-open').forEach(w => w.classList.remove('is-open'));
      }
    });

    slideSections.forEach(sec => {
      const header = sec.querySelector('header');
      if (!header || header.dataset.navEnhanced) return;
      header.dataset.navEnhanced = 'true';
      let title = header.textContent.trim();
      title = title.replace(/^[◄◀]\s*/, '').replace(/\s*[►▶]$/, '').trim();
      if (!title) return;
      header.innerHTML = '';
      const wrapper = createDropdownWrapper(title);
      header.appendChild(wrapper);
    });
  }

  function initQuizInteractions() {
    const slideSections = document.querySelectorAll('section[id]');
    slideSections.forEach(sec => {
      if (sec.dataset.quizInit) return;
      const ul = sec.querySelector('ul');
      const bq = sec.querySelector('blockquote');
      const h2 = sec.querySelector('h2');
      if (!ul || !bq) return;
      
      const bqText = bq.textContent || '';
      const ansMatch = bqText.match(/正確答案\s*[:：]?\s*\(?([A-D])\)?/i);
      if (!ansMatch) return;
      
      sec.dataset.quizInit = 'true';
      sec.classList.add('has-quiz');
      const correctOpt = ansMatch[1].toUpperCase();

      const qPs = [];
      let curr = h2 ? h2.nextElementSibling : sec.firstElementChild;
      while (curr && curr !== ul && curr !== bq) {
        if (curr.tagName === 'P') qPs.push(curr);
        curr = curr.nextElementSibling;
      }

      const quizLayout = document.createElement('div');
      quizLayout.className = 'quiz-layout';

      const metaDiv = document.createElement('div');
      metaDiv.className = 'quiz-meta';
      let rawTitle = h2 ? h2.textContent.trim() : '';
      let tagText = '隨堂測驗';
      let progText = '';
      const titleMatch = rawTitle.match(/(?:❓\s*)?(.*?)[：:](.*)/);
      if (titleMatch) {
        tagText = titleMatch[1].trim();
        progText = titleMatch[2].replace(/[【】]/g, '').trim();
      } else {
        tagText = rawTitle;
      }
      metaDiv.innerHTML = '<span class="quiz-tag">' + tagText + '</span>' + 
        (progText ? '<span class="quiz-prog">單元：' + progText + '</span>' : '');
      quizLayout.appendChild(metaDiv);

      const qbox = document.createElement('div');
      qbox.className = 'quiz-qbox';
      qPs.forEach(p => { qbox.innerHTML += p.innerHTML; });
      quizLayout.appendChild(qbox);

      const grid = document.createElement('div');
      grid.className = 'quiz-grid';
      const items = ul.querySelectorAll(':scope > li');
      const choices = [];

      items.forEach(li => {
        const text = li.textContent.trim();
        const m = text.match(/^\s*\(?([A-D])\)?[.、\s]?(.*)$/i);
        const opt = m ? m[1].toUpperCase() : '';
        const choiceText = m ? m[2].trim() : text;
        const isCorrect = (opt === correctOpt);

        const choiceDiv = document.createElement('div');
        choiceDiv.className = 'quiz-choice';
        choiceDiv.dataset.opt = opt;
        choiceDiv.dataset.correct = isCorrect ? 'true' : 'false';
        choiceDiv.innerHTML = '<span class="q-badge">' + opt + '</span><span class="q-text">' + choiceText + '</span>';
        grid.appendChild(choiceDiv);
        choices.push(choiceDiv);
      });
      quizLayout.appendChild(grid);

      const fbBox = document.createElement('div');
      fbBox.className = 'quiz-fb state-idle';
      const fbHead = document.createElement('div');
      fbHead.className = 'fb-head';
      const fbMsg = document.createElement('span');
      fbMsg.className = 'fb-msg';
      fbMsg.textContent = '👉 請點選左側選項進行自我檢測';
      const btnRetry = document.createElement('span');
      btnRetry.className = 'btn-retry';
      btnRetry.textContent = '↺ 重新作答';
      btnRetry.style.display = 'none';
      fbHead.appendChild(fbMsg);
      fbHead.appendChild(btnRetry);

      const fbBody = document.createElement('div');
      fbBody.className = 'fb-body';
      let cleanExp = bq.innerHTML.replace(/<strong[^>]*>.*?正確答案.*?<\/strong>\s*(?:<br\s*\/?>|[—\-:]\s*)?/i, '');
      fbBody.innerHTML = '<strong>💡 正確答案：(' + correctOpt + ')</strong> — ' + cleanExp.trim();
      fbBox.appendChild(fbHead);
      fbBox.appendChild(fbBody);
      quizLayout.appendChild(fbBox);

      if (h2) h2.style.display = 'none';
      qPs.forEach(p => p.style.display = 'none');
      ul.style.display = 'none';
      bq.style.display = 'none';
      sec.appendChild(quizLayout);

      choices.forEach(choice => {
        choice.addEventListener('click', function(e) {
          e.stopPropagation();
          const opt = choice.dataset.opt;
          const isCorrect = choice.dataset.correct === 'true';
          if (isCorrect) {
            choices.forEach(c => {
              c.classList.remove('is-wrong');
              c.style.pointerEvents = 'none';
            });
            choice.classList.add('is-correct');
            fbBox.className = 'quiz-fb state-correct';
            fbMsg.innerHTML = '<span style="color:#15803d;font-weight:700;">🎉 太棒了，完全答對！👏</span>';
            btnRetry.style.display = 'inline-block';
          } else {
            choice.classList.add('is-wrong');
            choice.style.animation = 'none';
            choice.offsetHeight;
            choice.style.animation = 'quizShake 0.35s ease-in-out';
            fbBox.className = 'quiz-fb state-wrong';
            fbMsg.innerHTML = '<span style="color:#dc2626;font-weight:700;">❌ 選項 (' + opt + ') 不太對喔，再換個選項試試看！💪</span>';
            btnRetry.style.display = 'inline-block';
          }
        });
      });

      btnRetry.addEventListener('click', function(e) {
        e.stopPropagation();
        choices.forEach(c => {
          c.classList.remove('is-wrong', 'is-correct');
          c.style.pointerEvents = '';
          c.style.animation = '';
        });
        fbBox.className = 'quiz-fb state-idle';
        fbMsg.textContent = '👉 請點選左側選項進行自我檢測';
        btnRetry.style.display = 'none';
      });
    });
  }

  function initNumberQuickJump() {
    let inputBuffer = '';
    let timer = null;
    let hud = null;

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
      return document.querySelectorAll('section[id]').length || 1;
    }

    function showHud() {
      const el = getOrCreateHud();
      const total = getTotalSlides();
      el.innerHTML = '<span style="color: #38bdf8; font-weight: 700; font-size: 16px;">⮞ 跳至頁碼: ' + inputBuffer + '</span><span style="color: #94a3b8; font-size: 13px;"> / ' + total + ' (Enter 確認)</span>';
      el.style.display = 'flex';
      el.style.opacity = '1';
      if (timer) clearTimeout(timer);
      timer = setTimeout(clearInput, 2500);
    }

    function clearInput() {
      inputBuffer = '';
      if (hud) {
        hud.style.opacity = '0';
        setTimeout(() => { if (hud) hud.style.display = 'none'; }, 150);
      }
      if (timer) { clearTimeout(timer); timer = null; }
    }

    function jumpToSlide(num) {
      const total = getTotalSlides();
      const target = Math.max(1, Math.min(num, total));
      const targetHash = '#' + target;
      const el = getOrCreateHud();
      el.innerHTML = '<span style="color: #34d399; font-weight: 700; font-size: 15px;">✓ 第 ' + target + ' 頁</span>';
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
      const active = document.activeElement;
      if (active && (active.tagName === 'INPUT' || active.tagName === 'TEXTAREA' || active.tagName === 'SELECT' || active.isContentEditable)) return;
      if (e.ctrlKey || e.altKey || e.metaKey) return;

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

      if ((e.key === 'Backspace' || e.code === 'Backspace') && inputBuffer.length > 0) {
        e.preventDefault();
        inputBuffer = inputBuffer.slice(0, -1);
        if (inputBuffer.length === 0) clearInput(); else showHud();
        return;
      }

      if ((e.key === 'Escape' || e.code === 'Escape') && inputBuffer.length > 0) {
        e.preventDefault();
        clearInput();
        return;
      }

      if ((e.key === 'Enter' || e.code === 'Enter' || e.code === 'NumpadEnter') && inputBuffer.length > 0) {
        e.preventDefault();
        const targetPage = parseInt(inputBuffer, 10);
        if (!isNaN(targetPage)) jumpToSlide(targetPage); else clearInput();
      }
    }, true);
  }

  function initAll() {
    initHeaderDropdown();
    initQuizInteractions();
    initNumberQuickJump();
  }

  if (document.readyState === 'loading') {
    document.addEventListener('DOMContentLoaded', initAll);
  } else {
    initAll();
  }
  setTimeout(initAll, 400);
  window.addEventListener('hashchange', () => setTimeout(initAll, 100));
})();
</script>
