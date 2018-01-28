package com.webdriver.helper;

import org.openqa.selenium.WebDriver;

public class BrowserHelper {
	
	private static BrowserHelper browserHelper;
	private static WebDriver webDriver;
	
	private BrowserHelper(WebDriver driver){
		webDriver = driver;
	}
	
	public static BrowserHelper getInstance(WebDriver driver){
		if(browserHelper == null || webDriver.hashCode() != driver.hashCode())
			browserHelper = new BrowserHelper(driver);
		return browserHelper;
	}
	
	// Sigleton Design patter
	
	/**
	* The cons should be private - so no other class can create the object of this class
	* To get the instance use the getInstance method
	*/
	
	
	public void moveForward(){
		webDriver.navigate().forward();
	}
	
	public void moveBackword(){
		webDriver.navigate().back();
	}
	
	public void refresh(){
		webDriver.navigate().refresh();
	}
	
	public void maximize(){
		webDriver.manage().window().maximize();
	}

}
