package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		
		Actions a = new Actions(driver);
		WebElement move = driver.findElement(By.cssSelector("a[id = 'nav-link-accountList']"));
		
		//driver.findElement(By.cssSelector("a[id = 'nav-link-accountList']"));
		// To move tp specific element
		//a.moveToElement(move).build().perform();
		
		WebElement move1 = driver.findElement(By.cssSelector("input[id = 'twotabsearchtextbox']"));
		a.moveToElement(move1).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		
		a.moveToElement(move).contextClick().build().perform();
		
		
		

	}

}
