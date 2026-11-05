package tests;

import com.codeborne.selenide.Configuration;
import config.TestConfig;
import org.junit.jupiter.api.BeforeAll;

public abstract class BaseTest {

    @BeforeAll
    public static void setUpConfig() {
        Configuration.baseUrl = TestConfig.getBaseUrl();
        Configuration.browser = TestConfig.getBrowser();
        Configuration.headless = TestConfig.isHeadless();
        Configuration.timeout = TestConfig.getTimeout();
        Configuration.browserSize = TestConfig.getBrowserSize();
        Configuration.reportsFolder = TestConfig.getReportsFolder();
    }
}