package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Features",
        glue = {"Steps"},
        tags = "@Deposit or @Deposits or @Transaction",
        plugin = {"io.qameta.allure.cucumber5junit.AllureCucumber5JUnit"},
        publish = true)
public class runner extends AbstractTestNGCucumberTests {
}