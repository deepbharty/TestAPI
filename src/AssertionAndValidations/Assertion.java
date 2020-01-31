package AssertionAndValidations;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class Assertion {
	
	public static void main(String[] args) {
		
		//Step 1 i will provide the access of base URl first
		
		RestAssured.baseURI="https://maps.googleapis.com";
		
		//Step 2 all the parameters and keys will be processed in given() block
		
		Response res=given().
		       param("key","AIzaSyBcy2C9_n9OlAc9vdNw6eoWGBkAia0-xNY").
		       param("query","Gate Way of India").
		       
		  //Step 3 we will pass request type along with the resource in when block
		       
		       when().
		       
		       get("/maps/api/place/textsearch/json").
		       
		       then().and().assertThat().statusCode(200).and().contentType("application/json")
		       .header("Server","scaffolding on HTTPServer2").and().
		       //body("results[0].geometry.location.lat",equalTo("18.9219841"));
		      // body("results[0].name",equalTo("Gateway Of India Mumbai"));
		       body("results[0].place_id",equalTo("ChIJrVwNOsfR5zsRPHOcIKclCsc")).
		       
		       extract().response();
		
		String ResString=res.asString();
		
		System.out.println(ResString);
		
		System.out.println("Api Run successfully");
	}
 
}
