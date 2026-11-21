package u05_behavioral.state;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.Objects;

/**
 * ✈️ 航空機票訂位狀態機 (Unit 5.8 狀態轉換測試示範類別)
 *
 * 【狀態機規格：6 大狀態 × 8 條合法轉移弧線】
 * - 正常主流程 (Happy Path)：
 *   ⚫ --[giveInfo]--> MADE --[payMoney]--> PAID --[print]--> TICKETED --[giveTicket]--> USED 🏁
 * - 例外取消分支 (Cancellation Paths)：
 *   MADE / PAID / TICKETED --[cancel]--> CANCELLED_BY_CUSTOMER ⛔
 *   MADE --[payTimeExpire]--> CANCELLED_NON_PAY ⏱️
 * - 終止狀態不變量 (Terminal States)：
 *   USED、CANCELLED_BY_CUSTOMER、CANCELLED_NON_PAY 皆為終止狀態，
 *   一旦進入即不得接受任何事件轉移，非法呼叫一律拋出 IllegalStateException 且維持原狀態不變。
 */
public class AirlineTicket {

    public static final Duration PAYMENT_WINDOW = Duration.ofHours(24);

    public enum State {
        MADE,
        PAID,
        TICKETED,
        USED,
        CANCELLED_BY_CUSTOMER,
        CANCELLED_NON_PAY
    }

    private final String passengerName;
    private final String flightNo;
    private final Instant createdAt;
    private final Instant paymentDeadline;
    private State state;

    private AirlineTicket(String passengerName, String flightNo, Clock clock) {
        if (passengerName == null || passengerName.isBlank()) {
            throw new IllegalArgumentException("旅客姓名不可為空白");
        }
        if (flightNo == null || flightNo.isBlank()) {
            throw new IllegalArgumentException("航班編號不可為空白");
        }
        Objects.requireNonNull(clock, "Clock 不可為 null");

        this.passengerName = passengerName;
        this.flightNo = flightNo;
        this.createdAt = clock.instant();
        this.paymentDeadline = this.createdAt.plus(PAYMENT_WINDOW);
        this.state = State.MADE;
    }

    /**
     * 初始轉移：⚫ --[giveInfo]--> MADE (已預約保留)
     */
    public static AirlineTicket giveInfo(String passengerName, String flightNo) {
        return giveInfo(passengerName, flightNo, Clock.systemDefaultZone());
    }

    /**
     * 初始轉移（支援注入虛擬時鐘 Clock，便於單元測試毫秒級驗證 24 小時逾期行為）
     */
    public static AirlineTicket giveInfo(String passengerName, String flightNo, Clock clock) {
        return new AirlineTicket(passengerName, flightNo, clock);
    }

    /**
     * 事件轉移：MADE --[payMoney]--> PAID (已完成付款)
     */
    public void payMoney() {
        if (state != State.MADE) {
            throw new IllegalStateException("非法轉移：僅在 MADE 狀態可付款，目前狀態為 " + state);
        }
        this.state = State.PAID;
    }

    /**
     * 事件轉移：PAID --[print]--> TICKETED (已開票完成)
     */
    public void print() {
        if (state != State.PAID) {
            throw new IllegalStateException("非法轉移：僅在 PAID 狀態可開票，目前狀態為 " + state);
        }
        this.state = State.TICKETED;
    }

    /**
     * 事件轉移：TICKETED --[giveTicket]--> USED (已登機搭乘 / 正常終止)
     */
    public void giveTicket() {
        if (state != State.TICKETED) {
            throw new IllegalStateException("非法轉移：僅在 TICKETED 狀態可登機，目前狀態為 " + state);
        }
        this.state = State.USED;
    }

    /**
     * 事件轉移：MADE / PAID / TICKETED --[cancel]--> CANCELLED_BY_CUSTOMER (顧客主動取消 / 退票)
     */
    public void cancel() {
        if (isTerminal()) {
            throw new IllegalStateException("非法轉移：訂單已處於終止狀態 (" + state + ")，禁止再取消或退票");
        }
        this.state = State.CANCELLED_BY_CUSTOMER;
    }

    /**
     * 事件轉移：MADE --[payTimeExpire]--> CANCELLED_NON_PAY (逾期未付系統自動取消)
     */
    public void payTimeExpire() {
        if (state != State.MADE) {
            throw new IllegalStateException("非法轉移：僅在 MADE (未付款) 狀態可觸發付款逾時，目前狀態為 " + state);
        }
        this.state = State.CANCELLED_NON_PAY;
    }

    /**
     * 搭配虛擬時鐘 (Mock Clock) 檢查是否超過 24 小時付款期限：
     * 若目前為 MADE 且 now 超過 paymentDeadline，自動觸發 payTimeExpire()。
     */
    public void checkPaymentTimeout(Clock nowClock) {
        Objects.requireNonNull(nowClock, "Clock 不可為 null");
        if (state == State.MADE && nowClock.instant().isAfter(paymentDeadline)) {
            payTimeExpire();
        }
    }

    public State getState() {
        return state;
    }

    public boolean isTerminal() {
        return state == State.USED
                || state == State.CANCELLED_BY_CUSTOMER
                || state == State.CANCELLED_NON_PAY;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getPaymentDeadline() {
        return paymentDeadline;
    }
}
