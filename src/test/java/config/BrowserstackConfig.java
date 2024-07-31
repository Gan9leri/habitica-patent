package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${platform}.properties",
})

public interface BrowserstackConfig extends Config {

    @DefaultValue("bsuser_akIolY")
    String browserstackUser();

    @DefaultValue("v4PBoq5d5rxdcyRSVYet")
    String browserstackKey();

    @DefaultValue("bs://f09b3495887f76cc04547455c2c0683773bac402")
    String app();

    @DefaultValue("Samsung Galaxy S23 Ultra")
    String deviceName();

    @DefaultValue("13.0")
    String platformVersion();

    @DefaultValue("First Java Project")
    String projectName();

    @DefaultValue("browserstack-build-1")
    String buildName();

    @DefaultValue("first_test")
    String name();

    @DefaultValue("https://hub.browserstack.com/wd/hub")
    String browserstackUrl();

}
