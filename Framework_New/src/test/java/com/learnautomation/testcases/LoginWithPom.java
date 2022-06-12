package com.learnautomation.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.learnautomation.base.BaseClass;
import com.learnautomation.dataprovider.CustomDataProvider;
import com.learnautomation.pages.DashboardPage;
import com.learnautomation.pages.HomePage;


public class LoginWithPom extends BaseClass{

	HomePage home;
	DashboardPage dash ;
	
		@Test(priority =1 , dataProvider ="loginDataExcel" , dataProviderClass = CustomDataProvider.class)
		public void loginWithAdmin(String uname , String pass) {
			home = new HomePage(driver); // or PageFactory.initElement(driver , HomaPage.class);
			dash = home.loginWithAdmin(uname, pass);
			Assert.assertTrue(dash.getCurrentURL().contains("dashboard") , "login failed");
			
			dash.logoutFromApplication();
			Assert.assertTrue(dash.getCurrentURL().contains("login") , "logout did not complete");
		}
		
		
}
