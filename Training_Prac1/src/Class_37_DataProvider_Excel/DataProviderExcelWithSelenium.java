package Class_37_DataProvider_Excel;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Class36.CustomDataProvider;
import utilityPackage.BaseClass;

public class DataProviderExcelWithSelenium extends BaseClass {

	/*
	 * @Test public void loginTest() { System.out.println("username is " );
	 * System.out.println("password is " ); }
	 */
	
	@Test(dataProvider = "loginDataExcel" , dataProviderClass = CustomDataProvider.class)
	public void loginTest(String username, String pass) {
		System.out.println("loginTest username is " + username);
		System.out.println("loginTest password is " + pass);

		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(pass);
		driver.findElement(By.id("btnLogin")).click();

		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "login failed");
	}

}
