package tests.web;

import data.BaseUrlSectionsName;
import data.FaqUrlSectionsNames;
import extensions.WithLogin;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.currentFrameUrl;

@Tag("ui")
public class PageNavigationTests extends TestBase{
    @Test
    @WithLogin
    void openCommunityGuidelinesTest(){
        open("");
        $(byTagAndText("a", "Правила сообщества")).scrollIntoView(true).click();
        webdriver().driver().switchTo().window(1);
        webdriver().shouldHave(currentFrameUrl("https://habitica.com/static/community-guidelines"));
        $("#welcome").shouldHave(text(" Добро пожаловать в страну Habitica! "));
    }

    @Test
    @WithLogin
    void mainPageNavigationTest() {
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
    void faqPageNavigationTest(){
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
    void navigationToMainPageTest(){
        open("https://habitica.com/static/overview");
        $(".habitica-logo").click();
        webdriver().shouldHave(currentFrameUrl("https://habitica.com/"));
    }
}
