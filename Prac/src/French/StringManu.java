package French;

import java.util.ArrayList;
import java.util.List;

public class StringManu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str1="Element Ordering Dealer Assignment Rules";
		
		List<String> head = new ArrayList<>();
		head.add("surbhi kourav");
		head.add(" ");
		head.add("kou");
		
		head.forEach(s->System.out.println(s.replaceAll("\\s*$", "")+"space"));
	}

}
