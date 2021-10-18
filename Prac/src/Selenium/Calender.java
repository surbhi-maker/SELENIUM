package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Calender {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		//Thread.sleep(2000L);
		driver.findElement(By.xpath("//a[@value ='MAA']")).click();
		System.out.println(driver.findElement(By.xpath("//a[@value ='MAA']")).getText());
		Thread.sleep(2000L);
		//driver.findElement(By.xpath("(//a[@value ='GOI'])[2]")).click(); OR
		// AVOID HARDCODED INDEX
		driver.findElement(By.xpath("//div[@id ='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value = 'GOI']")).click();
		
		System.out.println("For Round Trip");
		
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-hover")).click();
		
		System.out.println("selecting Round Trip");
		driver.findElement(By.id("Div1")).getAttribute("style");
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));

		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
			System.out.println("disabled");
		}else {
			System.out.println("enabled");
		}
			
	}

}
