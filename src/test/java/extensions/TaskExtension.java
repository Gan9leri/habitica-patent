package extensions;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import models.UserResponseBodyModel;
import static authorization.Authorization.getAuthResponse;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;
import static io.restassured.RestAssured.given;

public class TaskExtension {

    public static String addTask(){
        Faker faker = new Faker();
        String task = faker.job().keySkills();
        open("");
        $(byTagAndText("div", "Добавить задачу")).click();
        $(byTagAndText("div", "задачу")).click();
        $(".task-purple-modal-input").setValue(task);
        $(byTagAndText("button", "Создать")).click();
        closeWindow();
        return task;
    }

    public static String getTaskId(){
        Faker faker = new Faker();
        String task = faker.job().keySkills();
        open("");
        $(byTagAndText("div", "Добавить задачу")).click();
        $(byTagAndText("div", "задачу")).click();
        $(".task-purple-modal-input").setValue(task);
        $(byTagAndText("button", "Создать")).click();
        String xApiUser = getAuthResponse().getData().getId();
        String xApiKey = getAuthResponse().getData().getApiToken();
        UserResponseBodyModel response =
                given().log().all()
                        .contentType(ContentType.JSON)
                        .header("X-Api-User", xApiUser)
                        .header("X-Api-Key", xApiKey)
                        .when()
                        .get("v4/tasks/user")
                        .then().log().all()
                        .statusCode(200)
                        .extract().as(UserResponseBodyModel.class);
        closeWindow();
        return response.getData().get(0).getId();
    }
}
