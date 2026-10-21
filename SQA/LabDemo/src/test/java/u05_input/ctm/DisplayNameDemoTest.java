package u05_input.ctm;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 💡 課堂示範 (Demo 5.6)：@DisplayName 繁中活規格與測試命名生成器
 * 
 * 【教學核心觀念】：
 * 1. 敏捷活規格 (Living Documentation)：測試案例的名稱應該是領域業務規格的映射，而非難以閱讀的駝峰英文。
 * 2. @DisplayName 支援空白字元、特殊符號與 Emoji，讓測試報告直接變成需求驗收清單。
 * 3. @Nested 支援在測試類別內部進行「階層化分群」，與分類樹方法 (CTM) 的樹狀分類完美對齊。
 */
@DisplayName("Unit 5.6 示範：測試命名規格化與 @Nested 階層組織")
public class DisplayNameDemoTest {

    @Test
    @DisplayName("🎯 案例 1：支援繁體中文自然語言與 Emoji 標題")
    void testWithChineseAndEmoji() {
        assertTrue(true);
    }

    @Nested
    @DisplayName("🌳 分類樹分支：閏年規則檢驗 (A_year_is_a_leap_year)")
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class LeapYearRules {

        @Test
        @DisplayName("規則 A：若能被 4 整除但不能被 100 整除，則為閏年")
        void if_divisible_by_4_but_not_100() {
            int year = 2024;
            boolean isLeap = (year % 4 == 0 && year % 100 != 0);
            assertTrue(isLeap);
        }

        @ParameterizedTest(name = "年份 {0} 應判定為閏年")
        @ValueSource(ints = { 2000, 2016, 2020, 2024, 2028 })
        void valid_leap_years(int year) {
            boolean isLeap = (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
            assertTrue(isLeap);
        }
    }
}
