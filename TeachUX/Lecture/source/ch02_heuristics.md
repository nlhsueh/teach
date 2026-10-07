# Chapter 2: 尼爾森 10 大易用性原則 (Nielsen's 10 Usability Heuristics)

## 2.1 錯誤預防 (NS05) 與警示疲勞

防呆機制必須兼顧使用者的控制自由與操作效率，避免過度的阻斷確認造成使用者的警示疲勞。

<!-- id: ux-ch02-ccq1 -->
### 🙋 **概念核對問答 (CCQ 1)**

**問題**

為了徹底落實錯誤預防，系統在使用者執行「任何」可能修改資料的操作（包括編輯個人暱稱、切換深色模式）時，都強制彈出確認視窗要求點擊「確定修改」，這是兼顧安全性與可用性的最佳實踐？

A) 正確 (True)
B) 錯誤 (False)

[課堂互動](https://nlhsueh.github.io/nickedupocket/#/student/ux-ch02-ccq1)

<details>
<summary>點擊查看【概念核對問答】答案與解析</summary>

**正確答案：B**

* **解析**：
  * 無差別的確認彈窗會誘發「警示疲勞 (Alert Fatigue)」，嚴重破壞 NS03 (使用者控制權) 與 NS07 (使用效率)，讓用戶養成不看內容直接按確定的麻木習慣。
  * 最佳實踐為風險分級：低風險操作採用自動儲存 + Undo 復原機制；唯有高風險、不可逆操作才需二次阻斷確認。

</details>

---

## 2.2 簡潔設計 (NS08) 與跨裝置識別性 (NS06)

追求視覺極簡時，不可忽略跨裝置的可發現性與可用性限制。

<!-- id: ux-ch02-ccq2 -->
### 🙋 **概念核對問答 (CCQ 2)**

**問題**

為了實現極致簡潔的視覺體驗，將資料表格中的操作按鈕（編輯/刪除/下載）全數隱藏，改為僅在使用者將滑鼠 Hover 懸停於該列時才浮現，這在所有裝置與情境下都是最推薦的做法？

A) 正確 (True)
B) 錯誤 (False)

[課堂互動](https://nlhsueh.github.io/nickedupocket/#/student/ux-ch02-ccq2)

<details>
<summary>點擊查看【概念核對問答】答案與解析</summary>

**正確答案：B**

* **解析**：
  * 在觸控螢幕或行動裝置上缺乏滑鼠 Hover 懸停機制，隱藏按鈕將導致功能無法被觸發。
  * 過度隱藏核心操作違反了 NS06 (易於識別而非記憶)，降低了系統的可發現性 (Discoverability)。

</details>

---

## 2.3 尼爾森原則綜合交叉應用案例

在真實系統中，往往需要結合多個易用性原則來設計流暢且安全的使用者體驗。

<!-- id: ux-ch02-ccq3 -->
### 🙋 **概念核對問答 (CCQ 3)**

**問題**

電商結帳頁在輸入信用卡時，自動依卡號長度在每 4 碼插入空格（`4111 2222 3333 4444`），並在辨識出卡別後即時於右側點亮 Visa 圖示。這項設計最直接體現了哪兩項原則的結合？

A) NS05 (錯誤預防) 與 NS06 (易於識別而非記憶)
B) NS03 (控制權) 與 NS07 (彈性與使用效率)
C) NS04 (一致性) 與 NS09 (清楚的錯誤處理)
D) NS08 (優雅簡潔的設計) 與 NS10 (適當的說明與文件)

[課堂互動](https://nlhsueh.github.io/nickedupocket/#/student/ux-ch02-ccq3)

<details>
<summary>點擊查看【概念核對問答】答案與解析</summary>

**正確答案：A**

* **解析**：
  * NS05 錯誤預防：利用格式化分塊 (Chunking) 將 16 位數字拆解為 4 位一組，降低抄寫與輸錯機率。
  * NS06 易於識別而非記憶：系統自動辨識並點亮卡片 Logo，使用者一眼即可確認是否拿對卡片，無需回憶卡種規則。

</details>

---

<!-- id: ux-ch02-ccq4 -->
### 🙋 **概念核對問答 (CCQ 4)**

**問題**

使用者在 Gmail 內文提及「如附件企劃書」，但在未附加檔案時點擊「傳送」，系統即時攔截並提示：「您提及了附件但未附加檔案，是否仍要傳送？」，並提供「取消」與「直接傳送」。這最直接體現了哪兩項原則的結合？

A) NS05 (錯誤預防) 與 NS03 (使用者控制與自由)
B) NS01 (系統狀態能見度) 與 NS08 (優雅簡潔的設計)
C) NS02 (與真實世界對應) 與 NS06 (易於識別而非記憶)
D) NS04 (一致性與標準) 與 NS10 (適當的說明與文件)

