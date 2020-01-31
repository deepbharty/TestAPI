package LibraryAPI;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AddBookThenGetBookID {
	public static void main(String[] args) {
		
		//Step-1 =Provide the access of Base URL or Host name 
		RestAssured.baseURI="http://216.10.245.166";
		
		//Step-2 = All the parameters & resources should be provided in Given method
		
		Response res=given().
		         header("Content-Type","application/json").
		         body("{\r\n" + 
		         		"   \"name\": \"Selenium Automation with JAVA\",\r\n" + 
		         		"   \"isbn\": \"Deo\",\r\n" + 
		         		"   \"aisle\": \"106\",\r\n" + 
		         		"   \"author\": \"Rahul deo\"\r\n" + 
		         		"}").
		        
		 //Step-3 = We will define which kind of request we are sending along with the resource value in when () block
		         when().
		               post("Library/Addbook.php").
		               
		 //Step -4 = Now we will identify that our api request has been made successfully or not by the use of assertions in then () block.
		                then().assertThat().statusCode(200).
		                extract().response();
		 String ResponseString=res.asString();
         
         System.out.println(ResponseString);
         
         //Getting the added book ID with the heklp of JSONpath
         
     /*We need to convert our response in Json from string format, if we try to pull out result from the string the code does not work 
          *  this is because our system does not know the response is in JSON it will treat it as string*/

         // For converting a string into teh JSON format we need to create object of JsonPath like below.
        
         JsonPath js=new JsonPath(ResponseString);
         String GetBookID=js.getString("ID");
         
         System.out.println(GetBookID);
	}}

		                