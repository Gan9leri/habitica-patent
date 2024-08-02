package config;
import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties"
})

public interface ApiConfig extends Config {
    @DefaultValue("https://habitica.com")
    String baseURI();

    @DefaultValue("/api")
    String basePath();
}
