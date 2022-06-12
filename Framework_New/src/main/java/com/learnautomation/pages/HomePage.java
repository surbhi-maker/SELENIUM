package com.learnautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	By username  = By.id("txtUsername");
	
	By password = By.id("txtPassword");
	
	By loginButton = By.id("btnLogin");
	
	By socialMediaLinks = By.xpath("//div[@id='social-icons']//img");
	
	public DashboardPage loginWithAdmin(String uname , String pass) {
		
		driver.findElement(username).sendKeys(uname);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(loginButton).click();
		
		DashboardPage dash = new DashboardPage(driver);
		return dash;
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public int countSoacialMediaLinks() {
		return driver.findElements(socialMediaLinks).size();
	}
	
	//driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
//	System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
//	WebDriver driver = new ChromeDriver();
//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	driver.get("https://github.com/pazone/ashot");
//	driver.manage().window().maximize();
	
}