[課堂互動](https://nlhsueh.github.io/nickedupocket/#/student/ux-ch02-ccq4)

<details>
<summary>點擊查看【概念核對問答】答案與解析</summary>

**正確答案：A**

* **解析**：
  * NS05 錯誤預防：透過內文語意分析在不可逆操作前主動攔截遺漏附件。
  * NS03 使用者控制與自由：提供「取消」與「直接傳送」兩個出口，尊重使用者的最終自主權。

</details>

---

## 2.4 課堂互動遊戲：尼爾森 10 大原則闖關大挑戰

<!-- id: ux-ch02-game1 -->
### 🙋 課堂遊戲：尼爾森 10 大原則闖關大挑戰 (Game)

**第 1 題：【大檔案上傳與即時回饋】**
使用者在雲端硬碟上傳 1GB 的影片檔，系統在右下角以浮動視窗顯示圓形百分比進度、已上傳容量（如 450MB / 1GB）、即時傳輸速度與預估剩餘時間。這項設計最直接落實了哪一項易用性原則？
A) NS01 清楚的系統狀態能見度 (Visibility of System Status)
B) NS03 使用者控制與自由 (User Control and Freedom)
C) NS07 彈性與使用效率 (Flexibility and Efficiency of Use)
D) NS08 優雅簡潔的設計 (Aesthetic and Minimalist Design)

[課堂互動](https://nlhsueh.github.io/nickedupocket/#/student/ux-ch02-game1)

<details>
<summary>點擊查看答案與解析</summary>

**正確答案**：A
**解析**：系統在合理時間內提供即時、精確的狀態回饋（進度百分比、剩餘時間），消除使用者的等待焦慮與系統是否凍結的疑慮，完全符合 NS01 (系統狀態能見度)。
</details>

---

**第 2 題：【實體閱讀隱喻與書架設計】**
電子書閱讀 App 在使用者翻頁時提供紙張翻摺陰影與沙沙紙張翻頁聲，並使用「書籤」、「螢光筆劃記」與「書架」來組織收藏，介面詞彙亦使用讀者熟悉的「章節」、「目錄」而非底層工程術語。這項設計最直接體現了哪一項易用性原則？
A) NS01 清楚的系統狀態能見度 (Visibility of System Status)
B) NS02 與真實世界對應 (Match Between System and Real World)
C) NS04 一致性與標準 (Consistency and Standards)
D) NS06 易於識別而非記憶 (Recognition Rather Than Recall)

<details>
<summary>點擊查看答案與解析</summary>

**正確答案**：B
**解析**：使用真實實體世界的物件（書架、書籤、紙張質感）與日常概念作為隱喻，使用使用者熟悉的領域語言而非系統工程術語，符合 NS02 (與真實世界對應)。
</details>

---

**第 3 題：【批次操作的緊急出口】**
使用者在照片管理工具中勾選了 50 張照片並點擊「全數封存」，畫面底部立即彈出 SnackBar 提示：「已封存 50 張照片」，並在旁邊提供明顯的「復原 (Undo)」按鈕，且提供 10 秒的反悔猶豫期。這項設計最直接符合哪一項易用性原則？
A) NS02 與真實世界對應 (Match Between System and Real World)
B) NS03 使用者控制與自由 (User Control and Freedom)
C) NS05 錯誤預防 (Error Prevention)
D) NS08 優雅簡潔的設計 (Aesthetic and Minimalist Design)

<details>
<summary>點擊查看答案與解析</summary>

**正確答案**：B
**解析**：使用者在誤操作時需要一個清楚標記的「緊急出口 (Emergency Exit)」以撤銷操作返回先前狀態，Undo 復原機制賦予使用者充分的操作安全感，符合 NS03 (使用者控制與自由)。
</details>

---

