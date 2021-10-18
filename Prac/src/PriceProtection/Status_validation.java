package PriceProtection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Status_validation {

	@Test
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://ordering-backoffice.qa.fleet.ad/login");
		
		driver.findElement(By.xpath("//input[@name = 'username']")).sendKeys("ordsupft11");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys("TestingQA@1234");
		driver.findElement(By.cssSelector("input.btn")).click();
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//div[@id ='side-menu']/ul/li[7]")).click();
		driver.findElement(By.xpath("//div[@data-target = 'PPAQ']")).click();
		////button[@class = 'multiselect dropdown-toggle btn btn-default']
		
//		String defaultStatus = driver.findElement(By.xpath("//button[@class = 'multiselect dropdown-toggle btn btn-default']")).getText();
//		   Assert.assertEquals(defaultStatus, "Active", "Default status is Active");
//		   System.out.println("default check done :" + defaultStatus);
		   
		
		driver.findElement(By.xpath("//button[@id='clear-all-filters-btn']")).click();
		driver.findElement(By.xpath("//button[@class = 'multiselect dropdown-toggle btn btn-default']")).click();
		
		
		
//		Thread.sleep(2000);
		
	    List<WebElement> dropdown = driver.findElements(By.xpath("//ul[@class = 'multiselect-container dropdown-menu']/li/a"));
	    driver.findElement(By.xpath("//button[@class = 'multiselect dropdown-toggle btn btn-default']")).click();
	   /*
	    for (int i = 0; i < dropdown.size(); i++) {
	    	//driver.findElement(By.xpath("//button[@class = 'multiselect dropdown-toggle btn btn-default']")).click();
	    	driver.findElement(By.xpath("//button[@id='clear-all-filters-btn']")).click();
	    	driver.findElement(By.xpath("//button[@class = 'multiselect dropdown-toggle btn btn-default']")).click();
	    	Thread.sleep(2000);
	    	System.out.println("drop down value at: "+ i + dropdown.get(i).getText());
	    	Thread.sleep(2000);
//	    	WebDriverWait t = new WebDriverWait(driver,5); 
//	    	t.until(ExpectedConditions.elementToBeClickable(dropdown.get(i)));  
//	    	t.until(ExpectedConditions.;
	    	
	    	//toSelectStatus(dropdown.get(i).getText(), dropdown.get(i), driver);
	    	if(dropdown.get(i).getText().contains("Active")) {
	    	//Clicking the desired element
	    		toSelectStatus( dropdown.get(i).getText(), dropdown.get(i), driver);
	    	}
	    	else if(dropdown.get(i).getText().contains("Inactive")) {
	    		toSelectStatus( dropdown.get(i).getText(), dropdown.get(i), driver);
	    	}
	    	else if(dropdown.get(i).getText().contains("Select All")) {
	    		toSelectStatus( dropdown.get(i).getText(), dropdown.get(i), driver);
	    	}
	    	
	    	System.out.println("Run from 1");
//	    	Thread.sleep(4000);
	    }
	    */
		for (int i = 0; i < dropdown.size(); i++) {
//			driver.findElement(By.xpath("//button[@id='clear-all-filters-btn']")).click();
	    	driver.findElement(By.xpath("//button[@class = 'multiselect dropdown-toggle btn btn-default']")).click();
			WebElement option1 = dropdown.get(i);
			// String internalText = option.getAttribute("innerHTML");
			String status = dropdown.get(i).getText();
			Thread.sleep(2000);
			System.out.println("value of index  : " + i);
			System.out.println("value of option1  : " + option1);
			System.out.println("value of dropdown  : " + status);
			if (status.equalsIgnoreCase("Active")) {
				toSelectStatus(status, option1, driver);
				System.out.println("Status check for Status AS===============:" + status);
				 Thread.sleep(2000);
				ValidateRecordState(status ,driver);
				driver.findElement(By.xpath("//button[@id='clear-all-filters-btn']")).click();
			} 
			else if (status.equalsIgnoreCase("Inactive")) {
				toSelectStatus(status, option1, driver);
				System.out.println("Status check for Status AS===============:" + status);
				 Thread.sleep(2000);
				ValidateRecordState(status ,driver);
				driver.findElement(By.xpath("//button[@id='clear-all-filters-btn']")).click();
			}
			else if (status.equalsIgnoreCase("Select All")) {
				toSelectStatus(status, option1, driver);
				System.out.println("Status check for Status AS===============:" + status);
				 Thread.sleep(2000);
				ValidateRecordState(status ,driver);
				driver.findElement(By.xpath("//button[@id='clear-all-filters-btn']")).click();
			}
		}

	}

	
	public static void toSelectStatus(String option, WebElement option1, WebDriver driver) throws InterruptedException {
//		driver.findElement(By.xpath("//button[@class = 'multiselect dropdown-toggle btn btn-default']")).click();
//		Thread.sleep(4000);
		option1.click();
		Thread.sleep(4000);
		System.out.println("clicked on Active:" + option);
		driver.findElement(By.xpath("//button[@class = 'multiselect dropdown-toggle btn btn-default']")).click();
    		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='search-by-filters-btn']")).click();
