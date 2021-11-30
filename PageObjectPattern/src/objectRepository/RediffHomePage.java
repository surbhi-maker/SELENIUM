package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RediffHomePage {
	WebDriver driver;
	public RediffHomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	By search = By.id("srchword");
	By selectFirst = By.id("suggest_0");
	
	
	
	public WebElement search() {
		return driver.findElement(search);
	}
	
	public WebElement selectFirst() {
		return driver.findElement(selectFirst);
	}
}
