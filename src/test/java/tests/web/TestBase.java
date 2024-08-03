package tests.web;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.WebConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.Map;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    @BeforeAll
    public static void beforeAll(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebConfig webConfig = ConfigFactory.create(WebConfig.class, System.getProperties());
        Configuration.baseUrl = webConfig.baseUrl();
        Configuration.browser = webConfig.browser();
        Configuration.browserSize = webConfig.browserSize();
        Configuration.browserVersion = webConfig.browserVersion();
        RestAssured.baseURI = webConfig.baseURI();
        RestAssured.basePath = webConfig.basePath();
        Configuration.pageLoadStrategy = "eager";
        if(System.getProperty("host", "selenoid").equals("selenoid")) {
            Configuration.remote = webConfig.remoteUrl();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
            Configuration.browserCapabilities = capabilities;
        }

        //Configuration.holdBrowserOpen = true;

    }

    @AfterEach
        void afterEach() {
       /* Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();*/
        closeWebDriver();
    }
}
