package ui.tests;

import ui.enumeration.MainPageSectionsName;
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
@DisplayName("UI: Тесты навигации по разделам сайта")
public class NavigationTests extends TestBaseUi {
    MainPage mainPage = new MainPage();
    OverviewPage overviewPage = new OverviewPage();
    FaqPage faqPage = new FaqPage();
    MainPageSectionsName[] mainPageChapters = MainPageSectionsName.values();

    @Test
    @WithLogin
    @DisplayName("UI: Проверка логотипа")
    void navigationToMainPageTest() {
        overviewPage.openOverviewPage()
                .clickLogoButton();
        mainPage.checkUrl("https://habitica.com/");
    }

    @Test
    @WithLogin
    @DisplayName("UI: Навигация по разделам главной страницы")
    void mainPageNavigationTest() {
        mainPage.openMainPage();
        for (MainPageSectionsName item : mainPageChapters) {
            mainPage.clickMenuCollapseElement(item.getValue())
                    .checkUrl(item.getLink());
        }
    }
}
