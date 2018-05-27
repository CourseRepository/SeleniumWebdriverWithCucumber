package com.webdriver.runner;

import com.webdriver.customrunner.CustomAbstractTestNGCucumberTestsWithTag;

import cucumber.api.CucumberOptions;

@CucumberOptions(
		features = {"src/main/java/com/webdriver"},
		glue = {"com.webdriver"},
		dryRun = false,
		monochrome = true,
				plugin = {"pretty","json:target/customgenericrunnerwithtag.json"}
		)
public class CustomGenericRunnerWithTag extends CustomAbstractTestNGCucumberTestsWithTag {

}

/**
 * 1. To create a generic method that will navigate to corr page
 * 2. Use Factory design patter to get the instance of corr page after the navigation
 * */
 