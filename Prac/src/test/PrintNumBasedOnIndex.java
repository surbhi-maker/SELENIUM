package test;

import java.util.Scanner;

public class PrintNumBasedOnIndex {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the number of elements you want to store: ");
		int n = in.nextInt();
		int[] array = new int[5];
		System.out.println("Enter the elements of the array: ");  
		
		for(int i =0;i<n ;i++) {
			array[i]= in.nextInt();
		}
		System.out.println("Array elements are: ");  
		for (int i=0; i<n; i++)   
		{  
		System.out.println(array[i]);  
		}  
		System.out.println("Size of array :" + array.length);
		int index = in.nextInt();
		System.out.println("enter the index to fetch no at:" + index);
		if(index >= array.length-1) {
			System.out.println("value at index " + index + "is : " + array[index]);
		}
		
		
	}

}
