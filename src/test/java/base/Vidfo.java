package base;


import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import utils.DriverUtils;

import java.net.URL;
import java.time.Duration;

public class Vidfo {

    protected AndroidDriver driver;
    protected Dimension dim;

    @BeforeClass
    public void setup() throws Exception {
        driver = DriverUtils.createDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        dim = driver.manage().window().getSize();
        System.out.println("✅ App Started");

    }

    public AndroidDriver getDriver() {
        return driver;
    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

