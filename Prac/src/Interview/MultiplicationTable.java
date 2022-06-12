package Interview;

public class MultiplicationTable {

	public static void main(String[] args) {
		
		int[] tabl = multiply(5,10);
		
		System.out.println(tabl);
		
	}

	public static int[] multiply(int start, int end) {

		int[] num = null;
		for(int i = 1 ; i<=end ; i++) {
			num[i] = start*i;
			System.out.println(num[i]);
		}
		return num;
	}

}
