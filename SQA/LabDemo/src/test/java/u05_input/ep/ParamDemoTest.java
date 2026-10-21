package u05_input.ep;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 💡 課堂示範：JUnit 5 參數化測試 (Parameterized Tests) 與等價類驅動
 * 
 * 涵蓋：
 * - @ValueSource：單一參數陣列快速注入
 * - @CsvSource：多欄位表格資料注入 (最適合等價劃分測試向量)
 */
@DisplayName("Unit 5.4 示範：參數化測試與資料驅動")
public class ParamDemoTest {

    @ParameterizedTest(name = "測試字串 \"{0}\" 是否為回文")
    @DisplayName("示範 1：@ValueSource 字串回文檢驗")
    @ValueSource(strings = { "racecar", "radar", "able was I ere I saw elba" })
    void testPalindromes(String candidate) {
        assertTrue(StringUtils.isPalindrome(candidate), candidate + " 應該為回文");
    }

    @ParameterizedTest(name = "質數等價類：{0} 應判定為質數")
    @DisplayName("示範 2：@ValueSource 整數質數等價類驗證")
    @ValueSource(ints = { 2, 3, 5, 7, 11, 13, 17, 19, 23 })
    void testPrime(int argument) {
        assertTrue(MathUtils.isPrime(argument));
    }

    @ParameterizedTest(name = "非質數等價類：{0} 應判定為非質數")
    @DisplayName("示範 3：@ValueSource 整數合數與非質數等價類驗證")
    @ValueSource(ints = { -5, 0, 1, 4, 6, 8, 9, 10, 51 })
    void testNotPrime(int argument) {
        assertFalse(MathUtils.isPrime(argument));
    }

    @ParameterizedTest(name = "水果: {0}, 排名數值: {1}")
    @DisplayName("示範 4：@CsvSource 多維表格資料注入")
    @CsvSource({
            "apple,         1",
            "banana,        2",
            "'lemon, lime', 3",
            "strawberry,    4"
    })
    void testWithCsvSource(String fruit, int rank) {
        assertNotNull(fruit);
        assertTrue(rank > 0);
    }
}
