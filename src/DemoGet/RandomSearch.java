package DemoGet;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class RandomSearch {
	
	public static void main(String[] args) {
		
		//Step 1 we need to have base URl
		
		RestAssured.baseURI="https://maps.googleapis.com";
		
		//Step 2 
		
		Response res=given().
		param("key","AIzaSyDyQZLLkiTM7Wdnthi3VynpYM07vivPxxY").
		param("query","Gate way of india").
		
		//Step 3
		
		when().
		get("/maps/api/place/textsearch/json").
		
		// step 3
		
		then().and().assertThat().statusCode(200).and().contentType("application/json").header("Server", "scaffolding on HTTPServer2").
//body("results[0].geometry.location.lat",equalTo("18.9219841"));
	//	body("results[0].name",equalTo("Gateway Of India Mumbai"));	
		
		body("results[0].place_id",equalTo("ChIJrVwNOsfR5zsRPHOcIKclCsc")).
		
		//Step 4 extracting response 
		
		extract().response();
		
		
		String ResString=res.asString();
		
		System.out.println(ResString);
		
		System.out.println("Api run successfully");
		
		
	}

}
