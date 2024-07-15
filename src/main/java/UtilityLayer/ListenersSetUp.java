package UtilityLayer;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import BaseLayer.BaseClass;

public class ListenersSetUp extends BaseClass implements ITestListener {
	private static ExtentReports extentReports;
	private static ExtentTest extentTest;

	@Override
	public void onStart(ITestContext context) {
		extentReports = ExtentReportSetUp.setUp(context.getSuite().getName());
	}

	@Override
	public void onTestStart(ITestResult result) {
		extentTest = extentReports.createTest("Test Case Name" + result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.PASS, "Test Case Pass Name is"+result.getMethod().getMethodName());	
	extentTest.addScreenCaptureFromPath(ScreenShot.takesScreenShot("PassScreenShot", result.getMethod().getMethodName()));
	
	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.log(Status.FAIL, "Test Case Fail Name is" + result.getMethod().getMethodName());
		extentTest.addScreenCaptureFromPath(ScreenShot.takesScreenShot("FailScreenShot", result.getMethod().getMethodName()));
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.log(Status.SKIP, "Test Case Skip Name is" + result.getMethod().getMethodName());
		extentTest.addScreenCaptureFromPath(ScreenShot.takesScreenShot("SkipScreenShot", result.getMethod().getMethodName()));
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReports.flush();
	}

}
