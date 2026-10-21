package u05_input.pairwise;

/**
 * 貸款利率計算器 (供 Unit 5.5 全成對組合測試 Pairwise Testing 示範)
 * 
 * 商業規則規格：
 * - 基礎利率為 5.0%
 * - 年限優惠：
 *   - 貸款年限超過 10 年，折扣 0.5%
 *   - 貸款年限超過 20 年，折扣 1.0% (不累加 10 年之折扣)
 * - 額度優惠：
 *   - 貸款金額超過 500 萬，每多 100 萬額外減少 0.1%
 * - 身分優惠：
 *   - 申請者為青年，減少 1.0%
 *   - 若已婚，再減少 0.5%
 * - 防禦保底限制：
 *   - 最低優惠利率下限為 2.0% (即使各項優惠累加低於 2.0%，利率仍鎖定為 2.0%)
 */
public class LoanCalculator {

    public static double calculateInterestRate(int year, double amount, boolean isYouth, boolean isMarried) {
        double rate = 5.0; // 基礎基準利率

        // 1. 年限優惠規則
        if (year > 20) {
            rate -= 1.0;
        } else if (year > 10) {
            rate -= 0.5;
        }

        // 2. 額度優惠規則 (超過 500 萬，每滿 100 萬減 0.1%)
        if (amount > 5000000) {
            double extraMillion = (amount - 5000000) / 1000000;
            rate -= extraMillion * 0.1;
        }

        // 3. 身分優惠規則
        if (isYouth) {
            rate -= 1.0;
        }
        if (isMarried) {
            rate -= 0.5;
        }

        // 4. 防禦下限邊界：利率不可低於 2.0%
        if (rate < 2.0) {
            rate = 2.0;
        }

        // 精度修正至小數點後 2 位
        return Math.round(rate * 100.0) / 100.0;
    }
}
