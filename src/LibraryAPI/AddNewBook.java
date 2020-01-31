package LibraryAPI;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
 
public class AddNewBook {
	public static void main(String[] args) {
		
		//Step-1 =Provide the access of Base URL or Host name 
		RestAssured.baseURI="http://216.10.245.166";
		
		//Step-2 = All the parameters & resources should be provided in Given method
		
		Response res=given().
		         header("Content-Type","application/json").
		//Step 3 we will pass our body inside the given block
		         
		         body("{\r\n" + 
		         		"   \"name\": \"Learn Rest API Automation with Java\",\r\n" + 
		         		"   \"isbn\": \"Dee\",\r\n" + 
		         		"   \"aisle\": \"123\",\r\n" + 
		         		"   \"author\": \"Deepak Bharty\"\r\n" + 
		         		"}").
		        
		 //Step-3 = We will use when block to define our Post request
		         when().
		               post("Library/Addbook.php").
		               
	//Step -4 = Now we will identify that our api request has been made successfully or not by the use of assertions in then () block.
		                then().
		                    //assertThat().statusCode(200).
		                extract().response();
		
		 String ResponseString=res.asString();
         
         System.out.println(ResponseString);
         
		/** if we will try to add a book which is already existing in the DB then it will display book already existed message 
		 * for seeing this message we need to remove status code assertion "assertThat().statusCode(200)" from the above code  **/
		
	}}