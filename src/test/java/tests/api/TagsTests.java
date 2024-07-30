package tests.api;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import models.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static authorization.Authorization.getAuthResponse;
import static io.restassured.RestAssured.given;
import static specs.Specs.*;


@DisplayName("Тесты на список тэгов")
@Tag("api")
@Owner("Овсянников Александр")
@Feature("Tags")
public class TagsTests extends TestBase{

    @DisplayName("Тест на получение списка тэгов")
    @Test
    void getTagsTest(){

        String xApiUser = getAuthResponse().getData().getId();
        String xApiKey = getAuthResponse().getData().getApiToken();
        TagResponseBodyModel response =
                step("Отправка GET запроса на получение тэгов", () ->
                    given(RequestSpec)
                        .when()
                        .header("X-Api-User", xApiUser)
                        .header("X-Api-Key", xApiKey)
                        .get("/v3/tags")
                        .then()
                        .spec(ResponseSpec200)
                        .extract().as(TagResponseBodyModel.class)
                );
        int size = response.getData().size();
        step("Проверка успешности получения списка тэгов", () ->
            assertThat(response.getSuccess()).isEqualTo(true)
        );
        step("Проверка тэга", () ->
            assertThat(response.getData().get(size-1).getName()).isEqualTo("QA.GURU")
        );
    }
}
