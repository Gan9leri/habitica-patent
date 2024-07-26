package tests.web;
import com.github.javafaker.Faker;
import data.BaseUrlSectionsName;
import data.FaqUrlSectionsNames;
import extensions.WithLogin;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

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
        Faker faker = new Faker();
        String task = faker.job().keySkills();
        open("");
        $(byTagAndText("div", "Добавить задачу")).click();
        $(byTagAndText("div", "задачу")).click();
        $(".task-purple-modal-input").setValue(task);
        $(byTagAndText("button", "Создать")).click();
        $(byTagAndText("p", task)).shouldHave(text(task));
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

    @Test
    @WithLogin
    void challengesTest(){
        open("/challenges/myChallenges");
        $(".owner").shouldHave(text("Gan9leri"));
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

    @Test
    @WithLogin
    void baseUrlSectionsSelectionTest() {
        BaseUrlSectionsName[] names = BaseUrlSectionsName.values();
        open("");
        for (BaseUrlSectionsName item : names) {
            $("#menu_collapse").$$("li").filter(visible)
                    .find(text(item.getValue())).click();
            webdriver().shouldHave(currentFrameUrl(item.getLink()));
        }
    }

    @Test
    @WithLogin
    void faqUrlSectionsSelectionTest(){
        FaqUrlSectionsNames[] names = FaqUrlSectionsNames.values();
        open("https://habitica.com/static/faq");
        for (FaqUrlSectionsNames item: names) {
            $(".navbar-nav").$$("li").filter(visible)
                    .find(text(item.getValue())).click();
            webdriver().shouldHave(currentFrameUrl(item.getLink()));
        }
    }

    @Test
    @WithLogin
    void homePageTest(){
        open("https://habitica.com/static/overview");
        $(".habitica-logo").click();
        webdriver().shouldHave(currentFrameUrl("https://habitica.com/"));
    }

}
