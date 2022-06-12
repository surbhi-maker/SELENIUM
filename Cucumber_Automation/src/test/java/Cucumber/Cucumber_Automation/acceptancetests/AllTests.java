package Cucumber.Cucumber_Automation.acceptancetests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"Cucumber.Cucumber_Automation"},
        features = ".",
        format = {"pretty", "json:target/cucumber-reports/cucumber.json"},
        tags = {"@complete"}
)
public class AllTests {
}