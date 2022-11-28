package rest;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class GetAndAssert {
	
	@Test
	public void getLogoutTest() {
		
		baseURI = "https://petstore.swagger.io/v2";
		
		//according to the swagger doc userName given is 'user1' but i'm giving wrong userName
		//So I have to get status code as 404
		given()
		.pathParam("userName", "user2")
		
		.when()
		.get("/user/{userName}")
		
		.then()
		.statusCode(404)
		.log().all();
		
	}

}