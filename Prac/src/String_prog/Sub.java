package String_prog;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sub {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "London, ON N6E 1L8 Provincial ID" ;
		
		String[] star = str.split("Provincial");
		int zipCodeIndex = star[0].trim().length() -4;
//		System.out.println(star[0]);
//		System.out.println(star[0].length());
//		System.out.println(zipCodeIndex);
		
		System.out.println(star[0].lastIndexOf(" "));
		
//		System.out.println(star[0].replace(star[0].lastIndexOf(" "), ""));
		System.out.println(star[0].replace(star[0].substring(zipCodeIndex), star[0].substring(zipCodeIndex).trim()));
		
		System.out.println(star[1]);
		
		String str1 = "London, ON N6E 1L8"; 
		
		String[] zip = str1.split("ON");
		System.out.println(zip[0]);
		System.out.println(zip[1]);
		System.out.println("str1 contains ON is"+ str1.substring(str1.length()-4).trim()+"blnk test");
		System.out.println(str1.replaceAll("\\S*\\d\\S.$",""));
		String new1 = str1.replaceAll("\\S*\\d\\S.$","").trim();
		System.out.println("str1 contains ON is=>"+ new1.concat(str1.substring(str1.length()-4).trim()));
		System.out.println("blank is" +str1.charAt(str1.length()-4)+"test");
		
		String provin = "Provincial ID SHOPP485960002";
		
		System.out.println("pro+++++++++++++++++++++++++++++++++"+ provin.replaceAll("\\s*\\S+\\d.*", ":"));
		System.out.println("pro+++++++++++++++++++++++++++++++++"+ provin.replaceAll("\\S*\\s", ""));
		System.out.println("pro final+++++++++++++++++++++++++++++++++"+provin.replaceAll("\\s*\\S+\\d.*", ": ").concat(provin.replaceAll("\\S*\\s", "")));
		
		System.out.println("TO pattern***********");
		System.out.println(str1.replaceAll("\\s+\\d\\s\\d$","j"));
//		System.out.println(str1.matches("[*0-9]$"));
//		System.out.println(isAlphaNumeric(str1));
//		System.out.println(str1.matches("[a-zA-Z0-9]"));
		System.out.println(validateZip(str1));
		
		System.out.println("pattern***********");
		System.out.println(str1.replaceAll("\\d\\S\\d.$",""));
		
		System.out.println(str1.matches(".*\\d.*"));
//		System.out.println(str1.replaceAll(".*\\d.*\\s",""));
		System.out.println(str1.replaceAll("\\S*\\d\\S.$",""));
		
		System.out.println(str1.replaceAll("\\S*\\d\\S+\\s+\\S.$","J"));
		
		Pattern p = Pattern.compile("\\s.*\\d.*");
		Matcher m = p.matcher("London, ON N6E 1L8");
		boolean b = m.find();
		System.out.println(b);
	}

	public static boolean isAlphaNumeric(String s) {
	    return  s != null && s.matches("^[a-zA-Z0-9]*$");
	}
	public static boolean isAlphaNumeric2(String s) {
	    return  s != null && s.matches("\\S*\\d\\S+\\s+\\S.$");
	}
	
	public static boolean validateZip( String zip )
	   {
	      return zip.matches( "\\S*\\d\\S+\\s+\\S.$" );
	   } 

}
