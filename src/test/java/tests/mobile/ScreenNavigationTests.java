package tests.mobile;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

@Tag("mobile")
public class ScreenNavigationTests extends TestBase{

    @Test
    void checkIntroScreenTest() throws InterruptedException {

        $(id("com.habitrpg.android.habitica:id/skipButton")).click();
        $(id("com.habitrpg.android.habitica:id/show_login_button")).shouldHave(text("LOGIN")).shouldBe(visible);
        $(id("com.habitrpg.android.habitica:id/new_game_button")).shouldHave(text("REGISTER")).shouldBe(visible);

    }

    @Test
    void checkLoginScreenTest(){

        $(id("com.habitrpg.android.habitica:id/skipButton")).click();
        $(id("com.habitrpg.android.habitica:id/show_login_button")).click();
        $(id("com.habitrpg.android.habitica:id/username")).shouldHave(text("Email/Username"));
        $(id("com.habitrpg.android.habitica:id/password")).shouldHave(text("Password"));
        $(id("com.habitrpg.android.habitica:id/back_button")).click();
        $(id("com.habitrpg.android.habitica:id/show_login_button")).shouldHave(text("LOGIN")).shouldBe(visible);
        $(id("com.habitrpg.android.habitica:id/new_game_button")).shouldHave(text("REGISTER")).shouldBe(visible);

    }

    @Test
    void checkRegisterScreenTest(){

        $(id("com.habitrpg.android.habitica:id/skipButton")).click();
        $(id("com.habitrpg.android.habitica:id/new_game_button")).click();
        $(id("com.habitrpg.android.habitica:id/username")).shouldHave(text("Username"));
        $(id("com.habitrpg.android.habitica:id/email")).shouldHave(text("Email address"));
        $(id("com.habitrpg.android.habitica:id/password")).shouldHave(text("Password"));
        $(id("com.habitrpg.android.habitica:id/confirm_password")).shouldHave(text("Confirm password"));
        $(id("com.habitrpg.android.habitica:id/back_button")).click();
        $(id("com.habitrpg.android.habitica:id/show_login_button")).shouldHave(text("LOGIN")).shouldBe(visible);
        $(id("com.habitrpg.android.habitica:id/new_game_button")).shouldHave(text("REGISTER")).shouldBe(visible);

    }

}
