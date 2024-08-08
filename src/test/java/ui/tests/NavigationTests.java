package ui.tests;

import ui.utils.MainPageSectionsName;
import extensions.WithLogin;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ui.pages.MainPage;
import ui.pages.OverviewPage;
import ui.utils.UtilsMethods;

@Tag("web")
@Owner("Овсянников Александр")
@Feature("MainPage")
@DisplayName("UI: Тесты навигации по разделам сайта")
public class NavigationTests extends TestBaseUi {
    MainPage mainPage = new MainPage();
    OverviewPage overviewPage = new OverviewPage();
    MainPageSectionsName[] mainPageChapters = MainPageSectionsName.values();
    UtilsMethods util = new UtilsMethods();

    @Test
    @WithLogin
    @DisplayName("UI: Проверка логотипа")
    void navigationToMainPageTest() {
        overviewPage.openOverviewPage()
                    .clickLogoButton();
        util.checkUrl("https://habitica.com/");
    }

    @Test
    @WithLogin
    @DisplayName("UI: Навигация по разделам главной страницы")
    void mainPageNavigationTest() {
        mainPage.openMainPage();
        for (MainPageSectionsName item : mainPageChapters) {
            mainPage.clickMenuCollapseElement(item.getValue());
            util.checkUrl(item.getLink());
        }
    }
}
