package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber-report.json"},
        strict = true,
        stepNotifications = true,
        features = "classpath:features",
        glue = "steps.definitions",
        tags = "@all"
)
public class DefaultTestRunner extends AbstractTestRunner {
}
