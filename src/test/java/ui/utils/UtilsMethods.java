package ui.utils;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.currentFrameUrl;

public class UtilsMethods {

    public void checkUrl(String value) {
        webdriver().shouldHave(currentFrameUrl(value));
    }

}
