package com.webdriver.alerts;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = {"src/main/java/com/webdriver/alerts/Alerts.feature"},
		glue = {"com.webdriver.alerts"},
		dryRun = false,
		monochrome = true
		)
public class AlertsRunner extends AbstractTestNGCucumberTests {

}
