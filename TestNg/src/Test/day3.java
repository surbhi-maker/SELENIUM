package Test;

import org.testng.annotations.Test;

//includeTest and exclude parameters
public class day3 {
	
	@Test
	public void Demo()
	{
		System.out.println("hello day3");//automation
		
	}
	@Test
	public void includeTest()
	{
		System.out.println("hello day2: includeTest");
	}
	@Test
	public void secTest()
	{
		System.out.println("hello day2: secTest");
	}
	
	
}
