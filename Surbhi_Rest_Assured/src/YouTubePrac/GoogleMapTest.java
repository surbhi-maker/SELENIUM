package YouTubePrac;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class GoogleMapTest {
	
	@Test
	public void googleMapTest() {
		
		//base url
		RestAssured.baseURI = "https://www.google.com/maps";
		
		//request header
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response object
		
	}
}
