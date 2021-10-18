package test;

import java.util.Scanner;

public class ReverseString {

	 public static void main(String[] args) {

	  //String str = "Hello world";
	  String revString = "";
	  
	  Scanner in = new Scanner(System.in);
	  String s = in.nextLine();
	  
	  System.out.println(s.length()-1);
	  
	  for (int i = s.length() - 1; i >= 0; --i) {
	   revString += s.charAt(i);
	  }

	  System.out.println(revString);
	 }
	}