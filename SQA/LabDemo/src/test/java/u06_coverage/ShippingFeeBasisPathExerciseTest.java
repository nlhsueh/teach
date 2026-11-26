package u06_coverage;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit 06 複雜度與基本路徑練習：ShippingFeeCalculator 基本路徑測試 (Exercise)
 *
 * 實習手冊：LabDemo/docs/u06_wbtesting/metrics.md
 * 說明：本檔案目前僅提供 Path 1 與 Path 2（部分涵蓋度）。
 * 請先繪製 calculateFeeNested 的控制流程圖 (CFG) 並導出所有線性獨立基本路徑，
 * 再執行：
 *   mvn clean test -Dtest=ShippingFeeBasisPathExerciseTest jacoco:report
 * 補齊剩餘的 Path 3 ~ Path 6，驗證兩版實作結果完全等價並達成 100% 分支涵蓋！
 */
@DisplayName("Unit 06 練習：ShippingFeeCalculator 基本路徑與重構驗證")
class ShippingFeeBasisPathExerciseTest {

    @Test
    @DisplayName("Path 1 (範例)：非法金額 (amount <= 0) 回傳 -1")
    void testInvalidAmount() {
        assertEquals(-1, ShippingFeeCalculator.calculateFeeNested(0, false, false, false));
        assertEquals(-1, ShippingFeeCalculator.calculateFeeRefactored(0, false, false, false));
    }

    @Test
    @DisplayName("Path 2 (範例)：VIP 滿 1000 免運（偏遠地區亦免運）")
    void testVipFreeShipping() {
        assertEquals(0, ShippingFeeCalculator.calculateFeeNested(1000, true, true, false));
        assertEquals(0, ShippingFeeCalculator.calculateFeeRefactored(1000, true, true, false));
    }

    // =========================================================================
    // TODO 1 (Path 3 & 4)：補寫「VIP 未滿 1000」的一般地區 (30) 與偏遠地區 (80) 測試
    // 提示：同時驗證 calculateFeeNested 與 calculateFeeRefactored 結果一致
    // =========================================================================

    // =========================================================================
    // TODO 2 (Path 5 & 6)：補寫「一般會員」有折價券 (50) 與無折價券＋偏遠地區 (130) 測試
    // 提示：執行 JaCoCo 確認所有紅行與黃色菱形皆轉為綠色（Branch Coverage 100%）
    // =========================================================================
}
