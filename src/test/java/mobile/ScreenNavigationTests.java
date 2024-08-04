package mobile;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.IntroScreen;
import screens.LoginScreen;
import screens.RegisterScreen;
import screens.WelcomeScreen;

@Tag("mobile")
@Owner("Овсянников Александр")
@Feature("LoginApi")
@DisplayName("Тесты на навигацию по начальным экранам")
public class ScreenNavigationTests extends TestBase {
    IntroScreen introScreen = new IntroScreen();
    WelcomeScreen welcomeScreen = new WelcomeScreen();
    LoginScreen loginScreen = new LoginScreen();
    RegisterScreen registerScreen = new RegisterScreen();

    @Test
    @DisplayName("Проверка возможности пропустить Intro")
    void checkIntroScreenTest() {

        introScreen.skipIntro();
        welcomeScreen.checkVisibleLoginButton()
                .checkVisibleRegisterButton();
    }

    @Test
    @DisplayName("Проверка экрана авторизации")
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
    @DisplayName("Проверка экрана регистрации")
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
