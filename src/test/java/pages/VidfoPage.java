package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import utils.WaitUtils;

public class VidfoPage {

    protected AndroidDriver driver;

    public VidfoPage(AndroidDriver driver) {
        this.driver = driver;
    }

    protected void click(By locator) {
        WaitUtils.waitAndClick(driver, locator, 10);
    }

    protected boolean isDisplayed(By locator) {
        return !driver.findElements(locator).isEmpty();
    }
}
