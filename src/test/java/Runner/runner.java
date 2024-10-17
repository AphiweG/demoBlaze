package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Features",
        glue = {"Steps"},
        tags = "",
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        publish = true)
public class runner extends AbstractTestNGCucumberTests {
}