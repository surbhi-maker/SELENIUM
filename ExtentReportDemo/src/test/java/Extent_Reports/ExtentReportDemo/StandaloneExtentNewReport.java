package Extent_Reports.ExtentReportDemo;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


/*
 * https://www.seleniumeasy.com/selenium-tutorials/creating-extent-reports-in-selenium-example
 */
public class StandaloneExtentNewReport {
		
		ExtentSparkReporter extentSparkReporter;
	    ExtentReports extent;
	    //helps to generate the logs in test report.
	    ExtentTest test;
		
		@BeforeTest
		public void config() {
			//ExtentReport  and //ExtentSparkReport classes
			// directory where output is to be printed : D:\Users\SKourav\copy\ExtentReportDemo\reports\index.html
			System.out.println("path :" + System.getProperty("user.dir"));
			String path = System.getProperty("user.dir")+"\\reports\\index.html";
			System.out.println("final path :" + path);
			extentSparkReporter = new ExtentSparkReporter(path);
			extentSparkReporter.config().setDocumentTitle("Extent Report Demo SURBHI NOV");
			extentSparkReporter.config().setReportName("Surbhi's Test Report");
			
			extent = new ExtentReports();
			extent.attachReporter(extentSparkReporter);
		}
		
		@Test
		public void initialTest()
		{	
			test = extent.createTest("Initial Test");
			System.out.println("function for report details :initialTest");
			System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.amazon.com/");
			driver.manage().window().maximize();
			System.out.println("Title is:" + driver.getTitle());
			driver.close();
			test.fail("Test cases is failed due to following reason");
//			extent.flush();  @AfterTest
		}
		
		  @Test
		    public void testCase2() {
		        test = extent.createTest("Test Case 2", "PASSED test case");
		        Assert.assertTrue(true);
		    }
		    
		    @Test
		    public void testCase3() {
		        test = extent.createTest("Test Case 3", "PASSED test case");
		        Assert.assertTrue(true);
		    }
		     
		    @Test
		    public void testCase4() {
		        test = extent.createTest("Test Case 4", "Failed test case");
		        Assert.assertTrue(false);
		    }
		
		    @AfterTest
		    public void tearDown() {
		    	//to write or update test information to reporter
		        extent.flush();
		    }
}

