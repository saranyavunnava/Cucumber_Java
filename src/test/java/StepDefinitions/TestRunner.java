package StepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.core.backend.Glue;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/Features",glue= {"StepDefinitions"},
tags = "@functionalTests",
monochrome=true,
plugin={"html:target/CucumberReport.html","rerun:target/failed.txt"})
public class TestRunner {

	
}

