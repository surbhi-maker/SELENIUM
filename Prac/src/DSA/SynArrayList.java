package DSA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SynArrayList {

	public static void main(String[] args) {
		
		List<String> names = Collections.synchronizedList(new ArrayList<String>());
		names.add("Java");
		names.add("PY");
		names.add("Ruby");
		
		//*******add , remove - we dont need EXPLICIT SYNCHRONIZATION
		//******** TO fetch/TRAVERSE the value from this List  WE HAVE TO USE EXPLICIT SYNCHRONIZATION
		
		//EXPLICIT SYNCHRONIZATION EXAMPLE
				synchronized(names){
					Iterator<String> it = names.iterator();
					
					while(it.hasNext()) {
						System.out.println(it.next());
					}
				}
				
				//2. THREAD SAFE VARIENT OF ARRAYLIST
				// copyOnWriteArrayList  its a class ******************
				
				CopyOnWriteArrayList<String> empList = new CopyOnWriteArrayList<String>();
				empList.add("Surbhi");
				empList.add("hello");
				empList.add("helen");
				
				//DONT NEED ANY EXPLICIT SYNCHRONIZATION IN ANY OPERATION
				//its ALREADY A THREAD SAFE: AT A TIME ONLY ONE THREAD WILL OPERATE
				
				Iterator<String> it = empList.iterator();
				
				while(it.hasNext()) {
					System.out.println(it.next());
				}
				
				
				
				
	}

}
