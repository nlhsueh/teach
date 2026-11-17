package u06_coverage;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit 06 白箱測試實作：Triangle.java 涵蓋度分析與測資設計
 *
 * 實習手冊：LabDemo/docs/u06_wbtesting/whitebox_test.md
 * 目標：設計精簡測資依序點亮所有短路求值子條件，達到 100% 分支涵蓋度 (Branch Coverage)！
 */
public class TriangleCoverageTest {

    @Test
    @DisplayName("TC1 ~ TC6: 依序觸發決策 1 的 6 個非法條件 (a<=0, b<=0, c<=0, a+b<=c, a+c<=b, b+c<=a)")
    void testInvalidTriangles() {
        // 1. 觸發 a <= 0 (後續 5 條件被短路)
        assertEquals("Not a valid triangle", Triangle.getTriangleType(0, 2, 3));
        // 2. 觸發 b <= 0
        assertEquals("Not a valid triangle", Triangle.getTriangleType(2, 0, 3));
        // 3. 觸發 c <= 0
        assertEquals("Not a valid triangle", Triangle.getTriangleType(2, 3, 0));
        // 4. 觸發 a + b <= c
        assertEquals("Not a valid triangle", Triangle.getTriangleType(1, 2, 3));
        // 5. 觸發 a + c <= b
        assertEquals("Not a valid triangle", Triangle.getTriangleType(1, 3, 2));
        // 6. 觸發 b + c <= a
        assertEquals("Not a valid triangle", Triangle.getTriangleType(3, 1, 2));
    }

    @Test
    @DisplayName("TC7: 正三角形 (決策 1 全 False，決策 2 a==b && b==c 皆為 True)")
    void testEquilateralTriangle() {
        assertEquals("Equilateral", Triangle.getTriangleType(3, 3, 3));
    }

    @Test
    @DisplayName("TC8: 等腰三角形 (分別讓決策 3 的 a==b, b==c, a==c 獨立成立)")
    void testIsoscelesTriangle() {
        assertEquals("Isosceles", Triangle.getTriangleType(3, 3, 2)); // a == b
        assertEquals("Isosceles", Triangle.getTriangleType(2, 3, 3)); // b == c
        assertEquals("Isosceles", Triangle.getTriangleType(3, 2, 3)); // a == c
    }

    @Test
    @DisplayName("TC9: 一般不等邊三角形 (走完所有決策的 False 分支)")
    void testScaleneTriangle() {
        assertEquals("Scalene", Triangle.getTriangleType(3, 4, 5));
    }
}
