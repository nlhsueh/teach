package u05_pbtest;

import net.jqwik.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 💡 課堂示範 (Demo 5.9-A)：屬性基礎測試 (Property-Based Testing, PBT)
 * 
 * 【教學核心觀念】：
 * 1. 範例測試 (Example-based) vs. 屬性測試 (Property-based)：
 *    - 範例測試只檢驗特例：assert 1 + 2 == 3。
 *    - 屬性測試檢驗普遍真理 (Invariant)：forall a, b: a + b == b + a (交換律)。
 * 2. 海量隨機生成：
 *    - jqwik 引擎會自動產生數千組邊界與極值（如 0, 1, -1, Integer.MAX_VALUE）。
 * 3. 測資收縮 (Shrinking) 機制：
 *    - 當發現失敗反例時，jqwik 不會丟出一個巨大的混亂陣列，而是自動「二分微調」，
 *      找到能夠重現錯誤的最精簡最小反例 (Minimal Counterexample)！
 */
public class PropertyBasedDemoTest {

    @Property
    @Label("示範 1：加法交換律不變量 (Commutative Property: a + b == b + a)")
    boolean additionIsCommutative(@ForAll int a, @ForAll int b) {
        // 不管隨機生成何種整數，加法順序對調後的運算結果必須絕對相等
        return MathFunctions.add(a, b) == MathFunctions.add(b, a);
    }

    @Property
    @Label("示範 2：加法單位元性質 (Identity Element: a + 0 == a)")
    boolean additionHasIdentityElement(@ForAll int a) {
        return MathFunctions.add(a, 0) == a;
    }

    @Property
    @Label("示範 3：反轉兩次回到自身不變量 (reverse(reverse(L)) == L)")
    boolean reverseTwiceIsOriginal(@ForAll List<Integer> list) {
        List<Integer> reversedOnce = MathFunctions.reverse(list);
        List<Integer> reversedTwice = MathFunctions.reverse(reversedOnce);

        // 集合大小必須保持不變
        assertEquals(list.size(), reversedTwice.size());
        // 內容與順序必須完全恢復為原陣列
        return list.equals(reversedTwice);
    }

    @Property
    @Label("示範 4：排序後的單調遞增不變量")
    boolean sortedListIsMonotonic(@ForAll List<Integer> list) {
        List<Integer> sorted = MathFunctions.sort(list);

        // 驗證元素個數守恆
        assertEquals(list.size(), sorted.size());

        // 驗證前一元素必然小於等於後一元素 (單調遞增)
        for (int i = 0; i < sorted.size() - 1; i++) {
            if (sorted.get(i) > sorted.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
