---
marp: true
theme: gaia
size: 16:9
paginate: true
html: true
header: '<div class="hdr-wrap"><span class="hdr-title">AI and Education · 國立高雄師範大學專題演講（2026/11/24）</span><div class="nav-dropdown"><button class="nav-btn">章節導覽 ▾</button><div class="nav-menu"><a href="#2">破題：計程車司機的 AI 震撼</a><a href="#3">現場互動：你用 AI 做什麼？</a><a href="#4">演講主軸目錄</a><a href="#5">五篇研究脈絡總覽</a><a href="#6">NickPocket 個人百寶箱</a><a href="#7">Courseware Design 教材工程</a><a href="#8">Vibe Coding 實戰循環</a><a href="#9">Harness Engineering</a><a href="#10">結語與資源入口</a></div></div></div>'
footer: '薛念林教授（Nien-Lin Hsueh）· 逢甲大學資訊工程學系 · 高師大專題演講 2026/11/24'
---

<style>
@import url('https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700;800&family=Noto+Sans+TC:wght@400;500;700;900&family=JetBrains+Mono:wght@500;600&display=swap');

:root {
  --navy: #1b365d;
  --navy-dark: #102442;
  --accent: #8c1d40;
  --accent-soft: #fdf2f5;
  --teal: #0f766e;
  --teal-soft: #f0fdfa;
  --slate-900: #0f172a;
  --slate-700: #334155;
  --slate-500: #64748b;
  --slate-200: #e2e8f0;
  --slate-100: #f1f5f9;
  --surface: #ffffff;
}

section {
  background: var(--surface);
  color: var(--slate-900);
  font-family: 'Noto Sans TC', 'PingFang TC', 'Inter', -apple-system, sans-serif;
  font-size: 20px;
  line-height: 1.5;
  letter-spacing: 0.01em !important;
  padding: 68px 54px 48px 54px;
  box-sizing: border-box;
}

section h1, section h2, section h3 {
  letter-spacing: 0 !important;
}

/* Header & Navigation Dropdown */
header {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  height: 44px;
  padding: 0 54px;
  background: var(--navy);
  color: #ffffff;
  font-size: 13.5px;
  font-weight: 600;
  display: flex;
  align-items: center;
  box-sizing: border-box;
  overflow: visible !important;
  z-index: 50;
}

.hdr-wrap { width: 100%; display: flex; justify-content: space-between; align-items: center; }
.hdr-title { letter-spacing: 0.01em; opacity: 0.94; }

.nav-dropdown {
  position: relative;
  display: inline-block;
  padding-bottom: 6px;
  margin-bottom: -6px;
}

.nav-btn {
  background: rgba(255, 255, 255, 0.14);
  color: #ffffff;
  border: 1px solid rgba(255, 255, 255, 0.28);
  border-radius: 6px;
  padding: 3px 10px;
  font-size: 12px;
  font-weight: 600;
  cursor: pointer;
  font-family: inherit;
}

.nav-menu {
  display: none;
  position: absolute;
  right: 0;
  top: 100%;
  min-width: 230px;
  background: #ffffff;
  border: 1px solid var(--slate-200);
  border-radius: 8px;
  box-shadow: 0 10px 24px rgba(15, 23, 42, 0.18);
  padding: 6px 0;
  z-index: 200;
}

.nav-dropdown:hover .nav-menu,
.nav-dropdown.open .nav-menu { display: block; }

.nav-menu a {
  display: block;
  padding: 7px 14px;
  color: var(--slate-700);
  text-decoration: none;
  font-size: 12.5px;
  font-weight: 500;
  line-height: 1.35;
}

.nav-menu a:hover { background: var(--slate-100); color: var(--navy); }

@media print {
  .nav-dropdown { display: none !important; }
}

footer {
  position: absolute;
  left: 54px;
  bottom: 14px;
  font-size: 12.5px;
  color: var(--slate-500);
  font-weight: 500;
}

section::after {
  position: absolute;
  right: 54px;
  bottom: 14px;
  font-size: 12.5px;
  font-weight: 700;
  color: var(--navy);
  content: attr(data-marpit-pagination) ' / ' attr(data-marpit-pagination-total);
}

h1 { color: var(--navy); font-size: 1.7em; font-weight: 800; line-height: 1.24; margin: 0 0 12px 0; }

h2 {
  color: var(--navy);
  font-size: 1.26em;
  font-weight: 700;
  line-height: 1.28;
  margin: 0 0 14px 0;
  padding-bottom: 6px;
  border-bottom: 2.5px solid var(--navy);
  display: flex;
  align-items: center;
  gap: 8px;
}

