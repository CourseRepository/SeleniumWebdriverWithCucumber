package com.webdriver.page;

import org.openqa.selenium.WebDriver;

import com.webdriver.services.DriverServices;
import com.webdriver.utils.TestSettings;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class BugCreationTestProductStepDfn {
	
	private WebDriver driver;
	private DriverServices services;
	private TestSettings testsettings;
	
	public BugCreationTestProductStepDfn(DriverServices services,TestSettings testsettings) {
		this.services = services;
		this.driver = services.getDriver();
		this.testsettings = testsettings;
	}
	
	@Then("^Testproduct_I click on testng link and navigate to bug detail page$")
	public void testproduct_i_click_on_testng_link_and_navigate_to_bug_detail_page() throws Throwable {
		testsettings.detailPage = (DetailPageClass) testsettings.enterBug.clickTestngLink();
	}
	
	
}
