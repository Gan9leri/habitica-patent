package api.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import common.data.DataGeneration;
import api.models.PostCreateTaskUserRequestModel;
import api.models.PostCreateTaskUserResponseModel;

import java.io.File;
import java.io.IOException;

import static extensions.authorization.Authorization.getAuthResponse;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static api.specs.Specs.requestSpec;
import static api.specs.Specs.responseSpec201;

public class TaskExtension {
    public static String createTask() throws IOException {
        DataGeneration data = new DataGeneration();
        ObjectMapper om = new ObjectMapper();
        PostCreateTaskUserRequestModel[] request = om.readValue(
                new File("src/test/resources/request/PostAddTask.json"),
                PostCreateTaskUserRequestModel[].class
        );
        request[0].setText(data.getTask());
        request[0].set_id(data.getTaskId());
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


