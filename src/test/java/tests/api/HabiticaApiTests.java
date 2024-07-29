package tests.api;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
//import static tests.api.TaskExtension.getTaskId;
import static org.assertj.core.api.Assertions.assertThat;

import config.AuthConfig;
import extensions.WithLogin;
import io.restassured.http.ContentType;
import models.*;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static authorization.Authorization.getAuthResponse;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
//import static tests.api.TaskExtension.addTask;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static specs.HabiticaSpecs.*;
import static tests.api.TaskExtension.addTask;
import static tests.api.TaskExtension.getTaskId;


@Tag("api")
public class HabiticaApiTests extends TestBase{

    @Test
    @WithLogin
    void getTaskTest(){

        String task = addTask();
        String xApiUser = getAuthResponse().getData().getId();
        String xApiKey = getAuthResponse().getData().getApiToken();
        UserResponseBodyModel response =
        given(RequestSpec)
                .header("X-Api-User", xApiUser)
                .header("X-Api-Key", xApiKey)
                .when()
                .get("v4/tasks/user")
                .then()
                .spec(ResponseSpec200)
                .extract().as(UserResponseBodyModel.class);
        assertThat(response.getData().get(0).getText()).isEqualTo(task);
    }

    @Test
    @WithLogin
    void deleteTest(){

        String taskId = getTaskId();
        String xApiUser = getAuthResponse().getData().getId();
        String xApiKey = getAuthResponse().getData().getApiToken();
        DeleteTaskResponseBodyModel response =
                given(RequestSpec)
                        .header("X-Api-User", xApiUser)
                        .header("X-Api-Key", xApiKey)
                        .when()
                        .delete("v4/tasks/" + taskId)
                        .then()
                        .spec(ResponseSpec200)
                        .extract().as(DeleteTaskResponseBodyModel.class);
        assertThat(response.getSuccess()).isEqualTo(true);
    }

    @Test
    void loginTest() {
        AuthConfig authConfig = ConfigFactory.create(AuthConfig.class, System.getProperties());
        AuthRequestBodyModel request = new AuthRequestBodyModel();
        request.setUsername(authConfig.login());
        request.setPassword(authConfig.password());
        AuthResponseBodyModel response = given(RequestSpec)
                .body(request)
                .when()
                .post("/v4/user/auth/local/login")
                .then()
                .spec(ResponseSpec200)
                .extract().as(AuthResponseBodyModel.class);
        assertThat(response.getSuccess()).isEqualTo(true);
    }

    @Test
    void negativeLoginTest(){
        AuthRequestBodyModel request = new AuthRequestBodyModel();
        request.setUsername("error");
        request.setPassword("error");
        NotAuthRequestBodyModel response = given(RequestSpec)
                .body(request)
                .when()
                .post("/v4/user/auth/local/login")
                .then()
                .spec(ResponseSpec401)
                .extract().as(NotAuthRequestBodyModel.class);
        assertThat(response.getSuccess()).isEqualTo(false);
    }

    @Test
    void getTagsTest(){

        String xApiUser = getAuthResponse().getData().getId();
        String xApiKey = getAuthResponse().getData().getApiToken();
        TagResponseBodyModel response =
                given(RequestSpec)
                        .when()
                        .header("X-Api-User", xApiUser)
                        .header("X-Api-Key", xApiKey)
                        .get("/v3/tags")
                        .then()
                        .spec(ResponseSpec200)
                        .extract().as(TagResponseBodyModel.class);
        Integer size = response.getData().size();
        assertThat(response.getSuccess()).isEqualTo(true);
        assertThat(response.getData().get(size-1).getName()).isEqualTo("QA.GURU");
    }
}
