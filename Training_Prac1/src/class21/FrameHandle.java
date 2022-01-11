package class21;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * HTML IFRAME
 * NosuchframeException
 * if inside iframe then noSuchElementexception
 */
public class FrameHandle {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://classic.freecrm.com/");
		driver.manage().window().maximize();
		driver.findElement(By.name("username")).sendKeys("MukeshOtwani_50");
		driver.findElement(By.xpath("//input[@placeholder=\"Password\"]")).sendKeys("Abcd@1234");
		driver.findElement(By.xpath("//input[@value='Login']")).click();	
		System.out.println("count is:"+driver.findElements(By.tagName("frame")).size());
		
		//we can switch with index
//		driver.switchTo().frame(2);
		
		//By name
		driver.switchTo().frame("mainpanel");
		
		//By locator
		//driver.switchTo().frame(driver.findElement(By.xpath("//frame[contains(@src, 'index.cfm')]")));
		driver.findElement(By.xpath("//*[contains(text() , 'Logout')]")).click();
		Thread.sleep(5000L);
		System.out.println("log out done");
		
		/*
		 * then again use login funtion
		 * driver.switchTo().defaultContent();   OR main page pr vapis aana 
		 * frame to frame switch not allow
		 * switch to out /default then switch to frame
		 */
		driver.switchTo().defaultContent();
		Thread.sleep(3000L);
		System.out.println("login again#####");
		driver.findElement(By.name("username")).sendKeys("MukeshOtwani_50");
		driver.findElement(By.xpath("//input[@placeholder=\"Password\"]")).sendKeys("Abcd@1234");
		driver.findElement(By.xpath("//input[@value='Login']")).click();	
		Thread.sleep(3000L);
		System.out.println("logged in");
		
		
	}

}
