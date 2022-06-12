package miscelleanous;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SpecificLinkValidateAndCloseOther {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//https://opensource-demo.orangehrmlive.com/
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\\\new_driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		String parentWindowId = driver.getWindowHandle();
		
		driver.findElement(By.xpath("//img[@alt='LinkedIn OrangeHRM group']")).click();
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on Facebook']")).click();
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on twitter']")).click();
		Set<String> handles = driver.getWindowHandles();
		List<String> tabs = new ArrayList<String>(handles);
		if(switchToNewWindow(tabs ,"Facebook", driver)) {
			System.out.println("True");
			System.out.println("found a right window: "+ driver.getTitle());
			
		}
		switchToParentWindow(parentWindowId,driver);
		closeOtherWindows(tabs,parentWindowId,driver);
	
		int windowCount = driver.getWindowHandles().size();
		Assert.assertEquals(windowCount , 1);
		
		driver.manage().window().maximize();
	}
	public static void switchToParentWindow(String parentWindowId, WebDriver driver) {
		driver.switchTo().window(parentWindowId);
		System.out.println("current window shold be parent window:"+ driver.getCurrentUrl()+" id the current usr and title is :"+ driver.getTitle());
		
	}
	
	public static boolean switchToNewWindow(List<String> li, String windowTitle, WebDriver driver) {
		for(String e : li) {
			String titleNow = driver.switchTo().window(e).getTitle();
			if(titleNow.contains("Facebook")) {
				System.out.println("found a right window");
				return true;
			}
		}
		return false;
	}
	
	public static void closeOtherWindows(List<String> li,String parentWindowId,WebDriver driver) {
		for(String e : li) {
			if(!driver.switchTo().window(e).getWindowHandle().equals(parentWindowId))
				driver.close();
		}
	}
}