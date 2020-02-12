package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        stepNotifications = true,
        features = "classpath:features",
        glue = "steps.definitions",
        tags = "@all"
)
public class DefaultTestRunner extends AbstractTestRunner {
}
