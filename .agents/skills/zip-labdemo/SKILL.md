---
name: zip-labdemo
description: >-
  自動將 SQA/LabDemo 排除暫存檔後打包為 LabDemo.zip，並自動發布覆蓋至 Google Drive gTeachSQA/LabDemo-zip 目錄。
  當使用者說「zip the LabDemo」、「打包 LabDemo」或要求將 LabDemo 壓縮放置於雲端硬碟時觸發。
---

# Zip LabDemo Workflow

## 目的
將最新、乾淨的 `oTeach/SQA/LabDemo` 專案打包為 `LabDemo.zip`，並安全覆蓋至 Google Drive 的 `gTeachSQA/LabDemo-zip/`，供學生在 iLearn 或課堂下載。

## 執行步驟
直接執行自動化腳本：
```bash
/Users/nick-mini-26/oTeach/scripts/zip_labdemo.sh
```

## 腳本規格保證
1. **乾淨排除**：自動排除 `target/`、`.DS_Store`、`logs/*` 與 macOS 的 `._*` 隱藏元資料，避免 Windows/Mac 學生解壓困擾。
2. **完整性校驗**：使用 `zip -T` 驗證壓縮檔健康狀態。
3. **安全更新**：暫存於 `/tmp` 後原子性（Atomic）搬移覆蓋至目標路徑，避免雲端同步鎖死或寫入中斷。
