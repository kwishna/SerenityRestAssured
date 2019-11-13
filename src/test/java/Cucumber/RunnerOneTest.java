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
        features = "src\\test\\resources\\features\\"
)

public class RunnerOneTest extends BaseClass {
}
