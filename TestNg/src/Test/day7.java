package Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//Test
//BeforeClass and AfterClass
//BeforeSuite and AfterSuite
public class day7 {


		// TODO Auto-generated method stub
//	@AfterTest
//	public void lastexecution()
//	{
//		System.out.println("I will execute last");
//		
//	}
	
	@BeforeMethod
	public void BeforeMethod()
	{
		System.out.println("hello @BeforeMethod /*****************");//automation
		
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("hello @AfterMethod **************/");//automation
		
	}
	
	@Test
	public void Demo()
	{
		System.out.println("hello");//automation
		
	}
	@AfterSuite
	public void afSuite()
	{
		System.out.println("I am the no 1 from last: @AfterSuite ");
	}
	@Test
	public void SecondTest()
	{
		System.out.println("bye");
	}
	
	@BeforeClass
	public void day1BeforeClass()
	{
		System.out.println("day1BeforeClass runs/+++++++++++++++++");//automation
		
	}
	@AfterClass
	public void day1AfterClass()
	{
		System.out.println("day1AfterClass runs +++++++++++++++++++/");//automation
		
	}
	
	@Test(groups = {"smoke"})
	public void smokeTestFromDay1()
	{
		System.out.println("3rd smokeTestFromDay1 ");
		
	}
	
	
}