//		 System.out.println("Status check for Status AS===============:" + option);
//		 Thread.sleep(2000);
//		ValidateRecordState(driver);
		
		Thread.sleep(2000);
//		driver.findElement(By.xpath("//button[@id='clear-all-filters-btn']")).click();
		Thread.sleep(4000);
		System.out.println("clear InActive search filter");

	}
	
	public static void ValidateRecordState(String status,WebDriver driver) throws InterruptedException {
		List<WebElement> records = driver.findElements(By.xpath("//td[@data-name='status']"));
		List<String> statusList = new ArrayList<>();
		Thread.sleep(2000);
		for(WebElement rs : records) {
			statusList.add(rs.getAttribute("innerText").trim().replaceAll("\\r\\n|\\r|\\n", " "));
	}
		Thread.sleep(2000);
		boolean allEqual = new HashSet<String>(statusList).size() <= 1;
		if(status.equalsIgnoreCase("Select All")) {
			Assert.assertEquals(allEqual , false , status + "All Status records displayed");
			System.out.println("Status check for Status AS  DONE===============:" + status);
		} else {
			System.out.println("status test allEqual ?" + allEqual);
			Assert.assertEquals(allEqual, true , status + "Status records displayed");
			System.out.println("Status check for Status AS DONE===============:" + status);
		}
	}
	
	
	//boolean allEqual = new HashSet<String>(tempList).size() <= 1;
	
	/*
	 * if(status.equalsIgnoreCase("Inactive")) { option1.click();
	 * System.out.println("clicked on Active"); driver.findElement(By.
	 * xpath("//button[@class = 'multiselect dropdown-toggle btn btn-default']")).
	 * click(); // Thread.sleep(3000);
	 * driver.findElement(By.xpath("//button[@id='search-by-filters-btn']")).click()
	 * ; Thread.sleep(2000);
	 * driver.findElement(By.xpath("//button[@id='clear-all-filters-btn']")).click()
	 * ; System.out.println("clear InActive search filter");
	 * 
	 * } else if(status.equalsIgnoreCase("Select All")) { // toSelect(status,
	 * option1 ,driver ); option1.click(); Thread.sleep(3000);
	 * System.out.println("Select All status selected 3"); driver.findElement(By.
	 * xpath("//button[@class = 'multiselect dropdown-toggle btn btn-default']")).
	 * click(); // Thread.sleep(3000);
	 * driver.findElement(By.xpath("//button[@id='search-by-filters-btn']")).click()
	 * ; System.out.println("clicked on search"); Thread.sleep(2000);
	 * driver.findElement(By.xpath("//button[@id='clear-all-filters-btn']")).click()
	 * ; System.out.println("clear Active search filter");
	 * 
	 * }
	 */

