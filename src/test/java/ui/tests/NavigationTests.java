package ui.tests;

import ui.enumeration.MainPageSectionsName;
import ui.enumeration.FaqPageSectionsNames;
import extensions.WithLogin;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ui.pages.FaqPage;
import ui.pages.MainPage;
import ui.pages.OverviewPage;

@Tag("web")
@Owner("Овсянников Александр")
@Feature("MainPage")
@DisplayName("Тесты навигации по разделам сайта")
public class NavigationTests extends TestBase {
    MainPage mainPage = new MainPage();
    OverviewPage overviewPage = new OverviewPage();
    FaqPage faqPage = new FaqPage();
    MainPageSectionsName[] mainPageChapters = MainPageSectionsName.values();
    FaqPageSectionsNames[] faqPageChapters = FaqPageSectionsNames.values();

    @Test
    @WithLogin
    @DisplayName("Проверка возможности перехода к Правилам сообщества")
    void openCommunityGuidelinesTest() {

        mainPage.openMainPage()
                .clickCummunityRules()
                .moveToNewTab()
                .checkUrl("https://habitica.com/static/community-guidelines");
    }

    @Test
    @WithLogin
    @DisplayName("Проверка логотипа")
    void navigationToMainPageTest() {
        overviewPage.openOverviewPage()
                .clickLogoButton();
        mainPage.checkUrl("https://habitica.com/");
    }

    @Test
    @WithLogin
    @DisplayName("Навигация по разделам главной страницы")
    void mainPageNavigationTest() {
        mainPage.openMainPage();
        for (MainPageSectionsName item : mainPageChapters) {
            mainPage.clickMenuCollapseElement(item.getValue())
                    .checkUrl(item.getLink());
        }
    }

    @Test
    @WithLogin
    @DisplayName("Навигация по разделам Faq")
    void faqPageNavigationTest() {
        faqPage.openFaqPage();
        for (FaqPageSectionsNames item : faqPageChapters) {
            faqPage.clickNavBarChapter(item.getValue())
                    .checkUrl(item.getLink());

        }
    }
}
