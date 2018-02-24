package com.webdriver.wait;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.webdriver.browser.CustomChromeDriver;
import com.webdriver.helper.BrowserHelper;
import com.webdriver.helper.ButtonHelper;
import com.webdriver.helper.TextBoxHelper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WebdriverWaitStepDfn {
	
	private WebDriver driver;
	private ButtonHelper buttonHelper;
	private BrowserHelper browserHelper;
	private TextBoxHelper textboxHelper;
	
	
	@Given("^WebdriverWaitFunction_I open the face book home page \"([^\"]*)\"$")
	public void webdriverwaitfunction_i_open_the_face_book_home_page(String url) throws Throwable {
		CustomChromeDriver chromeDriver = new CustomChromeDriver();
		driver = chromeDriver.getChromeDriver();
		buttonHelper = ButtonHelper.getInstance(driver);
		browserHelper = BrowserHelper.getInstance(driver);
		textboxHelper = TextBoxHelper.getInstance(driver);
		driver.get(url);
		browserHelper.maximize();
	}

	@When("^WebdriverWaitFunction_I wait for \"([^\"]*)\" , it should wait$")
	public void webdriverwaitfunction_i_wait_for_it_should_wait(String delay) throws Throwable {
	   Thread.sleep(Integer.parseInt(delay));
	}
	
	@When("^WebdriverWaitFunction_I set the implicit wait to \"([^\"]*)\" seconds, it should wait for element till (\\d+) sec before throwing exception$")
	public void webdriverwaitfunction_i_set_the_implicit_wait_to_seconds_it_should_wait_for_element_till_sec_before_throwing_exception(String delay, int arg2) throws Throwable {
	    driver.manage().timeouts().implicitlyWait(Integer.parseInt(delay), TimeUnit.SECONDS);
	}

	@Then("^WebdriverWaitFunction_I send the \"([^\"]*)\" to the username text box$")
	public void webdriverwaitfunction_i_send_the_to_the_username_text_box(String arg1) throws Throwable {
	    textboxHelper.setText(By.cssSelector("#email"), arg1);
	}

	@Then("^WebdriverWaitFunction_I click on login button$")
	public void webdriverwaitfunction_i_click_on_login_button() throws Throwable {
	   buttonHelper.click(By.xpath("//input[@value='Log In']"));
	}

	@When("^WebdriverWaitFunction_I call the quit method the browser will close$")
	public void webdriverwaitfunction_i_call_the_quit_method_the_browser_will_close() throws Throwable {
		if (driver != null)
			driver.quit();
	}
	

}
