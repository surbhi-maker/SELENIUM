package WindowAuth;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowAutoHandle {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\new_driver_1\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		//https://the-internet.herokuapp.com/
		driver.get("https://admin:admin@the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Basic Auth")).click();
	}

}
