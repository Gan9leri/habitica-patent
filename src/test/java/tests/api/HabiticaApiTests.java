package tests.api;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static extensions.TaskExtension.getTaskId;
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
import static extensions.TaskExtension.addTask;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@Tag("api")
public class HabiticaApiTests extends TestBase{

    @Test
    @WithLogin
    void getTaskTest(){

        String task = addTask();
        String xApiUser = getAuthResponse().getData().getId();
        String xApiKey = getAuthResponse().getData().getApiToken();
        UserResponseBodyModel response =
        given().log().all()
                .contentType(ContentType.JSON)
                .header("X-Api-User", xApiUser)
                .header("X-Api-Key", xApiKey)
                .when()
                .get("v4/tasks/user")
                .then().log().all().
                statusCode(200)
                .extract().as(UserResponseBodyModel.class);
        assertThat(response.getData().getFirst().getText()).isEqualTo(task);
    }

    @Test
    @WithLogin
    void deleteTest(){

        String taskId = getTaskId();
        String xApiUser = getAuthResponse().getData().getId();
        String xApiKey = getAuthResponse().getData().getApiToken();
        DeleteTaskResponseBodyModel response =
                given().log().all()
                        .contentType(ContentType.JSON)
                        .header("X-Api-User", xApiUser)
                        .header("X-Api-Key", xApiKey)
                        .when()
                        .delete("v4/tasks/" + taskId)
                        .then().log().all()
                        .statusCode(200)
                        .extract().as(DeleteTaskResponseBodyModel.class);
        assertThat(response.getSuccess()).isEqualTo(true);
    }

    @Test
    void loginTest() {
        AuthConfig authConfig = ConfigFactory.create(AuthConfig.class, System.getProperties());
        AuthRequestBodyModel request = new AuthRequestBodyModel();
        request.setUsername(authConfig.login());
        request.setPassword(authConfig.password());
        AuthResponseBodyModel response = given().log().all()
                .contentType(ContentType.JSON)
                .body(request)
                .when()
                .post("/v4/user/auth/local/login")
                .then().log().all()
                .statusCode(200)
                .extract().as(AuthResponseBodyModel.class);
        assertThat(response.getSuccess()).isEqualTo(true);
    }

    @Test
    void negativeLoginTest(){
        AuthRequestBodyModel request = new AuthRequestBodyModel();
        request.setUsername("error");
        request.setPassword("error");
        NotAuthRequestBodyModel response = given().log().all()
                .contentType(ContentType.JSON)
                .body(request)
                .when()
                .post("/v4/user/auth/local/login")
                .then().log().all()
                .statusCode(401)
                .extract().as(NotAuthRequestBodyModel.class);
        assertThat(response.getSuccess()).isEqualTo(false);
    }

    @Test
    void getTagsTest(){

        String xApiUser = getAuthResponse().getData().getId();
        String xApiKey = getAuthResponse().getData().getApiToken();
        TagResponseBodyModel response =
                given().log().all()
                        .when()
                        .header("X-Api-User", xApiUser)
                        .header("X-Api-Key", xApiKey)
                        .get("/v3/tags")
                        .then().log().all()
                        .statusCode(200)
                        .extract().as(TagResponseBodyModel.class);
        assertThat(response.getSuccess()).isEqualTo(true);
        assertEquals("QA.GURU", response.getData().getLast().getName());
    }
}
