package u04_inspection;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 這是教學示範用的 Bubble Sort 類別（包含多種刻意設計的 Code Smells 與 PMD 違規）。
 * 
 * 對應 PMD 規則分類：
 * 1. Best Practices: UseEqualsToCompareStrings, AvoidInstantiatingObjectsInLoops
 * 2. Code Style: MethodNamingConventions, VariableNamingConventions, UseBraces, AvoidMagicNumbers, UnnecessarySemicolon
 * 3. Error Prone: EmptyCatchBlock, AvoidCatchingGenericException
 * 4. Documentation: 缺少適當長度與格式之 Javadoc
 * 5. Design: 圈複雜度過高、上帝方法
 */
public class BubbleSortBadSmellDemo {

    // ❌ PMD: FieldNamingConventions (成員變數未遵循小駝峰命名法)
    private int Swap_Count = 0;

    // ❌ PMD: MissingJavadocMethod (缺少公開方法的 Javadoc 註解)
    // ❌ PMD: MethodNamingConventions (方法名稱未遵循小駝峰命名法)
    // ❌ PMD: CyclomaticComplexity / ExcessiveMethodLength (圈複雜度過高、方法過長)
    public int[] Do_Bubble_Sort(int[] Arr, String Sort_Order) {
        
        // ❌ PMD: AvoidMagicNumbers (出現未命名的魔術數字 1000)
        if (Arr != null && Arr.length > 1000) {
            System.out.println("陣列長度過長！");
            return Arr;
        }

        // ❌ PMD: UseEqualsToCompareStrings (字串比較應使用 .equals() 而非 ==)
        boolean isAscending = true;
        if (Sort_Order == "DESC") {
            isAscending = false;
        } else if (Sort_Order == "ASC") {
            isAscending = true;
        }

        if (Arr == null || Arr.length <= 1) {
            return Arr;
        }

        int n = Arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                
                // ❌ PMD: AvoidInstantiatingObjectsInLoops (在巢狀迴圈內部頻繁創建物件，造成不必要的記憶體與 GC 負擔)
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String timestamp = sdf.format(new Date());

                boolean shouldSwap = false;
                if (isAscending) {
                    if (Arr[j] > Arr[j + 1]) {
                        shouldSwap = true;
                    }
                } else {
                    if (Arr[j] < Arr[j + 1]) {
                        shouldSwap = true;
                    }
                }

                if (shouldSwap) {
                    // ❌ PMD: UseBraces (if/else 或迴圈陳述句缺少大括號)
                    int Temp_Val = Arr[j];
                    Arr[j] = Arr[j + 1];
                    Arr[j + 1] = Temp_Val;
                    Swap_Count++;
                }
            }
        }

        // ❌ PMD: EmptyCatchBlock, AvoidCatchingGenericException
        try {
            // 模擬潛在的記錄或監控操作
            if (Swap_Count < 0) {
                throw new IllegalArgumentException("交換次數異常");
            }
        } catch (Exception e) {
            // ❌ 空的 catch 區塊，吞掉異常
        }

        return Arr;
    }; // ❌ PMD: UnnecessarySemicolon (多餘的分號)

    /**
     * 示範合理壓制違規 (Suppression Demo)：
     * 使用 @SuppressWarnings 與 // NOPMD 來豁免特定規則檢查。
     *
     * @param source 來源陣列
     * @return 複製之陣列
     */
    @SuppressWarnings("PMD.AvoidArrayLoops")
    public int[] copyArrayDemo(int[] source) {
        if (source == null) {
            return new int[0];
        }
        int[] destination = new int[source.length];
        // 刻意使用手動迴圈複製，通常 PMD 會建議使用 System.arraycopy
        // 這裡透過 @SuppressWarnings("PMD.AvoidArrayLoops") 成功壓制警告
        for (int i = 0; i < source.length; i++) {
            destination[i] = source[i]; // NOPMD - 教學展示行層級壓制
        }
        return destination;
    }

    /**
     * 取得交換次數。
     *
     * @return 總交換次數
     */
    public int getSwapCount() {
        return Swap_Count;
    }
}
