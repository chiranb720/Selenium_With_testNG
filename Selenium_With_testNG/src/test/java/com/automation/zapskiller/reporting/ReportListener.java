package com.automation.zapskiller.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static com.automation.zapskiller.config.Hooks.configProps;

public class ReportListener implements ITestListener {

    public static ExtentReports extentReports = new ExtentReports();
    public static ExtentSparkReporter reporter;
    public static ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test = extentReports.createTest(result.getMethod().getMethodName()+" started");

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test Method "+result.getMethod().getMethodName()+" Succeeded");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "Test Method "+result.getMethod().getMethodName()+" Failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "Test Method "+result.getMethod().getMethodName()+" Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
        reporter = new ExtentSparkReporter(configProps.getProperty("reporting.location"));
        extentReports.attachReporter(reporter);
        reporter.config(ExtentSparkReporterConfig.builder()
                .documentTitle(configProps.getProperty("report.title"))
                .theme(Theme.DARK)
                .reportName(configProps.getProperty("report.name")).build());
    }

    @Override
    public void onFinish(ITestContext context) {
        test.log(Status.INFO, "Test Suite "+context.getSuite().getName()+" Completed");
        extentReports.flush();
    }
}
