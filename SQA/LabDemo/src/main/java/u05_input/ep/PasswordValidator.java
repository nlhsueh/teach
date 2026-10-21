package u05_input.ep;

/**
 * 密碼安全性格式驗證器 (供 Unit 5.4 等價類分割 EP 課堂練習)
 * 
 * 業務規格：
 * 1. 長度規則：密碼長度必須在 8 ~ 20 字元之間 (含 8 與 20)。
 *    - 若為 null 或長度不在 [8, 20] 區間，視為【無效等價類】，必須拋出 IllegalArgumentException。
 * 2. 內容規則：密碼必須同時包含「至少一個英文字母」與「至少一個數字 (0-9)」。
 *    - 符合條件者回傳 true (有效等價類)。
 *    - 缺少英文字母或數字者回傳 false (弱密碼等價類)。
 */
public class PasswordValidator {

    public static boolean validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("密碼不可為 null");
        }

        int length = password.length();
        if (length < 8 || length > 20) {
            throw new IllegalArgumentException("密碼長度必須介於 8 至 20 個字元之間，目前長度: " + length);
        }

        boolean hasLetter = false;
        boolean hasDigit = false;

        for (char c : password.toCharArray()) {
            if (Character.isLetter(c)) {
                hasLetter = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            }
        }

        return hasLetter && hasDigit;
    }
}
