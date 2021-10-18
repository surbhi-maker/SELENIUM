package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FluentWait {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.get("https://the-internet.herokuapp.com/dynamic_loading");
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.manage().window().maximize();
//		WebDriverWait w = new WebDriverWait(driver, 5);
		
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//driver.findElement(By.xpath("//div[@id=\"content\"]/div/a[1]")).click();
		
		
		driver.findElement(By.xpath("//*[@id=\"start\"]/button")).click();
		
//		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"finish\"]/h4")));
		
		driver.findElement(By.xpath("//*[@id=\"finish\"]/h4")).getText();
		
//		System.out.println(driver.findElement(By.xpath("//*[@id=\"finish\"]/h4")).getText());
		
		

	}

}
