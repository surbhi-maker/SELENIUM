package PricingScheme;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class BasicValidation {
	
	public static void main(String[] args) throws InterruptedException {
		////div[@id='queue-table']//div[@class='dataTables_scrollHeadInner']//th[not(contains(@class, 'sorting_disable'))]
		
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://ordering-backoffice.qa.fleet.ad/login");
		
		driver.findElement(By.xpath("//input[@name = 'username']")).sendKeys("Bill_QA_Su");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys("testqa12");
		driver.findElement(By.cssSelector("input.btn")).click();
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//div[@id ='side-menu']/ul/li[8]")).click();
		driver.findElement(By.xpath("//div[@data-target = 'PS']")).click();
		////button[@class = 'multiselect dropdown-toggle btn btn-default']
		
//		List<WebElement> col = driver.findElements(By.xpath("//div[@id='queue-table']//div[@class='dataTables_scrollHeadInner']//th[not(contains(@class, 'sorting_disable'))]"));
		
//		col.forEach(s->System.out.println(s.getText()));
		
		/*
		driver.findElement(By.xpath("//button[@data-target='view-action-dropdow']")).click();
		
		driver.findElement(By.xpath("//ul[@class='dropdown-menu']//li[@data-view-action='Manage Views']")).click();
		
		
		List<String> disabled = Arrays.asList("Corp","Year","Manufacturer","Pricing Scheme","Effective Start Date");
		
		
		List<WebElement> actualEle = driver.findElements(By.xpath("//div[@class='manage-view-container']//label"));
		actualEle.forEach(s->System.out.println(s.getText()+ " actual element"));
		
		String mand = driver.findElement(By.xpath("//div[@class='manage-view-container']//label[@fieldname='corpCode']")).getText();
		Assert.assertTrue(mand.trim().contains("*"));
		System.out.println("mand field" + mand);
		
		for(WebElement actual :actualEle) {
//			System.out.println(actual.isEnabled()+" ele is" +actual.getText());
//			Assert.assertTrue(actual.isEnabled(), "not disabled"+actual.getText());
		}
		
		WebElement checkbox = driver.findElement(By.xpath("//div[@class='manage-view-container']//input[@value='corpCode']"));
		System.out.println("ele" +checkbox.getText()+" is blured ? " +checkbox.isEnabled() );
		
		WebElement checkbox1 = driver.findElement(By.xpath("//div[@class='manage-view-container']//input[@value='endDate']"));
		System.out.println("ele1" +checkbox1.getText()+" is blured ? " +checkbox1.isEnabled() );
		*/
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//button[@id='add-new-button']")).click();
		Thread.sleep(5000);
		
		String yr = driver.findElement(By.cssSelector("div#div-year>label")).getText();
		System.out.println(yr);
		
		
		String pscheme1 = driver.findElement(By.cssSelector("div#div-pricingScheme>label")).getText();
		System.out.println(pscheme1);
		
		WebElement pscheme = driver.findElement(By.cssSelector("div#div-pricingScheme>label"));
		System.out.println(pscheme.getAttribute("innerText"));
		Assert.assertFalse(verifyFieldIsMandatory(pscheme));
		
	}
	
	public static boolean verifyFieldIsMandatory(WebElement element){
		boolean isMandaory = element.getAttribute("innerText").trim().contains("*");
		System.out.println("is mandatory " +isMandaory);
		return isMandaory;
		
	}
}
