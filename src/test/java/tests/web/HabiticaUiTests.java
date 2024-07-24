package tests.web;

import extensions.WithLogin;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.Selenide.open;

@Tag("ui")
public class HabiticaUiTests extends TestBase {

    @Test
    @WithLogin
    void profileTest(){
        open("");
    }

}
