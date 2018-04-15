package com.webdriver.compositeactions;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

public class CompositeActionsDfn {
	
	private WebDriver driver;
	private CustomChromeDriver chromeDriver;
	private BrowserHelper browserHelper;
	private ButtonHelper buttonHelper;
	private WebElement element;
	private WindowHelper windowHelper;
	private ArrayList<String> windowId;
	private AlertHelper alertHelper;
	private Actions actions;
	private Action action;
	
	@Given("^Actions_I navigate to the webpage \"([^\"]*)\"$")
	public void actions_i_navigate_to_the_webpage(String page) throws Throwable {
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

	@When("^Actions_I create the composite action for context click$")
	public void actions_i_create_the_composite_action_for_context_click() throws Throwable {
	    // Create the composite action
		actions = new Actions(driver);
		actions = actions.contextClick(driver.findElement(By.id("droptarget")));
	}

	@Then("^Actions_I build the action$")
	public void actions_i_build_the_action() throws Throwable {
	   // Build the actions by using build method
		action = actions.build();
	}

	@Then("^Actions_I perfomr the action$")
	public void actions_i_perfomr_the_action() throws Throwable {
	    // Perform the action by calling perform method
		action.perform();
	}
	
	@When("^Actions_I create the composite action for drang and drop$")
	public void actions_i_create_the_composite_action_for_drang_and_drop() throws Throwable {
	    actions = new Actions(driver);
	    WebElement source = driver.findElement(By.id("draggable"));
	    WebElement target = driver.findElement(By.id("droptarget"));
	    actions.dragAndDrop(source, target);
	}
	
	@When("^Actions_I create the composite action for click and hold$")
	public void actions_i_create_the_composite_action_for_click_and_hold() throws Throwable {
		actions = new Actions(driver);
	    WebElement source = driver.findElement(By.id("draggable"));
	    actions.clickAndHold(source);
	}
	
	@When("^Actions_I create the composite action for keyboard$")
	public void actions_i_create_the_composite_action_for_keyboard() throws Throwable {
	    actions = new Actions(driver);
	    WebElement element = driver.findElement(By.id("example-search"));
	    actions = actions.keyDown(element,Keys.LEFT_SHIFT) // Simulate the pressing of Left shift key
	    .sendKeys(element,"sele" ,Keys.SPACE, "nium") // Type the string 
	    .keyUp(element,Keys.LEFT_SHIFT); // Simulate the releasing of shift key
	}



	@When("^Actions_I call the quit method the browser will close$")
	public void actions_i_call_the_quit_method_the_browser_will_close() throws Throwable {
		 if(driver != null){
		    	driver.quit(); // it will close all the window and stop the web driver
		    }
	}
	
}
