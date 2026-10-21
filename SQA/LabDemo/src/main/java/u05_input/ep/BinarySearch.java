package u05_input.ep;

/**
 * 二元搜尋演算法 (供 Unit 5.4 等價類分割 EP 教學與實作)
 * 
 * 測試等價劃分維度：
 * 1. 陣列長度維度：空陣列 (長度 0)、單元素陣列、多元素陣列。
 * 2. 目標元素命中位置：命中於頭部、中間、尾部、不存在。
 * 3. 陣列指標與防禦邊界。
 */
public class BinarySearch {

    public static class Result {
        public final boolean found;
        public final int index;

        public Result(boolean found, int index) {
            this.found = found;
            this.index = index;
        }

        @Override
        public String toString() {
            return "Result{found=" + found + ", index=" + index + "}";
        }
    }

    /**
     * 在已排序的 int 陣列中尋找指定 key
     * @param key 欲尋找之目標值
     * @param array 已遞增排序之整數陣列 (若為 null 拋出 IllegalArgumentException)
     * @return 包含命中狀態與索引的 Result 物件
     */
    public Result search(int key, int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("陣列不可為 null");
        }

        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            // 防溢位寫法：避免 (left + right) 造成整數溢位
            int mid = left + (right - left) / 2;

            if (array[mid] == key) {
                return new Result(true, mid);
            }

            if (array[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return new Result(false, -1);
    }
}
