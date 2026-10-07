#!/usr/bin/env node

/**
 * Common Lecture Markdown to PDF Generator for gTeach Courses
 * Usage:
 *   node generate_lecture_pdf.js <input-markdown-file> [output-pdf-file]
 */

const fs = require('fs');
const path = require('path');
const os = require('os');
const http = require('http');
const { spawn } = require('child_process');

const inputFile = process.argv[2];
if (!inputFile) {
  console.log(`
Usage:
  node generate_lecture_pdf.js <input-markdown-file> [output-pdf-file]

Examples:
  node scripts/generate_lecture_pdf.js Lecture/source/ch01e_intro.md
  node ../scripts/generate_lecture_pdf.js Lecture/source/ch01e_intro.md
`);
  process.exit(1);
}

const inputAbsPath = path.resolve(process.cwd(), inputFile);
if (!fs.existsSync(inputAbsPath)) {
  console.error(`Error: File not found: ${inputAbsPath}`);
  process.exit(1);
}

const fileDir = path.dirname(inputAbsPath);
const baseName = path.basename(inputAbsPath, path.extname(inputAbsPath));

// Smart resolution for output PDF path
let outputPdfPath = process.argv[3];
if (outputPdfPath) {
  outputPdfPath = path.resolve(process.cwd(), outputPdfPath);
} else {
  const parentDir = path.dirname(fileDir);
  const siblingPdfDir = path.join(parentDir, 'pdf');
  const innerPdfDir = path.join(fileDir, 'pdf');

  if (path.basename(fileDir).toLowerCase() === 'source') {
    if (!fs.existsSync(siblingPdfDir)) {
      fs.mkdirSync(siblingPdfDir, { recursive: true });
    }
    outputPdfPath = path.join(siblingPdfDir, `${baseName}.pdf`);
  } else if (fs.existsSync(innerPdfDir)) {
    outputPdfPath = path.join(innerPdfDir, `${baseName}.pdf`);
  } else {
    outputPdfPath = path.join(fileDir, `${baseName}.pdf`);
  }
}

const outDir = path.dirname(outputPdfPath);
if (!fs.existsSync(outDir)) {
  fs.mkdirSync(outDir, { recursive: true });
}

// Read markdown content
let mdContent = fs.readFileSync(inputAbsPath, 'utf8');

// Ensure image paths in markdown resolve correctly when loaded by Headless Chrome
mdContent = mdContent.replace(/src\s*=\s*["']?(\.\.?\/[^"'>\s]+)["']?/g, (match, relPath) => {
  const absImgPath = path.resolve(fileDir, relPath);
  return `src="file://${absImgPath}"`;
});
mdContent = mdContent.replace(/!\[(.*?)\]\((\.\.?\/[^\)]+)\)/g, (match, alt, relPath) => {
  const absImgPath = path.resolve(fileDir, relPath);
  return `![${alt}](file://${absImgPath})`;
});

