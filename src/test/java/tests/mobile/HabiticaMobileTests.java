package tests.mobile;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

@Tag("mobile")
public class HabiticaMobileTests extends TestBase{

    @Test
    void test() throws InterruptedException {

        $(id("com.habitrpg.android.habitica:id/skipButton")).click();
        $(id("com.habitrpg.android.habitica:id/show_login_button"))
                .shouldHave(text("LOGIN"))
                .shouldBe(visible);



    }

}
