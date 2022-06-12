package String_prog;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class add {

	public static void main(String[] args) {
		
		String a = "100.00";
		String b = "2100.00";
	
//		int c = Integer.parseInt(a)+Integer.parseInt(b);
		double c =Double.parseDouble(a);
		double d =Double.parseDouble(b);
		
		double f =Float.parseFloat(a);
		double g =Float.parseFloat(b);
		
		   BigDecimal amountOne= new BigDecimal(a).add(new BigDecimal(b));

		   String summaryOptNew = String.valueOf(amountOne);
//		int c = Integer.parseInt(a);
//		int e = Integer.parseInt(b);
//		String d = a+b;
		System.out.println(amountOne);
		System.out.println(summaryOptNew);

		System.out.println(f);
		System.out.println(g);
		
		
			String data = "1 record";
			
			System.out.println(data.replaceAll("[A-Z]", ""));
			System.out.println(data.replaceAll(" .*", ""));
			
	}
}
