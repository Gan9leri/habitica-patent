package config;
import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties",
})

public interface WebConfig extends Config {
    @DefaultValue("https://habitica.com")
    String baseUrl();

    @DefaultValue("chrome")
    String browser();

    @DefaultValue("1920x1080")
    String browserSize();

    @DefaultValue("127")
    String browserVersion();

    @DefaultValue("https://habitica.com")
    String baseURI();

    @DefaultValue("/api")
    String basePath();

    @DefaultValue("false")
    boolean isRemote();

    @DefaultValue("https://habitica.com")
    String remoteUrl();
}
