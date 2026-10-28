#!/usr/bin/env node

/**
 * Pre-renders Markdown lecture notes to beautiful self-contained HTML pages
 * for the Python course (Ch01 ~ Ch12).
 */

const fs = require('fs');
const path = require('path');

const lectures = [
  { file: 'Python/Lecture/ch01_intro.md', out: 'Python/Lecture/ch01_intro.html', title: 'Ch01 導論與環境建置', slideHtml: '../Slide/html/ch01s_intro.html', slidePdf: '../Slide/pdf/ch01s_intro.pdf' },
  { file: 'Python/Lecture/ch02_program.md', out: 'Python/Lecture/ch02_program.html', title: 'Ch02 程式基本元素', slideHtml: '../Slide/html/ch02s_program.html', slidePdf: '../Slide/pdf/ch02s_program.pdf' },
  { file: 'Python/Lecture/ch03_control.md', out: 'Python/Lecture/ch03_control.html', title: 'Ch03 流程控制結構', slideHtml: '../Slide/html/ch03s_control.html', slidePdf: '../Slide/pdf/ch03s_control.pdf' },
  { file: 'Python/Lecture/ch04_collection.md', out: 'Python/Lecture/ch04_collection.html', title: 'Ch04 資料容器與結構', slideHtml: '../Slide/html/ch04s_collection.html', slidePdf: '../Slide/pdf/ch04s_collection.pdf' },
  { file: 'Python/Lecture/ch05_function.md', out: 'Python/Lecture/ch05_function.html', title: 'Ch05 函式設計與模組化', slideHtml: '../Slide/html/ch05s_function.html', slidePdf: '../Slide/pdf/ch05s_function.pdf' },
  { file: 'Python/Lecture/ch06_pandas.md', out: 'Python/Lecture/ch06_pandas.html', title: 'Ch06 資料處理分析 (Pandas)', slideHtml: '../Slide/html/ch06s_pandas.html', slidePdf: '../Slide/pdf/ch06s_pandas.pdf' },
  { file: 'Python/Lecture/ch07_OOP.md', out: 'Python/Lecture/ch07_OOP.html', title: 'Ch07 物件導向設計 (OOP)', slideHtml: '../Slide/html/ch07s_OOP.html', slidePdf: '../Slide/pdf/ch07s_OOP.pdf' },
  { file: 'Python/Lecture+/ch08_engineering.md', out: 'Python/Lecture+/ch08_engineering.html', title: 'Ch08 工程與資電應用實務', slideHtml: '../Slide/html/ch08s_engineering.html', slidePdf: '../Slide/pdf/ch08s_engineering.pdf' },
  { file: 'Python/Lecture+/ch09_machine_learning.md', out: 'Python/Lecture+/ch09_machine_learning.html', title: 'Ch09 機器學習入門實踐', slideHtml: '../Slide/html/ch09s_machine_learning.html', slidePdf: '../Slide/pdf/ch09s_machine_learning.pdf' },
  { file: 'Python/Lecture+/ch10_AI_LLM.md', out: 'Python/Lecture+/ch10_AI_LLM.html', title: 'Ch10 生成式 AI 與 LLM 應用', slideHtml: '../Slide/html/ch10s_AI_LLM.html', slidePdf: '../Slide/pdf/ch10s_AI_LLM.pdf' },
  { file: 'Python/Lecture+/ch11_game.md', out: 'Python/Lecture+/ch11_game.html', title: 'Ch11 Pygame 視窗遊戲設計', slideHtml: '../Slide/html/ch11s_game.html', slidePdf: '../Slide/pdf/ch11s_game.pdf' },
  { file: 'Python/Lecture+/ch12_web.md', out: 'Python/Lecture+/ch12_web.html', title: 'Ch12 Python Web 開發 (Flask)', slideHtml: '../Slide/html/ch12s_web.html', slidePdf: '../Slide/pdf/ch12s_web.pdf' },
];

