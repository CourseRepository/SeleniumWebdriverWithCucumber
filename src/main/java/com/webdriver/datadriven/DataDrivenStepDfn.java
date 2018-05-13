package com.webdriver.datadriven;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.webdriver.page.BugSummaryPage;
import com.webdriver.page.DetailPageClass;
import com.webdriver.page.EnterBugClass;
import com.webdriver.page.HomePageClass;
import com.webdriver.page.LoginPageClass;
import com.webdriver.services.DriverServices;
import com.webdriver.transform.ExcelDataToDataTable;
import com.webdriver.utils.TestSettings;

import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class DataDrivenStepDfn {
	
	
	private DriverServices services;
	private TestSettings testSettings;
	private WebDriver driver;
	
	public DataDrivenStepDfn(DriverServices services,TestSettings testsettings) {
		this.services = services;
		this.testSettings = testsettings;
		this.driver = services.getDriver();
	}
	
	@Given("^DataDriven_I am at the Bugzilla home page$")
	public void datadriven_i_am_at_the_Bugzilla_home_page() throws Throwable {
		driver.get(services.getReader().getApplicationUrl());
		testSettings.homepage = new HomePageClass(driver);
	}

	@Then("^DataDriven_I click on File a bug link and navigate to login page$")
	public void datadriven_i_click_on_File_a_bug_link_and_navigate_to_login_page() throws Throwable {
		testSettings.loginPage = (LoginPageClass) testSettings.homepage.navigateToLoginPage();
	}

	@Then("^DataDriven_I log into the application and navigate to enter bug page$")
	public void datadriven_i_log_into_the_application_and_navigate_to_enter_bug_page() throws Throwable {
		testSettings.enterBug = (EnterBugClass) testSettings.loginPage.login(services.getReader().getUserName(), services.getReader().getPassword());
	}

	@Then("^DataDriven_I click on testng link and navigate to bug detail page$")
	public void datadriven_i_click_on_testng_link_and_navigate_to_bug_detail_page() throws Throwable {
		testSettings.detailPage = (DetailPageClass) testSettings.enterBug.clickTestngLink();
	}

	@Then("^DataDriven_I provide the following information in the detail page$")
	public void datadriven_i_provide_the_following_information_in_the_detail_page(DataTable table) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		/*
		 * [Key,Value] -> [Component,Logging and results] [Version,6.9.13.3]
		 * 
		 * */
		
		List<Map<String, String>> dataList = table.asMaps(String.class, String.class);
		Map<String, String> dataMap = dataList.get(0);
		testSettings.detailPage.provideDetails(dataMap.get("Component"), dataMap.get("Version"), dataMap.get("Severity"), dataMap.get("Hardware"));
		testSettings.detailPage.provideOtherDetails(dataMap.get("Operating"), dataMap.get("Summary"), dataMap.get("Description"));
	}
	
	@Then("^DataDriven_I provide the following information in the detail page from excel file \"([^\"]*)\"$")
	public void datadriven_i_provide_the_following_information_in_the_detail_page_from_excel_file(@Transform(ExcelDataToDataTable.class)DataTable table) throws Throwable {
		List<Map<String, String>> dataList = table.asMaps(String.class, String.class);
		Map<String, String> dataMap = dataList.get(0);
		testSettings.detailPage.provideDetails(dataMap.get("Component"), dataMap.get("Version"), dataMap.get("Severity"), dataMap.get("Hardware"));
		testSettings.detailPage.provideOtherDetails(dataMap.get("Operating"), dataMap.get("Summary"), dataMap.get("Description"));
	}
	
	@Then("^DataDriven_I provide the details as component as \"([^\"]*)\" version as \"([^\"]*)\" severity as \"([^\"]*)\" hardware as \"([^\"]*)\"$")
	public void datadriven_i_provide_the_details_as_component_as_version_as_severity_as_hardware_as(String component, String version, String severity, String hardware) throws Throwable {
		testSettings.detailPage.provideDetails(component,version, severity, hardware);
	}

	@Then("^DataDriven_I provide other details operating system as \"([^\"]*)\" summary as \"([^\"]*)\" and description as \"([^\"]*)\"$")
	public void datadriven_i_provide_other_details_operating_system_as_summary_as_and_description_as(String operating, String summary, String description) throws Throwable {
		testSettings.detailPage.provideOtherDetails(operating, summary, description);
	}

	@Then("^DataDriven_I title should contain \"([^\"]*)\"$")
	public void datadriven_i_title_should_contain(String subString) throws Throwable {
		Assert.assertTrue(driver.getTitle().contains(subString), "Title Mis Match");
	}
	

	@Then("^DataDriven_I click on submit bug button$")
	public void datadriven_i_click_on_submit_bug_button() throws Throwable {
		testSettings.summarypage = (BugSummaryPage) testSettings.detailPage.clickSubmitBugButton();
	}

	@Then("^DataDriven_I am at the summary page and I click the logout button$")
	public void datadriven_i_am_at_the_summary_page_and_I_click_the_logout_button() throws Throwable {
		testSettings.summarypage.logoutFromApplication();
	}
	
	@Then("^DataDriven_The title should contain \"([^\"]*)\"$")
	public void datadriven_the_title_should_contain(String subString) throws Throwable {
	    Assert.assertTrue(driver.getTitle().contains(subString), "Title Mis Match");
	}

}
