#!/usr/bin/env python3
"""
sync_iActivity.py - Automated Interactive Activities Extraction, nickedupocket Synchronization & Reverse Sync Tool

Features:
1. Bidirectional Sync:
   - Reverse Sync: Chapters named "Chapter Xnn" (e.g. Chapter X01, Chapter X02) authored in nickedupocket
     are reverse-synced into course lecture files (<course>/Lecture/chxXX.md or <course>/Lecture/source/chxXX.md).
     Directly embeds [課堂互動] link and QR Code image into Chapter Xnn lecture notes!
   - Forward Sync: Extracts Interactive Activities (CCQ, Poll, Game, WordCloud, Ordering, Pair, Survey, Short QA)
     from Lecture notes and Lab/Docs markdown files into nickedupocket course files.
   - Non-destructive Update: Chapters in nickedupocket that don't have local lecture files (e.g. test suites) are preserved.
2. Supports single-question and multi-question activities (e.g. multi-round Game challenges, multi-question Surveys).
3. Generates student QR code PNG images under <Course>/img/chXX/, <Course>/img/chX{num}/, or <Course>/img/uXX/.
4. Auto-embeds unique HTML comment IDs (<!-- id: ... -->) and [課堂互動] links into Lecture & Lab/Docs markdowns (plus QR code images for Chapter Xnn).
5. Auto-embeds unique HTML comment IDs (<!-- id: ... -->), [課堂互動] links, and QR code images into Slide markdowns.
6. Automatically detects changes in nickedupocket course files and performs git commit & push.
"""

import os
import sys
import glob
import re
import subprocess
import argparse
from pathlib import Path

try:
    import qrcode
    QR_AVAILABLE = True
except ImportError:
    QR_AVAILABLE = False

COURSE_MAPPING = {
    'gteachsqa': {
        'title': 'Software Testing & Quality Assurance (軟體品質與測試)',
        'slug': 'sqa',
        'output_file': 'gTeachSQA.md',
    },
    'sqa': {
        'title': 'Software Testing & Quality Assurance (軟體品質與測試)',
        'slug': 'sqa',
        'output_file': 'gTeachSQA.md',
    },
    'gteachase': {
        'title': 'Advanced Software Engineering (進階軟體工程)',
        'slug': 'ase',
        'output_file': 'gTeachASE.md',
    },
    'ase': {
        'title': 'Advanced Software Engineering (進階軟體工程)',
        'slug': 'ase',
        'output_file': 'gTeachASE.md',
    },
    'se': {
        'title': 'Advanced Software Engineering (進階軟體工程)',
        'slug': 'ase',
        'output_file': 'gTeachASE.md',
    },
    'gteachpython': {
        'title': 'Python Programming (Python 程式設計)',
        'slug': 'python',
        'output_file': 'gTeachPython.md',
    },
    'python': {
        'title': 'Python Programming (Python 程式設計)',
        'slug': 'python',
        'output_file': 'gTeachPython.md',
    },
    'gteachux': {
        'title': 'User Experience Design & AI (使用者體驗設計與 AI)',
        'slug': 'ux',
        'output_file': 'gTeachUX.md',
    },
    'ux': {
        'title': 'User Experience Design & AI (使用者體驗設計與 AI)',
        'slug': 'ux',
        'output_file': 'gTeachUX.md',
    },
    'gjusttest': {
        'title': 'JustTest 互動題型完整測試課程 (Interactive Test Suite)',
        'slug': 'test',
        'output_file': 'gJustTest.md',
    },
}

FOLDER_ALIASES = {
    'sqa': ['SQA', 'gTeachSQA'],
    'gteachsqa': ['SQA', 'gTeachSQA'],
    'ux': ['UX', 'gTeachUX'],
    'gteachux': ['UX', 'gTeachUX'],
    'ase': ['SE', 'ASE', 'gTeachASE'],
    'se': ['SE', 'ASE', 'gTeachASE'],
    'gteachase': ['SE', 'ASE', 'gTeachASE'],
    'python': ['Python', 'gTeachPython'],
    'gteachpython': ['Python', 'gTeachPython'],
    'gjusttest': ['gJustTest'],
}

BASE_STUDENT_URL = 'https://nlhsueh.github.io/nickedupocket/#/student/'

INTERACTIVE_PATTERN = r'(?:[🙋❓🎯📊⚡☁️🔢💬💡📱🎮🏆⏱️]\s*(?:\**\[?(?:CCQ|Poll|Survey|Game|Ordering|QA|Short|WordCloud|Pair|Discussion|PairDiscussion|Pair-Discussion|投票|問卷|問卷調查|搶答|文字雲|排序|簡答|觀念檢核|概念核對問答|課堂遊戲|雙人討論|分組討論|小組討論|隨堂測驗)[^\]\n]*\]?\**)?|\[(?:CCQ|Poll|Survey|Game|Ordering|QA|Short|WordCloud|Pair|Discussion|投票|問卷|問卷調查|搶答|文字雲|排序|簡答|觀念檢核|概念核對問答|課堂遊戲|雙人討論|分組討論|隨堂測驗)\]|【(?:是非題|單選題|多選題|問答題|投票|問卷|問卷調查|搶答|文字雲|排序|簡答|課堂遊戲|雙人討論|分組討論|隨堂測驗)】|(?:\([^\)]*CCQ[^\)]*\))|隨堂測驗)'
CCQ_REGEX = re.compile(
    r'((?:<!--\s*id:\s*[^\s>]+\s*-->\s*\n)?)(#{2,4}\s*[^\n]*?' + INTERACTIVE_PATTERN + r'[^\n]*?\n)(.*?)(?=\n<!--\s*id:|\n#{1,4}\s*[🙋❓]|\n#{1,3}\s|\Z)',
    re.DOTALL | re.IGNORECASE
)

def clean_question_text(raw_text: str) -> str:
    """Cleans question text by stripping prefix tags, emojis, and formatting."""
    text = raw_text.strip()
    text = re.sub(r'^[🙋🎯📊⚡☁️🔢💬💡❓📱🎮🏆⏱️]\s*', '', text)
    text = re.sub(r'^【(?:是非題|單選題|多選題|問答題|投票|問卷|問卷調查|搶答|文字雲|排序|簡答|課堂遊戲|雙人討論|分組討論)】\s*', '', text)
    text = re.sub(r'^(?:\*\s*)?\*\*(?:是非題|單選題|多選題|問答題|投票|問卷|問卷調查|搶答|文字雲|排序|簡答|課堂遊戲|雙人討論|分組討論)\*\*[：:]\s*', '', text)
    text = re.sub(r'^\*\*(?:問題|互動提問|Question)\*\*[：:]?\s*', '', text, flags=re.IGNORECASE)
    text = re.sub(r'^(?:問題|互動提問|Question)[：:]\s*', '', text, flags=re.IGNORECASE)
    return text.strip()

