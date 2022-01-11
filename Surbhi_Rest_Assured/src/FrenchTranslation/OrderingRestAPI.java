package FrenchTranslation;

import java.util.List;

import org.apache.http.HttpStatus;
import org.testng.Assert;

import Enum.EnumInterface.OrderingRestOperations;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;
public class OrderingRestAPI extends OrderingRestUtility1 {
/**
 * This gets the Application Cookie 
 * @return Cookie
 * @lastModifiedBy Pratik Dhole
 * @throws Exception
 */
	
	static String applicationURL = "https://ordering.qa.elementfleet.com/login";
public static String getCookieFromOrderingFO(String username, String password) throws Exception {
	
	
    System.out.println("GET: " + "https://ordering.qa.elementfleet.com");
    Response loginRes = given()
                 .redirects().follow(false)
                 .get("https://ordering.qa.elementfleet.com");
    loginRes.then().assertThat().statusCode(HttpStatus.SC_MOVED_TEMPORARILY);
    String responseLocation = loginRes.getHeader("Location");
    System.out.println("Response Location: " + responseLocation);
    System.out.println("GET: " + responseLocation);
    loginRes = given()
                 .redirects().follow(false)
                 .get(responseLocation);
    loginRes.then().assertThat().statusCode(HttpStatus.SC_MOVED_TEMPORARILY);
    List<String> responseCookieList = loginRes.getHeaders().getValues("Set-Cookie");
    System.out.println("Response Cookie: " + responseCookieList);
    String requestCookie = responseCookieList.get(0).split(";")[0]+";"+responseCookieList.get(1).split(";")[0];
    System.out.println("https://xcelerate2.qa.elementfleet.com/web/common/doLogin".replace("/doLogin", "/login"));
    System.out.println("Request body: "+"username="+ username +"&password="+ password);
    System.out.println("Request cookie list: " + requestCookie);
    loginRes = given()
                 .redirects().follow(false)
                 .contentType(ContentType.URLENC)
                 .header("Cookie", requestCookie)
                 .body("username="+ username +"&password="+ password)
                 .when()
                 .post("https://xcelerate2.qa.elementfleet.com/web/common/doLogin".replace("/doLogin", "/login"))
                 .then().assertThat().statusCode(HttpStatus.SC_MOVED_TEMPORARILY)
                 .extract().response();
    if("Bill_QA_Su"==null) {
           responseLocation = loginRes.getHeader("Location");
    }
    System.out.println("Location: " + responseLocation);
    responseCookieList = loginRes.getHeaders().getValues("Set-Cookie");
    System.out.println("Cookie: " + responseCookieList);
    requestCookie = responseCookieList.get(0).split(";")[0]+";"+responseCookieList.get(1).split(";")[0];
    System.out.println("GET: " + responseLocation.replace("http:", "https:"));
    System.out.println("Request cookie list: " + requestCookie);
    loginRes = given()
                 .redirects().follow(false)
                 .header("Cookie", requestCookie)
                 .get(responseLocation.replace("http:", "https:"));
    loginRes.then().assertThat().statusCode(HttpStatus.SC_MOVED_TEMPORARILY);
    responseLocation = loginRes.getHeader("Location");
    System.out.println("Location: " + responseLocation);
    Assert.assertTrue(responseLocation.contains(applicationURL + "?Authorization="));
    System.out.println("GET: " + responseLocation);
    System.out.println("Request cookie list: " + requestCookie);
    loginRes = given()
                 .redirects().follow(false)
                 .header("Cookie", requestCookie)
                 .get(responseLocation);
    loginRes.then().assertThat().statusCode(HttpStatus.SC_MOVED_TEMPORARILY);
    responseCookieList = loginRes.getHeaders().getValues("Set-Cookie");
    System.out.println("Cookie: " + responseCookieList);
    appCookie = responseCookieList.get(0).split(";")[0] + ";"+ responseCookieList.get(1).split(";")[0]/* +";"+responseCookieList.get(4).split(";")[0] */;
    return appCookie;
}

/**
 * This Method gets the Authentication Token 
 * @return authToken
 * @lastModifiedBy Pratik Dhole
 * @throws Exception
 */
public static String getOauthTokenFromOrderingFO(String appCookie) throws Exception {
	getWebUserRes = given()
			.baseUri(applicationURL.replace("/login", ""))
			.header("Cookie", appCookie)
			.when()
			.redirects().follow(false)
			.get(OrderingRestObjects.RESOURCE_AUTH_TOKEN).then()
			.spec(getResponseSpecBuilder())
			.extract().response();
	authToken = getWebUserRes.jsonPath().getString("oauthToken");
	System.out.println("OAuth token from API: " + authToken.trim());
	boPagesQueueBody = RestAPILogger.generateJsonMessage("Application Authentication Token : " + authToken);
	verifyHelperCallsResponses(getWebUserRes, OrderingRestOperations.APPLICATION_AUTH_TOKEN.name(), OrderingRestObjects.RESOURCE_AUTH_TOKEN);
	return authToken.trim();
}


/**
 * This method builds response specification
 * @author pdhole
 * @lastModifiedBy pdhole
 * @return ResponseSpecification object
 */
public static ResponseSpecification getResponseSpecBuilder() {
	ResponseSpecification responseSpecification = new ResponseSpecBuilder()
			.expectStatusCode(HttpStatus.SC_OK)
			.build();	
	return responseSpecification;
}
}