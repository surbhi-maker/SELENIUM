package test;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Title {
	
	public static void main(String[] args) throws AWTException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://ordering-backoffice.qa.fleet.ad/#displayOrder/3005358");
		
		
		driver.findElement(By.xpath("//input[@name = 'username']")).sendKeys("ordsupft11");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys("TestingQA@1234");
		driver.findElement(By.id("signinBtn")).click();
		driver.manage().window().maximize();
		
		String s = driver.findElement(By.id("titleInfoTabId")).getText();
		
		System.out.println(s);
		//titleInfoTabId
		Thread.sleep(5000L);
		driver.findElement(By.id("titleInfoTabId")).click();
		Thread.sleep(5000L);
		driver.findElement(By.id("titleOwner1")).sendKeys("df");
		
		Thread.sleep(5000L);
		driver.findElement(By.id("regOwner1")).sendKeys("df");
		
		
		
		String title = driver.findElement(By.id("titleOwner1")).getText();
		System.out.println(title);
		
		String title1 = driver.findElement(By.id("regOwner1")).getText();
		System.out.println(title1);
		
		
		
		WebElement city = driver.findElement(By.name("titleAddress[contactAddress][city]:string"));
		
		String city1 = "mumbai";
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;  
		// set the text
		jsExecutor.executeScript("arguments[0].value='"+city1+"'", city); 
		System.out.println("city entered***************");
		
		
		WebElement state = driver.findElement(By.xpath("//select[@name='titleAddress[contactAddress][stateProvince]:string']"));
		Select select = new Select(state);
		
		select.selectByVisibleText("COLORADO");
		System.out.println("state selected 1");
		Thread.sleep(5000L);
		
		select.selectByValue("MD");
		Thread.sleep(5000L);
		
		System.out.println("state selected 2");
				
		select.selectByIndex(0);
		
		System.out.println("state selected 3");
		String stateSelected = driver.findElement(By.xpath("//select[@name='titleAddress[contactAddress][stateProvince]:string']")).getText();
	
		System.out.println("state selected " +stateSelected);
		
		Thread.sleep(5000L);
	}
}
//https://ordering-backoffice.qa.fleet.ad/#displayOrder/3005358