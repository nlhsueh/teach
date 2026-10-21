package u05_input.ep;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 💡 課堂示範 (Demo 5.4)：等價類分割測試 (Equivalence Partitioning, EP)
 * 
 * 【教學核心觀念】：
 * 1. 等價劃分思維：將龐大的輸入域劃分為若干等價類別，同一個類別內的任一測資，對揭露缺陷具有相同效力。
 * 2. 二元搜尋的等價類維度：
 *    - 維度 1 (陣列長度)：空陣列、單元素、多元素。
 *    - 維度 2 (目標命中位置)：命中頭部、中間、尾部、不存在。
 *    - 維度 3 (輸入合法性)：有效陣列 vs. null 異常。
 * 3. 單一無效原則：測試無效等價類時，一次只能包含一個無效條件，避免「錯誤遮蔽 (Error Masking)」。
 */
@DisplayName("Unit 5.4 示範：二元搜尋等價類分割測試 (EP)")
public class BinarySearchEpDemoTest {

    private final BinarySearch binarySearch = new BinarySearch();

    @Test
    @DisplayName("示範 1：有效等價類 - 單元素陣列 (命中 vs. 沒找到)")
    void testSingleElementArray() {
        int[] array = {7};

        // 有效等價類 A：目標存在於單元素陣列中
        BinarySearch.Result r1 = binarySearch.search(7, array);
        assertTrue(r1.found, "目標 7 應該存在");
        assertEquals(0, r1.index, "索引位置應為 0");

        // 有效等價類 B：目標不存在於單元素陣列中
        BinarySearch.Result r2 = binarySearch.search(8, array);
        assertFalse(r2.found, "目標 8 不存在");
        assertEquals(-1, r2.index, "未找到索引應為 -1");
    }

    @Test
    @DisplayName("示範 2：有效等價類 - 多元素陣列命中不同位置 (頭部、中間、尾部)")
    void testMultipleElementArray_hitPositions() {
        int[] array = {2, 5, 8, 12, 19, 25, 33};

        assertAll("多元素命中位置測試",
                // 命中頭部 (Leftmost boundary)
                () -> {
                    BinarySearch.Result r = binarySearch.search(2, array);
                    assertTrue(r.found);
                    assertEquals(0, r.index, "應該命中陣列第 0 個位置 (頭部)");
                },
                // 命中中間 (Median)
                () -> {
                    BinarySearch.Result r = binarySearch.search(12, array);
                    assertTrue(r.found);
                    assertEquals(3, r.index, "應該命中陣列第 3 個位置 (中間)");
                },
                // 命中尾部 (Rightmost boundary)
                () -> {
                    BinarySearch.Result r = binarySearch.search(33, array);
                    assertTrue(r.found);
                    assertEquals(6, r.index, "應該命中陣列第 6 個位置 (尾部)");
                },
                // 未命中 (介於元素間之不存在值)
                () -> {
                    BinarySearch.Result r = binarySearch.search(10, array);
                    assertFalse(r.found);
                    assertEquals(-1, r.index, "10 不存在陣列中，應回傳 -1");
                }
        );
    }

    @Test
    @DisplayName("示範 3：極限邊界等價類 - 空陣列搜尋")
    void testEmptyArray() {
        int[] emptyArray = {};
        BinarySearch.Result r = binarySearch.search(100, emptyArray);
        assertFalse(r.found, "在空陣列中搜尋任何數皆應回傳未找到");
        assertEquals(-1, r.index);
    }

    @Test
    @DisplayName("示範 4：無效等價類 - 輸入 null 陣列防禦性例外")
    void testNullArray_throwsException() {
        // 單一無效原則：測試 null 陣列輸入時，確認系統依約拋出例外，而非 NullPointerException 崩潰
        assertThrows(IllegalArgumentException.class,
                () -> binarySearch.search(5, null),
                "傳入 null 陣列必須拋出 IllegalArgumentException"
        );
    }
}
