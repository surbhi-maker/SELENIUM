package String_prog;

import java.util.HashSet;
import java.util.Set;

public class MaximumOccurances
	{
		public static void main(String[] args) {
			String str = "surbhisssfYY";
			char[] a = str.toCharArray();
			Set<Character> s1 = new HashSet<>();
			int max = 0;
			for(char e : a) {
				if (s1.add(e) == true) {
					System.out.println("count of s:" + e + " is : " + charCount(str, e));
					if (charCount(str, e) > max) {
						max = charCount(str, e);
					}
				}
			}
			
			System.out.println("max occurances: " +max);
			System.out.println("count of s:"+charCount(str, 's'));
		}

		private static int charCount(String word, char character) {
			int count=0;
			for(int i=0;i<word.length();i++) {
				if(word.charAt(i)== character) {
					count++;
				}
			}
			return count;
		}

}
