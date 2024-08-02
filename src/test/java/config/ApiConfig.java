package config;
import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties"
})

public interface ApiConfig extends Config {
    @Key("baseUri")
    @DefaultValue("https://habitica.com")
    String baseURI();

    @Key("basePath")
    @DefaultValue("/api")
    String basePath();
}
