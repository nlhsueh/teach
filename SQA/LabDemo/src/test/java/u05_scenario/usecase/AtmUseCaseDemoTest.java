package u05_scenario.usecase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 💡 課堂示範 (Demo 5.10)：使用案例測試 (Use Case Testing) 與情境矩陣
 * 
 * 【教學核心觀念】：
 * 1. 系統層級黑箱視角：跳脫單一函數輸入，從真實使用者的端對端 (End-to-End) 業務場景展開測試。
 * 2. 使用案例測試矩陣四大流程路徑：
 *    - 基本流 (Happy Path / 流 1)：完全順暢無異常的主業務流程。
 *    - 替代流 (Alternative Path / 流 2)：遇到條件分歧，經由使用者重新修正後順利抵達成功終點。
 *    - 例外流 (Exception Path / 流 3 & 4)：不可逆異常觸發交易中止或安全防衛機制。
 * 3. 測試不變量：驗收業務完整狀態（餘額扣減、吐鈔金額、卡片狀態與操作紀錄）。
 */
@DisplayName("Unit 5.10 示範：ATM 提款使用案例情境矩陣測試")
public class AtmUseCaseDemoTest {

    private AtmWithdrawService atmService;
    private AtmWithdrawService.Account account;

    @BeforeEach
    void setUp() {
        atmService = new AtmWithdrawService();
        // 準備測試帳戶：卡號 "1234-5678", 密碼 "8888", 餘額 50,000 元
        account = new AtmWithdrawService.Account("1234-5678", "8888", 50000);
    }

    @Test
    @DisplayName("場景 1【基本流 Happy Path】：輸入正確密碼 ➔ 提款 5,000 元 ➔ 成功吐鈔並扣款")
    void testHappyPath_withdrawSuccess() {
        // [Act] 執行提款基本流
        AtmWithdrawService.WithdrawResult result = 
                atmService.withdraw(account, "8888", 5000);

        // [Assert] 驗證端對端業務狀態完整性
        assertAll("基本流完整業務驗收",
                () -> assertEquals(AtmWithdrawService.TransactionStatus.SUCCESS, result.status, "交易狀態應為 SUCCESS"),
                () -> assertEquals(5000, result.dispensedAmount, "吐鈔金額應為 5,000 元"),
                () -> assertEquals(45000, result.remainingBalance, "帳戶餘額應由 50,000 扣減至 45,000 元"),
                () -> assertEquals(45000, account.getBalance(), "實體帳戶狀態必須同步扣款")
        );
    }

    @Test
    @DisplayName("場景 2【替代流 Alternative Path】：金額超過單筆上限 ➔ 提示拒絕 ➔ 重新輸入合法金額成功")
    void testAlternativePath_exceedLimitThenCorrect() {
        // Step 1: 客戶嘗試單筆提款 30,000 元 (超過單筆 20,000 上限)
        AtmWithdrawService.WithdrawResult attempt1 = 
                atmService.withdraw(account, "8888", 30000);

        assertEquals(AtmWithdrawService.TransactionStatus.EXCEEDS_LIMIT, attempt1.status);
        assertEquals(0, attempt1.dispensedAmount, "超過上限不可吐鈔");
        assertEquals(50000, account.getBalance(), "帳戶餘額不應扣款");

        // Step 2: 系統提示後，客戶改提合法金額 15,000 元
        AtmWithdrawService.WithdrawResult attempt2 = 
                atmService.withdraw(account, "8888", 15000);

        assertEquals(AtmWithdrawService.TransactionStatus.SUCCESS, attempt2.status);
        assertEquals(15000, attempt2.dispensedAmount);
        assertEquals(35000, account.getBalance());
    }

    @Test
    @DisplayName("場景 3【例外流 Exception Path】：帳戶餘額不足 ➔ 拒絕交易並退卡")
    void testExceptionPath_insufficientBalance() {
        // 帳戶餘額 50,000 元，但若建立一個餘額僅 3,000 元之帳戶，嘗試提款 10,000 元 (符合單筆上限但餘額不足)
        AtmWithdrawService.Account poorAccount = 
                new AtmWithdrawService.Account("9999-0000", "8888", 3000);

        AtmWithdrawService.WithdrawResult result = 
                atmService.withdraw(poorAccount, "8888", 10000);

        assertEquals(AtmWithdrawService.TransactionStatus.INSUFFICIENT_BALANCE, result.status);
        assertEquals(0, result.dispensedAmount);
        assertEquals(3000, poorAccount.getBalance(), "餘額不足交易失敗，餘額維持 3,000 元不變");
    }
}
