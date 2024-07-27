package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.RealDeviceConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static io.appium.java_client.remote.MobilePlatform.ANDROID;
import static org.apache.commons.io.FileUtils.copyInputStreamToFile;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class RealDeviceDriver implements WebDriverProvider {

    static RealDeviceConfig realDeviceConfig = ConfigFactory.create(RealDeviceConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();

        options.setAutomationName(ANDROID_UIAUTOMATOR2)
                .setPlatformName(ANDROID)
                .setDeviceName(realDeviceConfig.deviceName())
                .setApp(getAppPath())
                .setAppPackage("com.habitrpg.android.habitica")
                .setAppActivity("com.habitrpg.android.habitica.ui.activities.MainActivity");

        return new AndroidDriver(getAppiumServerUrl(), options);
    }

    public static URL getAppiumServerUrl() {
        try {
            return new URL(realDeviceConfig.mobileUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private String getAppPath() {
        //String appVersion = "app-alpha-universal-release.apk";
        String appUrl = "https://github.com/HabitRPG/habitica-android/releases/download/4.0.2/Habitica-2209014510-prod-release.apk";//+ appVersion;
        String appPath = "src/test/resources/apps/Habitica-2209014510-prod-release.apk";// + appVersion;

        File app = new File(appPath);
        if (!app.exists()) {
            try (InputStream in = new URL(appUrl).openStream()) {
                copyInputStreamToFile(in, app);
            } catch (IOException e) {
                throw new AssertionError("Failed to download application", e);
            }
        }
        System.out.println(app.getAbsolutePath());
        return app.getAbsolutePath();
    }

}
