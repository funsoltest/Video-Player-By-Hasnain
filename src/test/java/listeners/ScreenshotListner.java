package listeners;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ScreenshotListner {

    public static String take(AndroidDriver driver, String name) throws IOException {

        String path = "screenshots/" + name + ".png";
        File src = driver
                .getScreenshotAs(OutputType.FILE);

        Files.copy(src.toPath(), new File(path).toPath());
        return path;
    }
}



