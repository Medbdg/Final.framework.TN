package com.qa.listeners;


import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class MyListeners implements ITestListener  {
	public ExtentReports extentReport;
	public ExtentTest extentTest;
	
	@Override
	public void onStart(ITestContext context) {
		try {
			extentReport = com.tn.utili.MyExtentReporter.generateExtentReport();
		} catch (Exception e) {
			e.printStackTrace();
		}}

	@Override
	public void onTestStart(ITestResult result) {
	String testName = result.getName();
	extentTest = extentReport.createTest(testName);
	extentTest.log(Status.INFO, testName + "started executing");
	}

	@Override
	public void onTestSuccess(ITestResult result) {	
	String testName = result.getName();
	extentTest = extentReport.createTest(testName);
	extentTest.log(Status.PASS, testName + "successfully executed");
	}

	@Override
	public void onTestFailure(ITestResult result) {	
	String testName = result.getName(); 
	WebDriver driver = null;
	try {
		driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
	} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
		e.printStackTrace();
	}
	File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String destination = System.getProperty("user.dir")+ "\\test-output\\Screenshots\\" + testName + ".png";
	try {
		FileHandler.copy(source, new File(destination));
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	extentTest.addScreenCaptureFromPath(destination);
	extentTest.log(Status.INFO, result.getThrowable());
	extentTest.log(Status.FAIL, testName + "failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {	
	String testName = result.getName();	
	extentTest.log(Status.INFO, result.getThrowable());
	extentTest.log(Status.SKIP, testName + "skipped");
	}

	@Override
	public void onFinish(ITestContext context) {
	System.out.println("Execution of TN project is finished");
	 extentReport.flush();
	}
	
	public void onTestFailedButWhitinSuccessPercentage(ITestResult result) {
	String testName = result.getName();
	System.out.println(testName + " with this much percentage ");
	System.out.println(result.getThrowable());
	}
	

}
