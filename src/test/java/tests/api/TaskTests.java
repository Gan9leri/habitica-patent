package tests.api;

import extensions.WithLogin;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import models.DeleteTaskResponseBodyModel;
import models.UserResponseBodyModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static authorization.Authorization.getAuthResponse;
import static com.codeborne.selenide.logevents.SelenideLogger.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static specs.Specs.RequestSpec;
import static specs.Specs.ResponseSpec200;
import static extensions.TaskExtension.addTask;
import static extensions.TaskExtension.getTaskId;

@DisplayName("Тесты на работу с задачами")
@Tag("api")
@Owner("Овсянников Александр")
@Feature("LoginApi")
public class TaskTests extends TestBase{

    @DisplayName("Тест на получение информации по задаче")
    @Test
    @WithLogin
    void getTaskTest(){

        String task = addTask();
        String xApiUser = getAuthResponse().getData().getId();
        String xApiKey = getAuthResponse().getData().getApiToken();
        UserResponseBodyModel response =
                step("Отправка GET запроса на получение информации по задачам", () ->
                    given(RequestSpec)
                        .header("X-Api-User", xApiUser)
                        .header("X-Api-Key", xApiKey)
                        .when()
                        .get("v4/tasks/user")
                        .then()
                        .spec(ResponseSpec200)
                        .extract().as(UserResponseBodyModel.class)
                );
        step("Проверка названия задачи", () ->
            assertThat(response.getData().get(0).getText()).isEqualTo(task)
        );
    }

    @DisplayName("Тест на удаление задачи")
    @Test
    @WithLogin
    void deleteTest(){

        String taskId = getTaskId();
        String xApiUser = getAuthResponse().getData().getId();
        String xApiKey = getAuthResponse().getData().getApiToken();
        DeleteTaskResponseBodyModel response =
                step("Отправка DELETE запроса на удаление задачи", () ->
                    given(RequestSpec)
                        .header("X-Api-User", xApiUser)
                        .header("X-Api-Key", xApiKey)
                        .when()
                        .delete("v4/tasks/" + taskId)
                        .then()
                        .spec(ResponseSpec200)
                        .extract().as(DeleteTaskResponseBodyModel.class)
                );
        step("Проверка успешности удаления задачи", () ->
            assertThat(response.getSuccess()).isEqualTo(true)
        );
    }
}
