package FrenchTranslation;

import static io.restassured.RestAssured.given;

import org.apache.http.HttpStatus;

import io.restassured.response.Response;

public class loginFOAPI {
	
	public static String main(String[] args) throws Exception {
	
//		public static String getUserRoleFromOrderingFO(String username) throws Exception {
		
		String userRole = null;
//		init();
		try {
			Response getWebUserRes = given()
					.baseUri("https://ordering.qa.elementfleet.com")
//					.header("Cookie", appCookie)
					.get("/getWebUser")
					.then().assertThat()
					.statusCode(HttpStatus.SC_OK)
					.extract().response();
			userRole = getWebUserRes.jsonPath().getString("roles[0]");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Exception in 'https://ordering.qa.elementfleet.com/getWebUser' api.");
		}
		return userRole;
	
	}
}
//}