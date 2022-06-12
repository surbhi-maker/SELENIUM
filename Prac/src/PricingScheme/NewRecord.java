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

public class NewRecord {
	
	public static void main(String[] args) throws InterruptedException {
		////div[@id='queue-table']//div[@class='dataTables_scrollHeadInner']//th[not(contains(@class, 'sorting_disable'))]
		
		System.setProperty("webdriver.chrome.driver","D:\\Users\\SKourav\\\\new_driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://ordering-backoffice.qa.fleet.ad/login");
		
		driver.findElement(By.xpath("//input[@name = 'username']")).sendKeys("AtestSupr");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys("TestingQA@1234");
		driver.findElement(By.cssSelector("input.btn")).click();
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//div[@id ='side-menu']/ul/li[8]")).click();
		driver.findElement(By.xpath("//div[@data-target = 'PS']")).click();
		/*
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("add-new-button"))));
		driver.findElement(By.id("add-new-button")).click();
		
		WebElement corpCd = driver.findElement(By.id("corpCode"));
		Select dropdown = new Select(corpCd);
		dropdown.selectByVisibleText("CA");
		System.out.println("drop down CA selected");
		
//		Thread.sleep(5000);
//		new WebDriverWait(driver, 20).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//select[@id='year']")))));
		
		new WebDriverWait(driver, 5000).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//select[@id='year']")))));
		
		
		//.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//select[@id='year']"))));
		
//		driver.findElement(By.xpath("//select[@id='year']")).click();
		
		WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
		Select yeardw = new Select(year);
	
		yeardw.selectByVisibleText("2022");
		System.out.println("2022 selected");
		
		Thread.sleep(5000);
		new WebDriverWait(driver, 5000).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("manufacturer")))));
		WebElement manufacturer = driver.findElement(By.id("manufacturer"));
		Select manufacturerDW = new Select(manufacturer);
		
		manufacturerDW.selectByVisibleText("Chrysler");
		System.out.println("Chrysler selected");
		
		
//		Thread.sleep(5000);
		new WebDriverWait(driver, 5000).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("year"))));
		WebElement make = driver.findElement(By.id("make"));
		Select makeDW = new Select(make);
		
		makeDW.selectByVisibleText("Chrysler");
		System.out.println("make Chrysler selected");
		*/
		
		
		String record = driver.findElement(By.xpath("//div[@class='dataTables_info']")).getAttribute("innerHTML");
		System.out.println("record: "+record.replaceAll(" .*", ""));
	}
}
