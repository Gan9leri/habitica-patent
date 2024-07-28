package tests.mobile;

import com.codeborne.selenide.Configuration;
import drivers.RealDeviceDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = null;
        Configuration.timeout = 30000;
        Configuration.browser = RealDeviceDriver.class.getName();
    }

    @BeforeEach
    void beforeEach() {
        open();
    }

    @AfterEach
    void afterEach() {
        closeWebDriver();
    }
}
