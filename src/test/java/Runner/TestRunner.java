package Runner;

import org.junit.runner.RunWith;

import io.cucumber.core.backend.Glue;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//monochrome--> removes unnecessary characters from console
//dryRun--> verifies each step in feature file have corresponding step definition defined
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/Features",glue= {"StepDefinitions"},
tags = "@functionalTests",
dryRun =true,
monochrome=true,
plugin={"html:target/CucumberReport.html","rerun:target/failed.txt"})
public class TestRunner {

	
}

