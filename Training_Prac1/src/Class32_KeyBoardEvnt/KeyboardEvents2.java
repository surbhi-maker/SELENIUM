package Class32_KeyBoardEvnt;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardEvents2 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("email")).sendKeys("Selenium@gmail.com");
		Actions act = new Actions(driver);
		
		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).pause(2000)
		.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).pause(2000)
		.sendKeys(Keys.TAB).pause(2000)
		.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).pause(2000)
		.sendKeys(Keys.ENTER).build().perform();
		
		
	
	}

}
