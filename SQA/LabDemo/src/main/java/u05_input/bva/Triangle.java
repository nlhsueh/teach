package u05_input.bva;

/**
 * 三角形型態判定類別 (供 Unit 5.3 邊界值分析 BVA 教學與實作)
 * 
 * 規則規格：
 * 1. 輸入 a, b, c 代表三邊長，範圍通常受限於 [1, 200]。
 * 2. 若任一邊長 <= 0 或任意兩邊之和 <= 第三邊，回傳 "Not a valid triangle"。
 * 3. 若三邊相等 (a == b && b == c)，回傳 "Equilateral" (正三角形)。
 * 4. 若恰有兩邊相等，回傳 "Isosceles" (等腰三角形)。
 * 5. 其餘三邊不相等之合法三角形，回傳 "Scalene" (不等邊三角形)。
 */
public class Triangle {

    public static String getTriangleType(double a, double b, double c) {
        // 邊界防禦：邊長必須大於 0，且任意兩邊之和大於第三邊 (三角形不等式定理)
        if (a <= 0 || b <= 0 || c <= 0 || a + b <= c || a + c <= b || b + c <= a) {
            return "Not a valid triangle";
        }

        // 正三角形判斷
        if (a == b && b == c) {
            return "Equilateral";
        }

        // 等腰三角形判斷
        if (a == b || b == c || a == c) {
            return "Isosceles";
        }

        // 不等邊三角形
        return "Scalene";
    }
}
