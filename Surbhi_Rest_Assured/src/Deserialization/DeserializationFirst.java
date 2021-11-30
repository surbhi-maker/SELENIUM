package Deserialization;
import static io.restassured.RestAssured.given;

import java.util.List;

import io.restassured.parsing.Parser;

public class DeserializationFirst {

	public static void main(String[] args) {
		
		String acccess_token_temp = "ya29.a0ARrdaM_yECyjV0pF1vDxNaDQRZMSn-Dl5ZJERRddCqqLyrf8gtUPLwAy9GKRbDHSQljQNbs-3GXdcs8mMHiRXJueJDF8zx3d0A0og2d3KIl3gWFqVhi5cdtcQFDJJDbVA_xlxoA8UEkaN6-Ea5TVITdYK0NjwA";
		GetCourse gc = given()
				.queryParam("access_token", acccess_token_temp.trim()).expect().defaultParser(Parser.JSON)
				.when().get("https://rahulshettyacademy.com/getCourse.php").as(GetCourse.class);
				
		System.out.println("instructor is************:" + gc.getInstructor());
		System.out.println("Linked in profile is************:" + gc.getLinkedIn());
		System.out.println("services are************:" + gc.getServices());
		
		Courses allCourse  = gc.getCourses();
		List<Api> list  = allCourse.getApi();
		
		for(int i = 0 ; i<list.size();i++) {
		System.out.println(list.get(i).getCourseTitle() + " get price :" + list.get(i).getPrice());
		
		if(list.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing")) {
			System.out.println("soap course found" + "and price is "+ list.get(i).getPrice());
		}
		}

		List<WebAutomation> list2 = allCourse.getWebAutomation();

		for (int i = 0; i < list2.size(); i++) {
			System.out.println("WebAutomation courses are :" + list2.get(i).getCourseTitle() + " get price :" + list2.get(i).getPrice());

		}
		
//		System.out.println("services are************:" + gc.getCourses(Courses.));
	}

}
