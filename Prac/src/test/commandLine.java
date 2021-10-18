package test;

public class commandLine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			if(args.length>0) {
				System.out.println("length is greater than 0");
				
				for(String val : args) {
					System.out.println("length is greater than 0 ie :" + val);
				}
			} else
	            System.out.println("No command line "
                        + "arguments found.");
}
	}


