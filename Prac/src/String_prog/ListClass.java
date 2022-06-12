package String_prog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ListClass {

	public static void main(String[] args) throws InterruptedException {
		
		String[] a1 = {"AA","AB"};
		String[] a2 = {"123","2211"};
		List<String> li = Arrays.asList(a1);
		List<String> l2 = Arrays.asList(a2);
		
//		li.forEach(s->System.out.println(s));
//		l2.forEach(s->System.out.println(s));
		
		List<String> l3 = new ArrayList<String>();
		for(int i=0;i<li.size();i++) {
			l3.add(li.get(i).concat(l2.get(i)));
//			List<String> l3 =	Stream.concat(li.stream(),l2.stream()).collect(Collectors.toList());
//			List<String> l4 =	Stream.concat(a, b)
//					concat(li.stream(),l2.stream()).collect(Collectors.toList());
		}
		l3.forEach(s->System.out.println(s));
		
		boolean match = l3.stream().anyMatch(s->s.contains("AB2211"));
				//l3.stream().filter(l3 -> "AB2211".equals(AB2211)).findAny().orElse(null);
		System.out.println(match);
		
//		String unit = "A012345678";
//		System.out.println("unit no : "+unit.substring(0, 5));
	}

}
