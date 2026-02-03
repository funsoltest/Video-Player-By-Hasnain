package pages;

import base.Vidfo;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class OnboardingPage extends VidfoPage {

    private By nextBtn = By.id("vidfo.video.player.videoplayer:id/nextBtn");
    private By continueBtn = By.id("vidfo.video.player.videoplayer:id/continueBtn");
    private By onboardNext = By.id("vidfo.video.player.videoplayer:id/onBoardingNextBtn");

    public OnboardingPage(AndroidDriver driver) {
        super(driver);
    }

    public boolean isFirstLaunch() {
        return isDisplayed(nextBtn) || isDisplayed(continueBtn);
    }

    public void completeOnboarding() {

        if (isDisplayed(nextBtn)) {
            click(nextBtn);
        } else {
            click(continueBtn);
        }

        click(onboardNext);
        click(onboardNext);

        System.out.println("Onboarding completed");
    }
}
