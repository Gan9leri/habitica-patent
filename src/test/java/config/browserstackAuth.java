package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:browserstackAuth.properties"
})

public interface browserstackAuth extends Config{

    @Key("mobileUser")
    @DefaultValue("bsuser_akIolY")
    String mobileUser();

    @Key("mobilePass")
    @DefaultValue("v4PBoq5d5rxdcyRSVYet")
    String mobilePass();

}
