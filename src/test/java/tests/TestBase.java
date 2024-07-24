package tests;

import com.codeborne.selenide.Configuration;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    public static void beforeAll(){
        RestAssured.baseURI = "https://habitica.com";
        RestAssured.basePath = "/api";
        Configuration.baseUrl = "https://habitica.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;

    }
}
