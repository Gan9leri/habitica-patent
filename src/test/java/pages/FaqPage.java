package pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.currentFrameUrl;

public class FaqPage {

    ElementsCollection navigationBar = $(".navbar-nav").$$("li");

    @Step("Открытие страницы Faq")
    public FaqPage openFaqPage() {
        open("/static/faq");
        return this;
    }

    @Step("Нажатие на кнопку раздела")
    public FaqPage clickNavBarChapter(int value) {
        navigationBar.get(value).click();
        return this;
    }

    @Step("Проверка Url")
    public FaqPage checkUrl(String value) {
        webdriver().shouldHave(currentFrameUrl(value));
        return this;
    }
}
