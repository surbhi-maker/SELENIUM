
public class Myclass{
	
//	public static void main(String[] args){
//	
//	System.out.println("hi..");
//	}
	
	 public static void main(String args[]){  
		   try{  
		      //code that may raise exception  
		      int data=100/0;  
		   }catch(ArithmeticException e){
			   
//			   System.out.println(e);
//			   e.printStackTrace();
			   throw e;
		   
		   }  
		   //rest code of the program   
		   System.out.println("rest of the code...");  
		  }  
}