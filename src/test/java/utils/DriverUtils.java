package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.URL;
import java.time.Duration;

public class DriverUtils {

    public static AndroidDriver createDriver() throws Exception {

        UiAutomator2Options options = new UiAutomator2Options()
                .setDeviceName("AndroidDevice")
                .setAutomationName("UiAutomator2")
                .setApp("C:\\APK\\AntivirusPro.apk")
                .setNoReset(false);

        AndroidDriver driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723/"), options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }
}
