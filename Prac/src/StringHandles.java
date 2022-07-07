
public class StringHandles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "NEWPORT BEACH           ,CA 92660,";
		
		String str1 =str.trim().replaceAll("\\s*\\,", ",");
		System.out.println("String1: "+str1.replaceAll(",", ", ")+"space");
		
		System.out.println("String1.1: "+str1.replaceAll(",$", "")+"space");
		System.out.println("String2: "+str1.replaceAll("\\s+", " ").trim()+"space");
		
		String str2 =str.trim().replaceAll("\\s+", " ");
		System.out.println("String3: "+str2+"space");
		
		
		String str3 =str.trim().replaceAll(", $", "");
		System.out.println("String4: "+str3+"space");
		
		String myString = "NEWPORT BEACH  ,CA 92660,,   SQV ,";
		// replace all consecutive spaces and commas by a space and a comma respectively
	    String sanitizedString = myString.replaceAll("\\s+", " ").replaceAll(",+", ",");

	    System.out.println("sanitizedString 1: "+sanitizedString+"space");
	    
	    // replace all resulting comma and space combinations
	    sanitizedString = sanitizedString.replaceAll("( , )+|( ,)+|(, )+", ",").replaceAll(",+", ",");

	    System.out.println("sanitizedString 2: "+sanitizedString+"space");
	    
	    // remove leading and trailing commas (if any)
	    sanitizedString = sanitizedString.replaceFirst("^,", "").replaceFirst(",$", "");
	    System.out.println("sanitizedString 3: "+sanitizedString+"space");
	    
	    // add a space between comma (merely for readability) **** optional ****
	    sanitizedString = sanitizedString.replace(",", ", ");
	    
	    System.out.println("sanitizedString 4: "+sanitizedString+"space");
	}

}
