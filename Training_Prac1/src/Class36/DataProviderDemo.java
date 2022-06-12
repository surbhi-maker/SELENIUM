package Class36;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {

	@Test(dataProvider = "loginData")
	public void loginTest(String username, String pass) {

		System.out.println("username is " + username);
		System.out.println("password is" + pass);
	}

	// if no of row 50 then test case 50 times execute hoga with diff data set
	// no of col : no of parameter test should accept
	@DataProvider(name = "loginData")
	public static Object[][] getLoginData() {

		System.out.println("Tets data is being prepared");
		Object[][] arr = new Object[2][2];

		arr[0][0] = "selenium";
		arr[0][1] = "TestNg";
		arr[1][0] = "Java";
		arr[1][1] = "Maven";
		arr[2][0] = "git";
		arr[2][1] = "github";
		
		System.out.println("Tets data is ready");
		return arr;
	}
	
	@DataProvider(name = "getUserData")
	public static Object[][] getUserData() {

		System.out.println("Tets data is being prepared");
		Object[][] arr = new Object[2][2];

		arr[0][0] = "selenium";
		arr[0][1] = "TestNg";
		arr[1][0] = "Java";
		arr[1][1] = "Maven";
		arr[2][0] = "git";
		arr[2][1] = "github";
		
		System.out.println("Tets data is ready");
		return arr;
	}
	
	@DataProvider(name = "getEmpData")
	public static Object[][] getEmpData() {

		System.out.println("Tets data is being prepared");
		Object[][] arr = new Object[2][2];

		arr[0][0] = "selenium";
		arr[0][1] = "TestNg";
		arr[1][0] = "Java";
		arr[1][1] = "Maven";
		arr[2][0] = "git";
		arr[2][1] = "github";
		
		System.out.println("Tets data is ready");
		return arr;
	}
}
