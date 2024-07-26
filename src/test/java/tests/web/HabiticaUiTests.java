package tests.web;
import com.github.javafaker.Faker;
import com.codeborne.selenide.Selenide;
import extensions.WithLogin;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
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
        $(byTagAndText("p", "Сделать диплом")).shouldHave(text("Сделать диплом"));
    }

    @Test
    @WithLogin
    void openWikiTest(){
        open("");
        $(byTagAndText("a", "Помощь")).click();
        webdriver().shouldHave(currentFrameUrl("https://habitica.com/static/faq"));
    }

    @Test
    @WithLogin
    void openRuleTest(){
        open("");
        $(byTagAndText("a", "Правила сообщества")).scrollIntoView(true).click();
        webdriver().driver().switchTo().window(1);
        webdriver().shouldHave(currentFrameUrl("https://habitica.com/static/community-guidelines"));
        $("#welcome").shouldHave(text(" Добро пожаловать в страну Habitica! "));
    }

    static Stream<Arguments> sectionsForumTest(){
        return Stream.of( Arguments.of( List.of(
                "Задачи", "Инвентарь", "Лавки", "Команда", "Группа", "Испытания", "Помощь") ) );
    }
    @ParameterizedTest
    @MethodSource
    @WithLogin
    void sectionsForumTest(List<String> value) {
        open("");
        for (String item : value) {
            $("#menu_collapse").$$("li").filter(visible).find(text(item)).click();
        }
    }

    @Test
    @WithLogin
    void challengesTest(){
        open("/challenges/myChallenges");
        $(".owner").shouldHave(text("Gan9leri"));
    }

    @Test
    @WithLogin
    void homePageTest(){
        open("https://habitica.com/static/overview");
        $(".habitica-logo").click();
        webdriver().shouldHave(currentFrameUrl("https://habitica.com/"));
    }

    @Test
    @WithLogin
    void teamChatTest(){
        Faker faker = new Faker();
        String message = faker.name().firstName();
        open("https://habitica.com/party");
        $("textarea[placeholder='Введите здесь сообщение для членов команды']").setValue(message);
        $(byTagAndText("button", "Отправить")).click();
        $(".container-fluid").shouldHave(text(message));
    }
}
