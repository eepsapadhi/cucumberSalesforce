package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/Salesforce.feature"},
              glue= {"Steps"})


public class TestRunner extends AbstractTestNGCucumberTests{

}
