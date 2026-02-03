package pages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class PermissionPage {

    private AndroidDriver driver;
    private TouchAction action;

    public PermissionPage(AndroidDriver driver) {
        this.driver = driver;
        this.action = new TouchAction(driver);
    }

    public void allowPermission() {
        action.tap(PointOption.point(550, 1950)).perform();
    }

    public void denyPermission() {
        action.tap(PointOption.point(510, 2111)).perform();
    }
}

