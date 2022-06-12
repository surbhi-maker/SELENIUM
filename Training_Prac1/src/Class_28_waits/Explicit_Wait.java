package Class_28_waits;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Explicit_Wait {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://seleniumpractise.blogspot.com/2019/01/alert-demo.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//button[text()='Try it'])[1]")).click();

		WebDriverWait wait = new WebDriverWait(driver, 20);
		Alert alt =wait.until(ExpectedConditions.alertIsPresent());
		System.out.println("Element found :" + alt.getText());
		alt.accept();
		
		
		//Example
//		wait.until(ExpectedConditions.num);
		/* returns
		waiting for surbhi : then return type is surbhi
		waiting for Alert : then return type is Alert
		waiting for Element : then return type is element
		waiting for boolean : then return type is boolean
		*/
		
		// WebDriverWait is the child of Fluent wait
		
		/*
		 * WebDriverWait Parent class of all waits
		 * Explicit wait: default polling frequency -> 500mili sec
		 * Not a global wait ..it applies to specific condition
		 * else time out exception
		 * 
		 * 
		 */
		
		/*
		for (int i = 0; i < 20; i++) {
			try {
				//Alert alt
				Alert alt =driver.switchTo().alert();
				System.out.println("Element found" + alt.getText());
				alt.accept();
				break;
			} catch (NoAlertPresentException e) {
				Thread.sleep(1000);
				System.err.println("Alert not found -trying Again count :"+i);
			}

		}*/
//		driver.quit();
	}
	
}
