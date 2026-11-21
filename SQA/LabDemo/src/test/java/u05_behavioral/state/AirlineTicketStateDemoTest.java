package u05_behavioral.state;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import u05_behavioral.state.AirlineTicket.State;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 💡 課堂示範 (Demo 5.8)：航空訂票系統狀態轉換測試 (Airline Ticket State Transition Testing)
 *
 * 【對應教材 Unit 5.8 航空訂票狀態機】：
 * 1. 全轉移覆蓋 (Transition Coverage / 0-Switch)：以 5 條端到端事件序列覆蓋全部 6 個狀態節點與 8 條轉移弧線。
 * 2. 虛擬時鐘測試 (Mock Clock)：透過注入 java.time.Clock 瞬間快轉 25 小時，免 Thread.sleep 即可驗證 payTimeExpire。
 * 3. 狀態轉移表強固性檢查 (Robustness Testing)：使用 @Nested + @BeforeEach 隔離各個前置狀態，
 *    驗證所有「❌ 非法事件」均拋出 IllegalStateException 且原狀態不被污染篡改。
 */
@DisplayName("Unit 5.8 示範：航空訂票系統 (AirlineTicket) 狀態轉換測試")
public class AirlineTicketStateDemoTest {

    // =========================================================================
    // Part 1: 5 條全轉移覆蓋測試路徑 (100% 狀態覆蓋 6/6 + 100% 轉移覆蓋 8/8)
    // =========================================================================
    @Nested
    @DisplayName("Part 1：全轉移覆蓋 (Transition Coverage) — 5 條端到端測試路徑")
    class FullTransitionCoveragePathsTests {

        @Test
        @DisplayName("路徑 1 (Happy Path)：giveInfo ➔ payMoney ➔ print ➔ giveTicket ➔ USED 🏁")
        void path1_happyPathToUsed() {
            AirlineTicket ticket = AirlineTicket.giveInfo("Alice", "BR-198");
            assertEquals(State.MADE, ticket.getState());

            ticket.payMoney();
            assertEquals(State.PAID, ticket.getState());

            ticket.print();
            assertEquals(State.TICKETED, ticket.getState());

            ticket.giveTicket();
            assertAll("正常登機終止驗證",
                    () -> assertEquals(State.USED, ticket.getState()),
                    () -> assertTrue(ticket.isTerminal(), "USED 應為終止狀態")
            );
        }

        @Test
        @DisplayName("路徑 2 (開票後退票)：giveInfo ➔ payMoney ➔ print ➔ cancel ➔ CANCELLED_BY_CUSTOMER ⛔")
        void path2_cancelAfterTicketed() {
            AirlineTicket ticket = AirlineTicket.giveInfo("Bob", "CI-100");
            ticket.payMoney();
            ticket.print();
            ticket.cancel();

            assertAll("開票後退票終止驗證",
                    () -> assertEquals(State.CANCELLED_BY_CUSTOMER, ticket.getState()),
                    () -> assertTrue(ticket.isTerminal())
            );
        }

        @Test
        @DisplayName("路徑 3 (付款後退款取消)：giveInfo ➔ payMoney ➔ cancel ➔ CANCELLED_BY_CUSTOMER ⛔")
        void path3_cancelAfterPaid() {
            AirlineTicket ticket = AirlineTicket.giveInfo("Carol", "JX-800");
            ticket.payMoney();
            ticket.cancel();

            assertAll("付款後取消終止驗證",
                    () -> assertEquals(State.CANCELLED_BY_CUSTOMER, ticket.getState()),
                    () -> assertTrue(ticket.isTerminal())
            );
        }

        @Test
        @DisplayName("路徑 4 (預約保留後主動放棄)：giveInfo ➔ cancel ➔ CANCELLED_BY_CUSTOMER ⛔")
        void path4_cancelAfterMade() {
            AirlineTicket ticket = AirlineTicket.giveInfo("Dave", "BR-852");
            ticket.cancel();

            assertAll("預約後取消終止驗證",
                    () -> assertEquals(State.CANCELLED_BY_CUSTOMER, ticket.getState()),
                    () -> assertTrue(ticket.isTerminal())
            );
        }

        @Test
        @DisplayName("路徑 5 (逾期未付自動取消)：giveInfo ➔ payTimeExpire ➔ CANCELLED_NON_PAY ⏱️")
        void path5_expireAfterMade() {
            AirlineTicket ticket = AirlineTicket.giveInfo("Eve", "CI-006");
            ticket.payTimeExpire();

            assertAll("逾期自動取消終止驗證",
                    () -> assertEquals(State.CANCELLED_NON_PAY, ticket.getState()),
                    () -> assertTrue(ticket.isTerminal())
            );
        }

        @Test
        @DisplayName("實務技巧 (Mock Clock)：虛擬時鐘瞬間快轉 25 小時觸發 payTimeExpire，不需 Thread.sleep")
        void path5_withVirtualClockFastForward() {
            // 1. 固定起點時間：2026-11-19T10:00:00Z
            Instant bookingTime = Instant.parse("2026-11-19T10:00:00Z");
            Clock bookingClock = Clock.fixed(bookingTime, ZoneOffset.UTC);
            AirlineTicket ticket = AirlineTicket.giveInfo("Frank", "JX-002", bookingClock);

            // 2. 快轉 23 小時（仍在 24 小時寬限期內）➔ 應維持 MADE
            Clock within23Hours = Clock.fixed(bookingTime.plus(Duration.ofHours(23)), ZoneOffset.UTC);
            ticket.checkPaymentTimeout(within23Hours);
            assertEquals(State.MADE, ticket.getState(), "23 小時尚未逾時，應維持 MADE 狀態");

            // 3. 快轉 25 小時（超過 24 小時期限）➔ 自動轉移至 CANCELLED_NON_PAY
            Clock after25Hours = Clock.fixed(bookingTime.plus(Duration.ofHours(25)), ZoneOffset.UTC);
            ticket.checkPaymentTimeout(after25Hours);
            assertEquals(State.CANCELLED_NON_PAY, ticket.getState(), "超過 24 小時未付款應自動取消");
        }
    }

