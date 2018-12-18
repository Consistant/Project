package cucumber.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features={"C:/Users/GOKUL/Documents/DatadrivenUdemy/src/test/java/cucumber/feature"},glue={"C:/Users/GOKUL/Documents/DatadrivenUdemy/src/test/java/cucumber/maven.step"},monochrome=true,format={"html:format"})
public class Runner {


	}


