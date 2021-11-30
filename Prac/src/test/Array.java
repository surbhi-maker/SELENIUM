package test;

public class Array {
	
	 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		int arr[] = { 1, 2, 3, 4};
//		sum(arr);
//	} 
//	public static void sum(int arr[]) {
//		int sum1 = 0;
//		
//		for(int i = 0; i <arr.length ; i++) {
//			sum1 += arr[i];
//			
//			System.out.println(sum1);
//		}
		
		String s1 = "Hi, I am";
		
		String expected =  "Hi   , I    /am   surbhi   kourav";
		
		System.out.println(expected.replaceAll(" ,", ","));
		
		System.out.println(expected.replaceAll("\\s+", " ").replaceAll(" ,", ",").replaceAll(" /", "/"));
//				(s1.trim()));
		
		
		
//		expected  [D.L. Peterson Trust /LSR]
//		but found [D.L. Peterson Trust/LSR]
//		           D.L. Peterson Trust/LSR
//	 			   D.L. Peterson,Trust/LSR
		String st = "D.L. Peterson Trust /LSR";
		System.out.println(st.replaceAll("\\s+", " ").replaceAll(" /", "/").replaceAll(" ,", ","));
		
		
	}

}
//https://www.javatpoint.com/how-to-take-array-input-in-java