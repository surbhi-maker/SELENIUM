package French;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FrenchTranslation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//		ChromeOptions chromeOptions = new ChromeOptions();
//		chromeOptions.addArguments("--lang= locale-of-choice");
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://xcelerate.qa.elementfleet.com/web/common/doLogin");
		
		
		driver.findElement(By.xpath("//input[@name = 'username']")).sendKeys("Bill_QA_Su");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys("testqa12");
		driver.findElement(By.id("signinBtn")).click();
		driver.manage().window().maximize();
		
		Thread.sleep(7000L);
//for now		driver.findElement(By.xpath("//button[@id='yes']")).click();
		System.out.println("click on setting");
		driver.findElement(By.xpath("//a[@data-sectionid='settingsSlidMenu']")).click();
		//
		driver.findElement(By.xpath("//a[@title='Preferences']")).click();
		System.out.println("clicked on setting");
		scrollToBottomOfPage(driver);
		System.out.println("select french setting");
//		driver.findElement(By.xpath("//span[text()='French/Français']")).click();
		System.out.println("selected************ french setting");
		driver.findElement(By.id("submitPreferences")).click();
		System.out.println("selected french lang and saved");
		Thread.sleep(2000L);
		driver.findElement(By.xpath("//a[@href='/web/common/home']")).click();
	}
	
	public static void scrollToBottomOfPage(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver ;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
}
