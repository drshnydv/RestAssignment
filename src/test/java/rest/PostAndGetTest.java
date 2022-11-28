package rest;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class PostAndGetTest {
	
	@Test
	public void postAndGetTest() {
		
		JSONObject job = new JSONObject();
		
		job.put("id", 1);
		job.put("petId", 2);
		job.put("quantity", 1);
		job.put("shipDate", "2022-10-18T12:12:19.317Z");
		job.put("status", "placed");
		job.put("complete", true);
		
		baseURI = "https://petstore.swagger.io/v2";
		
		   Response res = given()
			.body(job)
			.contentType(ContentType.JSON)
			
			.when()
			.post("/store/order");
			
			
		   int expId = res.jsonPath().get("id");
		   
		   
			Response res1 = given()
			.pathParam("orderId", 1)
			
			.when()
			.get("/store/order/{orderId}");
			
			int actId = res1.jsonPath().get("id");
			
			String body = res.getBody().asString();
			
			System.out.println(body);
			
			Assert.assertEquals(actId, expId);
			
	}

}
