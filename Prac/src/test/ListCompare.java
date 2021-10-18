package test;

import java.util.Arrays;
import java.util.List;

public class ListCompare {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	List<String> filterList = Arrays.asList("ram", "abc", "xyz", "rew", "pqr");
	
	List<String> filterList2 = Arrays.asList("ram", "abc", "pqr");
	
	System.out.println(filterList.size());
	
	for(int i =0; i<=3 ; i++) {
		System.out.println("contains: " + filterList.get(i));
		System.out.println(i);
		if(filterList.containsAll(filterList2)) {
			System.out.println("contains all element: ");
		}else
		{
			System.out.println("not containt equal element: ");
		}
	}
	
	System.out.println("verified");
	}
}
