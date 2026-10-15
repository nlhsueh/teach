package u03_principles;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 實驗單元 03：Test Oracle 困境與變質測試 (Metamorphic Testing) 沙盒
 * 
 * 核心教學目標：
 * 1. 體會「測試預言問題 (Test Oracle Problem)」：當被測系統演算法非常複雜時，
 *    人類測試員無法事先精確計算出 assertEquals 的預期值。
 * 2. 實踐陳振宇 (T.Y. Chen) 教授的「變質關係 (Metamorphic Relations, MRs)」：
 *    不比對絕對輸出數值，改為檢驗多次執行間的相對變換不變量！
 */
public class OracleSandboxTest {

    private RoutePlanner planner;
    private RoutePlanner.RoadGraph complexCityGraph;

    @BeforeEach
    void setUp() {
        planner = new RoutePlanner();
        complexCityGraph = new RoutePlanner.RoadGraph();

        // 建立一個包含 12 個節點、20 條雙向加權道路的複雜城市網絡
        // 節點：Taipei, Banqiao, Taoyuan, Hsinchu, Taichung, Changhua,
        //      Chiayi, Tainan, Kaohsiung, Pingtung, Yilan, Hualien
        complexCityGraph.addEdge("Taipei", "Banqiao", 8.5);
        complexCityGraph.addEdge("Taipei", "Yilan", 52.0);
        complexCityGraph.addEdge("Banqiao", "Taoyuan", 23.4);
        complexCityGraph.addEdge("Taoyuan", "Hsinchu", 45.2);
        complexCityGraph.addEdge("Hsinchu", "Taichung", 90.8);
        complexCityGraph.addEdge("Taichung", "Changhua", 18.3);
        complexCityGraph.addEdge("Changhua", "Chiayi", 65.1);
        complexCityGraph.addEdge("Chiayi", "Tainan", 58.7);
        complexCityGraph.addEdge("Tainan", "Kaohsiung", 42.6);
        complexCityGraph.addEdge("Kaohsiung", "Pingtung", 25.0);
        complexCityGraph.addEdge("Yilan", "Hualien", 98.4);
        // 支線與山線/快速道路交錯
        complexCityGraph.addEdge("Taipei", "Taoyuan", 28.0);
        complexCityGraph.addEdge("Banqiao", "Hsinchu", 64.0);
        complexCityGraph.addEdge("Taoyuan", "Taichung", 132.5);
        complexCityGraph.addEdge("Taichung", "Chiayi", 82.0);
        complexCityGraph.addEdge("Hsinchu", "Changhua", 105.0);
        complexCityGraph.addEdge("Chiayi", "Kaohsiung", 95.0);
        complexCityGraph.addEdge("Hualien", "Tainan", 240.0);
    }

    /**
     * 觀念展示：在小圖形中，我們能輕易手算預期輸出 (Traditional Example-Based Test)
     */
    @Test
    @DisplayName("傳統範例測試：在簡單 3 節點圖形中，有明確的預期數值 Oracle")
    void testSimpleTriangleGraphWithExplicitOracle() {
        RoutePlanner.RoadGraph smallGraph = new RoutePlanner.RoadGraph();
        smallGraph.addEdge("A", "B", 10.0);
        smallGraph.addEdge("B", "C", 15.0);
        smallGraph.addEdge("A", "C", 30.0);

        // 人類可輕易算出來：A -> B -> C = 25.0 < 30.0
        double expected = 25.0;
        double actual = planner.findShortestDistance(smallGraph, "A", "C");

        assertEquals(expected, actual, 0.001, "手算預期答案為 25.0");
    }

