package u05_junit;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 💡 課堂示範：JUnit 5 測試生命週期 (Test Lifecycle)
 * 
 * 執行順序展示：
 * @BeforeAll (類別等級，執行 1 次)
 *   ➔ @BeforeEach (每個測試前執行) ➔ @Test 1 ➔ @AfterEach (每個測試後執行)
 *   ➔ @BeforeEach (每個測試前執行) ➔ @Test 2 ➔ @AfterEach (每個測試後執行)
 * ➔ @AfterAll (類別等級，最後執行 1 次)
 */
@DisplayName("Unit 5.2 示範：測試生命週期展示")
public class LifeCycleDemoTest {

    private Calculator calculator;

    @BeforeAll
    static void setupAll() {
        System.out.println("  [LifeCycle] @BeforeAll: 全套測試開始前執行一次 (例如：連線資料庫、初始化環境)");
    }

    @BeforeEach
    void setupEach() {
        System.out.println("    [LifeCycle] @BeforeEach: 每個測試方法執行前重置受測物件，確保測試隔離無副作用");
        calculator = new Calculator();
    }

    @Test
    @DisplayName("測試加法 (觀察生命週期)")
    void testMethodOne() {
        System.out.println("      >> 執行測試方法一...");
        assertEquals(4, calculator.add(2, 2));
    }

    @Test
    @DisplayName("測試乘法 (觀察生命週期)")
    void testMethodTwo() {
        System.out.println("      >> 執行測試方法二...");
        assertEquals(9, calculator.multiply(3, 3));
    }

    @AfterEach
    void cleanupEach() {
        System.out.println("    [LifeCycle] @AfterEach: 每個測試方法執行後清理資源");
    }

    @AfterAll
    static void cleanupAll() {
        System.out.println("  [LifeCycle] @AfterAll: 全套測試結束後執行一次 (例如：關閉連線、釋放快取)");
    }
}
