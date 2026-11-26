package u06_coverage;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit 06 Lab 2 練習：BinarySearch.java 白箱涵蓋度分析 (Exercise)
 *
 * 實習手冊：LabDemo/docs/u06_wbtesting/whitebox_test.md
 * 說明：本檔案目前僅提供 1 組基礎測資（部分涵蓋度）。
 * 請先執行 IntelliJ Run with Coverage 或：
 *   mvn clean test -Dtest=BinarySearchCoverageExerciseTest jacoco:report
 * 觀察 JaCoCo 報告中的紅行與黃色菱形，補齊剩餘測試案例直到 Line 與 Branch 涵蓋度皆達 100%！
 */
@DisplayName("Unit 06 Lab 2 練習：BinarySearch 白箱涵蓋度分析")
public class BinarySearchCoverageExerciseTest {

    BinarySearch bs = new BinarySearch();

    @Test
    @DisplayName("TC1 (範例)：目標值剛好在正中間，第一輪即命中")
    void testSearchFoundAtMiddle() {
        int[] array = {1, 3, 5};
        // 第 1 輪 mid = 1 (array[1] == 3) 直接命中回傳 1
        // 思考：此時左半部搜尋、右半部搜尋、以及找不到的迴圈終止分支都尚未覆蓋！
        assertEquals(1, bs.search(3, array));
    }

    // =========================================================================
    // TODO 1：補寫「往左半部折半搜尋並命中」的測試案例（覆蓋 array[mid] > key 分支）
    // 提示：例如在 {1, 3, 5} 中搜尋 1，預期回傳索引 0
    // =========================================================================

    // =========================================================================
    // TODO 2：補寫「往右半部折半搜尋並命中」的測試案例（覆蓋 array[mid] < key 分支）
    // 提示：例如在 {1, 3, 5} 中搜尋 5，預期回傳索引 2
    // =========================================================================

    // =========================================================================
    // TODO 3：補寫「搜尋目標不存在」的測試案例（覆蓋 while 迴圈終止並回傳 -1）
    // 提示：例如在 {1, 3, 5} 中搜尋 6（或空陣列 {}），預期回傳 -1
    // =========================================================================
}
