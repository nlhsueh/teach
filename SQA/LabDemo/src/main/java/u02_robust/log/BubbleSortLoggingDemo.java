package u02_robust.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.Arrays;
import java.util.UUID;

/**
 * 氣泡排序日誌機制教學展示範例：BubbleSortLoggingDemo (SLF4J + Log4j 2)
 *
 * 【核心學習目標】：
 * 1. 門面模式 (Logging Facade)：
 *    - 使用 SLF4J 的 LoggerFactory.getLogger(...) 實現門面與日誌底層實作解耦。
 * 2. 結構化日誌等級階梯 (Log Levels)：
 *    - TRACE: 極細粒度步驟追蹤（每次相鄰元素比對與數值交換）。
 *    - DEBUG: 演算法內部狀態轉換（每輪 pass 結束、提前結束旗標）。
 *    - INFO : 業務關鍵里程碑與效能度量（排序開始、陣列長度、總耗時 ms）。
 *    - WARN : 潛在非預期但系統仍可運作之警訊（空陣列、單元素、已排序輸入）。
 *    - ERROR: 業務失敗或合約違反，傳入 Throwable 記錄完整堆疊追蹤 (Call Stack)。
 * 3. 效能優化準則：
 *    - 佔位符 (Parameterized Logging): logger.info("長度: {}", len)，避免無謂字串拼接。
 *    - 守衛語句 (Guard Statement): if (logger.isDebugEnabled()) 防止昂貴的 Arrays.toString() 提前求值。
 * 4. MDC (Mapped Diagnostic Context) 上下文追蹤：
 *    - 在分散式系統與多執行緒中注入 taskId / userId，便於日誌鏈路追蹤與 ELK 聚合分析。
 */
public class BubbleSortLoggingDemo {

    // 1. 標準 SLF4J Logger 宣告（private static final）
    private static final Logger logger = LoggerFactory.getLogger(BubbleSortLoggingDemo.class);

    /**
     * 具備完整日誌防禦與追蹤的氣泡排序
     *
     * @param data 待排序整數陣列
     * @return 排序後的陣列
     */
    public static int[] sortWithLogging(int[] data) {
        long startTime = System.currentTimeMillis();

        // 2. 邊界與參數防禦 (WARN / ERROR)
        if (data == null) {
            IllegalArgumentException ex = new IllegalArgumentException("待排序陣列不可為 null (契約前置失敗)");
            logger.error("排序執行失敗！傳入非法參數: null", ex);
            throw ex;
        }

        int length = data.length;

        // WARN: 潛在無效率或特殊邊界輸入警訊
        if (length <= 1) {
            logger.warn("輸入陣列長度為 {} (<= 1)，無須執行氣泡排序，直接返回", length);
            return data;
        }

        // INFO: 記錄排序流程開始與資料特徵
        logger.info("開始執行氣泡排序演算法，陣列長度: {}，預估最差複雜度: O(n^2)", length);

        int totalComparisons = 0;
        int totalSwaps = 0;
        boolean earlyTerminated = false;

        // 3. 排序核心迴圈與細部日誌
        for (int pass = 0; pass < length - 1; pass++) {
            boolean swapped = false;

            for (int i = 0; i < length - pass - 1; i++) {
                totalComparisons++;

                // TRACE: 極細微步驟，僅在底層演算法除錯時開啟
                if (logger.isTraceEnabled()) {
                    logger.trace("第 {} 輪比對: data[{}]={} 與 data[{}]={}",
                            pass + 1, i, data[i], i + 1, data[i + 1]);
                }

                if (data[i] > data[i + 1]) {
                    int temp = data[i];
                    data[i] = data[i + 1];
                    data[i + 1] = temp;
                    swapped = true;
                    totalSwaps++;

                    if (logger.isTraceEnabled()) {
                        logger.trace(" ↳ 觸發數值交換: 交換為 {} 與 {}", data[i], data[i + 1]);
                    }
                }
            }

            // DEBUG + 守衛條件 (Guard Statement)：
            // 只有在 DEBUG 等級開啟時，才執行昂貴的 Arrays.toString(data) 字串序列化
            if (logger.isDebugEnabled()) {
                logger.debug("第 {} 輪排序完成 | 本輪是否交換: {} | 當前中繼陣列: {}",
                        pass + 1, swapped, Arrays.toString(data));
            }

            // 提前終止優化
            if (!swapped) {
                earlyTerminated = true;
                logger.debug("第 {} 輪無任何元素交換，陣列已提前達到有序狀態，觸發提早跳出 (Early Break)", pass + 1);
                break;
            }
        }

        long duration = System.currentTimeMillis() - startTime;

        // 4. INFO: 里程碑完成與統計度量
        logger.info("氣泡排序成功完成！耗時: {} ms | 總比對次數: {} | 總交換次數: {} | 是否提前終止: {}",
                duration, totalComparisons, totalSwaps, earlyTerminated);

        // 5. 後置條件檢查 (Post-condition Verification) 與 ERROR 示範
        verifySorted(data);

        return data;
    }

