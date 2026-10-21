package u05_scenario.state;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 🧪 課堂動手練習 (Exercise 5.8)：堆疊 1-Switch 連續狀態轉移與不變量練習
 * 
 * 請閱讀【提示 (Hints)】，補全 // TODO 標記處的程式碼以通過測試。
 */
@DisplayName("Unit 5.8 練習：堆疊連續狀態轉移練習題")
public class StackStateExerciseTest {

    private Stack<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new Stack<>();
    }

    // =========================================================================
    // 💡 練習 1 提示 (Hints)：1-Switch 連續轉移序列 (Empty ➔ Non-Empty ➔ Empty)
    // 1. 初始狀態：Empty
    // 2. 觸發事件 1：push(42) ➔ 進入 Non-Empty
    // 3. 觸發事件 2：pop() ➔ 重新回到 Empty 狀態
    // 4. 驗證最終狀態是否精準維持 isEmpty() == true
    // =========================================================================
    @Test
    @DisplayName("練習 1：驗證 Empty ➔ Non-Empty ➔ Empty 狀態閉環轉移")
    void exercise1_testRoundTripTransition() {
        // [Initial] 初始空狀態
        assertTrue(stack.isEmpty(), "初始應為空");

        // [Event 1] push
        // TODO: 執行 stack.push(42) 並斷言此時 isEmpty 為 false
        stack.push(42);
        assertFalse(stack.isEmpty(), "push 後應離開空狀態");

        // [Event 2] pop
        // TODO: 執行 stack.pop() 並斷言回傳值為 42，且 stack 重新回到 isEmpty == true
        int value = stack.pop();
        assertEquals(42, value, "pop 出的值應為 42");
        assertTrue(stack.isEmpty(), "pop 後應恢復為空狀態");
    }

    // =========================================================================
    // 💡 練習 2 提示 (Hints)：在空狀態執行 peek() 之非法轉移例外防禦
    // 堆疊在空狀態時，呼叫 peek() 應該拋出 EmptyStackException，且堆疊依然保持為空狀態。
    // =========================================================================
    @Test
    @DisplayName("練習 2：驗證空狀態 peek() 之例外防禦與狀態不變量")
    void exercise2_testPeekOnEmptyThrowsException() {
        // TODO: 使用 assertThrows 驗證 stack.peek() 會拋出 EmptyStackException
        assertThrows(EmptyStackException.class, () -> stack.peek(),
                "空堆疊執行 peek 必須拋出 EmptyStackException");

        // 驗證狀態不變量：拋出例外後，物件狀態不可損壞，仍應為空
        assertTrue(stack.isEmpty(), "拋出例外後堆疊依然必須保持為空");
    }
}
