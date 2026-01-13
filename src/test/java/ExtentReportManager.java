//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.Theme;
//import io.appium.java_client.android.AndroidDriver;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//public class ExtentReportManager {
//
//    private static ExtentReports extent;
//    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
//
//    /**
//     * Initialize Extent Report
//     */
//    public static void initReport() {
//        if (extent == null) {
//            String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
//            String reportPath = "test-reports/ExtentReport_" + timestamp + ".html";
//
//            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
//            spark.config().setDocumentTitle("Vidfo Automation Report");
//            spark.config().setReportName("Test Execution Report");
//            spark.config().setTheme(Theme.DARK);
//            spark.config().setTimeStampFormat("dd-MMM-yyyy HH:mm:ss");
//
//            extent = new ExtentReports();
//            extent.attachReporter(spark);
//            extent.setSystemInfo("Tester", "Hasnain");
//            extent.setSystemInfo("Platform", "Android");
//            extent.setSystemInfo("App", "Vidfo Video Player");
//            extent.setSystemInfo("Environment", "Test");
//
//            System.out.println("📊 Extent Report initialized: " + reportPath);
//        }
//    }
//
//    /**
//     * Create test
//     */
//    public static void createTest(String testName) {
//        ExtentTest extentTest = extent.createTest(testName);
//        test.set(extentTest);
//    }
//
//    /**
//     * Get current test
//     */
//    public static ExtentTest getTest() {
//        return test.get();
//    }
//
//    /**
//     * Log with screenshot
//     */
//    public static void logWithScreenshot(AndroidDriver driver, String message, Status status) {
//        try {
//            String base64 = ScreenshotHelper.takeScreenshotAsBase64(driver);
//            if (base64 != null) {
//                getTest().log(status, message)
//                        .addScreenCaptureFromBase64String(base64);
//            } else {
//                getTest().log(status, message);
//            }
//        } catch (Exception e) {
//            getTest().log(status, message + " (Screenshot failed)");
//        }
//    }
//
//    /**
//     * Log pass
//     */
//    public static void logPass(String message) {
//        getTest().log(Status.PASS, message);
//    }
//
//    /**
//     * Log fail with screenshot
//     */
//    public static void logFail(AndroidDriver driver, String message) {
//        logWithScreenshot(driver, message, Status.FAIL);
//    }
//
//    /**
//     * Log info
//     */
//    public static void logInfo(String message) {
//        getTest().log(Status.INFO, message);
//    }
//
//    /**
//     * Flush report
//     */
//    public static void flushReport() {
//        if (extent != null) {
//            extent.flush();
//            System.out.println("✓ Report generated successfully");
//        }
//    }
//}