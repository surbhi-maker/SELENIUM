package Selenium;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GreenCart {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		String[] vegiesToAdd = { "Brocolli", "Cauliflower", "Cucumber", "Beetroot" };
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.manage().window().maximize();
		//IMPLICIT WAIT
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		//EXPLICIT WAIT
		WebDriverWait w = new WebDriverWait(driver, 5);

		addItems(driver, vegiesToAdd);

//		driver.findElement(By.cssSelector("//img[@alt = 'Cart']")).click();
		driver.findElement(By.cssSelector("a.cart-icon")).click();
//		Thread.sleep(2000l);
		driver.findElement(By.xpath("//button[contains(text() , 'PROCEED TO CHECKOUT')]")).click();
//		Thread.sleep(2000l);

		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();

		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

	}

	public static void addItems(WebDriver driver, String[] vegiesToAdd) {
		List<WebElement> product = driver.findElements(By.cssSelector("h4.product-name"));

		// System.out.println(product.get(0).getText());
		int i = 0;
		int j = 0;
		for (WebElement prod : product) {

//				 System.out.println(prod.getText() + " at index : " + i);
			String[] name = prod.getText().split("-");
			String formatName = name[0].trim();

//				 convert array to list
			List<String> itemsNeeded = Arrays.asList(vegiesToAdd);

			if (itemsNeeded.contains(formatName)) {

				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
//					break; it will not work in case of list
				System.out.println(formatName + " at Index " + i);
				j++;
				if (j == vegiesToAdd.length) {
					break;
				}
			}
//				Thread.sleep(2000L);
			i++;
		}
	}

}

//if(name.contains("Cucumber")) {
//	driver.findElements(By.xpath("//button[contains(text() , \"ADD TO CART\")]")).get(i).click();
//	 break;
//}