package String_prog;

public class ReverseEachWord {
	
	public static void main(String[] args) {
		// dont have reverse function in String bcs string is immutable
		
		String str = "Hello SURBHI HOW ARE YOU";
		
		String rev ="";
		
		String[] words = str.split(" ");
		/*
		char[] rev1 = new char[str.length()];
		for(int i = 0; i<words.length;i++) {
		
			String st = words[i];
				for(int j = st.length()-1; j>=0 ;j--) {
					
					rev1[j] =  st.charAt(j);
					System.out.println(rev1[j]);
				}
				
		} */
		
		System.out.println(str);
		for(String w : words) {
			String reverword = "";
			
			for(int i =w.length()-1 ;i>=0 ; i--) {
				
				reverword = reverword+ w.charAt(i);
			}
			rev = rev+ reverword + " ";
			
		}
		System.out.println(rev);
		//System.out.println(reverword);
		
	}

}
