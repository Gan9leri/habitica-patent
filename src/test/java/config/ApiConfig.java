package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${envApi}.properties"
})

public interface ApiConfig extends Config {

    @DefaultValue("https://habitica.com")
    String baseUrl();

    @DefaultValue("chrome")
    String browser();

    @DefaultValue("1920x1080")
    String browserSize();

    @DefaultValue("126")
    String browserVersion();

    @DefaultValue("https://habitica.com")
    String baseURI();

    @DefaultValue("/api")
    String basePath();

    @DefaultValue("false")
    boolean isRemote();

    @DefaultValue("https://habitica.com")
    String remoteUrl();

}
