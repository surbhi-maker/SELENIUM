package Class17;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestion {
	
	public static void main(String[] args) throws InterruptedException {
	
	System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://www.google.com");
	driver.findElement(By.name("q")).sendKeys("Mukesh Oatwani");
	Thread.sleep(2000L);
	////div[@role='option']
	List<WebElement> allValue = driver.findElements(By.xpath("//ul[@role='listbox']//li[@role = 'presentation']//div[@role='option']"));
	driver.manage().window().maximize();
	
	for(WebElement ele : allValue) {
		System.out.println(ele.getText());
		if(ele.getText().contains("api testing")){
			ele.click();
			break;
		}
	}
	}
	
//	http://seleniumpractise.blogspot.com/2016/08/how-to-handle-autocomplete-feature-in.html
}
