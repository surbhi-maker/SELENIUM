package String_prog;

public class StringProg {

	public static void main(String[] args) {

		String v = "al2haba8d"; // allhabaad
		String newS = "";
		String newStr="";

		for (int i = 0; i < v.length(); i++) {
			if (Character.isDigit(v.charAt(i))) {
				int n = Character.getNumericValue(v.charAt(i));
				System.out.println("numeric:" + n);
				for (int j = 1; j < n; j++) {
					newS += v.charAt(i - 1);
				}
			} else {
				newS += v.charAt(i);
			}
// case 2
			if (!(v.charAt(i) >= 'a' && v.charAt(i) <= 'z')) {
				int n1 = v.indexOf(v.charAt(i));
				for (int j = 0; j < n1; j++) {
					v.replace(v.charAt(i), v.charAt(i - 1));
				}
					newStr += v.charAt(i - 1);
				}
				else {
					newStr += v.charAt(i);
				}
						}
		System.out.println("case1 :"+newS);
		System.out.println("case2 new String **:" +newStr);
	}
}
