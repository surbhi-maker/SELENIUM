package com.learnautomation.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.learnautomation.base.BaseClass;
import com.learnautomation.dataprovider.CustomDataProvider;
import com.learnautomation.pages.AdminPage;
import com.learnautomation.pages.DashboardPage;
import com.learnautomation.pages.HomePage;


public class CreateUser extends BaseClass{

	HomePage home;
	DashboardPage dash ;
	AdminPage admin;
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUpWebDriver() {
		driver = getDriver();
	}
	
		@Test(priority =1 , dataProvider ="loginDataExcel" , dataProviderClass = CustomDataProvider.class)
		public void loginWithAdmin(String uname , String pass) {
			home = new HomePage(driver); // or PageFactory.initElement(driver , HomaPage.class);
			dash = home.loginWithAdmin(uname, pass);
			Assert.assertTrue(dash.getCurrentURL().contains("dashboard") , "login failed");
			
		}
		
		@Test(priority = 2 , dataProvider ="newUserDetails" , dataProviderClass = CustomDataProvider.class)
		public void createUser(String userRole , String empName , String userName ,String status, String passwrd,  String confirmPwd) {
			admin = dash.clickOnAdminPage();
			boolean result = admin.createUser(userRole, empName, userName, status, passwrd , confirmPwd);
			
			Assert.assertTrue(result , "user creation failed");
		}

		
		@Test(priority = 3 , dependsOnMethods ="createUser")
		public void logoutFromApplication() {
			dash.logoutFromApplication();
			Assert.assertTrue(dash.getCurrentURL().contains("login") , "logout did not complete");
		}
		
		
}
