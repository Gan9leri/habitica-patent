package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${envApi}.properties"
})

public interface ApiConfig extends Config {

    @DefaultValue("https://habitica.com")
    String baseURI();

    @DefaultValue("/api")
    String basePath();

}
