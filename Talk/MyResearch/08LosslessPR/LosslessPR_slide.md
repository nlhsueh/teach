---
marp: true
theme: gaia
size: 16:9
paginate: true
html: true
header: '<div class="hdr-wrap"><span class="hdr-title">A Lossless Data Hiding Scheme Based on Three-Pixel Block Differences</span><div class="hdr-actions"><a class="lang-btn" href="./LosslessPR_slide_zh.html" title="切換至繁體中文簡報">🌐 繁</a><div class="nav-dropdown"><button class="nav-btn">Sections ▾</button><div class="nav-menu"><a href="#2">Outline</a><a href="#3">1. Motivation &amp; Prior Work</a><a href="#4">2. Proposed 3-Pixel Block Scheme</a><a href="#9">3. Experimental Results</a><a href="#13">4. Discussion: Distortion Reduction</a><a href="#14">5. Conclusions</a></div></div></div></div>'
footer: 'Ching-Chiuan Lin & Nien-Lin Hsueh · Feng Chia University · Pattern Recognition 41 (2008) 1415–1425'
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
section.lead h1 { color: #ffffff; font-size: 1.94em; font-weight: 800; line-height: 1.24; margin-bottom: 16px; text-align: left; }
section.lead .subtitle { color: #cbd5e1; font-size: 0.92em; line-height: 1.5; margin-bottom: 24px; max-width: 960px; }
section.lead .meta-box { border-left: 4px solid #f43f5e; padding-left: 18px; color: #e2e8f0; font-size: 0.84em; line-height: 1.62; }

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
  font-size: 0.72em;
  margin: 6px 0 8px 0;
  background: #ffffff;
  border: 1px solid var(--slate-200);
}
th {
  background: var(--navy);
  color: #ffffff;
  font-weight: 700;
  padding: 5px 8px;
  text-align: left;
  border: 1px solid var(--navy);
}
td {
  padding: 4.5px 8px;
  border: 1px solid var(--slate-200);
  vertical-align: middle;
  line-height: 1.32;
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

.small-text { font-size: 0.81em; }
.formula-box {
  background: var(--slate-100);
  border: 1px solid var(--slate-200);
  border-left: 4px solid var(--navy);
  border-radius: 6px;
  padding: 7px 13px;
  font-family: 'JetBrains Mono', monospace;
  font-size: 0.77em;
  line-height: 1.48;
  color: var(--slate-900);
  margin: 6px 0;
}

@media print {
  .lang-btn, .nav-dropdown { display: none !important; }
}
</style>

<!-- _class: lead -->

<div class="badge">Pattern Recognition · Vol. 41 (2008) 1415–1425 · Elsevier</div>

# A Lossless Data Hiding Scheme Based on Three-Pixel Block Differences

<div class="subtitle">
Enhancing histogram-shifting reversible data hiding with adaptive <strong>three-pixel block differences</strong>, two-pass boundary management, and central-pixel optimization — achieving up to <strong>2.08 bpp</strong> average payload (<strong>6×–10×</strong> higher than Ni et al.)
</div>

<div class="meta-box">
<strong>Ching-Chiuan Lin<sup>*</sup></strong> · <code>cclin@ocit.edu.tw</code> (Dept. of Information Management, OCIT &amp; Ph.D. Candidate, FCU)<br>
<strong>Nien-Lin Hsueh</strong> · <code>nlhsueh@fcu.edu.tw</code> (Dept. of Information Engineering and Computer Science, Feng Chia University)<br>
Taichung 40724, Taiwan, ROC · DOI: <code>10.1016/j.patcog.2007.09.005</code>
</div>

<!--
Bibliographic & Research Overview:
This paper (Ching-Chiuan Lin & Nien-Lin Hsueh; Pattern Recognition, Vol. 41, 2008, pp. 1415–1425, Elsevier; received Oct 19, 2006, accepted Sep 6, 2007) proposes a high-capacity lossless (reversible) data hiding scheme based on histogram shifting of three-pixel block differences.

Core Breakthrough:
While Ni et al.'s (2006) pixel-value histogram shifting achieves simple lossless recovery without large location maps, natural images rarely have a single pixel value exceeding 3,000 occurrences, restricting capacity. By switching from raw pixel values to absolute differences (|b_i0 - b_i1| and |b_i1 - b_i2|) inside adaptively partitioned 3-pixel blocks, the histogram peak surges over 10x (e.g., 32,339 on Lena). Combined with multi-plane chaining, two-pass Fresh Boundary Block (FB) tracking, and single-pixel central modification for "11" bit pairs, the scheme attains 2.08 bpp average total payload (1.79 bpp pure) and 1.39 bpp (1.32 bpp pure) at PSNR >= 30 dB.
-->

---

## Outline

<div class="outline-grid">
<div class="outline-item">
<div class="outline-num">1</div>
<div class="outline-body"><a href="#3">Motivation &amp; Prior Art</a><br>Lossless steganography for medical/military domains and why pixel-histogram shifting stalls.</div>
</div>
<div class="outline-item">
<div class="outline-num">2</div>
<div class="outline-body"><a href="#4">Adaptive 3-Pixel Block Differences</a><br>6 partition candidates (BO × BT), block-difference histogram, and the 19-bit Key of Four.</div>
</div>
<div class="outline-item">
<div class="outline-num">3</div>
<div class="outline-body"><a href="#5">Two-Pass Architecture &amp; Rules</a><br>BB vs. FB boundary handling, overhead bit budgets, 9-branch embedding, and 36-case extraction.</div>
</div>
<div class="outline-item">
<div class="outline-num">4</div>
<div class="outline-body"><a href="#8">Multi-Plane Stack &amp; Walkthrough</a><br>Complete 5×12 image trace showing partition selection, FB logging, and LIFO recovery.</div>
</div>
<div class="outline-item">
<div class="outline-num">5</div>
<div class="outline-body"><a href="#9">Experimental Results</a><br>8 benchmark images, Tables 1–2 (up to 2.08 bpp), histogram concentration, and Ni et al. comparison.</div>
</div>
<div class="outline-item">
<div class="outline-num">6</div>
<div class="outline-body"><a href="#13">Discussion &amp; Conclusions</a><br>Block-type alternation distortion cancellation, central-pixel single edit, and key takeaways.</div>
</div>
</div>

<!--
Structural Map of the Paper:
- Section 1 (Introduction, pp. 1415–1416): Contrasts encryption (DES/RSA) with imperceptible data hiding, motivates lossless restoration, and reviews LSB compression (Fridrich et al.), G-LSB (Celik et al.), Difference Expansion (Tian, Alattar, Chang & Lu), and Histogram Shifting (Ni et al.).
- Section 2 (The Proposed Scheme, pp. 1416–1421): Presents the two-pass embedding overview (Fig. 1), formal 9-step embedding algorithm (2.1, Figs. 2–3), overhead bit-budget derivation (2.2, Fig. 4), 9-step reverse-stack extraction (2.3, Fig. 5), and a worked 5x12 example (2.4, Fig. 6).
- Section 3 (Experimental Results, pp. 1421–1423): Evaluates 8 grayscale 512x512 images (Fig. 7) for max capacity (Table 1) and PSNR >= 30 dB (Table 2), plus histogram (Fig. 8) and multi-plane PSNR/payload (Fig. 9) comparisons against Ni et al.
- Section 4 (Discussion, pp. 1423–1424): Analyzes two key distortion-reduction drivers: alternating block types (Fig. 10) and central-pixel shared modification (Fig. 11).
- Section 5 (Conclusions, pp. 1424–1425): Summarizes the 6x–10x capacity advantage over Ni et al. across smooth to complex imagery.
-->

---

## 1. Motivation & Limitations of Prior Lossless Schemes

<div class="two-col">
<div class="card">
<h3>Steganography vs. Encryption</h3>
<ul class="small-text">
<li><strong>Encryption (DES, RSA)</strong> scrambles content into meaningless ciphertext, alerting interceptors that secret data exist.</li>
<li><strong>Data Hiding</strong> embeds secrets imperceptibly into cover media, but permanent distortion is unacceptable in <strong>medical and military</strong> applications.</li>
<li><strong>Goal</strong>: Achieve <em>exact lossless cover recovery</em> with high payload capacity and high visual quality (PSNR).</li>
</ul>
</div>
<div class="card accent">
<h3>Why Existing RDH Schemes Bottleneck</h3>
<ul class="small-text">
<li><strong>LSB / G-LSB Compression</strong> (Fridrich et al.; Celik et al.): Payload depends heavily on spatial compression efficiency.</li>
<li><strong>Difference Expansion</strong> (Tian; Alattar; Chang &amp; Lu): Requires a <strong>large location map</strong> to track expanded pairs/vectors.</li>
<li><strong>Pixel Histogram Shifting</strong> (Ni et al., 2006): Simple and map-free, but natural images have few pixels sharing the exact peak value <code>M</code> (&lt; 3,000 bits/plane on Lena).</li>
</ul>
</div>
</div>

<div class="callout teal">
<strong>Core Insight of This Paper</strong>: Neighboring pixels in natural images are highly correlated, so their <strong>block differences</strong> concentrate sharply near 0–25. Shifting a <strong>three-pixel block-difference histogram</strong> boosts peak capacity by <strong>10×+</strong>, while in the best case embedding <strong>2 bits ("11")</strong> modifies only the single central pixel by <code>±1</code>!
</div>

<!--
Research Motivation & Literature Positioning (Section 1, pp. 1415–1416):
The paper positions its method at the intersection of two major RDH lineages:
1. Compression-based & DE-based schemes (Fridrich et al. [6,7], Celik et al. [8,9], Tian [10], Alattar [11], Chang & Lu [12]) achieve high capacity but pay a steep overhead penalty (large location maps or fragile residual compression).
2. Ni et al.'s (2006) histogram-shifting algorithm [13] eliminates large location maps by shifting pixel values between the histogram peak M and minimum point m by 1, then shifting M by +1 or 0 to embed bit "1" or "0". However, pixel intensities in natural images are broadly distributed across [30, 230], capping single-plane payload to fewer than 3,000 bits on 512x512 Lena.

By shifting the domain from raw pixel intensities to absolute differences inside non-overlapping 3-pixel blocks—where each block yields two differences sharing a central pixel—Lin & Hsueh preserve histogram shifting's low overhead while dramatically increasing both peak height and bits-per-pixel-edit efficiency.
-->

---

## 2. Core Idea: 3-Pixel Block Differences & Adaptive Partitioning

<div class="fig-box" style="margin-bottom: 10px;">
<img src="./img/diag1_six_partitions.svg" alt="Six adaptive partition candidates and 19-bit Key of Four" style="max-height: 295px;">
</div>

<div class="two-col">
<div class="card">
<h3>Adaptive Block Partitioning</h3>
<p class="small-text">For every embedding plane, evaluate all <strong>6 partitions</strong>: <code>BO ∈ {Horizontal 1×3, Vertical 3×1}</code> × <code>BT ∈ {Type-0, Type-1, Type-2}</code> (offset <code>t = 0, 1, 2</code>). Select the partition maximizing peak count <code>g(M)</code>.</p>
</div>
<div class="card teal">
<h3>Block Differences &amp; Key of Four</h3>
<p class="small-text">Each block <code>(b<sub>i0</sub>, b<sub>i1</sub>, b<sub>i2</sub>)</code> yields <code>d<sub>i0</sub> = |b<sub>i0</sub> - b<sub>i1</sub>|</code> and <code>d<sub>i1</sub> = |b<sub>i1</sub> - b<sub>i2</sub>|</code>. Find peak <code>M</code> and min <code>m</code> (<code>M &lt; m</code>, smallest <code>|M - m|</code>). Only <strong>3 extra bits</strong> for <code>(BO, BT)</code> gain hundreds to thousands of bits per plane!</p>
</div>
</div>

<!--
Adaptive Partitioning & Key of Four (Section 2.1, pp. 1416–1418):
An h x w grayscale image can be partitioned into non-overlapping 3-pixel blocks along two orientations (BO) and three starting offsets (BT, t in {0, 1, 2}):
- Horizontal (1x3): (b_{u, 3v+t}, b_{u, 3v+t+1}, b_{u, 3v+t+2})
- Vertical (3x1): (b_{3u+t, v}, b_{3u+t+1, v}, b_{3u+t+2, v})

For each of the 6 candidates, blocks containing any boundary pixel (0 or 255) are excluded when building the difference histogram g(d) for 0 <= d <= 253. The encoder finds maximum g(M) and minimum g(m) (with M < m, breaking ties by minimizing |M - m| so fewer differences need shifting).
The winning quadruple (BO, BT, M, m)—termed the "Key of Four"—defines one embedding plane with gross capacity g(M) bits and costs only 1 + 2 + 8 + 8 = 19 bits to encode.
Note: The paper notes that g(m) = 0 in virtually all test images (few differences exceed 130); if g(m) != 0, those block indices would simply be logged in overhead.
-->

---

## 2.2 Two-Pass Embedding & Extraction Overview

<div class="fig-box" style="margin-bottom: 10px;">
<img src="./img/fig1_overview.png" alt="Figure 1: Overview of two-pass embedding and extraction" style="max-height: 290px;">
<div class="fig-cap">Fig. 1. Two-pass embedding (a) and reverse two-pass extraction (b) preventing boundary ambiguity.</div>
</div>

<div class="two-col">
<div class="card accent">
<h3>Boundary Blocks (BB) vs. Fresh Boundary Blocks (FB)</h3>
<ul class="small-text">
<li><strong>BB</strong>: Any block already containing pixel value <code>0</code> or <code>255</code> ➔ skipped during embedding to prevent overflow/underflow.</li>
<li><strong>FB</strong>: A near-boundary block (<code>min = 1</code> or <code>max = 254</code>) that becomes <code>0</code> or <code>255</code> after embedding (e.g., <code>(2, 1, 2)</code> embedding <code>"11"</code> ➔ <code>(2, 0, 2)</code>).</li>
</ul>
</div>
<div class="card">
<h3>Why Two Passes Solve FB Ambiguity</h3>
<ul class="small-text">
<li><strong>Pass 1</strong> processes near-boundary blocks (<code>min = 1</code> or <code>max = 254</code>) first and logs every newly created FB index.</li>
<li><strong>Pass 2</strong> processes interior blocks (<code>2 ≤ b ≤ 253</code>, guaranteed never to hit <code>0/255</code>) to embed the FB overhead list + residual message.</li>
</ul>
</div>
</div>

<!--
Overflow/Underflow Prevention Without a Full Location Map (Section 2, pp. 1416–1417):
A classic dilemma in histogram shifting is distinguishing an original Boundary Block (BB, containing 0 or 255, which was untouched) from a Fresh Boundary Block (FB, which started with 1 or 254 and was shifted to 0 or 255 during embedding).

Lin & Hsueh solve this cleanly via two-pass spatial separation within every embedding plane:
- Pass 1 (Step 6): Scan only blocks with 1 <= b <= 254 AND (min = 1 or max = 254). Embed initial message bits; if any modified block hits 0 or 255, record its block index as an FB.
- Pass 2 (Step 7): Scan only interior blocks with 2 <= b <= 253. Because each pixel changes by at most +/-1 per plane, Pass 2 blocks can NEVER become 0 or 255! Therefore, the overhead information (containing all Pass 1 FB indices) embedded in Pass 2 is always 100% decodable by the receiver before touching any 0/255 block.

Worked Example from Section 2 (p. 1416, M=1, m=20):
- Pass 1: (2, 1, 2) embeds "11" -> (2, 0, 2) [logged as FB; only central pixel changed!]; (253, 254, 240) embeds "0" -> (253, 254, 239); (246, 243, 254) shifts -> (246, 242, 254).
- Pass 2: (3, 4, 6) embeds "0" -> (3, 4, 7). Original BB (0, 3, 5) is skipped in both passes.
-->

---

## 2.3 Two-Pass FB Management & Overhead Formats

<div class="fig-box" style="margin-bottom: 10px;">
<img src="./img/diag2_two_pass_fb.svg" alt="Two-pass FB management and LIFO stack unwinding" style="max-height: 225px;">
</div>

<div class="split55">
<div class="fig-box">
<img src="./img/fig4_overhead.png" alt="Figure 4: Overhead formats for first, middle, and last planes" style="max-height: 170px;">
<div class="fig-cap">Fig. 4. Overhead headers: (a) first, (b) middle, and (c) last embedding plane.</div>
</div>
<div class="card">
<h3>Compact Overhead Bit-Budget Analysis</h3>
<ul class="small-text">
<li><strong>Max Blocks</strong>: <code>η = max(h×⌊w/3⌋, w×⌊h/3⌋)</code>; each FB index (<code>IFB</code>) takes <code>δ = ⌈log<sub>2</sub> η⌉</code> bits.</li>
<li><strong>Key of Four</strong>: <code>BO</code> (1b) + <code>BT</code> (2b) + <code>M</code> (8b) + <code>m</code> (8b) = <strong>19 bits</strong>; <code>#EPs</code> = 8 bits in last plane.</li>
<li><strong>512×512 Image</strong>: <code>#FBs</code> takes <strong>14 bits</strong> and each <code>IFB</code> takes <strong>17 bits</strong>; most planes at <code>PSNR ≥ 30 dB</code> need <strong>&lt; 1,000 bits</strong> overhead total!</li>
</ul>
</div>
</div>

<!--
Overhead Format & Mathematical Bound (Section 2.2, p. 1419):
Each embedding plane chains backward to its predecessor via compact overhead embedded in Pass 2:
- First plane (Fig. 4a): [#FBs | IFBs]
- Middle plane (Fig. 4b): [#FBs | IFBs | BO | BT | M | m] (carrying the Key of Four of the preceding plane)
- Last plane (Fig. 4c): [#FBs | IFBs | BO | BT | M | m | #EPs] (also carrying total plane count #EPs < 256)
Only the last plane's 19-bit Key of Four is sent separately to the receiver (or optionally hidden in 19 negotiated pixel LSBs whose original bits are saved in overhead).

Deriving the Bit Width of #FBs:
If an embedding plane has at most x Fresh Boundary Blocks, encoding #FBs and IFBs needs ceil(log2 x) + x*delta bits. Remaining Pass 2 capacity is at most r = (eta - x)*2 - ceil(log2 x) - 19. Requiring x*delta <= r yields x < 2*eta / (delta + 2), so #FBs requires approximately ceil(log2(2*eta / (delta + 2))) bits. For a 512x512 image (eta = 512*170 = 87,040), delta = 17 bits and #FBs = 14 bits.
-->

---

## 2.4 Embedding & Extraction Decision Rules

<div class="two-col">
<div class="card">
<h3>9-Branch <code>embedding_procedure</code> (Figs. 2–3)</h3>
<p class="small-text">Each block's two differences <code>(d<sub>i0</sub>, d<sub>i1</sub>)</code> each fall into 3 regimes: <code>== M</code> (embed 1 bit), <code>M &lt; d &lt; m</code> (shift +1), or <code>else</code> (unchanged) ➔ <code>3 × 3 = 9</code> branches.</p>

| Shape of <code>(b<sub>i0</sub>, b<sub>i1</sub>, b<sub>i2</sub>)</code> | Action in <code>embed_2_bits</code> (<code>eb<sub>1</sub>, eb<sub>2</sub></code>) |
|---|---|
| Monotonic <code>b<sub>i0</sub> &gt; b<sub>i1</sub> &gt; b<sub>i2</sub></code> | <code>b<sub>i0</sub> += eb<sub>1</sub></code>, <code>b<sub>i2</sub> -= eb<sub>2</sub></code> |
| Monotonic <code>b<sub>i0</sub> &lt; b<sub>i1</sub> &lt; b<sub>i2</sub></code> | <code>b<sub>i0</sub> -= eb<sub>1</sub></code>, <code>b<sub>i2</sub> += eb<sub>2</sub></code> |
| Flat <code>b<sub>i0</sub> == b<sub>i1</sub> == b<sub>i2</sub></code> | If <code>11</code>: <strong><code>b<sub>i1</sub> += 1</code></strong>; else <code>b<sub>i0</sub> -= eb<sub>1</sub>, b<sub>i2</sub> += eb<sub>2</sub></code> |
| Peak <code>b<sub>i0</sub> &lt; b<sub>i1</sub> &gt; b<sub>i2</sub></code> | If <code>11</code>: <strong><code>b<sub>i1</sub> += 1</code></strong>; else <code>b<sub>i0</sub> -= eb<sub>1</sub>, b<sub>i2</sub> -= eb<sub>2</sub></code> |
| Valley <code>b<sub>i0</sub> &gt; b<sub>i1</sub> &lt; b<sub>i2</sub></code> | If <code>11</code>: <strong><code>b<sub>i1</sub> -= 1</code></strong>; else <code>b<sub>i0</sub> += eb<sub>1</sub>, b<sub>i2</sub> += eb<sub>2</sub></code> |

</div>
<div class="card teal">
<h3>36-Case Exact Extraction Table (Fig. 5)</h3>
<ul class="small-text">
<li><strong>4 Difference Regimes</strong> at decoder: <code>d == M</code> (bit <code>0</code>), <code>d == M+1</code> (bit <code>1</code>, shrink by 1), <code>M+1 &lt; d ≤ m</code> (shrink by 1), or <code>d &lt; M or d &gt; m</code> (no-op).</li>
<li><strong>Order Preservation</strong>: Because monotonic blocks move outer pixels outward and peak/valley blocks push <code>b<sub>i1</sub></code> further away from neighbors, the relative ordering (<code>&lt;</code>, <code>&gt;</code>) is strictly preserved!</li>
<li><strong>Single-Edit Recovery</strong>: For peak <code>b<sub>i0</sub> &lt; b<sub>i1</sub> &gt; b<sub>i2</sub></code> with <code>d<sub>i0</sub> = d<sub>i1</sub> = M+1</code> (Item 11), extract <code>"11"</code> and restore via <code>b<sub>i1</sub> = b<sub>i1</sub> - 1</code>.</li>
<li><strong>Exact Inverse</strong>: Every one of the 36 mutually exclusive conditions uniquely inverts Figs. 2–3.</li>
</ul>
</div>
</div>

<!--
Algorithmic Structure of Embedding & Extraction Rules (Sections 2.1 & 2.3, Figs. 2, 3, 5):
In Fig. 2, `embedding_procedure` dispatches on the pair (d_i0, d_i1) into 8 active sub-procedures plus `do nothing`.
The key distortion-minimization trick appears across `embed_2_bits`, `embed_1_bit_and_increase_difference`, `increase_difference_and_embed_1_bit`, and `increase_2_differences` (Fig. 3):
- Whenever BOTH differences must increase by 1 AND the block is a local peak (b_i0 < b_i1 > b_i2), local valley (b_i0 > b_i1 < b_i2), or flat (b_i0 == b_i1 == b_i2), modifying ONLY the central pixel b_i1 by +1 (for peak/flat) or -1 (for valley) increases BOTH |b_i0 - b_i1| and |b_i1 - b_i2| simultaneously!
- In all other cases (strictly monotonic blocks or single-difference changes), only the corresponding outer pixel (b_i0 or b_i2) is moved away from b_i1.

This design guarantees that no sign inversion ever occurs between adjacent pixels, so the 36-row lookup table in Fig. 5 (Items 1–36) deterministically extracts every embedded bit and shifts every modified pixel back by +/-1 to its exact original intensity.
-->

---

## 2.5 Multi-Plane Stack Extraction & 5×12 Walkthrough

<div class="split46">
<div class="fig-box">
<img src="./img/fig6_example.png" alt="Figure 6: 5x12 embedding and extraction example" style="max-height: 445px;">
<div class="fig-cap">Fig. 6. 5×12 grayscale middle-plane trace: (a) original; (b) stego-image.</div>
</div>
<div>
<div class="card" style="margin-bottom: 10px;">
<h3>1. Partition Selection &amp; Two-Pass Embedding</h3>
<ul class="small-text">
<li>Evaluates 6 partitions: <strong>1×3 Type-0</strong> wins with <code>M=1, m=5, g(M)=23</code> (skipping BB block 3 <code>(1,0,7)</code>).</li>
<li><strong>Pass 1</strong> (message <code>0011</code>): Block 1 <code>(1,3,4)</code> embeds <code>0</code> ➔ <code>(0,3,4)</code> (<strong>logged as FB #1!</strong>); Block 13 shifts <code>(1,5,2) ➔ (1,6,2)</code>; Block 14 embeds <code>01</code> ➔ <code>(1,2,4)</code>.</li>
<li><strong>Pass 2</strong>: Embeds 19-bit overhead (<code>#FBs=001, IFB=00001, BO'=0, BT'=1, M'=1, m'=3</code>) + residual bit <code>1</code> into interior blocks.</li>
</ul>
</div>
<div class="card teal">
<h3>2. Reverse Extraction &amp; Stack Reordering</h3>
<ul class="small-text">
<li><strong>Scan <code>1..254</code></strong>: Skips both Block 1 <code>(0,3,4)</code> and Block 3 <code>(1,0,7)</code>; separates <code>List-1 = 01</code> (Block 14) and <code>List-2</code> (19b overhead <code>List-2'</code> + residual <code>List-2'' = 1</code>).</li>
<li><strong>Decode FB</strong>: Overhead reveals Block 1 is FB (Block 3 is true BB) ➔ extracts <code>List-3 = 0</code> and restores <code>(1,3,4)</code>.</li>
<li><strong>Reorder &amp; Stack</strong>: Merge <code>List-1</code> + <code>List-3</code> by block index ➔ <code>List-4 = 001</code>; push <code>List-2''</code> then <code>List-4</code> onto LIFO stack ➔ recovers <strong><code>(0011)<sub>2</sub></code></strong>.</li>
</ul>
</div>
</div>
</div>

<!--
Detailed Trace of the 5x12 Worked Example (Section 2.4, pp. 1419–1421):
For the 5x12 image (20 non-overlapping 1x3 blocks), each block index takes ceil(log2 20) = 5 bits and #FBs takes ceil(log2(40/7)) = 3 bits (M and m use 4 bits here for illustration).
Comparing all 6 candidate partitions:
1. 1x3 Type-0: M=1, m=5, g(M)=23 (winner!)
2. 1x3 Type-1: M=1, m=5, g(M)=16
3. 1x3 Type-2: M=1, m=5, g(M)=14
4. 3x1 Type-0: M=1, m=7, g(M)=7
5. 3x1 Type-1: M=1, m=5, g(M)=8
6. 3x1 Type-2: M=1, m=7, g(M)=7

Why a LIFO Stack Is Needed Across Multiple Planes (Section 2.3, Steps 7–9):
Because embedding proceeds from Plane 1 -> Plane 2 -> ... -> Plane K, extraction must unwind in reverse order (Plane K -> ... -> Plane 1) using the chained Keys of Four. Within each plane, Pass 1 message bits (List-4) preceded Pass 2 residual bits (List-2''). Pushing List-2'' first and List-4 second onto a stack ensures that popping the stack after reaching Plane 1 outputs the entire multi-plane secret bitstream in exact original forward order.
-->

---

## 3. Experimental Setup & Eight Benchmark Images

<div class="fig-box" style="margin-bottom: 12px;">
<img src="./img/fig7_test_images.png" alt="Figure 7: Eight 512x512 grayscale test images" style="max-height: 255px;">
<div class="fig-cap">Fig. 7. Eight 512×512 (8-bit grayscale) test images from complex to smooth: (a) Baboon, (b) Boat, (c) Lena, (d) Airplane, (e) Pepper, (f) Tiffany, (g) GoldHill, (h) Gradient.</div>
</div>

<div class="two-col">
<div class="card">
<h3>Test Suite &amp; Payload Protocol</h3>
<ul class="small-text">
<li><strong>8 Diverse Images</strong>: Spanning high-frequency texture (<code>Baboon</code>) to computer-generated smooth ramp (<code>Gradient</code>, 2 rows per gray level 0..255).</li>
<li><strong>Embedded Secret</strong>: A portion of the <code>Lena</code> image served as user message <code>U</code> across all experiments.</li>
</ul>
</div>
<div class="card teal">
<h3>Capacity &amp; Distortion Metrics</h3>
<ul class="small-text">
<li><strong>Payload vs. Pure Payload</strong>: Total capacity sums <code>g(M)</code> across planes; <em>Pure Payload</em> subtracts all overhead (<code>#FBs</code>, <code>IFBs</code>, Keys of Four).</li>
<li><strong>Visual Quality</strong>: Evaluated via standard <code>PSNR = 10 × log<sub>10</sub>(255<sup>2</sup>·h·w / Σ(p<sub>i,j</sub> - q<sub>i,j</sub>)<sup>2</sup>)</code> dB.</li>
</ul>
</div>
</div>

<!--
Experimental Setup & Benchmark Diversity (Section 3, pp. 1421–1422):
Eight 512x512 8-bit grayscale images (262,144 pixels each) were tested to span the full spectrum of spatial smoothness:
- Complex texture: Baboon
- Natural photographic scenes: Boat, Lena, Airplane, Pepper, Tiffany, GoldHill
- Synthetic smooth gradient: Gradient (first two rows = 0, rows 3–4 = 1, etc.)

All experiments embed real image data (a segment of Lena) rather than synthetic zeros, and measure both gross payload (sum of g(M) over all embedding planes) and pure payload (net user message bits after subtracting every plane's Fig. 4 overhead). For example, on Airplane (56 planes), total payload is 585,380 bits (2.23 bpp) and pure payload is 563,704 bits (2.15 bpp), meaning total overhead across all 56 planes is only 21,676 bits (~3.7%).
-->

---

## 3.2 Maximum Capacity & High-Quality (`PSNR ≥ 30 dB`) Results

<div class="two-col">
<div>
<p class="small-text"><strong>Table 1</strong>: Maximum Multi-Plane Capacity</p>

| Image | PSNR | Planes | Payload (bpp) | Pure (bpp) |
|---|---:|---:|---:|---:|
| Baboon | 20.5 | 57 | 339,308 (1.29) | 297,607 (1.14) |
| Boat | 20.3 | 62 | 535,301 (2.04) | 446,141 (1.70) |
| Lena | 20.8 | 58 | 513,983 (1.96) | 452,546 (1.73) |
| Airplane | 21.0 | 56 | 585,380 (2.23) | 563,704 (2.15) |
| Pepper | 20.8 | 59 | 574,850 (2.19) | 449,035 (1.71) |
| Tiffany | 25.2 | 34 | 441,674 (1.68) | 405,475 (1.55) |
| GoldHill | 21.4 | 53 | 501,546 (1.91) | 426,504 (1.63) |
| Gradient | 26.5 | 33 | 867,554 (3.31) | 706,931 (2.70) |
| **Average** | — | — | **2.08 bpp** | **1.79 bpp** |

</div>
<div>
<p class="small-text"><strong>Table 2</strong>: High-Quality Regime (<code>PSNR ≥ 30 dB</code>)</p>

| Image | PSNR | Planes | Payload (bpp) | Pure (bpp) |
|---|---:|---:|---:|---:|
| Baboon | 30.4 | 17 | 162,544 (0.62) | 161,118 (0.61) |
| Boat | 30.4 | 19 | 307,937 (1.17) | 307,193 (1.17) |
| Lena | 30.0 | 20 | 309,166 (1.18) | 308,474 (1.18) |
| Airplane | 30.3 | 19 | 367,392 (1.40) | 366,784 (1.40) |
| Pepper | 30.2 | 20 | 356,450 (1.36) | 322,744 (1.23) |
| Tiffany | 30.1 | 19 | 332,570 (1.27) | 331,962 (1.27) |
| GoldHill | 30.1 | 20 | 303,629 (1.16) | 302,784 (1.16) |
| Gradient | 30.1 | 21 | 764,817 (2.92) | 660,511 (2.52) |
| **Average** | **≥30** | **~19** | **1.39 bpp** | **1.32 bpp** |

</div>
</div>

<div class="callout teal">
<strong>Negligible Overhead at High Quality</strong>: Under <code>PSNR ≥ 30 dB</code>, most natural images incur <strong>less than 1,000 bits of total overhead</strong> across ~20 planes (e.g., Lena: 309,166 total vs. 308,474 pure = only 692 bits overhead!), achieving <strong>1.32 bpp</strong> average pure payload.
</div>

<!--
Quantitative Analysis of Tables 1 & 2 (Section 3, pp. 1421–1423):
Table 1 evaluates maximum multi-plane capacity until embedding can no longer proceed:
- Capacity scales directly with image smoothness: from 1.29 bpp total (1.14 bpp pure) on highly textured Baboon up to 3.31 bpp total (2.70 bpp pure) on Gradient, with an 8-image average of 2.08 bpp total / 1.79 bpp pure.
- Natural photographs (Boat, Lena, Airplane, Pepper, GoldHill) consistently reach 1.91–2.23 bpp total capacity across 53–62 planes.

Table 2 evaluates the practically important high-fidelity regime (PSNR >= 30 dB):
- Across 17–21 planes, the scheme delivers an average of 1.39 bpp total and 1.32 bpp pure payload.
- Overhead is remarkably small because very few pixels drift near 0 or 255 in the first ~20 planes: e.g., Lena has only 692 overhead bits across 20 planes, Boat 744 bits, Airplane 608 bits, Tiffany 608 bits, and GoldHill 845 bits. (Pepper and Gradient have slightly more FBs because their original intensity distributions already touch near-0/near-255 regions.)
-->

---

## 3.3 Why Block Differences Win: Histogram Concentration

<div class="split55">
<div class="fig-box">
<img src="./img/fig8_histograms.png" alt="Figure 8: Ni et al. vs Proposed Histograms for Lena and Baboon" style="max-height: 445px;">
<div class="fig-cap">Fig. 8. Pixel-value histograms (Ni et al., left) vs. 3-pixel block-difference histograms (Ours, right) for Lena (top) and Baboon (bottom).</div>
</div>
<div>
<div class="kpi-card teal" style="margin-bottom: 12px;">
<div class="kpi-val">32,339 vs. &lt; 3,000</div>
<div class="kpi-label">First-plane peak count on <code>Lena</code> — more than <strong>10×</strong> single-plane capacity over Ni et al.</div>
</div>
<div class="card" style="margin-bottom: 12px;">
<h3>Lena Distribution Contrast</h3>
<ul class="small-text">
<li><strong>Ni et al. (Pixel Values)</strong>: Intensities spread broadly over <code>30–230</code>; peak frequency never reaches <code>3,000</code> pixels.</li>
<li><strong>Proposed (Block Differences)</strong>: Differences cluster tightly within <code>0–25</code>, producing a towering peak of <code>32,339</code> pairs on Plane 1.</li>
</ul>
</div>
<div class="card accent">
<h3>Baboon Distribution Contrast</h3>
<p class="small-text">Even on heavily textured <code>Baboon</code>, pixel values cap below <code>3,000</code>, whereas block differences surge past <code>12,000+</code> at the peak — confirming consistent gains across both smooth and complex images.</p>
</div>
</div>
</div>

<!--
Statistical Root Cause of Capacity Surge (Section 3, Fig. 8, pp. 1422–1423):
Figure 8 directly explains why the proposed scheme outperforms Ni et al.'s (2006) histogram shifting by an order of magnitude:
- In Fig. 8(a) and 8(c), raw pixel values of Lena and Baboon span a wide dynamic range [30, 230], resulting in flat, multi-modal histograms whose global maximum g(M) is strictly below 3,000.
- In Fig. 8(b) and 8(d), taking absolute differences between adjacent pixels in 3-pixel blocks exploits strong local spatial correlation, collapsing the distribution into a sharp Laplacian-like peak near zero (0–25 for Lena). On Lena's first plane, g(M) reaches 32,339 bits—over 10.7x larger than Ni et al.'s < 3,000 bits.
-->

---

## 3.4 Multi-Plane Capacity & PSNR Comparison vs. Ni et al.

<div class="split55">
<div class="fig-box">
<img src="./img/fig9_psnr_payload.png" alt="Figure 9: Payload and PSNR across 20 planes on Lena" style="max-height: 410px;">
<div class="fig-cap">Fig. 9. Plane-by-plane payload capacity (bits) and PSNR (dB) on Lena (Planes 1–20).</div>
</div>
<div>
<div class="kpi-card teal" style="margin-bottom: 12px;">
<div class="kpi-val">6× to 10× Payload</div>
<div class="kpi-label">Dramatically higher capacity than Ni et al. on every single embedding plane.</div>
</div>
<div class="kpi-card" style="margin-bottom: 12px;">
<div class="kpi-val">Higher PSNR After Plane 6</div>
<div class="kpi-label">Our PSNR curve crosses above Ni et al. after the 6th plane despite embedding far more data!</div>
</div>
<div class="card">
<h3>Minimal Boundary Drift</h3>
<ul class="small-text">
<li>Across the first <strong>20 embedding planes</strong> on Lena, Ni et al. encounters 0 saturation points while our scheme encounters <strong>only 3 Fresh Boundary Blocks (FBs)</strong>.</li>
<li>Combined with adaptive <code>(BO, BT)</code> selection, capacity remains high across successive planes instead of collapsing.</li>
</ul>
</div>
</div>
</div>

<!--
Multi-Plane Performance Trajectory (Section 3, Fig. 9, pp. 1422, 1424):
Figure 9 overlays both payload capacity (left axis, bits) and PSNR (right axis, dB) across embedding planes 1 through 20 on 512x512 Lena:
1. Payload Advantage: On Plane 1, our scheme embeds >32,000 bits vs. <3,000 bits for Ni et al. Even by Plane 20, our per-plane payload remains ~10,000 bits—still several times higher than Ni et al.'s best plane.
2. PSNR Crossover: Although both curves start around 48–50 dB, Ni et al.'s PSNR drops more steeply across planes because shifting raw pixel histograms shifts huge contiguous ranges of pixels uniformly in one direction. After Plane 6, our PSNR stays strictly HIGHER than Ni et al.'s (reaching ~30.0 dB at Plane 20 while carrying ~309k bits vs. Ni et al.'s much lower cumulative payload).
3. FB Stability: Encountering only 3 FBs across 20 planes proves that two-pass FB logging adds virtually zero overhead in practical high-quality operation.
-->

---

## 4. Discussion: Two Mechanisms That Reduce Distortion

<div class="two-col">
<div>
<div class="fig-box" style="margin-bottom: 10px;">
<img src="./img/fig10_block_type.png" alt="Figure 10: Altering block types cancels distortion" style="max-height: 220px;">
<div class="fig-cap">Fig. 10. Alternating Type-0 (a–b) ➔ Type-1 (c–d) restores pixel <code>b<sub>0,3</sub> = 9</code> back to its original value!</div>
</div>
<div class="card">
<h3>1. Adaptive Block-Type Alternation</h3>
<ul class="small-text">
<li>Plane 1 (Type-0, <code>M=1, m=4</code>) changes pixel <code>b<sub>0,3</sub></code> from <code>9 ➔ 8</code>.</li>
<li>Plane 2 (Type-1, <code>M=1, m=3</code>) changes <code>b<sub>0,3</sub></code> from <code>8 ➔ 9</code> — <strong>canceling prior distortion!</strong></li>
<li>Also utilizes the 2 rightmost columns of a <code>512×512</code> image (since <code>512 mod 3 = 2</code>) across planes.</li>
</ul>
</div>
</div>
<div>
<div class="fig-box" style="margin-bottom: 10px;">
<img src="./img/fig11_central_pixel.png" alt="Figure 11: Modifying only central pixel for 2 operations" style="max-height: 220px;">
<div class="fig-cap">Fig. 11. Single central-pixel edit achieves (a) embed "1" + shift, (b) embed "11", and (c) shift 2 differences.</div>
</div>
<div class="card teal">
<h3>2. Shared Central-Pixel Optimization</h3>
<ul class="small-text">
<li>Because both differences share <code>b<sub>i1</sub></code>, modifying <strong>only <code>b<sub>i1</sub></code> by <code>±1</code></strong> simultaneously handles two operations in peaks/valleys/flats.</li>
<li>Example (b): <code>(4, 3, 4) ➔ (4, 2, 4)</code> embeds <strong>2 bits ("11")</strong> with only <strong>1 pixel modified by 1</strong>!</li>
<li>Cuts pixel modifications in half for these blocks, explaining the superior PSNR after Plane 6.</li>
</ul>
</div>
</div>
</div>

<!--
Deep Analysis of Distortion-Reduction Mechanisms (Section 4, pp. 1423–1424):
Section 4 explains why the proposed scheme achieves BOTH higher payload AND higher PSNR than Ni et al. after Plane 6:
1. Alternating Block Types (Fig. 10):
In a 1x8 cover strip [3, 5, 6, 9, 10, 13, 13, 13], Plane 1 uses horizontal Type-0 blocks (3,5,6) and (9,10,13) with M=1, m=4, embedding "1" and "1" to produce [2, 5, 7, 8, 10, 14, 13, 13]. Plane 2 switches to horizontal Type-1 blocks (5,7,8) and (10,14,13) with M=1, m=3, embedding "1" and "0" to produce [2, 4, 7, 9, 10, 14, 13, 13]. Remarkably, pixel b_{0,3} moves 9 -> 8 -> 9, returning to its exact original intensity! Furthermore, switching Type-0/1/2 ensures the 2 leftover edge pixels (512 = 170*3 + 2) participate in embedding.

2. Shared Central-Pixel Modification (Fig. 11):
When M=1, m=4:
- Fig. 11(a): (4,3,6) -> (4,2,6) and (3,4,1) -> (3,5,1) embed bit "1" on one side AND shift the other difference by +1 using only 1 pixel edit.
- Fig. 11(b): (4,3,4) -> (4,2,4) and (3,4,3) -> (3,5,3) embed TWO bits "11" using only 1 pixel edit.
- Fig. 11(c): (6,4,7) -> (6,3,7) and (4,6,3) -> (4,7,3) shift TWO non-embedding differences using only 1 pixel edit.

3. High ROI of 3-Bit Partition Signaling:
Storing BO (1b) and BT (2b) costs just 3 bits per plane yet boosts each plane's capacity by hundreds to thousands of bits.
-->

---

## 5. Conclusions & Key Contributions

<div class="three-col" style="margin-bottom: 14px;">
<div class="kpi-card teal">
<div class="kpi-val">2.08 bpp</div>
<div class="kpi-label">Average total payload across 8 benchmark images (<strong>1.79 bpp</strong> pure payload; up to 3.31 bpp on Gradient).</div>
</div>
<div class="kpi-card">
<div class="kpi-val">1.39 bpp @ ≥30 dB</div>
<div class="kpi-label">Average payload at high visual quality (<strong>1.32 bpp</strong> pure, with &lt; 1,000 bits overhead on most images).</div>
</div>
<div class="kpi-card accent">
<div class="kpi-val">6×–10× Gain</div>
<div class="kpi-label">Higher payload capacity than Ni et al. (2006), plus higher PSNR from Plane 6 onward.</div>
</div>
</div>

<div class="two-col">
<div class="card">
<h3>Core Algorithmic Innovations</h3>
<ul class="small-text">
<li><strong>3-Pixel Block-Difference Shifting</strong>: Exploits local pixel correlation to concentrate histogram peaks &gt;10× higher than raw pixel values.</li>
<li><strong>Two-Pass FB Management</strong>: Separates near-boundary and interior blocks to achieve 100% lossless recovery without a large location map.</li>
</ul>
</div>
<div class="card teal">
<h3>Distortion &amp; Generalization</h3>
<ul class="small-text">
<li><strong>Dual Distortion Reducers</strong>: Adaptive 6-partition alternation cancels cumulative drift; shared central-pixel edits embed 2 bits via 1 pixel change.</li>
<li><strong>Broad Applicability</strong>: Proven effective across diverse imagery from complex texture (<code>Baboon</code>) to smooth ramps (<code>Gradient</code>).</li>
</ul>
</div>
</div>

<!--
Summary of Conclusions (Section 5, pp. 1424–1425):
This work demonstrates that shifting absolute differences inside adaptively partitioned three-pixel blocks overcomes the capacity bottleneck of pixel-value histogram shifting while keeping overhead minimal:
- Maximum capacity averages 2.08 bpp total (1.79 bpp pure) across eight 512x512 benchmark images.
- In the high-quality PSNR >= 30 dB regime, average capacity reaches 1.39 bpp total (1.32 bpp pure).
- Compared directly to Ni et al.'s (2006) benchmark, payload capacity is 6x to 10x higher while achieving superior PSNR beyond the sixth embedding plane, making the scheme well suited for lossless medical, military, and archival image authentication.
-->

---

<!-- _class: closing -->

# Thank You for Your Attention!

<p style="font-size: 1.05em; max-width: 860px;">
A Lossless Data Hiding Scheme Based on Three-Pixel Block Differences
</p>

<div class="contact-card">
<strong>Ching-Chiuan Lin<sup>*</sup></strong> · <code>cclin@ocit.edu.tw</code> (Overseas Chinese Institute of Technology / Feng Chia University)<br>
<strong>Nien-Lin Hsueh</strong> · <code>nlhsueh@fcu.edu.tw</code> (Dept. of Information Engineering and Computer Science, Feng Chia University)<br>
<span style="font-size: 0.85em; opacity: 0.88;">Pattern Recognition 41 (2008) 1415–1425 · Elsevier · DOI: 10.1016/j.patcog.2007.09.005</span>
</div>

<!--
Reference & Archival Metadata:
- Title: A lossless data hiding scheme based on three-pixel block differences
- Authors: Ching-Chiuan Lin (corresponding author, cclin@ocit.edu.tw) and Nien-Lin Hsueh (nlhsueh@fcu.edu.tw)
- Affiliation: Department of Information Engineering and Computer Science, Feng Chia University, Taichung 40724, Taiwan, ROC
- Venue: Pattern Recognition, Vol. 41, 2008, pp. 1415-1425, Elsevier Ltd.
- DOI: 10.1016/j.patcog.2007.09.005 (Received 19 October 2006; revised 2 September 2007; accepted 6 September 2007)
- Keywords: Lossless data hiding; Reversible data hiding; Block difference; Steganography
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
