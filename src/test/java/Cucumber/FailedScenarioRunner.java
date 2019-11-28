package Cucumber;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features = {"@target/cucumber-report/single/failed_scenarios.txt"}, // Error If @ Is Not Mentioned!
		// Complete Path Of failed_scenario.txt File
		monochrome = true,
		plugin = {
				"pretty", "html:target/cucumber-report/single",
				"json:target/cucumber-report/single/rerun_cucumber.json"
		},
		glue = "Cucumber.Steps"
)
public class FailedScenarioRunner{
}
