package PricingScheme;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FleetSpecDetail2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\\\new_driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://ordering.qa.elementfleet.com/#vehicleConfig/fleetSpec/add");
		
		driver.findElement(By.xpath("//input[@name = 'username']")).sendKeys("ordsupft11");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys("TestingQA@1234");
//		driver.findElement(By.xpath("//input[@id='login']")).click();
		driver.findElement(By.id("signinBtn")).click();
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[@class='multiselect dropdown-toggle btndropdown btn btn-default']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//ul[@class='multiselect-container dropdown-menu']//li[3]")).click();
		Thread.sleep(9000);
		
		new WebDriverWait(driver, 9).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//ul[@class='select2-selection__rendered']"))));
		
//		driver.findElement(By.xpath("//ul[@class='select2-selection__rendered']")).click();
//		driver.findElement(By.xpath("//input[@class='select2-search__field']")).clear();
		Thread.sleep(9000);
		
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//ul[@id='0027']//li[1]//input")));
		WebElement ele = driver.findElement(By.xpath("//ul[@id='0027']//li[1]//input"));
			System.out.println("Additional option is deselected :"+ ele.isSelected());
			ele.click();
			System.out.println("Additional option is deselected 2 :"+ ele.isSelected());
		
			
			
	}
}
//div//h3[contains(text(),'Additional Options')]//..//following::ul[1]//li[1]//input[@type='checkbox']

