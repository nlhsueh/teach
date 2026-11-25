package u06_coverage;

/**
 * Unit 06 Lab 2：程式碼複雜度度量與重構練習（運費計算器）
 *
 * 練習目標：
 * 1. 使用 IntelliJ MetricsReloaded 計算 calculateFeeNested 的 v(G) 與 CogC。
 * 2. 繪製控制流程圖 (CFG)，導出線性獨立基本路徑並撰寫測試。
 * 3. 以衛語句 (Guard Clauses) 重構為扁平結構，比較重構前後 v(G) 與 CogC 的變化！
 */
public class ShippingFeeCalculator {

    /**
     * 深層巢狀版本（Arrow Anti-Pattern）：
     * 業務規則：
     * - 金額 <= 0：非法訂單，回傳 -1
     * - VIP 會員：滿 1000 免運 (0)，否則 30（偏遠地區加收 50）
     * - 一般會員：有折價券收 50，無折價券收 80（偏遠地區加收 50）
     */
    public static int calculateFeeNested(int amount, boolean isVip, boolean isRemote, boolean hasCoupon) {
        if (amount > 0) {
            int fee;
            if (isVip) {
                if (amount >= 1000) {
                    fee = 0;
                } else {
                    fee = 30;
                }
            } else {
                if (hasCoupon) {
                    fee = 50;
                } else {
                    fee = 80;
                }
            }
            if (isRemote && fee > 0) {
                fee += 50;
            }
            return fee;
        }
        return -1;
    }

    /**
     * 衛語句重構參考版（Guard Clauses）：
     * 邏輯 100% 等價，但最大巢狀深度大幅降低，CogC 明顯下降！
     */
    public static int calculateFeeRefactored(int amount, boolean isVip, boolean isRemote, boolean hasCoupon) {
        if (amount <= 0) {
            return -1;
        }
        if (isVip && amount >= 1000) {
            return 0;
        }
        int baseFee = isVip ? 30 : (hasCoupon ? 50 : 80);
        return isRemote ? baseFee + 50 : baseFee;
    }
}
