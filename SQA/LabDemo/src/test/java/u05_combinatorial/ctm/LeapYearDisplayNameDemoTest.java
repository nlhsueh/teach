package u05_combinatorial.ctm;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 💡 補充示範：以閏年規則展示 @DisplayNameGeneration 自動將底線方法名轉譯為自然語意句子
 * 
 * （已自 DisplayNameDemoTest 獨立拆分出來，方便單獨觀察 @DisplayNameGeneration 效果）
 */
@DisplayName("補充示範：閏年規則與 @DisplayNameGeneration 自動語意轉譯")
public class LeapYearDisplayNameDemoTest {

    @Nested
    @DisplayName("🌳 閏年成立規則分支 (A_year_is_a_leap_year)")
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

    @Nested
    @DisplayName("🍂 平年規則分支 (A_year_is_not_a_leap_year)")
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class NonLeapYearRules {

        @ParameterizedTest(name = "年份 {0} 不應判定為閏年 (平年)")
        @ValueSource(ints = { 1900, 2021, 2022, 2023 })
        void common_years_are_not_leap_years(int year) {
            boolean isLeap = (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
            assertFalse(isLeap);
        }
    }
}
