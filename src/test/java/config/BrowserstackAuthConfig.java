package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:browserstackAuthConfig.properties"
})

public interface BrowserstackAuthConfig extends Config{

    String mobileUser();
    String mobilePass();

}
