package newFeature;

import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RelativeLocator {

	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();

		WebElement element = driver.findElement(By.cssSelector("[name='name']"));

//		driver.findElement(withTagName("label")).above()
//		System.out.println("value :" + driver.findElement(withTagName("label"))..getText());
		System.out.println(driver.findElement(withTagName("label").above(element)).getText());

		WebElement elementemail = driver.findElement(By.cssSelector("[name='email']"));
		System.out.println(driver.findElement(withTagName("label").below(elementemail)).getText());
		
		
		WebElement radiobutton = driver.findElement(By.cssSelector("[id='inlineRadio1']"));
		radiobutton.click();
		System.out.println(driver.findElement(withTagName("label").toRightOf(radiobutton)).getText());
				
//		driver.close();
	}
}
