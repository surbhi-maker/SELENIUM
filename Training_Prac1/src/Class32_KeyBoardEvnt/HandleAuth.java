package Class32_KeyBoardEvnt;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandleAuth {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		/*
		 * to by pass user name pass
		 * https://username:password@host/subdomain/path
		 */
//		driver.get("https://username:password@jigsaw.w3.org/HTTP/Basic");
		driver.get("https://guest:guest@jigsaw.w3.org/HTTP/Basic");
		driver.manage().window().maximize();
		
		
		
	
	}

}
