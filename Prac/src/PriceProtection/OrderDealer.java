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

public class OrderDealer {
//		https://ordering-qa3.qa.elementfleet.com/#editOrder/3009940
			public static void main(String[] args) {
			System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://ordering-qa3.qa.elementfleet.com/#editOrder/3009940");
			
			driver.findElement(By.xpath("//input[@name = 'username']")).sendKeys("ordsupft11");
			driver.manage().window().maximize();
			driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys("TestingQA@1234");
			driver.findElement(By.id("signinBtn")).click();
			driver.manage().window().maximize();
			
			
			driver.findElement(By.xpath("//a[@title= 'Dealer']")).click();
			driver.findElement(By.xpath("//a[@id= 'selectDiffDealer']")).click();
			
			WebElement state2 = driver.findElement(By.cssSelector("div.form-group.row div.ownDealerInfo div.form-group.row div.form-row:nth-child(2) div.form-group.col-md-3:nth-child(2) > label.block"));
			
			WebElement state  = driver.findElement(By.xpath("//label[contains(text() , 'State')]"));
			System.out.println("State entry string :" + state.getAttribute("innerText"));
			System.out.println("State entry string :" + state.getAttribute("innerHTML"));
			System.out.println("State entry string :" + state.getText());
//			assertLabelHighlight(state,"State/Province", "State label not matched" ,driver);
			assertLabelHighlight(state2,"State/Province", "State label not matched" ,driver);
			}
			
			public static void assertLabelHighlight(WebElement state2, String expectedString, String message , WebDriver driver) {
				System.out.println("State entry string inside assertLabelHighlight: " + state2.getAttribute("innerText"));
				try {
					Assert.assertEquals(state2.getAttribute("innerText").trim().replaceAll("\u00a0", ""), expectedString, message);
					jsGreenBorderHighlighter(state2 , driver);
				} catch (AssertionError e) {
					jsRedBorderHighlighter(state2 , driver);
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


