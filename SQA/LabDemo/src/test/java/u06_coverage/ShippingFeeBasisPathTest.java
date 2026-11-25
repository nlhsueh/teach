package u06_coverage;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit 06 Lab 2：ShippingFeeCalculator 基本路徑測試與重構等價驗證
 */
@DisplayName("Lab 2：ShippingFeeCalculator 基本路徑與重構驗證")
class ShippingFeeBasisPathTest {

    @Test
    @DisplayName("Path 1：非法金額 (amount <= 0) 回傳 -1")
    void testInvalidAmount() {
        assertEquals(-1, ShippingFeeCalculator.calculateFeeNested(0, false, false, false));
        assertEquals(-1, ShippingFeeCalculator.calculateFeeRefactored(0, false, false, false));
    }

    @Test
    @DisplayName("Path 2：VIP 滿 1000 免運（偏遠地區亦免運）")
    void testVipFreeShipping() {
        assertEquals(0, ShippingFeeCalculator.calculateFeeNested(1000, true, true, false));
        assertEquals(0, ShippingFeeCalculator.calculateFeeRefactored(1000, true, true, false));
    }

    @Test
    @DisplayName("Path 3 & 4：VIP 未滿 1000（一般地區 30 / 偏遠地區 80）")
    void testVipUnderThreshold() {
        assertEquals(30, ShippingFeeCalculator.calculateFeeNested(500, true, false, false));
        assertEquals(30, ShippingFeeCalculator.calculateFeeRefactored(500, true, false, false));
        assertEquals(80, ShippingFeeCalculator.calculateFeeNested(500, true, true, false));
        assertEquals(80, ShippingFeeCalculator.calculateFeeRefactored(500, true, true, false));
    }

    @Test
    @DisplayName("Path 5 & 6：一般會員（有折價券 50 / 無折價券 80，偏遠加收 50）")
    void testRegularMember() {
        assertEquals(50, ShippingFeeCalculator.calculateFeeNested(500, false, false, true));
        assertEquals(50, ShippingFeeCalculator.calculateFeeRefactored(500, false, false, true));
        assertEquals(130, ShippingFeeCalculator.calculateFeeNested(500, false, true, false));
        assertEquals(130, ShippingFeeCalculator.calculateFeeRefactored(500, false, true, false));
    }
}
