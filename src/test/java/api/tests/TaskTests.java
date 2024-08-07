package api.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import common.data.DataGeneration;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import api.models.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static extensions.authorization.Authorization.getAuthResponse;
import static api.tests.TaskExtension.*;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static api.specs.Specs.*;

@Tag("api")
@Owner("Овсянников Александр")
@Feature("LoginApi")
@DisplayName("Тесты на работу с задачами")
public class TaskTests extends TestBase {

    @Test
    @DisplayName("Тест на удаление задачи")
    void deleteTaskTest() throws IOException {
        String taskId = createTask();
        DeleteTaskResponseBodyModel response =
                step("Отправка DELETE запроса на удаление задачи", () ->
                        given(requestSpec)
                                .header("X-Api-Key", getAuthResponse().getData().getApiToken())
                                .header("X-Api-User", getAuthResponse().getData().getId())
                                .when()
                                .delete("v4/tasks/" + taskId)
                                .then()
                                .spec(responseSpec200)
                                .extract().as(DeleteTaskResponseBodyModel.class)
                );
        step("Проверка успешности удаления задачи", () ->
                assertThat(response.getSuccess()).isEqualTo(true)
        );
    }

    @Test
    @DisplayName("Тест на добавление задачи через Api")
    void addTaskApiTest() throws IOException {
        DataGeneration data = new DataGeneration();
        ObjectMapper om = new ObjectMapper();
        PostCreateTaskUserRequestModel[] request = om.readValue(
                new File("src/test/resources/request/PostAddTask.json"),
                PostCreateTaskUserRequestModel[].class
        );
        request[0].setText(data.task);
        request[0].set_id(data.taskId);
        PostCreateTaskUserResponseModel response =
                step("Отправка POST запроса на добавление задачи", () ->
                        given(requestSpec)
                                .when()
                                .body(request)
                                .header("X-Api-Key", getAuthResponse().getData().getApiToken())
                                .header("X-Api-User", getAuthResponse().getData().getId())
                                .post("/v4/tasks/user")
                                .then()
                                .spec(responseSpec201)
                                .extract().as(PostCreateTaskUserResponseModel.class)
                );
        step("Проверка успешности добавления задачи", () ->
                assertThat(response.getSuccess()).isEqualTo(true)
        );
    }
}