// HTML template with modern GitHub-style documentation styling
const htmlContent = `<!DOCTYPE html>
<html lang="zh-TW">
<head>
  <meta charset="UTF-8">
  <title>${baseName}</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/github-markdown-css/5.5.1/github-markdown-light.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.9.0/styles/github.min.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/katex@0.16.10/dist/katex.min.css">
  <script src="https://cdn.jsdelivr.net/npm/marked/marked.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.9.0/highlight.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/katex@0.16.10/dist/katex.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/katex@0.16.10/dist/contrib/auto-render.min.js"></script>
  <style>
    body {
      box-sizing: border-box;
      min-width: 200px;
      max-width: 860px;
      margin: 0 auto;
      padding: 24px;
      font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", "Noto Sans TC", "Noto Sans", Helvetica, Arial, sans-serif;
      font-size: 14.5px;
      line-height: 1.65;
      color: #24292f;
      background-color: #ffffff;
      -webkit-print-color-adjust: exact !important;
      print-color-adjust: exact !important;
    }
    .markdown-body {
      font-size: 14.5px;
    }
    .markdown-body h1 {
      font-size: 2em;
      border-bottom: 2px solid #0969da;
      padding-bottom: 0.3em;
      margin-top: 0;
      color: #1f2328;
    }
    .markdown-body h2 {
      font-size: 1.45em;
      border-bottom: 1px solid #d0d7de;
      padding-bottom: 0.3em;
      margin-top: 1.8em;
      color: #1f2328;
      page-break-after: avoid;
    }
    .markdown-body h3 {
      font-size: 1.2em;
      margin-top: 1.4em;
      color: #24292f;
      page-break-after: avoid;
    }
    .markdown-body blockquote {
      border-left: 4px solid #0969da;
      background: #f6f8fa;
      padding: 10px 16px;
      border-radius: 0 8px 8px 0;
      color: #333;
      page-break-inside: avoid;
    }
    .markdown-body pre {
      background-color: #f6f8fa;
      border-radius: 8px;
      border: 1px solid #e1e4e8;
      padding: 14px;
      font-size: 13px;
      page-break-inside: avoid;
    }
    .markdown-body table {
      border-collapse: collapse;
      width: 100%;
      margin: 16px 0;
      page-break-inside: avoid;
    }
    .markdown-body table th {
      background-color: #f0f4f8;
      font-weight: 600;
      text-align: left;
      padding: 8px 12px;
      border: 1px solid #d0d7de;
    }
    .markdown-body table td {
      padding: 8px 12px;
      border: 1px solid #d0d7de;
    }
    .markdown-body table tr:nth-child(2n) {
      background-color: #f9fafb;
    }
    .markdown-body img {
      max-width: 100%;
      border-radius: 6px;
      margin: 12px auto;
      display: block;
      box-shadow: 0 2px 8px rgba(0,0,0,0.08);
      page-break-inside: avoid;
    }
    .katex {
      font-size: 1.05em;
    }
    a {
      color: #0969da;
      text-decoration: underline;
      text-decoration-thickness: 1px;
      text-underline-offset: 2px;
    }
    a:hover {
      color: #0550ae;
    }
    hr {
      margin: 28px 0;
      border: 0;
      border-top: 1px solid #e1e4e8;
    }
  </style>
</head>
<body class="markdown-body">
  <div id="content"></div>
  <script>
    const b64Data = "${Buffer.from(mdContent).toString('base64')}";
    const binStr = atob(b64Data);
    const bytes = new Uint8Array(binStr.length);
    for (let i = 0; i < binStr.length; i++) {
      bytes[i] = binStr.charCodeAt(i);
    }
    const rawMarkdown = new TextDecoder('utf-8').decode(bytes);

    marked.setOptions({
      highlight: function(code, lang) {
        if (lang && hljs.getLanguage(lang)) {
          return hljs.highlight(code, { language: lang }).value;
        }
        return hljs.highlightAuto(code).value;
      },
      gfm: true,
      breaks: false
    });
    document.getElementById('content').innerHTML = marked.parse(rawMarkdown);

    renderMathInElement(document.body, {
      delimiters: [
        {left: '$$', right: '$$', display: true},
        {left: '$', right: '$', display: false}
      ],
      throwOnError: false
    });
  </script>
</body>
</html>
`;

// Save temporary HTML file in system temp dir
const tempHtmlPath = path.join(os.tmpdir(), `lecture_preview_${Date.now()}_${process.pid}.html`);
fs.writeFileSync(tempHtmlPath, htmlContent, 'utf8');

console.log(`Converting ${inputFile} -> ${outputPdfPath}...`);

const chromePath = '/Applications/Google Chrome.app/Contents/MacOS/Google Chrome';
if (!fs.existsSync(chromePath)) {
  console.error(`Error: Chrome executable not found at: ${chromePath}`);
  process.exit(1);
}

