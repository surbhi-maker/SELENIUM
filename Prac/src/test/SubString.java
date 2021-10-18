package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubString {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		String given = "0001110101";
//		int s = in.nextInt();
		 ArrayList<Integer> list = new ArrayList<Integer>();
		 while(in.hasNextInt()){
	         list.add(in.nextInt());
	      }
		 Integer[] nums = new  Integer[list.size()];
	      nums = list.toArray(nums);
	      for(int i = 0;i < nums.length; i++){
	      System.out.println(nums[i]);
	      }   
		

	}

}
