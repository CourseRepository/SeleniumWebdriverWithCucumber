package com.webdriver.page;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = {"src/main/java/com/webdriver/page/BugCreation.feature"},
		glue = {"com.webdriver.page","com.webdriver.generichook"},
		dryRun = false,
		monochrome = true
		)
public class BugCreationRunner extends AbstractTestNGCucumberTests {

}
