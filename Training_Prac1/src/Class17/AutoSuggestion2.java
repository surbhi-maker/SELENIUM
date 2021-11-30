package Class17;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utilityPackage.Utility;

public class AutoSuggestion2 {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-autocomplete-feature-in.html");
		driver.findElement(By.id("tags")).sendKeys("a");
		Thread.sleep(2000L);
////div[@role='option']
		Utility.selectValueFromSuggestion(driver, By.xpath("//div[@class='ui-menu-item-wrapper']"), "java");
	}
}
