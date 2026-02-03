package utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class WaitUtils {

    public static void waitForVisible(AndroidDriver driver, By locator, int sec) {
        new WebDriverWait(driver, Duration.ofSeconds(sec))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static boolean waitAndClick(AndroidDriver driver, By locator, int sec) {
        try {
            waitForVisible(driver, locator, sec);
            driver.findElement(locator).click();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
