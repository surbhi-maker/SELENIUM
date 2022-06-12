package Class_39_ExtentReport_Listener;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
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
		
//		test2.log(Status.FAIL, "Login auth fail");
		
//		test2.fail("MyPayMent pass");
		test2.fail("login auth failed", MediaEntityBuilder.createScreenCaptureFromPath("D:\\Users\\SKourav\\OneDrive - Element Financial Corp\\Desktop\\2021-10-22 19_38_58-capping_rule_issue.png").build());
		
		ExtentTest test3 = report.createTest("LogoutDone");
		
		test3.pass("Logout done");
		
		
		report.flush();
	}
	

}
