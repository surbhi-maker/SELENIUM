package Class_28_waits;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomWait {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://seleniumpractise.blogspot.com/search?q=timer");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@onclick ='timedText()']")).click();

		
		
		/*
		 * smart wait
		 * polling frequency 1 sec
		 * ignores  NoSuchElementException
		 * customize thread.sleep
		 * 
		 */
		for (int i = 0; i < 20; i++) {
			try {
				driver.findElement(By.xpath("//p[text()='WebDriver']"));
				System.out.println("Element found");
				break;
			} catch (NoSuchElementException e) {
				Thread.sleep(1000);
				System.err.println("Element not found-trying Again");
			}

		}
		driver.quit();
	}
	
}
