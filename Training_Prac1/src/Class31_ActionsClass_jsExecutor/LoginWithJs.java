package Class31_ActionsClass_jsExecutor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utilityPackage.Utility;

public class LoginWithJs {
	
public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		Utility.enterText(By.id("txtUsername"), driver, "Admin");
		Utility.enterText(By.id("txtPassword"), driver, "admin123");
		
		Utility.jsClick(By.id("btnLogin"), driver);
		
	}
}
