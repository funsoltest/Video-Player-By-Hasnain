package tests;

import base.Vidfo;
import base.Vidfo;
import listeners.ResultListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.SplashPage;
import pages.OnboardingPage;
import utils.AppStateUtils;

@Listeners(ResultListener.class)
public class DebugAdsTest extends Vidfo {

    @Test
    public void splashToHome() {

        SplashPage splash = new SplashPage(driver);
        OnboardingPage onboarding = new OnboardingPage(driver);

        splash.dismissSplashAd();
        if (AppStateUtils.isFirstRun()) {
            onboarding.completeOnboarding();
        }

        if (onboarding.isFirstLaunch()) {
            onboarding.completeOnboarding();
        }

        System.out.println("User landed on Home");
    }
}
