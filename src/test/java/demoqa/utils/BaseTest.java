package demoqa.utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import demoqa.config.AuthConfig;
import demoqa.config.WebDriverConfig;
import demoqa.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {
    static WebDriverConfig config;
    static AuthConfig authConfig;

    @BeforeAll
    static void beforeAll() {
        config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

        configureBrowser();
        if (config.isRemote()) {
            authConfig = ConfigFactory.create(AuthConfig.class);
            configureSelenoid();
        }

        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    static synchronized void configureBrowser() {
        Configuration.browser = config.getBrowser();
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    static synchronized void configureSelenoid() {
        //selenoid.autotests.cloud

        Configuration.remote = "https://" + authConfig.getLogin() + ":" + authConfig.getPassword() + "@" + config.getRemoteUrl() + "/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
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
