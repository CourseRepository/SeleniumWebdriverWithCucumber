package com.webdriver.webelementfunction;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.webdriver.browser.CustomChromeDriver;
import com.webdriver.helper.BrowserHelper;
import com.webdriver.helper.ButtonHelper;
import com.webdriver.helper.DropdownHelper;
import com.webdriver.helper.TextBoxHelper;
import com.webdriver.services.DriverServices;
import com.webdriver.utils.IReader;
import com.webdriver.utils.ReadConfigProperties;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WebElementStepDfn {

	private WebDriver driver;
	private DriverServices services;
	private IReader readConfigFile;
	//private BrowserHelper browserHelper;
	private WebElement element;
	private List<WebElement> elementList;
	/*private TextBoxHelper textBoxHelper;
	private ButtonHelper buttonHelper;
	private DropdownHelper dropDownHelper;*/
	
	
	public WebElementStepDfn(DriverServices services) {
		this.services = services;
		this.driver = services.getDriver();
		this.readConfigFile = services.getReader();
	}
	

	@Given("^WebElementFunction_I open the face book home page \"([^\"]*)\"$")
	public void webelementfunction_i_open_the_face_book_home_page(String url) throws Throwable {
		//CustomChromeDriver chromeDriver = new CustomChromeDriver();
		//driver = chromeDriver.getChromeDriver();
		
		/*CustomFirefoxDriver firefoxDriver = new CustomFirefoxDriver();
		driver = firefoxDriver.getFirefoxDriver();*/
		
		//browserHelper = BrowserHelper.getInstance(driver);
		//textBoxHelper = TextBoxHelper.getInstance(driver);
		//buttonHelper = ButtonHelper.getInstance(driver);
		//dropDownHelper = DropdownHelper.getInstance(driver);
		//browserHelper.maximize();
		driver.get(url);
		//driver.get(readConfigFile.getApplicationUrl());
		
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
		/*element = driver.findElement(By.cssSelector("#email"));
		element.sendKeys(value);*/
		//textBoxHelper.setText(By.cssSelector("#email"), value);
		services.getTextBoxHelper().setText(By.cssSelector("#email"), value);
	}

	@When("^WebElementFunction_I call the get text api it should return the text$")
	public void webelementfunction_i_call_the_get_text_api_it_should_return_the_text() throws Throwable {
	    //System.out.println(element.getText());
		//System.out.println(textBoxHelper.getText(By.cssSelector("#email")));
		System.out.println(services.getTextBoxHelper().getText(By.cssSelector("#email")));
	}

	@When("^WebElementFunction_I call the clear api it should clear the text box$")
	public void webelementfunction_i_call_the_clear_api_it_should_clear_the_text_box() throws Throwable {
		//element.clear();
		//textBoxHelper.clear(By.cssSelector("#email"));
		services.getTextBoxHelper().clear(By.cssSelector("#email"));
	}
	
	@When("^WebElementFunction_I the click method on button it should perform the click action on button$")
	public void webelementfunction_i_the_click_method_on_button_it_should_perform_the_click_action_on_button() throws Throwable {
		/*element = driver.findElement(By.cssSelector("[data-testid='royal_login_button']"));
		element.click();*/
		/*buttonHelper.click(By.cssSelector("[data-testid='royal_login_button']"));
		browserHelper.moveBackword();*/
		services.getButtonHelper().click(By.cssSelector("[data-testid='royal_login_button']"));
		services.getBrowserHelper().moveBackword();
	}
	
	@When("^WebElementFunction_I call the click method on radio button it should select the radio button$")
	public void webelementfunction_i_call_the_click_method_on_radio_button_it_should_select_the_radio_button() throws Throwable {
		/*element = driver.findElement(By.xpath("//label[text()='Male']/preceding-sibling::input"));
		element.click();*/
		//buttonHelper.click(By.xpath("//label[text()='Male']/preceding-sibling::input"));
		services.getButtonHelper().click(By.xpath("//label[text()='Male']/preceding-sibling::input"));
	}

	@When("^WebElementFunction_I call the click method on hyper link it shoulc click on the hyper link$")
	public void webelementfunction_i_call_the_click_method_on_hyper_link_it_shoulc_click_on_the_hyper_link() throws Throwable {
		/*element = driver.findElement(By.linkText("Create a Page"));
		element.click();*/
		/*buttonHelper.click(By.linkText("Create a Page"));
		browserHelper.moveBackword();*/
		services.getButtonHelper().click(By.linkText("Create a Page"));
		services.getBrowserHelper().moveBackword();
		
	}
	

	@When("^WebElementFunction_I call select by visible text on dropdown it should select the value based on ui$")
	public void webelementfunction_i_call_select_by_visible_text_on_dropdown_it_should_select_the_value_based_on_ui() throws Throwable {
		/*element = driver.findElement(By.cssSelector("#month"));
		Select select = new Select(element);
		select.selectByVisibleText("Nov");*/
		//dropDownHelper.selectByVisibleText(By.cssSelector("#month"), "Nov");
		services.getDropDownHelper().selectByVisibleText(By.cssSelector("#month"), "Nov");
	}
	
	@When("^WebElementFunction_I call select by index text on dropdown it should select the value based on index$")
	public void webelementfunction_i_call_select_by_index_text_on_dropdown_it_should_select_the_value_based_on_index() throws Throwable {
		/*element = driver.findElement(By.cssSelector("#month"));
		Select select = new Select(element);
		select.selectByIndex(2); // Selection based on index
		 */
		//dropDownHelper.selectByIndex(By.cssSelector("#month"), 2);
		services.getDropDownHelper().selectByIndex(By.cssSelector("#month"), 2);
		}
	
	@When("^WebElementFunction_I call select by value text on dropdown it should select the value based on value attribute in drop down$")
	public void webelementfunction_i_call_select_by_value_text_on_dropdown_it_should_select_the_value_based_on_value_attribute_in_drop_down() throws Throwable {
		/*element = driver.findElement(By.cssSelector("#month"));
		Select select = new Select(element);
		select.selectByValue("0");*/ // Selection based in value attribute
		//dropDownHelper.selectByValue(By.cssSelector("#month"), "0");
		services.getDropDownHelper().selectByValue(By.cssSelector("#month"), "0");
	}
	
	@When("^WebElementFunction_I call getOptions on dropdown it should list all the vlaue in dropdown$")
	public void webelementfunction_i_call_getOptions_on_dropdown_it_should_list_all_the_vlaue_in_dropdown() throws Throwable {
		/*element = driver.findElement(By.cssSelector("#month"));
		Select select = new Select(element);*/
		//elementList = dropDownHelper.getAllValues(By.cssSelector("#month"));
		elementList = services.getDropDownHelper().getAllValues(By.cssSelector("#month"));
		System.out.println(elementList.size());
		for(WebElement ele : elementList)
			System.out.println(ele.getText());
	}
		
	@When("^WebElementFunction_I call the quit method the browser will close$")
	public void webelementfunction_i_call_the_quit_method_the_browser_will_close() throws Throwable {
		/*if (driver != null)
			driver.quit();*/
	}

}
