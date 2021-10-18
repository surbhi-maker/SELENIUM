package PriceProtection;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Create_Price_Protection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://ordering-backoffice.qa.fleet.ad/login");
		//input[@name = 'username']
		//input[@name = 'lastname']
		driver.findElement(By.xpath("//input[@name = 'username']")).sendKeys("ordsupft11");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys("TestingQA@1234");
		driver.findElement(By.cssSelector("input.btn")).click();
		driver.manage().window().maximize();
		
		////div[@id ='side-menu']/ul/li[7]
		////div[@data-target = 'PPAQ']
		
		//add-new-btn
		
		//div[class = 'date-picker-container hasPicker']
		
		driver.findElement(By.xpath("//div[@id ='side-menu']/ul/li[7]")).click();
		driver.findElement(By.xpath("//div[@data-target = 'PPAQ']")).click();
		driver.findElement(By.id("add-new-btn")).click();
		
		WebElement corpCd = driver.findElement(By.id("corp-code"));
		Select dropdown = new Select(corpCd);
		dropdown.selectByIndex(2);
		
		////div[@id ='side-menu']/ul/li[7]
		//div[@class='tt-suggestion tt-selectable empty client-color']
		//search-client
		driver.findElement(By.id("search-client")).sendKeys("17595");
		driver.findElement(By.xpath("//div[@class='tt-suggestion tt-selectable empty client-color']")).click();
		//year 2022
		//make BMW
		//model  740
		//div[@class = 'multiselect-wrapper open']
		//Trim   //div[@class = 'multiselect-wrapper open']/ul/li[3]
		
		
		driver.findElement(By.id("year")).sendKeys("2022");
		driver.findElement(By.xpath("//*[@id=\"make\"]/option[6]")).click();
		driver.findElement(By.xpath("//*[@id= 'model']/option[2]")).click();
		
		Actions a = new Actions(driver);
		WebElement moveTotrim = driver.findElement(By.xpath("//*[@id=\"price-protection\"]/div[3]/div[7]/span/div/button"));
		a.moveToElement(moveTotrim).click();
		
//		WebElement we = driver.findElement(By.xpath("//div[@class= 'multiselect-wrapper open']/ul/li[3]"));
//		driver.findElement(By.xpath("//div[@class= 'multiselect-wrapper open']/ul/li[3]"));
		////*[@id="price-protection"]/div[3]/div[7]/span/div/ul/li[3]/a/label
		
		//*[@id="price-protection"]/div[3]/div[7]/span/div/button
		
		
	}

}
