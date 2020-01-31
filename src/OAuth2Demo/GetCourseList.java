package OAuth2Demo;

import static io.restassured.RestAssured.given;
import io.restassured.path.json.JsonPath;

public class GetCourseList {
	
	public static void main(String[] args) throws InterruptedException {
		
		//step 1 UI Automation invoke the chrome browser
		
		//Step-2 getting the Code
		
		String URL="https://rahulshettyacademy.com/getCourse.php?state=TestMode&code=4%2FvwGlc31icpS71A06n-5MNecu_PxDkr9hbqYYoRnhU-i7wM2sdzweHQS-FN6UncoY1Vl2ZBnmm9Iw7eV4hukqnFg&scope=email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&authuser=0&prompt=none&session_state=003314e9f5b6dbb47253e60472a49bbca638d5c9..343d#";
		
		String PartialCode=URL.split("code=")[1];
		String code=PartialCode.split("&scope")[0];
		System.out.println(code);
		
//Step-4 exchnaging the Code to get the Access Token
		
		String Res=given().urlEncodingEnabled(false).
				 queryParams("code",code).
				 queryParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com").
				 queryParams("client_secret","erZOWM9g3UtwNRj340YYaK_W").
				 queryParams("redirect_uri","https://rahulshettyacademy.com/getCourse.php").
				 queryParams("grant_type","authorization_code").
				 
				 when().
				 
				 post("https://www.googleapis.com/oauth2/v4/token").asString();
		
		//Parsing the JSON to get the Access token
		
		JsonPath js=new JsonPath(Res);
		String access_token=js.get("access_token");		 
		System.out.println(access_token);
				 
//Step-3 Getting our response by using the Access Token		 
				 
				 String ResString=given().log().all().
							queryParam("access_token",access_token)
							.when().
							get("https://rahulshettyacademy.com/getCourse.php").asString();
				 
				 System.out.println(ResString);
							
/* if we want to extract the response but we dont want to use assertions in our code that means we want to skip then() and extract.
* then we have sort cut way to get the response. In this we will extract the response in string method and we have to define that raw data as in string format.
 * that means we need to create a string variable with the given block to store the response.*/
				
	}

}
