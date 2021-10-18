package test;

import java.util.Scanner;

public class Tocommit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Tocommit.main()");

		Scanner in = new Scanner(System.in);
		int num = in.nextInt();

		// System.out.println("input from user is " + num);

		if (num == 0 || num == 1) {
			int n = 0;
			System.out.println("if input is sum " + n);
		} else if (num % 2 != 0) {
			int n = num - 1;
			System.out.println("input from user is " + n);

		} else if (num % 2 == 0) {
			int n = num - 3;
			System.out.println("if input is sum " + n);
		}

	}

}
