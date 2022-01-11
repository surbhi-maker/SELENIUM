package Class31_ActionsClass_jsExecutor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop3 {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		
		Actions action = new Actions(driver);
		WebElement src = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement target = driver.findElement(By.xpath("//div[@id='droppable']"));
		
		/*	
		action.dragAndDrop(driver.findElement(By.xpath("//div[@id='draggable']")), 
				driver.findElement(By.xpath("//div[@id='droppable']"))).perform();
				*/
		//OR
		//custom
		action.clickAndHold(src)
		.pause(1000)
		.moveToElement(target)
		.pause(1000)
		.release().build().perform();
		
	}
}
