package String_prog;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;



public class SmallestLargest {

	public static void main(String[] args) {
		
		int num[] = {10,-100, 300, 56,500,897348};
		
		int small = num[0];
		int largest = num[0];
		for(int i = 1;i<num.length;i++) {
			if(num[i]<small) {
				small =num[i];
			}
			else if(num[i]>largest) {
				largest = num[i];
			}
		}
		
		System.out.println("smallest :"+ small);
		System.out.println("largest :"+ largest);
	}
}
	
//	String sent = "have a nice day";
	
	
