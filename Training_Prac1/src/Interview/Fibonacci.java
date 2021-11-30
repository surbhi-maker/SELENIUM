package Interview;

/*
 * public class Fibonacci {
 * 
 * static int fib(int n) { int a = 0, b = 1, c;
 * 
 * 
 * int f[0] = 0; int f[1] = 1;
 * 
 * if(n==0) return a; for(int i = 2; i<=n; i++) {
 * 
 * c = a+b; System.out.println(c); a = b; b = c;
 * 
 * } return b; } public static void main(String[] args) {
 * 
 * int n = 9; System.out.println(fib(n)); }
 * 
 * }
 */

//Dynamic Programming approach for
//Fibonacci Series

class Fibonacci {
	// Function to find the fibonacci Series
	static int fib(int n)
	{
		// Declare an array to store
		// Fibonacci numbers.
		// 1 extra to handle case, n = 0
		int f[] = new int[n + 2];
		int i;
		// 0th and 1st number of  // the series are 0 and 1
		f[0] = 0;
		f[1] = 1;
		for (i = 2; i <= n; i++) {
			// Add the previous 2 numbers   // in the series and store it
			f[i] = f[i - 1] + f[i - 2];
		}
		// Nth Fibonacci Number
		return f[n];
	}

	public static void main(String args[])
	{
		// Given Number N
		int N = 10;
		// Print first 10 term
		for (int i = 0; i < N; i++)
			System.out.print(fib(i) + " ");
	}
}
