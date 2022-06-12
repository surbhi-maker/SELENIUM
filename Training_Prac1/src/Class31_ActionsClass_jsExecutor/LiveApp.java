package Class31_ActionsClass_jsExecutor;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class LiveApp {

	public static void main(String[] args) throws AWTException, IOException {
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\4thMay\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.flipkart.com");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5 , TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		
		driver.findElement(By.xpath("//input[contains(@title,'Search for products, brands and more')]")).sendKeys("readmi");
		
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
//		File src =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(src, new File("D:\\Users\\Surbhi.png"));
		/*
		WebElement eleScreenshot= driver.findElement(By.xpath("//div[@class='MIXNux']//img[@alt='REDMI 10 (Midnight Black, 64 GB)']"));
		File eleSs = eleScreenshot.getScreenshotAs(OutputType.FILE);
		
		String str = System.getProperty("user.dir")+"\\screenshots\\Selenium1.png";
		FileHandler.copy(eleSs, new File(str));
		*/
		driver.findElement(By.xpath("//div[contains(text(),'REDMI Note 11 Pro (Phantom White, 128 GB)')]")).click();
		
		Set<String> windows = driver.getWindowHandles();
		ArrayList<String> list = new ArrayList<String>();
		String parentid = driver.getWindowHandle();
		closeOtherWindow(list , parentid, driver);
	}
	
	private static void closeOtherWindow(ArrayList<String> list, String parentid, WebDriver driver) {
		
		
		for(String e : list) {
			if(!e.equals(parentid)) {
				driver.switchTo().window(e).close();
			}
		}
		
	}

}
