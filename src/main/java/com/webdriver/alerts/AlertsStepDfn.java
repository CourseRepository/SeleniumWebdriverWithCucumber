package com.webdriver.alerts;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webdriver.browser.CustomChromeDriver;
import com.webdriver.helper.BrowserHelper;
import com.webdriver.helper.ButtonHelper;
import com.webdriver.helper.WindowHelper;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AlertsStepDfn {
	
	private WebDriver driver;
	private CustomChromeDriver chromeDriver;
	private BrowserHelper browserHelper;
	private ButtonHelper buttonHelper;
	private WebElement element;
	private WindowHelper windowHelper;
	private ArrayList<String> windowId;

	@Given("^Alerts_I navigate to the webpage \"([^\"]*)\"$")
	public void alerts_i_navigate_to_the_webpage(String page) throws Throwable {
		chromeDriver = new CustomChromeDriver();
		driver = chromeDriver.getChromeDriver();
		browserHelper = BrowserHelper.getInstance(driver);
		buttonHelper = ButtonHelper.getInstance(driver);
		windowHelper = WindowHelper.getInstance(driver);
		driver.get(page);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS); //Page load time out
		browserHelper.maximize();
	}

	@When("^Alerts_I click on try it button , it should show the alert$")
	public void alerts_i_click_on_try_it_button_it_should_show_the_alert() throws Throwable {
	    WebDriverWait wait = getWait(driver, 60);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tryhome")));
	    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("iframeResult")));
	    buttonHelper.click(By.xpath("//button[text()='Try it']"));
	}
	
	@When("^Alerts_I switch to alert and accept the alert$")
	public void alerts_i_switch_to_alert_and_accept_the_alert() throws Throwable {
		WebDriverWait wait = getWait(driver, 60);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	  // Alert alert = driver.switchTo().alert();
	   //alert.accept();
	   alert.dismiss();
	}

	@Then("^Alerts_I switch to default content$")
	public void alerts_i_switch_to_default_content() throws Throwable {
	    driver.switchTo().defaultContent();
	}

	@When("^Alerts_I call the quit method the browser will close$")
	public void alerts_i_call_the_quit_method_the_browser_will_close() throws Throwable {
		 if(driver != null){
		    	driver.quit(); // it will close all the window and stop the web driver
		    }
	}
	
	private WebDriverWait getWait(WebDriver driver,int timeOut){
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.pollingEvery(250, TimeUnit.MILLISECONDS);
		wait.ignoring(NoSuchElementException.class);
		return wait;
	}
}
