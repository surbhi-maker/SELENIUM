package Class32_KeyBoardEvnt;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardEvents {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/selectable/");
		driver.manage().window().maximize();
		
		driver.switchTo().frame(0);
		
		Actions act = new Actions(driver);
		
		act.keyDown(Keys.CONTROL).perform();
		
		//ol[@class='ui-selectable']//li
		List<WebElement> allValues = driver.findElements(By.xpath("//ol[@class='ui-selectable']//li"));

		for(WebElement ele :allValues) {
			Thread.sleep(1000);
			ele.click();
		}
		act.keyUp(Keys.CONTROL).perform();
	}

}
