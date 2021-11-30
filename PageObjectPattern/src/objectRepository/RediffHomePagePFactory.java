package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RediffHomePagePFactory {
	
	private WebDriver driver;
	public RediffHomePagePFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Sign In")
	WebElement signin;
	
	@FindBy(name="logid")
	WebElement emailEnter;
	
	@FindBy(name="pswd")
	WebElement passwordEnter;
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement login;
	
	
	public WebElement signin() {
		return signin;
	}
	
	public WebElement emailEnter() {
		return emailEnter;
	}
	public WebElement passwordEnter() {
		return passwordEnter;
	}
	public WebElement login() {
		return login;
	}
	
//	
//	WebDriver driver;
//	public RediffHomePagePFactory(WebDriver driver) {
//		this.driver = driver;
//	}
//	
//	By search = By.id("srchword");
//	By selectFirst = By.id("suggest_0");
//	
//	
//	
//	public WebElement search() {
//		return driver.findElement(search);
//	}
//	
//	public WebElement selectFirst() {
//		return driver.findElement(selectFirst);
//	}
}
