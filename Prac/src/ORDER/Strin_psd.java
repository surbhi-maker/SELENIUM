package ORDER;

public class Strin_psd {

	public static void main(String[] args) throws InterruptedException {
		
		String str= "F805793-1    "
				+ "new_MSRP_bmw";
		
		System.out.println(str.replaceAll("\\s+\\S*", "").trim());
		
		String str1= "price    "
				+ "protected";
		
		System.out.println(str1.replaceAll("\\s+", " ").trim());
		
		System.out.println("Price & Configuration Status".contains("Price & Configuration Status"));
		System.out.println(Math.min(Double.MIN_VALUE, 0.0d));
		System.out.println(Math.min(Double.MAX_VALUE, 0.0d));
		System.out.println(Math.min(Integer.MAX_VALUE, 0));
		
	}
	
}
