package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.TestConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

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

    @BeforeEach
    public void setUpListener() {
        SelenideLogger.addListener(
                "AllureSelenide",
                new AllureSelenide()
        );
    }

    @AfterEach
    public void tearDownListener() {
        SelenideLogger.removeListener("AllureSelenide");
    }
}