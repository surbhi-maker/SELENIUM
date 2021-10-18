package Stream;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class searchFileterGreenKart {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		
		// 1 result
		List<WebElement> veggies = driver.findElements(By.xpath("//table[@class = 'table table-bordered']/tbody/tr/td[1]"));
		
		//filtered results
		List<WebElement> veggiesFiltered  = veggies.stream().filter(s->s.getText().contains("Rice")).collect(Collectors.toList());
		
		Assert.assertEquals(veggies, veggiesFiltered);
		if(veggies.equals(veggiesFiltered)) {
			System.out.println("search filter is worrking");
		}
	}

}
