import org.testng.Assert;
import org.testng.annotations.Test;

import Files.Payload;
import io.restassured.path.json.JsonPath;
@Test
public class ComplexJson {

	public static void main(String[] args) {
		JsonPath js = new JsonPath(Payload.coursePrice());
//		1. Print No of courses returned by API
		int num = js.getInt("courses.size()");
		System.out.println(num);

//		2.Print Purchase Amount
		int amt = js.getInt("dashboard.purchaseAmount");
		System.out.println(amt);

//		3. Print Title of the first course
		String title = js.getString("courses[0].title");
		System.out.println(title);

//		4. Print All course titles and their respective Prices
		int total = 0;
		for (int i = 0; i < num; i++) {
			String title1 = js.getString("courses[" + i + "].title");
			int price1 = js.getInt("courses[" + i + "].price");
			int copies = js.getInt("courses[" + i + "].copies");
			System.out.println("price of :" + title1 + "is==>" + price1 + "total copies " + copies);
//		5. Print no of copies sold by RPA Course
			if (title1.equalsIgnoreCase("RPA")) {
				System.out.println(js.getString("courses[" + i + "].title").toString());
				System.out.println(js.getString("courses[" + i + "].copies").toString());
			}

//		6. Verify if Sum of all Course prices matches with Purchase Amount
			total = total + (price1 * copies);
		}
		System.out.println("Totalpurchase amount : " + total);
		Assert.assertEquals(total, amt);
	}

}
