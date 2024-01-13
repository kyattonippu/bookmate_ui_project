package com.kyattonippu.config.web;

import org.aeonbits.owner.Config;

import java.net.URL;

@Config.Sources({
        "classpath:${env}.properties"
})

public interface WebConfig extends Config {

    @Key("browser")
    @DefaultValue("CHROME")
    String browser();

    @Key("browser_size")
    @DefaultValue("1920x1080")
    String browserSize();

    @Key("browser_version")
    @DefaultValue("100.0")
    String browserVersion();

    @Key("baseUrl")
    @DefaultValue("https://bookmate.ru/")
    String baseUrl();

    @Key("isRemote")
    @DefaultValue("false")
    Boolean isRemote();

    @Key("remoteUrl")
    @DefaultValue("https://user1:1234@selenoid.autotests.cloud/wd/hub")
    URL remoteUrl();
}
