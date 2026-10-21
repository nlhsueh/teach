package u05_input.ctm;

/**
 * 電商訂單折扣計算器 (供 Unit 5.6 分類樹方法 Classification Tree Method, CTM 示範)
 * 
 * 分類樹 (Classification Tree) 分類維度：
 * 1. 會員等級 (MemberType)：VIP 會員 (8折)、一般會員 (9折)、訪客 (無折扣)
 * 2. 訂單金額 (OrderAmount)：< 1000 (無滿額折)、1000 ~ 3000 (滿額折 100)、> 3000 (滿額折 300)
 * 3. 支付方式 (PaymentMethod)：信用卡 (滿千免手續費)、行動支付 (LINE/Apple Pay 滿千享回饋)、貨到付款 (無額外回饋)
 */
public class OrderDiscount {

    public enum MemberType {
        VIP, REGULAR, GUEST
    }

    public enum PaymentMethod {
        CREDIT_CARD, MOBILE_PAY, CASH_ON_DELIVERY
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
                String.format("會員: %s, 滿額立減: %.0f, 支付方式: %s", member, thresholdDiscount, payment));
    }
}
