package French;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SelectClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		

		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://ordering.qa.elementfleet.com/#myPendingActions/fleetSpec");
		
		
		driver.findElement(By.xpath("//input[@name = 'username']")).sendKeys("Bill_QA_Su");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys("testqa12");
		
		driver.findElement(By.id("signinBtn")).click();
		Thread.sleep(2000L);
		driver.findElement(By.id("clientBkdnTextId")).click();
		
		Thread.sleep(2000L);
		String text = driver.findElement(By.xpath("//div[@class='brkDwnHeader']//h3")).getText();
		
		System.out.println("client pop up heading:: " +text);	
		
		Thread.sleep(2000L);
		driver.findElement(By.xpath("//img[@id='flag-image-ca']")).click();
//		flag-image-ca id
		
		driver.findElement(By.id("sByClient")).sendKeys("1791");
		Thread.sleep(2000L);
		//not found --->//div[@class='tt-suggestion tt-selectable empty']
		//Aucun résultat trouvé! 
		String notfound = driver.findElement(By.xpath("//div[@class='tt-suggestion tt-selectable empty']")).getText();
		System.out.println("No results found!: " +notfound);	
		
		Thread.sleep(2000L);
		driver.findElement(By.id("sByClient")).sendKeys(Keys.CONTROL + "a");
		driver.findElement(By.id("sByClient")).sendKeys(Keys.DELETE);
		System.out.println("enter client field cleared");
		
		Thread.sleep(2000L);
		driver.findElement(By.id("sByClient")).sendKeys("9242");
		Thread.sleep(2000L);
		driver.findElement(By.xpath("//div[@class='tt-suggestion tt-selectable tt-client']")).click();
		
		driver.findElement(By.id("clientBkdnSearchCloseId")).click();
//		//div[@class='tt-suggestion tt-selectable tt-client']
		
//        Sélecteur du code de pays et du numéro de client
//		 Numéro de client 
		
		
		driver.findElement(By.id("vehicleConfigId")).click();
		Thread.sleep(2000L);
		driver.findElement(By.xpath("//ul[@id='fleet_submenu']//li[1]")).click();
		// heading ====//p[@class='option-list-title']
		
		List<WebElement> FS = driver.findElements(By.xpath("//div[@id='search-filters']//label[@class='table-filters__field-label']"));
		int size = driver.findElements(By.xpath("//div[@id='search-filters']//label[@class='table-filters__field-label']")).size();
		
		ArrayList<String> tabLabelActual= new ArrayList<String>();
		for(WebElement fs :FS) {
			tabLabelActual.add(fs.getAttribute("innerText").trim().replaceAll("\\r\\n|\\r|\\n", " "));
		}
		ArrayList<String> expected= new ArrayList<String>();
//		expected.add("Liste d’utilisateurs");
		expected.add("Numéro de client");
		expected.add("Profil");
		expected.add("Marque");
		expected.add("Année");
		expected.add("ID de la spéc. du parccc");
		
		
		
//		for(WebElement actual1:FS) {
			for(int i=0;i<5;i++) {
//			for(String expected1: expected) {
				if(expected.contains(FS.get(i).getText())) {
					System.out.println("From Testdata matching***:" +FS.get(i).getText());
					jsGreenBorderHighlighter(FS.get(i), driver);
				}
				else {
					System.out.println("From Testdata not present*********:" +FS.get(i).getText());
					jsRedBorderHighlighter(FS.get(i) ,driver);
				}
//			}
		}
			ArrayList<String> actcol = new ArrayList<String>();
			List<WebElement> web = driver.findElements(By.xpath("//th[@class='data-table__header-cell dt-left sorting']"));
			
//			web.stream().forEach(e->e.isDisplayed());
			
