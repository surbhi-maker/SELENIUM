package Stream;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GreenKartTableSorting {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().window().maximize();
		//IMPLICIT WAIT
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//click on a column
		driver.findElement(By.xpath("//table[@class = 'table table-bordered']/thead/tr/th[1]")).click();
		
		//get the list of element
		List<WebElement> elementlist = driver.findElements(By.xpath("//table[@class = 'table table-bordered']/tbody/tr/td[1]"));
		List<String> origionalList = elementlist.stream().map(s->s.getText()).collect(Collectors.toList());
		origionalList.stream().forEach(s->System.out.println("elements in list :" + s));
		
		//sort the original list
		List<String> sortedList = origionalList.stream().sorted().collect(Collectors.toList());
		
		//verify results
		assertEquals(origionalList, sortedList, "list not sorted properly");
		if(origionalList.equals(sortedList)) {
			System.out.println("both lists are equals means soted in same order");
		}
		
		//print price of rice
//		elementlist.forEach(s->System.out.println(s.getText()));
		List<String> priceList;
		do {
			List<WebElement> pageElement = driver.findElements(By.xpath("//table[@class = 'table table-bordered']/tbody/tr/td[1]"));
			priceList = pageElement.stream().filter(t -> t.getText().contains("Rice")).map(t -> getPriceVeggie(t))
					.collect(Collectors.toList());
			priceList.forEach(a -> System.out.println(a));
			if (priceList.size() < 1) {
				driver.findElement(By.cssSelector("[aria-label='Next']")).click();
			}
		} while (priceList.size() < 1);
	}

	private static String getPriceVeggie(WebElement t) {
		System.out.println("price of vaggies");
		String priceOfveg = t.findElement(By.xpath("following-sibling ::td[1]")).getText();   //@@@@@@@@Accessing sibling Element@@@@@@@@@@@@@22
		System.out.println("price of rice : " + priceOfveg);
		return priceOfveg;
	}
	
	
}
