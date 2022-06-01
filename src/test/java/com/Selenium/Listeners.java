package com.Selenium;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utilities.Extentreport;

public class Listeners extends base implements ITestListener
{
	ExtentReports extent = Extentreport.getreport();;
	public ExtentTest	test;
	ThreadLocal<ExtentTest> extenttest  = new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	
		
	test = extent.createTest(result.getMethod().getMethodName());
	
	extenttest.set(test);
		//ITestListener.super.onTestStart(result);
	}

	
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		extenttest.get().log(Status.PASS, "Test Passed");
		
		//ITestListener.super.onTestSuccess(result);
	}

	
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		extenttest.get().fail(result.getThrowable());
		WebDriver driver = null;
		String testcasename = result.getMethod().getMethodName();
		
		try {
			
		driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		}
		catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		
		try {
			String screenshotpath = getScreenShotOnFail(testcasename,driver);
			
			extenttest.get().addScreenCaptureFromPath(screenshotpath, testcasename);
			
		
		} 
		
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//ITestListener.super.onTestFailure(result);
	}

	
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}


	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		extent.flush();
		
		//ITestListener.super.onFinish(context);
	}
	
	

}
