package tests.web;

import Enumeration.MainPageSectionsName;
import Enumeration.FaqPageSectionsNames;
import extensions.WithLogin;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.FaqPage;
import pages.MainPage;
import pages.OverviewPage;

@DisplayName("Тесты навигации по разделам сайта")
@Tag("web")
@Owner("Овсянников Александр")
@Feature("MainPage")
public class NavigationTests extends TestBase{

    MainPage mainPage = new MainPage();
    OverviewPage overviewPage = new OverviewPage();
    FaqPage faqPage = new FaqPage();
    MainPageSectionsName[] mainPageChapters = MainPageSectionsName.values();
    FaqPageSectionsNames[] faqPageChapters = FaqPageSectionsNames.values();

    @DisplayName("Проверка возможности перехода к Правилам сообщества")
    @Test
    @WithLogin
    void openCommunityGuidelinesTest(){

        mainPage.openMainPage()
                .cummunityRulesClick()
                .moveToNewTab()
                .checkUrl("https://habitica.com/static/community-guidelines")
                .checkCommunityRulesTitle(" Добро пожаловать в страну Habitica! ");
    }

    @DisplayName("Проверка логотипа")
    @Test
    @WithLogin
    void navigationToMainPageTest(){
        overviewPage.openOverviewPage()
                    .logoButtonClick();
        mainPage.checkUrl("https://habitica.com/");
    }

    @DisplayName("Навигация по разделам главной страницы")
    @Test
    @WithLogin
    void mainPageNavigationTest() {
        mainPage.openMainPage();
        for (MainPageSectionsName item : mainPageChapters) {
            mainPage.menuCollapseElementClick(item.getValue())
                    .checkUrl(item.getLink());
        }
    }

    @DisplayName("Навигация по разделам Faq")
    @Test
    @WithLogin
    void faqPageNavigationTest(){
        faqPage.openFaqPage();
        for (FaqPageSectionsNames item: faqPageChapters) {
            faqPage.navBarChapterClick(item.getValue())
                    .checkUrl(item.getLink());

        }
    }
}