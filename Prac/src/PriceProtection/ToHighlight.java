package PriceProtection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ToHighlight {

	public static void main(String[] args) {
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
		List<String> filterList = Arrays.asList("Model", "Status" ,"Trim" ,  "Model Code");

		List<WebElement> filterLabelList = driver.findElements(By.cssSelector("label.table-filters__field-label"));
		
//		List<WebElement> filterLabelList2 = driver.findElements(By.cssSelector("label.table-filters__field-label"));
		
		ArrayList<String> actualColumnNames = new ArrayList<>();
		for(int i=0; i<filterLabelList.size(); i++) {
			
//			actualColumnNames.add(filterLabelList.get(i).getText());
//			if(((filterLabelList.get(i)).equals(filterLabelList2.get(i)))) {
				System.out.println("found actual: " +filterLabelList.get(i).getText().replaceAll("\\r\\n|\\r|\\n", " "));
//			assertLabelHighlight(filterLabelList.get(i), filterList.get(i), "Expected Search Filter Label : " + filterLabelList.get(i) + "Found : " + filterList.get(i).trim() ,driver);
//			}
				
		}
		
//		for(String filterList_fld : filterList) {
//	        for(WebElement filterLabelList_fld : filterLabelList) {
//	            if(filterList_fld.equals(filterLabelList_fld.getText())) {
//	                assertLabelHighlight(filterLabelList_fld,filterList_fld.trim() , "Expected Search Filter Label : " + filterList+ "Found : " + filterLabelList ,driver);
//	            }
//	        }
//	    }  
		
		
		
		
		
		for(String filterList_fld : filterList) {
			System.out.println("sbse pehle _expected for highlight : "+filterList_fld + "index : "+ filterList.indexOf(filterList_fld));
	        boolean found = false;
	        for(WebElement filterLabelList_fld : filterLabelList) {
//	            if(filterList_fld.contains(filterLabelList_fld.getText())) {
			if (filterList_fld.equals(filterLabelList_fld.getText())) {
//				String formating = filterLabelList_fld.getText().replaceAll("\\s", "");
//				System.out.println("Actual new  for highlight :" + formating);
				System.out.println("sbse pehle2 Actual for highlight : " + filterLabelList.indexOf(filterLabelList_fld));
				found = true;
				System.out.println("found true" + found);
				System.out.println("Actual for highlight : " + filterLabelList_fld.getAttribute("innerHTML"));
				System.out.println("expected for highlight : " + filterList_fld);
				assertLabelHighlight(filterLabelList_fld, filterList_fld.trim(),
						"Expected Search Filter Label : " + filterList + "Found : " + filterLabelList, driver);
				break;
			}
	        }
	        if (!found) {
	        	System.out.println(" not found" +found);
	        }
	    }    
	}
	
	

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
	}
	public static void jsGreenBorderHighlighter(WebElement webElement, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid green;');", webElement);
	}
	public static void jsRedBorderHighlighter(WebElement webElement, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", webElement);
	}

}
