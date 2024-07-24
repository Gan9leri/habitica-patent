package tests;

import authorization.Authorization;
import extensions.WithLogin;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static io.restassured.RestAssured.given;


public class HabiticaApiTests extends TestBase {

    @Test
    void userTest(){

        String xApiUser = Authorization.getAuthResponse().getData().getId();
        String xApiKey = Authorization.getAuthResponse().getData().getApiToken();

        given().log().all()
                .contentType(ContentType.JSON)
                .header("X-Api-User", xApiUser)
                .header("X-Api-Key", xApiKey)
                .when()
                .get("/v4/user")
                .then().log().all().
                statusCode(200);
    }

}
