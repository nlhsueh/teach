package u04_inspection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Unit 04: 氣泡排序功能性驗證測試")
class BubbleSortTest {

    @Test
    @DisplayName("BubbleSortClean: 升冪排序應正確排序陣列")
    void testCleanAscending() {
        BubbleSortClean sorter = new BubbleSortClean();
        int[] input = {5, 2, 8, 1, 9};
        int[] result = sorter.sort(input, BubbleSortClean.Direction.ASCENDING);

        assertArrayEquals(new int[]{1, 2, 5, 8, 9}, result);
        assertTrue(sorter.getSwapCount() > 0);
    }

    @Test
    @DisplayName("BubbleSortClean: 降冪排序應正確排序陣列")
    void testCleanDescending() {
        BubbleSortClean sorter = new BubbleSortClean();
        int[] input = {3, 1, 4, 1, 5, 9};
        int[] result = sorter.sort(input, BubbleSortClean.Direction.DESCENDING);

        assertArrayEquals(new int[]{9, 5, 4, 3, 1, 1}, result);
    }

    @Test
    @DisplayName("BubbleSortClean: 空陣列與單一元素應安全返回")
    void testCleanEdgeCases() {
        BubbleSortClean sorter = new BubbleSortClean();
        assertArrayEquals(new int[]{}, sorter.sort(new int[]{}, BubbleSortClean.Direction.ASCENDING));
        assertArrayEquals(new int[]{42}, sorter.sort(new int[]{42}, BubbleSortClean.Direction.ASCENDING));
        assertNull(sorter.sort(null, BubbleSortClean.Direction.ASCENDING));
    }

    @Test
    @DisplayName("BubbleSortBadSmellDemo: 雖然含有壞味道，功能仍能執行升冪與降冪")
    void testBadSmellDemoSort() {
        BubbleSortBadSmellDemo demo = new BubbleSortBadSmellDemo();
        int[] inputAsc = {4, 1, 3, 2};
        demo.Do_Bubble_Sort(inputAsc, "ASC");
        assertArrayEquals(new int[]{1, 2, 3, 4}, inputAsc);

        int[] inputDesc = {1, 3, 2};
        demo.Do_Bubble_Sort(inputDesc, "DESC");
        assertArrayEquals(new int[]{3, 2, 1}, inputDesc);

        // 測試壓制警告的 copyArrayDemo
        int[] copied = demo.copyArrayDemo(new int[]{10, 20});
        assertArrayEquals(new int[]{10, 20}, copied);
    }

    @Test
    @DisplayName("BubbleSortExercise: 學生練習題目基本排序功能應能運作")
    void testExerciseSort() {
        BubbleSortExercise exercise = new BubbleSortExercise();
        int[] data = {7, 3, 5, 1};
        exercise.bubbleSort(data, "ASC");
        assertArrayEquals(new int[]{1, 3, 5, 7}, data);

        int[] copied = exercise.manualCopy(new int[]{1, 2, 3});
        assertArrayEquals(new int[]{1, 2, 3}, copied);
    }
}
