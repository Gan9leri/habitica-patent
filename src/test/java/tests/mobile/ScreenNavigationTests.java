package tests.mobile;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.IntroScreen;
import screens.LoginScreen;
import screens.RegisterScreen;
import screens.WelcomeScreen;


@DisplayName("Тесты на навигацию по начальным экранам")
@Tag("mobile")
@Owner("Овсянников Александр")
@Feature("LoginApi")
public class ScreenNavigationTests extends TestBase{

    IntroScreen introScreen = new IntroScreen();
    WelcomeScreen welcomeScreen = new WelcomeScreen();
    LoginScreen loginScreen = new LoginScreen();
    RegisterScreen registerScreen = new RegisterScreen();

    @DisplayName("Проверка возможности пропустить Intro")
    @Test
    void checkIntroScreenTest() throws InterruptedException {

        introScreen.skipIntro();
        welcomeScreen.checkLoginButton("LOGIN")
                     .checkRegisterButton("REGISTER");
    }

    @DisplayName("Проверка возможности перейти к экрану авторизации")
    @Test
    void checkLoginScreenTest(){

        introScreen.skipIntro();
        welcomeScreen.loginButtonClick();
        loginScreen.checkUsernameField("Email/Username")
                   .checkPasswordField("Password")
                   .backButtonClick();
        welcomeScreen.checkLoginButton("LOGIN")
                     .checkRegisterButton("REGISTER");
    }

    @DisplayName("Проверка возможности перейти к экрану регистрации")
    @Test
    void checkRegisterScreenTest(){
        introScreen.skipIntro();
        welcomeScreen.newGameButtonClick();
        registerScreen.checkUsernameField("Username")
                      .checkEmailField("Email address")
                      .checkPasswordField("Password")
                      .checkConformPasswordField("Confirm password")
                      .backButtonClick();
        welcomeScreen.checkLoginButton("LOGIN")
                .checkRegisterButton("REGISTER");
    }
}
