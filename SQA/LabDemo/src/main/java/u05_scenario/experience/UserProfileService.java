package u05_scenario.experience;

import java.util.regex.Pattern;

/**
 * 使用者個人資料管理服務 (供 Unit 5.11 經驗基礎測試：錯誤猜測法 Error Guessing 示範)
 * 
 * 測試挑戰：
 * 規格書往往只寫了正常欄位定義，但經驗豐富的測試者會主動「猜測」以下工程師最常忽略的陷阱：
 * 1. 邊界零除與數值溢位 (Integer.MAX_VALUE)。
 * 2. 僅包含空白字元的字串 ("   ") 是否被 trim() 妥善過濾。
 * 3. NullPointer 防護。
 * 4. 特殊字元探針（SQL 注入、XSS `<script>`、Emoji 4-byte 截斷）。
 */
public class UserProfileService {

    private static final Pattern EMAIL_PATTERN = 
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

    public static class UserProfile {
        public final String username;
        public final String email;
        public final int age;

        public UserProfile(String username, String email, int age) {
            this.username = username;
            this.email = email;
            this.age = age;
        }
    }

    /**
     * 驗證並建立使用者資料
     */
    public UserProfile createUser(String username, String email, int age) {
        // 1. 錯誤猜測防禦：null 與純空白字元
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("使用者名稱不可為空或純空白");
        }

        // 2. 錯誤猜測防禦：XSS 標籤與特殊字元注入
        if (username.contains("<") || username.contains(">") || username.contains("'")) {
            throw new IllegalArgumentException("使用者名稱含有危險特殊字元");
        }

        // 3. Email 格式與 null 防護
        if (email == null || !EMAIL_PATTERN.matcher(email.trim()).matches()) {
            throw new IllegalArgumentException("Email 格式無效");
        }

        // 4. 年齡防禦：負數、過大溢位數值
        if (age <= 0 || age > 150) {
            throw new IllegalArgumentException("年齡必須介於 1 到 150 歲之間");
        }

        return new UserProfile(username.trim(), email.trim(), age);
    }
}
