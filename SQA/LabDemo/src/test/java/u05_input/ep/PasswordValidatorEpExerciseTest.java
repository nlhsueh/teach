package u05_input.ep;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 🧪 課堂動手練習 (Exercise 5.4)：密碼格式等價類分割 (EP) 測試
 * 
 * 業務規格：
 * 1. 長度介於 8 ~ 20 字元：
 *    - < 8 或 > 20 或 null：無效等價類，必須拋出 IllegalArgumentException。
 * 2. 內容必須同時具備「英文字母」與「數字」：
 *    - 兩者皆有 ➔ true (有效等價類)。
 *    - 僅有英文字母或僅有數字 ➔ false (弱密碼等價類)。
 */
@DisplayName("Unit 5.4 練習：密碼格式等價類分割練習題")
public class PasswordValidatorEpExerciseTest {

    // =========================================================================
    // 💡 練習 1 提示 (Hints)：有效等價類測試 (Valid Equivalence Class)
    // 1. 長度在 [8, 20] 且同時包含英文字母與數字。
    // 2. 預期回傳值皆為 true。
    // =========================================================================
    @ParameterizedTest(name = "有效密碼測試 - \"{0}\" ➔ 預期合格")
    @DisplayName("練習 1：驗證有效等價類密碼 (長度合格且包含字母與數字)")
    @ValueSource(strings = {
            "Admin1234",          // 一般大小寫英數混合
            "Password2026",       // 邊界長度合格
            "A1b2C3d4E5"          // 多字母多數字交錯
    })
    void exercise1_testValidPasswords(String password) {
        // TODO: 呼叫 PasswordValidator.validate(password) 並斷言為 true
        boolean isValid = PasswordValidator.validate(password);
        assertTrue(isValid, "密碼 " + password + " 應判定為合法有效");
    }

    // =========================================================================
    // 💡 練習 2 提示 (Hints)：無效等價類測試 (Invalid Equivalence Class)
    // 1. 單一無效原則：測試異常時，只改變單一變因。
    // 2. 驗證長度不足 (< 8) 或長度過長 (> 20) 時，系統是否依約拋出 IllegalArgumentException。
    // =========================================================================
    @ParameterizedTest(name = "無效長度密碼 - \"{0}\" ➔ 預期拋出例外")
    @DisplayName("練習 2：驗證長度不合格之無效等價類防禦 (拋出 IllegalArgumentException)")
    @ValueSource(strings = {
            "",                   // 長度 0 (極端下界)
            "Ab1",                // 長度 3 (過短)
            "Passw1",             // 長度 6 (過短)
            "ThisIsAVeryLongPasswordExceedingTwentyCharacters123" // 長度 50 (過長)
    })
    void exercise2_testInvalidLengthThrowsException(String invalidPassword) {
        // TODO: 使用 assertThrows 驗證傳入無效密碼時會拋出 IllegalArgumentException
        assertThrows(IllegalArgumentException.class,
                () -> PasswordValidator.validate(invalidPassword),
                "長度不符的密碼必須拋出 IllegalArgumentException");
    }

    // =========================================================================
    // 💡 練習 3 提示 (Hints)：內容弱密碼等價類測試 (Weak Password EP)
    // 1. 長度符合 (8~20)，但「純字母」或「純數字」。
    // 2. 系統不應崩潰或拋例外，而是正常回傳 false。
    // =========================================================================
    @ParameterizedTest(name = "弱密碼測試 - \"{0}\" ➔ 預期 false")
    @DisplayName("練習 3：驗證純字母或純數字之弱密碼等價類")
    @ValueSource(strings = {
            "OnlyLettersPassword",  // 純英文字母，無數字
            "123456789012"          // 純數字，無英文字母
    })
    void exercise3_testWeakPasswordReturnsFalse(String weakPassword) {
        // TODO: 呼叫 PasswordValidator.validate(weakPassword) 並斷言結果為 false
        boolean isValid = PasswordValidator.validate(weakPassword);
        assertFalse(isValid, "純文字或純數字密碼應判定為 false");
    }
}
