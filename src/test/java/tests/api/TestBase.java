package tests.api;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.ApiConfig;
import config.WebConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    @BeforeAll
    public static void beforeAll(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        ApiConfig apiConfig = ConfigFactory.create(ApiConfig.class, System.getProperties());
        RestAssured.baseURI = apiConfig.baseURI();
        RestAssured.basePath = apiConfig.basePath();
    }

    @AfterEach
    void addAttachments() {
        closeWebDriver();
    }
}