def parse_single_question_block(block_text: str, default_type: str = 'ccq') -> dict:
    """Parses a single question block (options, answers, explanation, question text)."""
    details_match = re.search(r'<details>(.*?)</details>', block_text, re.DOTALL)
    correct_ans = ''
    explanation = ''
    if details_match:
        details_content = details_match.group(1)
        ans_match = re.search(r'(?:正確答案|標準答案|Correct\s*Answer)\**[：:]\s*[*]*([A-Za-z0-9\(\)\s（）正確錯誤TrueFalseOX]+)[*]*', details_content, re.IGNORECASE)
        if ans_match:
            raw_ans = ans_match.group(1).strip()
            if 'A' in raw_ans: correct_ans = 'A'
            elif 'B' in raw_ans: correct_ans = 'B'
            elif 'C' in raw_ans: correct_ans = 'C'
            elif 'D' in raw_ans: correct_ans = 'D'
            elif 'E' in raw_ans: correct_ans = 'E'
            elif any(k in raw_ans for k in ['正確', 'True', 'O', 'o']): correct_ans = 'A'
            elif any(k in raw_ans for k in ['錯誤', 'False', 'X', 'x']): correct_ans = 'B'

        exp_match = re.search(r'(?:詳細)?(?:解析|說明|Explanation)\**[：:]\s*(.+)', details_content, re.DOTALL | re.IGNORECASE)
        if exp_match:
            explanation = exp_match.group(1).strip()

    q_body = re.sub(r'<details>.*?</details>', '', block_text, flags=re.DOTALL)
    q_body = re.sub(r'\[(?:線上作答|課堂互動|Online Answer|Interactive Activity[^\n\]]*|Interactive[^\n\]]*)\](?:\([^\)]*\))?\s*', '', q_body, flags=re.IGNORECASE)
    q_body = re.sub(r'\[[^\]\n]*\]\(https?://[^\s\)]*nickedupocket[^\s\)]*\)\s*', '', q_body)
    q_body = re.sub(r'\(https?://[^\s\)]*nickedupocket[^\s\)]*\)\s*', '', q_body)
    q_body = re.sub(r'!\[.*?\]\(.*?\)\s*', '', q_body)
    q_body = re.sub(r'<img\s+src=[\'"][^\'"]*?[\'"][^>]*?>\s*', '', q_body, flags=re.IGNORECASE)
    q_body = re.sub(r'<!--.*?-->\s*', '', q_body)

    lines = [l.strip() for l in q_body.split('\n') if l.strip()]
    question_lines = []
    options = []
    ordering_items = []

    for line in lines:
        # Option pattern: A) / A. / - A) / - A.
        opt_match = re.match(r'^(?:[-*]\s*)?([A-Za-z0-9]+)[\.\)]\s*(.+)$', line)
        if opt_match:
            key = opt_match.group(1)
            text = opt_match.group(2).strip()
            is_correct = (key == correct_ans)
            options.append((key, text, is_correct))
            continue

        # Numbered item pattern (for ordering): 1. / 1)
        num_match = re.match(r'^\d+[\.\)]\s*(.+)$', line)
        if num_match and default_type == 'ordering':
            ordering_items.append(num_match.group(1).strip())
            continue

        # Question text lines
        if not options and not ordering_items:
            clean_l = clean_question_text(line)
            if clean_l and not clean_l.startswith('---'):
                question_lines.append(clean_l)

    if default_type == 'ordering' and not ordering_items and options:
        ordering_items = [opt[1] for opt in options]

    question_text = ' '.join(question_lines).strip()
    return {
        'question': question_text,
        'type': default_type,
        'options': options,
        'ordering_items': ordering_items,
        'correct_answer': correct_ans,
        'explanation': explanation
    }

def extract_appendix_answers(content: str) -> dict:
    """Extracts reference answers and explanations from an Appendix/附錄 section at the bottom of a lecture file."""
    app_answers = {}
    app_match = re.search(r'##\s*📚?\s*(?:附錄|Appendix)[^\n]*\n(.*)', content, re.DOTALL | re.IGNORECASE)
    if not app_match:
        return app_answers

    app_text = app_match.group(1)

    # 1. Match <details> blocks containing answers (e.g. gTeachSQA Ch01, gTeachASE Ch01)
    for det_m in re.finditer(r'<details>(.*?)</details>', app_text, re.DOTALL):
        det_content = det_m.group(1)
        num_m = re.search(r'(?:CCQ|Concept\s*Check)\s*([A-Za-z0-9]+)', det_content, re.IGNORECASE)
        ans_m = re.search(r'正確答案\**[：:]\s*[*]*([A-Za-z0-9]+)[*]*', det_content)
        if not ans_m:
            ans_m = re.search(r'Correct\s*Answer\**[：:]\s*[*]*([A-Za-z0-9]+)[*]*', det_content, re.IGNORECASE)
        exp_m = re.search(r'(?:詳細)?解析\**[：:]\s*(.+)', det_content, re.DOTALL)
        if not exp_m:
            exp_m = re.search(r'(?:Detailed\s+)?Explanation\**[：:]\s*(.+)', det_content, re.DOTALL | re.IGNORECASE)

        if num_m and ans_m:
            num_key = num_m.group(1).lower()
            ans = ans_m.group(1).strip().upper()
            exp = exp_m.group(1).strip() if exp_m else ''
            app_answers[f'ccq_{num_key}'] = {'correct_answer': ans, 'explanation': exp}

    # 2. Match ### CCQ ([A-Za-z0-9]+) blocks (e.g. gTeachASE Ch01)
    for sec_m in re.finditer(r'###\s*(?:CCQ|Concept\s*Check)\s*([A-Za-z0-9]+)[^\n]*\n(.*?)(?=\n###|\n---|\Z)', app_text, re.DOTALL | re.IGNORECASE):
        num_key = sec_m.group(1).lower()
        sec_content = sec_m.group(2)
        ans_m = re.search(r'正確答案\**[：:]\s*[*]*([A-Za-z0-9]+)[*]*', sec_content)
        if not ans_m:
            ans_m = re.search(r'Correct\s*Answer\**[：:]\s*[*]*([A-Za-z0-9]+)[*]*', sec_content, re.IGNORECASE)
        exp_m = re.search(r'(?:詳細)?(?:解析|說明)\**[：:]\s*(.+?)(?=\n\*|\n\[|\n<|\Z)', sec_content, re.DOTALL)
        if not exp_m:
            exp_m = re.search(r'(?:Detailed\s+)?Explanation\**[：:]\s*(.+?)(?=\n\*|\n\[|\n<|\Z)', sec_content, re.DOTALL | re.IGNORECASE)

        if ans_m:
            ans = ans_m.group(1).strip().upper()
            exp = exp_m.group(1).strip() if exp_m else ''
            app_answers[f'ccq_{num_key}'] = {'correct_answer': ans, 'explanation': exp}

    return app_answers

