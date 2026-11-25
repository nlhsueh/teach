package u06_mutation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit 06 PITest 變異測試實戰範例：Triangle
 *
 * 執行指令（於 LabDemo 目錄下）：
 *   mvn test-compile org.pitest:pitest-maven:mutationCoverage \
 *       -DtargetClasses="u06_mutation.Triangle" \
 *       -DtargetTests="u06_mutation.TrianglePitestTest"
 *
 * 報表位置：target/pit-reports/index.html
 */
@DisplayName("PITest 變異測試：Triangle 三角形分類")
class TrianglePitestTest {

    @Test
    @DisplayName("合法三角形分類（正三角、等腰、不等邊）")
    void testValidTriangles() {
        assertEquals("Equilateral", Triangle.getTriangleType(3, 3, 3));
        assertEquals("Isosceles", Triangle.getTriangleType(3, 3, 2));
        assertEquals("Isosceles", Triangle.getTriangleType(2, 3, 3));
        assertEquals("Isosceles", Triangle.getTriangleType(3, 2, 3));
        assertEquals("Scalene", Triangle.getTriangleType(3, 4, 5));
    }

    @Test
    @DisplayName("非法邊長：包含 0 或負數（獵殺 <= 0 邊界變異體）")
    void testNonPositiveSides() {
        assertEquals("Not a valid triangle", Triangle.getTriangleType(0, 2, 3));
        assertEquals("Not a valid triangle", Triangle.getTriangleType(2, 0, 3));
        assertEquals("Not a valid triangle", Triangle.getTriangleType(2, 3, 0));
        assertEquals("Not a valid triangle", Triangle.getTriangleType(-1, 2, 3));
    }

    @Test
    @DisplayName("非法邊長：違反三角不等式（獵殺 a+b <= c 邊界變異體）")
    void testTriangleInequalityBoundary() {
        assertEquals("Not a valid triangle", Triangle.getTriangleType(1, 2, 3));
        assertEquals("Not a valid triangle", Triangle.getTriangleType(1, 3, 2));
        assertEquals("Not a valid triangle", Triangle.getTriangleType(3, 1, 2));
    }
}
