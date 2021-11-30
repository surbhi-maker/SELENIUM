package Test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


//@AfterTest @BeforeTest
//groups --runs after everyBuid

//*****************************Either grouping or Include will work ...include gets preference
public class day2 {
	
	@Test(groups = {"smoke"})
	public void smokeTestFromDay2()
	{
		System.out.println("2nd smokeTestFromDay2 ");
		
	}
	
	@Test
	public void includeTestday2()
	{
		System.out.println("hello day2: includeTestday2");
	}
	
	@Test
	public void Demo()
	{
		System.out.println("hello day2: 1");//automation
		
	}
		
	@AfterTest //runs before AfterSuite
	public void lastexecution()
	{
		System.out.println("I will execute last  day2:@AfterTest");
		
	}
	
	@Test
	public void secTest()
	{
		System.out.println("hello day2: bye");
	}
	
	@Test
	public void ExcludeTest()
	{
		System.out.println("hello day2: ExcludeTest");
	}
	@BeforeTest  //run after before suite
	public void preRequisteexecution()
	{
		System.out.println("I will execute last  day2 :@BeforeTest");
		
	}
}
