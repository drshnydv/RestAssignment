package rest;

import org.json.simple.JSONObject;
import org.openqa.selenium.json.Json;
import org.openxmlformats.schemas.drawingml.x2006.main.ThemeDocument;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class AssertionTest {
	
	@Test
	public void postAssertion() {
		
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
	
	@Test
	public void getTest() {
		
		baseURI = "https://petstore.swagger.io/v2";
		
		given()
		.pathParam("orderId", 5)
		
		.when()
		.get("/store/order/{orderId}")
		
		.then()
		.statusCode(200)
		.log().all();
		
	}
	
	@Test
	public void getLogoutTest() {
		
		baseURI = "https://petstore.swagger.io/v2";
		
		//here userName given is 'user1' but i'm giving wrong userName So I have to get status code as 404
		given()
		.pathParam("userName", "user2")
		
		.when()
		.get("/user/{userName}")
		
		.then()
		.statusCode(404)
		.log().all();
	}
	
	@Test
	public void postWrongAndAssertion() {
		
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