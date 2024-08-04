package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class IntroScreen {
    SelenideElement skipButton = $(id("com.habitrpg.android.habitica:id/skipButton"));

    @Step("Нажатие на кнопку Skip")
    public IntroScreen skipIntro() {
        skipButton.click();
        return this;
    }
}
