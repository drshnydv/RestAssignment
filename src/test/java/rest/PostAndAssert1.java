package rest;

import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostAndAssert1 {
	
	@Test
	public void postWrongAndAssertion() {
		
		File file = new File("./Data/Pets.json");
		
		baseURI = "https://petstore.swagger.io/v2";
		
		//according to swagger document here we have to get status code as '405 invalid input' but getting 200 ok
		given()
		.body(file)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/pet")
		
		.then()
		.assertThat()
		.statusCode(405)
		.log().all();
		
	}

}