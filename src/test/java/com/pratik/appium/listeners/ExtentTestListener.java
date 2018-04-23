package com.pratik.appium.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.pratik.appium.factory.Driver;
import com.pratik.appium.logger.LogUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentTestListener implements ITestListener {

    private static ExtentReports extent = ExtentManager.getInstance();
    private static ExtentTest parent;

    @Override
    public void onTestStart(ITestResult result) {
        parent = extent.createTest(result.getMethod().getMethodName());
        parent.createNode(result.getMethod().getMethodName());
        LogUtils.INFO("***** STARTING TEST" + result.getMethod().getMethodName());
    }


    @Override
    public void onTestSuccess(ITestResult result) {
        parent.pass("Test passed");
        LogUtils.INFO("TEST PASSED ->" + result.getMethod().getMethodName());

    }

    @Override
    public void onTestFailure(ITestResult result) {
        LogUtils.ERROR("**** TEST FAILED ->" + result.getMethod().getMethodName());
        parent.fail(result.getMethod().getMethodName() + " FAILED");
        parent.fail(result.getThrowable());
        try {
            String path = Driver.getScreenShot();
            parent.addScreenCaptureFromPath(path);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
