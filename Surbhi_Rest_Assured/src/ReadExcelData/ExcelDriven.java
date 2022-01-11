package ReadExcelData;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import DynamicPayload.ReuseablelMethos;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

/*
 * 
 * https://scalac.io/blog/rest-assured-api-testing-tutorial-java-scala/
 */
public class ExcelDriven {
	@Test
	public void addBook() throws IOException {
		
		DataDriver data = new DataDriver();
		ArrayList<String> a = data.dataDriver("RestAssured" , "RestAssuredSheet");
		
		Map<String, Object> jsonAsMap = new HashMap<>();
		   jsonAsMap.put("name", a.get(1));
		   jsonAsMap.put("isbn", a.get(2));
		   jsonAsMap.put("aisle", a.get(3));
		   jsonAsMap.put("author", a.get(4));
		   
		   /*
		    * for Nested json..
		    * create separate map then pass that map as a value in main map
		    */
		   
		RestAssured.baseURI = "http://216.10.245.166";		
		String resp = given().log().all().header("Content-Type", "application/json")
				.body(jsonAsMap)
				.when().log().all().post("Library/Addbook.php")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath jp = ReuseablelMethos.rawToJson(resp);
		String bookId = jp.get("ID");
		System.out.println("id is :  " +bookId);
		System.out.println("***************DELETE API**********************");
		String respd = given().log().all().header("Content-Type", "application/json")
				.body("{\r\n" + 
						"    \"ID\": \""+bookId+"\"\r\n" + 
						"}")
				.when().log().all().post("Library/DeleteBook.php")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();
		System.out.println("***************DELETE API Executed**********************");
		
}
}
