package POJO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static io.restassured.RestAssured.given;
import org.openqa.selenium.By;

import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
public class OAuth2Flow {

public static void main(String[] args) throws InterruptedException {
		
		//Step 1 UI Automation invoke the chrome browser
		
       System.setProperty("webdriver.chrome.driver","D:\\Eclipse\\RestApiAutomation\\lib\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php&state=TestMode");
		boolean id=driver.findElement(By.name("identifier")).isEnabled();
		 System.out.println(id);
		
		 driver.findElement(By.name("identifier")).sendKeys("bhartytest");
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.name("password")).sendKeys("test@1234");
		
		 driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
				
	//Step-2 getting the Code
				Thread.sleep(2000);
				String URL=driver.getCurrentUrl();
				System.out.println(URL);
				
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
				/*We will convert our response asClass from string type and create refernce of teh GetCourse class */
						 
						 GetCourse gc=given().contentType("application/json").
									queryParam("access_token",access_token).expect().defaultParser(Parser.JSON)
									.when().
									get("https://rahulshettyacademy.com/getCourse.php").as(GetCourse.class);
						 
						 System.out.println(gc.getInstructor());
						 
						 
		/*We are excepting our Response as in JSON format thats why we are using default parser
		 * if our content type is already defind as JSON tehn we do not need to use that 
		 * in our case our content type is text/HTMl so in this case rest assured get confuses 
		 *  so we will tell rest assured  explicitley by using defualt parser*/
		
		//I have removed guava jar from the build path before that code was not running.
		
		
}}
