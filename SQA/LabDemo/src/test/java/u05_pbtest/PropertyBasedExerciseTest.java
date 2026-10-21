package u05_pbtest;

import net.jqwik.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 🧪 課堂動手練習 (Exercise 5.9-A)：屬性基礎測試 (PBT) 不變量實作
 * 
 * 請閱讀【提示 (Hints)】，補全 // TODO 標記處的程式碼以通過測試。
 */
public class PropertyBasedExerciseTest {

    // =========================================================================
    // 💡 練習 1 提示 (Hints)：乘法交換律不變量 (a * b == b * a)
    // 1. 使用 @Property 與 @ForAll 隨機注入整數 a 與 b。
    // 2. 驗證 MathFunctions.multiply(a, b) 是否等於 MathFunctions.multiply(b, a)。
    // =========================================================================
    @Property
    @Label("練習 1：乘法交換律不變量驗證")
    boolean exercise1_multiplicationIsCommutative(@ForAll int a, @ForAll int b) {
        // TODO: 驗證 a * b 是否恆等於 b * a
        return MathFunctions.multiply(a, b) == MathFunctions.multiply(b, a);
    }

    // =========================================================================
    // 💡 練習 2 提示 (Hints)：反轉串列長度守恆性質
    // 對任意整數清單 L，其反轉後串列 reverse(L) 的元素數量必恆等於原串列長度！
    // =========================================================================
    @Property
    @Label("練習 2：反轉後清單長度守恆不變量")
    boolean exercise2_reversedListLengthInvariant(@ForAll List<Integer> list) {
        // TODO: 呼叫 MathFunctions.reverse(list) 並驗證長度是否相等
        List<Integer> reversed = MathFunctions.reverse(list);
        return list.size() == reversed.size();
    }
}
