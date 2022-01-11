package Class23;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utilityPackage.Utility;

public class CaptureDateTime {

	public static void main(String[] args) throws IOException {
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.manage().window().maximize();
		
		WebElement ele = driver.findElement(By.xpath("//input[@id='txtUsername']"));
		Utility.takeScreenShotOfWebElement(driver, ele);

		/*
		Date todaysDate = new Date();
		System.out.println(todaysDate);
		SimpleDateFormat newFormat = new SimpleDateFormat("dd_mm_yyyy_HH_mm_ss");
		System.out.println(newFormat.format(todaysDate));
		
		*/
		
	}

}
