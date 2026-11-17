package u06_coverage;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit 06 白箱測試實作：BinarySearch.java 涵蓋度分析
 *
 * 實習手冊：LabDemo/docs/u06_wbtesting/whitebox_test.md
 * 目標：透過 2 組精簡測試案例達成 100% 敘述涵蓋 (SC) 與 100% 分支涵蓋 (BC)！
 */
public class BinarySearchCoverageTest {

    BinarySearch bs = new BinarySearch();

    @Test
    @DisplayName("TC1: 搜尋目標存在 (走左半部折半分支與命中分支)")
    void testSearchFound() {
        int[] array = {1, 3, 5};
        // 第 1 輪 mid=1 (val=3 > 1) 走左半部 (right = mid - 1);
        // 第 2 輪 mid=0 (val=1 == 1) 走命中分支回傳索引 0
        assertEquals(0, bs.search(1, array));
    }

    @Test
    @DisplayName("TC2: 搜尋目標不存在 (走右半部折半分支與迴圈終止分支)")
    void testSearchNotFound() {
        int[] array = {1, 3};
        // 持續往右找，最終 left > right 走迴圈為 False 的跳出分支，回傳 -1
        assertEquals(-1, bs.search(6, array));
    }
}
