package common.config;

import org.aeonbits.owner.Config;


public interface WebConfig extends Config {
    @Key("baseUrl")
    @DefaultValue("https://habitica.com")
    String baseUrl();

    @Key("browser")
    @DefaultValue("chrome")
    String browser();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String browserSize();

    @Key("browserVersion")
    @DefaultValue("100")
    String browserVersion();

    @Key("host")
    @DefaultValue("https://user1:1234@selenoid.autotests.cloud/wd/hub")
    String remoteUrl();
}
