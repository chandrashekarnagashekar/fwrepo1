package runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import io.restassured.RestAssured;
import utils.PropertiesHelper;
//dry run is used to skip the step definition execution
//tags = used for controlling the scenario to be executed

@RunWith(Cucumber.class)
@CucumberOptions(
			features = "src/test/resources/features",	
			glue = {"stepdefinitions"},
			plugin = {"pretty", "html:target/report/htmlreport.html",
					"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
					"pretty", "summary"
					},
			monochrome = true,			
			dryRun = false,
			snippets = SnippetType.CAMELCASE
		)
public class TestRunner {

	@BeforeClass
	public static void beforeClassMethod() {	
		String envVal = PropertiesHelper.getGlobalProperty("global","env");
		String baseUrl = PropertiesHelper.getGlobalProperty(envVal,"baseUrl");
		RestAssured.baseURI=baseUrl;
		System.out.println("------------- Calling before class ----------- ");
	}
	
	@AfterClass
	public static void afterClassMethod() {
		System.out.println("------------- Calling after class ----------- ");
	}
		
}
