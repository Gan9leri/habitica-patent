package mobile.screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class WelcomeScreen {

    SelenideElement loginButton = $(id("com.habitrpg.android.habitica:id/show_login_button")),
            newGameButton = $(id("com.habitrpg.android.habitica:id/new_game_button"));

    @Step("Проверка кнопки LOGIN")
    public WelcomeScreen checkVisibleLoginButton() {
        loginButton.shouldBe(visible);
        return this;
    }

    @Step("Проверка кнопки REGISTER")
    public WelcomeScreen checkVisibleRegisterButton() {
        newGameButton.shouldBe(visible);
        return this;
    }

    @Step("Нажатие на кнопку LOGIN")
    public WelcomeScreen clickLoginButton() {
        loginButton.click();
        return this;
    }

    @Step("Нажатие на кнопку REGISTER")
    public WelcomeScreen clickNewGameButton() {
        newGameButton.click();
        return this;
    }

}
