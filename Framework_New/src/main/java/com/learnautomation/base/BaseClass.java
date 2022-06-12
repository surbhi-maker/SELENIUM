package com.learnautomation.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.learnautomation.dataprovider.ConfigUtility;

public class BaseClass {
	
	public WebDriver driver;
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	@BeforeClass
	public void setUP() {
		 System.out.println("Log:INFO - Browser getting ready");
		 System.out.println("Thread information "+ Thread.currentThread().getId());
		 
		 System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(ConfigUtility.getProperty("url"));
			System.out.println("Log:INFO - browser Started : @BeforeMethod /****************");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		System.out.println("Log:INFO - browser closed: @AfterMethod*****************/");
	}
	
}
