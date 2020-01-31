package LibraryAPI;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteBook {
	public static void main(String[] args) {
	
	//Step-1 =Provide the access of Base URL or Host name 
			RestAssured.baseURI="http://216.10.245.166";
			
			//Step-2 = All the parameters & resources should be provided in Given method
			
			Response res=given().
			         header("Content-Type","application/json").
			         body("{\r\n" + 
			         		"   \"ID\": \"Dee123\"\r\n" + 
			         		"}").
			        
			 //Step-3 = We will define which kind of request we are sending along with the resource value in when () block
			         when().
			               post("Library/DeleteBook.php").
			               
			 //Step -4 = Now we will identify that our api request has been made successfully or not by the use of assertions in then () block.
			                then().
			                //assertThat().statusCode(200).
			                extract().response();
			 String ResponseString=res.asString();
	         
	         System.out.println(ResponseString);
			
		  	
		}}
			                
