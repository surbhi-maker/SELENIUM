package String_prog;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
public class OcurrencesString {
	public static void main(String[] args) {
		String str = "surbhisssfYY";
		char[] a = str.toCharArray();
		Set<Character> s1 = new HashSet<>();
		int max = 0;
		for(char e : a) {
			if(s1.add(e)==true) {
				System.out.println("count of s:"+ e +" is : "+charCount(str, e));
				if (charCount(str, e) > max) {
					max = charCount(str, e);
				}
		 }
		}
		
		System.out.println("max occurances: " +max);
		System.out.println("count of s:"+charCount(str, 's'));
		//reverse a number
		int n = 543;
		System.out.println("reverse of a num: "+reverseANumber(n));
		
		//reverse string
		String str1 = "my name is surbhi";
		
	
		System.out.println("String in a reverse format: " + reverse(str1));
		//================================
		System.out.println("Prac**************");
		String str2 = "hello mumbai";
		System.out.println("String in a reverse1 format: " + reverse1(str2));
		
//		=====================================way 1==========================
		String freq = "cccOddEEEccABA";
		char[] ch2 = freq.toCharArray();
		Set<Character> set = new HashSet<>();
		for(int i = 0 ; i<freq.length() ;i++) {
			if (set.add(freq.charAt(i)) == true) {
				System.out.println(freq.charAt(i) + "= " + frequency(freq.charAt(i), ch2));
			}
		}
		//		=====================================way 2==========================		
		HashMap<Character, Integer> storeMap = new HashMap<>();
		
		for(int i = 0 ; i<ch2.length ; i++) {
			if(storeMap.get(ch2[i])==null) {
				storeMap.put(ch2[i] , 1);
			}else {
				int count =storeMap.get(ch2[i]);
				storeMap.put(ch2[i] , count+1);
			}
		}
		System.out.println(storeMap);
		String rev ="";
		for(int i = ch2.length-1; i>=0 ; i--) {
			
			rev  += ch2[i];
		}
		System.out.println("reverse strring:"+ rev);
	}
	
	private static int frequency(char c, char[] ch2) {
		int count =0;
		for(int i = 0 ; i<ch2.length ; i++) {
			if(ch2[i]==c) {
				count++;
			}
		}
		
		return count;
	}

	private static int reverseANumber(int number) {
		int reverse=0;
		while (number != 0) {
			int reminder = number % 10;
			reverse = reverse * 10 + reminder;
			number = number / 10;
		}
		System.out.println("count of s:"+reverse);
		return reverse;
	}

	private static int charCount(String word, char character) {
		int count=0;
		for(int i=0;i<word.length();i++) {
			if(word.charAt(i)== character) {
				count++;
			}
		}
		return count;
	}

	private static String reverse(String stringToBoReverse) {
		String[] arg = stringToBoReverse.split(" ");
		String current = " ";
			for (int i = arg.length - 1; i >= 0; i--) {
				String reverseword=" ";
				String word = arg[i];
				char[] ch = word.toCharArray();
				for(int j =ch.length - 1 ; j>=0;j--) {
					reverseword += ch[j];
				}
				current += reverseword + " ";
			}
		System.out.println("current string:" + current);
		return current;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static String reverse1(String stringToBoReverse) {
		System.out.println("start reverse 1:" );
		String[] arg = stringToBoReverse.split(" ");
		String reverseSen = "";
		String rev ="";
		String temp="" ;
//		for(int i = arg.length-1; i>=0 ; i--) {
//			reverseSen += arg[i]+ " ";
//			char[] ch = arg[i].toCharArray();
//			for(int j = ch.length-1; j>=0 ;j--) {
//				rev += ch[j];
//			}
//			temp = rev + " ";
//		}
		
//		for(int i = stringToBoReverse.length()-1; i>=0 ; i--) {
//			
//			reverseSen += stringToBoReverse.charAt(i);
//		}
		
		for(int i = arg.length-1; i>=0 ; i--) {
			
			reverseSen += arg[i] + " ";
		}
		System.out.println("rev : " +rev);
		System.out.println("temp : " +temp);
		System.out.println("reverse : " +reverseSen);
		return reverseSen;
	
	
	}
	
}
