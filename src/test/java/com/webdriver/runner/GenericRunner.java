package com.webdriver.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = {"src/main/java/com/webdriver"},
		glue = {"com.webdriver"},
		dryRun = false,
		monochrome = true,
		plugin = {"pretty","json:target/genericrunner.json"}
		//tags = {"@regression"}
		)
public class GenericRunner extends AbstractTestNGCucumberTests {

}

/**
 * 1. To create a generic method that will navigate to corr page
 * 2. Use Factory design patter to get the instance of corr page after the navigation
 * */
 