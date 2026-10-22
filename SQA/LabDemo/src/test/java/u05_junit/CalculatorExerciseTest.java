package u05_junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 🧪 課堂動手練習 (Exercise 5.2)：JUnit 5 基礎練習
 * 
 * 請閱讀每個測試方法的【提示 (Hints)】，補全 // TODO 標記處的程式碼以通過測試。
 */
@DisplayName("Unit 5.2 練習：Calculator 計算機練習題")
public class CalculatorExerciseTest {

    // =========================================================================
    // 💡 練習 1 提示 (Hints)：
    // 1. 題目目標：驗證 Calculator 的 subtract (減法) 方法。
    // 2. 請遵守 3A 原則：
    //    - Arrange：初始化 Calculator 物件。
    //    - Act：呼叫 calculator.subtract(20, 7)。
    //    - Assert：使用 assertEquals 驗證結果是否為 13。
    // =========================================================================
    @Test
    @DisplayName("練習 1：實作減法運算的 3A 測試")
    void exercise1_testSubtract() {
        // [Arrange]
        Calculator calculator = new Calculator();

        // [Act]
        // TODO: 請呼叫 calculator 的 subtract 方法計算 20 - 7，並將結果存入 actual 變數

        // [Assert]
        // TODO: 請撰寫 assertEquals 斷言 actual 是否等於 13
        fail("尚未完成練習 1：請呼叫 subtract(20, 7) 並斷言結果等於 13");
    }

    // =========================================================================
    // 💡 練習 2 提示 (Hints)：
    // 1. 題目目標：驗證負數加法與零的加法。
    // 2. 請使用 assertAll 群組斷言，在一個測試方法內同時驗證：
    //    - (-5) + (-8) 應為 -13
    //    - 100 + 0 應為 100
    // =========================================================================
    @Test
    @DisplayName("練習 2：使用 assertAll 驗證負數與零的加法")
    void exercise2_testNegativeAndZeroAdd() {
        Calculator calculator = new Calculator();

        // TODO: 請在 assertAll 中補全兩個測試斷言：
        // 1. (-5) + (-8) 應等於 -13
        // 2. 100 + 0 應等於 100
        assertAll("負數與零的邊界運算",
                () -> fail("尚未完成練習 2：請補全 (-5) + (-8) 斷言"),
                () -> fail("尚未完成練習 2：請補全 100 + 0 斷言")
        );
    }

    // =========================================================================
    // 💡 練習 3 提示 (Hints)：
    // 1. 題目目標：Person 物件的「內容相等 (assertEquals)」與「同一實體 (assertSame)」差異。
    // 2. 假設有 p1 = new Person("John", "Doe") 與 p2 = new Person("John", "Doe")。
    //    - 兩者姓名相同，使用 assertEquals(p1, p2) 應該為 true。
    //    - 兩者位於不同記憶體位址，使用 assertSame(p1, p2) 應該失敗，使用 assertNotSame(p1, p2) 為 true。
    // =========================================================================
    @Test
    @DisplayName("練習 3：驗證物件內容值相等 vs. 記憶體同一性")
    void exercise3_testObjectEqualityVsIdentity() {
        Person p1 = new Person("John", "Doe");
        Person p2 = new Person("John", "Doe");
        Person p3 = p1; // 指向同一記憶體實體

        // TODO: 請撰寫三個斷言：
        // 1. 驗證 p1 與 p2 的屬性內容相同 (assertEquals)
        // 2. 驗證 p1 與 p2 指向不同記憶體位址 (assertNotSame)
        // 3. 驗證 p1 與 p3 指向相同記憶體位址 (assertSame)
        fail("尚未完成練習 3：請依據上述提示補全三項斷言");
    }
}
