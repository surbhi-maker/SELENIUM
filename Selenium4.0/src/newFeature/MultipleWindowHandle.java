package newFeature;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;


public class MultipleWindowHandle {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();

//		driver.switchTo().newWindow(WindowType.TAB);
		// OR
		driver.switchTo().newWindow(WindowType.WINDOW);

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String ParentID = it.next();
		String childId = it.next();

		driver.switchTo().window(childId);
		driver.get("https://rahulshettyacademy.com");

		String coursename = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"))
				.get(1).getText();

		System.out.println(coursename);
		driver.switchTo().window(ParentID);

		WebElement name = driver.findElement(By.cssSelector("[name='name']"));
		name.sendKeys(coursename);
		
		 File file = name.getScreenshotAs(OutputType.FILE);
		 
		 FileHandler.copy(file, new File("logo.png"));
//		driver.close();  main window close
//		driver.quit();
	}

}
