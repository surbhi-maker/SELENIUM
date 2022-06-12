package ORDER;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.util.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PreOrderPdf {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://ordering.qa.elementfleet.com/#editOrder/3041468");
		
		
		driver.findElement(By.xpath("//input[@name = 'username']")).sendKeys("ordsup_AT1");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys("TestingQA@1234");
		
		driver.findElement(By.id("signinBtn")).click();
		Thread.sleep(2000L);
		
		Thread.sleep(3000L);
		driver.findElement(By.xpath("//ul[@id='createOrder-menu']//li[@id='coreorder_navigation__summary']//a[@title='Summary']")).click();
		
		List<WebElement> first = driver.findElements(By.xpath("//div[@id='titleRegInfo']//div[@class='col-md-4 inline-block']//p"));
		
		first.forEach(s->System.out.println(s.getAttribute("textContent")));
		List<WebElement> li = driver.findElements(By.xpath("//div[@id='titleRegInfo']//div[@class='col-md-4 inline-block no-padding']//p"));
		
		System.out.println(li.size());
		Thread.sleep(3000L);
		System.out.println("title plate");
		for(int i =0 ; i<li.size();i++) {
			
			String text = li.get(i).getAttribute("textContent").trim().replaceAll("\\s+", " ")
					.replaceAll("( , )+|( ,)+|(, )+", ",").replaceAll(",$", "").trim().replaceAll(",", ", ");
			
			String [] address =text.split("Provincial");
			int zipCodeIndex = address[0].trim().length() -4;
//			System.out.println("zipCodeIndex is"+zipCodeIndex);
//			System.out.println(address[0].replace(address[0].substring(zipCodeIndex), address[0].substring(zipCodeIndex).trim()));
			
			if(!text.isEmpty()) {
			System.out.println(text);
					//.substring(0, Math.min(3, text.length())));
			if(text.contains("ON")) {
				System.out.println("text contains ON is ************************"+text);
				System.out.println("str1 contains ON is"+ text.substring(text.length()-4).trim()+"blnk test");
				System.out.println(text.replaceAll("\\S*\\d\\S.$",""));
				String new1 = text.replaceAll("\\S*\\d\\S.$","").trim();
				System.out.println("str1 contains ON is=>"+ new1.concat(text.substring(text.length()-4).trim()));
//				System.out.println("text contains ON is"+ text.split("\\S*\\d\\S.$"));
//				System.out.println("blank is" +text.charAt(text.length()-4)+"test");
//				System.out.println(text.replace(text.charAt(text.length()-4), ""));
//				System.out.println(text.replace(target, replacement));
			}

			
			
			}
		}
		driver.close();
	
		String st = "N6E 1L8";
		System.out.println(st.replaceAll("", ""));
		System.out.println(isAlphaNumeric(st));
		
		
		
		String s1 = "ABC12 34f";
		  
	      boolean isAlphaNumeric = s1 != null &&
	                              s1.chars().allMatch(Character::isLetterOrDigit);
	      System.out.println("IsAlphaNumeric: " + isAlphaNumeric);
//		li.forEach(s->System.out.println(s.getText()));
	}
	
	
	public static boolean isAlphaNumeric(String s) {
        return  s != null && s.matches("^[a-zA-Z0-9]*$");
    }
	
	
	
	
}