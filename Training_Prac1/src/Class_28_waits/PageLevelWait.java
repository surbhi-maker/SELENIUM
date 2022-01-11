package Class_28_waits;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;

//https://developers.perfectomobile.com/display/TT/Page+Load+Timeouts+in+Selenium
/* Waits in Selenium
 * Page : complete application throughout session
 * Script : full session
 * Element : GLOBAL OR Specific web Element
 * 
 * org.openqa.selenium.TimeoutException:
 * Must Read: https://seleniumatfingertips.wordpress.com/tag/pageloadtimeout/
 */
public class PageLevelWait {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

//		Timeouts time = driver.manage().timeouts();
//		time.pageLoadTimeout(Duration.ofMillis(200));
		
		//before get method
		/*
		 * page
		 * 
		 */
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS); 
		
		/*
		 * jb java script load nhi hota tb he aata hei bhut rare
		 */
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);  
		
		/*
		 * implicitly
		 * ONLY works for element which is Presence/visibility (x,y)>0 ***********does not deal with alert frame ....
		 * only check if element is visible or enable 
		 * Global wait
		 * no need to define multiple time it will overwrite
		 * do not mix for explicit wait ********** do not provide both bcs it will get confused
		 * default polling 250 mili sec
		 * 
		 * 
		 */
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); //wait for 10 sec then fail
		
		driver.get("https://seleniumpractise.blogspot.com/search?q=timer");
		driver.findElement(By.xpath("//button[@onclick ='timedText()']")).click();
		System.out.println(driver.findElement(By.xpath("//button[@onclick ='timedText()']")).isDisplayed());
		
		
		
	}

}
