package Window;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://jqueryui.com/");
	driver.manage().window().maximize();
	
	System.out.println(driver.findElements(By.tagName("a")).size());

		//links count in footer
	
	//footer.clearfix.simple
	WebElement footerdriver = driver.findElement(By.cssSelector("footer.clearfix.simple"));
	footerdriver.findElements(By.tagName("a")).size();
	
	System.out.println(footerdriver.findElements(By.tagName("a")).size());

	}

}

//https://www.functionize.com/selenium-alternatives/