#!/bin/bash
# ==============================================================================
# Script: zip_labdemo.sh
# Purpose: 自動將 SQA/LabDemo 打包為乾淨的 LabDemo.zip 並發布至 Google Drive gTeachSQA/LabDemo-zip
# ==============================================================================

set -e

# 定位專案根目錄
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
ROOT_DIR="$(cd "$SCRIPT_DIR/.." && pwd)"
SQA_DIR="$ROOT_DIR/SQA"
LABDEMO_DIR="$SQA_DIR/LabDemo"

# 定位 Google Drive 目標目錄
GDRIVE_DIR="$HOME/Library/CloudStorage/GoogleDrive-nlhsueh@gmail.com/我的雲端硬碟/gTEACH/gTeachSQA/LabDemo-zip"

echo "📦 開始打包 SQA/LabDemo..."
echo "  來源路徑: $LABDEMO_DIR"
echo "  目標路徑: $GDRIVE_DIR/LabDemo.zip"

if [ ! -d "$LABDEMO_DIR" ]; then
    echo "❌ 錯誤：找不到來源目錄 $LABDEMO_DIR"
    exit 1
fi

# 確保目標資料夾存在
mkdir -p "$GDRIVE_DIR"

# 暫存 zip 檔路徑
TMP_ZIP="/tmp/LabDemo_temp_$$.zip"
rm -f "$TMP_ZIP"

cd "$SQA_DIR"

# 禁用 macOS 隱藏 resource fork (._*) 並打包，排除 target/、.git/、.DS_Store 等非必要檔案
COPYFILE_DISABLE=1 zip -r -q "$TMP_ZIP" LabDemo \
    -x "LabDemo/target/*" \
    -x "LabDemo/target" \
    -x "*/.DS_Store" \
    -x "LabDemo/.git/*" \
    -x "*/__MACOSX/*" \
    -x "LabDemo/logs/*"

# 驗證 zip 完整性
zip -T -q "$TMP_ZIP"
if [ $? -ne 0 ]; then
    echo "❌ 錯誤：Zip 檔案驗證失敗！"
    rm -f "$TMP_ZIP"
    exit 1
fi

# 原子性移動覆蓋
mv -f "$TMP_ZIP" "$GDRIVE_DIR/LabDemo.zip"

ZIP_SIZE=$(ls -lh "$GDRIVE_DIR/LabDemo.zip" | awk '{print $5}')
echo "✅ 打包完成！"
echo "  檔案位置: $GDRIVE_DIR/LabDemo.zip"
echo "  檔案大小: $ZIP_SIZE"
