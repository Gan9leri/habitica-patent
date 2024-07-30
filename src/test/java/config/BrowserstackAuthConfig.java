package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:browserstackAuthConfig.properties"
})

public interface BrowserstackAuthConfig extends Config{

    @DefaultValue("bsuser_akIolY")
    String mobileUser();

    @DefaultValue("v4PBoq5d5rxdcyRSVYet")
    String mobilePass();

}
