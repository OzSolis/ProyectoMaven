package testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/Features",
		glue = {"stepDefinitions"},
		tags = {"not @ignore"}
		)

public class FirstRunner extends AbstractTestNGCucumberTests{

}
