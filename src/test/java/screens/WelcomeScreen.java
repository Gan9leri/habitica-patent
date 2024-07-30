package screens;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class WelcomeScreen {

    SelenideElement loginButton = $(id("com.habitrpg.android.habitica:id/show_login_button")),
                    newGameButton = $(id("com.habitrpg.android.habitica:id/new_game_button"));

    @Step("Проверка кнопки LOGIN")
    public WelcomeScreen checkLoginButton(String value){
        loginButton.shouldHave(text(value)).shouldBe(visible);
        return this;
    }

    @Step("Проверка кнопки REGISTER")
    public WelcomeScreen checkRegisterButton(String value){
        newGameButton.shouldHave(text(value)).shouldBe(visible);
        return this;
    }

    @Step("Нажатие на кнопку LOGIN")
    public WelcomeScreen loginButtonClick(){
        loginButton.click();
        return this;
    }

    @Step("Нажатие на кнопку REGISTER")
    public WelcomeScreen newGameButtonClick(){
        newGameButton.click();
        return this;
    }

}
