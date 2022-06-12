package String_prog;

import java.util.Arrays;
import java.util.List;

public class ArrayMissingNum {

	public static void main(String[] args) {
		
		int[] num = {1,5,7,8};
		
//		List<int[]> li = Arrays.asList(num);
//		li.contains(num);
//		System.out.println("");
		
		int max = num[0];
		int min = num[1];
		
		for(int i=0;i<num.length;i++) {
			if(num[i]>max) {
				max= num[i];
			}else {
				min = num[i];
			}
		}
	System.out.println("max:"+ max);	
	System.out.println("min:"+ min);	
	}
	
	
	
	
}
