package tests.web;

import com.codeborne.selenide.Configuration;
import config.WebConfig;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;

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
        if(webConfig.isRemote()){
            Configuration.remote = webConfig.remoteUrl();
        }
        Configuration.pageLoadStrategy = "eager";
        //Configuration.holdBrowserOpen = true;

    }

    @AfterEach
    void afterEach() {
        closeWebDriver();
    }
}
