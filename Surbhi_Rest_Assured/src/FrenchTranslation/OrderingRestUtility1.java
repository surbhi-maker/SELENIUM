package FrenchTranslation;



import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;

import org.apache.http.HttpStatus;

//import com.element.fleet.ordering.commonutility.CommonPage;
//import com.element.fleet.ordering.exceptions.OrderingErrorOccured;
//import com.ge.capital.rainbow.common.utils.SimpleStringCipher;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class OrderingRestUtility1 implements OrderingRestObjects{
	
	public static String userName;
	public static String password;
	public static String appCookie;
	public static String authToken;
	public static String APPLICATION_BASE_URL;
	public static Response getWebUserRes;
	public static RequestSpecification requestSpecification;
	public static File file;
	public static FileOutputStream htmlLogfile;
	public static PrintStream log;
	public static FileInputStream fileInput;
	public static FileInputStream excelFileInput;
	public static int orderId;
	public static String logNumber;
	public static String driverEmployeeID;
	public static String HTMLHeader;
	public static String boPagesQueueBody;
	
	public static void init() throws Exception {
		userName = "Bill_QA_Su";
		password = "testqa12";
		APPLICATION_BASE_URL = "https://ordering.qa.elementfleet.com";
//		CommonPage.loadXMLParameterToTestData("URL", APPLICATION_BASE_URL);
//		CommonPage.loadXMLParameterToTestData("BoURL", CommonPage.getTestData("ApplicationBOURL").replace("/login", ""));
		file = new File(System.getProperty("user.dir") + File.separator + "target" + File.separator + "CompleteLogFile.txt");
		log = new PrintStream(file);
		htmlLogfile = new FileOutputStream(System.getProperty("user.dir") + File.separator + "target" + File.separator + "RestCallLogs.html");
//		HTMLHeader = RestAPILogger.readFileConvertString("zheader.html");
//		CommonPage.initializeElementOrderObject();
//		loadRestAssuredData();
		appCookie = OrderingRestAPI.getCookieFromOrderingFO(userName, password);
		authToken = OrderingRestAPI.getOauthTokenFromOrderingFO(appCookie);
	}
	/**
	 * This Method gets user role 
	 * @return userRole
	 * @lastModifiedBy djawale
	 * @throws Exception
	 */
	public static String getUserRoleFromOrderingFO(String username) throws Exception {
		String userRole = null;
		OrderingRestUtility1.init();
		try {
			getWebUserRes = given()
					.baseUri(APPLICATION_BASE_URL)
					.header("Cookie", appCookie)
					.get(OrderingRestObjects.RESOURCE_AUTH_TOKEN)
					.then().assertThat()
					.statusCode(HttpStatus.SC_OK)
					.extract().response();
			userRole = getWebUserRes.jsonPath().getString("roles[0]");
			System.out.println(userRole);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Exception in 'https://ordering.qa.elementfleet.com/getWebUser' api.");
		}
		return userRole;
	}
	
	/**
	 * This method used for HTML logging of API calls. Specifically designed for Helping APIs used in Create Order API.
	 * @author pdhole
	 * @lastModifiedBy pdhole
	 * @param API Response
	 * @param Front Office Tab
	 * @param Base Path
	 * @throws Exception
	 */
	public static void verifyHelperCallsResponses(Response response, String frontOfficeTab, String basePath) throws Exception {
		boolean statusCheck = false;
		if(response.getStatusCode()==200 || response.getStatusCode()==302) {
			statusCheck = true;
		}
		String status = statusCheck ? "Success": "Error";
		String message = "Helper REST call for Section " + frontOfficeTab.replace("_", " ") + " is Saved";
		if(status.equalsIgnoreCase("Error")) {
			message = "Helper REST call for Section " + frontOfficeTab.replace("_", " ") + " is Failed";
		}
		RestAPILogger.generateLogs(response.asString(), frontOfficeTab, status, message, basePath);
	}
}
