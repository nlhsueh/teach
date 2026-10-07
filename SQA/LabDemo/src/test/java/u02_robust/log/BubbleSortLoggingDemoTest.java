package u02_robust.log;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Ch02 穩健程式設計：氣泡排序日誌機制單元測試")
class BubbleSortLoggingDemoTest {

    @Test
    @DisplayName("正常陣列排序應正確遞增並輸出 INFO 日誌")
    void testNormalSort() {
        int[] data = {5, 2, 8, 1, 9};
        int[] sorted = BubbleSortLoggingDemo.sortWithLogging(data);
        assertArrayEquals(new int[]{1, 2, 5, 8, 9}, sorted);
    }

    @Test
    @DisplayName("單元素陣列應觸發 WARN 警訊並原樣返回")
    void testSingleElementSort() {
        int[] data = {100};
        int[] sorted = BubbleSortLoggingDemo.sortWithLogging(data);
        assertArrayEquals(new int[]{100}, sorted);
    }

    @Test
    @DisplayName("傳入 null 應記錄 ERROR 並拋出 IllegalArgumentException")
    void testNullArrayThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> BubbleSortLoggingDemo.sortWithLogging(null));
    }

    @Test
    @DisplayName("MDC 任務追蹤排序應順利執行且清空 MDC 上下文")
    void testMdcSort() {
        int[] data = {3, 1, 2};
        assertDoesNotThrow(() -> BubbleSortLoggingDemo.sortTaskWithMdc("TASK-UNIT-01", "Tester", data));
        assertArrayEquals(new int[]{1, 2, 3}, data);
    }
}
