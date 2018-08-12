package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions (
		dryRun = false,
		features = "src/test/resources/features/",
		glue = "stepdefs",
		tags = "@Etsy"
		)
public class EtsyRunner extends AbstractTestNGCucumberTests {

}
