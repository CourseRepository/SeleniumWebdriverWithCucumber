package com.webdriver.page;

import org.openqa.selenium.WebDriver;

import com.webdriver.services.DriverServices;
import com.webdriver.utils.TestSettings;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class BugCreationTestProductStepDfnTwo {
	
	private WebDriver driver;
	private DriverServices services;
	private TestSettings testsettings;
	
	public BugCreationTestProductStepDfnTwo(DriverServices services,TestSettings testsettings) {
		this.services = services;
		this.driver = services.getDriver();
		this.testsettings = testsettings;
	}
	
	/*
	 * We need a class that will be accessed by step dfn file
	 * The class will have variable which need to be shared across file
	 * 
	 * */
	
	@Then("^Testproduct_I provide the details as component as \"([^\"]*)\" version as \"([^\"]*)\" severity as \"([^\"]*)\" hardware as \"([^\"]*)\"$")
	public void testproduct_i_provide_the_details_as_component_as_version_as_severity_as_hardware_as(String comp, String ver, String sever, String hard) throws Throwable {
		testsettings.detailPage.provideDetails(comp, ver, sever, hard);
	}

	@Then("^Testproduct_I provide other details operating system as \"([^\"]*)\" summary as \"([^\"]*)\" and description as \"([^\"]*)\"$")
	public void testproduct_i_provide_other_details_operating_system_as_summary_as_and_description_as(String operatingsys, String shortSummary, String comment) throws Throwable {
		testsettings.detailPage.provideOtherDetails(operatingsys, shortSummary, comment);
	}

	@Then("^Testproduct_I click on submit bug button$")
	public void testproduct_i_click_on_submit_bug_button() throws Throwable {
		testsettings.summarypage = (BugSummaryPage) testsettings.detailPage.clickSubmitBugButton();
	}

	@Then("^Testproduct_I am at the summary page and I click the logout button$")
	public void testproduct_i_am_at_the_summary_page_and_I_click_the_logout_button() throws Throwable {
		testsettings.summarypage.logoutFromApplication();
		System.out.println("===============> " + testsettings.data);
	}
	
	
}
