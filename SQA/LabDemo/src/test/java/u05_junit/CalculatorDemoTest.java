package u05_junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 💡 課堂示範 (Demo 5.2)：單元測試與 3A 原則入門
 * 
 * 【教學核心觀念】：
 * 1. 3A 原則 (Arrange-Act-Assert) 讓測試案例結構清晰、易讀易維護。
 * 2. assertEquals(預期值, 實際值) 是最核心的內容等價性斷言。
 * 3. assertThrows 用於驗證防禦性例外 (如除以零)。
 * 4. assertAll 群組斷言能夠一次執行多個驗證，避免因單一中斷而掩蓋後續錯誤。
 */
@DisplayName("Unit 5.2 示範：Calculator 計算機單元測試與 3A 原則")
public class CalculatorDemoTest {

    @Test
    @DisplayName("示範 1：基礎加法運算驗證 (經典 3A 結構)")
    void testAdd_standard3A() {
        // -------------------------------------------------------------
        // 1. Arrange (安排準備)：準備受測物件與測試資料
        // -------------------------------------------------------------
        Calculator calculator = new Calculator();
        int a = 10;
        int b = 25;
        int expected = 35;

        // -------------------------------------------------------------
        // 2. Act (執行動作)：呼叫受測方法取得實際結果
        // -------------------------------------------------------------
        int actual = calculator.add(a, b);

        // -------------------------------------------------------------
        // 3. Assert (斷言驗證)：比對實際產出是否符合預期
        // -------------------------------------------------------------
        assertEquals(expected, actual, "10 + 25 應該等於 35");
    }

    @Test
    @DisplayName("示範 2：除法運算與浮點數精度斷言")
    void testDivide_normal() {
        // Arrange
        Calculator calculator = new Calculator();

        // Act
        double result = calculator.divide(10, 4);

        // Assert: 浮點數比對可指定容許誤差 (delta)
        assertEquals(2.5, result, 0.0001, "10 / 4 應該精準等於 2.5");
    }

    @Test
    @DisplayName("示範 3：防禦性例外斷言 (assertThrows)")
    void testDivideByZero_throwsException() {
        Calculator calculator = new Calculator();

        // 驗證當除數為 0 時，系統是否遵循合約拋出 ArithmeticException
        ArithmeticException exception = assertThrows(
                ArithmeticException.class,
                () -> calculator.divide(10, 0),
                "除數為 0 時必須拋出 ArithmeticException"
        );

        // 進一步斷言例外的錯誤訊息是否正確
        assertTrue(exception.getMessage().contains("Division by zero"),
                "例外訊息應明確指出不允許除以零");
    }

    @Test
    @DisplayName("示範 4：群組斷言 (assertAll) 避免測試連鎖中斷")
    void testMultipleCalculations_assertAll() {
        Calculator calculator = new Calculator();

        // assertAll 會確保內部的所有 lambda 都被執行完畢，最後統一彙整所有失敗報告
        assertAll("計算機多項基礎運算驗證",
                () -> assertEquals(15, calculator.add(7, 8), "7 + 8 應為 15"),
                () -> assertEquals(0, calculator.multiply(5, 0), "5 * 0 應為 0"),
                () -> assertEquals(42, calculator.multiply(6, 7), "6 * 7 應為 42")
        );
    }
}
