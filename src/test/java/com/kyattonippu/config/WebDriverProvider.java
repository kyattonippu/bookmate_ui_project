package com.kyattonippu.config;

import com.kyattonippu.config.web.WebConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Objects;
import java.util.function.Supplier;

public class WebDriverProvider implements Supplier<WebDriver> {

    private final WebConfig webConfig = ConfigReader.Instance.read();

    @Override
    public WebDriver get() {
        WebDriver driver = createWebDriver();
        driver.get(webConfig.getBaseUrl());
        return driver;
    }

    private WebDriver createWebDriver() {
        if (Objects.isNull(webConfig.getRemoteUrl())) {
            if (webConfig.getBrowser().equals(Browser.CHROME.toString())) {
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            } else if (webConfig.getBrowser().equals(Browser.FIREFOX.toString())) {
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            }
        } else {
            if (webConfig.getBrowser().equals(Browser.CHROME.toString())) {
                return new RemoteWebDriver(webConfig.getRemoteUrl(), new ChromeOptions());
            } else if (webConfig.getBrowser().equals(Browser.FIREFOX.toString())) {
                return new RemoteWebDriver(webConfig.getRemoteUrl(), new FirefoxOptions());
            }
        }
        throw new RuntimeException("No such browser");
    }
}
