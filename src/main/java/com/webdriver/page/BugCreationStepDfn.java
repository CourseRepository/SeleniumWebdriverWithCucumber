package com.webdriver.page;

import org.openqa.selenium.WebDriver;

import com.webdriver.services.DriverServices;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class BugCreationStepDfn {
	
	private WebDriver driver;
	private DriverServices services;
	private HomePageClass homepage;
	private LoginPageClass loginPage;
	private EnterBugClass enterBug;
	private DetailPageClass detailPage;
	
	public BugCreationStepDfn(DriverServices services) {
		this.services = services;
		this.driver = services.getDriver();
	}
	
	
	@Given("^Bugzilla_I am at the Bugzilla home page$")
	public void bugzilla_i_am_at_the_Bugzilla_home_page() throws Throwable {
		driver.get(services.getReader().getApplicationUrl());
		homepage = new HomePageClass(driver);
	}

	@Then("^Bugzilla_I click on File a bug link and navigate to login page$")
	public void bugzilla_i_click_on_File_a_bug_link_and_navigate_to_login_page() throws Throwable {
		loginPage = homepage.navigateToLoginPage();
	}

	@Then("^Bugzilla_I log into the application and navigate to enter bug page$")
	public void bugzilla_i_log_into_the_application_and_navigate_to_enter_bug_page() throws Throwable {
		enterBug = loginPage.login(services.getReader().getUserName(), services.getReader().getPassword());
	}

	@Then("^Bugzilla_I click on testng link and navigate to bug detail page$")
	public void bugzilla_i_click_on_testng_link_and_navigate_to_bug_detail_page() throws Throwable {
		detailPage = enterBug.clickTestngLink();
	}

	@Then("^Bugzilla_I provide the details as component as \"([^\"]*)\" version as \"([^\"]*)\" severity as \"([^\"]*)\" hardware as \"([^\"]*)\"$")
	public void bugzilla_i_provide_the_details_as_component_as_version_as_severity_as_hardware_as(String comp, String ver, String sever, String hard) throws Throwable {
		detailPage.provideDetails(comp, ver, sever, hard);
	}

	@Then("^Bugzilla_I provide other details operating system as \"([^\"]*)\" summary as \"([^\"]*)\" and description as \"([^\"]*)\"$")
	public void bugzilla_i_provide_other_details_operating_system_as_summary_as_and_description_as(String operatingsys, String shortSummary, String comment) throws Throwable {
		detailPage.provideOtherDetails(operatingsys, shortSummary, comment);
	}

	@Then("^Bugzilla_I click on submit bug button$")
	public void bugzilla_i_click_on_submit_bug_button() throws Throwable {
		detailPage.clickSubmitBugButton();
	}
	
}
