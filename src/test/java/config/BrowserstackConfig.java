package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:host/${deviceHost}.properties"
})

public interface BrowserstackConfig extends Config {

    @DefaultValue("https://hub.browserstack.com/wd/hub")
    String remoteUrl();

    @DefaultValue("Google Pixel 6")
    String deviceName();

    @DefaultValue("12.0")
    String mobilePlatform();

    @DefaultValue("bs://f09b3495887f76cc04547455c2c0683773bac402")
    String mobileApp();

    @DefaultValue("First Java Project")
    String mobileProject();

    @DefaultValue("browserstack-build-1")
    String mobileBuild();

    @DefaultValue("first_test")
    String mobileName();

    @DefaultValue("ru")
    String mobileLanguage();

    @DefaultValue("RU")
    String mobileLocale();

}
