package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import objectRepository.RediffHomePage;
import objectRepository.RediffHomePagePFactory;
import objectRepository.RediffLoginPage;

public class LOginApplication {
	
	@Test
	public void Login() throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		RediffLoginPage rd = new RediffLoginPage(driver);
		rd.emailId().sendKeys("hello");
		rd.password().sendKeys("Dream@88");
		rd.submit().click();
		rd.homepage().click();
		
		
		RediffHomePage hp = new RediffHomePage(driver);
		hp.search().sendKeys("mobile");
		Thread.sleep(2000L);
		hp.selectFirst().click();
		
		//***********************PAGE OBJECT FACTORY************
		Thread.sleep(2000L);
		RediffHomePagePFactory PF = new RediffHomePagePFactory(driver);
		PF.signin().click();	
		PF.emailEnter().sendKeys("surbhi@");
		Thread.sleep(2000L);
		PF.passwordEnter().sendKeys("pass");
		Thread.sleep(2000L);
		PF.login().click();
		
	}
}
