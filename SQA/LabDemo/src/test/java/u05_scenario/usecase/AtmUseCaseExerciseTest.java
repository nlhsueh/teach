package u05_scenario.usecase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 🧪 課堂動手練習 (Exercise 5.9)：使用案例測試矩陣實戰 (例外流與狀態保護)
 * 
 * 請閱讀【提示 (Hints)】，參考註解中的提示語法，
 * 親手打出程式碼並移除 fail(...) 以通過測試。
 */
@DisplayName("Unit 5.9 練習：ATM 提款例外流測試練習題")
public class AtmUseCaseExerciseTest {

    private AtmWithdrawService atmService;
    private AtmWithdrawService.Account account;

    @BeforeEach
    void setUp() {
        atmService = new AtmWithdrawService();
        // 初始帳戶餘額 20,000 元，正確密碼為 "1234"
        account = new AtmWithdrawService.Account("6666-8888", "1234", 20000);
    }

    // =========================================================================
    // 💡 練習 1 提示 (Hints)：密碼連續錯誤累計與鎖卡例外流 (Exception Flow 4)
    // 1. 第 1 次輸錯密碼 ("0000") ➔ 回傳 INVALID_PIN，卡片未鎖定。
    // 2. 第 2 次輸錯密碼 ("1111") ➔ 回傳 INVALID_PIN，卡片未鎖定。
    // 3. 第 3 次輸錯密碼 ("9999") ➔ 達到 3 次上限，回傳 CARD_LOCKED，帳戶狀態 isLocked 變為 true！
    // 4. 卡片鎖定後，即使第 4 次輸入正確密碼 ("1234")，系統仍必須拒絕交易！
    // =========================================================================
    @Test
    @DisplayName("練習 1：密碼連續輸入錯誤 3 次導致鎖卡例外流驗證")
    void exercise1_testConsecutiveWrongPinsLockCard() {
        // [Step 1] 第 1 次錯誤
        AtmWithdrawService.WithdrawResult r1 = atmService.withdraw(account, "0000", 1000);
        assertEquals(AtmWithdrawService.TransactionStatus.INVALID_PIN, r1.status);
        assertFalse(account.isLocked());

        // [Step 2] 第 2 次錯誤
        AtmWithdrawService.WithdrawResult r2 = atmService.withdraw(account, "1111", 1000);
        assertEquals(AtmWithdrawService.TransactionStatus.INVALID_PIN, r2.status);
        assertFalse(account.isLocked());

        // [Step 3] 第 3 次錯誤 (觸發鎖卡)
        // TODO: 請執行第 3 次錯誤密碼 ("9999") 提款，並斷言 status 為 CARD_LOCKED 且 account.isLocked() 為 true：
        // AtmWithdrawService.WithdrawResult r3 = atmService.withdraw(account, "9999", 1000);
        // assertEquals(AtmWithdrawService.TransactionStatus.CARD_LOCKED, r3.status, "連續第3次錯誤應觸發鎖卡");
        // assertTrue(account.isLocked(), "帳戶實體屬性 isLocked 應被標記為 true");

        // [Step 4] 鎖卡後的防衛性驗證：即使密碼正確，依然無法提款
        // TODO: 請使用正確密碼 "1234" 嘗試提款，斷言交易依然被拒絕 (CARD_LOCKED) 且餘額維持 20000，完成後刪除 fail(...)：
        // AtmWithdrawService.WithdrawResult r4 = atmService.withdraw(account, "1234", 1000);
        // assertEquals(AtmWithdrawService.TransactionStatus.CARD_LOCKED, r4.status, "卡片鎖定後即使密碼正確亦不可交易");
        // assertEquals(20000, account.getBalance(), "未成功交易前餘額不得扣除");
        fail("尚未完成練習 1：請完成第 3 次錯誤鎖卡與第 4 次鎖卡後拒絕提款之斷言");
    }

    // =========================================================================
    // 💡 練習 2 提示 (Hints)：輸錯 2 次後輸入正確密碼重置失敗計數
    // 1. 輸錯 2 次密碼 ("wrong1", "wrong2")。
    // 2. 第 3 次輸入正確密碼 ("1234") 提款 2,000 元 ➔ 交易成功！
    // 3. 失敗次數被重置，卡片不會被鎖定。
    // =========================================================================
    @Test
    @DisplayName("練習 2：輸錯 2 次後輸入正確密碼成功並重置計數")
    void exercise2_testCorrectPinResetsFailedAttempts() {
        // 輸錯 2 次
        atmService.withdraw(account, "wrong1", 1000);
        atmService.withdraw(account, "wrong2", 1000);

        // TODO: 請在第 3 次輸入正確密碼 "1234" 提款 2000 元，
        // 斷言 status 為 SUCCESS、餘額扣至 18000 元且卡片未鎖定，完成後刪除 fail(...)：
        // AtmWithdrawService.WithdrawResult result = atmService.withdraw(account, "1234", 2000);
        // assertEquals(AtmWithdrawService.TransactionStatus.SUCCESS, result.status);
        // assertEquals(18000, account.getBalance());
        // assertFalse(account.isLocked());
        fail("尚未完成練習 2：請驗證第 3 次輸入正確密碼時提款成功並重置失敗計數");
    }
}
