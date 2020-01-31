package OAuth2Demo;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
public class GetCoursesList {

	public static void main(String[] args) {
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		
		String res=given().
		queryParam("access_token", "ya29.ImC7B5wvdBfWSDKv8XF6Q7Oj1Wzu0hiqt4Hqs7nEZQDsJGYjIEa_1zw2hj_EXWmEyL_MYtQoGba6GE4g6b_YDUrzWRww5_KYT586EbXvevyloWfCBSqDNgMlgft0KaA3zzY")
		.when().
		get("/getCourse.php").asString();
		
		/* if we want to extract the response but we dont want to use assertions in our code that means we want to skip then() and extract.
		 * then we have sort cut way to get the response. In this we will extract the response in string method and we have to define that raw data as in string format.
		 * that means we need to create a string variable with the given block to store the response.*/
		
		System.out.println(res);
		
		
String URL="https://rahulshettyacademy.com/getCourse.php?state=TestMode&code=4%2FvwHogWuoh5lFGNGiQyvFdLIAs4_CUTmYOPvMKtUDmrO9OajKBQVwZpCd_Iyw7KptPbPjERAxMco6w_MKw0GMRHU&scope=email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&authuser=0&prompt=none&session_state=b97429982ad41bdbe0fe170192750e8c9689ef1c..256a#";
		
		String PartialCode=URL.split("code=")[1];
		String Code=PartialCode.split("&scope")[0];
		System.out.println(Code);
	}
}
