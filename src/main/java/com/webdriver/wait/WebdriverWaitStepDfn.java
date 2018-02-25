package com.webdriver.wait;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	
	@When("^WebdriverWaitFunction_I provide the dynamic wait with polling duration as (\\d+) ms and timeout duration as (\\d+) sec$")
	public void webdriverwaitfunction_i_provide_the_dynamic_wait_with_polling_duration_as_ms_and_timeout_duration_as_sec(int pollingduration, int timeOutInSeconds) throws Throwable {
	    /*
	     * Create the instance of web driver wait class
	     * Provide the polling duration and time out duration
	     * Provide the exception which we want ignore
	     * Call the until method with wait logic
	     * 
	     * */
		
		/*
		 * Already present wait logic
		 * Define your own wait logic
		 * 
		 * */
		driver.manage().timeouts().implicitlyWait(Integer.parseInt("0"), TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.pollingEvery(pollingduration, TimeUnit.MILLISECONDS);
		wait.ignoring(NoSuchElementException.class);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Log In']")));
		//wait.until(ExpectedConditions.urlContains("www.messenger.com"));
		WebElement element = wait.until(customWaitWithParameter(By.xpath("//input[@value='Log In']")));
		System.out.println(element.getText());
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
	
	private Function<WebDriver, Boolean> customWait(){
		Function<WebDriver, Boolean> wait = new Function<WebDriver, Boolean>() {

			@Override
			public Boolean apply(WebDriver t) {
				if( t.findElements(By.xpath("//input[@value='Log In']")).size() >= 1){
					System.err.println("WebElement Located");
					return true;
				}
				System.out.println("Waiting...");
				return false;
			}
		};
		
		return wait;
	}
	
	private Function<WebDriver, WebElement> customWaitOnElement(){
		Function<WebDriver, WebElement> wait = new Function<WebDriver, WebElement>() {

			@Override
			public WebElement apply(WebDriver t) {
				if( t.findElements(By.xpath("//input[@value='Log In']")).size() >= 1){
					System.err.println("WebElement Located");
					return t.findElement(By.xpath("//input[@value='Log In']"));
				}
				System.out.println("Waiting...");
				return null;
			}
		};
		
		return wait;
	}
	
	private Function<WebDriver, WebElement> customWaitWithParameter(By locator){
		Function<WebDriver, WebElement> wait = new Function<WebDriver, WebElement>() {

			@Override
			public WebElement apply(WebDriver t) {
				if( t.findElements(locator).size() >= 1){
					System.err.println("WebElement Located");
					return t.findElement(locator);
				}
				System.out.println("Waiting...");
				return null;
			}
		};
		return wait;
	}
}
