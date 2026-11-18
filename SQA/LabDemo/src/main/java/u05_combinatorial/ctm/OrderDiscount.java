package u05_combinatorial.ctm;

/**
 * 電商訂單折扣計算器 (供 Unit 5.6 分類樹方法 Classification Tree Method, CTM 示範)
 * 
 * 分類樹 (Classification Tree) 三大分類維度與階層子樹：
 * 1. 會員身分 (MemberType)：VIP 會員 (8折)、一般會員 (9折)、訪客 (無折扣)
 * 2. 消費金額 (OrderAmount)：< 1000 (無滿額折)、1000 ~ 3000 (滿額折 100)、> 3000 (滿額折 300)
 * 3. 付款方式 (PaymentMethod)：
 *    - 信用卡支付子樹 (Credit Card Sub-tree)：
 *      • CREDIT_CARD_ONE_TIME (刷一次付清)
 *      • CREDIT_CARD_INSTALLMENT (刷分期付款)
 *    - MOBILE_PAY (行動支付)
 *    - CASH_ON_DELIVERY (貨到付款)
 */
public class OrderDiscount {

    public enum MemberType {
        VIP, REGULAR, GUEST
    }

    public enum PaymentMethod {
        /** 信用卡：一次付清 */
        CREDIT_CARD_ONE_TIME,
        /** 信用卡子樹：分期付款 */
        CREDIT_CARD_INSTALLMENT,
        /** 信用卡（向下相容簡寫，等同一次付清） */
        CREDIT_CARD,
        /** 行動支付 */
        MOBILE_PAY,
        /** 貨到付款 */
        CASH_ON_DELIVERY
    }

    public static class DiscountResult {
        public final double finalAmount;
        public final double discountAmount;
        public final String description;

        public DiscountResult(double finalAmount, double discountAmount, String description) {
            this.finalAmount = finalAmount;
            this.discountAmount = discountAmount;
            this.description = description;
        }
    }

    /**
     * 計算最終結帳金額與折扣
     */
    public static DiscountResult calculateDiscount(MemberType member, double amount, PaymentMethod payment) {
        if (amount < 0) {
            throw new IllegalArgumentException("訂單金額不得為負數: " + amount);
        }

        // 1. 會員身分折扣率
        double rate = 1.0;
        if (member == MemberType.VIP) {
            rate = 0.8;
        } else if (member == MemberType.REGULAR) {
            rate = 0.9;
        }

        // 2. 滿額立減金額
        double thresholdDiscount = 0;
        if (amount > 3000) {
            thresholdDiscount = 300;
        } else if (amount >= 1000) {
            thresholdDiscount = 100;
        }

        // 結帳金額 = (原始金額 * 會員折扣) - 滿額立減
        double discounted = (amount * rate) - thresholdDiscount;
        if (discounted < 0) {
            discounted = 0;
        }

        double totalSaved = amount - discounted;
        return new DiscountResult(discounted, totalSaved,
                "會員: " + member + ", 滿額立減: " + (int) thresholdDiscount + ", 付款方式: " + payment);
    }
}