    // =========================================================================
    // Part 2: 狀態轉移表「❌ 非法轉移」強固性測試 (依現態分組 + @BeforeEach 隔離)
    // =========================================================================
    @Nested
    @DisplayName("Part 2-1：現態【MADE (已預約)】之非法轉移防禦")
    class WhenMadeTests {

        private AirlineTicket ticket;

        @BeforeEach
        void setUpMade() {
            ticket = AirlineTicket.giveInfo("Grace", "BR-198");
        }

        @Test
        @DisplayName("❌ 未付款不得開票 (print) ➔ 拋出 IllegalStateException 且維持 MADE")
        void illegalPrintBeforePay() {
            assertThrows(IllegalStateException.class, ticket::print);
            assertEquals(State.MADE, ticket.getState(), "非法事件不可破壞原有狀態");
        }

        @Test
        @DisplayName("❌ 未付款不得登機 (giveTicket) ➔ 拋出 IllegalStateException 且維持 MADE")
        void illegalGiveTicketBeforePay() {
            assertThrows(IllegalStateException.class, ticket::giveTicket);
            assertEquals(State.MADE, ticket.getState());
        }
    }

    @Nested
    @DisplayName("Part 2-2：現態【PAID (已付款)】之非法轉移防禦")
    class WhenPaidTests {

        private AirlineTicket ticket;

        @BeforeEach
        void setUpPaid() {
            ticket = AirlineTicket.giveInfo("Henry", "CI-100");
            ticket.payMoney();
        }

        @Test
        @DisplayName("❌ 已付款不得重複扣款 (payMoney)、未開票不得登機 (giveTicket)、已付不逾時 (payTimeExpire)")
        void illegalEventsOnPaid() {
            assertAll("PAID 狀態非法轉移矩陣",
                    () -> assertThrows(IllegalStateException.class, ticket::payMoney, "禁止重複扣款"),
                    () -> assertThrows(IllegalStateException.class, ticket::giveTicket, "未開票不得登機"),
                    () -> assertThrows(IllegalStateException.class, ticket::payTimeExpire, "已付款不會逾時取消"),
                    () -> assertEquals(State.PAID, ticket.getState(), "原狀態須維持 PAID")
            );
        }
    }

    @Nested
    @DisplayName("Part 2-3：現態【TICKETED (已開票)】之非法轉移防禦")
    class WhenTicketedTests {

        private AirlineTicket ticket;

        @BeforeEach
        void setUpTicketed() {
            ticket = AirlineTicket.giveInfo("Ivy", "JX-800");
            ticket.payMoney();
            ticket.print();
        }

        @Test
        @DisplayName("❌ 已開票不得重複付款 (payMoney)、重複出票 (print) 或逾時取消 (payTimeExpire)")
        void illegalEventsOnTicketed() {
            assertAll("TICKETED 狀態非法轉移矩陣",
                    () -> assertThrows(IllegalStateException.class, ticket::payMoney),
                    () -> assertThrows(IllegalStateException.class, ticket::print),
                    () -> assertThrows(IllegalStateException.class, ticket::payTimeExpire),
                    () -> assertEquals(State.TICKETED, ticket.getState())
            );
        }
    }

    @Nested
    @DisplayName("Part 2-4：終止狀態不變量【USED / CANCELLED】拒絕一切後續轉移")
    class TerminalStateInvariantTests {

        @Test
        @DisplayName("❌ 已登機 (USED) 後惡意退票 (cancel) 或觸發其他事件 ➔ 一律拒絕並維持 USED")
        void usedTicketRejectsAllTransitions() {
            AirlineTicket ticket = AirlineTicket.giveInfo("Jack", "BR-001");
            ticket.payMoney();
            ticket.print();
            ticket.giveTicket();

            assertAll("USED 終止狀態不變量",
                    () -> assertThrows(IllegalStateException.class, ticket::cancel, "已搭乘禁止退票"),
                    () -> assertThrows(IllegalStateException.class, ticket::payMoney),
                    () -> assertThrows(IllegalStateException.class, ticket::print),
                    () -> assertThrows(IllegalStateException.class, ticket::giveTicket),
                    () -> assertThrows(IllegalStateException.class, ticket::payTimeExpire),
                    () -> assertEquals(State.USED, ticket.getState())
            );
        }

        @Test
        @DisplayName("❌ 已取消 (CANCELLED_NON_PAY) 訂單不得復活付款或登機")
        void cancelledTicketRejectsAllTransitions() {
            AirlineTicket ticket = AirlineTicket.giveInfo("Kate", "CI-008");
            ticket.payTimeExpire();

            assertAll("CANCELLED_NON_PAY 終止狀態不變量",
                    () -> assertThrows(IllegalStateException.class, ticket::payMoney, "逾期取消後不可再付款"),
                    () -> assertThrows(IllegalStateException.class, ticket::print),
                    () -> assertThrows(IllegalStateException.class, ticket::giveTicket),
                    () -> assertThrows(IllegalStateException.class, ticket::cancel),
                    () -> assertThrows(IllegalStateException.class, ticket::payTimeExpire),
                    () -> assertEquals(State.CANCELLED_NON_PAY, ticket.getState())
            );
        }
    }
}
