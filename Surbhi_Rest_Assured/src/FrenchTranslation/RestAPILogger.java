package FrenchTranslation;


import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//import org.json.JSONTokener;

public class RestAPILogger extends OrderingRestUtility1 {
	private static File htmlfileInput;
	public static PrintStream htmllogger;
	public static String HTMLBody;
	public static StringBuffer HTMLBuilder = new StringBuffer();
	public static String requestBody;
	public static int count = 1;
	public static String ApplicationURL ="https://ordering.qa.elementfleet.com/login";
//	ApplicationBOURL
	public static String readFileConvertString(String fileName) throws IOException {
		htmlfileInput = new File(
				System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator
				+ "resources" + File.separator + "TestData" + File.separator + "RestData" + File.separator + fileName);
		return FileUtils.readFileToString(htmlfileInput, StandardCharsets.UTF_8);
	}
	
	public static void generateLogs(String apiResponse, String methodName, String status, String message, String basePath) throws Exception {
		HTMLBody = RestAPILogger.readFileConvertString("zbody.html");
		getRequestPayloadBody(methodName);
		HTMLBody = HTMLBody.replace("$REST_CALL_NAME$", methodName.replace("_", " "));
		methodName = methodName + count;
		HTMLBody = HTMLBody.replace("req_gfg_Run()", methodName +"req_gfg_Run()");
		HTMLBody = HTMLBody.replace("req_hide()", methodName +"_req_hide()");
		HTMLBody = HTMLBody.replace("reqElement", methodName+"reqElement");
		HTMLBody = HTMLBody.replace("reqobj", methodName+"reqobj");
		HTMLBody = HTMLBody.replace("REQUEST_ELEMENT_ID", methodName+"REQUEST_ELEMENT_ID");
		HTMLBody = HTMLBody.replace("resp_gfg_Run()", methodName +"resp_gfg_Run()");
		HTMLBody = HTMLBody.replace("resp_hide()", methodName +"_resp_hide()");
		HTMLBody = HTMLBody.replace("RESPONSE_ELEMENT_ID", methodName+"RESPONSE_ELEMENT_ID");
		HTMLBody = HTMLBody.replace("element", methodName+"element");
		HTMLBody = HTMLBody.replace("resobj", methodName+"resobj");
		HTMLBody = HTMLBody.replace("$URI$", APPLICATION_BASE_URL + basePath);
		HTMLBody = HTMLBody.replace("$requestBody$", requestBody);
//		HTMLBody = HTMLBody.replace("$responseBody$", isValidJson(apiResponse));
		HTMLBody = HTMLBody.replace("$status$", status);
		HTMLBody = HTMLBody.replace("$message$", message);
		HTMLBuilder.append(HTMLBody);
		if("error".equalsIgnoreCase(status)) {
			log();
			throw new Exception("Error - " + status + " & Message - " + message);
		}
		count++;
	}
	
	public static void generateLogsBOPages(String apiResponse, String methodName, String status, String message, String basePath) throws Exception {
		HTMLBody = RestAPILogger.readFileConvertString("zbody.html");
		requestBody = boPagesQueueBody;
		HTMLBody = HTMLBody.replace("$REST_CALL_NAME$", methodName.replace("_", " "));
		methodName = methodName + count;
		HTMLBody = HTMLBody.replace("req_gfg_Run()", methodName +"req_gfg_Run()");
		HTMLBody = HTMLBody.replace("req_hide()", methodName +"_req_hide()");
		HTMLBody = HTMLBody.replace("reqElement", methodName+"reqElement");
		HTMLBody = HTMLBody.replace("reqobj", methodName+"reqobj");
		HTMLBody = HTMLBody.replace("REQUEST_ELEMENT_ID", methodName+"REQUEST_ELEMENT_ID");
		HTMLBody = HTMLBody.replace("resp_gfg_Run()", methodName +"resp_gfg_Run()");
		HTMLBody = HTMLBody.replace("resp_hide()", methodName +"_resp_hide()");
		HTMLBody = HTMLBody.replace("RESPONSE_ELEMENT_ID", methodName+"RESPONSE_ELEMENT_ID");
		HTMLBody = HTMLBody.replace("element", methodName+"element");
		HTMLBody = HTMLBody.replace("resobj", methodName+"resobj");
		HTMLBody = HTMLBody.replace("$URI$", APPLICATION_BASE_URL + basePath);
		HTMLBody = HTMLBody.replace("$requestBody$", requestBody);
//		HTMLBody = HTMLBody.replace("$responseBody$", isValidJson(apiResponse));
		HTMLBody = HTMLBody.replace("$status$", status);
		HTMLBody = HTMLBody.replace("$message$", message);
		HTMLBuilder.append(HTMLBody);
		count++;
	}
	
	public static void log() {
		HTMLHeader = HTMLHeader.replace("$ApplicationURL$",ApplicationURL);
//		HTMLHeader = HTMLHeader.replace("$ApplicationBOURL$", CommonPage.getTestData("ApplicationBOURL"));
//		if(CommonPage.getElementOrderObject().getLogNumber() != null) {
//			HTMLHeader = HTMLHeader.replace("$LOG NUMBER$", CommonPage.getElementOrderObject().getLogNumber());
//		} else {
//			HTMLHeader = HTMLHeader.replace("$LOG NUMBER$", "NA");
//		}
//		if(CommonPage.getElementOrderObject().getDriverTabObject().getOrderID() != null) {
//			HTMLHeader = HTMLHeader.replace("$ORDER ID$", CommonPage.getElementOrderObject().getDriverTabObject().getOrderID());
//		} else {
//			HTMLHeader = HTMLHeader.replace("$ORDER ID$", "NA");
//		}
		HTMLHeader = HTMLHeader.replace("$BODY$", HTMLBuilder);
		htmllogger = new PrintStream(htmlLogfile);
		htmllogger.append(HTMLHeader);
		htmllogger.close();
	}
	
	public static void getRequestPayloadBody(String methodName) {
		switch (methodName) {
			case "START_HERE_PAGE":
//				requestBody = startHerePageRequestBody;
				break;
				/*
				 * case "DRIVER_PAGE": requestBody = driverPageRequestBody; break; case
				 * "VEHICLE_PAGE": requestBody = vehiclePageRequestBody; break; case
				 * "BILLING_PAGE": requestBody = billingPageRequestBody; break; case
				 * "DEALER_PAGE": requestBody = dealerPageRequestBody; break; case
				 * "SUMBIT_ORDER_PAGE": requestBody = submitOrdeRequestBody; break; defa
				ult: requestBody = boPagesQueueBody; */
		}
	}
	
	public static String generateJsonMessage(String message) {
		return "{\r\n" + 
				"  \"message\" : \""+ message +"\"\r\n" + 
				"}";
	}
	/*
	public static String isValidJson(String jsonStr) throws JSONException {
		Object json = null;
		json = new JSONTokener(jsonStr).nextValue();
		if (json instanceof JSONObject || json instanceof JSONArray) {
			return json.toString();
		} else {
			return generateJsonMessage(jsonStr);
		}
	} */
}

