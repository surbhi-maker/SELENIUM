package OAuthCode2;
import static io.restassured.RestAssured.given;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.restassured.path.json.JsonPath;


public class OAuthCode {
	
	public static void main(String[] args) {
			
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\SKourav\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
//		driver.get("https://accounts.google.com/o/oauth2/v2/auth/oauthchooseaccount?scope=https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&auth_url=https%3A%2F%2Faccounts.google.com%2Fo%2Foauth2%2Fv2%2Fauth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https%3A%2F%2Frahulshettyacademy.com%2FgetCourse.php&flowName=GeneralOAuthFlow");
//		driver.findElement(By.cssSelector("input[type='email']")).sendKeys("surbhimamar99@gmail.com");
//		driver.findElement(By.cssSelector("input[type='email']")).sendKeys(Keys.ENTER);
//		driver.findElement(By.cssSelector("//span[contains(text(),'Next')]")).click();
//		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("Dream@88");
//		driver.findElement(By.cssSelector("input[type='password']")).sendKeys(Keys.ENTER);
//		driver.findElement(By.cssSelector("//span[contains(text(),'Next')]")).click();
//		
//		String url = driver.getCurrentUrl();
		
//		String url = "https://www.googleapis.com/oauth2/v4/token?code=4%2F0AX4XfWjMzfvJJEMQRue3qNP-GdBp_DFFzktasxzWWMtdpwQkfR5uRiFLxzeYZs-2EHISjA&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&client_secret=erZOWM9g3UtwNRj340YYaK_W&grant_type=authorization_code&redirect_uri=https://rahulshettyacademy.com/getCourse.php";
//		String partialcode=url.split("code=")[1];
//		String code=partialcode.split("&scope")[0];
//		
//		System.out.println("###################code part"+ partialcode);
//		System.out.println("################### code:" + code);
		
//		String url ="https://rahulshettyacademy.com/getCourse.php?code=4%2F0AX4XfWgIga-whmSlMH9wO0caSZ631sGkh5p2yQIMcVCqDvOWwhOeWtTmRXgeUvycao4V4w&scope=email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&authuser=0&prompt=none#";
//
//		String partialcode=url.split("code=")[1];
//
//		String code=partialcode.split("&scope")[0];

		
		
//		String code1 = "4%2F0AX4XfWi9Co9TwKZcqNcQL8kdP8vXxx29OmQo8mMX6VWa-TCOu6aX2-bFdvDh7gEwUbH78g";
//		System.out.println("###################" + code1);
//		String access_token_res = given().log().all().queryParams("code", code1)
//		.queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
//		.queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
//		.queryParams("grant_type", "authorization_code")
//		.queryParams("redirect_uri","https://rahulshettyacademy.com/getCourse.php")
//		.when().log().all().post("https://www.googleapis.com/oauth2/v4/token")
//		.asString();
//		
//		JsonPath js = new JsonPath(access_token_res);
//		String access_token1 = js.getString("access_token");
//		System.out.println("&&&&&&&&&&&&&&&&  access_token1 is *************:" + access_token1);
		
		
		
		String acccess_token_temp = "ya29.a0ARrdaM9W4wAzBiksRjpQs130ObDRKwKDBgUE1RQ65TGYeyooBHsDBUnYP2-0hTM62Bq6V9HbWrYUBeZYkszr_QDIGkbWJDolFG7G8uWFAKYhC5hxbdQYEkdsnn4ssGMprOEccNINr7lmSmHL_EV0immu0X1dKg";
		String response = given().log().all()
				.queryParam("access_token", acccess_token_temp.trim())
				.when().log().all().get("https://rahulshettyacademy.com/getCourse.php").asString();
				
		JsonPath jsp = new JsonPath(response);
		String instructor = jsp.getString("instructor");
		System.out.println("instructor is**************************:" + instructor);
		
	}
}