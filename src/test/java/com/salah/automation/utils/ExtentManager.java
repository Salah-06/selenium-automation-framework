package com.salah.automation.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            ExtentSparkReporter reporter =
                new ExtentSparkReporter(
                    "reports/AutomationReport.html"
                );

            reporter.config().setReportName(
                "SauceDemo Automation Report"
            );

            reporter.config().setDocumentTitle(
                "QA Automation Results"
            );

            extent = new ExtentReports();

            extent.attachReporter(reporter);

            extent.setSystemInfo("Tester", "QA Engineer");
            extent.setSystemInfo("Browser", "Chrome");
            extent.setSystemInfo("Environment", "Test");
            extent.setSystemInfo("Framework", "Selenium + TestNG");
        }

        return extent;
    }
}