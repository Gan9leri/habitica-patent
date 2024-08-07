package mobile.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import mobile.screens.IntroScreen;
import mobile.screens.LoginScreen;
import mobile.screens.RegisterScreen;
import mobile.screens.WelcomeScreen;

@Tag("mobile")
@Owner("Овсянников Александр")
@Feature("LoginApi")
@DisplayName("Mobile: Тесты на навигацию по начальным экранам")
public class ScreenNavigationTests extends TestBaseMobile {
    IntroScreen introScreen = new IntroScreen();
    WelcomeScreen welcomeScreen = new WelcomeScreen();
    LoginScreen loginScreen = new LoginScreen();
    RegisterScreen registerScreen = new RegisterScreen();

    @Test
    @DisplayName("Mobile: Проверка возможности пропустить Intro")
    void checkIntroScreenTest() {

        introScreen.skipIntro();
        welcomeScreen.checkVisibleLoginButton()
                .checkVisibleRegisterButton();
    }

    @Test
    @DisplayName("Mobile: Проверка экрана авторизации")
    void checkLoginScreenTest() {

        introScreen.skipIntro();
        welcomeScreen.clickLoginButton();
        loginScreen.checkVisibleUsernameField()
                .checkVisibleUsernameField()
                .clickBackButton();
        welcomeScreen.checkVisibleLoginButton()
                .checkVisibleRegisterButton();
    }

    @Test
    @DisplayName("Mobile: Проверка экрана регистрации")
    void checkRegisterScreenTest() {
        introScreen.skipIntro();
        welcomeScreen.clickNewGameButton();
        registerScreen.checkVisibleEmailField()
                .checkVisibleEmailField()
                .checkVisiblePasswordField()
                .checkVisibleConfirmPasswordField()
                .clickBackButton();
        welcomeScreen.checkVisibleLoginButton()
                .checkVisibleRegisterButton();
    }
}
