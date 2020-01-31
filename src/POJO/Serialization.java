package POJO;
import static io.restassured.RestAssured.given;
public class Serialization {
	
	/* In POJO class all the variable will be declared private and all the method would be declared Public */
	
/* Suppose that our request bosy is like this 
 *   { "greet": "Hi",
 *     "name" : "Deepaik",
 *     "comment" : "Hi How are You"}
 *   for the above JSON payload we will create our POJO class like below manner   */
	
	private String greet;
	private String name;
	private String comment;
	
	public String getGreet() {
		return greet;
	}
	public void setGreet(String greet) {
		this.greet = greet;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	//Creating JAVA Object
	Serialization s= new Serialization();
	
	public static void main(String[] args) {
		Serialization s= new Serialization();
		s.setGreet("Hi");
		s.setName("Deepak");
		s.setComment("Hi How are You");
		
//Rest Assured Part
		
		given().
		        body(s).
		         when().
		          post("/message");

		
	/*After performing the post request we will get our Response Code
	 * This Whole Process is known as serialization */
		
	}

}
