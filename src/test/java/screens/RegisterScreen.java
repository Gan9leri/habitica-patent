package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class RegisterScreen {

    SelenideElement usernameField = $(id("com.habitrpg.android.habitica:id/username")),
                    emailField = $(id("com.habitrpg.android.habitica:id/email")),
                    passwordField = $(id("com.habitrpg.android.habitica:id/password")),
                    confirmPasswordField = $(id("com.habitrpg.android.habitica:id/confirm_password")),
                    backButton = $(id("com.habitrpg.android.habitica:id/back_button"));

    @Step("Проверка поля Username")
    public RegisterScreen checkVisibleUsernameField(){
        usernameField.shouldBe(visible);
        return this;
    }

    @Step("Проверка поля Email address")
    public RegisterScreen checkVisibleEmailField(){
        emailField.shouldBe(visible);
        return this;
    }

    @Step("Проверка поля Password")
    public RegisterScreen checkVisiblePasswordField(){
        passwordField.shouldBe(visible);
        return this;
    }

    @Step("Проверка поля Conform password")
    public RegisterScreen checkVisibleConfirmPasswordField(){
        confirmPasswordField.shouldBe(visible);
        return this;
    }

    @Step("Нажатие на кнопку <-")
    public RegisterScreen clickBackButton(){
        backButton.click();
        return this;
    }
}
