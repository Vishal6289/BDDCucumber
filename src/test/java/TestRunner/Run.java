package TestRunner;
import io.cucumber.junit.*;



import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".//Features/LoginFeature.feature",
        glue = "StepDefinition",dryRun = false,monochrome = true, plugin = {"pretty"})
public class Run {
}