def parse_lecture_ccqs(fpath: str, course_slug: str):
    """Parses all interactive questions from a lecture or doc markdown file."""
    basename = os.path.basename(fpath)
    is_lab = ('/docs/' in fpath or '/Lab' in fpath)

    ch_match = re.search(r'(?:ch|u)[xX]?(\d+)', fpath)
    ch_num = ch_match.group(1) if ch_match else '00'

    with open(fpath, 'r', encoding='utf-8') as f:
        content = f.read()

    # Extract appendix answers if present (e.g. ## 📚 附錄：課堂互動與概念檢核參考解答)
    appendix_answers = extract_appendix_answers(content)

    # Separate main body from appendix so appendix itself is not scanned as new questions
    main_content = content
    app_match = re.search(r'\n##\s*📚?\s*(?:附錄|Appendix)[^\n]*\n', content, re.IGNORECASE)
    if app_match:
        main_content = content[:app_match.start()]

    is_x_chap = bool(re.search(r'[xX]\d+', fpath) or re.search(r'Chapter\s+[xX]\d+', content, re.IGNORECASE))
    if is_x_chap:
        prefix_folder = f"chX{ch_num}"
        ch_id = f"x{ch_num}"
    elif is_lab:
        prefix_folder = f"u{ch_num}"
        doc_stem = Path(fpath).stem
        doc_slug = doc_stem.lower().replace('ai_', '').replace('_', '')
        ch_id = f"u{ch_num}-{doc_slug}"
    else:
        prefix_folder = f"ch{ch_num}"
        ch_id = prefix_folder

    # Find chapter / document title
    title_match = re.search(r'^#\s+(.+)$', content, re.MULTILINE)
    if title_match:
        raw_ch_title = title_match.group(1).strip()
        if is_lab:
            ch_title = re.sub(r'^[Uu](?:nit)?\s*0?(\d+)[:\s]*', r'Unit \1: ', raw_ch_title)
            if not ch_title.startswith('Unit ') and not ch_title.startswith('Lab ') and not ch_title.startswith('Chapter '):
                ch_title = f'Unit {int(ch_num)}: {ch_title}'
        elif is_x_chap:
            ch_title = re.sub(r'^[Cc]h(?:apter)?\s*0?([Xx]\d+)[:\s]*', r'Chapter \1: ', raw_ch_title)
        else:
            ch_title = re.sub(r'^[Cc]h(?:apter)?\s*0?(\d+)[:\s]*', r'Chapter \1: ', raw_ch_title)
            if not re.match(r'^(?:Chapter|Ch)\s*\d+[:\s]', ch_title, re.IGNORECASE):
                ch_title = f'Chapter {int(ch_num)}: {ch_title}'
    else:
        if is_x_chap:
            ch_title = f'Chapter X{ch_num}'
        elif is_lab:
            ch_title = f'Unit {int(ch_num)}'
        else:
            ch_title = f'Chapter {int(ch_num)}'

    matches = list(CCQ_REGEX.finditer(main_content))
    activities = []
    type_counts = {}

    for idx, m in enumerate(matches, 1):
        pre_id = m.group(1)
        header_line = m.group(2).strip()
        body = m.group(3)

        # 1. Identify Question Type
        type_match = re.search(r'(CCQ|Poll|Survey|Game|Ordering|QA|Short|WordCloud|Pair|Discussion|投票|問卷|問卷調查|搶答|文字雲|排序|簡答|觀念檢核|概念核對問答|課堂遊戲|雙人討論|分組討論)', header_line, re.IGNORECASE)
        q_type = 'ccq'
        if type_match:
            tag = type_match.group(1).lower()
            if tag in ['poll', 'survey', '投票', '問卷', '問卷調查']:
                q_type = 'poll'
            elif tag in ['game', '搶答', '搶答題', '課堂遊戲']:
                q_type = 'game'
            elif tag in ['wordcloud', '文字雲']:
                q_type = 'wordcloud'
            elif tag in ['ordering', '排序', '排序題']:
                q_type = 'ordering'
            elif tag in ['qa', 'short', '簡答', '簡答題']:
                q_type = 'short'
            elif tag in ['pair', 'discussion', '雙人討論', '分組討論']:
                q_type = 'pair'
            else:
                q_type = 'ccq'

        # 2. Identify Activity ID
        id_match = re.search(r'<!--\s*id:\s*([^\s>]+)\s*-->', pre_id)
        if not id_match:
            id_match = re.search(r'<!--\s*id:\s*([^\s>]+)\s*-->', body)

        seen_ids = {a['id'] for a in activities}
        if id_match:
            act_id = id_match.group(1).strip()
            if act_id in seen_ids:
                prefix = 'ccq' if q_type == 'ccq' else q_type
                c_prefix = course_slug
                type_counts[prefix] = type_counts.get(prefix, 0) + 1
                act_id = f'{c_prefix}-{ch_id}-{prefix}{type_counts[prefix]}'
        else:
            link_match = re.search(r'#/student/([a-zA-Z0-9_-]+)', body)
            if link_match and link_match.group(1).strip() not in seen_ids:
                act_id = link_match.group(1).strip()
            else:
                prefix = 'ccq' if q_type == 'ccq' else q_type
                c_prefix = course_slug
                type_counts[prefix] = type_counts.get(prefix, 0) + 1
                type_idx = type_counts[prefix]
                act_id = f'{c_prefix}-{ch_id}-{prefix}{type_idx}'

        # 3. Parse sub-questions (supporting single or multi-round questions)
        sub_questions = []
        if body.count('<details>') > 1 or len(re.findall(r'\*\*第\s*\d+\s*題', body)) > 1 or '\n---\n' in body:
            sub_blocks = [b.strip() for b in re.split(r'\n---\s*\n', body) if b.strip()]
            for sb in sub_blocks:
                sub_q = parse_single_question_block(sb, default_type=q_type)
                if sub_q['question'] or sub_q['options']:
                    sub_questions.append(sub_q)

        if not sub_questions:
            single_q = parse_single_question_block(body, default_type=q_type)
            if not single_q['question']:
                header_clean = clean_question_text(header_line.replace('#', '').strip())
                single_q['question'] = header_clean
            sub_questions = [single_q]

        # Check if we should backfill answers from the appendix
        num_m = re.search(r'CCQ\s*([A-Za-z0-9]+)', header_line, re.IGNORECASE)
        if not num_m:
            num_m = re.search(r'ccq([A-Za-z0-9]+)', act_id, re.IGNORECASE)

        if num_m:
            raw_key = num_m.group(1).lower()
            if raw_key.isdigit():
                ccq_key = f"ccq_{int(raw_key)}"
            else:
                ccq_key = f"ccq_{raw_key}"
            if ccq_key in appendix_answers:
                app_ans = appendix_answers[ccq_key]
                for sq in sub_questions:
                    if not sq.get('correct_answer'):
                        sq['correct_answer'] = app_ans['correct_answer']
                        if not sq.get('explanation'):
                            sq['explanation'] = app_ans['explanation']
                        # update is_correct on options
                        new_opts = []
                        for opt_key, opt_text, _ in sq.get('options', []):
                            new_opts.append((opt_key, opt_text, opt_key == sq['correct_answer']))
                        sq['options'] = new_opts

        # Extract custom activity title from header
        clean_h = re.sub(r'^[#\s🙋🎯📊⚡☁️🔢💬💡❓📱🎮🏆⏱️*]+', '', header_line).strip()
        clean_h = re.sub(r'[*]+$', '', clean_h).strip()
        act_custom_title = re.sub(r'^(?:概念核對問答|雙人課堂討論|投票互動|問卷調查|文字雲互動|排序互動|課堂遊戲挑戰|課堂遊戲|簡答問答)\s*(?:[（\(][^）\)]+[）\)])?[:：\s—\-]*', '', clean_h).strip()
        if not act_custom_title or act_custom_title.lower() in ['ccq', 'poll', 'game', 'wordcloud', 'pair', 'survey', 'ordering']:
            activity_title = f"{ch_title} {q_type.upper()} {idx}"
        else:
            activity_title = act_custom_title

        activities.append({
            'id': act_id,
            'title': activity_title,
            'type': q_type,
            'question': sub_questions[0]['question'],
            'options': sub_questions[0]['options'],
            'ordering_items': sub_questions[0]['ordering_items'],
            'correct_answer': sub_questions[0]['correct_answer'],
            'explanation': sub_questions[0]['explanation'],
            'questions': sub_questions,
            'ch_num': ch_num,
            'prefix_folder': prefix_folder
        })

    return ch_title, activities

