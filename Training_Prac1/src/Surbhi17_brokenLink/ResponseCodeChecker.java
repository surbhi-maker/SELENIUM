package Surbhi17_brokenLink;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ResponseCodeChecker 
{


	public static void main(String[] args) throws InterruptedException, IOException 
	{
		/*System.setProperty("webdriver.chrome.driver", "C:\\Users\\l\\Downloads\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.google.com/");
		
		 */
		
		String baseurl="https://the-internet.herokuapp.com/img/avatar-blank.jpg";
		
		URL url=new URL(baseurl);
		
		System.out.println("Log:INFO -Opening Connection");
		
		HttpURLConnection urlConn=(HttpURLConnection)url.openConnection();
		
		urlConn.connect();
		
		System.out.println("Log:INFO -Connection Done");
		
		int code=urlConn.getResponseCode();
		
		String responseMsg=urlConn.getResponseMessage();
		
		System.out.println("Response from server Code: "+code +" Server message :"+responseMsg);
		
	}

}
