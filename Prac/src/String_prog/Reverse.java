package String_prog;

public class Reverse {

	public static void main(String[] args) {
		// dont have reverse function in String bcs string is immutable
		
		String str = "Hello SURBHI";
		
		String rev ="";
		
		for(int i = str.length()-1;i>=0;i--) {
			rev+=str.charAt(i);
		}
		System.out.println("reversed String is:"+rev);
		
		String str1 = "SURBHI";
		StringBuffer sb = new StringBuffer(str1);
		System.out.println("reversed String is:"+sb.reverse());
	}
	
	
	
//	String sent = "have a nice day";
	
	
}
