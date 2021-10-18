package Window;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LinksCheck {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.functionize.com/selenium-alternatives/");
		driver.manage().window().maximize();

		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//total links
		//System.out.println(driver.findElements(By.tagName("a")).size());
		
		//links in the footer
		WebElement footerdriver = driver.findElement(By.cssSelector("div.container"));
		//System.out.println(footerdriver.findElements(By.tagName("a")).size());
		
		//list of links and check if they are valid links are not
		WebElement columndriver = footerdriver.findElement(By.xpath("//*[@id=\"fzbody\"]/footer/div/div/div[2]/div[1]/div[1]/div/ul[1]"));
		System.out.println(columndriver.findElements(By.tagName("a")).size());
		//System.out.println(columndriver.getText());
		
		
		//check
		for (int i = 0; i<columndriver.findElements(By.tagName("a")).size() ; i++){
			
			String clickonLink = Keys.chord(Keys.CONTROL,Keys.ENTER);
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonLink);
			
		}
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		
		int j = 0;
		while(it.hasNext()) {	
		String nextLink = it.next();
		String title  = driver.switchTo().window(nextLink).getTitle();
		System.out.println("title at index: " + j + " is: " + title);
		if(j==9) {
			System.out.println("all links working");
		}
			j++;
		}
		
	}

}
