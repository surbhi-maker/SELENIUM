package CDPCommand;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
	
/*
 * 300 400
 * 400 500
 * 700 900
 * same script but different data then use Data provider annotaion test ng
 */
public class CDPCommandDeviceMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Map<String, Object> obj = new HashMap<>();
		obj.put("width", 700);
		obj.put("height", 1024);
		obj.put("deviceScaleFactor", 100);
		obj.put("mobile", true);
		
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", obj);
		
		driver.get("https://www.selenium.dev/documentation/webdriver/bidirectional/chrome_devtools/");
	}

}
