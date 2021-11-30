package Test;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class day4 {
	
	@Test
	public void Demo()
	{
		System.out.println("hello day4");//automation
		
	}
	
	@BeforeSuite   //sbse pehle yahi run hoga
	public void BeforeSuite()
	{
		System.out.println("I am the no 1 from first : @BeforeSuite");
	}
	
	@Test(groups = {"smoke"})
	public void smokeTestFromDay4()
	{
		System.out.println("1st smokeTestFromDay4 ");
		
	}
}
