package Class_39_ExtentReport_Listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

@Test
public class ReportListner implements  ITestListener  {

	 @Override
		public synchronized void onStart(ITestContext context) {
			System.out.println("test execution begin" + context.getName());
		}
	 
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("test Failed" +result.getMethod().getMethodName() +" Exception trrown "+ result.getThrowable().getMessage());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("test Skippped" +result.getMethod().getMethodName() +" Exception trrown "+ result.getThrowable().getMessage());
	}

	@Override
	public void onTestStart(ITestResult context) {
		System.out.println("test Started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("test success" +result.getMethod().getMethodName());
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("test Finished " + context.getName());
		
	}

}
