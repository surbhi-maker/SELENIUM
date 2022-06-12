package String_prog;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;



public class DuplicateInArray {
	public static void main(String[] args) {
		String names[] = {"JAVA", "surbhi1", "surbhi2","surbhi3","surbhi4","JAVA"};
		Map<String, Integer> storeMap = new HashMap<String, Integer>();
		
		for (String name : names) {
			Integer count = storeMap.get(name);
			System.out.println("count: "+count + " name:"+name);
			if (count == null) {
				storeMap.put(name, 1);
			} else {
				storeMap.put(name, count+1);
			}
		}
		Set<Entry<String, Integer>> entrySet = storeMap.entrySet();
		for(Entry<String, Integer> entry : entrySet) {
			if(entry.getValue()>1) {
				System.out.println("dulplicate value::" +entry.getKey());
			}
		}
		System.out.println("***********************************************************88");
		
		Set<String> storeSet = new HashSet<String>();
		for (String name : names) {
			if (storeSet.add(name) == false) {
				System.out.println("Duplicate element: " + name);
			}
		}
	}
}
	
//	String sent = "have a nice day";
	
	
