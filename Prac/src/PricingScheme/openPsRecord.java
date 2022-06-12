package PricingScheme;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class openPsRecord {
	
	public static void main(String[] args) throws InterruptedException {
		////div[@id='queue-table']//div[@class='dataTables_scrollHeadInner']//th[not(contains(@class, 'sorting_disable'))]
		
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://ordering-backoffice.qa.fleet.ad/#businessTables/PS/1531");
		
		driver.findElement(By.xpath("//input[@name = 'username']")).sendKeys("Bill_QA_Su");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys("testqa12");
//		driver.findElement(By.cssSelector("input.btn")).click();
		
		driver.findElement(By.id("signinBtn")).click();
		driver.manage().window().maximize();
		
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("//table[@id='table-view50']//tbody//tr[1]//td[@data-name='corpCode']")).click();
		
		Thread.sleep(5000);
		System.out.println(driver.findElement(By.xpath("//div[@id='div-effectiveStartDate']//button[@data-toggle='datepicker']")).isEnabled());
		
		Thread.sleep(5000);
		System.out.println(driver.findElement(By.xpath("//span[@id='effectiveStartDate']")).getText());
		Thread.sleep(5000);
		System.out.println(driver.findElement(By.xpath("//input[@id='effectiveEndDate']")).getAttribute("value"));
		
//		driver.findElement(By.xpath("//div[@id ='side-menu']/ul/li[8]")).click();
//		driver.findElement(By.xpath("//div[@data-target = 'PS']")).click();
		
}
}