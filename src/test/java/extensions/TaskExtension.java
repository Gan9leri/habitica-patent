package extensions;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.DataGeneration;
import models.PostCreateTaskUserRequestModel;
import models.PostCreateTaskUserResponseModel;
import java.io.File;
import java.io.IOException;
import static authorization.Authorization.getAuthResponse;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static specs.Specs.requestSpec;
import static specs.Specs.responseSpec201;

public class TaskExtension {
    public static String createTask() throws IOException {
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
        return response.getData().get_id();
    }
}


