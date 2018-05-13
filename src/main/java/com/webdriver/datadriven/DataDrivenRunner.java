package com.webdriver.datadriven;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = {"src/main/java/com/webdriver/datadriven/DataDriven.feature"},
		glue = {"com.webdriver.datadriven","com.webdriver.generichook"},
		dryRun = false,
		monochrome = true
		)
public class DataDrivenRunner extends AbstractTestNGCucumberTests {

}
