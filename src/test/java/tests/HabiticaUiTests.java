package tests;

import extensions.WithLogin;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class HabiticaUiTests extends TestBase {

    @Test
    @WithLogin
    void profileTest(){
        open("");
    }

}
