package Table;

import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TableGrid {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		//div[@class ='tableFixHead']/table/thead/tr/th[4]
		
		//to identify rows of particular row of given table 
		//.tableFixHead td:nth-child(4)
		
		List<WebElement> amount= driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		
//		 int sum = Arrays.stream(A).reduce(0, (x, y) -> x + y);
//		 WebElement amt1 =  amount.
		
        //System.out.println(sum1);
        
		// iterator for accessing the elements
        Iterator<WebElement> it = amount.iterator();
		
       int sumOF = 0;
        while(it.hasNext()) {
        	WebElement num = it.next();
        	String n = (num.getText());
        	int num2 = Integer.parseInt(n);
        	sumOF += num2;
        }
        System.out.println(sumOF);
        
        WebElement invoice = driver.findElement(By.cssSelector("[class = 'totalAmount']"));
        
        
        int total = Integer.parseInt(driver.findElement(By.cssSelector("[class = 'totalAmount']")).getText().split(":")[1].trim());
        System.out.println(total);
        
        Assert.assertEquals(sumOF, total);
        driver.close();
	}
	
	// check result
	
}
