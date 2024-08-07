package mobile.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import mobile.drivers.BrowserstackDriver;
import mobile.drivers.EmulationDriver;
import mobile.drivers.RealDeviceDriver;
import common.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.browserSize = null;
        Configuration.browser = BrowserstackDriver.class.getName();
        if ("browserstack".equals(System.getProperty("deviceHost", "browserstack"))) {
            Configuration.browser = BrowserstackDriver.class.getName();
        } else if ("real".equals(System.getProperty("deviceHost", "browserstack"))) {
            Configuration.browser = RealDeviceDriver.class.getName();
        } else if ("emulation".equals(System.getProperty("deviceHost", "browserstack"))) {
            Configuration.browser = EmulationDriver.class.getName();
        }
    }

    @BeforeEach
    void beforeEach() {
        open();
    }

    @AfterEach
    void afterEach() {
        Attach.pageSource();
        if ("browserstack".equals(System.getProperty("deviceHost", "browserstack"))) {
            Attach.addVideo(sessionId().toString());
        }
        closeWebDriver();
    }
}