---
marp: true
theme: ux-theme
paginate: true
footer: '薛念林 教授 | 逢甲大學資訊工程學系'
size: 16:9
transition: fade
html: true
---

<!-- _class: lead -->
<!-- _header: '' -->
# AI for UX: 尼爾森 10 大可用性原則與提示工程
## Nielsen’s 10 Usability Heuristics & UX-Driven Prompting

**薛念林 教授**
逢甲大學 資訊工程學系

<span style="font-size: 14px; color: #64748b; margin-top: 24px; display: block;">（本講義與 Gemini AI 共同協作編製）</span>

---
<!-- header: '本單元大綱 (Course Outline)' -->

## 本單元大綱 (Course Outline)

<div class="two-columns">
<div class="card" data-marpit-fragment>

### 🚀 1. AI for UX 的核心價值
- 意義、目的與 1-10-100 效益法則
- UX 約束式提示工程 (Prompting) 做法

### 📗 2. 尼爾森 10 大原則與 Prompt 融合
- NS01 ~ NS10 啟發式原則概念與案例
- 各原則之 Prompt 設計框架與實作範本

</div>
<div class="card" data-marpit-fragment>

### 🤖 3. 從 Prompt 到 Agentic UX 實踐
- Prompt 與 Agentic 的差異
- 以 **Antigravity IDE** 為例：Agentic UX 實踐
- 實作演練：BMI 系統 AI-Coding 對照

### 🙋 4. 實務練習與課堂互動
- 系統易用性評估練習
- 概念核對問答與問答討論

</div>
</div>

---

<!-- _class: full-img -->

![](../../img/ai_for_ux_concept.png)

---
<!-- header: '1. 什麼是 AI for UX？' -->

## 什麼是 AI for UX？

> **AI for UX** 是應用生成式 AI 協助使用體驗設計，在系統開發的起點就注入專業的可用性與人因規範。

<div class="two-columns">
<div class="card" data-marpit-fragment>

### 傳統 UI/UX 設計流程的痛點
- **溝通代溝** ：沒有畫面與雛形，成品往往與預期嚴重脫節。
- **繁複設計** ：手繪草圖 ➔ Wireframe ➔ 靜態 Mockup ➔ 標註交付 ➔ 前端撰寫。
- **週期漫長** ：等看到第一個可操作版本時，已耗費數週開發時間。

</div>
<div class="card" data-marpit-fragment>

### AI for UX 的典範轉移 (Paradigm Shift)
- **意圖即介面** ：用結構化自然語言直接生成可操作原型，降低溝通失誤。
- **可用性內生化** ：將 UX 原則轉化為 Prompt 規則，讓 AI 生成的程式碼「天生具備好 UX」。
- **敏捷反饋閉環** ：快速完成從發想到可互動原型的驗證。

</div>
</div>

---

### AI for UX 的三大實務效益

<div class="two-columns">
<div class="card" data-marpit-fragment>

### ⚡ 開發效率與迭代速度倍增
- 從數週縮短至數分鐘，支援即時會議中現場修改、現場驗證。
- 開發團隊能有更多時間專注於核心業務架構與使用者洞察。

### 📐 介面標準化與設計系統落地
- 將專案的色彩、佈局、通用組件規格寫入 Prompt。
- 杜絕多位工程師各寫各的按鈕樣式與錯誤彈窗。

</div>
<div class="card" data-marpit-fragment>

### 💰 1-10-100 成本法則 (Cost of Quality)
- **$1 (雛形階段)** ：在 AI 雛形中發現可用性問題，修改僅需調整 Prompt 或幾行程式碼。
- **$10 (開發階段)** ：進入前端與後端整合後，修改需重構邏輯與資料庫關聯。
- **$100 (上線營運)** ：系統上線後使用者抱怨流失，修復成本高達百倍！

* > **AI for UX 讓高品質的「前期確認」變得容易可行！**

</div>
</div>

---
<!-- header: '2. Prompt 做法：從 RTF 到 RTCF' -->

## 使用 Prompt 的做法：角色-任務-約束-格式(RTCF)

* > 避免模糊無效的提示詞：❌ *「請幫我寫一個登入頁面」*
* > 採用軟體工程與體驗設計的 **RTCF 提示詞架構** （業界 RTF ＋ UX 約束）：

<div class="two-columns">
<div class="card" data-marpit-fragment>

### 1. 角色 (Role - R)
- 明確賦予資深 UI/UX 專家與軟體架構師視角。
- 例：*「你是一位具備 20 年經驗、專精防呆設計的資深 UX 架構師。」*

### 2. 任務 (Task - T)
- 清楚交代使用者目標、操作載具與業務流程。
- 例：*「設計外送點餐結帳表單，需考量單手操作與網路不穩情境。」*

</div>
<div class="card" data-marpit-fragment>

### 3. UX 約束 (Constraints - C)
- **主動帶入尼爾森原則作為非功能性需求** ：
 - 必須包含即時表單驗證 (NS05)
 - 避免沒有進度反饋 (NS01)
 - 支援 Toast 一鍵復原 (NS03)

### 4. 輸出格式 (Format - F)
- 規範組件技術棧（React/Tailwind），並要求條列標註應用的原則。

</div>
</div>

---
<!-- header: '尼爾森 10 大原則總覽' -->

## 尼爾森 10 大原則總覽 (Nielsen's Heuristics)

<div class="two-columns">
<div class="card" data-marpit-fragment>

- **NS01** 清楚的系統狀態 (Visibility of System Status)
- **NS02** 與真實世界對應 (Match Between System & Real World)
- **NS03** 使用者控制權 (User Control & Freedom)
- **NS04** 一致的風格 (Consistency & Standards)
- **NS05** 錯誤預防 (Error Prevention)

</div>
<div class="card" data-marpit-fragment>

- **NS06** 易於識別 (Recognition Rather Than Recall)
- **NS07** 彈性與效率 (Flexibility & Efficiency of Use)
- **NS08** 優雅簡潔設計 (Aesthetic & Minimalist Design)
- **NS09** 清楚錯誤處理 (Error Recovery)
- **NS10** 適當的說明 (Help & Documentation)

</div>
</div>


---
<!-- header: 'NS01 清楚的系統狀態 (Visibility)' -->

## NS01 清楚的系統狀態 (Visibility of System Status)

> *“The system should always keep users informed about what is going on, through appropriate **feedback** within a reasonable time.”* 
* > *「系統應始終在合理的時間內透過適當的 **反饋** ，讓使用者即時掌握正在發生的事情與 **當前狀態** 。」*

<div class="card">

### 核心概念：適時反饋、消除焦慮
- 系統必須在 **合理的時間內** 給予適當反饋，始終讓使用者了解當前進度與狀態。
- 凸顯重要資訊，建立使用者的情境掌控感。
* 👍 **優良實踐** ：提供上傳進度條、按鈕點擊後立即顯示目前狀態、步驟指示器（Step 2 of 4）。
* 👎 **不良設計** ：點擊無反應、畫面凍結、讓使用者猜測「系統是不是當機了？」。

</div>

---

### NS01 案例解析與實務應用

<div class="two-columns">
<div class="card" data-marpit-fragment>

### 檔案上傳狀態
```
Upload 100 files
[✓] image1.png (Done)
[✓] image2.png (Done)
[⟳] image3.png (45%...)
```
- 清楚交代每一項任務的進度。
- 使用者完全安心。

</div>
<div class="card" data-marpit-fragment>

### 即時表單與未讀通知
- 🔔 未讀訊息數字徽章
- 📧 Email 格式輸入錯誤時 **即時** 紅字提示
- 🛒 商品各尺寸之 **庫存即時狀態** 提示

</div>
</div>

---

<!-- _class: full-img -->

![](../../img/ns01_status_feedback_examples.png)

---

### iPhone Bug?

<div class="card-img">

<img src="../../img/iphone.png" alt="iPhone Bug">

</div>

---

### AI for UX：NS01 系統狀態能見度 (Visibility of System Status)

<div class="two-columns">
<div class="prompt-box" data-marpit-fragment>

### 💡 Prompt 設計框架
- **角色 (Role)**: 資深前端與 UX 專家。
- **任務 (Task)**: 當系統執行非同步操作（如 API 請求或資料處理）時，提供即時反饋讓使用者掌握進度。
- **約束 (Constraint)**: 必須包含明確進度與預估時間；避免毫無說明的空白畫面或無指示的 Spinner。

</div>
<div class="prompt-box" data-marpit-fragment>

### 📝 提示詞範本
> 你是一個資深前端工程師。在設計匯入大型檔案的 UI 時，請確保提供一個即時進度條（Progress Bar），包含目前處理百分比（如 45%）、已處理筆數與剩餘預估秒數。禁止在背景默默運算而不給任何進度指示。

</div>
</div>

---

<!-- _class: full-img -->

![](../../img/ns_ai_01.jpg)

---
<!-- header: 'NS02 與真實世界的對應 (Match Real World)' -->

## NS02 與真實世界的對應 (Match System & Real World)

> *“The system should speak the users’ language, with words, phrases, and concepts familiar to the user, rather than system-oriented terms.”*
* > *「系統應使用 **使用者的語言** ，採用使用者熟悉的詞彙、短語與概念，而非系統導向的專業術語。」*

<div class="card">

### 核心概念：說使用者的話、遵循日常習慣
- 使用使用者熟悉的日常單詞與概念，避免工程師導向的專業術語。
- 資訊排列順序應符合現實邏輯與心理模型。
* 👍 **優良實踐** ：「每天食用止痛藥不要超過 4 顆」
* 👎 **不良設計** ：「每日乙醯胺酚攝取上限為 2000mg」（過度術語化）

</div>

---

### NS02 案例解析：物理隱喻與直覺對應