function generateHtml(item, index) {
  const mdPath = path.resolve(process.cwd(), item.file);
  let mdContent = fs.readFileSync(mdPath, 'utf-8');

  // Fix image paths: in Lecture or Lecture+, images are located at ../img/
  // Replace references like img/ch01/ with ../img/ch01/ if not already starting with ../
  mdContent = mdContent.replace(/src=["'](?!\.\.\/)(img\/[^"']+)["']/g, 'src="../$1"');
  mdContent = mdContent.replace(/!\[(.*?)\]\((?!\.\.\/)(img\/[^\)]+)\)/g, '![$1](../$2)');

  const b64 = Buffer.from(mdContent, 'utf-8').toString('base64');

  const prevItem = index > 0 ? lectures[index - 1] : null;
  const nextItem = index < lectures.length - 1 ? lectures[index + 1] : null;

  // Relative path from the html file to Python portal index.html
  const isLecturePlus = item.out.includes('Lecture+');
  const portalUrl = isLecturePlus ? '../index.html' : '../index.html';

  // Build chapter options
  const chapterOptions = lectures.map(l => {
    // Relative link between html pages
    let link = '';
    if (isLecturePlus) {
      link = l.out.includes('Lecture+') ? path.basename(l.out) : `../Lecture/${path.basename(l.out)}`;
    } else {
      link = l.out.includes('Lecture+') ? `../Lecture+/${path.basename(l.out)}` : path.basename(l.out);
    }
    const selected = l.file === item.file ? 'selected' : '';
    return `<option value="${link}" ${selected}>${l.title}</option>`;
  }).join('\n          ');

  let prevBtnHtml = '';
  if (prevItem) {
    let pLink = isLecturePlus
      ? (prevItem.out.includes('Lecture+') ? path.basename(prevItem.out) : `../Lecture/${path.basename(prevItem.out)}`)
      : (prevItem.out.includes('Lecture+') ? `../Lecture+/${path.basename(prevItem.out)}` : path.basename(prevItem.out));
    prevBtnHtml = `<a href="${pLink}" class="btn-step"><span>←</span><span>${prevItem.title}</span></a>`;
  }

  let nextBtnHtml = '';
  if (nextItem) {
    let nLink = isLecturePlus
      ? (nextItem.out.includes('Lecture+') ? path.basename(nextItem.out) : `../Lecture/${path.basename(nextItem.out)}`)
      : (nextItem.out.includes('Lecture+') ? `../Lecture+/${path.basename(nextItem.out)}` : path.basename(nextItem.out));
    nextBtnHtml = `<a href="${nLink}" class="btn-step"><span>${nextItem.title}</span><span>→</span></a>`;
  }

  return `<!DOCTYPE html>
<html lang="zh-TW">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>${item.title} | Python 講義手冊</title>
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link
    href="https://fonts.googleapis.com/css2?family=Plus+Jakarta+Sans:wght@400;500;600;700;800&family=JetBrains+Mono:wght@400;500;600&family=Noto+Sans+TC:wght@400;500;700&display=swap"
    rel="stylesheet">

  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.9.0/styles/github.min.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/katex@0.16.9/dist/katex.min.css">

  <script src="https://cdn.jsdelivr.net/npm/marked/marked.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.9.0/highlight.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.9.0/languages/python.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.9.0/languages/bash.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.9.0/languages/json.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/mermaid@10/dist/mermaid.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/katex@0.16.9/dist/katex.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/katex@0.16.9/dist/contrib/auto-render.min.js"></script>

  <style>
    :root {
      --primary: #0284c7;
      --primary-dark: #0369a1;
      --primary-light: #e0f2fe;
      --accent: #f59e0b;
      --surface: #ffffff;
      --background: #f8fafc;
      --text-main: #0f172a;
      --text-muted: #64748b;
      --border: #e2e8f0;
      --radius: 12px;
      --shadow-sm: 0 1px 3px rgba(0, 0, 0, 0.05);
      --shadow-md: 0 4px 10px -1px rgba(2, 132, 199, 0.08);
    }

    body.dark-mode {
      --primary: #38bdf8;
      --primary-dark: #0284c7;
      --primary-light: #082f49;
      --accent: #fbbf24;
      --surface: #1e293b;
      --background: #0f172a;
      --text-main: #f1f5f9;
      --text-muted: #94a3b8;
      --border: #334155;
    }

    * { box-sizing: border-box; margin: 0; padding: 0; }

    body {
      font-family: 'Plus Jakarta Sans', 'Noto Sans TC', system-ui, -apple-system, sans-serif;
      background-color: var(--background);
      color: var(--text-main);
      line-height: 1.75;
      min-height: 100vh;
      display: flex;
      flex-direction: column;
      transition: background-color 0.2s ease, color 0.2s ease;
    }

    #progressBar {
      position: fixed;
      top: 0;
      left: 0;
      height: 3px;
      background: linear-gradient(90deg, #0284c7 0%, #f59e0b 100%);
      width: 0%;
      z-index: 9999;
      transition: width 0.1s ease-out;
    }

    .top-navbar {
      position: sticky;
      top: 0;
      z-index: 1000;
      background: rgba(255, 255, 255, 0.94);
      backdrop-filter: blur(12px);
      -webkit-backdrop-filter: blur(12px);
      border-bottom: 1px solid var(--border);
      padding: 10px 24px;
      display: flex;
      align-items: center;
      justify-content: space-between;
      gap: 16px;
      box-shadow: var(--shadow-sm);
    }

    body.dark-mode .top-navbar {
      background: rgba(30, 41, 59, 0.92);
    }

    .nav-left {
      display: flex;
      align-items: center;
      gap: 14px;
    }

    .btn-back {
      display: inline-flex;
      align-items: center;
      gap: 6px;
      color: var(--text-main);
      text-decoration: none;
      font-size: 13.5px;
      font-weight: 700;
      padding: 6px 12px;
      border-radius: 8px;
      background: #f1f5f9;
      transition: all 0.15s ease;
      white-space: nowrap;
    }

    body.dark-mode .btn-back { background: #334155; }
    .btn-back:hover { background: var(--primary-light); color: var(--primary-dark); }

    .chapter-select {
      padding: 6px 12px;
      border-radius: 8px;
      border: 1px solid var(--border);
      background: var(--surface);
      color: var(--text-main);
      font-family: inherit;
      font-size: 13.5px;
      font-weight: 600;
      outline: none;
      cursor: pointer;
      max-width: 280px;
    }

    .nav-right {
      display: flex;
      align-items: center;
      gap: 8px;
    }

    .btn-nav-action {
      display: inline-flex;
      align-items: center;
      gap: 5px;
      background: var(--surface);
      border: 1px solid var(--border);
      color: var(--text-muted);
      padding: 6px 12px;
      border-radius: 8px;
      font-size: 13px;
      font-weight: 600;
      text-decoration: none;
      cursor: pointer;
      transition: all 0.15s ease;
    }

    .btn-nav-action:hover {
      color: var(--primary);
      border-color: #93c5fd;
      background: var(--primary-light);
    }

    .layout-container {
      max-width: 1380px;
      width: 100%;
      margin: 0 auto;
      padding: 32px 24px 80px 24px;
      display: flex;
      gap: 36px;
      align-items: flex-start;
      flex: 1;
    }

    .document-body {
      flex: 1;
      min-width: 0;
      background: var(--surface);
      border-radius: var(--radius);
      border: 1px solid var(--border);
      padding: 44px 52px;
      box-shadow: var(--shadow-sm);
    }

    @media (max-width: 768px) {
      .document-body { padding: 24px 20px; }
    }

    .toc-sidebar {
      width: 290px;
      flex-shrink: 0;
      position: sticky;
      top: 75px;
      max-height: calc(100vh - 100px);
      overflow-y: auto;
      background: var(--surface);
      border: 1px solid var(--border);
      border-radius: var(--radius);
      padding: 20px;
      box-shadow: var(--shadow-sm);
    }

    @media (max-width: 1060px) {
      .toc-sidebar { display: none; }
    }

    .toc-title {
      font-size: 13px;
      font-weight: 700;
      text-transform: uppercase;
      letter-spacing: 0.5px;
      color: var(--text-muted);
      margin-bottom: 12px;
      display: flex;
      align-items: center;
      gap: 6px;
    }

    .toc-list {
      list-style: none;
      display: flex;
      flex-direction: column;
      gap: 4px;
    }

    .toc-item a {
      color: var(--text-muted);
      text-decoration: none;
      display: block;
      padding: 4px 8px;
      border-radius: 6px;
      transition: all 0.15s ease;
      white-space: nowrap;
      overflow: hidden;
      text-overflow: ellipsis;
      font-size: 13px;
    }

    .toc-item a:hover {
      color: var(--primary);
      background-color: var(--primary-light);
    }

    .toc-item.active a {
      color: var(--primary);
      font-weight: 700;
      background-color: var(--primary-light);
      border-left: 3px solid var(--primary);
    }

    .toc-level-3 { padding-left: 12px; font-size: 12.5px; }
    .toc-level-4 { padding-left: 20px; font-size: 12px; }

    #contentArea h1 {
      font-size: 2.1rem;
      font-weight: 800;
      color: var(--text-main);
      margin-bottom: 24px;
      padding-bottom: 14px;
      border-bottom: 2px solid var(--border);
      line-height: 1.3;
    }

    #contentArea h2 {
      font-size: 1.55rem;
      font-weight: 700;
      color: var(--text-main);
      margin-top: 42px;
      margin-bottom: 16px;
      padding-bottom: 8px;
      border-bottom: 1px solid var(--border);
    }

    #contentArea h3 {
      font-size: 1.25rem;
      font-weight: 700;
      color: var(--text-main);
      margin-top: 28px;
      margin-bottom: 12px;
    }

    #contentArea p {
      margin-bottom: 16px;
      font-size: 15.5px;
    }

    #contentArea ul, #contentArea ol {
      margin-bottom: 18px;
      padding-left: 26px;
      font-size: 15.5px;
    }

    #contentArea li { margin-bottom: 7px; }

    #contentArea blockquote {
      border-left: 4px solid var(--primary);
      background: var(--primary-light);
      padding: 14px 20px;
      border-radius: 0 10px 10px 0;
      margin: 20px 0;
      font-size: 15px;
    }

    #contentArea table {
      width: 100%;
      border-collapse: collapse;
      margin: 24px 0;
      font-size: 14px;
    }

    #contentArea th, #contentArea td {
      border: 1px solid var(--border);
      padding: 10px 14px;
      text-align: left;
    }

    #contentArea th {
      background: #f1f5f9;
      font-weight: 700;
    }

    body.dark-mode #contentArea th { background: #334155; }

    #contentArea img {
      max-width: 100%;
      height: auto;
      border-radius: 8px;
      border: 1px solid var(--border);
      margin: 18px 0;
      display: block;
      box-shadow: var(--shadow-sm);
    }

    .code-wrapper {
      margin: 20px 0;
      border: 1px solid var(--border);
      border-radius: 10px;
      overflow: hidden;
      background: #f8fafc;
    }

    body.dark-mode .code-wrapper { background: #0f172a; }

    .code-header {
      display: flex;
      justify-content: space-between;
      align-items: center;
      padding: 6px 14px;
      background: #e2e8f0;
      color: #475569;
      font-size: 12px;
      font-family: 'JetBrains Mono', monospace;
      font-weight: 600;
    }

    body.dark-mode .code-header { background: #1e293b; color: #94a3b8; }

    .btn-copy {
      background: white;
      border: 1px solid var(--border);
      border-radius: 5px;
      padding: 3px 8px;
      font-size: 11.5px;
      cursor: pointer;
      font-weight: 600;
    }

    body.dark-mode .btn-copy { background: #334155; color: #f1f5f9; }

    #contentArea pre {
      margin: 0;
      padding: 16px;
      overflow-x: auto;
      font-family: 'JetBrains Mono', monospace;
      font-size: 13.5px;
      line-height: 1.55;
    }

    #contentArea code:not(pre code) {
      font-family: 'JetBrains Mono', monospace;
      background: #f1f5f9;
      color: #0369a1;
      padding: 2px 6px;
      border-radius: 4px;
      font-size: 0.9em;
      border: 1px solid #e2e8f0;
    }

    body.dark-mode #contentArea code:not(pre code) {
      background: #334155;
      color: #38bdf8;
      border-color: #475569;
    }

    .bottom-nav {
      display: flex;
      justify-content: space-between;
      gap: 16px;
      margin-top: 50px;
      padding-top: 24px;
      border-top: 1px solid var(--border);
    }

    .btn-step {
      display: inline-flex;
      align-items: center;
      gap: 8px;
      padding: 10px 18px;
      border-radius: 8px;
      background: var(--surface);
      border: 1px solid var(--border);
      color: var(--text-main);
      text-decoration: none;
      font-weight: 600;
      font-size: 14px;
      transition: all 0.15s ease;
    }

    .btn-step:hover {
      background: var(--primary-light);
      border-color: var(--primary);
      color: var(--primary-dark);
    }
  </style>
</head>

<body>

  <div id="progressBar"></div>

  <header class="top-navbar">
    <div class="nav-left">
      <a href="${portalUrl}" class="btn-back">
        <span>←</span>
        <span>Python 門戶</span>
      </a>

      <select class="chapter-select" onchange="location.href=this.value">
        ${chapterOptions}
      </select>
    </div>

    <div class="nav-right">
      <button class="btn-nav-action" onclick="toggleDarkMode()" title="切換深淺模式">
        <span id="darkIcon">🌙</span>
      </button>
    </div>
  </header>

  <main class="layout-container">
    <article class="document-body">
      <div id="contentArea"></div>

      <nav class="bottom-nav">
        ${prevBtnHtml}
        <div style="flex:1"></div>
        ${nextBtnHtml}
      </nav>
    </article>

    <aside class="toc-sidebar" id="tocSidebar">
      <div class="toc-title">
        <span>📑</span>
        <span>本講義目錄</span>
      </div>
      <ul class="toc-list" id="tocList"></ul>
    </aside>
  </main>

  <script>
    // Embedded Base64 Markdown Content (Zero fetch, 100% reliable)
    const b64Data = "${b64}";
    const binStr = atob(b64Data);
    const bytes = new Uint8Array(binStr.length);
    for (let i = 0; i < binStr.length; i++) {
      bytes[i] = binStr.charCodeAt(i);
    }
    const rawMarkdown = new TextDecoder('utf-8').decode(bytes);

    // Render immediately
    marked.setOptions({
      highlight: function(code, lang) {
        if (lang && hljs.getLanguage(lang)) {
          return hljs.highlight(code, { language: lang }).value;
        }
        return hljs.highlightAuto(code).value;
      },
      breaks: true,
      gfm: true
    });

    const contentArea = document.getElementById('contentArea');
    contentArea.innerHTML = marked.parse(rawMarkdown);

    // Build Table of Contents
    const tocList = document.getElementById('tocList');
    const headings = contentArea.querySelectorAll('h2, h3, h4');
    if (headings.length === 0) {
      document.getElementById('tocSidebar').style.display = 'none';
    } else {
      headings.forEach((heading, index) => {
        let id = heading.id;
        if (!id) {
          id = 'heading-' + index + '-' + heading.textContent.toLowerCase().replace(/[^a-z0-9\\u4e00-\\u9fa5]+/g, '-');
          heading.id = id;
        }

        const li = document.createElement('li');
        li.className = 'toc-item toc-level-' + heading.tagName.toLowerCase().charAt(1);
        li.dataset.targetId = id;

        const a = document.createElement('a');
        a.href = '#' + id;
        a.textContent = heading.textContent.trim();
        a.addEventListener('click', (e) => {
          e.preventDefault();
          document.getElementById(id).scrollIntoView({ behavior: 'smooth' });
          history.pushState(null, null, '#' + id);
        });

        li.appendChild(a);
        tocList.appendChild(li);
      });

      const observer = new IntersectionObserver((entries) => {
        entries.forEach(entry => {
          if (entry.isIntersecting) {
            const id = entry.target.id;
            tocList.querySelectorAll('.toc-item').forEach(item => {
              item.classList.toggle('active', item.dataset.targetId === id);
            });
          }
        });
      }, { rootMargin: '-80px 0px -75% 0px' });

      headings.forEach(h => observer.observe(h));
    }

    // Enhance Code Blocks with Copy Buttons
    document.querySelectorAll('#contentArea pre').forEach(pre => {
      const code = pre.querySelector('code');
      if (!code) return;

      let lang = 'CODE';
      const classes = code.className.split(' ');
      for (let c of classes) {
        if (c.startsWith('language-')) {
          lang = c.replace('language-', '').toUpperCase();
          break;
        }
      }

      const wrapper = document.createElement('div');
      wrapper.className = 'code-wrapper';

      const header = document.createElement('div');
      header.className = 'code-header';
      header.innerHTML = '<span>' + lang + '</span>';

      const copyBtn = document.createElement('button');
      copyBtn.className = 'btn-copy';
      copyBtn.textContent = '📋 複製程式碼';
      copyBtn.addEventListener('click', () => {
        navigator.clipboard.writeText(code.innerText).then(() => {
          copyBtn.textContent = '✅ 已複製！';
          setTimeout(() => { copyBtn.textContent = '📋 複製程式碼'; }, 2000);
        });
      });

      header.appendChild(copyBtn);
      pre.parentNode.insertBefore(wrapper, pre);
      wrapper.appendChild(header);
      wrapper.appendChild(pre);
    });

    // Mermaid & KaTeX
    mermaid.initialize({ startOnLoad: false, theme: document.body.classList.contains('dark-mode') ? 'dark' : 'default' });
    document.querySelectorAll('#contentArea .language-mermaid').forEach(async (el) => {
      const graphDefinition = el.innerText;
      const container = document.createElement('div');
      container.className = 'mermaid';
      container.innerHTML = graphDefinition;
      el.parentNode.replaceChild(container, el);
    });
    mermaid.run();

    if (window.renderMathInElement) {
      renderMathInElement(contentArea, {
        delimiters: [
          { left: '$$', right: '$$', display: true },
          { left: '$', right: '$', display: false }
        ],
        throwOnError: false
      });
    }

    // Scroll Progress Bar
    window.addEventListener('scroll', () => {
      const scrollTop = window.scrollY || document.documentElement.scrollTop;
      const docHeight = document.documentElement.scrollHeight - document.documentElement.clientHeight;
      const progress = docHeight > 0 ? (scrollTop / docHeight) * 100 : 0;
      document.getElementById('progressBar').style.width = progress + '%';
    });

    // Dark Mode Toggle
    function toggleDarkMode() {
      document.body.classList.toggle('dark-mode');
      const isDark = document.body.classList.contains('dark-mode');
      document.getElementById('darkIcon').textContent = isDark ? '☀️' : '🌙';
      localStorage.setItem('teach_python_dark', isDark ? 'true' : 'false');
    }

    if (localStorage.getItem('teach_python_dark') === 'true') {
      document.body.classList.add('dark-mode');
      document.getElementById('darkIcon').textContent = '☀️';
    }
  </script>

</body>

</html>`;
}

lectures.forEach((item, index) => {
  const html = generateHtml(item, index);
  const outPath = path.resolve(process.cwd(), item.out);
  fs.writeFileSync(outPath, html, 'utf-8');
  console.log(`Generated HTML lecture: ${item.out}`);
});

console.log('All 12 lecture HTML pages generated successfully!');
