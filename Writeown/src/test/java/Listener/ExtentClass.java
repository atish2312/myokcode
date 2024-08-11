package Listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import testbase.BaseClass;

public class ExtentClass implements ITestListener {
    private static ExtentReports reports;
    private ExtentTest test;
    private WebDriver driver;

    static {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("C:\\Users\\kumar\\Desktop\\mypull code\\ExtentReports\\Spark.html");
        reports = new ExtentReports();
        reports.attachReporter(sparkReporter);
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test Suite started: " + context.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = reports.createTest(result.getMethod().getMethodName());
        test.log(Status.INFO, "Test started: " + result.getMethod().getMethodName());

       //  Retrieve WebDriver instance from the test class
        Object currentClass = result.getInstance();
        driver = ((BaseClass) currentClass).driver;
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "Test failed: " + result.getMethod().getMethodName());
        test.log(Status.FAIL, "Failure reason: " + result.getThrowable());

        try {
            // Capture screenshot as Base64
            String screenshotBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
            test.addScreenCaptureFromBase64String(screenshotBase64, "Screenshot on failure");
            System.out.println("Screenshot added to report.");
        } catch (Exception e) {
            test.log(Status.WARNING, "Failed to capture screenshot: " + e.getMessage());
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "Test skipped: " + result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        reports.flush();  // Ensure the report is written out
        System.out.println("Test suite finished: " + context.getName());
    }
}
