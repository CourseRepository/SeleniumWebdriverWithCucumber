package com.webdriver.generichook;

import org.openqa.selenium.WebDriver;

import com.webdriver.services.DriverServices;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class GeneralHook {
	
	private DriverServices services;
	private WebDriver driver;
	
	public GeneralHook(DriverServices services) {
		this.services = services;
		this.driver = services.getDriver();
	}
	
	@Before
	public void setup() {
		
	}
	
	@After
	public void teardown() {
		if(driver != null){
	    	driver.quit(); // it will close all the window and stop the web driver
	    }
		
	}

}
