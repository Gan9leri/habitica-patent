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
                    communityRulesTitle = $("#welcome");
    ElementsCollection menuCollapse = $("#menu_collapse").$$("li");

    @Step("Открытие главной страницы")
    public MainPage openMainPage(){
        open("");
        return this;
    }

    @Step("Нажатие на кнопку Добавить задачу")
    public MainPage clickAddTaskButton(){
        addTaskButton.click();
        return this;
    }

    @Step("Выбор пункта из выпадающего списка")
    public MainPage selectItemTask(){
        itemTask.click();
        return this;
    }

    @Step("Ввод названия задачи")
    public MainPage inputTaskName(String value){
        inputArea.setValue(value);
        return this;
    }

    @Step("Нажатие на кнопку Создать")
    public MainPage clickCreateButton(){
        createButton.click();
        return this;
    }

    @Step("Проверка задач")
    public MainPage checkTasksContainer(String value){
        $(byTagAndText("p", value)).shouldHave(text(value));
        return this;
    }

    @Step("Нажатие на кнопку Правила сообщества")
    public MainPage clickCummunityRules(){
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
        communityRulesTitle.shouldHave(text(value));
        return this;
    }

    @Step("Нажатие на кнопку раздела")
    public MainPage clickMenuCollapseElement(String value){
        menuCollapse.filter(visible).find(text(value)).click();
        return this;
    }
}
