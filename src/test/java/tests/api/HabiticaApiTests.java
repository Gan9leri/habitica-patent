package tests.api;

import authorization.Authorization;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

@Tag("api")
public class HabiticaApiTests extends TestBase{

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
