package Class36;

import org.testng.annotations.Test;

public class DataProviderDemo2 {

	@Test(dataProvider = "loginData" , dataProviderClass = CustomDataProvider.class)
	public void loginTest(String username, String pass) {

		System.out.println("username is " + username);
		System.out.println("password is" + pass);
	}

}
