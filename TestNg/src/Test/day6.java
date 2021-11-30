package Test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
//dependsOnMethods
//Enable = false means just skip the test cases
//Enable = true run the test cases
public class day6 {
	
	@Parameters({ "URL" })
	@Test
	public void WebloginHomeLoan(String uname)
	{
		System.out.println("webloginhomePersonalLoan");
		System.out.println(uname);
	}
	
	@Parameters({ "URL" , "Surbhi" , "username"})
	@Test
	public void WebloginHomeLoan(String uname,String name , String username )
	{
		System.out.println("webloginhomePersonalLoan");
		System.out.println(uname);
		System.out.println(name);
		System.out.println(username);
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[3][2];
		
		data[0][0]="1st username";
		data[0][1]="1st password";
		
		data[1][0]="2nd username";
		data[1][1]="2nd password";
		
		data[2][0]="3rd username";
		data[2][1]="3rd password";
		
		return data;
	}
	
	@Test(dataProvider = "getData")
	public void method(String username, String password) {
		System.out.println(username);
		System.out.println(password);
	}
	
//	@Test
//	public void FailedTestCase()
//	{	
//		System.out.println("************************************************************");
//		System.out.println("hello day6: FailedTestCase");
//		Assert.assertTrue(false);
//	}
}
