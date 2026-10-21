package u05_input.bva;

/**
 * 游泳池入場票價計算器 (供 Unit 5.3 邊界值分析 BVA 練習)
 * 
 * 業務規格：
 * - 0 ~ 3 歲：免費 ("FREE", 0 元)
 * - 4 ~ 12 歲：兒童票 ("CHILD", 100 元)
 * - 13 ~ 64 歲：全票 ("ADULT", 250 元)
 * - ≥ 65 歲：敬老票 ("SENIOR", 120 元)
 * - 年齡 < 0 或 > 120 歲：非法年齡，拋出 IllegalArgumentException
 */
public class PoolTicketCalculator {

    public enum TicketType {
        FREE(0),
        CHILD(100),
        ADULT(250),
        SENIOR(120);

        private final int price;

        TicketType(int price) {
            this.price = price;
        }

        public int getPrice() {
            return price;
        }
    }

    public static TicketType getTicketType(int age) {
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("無效的年齡輸入: " + age + "。合法年齡範圍為 0 ~ 120 歲。");
        }

        if (age <= 3) {
            return TicketType.FREE;
        } else if (age <= 12) {
            return TicketType.CHILD;
        } else if (age <= 64) {
            return TicketType.ADULT;
        } else {
            return TicketType.SENIOR;
        }
    }
}
