package Cucumber;


import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
import serenityTests.BaseClass;

@RunWith(CucumberWithSerenity.class) // mvn clean verify -Dcucumber.options="--tags=@baba" serenity:aggregate
@CucumberOptions(
        tags = "@baba",
        dryRun = false,
        glue = "Cucumber.Steps",
        features = "src\\test\\resources\\features\\",
		plugin = {
				"pretty", "html:target/cucumber-report/single",
				"json:target/cucumber-report/single/cucumber.json",
				"rerun:target/cucumber-report/single/failed_scenarios.txt"
        }
)

public class RunnerOneTest extends BaseClass {
}