//		}

	/*
	 * 
	 * System.out.println("status can be "+ dropdown.size()); for(int i =1;
	 * i<dropdown.size(); i++) { System.out.println("value of index  : " + i);
	 * WebElement option1 = dropdown.get(i);
	 * 
	 * toSelect("Active", option1 ,driver ); toSelect("InActive", option1 ,driver );
	 * toSelect("Select All", option1 ,driver );
	 * 
	 * String status = dropdown.get(i).getText();
	 * System.out.println("value of dropdown  : " + option1.getText());/*
	 * if(status.equalsIgnoreCase("Inactive")) { // toSelect(status, option1 ,driver
	 * ); option1.click(); //// toSelect("Active" , driver ); Thread.sleep(3000);
	 * System.out.println("Inactive status selected 1");
	 * 
	 * 
	 * System.out.println("clicked on search"); } else
	 * if(status.equalsIgnoreCase("Active")) { // toSelect(status, option1 ,driver
	 * ); option1.click(); Thread.sleep(3000);
	 * System.out.println("Active status selected 2"); driver.findElement(By.
	 * xpath("//button[@class = 'multiselect dropdown-toggle btn btn-default']")).
	 * click(); // Thread.sleep(3000);
	 * driver.findElement(By.xpath("//button[@id='search-by-filters-btn']")).click()
	 * ; System.out.println("clicked on search"); } else
	 * if(status.equalsIgnoreCase("Select All")) { //toSelect(status, option1
	 * ,driver ); System.out.println("All status selected 3"); option1.click();
	 * driver.findElement(By.
	 * xpath("//button[@class = 'multiselect dropdown-toggle btn btn-default']")).
	 * click(); Thread.sleep(1000);
	 * driver.findElement(By.xpath("//button[@id='search-by-filters-btn']")).click()
	 * ; System.out.println("clicked on search"); }
	 */

//	    	toSelect(status, option1 ,driver );

	public static void toSelect(String option, WebElement option1, WebDriver driver) throws InterruptedException {
		List<WebElement> dropdown = driver
				.findElements(By.xpath("//ul[@class = 'multiselect-container dropdown-menu']/li/a"));
		Object element = null;
		switch (option) {
		case "Active":
			System.out.println("Active status case");
			option1.click();
//	    		Thread.sleep(3000);
			System.out.println("Active status selected");
			driver.findElement(By.xpath("//button[@class = 'multiselect dropdown-toggle btn btn-default']")).click();
//	    		Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@id='search-by-filters-btn']")).click();
			;
			System.out.println("clicked on search");
			break;
		case "Inactive":
			option1.click();
			Thread.sleep(2000);
			System.out.println("Inactive status selected");
			driver.findElement(By.xpath("//button[@class = 'multiselect dropdown-toggle btn btn-default']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@id='search-by-filters-btn']")).click();
			;
			System.out.println("clicked on search");
			break;
		case "Select All":
			option1.click();
			Thread.sleep(3000);
			System.out.println(" Select All status selected");
			driver.findElement(By.xpath("//button[@class = 'multiselect dropdown-toggle btn btn-default']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@id='search-by-filters-btn']")).click();
			;
			System.out.println("clicked on search");
			break;
		default:
			System.out.println("Invalid side menu option selected");
		}
	}

}

//	    driver.findElement(By.xpath("//button[@id='search-by-filters-btn']"));

// driver.quit();

//		
//		WebElement openDropdown = driver.findElement(By.xpath("//div[@class='multiselect-wrapper open']"));
//		Select dropdown = new Select(openDropdown);

// WebElement opn = driver.findElement(By.xpath("//div[@class =
// 'multiselect-wrapper open']/ul"));

//		Select dropdown = new Select(opn);

//		dropdown.selectByValue("Active");

//		WebElement selectedvalue = dropdown.getFirstSelectedOption();
//		System.out.println("After selection " + selectedvalue.getText());
//		
//		List<WebElement> statusList1 = dropdown.getOptions();
//		System.out.println("status can be size: " + statusList1.size());
//		
//		for(WebElement ele :statusList1) {
//			System.out.println("status can be : " + ele.getText());
//		}

// OR
//		dropdown.selectByValue("Active");
//		System.out.println("Active selected 1");
//		dropdown.selectByVisibleText("Active");
//		System.out.println("Active selected");

//		WebElement selectedvalue1 = dropdown.getFirstSelectedOption();
//		System.out.println("After selection " + selectedvalue1.getText());
//		
