package Window;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarDyHandling {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companions");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id = 'travel_date']")).click();
		
		while(!driver.findElement(By.cssSelector("[class = ' table-condensed'] [class = 'datepicker-switch']")).getText().contains("October")) {
			System.out.println("not an October 2021");
			driver.findElement(By.cssSelector("[class = ' table-condensed']  [class = 'next']")).click();
		}
		
		List<WebElement> dates = driver.findElements(By.xpath("//td[@class = 'day']"));
		int count = dates.size();
		
		System.out.println(count);
		for(int i =0 ; i<count ; i++) {
			//System.out.println("i at before "+ i);
			String text = driver.findElements(By.xpath("//td[@class = 'day']")).get(i).getText();
			System.out.println(text);
			if(text.equalsIgnoreCase("30")){
				System.out.println(text);
				System.out.println("i at "+ i);
				driver.findElements(By.xpath("//td[@class = 'day']")).get(i).click();
				break;
			}
		}
	}

}
