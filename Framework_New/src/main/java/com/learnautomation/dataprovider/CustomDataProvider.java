package com.learnautomation.dataprovider;

import org.testng.annotations.DataProvider;

public class CustomDataProvider {


	// if no of row 50 then test case 50 times execute hoga with diff data set
	// no of col : no of parameter test should accept
	
	@DataProvider(name = "loginDataExcel")
	public static Object[][] getLoginDataWithExcel() {
		return ExcelUtility.getDataFromSheet("Login");
		
	}
	
	@DataProvider(name = "newUserDetails")
	public static Object[][] getUserDataWithExcel() {
		return ExcelUtility.getDataFromSheet("UserDetails");
	}

}
