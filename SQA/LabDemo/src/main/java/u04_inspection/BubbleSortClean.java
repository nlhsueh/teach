package u04_inspection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * BubbleSortClean 提供符合 PMD 規範的氣泡排序典範。
 */
public class BubbleSortClean {

    private static final Logger LOGGER = LogManager.getLogger(BubbleSortClean.class);

    /** 最大支援長度。 */
    public static final int MAX_SIZE = 10_000;

    /** 排序方向。 */
    public enum Direction {
        ASCENDING,
        DESCENDING
    }

    private int swapCount;

    /** 建構子。 */
    public BubbleSortClean() {
        this.swapCount = 0;
    }

    /**
     * 對陣列進行氣泡排序。
     *
     * @param array 待排序陣列
     * @param direction 排序方向
     * @return 排序後陣列
     */
    public int[] sort(final int[] array, final Direction direction) {
        if (array == null || array.length <= 1) {
            return array;
        }

        if (direction == null) {
            throw new IllegalArgumentException("排序方向不可為 null");
        }

        if (array.length > MAX_SIZE) {
            throw new IllegalArgumentException("長度超出限制: " + MAX_SIZE);
        }

        final int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < length - i - 1; j++) {
                if (needSwap(array[j], array[j + 1], direction)) {
                    swap(array, j, j + 1);
                    this.swapCount++;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }

        LOGGER.debug("總交換次數: {}", this.swapCount);
        return array;
    }

    /**
     * 判定是否需要交換。
     */
    private boolean needSwap(final int current, final int next, final Direction direction) {
        if (direction == Direction.ASCENDING) {
            return current > next;
        }
        return current < next;
    }

    /**
     * 交換相鄰元素。
     */
    private void swap(final int[] array, final int first, final int second) {
        final int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    /**
     * 取得交換次數。
     *
     * @return 交換次數
     */
    public int getSwapCount() {
        return this.swapCount;
    }
}
