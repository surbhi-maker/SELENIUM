package Xpath;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver_launch {

			public void openbrowser() {
			System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://opensource-demo.orangehrmlive.com");	
			driver.findElement(By.id("txtUsername")).sendKeys("Admin");		
			driver.findElement(By.id("txtPassword")).sendKeys("admin123");	
			driver.findElement(By.cssSelector("input.button")).click();
			}
			
}
