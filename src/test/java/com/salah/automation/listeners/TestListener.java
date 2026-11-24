package com.salah.automation.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;

import org.openqa.selenium.WebDriver;

import com.salah.automation.Base.BaseTest;
import com.salah.automation.utils.ScreenshotUtils;
import com.salah.automation.utils.ExtentManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import java.nio.file.Paths;
import java.util.Arrays;

public class TestListener implements ITestListener {

    private ExtentReports extent =
        ExtentManager.getInstance();

    private ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {

        test = extent.createTest(
            result.getName() + " "
            + Arrays.toString(result.getParameters())
        );

        test.info("Test execution started");

        System.out.println(
            "STARTED: " + result.getName()
        );
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.pass("Test passed successfully");

        System.out.println(
            "PASSED: " + result.getName()
        );
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail(result.getThrowable());

        System.out.println(
            "FAILED: " + result.getName()
        );

        if (result.getInstance() instanceof BaseTest) {

            BaseTest baseTest =
                (BaseTest) result.getInstance();

            WebDriver driver = baseTest.getDriver();

            if (driver != null) {

                try {

                    String path =
                        ScreenshotUtils.captureScreenshot(
                            driver, result.getName()
                        );

                    String absolutePath =
                        Paths.get(path)
                            .toAbsolutePath()
                            .toString();

                    test.addScreenCaptureFromPath(
                        absolutePath
                    );

                    System.out.println(
                        "Screenshot saved: " + path
                    );

                } catch (Exception e) {

                    test.warning(
                        "Screenshot failed: "
                        + e.getMessage()
                    );
                }
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        ExtentTest skippedTest =
            extent.createTest(result.getName());

        skippedTest.skip("Test skipped");

        System.out.println(
            "SKIPPED: " + result.getName()
        );
    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();

        System.out.println("Extent Report Generated");
    }
}