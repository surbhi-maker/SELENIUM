package CA_Scripts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PriceAndConfigCorp {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://ordering-backoffice.qa.fleet.ad/#vehicleConfig/priceAndConfig/add");

		driver.findElement(By.xpath("//input[@name = 'username']")).sendKeys("ordsup_AT2");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys("TestingQA@1234");
		
//		driver.findElement(By.id("login")).click();
		
		driver.findElement(By.id("signinBtn")).click();
		
		
		driver.findElement(By.xpath(
				"//label[@class='from-scratch-field'][contains(text(),'Corp Code')]//following::div//button[@class='multiselect dropdown-toggle btndropdown btn btn-default']")).click();
		
		
		String defaultCorp = driver.findElement(By.xpath(
				"//label[@class='from-scratch-field'][contains(text(),'Corp Code')]//following::div//button[@class='multiselect dropdown-toggle btndropdown btn btn-default']"))
				.getText();
		
		System.out.println("default selected corp code is before:" +defaultCorp);
	/*	
		List<WebElement> list = driver.findElements(By.xpath("//label[@class='from-scratch-field'][contains(text(),'Corp Code')]//following::div//ul//label[@class='radio']"));
//		WebElement CA = driver.findElement(By.xpath("//label[@class='from-scratch-field'][contains(text(),'Corp Code')]//following::div//ul//li[2]//input[@type='radio']"));
		 System.out.println("0***"+list.get(0).isSelected());
		 System.out.println("1***"+  list.get(1).isSelected());
		 list.forEach(e->System.out.println("elementa are" +e.getText()));
		 
//		WebElement corpcodeElement = driver.findElement(By.xpath("//button[@title='CA']"));
//		 System.out.println("before selection:"+ CA.isSelected());
		for(int i =0; i<list.size();i++) {
			System.out.println(list.get(i).getText());
			if (list.get(i).getText().equals("CA")) {
				if (!list.get(i).isSelected()) {
					Thread.sleep(1000L);
					list.get(i).click();
					System.out.println("After selection:" + "corp CA=>" + list.get(i).getText() + "is" + list.get(i).isSelected());
				} else {
					Thread.sleep(1000L);
					driver.findElement(By.xpath(
							"//label[@class='from-scratch-field'][contains(text(),'Corp Code')]//following::div//button[@class='multiselect dropdown-toggle btndropdown btn btn-default']"))
							.click();
				}
			}
//			}
		}
	*/
		WebElement corp = driver.findElement(By.xpath("//label[@class='from-scratch-field'][contains(text(),'Corp Code')]//following::div//ul//li[2]//label[@title='CA']"));
		if(!corp.isSelected()) {
			corp.click();
			System.out.println("slelected corp"+corp.getText() + "is:"+ corp.isSelected());
		}else {
			Thread.sleep(1000L);
			driver.findElement(By.xpath(
					"//label[@class='from-scratch-field'][contains(text(),'Corp Code')]//following::div//button[@class='multiselect dropdown-toggle btndropdown btn btn-default']"))
					.click();
		}
		
//		driver.findElement(By.xpath("//ul[@id='princeConfig-menu']//a[@class='vehicleConfig vconfig']")).click();
//		WebElement ele = driver.findElement(By.id("vcle__corp_code"));
//		Select select = new Select(ele);
//		select.selectByVisibleText("CA");
	}
	
	
	/*
	 * //div[@id='telematicsMCBWarningMessage']//button[text()=' OK']
	 */
	public static void jsClick(WebElement webElement, WebDriver driver) {
		try {
			webElement.click();
		} catch (Exception e) {
			System.out.println("Log:INFO- Webelement click did not worked try with js click");

			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].click();", webElement);
		}
	}
	
	public static void scrollToBottomOfPage(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver ;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	public static void jsScrollRight(WebElement webElement, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", webElement);
	}
}