    /**
     * 驗證排序結果是否符合非遞減順序
     */
    private static void verifySorted(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i] > data[i + 1]) {
                IllegalStateException stateEx = new IllegalStateException(
                        String.format("排序後置條件檢查失敗！在索引 [%d] 處 %d > %d", i, data[i], data[i + 1]));
                // ERROR: 記錄錯誤並傳入 Exception 物件列印完整 Call Stack
                logger.error("氣泡排序後置合約遭到破壞！系統狀態異常: {}", Arrays.toString(data), stateEx);
                throw stateEx;
            }
        }
    }

    /**
     * 配合 MDC (Mapped Diagnostic Context) 進行端對端任務鏈路追蹤
     */
    public static void sortTaskWithMdc(String taskId, String operator, int[] data) {
        try {
            // 在當前執行緒上下文綁定標籤
            MDC.put("taskId", taskId);
            MDC.put("operator", operator);

            logger.info("收到來自操作員 [{}] 的排序請求任務", operator);
            sortWithLogging(data);
            logger.info("任務 [{}] 處理完畢", taskId);

        } finally {
            // 必須在 finally 中清理，避免執行緒池 (Thread Pool) 污染
            MDC.clear();
        }
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" SQA 實習示範：BubbleSortLoggingDemo (SLF4J + Log4j 2)");
        System.out.println("==================================================");

        // 情境 1：正常未排序陣列（觀察 INFO, DEBUG 與 TRACE）
        System.out.println("\n--- [情境 1] 正常排序測試 ---");
        int[] arr1 = {64, 34, 25, 12, 22, 11, 90};
        sortWithLogging(arr1);

        // 情境 2：單元素陣列（觸發 WARN 警訊）
        System.out.println("\n--- [情境 2] 單元素陣列邊界測試 ---");
        int[] arr2 = {42};
        sortWithLogging(arr2);

        // 情境 3：使用 MDC 追蹤任務
        System.out.println("\n--- [情境 3] MDC 鏈路上下文追蹤 ---");
        int[] arr3 = {5, 1, 4, 2, 8};
        sortTaskWithMdc("TASK-" + UUID.randomUUID().toString().substring(0, 8), "Prof.Hsueh", arr3);

        // 情境 4：非法 null 參數（觸發 ERROR 並列印 Call Stack）
        System.out.println("\n--- [情境 4] 非法參數防禦與 ERROR 記錄 ---");
        try {
            sortWithLogging(null);
        } catch (IllegalArgumentException e) {
            System.out.println("捕獲預期例外: " + e.getMessage());
        }

        System.out.println("\n==================================================");
        System.out.println(" 展示完成！請觀察主控台與日誌輸出格式");
        System.out.println("==================================================");
    }
}
