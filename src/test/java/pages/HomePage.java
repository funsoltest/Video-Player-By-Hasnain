package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class HomePage extends VidfoPage {

    private By homeRoot =
            By.id("vidfo.video.player.videoplayer:id/homeRoot");

    private By homeInterstitialAd =
            By.id("vidfo.video.player.videoplayer:id/homeAd");

    private By backBtn =
            By.xpath("//android.widget.ImageButton");

    public HomePage(AndroidDriver driver) {
        super(driver);
    }

    public boolean isHomeDisplayed() {
        return isDisplayed(homeRoot);
    }

    public void clickHomeAdIfExists() {
        if (isDisplayed(homeInterstitialAd)) {
            click(homeInterstitialAd);
            System.out.println("Home Interstitial Ad Clicked");
        } else {
            System.out.println("No Home Ad Found");
        }
    }

    public void pressBack() {
        driver.navigate().back();
    }
}

