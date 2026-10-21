package u05_scenario.state;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 💡 課堂示範 (Demo 5.8)：狀態轉換測試 (State Transition Testing) 與物件狀態機
 * 
 * 【教學核心觀念】：
 * 1. 狀態機核心要素：當前狀態 (Current State)、觸發事件 (Event/Trigger)、保護條件 (Guard)、目標狀態 (Next State)。
 * 2. 狀態覆蓋 (0-Switch Coverage)：確保系統中的每一個離散狀態（如：Empty, Non-Empty, Full）皆至少被造訪一次。
 * 3. 轉移覆蓋：確保所有合法的狀態轉移路徑 (Transitions) 皆被執行驗證。
 * 4. 狀態不變量 (State Invariants)：在特定狀態下，物件必須恆常滿足的屬性 (例如：Empty 狀態下 size 必為 0)。
 */
@DisplayName("Unit 5.8 示範：Stack 堆疊狀態轉換測試")
public class StackStateDemoTest {

    private Stack<String> stack;

    @Nested
    @DisplayName("狀態 1：【空狀態 (Empty State)】下的行為與轉移")
    class EmptyStateTests {

        @BeforeEach
        void createEmptyStack() {
            // 初始化為全新的空堆疊
            stack = new Stack<>();
        }

        @Test
        @DisplayName("驗證空狀態不變量：isEmpty 必為 true 且 isFull 為 false")
        void testEmptyInvariants() {
            assertTrue(stack.isEmpty(), "新建立之堆疊應為空狀態");
            assertFalse(stack.isFull(), "空堆疊不可為滿");
        }

        @Test
        @DisplayName("事件轉移：在空狀態呼叫 push ➔ 轉移至【非空狀態 (Non-Empty)】")
        void testTransition_EmptyToNonEmpty() {
            stack.push("Item 1");

            assertFalse(stack.isEmpty(), "Push 後應離開空狀態");
            assertEquals("Item 1", stack.peek(), "頂端元素應為剛 push 之項目");
        }

        @Test
        @DisplayName("非法轉移防禦：在空狀態呼叫 pop ➔ 拋出 EmptyStackException")
        void testIllegalTransition_PopOnEmpty() {
            assertThrows(EmptyStackException.class, () -> stack.pop(),
                    "在空堆疊執行 pop 必須拋出 EmptyStackException");
        }
    }

    @Nested
    @DisplayName("狀態 2：【滿狀態 (Full State)】下的行為與轉移")
    class FullStateTests {

        @BeforeEach
        void fillStackToMax() {
            stack = new Stack<>();
            // MAX_SIZE = 5，連續 push 5 個元素到達滿狀態
            for (int i = 1; i <= 5; i++) {
                stack.push("Item " + i);
            }
        }

        @Test
        @DisplayName("驗證滿狀態不變量：isFull 必為 true")
        void testFullInvariants() {
            assertTrue(stack.isFull(), "包含 5 個元素時應為滿狀態");
        }

        @Test
        @DisplayName("非法轉移防禦：在滿狀態呼叫 push ➔ 拋出 IllegalStateException (Stack Overflow)")
        void testIllegalTransition_PushOnFull() {
            assertThrows(IllegalStateException.class, () -> stack.push("Item 6"),
                    "滿狀態再 push 必須拋出 IllegalStateException 防止溢位");
        }

        @Test
        @DisplayName("事件轉移：在滿狀態呼叫 pop ➔ 轉移至【非滿狀態 (Non-Empty)】")
        void testTransition_FullToNonEmpty() {
            String popped = stack.pop();

            assertEquals("Item 5", popped, "應彈出最後一個推入之元素");
            assertFalse(stack.isFull(), "Pop 一次後應離開滿狀態");
        }
    }
}