//			for(WebElement col: web) {
			for(int i =0;i<web.size() ; i++) {
				Thread.sleep(3000L);
//				if(col.isDisplayed()) {
				if(web.get(i).isDisplayed()) {
//					actcol.add(col.getText());
					Thread.sleep(3000L);
					jsGreenBorderHighlighter(web.get(i), driver);
					Thread.sleep(3000L);
//					System.out.println("Actual col from UI:"+col.getText());
					System.out.println("Actual col from UI:"+web.get(i).getText());
				}
				else {
					Thread.sleep(2000L);
//					jsScrollRight(col ,driver);
					jsScrollRight(web.get(i) ,driver);
//					jsGreenBorderHighlighter(col, driver);
//					Thread.sleep(3000L);
					System.out.println("Actual col from UI after scroll:"+web.get(i).getText());
				}
			}
			////div[@id='queue-table']//thead//th[contains(text(),'Fleet Specification Status')]
			
//		Assert.assertTrue(tabLabelActual.containsAll(expected), "Mismatch in tabs label");
		
		/*
		for(WebElement act :FS) {	
			for(String exp: expected) {
				if(exp.equals(act.getText())) {
					
//					Assert.assertEquals(act.getText(), exp);
					assertLabelHighlight(act, exp.trim(), 
							"Expected Search Filter Label : " + exp + "Found : " + act.getText(), driver);
//					jsGreenBorderHighlighter(act ,driver);
					System.out.println("From Testdata FR:" +exp );
					System.out.println("From UI FR:" +act);	
				}
			}
		} */
//		System.out.println("From Testdata:" +expected);
//		System.out.println("From UI:" +tabLabelActual);	
//		
//		Assert.assertTrue(tabLabelActual.containsAll(expected), "Mismatch in tabs label");
		
		
		
//		Assert.assertEquals(columnListElement, actualColumnNames);
	}
	
	public static void assertElementHighlight(WebElement webElement, String message, WebDriver driver) {
		try {
			Assert.assertTrue(webElement.isDisplayed(), message);
			jsGreenBorderHighlighter(webElement, driver);
		} catch (AssertionError e) {
			jsRedBorderHighlighter(webElement ,driver);
			e.printStackTrace();
			throw new AssertionError();
		}
	}

	
	/*
	public static void assertLabelHighlight(WebElement webElement, String expectedString, String message ,WebDriver driver) {
		try {
			Assert.assertEquals(webElement.getAttribute("innerText").trim().replaceAll("\u00a0", ""), expectedString, message);
			 System.out.println("found true for green :" +webElement.getAttribute("innerText").trim().replaceAll("\u00a0", ""));
			 System.out.println("expected : "+expectedString);
			jsGreenBorderHighlighter(webElement ,driver);
		} catch (AssertionError e) {
			 System.out.println("RED : "+expectedString);
			jsRedBorderHighlighter(webElement, driver);
			e.printStackTrace();
			throw new AssertionError();
		}
	} */
	public static void jsGreenBorderHighlighter(WebElement webElement, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid green;');", webElement);
	}
	public static void jsRedBorderHighlighter(WebElement webElement, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", webElement);
	}
	
	public static void jsScrollRight(WebElement webElement, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", webElement);
	}
	
}
/*
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://xcelerate2.qa.elementfleet.com/web/common/home");
		
		
		driver.findElement(By.xpath("//input[@name = 'username']")).sendKeys("Bill_QA_Su");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys("testqa12");
		driver.findElement(By.id("signinBtn")).click();
		
		Thread.sleep(7000L); //pop up
		WebElement langPop = driver.findElement(By.xpath("//div[@id='selectLanguageBox']//div[@class='modal-content']"));
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
		Thread.sleep(1000L);
		driver.findElement(By.xpath("//a[@class='vehicleIcon']")).click();
		Thread.sleep(1000L);
		driver.findElement(By.id("headingSeven")).click();
		
		driver.findElement(By.xpath("//a[@title='Commande - Front Office']")).click();
		Thread.sleep(1000L);
		driver.manage().window().maximize();
		
		Thread.sleep(2000L);
		driver.findElement(By.xpath("//a[@class='flag-image __us']")).click();
//		WebElement ele =driver.findElement(By.xpath("//button[@class='btn-default iconClickSlider brkdwnName']"));
//		javascriptClick(ele , driver);
		
		String text = driver.findElement(By.xpath("//div[@class='brkDwnHeader']//h3")).getText();
		
		System.out.println("client pop up heading" +text);
	}

	public static void javascriptClick(WebElement webElement,WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", webElement);
	}
	
}*/
