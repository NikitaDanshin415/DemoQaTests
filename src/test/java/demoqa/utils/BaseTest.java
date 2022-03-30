package demoqa.utils;

import com.codeborne.selenide.logevents.SelenideLogger;
import demoqa.config.DriverConfigProvider;
import demoqa.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;

/**
 * Базовый класс задающий начальную конфигурацию для всех тестов.
 */
public class BaseTest {

    @BeforeAll
    static void beforeAll() {
        new DriverConfigProvider().init();
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Screen");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}
