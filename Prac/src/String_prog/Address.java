package String_prog;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Address {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String addressLine="Winnipeg ,MB         R3H1B3";
		
//		System.out.println(addressLine.trim().replaceAll("[a-zA-Z0-9]*$", "").trim());
		System.out.println(addressLine.trim().replaceAll("\\S+\\s", "").trim());
		System.out.println(addressLine.trim().replaceAll("\\s", "").trim());
				//"London ,ON N6E1L8"; 
				//"FAYETTEVILLE , NC 28306-9083";
		String[] allAddressLine=addressLine.split(",");
//		System.out.println(allAddressLine.length);
//		System.out.println(allAddressLine[0]);
//		System.out.println(allAddressLine[1]);
//		System.out.println( allAddressLine[allAddressLine.length-1]);
		
//		System.out.println( allAddressLine[allAddressLine.length-1].trim().replaceAll("[^a-zA-Z]", ""));
		System.out.println( allAddressLine[allAddressLine.length-1].trim().replaceAll("[a-zA-Z0-9]*$", ""));
	/*	System.out.println( allAddressLine[allAddressLine.length-1].trim().replaceAll("\\S*\\d\\S.$", ""));
		System.out.println( allAddressLine[allAddressLine.length-1].trim().replaceAll("\\S*\\d\\S.$", ""));
		*/
		
		
/*
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://ordering.qa.elementfleet.com/#editOrder/3041468");
		
		
		driver.findElement(By.xpath("//input[@name = 'username']")).sendKeys("ordsup_AT1");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys("TestingQA@1234");
		
		driver.findElement(By.id("signinBtn")).click();
		Thread.sleep(2000L);
		
		Thread.sleep(3000L);
		driver.findElement(By.xpath("//ul[@id='createOrder-menu']//li[@id='coreorder_navigation__billing']//a[@title='Billing & Registration']")).click();
		Thread.sleep(2000L);
		
		String contractType = driver.findElement(By.xpath("//div[@class ='form-group col-md-3']//p")).getText();
		System.out.println("First contract type option is: "+contractType);
		*/
	}

}
