package Class_39_ExtentReport_Listener;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Sample_Test {

		@Test
		public void test1() {
			
			System.out.println("login ");
		}
		
		@Test
		public void test2() {
			
			System.out.println("Payment done ");
		}
		
		@Test
		public void test3() {
			Assert.assertTrue(false);
			System.out.println("payment processing");
		}
		
		@Test(dependsOnMethods ="test3")
		public void test4() {
			
			System.out.println("logout done ");
		}
		
}
