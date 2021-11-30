package Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class StreamExample {
	
	@Test
	public static void main(String[] args){
		
		List<String> list1 = new ArrayList<String>();
		list1.add("Ram");
		list1.add("Surbi");
		list1.add("Shyam");
		list1.add("Abc");
		list1.add("Abcm");
		
		
		List<String> list2 = new ArrayList<String>();
		list2.add("Sbhu");
		list2.add("Sai");
		list2.add("Test");
		list2.add("Md");
		
		System.out.println("print all elements");
		list1.forEach(s->System.out.println(s)); //print all elements
		System.out.println("apply any filter and create new list");
		List<String> newList1 = list1.stream().filter(s->s.startsWith("s")).collect(Collectors.toList());  //apply any filter and create new list
		System.out.println("get count");
		long  value = list1.stream().filter(s->s.startsWith("s")).count(); //apply filter and print element of that criteria
		System.out.println("Count : " +value);
		
		Stream<String> newStream = Stream.concat(list1.stream(),list2.stream());  
//		newStream.allMatch(s->s.contains("s"));
//		newStream.forEach(s->System.out.println(s)); //*****Stream ek bar bs process hota hei
		System.out.println("All contains - s: ?"+	newStream.allMatch(s->s.contains("s")));
		
		
		System.out.println("map method");
		//manipulate the list element and create a map of stream..new stream
		
//		list1.stream().filter(s->s.endsWith("m")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		list1.stream().filter(s->s.endsWith("m")).map(s->s.toUpperCase()).sorted().forEach(s->System.out.println(s));
		
		System.out.println("Distinct to find unique");
		Stream.of("Surbhii", "ram" ,"Surbhii" , "sai", "sai" , "ram").distinct().forEach(s->System.out.println(s));
		
		System.out.println("find any : ");
		 Stream.of("Surbhii", "ram" , "Surbhii" , "sai", "sai" , "ram").filter(s->s.startsWith("r")).limit(1).forEach(s->System.out.println(s));
		
	}
		
}
