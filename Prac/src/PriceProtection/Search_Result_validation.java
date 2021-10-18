package PriceProtection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Search_Result_validation {
	
	WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://ordering-backoffice.qa.fleet.ad/login");
		
		driver.findElement(By.xpath("//input[@name = 'username']")).sendKeys("ordsupft11");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys("TestingQA@1234");
		driver.findElement(By.cssSelector("input.btn")).click();
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//div[@id ='side-menu']/ul/li[7]")).click();
		driver.findElement(By.xpath("//div[@data-target = 'PPAQ']")).click();
		////button[@class = 'multiselect dropdown-toggle btn btn-default']
		
		String defaultStatus = driver.findElement(By.xpath("//button[@class = 'multiselect dropdown-toggle btn btn-default']")).getText();
		   System.out.println("default check done :" + defaultStatus);
		   System.out.println("Status check for :" + defaultStatus);
		   ValidateRecordState(driver);
		   Thread.sleep(2000);
		   driver.findElement(By.xpath("//button[@id='clear-all-filters-btn']")).click();
		   Thread.sleep(2000);
		   String defaultStatus1 = driver.findElement(By.xpath("//button[@class = 'multiselect dropdown-toggle btn btn-default']")).getText();
		   
		   System.out.println("Status check for :" + defaultStatus1);
		//record validate
		   ValidateRecordState(driver);
		   
		   
				
	}
	
	public static void ValidateRecordState(WebDriver driver) {
		List<WebElement> records = driver.findElements(By.xpath("//td[@data-name='status']"));
		List<String> statusList = new ArrayList<>();
		for(WebElement rs : records) {
			statusList.add(rs.getAttribute("innerText").trim().replaceAll("\\r\\n|\\r|\\n", " "));
	}
		boolean allEqual = new HashSet<String>(statusList).size() <= 1;
		System.out.println(" status test allEqual ?" + allEqual);
	}

}
