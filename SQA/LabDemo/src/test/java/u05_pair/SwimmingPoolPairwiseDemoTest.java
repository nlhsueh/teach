package u05_pair;

import io.github.pavelicii.allpairs4j.AllPairs;
import io.github.pavelicii.allpairs4j.Case;
import io.github.pavelicii.allpairs4j.Parameter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import u05_pair.SwimmingPoolPricing.DayType;
import u05_pair.SwimmingPoolPricing.TimeSlot;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 💡 課堂示範 A (Demo 5.5-A)：游泳池收費系統全成對測試與集合覆蓋步進驗證
 *
 * 對應投影片與講義範例：
 * - 時間 (TimeSlot, 3 種)：MORNING (t1), NOON (t2), OTHER (t3)
 * - 星期 (DayType, 2 種) ：HOLIDAY (d1), WEEKDAY (d2)
 * - 會員 (Member, 2 種)  ：true (m1), false (m2)
 * - 待覆蓋成對母集合 U = (3×2) + (3×2) + (2×2) = 16 個 Pairs
 * - 全乘積需要 3 × 2 × 2 = 12 組案例；全成對測試僅需 6 組案例即可 100% 覆蓋全部 16 個 Pairs！
 */
@DisplayName("Unit 5.5 示範 A：游泳池收費系統 AllPairs4J 與 16 組 Pairs 集合覆蓋驗證")
public class SwimmingPoolPairwiseDemoTest {

    @Test
    @DisplayName("示範 1：逐步盤點 IPO + Greedy (m1 vs. m2 計分比較) 如何挑選 6 組案例覆蓋 16 個 Pairs")
    void testSwimmingPoolSetCoverStepByStep() {
        String[] times = {"MORNING(t1)", "NOON(t2)", "OTHER(t3)"};
        String[] days = {"HOLIDAY(d1)", "WEEKDAY(d2)"};
        String[] members = {"true(m1)", "false(m2)"};

        System.out.println("======================================================================================================");
        System.out.println("  [SQA Lab 5.5-A] 游泳池收費系統：IPO 基底展開 + Greedy 貪婪計分 (m1 vs. m2) 逐步決策追蹤");
        System.out.println("======================================================================================================");
        System.out.printf("%-4s | %-11s | %-11s | %-12s | %-12s | %-15s | %-8s%n",
                "輪次", "時間基底(T)", "星期基底(D)", "若選 m1 得分", "若選 m2 得分", "貪婪勝出決策", "累計覆蓋");
        System.out.println("------------------------------------------------------------------------------------------------------");

        Set<String> coveredPairs = new HashSet<>();
        int round = 1;
        for (String t : times) {
            for (String d : days) {
                int gainM1 = countNewPairs(coveredPairs, t, d, members[0]);
                int gainM2 = countNewPairs(coveredPairs, t, d, members[1]);

                // 貪婪選擇條件：取新增覆蓋 Pair 數較高者；若平手 (gainM1 == gainM2)，依預設順序先選第一個值 m1
                String chosenM = (gainM1 >= gainM2) ? members[0] : members[1];
                int bestGain = Math.max(gainM1, gainM2);

                coveredPairs.add("T-D:" + t + "-" + d);
                coveredPairs.add("T-M:" + t + "-" + chosenM);
                coveredPairs.add("D-M:" + d + "-" + chosenM);

                System.out.printf("#%-3d | %-11s | %-11s | +%-11d | +%-11d | %-9s (+%d) | %2d / 16%n",
                        round++, t, d, gainM1, gainM2, chosenM, bestGain, coveredPairs.size());
            }
        }
        System.out.println("======================================================================================================");

        // 同時驗證 AllPairs4J 生成之案例數與覆蓋率
        List<Case> cases = buildSwimmingPoolCases();
        assertEquals(6, cases.size(), "3×2×2 的最小全成對測試集應為 6 組案例");
        assertEquals(16, coveredPairs.size(), "6 組案例必須 100% 涵蓋全部 (6+6+4)=16 個成對組合");
    }

    private static int countNewPairs(Set<String> coveredPairs, String t, String d, String m) {
        int newCount = 0;
        if (!coveredPairs.contains("T-D:" + t + "-" + d)) newCount++;
        if (!coveredPairs.contains("T-M:" + t + "-" + m)) newCount++;
        if (!coveredPairs.contains("D-M:" + d + "-" + m)) newCount++;
        return newCount;
    }

    @TestFactory
    @DisplayName("示範 2 (Oracle 策略 A - 屬性不變量)：AllPairs4J + @TestFactory 驗證不越界與通用規則")
    List<DynamicTest> dynamicSwimmingPoolPairwiseTests() {
        // ⚠️ 關鍵提問：AllPairs4J 只負責生成「輸入組合 (Inputs)」，不知道「預期輸出 (Expected Output)」怎麼辦？
        // 【策略 A：不變量與局部規則斷言 (Invariant Oracle)】
        // 當動態生成大量組合、不逐一人工算表時，可驗證「在任何組合下皆須成立的業務不變量」(例如票價必介於 50~200、會員必為 50 或 100)。
        List<Case> cases = buildSwimmingPoolCases();

        return cases.stream().map(c -> {
            TimeSlot time = TimeSlot.valueOf(c.get("TimeSlot").toString());
            DayType day = DayType.valueOf(c.get("DayType").toString());
            boolean isMember = Boolean.parseBoolean(c.get("IsMember").toString());

            String title = String.format("泳池成對案例: 時段=%s, 星期=%s, 會員=%b", time, day, isMember);

            return DynamicTest.dynamicTest(title, () -> {
                int price = SwimmingPoolPricing.calculatePrice(time, day, isMember);
                // 票價必定介於平日會員最低價 50 元與假日非會員最高價 200 元之間
                assertTrue(price >= 50 && price <= 200, "票價應介於 50 ~ 200 元合理區間");
                if (isMember) {
                    int expectedMemberPrice = (day == DayType.HOLIDAY) ? 100 : 50;
                    assertEquals(expectedMemberPrice, price, "會員應享五折優惠");
                }
            });
        }).collect(Collectors.toList());
    }

