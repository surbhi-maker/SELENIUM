package Class_40_testUsing_POM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.HomePage;
import utilityPackage.Utility;

public class LoginWithPagePOM {
	
	@Test
	public void checkSocialCount() {
		 System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.get("https://opensource-demo.orangehrmlive.com/");
		 
		 HomePage home = PageFactory.initElements(driver, HomePage.class); //PageFactory  <=> new HomePage
		 
		 Assert.assertEquals( home.countSoacialMediaLinks(), 4);
		 Utility.closeBrowser(driver);
	}
	
	@Test
	public void loginToApplication() {
		 System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.get("https://opensource-demo.orangehrmlive.com/");
		 
		 HomePage home = PageFactory.initElements(driver, HomePage.class);
		 DashboardPage dash = home.loginWithAdmin("admin", "admin123");
		 Assert.assertTrue(dash.getWelcomeText().contains("Welcome"), "login failed=> welcome text doesnot appeared");
		 
		 dash.logoutFromApplication();
		 Assert.assertTrue(home.getCurrentUrl().contains("login"));
		 Utility.closeBrowser(driver);
	}
	
	
}
