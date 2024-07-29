package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.currentFrameUrl;

public class MainPage {

    SelenideElement addTaskButton = $(byTagAndText("div", "Добавить задачу")),
                    itemTask =  $(byTagAndText("div", "задачу")),
                    inputArea =  $(".task-purple-modal-input"),
                    createButton = $(byTagAndText("button", "Создать")),
                    communityRulesButton = $(byTagAndText("a", "Правила сообщества")),
                    communityRulestitle = $("#welcome");
    ElementsCollection menuCollapse = $("#menu_collapse").$$("li");

    @Step("Открытие главной страницы")
    public MainPage openMainPage(){
        open("");
        return this;
    }

    @Step("Нажатие на кнопку Добавить задачу")
    public MainPage addTaskClick(){
        addTaskButton.click();
        return this;
    }

    @Step("Выбор пункта из выпадающего списка")
    public MainPage itemTaskSelection(){
        itemTask.click();
        return this;
    }

    @Step("Ввод названия задачи")
    public MainPage inputTaskName(String value){
        inputArea.setValue(value);
        return this;
    }

    @Step("Нажатие на кнопку Создать")
    public MainPage createButtonClick(){
        createButton.click();
        return this;
    }

    @Step("Проверка, что задача создалась")
    public MainPage checkingTasksContainer(String value){
        $(byTagAndText("p", value)).shouldHave(text(value));
        return this;
    }

    @Step("Нажатие на кнопку Правила сообщества")
    public MainPage cummunityRulesClick(){
        communityRulesButton.click();
        return this;
    }

    @Step("Переход к следующей вкладке")
    public MainPage moveToNewTab(){
        webdriver().driver().switchTo().window(1);
        return this;
    }

    @Step("Проверка Url")
    public MainPage checkUrl(String value){
        webdriver().shouldHave(currentFrameUrl(value));
        return this;
    }

    @Step("Проверка заголовка")
    public MainPage checkCommunityRulesTitle(String value){
        communityRulestitle.shouldHave(text(value));
        return this;
    }

    @Step("Нажатие на кнопку раздела")
    public MainPage menuCollapseElementClick(String value){
        menuCollapse.filter(visible).find(text(value)).click();
        return this;
    }

}
