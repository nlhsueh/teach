---
marp: true
theme: gaia
size: 16:9
paginate: true
html: true
header: '<div class="hdr-wrap"><span class="hdr-title">Reversible Data Hiding Based on Three-Circular-Pixel Difference Expansion</span><div class="hdr-actions"><a class="lang-btn" href="./ThreeCircular_slide_zh.html" title="切換至繁體中文簡報">🌐 繁</a><div class="nav-dropdown"><button class="nav-btn">Sections ▾</button><div class="nav-menu"><a href="#2">Outline</a><a href="#3">1. Motivation &amp; DE Background</a><a href="#5">2. TCP Block &amp; Dual Expansion</a><a href="#6">3. Proposed Scheme &amp; Walkthrough</a><a href="#11">4. Experimental Results</a><a href="#14">5. Conclusions</a></div></div></div></div>'
footer: 'Ching-Chiuan Lin, Shun-Ping Yang & Nien-Lin Hsueh · Fundamenta Informaticae (2009)'
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
  padding: 68px 54px 48px 54px;
  box-sizing: border-box;
  letter-spacing: 0.01em !important;
}

header {
  position: absolute;
  top: 0; left: 0; right: 0;
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
  right: 0; top: 100%;
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

footer {
  position: absolute;
  left: 54px; bottom: 14px;
  font-size: 12.5px;
  color: var(--slate-500);
  font-weight: 500;
}

section::after {
  position: absolute;
  right: 54px; bottom: 14px;
  font-size: 12.5px;
  font-weight: 700;
  color: var(--navy);
  content: attr(data-marpit-pagination) ' / ' attr(data-marpit-pagination-total);
}

h1 { color: var(--navy); font-size: 1.7em; font-weight: 800; line-height: 1.22; margin: 0 0 12px 0; letter-spacing: 0 !important; }
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
  letter-spacing: 0 !important;
}
h3 { color: var(--accent); font-size: 0.95em; font-weight: 700; margin: 4px 0 6px 0; letter-spacing: 0 !important; }
p { margin: 0 0 8px 0; }
section:not(.lead):not(.closing) > p { max-width: 980px; }
ul, ol { margin: 4px 0 8px 0; padding-left: 22px; }
li { margin-bottom: 5px; line-height: 1.42; }
li > ul { margin-top: 3px; margin-bottom: 3px; }
li > ul > li { font-size: 0.92em; margin-bottom: 3px; }
strong { color: var(--slate-900); }
a { color: #2563eb; text-decoration: none; }
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
section table th { background: var(--navy) !important; color: #ffffff !important; }
section table th strong, section table th code { color: #ffffff !important; }
section.lead strong, section.closing strong { color: #ffffff !important; }
section.lead code, section.closing code { color: #bae6fd !important; }

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
section.lead h1 { color: #ffffff; font-size: 1.92em; font-weight: 800; line-height: 1.24; margin-bottom: 16px; text-align: left; }
section.lead .subtitle { color: #cbd5e1; font-size: 0.92em; line-height: 1.5; margin-bottom: 24px; max-width: 960px; }
section.lead .meta-box { border-left: 4px solid #f43f5e; padding-left: 18px; color: #e2e8f0; font-size: 0.84em; line-height: 1.6; }

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
  font-size: 0.84em;
  line-height: 1.68;
  color: #f8fafc;
}

.two-col { display: grid; grid-template-columns: 1fr 1fr; gap: 20px; align-items: stretch; }
.three-col { display: grid; grid-template-columns: repeat(3, 1fr); gap: 15px; align-items: stretch; }
.split64 { display: grid; grid-template-columns: 56% 42%; gap: 2%; align-items: center; }
.split55 { display: grid; grid-template-columns: 49% 49%; gap: 2%; align-items: center; }
.split46 { display: grid; grid-template-columns: 42% 56%; gap: 2%; align-items: center; }

.card {
  background: #ffffff;
  border: 1px solid var(--slate-200);
  border-top: 3.5px solid var(--navy);
  border-radius: 8px;
  padding: 12px 16px;
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
  padding: 10px 15px;
  box-sizing: border-box;
}
.kpi-card.accent { border-left-color: var(--accent); background: var(--accent-soft); }
.kpi-card.teal { border-left-color: var(--teal); background: var(--teal-soft); }
.kpi-val { font-size: 1.38em; font-weight: 800; color: var(--navy); line-height: 1.15; margin-bottom: 3px; }
.kpi-card.accent .kpi-val { color: var(--accent); }
.kpi-card.teal .kpi-val { color: var(--teal); }
.kpi-label { font-size: 0.76em; color: var(--slate-700); line-height: 1.35; }

.callout {
  background: #f8fafc;
  border-left: 4px solid var(--accent);
  border-radius: 0 8px 8px 0;
  padding: 11px 16px;
  margin-top: 12px;
  font-size: 0.84em;
  color: var(--slate-700);
  max-width: 960px;
  line-height: 1.48;
}
.callout.teal { border-left-color: var(--teal); background: var(--teal-soft); }
.callout strong { color: var(--navy); }

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
  padding: 6px 9px;
  text-align: left;
  border: 1px solid var(--navy);
}
td {
  padding: 5px 9px;
  border: 1px solid var(--slate-200);
  vertical-align: middle;
  line-height: 1.34;
}
tr:nth-child(even) td { background: #f8fafc; }

.outline-grid { display: grid; grid-template-columns: 1fr 1fr; gap: 14px 24px; margin-top: 8px; }
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
  width: 28px; height: 28px;
  border-radius: 6px;
  display: flex;
  align-items: center;
  justify-content: center;
  flex-shrink: 0;
  margin-top: 2px;
}
.outline-body { font-size: 0.85em; line-height: 1.38; }
.outline-body a { color: var(--navy); font-weight: 700; font-size: 1.05em; }

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

.small-text { font-size: 0.82em; }
.formula-box {
  background: var(--slate-100);
  border: 1px solid var(--slate-200);
  border-left: 4px solid var(--navy);
  border-radius: 6px;
  padding: 8px 14px;
  font-family: 'JetBrains Mono', monospace;
  font-size: 0.78em;
  line-height: 1.5;
  color: var(--slate-900);
  margin: 6px 0;
}

@media print {
  .lang-btn, .nav-dropdown { display: none !important; }
}
</style>

<!-- _class: lead -->

<div class="badge">Fundamenta Informaticae · IOS Press · 2009</div>

# Reversible Data Hiding Based on Three-Circular-Pixel Difference Expansion

<div class="subtitle">
Expanding two pixel differences simultaneously via a shared largest central pixel in 3-pixel circular blocks to boost single-layer capacity to <strong>0.67 bpp</strong> while reducing image distortion
</div>

<div class="meta-box">
<strong>Ching-Chiuan Lin<sup>*</sup></strong> · Dept. of Information Management, Overseas Chinese Institute of Technology · <code>cclin@ocit.edu.tw</code><br>
<strong>Shun-Ping Yang</strong> · Dept. of Information Technology, Overseas Chinese Institute of Technology · <code>ysp@ocit.edu.tw</code><br>
<strong>Nien-Lin Hsueh</strong> · Dept. of Information Engineering and Computer Science, Feng Chia University · <code>nlhsueh@fcu.edu.tw</code>
</div>

<!--
Bibliographic & Research Overview:
This paper (Lin, Yang, & Hsueh; Fundamenta Informaticae, IOS Press, preprint dated 2008 / published 2009, pp. 1–15) presents a spatial-domain reversible data hiding (RDH) scheme based on three-circular-pixel (TCP) difference expansion.

Core Innovation:
In J. Tian's seminal 2003 Difference Expansion (DE) algorithm, an image is partitioned into non-overlapping 2-pixel pairs, capping single-layer capacity at 0.50 bits per pixel (bpp) and modifying up to four pixels to expand two differences. By grouping pixels into 3-pixel circular blocks and selecting the largest pixel as the shared central anchor, raising the central pixel expands two differences simultaneously—between the largest and smallest pixels, and between the largest and middle pixels. This increases the number of embeddable pixel pairs from N/2 to floor(2N/3) (up to 0.67 bpp per layer) while modifying at most three pixels instead of four, yielding lower mean square error (MSE) and higher PSNR across standard 512x512 benchmark images.
-->

---

## Outline

<div class="outline-grid">
<div class="outline-item">
<div class="outline-num">1</div>
<div class="outline-body"><a href="#3">Motivation &amp; DE Background</a><br>Reversible watermarking needs, prior RDH families, and Tian's 2-pixel DE bottlenecks.</div>
</div>
<div class="outline-item">
<div class="outline-num">2</div>
<div class="outline-body"><a href="#5">TCP Block &amp; Dual Expansion</a><br>Circular block transformation, shared largest pixel anchor, and MSE reduction.</div>
</div>
<div class="outline-item">
<div class="outline-num">3</div>
<div class="outline-body"><a href="#6">Proposed TCP Scheme</a><br>Architecture, expandability rules, 4-case embedding, symmetry, and threshold <code>T ≥ 1</code>.</div>
</div>
<div class="outline-item">
<div class="outline-num">4</div>
<div class="outline-body"><a href="#9">Extraction &amp; Walkthrough</a><br>Blind LSB extraction, JBIG location-map decoding, and complete 3×6 image trace.</div>
</div>
<div class="outline-item">
<div class="outline-num">5</div>
<div class="outline-body"><a href="#11">Experimental Results</a><br>512×512 benchmarks, PSNR vs. capacity against Tian, and threshold <code>T</code> trade-offs.</div>
</div>
<div class="outline-item">
<div class="outline-num">6</div>
<div class="outline-body"><a href="#14">Conclusions</a><br>Synthesis of capacity, visual quality, and lossless reversibility guarantees.</div>
</div>
</div>

<!--
Structural Map of the Paper:
- Section 1 (Introduction, pp. 2–3): Motivates lossless cover-image restoration in sensitive domains (such as medical diagnosis) and surveys four RDH paradigms: LSB compression (Fridrich et al.), generalized LSB quantization residual compression (Celik et al.), difference expansion (Tian and derivatives), and histogram shifting (Ni et al., Lin et al.).
- Section 2 (Difference Expansion, p. 3): Reviews Tian's 2003 integer difference expansion and its overflow/location-map constraint.
- Section 3 (The Proposed Scheme, pp. 3–11): Introduces TCP block transformation (3.1), formal embedding algorithm and central-pixel symmetry (3.2), blind extraction and threshold restriction 1 <= T <= 127 (3.3), and a worked 3x6 image walkthrough (3.4).
- Section 4 (Experimental Results, pp. 11–14): Evaluates the Java implementation on Lena, Baboon, Airplane, and Boat against Tian's method, plus JBIG compression ratios across T = 1..127 (Table 1).
- Section 5 (Conclusions, pp. 13–14): Summarizes the dual-difference expansion principle and lossless recovery mechanism.
-->

---

## 1. Motivation & Reversible Data Hiding Landscape

<div class="two-col">
<div class="card">
<h3>Why Reversibility Matters</h3>
<ul class="small-text">
<li><strong>Zero-Tolerance Domains</strong>: In medical diagnosis or military imagery, even subtle permanent watermark distortion can cause incorrect diagnosis and is unacceptable.</li>
<li><strong>Core Technical Challenge</strong>: Identify redundant host space that does <em>not</em> overlap image semantics, maximizing both <strong>embedding capacity (bpp)</strong> and <strong>visual quality (PSNR)</strong>.</li>
</ul>
</div>
<div class="card teal">
<h3>Proposed TCP Breakthrough</h3>
<ul class="small-text">
<li>Partition the image into non-overlapping <strong>3-pixel blocks</strong> transformed into <strong>Three-Circular-Pixel (TCP)</strong> blocks.</li>
<li>Raising the <strong>largest pixel</strong> expands <strong>two differences at once</strong> (largest–smallest and largest–middle).</li>
<li>Increases embeddable pairs to <strong>2/3 of total pixels</strong> (0.67 bpp/layer) with fewer modified pixels.</li>
</ul>
</div>
</div>

| RDH Paradigm | Representative Works | Core Redundancy Mechanism | Main Limitation |
|---|---|---|---|
| **LSB Compression** | Fridrich et al. (2001, 2002) | Losslessly compress bit-planes (LSB) | Capacity strictly bounded by compression ratio |
| **Generalized LSB** | Celik et al. (2005) | Quantize `Qx = q × ⌊x/q⌋`, compress residual `r` | Depends heavily on residual compressibility |
| **Histogram Shifting** | Ni et al. (2006); Lin et al. (2008) | Shift bins between peak `M` and zero `m` | Low single-pass capacity if peak `M` is small |
| **Difference Expansion** | Tian (2003); Alattar (2004); Thodi & Rodriguez (2007) | Double pixel difference `h' = 2h` to free LSB | 2-pixel pairs cap single layer at 0.50 bpp; higher MSE |

<!--
Theoretical Context & Prior Art (Section 1):
Reversible (lossless) data hiding requires exact bit-for-bit restoration of the original host image after secret message extraction.
1. Fridrich et al. [1, 2] compress the least significant bit (LSB) planes losslessly to create space; payload depends entirely on spatial compressibility.
2. Celik et al. [3] generalize this by quantizing each pixel x to Qx = q * floor(x/q), compressing the residual r = x mod q, converting compressed residual + payload into q-ary symbols s_i, and embedding via Qs = Qx + s_i (extracted via s_i = Qs mod q).
3. Ni et al. [12] shift pixel values between a histogram peak M and minimum point m by 1, then embed 0/1 at M. Because raw pixel histograms rarely have very high peaks, Lin et al. [13] improved this by shifting differences in non-overlapping 2-pixel blocks.
4. Tian [4] pioneered Difference Expansion (DE) in 2003, inspiring prediction-based variants such as Chang & Lu [6] (difference from average of preceding pixels) and Thodi & Rodriguez [7] (prediction-error expansion). The TCP scheme directly generalizes Tian's spatial pair expansion to 3-pixel circular blocks with a shared peak pixel.
-->

---

## 1.2 Tian's Difference Expansion (DE) & Its Bottlenecks

<div class="fig-box" style="margin-bottom: 10px;">
<img src="./img/diag1_tcp_vs_tian.svg" alt="Tian 2-Pixel DE vs Proposed TCP 3-Pixel DE" style="max-height: 295px;">
</div>

<div class="two-col">
<div class="card accent">
<h3>Tian's 2-Pixel DE Example</h3>
<p class="small-text">Given <code>(x, y) = (30, 33)</code>, difference <code>h = -3</code> expands to <code>h' = -6</code> via <code>x' = 30 + ⌊-3/2⌋ = 28</code>, <code>y' = 33 - ⌊(-3+1)/2⌋ = 34</code>. Embed bit <code>b</code> via <code>x'' = x' + b</code>; extract <code>b = |x'' - y'| mod 2</code> and restore <code>h = ⌊(x'' - y')/2⌋</code>.</p>
</div>
<div class="card">
<h3>Two Key Bottlenecks of 2-Pixel DE</h3>
<ul class="small-text">
<li><strong>0.50 bpp Capacity Ceiling</strong>: Pairing pixels into disjoint 2-pixel blocks yields only <code>⌊N/2⌋</code> pairs per layer.</li>
<li><strong>4-Pixel Modification Cost</strong>: Expanding two differences modifies up to 4 pixels, inflating MSE and requiring a compressed <code>⌊N/2⌋</code>-bit location map for overflow (e.g., <code>x=235, y=250</code>).</li>
</ul>
</div>
</div>

<!--
Detailed Analysis of Tian's DE (Section 2):
In Tian's DE [4], expanding the difference h = x - y between two pixels doubles it to h' = 2h, guaranteeing an even integer whose LSB is 0. Embedding a message bit b in {0, 1} sets x'' = x' + b.
During extraction, the decoder recovers b = |x'' - y'| mod 2 and h = floor((x'' - y')/2), then restores:
- x = x'' - b - floor(h/2) = 30
- y = y' + floor((h + 1)/2) = 33.

Overflow & Location Map:
For extreme pixel pairs such as (235, 250), expanding h = -15 would push y' beyond 255 (over-saturation). Thus, Tian requires a binary location map of size floor(N/2) bits indicating which pairs were expanded, losslessly compressed before embedding.

Why TCP Improves on Both Axes:
In the worked comparison (24, 28) and (28, 26), Tian expands them independently into (22, 30) and (29, 25)—modifying all 4 pixels with squared error (-2)^2 + 2^2 + 1^2 + (-1)^2 = 10. TCP treats (24, 28, 26) as one 3-pixel block sharing central peak 28, expanding it to (22, 30, 26)—leaving pixel 26 untouched with squared error (-2)^2 + 2^2 + 0^2 = 8.
-->

---

## 2. TCP Block Transformation & Dual Difference Expansion

<div class="split55">
<div>
<div class="fig-box" style="margin-bottom: 10px;">
<img src="./img/fig1_tcp_transform.png" alt="Figure 1: Raw blocks to TCP block transformation" style="max-height: 155px;">
<div class="fig-cap">Fig. 1. Transformation from raw blocks <code>[a<sub>i</sub>, b<sub>i</sub>, c<sub>i</sub>]</code> to a TCP block.</div>
</div>
<div class="card">
<h3>Circular Ordering &amp; Tie-Breaking</h3>
<ul class="small-text">
<li>Raw block <code>[a<sub>i</sub>, b<sub>i</sub>, c<sub>i</sub>]</code> is cyclically rotated into <code>(x<sub>i</sub>, y<sub>i</sub>, z<sub>i</sub>)</code> so that <code>y<sub>i</sub> ≥ x<sub>i</sub></code> and <code>y<sub>i</sub> ≥ z<sub>i</sub></code>.</li>
<li><code>x<sub>i</sub></code> is logically left of <code>y<sub>i</sub></code>; <code>z<sub>i</sub></code> is logically right.</li>
<li><strong>Example</strong>: <code>[18, 15, 26]</code>, <code>[15, 26, 18]</code>, <code>[26, 18, 15]</code> all map to TCP <code>(15, 26, 18)</code>.</li>
<li><strong>Boundary tie</strong>: If two maxima tie (<code>[26', 20, 26]</code>), the earlier-visited pixel becomes <code>y<sub>i</sub></code> ➔ <code>(26, 26', 20)</code>.</li>
</ul>
</div>
</div>
<div>
<div class="fig-box" style="margin-bottom: 10px;">
<img src="./img/fig2_expand_example.png" alt="Figure 2: Dual difference expansion example" style="max-height: 190px;">
<div class="fig-cap">Fig. 2. Dual expansion of <code>(24, 28, 26)</code> ➔ <code>(22, 30, 26)</code>.</div>
</div>
<div class="card teal">
<h3>Worked Dual Expansion &amp; Embedding</h3>
<ul class="small-text">
<li><code>h<sub>i1</sub> = 28 - 24 = 4</code>, <code>h<sub>i2</sub> = 28 - 26 = 2</code> (<code>h<sub>i1</sub> ≥ h<sub>i2</sub></code>).</li>
<li>Expand: <code>x'<sub>i</sub> = 24 - ⌊4/2⌋ = 22</code>, <code>y'<sub>i</sub> = 28 + ⌊5/2⌋ = 30</code>, <code>z'<sub>i</sub> = 30 - 2×2 = 26</code> (unchanged!).</li>
<li>Embed <code>b<sub>1</sub>=0, b<sub>2</sub>=1</code> ➔ <code>(22, 30, 25)</code>; decode <code>h''<sub>i1</sub>=8, h''<sub>i2</sub>=5</code> ➔ <code>b<sub>1</sub>=0, b<sub>2</sub>=1</code> and exact recovery <code>(24, 28, 26)</code>.</li>
</ul>
</div>
</div>
</div>

<!--
TCP Block Definition & Dual Expansion Mechanics (Sections 3 & 3.1):
A raw 3-pixel block [a_i, b_i, c_i] (scanned left-to-right, top-to-bottom) can take 1x3, 3x1, or L-shaped layouts (Fig. 1a). Arranging its three pixels on a directed circle (Fig. 1b) preserves cyclic adjacency while letting the largest pixel y_i act as the logical center, flanked by x_i (logically left) and z_i (logically right).

Tie-Breaking Rule for Exact Reversibility:
When y_i = x_i or y_i = z_i, the pixel visited earlier in scan order is uniquely designated as y_i (e.g., [26', 20, 26] maps to (26, 26', 20)). This deterministic canonicalization ensures both encoder and decoder construct identical TCP tuples.

Worked Numerical Verification (Section 3.1):
For (24, 28, 26), h_i1 = 4 >= h_i2 = 2. Expanding h_i1 symmetrically moves x_i down by floor(4/2)=2 to 22 and y_i up by floor(5/2)=2 to 30. Then z'_i = y'_i - 2*h_i2 = 30 - 4 = 26 remains completely unmodified!
Embedding b_1 = 0, b_2 = 1 subtracts b_1 from x'_i and b_2 from z'_i to produce (22, 30, 25).
At the receiver: h''_i1 = 30 - 22 = 8 (LSB 0), h''_i2 = 30 - 25 = 5 (LSB 1); original differences h_i1 = floor(8/2) = 4, h_i2 = floor(5/2) = 2; restored pixels x_i = 22 + 2 + 0 = 24, y_i = 30 - 2 = 28, z_i = 28 - 2 = 26.
Note also the paper's additional MSE examples: (24, 28, 23) -> (23, 31, 21), (24, 28, 25) -> (22, 30, 24), and (24, 28, 24) -> (22, 30, 22)—all achieving lower MSE than two separate Tian pairs.
-->

---

## 3. Proposed Scheme: End-to-End Architecture & Expandability

<div class="fig-box" style="margin-bottom: 10px;">
<img src="./img/diag2_tcp_pipeline.svg" alt="TCP Reversible Data Hiding Pipeline" style="max-height: 255px;">
</div>

<div class="two-col">
<div class="card">
<h3>Expandability Conditions (No Overflow/Underflow)</h3>
<ul class="small-text">
<li><code>h<sub>i1</sub> = y<sub>i</sub> - x<sub>i</sub></code> is <strong>expandable</strong> if: (1) <code>h<sub>i1</sub> ≥ h<sub>i2</sub></code>, <code>y<sub>i</sub> + ⌊(h<sub>i1</sub>+1)/2⌋ ≤ 255</code>, and <code>x<sub>i</sub> - ⌊h<sub>i1</sub>/2⌋ - 1 ≥ 0</code>; OR (2) <code>h<sub>i2</sub> > h<sub>i1</sub></code> and <code>h<sub>i2</sub></code> is expandable; OR (3) <code>h<sub>i2</sub></code> is not expandable and condition (1)'s bounds hold.</li>
<li><strong>Key Lemma</strong>: If the larger difference is expandable, the smaller difference is <em>automatically</em> expandable (since <code>x<sub>i</sub> ≤ z<sub>i</sub></code> when <code>h<sub>i1</sub> ≥ h<sub>i2</sub></code>).</li>
</ul>
</div>
<div class="card teal">
<h3>Changeability &amp; Set Partitioning</h3>
<ul class="small-text">
<li><code>h<sub>i1</sub></code> is <strong>changeable</strong> if <code>(y<sub>i</sub> - x<sub>i</sub>) mod 2 = 1</code> or <code>x<sub>i</sub> > 0</code> (symmetrically for <code>h<sub>i2</sub></code> with <code>z<sub>i</sub></code>).</li>
<li>Every expandable difference is also changeable.</li>
<li>Threshold <code>1 ≤ T ≤ 127</code> partitions differences into:
  <ul>
    <li><code>EN</code>: all expandable differences with <code>h ≤ T</code></li>
    <li><code>CN</code>: all changeable differences with <code>h ∉ EN</code></li>
  </ul>
</li>
</ul>
</div>
</div>

<!--
Formal Expandability & Changeability Theory (Section 3.2):
For an 8-bit grayscale block [a_i, b_i, c_i] in [0, 255], expanding a difference and then subtracting a message bit b in {0, 1} must never cause underflow (< 0) or overflow (> 255).
The `- 1` term in `x_i - floor(h_i1/2) - 1 >= 0` explicitly reserves headroom for embedding b_1 = 1 after expansion.

Crucial Structural Property:
Suppose h_i1 >= h_i2, which implies x_i <= z_i. If h_i1 is expandable, then y'_i <= 255 and x'_i - 1 >= 0. Because z'_i = y'_i - 2*h_i2 >= y'_i - 2*h_i1 = x'_i, we automatically have z'_i - 1 >= x'_i - 1 >= 0. Therefore, expandability of the larger difference guarantees expandability of the smaller difference in the same TCP block!

Why Changeability Requires `(y_i - x_i) mod 2 = 1` or `x_i > 0`:
To replace the LSB of a non-expanded difference h'_i1 without exceeding [0, 255]: if h'_i1 is odd, flipping its LSB to 0 adds 1 to x'_i (safe since x'_i < y'_i <= 255). If h'_i1 is even, flipping its LSB to 1 subtracts 1 from x'_i, which is only safe if x'_i > 0. Hence an unchangeable difference occurs solely when h'_i1 is even AND x'_i = 0.
-->

---

## 3.2 Embedding Process: 4 Cases & Bitstream Packing

<div class="two-col">
<div>
<h3>Step 2: Pixel Adjustment (4 Cases per Block)</h3>

| Case | Condition | Adjusted TCP Block <code>(x'<sub>i</sub>, y'<sub>i</sub>, z'<sub>i</sub>)</code> |
|---|---|---|
| **2.1a** | `h_i1, h_i2 ∈ EN`, `h_i1 ≥ h_i2` | `x_i - ⌊h_i1/2⌋`, `y_i + ⌊(h_i1+1)/2⌋`, `y'_i - 2h_i2` |
| **2.1b** | `h_i1, h_i2 ∈ EN`, `h_i1 < h_i2` | `y'_i - 2h_i1`, `y_i + ⌊(h_i2+1)/2⌋`, `z_i - ⌊h_i2/2⌋` |
| **2.2** | `h_i1 ∈ EN`, `h_i2 ∉ EN` | `x_i - ⌊h_i1/2⌋`, `y_i + ⌊(h_i1+1)/2⌋`, `z_i` |
| **2.3** | `h_i1 ∉ EN`, `h_i2 ∈ EN` | `x_i`, `y_i + ⌊(h_i2+1)/2⌋`, `z_i - ⌊h_i2/2⌋` |
| **2.4** | `h_i1 ∉ EN`, `h_i2 ∉ EN` | `x_i`, `y_i`, `z_i` (unchanged) |

<div class="callout">
<strong>Location Map <code>L</code> &amp; Control Bits <code>C</code></strong>: <code>L</code> has fixed length <code>⌊2N/3⌋</code> bits (<code>e<sub>2i</sub> = 1</code> iff <code>h<sub>i1</sub> ∈ EN</code>; <code>e<sub>2i+1</sub> = 1</code> iff <code>h<sub>i2</sub> ∈ EN</code>). <code>C</code> stores original LSBs of all changeable differences in <code>CN</code>.
</div>
</div>
<div>
<h3>Steps 5–8: Compression &amp; Blind LSB Embedding</h3>
<ol class="small-text">
<li><strong>Compress Overhead</strong>: Losslessly compress <code>L</code> and <code>C</code> via JBIG into <code>LC*</code>.</li>
<li><strong>Assemble Bitstream</strong>: <code>S = |LC*| ⊕ |C| ⊕ LC* ⊕ U</code> (16 bits for <code>|LC*|</code>, 17 bits for <code>|C|</code>, plus user payload <code>U</code>).</li>
<li><strong>Embed into Changeable Pairs</strong> (Eqs. 1–2):</li>
</ol>
<div class="formula-box">
x''<sub>i</sub> = x'<sub>i</sub> + 1 - b<sub>i1</sub> &nbsp; if h'<sub>i1</sub> mod 2 = 1<br>
x''<sub>i</sub> = x'<sub>i</sub> - b<sub>i1</sub> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; if h'<sub>i1</sub> mod 2 = 0 and x'<sub>i</sub> &gt; 0<br>
x''<sub>i</sub> = x'<sub>i</sub> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; otherwise (unchangeable)
</div>
<p class="small-text" style="margin-top: 6px;">Symmetrically for <code>z''<sub>i</sub></code> using bit <code>b</code> (where <code>b = b<sub>i1</sub></code> if <code>h'<sub>i1</sub></code> is unchangeable, else <code>b = b<sub>i2</sub></code>). Finally, inverse-map <code>(x''<sub>i</sub>, y'<sub>i</sub>, z''<sub>i</sub>)</code> to stego-block <code>[a'<sub>i</sub>, b'<sub>i</sub>, c'<sub>i</sub>]</code>.</p>
</div>
</div>

<!--
Complete 8-Step Embedding Algorithm (Section 3.2):
1. Partition the N-pixel cover image into non-overlapping 3-pixel blocks and transform each block i into TCP form (x_i, y_i, z_i).
2. Classify each difference into EN (expandable with h <= T) or CN (changeable and not in EN), and expand pixels according to the four mutually exclusive cases (2.1 through 2.4).
3. Populate location map L of fixed size floor(2N/3) bits: e_{2i} = 1 if h_i1 in EN (else 0), e_{2i+1} = 1 if h_i2 in EN (else 0).
4. Compute post-expansion differences h'_i1 = y'_i - x'_i and h'_i2 = y'_i - z'_i. Collect the original LSBs of all changeable differences belonging to CN into list C.
5. Losslessly compress L and C together using JBIG to produce LC*. Because |L| = floor(2N/3) is known to the decoder from the image dimensions, only |LC*| (16 bits) and |C| (17 bits) need to be stored in the header.
6. Concatenate S = |LC*| || |C| || LC* || U.
7. Blindly replace the LSBs of all changeable differences (both expanded EN and non-expanded CN) using Equations (1) and (2). Notice that if h'_i1 is even (as for every expanded difference), x''_i = x'_i - b_i1 increases the difference by b_i1; if h'_i1 is odd (a CN difference), x''_i = x'_i + 1 - b_i1 leaves x'_i unchanged when b_i1 = 1 and increments x'_i by 1 when b_i1 = 0, setting the new difference's LSB directly to b_i1.
8. Inverse-rotate each stego TCP block (x''_i, y'_i, z''_i) back into its raw spatial order [a'_i, b'_i, c'_i].
-->

---

## 3.3 Central-Pixel Symmetry & Threshold `T ≥ 1` Constraint

<div class="split55">
<div>
<div class="fig-box" style="margin-bottom: 10px;">
<img src="./img/fig3_smallest_center.png" alt="Figure 3: Smallest pixel as central pixel equivalence" style="max-height: 175px;">
<div class="fig-cap">Fig. 3. Selecting the smallest pixel (10) vs. largest pixel (20) yields identical expanded block <code>[5, 9, 25]</code>.</div>
</div>
<div class="card teal">
<h3>Duality of Largest vs. Smallest Anchor</h3>
<p class="small-text">For <code>[10, 12, 20]</code>, <code>h<sub>i2</sub> = h<sub>i1</sub> + h<sub>i3</sub> = 8 + 2 = 10</code>. Expanding <code>h<sub>i2</sub></code> to <code>20</code> automatically scales both <code>h<sub>i1</sub> ➔ 16</code> and <code>h<sub>i3</sub> ➔ 4</code>, producing <code>[5, 9, 25]</code> regardless of whether 20 (largest) or 10 (smallest) is chosen as center.</p>
</div>
</div>
<div>
<div class="card accent" style="margin-bottom: 12px;">
<h3>Why <code>T = 0</code> Is Strictly Forbidden</h3>
<p class="small-text">The threshold must satisfy <strong><code>1 ≤ T ≤ 127</code></strong>. If <code>T = 0</code> were allowed, embedding into a non-expanded block could alter which pixel is the largest, breaking TCP canonicalization at the decoder!</p>
</div>
<div class="card">
<h3>Counterexample When <code>T = 0</code></h3>
<ul class="small-text">
<li>Original raw block: <code>[a<sub>i</sub>, b<sub>i</sub>, c<sub>i</sub>] = [29, 29, 30]</code> ➔ TCP <code>(29, 30, 29)</code> with <code>h<sub>i1</sub> = 1, h<sub>i2</sub> = 1 ∈ CN</code>.</li>
<li>Embed bits <strong>"10"</strong> via Eqs. (1)–(2) ➔ <code>(29, 30, 30)</code>, i.e., raw stego-block <code>[30, 29, 30]</code>.</li>
<li><strong>Decoder failure</strong>: Earlier-visited <code>30</code> (first pixel) is now chosen as <code>y'<sub>i</sub></code> ➔ TCP <code>(30, 30, 29)</code> ➔ extracts <strong>"01" ≠ "10"</strong>!</li>
<li>Requiring <code>T ≥ 1</code> ensures all <code>h = 1</code> expandable blocks are expanded to <code>h' = 2</code>, preventing tie collisions.</li>
</ul>
</div>
</div>
</div>

<!--
Mathematical Properties & Edge-Case Rigor (Sections 3.2 & 3.3):
1. Central-Pixel Symmetry (Fig. 3, pp. 7–8):
Given raw block [10, 12, 20], the largest-pixel TCP representation is (12, 20, 10) with h_i1 = 8, h_i2 = 10. Expanding gives h'_i1 = 16, h'_i2 = 20 and (x'_i, y'_i, z'_i) = (9, 25, 5), which maps back to [5, 9, 25].
If instead the smallest pixel (10) is chosen as the central anchor, the differences are h_i2 = 20 - 10 = 10 and h_i3 = 12 - 10 = 2. Because h_i2 = h_i1 + h_i3, doubling h_i2 = 20 = 2*h_i1 + 2*h_i3 yields h'_i3 = 4 and the exact same raw expanded block [5, 9, 25]. Thus, choosing the largest pixel is without loss of generality.

2. Proof of the 1 <= T <= 127 Constraint (Section 3.3, p. 10):
If T = 0, then differences of h = 1 are NOT expanded (they stay in CN). When a block [29, 29, 30] has two differences of 1 and embeds bits "10", Eq. (2) adds 1 to z'_i = 29 (since h'_i2 = 1 is odd and b_2 = 0), turning z''_i into 30. Now a'_i = 30 ties with c'_i = 30, and because a'_i is visited before c'_i, the decoder's tie-breaking rule selects a'_i as y'_i instead of c'_i, rotating the TCP tuple to (30, 30, 29) and inverting the extracted bits to "01". Enforcing T >= 1 eliminates this ambiguity.
-->

---

## 3.4 Blind Extraction & Lossless Restoration Process

<div class="two-col">
<div>
<h3>Steps 1–5: Blind Bitstream Extraction</h3>
<ol class="small-text">
<li>Divide stego-image into 3-pixel blocks in identical scan order and transform each into stego TCP block <code>(x''<sub>i</sub>, y'<sub>i</sub>, z''<sub>i</sub>)</code>.</li>
<li>Compute <code>h''<sub>i1</sub> = y'<sub>i</sub> - x''<sub>i</sub></code> and <code>h''<sub>i2</sub> = y'<sub>i</sub> - z''<sub>i</sub></code>.</li>
<li>Extract bits blindly via Equations (3)–(4):</li>
</ol>
<div class="formula-box">
b<sub>i1</sub> = 1 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; if h''<sub>i1</sub> mod 2 = 1<br>
b<sub>i1</sub> = 0 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; if h''<sub>i1</sub> mod 2 = 0 and x''<sub>i</sub> &gt; 0<br>
b<sub>i1</sub> = nothing &nbsp; otherwise (and likewise for b<sub>i2</sub>, z''<sub>i</sub>)
</div>
<ol start="4" class="small-text">
<li>Concatenate bits into <code>S</code>; parse <code>|LC*|</code> (16b) and <code>|C|</code> (17b); decompress <code>LC*</code> into <code>L</code> (<code>⌊2N/3⌋</code> bits) and <code>C</code>; recover secret message <code>U</code>.</li>
</ol>
</div>
<div>
<h3>Step 6: Exact Pixel Restoration via <code>L</code> &amp; <code>C</code></h3>
<p class="small-text">Compute <code>h<sub>i1</sub> = ⌊(y'<sub>i</sub> - x''<sub>i</sub>)/2⌋</code> and <code>h<sub>i2</sub> = ⌊(y'<sub>i</sub> - z''<sub>i</sub>)/2⌋</code>, then restore:</p>

| Location Bits | Restoration Formula |
|---|---|
| `e_2i=1, e_2i+1=1`<br>(`h_i1 ≥ h_i2`) | `x_i = x''_i + ⌊h_i1/2⌋ + b_i1`<br>`y_i = y'_i - ⌊(h_i1+1)/2⌋`, `z_i = y_i - h_i2` |
| `e_2i=1, e_2i+1=1`<br>(`h_i1 < h_i2`) | `y_i = y'_i - ⌊(h_i2+1)/2⌋`, `x_i = y_i - h_i1`<br>`z_i = z''_i + ⌊h_i2/2⌋ + b_i2` |
| `e_2i=1, e_2i+1=0` | Restore `x_i, y_i` as above; restore `z_i` via `c_2i+1` (`±1` if `c ≠ b_i2`) |
| `e_2i=0, e_2i+1=1` | Restore `y_i, z_i` as above; restore `x_i` via `c_2i` (`±1` if `c ≠ b_i1`) |
| `e_2i=0, e_2i+1=0` | `y_i = y'_i`; restore `x_i, z_i` via control bits `c_2i, c_2i+1` |

</div>
</div>

<!--
Lossless Decoding & Restoration Mechanics (Section 3.3, pp. 8–10):
A major strength of the TCP scheme is that extraction of the raw bitstream S is completely blind to which differences were expanded vs. merely changeable: every expanded difference (EN) is guaranteed to be changeable in the stego-image.
Once S is assembled, the decoder reads the fixed-width length headers |LC*| and |C|, extracts LC*, and invokes the JBIG decoder to recover:
- L: the exact location map of length floor(2N/3) bits, distinguishing expanded pairs (e = 1) from non-expanded pairs (e = 0).
- C: the exact original LSBs of all changeable differences in CN.

In Step 6, the restoration is driven by the pair with the larger difference:
- When both pairs were expanded (Case 6.1), the larger difference restores the largest pixel y_i and the smallest pixel (x_i or z_i) first; once y_i is known, the remaining middle pixel is recovered immediately by subtracting the halved smaller difference (z_i = y_i - h_i2 or x_i = y_i - h_i1).
- For any non-expanded changeable difference (Cases 6.2–6.4), comparing the original control bit c with the extracted bit b tells whether the pixel was shifted by +1 (if c = 1, b = 0 -> subtract 1), -1 (if c = 0, b = 1 -> add 1), or unchanged (c = b). Thus, the host image is recovered with 0 bit error.
-->

---

## 3.5 Complete 3×6 Image Walkthrough (`T = 4`)

<div class="split46">
<div class="fig-box">
<img src="./img/fig4_walkthrough.png" alt="Figure 4: 3x6 image embedding and extraction walkthrough" style="max-height: 445px;">
<div class="fig-cap">Fig. 4. (a) Original 3×6 image; (b) Expanded differences; (c) Stego-image.</div>
</div>
<div>
<div class="card" style="margin-bottom: 10px;">
<h3>1. Embedding Trace (6 Blocks, <code>T = 4</code>)</h3>
<ul class="small-text">
<li><strong>Block 0</strong>: <code>[62, 60, 59]</code> ➔ TCP <code>(59, 62, 60)</code>, <code>h<sub>01</sub>=3, h<sub>02</sub>=2 ≤ 4</code> ➔ expands to <code>(58, 64, 60)</code>.</li>
<li><strong>Non-expandable pairs</strong>: Block 3's first pair <code>(20, 62, 58)</code> (<code>h=42</code>) and both pairs of Block 4 <code>(60, 65, 57)</code> (<code>h=5, 8</code>).</li>
<li><strong>Overhead</strong>: <code>L = (111111010011)<sub>2</sub></code>, <code>C = (010)<sub>2</sub></code> ➔ compressed <code>LC* = (0101)<sub>2</sub></code>.</li>
<li><strong>Bitstream</strong>: <code>S = (100, 011, 0101, 10)<sub>2</sub></code> (<code>|LC*|=4</code>, <code>|C|=3</code>, <code>U=10</code>) embedded into 12 changeable pairs ➔ Fig. 4(c).</li>
</ul>
</div>
<div class="card teal">
<h3>2. Extraction &amp; Restoration Trace</h3>
<ul class="small-text">
<li>From stego Block 0 <code>(57, 64, 60)</code>: <code>(64-57) mod 2 = 1</code>, <code>(64-60) mod 2 = 0</code> ➔ extracts <strong>"10"</strong>.</li>
<li>Decompress <code>LC*</code> ➔ recovers <code>L</code>, <code>C</code>, and message <code>U = (10)<sub>2</sub></code>.</li>
<li>Restore Block 0 (<code>e<sub>0</sub>=e<sub>1</sub>=1</code>, <code>h<sub>01</sub>=3 ≥ h<sub>02</sub>=2</code>): <code>x<sub>0</sub> = 57+⌊3/2⌋+1 = 59</code>, <code>y<sub>0</sub> = 64-⌊4/2⌋ = 62</code>, <code>z<sub>0</sub> = 62-2 = 60</code> ➔ <code>[62, 60, 59]</code>.</li>
</ul>
</div>
</div>
</div>

<!--
Step-by-Step Numerical Trace (Section 3.4, pp. 10–11):
Figure 4 demonstrates the full lifecycle on a 3-row x 6-column image (18 pixels = 6 three-pixel blocks, 12 pixel pairs) with threshold T = 4:
- Block 0: [62, 60, 59] -> TCP (59, 62, 60) -> expanded (58, 64, 60) -> embeds "10" -> stego (57, 64, 60) -> raw [64, 60, 57].
- Block 1: [60, 58, 61] -> TCP (58, 61, 60) -> expanded (57, 63, 61) -> embeds "00" -> stego (57, 63, 61) -> raw [61, 57, 63].
- Block 2: [64, 63, 60] -> TCP (60, 64, 63) -> expanded (58, 66, 64) -> embeds "11" -> stego (57, 66, 63) -> raw [66, 63, 57].
- Block 3: [61, 59, 20] -> TCP (20, 61, 59): h_31 = 41 > 4 (CN, e_6 = 0), h_32 = 2 <= 4 (EN, e_7 = 1) -> expanded (20, 62, 58) -> embeds "01" -> stego (20, 62, 57) -> raw [62, 57, 20]. Note that h'_31 = 62 - 20 = 42 (even, LSB = 0 saved in C).
- Block 4: [60, 65, 57] -> TCP (60, 65, 57): h_41 = 5 > 4, h_42 = 8 > 4 (both CN, e_8 = e_9 = 0; LSBs 1, 0 saved in C) -> embeds "01" -> stego (61, 65, 56).
- Block 5: [57, 59, 55] -> TCP (57, 59, 55) -> expanded (57, 61, 53) -> embeds "10" -> stego (56, 61, 53).

All 12 bits of S = (100 011 0101 10)_2 are embedded, extracted blindly, and every pixel is restored bit-for-bit to Fig. 4(a).
-->

---

## 4. Experimental Setup & Benchmark Dataset

<div class="fig-box" style="margin-bottom: 12px;">
<img src="./img/fig5_test_images.png" alt="Figure 5: Four 512x512 grayscale test images" style="max-height: 220px;">
<div class="fig-cap">Fig. 5. Standard 512×512 (8-bit grayscale) test images: (a) Lena; (b) Baboon; (c) Airplane; (d) Boat.</div>
</div>

<div class="two-col">
<div class="card">
<h3>Implementation &amp; Protocol</h3>
<ul class="small-text">
<li><strong>Platform</strong>: Both the proposed TCP scheme and Tian's DE baseline [4] implemented in <strong>Java</strong> on Windows.</li>
<li><strong>Image Size</strong>: <code>512 × 512</code> (<code>N = 262,144</code> pixels, 8 bits/pixel) ➔ <code>⌊2N/3⌋ = 174,762</code> pixel pairs per layer.</li>
<li><strong>Payload &amp; Compression</strong>: Random bitstream <code>U</code> via <code>⌊Math.random() + 0.5⌋</code>; <code>L</code> and <code>C</code> compressed by <strong>JBIG</strong>; 16 bits for <code>|LC*|</code> and 17 bits for <code>|C|</code>.</li>
</ul>
</div>
<div class="card teal">
<h3>Quality &amp; Capacity Metrics</h3>
<div class="formula-box">
MSE = (1 / N) × Σ<sub>i=0..N-1</sub> (x<sub>i</sub> - x''<sub>i</sub>)<sup>2</sup><br>
PSNR = 10 × log<sub>10</sub>(255<sup>2</sup> / MSE) dB
</div>
<ul class="small-text">
<li><strong>Single-Layer Ceiling</strong>: Up to <strong>0.67 bpp</strong> (vs. 0.50 bpp in Tian's method).</li>
<li><strong>Capacity Metric</strong>: Measured over expandable pairs <code>|E|</code> in <code>EN</code>, sweeping threshold <code>T ∈ [1, 127]</code>.</li>
</ul>
</div>
</div>

<!--
Experimental Methodology (Section 4, pp. 11–12):
To ensure a strictly controlled comparison, the authors implemented both the proposed TCP scheme and Tian's 2003 DE method in Java on the same Windows machine and evaluated them on four canonical 512x512 8-bit grayscale images spanning smooth to highly textured content:
- Lena (smooth portraits + moderate edges)
- Baboon (highly textured fur/whiskers—stress test for difference expansion)
- Airplane (large smooth sky/fuselage regions)
- Boat (mixed smooth water and fine mast details)

Overhead Encoding Details:
For N = 262,144 pixels, the location map L has a constant size of floor(2 * 262,144 / 3) = 174,762 bits, so |L| does not need to be transmitted. Only |LC*| (16 bits) and |C| (17 bits)—33 bits of fixed header—are prepended to LC* and the random user payload U. Both L and C are jointly compressed with JBIG before embedding.
-->

---

## 4.2 Visual Quality vs. Embedding Capacity (TCP vs. Tian)

<div class="split55">
<div class="fig-box">
<img src="./img/fig6_psnr_comparison.png" alt="Figure 6: PSNR vs Embedding Capacity across 4 test images" style="max-height: 445px;">
<div class="fig-cap">Fig. 6. PSNR (dB) vs. embedding capacity (bpp) for (a) Lena, (b) Baboon, (c) Airplane, and (d) Boat.</div>
</div>
<div>
<div class="kpi-card teal" style="margin-bottom: 12px;">
<div class="kpi-val">Up to 0.67 bpp</div>
<div class="kpi-label">Single-layer embedding capacity (33% higher ceiling than Tian's 0.50 bpp limit).</div>
</div>
<div class="kpi-card" style="margin-bottom: 12px;">
<div class="kpi-val">Higher PSNR at Every Capacity</div>
<div class="kpi-label">TCP strictly dominates Tian's rate-distortion curve across all four benchmark images.</div>
</div>
<div class="card">
<h3>Key Empirical Findings</h3>
<ul class="small-text">
<li><strong>Smooth Images (Lena, Airplane, Boat)</strong>: TCP achieves ~40–52 dB at low-to-medium payloads and extends well past 0.60 bpp where Tian saturates at 0.50 bpp.</li>
<li><strong>Complex Texture (Baboon)</strong>: Even on high-frequency fur textures, TCP sustains higher PSNR and reaches ~0.65 bpp vs. Tian's ~0.48 bpp ceiling.</li>
<li><strong>Why It Wins</strong>: Sharing the central largest pixel reduces total modified pixels per 2 embedded bits from 4 to at most 3.</li>
</ul>
</div>
</div>
</div>

<!--
Rate-Distortion Comparison Analysis (Section 4, Fig. 6, pp. 12–13):
Figure 6 plots PSNR (dB) against embedding capacity (bpp) for single-layer embedding across all four 512x512 test images:
- Lena (Fig. 6a): TCP stays strictly above Tian's curve from ~0.14 bpp up to 0.666 bpp (32.13 dB at T=127), whereas Tian's curve terminates below 0.50 bpp.
- Baboon (Fig. 6b): Because Baboon has large pixel differences, PSNR drops more rapidly with capacity in both schemes; nevertheless, TCP maintains a clear PSNR advantage at equal capacity and extends total capacity beyond 0.65 bpp.
- Airplane (Fig. 6c) & Boat (Fig. 6d): Both confirm consistent gains in both visual fidelity and maximum single-layer capacity.

Note on Capacity Definition in Fig. 6:
As explicitly noted in Section 4 (p. 12), the horizontal axis of Fig. 6 plots the gross embedding space |E| offered by expandable pixel pairs in EN (normalized by N = 262,144 pixels), while Table 1 separately breaks down the JBIG-compressed overhead |LC*| to determine net user payload.
-->

---

## 4.3 Threshold `T` Trade-Off & JBIG Overhead Analysis (Lena)

<div class="split55">
<div>
<p class="small-text"><strong>Table 1 (Excerpt)</strong>: TCP performance on <code>512×512</code> Lena (<code>|L| = 174,762</code> bits):</p>

| `T` | `\|E\|` (bits) | `\|C\|` (bits) | `\|LC*\|` (bits) | PSNR (dB) | Net Space? |
|---:|---:|---:|---:|---:|---|
| 1 | 36,820 | 137,942 | 299,336 | **51.94** | Overhead > `\|E\|` |
| 4 | 97,395 | 77,367 | 266,736 | 46.02 | Overhead > `\|E\|` |
| 7 | 129,941 | 44,821 | 189,000 | 42.35 | Overhead > `\|E\|` |
| **8** | **136,386** | **38,376** | **169,368** | **41.56** | **Net positive (`T ≥ 8`)** |
| 10 | 145,439 | 29,323 | 137,280 | 40.36 | +37,482 bits net |
| 20 | 163,575 | 11,187 | 66,296 | 37.07 | +108,466 bits net |
| 50 | 173,096 | 1,666 | 14,888 | 33.57 | +159,874 bits net |
| **127** | **174,585** | **177** | **2,512** | **32.13** | **69.6× JBIG ratio** |

</div>
<div>
<div class="card teal" style="margin-bottom: 10px;">
<h3>JBIG Compression Dynamics</h3>
<ul class="small-text">
<li><strong>Large <code>T</code> (e.g., <code>T = 127</code>)</strong>: Nearly all pairs are expanded (<code>L</code> is mostly <code>1</code>s; <code>|C| = 177</code>). JBIG achieves a <strong>69.6×</strong> compression ratio: <code>(174,762 + 177) / 2,512 = 69.6</code>.</li>
<li><strong>Small <code>T</code> (<code>T &lt; 8</code>)</strong>: <code>L</code> is fragmented with mixed <code>0/1</code>s and <code>|C|</code> is large, causing <code>|LC*| &gt; 174,762</code> (total changeable space). Thus <strong><code>T &gt; 7</code></strong> is required on Lena to embed user payload <code>U</code>.</li>
</ul>
</div>
<div class="card accent">
<h3>Honest Edge Case: High-Contrast Blocks</h3>
<p class="small-text">In rare sharp-edge blocks such as <code>(40, 80, 76)</code>, TCP expands to <code>(20, 100, 92)</code> (squared error = 1056), whereas Tian expands <code>(40, 80)</code> and <code>(80, 76)</code> to <code>(20, 100)</code> and <code>(82, 74)</code> (squared error = 808). Because natural images are predominantly smooth, such blocks are rare and overall PSNR strongly favors TCP.</p>
</div>
</div>
</div>

<!--
Quantitative Analysis of Table 1 & Edge-Case Discussion (Sections 3.4 & 4, pp. 11–14):
Table 1 provides the exact empirical trade-off between threshold T, expandable space |E|, non-expanded changeable LSB count |C|, JBIG-compressed overhead |LC*|, and visual quality (PSNR) on 512x512 Lena (total changeable pairs |E| + |C| = 174,762):
- At T = 1..7, |LC*| exceeds 174,762 bits (e.g., 299,336 bits at T = 1 and 189,000 bits at T = 7), meaning the JBIG-compressed overhead alone exceeds the total changeable capacity of the image.
- At T = 8, |LC*| drops to 169,368 bits (< 174,762), leaving 5,394 bits (minus 33 header bits) for user payload U at 41.56 dB PSNR.
- By T = 20, net user capacity surpasses 108k bits (~0.41 bpp net) at 37.07 dB; by T = 127, |LC*| shrinks to just 2,512 bits (69.6x compression ratio), yielding >172,000 net user bits (~0.66 bpp net) at 32.13 dB.

Transparent MSE Boundary Analysis (p. 11):
When h_i1 >> h_i2 (e.g., (40, 80, 76) with h_i1 = 40, h_i2 = 4), lifting y_i by +20 forces z'_i = 100 - 8 = 92 (a +16 shift on z_i), producing higher local MSE than Tian. The authors explicitly acknowledge this case and explain why natural image smoothness keeps it statistically negligible.
-->

---

## 5. Conclusions & Key Contributions

<div class="three-col" style="margin-bottom: 14px;">
<div class="kpi-card teal">
<div class="kpi-val">0.67 bpp</div>
<div class="kpi-label">Single-layer capacity ceiling (<code>⌊2N/3⌋</code> pairs), a <strong>33% gain</strong> over Tian's 0.50 bpp 2-pixel DE.</div>
</div>
<div class="kpi-card">
<div class="kpi-val">≤ 3 Pixels</div>
<div class="kpi-label">Modified to expand two differences simultaneously via the shared largest pixel <code>y<sub>i</sub></code>.</div>
</div>
<div class="kpi-card accent">
<div class="kpi-val">69.6× JBIG</div>
<div class="kpi-label">Location-map + control-bit compression ratio at <code>T = 127</code> on Lena, enabling high net payload.</div>
</div>
</div>

<div class="two-col">
<div class="card">
<h3>Methodological Contributions</h3>
<ul class="small-text">
<li><strong>TCP Block Transformation</strong>: Canonical cyclic mapping with deterministic tie-breaking and proven largest/smallest central-pixel duality.</li>
<li><strong>Guaranteed Reversibility</strong>: Restoring the larger-difference pair recovers <code>y<sub>i</sub></code> and the smallest pixel first, then directly derives the remaining middle pixel.</li>
</ul>
</div>
<div class="card teal">
<h3>Practical Takeaways</h3>
<ul class="small-text">
<li><strong>Strict Threshold Bounds</strong>: <code>1 ≤ T ≤ 127</code> prevents max-pixel ambiguity; <code>T ≥ 8</code> ensures positive net user payload on Lena under JBIG compression.</li>
<li><strong>Empirical Dominance</strong>: Outperforms Tian's DE in both PSNR and embedding capacity across smooth and textured 512×512 images.</li>
</ul>
</div>
</div>

<!--
Summary of Conclusions (Section 5, pp. 13–14):
The Three-Circular-Pixel (TCP) difference expansion scheme advances spatial-domain reversible data hiding through three coupled mechanisms:
1. Shared-Peak Dual Expansion: Increasing the largest pixel in a 3-pixel circular block expands two differences simultaneously, reducing pixel modifications per embedded bit pair and lifting single-layer capacity to 2/3 bpp.
2. Deterministic Reversibility: By enforcing 1 <= T <= 127 and restoring the larger difference first, the decoder recovers the largest and smallest pixels exactly and derives the third pixel from its halved difference without ambiguity.
3. Empirical Superiority: Across Lena, Baboon, Airplane, and Boat, TCP consistently surpasses Tian's 2003 DE baseline in both visual quality (PSNR) and embedding capacity.
-->

---

<!-- _class: closing -->

# Thank You for Your Attention!

<p style="font-size: 1.05em; max-width: 860px;">
Reversible Data Hiding Based on Three-Circular-Pixel Difference Expansion
</p>

<div class="contact-card">
<strong>Ching-Chiuan Lin<sup>*</sup></strong> · <code>cclin@ocit.edu.tw</code> (Overseas Chinese Institute of Technology)<br>
<strong>Shun-Ping Yang</strong> · <code>ysp@ocit.edu.tw</code> (Overseas Chinese Institute of Technology)<br>
<strong>Nien-Lin Hsueh</strong> · <code>nlhsueh@fcu.edu.tw</code> (Feng Chia University)<br>
<span style="font-size: 0.85em; opacity: 0.88;">Fundamenta Informaticae · IOS Press · 2009 (pp. 1–15)</span>
</div>

<!--
Reference & Archival Metadata:
- Title: Reversible Data Hiding Based on Three-Circular-Pixel Difference Expansion
- Authors: Ching-Chiuan Lin (corresponding author, cclin@ocit.edu.tw), Shun-Ping Yang (ysp@ocit.edu.tw), and Nien-Lin Hsueh (nlhsueh@fcu.edu.tw)
- Affiliations: The Overseas Chinese Institute of Technology (Taichung 40721, Taiwan) and Department of Information Engineering and Computer Science, Feng Chia University (Taichung 40724, Taiwan)
- Venue: Fundamenta Informaticae, IOS Press, 2009 (preprint header XX (2008) 1-15)
- Keywords: Difference expansion, information hiding, reversible data hiding, steganography
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