<div class="two-columns">
<div class="card" data-marpit-fragment>

### 物理對應 (Natural Mapping)
- **瓦斯爐旋鈕** ：控制器的排列位置應與四個爐嘴的空間位置完全一致。
- **機車方向燈** ：左轉撥左、右轉撥右（若改成上下按鍵將極難直覺對應）。
- **Tesla 換檔** ：螢幕向上滑前進 (D)、向下滑倒車 (R)、點擊 P 停車。

</div>
<div class="card" data-marpit-fragment>

### 人性化提示字
- **註冊按鈕** ：不寫生硬的 "Sign Up"，改為「是的，我想立即提升業績！」。
- **終端機輸入** ：
 - 👎 `press -9 to stop` (工程師程式碼邏輯)
 - 👍 `Press STOP to finish` (高可讀性日常邏輯)

</div>
</div>

---

<!-- _class: full-img -->

![](../../img/ns02_mapping_gas_stove.png)

---

### AI for UX：NS02 系統與真實世界的對照 (Match Between System & Real World)

<div class="two-columns">
<div class="prompt-box" data-marpit-fragment>

### 💡 Prompt 設計框架
- **角色 (Role)**: 產品經理與資深 UX 設計師。
- **任務 (Task)**: 撰寫系統操作回饋與付款失敗提示文案。
- **約束 (Constraint)**: 必須使用日常真實世界語言並提供下一步指引；避免拋出冷冰冰的程式技術術語（如 `NullPointerException`）。

</div>
<div class="prompt-box" data-marpit-fragment>

### 📝 提示詞範本
> 你是一位專為電商平台撰寫文案的資深 UX 設計師。當使用者付款失敗時，請寫出友好的提示。 **避免** 使用 "交易異常 403" 或 "Connection timeout" 等技術詞彙，應改用 "目前付款通道繁忙，我們無法完成扣款，請您稍候再試或更換信用卡。" 並提供直接的下一步建議。

</div>
</div>

---

<!-- _class: full-img -->

![](../../img/ns_ai_02.jpg)

---
<!-- header: 'NS03 使用者擁有控制權 (User Control)' -->

## NS03 使用者擁有控制權 (User Control & Freedom)

> *“Users often choose system functions by mistake and will need a clearly marked ‘emergency exit’ to leave the unwanted state. Support undo and redo.”*
* > *「使用者經常會誤觸系統功能，需要一個標示明確的「緊急出口」來離開 **非預期的狀態** 。系統應支援 **復原** (Undo) 與 **重做** (Redo)。」*

<div class="card">

### 核心概念：提供「緊急出口」與反悔機會
- 使用者經常手滑誤觸功能，系統必須提供顯眼的 **緊急出口** ，無需繁瑣對話框。
- 必備按鈕：`[Back]`, `[Cancel]`, `[Close]`, `[Undo]`, `[Redo]`。
- ⚠️ **謹慎使用 [Reset]** ：一鍵清空整個表單容易造成災難性誤刪。

</div>

---

### NS03 案例解析：常用的緊急出口

<div class="three-columns">
<div class="card" data-marpit-fragment>

### [Undo] 寄信與刪除
- Gmail 寄出信件後，底部浮現 **5 秒內「復原 (Undo)」** 。
- 丟到垃圾桶時提供反悔復原按鈕。

</div>
<div class="card" data-marpit-fragment>

### [Cancel] 留言與表單
- 放棄填寫留言時，提供取消按鈕快速回到上一層。
- 允許中途退出流程而不死鎖畫面。

</div>
<div class="card" data-marpit-fragment>

### [Back / Close]
- 進入錯誤頁面能按 Back 返回。
- 彈出式廣告或視窗提供明確且容易點擊的 `[✕]` 關閉鍵。

</div>
</div>

---

<!-- _class: full-img -->

![](../../img/ux_diagram.png)

---

### AI for UX：NS03 使用者控制與自由 (User Control & Freedom)

<div class="two-columns">
<div class="prompt-box" data-marpit-fragment>

### 💡 Prompt 設計框架
- **角色 (Role)**: 互動設計師。
- **任務 (Task)**: 設計操作誤觸時的「緊急出口」與反悔機制。
- **約束 (Constraint)**: 必須提供顯眼的 Undo 撤銷或取消機制；避免強迫使用者走完流程或無反悔退路。

</div>
<div class="prompt-box" data-marpit-fragment>

### 📝 提示詞範本
> 你是一位網頁互動設計師。當使用者在行事曆上拖拉並移動會議時間後，請設計一個 Toast 提示框，包含 "已將會議移動至 10:00" 以及一個明顯的 "復原 (Undo)" 按鈕，讓使用者能在 5 秒內一鍵撤銷剛才的移動。避免讓使用者必須手動把會議拖拉回去。

</div>
</div>

---

<!-- _class: full-img -->

![](../../img/ns_ai_03.jpg)

---
<!-- header: 'NS04 一致的風格與標準 (Consistency)' -->

## NS04 一致的風格與標準 (Consistency & Standards)

> *“Users should not have to wonder whether different words, situations, or actions mean the same thing. Follow platform conventions.”*
* > *「使用者不應懷疑不同的用詞、情境或操作是否代表同一件事。系統應遵循平台與業界既定 **慣例** 。」*

<div class="card">

### 核心概念：降低學習成本
* **內部一致性** ：同一系統或產品家族內，文字、按鈕顏色、圖示與排版風格保持統一。
* **外部一致性** ：遵循平台與業界既定慣例（如 iOS HIG, Material Design, `Ctrl+C` 複製）。

</div>

---

### NS04 案例解析：不一致帶來的混亂

<div class="two-columns">
<div class="card" data-marpit-fragment>

### 用詞不一致
- 同一個操作在不同頁面寫成：
 `[提交]`、`[Submit]`、`[確認]`、`[OK]`、`[Done]`
* 使用者會懷疑功能是否不同。

</div>
<div class="card" data-marpit-fragment>

### 空間記憶破壞 (Spatial Memory)
- 「確認」與「取消」按鈕在不同彈窗 **忽左忽右** 。
- 確認按鈕的顏色一下藍、一下綠、一下紅。
* 使用者容易手快誤按。

</div>
</div>

---

### AI for UX：NS04 一致性與標準 (Consistency & Standards)

<div class="two-columns">
<div class="prompt-box" data-marpit-fragment>

### 💡 Prompt 設計框架
- **角色 (Role)**: UI/UX 專家。
- **任務 (Task)**: 規範全系統之按鈕命名、色彩語意、圖示與操作手勢。
- **約束 (Constraint)**: 必須遵循平台通用慣例與專案設計系統；避免同一動作在不同頁面使用 **歧異名稱** 。

</div>
<div class="prompt-box" data-marpit-fragment>

### 📝 提示詞範本
> 你是一位 UI/UX 專家。請為我們的 SaaS 後台檢視所有的確認動作。請統一使用 "確定" 作為主按鈕文字，並套用綠色（#10b981）語意；取消動作一律使用 "取消" 灰色按鈕。避免在部分頁面使用 "送出"、"確認" 等混淆命名，確保全站一致性。

</div>
</div>

---

<!-- _class: full-img -->

![](../../img/ns_ai_04.jpg)

---
<!-- header: 'NS05 錯誤預防 (Error Prevention)' -->

## NS05 錯誤預防 (Error Prevention)

> *“Even better than good error messages is a careful design which prevents a problem from occurring in the first place.”*
* > *「比優秀的錯誤訊息更理想的，是一開始就防患於未然、 **防止問題發生** 的謹慎設計。」*

<div class="card">

### 核心概念：預防勝於治療
- 比「友善的報錯訊息」更優秀的是： **一開始就設計成不可能犯錯** ！
* 策略一： **限制輸入條件（Constraints）** （如禁用過去日期、只能輸入數字）。
* 策略二： **危險操作二次確認（Confirmation）** （不可逆刪除需再次確認）。
* 策略三： **智慧提醒與預測** （如偵測到內文寫「附件」卻未上傳檔案時主動提醒）。

</div>

---

### NS05 案例解析：表單防呆與即時約束

<div class="two-columns">
<div class="card" data-marpit-fragment>

### 表單輸入屬性防呆
```html
<label for="weight">Weight (kg):</label>
<input type="number" id="weight" 
 name="weight" value="60" 
 min="30" max="300" required>
```
- 限制只能輸入數值，並設定合理的範圍 `[30, 300]`，防止輸入負數或異常數字。

</div>
<div class="card" data-marpit-fragment>

### 關鍵操作確認
- ⚠️ `你確認要刪除此帳號嗎？資料將無法復原。`
- ⚠️ `您似乎在信中提到了附件，但尚未添加附件，確定要傳送嗎？`
- 密碼設定時，即時顯示 8 碼英數混合之驗證狀態條。

</div>
</div>

---

<!-- _class: full-img -->

![](../../img/ns05_confirmation_dialogs.png)

---

### AI for UX：NS05 錯誤預防 (Error Prevention)

<div class="two-columns">
<div class="prompt-box" data-marpit-fragment>

### 💡 Prompt 設計框架
- **角色 (Role)**: 資深系統架構師與防呆專家。
- **任務 (Task)**: 設計破壞性操作與表單輸入的錯誤預防機制。
- **約束 (Constraint)**: 必須在錯誤發生前即時防禦（如輸入驗證、二次確認輸入名稱）；避免事後才拋出報錯警告。

</div>
<div class="prompt-box" data-marpit-fragment>

### 📝 提示詞範本
> 你是一位系統防呆專家。請設計此專案的安全機制。當使用者點擊刪除時，不要直接執行，而是彈出一個二次確認視窗，要求使用者手動輸入專案名稱（例如輸入 "MyProject"）才能啟用刪除按鈕。避免讓使用者因誤觸按鈕而導致資料遺失，同時要偵測檢查可能的誤用狀況。

