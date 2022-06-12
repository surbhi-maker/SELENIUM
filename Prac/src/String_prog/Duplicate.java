package String_prog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Duplicate {

	public static void main(String[] args) {
		
		int[] num = {12,13,14,11,67,89,99};
		
		ArrayList<Integer> l1= new ArrayList();
		int count = 0;
		for(int i =0; i<num.length ;i++) {
			if(!l1.contains(num[i])) {
				l1.add(i);
				count++;
			}
			for(int j = i+1; j<num.length;j++) {
				
			}
		}
		List<Integer> ar =Arrays.asList(22,44,22,44,66,77,99);
		List<Integer> l2 = ar.stream().distinct().collect(Collectors.toList());
		
		l2.forEach(s->System.out.println(s));
		
		HashSet<Integer> s1 = new HashSet<Integer>(ar);
		System.out.println("records in set:"+s1);
		
		
	}

}
