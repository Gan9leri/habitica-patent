package ui.tests;

import common.data.DataGeneration;
import extensions.WithLogin;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ui.pages.MainPage;

@Tag("web")
@Owner("Овсянников Александр")
@Feature("MainPage")
@DisplayName("UI: Тесты для главной страницы")
public class TasksTests extends TestBaseUi {
    DataGeneration data = new DataGeneration();
    MainPage mainPage = new MainPage();

    @Test
    @WithLogin
    @DisplayName("UI: Проверка возможности создания задачи")
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
