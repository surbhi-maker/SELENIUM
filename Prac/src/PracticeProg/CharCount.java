package PracticeProg;

public class CharCount {

	public static void main(String[] args) {
		
		String string = "The best of both worlds";    
		int count =0;
		for(int i = 0; i<string.length() ; i++) {
			if(string.charAt(i)!= ' ') {
			count++;
		}
		
	}
		System.out.println("count is :" + count);
	}
}
