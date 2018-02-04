package com.webdriver.browserfunction;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = {"src/main/java/com/webdriver/browserfunction/BrowserFunction.feature"},
		glue = {"com.webdriver.browserfunction"},
		dryRun = false,
		monochrome = true
		)
public class BrowserFunctionRunner extends AbstractTestNGCucumberTests {

}
