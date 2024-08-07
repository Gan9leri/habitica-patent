package common.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:realDevice.properties"
})

public interface RealDeviceConfig extends Config {
    String mobileUrl();

    String deviceName();
}
