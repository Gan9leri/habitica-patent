package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:host/${deviceHost}.properties"
})

public interface BrowserstackConfig extends Config {

    @DefaultValue("http://hub.browserstack.com/wd/hub")
    String remoteUrl();

    @DefaultValue("Google Pixel 6")
    String deviceName();

    @DefaultValue("12.0")
    String mobilePlatform();

    @DefaultValue("bs://01d2eccefae833ceea2a51d3d729a3ac71f23c1d")
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
