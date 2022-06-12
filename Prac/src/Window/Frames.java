package Window;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Frames {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class = 'demo-frame']")));
		driver.findElement(By.id("draggable")).click();
		
		WebElement source =driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		//Drag&Drop
		Actions a = new Actions(driver);
		a.dragAndDrop(source, target).build().perform();
		
	}

}
