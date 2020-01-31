package OAuth2Demo;

import static io.restassured.RestAssured.given;
public class CreateAccessToken {
	
	public static void main(String[] args) {
		
	/* we have create teh Authorization code first by manually hitting the URL which has been constructed using different params
	 * after that the same code will be used and exchnged to get the access token */
		
	 //RestAssured.baseURI="https://www.googleapis.com";
	 String Res=given().
			 log().all().
	 queryParams("code","4%2FvwHogWuoh5lFGNGiQyvFdLIAs4_CUTmYOPvMKtUDmrO9OajKBQVwZpCd_Iyw7KptPbPjERAxMco6w_MKw0GMRHU").
	 queryParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com").
	 queryParams("client_secret","erZOWM9g3UtwNRj340YYaK_W").
	 queryParams("redirect_uri","https://rahulshettyacademy.com/getCourse.php").
	 queryParams("grant_type","authorization_code").
	 
	 when().
	 
	 post("https://www.googleapis.com/oauth2/v4/token").asString();
	 
	 System.out.println(Res);
	 
	 //This Code Throw error at the run Time
		
		
	}

}
