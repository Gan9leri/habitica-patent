package config;
import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties",
})

public interface WebConfig extends Config {
    @Key("browser")
    @DefaultValue("chrome")
    String browser();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String browserSize();

    @Key("browserVersion")
    @DefaultValue("128")
    String browserVersion();

    @Key("host")
    //@DefaultValue("https://habitica.com")
    String remoteUrl();

    //@Key("baseUrl")
    @DefaultValue("https://habitica.com")
    String baseUrl();

    //@Key("baseUri")
    @DefaultValue("https://habitica.com")
    String baseURI();

    //@Key("basePath")
    @DefaultValue("/api")
    String basePath();
}
