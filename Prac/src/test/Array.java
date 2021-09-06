package test;

public class Array {
	
	 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = { 1, 2, 3, 4};
		sum(arr);
	} 
	public static void sum(int arr[]) {
		int sum1 = 0;
		
		for(int i = 0; i <arr.length ; i++) {
			sum1 += arr[i];
			
			System.out.println(sum1);
		}
		
	}

}
//https://www.javatpoint.com/how-to-take-array-input-in-java