package tests.web;

import com.github.javafaker.Faker;
import extensions.WithLogin;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Tag("ui")
public class TasksTests extends TestBase{
    @Test
    @WithLogin
    void addTaskTest(){
        Faker faker = new Faker();
        String task = faker.job().keySkills();
        open("");
        $(byTagAndText("div", "Добавить задачу")).click();
        $(byTagAndText("div", "задачу")).click();
        $(".task-purple-modal-input").setValue(task);
        $(byTagAndText("button", "Создать")).click();
        $(byTagAndText("p", task)).shouldHave(text(task));
    }
}
