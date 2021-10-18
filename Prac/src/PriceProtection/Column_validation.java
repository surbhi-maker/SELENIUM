package PriceProtection;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Column_validation {

	public static void main(String[] args) {
		////div[@id='queue-table']//div[@class='dataTables_scrollHeadInner']//th[not(contains(@class, 'sorting_disable'))]
		
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://ordering-backoffice.qa.fleet.ad/login");
		
		driver.findElement(By.xpath("//input[@name = 'username']")).sendKeys("ordsupft11");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys("TestingQA@1234");
		driver.findElement(By.cssSelector("input.btn")).click();
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//div[@id ='side-menu']/ul/li[7]")).click();
		driver.findElement(By.xpath("//div[@data-target = 'PPAQ']")).click();
		////button[@class = 'multiselect dropdown-toggle btn btn-default']
		
		List<WebElement> col = driver.findElements(By.xpath("//div[@id='queue-table']//div[@class='dataTables_scrollHeadInner']//th[not(contains(@class, 'sorting_disable'))]"));
		
//		for(int i = 0; i<col.size() ; i++) {
//			String value =  col.get(i).getText().trim().replaceAll("\\r\\n|\\r|\\n", " ");
//			System.out.println("value at index :" + i +value);
//			
//		}
		ArrayList<String> actualColumnNames = new ArrayList<>();
		for(WebElement ele : col) {
			actualColumnNames.add(ele.getAttribute("innerText").trim().replaceAll("\\r\\n|\\r|\\n", " "));
			System.out.println("value at index :" + actualColumnNames);
		}
		for(int i = 0; i<actualColumnNames.size() ; i++) {
			System.out.println("actualColumnNames at index :" + actualColumnNames.get(i));
		}
		
//		Assert.assertEquals(expectedColumnNames, actualColumnNames);
	}
}
//			String val = col.get(5).getText().trim().replaceAll("\\r\\n|\\r|\\n", " ");
//			
//			System.out.println("formatted string :" +val ); 
//		}
//		ArrayList<String> actualColumnNames = new ArrayList<>();
//		for (WebElement e : col) {
//			actualColumnNames.add(e.getAttribute("innerText").trim().replaceAll("\\r\\n|\\r|\\n", " "));
//		}
	


