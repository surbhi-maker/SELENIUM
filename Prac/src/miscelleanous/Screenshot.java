package miscelleanous;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshot {

	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();

		 File scrShot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 
		 FileUtils.copyFile(scrShot, new File("D:\\Users\\Screenshot.png"));
		 
//		 File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		 FileUtils.copyFile(src, new File("path"));
	}

}
