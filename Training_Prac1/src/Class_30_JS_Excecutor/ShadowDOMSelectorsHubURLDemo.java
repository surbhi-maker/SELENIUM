package Class_30_JS_Excecutor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDOMSelectorsHubURLDemo {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://selectorshub.com/xpath-practice-page/");
		driver.manage().window().maximize();
		driver.switchTo().frame("pact");
	
		WebElement ele = driver.findElement(By.id("snacktime"));
		
		scrollIntoView(ele,driver);
		String teaType ="greenTea";
		jsRemoveSahdowDom(ele ,driver);
		
	}
	/*
	 * Nested ShadowDom
	 */
//	document.querySelector('#snacktime').shadowRoot.querySelector('#app2').shadowRoot.querySelector("#pizza").value='Farm house'
	
	public static void scrollIntoView(WebElement webElement, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true)", webElement);
	}
	
	public static void jsRemoveSahdowDom(WebElement webElement, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("document.getElementById(\"snacktime\").shadowRoot.getElementById(\"tea\").value='green tea'", webElement);
	}
}
