package com.webdriver.webelementfunction;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = {"src/main/java/com/webdriver/webelementfunction/WebelementFunction.feature"},
		glue = {"com.webdriver.webelementfunction","com.webdriver.generichook"},
		dryRun = false,
		monochrome = true
		)
public class WebelementFunctionRunner extends AbstractTestNGCucumberTests {

}
