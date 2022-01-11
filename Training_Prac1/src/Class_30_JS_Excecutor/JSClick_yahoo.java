package Class_30_JS_Excecutor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSClick_yahoo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://login.yahoo.com/");
		driver.manage().window().maximize();
		
	
		WebElement ele = driver.findElement(By.id("persistent"));
		WebElement name = driver.findElement(By.name("username"));
		
		String input = "Surbhi";
		jsTextEnter(name ,driver ,input);
		jsClick(ele, driver);
	
//		Thread.sleep(5000L);
//		System.out.println(ele.getText());
		
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
	
	//document.getElementsByName("username").value ='Surbhi'
	public static void jsTextEnter(WebElement webElement, WebDriver driver, String input) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
//		js.executeScript("arguments[0].value ='"+input+"'", webElement);
		
		//OR
		
		js.executeScript("arguments[0].value =arguments[1]", webElement , input);
	}

	public static void jsScrollRight(WebElement webElement, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", webElement);
	}
	
	
	//document.querySelector("#snacktime").shadowRoot.querySelector("#tea")
	public static void jsRemoveSahdowDom(WebElement webElement, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
//		js.executeScript("arguments[0].shadowRoot.innerHTML = '';", webElement);
		js.executeScript("document.querySelector(\"#snacktime\").shadowRoot.querySelector(\"#tea\");", webElement);
	}
}
