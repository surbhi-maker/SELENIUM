package PricingScheme;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FleetSpecDetail {

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
		
		driver.findElement(By.xpath("//ul[@class='select2-selection__rendered']")).click();
		driver.findElement(By.xpath("//input[@class='select2-search__field']")).clear();
		Thread.sleep(9000);
		System.out.println("make field is clickable");
		driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys("Jaguar");
		
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
		Thread.sleep(9000);
		driver.findElement(By.xpath("//tbody//tr[1]")).click();
		System.out.println("Vehicle page opened");
		/*
		//div[@id='optionsListOfSpecs']/ul[1]/li
		
		List<String> headerItems = new ArrayList<>(); 
		List<WebElement> actual  = driver.findElements(By.xpath("//div[@id='optionsListOfSpecs']/ul[1]/li"));
		for(WebElement ele :actual) {
			String str = ele.getText().replaceAll("[\\t\\n\\r]+"," ");
			if(!str.isEmpty()) {
			headerItems.add(str);
			}
		}
			headerItems.forEach(s->System.out.println(s));
			
			WebElement price = driver.findElement(By.xpath("//label[@class='an-value msrp-value']"));
			System.out.println(price.getText()+" :msrp price");
			System.out.println(price.getAttribute("outerText")+" :msrp price outerText");
			System.out.println(price.getAttribute("innerHTML")+" :msrp price innerHTML");
			System.out.println(price.getAttribute("innerText")+" :msrp price innerText");
			Float price1 = Float.parseFloat(price.getAttribute("innerText").replace("$", "").replace(",", "").trim());
//			invoiceAmount= Float.parseFloat(ele.getText().replace("$", "").replace(",", "").trim());
//			Integer.valueOf(price);
			System.out.println(price1+" :msrp price");
			System.out.println(price.getAttribute("innerText").replace("$", "").replace(",", "").trim()+" :msrp price");
		
			WebElement web = driver.findElement(By.xpath("//div[@id='optionsListOfSpecs']//ul[2]//label"));
			System.out.println(web.getAttribute("innerText").replace("$", "").replace(",", "").trim()+" :msrp price in header");
	}
*/		List<WebElement> li = driver.findElements(By.xpath("//div[@id='MSRP-tab']//tr[not(contains(@class,'subtotal'))]//td[2]"));

		li.forEach(s->System.out.println(s.getText()));
		li.forEach(s->System.out.println(s.getAttribute("innerText")));
		
		li.stream().forEach(s->System.out.println(s.getAttribute("innerText")));
		
		WebElement ele = driver.findElement(By.xpath("//div//h3[contains(text(),'Additional Options')]//..//following::ul[1]//li[1]//input[@type='checkbox']"));
			System.out.println("Additional option is deselected :"+ ele.isSelected());
			ele.click();
			System.out.println("Additional option is deselected 2 :"+ ele.isSelected());
		
	}
}
