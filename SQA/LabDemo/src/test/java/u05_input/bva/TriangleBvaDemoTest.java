package u05_input.bva;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 💡 課堂示範 (Demo 5.3)：邊界值分析 (Boundary Value Analysis, BVA)
 * 
 * 【教學核心觀念】：
 * 1. 「錯誤隱藏在角落」：程式碼中最容易發生瑕疵之處，往往在於邊界的 `>=` 誤寫為 `>` 或 `+1` 筆誤。
 * 2. 單一錯誤假設 (Single Fault Assumption)：
 *    - 假設多數缺陷是由單一變數處於極端邊界所引發。
 *    - 標準獨立型 BVA 案例數為 4n + 1 (若 n=3 則需 13 個案例)。
 * 3. 測試點五點法：
 *    - 針對範圍 [min, max] 取：min (最小值), min+ (略大於最小), nom (常態中間值), max- (略小於最大), max (最大值)。
 */
@DisplayName("Unit 5.3 示範：三角形邊界值分析 (BVA)")
public class TriangleBvaDemoTest {

    // 假設邊長範圍限制在 [1, 200]，取 nom = 100
    // 5 個代表點：min = 1, min+ = 2, nom = 100, max- = 199, max = 200

    @ParameterizedTest(name = "案例 #{index} - 邊長 ({0}, {1}, {2}) ➔ 預期型態: {3}")
    @DisplayName("示範 1：變動 a 邊長之邊界測試案例 (b=100, c=100 維持 nom)")
    @CsvSource({
            // a 取 min, min+, max-, max；b 與 c 維持 100
            "1,   100, 100, Isosceles",             // min 邊界 (1, 100, 100)
            "2,   100, 100, Isosceles",             // min+ 邊界 (2, 100, 100)
            "199, 100, 100, Isosceles",             // max- 邊界 (199, 100, 100)
            "200, 100, 100, Not a valid triangle"   // max 邊界 (200, 100, 100) ➔ 100+100=200 不滿足兩邊之和大於第三邊！
    })
    void testBoundary_variableA(double a, double b, double c, String expected) {
        String actual = Triangle.getTriangleType(a, b, c);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("示範 2：常態基準點案例 (所有變數皆取 nom)")
    void testNominal_baseline() {
        // a=100, b=100, c=100
        String actual = Triangle.getTriangleType(100, 100, 100);
        assertEquals("Equilateral", actual, "三邊皆為 100 時應為正三角形");
    }

    @Test
    @DisplayName("示範 3：使用 assertAll 驗證兩邊之和小於等於第三邊之極限臨界")
    void testTriangleInequality_criticalBoundary() {
        assertAll("兩邊之和剛好等於第三邊之退化邊界 (不構成三角形)",
                () -> assertEquals("Not a valid triangle", Triangle.getTriangleType(3, 4, 7), "3+4=7，剛好退化為線段"),
                () -> assertEquals("Not a valid triangle", Triangle.getTriangleType(3, 7, 4), "3+4=7，剛好退化為線段"),
                () -> assertEquals("Not a valid triangle", Triangle.getTriangleType(7, 3, 4), "3+4=7，剛好退化為線段")
        );
    }
}
