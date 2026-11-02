package tests;

import com.codeborne.selenide.Configuration;
import config.TestConfig;
import org.junit.jupiter.api.BeforeAll;

public abstract class BaseTest {

    @BeforeAll
    public static void setUpConfig() {
        Configuration.baseUrl = TestConfig.getBaseUrl();
    }
}