    // =========================================================================
    // 💡 關鍵觀念：Pairwise 工具只生「輸入組合」，實務上如何驗證精確的 Expected Output？
    // 【策略 B：兩階段精確預言機 (Two-Phase Exact Oracle)】
    //   階段 1 (下方示範 3-Step1)：執行 AllPairs4J 自動印出 @CsvSource 程式碼骨架（最後一欄留 TODO）。
    //   階段 2 (下方示範 3-Step2)：工程師複製貼上至測試方法，對照規格書 (SRS) 將 TODO 改為精確的 expectedPrice！
    // =========================================================================
    @Test
    @DisplayName("示範 3-Step1 (產生 @CsvSource 骨架)：由 AllPairs4J 自動印出可供複製貼上的 @CsvSource 樣板")
    void generateCsvSourceTemplateForPaste() {
        List<Case> cases = buildSwimmingPoolCases();

        System.out.println("====================================================================================");
        System.out.println("  [SQA Lab 5.5-A] 自動產出 @CsvSource 測試骨架（請複製貼上至下方測試，並補上 TODO 預期票價）");
        System.out.println("====================================================================================");
        System.out.println("@CsvSource({");
        System.out.println("    // TimeSlot, DayType, IsMember, ExpectedPrice (請對照 SRS 規格書填入預期票價)");
        for (int i = 0; i < cases.size(); i++) {
            Case c = cases.get(i);
            String comma = (i < cases.size() - 1) ? "," : " ";
            String row = String.format("%-8s %-8s %-6s TODO",
                    c.get("TimeSlot") + ",",
                    c.get("DayType") + ",",
                    c.get("IsMember") + ",");
            System.out.printf("    \"%s\"%s // #%d%n", row, comma, i + 1);
        }
        System.out.println("})");
        System.out.println("====================================================================================");

        assertEquals(6, cases.size());
    }

    @ParameterizedTest(name = "成對精確驗證 #{index}: 時段={0}, 星期={1}, 會員={2} ➔ 預期票價={3}元")
    @DisplayName("示範 3-Step2 (Oracle 策略 B - 精確預言機)：將 AllPairs 產出的 6 組組合補上 SRS 預期票價精確斷言")
    @CsvSource({
        // TimeSlot, DayType, IsMember, ExpectedPrice (由工程師對照 SRS 規格書計算填入：平日100/假日200，晨泳8折/午間9折/會員5折)
        "MORNING, HOLIDAY, true,  100", // #1: 假日(200) + 會員五折 = 100 元
        "MORNING, WEEKDAY, false,  80", // #2: 平日(100) + 非會員清晨八折 = 80 元
        "NOON,    HOLIDAY, false, 200", // #3: 假日(200) + 非會員不打折 = 200 元
        "NOON,    WEEKDAY, true,   50", // #4: 平日(100) + 會員五折 = 50 元
        "OTHER,   HOLIDAY, true,  100", // #5: 假日(200) + 會員五折 = 100 元
        "OTHER,   WEEKDAY, false, 100"  // #6: 平日(100) + 非會員一般時段原價 = 100 元
    })
    void testSwimmingPoolPairwiseWithExactOracle(TimeSlot time, DayType day, boolean isMember, int expectedPrice) {
        int actualPrice = SwimmingPoolPricing.calculatePrice(time, day, isMember);
        assertEquals(expectedPrice, actualPrice,
                () -> String.format("時段=%s, 星期=%s, 會員=%b 之票價計算錯誤", time, day, isMember));
    }

    /**
     * 🛠️ AllPairs4J 核心 API 使用四部曲：
     * 1. new Parameter(name, values...)：定義單一測試參數維度（Factor）及其所有候選取值水準（Levels）。
     * 2. new AllPairs.AllPairsBuilder()：建立建造者物件，透過 .withParameter(...) 依序註冊所有維度。
     *    （選填：.withTestCombinationSize(2) 指定 2-Way 成對；.withConstraint(...) 加入互斥條件過濾）
     * 3. .build()：正式啟動 IPO + Greedy 演算法，在記憶體中生成最小化之成對測試矩陣（AllPairs 物件）。
     * 4. .getGeneratedCases()：回傳 List<Case>，每個 Case 代表一列測試案例（繼承自 Map，可用 c.get(key) 取值）。
     */
    private static List<Case> buildSwimmingPoolCases() {
        AllPairs allPairs = new AllPairs.AllPairsBuilder()
                .withParameter(new Parameter("TimeSlot", "MORNING", "NOON", "OTHER"))
                .withParameter(new Parameter("DayType", "HOLIDAY", "WEEKDAY"))
                .withParameter(new Parameter("IsMember", "true", "false"))
                .build();
        return allPairs.getGeneratedCases();
    }
}

