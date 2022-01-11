package Class_30_JS_Excecutor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VehiclePDF {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://vsplordwb01d:8300/#displayOrder/3006649");

		driver.findElement(By.xpath("//input[@name = 'username']")).sendKeys("orddevauto");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys("TestDev@1234");

		driver.findElement(By.id("login")).click();
		Thread.sleep(2000L);
		driver.findElement(By.xpath("//i[@class='fa fa-list-alt']")).click();
		Thread.sleep(2000L);
		
		driver.findElement(By.xpath("//div[@data-target='OOQ']")).click();
		
		driver.findElement(By.xpath("//input[@name='logNumber']")).sendKeys("25012822");
		
		driver.findElement(By.xpath("//div[@data-target='search']")).click();
		Thread.sleep(2000L);
		driver.findElement(By.xpath("//tr[@class='odd']")).click();
//		driver.findElement(By.id("vehicleInfoTabId")).click();
		jsClick(driver.findElement(By.xpath("//h1[text()='Vehicle']")) ,driver);
		
		WebElement ele =driver.findElement(By.xpath("//div[@class='export-po-vehicle button button--primary button--small pull-right hidden']"));
		
		jsClick(ele ,driver);
	}
	
	public static void jsClick(WebElement webElement, WebDriver driver) {
		try {
			webElement.click();
		} catch (Exception e) {
			System.out.println("Log:INFO- Webelement click did not worked try with js click");

			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].click();", webElement);
		}
	}
}
