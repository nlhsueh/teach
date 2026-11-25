---
marp: true
theme: gaia
size: 16:9
paginate: true
html: true
header: '<div class="hdr-wrap"><span class="hdr-title">Adaptively Embedding Binary Data in an Image (FI 2008)</span><div class="hdr-actions"><a class="lang-btn" href="./AdaptiveHiding_slide_zh.html" title="切換至繁體中文簡報">🌐 繁</a><div class="nav-dropdown"><button class="nav-btn">Sections ▾</button><div class="nav-menu"><a href="#2">Outline</a><a href="#3">1. Introduction & Motivation</a><a href="#4">2. Related Work & OPAP</a><a href="#6">3. Proposed Adaptive DEM</a><a href="#10">4. Experimental Results</a><a href="#14">5. Conclusions</a></div></div></div></div>'
footer: 'Ching-Chiuan Lin, Nien-Lin Hsueh & Wen-Hsiang Shen · Feng Chia University · Fundamenta Informaticae 2008'
---

<style>
@import url('https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700;800&family=JetBrains+Mono:wght@500;600&display=swap');

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
  font-family: 'Inter', -apple-system, BlinkMacSystemFont, 'Segoe UI', sans-serif;
  font-size: 20px;
  line-height: 1.46;
  padding: 66px 52px 46px 52px;
  box-sizing: border-box;
  letter-spacing: 0.01em !important;
}

section h1, section h2, section h3 { letter-spacing: 0 !important; }
section:not(.lead):not(.closing) > p { max-width: 980px; }

/* Header & Navigation Dropdown */
header {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  height: 44px;
  padding: 0 52px;
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
.hdr-actions { display: inline-flex; align-items: center; gap: 8px; }

.lang-btn {
  background: rgba(255, 255, 255, 0.14);
  color: #ffffff !important;
  border: 1px solid rgba(255, 255, 255, 0.28);
  border-radius: 6px;
  padding: 3px 10px;
  font-size: 12px;
  font-weight: 600;
  text-decoration: none !important;
  cursor: pointer;
  display: inline-flex;
  align-items: center;
  gap: 4px;
  line-height: 1.35;
  transition: background 0.15s ease;
}
.lang-btn:hover { background: rgba(255, 255, 255, 0.26); text-decoration: none !important; }

.nav-dropdown { position: relative; display: inline-block; padding-bottom: 6px; margin-bottom: -6px; }
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
  min-width: 235px;
  background: #ffffff;
  border: 1px solid var(--slate-200);
  border-radius: 8px;
  box-shadow: 0 10px 24px rgba(15, 23, 42, 0.18);
  padding: 6px 0;
  z-index: 200;
}
.nav-dropdown:hover .nav-menu, .nav-dropdown.open .nav-menu { display: block; }
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

@media print { .lang-btn, .nav-dropdown { display: none !important; } }

/* Footer & Pagination */
footer {
  position: absolute;
  left: 52px;
  bottom: 14px;
  font-size: 12.5px;
  color: var(--slate-500);
  font-weight: 500;
}

section::after {
  position: absolute;
  right: 52px;
  bottom: 14px;
  font-size: 12.5px;
  font-weight: 700;
  color: var(--navy);
  content: attr(data-marpit-pagination) ' / ' attr(data-marpit-pagination-total);
}

/* Headings */
h1 { color: var(--navy); font-size: 1.68em; font-weight: 800; line-height: 1.22; margin: 0 0 12px 0; }
h2 {
  color: var(--navy);
  font-size: 1.22em;
  font-weight: 700;
  line-height: 1.25;
  margin: 0 0 12px 0;
  padding-bottom: 6px;
  border-bottom: 2.5px solid var(--navy);
  display: flex;
  align-items: center;
  gap: 8px;
}
h3 { color: var(--accent); font-size: 0.95em; font-weight: 700; margin: 4px 0 6px 0; }

