package u06_coverage;

/**
 * 撰寫一個 `getTriangleType` 方法，根據三邊長 `a`、`b`、`c` 的值來判斷三角形的類型：
 * 若任一邊長小於等於 0 或兩邊之和小於等於第三邊，回傳 "Not a valid triangle"；
 * 若三邊相等，回傳 "Equilateral"；若兩邊相等，回傳 "Isosceles"；若三邊皆不相等，回傳 "Scalene"。
 *
 * 供 Unit 06 白箱覆蓋率（Line / Branch / Condition Coverage）實作示範。
 */
public class Triangle {

    public static String getTriangleType(double a, double b, double c) {
        // 決策 1：6 個子條件，共 12 個 Bytecode 跳轉分支
        if (a <= 0 || b <= 0 || c <= 0 || a + b <= c || a + c <= b || b + c <= a) {
            return "Not a valid triangle";
        }

        // 決策 2：正三角形判斷 (3 個條件；注意 a==b && b==c 成立時，由遞移律 a==c 恆為 True，屬於死分支)
        if (a == b && b == c && a == c) {
            return "Equilateral";
        }

        // 決策 3：等腰三角形判斷 (3 個子條件)
        if (a == b || b == c || a == c) {
            return "Isosceles";
        }

        // 決策 4：一般不等邊三角形
        return "Scalene";
    }
}
