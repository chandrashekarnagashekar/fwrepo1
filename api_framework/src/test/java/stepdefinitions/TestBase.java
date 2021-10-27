package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

public class TestBase {

	@Before
	public void beforeScenarioMethod() {
		//RestAssured.baseURI="https://api.github.com";
		System.out.println("------- Executing before scenario --------");
	}
	
	@After
	public void genericCfterScenarioMethod() {
		System.out.println("------- Executing After scenario --------");
	}
	
	@After("@smoketest")
	public void dbAfterScenarioMethod() {
		System.out.println("------- Executing After scenario DB Test--------");
	}
	
	@BeforeStep
	public void beforeStep() {
		System.out.println("Executing before step");
	}
	
	@AfterStep
	public void afterStep() {
		System.out.println("Executing after step");
	}
}
