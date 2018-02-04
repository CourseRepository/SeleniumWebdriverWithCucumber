package com.webdriver.webelementfunction;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.webdriver.helper.BrowserHelper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WebElementStepDfn {

	private WebDriver driver;
	private BrowserHelper browserHelper;
	private WebElement element;
	private List<WebElement> elementList;

	@Given("^WebElementFunction_I open the face book home page \"([^\"]*)\"$")
	public void webelementfunction_i_open_the_face_book_home_page(String url) throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\rathr1\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		browserHelper = BrowserHelper.getInstance(driver);
		browserHelper.maximize();
		driver.get(url);
	}

	@When("^WebElementFunction_I provide the unique location to findelement api$")
	public void webelementfunction_i_provide_the_unique_location_to_findelement_api() throws Throwable {
		element = driver.findElement(By.id("email"));
	}

	@Then("^WebElementFunction_I should get webelement$")
	public void webelementfunction_i_should_get_webelement() throws Throwable {
		System.out.println(element.toString());
	}

	@When("^WebElementFunction_I provide non unique locator$")
	public void webelementfunction_i_provide_non_unique_locator() throws Throwable {
		elementList = driver.findElements(By.xpath("//input"));
	}

	@Then("^WebElemetFunction_It should return the list of web element$")
	public void webelemetfunction_it_should_return_the_list_of_web_element() throws Throwable {
		System.out.println(elementList.size());
	}
	
	@When("^WebElementFunction_I call the send keys api with value \"([^\"]*)\" it should type in the textbox$")
	public void webelementfunction_i_call_the_send_keys_api_with_value_it_should_type_in_the_textbox(String value) throws Throwable {
		element = driver.findElement(By.cssSelector("#email"));
		element.sendKeys(value);
	}

	@When("^WebElementFunction_I call the get text api it should return the text$")
	public void webelementfunction_i_call_the_get_text_api_it_should_return_the_text() throws Throwable {
	    System.out.println(element.getText());
	}

	@When("^WebElementFunction_I call the clear api it should clear the text box$")
	public void webelementfunction_i_call_the_clear_api_it_should_clear_the_text_box() throws Throwable {
		element.clear();
	}

	@When("^WebElementFunction_I call the quit method the browser will close$")
	public void webelementfunction_i_call_the_quit_method_the_browser_will_close() throws Throwable {
		if (driver != null)
			driver.quit();
	}

}
