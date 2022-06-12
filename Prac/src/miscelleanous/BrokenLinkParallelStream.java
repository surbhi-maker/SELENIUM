package miscelleanous;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//naveen
public class BrokenLinkParallelStream {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		//https://opensource-demo.orangehrmlive.com/
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\\\new_driver_1\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.com/");
		
		List<WebElement> urlElement = driver.findElements(By.tagName("a"));
		System.out.println("Total Urls to be checked: "+urlElement.size());
		List<String> urlList = new ArrayList<String>();
		
		for(WebElement e : urlElement) {
			String url = e.getAttribute("href");
			urlList.add(url);
			
		}
		urlList.parallelStream().forEach(s->{
			try {
				checkBrokenLink(s);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}

	public static void checkBrokenLink(String url) throws IOException {
		
		try {
			URL currentUrl = new URL(url);
			HttpURLConnection httpUrlConnection = (HttpURLConnection) currentUrl.openConnection();
			httpUrlConnection.setConnectTimeout(5000);
			httpUrlConnection.connect();
			if(httpUrlConnection.getResponseCode()>=400) {
				System.err.println("Broken link is********:"+ url +" Respons msg" +httpUrlConnection.getResponseMessage() );
			}
			else {
				System.out.println("link is not broken:"+ url +" Respons msg" +httpUrlConnection.getResponseMessage() );
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}