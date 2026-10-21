package u05_scenario.state;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 💡 課堂示範 (Demo 5.8-B)：Player 角色能量與狀態機測試
 * 
 * 狀態定義：
 * - "正常"：能量 30 ~ 100
 * - "虛弱"：能量 < 30
 * - "超人"：能量 > 100
 */
@DisplayName("Unit 5.8 示範：Player 狀態機轉移路徑測試")
public class PlayerStateDemoTest {

    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player(); // 初始能量 100，狀態為「正常」
    }

    @Test
    @DisplayName("路徑 1：初始正常狀態 ➔ 連續移動 ➔ 能量扣減")
    void testInitialStateAndMove() {
        assertEquals("正常", player.getStatus());
        assertEquals(100, player.getEnergy());

        player.move(); // 移動消耗 2 能量
        assertEquals(98, player.getEnergy());
        assertEquals("正常", player.getStatus());
    }

    @Test
    @DisplayName("路徑 2：吃仙丹 (+10) ➔ 能量超過 100 ➔ 進入【超人狀態】")
    void testTransitionToSuperman() {
        player.eatElixir(); // 100 + 10 = 110

        assertEquals("超人", player.getStatus(), "能量超過 100 應進入超人狀態");
        player.move(); // 超人狀態移動僅消耗 1 能量
        assertEquals(109, player.getEnergy());
    }

    @Test
    @DisplayName("路徑 3：連續被打 (-20) ➔ 能量低於 30 ➔ 進入【虛弱狀態】")
    void testTransitionToWeak() {
        // 連續被打 4 次：100 - (20 * 4) = 20
        player.takeHit();
        player.takeHit();
        player.takeHit();
        player.takeHit();

        assertEquals(20, player.getEnergy());
        assertEquals("虛弱", player.getStatus(), "能量低於 30 應轉入虛弱狀態");
    }
}
