package PriceProtection;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PriceAndConfig {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://ordering-backoffice-uat.qa.fleet.ad/#vehicleConfig/priceAndConfig/search");
		
		driver.findElement(By.xpath("//input[@name = 'username']")).sendKeys("ordsupft11");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys("TestingQA@1234");
		driver.findElement(By.id("signinBtn")).click();
		driver.manage().window().maximize();
		
		driver.findElement(By.id("clientNumber-input")).clear();
		
		driver.findElement(By.id("businessAccessKey-input")).sendKeys("P081241");
		Thread.sleep(2000L);
		driver.findElement(By.id("search-by-filters-btn")).click();
		Thread.sleep(2000L);
		driver.findElement(By.xpath("//tr[@class='data-table__row odd'][1]")).click();
		
//		WebElement web = ((WebDriver) driver.findElement(By.xpath("//img[@class='price-protected-img'][1]"))).get(0);

		System.out.println(driver.findElement(By.xpath("//img[@class='price-protected-img'][1]")));
		System.out.println(driver.findElement(By.xpath("//img[@class='price-protected-img'][1]")).getSize());
	
}
}