def convert_nickedupocket_activity_to_lecture(act_raw: str, base_url: str = BASE_STUDENT_URL, img_rel_path: str = None) -> str:
    """Converts a raw nickedupocket activity markdown block into clean Lecture Markdown with student link and QR Code."""
    m = re.match(r'###\s+\[Activity:\s*([^\]]+)\]\s*([^\n]*)', act_raw.strip())
    if not m:
        return ''
    act_id = m.group(1).strip()
    act_title = m.group(2).strip()

    clean_title = re.sub(r'^(?:Chapter|Ch)\s*X\d+[:\s]*', '', act_title, flags=re.IGNORECASE).strip()
    body = act_raw.strip()[m.end():].strip()

    q_blocks = re.split(r'\n(?=####\s+)', body)
    first_type_m = re.search(r'####\s+\[([^\]]+)\]', body)
    raw_type = first_type_m.group(1).lower() if first_type_m else 'ccq'

    type_labels = {
        'ccq': '概念核對問答 (CCQ)',
        'pair': '雙人課堂討論 (Pair Discussion)',
        'poll': '投票互動 (Poll)',
        'survey': '問卷調查 (Survey)',
        '問卷': '問卷調查 (Survey)',
        'wordcloud': '文字雲互動 (WordCloud)',
        'ordering': '排序互動 (Ordering)',
        'game': '課堂遊戲挑戰 (Game)',
        'short': '簡答問答 (Short QA)',
        'qa': '簡答問答 (Short QA)',
    }
    type_label = type_labels.get(raw_type, raw_type.upper())

    if any(k in clean_title for k in ['CCQ', 'Pair', 'Poll', 'WordCloud', 'Game', 'Ordering', '問卷', 'Survey', '討論', '投票']):
        header_text = f'#### 🙋 **{clean_title}**'
    else:
        header_text = f'#### 🙋 **{type_label}：{clean_title}**'

    formatted_questions = []
    for qb in q_blocks:
        if not qb.strip():
            continue
        qm = re.match(r'####\s+\[([^\]]+)\]\s*([^\n]*)', qb.strip())
        if qm:
            q_header = qm.group(2).strip()
            q_content = qb.strip()[qm.end():].strip()
        else:
            q_header = ''
            q_content = qb.strip()

        details_match = re.search(r'(<details>.*?</details>)', q_content, re.DOTALL)
        details_str = ''
        if details_match:
            details_str = details_match.group(1).strip()
            q_content = q_content[:details_match.start()] + q_content[details_match.end():]
            q_content = q_content.strip()

        lines = [l.strip() for l in q_content.split('\n') if l.strip()]
        out_lines = []
        if q_header:
            if re.match(r'^第\s*\d+\s*題', q_header) and not q_header.startswith('**'):
                out_lines.append(f'**{q_header}**\n')
            else:
                out_lines.append(f'{q_header}\n')

        opt_idx = 0
        letters = [chr(i) for i in range(ord('A'), ord('Z') + 1)]
        for line in lines:
            opt_m = re.match(r'^[-*]\s+(.+)$', line)
            if opt_m:
                opt_text = opt_m.group(1).strip()
                letter_m = re.match(r'^([A-Za-z0-9]+)[\.\)]\s*(.+)$', opt_text)
                if letter_m:
                    out_lines.append(f'{letter_m.group(1)}) {letter_m.group(2).strip()}  ')
                else:
                    letter = letters[opt_idx] if opt_idx < len(letters) else str(opt_idx + 1)
                    clean_opt = re.sub(r'\s*\([Cc]orrect\)', '', opt_text)
                    out_lines.append(f'{letter}) {clean_opt}  ')
                    opt_idx += 1
            else:
                out_lines.append(line)

        q_formatted = '\n'.join(out_lines).strip()
        if details_str:
            q_formatted += f'\n\n{details_str}'
        formatted_questions.append(q_formatted)

    combined_body = '\n\n---\n\n'.join(formatted_questions)
    if img_rel_path:
        link = f'[課堂互動]({base_url}{act_id})\n\n<img src="{img_rel_path}" width="120">'
    else:
        link = f'[課堂互動]({base_url}{act_id})'
    return f'<!-- id: {act_id} -->\n{header_text}\n\n{combined_body}\n\n{link}\n'

def reverse_sync_chapter_x(course_key: str, course_dir: str, target_out_path: str, base_url: str = BASE_STUDENT_URL):
    """
    Reverse-syncs Chapter Xnn chapters authored in nickedupocket back into the course files.
    e.g. Chapter X01, Chapter X02 -> <course>/Lecture/chx01.md, chx02.md
    Also directly embeds the QR Code image in the generated lecture markdown.
    """
    if not os.path.exists(target_out_path):
        return 0

    with open(target_out_path, 'r', encoding='utf-8') as f:
        content = f.read()

    chap_blocks = re.split(r'\n(?=##\s+)', content)
    reverse_count = 0

    for cb in chap_blocks:
        m = re.match(r'##\s+([^\n]+)', cb.strip())
        if not m:
            continue
        title = m.group(1).strip()
        x_m = re.search(r'Chapter\s+[Xx](\d+)', title)
        if not x_m:
            continue

        num = x_m.group(1)

        # Determine target file path
        candidate_paths = [
            os.path.join(course_dir, 'Lecture', 'source', f'chx{num}.md'),
            os.path.join(course_dir, 'Lecture', f'chx{num}.md'),
            os.path.join(course_dir, 'Lecture', 'source', f'chX{num}.md'),
            os.path.join(course_dir, 'Lecture', f'chX{num}.md'),
        ]
        target_file = None
        for cand in candidate_paths:
            if os.path.exists(cand):
                target_file = cand
                break

        if not target_file:
            if os.path.exists(os.path.join(course_dir, 'Lecture', 'source')):
                target_file = os.path.join(course_dir, 'Lecture', 'source', f'chx{num}.md')
            else:
                os.makedirs(os.path.join(course_dir, 'Lecture'), exist_ok=True)
                target_file = os.path.join(course_dir, 'Lecture', f'chx{num}.md')

        is_source = ('/source/' in target_file)
        img_prefix = '../../img' if is_source else '../img'

        act_blocks = re.split(r'\n(?=###\s+)', cb)
        act_markdowns = []

        # Generate QR code images for Chapter X
        if QR_AVAILABLE:
            img_dir = os.path.join(course_dir, 'img', f'chX{num}')
            os.makedirs(img_dir, exist_ok=True)

        for ab in act_blocks:
            if ab.startswith('## '):
                continue
            m_id = re.search(r'###\s+\[Activity:\s*([^\]]+)\]', ab)
            act_id = m_id.group(1).strip() if m_id else None
            qr_img_rel = f"{img_prefix}/chX{num}/{act_id}.png" if act_id else None

            if QR_AVAILABLE and act_id:
                qr_path = os.path.join(img_dir, f'{act_id}.png')
                url = f"{base_url}{act_id}"
                qr = qrcode.QRCode(
                    version=1,
                    error_correction=qrcode.constants.ERROR_CORRECT_M,
                    box_size=8,
                    border=2,
                )
                qr.add_data(url)
                qr.make(fit=True)
                img = qr.make_image(fill_color="black", back_color="white")
                img.save(qr_path)

            act_md = convert_nickedupocket_activity_to_lecture(ab, base_url, img_rel_path=qr_img_rel)
            if act_md:
                act_markdowns.append(act_md)

        if not act_markdowns:
            continue

        file_content = f'# {title}\n\n' + '\n---\n\n'.join(act_markdowns)

        with open(target_file, 'w', encoding='utf-8') as f:
            f.write(file_content)

        rel_path = os.path.relpath(target_file, course_dir)
        print(f"  📥 [Reverse Sync] {title} -> {rel_path} ({len(act_markdowns)} activities with QR codes)")
        reverse_count += 1

    return reverse_count

def normalize_chapter_key(title: str) -> str:
    xm = re.search(r'Chapter\s+[Xx](\d+)', title, re.IGNORECASE)
    if xm:
        return f'chapter_x{xm.group(1).lower()}'
    k = re.sub(r'^[Cc]h(?:apter)?\s*0?(\d+)[:\s]*', '', title)
    k = re.sub(r'^[Uu](?:nit)?\s*0?(\d+)[:\s]*', '', k)
    return k.strip().lower()

