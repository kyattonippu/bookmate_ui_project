package com.kyattonippu.config;

import com.codeborne.selenide.Configuration;
import com.kyattonippu.config.web.WebConfig;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Arrays;
import java.util.Map;

public class ProjectConfiguration {

    private final WebConfig webConfig;

    public ProjectConfiguration(WebConfig webConfig) {
        this.webConfig = webConfig;
    }

    public void webConfig() {
        Configuration.baseUrl = webConfig.getBaseUrl();
        Configuration.browser = webConfig.getBrowser().toString();
        Configuration.browserVersion = webConfig.getBrowserVersion();
        Configuration.browserSize = webConfig.getBrowserSize();
        Configuration.pageLoadStrategy ="eager";
        if (webConfig.isRemote()) {
            Configuration.remote = String.valueOf(webConfig.getRemoteUrl());
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true,
                    "env", Arrays.asList("LANG=ru_RU.UTF-8", "LANGUAGE=ru:ru", "LC_ALL=ru_RU.UTF=8")
            ));
            Configuration.browserCapabilities = capabilities;
        }
    }
}
