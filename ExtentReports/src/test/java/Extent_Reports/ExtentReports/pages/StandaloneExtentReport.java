package Extent_Reports.ExtentReports.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class StandaloneExtentReport {
		
		ExtentHtmlReporter htmlReporter;
	    ExtentReports extent;
	    //helps to generate the logs in test report.
	    ExtentTest test;
	    //D:\Users\SKourav\copy\ExtentReports\test-output\index.html
		
		@BeforeTest
		public void config() {
			//ExtentReport
			//ExtentSparkReport
			// directory where output is to be printed
			//D:\Users\SKourav\copy\ExtentReports\test-output\index.html
			System.out.println("path :" + System.getProperty("user.dir"));
			String path = System.getProperty("user.dir")+"\\test-output\\index.html";
			System.out.println("final path :" + path);
			htmlReporter = new ExtentHtmlReporter(path);
			htmlReporter.config().setDocumentTitle("Extent Report Demo NOV");
			htmlReporter.config().setReportName("Surbhi Test Report");
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
			
		}
		
		@Test
		public void initialTest()
		{	
			extent.createTest("Initial Test");
			System.out.println("function for report details :initialTest");
			System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.amazon.com/");
			driver.manage().window().maximize();
			System.out.println("Title is:" + driver.getTitle());
			driver.close();
//			extent.flush();
			
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
		        test = extent.createTest("Test Case 4", "PASSED test case");
		        Assert.assertTrue(true);
		    }
		
		    @AfterTest
		    public void tearDown() {
		    	//to write or update test information to reporter
		        extent.flush();
		    }
}

