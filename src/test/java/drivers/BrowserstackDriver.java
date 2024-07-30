package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.browserstackAuth;
import config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {

        MutableCapabilities caps = new MutableCapabilities();
        browserstackAuth authConfig =
                ConfigFactory.create(browserstackAuth.class, System.getProperties());
        BrowserstackConfig hostConfig =
                ConfigFactory.create(BrowserstackConfig.class, System.getProperties());

        caps.setCapability("browserstack.user", authConfig.mobileUser());
        caps.setCapability("browserstack.key", authConfig.mobilePass());
        caps.setCapability("app", hostConfig.mobileApp());
        caps.setCapability("device", hostConfig.deviceName());
        caps.setCapability("os_version", hostConfig.mobilePlatform());
        caps.setCapability("project", hostConfig.mobileProject());
        caps.setCapability("build", hostConfig.mobileBuild());
        caps.setCapability("name", hostConfig.mobileName());
        caps.setCapability("url", hostConfig.remoteUrl());
        //caps.setCapability("language", hostConfig.mobileLanguage());
        //caps.setCapability("locale", hostConfig.mobileLocale());

        try {
            return new RemoteWebDriver(
                    new URL(hostConfig.remoteUrl()), caps);
        } catch (
                MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

}
