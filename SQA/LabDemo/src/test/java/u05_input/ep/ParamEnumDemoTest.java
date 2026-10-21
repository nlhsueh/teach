package u05_input.ep;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 💡 課堂示範：@EnumSource 列舉型別參數化測試
 */
@DisplayName("Unit 5.4 示範：@EnumSource 列舉參數注入")
public class ParamEnumDemoTest {

    @ParameterizedTest(name = "列舉單位: {0}")
    @DisplayName("示範 1：自動注入所有 ChronoUnit 列舉項目")
    @EnumSource(ChronoUnit.class)
    void testWithEnumSource(TemporalUnit unit) {
        assertNotNull(unit);
    }

    @ParameterizedTest(name = "特定時間單位: {0}")
    @DisplayName("示範 2：過濾特定列舉值 (names 屬性)")
    @EnumSource(names = { "DAYS", "HOURS" })
    void testWithEnumSourceInclude(ChronoUnit unit) {
        assertTrue(EnumSet.of(ChronoUnit.DAYS, ChronoUnit.HOURS).contains(unit));
    }
}
