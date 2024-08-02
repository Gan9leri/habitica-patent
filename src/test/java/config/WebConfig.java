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

    @DefaultValue("https://habitica.com")
    String baseUrl();

    @DefaultValue("https://habitica.com")
    String baseURI();

    @DefaultValue("/api")
    String basePath();

    @DefaultValue("https://habitica.com")
    String remoteUrl();

    @DefaultValue("false")
    boolean isRemote();
}
