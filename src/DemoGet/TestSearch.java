package DemoGet;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
public class TestSearch {
	
	public static void main(String[] args) {
		
		//Step 1 i will provide the access of base URl first
		
		RestAssured.baseURI="https://maps.googleapis.com";
		
		//Step 2 all the parameters and keys will be processed in given() block
		
		given().
		       param("key","AIzaSyBcy2C9_n9OlAc9vdNw6eoWGBkAia0-xNY").
		       param("query","Gate Way of India").
		       
		  //Step 3 we will pass request type along with the resource in when block
		       
		       when().
		       
		       get("/maps/api/place/textsearch/json");
		
		System.out.println("Api Run successfully");
	}

}