**第 4 題：【全站按鈕規範與平台標準】**
某跨平台購物系統在 iOS App 遵循蘋果 HIG 規範將導覽標籤放在底部，在 Web 則遵循常見的頂部 Header 導航；全站無論在哪個頁面，「加入購物車」一律是深橘色按鈕、「立即結帳」一律是綠色按鈕，危險操作一律是紅色文字。這項設計最直接符合哪一項易用性原則？
A) NS03 使用者控制與自由 (User Control and Freedom)
B) NS04 一致性與標準 (Consistency and Standards)
C) NS06 易於識別而非記憶 (Recognition Rather Than Recall)
D) NS07 彈性與使用效率 (Flexibility and Efficiency of Use)

<details>
<summary>點擊查看答案與解析</summary>

**正確答案**：B
**解析**：兼顧了「外部一致性」（適配平台既有慣例）與「內部一致性」（全站統一顏色編碼與按鈕意圖），讓使用者不需猜測不同文字或按鈕代表的含義，符合 NS04 (一致性與標準)。
</details>

---

**第 5 題：【新手視覺按鈕與專家快捷鍵】**
現代程式碼編輯器（如 VS Code）為新手提供視覺化的功能選單與側邊欄按鈕，同時為資深工程師提供強大的快捷鍵（如 `Cmd + P` 快速開檔、`Cmd + Shift + L` 多游標編輯），並允許自訂程式碼片段 (Snippets) 與巨集。這項設計最直接符合哪一項易用性原則？
A) NS03 使用者控制與自由 (User Control and Freedom)
B) NS05 錯誤預防 (Error Prevention)
C) NS07 彈性與使用效率 (Flexibility and Efficiency of Use)
D) NS09 清楚的錯誤處理 (Help Users Recognize, Diagnose, and Recover from Errors)

<details>
<summary>點擊查看答案與解析</summary>

**正確答案**：C
**解析**：系統提供加速鍵 (Accelerators) 與客製化捷徑，同時包容無經驗新手與追求極致速度的高頻率資深用戶，提升操作效率，符合 NS07 (彈性與使用效率)。
</details>

---

**第 6 題：【AI-UX 概念：1-10-100 品質成本法則】**
開發團隊在專案初期運用 AI 生成前端原型時，即在提示詞中明確定義防呆約束與錯誤復原指引，及早發現並修復體驗瑕疵。相較於系統上線後因使用者客訴才動員十倍人力進行重構修復，這種在前端即落實 UX 的做法最直接體現了哪一項核心定律？
A) 摩爾定律 (Moore's Law)
B) 1-10-100 品質成本法則 (Cost of Quality Rule)
C) 阿姆達爾定律 (Amdahl's Law)
D) 康威定律 (Conway's Law)

<details>
<summary>點擊查看答案與解析</summary>

**正確答案**：B
**解析**：1-10-100 成本法則指出：在概念/設計階段預防問題成本為 1，在開發階段修正為 10，等到上線維護階段修復則高達 100。透過 AI for UX 在生成原型初期即注入易用性約束，能大幅壓低品質缺陷成本。
</details>

---

**第 7 題：【AI-UX 提示工程：RTCF 框架中的 UX 約束】**
工程師撰寫提示詞：「你是一位 UI 設計師（Role），請設計電商購物車結帳頁（Task）。**【約束：載入時必須顯示骨架屏 (Skeleton Screen) 消除等待焦慮，且 API 斷線時必須以白話說明並提供重試按鈕，嚴禁僅拋出無說明的狀態碼】**（Constraints），請以 React 輸出（Format）。」請問提示詞中針對 Constraints 的具體要求，最主要是為了確保 AI 生成的介面滿足哪兩項尼爾森原則？
A) NS02 (與真實世界對應) 與 NS04 (一致性與標準)
B) NS01 (系統狀態能見度) 與 NS09 (清楚的錯誤處理)
C) NS06 (易於識別而非記憶) 與 NS08 (優雅簡潔的設計)
D) NS03 (使用者控制權) 與 NS07 (彈性與使用效率)

<details>
<summary>點擊查看答案與解析</summary>

**正確答案**：B
**解析**：骨架屏提供清晰的加載狀態感知，符合 NS01 (系統狀態能見度)；斷線時以通俗語言說明並提供重試按鈕，符合 NS09 (清楚的錯誤處理)。這正是 RTCF 提示框架中將 UX 易用性指標轉化為 AI 生成約束的標準實踐。
</details>
