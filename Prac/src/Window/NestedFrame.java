package Window;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedFrame {

	/***********
	 * Assignment 5
	 *********/

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		driver.manage().window().maximize();

		WebElement ele1 = driver.findElement(By.xpath("/html/frameset/frame[1]"));
		driver.switchTo().frame(ele1);
		WebElement ele2 = driver.findElement(By.xpath("/html/frameset/frame[2]"));
		driver.switchTo().frame(ele2);

		String text = driver.findElement(By.xpath("//div[@id='content']")).getText();
		System.out.println(text);

	}

}