</div>
</div>

---

<!-- _class: full-img -->

![](../../img/ns_ai_05.jpg)

---

<!-- id: ux-ch02-ccq1 -->
### 🙋 概念核對問答 (CCQ1)

<div class="two-columns-64">
<div class="card">

### 錯誤預防 (NS05)
**[ 是 / 否 ]**

> 「為了徹底落實錯誤預防，系統在使用者執行『任何』可能修改資料的操作（包括編輯個人暱稱、切換深色模式）時，都強制彈出確認視窗要求點擊『確定修改』，這是兼顧安全性與可用性的最佳實踐。」

[線上作答](https://nlhsueh.github.io/nickedupocket/#/student/ux-ch02-ccq1)

</div>
<div class="card-img">

<a href="https://nlhsueh.github.io/nickedupocket/#/student/ux-ch02-ccq1" target="_blank"><img src="../../img/ch02/ux-ch02-ccq1.png" alt="QR Code" style="max-height: 280px;"></a>

</div>
</div>

---
<!-- header: 'NS06 易於識別而非記憶 (Recognition)' -->

## NS06 易於識別而非記憶 (Recognition Rather Than Recall)

> *“Minimize the user’s memory load by making objects, actions, and options visible. Instructions should be easily retrievable.”*
* > *「藉由讓物件、操作與選項清晰可見，最大程度減輕使用者的 **記憶負荷** 。操作說明應隨處易於檢索。」*

<div class="card">

### 核心概念：看到就選，不要考驗大腦記憶
- 選擇題遠比問答題容易：
 - 👎 「葡萄牙的首都是哪座城市？」（需提取記憶 Recall）
 * 👍 「里斯本是葡萄牙的首都嗎？」（只需辨識 Recognition）
* 操作指引與選項隨處可見，使用者不需要在各畫面間切換記憶。

</div>

---

### NS06 案例解析：降低認知負擔

<div class="three-columns">
<div class="card" data-marpit-fragment>

### 搜尋關鍵字保留
- 搜尋結果頁上方保留剛剛輸入的關鍵字：
 `"user experience design"`
 讓使用者不必費心記憶。

</div>
<div class="card" data-marpit-fragment>

### Apple 產品規格比較表
- iPad Pro / Air / Mini 並列比較螢幕、晶片、鏡頭規格。
- 消除跨頁對比記憶負擔。

</div>
<div class="card" data-marpit-fragment>

### 已拜訪連結變色
- 搜尋引擎將已點擊過的連結以紫色標示。
- 清楚識別拜訪記錄。

</div>
</div>

---

<!-- _class: full-img -->

![](../../img/compare_iPad.png)

---

<!-- _class: full-img -->

![](../../img/ns06_search_keyword_retention.png)

---

### AI for UX：NS06 辨識而非回憶 (Recognition Rather Than Recall)

<div class="two-columns">
<div class="prompt-box" data-marpit-fragment>

### 💡 Prompt 設計框架
- **角色 (Role)**: 認知心理學與介面設計專家。
- **任務 (Task)**: 設計搜尋與表單選單以降低使用者的記憶負荷。
- **約束 (Constraint)**: 必須將歷史紀錄與選項外顯化（如自動完成、最近搜尋）；避免考驗使用者回想之前的輸入。

</div>
<div class="prompt-box" data-marpit-fragment>

### 📝 提示詞範本
> 你是一位介面設計師。當使用者點擊搜尋框時，請顯示一個浮動視窗，列出 "最近搜尋項目" 與 "熱門推薦標籤"，讓使用者可以直接點擊。避免讓使用者必須自己去回想上一次輸入的關鍵字。

</div>
</div>

---

<!-- _class: full-img -->

![](../../img/ns_ai_06.jpg)

---
<!-- header: 'NS07 彈性與使用效率 (Efficiency)' -->

## NS07 彈性與使用效率 (Flexibility and Efficiency of Use)

> *“Accelerators — unseen by the novice user — may often speed up the interaction for the expert user. Allow users to tailor frequent actions.”*
* > *「新手不易察覺的『加速器』能大幅提升專家的操作效率。系統應允許使用者 **自訂** 與 **快捷** 常用操作。」*

<div class="card">

### 核心概念：新手好上手，專家更迅速
- 系統應兼顧新手與資深使用者的需求。
* **加速器（Accelerators）** ：提供鍵盤快捷鍵、自訂巨集、右鍵快顯功能。
* **個人化 (Personalization)** ：系統依據使用者歷史行為自動調整（如推薦片單）。
* **客製化 (Customization)** ：使用者自主調整偏好設定（如 VS Code / Gmail 設定）。

</div>

---

### NS07 案例解析：快捷鍵與個人化設定

<div class="two-columns">
<div class="card" data-marpit-fragment>

### 快捷鍵與快捷手勢
- Instagram 雙擊照片快速點讚 ❤️
- 終端機與 IDE 的程式碼片段 (Code Snippets)
- 簡易計算機一鍵切換成科學計算機

</div>
<div class="card" data-marpit-fragment>

### 個人化 vs 客製化
- **個人化** ：依角色顯示不同面板（管理者 vs 學生），或智慧推薦。
- **客製化** ：自訂最愛工具列、深色模式切換、批次選取操作。

</div>
</div>

---

<!-- _class: full-img -->

![](../../img/ns07_keyboard_shortcuts_snippets.png)

---

### AI for UX：NS07 使用的彈性與效率 (Flexibility & Efficiency of Use)

<div class="two-columns">
<div class="prompt-box" data-marpit-fragment>

### 💡 Prompt 設計框架
- **角色 (Role)**: 生產力工具 UX 專家。
- **任務 (Task)**: 設計兼顧新手引導與專家高效操作的介面機制。
- **約束 (Constraint)**: 必須提供加速器（如快捷鍵、批次操作、自訂範本）；避免所有操作皆須逐步點擊而降低效率。

</div>
<div class="prompt-box" data-marpit-fragment>

### 📝 提示詞範本
> 你是一位負責報表管理系統的 UX 專家。請為資料列表設計 "批次操作"（如批次刪除、批次匯出）。使用者勾選多個項目後，上方應出現浮動操作列，並支援快捷鍵（如按 Delete 鍵觸發批次刪除確認）。避免讓使用者必須點進每一筆資料單獨刪除。

</div>
</div>

---

<!-- _class: full-img -->

![](../../img/ns_ai_07.jpg)

---
<!-- header: 'NS08 優雅簡潔的設計 (Minimalist)' -->

## NS08 優雅簡潔的設計 (Aesthetic & Minimalist Design)

> *“Dialogues should not contain information which is irrelevant or rarely needed. Every extra unit of information diminishes relative visibility.”*
* > *「對話框與介面不應包含 **不相關** 或 **極少需要** 的資訊。每一筆多餘的資訊單位，都會削弱 **重要資訊** 的相對可見度。」*

<div class="card">

### 核心概念：少即是多，消滅視覺噪音
- 對話框與頁面不應包含不相關或極低頻率的訊息。
* 每多一個多餘元素，都會削弱重要資訊的可見度。
* **以圖表取代冗長文字** ，使用精準用詞，適度留白。

</div>

---

### NS08 案例解析：極簡主義的力量

<div class="two-columns">
<div class="card" data-marpit-fragment>

### Google 搜尋首頁
- 首頁只有中央乾淨的搜尋框與 Logo，極度專注。
- 簡約不代表功能簡單，背後需要更強大的智慧技術支持。
- 網址列直接兼具搜尋功能。

</div>
<div class="card" data-marpit-fragment>

### 漸進式選單與圖表視覺化
- 首頁僅呈現核心指標，點擊後才展開細部進階功能。
- 健康資訊以視覺化圓餅圖或柱狀圖呈現，一目了然。

</div>
</div>

---

<!-- _class: full-img -->

![](../../img/aesthetic_clock.png)

---

<!-- _class: full-img -->

![](../../img/ns08_excessive_info_gates.png)

---

### AI for UX：NS08 極簡與美觀設計 (Aesthetic & Minimalist Design)

<div class="two-columns">
<div class="prompt-box" data-marpit-fragment>

### 💡 Prompt 設計框架
- **角色 (Role)**: 視覺傳達與 UI 設計師。
- **任務 (Task)**: 重新梳理儀表板介面以達成簡潔優雅的資訊架構。
- **約束 (Constraint)**: 必須保留足夠留白並收納 80% 次要低頻數據；避免單一畫面塞入過量圖表造成 **視覺噪音** 。

</div>
<div class="prompt-box" data-marpit-fragment>

### 📝 提示詞範本
> 你是一位追求極簡主義的 UI 設計師。請重新設計這個儀表板。請過濾掉 80% 的次要監控數據，僅保留最重要的 3 個指標，並使用大字體與大量的留白（White Space）。其餘次要數據應收納至 "詳細報告" 展開按鈕中。避免把所有圖表和數字擠在同一頁。

</div>
</div>

---

<!-- _class: full-img -->

![](../../img/ns_ai_08.jpg)

---

<!-- id: ux-ch02-ccq2 -->
### 🙋 概念核對問答 (CCQ2)

<div class="two-columns-64">
<div class="card">

### 簡潔設計 (NS08)
**[ 是 / 否 ]**

> 「為了實現極致簡潔的視覺體驗，將資料表格中的操作按鈕（編輯/刪除/下載）全數隱藏，改為僅在使用者將滑鼠 Hover 懸停於該列時才浮現，這在所有裝置與情境下都是最推薦的做法。」

[線上作答](https://nlhsueh.github.io/nickedupocket/#/student/ux-ch02-ccq2)

</div>
<div class="card-img">

<a href="https://nlhsueh.github.io/nickedupocket/#/student/ux-ch02-ccq2" target="_blank"><img src="../../img/ch02/ux-ch02-ccq2.png" alt="QR Code" style="max-height: 280px;"></a>

</div>
</div>

---
<!-- header: 'NS09 清楚的錯誤處理 (Recover Errors)' -->

## NS09 清楚的錯誤處理 (Help Users Recover from Errors)

> *“Error messages should be expressed in plain language (no codes), precisely indicate the problem, and constructively suggest a solution.”*
* > *「錯誤訊息應以 **通俗直白** 的語言表達（不顯示難懂的錯誤碼），精準指出問題所在，並提出 **建設性** 的解決方案。」*

<div class="card">

### 核心概念：通俗語言、精準定位、建設性建議
* **明晰的 (Explicit)** ：有錯誤必須明確提示，不能默默失敗。
* **精準的 (Precise)** ：指出究竟是哪個環節出錯。
* **白話文 (Readable)** ：嚴禁向一般使用者丟出 `Error 0x80070057` 或 `SQL Exception`。
* **客氣有禮 (Polite)** ：不要責怪使用者。
* **具建設性 (Constructive)** ：給予明確的下一步修復方案。

</div>

---

### NS09 案例解析：登入錯誤訊息對比

<div class="two-columns">
<div class="card" data-marpit-fragment>

### <span class="badge-bad">糟糕的報錯</span>
- ❌ `帳號或密碼錯誤，無法登入`
 （使用者不知道是帳號打錯還是密碼忘記）
- ❌ `System Error 500: NullReferenceException`
 （使用者完全看不懂）

</div>
<div class="card" data-marpit-fragment>

### <span class="badge-good">優良的報錯</span>
- ✅ `密碼錯誤。請重新輸入，或 [點此重設密碼]（我們將寄送重設信至您的信箱）。`
- ✅ 404 頁面：`抱歉，找不到該頁面。您可以返回首頁，或撥打客服電話 0800-xxx-xxx。`

</div>
</div>

---

<!-- _class: full-img -->

![](../../img/ns09_error_404_recovery.png)

---

### AI for UX：NS09 協助使用者辨識、診斷並從錯誤中復原 (Help Users Recognize, Diagnose, & Recover from Errors)

<div class="two-columns">
<div class="prompt-box" data-marpit-fragment>

### 💡 Prompt 設計框架
- **角色 (Role)**: 客服體驗與 UX 技術 Writer。
- **任務 (Task)**: 撰寫系統異常與操作失敗時的錯誤提示文案。
- **約束 (Constraint)**: 必須以白話文清楚說明原因並給予具體解決步驟；避免僅顯示模糊錯誤碼（如 `0x80070005`）。

</div>
<div class="prompt-box" data-marpit-fragment>

### 📝 提示詞範本
> 你是一位軟體易用性專家。請重寫上傳檔案失敗的錯誤提示。如果使用者上傳了不支援的格式（如 PDF，而系統只接受 PNG/JPG），請顯示："上傳失敗：不支援此檔案格式。我們只接受 PNG 或 JPG 格式（最大 5MB）。請將您的檔案轉檔後重新上傳，或點此 [查看支援格式說明] 連結。" 避免使用 "Format invalid" 這種無建設性的文字。

</div>
</div>

---

<!-- _class: full-img -->

![](../../img/ns_ai_09.jpg)

---

<!-- id: ux-ch03-ccq1 -->
### 🙋 概念核對問答 (CCQ3)

<div class="two-columns-64">
<div class="card">

### ❓ API 例外處理與使用者感知 (NS09)
**[ 是 / 否 ]**

> 「在要求 AI 生成前端資料請求組件時，提示詞明確要求『當 API 發生 500 伺服器錯誤時，必須使用 `try...catch` 捕捉並在控制台輸出 `console.error(err)`』，在軟體工程與 UX 層面上已完整滿足了 NS09（協助辨識與復原錯誤）的要求。」

請判斷上述說法是否正確，並思考對使用者介面的影響。

[線上作答](https://nlhsueh.github.io/nickedupocket/#/student/ux-ch03-ccq1)

</div>
<div class="card-img">

<a href="https://nlhsueh.github.io/nickedupocket/#/student/ux-ch03-ccq1" target="_blank"><img src="../../img/ch03/ux-ch03-ccq1.png" alt="QR Code" style="max-height: 280px;"></a>

</div>
</div>

---
<!-- header: 'NS10 說明與文件 (Help & Docs)' -->

## NS10 說明與文件 (Help and Documentation)

> *“Even though it is better if the system can be used without documentation, it may be necessary to provide help and documentation. It should be easy to search and list concrete steps.”*
* > *「雖然理想的系統最好不需說明文件即可直覺使用，但仍有必要提供說明與文件。這些文件應易於搜尋，並列出具體的執行步驟。」*

<div class="card">

### 核心概念：易於檢索、專注任務、步驟具體
- 最理想的系統是無須說明就能直覺使用，但針對複雜業務仍需具備完善說明。
* **被動式協助** ：使用者有疑問時可搜尋的 Help Center / FAQ。
* **主動式協助** ：新功能/新手導覽、多樣化樣板 (Templates)。
 * ⚠️ **避免多餘的干擾導覽** （例如在極度直覺的日曆新增介面彈出長篇教學）。

</div>

---

### NS10 案例解析：情境化與樣板協助

<div class="two-columns">
<div class="card" data-marpit-fragment>

### 互動式導覽 (Interactive Tour)
- 新手登入後的 3 步驟快速引導：
 `Step 1: 建立專案 ➔ Step 2: 邀請成員 ➔ 完成`
- 隨時可點擊 `[Skip 跳過]`。

</div>
<div class="card" data-marpit-fragment>

### 豐富的樣板庫 (Templates)
- Notion / Canva / Google Docs 提供各領域範本。
- 使用者在參考他人作品與範本的過程中，自然學會如何使用系統。

</div>
</div>

---

<!-- _class: full-img -->

![](../../img/ns10_onboarding_tutorial_modes.png)

---

### AI for UX：NS10 說明文件與輔助說明 (Help & Documentation)

<div class="two-columns">
<div class="prompt-box" data-marpit-fragment>

### 💡 Prompt 設計框架
- **角色 (Role)**: 技術寫作與引導設計專家。
- **任務 (Task)**: 為複雜功能設計情境式步驟導覽與常見問答索引。
- **約束 (Constraint)**: 必須簡明、任務導向且隨處易檢索；避免提供冗長無趣的整本手冊或缺乏情境說明。

</div>
<div class="prompt-box" data-marpit-fragment>

### 📝 提示詞範本
> 你是一位新手引導設計專家。請為我們的 [智慧報稅系統] 設計一個系統說明的引導方案。當使用者首次進入『薪資申報』頁面時，設計一個輕量級的步驟引導 (Walkthrough Tooltip) 說明如何匯入扣繳憑單，並提供常見問答連結，避免拋出冗長的說明書讓使用者自己閱讀。

</div>
</div>

---

<!-- _class: full-img -->

![](../../img/ns_ai_10.jpg)

---
<!-- header: '尼爾森 10 大原則總結對照' -->

## 尼爾森 10 大可用性原則總結對照表

| 代號 | 原則名稱 | 核心目標 | 典型範例 |
| :---: | :---: | :--- | :--- |
| **NS01** | 清楚的系統狀態 | 消除等待焦慮，進度即時反饋 | 上傳進度條、Loading 動畫 |
| **NS02** | 與真實世界對應 | 使用通俗語言與物理隱喻 | 丟入垃圾桶、日常詞彙 |
| **NS03** | 使用者擁有控制權 | 提供反悔機會與緊急出口 | Undo 復原、Cancel 取消 |
| **NS04** | 一致的風格與標準 | 降低學習成本，排版用詞統一 | 遵循 iOS/Material 慣例 |
| **NS05** | 錯誤預防 | 預防勝於治療，輸入防呆 | 禁用過去日期、刪除確認 |
| **NS06** | 易於識別而非記憶 | 降低認知負擔，看到即選 | 歷史搜尋記號、產品比較表 |
| **NS07** | 彈性與使用效率 | 兼顧新手與資深用戶速度 | 鍵盤快捷鍵、批次操作 |
| **NS08** | 優雅簡潔的設計 | 消除干擾資訊，強調核心重點 | Google 極簡首頁、圖表化 |
| **NS09** | 清楚的錯誤處理 | 白話說明問題並給予復原指引 | 附帶重設連結的密碼報錯 |
| **NS10** | 適當的說明與文件 | 任務導向教學，易於檢索搜尋 | 步驟引導、豐富樣板庫 |

---

## 互動導引：斜線指令實戰 (Antigravity自主推進與經驗固化應用)

<style scoped>
.card {
 padding: 14px 18px;
 font-size: 18px;
 line-height: 1.45;
}
.card h3 {
 font-size: 24px;
 margin-top: 0;
 margin-bottom: 8px;
}
.card ul {
 margin-top: 4px;
 margin-bottom: 4px;
 padding-left: 18px;
}
.card li {
 margin-bottom: 6px;
}
.cmd-box {
 background: #f1f5f9;
 border-left: 4px solid #3b82f6;
 padding: 5px 10px;
 margin: 4px 0 8px 0;
 border-radius: 4px;
 font-family: 'JetBrains Mono', Consolas, monospace;
 font-size: 16px;
 color: #1e293b;
 line-height: 1.4;
}
</style>

<div class="two-columns">
<div class="card" data-marpit-fragment>

### 🎯 `/goal`：自主長任務推進
- **核心機制** ：給定高階目標，Agent 自主展開多步驟推演、跨檔案重構、排錯與驗證，直到徹底達標。
- **實戰指令範例** ：
 - **全站表單與元件防呆健檢 (NS01, NS05)**
 <div class="cmd-box">/goal 走查整站結帳流程，替所有送出按鈕補齊防連點 Disabled 與 Loading 狀態，並加入斷線重試機制。</div>

 - **WCAG AA 無障礙體驗升級**
 <div class="cmd-box">/goal 掃描全站導覽與對話框，補齊 ARIA 標籤與鍵盤焦點輪廓 (Focus Ring)，確保純鍵盤可順暢操作。</div>

 - **設計系統全域變數重構 (NS04)**
 <div class="cmd-box">/goal 依據 tokens.css，將寫死 hex 色碼全面替換為語意化變數，並自動驗證深淺色切換對比度。</div>

</div>
<div class="card" data-marpit-fragment>

### 🧠 `/learn`：經驗固化與規範沉澱
- **核心機制** ：當人類在對話中糾正 Agent 或確立偏好時，下達 `/learn` 將經驗沉澱為全專案的長期記憶與規範。
- **實戰指令範例** ：
 - **軟體工程與專業術語規範**
 <div class="cmd-box">/learn 本教材遵循臺灣繁體中文規範，嚴格禁用「代碼」，一律改用「程式碼」，錯誤碼與狀態碼除外。</div>

 - **UX 與視覺排版一致性 (NS04)**
 <div class="cmd-box">/learn 尼爾森 10 大可用性原則總結對照表表格請置中（投影片內所有 Markdown 表格一律強制水平置中）。</div>

 - **破壞性操作防呆準則 (NS05)**
 <div class="cmd-box">/learn 凡涉及刪除、清空或覆蓋操作，前端一律必須彈出二次確認 Modal，且危險按鈕需以警示紅標註。</div>

</div>
</div>

---

<!-- id: ux-ch02-ccq3 -->
### 🙋 概念核對問答 (CCQ4)

<div class="two-columns-64">
<div class="card">

### 尼爾森原則綜合交叉應用
電商結帳頁在輸入信用卡時，自動依卡號長度在每 4 碼插入空格（`4111 2222 3333 4444`），並在辨識出卡別後即時於右側點亮 Visa 圖示。這項設計最直接體現了哪兩項原則的結合？

- **(A)** NS05 (錯誤預防) 與 NS06 (易於識別而非記憶)
- **(B)** NS03 (控制權) 與 NS07 (彈性與使用效率)
- **(C)** NS04 (一致性) 與 NS09 (清楚的錯誤處理)
- **(D)** NS08 (優雅簡潔的設計) 與 NS10 (適當的說明與文件)

[線上作答](https://nlhsueh.github.io/nickedupocket/#/student/ux-ch02-ccq3)

</div>
<div class="card-img">

<a href="https://nlhsueh.github.io/nickedupocket/#/student/ux-ch02-ccq3" target="_blank"><img src="../../img/ch02/ux-ch02-ccq3.png" alt="QR Code" style="max-height: 280px;"></a>

</div>
</div>

---

<!-- id: ux-ch02-ccq4 -->
### 🙋 概念核對問答 (CCQ5)

<div class="two-columns-64">
<div class="card">

### 尼爾森原則綜合交叉應用
使用者在 Gmail 內文提及「如附件企劃書」，但在未附加檔案時點擊「傳送」，系統即時攔截並提示：*「您提及了附件但未附加檔案，是否仍要傳送？」* ，並提供「取消」與「直接傳送」。這最直接體現了哪兩項原則的結合？

- **(A)** NS05 (錯誤預防) 與 NS03 (使用者控制與自由)
- **(B)** NS01 (系統狀態能見度) 與 NS08 (優雅簡潔的設計)
- **(C)** NS02 (與真實世界對應) 與 NS06 (易於識別而非記憶)
- **(D)** NS04 (一致性與標準) 與 NS10 (適當的說明與文件)

[線上作答](https://nlhsueh.github.io/nickedupocket/#/student/ux-ch02-ccq4)

</div>
<div class="card-img">

<a href="https://nlhsueh.github.io/nickedupocket/#/student/ux-ch02-ccq4" target="_blank"><img src="../../img/ch02/ux-ch02-ccq4.png" alt="QR Code" style="max-height: 280px;"></a>

</div>
</div>

---

<!-- id: ux-ch03-ccq2 -->
### 🙋 概念核對問答 (CCQ6)

<div class="two-columns-64">
<div class="card">

### ❓ 高保真提示詞的多維度 UX 約束
在要求 AI 生成「多步驟註冊表單」時，以下哪一段提示詞最能同時滿足 **NS01 (狀態)** 、 **NS03 (控制權)** 與 **NS05 (錯誤預防)** ？

- **(A)** 「請用 React + Tailwind 寫一個美觀的註冊表單，支援深色模式。」
- **(B)** 「提供步驟進度條；每步均有『上一步』且保留資料；欄位 blur 時即時驗證並禁用未過關的『下一步』按鈕。」
- **(C)** 「表單最後提供送出按鈕，送出失敗時彈出 Toast `Submission failed`。」
- **(D)** 「使用 LocalStorage 快取所有欄位，並提供一鍵重設按鈕。」

[線上作答](https://nlhsueh.github.io/nickedupocket/#/student/ux-ch03-ccq2)

</div>
<div class="card-img">

<a href="https://nlhsueh.github.io/nickedupocket/#/student/ux-ch03-ccq2" target="_blank"><img src="../../img/ch03/ux-ch03-ccq2.png" alt="QR Code" style="max-height: 280px;"></a>

</div>
</div>

---
<!-- header: '課堂遊戲：尼爾森原則闖關挑戰' -->

<!-- id: ux-ch02-game1 -->
## 🙋 課堂遊戲：尼爾森 10 大原則闖關大挑戰 (Game01)

<div class="two-columns-64">
<div class="card">

### 🏆 遊戲任務說明
- **挑戰目標** ：融會貫通尼爾森可用性原則 (NS) 與 AI-UX 提示工程實踐。
- **搶答規則** ：共 **7 道實戰單選題** （5 題 NS 原則 + 2 題 AI-UX 實踐），每題限時搶答！請選出最符合情境的核心原則或實踐。
- **操作方式** ：請拿起手機或平板掃描右側 QR Code，或點擊下方連結進入遊戲間。

[線上作答](https://nlhsueh.github.io/nickedupocket/#/student/ux-ch02-game1)

</div>
<div class="card-img">

<a href="https://nlhsueh.github.io/nickedupocket/#/student/ux-ch02-game1" target="_blank"><img src="../../img/ch02/ux-ch02-game1.png" alt="QR Code" style="max-height: 280px;"></a>

</div>
</div>

---

### 🎮 闖關第 01 關：【大檔案上傳與即時回饋】

<div class="card">

**情境描述** ：
使用者在雲端硬碟上傳 1GB 的影片檔，系統在右下角以浮動視窗顯示圓形百分比進度、已上傳容量（如 450MB / 1GB）、即時傳輸速度與預估剩餘時間。

**請問這項設計最直接落實了哪一項易用性原則？**
- **(A)** NS01 清楚的系統狀態能見度 (Visibility of System Status)
- **(B)** NS03 使用者控制與自由 (User Control and Freedom)
- **(C)** NS07 彈性與使用效率 (Flexibility and Efficiency of Use)
- **(D)** NS08 優雅簡潔的設計 (Aesthetic and Minimalist Design)

</div>

---

### 🎮 闖關第 02 關：【實體閱讀隱喻與書架設計】

<div class="card">

**情境描述** ：
電子書閱讀 App 在使用者翻頁時提供紙張翻摺陰影與沙沙紙張翻頁聲，並使用「書籤」、「螢光筆劃記」與「書架」來組織收藏，介面詞彙亦使用讀者熟悉的「章節」、「目錄」而非底層工程術語。

**請問這項設計最直接體現了哪一項易用性原則？**
- **(A)** NS01 清楚的系統狀態能見度 (Visibility of System Status)
- **(B)** NS02 與真實世界對應 (Match Between System and Real World)
- **(C)** NS04 一致性與標準 (Consistency and Standards)
- **(D)** NS06 易於識別而非記憶 (Recognition Rather Than Recall)

</div>

---

### 🎮 闖關第 03 關：【批次操作的緊急出口】

<div class="card">

**情境描述** ：
使用者在照片管理工具中勾選了 50 張照片並點擊「全數封存」，畫面底部立即彈出 SnackBar 提示：「已封存 50 張照片」，並在旁邊提供明顯的「復原 (Undo)」按鈕，且提供 10 秒的反悔猶豫期。

**請問這項設計最直接符合哪一項易用性原則？**
- **(A)** NS02 與真實世界對應 (Match Between System and Real World)
- **(B)** NS03 使用者控制與自由 (User Control and Freedom)
- **(C)** NS05 錯誤預防 (Error Prevention)
- **(D)** NS08 優雅簡潔的設計 (Aesthetic and Minimalist Design)

</div>

---

### 🎮 闖關第 04 關：【全站按鈕規範與平台標準】

<div class="card">

**情境描述** ：
某跨平台購物系統在 iOS App 遵循蘋果 HIG 規範將導覽標籤放在底部，在 Web 則遵循常見的頂部 Header 導航；全站無論在哪個頁面，「加入購物車」一律是深橘色按鈕、「立即結帳」一律是綠色按鈕，危險操作一律是紅色文字。

**請問這項設計最直接符合哪一項易用性原則？**
- **(A)** NS03 使用者控制與自由 (User Control and Freedom)
- **(B)** NS04 一致性與標準 (Consistency and Standards)
- **(C)** NS06 易於識別而非記憶 (Recognition Rather Than Recall)
- **(D)** NS07 彈性與使用效率 (Flexibility and Efficiency of Use)

</div>

---

### 🎮 闖關第 05 關：【新手視覺按鈕與專家快捷鍵】

<div class="card">

**情境描述** ：
現代程式碼編輯器（如 VS Code）為新手提供視覺化的功能選單與側邊欄按鈕，同時為資深工程師提供強大的快捷鍵（如 `Cmd + P` 快速開檔、`Cmd + Shift + L` 多游標編輯），並允許自訂程式碼片段 (Snippets) 與巨集。

**請問這項設計最直接符合哪一項易用性原則？**
- **(A)** NS03 使用者控制與自由 (User Control and Freedom)
- **(B)** NS05 錯誤預防 (Error Prevention)
- **(C)** NS07 彈性與使用效率 (Flexibility and Efficiency of Use)
- **(D)** NS09 清楚的錯誤處理 (Help Users Recognize, Diagnose, and Recover from Errors)

</div>

---

### 🎮 闖關第 06 關：【AI-UX 概念：1-10-100 品質成本法則】

<div class="card">

**情境描述** ：
開發團隊在專案初期運用 AI 生成前端原型時，即在提示詞中明確定義防呆約束與錯誤復原指引，及早發現並修復體驗瑕疵。相較於系統上線後因使用者客訴才動員十倍人力進行重構修復，這種在前端即落實 UX 的做法最直接體現了哪一項核心定律？

**請問下列哪一項是正確的軟體工程與品質法則？**
- **(A)** 摩爾定律 (Moore's Law)
- **(B)** 1-10-100 品質成本法則 (Cost of Quality Rule)
- **(C)** 阿姆達爾定律 (Amdahl's Law)
- **(D)** 康威定律 (Conway's Law)

</div>

---

### 🎮 闖關第 07 關：【AI-UX 提示工程：RTCF 框架中的 UX 約束】

<div class="card">

**情境描述** ：
工程師撰寫提示詞：「你是一位 UI 設計師（Role），請設計電商購物車結帳頁（Task）。 **【約束：載入時必須顯示骨架屏 (Skeleton Screen) 消除等待焦慮，且 API 斷線時必須以白話說明並提供重試按鈕，嚴禁僅拋出無說明的狀態碼】** （Constraints），請以 React 輸出（Format）。」

**請問提示詞中針對 Constraints 的具體要求，最主要是為了確保 AI 生成的介面滿足哪兩項尼爾森原則？**
- **(A)** NS02 (與真實世界對應) 與 NS04 (一致性與標準)
- **(B)** NS01 (系統狀態能見度) 與 NS09 (清楚的錯誤處理)
- **(C)** NS06 (易於識別而非記憶) 與 NS08 (優雅簡潔的設計)
- **(D)** NS03 (使用者控制權) 與 NS07 (彈性與使用效率)

</div>

---

### 🎯 闖關挑戰 7 題完整解答與核心解析

<div class="two-columns">
<div class="card" style="font-size: 18px;" data-marpit-fragment>

- **第 01 題 (A)** ： **NS01 狀態能見度** —— 百分比與進度條即時回饋，消除等待焦慮。
- **第 02 題 (B)** ： **NS02 與真實世界對應** —— 書架、書籤與紙張翻頁隱喻。
- **第 03 題 (B)** ： **NS03 使用者控制與自由** —— SnackBar Undo 10 秒反悔復原機制。
- **第 04 題 (B)** ： **NS04 一致性與標準** —— 遵循 iOS HIG/Web 平台規範與統一色彩意圖。

</div>
<div class="card" style="font-size: 18px;" data-marpit-fragment>

- **第 05 題 (C)** ： **NS07 彈性與使用效率** —— 鍵盤加速鍵兼顧初學者與資深專家操作速度。
- **第 06 題 (B)** ： **1-10-100 品質成本法則** —— 早期以 UX 約束生成原型，修復成本遠低於上線後客訴返工。
- **第 07 題 (B)** ： **RTCF 之 UX 約束落地** —— 將 NS01 (狀態) 與 NS09 (錯誤指引) 注入提示詞直接規範 AI 原型。

</div>
</div>

---
<!-- header: '從 Prompting 到 Agent 典範轉移' -->

<!-- _class: full-img -->

![](../../img/agent_ai_concept.png)

---
## 從 Prompting 到 Agent：AI 體驗設計的典範轉移

<div class="two-columns">
<div class="card" data-marpit-fragment>

### 💬 傳統 Prompting 的局限 (Chat-based)
- **上下文孤島** ：對話框無法感知整個專案的檔案架構與既有組件庫。
- **手動拼裝負擔** ：產出的片段程式碼需工程師手動複製貼上、修復依賴與樣式衝突。
- **無法自主閉環** ：無法自動運行專案、無法看見渲染成果、無法自主除錯。

</div>
<div class="card" data-marpit-fragment>

### 🤖 Agentic UX Workflow (代理人工作流)
- **具備全專案視野** ：能自主檢索目錄、閱讀系統設計與相關文件。
- **主動規劃與推演** ：不直接盲目寫程式碼，而是先擬定結構化實施計畫 (Plan)。
- **多檔案自主重構** ：自動修改關聯組件、加入狀態機、執行終端機驗證。
- **感知式工具調用** ：能啟動本機伺服器、透過瀏覽器自主走查使用者操作路徑。

</div>
</div>

---

### 以 Antigravity IDE 為例：現代 Agentic UX 實踐環境

> **Google Antigravity IDE** 提供專為工程師與設計師打造的深度 Agentic 協同環境：

<div class="three-columns">
<div class="card" data-marpit-fragment>

### 📋 規劃優先 (Planning Mode)
- 遇到複雜 UX 需求時，主動進入 Planning Mode。
- 自動生成詳細的 `implementation_plan.md` ，將使用者旅程、狀態圖與驗證方案列出供審查。

</div>
<div class="card" data-marpit-fragment>

### 🧠 專案規範感知 (AGENTS.md)
- Agent 自動遵守專案自訂之設計守則（如色彩主題、排版間距、中英混排空白規範）。
- 確保跨組件、跨頁面的視覺與行為高度一致 (NS04)。

</div>
<div class="card" data-marpit-fragment>

### 🛠️ 全自動驗證工具鏈
- 整合終端機指令、靜態檢查與瀏覽器子代理 (Browser Subagent)。
- 能自主啟動畫面預覽、自動點擊走查、即時修正渲染異常。

</div>
</div>

---

### 專案規範與技能庫：AGENTS.md vs .agents

<div style="text-align: center; margin-top: 15px;">
<img src="../../img/antigravity_agents_architecture.png" style="max-height: 470px; width: auto; border-radius: 8px; box-shadow: 0 4px 14px rgba(0,0,0,0.06);" />
</div>

---

### 實戰範例：AGENTS.md 跨專案通用守則

<style scoped>
pre {
 font-size: 19px;
 line-height: 1.42;
}
</style>

<div class="card">

### 📝 專案根目錄 `AGENTS.md` 範本（每次對話全量常駐注入）

```markdown
# 跨專案通用工程與 UX 準則

## 1. 協同與溝通原則
- 複雜重構前必須先擬定計畫，確認影響範圍與邊界再動工。
- 使用臺灣繁體中文與標準軟體工程用語（嚴禁用代碼，一律用程式碼）。

## 2. 核心 UX 與前端設計守則 (NS01, NS05, NS09)
- 非同步操作按鈕必須實作 Loading 與 Disabled 狀態，防重複點擊。
- 破壞性操作（刪除、重置、覆蓋）必須提供二次確認或 Toast 復原機制。
- 遵循 WCAG AA 規範：色彩對比度充足、所有互動元件必須具備鍵盤焦點態。

## 3. 程式碼品質與安全守則
- 禁止將 API Key、Token 或機敏憑證硬編碼在前端程式碼中。
- 外部請求必須實作錯誤處理並提供明確的狀態碼與錯誤碼反饋。
```

</div>

---

### 實戰範例：.agents 模組化技能 (Skills) 封裝

<style scoped>
pre {
 font-size: 20px;
 line-height: 1.48;
}
</style>

<div class="card">

### 🛠️ 模組檔案 `.agents/skills/ux-audit/SKILL.md` 範本（任務觸發動態載入）

```markdown
---
name: ux-audit
description: >-
 當使用者要求對前端頁面進行無障礙 (a11y) 或 Nielsen 易用性走查時使用此技能。
---

### UX 易用性自動化走查流程

## 執行步驟
1. 執行靜態無障礙檢查腳本：`./scripts/run-axe.sh`
2. 檢查頁面焦點順序、ARIA 標籤與鍵盤導航是否完整。
3. 若檢測到違規項，對照 `references/wcag.md` 提出具體修復方案。
4. 整理走查結果，於專案目錄自動產出 `ux_audit_report.md`。
```

</div>

---

### 開源生態與社群範本庫：直接引用的開源資源

<div class="three-columns">
<div class="card" data-marpit-fragment>

### 🌐 規則庫 (Rules Hub)
- **Awesome Cursorrules** ：最大開源社群庫 (`cursorrules.org`)。
- **技術棧支援** ：支援 React, Vue, Tailwind 等，可直接改名為 `AGENTS.md`。
- **Claude Prompts** ：Anthropic 官方與社群之專案規範模板。

</div>
<div class="card" data-marpit-fragment>

### 🔌 工具庫 (MCP Servers)
- **Model Context Protocol** ：官方開源庫 (`modelcontextprotocol`)。
- **Glama MCP Directory** ：收錄數百款現成工具 (`glama.co/mcp`)。
- **常用工具鏈** ：Git 整合、PostgreSQL、Puppeteer 走查、Figma 設計稿。

</div>
<div class="card" data-marpit-fragment>

### 📚 技能與標準 (Skills)
- **Built-in Skills** ：Antigravity 內建技能包（SOP 範本）。
- **llms.txt 標準倡議** ：根目錄標準化 AI 索引檔 (`llmstxt.org`)。
- **生態價值** ：加速理解相依套件與第三方函式庫。

</div>
</div>



---

### Antigravity IDE 實戰流程：自主 UX 走查與防呆重構

<style scoped>
.card {
 padding: 16px 20px;
 font-size: 19px;
 line-height: 1.5;
}
.card h3 {
 font-size: 26px;
 margin-top: 0;
 margin-bottom: 10px;
}
.card ul {
 margin-top: 4px;
 margin-bottom: 4px;
 padding-left: 20px;
}
.card li {
 margin-bottom: 8px;
}
</style>

<div class="two-columns">
<div class="card" data-marpit-fragment>

### 📋 階段一：脈絡診斷與架構計畫 (Plan)
- **步驟 1【全專案脈絡走訪與診斷】** ：
    - 開發者指派任務：*「請對購物車結帳模組進行 Nielsen 易用性健檢。」*
    - Agent 主動跨檔案分析組件關聯，偵測出送出按鈕缺少 Loading 狀態 ( **NS01**) 以及刪除項目無二次確認防呆 (**NS05** )。

- **步驟 2【產出變更計畫書 (`implementation_plan.md`)】** ：
    - 明確條列受影響檔案、組件依賴關係與狀態邏輯改動點。
    - 落實 **人機協同 (Human-in-the-Loop)** ：暫停並等待人類審核批准。

</div>
<div class="card" data-marpit-fragment>

### 🚀 階段二：精準重構與驗證交付 (Execute)
- **步驟 3【自主程式碼重構與防呆注入】** ：
    - 獲得授權後，Agent 調用工具精準修改前端程式碼檔案。
    - 實作按鈕 Disabled 防重複送出、注入防呆 Modal，並新增 SnackBar 提供 10 秒 Undo 復原反悔機制 ( **NS03** )。
- **步驟 4【自動化工具鏈驗證與交付 (`walkthrough.md`)】** ：
    - 背景調用終端機指令編譯專案、自動排查語法錯誤並透過瀏覽器確認渲染。
    - 輸出改動對照走查報告，清楚呈現體驗升級成果供團隊驗收。

</div>
</div>

---

### 人機協同 (Human-in-the-Loop) 的最佳實踐

<div class="two-columns">
<div class="card" data-marpit-fragment>

### 🤖 AI Agent 專精的範疇 (Heavy Lifting)
- 邊界狀態（Loading、Empty、Error、Retry）的全覆蓋程式設計。
- 既有 Design System 的命名規範、無障礙標籤 (ARIA) 嚴格遵守。
- 跨多個檔案同步重構與重複性程式碼撰寫。
- 自動化指令執行與編譯除錯。

</div>
<div class="card" data-marpit-fragment>

### 🧑‍🎨 人類專家專注的範疇 (High-Value Decision)
- 核心業務目標與使用者同理心洞察。
- 審查 Agent 提出的 `implementation_plan.md` ，把關架構方向。
- 最終美學品味、微互動細節感受與倫理決策。
- 「信任但驗證」：確保技術方案真正解決使用者痛點。

</div>
</div>

* > **Prompt 讓你與 AI 對話，而 Agent 讓你與 AI 並肩建立卓越的軟體產品！**

---

<!-- header: '實作活動：AI-Coding BMI 系統對照實驗' -->

## 🛠️ 實作演練：AI-Coding 學生 BMI 系統對照實驗

<div class="two-columns">
<div class="card" data-marpit-fragment>

### 🎯 實作任務與需求 Prompt
請在終端或 AI 編輯器中輸入以下需求，建立一個學生體位分析系統：

> *「建立一個 BMI 的網頁系統（採用 HTML, CSS, JavaScript）。可以連續的輸入學生的姓名，身高體重，算出每一個人的 BMI，並且進行分析（過重，過輕等）」*

- **技術範疇** ：純前端 HTML5 / CSS3 / Vanilla JavaScript。
- **核心功能** ：連續輸入、即時試算 BMI、體位判斷與班級清單。

</div>
<div class="card" data-marpit-fragment>

### 🔬 A/B 對照實驗設計

- **對照組【 noGuide 】（無規範引導）** ：
  - 僅提供上述需求 Prompt ，直接讓 AI 生成單頁應用。
  - 🔗 [開啟 noGuide 實作網頁](../../demoBMI/noGuide/index.html)
- **實驗組【 yesGuide 】（注入 agents.md 引導）** ：
  - 在專案工作區注入包含 **尼爾森原則** 規範的 `agents.md` ，交由 AI Agent 自主實現。
  - 🔗 [開啟 yesGuide 實作網頁](../../demoBMI/yesGuide/index.html)
- **核心探討** ：兩者在 **易用性細節** 、 **錯誤防呆** 與 **軟體工程架構** 上有何差異？

</div>
</div>

---

### 📊 產出比較：noGuide vs. yesGuide 體驗落差

<div class="two-columns">
<div class="card" data-marpit-fragment>

### 🚫 noGuide （無引導：功能及格但體驗冰冷）
- **狀態能見度 (NS01)** ：無即時試算預覽，必須點擊送出後才能在下方表格看到結果。
- **操作效率 (NS07)** ：無鍵盤加速流，每次新增後焦點丟失，需依賴滑鼠重新點選輸入框。
- **控制權與容錯 (NS03/05)** ：單筆刪除立即永久移除（無 Undo 復原機制）；邊界數值缺乏即時防呆。
- **視覺與規範 (NS04/08)** ：無統整 Design Tokens，狀態顏色隨意且缺乏語意，程式碼混亂。

</div>
<div class="card" data-marpit-fragment>

### ✨ yesGuide （agents.md 引導：生產級極致體驗）
- **即時狀態反饋 (NS01)** ：鍵入數值時呈現「即時動態試算條」；全班 Dashboard 儀表板與堆疊比例圖即時連動。
- **極速連續輸入 (NS07)** ：支援 <kbd>Enter</kbd> 一鍵送出， **自動清空並自動聚焦姓名欄位** ，雙手不離鍵盤連打全班！
- **容錯與反悔 (NS03/05)** ：單筆刪除提供「Toast 5 秒 Undo 撤銷按鈕」；清空全班具備防呆二階段確認。
- **標準與美學 (NS04/08)** ：遵循衛福部 6 級標準切點與專屬語意色；點擊圖表長條可直接篩選特定體位學生。

</div>
</div>

---

### 🔍 深入檢視：agents.md 如何具體落地尼爾森原則

| 尼爾森啟發式原則 | ❌ noGuide （無規範引導） | ✅ yesGuide （agents.md 規範引導） |
| :--- | :--- | :--- |
| **NS01 系統狀態能見度** | 送出後僅靜態新增列，無動態反饋 | 即時動態試算預覽、新增 Toast 提示、即時分佈看板 |
| **NS02 與真實世界對應** | 簡易體位文字，缺乏權威標準依據 | 遵循衛福部國健署最新成人標準、單位標示與健康建議 |
| **NS03 使用者控制權** | 刪除單筆立即銷毀，無法撤銷挽回 | 刪除配備 **5 秒 SnackBar Undo 反悔** ，提供清空重設 |
| **NS04 一致性與標準** | 顏色與間距無系統，各自為政 | 封裝 CSS 變數 Design System，狀態色全站語意統一 |
| **NS05 錯誤預防** | 僅依賴瀏覽器簡易原生提示 | 嚴格數值邊界約束、清空全班二階段確認防呆彈窗 |
| **NS06 易於識別非記憶** | 使用者需自行記憶各體位 BMI 切點 | 常駐國健署標準對照抽屜，點擊圖表長條直接即時過濾 |
| **NS07 彈性與使用效率** | 每次送出需頻繁切換滑鼠點擊 | **鍵盤流連續輸入** ：Enter 送出且自動返回姓名焦點 |
| **NS09 協助辨識與復原** | 阻斷式警告或無定位的錯誤字串 | 欄位就地即時繁中指引，自動聚焦錯誤欄位就地修正 |

---

### 💡 AI-Coding 核心啟示：Prompt 給予能力，agents.md 賦予靈魂

<div class="two-columns">
<div class="card" data-marpit-fragment>

### 🤖 從 Code Completion 到 Agentic Quality
- **Prompt 的天花板** ：
  - 純 Prompt 只能告訴 AI「做什麼 (What)」，AI 預設只會滿足 Happy Path，產出能動但粗糙的「玩具原型」。
- **agents.md 的決定性力量** ：
  - 作為常駐的「AI 心智模型與憲章」，它定義了「如何做到卓越 (How to Excel)」，引導 Agent 主動實踐邊界狀態、無障礙與人因細節。
- **架構與軟體工程規格** ：
  - 模組化職責分離、CSS 變數 Design Tokens、狀態管理與臺灣標準繁中軟體工程術語。

</div>
<div class="card" data-marpit-fragment>

### 🧑‍💻 新時代軟體工程師的核心價值
- **角色典範躍遷** ：
  - 不再耗費大量時間「手刻每行 HTML/CSS 樣板程式碼」。
  - 升級為 **「系統規範制定者 (Rule Maker)」** 與 **「體驗架構師 (UX Architect)」** 。
- **AI-Coding 效能階梯** ：
  - **Level 1 (Chat/Prompt)** ：碎片程式碼、複製貼上、無上下文。
  - **Level 2 (Agent Autonomy)** ：自主執行但若欠缺約束易失控。
  - **Level 3 (Agent + agents.md)** ：注入人因準則與工程規範，持續自主交付生產級卓越品質！

</div>
</div>

---

<!-- header: '課堂遊戲：從 Prompting 到 Agent 闖關挑戰' -->

<!-- id: ux-ch03-game1 -->
## 🙋 課堂遊戲：從 Prompting 到 Agent 典範轉移闖關挑戰 (Game02)

<div class="two-columns-64">
<div class="card">

### 🏆 遊戲任務說明
* **挑戰目標** ：深刻體會從傳統 Chat 對話框到現代 Agentic 自主工作流的關鍵思維升級。
* **搶答規則** ：共 **5 道實戰單選題** ，每題限時搶答！請選出最符合現代 Agentic UX 的最佳實踐。
* **操作方式** ：請拿起手機或平板掃描右側 QR Code，或點擊下方連結進入遊戲間。

[線上作答](https://nlhsueh.github.io/nickedupocket/#/student/ux-ch03-game1)

</div>
<div class="card-img">

<a href="https://nlhsueh.github.io/nickedupocket/#/student/ux-ch03-game1" target="_blank"><img src="../../img/ch03/ux-ch03-game1.png" alt="QR Code" style="max-height: 280px;"></a>

</div>
</div>

---

### 🎮 闖關第 01 關：【Chat-based Prompting 的上下文孤島】

<div class="card">

**情境描述** ：
工程師在傳統對話框中輸入「請幫我寫一個符合 NS01 的購物車組件」，AI 給出了一段語法正確的 React 程式碼。然而當工程師複製進專案時，卻發現該組件無法辨識專案既有的 Pinia/Redux 狀態機，CSS 變數亦與全域 Design System 衝突，還缺漏了必要的依賴套件。

**請問這最能說明傳統對話型 Prompting 的哪一項核心局限？**
- **(A)** 大型語言模型的推理速度過慢
- **(B)** 上下文孤島 (Context Silo) 與缺乏全專案視野
- **(C)** 模型欠缺基本的程式碼語法檢查能力
- **(D)** 對話介面無法輸出超過 50 行的文字

</div>

---

### 🎮 闖關第 02 關：【Agent 的規劃優先原則 (Planning Mode)】

<div class="card">

**情境描述** ：
當我們指派 AI Agent 一個涉及 5 個前端組件、全站深色模式變數以及結帳狀態機的複雜 UX 重構任務時，一個成熟的 Agentic 協同工作流應該採取的第一步動作為何？

**請問下列哪一項是最佳實踐？**
- **(A)** 立即以多執行緒同時盲目改寫 5 個前端程式碼檔案
- **(B)** 自動覆寫既有檔案並強制執行 `git push --force` 推送至遠端
- **(C)** 優先進入規劃模式 (Plan)，主動分析相依性並產出結構化實施計畫書，等待人類審查批准
- **(D)** 自動關閉終端機並拒絕執行跨檔案操作

</div>

---

### 🎮 闖關第 03 關：【閉環驗證與自主走查 (Feedback Loop)】

<div class="card">

**情境描述** ：
AI Agent 在完成購物車刪除防呆 Modal (NS05) 的前端程式碼改動後，自主調用終端機指令編譯專案、開啟瀏覽器走查工具模擬點擊結帳流程，並在瀏覽器控制台檢測有無未捕捉之 JavaScript 錯誤。

**請問這項特徵體現了 Agent 與傳統 Prompting 的哪項本質差異？**
- **(A)** 單一對話的提示詞長度能無限擴展
- **(B)** 外部工具調用與自主閉環走查驗證 (Tool Calling & Feedback Loop)
- **(C)** 取代人類產品經理的所有商業決策
- **(D)** 完全不需要依賴任何底層大型語言模型

</div>

---

### 🎮 闖關第 04 關：【人機協同 (Human-in-the-Loop) 的角色演進】

<div class="card">

**情境描述** ：
在現代 Agentic UX 開發模式下，AI Agent 能自主負擔繁重的跨檔案重構、樣式微調與自動化測試驗證。

**請問在此典範轉移下，人類工程師與設計師最關鍵的核心職責轉變為何？**
- **(A)** 專職手動輸入終端機編譯指令
- **(B)** 意圖定義、架構審核、關鍵決策批准與最終體驗驗收 (Reviewer & Orchestrator)
- **(C)** 完全退出軟體開發流程，由 AI 獨立交付與部署上線
- **(D)** 僅負責幫 AI 支付 API 費用與伺服器硬體維護

</div>

---

### 🎮 闖關第 05 關：【斜線指令實踐：經驗固化 (`/learn`)】

<div class="card">

**情境描述** ：
團隊在協同開發時，發現 Agent 預設常常生成未對齊 Design System 的任意色彩，破壞了介面一致性 (NS04)。若使用 Antigravity IDE，團隊最推薦透過哪一項指令將「一律使用 tokens.css 變數」的決策沉澱為全專案的長期記憶？

**請問應該使用哪一個斜線指令？**
- **(A)** `/goal`
- **(B)** `/schedule`
- **(C)** `/learn`
- **(D)** `/plan`

</div>

---

### 🎯 闖關挑戰 (Game02) 5 題完整解答與核心解析

<div class="two-columns">
<div class="card" style="font-size: 19px;" data-marpit-fragment>

- **第 01 題 (B)** ： **上下文孤島** —— 傳統 Chat 無法感知全專案架構，導致生成的程式碼與既有狀態及 Design System 脫節。
- **第 02 題 (C)** ： **規劃優先 (Plan First)** —— 複雜重構先擬定變更計畫書並落實人機協同審查，避免盲目修改引發災難。
- **第 03 題 (B)** ： **自主閉環驗證** —— Agent 具備感知式工具調用能力，能啟動伺服器與瀏覽器自主驗證操作路徑。

</div>
<div class="card" style="font-size: 19px;" data-marpit-fragment>

- **第 04 題 (B)** ： **人機協同關鍵價值** —— 人類專家從低層次搬磚轉變為架構審核、意圖掌控與最終體驗品質把關者。
- **第 05 題 (C)** ： **`/learn` 經驗固化** —— 將人類反饋與專案規範沉澱為持久性規則，避免每次對話重複糾正。

</div>
</div>

---
<!-- header: '練習：應用尼爾森原則評估系統' -->

## 練習 🏄🏻‍♀️：應用尼爾森原則評估系統

<div class="card">

### 請挑選以下其中一個系統，依據尼爾森原則進行 UX 分析與改進建議：
- 🎓 研究所推薦信系統（Web）
- 📋 課堂出缺席點名系統（Mobile/Web）
- 🍜 餐廳 Line 點餐系統（Mobile）
- 🚄 台灣高鐵線上訂票系統（Web/App）
- 🛵 美食外送軟體（Foodpanda/UberEats）
- 🏫 校園資訊入口網站（Web）
- 🚗 汽車中控車機資訊系統（Car）

</div>

---

<!-- id: ux-ch03-qa1 -->
### 🙋 問答討論 (QA1)

<div class="two-columns-64">
<div class="card">

### 用 AI 設計辦公室 Web 點餐系統
請使用 AI 輔助設計辦公室 Web 點餐系統，並分享你的提示詞與生成觀察：

1. **初版生成 vs. UX 優化** ：比較「無 Prompt 限制」與「加入尼爾森原則約束」後的程式碼與介面差異。
2. **滿足哪些易用性原則** ：你的 Master Prompt 中加入了哪些 UX 約束（如 NS01 狀態、NS03 控制權、NS05 錯誤預防）？
3. **心得與發現** ：AI 生成的 UX 細節是否符合預期？有哪些值得注意的盲點？

[線上作答](https://nlhsueh.github.io/nickedupocket/#/student/ux-ch03-qa1)

</div>
<div class="card-img">

<a href="https://nlhsueh.github.io/nickedupocket/#/student/ux-ch03-qa1" target="_blank"><img src="../../img/ch03/ux-ch03-qa1.png" alt="QR Code" style="max-height: 280px;"></a>

</div>
</div>

---

<!-- _class: lead -->
<!-- _header: '' -->
# Thank You!
## 結合可用性原則與 AI 提示，打造極致體驗

**Q & A / 交流討論**

<script>
(function() {
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

    // Helper to create the dropdown DOM
    function createDropdownWrapper(currentTitle) {
      const wrapper = document.createElement('span');
      wrapper.className = 'header-nav-wrapper';
      
      const titleSpan = document.createElement('span');
      titleSpan.className = 'header-nav-title';
      titleSpan.title = '點擊固定或懸停查看所有章節快速跳轉';
      titleSpan.innerHTML = currentTitle + '<span class="nav-caret"> ▾</span>';
      
      // Click on title toggles pinned state
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
      
      // Prevent clicks inside dropdown from bubbling and closing
      dropdown.addEventListener('click', function(e) {
        e.stopPropagation();
      });
      
      const dropHeader = document.createElement('div');
      dropHeader.className = 'nav-dropdown-header';
      dropHeader.innerHTML = '<span>📑 快速跳轉章節目錄</span><span style="font-size:11px;font-weight:normal;color:#64748b;">共 ' + sections.length + ' 個章節</span>';
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
          wrapper.classList.remove('is-open');
          dropdown.style.display = 'none';
          window.location.hash = '#' + s.id;
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
      
      let title = header.textContent.trim();
      title = title.replace(/^[◄◀]\s*/, '').replace(/\s*[►▶]$/, '').trim();
      if (!title) return;
      
      header.innerHTML = '';
      const wrapper = createDropdownWrapper(title);
      header.appendChild(wrapper);
    });
  }

  if (document.readyState === 'loading') {
    document.addEventListener('DOMContentLoaded', initHeaderDropdown);
  } else {
    initHeaderDropdown();
  }
  setTimeout(initHeaderDropdown, 400);
})();
</script>