// Generate PDF via Chrome DevTools Protocol with bottom-right page numbers
async function printPdfWithPageNumbers() {
  const port = 9300 + Math.floor(Math.random() * 500);
  const chromeProc = spawn(chromePath, [
    '--headless=new',
    '--disable-gpu',
    `--remote-debugging-port=${port}`,
    '--no-first-run',
    '--no-default-browser-check',
    'about:blank'
  ]);

  // Wait for Chrome remote debugging port to start
  await new Promise(r => setTimeout(r, 1000));

  return new Promise((resolve, reject) => {
    http.get(`http://127.0.0.1:${port}/json/list`, (res) => {
      let data = '';
      res.on('data', chunk => data += chunk);
      res.on('end', async () => {
        try {
          const tabs = JSON.parse(data);
          const pageTab = tabs.find(t => t.type === 'page') || tabs[0];
          if (!pageTab || !pageTab.webSocketDebuggerUrl) {
            throw new Error('Could not find active Chrome tab debugger URL');
          }

          const ws = new WebSocket(pageTab.webSocketDebuggerUrl);

          ws.onopen = () => {
            let reqId = 1;
            function send(method, params) {
              return new Promise((resFn, rejFn) => {
                const curId = reqId++;
                function handler(event) {
                  const msg = JSON.parse(event.data);
                  if (msg.id === curId) {
                    ws.removeEventListener('message', handler);
                    if (msg.error) rejFn(msg.error);
                    else resFn(msg.result);
                  }
                }
                ws.addEventListener('message', handler);
                ws.send(JSON.stringify({ id: curId, method, params }));
              });
            }

            (async () => {
              try {
                await send('Page.enable', {});
                
                // Wait for page load event
                const loadPromise = new Promise(resolve => {
                  function loadHandler(event) {
                    const msg = JSON.parse(event.data);
                    if (msg.method === 'Page.loadEventFired') {
                      ws.removeEventListener('message', loadHandler);
                      resolve();
                    }
                  }
                  ws.addEventListener('message', loadHandler);
                });

                await send('Page.navigate', { url: `file://${tempHtmlPath}` });
                await Promise.race([loadPromise, new Promise(r => setTimeout(r, 3000))]);
                
                // Additional delay to ensure KaTeX, marked, and local images finish layout
                await new Promise(r => setTimeout(r, 1800));

                // Extract title
                const h1Match = mdContent.match(/^#\s+(.+)$/m);
                const rawTitle = h1Match ? h1Match[1].trim() : baseName;
                let chapterHeader = rawTitle;
                const chNumMatch = baseName.match(/^ch(\d+)([a-z]*)/i);
                if (chNumMatch) {
                  const cleanTitle = rawTitle.replace(/^ch\s*\d+[a-z]*\s*[:·\-—]?\s*/i, '');
                  chapterHeader = `Ch ${chNumMatch[1]} · ${cleanTitle}`;
                }

                const result = await send('Page.printToPDF', {
                  displayHeaderFooter: true,
                  headerTemplate: '<div></div>',
                  footerTemplate: `<div style="font-size: 8.5px; width: 100%; display: flex; justify-content: space-between; align-items: center; box-sizing: border-box; padding-left: 16mm; padding-right: 16mm; margin-bottom: 3mm; color: #8c959f; font-family: -apple-system, BlinkMacSystemFont, 'PingFang TC', 'Noto Sans TC', 'Heiti TC', 'Microsoft JhengHei', 'Segoe UI', sans-serif;"><span style="overflow: hidden; text-overflow: ellipsis; white-space: nowrap; max-width: 75%;">${chapterHeader}</span><span><span class="pageNumber"></span> / <span class="totalPages"></span></span></div>`,
                  marginTop: 0.7,
                  marginBottom: 0.8,
                  marginLeft: 0.6,
                  marginRight: 0.6,
                  printBackground: true,
                  paperWidth: 8.27,
                  paperHeight: 11.69,
                  generateTaggedPDF: true,
                  generateDocumentOutline: true
                });

                if (result && result.data) {
                  fs.writeFileSync(outputPdfPath, Buffer.from(result.data, 'base64'));
                  
                  // Post-process with PyMuPDF to inject clickable internal and external links
                  const enrichScriptPath = path.join(__dirname, 'add_pdf_links.py');
                  if (fs.existsSync(enrichScriptPath)) {
                    const { execSync } = require('child_process');
                    try {
                      execSync(`python3 "${enrichScriptPath}" "${inputAbsPath}" "${outputPdfPath}"`, { stdio: 'inherit' });
                    } catch (e) {
                      console.warn('Note: Link post-processor message:', e.message);
                    }
                  }

                  console.log(` Successfully generated PDF with page numbers & clickable links: ${outputPdfPath}`);
                  resolve();
                } else {
                  throw new Error('No PDF data returned from Chrome');
                }
              } catch (err) {
                reject(err);
              } finally {
                try { ws.close(); } catch (_) {}
                try { chromeProc.kill(); } catch (_) {}
              }
            })();
          };

          ws.onerror = (err) => {
            try { chromeProc.kill(); } catch (_) {}
            reject(err);
          };
        } catch (err) {
          try { chromeProc.kill(); } catch (_) {}
          reject(err);
        }
      });
    }).on('error', (err) => {
      try { chromeProc.kill(); } catch (_) {}
      reject(err);
    });
  });
}

(async () => {
  try {
    await printPdfWithPageNumbers();
  } catch (err) {
    console.error('Failed to generate PDF:', err.message || err);
  } finally {
    if (fs.existsSync(tempHtmlPath)) {
      try { fs.unlinkSync(tempHtmlPath); } catch (_) {}
    }
  }
})();
