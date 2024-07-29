package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.currentFrameUrl;

public class FaqPage {

    ElementsCollection navigationBar = $(".navbar-nav").$$("li");

    @Step("Открытие страницы Faq")
    public FaqPage openFaqPage(){
        open("https://habitica.com/static/faq");
        return this;
    }

    @Step("Нажатие на кнопку раздела")
    public FaqPage navBarChapterClick(String value){
        navigationBar.filter(visible).find(text(value)).click();
        return this;
    }

    @Step("Проверка Url")
    public FaqPage checkUrl(String value){
        webdriver().shouldHave(currentFrameUrl(value));
        return this;
    }

}
