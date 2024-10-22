package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Features",
        glue = {"Steps"},
        tags = "@Deposit or @Deposits or @Transaction",
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        publish = true)
public class runner extends AbstractTestNGCucumberTests {
}