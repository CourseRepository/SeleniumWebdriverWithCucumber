package com.webdriver.iframes;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = {"src/main/java/com/webdriver/iframes/Iframes.feature"},
		glue = {"com.webdriver.iframes"},
		dryRun = false,
		monochrome = true
		)
public class IframesRunner extends AbstractTestNGCucumberTests {

}
