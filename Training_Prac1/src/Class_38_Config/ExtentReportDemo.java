package Class_38_Config;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportDemo {
	
	@Test
	public void createReport() {
		ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/AutomationReport.html");
		
		reporter.config().setReportName("Sprint Report");
		reporter.config().setDocumentTitle("AutomationReport");
		reporter.config().setTheme(Theme.DARK);
		
		ExtentReports report = new ExtentReports();
		report.attachReporter(reporter);
		
		ExtentTest test1 = report.createTest("MyFirstTest");
		
		test1.pass("login pass");
		
		ExtentTest test2 = report.createTest("MyPayMent");
		
		test2.fail("MyPayMent pass");
		
		ExtentTest test3 = report.createTest("LogoutDone");
		
		test3.pass("Logout done");
		
		
		report.flush();
	}
	

}
