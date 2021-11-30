package Interview;

public class Palindrome {
	
	static boolean isPalindrome(String tocheck ) {
		
		int len = tocheck.length();
		int length = len - 1;
		System.out.println(length);
		
		if(tocheck.isEmpty()) { 
			return false;
		}
			int i =0 , j = length;
			while (i < j) {
				if (tocheck.charAt(i) != tocheck.charAt(j))
					return false;
				System.out.println("first :" + tocheck.charAt(i));
				System.out.println("from last :" + tocheck.charAt(j));
				i++;
				j--;
			}
			return true;
	}

	public static void main(String[] args) {

		String str = "MANAMANAM";
		if(isPalindrome(str.toLowerCase()))
        System.out.print("Yes");    // It is a palindrome
    else
        System.out.print("No");   // Not a palindrome
	}

}
