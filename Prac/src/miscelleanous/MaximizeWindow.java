package miscelleanous;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MaximizeWindow {
	
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companions");
		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
//		driver.manage().deleteCookieNamed("cookie name");
		driver.findElement(By.xpath("//input[@id = 'travel_date']")).click();
		
	}
	}
