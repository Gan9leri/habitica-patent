package extensions;

import com.fasterxml.jackson.databind.ObjectMapper;
import data.DataGeneration;
import models.AuthResponseBodyModel;
import models.PostCreateTaskUserRequestModel;
import models.PostCreateTaskUserResponseModel;

import java.io.File;
import java.io.IOException;

import static authorization.Authorization.getAuthResponse;
import static io.restassured.RestAssured.given;
import static specs.Specs.RequestSpec;
import static specs.Specs.responseSpec201;

public class TaskExtension {

    public static String createTask() throws IOException {
        DataGeneration data = new DataGeneration();
        AuthResponseBodyModel authResponse = getAuthResponse();
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
                        .header("X-Api-Key", authResponse.getData().getApiToken())
                        .header("X-Api-User", authResponse.getData().getId())
                        .post("/v4/tasks/user")
                        .then()
                        .spec(responseSpec201)
                        .extract().as(PostCreateTaskUserResponseModel.class);
        return response.getData().get_id();
    }
}