def format_activity_block(act: dict) -> list:
    act_lines = []
    act_lines.append(f"### [Activity: {act['id']}] {act['title']}")
    q_type = act.get('type', 'ccq')

    questions = act.get('questions', [])
    if not questions:
        questions = [{
            'question': act.get('question', ''),
            'type': q_type,
            'options': act.get('options', []),
            'ordering_items': act.get('ordering_items', []),
            'correct_answer': act.get('correct_answer', ''),
            'explanation': act.get('explanation', ''),
        }]

    for q in questions:
        q_formatted = q['question'].replace('\n', ' ')
        sub_type = q.get('type', q_type)
        sub_tag = 'CCQ' if sub_type == 'ccq' else ('Short' if sub_type == 'short' else ('WordCloud' if sub_type == 'wordcloud' else ('Pair' if sub_type == 'pair' else sub_type.capitalize())))
        act_lines.append(f"#### [{sub_tag}] {q_formatted}")

        if sub_type == 'ordering':
            items = q.get('ordering_items', [])
            if not items:
                items = [opt[1] for opt in q.get('options', [])]
            for o_idx, item in enumerate(items, 1):
                act_lines.append(f"{o_idx}. {item}")
        elif sub_type in ['ccq', 'poll', 'game', 'survey']:
            for opt_key, opt_text, is_correct in q.get('options', []):
                suffix = " (Correct)" if (is_correct and sub_type not in ['poll', 'survey']) else ""
                act_lines.append(f"- {opt_text}{suffix}")

        # Include <details> block if explanation or correct answer exists
        if sub_type in ['ccq', 'game'] and (q.get('correct_answer') or q.get('explanation')):
            is_zh = bool(re.search(r'[\u4e00-\u9fff]', q.get('question', '') + q.get('explanation', '')))
            act_lines.append("")
            act_lines.append("<details>")
            act_lines.append("<summary>點擊查看答案與解析</summary>" if is_zh else "<summary>Click to view Answer & Explanation</summary>")
            act_lines.append("")
            if q.get('correct_answer'):
                prefix = "**正確答案**：" if is_zh else "**Correct Answer**: "
                act_lines.append(f"{prefix}{q['correct_answer']}")
            if q.get('explanation'):
                prefix = "**解析**：" if is_zh else "**Explanation**: "
                act_lines.append(f"{prefix}{q['explanation']}")
            act_lines.append("</details>")

    act_lines.append("")
    return act_lines

def update_nickedupocket_markdown(course_title: str, target_out_path: str, chapters_data: list) -> str:
    """Updates nickedupocket course markdown, preserving any chapters that only exist in nickedupocket or Chapter Xnn."""
    existing_chapters = {}
    ordered_titles = []

    if os.path.exists(target_out_path):
        with open(target_out_path, 'r', encoding='utf-8') as f:
            existing_content = f.read()

        chap_blocks = re.split(r'\n(?=##\s+)', existing_content)
        for cb in chap_blocks:
            m = re.match(r'##\s+([^\n]+)', cb.strip())
            if m:
                raw_title = m.group(1).strip()
                norm_key = normalize_chapter_key(raw_title)
                existing_chapters[norm_key] = cb.strip()
                ordered_titles.append(norm_key)

    scanned_dict = {}
    for ch_title, activities in chapters_data:
        norm_key = normalize_chapter_key(ch_title)
        scanned_dict[norm_key] = (ch_title, activities)
        if norm_key not in ordered_titles:
            ordered_titles.append(norm_key)

    # Ensure Chapter Xnn chapters always stay at the end of ordered_titles
    non_x_titles = [t for t in ordered_titles if not re.search(r'Chapter\s+[Xx]\d+', t)]
    x_titles = [t for t in ordered_titles if re.search(r'Chapter\s+[Xx]\d+', t)]
    ordered_titles = list(dict.fromkeys(non_x_titles)) + list(dict.fromkeys(x_titles))

    lines = [f"# {course_title}", ""]
    emitted_scanned = set()

    for norm_key in ordered_titles:
        is_x_chap = bool(re.search(r'Chapter\s+[Xx]\d+', norm_key))
        if is_x_chap and norm_key in existing_chapters:
            # Chapter Xnn is authored in nickedupocket: preserve nickedupocket's master content!
            lines.append(existing_chapters[norm_key])
            lines.append("")
            emitted_scanned.add(norm_key)
        elif norm_key in scanned_dict:
            ch_title, activities = scanned_dict[norm_key]
            emitted_scanned.add(norm_key)
            if not activities:
                continue
            lines.append(f"## {ch_title}")
            lines.append("")
            for act in activities:
                lines.extend(format_activity_block(act))
        elif norm_key in existing_chapters:
            lines.append(existing_chapters[norm_key])
            lines.append("")

    # Emit any remaining scanned chapters
    for s_key, (ch_title, activities) in scanned_dict.items():
        if s_key not in emitted_scanned and activities:
            lines.append(f"## {ch_title}")
            lines.append("")
            for act in activities:
                lines.extend(format_activity_block(act))
            emitted_scanned.add(s_key)

    return '\n'.join(lines).strip() + '\n'

def generate_qr_codes(course_dir: str, chapters_data: list, base_url: str):
    """Generates QR code images for student mobile access."""
    if not QR_AVAILABLE:
        print("[WARN] 'qrcode' module not installed. Skipping QR code generation.")
        return 0

    count = 0
    for ch_title, activities in chapters_data:
        for act in activities:
            prefix_folder = act.get('prefix_folder', f"ch{act['ch_num']}")
            act_id = act['id']

            img_dir = os.path.join(course_dir, 'img', prefix_folder)
            os.makedirs(img_dir, exist_ok=True)
            qr_path = os.path.join(img_dir, f'{act_id}.png')

            url = f"{base_url}{act_id}"
            qr = qrcode.QRCode(
                version=1,
                error_correction=qrcode.constants.ERROR_CORRECT_M,
                box_size=8,
                border=2,
            )
            qr.add_data(url)
            qr.make(fit=True)
            img = qr.make_image(fill_color="black", back_color="white")
            img.save(qr_path)
            count += 1

    return count

