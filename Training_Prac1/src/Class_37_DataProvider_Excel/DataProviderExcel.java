package Class_37_DataProvider_Excel;

import org.testng.annotations.Test;

import Class36.CustomDataProvider;

public class DataProviderExcel {

	@Test(dataProvider = "loginDataExcel" , dataProviderClass = CustomDataProvider.class)
	public void loginTest(String username, String pass) {

		System.out.println("username is " + username);
		System.out.println("password is" + pass);
	}

}
