package com.learnautomation.helper;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Utility {

	public static String takeScreenShotOfWebElement(WebDriver driver, WebElement element) throws IOException {
		// D:\Users\SKourav\copy\Training_Prac1\Screenshots
		File src = element.getScreenshotAs(OutputType.FILE);
		String ScreenshotPath = System.getProperty("user.dir") + "\\screenshots\\Selenium" + captureDateTime() + ".png";
		FileHandler.copy(src, new File(ScreenshotPath));
		return ScreenshotPath;
	}

	public static String takeFullPageScreenShot(WebDriver driver) throws IOException {
		String Path = System.getProperty("user.dir") + "\\screenshots\\SeleniumComplete" + captureDateTime() + ".png";
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
				.takeScreenshot(driver);
		ImageIO.write(screenshot.getImage(), "png", new File(Path));
		return Path;

	}

	public static void selectValueFromSuggestion(WebDriver driver, By locator, String valueToSelect) {
		List<WebElement> allValue = driver.findElements(locator);
		driver.manage().window().maximize();
		System.out.println("Value is :" + allValue.size());
		for (WebElement ele : allValue) {
			String value = ele.getText();
			System.out.println(value);
			if (value.equalsIgnoreCase(valueToSelect)) {
				ele.click();
				break;
			}
		}
	}

	// Formate my current date
	public static String captureDateTime() {
//		Date todaysDate = new Date();
//		System.out.println(todaysDate);
		SimpleDateFormat newFormat = new SimpleDateFormat("dd_mm_yyyy_HH_mm_ss");
		System.out.println(newFormat.format(new Date()));
		return newFormat.format(new Date());
	}

	public static void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
		System.out.println("Alert accepted");
	}

	public static void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public static String captureAlertTextAndAceept(WebDriver driver) {
		Alert alt = driver.switchTo().alert();
		String alt_text = alt.getText();
		return alt_text;
	}
	
	//Switching frame with differt arg
	public static <AnyType> void switchToFrame(WebDriver driver , AnyType element) {
		System.out.println(element.getClass().getName());
		if(element.getClass().getName().contains("Integer")) {
			driver.switchTo().frame((int) element);
		}
		else if(element.getClass().getName().contains("String")) {
			driver.switchTo().frame ((String) element);
		}
		else
		{
			driver.switchTo().frame((WebElement)element);
		}
	}
	
	public static void switchToParentFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public static void jsClick(By locator, WebDriver driver) {
		try {
			WebElement element =waitForWebElement(locator ,driver );
			element.click();
		} catch (Exception e) {
			System.out.println("Log:INFO- Webelement click did not worked try with js click");
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].click();", waitForWebElement(locator ,driver ));
		}
	}
	
	public static WebElement waitForWebElement(By locator, WebDriver driver) {
		 WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(locator));
		 highLightElement(driver, ele);
		 return ele;
	}
	
	private static void highLightElement(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;');", ele);
		
		try {
			Thread.sleep(1000);
		}
		catch(InterruptedException e){
			System.out.println(e.getMessage());
		}
		js.executeScript("arguments[0].setAttribute('style','border: 2px solid white;');", ele);
	}

	public static void enterText(By locator, WebDriver driver ,String text) {
		try {
			waitForWebElement(locator ,driver).sendKeys(text);
		} catch (Exception e) {
			System.out.println("Log:INFO- Webelement send Key does not worked try with js click");
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].value=arguments[1];", waitForWebElement(locator ,driver) ,text);
		}
	}
	
	public static void selectFromDropDownUsingText(WebDriver driver ,By locator ,String valueToBeSelected) {
		
		Select dropDown = new Select(driver.findElement(locator));
		dropDown.selectByVisibleText(valueToBeSelected);
	}
	public static void selectFromDropDownUsingValue(WebDriver driver ,By locator ,String valueToBeSelected) {
			
			Select dropDown = new Select(driver.findElement(locator));
			dropDown.selectByValue(valueToBeSelected);
			
		}
	public static void selectFromDropDownUsingIndex(WebDriver driver ,By locator ,int indexTobeSelected) {
		
		Select dropDown = new Select(driver.findElement(locator));
		dropDown.selectByIndex(indexTobeSelected);
		
	}
	
}
