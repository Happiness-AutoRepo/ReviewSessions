package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		dryRun=true,
		features="src/test/resources/features/",
		glue = "stepdefs",
		tags= "@csvReportDataValidation"
		)
public class CukesRunner extends AbstractTestNGCucumberTests {
			
}