def embed_ccqs_into_lecture(fpath: str, activities: list, base_url: str):
    """Embeds <!-- id: ... --> comments and [課堂互動] links (and QR code for Chapter X) into lecture/doc markdown."""
    with open(fpath, 'r', encoding='utf-8') as f:
        content = f.read()

    is_x_chap = bool(re.search(r'[xX]\d+', fpath) or re.search(r'Chapter\s+[xX]\d+', content, re.IGNORECASE))
    is_source = ('/source/' in fpath or '/en/' in fpath or '/tw/' in fpath)
    img_prefix = '../../img' if is_source else '../img'
    is_english = ('/en/' in fpath or os.path.basename(fpath).endswith('e.md') or '_en' in fpath.lower())
    link_label = "Interactive Activity (線上作答)" if is_english else "課堂互動"

    matches = list(CCQ_REGEX.finditer(content))
    new_content = ""
    last_end = 0

    for idx, (m, act) in enumerate(zip(matches, activities), 1):
        header_line = m.group(2).strip()
        body = m.group(3)
        act_id = act['id']
        url = f"{base_url}{act_id}"

        # Extract <details> block if present so we can place link/QR before details
        details_match = re.search(r'(<details>.*?</details>)', body, re.DOTALL)
        details_block = details_match.group(1) if details_match else ''
        main_body = body[:details_match.start()] if details_match else body
        after_details = body[details_match.end():] if details_match else ''

        # Clean old embeddings completely from main_body
        clean_body = re.sub(r'<!--\s*id:\s*[^\s>]+\s*-->\s*', '', main_body)
        clean_body = re.sub(r'\[(?:線上作答|課堂互動|Online Answer|Interactive Activity[^\]\n]*|Interactive[^\]\n]*)\](?:\([^)]*\))?\s*', '', clean_body, flags=re.IGNORECASE)
        clean_body = re.sub(r'\[[^\]\n]*\]\(https?://[^\s)]*nickedupocket[^\s)]*\)\s*', '', clean_body)
        clean_body = re.sub(r'\(https?://[^\s)]*nickedupocket[^\s)]*\)\s*', '', clean_body)
        clean_body = re.sub(r'!\[.*?\]\([^)]*\)\s*', '', clean_body)
        clean_body = re.sub(r'<a\s+href=[\'"][^\'"]*?[\'"][^>]*?>\s*<img[^>]*?>\s*</a>\s*', '', clean_body, flags=re.IGNORECASE)
        clean_body = re.sub(r'<img[^>]*?>\s*', '', clean_body, flags=re.IGNORECASE)
        clean_body = clean_body.strip()

        # Build clean block (QR code image included for Chapter Xnn or if already had QR code)
        prefix_folder = act.get('prefix_folder', f"ch{act['ch_num']}")
        qr_img_rel = f"{img_prefix}/{prefix_folder}/{act_id}.png"
        
        had_qr = is_x_chap or ('<img' in body and ('.png' in body or 'ccq' in body.lower()))
        if had_qr:
            embedded_link = f"\n\n[{link_label}]({url})\n\n<a href=\"{url}\" target=\"_blank\"><img src=\"{qr_img_rel}\" width=\"120\"></a>\n"
        else:
            embedded_link = f"\n\n[{link_label}]({url})\n"

        replacement = f"<!-- id: {act_id} -->\n{header_line}\n\n{clean_body}{embedded_link}"
        if details_block:
            replacement += f"\n{details_block}\n"
        if after_details.strip():
            clean_after = re.sub(r'\[[^\]\n]*\]\(https?://[^\s)]*nickedupocket[^\s)]*\)\s*', '', after_details)
            clean_after = re.sub(r'<a\s+href=[\'"][^\'"]*?[\'"][^>]*?>\s*<img[^>]*?>\s*</a>\s*', '', clean_after, flags=re.IGNORECASE)
            clean_after = re.sub(r'<img[^>]*?>\s*', '', clean_after, flags=re.IGNORECASE).strip()
            if clean_after:
                replacement += f"\n{clean_after}\n"

        new_content += content[last_end:m.start()]
        new_content += replacement
        last_end = m.end()

    new_content += content[last_end:]

    # Remove any duplicate or orphaned [課堂互動] or [Interactive Activity] lines
    new_content = re.sub(r'\n+\[[^\]\n]*\]\(https?://[^\s)]*nickedupocket[^\s)]*\)\s*(?=\n(?:#|---|\Z))', '', new_content)

    with open(fpath, 'w', encoding='utf-8') as f:
        f.write(new_content)

def embed_ccqs_into_slides(course_dir: str, chapters_data: list, base_url: str, course_slug: str = ''):
    """Embeds QR codes and [課堂互動] links into Marp slide files in Slide directories."""
    slide_dirs = [
        os.path.join(course_dir, 'Slide', 'source'),
        os.path.join(course_dir, 'Slide', 'md-en'),
        os.path.join(course_dir, 'Slide', 'md-tw'),
        os.path.join(course_dir, 'Slide'),
    ]
    slide_files = []
    for sdir in slide_dirs:
        if os.path.exists(sdir):
            for f in glob.glob(os.path.join(sdir, '*.md')):
                if f not in slide_files and not any(b in f.lower() for b in ['backup', 'copy', 'old', 'tmp']):
                    slide_files.append(f)
    if not slide_files:
        return 0
    slide_files = sorted(slide_files)

    total_slide_updates = 0
    all_activities = []
    for ch_title, activities in chapters_data:
        all_activities.extend(activities)

    act_by_id = {act['id']: act for act in all_activities}
    for sfile in slide_files:
        basename = os.path.basename(sfile)
        ch_match = re.search(r'(\d+)', basename)
        ch_num_file = ch_match.group(1) if ch_match else '01'

        with open(sfile, 'r', encoding='utf-8') as f:
            content = f.read()

        slides = content.split('\n---\n')
        updated_slides = []
        file_changed = False
        current_ch = ch_num_file

        for slide in slides:
            # Skip answer/explanation slides
            if re.search(r'(?:答案與解析|課堂互動參考解答|互動參考解答|參考解答|參考答案|Answer\s*&?\s*Explanation)', slide, re.IGNORECASE):
                updated_slides.append(slide)
                continue

            # Update chapter if slide has a section/chapter title
            ch_hdr_m = re.search(r'#+\s*(?:Chapter|Ch|Unit|單元)\s*0?(\d+)', slide, re.IGNORECASE)
            if ch_hdr_m:
                current_ch = ch_hdr_m.group(1)

            ccq_num_match = re.search(r'(?:CCQ|Concept Check(?: Question)?|觀念檢[測核])\s*[:：]?\s*(\d+)|(?:CCQ\s*(\d+))', slide, re.IGNORECASE)
            id_match = re.search(r'<!--\s*id:\s*([^\s>]+)\s*-->', slide)

            matched_act = None

            # Priority 1: If slide has explicit <!-- id: ... -->, use it!
            if id_match:
                candidate = id_match.group(1).strip()
                if candidate in act_by_id:
                    matched_act = act_by_id[candidate]

            # Priority 2: Match by CCQ number and chapter
            if not matched_act and ccq_num_match:
                num = ccq_num_match.group(1) or ccq_num_match.group(2)
                for ch_try in [current_ch, ch_num_file]:
                    if ch_try:
                        cand = f"{course_slug}-ch{int(ch_try):02d}-ccq{int(num)}"
                        if cand in act_by_id:
                            matched_act = act_by_id[cand]
                            break
                if not matched_act:
                    for act in all_activities:
                        if act['id'].endswith(f"ch{int(ch_num_file):02d}-ccq{num}") or (act.get('ch_num') == f"{int(ch_num_file):02d}" and act['id'].endswith(f"-ccq{num}")):
                            matched_act = act
                            break

            # Priority 3: Match by heading content
            if not matched_act:
                heading_m = CCQ_REGEX.search(slide)
                if heading_m:
                    header_text = heading_m.group(2).strip()
                    clean_header = clean_question_text(header_text)
                    for act in all_activities:
                        if (act.get('ch_num') in [f"{int(current_ch):02d}", f"{int(ch_num_file):02d}"]) and (act['id'] in slide or (clean_header and clean_header in act['question'])):
                            matched_act = act
                            break

            if matched_act:
                act_id = matched_act['id']
                prefix_folder = matched_act.get('prefix_folder', f"ch{matched_act['ch_num']}")
                url = f"{base_url}{act_id}"
                qr_img_rel = f"../../img/{prefix_folder}/{act_id}.png"

                # Format A: div.ccq-logo (e.g. gTeachPython, gTeachASE ch01/ch02, SQA)
                if 'class="ccq-logo"' in slide or "class='ccq-logo'" in slide:
                    m_logo = re.search(r'(<div class=["\']ccq-logo["\'][^>]*>)(.*?)(</div>)', slide, re.DOTALL)
                    if m_logo:
                        open_tag = m_logo.group(1)
                        inner = m_logo.group(2)
                        close_tag = m_logo.group(3)
                        qr_link = f'<a href="{url}" target="_blank"><img src="{qr_img_rel}" alt="QR Code" /></a>'

                        qr_m = re.search(r'<a\s+href=[\'"][^\'"]*(?:nickedupocket|student)[^\'"]*[\'"][^>]*>\s*<img[^>]*?>\s*</a>', inner, re.IGNORECASE | re.DOTALL)
                        if not qr_m:
                            qr_m = re.search(r'<img\s+src=[\'"][^\'"]*?(?:ccq|student|u\d+|ch\d+)[^\'"]*\.png[\'"][^>]*?>', inner, re.IGNORECASE)

                        if qr_m:
                            new_inner = inner[:qr_m.start()] + qr_link + inner[qr_m.end():]
                        else:
                            clean_inner = inner.strip()
                            if clean_inner:
                                new_inner = f"\n    {qr_link}\n    <br>{clean_inner}\n  "
                            else:
                                new_inner = f"\n    {qr_link}\n  "

                        new_slide = slide[:m_logo.start()] + open_tag + new_inner + close_tag + slide[m_logo.end():]
                    else:
                        new_slide = slide

                    if f'<!-- id: {act_id} -->' not in new_slide:
                        new_slide = re.sub(r'<!--\s*id:\s*[^\s>]+\s*-->\s*', '', new_slide)
                        heading_sub = re.search(r'(###?[^\n]+\n)', new_slide)
                        if heading_sub:
                            pos = heading_sub.end()
                            new_slide = new_slide[:pos] + f'<!-- id: {act_id} -->\n' + new_slide[pos:]
                        else:
                            new_slide = f'<!-- id: {act_id} -->\n' + new_slide
                    if new_slide != slide:
                        slide = new_slide
                        file_changed = True

                # Format B: div.card-img (e.g. gTeachUX UX_AI.md)
                elif 'class="card-img"' in slide or "class='card-img'" in slide:
                    new_slide = re.sub(
                        r'(<div class=["\']card-img["\'].*?>\s*)(?:<a[^>]*>.*?</a>|<img[^>]*>|.*?)(?=\s*</div>)',
                        rf'\g<1><a href="{url}" target="_blank"><img src="{qr_img_rel}" alt="QR Code" style="max-height: 280px;"></a>',
                        slide,
                        flags=re.DOTALL
                    )
                    new_slide = re.sub(
                        r'\[(?:線上作答|課堂互動|Online Answer)\]\([^\)]*\)',
                        f'[線上作答]({url})',
                        new_slide
                    )
                    if f'<!-- id: {act_id} -->' not in new_slide:
                        new_slide = re.sub(r'<!--\s*id:\s*[^\s>]+\s*-->\s*', '', new_slide)
                        new_slide = f'<!-- id: {act_id} -->\n' + new_slide.lstrip()
                    if new_slide != slide:
                        slide = new_slide
                        file_changed = True

                # Format C: General slide (fallback)
                else:
                    clean_slide = re.sub(r'<!--\s*id:\s*[^\s>]+\s*-->\s*', '', slide)
                    clean_slide = re.sub(r'\[(?:線上作答|課堂互動|Online Answer)\]\([^\)]*\)\s*', '', clean_slide)
                    clean_slide = re.sub(r'<a\s+href=["\'][^"\']*?["\'][^>]*?>\s*<img[^>]*?>\s*</a>\s*', '', clean_slide, flags=re.IGNORECASE)
                    clean_slide = re.sub(r'<img\s+src=["\'][^"\']*?(?:ccq|student|patriot|wordcloud|\.png)[^"\']*?["\'][^>]*?>\s*', '', clean_slide, flags=re.IGNORECASE)
                    clean_slide = clean_slide.rstrip()

                    embedded = f"\n\n[課堂互動]({url})\n\n<a href=\"{url}\" target=\"_blank\"><img src=\"{qr_img_rel}\" width=\"120\"></a>\n"
                    new_slide = f"<!-- id: {act_id} -->\n{clean_slide}{embedded}"
                    if new_slide != slide:
                        slide = new_slide
                        file_changed = True

            updated_slides.append(slide)

        if file_changed:
            with open(sfile, 'w', encoding='utf-8') as f:
                f.write('\n---\n'.join(updated_slides))
            total_slide_updates += 1

    return total_slide_updates

