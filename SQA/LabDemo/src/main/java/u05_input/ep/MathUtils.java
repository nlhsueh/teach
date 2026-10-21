package u05_input.ep;

/**
 * 數學輔助工具類別 (供 Unit 5.4 參數化測試與等價類示範)
 */
public class MathUtils {

    /**
     * 質數判斷方法
     */
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
