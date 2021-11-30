package Class17;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utilityPackage.Utility;

public class HandleCalendar {
	
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		driver.findElement(By.id("datepicker")).click();
		Thread.sleep(2000L);
		
		String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		String year = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		while(!currentMonth.equalsIgnoreCase("April") && !year.equals("2022")) {
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			currentMonth= driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		}
		Utility.selectValueFromSuggestion(driver, By.xpath("//table[@class='ui-datepicker-calendar']//a"), "27");
		
		driver.manage().window().maximize();
//		Utility.selectValueFromSuggestion(driver, By.xpath("//table[@class='ui-datepicker-calendar']//a"), "27");

	}
}