def find_nickedupocket_dir(repo_root: str, custom_path: str = None) -> str:
    """Finds nickedupocket directory across environments (nTeach at home, oTeach at office, Google Drive)."""
    if custom_path and os.path.exists(custom_path):
        return os.path.abspath(custom_path)

    parent_dir = os.path.dirname(repo_root)
    candidates = [
        os.path.join(parent_dir, 'nickedupocket'),
        os.path.join(repo_root, 'nickedupocket'),
        os.path.expanduser('~/homeTeach/nickedupocket'),
        os.path.expanduser('~/oTeach/nickedupocket'),
        os.path.expanduser('~/nickedupocket'),
        os.path.expanduser('~/Library/CloudStorage/GoogleDrive-nlhsueh@gmail.com/我的雲端硬碟/gTEACH/nickedupocket'),
        os.path.expanduser('~/Library/CloudStorage/GoogleDrive-nlhsueh@gmail.com/My Drive/gTEACH/nickedupocket'),
    ]
    for c in candidates:
        if os.path.exists(os.path.join(c, 'public', 'courses')):
            return os.path.abspath(c)
    return os.path.abspath(candidates[0])

def find_course_dir(workspace_root: str, course_key: str) -> str:
    """Finds course directory under workspace_root, matching both new (SQA/UX/SE) and legacy (gTeachSQA) names."""
    c_lower = course_key.lower()
    aliases = FOLDER_ALIASES.get(c_lower, [course_key])
    for alias in aliases:
        p = os.path.join(workspace_root, alias)
        if os.path.exists(p):
            return p
    for item in os.listdir(workspace_root):
        if item.lower() in [a.lower() for a in aliases]:
            return os.path.join(workspace_root, item)
    return os.path.join(workspace_root, course_key)

def git_commit_and_push_nickedupocket(nickedupocket_dir: str, course_title: str = None):
    """Checks if nickedupocket repository has modified course data and commits & pushes them."""
    if not os.path.exists(os.path.join(nickedupocket_dir, '.git')):
        print(f"ℹ️ nickedupocket at '{nickedupocket_dir}' is not a Git repository. Skipping auto-push.")
        return

    try:
        status_res = subprocess.run(
            ['git', 'status', '--porcelain', 'public/courses/'],
            cwd=nickedupocket_dir,
            capture_output=True,
            text=True,
            check=True
        )
        if status_res.stdout.strip():
            print(f"\n🔄 Detected changes in nickedupocket ({nickedupocket_dir}). Auto committing and pushing...")
            subprocess.run(['git', 'add', 'public/courses/'], cwd=nickedupocket_dir, check=True)
            msg = f"Auto-sync interactive course data: {course_title or 'Teach'}"
            subprocess.run(['git', 'commit', '-m', msg], cwd=nickedupocket_dir, check=True)
            push_res = subprocess.run(['git', 'push'], cwd=nickedupocket_dir, capture_output=True, text=True, check=True)
            print("🚀 Successfully committed and pushed course data to nickedupocket repository!")
        else:
            print("\nℹ️ nickedupocket course data is up-to-date (no Git changes).")
    except subprocess.CalledProcessError as e:
        print(f"⚠️ [WARN] Git auto commit/push for nickedupocket encountered an issue: {e}")
        if e.stderr:
            print(f"   Details: {e.stderr.strip()}")

