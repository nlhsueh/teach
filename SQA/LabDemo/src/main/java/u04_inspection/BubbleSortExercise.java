package u04_inspection;

/**
 * 【Unit 04 實習練習】氣泡排序程式碼檢視與重構練習 (BubbleSortExercise)
 * 
 * 說明：
 * 本類別功能可正常執行排序，但程式碼中潛藏多項 Code Smells 與 PMD 規則違規。
 * 請依照實驗手冊 (docs/u04_inspection/pmd.md) 的指引完成以下任務：
 * 
 * - Lab 01: 執行 `mvn pmd:check`，檢視產生的違規報告。
 * - Lab 02: 依 PMD 建議重構程式碼，至少修復 3 項不同類型的違規。
 * - Lab 03: 調整 ruleset.xml，觀察特定自訂規則對建置的影響。
 * - Lab 04: 針對合理且無法修改之特定段落，使用 @SuppressWarnings 或 // NOPMD 進行局部壓制。
 */
public class BubbleSortExercise {

    // ❌ PMD 壞味道 1: 成員變數命名不符合慣例 (FieldNamingConventions)
    // TODO: [Lab 02] 修改為符合 Java 小駝峰規範 (camelCase)
    private int Total_Swaps = 0;

    // ❌ PMD 壞味道 2: 缺少 Javadoc 註解 (CommentRequired)
    // ❌ PMD 壞味道 3: 方法名稱命名不符合規範 (MethodNamingConventions)
    // TODO: [Lab 02] 補齊 Javadoc 說明 (@param, @return) 並改為符合 camelCase 的名稱
    public int[] bubbleSort(int[] data, String mode) {
        if (data == null) {
            return null; // ❌ PMD: NullAssignment
        }

        // ❌ PMD 壞味道 4: 魔術數字 (AvoidMagicNumbers)
        // TODO: [Lab 02] 將 5000 抽取為 private static final int 常數
        if (data.length > 5000) {
            throw new IllegalArgumentException("陣列大小超過上限 5000");
        }

        // ❌ PMD 壞味道 5: 字串比對錯誤使用 == (UseEqualsToCompareStrings)
        // TODO: [Lab 02] 改用 .equalsIgnoreCase() 或定義 Enum
        boolean desc = false;
        if (mode == "DESC") {
            desc = true;
        }

        int n = data.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                
                // ❌ PMD 壞味道 6: 迴圈內重複創建物件 (AvoidInstantiatingObjectsInLoops)
                // TODO: [Lab 02] 將不必要的物件宣告移至迴圈外或改用基本型別
                Integer wrapperJ = Integer.valueOf(data[j]);
                Integer wrapperNext = Integer.valueOf(data[j + 1]);

                boolean needSwap;
                if (desc) {
                    needSwap = wrapperJ.intValue() < wrapperNext.intValue();
                } else {
                    needSwap = wrapperJ.intValue() > wrapperNext.intValue();
                }

                if (needSwap) {
                    // ❌ PMD 壞味道 7: 省略大括號 (UseBraces)
                    // TODO: [Lab 02] 補齊大括號 {}
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    Total_Swaps++;
                }
            }
        }

        // ❌ PMD 壞味道 8: 空的 catch 區塊 (EmptyCatchBlock)
        // TODO: [Lab 02] 妥善處理例外或移除無意義的 try-catch
        try {
            if (data.length == 0) {
                // 模擬檢查
            }
        } catch (Exception e) {
            // 空區塊吞掉異常
        }

        return data;
    }

    /**
     * 複製陣列輔助方法。
     *
     * 【Lab 04 練習目標】：
     * PMD 的 AvoidArrayLoops 規則通常建議使用 System.arraycopy()。
     * 若團隊因特定教學或效能考量堅持保留手動迴圈，請在此處練習使用 @SuppressWarnings 或 // NOPMD 壓制警告。
     *
     * @param source 原始陣列
     * @return 複製後之陣列
     */
    // TODO: [Lab 04] 在此處加上 @SuppressWarnings("PMD.AvoidArrayLoops")
    public int[] manualCopy(int[] source) {
        if (source == null) {
            return new int[0];
        }
        int[] result = new int[source.length];
        for (int i = 0; i < source.length; i++) {
            result[i] = source[i]; // TODO: [Lab 04] 亦可在此行後加上 // NOPMD - Reason
        }
        return result;
    }

    /**
     * 取得累積交換次數。
     *
     * @return 交換次數
     */
    public int getTotalSwaps() {
        return Total_Swaps;
    }
}
