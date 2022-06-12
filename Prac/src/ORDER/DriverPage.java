package ORDER;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverPage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://ordering.qa.elementfleet.com/#editOrder/3045768");
		
		
		driver.findElement(By.xpath("//input[@name = 'username']")).sendKeys("ordsupft11");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys("TestingQA@1234");
		
		driver.findElement(By.id("signinBtn")).click();
		Thread.sleep(2000L);
		
		driver.findElement(By.xpath("//ul[@id='createOrder-menu']//li[4]")).click();
		
//		System.out.println("driver tab");
//		driver.findElement(By.xpath("//ul[@id='createOrder-menu']//a[@title='Vehicle']")).click();
//		System.out.println("driver tab moved");
		
		String val = driver.findElement(By.xpath("//input[@id='new-vehicle-breakdown']")).getAttribute("value");
		System.out.println("bkdm is"+ val);
	}

}
