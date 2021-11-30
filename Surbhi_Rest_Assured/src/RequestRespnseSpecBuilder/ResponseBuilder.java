package RequestRespnseSpecBuilder;

import org.apache.http.HttpStatus;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

public class ResponseBuilder {
	
	public static ResponseSpecification getResponseSpecBuilder() {
		ResponseSpecification responseSpecification = new ResponseSpecBuilder()
				.expectStatusCode(HttpStatus.SC_OK)
				.build();	
		return responseSpecification;
	}
}
