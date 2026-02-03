package listeners;

import base.Vidfo;
import com.aventstack.extentreports.*;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ExtentManager;

import java.io.IOException;

public class ResultListener implements ITestListener {

    private static ExtentReports report = ExtentManager.getReport();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        test.set(report.createTest(result.getName()));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.get().fail(result.getThrowable());

        Object obj = result.getInstance();
        if (obj instanceof Vidfo) {
            Vidfo base = (Vidfo) obj;

            String path = null;
            try {
                path = ScreenshotListner.take(
                        base.getDriver(),
                        result.getName()
                );
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            test.get().addScreenCaptureFromPath(path);
        }
    }

    @Override
    public void onFinish(org.testng.ITestContext context) {
        report.flush();
    }
}
