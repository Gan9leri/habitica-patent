package tests.web;

import com.github.javafaker.Faker;
import data.DataGeneration;
import extensions.WithLogin;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@DisplayName("Тесты для главной страницы")
@Tag("web")
@Owner("Овсянников Александр")
@Feature("MainPage")
public class TasksTests extends TestBase{

    DataGeneration data = new DataGeneration();
    MainPage mainPage = new MainPage();

    @DisplayName("Проверка возможности создания задачи")
    @Test
    @WithLogin
    void addTaskTest(){
        String task = data.task;
        mainPage.openMainPage()
                .addTaskClick()
                .itemTaskSelection()
                .inputTaskName(task)
                .createButtonClick()
                .checkingTasksContainer(task);
    }
}
