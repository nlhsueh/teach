# 📚 Lab 05 練習題完整參考解答庫 (Exercise Solutions)

> 本文件收錄 Lab 05（5.2 ～ 5.11）所有課堂動手練習（Exercise）之**完整標準參考解答程式碼與設計解析**。  
> 供同學在完成自主推敲後對照思路、自我除錯或卡關時求助使用。  
> 💡 獨立的 Java 原始碼檔案亦完整存放於各章節子目錄中，可直接在 IDE 中執行驗收。

---

## 🗂️ 快速章節跳轉導覽

- [Unit 5.2：JUnit 5 基礎與 3A 原則解答](#unit-52-junit-5-基礎與-3a-原則)
- [Unit 5.3：邊界值分析 (BVA) 解答](#unit-53-邊界值分析-bva)
- [Unit 5.4：等價類分割 (EP) 解答](#unit-54-等價類分割-ep)
- [Unit 5.5：全成對組合測試 (Pairwise) 解答](#unit-55-全成對組合測試-pairwise)
- [Unit 5.6：分類樹方法 (CTM) 解答](#unit-56-分類樹方法-ctm)
- [Unit 5.7：因果圖與決策表測試解答](#unit-57-因果圖與決策表測試)
- [Unit 5.8：狀態轉換測試解答](#unit-58-狀態轉換測試)
- [Unit 5.9：使用案例測試 (Use Case) 解答](#unit-59-使用案例測試-use-case)
- [Unit 5.10：經驗基礎與錯誤推測解答](#unit-510-經驗基礎與錯誤推測)
- [Unit 5.11：屬性測試 (PBT) 與變質測試解答](#unit-511-屬性測試-pbt-與變質測試)

---

## Unit 5.2: JUnit 5 基礎與 3A 原則
📂 原始檔案：[`5.2_junit/CalculatorExerciseTest.java`](5.2_junit/CalculatorExerciseTest.java)

```java
package u05_junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Unit 5.2 練習：Calculator 計算機練習題解答")
public class CalculatorExerciseTest {

    // 練習 1：實作減法運算的 3A 測試
    @Test
    @DisplayName("練習 1：實作減法運算的 3A 測試")
    void exercise1_testSubtract() {
        // [Arrange] 準備計算機實體
        Calculator calculator = new Calculator();
        // [Act] 執行減法
        int actual = calculator.subtract(20, 7);
        // [Assert] 驗證結果
        assertEquals(13, actual, "20 - 7 應該等於 13");
    }

    // 練習 2：使用 assertAll 驗證負數與零的加法
    @Test
    @DisplayName("練習 2：使用 assertAll 驗證負數與零的加法")
    void exercise2_testNegativeAndZeroAdd() {
        Calculator calculator = new Calculator();
        assertAll("負數與零的邊界運算",
            () -> assertEquals(-13, calculator.add(-5, -8), "(-5) + (-8) 應等於 -13"),
            () -> assertEquals(100, calculator.add(100, 0), "100 + 0 應等於 100")
        );
    }

    // 練習 3：驗證物件內容值相等 vs. 記憶體同一性
    @Test
    @DisplayName("練習 3：驗證物件內容值相等 vs. 記憶體同一性")
    void exercise3_testObjectEqualityVsIdentity() {
        Person p1 = new Person("John", "Doe");
        Person p2 = new Person("John", "Doe");
        Person p3 = p1;

        assertAll("物件比對",
            () -> assertEquals(p1, p2, "姓名內容相同，equals 應為 true"),
            () -> assertNotSame(p1, p2, "不同 new 物件，記憶體位址應不同"),
            () -> assertSame(p1, p3, "指向同一指標，assertSame 應為 true")
        );
    }
}
```

---

## Unit 5.3: 邊界值分析 (BVA)
📂 原始檔案：
- [`5.3_bva/TriangleBvaExerciseTest.java`](5.3_bva/TriangleBvaExerciseTest.java)
- [`5.3_bva/PoolTicketBvaExerciseTest.java`](5.3_bva/PoolTicketBvaExerciseTest.java)

```java
// === 1. 三角形強固邊界測試 (TriangleBvaExerciseTest.java) ===
@ParameterizedTest(name = "強固越界測試 - 邊長 ({0}, {1}, {2}) ➔ {3}")
@CsvSource({
    "0,   100, 100, Not a valid triangle", // min- 越界值 (0 <= 0 邊長非法)
    "-1,  100, 100, Not a valid triangle", // 負數越界值
    "201, 100, 100, Not a valid triangle"  // max+ 越界值
})
void exercise1_testRobustBoundaryA(double a, double b, double c, String expected) {
    String actual = Triangle.getTriangleType(a, b, c);
    assertEquals(expected, actual, "越界值應該被防禦判定為 Not a valid triangle");
}

@Test
@DisplayName("On-Off-In 三點法臨界驗證")
void exercise2_testOnOffInPoints() {
    assertAll("On-Off-In 三點法臨界驗證",
        () -> assertEquals("Not a valid triangle", Triangle.getTriangleType(3, 4, 7), "On 點: 3+4=7 剛好退化"),
        () -> assertEquals("Not a valid triangle", Triangle.getTriangleType(3, 4, 8), "Off 點: 3+4 < 8 越界非法"),
        () -> assertEquals("Scalene", Triangle.getTriangleType(3, 4, 6), "In 點: 3+4 > 6 合法不等邊三角形")
    );
}

// === 2. 游泳池年齡階層票價測試 (PoolTicketBvaExerciseTest.java) ===
@ParameterizedTest(name = "年齡 {0} 歲 ➔ 預期票種: {1}, 票價: {2} 元")
@CsvSource({
    "0,  FREE,   0",
    "3,  FREE,   0",
    "4,  CHILD,  100",
    "12, CHILD,  100",
    "13, ADULT,  250",
    "64, ADULT,  250",
    "65, SENIOR, 120",
    "120, SENIOR, 120"
})
void exercise1_testAgeBoundaries(int age, TicketType expectedType, int expectedPrice) {
    TicketType actualType = PoolTicketCalculator.getTicketType(age);
    assertEquals(expectedType, actualType, "年齡 " + age + " 歲之票種判定不符");
    assertEquals(expectedPrice, actualType.getPrice(), "年齡 " + age + " 歲之票價不符");
}

@Test
@DisplayName("年齡越界防禦性例外拋出")
void exercise2_testInvalidAgeBoundaries() {
    assertAll("年齡越界防禦",
        () -> assertThrows(IllegalArgumentException.class, () -> PoolTicketCalculator.getTicketType(-1)),
        () -> assertThrows(IllegalArgumentException.class, () -> PoolTicketCalculator.getTicketType(121))
    );
}
```

---

## Unit 5.4: 等價類分割 (EP)
📂 原始檔案：[`5.4_ep/PasswordValidatorEpExerciseTest.java`](5.4_ep/PasswordValidatorEpExerciseTest.java)

```java
// 練習 1：有效等價類 (長度 8~20 且含英數字)
@ParameterizedTest
@ValueSource(strings = {"abcde123", "P@ssw0rd2026", "A1b2C3d4E5f6G7h8I9j0"})
void exercise1_testValidPasswords(String password) {
    assertTrue(PasswordValidator.isValid(password), "合規密碼應通過驗證");
}

// 練習 2：無效等價類長度過短/過長 (assertThrows)
@Test
void exercise2_testInvalidLengthThrows() {
    assertAll("長度異常防禦",
        () -> assertThrows(IllegalArgumentException.class, () -> PasswordValidator.isValid("short1")),
        () -> assertThrows(IllegalArgumentException.class, () -> PasswordValidator.isValid("a1".repeat(11)))
    );
}

// 練習 3：弱密碼等價類 (純字母或純數字)
@ParameterizedTest
@ValueSource(strings = {"abcdefghij", "1234567890"})
void exercise3_testWeakPasswordCombinations(String weakPassword) {
    assertFalse(PasswordValidator.isValid(weakPassword), "缺少英數混合應判定為無效弱密碼");
}
```

---

## Unit 5.5: 全成對組合測試 (Pairwise)
📂 原始檔案：[`5.5_pairwise/LoanCalculatorPairwiseExerciseTest.java`](5.5_pairwise/LoanCalculatorPairwiseExerciseTest.java)

```java
// 練習 1：極限優惠組合驗證利率精準觸發保底下限 2.0%
@Test
void exercise1_testExtremeDiscountRate() {
    double rate = LoanCalculator.calculateInterestRate(30, 10000000, true, true);
    assertEquals(2.0, rate, "利率不可低於保底下限 2.0%");
}

// 練習 2：自訂 3 因子成對生成矩陣並動態執行
@TestFactory
List<DynamicTest> exercise2_customPairwiseTests() {
    AllPairs allPairs = new AllPairs.AllPairsBuilder()
        .withFactor(new Factor("OS", Arrays.asList("Windows", "macOS", "Linux")))
        .withFactor(new Factor("Browser", Arrays.asList("Chrome", "Edge", "Firefox")))
        .withFactor(new Factor("Network", Arrays.asList("WiFi", "5G")))
        .build();

    return allPairs.stream().map(c ->
        DynamicTest.dynamicTest("配對: " + c, () -> assertNotNull(c))
    ).collect(Collectors.toList());
}
```

---

## Unit 5.6: 分類樹方法 (CTM)
📂 原始檔案：[`5.6_ctm/OrderDiscountCtmExerciseTest.java`](5.6_ctm/OrderDiscountCtmExerciseTest.java)

```java
@Nested
@DisplayName("VIP 會員折扣情境")
class VipMemberTests {
    @Test
    @DisplayName("TC_1: VIP 大額訂單 (>3K) 享 8 折再折 300 元")
    void testVipLargeOrder() {
        assertEquals(2900.0, OrderDiscount.calculate(4000.0, MemberLevel.VIP, Payment.LINE_PAY));
    }
}

@Nested
@DisplayName("一般會員與訪客折扣情境")
class RegularAndGuestTests {
    @Test
    @DisplayName("TC_2: 一般會員中額訂單 (1K~3K) 享 9 折再折 100 元")
    void testRegularMediumOrder() {
        assertEquals(1700.0, OrderDiscount.calculate(2000.0, MemberLevel.REGULAR, Payment.CREDIT_CARD));
    }

    @Test
    @DisplayName("TC_3: 訪客小額訂單 (<1K) 原價無折扣")
    void testGuestSmallOrder() {
        assertEquals(500.0, OrderDiscount.calculate(500.0, MemberLevel.GUEST, Payment.CASH));
    }
}
```

---

## Unit 5.7: 因果圖與決策表測試
📂 原始檔案：[`5.7_decision/PromotionDecisionExerciseTest.java`](5.7_decision/PromotionDecisionExerciseTest.java)

```java
// 練習 1：剛好滿 1000 元臨界值
@Test
void exercise1_boundaryExact1000() {
    double actual = PromotionCalculator.calculate(1000.0, true, false);
    assertEquals(800.0, actual, "剛好 1000 元應享 8 折優惠");
}

// 練習 2：999.9 元未滿額臨界值 (原價結帳)
@Test
void exercise2_boundaryBelow1000() {
    double actual = PromotionCalculator.calculate(999.9, true, true);
    assertEquals(999.9, actual, 0.001, "未滿千元無論身分與促銷碼一律原價");
}

// 練習 3：CAR 決策表全矩陣驗收 (@CsvSource)
@ParameterizedTest
@CsvSource({
    "1500.0, true,  false, 1200.0", // R1: 滿千+VIP -> 8折
    "1200.0, false, true,  1200.0", // R2: 滿千+促銷碼 -> 免運 (金額不變)
    "2000.0, true,  true,  1600.0", // R3: 滿千+VIP+促銷碼 -> 8折+免運
    "800.0,  true,  true,  800.0"   // R4: 未滿千 -> 原價結帳
})
void exercise3_fullDecisionTable(double amount, boolean isVip, boolean hasCoupon, double expected) {
    assertEquals(expected, PromotionCalculator.calculate(amount, isVip, hasCoupon));
}
```

---

## Unit 5.8: 狀態轉換測試
📂 原始檔案：[`5.8_state/StackStateExerciseTest.java`](5.8_state/StackStateExerciseTest.java)

```java
// 練習 1：1-Switch 閉環轉移序列 (Empty -> Non-Empty -> Empty)
@Test
void exercise1_emptyNonEmptyEmptySequence() {
    Stack stack = new Stack(5);
    assertTrue(stack.isEmpty(), "初始為空");

    stack.push(10);
    assertFalse(stack.isEmpty(), "轉移至 Non-Empty");

    int popped = stack.pop();
    assertAll("轉移回 Empty 狀態",
        () -> assertEquals(10, popped),
        () -> assertTrue(stack.isEmpty(), "閉環轉移回 Empty")
    );
}

// 練習 2：空狀態 peek() 例外與狀態不變量維護
@Test
void exercise2_peekOnEmptyStackMaintainsInvariant() {
    Stack stack = new Stack(3);
    assertThrows(EmptyStackException.class, () -> stack.peek());
    assertTrue(stack.isEmpty(), "非法 peek 操作後狀態不變量依然維持為空");
}
```

---

## Unit 5.9: 使用案例測試 (Use Case)
📂 原始檔案：[`5.9_usecase/AtmUseCaseExerciseTest.java`](5.9_usecase/AtmUseCaseExerciseTest.java)

```java
@Test
@DisplayName("防盜刷 PIN 碼連續錯誤 3 次鎖卡例外流 (UC-04)")
void exercise_pinRetryLimitAndLockCard() {
    AtmWithdrawService atm = new AtmWithdrawService("1234", 10000.0);

    // 第 1 次錯誤：提示剩餘 2 次
    AtmWithdrawService.WithdrawResult r1 = atm.withdraw("9999", 1000.0);
    assertEquals(AtmWithdrawService.Status.INVALID_PIN, r1.getStatus());
    assertEquals(2, r1.getRemainingAttempts());
    assertFalse(atm.isCardLocked());

    // 第 2 次錯誤：提示剩餘 1 次
    AtmWithdrawService.WithdrawResult r2 = atm.withdraw("8888", 1000.0);
    assertEquals(AtmWithdrawService.Status.INVALID_PIN, r2.getStatus());
    assertEquals(1, r2.getRemainingAttempts());
    assertFalse(atm.isCardLocked());

    // 第 3 次錯誤：精準觸發鎖卡
    AtmWithdrawService.WithdrawResult r3 = atm.withdraw("7777", 1000.0);
    assertEquals(AtmWithdrawService.Status.CARD_LOCKED, r3.getStatus());
    assertTrue(atm.isCardLocked(), "連續 3 次錯誤應鎖卡");

    // 鎖卡後即使輸入正確 PIN 依然拒絕服務
    AtmWithdrawService.WithdrawResult r4 = atm.withdraw("1234", 1000.0);
    assertEquals(AtmWithdrawService.Status.CARD_LOCKED, r4.getStatus());
}
```

---

## Unit 5.10: 經驗基礎與錯誤推測
📂 原始檔案：[`5.10_experience/ExploratoryExerciseTest.java`](5.10_experience/ExploratoryExerciseTest.java)

```java
// 練習 1：畸形 Email 格式直覺推測
@ParameterizedTest
@ValueSource(strings = {"invalid-email", "user@", "@domain.com", "user name@test.com"})
void exercise1_guessMalformedEmail(String malformedEmail) {
    assertThrows(IllegalArgumentException.class,
        () -> UserProfileService.register("ValidUser", malformedEmail, 25));
}

// 練習 2：Null 注入崩潰防護
@Test
void exercise2_nullPointerAttackDefense() {
    assertAll("Null 參數防禦",
        () -> assertThrows(IllegalArgumentException.class, () -> UserProfileService.register(null, "a@b.com", 20)),
        () -> assertThrows(IllegalArgumentException.class, () -> UserProfileService.register("User", null, 20))
    );
}
```

---

## Unit 5.11: 屬性測試 (PBT) 與變質測試
📂 原始檔案：
- [`5.11_pbtest/PropertyBasedExerciseTest.java`](5.11_pbtest/PropertyBasedExerciseTest.java)
- [`5.11_pbtest/MetamorphicExerciseTest.java`](5.11_pbtest/MetamorphicExerciseTest.java)

```java
// === 1. 屬性基礎測試 (PropertyBasedExerciseTest.java) ===
// 練習 1：乘法交換律不變量 (a * b == b * a)
@Property
void exercise1_multiplicationCommutative(@ForAll int a, @ForAll int b) {
    assertEquals(MathFunctions.multiply(a, b), MathFunctions.multiply(b, a));
}

// 練習 2：反轉後清單長度守恆不變量
@Property
void exercise2_reversePreservesLength(@ForAll List<String> list) {
    List<String> reversed = MathFunctions.reverseList(list);
    assertEquals(list.size(), reversed.size());
}

// === 2. 變質測試 (MetamorphicExerciseTest.java) ===
// 練習 3：關鍵字大小寫不敏感對稱性變質關係
@Test
void exercise_caseInsensitiveMetamorphicRelation() {
    MetamorphicSearch engine = new MetamorphicSearch();
    List<String> r1 = engine.search("software");
    List<String> r2 = engine.search("SOFTWARE");
    assertEquals(r1, r2, "大小寫變質轉換後搜尋結果應對稱相等");
}
```
