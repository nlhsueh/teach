package u05_scenario.usecase;

/**
 * ATM 自動櫃員機提款服務 (供 Unit 5.10 使用案例與情境測試 Use Case Testing 示範)
 * 
 * 使用案例規格：
 * - 執行者 (Actor)：銀行客戶
 * - 先決條件：客戶持有有效晶片卡，ATM 機台處於連線就緒狀態
 * 
 * 流程分支矩陣：
 * 1. 基本流 (Happy Path / 流 1)：
 *    插入卡片 ➔ 密碼正確 ➔ 輸入提款金額 (<= 餘額且 <= 機台鈔票) ➔ 系統扣款 ➔ 吐鈔 ➔ 退卡。
 * 2. 替代流 (Alternative Path / 流 2)：
 *    輸入金額超過單筆上限 (20,000 元) ➔ 提示重新輸入 ➔ 改提合法金額 ➔ 成功吐鈔。
 * 3. 例外流 1 (Exception Path / 流 3)：
 *    帳戶可用餘額不足 ➔ 拒絕交易並退卡。
 * 4. 例外流 2 (Exception Path / 流 4)：
 *    密碼連續輸入錯誤達 3 次 ➔ 立即吞卡 (鎖卡) 並終止交易。
 */
public class AtmWithdrawService {

    public static class Account {
        public final String cardNumber;
        private final String pin;
        private int balance;
        private int failedAttempts = 0;
        private boolean isLocked = false;

        public Account(String cardNumber, String pin, int balance) {
            this.cardNumber = cardNumber;
            this.pin = pin;
            this.balance = balance;
        }

        public int getBalance() {
            return balance;
        }

        public boolean isLocked() {
            return isLocked;
        }
    }

    public enum TransactionStatus {
        SUCCESS,
        INSUFFICIENT_BALANCE,
        CARD_LOCKED,
        EXCEEDS_LIMIT,
        INVALID_PIN
    }

    public static class WithdrawResult {
        public final TransactionStatus status;
        public final int dispensedAmount;
        public final int remainingBalance;
        public final String message;

        public WithdrawResult(TransactionStatus status, int dispensedAmount, int remainingBalance, String message) {
            this.status = status;
            this.dispensedAmount = dispensedAmount;
            this.remainingBalance = remainingBalance;
            this.message = message;
        }
    }

    private static final int SINGLE_TRANSACTION_LIMIT = 20000;
    private int atmCashStock = 100000; // 機台庫存現金

    /**
     * 執行 ATM 提款交易流程
     */
    public WithdrawResult withdraw(Account account, String inputPin, int amount) {
        // 1. 檢查帳戶是否已被鎖定
        if (account.isLocked) {
            return new WithdrawResult(TransactionStatus.CARD_LOCKED, 0, account.balance, "卡片已鎖定，請洽分行櫃檯");
        }

        // 2. 密碼驗證
        if (!account.pin.equals(inputPin)) {
            account.failedAttempts++;
            if (account.failedAttempts >= 3) {
                account.isLocked = true;
                return new WithdrawResult(TransactionStatus.CARD_LOCKED, 0, account.balance, "密碼連續錯誤3次，卡片已鎖定");
            }
            return new WithdrawResult(TransactionStatus.INVALID_PIN, 0, account.balance,
                    "密碼錯誤，已累計 " + account.failedAttempts + " 次");
        }

        // 密碼正確，重置失敗次數
        account.failedAttempts = 0;

        // 3. 單筆上限檢驗 (替代流觸發點)
        if (amount > SINGLE_TRANSACTION_LIMIT) {
            return new WithdrawResult(TransactionStatus.EXCEEDS_LIMIT, 0, account.balance,
                    "單筆提款金額超過上限 " + SINGLE_TRANSACTION_LIMIT + " 元");
        }

        // 4. 餘額檢驗 (例外流觸發點)
        if (amount > account.balance) {
            return new WithdrawResult(TransactionStatus.INSUFFICIENT_BALANCE, 0, account.balance, "帳戶餘額不足");
        }

        // 5. 機台鈔票庫存檢驗
        if (amount > atmCashStock) {
            return new WithdrawResult(TransactionStatus.INSUFFICIENT_BALANCE, 0, account.balance, "機台現鈔不足");
        }

        // 6. 成功出鈔與扣款 (基本流)
        account.balance -= amount;
        atmCashStock -= amount;

        return new WithdrawResult(TransactionStatus.SUCCESS, amount, account.balance, "提款成功，請取出現鈔與卡片");
    }
}
