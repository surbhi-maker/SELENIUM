package Graph;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SvgElement {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//https://opensource-demo.orangehrmlive.com/
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\\\new_driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/search?q=covid+cases+in+india&rlz=1C1GCEU_en&ei=EHY0YquuLPilptQPjqypsA0&ved=0ahUKEwir9qL0z8_2AhX4kokEHQ5WCtYQ4dUDCA4&uact=5&oq=covid+cases+in+india&gs_lcp=Cgdnd3Mtd2l6EAMyCAgAEIAEELEDMggIABCABBCxAzIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgYIABAHEB4yBQgAEIAEMgUIABCABDoECAAQCkoFCDwSATFKBAhBGABKBAhGGABQsQhY6gpg1hBoAXABeACAAUGIAb8BkgEBM5gBAKABAcABAQ&sclient=gws-wiz");
		
		List<WebElement> element=driver.findElements(By.xpath("(//*[local-name()='svg' and @class='uch-psvg'])[1]//*[local-name()='rect']"));
		
		for(WebElement e: element) {
			Actions act = new Actions(driver);
			act.moveToElement(e).perform();
			String toolTip = driver.findElement(By.xpath("//div[@class='ExnoTd']")).getText();
			if(toolTip.contains("Jul 28")) {
				break;
			}
			System.out.println(toolTip);
		}
		
	}
}