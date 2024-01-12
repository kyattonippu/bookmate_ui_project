package com.kyattonippu.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.kyattonippu.config.AuthConfig;
import com.kyattonippu.config.WebDriverConfig;
import com.kyattonippu.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Selenide.*;

public class TestBase {

    static WebDriverConfig webDriverConfig = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
    static AuthConfig authConfig = ConfigFactory.create(AuthConfig.class, System.getProperties());

    @BeforeAll
    static void configuration() {
        Configuration.browser = webDriverConfig.browser();
        Configuration.browserVersion = webDriverConfig.browserVersion();
        Configuration.browserSize = webDriverConfig.browserSize();
        Configuration.baseUrl = webDriverConfig.baseUrl();
        String remoteUrl = "https://" + authConfig.remote_username() + ":" + authConfig.remote_password()
                + "@" + webDriverConfig.remoteUrl() + "/wd/hub";
        System.out.println(remoteUrl);
        if (webDriverConfig.isRemote()) {
            Configuration.remote = remoteUrl;

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));

            Configuration.browserCapabilities = capabilities;
        }
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

    @AfterAll
    static void afterAll() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
        closeWebDriver();
    }
}

