package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:host/${deviceHost}.properties"
})

public interface BrowserstackConfig extends Config {

    @Key("remoteUrl")
    @DefaultValue("https://hub.browserstack.com/wd/hub")
    String remoteUrl();

    @Key("deviceName")
    @DefaultValue("Google Pixel 6")
    String deviceName();

    @Key("mobilePlatform")
    @DefaultValue("12.0")
    String mobilePlatform();

    @Key("mobileApp")
    @DefaultValue("bs://f09b3495887f76cc04547455c2c0683773bac402")
    String mobileApp();

    @Key("mobileProject")
    @DefaultValue("First Java Project")
    String mobileProject();

    @Key("mobileBuild")
    @DefaultValue("browserstack-build-1")
    String mobileBuild();

    @Key("mobileName")
    @DefaultValue("first_test")
    String mobileName();

    @Key("mobileLanguage")
    @DefaultValue("ru")
    String mobileLanguage();

    @Key("mobileLocale")
    @DefaultValue("RU")
    String mobileLocale();

}
