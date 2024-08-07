package api.tests;

import common.config.AuthConfig;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import api.models.AuthRequestBodyModel;
import api.models.AuthResponseBodyModel;
import api.models.NotAuthRequestBodyModel;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static api.specs.Specs.*;


@Tag("api")
@Owner("Овсянников Александр")
@Feature("LoginApi")
@DisplayName("Тесты на авторизацию через Api")
public class LoginTests extends TestBase {

    @Test
    @DisplayName("Позитивный тест на авторизацию")
    void loginTest() {
        AuthConfig authConfig = ConfigFactory.create(AuthConfig.class, System.getProperties());
        AuthRequestBodyModel request = new AuthRequestBodyModel();
        request.setUsername(authConfig.login());
        request.setPassword(authConfig.password());
        AuthResponseBodyModel response =
                step("Отправка POST запроса на авторизацию ", () ->
                        given(requestSpec)
                                .body(request)
                                .when()
                                .post("/v4/user/auth/local/login")
                                .then()
                                .spec(responseSpec200)
                                .extract().as(AuthResponseBodyModel.class)
                );
        step("Проверка успешности авторизации", () ->
                assertThat(response.getSuccess()).isEqualTo(true)
        );
    }

    @Test
    @DisplayName("Негативный тест на авторизацию")
    void negativeLoginTest() {
        AuthRequestBodyModel request = new AuthRequestBodyModel();
        request.setUsername("error");
        request.setPassword("error");
        NotAuthRequestBodyModel response =
                step("Отправка POST запроса на авторизацию ", () ->
                        given(requestSpec)
                                .body(request)
                                .when()
                                .post("/v4/user/auth/local/login")
                                .then()
                                .spec(responseSpec401)
                                .extract().as(NotAuthRequestBodyModel.class)
                );
        step("Проверка неуспешности авторизации", () ->
                assertThat(response.getSuccess()).isEqualTo(false)
        );
    }
}
