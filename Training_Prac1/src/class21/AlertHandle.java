package class21;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandle {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.xpath("//input[@title='Sign in']")).click();
		Thread.sleep(3000L);
		
		Alert alt = driver.switchTo().alert();
		String alt_text = alt.getText();
	
		if(alt_text.contains("Please enter a valid user name")) {
			System.out.println("validation pass");
		} else {
			System.out.println("validation fail");
		}
		/*ok, yes, continue  OR use alt dismiss
		 * 
		 */
		alt.accept();
		
		/*
		 * But before handling alert just try to enter username
		 * UNHANDLED ALERT EXCEPTION
		 * org.openqa.selenium.UnhandledAlertException:
		 */
		System.out.println("Again generate alert then perform");
		driver.findElement(By.xpath("//input[@title='Sign in']")).click();
		driver.findElement(By.id("login1")).sendKeys("surbhi");
		
		Thread.sleep(3000L);
		driver.close();
		
		/*   for alert with wait practice
		 *  http://seleniumpractise.blogspot.com/2019/01/alert-demo.html
		 */
		
		//bootstrap angular vie js examples
}
}
