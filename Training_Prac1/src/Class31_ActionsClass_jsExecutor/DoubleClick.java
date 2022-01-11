package Class31_ActionsClass_jsExecutor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClick {
	
//https://swisnl.github.io/jQuery-contextMenu/demo.html
//	https://api.jquery.com/dblclick/
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://api.jquery.com/dblclick/");
		driver.manage().window().maximize();
		
		WebElement ele =driver.findElement(By.xpath("//div[@class='demo code-demo']"));
		scrollIntoView(ele , driver);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe")));
		
		WebElement element = driver.findElement(By.xpath("//html[@lang='en']//body//div"));
		Actions action = new Actions(driver);
		
//		action.contextClick(element);
		
	}
	
	
	public static void scrollIntoView(WebElement webElement, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true)", webElement);
	}
}