p { margin: 0 0 8px 0; }
ul, ol { margin: 4px 0 8px 0; padding-left: 22px; }
li { margin-bottom: 5px; line-height: 1.42; }
strong { color: var(--slate-900); }
a { color: #2563eb; text-decoration: none; }
a:hover { text-decoration: underline; }

/* Inline code without background */
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
section table th { background: var(--navy) !important; color: #ffffff !important; }
section table th strong, section table th code { color: #ffffff !important; }
section.lead strong, section.closing strong { color: #ffffff !important; }
section.lead code, section.closing code { color: #bae6fd !important; }

/* Lead Slide */
section.lead {
  background: linear-gradient(135deg, #102442 0%, #1b365d 62%, #294c7a 100%);
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
  font-size: 0.72em;
  font-weight: 600;
  letter-spacing: 0.06em;
  text-transform: uppercase;
  padding: 5px 14px;
  border-radius: 999px;
  margin-bottom: 18px;
}
section.lead h1 { color: #ffffff; font-size: 2.02em; font-weight: 800; line-height: 1.24; margin-bottom: 16px; text-align: left; }
section.lead .subtitle { color: #cbd5e1; font-size: 0.94em; line-height: 1.5; margin-bottom: 26px; max-width: 960px; }
section.lead .meta-box { border-left: 4px solid #f43f5e; padding-left: 18px; color: #e2e8f0; font-size: 0.85em; line-height: 1.6; }
section.lead .grant { margin-top: 20px; font-size: 0.74em; color: #94a3b8; }

/* Closing Slide */
section.closing {
  background: linear-gradient(135deg, #102442 0%, #1b365d 65%, #8c1d40 100%);
  color: #ffffff;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  text-align: center;
  padding: 54px 72px;
}
section.closing header, section.closing footer, section.closing::after { display: none !important; }
section.closing h1 { color: #ffffff; font-size: 2.2em; margin-bottom: 12px; }
section.closing p { color: #e2e8f0; }
section.closing .contact-card {
  margin-top: 22px;
  background: rgba(255, 255, 255, 0.12);
  border: 1px solid rgba(255, 255, 255, 0.25);
  border-radius: 12px;
  padding: 18px 36px;
  font-size: 0.85em;
  line-height: 1.68;
  color: #f8fafc;
}

/* Layouts & Cards */
.two-col { display: grid; grid-template-columns: 1fr 1fr; gap: 18px; align-items: stretch; }
.three-col { display: grid; grid-template-columns: repeat(3, 1fr); gap: 14px; align-items: stretch; }
.split64 { display: grid; grid-template-columns: 56% 42%; gap: 2%; align-items: center; }
.split55 { display: grid; grid-template-columns: 49% 49%; gap: 2%; align-items: center; }
.split46 { display: grid; grid-template-columns: 42% 56%; gap: 2%; align-items: center; }

.card {
  background: #ffffff;
  border: 1px solid var(--slate-200);
  border-top: 3.5px solid var(--navy);
  border-radius: 8px;
  padding: 12px 15px;
  box-shadow: 0 2px 6px rgba(15, 23, 42, 0.05);
  box-sizing: border-box;
}
.card.accent { border-top-color: var(--accent); }
.card.teal { border-top-color: var(--teal); }

.kpi-card {
  background: var(--slate-100);
  border: 1px solid var(--slate-200);
  border-left: 4px solid var(--navy);
  border-radius: 8px;
  padding: 10px 14px;
  box-sizing: border-box;
}
.kpi-card.accent { border-left-color: var(--accent); background: var(--accent-soft); }
.kpi-card.teal { border-left-color: var(--teal); background: var(--teal-soft); }
.kpi-val { font-size: 1.35em; font-weight: 800; color: var(--navy); line-height: 1.15; margin-bottom: 3px; }
.kpi-card.accent .kpi-val { color: var(--accent); }
.kpi-card.teal .kpi-val { color: var(--teal); }
.kpi-label { font-size: 0.75em; color: var(--slate-700); line-height: 1.34; }

.callout {
  background: #f8fafc;
  border-left: 4px solid var(--accent);
  border-radius: 0 8px 8px 0;
  padding: 10px 16px;
  margin-top: 12px;
  font-size: 0.84em;
  color: var(--slate-700);
  line-height: 1.48;
}
.callout.teal { border-left-color: var(--teal); background: var(--teal-soft); }
.callout strong { color: var(--navy); }

/* Tables */
table {
  width: 100%;
  border-collapse: collapse;
  font-size: 0.73em;
  margin: 8px 0 10px 0;
  background: #ffffff;
  border: 1px solid var(--slate-200);
}
th {
  background: var(--navy);
  color: #ffffff;
  font-weight: 700;
  padding: 6px 8px;
  text-align: left;
  border: 1px solid var(--navy);
}
td {
  padding: 5px 8px;
  border: 1px solid var(--slate-200);
  vertical-align: middle;
  line-height: 1.32;
}
tr:nth-child(even) td { background: #f8fafc; }

/* Outline Grid */
.outline-grid { display: grid; grid-template-columns: 1fr 1fr; gap: 14px 22px; margin-top: 10px; }
.outline-item {
  display: flex;
  align-items: flex-start;
  gap: 12px;
  background: #f8fafc;
  border: 1px solid var(--slate-200);
  border-left: 4px solid var(--navy);
  border-radius: 8px;
  padding: 12px 16px;
}
.outline-num {
  background: var(--navy);
  color: #ffffff;
  font-weight: 800;
  font-size: 0.85em;
  width: 28px;
  height: 28px;
  border-radius: 6px;
  display: flex;
  align-items: center;
  justify-content: center;
  flex-shrink: 0;
  margin-top: 2px;
}
.outline-body { font-size: 0.85em; line-height: 1.38; }
.outline-body a { color: var(--navy); font-weight: 700; font-size: 1.05em; }

/* Figures & Hover Zoom */
.fig-box {
  background: #ffffff;
  border: 1px solid var(--slate-200);
  border-radius: 8px;
  padding: 8px;
  text-align: center;
  box-shadow: 0 2px 6px rgba(15, 23, 42, 0.05);
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
.fig-cap { font-size: 0.72em; color: var(--slate-500); margin-top: 5px; font-weight: 500; }

.eq-box {
  background: #f8fafc;
  border: 1px solid var(--slate-200);
  border-left: 4px solid var(--teal);
  border-radius: 6px;
  padding: 8px 14px;
  margin: 8px 0;
  font-family: 'JetBrains Mono', monospace;
  font-size: 0.78em;
  color: var(--slate-900);
  line-height: 1.5;
}
.small-text { font-size: 0.82em; }
.future-strip { display: grid; grid-template-columns: repeat(3, 1fr); gap: 12px; margin-top: 12px; }
.future-pill {
  background: #f8fafc;
  border: 1px solid var(--slate-200);
  border-left: 4px solid var(--teal);
  border-radius: 8px;
  padding: 10px 13px;
  font-size: 0.76em;
  line-height: 1.4;
  color: var(--slate-700);
}
.future-pill strong { color: var(--navy); }
</style>

<!-- _class: lead -->

<div class="badge">Fundamenta Informaticae · Vol. 84, pp. 1–12 · 2008 (IOS Press)</div>

# Adaptively Embedding Binary Data in an Image

<div class="subtitle">
Minimizing Stego-Image Distortion via <strong>Two-Segment Variable-Length Message Decomposition</strong> and <strong>Nearest-Neighbor Pixel Adjustment</strong>
</div>

<div class="meta-box">
<strong>Ching-Chiuan Lin<sup>*</sup></strong>, <strong>Nien-Lin Hsueh</strong>, and <strong>Wen-Hsiang Shen</strong><br>
Department of Information Engineering and Computer Science, Feng Chia University, Taichung 40724, Taiwan, ROC<br>
<code>cclin@ocit.edu.tw</code> · <code>nlhsueh@fcu.edu.tw</code> · <code>shen@ocit.edu.tw</code>
</div>

<div class="grant">
Keywords: Information hiding · LSB · Directory of Elementary Messages (DEM) · Optimal Pixel Adjustment Process (OPAP)
</div>

<!--
Bibliographic & Research Overview:
This paper (Lin, Hsueh, & Shen, Fundamenta Informaticae 84, 2008, pp. 1–12, IOS Press) proposes a high-visual-quality adaptive binary data hiding algorithm for grayscale host images.

Core Research Idea:
Conventional spatial-domain methods such as simple LSB substitution and Optimal Pixel Adjustment Process (OPAP) embed a fixed integer number k of bits per pixel (effective alphabet size q = 2^k). When the target embedding capacity C lies between integer bit counts (e.g., 1.5, 2.25, or 3.375 bpp), fixed-k methods must either waste pixel capacity or abruptly mix k-bit and (k+1)-bit embeddings. The proposed scheme instead divides the binary message M into two segments and decomposes them into n and n-1 types of variable-length elementary sub-messages (n >= 3) using a Directory of Elementary Messages (DEM). Each host pixel then embeds one sub-message by shifting to its nearest congruence class modulo n (or n-1), bounding pixel distortion to at most floor(n/2).
-->

---

## Presentation Outline

<div class="outline-grid">

<div class="outline-item">
  <div class="outline-num">1</div>
  <div class="outline-body"><a href="#3">Introduction & Motivation</a><br>Visual quality vs. capacity trade-off and why fixed 2<sup>k</sup> alphabets cause excess distortion.</div>
</div>

<div class="outline-item">
  <div class="outline-num">2</div>
  <div class="outline-body"><a href="#4">Related Work & OPAP Baseline</a><br>PVD, modulus hiding, LSB matching, EMD, simple LSB substitution, and Chan–Cheng OPAP.</div>
</div>

<div class="outline-item">
  <div class="outline-num">3</div>
  <div class="outline-body"><a href="#6">Proposed Adaptive DEM Algorithm</a><br>Directory of Elementary Messages (DEM), two-segment split, Eqs. (2)–(8), and 4×4 walkthrough.</div>
</div>

<div class="outline-item">
  <div class="outline-num">4</div>
  <div class="outline-body"><a href="#10">Experimental Setup & Results</a><br>Evaluation on Lena, Baboon, Airplane, and Pepper across 1.0 to 3.875 bpp (Tables 2–4).</div>
</div>

<div class="outline-item">
  <div class="outline-num">5</div>
  <div class="outline-body"><a href="#13">Distortion Mechanism Analysis</a><br>Why adaptive n-ary alphabets outperform OPAP at fractional bpp and match OPAP at k = 2, 3.</div>
</div>

<div class="outline-item">
  <div class="outline-num">6</div>
  <div class="outline-body"><a href="#14">Conclusions & Practical Impact</a><br>Summary of contributions, side-information footprint, and target steganographic applications.</div>
</div>

</div>

<!--
Structural Navigation:
The paper is organized into five sections: Section 1 introduces image steganography and surveys spatial-domain alternatives; Section 2 reviews simple LSB substitution and Chan & Cheng's OPAP [9]; Section 3 formally defines DEM_t(n), the expected capacity formula EC_n, the 8-step adaptive two-segment embedding algorithm, the modulo extraction procedure, and a complete 4x4 grayscale worked example; Section 4 reports Java/Windows XP experimental comparisons over 100 random messages per capacity on four 512x512 test images; Section 5 summarizes the bounded-distortion guarantee and conclusions.
-->

---

## 1. Introduction & Motivation

<div class="two-col">
<div class="card">
<h3>The Steganographic Quality–Capacity Dilemma</h3>
<ul>
  <li><strong>Applications:</strong> Intellectual property protection, confidential communication, and medium annotation.</li>
  <li><strong>Core requirement:</strong> Modify the cover (host) image as little as possible so the stego-image remains visually imperceptible.</li>
  <li><strong>Fixed-k bottleneck:</strong> Simple LSB and OPAP replace <code>k</code> bits per pixel, restricting the per-pixel alphabet size to powers of two (<code>2<sup>k</sup> ∈ {2, 4, 8, 16}</code>).</li>
  <li><strong>Coarse granularity:</strong> For non-integer capacities (e.g., 1.5 or 2.25 bpp), fixed-k schemes suffer unnecessary pixel value jumps.</li>
</ul>
</div>

<div class="card teal">
<h3>Our Adaptive Decomposition Insight</h3>
<ul>
  <li><strong>Break the fixed-bit constraint:</strong> Each pixel does <em>not</em> need to embed an identical number of bits.</li>
  <li><strong>Adaptive n-ary alphabet (n ≥ 3):</strong> Decompose binary message <code>M</code> into variable-length elementary sub-messages chosen by target capacity <code>C = #(M)/N</code>.</li>
  <li><strong>Two-segment minimization:</strong> Split <code>M</code> into <code>M'<sub>n</sub></code> (minimized) and <code>M''<sub>n−1</sub></code> (maximized) so most pixels use the smaller alphabet <code>n−1</code>.</li>
  <li><strong>Minimal pixel shift:</strong> Map each pixel to its nearest congruent neighbor, bounding error to <code>±⌊n/2⌋</code>.</li>
</ul>
</div>
</div>

<div class="callout teal">
<strong>Key Result:</strong> At 1.5 bpp, our scheme selects <code>n = 3</code> (max pixel change ±1) and achieves <strong>49.89 dB</strong> PSNR—surpassing OPAP by <strong>+1.76 dB</strong> and simple LSB by <strong>+3.52 dB</strong>.
</div>

<!--
Research Motivation (Section 1):
In spatial-domain image hiding, both direct LSB replacement and pixel-value adjustment alter host pixels and introduce distortion. While replacing k LSBs is straightforward, k is restricted to integers (typically k <= 4 for acceptable visual quality). Consequently, the number of representable states per pixel jumps exponentially (2, 4, 8, 16). By generalizing per-pixel states to arbitrary integers n >= 3 via prefix-free variable-length sub-message directories (DEM) and splitting M across n and n-1 states, the algorithm continuously adapts to any payload length #(M) and host image size N while minimizing squared error.
-->

---

## 2. Related Work: Spatial-Domain Data Hiding

| Category | Representative Works | Core Mechanism | Key Limitation Addressed by Our Method |
| :--- | :--- | :--- | :--- |
| **Pixel-Value Differencing (PVD)** | Wu & Tsai [4]; Wu et al. [5]; Chang et al. [6] | Embeds variable bits in neighboring pixel differences via predefined ranges `{0–7, 8–15, ...}` | Low capacity (< 1.6 bpp) and lower PSNR (< 42 dB); requires predefined range tables |
| **Modulus Function** | Wang [7]; Chang et al. [8] | Sets `y' = y − (y mod q) + x` with `±q` adjustment when `|y' − y| > q/2` | Requires `q = 2^k` for binary messages; equivalent to OPAP when `q = 2^k` |
| **LSB Matching & EMD** | Mielikainen [10]; Zhang & Wang [11] | Pairwise LSB matching (mod prob. 0.375); `(2R+1)`-ary EMD changes at most 1 pixel by ±1 in `R`-pixel block | Capacity strictly capped at 1 bpp [10] or `(log2(2R+1))/R` bpp [11] |
| **Block-Difference Image Hiding** | Li et al. [12]; Wang & Chen [13] | Matches smooth secret image blocks to host blocks or compresses via two-way matching | Restricted to hiding secret images; unsuitable for arbitrary binary bit streams |
| **LSB & OPAP** | Chan & Cheng [9] | Direct `k`-bit LSB substitution followed by optimal `±2^k` adjustment | Restricted to power-of-two alphabets `2^k`; suboptimal at fractional bpp |

<!--
Literature Positioning (Section 1):
The paper contrasts five families of spatial-domain schemes:
1. PVD-based schemes [4, 5, 6]: Wu & Tsai (2003) map difference ranges {0-7, 8-15, 16-31, 32-63, 64-127, 128-255} to bit lengths {3, 3, 4, 5, 6, 7}, yielding < 1.6 bpp and < 42 dB. Wu et al. (2005) hybridize LSB for differences < 16 with PVD otherwise, and Chang et al. (2006) use preceding-pixel differences to select k.
2. Modulus-function schemes [7, 8]: Achieve OPAP-like adjustment for modulus q, but embedding raw binary streams forces q = 2^k.
3. Low-distortion low-payload schemes [10, 11]: Mielikainen's LSB matching lowers modification probability from 0.5 to 0.375 at 1 bpp; Zhang & Wang's Exploiting Modification Direction (EMD) embeds a (2R+1)-ary digit per R pixels with capacity at most log2(2R+1)/R bpp (max ~1.16 bpp at R=2).
4. Secret-image-only schemes [12, 13]: Exploit spatial smoothness of secret images and cannot embed arbitrary binary messages.
Our algorithm bridges arbitrary binary payloads with fine-grained n-ary modulus embedding across wide capacities (1.0 to 3.875+ bpp).
-->

---

## 2. Baseline: Simple LSB Substitution & OPAP [9]

<div class="split55">
<div>
<div class="card">
<h3>Simple LSB Substitution</h3>
<div class="eq-box">
y' = y − (y mod 2<sup>k</sup>) + m &nbsp;&nbsp;(Eq. 1)<br>
Extraction: m = y' mod 2<sup>k</sup> &nbsp;(typically k ≤ 4)
</div>
<ul class="small-text">
  <li>Replaces the <code>k</code> least significant bits of host pixel <code>y</code> directly with <code>k</code>-bit message <code>m</code>.</li>
  <li>Maximum pixel error can reach <code>2<sup>k</sup> − 1</code> (e.g., error −3 when <code>k = 2</code>).</li>
</ul>
</div>

<div class="card accent" style="margin-top: 10px;">
<h3>Chan &amp; Cheng's OPAP [9]</h3>
<ul class="small-text">
  <li>Let <code>d<sub>i</sub> = b'<sub>i</sub> − b<sub>i</sub></code> after LSB substitution:</li>
  <li>If <code>−2<sup>k</sup> &lt; d<sub>i</sub> &lt; −2<sup>k−1</sup></code> and <code>b'<sub>i</sub> &lt; 256 − 2<sup>k</sup></code> ➔ add <code>2<sup>k</sup></code>.</li>
  <li>If <code>2<sup>k−1</sup> &lt; d<sub>i</sub> &lt; 2<sup>k</sup></code> and <code>b'<sub>i</sub> ≥ 2<sup>k</sup></code> ➔ subtract <code>2<sup>k</sup></code>.</li>
  <li>Otherwise keep <code>b'<sub>i</sub></code> unchanged ➔ halves worst-case error to <code>±2<sup>k−1</sup></code>.</li>
</ul>
</div>
</div>

<div class="fig-box">
<img src="./img/fig1_opap.png" alt="Figure 1: Examples of OPAP for k=2" style="max-height: 290px;">
<div class="fig-cap">Figure 1 (Paper p. 4): Examples of OPAP for k = 2 — (a) Embedding (00)<sub>2</sub> into (43)<sub>16</sub> shifts (40)<sub>16</sub> up to (44)<sub>16</sub> (error −3 ➔ +1); (b) Embedding (11)<sub>2</sub> into (44)<sub>16</sub> shifts (47)<sub>16</sub> down to (43)<sub>16</sub>.</div>
</div>
</div>

<!--
Detailed Mechanics of Baselines (Section 2):
Chan and Cheng (2004) [9] improve simple LSB substitution by observing that adding or subtracting 2^k preserves the k least significant bits (so extraction m = b'_i mod 2^k remains untouched) while pulling the stego-pixel closer to the original host pixel b_i.
In Figure 1(a), with k = 2 and b_i = (01000011)_2 = (43)_16 = 67, embedding m = (00)_2 via simple LSB gives b'_i = (01000000)_2 = (40)_16 = 64, yielding d_i = -3. Because -4 < d_i < -2 and b'_i < 252, OPAP adds 2^2 = 4 to obtain (01000100)_2 = (44)_16 = 68, cutting |d_i| from 3 down to 1. Figure 1(b) shows the symmetric case: embedding (11)_2 into (44)_16 = 68 yields (47)_16 = 71 (d_i = +3), which OPAP pulls down by 4 to (43)_16 = 67 (d_i = -1). Our proposed Eqs. (2)-(3) generalize this exact nearest-neighbor adjustment from power-of-two moduli 2^k to arbitrary integers n >= 3.
-->

---

## 3. Proposed Method: Adaptive Two-Segment DEM Pipeline

<div class="fig-box" style="padding: 8px 10px; margin-bottom: 10px;">
<img src="./img/diag1_adaptive_pipeline.svg" alt="Adaptive Two-Segment DEM Embedding Pipeline" style="max-height: 365px;">
</div>

<div class="callout">
<strong>Core Philosophy:</strong> Maximize the number of sub-messages (using all <code>N</code> host pixels) while minimizing the number of sub-message types <code>n</code>, keeping every pixel inside <code>{b<sub>i</sub> − ⌊n/2⌋, ..., b<sub>i</sub> + ⌊n/2⌋}</code>.
</div>

<!--
Architecture Overview (Section 3):
The proposed algorithm decouples binary message encoding from pixel-value modification through four stages:
1. Capacity & DEM Selection: Compute required capacity C = #(M)/N, select the smallest integer n >= 3 satisfying EC_n <= C < EC_{n+1}, and detect whether bit "1" or "0" dominates M to pick DEM_1(n) or DEM_0(n).
2. Two-Segment Decomposition: If |M_n| > N (due to bit-stream permutation variance), increment n by 1. Then split M = M'_n || M''_{n-1} so that |M'_n| + |M''_{n-1}| <= N with |M'_n| minimized (approximated by N * ER_n).
3. Nearest-Neighbor Pixel Embedding: Sequentially embed M'_n using modulus n and M''_{n-1} using modulus n-1 via Eqs. (2)-(3), guaranteeing |b''_i - b_i| <= floor(n/2) for non-oversaturated pixels.
4. O(1) Modulo Extraction: Recover sub-message index u = (b''_i mod n) + 1 (or mod (n-1)), look up m_u in the DEM, concatenate, and strip any trailing padding bits beyond #(M).
-->

---

## 3. Directory of Elementary Messages (DEM) & Expected Capacity

<div class="split64">
<div>

| Sub-msg | `n = 3` (`DEM1` / `DEM0`) | `n = 4` (`DEM1` / `DEM0`) | `n = 5` (`DEM1` / `DEM0`) | `n = 6` (`DEM1` / `DEM0`) | `n = 7` (`DEM1` / `DEM0`) |
| :--- | :---: | :---: | :---: | :---: | :---: |
| `m1` | `0` / `1` | `00` / `11` | `00` / `11` | `00` / `11` | `10` / `01` |
| `m2` | `10` / `01` | `01` / `10` | `01` / `10` | `01` / `10` | `110` / `001` |
| `m3` | `11` / `00` | `10` / `01` | `10` / `01` | `100` / `011` | `111` / `000` |
| `m4` | — | `11` / `00` | `110` / `001` | `101` / `010` | `000` / `111` |
| `m5` | — | — | `111` / `000` | `110` / `001` | `001` / `110` |
| `m6` | — | — | — | `111` / `000` | `010` / `101` |
| `m7` | — | — | — | — | `011` / `100` |
| **EC<sub>n</sub> (bpp)** | **1.50** | **2.00** | **2.25** | **2.50** | **2.75** |

</div>

<div>
<div class="card teal">
<h3>Balanced Prefix-Free Condition</h3>
<div class="eq-box">
⌊log<sub>2</sub> n⌋ ≤ #(m<sub>u</sub>) ≤ ⌈log<sub>2</sub> n⌉ &nbsp;&nbsp;(Eq. 4)<br>
EC<sub>n</sub> = ∑ #(m<sub>u</sub>) × P<sub>u</sub> &nbsp;&nbsp;(Eq. 5)<br>
EC<sub>n</sub> = ⌊log<sub>2</sub> n⌋ − 1 + n / 2<sup>⌊log<sub>2</sub> n⌋</sup> &nbsp;(Eq. 6)
</div>
<ul class="small-text">
  <li><strong>Balanced tree maximizes capacity:</strong> For <code>n = 4</code>, <code>{00, 01, 10, 11}</code> yields <code>2.00 bpp</code> vs. unbalanced <code>{0, 100, 101, 11}</code> at only <code>1.75 bpp</code>.</li>
  <li><strong>Bit-dominance matching:</strong> Choose <code>DEM<sub>1</sub>(n)</code> when bit <code>1</code> dominates <code>M</code> (since <code>#DEM<sub>1</sub>(3,1) = 3 &gt; 2</code>), or <code>DEM<sub>0</sub>(n)</code> when bit <code>0</code> dominates.</li>
  <li><strong>Symmetric case (n = 7):</strong> Both <code>DEM<sub>1</sub>(7)</code> and <code>DEM<sub>0</sub>(7)</code> have 10 ones and 10 zeros, so either may be chosen.</li>
</ul>
</div>
</div>
</div>

<!--
DEM Design & Mathematical Derivation (Section 3, Table 1, Eqs. 4–6):
A Directory of Elementary Messages (DEM) is a complete prefix-free binary code of size n (constructed by recursively splitting a leaf m_u into m_u0 and m_u1). To maximize expected capacity EC_n for a uniform random binary message, every codeword length #(m_u) must differ by at most 1 bit—formally, floor(log2 n) <= #(m_u) <= ceil(log2 n) (Eq. 4).
Proof sketch of Eq. (6): Let L = floor(log2 n). A balanced prefix-free set of n codewords splits (n - 2^L) leaves of length L into 2(n - 2^L) leaves of length L+1, leaving 2^L - (n - 2^L) = 2^{L+1} - n leaves of length L. Each leaf of length L has probability 2^{-L} and each leaf of length L+1 has probability 2^{-(L+1)}. Thus:
EC_n = (2^{L+1} - n) * L * 2^{-L} + 2(n - 2^L) * (L+1) * 2^{-(L+1)} = L + (n - 2^L)/2^L = L - 1 + n / 2^L bpp.
This yields the exact piecewise-linear capacity ladder: n=3 -> 1.5, n=4 -> 2.0, n=5 -> 2.25, n=6 -> 2.5, n=7 -> 2.75, n=8 -> 3.0, n=9 -> 3.125, n=10 -> 3.25, n=11 -> 3.375, n=13 -> 3.625, n=15 -> 3.875 bpp.
-->

---

## 3. Nearest-Neighbor Adjustment & Two-Segment Algorithm

<div class="two-col">
<div class="card">
<h3>Pixel Embedding Equations (Eqs. 2–3)</h3>
<div class="eq-box">
b'<sub>i</sub> = b<sub>i</sub> − (b<sub>i</sub> mod n) + u − 1 &nbsp;&nbsp;(Eq. 2)<br>
b''<sub>i</sub> = b'<sub>i</sub> + n &nbsp; if b<sub>i</sub> − b'<sub>i</sub> &gt; n/2 &amp; b'<sub>i</sub> ≤ 255−n<br>
b''<sub>i</sub> = b'<sub>i</sub> − n &nbsp; if (b'<sub>i</sub> − b<sub>i</sub> &gt; n/2 &amp; b'<sub>i</sub> ≥ n) or b'<sub>i</sub> &gt; 255<br>
b''<sub>i</sub> = b'<sub>i</sub> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; otherwise &nbsp;&nbsp;(Eq. 3)
</div>
<ul class="small-text">
  <li><strong>Odd n:</strong> Uses symmetric neighborhood <code>{b<sub>i</sub>−⌊n/2⌋, ..., b<sub>i</sub>+⌊n/2⌋}</code>.</li>
  <li><strong>Even n:</strong> Uses <code>n</code> consecutive values around <code>b<sub>i</sub></code> (bounded error <code>≤ ⌊n/2⌋</code> when not oversaturated).</li>
  <li><strong>Padding rule:</strong> If the tail of <code>M''<sub>n−1</sub></code> is incomplete, pad it to the DEM codeword minimizing pixel change.</li>
</ul>
</div>

<div class="card accent">
<h3>8-Step Adaptive Embedding &amp; Extraction</h3>
<ol class="small-text">
  <li>Compute <code>C = #(M)/N</code>; pick <code>n = 3</code> if <code>C ≤ 1.5</code>, else <code>EC<sub>n</sub> ≤ C &lt; EC<sub>n+1</sub></code>.</li>
  <li>Choose <code>DEM<sub>t</sub>(n)</code> by dominant bit <code>t</code>; decompose <code>M</code> ➔ <code>M<sub>n</sub></code>.</li>
  <li>If <code>|M<sub>n</sub>| &gt; N</code>, increment <code>n ← n + 1</code> and re-decompose.</li>
  <li>Split <code>M = M'<sub>n</sub> ∥ M''<sub>n−1</sub></code> with <code>|M'<sub>n</sub>| + |M''<sub>n−1</sub>| ≤ N</code> and <code>|M'<sub>n</sub>|</code> minimized: <code>|M'<sub>n</sub>| ≈ N × (C − EC<sub>n−1</sub>)/(EC<sub>n</sub> − EC<sub>n−1</sub>)</code>.</li>
  <li>Embed <code>M'<sub>n</sub></code> via <code>DEM<sub>t</sub>(n)</code>, then <code>M''<sub>n−1</sub></code> via <code>DEM<sub>t</sub>(n−1)</code> sequentially.</li>
  <li>Save side info: <code>n, |M'<sub>n</sub>|, |M''<sub>n−1</sub>|, #(M), DEM<sub>t</sub>(n), DEM<sub>t</sub>(n−1)</code>.</li>
</ol>
<div class="eq-box" style="margin-top: 6px;">
Extract (Eqs. 7–8): u' = b''<sub>i</sub> mod n (i &lt; |M'<sub>n</sub>|) else mod (n−1); u = u' + 1
</div>
</div>
</div>

<!--
Algorithmic & Boundary Details (Section 3, Eqs. 2–3 & 7–8):
Notice two crucial safeguards in Eq. (3):
1. Oversaturation protection: If b'_i > 255 (which can happen near 255 when u-1 > b_i mod n), Eq. (3) subtracts n so b''_i remains strictly within [0, 255]. Similarly, adding n requires b'_i <= 255 - n and subtracting n requires b'_i >= n.
2. Why two segments (n and n-1)? If step 4 increments n because |M_n| > N (or when C sits strictly between EC_{n-1} and EC_n), using DEM_t(n) across all pixels would leave many pixels unused while imposing larger max distortion floor(n/2) on every used pixel. Splitting M into M'_n (minimized) and M''_{n-1} (maximized) fills all N pixels while shifting as many pixels as possible into the tighter distortion envelope floor((n-1)/2). When n = 3, |M''_2| = 0 because n >= 3 is enforced.
-->

---

## 3. Permutation Sensitivity & 4×4 Worked Example

<div class="split55">
<div>
<div class="fig-box" style="margin-bottom: 10px;">
<img src="./img/fig2_capacity.png" alt="Figure 2: Embedding capacity examples for n=3" style="max-height: 120px;">
<div class="fig-cap">Figure 2 (Paper p. 7): Same 8 host pixels, DEM<sub>0</sub>(3) = {1, 01, 00} — bit permutation yields 1.75, 1.50, or 1.375 bpp.</div>
</div>

<div class="card teal">
<h3>Worked Example: 25 Bits in 4×4 Image</h3>
<ul class="small-text">
  <li><strong>Message:</strong> <code>M = (0110110101100011100101101)<sub>2</sub></code>, <code>C = 25/16 = 1.5625 bpp</code>.</li>
  <li><strong>Step 2–4:</strong> Bit <code>1</code> dominates ➔ <code>DEM<sub>1</sub>(3)</code> gives <code>|M<sub>3</sub>| = 17 &gt; 16</code> ➔ increment to <code>n = 4</code>.</li>
  <li><strong>Two-segment split:</strong> <code>|M'<sub>4</sub>| = 1</code> (<code>s<sub>0</sub> = 01</code>) and <code>|M''<sub>3</sub>| = 15</code> (<code>s<sub>1</sub>..s<sub>15</sub></code>, last bit padded with <code>0</code> ➔ <code>10</code> so pixel 15 = <code>43</code> stays unchanged!).</li>
  <li><strong>Result:</strong> 25 bits embedded in 16 pixels; <strong>only 9 pixels modified, each by ±1</strong>.</li>
</ul>
</div>
</div>

<div class="fig-box">
<img src="./img/fig3_example.png" alt="Figure 3: 4x4 Host image vs Stego-image" style="max-height: 350px;">
<div class="fig-cap">Figure 3 (Paper p. 8): (a) Original 4×4 grayscale host image; (b) Stego-image (bold = 9 modified pixels, all within ±1). Extraction: pixel 0 has 45 mod 4 = 1 ➔ m<sub>2</sub> = "01" in DEM<sub>1</sub>(4); pixel 1 has 46 mod 3 = 1 ➔ m<sub>2</sub> = "10" in DEM<sub>1</sub>(3).</div>
</div>
</div>

<!--
Worked Example Verification (Section 3, Figures 2 & 3):
Figure 2 illustrates why step 4 of the embedding algorithm checks |M_n| > N: even with fixed DEM_0(3) = {m1=1, m2=01, m3=00} and bit "0" dominating, the exact bit permutation changes how many 2-bit vs. 1-bit codewords occur across 8 pixels (14 bits = 1.75 bpp in (a), 12 bits = 1.50 bpp in (b), 11 bits = 1.375 bpp in (c)). Over random bit streams, however, the empirical average converges tightly to EC_n.

In Figure 3, M has length 25 bits (14 ones, 11 zeros -> t = 1). Row-major scanning processes pixel 0 (value 45) with s_0 = "01" (m2 in DEM_1(4), u=2): b'_0 = 45 - (45 mod 4) + 1 = 45 (unchanged). Pixel 1 (value 47) embeds s_1 = "10" (m2 in DEM_1(3), u=2): b'_1 = 47 - (47 mod 3) + 1 = 46 (decreased by 1). At the final pixel 15 (value 43), the remaining single bit "1" is padded with "0" to form "10" (m2 in DEM_1(3)) because 43 mod 3 = 1 gives u = 2 directly with zero pixel modification.
-->

---

## 4. Experimental Setup & Benchmark Images

<div class="fig-box" style="margin-bottom: 12px;">
<img src="./img/fig4_test_images.png" alt="Figure 4: Four 512x512 grayscale test images" style="max-height: 230px;">
<div class="fig-cap">Figure 4 (Paper p. 9): Standard 512 × 512 × 8-bit grayscale host images (N = 262,144 pixels) — (a) Lena; (b) Baboon; (c) Airplane; (d) Pepper.</div>
</div>

<div class="three-col">
<div class="kpi-card">
  <div class="kpi-val">Java · Win XP</div>
  <div class="kpi-label">Proposed algorithm, Simple LSB, and OPAP [9] implemented on the same platform for fair benchmarking.</div>
</div>
<div class="kpi-card teal">
  <div class="kpi-val">100 Trials / Point</div>
  <div class="kpi-label">Every reported PSNR value is the average over 100 independently generated random binary messages.</div>
</div>
<div class="kpi-card accent">
  <div class="kpi-val">PSNR (dB)</div>
  <div class="kpi-label"><code>10 × log<sub>10</sub>(255² / MSE)</code>, where <code>MSE = (1 / r×c) ∑ (α(i,j) − β(i,j))²</code>.</div>
</div>
</div>

<!--
Experimental Methodology (Section 4):
Four classic 512x512 8-bit grayscale images spanning smooth to highly textured scenes (Lena, Baboon, Airplane, Pepper; N = 262,144 pixels each) serve as host images. To eliminate bias from any single bit-stream permutation, each data point in Tables 2, 3, and 4 averages the PSNR over 100 randomly generated binary messages. For non-integer capacities k in the LSB and OPAP baselines, the authors construct the optimal fractional baseline k = q * k_i + q' * k_j (with q + q' = 1 so every pixel is utilized, e.g., at 2.25 bpp, 75% of pixels embed 2 bits and 25% embed 3 bits), giving LSB and OPAP their strongest possible configuration.
-->

---

## 4. Results at 1.0 bpp & 1.5 bpp (Tables 2 & 3)

<div class="two-col">
<div>
<h3>Table 2: Capacity = 1.0 bpp (262,144 bits)</h3>

| Host Image | Simple LSB | OPAP [9] | **Proposed (n = 3)** | Gain vs. OPAP |
| :--- | :---: | :---: | :---: | :---: |
| **Lena** | 51.1414 | 51.1423 | **51.6559** | **+0.51 dB** |
| **Baboon** | 51.1426 | 51.1398 | **51.6527** | **+0.51 dB** |
| **Airplane** | 51.1381 | 51.1406 | **51.6593** | **+0.52 dB** |
| **Pepper** | 51.1415 | 51.1412 | **51.6563** | **+0.52 dB** |
| **Average** | 51.1409 | 51.1410 | **51.6561** | **+0.52 dB** |

<div class="callout teal" style="margin-top: 10px;">
<strong>Why 1.0 bpp improves by +0.52 dB:</strong> With <code>n = 3</code>, only <code>262,144 / 1.5 ≈ 174,763</code> pixels are used, and only 2/3 of them (<strong>116,509 pixels</strong>) change by ±1—vs. <strong>131,072 pixels</strong> in LSB/OPAP!
</div>
</div>

<div>
<h3>Table 3: Capacity = 1.5 bpp (393,216 bits)</h3>

| Host Image | LSB (`k=2`) | LSB (`k=1.5`) | OPAP (`k=2`) | OPAP (`k=1.5`) | **Proposed (`n=3`)** |
| :--- | :---: | :---: | :---: | :---: | :---: |
| **Lena** | 45.4020 | 46.3716 | 47.6256 | 48.1305 | **49.8916** |
| **Baboon** | 45.4068 | 46.3774 | 47.6252 | 48.1290 | **49.8917** |
| **Airplane** | 45.3947 | 46.3686 | 47.6180 | 48.1334 | **49.9012** |
| **Pepper** | 45.3950 | 46.3624 | 47.6262 | 48.1274 | **49.8938** |

<div class="callout" style="margin-top: 10px;">
<strong>Biggest Win at 1.5 bpp:</strong> Proposed (<code>n = 3</code>) reaches <strong>~49.89 dB</strong> across all four images—outperforming best OPAP (<code>k = 1.5</code>) by <strong>+1.76 dB</strong> and best LSB by <strong>+3.52 dB</strong>.
</div>
</div>
</div>

<!--
Analysis of Tables 2 and 3 (Section 4, pp. 9–10):
Table 2 (1.0 bpp, 262,144 bits): In LSB and OPAP with k = 1, all 262,144 pixels embed 1 bit each, and half of them (131,072 pixels) are modified by ±1, yielding MSE ≈ 0.500 and PSNR ≈ 51.14 dB. In our algorithm with n = 3 (EC_3 = 1.5 bpp), only ~174,763 pixels are needed; for each used pixel, the probability of zero change is 1/3 and the probability of ±1 change is 2/3, so only ~116,509 pixels change by ±1 (MSE ≈ 0.4444, PSNR ≈ 51.66 dB).
Table 3 (1.5 bpp, 393,216 bits): Two baseline strategies are tested: k = 2 (using 0.75N = 196,608 pixels at 2 bpp) and k = 1.5 (first half of N pixels at k = 2, second half at k = 1). Even with the better k = 1.5 split, OPAP reaches 48.13 dB because half of the pixels suffer ±2 errors. Our n = 3 DEM keeps every pixel's change strictly within ±1, achieving 49.89–49.90 dB across all four images—completely independent of image texture!
-->

---

## 4. Results Across 2.0–3.875 bpp (Table 4)

<div class="split64">
<div class="fig-box">
<img src="./img/diag2_psnr_chart.svg" alt="PSNR vs Capacity on Lena from 1.0 to 3.875 bpp" style="max-height: 390px;">
<div class="fig-cap">PSNR curves on Lena (Tables 2–4): Adaptive DEM dominates LSB everywhere and beats OPAP at every non-integer capacity.</div>
</div>

<div>
<h3>Table 4 Highlights (Lena, dB)</h3>

| Cap. (bpp) | `n` | LSB | OPAP | **Proposed** | Δ vs. OPAP |
| :---: | :---: | :---: | :---: | :---: | :---: |
| **2.000** | 4 | 44.15 | 46.37 | **46.37** | 0.00 dB |
| **2.250** | 5 | 41.60 | 44.15 | **45.12** | **+0.97 dB** |
| **2.500** | 6 | 40.01 | 42.69 | **43.12** | **+0.43 dB** |
| **2.750** | 7 | 38.84 | 41.60 | **42.11** | **+0.51 dB** |
| **3.000** | 8 | 37.92 | 40.73 | **40.73** | 0.00 dB |
| **3.125** | 9 | 36.51 | 39.38 | **39.89** | **+0.51 dB** |
| **3.375** | 11 | 34.58 | 37.52 | **38.13** | **+0.61 dB** |
| **3.625** | 13 | 33.25 | 36.23 | **36.68** | **+0.45 dB** |
| **3.875** | 15 | 32.23 | 35.23 | **35.42** | **+0.18 dB** |

</div>
</div>

<!--
Analysis of Table 4 (Section 4, pp. 10–11):
Across all four test images (Lena, Baboon, Airplane, Pepper), the PSNR values at each capacity are remarkably consistent (within ±0.03 dB across images), confirming that the distortion depends primarily on the modulus alphabet n rather than host image texture.
Key observations:
- At exact powers of two (n = 4 for 2.0 bpp; n = 8 for 3.0 bpp), every codeword in DEM_t(n) has fixed length k = 2 or k = 3, and Eqs. (2)-(3) reduce mathematically to Chan & Cheng's OPAP (46.37 dB at 2 bpp; 40.73 dB at 3 bpp).
- At every intermediate capacity (n = 5, 6, 7, 9, 10, 11, 13, 15), Proposed consistently outperforms OPAP by +0.18 to +0.97 dB and outperforms simple LSB by +2.2 to +3.5 dB, with the largest gains appearing right above power-of-two boundaries (e.g., n = 5 at 2.25 bpp: +0.97 dB; n = 11 at 3.375 bpp: +0.61 dB).
-->

---

## 4. Why It Wins: Distortion & Mechanism Analysis

<div class="three-col">
<div class="card">
<h3>1. Smaller Modification Radius</h3>
<p class="small-text">Because MSE scales <strong>quadratically</strong> with pixel error <code>(Δb)<sup>2</sup></code>, avoiding jumps from <code>k</code> to <code>k+1</code> yields disproportionate PSNR gains.</p>
<ul class="small-text">
  <li>At <strong>2.25 bpp</strong>: OPAP mixes 75% <code>k=2</code> (<code>|Δb| ≤ 2</code>) and 25% <code>k=3</code> (<code>|Δb| ≤ 4</code>, squared error up to <strong>16</strong>).</li>
  <li>Proposed uses <code>n = 5</code>: every pixel satisfies <code>|Δb| ≤ 2</code> (squared error capped at <strong>4</strong>) ➔ <strong>+0.97 dB</strong> gain!</li>
</ul>
</div>

<div class="card teal">
<h3>2. Odd-n Symmetry Advantage</h3>
<p class="small-text">Odd values of <code>n</code> (3, 5, 7, 9, 11, 13, 15) center the adjustment window symmetrically on <code>b<sub>i</sub></code>:</p>
<ul class="small-text">
  <li><code>n = 3</code>: <code>{−1, 0, +1}</code> ➔ expected MSE = <code>2/3 = 0.667</code>.</li>
  <li><code>n = 5</code>: <code>{−2, −1, 0, +1, +2}</code> ➔ expected MSE = <code>10/5 = 2.00</code>.</li>
  <li>Even <code>n = 4</code> has asymmetric residual <code>±2</code>; thus odd-<code>n</code> points produce the sharpest peaks above the OPAP curve.</li>
</ul>
</div>

<div class="card accent">
<h3>3. Texture-Independent Stability</h3>
<p class="small-text">Unlike PVD or block-matching schemes whose capacity fluctuates wildly with image smoothness:</p>
<ul class="small-text">
  <li>PSNR at <strong>1.5 bpp</strong>: Lena <code>49.89</code>, Baboon <code>49.89</code>, Airplane <code>49.90</code>, Pepper <code>49.89 dB</code>.</li>
  <li>PSNR at <strong>2.25 bpp</strong>: Lena <code>45.12</code>, Baboon <code>45.12</code>, Airplane <code>45.13</code>, Pepper <code>45.12 dB</code>.</li>
  <li>Works identically on smooth and rough images for any binary payload.</li>
</ul>
</div>
</div>

<div class="callout teal">
<strong>Theoretical Takeaway:</strong> Replacing binary power-of-two quantization (<code>q = 2<sup>k</sup></code>) with prefix-free variable-length <code>n</code>-ary quantization eliminates the quadratic MSE penalty of coarse bit-plane transitions.
</div>

<!--
Theoretical Justification of Empirical Gains:
For a uniformly distributed remainder modulo n, the expected mean square error of nearest-neighbor adjustment is:
- For odd n = 2m + 1: MSE(n) = (2 * sum_{r=1}^{m} r^2) / n = (n^2 - 1) / 12.
  For n = 3: (9 - 1)/12 = 0.6667 -> PSNR = 10*log10(255^2 / 0.6667) = 49.89 dB (matches Table 3's 49.89 dB!).
  For n = 5: (25 - 1)/12 = 2.0000 -> PSNR = 10*log10(255^2 / 2.0) = 45.12 dB (matches Table 4's 45.12 dB!).
- For even n = 2m: MSE(n) = (n^2 + 2) / 12.
  For n = 4 (OPAP k=2): (16 + 2)/12 = 1.5000 -> PSNR = 46.37 dB (matches Table 4!).
  For n = 8 (OPAP k=3): (64 + 2)/12 = 5.5000 -> PSNR = 40.73 dB (matches Table 4!).
Meanwhile, OPAP at 2.25 bpp mixes 0.75 * 1.5 + 0.25 * 5.5 = 2.5000 -> PSNR = 44.15 dB, strictly worse than n = 5's MSE = 2.0000 (45.12 dB)! This closed-form analysis explains both the exact empirical numbers and why texture has negligible effect.
-->

---

## 5. Conclusions & Practical Impact

<div class="three-col">
<div class="kpi-card teal">
  <div class="kpi-val">≤ ⌊n/2⌋ Shift</div>
  <div class="kpi-label">Every non-oversaturated host pixel shifts by at most ⌊n/2⌋, guaranteeing high stego-image visual quality.</div>
</div>
<div class="kpi-card">
  <div class="kpi-val">+1.76 dB Peak</div>
  <div class="kpi-label">Substantial PSNR gains over OPAP across fractional capacities (1.0, 1.5, 2.25–3.875 bpp) and +2.2–3.5 dB over LSB.</div>
</div>
<div class="kpi-card accent">
  <div class="kpi-val">O(N) &amp; General</div>
  <div class="kpi-label">Single-pass modulo embedding &amp; extraction; supports arbitrary binary messages on any grayscale image.</div>
</div>
</div>

<div class="future-strip">
<div class="future-pill"><strong>1. Two-Segment Optimality</strong><br>Dividing <code>M</code> into minimized <code>M'<sub>n</sub></code> and maximized <code>M''<sub>n−1</sub></code> utilizes all <code>N</code> host pixels while minimizing the alphabet size <code>n</code>.</div>
<div class="future-pill"><strong>2. Compact Side Information</strong><br>Decoder only requires <code>n</code>, <code>|M'<sub>n</sub>|</code>, <code>|M''<sub>n−1</sub>|</code>, <code>#(M)</code>, and the two DEM tables (recoverable from <code>n</code> and dominant bit <code>t</code>).</div>
<div class="future-pill"><strong>3. Target Applications</strong><br>Ideal for covert binary communication, digital annotation, and steganography demanding minimal visual distortion at arbitrary payloads.</div>
</div>

<!--
Summary of Contributions (Section 5):
1. Formulation of balanced prefix-free Directories of Elementary Messages (DEM_t(n)) with bit-dominance selection and closed-form expected capacity EC_n = floor(log2 n) - 1 + n / 2^{floor(log2 n)}.
2. Two-segment adaptive decomposition (M = M'_n || M''_{n-1}) paired with oversaturation-safe nearest-neighbor modulo adjustment (Eqs. 2–3), bounding pixel modification to at most floor(n/2).
3. Comprehensive empirical verification on 512x512 Lena, Baboon, Airplane, and Pepper across 1.0 to 3.875 bpp showing consistent superiority over simple LSB substitution everywhere and over OPAP at every non-power-of-two capacity.
-->

---

<!-- _class: closing -->

# Thank You for Your Attention!

<p style="font-size: 1.05em; max-width: 860px;">
Adaptively Embedding Binary Data in an Image
</p>

<div class="contact-card">
<strong>Ching-Chiuan Lin<sup>*</sup></strong> · <code>cclin@ocit.edu.tw</code><br>
<strong>Nien-Lin Hsueh</strong> · <code>nlhsueh@fcu.edu.tw</code> &nbsp;|&nbsp; <strong>Wen-Hsiang Shen</strong> · <code>shen@ocit.edu.tw</code><br>
Department of Information Engineering and Computer Science, Feng Chia University, Taichung 40724, Taiwan, ROC<br>
<span style="font-size: 0.85em; opacity: 0.88;">Fundamenta Informaticae, Vol. 84, pp. 1–12, 2008 · IOS Press</span>
</div>

<!--
Archival Metadata:
- Title: Adaptively Embedding Binary Data in an Image
- Authors: Ching-Chiuan Lin (corresponding author, cclin@ocit.edu.tw), Nien-Lin Hsueh (nlhsueh@fcu.edu.tw), Wen-Hsiang Shen (shen@ocit.edu.tw)
- Affiliation: Department of Information Engineering and Computer Science, Feng Chia University, Taichung 40724, Taiwan, ROC
- Venue: Fundamenta Informaticae 84 (2008) 1–12, IOS Press
- Keywords: Information hiding, LSB
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
document.querySelectorAll('.split64 .fig-box img, .split55 .fig-box img, .split46 .fig-box img, .split73 .fig-box img, .two-col .fig-box img, .three-col .fig-box img').forEach((img) => {
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

// Bilingual toggle preserving current slide hash
document.addEventListener('click', (e) => {
  const langBtn = e.target.closest('.lang-btn');
  if (!langBtn) return;
  e.preventDefault();
  const target = langBtn.getAttribute('href');
  if (target) window.location.href = target + (window.location.hash || '');
});
</script>
