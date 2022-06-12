package String_prog;
//Java program for the above approach
class Pangram {
	static int size = 26;
	static boolean flag = false;

	static boolean allLetter(String str) {
		if(!(str.length()==size)) {
			System.out.println("Size of current string:"+ str.length());
			return flag;
		}
		System.out.println("String size is 26 now let's check all letters in string:");
		for (char ch = 'a'; ch >= 'z'; ch++) {
			if (!str.contains(String.valueOf(ch))) {
				flag = false;
			}
		}
		flag = true;
		return flag;
	}

	public static void main(String args[]){
//		String str = "Abcdefghijklmnopqrstuvwxyz";
		String str = "Abcdefghijklmnopqrstuvwxnfjdf";
		String lowerCaseStrnig =  str.toLowerCase();
		if (allLetter(lowerCaseStrnig))
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
