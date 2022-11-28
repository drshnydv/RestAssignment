package rest;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostAndAssert {
	
	@Test
	public void postAssertion() {
		
		//asserting for sucess status code 200
		JSONObject job = new JSONObject();
		
		job.put("id", 1);
		job.put("username", "drshn");
		job.put("firstName", "darshan");
		job.put("lastName", "yadav");
		job.put("email", "darshan@gmail.com");
		job.put("password", "1234");
		job.put("phone", "9876543210");
		job.put("userStatus", 1);
		
		baseURI = "https://petstore.swagger.io/v2";
		
		given()
		.body(job)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/user")
		
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
		
	}

}
