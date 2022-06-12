package String_prog;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

public class QuickPractice {

	public static void main(String[] args) {
		
		//===========================Frequency of the element
		String[] s = {"java", "python", "Ruby", "java", "abcd" ,"abce"};
		System.out.println("elemenet frequency:" + eleFrequency(s));
//		System.out.println(sm);
		
		
		//reverse a string sentence=================
		String s1= "surbhi how are you";
		
		String[] words = s1.split(" ");
		//String Stored in Array
		for(int i = 0 ; i<words.length ;i++) {
			System.out.println(words[i]);
		}
		
		System.out.println("reverse each word in the string: ");
		
		String reverseWordString ="";
		for(String w : words) { //Word extracted
			String reverseWord ="";
			for(int i = w.length()-1 ; i>=0 ; i--) {   // reverse of each word is perfromed
				reverseWord += w.charAt(i); 
			}
			reverseWordString += reverseWord + " "; 
		}
		System.out.println("reverse each word in the string: " +reverseWordString);
		System.out.println("reverse string: ");
		
		String rev ="";
		for(int i = words.length-1 ; i>=0 ;i--) {
			rev += words[i] + " ";
		}
		System.out.println(rev);
		
		
		
		//*******************************************************************VOWEL CONSONANT COUNT*****************************************
		
		String str = "$$SurbhiKourav";
		String ref1 = "$$aeiouAEIOU";
		int vow = 0, con =0;
		for(int i= 0; i<str.length() ; i++) {
			if((str.charAt(i)>='A' && str.charAt(i) <= 'Z') || ( str.charAt(i)>='a' && str.charAt(i)<='z')) {
				if(ref1.indexOf(str.charAt(i))!= -1) {
					vow++;
				}else {
					con++;
				}
			}
			
		}
		System.out.println("vowel: "+ vow + " con: "+ con);
		
//*******************************************************************kth largest******************************************************
		
		int[] arr = { 10, 20 , 50 , 40, 90 ,80};
		int k = 3;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
			if (i==k-1) {
				System.out.println(arr[i]);
				break;
			}
		}
	
//*************************************************************occurance of char in a given string*****************************
	
		//Duplicate 1
		
		String[] a = {"java", "python", "Go", "Ruby", "java", "Ruby"};
		
		HashSet<String> s2 = new HashSet<>();
		for(int i =0; i<a.length; i++) {
			if(s2.add(a[i])== false) {
				System.out.println("Duplicate elements:"+ a[i]);
			}
		}
		
		for(String e: s2) {
			System.out.println(e);
		}
		
		//Duplicate 1st duplicate
		int count =0;
		for(int i =0; i<a.length ;i++) {
			for(int j = i+1; j<a.length ; j++) {
				if(a[i] == a[j] ){
					System.out.println("first duplicate:" + a[i]);
					count = 1;
				}
				if(count==1) {
					break;
				}
			}
		}
		//===========================================================Map Read===============
		mapRead();
		
		//=========================
		
		
		// Ascii value
		String str3 = "ABcd";
		char[] ch = str3.toCharArray();
		
		for(int i = 0; i<ch.length; i++) {
			int value = ch[i];
			System.out.println(ch[i] + "number" + value);
		}
		
		//Fabonacci:
		int n = 5;
		System.out.println("fabonacci:"+ fabonacci(n));
		Scanner sc = new Scanner(System.in);
//		int newNum = sc.nextInt();
//		System.out.println("fabonacci 2:"+ fabonacci(newNum));
		
		//palindrome:
		int np = 15151;
		System.out.println("is palindrome:"+ palindrome(np));
		
		
		//----------------------reverse an array
		System.out.println("element in reverse order:");
		String[] st1 = {"java", "python1", "Ruby"};
		String[] revArray =  new String[st1.length];
		
		for(int i = st1.length-1 ;i>= 0 ;i--) {
			System.out.println(st1[i]+ " ");
		}
	
		
		
		//==============================remove speacial char
		
		String strSpeacial= "This#string%contains^special*characters&****************$$.";
		str = strSpeacial.replaceAll("[^a-zA-Z0-9]", " ");
		strSpeacial.replaceAll("[^a-zA-Z0-9]", " ");
		System.out.println("Speacial char removed: "+ str);
		
		
		String v = "al2haba2d"; //allahabaad
		
		char[] a1 = v.toCharArray();
		String newString ="";
		for(int i = 0; i<a1.length;i++ ) {
			if(!(v.charAt(i)>= 'a' && v.charAt(i)<='z')) {
			 newString = v.replace(v.charAt(i), v.charAt(i-1));
			}
		}
		System.out.println("new : "+ newString);
		
		
		//===================== 3rd largest element=========================================================================
		
		int[] z1 = { 1, 5, 78, 100, 90,34,65};
		int temp = 0;
		int k4 = 3;
		System.out.println("z1 length:"+ z1.length);
		for(int i = 0; i<z1.length-1 ;i++) {
			for(int j = i+1 ; j<z1.length ; j++) {
				if(z1[i]<z1[j]) {
					temp = z1[i];
					z1[i]=z1[j];
					z1[j]= temp;
				}
			}
			if(k4==i) {
				System.out.println("3rd largest : "+ z1[i]);
				break;
			}
		}
		
		

// ==================reverse string preserving space position====================================================================================
		String str2 = "I am Surbhi";
		System.out.println("String Reverse by Preserving space:" +reverPreserveSpace(str2));
		
	}
	
	public static String reverPreserveSpace(String str2) {
		int strlen = str2.length();
		int start = 0; 
		int end = strlen - 1;
		char[] p= str2.toCharArray();
		while (start<end) {
			if (p[start] == ' ') {
				start++;
				continue;
			} else if (p[end] == ' ') {
				end--;
				continue;
			} else {
				char temp2 = p[start];
				p[start] = p[end];
				p[end] = temp2;
				start++;
				end--;
			}
		}
		System.out.println("reverse string preserving space position:"+ String.valueOf(p));
		return String.valueOf(p);
	}
	
	public static boolean palindrome(int np) {
		boolean flag = false;
		int sum = 0;
		int r = 0;
		int temp = np;
		while (np > 0) {
			 r = np % 10;
			sum = (sum * 10) + r;
			np = np/10;
		}
		if(temp == sum) {
			flag = true;
		}
		return flag;
	}

	public static int fabonacci(int n) {
		int fact = 1;
		for(int i = n; i>=1;i-- ) {
			fact = fact*i;
		}
		return fact;
	}
	
	
	public static void mapRead() {
		
		HashMap<String, Integer> storeMap = new HashMap<>();
		storeMap.put("mumbai", 1);
		storeMap.put("Pune", 2);
		Set<Entry<String, Integer>> entrySet = storeMap.entrySet();
		for(Entry<String, Integer> e : entrySet) {
		
			System.out.println(e.getKey() + "value" + e.getValue());
		}
	}
	
		public static  Map<String, Integer> eleFrequency(String[] s) {
			
			System.out.println("elemenet frequency check");
			
			
			Map<String, Integer> sm = new HashMap<String, Integer>();
			for(int i = 0; i< s.length; i++) {
				
				if(sm.get(s[i])==null) {
					sm.put(s[i], 1);
				}
				else {
					int count = sm.get(s[i]);
					sm.put(s[i], count+1);
				}
			}
			System.out.println(sm);
			return sm;
		}
	
	}
		

	
