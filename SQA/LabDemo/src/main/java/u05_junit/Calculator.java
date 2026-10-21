package u05_junit;

/**
 * 簡易計算機類別 (供 Unit 5.2 JUnit 5 入門與 3A 原則教學示範)
 */
public class Calculator {

    /**
     * 加法運算
     */
    public int add(int a, int b) {
        return a + b;
    }

    /**
     * 乘法運算
     */
    public int multiply(int a, int b) {
        return a * b;
    }

    /**
     * 除法運算
     * @throws ArithmeticException 當除數為 0 時拋出例外
     */
    public double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return (double) a / b;
    }

    /**
     * 減法運算 (供學生練習用)
     */
    public int subtract(int a, int b) {
        return a - b;
    }
}
