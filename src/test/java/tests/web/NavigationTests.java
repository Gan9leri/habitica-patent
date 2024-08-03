package tests.web;
import enumeration.MainPageSectionsName;
import enumeration.FaqPageSectionsNames;
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
    /*MainPage mainPage = new MainPage();
    OverviewPage overviewPage = new OverviewPage();
    FaqPage faqPage = new FaqPage();
    MainPageSectionsName[] mainPageChapters = MainPageSectionsName.values();
    FaqPageSectionsNames[] faqPageChapters = FaqPageSectionsNames.values();

    @DisplayName("Проверка возможности перехода к Правилам сообщества")
    @Test
    @WithLogin
    void openCommunityGuidelinesTest(){

        mainPage.openMainPage()
                .clickCummunityRules()
                .moveToNewTab()
                .checkUrl("https://habitica.com/static/community-guidelines")
                .checkCommunityRulesTitle(" Добро пожаловать в страну Habitica! ");
    }

    @DisplayName("Проверка логотипа")
    @Test
    @WithLogin
    void navigationToMainPageTest(){
        overviewPage.openOverviewPage()
                    .clickLogoButton();
        mainPage.checkUrl("https://habitica.com/");
    }

    @DisplayName("Навигация по разделам главной страницы")
    @Test
    @WithLogin
    void mainPageNavigationTest() {
        mainPage.openMainPage();
        for (MainPageSectionsName item : mainPageChapters) {
            mainPage.clickMenuCollapseElement(item.getValue())
                    .checkUrl(item.getLink());
        }
    }

    @DisplayName("Навигация по разделам Faq")
    @Test
    @WithLogin
    void faqPageNavigationTest(){
        faqPage.openFaqPage();
        for (FaqPageSectionsNames item: faqPageChapters) {
            faqPage.clickNavBarChapter(item.getValue())
                    .checkUrl(item.getLink());

        }
    }*/
}
