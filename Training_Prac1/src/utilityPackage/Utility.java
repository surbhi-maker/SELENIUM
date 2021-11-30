package utilityPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utility {
	
	public static void selectValueFromSuggestion(WebDriver driver, By locator, String valueToSelect) {
		List<WebElement> allValue = driver.findElements(locator);
		driver.manage().window().maximize();
		System.out.println("Value is :" + allValue.size());
			for(WebElement ele : allValue) {
				String value = ele.getText();
				System.out.println(value);
				if(value.equalsIgnoreCase(valueToSelect)){
					ele.click();
					break;
				}
			}
	}
	
}
