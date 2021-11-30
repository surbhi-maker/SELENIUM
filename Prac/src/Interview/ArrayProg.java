package Interview;

public class ArrayProg {

	public static void main(String[] args) {
		
		int[] num = {5,10,10,4,4,5,6,7,8,9 };
		
		for(int i = 1 ; i <num.length ; i++) {
			System.out.println("previous first " + num[i -1]);
			System.out.println("current element" +num[i]);
			
			int max = num[0];
			if(max<num[i]) {
				max = num[i];
			}
			System.out.println("***********************************");
			System.out.println("max element" + max);
			System.out.println("num.length element" + num.length);
		}
		
		System.out.println("***********************************");
		for(int i = 0 ; i<num.length ;i++) {
			for(int j = i+1 ; j<(num.length-1);j++) {
				if(num[i]==num[j]) {
					System.out.println("duplicate element" +num[i]);
				}
			}
		}
		System.out.println("***********************************");
		for(int i = 0 ; i<num.length ;i++) {
			for(int j = i+1 ; j<(num.length-1);j++) {
				if(num[i]==num[j]) {
				
				}
			}
		}
	}

}
