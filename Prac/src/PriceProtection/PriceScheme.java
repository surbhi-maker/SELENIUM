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

public class PriceScheme {

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
//				dropdown.selectByIndex(2);
				 System.out.println("drop down FA");
				dropdown.selectByVisibleText("FA");
				System.out.println("drop down FA selected");
			
			driver.findElement(By.xpath("//input[@id='search-client']")).sendKeys("175");
			Thread.sleep(2000);
			
			//  //div[@class='tt-dataset tt-dataset-search-client']//div[@class='tt-suggestion tt-selectable empty client-color']
			//OrderingBOQueuePage
			//enterDetailsOnCreateProjectPopup
			driver.findElements(By.xpath("//div[@class='tt-dataset tt-dataset-search-client']//div[@class='tt-suggestion tt-selectable empty client-color']")).get(0).click();
			
			
//			selectDataForPricingNotReleased();
			
			WebElement year = driver.findElement(By.id("year"));
			Select yearList = new Select(year);
			 System.out.println("drop down year 1");
//			 yearList.selectByVisibleText("2023");
			  yearList.selectByIndex(1);
			 System.out.println("drop down year selected:"  + yearList.getAllSelectedOptions());
			 
			 Thread.sleep(2000);
			 selectDataForPricingReleased(driver);
			
		}
		//MMT
		public static void selectDataForPricingReleased(WebDriver driver) throws InterruptedException {
			WebElement make = driver.findElement(By.id("make"));
			Select makeList = new Select(make);
			 System.out.println("drop down make");
//			 makeList.selectByVisibleText("Chevrolet");
//			 make.click();
			 makeList.selectByIndex(1);
			 System.out.println("drop down make selected:"  + makeList.getAllSelectedOptions());
			 Thread.sleep(2000);
			 WebElement model = driver.findElement(By.id("model"));
				Select modelList = new Select(model);
//				 modelList.selectByVisibleText("3500 LCF Gas");
				modelList.selectByIndex(1);
				 System.out.println("drop down model");
				 System.out.println("drop down model selected:"  + makeList.getAllSelectedOptions());
				 
				 driver.findElement(By.xpath("//div[@class = 'price-protection__container__row trim']//button[@class = 'multiselect dropdown-toggle btn btn-default']")).click();
				  System.out.println("drop down Trim");
				 List<WebElement> trimDropdown =
						 		driver.findElements(By.xpath("//div[@class = 'price-protection__container__row trim']//ul[@class = 'multiselect-container dropdown-menu']/li/a"));
				 Thread.sleep(2000);
				 System.out.println("drop down Trim list aa gya");
				  trimDropdown.get(1).click();
				  Thread.sleep(2000);
				 driver.findElement(By.xpath("//div[@class = 'price-protection__container__row trim']//button[@class = 'multiselect dropdown-toggle btn btn-default']")).click();
				  Thread.sleep(2000);
				  Assert.assertFalse(driver.findElement(By.xpath("//button[@class ='multiselect dropdown-toggle btn btn-default disabled']")).isEnabled());
				 WebElement element =    driver.findElement(By.xpath("//span[@id = 'intro-pricing-status']"));
				 System.out.println("Pricing release :" + element.getAttribute("innerText"));
				 verifyPricingReleasedStatus( element, driver);
				 
				 verifyPricesApplyTo(driver);
				 System.out.println(" verifyPricesApplyTo done*********");
				  Thread.sleep(2000);
//				 verifyMultipleTrimSelection(driver);
				 System.out.println("verifyMultipleTrimSelection done************************");
		}
		
		public static void verifyPricingReleasedStatus( WebElement element ,WebDriver driver) {
			
			 //Pricing released or not validation
			 if(element.getAttribute("innerText").contains("Pricing released")) {
				 System.out.println("Pricing release wala case :");
				 
				 Boolean yes = driver.findElement(By.xpath("//div[@id = 'autodata-base-price']")).isDisplayed();
				 System.out.println("Pricing release wala case 2:" +yes);
				 Assert.assertTrue(driver.findElement(By.xpath("//div[@id = 'autodata-base-price']")).isDisplayed() , "autodata-base-price not displayed" );
				 Assert.assertTrue(driver.findElement(By.xpath("//div[@id = 'autodata-destination-charge']")).isDisplayed() , "autodata-destination-charge not displayed" );
				 Assert.assertTrue(driver.findElement(By.xpath("//input[@id = 'overwrite-base']")).isDisplayed() , "overwrite-base text field not displayed" );
				 Assert.assertTrue(driver.findElement(By.xpath("//input[@id = 'overwrite-destination']")).isDisplayed() , "overwrite-destination text field not displayed" );
				 System.out.println("Pricing release wala case  completed:");
			 }
			 else if(element.getAttribute("innerText").contains("Pricing not yet available")) {
				 System.out.println("***Pricing NOT release wala case :");
				 Assert.assertFalse(driver.findElement(By.xpath("//div[@id = 'autodata-base-price']")).isDisplayed() , "autodata-base-price should not displayed" );
				 Assert.assertFalse(driver.findElement(By.xpath("//div[@id = 'autodata-destination-charge']")).isDisplayed() , "autodata-destination-charge shouldnot displayed" );
				 Assert.assertFalse(driver.findElement(By.xpath("//input[@id = 'overwrite-base']")).isDisplayed() , "overwrite-base text field should not displayed" );
				 Assert.assertFalse(driver.findElement(By.xpath("//input[@id = 'overwrite-destination']")).isDisplayed() , "overwrite-destination text field should not displayed" );
				 System.out.println("***Pricing NOT release wala case **********DONE** :");
			 }
		}
		
		public static void verifyPricesApplyTo(WebDriver driver) {
			
			System.out.println("verifyPricesApplyTo **" );
			
			driver.findElement(By.xpath("//input[@id = 'destination-charge']")).click();
			 Assert.assertFalse(driver.findElement(By.xpath("//div[@id = 'autodata-destination-charge']")).isDisplayed() , "autodata-destination-charge is still displayed" );
			 Assert.assertFalse(driver.findElement(By.xpath("//input[@id = 'overwrite-destination']")).isDisplayed() , "autodata-destination-charge is still displayed" );
			 System.out.println("verifyPricesApplyTo **" );
		}
		
		public static void verifyMultipleTrimSelection(WebDriver driver) throws InterruptedException {
			
			driver.findElement(By.xpath("//div[@class = 'price-protection__container__row trim']//button[@class = 'multiselect dropdown-toggle btn btn-default']")).click();
			  System.out.println("drop down Trim clear");
			 List<WebElement> trimDropdown =
					 		driver.findElements(By.xpath("//div[@class = 'price-protection__container__row trim']//ul[@class = 'multiselect-container dropdown-menu']/li/a"));
			 Thread.sleep(2000);
			
			  trimDropdown.get(1).click();
			  System.out.println("drop down Trim list aa gya and clear hua &&s");
			 
		}
}
				 /*
				 
				 
				 
					WebElement model = driver.findElement(By.id("model"));
					Select modelList = new Select(model);
					 modelList.selectByVisibleText("3500 LCF Gas");
//					modelList.selectByIndex(1);
					 System.out.println("drop down model");
					 
//					 WebElement trim = driver.findElement(By.id("trim"));
//						Select trimList = new Select(trim);
//						 System.out.println("drop down trim");
//						 yearList.selectByVisibleText("Edge");
						 
					  driver.findElement(By.xpath("//div[@class = 'price-protection__container__row trim']//button[@class = 'multiselect dropdown-toggle btn btn-default']")).click();
					  System.out.println("drop down Trim");
					 List<WebElement> trimDropdown =
							 		driver.findElements(By.xpath("//div[@class = 'price-protection__container__row trim']//ul[@class = 'multiselect-container dropdown-menu']/li/a"));
					 Thread.sleep(2000);
					 System.out.println("drop down Trim list aa gya");
					  trimDropdown.get(1).click();
					  Thread.sleep(2000);
					 driver.findElement(By.xpath("//div[@class = 'price-protection__container__row trim']//button[@class = 'multiselect dropdown-toggle btn btn-default']")).click();
					  
					  Thread.sleep(2000);
					  
					  Assert.assertFalse(driver.findElement(By.xpath("//button[@class ='multiselect dropdown-toggle btn btn-default disabled']")).isEnabled());
					 WebElement element =    driver.findElement(By.xpath("//span[@id = 'intro-pricing-status']"));
					 System.out.println("Pricing release :" + element.getAttribute("innerText"));
					 
					 
					 //Pricing released or not validation
					 if(element.getAttribute("innerText").contains("Pricing released")) {
						 System.out.println("Pricing release wala case :");
						 Assert.assertTrue(driver.findElement(By.xpath("//div[@id = 'autodata-base-price']")).isDisplayed() , "autodata-base-price not displayed" );
						 Assert.assertTrue(driver.findElement(By.xpath("//div[@id = 'autodata-destination-charge']")).isDisplayed() , "autodata-destination-charge not displayed" );
						 Assert.assertTrue(driver.findElement(By.xpath("//input[@id = 'overwrite-base']")).isDisplayed() , "overwrite-base text field not displayed" );
						 Assert.assertTrue(driver.findElement(By.xpath("//input[@id = 'overwrite-destination']")).isDisplayed() , "overwrite-destination text field not displayed" );
						 
					 }
					 else if(element.getAttribute("innerText").contains("Pricing not yet available")) {
						 System.out.println("***Pricing NOT release wala case :");
					 }
					 
//					 System.out.println("Pricing release2 :" + element.getCssValue("innerText"));
//					 System.out.println("Pricing release2 :" + element.isDisplayed());
//					 System.out.println("Pricing release2 :" + element.getSize());
			
	}
	

}
*/