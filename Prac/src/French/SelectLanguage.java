package French;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectLanguage {

	@Test
	public static void selectEnglishLanguagePopupIfDisplayed() throws Exception {
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://xcelerate.qa.elementfleet.com/web/common/doLogin");
		
		
		driver.findElement(By.xpath("//input[@name = 'username']")).sendKeys("Bill_QA_Su");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys("testqa12");
		driver.findElement(By.id("signinBtn")).click();
		driver.manage().window().maximize();
		
		WebElement langPop = driver.findElement(By.xpath("//div[@id='selectLanguageBox']//div[@class='modal-content']"));
//		Thread.sleep(7000L);
//		WebElement langPopDisplay = new WebDriverWait(driver, new Long(4000))
//				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='selectLanguageBox']//div[@class='modal-content']")));
		
		System.out.println("MODAL window displayed");	
		if(langPop.isDisplayed()) {
			WebElement wait = new WebDriverWait(driver, new Long(10))
					.until(ExpectedConditions.elementToBeClickable(By.xpath(
							"//div[@id='selectLanguageBox']//button[@id='no']")));
			if (wait != null) {
				driver.findElement(By.xpath("//div[@id='selectLanguageBox']//button[@id='no']")).click();
				System.out.println("Selected French as language *************" + wait);
			}
		}
			else {
				System.out.println("**********************Select Language popup is not present ********************");
				System.out.println("click on setting");
				driver.findElement(By.xpath("//a[@data-sectionid='settingsSlidMenu']")).click();
				Thread.sleep(2000L);
				driver.findElement(By.xpath("//a[@title='Preferences']")).click();
				System.out.println("clicked on setting");
				scrollToBottomOfPage(driver);
				System.out.println("select french setting");
				WebElement frenchRadio = driver.findElement(By.xpath("//input[@value='fr-ca']"));
				System.out.println("flag frenchRadio1:"+ frenchRadio.isSelected());
				
				if(!frenchRadio.isSelected()) {
					System.out.println("flag frenchRadio.isSelected() before:"+ frenchRadio.isSelected());
					Assert.assertFalse(frenchRadio.isSelected(), "french is not selected true");
					frenchRadio.click();
					Thread.sleep(2000L);
					System.out.println("flag frenchRadio.isSelected() After:"+ frenchRadio.isSelected());
//					Assert.assertFalse(frenchRadio.isSelected(), "french is not selected true");
				}
				
				Thread.sleep(2000L);
				driver.findElement(By.xpath("//a[@href='/web/common/home']")).click();
			}
		
		

	}
	
	public static void scrollToBottomOfPage(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver ;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
}
