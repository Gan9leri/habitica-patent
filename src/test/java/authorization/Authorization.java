package authorization;


import com.codeborne.selenide.Selenide;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import data.AuthTestData;
import io.restassured.http.ContentType;
import models.AuthRequestBodyModel;
import models.AuthResponseBodyModel;
import models.HabitMobileSettings;

import static com.codeborne.selenide.Selenide.open;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class Authorization {

    public static AuthResponseBodyModel getAuthResponse() {

        AuthTestData logoPass = new AuthTestData();
        AuthRequestBodyModel request = new AuthRequestBodyModel();
        request.setUsername(logoPass.getLogin());
        request.setPassword(logoPass.getPassword());
        return given().log().all()
                .contentType(ContentType.JSON)
                .body(request)
                .when()
                .post("/v4/user/auth/local/login")
                .then().log().all()
                .statusCode(200)
                .extract().as(AuthResponseBodyModel.class);

    }

    public static void setAuthDataInLocalStorage(AuthResponseBodyModel authResponse) throws JsonProcessingException {

        HabitMobileSettings habitMobileSettings =
                new HabitMobileSettings(authResponse.getData().getId(), authResponse.getData().getApiToken());
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        String authData = mapper.writeValueAsString(habitMobileSettings);
        open("/static/img/bits.d0926ee2.svg");
        Selenide.localStorage().setItem("habit-mobile-settings", authData);

    }
}
