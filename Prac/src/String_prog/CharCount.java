package String_prog;

public class CharCount {

	public static void main(String[] args) {
		
		String s ="Surbhi Automation engineer      ";
		
		int count =0;
		for(int i=0 ; i<s.length();i++) {
			if(s.charAt(i)!= ' ') {
			count++;
			}
		}
		System.out.println("chr count is" + count);
	}

}
