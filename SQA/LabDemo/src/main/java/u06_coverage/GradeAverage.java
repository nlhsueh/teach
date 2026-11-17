package u06_coverage;

/**
 * 學生成績平均計算程式
 * 供 Unit 06 控制流程圖 (CFG)、McCabe 圈複雜度 V(G) 與基本路徑測試 (Basis Path Testing) 示範。
 *
 * 註解中的數字 (1) ~ (12) 代表 CFG 中的節點編號。
 * Predicate Nodes P = 5 ➔ 圈複雜度 V(G) = P + 1 = 6
 */
public class GradeAverage {

    public double computeAverage(int[] grade) {
        // 節點 (1)：變數初始化
        int sum = 0, max = 100, min = 10, valid = 0, index = 0;
        double average;

        // 判定節點 (2), (3)：迴圈終止符號與陣列長度邊界檢查
        while (grade[index] != -999 && index < 50) {
            // 判定節點 (4), (5)：成績範圍上下限檢查
            if (grade[index] >= min && grade[index] <= max) {
                // 節點 (6)：累加有效成績
                sum += grade[index];
                valid++;
            } else {
                // 節點 (7)：非法成績輸出警告
                System.out.println("成績範圍錯誤");
            }
            // 節點 (8)：索引遞增
            index++;
        }

        // 判定節點 (9)：有效成績筆數檢查
        if (valid > 0) {
            average = (double) sum / valid; // 節點 (10)：計算平均值
        } else {
            average = -999;                 // 節點 (11)：無有效成績回傳 -999
        }

        return average; // 節點 (12)：回傳結果
    }
}
