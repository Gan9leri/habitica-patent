package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.EmulationConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static io.appium.java_client.remote.MobilePlatform.ANDROID;
import static org.apache.commons.io.FileUtils.copyInputStreamToFile;


public class EmulationDriver implements WebDriverProvider {
    static EmulationConfig emulationConfig = ConfigFactory.create(EmulationConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();

        options.setAutomationName(ANDROID_UIAUTOMATOR2)
                .setPlatformName(ANDROID)
                .setPlatformVersion(emulationConfig.mobilePlatform())
                .setDeviceName(emulationConfig.deviceName())
                .setApp(getAppPath())
                .setAppPackage("com.habitrpg.android.habitica")
                .setAppActivity("com.habitrpg.android.habitica.ui.activities.MainActivity");

        return new AndroidDriver(getAppiumServerUrl(), options);
    }

    public static URL getAppiumServerUrl() {
        try {
            return new URL(emulationConfig.mobileUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private String getAppPath() {
        String appUrl = "https://github.com/HabitRPG/habitica-android/releases/download/4.0.2/Habitica-2209014510-prod-release.apk";
        String appPath = "src/test/resources/apps/Habitica-2209014510-prod-release.apk";

        File app = new File(appPath);
        if (!app.exists()) {
            try (InputStream in = new URL(appUrl).openStream()) {
                copyInputStreamToFile(in, app);
            } catch (IOException e) {
                throw new AssertionError("Failed to download application", e);
            }
        }
        return app.getAbsolutePath();
    }
}
