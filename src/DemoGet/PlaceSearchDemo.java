package DemoGet;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class PlaceSearchDemo {
	public static void main(String[] args) {
		
		//Step-1 =Provide the access of Base URL or Host name 
		RestAssured.baseURI="https://maps.googleapis.com";
		
		//Step-2 = All the parameters & resources should be provided in Given method
		
		given().
		         param("query","123+main+street").
		         param("key","AIzaSyCIDgfGgy56Je7RCK3Jzq6MFS4HvgJr0-Q").
		         
		 //Step-3 = We will define which kind of request we are sending along with the resource value in when () block
		         when().
		               get("/maps/api/place/textsearch/json").
		               
		 //Step -4 = Now we will identify that our api request has been made successfully or not by the use of assertions in then () block.
		                then().assertThat().statusCode(200);
		 
		System.out.println(" Api request has been made successfully");
		                
		                 
	}

}
