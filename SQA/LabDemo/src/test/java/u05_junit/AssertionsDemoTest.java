package u05_junit;

import static java.time.Duration.ofMillis;
import static java.time.Duration.ofMinutes;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.CountDownLatch;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 💡 課堂示範：JUnit 5 常用斷言 (Assertions) 大全
 * 
 * 涵蓋：
 * - 標準斷言 (assertEquals, assertTrue)
 * - 延遲求值訊息 (Lazy Messages)
 * - 群組斷言 (assertAll)
 * - 相依性斷言 (Dependent Assertions)
 * - 防禦性例外斷言 (assertThrows)
 * - 逾時測試 (assertTimeout)
 */
@DisplayName("Unit 5.2 示範：JUnit 5 常用斷言語法大全")
public class AssertionsDemoTest {

    private final Calculator calculator = new Calculator();
    private final Person person = new Person("Jane", "Doe");

    @Test
    @DisplayName("1. 標準斷言與延遲求值訊息")
    void standardAssertions() {
        assertEquals(2, calculator.add(1, 1));
        assertEquals(4, calculator.multiply(2, 2), "選填的失敗提示訊息放在最後一個參數");

        // 使用 Lambda 提供延遲求值訊息：只有當斷言失敗時才會進行字串拼接，提高效能
        assertTrue('a' < 'b', () -> generateFailureMessage('a', 'b'));
    }

    @Test
    @DisplayName("2. 群組斷言 (assertAll)：全數執行並同時回報所有失敗")
    void groupedAssertions() {
        assertAll("person 屬性驗證",
                () -> assertEquals("Jane", person.getFirstName()),
                () -> assertEquals("Doe", person.getLastName())
        );
    }

    @Test
    @DisplayName("3. 相依性斷言：前項斷言失敗則後續跳過")
    void dependentAssertions() {
        assertAll("properties",
                () -> {
                    String firstName = person.getFirstName();
                    assertNotNull(firstName);

                    // 只有在 firstName 非 null 時，才會繼續執行下層的斷言
                    assertAll("first name 細部檢驗",
                            () -> assertTrue(firstName.startsWith("J")),
                            () -> assertTrue(firstName.endsWith("e"))
                    );
                },
                () -> {
                    String lastName = person.getLastName();
                    assertNotNull(lastName);

                    assertAll("last name 細部檢驗",
                            () -> assertTrue(lastName.startsWith("D")),
                            () -> assertTrue(lastName.endsWith("e"))
                    );
                }
        );
    }

    @Test
    @DisplayName("4. 例外斷言 (assertThrows)：驗證防禦性例外拋出與訊息")
    void exceptionTesting() {
        ArithmeticException exception = assertThrows(
                ArithmeticException.class,
                () -> calculator.divide(1, 0)
        );
        assertEquals("Division by zero is not allowed.", exception.getMessage());
    }

    @Test
    @DisplayName("5. 逾時測試 (assertTimeout)：要求指定時間內完成")
    void timeoutNotExceeded() {
        // 驗證程式碼必須在 2 分鐘內執行完畢
        String actualResult = assertTimeout(ofMinutes(2), () -> "a result");
        assertEquals("a result", actualResult);
    }

    @Test
    @DisplayName("6. 毫秒等級逾時測試")
    void timeoutNotExceededWithResult() {
        String actualResult = assertTimeout(ofMillis(500), () -> {
            Thread.sleep(50);
            return "done";
        });
        assertEquals("done", actualResult);
    }

    private static String generateFailureMessage(char a, char b) {
        return "字元比對失敗: " + a + " 應該小於 " + b;
    }
}
