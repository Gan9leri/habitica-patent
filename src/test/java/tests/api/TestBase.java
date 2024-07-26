package tests.api;

import com.codeborne.selenide.Configuration;
import config.ApiConfig;
import config.WebConfig;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    public static void beforeAll(){

        ApiConfig apiConfig = ConfigFactory.create(ApiConfig.class, System.getProperties());
        Configuration.baseUrl = apiConfig.baseUrl();
        Configuration.browser = apiConfig.browser();
        Configuration.browserSize = apiConfig.browserSize();
        Configuration.browserVersion = apiConfig.browserVersion();
        RestAssured.baseURI = apiConfig.baseURI();
        RestAssured.basePath = apiConfig.basePath();
        if(apiConfig.isRemote()){
            Configuration.remote = apiConfig.remoteUrl();
        }
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;

    }
}
