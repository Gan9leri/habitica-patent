package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${platform}.properties"
})

public interface EmulationConfig extends Config {

    @DefaultValue("15")
    String mobilePlatform();

    @DefaultValue("sdk_gphone64_x86_64")
    String deviceName();

    @DefaultValue("http://localhost:4723/wd/hub")
    String mobileUrl();

}
