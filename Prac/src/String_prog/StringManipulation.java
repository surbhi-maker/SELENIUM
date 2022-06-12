package String_prog;

public class StringManipulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

				String str = "it is raining";
				System.out.println(str.charAt(5)+"next:"+str.charAt(6));
				
				System.out.println(str.indexOf('i', str.indexOf('i')+1));
				
				String a = "hello";
				String b = "world";
				
				a = a+b;
				System.out.println("a before swap is"+ a);
				
				b = a.substring(0, a.length()-b.length());
				System.out.println("b after swap is :"+ b);
				
				a= a.substring(b.length());
				System.out.println("a after swap is :"+ a);
				
				
				String str1 = "Federal Identification Number:  330684706";
				System.out.println("str1 :"+ str1.replaceAll(":\\s",""));
	}

}