    /**
     * 【變質關係 MR-1：對稱與等價性 (Symmetry Invariance)】
     * 哲學：在無向路網中，從 A 到 B 的最短距離，必須等於從 B 到 A 的最短距離！
     * 優勢：完全不需知道距離究竟是 254.3 還是 310.8，只要不對稱，演算法必有 Bug！
     */
    @Test
    @DisplayName("MR-1 (對稱性)：無向圖中 dist(A, B) 必須等於 dist(B, A)")
    void metamorphicRelation_Symmetry() {
        String start = "Taipei";
        String end = "Kaohsiung";

        // 1. 原始執行 (Source Execution)
        double forwardDist = planner.findShortestDistance(complexCityGraph, start, end);

        // 2. 變質變換執行 (Follow-up Execution: 起終點對調)
        double backwardDist = planner.findShortestDistance(complexCityGraph, end, start);

        // 3. 變質關係判定 (MR Verification)
        assertTrue(forwardDist > 0 && forwardDist < Double.POSITIVE_INFINITY, "起終點應可達");
        assertEquals(forwardDist, backwardDist, 0.0001,
            "變質關係違規：無向圖雙向最短路徑不對稱！");
    }

    /**
     * 【變質關係 MR-2：比例縮放一致性 (Scaling Consistency)】
     * 哲學：若將全圖所有道路權重同乘以 k 倍（例如英哩換算成公里，k = 1.60934），
     *      則計算出的最短距離必然剛好等於原距離乘以 k 倍！
     */
    @ParameterizedTest
    @ValueSource(doubles = {2.0, 5.0, 0.5, 1.60934})
    @DisplayName("MR-2 (比例縮放)：道路權重放大 k 倍，最短路徑長度必須精確放大 k 倍")
    void metamorphicRelation_ScalingConsistency(double scaleFactor) {
        String start = "Taipei";
        String end = "Pingtung";

        // 1. 原始執行
        double baseDistance = planner.findShortestDistance(complexCityGraph, start, end);

        // 2. 變質變換：將路網所有權重放大 k 倍
        RoutePlanner.RoadGraph scaledGraph = complexCityGraph.scaleWeights(scaleFactor);
        double scaledDistance = planner.findShortestDistance(scaledGraph, start, end);

        // 3. 變質關係判定：scaled == base * scaleFactor
        double expectedScaled = baseDistance * scaleFactor;
        assertEquals(expectedScaled, scaledDistance, 0.001,
            String.format("變質關係違規：權重放大 %.2f 倍後，最短距離未等比例縮放！", scaleFactor));
    }

    /**
     * 【變質關係 MR-3：中繼節點三角不等式 (Triangle Inequality)】
     * 哲學：對於圖中任意中繼點 C，從 A 直達 B 的最短距離必然 <= (A 到 C) + (C 到 B)。
     */
    @Test
    @DisplayName("MR-3 (三角不等式)：dist(A, B) <= dist(A, C) + dist(C, B)")
    void metamorphicRelation_TriangleInequality() {
        String a = "Taipei";
        String b = "Kaohsiung";
        String c = "Taichung"; // 中繼點

        double distAB = planner.findShortestDistance(complexCityGraph, a, b);
        double distAC = planner.findShortestDistance(complexCityGraph, a, c);
        double distCB = planner.findShortestDistance(complexCityGraph, c, b);

        assertTrue(distAB <= (distAC + distCB) + 0.0001,
            "變質關係違規：直達最短路徑竟然比繞道中繼點還要長！違反三角不等式！");
    }

    /**
     * 【變質關係 MR-4：無關獨立節點抗擾動性 (Irrelevant Perturbation)】
     * 哲學：在城市路網中加入一個尚未連通的新外島或孤立節點 (如 Penghu)，
     *      本島任何兩點之間的最短距離絕對不可受任何影響！
     */
    @Test
    @DisplayName("MR-4 (無關擾動)：加入孤立節點後，原有節點間之最短距離恆定不變")
    void metamorphicRelation_IrrelevantNodePerturbation() {
        String start = "Taipei";
        String end = "Hualien";

        // 1. 原始執行
        double originalDist = planner.findShortestDistance(complexCityGraph, start, end);

        // 2. 變質變換：複製圖並注入孤立節點
        RoutePlanner.RoadGraph perturbedGraph = complexCityGraph.copy();
        perturbedGraph.addNode("Penghu_Isolated");
        perturbedGraph.addNode("Green_Island_Isolated");

        // 3. 後續執行
        double perturbedDist = planner.findShortestDistance(perturbedGraph, start, end);

        // 4. 變質關係判定
        assertEquals(originalDist, perturbedDist, 0.0001,
            "變質關係違規：加入無關孤立節點竟導致原最短路徑距離改變！");
    }
}
