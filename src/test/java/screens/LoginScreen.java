package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class LoginScreen {

    SelenideElement usernameField = $(id("com.habitrpg.android.habitica:id/username")),
                    passwordField = $(id("com.habitrpg.android.habitica:id/password")),
                    backButton = $(id("com.habitrpg.android.habitica:id/back_button"));

    @Step("Проверка поля Username")
    public LoginScreen checkUsernameField(String value){
        usernameField.shouldHave(text(value));
        return this;
    }

    @Step("Проверка поля Password")
    public LoginScreen checkPasswordField(String value){
        passwordField.shouldHave(text(value));
        return this;
    }

    @Step("Нажатие на кнопку <-")
    public LoginScreen backButtonClick(){
        backButton.click();
        return this;
    }
}
