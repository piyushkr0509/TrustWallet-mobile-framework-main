package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverUtils {

    private static AppiumDriver driver;

   public static void initializeDriver() {
    DesiredCapabilities capabilities = new DesiredCapabilities();

    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator"); // Change if needed
    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13"); // Adjust per your device
    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

    // Instead of using an APK, launch the installed app by package/activity
    capabilities.setCapability("appPackage", "com.wallet.crypto.trustapp");
    capabilities.setCapability("appActivity", "com.wallet.crypto.trustapp.ui.app.AppActivity");

    // Optional: Don't reset app data every time
    capabilities.setCapability("noReset", false);

    try {
        driver = new AndroidDriver(new URL("http://127.0.0.1:4725/wd/hub"), capabilities);
    } catch (MalformedURLException e) {
        e.printStackTrace();
    }
}

    public static AppiumDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("Driver not initialized. Please call initializeDriver first.");
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
