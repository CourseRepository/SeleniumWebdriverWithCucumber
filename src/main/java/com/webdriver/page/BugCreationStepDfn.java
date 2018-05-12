package com.webdriver.page;

import org.openqa.selenium.WebDriver;
import static org.testng.Assert.*;

import com.webdriver.page.factory.PageName;
import com.webdriver.services.DriverServices;
import com.webdriver.utils.TestSettings;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class BugCreationStepDfn {
	
	private WebDriver driver;
	private DriverServices services;
	private HomePageClass homepage;
	private LoginPageClass loginPage;
	private EnterBugClass enterBug;
	private DetailPageClass detailPage;
	private BugSummaryPage summarypage;
	private TestSettings testSettings;
	
	public BugCreationStepDfn(DriverServices services,TestSettings testSettings) {
		this.services = services;
		this.driver = services.getDriver();
		this.testSettings = testSettings;
	}
	
	
	@Given("^Bugzilla_I am at the Bugzilla home page$")
	public void bugzilla_i_am_at_the_Bugzilla_home_page() throws Throwable {
		driver.get(services.getReader().getApplicationUrl());
		testSettings.homepage = new HomePageClass(driver);
		testSettings.data = "From 1st Step dfn Class";
	}
	

	@Then("^Bugzilla_I click on File a bug link and navigate to login page$")
	public void bugzilla_i_click_on_File_a_bug_link_and_navigate_to_login_page() throws Throwable {
		testSettings.loginPage = (LoginPageClass) testSettings.homepage.navigateToLoginPage();
	}
	
	@Then("^Bugzilla_The title of login page should be \"([^\"]*)\"$")
	public void bugzilla_the_title_of_login_page_should_be(String expected) throws Throwable {
		//Assert.assertEquals(driver.getTitle(), expected + "asd");
	/*	int i = 0;
		
		try {
			if(i == 0)
				fail("Failed By User");
		} catch (AssertionError e) {
			System.out.println("Condition was failed But test continued");
		}*/
		fail("To Take the Screen Shot");
		
	}
	

	@Then("^Bugzilla_I log into the application and navigate to enter bug page$")
	public void bugzilla_i_log_into_the_application_and_navigate_to_enter_bug_page() throws Throwable {
		testSettings.enterBug = (EnterBugClass) testSettings.loginPage.login(services.getReader().getUserName(), services.getReader().getPassword());
	}

	@Then("^Bugzilla_I click on testng link and navigate to bug detail page$")
	public void bugzilla_i_click_on_testng_link_and_navigate_to_bug_detail_page() throws Throwable {
		testSettings.detailPage = (DetailPageClass) testSettings.enterBug.clickTestngLink();
	}

	@Then("^Bugzilla_I provide the details as component as \"([^\"]*)\" version as \"([^\"]*)\" severity as \"([^\"]*)\" hardware as \"([^\"]*)\"$")
	public void bugzilla_i_provide_the_details_as_component_as_version_as_severity_as_hardware_as(String comp, String ver, String sever, String hard) throws Throwable {
		testSettings.detailPage.provideDetails(comp, ver, sever, hard);
	}

	@Then("^Bugzilla_I provide other details operating system as \"([^\"]*)\" summary as \"([^\"]*)\" and description as \"([^\"]*)\"$")
	public void bugzilla_i_provide_other_details_operating_system_as_summary_as_and_description_as(String operatingsys, String shortSummary, String comment) throws Throwable {
		testSettings.detailPage.provideOtherDetails(operatingsys, shortSummary, comment);
	}

	@Then("^Bugzilla_I click on submit bug button$")
	public void bugzilla_i_click_on_submit_bug_button() throws Throwable {
		testSettings.summarypage = (BugSummaryPage) testSettings.detailPage.clickSubmitBugButton();
	}
	
	@Then("^Bugzilla_I am at the summary page and I click the logout button$")
	public void bugzilla_i_am_at_the_summary_page_and_I_click_the_logout_button() throws Throwable {
		testSettings.summarypage.logoutFromApplication();
	}
	
	@Then("^Bugzilla_I navigate to Home page$")
	public void bugzilla_i_navigate_to_Home_page() throws Throwable {
		testSettings.enterBug.home.click();
		testSettings.homepage = (HomePageClass) testSettings.enterBug.navigateTo(PageName.HomePage, driver, testSettings.enterBug.home);
	   
	}

	@Then("^Bugzilla_I navigate to enter bug page$")
	public void bugzilla_i_navigate_to_enter_bug_page() throws Throwable {
	    testSettings.homepage.newLink.click();
	    testSettings.enterBug = (EnterBugClass) testSettings.homepage.navigateTo(PageName.EnterBugPage, driver, testSettings.homepage.newLink);
	}
}
