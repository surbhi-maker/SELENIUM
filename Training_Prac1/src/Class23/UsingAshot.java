package Class23;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utilityPackage.Utility;

public class UsingAshot {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://github.com/pazone/ashot");
		driver.manage().window().maximize();
		Utility.takeFullPageScreenShot(driver);
//		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
//		ImageIO.write(screenshot.getImage(), "png", new File(System.getProperty("user.dir") +"\\screenshots\\Selenium" + System.currentTimeMillis()+".png"));
		
		
		
}
}
