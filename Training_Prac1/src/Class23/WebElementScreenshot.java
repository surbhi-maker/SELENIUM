package Class23;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utilityPackage.Utility;

public class WebElementScreenshot {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.manage().window().maximize();
		
		WebElement ele = driver.findElement(By.xpath("//input[@id='txtUsername']"));
		Utility.takeScreenShotOfWebElement(driver, ele);
		
		WebElement ele1 = driver.findElement(By.xpath("//div[@id='divPassword']"));
		Utility.takeScreenShotOfWebElement(driver, ele1);
		
		/*
		File  src = driver.findElement(By.xpath("//input[@id='txtUsername']")).getScreenshotAs(OutputType.FILE);
		String ScreenshotPath = System.getProperty("user.dir") +"\\screenshots\\Selenium" + System.currentTimeMillis()+".png";
		
		System.out.println(ScreenshotPath);
		FileHandler.copy(src, new File(ScreenshotPath));
		*/
		Thread.sleep(3000L);
		driver.close();
	}

}
