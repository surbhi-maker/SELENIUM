package DynamicPayload;

import io.restassured.path.json.JsonPath;

public class ReuseablelMethos {
	
	public static JsonPath rawToJson(String response) {
		
		JsonPath jsonResponse =  new JsonPath(response);
		
		return jsonResponse ;
	}
}
