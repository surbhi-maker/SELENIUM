package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RediffLoginPage {
	WebDriver driver;
	public RediffLoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By username = By.id("login1");
	By password = By.id("password");
	By signin = By.name("proceed");
	By homepage = By.xpath("//a[@class ='f12']");
	
	public WebElement emailId() {
		return driver.findElement(username);
	}
	
	public WebElement password() {
		return driver.findElement(password);
	}
	
	public WebElement submit() {
		return driver.findElement(signin);
	}
	
	public WebElement homepage() {
		return driver.findElement(homepage);
	}
}
