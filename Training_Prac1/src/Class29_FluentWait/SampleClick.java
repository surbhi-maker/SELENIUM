package Class29_FluentWait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SampleClick {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://login.yahoo.com/?.intl=us");
		
		System.out.println(driver.findElement(By.xpath("//input[@id='persistent']")).isEnabled());
		System.out.println(driver.findElement(By.xpath("//input[@id='persistent']")).getLocation().getX());
		System.out.println(driver.findElement(By.xpath("//input[@id='persistent']")).getLocation().getY());
				
//		WebDriverWait wait = new WebDriverWait(driver, 30);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='persistent']"))).click();

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Stay signed')]"))).click();

		
	}

}