def sync_course(course_key: str, out_file: str = None, gen_qr: bool = True, embed: bool = True, auto_push: bool = True, base_url: str = BASE_STUDENT_URL, nickedupocket_dir: str = None):
    target_filter = None
    if '/' in course_key:
        course_key, target_filter = course_key.split('/', 1)
    elif '\\' in course_key:
        course_key, target_filter = course_key.split('\\', 1)

    course_cfg = COURSE_MAPPING.get(course_key.lower())
    script_dir = os.path.dirname(os.path.abspath(__file__))
    workspace_root = os.path.dirname(script_dir)

    pocket_dir = find_nickedupocket_dir(workspace_root, nickedupocket_dir)
    course_dir = find_course_dir(workspace_root, course_key)

    if not course_cfg:
        course_name = os.path.basename(course_dir) if os.path.exists(course_dir) else course_key
        target_filename = f"{course_name}.md"
        course_title = course_name
        course_slug = course_name.lower().replace('gteach', '').replace('g', '')
    else:
        course_title = course_cfg['title']
        course_slug = course_cfg['slug']
        target_filename = course_cfg['output_file']

    target_out_path = out_file or os.path.join(pocket_dir, 'public', 'courses', os.path.basename(target_filename))

    print("=" * 55)
    print(f"📦 Syncing Course: {course_key}")
    if target_filter:
        print(f"🔍 Filter: {target_filter}")
    print(f"📖 Title: {course_title}")
    print(f"🎯 Target File: {target_out_path}")
    print("=" * 55)

    # 1. Reverse Sync: Chapter Xnn chapters from nickedupocket to course files
    rev_count = reverse_sync_chapter_x(course_key, course_dir, target_out_path, base_url)

    # 2. Collect all course markdown files
    lecture_files = []
    if os.path.exists(os.path.join(course_dir, 'Lecture', 'source')):
        lecture_files.extend(glob.glob(os.path.join(course_dir, 'Lecture', 'source', '*.md')))
    if os.path.exists(os.path.join(course_dir, 'Lecture', 'en')):
        lecture_files.extend(glob.glob(os.path.join(course_dir, 'Lecture', 'en', '*.md')))
    elif os.path.exists(os.path.join(course_dir, 'Lecture', 'tw')):
        lecture_files.extend(glob.glob(os.path.join(course_dir, 'Lecture', 'tw', '*.md')))
    if os.path.exists(os.path.join(course_dir, 'Lecture')):
        for f in glob.glob(os.path.join(course_dir, 'Lecture', '*.md')):
            if f not in lecture_files:
                lecture_files.append(f)
    if os.path.exists(os.path.join(course_dir, 'Lecture+')):
        for f in glob.glob(os.path.join(course_dir, 'Lecture+', '*.md')):
            if f not in lecture_files:
                lecture_files.append(f)
    lecture_files = sorted(lecture_files)
    lecture_files = [f for f in lecture_files if not any(b in f.lower() for b in ['backup', 'copy', 'old', 'tmp', 'chx'])]

    docs_patterns = [
        os.path.join(course_dir, 'LabDemo', 'docs', '**', '*.md'),
        os.path.join(course_dir, 'Lab', 'docs', '**', '*.md'),
        os.path.join(course_dir, 'docs', '**', '*.md'),
    ]
    docs_files = []
    for pat in docs_patterns:
        docs_files.extend(glob.glob(pat, recursive=True))
    docs_files = sorted(list(set(docs_files)))
    docs_files = [f for f in docs_files if not any(b in f.lower() for b in ['backup', 'copy', 'uxx', 'old', 'tmp'])]

    all_source_files = lecture_files + docs_files
    if target_filter:
        print(f"🔍 Applying target filter: '{target_filter}'")
        filt_num_m = re.search(r'(?:slide|ch|unit|u)0*(\d+)', target_filter, re.IGNORECASE)
        filter_terms = [target_filter.lower()]
        if filt_num_m:
            num = int(filt_num_m.group(1))
            filter_terms.extend([f"ch{num:02d}", f"ch{num}", f"slide{num:02d}", f"slide{num}", f"u{num:02d}", f"u{num}"])
        all_source_files = [f for f in all_source_files if any(term in f.lower() for term in filter_terms)]
        lecture_files = [f for f in lecture_files if any(term in f.lower() for term in filter_terms)]
        docs_files = [f for f in docs_files if any(term in f.lower() for term in filter_terms)]

    print(f"📂 Found {len(lecture_files)} lecture files and {len(docs_files)} docs files (Total {len(all_source_files)}).")

    chapters_data = []
    total_activities = 0
    total_questions = 0

    for fpath in all_source_files:
        rel_path = os.path.relpath(fpath, course_dir)
        ch_title, activities = parse_lecture_ccqs(fpath, course_slug)
        count = len(activities)
        if count > 0:
            chapters_data.append((fpath, ch_title, activities))
            total_activities += count
            sub_q_count = sum(len(a.get('questions', [1])) for a in activities)
            total_questions += sub_q_count
            print(f"  ✓ {rel_path:<35} -> {count:>2} Activities ({sub_q_count} Qs) [{ch_title}]")

    # 3. Update nickedupocket Course Markdown (preserving non-synced chapters)
    os.makedirs(os.path.dirname(target_out_path), exist_ok=True)
    out_md = update_nickedupocket_markdown(course_title, target_out_path, [(ch_t, acts) for _, ch_t, acts in chapters_data])
    with open(target_out_path, 'w', encoding='utf-8') as f:
        f.write(out_md)
    print(f"\n✅ Successfully synced nickedupocket course: {target_out_path} (Total {total_activities} Scanned Activities, {total_questions} Questions)")

    # 4. Generate QR Code Images
    if gen_qr:
        qr_count = generate_qr_codes(course_dir, [(ch_t, acts) for _, ch_t, acts in chapters_data], base_url)
        print(f"📱 Successfully generated {qr_count} QR code images under {course_key}/img/")

    # 5. Embed links into Lecture & Lab/Docs Markdowns
    if embed:
        for fpath, ch_title, activities in chapters_data:
            if activities:
                embed_ccqs_into_lecture(fpath, activities, base_url)
        for fpath, ch_title, activities in chapters_data:
            if activities:
                # Also check if tw counterpart exists in bilingual courses
                if '/Lecture/en/' in fpath:
                    tw_fpath = fpath.replace('/Lecture/en/', '/Lecture/tw/').replace('e_', 't_')
                    if os.path.exists(tw_fpath):
                        embed_ccqs_into_lecture(tw_fpath, activities, base_url)
        slide_count = embed_ccqs_into_slides(course_dir, [(ch_t, acts) for _, ch_t, acts in chapters_data], base_url, course_slug=course_slug)
        print(f"📝 Auto-embedded activity IDs and [課堂互動] links into source files and {slide_count} slide files.")

    # 6. Auto commit and push nickedupocket changes
    if auto_push:
        git_commit_and_push_nickedupocket(pocket_dir, course_title=course_key)

    return True

def main():
    parser = argparse.ArgumentParser(description="Synchronize Interactive Activities to nickedupocket & Embed Links/QR codes")
    parser.add_argument("--course", "-c", help="Course key (e.g. sqa, ux, se, python, gTeachSQA...) or 'all'")
    parser.add_argument("--all", "-a", action="store_true", help="Sync all courses")
    parser.add_argument("--pocket-dir", "-p", help="Custom path to nickedupocket repository directory")
    parser.add_argument("--out", "-o", help="Custom output markdown file path for nickedupocket")
    parser.add_argument("--base-url", default=BASE_STUDENT_URL, help="Base URL for student access (default: NickPocket GitHub Pages)")
    parser.add_argument("--no-qr", action="store_true", help="Skip QR code image generation")
    parser.add_argument("--no-embed", action="store_true", help="Skip embedding comments/links/QR into source files")
    parser.add_argument("--no-push", action="store_true", help="Skip auto git commit & push for nickedupocket repository")

    args = parser.parse_args()

    script_dir = os.path.dirname(os.path.abspath(__file__))
    workspace_root = os.path.dirname(script_dir)

    if args.all or (args.course and args.course.lower() == 'all'):
        target_courses = ['sqa', 'ux', 'se', 'python']
        for c in target_courses:
            c_dir = find_course_dir(workspace_root, c)
            if os.path.exists(c_dir):
                sync_course(c, out_file=args.out, gen_qr=not args.no_qr, embed=not args.no_embed, auto_push=not args.no_push, base_url=args.base_url, nickedupocket_dir=args.pocket_dir)
    elif args.course:
        sync_course(args.course, out_file=args.out, gen_qr=not args.no_qr, embed=not args.no_embed, auto_push=not args.no_push, base_url=args.base_url, nickedupocket_dir=args.pocket_dir)
    else:
        parser.print_help()

if __name__ == '__main__':
    main()
