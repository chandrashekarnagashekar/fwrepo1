package stepdefinitions;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.CreateRepositoryPojo;
import pojo.CreateRepositoryResponsePojo;
import utils.PojoHelper;

public class StepDefinition {
	RequestSpecification requestSpecification;
	Response response;				
	
	@Given("Header {string} has value {string}")
	public void header_has_value(String key, String value) {			
	    System.out.println("Executing Given");
	    requestSpecification = RestAssured.given().header(key, value);	    	    
	}
	@And("Request payload has values {string} and {string}")
	public void request_payload_has_values_and(String string, String string2) {
		CreateRepositoryPojo jsonPayload= PojoHelper.getCreateGithubRepoPojo(string, string2);
		requestSpecification.body(jsonPayload);
	}
	@And("Query parameter {string} has value {string}")
	public void query_param_has_value(String key, String value) {
		requestSpecification.queryParam(key, value);
	}
	@And("Query parameter {string} has value {int}")
	public void query_param_has_value(String key, int value) {
		requestSpecification.queryParam(key, value);
	}
	@When("{string} request is executed")
	public void request_is_executed(String httpMethod) {
	    System.out.println("Executing When");
	    switch(httpMethod) {
	    	case "GET":
	    		response = requestSpecification.when().log().all().get("orgs/orgchandra/repos");
	    		break;
	    		
	    	case "POST":
	    		response = requestSpecification.when().log().all().post("orgs/orgchandra/repos");
	    }	    
	    
	}
	@Then("Verify status code is {int}")
	public void verify_status_code_is(Integer statusCodeVal) {
	    System.out.println("Executing Then");
	    //ExtentCucumberAdapter.addTestStepLog(response.getHeaders().toString());
	    //ExtentCucumberAdapter.addTestStepLog(response.body().asPrettyString());
	    response.then()	//Prints the response headers, and response body
		.assertThat()
		.statusCode(statusCodeVal);
	}
	
	@Then("Verify body contains {string} as {string} and {string} as {string}")
	public void verify_body_contains_as_and_as(String key1, String value1, String key2, String value2) {		
		
		//RestAssured
		response.then().body(key1, Matchers.equalTo(value1));
		
		//jsonpath
		JsonPath pth = response.then().extract().body().jsonPath();
		String nameVal = pth.getString(key1);
		MatcherAssert.assertThat(value1, Matchers.equalTo(nameVal));
		
		//Pojo
		CreateRepositoryResponsePojo responseObj = response.then().extract().body().as(CreateRepositoryResponsePojo.class);
		MatcherAssert.assertThat(value1, Matchers.equalTo(responseObj.getName()));
		MatcherAssert.assertThat(value2, Matchers.equalTo(responseObj.getDescription()));
		
	}
	
}
