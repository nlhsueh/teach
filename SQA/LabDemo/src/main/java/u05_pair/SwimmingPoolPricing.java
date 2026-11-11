package u05_pair;

/**
 * 游泳池收費系統 (供 Unit 5.5 全成對組合測試 Pairwise Testing 示範)
 *
 * 對應講義與投影片範例：凱旋游泳池收費規則
 * - 標準收費為 100 元。
 * - (1) 星期六日 (HOLIDAY) 200 元，除會員以外不打折。
 * - (2) 清晨 6:00 以前 (MORNING) 所有人打八折 (0.8)；中午 11:00-13:00 (NOON) 打九折 (0.9)；其他時段 (OTHER) 原價。
 * - (3) 會員 (isMember = true) 一律打五折 (0.5)。
 * - 各項折扣不可重複累加，若有適用折扣則以最低價為主。
 *
 * 【三個測試參數維度】：
 * - 時間 (TimeSlot, 3 種)：MORNING (t1 清晨), NOON (t2 中午), OTHER (t3 其他)
 * - 星期 (DayType, 2 種) ：HOLIDAY (d1 假日), WEEKDAY (d2 平日)
 * - 會員 (Boolean, 2 種) ：true (m1 會員), false (m2 非會員)
 * - 全乘積案例數：3 × 2 × 2 = 12 組
 * - 全成對案例數：僅需 6 組即可 100% 涵蓋全部 16 個成對組合 (Pairs)！
 */
public class SwimmingPoolPricing {

    public enum TimeSlot {
        MORNING, // t1: 清晨 6:00 前
        NOON,    // t2: 中午 11:00-13:00
        OTHER    // t3: 其他時段
    }

    public enum DayType {
        HOLIDAY, // d1: 星期六日 (假日)
        WEEKDAY  // d2: 一般平日
    }

    /**
     * 計算游泳池門票價格。
     *
     * @param timeSlot 入場時段 (MORNING / NOON / OTHER)
     * @param dayType  平假日別 (HOLIDAY / WEEKDAY)
     * @param isMember 是否為會員 (true / false)
     * @return 應付門票金額 (元)
     */
    public static int calculatePrice(TimeSlot timeSlot, DayType dayType, boolean isMember) {
        if (timeSlot == null || dayType == null) {
            throw new IllegalArgumentException("時段與平假日參數不可為 null");
        }

        int basePrice = (dayType == DayType.HOLIDAY) ? 200 : 100;

        // 會員無論平假日一律享有最低五折優惠
        if (isMember) {
            return (int) Math.round(basePrice * 0.5);
        }

        // 假日非會員不打折
        if (dayType == DayType.HOLIDAY) {
            return basePrice;
        }

        // 平日非會員依時段折扣
        if (timeSlot == TimeSlot.MORNING) {
            return (int) Math.round(basePrice * 0.8);
        } else if (timeSlot == TimeSlot.NOON) {
            return (int) Math.round(basePrice * 0.9);
        } else {
            return basePrice;
        }
    }
}

