package tests.api;

import config.ApiConfig;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    @BeforeAll
    public static void beforeAll() {
        ApiConfig apiConfig = ConfigFactory.create(ApiConfig.class, System.getProperties());
        RestAssured.baseURI = apiConfig.baseURI();
        RestAssured.basePath = apiConfig.basePath();
    }

    @AfterEach
    void addAttachments() {
        closeWebDriver();
    }
}
