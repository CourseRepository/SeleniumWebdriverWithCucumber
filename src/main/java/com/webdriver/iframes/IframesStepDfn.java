package com.webdriver.iframes;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.picocontainer.converters.NewInstanceConverter;

import com.webdriver.browser.CustomChromeDriver;
import com.webdriver.helper.BrowserHelper;
import com.webdriver.helper.ButtonHelper;
import com.webdriver.helper.TextBoxHelper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class IframesStepDfn {
	
	private WebDriver driver;
	private CustomChromeDriver chromeDriver;
	private BrowserHelper browserHelper;
	private ButtonHelper buttonHelper;
	private WebElement element;
	
	@Given("^IFrame_I navigate to the webpage \"([^\"]*)\"$")
	public void iframe_i_navigate_to_the_webpage(String page) throws Throwable {
		chromeDriver = new CustomChromeDriver();
		driver = chromeDriver.getChromeDriver();
		browserHelper = BrowserHelper.getInstance(driver);
		buttonHelper = ButtonHelper.getInstance(driver);
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

	
	
	@When("^IFrame_I call the quit method the browser will close$")
	public void iframe_i_call_the_quit_method_the_browser_will_close() throws Throwable {
	    if(driver != null){
	    	driver.quit();
	    }
	}
	
	private WebDriverWait getWait(WebDriver driver,int timeOut){
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.pollingEvery(250, TimeUnit.MILLISECONDS);
		wait.ignoring(NoSuchElementException.class);
		return wait;
	}
	
}
