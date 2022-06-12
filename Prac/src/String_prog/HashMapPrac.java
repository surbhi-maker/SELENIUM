package String_prog;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapPrac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<String, Integer> storeMap = new HashMap<String, Integer>();
		/*
		storeMap.put("Surbhi", 1);
		storeMap.put("Surbhi", 2);
		storeMap.put("Surbhi2", 3);
		storeMap.put("Surbhi3", 4);
		
		Set<Entry<String, Integer>> entrySet = storeMap.entrySet();
		
		for(Entry<String, Integer> entry:entrySet) {
			
			Integer count = storeMap.get(entry.getKey());
			System.out.println("count: "+ count );
			System.out.println("Key: " +entry.getKey() + " value: " + entry.getValue());
		} */
		//*****************************************************************remove duplicate**********************************
		String[] names = {"surbhi" , "surbhi1" ,"surbhi" ,"abc" ,"bcd","abc"} ;
		
		for(String name : names) {
			Integer count = storeMap.get(name);
			System.out.println("count :"+ count);
					
			if(count==null) {
				storeMap.put(name, 1);
			}else {
				storeMap.put(name, count+1);
			}
		}
		
		Set<Entry<String , Integer>> entrySet = storeMap.entrySet();
		for(Entry<String , Integer> entry : entrySet) {
			System.out.println("key: " +entry.getKey() + " value"+ entry.getValue());
		}
		
		//***************************************************** find duplicate *****************************************************
		
		Set<String> setStore = new HashSet<>();
		for(String name : names) {
			if(setStore.add(name)== false) {
				System.out.println("duplicate element:"+ name);
			}
		}
	}
}
