package PriceProtection;



import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CorpCode {

		
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
//				System.out.println("corp code which is selected: " + corpCd.getText());
				
				 System.out.println("default view for FA");
					Assert.assertTrue(driver.findElement(By.xpath("//input[@id = 'intro-pricing']")).isSelected(), "Intro price is not selected");
					Assert.assertTrue(driver.findElement(By.xpath("//input[@id = 'invoice']")).isSelected(), "Invoice is not selected");
					Assert.assertTrue(driver.findElement(By.xpath("//input[@id = 'base-price']")).isSelected(), "base-price is not selected");
					
					Assert.assertFalse(driver.findElement(By.xpath("//input[@id = 'base-price']")).isEnabled(), "base-price is not disabled");
					
					Assert.assertTrue(driver.findElement(By.xpath("//input[@id = 'destination-charge']")).isSelected(), "destination-charge is  not selected");
					
					
					 WebElement ele = driver.findElement(By.xpath("//input[@id = 'invoice']"));
						//input[@id ='msrp']
						 if(ele.isSelected()) {
							 System.out.println("Invoice selected");
							 Assert.assertFalse(driver.findElement(By.xpath("//input[@id = 'msrp']")).isSelected());
						 }
						 else
						 {
							 System.out.println("MSRP selected");
							 Assert.assertTrue(driver.findElement(By.xpath("//input[@id = 'msrp']")).isSelected());
						 }
						 
						 
						 
						 
//				String corpCode = driver.findElement(By.xpath("//select[@id = 'corp-code']")).getText();
//				 System.out.println("drop down is select"+ corpCode);
				Thread.sleep(2000);
//				 System.out.println("drop down CA");
				dropdown.selectByVisibleText("CA");
				System.out.println("default view for CA");
				Assert.assertTrue(driver.findElement(By.xpath("//input[@id = 'intro-pricing']")).isSelected(), "Intro select is not selected");
				Assert.assertTrue(driver.findElement(By.xpath("//input[@id = 'net']")).isSelected(), "Nect selected is not selected");
				Assert.assertTrue(driver.findElement(By.xpath("//input[@id = 'base-price']")).isSelected(), "base-price is not selected");
				Assert.assertTrue(driver.findElement(By.xpath("//input[@id = 'destination-charge']")).isSelected(), "destination-charge is not selected");
//				String corpCode1 = driver.findElement(By.xpath("//select[@id = 'corp-code']")).getText();
//				 System.out.println("drop down is select"+ corpCode);
				
				
				
				 WebElement element = driver.findElement(By.xpath("//input[@id = 'effective-date']"));
				 System.out.println("default view for effective date:" +element.getAttribute("placeholder") );
				 Assert.assertEquals(element.getAttribute("placeholder"), "MM/DD/YYYY");
				
				 
				 
					
					
					//  //div[@class='tt-dataset tt-dataset-search-client']//div[@class='tt-suggestion tt-selectable empty client-color']
					
					
					//OrderingBOQueuePage
					//enterDetailsOnCreateProjectPopup
				 
				 //first client selection
				 driver.findElement(By.xpath("//input[@id='search-client']")).sendKeys("175");
					Thread.sleep(2000);
					driver.findElements(By.xpath("//div[@class='tt-dataset tt-dataset-search-client']//div[@class='tt-suggestion tt-selectable empty client-color']")).get(0).click();
					
				 /*
				if(corpCode.equals("FA")) {
					Thread.sleep(2000);
					 System.out.println("default view for FA");
					Assert.assertTrue(driver.findElement(By.xpath("//input[@id = 'intro-pricing']")).isSelected(), "Intro price is not selected");
					Assert.assertTrue(driver.findElement(By.xpath("//input[@id = 'invoice']")).isSelected(), "Invoice is not selected");
					Assert.assertTrue(driver.findElement(By.xpath("//input[@id = 'base-price']")).isSelected(), "base-price is not selected");
					Assert.assertTrue(driver.findElement(By.xpath("//input[@id = 'destination-charge']")).isSelected(), "destination-charge is  not selected");
				}else if(corpCode.equals("CA")) {
					System.out.println("default view for CA");
					Assert.assertTrue(driver.findElement(By.xpath("//input[@id = 'intro-pricing']")).isSelected(), "Intro select is not selected");
					Assert.assertTrue(driver.findElement(By.xpath("//input[@id = 'net']")).isSelected(), "Nect selected is not selected");
					Assert.assertTrue(driver.findElement(By.xpath("//input[@id = 'base-price']")).isSelected(), "base-price is not selected");
					Assert.assertTrue(driver.findElement(By.xpath("//input[@id = 'destination-charge']")).isSelected(), "destination-charge is not selected");
				}
				*/
				
//				Boolean intro = driver.findElement(By.xpath("//input[@id = 'intro-pricing']")).isSelected();
//				Boolean flag2 = driver.findElement(By.xpath("//input[@id = 'invoice']")).isSelected();
//				Boolean flag3 = driver.findElement(By.xpath("//input[@id = 'destination-charge']")).isSelected();
					
					WebElement element1 =	driver.findElement(By.linkText("Back to Queue View"));
					 element1.click();
					 System.out.println(" breadcrumbs clicked");
				
	}

}
