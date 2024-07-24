package tests.web;

import com.codeborne.selenide.Configuration;
import config.WebConfig;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    public static void beforeAll(){

        WebConfig webConfig = ConfigFactory.create(WebConfig.class, System.getProperties());

        Configuration.baseUrl = webConfig.baseUrl();
        Configuration.browser = webConfig.browser();
        Configuration.browserSize = webConfig.browserSize();
        Configuration.browserVersion = webConfig.browserVersion();
        RestAssured.baseURI = webConfig.baseURI();
        RestAssured.basePath = webConfig.basePath();

        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }
}
