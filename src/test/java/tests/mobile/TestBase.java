package tests.mobile;

import com.codeborne.selenide.Configuration;
import drivers.BrowserstackDriver;
import drivers.EmulationDriver;
import drivers.RealDeviceDriver;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = null;
        Configuration.timeout = 30000;
        //Configuration.browser = BrowserstackDriver.class.getName();
        Configuration.browser = RealDeviceDriver.class.getName();
        if ("browserstack".equals(System.getProperty("deviceHost"))) {
            Configuration.browser = BrowserstackDriver.class.getName();
        }
        else if ("real".equals(System.getProperty("deviceHost"))){
            Configuration.browser = RealDeviceDriver.class.getName();
        }
        else if ("emulation".equals(System.getProperty("deviceHost"))){
            Configuration.browser = EmulationDriver.class.getName();
        }
    }

    @BeforeEach
    void beforeEach() {
        open();
    }
}