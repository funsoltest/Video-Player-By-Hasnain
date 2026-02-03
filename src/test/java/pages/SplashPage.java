package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class SplashPage {

    private AndroidDriver driver;

    private By closeAdBtn = By.xpath("//android.widget.Button");

    public SplashPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void dismissSplashAd() {
        driver.findElement(closeAdBtn).click();
        System.out.println("Splash Ad Dismissed");
    }
}
