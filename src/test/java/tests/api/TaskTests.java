package tests.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import data.DataGeneration;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import models.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import static authorization.Authorization.getAuthResponse;
import static extensions.TaskExtension.*;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static specs.Specs.*;

@DisplayName("Тесты на работу с задачами")
@Tag("api")
@Owner("Овсянников Александр")
@Feature("LoginApi")
public class TaskTests extends TestBase{

    @DisplayName("Тест на удаление задачи")
    @Test
    void deleteTest() throws IOException {
        AuthResponseBodyModel authResponse = getAuthResponse();
        String taskId = createTask();
        System.out.println(taskId);
        DeleteTaskResponseBodyModel response =
                step("Отправка DELETE запроса на удаление задачи", () ->
                    given(RequestSpec)
                            .header("X-Api-Key", getAuthResponse().getData().getApiToken())
                            .header("X-Api-User", getAuthResponse().getData().getId())
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


    @Test
    void addApiTask() throws IOException {
        DataGeneration data = new DataGeneration();
        String text = data.task;
        String id = data.taskId;
        ObjectMapper om = new ObjectMapper();
        PostCreateTaskUserRequestModel[] request = om.readValue(
                new File("src/test/resources/request/PostAddTask.json"),
                PostCreateTaskUserRequestModel[].class
        );
        request[0].setText(text);
        request[0].set_id(id);
        PostCreateTaskUserResponseModel response =
        given(RequestSpec)
                .when()
                .body(request)
                .header("X-Api-Key", getAuthResponse().getData().getApiToken())
                .header("X-Api-User", getAuthResponse().getData().getId())
                .post("/v4/tasks/user")
                .then()
                .spec(responseSpec201)
                .extract().as(PostCreateTaskUserResponseModel.class);
        assertThat(response.getSuccess()).isEqualTo(true);
    }
}
