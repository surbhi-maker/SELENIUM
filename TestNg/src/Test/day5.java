package Test;

import org.testng.annotations.Test;
//dependsOnMethods
//Enable = false means just skip the test cases
//Enable = true run the test cases
public class day5 {
	
	@Test
	public void Demoday5()
	{
		System.out.println("hello day5 execution Starts here*******");//automation
	}
	
	@Test(dependsOnMethods = ("Demoday5"))
	public void dependOnday5()
	{
		System.out.println("day5 mehtod:dependsOnMethods Demoday5 ");
	}
	
	@Test(dependsOnMethods = {"Demoday5" , "dependOnday5"})
	public void dependOndayPre()
	{
		System.out.println("day5 mehtod:dependsOnMethods Demoday5 and dependOnday5");
	}
	
	@Test(enabled = false)
	public void enablesFalseDay5()
	{
		System.out.println("hello day5");
	}
	
	@Test(enabled = true)
	public void enablesTrueDay5()
	{
		System.out.println("hello day5  execution ends here*********");
	}
}
