package u05_input.bva;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 🧪 課堂動手練習 (Exercise 5.3-A)：三角形強固邊界值測試 (Robust BVA)
 * 
 * 請閱讀每個測試方法的【提示 (Hints)】，補全 // TODO 標記處的程式碼以通過測試。
 */
@DisplayName("Unit 5.3 練習：三角形強固邊界測試練習題")
public class TriangleBvaExerciseTest {

    // =========================================================================
    // 💡 練習 1 提示 (Hints)：強固邊界測試 (Robust Boundary Value Analysis)
    // 1. 強固邊界除了 min, min+, nom, max-, max 之外，還納入了越界值：min- 與 max+。
    // 2. 假設範圍為 [1, 200]：
    //    - min- (越下界)：0 (或 -1) ➔ 預期輸出 "Not a valid triangle"
    //    - max+ (越上界)：201 ➔ 依三角形不等式 100+100 < 201 ➔ 預期輸出 "Not a valid triangle"
    // 3. 獨立型強固案例數為 6n + 1 (當 n=3 時為 19 個)。
    // =========================================================================
    @ParameterizedTest(name = "強固越界測試 - 邊長 ({0}, {1}, {2}) ➔ {3}")
    @DisplayName("練習 1：驗證 a 變數的 min- 與 max+ 越界測試")
    @CsvSource({
            // TODO: 請補全下方測試資料，測試 a 的越界情況 (b=100, c=100 維持 nom)
            "0,   100, 100, Not a valid triangle", // min- 越界值 (0 <= 0 邊長非法)
            "-1,  100, 100, Not a valid triangle", // 負數越界值
            "201, 100, 100, Not a valid triangle"  // max+ 越界值
    })
    void exercise1_testRobustBoundaryA(double a, double b, double c, String expected) {
        String actual = Triangle.getTriangleType(a, b, c);
        assertEquals(expected, actual, "越界值應該被防禦判定為 Not a valid triangle");
    }

    // =========================================================================
    // 💡 練習 2 提示 (Hints)：On-Off-In 三點法精準測試三角形等腰臨界
    // 1. 考慮邊長 a=3, b=4：
    //    - On 邊界點 (剛好等於臨界)：c = 7 (3+4=7，退化) ➔ "Not a valid triangle"
    //    - Off 邊界點 (剛好越過臨界)：c = 7.1 或 8 (3+4 < 7.1) ➔ "Not a valid triangle"
    //    - In 邊界點 (剛好在合法內部)：c = 6.9 或 6 (3+4 > 6.9) ➔ "Scalene"
    // =========================================================================
    @Test
    @DisplayName("練習 2：使用 On-Off-In 三點法檢驗兩邊之和的臨界點")
    void exercise2_testOnOffInPoints() {
        assertAll("On-Off-In 三點法臨界驗證",
                // On 點：a+b == c
                () -> assertEquals("Not a valid triangle", Triangle.getTriangleType(3, 4, 7),
                        "On 點: 3+4=7 剛好退化"),

                // Off 點：a+b < c
                () -> assertEquals("Not a valid triangle", Triangle.getTriangleType(3, 4, 8),
                        "Off 點: 3+4 < 8 越界非法"),

                // In 點：a+b > c
                () -> assertEquals("Scalene", Triangle.getTriangleType(3, 4, 6),
                        "In 點: 3+4 > 6 合法不等邊三角形")
        );
    }
}
