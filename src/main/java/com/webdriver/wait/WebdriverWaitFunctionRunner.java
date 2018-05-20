package com.webdriver.wait;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = {"src/main/java/com/webdriver/wait/WebdriverWaitFunction.feature"},
		glue = {"com.webdriver.wait"},
		dryRun = false,
		monochrome = true,
		plugin = {"pretty"}
		)
public class WebdriverWaitFunctionRunner extends AbstractTestNGCucumberTests {

}
