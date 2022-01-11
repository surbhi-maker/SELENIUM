package CA_Scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClientChangeXecelerate {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://xcelerate2.qa.elementfleet.com/web/common/doLogin");

		driver.findElement(By.xpath("//input[@name = 'username']")).sendKeys("ordsupft11");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys("TestingQA@1234");

		driver.findElement(By.id("signinBtn")).click();
		Thread.sleep(2000L);
		driver.findElement(By.xpath("//button[@title='Client Breakdown']")).click();
		
		driver.findElement(By.xpath("//img[@title='Canada']")).click();
		driver.findElement(By.id("sClientNumberview12")).sendKeys("9242");
		
//		Thread.sleep(2000L);
		driver.findElement(By.cssSelector("div[class='tt-suggestion tt-selectable']")).click();
		Thread.sleep(2000L);
		WebElement webElement =driver.findElement(By.xpath("//a[@title='Client & Breakdown Selector']"));
		
		jsClick(webElement ,driver);
	}
	
	
	/*
	 * //div[@id='telematicsMCBWarningMessage']//button[text()=' OK']
	 */
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
