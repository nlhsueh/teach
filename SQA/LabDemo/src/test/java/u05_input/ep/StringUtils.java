package u05_input.ep;

/**
 * 字串輔助工具類別 (供 Unit 5.4 參數化測試示範)
 */
public class StringUtils {

    /**
     * 檢查字串是否為回文 (Palindrome)
     */
    public static boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        String clean = s.replaceAll("\\s+", "").toLowerCase();
        int left = 0;
        int right = clean.length() - 1;
        while (left < right) {
            if (clean.charAt(left) != clean.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
