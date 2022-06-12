package Interview;

public class PrimeNumber {

	
	public static int fact(int num) {
		if(num==0) {
			return 1;
		}
		return num*fact(num-1);
		
	}
	
	public static int factorial(int number) {
		int fact =1;
		if (number == 0)
			return 1;
			for (int i = 1; i <= number; i++) {
				fact = fact * i;
			}
			return fact;
	}
	public static void main(String[] args) {
		fact(5);
		System.out.println("factorial is: "+ 	fact(5));
		System.out.println("factorial is: "+ 	factorial(5));
		System.out.println("factorial is: "+ 	factorial(0));
	}

}
