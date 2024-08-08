package ui.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.currentFrameUrl;

public class MainPage {
    private final SelenideElement addTaskButton = $("#create-task-btn"),
            itemTask = $("div.px-2:nth-child(3) > div:nth-child(2)"),
            inputArea = $(".task-purple-modal-input"),
            createButton = $("button.justify-content-center:nth-child(2)"),
            communityRulesButton = $("[href='/static/community-guidelines']"),
            communityRulesTitle = $("#welcome");
    private final ElementsCollection menuCollapse = $("#menu_collapse").$$("li");

    @Step("Открытие главной страницы")
    public MainPage openMainPage() {
        open("");
        return this;
    }

    @Step("Нажатие на кнопку Добавить задачу")
    public MainPage clickAddTaskButton() {
        addTaskButton.click();
        return this;
    }

    @Step("Выбор пункта из выпадающего списка")
    public MainPage selectItemTask() {
        itemTask.click();
        return this;
    }

    @Step("Ввод названия задачи")
    public MainPage inputTaskName(String value) {
        inputArea.setValue(value);
        return this;
    }

    @Step("Нажатие на кнопку Создать")
    public MainPage clickCreateButton() {
        createButton.click();
        return this;
    }

    @Step("Проверка задач")
    public MainPage checkTasksContainer(String value) {
        $(byTagAndText("p", value)).shouldHave(text(value));
        return this;
    }

    @Step("Проверка Url")
    public MainPage checkUrl(String value) {
        webdriver().shouldHave(currentFrameUrl(value));
        return this;
    }

    @Step("Нажатие на кнопку раздела")
    public MainPage clickMenuCollapseElement(int value) {
        menuCollapse.get(value).click();
        return this;
    }
}
