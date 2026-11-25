package u06_mutation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit 06 PITest 變異測試實戰範例：BinarySearch
 *
 * 執行指令（於 LabDemo 目錄下）：
 *   mvn test-compile org.pitest:pitest-maven:mutationCoverage \
 *       -DtargetClasses="u06_mutation.BinarySearch" \
 *       -DtargetTests="u06_mutation.BinarySearchPitestTest"
 *
 * 報表位置：target/pit-reports/index.html
 */
@DisplayName("PITest 變異測試：BinarySearch 二元搜尋")
class BinarySearchPitestTest {

    private final BinarySearch bs = new BinarySearch();

    @Test
    @DisplayName("空陣列與單元素陣列（獵殺 left <= right 邊界變異體）")
    void testEmptyAndSingleElement() {
        assertEquals(-1, bs.search(5, new int[]{}));
        assertEquals(0, bs.search(5, new int[]{5}));
        assertEquals(-1, bs.search(3, new int[]{5}));
    }

    @Test
    @DisplayName("命中左端點、中間點與右端點（獵殺 mid + 1 / mid - 1 變異體）")
    void testFoundAtBoundariesAndMiddle() {
        int[] data = {1, 3, 5, 7, 9};
        assertEquals(0, bs.search(1, data));
        assertEquals(1, bs.search(3, data));
        assertEquals(2, bs.search(5, data));
        assertEquals(3, bs.search(7, data));
        assertEquals(4, bs.search(9, data));
    }

    @Test
    @DisplayName("搜尋不存在的目標值（小於最小值、介於中間、大於最大值）")
    void testNotFoundCases() {
        int[] data = {1, 3, 5, 7, 9};
        assertEquals(-1, bs.search(0, data));
        assertEquals(-1, bs.search(4, data));
        assertEquals(-1, bs.search(10, data));
    }
}
