package tests.web;

import com.codeborne.selenide.Selenide;
import extensions.WithLogin;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.currentFrameUrl;
import static io.restassured.RestAssured.given;

@Tag("ui")
public class HabiticaUiTests extends TestBase {

    @Test
    @WithLogin
    void addTaskTest(){
        open("");
        $(byTagAndText("div", "Добавить задачу")).click();
        $(byTagAndText("div", "задачу")).click();
        $(".task-purple-modal-input").setValue("Сделать диплом");
        $(byTagAndText("button", "Создать")).click();
        $(".task-content").shouldHave(text("Сделать диплом"));
    }

    @Test
    @WithLogin
    void deleteTaskTest(){
        open("");
        $(byTagAndText("div", "Добавить задачу")).click();
        $(byTagAndText("div", "задачу")).click();
        $(".task-purple-modal-input").setValue("Сходить в магазин");
        $(byTagAndText("button", "Создать")).click();
        $(byTagAndText("p", "Сходить в магазин")).click();
        $(byTagAndText("span", "Удалить задачу")).click();
        Selenide.switchTo().alert().accept();
        $(".task-content").shouldNotHave(text("Сходить в магазин"));
    }

    @Test
    @WithLogin
    void openWikiTest(){
        open("");
        $(byTagAndText("a", "Помощь")).click();
        webdriver().shouldHave(currentFrameUrl("https://habitica.com/static/faq"));
    }
}
