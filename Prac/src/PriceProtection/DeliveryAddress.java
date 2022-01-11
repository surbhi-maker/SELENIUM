package PriceProtection;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeliveryAddress {
//		https://ordering-qa3.qa.elementfleet.com/#editOrder/3009940
			public static void main(String[] args) throws AWTException, InterruptedException {
			System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://ordering.qa.elementfleet.com/#createOrder");
			
			
			driver.findElement(By.xpath("//input[@name = 'username']")).sendKeys("ordsupft11");
			driver.manage().window().maximize();
			driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys("TestingQA@1234");
			driver.findElement(By.id("signinBtn")).click();
			driver.manage().window().maximize();
			
			driver.findElement(By.xpath("//button[@class = 'pull-right btn saveNext icon-stack']")).click();
//			driver.findElement(By.xpath("//a[@title= 'Driver']")).click();
			System.out.println("driver 1");
			 driver.findElement(By.xpath("//input[@class='searchText searchButton tt-input']")).sendKeys("jeremy");
			 driver.findElement(By.xpath("//div[@class ='tt-suggestion tt-selectable sugg-item disabled-ui-state'][4]")).click();
			System.out.println("driver 2");
		
//			Robot r = new Robot();
//			r.keyPress(KeyEvent.VK_DOWN);
//			r.keyRelease(KeyEvent.VK_DOWN);
//			System.out.println("key released: ");
//			r.keyPress(KeyEvent.VK_ENTER);
//			r.keyRelease(KeyEvent.VK_ENTER);
//			System.out.println("key selected: ");
			
			
			String new1 =  driver.findElement(By.id("bh-search-unit")).getText();
			
//			System.out.println("key selected: " +new1);
			driver.findElement(By.xpath("//input[@id= 'addDelivery']")).click();
			
// driver.findElement(By.xpath("//div[@id='section__delivery-address']//input[@id='addressLine1']")).sendKeys("759 N ECKHOFF ST");
			
 
 WebElement currentAddress=driver.findElement(By.xpath("//div[@id='section__delivery-address']//input[@id='addressLine1']"));
 currentAddress.sendKeys("759 N ECKHOFF");
 
// currentAddress.sendKeys(Keys.DOWN);
// currentAddress.sendKeys(Keys.ENTER);
// currentAddress.sendKeys(Keys.DOWN, Keys.RETURN);
			Robot r = new Robot();
			
			Thread.sleep(2000L);
			
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
//			Thread.sleep(5000L);
			System.out.println("key released 1: ");
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			System.out.println("key selected 2: ");
			
			
//			WebElement state2 = driver.findElement(By.cssSelector("div.form-group.row div.ownDealerInfo div.form-group.row div.form-row:nth-child(2) div.form-group.col-md-3:nth-child(2) > label.block"));
//			
//			WebElement state  = driver.findElement(By.xpath("//label[contains(text() , 'State')]"));
//			System.out.println("State entry string :" + state.getAttribute("innerText"));
//			System.out.println("State entry string :" + state.getAttribute("innerHTML"));
//			System.out.println("State entry string :" + state.getText());
////			assertLabelHighlight(state,"State/Province", "State label not matched" ,driver);
//			assertLabelHighlight(state2,"State/Province", "State label not matched" ,driver);
			}
}