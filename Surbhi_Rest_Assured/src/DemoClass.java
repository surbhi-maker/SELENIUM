import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import Files.Payload;

public class DemoClass {

	public static void main(String[] args) {
		System.out.println("First API Validation");

		// VALIDATE if add place api is working as expected

		// given()
		// when()
		// then()

		// https://rahulshettyacademy.com/maps/api/place/add/json?key=qaclick123

		RestAssured.baseURI = "https://rahulshettyacademy.com";

		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(Payload.addPlace()).when().log().all().post("maps/api/place/add/json").then().log().all()
				.assertThat().statusCode(200)
//		.header("server", "Apache")
				.body("scope", equalTo("APP")).extract().asString();
		System.out.println("repsonse is :" + response);

		// parse string in to JSON
		JsonPath jp = new JsonPath(response);
		String placeId = jp.getString("place_id");
		System.out.println(" placeId is :" + placeId); //extracted
		
		//check what place is added by get API
		String addedPLace=  given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeId)
				 .when().log().all().get("maps/api/place/get/json").then().assertThat().statusCode(200)
				 .extract().asString();
		
		JsonPath added = new JsonPath(addedPLace);
		String addressADDED = added.getString("address");
		
		System.out.println(" ************ Actual address  ************ "+ addressADDED);
		
		//UPDATE PLACE
		
		String newAddress = "70 Summer walk, USA";
		
		 given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body("{\r\n" + 
						"    \"place_id\": \"" + placeId + "\",\r\n" + 
						"    \"address\": \" "+newAddress+" \",\r\n" + 
						"    \"key\": \"qaclick123\"\r\n" + 
						"}")
				.when().log().all().put("maps/api/place/update/json").then().log().all()
				.assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
		

		 //NOW check if place is updated successfully or not 
		 
		String actualUpdated =  given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeId)
		 .when().log().all().get("maps/api/place/get/json").then().assertThat().statusCode(200)
		 .extract().asString();
		 
		JsonPath js = new JsonPath(actualUpdated);
		String addressUPDATED = js.getString("address");
		
		System.out.println(" ************ updated address    ************ " + addressUPDATED);
		System.out.println(" ************ newAddress address  ************" + newAddress.replaceAll(" ", ""));
		
	
		Assert.assertEquals(addressUPDATED.trim() ,newAddress.trim());
	}

}
