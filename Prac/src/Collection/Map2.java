package Collection;

import java.util.HashMap;
import java.util.Map;

public class Map2 {

	public static void main(String args[]){
	    HashMap<Integer, String> hp = new HashMap<>();
	    hp.put(1,"India");
	    hp.put(2,"US");
	    hp.put(3,"CA");
	    
	    for(Map.Entry e : hp.entrySet()) {
	    	System.out.println(e.getKey()+" "+e.getValue());
	    }
	}
}
