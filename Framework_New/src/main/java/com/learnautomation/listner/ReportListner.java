package com.learnautomation.listner;

import java.lang.reflect.Field;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.learnautomation.base.BaseClass;

@Test
public class ReportListner implements  ITestListener  {

	static ExtentReports extent = ExtentManager.createInstance();
	
	ThreadLocal<ExtentTest> parentTest = new ThreadLocal<>();
	
	 @Override
		public void onStart(ITestContext context) {
			System.out.println("test execution begin" + context.getName());
			
		}
	 
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		WebDriver driver=null;
		
//		WebDriver driver= BaseClass.driver;  //for single test class
		try {
			Field driverField = result.getTestClass().getRealClass().getDeclaredField("driver");
			Object obj = driverField.get(result.getInstance());
			driver = (WebDriver)obj;
		}
		catch(Exception e) {
			System.out.println();
		}
		
		TakesScreenshot ts =(TakesScreenshot)driver;
		parentTest.get().fail("test Failed " + result.getThrowable().getMessage() ,MediaEntityBuilder.createScreenCaptureFromBase64String(ts.getScreenshotAs(OutputType.BASE64)).build());
		System.out.println("test Failed" );
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		parentTest.get().skip("test skip" + result.getThrowable().getMessage());
		System.out.println("test Skippped" );
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("LOg:Info : creating new test object");
		ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
		parentTest.set(extentTest);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("test success");
		parentTest.get().pass("test pass");
	}

	@Override
	public void onFinish(ITestContext context) {
		
		System.out.println("report getting ready");
		extent.flush();
		System.out.println("report generated");
		
	}

}
