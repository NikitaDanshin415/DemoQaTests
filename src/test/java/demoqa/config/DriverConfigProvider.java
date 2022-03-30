package demoqa.config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Класс для настройки конфигурации тестов.
 */
public class DriverConfigProvider {
    WebDriverConfig webDriverConfig;
    AuthConfig authConfig;

    public void init() {
        webDriverConfig = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
        configureBrowser();

        if (webDriverConfig.isRemote()) {
            authConfig = ConfigFactory.create(AuthConfig.class);
            configureSelenoid();
        }
    }

    /**
     * Конфигурации для браузера.
     */
    private void configureBrowser() {
        Configuration.browser = webDriverConfig.getBrowser();
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    /**
     * Конфигурации для удаленного драйвера.
     */
    private void configureSelenoid() {
        //selenoid.autotests.cloud

        Configuration.remote = "https://" + authConfig.getLogin() + ":" + authConfig.getPassword() + "@" + webDriverConfig.getRemoteUrl() + "/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }
}
