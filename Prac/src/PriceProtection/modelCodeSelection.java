package PriceProtection;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class modelCodeSelection {
	
	@Test
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://ordering-backoffice.qa.fleet.ad/login");
		
		driver.findElement(By.xpath("//input[@name = 'username']")).sendKeys("ordsupft11");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys("TestingQA@1234");
		driver.findElement(By.cssSelector("input.btn")).click();
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//div[@id ='side-menu']/ul/li[7]")).click();
		driver.findElement(By.xpath("//div[@data-target = 'PPAQ']")).click();
		
		driver.findElement(By.id("add-new-btn")).click();
		 System.out.println("drop down");
			WebElement corpCd = driver.findElement(By.id("corp-code"));
			Select dropdown = new Select(corpCd);
//			dropdown.selectByIndex(2);
			 System.out.println("drop down FA");
			dropdown.selectByVisibleText("FA");
			System.out.println("drop down FA selected");
		
		driver.findElement(By.xpath("//input[@id='search-client']")).sendKeys("175");
		Thread.sleep(2000);
		
		//  //div[@class='tt-dataset tt-dataset-search-client']//div[@class='tt-suggestion tt-selectable empty client-color']
		//OrderingBOQueuePage
		//enterDetailsOnCreateProjectPopup
		driver.findElements(By.xpath("//div[@class='tt-dataset tt-dataset-search-client']//div[@class='tt-suggestion tt-selectable empty client-color']")).get(0).click();
		
		
//		selectDataForPricingNotReleased();
		
		WebElement year = driver.findElement(By.id("year"));
		Select yearList = new Select(year);
		 System.out.println("drop down year 1");
//		 yearList.selectByVisibleText("2023");
		  yearList.selectByIndex(1);
		 System.out.println("drop down year selected:"  + yearList.getAllSelectedOptions());
		 
		 Thread.sleep(2000);
		 selectDataForPricingReleased(driver);
		
	}
	//MMT
	public static void selectDataForPricingReleased(WebDriver driver) throws InterruptedException {
		WebElement make = driver.findElement(By.id("make"));
		Select makeList = new Select(make);
		
		List<WebElement> dpdown = makeList.getOptions();
		dpdown.forEach(s->System.out.println("optins are +++++:" +s.getText()));
		 System.out.println("drop down make*********" );
//		 makeList.selectByVisibleText("Chevrolet");
//		 make.click();
		 makeList.selectByIndex(1);
		 System.out.println("drop down make selected********:"  + makeList.getAllSelectedOptions());
		 Thread.sleep(2000);
		 WebElement model = driver.findElement(By.id("model"));
			Select modelList = new Select(model);
//			 modelList.selectByVisibleText("3500 LCF Gas");
			modelList.selectByIndex(1);
			 System.out.println("drop down model");
			 System.out.println("drop down model selected:"  + makeList.getAllSelectedOptions());
			 
			 driver.findElement(By.xpath("//div[@class = 'price-protection__container__row modelCode']//button[@class = 'multiselect dropdown-toggle btn btn-default']")).click();
			  System.out.println("drop down mode code");
			 List<WebElement> modelCodeDropdown =
					 		driver.findElements(By.xpath("//div[@class = 'price-protection__container__row modelCode']//ul[@class = 'multiselect-container dropdown-menu']/li/a"));
			 Thread.sleep(2000);
			 System.out.println("drop down modelCode aa gya");
			 modelCodeDropdown.get(1).click();
			  Thread.sleep(2000);
			 driver.findElement(By.xpath("//div[@class = 'price-protection__container__row modelCode']//button[@class = 'multiselect dropdown-toggle btn btn-default']")).click();
			  Thread.sleep(2000);
			  Boolean trimgrayout = driver.findElement(By.xpath("//button[@class ='multiselect dropdown-toggle btn btn-default disabled']")).isEnabled();
			  Assert.assertFalse(trimgrayout);
			 System.out.println("trimgrayout done************************" + trimgrayout);
	}
}
