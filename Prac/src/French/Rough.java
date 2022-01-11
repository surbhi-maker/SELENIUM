package French;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Rough {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	
		ArrayList<String> actual= new ArrayList<String>();
		actual.add("Liste d’utilisateurs");
		actual.add("Numéro de client");
		actual.add("ID de la spéc. du parccc");
//		actual.add("abcd");


		ArrayList<String> expected= new ArrayList<String>();
		expected.add("Liste d’utilisateurs");
		expected.add("Numéro de client");
		expected.add("ID de la spéc. du parccc99");
		
		
		System.out.println("************************size:"+expected.size());
		if(actual.equals(expected)) {
			System.out.println("not matching");
		}
		System.out.println(actual.containsAll(expected));
		
		
		for(String actual1:actual) {
			for(String expected1: expected) {
				if(actual1.contains(expected1)) {
					
				}
			}
		Assert.assertTrue(actual.containsAll(expected), "Mismatch in tabs label");
		
	}

}
}