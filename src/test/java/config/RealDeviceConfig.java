package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${platform}.properties"
})

public interface RealDeviceConfig extends Config {
    @Config.DefaultValue("http://localhost:4723/wd/hub")
    String mobileUrl();

    @Config.DefaultValue("7cfb82f6")
    String deviceName();
}
