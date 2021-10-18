package PriceProtection;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ClientSearch {

		
		////div[@class='tt-dataset tt-dataset-contactSearch']//div[@class='tt-suggestion tt-selectable empty']
	///input[@id='search-client']
		
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
			
	}

}
