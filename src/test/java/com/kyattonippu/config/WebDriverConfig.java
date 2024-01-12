package com.kyattonippu.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties"
})

public interface WebDriverConfig extends Config {

    @Key("browser")
    @DefaultValue("CHROME")
    String browser();

    @Key("browser_size")
    @DefaultValue("1440x900")
    String browserSize();

    @Key("browser_version")
    @DefaultValue("100.0")
    String browserVersion();

    @Key("baseUrl")
    @DefaultValue("https://bookmate.ru")
    String baseUrl();

    @Key("isRemote")
    @DefaultValue("false")
    Boolean isRemote();

    @Key("remoteUrl")
    @DefaultValue("http://localhost:4444")
    String remoteUrl();
}
