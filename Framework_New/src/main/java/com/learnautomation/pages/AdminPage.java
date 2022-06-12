package com.learnautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.learnautomation.helper.Utility;

public class AdminPage {

	WebDriver driver;

	public AdminPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By addUser = By.name("btnAdd");
	
	By userRole = By.xpath("//select[@id='systemUser_userType']");
	
	By empName = By.xpath("//input[@id='systemUser_employeeName_empName']");
	
	By username = By.xpath("//input[@id='systemUser_userName']");
	By password = By.xpath("//input[@id='systemUser_password']");
	
	By meter = By.xpath("//span[@id='systemUser_password_strength_meter']");
	By confirmpwd = By.id("systemUser_confirmPassword");
	
	By save = By.id("btnSave");
	
	By successMsg = By.xpath("//*[contains(text(), 'Successfully Saved') and @class]");
	
	public boolean createUser(String userRol , String empNm , String uname, String status ,String pwd, String cnfmPwd) {
		
		boolean userStatus = false;
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(addUser));
		driver.findElement(addUser).click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(userRole));
		Utility.selectFromDropDownUsingText(driver, userRole, userRol);
		driver.findElement(empName).sendKeys(empNm);
		driver.findElement(username).sendKeys(uname);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(confirmpwd).sendKeys(cnfmPwd);
		
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(meter));
		
		if(Utility.waitForWebElement(meter, driver).isDisplayed()) {
			System.out.println("before saving the elelement");
//			driver.findElement(save).click();
			Utility.jsClick(save, driver);
			System.out.println("After saving the elelement");
		}
		
//		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(successMsg));
		
		if(Utility.waitForWebElement(successMsg, driver).isDisplayed()) {
			
			System.out.println("After saving the elelement => success msg displayes");
			userStatus = true;
		}
		
		return userStatus;
		
	}
}