h3 { color: var(--accent); font-size: 0.96em; font-weight: 700; margin: 4px 0 6px 0; }
p { margin: 0 0 8px 0; }
ul, ol { margin: 4px 0 8px 0; padding-left: 22px; }
li { margin-bottom: 5px; line-height: 1.45; }
li > ul { margin-top: 3px; margin-bottom: 3px; }
li > ul > li { font-size: 0.92em; margin-bottom: 3px; }
strong { color: var(--slate-900); }
a { color: #2563eb; text-decoration: none; font-weight: 600; }
a:hover { text-decoration: underline; }

:not(pre, marp-pre) > code {
  background: transparent !important;
  border: none !important;
  padding: 0 !important;
  font-family: 'JetBrains Mono', monospace;
  font-size: 0.9em;
  font-weight: 600;
  color: #475569;
}

h1 code, h2 code, h3 code { color: #0b3c5d; }
section.lead code, section.closing code { color: #bae6fd !important; }
section.closing strong { color: #ffffff !important; }

/* Lead Slide */
section.lead {
  background: linear-gradient(135deg, #102442 0%, #1b365d 60%, #8c1d40 100%);
  color: #ffffff;
  display: flex;
  flex-direction: column;
  justify-content: center;
  padding: 54px 72px;
}

section.lead header, section.lead footer, section.lead::after { display: none !important; }

section.lead .badge {
  display: inline-block;
  align-self: flex-start;
  background: rgba(255, 255, 255, 0.14);
  border: 1px solid rgba(255, 255, 255, 0.32);
  color: #f8fafc;
  font-size: 0.74em;
  font-weight: 600;
  letter-spacing: 0.05em;
  padding: 5px 14px;
  border-radius: 999px;
  margin-bottom: 18px;
}

section.lead h1 { color: #ffffff; font-size: 2.35em; font-weight: 900; line-height: 1.2; margin-bottom: 12px; text-align: left; }
section.lead .subtitle { color: #e2e8f0; font-size: 1.05em; line-height: 1.5; margin-bottom: 28px; max-width: 900px; }

section.lead .meta-box {
  border-left: 4px solid #f43f5e;
  padding-left: 18px;
  color: #f1f5f9;
  font-size: 0.9em;
  line-height: 1.65;
}

section.lead .meta-box strong { color: #ffffff; }

/* Closing Slide */
section.closing {
  background: linear-gradient(135deg, #102442 0%, #1b365d 62%, #8c1d40 100%);
  color: #ffffff;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  text-align: center;
  padding: 48px 72px;
}

section.closing header, section.closing footer, section.closing::after { display: none !important; }
section.closing h1 { color: #ffffff; font-size: 2.1em; margin-bottom: 10px; }
section.closing p { color: #e2e8f0; }

/* Layouts */
.two-col { display: grid; grid-template-columns: 1fr 1fr; gap: 20px; align-items: stretch; }
.three-col { display: grid; grid-template-columns: repeat(3, 1fr); gap: 14px; align-items: stretch; }
.split64 { display: grid; grid-template-columns: 58% 40%; gap: 2%; align-items: center; }
.split55 { display: grid; grid-template-columns: 49% 49%; gap: 2%; align-items: center; }

.card {
  background: #ffffff;
  border: 1px solid var(--slate-200);
  border-top: 3.5px solid var(--navy);
  border-radius: 10px;
  padding: 13px 17px;
  box-shadow: 0 2px 8px rgba(15, 23, 42, 0.05);
  box-sizing: border-box;
}

.card.accent { border-top-color: var(--accent); }
.card.teal { border-top-color: var(--teal); }

.callout {
  background: #f8fafc;
  border-left: 4px solid var(--accent);
  border-radius: 0 8px 8px 0;
  padding: 12px 18px;
  margin-top: 16px;
  max-width: 920px;
  margin-left: auto;
  margin-right: auto;
  font-size: 0.86em;
  line-height: 1.54;
  color: var(--slate-700);
}

.callout strong { color: var(--navy); }

/* Threads Mobile UI Mockup (Slide 2) */
.threads-phone {
  background: #ffffff;
  border: 2px solid #cbd5e1;
  border-radius: 22px;
  padding: 14px 18px;
  box-shadow: 0 12px 28px rgba(15, 23, 42, 0.12);
  font-size: 0.72em;
  line-height: 1.52;
  color: #0f172a;
}

.threads-top {
  display: flex;
  align-items: center;
  justify-content: space-between;
  border-bottom: 1px solid #e2e8f0;
  padding-bottom: 8px;
  margin-bottom: 10px;
}

.threads-user {
  display: flex;
  align-items: center;
  gap: 10px;
}

.threads-avatar {
  width: 34px;
  height: 34px;
  border-radius: 50%;
  background: linear-gradient(135deg, #1b365d, #8c1d40);
  color: #ffffff;
  font-weight: 800;
  font-size: 15px;
  display: flex;
  align-items: center;
  justify-content: center;
}

.threads-hl {
  background: #fef3c7;
  color: #92400e;
  font-weight: 700;
  padding: 1px 5px;
  border-radius: 4px;
}

.threads-actions {
  display: flex;
  gap: 18px;
  margin-top: 10px;
  padding-top: 8px;
  border-top: 1px solid #f1f5f9;
  color: #64748b;
  font-size: 0.92em;
  font-weight: 600;
}

/* Interactive Hub Grid (Slide 4) */
.hub-grid {
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 16px 20px;
  margin-top: 6px;
}

.hub-card {
  background: #ffffff;
  border: 1px solid var(--slate-200);
  border-left: 5px solid var(--navy);
  border-radius: 10px;
  padding: 13px 18px;
  box-shadow: 0 2px 8px rgba(15, 23, 42, 0.05);
}

.hub-card.teal { border-left-color: var(--teal); }
.hub-card.accent { border-left-color: var(--accent); }
.hub-card.amber { border-left-color: #d97706; }

.hub-title {
  font-size: 0.96em;
  font-weight: 800;
  color: var(--navy);
  margin-bottom: 8px;
  display: flex;
  align-items: center;
  gap: 8px;
}

.hub-card.teal .hub-title { color: var(--teal); }
.hub-card.accent .hub-title { color: var(--accent); }
.hub-card.amber .hub-title { color: #b45309; }

.hub-links {
  display: flex;
  flex-direction: column;
  gap: 7px;
  font-size: 0.8em;
}

.hub-link {
  display: flex;
  align-items: center;
  justify-content: space-between;
  gap: 10px;
  background: #f8fafc;
  border: 1px solid var(--slate-200);
  border-radius: 7px;
  padding: 6px 11px;
  color: var(--slate-900) !important;
  text-decoration: none !important;
  transition: all 0.15s ease;
}

.hub-link:hover {
  background: #eff6ff;
  border-color: #93c5fd;
  color: var(--navy) !important;
  transform: translateX(2px);
}

.hub-badge {
  font-size: 0.82em;
  font-weight: 700;
  color: #ffffff;
  background: var(--navy);
  padding: 2px 8px;
  border-radius: 999px;
  white-space: nowrap;
  flex-shrink: 0;
}

.hub-card.teal .hub-badge { background: var(--teal); }
.hub-card.accent .hub-badge { background: var(--accent); }
.hub-card.amber .hub-badge { background: #d97706; }

/* QR & Big Question Hero */
.qr-card {
  background: #ffffff;
  border: 2px solid var(--navy);
  border-radius: 14px;
  padding: 16px;
  text-align: center;
  box-shadow: 0 8px 24px rgba(15, 23, 42, 0.1);
}

.qr-card img {
  width: 245px;
  height: 245px;
  display: block;
  margin: 0 auto 10px auto;
}

.big-q {
  font-size: 1.55em;
  font-weight: 900;
  color: var(--navy);
  line-height: 1.32;
  margin-bottom: 14px;
}

.big-q span {
  color: var(--accent);
}

/* Minimalist Centered Question Slide (Slide 3) */
section.question-slide {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  text-align: center;
  padding: 64px 72px 52px 72px;
}

section.question-slide .big-q {
  font-size: 2.35em;
  line-height: 1.35;
  margin: 0;
}

section.question-slide ul {
  list-style: none;
  padding: 0;
  margin: 28px 0 0 0;
}

section.question-slide li {
  margin: 0;
  padding: 0;
}

section.question-slide img.qr-clean {
  width: 240px;
  height: 240px;
  display: block;
  margin: 0 auto;
  border: none !important;
  box-shadow: none !important;
  background: transparent !important;
}

/* NickPocket 6-module grid */
.np-grid {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: 12px;
  margin-top: 8px;
}

.np-item {
  background: #f8fafc;
  border: 1px solid var(--slate-200);
  border-top: 3.5px solid var(--teal);
  border-radius: 9px;
  padding: 10px 13px;
  font-size: 0.78em;
  line-height: 1.44;
}

.np-item.navy { border-top-color: var(--navy); }
.np-item.accent { border-top-color: var(--accent); }

.np-name {
  font-size: 1.06em;
  font-weight: 800;
  color: var(--navy);
  margin-bottom: 4px;
}

.cta-btn {
  display: inline-flex;
  align-items: center;
  gap: 8px;
  background: linear-gradient(135deg, #1b365d, #8c1d40);
  color: #ffffff !important;
  padding: 8px 18px;
  border-radius: 8px;
  font-size: 0.84em;
  font-weight: 700;
  text-decoration: none !important;
  box-shadow: 0 4px 12px rgba(27, 54, 93, 0.22);
}

.fig-box {
  background: #ffffff;
  border: 1px solid var(--slate-200);
  border-radius: 10px;
  padding: 8px;
  text-align: center;
  box-shadow: 0 2px 8px rgba(15, 23, 42, 0.05);
  overflow: visible;
  position: relative;
}

.fig-box img {
  max-width: 100%;
  height: auto;
  display: block;
  margin: 0 auto;
  border-radius: 4px;
  cursor: zoom-in;
  transition: transform 0.25s ease, box-shadow 0.25s ease;
}

.fig-box.is-zoomed { z-index: 45; }
.fig-box img.is-zoomed {
  position: relative;
  z-index: 46;
  box-shadow: 0 18px 44px rgba(15, 23, 42, 0.30);
  background: #ffffff;
}

.small-text { font-size: 0.83em; }
</style>

<!-- _class: lead -->

<div class="badge">國立高雄師範大學（NKNU）專題演講 · 2026/11/24 13:30–16:30</div>

# AI and Education

<div class="subtitle">
從全民 AI 應用出發：探討 AI 時代的程式設計教育、軟體工程研究、互動教材工程與 Harness 設計思維
</div>

<div class="meta-box">
<strong>主講人：薛念林 教授（Prof. Nien-Lin Hsueh）</strong><br>
逢甲大學 資訊工程學系（Department of Information Engineering and Computer Science, FCU）<br>
<code>nlhsueh@fcu.edu.tw</code> · 教材總門戶：<code>https://nlhsueh.github.io/teach/</code>
</div>

<!--
本場演講為國立高雄師範大學（2026/11/24 13:30–16:30，共三小時）之專題講座主軸簡報。全場設計為「中樞導覽（Hub）式簡報」，由生活化的 AI 全民化案例破題，結合現場問卷互動，並透過第 4 頁目錄直接串聯五篇已發表或投稿中之實證研究簡報（Pytutor 測試能力、AT-TPL AI 助教三元模式、SCT AI 稅率與 LADI、LLM UX 測試、PLANT 多代理人需求工程），最後回到第一線教學現場的個人工具實作（NickPocket）、互動題庫（NickEduPocket）、雙語教材工程（Courseware Design）與 Harness Engineering 系統化駕馭 AI 的核心框架。
-->

---

## 破題：一則讓人「下巴掉下來」的 Threads 貼文

<div class="split64">
<div class="left">

<div class="threads-phone">
<div class="threads-top">
<div class="threads-user">
<div class="threads-avatar">@</div>
<div><strong>threads 熱門分享</strong> <span style="color:#64748b;">· 剛剛</span><br><strong style="color:#8c1d40; font-size:1.08em;">標題：很扯</strong></div>
</div>
<span style="color:#64748b; font-weight:700;">•••</span>
</div>

昨天搭計程車的時候，發現司機大哥在聽 VK 科技閱讀講 <span class="threads-hl">NotebookLM</span>，所以就跟他聊了起來，發現他也有聽曼報，甚至以前也有聽科技島讀，我也跟他分享以前的創業經歷。<br><br>
接著更加刷新三觀的是，他說他用 <span class="threads-hl">Claude Code vibe coding</span> 做出了一個可以幫助他比較好算跑車收入的 app，還用 <span class="threads-hl">Typeless 搭配 Obsidian 串 agent</span> 做了他個人的日記管理系統。<br><br>
我整個下巴快掉下來……重點是他是一個<strong>全職計程車司機</strong>。還一直跟我說他覺得他 AI 用得沒有很好，他知道之後自己一定會被無人車取代，所以提早開始學習新科技。<br><br>
Oh my god！我跟他說，他的 AI 使用程度絕對是非常頂尖的，甚至贏過非常非常多年輕人跟上班族。我也覺得蠻激動的，感覺真的看到了那種<strong>科技平民化、AI 全民化</strong>的影子。

<div class="threads-actions">
<span>❤️ 12.4K</span><span>💬 842</span><span>🔁 2.1K</span><span>📤 分享</span>
</div>
</div>

</div>
<div class="right">

<div class="card accent" style="margin-bottom: 14px;">

### 💡 什麼才是「100 分的 AI 使用」？
AI 用得好真的不是要懂什麼艱深的工具或專有名詞，而是**能像這位司機大哥一樣，實際解決工作跟生活的問題**，就是最完美的 100 分！

</div>

<div class="card teal small-text">

### 🔍 給教育現場的三個震撼反思
- **危機感驅動自主學習**：面對無人車浪潮，主動提前升級能力。
- **軟體開發門檻崩解**：非資訊背景也能用 Vibe Coding 打造專屬工具。
- **大學教育的重新定位**：當工具人人可用，我們該教學生什麼？

</div>

</div>
</div>

<!--
此真實社群案例（Threads 貼文「很扯」）具體呈現了 2025–2026 年間生成式 AI 普及後的「科技平民化（Democratization of Technology）」現象：一位無資訊工程學歷背景的全職計程車司機，因預見自動駕駛（無人車）對職業的衝擊，主動透過科技 Podcast（VK 科技閱讀、曼報、科技島讀）吸收新知，並進一步以 Claude Code 進行 Vibe Coding 自行開發跑車收入計算 App，再結合語音輸入工具（Typeless）與知識庫（Obsidian）串接 AI Agent 建立個人日記管理系統。此案例對高等教育提出根本挑戰：當「寫出可用軟體」不再是資訊科系的專利，程式設計與軟體工程教育的價值重心必須從純語法記憶轉向問題定義、驗證能力、系統架構與駕馭 AI 的方法論。
-->

---

<!-- _class: question-slide -->

<div class="big-q">
大家用 AI 做了什麼事？<br>
<span>（寫作業除外！）</span>
</div>

* <a href="https://forms.gle/5wdGkgk71ZF6qZkY8" target="_blank" rel="noopener" title="開啟現場互動問卷"><img src="./img/qr_survey.png" alt="現場問卷 QR Code" class="qr-clean"></a>

<!--
本頁刻意採用極簡置中構圖，先拋出核心大問題「大家用 AI 做了什麼事？（寫作業除外！）」，給予現場聽眾思考空間；按下一步後再無邊框淡入 Google Forms QR Code（https://forms.gle/5wdGkgk71ZF6qZkY8）邀請掃碼作答。加上「寫作業除外」的限制條件，目的是區分「被動應付課業（把 AI 當代寫工具）」與「主動解決真實問題（把 AI 當生產力槓桿）」兩種截然不同的使用心態。
-->

---

## 演講主軸目錄（點擊各項目直接跳轉簡報或實作）

<div class="hub-grid">

<div class="hub-card teal">
<div class="hub-title">⚖️ 1. AI ➔ Good or Bad?</div>
<div class="hub-links">
<a class="hub-link" href="#6"><span>🧰 NickPocket：個人專屬 AI 百寶箱實作</span><span class="hub-badge">本簡報 #6</span></a>
<a class="hub-link" href="https://nick-pocket.web.app/" target="_blank" rel="noopener"><span>🌐 NickPocket 線上系統直接展示</span><span class="hub-badge">Web App ↗</span></a>
</div>
</div>

<div class="hub-card">
<div class="hub-title">💻 2. AI ➔ Programming（程式教育）</div>
<div class="hub-links">
<a class="hub-link" href="../../MyResearch/23Testability/Testability_slide_zh.html" target="_blank" rel="noopener"><span>🧪 Online Judge &amp; Testability（Pytutor）</span><span class="hub-badge">2023 簡報 ↗</span></a>
<a class="hub-link" href="../../MyResearch/26Pattern/Pattern26_slide_zh.html" target="_blank" rel="noopener"><span>🧩 From Online Judge to Tutor（AT-TPL）</span><span class="hub-badge">2026 簡報 ↗</span></a>
<a class="hub-link" href="../../MyResearch/27SCT/SCT_slide_zh.html" target="_blank" rel="noopener"><span>🚕 AI Tax &amp; LADI（Smart Coding Tutor）</span><span class="hub-badge">2026 簡報 ↗</span></a>
</div>
</div>

<div class="hub-card accent">
<div class="hub-title">🏗️ 3. AI ➔ Software Engineering</div>
<div class="hub-links">
<a class="hub-link" href="../../MyResearch/24UXtesting/UXtesting_slide_zh.html" target="_blank" rel="noopener"><span>🎨 User Experience and AI（LLM UX Testing）</span><span class="hub-badge">2024 簡報 ↗</span></a>
<a class="hub-link" href="../../MyResearch/26Plant/Plant_slide_zh.html" target="_blank" rel="noopener"><span>🤖 Requirement Engineering &amp; Multi-Agents（PLANT）</span><span class="hub-badge">2026 簡報 ↗</span></a>
<a class="hub-link" href="#5"><span>🗺️ 五篇核心論文研究脈絡總覽圖</span><span class="hub-badge">本簡報 #5</span></a>
</div>
</div>

<div class="hub-card amber">
<div class="hub-title">🏫 4. AI ➔ Teaching（教學與開發實踐）</div>
<div class="hub-links">
<a class="hub-link" href="https://nlhsueh.github.io/nickedupocket/" target="_blank" rel="noopener"><span>🎯 NickPocketEdu 互動隨堂題庫平台</span><span class="hub-badge">Web App ↗</span></a>
<a class="hub-link" href="#7"><span>📚 Courseware Design（AI 教材工程）</span><span class="hub-badge">本簡報 #7</span></a>
<a class="hub-link" href="#8"><span>☕ Vibe Coding 實戰循環（喝咖啡寫程式）</span><span class="hub-badge">本簡報 #8</span></a>
<a class="hub-link" href="#9"><span>🐴 Harness Engineering（駕馭 AI 框架）</span><span class="hub-badge">本簡報 #9</span></a>
</div>
</div>

</div>

<!--
本頁為全場演講的四維度架構總覽與超連結中樞，所有條目皆可直接點擊開啟對應之投影片或線上系統：
1. AI ➔ Good or Bad?：透過自建個人工具 NickPocket 展示 AI 賦能的正向價值，同時反思依賴風險。
2. AI ➔ Programming：串聯逢甲團隊四年演進脈絡——從強調學生自寫測試的 Pytutor（Electronics 2023），進化到三元角色分工的 AI 助教模式 AT-TPL（JISE 2026），再到以「AI 稅率（0%–20%）」與「LADI 依賴指標」兼顧學習鷹架與評量鑑別度的 Smart Coding Tutor（SCT）。
3. AI ➔ Software Engineering：展示 LLM 如何深入傳統軟體工程上游與下游——包括結合 Rapi 錄製與 Nielsen 啟發式準則的多模態 UX 自動檢測（Electronics 2024），以及六角色多代理人需求工程平台 PLANT（JISE 2026）。
4. AI ➔ Teaching：聚焦第一線教師如何將 AI 系統化導入教學，涵蓋 NickPocketEdu 互動題庫、雙語互動教材工程（Courseware Design）、Vibe Coding 實戰循環與 Harness Engineering 設計思維。
-->

---

## 研究脈絡總覽：五篇核心論文的動機與結論

<div class="fig-box" style="padding: 8px 10px; margin-top: 4px;">
<img src="./img/diag_research_roadmap.svg" alt="五篇核心論文研究脈絡與演進示意圖" style="max-height: 465px;">
</div>

<!--
本頁將今日演講所串聯之五篇逢甲研究團隊核心論文濃縮為雙主軸演進圖，方便聽眾先掌握全局再點擊進入個別論文細節：
主軸一（AI ➔ Programming，由「測」到「教」再到「控」）：（1）Pytutor（Electronics 2023）針對傳統 Online Judge 僅重視輸出對錯、忽略測試能力的痛點，引導學生於提交前自寫測試案例（DTC），實證顯著提升平時成效；（2）AT-TPL（JISE 2026）針對單一 AI 助教角色混雜且易直接給答案的問題，提出 Guidey（引導）、Debuggy（除錯）、Opti（優化）三元分工模式，實證顯示 67.4% 學生併用多助教並達 73.9% 通過率；（3）SCT（2026）直面 AI 造成作業滿分膨脹與評量失真，設計五級分層輔助、0%–20% AI 稅與 LADI 依賴指標，將滿分集中率由 52.7% 有效降至 13.4%。
主軸二（AI ➔ Software Engineering，上游需求 × 下游體驗）：（4）PLANT（JISE 2026）解決單一 LLM 易漏隱性需求與衝突調解不足之限制，以六角色多代理人混合調解與外部知識庫達成隱性需求 2.5–3.2× 與衝突召回 96–100%；（5）LLM UX Testing（Electronics 2024）解決人工易用性測試高成本與主觀問題，結合 Rapi 錄製與多模態 GPT-4 啟發式檢測，F1 達 0.66 大幅超越人類受試者（0.16）。五篇研究最終共同匯聚於「角色分工 × 分層邊界 × 自動驗證」之 AI 駕馭核心理念。
-->

---

## AI ➔ Good or Bad? 實作案例：NickPocket 個人百寶箱

以 AI 協作打造的**個人專屬 PWA 行動工具箱**，以 `NickPocket` 為核心向外延伸 **8 大生活與研究模組**（點擊下方心智圖直接開啟線上系統 ↗）：

<div class="fig-box" style="padding: 8px 12px; margin-top: 8px;">
<a href="https://nick-pocket.web.app/" target="_blank" rel="noopener" title="點擊開啟 NickPocket 線上系統（nick-pocket.web.app）" style="display: block;">
<img src="./img/diag_nickpocket_mindmap.svg" alt="NickPocket 八大功能心智圖（點擊開啟線上系統）" style="max-height: 450px; cursor: pointer;">
</a>
</div>

<!--
NickPocket（https://nick-pocket.web.app/）是講者透過 AI 輔助開發建置之個人行動工具箱（Progressive Web App, PWA），整合 Google 身分驗證與雲端即時資料庫，以中心向外延伸八大日常與研究模組：左側涵蓋 Musings（生活隨筆並支援 ePub 電子書匯出）、Bullet Journal（子彈筆記與每日任務目標排程）、Body Rhythm（身心節律與作息健康追蹤）、Nick English（每日文章抓取、單字本與 Quiz Game）；右側涵蓋 Research（研究脈絡與文獻筆記）、Investment（資產配置與定期定額 ROI 追蹤）、Ledger（輕量日常記帳）與 Inventory（個人物品盤點）。在「AI ➔ Good or Bad?」的脈絡下，NickPocket 作為正向案例展示「個人化微軟體（Personal Software）」時代的來臨，個人與教師皆能低成本打造高度契合自身工作流的專屬系統。
-->

---

## AI ➔ Teaching：Courseware Design（AI 教材工程）

<div class="split55">
<div class="left small-text">

### 📚 跨課程統一教學門戶與教材特色
- **一致性的風格**：跨課程（SE、UX、SQA、Python、Talk）共用主題與排版規格，消除版面雜亂。
- **引導教材生成，豐富內容**：
  - 結合 AI 產出**生動的圖片與概念示意圖**，將抽象理論視覺化。
  - 打造**互動式教材**（實例：<a href="https://nlhsueh.github.io/teach/SE/Slide/html/slide06e_ux.html?transition=fade#60" target="_blank" rel="noopener">Nielsen 啟發式複習 ↗</a>、<a href="https://nlhsueh.github.io/teach/SE/Slide/html/slide07e_test.html?transition=fade#42" target="_blank" rel="noopener">BVA 邊界值教學 ↗</a>）。
- **中英文雙語同步**：
  - 同步維護**中英文雙語教材**，支援 **`🌐 繁` ⇄ `🌐 EN` 逐頁同頁切換**。
- **多元測驗與平台整合**：
  - 內建**即時自我測驗**、課堂 **CCQ** 與 **Game** 互動。
  - 自動同步題庫至 **NickEduPocket**，並無縫銜接校內 **iLearn** 學習平台。

<div style="margin-top: 10px;">
<a href="https://nlhsueh.github.io/teach/" target="_blank" rel="noopener" class="cta-btn">🏫 造訪課程教材總門戶（nlhsueh.github.io/teach/）↗</a>
</div>

</div>
<div class="right">

<div class="fig-box" style="padding: 10px;">
<img src="./img/diag_courseware.svg" alt="Courseware Design 教材工程概念架構圖" style="max-height: 435px;">
</div>

</div>
</div>

<!--
Courseware Design（教材工程）將軟體工程的「單一源碼（Single Source of Truth）」、「版本控制（Git + GitHub Pages）」與「自動化建置管線」導入大學教學教材製作（門戶網址：https://nlhsueh.github.io/teach/）。四大核心設計分別為：（1）以 AGENTS.md 與跨課程 CSS 主題庫確保所有課程簡報與講義具一致視覺規範；（2）透過 AI 輔助生成概念向量圖（SVG）、情境漫畫與互動增強腳本（如不超出投影片邊界的動態懸停放大）；（3）維護完全對齊的中英文雙語 Markdown 簡報，並透過 URL Hash 保留機制達成同頁一鍵語系切換（🌐 繁 ⇄ 🌐 EN）；（4）透過自動化腳本（如 sync_iActivity.py）解析簡報與講義中的隨堂概念測驗（CCQ）與遊戲化活動，自動產出 QR Code 並同步至 NickEduPocket 與學校 iLearn 系統，形成教學與評量閉環。
-->

---

## AI ➔ Workflow：Vibe Coding 實戰循環

<div class="fig-box" style="padding: 4px 10px; margin-top: 2px; border: 1px solid #e2e8f0;">
<img src="./img/vibe_coding_loop.jpg" alt="Vibe Coding 五步驟循環卡通示意圖" style="max-height: 365px;">
</div>

<div style="display: grid; grid-template-columns: repeat(5, 1fr); gap: 8px; margin-top: 10px; font-size: 0.72em; text-align: center;">
<div style="background: #f8fafc; border: 1px solid #cbd5e1; border-top: 3px solid #1b365d; border-radius: 8px; padding: 6px 6px;">
<strong style="color: #1b365d;">① 準備環境</strong><br>工作區、工具與規範就定位
</div>
<div style="background: #fffbeb; border: 1px solid #fde68a; border-top: 3px solid #d97706; border-radius: 8px; padding: 6px 6px;">
<strong style="color: #b45309;">② 下達指令</strong><br>描述目標、規格與驗收條件
</div>
<div style="background: #f0fdfa; border: 1px solid #99f6e4; border-top: 3px solid #0f766e; border-radius: 8px; padding: 6px 6px;">
<strong style="color: #0f766e;">③ Agents 開工</strong><br>多代理人併發實作與測試
</div>
<div style="background: #fdf2f5; border: 1px solid #fbcfe8; border-top: 3px solid #8c1d40; border-radius: 8px; padding: 6px 6px;">
<strong style="color: #8c1d40;">④ 喝咖啡滑手機</strong><br>釋放雙手，等待進度完成
</div>
<div style="background: #eff6ff; border: 1px solid #bfdbfe; border-top: 3px solid #2563eb; border-radius: 8px; padding: 6px 6px;">
<strong style="color: #1d4ed8;">⑤ 驗收再微調 ↻</strong><br>檢視成果並回饋進入下一輪
</div>
</div>

<div class="callout" style="margin-top: 10px; padding: 8px 16px; font-size: 0.82em;">
<strong>關鍵提問：</strong> 「喝咖啡滑手機」之所以能安心放手、不必擔心 AI 亂寫或跑版，全靠第一步與第五步背後的工程基礎 ➔ <strong>Harness Engineering</strong>！
</div>

<!--
本頁以輕鬆的卡通循環描繪 AI 時代的「Vibe Coding」實作工作流：開發者／教師的角色從逐行手寫程式碼，轉變為高層次的「任務規劃與驗收循環」：（1）準備好開發環境、檔案結構與專案規則；（2）以自然語言清楚下達需求指令與驗收標準；（3）交由 AI Agents 自主併發撰寫程式、產生圖表與執行測試；（4）人類得以暫時脫離繁瑣細節（喝杯咖啡、滑手機處理其他事務）；（5）回來檢視產出成果、提出修正回饋，再次回到步驟（2）形成快速迭代閉環。本頁在結構上作為承先啟後的橋樑，點出一個核心工程問題：若缺乏明確規則、自動驗證與邊界控管，第（4）步放手只會換來失控的程式碼；正因如此，才引出下一頁的「Harness Engineering（駕馭 AI 的系統化馬具框架）」。
-->

---

## AI ➔ Engineering：Harness Engineering（駕馭 AI 的設計思維）

模型能力持續暴漲，但**真正決定 AI 系統可靠度與教學品質的關鍵，不在單一 Prompt，而在「Harness（馬具系統）」的設計**。

<div class="fig-box" style="padding: 8px 10px; margin-top: 6px;">
<img src="./img/diag_harness.svg" alt="Harness Engineering 四大支柱概念架構圖" style="max-height: 360px;">
</div>

<div class="callout" style="margin-top: 14px;">
<strong>貫穿今日演講的共同主軸：</strong> 無論是 <strong>SCT 的分層邊界與 AI 稅</strong>、<strong>PLANT 的調解者與 PlantUML 驗證</strong>，還是 <strong>Courseware 的 AGENTS.md 與編譯檢查</strong>，本質上都是 <strong>Harness Engineering</strong> 的具體實踐！
</div>

<!--
Harness Engineering（駕馭工程／馬具設計）是 AI-Augmented Software Engineering（AASD）時代的核心工程方法論。將大型語言模型（LLM）比喻為動力強大但行為具隨機性的「駿馬」，單純依賴人工反覆微調提示詞（Prompt Engineering）難以在複雜任務中維持穩定品質；唯有圍繞模型建構完整的 Harness（馬具框架），包含：（1）規範與護欄（Rules & Guardrails，如 AGENTS.md 防破版規則、SCT 禁止直接輸出完整解答的邊界）；（2）上下文與技能（Context & Skills，如領域法規庫、多角色分工提示詞）；（3）工具與自動驗證迴路（Verification Loop，如編譯器、Online Judge、突變測試、PlantUML 語法驗證與視覺截圖檢查）；（4）人機協作檢查點（Human-in-the-Loop，關鍵決策與僵局升級由人類裁決），才能把 AI 從「不可控的玩具」轉化為「可控、可驗證、可重現的工程與教育系統」。
-->

---

<!-- _class: closing -->

# AI × 教育：從「用工具」邁向「設計系統」

<p style="font-size: 0.98em; max-width: 820px; margin-bottom: 20px;">
當計程車司機都能用 AI 解決生活問題，高等教育的使命是培養能<strong>定義問題、設計護欄、驗證品質並駕馭 AI 系統</strong>的下一代人才。
</p>

<div style="display: flex; gap: 22px; align-items: center; background: rgba(255,255,255,0.12); border: 1px solid rgba(255,255,255,0.28); border-radius: 14px; padding: 18px 30px; text-align: left;">
<div style="font-size: 0.84em; line-height: 1.75; color: #f8fafc;">
<strong>薛念林 教授（Prof. Nien-Lin Hsueh）</strong> · 逢甲大學資訊工程學系<br>
📧 Email：<code>nlhsueh@fcu.edu.tw</code><br>
🏫 課程教材總門戶：<code>https://nlhsueh.github.io/teach/</code><br>
🎯 互動隨堂題庫：<code>https://nlhsueh.github.io/nickedupocket/</code><br>
🧰 個人百寶箱：<code>https://nick-pocket.web.app/</code>
</div>
<div style="background: #ffffff; padding: 8px; border-radius: 10px; text-align: center;">
<img src="./img/qr_teach.png" alt="教材總門戶 QR Code" style="width: 112px; height: 112px; display: block;">
<div style="font-size: 11px; font-weight: 800; color: #1b365d; margin-top: 4px;">教材總門戶</div>
</div>
</div>

<!--
結語總結本場三小時演講之核心論點：在生成式 AI 全面普及的時代，教育現場不應停留於「禁止或放任 AI」的二元對立，而應透過個人賦能（NickPocket）、分層可控輔助（SCT / AT-TPL）、多代理人專業協作（PLANT / LLM UX Testing）、雙語互動教材工程（Courseware Design）與系統化駕馭架構（Harness Engineering），引導學生從單純的「AI 工具使用者」成長為具備問題定義、品質驗證與系統設計能力的「AI 系統駕馭者」。右側提供教材總門戶（https://nlhsueh.github.io/teach/）QR Code 供與會師生課後持續瀏覽與交流。
-->

<script>
document.addEventListener('click', (e) => {
  const btn = e.target.closest('.nav-btn');
  if (btn) {
    e.stopPropagation();
    const dd = btn.closest('.nav-dropdown');
    const wasOpen = dd.classList.contains('open');
    document.querySelectorAll('.nav-dropdown.open').forEach(el => el.classList.remove('open'));
    if (!wasOpen) dd.classList.add('open');
    return;
  }
  document.querySelectorAll('.nav-dropdown.open').forEach(el => el.classList.remove('open'));
});

// Dynamic bounded in-place hover zoom (max 2.15x, strictly within 1280x720 safe area)
document.querySelectorAll('.split64 .fig-box img, .split55 .fig-box img, .two-col .fig-box img').forEach((img) => {
  const box = img.closest('.fig-box');
  img.addEventListener('mouseenter', () => {
    const sec = img.closest('section');
    if (!sec) return;
    img.style.transform = '';
    const sr = sec.getBoundingClientRect();
    const ir = img.getBoundingClientRect();
    if (!ir.width || !ir.height) return;
    const padX = sr.width * (24 / 1280);
    const padTop = sr.height * (52 / 720);
    const padBot = sr.height * (22 / 720);
    const safeL = sr.left + padX;
    const safeR = sr.right - padX;
    const safeT = sr.top + padTop;
    const safeB = sr.bottom - padBot;
    const maxW = safeR - safeL;
    const maxH = safeB - safeT;
    const s = Math.min(2.15, (maxW / ir.width) * 0.98, (maxH / ir.height) * 0.98);
    if (s <= 1.03) return;
    const L = Math.max(0, ir.left - safeL);
    const R = Math.max(0, safeR - ir.right);
    const T = Math.max(0, ir.top - safeT);
    const B = Math.max(0, safeB - ir.bottom);
    const ox = (L + R) > 0 ? (L / (L + R)) * 100 : 50;
    const oy = (T + B) > 0 ? (T / (T + B)) * 100 : 50;
    img.style.transformOrigin = ox.toFixed(1) + '% ' + oy.toFixed(1) + '%';
    img.style.transform = 'scale(' + s.toFixed(3) + ')';
    img.classList.add('is-zoomed');
    if (box) box.classList.add('is-zoomed');
  });
  img.addEventListener('mouseleave', () => {
    img.style.transform = '';
    img.classList.remove('is-zoomed');
    if (box) box.classList.remove('is-zoomed');
  });
});
</script>
