package miscelleanous;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLink {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		//links in the footer
//			a[href*='SoapUI']	   //li[class = 'gf-li']"
		
		List<WebElement> links = driver.findElements(By.cssSelector("li[class = 'gf-li'] a"));
		
//		links.stream().forEach(l->l.getAttribute("href"));
//		links.forEach(s->System.out.println(s.getAttribute("href")));
		
		SoftAssert a = new  SoftAssert() ;
		for(WebElement link : links) {
			String url = link.getAttribute("href");
			HttpURLConnection conn  = (HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int responseCode = conn.getResponseCode();
			System.out.println("responseCode :"+ responseCode );
//			if(responseCode>400) {
//				System.out.println( "The link  : "+ link.getText() +" is failed with code :" + responseCode);
				a.assertTrue(responseCode<400, "The link with : "+ link.getText() +" is failed with code :" + responseCode);
//			}
		}	
		a.assertAll();   // to report the error at the end of checking all the elements
		
				//Get the URL present under link soap UI
//		String url = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
//		System.out.println("url:"+ url);
//		HttpURLConnection conn  = (HttpURLConnection)new URL(url).openConnection();
//		conn.setRequestMethod("HEAD");
//		conn.connect();
//		int responseCode = conn.getResponseCode();
//		System.out.println("responseCode :"+ responseCode );
		driver.close();
	}
	
}
