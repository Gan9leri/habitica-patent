package tests.web;

import data.DataGeneration;
import extensions.WithLogin;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;

@DisplayName("Тесты для главной страницы")
@Tag("web")
@Owner("Овсянников Александр")
@Feature("MainPage")
public class TasksTests extends TestBase {
    DataGeneration data = new DataGeneration();
    MainPage mainPage = new MainPage();

    @DisplayName("Проверка возможности создания задачи")
    @Test
    @WithLogin
    void addTaskTest() {
        String task = data.task;
        mainPage.openMainPage()
                .clickAddTaskButton()
                .selectItemTask()
                .inputTaskName(task)
                .clickCreateButton()
                .checkTasksContainer(task);
    }
}
