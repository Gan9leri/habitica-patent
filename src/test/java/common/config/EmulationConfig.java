package common.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:emulation.properties"
})

public interface EmulationConfig extends Config {
    String mobilePlatform();

    String deviceName();

    String mobileUrl();
}
