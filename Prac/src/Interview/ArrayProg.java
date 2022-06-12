package Interview;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ArrayProg {

	public static void main(String[] args) {
		
		int[] num = {5,10,10,4,4,5,6,7,8,9 };
		
		for(int i = 1 ; i <num.length ; i++) {
			System.out.println("previous first " + num[i -1]);
			System.out.println("current element" +num[i]);
			
			int max = num[0];
			if(max<num[i]) {
				max = num[i];
			}
			System.out.println("***********************************");
			System.out.println("max element" + max);
			System.out.println("num.length element" + num.length);
		}
		
		System.out.println("***********************************");
		for(int i = 0 ; i<num.length ;i++) {
			for(int j = i+1 ; j<(num.length-1);j++) {
				if(num[i]==num[j]) {
					System.out.println("duplicate element" +num[i]);
				}
			}
		}
		System.out.println("***********************************");
		System.out.println("sum of element:" +SumOfArray(num));
		System.out.println("***********************************");
		distincArrayElement(num);
		System.out.println("***********************************");
		System.out.println("Max difference of element:" + maxDifference(num));
		
		System.out.println("*******************************Compare 2 array and create new one");
		int[] a = {10 ,23,45,12,23,34};
		int[] b = {10 ,23,45,12,20,30};
		
		for(int i = a.length-1; i>=0 ;i--) {
			System.out.println(a[i]);
		}
		System.out.println("***********************");
		System.out.println("reverse of element:" + reverseArray(a));
		
//		System.out.println("*****************" +CompareArray(a ,b));
	}

	private static int reverseArray(int[] a) {
		int newArray = 0;
		for(int i = a.length-1; i>=0 ;i--) {
			System.out.println(a[i]);
			newArray= a[i];
		}
		
		return newArray;
	}

	public static int SumOfArray(int[] num) {
		int total =0;
		for(int i= 0;i<num.length ;i++) {
			total = total + num[i];
		}
		return total;
	}

	public static void distincArrayElement(int[] num) {
		List<Integer> ar = Arrays.asList(5,10,10,4,4,5,6,7,8,9 );
		List<Integer> distinctElements =ar.stream()
                .distinct()
                .collect(Collectors.toList());
		distinctElements.forEach(s->System.out.println(s));
		
	}
	
	public static int maxDifference(int[] num) {
		int maxdiff = 0;
		for(int i=1; i<num.length ;i++) {
			int diff =num[i]-num[i-1];
			System.out.println(diff);
			if(diff > maxdiff) {
				maxdiff = diff;
			}
		}
		return maxdiff;
		
	}
	
//	public static int[] CompareArray(int[] ar1, int[] ar2) {
//		
//		int newArry[] = new int[ar1 +1];
//		if(!(ar1.length==ar2.length)) {
//			return ar3;
//		}
//		for(int i =0 ; i<ar1.length ;i++) {
//			if(ar1[i]==ar2[i]) {
//				ar3[i] = ar1[i];
//			}
//		}
//		System.out.println("matching elements in array are:" + ar3);
//		return ar3;
		
	
	private static int reverseArray1(int[] a) {
		int newArray = 0;
		for(int i = a.length-1; i>=0 ;i--) {
			System.out.println(a[i]);
			newArray= a[i];
		}
		
		return newArray;
	}
}
