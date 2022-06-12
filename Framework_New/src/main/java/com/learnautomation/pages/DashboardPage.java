package com.learnautomation.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {

	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	By allTabsMenu = By.xpath("//ul[@id='mainMenuFirstLevelUnorderedList']//b");

	By welcomeText = By.id("welcome");
	By logoutText = By.xpath("//a[contains(text(),'Logout')]");
	By adminTab = By.xpath("//div[@id='mainMenu']//b[contains(text(),'Admin')]");
	
	
	public String getWelcomeText() {
		return driver.findElement(welcomeText).getText();
	}
	
	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}
	
	public void logoutFromApplication() {
		driver.findElement(welcomeText).click();
		
//		WebDriverWait wait = (WebDriverWait) 
				new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(logoutText));
		
		driver.findElement(logoutText).click();
	}
	
	public AdminPage clickOnAdminPage() {
		driver.findElement(adminTab).click();
		AdminPage admin = new AdminPage(driver);
		return admin;
	}
	
}
