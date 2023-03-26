package steps;

import java.io.File;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

public class ChangerequestManagement extends Common{
	@Given("Set the endpoint")
	public  void SetEndpoint() {
		RestAssured.baseURI="https://dev116510.service-now.com/api/now/table/";
	}
	
	@And("Set the Auth")
	public void setAuth() {
		RestAssured.authentication=RestAssured.basic("admin", "Ngpe$1UnA9=A");
	}
	
	@When("get Change Request")
	public void get_change_request() {
		
		inputRequest = RestAssured.given();
		response = inputRequest.get("change_request");
	}
	
	@Then("validate response code as {int}")
	public void validateResponse(int responseCode) {
		
		response.then().assertThat().statusCode(responseCode);
		//response.prettyPrint();
	}
	
	@When("create change request with String body {string}")
	public void create_change_request_with_string_body(String body) {
	
		inputRequest = RestAssured.given().contentType("application/json").body(body);
		response = inputRequest.post("change_request");
		//response.prettyPrint();
	}
	
	@When("get changerequest with queryparam {string} and {string}")
	public void getchangerequestQP(String key, String value) {
		
		inputRequest = RestAssured.given().queryParam(key, value);
		response = inputRequest.get("change_request");
	}
	
	@When("create changerequest with file {string}")
	public void createchangerequestFile(String fileName) {
		
		File file =new File ("./data/"+fileName);
		inputRequest = RestAssured.given().contentType("application/json").body(file);
		response = inputRequest.post("change_request");
		
		
	}	

	
	

}
