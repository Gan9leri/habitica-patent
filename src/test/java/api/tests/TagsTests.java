package api.tests;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import api.models.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static extensions.authorization.Authorization.getAuthResponse;
import static io.restassured.RestAssured.given;
import static api.specs.Specs.*;

@Tag("api")
@Owner("Овсянников Александр")
@Feature("Tags")
@DisplayName("API: Тесты на список тэгов")
public class TagsTests extends TestBaseApi {

    @Test
    @DisplayName("API: Тест на получение списка тэгов")
    void getTagsTest() {
        String xApiUser = getAuthResponse().getData().getId();
        String xApiKey = getAuthResponse().getData().getApiToken();
        TagResponseBodyModel response =
                step("Отправка GET запроса на получение тэгов", () ->
                        given(requestSpec)
                                .when()
                                .header("X-Api-User", xApiUser)
                                .header("X-Api-Key", xApiKey)
                                .get("/v3/tags")
                                .then()
                                .spec(responseSpec200)
                                .extract().as(TagResponseBodyModel.class)
                );
        int size = response.getData().size();
        step("Проверка успешности получения списка тэгов", () ->
                assertThat(response.getSuccess()).isEqualTo(true)
        );
        step("Проверка тэга", () ->
                assertThat(response.getData().get(size - 1).getName()).isEqualTo("QA.GURU")
        );
    }
}
