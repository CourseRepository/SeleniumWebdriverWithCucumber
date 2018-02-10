package com.webdriver.browserfunction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.webdriver.helper.BrowserHelper;
import com.webdriver.helper.TextBoxHelper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BrowserFunctionStepDfn {
	
	private WebDriver driver;
	private WebDriver.Navigation navigate;
	private BrowserHelper browserHelper;
	
	
	@Given("^BrowserFunction_I have chrome driver instance$")
	public void browserfunction_i_have_chrome_driver_instance() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rathr1\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		browserHelper = BrowserHelper.getInstance(driver);
		
	}
	
	@Given("^BrowserFucntion_I call the get with url \"([^\"]*)\" then it should open the page$")
	public void browserfucntion_i_call_the_get_with_url_then_it_should_open_the_page(String url) throws Throwable {
		driver.get(url);
		browserHelper = BrowserHelper.getInstance(driver);
	}
	
	@Then("^BrowserFunction_I call the back api this should navigate back in the browser$")
	public void browserfunction_i_call_the_back_api_this_should_navigate_back_in_the_browser() throws Throwable {
	  /* navigate = driver.navigate();
	   navigate.back();*/
		browserHelper.moveBackword();
	}

	@Then("^BrowserFunction_I call the forward api this should move forward in the browser$")
	public void browserfunction_i_call_the_forward_api_this_should_move_forward_in_the_browser() throws Throwable {
	   // navigate.forward();
		browserHelper.moveForward();
	}

	@Then("^BrowserFunction_I call the refresh api this should refresh the webpage$")
	public void browserfunction_i_call_the_refresh_api_this_should_refresh_the_webpage() throws Throwable {
	  // navigate.refresh();
		browserHelper.refresh();
	}
	
	@When("^BrowserFunction_I call the maximize metho$")
	public void browserfunction_i_call_the_maximize_metho() throws Throwable {
		/*WebDriver.Options option = driver.manage();
		WebDriver.Window window = option.window();
		window.maximize();*/
		//driver.manage().window().maximize();
		browserHelper.maximize();
	}

	
	
	@When("^BrowserFucnton_I call the quit method the browser will close$")
	public void browserfucnton_i_call_the_quit_method_the_browser_will_close() throws Throwable {
		if(driver != null)
			driver.quit();
	}

}
