package Surbhi17_brokenLink;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ResponseCodeChecker2 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\l\\Downloads\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://the-internet.herokuapp.com/broken_images");
		
		List<String> broken_images= imageChecker(driver.findElements(By.tagName("img")));
		
		System.out.println(broken_images);
		
		if(broken_images.size()>0)
		{
			System.out.println("Log:FAIL - Broken images found and Count is "+broken_images.size());
		}
		else
		{
			System.out.println("Log:PASS - No Broken images found");
		}
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		

		List<String> broken_links=linkChecker(driver.findElements(By.tagName("a")));
		
		System.out.println(broken_links);
		
		if(broken_links.size()>0)
		{
			System.out.println("Log:FAIL - Broken links found and Count is "+broken_images.size());
		}
		else
		{
			System.out.println("Log:PASS - No Broken links found");
		}
		
		driver.quit();
		

	}
	
	public static List<String> linkChecker(ArrayList<String> allLinks)
	{
		
	
		return null;
	}
	
	public static String linkChecker(String link)
	{
		

		return null;
	}
	
	
	public static List<String> imageChecker(List<WebElement> allURL) {

		List<String> allBrokenLink = new ArrayList<>();

		for (WebElement ele : allURL) {

			String linkURL = ele.getAttribute("src");

			try {
				URL url = new URL(linkURL);

				System.out.println("Log:INFO -Opening Connection");

				HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();

				urlConn.connect();

				System.out.println("Log:INFO -Connection Done");

				int code = urlConn.getResponseCode();

				String responseMsg = urlConn.getResponseMessage();

				System.out.println("Response from server Code: " + code + " Server message :" + responseMsg);

				if (code < 400) {
					System.out.println("Log:INFO -Image  is valid");
				} else if (code > 400) {
					System.out.println("Log:INFO -Image is broken " + linkURL);
					allBrokenLink.add(linkURL);

				}

			} catch (Exception e) {
				System.out.println("Exception " + e.getMessage());
			}

		}

		return allBrokenLink;

	}
	
	
	public static List<String> linkChecker(List<WebElement> allURL) {

		List<String> allBrokenLink = new ArrayList<>();

		for (WebElement ele : allURL) {

			String linkURL = ele.getAttribute("href");

			try {
				URL url = new URL(linkURL);

				System.out.println("Log:INFO -Opening Connection");

				HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();

				urlConn.connect();

				System.out.println("Log:INFO -Connection Done");

				int code = urlConn.getResponseCode();

				String responseMsg = urlConn.getResponseMessage();

				System.out.println("Response from server Code: " + code + " Server message :" + responseMsg);

				if (code < 400) {
					System.out.println("Log:INFO -Link is valid");
				} else if (code > 400) {
					System.out.println("Log:INFO -Link is broken " + linkURL);
					allBrokenLink.add(linkURL);

				}

			} catch (Exception e) {
				System.out.println("Exception " + e.getMessage());
			}

		}

		return allBrokenLink;

	}

}
