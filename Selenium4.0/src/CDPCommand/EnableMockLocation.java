package CDPCommand;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class EnableMockLocation {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Map<String, Object> obj = new HashMap<>();
		obj.put("latitude", 41.881832);
		obj.put("longitude", -87.623177);
		obj.put("accuracy", 100);
		
		
		driver.executeCdpCommand("Emulation.setGeolocationOverride", obj);
		
		driver.get("https://locations.dennys.com/search.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[contains(@class,'geolocateTrigger')]")).click();
	}

}
