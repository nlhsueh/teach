# 實習 10：Testcontainers 純 Java 容器化資料庫整合測試

> 🎯 **實習目標**：
> 1. 理解 H2 記憶體資料庫的「假綠燈幻覺」（SQL 方言、JSONB、Upsert 與約束行為與生產環境不一致）。
> 2. 在純 **Java 21 + JUnit 5 + JDBC** 環境中，透過 **Testcontainers** 自動啟動真實的 **Docker PostgreSQL 16 容器**。
> 3. 驗證 PostgreSQL 原生 `JSONB`、`UNIQUE` 約束錯誤碼 (`23505`)、`ON CONFLICT DO UPDATE` 與交易回滾 (`Rollback`)。
> 4. 📖 **專案對應源碼**：
>    - 待測程式：[`UserRepository.java`](../../src/main/java/u07_testcontainers/UserRepository.java)
>    - 示範測試：[`UserRepositoryTestcontainersTest.java`](../../src/test/java/u07_testcontainers/UserRepositoryTestcontainersTest.java)
>    - 動手練習：[`UserRepositoryExerciseTest.java`](../../src/test/java/u07_testcontainers/UserRepositoryExerciseTest.java)

---

## 1. 為什麼要淘汰 H2 記憶體資料庫？

| 傳統 H2 記憶體測試 (舊做法) | 現代 Testcontainers 容器化測試 (SQA 2.0) |
| :--- | :--- |
| SQL 方言與真實 PostgreSQL/MySQL 不相容（如 `JSONB`、`RETURNING id`、`ON CONFLICT`） | **使用 100% 與生產環境相同的 Docker 映像檔**（`postgres:16-alpine`） |
| 無法重現真實資料庫的鎖定、死結 (Deadlock) 與標準錯誤碼 (`SQLState 23505`) | 真實重現交易隔離等級、鎖定與唯一鍵衝突 |
| 容易發生「本機測試全綠、上線卻因 SQL 語法錯誤崩潰」 | **本機測試通過即確保資料庫層與生產環境行為一致** |

---

## 2. Maven 依賴設定 (`LabDemo/pom.xml` 已預先配置)

無須引入任何 Spring Boot 框架，只要純 Java JDBC 驅動加上 Testcontainers 模組即可：

```xml
<!-- PostgreSQL JDBC Driver -->
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.7.4</version>
</dependency>

<!-- Testcontainers JUnit 5 與 PostgreSQL 模組 -->
<dependency>
    <groupId>org.testcontainers</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>1.20.4</version>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>org.testcontainers</groupId>
    <artifactId>postgresql</artifactId>
    <version>1.20.4</version>
    <scope>test</scope>
</dependency>
```

---

## 3. 實戰演練：純 Java JDBC + `@Testcontainers` 整合測試

透過建構子依賴注入 (Constructor DI)，直接把 Testcontainers 容器動態分配的 `jdbcUrl`、`username`、`password` 傳給 `UserRepository`：

```java
@Testcontainers(disabledWithoutDocker = true)
public class UserRepositoryTestcontainersTest {

    @Container
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16-alpine")
            .withDatabaseName("sqa_test_db")
            .withUsername("test_user")
            .withPassword("test_pass");

    private static UserRepository userRepository;

    @BeforeAll
    static void setUpDatabase() throws SQLException {
        userRepository = new UserRepository(
                postgres.getJdbcUrl(),
                postgres.getUsername(),
                postgres.getPassword()
        );
        userRepository.initSchema();
    }

    @Test
    void testUniqueEmailConstraintViolation() throws SQLException {
        userRepository.save("Bob", "bob@fcu.edu.tw", "{}");
        SQLException ex = assertThrows(SQLException.class, () ->
                userRepository.save("Bob Duplicate", "bob@fcu.edu.tw", "{}")
        );
        assertEquals("23505", ex.getSQLState()); // PostgreSQL UNIQUE 衝突標準碼
    }
}
```

---

## 4. 執行步驟與實習任務

1. **啟動 Docker**：確認本機已開啟 Docker Desktop 或 OrbStack。
2. **執行示範測試**（於 `LabDemo/` 目錄下）：
   ```bash
   mvn test -Dtest=UserRepositoryTestcontainersTest
   ```
   * 觀察終端機輸出：Testcontainers 會自動拉取 `postgres:16-alpine`、隨機綁定本機 Port、執行 3 個測試案例，並在結束後由 **Ryuk 守護容器**自動清理銷毀！
3. **完成動手練習**：
   * 開啟 [`UserRepositoryExerciseTest.java`](../../src/test/java/u07_testcontainers/UserRepositoryExerciseTest.java)，移除 `@Disabled` 並執行 `mvn test -Dtest=UserRepositoryExerciseTest`，驗證交易回滾 (`conn.rollback()`) 後資料庫不殘留髒資料。
   * **進階挑戰**：在 `UserRepository` 新增 `findAdmins()` 方法，使用 PostgreSQL 原生語法 `WHERE metadata->>'role' = 'ADMIN'` 查詢管理員，並撰寫 Testcontainers 整合測試驗證！

---

## 📋 實習成果驗收標準
1. [ ] 成功執行 `UserRepositoryTestcontainersTest` 並通過 3 項真實 PostgreSQL 測試。
2. [ ] 完成 `UserRepositoryExerciseTest` 之交易回滾與 JSONB 條件查詢驗證。
3. [ ] 截圖包含 Testcontainers 啟動 Docker 容器的 Console 日誌與 JUnit 5 綠燈報告。
