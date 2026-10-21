package u05_pbtest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 數學與集合不變量函式庫 (供 Unit 5.9 屬性基礎測試 PBT 與變質測試示範)
 */
public class MathFunctions {

    /**
     * 加法運算
     */
    public static int add(int a, int b) {
        return a + b;
    }

    /**
     * 乘法運算
     */
    public static int multiply(int a, int b) {
        return a * b;
    }

    /**
     * 反轉整數清單
     */
    public static List<Integer> reverse(List<Integer> list) {
        if (list == null) {
            return Collections.emptyList();
        }
        List<Integer> copy = new ArrayList<>(list);
        Collections.reverse(copy);
        return copy;
    }

    /**
     * 排序整數清單
     */
    public static List<Integer> sort(List<Integer> list) {
        if (list == null) {
            return Collections.emptyList();
        }
        List<Integer> copy = new ArrayList<>(list);
        Collections.sort(copy);
        return copy;
    }
}
