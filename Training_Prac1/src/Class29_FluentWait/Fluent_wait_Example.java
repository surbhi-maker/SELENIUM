package Class29_FluentWait;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

public class Fluent_wait_Example {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://seleniumpractise.blogspot.com/search?q=timer");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@onclick ='timedText()']")).click();

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
				wait.withTimeout(Duration.ofSeconds(30));
				wait.pollingEvery(Duration.ofMillis(10));
				wait.ignoring(Exception.class);
				
			WebElement element =wait.until(new Function<WebDriver, WebElement>() {

					public WebElement apply(WebDriver input) {
						WebElement ele = input.findElement(By.xpath("//p[@id='demo']"));
						String text =ele.getText();
						if(text.equalsIgnoreCase("WebDriver")) {
							System.out.println("Element Found");
							return ele;
						}
						else
						{
							System.out.println("Current element text is:"+text);
						return null;
						}
					}
					
				});
				
				System.out.println(element.isDisplayed());
	}

}
