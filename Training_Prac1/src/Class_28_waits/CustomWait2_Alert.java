package Class_28_waits;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomWait2_Alert {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://seleniumpractise.blogspot.com/2019/01/alert-demo.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//button[text()='Try it'])[1]")).click();

		
		/*
		 * smart wait
		 * polling frequency 1 sec
		 * ignores  NoAlertPresentException
		 * customize thread.sleep
		 * 
		 */
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

		}
//		driver.quit();
	}
	
}
