package CollectionDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniqueNum {

	public static void main(String[] args) {
		
		
		int a[] = {2,2,3,4,5,5,5,5};
		
		
		List li = Arrays.asList(a);
		
		li.forEach(s->System.out.println(s));
		
		/*
		 * List<Integer> al = new ArrayList<Integer>(Arrays.asList(a));
		 * System.out.println(al);
		 * 
		 * int[] primes = new int[]{2, 3, 5, 7, 11, 13, 17};
		 * 
		 * ArrayList<Integer> list = IntStream.of(primes) .boxed()
		 * .collect(Collectors.toCollection(ArrayList::new));
		 * 
		 * // Read more:
		 * https://www.java67.com/2019/03/how-to-convert-int-array-to-arraylist-in-java-
		 * 8-example.html#ixzz7IjHezPtL
		 */	        	
	        	
	        
		for(int i = 0; i<li.size();i++) {
//			int b = li[i];
			System.out.println(li.get(i));
		}
	}

}
