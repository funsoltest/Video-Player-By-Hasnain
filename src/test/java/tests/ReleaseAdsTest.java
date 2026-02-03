package tests;

import base.Vidfo;
import base.Vidfo;
import listeners.ResultListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.OnboardingPage;
import pages.SplashPage;
import utils.AppStateUtils;

@Listeners(ResultListener.class)
public class ReleaseAdsTest extends Vidfo {

    @Test
    public void verifyReleaseAdsFlow() {

        System.out.println("=== Release Ads Test Started ===");

        SplashPage splash = new SplashPage(driver);
        OnboardingPage onboarding = new OnboardingPage(driver);
        HomePage home = new HomePage(driver);

        splash.dismissSplashAd();

        if (AppStateUtils.isFirstRun()) {
            onboarding.completeOnboarding();
        }

        if (home.isHomeDisplayed()) {
            System.out.println("User landed on Home");
            home.clickHomeAdIfExists();
        }

        home.pressBack();

        System.out.println("=== Release Ads Test Finished ===");
    }
}
