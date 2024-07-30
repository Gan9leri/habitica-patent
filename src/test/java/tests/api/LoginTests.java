package tests.api;

import config.AuthConfig;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import models.AuthRequestBodyModel;
import models.AuthResponseBodyModel;
import models.NotAuthRequestBodyModel;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static specs.Specs.*;

@DisplayName("Тесты на авторизацию через Api")
@Tag("api")
@Owner("Овсянников Александр")
@Feature("LoginApi")
public class LoginTests extends TestBase {

    @DisplayName("Позитивный тест на авторизацию")
    @Test
    void loginTest() {
        AuthConfig authConfig = ConfigFactory.create(AuthConfig.class, System.getProperties());
        AuthRequestBodyModel request = new AuthRequestBodyModel();
        request.setUsername(authConfig.login());
        request.setPassword(authConfig.password());
        AuthResponseBodyModel response =
                step("Отправка POST запроса на авторизацию ", () ->
                    given(RequestSpec)
                        .body(request)
                        .when()
                        .post("/v4/user/auth/local/login")
                        .then()
                        .spec(ResponseSpec200)
                        .extract().as(AuthResponseBodyModel.class)
                );
        step("Проверка успешности авторизации", () ->
                assertThat(response.getSuccess()).isEqualTo(true)
        );
    }

    @DisplayName("Негативный тест на авторизацию")
    @Test
    void negativeLoginTest(){
        AuthRequestBodyModel request = new AuthRequestBodyModel();
        request.setUsername("error");
        request.setPassword("error");
        NotAuthRequestBodyModel response =
                step("Отправка POST запроса на авторизацию ", () ->
                        given(RequestSpec)
                        .body(request)
                        .when()
                        .post("/v4/user/auth/local/login")
                        .then()
                        .spec(ResponseSpec401)
                        .extract().as(NotAuthRequestBodyModel.class)
                );
        step("Проверка неуспешности авторизации", () ->
            assertThat(response.getSuccess()).isEqualTo(false)
        );
    }
}
