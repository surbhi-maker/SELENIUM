package Class31_ActionsClass_jsExecutor;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import utilityPackage.Utility;

public class DragAndDrop4_dblClick {
	
	//https://swisnl.github.io/jQuery-contextMenu/demo.html
//	https://api.jquery.com/dblclick/
	public static void main(String[] args) throws InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();
		WebElement ele =driver.findElement(By.xpath("//span[text()='right click me']"));
		
		Actions action = new Actions(driver);
		
		action.click();
		action.contextClick(ele).perform();
		
		Robot r = new Robot();
		for(int i=0 ;i<5 ; i++) {
			r.keyPress(KeyEvent.VK_DOWN);
			System.out.println("key Down: " +i);
			Thread.sleep(1000);
			if(i==4) {
				r.keyPress(KeyEvent.VK_ENTER);
				r.keyRelease(KeyEvent.VK_ENTER);
				System.out.println("key selected: ");
			}
		}
		
		Utility.acceptAlert(driver);
		
			
	}
	
	
}
