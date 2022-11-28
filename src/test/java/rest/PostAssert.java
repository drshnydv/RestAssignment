package rest;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostAssert {
	
	@Test
	public void postWrongAndAssertion() {
		
		JSONObject job = new JSONObject();
		
		job.put("id", 1);
		job.put("username", "drshn");
		job.put("firstName", "darshan");
		job.put("lastName", "yadav");
		
		baseURI = "https://petstore.swagger.io/v2";
		
		//according to swagger document here we have to get status code as '405 invalid input' but getting 200 ok
		given()
		.body(job)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/pet")
		
		.then()
		.assertThat()
		.statusCode(405)
		.log().all();
		
	}

}
