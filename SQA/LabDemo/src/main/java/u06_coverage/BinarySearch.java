package u06_coverage;

/**
 * 設計一個 `BinarySearch` 類別，包含 `search(int key, int[] array)` 方法，
 * 該方法接受一個目標數字 `key` 和已排序的整數陣列 `array`，並回傳一個整數表示該資料所在位置；
 * 如果沒有找到，就回傳 -1。
 *
 * 供 Unit 06 迴圈涵蓋度與分支涵蓋度實作示範。
 */
public class BinarySearch {

    public int search(int key, int[] array) {
        int left = 0;
        int right = array.length - 1;

        // B1: 迴圈判定分支 (left <= right)
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // B2: 命中目標分支 (array[mid] == key)
            if (array[mid] == key) {
                return mid;
            }

            // B3: 折半搜尋方向分支
            if (array[mid] < key) {
                left = mid + 1;  // 往右半部找
            } else {
                right = mid - 1; // 往左半部找
            }
        }

        return -1; // 搜尋失敗
    }
}
