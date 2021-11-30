package DynamicPayload;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class DynamicPayloadClass {

	@Test(dataProvider = "BookAnyName")
	public void addBook(String isbn , String aisle) {

		RestAssured.baseURI = "http://216.10.245.166";		
		String resp = given().log().all().header("Content-Type", "application/json")
				.body(Payload.addBookPayload(isbn , aisle))
				.when().log().all().post("Library/Addbook.php")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath jp = ReuseablelMethos.rawToJson(resp);
		String bookId = jp.get("ID");
		
		System.out.println("id is :  " +bookId);
		
//		String addedBook=  given().log().all().queryParam("ID", bookId)
//				 .when().log().all().get("Library/GetBook.php").then().assertThat().statusCode(200)
//				 .extract().asString();
//		
//		JsonPath getbook = ReuseablelMethos.rawToJson(addedBook);
//		String bookAuthor = getbook.getString("author");
//		System.out.println("bookAuthor is :  " +bookAuthor);
		
		
		
	}
	
	@DataProvider(name = "BookAnyName")
	public Object[][] bookesToBeAdded(){
		
		return new Object[][] {{"abc11" , "surbhi"},{"ab231", "mamar"},{"23bn1", "singh"}};
		
	}
	
	
	
	
}
