package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class OverviewPage {

    SelenideElement logoButton = $(".habitica-logo");

    @Step("Открытие страницы Информация для новичков")
    public OverviewPage openOverviewPage(){
        open("/static/overview");
        return this;
    }

    @Step("Нажатие на логотип")
    public OverviewPage logoButtonClick(){
        logoButton.click();
        return this;
    }


}
