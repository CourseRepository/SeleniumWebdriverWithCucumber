package com.webdriver.iframes;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

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
import gherkin.lexer.Th;

public class IframesStepDfn {
	
	private WebDriver driver;
	private CustomChromeDriver chromeDriver;
	private BrowserHelper browserHelper;
	private ButtonHelper buttonHelper;
	private WebElement element;
	private WindowHelper windowHelper;
	private ArrayList<String> windowId;
	
	@Given("^IFrame_I navigate to the webpage \"([^\"]*)\"$")
	public void iframe_i_navigate_to_the_webpage(String page) throws Throwable {
		chromeDriver = new CustomChromeDriver();
		driver = chromeDriver.getChromeDriver();
		browserHelper = BrowserHelper.getInstance(driver);
		buttonHelper = ButtonHelper.getInstance(driver);
		windowHelper = WindowHelper.getInstance(driver);
		driver.get(page);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS); //Page load time out
		browserHelper.maximize();
	}

	@When("^IFrame_I perform the click on the element presetn in iframe, then it should click$")
	public void iframe_i_perform_the_click_on_the_element_presetn_in_iframe_then_it_should_click() throws Throwable {
		WebDriverWait wait = getWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tryhome")));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("iframeResult")));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("[src='https://www.w3schools.com']")));
		
		//driver.switchTo().frame("iframeResult"); // 1st iframe
		//element = driver.findElement(By.cssSelector("[src='https://www.w3schools.com']"));
		//driver.switchTo().frame(element); //2nd iframe
	   buttonHelper.click(By.cssSelector("[title='Search W3Schools']"));
	}
	
	@When("^IFrame_I perform the click action on the home button$")
	public void iframe_i_perform_the_click_action_on_the_home_button() throws Throwable {
		driver.switchTo().defaultContent(); // switch to parent DOM -> doc Obj model
	    buttonHelper.click(By.id("tryhome"));
	}
	
	@Given("^MultipleWindow_I open the web page \"([^\"]*)\"$")
	public void multiplewindow_i_open_the_web_page(String arg1) throws Throwable {
	    driver.get(arg1);
	    WebDriverWait wait = getWait(driver, 60);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#main .w3-example:nth-child(13) [target]")));
	}

	@Then("^MultipleWindow_I click on button and it will open the child browser window$")
	public void multiplewindow_i_click_on_button_and_it_will_open_the_child_browser_window() throws Throwable {
		buttonHelper.click(By.cssSelector("#main .w3-example:nth-child(13) [target]"));
		WebDriverWait wait = getWait(driver, 60);
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		/*try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// Ignore
		}*/
		/*windowId = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(windowId.get(1));*/
		windowHelper.switchToWindow(1);
	}

	@Then("^MultipleWindow_I switch to child browser window and click on home button$")
	public void multiplewindow_i_switch_to_child_browser_window_and_click_on_home_button() throws Throwable {
		WebDriverWait wait = getWait(driver, 60);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tryhome")));
	    buttonHelper.click(By.id("tryhome"));
	    wait.until(ExpectedConditions.numberOfWindowsToBe(3));
	    /*windowId = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(windowId.get(2));*/
	    windowHelper.switchToWindow(2);
	}
	
	@Then("^MultipleWindow_I click on the element present in parent window$")
	public void multiplewindow_i_click_on_the_element_present_in_parent_window() throws Throwable {
		/*driver.switchTo().window(windowId.get(0));*/
		windowHelper.switchToParent();
		buttonHelper.click(By.cssSelector("#main .w3-example:nth-child(13) [target]"));
		/*driver.switchTo().window(windowId.get(2));*/
		windowHelper.switchToWindow(2);
	}

	
	@When("^IFrame_I call the quit method the browser will close$")
	public void iframe_i_call_the_quit_method_the_browser_will_close() throws Throwable {
	    if(driver != null){
	    	windowHelper.switchToParentWithClose();
	    	driver.quit(); // it will close all the window and stop the web driver
	    	//driver.close(); //it will close the window, currently pointed by driver instance
	    }
	}
	
	private WebDriverWait getWait(WebDriver driver,int timeOut){
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.pollingEvery(250, TimeUnit.MILLISECONDS);
		wait.ignoring(NoSuchElementException.class);
		return wait;
	}
	
}
