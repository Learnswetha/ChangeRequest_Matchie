package services;

import static org.hamcrest.Matchers.containsString;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class ChangeRequestTests extends BaseRequest{
	@Test
	public void getchangerequest(){
	  RestAssured.given()
			.get("change_request")
			.then()
			.assertThat()
			.statusCode(200)
			.body(containsString("number"),containsString("sys_id"))
			.extract().response();
				
	}
	
	@Test
	public void createchangerequest(){
		RestAssured.given()	.contentType("application/json").when()	
		.body(new File("./data/changerequest1.json"))
			.post("change_request")
			.then()
			.assertThat()
			.statusCode(201)
			.body(containsString("number"),containsString("sys_id"));		
	}
	
	@Test
	public void updatechangerequest() {
		
		RestAssured.given()	.contentType("application/json").when()	
		.body(new File("./data/changerequest1.json"))
		.put("change_request/c3c80d23977211105be87f5e6253af6d")
		.then()
		.assertThat()
		.statusCode(404);
		
	}

}
