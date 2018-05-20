package com.webdriver.page;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = {"src/main/java/com/webdriver/page/BugCreation.feature"},
		glue = {"com.webdriver.page","com.webdriver.generichook"},
		dryRun = false,
		monochrome = true,
		plugin = {"pretty","junit:target/junitReport/junitreport.xml"}
		)
public class BugCreationRunner extends AbstractTestNGCucumberTests {

}

/**
 * 1. To create a generic method that will navigate to corr page
 * 2. Use Factory design patter to get the instance of corr page after the navigation
 * */
 