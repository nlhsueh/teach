---
name: ccq-authoring
description: >-
  Use this skill when designing, writing, or editing Concept Check Questions (CCQs)
  for lectures, handouts, or slide decks.
---

# CCQ Authoring Guidelines

Guidelines and procedures for authoring high-quality Concept Check Questions (CCQs) in course materials.

## Core Rules

1. **Option Length Balance & Anti-Bias (Critical / 避免答案最長陷阱)**
   * **The Trap to Avoid**: In multiple-choice questions, LLMs often make the correct answer the longest, most detailed option with nuanced caveats. Students quickly exploit this test-taking bias ("when in doubt, pick the longest option"). **This must be strictly avoided.**
   * **Rule 1 - Length Parity**: Keep all four options similar in length (character/word count) and grammatical complexity. Lengths should not differ significantly across options.
   * **Rule 2 - Deliberate Variation**: Actively vary the pattern across questions.
     - Occasionally make the correct answer the **shortest** or **medium-length** option.
     - Deliberately expand plausible distractors with rich technical details, caveats, and realistic sounding complexity so that incorrect options can also be the longest.
     - Ensure the correct option's length is unpredictable.
   * **Rule 3 - Structural Symmetry**: Keep all options structurally parallel (e.g., all starting with verbs, all complete sentences, or all conditional clauses).

2. **Historically and Technically Plausible Distractors**
   * Distractors must be plausible, realistic, and represent common misunderstandings.
   * Do not use concepts or terminology that are completely out of place for the question's scope (e.g., using modern cloud terminology in a historical 1968 question, unless as a deliberate and balanced distractor).

3. **Standard Formatting**
   * **In Lecture Source (`Lecture/en/*.md` or `Lecture/tw/*.md`)**:
     ```markdown
     > 💡🧠 **Concept Check (CCQ <number>) — <Title>**:
     > 
     > *Question*: <Question Text>
     > * A) <Option A>
     > * B) <Option B>
     > * C) <Option C>
     > * D) <Option D>
     > 
     > [👉 View Answer & Detailed Explanation in Appendix](#ccq-<number>--<kebab-case-title>)
     ```
   * **In the Appendix**:
     ```markdown
     ### CCQ <number> — <Title>
     * **Correct Answer**: **<Letter>** (<Correct Option Text>)
     * **Explanation**: <Detailed explanation explaining why the correct answer is right and correcting the distractors.>
     * [⬆ Return to Section <Section>](#<section-anchor>)
     ```
