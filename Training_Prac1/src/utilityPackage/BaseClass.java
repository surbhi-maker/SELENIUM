package utilityPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setUP() {
		 System.out.println("Log:INFO - Browser getting ready");
		 System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
			System.out.println("Log:INFO - browser Started : @BeforeMethod /****************");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		System.out.println("Log:INFO - browser closed: @AfterMethod*****************/");
	}
	
}
