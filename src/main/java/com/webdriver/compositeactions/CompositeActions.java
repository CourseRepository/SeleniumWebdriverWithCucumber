package com.webdriver.compositeactions;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = {"src/main/java/com/webdriver/compositeactions/CompositeActions.feature"},
		glue = {"com.webdriver.compositeactions","com.webdriver.generichook"},
		dryRun = false,
		monochrome = true
		)
public class CompositeActions extends AbstractTestNGCucumberTests {

}
