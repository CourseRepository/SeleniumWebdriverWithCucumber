package com.webdriver.alerts;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webdriver.browser.CustomChromeDriver;
import com.webdriver.helper.AlertHelper;
import com.webdriver.helper.BrowserHelper;
import com.webdriver.helper.ButtonHelper;
import com.webdriver.helper.WindowHelper;

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
	private AlertHelper alertHelper;

	@Given("^Alerts_I navigate to the webpage \"([^\"]*)\"$")
	public void alerts_i_navigate_to_the_webpage(String page) throws Throwable {
		chromeDriver = new CustomChromeDriver();
		driver = chromeDriver.getChromeDriver();
		browserHelper = BrowserHelper.getInstance(driver);
		buttonHelper = ButtonHelper.getInstance(driver);
		windowHelper = WindowHelper.getInstance(driver);
		alertHelper = AlertHelper.getInstance(driver);
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
	
	@Given("^Alerts_I open to the webpage \"([^\"]*)\"$")
	public void alerts_i_open_to_the_webpage(String arg1) throws Throwable {
	    driver.get(arg1);
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
	
	@When("^Alerts_I click on try it button, it should open the confirmation popup$")
	public void alerts_i_click_on_try_it_button_it_should_open_the_confirmation_popup() throws Throwable {
		driver.switchTo().defaultContent();
		 WebDriverWait wait = getWait(driver, 60);
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tryhome")));
		    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("iframeResult")));
		    buttonHelper.click(By.xpath("//button[text()='Try it']"));
	}

	@When("^Alerts_I switch to popup and accept it$")
	public void alerts_i_switch_to_popup_and_accept_it() throws Throwable {
/*	   WebDriverWait wait = getWait(driver, 60);
	   Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	   alert.accept();*/
		alertHelper.acceptAlert();
	}

	@When("^Alerts_I switch to popup and cancel it$")
	public void alerts_i_switch_to_popup_and_cancel_it() throws Throwable {
		/*WebDriverWait wait = getWait(driver, 60);
		   Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		   alert.dismiss();*/
		alertHelper.dismissAlert();
	}
	
	@When("^Alerts_I provide string as \"([^\"]*)\"$")
	public void alerts_i_provide_string_as(String arg1) throws Throwable {
	   /* WebDriverWait wait = getWait(driver, 60);
	    Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	    alert.sendKeys(arg1);*/
		alertHelper.setAlertTest(arg1);
	}

	@When("^Alerts_I get the string of the prompt$")
	public void alerts_i_get_the_string_of_the_prompt() throws Throwable {
		/*WebDriverWait wait = getWait(driver, 60);
	    Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	    System.out.println("Prompt Text : " + alert.getText());*/
		System.out.println("Prompt Text : " + alertHelper.getAlertText());
		
	}
	
	@When("^Alerts_I call the quit method the browser will close$")
	public void alerts_i_call_the_quit_method_the_browser_will_close() throws Throwable {
		 if(driver != null){
		    	driver.quit(); // it will close all the window and stop the web driver
		    }
	}
	
	@When("^Alerts_I click on open modal button$")
	public void alerts_i_click_on_open_modal_button() throws Throwable {
	   buttonHelper.click(By.xpath("//button[text()='Click To Open Modal']"));
	}

	@Then("^Alerts_It should open the bootstrap popup$")
	public void alerts_it_should_open_the_bootstrap_popup() throws Throwable {
	    WebDriverWait wait = getWait(driver, 60);
	   element =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Close']")));
	}

	@Then("^Alerts_I click on the close button to close the popup$")
	public void alerts_i_click_on_the_close_button_to_close_the_popup() throws Throwable {
	    element.click();
	    Actions act = new Actions(driver);
	    act.click().build().perform();
	}
	
	private WebDriverWait getWait(WebDriver driver,int timeOut){
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.pollingEvery(250, TimeUnit.MILLISECONDS);
		wait.ignoring(NoSuchElementException.class);
		return wait;
	}
}
