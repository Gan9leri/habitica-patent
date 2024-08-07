package common.config;

import org.aeonbits.owner.Config;

public interface ApiConfig extends Config {
    @Key("baseURI")
    @DefaultValue("https://habitica.com")
    String baseURI();

    @Key("/api")
    @DefaultValue("/api")
    String basePath();
}
