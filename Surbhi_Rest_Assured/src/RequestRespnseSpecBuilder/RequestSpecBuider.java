package RequestRespnseSpecBuilder;

import java.io.PrintStream;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpecBuider {
		
	public static PrintStream log;
	public static RequestSpecification getRequestSpecBuilder() {
		RequestSpecification requestSpecification = new RequestSpecBuilder()
				.setBaseUri("https://rahulshettyacademy.com")
				.setContentType(ContentType.JSON)
				.addQueryParam("key", "qalick123")
//				.addHeader("Authorization", authToken)
//				.addFilter(RequestLoggingFilter.logRequestTo(log))
//				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.build();
//		log.append(OrderingRestOperations.REST_CALL_SEPARATOR.toString());
		return requestSpecification;
	}
}
