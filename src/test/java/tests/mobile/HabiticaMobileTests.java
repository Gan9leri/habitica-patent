package tests.mobile;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.appium.java_client.AppiumBy.id;

@Tag("mobile")
public class HabiticaMobileTests extends TestBase{

    @Test
    void test(){
        open();
        $(id("com.habitrpg.android.habitica:id/new_game_button")).click();


    }

}
