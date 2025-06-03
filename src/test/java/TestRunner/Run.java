package TestRunner;
import io.cucumber.junit.*;



import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {".//Features/Customers.feature",".//Features/LoginFeature.feature"},
//        features = ".//Features/",
        glue = "StepDefinition",
        dryRun = true,
        monochrome = true,
        tags = "@sanity",
        plugin = {"pretty","html:target/cucumber-reports/report1.html"})

public class Run {
}

